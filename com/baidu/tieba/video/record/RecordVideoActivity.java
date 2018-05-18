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
    private ImageView dGK;
    private int dnd;
    private final CustomMessageListener doJ;
    private String gMp;
    private SelectMusicModel gMt;
    private b.a gPK;
    private i gRi;
    protected h gRr;
    private RecordLayout gSS;
    private VideoControllerLayout gST;
    private RelativeLayout gSU;
    private ImageView gSV;
    private ImageView gSW;
    private ImageView gSX;
    private com.baidu.tbadk.core.dialog.a gSY;
    private PreviewViewContainer gSZ;
    private b gSb;
    private TextView gTa;
    private VideoEffectButtonLayout gTb;
    private TextView gTc;
    private View gTd;
    private RoundProgressBar gTe;
    private TextView gTf;
    private AnimatorSet gTg;
    private AnimatorSet gTh;
    private ScaleAnimation gTi;
    private ObjectAnimator gTj;
    private ObjectAnimator gTk;
    private int gTl;
    private ForumWriteData gTm;
    private boolean gTn;
    private boolean gTo = true;
    private l gTp;
    private StickerItem gTq;
    protected j gTr;
    private RecordTabLayout gTs;
    private ImageFileInfo gTt;
    private HttpMessageListener gTu;
    private boolean gTv;
    private com.baidu.tieba.j.h gyx;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gyx = kVar.aSb();
        }
        if (this.gyx != null) {
            this.gyx.aRI();
        }
        this.gPK = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dE(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.w(list)) {
                    if (RecordVideoActivity.this.gST != null) {
                        RecordVideoActivity.this.gST.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.gST != null) {
                    RecordVideoActivity.this.gST.setHasLocalVideo(true);
                    RecordVideoActivity.this.gTo = false;
                }
            }
        };
        this.gTu = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.gST != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.gST.setStickerItems(list);
                    }
                }
            }
        };
        this.doJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void byD() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gRr.gMv);
        videoInfo.setVideoDuration(this.gRi.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gRr.gMv).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.gTm.writeCallFrom, this.gTm == null ? "" : this.gTm.forumName, this.gTm == null ? "" : this.gTm.forumId, this.gMp, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.gTr != null) {
            this.gTr.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gyx != null) {
            this.gyx.aRL();
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
        if (this.gRi != null && this.gRi.isRecording()) {
            this.gRi.stopRecord();
        }
        if (this.gMt != null) {
            this.gMt.cancelLoadData();
        }
        if (this.gyx != null) {
            this.gyx.pK("record");
        }
        com.baidu.tbadk.core.util.k.r(new File(com.baidu.tieba.video.b.gKJ));
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
        this.gTl = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.gTm = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gMp = getIntent().getStringExtra("video_title");
        initUI();
        this.gMt = new SelectMusicModel(getPageContext(), this.gST);
        this.gMt.bwR();
        this.gTr = new j(this);
        this.gTr.b(this.gMt);
        this.gRi.a(this.gTr);
        byE();
        registerListener(this.gTu);
        registerListener(this.doJ);
    }

    private void byE() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bxu() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gPK);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gSS = (RecordLayout) findViewById(d.g.root_layout);
        this.gSS.setListener(this);
        this.gRi = new i(this);
        this.gST = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gST.setRecordController(this.gRi);
        this.gST.setRecordControlListener(this);
        this.gST.setEffectChoosedListener(this);
        this.gSU = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dGK = (ImageView) findViewById(d.g.close_page);
        this.dGK.setOnClickListener(this);
        this.gSV = (ImageView) findViewById(d.g.flash_switch);
        this.gSV.setOnClickListener(this);
        this.gSW = (ImageView) findViewById(d.g.camera_switch);
        this.gSW.setOnClickListener(this);
        this.gSX = (ImageView) findViewById(d.g.count_down);
        this.gSX.setOnClickListener(this);
        this.gSZ = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.gRr = new h(this);
        this.gRr.a(this);
        this.gRr.setFaceIdentifyStateListener(this);
        this.gRr.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void byp() {
                if (RecordVideoActivity.this.gST.bzd()) {
                    RecordVideoActivity.this.gST.a((m) null);
                }
            }
        });
        this.gTb = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gTb.setListener(this);
        this.gRi.a(this.gTb);
        this.gTb.setViewChoosed(2, true);
        this.gTa = (TextView) findViewById(d.g.tv_count_down);
        this.gTc = (TextView) findViewById(d.g.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds150);
        if (this.gTa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gTa.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gTb.setVisibility(8);
        }
        this.gTd = findViewById(d.g.progress_layout);
        this.gTe = (RoundProgressBar) this.gTd.findViewById(d.g.video_progress);
        this.gTf = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gTf.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds38);
        this.gTf.setLayoutParams(layoutParams);
        this.gTs = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.gTs.ar(1, getString(d.k.tab_photo));
        if (this.gTl != 2 && this.gTl != 3) {
            this.gTs.ar(2, getString(d.k.tab_record));
            this.gTs.setListener(this);
            this.gTs.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.gTs.setShowIndicator(false);
            this.gTs.setCurrentTab(1, false);
            G(1, false);
        }
        byF();
    }

    private void byF() {
        if (UtilHelper.isOppoConcaveScreen()) {
            if (this.gSU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.gSU.getLayoutParams()).topMargin = 80;
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
        this.gRr.onResume();
        this.gSb = this.gRr.byg();
        if (this.gSb != null) {
            this.gSb.setRecordController(this.gRi);
            this.gSZ.setZoomHelper(this.gSb);
        }
        byG();
        if (this.gTp == null) {
            this.gTp = new l();
            this.gTp.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ci(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gTq, str2);
                    if (RecordVideoActivity.this.gST != null) {
                        RecordVideoActivity.this.gST.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void tO(String str) {
                    if (RecordVideoActivity.this.gST != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gST.b(stickerItem);
                        if (RecordVideoActivity.this.gRr != null) {
                            RecordVideoActivity.this.gRr.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gST != null) {
                        RecordVideoActivity.this.gST.setDownLoadSticker(null);
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
                public void bvZ() {
                    if (RecordVideoActivity.this.gST != null) {
                        RecordVideoActivity.this.gST.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gTp.byX();
        if (this.gST != null && this.gTo) {
            bxu();
        }
        if (this.gyx != null) {
            this.gyx.pJ("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gRr.onPause();
        if (this.gST != null) {
            if (this.gRi != null && this.gRi.getStatus() == 6) {
                this.gST.stopRecord();
                byP();
            }
            if (this.gRi != null && this.gRi.isRecording()) {
                this.gST.stopRecord();
            }
        }
        if (this.gTr != null) {
            this.gTr.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gRi == null || this.gRi.getStatus() != 7) {
            if (this.gRi != null && this.gRi.getStatus() == 6) {
                if (this.gST != null) {
                    this.gST.stopRecord();
                }
                byP();
            } else if (this.gRi.onBackPressed()) {
                finish();
            } else {
                if (this.gSY == null) {
                    this.gSY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gSY.ca(d.k.video_quit_confirm);
                    this.gSY.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gSY.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gSY.ar(true);
                    this.gSY.b(getPageContext());
                }
                this.gSY.tC();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        this.gTf.setVisibility(4);
        if (view2 == this.dGK) {
            onBackPressed();
        } else if (view2 == this.gSV) {
            if (this.gRi.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gRr.byj();
            byG();
        } else if (view2 == this.gSW) {
            if (this.gRi.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gSW.setOnClickListener(null);
            this.gRr.byl();
            if (this.gRr.bym() && this.gRr.byk()) {
                this.gRr.byj();
            }
            byG();
            this.gSW.setOnClickListener(this);
        } else if (view2 == this.gSX) {
            byI();
        }
    }

    private void byG() {
        if (this.gRr.bym()) {
            this.gSV.setVisibility(8);
        } else {
            this.gSV.setVisibility(0);
        }
        if (this.gRr.byk()) {
            this.gSV.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.gSV.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout byH() {
        return this.gSZ;
    }

    public void byI() {
        this.gTf.setVisibility(4);
        if (this.gRi.getStatus() != 6) {
            this.gRi.setStatus(6);
            byN();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gTi == null) {
                this.gTi = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gTi.setDuration(500L);
                this.gTi.setRepeatCount(5);
                this.gTi.setRepeatMode(2);
                this.gTi.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gTi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gRi.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gTa.setVisibility(0);
                        RecordVideoActivity.this.gTa.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gTa.setVisibility(8);
                    if (RecordVideoActivity.this.gRi.getStatus() == 6) {
                        RecordVideoActivity.this.gST.bza();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gRi.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gTa.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gTa.setText("");
                        }
                    }
                }
            });
            this.gTa.setAnimation(this.gTi);
            this.gTi.startNow();
            this.gST.byI();
            if (this.gTr != null) {
                this.gTr.byC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byJ() {
        if (this.gRi.getStatus() == 1) {
            this.gTf.setVisibility(4);
            if (this.gRi.getStatus() != 6) {
                this.gST.byJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byK() {
        this.gTf.setVisibility(4);
        if (this.gRi.getStatus() != 6) {
            this.gST.byK();
            if (this.gST.bze()) {
                byE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byL() {
        this.gTf.setVisibility(4);
        if (this.gRi.getStatus() != 6) {
            this.gST.byL();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void byM() {
        this.gTf.setVisibility(4);
        if (this.gRi.getStatus() != 6) {
            this.gST.byM();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byN() {
        this.gTn = true;
        if (this.gTh != null && this.gTh.isRunning()) {
            this.gTh.cancel();
        }
        if (this.gTg == null) {
            this.gTg = new AnimatorSet();
            this.gTg.playTogether(ObjectAnimator.ofFloat(this.gSU, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gTb, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gTs, "alpha", 1.0f, 0.0f));
            this.gTg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gUV) {
                        RecordVideoActivity.this.gSU.setVisibility(8);
                        RecordVideoActivity.this.gTb.setVisibility(8);
                        RecordVideoActivity.this.gTs.setVisibility(8);
                    }
                }
            });
            this.gTg.setDuration(300L);
        }
        this.gTg.start();
        this.gTb.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byC() {
        if (this.dnd == 2) {
            if (this.gTn) {
                this.gTn = false;
                if (this.gTr != null) {
                    this.gTr.byC();
                }
            } else {
                return;
            }
        }
        if (this.gTg != null && this.gTg.isRunning()) {
            this.gTg.cancel();
        }
        if (this.gTh == null) {
            this.gTh = new AnimatorSet();
            this.gTh.playTogether(ObjectAnimator.ofFloat(this.gSU, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gTb, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gTs, "alpha", 0.0f, 1.0f));
            this.gTh.setDuration(300L);
        }
        this.gSU.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.gTb.setVisibility(0);
        }
        if (this.gRi.getStatus() == 1) {
            this.gTs.setVisibility(0);
        }
        this.gTh.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byO() {
        if (this.gRr != null) {
            this.gRr.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void p(boolean z, String str) {
                    RecordVideoActivity.this.gRi.setStatus(1);
                    RecordVideoActivity.this.byC();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.gTt != null && !v.w(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.gTt)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.gTt);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.gTt = new ImageFileInfo();
                        RecordVideoActivity.this.gTt.setFilePath(str);
                        RecordVideoActivity.this.gTt.setTempFile(true);
                        RecordVideoActivity.this.gTt.setAlbumnId(null);
                        RecordVideoActivity.this.gTt.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.gTt);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.gTm, RecordVideoActivity.this.gTl)));
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
    public void byP() {
        this.gTi.cancel();
        this.gTi.setAnimationListener(null);
        this.gTa.clearAnimation();
        this.gTa.setVisibility(8);
        if (this.gTr != null) {
            this.gTr.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byQ() {
        bpr();
    }

    private void bpr() {
        if (this.gTj != null) {
            this.gTj.cancel();
        }
        if (this.gTk == null) {
            this.gTk = ObjectAnimator.ofFloat(this.gTs, "alpha", 1.0f, 0.0f);
            this.gTk.setDuration(500L);
            this.gTk.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gUV) {
                        RecordVideoActivity.this.gTs.setVisibility(8);
                    }
                }
            });
        }
        this.gTk.start();
    }

    private void bpq() {
        if (this.gTk != null) {
            this.gTk.cancel();
        }
        if (this.gTj == null) {
            this.gTj = ObjectAnimator.ofFloat(this.gTs, "alpha", 0.0f, 1.0f);
            this.gTj.setDuration(500L);
        }
        this.gTs.setVisibility(0);
        this.gTj.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byR() {
        this.gTb.reset();
        if (this.gRi.getStatus() == 1) {
            bpq();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byS() {
        if (this.gTd.getVisibility() != 0) {
            this.gST.byZ();
            this.gRi.setStatus(8);
            byC();
            if (this.gRr.gRZ != null && this.gRr.gRZ.size() > 0) {
                this.gTd.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int gTx = 50;
        final int gTy = 1;
        Handler gTz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gTe.av(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.byW();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void byW() {
            this.gTz.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            byW();
            boolean z = RecordVideoActivity.this.gTr == null || TextUtils.isEmpty(RecordVideoActivity.this.gTr.byB()) || !new File(RecordVideoActivity.this.gTr.byB()).exists();
            if (RecordVideoActivity.this.gRr.gRZ.size() > 1) {
                return com.baidu.tieba.video.meida.h.bxN().b(RecordVideoActivity.this.gRr.gRZ, RecordVideoActivity.this.gRr.byd(), z);
            }
            File file = new File(RecordVideoActivity.this.gRr.gRZ.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.gRr.byd()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bxN().b(RecordVideoActivity.this.gRr.gRZ, RecordVideoActivity.this.gRr.byd(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.gST.bzf();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.byD();
                    RecordVideoActivity.this.uy(102);
                    RecordVideoActivity.this.gTd.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.byD();
                RecordVideoActivity.this.uy(102);
                RecordVideoActivity.this.gTd.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.k.mix_fail));
                RecordVideoActivity.this.gTd.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ac(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.gTe.av(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gST == null || v.w(this.gST.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.gST.getChoosedBeautyList()) {
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
        if (this.gST == null || v.w(this.gST.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.gST.getChoosedFilterList()) {
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
        if (this.gST == null || v.w(this.gST.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gST.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byT() {
        this.gTf.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byU() {
        this.gTf.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void byV() {
        if (this.gRi.getStatus() == 1) {
            this.gTs.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.gRr != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gRr.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new al("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.gTb.setViewChoosed(2, false);
                            return;
                        } else {
                            this.gTb.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.gRr.setFilter((String) eVar.getValue());
                        al alVar = new al("c12496");
                        alVar.ac(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.gRi.getStatus() == 1) {
                            alVar.r("obj_type", 1);
                        } else {
                            alVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.gTb.setViewChoosed(3, false);
                            return;
                        } else {
                            this.gTb.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.gTr.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.gTb.setViewChoosed(0, false);
                            return;
                        } else {
                            this.gTb.setViewChoosed(0, true);
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
            this.gTq = stickerItem;
            this.gTp.uo(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gRr != null) {
                    this.gRr.setSticker(null);
                    this.gTv = false;
                }
                if (this.gST != null) {
                    this.gST.setDownLoadSticker(null);
                }
                this.gTc.setVisibility(8);
                this.gTb.setViewChoosed(1, false);
                return;
            }
            String um = this.gTp.um(stickerItem.resource);
            if (!StringUtils.isNull(um)) {
                a(stickerItem, um);
                if (this.gST != null) {
                    this.gST.setDownLoadSticker(null);
                }
            } else {
                if (this.gST != null) {
                    this.gST.setDownLoadSticker(stickerItem);
                }
                this.gTp.un(stickerItem.resource);
            }
            this.gTb.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gRr != null) {
                this.gRr.setSticker(stickerItem);
                this.gTv = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gTc.setText(stickerItem.desc);
                this.gTc.setVisibility(0);
                this.gTc.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gTc.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gTc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.q(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gST.getLayoutParams();
            layoutParams.height = i4;
            this.gST.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tX = com.baidu.tieba.video.editvideo.model.a.bwL().tX(stringExtra);
                if (this.gTr != null && !TextUtils.isEmpty(tX)) {
                    this.gTr.cj(tX, stringExtra2);
                    this.gST.bxS();
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
        if (this.gRi.getStatus() == 8) {
            this.gST.byY();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void mZ(boolean z) {
        if (this.gRi != null && (this.gRi.getStatus() == 1 || this.gRi.getStatus() == 3 || this.gRi.getStatus() == 4)) {
            if (!z && this.gTv) {
                this.gSZ.byq();
                return;
            } else {
                this.gSZ.byr();
                return;
            }
        }
        this.gSZ.byr();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dnd != i) {
            switch (i) {
                case 1:
                    if (this.gTr != null) {
                        this.gTr.bgx();
                    }
                    this.gRr.setFilter("nature");
                    this.gTb.setViewChoosed(0, false);
                    this.gTb.setViewChoosed(3, false);
                    this.gST.uA(1);
                    this.gTb.setViewVisibility(0, 8);
                    this.gTb.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.gTb.setViewVisibility(0, 0);
                    this.gTb.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dnd = i;
            this.gST.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new al().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void byA() {
        if (this.gRi.getStatus() == 1 && !this.gST.bzd()) {
            G(1, true);
            this.gTs.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void byz() {
        if (this.gRi.getStatus() == 1 && !this.gST.bzd()) {
            G(2, true);
            this.gTs.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy(int i) {
        if (this.gyx != null) {
            this.gyx.ad(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
        if (this.gyx != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gyx.ac(i, str);
        }
    }
}
