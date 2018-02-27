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
    private int dRM;
    private final CustomMessageListener dTl;
    private ImageView ekM;
    private com.baidu.tieba.i.h hbC;
    private String hph;
    private SelectMusicModel hpl;
    private b.a hsG;
    private j huA;
    protected i huJ;
    private b hvt;
    private AnimatorSet hwA;
    private ScaleAnimation hwB;
    private ObjectAnimator hwC;
    private ObjectAnimator hwD;
    private int hwE;
    private ForumWriteData hwF;
    private boolean hwG;
    private boolean hwH = true;
    private m hwI;
    private StickerItem hwJ;
    protected k hwK;
    private RecordTabLayout hwL;
    private ImageFileInfo hwM;
    private HttpMessageListener hwN;
    private boolean hwO;
    private RecordLayout hwl;
    private VideoControllerLayout hwm;
    private RelativeLayout hwn;
    private ImageView hwo;
    private ImageView hwp;
    private ImageView hwq;
    private com.baidu.tbadk.core.dialog.a hwr;
    private PreviewViewContainer hws;
    private TextView hwt;
    private VideoEffectButtonLayout hwu;
    private TextView hwv;
    private View hww;
    private RoundProgressBar hwx;
    private TextView hwy;
    private AnimatorSet hwz;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hbC = kVar.aXf();
        }
        if (this.hbC != null) {
            this.hbC.aWM();
        }
        this.hsG = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dK(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.E(list)) {
                    if (RecordVideoActivity.this.hwm != null) {
                        RecordVideoActivity.this.hwm.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hwm != null) {
                    RecordVideoActivity.this.hwm.setHasLocalVideo(true);
                    RecordVideoActivity.this.hwH = false;
                }
            }
        };
        this.hwN = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hwm != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hwm.setStickerItems(list);
                    }
                }
            }
        };
        this.dTl = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bDH() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.huJ.hpn);
        videoInfo.setVideoDuration(this.huA.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.huJ.hpn).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hwF.writeCallFrom, this.hwF == null ? "" : this.hwF.forumName, this.hwF == null ? "" : this.hwF.forumId, this.hph, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hwK != null) {
            this.hwK.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.huA.UC();
        this.huJ.bDe();
        if (this.hbC != null) {
            this.hbC.aWP();
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
        if (this.huA != null && this.huA.isRecording()) {
            this.huA.stopRecord();
        }
        if (this.hpl != null) {
            this.hpl.cancelLoadData();
        }
        if (this.hbC != null) {
            this.hbC.pB("record");
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
        this.hwE = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hwF = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hph = getIntent().getStringExtra("video_title");
        initUI();
        this.hpl = new SelectMusicModel(getPageContext(), this.hwm);
        this.hpl.bBJ();
        this.hwK = new k(this);
        this.hwK.b(this.hpl);
        this.huA.a(this.hwK);
        bDI();
        registerListener(this.hwN);
        registerListener(this.dTl);
    }

    private void bDI() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCm() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hsG);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hwl = (RecordLayout) findViewById(d.g.root_layout);
        this.hwl.setListener(this);
        this.huA = new j(this);
        this.hwm = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hwm.setRecordController(this.huA);
        this.hwm.setRecordControlListener(this);
        this.hwm.setEffectChoosedListener(this);
        this.hwn = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.ekM = (ImageView) findViewById(d.g.close_page);
        this.ekM.setOnClickListener(this);
        this.hwo = (ImageView) findViewById(d.g.flash_switch);
        this.hwo.setOnClickListener(this);
        this.hwp = (ImageView) findViewById(d.g.camera_switch);
        this.hwp.setOnClickListener(this);
        this.hwq = (ImageView) findViewById(d.g.count_down);
        this.hwq.setOnClickListener(this);
        this.hws = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.huJ = new i(this);
        this.huJ.a(this);
        this.huJ.setFaceIdentifyStateListener(this);
        this.huJ.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bDt() {
                if (RecordVideoActivity.this.hwm.bEg()) {
                    RecordVideoActivity.this.hwm.a((o) null);
                }
            }
        });
        this.hwu = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hwu.setListener(this);
        this.huA.a(this.hwu);
        this.hwu.W(2, true);
        this.hwt = (TextView) findViewById(d.g.tv_count_down);
        this.hwv = (TextView) findViewById(d.g.gesture_guide_tv);
        int aq = ((com.baidu.adp.lib.util.l.aq(this.mContext) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds150);
        if (this.hwt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hwt.getLayoutParams()).topMargin = aq;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hwu.setVisibility(8);
        }
        this.hww = findViewById(d.g.progress_layout);
        this.hwx = (RoundProgressBar) this.hww.findViewById(d.g.video_progress);
        this.hwy = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hwy.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ao(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds38);
        this.hwy.setLayoutParams(layoutParams);
        this.hwL = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hwL.al(1, getString(d.j.tab_photo));
        if (this.hwE != 2 && this.hwE != 3) {
            this.hwL.al(2, getString(d.j.tab_record));
            this.hwL.setListener(this);
            this.hwL.H(2, false);
            V(2, false);
            return;
        }
        this.hwL.setShowIndicator(false);
        this.hwL.H(1, false);
        V(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.huJ.onResume();
        this.hvt = this.huJ.bDk();
        if (this.hvt != null) {
            this.hvt.setRecordController(this.huA);
            this.hws.setZoomHelper(this.hvt);
        }
        bDJ();
        if (this.hwI == null) {
            this.hwI = new m();
            this.hwI.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void cj(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hwJ, str2);
                    if (RecordVideoActivity.this.hwm != null) {
                        RecordVideoActivity.this.hwm.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tE(String str) {
                    if (RecordVideoActivity.this.hwm != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hwm.b(stickerItem);
                        if (RecordVideoActivity.this.huJ != null) {
                            RecordVideoActivity.this.huJ.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hwm != null) {
                        RecordVideoActivity.this.hwm.setDownLoadSticker(null);
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
                public void bAR() {
                    if (RecordVideoActivity.this.hwm != null) {
                        RecordVideoActivity.this.hwm.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hwI.bEb();
        if (this.hwm != null && this.hwH) {
            bCm();
        }
        if (this.hwK != null) {
            this.hwK.onResume();
        }
        if (this.hbC != null) {
            this.hbC.pA("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.huJ.onPause();
        if (this.hwm != null) {
            if (this.huA != null && this.huA.getStatus() == 6) {
                this.hwm.stopRecord();
                bDS();
            }
            if (this.huA != null && this.huA.isRecording()) {
                this.hwm.stopRecord();
            }
        }
        if (this.hwK != null) {
            this.hwK.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.huA == null || this.huA.getStatus() != 7) {
            if (this.huA != null && this.huA.getStatus() == 6) {
                if (this.hwm != null) {
                    this.hwm.stopRecord();
                }
                bDS();
            } else if (this.huA.onBackPressed()) {
                finish();
            } else {
                if (this.hwr == null) {
                    this.hwr = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hwr.fb(d.j.video_quit_confirm);
                    this.hwr.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hwr.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hwr.aZ(true);
                    this.hwr.b(getPageContext());
                }
                this.hwr.AU();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hwy.setVisibility(4);
        if (view == this.ekM) {
            onBackPressed();
        } else if (view == this.hwo) {
            if (this.huA.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.huJ.bDn();
            bDJ();
        } else if (view == this.hwp) {
            if (this.huA.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hwp.setOnClickListener(null);
            this.huJ.bDp();
            if (this.huJ.bDq() && this.huJ.bDo()) {
                this.huJ.bDn();
            }
            bDJ();
            this.hwp.setOnClickListener(this);
        } else if (view == this.hwq) {
            bDL();
        }
    }

    private void bDJ() {
        if (this.huJ.bDq()) {
            this.hwo.setVisibility(8);
        } else {
            this.hwo.setVisibility(0);
        }
        if (this.huJ.bDo()) {
            this.hwo.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hwo.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDK() {
        return this.hws;
    }

    public void bDL() {
        this.hwy.setVisibility(4);
        if (this.huA.getStatus() != 6) {
            this.huA.setStatus(6);
            bDQ();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hwB == null) {
                this.hwB = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hwB.setDuration(500L);
                this.hwB.setRepeatCount(5);
                this.hwB.setRepeatMode(2);
                this.hwB.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hwB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.huA.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hwt.setVisibility(0);
                        RecordVideoActivity.this.hwt.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hwt.setVisibility(8);
                    if (RecordVideoActivity.this.huA.getStatus() == 6) {
                        RecordVideoActivity.this.hwm.bEd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.huA.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hwt.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hwt.setText("");
                        }
                    }
                }
            });
            this.hwt.setAnimation(this.hwB);
            this.hwB.startNow();
            this.hwm.bDL();
            if (this.hwK != null) {
                this.hwK.bDF();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDM() {
        if (this.huA.getStatus() == 1) {
            this.hwy.setVisibility(4);
            if (this.huA.getStatus() != 6) {
                this.hwm.bDM();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDN() {
        this.hwy.setVisibility(4);
        if (this.huA.getStatus() != 6) {
            this.hwm.bDN();
            if (this.hwm.bEh()) {
                bDI();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDO() {
        this.hwy.setVisibility(4);
        if (this.huA.getStatus() != 6) {
            this.hwm.bDO();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDP() {
        this.hwy.setVisibility(4);
        if (this.huA.getStatus() != 6) {
            this.hwm.bDP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDQ() {
        this.hwG = true;
        if (this.hwA != null && this.hwA.isRunning()) {
            this.hwA.cancel();
        }
        if (this.hwz == null) {
            this.hwz = new AnimatorSet();
            this.hwz.playTogether(ObjectAnimator.ofFloat(this.hwn, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hwu, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hwL, "alpha", 1.0f, 0.0f));
            this.hwz.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyo) {
                        RecordVideoActivity.this.hwn.setVisibility(8);
                        RecordVideoActivity.this.hwu.setVisibility(8);
                        RecordVideoActivity.this.hwL.setVisibility(8);
                    }
                }
            });
            this.hwz.setDuration(300L);
        }
        this.hwz.start();
        this.hwu.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDF() {
        if (this.dRM == 2) {
            if (this.hwG) {
                this.hwG = false;
                if (this.hwK != null) {
                    this.hwK.bDF();
                }
            } else {
                return;
            }
        }
        if (this.hwz != null && this.hwz.isRunning()) {
            this.hwz.cancel();
        }
        if (this.hwA == null) {
            this.hwA = new AnimatorSet();
            this.hwA.playTogether(ObjectAnimator.ofFloat(this.hwn, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hwu, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hwL, "alpha", 0.0f, 1.0f));
            this.hwA.setDuration(300L);
        }
        this.hwn.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hwu.setVisibility(0);
        }
        if (this.huA.getStatus() == 1) {
            this.hwL.setVisibility(0);
        }
        this.hwA.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDR() {
        if (this.huJ != null) {
            this.huJ.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void n(boolean z, String str) {
                    RecordVideoActivity.this.huA.setStatus(1);
                    RecordVideoActivity.this.bDF();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hwM != null && !v.E(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hwM)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hwM);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hwM = new ImageFileInfo();
                        RecordVideoActivity.this.hwM.setFilePath(str);
                        RecordVideoActivity.this.hwM.setTempFile(true);
                        RecordVideoActivity.this.hwM.setAlbumnId(null);
                        RecordVideoActivity.this.hwM.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hwM);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hwF, RecordVideoActivity.this.hwE)));
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
    public void bDS() {
        this.hwB.cancel();
        this.hwB.setAnimationListener(null);
        this.hwt.clearAnimation();
        this.hwt.setVisibility(8);
        if (this.hwK != null) {
            this.hwK.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDT() {
        buk();
    }

    private void buk() {
        if (this.hwC != null) {
            this.hwC.cancel();
        }
        if (this.hwD == null) {
            this.hwD = ObjectAnimator.ofFloat(this.hwL, "alpha", 1.0f, 0.0f);
            this.hwD.setDuration(500L);
            this.hwD.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyo) {
                        RecordVideoActivity.this.hwL.setVisibility(8);
                    }
                }
            });
        }
        this.hwD.start();
    }

    private void buj() {
        if (this.hwD != null) {
            this.hwD.cancel();
        }
        if (this.hwC == null) {
            this.hwC = ObjectAnimator.ofFloat(this.hwL, "alpha", 0.0f, 1.0f);
            this.hwC.setDuration(500L);
        }
        this.hwL.setVisibility(0);
        this.hwC.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDU() {
        this.hwu.reset();
        if (this.huA.getStatus() == 1) {
            buj();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDG() {
        if (this.hww.getVisibility() != 0) {
            this.hwm.bEc();
            this.huA.setStatus(8);
            bDF();
            if (this.huJ.hvr != null && this.huJ.hvr.size() > 0) {
                this.hww.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hwQ = 50;
        final int hwR = 1;
        Handler hwS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hwx.aH(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bDZ();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bDZ() {
            this.hwS.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bDZ();
            boolean z = RecordVideoActivity.this.hwK == null || TextUtils.isEmpty(RecordVideoActivity.this.hwK.bDE()) || !new File(RecordVideoActivity.this.hwK.bDE()).exists();
            if (RecordVideoActivity.this.huJ.hvr.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCF().b(RecordVideoActivity.this.huJ.hvr, RecordVideoActivity.this.huJ.bDh(), z);
            }
            File file = new File(RecordVideoActivity.this.huJ.hvr.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.huJ.bDh()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCF().b(RecordVideoActivity.this.huJ.hvr, RecordVideoActivity.this.huJ.bDh(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hwm.bEi();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bDH();
                    RecordVideoActivity.this.wX(102);
                    RecordVideoActivity.this.hww.setVisibility(8);
                    RecordVideoActivity.this.hwK.bDG();
                    return;
                }
                RecordVideoActivity.this.bDH();
                RecordVideoActivity.this.wX(102);
                RecordVideoActivity.this.hww.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hww.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.U(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hwx.aH(0.0f);
            RecordVideoActivity.this.hwK.bDG();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hwm == null || v.E(this.hwm.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hwm.getChoosedBeautyList()) {
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
        if (this.hwm == null || v.E(this.hwm.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hwm.getChoosedFilterList()) {
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
        if (this.hwm == null || v.E(this.hwm.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hwm.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDV() {
        this.hwy.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDW() {
        this.hwy.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDX() {
        if (this.huA.getStatus() == 1) {
            this.hwL.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.huJ != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.huJ.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").s("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hwu.W(2, false);
                            return;
                        } else {
                            this.hwu.W(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.huJ.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ab("obj_id", (String) eVar.getValue());
                        if (this.huA.getStatus() == 1) {
                            akVar.s("obj_type", 1);
                        } else {
                            akVar.s("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hwu.W(3, false);
                            return;
                        } else {
                            this.hwu.W(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hwK.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hwu.W(0, false);
                            return;
                        } else {
                            this.hwu.W(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bDY() {
        if (this.huJ != null && this.hwu != null && this.hwK != null) {
            this.huJ.setBeautyLevel(com.baidu.tieba.video.a.wC(2));
            this.hwu.W(2, true);
            this.huJ.setFilter("nature");
            this.hwu.W(3, false);
            this.hwK.a(new MusicData("-100", 1, getResources().getString(d.j.music_normal)), (Object) null);
            this.hwu.W(0, false);
            if (this.hwm != null) {
                this.hwm.bDY();
            }
            if (this.huJ != null) {
                this.huJ.setSticker(null);
                this.hwO = false;
            }
            if (this.hwm != null) {
                this.hwm.setDownLoadSticker(null);
            }
            this.hwv.setVisibility(8);
            this.hwu.W(1, false);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.hwJ = stickerItem;
            this.hwI.ue(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.huJ != null) {
                    this.huJ.setSticker(null);
                    this.hwO = false;
                }
                if (this.hwm != null) {
                    this.hwm.setDownLoadSticker(null);
                }
                this.hwv.setVisibility(8);
                this.hwu.W(1, false);
                return;
            }
            String uc = this.hwI.uc(stickerItem.resource);
            if (!StringUtils.isNull(uc)) {
                a(stickerItem, uc);
                if (this.hwm != null) {
                    this.hwm.setDownLoadSticker(null);
                }
            } else {
                if (this.hwm != null) {
                    this.hwm.setDownLoadSticker(stickerItem);
                }
                this.hwI.ud(stickerItem.resource);
            }
            this.hwu.W(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.huJ != null) {
                this.huJ.setSticker(stickerItem);
                this.hwO = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hwv.setText(stickerItem.desc);
                this.hwv.setVisibility(0);
                this.hwv.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hwv.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hwv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.q(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hwm.getLayoutParams();
            layoutParams.height = i4;
            this.hwm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tN = com.baidu.tieba.video.editvideo.model.a.bBD().tN(stringExtra);
                if (this.hwK != null && !TextUtils.isEmpty(tN)) {
                    this.hwK.ck(tN, stringExtra2);
                    this.hwm.bCW();
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
            bDY();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.huA.getStatus() == 8) {
            this.hwm.wZ(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nr(boolean z) {
        if (this.huA != null && (this.huA.getStatus() == 1 || this.huA.getStatus() == 3 || this.huA.getStatus() == 4)) {
            if (!z && this.hwO) {
                this.hws.bDu();
                return;
            } else {
                this.hws.bDv();
                return;
            }
        }
        this.hws.bDv();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void V(int i, boolean z) {
        int i2 = 1;
        if (this.dRM != i) {
            switch (i) {
                case 1:
                    if (this.hwK != null) {
                        this.hwK.blq();
                    }
                    this.huJ.setFilter("nature");
                    this.hwu.W(0, false);
                    this.hwu.W(3, false);
                    this.hwm.wZ(1);
                    this.hwu.setViewVisibility(0, 8);
                    this.hwu.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hwu.setViewVisibility(0, 0);
                    this.hwu.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dRM = i;
            this.hwm.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().s("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDD() {
        if (this.huA.getStatus() == 1 && !this.hwm.bEg()) {
            V(1, true);
            this.hwL.H(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDC() {
        if (this.huA.getStatus() == 1 && !this.hwm.bEg()) {
            V(2, true);
            this.hwL.H(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX(int i) {
        if (this.hbC != null) {
            this.hbC.V(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        if (this.hbC != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hbC.U(i, str);
        }
    }
}
