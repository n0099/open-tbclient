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
/* loaded from: classes22.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bjP;
    private final CustomMessageListener fpd;
    private ImageView iZp;
    private com.baidu.tbadk.core.dialog.a idP;
    private ForumWriteData imW;
    private int iuC;
    private final CustomMessageListener iwq;
    private Context mContext;
    private String mFg;
    private SelectMusicModel mFk;
    private b.a mIG;
    private i mJZ;
    private b mKP;
    protected h mKh;
    private RecordLayout mLF;
    private VideoControllerLayout mLG;
    private RelativeLayout mLH;
    private ImageView mLI;
    private ImageView mLJ;
    private ImageView mLK;
    private PreviewViewContainer mLL;
    private TextView mLM;
    private VideoEffectButtonLayout mLN;
    private TextView mLO;
    private RoundProgressBar mLP;
    private TextView mLQ;
    private AnimatorSet mLR;
    private AnimatorSet mLS;
    private ScaleAnimation mLT;
    private ObjectAnimator mLU;
    private ObjectAnimator mLV;
    private int mLW;
    private int mLX;
    private boolean mLY;
    private boolean mLZ = true;
    private l mMa;
    private StickerItem mMb;
    protected j mMc;
    private RecordTabLayout mMd;
    private ImageFileInfo mMe;
    private HttpMessageListener mMf;
    private boolean mMg;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tieba.k.h mpU;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mpU = lVar.cVa();
        }
        if (this.mpU != null) {
            this.mpU.cUJ();
        }
        this.mIG = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fy(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.mLG != null) {
                        RecordVideoActivity.this.mLG.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mLG != null) {
                    RecordVideoActivity.this.mLG.setHasLocalVideo(true);
                    RecordVideoActivity.this.mLZ = false;
                }
            }
        };
        this.mMf = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mLG != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mLG.setStickerItems(list);
                    }
                }
            }
        };
        this.iwq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fpd = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dHB() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mKh.mHR);
        videoInfo.setVideoDuration(this.mJZ.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mKh.mHR).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.imW == null ? "" : this.imW.forumName;
        String str2 = this.imW == null ? "" : this.imW.forumId;
        int i = this.imW == null ? -1 : this.imW.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.imW.writeCallFrom, str, str2, this.mFg, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.imW != null ? this.imW.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.imW != null ? this.imW.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.imW.mFrom);
        if (this.mMc != null) {
            this.mMc.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mpU != null) {
            this.mpU.cUM();
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
        if (this.mJZ != null && this.mJZ.bmW()) {
            this.mJZ.stopRecord();
        }
        if (this.mFk != null) {
            this.mFk.cancelLoadData();
        }
        if (this.mpU != null) {
            this.mpU.Ni("record");
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
        this.mLW = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mLX = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.imW = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mFg = getIntent().getStringExtra("video_title");
        initUI();
        this.mFk = new SelectMusicModel(getPageContext(), this.mLG);
        this.mFk.dFT();
        this.mMc = new j(this);
        this.mMc.b(this.mFk);
        this.mJZ.a(this.mMc);
        registerListener(this.mMf);
        registerListener(this.iwq);
        registerListener(this.fpd);
        dHC();
        if (Build.VERSION.SDK_INT >= 28 && an.bke() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dHC() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dGv() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.mIG);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mLF = (RecordLayout) findViewById(R.id.root_layout);
        this.mLF.setListener(this);
        this.mJZ = new i(this);
        this.mLG = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mLG.setRecordController(this.mJZ);
        this.mLG.setRecordControlListener(this);
        this.mLG.setEffectChoosedListener(this);
        this.mLH = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.iZp = (ImageView) findViewById(R.id.close_page);
        this.iZp.setOnClickListener(this);
        this.mLI = (ImageView) findViewById(R.id.flash_switch);
        this.mLI.setOnClickListener(this);
        this.mLJ = (ImageView) findViewById(R.id.camera_switch);
        this.mLJ.setOnClickListener(this);
        this.mLK = (ImageView) findViewById(R.id.count_down);
        this.mLK.setOnClickListener(this);
        this.mLL = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.mKh = new h(this);
        this.mKh.a(this);
        this.mKh.setFaceIdentifyStateListener(this);
        this.mKh.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dHp() {
                if (RecordVideoActivity.this.mLG.dIb()) {
                    RecordVideoActivity.this.mLG.a((m) null);
                }
            }
        });
        this.mLN = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mLN.setListener(this);
        this.mJZ.a(this.mLN);
        this.mLN.setViewChoosed(2, true);
        this.mLM = (TextView) findViewById(R.id.tv_count_down);
        this.mLO = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mLM.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mLM.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mLN.setVisibility(8);
        }
        this.bjP = findViewById(R.id.progress_layout);
        this.mLP = (RoundProgressBar) this.bjP.findViewById(R.id.video_progress);
        this.mLQ = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mLQ.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mLQ.setLayoutParams(layoutParams);
        this.mMd = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            JI(this.mLX);
        } else {
            JI(1);
        }
        dHD();
    }

    private void JI(int i) {
        if (this.mMd != null) {
            if (i == 0) {
                this.mMd.bK(1, getString(R.string.tab_photo));
                this.mMd.bK(2, getString(R.string.tab_record));
                this.mMd.setListener(this);
                this.mMd.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.mMd.bK(1, getString(R.string.tab_photo));
                this.mMd.setShowIndicator(false);
                this.mMd.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.mMd.bK(2, getString(R.string.tab_record));
                this.mMd.setShowIndicator(false);
                this.mMd.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dHD() {
        if (com.baidu.tbadk.core.util.g.bjo()) {
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
        this.mKh.onResume();
        this.mKP = this.mKh.dHg();
        if (this.mKP != null) {
            this.mKP.setRecordController(this.mJZ);
            this.mLL.setZoomHelper(this.mKP);
        }
        dHE();
        if (this.mMa == null) {
            this.mMa = new l();
            this.mMa.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gk(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mMb, str2);
                    if (RecordVideoActivity.this.mLG != null) {
                        RecordVideoActivity.this.mLG.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Sc(String str) {
                    if (RecordVideoActivity.this.mLG != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mLG.b(stickerItem);
                        if (RecordVideoActivity.this.mKh != null) {
                            RecordVideoActivity.this.mKh.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mLG != null) {
                        RecordVideoActivity.this.mLG.setDownLoadSticker(null);
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
                    recordVideoActivity.bq(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dFh() {
                    if (RecordVideoActivity.this.mLG != null) {
                        RecordVideoActivity.this.mLG.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mMa.dHV();
        if (this.mLG != null && this.mLZ) {
            dGv();
        }
        if (this.mpU != null) {
            this.mpU.Nh("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mKh.onPause();
        if (this.mLG != null) {
            if (this.mJZ != null && this.mJZ.getStatus() == 6) {
                this.mLG.stopRecord();
                dHN();
            }
            if (this.mJZ != null && this.mJZ.bmW()) {
                this.mLG.stopRecord();
            }
        }
        if (this.mMc != null) {
            this.mMc.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mJZ == null || this.mJZ.getStatus() != 7) {
            if (this.mJZ != null && this.mJZ.getStatus() == 6) {
                if (this.mLG != null) {
                    this.mLG.stopRecord();
                }
                dHN();
            } else if (this.mJZ != null && this.mJZ.onBackPressed()) {
                finish();
            } else {
                if (this.idP == null) {
                    this.idP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.idP.nE(R.string.video_quit_confirm);
                    this.idP.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.idP.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.idP.id(true);
                    this.idP.b(getPageContext());
                }
                this.idP.bia();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mLQ.setVisibility(4);
        if (view == this.iZp) {
            onBackPressed();
        } else if (view == this.mLI) {
            if (this.mJZ.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mKh.dHj();
            dHE();
        } else if (view == this.mLJ) {
            if (this.mJZ.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mLJ.setOnClickListener(null);
            this.mKh.dHl();
            if (this.mKh.dHm() && this.mKh.dHk()) {
                this.mKh.dHj();
            }
            dHE();
            this.mLJ.setOnClickListener(this);
        } else if (view == this.mLK) {
            dHG();
        }
    }

    private void dHE() {
        if (this.mKh.dHm()) {
            this.mLI.setVisibility(8);
        } else {
            this.mLI.setVisibility(0);
        }
        if (this.mKh.dHk()) {
            this.mLI.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mLI.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dHF() {
        return this.mLL;
    }

    public void dHG() {
        this.mLQ.setVisibility(4);
        if (this.mJZ.getStatus() != 6) {
            this.mJZ.setStatus(6);
            dHL();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mLT == null) {
                this.mLT = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mLT.setDuration(500L);
                this.mLT.setRepeatCount(5);
                this.mLT.setRepeatMode(2);
                this.mLT.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mLT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.mJZ.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mLM.setVisibility(0);
                        RecordVideoActivity.this.mLM.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mLM.setVisibility(8);
                    if (RecordVideoActivity.this.mJZ.getStatus() == 6) {
                        RecordVideoActivity.this.mLG.dHY();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.mJZ.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mLM.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mLM.setText("");
                        }
                    }
                }
            });
            this.mLM.setAnimation(this.mLT);
            this.mLT.startNow();
            this.mLG.dHG();
            if (this.mMc != null) {
                this.mMc.dHA();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHH() {
        if (this.mJZ.getStatus() == 1) {
            this.mLQ.setVisibility(4);
            if (this.mJZ.getStatus() != 6) {
                this.mLG.dHH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHI() {
        this.mLQ.setVisibility(4);
        if (this.mJZ.getStatus() != 6) {
            this.mLG.dHI();
            if (this.mLG.dIc()) {
                dHC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHJ() {
        this.mLQ.setVisibility(4);
        if (this.mJZ.getStatus() != 6) {
            this.mLG.dHJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dHK() {
        this.mLQ.setVisibility(4);
        if (this.mJZ.getStatus() != 6) {
            this.mLG.dHK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHL() {
        this.mLY = true;
        if (this.mLS != null && this.mLS.isRunning()) {
            this.mLS.cancel();
        }
        if (this.mLR == null) {
            this.mLR = new AnimatorSet();
            this.mLR.playTogether(ObjectAnimator.ofFloat(this.mLH, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mLN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mMd, "alpha", 1.0f, 0.0f));
            this.mLR.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mND) {
                        RecordVideoActivity.this.mLH.setVisibility(8);
                        RecordVideoActivity.this.mLN.setVisibility(8);
                        RecordVideoActivity.this.mMd.setVisibility(8);
                    }
                }
            });
            this.mLR.setDuration(300L);
        }
        this.mLR.start();
        this.mLN.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHA() {
        if (this.iuC == 2) {
            if (this.mLY) {
                this.mLY = false;
                if (this.mMc != null) {
                    this.mMc.dHA();
                }
            } else {
                return;
            }
        }
        if (this.mLR != null && this.mLR.isRunning()) {
            this.mLR.cancel();
        }
        if (this.mLS == null) {
            this.mLS = new AnimatorSet();
            this.mLS.playTogether(ObjectAnimator.ofFloat(this.mLH, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mLN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mMd, "alpha", 0.0f, 1.0f));
            this.mLS.setDuration(300L);
        }
        this.mLH.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mLN.setVisibility(0);
        }
        if (this.mJZ.getStatus() == 1) {
            this.mMd.setVisibility(0);
        }
        this.mLS.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHM() {
        if (this.mKh != null) {
            this.mKh.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void D(boolean z, String str) {
                    RecordVideoActivity.this.mJZ.setStatus(1);
                    RecordVideoActivity.this.dHA();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mMe != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mMe)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mMe);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mMe = new ImageFileInfo();
                        RecordVideoActivity.this.mMe.setFilePath(str);
                        RecordVideoActivity.this.mMe.setContentUriStr(null);
                        RecordVideoActivity.this.mMe.setTempFile(true);
                        RecordVideoActivity.this.mMe.setAlbumnId(null);
                        RecordVideoActivity.this.mMe.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mMe);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.imW, RecordVideoActivity.this.mLW)));
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
    public void dHN() {
        this.mLT.cancel();
        this.mLT.setAnimationListener(null);
        this.mLM.clearAnimation();
        this.mLM.setVisibility(8);
        if (this.mMc != null) {
            this.mMc.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHO() {
        dzf();
    }

    private void dzf() {
        if (this.mLU != null) {
            this.mLU.cancel();
        }
        if (this.mLV == null) {
            this.mLV = ObjectAnimator.ofFloat(this.mMd, "alpha", 1.0f, 0.0f);
            this.mLV.setDuration(500L);
            this.mLV.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mND) {
                        RecordVideoActivity.this.mMd.setVisibility(8);
                    }
                }
            });
        }
        this.mLV.start();
    }

    private void dze() {
        if (this.mLV != null) {
            this.mLV.cancel();
        }
        if (this.mLU == null) {
            this.mLU = ObjectAnimator.ofFloat(this.mMd, "alpha", 0.0f, 1.0f);
            this.mLU.setDuration(500L);
        }
        this.mMd.setVisibility(0);
        this.mLU.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHP() {
        this.mLN.reset();
        if (this.mJZ.getStatus() == 1) {
            dze();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHQ() {
        if (this.bjP.getVisibility() != 0) {
            this.mLG.dHX();
            this.mJZ.setStatus(8);
            dHA();
            if (this.mKh.mKN != null && this.mKh.mKN.size() > 0) {
                this.bjP.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int mMi = 50;
        final int mMj = 1;
        Handler mMk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mLP.K(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dHU();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void dHU() {
            this.mMk.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dHU();
            boolean z = RecordVideoActivity.this.mMc == null || TextUtils.isEmpty(RecordVideoActivity.this.mMc.dHz()) || !new File(RecordVideoActivity.this.mMc.dHz()).exists();
            if (RecordVideoActivity.this.mKh.mKN.size() > 1) {
                return com.baidu.tieba.video.meida.h.dGM().a(RecordVideoActivity.this.mKh.mKN, RecordVideoActivity.this.mKh.dHd(), z);
            }
            File file = new File(RecordVideoActivity.this.mKh.mKN.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.mKh.dHd());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dGM().a(RecordVideoActivity.this.mKh.mKN, RecordVideoActivity.this.mKh.dHd(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mLG.dId();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dHB();
                    RecordVideoActivity.this.JJ(102);
                    RecordVideoActivity.this.bjP.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dHB();
                RecordVideoActivity.this.JJ(102);
                RecordVideoActivity.this.bjP.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bjP.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bq(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mLP.K(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mLG == null || y.isEmpty(this.mLG.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mLG.getChoosedBeautyList()) {
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
        if (this.mLG == null || y.isEmpty(this.mLG.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mLG.getChoosedFilterList()) {
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
        if (this.mLG == null || y.isEmpty(this.mLG.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mLG.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHR() {
        this.mLQ.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHS() {
        this.mLQ.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dHT() {
        if (this.mJZ.getStatus() == 1) {
            this.mMd.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.mKh != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.mKh.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").ai("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mLN.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mLN.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.mKh.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dF("obj_id", (String) eVar.getValue());
                        if (this.mJZ.getStatus() == 1) {
                            aqVar.ai("obj_type", 1);
                        } else {
                            aqVar.ai("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mLN.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mLN.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mMc.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mLN.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mLN.setViewChoosed(0, true);
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
            this.mMb = stickerItem;
            this.mMa.SD(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.mKh != null) {
                    this.mKh.setSticker(null);
                    this.mMg = false;
                }
                if (this.mLG != null) {
                    this.mLG.setDownLoadSticker(null);
                }
                this.mLO.setVisibility(8);
                this.mLN.setViewChoosed(1, false);
                return;
            }
            String SA = this.mMa.SA(stickerItem.resource);
            if (!StringUtils.isNull(SA)) {
                a(stickerItem, SA);
                if (this.mLG != null) {
                    this.mLG.setDownLoadSticker(null);
                }
            } else {
                if (this.mLG != null) {
                    this.mLG.setDownLoadSticker(stickerItem);
                }
                this.mMa.SB(stickerItem.resource);
            }
            this.mLN.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.mKh != null) {
                this.mKh.setSticker(stickerItem);
                this.mMg = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mLO.setText(stickerItem.desc);
                this.mLO.setVisibility(0);
                this.mLO.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mLO.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.mLO.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dx(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mLG.getLayoutParams();
            layoutParams.height = i4;
            this.mLG.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Si = com.baidu.tieba.video.editvideo.model.a.dFN().Si(stringExtra);
                if (this.mMc != null && !TextUtils.isEmpty(Si)) {
                    this.mMc.gn(Si, stringExtra2);
                    this.mLG.dGR();
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
        if (this.mJZ.getStatus() == 8) {
            this.mLG.dHW();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void wW(boolean z) {
        if (this.mJZ != null && (this.mJZ.getStatus() == 1 || this.mJZ.getStatus() == 3 || this.mJZ.getStatus() == 4)) {
            if (!z && this.mMg) {
                this.mLL.dHq();
                return;
            } else {
                this.mLL.dHr();
                return;
            }
        }
        this.mLL.dHr();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.iuC != i) {
            switch (i) {
                case 1:
                    if (this.mMc != null) {
                        this.mMc.aXD();
                    }
                    this.mKh.setFilter("origin");
                    this.mLN.setViewChoosed(0, false);
                    this.mLN.setViewChoosed(3, false);
                    this.mLG.JL(1);
                    this.mLN.setViewVisibility(0, 8);
                    this.mLN.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mLN.setViewVisibility(0, 0);
                    this.mLN.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.iuC = i;
            this.mLG.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().ai("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dHy() {
        if (this.mJZ.getStatus() == 1 && !this.mLG.dIb()) {
            ai(1, true);
            this.mMd.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dHx() {
        if (this.mJZ.getStatus() == 1 && !this.mLG.dIb()) {
            ai(2, true);
            this.mMd.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JJ(int i) {
        if (this.mpU != null) {
            this.mpU.br(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(int i, String str) {
        if (this.mpU != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mpU.bq(i, str);
        }
    }
}
