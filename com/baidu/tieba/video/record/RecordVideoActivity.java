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
    private int dOV;
    private final CustomMessageListener dQm;
    private ImageView egM;
    private com.baidu.tieba.i.h gZD;
    private String hof;
    private SelectMusicModel hoj;
    private b.a hrD;
    protected i htH;
    private j hty;
    private b hus;
    private ScaleAnimation hvA;
    private ObjectAnimator hvB;
    private ObjectAnimator hvC;
    private int hvD;
    private ForumWriteData hvE;
    private boolean hvF;
    private boolean hvG = true;
    private m hvH;
    private StickerItem hvI;
    protected k hvJ;
    private RecordTabLayout hvK;
    private ImageFileInfo hvL;
    private HttpMessageListener hvM;
    private boolean hvN;
    private RecordLayout hvk;
    private VideoControllerLayout hvl;
    private RelativeLayout hvm;
    private ImageView hvn;
    private ImageView hvo;
    private ImageView hvp;
    private com.baidu.tbadk.core.dialog.a hvq;
    private PreviewViewContainer hvr;
    private TextView hvs;
    private VideoEffectButtonLayout hvt;
    private TextView hvu;
    private View hvv;
    private RoundProgressBar hvw;
    private TextView hvx;
    private AnimatorSet hvy;
    private AnimatorSet hvz;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.gZD = kVar.aVx();
        }
        if (this.gZD != null) {
            this.gZD.aVe();
        }
        this.hrD = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dE(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.E(list)) {
                    if (RecordVideoActivity.this.hvl != null) {
                        RecordVideoActivity.this.hvl.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hvl != null) {
                    RecordVideoActivity.this.hvl.setHasLocalVideo(true);
                    RecordVideoActivity.this.hvG = false;
                }
            }
        };
        this.hvM = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hvl != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hvl.setStickerItems(list);
                    }
                }
            }
        };
        this.dQm = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bDa() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.htH.hol);
        videoInfo.setVideoDuration(this.hty.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.htH.hol).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hvE.writeCallFrom, this.hvE == null ? "" : this.hvE.forumName, this.hvE == null ? "" : this.hvE.forumId, this.hof, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hvJ != null) {
            this.hvJ.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.hty.TL();
        this.htH.bCw();
        if (this.gZD != null) {
            this.gZD.aVh();
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
        if (this.hty != null && this.hty.isRecording()) {
            this.hty.stopRecord();
        }
        if (this.hoj != null) {
            this.hoj.cancelLoadData();
        }
        if (this.gZD != null) {
            this.gZD.ps("record");
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
        this.hvD = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hvE = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hof = getIntent().getStringExtra("video_title");
        initUI();
        this.hoj = new SelectMusicModel(getPageContext(), this.hvl);
        this.hoj.bBb();
        this.hvJ = new k(this);
        this.hvJ.b(this.hoj);
        this.hty.a(this.hvJ);
        bDb();
        registerListener(this.hvM);
        registerListener(this.dQm);
    }

    private void bDb() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bBE() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hrD);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hvk = (RecordLayout) findViewById(d.g.root_layout);
        this.hvk.setListener(this);
        this.hty = new j(this);
        this.hvl = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hvl.setRecordController(this.hty);
        this.hvl.setRecordControlListener(this);
        this.hvl.setEffectChoosedListener(this);
        this.hvm = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.egM = (ImageView) findViewById(d.g.close_page);
        this.egM.setOnClickListener(this);
        this.hvn = (ImageView) findViewById(d.g.flash_switch);
        this.hvn.setOnClickListener(this);
        this.hvo = (ImageView) findViewById(d.g.camera_switch);
        this.hvo.setOnClickListener(this);
        this.hvp = (ImageView) findViewById(d.g.count_down);
        this.hvp.setOnClickListener(this);
        this.hvr = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.htH = new i(this);
        this.htH.a(this);
        this.htH.setFaceIdentifyStateListener(this);
        this.htH.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bCM() {
                if (RecordVideoActivity.this.hvl.bDz()) {
                    RecordVideoActivity.this.hvl.a((o) null);
                }
            }
        });
        this.hvt = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hvt.setListener(this);
        this.hty.a(this.hvt);
        this.hvt.Q(2, true);
        this.hvs = (TextView) findViewById(d.g.tv_count_down);
        this.hvu = (TextView) findViewById(d.g.gesture_guide_tv);
        int aq = ((com.baidu.adp.lib.util.l.aq(this.mContext) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds150);
        if (this.hvs.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hvs.getLayoutParams()).topMargin = aq;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hvt.setVisibility(8);
        }
        this.hvv = findViewById(d.g.progress_layout);
        this.hvw = (RoundProgressBar) this.hvv.findViewById(d.g.video_progress);
        this.hvx = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hvx.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ao(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds38);
        this.hvx.setLayoutParams(layoutParams);
        this.hvK = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hvK.an(1, getString(d.j.tab_photo));
        if (this.hvD != 2 && this.hvD != 3) {
            this.hvK.an(2, getString(d.j.tab_record));
            this.hvK.setListener(this);
            this.hvK.C(2, false);
            P(2, false);
            return;
        }
        this.hvK.setShowIndicator(false);
        this.hvK.C(1, false);
        P(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.htH.onResume();
        this.hus = this.htH.bCC();
        if (this.hus != null) {
            this.hus.setRecordController(this.hty);
            this.hvr.setZoomHelper(this.hus);
        }
        bDc();
        if (this.hvH == null) {
            this.hvH = new m();
            this.hvH.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void ch(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hvI, str2);
                    if (RecordVideoActivity.this.hvl != null) {
                        RecordVideoActivity.this.hvl.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tz(String str) {
                    if (RecordVideoActivity.this.hvl != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hvl.b(stickerItem);
                        if (RecordVideoActivity.this.htH != null) {
                            RecordVideoActivity.this.htH.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hvl != null) {
                        RecordVideoActivity.this.hvl.setDownLoadSticker(null);
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
                    recordVideoActivity.T(5, str);
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void bAi() {
                    if (RecordVideoActivity.this.hvl != null) {
                        RecordVideoActivity.this.hvl.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hvH.bDu();
        if (this.hvl != null && this.hvG) {
            bBE();
        }
        if (this.hvJ != null) {
            this.hvJ.onResume();
        }
        if (this.gZD != null) {
            this.gZD.pr("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.htH.onPause();
        if (this.hvl != null) {
            if (this.hty != null && this.hty.getStatus() == 6) {
                this.hvl.stopRecord();
                bDl();
            }
            if (this.hty != null && this.hty.isRecording()) {
                this.hvl.stopRecord();
            }
        }
        if (this.hvJ != null) {
            this.hvJ.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hty == null || this.hty.getStatus() != 7) {
            if (this.hty != null && this.hty.getStatus() == 6) {
                if (this.hvl != null) {
                    this.hvl.stopRecord();
                }
                bDl();
            } else if (this.hty.onBackPressed()) {
                finish();
            } else {
                if (this.hvq == null) {
                    this.hvq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hvq.fb(d.j.video_quit_confirm);
                    this.hvq.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hvq.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hvq.aW(true);
                    this.hvq.b(getPageContext());
                }
                this.hvq.AB();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hvx.setVisibility(4);
        if (view == this.egM) {
            onBackPressed();
        } else if (view == this.hvn) {
            if (this.hty.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.htH.bCG();
            bDc();
        } else if (view == this.hvo) {
            if (this.hty.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hvo.setOnClickListener(null);
            this.htH.bCI();
            if (this.htH.bCJ() && this.htH.bCH()) {
                this.htH.bCG();
            }
            bDc();
            this.hvo.setOnClickListener(this);
        } else if (view == this.hvp) {
            bDe();
        }
    }

    private void bDc() {
        if (this.htH.bCJ()) {
            this.hvn.setVisibility(8);
        } else {
            this.hvn.setVisibility(0);
        }
        if (this.htH.bCH()) {
            this.hvn.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hvn.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDd() {
        return this.hvr;
    }

    public void bDe() {
        this.hvx.setVisibility(4);
        if (this.hty.getStatus() != 6) {
            this.hty.setStatus(6);
            bDj();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hvA == null) {
                this.hvA = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hvA.setDuration(500L);
                this.hvA.setRepeatCount(5);
                this.hvA.setRepeatMode(2);
                this.hvA.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hvA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hty.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hvs.setVisibility(0);
                        RecordVideoActivity.this.hvs.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hvs.setVisibility(8);
                    if (RecordVideoActivity.this.hty.getStatus() == 6) {
                        RecordVideoActivity.this.hvl.bDw();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hty.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hvs.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hvs.setText("");
                        }
                    }
                }
            });
            this.hvs.setAnimation(this.hvA);
            this.hvA.startNow();
            this.hvl.bDe();
            if (this.hvJ != null) {
                this.hvJ.bCY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDf() {
        if (this.hty.getStatus() == 1) {
            this.hvx.setVisibility(4);
            if (this.hty.getStatus() != 6) {
                this.hvl.bDf();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDg() {
        this.hvx.setVisibility(4);
        if (this.hty.getStatus() != 6) {
            this.hvl.bDg();
            if (this.hvl.bDA()) {
                bDb();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDh() {
        this.hvx.setVisibility(4);
        if (this.hty.getStatus() != 6) {
            this.hvl.bDh();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDi() {
        this.hvx.setVisibility(4);
        if (this.hty.getStatus() != 6) {
            this.hvl.bDi();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDj() {
        this.hvF = true;
        if (this.hvz != null && this.hvz.isRunning()) {
            this.hvz.cancel();
        }
        if (this.hvy == null) {
            this.hvy = new AnimatorSet();
            this.hvy.playTogether(ObjectAnimator.ofFloat(this.hvm, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hvt, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hvK, "alpha", 1.0f, 0.0f));
            this.hvy.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hxn) {
                        RecordVideoActivity.this.hvm.setVisibility(8);
                        RecordVideoActivity.this.hvt.setVisibility(8);
                        RecordVideoActivity.this.hvK.setVisibility(8);
                    }
                }
            });
            this.hvy.setDuration(300L);
        }
        this.hvy.start();
        this.hvt.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bCY() {
        if (this.dOV == 2) {
            if (this.hvF) {
                this.hvF = false;
                if (this.hvJ != null) {
                    this.hvJ.bCY();
                }
            } else {
                return;
            }
        }
        if (this.hvy != null && this.hvy.isRunning()) {
            this.hvy.cancel();
        }
        if (this.hvz == null) {
            this.hvz = new AnimatorSet();
            this.hvz.playTogether(ObjectAnimator.ofFloat(this.hvm, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hvt, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hvK, "alpha", 0.0f, 1.0f));
            this.hvz.setDuration(300L);
        }
        this.hvm.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hvt.setVisibility(0);
        }
        if (this.hty.getStatus() == 1) {
            this.hvK.setVisibility(0);
        }
        this.hvz.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDk() {
        if (this.htH != null) {
            this.htH.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void n(boolean z, String str) {
                    RecordVideoActivity.this.hty.setStatus(1);
                    RecordVideoActivity.this.bCY();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hvL != null && !v.E(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hvL)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hvL);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hvL = new ImageFileInfo();
                        RecordVideoActivity.this.hvL.setFilePath(str);
                        RecordVideoActivity.this.hvL.setTempFile(true);
                        RecordVideoActivity.this.hvL.setAlbumnId(null);
                        RecordVideoActivity.this.hvL.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hvL);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hvE, RecordVideoActivity.this.hvD)));
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
    public void bDl() {
        this.hvA.cancel();
        this.hvA.setAnimationListener(null);
        this.hvs.clearAnimation();
        this.hvs.setVisibility(8);
        if (this.hvJ != null) {
            this.hvJ.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDm() {
        bsY();
    }

    private void bsY() {
        if (this.hvB != null) {
            this.hvB.cancel();
        }
        if (this.hvC == null) {
            this.hvC = ObjectAnimator.ofFloat(this.hvK, "alpha", 1.0f, 0.0f);
            this.hvC.setDuration(500L);
            this.hvC.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hxn) {
                        RecordVideoActivity.this.hvK.setVisibility(8);
                    }
                }
            });
        }
        this.hvC.start();
    }

    private void bsX() {
        if (this.hvC != null) {
            this.hvC.cancel();
        }
        if (this.hvB == null) {
            this.hvB = ObjectAnimator.ofFloat(this.hvK, "alpha", 0.0f, 1.0f);
            this.hvB.setDuration(500L);
        }
        this.hvK.setVisibility(0);
        this.hvB.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDn() {
        this.hvt.reset();
        if (this.hty.getStatus() == 1) {
            bsX();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bCZ() {
        if (this.hvv.getVisibility() != 0) {
            this.hvl.bDv();
            this.hty.setStatus(8);
            bCY();
            if (this.htH.huq != null && this.htH.huq.size() > 0) {
                this.hvv.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hvP = 50;
        final int hvQ = 1;
        Handler hvR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hvw.aB(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bDs();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bDs() {
            this.hvR.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bDs();
            boolean z = RecordVideoActivity.this.hvJ == null || TextUtils.isEmpty(RecordVideoActivity.this.hvJ.bCX()) || !new File(RecordVideoActivity.this.hvJ.bCX()).exists();
            if (RecordVideoActivity.this.htH.huq.size() > 1) {
                return com.baidu.tieba.video.meida.h.bBX().b(RecordVideoActivity.this.htH.huq, RecordVideoActivity.this.htH.bCz(), z);
            }
            File file = new File(RecordVideoActivity.this.htH.huq.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.htH.bCz()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bBX().b(RecordVideoActivity.this.htH.huq, RecordVideoActivity.this.htH.bCz(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hvl.bDB();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bDa();
                    RecordVideoActivity.this.wX(102);
                    RecordVideoActivity.this.hvv.setVisibility(8);
                    RecordVideoActivity.this.hvJ.bCZ();
                    return;
                }
                RecordVideoActivity.this.bDa();
                RecordVideoActivity.this.wX(102);
                RecordVideoActivity.this.hvv.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hvv.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.T(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hvw.aB(0.0f);
            RecordVideoActivity.this.hvJ.bCZ();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hvl == null || v.E(this.hvl.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hvl.getChoosedBeautyList()) {
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
        if (this.hvl == null || v.E(this.hvl.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hvl.getChoosedFilterList()) {
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
        if (this.hvl == null || v.E(this.hvl.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hvl.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDo() {
        this.hvx.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDp() {
        this.hvx.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDq() {
        if (this.hty.getStatus() == 1) {
            this.hvK.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.htH != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.htH.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").s("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hvt.Q(2, false);
                            return;
                        } else {
                            this.hvt.Q(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.htH.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.aa("obj_id", (String) eVar.getValue());
                        if (this.hty.getStatus() == 1) {
                            akVar.s("obj_type", 1);
                        } else {
                            akVar.s("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hvt.Q(3, false);
                            return;
                        } else {
                            this.hvt.Q(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hvJ.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hvt.Q(0, false);
                            return;
                        } else {
                            this.hvt.Q(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bDr() {
        if (this.htH != null && this.hvt != null && this.hvJ != null) {
            this.htH.setBeautyLevel(com.baidu.tieba.video.a.wC(2));
            this.hvt.Q(2, true);
            this.htH.setFilter("nature");
            this.hvt.Q(3, false);
            this.hvJ.a(new MusicData("-100", 1, getResources().getString(d.j.music_normal)), (Object) null);
            this.hvt.Q(0, false);
            if (this.hvl != null) {
                this.hvl.bDr();
            }
            if (this.htH != null) {
                this.htH.setSticker(null);
                this.hvN = false;
            }
            if (this.hvl != null) {
                this.hvl.setDownLoadSticker(null);
            }
            this.hvu.setVisibility(8);
            this.hvt.Q(1, false);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.hvI = stickerItem;
            this.hvH.tZ(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.htH != null) {
                    this.htH.setSticker(null);
                    this.hvN = false;
                }
                if (this.hvl != null) {
                    this.hvl.setDownLoadSticker(null);
                }
                this.hvu.setVisibility(8);
                this.hvt.Q(1, false);
                return;
            }
            String tX = this.hvH.tX(stickerItem.resource);
            if (!StringUtils.isNull(tX)) {
                a(stickerItem, tX);
                if (this.hvl != null) {
                    this.hvl.setDownLoadSticker(null);
                }
            } else {
                if (this.hvl != null) {
                    this.hvl.setDownLoadSticker(stickerItem);
                }
                this.hvH.tY(stickerItem.resource);
            }
            this.hvt.Q(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.htH != null) {
                this.htH.setSticker(stickerItem);
                this.hvN = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hvu.setText(stickerItem.desc);
                this.hvu.setVisibility(0);
                this.hvu.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hvu.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hvu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cV(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hvl.getLayoutParams();
            layoutParams.height = i4;
            this.hvl.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tI = com.baidu.tieba.video.editvideo.model.a.bAV().tI(stringExtra);
                if (this.hvJ != null && !TextUtils.isEmpty(tI)) {
                    this.hvJ.ci(tI, stringExtra2);
                    this.hvl.bCo();
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
            bDr();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.hty.getStatus() == 8) {
            this.hvl.wZ(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nj(boolean z) {
        if (this.hty != null && (this.hty.getStatus() == 1 || this.hty.getStatus() == 3 || this.hty.getStatus() == 4)) {
            if (!z && this.hvN) {
                this.hvr.bCN();
                return;
            } else {
                this.hvr.bCO();
                return;
            }
        }
        this.hvr.bCO();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void P(int i, boolean z) {
        int i2 = 1;
        if (this.dOV != i) {
            switch (i) {
                case 1:
                    if (this.hvJ != null) {
                        this.hvJ.bke();
                    }
                    this.htH.setFilter("nature");
                    this.hvt.Q(0, false);
                    this.hvt.Q(3, false);
                    this.hvl.wZ(1);
                    this.hvt.setViewVisibility(0, 8);
                    this.hvt.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hvt.setViewVisibility(0, 0);
                    this.hvt.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dOV = i;
            this.hvl.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().s("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCW() {
        if (this.hty.getStatus() == 1 && !this.hvl.bDz()) {
            P(1, true);
            this.hvK.C(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bCV() {
        if (this.hty.getStatus() == 1 && !this.hvl.bDz()) {
            P(2, true);
            this.hvK.C(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX(int i) {
        if (this.gZD != null) {
            this.gZD.U(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        if (this.gZD != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.gZD.T(i, str);
        }
    }
}
