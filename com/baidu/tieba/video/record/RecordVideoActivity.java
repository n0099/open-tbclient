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
/* loaded from: classes17.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View buW;
    private ImageView gIn;
    private com.baidu.tbadk.core.dialog.a hWF;
    private ForumWriteData ifP;
    private int inf;
    private final CustomMessageListener ioU;
    private final CustomMessageListener kbo;
    private b mAH;
    private RelativeLayout mBA;
    private ImageView mBB;
    private ImageView mBC;
    private ImageView mBD;
    private PreviewViewContainer mBE;
    private TextView mBF;
    private VideoEffectButtonLayout mBG;
    private TextView mBH;
    private RoundProgressBar mBI;
    private TextView mBJ;
    private AnimatorSet mBK;
    private AnimatorSet mBL;
    private ScaleAnimation mBM;
    private ObjectAnimator mBN;
    private ObjectAnimator mBO;
    private int mBP;
    private int mBQ;
    private boolean mBR;
    private boolean mBS = true;
    private l mBT;
    private StickerItem mBU;
    protected j mBV;
    private RecordTabLayout mBW;
    private ImageFileInfo mBX;
    private HttpMessageListener mBY;
    private boolean mBZ;
    private RecordLayout mBy;
    private VideoControllerLayout mBz;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tieba.k.h mgf;
    private String mvc;
    private SelectMusicModel mvg;
    private b.a myy;
    private i mzR;
    protected h mzZ;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mgf = lVar.cRt();
        }
        if (this.mgf != null) {
            this.mgf.cRc();
        }
        this.myy = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fp(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.mBz != null) {
                        RecordVideoActivity.this.mBz.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mBz != null) {
                    RecordVideoActivity.this.mBz.setHasLocalVideo(true);
                    RecordVideoActivity.this.mBS = false;
                }
            }
        };
        this.mBY = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mBz != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mBz.setStickerItems(list);
                    }
                }
            }
        };
        this.ioU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.kbo = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dDy() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mzZ.mxN);
        videoInfo.setVideoDuration(this.mzR.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mzZ.mxN).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.ifP == null ? "" : this.ifP.forumName;
        String str2 = this.ifP == null ? "" : this.ifP.forumId;
        int i = this.ifP == null ? -1 : this.ifP.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.ifP.writeCallFrom, str, str2, this.mvc, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.ifP != null ? this.ifP.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.ifP != null ? this.ifP.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.ifP.mFrom);
        if (this.mBV != null) {
            this.mBV.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mgf != null) {
            this.mgf.cRf();
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
        if (this.mzR != null && this.mzR.bmc()) {
            this.mzR.stopRecord();
        }
        if (this.mvg != null) {
            this.mvg.cancelLoadData();
        }
        if (this.mgf != null) {
            this.mgf.MF("record");
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
        this.mBP = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mBQ = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.ifP = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mvc = getIntent().getStringExtra("video_title");
        initUI();
        this.mvg = new SelectMusicModel(getPageContext(), this.mBz);
        this.mvg.dBQ();
        this.mBV = new j(this);
        this.mBV.b(this.mvg);
        this.mzR.a(this.mBV);
        registerListener(this.mBY);
        registerListener(this.ioU);
        registerListener(this.kbo);
        dDz();
        if (Build.VERSION.SDK_INT >= 28 && an.bjj() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dDz() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dCs() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.myy);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mBy = (RecordLayout) findViewById(R.id.root_layout);
        this.mBy.setListener(this);
        this.mzR = new i(this);
        this.mBz = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mBz.setRecordController(this.mzR);
        this.mBz.setRecordControlListener(this);
        this.mBz.setEffectChoosedListener(this);
        this.mBA = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gIn = (ImageView) findViewById(R.id.close_page);
        this.gIn.setOnClickListener(this);
        this.mBB = (ImageView) findViewById(R.id.flash_switch);
        this.mBB.setOnClickListener(this);
        this.mBC = (ImageView) findViewById(R.id.camera_switch);
        this.mBC.setOnClickListener(this);
        this.mBD = (ImageView) findViewById(R.id.count_down);
        this.mBD.setOnClickListener(this);
        this.mBE = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.mzZ = new h(this);
        this.mzZ.a(this);
        this.mzZ.setFaceIdentifyStateListener(this);
        this.mzZ.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dDm() {
                if (RecordVideoActivity.this.mBz.dDY()) {
                    RecordVideoActivity.this.mBz.a((m) null);
                }
            }
        });
        this.mBG = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mBG.setListener(this);
        this.mzR.a(this.mBG);
        this.mBG.setViewChoosed(2, true);
        this.mBF = (TextView) findViewById(R.id.tv_count_down);
        this.mBH = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mBF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mBF.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mBG.setVisibility(8);
        }
        this.buW = findViewById(R.id.progress_layout);
        this.mBI = (RoundProgressBar) this.buW.findViewById(R.id.video_progress);
        this.mBJ = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mBJ.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mBJ.setLayoutParams(layoutParams);
        this.mBW = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Je(this.mBQ);
        } else {
            Je(1);
        }
        dDA();
    }

    private void Je(int i) {
        if (this.mBW != null) {
            if (i == 0) {
                this.mBW.bH(1, getString(R.string.tab_photo));
                this.mBW.bH(2, getString(R.string.tab_record));
                this.mBW.setListener(this);
                this.mBW.setCurrentTab(2, false);
                ah(2, false);
            } else if (i == 1) {
                this.mBW.bH(1, getString(R.string.tab_photo));
                this.mBW.setShowIndicator(false);
                this.mBW.setCurrentTab(1, false);
                ah(1, false);
            } else {
                this.mBW.bH(2, getString(R.string.tab_record));
                this.mBW.setShowIndicator(false);
                this.mBW.setCurrentTab(2, false);
                ah(2, false);
            }
        }
    }

    private void dDA() {
        if (com.baidu.tbadk.core.util.g.bit()) {
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
        this.mzZ.onResume();
        this.mAH = this.mzZ.dDd();
        if (this.mAH != null) {
            this.mAH.setRecordController(this.mzR);
            this.mBE.setZoomHelper(this.mAH);
        }
        dDB();
        if (this.mBT == null) {
            this.mBT = new l();
            this.mBT.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void fX(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mBU, str2);
                    if (RecordVideoActivity.this.mBz != null) {
                        RecordVideoActivity.this.mBz.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void RC(String str) {
                    if (RecordVideoActivity.this.mBz != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mBz.b(stickerItem);
                        if (RecordVideoActivity.this.mzZ != null) {
                            RecordVideoActivity.this.mzZ.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mBz != null) {
                        RecordVideoActivity.this.mBz.setDownLoadSticker(null);
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
                    recordVideoActivity.bn(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dBe() {
                    if (RecordVideoActivity.this.mBz != null) {
                        RecordVideoActivity.this.mBz.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mBT.dDS();
        if (this.mBz != null && this.mBS) {
            dCs();
        }
        if (this.mgf != null) {
            this.mgf.ME("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mzZ.onPause();
        if (this.mBz != null) {
            if (this.mzR != null && this.mzR.getStatus() == 6) {
                this.mBz.stopRecord();
                dDK();
            }
            if (this.mzR != null && this.mzR.bmc()) {
                this.mBz.stopRecord();
            }
        }
        if (this.mBV != null) {
            this.mBV.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mzR == null || this.mzR.getStatus() != 7) {
            if (this.mzR != null && this.mzR.getStatus() == 6) {
                if (this.mBz != null) {
                    this.mBz.stopRecord();
                }
                dDK();
            } else if (this.mzR != null && this.mzR.onBackPressed()) {
                finish();
            } else {
                if (this.hWF == null) {
                    this.hWF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hWF.nt(R.string.video_quit_confirm);
                    this.hWF.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hWF.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hWF.m39if(true);
                    this.hWF.b(getPageContext());
                }
                this.hWF.bhg();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mBJ.setVisibility(4);
        if (view == this.gIn) {
            onBackPressed();
        } else if (view == this.mBB) {
            if (this.mzR.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mzZ.dDg();
            dDB();
        } else if (view == this.mBC) {
            if (this.mzR.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mBC.setOnClickListener(null);
            this.mzZ.dDi();
            if (this.mzZ.dDj() && this.mzZ.dDh()) {
                this.mzZ.dDg();
            }
            dDB();
            this.mBC.setOnClickListener(this);
        } else if (view == this.mBD) {
            dDD();
        }
    }

    private void dDB() {
        if (this.mzZ.dDj()) {
            this.mBB.setVisibility(8);
        } else {
            this.mBB.setVisibility(0);
        }
        if (this.mzZ.dDh()) {
            this.mBB.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mBB.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dDC() {
        return this.mBE;
    }

    public void dDD() {
        this.mBJ.setVisibility(4);
        if (this.mzR.getStatus() != 6) {
            this.mzR.setStatus(6);
            dDI();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mBM == null) {
                this.mBM = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mBM.setDuration(500L);
                this.mBM.setRepeatCount(5);
                this.mBM.setRepeatMode(2);
                this.mBM.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mBM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.mzR.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mBF.setVisibility(0);
                        RecordVideoActivity.this.mBF.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mBF.setVisibility(8);
                    if (RecordVideoActivity.this.mzR.getStatus() == 6) {
                        RecordVideoActivity.this.mBz.dDV();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.mzR.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mBF.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mBF.setText("");
                        }
                    }
                }
            });
            this.mBF.setAnimation(this.mBM);
            this.mBM.startNow();
            this.mBz.dDD();
            if (this.mBV != null) {
                this.mBV.dDx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDE() {
        if (this.mzR.getStatus() == 1) {
            this.mBJ.setVisibility(4);
            if (this.mzR.getStatus() != 6) {
                this.mBz.dDE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDF() {
        this.mBJ.setVisibility(4);
        if (this.mzR.getStatus() != 6) {
            this.mBz.dDF();
            if (this.mBz.dDZ()) {
                dDz();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDG() {
        this.mBJ.setVisibility(4);
        if (this.mzR.getStatus() != 6) {
            this.mBz.dDG();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDH() {
        this.mBJ.setVisibility(4);
        if (this.mzR.getStatus() != 6) {
            this.mBz.dDH();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDI() {
        this.mBR = true;
        if (this.mBL != null && this.mBL.isRunning()) {
            this.mBL.cancel();
        }
        if (this.mBK == null) {
            this.mBK = new AnimatorSet();
            this.mBK.playTogether(ObjectAnimator.ofFloat(this.mBA, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mBG, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mBW, "alpha", 1.0f, 0.0f));
            this.mBK.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDA) {
                        RecordVideoActivity.this.mBA.setVisibility(8);
                        RecordVideoActivity.this.mBG.setVisibility(8);
                        RecordVideoActivity.this.mBW.setVisibility(8);
                    }
                }
            });
            this.mBK.setDuration(300L);
        }
        this.mBK.start();
        this.mBG.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDx() {
        if (this.inf == 2) {
            if (this.mBR) {
                this.mBR = false;
                if (this.mBV != null) {
                    this.mBV.dDx();
                }
            } else {
                return;
            }
        }
        if (this.mBK != null && this.mBK.isRunning()) {
            this.mBK.cancel();
        }
        if (this.mBL == null) {
            this.mBL = new AnimatorSet();
            this.mBL.playTogether(ObjectAnimator.ofFloat(this.mBA, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mBG, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mBW, "alpha", 0.0f, 1.0f));
            this.mBL.setDuration(300L);
        }
        this.mBA.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mBG.setVisibility(0);
        }
        if (this.mzR.getStatus() == 1) {
            this.mBW.setVisibility(0);
        }
        this.mBL.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDJ() {
        if (this.mzZ != null) {
            this.mzZ.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void D(boolean z, String str) {
                    RecordVideoActivity.this.mzR.setStatus(1);
                    RecordVideoActivity.this.dDx();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mBX != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mBX)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mBX);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mBX = new ImageFileInfo();
                        RecordVideoActivity.this.mBX.setFilePath(str);
                        RecordVideoActivity.this.mBX.setContentUriStr(null);
                        RecordVideoActivity.this.mBX.setTempFile(true);
                        RecordVideoActivity.this.mBX.setAlbumnId(null);
                        RecordVideoActivity.this.mBX.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mBX);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.ifP, RecordVideoActivity.this.mBP)));
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
    public void dDK() {
        this.mBM.cancel();
        this.mBM.setAnimationListener(null);
        this.mBF.clearAnimation();
        this.mBF.setVisibility(8);
        if (this.mBV != null) {
            this.mBV.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDL() {
        dvh();
    }

    private void dvh() {
        if (this.mBN != null) {
            this.mBN.cancel();
        }
        if (this.mBO == null) {
            this.mBO = ObjectAnimator.ofFloat(this.mBW, "alpha", 1.0f, 0.0f);
            this.mBO.setDuration(500L);
            this.mBO.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDA) {
                        RecordVideoActivity.this.mBW.setVisibility(8);
                    }
                }
            });
        }
        this.mBO.start();
    }

    private void dvg() {
        if (this.mBO != null) {
            this.mBO.cancel();
        }
        if (this.mBN == null) {
            this.mBN = ObjectAnimator.ofFloat(this.mBW, "alpha", 0.0f, 1.0f);
            this.mBN.setDuration(500L);
        }
        this.mBW.setVisibility(0);
        this.mBN.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDM() {
        this.mBG.reset();
        if (this.mzR.getStatus() == 1) {
            dvg();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDN() {
        if (this.buW.getVisibility() != 0) {
            this.mBz.dDU();
            this.mzR.setStatus(8);
            dDx();
            if (this.mzZ.mAF != null && this.mzZ.mAF.size() > 0) {
                this.buW.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int mCb = 50;
        final int mCc = 1;
        Handler mCd = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mBI.K(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dDR();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void dDR() {
            this.mCd.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dDR();
            boolean z = RecordVideoActivity.this.mBV == null || TextUtils.isEmpty(RecordVideoActivity.this.mBV.dDw()) || !new File(RecordVideoActivity.this.mBV.dDw()).exists();
            if (RecordVideoActivity.this.mzZ.mAF.size() > 1) {
                return com.baidu.tieba.video.meida.h.dCJ().a(RecordVideoActivity.this.mzZ.mAF, RecordVideoActivity.this.mzZ.dDa(), z);
            }
            File file = new File(RecordVideoActivity.this.mzZ.mAF.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.mzZ.dDa());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dCJ().a(RecordVideoActivity.this.mzZ.mAF, RecordVideoActivity.this.mzZ.dDa(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mBz.dEa();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dDy();
                    RecordVideoActivity.this.Jf(102);
                    RecordVideoActivity.this.buW.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dDy();
                RecordVideoActivity.this.Jf(102);
                RecordVideoActivity.this.buW.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.buW.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bn(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mBI.K(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mBz == null || y.isEmpty(this.mBz.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mBz.getChoosedBeautyList()) {
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
        if (this.mBz == null || y.isEmpty(this.mBz.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mBz.getChoosedFilterList()) {
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
        if (this.mBz == null || y.isEmpty(this.mBz.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mBz.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDO() {
        this.mBJ.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDP() {
        this.mBJ.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDQ() {
        if (this.mzR.getStatus() == 1) {
            this.mBW.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.mzZ != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.mzZ.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").ai("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mBG.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mBG.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.mzZ.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dD("obj_id", (String) eVar.getValue());
                        if (this.mzR.getStatus() == 1) {
                            aqVar.ai("obj_type", 1);
                        } else {
                            aqVar.ai("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mBG.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mBG.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mBV.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mBG.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mBG.setViewChoosed(0, true);
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
            this.mBU = stickerItem;
            this.mBT.Sd(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.mzZ != null) {
                    this.mzZ.setSticker(null);
                    this.mBZ = false;
                }
                if (this.mBz != null) {
                    this.mBz.setDownLoadSticker(null);
                }
                this.mBH.setVisibility(8);
                this.mBG.setViewChoosed(1, false);
                return;
            }
            String Sa = this.mBT.Sa(stickerItem.resource);
            if (!StringUtils.isNull(Sa)) {
                a(stickerItem, Sa);
                if (this.mBz != null) {
                    this.mBz.setDownLoadSticker(null);
                }
            } else {
                if (this.mBz != null) {
                    this.mBz.setDownLoadSticker(stickerItem);
                }
                this.mBT.Sb(stickerItem.resource);
            }
            this.mBG.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.mzZ != null) {
                this.mzZ.setSticker(stickerItem);
                this.mBZ = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mBH.setText(stickerItem.desc);
                this.mBH.setVisibility(0);
                this.mBH.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mBH.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.mBH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dt(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mBz.getLayoutParams();
            layoutParams.height = i4;
            this.mBz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String RI = com.baidu.tieba.video.editvideo.model.a.dBK().RI(stringExtra);
                if (this.mBV != null && !TextUtils.isEmpty(RI)) {
                    this.mBV.ga(RI, stringExtra2);
                    this.mBz.dCO();
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
        if (this.mzR.getStatus() == 8) {
            this.mBz.dDT();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void wL(boolean z) {
        if (this.mzR != null && (this.mzR.getStatus() == 1 || this.mzR.getStatus() == 3 || this.mzR.getStatus() == 4)) {
            if (!z && this.mBZ) {
                this.mBE.dDn();
                return;
            } else {
                this.mBE.dDo();
                return;
            }
        }
        this.mBE.dDo();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ah(int i, boolean z) {
        int i2 = 1;
        if (this.inf != i) {
            switch (i) {
                case 1:
                    if (this.mBV != null) {
                        this.mBV.aWR();
                    }
                    this.mzZ.setFilter("origin");
                    this.mBG.setViewChoosed(0, false);
                    this.mBG.setViewChoosed(3, false);
                    this.mBz.Jh(1);
                    this.mBG.setViewVisibility(0, 8);
                    this.mBG.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mBG.setViewVisibility(0, 0);
                    this.mBG.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.inf = i;
            this.mBz.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().ai("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dDv() {
        if (this.mzR.getStatus() == 1 && !this.mBz.dDY()) {
            ah(1, true);
            this.mBW.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dDu() {
        if (this.mzR.getStatus() == 1 && !this.mBz.dDY()) {
            ah(2, true);
            this.mBW.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jf(int i) {
        if (this.mgf != null) {
            this.mgf.bo(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(int i, String str) {
        if (this.mgf != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mgf.bn(i, str);
        }
    }
}
