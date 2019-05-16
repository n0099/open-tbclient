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
import com.baidu.mobstat.Config;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
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
/* loaded from: classes5.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private int fFW;
    private final CustomMessageListener fHF;
    private ImageView geN;
    private com.baidu.tieba.j.h iZR;
    private String joT;
    private SelectMusicModel joX;
    private b.a jsj;
    private i jtD;
    protected h jtL;
    private b juu;
    private AnimatorSet jvA;
    private AnimatorSet jvB;
    private ScaleAnimation jvC;
    private ObjectAnimator jvD;
    private ObjectAnimator jvE;
    private int jvF;
    private ForumWriteData jvG;
    private boolean jvH;
    private boolean jvI = true;
    private l jvJ;
    private StickerItem jvK;
    protected j jvL;
    private RecordTabLayout jvM;
    private ImageFileInfo jvN;
    private HttpMessageListener jvO;
    private boolean jvP;
    private RecordLayout jvm;
    private VideoControllerLayout jvn;
    private RelativeLayout jvo;
    private ImageView jvp;
    private ImageView jvq;
    private ImageView jvr;
    private com.baidu.tbadk.core.dialog.a jvs;
    private PreviewViewContainer jvt;
    private TextView jvu;
    private VideoEffectButtonLayout jvv;
    private TextView jvw;
    private View jvx;
    private RoundProgressBar jvy;
    private TextView jvz;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZR = lVar.bMk();
        }
        if (this.iZR != null) {
            this.iZR.bLO();
        }
        this.jsj = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eo(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.aa(list)) {
                    if (RecordVideoActivity.this.jvn != null) {
                        RecordVideoActivity.this.jvn.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jvn != null) {
                    RecordVideoActivity.this.jvn.setHasLocalVideo(true);
                    RecordVideoActivity.this.jvI = false;
                }
            }
        };
        this.jvO = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jvn != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jvn.setStickerItems(list);
                    }
                }
            }
        };
        this.fHF = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctB() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jtL.joZ);
        videoInfo.setVideoDuration(this.jtD.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jtL.joZ).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jvG == null ? "" : this.jvG.forumName;
        String str2 = this.jvG == null ? "" : this.jvG.forumId;
        int i = this.jvG == null ? -1 : this.jvG.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jvG.writeCallFrom, str, str2, this.joT, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jvL != null) {
            this.jvL.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.iZR != null) {
            this.iZR.bLR();
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
        if (this.jtD != null && this.jtD.akv()) {
            this.jtD.stopRecord();
        }
        if (this.joX != null) {
            this.joX.cancelLoadData();
        }
        if (this.iZR != null) {
            this.iZR.Am("record");
        }
        com.baidu.tbadk.core.util.m.A(new File(com.baidu.tieba.video.c.jnn));
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
        setContentView(R.layout.record_activity);
        this.jvF = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jvG = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.joT = getIntent().getStringExtra("video_title");
        initUI();
        this.joX = new SelectMusicModel(getPageContext(), this.jvn);
        this.joX.crR();
        this.jvL = new j(this);
        this.jvL.b(this.joX);
        this.jtD.a(this.jvL);
        registerListener(this.jvO);
        registerListener(this.fHF);
        ctC();
    }

    private void ctC() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void csu() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jsj);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jvm = (RecordLayout) findViewById(R.id.root_layout);
        this.jvm.setListener(this);
        this.jtD = new i(this);
        this.jvn = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jvn.setRecordController(this.jtD);
        this.jvn.setRecordControlListener(this);
        this.jvn.setEffectChoosedListener(this);
        this.jvo = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.geN = (ImageView) findViewById(R.id.close_page);
        this.geN.setOnClickListener(this);
        this.jvp = (ImageView) findViewById(R.id.flash_switch);
        this.jvp.setOnClickListener(this);
        this.jvq = (ImageView) findViewById(R.id.camera_switch);
        this.jvq.setOnClickListener(this);
        this.jvr = (ImageView) findViewById(R.id.count_down);
        this.jvr.setOnClickListener(this);
        this.jvt = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jtL = new h(this);
        this.jtL.a(this);
        this.jtL.setFaceIdentifyStateListener(this);
        this.jtL.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void ctp() {
                if (RecordVideoActivity.this.jvn.cub()) {
                    RecordVideoActivity.this.jvn.a((m) null);
                }
            }
        });
        this.jvv = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jvv.setListener(this);
        this.jtD.a(this.jvv);
        this.jvv.setViewChoosed(2, true);
        this.jvu = (TextView) findViewById(R.id.tv_count_down);
        this.jvw = (TextView) findViewById(R.id.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds150);
        if (this.jvu.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jvu.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jvv.setVisibility(8);
        }
        this.jvx = findViewById(R.id.progress_layout);
        this.jvy = (RoundProgressBar) this.jvx.findViewById(R.id.video_progress);
        this.jvz = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jvz.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds38);
        this.jvz.setLayoutParams(layoutParams);
        this.jvM = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jvM.aM(1, getString(R.string.tab_photo));
        if (this.jvF != 2 && this.jvF != 3) {
            this.jvM.aM(2, getString(R.string.tab_record));
            this.jvM.setListener(this);
            this.jvM.setCurrentTab(2, false);
            R(2, false);
        } else {
            this.jvM.setShowIndicator(false);
            this.jvM.setCurrentTab(1, false);
            R(1, false);
        }
        ctD();
    }

    private void ctD() {
        if (com.baidu.tbadk.core.util.g.agV()) {
            this.mStatusBarView = findViewById(R.id.statusbar_view);
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
        this.jtL.onResume();
        this.juu = this.jtL.ctg();
        if (this.juu != null) {
            this.juu.setRecordController(this.jtD);
            this.jvt.setZoomHelper(this.juu);
        }
        ctE();
        if (this.jvJ == null) {
            this.jvJ = new l();
            this.jvJ.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void er(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jvK, str2);
                    if (RecordVideoActivity.this.jvn != null) {
                        RecordVideoActivity.this.jvn.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void EO(String str) {
                    if (RecordVideoActivity.this.jvn != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jvn.b(stickerItem);
                        if (RecordVideoActivity.this.jtL != null) {
                            RecordVideoActivity.this.jtL.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jvn != null) {
                        RecordVideoActivity.this.jvn.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(R.string.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(R.string.sticker_download_error);
                    }
                    recordVideoActivity.av(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void cqZ() {
                    if (RecordVideoActivity.this.jvn != null) {
                        RecordVideoActivity.this.jvn.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jvJ.ctV();
        if (this.jvn != null && this.jvI) {
            csu();
        }
        if (this.iZR != null) {
            this.iZR.Al("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jtL.onPause();
        if (this.jvn != null) {
            if (this.jtD != null && this.jtD.getStatus() == 6) {
                this.jvn.stopRecord();
                ctN();
            }
            if (this.jtD != null && this.jtD.akv()) {
                this.jvn.stopRecord();
            }
        }
        if (this.jvL != null) {
            this.jvL.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jtD == null || this.jtD.getStatus() != 7) {
            if (this.jtD != null && this.jtD.getStatus() == 6) {
                if (this.jvn != null) {
                    this.jvn.stopRecord();
                }
                ctN();
            } else if (this.jtD.onBackPressed()) {
                finish();
            } else {
                if (this.jvs == null) {
                    this.jvs = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jvs.ho(R.string.video_quit_confirm);
                    this.jvs.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jvs.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jvs.dM(true);
                    this.jvs.b(getPageContext());
                }
                this.jvs.afG();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jvz.setVisibility(4);
        if (view == this.geN) {
            onBackPressed();
        } else if (view == this.jvp) {
            if (this.jtD.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jtL.ctj();
            ctE();
        } else if (view == this.jvq) {
            if (this.jtD.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jvq.setOnClickListener(null);
            this.jtL.ctl();
            if (this.jtL.ctm() && this.jtL.ctk()) {
                this.jtL.ctj();
            }
            ctE();
            this.jvq.setOnClickListener(this);
        } else if (view == this.jvr) {
            ctG();
        }
    }

    private void ctE() {
        if (this.jtL.ctm()) {
            this.jvp.setVisibility(8);
        } else {
            this.jvp.setVisibility(0);
        }
        if (this.jtL.ctk()) {
            this.jvp.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jvp.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout ctF() {
        return this.jvt;
    }

    public void ctG() {
        this.jvz.setVisibility(4);
        if (this.jtD.getStatus() != 6) {
            this.jtD.setStatus(6);
            ctL();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jvC == null) {
                this.jvC = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jvC.setDuration(500L);
                this.jvC.setRepeatCount(5);
                this.jvC.setRepeatMode(2);
                this.jvC.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jvC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jtD.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jvu.setVisibility(0);
                        RecordVideoActivity.this.jvu.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jvu.setVisibility(8);
                    if (RecordVideoActivity.this.jtD.getStatus() == 6) {
                        RecordVideoActivity.this.jvn.ctY();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jtD.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jvu.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jvu.setText("");
                        }
                    }
                }
            });
            this.jvu.setAnimation(this.jvC);
            this.jvC.startNow();
            this.jvn.ctG();
            if (this.jvL != null) {
                this.jvL.ctA();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctH() {
        if (this.jtD.getStatus() == 1) {
            this.jvz.setVisibility(4);
            if (this.jtD.getStatus() != 6) {
                this.jvn.ctH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctI() {
        this.jvz.setVisibility(4);
        if (this.jtD.getStatus() != 6) {
            this.jvn.ctI();
            if (this.jvn.cuc()) {
                ctC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        this.jvz.setVisibility(4);
        if (this.jtD.getStatus() != 6) {
            this.jvn.ctJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        this.jvz.setVisibility(4);
        if (this.jtD.getStatus() != 6) {
            this.jvn.ctK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctL() {
        this.jvH = true;
        if (this.jvB != null && this.jvB.isRunning()) {
            this.jvB.cancel();
        }
        if (this.jvA == null) {
            this.jvA = new AnimatorSet();
            this.jvA.playTogether(ObjectAnimator.ofFloat(this.jvo, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jvv, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jvM, "alpha", 1.0f, 0.0f));
            this.jvA.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxn) {
                        RecordVideoActivity.this.jvo.setVisibility(8);
                        RecordVideoActivity.this.jvv.setVisibility(8);
                        RecordVideoActivity.this.jvM.setVisibility(8);
                    }
                }
            });
            this.jvA.setDuration(300L);
        }
        this.jvA.start();
        this.jvv.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctA() {
        if (this.fFW == 2) {
            if (this.jvH) {
                this.jvH = false;
                if (this.jvL != null) {
                    this.jvL.ctA();
                }
            } else {
                return;
            }
        }
        if (this.jvA != null && this.jvA.isRunning()) {
            this.jvA.cancel();
        }
        if (this.jvB == null) {
            this.jvB = new AnimatorSet();
            this.jvB.playTogether(ObjectAnimator.ofFloat(this.jvo, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jvv, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jvM, "alpha", 0.0f, 1.0f));
            this.jvB.setDuration(300L);
        }
        this.jvo.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jvv.setVisibility(0);
        }
        if (this.jtD.getStatus() == 1) {
            this.jvM.setVisibility(0);
        }
        this.jvB.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctM() {
        if (this.jtL != null) {
            this.jtL.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void y(boolean z, String str) {
                    RecordVideoActivity.this.jtD.setStatus(1);
                    RecordVideoActivity.this.ctA();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jvN != null && !v.aa(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jvN)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jvN);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jvN = new ImageFileInfo();
                        RecordVideoActivity.this.jvN.setFilePath(str);
                        RecordVideoActivity.this.jvN.setTempFile(true);
                        RecordVideoActivity.this.jvN.setAlbumnId(null);
                        RecordVideoActivity.this.jvN.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jvN);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jvG, RecordVideoActivity.this.jvF)));
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
    public void ctN() {
        this.jvC.cancel();
        this.jvC.setAnimationListener(null);
        this.jvu.clearAnimation();
        this.jvu.setVisibility(8);
        if (this.jvL != null) {
            this.jvL.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctO() {
        ckV();
    }

    private void ckV() {
        if (this.jvD != null) {
            this.jvD.cancel();
        }
        if (this.jvE == null) {
            this.jvE = ObjectAnimator.ofFloat(this.jvM, "alpha", 1.0f, 0.0f);
            this.jvE.setDuration(500L);
            this.jvE.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxn) {
                        RecordVideoActivity.this.jvM.setVisibility(8);
                    }
                }
            });
        }
        this.jvE.start();
    }

    private void ckU() {
        if (this.jvE != null) {
            this.jvE.cancel();
        }
        if (this.jvD == null) {
            this.jvD = ObjectAnimator.ofFloat(this.jvM, "alpha", 0.0f, 1.0f);
            this.jvD.setDuration(500L);
        }
        this.jvM.setVisibility(0);
        this.jvD.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctP() {
        this.jvv.reset();
        if (this.jtD.getStatus() == 1) {
            ckU();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctQ() {
        if (this.jvx.getVisibility() != 0) {
            this.jvn.ctX();
            this.jtD.setStatus(8);
            ctA();
            if (this.jtL.jus != null && this.jtL.jus.size() > 0) {
                this.jvx.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jvR = 50;
        final int jvS = 1;
        Handler jvT = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jvy.aT(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.ctU();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void ctU() {
            this.jvT.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            ctU();
            boolean z = RecordVideoActivity.this.jvL == null || TextUtils.isEmpty(RecordVideoActivity.this.jvL.ctz()) || !new File(RecordVideoActivity.this.jvL.ctz()).exists();
            if (RecordVideoActivity.this.jtL.jus.size() > 1) {
                return com.baidu.tieba.video.meida.h.csM().a(RecordVideoActivity.this.jtL.jus, RecordVideoActivity.this.jtL.ctd(), z);
            }
            File file = new File(RecordVideoActivity.this.jtL.jus.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.c(file, new File(RecordVideoActivity.this.jtL.ctd()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.csM().a(RecordVideoActivity.this.jtL.jus, RecordVideoActivity.this.jtL.ctd(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jvn.cud();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.ctB();
                    RecordVideoActivity.this.BL(102);
                    RecordVideoActivity.this.jvx.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.ctB();
                RecordVideoActivity.this.BL(102);
                RecordVideoActivity.this.jvx.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.jvx.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jvy.aT(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jvn == null || v.aa(this.jvn.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jvn.getChoosedBeautyList()) {
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
        if (this.jvn == null || v.aa(this.jvn.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jvn.getChoosedFilterList()) {
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
        if (this.jvn == null || v.aa(this.jvn.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jvn.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctR() {
        this.jvz.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctS() {
        this.jvz.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctT() {
        if (this.jtD.getStatus() == 1) {
            this.jvM.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jtL != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jtL.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").P(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jvv.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jvv.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jtL.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.bT(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jtD.getStatus() == 1) {
                            amVar.P("obj_type", 1);
                        } else {
                            amVar.P("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jvv.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jvv.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jvL.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jvv.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jvv.setViewChoosed(0, true);
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
            this.jvK = stickerItem;
            this.jvJ.Fo(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jtL != null) {
                    this.jtL.setSticker(null);
                    this.jvP = false;
                }
                if (this.jvn != null) {
                    this.jvn.setDownLoadSticker(null);
                }
                this.jvw.setVisibility(8);
                this.jvv.setViewChoosed(1, false);
                return;
            }
            String Fl = this.jvJ.Fl(stickerItem.resource);
            if (!StringUtils.isNull(Fl)) {
                a(stickerItem, Fl);
                if (this.jvn != null) {
                    this.jvn.setDownLoadSticker(null);
                }
            } else {
                if (this.jvn != null) {
                    this.jvn.setDownLoadSticker(stickerItem);
                }
                this.jvJ.Fm(stickerItem.resource);
            }
            this.jvv.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jtL != null) {
                this.jtL.setSticker(stickerItem);
                this.jvP = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jvw.setText(stickerItem.desc);
                this.jvw.setVisibility(0);
                this.jvw.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jvw.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jvw.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cD(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jvn.getLayoutParams();
            layoutParams.height = i4;
            this.jvn.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EW = com.baidu.tieba.video.editvideo.model.a.crL().EW(stringExtra);
                if (this.jvL != null && !TextUtils.isEmpty(EW)) {
                    this.jvL.es(EW, stringExtra2);
                    this.jvn.csR();
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
        if (this.jtD.getStatus() == 8) {
            this.jvn.ctW();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void rx(boolean z) {
        if (this.jtD != null && (this.jtD.getStatus() == 1 || this.jtD.getStatus() == 3 || this.jtD.getStatus() == 4)) {
            if (!z && this.jvP) {
                this.jvt.aTa();
                return;
            } else {
                this.jvt.aTb();
                return;
            }
        }
        this.jvt.aTb();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void R(int i, boolean z) {
        int i2 = 1;
        if (this.fFW != i) {
            switch (i) {
                case 1:
                    if (this.jvL != null) {
                        this.jvL.aAi();
                    }
                    this.jtL.setFilter("origin");
                    this.jvv.setViewChoosed(0, false);
                    this.jvv.setViewChoosed(3, false);
                    this.jvn.BN(1);
                    this.jvv.setViewVisibility(0, 8);
                    this.jvv.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jvv.setViewVisibility(0, 0);
                    this.jvv.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fFW = i;
            this.jvn.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().P("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cty() {
        if (this.jtD.getStatus() == 1 && !this.jvn.cub()) {
            R(1, true);
            this.jvM.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void ctx() {
        if (this.jtD.getStatus() == 1 && !this.jvn.cub()) {
            R(2, true);
            this.jvM.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL(int i) {
        if (this.iZR != null) {
            this.iZR.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.iZR != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.iZR.av(i, str);
        }
    }
}
