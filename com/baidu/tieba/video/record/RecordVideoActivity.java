package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.localvideo.b;
import com.baidu.tieba.video.record.GLVideoPreviewView;
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import com.baidu.tieba.video.record.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private ImageView dFH;
    private int dlZ;
    private final CustomMessageListener dnE;
    private String gLp;
    private SelectMusicModel gLt;
    private b.a gOK;
    private i gQh;
    protected h gQq;
    private RecordLayout gRR;
    private VideoControllerLayout gRS;
    private RelativeLayout gRT;
    private ImageView gRU;
    private ImageView gRV;
    private ImageView gRW;
    private com.baidu.tbadk.core.dialog.a gRX;
    private PreviewViewContainer gRY;
    private TextView gRZ;
    private b gRa;
    private VideoEffectButtonLayout gSa;
    private TextView gSb;
    private View gSc;
    private RoundProgressBar gSd;
    private TextView gSe;
    private AnimatorSet gSf;
    private AnimatorSet gSg;
    private ScaleAnimation gSh;
    private ObjectAnimator gSi;
    private ObjectAnimator gSj;
    private int gSk;
    private ForumWriteData gSl;
    private boolean gSm;
    private boolean gSn = true;
    private l gSo;
    private StickerItem gSp;
    protected j gSq;
    private RecordTabLayout gSr;
    private ImageFileInfo gSs;
    private HttpMessageListener gSt;
    private boolean gSu;
    private com.baidu.tieba.j.h gxw;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxw = kVar.aSb();
        }
        if (this.gxw != null) {
            this.gxw.aRI();
        }
        this.gOK = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dB(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.w(list)) {
                    if (RecordVideoActivity.this.gRS != null) {
                        RecordVideoActivity.this.gRS.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.gRS != null) {
                    RecordVideoActivity.this.gRS.setHasLocalVideo(true);
                    RecordVideoActivity.this.gSn = false;
                }
            }
        };
        this.gSt = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                List<StickerItem> list;
                if (httpResponsedMessage instanceof ResponseGetStickersMessage) {
                    ResponseGetStickersMessage responseGetStickersMessage = (ResponseGetStickersMessage) httpResponsedMessage;
                    if (httpResponsedMessage.getError() != 0) {
                        list = null;
                    } else {
                        list = responseGetStickersMessage.getStickerItems();
                    }
                    if (RecordVideoActivity.this.gRS != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.gRS.setStickerItems(list);
                    }
                }
            }
        };
        this.dnE = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gQq.gLv);
        videoInfo.setVideoDuration(this.gQh.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gQq.gLv).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.gSl.writeCallFrom, this.gSl == null ? "" : this.gSl.forumName, this.gSl == null ? "" : this.gSl.forumId, this.gLp, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.gSq != null) {
            this.gSq.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gxw != null) {
            this.gxw.aRL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQh != null && this.gQh.isRecording()) {
            this.gQh.stopRecord();
        }
        if (this.gLt != null) {
            this.gLt.cancelLoadData();
        }
        if (this.gxw != null) {
            this.gxw.pH("record");
        }
        com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gJJ));
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        TiebaStatic.log("c12293");
        this.mContext = getPageContext().getPageActivity();
        setIsAddSwipeBackLayout(false);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        super.onCreate(bundle);
        setContentView(d.i.record_activity);
        this.gSk = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.gSl = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gLp = getIntent().getStringExtra("video_title");
        initUI();
        this.gLt = new SelectMusicModel(getPageContext(), this.gRS);
        this.gLt.bwT();
        this.gSq = new j(this);
        this.gSq.b(this.gLt);
        this.gQh.a(this.gSq);
        byG();
        registerListener(this.gSt);
        registerListener(this.dnE);
    }

    private void byG() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bxw() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gOK);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gRR = (RecordLayout) findViewById(d.g.root_layout);
        this.gRR.setListener(this);
        this.gQh = new i(this);
        this.gRS = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gRS.setRecordController(this.gQh);
        this.gRS.setRecordControlListener(this);
        this.gRS.setEffectChoosedListener(this);
        this.gRT = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dFH = (ImageView) findViewById(d.g.close_page);
        this.dFH.setOnClickListener(this);
        this.gRU = (ImageView) findViewById(d.g.flash_switch);
        this.gRU.setOnClickListener(this);
        this.gRV = (ImageView) findViewById(d.g.camera_switch);
        this.gRV.setOnClickListener(this);
        this.gRW = (ImageView) findViewById(d.g.count_down);
        this.gRW.setOnClickListener(this);
        this.gRY = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.gQq = new h(this);
        this.gQq.a(this);
        this.gQq.setFaceIdentifyStateListener(this);
        this.gQq.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void byr() {
                if (RecordVideoActivity.this.gRS.bzf()) {
                    RecordVideoActivity.this.gRS.a((m) null);
                }
            }
        });
        this.gSa = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gSa.setListener(this);
        this.gQh.a(this.gSa);
        this.gSa.setViewChoosed(2, true);
        this.gRZ = (TextView) findViewById(d.g.tv_count_down);
        this.gSb = (TextView) findViewById(d.g.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds150);
        if (this.gRZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gRZ.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gSa.setVisibility(8);
        }
        this.gSc = findViewById(d.g.progress_layout);
        this.gSd = (RoundProgressBar) this.gSc.findViewById(d.g.video_progress);
        this.gSe = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSe.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds38);
        this.gSe.setLayoutParams(layoutParams);
        this.gSr = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.gSr.ar(1, getString(d.k.tab_photo));
        if (this.gSk != 2 && this.gSk != 3) {
            this.gSr.ar(2, getString(d.k.tab_record));
            this.gSr.setListener(this);
            this.gSr.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.gSr.setShowIndicator(false);
            this.gSr.setCurrentTab(1, false);
            G(1, false);
        }
        byH();
    }

    private void byH() {
        if (UtilHelper.isOppoConcaveScreen()) {
            if (this.gRT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gRT.getLayoutParams()).topMargin = 80;
            }
            ProgressView progressView = (ProgressView) findViewById(d.g.video_progress_view);
            if (progressView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) progressView.getLayoutParams()).topMargin = 80;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gQq.onResume();
        this.gRa = this.gQq.byi();
        if (this.gRa != null) {
            this.gRa.setRecordController(this.gQh);
            this.gRY.setZoomHelper(this.gRa);
        }
        byI();
        if (this.gSo == null) {
            this.gSo = new l();
            this.gSo.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ci(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gSp, str2);
                    if (RecordVideoActivity.this.gRS != null) {
                        RecordVideoActivity.this.gRS.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void tL(String str) {
                    if (RecordVideoActivity.this.gRS != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gRS.b(stickerItem);
                        if (RecordVideoActivity.this.gQq != null) {
                            RecordVideoActivity.this.gQq.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gRS != null) {
                        RecordVideoActivity.this.gRS.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.k.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(d.k.sticker_download_error);
                    }
                    recordVideoActivity.ac(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bwb() {
                    if (RecordVideoActivity.this.gRS != null) {
                        RecordVideoActivity.this.gRS.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gSo.byZ();
        if (this.gRS != null && this.gSn) {
            bxw();
        }
        if (this.gxw != null) {
            this.gxw.pG("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gQq.onPause();
        if (this.gRS != null) {
            if (this.gQh != null && this.gQh.getStatus() == 6) {
                this.gRS.stopRecord();
                byR();
            }
            if (this.gQh != null && this.gQh.isRecording()) {
                this.gRS.stopRecord();
            }
        }
        if (this.gSq != null) {
            this.gSq.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gQh == null || this.gQh.getStatus() != 7) {
            if (this.gQh != null && this.gQh.getStatus() == 6) {
                if (this.gRS != null) {
                    this.gRS.stopRecord();
                }
                byR();
            } else if (this.gQh.onBackPressed()) {
                finish();
            } else {
                if (this.gRX == null) {
                    this.gRX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gRX.ca(d.k.video_quit_confirm);
                    this.gRX.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gRX.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gRX.ar(true);
                    this.gRX.b(getPageContext());
                }
                this.gRX.tD();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        this.gSe.setVisibility(4);
        if (view2 == this.dFH) {
            onBackPressed();
        } else if (view2 == this.gRU) {
            if (this.gQh.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gQq.byl();
            byI();
        } else if (view2 == this.gRV) {
            if (this.gQh.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gRV.setOnClickListener(null);
            this.gQq.byn();
            if (this.gQq.byo() && this.gQq.bym()) {
                this.gQq.byl();
            }
            byI();
            this.gRV.setOnClickListener(this);
        } else if (view2 == this.gRW) {
            byK();
        }
    }

    private void byI() {
        if (this.gQq.byo()) {
            this.gRU.setVisibility(8);
        } else {
            this.gRU.setVisibility(0);
        }
        if (this.gQq.bym()) {
            this.gRU.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.gRU.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout byJ() {
        return this.gRY;
    }

    public void byK() {
        this.gSe.setVisibility(4);
        if (this.gQh.getStatus() != 6) {
            this.gQh.setStatus(6);
            byP();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gSh == null) {
                this.gSh = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gSh.setDuration(500L);
                this.gSh.setRepeatCount(5);
                this.gSh.setRepeatMode(2);
                this.gSh.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gSh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gQh.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gRZ.setVisibility(0);
                        RecordVideoActivity.this.gRZ.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gRZ.setVisibility(8);
                    if (RecordVideoActivity.this.gQh.getStatus() == 6) {
                        RecordVideoActivity.this.gRS.bzc();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gQh.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gRZ.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gRZ.setText("");
                        }
                    }
                }
            });
            this.gRZ.setAnimation(this.gSh);
            this.gSh.startNow();
            this.gRS.byK();
            if (this.gSq != null) {
                this.gSq.byE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        if (this.gQh.getStatus() == 1) {
            this.gSe.setVisibility(4);
            if (this.gQh.getStatus() != 6) {
                this.gRS.byL();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        this.gSe.setVisibility(4);
        if (this.gQh.getStatus() != 6) {
            this.gRS.byM();
            if (this.gRS.bzg()) {
                byG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byN() {
        this.gSe.setVisibility(4);
        if (this.gQh.getStatus() != 6) {
            this.gRS.byN();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byO() {
        this.gSe.setVisibility(4);
        if (this.gQh.getStatus() != 6) {
            this.gRS.byO();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byP() {
        this.gSm = true;
        if (this.gSg != null && this.gSg.isRunning()) {
            this.gSg.cancel();
        }
        if (this.gSf == null) {
            this.gSf = new AnimatorSet();
            this.gSf.playTogether(ObjectAnimator.ofFloat(this.gRT, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gSa, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gSr, "alpha", 1.0f, 0.0f));
            this.gSf.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTU) {
                        RecordVideoActivity.this.gRT.setVisibility(8);
                        RecordVideoActivity.this.gSa.setVisibility(8);
                        RecordVideoActivity.this.gSr.setVisibility(8);
                    }
                }
            });
            this.gSf.setDuration(300L);
        }
        this.gSf.start();
        this.gSa.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byE() {
        if (this.dlZ == 2) {
            if (this.gSm) {
                this.gSm = false;
                if (this.gSq != null) {
                    this.gSq.byE();
                }
            } else {
                return;
            }
        }
        if (this.gSf != null && this.gSf.isRunning()) {
            this.gSf.cancel();
        }
        if (this.gSg == null) {
            this.gSg = new AnimatorSet();
            this.gSg.playTogether(ObjectAnimator.ofFloat(this.gRT, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gSa, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gSr, "alpha", 0.0f, 1.0f));
            this.gSg.setDuration(300L);
        }
        this.gRT.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.gSa.setVisibility(0);
        }
        if (this.gQh.getStatus() == 1) {
            this.gSr.setVisibility(0);
        }
        this.gSg.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byQ() {
        if (this.gQq != null) {
            this.gQq.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void p(boolean z, String str) {
                    RecordVideoActivity.this.gQh.setStatus(1);
                    RecordVideoActivity.this.byE();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.gSs != null && !v.w(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.gSs)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.gSs);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.gSs = new ImageFileInfo();
                        RecordVideoActivity.this.gSs.setFilePath(str);
                        RecordVideoActivity.this.gSs.setTempFile(true);
                        RecordVideoActivity.this.gSs.setAlbumnId(null);
                        RecordVideoActivity.this.gSs.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.gSs);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.gSl, RecordVideoActivity.this.gSk)));
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, RecordVideoActivity.this.mWriteImagesInfo.toJsonString());
                        RecordVideoActivity.this.setResult(-1, intent);
                        RecordVideoActivity.this.finish();
                        ActivityPendingTransitionFactory.closeAnimation(RecordVideoActivity.this.getPageContext(), 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byR() {
        this.gSh.cancel();
        this.gSh.setAnimationListener(null);
        this.gRZ.clearAnimation();
        this.gRZ.setVisibility(8);
        if (this.gSq != null) {
            this.gSq.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byS() {
        bpt();
    }

    private void bpt() {
        if (this.gSi != null) {
            this.gSi.cancel();
        }
        if (this.gSj == null) {
            this.gSj = ObjectAnimator.ofFloat(this.gSr, "alpha", 1.0f, 0.0f);
            this.gSj.setDuration(500L);
            this.gSj.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTU) {
                        RecordVideoActivity.this.gSr.setVisibility(8);
                    }
                }
            });
        }
        this.gSj.start();
    }

    private void bps() {
        if (this.gSj != null) {
            this.gSj.cancel();
        }
        if (this.gSi == null) {
            this.gSi = ObjectAnimator.ofFloat(this.gSr, "alpha", 0.0f, 1.0f);
            this.gSi.setDuration(500L);
        }
        this.gSr.setVisibility(0);
        this.gSi.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byT() {
        this.gSa.reset();
        if (this.gQh.getStatus() == 1) {
            bps();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byU() {
        if (this.gSc.getVisibility() != 0) {
            this.gRS.bzb();
            this.gQh.setStatus(8);
            byE();
            if (this.gQq.gQY != null && this.gQq.gQY.size() > 0) {
                this.gSc.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int gSw = 50;
        final int gSx = 1;
        Handler gSy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gSd.av(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.byY();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void byY() {
            this.gSy.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            byY();
            boolean z = RecordVideoActivity.this.gSq == null || TextUtils.isEmpty(RecordVideoActivity.this.gSq.byD()) || !new File(RecordVideoActivity.this.gSq.byD()).exists();
            if (RecordVideoActivity.this.gQq.gQY.size() > 1) {
                return com.baidu.tieba.video.meida.h.bxP().b(RecordVideoActivity.this.gQq.gQY, RecordVideoActivity.this.gQq.byf(), z);
            }
            File file = new File(RecordVideoActivity.this.gQq.gQY.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.gQq.byf()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bxP().b(RecordVideoActivity.this.gQq.gQY, RecordVideoActivity.this.gQq.byf(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.gRS.bzh();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.byF();
                    RecordVideoActivity.this.uA(102);
                    RecordVideoActivity.this.gSc.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.byF();
                RecordVideoActivity.this.uA(102);
                RecordVideoActivity.this.gSc.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.k.mix_fail));
                RecordVideoActivity.this.gSc.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ac(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.gSd.av(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gRS == null || v.w(this.gRS.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.gRS.getChoosedBeautyList()) {
            if (eVar != null) {
                String name = eVar.getName();
                if (!TextUtils.isEmpty(name)) {
                    if (name.equals("Normal")) {
                        name = "0";
                    }
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedFilterList() {
        ArrayList arrayList = new ArrayList();
        if (this.gRS == null || v.w(this.gRS.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.gRS.getChoosedFilterList()) {
            if (eVar != null) {
                String str = (String) eVar.getValue();
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedStickerList() {
        ArrayList arrayList = new ArrayList();
        if (this.gRS == null || v.w(this.gRS.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gRS.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byV() {
        this.gSe.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byW() {
        this.gSe.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byX() {
        if (this.gQh.getStatus() == 1) {
            this.gSr.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.gQq != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gQq.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new al("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.gSa.setViewChoosed(2, false);
                            return;
                        } else {
                            this.gSa.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.gQq.setFilter((String) eVar.getValue());
                        al alVar = new al("c12496");
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.gQh.getStatus() == 1) {
                            alVar.r("obj_type", 1);
                        } else {
                            alVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.gSa.setViewChoosed(3, false);
                            return;
                        } else {
                            this.gSa.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.gSq.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.gSa.setViewChoosed(0, false);
                            return;
                        } else {
                            this.gSa.setViewChoosed(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.gSp = stickerItem;
            this.gSo.ul(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gQq != null) {
                    this.gQq.setSticker(null);
                    this.gSu = false;
                }
                if (this.gRS != null) {
                    this.gRS.setDownLoadSticker(null);
                }
                this.gSb.setVisibility(8);
                this.gSa.setViewChoosed(1, false);
                return;
            }
            String uj = this.gSo.uj(stickerItem.resource);
            if (!StringUtils.isNull(uj)) {
                a(stickerItem, uj);
                if (this.gRS != null) {
                    this.gRS.setDownLoadSticker(null);
                }
            } else {
                if (this.gRS != null) {
                    this.gRS.setDownLoadSticker(stickerItem);
                }
                this.gSo.uk(stickerItem.resource);
            }
            this.gSa.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gQq != null) {
                this.gQq.setSticker(stickerItem);
                this.gSu = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gSb.setText(stickerItem.desc);
                this.gSb.setVisibility(0);
                this.gSb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gSb.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gSb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bR(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.q(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gRS.getLayoutParams();
            layoutParams.height = i4;
            this.gRS.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tU = com.baidu.tieba.video.editvideo.model.a.bwN().tU(stringExtra);
                if (this.gSq != null && !TextUtils.isEmpty(tU)) {
                    this.gSq.cj(tU, stringExtra2);
                    this.gRS.bxU();
                }
            }
        } else if (i == 12012 && i2 == -1) {
            Intent intent2 = new Intent();
            if (intent != null) {
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT));
                if (!StringUtils.isNull(intent.getStringExtra("file_name"))) {
                    intent2.putExtra("file_name", intent.getStringExtra("file_name"));
                }
            }
            setResult(-1, intent2);
            finish();
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.gQh.getStatus() == 8) {
            this.gRS.bza();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void mY(boolean z) {
        if (this.gQh != null && (this.gQh.getStatus() == 1 || this.gQh.getStatus() == 3 || this.gQh.getStatus() == 4)) {
            if (!z && this.gSu) {
                this.gRY.bys();
                return;
            } else {
                this.gRY.byt();
                return;
            }
        }
        this.gRY.byt();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dlZ != i) {
            switch (i) {
                case 1:
                    if (this.gSq != null) {
                        this.gSq.bgx();
                    }
                    this.gQq.setFilter("nature");
                    this.gSa.setViewChoosed(0, false);
                    this.gSa.setViewChoosed(3, false);
                    this.gRS.uC(1);
                    this.gSa.setViewVisibility(0, 8);
                    this.gSa.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.gSa.setViewVisibility(0, 0);
                    this.gSa.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dlZ = i;
            this.gRS.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new al().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void byC() {
        if (this.gQh.getStatus() == 1 && !this.gRS.bzf()) {
            G(1, true);
            this.gSr.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void byB() {
        if (this.gQh.getStatus() == 1 && !this.gRS.bzf()) {
            G(2, true);
            this.gSr.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(int i) {
        if (this.gxw != null) {
            this.gxw.ad(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
        if (this.gxw != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gxw.ac(i, str);
        }
    }
}
