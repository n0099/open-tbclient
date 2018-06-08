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
import com.baidu.tbadk.core.util.am;
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
    private ImageView dSa;
    private int dwv;
    private final CustomMessageListener dya;
    private com.baidu.tieba.j.h gJZ;
    private String gXR;
    private SelectMusicModel gXV;
    private b.a hbm;
    private i hcK;
    protected h hcS;
    private b hdC;
    private PreviewViewContainer heA;
    private TextView heB;
    private VideoEffectButtonLayout heC;
    private TextView heD;
    private View heE;
    private RoundProgressBar heF;
    private TextView heG;
    private AnimatorSet heH;
    private AnimatorSet heI;
    private ScaleAnimation heJ;
    private ObjectAnimator heK;
    private ObjectAnimator heL;
    private int heM;
    private ForumWriteData heN;
    private boolean heO;
    private boolean heP = true;
    private l heQ;
    private StickerItem heR;
    protected j heS;
    private RecordTabLayout heT;
    private ImageFileInfo heU;
    private HttpMessageListener heV;
    private boolean heW;
    private RecordLayout het;
    private VideoControllerLayout heu;
    private RelativeLayout hev;
    private ImageView hew;
    private ImageView hex;
    private ImageView hey;
    private com.baidu.tbadk.core.dialog.a hez;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.k.class);
        com.baidu.tieba.j.k kVar = runTask != null ? (com.baidu.tieba.j.k) runTask.getData() : null;
        if (kVar != null) {
            this.gJZ = kVar.aWY();
        }
        if (this.gJZ != null) {
            this.gJZ.aWF();
        }
        this.hbm = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dJ(List<com.baidu.tieba.video.localvideo.d> list) {
                if (w.z(list)) {
                    if (RecordVideoActivity.this.heu != null) {
                        RecordVideoActivity.this.heu.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.heu != null) {
                    RecordVideoActivity.this.heu.setHasLocalVideo(true);
                    RecordVideoActivity.this.heP = false;
                }
            }
        };
        this.heV = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.heu != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.heu.setStickerItems(list);
                    }
                }
            }
        };
        this.dya = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bDJ() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hcS.gXX);
        videoInfo.setVideoDuration(this.hcK.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hcS.gXX).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.heN.writeCallFrom, this.heN == null ? "" : this.heN.forumName, this.heN == null ? "" : this.heN.forumId, this.gXR, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.heS != null) {
            this.heS.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.gJZ != null) {
            this.gJZ.aWI();
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
        if (this.hcK != null && this.hcK.isRecording()) {
            this.hcK.stopRecord();
        }
        if (this.gXV != null) {
            this.gXV.cancelLoadData();
        }
        if (this.gJZ != null) {
            this.gJZ.qy("record");
        }
        com.baidu.tbadk.core.util.l.r(new File(com.baidu.tieba.video.b.gWl));
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
        this.heM = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.heN = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gXR = getIntent().getStringExtra("video_title");
        initUI();
        this.gXV = new SelectMusicModel(getPageContext(), this.heu);
        this.gXV.bBY();
        this.heS = new j(this);
        this.heS.b(this.gXV);
        this.hcK.a(this.heS);
        bDK();
        registerListener(this.heV);
        registerListener(this.dya);
    }

    private void bDK() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCB() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hbm);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.het = (RecordLayout) findViewById(d.g.root_layout);
        this.het.setListener(this);
        this.hcK = new i(this);
        this.heu = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.heu.setRecordController(this.hcK);
        this.heu.setRecordControlListener(this);
        this.heu.setEffectChoosedListener(this);
        this.hev = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dSa = (ImageView) findViewById(d.g.close_page);
        this.dSa.setOnClickListener(this);
        this.hew = (ImageView) findViewById(d.g.flash_switch);
        this.hew.setOnClickListener(this);
        this.hex = (ImageView) findViewById(d.g.camera_switch);
        this.hex.setOnClickListener(this);
        this.hey = (ImageView) findViewById(d.g.count_down);
        this.hey.setOnClickListener(this);
        this.heA = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.hcS = new h(this);
        this.hcS.a(this);
        this.hcS.setFaceIdentifyStateListener(this);
        this.hcS.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bDv() {
                if (RecordVideoActivity.this.heu.bEj()) {
                    RecordVideoActivity.this.heu.a((m) null);
                }
            }
        });
        this.heC = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.heC.setListener(this);
        this.hcK.a(this.heC);
        this.heC.setViewChoosed(2, true);
        this.heB = (TextView) findViewById(d.g.tv_count_down);
        this.heD = (TextView) findViewById(d.g.gesture_guide_tv);
        int aj = ((com.baidu.adp.lib.util.l.aj(this.mContext) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds150);
        if (this.heB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.heB.getLayoutParams()).topMargin = aj;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.heC.setVisibility(8);
        }
        this.heE = findViewById(d.g.progress_layout);
        this.heF = (RoundProgressBar) this.heE.findViewById(d.g.video_progress);
        this.heG = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.heG.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ah(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds38);
        this.heG.setLayoutParams(layoutParams);
        this.heT = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.heT.ar(1, getString(d.k.tab_photo));
        if (this.heM != 2 && this.heM != 3) {
            this.heT.ar(2, getString(d.k.tab_record));
            this.heT.setListener(this);
            this.heT.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.heT.setShowIndicator(false);
            this.heT.setCurrentTab(1, false);
            G(1, false);
        }
        bDL();
    }

    private void bDL() {
        if (com.baidu.tbadk.core.util.g.ya()) {
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
        this.hcS.onResume();
        this.hdC = this.hcS.bDm();
        if (this.hdC != null) {
            this.hdC.setRecordController(this.hcK);
            this.heA.setZoomHelper(this.hdC);
        }
        bDM();
        if (this.heQ == null) {
            this.heQ = new l();
            this.heQ.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cq(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.heR, str2);
                    if (RecordVideoActivity.this.heu != null) {
                        RecordVideoActivity.this.heu.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void uI(String str) {
                    if (RecordVideoActivity.this.heu != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.heu.b(stickerItem);
                        if (RecordVideoActivity.this.hcS != null) {
                            RecordVideoActivity.this.hcS.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.heu != null) {
                        RecordVideoActivity.this.heu.setDownLoadSticker(null);
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
                public void bBg() {
                    if (RecordVideoActivity.this.heu != null) {
                        RecordVideoActivity.this.heu.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.heQ.bEd();
        if (this.heu != null && this.heP) {
            bCB();
        }
        if (this.gJZ != null) {
            this.gJZ.qx("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hcS.onPause();
        if (this.heu != null) {
            if (this.hcK != null && this.hcK.getStatus() == 6) {
                this.heu.stopRecord();
                bDV();
            }
            if (this.hcK != null && this.hcK.isRecording()) {
                this.heu.stopRecord();
            }
        }
        if (this.heS != null) {
            this.heS.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hcK == null || this.hcK.getStatus() != 7) {
            if (this.hcK != null && this.hcK.getStatus() == 6) {
                if (this.heu != null) {
                    this.heu.stopRecord();
                }
                bDV();
            } else if (this.hcK.onBackPressed()) {
                finish();
            } else {
                if (this.hez == null) {
                    this.hez = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hez.cc(d.k.video_quit_confirm);
                    this.hez.a(d.k.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hez.b(d.k.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hez.au(true);
                    this.hez.b(getPageContext());
                }
                this.hez.xa();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.heG.setVisibility(4);
        if (view == this.dSa) {
            onBackPressed();
        } else if (view == this.hew) {
            if (this.hcK.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hcS.bDp();
            bDM();
        } else if (view == this.hex) {
            if (this.hcK.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hex.setOnClickListener(null);
            this.hcS.bDr();
            if (this.hcS.bDs() && this.hcS.bDq()) {
                this.hcS.bDp();
            }
            bDM();
            this.hex.setOnClickListener(this);
        } else if (view == this.hey) {
            bDO();
        }
    }

    private void bDM() {
        if (this.hcS.bDs()) {
            this.hew.setVisibility(8);
        } else {
            this.hew.setVisibility(0);
        }
        if (this.hcS.bDq()) {
            this.hew.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hew.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDN() {
        return this.heA;
    }

    public void bDO() {
        this.heG.setVisibility(4);
        if (this.hcK.getStatus() != 6) {
            this.hcK.setStatus(6);
            bDT();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.heJ == null) {
                this.heJ = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.heJ.setDuration(500L);
                this.heJ.setRepeatCount(5);
                this.heJ.setRepeatMode(2);
                this.heJ.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.heJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hcK.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.heB.setVisibility(0);
                        RecordVideoActivity.this.heB.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.heB.setVisibility(8);
                    if (RecordVideoActivity.this.hcK.getStatus() == 6) {
                        RecordVideoActivity.this.heu.bEg();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hcK.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.heB.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.heB.setText("");
                        }
                    }
                }
            });
            this.heB.setAnimation(this.heJ);
            this.heJ.startNow();
            this.heu.bDO();
            if (this.heS != null) {
                this.heS.bDI();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        if (this.hcK.getStatus() == 1) {
            this.heG.setVisibility(4);
            if (this.hcK.getStatus() != 6) {
                this.heu.bDP();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDQ() {
        this.heG.setVisibility(4);
        if (this.hcK.getStatus() != 6) {
            this.heu.bDQ();
            if (this.heu.bEk()) {
                bDK();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDR() {
        this.heG.setVisibility(4);
        if (this.hcK.getStatus() != 6) {
            this.heu.bDR();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDS() {
        this.heG.setVisibility(4);
        if (this.hcK.getStatus() != 6) {
            this.heu.bDS();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDT() {
        this.heO = true;
        if (this.heI != null && this.heI.isRunning()) {
            this.heI.cancel();
        }
        if (this.heH == null) {
            this.heH = new AnimatorSet();
            this.heH.playTogether(ObjectAnimator.ofFloat(this.hev, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.heC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.heT, "alpha", 1.0f, 0.0f));
            this.heH.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hgw) {
                        RecordVideoActivity.this.hev.setVisibility(8);
                        RecordVideoActivity.this.heC.setVisibility(8);
                        RecordVideoActivity.this.heT.setVisibility(8);
                    }
                }
            });
            this.heH.setDuration(300L);
        }
        this.heH.start();
        this.heC.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDI() {
        if (this.dwv == 2) {
            if (this.heO) {
                this.heO = false;
                if (this.heS != null) {
                    this.heS.bDI();
                }
            } else {
                return;
            }
        }
        if (this.heH != null && this.heH.isRunning()) {
            this.heH.cancel();
        }
        if (this.heI == null) {
            this.heI = new AnimatorSet();
            this.heI.playTogether(ObjectAnimator.ofFloat(this.hev, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.heC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.heT, "alpha", 0.0f, 1.0f));
            this.heI.setDuration(300L);
        }
        this.hev.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.heC.setVisibility(0);
        }
        if (this.hcK.getStatus() == 1) {
            this.heT.setVisibility(0);
        }
        this.heI.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDU() {
        if (this.hcS != null) {
            this.hcS.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void q(boolean z, String str) {
                    RecordVideoActivity.this.hcK.setStatus(1);
                    RecordVideoActivity.this.bDI();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.heU != null && !w.z(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.heU)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.heU);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.heU = new ImageFileInfo();
                        RecordVideoActivity.this.heU.setFilePath(str);
                        RecordVideoActivity.this.heU.setTempFile(true);
                        RecordVideoActivity.this.heU.setAlbumnId(null);
                        RecordVideoActivity.this.heU.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.heU);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.heN, RecordVideoActivity.this.heM)));
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
    public void bDV() {
        this.heJ.cancel();
        this.heJ.setAnimationListener(null);
        this.heB.clearAnimation();
        this.heB.setVisibility(8);
        if (this.heS != null) {
            this.heS.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDW() {
        bur();
    }

    private void bur() {
        if (this.heK != null) {
            this.heK.cancel();
        }
        if (this.heL == null) {
            this.heL = ObjectAnimator.ofFloat(this.heT, "alpha", 1.0f, 0.0f);
            this.heL.setDuration(500L);
            this.heL.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hgw) {
                        RecordVideoActivity.this.heT.setVisibility(8);
                    }
                }
            });
        }
        this.heL.start();
    }

    private void buq() {
        if (this.heL != null) {
            this.heL.cancel();
        }
        if (this.heK == null) {
            this.heK = ObjectAnimator.ofFloat(this.heT, "alpha", 0.0f, 1.0f);
            this.heK.setDuration(500L);
        }
        this.heT.setVisibility(0);
        this.heK.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDX() {
        this.heC.reset();
        if (this.hcK.getStatus() == 1) {
            buq();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDY() {
        if (this.heE.getVisibility() != 0) {
            this.heu.bEf();
            this.hcK.setStatus(8);
            bDI();
            if (this.hcS.hdA != null && this.hcS.hdA.size() > 0) {
                this.heE.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int heY = 50;
        final int heZ = 1;
        Handler hfa = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.heF.aF(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bEc();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bEc() {
            this.hfa.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bEc();
            boolean z = RecordVideoActivity.this.heS == null || TextUtils.isEmpty(RecordVideoActivity.this.heS.bDH()) || !new File(RecordVideoActivity.this.heS.bDH()).exists();
            if (RecordVideoActivity.this.hcS.hdA.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCT().b(RecordVideoActivity.this.hcS.hdA, RecordVideoActivity.this.hcS.bDj(), z);
            }
            File file = new File(RecordVideoActivity.this.hcS.hdA.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hcS.bDj()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCT().b(RecordVideoActivity.this.hcS.hdA, RecordVideoActivity.this.hcS.bDj(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.heu.bEl();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bDJ();
                    RecordVideoActivity.this.uL(102);
                    RecordVideoActivity.this.heE.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bDJ();
                RecordVideoActivity.this.uL(102);
                RecordVideoActivity.this.heE.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.k.mix_fail));
                RecordVideoActivity.this.heE.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ac(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.heF.aF(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.heu == null || w.z(this.heu.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.heu.getChoosedBeautyList()) {
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
        if (this.heu == null || w.z(this.heu.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.heu.getChoosedFilterList()) {
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
        if (this.heu == null || w.z(this.heu.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.heu.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDZ() {
        this.heG.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEa() {
        this.heG.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEb() {
        if (this.hcK.getStatus() == 1) {
            this.heT.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hcS != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hcS.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").r(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.heC.setViewChoosed(2, false);
                            return;
                        } else {
                            this.heC.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hcS.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.ah(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hcK.getStatus() == 1) {
                            amVar.r("obj_type", 1);
                        } else {
                            amVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.heC.setViewChoosed(3, false);
                            return;
                        } else {
                            this.heC.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.heS.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.heC.setViewChoosed(0, false);
                            return;
                        } else {
                            this.heC.setViewChoosed(0, true);
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
            this.heR = stickerItem;
            this.heQ.vi(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hcS != null) {
                    this.hcS.setSticker(null);
                    this.heW = false;
                }
                if (this.heu != null) {
                    this.heu.setDownLoadSticker(null);
                }
                this.heD.setVisibility(8);
                this.heC.setViewChoosed(1, false);
                return;
            }
            String vg = this.heQ.vg(stickerItem.resource);
            if (!StringUtils.isNull(vg)) {
                a(stickerItem, vg);
                if (this.heu != null) {
                    this.heu.setDownLoadSticker(null);
                }
            } else {
                if (this.heu != null) {
                    this.heu.setDownLoadSticker(stickerItem);
                }
                this.heQ.vh(stickerItem.resource);
            }
            this.heC.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hcS != null) {
                this.hcS.setSticker(stickerItem);
                this.heW = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.heD.setText(stickerItem.desc);
                this.heD.setVisibility(0);
                this.heD.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.heD.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.heD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bS(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.p(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.heu.getLayoutParams();
            layoutParams.height = i4;
            this.heu.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uR = com.baidu.tieba.video.editvideo.model.a.bBS().uR(stringExtra);
                if (this.heS != null && !TextUtils.isEmpty(uR)) {
                    this.heS.cr(uR, stringExtra2);
                    this.heu.bCY();
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
        if (this.hcK.getStatus() == 8) {
            this.heu.bEe();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void nf(boolean z) {
        if (this.hcK != null && (this.hcK.getStatus() == 1 || this.hcK.getStatus() == 3 || this.hcK.getStatus() == 4)) {
            if (!z && this.heW) {
                this.heA.bDw();
                return;
            } else {
                this.heA.bDx();
                return;
            }
        }
        this.heA.bDx();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dwv != i) {
            switch (i) {
                case 1:
                    if (this.heS != null) {
                        this.heS.blv();
                    }
                    this.hcS.setFilter("nature");
                    this.heC.setViewChoosed(0, false);
                    this.heC.setViewChoosed(3, false);
                    this.heu.uN(1);
                    this.heC.setViewVisibility(0, 8);
                    this.heC.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.heC.setViewVisibility(0, 0);
                    this.heC.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dwv = i;
            this.heu.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDG() {
        if (this.hcK.getStatus() == 1 && !this.heu.bEj()) {
            G(1, true);
            this.heT.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDF() {
        if (this.hcK.getStatus() == 1 && !this.heu.bEj()) {
            G(2, true);
            this.heT.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL(int i) {
        if (this.gJZ != null) {
            this.gJZ.ad(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, String str) {
        if (this.gJZ != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gJZ.ac(i, str);
        }
    }
}
