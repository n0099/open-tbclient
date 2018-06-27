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
    private final CustomMessageListener dBp;
    private ImageView dVU;
    private int dzH;
    private com.baidu.tieba.j.h gOa;
    private String hbW;
    private SelectMusicModel hca;
    private b.a hfr;
    private i hgP;
    protected h hgX;
    private b hhH;
    private RecordLayout hiA;
    private VideoControllerLayout hiB;
    private RelativeLayout hiC;
    private ImageView hiD;
    private ImageView hiE;
    private ImageView hiF;
    private com.baidu.tbadk.core.dialog.a hiG;
    private PreviewViewContainer hiH;
    private TextView hiI;
    private VideoEffectButtonLayout hiJ;
    private TextView hiK;
    private View hiL;
    private RoundProgressBar hiM;
    private TextView hiN;
    private AnimatorSet hiO;
    private AnimatorSet hiP;
    private ScaleAnimation hiQ;
    private ObjectAnimator hiR;
    private ObjectAnimator hiS;
    private int hiT;
    private ForumWriteData hiU;
    private boolean hiV;
    private boolean hiW = true;
    private l hiX;
    private StickerItem hiY;
    protected j hiZ;
    private RecordTabLayout hja;
    private ImageFileInfo hjb;
    private HttpMessageListener hjc;
    private boolean hjd;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gOa = kVar.aXF();
        }
        if (this.gOa != null) {
            this.gOa.aXm();
        }
        this.hfr = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dM(List<com.baidu.tieba.video.localvideo.d> list) {
                if (w.A(list)) {
                    if (RecordVideoActivity.this.hiB != null) {
                        RecordVideoActivity.this.hiB.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hiB != null) {
                    RecordVideoActivity.this.hiB.setHasLocalVideo(true);
                    RecordVideoActivity.this.hiW = false;
                }
            }
        };
        this.hjc = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hiB != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hiB.setStickerItems(list);
                    }
                }
            }
        };
        this.dBp = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bEj() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hgX.hcc);
        videoInfo.setVideoDuration(this.hgP.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hgX.hcc).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hiU.writeCallFrom, this.hiU == null ? "" : this.hiU.forumName, this.hiU == null ? "" : this.hiU.forumId, this.hbW, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hiZ != null) {
            this.hiZ.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gOa != null) {
            this.gOa.aXp();
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
        if (this.hgP != null && this.hgP.isRecording()) {
            this.hgP.stopRecord();
        }
        if (this.hca != null) {
            this.hca.cancelLoadData();
        }
        if (this.gOa != null) {
            this.gOa.qy("record");
        }
        com.baidu.tbadk.core.util.l.r(new File(com.baidu.tieba.video.b.haq));
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
        this.hiT = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hiU = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hbW = getIntent().getStringExtra("video_title");
        initUI();
        this.hca = new SelectMusicModel(getPageContext(), this.hiB);
        this.hca.bCy();
        this.hiZ = new j(this);
        this.hiZ.b(this.hca);
        this.hgP.a(this.hiZ);
        bEk();
        registerListener(this.hjc);
        registerListener(this.dBp);
    }

    private void bEk() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bDb() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hfr);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hiA = (RecordLayout) findViewById(d.g.root_layout);
        this.hiA.setListener(this);
        this.hgP = new i(this);
        this.hiB = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hiB.setRecordController(this.hgP);
        this.hiB.setRecordControlListener(this);
        this.hiB.setEffectChoosedListener(this);
        this.hiC = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dVU = (ImageView) findViewById(d.g.close_page);
        this.dVU.setOnClickListener(this);
        this.hiD = (ImageView) findViewById(d.g.flash_switch);
        this.hiD.setOnClickListener(this);
        this.hiE = (ImageView) findViewById(d.g.camera_switch);
        this.hiE.setOnClickListener(this);
        this.hiF = (ImageView) findViewById(d.g.count_down);
        this.hiF.setOnClickListener(this);
        this.hiH = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.hgX = new h(this);
        this.hgX.a(this);
        this.hgX.setFaceIdentifyStateListener(this);
        this.hgX.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bDV() {
                if (RecordVideoActivity.this.hiB.bEJ()) {
                    RecordVideoActivity.this.hiB.a((m) null);
                }
            }
        });
        this.hiJ = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hiJ.setListener(this);
        this.hgP.a(this.hiJ);
        this.hiJ.setViewChoosed(2, true);
        this.hiI = (TextView) findViewById(d.g.tv_count_down);
        this.hiK = (TextView) findViewById(d.g.gesture_guide_tv);
        int aj = ((com.baidu.adp.lib.util.l.aj(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds150);
        if (this.hiI.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hiI.getLayoutParams()).topMargin = aj;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hiJ.setVisibility(8);
        }
        this.hiL = findViewById(d.g.progress_layout);
        this.hiM = (RoundProgressBar) this.hiL.findViewById(d.g.video_progress);
        this.hiN = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hiN.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ah(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds38);
        this.hiN.setLayoutParams(layoutParams);
        this.hja = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hja.ao(1, getString(d.k.tab_photo));
        if (this.hiT != 2 && this.hiT != 3) {
            this.hja.ao(2, getString(d.k.tab_record));
            this.hja.setListener(this);
            this.hja.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hja.setShowIndicator(false);
            this.hja.setCurrentTab(1, false);
            G(1, false);
        }
        bEl();
    }

    private void bEl() {
        if (com.baidu.tbadk.core.util.g.yn()) {
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
        this.hgX.onResume();
        this.hhH = this.hgX.bDM();
        if (this.hhH != null) {
            this.hhH.setRecordController(this.hgP);
            this.hiH.setZoomHelper(this.hhH);
        }
        bEm();
        if (this.hiX == null) {
            this.hiX = new l();
            this.hiX.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cu(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hiY, str2);
                    if (RecordVideoActivity.this.hiB != null) {
                        RecordVideoActivity.this.hiB.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void uE(String str) {
                    if (RecordVideoActivity.this.hiB != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hiB.b(stickerItem);
                        if (RecordVideoActivity.this.hgX != null) {
                            RecordVideoActivity.this.hgX.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hiB != null) {
                        RecordVideoActivity.this.hiB.setDownLoadSticker(null);
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
                    recordVideoActivity.Z(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bBG() {
                    if (RecordVideoActivity.this.hiB != null) {
                        RecordVideoActivity.this.hiB.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hiX.bED();
        if (this.hiB != null && this.hiW) {
            bDb();
        }
        if (this.gOa != null) {
            this.gOa.qx("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hgX.onPause();
        if (this.hiB != null) {
            if (this.hgP != null && this.hgP.getStatus() == 6) {
                this.hiB.stopRecord();
                bEv();
            }
            if (this.hgP != null && this.hgP.isRecording()) {
                this.hiB.stopRecord();
            }
        }
        if (this.hiZ != null) {
            this.hiZ.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hgP == null || this.hgP.getStatus() != 7) {
            if (this.hgP != null && this.hgP.getStatus() == 6) {
                if (this.hiB != null) {
                    this.hiB.stopRecord();
                }
                bEv();
            } else if (this.hgP.onBackPressed()) {
                finish();
            } else {
                if (this.hiG == null) {
                    this.hiG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hiG.cd(d.k.video_quit_confirm);
                    this.hiG.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hiG.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hiG.aw(true);
                    this.hiG.b(getPageContext());
                }
                this.hiG.xn();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hiN.setVisibility(4);
        if (view == this.dVU) {
            onBackPressed();
        } else if (view == this.hiD) {
            if (this.hgP.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hgX.bDP();
            bEm();
        } else if (view == this.hiE) {
            if (this.hgP.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hiE.setOnClickListener(null);
            this.hgX.bDR();
            if (this.hgX.bDS() && this.hgX.bDQ()) {
                this.hgX.bDP();
            }
            bEm();
            this.hiE.setOnClickListener(this);
        } else if (view == this.hiF) {
            bEo();
        }
    }

    private void bEm() {
        if (this.hgX.bDS()) {
            this.hiD.setVisibility(8);
        } else {
            this.hiD.setVisibility(0);
        }
        if (this.hgX.bDQ()) {
            this.hiD.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hiD.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bEn() {
        return this.hiH;
    }

    public void bEo() {
        this.hiN.setVisibility(4);
        if (this.hgP.getStatus() != 6) {
            this.hgP.setStatus(6);
            bEt();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hiQ == null) {
                this.hiQ = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hiQ.setDuration(500L);
                this.hiQ.setRepeatCount(5);
                this.hiQ.setRepeatMode(2);
                this.hiQ.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hiQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hgP.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hiI.setVisibility(0);
                        RecordVideoActivity.this.hiI.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hiI.setVisibility(8);
                    if (RecordVideoActivity.this.hgP.getStatus() == 6) {
                        RecordVideoActivity.this.hiB.bEG();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hgP.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hiI.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hiI.setText("");
                        }
                    }
                }
            });
            this.hiI.setAnimation(this.hiQ);
            this.hiQ.startNow();
            this.hiB.bEo();
            if (this.hiZ != null) {
                this.hiZ.bEi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEp() {
        if (this.hgP.getStatus() == 1) {
            this.hiN.setVisibility(4);
            if (this.hgP.getStatus() != 6) {
                this.hiB.bEp();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEq() {
        this.hiN.setVisibility(4);
        if (this.hgP.getStatus() != 6) {
            this.hiB.bEq();
            if (this.hiB.bEK()) {
                bEk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEr() {
        this.hiN.setVisibility(4);
        if (this.hgP.getStatus() != 6) {
            this.hiB.bEr();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEs() {
        this.hiN.setVisibility(4);
        if (this.hgP.getStatus() != 6) {
            this.hiB.bEs();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEt() {
        this.hiV = true;
        if (this.hiP != null && this.hiP.isRunning()) {
            this.hiP.cancel();
        }
        if (this.hiO == null) {
            this.hiO = new AnimatorSet();
            this.hiO.playTogether(ObjectAnimator.ofFloat(this.hiC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hiJ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hja, "alpha", 1.0f, 0.0f));
            this.hiO.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hkD) {
                        RecordVideoActivity.this.hiC.setVisibility(8);
                        RecordVideoActivity.this.hiJ.setVisibility(8);
                        RecordVideoActivity.this.hja.setVisibility(8);
                    }
                }
            });
            this.hiO.setDuration(300L);
        }
        this.hiO.start();
        this.hiJ.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEi() {
        if (this.dzH == 2) {
            if (this.hiV) {
                this.hiV = false;
                if (this.hiZ != null) {
                    this.hiZ.bEi();
                }
            } else {
                return;
            }
        }
        if (this.hiO != null && this.hiO.isRunning()) {
            this.hiO.cancel();
        }
        if (this.hiP == null) {
            this.hiP = new AnimatorSet();
            this.hiP.playTogether(ObjectAnimator.ofFloat(this.hiC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hiJ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hja, "alpha", 0.0f, 1.0f));
            this.hiP.setDuration(300L);
        }
        this.hiC.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hiJ.setVisibility(0);
        }
        if (this.hgP.getStatus() == 1) {
            this.hja.setVisibility(0);
        }
        this.hiP.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEu() {
        if (this.hgX != null) {
            this.hgX.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void q(boolean z, String str) {
                    RecordVideoActivity.this.hgP.setStatus(1);
                    RecordVideoActivity.this.bEi();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hjb != null && !w.A(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hjb)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hjb);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hjb = new ImageFileInfo();
                        RecordVideoActivity.this.hjb.setFilePath(str);
                        RecordVideoActivity.this.hjb.setTempFile(true);
                        RecordVideoActivity.this.hjb.setAlbumnId(null);
                        RecordVideoActivity.this.hjb.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hjb);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hiU, RecordVideoActivity.this.hiT)));
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
    public void bEv() {
        this.hiQ.cancel();
        this.hiQ.setAnimationListener(null);
        this.hiI.clearAnimation();
        this.hiI.setVisibility(8);
        if (this.hiZ != null) {
            this.hiZ.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEw() {
        buR();
    }

    private void buR() {
        if (this.hiR != null) {
            this.hiR.cancel();
        }
        if (this.hiS == null) {
            this.hiS = ObjectAnimator.ofFloat(this.hja, "alpha", 1.0f, 0.0f);
            this.hiS.setDuration(500L);
            this.hiS.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hkD) {
                        RecordVideoActivity.this.hja.setVisibility(8);
                    }
                }
            });
        }
        this.hiS.start();
    }

    private void buQ() {
        if (this.hiS != null) {
            this.hiS.cancel();
        }
        if (this.hiR == null) {
            this.hiR = ObjectAnimator.ofFloat(this.hja, "alpha", 0.0f, 1.0f);
            this.hiR.setDuration(500L);
        }
        this.hja.setVisibility(0);
        this.hiR.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEx() {
        this.hiJ.reset();
        if (this.hgP.getStatus() == 1) {
            buQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEy() {
        if (this.hiL.getVisibility() != 0) {
            this.hiB.bEF();
            this.hgP.setStatus(8);
            bEi();
            if (this.hgX.hhF != null && this.hgX.hhF.size() > 0) {
                this.hiL.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hjf = 50;
        final int hjg = 1;
        Handler hjh = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hiM.aF(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bEC();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bEC() {
            this.hjh.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bEC();
            boolean z = RecordVideoActivity.this.hiZ == null || TextUtils.isEmpty(RecordVideoActivity.this.hiZ.bEh()) || !new File(RecordVideoActivity.this.hiZ.bEh()).exists();
            if (RecordVideoActivity.this.hgX.hhF.size() > 1) {
                return com.baidu.tieba.video.meida.h.bDt().a(RecordVideoActivity.this.hgX.hhF, RecordVideoActivity.this.hgX.bDJ(), z);
            }
            File file = new File(RecordVideoActivity.this.hgX.hhF.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hgX.bDJ()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bDt().a(RecordVideoActivity.this.hgX.hhF, RecordVideoActivity.this.hgX.bDJ(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hiB.bEL();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bEj();
                    RecordVideoActivity.this.uT(102);
                    RecordVideoActivity.this.hiL.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bEj();
                RecordVideoActivity.this.uT(102);
                RecordVideoActivity.this.hiL.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.k.mix_fail));
                RecordVideoActivity.this.hiL.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.Z(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hiM.aF(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hiB == null || w.A(this.hiB.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hiB.getChoosedBeautyList()) {
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
        if (this.hiB == null || w.A(this.hiB.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hiB.getChoosedFilterList()) {
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
        if (this.hiB == null || w.A(this.hiB.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hiB.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEz() {
        this.hiN.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEA() {
        this.hiN.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEB() {
        if (this.hgP.getStatus() == 1) {
            this.hja.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hgX != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hgX.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hiJ.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hiJ.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hgX.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.ah(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hgP.getStatus() == 1) {
                            anVar.r("obj_type", 1);
                        } else {
                            anVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hiJ.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hiJ.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hiZ.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hiJ.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hiJ.setViewChoosed(0, true);
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
            this.hiY = stickerItem;
            this.hiX.ve(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hgX != null) {
                    this.hgX.setSticker(null);
                    this.hjd = false;
                }
                if (this.hiB != null) {
                    this.hiB.setDownLoadSticker(null);
                }
                this.hiK.setVisibility(8);
                this.hiJ.setViewChoosed(1, false);
                return;
            }
            String vc = this.hiX.vc(stickerItem.resource);
            if (!StringUtils.isNull(vc)) {
                a(stickerItem, vc);
                if (this.hiB != null) {
                    this.hiB.setDownLoadSticker(null);
                }
            } else {
                if (this.hiB != null) {
                    this.hiB.setDownLoadSticker(stickerItem);
                }
                this.hiX.vd(stickerItem.resource);
            }
            this.hiJ.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hgX != null) {
                this.hgX.setSticker(stickerItem);
                this.hjd = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hiK.setText(stickerItem.desc);
                this.hiK.setVisibility(0);
                this.hiK.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hiK.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hiK.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.p(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hiB.getLayoutParams();
            layoutParams.height = i4;
            this.hiB.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uN = com.baidu.tieba.video.editvideo.model.a.bCs().uN(stringExtra);
                if (this.hiZ != null && !TextUtils.isEmpty(uN)) {
                    this.hiZ.cv(uN, stringExtra2);
                    this.hiB.bDy();
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
        if (this.hgP.getStatus() == 8) {
            this.hiB.bEE();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void nn(boolean z) {
        if (this.hgP != null && (this.hgP.getStatus() == 1 || this.hgP.getStatus() == 3 || this.hgP.getStatus() == 4)) {
            if (!z && this.hjd) {
                this.hiH.bDW();
                return;
            } else {
                this.hiH.bDX();
                return;
            }
        }
        this.hiH.bDX();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dzH != i) {
            switch (i) {
                case 1:
                    if (this.hiZ != null) {
                        this.hiZ.blZ();
                    }
                    this.hgX.setFilter("nature");
                    this.hiJ.setViewChoosed(0, false);
                    this.hiJ.setViewChoosed(3, false);
                    this.hiB.uV(1);
                    this.hiJ.setViewVisibility(0, 8);
                    this.hiJ.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hiJ.setViewVisibility(0, 0);
                    this.hiJ.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dzH = i;
            this.hiB.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bEg() {
        if (this.hgP.getStatus() == 1 && !this.hiB.bEJ()) {
            G(1, true);
            this.hja.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bEf() {
        if (this.hgP.getStatus() == 1 && !this.hiB.bEJ()) {
            G(2, true);
            this.hja.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uT(int i) {
        if (this.gOa != null) {
            this.gOa.aa(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, String str) {
        if (this.gOa != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gOa.Z(i, str);
        }
    }
}
