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
    private int dYL;
    private final CustomMessageListener eau;
    private ImageView exm;
    private String hBn;
    private SelectMusicModel hBr;
    private b.a hEI;
    private b hGW;
    private i hGc;
    protected h hGk;
    private RecordLayout hHO;
    private VideoControllerLayout hHP;
    private RelativeLayout hHQ;
    private ImageView hHR;
    private ImageView hHS;
    private ImageView hHT;
    private com.baidu.tbadk.core.dialog.a hHU;
    private PreviewViewContainer hHV;
    private TextView hHW;
    private VideoEffectButtonLayout hHX;
    private TextView hHY;
    private View hHZ;
    private RoundProgressBar hIa;
    private TextView hIb;
    private AnimatorSet hIc;
    private AnimatorSet hId;
    private ScaleAnimation hIe;
    private ObjectAnimator hIf;
    private ObjectAnimator hIg;
    private int hIh;
    private ForumWriteData hIi;
    private boolean hIj;
    private boolean hIk = true;
    private l hIl;
    private StickerItem hIm;
    protected j hIn;
    private RecordTabLayout hIo;
    private ImageFileInfo hIp;
    private HttpMessageListener hIq;
    private boolean hIr;
    private com.baidu.tieba.j.h hms;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hms = lVar.bcM();
        }
        if (this.hms != null) {
            this.hms.bcq();
        }
        this.hEI = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dZ(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.I(list)) {
                    if (RecordVideoActivity.this.hHP != null) {
                        RecordVideoActivity.this.hHP.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hHP != null) {
                    RecordVideoActivity.this.hHP.setHasLocalVideo(true);
                    RecordVideoActivity.this.hIk = false;
                }
            }
        };
        this.hIq = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hHP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hHP.setStickerItems(list);
                    }
                }
            }
        };
        this.eau = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bKB() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hGk.hBt);
        videoInfo.setVideoDuration(this.hGc.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hGk.hBt).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hIi.writeCallFrom, this.hIi == null ? "" : this.hIi.forumName, this.hIi == null ? "" : this.hIi.forumId, this.hBn, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hIn != null) {
            this.hIn.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.hms != null) {
            this.hms.bct();
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
        if (this.hGc != null && this.hGc.FR()) {
            this.hGc.stopRecord();
        }
        if (this.hBr != null) {
            this.hBr.cancelLoadData();
        }
        if (this.hms != null) {
            this.hms.sb("record");
        }
        com.baidu.tbadk.core.util.l.y(new File(com.baidu.tieba.video.c.hzI));
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
        this.hIh = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hIi = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hBn = getIntent().getStringExtra("video_title");
        initUI();
        this.hBr = new SelectMusicModel(getPageContext(), this.hHP);
        this.hBr.bIS();
        this.hIn = new j(this);
        this.hIn.b(this.hBr);
        this.hGc.a(this.hIn);
        registerListener(this.hIq);
        registerListener(this.eau);
        bKC();
    }

    private void bKC() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", ErrDef.Feature.OVERFLOW);
        sendMessage(httpMessage);
    }

    private void bJu() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hEI);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hHO = (RecordLayout) findViewById(e.g.root_layout);
        this.hHO.setListener(this);
        this.hGc = new i(this);
        this.hHP = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hHP.setRecordController(this.hGc);
        this.hHP.setRecordControlListener(this);
        this.hHP.setEffectChoosedListener(this);
        this.hHQ = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.exm = (ImageView) findViewById(e.g.close_page);
        this.exm.setOnClickListener(this);
        this.hHR = (ImageView) findViewById(e.g.flash_switch);
        this.hHR.setOnClickListener(this);
        this.hHS = (ImageView) findViewById(e.g.camera_switch);
        this.hHS.setOnClickListener(this);
        this.hHT = (ImageView) findViewById(e.g.count_down);
        this.hHT.setOnClickListener(this);
        this.hHV = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hGk = new h(this);
        this.hGk.a(this);
        this.hGk.setFaceIdentifyStateListener(this);
        this.hGk.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bKp() {
                if (RecordVideoActivity.this.hHP.bLb()) {
                    RecordVideoActivity.this.hHP.a((m) null);
                }
            }
        });
        this.hHX = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hHX.setListener(this);
        this.hGc.a(this.hHX);
        this.hHX.setViewChoosed(2, true);
        this.hHW = (TextView) findViewById(e.g.tv_count_down);
        this.hHY = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds150);
        if (this.hHW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hHW.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hHX.setVisibility(8);
        }
        this.hHZ = findViewById(e.g.progress_layout);
        this.hIa = (RoundProgressBar) this.hHZ.findViewById(e.g.video_progress);
        this.hIb = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hIb.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0210e.ds38);
        this.hIb.setLayoutParams(layoutParams);
        this.hIo = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hIo.ao(1, getString(e.j.tab_photo));
        if (this.hIh != 2 && this.hIh != 3) {
            this.hIo.ao(2, getString(e.j.tab_record));
            this.hIo.setListener(this);
            this.hIo.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hIo.setShowIndicator(false);
            this.hIo.setCurrentTab(1, false);
            G(1, false);
        }
        bKD();
    }

    private void bKD() {
        if (com.baidu.tbadk.core.util.g.CE()) {
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
        this.hGk.onResume();
        this.hGW = this.hGk.bKg();
        if (this.hGW != null) {
            this.hGW.setRecordController(this.hGc);
            this.hHV.setZoomHelper(this.hGW);
        }
        bKE();
        if (this.hIl == null) {
            this.hIl = new l();
            this.hIl.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cR(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hIm, str2);
                    if (RecordVideoActivity.this.hHP != null) {
                        RecordVideoActivity.this.hHP.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void wz(String str) {
                    if (RecordVideoActivity.this.hHP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hHP.b(stickerItem);
                        if (RecordVideoActivity.this.hGk != null) {
                            RecordVideoActivity.this.hGk.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hHP != null) {
                        RecordVideoActivity.this.hHP.setDownLoadSticker(null);
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
                    recordVideoActivity.X(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void bIa() {
                    if (RecordVideoActivity.this.hHP != null) {
                        RecordVideoActivity.this.hHP.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hIl.bKV();
        if (this.hHP != null && this.hIk) {
            bJu();
        }
        if (this.hms != null) {
            this.hms.sa(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hGk.onPause();
        if (this.hHP != null) {
            if (this.hGc != null && this.hGc.getStatus() == 6) {
                this.hHP.stopRecord();
                bKN();
            }
            if (this.hGc != null && this.hGc.FR()) {
                this.hHP.stopRecord();
            }
        }
        if (this.hIn != null) {
            this.hIn.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hGc == null || this.hGc.getStatus() != 7) {
            if (this.hGc != null && this.hGc.getStatus() == 6) {
                if (this.hHP != null) {
                    this.hHP.stopRecord();
                }
                bKN();
            } else if (this.hGc.onBackPressed()) {
                finish();
            } else {
                if (this.hHU == null) {
                    this.hHU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hHU.db(e.j.video_quit_confirm);
                    this.hHU.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hHU.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hHU.bf(true);
                    this.hHU.b(getPageContext());
                }
                this.hHU.BF();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hIb.setVisibility(4);
        if (view == this.exm) {
            onBackPressed();
        } else if (view == this.hHR) {
            if (this.hGc.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hGk.bKj();
            bKE();
        } else if (view == this.hHS) {
            if (this.hGc.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hHS.setOnClickListener(null);
            this.hGk.bKl();
            if (this.hGk.bKm() && this.hGk.bKk()) {
                this.hGk.bKj();
            }
            bKE();
            this.hHS.setOnClickListener(this);
        } else if (view == this.hHT) {
            bKG();
        }
    }

    private void bKE() {
        if (this.hGk.bKm()) {
            this.hHR.setVisibility(8);
        } else {
            this.hHR.setVisibility(0);
        }
        if (this.hGk.bKk()) {
            this.hHR.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hHR.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bKF() {
        return this.hHV;
    }

    public void bKG() {
        this.hIb.setVisibility(4);
        if (this.hGc.getStatus() != 6) {
            this.hGc.setStatus(6);
            bKL();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hIe == null) {
                this.hIe = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hIe.setDuration(500L);
                this.hIe.setRepeatCount(5);
                this.hIe.setRepeatMode(2);
                this.hIe.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hIe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hGc.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hHW.setVisibility(0);
                        RecordVideoActivity.this.hHW.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hHW.setVisibility(8);
                    if (RecordVideoActivity.this.hGc.getStatus() == 6) {
                        RecordVideoActivity.this.hHP.bKY();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hGc.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hHW.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hHW.setText("");
                        }
                    }
                }
            });
            this.hHW.setAnimation(this.hIe);
            this.hIe.startNow();
            this.hHP.bKG();
            if (this.hIn != null) {
                this.hIn.bKA();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKH() {
        if (this.hGc.getStatus() == 1) {
            this.hIb.setVisibility(4);
            if (this.hGc.getStatus() != 6) {
                this.hHP.bKH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKI() {
        this.hIb.setVisibility(4);
        if (this.hGc.getStatus() != 6) {
            this.hHP.bKI();
            if (this.hHP.bLc()) {
                bKC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKJ() {
        this.hIb.setVisibility(4);
        if (this.hGc.getStatus() != 6) {
            this.hHP.bKJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bKK() {
        this.hIb.setVisibility(4);
        if (this.hGc.getStatus() != 6) {
            this.hHP.bKK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKL() {
        this.hIj = true;
        if (this.hId != null && this.hId.isRunning()) {
            this.hId.cancel();
        }
        if (this.hIc == null) {
            this.hIc = new AnimatorSet();
            this.hIc.playTogether(ObjectAnimator.ofFloat(this.hHQ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hHX, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hIo, "alpha", 1.0f, 0.0f));
            this.hIc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hJQ) {
                        RecordVideoActivity.this.hHQ.setVisibility(8);
                        RecordVideoActivity.this.hHX.setVisibility(8);
                        RecordVideoActivity.this.hIo.setVisibility(8);
                    }
                }
            });
            this.hIc.setDuration(300L);
        }
        this.hIc.start();
        this.hHX.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKA() {
        if (this.dYL == 2) {
            if (this.hIj) {
                this.hIj = false;
                if (this.hIn != null) {
                    this.hIn.bKA();
                }
            } else {
                return;
            }
        }
        if (this.hIc != null && this.hIc.isRunning()) {
            this.hIc.cancel();
        }
        if (this.hId == null) {
            this.hId = new AnimatorSet();
            this.hId.playTogether(ObjectAnimator.ofFloat(this.hHQ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hHX, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hIo, "alpha", 0.0f, 1.0f));
            this.hId.setDuration(300L);
        }
        this.hHQ.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hHX.setVisibility(0);
        }
        if (this.hGc.getStatus() == 1) {
            this.hIo.setVisibility(0);
        }
        this.hId.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKM() {
        if (this.hGk != null) {
            this.hGk.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void t(boolean z, String str) {
                    RecordVideoActivity.this.hGc.setStatus(1);
                    RecordVideoActivity.this.bKA();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hIp != null && !v.I(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hIp)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hIp);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hIp = new ImageFileInfo();
                        RecordVideoActivity.this.hIp.setFilePath(str);
                        RecordVideoActivity.this.hIp.setTempFile(true);
                        RecordVideoActivity.this.hIp.setAlbumnId(null);
                        RecordVideoActivity.this.hIp.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hIp);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hIi, RecordVideoActivity.this.hIh)));
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
    public void bKN() {
        this.hIe.cancel();
        this.hIe.setAnimationListener(null);
        this.hHW.clearAnimation();
        this.hHW.setVisibility(8);
        if (this.hIn != null) {
            this.hIn.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKO() {
        bAG();
    }

    private void bAG() {
        if (this.hIf != null) {
            this.hIf.cancel();
        }
        if (this.hIg == null) {
            this.hIg = ObjectAnimator.ofFloat(this.hIo, "alpha", 1.0f, 0.0f);
            this.hIg.setDuration(500L);
            this.hIg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hJQ) {
                        RecordVideoActivity.this.hIo.setVisibility(8);
                    }
                }
            });
        }
        this.hIg.start();
    }

    private void bAF() {
        if (this.hIg != null) {
            this.hIg.cancel();
        }
        if (this.hIf == null) {
            this.hIf = ObjectAnimator.ofFloat(this.hIo, "alpha", 0.0f, 1.0f);
            this.hIf.setDuration(500L);
        }
        this.hIo.setVisibility(0);
        this.hIf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKP() {
        this.hHX.reset();
        if (this.hGc.getStatus() == 1) {
            bAF();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKQ() {
        if (this.hHZ.getVisibility() != 0) {
            this.hHP.bKX();
            this.hGc.setStatus(8);
            bKA();
            if (this.hGk.hGU != null && this.hGk.hGU.size() > 0) {
                this.hHZ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hIt = 50;
        final int hIu = 1;
        Handler hIv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hIa.aC(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bKU();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bKU() {
            this.hIv.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bKU();
            boolean z = RecordVideoActivity.this.hIn == null || TextUtils.isEmpty(RecordVideoActivity.this.hIn.bKz()) || !new File(RecordVideoActivity.this.hIn.bKz()).exists();
            if (RecordVideoActivity.this.hGk.hGU.size() > 1) {
                return com.baidu.tieba.video.meida.h.bJM().c(RecordVideoActivity.this.hGk.hGU, RecordVideoActivity.this.hGk.bKd(), z);
            }
            File file = new File(RecordVideoActivity.this.hGk.hGU.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hGk.bKd()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bJM().c(RecordVideoActivity.this.hGk.hGU, RecordVideoActivity.this.hGk.bKd(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hHP.bLd();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bKB();
                    RecordVideoActivity.this.wF(102);
                    RecordVideoActivity.this.hHZ.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bKB();
                RecordVideoActivity.this.wF(102);
                RecordVideoActivity.this.hHZ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hHZ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.X(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hIa.aC(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hHP == null || v.I(this.hHP.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hHP.getChoosedBeautyList()) {
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
        if (this.hHP == null || v.I(this.hHP.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hHP.getChoosedFilterList()) {
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
        if (this.hHP == null || v.I(this.hHP.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hHP.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKR() {
        this.hIb.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKS() {
        this.hIb.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bKT() {
        if (this.hGc.getStatus() == 1) {
            this.hIo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hGk != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hGk.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").x(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hHX.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hHX.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hGk.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.aA(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hGc.getStatus() == 1) {
                            amVar.x("obj_type", 1);
                        } else {
                            amVar.x("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.hHX.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hHX.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hIn.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hHX.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hHX.setViewChoosed(0, true);
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
            this.hIm = stickerItem;
            this.hIl.wZ(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hGk != null) {
                    this.hGk.setSticker(null);
                    this.hIr = false;
                }
                if (this.hHP != null) {
                    this.hHP.setDownLoadSticker(null);
                }
                this.hHY.setVisibility(8);
                this.hHX.setViewChoosed(1, false);
                return;
            }
            String wW = this.hIl.wW(stickerItem.resource);
            if (!StringUtils.isNull(wW)) {
                a(stickerItem, wW);
                if (this.hHP != null) {
                    this.hHP.setDownLoadSticker(null);
                }
            } else {
                if (this.hHP != null) {
                    this.hHP.setDownLoadSticker(stickerItem);
                }
                this.hIl.wX(stickerItem.resource);
            }
            this.hHX.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hGk != null) {
                this.hGk.setSticker(stickerItem);
                this.hIr = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hHY.setText(stickerItem.desc);
                this.hHY.setVisibility(0);
                this.hHY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hHY.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hHY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bY(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0210e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hHP.getLayoutParams();
            layoutParams.height = i4;
            this.hHP.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String wH = com.baidu.tieba.video.editvideo.model.a.bIM().wH(stringExtra);
                if (this.hIn != null && !TextUtils.isEmpty(wH)) {
                    this.hIn.cS(wH, stringExtra2);
                    this.hHP.bJR();
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
        if (this.hGc.getStatus() == 8) {
            this.hHP.bKW();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void oe(boolean z) {
        if (this.hGc != null && (this.hGc.getStatus() == 1 || this.hGc.getStatus() == 3 || this.hGc.getStatus() == 4)) {
            if (!z && this.hIr) {
                this.hHV.alm();
                return;
            } else {
                this.hHV.aln();
                return;
            }
        }
        this.hHV.aln();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dYL != i) {
            switch (i) {
                case 1:
                    if (this.hIn != null) {
                        this.hIn.UJ();
                    }
                    this.hGk.setFilter("origin");
                    this.hHX.setViewChoosed(0, false);
                    this.hHX.setViewChoosed(3, false);
                    this.hHP.wH(1);
                    this.hHX.setViewVisibility(0, 8);
                    this.hHX.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hHX.setViewVisibility(0, 0);
                    this.hHX.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dYL = i;
            this.hHP.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().x("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bKy() {
        if (this.hGc.getStatus() == 1 && !this.hHP.bLb()) {
            G(1, true);
            this.hIo.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bKx() {
        if (this.hGc.getStatus() == 1 && !this.hHP.bLb()) {
            G(2, true);
            this.hIo.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(int i) {
        if (this.hms != null) {
            this.hms.Y(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        if (this.hms != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hms.X(i, str);
        }
    }
}
