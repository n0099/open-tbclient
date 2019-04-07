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
    private ImageView fNE;
    private int fpA;
    private final CustomMessageListener frk;
    private com.baidu.tieba.j.h iGX;
    private String iVV;
    private SelectMusicModel iVZ;
    private b.a iZn;
    private i jaH;
    protected h jaP;
    private b jbz;
    private VideoEffectButtonLayout jcA;
    private TextView jcB;
    private View jcC;
    private RoundProgressBar jcD;
    private TextView jcE;
    private AnimatorSet jcF;
    private AnimatorSet jcG;
    private ScaleAnimation jcH;
    private ObjectAnimator jcI;
    private ObjectAnimator jcJ;
    private int jcK;
    private ForumWriteData jcL;
    private boolean jcM;
    private boolean jcN = true;
    private l jcO;
    private StickerItem jcP;
    protected j jcQ;
    private RecordTabLayout jcR;
    private ImageFileInfo jcS;
    private HttpMessageListener jcT;
    private boolean jcU;
    private RecordLayout jcr;
    private VideoControllerLayout jcs;
    private RelativeLayout jct;
    private ImageView jcu;
    private ImageView jcv;
    private ImageView jcw;
    private com.baidu.tbadk.core.dialog.a jcx;
    private PreviewViewContainer jcy;
    private TextView jcz;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iGX = lVar.bEz();
        }
        if (this.iGX != null) {
            this.iGX.bEd();
        }
        this.iZn = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void ee(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.T(list)) {
                    if (RecordVideoActivity.this.jcs != null) {
                        RecordVideoActivity.this.jcs.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jcs != null) {
                    RecordVideoActivity.this.jcs.setHasLocalVideo(true);
                    RecordVideoActivity.this.jcN = false;
                }
            }
        };
        this.jcT = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jcs != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jcs.setStickerItems(list);
                    }
                }
            }
        };
        this.frk = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cly() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jaP.iWb);
        videoInfo.setVideoDuration(this.jaH.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jaP.iWb).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jcL == null ? "" : this.jcL.forumName;
        String str2 = this.jcL == null ? "" : this.jcL.forumId;
        int i = this.jcL == null ? -1 : this.jcL.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jcL.writeCallFrom, str, str2, this.iVV, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jcQ != null) {
            this.jcQ.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.iGX != null) {
            this.iGX.bEg();
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
        if (this.jaH != null && this.jaH.afw()) {
            this.jaH.stopRecord();
        }
        if (this.iVZ != null) {
            this.iVZ.cancelLoadData();
        }
        if (this.iGX != null) {
            this.iGX.yW("record");
        }
        com.baidu.tbadk.core.util.m.G(new File(com.baidu.tieba.video.c.iUp));
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
        this.jcK = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jcL = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.iVV = getIntent().getStringExtra("video_title");
        initUI();
        this.iVZ = new SelectMusicModel(getPageContext(), this.jcs);
        this.iVZ.cjO();
        this.jcQ = new j(this);
        this.jcQ.b(this.iVZ);
        this.jaH.a(this.jcQ);
        registerListener(this.jcT);
        registerListener(this.frk);
        clz();
    }

    private void clz() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void ckr() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.iZn);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jcr = (RecordLayout) findViewById(d.g.root_layout);
        this.jcr.setListener(this);
        this.jaH = new i(this);
        this.jcs = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.jcs.setRecordController(this.jaH);
        this.jcs.setRecordControlListener(this);
        this.jcs.setEffectChoosedListener(this);
        this.jct = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.fNE = (ImageView) findViewById(d.g.close_page);
        this.fNE.setOnClickListener(this);
        this.jcu = (ImageView) findViewById(d.g.flash_switch);
        this.jcu.setOnClickListener(this);
        this.jcv = (ImageView) findViewById(d.g.camera_switch);
        this.jcv.setOnClickListener(this);
        this.jcw = (ImageView) findViewById(d.g.count_down);
        this.jcw.setOnClickListener(this);
        this.jcy = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.jaP = new h(this);
        this.jaP.a(this);
        this.jaP.setFaceIdentifyStateListener(this);
        this.jaP.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void clm() {
                if (RecordVideoActivity.this.jcs.clY()) {
                    RecordVideoActivity.this.jcs.a((m) null);
                }
            }
        });
        this.jcA = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.jcA.setListener(this);
        this.jaH.a(this.jcA);
        this.jcA.setViewChoosed(2, true);
        this.jcz = (TextView) findViewById(d.g.tv_count_down);
        this.jcB = (TextView) findViewById(d.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds150);
        if (this.jcz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jcz.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jcA.setVisibility(8);
        }
        this.jcC = findViewById(d.g.progress_layout);
        this.jcD = (RoundProgressBar) this.jcC.findViewById(d.g.video_progress);
        this.jcE = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcE.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds38);
        this.jcE.setLayoutParams(layoutParams);
        this.jcR = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.jcR.aJ(1, getString(d.j.tab_photo));
        if (this.jcK != 2 && this.jcK != 3) {
            this.jcR.aJ(2, getString(d.j.tab_record));
            this.jcR.setListener(this);
            this.jcR.setCurrentTab(2, false);
            M(2, false);
        } else {
            this.jcR.setShowIndicator(false);
            this.jcR.setCurrentTab(1, false);
            M(1, false);
        }
        clA();
    }

    private void clA() {
        if (com.baidu.tbadk.core.util.g.abY()) {
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
        this.jaP.onResume();
        this.jbz = this.jaP.cld();
        if (this.jbz != null) {
            this.jbz.setRecordController(this.jaH);
            this.jcy.setZoomHelper(this.jbz);
        }
        clB();
        if (this.jcO == null) {
            this.jcO = new l();
            this.jcO.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ed(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jcP, str2);
                    if (RecordVideoActivity.this.jcs != null) {
                        RecordVideoActivity.this.jcs.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Ds(String str) {
                    if (RecordVideoActivity.this.jcs != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jcs.b(stickerItem);
                        if (RecordVideoActivity.this.jaP != null) {
                            RecordVideoActivity.this.jaP.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jcs != null) {
                        RecordVideoActivity.this.jcs.setDownLoadSticker(null);
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
                    recordVideoActivity.as(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void ciW() {
                    if (RecordVideoActivity.this.jcs != null) {
                        RecordVideoActivity.this.jcs.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jcO.clS();
        if (this.jcs != null && this.jcN) {
            ckr();
        }
        if (this.iGX != null) {
            this.iGX.yV("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jaP.onPause();
        if (this.jcs != null) {
            if (this.jaH != null && this.jaH.getStatus() == 6) {
                this.jcs.stopRecord();
                clK();
            }
            if (this.jaH != null && this.jaH.afw()) {
                this.jcs.stopRecord();
            }
        }
        if (this.jcQ != null) {
            this.jcQ.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jaH == null || this.jaH.getStatus() != 7) {
            if (this.jaH != null && this.jaH.getStatus() == 6) {
                if (this.jcs != null) {
                    this.jcs.stopRecord();
                }
                clK();
            } else if (this.jaH.onBackPressed()) {
                finish();
            } else {
                if (this.jcx == null) {
                    this.jcx = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jcx.gC(d.j.video_quit_confirm);
                    this.jcx.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jcx.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jcx.dq(true);
                    this.jcx.b(getPageContext());
                }
                this.jcx.aaW();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jcE.setVisibility(4);
        if (view == this.fNE) {
            onBackPressed();
        } else if (view == this.jcu) {
            if (this.jaH.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jaP.clg();
            clB();
        } else if (view == this.jcv) {
            if (this.jaH.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jcv.setOnClickListener(null);
            this.jaP.cli();
            if (this.jaP.clj() && this.jaP.clh()) {
                this.jaP.clg();
            }
            clB();
            this.jcv.setOnClickListener(this);
        } else if (view == this.jcw) {
            clD();
        }
    }

    private void clB() {
        if (this.jaP.clj()) {
            this.jcu.setVisibility(8);
        } else {
            this.jcu.setVisibility(0);
        }
        if (this.jaP.clh()) {
            this.jcu.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.jcu.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout clC() {
        return this.jcy;
    }

    public void clD() {
        this.jcE.setVisibility(4);
        if (this.jaH.getStatus() != 6) {
            this.jaH.setStatus(6);
            clI();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jcH == null) {
                this.jcH = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jcH.setDuration(500L);
                this.jcH.setRepeatCount(5);
                this.jcH.setRepeatMode(2);
                this.jcH.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jcH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jaH.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jcz.setVisibility(0);
                        RecordVideoActivity.this.jcz.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jcz.setVisibility(8);
                    if (RecordVideoActivity.this.jaH.getStatus() == 6) {
                        RecordVideoActivity.this.jcs.clV();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jaH.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jcz.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jcz.setText("");
                        }
                    }
                }
            });
            this.jcz.setAnimation(this.jcH);
            this.jcH.startNow();
            this.jcs.clD();
            if (this.jcQ != null) {
                this.jcQ.clx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clE() {
        if (this.jaH.getStatus() == 1) {
            this.jcE.setVisibility(4);
            if (this.jaH.getStatus() != 6) {
                this.jcs.clE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clF() {
        this.jcE.setVisibility(4);
        if (this.jaH.getStatus() != 6) {
            this.jcs.clF();
            if (this.jcs.clZ()) {
                clz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        this.jcE.setVisibility(4);
        if (this.jaH.getStatus() != 6) {
            this.jcs.clG();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        this.jcE.setVisibility(4);
        if (this.jaH.getStatus() != 6) {
            this.jcs.clH();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clI() {
        this.jcM = true;
        if (this.jcG != null && this.jcG.isRunning()) {
            this.jcG.cancel();
        }
        if (this.jcF == null) {
            this.jcF = new AnimatorSet();
            this.jcF.playTogether(ObjectAnimator.ofFloat(this.jct, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jcA, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jcR, "alpha", 1.0f, 0.0f));
            this.jcF.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jes) {
                        RecordVideoActivity.this.jct.setVisibility(8);
                        RecordVideoActivity.this.jcA.setVisibility(8);
                        RecordVideoActivity.this.jcR.setVisibility(8);
                    }
                }
            });
            this.jcF.setDuration(300L);
        }
        this.jcF.start();
        this.jcA.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clx() {
        if (this.fpA == 2) {
            if (this.jcM) {
                this.jcM = false;
                if (this.jcQ != null) {
                    this.jcQ.clx();
                }
            } else {
                return;
            }
        }
        if (this.jcF != null && this.jcF.isRunning()) {
            this.jcF.cancel();
        }
        if (this.jcG == null) {
            this.jcG = new AnimatorSet();
            this.jcG.playTogether(ObjectAnimator.ofFloat(this.jct, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jcA, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jcR, "alpha", 0.0f, 1.0f));
            this.jcG.setDuration(300L);
        }
        this.jct.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jcA.setVisibility(0);
        }
        if (this.jaH.getStatus() == 1) {
            this.jcR.setVisibility(0);
        }
        this.jcG.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clJ() {
        if (this.jaP != null) {
            this.jaP.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jaH.setStatus(1);
                    RecordVideoActivity.this.clx();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jcS != null && !v.T(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jcS)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jcS);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jcS = new ImageFileInfo();
                        RecordVideoActivity.this.jcS.setFilePath(str);
                        RecordVideoActivity.this.jcS.setTempFile(true);
                        RecordVideoActivity.this.jcS.setAlbumnId(null);
                        RecordVideoActivity.this.jcS.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jcS);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jcL, RecordVideoActivity.this.jcK)));
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
    public void clK() {
        this.jcH.cancel();
        this.jcH.setAnimationListener(null);
        this.jcz.clearAnimation();
        this.jcz.setVisibility(8);
        if (this.jcQ != null) {
            this.jcQ.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clL() {
        ccR();
    }

    private void ccR() {
        if (this.jcI != null) {
            this.jcI.cancel();
        }
        if (this.jcJ == null) {
            this.jcJ = ObjectAnimator.ofFloat(this.jcR, "alpha", 1.0f, 0.0f);
            this.jcJ.setDuration(500L);
            this.jcJ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jes) {
                        RecordVideoActivity.this.jcR.setVisibility(8);
                    }
                }
            });
        }
        this.jcJ.start();
    }

    private void ccQ() {
        if (this.jcJ != null) {
            this.jcJ.cancel();
        }
        if (this.jcI == null) {
            this.jcI = ObjectAnimator.ofFloat(this.jcR, "alpha", 0.0f, 1.0f);
            this.jcI.setDuration(500L);
        }
        this.jcR.setVisibility(0);
        this.jcI.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clM() {
        this.jcA.reset();
        if (this.jaH.getStatus() == 1) {
            ccQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clN() {
        if (this.jcC.getVisibility() != 0) {
            this.jcs.clU();
            this.jaH.setStatus(8);
            clx();
            if (this.jaP.jbx != null && this.jaP.jbx.size() > 0) {
                this.jcC.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jcW = 50;
        final int jcX = 1;
        Handler jcY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jcD.aP(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.clR();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void clR() {
            this.jcY.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            clR();
            boolean z = RecordVideoActivity.this.jcQ == null || TextUtils.isEmpty(RecordVideoActivity.this.jcQ.clw()) || !new File(RecordVideoActivity.this.jcQ.clw()).exists();
            if (RecordVideoActivity.this.jaP.jbx.size() > 1) {
                return com.baidu.tieba.video.meida.h.ckJ().a(RecordVideoActivity.this.jaP.jbx, RecordVideoActivity.this.jaP.cla(), z);
            }
            File file = new File(RecordVideoActivity.this.jaP.jbx.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.jaP.cla()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.ckJ().a(RecordVideoActivity.this.jaP.jbx, RecordVideoActivity.this.jaP.cla(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jcs.cma();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cly();
                    RecordVideoActivity.this.AD(102);
                    RecordVideoActivity.this.jcC.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cly();
                RecordVideoActivity.this.AD(102);
                RecordVideoActivity.this.jcC.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.jcC.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.as(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jcD.aP(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jcs == null || v.T(this.jcs.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jcs.getChoosedBeautyList()) {
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
        if (this.jcs == null || v.T(this.jcs.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jcs.getChoosedFilterList()) {
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
        if (this.jcs == null || v.T(this.jcs.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jcs.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clO() {
        this.jcE.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clP() {
        this.jcE.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clQ() {
        if (this.jaH.getStatus() == 1) {
            this.jcR.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jaP != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jaP.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").T(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jcA.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jcA.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jaP.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jaH.getStatus() == 1) {
                            amVar.T("obj_type", 1);
                        } else {
                            amVar.T("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jcA.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jcA.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jcQ.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jcA.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jcA.setViewChoosed(0, true);
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
            this.jcP = stickerItem;
            this.jcO.DS(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jaP != null) {
                    this.jaP.setSticker(null);
                    this.jcU = false;
                }
                if (this.jcs != null) {
                    this.jcs.setDownLoadSticker(null);
                }
                this.jcB.setVisibility(8);
                this.jcA.setViewChoosed(1, false);
                return;
            }
            String DP = this.jcO.DP(stickerItem.resource);
            if (!StringUtils.isNull(DP)) {
                a(stickerItem, DP);
                if (this.jcs != null) {
                    this.jcs.setDownLoadSticker(null);
                }
            } else {
                if (this.jcs != null) {
                    this.jcs.setDownLoadSticker(stickerItem);
                }
                this.jcO.DQ(stickerItem.resource);
            }
            this.jcA.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jaP != null) {
                this.jaP.setSticker(stickerItem);
                this.jcU = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jcB.setText(stickerItem.desc);
                this.jcB.setVisibility(0);
                this.jcB.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jcB.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jcB.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cw(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jcs.getLayoutParams();
            layoutParams.height = i4;
            this.jcs.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String DA = com.baidu.tieba.video.editvideo.model.a.cjI().DA(stringExtra);
                if (this.jcQ != null && !TextUtils.isEmpty(DA)) {
                    this.jcQ.ef(DA, stringExtra2);
                    this.jcs.ckO();
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
        if (this.jaH.getStatus() == 8) {
            this.jcs.clT();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void qI(boolean z) {
        if (this.jaH != null && (this.jaH.getStatus() == 1 || this.jaH.getStatus() == 3 || this.jaH.getStatus() == 4)) {
            if (!z && this.jcU) {
                this.jcy.aMQ();
                return;
            } else {
                this.jcy.aMR();
                return;
            }
        }
        this.jcy.aMR();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void M(int i, boolean z) {
        int i2 = 1;
        if (this.fpA != i) {
            switch (i) {
                case 1:
                    if (this.jcQ != null) {
                        this.jcQ.avd();
                    }
                    this.jaP.setFilter("origin");
                    this.jcA.setViewChoosed(0, false);
                    this.jcA.setViewChoosed(3, false);
                    this.jcs.AF(1);
                    this.jcA.setViewVisibility(0, 8);
                    this.jcA.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jcA.setViewVisibility(0, 0);
                    this.jcA.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fpA = i;
            this.jcs.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().T("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void clv() {
        if (this.jaH.getStatus() == 1 && !this.jcs.clY()) {
            M(1, true);
            this.jcR.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void clu() {
        if (this.jaH.getStatus() == 1 && !this.jcs.clY()) {
            M(2, true);
            this.jcR.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD(int i) {
        if (this.iGX != null) {
            this.iGX.at(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, String str) {
        if (this.iGX != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.iGX.as(i, str);
        }
    }
}
