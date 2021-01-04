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
    private String nGI;
    private SelectMusicModel nGM;
    private i nKF;
    protected h nKN;
    private b nLv;
    private ObjectAnimator nMA;
    private ObjectAnimator nMB;
    private int nMC;
    private int nMD;
    private boolean nME;
    private boolean nMF = true;
    private l nMG;
    private StickerItem nMH;
    protected j nMI;
    private RecordTabLayout nMJ;
    private ImageFileInfo nMK;
    private a.InterfaceC0865a nML;
    private HttpMessageListener nMM;
    private boolean nMN;
    private final CustomMessageListener nMO;
    private RecordLayout nMm;
    private VideoControllerLayout nMn;
    private RelativeLayout nMo;
    private ImageView nMp;
    private ImageView nMq;
    private ImageView nMr;
    private PreviewViewContainer nMs;
    private VideoEffectButtonLayout nMt;
    private TextView nMu;
    private RoundProgressBar nMv;
    private TextView nMw;
    private AnimatorSet nMx;
    private AnimatorSet nMy;
    private ScaleAnimation nMz;
    private com.baidu.tieba.l.g nsP;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nsP = kVar.diP();
        }
        if (this.nsP != null) {
            this.nsP.diy();
        }
        this.nML = new a.InterfaceC0865a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.a.InterfaceC0865a
            public void gb(List<com.baidu.tieba.video.localvideo.b> list) {
                if (x.isEmpty(list)) {
                    if (RecordVideoActivity.this.nMn != null) {
                        RecordVideoActivity.this.nMn.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nMn != null) {
                    RecordVideoActivity.this.nMn.setHasLocalVideo(true);
                    RecordVideoActivity.this.nMF = false;
                }
            }
        };
        this.nMM = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nMn != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nMn.setStickerItems(list);
                    }
                }
            }
        };
        this.nMO = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void dVT() {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nKN.nJo);
        videoInfo.setVideoDuration(this.nKF.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nKN.nJo).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str3 = this.jst == null ? "" : this.jst.forumName;
        String str4 = this.jst == null ? "" : this.jst.forumId;
        int i = this.jst == null ? -1 : this.jst.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jst.writeCallFrom, str3, str4, this.nGI, videoInfo);
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
        if (this.nMI != null) {
            this.nMI.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nsP != null) {
            this.nsP.diB();
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
        if (this.nKF != null && this.nKF.bzi()) {
            this.nKF.stopRecord();
        }
        if (this.nGM != null) {
            this.nGM.cancelLoadData();
        }
        if (this.nsP != null) {
            this.nsP.OX("record");
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
        this.nMC = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nMD = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jst = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nGI = getIntent().getStringExtra("video_title");
        initUI();
        this.nGM = new SelectMusicModel(getPageContext(), this.nMn);
        this.nGM.dUy();
        this.nMI = new j(this);
        this.nMI.b(this.nGM);
        this.nKF.a(this.nMI);
        registerListener(this.nMM);
        registerListener(this.nMO);
        registerListener(this.ghd);
        dVU();
        if (Build.VERSION.SDK_INT >= 28 && am.bwi() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dVU() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dVV() {
        com.baidu.tieba.video.localvideo.a aVar = new com.baidu.tieba.video.localvideo.a(this);
        aVar.a(this.nML);
        aVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nMm = (RecordLayout) findViewById(R.id.root_layout);
        this.nMm.setListener(this);
        this.nKF = new i(this);
        this.nMn = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nMn.setRecordController(this.nKF);
        this.nMn.setRecordControlListener(this);
        this.nMn.setEffectChoosedListener(this);
        this.nMo = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.kiB = (ImageView) findViewById(R.id.close_page);
        this.kiB.setOnClickListener(this);
        this.nMp = (ImageView) findViewById(R.id.flash_switch);
        this.nMp.setOnClickListener(this);
        this.nMq = (ImageView) findViewById(R.id.camera_switch);
        this.nMq.setOnClickListener(this);
        this.nMr = (ImageView) findViewById(R.id.count_down);
        this.nMr.setOnClickListener(this);
        this.nMs = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nKN = new h(this);
        this.nKN.a(this);
        this.nKN.setFaceIdentifyStateListener(this);
        this.nKN.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dVH() {
                if (RecordVideoActivity.this.nMn.dWu()) {
                    RecordVideoActivity.this.nMn.a((m) null);
                }
            }
        });
        this.nMt = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nMt.setListener(this);
        this.nKF.a(this.nMt);
        this.nMt.setViewChoosed(2, true);
        this.bDM = (TextView) findViewById(R.id.tv_count_down);
        this.nMu = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bDM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bDM.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nMt.setVisibility(8);
        }
        this.byS = findViewById(R.id.progress_layout);
        this.nMv = (RoundProgressBar) this.byS.findViewById(R.id.video_progress);
        this.nMw = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nMw.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nMw.setLayoutParams(layoutParams);
        this.nMJ = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || x.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Mb(this.nMD);
        } else {
            Mb(1);
        }
        dVW();
    }

    private void Mb(int i) {
        if (this.nMJ != null) {
            if (i == 0) {
                this.nMJ.bX(1, getString(R.string.tab_photo));
                this.nMJ.bX(2, getString(R.string.tab_record));
                this.nMJ.setListener(this);
                this.nMJ.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.nMJ.bX(1, getString(R.string.tab_photo));
                this.nMJ.setShowIndicator(false);
                this.nMJ.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.nMJ.bX(2, getString(R.string.tab_record));
                this.nMJ.setShowIndicator(false);
                this.nMJ.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dVW() {
        if (com.baidu.tbadk.core.util.g.bvz()) {
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
        this.nKN.onResume();
        this.nLv = this.nKN.dVy();
        if (this.nLv != null) {
            this.nLv.setRecordController(this.nKF);
            this.nMs.setZoomHelper(this.nLv);
        }
        dVX();
        if (this.nMG == null) {
            this.nMG = new l();
            this.nMG.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gy(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nMH, str2);
                    if (RecordVideoActivity.this.nMn != null) {
                        RecordVideoActivity.this.nMn.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Un(String str) {
                    if (RecordVideoActivity.this.nMn != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nMn.b(stickerItem);
                        if (RecordVideoActivity.this.nKN != null) {
                            RecordVideoActivity.this.nKN.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nMn != null) {
                        RecordVideoActivity.this.nMn.setDownLoadSticker(null);
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
                public void dTM() {
                    if (RecordVideoActivity.this.nMn != null) {
                        RecordVideoActivity.this.nMn.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nMG.dWo();
        if (this.nMn != null && this.nMF) {
            dVV();
        }
        if (this.nsP != null) {
            this.nsP.OW("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nKN.onPause();
        if (this.nMn != null) {
            if (this.nKF != null && this.nKF.getStatus() == 6) {
                this.nMn.stopRecord();
                dWg();
            }
            if (this.nKF != null && this.nKF.bzi()) {
                this.nMn.stopRecord();
            }
        }
        if (this.nMI != null) {
            this.nMI.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nKF == null || this.nKF.getStatus() != 7) {
            if (this.nKF != null && this.nKF.getStatus() == 6) {
                if (this.nMn != null) {
                    this.nMn.stopRecord();
                }
                dWg();
            } else if (this.nKF != null && this.nKF.onBackPressed()) {
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
                this.jiY.btX();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nMw.setVisibility(4);
        if (view == this.kiB) {
            onBackPressed();
        } else if (view == this.nMp) {
            if (this.nKF.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nKN.dVB();
            dVX();
        } else if (view == this.nMq) {
            if (this.nKF.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nMq.setOnClickListener(null);
            this.nKN.dVD();
            if (this.nKN.dVE() && this.nKN.dVC()) {
                this.nKN.dVB();
            }
            dVX();
            this.nMq.setOnClickListener(this);
        } else if (view == this.nMr) {
            dVZ();
        }
    }

    private void dVX() {
        if (this.nKN.dVE()) {
            this.nMp.setVisibility(8);
        } else {
            this.nMp.setVisibility(0);
        }
        if (this.nKN.dVC()) {
            this.nMp.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nMp.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dVY() {
        return this.nMs;
    }

    public void dVZ() {
        this.nMw.setVisibility(4);
        if (this.nKF.getStatus() != 6) {
            this.nKF.setStatus(6);
            dWe();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nMz == null) {
                this.nMz = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nMz.setDuration(500L);
                this.nMz.setRepeatCount(5);
                this.nMz.setRepeatMode(2);
                this.nMz.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nMz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nKF.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bDM.setVisibility(0);
                        RecordVideoActivity.this.bDM.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bDM.setVisibility(8);
                    if (RecordVideoActivity.this.nKF.getStatus() == 6) {
                        RecordVideoActivity.this.nMn.dWr();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nKF.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bDM.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bDM.setText("");
                        }
                    }
                }
            });
            this.bDM.setAnimation(this.nMz);
            this.nMz.startNow();
            this.nMn.dVZ();
            if (this.nMI != null) {
                this.nMI.dVS();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWa() {
        if (this.nKF.getStatus() == 1) {
            this.nMw.setVisibility(4);
            if (this.nKF.getStatus() != 6) {
                this.nMn.dWa();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWb() {
        this.nMw.setVisibility(4);
        if (this.nKF.getStatus() != 6) {
            this.nMn.dWb();
            if (this.nMn.dWv()) {
                dVU();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWc() {
        this.nMw.setVisibility(4);
        if (this.nKF.getStatus() != 6) {
            this.nMn.dWc();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWd() {
        this.nMw.setVisibility(4);
        if (this.nKF.getStatus() != 6) {
            this.nMn.dWd();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWe() {
        this.nME = true;
        if (this.nMy != null && this.nMy.isRunning()) {
            this.nMy.cancel();
        }
        if (this.nMx == null) {
            this.nMx = new AnimatorSet();
            this.nMx.playTogether(ObjectAnimator.ofFloat(this.nMo, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nMt, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nMJ, "alpha", 1.0f, 0.0f));
            this.nMx.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOl) {
                        RecordVideoActivity.this.nMo.setVisibility(8);
                        RecordVideoActivity.this.nMt.setVisibility(8);
                        RecordVideoActivity.this.nMJ.setVisibility(8);
                    }
                }
            });
            this.nMx.setDuration(300L);
        }
        this.nMx.start();
        this.nMt.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dVS() {
        if (this.jCC == 2) {
            if (this.nME) {
                this.nME = false;
                if (this.nMI != null) {
                    this.nMI.dVS();
                }
            } else {
                return;
            }
        }
        if (this.nMx != null && this.nMx.isRunning()) {
            this.nMx.cancel();
        }
        if (this.nMy == null) {
            this.nMy = new AnimatorSet();
            this.nMy.playTogether(ObjectAnimator.ofFloat(this.nMo, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nMt, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nMJ, "alpha", 0.0f, 1.0f));
            this.nMy.setDuration(300L);
        }
        this.nMo.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nMt.setVisibility(0);
        }
        if (this.nKF.getStatus() == 1) {
            this.nMJ.setVisibility(0);
        }
        this.nMy.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWf() {
        if (this.nKN != null) {
            this.nKN.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void G(boolean z, String str) {
                    RecordVideoActivity.this.nKF.setStatus(1);
                    RecordVideoActivity.this.dVS();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nMK != null && !x.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nMK)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nMK);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nMK = new ImageFileInfo();
                        RecordVideoActivity.this.nMK.setFilePath(str);
                        RecordVideoActivity.this.nMK.setContentUriStr(null);
                        RecordVideoActivity.this.nMK.setTempFile(true);
                        RecordVideoActivity.this.nMK.setAlbumnId(null);
                        RecordVideoActivity.this.nMK.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nMK);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jst, RecordVideoActivity.this.nMC)));
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
    public void dWg() {
        this.nMz.cancel();
        this.nMz.setAnimationListener(null);
        this.bDM.clearAnimation();
        this.bDM.setVisibility(8);
        if (this.nMI != null) {
            this.nMI.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWh() {
        dNA();
    }

    private void dNA() {
        if (this.nMA != null) {
            this.nMA.cancel();
        }
        if (this.nMB == null) {
            this.nMB = ObjectAnimator.ofFloat(this.nMJ, "alpha", 1.0f, 0.0f);
            this.nMB.setDuration(500L);
            this.nMB.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nOl) {
                        RecordVideoActivity.this.nMJ.setVisibility(8);
                    }
                }
            });
        }
        this.nMB.start();
    }

    private void dNz() {
        if (this.nMB != null) {
            this.nMB.cancel();
        }
        if (this.nMA == null) {
            this.nMA = ObjectAnimator.ofFloat(this.nMJ, "alpha", 0.0f, 1.0f);
            this.nMA.setDuration(500L);
        }
        this.nMJ.setVisibility(0);
        this.nMA.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWi() {
        this.nMt.reset();
        if (this.nKF.getStatus() == 1) {
            dNz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWj() {
        if (this.byS.getVisibility() != 0) {
            this.nMn.dWq();
            this.nKF.setStatus(8);
            dVS();
            if (this.nKN.nLt != null && this.nKN.nLt.size() > 0) {
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
        final int nMQ = 50;
        final int nMR = 1;
        Handler nMS = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AnonymousClass3.this.mProgress >= 0) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nMv.R(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dWn();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dWn() {
            if (this.mProgress >= 0) {
                this.nMS.sendEmptyMessageDelayed(1, 50L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dWn();
            boolean z = RecordVideoActivity.this.nMI == null || TextUtils.isEmpty(RecordVideoActivity.this.nMI.dVR()) || !new File(RecordVideoActivity.this.nMI.dVR()).exists();
            if (RecordVideoActivity.this.nKN.nLt.size() > 1) {
                return com.baidu.tieba.video.meida.h.dVe().a(RecordVideoActivity.this.nKN.nLt, RecordVideoActivity.this.nKN.dVv(), z);
            }
            File file = new File(RecordVideoActivity.this.nKN.nLt.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nKN.dVv());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dVe().a(RecordVideoActivity.this.nKN.nLt, RecordVideoActivity.this.nKN.dVv(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            this.mProgress = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.nMn.dWw();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dVT();
                    RecordVideoActivity.this.Mc(102);
                    RecordVideoActivity.this.byS.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dVT();
                RecordVideoActivity.this.Mc(102);
                RecordVideoActivity.this.byS.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.byS.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bD(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nMv.R(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nMn == null || x.isEmpty(this.nMn.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nMn.getChoosedBeautyList()) {
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
        if (this.nMn == null || x.isEmpty(this.nMn.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nMn.getChoosedFilterList()) {
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
        if (this.nMn == null || x.isEmpty(this.nMn.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nMn.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWk() {
        this.nMw.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWl() {
        this.nMw.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWm() {
        if (this.nKF.getStatus() == 1) {
            this.nMJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nKN != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nKN.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").an("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nMt.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nMt.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nKN.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dX("obj_id", (String) eVar.getValue());
                        if (this.nKF.getStatus() == 1) {
                            aqVar.an("obj_type", 1);
                        } else {
                            aqVar.an("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nMt.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nMt.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nMI.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nMt.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nMt.setViewChoosed(0, true);
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
            this.nMH = stickerItem;
            this.nMG.UL(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nKN != null) {
                    this.nKN.setSticker(null);
                    this.nMN = false;
                }
                if (this.nMn != null) {
                    this.nMn.setDownLoadSticker(null);
                }
                this.nMu.setVisibility(8);
                this.nMt.setViewChoosed(1, false);
                return;
            }
            String UI = this.nMG.UI(stickerItem.resource);
            if (!StringUtils.isNull(UI)) {
                a(stickerItem, UI);
                if (this.nMn != null) {
                    this.nMn.setDownLoadSticker(null);
                }
            } else {
                if (this.nMn != null) {
                    this.nMn.setDownLoadSticker(stickerItem);
                }
                this.nMG.UJ(stickerItem.resource);
            }
            this.nMt.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nKN != null) {
                this.nKN.setSticker(stickerItem);
                this.nMN = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nMu.setText(stickerItem.desc);
                this.nMu.setVisibility(0);
                this.nMu.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nMu.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nMu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dC(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nMn.getLayoutParams();
            layoutParams.height = i4;
            this.nMn.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ut = com.baidu.tieba.video.editvideo.model.a.dUs().Ut(stringExtra);
                if (this.nMI != null && !TextUtils.isEmpty(Ut)) {
                    this.nMI.gB(Ut, stringExtra2);
                    this.nMn.dVj();
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
        if (this.nKF.getStatus() == 8) {
            this.nMn.dWp();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yP(boolean z) {
        if (this.nKF != null && (this.nKF.getStatus() == 1 || this.nKF.getStatus() == 3 || this.nKF.getStatus() == 4)) {
            if (!z && this.nMN) {
                this.nMs.dVI();
                return;
            } else {
                this.nMs.dVJ();
                return;
            }
        }
        this.nMs.dVJ();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.jCC != i) {
            switch (i) {
                case 1:
                    if (this.nMI != null) {
                        this.nMI.bjz();
                    }
                    this.nKN.setFilter("origin");
                    this.nMt.setViewChoosed(0, false);
                    this.nMt.setViewChoosed(3, false);
                    this.nMn.Me(1);
                    this.nMt.setViewVisibility(0, 8);
                    this.nMt.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nMt.setViewVisibility(0, 0);
                    this.nMt.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jCC = i;
            this.nMn.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().an("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dVQ() {
        if (this.nKF.getStatus() == 1 && !this.nMn.dWu()) {
            ai(1, true);
            this.nMJ.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dVP() {
        if (this.nKF.getStatus() == 1 && !this.nMn.dWu()) {
            ai(2, true);
            this.nMJ.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mc(int i) {
        if (this.nsP != null) {
            this.nsP.bE(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, String str) {
        if (this.nsP != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nsP.bD(i, str);
        }
    }
}
