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
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
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
import com.baidu.tieba.video.record.RecordLayout;
import com.baidu.tieba.video.record.RecordTabLayout;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.video.record.g;
import com.baidu.tieba.video.record.h;
import com.baidu.tieba.video.record.i;
import com.baidu.tieba.video.record.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class RecordVideoActivity extends BaseActivity implements RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, g.a, i.c {
    private final CustomMessageListener cYn;
    private ImageView dsU;
    private com.baidu.tieba.i.h gCU;
    private String gRg;
    private SelectMusicModel gRk;
    private b.a gUC;
    protected i gWF;
    private j gWw;
    private b gXr;
    private ScaleAnimation gYA;
    private ObjectAnimator gYB;
    private ObjectAnimator gYC;
    private int gYD;
    private ForumWriteData gYE;
    private boolean gYF;
    private boolean gYG = true;
    private m gYH;
    private StickerItem gYI;
    protected k gYJ;
    private RecordTabLayout gYK;
    private ImageFileInfo gYL;
    private HttpMessageListener gYM;
    private boolean gYN;
    private RecordLayout gYk;
    private VideoControllerLayout gYl;
    private RelativeLayout gYm;
    private ImageView gYn;
    private ImageView gYo;
    private ImageView gYp;
    private com.baidu.tbadk.core.dialog.a gYq;
    private PreviewViewContainer gYr;
    private TextView gYs;
    private VideoEffectButtonLayout gYt;
    private TextView gYu;
    private View gYv;
    private RoundProgressBar gYw;
    private TextView gYx;
    private AnimatorSet gYy;
    private AnimatorSet gYz;
    private int goK;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCU = kVar.aOk();
        }
        if (this.gCU != null) {
            this.gCU.aNS();
        }
        this.gUC = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dP(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.w(list)) {
                    if (RecordVideoActivity.this.gYl != null) {
                        RecordVideoActivity.this.gYl.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.gYl != null) {
                    RecordVideoActivity.this.gYl.setHasLocalVideo(true);
                    RecordVideoActivity.this.gYG = false;
                }
            }
        };
        this.gYM = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.gYl != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.gYl.setStickerItems(list);
                    }
                }
            }
        };
        this.cYn = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bEb() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gWF.gRm);
        videoInfo.setVideoDuration(this.gWw.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gWF.gRm).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.gYE.writeCallFrom, this.gYE == null ? "" : this.gYE.forumName, this.gYE == null ? "" : this.gYE.forumId, this.gRg, videoInfo);
        if (this.gYJ != null) {
            this.gYJ.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.gWw.Mw();
        this.gWF.bDy();
        if (this.gCU != null) {
            this.gCU.aNV();
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
        if (this.gWw != null && this.gWw.isRecording()) {
            this.gWw.stopRecord();
        }
        if (this.gRk != null) {
            this.gRk.cancelLoadData();
        }
        if (this.gCU != null) {
            this.gCU.oY("record");
        }
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
        setContentView(d.h.record_activity);
        this.gYD = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.gYE = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gRg = getIntent().getStringExtra("video_title");
        initUI();
        this.gRk = new SelectMusicModel(getPageContext(), this.gYl);
        this.gRk.bCf();
        this.gYJ = new k(this);
        this.gYJ.b(this.gRk);
        this.gWw.a(this.gYJ);
        bEc();
        registerListener(this.gYM);
        registerListener(this.cYn);
    }

    private void bEc() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCI() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gUC);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gYk = (RecordLayout) findViewById(d.g.root_layout);
        this.gYk.setListener(this);
        this.gWw = new j(this);
        this.gYl = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gYl.setRecordController(this.gWw);
        this.gYl.setRecordControlListener(this);
        this.gYl.setEffectChoosedListener(this);
        this.gYm = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dsU = (ImageView) findViewById(d.g.close_page);
        this.dsU.setOnClickListener(this);
        this.gYn = (ImageView) findViewById(d.g.flash_switch);
        this.gYn.setOnClickListener(this);
        this.gYo = (ImageView) findViewById(d.g.camera_switch);
        this.gYo.setOnClickListener(this);
        this.gYp = (ImageView) findViewById(d.g.count_down);
        this.gYp.setOnClickListener(this);
        this.gYr = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.gWF = new i(this);
        this.gWF.a(this);
        this.gWF.setFaceIdentifyStateListener(this);
        this.gWF.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bDO() {
                if (RecordVideoActivity.this.gYl.bEy()) {
                    RecordVideoActivity.this.gYl.a((o) null);
                }
            }
        });
        this.gYt = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gYt.setListener(this);
        this.gWw.a(this.gYt);
        this.gYt.F(2, true);
        this.gYs = (TextView) findViewById(d.g.tv_count_down);
        this.gYu = (TextView) findViewById(d.g.gesture_guide_tv);
        int ae = ((com.baidu.adp.lib.util.l.ae(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds150);
        if (this.gYs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gYs.getLayoutParams()).topMargin = ae;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gYt.setVisibility(8);
        }
        this.gYv = findViewById(d.g.progress_layout);
        this.gYw = (RoundProgressBar) this.gYv.findViewById(d.g.video_progress);
        this.gYx = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYx.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ac(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds38);
        this.gYx.setLayoutParams(layoutParams);
        this.gYK = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.gYK.al(1, getString(d.j.tab_photo));
        if (this.gYD != 2 && this.gYD != 3) {
            this.gYK.al(2, getString(d.j.tab_record));
            this.gYK.setListener(this);
            this.gYK.q(2, false);
            E(2, false);
            return;
        }
        this.gYK.setShowIndicator(false);
        this.gYK.q(1, false);
        E(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gWF.onResume();
        this.gXr = this.gWF.bDE();
        this.gXr.setRecordController(this.gWw);
        this.gYr.setZoomHelper(this.gXr);
        if (this.gYH == null) {
            this.gYH = new m();
            this.gYH.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void cn(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gYI, str2);
                    if (RecordVideoActivity.this.gYl != null) {
                        RecordVideoActivity.this.gYl.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tW(String str) {
                    if (RecordVideoActivity.this.gYl != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gYl.b(stickerItem);
                        if (RecordVideoActivity.this.gWF != null) {
                            RecordVideoActivity.this.gWF.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gYl != null) {
                        RecordVideoActivity.this.gYl.setDownLoadSticker(null);
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
                    recordVideoActivity.Q(5, str);
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void bBm() {
                    if (RecordVideoActivity.this.gYl != null) {
                        RecordVideoActivity.this.gYl.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gYH.bEt();
        if (this.gYl != null && this.gYG) {
            bCI();
        }
        if (this.gYJ != null) {
            this.gYJ.onResume();
        }
        if (this.gCU != null) {
            this.gCU.oX("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gWF.onPause();
        if (this.gYl != null) {
            if (this.gWw != null && this.gWw.getStatus() == 6) {
                this.gYl.stopRecord();
                bEm();
            }
            if (this.gWw != null && this.gWw.isRecording()) {
                this.gYl.stopRecord();
            }
        }
        if (this.gYJ != null) {
            this.gYJ.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gWw == null || this.gWw.getStatus() != 7) {
            if (this.gWw != null && this.gWw.getStatus() == 6) {
                if (this.gYl != null) {
                    this.gYl.stopRecord();
                }
                bEm();
            } else if (this.gWw.onBackPressed()) {
                finish();
            } else {
                if (this.gYq == null) {
                    this.gYq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gYq.cd(d.j.video_quit_confirm);
                    this.gYq.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gYq.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gYq.ao(true);
                    this.gYq.b(getPageContext());
                }
                this.gYq.th();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gYx.setVisibility(4);
        if (view == this.dsU) {
            onBackPressed();
        } else if (view == this.gYn) {
            if (this.gWw.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gWF.bDI();
            bEd();
        } else if (view == this.gYo) {
            if (this.gWw.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gYo.setOnClickListener(null);
            this.gWF.bDK();
            if (this.gWF.bDL() && this.gWF.bDJ()) {
                this.gWF.bDI();
            }
            bEd();
            this.gYo.setOnClickListener(this);
        } else if (view == this.gYp) {
            bEf();
        }
    }

    private void bEd() {
        if (this.gWF.bDL()) {
            this.gYn.setVisibility(8);
        } else {
            this.gYn.setVisibility(0);
        }
        if (this.gWF.bDJ()) {
            this.gYn.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.gYn.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bEe() {
        return this.gYr;
    }

    public void bEf() {
        this.gYx.setVisibility(4);
        if (this.gWw.getStatus() != 6) {
            this.gWw.setStatus(6);
            bEk();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gYA == null) {
                this.gYA = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gYA.setDuration(500L);
                this.gYA.setRepeatCount(5);
                this.gYA.setRepeatMode(2);
                this.gYA.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gYA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gWw.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gYs.setVisibility(0);
                        RecordVideoActivity.this.gYs.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gYs.setVisibility(8);
                    if (RecordVideoActivity.this.gWw.getStatus() == 6) {
                        RecordVideoActivity.this.gYl.bEv();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gWw.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gYs.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gYs.setText("");
                        }
                    }
                }
            });
            this.gYs.setAnimation(this.gYA);
            this.gYA.startNow();
            this.gYl.bEf();
            if (this.gYJ != null) {
                this.gYJ.bDZ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEg() {
        if (this.gWw.getStatus() == 1) {
            this.gYx.setVisibility(4);
            if (this.gWw.getStatus() != 6) {
                this.gYl.bEg();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEh() {
        this.gYx.setVisibility(4);
        if (this.gWw.getStatus() != 6) {
            this.gYl.bEh();
            if (this.gYl.bEz()) {
                bEc();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEi() {
        this.gYx.setVisibility(4);
        if (this.gWw.getStatus() != 6) {
            this.gYl.bEi();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEj() {
        this.gYx.setVisibility(4);
        if (this.gWw.getStatus() != 6) {
            this.gYl.bEj();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEk() {
        this.gYF = true;
        if (this.gYz != null && this.gYz.isRunning()) {
            this.gYz.cancel();
        }
        if (this.gYy == null) {
            this.gYy = new AnimatorSet();
            this.gYy.playTogether(ObjectAnimator.ofFloat(this.gYm, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gYt, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gYK, "alpha", 1.0f, 0.0f));
            this.gYy.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hal) {
                        RecordVideoActivity.this.gYm.setVisibility(8);
                        RecordVideoActivity.this.gYt.setVisibility(8);
                        RecordVideoActivity.this.gYK.setVisibility(8);
                    }
                }
            });
            this.gYy.setDuration(300L);
        }
        this.gYy.start();
        this.gYt.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDZ() {
        if (this.goK == 2) {
            if (this.gYF) {
                this.gYF = false;
                if (this.gYJ != null) {
                    this.gYJ.bDZ();
                }
            } else {
                return;
            }
        }
        if (this.gYy != null && this.gYy.isRunning()) {
            this.gYy.cancel();
        }
        if (this.gYz == null) {
            this.gYz = new AnimatorSet();
            this.gYz.playTogether(ObjectAnimator.ofFloat(this.gYm, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gYt, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gYK, "alpha", 0.0f, 1.0f));
            this.gYz.setDuration(300L);
        }
        this.gYm.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.gYt.setVisibility(0);
        }
        if (this.gWw.getStatus() == 1) {
            this.gYK.setVisibility(0);
        }
        this.gYz.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEl() {
        if (this.gWF != null) {
            this.gWF.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void s(boolean z, String str) {
                    RecordVideoActivity.this.gWw.setStatus(1);
                    RecordVideoActivity.this.bDZ();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.gYL != null && !v.w(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.gYL)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.gYL);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.gYL = new ImageFileInfo();
                        RecordVideoActivity.this.gYL.setFilePath(str);
                        RecordVideoActivity.this.gYL.setTempFile(true);
                        RecordVideoActivity.this.gYL.setAlbumnId(null);
                        RecordVideoActivity.this.gYL.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.gYL);
                        RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.gYE, RecordVideoActivity.this.gYD)));
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEm() {
        this.gYA.cancel();
        this.gYA.setAnimationListener(null);
        this.gYs.clearAnimation();
        this.gYs.setVisibility(8);
        if (this.gYJ != null) {
            this.gYJ.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEn() {
        brT();
    }

    private void brT() {
        if (this.gYB != null) {
            this.gYB.cancel();
        }
        if (this.gYC == null) {
            this.gYC = ObjectAnimator.ofFloat(this.gYK, "alpha", 1.0f, 0.0f);
            this.gYC.setDuration(500L);
            this.gYC.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hal) {
                        RecordVideoActivity.this.gYK.setVisibility(8);
                    }
                }
            });
        }
        this.gYC.start();
    }

    private void brS() {
        if (this.gYC != null) {
            this.gYC.cancel();
        }
        if (this.gYB == null) {
            this.gYB = ObjectAnimator.ofFloat(this.gYK, "alpha", 0.0f, 1.0f);
            this.gYB.setDuration(500L);
        }
        this.gYK.setVisibility(0);
        this.gYB.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEo() {
        this.gYt.reset();
        if (this.gWw.getStatus() == 1) {
            brS();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEa() {
        if (this.gYv.getVisibility() != 0) {
            this.gYl.bEu();
            this.gWw.setStatus(8);
            bDZ();
            if (this.gWF.gXp != null && this.gWF.gXp.size() > 0) {
                this.gYv.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int gYP = 50;
        final int gYQ = 1;
        Handler gYR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gYw.ap(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bEs();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bEs() {
            this.gYR.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bEs();
            boolean z = RecordVideoActivity.this.gYJ == null || TextUtils.isEmpty(RecordVideoActivity.this.gYJ.bDY()) || !new File(RecordVideoActivity.this.gYJ.bDY()).exists();
            if (RecordVideoActivity.this.gWF.gXp.size() > 1) {
                return com.baidu.tieba.video.meida.h.bDb().b(RecordVideoActivity.this.gWF.gXp, RecordVideoActivity.this.gWF.bDB(), z);
            }
            File file = new File(RecordVideoActivity.this.gWF.gXp.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.gWF.bDB()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bDb().b(RecordVideoActivity.this.gWF.gXp, RecordVideoActivity.this.gWF.bDB(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.gYl.bEA();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bEb();
                    RecordVideoActivity.this.vF(102);
                    RecordVideoActivity.this.gYv.setVisibility(8);
                    RecordVideoActivity.this.gYJ.bEa();
                    return;
                }
                RecordVideoActivity.this.bEb();
                RecordVideoActivity.this.vF(102);
                RecordVideoActivity.this.gYv.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.gYv.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.Q(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.gYw.ap(0.0f);
            RecordVideoActivity.this.gYJ.bEa();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gYl == null || v.w(this.gYl.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.gYl.getChoosedBeautyList()) {
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
        if (this.gYl == null || v.w(this.gYl.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.gYl.getChoosedFilterList()) {
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
        if (this.gYl == null || v.w(this.gYl.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gYl.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEp() {
        this.gYx.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEq() {
        this.gYx.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEr() {
        if (this.gWw.getStatus() == 1) {
            this.gYK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.gWF != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gWF.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").r("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.gYt.F(2, false);
                            return;
                        } else {
                            this.gYt.F(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.gWF.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ac("obj_id", (String) eVar.getValue());
                        if (this.gWw.getStatus() == 1) {
                            akVar.r("obj_type", 1);
                        } else {
                            akVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.gYt.F(3, false);
                            return;
                        } else {
                            this.gYt.F(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.gYJ.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.gYt.F(0, false);
                            return;
                        } else {
                            this.gYt.F(0, true);
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
            this.gYI = stickerItem;
            this.gYH.uw(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gWF != null) {
                    this.gWF.setSticker(null);
                    this.gYN = false;
                }
                if (this.gYl != null) {
                    this.gYl.setDownLoadSticker(null);
                }
                this.gYu.setVisibility(8);
                this.gYt.F(1, false);
                return;
            }
            String uu = this.gYH.uu(stickerItem.resource);
            if (!StringUtils.isNull(uu)) {
                a(stickerItem, uu);
                if (this.gYl != null) {
                    this.gYl.setDownLoadSticker(null);
                }
            } else {
                if (this.gYl != null) {
                    this.gYl.setDownLoadSticker(stickerItem);
                }
                this.gYH.uv(stickerItem.resource);
            }
            this.gYt.F(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gWF != null) {
                this.gWF.setSticker(stickerItem);
                this.gYN = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gYu.setText(stickerItem.desc);
                this.gYu.setVisibility(0);
                this.gYu.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gYu.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gYu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cf(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gYl.getLayoutParams();
            layoutParams.height = i4;
            this.gYl.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(stringExtra);
                if (this.gYJ != null && !TextUtils.isEmpty(uf)) {
                    this.gYJ.co(uf, stringExtra2);
                    this.gYl.bDq();
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
        if (this.gWw.getStatus() == 8) {
            this.gYl.vH(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nK(boolean z) {
        if (this.gWw != null && (this.gWw.getStatus() == 1 || this.gWw.getStatus() == 3 || this.gWw.getStatus() == 4)) {
            if (!z && this.gYN) {
                this.gYr.bDP();
                return;
            } else {
                this.gYr.bDQ();
                return;
            }
        }
        this.gYr.bDQ();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void E(int i, boolean z) {
        int i2 = 1;
        if (this.goK != i) {
            switch (i) {
                case 1:
                    if (this.gYJ != null) {
                        this.gYJ.bjo();
                    }
                    this.gWF.setFilter("nature");
                    this.gYt.F(0, false);
                    this.gYt.F(3, false);
                    this.gYl.vH(1);
                    this.gYt.setViewVisibility(0, 8);
                    this.gYt.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.gYt.setViewVisibility(0, 0);
                    this.gYt.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.goK = i;
            this.gYl.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDX() {
        if (this.gWw.getStatus() == 1 && !this.gYl.bEy()) {
            E(1, true);
            this.gYK.q(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDW() {
        if (this.gWw.getStatus() == 1 && !this.gYl.bEy()) {
            E(2, true);
            this.gYK.q(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        if (this.gCU != null) {
            this.gCU.R(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        if (this.gCU != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gCU.Q(i, str);
        }
    }
}
