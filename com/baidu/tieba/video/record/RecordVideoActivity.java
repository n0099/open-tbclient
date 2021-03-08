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
/* loaded from: classes7.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private TextView bEg;
    private View bXd;
    private final CustomMessageListener ggs;
    private ImageView izx;
    private int jFy;
    private com.baidu.tbadk.core.dialog.a jlU;
    private ForumWriteData jvq;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private com.baidu.tieba.l.g nAz;
    private String nOs;
    private SelectMusicModel nOw;
    private i nSo;
    protected h nSw;
    private RecordLayout nTT;
    private VideoControllerLayout nTU;
    private RelativeLayout nTV;
    private ImageView nTW;
    private ImageView nTX;
    private ImageView nTY;
    private PreviewViewContainer nTZ;
    private b nTc;
    private VideoEffectButtonLayout nUa;
    private TextView nUb;
    private RoundProgressBar nUc;
    private TextView nUd;
    private AnimatorSet nUe;
    private AnimatorSet nUf;
    private ScaleAnimation nUg;
    private ObjectAnimator nUh;
    private ObjectAnimator nUi;
    private int nUj;
    private int nUk;
    private boolean nUl;
    private boolean nUm = true;
    private l nUn;
    private StickerItem nUo;
    protected j nUp;
    private RecordTabLayout nUq;
    private ImageFileInfo nUr;
    private a.InterfaceC0897a nUs;
    private HttpMessageListener nUt;
    private boolean nUu;
    private final CustomMessageListener nUv;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.l.k.class);
        com.baidu.tieba.l.k kVar = runTask != null ? (com.baidu.tieba.l.k) runTask.getData() : null;
        if (kVar != null) {
            this.nAz = kVar.dho();
        }
        if (this.nAz != null) {
            this.nAz.dgX();
        }
        this.nUs = new a.InterfaceC0897a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.a.InterfaceC0897a
            public void fZ(List<com.baidu.tieba.video.localvideo.b> list) {
                if (y.isEmpty(list)) {
                    if (RecordVideoActivity.this.nTU != null) {
                        RecordVideoActivity.this.nTU.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.nTU != null) {
                    RecordVideoActivity.this.nTU.setHasLocalVideo(true);
                    RecordVideoActivity.this.nUm = false;
                }
            }
        };
        this.nUt = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.nTU != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.nTU.setStickerItems(list);
                    }
                }
            }
        };
        this.nUv = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.ggs = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dUD() {
        String str;
        String str2;
        AntiData antiData;
        PostPrefixData postPrefixData;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.nSw.nQY);
        videoInfo.setVideoDuration(this.nSo.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(960);
        videoInfo.setVideoLength(new File(this.nSw.nQY).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str3 = this.jvq == null ? "" : this.jvq.forumName;
        String str4 = this.jvq == null ? "" : this.jvq.forumId;
        int i = this.jvq == null ? -1 : this.jvq.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jvq.writeCallFrom, str3, str4, this.nOs, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setStatisticFrom(this.jvq.statisticFrom);
        editVideoActivityConfig.setFrsTabInfo(this.jvq != null ? this.jvq.frsTabInfo : null);
        editVideoActivityConfig.setForumLevel(this.jvq != null ? this.jvq.forumLevel : -1);
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
        editVideoActivityConfig.setFrom(this.jvq.mFrom);
        if (this.nUp != null) {
            this.nUp.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.nAz != null) {
            this.nAz.dha();
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
        if (this.nSo != null && this.nSo.isRecording()) {
            this.nSo.stopRecord();
        }
        if (this.nOw != null) {
            this.nOw.cancelLoadData();
        }
        if (this.nAz != null) {
            this.nAz.OK("record");
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
        this.nUj = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.nUk = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.jvq = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.nOs = getIntent().getStringExtra("video_title");
        initUI();
        this.nOw = new SelectMusicModel(getPageContext(), this.nTU);
        this.nOw.dTi();
        this.nUp = new j(this);
        this.nUp.b(this.nOw);
        this.nSo.a(this.nUp);
        registerListener(this.nUt);
        registerListener(this.nUv);
        registerListener(this.ggs);
        dUE();
        if (Build.VERSION.SDK_INT >= 28 && an.bsM() && TbSingleton.getInstance().isCutoutScreen(this)) {
            com.baidu.tieba.v.c.a(1, getWindow().getAttributes(), getWindow());
        }
    }

    private void dUE() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dUF() {
        com.baidu.tieba.video.localvideo.a aVar = new com.baidu.tieba.video.localvideo.a(this);
        aVar.a(this.nUs);
        aVar.execute(new Void[0]);
    }

    private void initUI() {
        this.nTT = (RecordLayout) findViewById(R.id.root_layout);
        this.nTT.setListener(this);
        this.nSo = new i(this);
        this.nTU = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.nTU.setRecordController(this.nSo);
        this.nTU.setRecordControlListener(this);
        this.nTU.setEffectChoosedListener(this);
        this.nTV = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.izx = (ImageView) findViewById(R.id.close_page);
        this.izx.setOnClickListener(this);
        this.nTW = (ImageView) findViewById(R.id.flash_switch);
        this.nTW.setOnClickListener(this);
        this.nTX = (ImageView) findViewById(R.id.camera_switch);
        this.nTX.setOnClickListener(this);
        this.nTY = (ImageView) findViewById(R.id.count_down);
        this.nTY.setOnClickListener(this);
        this.nTZ = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.nSw = new h(this);
        this.nSw.a(this);
        this.nSw.setFaceIdentifyStateListener(this);
        this.nSw.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void dUr() {
                if (RecordVideoActivity.this.nTU.dVe()) {
                    RecordVideoActivity.this.nTU.a((m) null);
                }
            }
        });
        this.nUa = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.nUa.setListener(this);
        this.nSo.a(this.nUa);
        this.nUa.setViewChoosed(2, true);
        this.bEg = (TextView) findViewById(R.id.tv_count_down);
        this.nUb = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.bEg.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.bEg.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.nUa.setVisibility(8);
        }
        this.bXd = findViewById(R.id.progress_layout);
        this.nUc = (RoundProgressBar) this.bXd.findViewById(R.id.video_progress);
        this.nUd = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nUd.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.nUd.setLayoutParams(layoutParams);
        this.nUq = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || y.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            KT(this.nUk);
        } else {
            KT(1);
        }
        dUG();
    }

    private void KT(int i) {
        if (this.nUq != null) {
            if (i == 0) {
                this.nUq.cf(1, getString(R.string.tab_photo));
                this.nUq.cf(2, getString(R.string.tab_record));
                this.nUq.setListener(this);
                this.nUq.setCurrentTab(2, false);
                ai(2, false);
            } else if (i == 1) {
                this.nUq.cf(1, getString(R.string.tab_photo));
                this.nUq.setShowIndicator(false);
                this.nUq.setCurrentTab(1, false);
                ai(1, false);
            } else {
                this.nUq.cf(2, getString(R.string.tab_record));
                this.nUq.setShowIndicator(false);
                this.nUq.setCurrentTab(2, false);
                ai(2, false);
            }
        }
    }

    private void dUG() {
        if (com.baidu.tbadk.core.util.g.bsa()) {
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
        this.nSw.onResume();
        this.nTc = this.nSw.dUi();
        if (this.nTc != null) {
            this.nTc.setRecordController(this.nSo);
            this.nTZ.setZoomHelper(this.nTc);
        }
        dUH();
        if (this.nUn == null) {
            this.nUn = new l();
            this.nUn.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void gF(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.nUo, str2);
                    if (RecordVideoActivity.this.nTU != null) {
                        RecordVideoActivity.this.nTU.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Uv(String str) {
                    if (RecordVideoActivity.this.nTU != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.nTU.b(stickerItem);
                        if (RecordVideoActivity.this.nSw != null) {
                            RecordVideoActivity.this.nSw.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.nTU != null) {
                        RecordVideoActivity.this.nTU.setDownLoadSticker(null);
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
                public void dSw() {
                    if (RecordVideoActivity.this.nTU != null) {
                        RecordVideoActivity.this.nTU.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.nUn.dUY();
        if (this.nTU != null && this.nUm) {
            dUF();
        }
        if (this.nAz != null) {
            this.nAz.OJ("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.nSw.onPause();
        if (this.nTU != null) {
            if (this.nSo != null && this.nSo.getStatus() == 6) {
                this.nTU.stopRecord();
                dUQ();
            }
            if (this.nSo != null && this.nSo.isRecording()) {
                this.nTU.stopRecord();
            }
        }
        if (this.nUp != null) {
            this.nUp.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.nSo == null || this.nSo.getStatus() != 7) {
            if (this.nSo != null && this.nSo.getStatus() == 6) {
                if (this.nTU != null) {
                    this.nTU.stopRecord();
                }
                dUQ();
            } else if (this.nSo != null && this.nSo.onBackPressed()) {
                finish();
            } else {
                if (this.jlU == null) {
                    this.jlU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jlU.ny(R.string.video_quit_confirm);
                    this.jlU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jlU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jlU.jF(true);
                    this.jlU.b(getPageContext());
                }
                this.jlU.bqz();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.nUd.setVisibility(4);
        if (view == this.izx) {
            onBackPressed();
        } else if (view == this.nTW) {
            if (this.nSo.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.nSw.dUl();
            dUH();
        } else if (view == this.nTX) {
            if (this.nSo.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.nTX.setOnClickListener(null);
            this.nSw.dUn();
            if (this.nSw.dUo() && this.nSw.dUm()) {
                this.nSw.dUl();
            }
            dUH();
            this.nTX.setOnClickListener(this);
        } else if (view == this.nTY) {
            dUJ();
        }
    }

    private void dUH() {
        if (this.nSw.dUo()) {
            this.nTW.setVisibility(8);
        } else {
            this.nTW.setVisibility(0);
        }
        if (this.nSw.dUm()) {
            this.nTW.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.nTW.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dUI() {
        return this.nTZ;
    }

    public void dUJ() {
        this.nUd.setVisibility(4);
        if (this.nSo.getStatus() != 6) {
            this.nSo.setStatus(6);
            dUO();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.nUg == null) {
                this.nUg = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.nUg.setDuration(500L);
                this.nUg.setRepeatCount(5);
                this.nUg.setRepeatMode(2);
                this.nUg.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.nUg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.nSo.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.bEg.setVisibility(0);
                        RecordVideoActivity.this.bEg.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.bEg.setVisibility(8);
                    if (RecordVideoActivity.this.nSo.getStatus() == 6) {
                        RecordVideoActivity.this.nTU.dVb();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.nSo.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.bEg.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.bEg.setText("");
                        }
                    }
                }
            });
            this.bEg.setAnimation(this.nUg);
            this.nUg.startNow();
            this.nTU.dUJ();
            if (this.nUp != null) {
                this.nUp.dUC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUK() {
        if (this.nSo.getStatus() == 1) {
            this.nUd.setVisibility(4);
            if (this.nSo.getStatus() != 6) {
                this.nTU.dUK();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUL() {
        this.nUd.setVisibility(4);
        if (this.nSo.getStatus() != 6) {
            this.nTU.dUL();
            if (this.nTU.dVf()) {
                dUE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUM() {
        this.nUd.setVisibility(4);
        if (this.nSo.getStatus() != 6) {
            this.nTU.dUM();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dUN() {
        this.nUd.setVisibility(4);
        if (this.nSo.getStatus() != 6) {
            this.nTU.dUN();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUO() {
        this.nUl = true;
        if (this.nUf != null && this.nUf.isRunning()) {
            this.nUf.cancel();
        }
        if (this.nUe == null) {
            this.nUe = new AnimatorSet();
            this.nUe.playTogether(ObjectAnimator.ofFloat(this.nTV, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nUa, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.nUq, "alpha", 1.0f, 0.0f));
            this.nUe.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nVS) {
                        RecordVideoActivity.this.nTV.setVisibility(8);
                        RecordVideoActivity.this.nUa.setVisibility(8);
                        RecordVideoActivity.this.nUq.setVisibility(8);
                    }
                }
            });
            this.nUe.setDuration(300L);
        }
        this.nUe.start();
        this.nUa.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUC() {
        if (this.jFy == 2) {
            if (this.nUl) {
                this.nUl = false;
                if (this.nUp != null) {
                    this.nUp.dUC();
                }
            } else {
                return;
            }
        }
        if (this.nUe != null && this.nUe.isRunning()) {
            this.nUe.cancel();
        }
        if (this.nUf == null) {
            this.nUf = new AnimatorSet();
            this.nUf.playTogether(ObjectAnimator.ofFloat(this.nTV, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nUa, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.nUq, "alpha", 0.0f, 1.0f));
            this.nUf.setDuration(300L);
        }
        this.nTV.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.nUa.setVisibility(0);
        }
        if (this.nSo.getStatus() == 1) {
            this.nUq.setVisibility(0);
        }
        this.nUf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUP() {
        if (this.nSw != null) {
            this.nSw.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void O(boolean z, String str) {
                    RecordVideoActivity.this.nSo.setStatus(1);
                    RecordVideoActivity.this.dUC();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.nUr != null && !y.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.nUr)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.nUr);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.nUr = new ImageFileInfo();
                        RecordVideoActivity.this.nUr.setFilePath(str);
                        RecordVideoActivity.this.nUr.setContentUriStr(null);
                        RecordVideoActivity.this.nUr.setTempFile(true);
                        RecordVideoActivity.this.nUr.setAlbumnId(null);
                        RecordVideoActivity.this.nUr.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.nUr);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jvq, RecordVideoActivity.this.nUj)));
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
    public void dUQ() {
        this.nUg.cancel();
        this.nUg.setAnimationListener(null);
        this.bEg.clearAnimation();
        this.bEg.setVisibility(8);
        if (this.nUp != null) {
            this.nUp.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUR() {
        dMk();
    }

    private void dMk() {
        if (this.nUh != null) {
            this.nUh.cancel();
        }
        if (this.nUi == null) {
            this.nUi = ObjectAnimator.ofFloat(this.nUq, "alpha", 1.0f, 0.0f);
            this.nUi.setDuration(500L);
            this.nUi.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.nVS) {
                        RecordVideoActivity.this.nUq.setVisibility(8);
                    }
                }
            });
        }
        this.nUi.start();
    }

    private void dMj() {
        if (this.nUi != null) {
            this.nUi.cancel();
        }
        if (this.nUh == null) {
            this.nUh = ObjectAnimator.ofFloat(this.nUq, "alpha", 0.0f, 1.0f);
            this.nUh.setDuration(500L);
        }
        this.nUq.setVisibility(0);
        this.nUh.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUS() {
        this.nUa.reset();
        if (this.nSo.getStatus() == 1) {
            dMj();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUT() {
        if (this.bXd.getVisibility() != 0) {
            this.nTU.dVa();
            this.nSo.setStatus(8);
            dUC();
            if (this.nSw.nTa != null && this.nSw.nTa.size() > 0) {
                this.bXd.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int nUx = 50;
        final int nUy = 1;
        Handler nUz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && AnonymousClass3.this.mProgress >= 0) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.nUc.W(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dUX();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dUX() {
            if (this.mProgress >= 0) {
                this.nUz.sendEmptyMessageDelayed(1, 50L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dUX();
            boolean z = RecordVideoActivity.this.nUp == null || TextUtils.isEmpty(RecordVideoActivity.this.nUp.dUB()) || !new File(RecordVideoActivity.this.nUp.dUB()).exists();
            if (RecordVideoActivity.this.nSw.nTa.size() > 1) {
                return com.baidu.tieba.video.meida.h.dTO().a(RecordVideoActivity.this.nSw.nTa, RecordVideoActivity.this.nSw.dUf(), z);
            }
            File file = new File(RecordVideoActivity.this.nSw.nTa.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    o.copyFile(file.getPath(), RecordVideoActivity.this.nSw.dUf());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dTO().a(RecordVideoActivity.this.nSw.nTa, RecordVideoActivity.this.nSw.dUf(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            this.mProgress = -1;
            RecordVideoActivity.this.mHandler.removeMessages(1);
            RecordVideoActivity.this.nTU.dVg();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dUD();
                    RecordVideoActivity.this.KU(102);
                    RecordVideoActivity.this.bXd.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dUD();
                RecordVideoActivity.this.KU(102);
                RecordVideoActivity.this.bXd.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bXd.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bK(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.nUc.W(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.nTU == null || y.isEmpty(this.nTU.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.nTU.getChoosedBeautyList()) {
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
        if (this.nTU == null || y.isEmpty(this.nTU.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.nTU.getChoosedFilterList()) {
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
        if (this.nTU == null || y.isEmpty(this.nTU.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.nTU.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUU() {
        this.nUd.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUV() {
        this.nUd.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dUW() {
        if (this.nSo.getStatus() == 1) {
            this.nUq.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.nSw != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.nSw.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ar("c12421").aq("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.nUa.setViewChoosed(2, false);
                            return;
                        } else {
                            this.nUa.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.nSw.setFilter((String) eVar.getValue());
                        ar arVar = new ar("c12496");
                        arVar.dR("obj_id", (String) eVar.getValue());
                        if (this.nSo.getStatus() == 1) {
                            arVar.aq("obj_type", 1);
                        } else {
                            arVar.aq("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.nUa.setViewChoosed(3, false);
                            return;
                        } else {
                            this.nUa.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.nUp.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.nUa.setViewChoosed(0, false);
                            return;
                        } else {
                            this.nUa.setViewChoosed(0, true);
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
            this.nUo = stickerItem;
            this.nUn.UT(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.nSw != null) {
                    this.nSw.setSticker(null);
                    this.nUu = false;
                }
                if (this.nTU != null) {
                    this.nTU.setDownLoadSticker(null);
                }
                this.nUb.setVisibility(8);
                this.nUa.setViewChoosed(1, false);
                return;
            }
            String UQ = this.nUn.UQ(stickerItem.resource);
            if (!StringUtils.isNull(UQ)) {
                a(stickerItem, UQ);
                if (this.nTU != null) {
                    this.nTU.setDownLoadSticker(null);
                }
            } else {
                if (this.nTU != null) {
                    this.nTU.setDownLoadSticker(stickerItem);
                }
                this.nUn.UR(stickerItem.resource);
            }
            this.nUa.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.nSw != null) {
                this.nSw.setSticker(stickerItem);
                this.nUu = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.nUb.setText(stickerItem.desc);
                this.nUb.setVisibility(0);
                this.nUb.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.nUb.setVisibility(8);
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
                return;
            }
            this.nUb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dA(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.nTU.getLayoutParams();
            layoutParams.height = i4;
            this.nTU.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String UB = com.baidu.tieba.video.editvideo.model.a.dTc().UB(stringExtra);
                if (this.nUp != null && !TextUtils.isEmpty(UB)) {
                    this.nUp.gI(UB, stringExtra2);
                    this.nTU.dTT();
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
        if (this.nSo.getStatus() == 8) {
            this.nTU.dUZ();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void zd(boolean z) {
        if (this.nSo != null && (this.nSo.getStatus() == 1 || this.nSo.getStatus() == 3 || this.nSo.getStatus() == 4)) {
            if (!z && this.nUu) {
                this.nTZ.dUs();
                return;
            } else {
                this.nTZ.dUt();
                return;
            }
        }
        this.nTZ.dUt();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ai(int i, boolean z) {
        int i2 = 1;
        if (this.jFy != i) {
            switch (i) {
                case 1:
                    if (this.nUp != null) {
                        this.nUp.bfV();
                    }
                    this.nSw.setFilter("origin");
                    this.nUa.setViewChoosed(0, false);
                    this.nUa.setViewChoosed(3, false);
                    this.nTU.KW(1);
                    this.nUa.setViewVisibility(0, 8);
                    this.nUa.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.nUa.setViewVisibility(0, 0);
                    this.nUa.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.jFy = i;
            this.nTU.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ar().aq("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dUA() {
        if (this.nSo.getStatus() == 1 && !this.nTU.dVe()) {
            ai(1, true);
            this.nUq.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dUz() {
        if (this.nSo.getStatus() == 1 && !this.nTU.dVe()) {
            ai(2, true);
            this.nUq.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KU(int i) {
        if (this.nAz != null) {
            this.nAz.bL(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(int i, String str) {
        if (this.nAz != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.nAz.bK(i, str);
        }
    }
}
