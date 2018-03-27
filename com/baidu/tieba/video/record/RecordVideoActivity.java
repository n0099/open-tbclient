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
    private int dRR;
    private final CustomMessageListener dTq;
    private ImageView elc;
    private com.baidu.tieba.i.h hca;
    private String hpF;
    private SelectMusicModel hpJ;
    private b.a hte;
    private j huY;
    private b hvR;
    protected i hvh;
    private RecordLayout hwJ;
    private VideoControllerLayout hwK;
    private RelativeLayout hwL;
    private ImageView hwM;
    private ImageView hwN;
    private ImageView hwO;
    private com.baidu.tbadk.core.dialog.a hwP;
    private PreviewViewContainer hwQ;
    private TextView hwR;
    private VideoEffectButtonLayout hwS;
    private TextView hwT;
    private View hwU;
    private RoundProgressBar hwV;
    private TextView hwW;
    private AnimatorSet hwX;
    private AnimatorSet hwY;
    private ScaleAnimation hwZ;
    private ObjectAnimator hxa;
    private ObjectAnimator hxb;
    private int hxc;
    private ForumWriteData hxd;
    private boolean hxe;
    private boolean hxf = true;
    private m hxg;
    private StickerItem hxh;
    protected k hxi;
    private RecordTabLayout hxj;
    private ImageFileInfo hxk;
    private HttpMessageListener hxl;
    private boolean hxm;
    private Context mContext;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.i.k.class);
        com.baidu.tieba.i.k kVar = runTask != null ? (com.baidu.tieba.i.k) runTask.getData() : null;
        if (kVar != null) {
            this.hca = kVar.aXg();
        }
        if (this.hca != null) {
            this.hca.aWN();
        }
        this.hte = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dK(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.E(list)) {
                    if (RecordVideoActivity.this.hwK != null) {
                        RecordVideoActivity.this.hwK.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hwK != null) {
                    RecordVideoActivity.this.hwK.setHasLocalVideo(true);
                    RecordVideoActivity.this.hxf = false;
                }
            }
        };
        this.hxl = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hwK != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hwK.setStickerItems(list);
                    }
                }
            }
        };
        this.dTq = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bDM() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hvh.hpL);
        videoInfo.setVideoDuration(this.huY.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hvh.hpL).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hxd.writeCallFrom, this.hxd == null ? "" : this.hxd.forumName, this.hxd == null ? "" : this.hxd.forumId, this.hpF, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hxi != null) {
            this.hxi.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        this.huY.UD();
        this.hvh.bDj();
        if (this.hca != null) {
            this.hca.aWQ();
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
        if (this.huY != null && this.huY.isRecording()) {
            this.huY.stopRecord();
        }
        if (this.hpJ != null) {
            this.hpJ.cancelLoadData();
        }
        if (this.hca != null) {
            this.hca.pB("record");
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
        this.hxc = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hxd = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hpF = getIntent().getStringExtra("video_title");
        initUI();
        this.hpJ = new SelectMusicModel(getPageContext(), this.hwK);
        this.hpJ.bBO();
        this.hxi = new k(this);
        this.hxi.b(this.hpJ);
        this.huY.a(this.hxi);
        bDN();
        registerListener(this.hxl);
        registerListener(this.dTq);
    }

    private void bDN() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bCr() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hte);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hwJ = (RecordLayout) findViewById(d.g.root_layout);
        this.hwJ.setListener(this);
        this.huY = new j(this);
        this.hwK = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.hwK.setRecordController(this.huY);
        this.hwK.setRecordControlListener(this);
        this.hwK.setEffectChoosedListener(this);
        this.hwL = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.elc = (ImageView) findViewById(d.g.close_page);
        this.elc.setOnClickListener(this);
        this.hwM = (ImageView) findViewById(d.g.flash_switch);
        this.hwM.setOnClickListener(this);
        this.hwN = (ImageView) findViewById(d.g.camera_switch);
        this.hwN.setOnClickListener(this);
        this.hwO = (ImageView) findViewById(d.g.count_down);
        this.hwO.setOnClickListener(this);
        this.hwQ = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.hvh = new i(this);
        this.hvh.a(this);
        this.hvh.setFaceIdentifyStateListener(this);
        this.hvh.a(new i.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.i.b
            public void bDy() {
                if (RecordVideoActivity.this.hwK.bEl()) {
                    RecordVideoActivity.this.hwK.a((o) null);
                }
            }
        });
        this.hwS = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.hwS.setListener(this);
        this.huY.a(this.hwS);
        this.hwS.W(2, true);
        this.hwR = (TextView) findViewById(d.g.tv_count_down);
        this.hwT = (TextView) findViewById(d.g.gesture_guide_tv);
        int aq = ((com.baidu.adp.lib.util.l.aq(this.mContext) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds150);
        if (this.hwR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hwR.getLayoutParams()).topMargin = aq;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hwS.setVisibility(8);
        }
        this.hwU = findViewById(d.g.progress_layout);
        this.hwV = (RoundProgressBar) this.hwU.findViewById(d.g.video_progress);
        this.hwW = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hwW.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ao(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds38);
        this.hwW.setLayoutParams(layoutParams);
        this.hxj = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.hxj.al(1, getString(d.j.tab_photo));
        if (this.hxc != 2 && this.hxc != 3) {
            this.hxj.al(2, getString(d.j.tab_record));
            this.hxj.setListener(this);
            this.hxj.H(2, false);
            V(2, false);
            return;
        }
        this.hxj.setShowIndicator(false);
        this.hxj.H(1, false);
        V(1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hvh.onResume();
        this.hvR = this.hvh.bDp();
        if (this.hvR != null) {
            this.hvR.setRecordController(this.huY);
            this.hwQ.setZoomHelper(this.hvR);
        }
        bDO();
        if (this.hxg == null) {
            this.hxg = new m();
            this.hxg.a(new m.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.m.a
                public void cj(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hxh, str2);
                    if (RecordVideoActivity.this.hwK != null) {
                        RecordVideoActivity.this.hwK.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.m.a
                public void tE(String str) {
                    if (RecordVideoActivity.this.hwK != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hwK.b(stickerItem);
                        if (RecordVideoActivity.this.hvh != null) {
                            RecordVideoActivity.this.hvh.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hwK != null) {
                        RecordVideoActivity.this.hwK.setDownLoadSticker(null);
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
                public void bAW() {
                    if (RecordVideoActivity.this.hwK != null) {
                        RecordVideoActivity.this.hwK.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hxg.bEg();
        if (this.hwK != null && this.hxf) {
            bCr();
        }
        if (this.hxi != null) {
            this.hxi.onResume();
        }
        if (this.hca != null) {
            this.hca.pA("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hvh.onPause();
        if (this.hwK != null) {
            if (this.huY != null && this.huY.getStatus() == 6) {
                this.hwK.stopRecord();
                bDX();
            }
            if (this.huY != null && this.huY.isRecording()) {
                this.hwK.stopRecord();
            }
        }
        if (this.hxi != null) {
            this.hxi.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.huY == null || this.huY.getStatus() != 7) {
            if (this.huY != null && this.huY.getStatus() == 6) {
                if (this.hwK != null) {
                    this.hwK.stopRecord();
                }
                bDX();
            } else if (this.huY.onBackPressed()) {
                finish();
            } else {
                if (this.hwP == null) {
                    this.hwP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hwP.fb(d.j.video_quit_confirm);
                    this.hwP.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hwP.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hwP.aZ(true);
                    this.hwP.b(getPageContext());
                }
                this.hwP.AV();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hwW.setVisibility(4);
        if (view == this.elc) {
            onBackPressed();
        } else if (view == this.hwM) {
            if (this.huY.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hvh.bDs();
            bDO();
        } else if (view == this.hwN) {
            if (this.huY.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hwN.setOnClickListener(null);
            this.hvh.bDu();
            if (this.hvh.bDv() && this.hvh.bDt()) {
                this.hvh.bDs();
            }
            bDO();
            this.hwN.setOnClickListener(this);
        } else if (view == this.hwO) {
            bDQ();
        }
    }

    private void bDO() {
        if (this.hvh.bDv()) {
            this.hwM.setVisibility(8);
        } else {
            this.hwM.setVisibility(0);
        }
        if (this.hvh.bDt()) {
            this.hwM.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.hwM.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bDP() {
        return this.hwQ;
    }

    public void bDQ() {
        this.hwW.setVisibility(4);
        if (this.huY.getStatus() != 6) {
            this.huY.setStatus(6);
            bDV();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hwZ == null) {
                this.hwZ = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hwZ.setDuration(500L);
                this.hwZ.setRepeatCount(5);
                this.hwZ.setRepeatMode(2);
                this.hwZ.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hwZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.huY.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hwR.setVisibility(0);
                        RecordVideoActivity.this.hwR.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hwR.setVisibility(8);
                    if (RecordVideoActivity.this.huY.getStatus() == 6) {
                        RecordVideoActivity.this.hwK.bEi();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.huY.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hwR.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hwR.setText("");
                        }
                    }
                }
            });
            this.hwR.setAnimation(this.hwZ);
            this.hwZ.startNow();
            this.hwK.bDQ();
            if (this.hxi != null) {
                this.hxi.bDK();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDR() {
        if (this.huY.getStatus() == 1) {
            this.hwW.setVisibility(4);
            if (this.huY.getStatus() != 6) {
                this.hwK.bDR();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDS() {
        this.hwW.setVisibility(4);
        if (this.huY.getStatus() != 6) {
            this.hwK.bDS();
            if (this.hwK.bEm()) {
                bDN();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDT() {
        this.hwW.setVisibility(4);
        if (this.huY.getStatus() != 6) {
            this.hwK.bDT();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bDU() {
        this.hwW.setVisibility(4);
        if (this.huY.getStatus() != 6) {
            this.hwK.bDU();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDV() {
        this.hxe = true;
        if (this.hwY != null && this.hwY.isRunning()) {
            this.hwY.cancel();
        }
        if (this.hwX == null) {
            this.hwX = new AnimatorSet();
            this.hwX.playTogether(ObjectAnimator.ofFloat(this.hwL, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hwS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hxj, "alpha", 1.0f, 0.0f));
            this.hwX.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyM) {
                        RecordVideoActivity.this.hwL.setVisibility(8);
                        RecordVideoActivity.this.hwS.setVisibility(8);
                        RecordVideoActivity.this.hxj.setVisibility(8);
                    }
                }
            });
            this.hwX.setDuration(300L);
        }
        this.hwX.start();
        this.hwS.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDK() {
        if (this.dRR == 2) {
            if (this.hxe) {
                this.hxe = false;
                if (this.hxi != null) {
                    this.hxi.bDK();
                }
            } else {
                return;
            }
        }
        if (this.hwX != null && this.hwX.isRunning()) {
            this.hwX.cancel();
        }
        if (this.hwY == null) {
            this.hwY = new AnimatorSet();
            this.hwY.playTogether(ObjectAnimator.ofFloat(this.hwL, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hwS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hxj, "alpha", 0.0f, 1.0f));
            this.hwY.setDuration(300L);
        }
        this.hwL.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hwS.setVisibility(0);
        }
        if (this.huY.getStatus() == 1) {
            this.hxj.setVisibility(0);
        }
        this.hwY.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDW() {
        if (this.hvh != null) {
            this.hvh.a(new h.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.h.a
                public void n(boolean z, String str) {
                    RecordVideoActivity.this.huY.setStatus(1);
                    RecordVideoActivity.this.bDK();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hxk != null && !v.E(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hxk)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hxk);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hxk = new ImageFileInfo();
                        RecordVideoActivity.this.hxk.setFilePath(str);
                        RecordVideoActivity.this.hxk.setTempFile(true);
                        RecordVideoActivity.this.hxk.setAlbumnId(null);
                        RecordVideoActivity.this.hxk.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hxk);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hxd, RecordVideoActivity.this.hxc)));
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
    public void bDX() {
        this.hwZ.cancel();
        this.hwZ.setAnimationListener(null);
        this.hwR.clearAnimation();
        this.hwR.setVisibility(8);
        if (this.hxi != null) {
            this.hxi.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDY() {
        bul();
    }

    private void bul() {
        if (this.hxa != null) {
            this.hxa.cancel();
        }
        if (this.hxb == null) {
            this.hxb = ObjectAnimator.ofFloat(this.hxj, "alpha", 1.0f, 0.0f);
            this.hxb.setDuration(500L);
            this.hxb.addListener(new o() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.o, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hyM) {
                        RecordVideoActivity.this.hxj.setVisibility(8);
                    }
                }
            });
        }
        this.hxb.start();
    }

    private void buk() {
        if (this.hxb != null) {
            this.hxb.cancel();
        }
        if (this.hxa == null) {
            this.hxa = ObjectAnimator.ofFloat(this.hxj, "alpha", 0.0f, 1.0f);
            this.hxa.setDuration(500L);
        }
        this.hxj.setVisibility(0);
        this.hxa.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDZ() {
        this.hwS.reset();
        if (this.huY.getStatus() == 1) {
            buk();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bDL() {
        if (this.hwU.getVisibility() != 0) {
            this.hwK.bEh();
            this.huY.setStatus(8);
            bDK();
            if (this.hvh.hvP != null && this.hvh.hvP.size() > 0) {
                this.hwU.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hxo = 50;
        final int hxp = 1;
        Handler hxq = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hwV.aH(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bEe();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bEe() {
            this.hxq.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bEe();
            boolean z = RecordVideoActivity.this.hxi == null || TextUtils.isEmpty(RecordVideoActivity.this.hxi.bDJ()) || !new File(RecordVideoActivity.this.hxi.bDJ()).exists();
            if (RecordVideoActivity.this.hvh.hvP.size() > 1) {
                return com.baidu.tieba.video.meida.h.bCK().b(RecordVideoActivity.this.hvh.hvP, RecordVideoActivity.this.hvh.bDm(), z);
            }
            File file = new File(RecordVideoActivity.this.hvh.hvP.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                file.renameTo(new File(RecordVideoActivity.this.hvh.bDm()));
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bCK().b(RecordVideoActivity.this.hvh.hvP, RecordVideoActivity.this.hvh.bDm(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hwK.bEn();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bDM();
                    RecordVideoActivity.this.wX(102);
                    RecordVideoActivity.this.hwU.setVisibility(8);
                    RecordVideoActivity.this.hxi.bDL();
                    return;
                }
                RecordVideoActivity.this.bDM();
                RecordVideoActivity.this.wX(102);
                RecordVideoActivity.this.hwU.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.hwU.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.U(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hwV.aH(0.0f);
            RecordVideoActivity.this.hxi.bDL();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hwK == null || v.E(this.hwK.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hwK.getChoosedBeautyList()) {
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
        if (this.hwK == null || v.E(this.hwK.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hwK.getChoosedFilterList()) {
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
        if (this.hwK == null || v.E(this.hwK.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hwK.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEa() {
        this.hwW.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEb() {
        this.hwW.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bEc() {
        if (this.huY.getStatus() == 1) {
            this.hxj.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hvh != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hvh.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ak("c12421").s("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hwS.W(2, false);
                            return;
                        } else {
                            this.hwS.W(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hvh.setFilter((String) eVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ab("obj_id", (String) eVar.getValue());
                        if (this.huY.getStatus() == 1) {
                            akVar.s("obj_type", 1);
                        } else {
                            akVar.s("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hwS.W(3, false);
                            return;
                        } else {
                            this.hwS.W(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hxi.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hwS.W(0, false);
                            return;
                        } else {
                            this.hwS.W(0, true);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void bEd() {
        if (this.hvh != null && this.hwS != null && this.hxi != null) {
            this.hvh.setBeautyLevel(com.baidu.tieba.video.a.wC(2));
            this.hwS.W(2, true);
            this.hvh.setFilter("nature");
            this.hwS.W(3, false);
            this.hxi.a(new MusicData("-100", 1, getResources().getString(d.j.music_normal)), (Object) null);
            this.hwS.W(0, false);
            if (this.hwK != null) {
                this.hwK.bEd();
            }
            if (this.hvh != null) {
                this.hvh.setSticker(null);
                this.hxm = false;
            }
            if (this.hwK != null) {
                this.hwK.setDownLoadSticker(null);
            }
            this.hwT.setVisibility(8);
            this.hwS.W(1, false);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(StickerItem stickerItem) {
        if (stickerItem != null) {
            this.hxh = stickerItem;
            this.hxg.ue(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hvh != null) {
                    this.hvh.setSticker(null);
                    this.hxm = false;
                }
                if (this.hwK != null) {
                    this.hwK.setDownLoadSticker(null);
                }
                this.hwT.setVisibility(8);
                this.hwS.W(1, false);
                return;
            }
            String uc = this.hxg.uc(stickerItem.resource);
            if (!StringUtils.isNull(uc)) {
                a(stickerItem, uc);
                if (this.hwK != null) {
                    this.hwK.setDownLoadSticker(null);
                }
            } else {
                if (this.hwK != null) {
                    this.hwK.setDownLoadSticker(stickerItem);
                }
                this.hxg.ud(stickerItem.resource);
            }
            this.hwS.W(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hvh != null) {
                this.hvh.setSticker(stickerItem);
                this.hxm = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hwT.setText(stickerItem.desc);
                this.hwT.setVisibility(0);
                this.hwT.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hwT.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hwT.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.i.c
    public void cQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.q(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hwK.getLayoutParams();
            layoutParams.height = i4;
            this.hwK.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tN = com.baidu.tieba.video.editvideo.model.a.bBI().tN(stringExtra);
                if (this.hxi != null && !TextUtils.isEmpty(tN)) {
                    this.hxi.ck(tN, stringExtra2);
                    this.hwK.bDb();
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
            bEd();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (this.huY.getStatus() == 8) {
            this.hwK.wZ(1);
        }
    }

    @Override // com.baidu.tieba.video.record.g.a
    public void nw(boolean z) {
        if (this.huY != null && (this.huY.getStatus() == 1 || this.huY.getStatus() == 3 || this.huY.getStatus() == 4)) {
            if (!z && this.hxm) {
                this.hwQ.bDz();
                return;
            } else {
                this.hwQ.bDA();
                return;
            }
        }
        this.hwQ.bDA();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void V(int i, boolean z) {
        int i2 = 1;
        if (this.dRR != i) {
            switch (i) {
                case 1:
                    if (this.hxi != null) {
                        this.hxi.blr();
                    }
                    this.hvh.setFilter("nature");
                    this.hwS.W(0, false);
                    this.hwS.W(3, false);
                    this.hwK.wZ(1);
                    this.hwS.setViewVisibility(0, 8);
                    this.hwS.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hwS.setViewVisibility(0, 0);
                    this.hwS.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dRR = i;
            this.hwK.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ak().s("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDI() {
        if (this.huY.getStatus() == 1 && !this.hwK.bEl()) {
            V(1, true);
            this.hxj.H(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bDH() {
        if (this.huY.getStatus() == 1 && !this.hwK.bEl()) {
            V(2, true);
            this.hxj.H(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX(int i) {
        if (this.hca != null) {
            this.hca.V(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        if (this.hca != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hca.U(i, str);
        }
    }
}
