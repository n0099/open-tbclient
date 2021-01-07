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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.video.localvideo.a;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private TextView bDM;
    private View byS;
    private final CustomMessageListener ghd;
    private int jCC;
    private com.baidu.tbadk.core.dialog.a jiY;
    private ForumWriteData jst;
    private ImageView kiB;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String nGH;
    private SelectMusicModel nGL;
    private i nKE;
    protected h nKM;
    private b nLu;
    private ObjectAnimator nMA;
    private int nMB;
    private int nMC;
    private boolean nMD;
    private boolean nME = true;
    private l nMF;
    private StickerItem nMG;
    protected j nMH;
    private RecordTabLayout nMI;
    private ImageFileInfo nMJ;
    private a.InterfaceC0903a nMK;
    private HttpMessageListener nML;
    private boolean nMM;
    private final CustomMessageListener nMN;
    private RecordLayout nMl;
    private VideoControllerLayout nMm;
    private RelativeLayout nMn;
    private ImageView nMo;
    private ImageView nMp;
    private ImageView nMq;
    private PreviewViewContainer nMr;
    private VideoEffectButtonLayout nMs;
    private TextView nMt;
    private RoundProgressBar nMu;
    private TextView nMv;
    private AnimatorSet nMw;
    private AnimatorSet nMx;
    private ScaleAnimation nMy;
    private ObjectAnimator nMz;
    private com.baidu.tieba.l.g nsO;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nsO = kVar.diQ();
        }
        if (this.nsO != null) {
            this.nsO.diz();
        }
        this.nMK = new a.InterfaceC0903a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.a.InterfaceC0903a
            public void gb(List<com.baidu.tieba.video.localvideo.b> list) {
                if (x.isEmpty(list)) {
                    if (RecordVideoActivity.this.nMm != null) {
                        RecordVideoActivity.this.nMm.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nMm != null) {
                    RecordVideoActivity.this.nMm.setHasLocalVideo(true);
                    RecordVideoActivity.this.nME = false;
                }
            }
        };
        this.nML = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nMm != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nMm.setStickerItems(list);
                    }
                }
            }
        };
        this.nMN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.ghd = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
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
    public void dVU() {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nKM.nJn);
        videoInfo.setVideoDuration(this.nKE.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nKM.nJn).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str3 = this.jst == null ? "" : this.jst.forumName;
        String str4 = this.jst == null ? "" : this.jst.forumId;
        int i = this.jst == null ? -1 : this.jst.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jst.writeCallFrom, str3, str4, this.nGH, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setStatisticFrom(this.jst.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.jst != null ? this.jst.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jst != null ? this.jst.forumLevel : -1);
        if (getIntent() == null) {
            str = "";
            str2 = "";
            antiData = null;
            postPrefixData = null;
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
            AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
            PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
            str2 = getIntent().getStringExtra("forum_first_dir");
            str = getIntent().getStringExtra("forum_second_dir");
            antiData = antiData2;
            postPrefixData = postPrefixData2;
        }
        editVideoActivityConfig.setExtraData(antiData, postPrefixData, str2, str);
        editVideoActivityConfig.setFrom(this.jst.mFrom);
        if (this.nMH != null) {
            this.nMH.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nsO != null) {
            this.nsO.diC();
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
        if (this.nKE != null && this.nKE.bzj()) {
            this.nKE.stopRecord();
        }
        if (this.nGL != null) {
            this.nGL.cancelLoadData();
        }
        if (this.nsO != null) {
            this.nsO.OW("record");
        }
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
        this.nMB = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nMC = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jst = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nGH = getIntent().getStringExtra("video_title");
        initUI();
        this.nGL = new SelectMusicModel(getPageContext(), this.nMm);
        this.nGL.dUz();
        this.nMH = new j(this);
        this.nMH.b(this.nGL);
        this.nKE.a(this.nMH);
        registerListener(this.nML);
        registerListener(this.nMN);
        registerListener(this.ghd);
        dVV();
        if (Build.VERSION.SDK_INT >= 28 && am.bwj() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dVV() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dVW() {
        com.baidu.tieba.video.localvideo.a aVar = new com.baidu.tieba.video.localvideo.a(this);
        aVar.a(this.nMK);
        aVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nMl = (RecordLayout) findViewById(R.id.root_layout);
        this.nMl.setListener(this);
        this.nKE = new i(this);
        this.nMm = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nMm.setRecordController(this.nKE);
        this.nMm.setRecordControlListener(this);
        this.nMm.setEffectChoosedListener(this);
        this.nMn = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.kiB = (ImageView) findViewById(R.id.close_page);
        this.kiB.setOnClickListener(this);
        this.nMo = (ImageView) findViewById(R.id.flash_switch);
        this.nMo.setOnClickListener(this);
        this.nMp = (ImageView) findViewById(R.id.camera_switch);
        this.nMp.setOnClickListener(this);
        this.nMq = (ImageView) findViewById(R.id.count_down);
        this.nMq.setOnClickListener(this);
        this.nMr = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nKM = new h(this);
        this.nKM.a(this);
        this.nKM.setFaceIdentifyStateListener(this);
        this.nKM.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dVI() {
                if (RecordVideoActivity.this.nMm.dWv()) {
                    RecordVideoActivity.this.nMm.a((m) null);
                }
            }
        });
        this.nMs = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nMs.setListener(this);
        this.nKE.a(this.nMs);
        this.nMs.setViewChoosed(2, true);
        this.bDM = (TextView) findViewById(R.id.tv_count_down);
        this.nMt = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bDM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bDM.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nMs.setVisibility(8);
        }
        this.byS = findViewById(R.id.progress_layout);
        this.nMu = (RoundProgressBar) this.byS.findViewById(R.id.video_progress);
        this.nMv = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nMv.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nMv.setLayoutParams(layoutParams);
        this.nMI = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || x.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Mb(this.nMC);
        } else {
            Mb(1);
        }
        dVX();
    }

    private void Mb(int i) {
        if (this.nMI != null) {
            if (i == 0) {
                this.nMI.bX(1, getString(R.string.tab_photo));
                this.nMI.bX(2, getString(R.string.tab_record));
                this.nMI.setListener(this);
                this.nMI.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.nMI.bX(1, getString(R.string.tab_photo));
                this.nMI.setShowIndicator(false);
                this.nMI.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.nMI.bX(2, getString(R.string.tab_record));
                this.nMI.setShowIndicator(false);
                this.nMI.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dVX() {
        if (com.baidu.tbadk.core.util.g.bvA()) {
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
        this.nKM.onResume();
        this.nLu = this.nKM.dVz();
        if (this.nLu != null) {
            this.nLu.setRecordController(this.nKE);
            this.nMr.setZoomHelper(this.nLu);
        }
        dVY();
        if (this.nMF == null) {
            this.nMF = new l();
            this.nMF.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gy(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nMG, str2);
                    if (RecordVideoActivity.this.nMm != null) {
                        RecordVideoActivity.this.nMm.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Um(String str) {
                    if (RecordVideoActivity.this.nMm != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nMm.b(stickerItem);
                        if (RecordVideoActivity.this.nKM != null) {
                            RecordVideoActivity.this.nKM.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nMm != null) {
                        RecordVideoActivity.this.nMm.setDownLoadSticker(null);
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
                    recordVideoActivity.bD(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dTN() {
                    if (RecordVideoActivity.this.nMm != null) {
                        RecordVideoActivity.this.nMm.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nMF.dWp();
        if (this.nMm != null && this.nME) {
            dVW();
        }
        if (this.nsO != null) {
            this.nsO.OV("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nKM.onPause();
        if (this.nMm != null) {
            if (this.nKE != null && this.nKE.getStatus() == 6) {
                this.nMm.stopRecord();
                dWh();
            }
            if (this.nKE != null && this.nKE.bzj()) {
                this.nMm.stopRecord();
            }
        }
        if (this.nMH != null) {
            this.nMH.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nKE == null || this.nKE.getStatus() != 7) {
            if (this.nKE != null && this.nKE.getStatus() == 6) {
                if (this.nMm != null) {
                    this.nMm.stopRecord();
                }
                dWh();
            } else if (this.nKE != null && this.nKE.onBackPressed()) {
                finish();
            } else {
                if (this.jiY == null) {
                    this.jiY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jiY.pa(R.string.video_quit_confirm);
                    this.jiY.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jiY.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jiY.jH(true);
                    this.jiY.b(getPageContext());
                }
                this.jiY.btY();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nMv.setVisibility(4);
        if (view == this.kiB) {
            onBackPressed();
        } else if (view == this.nMo) {
            if (this.nKE.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nKM.dVC();
            dVY();
        } else if (view == this.nMp) {
            if (this.nKE.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nMp.setOnClickListener(null);
            this.nKM.dVE();
            if (this.nKM.dVF() && this.nKM.dVD()) {
                this.nKM.dVC();
            }
            dVY();
            this.nMp.setOnClickListener(this);
        } else if (view == this.nMq) {
            dWa();
        }
    }

    private void dVY() {
        if (this.nKM.dVF()) {
            this.nMo.setVisibility(8);
        } else {
            this.nMo.setVisibility(0);
        }
        if (this.nKM.dVD()) {
            this.nMo.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nMo.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dVZ() {
        return this.nMr;
    }

    public void dWa() {
        this.nMv.setVisibility(4);
        if (this.nKE.getStatus() != 6) {
            this.nKE.setStatus(6);
            dWf();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nMy == null) {
                this.nMy = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nMy.setDuration(500L);
                this.nMy.setRepeatCount(5);
                this.nMy.setRepeatMode(2);
                this.nMy.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nMy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nKE.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bDM.setVisibility(0);
                        RecordVideoActivity.this.bDM.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bDM.setVisibility(8);
                    if (RecordVideoActivity.this.nKE.getStatus() == 6) {
                        RecordVideoActivity.this.nMm.dWs();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nKE.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bDM.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bDM.setText("");
                        }
                    }
                }
            });
            this.bDM.setAnimation(this.nMy);
            this.nMy.startNow();
            this.nMm.dWa();
            if (this.nMH != null) {
                this.nMH.dVT();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWb() {
        if (this.nKE.getStatus() == 1) {
            this.nMv.setVisibility(4);
            if (this.nKE.getStatus() != 6) {
                this.nMm.dWb();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWc() {
        this.nMv.setVisibility(4);
        if (this.nKE.getStatus() != 6) {
            this.nMm.dWc();
            if (this.nMm.dWw()) {
                dVV();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWd() {
        this.nMv.setVisibility(4);
        if (this.nKE.getStatus() != 6) {
            this.nMm.dWd();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWe() {
        this.nMv.setVisibility(4);
        if (this.nKE.getStatus() != 6) {
            this.nMm.dWe();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWf() {
        this.nMD = true;
        if (this.nMx != null && this.nMx.isRunning()) {
            this.nMx.cancel();
        }
        if (this.nMw == null) {
            this.nMw = new AnimatorSet();
            this.nMw.playTogether(ObjectAnimator.ofFloat(this.nMn, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nMs, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nMI, "alpha", 1.0f, 0.0f));
            this.nMw.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOk) {
                        RecordVideoActivity.this.nMn.setVisibility(8);
                        RecordVideoActivity.this.nMs.setVisibility(8);
                        RecordVideoActivity.this.nMI.setVisibility(8);
                    }
                }
            });
            this.nMw.setDuration(300L);
        }
        this.nMw.start();
        this.nMs.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dVT() {
        if (this.jCC == 2) {
            if (this.nMD) {
                this.nMD = false;
                if (this.nMH != null) {
                    this.nMH.dVT();
                }
            } else {
                return;
            }
        }
        if (this.nMw != null && this.nMw.isRunning()) {
            this.nMw.cancel();
        }
        if (this.nMx == null) {
            this.nMx = new AnimatorSet();
            this.nMx.playTogether(ObjectAnimator.ofFloat(this.nMn, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nMs, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nMI, "alpha", 0.0f, 1.0f));
            this.nMx.setDuration(300L);
        }
        this.nMn.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nMs.setVisibility(0);
        }
        if (this.nKE.getStatus() == 1) {
            this.nMI.setVisibility(0);
        }
        this.nMx.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWg() {
        if (this.nKM != null) {
            this.nKM.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void G(boolean z, String str) {
                    RecordVideoActivity.this.nKE.setStatus(1);
                    RecordVideoActivity.this.dVT();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nMJ != null && !x.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nMJ)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nMJ);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nMJ = new ImageFileInfo();
                        RecordVideoActivity.this.nMJ.setFilePath(str);
                        RecordVideoActivity.this.nMJ.setContentUriStr(null);
                        RecordVideoActivity.this.nMJ.setTempFile(true);
                        RecordVideoActivity.this.nMJ.setAlbumnId(null);
                        RecordVideoActivity.this.nMJ.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nMJ);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jst, RecordVideoActivity.this.nMB)));
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
    public void dWh() {
        this.nMy.cancel();
        this.nMy.setAnimationListener(null);
        this.bDM.clearAnimation();
        this.bDM.setVisibility(8);
        if (this.nMH != null) {
            this.nMH.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWi() {
        dNB();
    }

    private void dNB() {
        if (this.nMz != null) {
            this.nMz.cancel();
        }
        if (this.nMA == null) {
            this.nMA = ObjectAnimator.ofFloat(this.nMI, "alpha", 1.0f, 0.0f);
            this.nMA.setDuration(500L);
            this.nMA.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOk) {
                        RecordVideoActivity.this.nMI.setVisibility(8);
                    }
                }
            });
        }
        this.nMA.start();
    }

    private void dNA() {
        if (this.nMA != null) {
            this.nMA.cancel();
        }
        if (this.nMz == null) {
            this.nMz = ObjectAnimator.ofFloat(this.nMI, "alpha", 0.0f, 1.0f);
            this.nMz.setDuration(500L);
        }
        this.nMI.setVisibility(0);
        this.nMz.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWj() {
        this.nMs.reset();
        if (this.nKE.getStatus() == 1) {
            dNA();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWk() {
        if (this.byS.getVisibility() != 0) {
            this.nMm.dWr();
            this.nKE.setStatus(8);
            dVT();
            if (this.nKM.nLs != null && this.nKM.nLs.size() > 0) {
                this.byS.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nMP = 50;
        final int nMQ = 1;
        Handler nMR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AnonymousClass3.this.mProgress >= 0) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nMu.R(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dWo();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dWo() {
            if (this.mProgress >= 0) {
                this.nMR.sendEmptyMessageDelayed(1, 50L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dWo();
            boolean z = RecordVideoActivity.this.nMH == null || TextUtils.isEmpty(RecordVideoActivity.this.nMH.dVS()) || !new File(RecordVideoActivity.this.nMH.dVS()).exists();
            if (RecordVideoActivity.this.nKM.nLs.size() > 1) {
                return com.baidu.tieba.video.meida.h.dVf().a(RecordVideoActivity.this.nKM.nLs, RecordVideoActivity.this.nKM.dVw(), z);
            }
            File file = new File(RecordVideoActivity.this.nKM.nLs.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nKM.dVw());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dVf().a(RecordVideoActivity.this.nKM.nLs, RecordVideoActivity.this.nKM.dVw(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            this.mProgress = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.nMm.dWx();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dVU();
                    RecordVideoActivity.this.Mc(102);
                    RecordVideoActivity.this.byS.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dVU();
                RecordVideoActivity.this.Mc(102);
                RecordVideoActivity.this.byS.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.byS.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bD(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nMu.R(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nMm == null || x.isEmpty(this.nMm.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nMm.getChoosedBeautyList()) {
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
        if (this.nMm == null || x.isEmpty(this.nMm.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nMm.getChoosedFilterList()) {
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
        if (this.nMm == null || x.isEmpty(this.nMm.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nMm.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWl() {
        this.nMv.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWm() {
        this.nMv.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWn() {
        if (this.nKE.getStatus() == 1) {
            this.nMI.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nKM != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nKM.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").an("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nMs.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nMs.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nKM.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dX("obj_id", (String) eVar.getValue());
                        if (this.nKE.getStatus() == 1) {
                            aqVar.an("obj_type", 1);
                        } else {
                            aqVar.an("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nMs.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nMs.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nMH.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nMs.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nMs.setViewChoosed(0, true);
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
            this.nMG = stickerItem;
            this.nMF.UK(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nKM != null) {
                    this.nKM.setSticker(null);
                    this.nMM = false;
                }
                if (this.nMm != null) {
                    this.nMm.setDownLoadSticker(null);
                }
                this.nMt.setVisibility(8);
                this.nMs.setViewChoosed(1, false);
                return;
            }
            String UH = this.nMF.UH(stickerItem.resource);
            if (!StringUtils.isNull(UH)) {
                a(stickerItem, UH);
                if (this.nMm != null) {
                    this.nMm.setDownLoadSticker(null);
                }
            } else {
                if (this.nMm != null) {
                    this.nMm.setDownLoadSticker(stickerItem);
                }
                this.nMF.UI(stickerItem.resource);
            }
            this.nMs.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nKM != null) {
                this.nKM.setSticker(stickerItem);
                this.nMM = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nMt.setText(stickerItem.desc);
                this.nMt.setVisibility(0);
                this.nMt.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nMt.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nMt.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dC(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nMm.getLayoutParams();
            layoutParams.height = i4;
            this.nMm.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Us = com.baidu.tieba.video.editvideo.model.a.dUt().Us(stringExtra);
                if (this.nMH != null && !TextUtils.isEmpty(Us)) {
                    this.nMH.gB(Us, stringExtra2);
                    this.nMm.dVk();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (this.nKE.getStatus() == 8) {
            this.nMm.dWq();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yP(boolean z) {
        if (this.nKE != null && (this.nKE.getStatus() == 1 || this.nKE.getStatus() == 3 || this.nKE.getStatus() == 4)) {
            if (!z && this.nMM) {
                this.nMr.dVJ();
                return;
            } else {
                this.nMr.dVK();
                return;
            }
        }
        this.nMr.dVK();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.jCC != i) {
            switch (i) {
                case 1:
                    if (this.nMH != null) {
                        this.nMH.bjA();
                    }
                    this.nKM.setFilter("origin");
                    this.nMs.setViewChoosed(0, false);
                    this.nMs.setViewChoosed(3, false);
                    this.nMm.Me(1);
                    this.nMs.setViewVisibility(0, 8);
                    this.nMs.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nMs.setViewVisibility(0, 0);
                    this.nMs.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jCC = i;
            this.nMm.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().an("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dVR() {
        if (this.nKE.getStatus() == 1 && !this.nMm.dWv()) {
            ai(1, true);
            this.nMI.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dVQ() {
        if (this.nKE.getStatus() == 1 && !this.nMm.dWv()) {
            ai(2, true);
            this.nMI.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mc(int i) {
        if (this.nsO != null) {
            this.nsO.bE(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, String str) {
        if (this.nsO != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nsO.bD(i, str);
        }
    }
}
