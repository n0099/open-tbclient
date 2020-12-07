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
/* loaded from: classes23.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View buh;
    private TextView byY;
    private final CustomMessageListener fXu;
    private com.baidu.tbadk.core.dialog.a iWJ;
    private ImageView jVn;
    private ForumWriteData jfR;
    private int jqd;
    private final CustomMessageListener jrS;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private SelectMusicModel nCD;
    private String nCz;
    private b.a nFS;
    private i nHm;
    protected h nHu;
    private RecordLayout nIR;
    private VideoControllerLayout nIS;
    private RelativeLayout nIT;
    private ImageView nIU;
    private ImageView nIV;
    private ImageView nIW;
    private PreviewViewContainer nIX;
    private VideoEffectButtonLayout nIY;
    private TextView nIZ;
    private b nIc;
    private RoundProgressBar nJa;
    private TextView nJb;
    private AnimatorSet nJc;
    private AnimatorSet nJd;
    private ScaleAnimation nJe;
    private ObjectAnimator nJf;
    private ObjectAnimator nJg;
    private int nJh;
    private int nJi;
    private boolean nJj;
    private boolean nJk = true;
    private l nJl;
    private StickerItem nJm;
    protected j nJn;
    private RecordTabLayout nJo;
    private ImageFileInfo nJp;
    private HttpMessageListener nJq;
    private boolean nJr;
    private com.baidu.tieba.l.h nnb;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnb = lVar.djb();
        }
        if (this.nnb != null) {
            this.nnb.diK();
        }
        this.nFS = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void gg(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nIS != null) {
                        RecordVideoActivity.this.nIS.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nIS != null) {
                    RecordVideoActivity.this.nIS.setHasLocalVideo(true);
                    RecordVideoActivity.this.nJk = false;
                }
            }
        };
        this.nJq = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nIS != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nIS.setStickerItems(list);
                    }
                }
            }
        };
        this.jrS = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fXu = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dWq() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nHu.nFh);
        videoInfo.setVideoDuration(this.nHm.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nHu.nFh).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jfR == null ? "" : this.jfR.forumName;
        String str2 = this.jfR == null ? "" : this.jfR.forumId;
        int i = this.jfR == null ? -1 : this.jfR.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jfR.writeCallFrom, str, str2, this.nCz, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.jfR != null ? this.jfR.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jfR != null ? this.jfR.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.jfR.mFrom);
        if (this.nJn != null) {
            this.nJn.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nnb != null) {
            this.nnb.diN();
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
        if (this.nHm != null && this.nHm.bwP()) {
            this.nHm.stopRecord();
        }
        if (this.nCD != null) {
            this.nCD.cancelLoadData();
        }
        if (this.nnb != null) {
            this.nnb.Pp("record");
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
        this.nJh = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nJi = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jfR = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nCz = getIntent().getStringExtra("video_title");
        initUI();
        this.nCD = new SelectMusicModel(getPageContext(), this.nIS);
        this.nCD.dUG();
        this.nJn = new j(this);
        this.nJn.b(this.nCD);
        this.nHm.a(this.nJn);
        registerListener(this.nJq);
        registerListener(this.jrS);
        registerListener(this.fXu);
        dWr();
        if (Build.VERSION.SDK_INT >= 28 && an.btO() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.w.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dWr() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dVk() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.nFS);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nIR = (RecordLayout) findViewById(R.id.root_layout);
        this.nIR.setListener(this);
        this.nHm = new i(this);
        this.nIS = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nIS.setRecordController(this.nHm);
        this.nIS.setRecordControlListener(this);
        this.nIS.setEffectChoosedListener(this);
        this.nIT = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.jVn = (ImageView) findViewById(R.id.close_page);
        this.jVn.setOnClickListener(this);
        this.nIU = (ImageView) findViewById(R.id.flash_switch);
        this.nIU.setOnClickListener(this);
        this.nIV = (ImageView) findViewById(R.id.camera_switch);
        this.nIV.setOnClickListener(this);
        this.nIW = (ImageView) findViewById(R.id.count_down);
        this.nIW.setOnClickListener(this);
        this.nIX = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nHu = new h(this);
        this.nHu.a(this);
        this.nHu.setFaceIdentifyStateListener(this);
        this.nHu.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dWe() {
                if (RecordVideoActivity.this.nIS.dWQ()) {
                    RecordVideoActivity.this.nIS.a((m) null);
                }
            }
        });
        this.nIY = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nIY.setListener(this);
        this.nHm.a(this.nIY);
        this.nIY.setViewChoosed(2, true);
        this.byY = (TextView) findViewById(R.id.tv_count_down);
        this.nIZ = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.byY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.byY.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nIY.setVisibility(8);
        }
        this.buh = findViewById(R.id.progress_layout);
        this.nJa = (RoundProgressBar) this.buh.findViewById(R.id.video_progress);
        this.nJb = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nJb.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nJb.setLayoutParams(layoutParams);
        this.nJo = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Mo(this.nJi);
        } else {
            Mo(1);
        }
        dWs();
    }

    private void Mo(int i) {
        if (this.nJo != null) {
            if (i == 0) {
                this.nJo.bX(1, getString(R.string.tab_photo));
                this.nJo.bX(2, getString(R.string.tab_record));
                this.nJo.setListener(this);
                this.nJo.setCurrentTab(2, false);
                ak(2, false);
            } else if (i == 1) {
                this.nJo.bX(1, getString(R.string.tab_photo));
                this.nJo.setShowIndicator(false);
                this.nJo.setCurrentTab(1, false);
                ak(1, false);
            } else {
                this.nJo.bX(2, getString(R.string.tab_record));
                this.nJo.setShowIndicator(false);
                this.nJo.setCurrentTab(2, false);
                ak(2, false);
            }
        }
    }

    private void dWs() {
        if (com.baidu.tbadk.core.util.g.bsX()) {
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
        this.nHu.onResume();
        this.nIc = this.nHu.dVV();
        if (this.nIc != null) {
            this.nIc.setRecordController(this.nHm);
            this.nIX.setZoomHelper(this.nIc);
        }
        dWt();
        if (this.nJl == null) {
            this.nJl = new l();
            this.nJl.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gB(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nJm, str2);
                    if (RecordVideoActivity.this.nIS != null) {
                        RecordVideoActivity.this.nIS.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void UG(String str) {
                    if (RecordVideoActivity.this.nIS != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nIS.b(stickerItem);
                        if (RecordVideoActivity.this.nHu != null) {
                            RecordVideoActivity.this.nHu.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nIS != null) {
                        RecordVideoActivity.this.nIS.setDownLoadSticker(null);
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
                public void dTU() {
                    if (RecordVideoActivity.this.nIS != null) {
                        RecordVideoActivity.this.nIS.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nJl.dWK();
        if (this.nIS != null && this.nJk) {
            dVk();
        }
        if (this.nnb != null) {
            this.nnb.Po("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nHu.onPause();
        if (this.nIS != null) {
            if (this.nHm != null && this.nHm.getStatus() == 6) {
                this.nIS.stopRecord();
                dWC();
            }
            if (this.nHm != null && this.nHm.bwP()) {
                this.nIS.stopRecord();
            }
        }
        if (this.nJn != null) {
            this.nJn.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nHm == null || this.nHm.getStatus() != 7) {
            if (this.nHm != null && this.nHm.getStatus() == 6) {
                if (this.nIS != null) {
                    this.nIS.stopRecord();
                }
                dWC();
            } else if (this.nHm != null && this.nHm.onBackPressed()) {
                finish();
            } else {
                if (this.iWJ == null) {
                    this.iWJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.iWJ.oQ(R.string.video_quit_confirm);
                    this.iWJ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.iWJ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.iWJ.jl(true);
                    this.iWJ.b(getPageContext());
                }
                this.iWJ.brv();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nJb.setVisibility(4);
        if (view == this.jVn) {
            onBackPressed();
        } else if (view == this.nIU) {
            if (this.nHm.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nHu.dVY();
            dWt();
        } else if (view == this.nIV) {
            if (this.nHm.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nIV.setOnClickListener(null);
            this.nHu.dWa();
            if (this.nHu.dWb() && this.nHu.dVZ()) {
                this.nHu.dVY();
            }
            dWt();
            this.nIV.setOnClickListener(this);
        } else if (view == this.nIW) {
            dWv();
        }
    }

    private void dWt() {
        if (this.nHu.dWb()) {
            this.nIU.setVisibility(8);
        } else {
            this.nIU.setVisibility(0);
        }
        if (this.nHu.dVZ()) {
            this.nIU.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nIU.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dWu() {
        return this.nIX;
    }

    public void dWv() {
        this.nJb.setVisibility(4);
        if (this.nHm.getStatus() != 6) {
            this.nHm.setStatus(6);
            dWA();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nJe == null) {
                this.nJe = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nJe.setDuration(500L);
                this.nJe.setRepeatCount(5);
                this.nJe.setRepeatMode(2);
                this.nJe.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nJe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nHm.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.byY.setVisibility(0);
                        RecordVideoActivity.this.byY.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.byY.setVisibility(8);
                    if (RecordVideoActivity.this.nHm.getStatus() == 6) {
                        RecordVideoActivity.this.nIS.dWN();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nHm.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.byY.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.byY.setText("");
                        }
                    }
                }
            });
            this.byY.setAnimation(this.nJe);
            this.nJe.startNow();
            this.nIS.dWv();
            if (this.nJn != null) {
                this.nJn.dWp();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWw() {
        if (this.nHm.getStatus() == 1) {
            this.nJb.setVisibility(4);
            if (this.nHm.getStatus() != 6) {
                this.nIS.dWw();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWx() {
        this.nJb.setVisibility(4);
        if (this.nHm.getStatus() != 6) {
            this.nIS.dWx();
            if (this.nIS.dWR()) {
                dWr();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWy() {
        this.nJb.setVisibility(4);
        if (this.nHm.getStatus() != 6) {
            this.nIS.dWy();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWz() {
        this.nJb.setVisibility(4);
        if (this.nHm.getStatus() != 6) {
            this.nIS.dWz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWA() {
        this.nJj = true;
        if (this.nJd != null && this.nJd.isRunning()) {
            this.nJd.cancel();
        }
        if (this.nJc == null) {
            this.nJc = new AnimatorSet();
            this.nJc.playTogether(ObjectAnimator.ofFloat(this.nIT, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nIY, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nJo, "alpha", 1.0f, 0.0f));
            this.nJc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKO) {
                        RecordVideoActivity.this.nIT.setVisibility(8);
                        RecordVideoActivity.this.nIY.setVisibility(8);
                        RecordVideoActivity.this.nJo.setVisibility(8);
                    }
                }
            });
            this.nJc.setDuration(300L);
        }
        this.nJc.start();
        this.nIY.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWp() {
        if (this.jqd == 2) {
            if (this.nJj) {
                this.nJj = false;
                if (this.nJn != null) {
                    this.nJn.dWp();
                }
            } else {
                return;
            }
        }
        if (this.nJc != null && this.nJc.isRunning()) {
            this.nJc.cancel();
        }
        if (this.nJd == null) {
            this.nJd = new AnimatorSet();
            this.nJd.playTogether(ObjectAnimator.ofFloat(this.nIT, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nIY, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nJo, "alpha", 0.0f, 1.0f));
            this.nJd.setDuration(300L);
        }
        this.nIT.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nIY.setVisibility(0);
        }
        if (this.nHm.getStatus() == 1) {
            this.nJo.setVisibility(0);
        }
        this.nJd.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWB() {
        if (this.nHu != null) {
            this.nHu.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void G(boolean z, String str) {
                    RecordVideoActivity.this.nHm.setStatus(1);
                    RecordVideoActivity.this.dWp();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nJp != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nJp)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nJp);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nJp = new ImageFileInfo();
                        RecordVideoActivity.this.nJp.setFilePath(str);
                        RecordVideoActivity.this.nJp.setContentUriStr(null);
                        RecordVideoActivity.this.nJp.setTempFile(true);
                        RecordVideoActivity.this.nJp.setAlbumnId(null);
                        RecordVideoActivity.this.nJp.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nJp);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jfR, RecordVideoActivity.this.nJh)));
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
    public void dWC() {
        this.nJe.cancel();
        this.nJe.setAnimationListener(null);
        this.byY.clearAnimation();
        this.byY.setVisibility(8);
        if (this.nJn != null) {
            this.nJn.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWD() {
        dNH();
    }

    private void dNH() {
        if (this.nJf != null) {
            this.nJf.cancel();
        }
        if (this.nJg == null) {
            this.nJg = ObjectAnimator.ofFloat(this.nJo, "alpha", 1.0f, 0.0f);
            this.nJg.setDuration(500L);
            this.nJg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKO) {
                        RecordVideoActivity.this.nJo.setVisibility(8);
                    }
                }
            });
        }
        this.nJg.start();
    }

    private void dNG() {
        if (this.nJg != null) {
            this.nJg.cancel();
        }
        if (this.nJf == null) {
            this.nJf = ObjectAnimator.ofFloat(this.nJo, "alpha", 0.0f, 1.0f);
            this.nJf.setDuration(500L);
        }
        this.nJo.setVisibility(0);
        this.nJf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWE() {
        this.nIY.reset();
        if (this.nHm.getStatus() == 1) {
            dNG();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWF() {
        if (this.buh.getVisibility() != 0) {
            this.nIS.dWM();
            this.nHm.setStatus(8);
            dWp();
            if (this.nHu.nIa != null && this.nHu.nIa.size() > 0) {
                this.buh.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nJt = 50;
        final int nJu = 1;
        Handler nJv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nJa.P(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dWJ();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dWJ() {
            this.nJv.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dWJ();
            boolean z = RecordVideoActivity.this.nJn == null || TextUtils.isEmpty(RecordVideoActivity.this.nJn.dWo()) || !new File(RecordVideoActivity.this.nJn.dWo()).exists();
            if (RecordVideoActivity.this.nHu.nIa.size() > 1) {
                return com.baidu.tieba.video.meida.h.dVB().a(RecordVideoActivity.this.nHu.nIa, RecordVideoActivity.this.nHu.dVS(), z);
            }
            File file = new File(RecordVideoActivity.this.nHu.nIa.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nHu.dVS());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dVB().a(RecordVideoActivity.this.nHu.nIa, RecordVideoActivity.this.nHu.dVS(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.nIS.dWS();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dWq();
                    RecordVideoActivity.this.Mp(102);
                    RecordVideoActivity.this.buh.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dWq();
                RecordVideoActivity.this.Mp(102);
                RecordVideoActivity.this.buh.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.buh.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bD(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nJa.P(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nIS == null || y.isEmpty(this.nIS.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nIS.getChoosedBeautyList()) {
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
        if (this.nIS == null || y.isEmpty(this.nIS.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nIS.getChoosedFilterList()) {
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
        if (this.nIS == null || y.isEmpty(this.nIS.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nIS.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWG() {
        this.nJb.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWH() {
        this.nJb.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWI() {
        if (this.nHm.getStatus() == 1) {
            this.nJo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nHu != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nHu.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ar("c12421").al("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nIY.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nIY.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nHu.setFilter((String) eVar.getValue());
                        ar arVar = new ar("c12496");
                        arVar.dY("obj_id", (String) eVar.getValue());
                        if (this.nHm.getStatus() == 1) {
                            arVar.al("obj_type", 1);
                        } else {
                            arVar.al("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nIY.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nIY.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nJn.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nIY.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nIY.setViewChoosed(0, true);
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
            this.nJm = stickerItem;
            this.nJl.Vh(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nHu != null) {
                    this.nHu.setSticker(null);
                    this.nJr = false;
                }
                if (this.nIS != null) {
                    this.nIS.setDownLoadSticker(null);
                }
                this.nIZ.setVisibility(8);
                this.nIY.setViewChoosed(1, false);
                return;
            }
            String Ve = this.nJl.Ve(stickerItem.resource);
            if (!StringUtils.isNull(Ve)) {
                a(stickerItem, Ve);
                if (this.nIS != null) {
                    this.nIS.setDownLoadSticker(null);
                }
            } else {
                if (this.nIS != null) {
                    this.nIS.setDownLoadSticker(stickerItem);
                }
                this.nJl.Vf(stickerItem.resource);
            }
            this.nIY.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nHu != null) {
                this.nHu.setSticker(stickerItem);
                this.nJr = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nIZ.setText(stickerItem.desc);
                this.nIZ.setVisibility(0);
                this.nIZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nIZ.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nIZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dH(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nIS.getLayoutParams();
            layoutParams.height = i4;
            this.nIS.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String UM = com.baidu.tieba.video.editvideo.model.a.dUA().UM(stringExtra);
                if (this.nJn != null && !TextUtils.isEmpty(UM)) {
                    this.nJn.gE(UM, stringExtra2);
                    this.nIS.dVG();
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
        if (this.nHm.getStatus() == 8) {
            this.nIS.dWL();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yP(boolean z) {
        if (this.nHm != null && (this.nHm.getStatus() == 1 || this.nHm.getStatus() == 3 || this.nHm.getStatus() == 4)) {
            if (!z && this.nJr) {
                this.nIX.dWf();
                return;
            } else {
                this.nIX.dWg();
                return;
            }
        }
        this.nIX.dWg();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ak(int i, boolean z) {
        int i2 = 1;
        if (this.jqd != i) {
            switch (i) {
                case 1:
                    if (this.nJn != null) {
                        this.nJn.bhc();
                    }
                    this.nHu.setFilter("origin");
                    this.nIY.setViewChoosed(0, false);
                    this.nIY.setViewChoosed(3, false);
                    this.nIS.Mr(1);
                    this.nIY.setViewVisibility(0, 8);
                    this.nIY.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nIY.setViewVisibility(0, 0);
                    this.nIY.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jqd = i;
            this.nIS.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ar().al("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dWn() {
        if (this.nHm.getStatus() == 1 && !this.nIS.dWQ()) {
            ak(1, true);
            this.nJo.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dWm() {
        if (this.nHm.getStatus() == 1 && !this.nIS.dWQ()) {
            ak(2, true);
            this.nJo.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp(int i) {
        if (this.nnb != null) {
            this.nnb.bE(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, String str) {
        if (this.nnb != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nnb.bD(i, str);
        }
    }
}
