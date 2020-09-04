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
    private View buZ;
    private ImageView gIr;
    private com.baidu.tbadk.core.dialog.a hWL;
    private ForumWriteData ifV;
    private int inl;
    private final CustomMessageListener ipa;
    private final CustomMessageListener kbv;
    private b mAZ;
    private i mAj;
    protected h mAr;
    private RecordLayout mBQ;
    private VideoControllerLayout mBR;
    private RelativeLayout mBS;
    private ImageView mBT;
    private ImageView mBU;
    private ImageView mBV;
    private PreviewViewContainer mBW;
    private TextView mBX;
    private VideoEffectButtonLayout mBY;
    private TextView mBZ;
    private RoundProgressBar mCa;
    private TextView mCb;
    private AnimatorSet mCc;
    private AnimatorSet mCd;
    private ScaleAnimation mCe;
    private ObjectAnimator mCf;
    private ObjectAnimator mCg;
    private int mCh;
    private int mCi;
    private boolean mCj;
    private boolean mCk = true;
    private l mCl;
    private StickerItem mCm;
    protected j mCn;
    private RecordTabLayout mCo;
    private Context mContext;
    private ImageFileInfo mCp;
    private HttpMessageListener mCq;
    private boolean mCr;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tieba.k.h mgu;
    private String mvu;
    private SelectMusicModel mvy;
    private b.a myQ;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.mgu = lVar.cRu();
        }
        if (this.mgu != null) {
            this.mgu.cRd();
        }
        this.myQ = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fp(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.mBR != null) {
                        RecordVideoActivity.this.mBR.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mBR != null) {
                    RecordVideoActivity.this.mBR.setHasLocalVideo(true);
                    RecordVideoActivity.this.mCk = false;
                }
            }
        };
        this.mCq = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mBR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mBR.setStickerItems(list);
                    }
                }
            }
        };
        this.ipa = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.kbv = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dDH() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mAr.myf);
        videoInfo.setVideoDuration(this.mAj.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mAr.myf).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.ifV == null ? "" : this.ifV.forumName;
        String str2 = this.ifV == null ? "" : this.ifV.forumId;
        int i = this.ifV == null ? -1 : this.ifV.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.ifV.writeCallFrom, str, str2, this.mvu, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.ifV != null ? this.ifV.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.ifV != null ? this.ifV.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.ifV.mFrom);
        if (this.mCn != null) {
            this.mCn.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mgu != null) {
            this.mgu.cRg();
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
        if (this.mAj != null && this.mAj.bmc()) {
            this.mAj.stopRecord();
        }
        if (this.mvy != null) {
            this.mvy.cancelLoadData();
        }
        if (this.mgu != null) {
            this.mgu.MG("record");
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
        this.mCh = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mCi = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.ifV = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mvu = getIntent().getStringExtra("video_title");
        initUI();
        this.mvy = new SelectMusicModel(getPageContext(), this.mBR);
        this.mvy.dBZ();
        this.mCn = new j(this);
        this.mCn.b(this.mvy);
        this.mAj.a(this.mCn);
        registerListener(this.mCq);
        registerListener(this.ipa);
        registerListener(this.kbv);
        dDI();
        if (Build.VERSION.SDK_INT >= 28 && an.bjj() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dDI() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dCB() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.myQ);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mBQ = (RecordLayout) findViewById(R.id.root_layout);
        this.mBQ.setListener(this);
        this.mAj = new i(this);
        this.mBR = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mBR.setRecordController(this.mAj);
        this.mBR.setRecordControlListener(this);
        this.mBR.setEffectChoosedListener(this);
        this.mBS = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gIr = (ImageView) findViewById(R.id.close_page);
        this.gIr.setOnClickListener(this);
        this.mBT = (ImageView) findViewById(R.id.flash_switch);
        this.mBT.setOnClickListener(this);
        this.mBU = (ImageView) findViewById(R.id.camera_switch);
        this.mBU.setOnClickListener(this);
        this.mBV = (ImageView) findViewById(R.id.count_down);
        this.mBV.setOnClickListener(this);
        this.mBW = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.mAr = new h(this);
        this.mAr.a(this);
        this.mAr.setFaceIdentifyStateListener(this);
        this.mAr.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dDv() {
                if (RecordVideoActivity.this.mBR.dEh()) {
                    RecordVideoActivity.this.mBR.a((m) null);
                }
            }
        });
        this.mBY = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mBY.setListener(this);
        this.mAj.a(this.mBY);
        this.mBY.setViewChoosed(2, true);
        this.mBX = (TextView) findViewById(R.id.tv_count_down);
        this.mBZ = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mBX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mBX.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mBY.setVisibility(8);
        }
        this.buZ = findViewById(R.id.progress_layout);
        this.mCa = (RoundProgressBar) this.buZ.findViewById(R.id.video_progress);
        this.mCb = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCb.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mCb.setLayoutParams(layoutParams);
        this.mCo = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Je(this.mCi);
        } else {
            Je(1);
        }
        dDJ();
    }

    private void Je(int i) {
        if (this.mCo != null) {
            if (i == 0) {
                this.mCo.bG(1, getString(R.string.tab_photo));
                this.mCo.bG(2, getString(R.string.tab_record));
                this.mCo.setListener(this);
                this.mCo.setCurrentTab(2, false);
                ah(2, false);
            } else if (i == 1) {
                this.mCo.bG(1, getString(R.string.tab_photo));
                this.mCo.setShowIndicator(false);
                this.mCo.setCurrentTab(1, false);
                ah(1, false);
            } else {
                this.mCo.bG(2, getString(R.string.tab_record));
                this.mCo.setShowIndicator(false);
                this.mCo.setCurrentTab(2, false);
                ah(2, false);
            }
        }
    }

    private void dDJ() {
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
        this.mAr.onResume();
        this.mAZ = this.mAr.dDm();
        if (this.mAZ != null) {
            this.mAZ.setRecordController(this.mAj);
            this.mBW.setZoomHelper(this.mAZ);
        }
        dDK();
        if (this.mCl == null) {
            this.mCl = new l();
            this.mCl.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void fY(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mCm, str2);
                    if (RecordVideoActivity.this.mBR != null) {
                        RecordVideoActivity.this.mBR.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void RC(String str) {
                    if (RecordVideoActivity.this.mBR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mBR.b(stickerItem);
                        if (RecordVideoActivity.this.mAr != null) {
                            RecordVideoActivity.this.mAr.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mBR != null) {
                        RecordVideoActivity.this.mBR.setDownLoadSticker(null);
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
                    recordVideoActivity.bm(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dBn() {
                    if (RecordVideoActivity.this.mBR != null) {
                        RecordVideoActivity.this.mBR.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mCl.dEb();
        if (this.mBR != null && this.mCk) {
            dCB();
        }
        if (this.mgu != null) {
            this.mgu.MF("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mAr.onPause();
        if (this.mBR != null) {
            if (this.mAj != null && this.mAj.getStatus() == 6) {
                this.mBR.stopRecord();
                dDT();
            }
            if (this.mAj != null && this.mAj.bmc()) {
                this.mBR.stopRecord();
            }
        }
        if (this.mCn != null) {
            this.mCn.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mAj == null || this.mAj.getStatus() != 7) {
            if (this.mAj != null && this.mAj.getStatus() == 6) {
                if (this.mBR != null) {
                    this.mBR.stopRecord();
                }
                dDT();
            } else if (this.mAj != null && this.mAj.onBackPressed()) {
                finish();
            } else {
                if (this.hWL == null) {
                    this.hWL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hWL.nt(R.string.video_quit_confirm);
                    this.hWL.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hWL.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hWL.ig(true);
                    this.hWL.b(getPageContext());
                }
                this.hWL.bhg();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mCb.setVisibility(4);
        if (view == this.gIr) {
            onBackPressed();
        } else if (view == this.mBT) {
            if (this.mAj.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mAr.dDp();
            dDK();
        } else if (view == this.mBU) {
            if (this.mAj.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mBU.setOnClickListener(null);
            this.mAr.dDr();
            if (this.mAr.dDs() && this.mAr.dDq()) {
                this.mAr.dDp();
            }
            dDK();
            this.mBU.setOnClickListener(this);
        } else if (view == this.mBV) {
            dDM();
        }
    }

    private void dDK() {
        if (this.mAr.dDs()) {
            this.mBT.setVisibility(8);
        } else {
            this.mBT.setVisibility(0);
        }
        if (this.mAr.dDq()) {
            this.mBT.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mBT.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dDL() {
        return this.mBW;
    }

    public void dDM() {
        this.mCb.setVisibility(4);
        if (this.mAj.getStatus() != 6) {
            this.mAj.setStatus(6);
            dDR();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mCe == null) {
                this.mCe = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mCe.setDuration(500L);
                this.mCe.setRepeatCount(5);
                this.mCe.setRepeatMode(2);
                this.mCe.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mCe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.mAj.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mBX.setVisibility(0);
                        RecordVideoActivity.this.mBX.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mBX.setVisibility(8);
                    if (RecordVideoActivity.this.mAj.getStatus() == 6) {
                        RecordVideoActivity.this.mBR.dEe();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.mAj.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mBX.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mBX.setText("");
                        }
                    }
                }
            });
            this.mBX.setAnimation(this.mCe);
            this.mCe.startNow();
            this.mBR.dDM();
            if (this.mCn != null) {
                this.mCn.dDG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDN() {
        if (this.mAj.getStatus() == 1) {
            this.mCb.setVisibility(4);
            if (this.mAj.getStatus() != 6) {
                this.mBR.dDN();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDO() {
        this.mCb.setVisibility(4);
        if (this.mAj.getStatus() != 6) {
            this.mBR.dDO();
            if (this.mBR.dEi()) {
                dDI();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDP() {
        this.mCb.setVisibility(4);
        if (this.mAj.getStatus() != 6) {
            this.mBR.dDP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dDQ() {
        this.mCb.setVisibility(4);
        if (this.mAj.getStatus() != 6) {
            this.mBR.dDQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDR() {
        this.mCj = true;
        if (this.mCd != null && this.mCd.isRunning()) {
            this.mCd.cancel();
        }
        if (this.mCc == null) {
            this.mCc = new AnimatorSet();
            this.mCc.playTogether(ObjectAnimator.ofFloat(this.mBS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mBY, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mCo, "alpha", 1.0f, 0.0f));
            this.mCc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDS) {
                        RecordVideoActivity.this.mBS.setVisibility(8);
                        RecordVideoActivity.this.mBY.setVisibility(8);
                        RecordVideoActivity.this.mCo.setVisibility(8);
                    }
                }
            });
            this.mCc.setDuration(300L);
        }
        this.mCc.start();
        this.mBY.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDG() {
        if (this.inl == 2) {
            if (this.mCj) {
                this.mCj = false;
                if (this.mCn != null) {
                    this.mCn.dDG();
                }
            } else {
                return;
            }
        }
        if (this.mCc != null && this.mCc.isRunning()) {
            this.mCc.cancel();
        }
        if (this.mCd == null) {
            this.mCd = new AnimatorSet();
            this.mCd.playTogether(ObjectAnimator.ofFloat(this.mBS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mBY, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mCo, "alpha", 0.0f, 1.0f));
            this.mCd.setDuration(300L);
        }
        this.mBS.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mBY.setVisibility(0);
        }
        if (this.mAj.getStatus() == 1) {
            this.mCo.setVisibility(0);
        }
        this.mCd.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDS() {
        if (this.mAr != null) {
            this.mAr.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void D(boolean z, String str) {
                    RecordVideoActivity.this.mAj.setStatus(1);
                    RecordVideoActivity.this.dDG();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mCp != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mCp)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mCp);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mCp = new ImageFileInfo();
                        RecordVideoActivity.this.mCp.setFilePath(str);
                        RecordVideoActivity.this.mCp.setContentUriStr(null);
                        RecordVideoActivity.this.mCp.setTempFile(true);
                        RecordVideoActivity.this.mCp.setAlbumnId(null);
                        RecordVideoActivity.this.mCp.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mCp);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.ifV, RecordVideoActivity.this.mCh)));
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
    public void dDT() {
        this.mCe.cancel();
        this.mCe.setAnimationListener(null);
        this.mBX.clearAnimation();
        this.mBX.setVisibility(8);
        if (this.mCn != null) {
            this.mCn.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDU() {
        dvm();
    }

    private void dvm() {
        if (this.mCf != null) {
            this.mCf.cancel();
        }
        if (this.mCg == null) {
            this.mCg = ObjectAnimator.ofFloat(this.mCo, "alpha", 1.0f, 0.0f);
            this.mCg.setDuration(500L);
            this.mCg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mDS) {
                        RecordVideoActivity.this.mCo.setVisibility(8);
                    }
                }
            });
        }
        this.mCg.start();
    }

    private void dvl() {
        if (this.mCg != null) {
            this.mCg.cancel();
        }
        if (this.mCf == null) {
            this.mCf = ObjectAnimator.ofFloat(this.mCo, "alpha", 0.0f, 1.0f);
            this.mCf.setDuration(500L);
        }
        this.mCo.setVisibility(0);
        this.mCf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDV() {
        this.mBY.reset();
        if (this.mAj.getStatus() == 1) {
            dvl();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDW() {
        if (this.buZ.getVisibility() != 0) {
            this.mBR.dEd();
            this.mAj.setStatus(8);
            dDG();
            if (this.mAr.mAX != null && this.mAr.mAX.size() > 0) {
                this.buZ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int mCt = 50;
        final int mCu = 1;
        Handler mCw = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mCa.K(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dEa();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void dEa() {
            this.mCw.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dEa();
            boolean z = RecordVideoActivity.this.mCn == null || TextUtils.isEmpty(RecordVideoActivity.this.mCn.dDF()) || !new File(RecordVideoActivity.this.mCn.dDF()).exists();
            if (RecordVideoActivity.this.mAr.mAX.size() > 1) {
                return com.baidu.tieba.video.meida.h.dCS().a(RecordVideoActivity.this.mAr.mAX, RecordVideoActivity.this.mAr.dDj(), z);
            }
            File file = new File(RecordVideoActivity.this.mAr.mAX.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.mAr.dDj());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dCS().a(RecordVideoActivity.this.mAr.mAX, RecordVideoActivity.this.mAr.dDj(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mBR.dEj();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dDH();
                    RecordVideoActivity.this.Jf(102);
                    RecordVideoActivity.this.buZ.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dDH();
                RecordVideoActivity.this.Jf(102);
                RecordVideoActivity.this.buZ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.buZ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bm(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mCa.K(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mBR == null || y.isEmpty(this.mBR.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mBR.getChoosedBeautyList()) {
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
        if (this.mBR == null || y.isEmpty(this.mBR.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mBR.getChoosedFilterList()) {
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
        if (this.mBR == null || y.isEmpty(this.mBR.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mBR.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDX() {
        this.mCb.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDY() {
        this.mCb.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dDZ() {
        if (this.mAj.getStatus() == 1) {
            this.mCo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.mAr != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.mAr.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new aq("c12421").ai("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mBY.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mBY.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.mAr.setFilter((String) eVar.getValue());
                        aq aqVar = new aq("c12496");
                        aqVar.dD("obj_id", (String) eVar.getValue());
                        if (this.mAj.getStatus() == 1) {
                            aqVar.ai("obj_type", 1);
                        } else {
                            aqVar.ai("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mBY.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mBY.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mCn.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mBY.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mBY.setViewChoosed(0, true);
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
            this.mCm = stickerItem;
            this.mCl.Sd(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.mAr != null) {
                    this.mAr.setSticker(null);
                    this.mCr = false;
                }
                if (this.mBR != null) {
                    this.mBR.setDownLoadSticker(null);
                }
                this.mBZ.setVisibility(8);
                this.mBY.setViewChoosed(1, false);
                return;
            }
            String Sa = this.mCl.Sa(stickerItem.resource);
            if (!StringUtils.isNull(Sa)) {
                a(stickerItem, Sa);
                if (this.mBR != null) {
                    this.mBR.setDownLoadSticker(null);
                }
            } else {
                if (this.mBR != null) {
                    this.mBR.setDownLoadSticker(stickerItem);
                }
                this.mCl.Sb(stickerItem.resource);
            }
            this.mBY.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.mAr != null) {
                this.mAr.setSticker(stickerItem);
                this.mCr = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mBZ.setText(stickerItem.desc);
                this.mBZ.setVisibility(0);
                this.mBZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mBZ.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.mBZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dt(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mBR.getLayoutParams();
            layoutParams.height = i4;
            this.mBR.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String RI = com.baidu.tieba.video.editvideo.model.a.dBT().RI(stringExtra);
                if (this.mCn != null && !TextUtils.isEmpty(RI)) {
                    this.mCn.gb(RI, stringExtra2);
                    this.mBR.dCX();
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
        if (this.mAj.getStatus() == 8) {
            this.mBR.dEc();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void wN(boolean z) {
        if (this.mAj != null && (this.mAj.getStatus() == 1 || this.mAj.getStatus() == 3 || this.mAj.getStatus() == 4)) {
            if (!z && this.mCr) {
                this.mBW.dDw();
                return;
            } else {
                this.mBW.dDx();
                return;
            }
        }
        this.mBW.dDx();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ah(int i, boolean z) {
        int i2 = 1;
        if (this.inl != i) {
            switch (i) {
                case 1:
                    if (this.mCn != null) {
                        this.mCn.aWR();
                    }
                    this.mAr.setFilter("origin");
                    this.mBY.setViewChoosed(0, false);
                    this.mBY.setViewChoosed(3, false);
                    this.mBR.Jh(1);
                    this.mBY.setViewVisibility(0, 8);
                    this.mBY.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mBY.setViewVisibility(0, 0);
                    this.mBY.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.inl = i;
            this.mBR.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new aq().ai("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dDE() {
        if (this.mAj.getStatus() == 1 && !this.mBR.dEh()) {
            ah(1, true);
            this.mCo.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dDD() {
        if (this.mAj.getStatus() == 1 && !this.mBR.dEh()) {
            ah(2, true);
            this.mCo.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jf(int i) {
        if (this.mgu != null) {
            this.mgu.bn(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(int i, String str) {
        if (this.mgu != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mgu.bm(i, str);
        }
    }
}
