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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
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
    private int dCt;
    private final CustomMessageListener dEb;
    private ImageView dZM;
    private com.baidu.tieba.j.h gOY;
    private String hdj;
    private SelectMusicModel hdn;
    private b.a hgG;
    private b hiW;
    private i hie;
    protected h him;
    private RecordLayout hjO;
    private VideoControllerLayout hjP;
    private RelativeLayout hjQ;
    private ImageView hjR;
    private ImageView hjS;
    private ImageView hjT;
    private com.baidu.tbadk.core.dialog.a hjU;
    private PreviewViewContainer hjV;
    private TextView hjW;
    private VideoEffectButtonLayout hjX;
    private TextView hjY;
    private View hjZ;
    private RoundProgressBar hka;
    private TextView hkb;
    private AnimatorSet hkc;
    private AnimatorSet hkd;
    private ScaleAnimation hke;
    private ObjectAnimator hkf;
    private ObjectAnimator hkg;
    private int hkh;
    private ForumWriteData hki;
    private boolean hkj;
    private boolean hkk = true;
    private l hkl;
    private StickerItem hkm;
    protected j hkn;
    private RecordTabLayout hko;
    private ImageFileInfo hkp;
    private HttpMessageListener hkq;
    private boolean hkr;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gOY = lVar.aWa();
        }
        if (this.gOY != null) {
            this.gOY.aVF();
        }
        this.hgG = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dI(List<com.baidu.tieba.video.localvideo.d> list) {
                if (w.z(list)) {
                    if (RecordVideoActivity.this.hjP != null) {
                        RecordVideoActivity.this.hjP.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hjP != null) {
                    RecordVideoActivity.this.hjP.setHasLocalVideo(true);
                    RecordVideoActivity.this.hkk = false;
                }
            }
        };
        this.hkq = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hjP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hjP.setStickerItems(list);
                    }
                }
            }
        };
        this.dEb = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bCT() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.him.hdp);
        videoInfo.setVideoDuration(this.hie.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.him.hdp).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hki.writeCallFrom, this.hki == null ? "" : this.hki.forumName, this.hki == null ? "" : this.hki.forumId, this.hdj, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hkn != null) {
            this.hkn.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gOY != null) {
            this.gOY.aVI();
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
        if (this.hie != null && this.hie.isRecording()) {
            this.hie.stopRecord();
        }
        if (this.hdn != null) {
            this.hdn.cancelLoadData();
        }
        if (this.gOY != null) {
            this.gOY.qr("record");
        }
        com.baidu.tbadk.core.util.l.r(new File(com.baidu.tieba.video.c.hbD));
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
        setContentView(d.h.record_activity);
        this.hkh = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hki = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hdj = getIntent().getStringExtra("video_title");
        initUI();
        this.hdn = new SelectMusicModel(getPageContext(), this.hjP);
        this.hdn.bBj();
        this.hkn = new j(this);
        this.hkn.b(this.hdn);
        this.hie.a(this.hkn);
        registerListener(this.hkq);
        registerListener(this.dEb);
        bCU();
    }

    private void bCU() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bBM() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hgG);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hjO = (RecordLayout) findViewById(d.g.root_layout);
        this.hjO.setListener(this);
        this.hie = new i(this);
        this.hjP = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hjP.setRecordController(this.hie);
        this.hjP.setRecordControlListener(this);
        this.hjP.setEffectChoosedListener(this);
        this.hjQ = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dZM = (ImageView) findViewById(d.g.close_page);
        this.dZM.setOnClickListener(this);
        this.hjR = (ImageView) findViewById(d.g.flash_switch);
        this.hjR.setOnClickListener(this);
        this.hjS = (ImageView) findViewById(d.g.camera_switch);
        this.hjS.setOnClickListener(this);
        this.hjT = (ImageView) findViewById(d.g.count_down);
        this.hjT.setOnClickListener(this);
        this.hjV = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.him = new h(this);
        this.him.a(this);
        this.him.setFaceIdentifyStateListener(this);
        this.him.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bCH() {
                if (RecordVideoActivity.this.hjP.bDt()) {
                    RecordVideoActivity.this.hjP.a((m) null);
                }
            }
        });
        this.hjX = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hjX.setListener(this);
        this.hie.a(this.hjX);
        this.hjX.setViewChoosed(2, true);
        this.hjW = (TextView) findViewById(d.g.tv_count_down);
        this.hjY = (TextView) findViewById(d.g.gesture_guide_tv);
        int aj = ((com.baidu.adp.lib.util.l.aj(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds150);
        if (this.hjW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hjW.getLayoutParams()).topMargin = aj;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hjX.setVisibility(8);
        }
        this.hjZ = findViewById(d.g.progress_layout);
        this.hka = (RoundProgressBar) this.hjZ.findViewById(d.g.video_progress);
        this.hkb = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkb.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ah(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds38);
        this.hkb.setLayoutParams(layoutParams);
        this.hko = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hko.ar(1, getString(d.j.tab_photo));
        if (this.hkh != 2 && this.hkh != 3) {
            this.hko.ar(2, getString(d.j.tab_record));
            this.hko.setListener(this);
            this.hko.setCurrentTab(2, false);
            F(2, false);
        } else {
            this.hko.setShowIndicator(false);
            this.hko.setCurrentTab(1, false);
            F(1, false);
        }
        bCV();
    }

    private void bCV() {
        if (com.baidu.tbadk.core.util.g.yf()) {
            this.mStatusBarView = findViewById(d.g.statusbar_view);
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
        this.him.onResume();
        this.hiW = this.him.bCy();
        if (this.hiW != null) {
            this.hiW.setRecordController(this.hie);
            this.hjV.setZoomHelper(this.hiW);
        }
        bCW();
        if (this.hkl == null) {
            this.hkl = new l();
            this.hkl.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cr(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hkm, str2);
                    if (RecordVideoActivity.this.hjP != null) {
                        RecordVideoActivity.this.hjP.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void uC(String str) {
                    if (RecordVideoActivity.this.hjP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hjP.b(stickerItem);
                        if (RecordVideoActivity.this.him != null) {
                            RecordVideoActivity.this.him.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hjP != null) {
                        RecordVideoActivity.this.hjP.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(d.j.sticker_download_error);
                    }
                    recordVideoActivity.ab(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bAr() {
                    if (RecordVideoActivity.this.hjP != null) {
                        RecordVideoActivity.this.hjP.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hkl.bDn();
        if (this.hjP != null && this.hkk) {
            bBM();
        }
        if (this.gOY != null) {
            this.gOY.qq("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.him.onPause();
        if (this.hjP != null) {
            if (this.hie != null && this.hie.getStatus() == 6) {
                this.hjP.stopRecord();
                bDf();
            }
            if (this.hie != null && this.hie.isRecording()) {
                this.hjP.stopRecord();
            }
        }
        if (this.hkn != null) {
            this.hkn.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hie == null || this.hie.getStatus() != 7) {
            if (this.hie != null && this.hie.getStatus() == 6) {
                if (this.hjP != null) {
                    this.hjP.stopRecord();
                }
                bDf();
            } else if (this.hie.onBackPressed()) {
                finish();
            } else {
                if (this.hjU == null) {
                    this.hjU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hjU.cf(d.j.video_quit_confirm);
                    this.hjU.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hjU.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hjU.au(true);
                    this.hjU.b(getPageContext());
                }
                this.hjU.xf();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hkb.setVisibility(4);
        if (view == this.dZM) {
            onBackPressed();
        } else if (view == this.hjR) {
            if (this.hie.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.him.bCB();
            bCW();
        } else if (view == this.hjS) {
            if (this.hie.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hjS.setOnClickListener(null);
            this.him.bCD();
            if (this.him.bCE() && this.him.bCC()) {
                this.him.bCB();
            }
            bCW();
            this.hjS.setOnClickListener(this);
        } else if (view == this.hjT) {
            bCY();
        }
    }

    private void bCW() {
        if (this.him.bCE()) {
            this.hjR.setVisibility(8);
        } else {
            this.hjR.setVisibility(0);
        }
        if (this.him.bCC()) {
            this.hjR.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hjR.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bCX() {
        return this.hjV;
    }

    public void bCY() {
        this.hkb.setVisibility(4);
        if (this.hie.getStatus() != 6) {
            this.hie.setStatus(6);
            bDd();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hke == null) {
                this.hke = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hke.setDuration(500L);
                this.hke.setRepeatCount(5);
                this.hke.setRepeatMode(2);
                this.hke.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hke.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hie.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hjW.setVisibility(0);
                        RecordVideoActivity.this.hjW.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hjW.setVisibility(8);
                    if (RecordVideoActivity.this.hie.getStatus() == 6) {
                        RecordVideoActivity.this.hjP.bDq();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hie.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hjW.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hjW.setText("");
                        }
                    }
                }
            });
            this.hjW.setAnimation(this.hke);
            this.hke.startNow();
            this.hjP.bCY();
            if (this.hkn != null) {
                this.hkn.bCS();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bCZ() {
        if (this.hie.getStatus() == 1) {
            this.hkb.setVisibility(4);
            if (this.hie.getStatus() != 6) {
                this.hjP.bCZ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDa() {
        this.hkb.setVisibility(4);
        if (this.hie.getStatus() != 6) {
            this.hjP.bDa();
            if (this.hjP.bDu()) {
                bCU();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDb() {
        this.hkb.setVisibility(4);
        if (this.hie.getStatus() != 6) {
            this.hjP.bDb();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDc() {
        this.hkb.setVisibility(4);
        if (this.hie.getStatus() != 6) {
            this.hjP.bDc();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDd() {
        this.hkj = true;
        if (this.hkd != null && this.hkd.isRunning()) {
            this.hkd.cancel();
        }
        if (this.hkc == null) {
            this.hkc = new AnimatorSet();
            this.hkc.playTogether(ObjectAnimator.ofFloat(this.hjQ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hjX, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hko, "alpha", 1.0f, 0.0f));
            this.hkc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlR) {
                        RecordVideoActivity.this.hjQ.setVisibility(8);
                        RecordVideoActivity.this.hjX.setVisibility(8);
                        RecordVideoActivity.this.hko.setVisibility(8);
                    }
                }
            });
            this.hkc.setDuration(300L);
        }
        this.hkc.start();
        this.hjX.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bCS() {
        if (this.dCt == 2) {
            if (this.hkj) {
                this.hkj = false;
                if (this.hkn != null) {
                    this.hkn.bCS();
                }
            } else {
                return;
            }
        }
        if (this.hkc != null && this.hkc.isRunning()) {
            this.hkc.cancel();
        }
        if (this.hkd == null) {
            this.hkd = new AnimatorSet();
            this.hkd.playTogether(ObjectAnimator.ofFloat(this.hjQ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hjX, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hko, "alpha", 0.0f, 1.0f));
            this.hkd.setDuration(300L);
        }
        this.hjQ.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hjX.setVisibility(0);
        }
        if (this.hie.getStatus() == 1) {
            this.hko.setVisibility(0);
        }
        this.hkd.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDe() {
        if (this.him != null) {
            this.him.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void q(boolean z, String str) {
                    RecordVideoActivity.this.hie.setStatus(1);
                    RecordVideoActivity.this.bCS();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hkp != null && !w.z(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hkp)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hkp);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hkp = new ImageFileInfo();
                        RecordVideoActivity.this.hkp.setFilePath(str);
                        RecordVideoActivity.this.hkp.setTempFile(true);
                        RecordVideoActivity.this.hkp.setAlbumnId(null);
                        RecordVideoActivity.this.hkp.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hkp);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hki, RecordVideoActivity.this.hkh)));
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
    public void bDf() {
        this.hke.cancel();
        this.hke.setAnimationListener(null);
        this.hjW.clearAnimation();
        this.hjW.setVisibility(8);
        if (this.hkn != null) {
            this.hkn.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDg() {
        btu();
    }

    private void btu() {
        if (this.hkf != null) {
            this.hkf.cancel();
        }
        if (this.hkg == null) {
            this.hkg = ObjectAnimator.ofFloat(this.hko, "alpha", 1.0f, 0.0f);
            this.hkg.setDuration(500L);
            this.hkg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlR) {
                        RecordVideoActivity.this.hko.setVisibility(8);
                    }
                }
            });
        }
        this.hkg.start();
    }

    private void btt() {
        if (this.hkg != null) {
            this.hkg.cancel();
        }
        if (this.hkf == null) {
            this.hkf = ObjectAnimator.ofFloat(this.hko, "alpha", 0.0f, 1.0f);
            this.hkf.setDuration(500L);
        }
        this.hko.setVisibility(0);
        this.hkf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDh() {
        this.hjX.reset();
        if (this.hie.getStatus() == 1) {
            btt();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDi() {
        if (this.hjZ.getVisibility() != 0) {
            this.hjP.bDp();
            this.hie.setStatus(8);
            bCS();
            if (this.him.hiU != null && this.him.hiU.size() > 0) {
                this.hjZ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hkt = 50;
        final int hku = 1;
        Handler hkv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hka.aG(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bDm();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bDm() {
            this.hkv.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bDm();
            boolean z = RecordVideoActivity.this.hkn == null || TextUtils.isEmpty(RecordVideoActivity.this.hkn.bCR()) || !new File(RecordVideoActivity.this.hkn.bCR()).exists();
            if (RecordVideoActivity.this.him.hiU.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCe().a(RecordVideoActivity.this.him.hiU, RecordVideoActivity.this.him.bCv(), z);
            }
            File file = new File(RecordVideoActivity.this.him.hiU.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.him.bCv()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCe().a(RecordVideoActivity.this.him.hiU, RecordVideoActivity.this.him.bCv(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hjP.bDv();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bCT();
                    RecordVideoActivity.this.uS(102);
                    RecordVideoActivity.this.hjZ.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bCT();
                RecordVideoActivity.this.uS(102);
                RecordVideoActivity.this.hjZ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hjZ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ab(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hka.aG(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hjP == null || w.z(this.hjP.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hjP.getChoosedBeautyList()) {
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
        if (this.hjP == null || w.z(this.hjP.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hjP.getChoosedFilterList()) {
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
        if (this.hjP == null || w.z(this.hjP.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hjP.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDj() {
        this.hkb.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDk() {
        this.hkb.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDl() {
        if (this.hie.getStatus() == 1) {
            this.hko.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.him != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.him.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hjX.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hjX.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.him.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.af(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hie.getStatus() == 1) {
                            anVar.r("obj_type", 1);
                        } else {
                            anVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hjX.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hjX.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hkn.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hjX.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hjX.setViewChoosed(0, true);
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
            this.hkm = stickerItem;
            this.hkl.vd(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.him != null) {
                    this.him.setSticker(null);
                    this.hkr = false;
                }
                if (this.hjP != null) {
                    this.hjP.setDownLoadSticker(null);
                }
                this.hjY.setVisibility(8);
                this.hjX.setViewChoosed(1, false);
                return;
            }
            String va = this.hkl.va(stickerItem.resource);
            if (!StringUtils.isNull(va)) {
                a(stickerItem, va);
                if (this.hjP != null) {
                    this.hjP.setDownLoadSticker(null);
                }
            } else {
                if (this.hjP != null) {
                    this.hjP.setDownLoadSticker(stickerItem);
                }
                this.hkl.vb(stickerItem.resource);
            }
            this.hjX.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.him != null) {
                this.him.setSticker(stickerItem);
                this.hkr = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hjY.setText(stickerItem.desc);
                this.hjY.setVisibility(0);
                this.hjY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hjY.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hjY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bR(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.p(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hjP.getLayoutParams();
            layoutParams.height = i4;
            this.hjP.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uL = com.baidu.tieba.video.editvideo.model.a.bBd().uL(stringExtra);
                if (this.hkn != null && !TextUtils.isEmpty(uL)) {
                    this.hkn.cs(uL, stringExtra2);
                    this.hjP.bCj();
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
        if (this.hie.getStatus() == 8) {
            this.hjP.bDo();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void na(boolean z) {
        if (this.hie != null && (this.hie.getStatus() == 1 || this.hie.getStatus() == 3 || this.hie.getStatus() == 4)) {
            if (!z && this.hkr) {
                this.hjV.afl();
                return;
            } else {
                this.hjV.afm();
                return;
            }
        }
        this.hjV.afm();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void F(int i, boolean z) {
        int i2 = 1;
        if (this.dCt != i) {
            switch (i) {
                case 1:
                    if (this.hkn != null) {
                        this.hkn.bkr();
                    }
                    this.him.setFilter("nature");
                    this.hjX.setViewChoosed(0, false);
                    this.hjX.setViewChoosed(3, false);
                    this.hjP.uU(1);
                    this.hjX.setViewVisibility(0, 8);
                    this.hjX.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hjX.setViewVisibility(0, 0);
                    this.hjX.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dCt = i;
            this.hjP.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCQ() {
        if (this.hie.getStatus() == 1 && !this.hjP.bDt()) {
            F(1, true);
            this.hko.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCP() {
        if (this.hie.getStatus() == 1 && !this.hjP.bDt()) {
            F(2, true);
            this.hko.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        if (this.gOY != null) {
            this.gOY.ac(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.gOY != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gOY.ab(i, str);
        }
    }
}
