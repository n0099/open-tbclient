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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View aGw;
    private ImageView fkG;
    private final CustomMessageListener gIA;
    private b.a kBo;
    private i kCF;
    protected h kCN;
    private b kDu;
    private ObjectAnimator kEA;
    private int kEB;
    private ForumWriteData kEC;
    private boolean kED;
    private boolean kEE = true;
    private l kEF;
    private StickerItem kEG;
    protected j kEH;
    private RecordTabLayout kEI;
    private ImageFileInfo kEJ;
    private HttpMessageListener kEK;
    private boolean kEL;
    private RecordLayout kEj;
    private VideoControllerLayout kEk;
    private RelativeLayout kEl;
    private ImageView kEm;
    private ImageView kEn;
    private ImageView kEo;
    private com.baidu.tbadk.core.dialog.a kEp;
    private PreviewViewContainer kEq;
    private TextView kEr;
    private VideoEffectButtonLayout kEs;
    private TextView kEt;
    private RoundProgressBar kEu;
    private TextView kEv;
    private AnimatorSet kEw;
    private AnimatorSet kEx;
    private ScaleAnimation kEy;
    private ObjectAnimator kEz;
    private com.baidu.tieba.k.h kjC;
    private String kyd;
    private SelectMusicModel kyh;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.kjC = lVar.cht();
        }
        if (this.kjC != null) {
            this.kjC.cgV();
        }
        this.kBo = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eq(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kEk != null) {
                        RecordVideoActivity.this.kEk.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kEk != null) {
                    RecordVideoActivity.this.kEk.setHasLocalVideo(true);
                    RecordVideoActivity.this.kEE = false;
                }
            }
        };
        this.kEK = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kEk != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kEk.setStickerItems(list);
                    }
                }
            }
        };
        this.gIA = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    RecordVideoActivity.this.setResult(-1, intent);
                    RecordVideoActivity.this.finish();
                }
            }
        };
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003368, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSb() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kCN.kyi);
        videoInfo.setVideoDuration(this.kCF.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kCN.kyi).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kEC == null ? "" : this.kEC.forumName;
        String str2 = this.kEC == null ? "" : this.kEC.forumId;
        int i = this.kEC == null ? -1 : this.kEC.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kEC.writeCallFrom, str, str2, this.kyd, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.kEC != null ? this.kEC.frsTabInfo : null);
        if (this.kEH != null) {
            this.kEH.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.kjC != null) {
            this.kjC.cgY();
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
        if (this.kCF != null && this.kCF.isRecording()) {
            this.kCF.stopRecord();
        }
        if (this.kyh != null) {
            this.kyh.cancelLoadData();
        }
        if (this.kjC != null) {
            this.kjC.Fc("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kwD));
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
        this.kEB = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kEC = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.kyd = getIntent().getStringExtra("video_title");
        initUI();
        this.kyh = new SelectMusicModel(getPageContext(), this.kEk);
        this.kyh.cQz();
        this.kEH = new j(this);
        this.kEH.b(this.kyh);
        this.kCF.a(this.kEH);
        registerListener(this.kEK);
        registerListener(this.gIA);
        cSc();
    }

    private void cSc() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cQZ() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kBo);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kEj = (RecordLayout) findViewById(R.id.root_layout);
        this.kEj.setListener(this);
        this.kCF = new i(this);
        this.kEk = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kEk.setRecordController(this.kCF);
        this.kEk.setRecordControlListener(this);
        this.kEk.setEffectChoosedListener(this);
        this.kEl = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fkG = (ImageView) findViewById(R.id.close_page);
        this.fkG.setOnClickListener(this);
        this.kEm = (ImageView) findViewById(R.id.flash_switch);
        this.kEm.setOnClickListener(this);
        this.kEn = (ImageView) findViewById(R.id.camera_switch);
        this.kEn.setOnClickListener(this);
        this.kEo = (ImageView) findViewById(R.id.count_down);
        this.kEo.setOnClickListener(this);
        this.kEq = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kCN = new h(this);
        this.kCN.a(this);
        this.kCN.setFaceIdentifyStateListener(this);
        this.kCN.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cRQ() {
                if (RecordVideoActivity.this.kEk.cSB()) {
                    RecordVideoActivity.this.kEk.a((m) null);
                }
            }
        });
        this.kEs = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kEs.setListener(this);
        this.kCF.a(this.kEs);
        this.kEs.setViewChoosed(2, true);
        this.kEr = (TextView) findViewById(R.id.tv_count_down);
        this.kEt = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kEr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kEr.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kEs.setVisibility(8);
        }
        this.aGw = findViewById(R.id.progress_layout);
        this.kEu = (RoundProgressBar) this.aGw.findViewById(R.id.video_progress);
        this.kEv = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kEv.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kEv.setLayoutParams(layoutParams);
        this.kEI = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kEI.bf(1, getString(R.string.tab_photo));
        if (this.kEB != 2 && this.kEB != 3) {
            this.kEI.bf(2, getString(R.string.tab_record));
            this.kEI.setListener(this);
            this.kEI.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kEI.setShowIndicator(false);
            this.kEI.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cSd();
    }

    private void cSd() {
        if (com.baidu.tbadk.core.util.g.aFQ()) {
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
        this.kCN.onResume();
        this.kDu = this.kCN.cRI();
        if (this.kDu != null) {
            this.kDu.setRecordController(this.kCF);
            this.kEq.setZoomHelper(this.kDu);
        }
        cSe();
        if (this.kEF == null) {
            this.kEF = new l();
            this.kEF.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eH(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kEG, str2);
                    if (RecordVideoActivity.this.kEk != null) {
                        RecordVideoActivity.this.kEk.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void JU(String str) {
                    if (RecordVideoActivity.this.kEk != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kEk.b(stickerItem);
                        if (RecordVideoActivity.this.kCN != null) {
                            RecordVideoActivity.this.kCN.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kEk != null) {
                        RecordVideoActivity.this.kEk.setDownLoadSticker(null);
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
                    recordVideoActivity.aP(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void cPL() {
                    if (RecordVideoActivity.this.kEk != null) {
                        RecordVideoActivity.this.kEk.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kEF.cSv();
        if (this.kEk != null && this.kEE) {
            cQZ();
        }
        if (this.kjC != null) {
            this.kjC.Fb("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kCN.onPause();
        if (this.kEk != null) {
            if (this.kCF != null && this.kCF.getStatus() == 6) {
                this.kEk.stopRecord();
                cSn();
            }
            if (this.kCF != null && this.kCF.isRecording()) {
                this.kEk.stopRecord();
            }
        }
        if (this.kEH != null) {
            this.kEH.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kCF == null || this.kCF.getStatus() != 7) {
            if (this.kCF != null && this.kCF.getStatus() == 6) {
                if (this.kEk != null) {
                    this.kEk.stopRecord();
                }
                cSn();
            } else if (this.kCF.onBackPressed()) {
                finish();
            } else {
                if (this.kEp == null) {
                    this.kEp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kEp.jW(R.string.video_quit_confirm);
                    this.kEp.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kEp.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kEp.fH(true);
                    this.kEp.b(getPageContext());
                }
                this.kEp.aEG();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kEv.setVisibility(4);
        if (view == this.fkG) {
            onBackPressed();
        } else if (view == this.kEm) {
            if (this.kCF.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kCN.cRL();
            cSe();
        } else if (view == this.kEn) {
            if (this.kCF.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kEn.setOnClickListener(null);
            this.kCN.cRN();
            if (this.kCN.getIsFrontCamera() && this.kCN.cRM()) {
                this.kCN.cRL();
            }
            cSe();
            this.kEn.setOnClickListener(this);
        } else if (view == this.kEo) {
            cSg();
        }
    }

    private void cSe() {
        if (this.kCN.getIsFrontCamera()) {
            this.kEm.setVisibility(8);
        } else {
            this.kEm.setVisibility(0);
        }
        if (this.kCN.cRM()) {
            this.kEm.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kEm.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cSf() {
        return this.kEq;
    }

    public void cSg() {
        this.kEv.setVisibility(4);
        if (this.kCF.getStatus() != 6) {
            this.kCF.setStatus(6);
            cSl();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kEy == null) {
                this.kEy = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kEy.setDuration(500L);
                this.kEy.setRepeatCount(5);
                this.kEy.setRepeatMode(2);
                this.kEy.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kEy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kCF.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kEr.setVisibility(0);
                        RecordVideoActivity.this.kEr.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kEr.setVisibility(8);
                    if (RecordVideoActivity.this.kCF.getStatus() == 6) {
                        RecordVideoActivity.this.kEk.cSy();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kCF.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kEr.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kEr.setText("");
                        }
                    }
                }
            });
            this.kEr.setAnimation(this.kEy);
            this.kEy.startNow();
            this.kEk.cSg();
            if (this.kEH != null) {
                this.kEH.cSa();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSh() {
        if (this.kCF.getStatus() == 1) {
            this.kEv.setVisibility(4);
            if (this.kCF.getStatus() != 6) {
                this.kEk.cSh();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSi() {
        this.kEv.setVisibility(4);
        if (this.kCF.getStatus() != 6) {
            this.kEk.cSi();
            if (this.kEk.cSC()) {
                cSc();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSj() {
        this.kEv.setVisibility(4);
        if (this.kCF.getStatus() != 6) {
            this.kEk.cSj();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cSk() {
        this.kEv.setVisibility(4);
        if (this.kCF.getStatus() != 6) {
            this.kEk.cSk();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSl() {
        this.kED = true;
        if (this.kEx != null && this.kEx.isRunning()) {
            this.kEx.cancel();
        }
        if (this.kEw == null) {
            this.kEw = new AnimatorSet();
            this.kEw.playTogether(ObjectAnimator.ofFloat(this.kEl, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kEs, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kEI, "alpha", 1.0f, 0.0f));
            this.kEw.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kGi) {
                        RecordVideoActivity.this.kEl.setVisibility(8);
                        RecordVideoActivity.this.kEs.setVisibility(8);
                        RecordVideoActivity.this.kEI.setVisibility(8);
                    }
                }
            });
            this.kEw.setDuration(300L);
        }
        this.kEw.start();
        this.kEs.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSa() {
        if (this.mCurrentTab == 2) {
            if (this.kED) {
                this.kED = false;
                if (this.kEH != null) {
                    this.kEH.cSa();
                }
            } else {
                return;
            }
        }
        if (this.kEw != null && this.kEw.isRunning()) {
            this.kEw.cancel();
        }
        if (this.kEx == null) {
            this.kEx = new AnimatorSet();
            this.kEx.playTogether(ObjectAnimator.ofFloat(this.kEl, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kEs, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kEI, "alpha", 0.0f, 1.0f));
            this.kEx.setDuration(300L);
        }
        this.kEl.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kEs.setVisibility(0);
        }
        if (this.kCF.getStatus() == 1) {
            this.kEI.setVisibility(0);
        }
        this.kEx.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSm() {
        if (this.kCN != null) {
            this.kCN.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kCF.setStatus(1);
                    RecordVideoActivity.this.cSa();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kEJ != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kEJ)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kEJ);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kEJ = new ImageFileInfo();
                        RecordVideoActivity.this.kEJ.setFilePath(str);
                        RecordVideoActivity.this.kEJ.setTempFile(true);
                        RecordVideoActivity.this.kEJ.setAlbumnId(null);
                        RecordVideoActivity.this.kEJ.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kEJ);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kEC, RecordVideoActivity.this.kEB)));
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("album_result", RecordVideoActivity.this.mWriteImagesInfo.toJsonString());
                        RecordVideoActivity.this.setResult(-1, intent);
                        RecordVideoActivity.this.finish();
                        ActivityPendingTransitionFactory.closeAnimation(RecordVideoActivity.this.getPageContext(), 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSn() {
        this.kEy.cancel();
        this.kEy.setAnimationListener(null);
        this.kEr.clearAnimation();
        this.kEr.setVisibility(8);
        if (this.kEH != null) {
            this.kEH.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSo() {
        cJZ();
    }

    private void cJZ() {
        if (this.kEz != null) {
            this.kEz.cancel();
        }
        if (this.kEA == null) {
            this.kEA = ObjectAnimator.ofFloat(this.kEI, "alpha", 1.0f, 0.0f);
            this.kEA.setDuration(500L);
            this.kEA.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kGi) {
                        RecordVideoActivity.this.kEI.setVisibility(8);
                    }
                }
            });
        }
        this.kEA.start();
    }

    private void cJY() {
        if (this.kEA != null) {
            this.kEA.cancel();
        }
        if (this.kEz == null) {
            this.kEz = ObjectAnimator.ofFloat(this.kEI, "alpha", 0.0f, 1.0f);
            this.kEz.setDuration(500L);
        }
        this.kEI.setVisibility(0);
        this.kEz.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSp() {
        this.kEs.reset();
        if (this.kCF.getStatus() == 1) {
            cJY();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSq() {
        if (this.aGw.getVisibility() != 0) {
            this.kEk.cSx();
            this.kCF.setStatus(8);
            cSa();
            if (this.kCN.kDs != null && this.kCN.kDs.size() > 0) {
                this.aGw.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kEN = 50;
        final int kEO = 1;
        Handler kEP = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kEu.V(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cSu();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cSu() {
            this.kEP.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cSu();
            boolean z = RecordVideoActivity.this.kEH == null || TextUtils.isEmpty(RecordVideoActivity.this.kEH.cRZ()) || !new File(RecordVideoActivity.this.kEH.cRZ()).exists();
            if (RecordVideoActivity.this.kCN.kDs.size() > 1) {
                return com.baidu.tieba.video.meida.h.cRp().a(RecordVideoActivity.this.kCN.kDs, RecordVideoActivity.this.kCN.cRF(), z);
            }
            File file = new File(RecordVideoActivity.this.kCN.kDs.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kCN.cRF());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cRp().a(RecordVideoActivity.this.kCN.kDs, RecordVideoActivity.this.kCN.cRF(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kEk.cSD();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cSb();
                    RecordVideoActivity.this.DS(102);
                    RecordVideoActivity.this.aGw.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cSb();
                RecordVideoActivity.this.DS(102);
                RecordVideoActivity.this.aGw.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aGw.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aP(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kEu.V(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kEk == null || v.isEmpty(this.kEk.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kEk.getChoosedBeautyList()) {
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
        if (this.kEk == null || v.isEmpty(this.kEk.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kEk.getChoosedFilterList()) {
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
        if (this.kEk == null || v.isEmpty(this.kEk.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kEk.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSr() {
        this.kEv.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSs() {
        this.kEv.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cSt() {
        if (this.kCF.getStatus() == 1) {
            this.kEI.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kCN != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kCN.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").X("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kEs.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kEs.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kCN.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cx("obj_id", (String) eVar.getValue());
                        if (this.kCF.getStatus() == 1) {
                            anVar.X("obj_type", 1);
                        } else {
                            anVar.X("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kEs.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kEs.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kEH.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kEs.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kEs.setViewChoosed(0, true);
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
            this.kEG = stickerItem;
            this.kEF.Ks(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kCN != null) {
                    this.kCN.setSticker(null);
                    this.kEL = false;
                }
                if (this.kEk != null) {
                    this.kEk.setDownLoadSticker(null);
                }
                this.kEt.setVisibility(8);
                this.kEs.setViewChoosed(1, false);
                return;
            }
            String Kp = this.kEF.Kp(stickerItem.resource);
            if (!StringUtils.isNull(Kp)) {
                a(stickerItem, Kp);
                if (this.kEk != null) {
                    this.kEk.setDownLoadSticker(null);
                }
            } else {
                if (this.kEk != null) {
                    this.kEk.setDownLoadSticker(stickerItem);
                }
                this.kEF.Kq(stickerItem.resource);
            }
            this.kEs.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kCN != null) {
                this.kCN.setSticker(stickerItem);
                this.kEL = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kEt.setText(stickerItem.desc);
                this.kEt.setVisibility(0);
                this.kEt.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kEt.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kEt.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cT(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kEk.getLayoutParams();
            layoutParams.height = i4;
            this.kEk.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Kb = com.baidu.tieba.video.editvideo.model.a.cQt().Kb(stringExtra);
                if (this.kEH != null && !TextUtils.isEmpty(Kb)) {
                    this.kEH.eI(Kb, stringExtra2);
                    this.kEk.cRu();
                }
            }
        } else if (i == 12012 && i2 == -1) {
            Intent intent2 = new Intent();
            if (intent != null) {
                intent2.putExtra("album_result", intent.getStringExtra("album_result"));
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
        if (this.kCF.getStatus() == 8) {
            this.kEk.cSw();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void tA(boolean z) {
        if (this.kCF != null && (this.kCF.getStatus() == 1 || this.kCF.getStatus() == 3 || this.kCF.getStatus() == 4)) {
            if (!z && this.kEL) {
                this.kEq.cRR();
                return;
            } else {
                this.kEq.cRS();
                return;
            }
        }
        this.kEq.cRS();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kEH != null) {
                        this.kEH.aWH();
                    }
                    this.kCN.setFilter("origin");
                    this.kEs.setViewChoosed(0, false);
                    this.kEs.setViewChoosed(3, false);
                    this.kEk.DU(1);
                    this.kEs.setViewVisibility(0, 8);
                    this.kEs.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kEs.setViewVisibility(0, 0);
                    this.kEs.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kEk.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().X("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRY() {
        if (this.kCF.getStatus() == 1 && !this.kEk.cSB()) {
            onTabChoosed(1, true);
            this.kEI.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRX() {
        if (this.kCF.getStatus() == 1 && !this.kEk.cSB()) {
            onTabChoosed(2, true);
            this.kEI.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DS(int i) {
        if (this.kjC != null) {
            this.kjC.aQ(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (this.kjC != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.kjC.aP(i, str);
        }
    }
}
