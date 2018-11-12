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
    private int dSj;
    private final CustomMessageListener dTR;
    private ImageView eqs;
    private RecordLayout hAC;
    private VideoControllerLayout hAD;
    private RelativeLayout hAE;
    private ImageView hAF;
    private ImageView hAG;
    private ImageView hAH;
    private com.baidu.tbadk.core.dialog.a hAI;
    private PreviewViewContainer hAJ;
    private TextView hAK;
    private VideoEffectButtonLayout hAL;
    private TextView hAM;
    private View hAN;
    private RoundProgressBar hAO;
    private TextView hAP;
    private AnimatorSet hAQ;
    private AnimatorSet hAR;
    private ScaleAnimation hAS;
    private ObjectAnimator hAT;
    private ObjectAnimator hAU;
    private int hAV;
    private ForumWriteData hAW;
    private boolean hAX;
    private boolean hAY = true;
    private l hAZ;
    private StickerItem hBa;
    protected j hBb;
    private RecordTabLayout hBc;
    private ImageFileInfo hBd;
    private HttpMessageListener hBe;
    private boolean hBf;
    private com.baidu.tieba.j.h hfy;
    private String hub;
    private SelectMusicModel huf;
    private b.a hxw;
    private i hyQ;
    protected h hyY;
    private b hzK;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.hfy = lVar.baV();
        }
        if (this.hfy != null) {
            this.hfy.baz();
        }
        this.hxw = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void dV(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.I(list)) {
                    if (RecordVideoActivity.this.hAD != null) {
                        RecordVideoActivity.this.hAD.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.hAD != null) {
                    RecordVideoActivity.this.hAD.setHasLocalVideo(true);
                    RecordVideoActivity.this.hAY = false;
                }
            }
        };
        this.hBe = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.hAD != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.hAD.setStickerItems(list);
                    }
                }
            }
        };
        this.dTR = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void bIw() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.hyY.huh);
        videoInfo.setVideoDuration(this.hyQ.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.hyY.huh).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hAW.writeCallFrom, this.hAW == null ? "" : this.hAW.forumName, this.hAW == null ? "" : this.hAW.forumId, this.hub, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        if (this.hBb != null) {
            this.hBb.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.hfy != null) {
            this.hfy.baC();
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
        if (this.hyQ != null && this.hyQ.EN()) {
            this.hyQ.stopRecord();
        }
        if (this.huf != null) {
            this.huf.cancelLoadData();
        }
        if (this.hfy != null) {
            this.hfy.rz("record");
        }
        com.baidu.tbadk.core.util.l.x(new File(com.baidu.tieba.video.c.hsw));
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
        this.hAV = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.hAW = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.hub = getIntent().getStringExtra("video_title");
        initUI();
        this.huf = new SelectMusicModel(getPageContext(), this.hAD);
        this.huf.bGN();
        this.hBb = new j(this);
        this.hBb.b(this.huf);
        this.hyQ.a(this.hBb);
        registerListener(this.hBe);
        registerListener(this.dTR);
        bIx();
    }

    private void bIx() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", ErrDef.Feature.OVERFLOW);
        sendMessage(httpMessage);
    }

    private void bHp() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.hxw);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.hAC = (RecordLayout) findViewById(e.g.root_layout);
        this.hAC.setListener(this);
        this.hyQ = new i(this);
        this.hAD = (VideoControllerLayout) findViewById(e.g.record_controller_layout);
        this.hAD.setRecordController(this.hyQ);
        this.hAD.setRecordControlListener(this);
        this.hAD.setEffectChoosedListener(this);
        this.hAE = (RelativeLayout) findViewById(e.g.top_control_layout);
        this.eqs = (ImageView) findViewById(e.g.close_page);
        this.eqs.setOnClickListener(this);
        this.hAF = (ImageView) findViewById(e.g.flash_switch);
        this.hAF.setOnClickListener(this);
        this.hAG = (ImageView) findViewById(e.g.camera_switch);
        this.hAG.setOnClickListener(this);
        this.hAH = (ImageView) findViewById(e.g.count_down);
        this.hAH.setOnClickListener(this);
        this.hAJ = (PreviewViewContainer) findViewById(e.g.video_surface_container);
        this.hyY = new h(this);
        this.hyY.a(this);
        this.hyY.setFaceIdentifyStateListener(this);
        this.hyY.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void bIk() {
                if (RecordVideoActivity.this.hAD.bIW()) {
                    RecordVideoActivity.this.hAD.a((m) null);
                }
            }
        });
        this.hAL = (VideoEffectButtonLayout) findViewById(e.g.layout_effect_button);
        this.hAL.setListener(this);
        this.hyQ.a(this.hAL);
        this.hAL.setViewChoosed(2, true);
        this.hAK = (TextView) findViewById(e.g.tv_count_down);
        this.hAM = (TextView) findViewById(e.g.gesture_guide_tv);
        int aQ = ((com.baidu.adp.lib.util.l.aQ(this.mContext) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds336)) / 2) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds150);
        if (this.hAK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hAK.getLayoutParams()).topMargin = aQ;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.hAL.setVisibility(8);
        }
        this.hAN = findViewById(e.g.progress_layout);
        this.hAO = (RoundProgressBar) this.hAN.findViewById(e.g.video_progress);
        this.hAP = (TextView) findViewById(e.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hAP.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.aO(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds38);
        this.hAP.setLayoutParams(layoutParams);
        this.hBc = (RecordTabLayout) findViewById(e.g.tab_layout);
        this.hBc.ao(1, getString(e.j.tab_photo));
        if (this.hAV != 2 && this.hAV != 3) {
            this.hBc.ao(2, getString(e.j.tab_record));
            this.hBc.setListener(this);
            this.hBc.setCurrentTab(2, false);
            G(2, false);
        } else {
            this.hBc.setShowIndicator(false);
            this.hBc.setCurrentTab(1, false);
            G(1, false);
        }
        bIy();
    }

    private void bIy() {
        if (com.baidu.tbadk.core.util.g.BA()) {
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
        this.hyY.onResume();
        this.hzK = this.hyY.bIb();
        if (this.hzK != null) {
            this.hzK.setRecordController(this.hyQ);
            this.hAJ.setZoomHelper(this.hzK);
        }
        bIz();
        if (this.hAZ == null) {
            this.hAZ = new l();
            this.hAZ.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void cM(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.hBa, str2);
                    if (RecordVideoActivity.this.hAD != null) {
                        RecordVideoActivity.this.hAD.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void vW(String str) {
                    if (RecordVideoActivity.this.hAD != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.hAD.b(stickerItem);
                        if (RecordVideoActivity.this.hyY != null) {
                            RecordVideoActivity.this.hyY.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.hAD != null) {
                        RecordVideoActivity.this.hAD.setDownLoadSticker(null);
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
                public void bFV() {
                    if (RecordVideoActivity.this.hAD != null) {
                        RecordVideoActivity.this.hAD.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.hAZ.bIQ();
        if (this.hAD != null && this.hAY) {
            bHp();
        }
        if (this.hfy != null) {
            this.hfy.ry(ChooseVideoAction.KEY_SOURCE_ALBUM);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.hyY.onPause();
        if (this.hAD != null) {
            if (this.hyQ != null && this.hyQ.getStatus() == 6) {
                this.hAD.stopRecord();
                bII();
            }
            if (this.hyQ != null && this.hyQ.EN()) {
                this.hAD.stopRecord();
            }
        }
        if (this.hBb != null) {
            this.hBb.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.hyQ == null || this.hyQ.getStatus() != 7) {
            if (this.hyQ != null && this.hyQ.getStatus() == 6) {
                if (this.hAD != null) {
                    this.hAD.stopRecord();
                }
                bII();
            } else if (this.hyQ.onBackPressed()) {
                finish();
            } else {
                if (this.hAI == null) {
                    this.hAI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hAI.cN(e.j.video_quit_confirm);
                    this.hAI.a(e.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hAI.b(e.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hAI.be(true);
                    this.hAI.b(getPageContext());
                }
                this.hAI.AB();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.hAP.setVisibility(4);
        if (view == this.eqs) {
            onBackPressed();
        } else if (view == this.hAF) {
            if (this.hyQ.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.hyY.bIe();
            bIz();
        } else if (view == this.hAG) {
            if (this.hyQ.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.hAG.setOnClickListener(null);
            this.hyY.bIg();
            if (this.hyY.bIh() && this.hyY.bIf()) {
                this.hyY.bIe();
            }
            bIz();
            this.hAG.setOnClickListener(this);
        } else if (view == this.hAH) {
            bIB();
        }
    }

    private void bIz() {
        if (this.hyY.bIh()) {
            this.hAF.setVisibility(8);
        } else {
            this.hAF.setVisibility(0);
        }
        if (this.hyY.bIf()) {
            this.hAF.setImageResource(e.f.icon_video_flashon_n);
        } else {
            this.hAF.setImageResource(e.f.icon_video_flashoff_n);
        }
    }

    public FrameLayout bIA() {
        return this.hAJ;
    }

    public void bIB() {
        this.hAP.setVisibility(4);
        if (this.hyQ.getStatus() != 6) {
            this.hyQ.setStatus(6);
            bIG();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.hAS == null) {
                this.hAS = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.hAS.setDuration(500L);
                this.hAS.setRepeatCount(5);
                this.hAS.setRepeatMode(2);
                this.hAS.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.hAS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.hyQ.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.hAK.setVisibility(0);
                        RecordVideoActivity.this.hAK.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.hAK.setVisibility(8);
                    if (RecordVideoActivity.this.hyQ.getStatus() == 6) {
                        RecordVideoActivity.this.hAD.bIT();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.hyQ.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.hAK.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.hAK.setText("");
                        }
                    }
                }
            });
            this.hAK.setAnimation(this.hAS);
            this.hAS.startNow();
            this.hAD.bIB();
            if (this.hBb != null) {
                this.hBb.bIv();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIC() {
        if (this.hyQ.getStatus() == 1) {
            this.hAP.setVisibility(4);
            if (this.hyQ.getStatus() != 6) {
                this.hAD.bIC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bID() {
        this.hAP.setVisibility(4);
        if (this.hyQ.getStatus() != 6) {
            this.hAD.bID();
            if (this.hAD.bIX()) {
                bIx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIE() {
        this.hAP.setVisibility(4);
        if (this.hyQ.getStatus() != 6) {
            this.hAD.bIE();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bIF() {
        this.hAP.setVisibility(4);
        if (this.hyQ.getStatus() != 6) {
            this.hAD.bIF();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIG() {
        this.hAX = true;
        if (this.hAR != null && this.hAR.isRunning()) {
            this.hAR.cancel();
        }
        if (this.hAQ == null) {
            this.hAQ = new AnimatorSet();
            this.hAQ.playTogether(ObjectAnimator.ofFloat(this.hAE, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hAL, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.hBc, "alpha", 1.0f, 0.0f));
            this.hAQ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hCE) {
                        RecordVideoActivity.this.hAE.setVisibility(8);
                        RecordVideoActivity.this.hAL.setVisibility(8);
                        RecordVideoActivity.this.hBc.setVisibility(8);
                    }
                }
            });
            this.hAQ.setDuration(300L);
        }
        this.hAQ.start();
        this.hAL.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIv() {
        if (this.dSj == 2) {
            if (this.hAX) {
                this.hAX = false;
                if (this.hBb != null) {
                    this.hBb.bIv();
                }
            } else {
                return;
            }
        }
        if (this.hAQ != null && this.hAQ.isRunning()) {
            this.hAQ.cancel();
        }
        if (this.hAR == null) {
            this.hAR = new AnimatorSet();
            this.hAR.playTogether(ObjectAnimator.ofFloat(this.hAE, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hAL, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.hBc, "alpha", 0.0f, 1.0f));
            this.hAR.setDuration(300L);
        }
        this.hAE.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.hAL.setVisibility(0);
        }
        if (this.hyQ.getStatus() == 1) {
            this.hBc.setVisibility(0);
        }
        this.hAR.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIH() {
        if (this.hyY != null) {
            this.hyY.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void t(boolean z, String str) {
                    RecordVideoActivity.this.hyQ.setStatus(1);
                    RecordVideoActivity.this.bIv();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.hBd != null && !v.I(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.hBd)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.hBd);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.hBd = new ImageFileInfo();
                        RecordVideoActivity.this.hBd.setFilePath(str);
                        RecordVideoActivity.this.hBd.setTempFile(true);
                        RecordVideoActivity.this.hBd.setAlbumnId(null);
                        RecordVideoActivity.this.hBd.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.hBd);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hAW, RecordVideoActivity.this.hAV)));
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
    public void bII() {
        this.hAS.cancel();
        this.hAS.setAnimationListener(null);
        this.hAK.clearAnimation();
        this.hAK.setVisibility(8);
        if (this.hBb != null) {
            this.hBb.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIJ() {
        byM();
    }

    private void byM() {
        if (this.hAT != null) {
            this.hAT.cancel();
        }
        if (this.hAU == null) {
            this.hAU = ObjectAnimator.ofFloat(this.hBc, "alpha", 1.0f, 0.0f);
            this.hAU.setDuration(500L);
            this.hAU.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.hCE) {
                        RecordVideoActivity.this.hBc.setVisibility(8);
                    }
                }
            });
        }
        this.hAU.start();
    }

    private void byL() {
        if (this.hAU != null) {
            this.hAU.cancel();
        }
        if (this.hAT == null) {
            this.hAT = ObjectAnimator.ofFloat(this.hBc, "alpha", 0.0f, 1.0f);
            this.hAT.setDuration(500L);
        }
        this.hBc.setVisibility(0);
        this.hAT.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIK() {
        this.hAL.reset();
        if (this.hyQ.getStatus() == 1) {
            byL();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIL() {
        if (this.hAN.getVisibility() != 0) {
            this.hAD.bIS();
            this.hyQ.setStatus(8);
            bIv();
            if (this.hyY.hzI != null && this.hyY.hzI.size() > 0) {
                this.hAN.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int hBh = 50;
        final int hBi = 1;
        Handler hBj = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.hAO.aC(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bIP();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bIP() {
            this.hBj.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            bIP();
            boolean z = RecordVideoActivity.this.hBb == null || TextUtils.isEmpty(RecordVideoActivity.this.hBb.bIu()) || !new File(RecordVideoActivity.this.hBb.bIu()).exists();
            if (RecordVideoActivity.this.hyY.hzI.size() > 1) {
                return com.baidu.tieba.video.meida.h.bHH().c(RecordVideoActivity.this.hyY.hzI, RecordVideoActivity.this.hyY.bHY(), z);
            }
            File file = new File(RecordVideoActivity.this.hyY.hzI.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.b(file, new File(RecordVideoActivity.this.hyY.bHY()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.bHH().c(RecordVideoActivity.this.hyY.hzI, RecordVideoActivity.this.hyY.bHY(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.hAD.bIY();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.bIw();
                    RecordVideoActivity.this.wi(102);
                    RecordVideoActivity.this.hAN.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.bIw();
                RecordVideoActivity.this.wi(102);
                RecordVideoActivity.this.hAN.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(e.j.mix_fail));
                RecordVideoActivity.this.hAN.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.X(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.hAO.aC(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.hAD == null || v.I(this.hAD.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.hAD.getChoosedBeautyList()) {
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
        if (this.hAD == null || v.I(this.hAD.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.hAD.getChoosedFilterList()) {
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
        if (this.hAD == null || v.I(this.hAD.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.hAD.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIM() {
        this.hAP.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIN() {
        this.hAP.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bIO() {
        if (this.hyQ.getStatus() == 1) {
            this.hBc.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.hyY != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.hyY.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").x(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.hAL.setViewChoosed(2, false);
                            return;
                        } else {
                            this.hAL.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.hyY.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.ax(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.hyQ.getStatus() == 1) {
                            amVar.x("obj_type", 1);
                        } else {
                            amVar.x("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.hAL.setViewChoosed(3, false);
                            return;
                        } else {
                            this.hAL.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.hBb.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.hAL.setViewChoosed(0, false);
                            return;
                        } else {
                            this.hAL.setViewChoosed(0, true);
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
            this.hBa = stickerItem;
            this.hAZ.ww(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.hyY != null) {
                    this.hyY.setSticker(null);
                    this.hBf = false;
                }
                if (this.hAD != null) {
                    this.hAD.setDownLoadSticker(null);
                }
                this.hAM.setVisibility(8);
                this.hAL.setViewChoosed(1, false);
                return;
            }
            String wt = this.hAZ.wt(stickerItem.resource);
            if (!StringUtils.isNull(wt)) {
                a(stickerItem, wt);
                if (this.hAD != null) {
                    this.hAD.setDownLoadSticker(null);
                }
            } else {
                if (this.hAD != null) {
                    this.hAD.setDownLoadSticker(stickerItem);
                }
                this.hAZ.wu(stickerItem.resource);
            }
            this.hAL.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.hyY != null) {
                this.hyY.setSticker(stickerItem);
                this.hBf = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.hAM.setText(stickerItem.desc);
                this.hAM.setVisibility(0);
                this.hAM.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.hAM.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.hAM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void ca(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.C0200e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.hAD.getLayoutParams();
            layoutParams.height = i4;
            this.hAD.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String we = com.baidu.tieba.video.editvideo.model.a.bGH().we(stringExtra);
                if (this.hBb != null && !TextUtils.isEmpty(we)) {
                    this.hBb.cN(we, stringExtra2);
                    this.hAD.bHM();
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
        if (this.hyQ.getStatus() == 8) {
            this.hAD.bIR();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void oc(boolean z) {
        if (this.hyQ != null && (this.hyQ.getStatus() == 1 || this.hyQ.getStatus() == 3 || this.hyQ.getStatus() == 4)) {
            if (!z && this.hBf) {
                this.hAJ.ake();
                return;
            } else {
                this.hAJ.akf();
                return;
            }
        }
        this.hAJ.akf();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void G(int i, boolean z) {
        int i2 = 1;
        if (this.dSj != i) {
            switch (i) {
                case 1:
                    if (this.hBb != null) {
                        this.hBb.TD();
                    }
                    this.hyY.setFilter("origin");
                    this.hAL.setViewChoosed(0, false);
                    this.hAL.setViewChoosed(3, false);
                    this.hAD.wk(1);
                    this.hAL.setViewVisibility(0, 8);
                    this.hAL.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.hAL.setViewVisibility(0, 0);
                    this.hAL.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.dSj = i;
            this.hAD.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().x("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bIt() {
        if (this.hyQ.getStatus() == 1 && !this.hAD.bIW()) {
            G(1, true);
            this.hBc.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void bIs() {
        if (this.hyQ.getStatus() == 1 && !this.hAD.bIW()) {
            G(2, true);
            this.hBc.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(int i) {
        if (this.hfy != null) {
            this.hfy.Y(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, String str) {
        if (this.hfy != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.hfy.X(i, str);
        }
    }
}
