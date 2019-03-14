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
/* loaded from: classes5.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private ImageView fNQ;
    private int fpO;
    private final CustomMessageListener frz;
    private com.baidu.tieba.j.h iHn;
    private String iWh;
    private SelectMusicModel iWl;
    private b.a iZz;
    private i jaT;
    private b jbL;
    protected h jbb;
    private RecordLayout jcD;
    private VideoControllerLayout jcE;
    private RelativeLayout jcF;
    private ImageView jcG;
    private ImageView jcH;
    private ImageView jcI;
    private com.baidu.tbadk.core.dialog.a jcJ;
    private PreviewViewContainer jcK;
    private TextView jcL;
    private VideoEffectButtonLayout jcM;
    private TextView jcN;
    private View jcO;
    private RoundProgressBar jcP;
    private TextView jcQ;
    private AnimatorSet jcR;
    private AnimatorSet jcS;
    private ScaleAnimation jcT;
    private ObjectAnimator jcU;
    private ObjectAnimator jcV;
    private int jcW;
    private ForumWriteData jcX;
    private boolean jcY;
    private boolean jcZ = true;
    private l jda;
    private StickerItem jdb;
    protected j jdc;
    private RecordTabLayout jdd;
    private ImageFileInfo jde;
    private HttpMessageListener jdf;
    private boolean jdg;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iHn = lVar.bEC();
        }
        if (this.iHn != null) {
            this.iHn.bEg();
        }
        this.iZz = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eh(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.T(list)) {
                    if (RecordVideoActivity.this.jcE != null) {
                        RecordVideoActivity.this.jcE.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jcE != null) {
                    RecordVideoActivity.this.jcE.setHasLocalVideo(true);
                    RecordVideoActivity.this.jcZ = false;
                }
            }
        };
        this.jdf = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jcE != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jcE.setStickerItems(list);
                    }
                }
            }
        };
        this.frz = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void clA() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jbb.iWn);
        videoInfo.setVideoDuration(this.jaT.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jbb.iWn).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jcX == null ? "" : this.jcX.forumName;
        String str2 = this.jcX == null ? "" : this.jcX.forumId;
        int i = this.jcX == null ? -1 : this.jcX.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jcX.writeCallFrom, str, str2, this.iWh, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jdc != null) {
            this.jdc.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.iHn != null) {
            this.iHn.bEj();
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
        if (this.jaT != null && this.jaT.afz()) {
            this.jaT.stopRecord();
        }
        if (this.iWl != null) {
            this.iWl.cancelLoadData();
        }
        if (this.iHn != null) {
            this.iHn.yX("record");
        }
        com.baidu.tbadk.core.util.m.G(new File(com.baidu.tieba.video.c.iUB));
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
        this.jcW = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jcX = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.iWh = getIntent().getStringExtra("video_title");
        initUI();
        this.iWl = new SelectMusicModel(getPageContext(), this.jcE);
        this.iWl.cjQ();
        this.jdc = new j(this);
        this.jdc.b(this.iWl);
        this.jaT.a(this.jdc);
        registerListener(this.jdf);
        registerListener(this.frz);
        clB();
    }

    private void clB() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void ckt() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.iZz);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jcD = (RecordLayout) findViewById(d.g.root_layout);
        this.jcD.setListener(this);
        this.jaT = new i(this);
        this.jcE = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.jcE.setRecordController(this.jaT);
        this.jcE.setRecordControlListener(this);
        this.jcE.setEffectChoosedListener(this);
        this.jcF = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.fNQ = (ImageView) findViewById(d.g.close_page);
        this.fNQ.setOnClickListener(this);
        this.jcG = (ImageView) findViewById(d.g.flash_switch);
        this.jcG.setOnClickListener(this);
        this.jcH = (ImageView) findViewById(d.g.camera_switch);
        this.jcH.setOnClickListener(this);
        this.jcI = (ImageView) findViewById(d.g.count_down);
        this.jcI.setOnClickListener(this);
        this.jcK = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.jbb = new h(this);
        this.jbb.a(this);
        this.jbb.setFaceIdentifyStateListener(this);
        this.jbb.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void clo() {
                if (RecordVideoActivity.this.jcE.cma()) {
                    RecordVideoActivity.this.jcE.a((m) null);
                }
            }
        });
        this.jcM = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.jcM.setListener(this);
        this.jaT.a(this.jcM);
        this.jcM.setViewChoosed(2, true);
        this.jcL = (TextView) findViewById(d.g.tv_count_down);
        this.jcN = (TextView) findViewById(d.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds150);
        if (this.jcL.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jcL.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jcM.setVisibility(8);
        }
        this.jcO = findViewById(d.g.progress_layout);
        this.jcP = (RoundProgressBar) this.jcO.findViewById(d.g.video_progress);
        this.jcQ = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcQ.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds38);
        this.jcQ.setLayoutParams(layoutParams);
        this.jdd = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.jdd.aH(1, getString(d.j.tab_photo));
        if (this.jcW != 2 && this.jcW != 3) {
            this.jdd.aH(2, getString(d.j.tab_record));
            this.jdd.setListener(this);
            this.jdd.setCurrentTab(2, false);
            M(2, false);
        } else {
            this.jdd.setShowIndicator(false);
            this.jdd.setCurrentTab(1, false);
            M(1, false);
        }
        clC();
    }

    private void clC() {
        if (com.baidu.tbadk.core.util.g.acb()) {
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
        this.jbb.onResume();
        this.jbL = this.jbb.clf();
        if (this.jbL != null) {
            this.jbL.setRecordController(this.jaT);
            this.jcK.setZoomHelper(this.jbL);
        }
        clD();
        if (this.jda == null) {
            this.jda = new l();
            this.jda.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ec(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jdb, str2);
                    if (RecordVideoActivity.this.jcE != null) {
                        RecordVideoActivity.this.jcE.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Dt(String str) {
                    if (RecordVideoActivity.this.jcE != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jcE.b(stickerItem);
                        if (RecordVideoActivity.this.jbb != null) {
                            RecordVideoActivity.this.jbb.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jcE != null) {
                        RecordVideoActivity.this.jcE.setDownLoadSticker(null);
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
                    recordVideoActivity.aq(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void ciY() {
                    if (RecordVideoActivity.this.jcE != null) {
                        RecordVideoActivity.this.jcE.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jda.clU();
        if (this.jcE != null && this.jcZ) {
            ckt();
        }
        if (this.iHn != null) {
            this.iHn.yW("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jbb.onPause();
        if (this.jcE != null) {
            if (this.jaT != null && this.jaT.getStatus() == 6) {
                this.jcE.stopRecord();
                clM();
            }
            if (this.jaT != null && this.jaT.afz()) {
                this.jcE.stopRecord();
            }
        }
        if (this.jdc != null) {
            this.jdc.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jaT == null || this.jaT.getStatus() != 7) {
            if (this.jaT != null && this.jaT.getStatus() == 6) {
                if (this.jcE != null) {
                    this.jcE.stopRecord();
                }
                clM();
            } else if (this.jaT.onBackPressed()) {
                finish();
            } else {
                if (this.jcJ == null) {
                    this.jcJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jcJ.gD(d.j.video_quit_confirm);
                    this.jcJ.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jcJ.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jcJ.dq(true);
                    this.jcJ.b(getPageContext());
                }
                this.jcJ.aaZ();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jcQ.setVisibility(4);
        if (view == this.fNQ) {
            onBackPressed();
        } else if (view == this.jcG) {
            if (this.jaT.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jbb.cli();
            clD();
        } else if (view == this.jcH) {
            if (this.jaT.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jcH.setOnClickListener(null);
            this.jbb.clk();
            if (this.jbb.cll() && this.jbb.clj()) {
                this.jbb.cli();
            }
            clD();
            this.jcH.setOnClickListener(this);
        } else if (view == this.jcI) {
            clF();
        }
    }

    private void clD() {
        if (this.jbb.cll()) {
            this.jcG.setVisibility(8);
        } else {
            this.jcG.setVisibility(0);
        }
        if (this.jbb.clj()) {
            this.jcG.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.jcG.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout clE() {
        return this.jcK;
    }

    public void clF() {
        this.jcQ.setVisibility(4);
        if (this.jaT.getStatus() != 6) {
            this.jaT.setStatus(6);
            clK();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jcT == null) {
                this.jcT = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jcT.setDuration(500L);
                this.jcT.setRepeatCount(5);
                this.jcT.setRepeatMode(2);
                this.jcT.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jcT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jaT.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jcL.setVisibility(0);
                        RecordVideoActivity.this.jcL.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jcL.setVisibility(8);
                    if (RecordVideoActivity.this.jaT.getStatus() == 6) {
                        RecordVideoActivity.this.jcE.clX();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jaT.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jcL.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jcL.setText("");
                        }
                    }
                }
            });
            this.jcL.setAnimation(this.jcT);
            this.jcT.startNow();
            this.jcE.clF();
            if (this.jdc != null) {
                this.jdc.clz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        if (this.jaT.getStatus() == 1) {
            this.jcQ.setVisibility(4);
            if (this.jaT.getStatus() != 6) {
                this.jcE.clG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        this.jcQ.setVisibility(4);
        if (this.jaT.getStatus() != 6) {
            this.jcE.clH();
            if (this.jcE.cmb()) {
                clB();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clI() {
        this.jcQ.setVisibility(4);
        if (this.jaT.getStatus() != 6) {
            this.jcE.clI();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clJ() {
        this.jcQ.setVisibility(4);
        if (this.jaT.getStatus() != 6) {
            this.jcE.clJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clK() {
        this.jcY = true;
        if (this.jcS != null && this.jcS.isRunning()) {
            this.jcS.cancel();
        }
        if (this.jcR == null) {
            this.jcR = new AnimatorSet();
            this.jcR.playTogether(ObjectAnimator.ofFloat(this.jcF, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jcM, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jdd, "alpha", 1.0f, 0.0f));
            this.jcR.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jeE) {
                        RecordVideoActivity.this.jcF.setVisibility(8);
                        RecordVideoActivity.this.jcM.setVisibility(8);
                        RecordVideoActivity.this.jdd.setVisibility(8);
                    }
                }
            });
            this.jcR.setDuration(300L);
        }
        this.jcR.start();
        this.jcM.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clz() {
        if (this.fpO == 2) {
            if (this.jcY) {
                this.jcY = false;
                if (this.jdc != null) {
                    this.jdc.clz();
                }
            } else {
                return;
            }
        }
        if (this.jcR != null && this.jcR.isRunning()) {
            this.jcR.cancel();
        }
        if (this.jcS == null) {
            this.jcS = new AnimatorSet();
            this.jcS.playTogether(ObjectAnimator.ofFloat(this.jcF, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jcM, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jdd, "alpha", 0.0f, 1.0f));
            this.jcS.setDuration(300L);
        }
        this.jcF.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jcM.setVisibility(0);
        }
        if (this.jaT.getStatus() == 1) {
            this.jdd.setVisibility(0);
        }
        this.jcS.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clL() {
        if (this.jbb != null) {
            this.jbb.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jaT.setStatus(1);
                    RecordVideoActivity.this.clz();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jde != null && !v.T(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jde)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jde);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jde = new ImageFileInfo();
                        RecordVideoActivity.this.jde.setFilePath(str);
                        RecordVideoActivity.this.jde.setTempFile(true);
                        RecordVideoActivity.this.jde.setAlbumnId(null);
                        RecordVideoActivity.this.jde.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jde);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jcX, RecordVideoActivity.this.jcW)));
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
    public void clM() {
        this.jcT.cancel();
        this.jcT.setAnimationListener(null);
        this.jcL.clearAnimation();
        this.jcL.setVisibility(8);
        if (this.jdc != null) {
            this.jdc.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clN() {
        ccV();
    }

    private void ccV() {
        if (this.jcU != null) {
            this.jcU.cancel();
        }
        if (this.jcV == null) {
            this.jcV = ObjectAnimator.ofFloat(this.jdd, "alpha", 1.0f, 0.0f);
            this.jcV.setDuration(500L);
            this.jcV.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jeE) {
                        RecordVideoActivity.this.jdd.setVisibility(8);
                    }
                }
            });
        }
        this.jcV.start();
    }

    private void ccU() {
        if (this.jcV != null) {
            this.jcV.cancel();
        }
        if (this.jcU == null) {
            this.jcU = ObjectAnimator.ofFloat(this.jdd, "alpha", 0.0f, 1.0f);
            this.jcU.setDuration(500L);
        }
        this.jdd.setVisibility(0);
        this.jcU.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clO() {
        this.jcM.reset();
        if (this.jaT.getStatus() == 1) {
            ccU();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clP() {
        if (this.jcO.getVisibility() != 0) {
            this.jcE.clW();
            this.jaT.setStatus(8);
            clz();
            if (this.jbb.jbJ != null && this.jbb.jbJ.size() > 0) {
                this.jcO.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jdi = 50;
        final int jdj = 1;
        Handler jdk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jcP.aP(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.clT();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void clT() {
            this.jdk.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            clT();
            boolean z = RecordVideoActivity.this.jdc == null || TextUtils.isEmpty(RecordVideoActivity.this.jdc.cly()) || !new File(RecordVideoActivity.this.jdc.cly()).exists();
            if (RecordVideoActivity.this.jbb.jbJ.size() > 1) {
                return com.baidu.tieba.video.meida.h.ckL().a(RecordVideoActivity.this.jbb.jbJ, RecordVideoActivity.this.jbb.clc(), z);
            }
            File file = new File(RecordVideoActivity.this.jbb.jbJ.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.jbb.clc()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.ckL().a(RecordVideoActivity.this.jbb.jbJ, RecordVideoActivity.this.jbb.clc(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jcE.cmc();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.clA();
                    RecordVideoActivity.this.AH(102);
                    RecordVideoActivity.this.jcO.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.clA();
                RecordVideoActivity.this.AH(102);
                RecordVideoActivity.this.jcO.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.jcO.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aq(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jcP.aP(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jcE == null || v.T(this.jcE.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jcE.getChoosedBeautyList()) {
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
        if (this.jcE == null || v.T(this.jcE.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jcE.getChoosedFilterList()) {
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
        if (this.jcE == null || v.T(this.jcE.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jcE.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clQ() {
        this.jcQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clR() {
        this.jcQ.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clS() {
        if (this.jaT.getStatus() == 1) {
            this.jdd.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jbb != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jbb.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").T(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jcM.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jcM.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jbb.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jaT.getStatus() == 1) {
                            amVar.T("obj_type", 1);
                        } else {
                            amVar.T("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jcM.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jcM.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jdc.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jcM.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jcM.setViewChoosed(0, true);
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
            this.jdb = stickerItem;
            this.jda.DT(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jbb != null) {
                    this.jbb.setSticker(null);
                    this.jdg = false;
                }
                if (this.jcE != null) {
                    this.jcE.setDownLoadSticker(null);
                }
                this.jcN.setVisibility(8);
                this.jcM.setViewChoosed(1, false);
                return;
            }
            String DQ = this.jda.DQ(stickerItem.resource);
            if (!StringUtils.isNull(DQ)) {
                a(stickerItem, DQ);
                if (this.jcE != null) {
                    this.jcE.setDownLoadSticker(null);
                }
            } else {
                if (this.jcE != null) {
                    this.jcE.setDownLoadSticker(stickerItem);
                }
                this.jda.DR(stickerItem.resource);
            }
            this.jcM.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jbb != null) {
                this.jbb.setSticker(stickerItem);
                this.jdg = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jcN.setText(stickerItem.desc);
                this.jcN.setVisibility(0);
                this.jcN.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jcN.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jcN.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cw(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jcE.getLayoutParams();
            layoutParams.height = i4;
            this.jcE.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String DB = com.baidu.tieba.video.editvideo.model.a.cjK().DB(stringExtra);
                if (this.jdc != null && !TextUtils.isEmpty(DB)) {
                    this.jdc.ed(DB, stringExtra2);
                    this.jcE.ckQ();
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
        if (this.jaT.getStatus() == 8) {
            this.jcE.clV();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void qI(boolean z) {
        if (this.jaT != null && (this.jaT.getStatus() == 1 || this.jaT.getStatus() == 3 || this.jaT.getStatus() == 4)) {
            if (!z && this.jdg) {
                this.jcK.aNb();
                return;
            } else {
                this.jcK.aNc();
                return;
            }
        }
        this.jcK.aNc();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void M(int i, boolean z) {
        int i2 = 1;
        if (this.fpO != i) {
            switch (i) {
                case 1:
                    if (this.jdc != null) {
                        this.jdc.avg();
                    }
                    this.jbb.setFilter("origin");
                    this.jcM.setViewChoosed(0, false);
                    this.jcM.setViewChoosed(3, false);
                    this.jcE.AJ(1);
                    this.jcM.setViewVisibility(0, 8);
                    this.jcM.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jcM.setViewVisibility(0, 0);
                    this.jcM.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fpO = i;
            this.jcE.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().T("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void clx() {
        if (this.jaT.getStatus() == 1 && !this.jcE.cma()) {
            M(1, true);
            this.jdd.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void clw() {
        if (this.jaT.getStatus() == 1 && !this.jcE.cma()) {
            M(2, true);
            this.jdd.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(int i) {
        if (this.iHn != null) {
            this.iHn.ar(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(int i, String str) {
        if (this.iHn != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.iHn.aq(i, str);
        }
    }
}
