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
    private final CustomMessageListener cYj;
    private ImageView dsQ;
    private com.baidu.tieba.i.h gCP;
    private String gRb;
    private SelectMusicModel gRf;
    private b.a gUx;
    protected i gWA;
    private j gWr;
    private b gXm;
    private boolean gYA;
    private boolean gYB = true;
    private m gYC;
    private StickerItem gYD;
    protected k gYE;
    private RecordTabLayout gYF;
    private ImageFileInfo gYG;
    private HttpMessageListener gYH;
    private boolean gYI;
    private RecordLayout gYf;
    private VideoControllerLayout gYg;
    private RelativeLayout gYh;
    private ImageView gYi;
    private ImageView gYj;
    private ImageView gYk;
    private com.baidu.tbadk.core.dialog.a gYl;
    private PreviewViewContainer gYm;
    private TextView gYn;
    private VideoEffectButtonLayout gYo;
    private TextView gYp;
    private View gYq;
    private RoundProgressBar gYr;
    private TextView gYs;
    private AnimatorSet gYt;
    private AnimatorSet gYu;
    private ScaleAnimation gYv;
    private ObjectAnimator gYw;
    private ObjectAnimator gYx;
    private int gYy;
    private ForumWriteData gYz;
    private int goF;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gCP = kVar.aOk();
        }
        if (this.gCP != null) {
            this.gCP.aNS();
        }
        this.gUx = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dP(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.w(list)) {
                    if (RecordVideoActivity.this.gYg != null) {
                        RecordVideoActivity.this.gYg.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.gYg != null) {
                    RecordVideoActivity.this.gYg.setHasLocalVideo(true);
                    RecordVideoActivity.this.gYB = false;
                }
            }
        };
        this.gYH = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.gYg != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.gYg.setStickerItems(list);
                    }
                }
            }
        };
        this.cYj = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
        videoInfo.setVideoPath(this.gWA.gRh);
        videoInfo.setVideoDuration(this.gWr.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gWA.gRh).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.gYz.writeCallFrom, this.gYz == null ? "" : this.gYz.forumName, this.gYz == null ? "" : this.gYz.forumId, this.gRb, videoInfo);
        if (this.gYE != null) {
            this.gYE.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.gWr.Mw();
        this.gWA.bDy();
        if (this.gCP != null) {
            this.gCP.aNV();
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
        if (this.gWr != null && this.gWr.isRecording()) {
            this.gWr.stopRecord();
        }
        if (this.gRf != null) {
            this.gRf.cancelLoadData();
        }
        if (this.gCP != null) {
            this.gCP.oY("record");
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
        this.gYy = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.gYz = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.gRb = getIntent().getStringExtra("video_title");
        initUI();
        this.gRf = new SelectMusicModel(getPageContext(), this.gYg);
        this.gRf.bCf();
        this.gYE = new k(this);
        this.gYE.b(this.gRf);
        this.gWr.a(this.gYE);
        bEc();
        registerListener(this.gYH);
        registerListener(this.cYj);
    }

    private void bEc() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCI() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gUx);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gYf = (RecordLayout) findViewById(d.g.root_layout);
        this.gYf.setListener(this);
        this.gWr = new j(this);
        this.gYg = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gYg.setRecordController(this.gWr);
        this.gYg.setRecordControlListener(this);
        this.gYg.setEffectChoosedListener(this);
        this.gYh = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.dsQ = (ImageView) findViewById(d.g.close_page);
        this.dsQ.setOnClickListener(this);
        this.gYi = (ImageView) findViewById(d.g.flash_switch);
        this.gYi.setOnClickListener(this);
        this.gYj = (ImageView) findViewById(d.g.camera_switch);
        this.gYj.setOnClickListener(this);
        this.gYk = (ImageView) findViewById(d.g.count_down);
        this.gYk.setOnClickListener(this);
        this.gYm = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.gWA = new i(this);
        this.gWA.a(this);
        this.gWA.setFaceIdentifyStateListener(this);
        this.gWA.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bDO() {
                if (RecordVideoActivity.this.gYg.bEy()) {
                    RecordVideoActivity.this.gYg.a((o) null);
                }
            }
        });
        this.gYo = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gYo.setListener(this);
        this.gWr.a(this.gYo);
        this.gYo.F(2, true);
        this.gYn = (TextView) findViewById(d.g.tv_count_down);
        this.gYp = (TextView) findViewById(d.g.gesture_guide_tv);
        int ae = ((com.baidu.adp.lib.util.l.ae(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds150);
        if (this.gYn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gYn.getLayoutParams()).topMargin = ae;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gYo.setVisibility(8);
        }
        this.gYq = findViewById(d.g.progress_layout);
        this.gYr = (RoundProgressBar) this.gYq.findViewById(d.g.video_progress);
        this.gYs = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYs.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ac(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds38);
        this.gYs.setLayoutParams(layoutParams);
        this.gYF = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.gYF.al(1, getString(d.j.tab_photo));
        if (this.gYy != 2 && this.gYy != 3) {
            this.gYF.al(2, getString(d.j.tab_record));
            this.gYF.setListener(this);
            this.gYF.q(2, false);
            E(2, false);
            return;
        }
        this.gYF.setShowIndicator(false);
        this.gYF.q(1, false);
        E(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gWA.onResume();
        this.gXm = this.gWA.bDE();
        this.gXm.setRecordController(this.gWr);
        this.gYm.setZoomHelper(this.gXm);
        if (this.gYC == null) {
            this.gYC = new m();
            this.gYC.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void cn(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gYD, str2);
                    if (RecordVideoActivity.this.gYg != null) {
                        RecordVideoActivity.this.gYg.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tW(String str) {
                    if (RecordVideoActivity.this.gYg != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gYg.b(stickerItem);
                        if (RecordVideoActivity.this.gWA != null) {
                            RecordVideoActivity.this.gWA.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gYg != null) {
                        RecordVideoActivity.this.gYg.setDownLoadSticker(null);
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
                    if (RecordVideoActivity.this.gYg != null) {
                        RecordVideoActivity.this.gYg.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gYC.bEt();
        if (this.gYg != null && this.gYB) {
            bCI();
        }
        if (this.gYE != null) {
            this.gYE.onResume();
        }
        if (this.gCP != null) {
            this.gCP.oX("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gWA.onPause();
        if (this.gYg != null) {
            if (this.gWr != null && this.gWr.getStatus() == 6) {
                this.gYg.stopRecord();
                bEm();
            }
            if (this.gWr != null && this.gWr.isRecording()) {
                this.gYg.stopRecord();
            }
        }
        if (this.gYE != null) {
            this.gYE.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gWr == null || this.gWr.getStatus() != 7) {
            if (this.gWr != null && this.gWr.getStatus() == 6) {
                if (this.gYg != null) {
                    this.gYg.stopRecord();
                }
                bEm();
            } else if (this.gWr.onBackPressed()) {
                finish();
            } else {
                if (this.gYl == null) {
                    this.gYl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gYl.cd(d.j.video_quit_confirm);
                    this.gYl.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gYl.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gYl.ao(true);
                    this.gYl.b(getPageContext());
                }
                this.gYl.th();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gYs.setVisibility(4);
        if (view == this.dsQ) {
            onBackPressed();
        } else if (view == this.gYi) {
            if (this.gWr.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gWA.bDI();
            bEd();
        } else if (view == this.gYj) {
            if (this.gWr.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gYj.setOnClickListener(null);
            this.gWA.bDK();
            if (this.gWA.bDL() && this.gWA.bDJ()) {
                this.gWA.bDI();
            }
            bEd();
            this.gYj.setOnClickListener(this);
        } else if (view == this.gYk) {
            bEf();
        }
    }

    private void bEd() {
        if (this.gWA.bDL()) {
            this.gYi.setVisibility(8);
        } else {
            this.gYi.setVisibility(0);
        }
        if (this.gWA.bDJ()) {
            this.gYi.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.gYi.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bEe() {
        return this.gYm;
    }

    public void bEf() {
        this.gYs.setVisibility(4);
        if (this.gWr.getStatus() != 6) {
            this.gWr.setStatus(6);
            bEk();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gYv == null) {
                this.gYv = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gYv.setDuration(500L);
                this.gYv.setRepeatCount(5);
                this.gYv.setRepeatMode(2);
                this.gYv.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gYv.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gWr.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gYn.setVisibility(0);
                        RecordVideoActivity.this.gYn.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gYn.setVisibility(8);
                    if (RecordVideoActivity.this.gWr.getStatus() == 6) {
                        RecordVideoActivity.this.gYg.bEv();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gWr.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gYn.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gYn.setText("");
                        }
                    }
                }
            });
            this.gYn.setAnimation(this.gYv);
            this.gYv.startNow();
            this.gYg.bEf();
            if (this.gYE != null) {
                this.gYE.bDZ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEg() {
        if (this.gWr.getStatus() == 1) {
            this.gYs.setVisibility(4);
            if (this.gWr.getStatus() != 6) {
                this.gYg.bEg();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEh() {
        this.gYs.setVisibility(4);
        if (this.gWr.getStatus() != 6) {
            this.gYg.bEh();
            if (this.gYg.bEz()) {
                bEc();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEi() {
        this.gYs.setVisibility(4);
        if (this.gWr.getStatus() != 6) {
            this.gYg.bEi();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bEj() {
        this.gYs.setVisibility(4);
        if (this.gWr.getStatus() != 6) {
            this.gYg.bEj();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEk() {
        this.gYA = true;
        if (this.gYu != null && this.gYu.isRunning()) {
            this.gYu.cancel();
        }
        if (this.gYt == null) {
            this.gYt = new AnimatorSet();
            this.gYt.playTogether(ObjectAnimator.ofFloat(this.gYh, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gYo, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gYF, "alpha", 1.0f, 0.0f));
            this.gYt.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hag) {
                        RecordVideoActivity.this.gYh.setVisibility(8);
                        RecordVideoActivity.this.gYo.setVisibility(8);
                        RecordVideoActivity.this.gYF.setVisibility(8);
                    }
                }
            });
            this.gYt.setDuration(300L);
        }
        this.gYt.start();
        this.gYo.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDZ() {
        if (this.goF == 2) {
            if (this.gYA) {
                this.gYA = false;
                if (this.gYE != null) {
                    this.gYE.bDZ();
                }
            } else {
                return;
            }
        }
        if (this.gYt != null && this.gYt.isRunning()) {
            this.gYt.cancel();
        }
        if (this.gYu == null) {
            this.gYu = new AnimatorSet();
            this.gYu.playTogether(ObjectAnimator.ofFloat(this.gYh, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gYo, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gYF, "alpha", 0.0f, 1.0f));
            this.gYu.setDuration(300L);
        }
        this.gYh.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.gYo.setVisibility(0);
        }
        if (this.gWr.getStatus() == 1) {
            this.gYF.setVisibility(0);
        }
        this.gYu.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEl() {
        if (this.gWA != null) {
            this.gWA.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void s(boolean z, String str) {
                    RecordVideoActivity.this.gWr.setStatus(1);
                    RecordVideoActivity.this.bDZ();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.gYG != null && !v.w(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.gYG)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.gYG);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.gYG = new ImageFileInfo();
                        RecordVideoActivity.this.gYG.setFilePath(str);
                        RecordVideoActivity.this.gYG.setTempFile(true);
                        RecordVideoActivity.this.gYG.setAlbumnId(null);
                        RecordVideoActivity.this.gYG.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.gYG);
                        RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.gYz, RecordVideoActivity.this.gYy)));
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEm() {
        this.gYv.cancel();
        this.gYv.setAnimationListener(null);
        this.gYn.clearAnimation();
        this.gYn.setVisibility(8);
        if (this.gYE != null) {
            this.gYE.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEn() {
        brT();
    }

    private void brT() {
        if (this.gYw != null) {
            this.gYw.cancel();
        }
        if (this.gYx == null) {
            this.gYx = ObjectAnimator.ofFloat(this.gYF, "alpha", 1.0f, 0.0f);
            this.gYx.setDuration(500L);
            this.gYx.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hag) {
                        RecordVideoActivity.this.gYF.setVisibility(8);
                    }
                }
            });
        }
        this.gYx.start();
    }

    private void brS() {
        if (this.gYx != null) {
            this.gYx.cancel();
        }
        if (this.gYw == null) {
            this.gYw = ObjectAnimator.ofFloat(this.gYF, "alpha", 0.0f, 1.0f);
            this.gYw.setDuration(500L);
        }
        this.gYF.setVisibility(0);
        this.gYw.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEo() {
        this.gYo.reset();
        if (this.gWr.getStatus() == 1) {
            brS();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEa() {
        if (this.gYq.getVisibility() != 0) {
            this.gYg.bEu();
            this.gWr.setStatus(8);
            bDZ();
            if (this.gWA.gXk != null && this.gWA.gXk.size() > 0) {
                this.gYq.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int gYK = 50;
        final int gYL = 1;
        Handler gYM = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gYr.ap(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bEs();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bEs() {
            this.gYM.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: m */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bEs();
            boolean z = RecordVideoActivity.this.gYE == null || TextUtils.isEmpty(RecordVideoActivity.this.gYE.bDY()) || !new File(RecordVideoActivity.this.gYE.bDY()).exists();
            if (RecordVideoActivity.this.gWA.gXk.size() > 1) {
                return com.baidu.tieba.video.meida.h.bDb().b(RecordVideoActivity.this.gWA.gXk, RecordVideoActivity.this.gWA.bDB(), z);
            }
            File file = new File(RecordVideoActivity.this.gWA.gXk.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.gWA.bDB()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bDb().b(RecordVideoActivity.this.gWA.gXk, RecordVideoActivity.this.gWA.bDB(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.gYg.bEA();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bEb();
                    RecordVideoActivity.this.vF(102);
                    RecordVideoActivity.this.gYq.setVisibility(8);
                    RecordVideoActivity.this.gYE.bEa();
                    return;
                }
                RecordVideoActivity.this.bEb();
                RecordVideoActivity.this.vF(102);
                RecordVideoActivity.this.gYq.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.gYq.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.Q(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.gYr.ap(0.0f);
            RecordVideoActivity.this.gYE.bEa();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gYg == null || v.w(this.gYg.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.gYg.getChoosedBeautyList()) {
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
        if (this.gYg == null || v.w(this.gYg.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.gYg.getChoosedFilterList()) {
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
        if (this.gYg == null || v.w(this.gYg.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gYg.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEp() {
        this.gYs.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEq() {
        this.gYs.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEr() {
        if (this.gWr.getStatus() == 1) {
            this.gYF.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.gWA != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gWA.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").r("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.gYo.F(2, false);
                            return;
                        } else {
                            this.gYo.F(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.gWA.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ac("obj_id", (String) eVar.getValue());
                        if (this.gWr.getStatus() == 1) {
                            akVar.r("obj_type", 1);
                        } else {
                            akVar.r("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.gYo.F(3, false);
                            return;
                        } else {
                            this.gYo.F(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.gYE.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.gYo.F(0, false);
                            return;
                        } else {
                            this.gYo.F(0, true);
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
            this.gYD = stickerItem;
            this.gYC.uw(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gWA != null) {
                    this.gWA.setSticker(null);
                    this.gYI = false;
                }
                if (this.gYg != null) {
                    this.gYg.setDownLoadSticker(null);
                }
                this.gYp.setVisibility(8);
                this.gYo.F(1, false);
                return;
            }
            String uu = this.gYC.uu(stickerItem.resource);
            if (!StringUtils.isNull(uu)) {
                a(stickerItem, uu);
                if (this.gYg != null) {
                    this.gYg.setDownLoadSticker(null);
                }
            } else {
                if (this.gYg != null) {
                    this.gYg.setDownLoadSticker(stickerItem);
                }
                this.gYC.uv(stickerItem.resource);
            }
            this.gYo.F(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gWA != null) {
                this.gWA.setSticker(stickerItem);
                this.gYI = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gYp.setText(stickerItem.desc);
                this.gYp.setVisibility(0);
                this.gYp.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gYp.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gYp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cf(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gYg.getLayoutParams();
            layoutParams.height = i4;
            this.gYg.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String uf = com.baidu.tieba.video.editvideo.model.a.bBZ().uf(stringExtra);
                if (this.gYE != null && !TextUtils.isEmpty(uf)) {
                    this.gYE.co(uf, stringExtra2);
                    this.gYg.bDq();
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
        if (this.gWr.getStatus() == 8) {
            this.gYg.vH(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nK(boolean z) {
        if (this.gWr != null && (this.gWr.getStatus() == 1 || this.gWr.getStatus() == 3 || this.gWr.getStatus() == 4)) {
            if (!z && this.gYI) {
                this.gYm.bDP();
                return;
            } else {
                this.gYm.bDQ();
                return;
            }
        }
        this.gYm.bDQ();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void E(int i, boolean z) {
        int i2 = 1;
        if (this.goF != i) {
            switch (i) {
                case 1:
                    if (this.gYE != null) {
                        this.gYE.bjo();
                    }
                    this.gWA.setFilter("nature");
                    this.gYo.F(0, false);
                    this.gYo.F(3, false);
                    this.gYg.vH(1);
                    this.gYo.setViewVisibility(0, 8);
                    this.gYo.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.gYo.setViewVisibility(0, 0);
                    this.gYo.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.goF = i;
            this.gYg.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().r("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDX() {
        if (this.gWr.getStatus() == 1 && !this.gYg.bEy()) {
            E(1, true);
            this.gYF.q(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDW() {
        if (this.gWr.getStatus() == 1 && !this.gYg.bEy()) {
            E(2, true);
            this.gYF.q(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        if (this.gCP != null) {
            this.gCP.R(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q(int i, String str) {
        if (this.gCP != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gCP.Q(i, str);
        }
    }
}
