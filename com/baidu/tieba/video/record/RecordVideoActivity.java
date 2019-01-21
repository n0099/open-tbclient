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
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
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
import com.baidu.tieba.e;
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
    private ImageView eAR;
    private int ecj;
    private final CustomMessageListener edS;
    private String hFG;
    private SelectMusicModel hFK;
    private b.a hJb;
    protected h hKD;
    private i hKv;
    private b hLp;
    private int hMA;
    private ForumWriteData hMB;
    private boolean hMC;
    private boolean hMD = true;
    private l hME;
    private StickerItem hMF;
    protected j hMG;
    private RecordTabLayout hMH;
    private ImageFileInfo hMI;
    private HttpMessageListener hMJ;
    private boolean hMK;
    private RecordLayout hMh;
    private VideoControllerLayout hMi;
    private RelativeLayout hMj;
    private ImageView hMk;
    private ImageView hMl;
    private ImageView hMm;
    private com.baidu.tbadk.core.dialog.a hMn;
    private PreviewViewContainer hMo;
    private TextView hMp;
    private VideoEffectButtonLayout hMq;
    private TextView hMr;
    private View hMs;
    private RoundProgressBar hMt;
    private TextView hMu;
    private AnimatorSet hMv;
    private AnimatorSet hMw;
    private ScaleAnimation hMx;
    private ObjectAnimator hMy;
    private ObjectAnimator hMz;
    private com.baidu.tieba.j.h hqM;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hqM = lVar.bdZ();
        }
        if (this.hqM != null) {
            this.hqM.bdD();
        }
        this.hJb = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eb(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.I(list)) {
                    if (RecordVideoActivity.this.hMi != null) {
                        RecordVideoActivity.this.hMi.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hMi != null) {
                    RecordVideoActivity.this.hMi.setHasLocalVideo(true);
                    RecordVideoActivity.this.hMD = false;
                }
            }
        };
        this.hMJ = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hMi != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hMi.setStickerItems(list);
                    }
                }
            }
        };
        this.edS = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bLZ() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hKD.hFM);
        videoInfo.setVideoDuration(this.hKv.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hKD.hFM).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hMB.writeCallFrom, this.hMB == null ? "" : this.hMB.forumName, this.hMB == null ? "" : this.hMB.forumId, this.hFG, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hMG != null) {
            this.hMG.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.hqM != null) {
            this.hqM.bdG();
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
        if (this.hKv != null && this.hKv.Gf()) {
            this.hKv.stopRecord();
        }
        if (this.hFK != null) {
            this.hFK.cancelLoadData();
        }
        if (this.hqM != null) {
            this.hqM.sv("record");
        }
        com.baidu.tbadk.core.util.l.y(new File(com.baidu.tieba.video.c.hEb));
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
        setContentView(e.h.record_activity);
        this.hMA = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hMB = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hFG = getIntent().getStringExtra("video_title");
        initUI();
        this.hFK = new SelectMusicModel(getPageContext(), this.hMi);
        this.hFK.bKq();
        this.hMG = new j(this);
        this.hMG.b(this.hFK);
        this.hKv.a(this.hMG);
        registerListener(this.hMJ);
        registerListener(this.edS);
        bMa();
    }

    private void bMa() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", ErrDef.Feature.OVERFLOW);
        sendMessage(httpMessage);
    }

    private void bKS() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hJb);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hMh = (RecordLayout) findViewById(e.g.root_layout);
        this.hMh.setListener(this);
        this.hKv = new i(this);
        this.hMi = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hMi.setRecordController(this.hKv);
        this.hMi.setRecordControlListener(this);
        this.hMi.setEffectChoosedListener(this);
        this.hMj = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.eAR = (ImageView) findViewById(e.g.close_page);
        this.eAR.setOnClickListener(this);
        this.hMk = (ImageView) findViewById(e.g.flash_switch);
        this.hMk.setOnClickListener(this);
        this.hMl = (ImageView) findViewById(e.g.camera_switch);
        this.hMl.setOnClickListener(this);
        this.hMm = (ImageView) findViewById(e.g.count_down);
        this.hMm.setOnClickListener(this);
        this.hMo = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hKD = new h(this);
        this.hKD.a(this);
        this.hKD.setFaceIdentifyStateListener(this);
        this.hKD.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bLN() {
                if (RecordVideoActivity.this.hMi.bMz()) {
                    RecordVideoActivity.this.hMi.a((m) null);
                }
            }
        });
        this.hMq = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hMq.setListener(this);
        this.hKv.a(this.hMq);
        this.hMq.setViewChoosed(2, true);
        this.hMp = (TextView) findViewById(e.g.tv_count_down);
        this.hMr = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds150);
        if (this.hMp.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hMp.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hMq.setVisibility(8);
        }
        this.hMs = findViewById(e.g.progress_layout);
        this.hMt = (RoundProgressBar) this.hMs.findViewById(e.g.video_progress);
        this.hMu = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hMu.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds38);
        this.hMu.setLayoutParams(layoutParams);
        this.hMH = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hMH.ar(1, getString(e.j.tab_photo));
        if (this.hMA != 2 && this.hMA != 3) {
            this.hMH.ar(2, getString(e.j.tab_record));
            this.hMH.setListener(this);
            this.hMH.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hMH.setShowIndicator(false);
            this.hMH.setCurrentTab(1, false);
            G(1, false);
        }
        bMb();
    }

    private void bMb() {
        if (com.baidu.tbadk.core.util.g.CR()) {
            this.mStatusBarView = findViewById(e.g.statusbar_view);
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
        this.hKD.onResume();
        this.hLp = this.hKD.bLE();
        if (this.hLp != null) {
            this.hLp.setRecordController(this.hKv);
            this.hMo.setZoomHelper(this.hLp);
        }
        bMc();
        if (this.hME == null) {
            this.hME = new l();
            this.hME.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cT(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hMF, str2);
                    if (RecordVideoActivity.this.hMi != null) {
                        RecordVideoActivity.this.hMi.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void wS(String str) {
                    if (RecordVideoActivity.this.hMi != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hMi.b(stickerItem);
                        if (RecordVideoActivity.this.hKD != null) {
                            RecordVideoActivity.this.hKD.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hMi != null) {
                        RecordVideoActivity.this.hMi.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(e.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                    RecordVideoActivity recordVideoActivity = RecordVideoActivity.this;
                    if (StringUtils.isNull(str)) {
                        str = RecordVideoActivity.this.getResources().getString(e.j.sticker_download_error);
                    }
                    recordVideoActivity.aa(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bJy() {
                    if (RecordVideoActivity.this.hMi != null) {
                        RecordVideoActivity.this.hMi.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hME.bMt();
        if (this.hMi != null && this.hMD) {
            bKS();
        }
        if (this.hqM != null) {
            this.hqM.su(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hKD.onPause();
        if (this.hMi != null) {
            if (this.hKv != null && this.hKv.getStatus() == 6) {
                this.hMi.stopRecord();
                bMl();
            }
            if (this.hKv != null && this.hKv.Gf()) {
                this.hMi.stopRecord();
            }
        }
        if (this.hMG != null) {
            this.hMG.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hKv == null || this.hKv.getStatus() != 7) {
            if (this.hKv != null && this.hKv.getStatus() == 6) {
                if (this.hMi != null) {
                    this.hMi.stopRecord();
                }
                bMl();
            } else if (this.hKv.onBackPressed()) {
                finish();
            } else {
                if (this.hMn == null) {
                    this.hMn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hMn.db(e.j.video_quit_confirm);
                    this.hMn.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hMn.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hMn.bg(true);
                    this.hMn.b(getPageContext());
                }
                this.hMn.BS();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hMu.setVisibility(4);
        if (view == this.eAR) {
            onBackPressed();
        } else if (view == this.hMk) {
            if (this.hKv.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hKD.bLH();
            bMc();
        } else if (view == this.hMl) {
            if (this.hKv.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hMl.setOnClickListener(null);
            this.hKD.bLJ();
            if (this.hKD.bLK() && this.hKD.bLI()) {
                this.hKD.bLH();
            }
            bMc();
            this.hMl.setOnClickListener(this);
        } else if (view == this.hMm) {
            bMe();
        }
    }

    private void bMc() {
        if (this.hKD.bLK()) {
            this.hMk.setVisibility(8);
        } else {
            this.hMk.setVisibility(0);
        }
        if (this.hKD.bLI()) {
            this.hMk.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hMk.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bMd() {
        return this.hMo;
    }

    public void bMe() {
        this.hMu.setVisibility(4);
        if (this.hKv.getStatus() != 6) {
            this.hKv.setStatus(6);
            bMj();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hMx == null) {
                this.hMx = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hMx.setDuration(500L);
                this.hMx.setRepeatCount(5);
                this.hMx.setRepeatMode(2);
                this.hMx.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hMx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hKv.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hMp.setVisibility(0);
                        RecordVideoActivity.this.hMp.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hMp.setVisibility(8);
                    if (RecordVideoActivity.this.hKv.getStatus() == 6) {
                        RecordVideoActivity.this.hMi.bMw();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hKv.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hMp.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hMp.setText("");
                        }
                    }
                }
            });
            this.hMp.setAnimation(this.hMx);
            this.hMx.startNow();
            this.hMi.bMe();
            if (this.hMG != null) {
                this.hMG.bLY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMf() {
        if (this.hKv.getStatus() == 1) {
            this.hMu.setVisibility(4);
            if (this.hKv.getStatus() != 6) {
                this.hMi.bMf();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMg() {
        this.hMu.setVisibility(4);
        if (this.hKv.getStatus() != 6) {
            this.hMi.bMg();
            if (this.hMi.bMA()) {
                bMa();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMh() {
        this.hMu.setVisibility(4);
        if (this.hKv.getStatus() != 6) {
            this.hMi.bMh();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMi() {
        this.hMu.setVisibility(4);
        if (this.hKv.getStatus() != 6) {
            this.hMi.bMi();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMj() {
        this.hMC = true;
        if (this.hMw != null && this.hMw.isRunning()) {
            this.hMw.cancel();
        }
        if (this.hMv == null) {
            this.hMv = new AnimatorSet();
            this.hMv.playTogether(ObjectAnimator.ofFloat(this.hMj, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hMq, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hMH, "alpha", 1.0f, 0.0f));
            this.hMv.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOj) {
                        RecordVideoActivity.this.hMj.setVisibility(8);
                        RecordVideoActivity.this.hMq.setVisibility(8);
                        RecordVideoActivity.this.hMH.setVisibility(8);
                    }
                }
            });
            this.hMv.setDuration(300L);
        }
        this.hMv.start();
        this.hMq.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLY() {
        if (this.ecj == 2) {
            if (this.hMC) {
                this.hMC = false;
                if (this.hMG != null) {
                    this.hMG.bLY();
                }
            } else {
                return;
            }
        }
        if (this.hMv != null && this.hMv.isRunning()) {
            this.hMv.cancel();
        }
        if (this.hMw == null) {
            this.hMw = new AnimatorSet();
            this.hMw.playTogether(ObjectAnimator.ofFloat(this.hMj, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hMq, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hMH, "alpha", 0.0f, 1.0f));
            this.hMw.setDuration(300L);
        }
        this.hMj.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hMq.setVisibility(0);
        }
        if (this.hKv.getStatus() == 1) {
            this.hMH.setVisibility(0);
        }
        this.hMw.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMk() {
        if (this.hKD != null) {
            this.hKD.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void t(boolean z, String str) {
                    RecordVideoActivity.this.hKv.setStatus(1);
                    RecordVideoActivity.this.bLY();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hMI != null && !v.I(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hMI)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hMI);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hMI = new ImageFileInfo();
                        RecordVideoActivity.this.hMI.setFilePath(str);
                        RecordVideoActivity.this.hMI.setTempFile(true);
                        RecordVideoActivity.this.hMI.setAlbumnId(null);
                        RecordVideoActivity.this.hMI.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hMI);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hMB, RecordVideoActivity.this.hMA)));
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
    public void bMl() {
        this.hMx.cancel();
        this.hMx.setAnimationListener(null);
        this.hMp.clearAnimation();
        this.hMp.setVisibility(8);
        if (this.hMG != null) {
            this.hMG.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMm() {
        bCe();
    }

    private void bCe() {
        if (this.hMy != null) {
            this.hMy.cancel();
        }
        if (this.hMz == null) {
            this.hMz = ObjectAnimator.ofFloat(this.hMH, "alpha", 1.0f, 0.0f);
            this.hMz.setDuration(500L);
            this.hMz.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOj) {
                        RecordVideoActivity.this.hMH.setVisibility(8);
                    }
                }
            });
        }
        this.hMz.start();
    }

    private void bCd() {
        if (this.hMz != null) {
            this.hMz.cancel();
        }
        if (this.hMy == null) {
            this.hMy = ObjectAnimator.ofFloat(this.hMH, "alpha", 0.0f, 1.0f);
            this.hMy.setDuration(500L);
        }
        this.hMH.setVisibility(0);
        this.hMy.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMn() {
        this.hMq.reset();
        if (this.hKv.getStatus() == 1) {
            bCd();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMo() {
        if (this.hMs.getVisibility() != 0) {
            this.hMi.bMv();
            this.hKv.setStatus(8);
            bLY();
            if (this.hKD.hLn != null && this.hKD.hLn.size() > 0) {
                this.hMs.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hMM = 50;
        final int hMN = 1;
        Handler hMO = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hMt.aC(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bMs();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bMs() {
            this.hMO.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bMs();
            boolean z = RecordVideoActivity.this.hMG == null || TextUtils.isEmpty(RecordVideoActivity.this.hMG.bLX()) || !new File(RecordVideoActivity.this.hMG.bLX()).exists();
            if (RecordVideoActivity.this.hKD.hLn.size() > 1) {
                return com.baidu.tieba.video.meida.h.bLk().c(RecordVideoActivity.this.hKD.hLn, RecordVideoActivity.this.hKD.bLB(), z);
            }
            File file = new File(RecordVideoActivity.this.hKD.hLn.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hKD.bLB()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bLk().c(RecordVideoActivity.this.hKD.hLn, RecordVideoActivity.this.hKD.bLB(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hMi.bMB();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bLZ();
                    RecordVideoActivity.this.wV(102);
                    RecordVideoActivity.this.hMs.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bLZ();
                RecordVideoActivity.this.wV(102);
                RecordVideoActivity.this.hMs.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hMs.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aa(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hMt.aC(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hMi == null || v.I(this.hMi.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hMi.getChoosedBeautyList()) {
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
        if (this.hMi == null || v.I(this.hMi.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hMi.getChoosedFilterList()) {
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
        if (this.hMi == null || v.I(this.hMi.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hMi.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMp() {
        this.hMu.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMq() {
        this.hMu.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMr() {
        if (this.hKv.getStatus() == 1) {
            this.hMH.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hKD != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hKD.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").y(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hMq.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hMq.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hKD.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.aB(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hKv.getStatus() == 1) {
                            amVar.y("obj_type", 1);
                        } else {
                            amVar.y("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.hMq.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hMq.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hMG.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hMq.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hMq.setViewChoosed(0, true);
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
            this.hMF = stickerItem;
            this.hME.xs(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hKD != null) {
                    this.hKD.setSticker(null);
                    this.hMK = false;
                }
                if (this.hMi != null) {
                    this.hMi.setDownLoadSticker(null);
                }
                this.hMr.setVisibility(8);
                this.hMq.setViewChoosed(1, false);
                return;
            }
            String xp = this.hME.xp(stickerItem.resource);
            if (!StringUtils.isNull(xp)) {
                a(stickerItem, xp);
                if (this.hMi != null) {
                    this.hMi.setDownLoadSticker(null);
                }
            } else {
                if (this.hMi != null) {
                    this.hMi.setDownLoadSticker(stickerItem);
                }
                this.hME.xq(stickerItem.resource);
            }
            this.hMq.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hKD != null) {
                this.hKD.setSticker(stickerItem);
                this.hMK = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hMr.setText(stickerItem.desc);
                this.hMr.setVisibility(0);
                this.hMr.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hMr.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hMr.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bZ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0210e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hMi.getLayoutParams();
            layoutParams.height = i4;
            this.hMi.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String xa = com.baidu.tieba.video.editvideo.model.a.bKk().xa(stringExtra);
                if (this.hMG != null && !TextUtils.isEmpty(xa)) {
                    this.hMG.cU(xa, stringExtra2);
                    this.hMi.bLp();
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
        if (this.hKv.getStatus() == 8) {
            this.hMi.bMu();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void oi(boolean z) {
        if (this.hKv != null && (this.hKv.getStatus() == 1 || this.hKv.getStatus() == 3 || this.hKv.getStatus() == 4)) {
            if (!z && this.hMK) {
                this.hMo.amh();
                return;
            } else {
                this.hMo.ami();
                return;
            }
        }
        this.hMo.ami();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.ecj != i) {
            switch (i) {
                case 1:
                    if (this.hMG != null) {
                        this.hMG.Vh();
                    }
                    this.hKD.setFilter("origin");
                    this.hMq.setViewChoosed(0, false);
                    this.hMq.setViewChoosed(3, false);
                    this.hMi.wX(1);
                    this.hMq.setViewVisibility(0, 8);
                    this.hMq.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hMq.setViewVisibility(0, 0);
                    this.hMq.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.ecj = i;
            this.hMi.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().y("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bLW() {
        if (this.hKv.getStatus() == 1 && !this.hMi.bMz()) {
            G(1, true);
            this.hMH.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bLV() {
        if (this.hKv.getStatus() == 1 && !this.hMi.bMz()) {
            G(2, true);
            this.hMH.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.hqM != null) {
            this.hqM.ab(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        if (this.hqM != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hqM.aa(i, str);
        }
    }
}
