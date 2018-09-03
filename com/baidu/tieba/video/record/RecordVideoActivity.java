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
import com.baidu.tieba.f;
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
    private int dCq;
    private final CustomMessageListener dDY;
    private ImageView dZJ;
    private com.baidu.tieba.j.h gPa;
    private String hdk;
    private SelectMusicModel hdo;
    private b.a hgH;
    private b hiX;
    private i hif;
    protected h hin;
    private RecordLayout hjP;
    private VideoControllerLayout hjQ;
    private RelativeLayout hjR;
    private ImageView hjS;
    private ImageView hjT;
    private ImageView hjU;
    private com.baidu.tbadk.core.dialog.a hjV;
    private PreviewViewContainer hjW;
    private TextView hjX;
    private VideoEffectButtonLayout hjY;
    private TextView hjZ;
    private View hka;
    private RoundProgressBar hkb;
    private TextView hkc;
    private AnimatorSet hkd;
    private AnimatorSet hke;
    private ScaleAnimation hkf;
    private ObjectAnimator hkg;
    private ObjectAnimator hkh;
    private int hki;
    private ForumWriteData hkj;
    private boolean hkk;
    private boolean hkl = true;
    private l hkm;
    private StickerItem hkn;
    protected j hko;
    private RecordTabLayout hkp;
    private ImageFileInfo hkq;
    private HttpMessageListener hkr;
    private boolean hks;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.gPa = lVar.aVW();
        }
        if (this.gPa != null) {
            this.gPa.aVB();
        }
        this.hgH = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dI(List<com.baidu.tieba.video.localvideo.d> list) {
                if (w.z(list)) {
                    if (RecordVideoActivity.this.hjQ != null) {
                        RecordVideoActivity.this.hjQ.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hjQ != null) {
                    RecordVideoActivity.this.hjQ.setHasLocalVideo(true);
                    RecordVideoActivity.this.hkl = false;
                }
            }
        };
        this.hkr = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hjQ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hjQ.setStickerItems(list);
                    }
                }
            }
        };
        this.dDY = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bCV() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hin.hdq);
        videoInfo.setVideoDuration(this.hif.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hin.hdq).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hkj.writeCallFrom, this.hkj == null ? "" : this.hkj.forumName, this.hkj == null ? "" : this.hkj.forumId, this.hdk, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hko != null) {
            this.hko.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gPa != null) {
            this.gPa.aVE();
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
        if (this.hif != null && this.hif.isRecording()) {
            this.hif.stopRecord();
        }
        if (this.hdo != null) {
            this.hdo.cancelLoadData();
        }
        if (this.gPa != null) {
            this.gPa.qt("record");
        }
        com.baidu.tbadk.core.util.l.r(new File(com.baidu.tieba.video.c.hbE));
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
        setContentView(f.h.record_activity);
        this.hki = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hkj = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hdk = getIntent().getStringExtra("video_title");
        initUI();
        this.hdo = new SelectMusicModel(getPageContext(), this.hjQ);
        this.hdo.bBl();
        this.hko = new j(this);
        this.hko.b(this.hdo);
        this.hif.a(this.hko);
        registerListener(this.hkr);
        registerListener(this.dDY);
        bCW();
    }

    private void bCW() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bBO() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hgH);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hjP = (RecordLayout) findViewById(f.g.root_layout);
        this.hjP.setListener(this);
        this.hif = new i(this);
        this.hjQ = (VideoControllerLayout) findViewById(f.g.record_controller_layout);
        this.hjQ.setRecordController(this.hif);
        this.hjQ.setRecordControlListener(this);
        this.hjQ.setEffectChoosedListener(this);
        this.hjR = (RelativeLayout) findViewById(f.g.top_control_layout);
        this.dZJ = (ImageView) findViewById(f.g.close_page);
        this.dZJ.setOnClickListener(this);
        this.hjS = (ImageView) findViewById(f.g.flash_switch);
        this.hjS.setOnClickListener(this);
        this.hjT = (ImageView) findViewById(f.g.camera_switch);
        this.hjT.setOnClickListener(this);
        this.hjU = (ImageView) findViewById(f.g.count_down);
        this.hjU.setOnClickListener(this);
        this.hjW = (PreviewViewContainer) findViewById(f.g.video_surface_container);
        this.hin = new h(this);
        this.hin.a(this);
        this.hin.setFaceIdentifyStateListener(this);
        this.hin.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bCJ() {
                if (RecordVideoActivity.this.hjQ.bDv()) {
                    RecordVideoActivity.this.hjQ.a((m) null);
                }
            }
        });
        this.hjY = (VideoEffectButtonLayout) findViewById(f.g.layout_effect_button);
        this.hjY.setListener(this);
        this.hif.a(this.hjY);
        this.hjY.setViewChoosed(2, true);
        this.hjX = (TextView) findViewById(f.g.tv_count_down);
        this.hjZ = (TextView) findViewById(f.g.gesture_guide_tv);
        int aj = ((com.baidu.adp.lib.util.l.aj(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds150);
        if (this.hjX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hjX.getLayoutParams()).topMargin = aj;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hjY.setVisibility(8);
        }
        this.hka = findViewById(f.g.progress_layout);
        this.hkb = (RoundProgressBar) this.hka.findViewById(f.g.video_progress);
        this.hkc = (TextView) findViewById(f.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkc.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ah(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds38);
        this.hkc.setLayoutParams(layoutParams);
        this.hkp = (RecordTabLayout) findViewById(f.g.tab_layout);
        this.hkp.ar(1, getString(f.j.tab_photo));
        if (this.hki != 2 && this.hki != 3) {
            this.hkp.ar(2, getString(f.j.tab_record));
            this.hkp.setListener(this);
            this.hkp.setCurrentTab(2, false);
            F(2, false);
        } else {
            this.hkp.setShowIndicator(false);
            this.hkp.setCurrentTab(1, false);
            F(1, false);
        }
        bCX();
    }

    private void bCX() {
        if (com.baidu.tbadk.core.util.g.ye()) {
            this.mStatusBarView = findViewById(f.g.statusbar_view);
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
        this.hin.onResume();
        this.hiX = this.hin.bCA();
        if (this.hiX != null) {
            this.hiX.setRecordController(this.hif);
            this.hjW.setZoomHelper(this.hiX);
        }
        bCY();
        if (this.hkm == null) {
            this.hkm = new l();
            this.hkm.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cr(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hkn, str2);
                    if (RecordVideoActivity.this.hjQ != null) {
                        RecordVideoActivity.this.hjQ.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void uG(String str) {
                    if (RecordVideoActivity.this.hjQ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hjQ.b(stickerItem);
                        if (RecordVideoActivity.this.hin != null) {
                            RecordVideoActivity.this.hin.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hjQ != null) {
                        RecordVideoActivity.this.hjQ.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(f.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(f.j.sticker_download_error);
                    }
                    recordVideoActivity.ab(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bAt() {
                    if (RecordVideoActivity.this.hjQ != null) {
                        RecordVideoActivity.this.hjQ.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hkm.bDp();
        if (this.hjQ != null && this.hkl) {
            bBO();
        }
        if (this.gPa != null) {
            this.gPa.qs("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hin.onPause();
        if (this.hjQ != null) {
            if (this.hif != null && this.hif.getStatus() == 6) {
                this.hjQ.stopRecord();
                bDh();
            }
            if (this.hif != null && this.hif.isRecording()) {
                this.hjQ.stopRecord();
            }
        }
        if (this.hko != null) {
            this.hko.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hif == null || this.hif.getStatus() != 7) {
            if (this.hif != null && this.hif.getStatus() == 6) {
                if (this.hjQ != null) {
                    this.hjQ.stopRecord();
                }
                bDh();
            } else if (this.hif.onBackPressed()) {
                finish();
            } else {
                if (this.hjV == null) {
                    this.hjV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hjV.cf(f.j.video_quit_confirm);
                    this.hjV.a(f.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hjV.b(f.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hjV.av(true);
                    this.hjV.b(getPageContext());
                }
                this.hjV.xe();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hkc.setVisibility(4);
        if (view == this.dZJ) {
            onBackPressed();
        } else if (view == this.hjS) {
            if (this.hif.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hin.bCD();
            bCY();
        } else if (view == this.hjT) {
            if (this.hif.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hjT.setOnClickListener(null);
            this.hin.bCF();
            if (this.hin.bCG() && this.hin.bCE()) {
                this.hin.bCD();
            }
            bCY();
            this.hjT.setOnClickListener(this);
        } else if (view == this.hjU) {
            bDa();
        }
    }

    private void bCY() {
        if (this.hin.bCG()) {
            this.hjS.setVisibility(8);
        } else {
            this.hjS.setVisibility(0);
        }
        if (this.hin.bCE()) {
            this.hjS.setImageResource(f.C0146f.icon_video_flashon_n);
        } else {
            this.hjS.setImageResource(f.C0146f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bCZ() {
        return this.hjW;
    }

    public void bDa() {
        this.hkc.setVisibility(4);
        if (this.hif.getStatus() != 6) {
            this.hif.setStatus(6);
            bDf();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hkf == null) {
                this.hkf = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hkf.setDuration(500L);
                this.hkf.setRepeatCount(5);
                this.hkf.setRepeatMode(2);
                this.hkf.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hkf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hif.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hjX.setVisibility(0);
                        RecordVideoActivity.this.hjX.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hjX.setVisibility(8);
                    if (RecordVideoActivity.this.hif.getStatus() == 6) {
                        RecordVideoActivity.this.hjQ.bDs();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hif.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hjX.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hjX.setText("");
                        }
                    }
                }
            });
            this.hjX.setAnimation(this.hkf);
            this.hkf.startNow();
            this.hjQ.bDa();
            if (this.hko != null) {
                this.hko.bCU();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDb() {
        if (this.hif.getStatus() == 1) {
            this.hkc.setVisibility(4);
            if (this.hif.getStatus() != 6) {
                this.hjQ.bDb();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDc() {
        this.hkc.setVisibility(4);
        if (this.hif.getStatus() != 6) {
            this.hjQ.bDc();
            if (this.hjQ.bDw()) {
                bCW();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDd() {
        this.hkc.setVisibility(4);
        if (this.hif.getStatus() != 6) {
            this.hjQ.bDd();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDe() {
        this.hkc.setVisibility(4);
        if (this.hif.getStatus() != 6) {
            this.hjQ.bDe();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDf() {
        this.hkk = true;
        if (this.hke != null && this.hke.isRunning()) {
            this.hke.cancel();
        }
        if (this.hkd == null) {
            this.hkd = new AnimatorSet();
            this.hkd.playTogether(ObjectAnimator.ofFloat(this.hjR, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hjY, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hkp, "alpha", 1.0f, 0.0f));
            this.hkd.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlS) {
                        RecordVideoActivity.this.hjR.setVisibility(8);
                        RecordVideoActivity.this.hjY.setVisibility(8);
                        RecordVideoActivity.this.hkp.setVisibility(8);
                    }
                }
            });
            this.hkd.setDuration(300L);
        }
        this.hkd.start();
        this.hjY.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bCU() {
        if (this.dCq == 2) {
            if (this.hkk) {
                this.hkk = false;
                if (this.hko != null) {
                    this.hko.bCU();
                }
            } else {
                return;
            }
        }
        if (this.hkd != null && this.hkd.isRunning()) {
            this.hkd.cancel();
        }
        if (this.hke == null) {
            this.hke = new AnimatorSet();
            this.hke.playTogether(ObjectAnimator.ofFloat(this.hjR, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hjY, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hkp, "alpha", 0.0f, 1.0f));
            this.hke.setDuration(300L);
        }
        this.hjR.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hjY.setVisibility(0);
        }
        if (this.hif.getStatus() == 1) {
            this.hkp.setVisibility(0);
        }
        this.hke.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDg() {
        if (this.hin != null) {
            this.hin.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void p(boolean z, String str) {
                    RecordVideoActivity.this.hif.setStatus(1);
                    RecordVideoActivity.this.bCU();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hkq != null && !w.z(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hkq)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hkq);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hkq = new ImageFileInfo();
                        RecordVideoActivity.this.hkq.setFilePath(str);
                        RecordVideoActivity.this.hkq.setTempFile(true);
                        RecordVideoActivity.this.hkq.setAlbumnId(null);
                        RecordVideoActivity.this.hkq.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hkq);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hkj, RecordVideoActivity.this.hki)));
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
    public void bDh() {
        this.hkf.cancel();
        this.hkf.setAnimationListener(null);
        this.hjX.clearAnimation();
        this.hjX.setVisibility(8);
        if (this.hko != null) {
            this.hko.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDi() {
        btv();
    }

    private void btv() {
        if (this.hkg != null) {
            this.hkg.cancel();
        }
        if (this.hkh == null) {
            this.hkh = ObjectAnimator.ofFloat(this.hkp, "alpha", 1.0f, 0.0f);
            this.hkh.setDuration(500L);
            this.hkh.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hlS) {
                        RecordVideoActivity.this.hkp.setVisibility(8);
                    }
                }
            });
        }
        this.hkh.start();
    }

    private void btu() {
        if (this.hkh != null) {
            this.hkh.cancel();
        }
        if (this.hkg == null) {
            this.hkg = ObjectAnimator.ofFloat(this.hkp, "alpha", 0.0f, 1.0f);
            this.hkg.setDuration(500L);
        }
        this.hkp.setVisibility(0);
        this.hkg.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDj() {
        this.hjY.reset();
        if (this.hif.getStatus() == 1) {
            btu();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDk() {
        if (this.hka.getVisibility() != 0) {
            this.hjQ.bDr();
            this.hif.setStatus(8);
            bCU();
            if (this.hin.hiV != null && this.hin.hiV.size() > 0) {
                this.hka.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hku = 50;
        final int hkv = 1;
        Handler hkw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hkb.aF(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bDo();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bDo() {
            this.hkw.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bDo();
            boolean z = RecordVideoActivity.this.hko == null || TextUtils.isEmpty(RecordVideoActivity.this.hko.bCT()) || !new File(RecordVideoActivity.this.hko.bCT()).exists();
            if (RecordVideoActivity.this.hin.hiV.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCg().a(RecordVideoActivity.this.hin.hiV, RecordVideoActivity.this.hin.bCx(), z);
            }
            File file = new File(RecordVideoActivity.this.hin.hiV.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hin.bCx()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCg().a(RecordVideoActivity.this.hin.hiV, RecordVideoActivity.this.hin.bCx(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hjQ.bDx();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bCV();
                    RecordVideoActivity.this.uS(102);
                    RecordVideoActivity.this.hka.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bCV();
                RecordVideoActivity.this.uS(102);
                RecordVideoActivity.this.hka.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(f.j.mix_fail));
                RecordVideoActivity.this.hka.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ab(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hkb.aF(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hjQ == null || w.z(this.hjQ.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hjQ.getChoosedBeautyList()) {
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
        if (this.hjQ == null || w.z(this.hjQ.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hjQ.getChoosedFilterList()) {
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
        if (this.hjQ == null || w.z(this.hjQ.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hjQ.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDl() {
        this.hkc.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDm() {
        this.hkc.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDn() {
        if (this.hif.getStatus() == 1) {
            this.hkp.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hin != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hin.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hjY.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hjY.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hin.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.ae(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hif.getStatus() == 1) {
                            anVar.r("obj_type", 1);
                        } else {
                            anVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hjY.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hjY.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hko.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hjY.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hjY.setViewChoosed(0, true);
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
            this.hkn = stickerItem;
            this.hkm.vh(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hin != null) {
                    this.hin.setSticker(null);
                    this.hks = false;
                }
                if (this.hjQ != null) {
                    this.hjQ.setDownLoadSticker(null);
                }
                this.hjZ.setVisibility(8);
                this.hjY.setViewChoosed(1, false);
                return;
            }
            String ve = this.hkm.ve(stickerItem.resource);
            if (!StringUtils.isNull(ve)) {
                a(stickerItem, ve);
                if (this.hjQ != null) {
                    this.hjQ.setDownLoadSticker(null);
                }
            } else {
                if (this.hjQ != null) {
                    this.hjQ.setDownLoadSticker(stickerItem);
                }
                this.hkm.vf(stickerItem.resource);
            }
            this.hjY.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hin != null) {
                this.hin.setSticker(stickerItem);
                this.hks = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hjZ.setText(stickerItem.desc);
                this.hjZ.setVisibility(0);
                this.hjZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hjZ.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hjZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bR(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(f.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hjQ.getLayoutParams();
            layoutParams.height = i4;
            this.hjQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uP = com.baidu.tieba.video.editvideo.model.a.bBf().uP(stringExtra);
                if (this.hko != null && !TextUtils.isEmpty(uP)) {
                    this.hko.cs(uP, stringExtra2);
                    this.hjQ.bCl();
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
        if (this.hif.getStatus() == 8) {
            this.hjQ.bDq();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void na(boolean z) {
        if (this.hif != null && (this.hif.getStatus() == 1 || this.hif.getStatus() == 3 || this.hif.getStatus() == 4)) {
            if (!z && this.hks) {
                this.hjW.afn();
                return;
            } else {
                this.hjW.afo();
                return;
            }
        }
        this.hjW.afo();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void F(int i, boolean z) {
        int i2 = 1;
        if (this.dCq != i) {
            switch (i) {
                case 1:
                    if (this.hko != null) {
                        this.hko.bko();
                    }
                    this.hin.setFilter("nature");
                    this.hjY.setViewChoosed(0, false);
                    this.hjY.setViewChoosed(3, false);
                    this.hjQ.uU(1);
                    this.hjY.setViewVisibility(0, 8);
                    this.hjY.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hjY.setViewVisibility(0, 0);
                    this.hjY.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dCq = i;
            this.hjQ.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCS() {
        if (this.hif.getStatus() == 1 && !this.hjQ.bDv()) {
            F(1, true);
            this.hkp.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCR() {
        if (this.hif.getStatus() == 1 && !this.hjQ.bDv()) {
            F(2, true);
            this.hkp.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        if (this.gPa != null) {
            this.gPa.ac(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.gPa != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gPa.ab(i, str);
        }
    }
}
