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
    private View boX;
    private TextView btN;
    private final CustomMessageListener fPl;
    private com.baidu.tbadk.core.dialog.a iLS;
    private ForumWriteData iUV;
    private ImageView jHK;
    private int jcA;
    private final CustomMessageListener jep;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tieba.l.h mZc;
    private SelectMusicModel noC;
    private String noy;
    private b.a nrR;
    private i ntk;
    protected h nts;
    private RecordLayout nuQ;
    private VideoControllerLayout nuR;
    private RelativeLayout nuS;
    private ImageView nuT;
    private ImageView nuU;
    private ImageView nuV;
    private PreviewViewContainer nuW;
    private VideoEffectButtonLayout nuX;
    private TextView nuY;
    private RoundProgressBar nuZ;
    private b nua;
    private TextView nva;
    private AnimatorSet nvb;
    private AnimatorSet nvc;
    private ScaleAnimation nvd;
    private ObjectAnimator nve;
    private ObjectAnimator nvf;
    private int nvg;
    private int nvh;
    private boolean nvi;
    private boolean nvj = true;
    private l nvk;
    private StickerItem nvl;
    protected j nvm;
    private RecordTabLayout nvn;
    private ImageFileInfo nvo;
    private HttpMessageListener nvp;
    private boolean nvq;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.mZc = lVar.ddQ();
        }
        if (this.mZc != null) {
            this.mZc.ddz();
        }
        this.nrR = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fS(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nuR != null) {
                        RecordVideoActivity.this.nuR.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nuR != null) {
                    RecordVideoActivity.this.nuR.setHasLocalVideo(true);
                    RecordVideoActivity.this.nvj = false;
                }
            }
        };
        this.nvp = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nuR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nuR.setStickerItems(list);
                    }
                }
            }
        };
        this.jep = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fPl = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dQW() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nts.nrg);
        videoInfo.setVideoDuration(this.ntk.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nts.nrg).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.iUV == null ? "" : this.iUV.forumName;
        String str2 = this.iUV == null ? "" : this.iUV.forumId;
        int i = this.iUV == null ? -1 : this.iUV.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.iUV.writeCallFrom, str, str2, this.noy, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.iUV != null ? this.iUV.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.iUV != null ? this.iUV.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.iUV.mFrom);
        if (this.nvm != null) {
            this.nvm.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.mZc != null) {
            this.mZc.ddC();
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
        if (this.ntk != null && this.ntk.btp()) {
            this.ntk.stopRecord();
        }
        if (this.noC != null) {
            this.noC.cancelLoadData();
        }
        if (this.mZc != null) {
            this.mZc.Oi("record");
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
        this.nvg = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nvh = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.iUV = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.noy = getIntent().getStringExtra("video_title");
        initUI();
        this.noC = new SelectMusicModel(getPageContext(), this.nuR);
        this.noC.dPo();
        this.nvm = new j(this);
        this.nvm.b(this.noC);
        this.ntk.a(this.nvm);
        registerListener(this.nvp);
        registerListener(this.jep);
        registerListener(this.fPl);
        dQX();
        if (Build.VERSION.SDK_INT >= 28 && an.bqt() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.w.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dQX() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dPQ() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.nrR);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nuQ = (RecordLayout) findViewById(R.id.root_layout);
        this.nuQ.setListener(this);
        this.ntk = new i(this);
        this.nuR = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nuR.setRecordController(this.ntk);
        this.nuR.setRecordControlListener(this);
        this.nuR.setEffectChoosedListener(this);
        this.nuS = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.jHK = (ImageView) findViewById(R.id.close_page);
        this.jHK.setOnClickListener(this);
        this.nuT = (ImageView) findViewById(R.id.flash_switch);
        this.nuT.setOnClickListener(this);
        this.nuU = (ImageView) findViewById(R.id.camera_switch);
        this.nuU.setOnClickListener(this);
        this.nuV = (ImageView) findViewById(R.id.count_down);
        this.nuV.setOnClickListener(this);
        this.nuW = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nts = new h(this);
        this.nts.a(this);
        this.nts.setFaceIdentifyStateListener(this);
        this.nts.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dQK() {
                if (RecordVideoActivity.this.nuR.dRw()) {
                    RecordVideoActivity.this.nuR.a((m) null);
                }
            }
        });
        this.nuX = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nuX.setListener(this);
        this.ntk.a(this.nuX);
        this.nuX.setViewChoosed(2, true);
        this.btN = (TextView) findViewById(R.id.tv_count_down);
        this.nuY = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.btN.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.btN.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nuX.setVisibility(8);
        }
        this.boX = findViewById(R.id.progress_layout);
        this.nuZ = (RoundProgressBar) this.boX.findViewById(R.id.video_progress);
        this.nva = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nva.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nva.setLayoutParams(layoutParams);
        this.nvn = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Lw(this.nvh);
        } else {
            Lw(1);
        }
        dQY();
    }

    private void Lw(int i) {
        if (this.nvn != null) {
            if (i == 0) {
                this.nvn.bX(1, getString(R.string.tab_photo));
                this.nvn.bX(2, getString(R.string.tab_record));
                this.nvn.setListener(this);
                this.nvn.setCurrentTab(2, false);
                ak(2, false);
            } else if (i == 1) {
                this.nvn.bX(1, getString(R.string.tab_photo));
                this.nvn.setShowIndicator(false);
                this.nvn.setCurrentTab(1, false);
                ak(1, false);
            } else {
                this.nvn.bX(2, getString(R.string.tab_record));
                this.nvn.setShowIndicator(false);
                this.nvn.setCurrentTab(2, false);
                ak(2, false);
            }
        }
    }

    private void dQY() {
        if (com.baidu.tbadk.core.util.g.bpD()) {
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
        this.nts.onResume();
        this.nua = this.nts.dQB();
        if (this.nua != null) {
            this.nua.setRecordController(this.ntk);
            this.nuW.setZoomHelper(this.nua);
        }
        dQZ();
        if (this.nvk == null) {
            this.nvk = new l();
            this.nvk.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gw(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nvl, str2);
                    if (RecordVideoActivity.this.nuR != null) {
                        RecordVideoActivity.this.nuR.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Tr(String str) {
                    if (RecordVideoActivity.this.nuR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nuR.b(stickerItem);
                        if (RecordVideoActivity.this.nts != null) {
                            RecordVideoActivity.this.nts.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nuR != null) {
                        RecordVideoActivity.this.nuR.setDownLoadSticker(null);
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
                public void dOC() {
                    if (RecordVideoActivity.this.nuR != null) {
                        RecordVideoActivity.this.nuR.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nvk.dRq();
        if (this.nuR != null && this.nvj) {
            dPQ();
        }
        if (this.mZc != null) {
            this.mZc.Oh("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nts.onPause();
        if (this.nuR != null) {
            if (this.ntk != null && this.ntk.getStatus() == 6) {
                this.nuR.stopRecord();
                dRi();
            }
            if (this.ntk != null && this.ntk.btp()) {
                this.nuR.stopRecord();
            }
        }
        if (this.nvm != null) {
            this.nvm.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ntk == null || this.ntk.getStatus() != 7) {
            if (this.ntk != null && this.ntk.getStatus() == 6) {
                if (this.nuR != null) {
                    this.nuR.stopRecord();
                }
                dRi();
            } else if (this.ntk != null && this.ntk.onBackPressed()) {
                finish();
            } else {
                if (this.iLS == null) {
                    this.iLS = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.iLS.os(R.string.video_quit_confirm);
                    this.iLS.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.iLS.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.iLS.iW(true);
                    this.iLS.b(getPageContext());
                }
                this.iLS.bog();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nva.setVisibility(4);
        if (view == this.jHK) {
            onBackPressed();
        } else if (view == this.nuT) {
            if (this.ntk.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nts.dQE();
            dQZ();
        } else if (view == this.nuU) {
            if (this.ntk.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nuU.setOnClickListener(null);
            this.nts.dQG();
            if (this.nts.dQH() && this.nts.dQF()) {
                this.nts.dQE();
            }
            dQZ();
            this.nuU.setOnClickListener(this);
        } else if (view == this.nuV) {
            dRb();
        }
    }

    private void dQZ() {
        if (this.nts.dQH()) {
            this.nuT.setVisibility(8);
        } else {
            this.nuT.setVisibility(0);
        }
        if (this.nts.dQF()) {
            this.nuT.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nuT.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dRa() {
        return this.nuW;
    }

    public void dRb() {
        this.nva.setVisibility(4);
        if (this.ntk.getStatus() != 6) {
            this.ntk.setStatus(6);
            dRg();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nvd == null) {
                this.nvd = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nvd.setDuration(500L);
                this.nvd.setRepeatCount(5);
                this.nvd.setRepeatMode(2);
                this.nvd.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nvd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.ntk.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.btN.setVisibility(0);
                        RecordVideoActivity.this.btN.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.btN.setVisibility(8);
                    if (RecordVideoActivity.this.ntk.getStatus() == 6) {
                        RecordVideoActivity.this.nuR.dRt();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.ntk.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.btN.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.btN.setText("");
                        }
                    }
                }
            });
            this.btN.setAnimation(this.nvd);
            this.nvd.startNow();
            this.nuR.dRb();
            if (this.nvm != null) {
                this.nvm.dQV();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRc() {
        if (this.ntk.getStatus() == 1) {
            this.nva.setVisibility(4);
            if (this.ntk.getStatus() != 6) {
                this.nuR.dRc();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRd() {
        this.nva.setVisibility(4);
        if (this.ntk.getStatus() != 6) {
            this.nuR.dRd();
            if (this.nuR.dRx()) {
                dQX();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRe() {
        this.nva.setVisibility(4);
        if (this.ntk.getStatus() != 6) {
            this.nuR.dRe();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dRf() {
        this.nva.setVisibility(4);
        if (this.ntk.getStatus() != 6) {
            this.nuR.dRf();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRg() {
        this.nvi = true;
        if (this.nvc != null && this.nvc.isRunning()) {
            this.nvc.cancel();
        }
        if (this.nvb == null) {
            this.nvb = new AnimatorSet();
            this.nvb.playTogether(ObjectAnimator.ofFloat(this.nuS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nuX, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nvn, "alpha", 1.0f, 0.0f));
            this.nvb.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nwN) {
                        RecordVideoActivity.this.nuS.setVisibility(8);
                        RecordVideoActivity.this.nuX.setVisibility(8);
                        RecordVideoActivity.this.nvn.setVisibility(8);
                    }
                }
            });
            this.nvb.setDuration(300L);
        }
        this.nvb.start();
        this.nuX.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dQV() {
        if (this.jcA == 2) {
            if (this.nvi) {
                this.nvi = false;
                if (this.nvm != null) {
                    this.nvm.dQV();
                }
            } else {
                return;
            }
        }
        if (this.nvb != null && this.nvb.isRunning()) {
            this.nvb.cancel();
        }
        if (this.nvc == null) {
            this.nvc = new AnimatorSet();
            this.nvc.playTogether(ObjectAnimator.ofFloat(this.nuS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nuX, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nvn, "alpha", 0.0f, 1.0f));
            this.nvc.setDuration(300L);
        }
        this.nuS.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nuX.setVisibility(0);
        }
        if (this.ntk.getStatus() == 1) {
            this.nvn.setVisibility(0);
        }
        this.nvc.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRh() {
        if (this.nts != null) {
            this.nts.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void G(boolean z, String str) {
                    RecordVideoActivity.this.ntk.setStatus(1);
                    RecordVideoActivity.this.dQV();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nvo != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nvo)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nvo);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nvo = new ImageFileInfo();
                        RecordVideoActivity.this.nvo.setFilePath(str);
                        RecordVideoActivity.this.nvo.setContentUriStr(null);
                        RecordVideoActivity.this.nvo.setTempFile(true);
                        RecordVideoActivity.this.nvo.setAlbumnId(null);
                        RecordVideoActivity.this.nvo.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nvo);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.iUV, RecordVideoActivity.this.nvg)));
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
    public void dRi() {
        this.nvd.cancel();
        this.nvd.setAnimationListener(null);
        this.btN.clearAnimation();
        this.btN.setVisibility(8);
        if (this.nvm != null) {
            this.nvm.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRj() {
        dIr();
    }

    private void dIr() {
        if (this.nve != null) {
            this.nve.cancel();
        }
        if (this.nvf == null) {
            this.nvf = ObjectAnimator.ofFloat(this.nvn, "alpha", 1.0f, 0.0f);
            this.nvf.setDuration(500L);
            this.nvf.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nwN) {
                        RecordVideoActivity.this.nvn.setVisibility(8);
                    }
                }
            });
        }
        this.nvf.start();
    }

    private void dIq() {
        if (this.nvf != null) {
            this.nvf.cancel();
        }
        if (this.nve == null) {
            this.nve = ObjectAnimator.ofFloat(this.nvn, "alpha", 0.0f, 1.0f);
            this.nve.setDuration(500L);
        }
        this.nvn.setVisibility(0);
        this.nve.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRk() {
        this.nuX.reset();
        if (this.ntk.getStatus() == 1) {
            dIq();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRl() {
        if (this.boX.getVisibility() != 0) {
            this.nuR.dRs();
            this.ntk.setStatus(8);
            dQV();
            if (this.nts.ntY != null && this.nts.ntY.size() > 0) {
                this.boX.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nvs = 50;
        final int nvt = 1;
        Handler nvu = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nuZ.P(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dRp();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dRp() {
            this.nvu.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dRp();
            boolean z = RecordVideoActivity.this.nvm == null || TextUtils.isEmpty(RecordVideoActivity.this.nvm.dQU()) || !new File(RecordVideoActivity.this.nvm.dQU()).exists();
            if (RecordVideoActivity.this.nts.ntY.size() > 1) {
                return com.baidu.tieba.video.meida.h.dQh().a(RecordVideoActivity.this.nts.ntY, RecordVideoActivity.this.nts.dQy(), z);
            }
            File file = new File(RecordVideoActivity.this.nts.ntY.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nts.dQy());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dQh().a(RecordVideoActivity.this.nts.ntY, RecordVideoActivity.this.nts.dQy(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.nuR.dRy();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dQW();
                    RecordVideoActivity.this.Lx(102);
                    RecordVideoActivity.this.boX.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dQW();
                RecordVideoActivity.this.Lx(102);
                RecordVideoActivity.this.boX.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.boX.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bD(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nuZ.P(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nuR == null || y.isEmpty(this.nuR.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nuR.getChoosedBeautyList()) {
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
        if (this.nuR == null || y.isEmpty(this.nuR.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nuR.getChoosedFilterList()) {
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
        if (this.nuR == null || y.isEmpty(this.nuR.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nuR.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRm() {
        this.nva.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRn() {
        this.nva.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dRo() {
        if (this.ntk.getStatus() == 1) {
            this.nvn.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nts != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nts.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ar("c12421").ak("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nuX.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nuX.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nts.setFilter((String) eVar.getValue());
                        ar arVar = new ar("c12496");
                        arVar.dR("obj_id", (String) eVar.getValue());
                        if (this.ntk.getStatus() == 1) {
                            arVar.ak("obj_type", 1);
                        } else {
                            arVar.ak("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nuX.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nuX.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nvm.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nuX.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nuX.setViewChoosed(0, true);
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
            this.nvl = stickerItem;
            this.nvk.TS(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nts != null) {
                    this.nts.setSticker(null);
                    this.nvq = false;
                }
                if (this.nuR != null) {
                    this.nuR.setDownLoadSticker(null);
                }
                this.nuY.setVisibility(8);
                this.nuX.setViewChoosed(1, false);
                return;
            }
            String TP = this.nvk.TP(stickerItem.resource);
            if (!StringUtils.isNull(TP)) {
                a(stickerItem, TP);
                if (this.nuR != null) {
                    this.nuR.setDownLoadSticker(null);
                }
            } else {
                if (this.nuR != null) {
                    this.nuR.setDownLoadSticker(stickerItem);
                }
                this.nvk.TQ(stickerItem.resource);
            }
            this.nuX.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nts != null) {
                this.nts.setSticker(stickerItem);
                this.nvq = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nuY.setText(stickerItem.desc);
                this.nuY.setVisibility(0);
                this.nuY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nuY.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nuY.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dC(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nuR.getLayoutParams();
            layoutParams.height = i4;
            this.nuR.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Tx = com.baidu.tieba.video.editvideo.model.a.dPi().Tx(stringExtra);
                if (this.nvm != null && !TextUtils.isEmpty(Tx)) {
                    this.nvm.gz(Tx, stringExtra2);
                    this.nuR.dQm();
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
        if (this.ntk.getStatus() == 8) {
            this.nuR.dRr();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yk(boolean z) {
        if (this.ntk != null && (this.ntk.getStatus() == 1 || this.ntk.getStatus() == 3 || this.ntk.getStatus() == 4)) {
            if (!z && this.nvq) {
                this.nuW.dQL();
                return;
            } else {
                this.nuW.dQM();
                return;
            }
        }
        this.nuW.dQM();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ak(int i, boolean z) {
        int i2 = 1;
        if (this.jcA != i) {
            switch (i) {
                case 1:
                    if (this.nvm != null) {
                        this.nvm.bdX();
                    }
                    this.nts.setFilter("origin");
                    this.nuX.setViewChoosed(0, false);
                    this.nuX.setViewChoosed(3, false);
                    this.nuR.Lz(1);
                    this.nuX.setViewVisibility(0, 8);
                    this.nuX.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nuX.setViewVisibility(0, 0);
                    this.nuX.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jcA = i;
            this.nuR.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ar().ak("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dQT() {
        if (this.ntk.getStatus() == 1 && !this.nuR.dRw()) {
            ak(1, true);
            this.nvn.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dQS() {
        if (this.ntk.getStatus() == 1 && !this.nuR.dRw()) {
            ak(2, true);
            this.nvn.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lx(int i) {
        if (this.mZc != null) {
            this.mZc.bE(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, String str) {
        if (this.mZc != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.mZc.bD(i, str);
        }
    }
}
