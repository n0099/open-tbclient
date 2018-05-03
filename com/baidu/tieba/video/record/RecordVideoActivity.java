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
    private ImageView dFE;
    private int dlW;
    private final CustomMessageListener dnB;
    private String gLm;
    private SelectMusicModel gLq;
    private b.a gOH;
    private b gQX;
    private i gQe;
    protected h gQn;
    private RecordLayout gRO;
    private VideoControllerLayout gRP;
    private RelativeLayout gRQ;
    private ImageView gRR;
    private ImageView gRS;
    private ImageView gRT;
    private com.baidu.tbadk.core.dialog.a gRU;
    private PreviewViewContainer gRV;
    private TextView gRW;
    private VideoEffectButtonLayout gRX;
    private TextView gRY;
    private View gRZ;
    private RoundProgressBar gSa;
    private TextView gSb;
    private AnimatorSet gSc;
    private AnimatorSet gSd;
    private ScaleAnimation gSe;
    private ObjectAnimator gSf;
    private ObjectAnimator gSg;
    private int gSh;
    private ForumWriteData gSi;
    private boolean gSj;
    private boolean gSk = true;
    private l gSl;
    private StickerItem gSm;
    protected j gSn;
    private RecordTabLayout gSo;
    private ImageFileInfo gSp;
    private HttpMessageListener gSq;
    private boolean gSr;
    private com.baidu.tieba.j.h gxt;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gxt = kVar.aSb();
        }
        if (this.gxt != null) {
            this.gxt.aRI();
        }
        this.gOH = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dB(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.w(list)) {
                    if (RecordVideoActivity.this.gRP != null) {
                        RecordVideoActivity.this.gRP.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.gRP != null) {
                    RecordVideoActivity.this.gRP.setHasLocalVideo(true);
                    RecordVideoActivity.this.gSk = false;
                }
            }
        };
        this.gSq = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.gRP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.gRP.setStickerItems(list);
                    }
                }
            }
        };
        this.dnB = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
        videoInfo.setVideoPath(this.gQn.gLs);
        videoInfo.setVideoDuration(this.gQe.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gQn.gLs).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.gSi.writeCallFrom, this.gSi == null ? "" : this.gSi.forumName, this.gSi == null ? "" : this.gSi.forumId, this.gLm, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.gSn != null) {
            this.gSn.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gxt != null) {
            this.gxt.aRL();
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
        if (this.gQe != null && this.gQe.isRecording()) {
            this.gQe.stopRecord();
        }
        if (this.gLq != null) {
            this.gLq.cancelLoadData();
        }
        if (this.gxt != null) {
            this.gxt.pH("record");
        }
        com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gJG));
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
        this.gSh = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.gSi = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gLm = getIntent().getStringExtra("video_title");
        initUI();
        this.gLq = new SelectMusicModel(getPageContext(), this.gRP);
        this.gLq.bwT();
        this.gSn = new j(this);
        this.gSn.b(this.gLq);
        this.gQe.a(this.gSn);
        byG();
        registerListener(this.gSq);
        registerListener(this.dnB);
    }

    private void byG() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bxw() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gOH);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gRO = (RecordLayout) findViewById(d.g.root_layout);
        this.gRO.setListener(this);
        this.gQe = new i(this);
        this.gRP = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gRP.setRecordController(this.gQe);
        this.gRP.setRecordControlListener(this);
        this.gRP.setEffectChoosedListener(this);
        this.gRQ = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dFE = (ImageView) findViewById(d.g.close_page);
        this.dFE.setOnClickListener(this);
        this.gRR = (ImageView) findViewById(d.g.flash_switch);
        this.gRR.setOnClickListener(this);
        this.gRS = (ImageView) findViewById(d.g.camera_switch);
        this.gRS.setOnClickListener(this);
        this.gRT = (ImageView) findViewById(d.g.count_down);
        this.gRT.setOnClickListener(this);
        this.gRV = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.gQn = new h(this);
        this.gQn.a(this);
        this.gQn.setFaceIdentifyStateListener(this);
        this.gQn.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void byr() {
                if (RecordVideoActivity.this.gRP.bzf()) {
                    RecordVideoActivity.this.gRP.a((m) null);
                }
            }
        });
        this.gRX = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gRX.setListener(this);
        this.gQe.a(this.gRX);
        this.gRX.setViewChoosed(2, true);
        this.gRW = (TextView) findViewById(d.g.tv_count_down);
        this.gRY = (TextView) findViewById(d.g.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds150);
        if (this.gRW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gRW.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gRX.setVisibility(8);
        }
        this.gRZ = findViewById(d.g.progress_layout);
        this.gSa = (RoundProgressBar) this.gRZ.findViewById(d.g.video_progress);
        this.gSb = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gSb.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds38);
        this.gSb.setLayoutParams(layoutParams);
        this.gSo = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.gSo.ar(1, getString(d.k.tab_photo));
        if (this.gSh != 2 && this.gSh != 3) {
            this.gSo.ar(2, getString(d.k.tab_record));
            this.gSo.setListener(this);
            this.gSo.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.gSo.setShowIndicator(false);
            this.gSo.setCurrentTab(1, false);
            G(1, false);
        }
        byH();
    }

    private void byH() {
        if (UtilHelper.isOppoConcaveScreen()) {
            if (this.gRQ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gRQ.getLayoutParams()).topMargin = 80;
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
        this.gQn.onResume();
        this.gQX = this.gQn.byi();
        if (this.gQX != null) {
            this.gQX.setRecordController(this.gQe);
            this.gRV.setZoomHelper(this.gQX);
        }
        byI();
        if (this.gSl == null) {
            this.gSl = new l();
            this.gSl.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ci(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gSm, str2);
                    if (RecordVideoActivity.this.gRP != null) {
                        RecordVideoActivity.this.gRP.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void tL(String str) {
                    if (RecordVideoActivity.this.gRP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gRP.b(stickerItem);
                        if (RecordVideoActivity.this.gQn != null) {
                            RecordVideoActivity.this.gQn.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gRP != null) {
                        RecordVideoActivity.this.gRP.setDownLoadSticker(null);
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
                    if (RecordVideoActivity.this.gRP != null) {
                        RecordVideoActivity.this.gRP.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gSl.byZ();
        if (this.gRP != null && this.gSk) {
            bxw();
        }
        if (this.gxt != null) {
            this.gxt.pG("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gQn.onPause();
        if (this.gRP != null) {
            if (this.gQe != null && this.gQe.getStatus() == 6) {
                this.gRP.stopRecord();
                byR();
            }
            if (this.gQe != null && this.gQe.isRecording()) {
                this.gRP.stopRecord();
            }
        }
        if (this.gSn != null) {
            this.gSn.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gQe == null || this.gQe.getStatus() != 7) {
            if (this.gQe != null && this.gQe.getStatus() == 6) {
                if (this.gRP != null) {
                    this.gRP.stopRecord();
                }
                byR();
            } else if (this.gQe.onBackPressed()) {
                finish();
            } else {
                if (this.gRU == null) {
                    this.gRU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gRU.bZ(d.k.video_quit_confirm);
                    this.gRU.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gRU.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gRU.ar(true);
                    this.gRU.b(getPageContext());
                }
                this.gRU.tD();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        this.gSb.setVisibility(4);
        if (view2 == this.dFE) {
            onBackPressed();
        } else if (view2 == this.gRR) {
            if (this.gQe.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gQn.byl();
            byI();
        } else if (view2 == this.gRS) {
            if (this.gQe.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gRS.setOnClickListener(null);
            this.gQn.byn();
            if (this.gQn.byo() && this.gQn.bym()) {
                this.gQn.byl();
            }
            byI();
            this.gRS.setOnClickListener(this);
        } else if (view2 == this.gRT) {
            byK();
        }
    }

    private void byI() {
        if (this.gQn.byo()) {
            this.gRR.setVisibility(8);
        } else {
            this.gRR.setVisibility(0);
        }
        if (this.gQn.bym()) {
            this.gRR.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.gRR.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout byJ() {
        return this.gRV;
    }

    public void byK() {
        this.gSb.setVisibility(4);
        if (this.gQe.getStatus() != 6) {
            this.gQe.setStatus(6);
            byP();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gSe == null) {
                this.gSe = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gSe.setDuration(500L);
                this.gSe.setRepeatCount(5);
                this.gSe.setRepeatMode(2);
                this.gSe.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gSe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gQe.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gRW.setVisibility(0);
                        RecordVideoActivity.this.gRW.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gRW.setVisibility(8);
                    if (RecordVideoActivity.this.gQe.getStatus() == 6) {
                        RecordVideoActivity.this.gRP.bzc();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gQe.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gRW.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gRW.setText("");
                        }
                    }
                }
            });
            this.gRW.setAnimation(this.gSe);
            this.gSe.startNow();
            this.gRP.byK();
            if (this.gSn != null) {
                this.gSn.byE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        if (this.gQe.getStatus() == 1) {
            this.gSb.setVisibility(4);
            if (this.gQe.getStatus() != 6) {
                this.gRP.byL();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        this.gSb.setVisibility(4);
        if (this.gQe.getStatus() != 6) {
            this.gRP.byM();
            if (this.gRP.bzg()) {
                byG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byN() {
        this.gSb.setVisibility(4);
        if (this.gQe.getStatus() != 6) {
            this.gRP.byN();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byO() {
        this.gSb.setVisibility(4);
        if (this.gQe.getStatus() != 6) {
            this.gRP.byO();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byP() {
        this.gSj = true;
        if (this.gSd != null && this.gSd.isRunning()) {
            this.gSd.cancel();
        }
        if (this.gSc == null) {
            this.gSc = new AnimatorSet();
            this.gSc.playTogether(ObjectAnimator.ofFloat(this.gRQ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gRX, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gSo, "alpha", 1.0f, 0.0f));
            this.gSc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTR) {
                        RecordVideoActivity.this.gRQ.setVisibility(8);
                        RecordVideoActivity.this.gRX.setVisibility(8);
                        RecordVideoActivity.this.gSo.setVisibility(8);
                    }
                }
            });
            this.gSc.setDuration(300L);
        }
        this.gSc.start();
        this.gRX.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byE() {
        if (this.dlW == 2) {
            if (this.gSj) {
                this.gSj = false;
                if (this.gSn != null) {
                    this.gSn.byE();
                }
            } else {
                return;
            }
        }
        if (this.gSc != null && this.gSc.isRunning()) {
            this.gSc.cancel();
        }
        if (this.gSd == null) {
            this.gSd = new AnimatorSet();
            this.gSd.playTogether(ObjectAnimator.ofFloat(this.gRQ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gRX, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gSo, "alpha", 0.0f, 1.0f));
            this.gSd.setDuration(300L);
        }
        this.gRQ.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.gRX.setVisibility(0);
        }
        if (this.gQe.getStatus() == 1) {
            this.gSo.setVisibility(0);
        }
        this.gSd.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byQ() {
        if (this.gQn != null) {
            this.gQn.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void p(boolean z, String str) {
                    RecordVideoActivity.this.gQe.setStatus(1);
                    RecordVideoActivity.this.byE();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.gSp != null && !v.w(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.gSp)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.gSp);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.gSp = new ImageFileInfo();
                        RecordVideoActivity.this.gSp.setFilePath(str);
                        RecordVideoActivity.this.gSp.setTempFile(true);
                        RecordVideoActivity.this.gSp.setAlbumnId(null);
                        RecordVideoActivity.this.gSp.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.gSp);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.gSi, RecordVideoActivity.this.gSh)));
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
        this.gSe.cancel();
        this.gSe.setAnimationListener(null);
        this.gRW.clearAnimation();
        this.gRW.setVisibility(8);
        if (this.gSn != null) {
            this.gSn.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byS() {
        bpt();
    }

    private void bpt() {
        if (this.gSf != null) {
            this.gSf.cancel();
        }
        if (this.gSg == null) {
            this.gSg = ObjectAnimator.ofFloat(this.gSo, "alpha", 1.0f, 0.0f);
            this.gSg.setDuration(500L);
            this.gSg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gTR) {
                        RecordVideoActivity.this.gSo.setVisibility(8);
                    }
                }
            });
        }
        this.gSg.start();
    }

    private void bps() {
        if (this.gSg != null) {
            this.gSg.cancel();
        }
        if (this.gSf == null) {
            this.gSf = ObjectAnimator.ofFloat(this.gSo, "alpha", 0.0f, 1.0f);
            this.gSf.setDuration(500L);
        }
        this.gSo.setVisibility(0);
        this.gSf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byT() {
        this.gRX.reset();
        if (this.gQe.getStatus() == 1) {
            bps();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byU() {
        if (this.gRZ.getVisibility() != 0) {
            this.gRP.bzb();
            this.gQe.setStatus(8);
            byE();
            if (this.gQn.gQV != null && this.gQn.gQV.size() > 0) {
                this.gRZ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int gSt = 50;
        final int gSu = 1;
        Handler gSv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gSa.av(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.byY();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void byY() {
            this.gSv.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            byY();
            boolean z = RecordVideoActivity.this.gSn == null || TextUtils.isEmpty(RecordVideoActivity.this.gSn.byD()) || !new File(RecordVideoActivity.this.gSn.byD()).exists();
            if (RecordVideoActivity.this.gQn.gQV.size() > 1) {
                return com.baidu.tieba.video.meida.h.bxP().b(RecordVideoActivity.this.gQn.gQV, RecordVideoActivity.this.gQn.byf(), z);
            }
            File file = new File(RecordVideoActivity.this.gQn.gQV.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.gQn.byf()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bxP().b(RecordVideoActivity.this.gQn.gQV, RecordVideoActivity.this.gQn.byf(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.gRP.bzh();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.byF();
                    RecordVideoActivity.this.uz(102);
                    RecordVideoActivity.this.gRZ.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.byF();
                RecordVideoActivity.this.uz(102);
                RecordVideoActivity.this.gRZ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.k.mix_fail));
                RecordVideoActivity.this.gRZ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ac(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.gSa.av(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gRP == null || v.w(this.gRP.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.gRP.getChoosedBeautyList()) {
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
        if (this.gRP == null || v.w(this.gRP.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.gRP.getChoosedFilterList()) {
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
        if (this.gRP == null || v.w(this.gRP.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gRP.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byV() {
        this.gSb.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byW() {
        this.gSb.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byX() {
        if (this.gQe.getStatus() == 1) {
            this.gSo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.gQn != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gQn.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new al("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.gRX.setViewChoosed(2, false);
                            return;
                        } else {
                            this.gRX.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.gQn.setFilter((String) eVar.getValue());
                        al alVar = new al("c12496");
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.gQe.getStatus() == 1) {
                            alVar.r("obj_type", 1);
                        } else {
                            alVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.gRX.setViewChoosed(3, false);
                            return;
                        } else {
                            this.gRX.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.gSn.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.gRX.setViewChoosed(0, false);
                            return;
                        } else {
                            this.gRX.setViewChoosed(0, true);
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
            this.gSm = stickerItem;
            this.gSl.ul(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gQn != null) {
                    this.gQn.setSticker(null);
                    this.gSr = false;
                }
                if (this.gRP != null) {
                    this.gRP.setDownLoadSticker(null);
                }
                this.gRY.setVisibility(8);
                this.gRX.setViewChoosed(1, false);
                return;
            }
            String uj = this.gSl.uj(stickerItem.resource);
            if (!StringUtils.isNull(uj)) {
                a(stickerItem, uj);
                if (this.gRP != null) {
                    this.gRP.setDownLoadSticker(null);
                }
            } else {
                if (this.gRP != null) {
                    this.gRP.setDownLoadSticker(stickerItem);
                }
                this.gSl.uk(stickerItem.resource);
            }
            this.gRX.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gQn != null) {
                this.gQn.setSticker(stickerItem);
                this.gSr = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gRY.setText(stickerItem.desc);
                this.gRY.setVisibility(0);
                this.gRY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gRY.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gRY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.q(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gRP.getLayoutParams();
            layoutParams.height = i4;
            this.gRP.setLayoutParams(layoutParams);
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
                if (this.gSn != null && !TextUtils.isEmpty(tU)) {
                    this.gSn.cj(tU, stringExtra2);
                    this.gRP.bxU();
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
        if (this.gQe.getStatus() == 8) {
            this.gRP.bza();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void mY(boolean z) {
        if (this.gQe != null && (this.gQe.getStatus() == 1 || this.gQe.getStatus() == 3 || this.gQe.getStatus() == 4)) {
            if (!z && this.gSr) {
                this.gRV.bys();
                return;
            } else {
                this.gRV.byt();
                return;
            }
        }
        this.gRV.byt();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dlW != i) {
            switch (i) {
                case 1:
                    if (this.gSn != null) {
                        this.gSn.bgx();
                    }
                    this.gQn.setFilter("nature");
                    this.gRX.setViewChoosed(0, false);
                    this.gRX.setViewChoosed(3, false);
                    this.gRP.uB(1);
                    this.gRX.setViewVisibility(0, 8);
                    this.gRX.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.gRX.setViewVisibility(0, 0);
                    this.gRX.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dlW = i;
            this.gRP.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new al().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void byC() {
        if (this.gQe.getStatus() == 1 && !this.gRP.bzf()) {
            G(1, true);
            this.gSo.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void byB() {
        if (this.gQe.getStatus() == 1 && !this.gRP.bzf()) {
            G(2, true);
            this.gSo.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(int i) {
        if (this.gxt != null) {
            this.gxt.ad(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
        if (this.gxt != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gxt.ac(i, str);
        }
    }
}
