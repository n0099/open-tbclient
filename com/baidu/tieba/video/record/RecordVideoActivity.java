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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.y;
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
    private TextView bCG;
    private View bVD;
    private final CustomMessageListener geK;
    private ImageView ixA;
    private int jDB;
    private com.baidu.tbadk.core.dialog.a jjX;
    private ForumWriteData jtt;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String nLN;
    private SelectMusicModel nLR;
    private i nPJ;
    protected h nPR;
    private b nQx;
    private AnimatorSet nRA;
    private ScaleAnimation nRB;
    private ObjectAnimator nRC;
    private ObjectAnimator nRD;
    private int nRE;
    private int nRF;
    private boolean nRG;
    private boolean nRH = true;
    private l nRI;
    private StickerItem nRJ;
    protected j nRK;
    private RecordTabLayout nRL;
    private ImageFileInfo nRM;
    private a.InterfaceC0889a nRN;
    private HttpMessageListener nRO;
    private boolean nRP;
    private final CustomMessageListener nRQ;
    private RecordLayout nRo;
    private VideoControllerLayout nRp;
    private RelativeLayout nRq;
    private ImageView nRr;
    private ImageView nRs;
    private ImageView nRt;
    private PreviewViewContainer nRu;
    private VideoEffectButtonLayout nRv;
    private TextView nRw;
    private RoundProgressBar nRx;
    private TextView nRy;
    private AnimatorSet nRz;
    private com.baidu.tieba.l.g nxU;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nxU = kVar.dgY();
        }
        if (this.nxU != null) {
            this.nxU.dgH();
        }
        this.nRN = new a.InterfaceC0889a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.a.InterfaceC0889a
            public void fZ(List<com.baidu.tieba.video.localvideo.b> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nRp != null) {
                        RecordVideoActivity.this.nRp.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nRp != null) {
                    RecordVideoActivity.this.nRp.setHasLocalVideo(true);
                    RecordVideoActivity.this.nRH = false;
                }
            }
        };
        this.nRO = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nRp != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nRp.setStickerItems(list);
                    }
                }
            }
        };
        this.nRQ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.geK = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dUn() {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nPR.nOt);
        videoInfo.setVideoDuration(this.nPJ.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(960);
        videoInfo.setVideoLength(new File(this.nPR.nOt).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str3 = this.jtt == null ? "" : this.jtt.forumName;
        String str4 = this.jtt == null ? "" : this.jtt.forumId;
        int i = this.jtt == null ? -1 : this.jtt.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jtt.writeCallFrom, str3, str4, this.nLN, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setStatisticFrom(this.jtt.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.jtt != null ? this.jtt.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jtt != null ? this.jtt.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.jtt.mFrom);
        if (this.nRK != null) {
            this.nRK.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nxU != null) {
            this.nxU.dgK();
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
        if (this.nPJ != null && this.nPJ.isRecording()) {
            this.nPJ.stopRecord();
        }
        if (this.nLR != null) {
            this.nLR.cancelLoadData();
        }
        if (this.nxU != null) {
            this.nxU.OD("record");
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
        this.nRE = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nRF = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jtt = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nLN = getIntent().getStringExtra("video_title");
        initUI();
        this.nLR = new SelectMusicModel(getPageContext(), this.nRp);
        this.nLR.dSS();
        this.nRK = new j(this);
        this.nRK.b(this.nLR);
        this.nPJ.a(this.nRK);
        registerListener(this.nRO);
        registerListener(this.nRQ);
        registerListener(this.geK);
        dUo();
        if (Build.VERSION.SDK_INT >= 28 && an.bsJ() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dUo() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dUp() {
        com.baidu.tieba.video.localvideo.a aVar = new com.baidu.tieba.video.localvideo.a(this);
        aVar.a(this.nRN);
        aVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nRo = (RecordLayout) findViewById(R.id.root_layout);
        this.nRo.setListener(this);
        this.nPJ = new i(this);
        this.nRp = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nRp.setRecordController(this.nPJ);
        this.nRp.setRecordControlListener(this);
        this.nRp.setEffectChoosedListener(this);
        this.nRq = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.ixA = (ImageView) findViewById(R.id.close_page);
        this.ixA.setOnClickListener(this);
        this.nRr = (ImageView) findViewById(R.id.flash_switch);
        this.nRr.setOnClickListener(this);
        this.nRs = (ImageView) findViewById(R.id.camera_switch);
        this.nRs.setOnClickListener(this);
        this.nRt = (ImageView) findViewById(R.id.count_down);
        this.nRt.setOnClickListener(this);
        this.nRu = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nPR = new h(this);
        this.nPR.a(this);
        this.nPR.setFaceIdentifyStateListener(this);
        this.nPR.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dUb() {
                if (RecordVideoActivity.this.nRp.dUO()) {
                    RecordVideoActivity.this.nRp.a((m) null);
                }
            }
        });
        this.nRv = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nRv.setListener(this);
        this.nPJ.a(this.nRv);
        this.nRv.setViewChoosed(2, true);
        this.bCG = (TextView) findViewById(R.id.tv_count_down);
        this.nRw = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bCG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bCG.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nRv.setVisibility(8);
        }
        this.bVD = findViewById(R.id.progress_layout);
        this.nRx = (RoundProgressBar) this.bVD.findViewById(R.id.video_progress);
        this.nRy = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nRy.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nRy.setLayoutParams(layoutParams);
        this.nRL = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            KO(this.nRF);
        } else {
            KO(1);
        }
        dUq();
    }

    private void KO(int i) {
        if (this.nRL != null) {
            if (i == 0) {
                this.nRL.cf(1, getString(R.string.tab_photo));
                this.nRL.cf(2, getString(R.string.tab_record));
                this.nRL.setListener(this);
                this.nRL.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.nRL.cf(1, getString(R.string.tab_photo));
                this.nRL.setShowIndicator(false);
                this.nRL.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.nRL.cf(2, getString(R.string.tab_record));
                this.nRL.setShowIndicator(false);
                this.nRL.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dUq() {
        if (com.baidu.tbadk.core.util.g.brZ()) {
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
        this.nPR.onResume();
        this.nQx = this.nPR.dTS();
        if (this.nQx != null) {
            this.nQx.setRecordController(this.nPJ);
            this.nRu.setZoomHelper(this.nQx);
        }
        dUr();
        if (this.nRI == null) {
            this.nRI = new l();
            this.nRI.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gD(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nRJ, str2);
                    if (RecordVideoActivity.this.nRp != null) {
                        RecordVideoActivity.this.nRp.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Uc(String str) {
                    if (RecordVideoActivity.this.nRp != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nRp.b(stickerItem);
                        if (RecordVideoActivity.this.nPR != null) {
                            RecordVideoActivity.this.nPR.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nRp != null) {
                        RecordVideoActivity.this.nRp.setDownLoadSticker(null);
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
                    recordVideoActivity.bK(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dSg() {
                    if (RecordVideoActivity.this.nRp != null) {
                        RecordVideoActivity.this.nRp.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nRI.dUI();
        if (this.nRp != null && this.nRH) {
            dUp();
        }
        if (this.nxU != null) {
            this.nxU.OC("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nPR.onPause();
        if (this.nRp != null) {
            if (this.nPJ != null && this.nPJ.getStatus() == 6) {
                this.nRp.stopRecord();
                dUA();
            }
            if (this.nPJ != null && this.nPJ.isRecording()) {
                this.nRp.stopRecord();
            }
        }
        if (this.nRK != null) {
            this.nRK.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nPJ == null || this.nPJ.getStatus() != 7) {
            if (this.nPJ != null && this.nPJ.getStatus() == 6) {
                if (this.nRp != null) {
                    this.nRp.stopRecord();
                }
                dUA();
            } else if (this.nPJ != null && this.nPJ.onBackPressed()) {
                finish();
            } else {
                if (this.jjX == null) {
                    this.jjX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jjX.nx(R.string.video_quit_confirm);
                    this.jjX.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jjX.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jjX.jF(true);
                    this.jjX.b(getPageContext());
                }
                this.jjX.bqx();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nRy.setVisibility(4);
        if (view == this.ixA) {
            onBackPressed();
        } else if (view == this.nRr) {
            if (this.nPJ.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nPR.dTV();
            dUr();
        } else if (view == this.nRs) {
            if (this.nPJ.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nRs.setOnClickListener(null);
            this.nPR.dTX();
            if (this.nPR.dTY() && this.nPR.dTW()) {
                this.nPR.dTV();
            }
            dUr();
            this.nRs.setOnClickListener(this);
        } else if (view == this.nRt) {
            dUt();
        }
    }

    private void dUr() {
        if (this.nPR.dTY()) {
            this.nRr.setVisibility(8);
        } else {
            this.nRr.setVisibility(0);
        }
        if (this.nPR.dTW()) {
            this.nRr.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nRr.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dUs() {
        return this.nRu;
    }

    public void dUt() {
        this.nRy.setVisibility(4);
        if (this.nPJ.getStatus() != 6) {
            this.nPJ.setStatus(6);
            dUy();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nRB == null) {
                this.nRB = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nRB.setDuration(500L);
                this.nRB.setRepeatCount(5);
                this.nRB.setRepeatMode(2);
                this.nRB.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nRB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nPJ.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bCG.setVisibility(0);
                        RecordVideoActivity.this.bCG.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bCG.setVisibility(8);
                    if (RecordVideoActivity.this.nPJ.getStatus() == 6) {
                        RecordVideoActivity.this.nRp.dUL();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nPJ.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bCG.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bCG.setText("");
                        }
                    }
                }
            });
            this.bCG.setAnimation(this.nRB);
            this.nRB.startNow();
            this.nRp.dUt();
            if (this.nRK != null) {
                this.nRK.dUm();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUu() {
        if (this.nPJ.getStatus() == 1) {
            this.nRy.setVisibility(4);
            if (this.nPJ.getStatus() != 6) {
                this.nRp.dUu();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUv() {
        this.nRy.setVisibility(4);
        if (this.nPJ.getStatus() != 6) {
            this.nRp.dUv();
            if (this.nRp.dUP()) {
                dUo();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUw() {
        this.nRy.setVisibility(4);
        if (this.nPJ.getStatus() != 6) {
            this.nRp.dUw();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUx() {
        this.nRy.setVisibility(4);
        if (this.nPJ.getStatus() != 6) {
            this.nRp.dUx();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUy() {
        this.nRG = true;
        if (this.nRA != null && this.nRA.isRunning()) {
            this.nRA.cancel();
        }
        if (this.nRz == null) {
            this.nRz = new AnimatorSet();
            this.nRz.playTogether(ObjectAnimator.ofFloat(this.nRq, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nRv, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nRL, "alpha", 1.0f, 0.0f));
            this.nRz.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTn) {
                        RecordVideoActivity.this.nRq.setVisibility(8);
                        RecordVideoActivity.this.nRv.setVisibility(8);
                        RecordVideoActivity.this.nRL.setVisibility(8);
                    }
                }
            });
            this.nRz.setDuration(300L);
        }
        this.nRz.start();
        this.nRv.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUm() {
        if (this.jDB == 2) {
            if (this.nRG) {
                this.nRG = false;
                if (this.nRK != null) {
                    this.nRK.dUm();
                }
            } else {
                return;
            }
        }
        if (this.nRz != null && this.nRz.isRunning()) {
            this.nRz.cancel();
        }
        if (this.nRA == null) {
            this.nRA = new AnimatorSet();
            this.nRA.playTogether(ObjectAnimator.ofFloat(this.nRq, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nRv, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nRL, "alpha", 0.0f, 1.0f));
            this.nRA.setDuration(300L);
        }
        this.nRq.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nRv.setVisibility(0);
        }
        if (this.nPJ.getStatus() == 1) {
            this.nRL.setVisibility(0);
        }
        this.nRA.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUz() {
        if (this.nPR != null) {
            this.nPR.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void O(boolean z, String str) {
                    RecordVideoActivity.this.nPJ.setStatus(1);
                    RecordVideoActivity.this.dUm();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nRM != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nRM)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nRM);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nRM = new ImageFileInfo();
                        RecordVideoActivity.this.nRM.setFilePath(str);
                        RecordVideoActivity.this.nRM.setContentUriStr(null);
                        RecordVideoActivity.this.nRM.setTempFile(true);
                        RecordVideoActivity.this.nRM.setAlbumnId(null);
                        RecordVideoActivity.this.nRM.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nRM);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jtt, RecordVideoActivity.this.nRE)));
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
    public void dUA() {
        this.nRB.cancel();
        this.nRB.setAnimationListener(null);
        this.bCG.clearAnimation();
        this.bCG.setVisibility(8);
        if (this.nRK != null) {
            this.nRK.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUB() {
        dLU();
    }

    private void dLU() {
        if (this.nRC != null) {
            this.nRC.cancel();
        }
        if (this.nRD == null) {
            this.nRD = ObjectAnimator.ofFloat(this.nRL, "alpha", 1.0f, 0.0f);
            this.nRD.setDuration(500L);
            this.nRD.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTn) {
                        RecordVideoActivity.this.nRL.setVisibility(8);
                    }
                }
            });
        }
        this.nRD.start();
    }

    private void dLT() {
        if (this.nRD != null) {
            this.nRD.cancel();
        }
        if (this.nRC == null) {
            this.nRC = ObjectAnimator.ofFloat(this.nRL, "alpha", 0.0f, 1.0f);
            this.nRC.setDuration(500L);
        }
        this.nRL.setVisibility(0);
        this.nRC.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUC() {
        this.nRv.reset();
        if (this.nPJ.getStatus() == 1) {
            dLT();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUD() {
        if (this.bVD.getVisibility() != 0) {
            this.nRp.dUK();
            this.nPJ.setStatus(8);
            dUm();
            if (this.nPR.nQv != null && this.nPR.nQv.size() > 0) {
                this.bVD.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nRS = 50;
        final int nRT = 1;
        Handler nRU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AnonymousClass3.this.mProgress >= 0) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nRx.S(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dUH();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dUH() {
            if (this.mProgress >= 0) {
                this.nRU.sendEmptyMessageDelayed(1, 50L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dUH();
            boolean z = RecordVideoActivity.this.nRK == null || TextUtils.isEmpty(RecordVideoActivity.this.nRK.dUl()) || !new File(RecordVideoActivity.this.nRK.dUl()).exists();
            if (RecordVideoActivity.this.nPR.nQv.size() > 1) {
                return com.baidu.tieba.video.meida.h.dTy().a(RecordVideoActivity.this.nPR.nQv, RecordVideoActivity.this.nPR.dTP(), z);
            }
            File file = new File(RecordVideoActivity.this.nPR.nQv.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    o.copyFile(file.getPath(), RecordVideoActivity.this.nPR.dTP());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dTy().a(RecordVideoActivity.this.nPR.nQv, RecordVideoActivity.this.nPR.dTP(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            this.mProgress = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.nRp.dUQ();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dUn();
                    RecordVideoActivity.this.KP(102);
                    RecordVideoActivity.this.bVD.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dUn();
                RecordVideoActivity.this.KP(102);
                RecordVideoActivity.this.bVD.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bVD.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bK(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nRx.S(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nRp == null || y.isEmpty(this.nRp.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nRp.getChoosedBeautyList()) {
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
        if (this.nRp == null || y.isEmpty(this.nRp.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nRp.getChoosedFilterList()) {
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
        if (this.nRp == null || y.isEmpty(this.nRp.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nRp.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUE() {
        this.nRy.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUF() {
        this.nRy.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUG() {
        if (this.nPJ.getStatus() == 1) {
            this.nRL.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nPR != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nPR.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ar("c12421").ap("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nRv.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nRv.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nPR.setFilter((String) eVar.getValue());
                        ar arVar = new ar("c12496");
                        arVar.dR("obj_id", (String) eVar.getValue());
                        if (this.nPJ.getStatus() == 1) {
                            arVar.ap("obj_type", 1);
                        } else {
                            arVar.ap("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nRv.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nRv.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nRK.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nRv.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nRv.setViewChoosed(0, true);
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
            this.nRJ = stickerItem;
            this.nRI.UA(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nPR != null) {
                    this.nPR.setSticker(null);
                    this.nRP = false;
                }
                if (this.nRp != null) {
                    this.nRp.setDownLoadSticker(null);
                }
                this.nRw.setVisibility(8);
                this.nRv.setViewChoosed(1, false);
                return;
            }
            String Ux = this.nRI.Ux(stickerItem.resource);
            if (!StringUtils.isNull(Ux)) {
                a(stickerItem, Ux);
                if (this.nRp != null) {
                    this.nRp.setDownLoadSticker(null);
                }
            } else {
                if (this.nRp != null) {
                    this.nRp.setDownLoadSticker(stickerItem);
                }
                this.nRI.Uy(stickerItem.resource);
            }
            this.nRv.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nPR != null) {
                this.nPR.setSticker(stickerItem);
                this.nRP = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nRw.setText(stickerItem.desc);
                this.nRw.setVisibility(0);
                this.nRw.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nRw.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nRw.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dz(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nRp.getLayoutParams();
            layoutParams.height = i4;
            this.nRp.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ui = com.baidu.tieba.video.editvideo.model.a.dSM().Ui(stringExtra);
                if (this.nRK != null && !TextUtils.isEmpty(Ui)) {
                    this.nRK.gG(Ui, stringExtra2);
                    this.nRp.dTD();
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
        if (this.nPJ.getStatus() == 8) {
            this.nRp.dUJ();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void ze(boolean z) {
        if (this.nPJ != null && (this.nPJ.getStatus() == 1 || this.nPJ.getStatus() == 3 || this.nPJ.getStatus() == 4)) {
            if (!z && this.nRP) {
                this.nRu.dUc();
                return;
            } else {
                this.nRu.dUd();
                return;
            }
        }
        this.nRu.dUd();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.jDB != i) {
            switch (i) {
                case 1:
                    if (this.nRK != null) {
                        this.nRK.bfT();
                    }
                    this.nPR.setFilter("origin");
                    this.nRv.setViewChoosed(0, false);
                    this.nRv.setViewChoosed(3, false);
                    this.nRp.KR(1);
                    this.nRv.setViewVisibility(0, 8);
                    this.nRv.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nRv.setViewVisibility(0, 0);
                    this.nRv.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jDB = i;
            this.nRp.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ar().ap("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dUk() {
        if (this.nPJ.getStatus() == 1 && !this.nRp.dUO()) {
            ai(1, true);
            this.nRL.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dUj() {
        if (this.nPJ.getStatus() == 1 && !this.nRp.dUO()) {
            ai(2, true);
            this.nRL.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KP(int i) {
        if (this.nxU != null) {
            this.nxU.bL(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(int i, String str) {
        if (this.nxU != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nxU.bK(i, str);
        }
    }
}
