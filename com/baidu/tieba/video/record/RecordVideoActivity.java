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
    private int dRY;
    private final CustomMessageListener dTx;
    private ImageView ekY;
    private com.baidu.tieba.i.h hbR;
    private String hpu;
    private SelectMusicModel hpy;
    private b.a hsT;
    private j huN;
    protected i huW;
    private b hvG;
    private RelativeLayout hwA;
    private ImageView hwB;
    private ImageView hwC;
    private ImageView hwD;
    private com.baidu.tbadk.core.dialog.a hwE;
    private PreviewViewContainer hwF;
    private TextView hwG;
    private VideoEffectButtonLayout hwH;
    private TextView hwI;
    private View hwJ;
    private RoundProgressBar hwK;
    private TextView hwL;
    private AnimatorSet hwM;
    private AnimatorSet hwN;
    private ScaleAnimation hwO;
    private ObjectAnimator hwP;
    private ObjectAnimator hwQ;
    private int hwR;
    private ForumWriteData hwS;
    private boolean hwT;
    private boolean hwU = true;
    private m hwV;
    private StickerItem hwW;
    protected k hwX;
    private RecordTabLayout hwY;
    private ImageFileInfo hwZ;
    private RecordLayout hwy;
    private VideoControllerLayout hwz;
    private HttpMessageListener hxa;
    private boolean hxb;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbR = kVar.aXg();
        }
        if (this.hbR != null) {
            this.hbR.aWN();
        }
        this.hsT = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dK(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.E(list)) {
                    if (RecordVideoActivity.this.hwz != null) {
                        RecordVideoActivity.this.hwz.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hwz != null) {
                    RecordVideoActivity.this.hwz.setHasLocalVideo(true);
                    RecordVideoActivity.this.hwU = false;
                }
            }
        };
        this.hxa = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hwz != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hwz.setStickerItems(list);
                    }
                }
            }
        };
        this.dTx = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bDI() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.huW.hpA);
        videoInfo.setVideoDuration(this.huN.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.huW.hpA).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hwS.writeCallFrom, this.hwS == null ? "" : this.hwS.forumName, this.hwS == null ? "" : this.hwS.forumId, this.hpu, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hwX != null) {
            this.hwX.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.huN.UD();
        this.huW.bDf();
        if (this.hbR != null) {
            this.hbR.aWQ();
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
        if (this.huN != null && this.huN.isRecording()) {
            this.huN.stopRecord();
        }
        if (this.hpy != null) {
            this.hpy.cancelLoadData();
        }
        if (this.hbR != null) {
            this.hbR.pB("record");
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
        this.hwR = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hwS = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hpu = getIntent().getStringExtra("video_title");
        initUI();
        this.hpy = new SelectMusicModel(getPageContext(), this.hwz);
        this.hpy.bBK();
        this.hwX = new k(this);
        this.hwX.b(this.hpy);
        this.huN.a(this.hwX);
        bDJ();
        registerListener(this.hxa);
        registerListener(this.dTx);
    }

    private void bDJ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCn() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hsT);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hwy = (RecordLayout) findViewById(d.g.root_layout);
        this.hwy.setListener(this);
        this.huN = new j(this);
        this.hwz = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hwz.setRecordController(this.huN);
        this.hwz.setRecordControlListener(this);
        this.hwz.setEffectChoosedListener(this);
        this.hwA = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.ekY = (ImageView) findViewById(d.g.close_page);
        this.ekY.setOnClickListener(this);
        this.hwB = (ImageView) findViewById(d.g.flash_switch);
        this.hwB.setOnClickListener(this);
        this.hwC = (ImageView) findViewById(d.g.camera_switch);
        this.hwC.setOnClickListener(this);
        this.hwD = (ImageView) findViewById(d.g.count_down);
        this.hwD.setOnClickListener(this);
        this.hwF = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.huW = new i(this);
        this.huW.a(this);
        this.huW.setFaceIdentifyStateListener(this);
        this.huW.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bDu() {
                if (RecordVideoActivity.this.hwz.bEh()) {
                    RecordVideoActivity.this.hwz.a((o) null);
                }
            }
        });
        this.hwH = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hwH.setListener(this);
        this.huN.a(this.hwH);
        this.hwH.W(2, true);
        this.hwG = (TextView) findViewById(d.g.tv_count_down);
        this.hwI = (TextView) findViewById(d.g.gesture_guide_tv);
        int aq = ((com.baidu.adp.lib.util.l.aq(this.mContext) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds150);
        if (this.hwG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hwG.getLayoutParams()).topMargin = aq;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hwH.setVisibility(8);
        }
        this.hwJ = findViewById(d.g.progress_layout);
        this.hwK = (RoundProgressBar) this.hwJ.findViewById(d.g.video_progress);
        this.hwL = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hwL.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ao(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds38);
        this.hwL.setLayoutParams(layoutParams);
        this.hwY = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hwY.al(1, getString(d.j.tab_photo));
        if (this.hwR != 2 && this.hwR != 3) {
            this.hwY.al(2, getString(d.j.tab_record));
            this.hwY.setListener(this);
            this.hwY.H(2, false);
            V(2, false);
            return;
        }
        this.hwY.setShowIndicator(false);
        this.hwY.H(1, false);
        V(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.huW.onResume();
        this.hvG = this.huW.bDl();
        if (this.hvG != null) {
            this.hvG.setRecordController(this.huN);
            this.hwF.setZoomHelper(this.hvG);
        }
        bDK();
        if (this.hwV == null) {
            this.hwV = new m();
            this.hwV.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void cj(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hwW, str2);
                    if (RecordVideoActivity.this.hwz != null) {
                        RecordVideoActivity.this.hwz.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tE(String str) {
                    if (RecordVideoActivity.this.hwz != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hwz.b(stickerItem);
                        if (RecordVideoActivity.this.huW != null) {
                            RecordVideoActivity.this.huW.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hwz != null) {
                        RecordVideoActivity.this.hwz.setDownLoadSticker(null);
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
                    recordVideoActivity.U(5, str);
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void bAS() {
                    if (RecordVideoActivity.this.hwz != null) {
                        RecordVideoActivity.this.hwz.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hwV.bEc();
        if (this.hwz != null && this.hwU) {
            bCn();
        }
        if (this.hwX != null) {
            this.hwX.onResume();
        }
        if (this.hbR != null) {
            this.hbR.pA("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.huW.onPause();
        if (this.hwz != null) {
            if (this.huN != null && this.huN.getStatus() == 6) {
                this.hwz.stopRecord();
                bDT();
            }
            if (this.huN != null && this.huN.isRecording()) {
                this.hwz.stopRecord();
            }
        }
        if (this.hwX != null) {
            this.hwX.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.huN == null || this.huN.getStatus() != 7) {
            if (this.huN != null && this.huN.getStatus() == 6) {
                if (this.hwz != null) {
                    this.hwz.stopRecord();
                }
                bDT();
            } else if (this.huN.onBackPressed()) {
                finish();
            } else {
                if (this.hwE == null) {
                    this.hwE = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hwE.fb(d.j.video_quit_confirm);
                    this.hwE.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hwE.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hwE.aZ(true);
                    this.hwE.b(getPageContext());
                }
                this.hwE.AU();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hwL.setVisibility(4);
        if (view == this.ekY) {
            onBackPressed();
        } else if (view == this.hwB) {
            if (this.huN.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.huW.bDo();
            bDK();
        } else if (view == this.hwC) {
            if (this.huN.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hwC.setOnClickListener(null);
            this.huW.bDq();
            if (this.huW.bDr() && this.huW.bDp()) {
                this.huW.bDo();
            }
            bDK();
            this.hwC.setOnClickListener(this);
        } else if (view == this.hwD) {
            bDM();
        }
    }

    private void bDK() {
        if (this.huW.bDr()) {
            this.hwB.setVisibility(8);
        } else {
            this.hwB.setVisibility(0);
        }
        if (this.huW.bDp()) {
            this.hwB.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hwB.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDL() {
        return this.hwF;
    }

    public void bDM() {
        this.hwL.setVisibility(4);
        if (this.huN.getStatus() != 6) {
            this.huN.setStatus(6);
            bDR();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hwO == null) {
                this.hwO = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hwO.setDuration(500L);
                this.hwO.setRepeatCount(5);
                this.hwO.setRepeatMode(2);
                this.hwO.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hwO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.huN.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hwG.setVisibility(0);
                        RecordVideoActivity.this.hwG.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hwG.setVisibility(8);
                    if (RecordVideoActivity.this.huN.getStatus() == 6) {
                        RecordVideoActivity.this.hwz.bEe();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.huN.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hwG.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hwG.setText("");
                        }
                    }
                }
            });
            this.hwG.setAnimation(this.hwO);
            this.hwO.startNow();
            this.hwz.bDM();
            if (this.hwX != null) {
                this.hwX.bDG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDN() {
        if (this.huN.getStatus() == 1) {
            this.hwL.setVisibility(4);
            if (this.huN.getStatus() != 6) {
                this.hwz.bDN();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDO() {
        this.hwL.setVisibility(4);
        if (this.huN.getStatus() != 6) {
            this.hwz.bDO();
            if (this.hwz.bEi()) {
                bDJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        this.hwL.setVisibility(4);
        if (this.huN.getStatus() != 6) {
            this.hwz.bDP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDQ() {
        this.hwL.setVisibility(4);
        if (this.huN.getStatus() != 6) {
            this.hwz.bDQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDR() {
        this.hwT = true;
        if (this.hwN != null && this.hwN.isRunning()) {
            this.hwN.cancel();
        }
        if (this.hwM == null) {
            this.hwM = new AnimatorSet();
            this.hwM.playTogether(ObjectAnimator.ofFloat(this.hwA, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hwH, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hwY, "alpha", 1.0f, 0.0f));
            this.hwM.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyB) {
                        RecordVideoActivity.this.hwA.setVisibility(8);
                        RecordVideoActivity.this.hwH.setVisibility(8);
                        RecordVideoActivity.this.hwY.setVisibility(8);
                    }
                }
            });
            this.hwM.setDuration(300L);
        }
        this.hwM.start();
        this.hwH.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDG() {
        if (this.dRY == 2) {
            if (this.hwT) {
                this.hwT = false;
                if (this.hwX != null) {
                    this.hwX.bDG();
                }
            } else {
                return;
            }
        }
        if (this.hwM != null && this.hwM.isRunning()) {
            this.hwM.cancel();
        }
        if (this.hwN == null) {
            this.hwN = new AnimatorSet();
            this.hwN.playTogether(ObjectAnimator.ofFloat(this.hwA, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hwH, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hwY, "alpha", 0.0f, 1.0f));
            this.hwN.setDuration(300L);
        }
        this.hwA.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hwH.setVisibility(0);
        }
        if (this.huN.getStatus() == 1) {
            this.hwY.setVisibility(0);
        }
        this.hwN.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDS() {
        if (this.huW != null) {
            this.huW.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void n(boolean z, String str) {
                    RecordVideoActivity.this.huN.setStatus(1);
                    RecordVideoActivity.this.bDG();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hwZ != null && !v.E(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hwZ)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hwZ);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hwZ = new ImageFileInfo();
                        RecordVideoActivity.this.hwZ.setFilePath(str);
                        RecordVideoActivity.this.hwZ.setTempFile(true);
                        RecordVideoActivity.this.hwZ.setAlbumnId(null);
                        RecordVideoActivity.this.hwZ.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hwZ);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hwS, RecordVideoActivity.this.hwR)));
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
    public void bDT() {
        this.hwO.cancel();
        this.hwO.setAnimationListener(null);
        this.hwG.clearAnimation();
        this.hwG.setVisibility(8);
        if (this.hwX != null) {
            this.hwX.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDU() {
        bul();
    }

    private void bul() {
        if (this.hwP != null) {
            this.hwP.cancel();
        }
        if (this.hwQ == null) {
            this.hwQ = ObjectAnimator.ofFloat(this.hwY, "alpha", 1.0f, 0.0f);
            this.hwQ.setDuration(500L);
            this.hwQ.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyB) {
                        RecordVideoActivity.this.hwY.setVisibility(8);
                    }
                }
            });
        }
        this.hwQ.start();
    }

    private void buk() {
        if (this.hwQ != null) {
            this.hwQ.cancel();
        }
        if (this.hwP == null) {
            this.hwP = ObjectAnimator.ofFloat(this.hwY, "alpha", 0.0f, 1.0f);
            this.hwP.setDuration(500L);
        }
        this.hwY.setVisibility(0);
        this.hwP.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDV() {
        this.hwH.reset();
        if (this.huN.getStatus() == 1) {
            buk();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDH() {
        if (this.hwJ.getVisibility() != 0) {
            this.hwz.bEd();
            this.huN.setStatus(8);
            bDG();
            if (this.huW.hvE != null && this.huW.hvE.size() > 0) {
                this.hwJ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hxd = 50;
        final int hxe = 1;
        Handler hxf = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hwK.aH(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bEa();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bEa() {
            this.hxf.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bEa();
            boolean z = RecordVideoActivity.this.hwX == null || TextUtils.isEmpty(RecordVideoActivity.this.hwX.bDF()) || !new File(RecordVideoActivity.this.hwX.bDF()).exists();
            if (RecordVideoActivity.this.huW.hvE.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCG().b(RecordVideoActivity.this.huW.hvE, RecordVideoActivity.this.huW.bDi(), z);
            }
            File file = new File(RecordVideoActivity.this.huW.hvE.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.huW.bDi()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCG().b(RecordVideoActivity.this.huW.hvE, RecordVideoActivity.this.huW.bDi(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hwz.bEj();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bDI();
                    RecordVideoActivity.this.wW(102);
                    RecordVideoActivity.this.hwJ.setVisibility(8);
                    RecordVideoActivity.this.hwX.bDH();
                    return;
                }
                RecordVideoActivity.this.bDI();
                RecordVideoActivity.this.wW(102);
                RecordVideoActivity.this.hwJ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hwJ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.U(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hwK.aH(0.0f);
            RecordVideoActivity.this.hwX.bDH();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hwz == null || v.E(this.hwz.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hwz.getChoosedBeautyList()) {
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
        if (this.hwz == null || v.E(this.hwz.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hwz.getChoosedFilterList()) {
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
        if (this.hwz == null || v.E(this.hwz.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hwz.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDW() {
        this.hwL.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDX() {
        this.hwL.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDY() {
        if (this.huN.getStatus() == 1) {
            this.hwY.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.huW != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.huW.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").s("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hwH.W(2, false);
                            return;
                        } else {
                            this.hwH.W(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.huW.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ab("obj_id", (String) eVar.getValue());
                        if (this.huN.getStatus() == 1) {
                            akVar.s("obj_type", 1);
                        } else {
                            akVar.s("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hwH.W(3, false);
                            return;
                        } else {
                            this.hwH.W(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hwX.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hwH.W(0, false);
                            return;
                        } else {
                            this.hwH.W(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bDZ() {
        if (this.huW != null && this.hwH != null && this.hwX != null) {
            this.huW.setBeautyLevel(com.baidu.tieba.video.a.wB(2));
            this.hwH.W(2, true);
            this.huW.setFilter("nature");
            this.hwH.W(3, false);
            this.hwX.a(new MusicData("-100", 1, getResources().getString(d.j.music_normal)), (Object) null);
            this.hwH.W(0, false);
            if (this.hwz != null) {
                this.hwz.bDZ();
            }
            if (this.huW != null) {
                this.huW.setSticker(null);
                this.hxb = false;
            }
            if (this.hwz != null) {
                this.hwz.setDownLoadSticker(null);
            }
            this.hwI.setVisibility(8);
            this.hwH.W(1, false);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.hwW = stickerItem;
            this.hwV.ue(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.huW != null) {
                    this.huW.setSticker(null);
                    this.hxb = false;
                }
                if (this.hwz != null) {
                    this.hwz.setDownLoadSticker(null);
                }
                this.hwI.setVisibility(8);
                this.hwH.W(1, false);
                return;
            }
            String uc = this.hwV.uc(stickerItem.resource);
            if (!StringUtils.isNull(uc)) {
                a(stickerItem, uc);
                if (this.hwz != null) {
                    this.hwz.setDownLoadSticker(null);
                }
            } else {
                if (this.hwz != null) {
                    this.hwz.setDownLoadSticker(stickerItem);
                }
                this.hwV.ud(stickerItem.resource);
            }
            this.hwH.W(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.huW != null) {
                this.huW.setSticker(stickerItem);
                this.hxb = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hwI.setText(stickerItem.desc);
                this.hwI.setVisibility(0);
                this.hwI.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hwI.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hwI.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.q(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hwz.getLayoutParams();
            layoutParams.height = i4;
            this.hwz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tN = com.baidu.tieba.video.editvideo.model.a.bBE().tN(stringExtra);
                if (this.hwX != null && !TextUtils.isEmpty(tN)) {
                    this.hwX.ck(tN, stringExtra2);
                    this.hwz.bCX();
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
            bDZ();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.huN.getStatus() == 8) {
            this.hwz.wY(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nr(boolean z) {
        if (this.huN != null && (this.huN.getStatus() == 1 || this.huN.getStatus() == 3 || this.huN.getStatus() == 4)) {
            if (!z && this.hxb) {
                this.hwF.bDv();
                return;
            } else {
                this.hwF.bDw();
                return;
            }
        }
        this.hwF.bDw();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void V(int i, boolean z) {
        int i2 = 1;
        if (this.dRY != i) {
            switch (i) {
                case 1:
                    if (this.hwX != null) {
                        this.hwX.blr();
                    }
                    this.huW.setFilter("nature");
                    this.hwH.W(0, false);
                    this.hwH.W(3, false);
                    this.hwz.wY(1);
                    this.hwH.setViewVisibility(0, 8);
                    this.hwH.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hwH.setViewVisibility(0, 0);
                    this.hwH.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dRY = i;
            this.hwz.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().s("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDE() {
        if (this.huN.getStatus() == 1 && !this.hwz.bEh()) {
            V(1, true);
            this.hwY.H(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDD() {
        if (this.huN.getStatus() == 1 && !this.hwz.bEh()) {
            V(2, true);
            this.hwY.H(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wW(int i) {
        if (this.hbR != null) {
            this.hbR.V(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        if (this.hbR != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hbR.U(i, str);
        }
    }
}
