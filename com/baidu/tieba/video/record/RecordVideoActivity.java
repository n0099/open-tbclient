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
    private int dRd;
    private final CustomMessageListener dSK;
    private ImageView eoY;
    private com.baidu.tieba.j.h hea;
    private String hsr;
    private SelectMusicModel hsv;
    private b.a hvM;
    private b hxZ;
    private i hxh;
    protected h hxp;
    private RecordLayout hyR;
    private VideoControllerLayout hyS;
    private RelativeLayout hyT;
    private ImageView hyU;
    private ImageView hyV;
    private ImageView hyW;
    private com.baidu.tbadk.core.dialog.a hyX;
    private PreviewViewContainer hyY;
    private TextView hyZ;
    private VideoEffectButtonLayout hza;
    private TextView hzb;
    private View hzc;
    private RoundProgressBar hzd;
    private TextView hze;
    private AnimatorSet hzf;
    private AnimatorSet hzg;
    private ScaleAnimation hzh;
    private ObjectAnimator hzi;
    private ObjectAnimator hzj;
    private int hzk;
    private ForumWriteData hzl;
    private boolean hzm;
    private boolean hzn = true;
    private l hzo;
    private StickerItem hzp;
    protected j hzq;
    private RecordTabLayout hzr;
    private ImageFileInfo hzs;
    private HttpMessageListener hzt;
    private boolean hzu;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hea = lVar.bbw();
        }
        if (this.hea != null) {
            this.hea.bbc();
        }
        this.hvM = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dX(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.J(list)) {
                    if (RecordVideoActivity.this.hyS != null) {
                        RecordVideoActivity.this.hyS.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hyS != null) {
                    RecordVideoActivity.this.hyS.setHasLocalVideo(true);
                    RecordVideoActivity.this.hzn = false;
                }
            }
        };
        this.hzt = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hyS != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hyS.setStickerItems(list);
                    }
                }
            }
        };
        this.dSK = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bIX() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hxp.hsx);
        videoInfo.setVideoDuration(this.hxh.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hxp.hsx).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hzl.writeCallFrom, this.hzl == null ? "" : this.hzl.forumName, this.hzl == null ? "" : this.hzl.forumId, this.hsr, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hzq != null) {
            this.hzq.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.hea != null) {
            this.hea.bbf();
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
        if (this.hxh != null && this.hxh.isRecording()) {
            this.hxh.stopRecord();
        }
        if (this.hsv != null) {
            this.hsv.cancelLoadData();
        }
        if (this.hea != null) {
            this.hea.ry("record");
        }
        com.baidu.tbadk.core.util.l.x(new File(com.baidu.tieba.video.c.hqM));
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
        this.hzk = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hzl = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hsr = getIntent().getStringExtra("video_title");
        initUI();
        this.hsv = new SelectMusicModel(getPageContext(), this.hyS);
        this.hsv.bHo();
        this.hzq = new j(this);
        this.hzq.b(this.hsv);
        this.hxh.a(this.hzq);
        registerListener(this.hzt);
        registerListener(this.dSK);
        bIY();
    }

    private void bIY() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", ErrDef.Feature.OVERFLOW);
        sendMessage(httpMessage);
    }

    private void bHQ() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hvM);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hyR = (RecordLayout) findViewById(e.g.root_layout);
        this.hyR.setListener(this);
        this.hxh = new i(this);
        this.hyS = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hyS.setRecordController(this.hxh);
        this.hyS.setRecordControlListener(this);
        this.hyS.setEffectChoosedListener(this);
        this.hyT = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.eoY = (ImageView) findViewById(e.g.close_page);
        this.eoY.setOnClickListener(this);
        this.hyU = (ImageView) findViewById(e.g.flash_switch);
        this.hyU.setOnClickListener(this);
        this.hyV = (ImageView) findViewById(e.g.camera_switch);
        this.hyV.setOnClickListener(this);
        this.hyW = (ImageView) findViewById(e.g.count_down);
        this.hyW.setOnClickListener(this);
        this.hyY = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hxp = new h(this);
        this.hxp.a(this);
        this.hxp.setFaceIdentifyStateListener(this);
        this.hxp.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bIL() {
                if (RecordVideoActivity.this.hyS.bJx()) {
                    RecordVideoActivity.this.hyS.a((m) null);
                }
            }
        });
        this.hza = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hza.setListener(this);
        this.hxh.a(this.hza);
        this.hza.setViewChoosed(2, true);
        this.hyZ = (TextView) findViewById(e.g.tv_count_down);
        this.hzb = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds150);
        if (this.hyZ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hyZ.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hza.setVisibility(8);
        }
        this.hzc = findViewById(e.g.progress_layout);
        this.hzd = (RoundProgressBar) this.hzc.findViewById(e.g.video_progress);
        this.hze = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hze.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds38);
        this.hze.setLayoutParams(layoutParams);
        this.hzr = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hzr.as(1, getString(e.j.tab_photo));
        if (this.hzk != 2 && this.hzk != 3) {
            this.hzr.as(2, getString(e.j.tab_record));
            this.hzr.setListener(this);
            this.hzr.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hzr.setShowIndicator(false);
            this.hzr.setCurrentTab(1, false);
            G(1, false);
        }
        bIZ();
    }

    private void bIZ() {
        if (com.baidu.tbadk.core.util.g.Bt()) {
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
        this.hxp.onResume();
        this.hxZ = this.hxp.bIC();
        if (this.hxZ != null) {
            this.hxZ.setRecordController(this.hxh);
            this.hyY.setZoomHelper(this.hxZ);
        }
        bJa();
        if (this.hzo == null) {
            this.hzo = new l();
            this.hzo.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cM(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hzp, str2);
                    if (RecordVideoActivity.this.hyS != null) {
                        RecordVideoActivity.this.hyS.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void vR(String str) {
                    if (RecordVideoActivity.this.hyS != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hyS.b(stickerItem);
                        if (RecordVideoActivity.this.hxp != null) {
                            RecordVideoActivity.this.hxp.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hyS != null) {
                        RecordVideoActivity.this.hyS.setDownLoadSticker(null);
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
                    recordVideoActivity.ab(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bGw() {
                    if (RecordVideoActivity.this.hyS != null) {
                        RecordVideoActivity.this.hyS.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hzo.bJr();
        if (this.hyS != null && this.hzn) {
            bHQ();
        }
        if (this.hea != null) {
            this.hea.rx(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hxp.onPause();
        if (this.hyS != null) {
            if (this.hxh != null && this.hxh.getStatus() == 6) {
                this.hyS.stopRecord();
                bJj();
            }
            if (this.hxh != null && this.hxh.isRecording()) {
                this.hyS.stopRecord();
            }
        }
        if (this.hzq != null) {
            this.hzq.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hxh == null || this.hxh.getStatus() != 7) {
            if (this.hxh != null && this.hxh.getStatus() == 6) {
                if (this.hyS != null) {
                    this.hyS.stopRecord();
                }
                bJj();
            } else if (this.hxh.onBackPressed()) {
                finish();
            } else {
                if (this.hyX == null) {
                    this.hyX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hyX.cz(e.j.video_quit_confirm);
                    this.hyX.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hyX.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hyX.aO(true);
                    this.hyX.b(getPageContext());
                }
                this.hyX.Au();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hze.setVisibility(4);
        if (view == this.eoY) {
            onBackPressed();
        } else if (view == this.hyU) {
            if (this.hxh.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hxp.bIF();
            bJa();
        } else if (view == this.hyV) {
            if (this.hxh.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hyV.setOnClickListener(null);
            this.hxp.bIH();
            if (this.hxp.bII() && this.hxp.bIG()) {
                this.hxp.bIF();
            }
            bJa();
            this.hyV.setOnClickListener(this);
        } else if (view == this.hyW) {
            bJc();
        }
    }

    private void bJa() {
        if (this.hxp.bII()) {
            this.hyU.setVisibility(8);
        } else {
            this.hyU.setVisibility(0);
        }
        if (this.hxp.bIG()) {
            this.hyU.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hyU.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bJb() {
        return this.hyY;
    }

    public void bJc() {
        this.hze.setVisibility(4);
        if (this.hxh.getStatus() != 6) {
            this.hxh.setStatus(6);
            bJh();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hzh == null) {
                this.hzh = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hzh.setDuration(500L);
                this.hzh.setRepeatCount(5);
                this.hzh.setRepeatMode(2);
                this.hzh.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hzh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hxh.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hyZ.setVisibility(0);
                        RecordVideoActivity.this.hyZ.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hyZ.setVisibility(8);
                    if (RecordVideoActivity.this.hxh.getStatus() == 6) {
                        RecordVideoActivity.this.hyS.bJu();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hxh.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hyZ.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hyZ.setText("");
                        }
                    }
                }
            });
            this.hyZ.setAnimation(this.hzh);
            this.hzh.startNow();
            this.hyS.bJc();
            if (this.hzq != null) {
                this.hzq.bIW();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJd() {
        if (this.hxh.getStatus() == 1) {
            this.hze.setVisibility(4);
            if (this.hxh.getStatus() != 6) {
                this.hyS.bJd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJe() {
        this.hze.setVisibility(4);
        if (this.hxh.getStatus() != 6) {
            this.hyS.bJe();
            if (this.hyS.bJy()) {
                bIY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJf() {
        this.hze.setVisibility(4);
        if (this.hxh.getStatus() != 6) {
            this.hyS.bJf();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJg() {
        this.hze.setVisibility(4);
        if (this.hxh.getStatus() != 6) {
            this.hyS.bJg();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJh() {
        this.hzm = true;
        if (this.hzg != null && this.hzg.isRunning()) {
            this.hzg.cancel();
        }
        if (this.hzf == null) {
            this.hzf = new AnimatorSet();
            this.hzf.playTogether(ObjectAnimator.ofFloat(this.hyT, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hza, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hzr, "alpha", 1.0f, 0.0f));
            this.hzf.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAT) {
                        RecordVideoActivity.this.hyT.setVisibility(8);
                        RecordVideoActivity.this.hza.setVisibility(8);
                        RecordVideoActivity.this.hzr.setVisibility(8);
                    }
                }
            });
            this.hzf.setDuration(300L);
        }
        this.hzf.start();
        this.hza.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIW() {
        if (this.dRd == 2) {
            if (this.hzm) {
                this.hzm = false;
                if (this.hzq != null) {
                    this.hzq.bIW();
                }
            } else {
                return;
            }
        }
        if (this.hzf != null && this.hzf.isRunning()) {
            this.hzf.cancel();
        }
        if (this.hzg == null) {
            this.hzg = new AnimatorSet();
            this.hzg.playTogether(ObjectAnimator.ofFloat(this.hyT, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hza, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hzr, "alpha", 0.0f, 1.0f));
            this.hzg.setDuration(300L);
        }
        this.hyT.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hza.setVisibility(0);
        }
        if (this.hxh.getStatus() == 1) {
            this.hzr.setVisibility(0);
        }
        this.hzg.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJi() {
        if (this.hxp != null) {
            this.hxp.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void u(boolean z, String str) {
                    RecordVideoActivity.this.hxh.setStatus(1);
                    RecordVideoActivity.this.bIW();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hzs != null && !v.J(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hzs)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hzs);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hzs = new ImageFileInfo();
                        RecordVideoActivity.this.hzs.setFilePath(str);
                        RecordVideoActivity.this.hzs.setTempFile(true);
                        RecordVideoActivity.this.hzs.setAlbumnId(null);
                        RecordVideoActivity.this.hzs.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hzs);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hzl, RecordVideoActivity.this.hzk)));
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
    public void bJj() {
        this.hzh.cancel();
        this.hzh.setAnimationListener(null);
        this.hyZ.clearAnimation();
        this.hyZ.setVisibility(8);
        if (this.hzq != null) {
            this.hzq.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJk() {
        bzq();
    }

    private void bzq() {
        if (this.hzi != null) {
            this.hzi.cancel();
        }
        if (this.hzj == null) {
            this.hzj = ObjectAnimator.ofFloat(this.hzr, "alpha", 1.0f, 0.0f);
            this.hzj.setDuration(500L);
            this.hzj.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAT) {
                        RecordVideoActivity.this.hzr.setVisibility(8);
                    }
                }
            });
        }
        this.hzj.start();
    }

    private void bzp() {
        if (this.hzj != null) {
            this.hzj.cancel();
        }
        if (this.hzi == null) {
            this.hzi = ObjectAnimator.ofFloat(this.hzr, "alpha", 0.0f, 1.0f);
            this.hzi.setDuration(500L);
        }
        this.hzr.setVisibility(0);
        this.hzi.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJl() {
        this.hza.reset();
        if (this.hxh.getStatus() == 1) {
            bzp();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJm() {
        if (this.hzc.getVisibility() != 0) {
            this.hyS.bJt();
            this.hxh.setStatus(8);
            bIW();
            if (this.hxp.hxX != null && this.hxp.hxX.size() > 0) {
                this.hzc.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hzw = 50;
        final int hzx = 1;
        Handler hzy = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hzd.aA(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bJq();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bJq() {
            this.hzy.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bJq();
            boolean z = RecordVideoActivity.this.hzq == null || TextUtils.isEmpty(RecordVideoActivity.this.hzq.bIV()) || !new File(RecordVideoActivity.this.hzq.bIV()).exists();
            if (RecordVideoActivity.this.hxp.hxX.size() > 1) {
                return com.baidu.tieba.video.meida.h.bIi().c(RecordVideoActivity.this.hxp.hxX, RecordVideoActivity.this.hxp.bIz(), z);
            }
            File file = new File(RecordVideoActivity.this.hxp.hxX.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hxp.bIz()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bIi().c(RecordVideoActivity.this.hxp.hxX, RecordVideoActivity.this.hxp.bIz(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hyS.bJz();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bIX();
                    RecordVideoActivity.this.vP(102);
                    RecordVideoActivity.this.hzc.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bIX();
                RecordVideoActivity.this.vP(102);
                RecordVideoActivity.this.hzc.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hzc.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ab(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hzd.aA(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hyS == null || v.J(this.hyS.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hyS.getChoosedBeautyList()) {
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
        if (this.hyS == null || v.J(this.hyS.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hyS.getChoosedFilterList()) {
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
        if (this.hyS == null || v.J(this.hyS.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hyS.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJn() {
        this.hze.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJo() {
        this.hze.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJp() {
        if (this.hxh.getStatus() == 1) {
            this.hzr.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hxp != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hxp.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").x(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hza.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hza.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hxp.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hxh.getStatus() == 1) {
                            amVar.x("obj_type", 1);
                        } else {
                            amVar.x("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hza.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hza.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hzq.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hza.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hza.setViewChoosed(0, true);
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
            this.hzp = stickerItem;
            this.hzo.wr(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hxp != null) {
                    this.hxp.setSticker(null);
                    this.hzu = false;
                }
                if (this.hyS != null) {
                    this.hyS.setDownLoadSticker(null);
                }
                this.hzb.setVisibility(8);
                this.hza.setViewChoosed(1, false);
                return;
            }
            String wo = this.hzo.wo(stickerItem.resource);
            if (!StringUtils.isNull(wo)) {
                a(stickerItem, wo);
                if (this.hyS != null) {
                    this.hyS.setDownLoadSticker(null);
                }
            } else {
                if (this.hyS != null) {
                    this.hyS.setDownLoadSticker(stickerItem);
                }
                this.hzo.wp(stickerItem.resource);
            }
            this.hza.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hxp != null) {
                this.hxp.setSticker(stickerItem);
                this.hzu = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hzb.setText(stickerItem.desc);
                this.hzb.setVisibility(0);
                this.hzb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hzb.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hzb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bW(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0175e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hyS.getLayoutParams();
            layoutParams.height = i4;
            this.hyS.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String vZ = com.baidu.tieba.video.editvideo.model.a.bHi().vZ(stringExtra);
                if (this.hzq != null && !TextUtils.isEmpty(vZ)) {
                    this.hzq.cN(vZ, stringExtra2);
                    this.hyS.bIn();
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
        if (this.hxh.getStatus() == 8) {
            this.hyS.bJs();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void nO(boolean z) {
        if (this.hxh != null && (this.hxh.getStatus() == 1 || this.hxh.getStatus() == 3 || this.hxh.getStatus() == 4)) {
            if (!z && this.hzu) {
                this.hyY.akF();
                return;
            } else {
                this.hyY.akG();
                return;
            }
        }
        this.hyY.akG();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dRd != i) {
            switch (i) {
                case 1:
                    if (this.hzq != null) {
                        this.hzq.Tu();
                    }
                    this.hxp.setFilter("nature");
                    this.hza.setViewChoosed(0, false);
                    this.hza.setViewChoosed(3, false);
                    this.hyS.vR(1);
                    this.hza.setViewVisibility(0, 8);
                    this.hza.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hza.setViewVisibility(0, 0);
                    this.hza.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dRd = i;
            this.hyS.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().x("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bIU() {
        if (this.hxh.getStatus() == 1 && !this.hyS.bJx()) {
            G(1, true);
            this.hzr.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bIT() {
        if (this.hxh.getStatus() == 1 && !this.hyS.bJx()) {
            G(2, true);
            this.hzr.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        if (this.hea != null) {
            this.hea.ac(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.hea != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hea.ab(i, str);
        }
    }
}
