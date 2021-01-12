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
/* loaded from: classes7.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bug;
    private TextView bza;
    private final CustomMessageListener gcv;
    private com.baidu.tbadk.core.dialog.a jeq;
    private ForumWriteData jnN;
    private int jxW;
    private ImageView kdU;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String nCc;
    private SelectMusicModel nCg;
    private i nFZ;
    private b nGP;
    protected h nGh;
    private RecordLayout nHG;
    private VideoControllerLayout nHH;
    private RelativeLayout nHI;
    private ImageView nHJ;
    private ImageView nHK;
    private ImageView nHL;
    private PreviewViewContainer nHM;
    private VideoEffectButtonLayout nHN;
    private TextView nHO;
    private RoundProgressBar nHP;
    private TextView nHQ;
    private AnimatorSet nHR;
    private AnimatorSet nHS;
    private ScaleAnimation nHT;
    private ObjectAnimator nHU;
    private ObjectAnimator nHV;
    private int nHW;
    private int nHX;
    private boolean nHY;
    private boolean nHZ = true;
    private l nIa;
    private StickerItem nIb;
    protected j nIc;
    private RecordTabLayout nId;
    private ImageFileInfo nIe;
    private a.InterfaceC0886a nIf;
    private HttpMessageListener nIg;
    private boolean nIh;
    private final CustomMessageListener nIi;
    private com.baidu.tieba.l.g noh;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.noh = kVar.deY();
        }
        if (this.noh != null) {
            this.noh.deH();
        }
        this.nIf = new a.InterfaceC0886a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.a.InterfaceC0886a
            public void gb(List<com.baidu.tieba.video.localvideo.b> list) {
                if (x.isEmpty(list)) {
                    if (RecordVideoActivity.this.nHH != null) {
                        RecordVideoActivity.this.nHH.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nHH != null) {
                    RecordVideoActivity.this.nHH.setHasLocalVideo(true);
                    RecordVideoActivity.this.nHZ = false;
                }
            }
        };
        this.nIg = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nHH != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nHH.setStickerItems(list);
                    }
                }
            }
        };
        this.nIi = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.gcv = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dSc() {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nGh.nEI);
        videoInfo.setVideoDuration(this.nFZ.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nGh.nEI).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str3 = this.jnN == null ? "" : this.jnN.forumName;
        String str4 = this.jnN == null ? "" : this.jnN.forumId;
        int i = this.jnN == null ? -1 : this.jnN.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jnN.writeCallFrom, str3, str4, this.nCc, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setStatisticFrom(this.jnN.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.jnN != null ? this.jnN.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jnN != null ? this.jnN.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.jnN.mFrom);
        if (this.nIc != null) {
            this.nIc.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.noh != null) {
            this.noh.deK();
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
        if (this.nFZ != null && this.nFZ.bvp()) {
            this.nFZ.stopRecord();
        }
        if (this.nCg != null) {
            this.nCg.cancelLoadData();
        }
        if (this.noh != null) {
            this.noh.NO("record");
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
        this.nHW = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nHX = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jnN = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nCc = getIntent().getStringExtra("video_title");
        initUI();
        this.nCg = new SelectMusicModel(getPageContext(), this.nHH);
        this.nCg.dQH();
        this.nIc = new j(this);
        this.nIc.b(this.nCg);
        this.nFZ.a(this.nIc);
        registerListener(this.nIg);
        registerListener(this.nIi);
        registerListener(this.gcv);
        dSd();
        if (Build.VERSION.SDK_INT >= 28 && am.bsp() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dSd() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dSe() {
        com.baidu.tieba.video.localvideo.a aVar = new com.baidu.tieba.video.localvideo.a(this);
        aVar.a(this.nIf);
        aVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nHG = (RecordLayout) findViewById(R.id.root_layout);
        this.nHG.setListener(this);
        this.nFZ = new i(this);
        this.nHH = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nHH.setRecordController(this.nFZ);
        this.nHH.setRecordControlListener(this);
        this.nHH.setEffectChoosedListener(this);
        this.nHI = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.kdU = (ImageView) findViewById(R.id.close_page);
        this.kdU.setOnClickListener(this);
        this.nHJ = (ImageView) findViewById(R.id.flash_switch);
        this.nHJ.setOnClickListener(this);
        this.nHK = (ImageView) findViewById(R.id.camera_switch);
        this.nHK.setOnClickListener(this);
        this.nHL = (ImageView) findViewById(R.id.count_down);
        this.nHL.setOnClickListener(this);
        this.nHM = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nGh = new h(this);
        this.nGh.a(this);
        this.nGh.setFaceIdentifyStateListener(this);
        this.nGh.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dRQ() {
                if (RecordVideoActivity.this.nHH.dSD()) {
                    RecordVideoActivity.this.nHH.a((m) null);
                }
            }
        });
        this.nHN = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nHN.setListener(this);
        this.nFZ.a(this.nHN);
        this.nHN.setViewChoosed(2, true);
        this.bza = (TextView) findViewById(R.id.tv_count_down);
        this.nHO = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bza.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bza.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nHN.setVisibility(8);
        }
        this.bug = findViewById(R.id.progress_layout);
        this.nHP = (RoundProgressBar) this.bug.findViewById(R.id.video_progress);
        this.nHQ = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nHQ.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nHQ.setLayoutParams(layoutParams);
        this.nId = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || x.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Ku(this.nHX);
        } else {
            Ku(1);
        }
        dSf();
    }

    private void Ku(int i) {
        if (this.nId != null) {
            if (i == 0) {
                this.nId.bY(1, getString(R.string.tab_photo));
                this.nId.bY(2, getString(R.string.tab_record));
                this.nId.setListener(this);
                this.nId.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.nId.bY(1, getString(R.string.tab_photo));
                this.nId.setShowIndicator(false);
                this.nId.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.nId.bY(2, getString(R.string.tab_record));
                this.nId.setShowIndicator(false);
                this.nId.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dSf() {
        if (com.baidu.tbadk.core.util.g.brG()) {
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
        this.nGh.onResume();
        this.nGP = this.nGh.dRH();
        if (this.nGP != null) {
            this.nGP.setRecordController(this.nFZ);
            this.nHM.setZoomHelper(this.nGP);
        }
        dSg();
        if (this.nIa == null) {
            this.nIa = new l();
            this.nIa.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gx(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nIb, str2);
                    if (RecordVideoActivity.this.nHH != null) {
                        RecordVideoActivity.this.nHH.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Te(String str) {
                    if (RecordVideoActivity.this.nHH != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nHH.b(stickerItem);
                        if (RecordVideoActivity.this.nGh != null) {
                            RecordVideoActivity.this.nGh.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nHH != null) {
                        RecordVideoActivity.this.nHH.setDownLoadSticker(null);
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
                    recordVideoActivity.bE(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dPV() {
                    if (RecordVideoActivity.this.nHH != null) {
                        RecordVideoActivity.this.nHH.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nIa.dSx();
        if (this.nHH != null && this.nHZ) {
            dSe();
        }
        if (this.noh != null) {
            this.noh.NN("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nGh.onPause();
        if (this.nHH != null) {
            if (this.nFZ != null && this.nFZ.getStatus() == 6) {
                this.nHH.stopRecord();
                dSp();
            }
            if (this.nFZ != null && this.nFZ.bvp()) {
                this.nHH.stopRecord();
            }
        }
        if (this.nIc != null) {
            this.nIc.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nFZ == null || this.nFZ.getStatus() != 7) {
            if (this.nFZ != null && this.nFZ.getStatus() == 6) {
                if (this.nHH != null) {
                    this.nHH.stopRecord();
                }
                dSp();
            } else if (this.nFZ != null && this.nFZ.onBackPressed()) {
                finish();
            } else {
                if (this.jeq == null) {
                    this.jeq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jeq.nu(R.string.video_quit_confirm);
                    this.jeq.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jeq.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jeq.jD(true);
                    this.jeq.b(getPageContext());
                }
                this.jeq.bqe();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nHQ.setVisibility(4);
        if (view == this.kdU) {
            onBackPressed();
        } else if (view == this.nHJ) {
            if (this.nFZ.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nGh.dRK();
            dSg();
        } else if (view == this.nHK) {
            if (this.nFZ.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nHK.setOnClickListener(null);
            this.nGh.dRM();
            if (this.nGh.dRN() && this.nGh.dRL()) {
                this.nGh.dRK();
            }
            dSg();
            this.nHK.setOnClickListener(this);
        } else if (view == this.nHL) {
            dSi();
        }
    }

    private void dSg() {
        if (this.nGh.dRN()) {
            this.nHJ.setVisibility(8);
        } else {
            this.nHJ.setVisibility(0);
        }
        if (this.nGh.dRL()) {
            this.nHJ.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nHJ.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dSh() {
        return this.nHM;
    }

    public void dSi() {
        this.nHQ.setVisibility(4);
        if (this.nFZ.getStatus() != 6) {
            this.nFZ.setStatus(6);
            dSn();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nHT == null) {
                this.nHT = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nHT.setDuration(500L);
                this.nHT.setRepeatCount(5);
                this.nHT.setRepeatMode(2);
                this.nHT.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nHT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nFZ.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bza.setVisibility(0);
                        RecordVideoActivity.this.bza.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bza.setVisibility(8);
                    if (RecordVideoActivity.this.nFZ.getStatus() == 6) {
                        RecordVideoActivity.this.nHH.dSA();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nFZ.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bza.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bza.setText("");
                        }
                    }
                }
            });
            this.bza.setAnimation(this.nHT);
            this.nHT.startNow();
            this.nHH.dSi();
            if (this.nIc != null) {
                this.nIc.dSb();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSj() {
        if (this.nFZ.getStatus() == 1) {
            this.nHQ.setVisibility(4);
            if (this.nFZ.getStatus() != 6) {
                this.nHH.dSj();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSk() {
        this.nHQ.setVisibility(4);
        if (this.nFZ.getStatus() != 6) {
            this.nHH.dSk();
            if (this.nHH.dSE()) {
                dSd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSl() {
        this.nHQ.setVisibility(4);
        if (this.nFZ.getStatus() != 6) {
            this.nHH.dSl();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dSm() {
        this.nHQ.setVisibility(4);
        if (this.nFZ.getStatus() != 6) {
            this.nHH.dSm();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSn() {
        this.nHY = true;
        if (this.nHS != null && this.nHS.isRunning()) {
            this.nHS.cancel();
        }
        if (this.nHR == null) {
            this.nHR = new AnimatorSet();
            this.nHR.playTogether(ObjectAnimator.ofFloat(this.nHI, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nHN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nId, "alpha", 1.0f, 0.0f));
            this.nHR.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nJF) {
                        RecordVideoActivity.this.nHI.setVisibility(8);
                        RecordVideoActivity.this.nHN.setVisibility(8);
                        RecordVideoActivity.this.nId.setVisibility(8);
                    }
                }
            });
            this.nHR.setDuration(300L);
        }
        this.nHR.start();
        this.nHN.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSb() {
        if (this.jxW == 2) {
            if (this.nHY) {
                this.nHY = false;
                if (this.nIc != null) {
                    this.nIc.dSb();
                }
            } else {
                return;
            }
        }
        if (this.nHR != null && this.nHR.isRunning()) {
            this.nHR.cancel();
        }
        if (this.nHS == null) {
            this.nHS = new AnimatorSet();
            this.nHS.playTogether(ObjectAnimator.ofFloat(this.nHI, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nHN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nId, "alpha", 0.0f, 1.0f));
            this.nHS.setDuration(300L);
        }
        this.nHI.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nHN.setVisibility(0);
        }
        if (this.nFZ.getStatus() == 1) {
            this.nId.setVisibility(0);
        }
        this.nHS.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSo() {
        if (this.nGh != null) {
            this.nGh.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void G(boolean z, String str) {
                    RecordVideoActivity.this.nFZ.setStatus(1);
                    RecordVideoActivity.this.dSb();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nIe != null && !x.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nIe)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nIe);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nIe = new ImageFileInfo();
                        RecordVideoActivity.this.nIe.setFilePath(str);
                        RecordVideoActivity.this.nIe.setContentUriStr(null);
                        RecordVideoActivity.this.nIe.setTempFile(true);
                        RecordVideoActivity.this.nIe.setAlbumnId(null);
                        RecordVideoActivity.this.nIe.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nIe);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jnN, RecordVideoActivity.this.nHW)));
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
    public void dSp() {
        this.nHT.cancel();
        this.nHT.setAnimationListener(null);
        this.bza.clearAnimation();
        this.bza.setVisibility(8);
        if (this.nIc != null) {
            this.nIc.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSq() {
        dJJ();
    }

    private void dJJ() {
        if (this.nHU != null) {
            this.nHU.cancel();
        }
        if (this.nHV == null) {
            this.nHV = ObjectAnimator.ofFloat(this.nId, "alpha", 1.0f, 0.0f);
            this.nHV.setDuration(500L);
            this.nHV.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nJF) {
                        RecordVideoActivity.this.nId.setVisibility(8);
                    }
                }
            });
        }
        this.nHV.start();
    }

    private void dJI() {
        if (this.nHV != null) {
            this.nHV.cancel();
        }
        if (this.nHU == null) {
            this.nHU = ObjectAnimator.ofFloat(this.nId, "alpha", 0.0f, 1.0f);
            this.nHU.setDuration(500L);
        }
        this.nId.setVisibility(0);
        this.nHU.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSr() {
        this.nHN.reset();
        if (this.nFZ.getStatus() == 1) {
            dJI();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSs() {
        if (this.bug.getVisibility() != 0) {
            this.nHH.dSz();
            this.nFZ.setStatus(8);
            dSb();
            if (this.nGh.nGN != null && this.nGh.nGN.size() > 0) {
                this.bug.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nIk = 50;
        final int nIl = 1;
        Handler nIm = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AnonymousClass3.this.mProgress >= 0) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nHP.R(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dSw();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dSw() {
            if (this.mProgress >= 0) {
                this.nIm.sendEmptyMessageDelayed(1, 50L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dSw();
            boolean z = RecordVideoActivity.this.nIc == null || TextUtils.isEmpty(RecordVideoActivity.this.nIc.dSa()) || !new File(RecordVideoActivity.this.nIc.dSa()).exists();
            if (RecordVideoActivity.this.nGh.nGN.size() > 1) {
                return com.baidu.tieba.video.meida.h.dRn().a(RecordVideoActivity.this.nGh.nGN, RecordVideoActivity.this.nGh.dRE(), z);
            }
            File file = new File(RecordVideoActivity.this.nGh.nGN.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nGh.dRE());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dRn().a(RecordVideoActivity.this.nGh.nGN, RecordVideoActivity.this.nGh.dRE(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            this.mProgress = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.nHH.dSF();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dSc();
                    RecordVideoActivity.this.Kv(102);
                    RecordVideoActivity.this.bug.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dSc();
                RecordVideoActivity.this.Kv(102);
                RecordVideoActivity.this.bug.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bug.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bE(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nHP.R(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nHH == null || x.isEmpty(this.nHH.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nHH.getChoosedBeautyList()) {
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
        if (this.nHH == null || x.isEmpty(this.nHH.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nHH.getChoosedFilterList()) {
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
        if (this.nHH == null || x.isEmpty(this.nHH.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nHH.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSt() {
        this.nHQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSu() {
        this.nHQ.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dSv() {
        if (this.nFZ.getStatus() == 1) {
            this.nId.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nGh != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nGh.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").an("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nHN.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nHN.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nGh.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dW("obj_id", (String) eVar.getValue());
                        if (this.nFZ.getStatus() == 1) {
                            aqVar.an("obj_type", 1);
                        } else {
                            aqVar.an("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nHN.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nHN.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nIc.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nHN.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nHN.setViewChoosed(0, true);
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
            this.nIb = stickerItem;
            this.nIa.TC(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nGh != null) {
                    this.nGh.setSticker(null);
                    this.nIh = false;
                }
                if (this.nHH != null) {
                    this.nHH.setDownLoadSticker(null);
                }
                this.nHO.setVisibility(8);
                this.nHN.setViewChoosed(1, false);
                return;
            }
            String Tz = this.nIa.Tz(stickerItem.resource);
            if (!StringUtils.isNull(Tz)) {
                a(stickerItem, Tz);
                if (this.nHH != null) {
                    this.nHH.setDownLoadSticker(null);
                }
            } else {
                if (this.nHH != null) {
                    this.nHH.setDownLoadSticker(stickerItem);
                }
                this.nIa.TA(stickerItem.resource);
            }
            this.nHN.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nGh != null) {
                this.nGh.setSticker(stickerItem);
                this.nIh = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nHO.setText(stickerItem.desc);
                this.nHO.setVisibility(0);
                this.nHO.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nHO.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nHO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dC(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nHH.getLayoutParams();
            layoutParams.height = i4;
            this.nHH.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Tk = com.baidu.tieba.video.editvideo.model.a.dQB().Tk(stringExtra);
                if (this.nIc != null && !TextUtils.isEmpty(Tk)) {
                    this.nIc.gA(Tk, stringExtra2);
                    this.nHH.dRs();
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
        if (this.nFZ.getStatus() == 8) {
            this.nHH.dSy();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yL(boolean z) {
        if (this.nFZ != null && (this.nFZ.getStatus() == 1 || this.nFZ.getStatus() == 3 || this.nFZ.getStatus() == 4)) {
            if (!z && this.nIh) {
                this.nHM.dRR();
                return;
            } else {
                this.nHM.dRS();
                return;
            }
        }
        this.nHM.dRS();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.jxW != i) {
            switch (i) {
                case 1:
                    if (this.nIc != null) {
                        this.nIc.bfG();
                    }
                    this.nGh.setFilter("origin");
                    this.nHN.setViewChoosed(0, false);
                    this.nHN.setViewChoosed(3, false);
                    this.nHH.Kx(1);
                    this.nHN.setViewVisibility(0, 8);
                    this.nHN.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nHN.setViewVisibility(0, 0);
                    this.nHN.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jxW = i;
            this.nHH.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().an("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dRZ() {
        if (this.nFZ.getStatus() == 1 && !this.nHH.dSD()) {
            ai(1, true);
            this.nId.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dRY() {
        if (this.nFZ.getStatus() == 1 && !this.nHH.dSD()) {
            ai(2, true);
            this.nId.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv(int i) {
        if (this.noh != null) {
            this.noh.bF(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(int i, String str) {
        if (this.noh != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.noh.bE(i, str);
        }
    }
}
