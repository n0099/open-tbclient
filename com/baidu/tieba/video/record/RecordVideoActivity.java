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
    private ImageView eAQ;
    private int eci;
    private final CustomMessageListener edR;
    private String hFF;
    private SelectMusicModel hFJ;
    private b.a hJa;
    protected h hKC;
    private i hKu;
    private b hLo;
    private ForumWriteData hMA;
    private boolean hMB;
    private boolean hMC = true;
    private l hMD;
    private StickerItem hME;
    protected j hMF;
    private RecordTabLayout hMG;
    private ImageFileInfo hMH;
    private HttpMessageListener hMI;
    private boolean hMJ;
    private RecordLayout hMg;
    private VideoControllerLayout hMh;
    private RelativeLayout hMi;
    private ImageView hMj;
    private ImageView hMk;
    private ImageView hMl;
    private com.baidu.tbadk.core.dialog.a hMm;
    private PreviewViewContainer hMn;
    private TextView hMo;
    private VideoEffectButtonLayout hMp;
    private TextView hMq;
    private View hMr;
    private RoundProgressBar hMs;
    private TextView hMt;
    private AnimatorSet hMu;
    private AnimatorSet hMv;
    private ScaleAnimation hMw;
    private ObjectAnimator hMx;
    private ObjectAnimator hMy;
    private int hMz;
    private com.baidu.tieba.j.h hqL;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hqL = lVar.bdZ();
        }
        if (this.hqL != null) {
            this.hqL.bdD();
        }
        this.hJa = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eb(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.I(list)) {
                    if (RecordVideoActivity.this.hMh != null) {
                        RecordVideoActivity.this.hMh.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hMh != null) {
                    RecordVideoActivity.this.hMh.setHasLocalVideo(true);
                    RecordVideoActivity.this.hMC = false;
                }
            }
        };
        this.hMI = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hMh != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hMh.setStickerItems(list);
                    }
                }
            }
        };
        this.edR = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
        videoInfo.setVideoPath(this.hKC.hFL);
        videoInfo.setVideoDuration(this.hKu.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hKC.hFL).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hMA.writeCallFrom, this.hMA == null ? "" : this.hMA.forumName, this.hMA == null ? "" : this.hMA.forumId, this.hFF, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hMF != null) {
            this.hMF.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.hqL != null) {
            this.hqL.bdG();
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
        if (this.hKu != null && this.hKu.Gf()) {
            this.hKu.stopRecord();
        }
        if (this.hFJ != null) {
            this.hFJ.cancelLoadData();
        }
        if (this.hqL != null) {
            this.hqL.sv("record");
        }
        com.baidu.tbadk.core.util.l.y(new File(com.baidu.tieba.video.c.hEa));
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
        this.hMz = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hMA = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hFF = getIntent().getStringExtra("video_title");
        initUI();
        this.hFJ = new SelectMusicModel(getPageContext(), this.hMh);
        this.hFJ.bKq();
        this.hMF = new j(this);
        this.hMF.b(this.hFJ);
        this.hKu.a(this.hMF);
        registerListener(this.hMI);
        registerListener(this.edR);
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
        bVar.b(this.hJa);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hMg = (RecordLayout) findViewById(e.g.root_layout);
        this.hMg.setListener(this);
        this.hKu = new i(this);
        this.hMh = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hMh.setRecordController(this.hKu);
        this.hMh.setRecordControlListener(this);
        this.hMh.setEffectChoosedListener(this);
        this.hMi = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.eAQ = (ImageView) findViewById(e.g.close_page);
        this.eAQ.setOnClickListener(this);
        this.hMj = (ImageView) findViewById(e.g.flash_switch);
        this.hMj.setOnClickListener(this);
        this.hMk = (ImageView) findViewById(e.g.camera_switch);
        this.hMk.setOnClickListener(this);
        this.hMl = (ImageView) findViewById(e.g.count_down);
        this.hMl.setOnClickListener(this);
        this.hMn = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hKC = new h(this);
        this.hKC.a(this);
        this.hKC.setFaceIdentifyStateListener(this);
        this.hKC.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bLN() {
                if (RecordVideoActivity.this.hMh.bMz()) {
                    RecordVideoActivity.this.hMh.a((m) null);
                }
            }
        });
        this.hMp = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hMp.setListener(this);
        this.hKu.a(this.hMp);
        this.hMp.setViewChoosed(2, true);
        this.hMo = (TextView) findViewById(e.g.tv_count_down);
        this.hMq = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds150);
        if (this.hMo.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hMo.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hMp.setVisibility(8);
        }
        this.hMr = findViewById(e.g.progress_layout);
        this.hMs = (RoundProgressBar) this.hMr.findViewById(e.g.video_progress);
        this.hMt = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hMt.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds38);
        this.hMt.setLayoutParams(layoutParams);
        this.hMG = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hMG.ar(1, getString(e.j.tab_photo));
        if (this.hMz != 2 && this.hMz != 3) {
            this.hMG.ar(2, getString(e.j.tab_record));
            this.hMG.setListener(this);
            this.hMG.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hMG.setShowIndicator(false);
            this.hMG.setCurrentTab(1, false);
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
        this.hKC.onResume();
        this.hLo = this.hKC.bLE();
        if (this.hLo != null) {
            this.hLo.setRecordController(this.hKu);
            this.hMn.setZoomHelper(this.hLo);
        }
        bMc();
        if (this.hMD == null) {
            this.hMD = new l();
            this.hMD.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cT(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hME, str2);
                    if (RecordVideoActivity.this.hMh != null) {
                        RecordVideoActivity.this.hMh.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void wS(String str) {
                    if (RecordVideoActivity.this.hMh != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hMh.b(stickerItem);
                        if (RecordVideoActivity.this.hKC != null) {
                            RecordVideoActivity.this.hKC.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hMh != null) {
                        RecordVideoActivity.this.hMh.setDownLoadSticker(null);
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
                    if (RecordVideoActivity.this.hMh != null) {
                        RecordVideoActivity.this.hMh.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hMD.bMt();
        if (this.hMh != null && this.hMC) {
            bKS();
        }
        if (this.hqL != null) {
            this.hqL.su(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hKC.onPause();
        if (this.hMh != null) {
            if (this.hKu != null && this.hKu.getStatus() == 6) {
                this.hMh.stopRecord();
                bMl();
            }
            if (this.hKu != null && this.hKu.Gf()) {
                this.hMh.stopRecord();
            }
        }
        if (this.hMF != null) {
            this.hMF.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hKu == null || this.hKu.getStatus() != 7) {
            if (this.hKu != null && this.hKu.getStatus() == 6) {
                if (this.hMh != null) {
                    this.hMh.stopRecord();
                }
                bMl();
            } else if (this.hKu.onBackPressed()) {
                finish();
            } else {
                if (this.hMm == null) {
                    this.hMm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hMm.db(e.j.video_quit_confirm);
                    this.hMm.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hMm.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hMm.bg(true);
                    this.hMm.b(getPageContext());
                }
                this.hMm.BS();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hMt.setVisibility(4);
        if (view == this.eAQ) {
            onBackPressed();
        } else if (view == this.hMj) {
            if (this.hKu.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hKC.bLH();
            bMc();
        } else if (view == this.hMk) {
            if (this.hKu.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hMk.setOnClickListener(null);
            this.hKC.bLJ();
            if (this.hKC.bLK() && this.hKC.bLI()) {
                this.hKC.bLH();
            }
            bMc();
            this.hMk.setOnClickListener(this);
        } else if (view == this.hMl) {
            bMe();
        }
    }

    private void bMc() {
        if (this.hKC.bLK()) {
            this.hMj.setVisibility(8);
        } else {
            this.hMj.setVisibility(0);
        }
        if (this.hKC.bLI()) {
            this.hMj.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hMj.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bMd() {
        return this.hMn;
    }

    public void bMe() {
        this.hMt.setVisibility(4);
        if (this.hKu.getStatus() != 6) {
            this.hKu.setStatus(6);
            bMj();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hMw == null) {
                this.hMw = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hMw.setDuration(500L);
                this.hMw.setRepeatCount(5);
                this.hMw.setRepeatMode(2);
                this.hMw.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hMw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hKu.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hMo.setVisibility(0);
                        RecordVideoActivity.this.hMo.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hMo.setVisibility(8);
                    if (RecordVideoActivity.this.hKu.getStatus() == 6) {
                        RecordVideoActivity.this.hMh.bMw();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hKu.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hMo.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hMo.setText("");
                        }
                    }
                }
            });
            this.hMo.setAnimation(this.hMw);
            this.hMw.startNow();
            this.hMh.bMe();
            if (this.hMF != null) {
                this.hMF.bLY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMf() {
        if (this.hKu.getStatus() == 1) {
            this.hMt.setVisibility(4);
            if (this.hKu.getStatus() != 6) {
                this.hMh.bMf();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMg() {
        this.hMt.setVisibility(4);
        if (this.hKu.getStatus() != 6) {
            this.hMh.bMg();
            if (this.hMh.bMA()) {
                bMa();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMh() {
        this.hMt.setVisibility(4);
        if (this.hKu.getStatus() != 6) {
            this.hMh.bMh();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bMi() {
        this.hMt.setVisibility(4);
        if (this.hKu.getStatus() != 6) {
            this.hMh.bMi();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMj() {
        this.hMB = true;
        if (this.hMv != null && this.hMv.isRunning()) {
            this.hMv.cancel();
        }
        if (this.hMu == null) {
            this.hMu = new AnimatorSet();
            this.hMu.playTogether(ObjectAnimator.ofFloat(this.hMi, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hMp, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hMG, "alpha", 1.0f, 0.0f));
            this.hMu.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOi) {
                        RecordVideoActivity.this.hMi.setVisibility(8);
                        RecordVideoActivity.this.hMp.setVisibility(8);
                        RecordVideoActivity.this.hMG.setVisibility(8);
                    }
                }
            });
            this.hMu.setDuration(300L);
        }
        this.hMu.start();
        this.hMp.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bLY() {
        if (this.eci == 2) {
            if (this.hMB) {
                this.hMB = false;
                if (this.hMF != null) {
                    this.hMF.bLY();
                }
            } else {
                return;
            }
        }
        if (this.hMu != null && this.hMu.isRunning()) {
            this.hMu.cancel();
        }
        if (this.hMv == null) {
            this.hMv = new AnimatorSet();
            this.hMv.playTogether(ObjectAnimator.ofFloat(this.hMi, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hMp, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hMG, "alpha", 0.0f, 1.0f));
            this.hMv.setDuration(300L);
        }
        this.hMi.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hMp.setVisibility(0);
        }
        if (this.hKu.getStatus() == 1) {
            this.hMG.setVisibility(0);
        }
        this.hMv.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMk() {
        if (this.hKC != null) {
            this.hKC.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void t(boolean z, String str) {
                    RecordVideoActivity.this.hKu.setStatus(1);
                    RecordVideoActivity.this.bLY();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hMH != null && !v.I(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hMH)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hMH);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hMH = new ImageFileInfo();
                        RecordVideoActivity.this.hMH.setFilePath(str);
                        RecordVideoActivity.this.hMH.setTempFile(true);
                        RecordVideoActivity.this.hMH.setAlbumnId(null);
                        RecordVideoActivity.this.hMH.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hMH);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hMA, RecordVideoActivity.this.hMz)));
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
        this.hMw.cancel();
        this.hMw.setAnimationListener(null);
        this.hMo.clearAnimation();
        this.hMo.setVisibility(8);
        if (this.hMF != null) {
            this.hMF.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMm() {
        bCe();
    }

    private void bCe() {
        if (this.hMx != null) {
            this.hMx.cancel();
        }
        if (this.hMy == null) {
            this.hMy = ObjectAnimator.ofFloat(this.hMG, "alpha", 1.0f, 0.0f);
            this.hMy.setDuration(500L);
            this.hMy.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hOi) {
                        RecordVideoActivity.this.hMG.setVisibility(8);
                    }
                }
            });
        }
        this.hMy.start();
    }

    private void bCd() {
        if (this.hMy != null) {
            this.hMy.cancel();
        }
        if (this.hMx == null) {
            this.hMx = ObjectAnimator.ofFloat(this.hMG, "alpha", 0.0f, 1.0f);
            this.hMx.setDuration(500L);
        }
        this.hMG.setVisibility(0);
        this.hMx.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMn() {
        this.hMp.reset();
        if (this.hKu.getStatus() == 1) {
            bCd();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMo() {
        if (this.hMr.getVisibility() != 0) {
            this.hMh.bMv();
            this.hKu.setStatus(8);
            bLY();
            if (this.hKC.hLm != null && this.hKC.hLm.size() > 0) {
                this.hMr.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hML = 50;
        final int hMM = 1;
        Handler hMN = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hMs.aC(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bMs();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bMs() {
            this.hMN.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bMs();
            boolean z = RecordVideoActivity.this.hMF == null || TextUtils.isEmpty(RecordVideoActivity.this.hMF.bLX()) || !new File(RecordVideoActivity.this.hMF.bLX()).exists();
            if (RecordVideoActivity.this.hKC.hLm.size() > 1) {
                return com.baidu.tieba.video.meida.h.bLk().c(RecordVideoActivity.this.hKC.hLm, RecordVideoActivity.this.hKC.bLB(), z);
            }
            File file = new File(RecordVideoActivity.this.hKC.hLm.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hKC.bLB()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bLk().c(RecordVideoActivity.this.hKC.hLm, RecordVideoActivity.this.hKC.bLB(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hMh.bMB();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bLZ();
                    RecordVideoActivity.this.wV(102);
                    RecordVideoActivity.this.hMr.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bLZ();
                RecordVideoActivity.this.wV(102);
                RecordVideoActivity.this.hMr.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hMr.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aa(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hMs.aC(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hMh == null || v.I(this.hMh.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hMh.getChoosedBeautyList()) {
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
        if (this.hMh == null || v.I(this.hMh.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hMh.getChoosedFilterList()) {
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
        if (this.hMh == null || v.I(this.hMh.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hMh.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMp() {
        this.hMt.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMq() {
        this.hMt.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bMr() {
        if (this.hKu.getStatus() == 1) {
            this.hMG.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hKC != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hKC.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").y(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hMp.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hMp.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hKC.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.aB(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hKu.getStatus() == 1) {
                            amVar.y("obj_type", 1);
                        } else {
                            amVar.y("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.hMp.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hMp.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hMF.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hMp.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hMp.setViewChoosed(0, true);
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
            this.hME = stickerItem;
            this.hMD.xs(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hKC != null) {
                    this.hKC.setSticker(null);
                    this.hMJ = false;
                }
                if (this.hMh != null) {
                    this.hMh.setDownLoadSticker(null);
                }
                this.hMq.setVisibility(8);
                this.hMp.setViewChoosed(1, false);
                return;
            }
            String xp = this.hMD.xp(stickerItem.resource);
            if (!StringUtils.isNull(xp)) {
                a(stickerItem, xp);
                if (this.hMh != null) {
                    this.hMh.setDownLoadSticker(null);
                }
            } else {
                if (this.hMh != null) {
                    this.hMh.setDownLoadSticker(stickerItem);
                }
                this.hMD.xq(stickerItem.resource);
            }
            this.hMp.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hKC != null) {
                this.hKC.setSticker(stickerItem);
                this.hMJ = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hMq.setText(stickerItem.desc);
                this.hMq.setVisibility(0);
                this.hMq.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hMq.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hMq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bZ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0210e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hMh.getLayoutParams();
            layoutParams.height = i4;
            this.hMh.setLayoutParams(layoutParams);
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
                if (this.hMF != null && !TextUtils.isEmpty(xa)) {
                    this.hMF.cU(xa, stringExtra2);
                    this.hMh.bLp();
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
        if (this.hKu.getStatus() == 8) {
            this.hMh.bMu();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void oi(boolean z) {
        if (this.hKu != null && (this.hKu.getStatus() == 1 || this.hKu.getStatus() == 3 || this.hKu.getStatus() == 4)) {
            if (!z && this.hMJ) {
                this.hMn.amh();
                return;
            } else {
                this.hMn.ami();
                return;
            }
        }
        this.hMn.ami();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.eci != i) {
            switch (i) {
                case 1:
                    if (this.hMF != null) {
                        this.hMF.Vh();
                    }
                    this.hKC.setFilter("origin");
                    this.hMp.setViewChoosed(0, false);
                    this.hMp.setViewChoosed(3, false);
                    this.hMh.wX(1);
                    this.hMp.setViewVisibility(0, 8);
                    this.hMp.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hMp.setViewVisibility(0, 0);
                    this.hMp.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.eci = i;
            this.hMh.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().y("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bLW() {
        if (this.hKu.getStatus() == 1 && !this.hMh.bMz()) {
            G(1, true);
            this.hMG.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bLV() {
        if (this.hKu.getStatus() == 1 && !this.hMh.bMz()) {
            G(2, true);
            this.hMG.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(int i) {
        if (this.hqL != null) {
            this.hqL.ab(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, String str) {
        if (this.hqL != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hqL.aa(i, str);
        }
    }
}
