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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.x;
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
    private View bdK;
    private ImageView gwo;
    private com.baidu.tbadk.core.dialog.a hJl;
    private ForumWriteData hRF;
    private int hYV;
    private final CustomMessageListener iaK;
    private final CustomMessageListener jLU;
    private com.baidu.tieba.k.h lOt;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private String mdp;
    private SelectMusicModel mdt;
    private b.a mgM;
    private b miX;
    private i mig;
    protected h mip;
    private RecordLayout mjN;
    private VideoControllerLayout mjO;
    private RelativeLayout mjP;
    private ImageView mjQ;
    private ImageView mjR;
    private ImageView mjS;
    private PreviewViewContainer mjT;
    private TextView mjU;
    private VideoEffectButtonLayout mjV;
    private TextView mjW;
    private RoundProgressBar mjX;
    private TextView mjY;
    private AnimatorSet mjZ;
    private AnimatorSet mka;
    private ScaleAnimation mkb;
    private ObjectAnimator mkc;
    private ObjectAnimator mkd;
    private int mke;
    private int mkf;
    private boolean mkg;
    private boolean mkh = true;
    private l mki;
    private StickerItem mkj;
    protected j mkk;
    private RecordTabLayout mkl;
    private ImageFileInfo mkm;
    private HttpMessageListener mkn;
    private boolean mko;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lOt = lVar.cGE();
        }
        if (this.lOt != null) {
            this.lOt.cGn();
        }
        this.mgM = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fh(List<com.baidu.tieba.video.localvideo.d> list) {
                if (x.isEmpty(list)) {
                    if (RecordVideoActivity.this.mjO != null) {
                        RecordVideoActivity.this.mjO.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mjO != null) {
                    RecordVideoActivity.this.mjO.setHasLocalVideo(true);
                    RecordVideoActivity.this.mkh = false;
                }
            }
        };
        this.mkn = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mjO != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mjO.setStickerItems(list);
                    }
                }
            }
        };
        this.iaK = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.jLU = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void dsc() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.mip.mgb);
        videoInfo.setVideoDuration(this.mig.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.mip.mgb).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.hRF == null ? "" : this.hRF.forumName;
        String str2 = this.hRF == null ? "" : this.hRF.forumId;
        int i = this.hRF == null ? -1 : this.hRF.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hRF.writeCallFrom, str, str2, this.mdp, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.hRF != null ? this.hRF.frsTabInfo : null);
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
        editVideoActivityConfig.setFrom(this.hRF.mFrom);
        if (this.mkk != null) {
            this.mkk.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.lOt != null) {
            this.lOt.cGq();
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
        if (this.mig != null && this.mig.bdw()) {
            this.mig.stopRecord();
        }
        if (this.mdt != null) {
            this.mdt.cancelLoadData();
        }
        if (this.lOt != null) {
            this.lOt.JN("record");
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
        this.mke = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mkf = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.hRF = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.mdp = getIntent().getStringExtra("video_title");
        initUI();
        this.mdt = new SelectMusicModel(getPageContext(), this.mjO);
        this.mdt.dqu();
        this.mkk = new j(this);
        this.mkk.b(this.mdt);
        this.mig.a(this.mkk);
        registerListener(this.mkn);
        registerListener(this.iaK);
        registerListener(this.jLU);
        dsd();
    }

    private void dsd() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dqW() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.mgM);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mjN = (RecordLayout) findViewById(R.id.root_layout);
        this.mjN.setListener(this);
        this.mig = new i(this);
        this.mjO = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mjO.setRecordController(this.mig);
        this.mjO.setRecordControlListener(this);
        this.mjO.setEffectChoosedListener(this);
        this.mjP = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gwo = (ImageView) findViewById(R.id.close_page);
        this.gwo.setOnClickListener(this);
        this.mjQ = (ImageView) findViewById(R.id.flash_switch);
        this.mjQ.setOnClickListener(this);
        this.mjR = (ImageView) findViewById(R.id.camera_switch);
        this.mjR.setOnClickListener(this);
        this.mjS = (ImageView) findViewById(R.id.count_down);
        this.mjS.setOnClickListener(this);
        this.mjT = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.mip = new h(this);
        this.mip.a(this);
        this.mip.setFaceIdentifyStateListener(this);
        this.mip.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void drQ() {
                if (RecordVideoActivity.this.mjO.dsC()) {
                    RecordVideoActivity.this.mjO.a((m) null);
                }
            }
        });
        this.mjV = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mjV.setListener(this);
        this.mig.a(this.mjV);
        this.mjV.setViewChoosed(2, true);
        this.mjU = (TextView) findViewById(R.id.tv_count_down);
        this.mjW = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mjU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mjU.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mjV.setVisibility(8);
        }
        this.bdK = findViewById(R.id.progress_layout);
        this.mjX = (RoundProgressBar) this.bdK.findViewById(R.id.video_progress);
        this.mjY = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mjY.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mjY.setLayoutParams(layoutParams);
        this.mkl = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || x.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            GI(this.mkf);
        } else {
            GI(1);
        }
        dse();
    }

    private void GI(int i) {
        if (this.mkl != null) {
            if (i == 0) {
                this.mkl.bJ(1, getString(R.string.tab_photo));
                this.mkl.bJ(2, getString(R.string.tab_record));
                this.mkl.setListener(this);
                this.mkl.setCurrentTab(2, false);
                af(2, false);
            } else if (i == 1) {
                this.mkl.bJ(1, getString(R.string.tab_photo));
                this.mkl.setShowIndicator(false);
                this.mkl.setCurrentTab(1, false);
                af(1, false);
            } else {
                this.mkl.bJ(2, getString(R.string.tab_record));
                this.mkl.setShowIndicator(false);
                this.mkl.setCurrentTab(2, false);
                af(2, false);
            }
        }
    }

    private void dse() {
        if (com.baidu.tbadk.core.util.g.aZY()) {
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
        this.mip.onResume();
        this.miX = this.mip.drH();
        if (this.miX != null) {
            this.miX.setRecordController(this.mig);
            this.mjT.setZoomHelper(this.miX);
        }
        dsf();
        if (this.mki == null) {
            this.mki = new l();
            this.mki.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void fG(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mkj, str2);
                    if (RecordVideoActivity.this.mjO != null) {
                        RecordVideoActivity.this.mjO.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void OE(String str) {
                    if (RecordVideoActivity.this.mjO != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mjO.b(stickerItem);
                        if (RecordVideoActivity.this.mip != null) {
                            RecordVideoActivity.this.mip.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mjO != null) {
                        RecordVideoActivity.this.mjO.setDownLoadSticker(null);
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
                    recordVideoActivity.bp(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void dpI() {
                    if (RecordVideoActivity.this.mjO != null) {
                        RecordVideoActivity.this.mjO.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mki.dsw();
        if (this.mjO != null && this.mkh) {
            dqW();
        }
        if (this.lOt != null) {
            this.lOt.JM("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mip.onPause();
        if (this.mjO != null) {
            if (this.mig != null && this.mig.getStatus() == 6) {
                this.mjO.stopRecord();
                dso();
            }
            if (this.mig != null && this.mig.bdw()) {
                this.mjO.stopRecord();
            }
        }
        if (this.mkk != null) {
            this.mkk.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mig == null || this.mig.getStatus() != 7) {
            if (this.mig != null && this.mig.getStatus() == 6) {
                if (this.mjO != null) {
                    this.mjO.stopRecord();
                }
                dso();
            } else if (this.mig != null && this.mig.onBackPressed()) {
                finish();
            } else {
                if (this.hJl == null) {
                    this.hJl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hJl.ln(R.string.video_quit_confirm);
                    this.hJl.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hJl.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hJl.hJ(true);
                    this.hJl.b(getPageContext());
                }
                this.hJl.aYL();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mjY.setVisibility(4);
        if (view == this.gwo) {
            onBackPressed();
        } else if (view == this.mjQ) {
            if (this.mig.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.mip.drK();
            dsf();
        } else if (view == this.mjR) {
            if (this.mig.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mjR.setOnClickListener(null);
            this.mip.drM();
            if (this.mip.drN() && this.mip.drL()) {
                this.mip.drK();
            }
            dsf();
            this.mjR.setOnClickListener(this);
        } else if (view == this.mjS) {
            dsh();
        }
    }

    private void dsf() {
        if (this.mip.drN()) {
            this.mjQ.setVisibility(8);
        } else {
            this.mjQ.setVisibility(0);
        }
        if (this.mip.drL()) {
            this.mjQ.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mjQ.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout dsg() {
        return this.mjT;
    }

    public void dsh() {
        this.mjY.setVisibility(4);
        if (this.mig.getStatus() != 6) {
            this.mig.setStatus(6);
            dsm();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mkb == null) {
                this.mkb = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mkb.setDuration(500L);
                this.mkb.setRepeatCount(5);
                this.mkb.setRepeatMode(2);
                this.mkb.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mkb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.mig.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mjU.setVisibility(0);
                        RecordVideoActivity.this.mjU.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mjU.setVisibility(8);
                    if (RecordVideoActivity.this.mig.getStatus() == 6) {
                        RecordVideoActivity.this.mjO.dsz();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.mig.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mjU.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mjU.setText("");
                        }
                    }
                }
            });
            this.mjU.setAnimation(this.mkb);
            this.mkb.startNow();
            this.mjO.dsh();
            if (this.mkk != null) {
                this.mkk.dsb();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsi() {
        if (this.mig.getStatus() == 1) {
            this.mjY.setVisibility(4);
            if (this.mig.getStatus() != 6) {
                this.mjO.dsi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsj() {
        this.mjY.setVisibility(4);
        if (this.mig.getStatus() != 6) {
            this.mjO.dsj();
            if (this.mjO.dsD()) {
                dsd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsk() {
        this.mjY.setVisibility(4);
        if (this.mig.getStatus() != 6) {
            this.mjO.dsk();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dsl() {
        this.mjY.setVisibility(4);
        if (this.mig.getStatus() != 6) {
            this.mjO.dsl();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsm() {
        this.mkg = true;
        if (this.mka != null && this.mka.isRunning()) {
            this.mka.cancel();
        }
        if (this.mjZ == null) {
            this.mjZ = new AnimatorSet();
            this.mjZ.playTogether(ObjectAnimator.ofFloat(this.mjP, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mjV, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mkl, "alpha", 1.0f, 0.0f));
            this.mjZ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlL) {
                        RecordVideoActivity.this.mjP.setVisibility(8);
                        RecordVideoActivity.this.mjV.setVisibility(8);
                        RecordVideoActivity.this.mkl.setVisibility(8);
                    }
                }
            });
            this.mjZ.setDuration(300L);
        }
        this.mjZ.start();
        this.mjV.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsb() {
        if (this.hYV == 2) {
            if (this.mkg) {
                this.mkg = false;
                if (this.mkk != null) {
                    this.mkk.dsb();
                }
            } else {
                return;
            }
        }
        if (this.mjZ != null && this.mjZ.isRunning()) {
            this.mjZ.cancel();
        }
        if (this.mka == null) {
            this.mka = new AnimatorSet();
            this.mka.playTogether(ObjectAnimator.ofFloat(this.mjP, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mjV, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mkl, "alpha", 0.0f, 1.0f));
            this.mka.setDuration(300L);
        }
        this.mjP.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mjV.setVisibility(0);
        }
        if (this.mig.getStatus() == 1) {
            this.mkl.setVisibility(0);
        }
        this.mka.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsn() {
        if (this.mip != null) {
            this.mip.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void C(boolean z, String str) {
                    RecordVideoActivity.this.mig.setStatus(1);
                    RecordVideoActivity.this.dsb();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mkm != null && !x.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mkm)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mkm);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mkm = new ImageFileInfo();
                        RecordVideoActivity.this.mkm.setFilePath(str);
                        RecordVideoActivity.this.mkm.setContentUriStr(null);
                        RecordVideoActivity.this.mkm.setTempFile(true);
                        RecordVideoActivity.this.mkm.setAlbumnId(null);
                        RecordVideoActivity.this.mkm.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mkm);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hRF, RecordVideoActivity.this.mke)));
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
    public void dso() {
        this.mkb.cancel();
        this.mkb.setAnimationListener(null);
        this.mjU.clearAnimation();
        this.mjU.setVisibility(8);
        if (this.mkk != null) {
            this.mkk.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsp() {
        djK();
    }

    private void djK() {
        if (this.mkc != null) {
            this.mkc.cancel();
        }
        if (this.mkd == null) {
            this.mkd = ObjectAnimator.ofFloat(this.mkl, "alpha", 1.0f, 0.0f);
            this.mkd.setDuration(500L);
            this.mkd.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mlL) {
                        RecordVideoActivity.this.mkl.setVisibility(8);
                    }
                }
            });
        }
        this.mkd.start();
    }

    private void djJ() {
        if (this.mkd != null) {
            this.mkd.cancel();
        }
        if (this.mkc == null) {
            this.mkc = ObjectAnimator.ofFloat(this.mkl, "alpha", 0.0f, 1.0f);
            this.mkc.setDuration(500L);
        }
        this.mkl.setVisibility(0);
        this.mkc.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsq() {
        this.mjV.reset();
        if (this.mig.getStatus() == 1) {
            djJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsr() {
        if (this.bdK.getVisibility() != 0) {
            this.mjO.dsy();
            this.mig.setStatus(8);
            dsb();
            if (this.mip.miV != null && this.mip.miV.size() > 0) {
                this.bdK.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes17.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int mkq = 50;
        final int mkr = 1;
        Handler mks = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mjX.G(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dsv();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dsv() {
            this.mks.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dsv();
            boolean z = RecordVideoActivity.this.mkk == null || TextUtils.isEmpty(RecordVideoActivity.this.mkk.dsa()) || !new File(RecordVideoActivity.this.mkk.dsa()).exists();
            if (RecordVideoActivity.this.mip.miV.size() > 1) {
                return com.baidu.tieba.video.meida.h.drn().a(RecordVideoActivity.this.mip.miV, RecordVideoActivity.this.mip.drE(), z);
            }
            File file = new File(RecordVideoActivity.this.mip.miV.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.mip.drE());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.drn().a(RecordVideoActivity.this.mip.miV, RecordVideoActivity.this.mip.drE(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mjO.dsE();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dsc();
                    RecordVideoActivity.this.GJ(102);
                    RecordVideoActivity.this.bdK.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dsc();
                RecordVideoActivity.this.GJ(102);
                RecordVideoActivity.this.bdK.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bdK.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bp(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mjX.G(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mjO == null || x.isEmpty(this.mjO.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mjO.getChoosedBeautyList()) {
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
        if (this.mjO == null || x.isEmpty(this.mjO.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mjO.getChoosedFilterList()) {
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
        if (this.mjO == null || x.isEmpty(this.mjO.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mjO.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dss() {
        this.mjY.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dst() {
        this.mjY.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dsu() {
        if (this.mig.getStatus() == 1) {
            this.mkl.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.mip != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.mip.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ap("c12421").ah("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mjV.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mjV.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.mip.setFilter((String) eVar.getValue());
                        ap apVar = new ap("c12496");
                        apVar.dn("obj_id", (String) eVar.getValue());
                        if (this.mig.getStatus() == 1) {
                            apVar.ah("obj_type", 1);
                        } else {
                            apVar.ah("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mjV.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mjV.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mkk.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mjV.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mjV.setViewChoosed(0, true);
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
            this.mkj = stickerItem;
            this.mki.Pf(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.mip != null) {
                    this.mip.setSticker(null);
                    this.mko = false;
                }
                if (this.mjO != null) {
                    this.mjO.setDownLoadSticker(null);
                }
                this.mjW.setVisibility(8);
                this.mjV.setViewChoosed(1, false);
                return;
            }
            String Pc = this.mki.Pc(stickerItem.resource);
            if (!StringUtils.isNull(Pc)) {
                a(stickerItem, Pc);
                if (this.mjO != null) {
                    this.mjO.setDownLoadSticker(null);
                }
            } else {
                if (this.mjO != null) {
                    this.mjO.setDownLoadSticker(stickerItem);
                }
                this.mki.Pd(stickerItem.resource);
            }
            this.mjV.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.mip != null) {
                this.mip.setSticker(stickerItem);
                this.mko = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mjW.setText(stickerItem.desc);
                this.mjW.setVisibility(0);
                this.mjW.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mjW.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.mjW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dl(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mjO.getLayoutParams();
            layoutParams.height = i4;
            this.mjO.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String OK = com.baidu.tieba.video.editvideo.model.a.dqo().OK(stringExtra);
                if (this.mkk != null && !TextUtils.isEmpty(OK)) {
                    this.mkk.fJ(OK, stringExtra2);
                    this.mjO.drs();
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
        if (this.mig.getStatus() == 8) {
            this.mjO.dsx();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void vW(boolean z) {
        if (this.mig != null && (this.mig.getStatus() == 1 || this.mig.getStatus() == 3 || this.mig.getStatus() == 4)) {
            if (!z && this.mko) {
                this.mjT.drR();
                return;
            } else {
                this.mjT.drS();
                return;
            }
        }
        this.mjT.drS();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void af(int i, boolean z) {
        int i2 = 1;
        if (this.hYV != i) {
            switch (i) {
                case 1:
                    if (this.mkk != null) {
                        this.mkk.aOt();
                    }
                    this.mip.setFilter("origin");
                    this.mjV.setViewChoosed(0, false);
                    this.mjV.setViewChoosed(3, false);
                    this.mjO.GL(1);
                    this.mjV.setViewVisibility(0, 8);
                    this.mjV.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mjV.setViewVisibility(0, 0);
                    this.mjV.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hYV = i;
            this.mjO.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ap().ah("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void drZ() {
        if (this.mig.getStatus() == 1 && !this.mjO.dsC()) {
            af(1, true);
            this.mkl.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void drY() {
        if (this.mig.getStatus() == 1 && !this.mjO.dsC()) {
            af(2, true);
            this.mkl.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GJ(int i) {
        if (this.lOt != null) {
            this.lOt.bq(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(int i, String str) {
        if (this.lOt != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.lOt.bp(i, str);
        }
    }
}
