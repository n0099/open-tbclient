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
    private final CustomMessageListener fXw;
    private com.baidu.tbadk.core.dialog.a iWL;
    private ImageView jVp;
    private ForumWriteData jfT;
    private int jqf;
    private final CustomMessageListener jrU;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String nCB;
    private SelectMusicModel nCF;
    private b.a nFU;
    private i nHo;
    protected h nHw;
    private RecordLayout nIT;
    private VideoControllerLayout nIU;
    private RelativeLayout nIV;
    private ImageView nIW;
    private ImageView nIX;
    private ImageView nIY;
    private PreviewViewContainer nIZ;
    private b nIe;
    private VideoEffectButtonLayout nJa;
    private TextView nJb;
    private RoundProgressBar nJc;
    private TextView nJd;
    private AnimatorSet nJe;
    private AnimatorSet nJf;
    private ScaleAnimation nJg;
    private ObjectAnimator nJh;
    private ObjectAnimator nJi;
    private int nJj;
    private int nJk;
    private boolean nJl;
    private boolean nJm = true;
    private l nJn;
    private StickerItem nJo;
    protected j nJp;
    private RecordTabLayout nJq;
    private ImageFileInfo nJr;
    private HttpMessageListener nJs;
    private boolean nJt;
    private com.baidu.tieba.l.h nnd;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.l.class);
        com.baidu.tieba.l.l lVar = runTask != null ? (com.baidu.tieba.l.l) runTask.getData() : null;
        if (lVar != null) {
            this.nnd = lVar.djc();
        }
        if (this.nnd != null) {
            this.nnd.diL();
        }
        this.nFU = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void gg(List<com.baidu.tieba.video.localvideo.d> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nIU != null) {
                        RecordVideoActivity.this.nIU.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nIU != null) {
                    RecordVideoActivity.this.nIU.setHasLocalVideo(true);
                    RecordVideoActivity.this.nJm = false;
                }
            }
        };
        this.nJs = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nIU != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nIU.setStickerItems(list);
                    }
                }
            }
        };
        this.jrU = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.fXw = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dWr() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nHw.nFj);
        videoInfo.setVideoDuration(this.nHo.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.nHw.nFj).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jfT == null ? "" : this.jfT.forumName;
        String str2 = this.jfT == null ? "" : this.jfT.forumId;
        int i = this.jfT == null ? -1 : this.jfT.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jfT.writeCallFrom, str, str2, this.nCB, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.jfT != null ? this.jfT.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jfT != null ? this.jfT.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.jfT.mFrom);
        if (this.nJp != null) {
            this.nJp.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nnd != null) {
            this.nnd.diO();
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
        if (this.nHo != null && this.nHo.bwP()) {
            this.nHo.stopRecord();
        }
        if (this.nCF != null) {
            this.nCF.cancelLoadData();
        }
        if (this.nnd != null) {
            this.nnd.Pp("record");
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
        this.nJj = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nJk = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jfT = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nCB = getIntent().getStringExtra("video_title");
        initUI();
        this.nCF = new SelectMusicModel(getPageContext(), this.nIU);
        this.nCF.dUH();
        this.nJp = new j(this);
        this.nJp.b(this.nCF);
        this.nHo.a(this.nJp);
        registerListener(this.nJs);
        registerListener(this.jrU);
        registerListener(this.fXw);
        dWs();
        if (Build.VERSION.SDK_INT >= 28 && an.btO() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.w.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dWs() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dVl() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.nFU);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nIT = (RecordLayout) findViewById(R.id.root_layout);
        this.nIT.setListener(this);
        this.nHo = new i(this);
        this.nIU = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nIU.setRecordController(this.nHo);
        this.nIU.setRecordControlListener(this);
        this.nIU.setEffectChoosedListener(this);
        this.nIV = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.jVp = (ImageView) findViewById(R.id.close_page);
        this.jVp.setOnClickListener(this);
        this.nIW = (ImageView) findViewById(R.id.flash_switch);
        this.nIW.setOnClickListener(this);
        this.nIX = (ImageView) findViewById(R.id.camera_switch);
        this.nIX.setOnClickListener(this);
        this.nIY = (ImageView) findViewById(R.id.count_down);
        this.nIY.setOnClickListener(this);
        this.nIZ = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nHw = new h(this);
        this.nHw.a(this);
        this.nHw.setFaceIdentifyStateListener(this);
        this.nHw.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dWf() {
                if (RecordVideoActivity.this.nIU.dWR()) {
                    RecordVideoActivity.this.nIU.a((m) null);
                }
            }
        });
        this.nJa = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nJa.setListener(this);
        this.nHo.a(this.nJa);
        this.nJa.setViewChoosed(2, true);
        this.byY = (TextView) findViewById(R.id.tv_count_down);
        this.nJb = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.byY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.byY.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nJa.setVisibility(8);
        }
        this.buh = findViewById(R.id.progress_layout);
        this.nJc = (RoundProgressBar) this.buh.findViewById(R.id.video_progress);
        this.nJd = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nJd.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nJd.setLayoutParams(layoutParams);
        this.nJq = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Mo(this.nJk);
        } else {
            Mo(1);
        }
        dWt();
    }

    private void Mo(int i) {
        if (this.nJq != null) {
            if (i == 0) {
                this.nJq.bX(1, getString(R.string.tab_photo));
                this.nJq.bX(2, getString(R.string.tab_record));
                this.nJq.setListener(this);
                this.nJq.setCurrentTab(2, false);
                ak(2, false);
            } else if (i == 1) {
                this.nJq.bX(1, getString(R.string.tab_photo));
                this.nJq.setShowIndicator(false);
                this.nJq.setCurrentTab(1, false);
                ak(1, false);
            } else {
                this.nJq.bX(2, getString(R.string.tab_record));
                this.nJq.setShowIndicator(false);
                this.nJq.setCurrentTab(2, false);
                ak(2, false);
            }
        }
    }

    private void dWt() {
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
        this.nHw.onResume();
        this.nIe = this.nHw.dVW();
        if (this.nIe != null) {
            this.nIe.setRecordController(this.nHo);
            this.nIZ.setZoomHelper(this.nIe);
        }
        dWu();
        if (this.nJn == null) {
            this.nJn = new l();
            this.nJn.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gB(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nJo, str2);
                    if (RecordVideoActivity.this.nIU != null) {
                        RecordVideoActivity.this.nIU.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void UG(String str) {
                    if (RecordVideoActivity.this.nIU != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nIU.b(stickerItem);
                        if (RecordVideoActivity.this.nHw != null) {
                            RecordVideoActivity.this.nHw.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nIU != null) {
                        RecordVideoActivity.this.nIU.setDownLoadSticker(null);
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
                public void dTV() {
                    if (RecordVideoActivity.this.nIU != null) {
                        RecordVideoActivity.this.nIU.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nJn.dWL();
        if (this.nIU != null && this.nJm) {
            dVl();
        }
        if (this.nnd != null) {
            this.nnd.Po("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nHw.onPause();
        if (this.nIU != null) {
            if (this.nHo != null && this.nHo.getStatus() == 6) {
                this.nIU.stopRecord();
                dWD();
            }
            if (this.nHo != null && this.nHo.bwP()) {
                this.nIU.stopRecord();
            }
        }
        if (this.nJp != null) {
            this.nJp.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nHo == null || this.nHo.getStatus() != 7) {
            if (this.nHo != null && this.nHo.getStatus() == 6) {
                if (this.nIU != null) {
                    this.nIU.stopRecord();
                }
                dWD();
            } else if (this.nHo != null && this.nHo.onBackPressed()) {
                finish();
            } else {
                if (this.iWL == null) {
                    this.iWL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.iWL.oQ(R.string.video_quit_confirm);
                    this.iWL.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.iWL.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.iWL.jl(true);
                    this.iWL.b(getPageContext());
                }
                this.iWL.brv();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nJd.setVisibility(4);
        if (view == this.jVp) {
            onBackPressed();
        } else if (view == this.nIW) {
            if (this.nHo.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nHw.dVZ();
            dWu();
        } else if (view == this.nIX) {
            if (this.nHo.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nIX.setOnClickListener(null);
            this.nHw.dWb();
            if (this.nHw.dWc() && this.nHw.dWa()) {
                this.nHw.dVZ();
            }
            dWu();
            this.nIX.setOnClickListener(this);
        } else if (view == this.nIY) {
            dWw();
        }
    }

    private void dWu() {
        if (this.nHw.dWc()) {
            this.nIW.setVisibility(8);
        } else {
            this.nIW.setVisibility(0);
        }
        if (this.nHw.dWa()) {
            this.nIW.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nIW.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dWv() {
        return this.nIZ;
    }

    public void dWw() {
        this.nJd.setVisibility(4);
        if (this.nHo.getStatus() != 6) {
            this.nHo.setStatus(6);
            dWB();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nJg == null) {
                this.nJg = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nJg.setDuration(500L);
                this.nJg.setRepeatCount(5);
                this.nJg.setRepeatMode(2);
                this.nJg.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nJg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nHo.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.byY.setVisibility(0);
                        RecordVideoActivity.this.byY.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.byY.setVisibility(8);
                    if (RecordVideoActivity.this.nHo.getStatus() == 6) {
                        RecordVideoActivity.this.nIU.dWO();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nHo.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.byY.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.byY.setText("");
                        }
                    }
                }
            });
            this.byY.setAnimation(this.nJg);
            this.nJg.startNow();
            this.nIU.dWw();
            if (this.nJp != null) {
                this.nJp.dWq();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWx() {
        if (this.nHo.getStatus() == 1) {
            this.nJd.setVisibility(4);
            if (this.nHo.getStatus() != 6) {
                this.nIU.dWx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWy() {
        this.nJd.setVisibility(4);
        if (this.nHo.getStatus() != 6) {
            this.nIU.dWy();
            if (this.nIU.dWS()) {
                dWs();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWz() {
        this.nJd.setVisibility(4);
        if (this.nHo.getStatus() != 6) {
            this.nIU.dWz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dWA() {
        this.nJd.setVisibility(4);
        if (this.nHo.getStatus() != 6) {
            this.nIU.dWA();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWB() {
        this.nJl = true;
        if (this.nJf != null && this.nJf.isRunning()) {
            this.nJf.cancel();
        }
        if (this.nJe == null) {
            this.nJe = new AnimatorSet();
            this.nJe.playTogether(ObjectAnimator.ofFloat(this.nIV, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nJa, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nJq, "alpha", 1.0f, 0.0f));
            this.nJe.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKQ) {
                        RecordVideoActivity.this.nIV.setVisibility(8);
                        RecordVideoActivity.this.nJa.setVisibility(8);
                        RecordVideoActivity.this.nJq.setVisibility(8);
                    }
                }
            });
            this.nJe.setDuration(300L);
        }
        this.nJe.start();
        this.nJa.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWq() {
        if (this.jqf == 2) {
            if (this.nJl) {
                this.nJl = false;
                if (this.nJp != null) {
                    this.nJp.dWq();
                }
            } else {
                return;
            }
        }
        if (this.nJe != null && this.nJe.isRunning()) {
            this.nJe.cancel();
        }
        if (this.nJf == null) {
            this.nJf = new AnimatorSet();
            this.nJf.playTogether(ObjectAnimator.ofFloat(this.nIV, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nJa, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nJq, "alpha", 0.0f, 1.0f));
            this.nJf.setDuration(300L);
        }
        this.nIV.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nJa.setVisibility(0);
        }
        if (this.nHo.getStatus() == 1) {
            this.nJq.setVisibility(0);
        }
        this.nJf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWC() {
        if (this.nHw != null) {
            this.nHw.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void G(boolean z, String str) {
                    RecordVideoActivity.this.nHo.setStatus(1);
                    RecordVideoActivity.this.dWq();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nJr != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nJr)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nJr);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nJr = new ImageFileInfo();
                        RecordVideoActivity.this.nJr.setFilePath(str);
                        RecordVideoActivity.this.nJr.setContentUriStr(null);
                        RecordVideoActivity.this.nJr.setTempFile(true);
                        RecordVideoActivity.this.nJr.setAlbumnId(null);
                        RecordVideoActivity.this.nJr.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nJr);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jfT, RecordVideoActivity.this.nJj)));
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
    public void dWD() {
        this.nJg.cancel();
        this.nJg.setAnimationListener(null);
        this.byY.clearAnimation();
        this.byY.setVisibility(8);
        if (this.nJp != null) {
            this.nJp.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWE() {
        dNI();
    }

    private void dNI() {
        if (this.nJh != null) {
            this.nJh.cancel();
        }
        if (this.nJi == null) {
            this.nJi = ObjectAnimator.ofFloat(this.nJq, "alpha", 1.0f, 0.0f);
            this.nJi.setDuration(500L);
            this.nJi.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nKQ) {
                        RecordVideoActivity.this.nJq.setVisibility(8);
                    }
                }
            });
        }
        this.nJi.start();
    }

    private void dNH() {
        if (this.nJi != null) {
            this.nJi.cancel();
        }
        if (this.nJh == null) {
            this.nJh = ObjectAnimator.ofFloat(this.nJq, "alpha", 0.0f, 1.0f);
            this.nJh.setDuration(500L);
        }
        this.nJq.setVisibility(0);
        this.nJh.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWF() {
        this.nJa.reset();
        if (this.nHo.getStatus() == 1) {
            dNH();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWG() {
        if (this.buh.getVisibility() != 0) {
            this.nIU.dWN();
            this.nHo.setStatus(8);
            dWq();
            if (this.nHw.nIc != null && this.nHw.nIc.size() > 0) {
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
        final int nJv = 50;
        final int nJw = 1;
        Handler nJx = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nJc.P(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dWK();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dWK() {
            this.nJx.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dWK();
            boolean z = RecordVideoActivity.this.nJp == null || TextUtils.isEmpty(RecordVideoActivity.this.nJp.dWp()) || !new File(RecordVideoActivity.this.nJp.dWp()).exists();
            if (RecordVideoActivity.this.nHw.nIc.size() > 1) {
                return com.baidu.tieba.video.meida.h.dVC().a(RecordVideoActivity.this.nHw.nIc, RecordVideoActivity.this.nHw.dVT(), z);
            }
            File file = new File(RecordVideoActivity.this.nHw.nIc.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.nHw.dVT());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dVC().a(RecordVideoActivity.this.nHw.nIc, RecordVideoActivity.this.nHw.dVT(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.nIU.dWT();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dWr();
                    RecordVideoActivity.this.Mp(102);
                    RecordVideoActivity.this.buh.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dWr();
                RecordVideoActivity.this.Mp(102);
                RecordVideoActivity.this.buh.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.buh.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bD(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nJc.P(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nIU == null || y.isEmpty(this.nIU.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nIU.getChoosedBeautyList()) {
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
        if (this.nIU == null || y.isEmpty(this.nIU.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nIU.getChoosedFilterList()) {
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
        if (this.nIU == null || y.isEmpty(this.nIU.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nIU.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWH() {
        this.nJd.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWI() {
        this.nJd.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dWJ() {
        if (this.nHo.getStatus() == 1) {
            this.nJq.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nHw != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nHw.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ar("c12421").al("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nJa.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nJa.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nHw.setFilter((String) eVar.getValue());
                        ar arVar = new ar("c12496");
                        arVar.dY("obj_id", (String) eVar.getValue());
                        if (this.nHo.getStatus() == 1) {
                            arVar.al("obj_type", 1);
                        } else {
                            arVar.al("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nJa.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nJa.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nJp.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nJa.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nJa.setViewChoosed(0, true);
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
            this.nJo = stickerItem;
            this.nJn.Vh(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nHw != null) {
                    this.nHw.setSticker(null);
                    this.nJt = false;
                }
                if (this.nIU != null) {
                    this.nIU.setDownLoadSticker(null);
                }
                this.nJb.setVisibility(8);
                this.nJa.setViewChoosed(1, false);
                return;
            }
            String Ve = this.nJn.Ve(stickerItem.resource);
            if (!StringUtils.isNull(Ve)) {
                a(stickerItem, Ve);
                if (this.nIU != null) {
                    this.nIU.setDownLoadSticker(null);
                }
            } else {
                if (this.nIU != null) {
                    this.nIU.setDownLoadSticker(stickerItem);
                }
                this.nJn.Vf(stickerItem.resource);
            }
            this.nJa.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nHw != null) {
                this.nHw.setSticker(stickerItem);
                this.nJt = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nJb.setText(stickerItem.desc);
                this.nJb.setVisibility(0);
                this.nJb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nJb.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nJb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dH(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nIU.getLayoutParams();
            layoutParams.height = i4;
            this.nIU.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String UM = com.baidu.tieba.video.editvideo.model.a.dUB().UM(stringExtra);
                if (this.nJp != null && !TextUtils.isEmpty(UM)) {
                    this.nJp.gE(UM, stringExtra2);
                    this.nIU.dVH();
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
        if (this.nHo.getStatus() == 8) {
            this.nIU.dWM();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void yP(boolean z) {
        if (this.nHo != null && (this.nHo.getStatus() == 1 || this.nHo.getStatus() == 3 || this.nHo.getStatus() == 4)) {
            if (!z && this.nJt) {
                this.nIZ.dWg();
                return;
            } else {
                this.nIZ.dWh();
                return;
            }
        }
        this.nIZ.dWh();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ak(int i, boolean z) {
        int i2 = 1;
        if (this.jqf != i) {
            switch (i) {
                case 1:
                    if (this.nJp != null) {
                        this.nJp.bhc();
                    }
                    this.nHw.setFilter("origin");
                    this.nJa.setViewChoosed(0, false);
                    this.nJa.setViewChoosed(3, false);
                    this.nIU.Mr(1);
                    this.nJa.setViewVisibility(0, 8);
                    this.nJa.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nJa.setViewVisibility(0, 0);
                    this.nJa.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jqf = i;
            this.nIU.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ar().al("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dWo() {
        if (this.nHo.getStatus() == 1 && !this.nIU.dWR()) {
            ak(1, true);
            this.nJq.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dWn() {
        if (this.nHo.getStatus() == 1 && !this.nIU.dWR()) {
            ak(2, true);
            this.nJq.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mp(int i) {
        if (this.nnd != null) {
            this.nnd.bE(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i, String str) {
        if (this.nnd != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nnd.bD(i, str);
        }
    }
}
