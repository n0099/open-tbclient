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
    private com.baidu.tieba.j.h iGY;
    private String iVW;
    private SelectMusicModel iWa;
    private b.a iZo;
    private i jaI;
    protected h jaQ;
    private b jbA;
    private TextView jcA;
    private VideoEffectButtonLayout jcB;
    private TextView jcC;
    private View jcD;
    private RoundProgressBar jcE;
    private TextView jcF;
    private AnimatorSet jcG;
    private AnimatorSet jcH;
    private ScaleAnimation jcI;
    private ObjectAnimator jcJ;
    private ObjectAnimator jcK;
    private int jcL;
    private ForumWriteData jcM;
    private boolean jcN;
    private boolean jcO = true;
    private l jcP;
    private StickerItem jcQ;
    protected j jcR;
    private RecordTabLayout jcS;
    private ImageFileInfo jcT;
    private HttpMessageListener jcU;
    private boolean jcV;
    private RecordLayout jcs;
    private VideoControllerLayout jct;
    private RelativeLayout jcu;
    private ImageView jcv;
    private ImageView jcw;
    private ImageView jcx;
    private com.baidu.tbadk.core.dialog.a jcy;
    private PreviewViewContainer jcz;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iGY = lVar.bEz();
        }
        if (this.iGY != null) {
            this.iGY.bEd();
        }
        this.iZo = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void ee(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.T(list)) {
                    if (RecordVideoActivity.this.jct != null) {
                        RecordVideoActivity.this.jct.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jct != null) {
                    RecordVideoActivity.this.jct.setHasLocalVideo(true);
                    RecordVideoActivity.this.jcO = false;
                }
            }
        };
        this.jcU = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jct != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jct.setStickerItems(list);
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
        videoInfo.setVideoPath(this.jaQ.iWc);
        videoInfo.setVideoDuration(this.jaI.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jaQ.iWc).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jcM == null ? "" : this.jcM.forumName;
        String str2 = this.jcM == null ? "" : this.jcM.forumId;
        int i = this.jcM == null ? -1 : this.jcM.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jcM.writeCallFrom, str, str2, this.iVW, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jcR != null) {
            this.jcR.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.iGY != null) {
            this.iGY.bEg();
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
        if (this.jaI != null && this.jaI.afw()) {
            this.jaI.stopRecord();
        }
        if (this.iWa != null) {
            this.iWa.cancelLoadData();
        }
        if (this.iGY != null) {
            this.iGY.yW("record");
        }
        com.baidu.tbadk.core.util.m.G(new File(com.baidu.tieba.video.c.iUq));
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
        this.jcL = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jcM = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.iVW = getIntent().getStringExtra("video_title");
        initUI();
        this.iWa = new SelectMusicModel(getPageContext(), this.jct);
        this.iWa.cjO();
        this.jcR = new j(this);
        this.jcR.b(this.iWa);
        this.jaI.a(this.jcR);
        registerListener(this.jcU);
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
        bVar.b(this.iZo);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jcs = (RecordLayout) findViewById(d.g.root_layout);
        this.jcs.setListener(this);
        this.jaI = new i(this);
        this.jct = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.jct.setRecordController(this.jaI);
        this.jct.setRecordControlListener(this);
        this.jct.setEffectChoosedListener(this);
        this.jcu = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.fNE = (ImageView) findViewById(d.g.close_page);
        this.fNE.setOnClickListener(this);
        this.jcv = (ImageView) findViewById(d.g.flash_switch);
        this.jcv.setOnClickListener(this);
        this.jcw = (ImageView) findViewById(d.g.camera_switch);
        this.jcw.setOnClickListener(this);
        this.jcx = (ImageView) findViewById(d.g.count_down);
        this.jcx.setOnClickListener(this);
        this.jcz = (PreviewViewContainer) findViewById(d.g.video_surface_container);
        this.jaQ = new h(this);
        this.jaQ.a(this);
        this.jaQ.setFaceIdentifyStateListener(this);
        this.jaQ.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void clm() {
                if (RecordVideoActivity.this.jct.clY()) {
                    RecordVideoActivity.this.jct.a((m) null);
                }
            }
        });
        this.jcB = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.jcB.setListener(this);
        this.jaI.a(this.jcB);
        this.jcB.setViewChoosed(2, true);
        this.jcA = (TextView) findViewById(d.g.tv_count_down);
        this.jcC = (TextView) findViewById(d.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds150);
        if (this.jcA.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jcA.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jcB.setVisibility(8);
        }
        this.jcD = findViewById(d.g.progress_layout);
        this.jcE = (RoundProgressBar) this.jcD.findViewById(d.g.video_progress);
        this.jcF = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcF.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds38);
        this.jcF.setLayoutParams(layoutParams);
        this.jcS = (RecordTabLayout) findViewById(d.g.tab_layout);
        this.jcS.aJ(1, getString(d.j.tab_photo));
        if (this.jcL != 2 && this.jcL != 3) {
            this.jcS.aJ(2, getString(d.j.tab_record));
            this.jcS.setListener(this);
            this.jcS.setCurrentTab(2, false);
            M(2, false);
        } else {
            this.jcS.setShowIndicator(false);
            this.jcS.setCurrentTab(1, false);
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
        this.jaQ.onResume();
        this.jbA = this.jaQ.cld();
        if (this.jbA != null) {
            this.jbA.setRecordController(this.jaI);
            this.jcz.setZoomHelper(this.jbA);
        }
        clB();
        if (this.jcP == null) {
            this.jcP = new l();
            this.jcP.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ed(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jcQ, str2);
                    if (RecordVideoActivity.this.jct != null) {
                        RecordVideoActivity.this.jct.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Ds(String str) {
                    if (RecordVideoActivity.this.jct != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jct.b(stickerItem);
                        if (RecordVideoActivity.this.jaQ != null) {
                            RecordVideoActivity.this.jaQ.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jct != null) {
                        RecordVideoActivity.this.jct.setDownLoadSticker(null);
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
                    if (RecordVideoActivity.this.jct != null) {
                        RecordVideoActivity.this.jct.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jcP.clS();
        if (this.jct != null && this.jcO) {
            ckr();
        }
        if (this.iGY != null) {
            this.iGY.yV("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jaQ.onPause();
        if (this.jct != null) {
            if (this.jaI != null && this.jaI.getStatus() == 6) {
                this.jct.stopRecord();
                clK();
            }
            if (this.jaI != null && this.jaI.afw()) {
                this.jct.stopRecord();
            }
        }
        if (this.jcR != null) {
            this.jcR.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jaI == null || this.jaI.getStatus() != 7) {
            if (this.jaI != null && this.jaI.getStatus() == 6) {
                if (this.jct != null) {
                    this.jct.stopRecord();
                }
                clK();
            } else if (this.jaI.onBackPressed()) {
                finish();
            } else {
                if (this.jcy == null) {
                    this.jcy = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jcy.gC(d.j.video_quit_confirm);
                    this.jcy.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jcy.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jcy.dq(true);
                    this.jcy.b(getPageContext());
                }
                this.jcy.aaW();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jcF.setVisibility(4);
        if (view == this.fNE) {
            onBackPressed();
        } else if (view == this.jcv) {
            if (this.jaI.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jaQ.clg();
            clB();
        } else if (view == this.jcw) {
            if (this.jaI.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jcw.setOnClickListener(null);
            this.jaQ.cli();
            if (this.jaQ.clj() && this.jaQ.clh()) {
                this.jaQ.clg();
            }
            clB();
            this.jcw.setOnClickListener(this);
        } else if (view == this.jcx) {
            clD();
        }
    }

    private void clB() {
        if (this.jaQ.clj()) {
            this.jcv.setVisibility(8);
        } else {
            this.jcv.setVisibility(0);
        }
        if (this.jaQ.clh()) {
            this.jcv.setImageResource(d.f.icon_video_flashon_n);
        } else {
            this.jcv.setImageResource(d.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout clC() {
        return this.jcz;
    }

    public void clD() {
        this.jcF.setVisibility(4);
        if (this.jaI.getStatus() != 6) {
            this.jaI.setStatus(6);
            clI();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jcI == null) {
                this.jcI = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jcI.setDuration(500L);
                this.jcI.setRepeatCount(5);
                this.jcI.setRepeatMode(2);
                this.jcI.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jcI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jaI.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jcA.setVisibility(0);
                        RecordVideoActivity.this.jcA.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jcA.setVisibility(8);
                    if (RecordVideoActivity.this.jaI.getStatus() == 6) {
                        RecordVideoActivity.this.jct.clV();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jaI.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jcA.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jcA.setText("");
                        }
                    }
                }
            });
            this.jcA.setAnimation(this.jcI);
            this.jcI.startNow();
            this.jct.clD();
            if (this.jcR != null) {
                this.jcR.clx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clE() {
        if (this.jaI.getStatus() == 1) {
            this.jcF.setVisibility(4);
            if (this.jaI.getStatus() != 6) {
                this.jct.clE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clF() {
        this.jcF.setVisibility(4);
        if (this.jaI.getStatus() != 6) {
            this.jct.clF();
            if (this.jct.clZ()) {
                clz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clG() {
        this.jcF.setVisibility(4);
        if (this.jaI.getStatus() != 6) {
            this.jct.clG();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void clH() {
        this.jcF.setVisibility(4);
        if (this.jaI.getStatus() != 6) {
            this.jct.clH();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clI() {
        this.jcN = true;
        if (this.jcH != null && this.jcH.isRunning()) {
            this.jcH.cancel();
        }
        if (this.jcG == null) {
            this.jcG = new AnimatorSet();
            this.jcG.playTogether(ObjectAnimator.ofFloat(this.jcu, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jcB, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jcS, "alpha", 1.0f, 0.0f));
            this.jcG.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jet) {
                        RecordVideoActivity.this.jcu.setVisibility(8);
                        RecordVideoActivity.this.jcB.setVisibility(8);
                        RecordVideoActivity.this.jcS.setVisibility(8);
                    }
                }
            });
            this.jcG.setDuration(300L);
        }
        this.jcG.start();
        this.jcB.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clx() {
        if (this.fpA == 2) {
            if (this.jcN) {
                this.jcN = false;
                if (this.jcR != null) {
                    this.jcR.clx();
                }
            } else {
                return;
            }
        }
        if (this.jcG != null && this.jcG.isRunning()) {
            this.jcG.cancel();
        }
        if (this.jcH == null) {
            this.jcH = new AnimatorSet();
            this.jcH.playTogether(ObjectAnimator.ofFloat(this.jcu, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jcB, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jcS, "alpha", 0.0f, 1.0f));
            this.jcH.setDuration(300L);
        }
        this.jcu.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jcB.setVisibility(0);
        }
        if (this.jaI.getStatus() == 1) {
            this.jcS.setVisibility(0);
        }
        this.jcH.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clJ() {
        if (this.jaQ != null) {
            this.jaQ.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jaI.setStatus(1);
                    RecordVideoActivity.this.clx();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jcT != null && !v.T(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jcT)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jcT);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jcT = new ImageFileInfo();
                        RecordVideoActivity.this.jcT.setFilePath(str);
                        RecordVideoActivity.this.jcT.setTempFile(true);
                        RecordVideoActivity.this.jcT.setAlbumnId(null);
                        RecordVideoActivity.this.jcT.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jcT);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jcM, RecordVideoActivity.this.jcL)));
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
        this.jcI.cancel();
        this.jcI.setAnimationListener(null);
        this.jcA.clearAnimation();
        this.jcA.setVisibility(8);
        if (this.jcR != null) {
            this.jcR.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clL() {
        ccR();
    }

    private void ccR() {
        if (this.jcJ != null) {
            this.jcJ.cancel();
        }
        if (this.jcK == null) {
            this.jcK = ObjectAnimator.ofFloat(this.jcS, "alpha", 1.0f, 0.0f);
            this.jcK.setDuration(500L);
            this.jcK.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jet) {
                        RecordVideoActivity.this.jcS.setVisibility(8);
                    }
                }
            });
        }
        this.jcK.start();
    }

    private void ccQ() {
        if (this.jcK != null) {
            this.jcK.cancel();
        }
        if (this.jcJ == null) {
            this.jcJ = ObjectAnimator.ofFloat(this.jcS, "alpha", 0.0f, 1.0f);
            this.jcJ.setDuration(500L);
        }
        this.jcS.setVisibility(0);
        this.jcJ.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clM() {
        this.jcB.reset();
        if (this.jaI.getStatus() == 1) {
            ccQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clN() {
        if (this.jcD.getVisibility() != 0) {
            this.jct.clU();
            this.jaI.setStatus(8);
            clx();
            if (this.jaQ.jby != null && this.jaQ.jby.size() > 0) {
                this.jcD.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jcX = 50;
        final int jcY = 1;
        Handler jcZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jcE.aP(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.clR();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void clR() {
            this.jcZ.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            clR();
            boolean z = RecordVideoActivity.this.jcR == null || TextUtils.isEmpty(RecordVideoActivity.this.jcR.clw()) || !new File(RecordVideoActivity.this.jcR.clw()).exists();
            if (RecordVideoActivity.this.jaQ.jby.size() > 1) {
                return com.baidu.tieba.video.meida.h.ckJ().a(RecordVideoActivity.this.jaQ.jby, RecordVideoActivity.this.jaQ.cla(), z);
            }
            File file = new File(RecordVideoActivity.this.jaQ.jby.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.jaQ.cla()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.ckJ().a(RecordVideoActivity.this.jaQ.jby, RecordVideoActivity.this.jaQ.cla(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jct.cma();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cly();
                    RecordVideoActivity.this.AD(102);
                    RecordVideoActivity.this.jcD.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cly();
                RecordVideoActivity.this.AD(102);
                RecordVideoActivity.this.jcD.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.jcD.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.as(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jcE.aP(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jct == null || v.T(this.jct.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jct.getChoosedBeautyList()) {
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
        if (this.jct == null || v.T(this.jct.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jct.getChoosedFilterList()) {
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
        if (this.jct == null || v.T(this.jct.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jct.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clO() {
        this.jcF.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clP() {
        this.jcF.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void clQ() {
        if (this.jaI.getStatus() == 1) {
            this.jcS.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jaQ != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jaQ.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").T(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jcB.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jcB.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jaQ.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.bJ(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jaI.getStatus() == 1) {
                            amVar.T("obj_type", 1);
                        } else {
                            amVar.T("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jcB.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jcB.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jcR.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jcB.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jcB.setViewChoosed(0, true);
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
            this.jcQ = stickerItem;
            this.jcP.DS(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jaQ != null) {
                    this.jaQ.setSticker(null);
                    this.jcV = false;
                }
                if (this.jct != null) {
                    this.jct.setDownLoadSticker(null);
                }
                this.jcC.setVisibility(8);
                this.jcB.setViewChoosed(1, false);
                return;
            }
            String DP = this.jcP.DP(stickerItem.resource);
            if (!StringUtils.isNull(DP)) {
                a(stickerItem, DP);
                if (this.jct != null) {
                    this.jct.setDownLoadSticker(null);
                }
            } else {
                if (this.jct != null) {
                    this.jct.setDownLoadSticker(stickerItem);
                }
                this.jcP.DQ(stickerItem.resource);
            }
            this.jcB.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jaQ != null) {
                this.jaQ.setSticker(stickerItem);
                this.jcV = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jcC.setText(stickerItem.desc);
                this.jcC.setVisibility(0);
                this.jcC.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jcC.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jcC.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cw(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jct.getLayoutParams();
            layoutParams.height = i4;
            this.jct.setLayoutParams(layoutParams);
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
                if (this.jcR != null && !TextUtils.isEmpty(DA)) {
                    this.jcR.ef(DA, stringExtra2);
                    this.jct.ckO();
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
        if (this.jaI.getStatus() == 8) {
            this.jct.clT();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void qI(boolean z) {
        if (this.jaI != null && (this.jaI.getStatus() == 1 || this.jaI.getStatus() == 3 || this.jaI.getStatus() == 4)) {
            if (!z && this.jcV) {
                this.jcz.aMQ();
                return;
            } else {
                this.jcz.aMR();
                return;
            }
        }
        this.jcz.aMR();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void M(int i, boolean z) {
        int i2 = 1;
        if (this.fpA != i) {
            switch (i) {
                case 1:
                    if (this.jcR != null) {
                        this.jcR.avd();
                    }
                    this.jaQ.setFilter("origin");
                    this.jcB.setViewChoosed(0, false);
                    this.jcB.setViewChoosed(3, false);
                    this.jct.AF(1);
                    this.jcB.setViewVisibility(0, 8);
                    this.jcB.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jcB.setViewVisibility(0, 0);
                    this.jcB.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fpA = i;
            this.jct.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().T("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void clv() {
        if (this.jaI.getStatus() == 1 && !this.jct.clY()) {
            M(1, true);
            this.jcS.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void clu() {
        if (this.jaI.getStatus() == 1 && !this.jct.clY()) {
            M(2, true);
            this.jcS.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AD(int i) {
        if (this.iGY != null) {
            this.iGY.at(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(int i, String str) {
        if (this.iGY != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.iGY.as(i, str);
        }
    }
}
