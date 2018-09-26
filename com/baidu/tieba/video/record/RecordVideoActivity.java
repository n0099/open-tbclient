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
import com.baidu.mobstat.Config;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tieba.e;
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
    private int dJg;
    private final CustomMessageListener dKO;
    private ImageView ehf;
    private com.baidu.tieba.j.h gWF;
    private String hlc;
    private SelectMusicModel hlg;
    private b.a hox;
    private i hpU;
    private b hqM;
    protected h hqc;
    private RecordLayout hrE;
    private VideoControllerLayout hrF;
    private RelativeLayout hrG;
    private ImageView hrH;
    private ImageView hrI;
    private ImageView hrJ;
    private com.baidu.tbadk.core.dialog.a hrK;
    private PreviewViewContainer hrL;
    private TextView hrM;
    private VideoEffectButtonLayout hrN;
    private TextView hrO;
    private View hrP;
    private RoundProgressBar hrQ;
    private TextView hrR;
    private AnimatorSet hrS;
    private AnimatorSet hrT;
    private ScaleAnimation hrU;
    private ObjectAnimator hrV;
    private ObjectAnimator hrW;
    private int hrX;
    private ForumWriteData hrY;
    private boolean hrZ;
    private boolean hsa = true;
    private l hsb;
    private StickerItem hsc;
    protected j hsd;
    private RecordTabLayout hse;
    private ImageFileInfo hsf;
    private HttpMessageListener hsg;
    private boolean hsh;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gWF = lVar.aYk();
        }
        if (this.gWF != null) {
            this.gWF.aXP();
        }
        this.hox = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dJ(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.z(list)) {
                    if (RecordVideoActivity.this.hrF != null) {
                        RecordVideoActivity.this.hrF.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hrF != null) {
                    RecordVideoActivity.this.hrF.setHasLocalVideo(true);
                    RecordVideoActivity.this.hsa = false;
                }
            }
        };
        this.hsg = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hrF != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hrF.setStickerItems(list);
                    }
                }
            }
        };
        this.dKO = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bFK() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hqc.hli);
        videoInfo.setVideoDuration(this.hpU.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hqc.hli).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hrY.writeCallFrom, this.hrY == null ? "" : this.hrY.forumName, this.hrY == null ? "" : this.hrY.forumId, this.hlc, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hsd != null) {
            this.hsd.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gWF != null) {
            this.gWF.aXS();
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
        if (this.hpU != null && this.hpU.isRecording()) {
            this.hpU.stopRecord();
        }
        if (this.hlg != null) {
            this.hlg.cancelLoadData();
        }
        if (this.gWF != null) {
            this.gWF.qY("record");
        }
        com.baidu.tbadk.core.util.l.x(new File(com.baidu.tieba.video.c.hjw));
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
        setContentView(e.h.record_activity);
        this.hrX = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hrY = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hlc = getIntent().getStringExtra("video_title");
        initUI();
        this.hlg = new SelectMusicModel(getPageContext(), this.hrF);
        this.hlg.bEa();
        this.hsd = new j(this);
        this.hsd.b(this.hlg);
        this.hpU.a(this.hsd);
        registerListener(this.hsg);
        registerListener(this.dKO);
        bFL();
    }

    private void bFL() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void bED() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hox);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hrE = (RecordLayout) findViewById(e.g.root_layout);
        this.hrE.setListener(this);
        this.hpU = new i(this);
        this.hrF = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hrF.setRecordController(this.hpU);
        this.hrF.setRecordControlListener(this);
        this.hrF.setEffectChoosedListener(this);
        this.hrG = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.ehf = (ImageView) findViewById(e.g.close_page);
        this.ehf.setOnClickListener(this);
        this.hrH = (ImageView) findViewById(e.g.flash_switch);
        this.hrH.setOnClickListener(this);
        this.hrI = (ImageView) findViewById(e.g.camera_switch);
        this.hrI.setOnClickListener(this);
        this.hrJ = (ImageView) findViewById(e.g.count_down);
        this.hrJ.setOnClickListener(this);
        this.hrL = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hqc = new h(this);
        this.hqc.a(this);
        this.hqc.setFaceIdentifyStateListener(this);
        this.hqc.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bFy() {
                if (RecordVideoActivity.this.hrF.bGk()) {
                    RecordVideoActivity.this.hrF.a((m) null);
                }
            }
        });
        this.hrN = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hrN.setListener(this);
        this.hpU.a(this.hrN);
        this.hrN.setViewChoosed(2, true);
        this.hrM = (TextView) findViewById(e.g.tv_count_down);
        this.hrO = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds150);
        if (this.hrM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hrM.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hrN.setVisibility(8);
        }
        this.hrP = findViewById(e.g.progress_layout);
        this.hrQ = (RoundProgressBar) this.hrP.findViewById(e.g.video_progress);
        this.hrR = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrR.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0141e.ds38);
        this.hrR.setLayoutParams(layoutParams);
        this.hse = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hse.as(1, getString(e.j.tab_photo));
        if (this.hrX != 2 && this.hrX != 3) {
            this.hse.as(2, getString(e.j.tab_record));
            this.hse.setListener(this);
            this.hse.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hse.setShowIndicator(false);
            this.hse.setCurrentTab(1, false);
            G(1, false);
        }
        bFM();
    }

    private void bFM() {
        if (com.baidu.tbadk.core.util.g.zl()) {
            this.mStatusBarView = findViewById(e.g.statusbar_view);
            ViewGroup.LayoutParams layoutParams = this.mStatusBarView.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            this.mStatusBarView.setLayoutParams(layoutParams);
            this.mStatusBarView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hqc.onResume();
        this.hqM = this.hqc.bFp();
        if (this.hqM != null) {
            this.hqM.setRecordController(this.hpU);
            this.hrL.setZoomHelper(this.hqM);
        }
        bFN();
        if (this.hsb == null) {
            this.hsb = new l();
            this.hsb.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cB(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hsc, str2);
                    if (RecordVideoActivity.this.hrF != null) {
                        RecordVideoActivity.this.hrF.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void vp(String str) {
                    if (RecordVideoActivity.this.hrF != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hrF.b(stickerItem);
                        if (RecordVideoActivity.this.hqc != null) {
                            RecordVideoActivity.this.hqc.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hrF != null) {
                        RecordVideoActivity.this.hrF.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(e.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(e.j.sticker_download_error);
                    }
                    recordVideoActivity.ab(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bDi() {
                    if (RecordVideoActivity.this.hrF != null) {
                        RecordVideoActivity.this.hrF.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hsb.bGe();
        if (this.hrF != null && this.hsa) {
            bED();
        }
        if (this.gWF != null) {
            this.gWF.qX("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hqc.onPause();
        if (this.hrF != null) {
            if (this.hpU != null && this.hpU.getStatus() == 6) {
                this.hrF.stopRecord();
                bFW();
            }
            if (this.hpU != null && this.hpU.isRecording()) {
                this.hrF.stopRecord();
            }
        }
        if (this.hsd != null) {
            this.hsd.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hpU == null || this.hpU.getStatus() != 7) {
            if (this.hpU != null && this.hpU.getStatus() == 6) {
                if (this.hrF != null) {
                    this.hrF.stopRecord();
                }
                bFW();
            } else if (this.hpU.onBackPressed()) {
                finish();
            } else {
                if (this.hrK == null) {
                    this.hrK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hrK.cp(e.j.video_quit_confirm);
                    this.hrK.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hrK.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hrK.aE(true);
                    this.hrK.b(getPageContext());
                }
                this.hrK.yl();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hrR.setVisibility(4);
        if (view == this.ehf) {
            onBackPressed();
        } else if (view == this.hrH) {
            if (this.hpU.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hqc.bFs();
            bFN();
        } else if (view == this.hrI) {
            if (this.hpU.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hrI.setOnClickListener(null);
            this.hqc.bFu();
            if (this.hqc.bFv() && this.hqc.bFt()) {
                this.hqc.bFs();
            }
            bFN();
            this.hrI.setOnClickListener(this);
        } else if (view == this.hrJ) {
            bFP();
        }
    }

    private void bFN() {
        if (this.hqc.bFv()) {
            this.hrH.setVisibility(8);
        } else {
            this.hrH.setVisibility(0);
        }
        if (this.hqc.bFt()) {
            this.hrH.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hrH.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bFO() {
        return this.hrL;
    }

    public void bFP() {
        this.hrR.setVisibility(4);
        if (this.hpU.getStatus() != 6) {
            this.hpU.setStatus(6);
            bFU();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hrU == null) {
                this.hrU = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hrU.setDuration(500L);
                this.hrU.setRepeatCount(5);
                this.hrU.setRepeatMode(2);
                this.hrU.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hrU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hpU.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hrM.setVisibility(0);
                        RecordVideoActivity.this.hrM.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hrM.setVisibility(8);
                    if (RecordVideoActivity.this.hpU.getStatus() == 6) {
                        RecordVideoActivity.this.hrF.bGh();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hpU.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hrM.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hrM.setText("");
                        }
                    }
                }
            });
            this.hrM.setAnimation(this.hrU);
            this.hrU.startNow();
            this.hrF.bFP();
            if (this.hsd != null) {
                this.hsd.bFJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFQ() {
        if (this.hpU.getStatus() == 1) {
            this.hrR.setVisibility(4);
            if (this.hpU.getStatus() != 6) {
                this.hrF.bFQ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFR() {
        this.hrR.setVisibility(4);
        if (this.hpU.getStatus() != 6) {
            this.hrF.bFR();
            if (this.hrF.bGl()) {
                bFL();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFS() {
        this.hrR.setVisibility(4);
        if (this.hpU.getStatus() != 6) {
            this.hrF.bFS();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bFT() {
        this.hrR.setVisibility(4);
        if (this.hpU.getStatus() != 6) {
            this.hrF.bFT();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bFU() {
        this.hrZ = true;
        if (this.hrT != null && this.hrT.isRunning()) {
            this.hrT.cancel();
        }
        if (this.hrS == null) {
            this.hrS = new AnimatorSet();
            this.hrS.playTogether(ObjectAnimator.ofFloat(this.hrG, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hrN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hse, "alpha", 1.0f, 0.0f));
            this.hrS.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.htH) {
                        RecordVideoActivity.this.hrG.setVisibility(8);
                        RecordVideoActivity.this.hrN.setVisibility(8);
                        RecordVideoActivity.this.hse.setVisibility(8);
                    }
                }
            });
            this.hrS.setDuration(300L);
        }
        this.hrS.start();
        this.hrN.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bFJ() {
        if (this.dJg == 2) {
            if (this.hrZ) {
                this.hrZ = false;
                if (this.hsd != null) {
                    this.hsd.bFJ();
                }
            } else {
                return;
            }
        }
        if (this.hrS != null && this.hrS.isRunning()) {
            this.hrS.cancel();
        }
        if (this.hrT == null) {
            this.hrT = new AnimatorSet();
            this.hrT.playTogether(ObjectAnimator.ofFloat(this.hrG, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hrN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hse, "alpha", 0.0f, 1.0f));
            this.hrT.setDuration(300L);
        }
        this.hrG.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hrN.setVisibility(0);
        }
        if (this.hpU.getStatus() == 1) {
            this.hse.setVisibility(0);
        }
        this.hrT.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bFV() {
        if (this.hqc != null) {
            this.hqc.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void u(boolean z, String str) {
                    RecordVideoActivity.this.hpU.setStatus(1);
                    RecordVideoActivity.this.bFJ();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hsf != null && !v.z(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hsf)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hsf);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hsf = new ImageFileInfo();
                        RecordVideoActivity.this.hsf.setFilePath(str);
                        RecordVideoActivity.this.hsf.setTempFile(true);
                        RecordVideoActivity.this.hsf.setAlbumnId(null);
                        RecordVideoActivity.this.hsf.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hsf);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hrY, RecordVideoActivity.this.hrX)));
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
    public void bFW() {
        this.hrU.cancel();
        this.hrU.setAnimationListener(null);
        this.hrM.clearAnimation();
        this.hrM.setVisibility(8);
        if (this.hsd != null) {
            this.hsd.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bFX() {
        bwb();
    }

    private void bwb() {
        if (this.hrV != null) {
            this.hrV.cancel();
        }
        if (this.hrW == null) {
            this.hrW = ObjectAnimator.ofFloat(this.hse, "alpha", 1.0f, 0.0f);
            this.hrW.setDuration(500L);
            this.hrW.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.htH) {
                        RecordVideoActivity.this.hse.setVisibility(8);
                    }
                }
            });
        }
        this.hrW.start();
    }

    private void bwa() {
        if (this.hrW != null) {
            this.hrW.cancel();
        }
        if (this.hrV == null) {
            this.hrV = ObjectAnimator.ofFloat(this.hse, "alpha", 0.0f, 1.0f);
            this.hrV.setDuration(500L);
        }
        this.hse.setVisibility(0);
        this.hrV.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bFY() {
        this.hrN.reset();
        if (this.hpU.getStatus() == 1) {
            bwa();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bFZ() {
        if (this.hrP.getVisibility() != 0) {
            this.hrF.bGg();
            this.hpU.setStatus(8);
            bFJ();
            if (this.hqc.hqK != null && this.hqc.hqK.size() > 0) {
                this.hrP.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hsj = 50;
        final int hsk = 1;
        Handler hsl = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hrQ.az(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bGd();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bGd() {
            this.hsl.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bGd();
            boolean z = RecordVideoActivity.this.hsd == null || TextUtils.isEmpty(RecordVideoActivity.this.hsd.bFI()) || !new File(RecordVideoActivity.this.hsd.bFI()).exists();
            if (RecordVideoActivity.this.hqc.hqK.size() > 1) {
                return com.baidu.tieba.video.meida.h.bEV().a(RecordVideoActivity.this.hqc.hqK, RecordVideoActivity.this.hqc.bFm(), z);
            }
            File file = new File(RecordVideoActivity.this.hqc.hqK.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hqc.bFm()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bEV().a(RecordVideoActivity.this.hqc.hqK, RecordVideoActivity.this.hqc.bFm(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hrF.bGm();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bFK();
                    RecordVideoActivity.this.vs(102);
                    RecordVideoActivity.this.hrP.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bFK();
                RecordVideoActivity.this.vs(102);
                RecordVideoActivity.this.hrP.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hrP.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ab(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hrQ.az(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hrF == null || v.z(this.hrF.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hrF.getChoosedBeautyList()) {
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
        if (this.hrF == null || v.z(this.hrF.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hrF.getChoosedFilterList()) {
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
        if (this.hrF == null || v.z(this.hrF.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hrF.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bGa() {
        this.hrR.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bGb() {
        this.hrR.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bGc() {
        if (this.hpU.getStatus() == 1) {
            this.hse.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hqc != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hqc.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").w(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hrN.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hrN.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hqc.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.al(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hpU.getStatus() == 1) {
                            amVar.w("obj_type", 1);
                        } else {
                            amVar.w("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hrN.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hrN.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hsd.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hrN.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hrN.setViewChoosed(0, true);
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
            this.hsc = stickerItem;
            this.hsb.vQ(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hqc != null) {
                    this.hqc.setSticker(null);
                    this.hsh = false;
                }
                if (this.hrF != null) {
                    this.hrF.setDownLoadSticker(null);
                }
                this.hrO.setVisibility(8);
                this.hrN.setViewChoosed(1, false);
                return;
            }
            String vN = this.hsb.vN(stickerItem.resource);
            if (!StringUtils.isNull(vN)) {
                a(stickerItem, vN);
                if (this.hrF != null) {
                    this.hrF.setDownLoadSticker(null);
                }
            } else {
                if (this.hrF != null) {
                    this.hrF.setDownLoadSticker(stickerItem);
                }
                this.hsb.vO(stickerItem.resource);
            }
            this.hrN.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hqc != null) {
                this.hqc.setSticker(stickerItem);
                this.hsh = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hrO.setText(stickerItem.desc);
                this.hrO.setVisibility(0);
                this.hrO.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hrO.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hrO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bT(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0141e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hrF.getLayoutParams();
            layoutParams.height = i4;
            this.hrF.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String vy = com.baidu.tieba.video.editvideo.model.a.bDU().vy(stringExtra);
                if (this.hsd != null && !TextUtils.isEmpty(vy)) {
                    this.hsd.cC(vy, stringExtra2);
                    this.hrF.bFa();
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
        if (this.hpU.getStatus() == 8) {
            this.hrF.bGf();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void nx(boolean z) {
        if (this.hpU != null && (this.hpU.getStatus() == 1 || this.hpU.getStatus() == 3 || this.hpU.getStatus() == 4)) {
            if (!z && this.hsh) {
                this.hrL.agZ();
                return;
            } else {
                this.hrL.aha();
                return;
            }
        }
        this.hrL.aha();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dJg != i) {
            switch (i) {
                case 1:
                    if (this.hsd != null) {
                        this.hsd.Ry();
                    }
                    this.hqc.setFilter("nature");
                    this.hrN.setViewChoosed(0, false);
                    this.hrN.setViewChoosed(3, false);
                    this.hrF.vu(1);
                    this.hrN.setViewVisibility(0, 8);
                    this.hrN.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hrN.setViewVisibility(0, 0);
                    this.hrN.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dJg = i;
            this.hrF.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().w("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bFH() {
        if (this.hpU.getStatus() == 1 && !this.hrF.bGk()) {
            G(1, true);
            this.hse.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bFG() {
        if (this.hpU.getStatus() == 1 && !this.hrF.bGk()) {
            G(2, true);
            this.hse.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs(int i) {
        if (this.gWF != null) {
            this.gWF.ac(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.gWF != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gWF.ab(i, str);
        }
    }
}
