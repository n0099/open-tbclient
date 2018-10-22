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
    private int dRe;
    private final CustomMessageListener dSL;
    private ImageView eoZ;
    private com.baidu.tieba.j.h heb;
    private String hss;
    private SelectMusicModel hsw;
    private b.a hvN;
    private i hxi;
    protected h hxq;
    private RecordLayout hyS;
    private VideoControllerLayout hyT;
    private RelativeLayout hyU;
    private ImageView hyV;
    private ImageView hyW;
    private ImageView hyX;
    private com.baidu.tbadk.core.dialog.a hyY;
    private PreviewViewContainer hyZ;
    private b hya;
    private TextView hza;
    private VideoEffectButtonLayout hzb;
    private TextView hzc;
    private View hzd;
    private RoundProgressBar hze;
    private TextView hzf;
    private AnimatorSet hzg;
    private AnimatorSet hzh;
    private ScaleAnimation hzi;
    private ObjectAnimator hzj;
    private ObjectAnimator hzk;
    private int hzl;
    private ForumWriteData hzm;
    private boolean hzn;
    private boolean hzo = true;
    private l hzp;
    private StickerItem hzq;
    protected j hzr;
    private RecordTabLayout hzs;
    private ImageFileInfo hzt;
    private HttpMessageListener hzu;
    private boolean hzv;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.heb = lVar.bbw();
        }
        if (this.heb != null) {
            this.heb.bbc();
        }
        this.hvN = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dX(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.J(list)) {
                    if (RecordVideoActivity.this.hyT != null) {
                        RecordVideoActivity.this.hyT.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hyT != null) {
                    RecordVideoActivity.this.hyT.setHasLocalVideo(true);
                    RecordVideoActivity.this.hzo = false;
                }
            }
        };
        this.hzu = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hyT != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hyT.setStickerItems(list);
                    }
                }
            }
        };
        this.dSL = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
        videoInfo.setVideoPath(this.hxq.hsy);
        videoInfo.setVideoDuration(this.hxi.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hxq.hsy).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hzm.writeCallFrom, this.hzm == null ? "" : this.hzm.forumName, this.hzm == null ? "" : this.hzm.forumId, this.hss, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hzr != null) {
            this.hzr.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.heb != null) {
            this.heb.bbf();
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
        if (this.hxi != null && this.hxi.isRecording()) {
            this.hxi.stopRecord();
        }
        if (this.hsw != null) {
            this.hsw.cancelLoadData();
        }
        if (this.heb != null) {
            this.heb.ry("record");
        }
        com.baidu.tbadk.core.util.l.x(new File(com.baidu.tieba.video.c.hqN));
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
        this.hzl = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hzm = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hss = getIntent().getStringExtra("video_title");
        initUI();
        this.hsw = new SelectMusicModel(getPageContext(), this.hyT);
        this.hsw.bHo();
        this.hzr = new j(this);
        this.hzr.b(this.hsw);
        this.hxi.a(this.hzr);
        registerListener(this.hzu);
        registerListener(this.dSL);
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
        bVar.b(this.hvN);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hyS = (RecordLayout) findViewById(e.g.root_layout);
        this.hyS.setListener(this);
        this.hxi = new i(this);
        this.hyT = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hyT.setRecordController(this.hxi);
        this.hyT.setRecordControlListener(this);
        this.hyT.setEffectChoosedListener(this);
        this.hyU = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.eoZ = (ImageView) findViewById(e.g.close_page);
        this.eoZ.setOnClickListener(this);
        this.hyV = (ImageView) findViewById(e.g.flash_switch);
        this.hyV.setOnClickListener(this);
        this.hyW = (ImageView) findViewById(e.g.camera_switch);
        this.hyW.setOnClickListener(this);
        this.hyX = (ImageView) findViewById(e.g.count_down);
        this.hyX.setOnClickListener(this);
        this.hyZ = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hxq = new h(this);
        this.hxq.a(this);
        this.hxq.setFaceIdentifyStateListener(this);
        this.hxq.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bIL() {
                if (RecordVideoActivity.this.hyT.bJx()) {
                    RecordVideoActivity.this.hyT.a((m) null);
                }
            }
        });
        this.hzb = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hzb.setListener(this);
        this.hxi.a(this.hzb);
        this.hzb.setViewChoosed(2, true);
        this.hza = (TextView) findViewById(e.g.tv_count_down);
        this.hzc = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds150);
        if (this.hza.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hza.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hzb.setVisibility(8);
        }
        this.hzd = findViewById(e.g.progress_layout);
        this.hze = (RoundProgressBar) this.hzd.findViewById(e.g.video_progress);
        this.hzf = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hzf.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds38);
        this.hzf.setLayoutParams(layoutParams);
        this.hzs = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hzs.as(1, getString(e.j.tab_photo));
        if (this.hzl != 2 && this.hzl != 3) {
            this.hzs.as(2, getString(e.j.tab_record));
            this.hzs.setListener(this);
            this.hzs.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hzs.setShowIndicator(false);
            this.hzs.setCurrentTab(1, false);
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
        this.hxq.onResume();
        this.hya = this.hxq.bIC();
        if (this.hya != null) {
            this.hya.setRecordController(this.hxi);
            this.hyZ.setZoomHelper(this.hya);
        }
        bJa();
        if (this.hzp == null) {
            this.hzp = new l();
            this.hzp.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cM(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hzq, str2);
                    if (RecordVideoActivity.this.hyT != null) {
                        RecordVideoActivity.this.hyT.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void vR(String str) {
                    if (RecordVideoActivity.this.hyT != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hyT.b(stickerItem);
                        if (RecordVideoActivity.this.hxq != null) {
                            RecordVideoActivity.this.hxq.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hyT != null) {
                        RecordVideoActivity.this.hyT.setDownLoadSticker(null);
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
                    if (RecordVideoActivity.this.hyT != null) {
                        RecordVideoActivity.this.hyT.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hzp.bJr();
        if (this.hyT != null && this.hzo) {
            bHQ();
        }
        if (this.heb != null) {
            this.heb.rx(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hxq.onPause();
        if (this.hyT != null) {
            if (this.hxi != null && this.hxi.getStatus() == 6) {
                this.hyT.stopRecord();
                bJj();
            }
            if (this.hxi != null && this.hxi.isRecording()) {
                this.hyT.stopRecord();
            }
        }
        if (this.hzr != null) {
            this.hzr.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hxi == null || this.hxi.getStatus() != 7) {
            if (this.hxi != null && this.hxi.getStatus() == 6) {
                if (this.hyT != null) {
                    this.hyT.stopRecord();
                }
                bJj();
            } else if (this.hxi.onBackPressed()) {
                finish();
            } else {
                if (this.hyY == null) {
                    this.hyY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hyY.cz(e.j.video_quit_confirm);
                    this.hyY.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hyY.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hyY.aO(true);
                    this.hyY.b(getPageContext());
                }
                this.hyY.Au();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hzf.setVisibility(4);
        if (view == this.eoZ) {
            onBackPressed();
        } else if (view == this.hyV) {
            if (this.hxi.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hxq.bIF();
            bJa();
        } else if (view == this.hyW) {
            if (this.hxi.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hyW.setOnClickListener(null);
            this.hxq.bIH();
            if (this.hxq.bII() && this.hxq.bIG()) {
                this.hxq.bIF();
            }
            bJa();
            this.hyW.setOnClickListener(this);
        } else if (view == this.hyX) {
            bJc();
        }
    }

    private void bJa() {
        if (this.hxq.bII()) {
            this.hyV.setVisibility(8);
        } else {
            this.hyV.setVisibility(0);
        }
        if (this.hxq.bIG()) {
            this.hyV.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hyV.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bJb() {
        return this.hyZ;
    }

    public void bJc() {
        this.hzf.setVisibility(4);
        if (this.hxi.getStatus() != 6) {
            this.hxi.setStatus(6);
            bJh();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hzi == null) {
                this.hzi = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hzi.setDuration(500L);
                this.hzi.setRepeatCount(5);
                this.hzi.setRepeatMode(2);
                this.hzi.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hzi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hxi.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hza.setVisibility(0);
                        RecordVideoActivity.this.hza.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hza.setVisibility(8);
                    if (RecordVideoActivity.this.hxi.getStatus() == 6) {
                        RecordVideoActivity.this.hyT.bJu();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hxi.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hza.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hza.setText("");
                        }
                    }
                }
            });
            this.hza.setAnimation(this.hzi);
            this.hzi.startNow();
            this.hyT.bJc();
            if (this.hzr != null) {
                this.hzr.bIW();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJd() {
        if (this.hxi.getStatus() == 1) {
            this.hzf.setVisibility(4);
            if (this.hxi.getStatus() != 6) {
                this.hyT.bJd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJe() {
        this.hzf.setVisibility(4);
        if (this.hxi.getStatus() != 6) {
            this.hyT.bJe();
            if (this.hyT.bJy()) {
                bIY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJf() {
        this.hzf.setVisibility(4);
        if (this.hxi.getStatus() != 6) {
            this.hyT.bJf();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bJg() {
        this.hzf.setVisibility(4);
        if (this.hxi.getStatus() != 6) {
            this.hyT.bJg();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJh() {
        this.hzn = true;
        if (this.hzh != null && this.hzh.isRunning()) {
            this.hzh.cancel();
        }
        if (this.hzg == null) {
            this.hzg = new AnimatorSet();
            this.hzg.playTogether(ObjectAnimator.ofFloat(this.hyU, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hzb, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hzs, "alpha", 1.0f, 0.0f));
            this.hzg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAU) {
                        RecordVideoActivity.this.hyU.setVisibility(8);
                        RecordVideoActivity.this.hzb.setVisibility(8);
                        RecordVideoActivity.this.hzs.setVisibility(8);
                    }
                }
            });
            this.hzg.setDuration(300L);
        }
        this.hzg.start();
        this.hzb.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIW() {
        if (this.dRe == 2) {
            if (this.hzn) {
                this.hzn = false;
                if (this.hzr != null) {
                    this.hzr.bIW();
                }
            } else {
                return;
            }
        }
        if (this.hzg != null && this.hzg.isRunning()) {
            this.hzg.cancel();
        }
        if (this.hzh == null) {
            this.hzh = new AnimatorSet();
            this.hzh.playTogether(ObjectAnimator.ofFloat(this.hyU, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hzb, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hzs, "alpha", 0.0f, 1.0f));
            this.hzh.setDuration(300L);
        }
        this.hyU.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hzb.setVisibility(0);
        }
        if (this.hxi.getStatus() == 1) {
            this.hzs.setVisibility(0);
        }
        this.hzh.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJi() {
        if (this.hxq != null) {
            this.hxq.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void u(boolean z, String str) {
                    RecordVideoActivity.this.hxi.setStatus(1);
                    RecordVideoActivity.this.bIW();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hzt != null && !v.J(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hzt)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hzt);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hzt = new ImageFileInfo();
                        RecordVideoActivity.this.hzt.setFilePath(str);
                        RecordVideoActivity.this.hzt.setTempFile(true);
                        RecordVideoActivity.this.hzt.setAlbumnId(null);
                        RecordVideoActivity.this.hzt.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hzt);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hzm, RecordVideoActivity.this.hzl)));
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
        this.hzi.cancel();
        this.hzi.setAnimationListener(null);
        this.hza.clearAnimation();
        this.hza.setVisibility(8);
        if (this.hzr != null) {
            this.hzr.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJk() {
        bzq();
    }

    private void bzq() {
        if (this.hzj != null) {
            this.hzj.cancel();
        }
        if (this.hzk == null) {
            this.hzk = ObjectAnimator.ofFloat(this.hzs, "alpha", 1.0f, 0.0f);
            this.hzk.setDuration(500L);
            this.hzk.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hAU) {
                        RecordVideoActivity.this.hzs.setVisibility(8);
                    }
                }
            });
        }
        this.hzk.start();
    }

    private void bzp() {
        if (this.hzk != null) {
            this.hzk.cancel();
        }
        if (this.hzj == null) {
            this.hzj = ObjectAnimator.ofFloat(this.hzs, "alpha", 0.0f, 1.0f);
            this.hzj.setDuration(500L);
        }
        this.hzs.setVisibility(0);
        this.hzj.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJl() {
        this.hzb.reset();
        if (this.hxi.getStatus() == 1) {
            bzp();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJm() {
        if (this.hzd.getVisibility() != 0) {
            this.hyT.bJt();
            this.hxi.setStatus(8);
            bIW();
            if (this.hxq.hxY != null && this.hxq.hxY.size() > 0) {
                this.hzd.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hzx = 50;
        final int hzy = 1;
        Handler hzz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hze.aA(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bJq();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bJq() {
            this.hzz.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bJq();
            boolean z = RecordVideoActivity.this.hzr == null || TextUtils.isEmpty(RecordVideoActivity.this.hzr.bIV()) || !new File(RecordVideoActivity.this.hzr.bIV()).exists();
            if (RecordVideoActivity.this.hxq.hxY.size() > 1) {
                return com.baidu.tieba.video.meida.h.bIi().c(RecordVideoActivity.this.hxq.hxY, RecordVideoActivity.this.hxq.bIz(), z);
            }
            File file = new File(RecordVideoActivity.this.hxq.hxY.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hxq.bIz()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bIi().c(RecordVideoActivity.this.hxq.hxY, RecordVideoActivity.this.hxq.bIz(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hyT.bJz();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bIX();
                    RecordVideoActivity.this.vP(102);
                    RecordVideoActivity.this.hzd.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bIX();
                RecordVideoActivity.this.vP(102);
                RecordVideoActivity.this.hzd.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hzd.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.ab(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hze.aA(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hyT == null || v.J(this.hyT.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hyT.getChoosedBeautyList()) {
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
        if (this.hyT == null || v.J(this.hyT.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hyT.getChoosedFilterList()) {
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
        if (this.hyT == null || v.J(this.hyT.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hyT.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJn() {
        this.hzf.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJo() {
        this.hzf.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bJp() {
        if (this.hxi.getStatus() == 1) {
            this.hzs.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hxq != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hxq.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").x(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hzb.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hzb.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hxq.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hxi.getStatus() == 1) {
                            amVar.x("obj_type", 1);
                        } else {
                            amVar.x("obj_type", 2);
                        }
                        if (eVar.getValue().equals("nature")) {
                            this.hzb.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hzb.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hzr.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hzb.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hzb.setViewChoosed(0, true);
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
            this.hzq = stickerItem;
            this.hzp.wr(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hxq != null) {
                    this.hxq.setSticker(null);
                    this.hzv = false;
                }
                if (this.hyT != null) {
                    this.hyT.setDownLoadSticker(null);
                }
                this.hzc.setVisibility(8);
                this.hzb.setViewChoosed(1, false);
                return;
            }
            String wo = this.hzp.wo(stickerItem.resource);
            if (!StringUtils.isNull(wo)) {
                a(stickerItem, wo);
                if (this.hyT != null) {
                    this.hyT.setDownLoadSticker(null);
                }
            } else {
                if (this.hyT != null) {
                    this.hyT.setDownLoadSticker(stickerItem);
                }
                this.hzp.wp(stickerItem.resource);
            }
            this.hzb.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hxq != null) {
                this.hxq.setSticker(stickerItem);
                this.hzv = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hzc.setText(stickerItem.desc);
                this.hzc.setVisibility(0);
                this.hzc.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hzc.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hzc.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void bW(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0175e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hyT.getLayoutParams();
            layoutParams.height = i4;
            this.hyT.setLayoutParams(layoutParams);
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
                if (this.hzr != null && !TextUtils.isEmpty(vZ)) {
                    this.hzr.cN(vZ, stringExtra2);
                    this.hyT.bIn();
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
        if (this.hxi.getStatus() == 8) {
            this.hyT.bJs();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void nO(boolean z) {
        if (this.hxi != null && (this.hxi.getStatus() == 1 || this.hxi.getStatus() == 3 || this.hxi.getStatus() == 4)) {
            if (!z && this.hzv) {
                this.hyZ.akG();
                return;
            } else {
                this.hyZ.akH();
                return;
            }
        }
        this.hyZ.akH();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dRe != i) {
            switch (i) {
                case 1:
                    if (this.hzr != null) {
                        this.hzr.Tu();
                    }
                    this.hxq.setFilter("nature");
                    this.hzb.setViewChoosed(0, false);
                    this.hzb.setViewChoosed(3, false);
                    this.hyT.vR(1);
                    this.hzb.setViewVisibility(0, 8);
                    this.hzb.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hzb.setViewVisibility(0, 0);
                    this.hzb.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dRe = i;
            this.hyT.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().x("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bIU() {
        if (this.hxi.getStatus() == 1 && !this.hyT.bJx()) {
            G(1, true);
            this.hzs.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bIT() {
        if (this.hxi.getStatus() == 1 && !this.hyT.bJx()) {
            G(2, true);
            this.hzs.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        if (this.heb != null) {
            this.heb.ac(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, String str) {
        if (this.heb != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.heb.ab(i, str);
        }
    }
}
