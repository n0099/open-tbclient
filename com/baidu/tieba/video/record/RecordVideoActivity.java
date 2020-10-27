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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.n;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes23.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bpp;
    private final CustomMessageListener fJM;
    private com.baidu.tbadk.core.dialog.a iFi;
    private ForumWriteData iOm;
    private int iVR;
    private final CustomMessageListener iXF;
    private ImageView jAO;
    private Context mContext;
    private com.baidu.tieba.k.h mSh;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String nht;
    private SelectMusicModel nhx;
    private b.a nkN;
    private b nmW;
    private i nmg;
    protected h nmo;
    private RecordLayout nnL;
    private VideoControllerLayout nnM;
    private RelativeLayout nnN;
    private ImageView nnO;
    private ImageView nnP;
    private ImageView nnQ;
    private PreviewViewContainer nnR;
    private TextView nnS;
    private VideoEffectButtonLayout nnT;
    private TextView nnU;
    private RoundProgressBar nnV;
    private TextView nnW;
    private AnimatorSet nnX;
    private AnimatorSet nnY;
    private ScaleAnimation nnZ;
    private ObjectAnimator noa;
    private ObjectAnimator nob;
    private int noc;
    private int nod;
    private boolean noe;
    private boolean nof = true;
    private l nog;
    private StickerItem noh;
    protected j noi;
    private RecordTabLayout noj;
    private ImageFileInfo nok;
    private HttpMessageListener nol;
    private boolean nom;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mSh = lVar.dbR();
        }
        if (this.mSh != null) {
            this.mSh.dbA();
        }
        this.nkN = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fK(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nnM != null) {
                        RecordVideoActivity.this.nnM.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nnM != null) {
                    RecordVideoActivity.this.nnM.setHasLocalVideo(true);
                    RecordVideoActivity.this.nof = false;
                }
            }
        };
        this.nol = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nnM != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nnM.setStickerItems(list);
                    }
                }
            }
        };
        this.iXF = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fJM = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dOv() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nmo.nkc);
        videoInfo.setVideoDuration(this.nmg.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nmo.nkc).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.iOm == null ? "" : this.iOm.forumName;
        String str2 = this.iOm == null ? "" : this.iOm.forumId;
        int i = this.iOm == null ? -1 : this.iOm.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.iOm.writeCallFrom, str, str2, this.nht, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.iOm != null ? this.iOm.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.iOm != null ? this.iOm.forumLevel : -1);
        String str3 = "";
        String str4 = "";
        if (getIntent() != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra("anti_data");
            AntiData antiData2 = serializableExtra instanceof AntiData ? (AntiData) serializableExtra : null;
            Serializable serializableExtra2 = getIntent().getSerializableExtra("prefix_data");
            PostPrefixData postPrefixData2 = serializableExtra2 instanceof PostPrefixData ? (PostPrefixData) serializableExtra2 : null;
            antiData = antiData2;
            str3 = getIntent().getStringExtra("forum_first_dir");
            postPrefixData = postPrefixData2;
            str4 = getIntent().getStringExtra("forum_second_dir");
        } else {
            postPrefixData = null;
        }
        editVideoActivityConfig.setExtraData(antiData, postPrefixData, str3, str4);
        editVideoActivityConfig.setFrom(this.iOm.mFrom);
        if (this.noi != null) {
            this.noi.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mSh != null) {
            this.mSh.dbD();
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
        if (this.nmg != null && this.nmg.brz()) {
            this.nmg.stopRecord();
        }
        if (this.nhx != null) {
            this.nhx.cancelLoadData();
        }
        if (this.mSh != null) {
            this.mSh.Ov("record");
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
        this.noc = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nod = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.iOm = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nht = getIntent().getStringExtra("video_title");
        initUI();
        this.nhx = new SelectMusicModel(getPageContext(), this.nnM);
        this.nhx.dMN();
        this.noi = new j(this);
        this.noi.b(this.nhx);
        this.nmg.a(this.noi);
        registerListener(this.nol);
        registerListener(this.iXF);
        registerListener(this.fJM);
        dOw();
        if (Build.VERSION.SDK_INT >= 28 && an.boG() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dOw() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dNp() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.nkN);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nnL = (RecordLayout) findViewById(R.id.root_layout);
        this.nnL.setListener(this);
        this.nmg = new i(this);
        this.nnM = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nnM.setRecordController(this.nmg);
        this.nnM.setRecordControlListener(this);
        this.nnM.setEffectChoosedListener(this);
        this.nnN = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.jAO = (ImageView) findViewById(R.id.close_page);
        this.jAO.setOnClickListener(this);
        this.nnO = (ImageView) findViewById(R.id.flash_switch);
        this.nnO.setOnClickListener(this);
        this.nnP = (ImageView) findViewById(R.id.camera_switch);
        this.nnP.setOnClickListener(this);
        this.nnQ = (ImageView) findViewById(R.id.count_down);
        this.nnQ.setOnClickListener(this);
        this.nnR = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nmo = new h(this);
        this.nmo.a(this);
        this.nmo.setFaceIdentifyStateListener(this);
        this.nmo.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dOj() {
                if (RecordVideoActivity.this.nnM.dOV()) {
                    RecordVideoActivity.this.nnM.a((m) null);
                }
            }
        });
        this.nnT = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nnT.setListener(this);
        this.nmg.a(this.nnT);
        this.nnT.setViewChoosed(2, true);
        this.nnS = (TextView) findViewById(R.id.tv_count_down);
        this.nnU = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.nnS.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.nnS.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nnT.setVisibility(8);
        }
        this.bpp = findViewById(R.id.progress_layout);
        this.nnV = (RoundProgressBar) this.bpp.findViewById(R.id.video_progress);
        this.nnW = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nnW.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nnW.setLayoutParams(layoutParams);
        this.noj = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            KG(this.nod);
        } else {
            KG(1);
        }
        dOx();
    }

    private void KG(int i) {
        if (this.noj != null) {
            if (i == 0) {
                this.noj.bV(1, getString(R.string.tab_photo));
                this.noj.bV(2, getString(R.string.tab_record));
                this.noj.setListener(this);
                this.noj.setCurrentTab(2, false);
                ak(2, false);
            } else if (i == 1) {
                this.noj.bV(1, getString(R.string.tab_photo));
                this.noj.setShowIndicator(false);
                this.noj.setCurrentTab(1, false);
                ak(1, false);
            } else {
                this.noj.bV(2, getString(R.string.tab_record));
                this.noj.setShowIndicator(false);
                this.noj.setCurrentTab(2, false);
                ak(2, false);
            }
        }
    }

    private void dOx() {
        if (com.baidu.tbadk.core.util.g.bnQ()) {
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
        this.nmo.onResume();
        this.nmW = this.nmo.dOa();
        if (this.nmW != null) {
            this.nmW.setRecordController(this.nmg);
            this.nnR.setZoomHelper(this.nmW);
        }
        dOy();
        if (this.nog == null) {
            this.nog = new l();
            this.nog.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gw(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.noh, str2);
                    if (RecordVideoActivity.this.nnM != null) {
                        RecordVideoActivity.this.nnM.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Tp(String str) {
                    if (RecordVideoActivity.this.nnM != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nnM.b(stickerItem);
                        if (RecordVideoActivity.this.nmo != null) {
                            RecordVideoActivity.this.nmo.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nnM != null) {
                        RecordVideoActivity.this.nnM.setDownLoadSticker(null);
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
                    recordVideoActivity.bB(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dMb() {
                    if (RecordVideoActivity.this.nnM != null) {
                        RecordVideoActivity.this.nnM.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nog.dOP();
        if (this.nnM != null && this.nof) {
            dNp();
        }
        if (this.mSh != null) {
            this.mSh.Ou("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nmo.onPause();
        if (this.nnM != null) {
            if (this.nmg != null && this.nmg.getStatus() == 6) {
                this.nnM.stopRecord();
                dOH();
            }
            if (this.nmg != null && this.nmg.brz()) {
                this.nnM.stopRecord();
            }
        }
        if (this.noi != null) {
            this.noi.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nmg == null || this.nmg.getStatus() != 7) {
            if (this.nmg != null && this.nmg.getStatus() == 6) {
                if (this.nnM != null) {
                    this.nnM.stopRecord();
                }
                dOH();
            } else if (this.nmg != null && this.nmg.onBackPressed()) {
                finish();
            } else {
                if (this.iFi == null) {
                    this.iFi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.iFi.om(R.string.video_quit_confirm);
                    this.iFi.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.iFi.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.iFi.iM(true);
                    this.iFi.b(getPageContext());
                }
                this.iFi.bmC();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nnW.setVisibility(4);
        if (view == this.jAO) {
            onBackPressed();
        } else if (view == this.nnO) {
            if (this.nmg.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nmo.dOd();
            dOy();
        } else if (view == this.nnP) {
            if (this.nmg.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nnP.setOnClickListener(null);
            this.nmo.dOf();
            if (this.nmo.dOg() && this.nmo.dOe()) {
                this.nmo.dOd();
            }
            dOy();
            this.nnP.setOnClickListener(this);
        } else if (view == this.nnQ) {
            dOA();
        }
    }

    private void dOy() {
        if (this.nmo.dOg()) {
            this.nnO.setVisibility(8);
        } else {
            this.nnO.setVisibility(0);
        }
        if (this.nmo.dOe()) {
            this.nnO.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nnO.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dOz() {
        return this.nnR;
    }

    public void dOA() {
        this.nnW.setVisibility(4);
        if (this.nmg.getStatus() != 6) {
            this.nmg.setStatus(6);
            dOF();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nnZ == null) {
                this.nnZ = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nnZ.setDuration(500L);
                this.nnZ.setRepeatCount(5);
                this.nnZ.setRepeatMode(2);
                this.nnZ.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nnZ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nmg.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.nnS.setVisibility(0);
                        RecordVideoActivity.this.nnS.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.nnS.setVisibility(8);
                    if (RecordVideoActivity.this.nmg.getStatus() == 6) {
                        RecordVideoActivity.this.nnM.dOS();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nmg.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.nnS.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.nnS.setText("");
                        }
                    }
                }
            });
            this.nnS.setAnimation(this.nnZ);
            this.nnZ.startNow();
            this.nnM.dOA();
            if (this.noi != null) {
                this.noi.dOu();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOB() {
        if (this.nmg.getStatus() == 1) {
            this.nnW.setVisibility(4);
            if (this.nmg.getStatus() != 6) {
                this.nnM.dOB();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOC() {
        this.nnW.setVisibility(4);
        if (this.nmg.getStatus() != 6) {
            this.nnM.dOC();
            if (this.nnM.dOW()) {
                dOw();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOD() {
        this.nnW.setVisibility(4);
        if (this.nmg.getStatus() != 6) {
            this.nnM.dOD();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dOE() {
        this.nnW.setVisibility(4);
        if (this.nmg.getStatus() != 6) {
            this.nnM.dOE();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOF() {
        this.noe = true;
        if (this.nnY != null && this.nnY.isRunning()) {
            this.nnY.cancel();
        }
        if (this.nnX == null) {
            this.nnX = new AnimatorSet();
            this.nnX.playTogether(ObjectAnimator.ofFloat(this.nnN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nnT, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.noj, "alpha", 1.0f, 0.0f));
            this.nnX.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.npL) {
                        RecordVideoActivity.this.nnN.setVisibility(8);
                        RecordVideoActivity.this.nnT.setVisibility(8);
                        RecordVideoActivity.this.noj.setVisibility(8);
                    }
                }
            });
            this.nnX.setDuration(300L);
        }
        this.nnX.start();
        this.nnT.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOu() {
        if (this.iVR == 2) {
            if (this.noe) {
                this.noe = false;
                if (this.noi != null) {
                    this.noi.dOu();
                }
            } else {
                return;
            }
        }
        if (this.nnX != null && this.nnX.isRunning()) {
            this.nnX.cancel();
        }
        if (this.nnY == null) {
            this.nnY = new AnimatorSet();
            this.nnY.playTogether(ObjectAnimator.ofFloat(this.nnN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nnT, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.noj, "alpha", 0.0f, 1.0f));
            this.nnY.setDuration(300L);
        }
        this.nnN.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nnT.setVisibility(0);
        }
        if (this.nmg.getStatus() == 1) {
            this.noj.setVisibility(0);
        }
        this.nnY.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOG() {
        if (this.nmo != null) {
            this.nmo.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void F(boolean z, String str) {
                    RecordVideoActivity.this.nmg.setStatus(1);
                    RecordVideoActivity.this.dOu();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nok != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nok)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nok);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nok = new ImageFileInfo();
                        RecordVideoActivity.this.nok.setFilePath(str);
                        RecordVideoActivity.this.nok.setContentUriStr(null);
                        RecordVideoActivity.this.nok.setTempFile(true);
                        RecordVideoActivity.this.nok.setAlbumnId(null);
                        RecordVideoActivity.this.nok.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nok);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.iOm, RecordVideoActivity.this.noc)));
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
    public void dOH() {
        this.nnZ.cancel();
        this.nnZ.setAnimationListener(null);
        this.nnS.clearAnimation();
        this.nnS.setVisibility(8);
        if (this.noi != null) {
            this.noi.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOI() {
        dFY();
    }

    private void dFY() {
        if (this.noa != null) {
            this.noa.cancel();
        }
        if (this.nob == null) {
            this.nob = ObjectAnimator.ofFloat(this.noj, "alpha", 1.0f, 0.0f);
            this.nob.setDuration(500L);
            this.nob.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.npL) {
                        RecordVideoActivity.this.noj.setVisibility(8);
                    }
                }
            });
        }
        this.nob.start();
    }

    private void dFX() {
        if (this.nob != null) {
            this.nob.cancel();
        }
        if (this.noa == null) {
            this.noa = ObjectAnimator.ofFloat(this.noj, "alpha", 0.0f, 1.0f);
            this.noa.setDuration(500L);
        }
        this.noj.setVisibility(0);
        this.noa.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOJ() {
        this.nnT.reset();
        if (this.nmg.getStatus() == 1) {
            dFX();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOK() {
        if (this.bpp.getVisibility() != 0) {
            this.nnM.dOR();
            this.nmg.setStatus(8);
            dOu();
            if (this.nmo.nmU != null && this.nmo.nmU.size() > 0) {
                this.bpp.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int noo = 50;
        final int nop = 1;
        Handler noq = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nnV.O(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dOO();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dOO() {
            this.noq.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dOO();
            boolean z = RecordVideoActivity.this.noi == null || TextUtils.isEmpty(RecordVideoActivity.this.noi.dOt()) || !new File(RecordVideoActivity.this.noi.dOt()).exists();
            if (RecordVideoActivity.this.nmo.nmU.size() > 1) {
                return com.baidu.tieba.video.meida.h.dNG().a(RecordVideoActivity.this.nmo.nmU, RecordVideoActivity.this.nmo.dNX(), z);
            }
            File file = new File(RecordVideoActivity.this.nmo.nmU.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nmo.dNX());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dNG().a(RecordVideoActivity.this.nmo.nmU, RecordVideoActivity.this.nmo.dNX(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.nnM.dOX();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dOv();
                    RecordVideoActivity.this.KH(102);
                    RecordVideoActivity.this.bpp.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dOv();
                RecordVideoActivity.this.KH(102);
                RecordVideoActivity.this.bpp.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bpp.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bB(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nnV.O(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nnM == null || y.isEmpty(this.nnM.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nnM.getChoosedBeautyList()) {
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
        if (this.nnM == null || y.isEmpty(this.nnM.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nnM.getChoosedFilterList()) {
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
        if (this.nnM == null || y.isEmpty(this.nnM.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nnM.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOL() {
        this.nnW.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dOM() {
        this.nnW.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dON() {
        if (this.nmg.getStatus() == 1) {
            this.noj.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nmo != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nmo.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").aj("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nnT.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nnT.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nmo.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dR("obj_id", (String) eVar.getValue());
                        if (this.nmg.getStatus() == 1) {
                            aqVar.aj("obj_type", 1);
                        } else {
                            aqVar.aj("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nnT.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nnT.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.noi.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nnT.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nnT.setViewChoosed(0, true);
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
            this.noh = stickerItem;
            this.nog.TQ(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nmo != null) {
                    this.nmo.setSticker(null);
                    this.nom = false;
                }
                if (this.nnM != null) {
                    this.nnM.setDownLoadSticker(null);
                }
                this.nnU.setVisibility(8);
                this.nnT.setViewChoosed(1, false);
                return;
            }
            String TN = this.nog.TN(stickerItem.resource);
            if (!StringUtils.isNull(TN)) {
                a(stickerItem, TN);
                if (this.nnM != null) {
                    this.nnM.setDownLoadSticker(null);
                }
            } else {
                if (this.nnM != null) {
                    this.nnM.setDownLoadSticker(stickerItem);
                }
                this.nog.TO(stickerItem.resource);
            }
            this.nnT.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nmo != null) {
                this.nmo.setSticker(stickerItem);
                this.nom = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nnU.setText(stickerItem.desc);
                this.nnU.setVisibility(0);
                this.nnU.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nnU.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nnU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dz(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nnM.getLayoutParams();
            layoutParams.height = i4;
            this.nnM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Tv = com.baidu.tieba.video.editvideo.model.a.dMH().Tv(stringExtra);
                if (this.noi != null && !TextUtils.isEmpty(Tv)) {
                    this.noi.gz(Tv, stringExtra2);
                    this.nnM.dNL();
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
        if (this.nmg.getStatus() == 8) {
            this.nnM.dOQ();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void xU(boolean z) {
        if (this.nmg != null && (this.nmg.getStatus() == 1 || this.nmg.getStatus() == 3 || this.nmg.getStatus() == 4)) {
            if (!z && this.nom) {
                this.nnR.dOk();
                return;
            } else {
                this.nnR.dOl();
                return;
            }
        }
        this.nnR.dOl();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ak(int i, boolean z) {
        int i2 = 1;
        if (this.iVR != i) {
            switch (i) {
                case 1:
                    if (this.noi != null) {
                        this.noi.bce();
                    }
                    this.nmo.setFilter("origin");
                    this.nnT.setViewChoosed(0, false);
                    this.nnT.setViewChoosed(3, false);
                    this.nnM.KJ(1);
                    this.nnT.setViewVisibility(0, 8);
                    this.nnT.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nnT.setViewVisibility(0, 0);
                    this.nnT.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.iVR = i;
            this.nnM.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().aj("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dOs() {
        if (this.nmg.getStatus() == 1 && !this.nnM.dOV()) {
            ak(1, true);
            this.noj.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dOr() {
        if (this.nmg.getStatus() == 1 && !this.nnM.dOV()) {
            ak(2, true);
            this.noj.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KH(int i) {
        if (this.mSh != null) {
            this.mSh.bC(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(int i, String str) {
        if (this.mSh != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mSh.bB(i, str);
        }
    }
}
