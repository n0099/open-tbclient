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
    private int dOA;
    private final CustomMessageListener dPR;
    private ImageView egr;
    private com.baidu.tieba.i.h gZj;
    private String hnL;
    private SelectMusicModel hnP;
    private b.a hrj;
    private b htY;
    private j hte;
    protected i htn;
    private RecordLayout huQ;
    private VideoControllerLayout huR;
    private RelativeLayout huS;
    private ImageView huT;
    private ImageView huU;
    private ImageView huV;
    private com.baidu.tbadk.core.dialog.a huW;
    private PreviewViewContainer huX;
    private TextView huY;
    private VideoEffectButtonLayout huZ;
    private TextView hva;
    private View hvb;
    private RoundProgressBar hvc;
    private TextView hvd;
    private AnimatorSet hve;
    private AnimatorSet hvf;
    private ScaleAnimation hvg;
    private ObjectAnimator hvh;
    private ObjectAnimator hvi;
    private int hvj;
    private ForumWriteData hvk;
    private boolean hvl;
    private boolean hvm = true;
    private m hvn;
    private StickerItem hvo;
    protected k hvp;
    private RecordTabLayout hvq;
    private ImageFileInfo hvr;
    private HttpMessageListener hvs;
    private boolean hvt;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZj = kVar.aVs();
        }
        if (this.gZj != null) {
            this.gZj.aUZ();
        }
        this.hrj = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dE(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.E(list)) {
                    if (RecordVideoActivity.this.huR != null) {
                        RecordVideoActivity.this.huR.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.huR != null) {
                    RecordVideoActivity.this.huR.setHasLocalVideo(true);
                    RecordVideoActivity.this.hvm = false;
                }
            }
        };
        this.hvs = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.huR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.huR.setStickerItems(list);
                    }
                }
            }
        };
        this.dPR = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bCY() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.htn.hnR);
        videoInfo.setVideoDuration(this.hte.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.htn.hnR).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hvk.writeCallFrom, this.hvk == null ? "" : this.hvk.forumName, this.hvk == null ? "" : this.hvk.forumId, this.hnL, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hvp != null) {
            this.hvp.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.hte.TJ();
        this.htn.bCu();
        if (this.gZj != null) {
            this.gZj.aVc();
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
        if (this.hte != null && this.hte.isRecording()) {
            this.hte.stopRecord();
        }
        if (this.hnP != null) {
            this.hnP.cancelLoadData();
        }
        if (this.gZj != null) {
            this.gZj.pl("record");
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
        this.hvj = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hvk = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hnL = getIntent().getStringExtra("video_title");
        initUI();
        this.hnP = new SelectMusicModel(getPageContext(), this.huR);
        this.hnP.bAZ();
        this.hvp = new k(this);
        this.hvp.b(this.hnP);
        this.hte.a(this.hvp);
        bCZ();
        registerListener(this.hvs);
        registerListener(this.dPR);
    }

    private void bCZ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bBC() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hrj);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.huQ = (RecordLayout) findViewById(d.g.root_layout);
        this.huQ.setListener(this);
        this.hte = new j(this);
        this.huR = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.huR.setRecordController(this.hte);
        this.huR.setRecordControlListener(this);
        this.huR.setEffectChoosedListener(this);
        this.huS = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.egr = (ImageView) findViewById(d.g.close_page);
        this.egr.setOnClickListener(this);
        this.huT = (ImageView) findViewById(d.g.flash_switch);
        this.huT.setOnClickListener(this);
        this.huU = (ImageView) findViewById(d.g.camera_switch);
        this.huU.setOnClickListener(this);
        this.huV = (ImageView) findViewById(d.g.count_down);
        this.huV.setOnClickListener(this);
        this.huX = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.htn = new i(this);
        this.htn.a(this);
        this.htn.setFaceIdentifyStateListener(this);
        this.htn.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bCK() {
                if (RecordVideoActivity.this.huR.bDx()) {
                    RecordVideoActivity.this.huR.a((o) null);
                }
            }
        });
        this.huZ = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.huZ.setListener(this);
        this.hte.a(this.huZ);
        this.huZ.Q(2, true);
        this.huY = (TextView) findViewById(d.g.tv_count_down);
        this.hva = (TextView) findViewById(d.g.gesture_guide_tv);
        int aq = ((com.baidu.adp.lib.util.l.aq(this.mContext) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds150);
        if (this.huY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.huY.getLayoutParams()).topMargin = aq;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.huZ.setVisibility(8);
        }
        this.hvb = findViewById(d.g.progress_layout);
        this.hvc = (RoundProgressBar) this.hvb.findViewById(d.g.video_progress);
        this.hvd = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvd.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ao(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds38);
        this.hvd.setLayoutParams(layoutParams);
        this.hvq = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hvq.al(1, getString(d.j.tab_photo));
        if (this.hvj != 2 && this.hvj != 3) {
            this.hvq.al(2, getString(d.j.tab_record));
            this.hvq.setListener(this);
            this.hvq.C(2, false);
            P(2, false);
            return;
        }
        this.hvq.setShowIndicator(false);
        this.hvq.C(1, false);
        P(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.htn.onResume();
        this.htY = this.htn.bCA();
        if (this.htY != null) {
            this.htY.setRecordController(this.hte);
            this.huX.setZoomHelper(this.htY);
        }
        bDa();
        if (this.hvn == null) {
            this.hvn = new m();
            this.hvn.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void ci(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hvo, str2);
                    if (RecordVideoActivity.this.huR != null) {
                        RecordVideoActivity.this.huR.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void ts(String str) {
                    if (RecordVideoActivity.this.huR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.huR.b(stickerItem);
                        if (RecordVideoActivity.this.htn != null) {
                            RecordVideoActivity.this.htn.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.huR != null) {
                        RecordVideoActivity.this.huR.setDownLoadSticker(null);
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
                    recordVideoActivity.R(5, str);
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void bAg() {
                    if (RecordVideoActivity.this.huR != null) {
                        RecordVideoActivity.this.huR.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hvn.bDs();
        if (this.huR != null && this.hvm) {
            bBC();
        }
        if (this.hvp != null) {
            this.hvp.onResume();
        }
        if (this.gZj != null) {
            this.gZj.pk("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.htn.onPause();
        if (this.huR != null) {
            if (this.hte != null && this.hte.getStatus() == 6) {
                this.huR.stopRecord();
                bDj();
            }
            if (this.hte != null && this.hte.isRecording()) {
                this.huR.stopRecord();
            }
        }
        if (this.hvp != null) {
            this.hvp.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hte == null || this.hte.getStatus() != 7) {
            if (this.hte != null && this.hte.getStatus() == 6) {
                if (this.huR != null) {
                    this.huR.stopRecord();
                }
                bDj();
            } else if (this.hte.onBackPressed()) {
                finish();
            } else {
                if (this.huW == null) {
                    this.huW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.huW.fb(d.j.video_quit_confirm);
                    this.huW.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.huW.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.huW.aV(true);
                    this.huW.b(getPageContext());
                }
                this.huW.AA();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hvd.setVisibility(4);
        if (view == this.egr) {
            onBackPressed();
        } else if (view == this.huT) {
            if (this.hte.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.htn.bCE();
            bDa();
        } else if (view == this.huU) {
            if (this.hte.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.huU.setOnClickListener(null);
            this.htn.bCG();
            if (this.htn.bCH() && this.htn.bCF()) {
                this.htn.bCE();
            }
            bDa();
            this.huU.setOnClickListener(this);
        } else if (view == this.huV) {
            bDc();
        }
    }

    private void bDa() {
        if (this.htn.bCH()) {
            this.huT.setVisibility(8);
        } else {
            this.huT.setVisibility(0);
        }
        if (this.htn.bCF()) {
            this.huT.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.huT.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDb() {
        return this.huX;
    }

    public void bDc() {
        this.hvd.setVisibility(4);
        if (this.hte.getStatus() != 6) {
            this.hte.setStatus(6);
            bDh();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hvg == null) {
                this.hvg = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hvg.setDuration(500L);
                this.hvg.setRepeatCount(5);
                this.hvg.setRepeatMode(2);
                this.hvg.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hvg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hte.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.huY.setVisibility(0);
                        RecordVideoActivity.this.huY.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.huY.setVisibility(8);
                    if (RecordVideoActivity.this.hte.getStatus() == 6) {
                        RecordVideoActivity.this.huR.bDu();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hte.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.huY.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.huY.setText("");
                        }
                    }
                }
            });
            this.huY.setAnimation(this.hvg);
            this.hvg.startNow();
            this.huR.bDc();
            if (this.hvp != null) {
                this.hvp.bCW();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDd() {
        if (this.hte.getStatus() == 1) {
            this.hvd.setVisibility(4);
            if (this.hte.getStatus() != 6) {
                this.huR.bDd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDe() {
        this.hvd.setVisibility(4);
        if (this.hte.getStatus() != 6) {
            this.huR.bDe();
            if (this.huR.bDy()) {
                bCZ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDf() {
        this.hvd.setVisibility(4);
        if (this.hte.getStatus() != 6) {
            this.huR.bDf();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDg() {
        this.hvd.setVisibility(4);
        if (this.hte.getStatus() != 6) {
            this.huR.bDg();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDh() {
        this.hvl = true;
        if (this.hvf != null && this.hvf.isRunning()) {
            this.hvf.cancel();
        }
        if (this.hve == null) {
            this.hve = new AnimatorSet();
            this.hve.playTogether(ObjectAnimator.ofFloat(this.huS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.huZ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hvq, "alpha", 1.0f, 0.0f));
            this.hve.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hwT) {
                        RecordVideoActivity.this.huS.setVisibility(8);
                        RecordVideoActivity.this.huZ.setVisibility(8);
                        RecordVideoActivity.this.hvq.setVisibility(8);
                    }
                }
            });
            this.hve.setDuration(300L);
        }
        this.hve.start();
        this.huZ.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bCW() {
        if (this.dOA == 2) {
            if (this.hvl) {
                this.hvl = false;
                if (this.hvp != null) {
                    this.hvp.bCW();
                }
            } else {
                return;
            }
        }
        if (this.hve != null && this.hve.isRunning()) {
            this.hve.cancel();
        }
        if (this.hvf == null) {
            this.hvf = new AnimatorSet();
            this.hvf.playTogether(ObjectAnimator.ofFloat(this.huS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.huZ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hvq, "alpha", 0.0f, 1.0f));
            this.hvf.setDuration(300L);
        }
        this.huS.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.huZ.setVisibility(0);
        }
        if (this.hte.getStatus() == 1) {
            this.hvq.setVisibility(0);
        }
        this.hvf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDi() {
        if (this.htn != null) {
            this.htn.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void n(boolean z, String str) {
                    RecordVideoActivity.this.hte.setStatus(1);
                    RecordVideoActivity.this.bCW();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hvr != null && !v.E(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hvr)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hvr);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hvr = new ImageFileInfo();
                        RecordVideoActivity.this.hvr.setFilePath(str);
                        RecordVideoActivity.this.hvr.setTempFile(true);
                        RecordVideoActivity.this.hvr.setAlbumnId(null);
                        RecordVideoActivity.this.hvr.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hvr);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hvk, RecordVideoActivity.this.hvj)));
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
    public void bDj() {
        this.hvg.cancel();
        this.hvg.setAnimationListener(null);
        this.huY.clearAnimation();
        this.huY.setVisibility(8);
        if (this.hvp != null) {
            this.hvp.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDk() {
        bsW();
    }

    private void bsW() {
        if (this.hvh != null) {
            this.hvh.cancel();
        }
        if (this.hvi == null) {
            this.hvi = ObjectAnimator.ofFloat(this.hvq, "alpha", 1.0f, 0.0f);
            this.hvi.setDuration(500L);
            this.hvi.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hwT) {
                        RecordVideoActivity.this.hvq.setVisibility(8);
                    }
                }
            });
        }
        this.hvi.start();
    }

    private void bsV() {
        if (this.hvi != null) {
            this.hvi.cancel();
        }
        if (this.hvh == null) {
            this.hvh = ObjectAnimator.ofFloat(this.hvq, "alpha", 0.0f, 1.0f);
            this.hvh.setDuration(500L);
        }
        this.hvq.setVisibility(0);
        this.hvh.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDl() {
        this.huZ.reset();
        if (this.hte.getStatus() == 1) {
            bsV();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bCX() {
        if (this.hvb.getVisibility() != 0) {
            this.huR.bDt();
            this.hte.setStatus(8);
            bCW();
            if (this.htn.htW != null && this.htn.htW.size() > 0) {
                this.hvb.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hvv = 50;
        final int hvw = 1;
        Handler hvx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hvc.aB(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bDq();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bDq() {
            this.hvx.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bDq();
            boolean z = RecordVideoActivity.this.hvp == null || TextUtils.isEmpty(RecordVideoActivity.this.hvp.bCV()) || !new File(RecordVideoActivity.this.hvp.bCV()).exists();
            if (RecordVideoActivity.this.htn.htW.size() > 1) {
                return com.baidu.tieba.video.meida.h.bBV().b(RecordVideoActivity.this.htn.htW, RecordVideoActivity.this.htn.bCx(), z);
            }
            File file = new File(RecordVideoActivity.this.htn.htW.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.htn.bCx()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bBV().b(RecordVideoActivity.this.htn.htW, RecordVideoActivity.this.htn.bCx(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.huR.bDz();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bCY();
                    RecordVideoActivity.this.wX(102);
                    RecordVideoActivity.this.hvb.setVisibility(8);
                    RecordVideoActivity.this.hvp.bCX();
                    return;
                }
                RecordVideoActivity.this.bCY();
                RecordVideoActivity.this.wX(102);
                RecordVideoActivity.this.hvb.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hvb.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.R(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hvc.aB(0.0f);
            RecordVideoActivity.this.hvp.bCX();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.huR == null || v.E(this.huR.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.huR.getChoosedBeautyList()) {
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
        if (this.huR == null || v.E(this.huR.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.huR.getChoosedFilterList()) {
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
        if (this.huR == null || v.E(this.huR.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.huR.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDm() {
        this.hvd.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDn() {
        this.hvd.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDo() {
        if (this.hte.getStatus() == 1) {
            this.hvq.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.htn != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.htn.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").s("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.huZ.Q(2, false);
                            return;
                        } else {
                            this.huZ.Q(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.htn.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ab("obj_id", (String) eVar.getValue());
                        if (this.hte.getStatus() == 1) {
                            akVar.s("obj_type", 1);
                        } else {
                            akVar.s("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.huZ.Q(3, false);
                            return;
                        } else {
                            this.huZ.Q(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hvp.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.huZ.Q(0, false);
                            return;
                        } else {
                            this.huZ.Q(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bDp() {
        if (this.htn != null && this.huZ != null && this.hvp != null) {
            this.htn.setBeautyLevel(com.baidu.tieba.video.a.wC(2));
            this.huZ.Q(2, true);
            this.htn.setFilter("nature");
            this.huZ.Q(3, false);
            this.hvp.a(new MusicData("-100", 1, getResources().getString(d.j.music_normal)), (Object) null);
            this.huZ.Q(0, false);
            if (this.huR != null) {
                this.huR.bDp();
            }
            if (this.htn != null) {
                this.htn.setSticker(null);
                this.hvt = false;
            }
            if (this.huR != null) {
                this.huR.setDownLoadSticker(null);
            }
            this.hva.setVisibility(8);
            this.huZ.Q(1, false);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.hvo = stickerItem;
            this.hvn.tS(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.htn != null) {
                    this.htn.setSticker(null);
                    this.hvt = false;
                }
                if (this.huR != null) {
                    this.huR.setDownLoadSticker(null);
                }
                this.hva.setVisibility(8);
                this.huZ.Q(1, false);
                return;
            }
            String tQ = this.hvn.tQ(stickerItem.resource);
            if (!StringUtils.isNull(tQ)) {
                a(stickerItem, tQ);
                if (this.huR != null) {
                    this.huR.setDownLoadSticker(null);
                }
            } else {
                if (this.huR != null) {
                    this.huR.setDownLoadSticker(stickerItem);
                }
                this.hvn.tR(stickerItem.resource);
            }
            this.huZ.Q(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.htn != null) {
                this.htn.setSticker(stickerItem);
                this.hvt = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hva.setText(stickerItem.desc);
                this.hva.setVisibility(0);
                this.hva.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hva.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hva.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cV(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.huR.getLayoutParams();
            layoutParams.height = i4;
            this.huR.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tB = com.baidu.tieba.video.editvideo.model.a.bAT().tB(stringExtra);
                if (this.hvp != null && !TextUtils.isEmpty(tB)) {
                    this.hvp.cj(tB, stringExtra2);
                    this.huR.bCm();
                }
            }
        } else if (i == 12012) {
            if (i2 == -1) {
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
        } else if (i == 25036 && i2 == -1) {
            bDp();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.hte.getStatus() == 8) {
            this.huR.wZ(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nh(boolean z) {
        if (this.hte != null && (this.hte.getStatus() == 1 || this.hte.getStatus() == 3 || this.hte.getStatus() == 4)) {
            if (!z && this.hvt) {
                this.huX.bCL();
                return;
            } else {
                this.huX.bCM();
                return;
            }
        }
        this.huX.bCM();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void P(int i, boolean z) {
        int i2 = 1;
        if (this.dOA != i) {
            switch (i) {
                case 1:
                    if (this.hvp != null) {
                        this.hvp.bkd();
                    }
                    this.htn.setFilter("nature");
                    this.huZ.Q(0, false);
                    this.huZ.Q(3, false);
                    this.huR.wZ(1);
                    this.huZ.setViewVisibility(0, 8);
                    this.huZ.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.huZ.setViewVisibility(0, 0);
                    this.huZ.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dOA = i;
            this.huR.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().s("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCU() {
        if (this.hte.getStatus() == 1 && !this.huR.bDx()) {
            P(1, true);
            this.hvq.C(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCT() {
        if (this.hte.getStatus() == 1 && !this.huR.bDx()) {
            P(2, true);
            this.hvq.C(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX(int i) {
        if (this.gZj != null) {
            this.gZj.S(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i, String str) {
        if (this.gZj != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gZj.R(i, str);
        }
    }
}
