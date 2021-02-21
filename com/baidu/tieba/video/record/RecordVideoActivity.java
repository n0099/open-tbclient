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
    private final CustomMessageListener geP;
    private ImageView ixO;
    private int jDP;
    private com.baidu.tbadk.core.dialog.a jkl;
    private ForumWriteData jtH;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String nMn;
    private SelectMusicModel nMr;
    private b nQX;
    private i nQj;
    protected h nQr;
    private RecordLayout nRO;
    private VideoControllerLayout nRP;
    private RelativeLayout nRQ;
    private ImageView nRR;
    private ImageView nRS;
    private ImageView nRT;
    private PreviewViewContainer nRU;
    private VideoEffectButtonLayout nRV;
    private TextView nRW;
    private RoundProgressBar nRX;
    private TextView nRY;
    private AnimatorSet nRZ;
    private AnimatorSet nSa;
    private ScaleAnimation nSb;
    private ObjectAnimator nSc;
    private ObjectAnimator nSd;
    private int nSe;
    private int nSf;
    private boolean nSg;
    private boolean nSh = true;
    private l nSi;
    private StickerItem nSj;
    protected j nSk;
    private RecordTabLayout nSl;
    private ImageFileInfo nSm;
    private a.InterfaceC0891a nSn;
    private HttpMessageListener nSo;
    private boolean nSp;
    private final CustomMessageListener nSq;
    private com.baidu.tieba.l.g nyu;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nyu = kVar.dhf();
        }
        if (this.nyu != null) {
            this.nyu.dgO();
        }
        this.nSn = new a.InterfaceC0891a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.a.InterfaceC0891a
            public void fZ(List<com.baidu.tieba.video.localvideo.b> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nRP != null) {
                        RecordVideoActivity.this.nRP.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nRP != null) {
                    RecordVideoActivity.this.nRP.setHasLocalVideo(true);
                    RecordVideoActivity.this.nSh = false;
                }
            }
        };
        this.nSo = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nRP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nRP.setStickerItems(list);
                    }
                }
            }
        };
        this.nSq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.geP = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dUv() {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nQr.nOT);
        videoInfo.setVideoDuration(this.nQj.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(960);
        videoInfo.setVideoLength(new File(this.nQr.nOT).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str3 = this.jtH == null ? "" : this.jtH.forumName;
        String str4 = this.jtH == null ? "" : this.jtH.forumId;
        int i = this.jtH == null ? -1 : this.jtH.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jtH.writeCallFrom, str3, str4, this.nMn, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setStatisticFrom(this.jtH.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.jtH != null ? this.jtH.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jtH != null ? this.jtH.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.jtH.mFrom);
        if (this.nSk != null) {
            this.nSk.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nyu != null) {
            this.nyu.dgR();
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
        if (this.nQj != null && this.nQj.isRecording()) {
            this.nQj.stopRecord();
        }
        if (this.nMr != null) {
            this.nMr.cancelLoadData();
        }
        if (this.nyu != null) {
            this.nyu.OE("record");
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
        this.nSe = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nSf = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jtH = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nMn = getIntent().getStringExtra("video_title");
        initUI();
        this.nMr = new SelectMusicModel(getPageContext(), this.nRP);
        this.nMr.dTa();
        this.nSk = new j(this);
        this.nSk.b(this.nMr);
        this.nQj.a(this.nSk);
        registerListener(this.nSo);
        registerListener(this.nSq);
        registerListener(this.geP);
        dUw();
        if (Build.VERSION.SDK_INT >= 28 && an.bsJ() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dUw() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dUx() {
        com.baidu.tieba.video.localvideo.a aVar = new com.baidu.tieba.video.localvideo.a(this);
        aVar.a(this.nSn);
        aVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nRO = (RecordLayout) findViewById(R.id.root_layout);
        this.nRO.setListener(this);
        this.nQj = new i(this);
        this.nRP = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nRP.setRecordController(this.nQj);
        this.nRP.setRecordControlListener(this);
        this.nRP.setEffectChoosedListener(this);
        this.nRQ = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.ixO = (ImageView) findViewById(R.id.close_page);
        this.ixO.setOnClickListener(this);
        this.nRR = (ImageView) findViewById(R.id.flash_switch);
        this.nRR.setOnClickListener(this);
        this.nRS = (ImageView) findViewById(R.id.camera_switch);
        this.nRS.setOnClickListener(this);
        this.nRT = (ImageView) findViewById(R.id.count_down);
        this.nRT.setOnClickListener(this);
        this.nRU = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nQr = new h(this);
        this.nQr.a(this);
        this.nQr.setFaceIdentifyStateListener(this);
        this.nQr.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dUj() {
                if (RecordVideoActivity.this.nRP.dUW()) {
                    RecordVideoActivity.this.nRP.a((m) null);
                }
            }
        });
        this.nRV = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nRV.setListener(this);
        this.nQj.a(this.nRV);
        this.nRV.setViewChoosed(2, true);
        this.bCG = (TextView) findViewById(R.id.tv_count_down);
        this.nRW = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bCG.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bCG.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nRV.setVisibility(8);
        }
        this.bVD = findViewById(R.id.progress_layout);
        this.nRX = (RoundProgressBar) this.bVD.findViewById(R.id.video_progress);
        this.nRY = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nRY.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nRY.setLayoutParams(layoutParams);
        this.nSl = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            KO(this.nSf);
        } else {
            KO(1);
        }
        dUy();
    }

    private void KO(int i) {
        if (this.nSl != null) {
            if (i == 0) {
                this.nSl.cf(1, getString(R.string.tab_photo));
                this.nSl.cf(2, getString(R.string.tab_record));
                this.nSl.setListener(this);
                this.nSl.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.nSl.cf(1, getString(R.string.tab_photo));
                this.nSl.setShowIndicator(false);
                this.nSl.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.nSl.cf(2, getString(R.string.tab_record));
                this.nSl.setShowIndicator(false);
                this.nSl.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dUy() {
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
        this.nQr.onResume();
        this.nQX = this.nQr.dUa();
        if (this.nQX != null) {
            this.nQX.setRecordController(this.nQj);
            this.nRU.setZoomHelper(this.nQX);
        }
        dUz();
        if (this.nSi == null) {
            this.nSi = new l();
            this.nSi.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gF(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nSj, str2);
                    if (RecordVideoActivity.this.nRP != null) {
                        RecordVideoActivity.this.nRP.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Uo(String str) {
                    if (RecordVideoActivity.this.nRP != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nRP.b(stickerItem);
                        if (RecordVideoActivity.this.nQr != null) {
                            RecordVideoActivity.this.nQr.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nRP != null) {
                        RecordVideoActivity.this.nRP.setDownLoadSticker(null);
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
                public void dSo() {
                    if (RecordVideoActivity.this.nRP != null) {
                        RecordVideoActivity.this.nRP.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nSi.dUQ();
        if (this.nRP != null && this.nSh) {
            dUx();
        }
        if (this.nyu != null) {
            this.nyu.OD("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nQr.onPause();
        if (this.nRP != null) {
            if (this.nQj != null && this.nQj.getStatus() == 6) {
                this.nRP.stopRecord();
                dUI();
            }
            if (this.nQj != null && this.nQj.isRecording()) {
                this.nRP.stopRecord();
            }
        }
        if (this.nSk != null) {
            this.nSk.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nQj == null || this.nQj.getStatus() != 7) {
            if (this.nQj != null && this.nQj.getStatus() == 6) {
                if (this.nRP != null) {
                    this.nRP.stopRecord();
                }
                dUI();
            } else if (this.nQj != null && this.nQj.onBackPressed()) {
                finish();
            } else {
                if (this.jkl == null) {
                    this.jkl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jkl.nx(R.string.video_quit_confirm);
                    this.jkl.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jkl.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jkl.jF(true);
                    this.jkl.b(getPageContext());
                }
                this.jkl.bqx();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nRY.setVisibility(4);
        if (view == this.ixO) {
            onBackPressed();
        } else if (view == this.nRR) {
            if (this.nQj.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nQr.dUd();
            dUz();
        } else if (view == this.nRS) {
            if (this.nQj.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nRS.setOnClickListener(null);
            this.nQr.dUf();
            if (this.nQr.dUg() && this.nQr.dUe()) {
                this.nQr.dUd();
            }
            dUz();
            this.nRS.setOnClickListener(this);
        } else if (view == this.nRT) {
            dUB();
        }
    }

    private void dUz() {
        if (this.nQr.dUg()) {
            this.nRR.setVisibility(8);
        } else {
            this.nRR.setVisibility(0);
        }
        if (this.nQr.dUe()) {
            this.nRR.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nRR.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dUA() {
        return this.nRU;
    }

    public void dUB() {
        this.nRY.setVisibility(4);
        if (this.nQj.getStatus() != 6) {
            this.nQj.setStatus(6);
            dUG();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nSb == null) {
                this.nSb = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nSb.setDuration(500L);
                this.nSb.setRepeatCount(5);
                this.nSb.setRepeatMode(2);
                this.nSb.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nSb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nQj.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bCG.setVisibility(0);
                        RecordVideoActivity.this.bCG.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bCG.setVisibility(8);
                    if (RecordVideoActivity.this.nQj.getStatus() == 6) {
                        RecordVideoActivity.this.nRP.dUT();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nQj.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bCG.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bCG.setText("");
                        }
                    }
                }
            });
            this.bCG.setAnimation(this.nSb);
            this.nSb.startNow();
            this.nRP.dUB();
            if (this.nSk != null) {
                this.nSk.dUu();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUC() {
        if (this.nQj.getStatus() == 1) {
            this.nRY.setVisibility(4);
            if (this.nQj.getStatus() != 6) {
                this.nRP.dUC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUD() {
        this.nRY.setVisibility(4);
        if (this.nQj.getStatus() != 6) {
            this.nRP.dUD();
            if (this.nRP.dUX()) {
                dUw();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUE() {
        this.nRY.setVisibility(4);
        if (this.nQj.getStatus() != 6) {
            this.nRP.dUE();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUF() {
        this.nRY.setVisibility(4);
        if (this.nQj.getStatus() != 6) {
            this.nRP.dUF();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUG() {
        this.nSg = true;
        if (this.nSa != null && this.nSa.isRunning()) {
            this.nSa.cancel();
        }
        if (this.nRZ == null) {
            this.nRZ = new AnimatorSet();
            this.nRZ.playTogether(ObjectAnimator.ofFloat(this.nRQ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nRV, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nSl, "alpha", 1.0f, 0.0f));
            this.nRZ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTN) {
                        RecordVideoActivity.this.nRQ.setVisibility(8);
                        RecordVideoActivity.this.nRV.setVisibility(8);
                        RecordVideoActivity.this.nSl.setVisibility(8);
                    }
                }
            });
            this.nRZ.setDuration(300L);
        }
        this.nRZ.start();
        this.nRV.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUu() {
        if (this.jDP == 2) {
            if (this.nSg) {
                this.nSg = false;
                if (this.nSk != null) {
                    this.nSk.dUu();
                }
            } else {
                return;
            }
        }
        if (this.nRZ != null && this.nRZ.isRunning()) {
            this.nRZ.cancel();
        }
        if (this.nSa == null) {
            this.nSa = new AnimatorSet();
            this.nSa.playTogether(ObjectAnimator.ofFloat(this.nRQ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nRV, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nSl, "alpha", 0.0f, 1.0f));
            this.nSa.setDuration(300L);
        }
        this.nRQ.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nRV.setVisibility(0);
        }
        if (this.nQj.getStatus() == 1) {
            this.nSl.setVisibility(0);
        }
        this.nSa.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUH() {
        if (this.nQr != null) {
            this.nQr.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void O(boolean z, String str) {
                    RecordVideoActivity.this.nQj.setStatus(1);
                    RecordVideoActivity.this.dUu();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nSm != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nSm)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nSm);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nSm = new ImageFileInfo();
                        RecordVideoActivity.this.nSm.setFilePath(str);
                        RecordVideoActivity.this.nSm.setContentUriStr(null);
                        RecordVideoActivity.this.nSm.setTempFile(true);
                        RecordVideoActivity.this.nSm.setAlbumnId(null);
                        RecordVideoActivity.this.nSm.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nSm);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jtH, RecordVideoActivity.this.nSe)));
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
    public void dUI() {
        this.nSb.cancel();
        this.nSb.setAnimationListener(null);
        this.bCG.clearAnimation();
        this.bCG.setVisibility(8);
        if (this.nSk != null) {
            this.nSk.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUJ() {
        dMc();
    }

    private void dMc() {
        if (this.nSc != null) {
            this.nSc.cancel();
        }
        if (this.nSd == null) {
            this.nSd = ObjectAnimator.ofFloat(this.nSl, "alpha", 1.0f, 0.0f);
            this.nSd.setDuration(500L);
            this.nSd.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nTN) {
                        RecordVideoActivity.this.nSl.setVisibility(8);
                    }
                }
            });
        }
        this.nSd.start();
    }

    private void dMb() {
        if (this.nSd != null) {
            this.nSd.cancel();
        }
        if (this.nSc == null) {
            this.nSc = ObjectAnimator.ofFloat(this.nSl, "alpha", 0.0f, 1.0f);
            this.nSc.setDuration(500L);
        }
        this.nSl.setVisibility(0);
        this.nSc.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUK() {
        this.nRV.reset();
        if (this.nQj.getStatus() == 1) {
            dMb();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUL() {
        if (this.bVD.getVisibility() != 0) {
            this.nRP.dUS();
            this.nQj.setStatus(8);
            dUu();
            if (this.nQr.nQV != null && this.nQr.nQV.size() > 0) {
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
        final int nSs = 50;
        final int nSt = 1;
        Handler nSu = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AnonymousClass3.this.mProgress >= 0) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nRX.S(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dUP();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dUP() {
            if (this.mProgress >= 0) {
                this.nSu.sendEmptyMessageDelayed(1, 50L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dUP();
            boolean z = RecordVideoActivity.this.nSk == null || TextUtils.isEmpty(RecordVideoActivity.this.nSk.dUt()) || !new File(RecordVideoActivity.this.nSk.dUt()).exists();
            if (RecordVideoActivity.this.nQr.nQV.size() > 1) {
                return com.baidu.tieba.video.meida.h.dTG().a(RecordVideoActivity.this.nQr.nQV, RecordVideoActivity.this.nQr.dTX(), z);
            }
            File file = new File(RecordVideoActivity.this.nQr.nQV.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    o.copyFile(file.getPath(), RecordVideoActivity.this.nQr.dTX());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dTG().a(RecordVideoActivity.this.nQr.nQV, RecordVideoActivity.this.nQr.dTX(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            this.mProgress = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.nRP.dUY();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dUv();
                    RecordVideoActivity.this.KP(102);
                    RecordVideoActivity.this.bVD.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dUv();
                RecordVideoActivity.this.KP(102);
                RecordVideoActivity.this.bVD.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bVD.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bK(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nRX.S(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nRP == null || y.isEmpty(this.nRP.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nRP.getChoosedBeautyList()) {
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
        if (this.nRP == null || y.isEmpty(this.nRP.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nRP.getChoosedFilterList()) {
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
        if (this.nRP == null || y.isEmpty(this.nRP.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nRP.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUM() {
        this.nRY.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUN() {
        this.nRY.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUO() {
        if (this.nQj.getStatus() == 1) {
            this.nSl.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nQr != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nQr.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ar("c12421").ap("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nRV.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nRV.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nQr.setFilter((String) eVar.getValue());
                        ar arVar = new ar("c12496");
                        arVar.dR("obj_id", (String) eVar.getValue());
                        if (this.nQj.getStatus() == 1) {
                            arVar.ap("obj_type", 1);
                        } else {
                            arVar.ap("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nRV.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nRV.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nSk.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nRV.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nRV.setViewChoosed(0, true);
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
            this.nSj = stickerItem;
            this.nSi.UM(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nQr != null) {
                    this.nQr.setSticker(null);
                    this.nSp = false;
                }
                if (this.nRP != null) {
                    this.nRP.setDownLoadSticker(null);
                }
                this.nRW.setVisibility(8);
                this.nRV.setViewChoosed(1, false);
                return;
            }
            String UJ = this.nSi.UJ(stickerItem.resource);
            if (!StringUtils.isNull(UJ)) {
                a(stickerItem, UJ);
                if (this.nRP != null) {
                    this.nRP.setDownLoadSticker(null);
                }
            } else {
                if (this.nRP != null) {
                    this.nRP.setDownLoadSticker(stickerItem);
                }
                this.nSi.UK(stickerItem.resource);
            }
            this.nRV.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nQr != null) {
                this.nQr.setSticker(stickerItem);
                this.nSp = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nRW.setText(stickerItem.desc);
                this.nRW.setVisibility(0);
                this.nRW.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nRW.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nRW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dA(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nRP.getLayoutParams();
            layoutParams.height = i4;
            this.nRP.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Uu = com.baidu.tieba.video.editvideo.model.a.dSU().Uu(stringExtra);
                if (this.nSk != null && !TextUtils.isEmpty(Uu)) {
                    this.nSk.gI(Uu, stringExtra2);
                    this.nRP.dTL();
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
        if (this.nQj.getStatus() == 8) {
            this.nRP.dUR();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void ze(boolean z) {
        if (this.nQj != null && (this.nQj.getStatus() == 1 || this.nQj.getStatus() == 3 || this.nQj.getStatus() == 4)) {
            if (!z && this.nSp) {
                this.nRU.dUk();
                return;
            } else {
                this.nRU.dUl();
                return;
            }
        }
        this.nRU.dUl();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.jDP != i) {
            switch (i) {
                case 1:
                    if (this.nSk != null) {
                        this.nSk.bfT();
                    }
                    this.nQr.setFilter("origin");
                    this.nRV.setViewChoosed(0, false);
                    this.nRV.setViewChoosed(3, false);
                    this.nRP.KR(1);
                    this.nRV.setViewVisibility(0, 8);
                    this.nRV.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nRV.setViewVisibility(0, 0);
                    this.nRV.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jDP = i;
            this.nRP.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ar().ap("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dUs() {
        if (this.nQj.getStatus() == 1 && !this.nRP.dUW()) {
            ai(1, true);
            this.nSl.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dUr() {
        if (this.nQj.getStatus() == 1 && !this.nRP.dUW()) {
            ai(2, true);
            this.nSl.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KP(int i) {
        if (this.nyu != null) {
            this.nyu.bL(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(int i, String str) {
        if (this.nyu != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nyu.bK(i, str);
        }
    }
}
