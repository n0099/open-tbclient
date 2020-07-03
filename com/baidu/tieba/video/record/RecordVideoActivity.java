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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes10.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View bds;
    private ImageView gqS;
    private com.baidu.tbadk.core.dialog.a hDn;
    private ForumWriteData hLG;
    private int hSW;
    private final CustomMessageListener hUL;
    private final CustomMessageListener jDq;
    private com.baidu.tieba.k.h lHf;
    private String lVW;
    private SelectMusicModel lWa;
    private b.a lZs;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private i maO;
    protected h maW;
    private b mbE;
    private PreviewViewContainer mcA;
    private TextView mcB;
    private VideoEffectButtonLayout mcC;
    private TextView mcD;
    private RoundProgressBar mcE;
    private TextView mcF;
    private AnimatorSet mcG;
    private AnimatorSet mcH;
    private ScaleAnimation mcI;
    private ObjectAnimator mcJ;
    private ObjectAnimator mcK;
    private int mcL;
    private int mcM;
    private boolean mcN;
    private boolean mcO = true;
    private l mcP;
    private StickerItem mcQ;
    protected j mcR;
    private RecordTabLayout mcS;
    private ImageFileInfo mcT;
    private HttpMessageListener mcU;
    private boolean mcV;
    private RecordLayout mcu;
    private VideoControllerLayout mcv;
    private RelativeLayout mcw;
    private ImageView mcx;
    private ImageView mcy;
    private ImageView mcz;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCP();
        }
        if (this.lHf != null) {
            this.lHf.cCr();
        }
        this.lZs = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fb(List<com.baidu.tieba.video.localvideo.d> list) {
                if (w.isEmpty(list)) {
                    if (RecordVideoActivity.this.mcv != null) {
                        RecordVideoActivity.this.mcv.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mcv != null) {
                    RecordVideoActivity.this.mcv.setHasLocalVideo(true);
                    RecordVideoActivity.this.mcO = false;
                }
            }
        };
        this.mcU = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mcv != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mcv.setStickerItems(list);
                    }
                }
            }
        };
        this.hUL = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    RecordVideoActivity.this.finish();
                }
            }
        };
        this.jDq = new CustomMessageListener(2001373) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
    public void doP() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.maW.lYH);
        videoInfo.setVideoDuration(this.maO.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.maW.lYH).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.hLG == null ? "" : this.hLG.forumName;
        String str2 = this.hLG == null ? "" : this.hLG.forumId;
        int i = this.hLG == null ? -1 : this.hLG.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hLG.writeCallFrom, str, str2, this.lVW, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.hLG != null ? this.hLG.frsTabInfo : null);
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
        editVideoActivityConfig.setFrom(this.hLG.mFrom);
        if (this.mcR != null) {
            this.mcR.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.lHf != null) {
            this.lHf.cCu();
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
        if (this.maO != null && this.maO.aZz()) {
            this.maO.stopRecord();
        }
        if (this.lWa != null) {
            this.lWa.cancelLoadData();
        }
        if (this.lHf != null) {
            this.lHf.IY("record");
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
        this.mcL = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mcM = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.hLG = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.lVW = getIntent().getStringExtra("video_title");
        initUI();
        this.lWa = new SelectMusicModel(getPageContext(), this.mcv);
        this.lWa.dng();
        this.mcR = new j(this);
        this.mcR.b(this.lWa);
        this.maO.a(this.mcR);
        registerListener(this.mcU);
        registerListener(this.hUL);
        registerListener(this.jDq);
        doQ();
    }

    private void doQ() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dnJ() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.lZs);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mcu = (RecordLayout) findViewById(R.id.root_layout);
        this.mcu.setListener(this);
        this.maO = new i(this);
        this.mcv = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mcv.setRecordController(this.maO);
        this.mcv.setRecordControlListener(this);
        this.mcv.setEffectChoosedListener(this);
        this.mcw = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gqS = (ImageView) findViewById(R.id.close_page);
        this.gqS.setOnClickListener(this);
        this.mcx = (ImageView) findViewById(R.id.flash_switch);
        this.mcx.setOnClickListener(this);
        this.mcy = (ImageView) findViewById(R.id.camera_switch);
        this.mcy.setOnClickListener(this);
        this.mcz = (ImageView) findViewById(R.id.count_down);
        this.mcz.setOnClickListener(this);
        this.mcA = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.maW = new h(this);
        this.maW.a(this);
        this.maW.setFaceIdentifyStateListener(this);
        this.maW.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void doD() {
                if (RecordVideoActivity.this.mcv.dpp()) {
                    RecordVideoActivity.this.mcv.a((m) null);
                }
            }
        });
        this.mcC = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mcC.setListener(this);
        this.maO.a(this.mcC);
        this.mcC.setViewChoosed(2, true);
        this.mcB = (TextView) findViewById(R.id.tv_count_down);
        this.mcD = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mcB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mcB.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mcC.setVisibility(8);
        }
        this.bds = findViewById(R.id.progress_layout);
        this.mcE = (RoundProgressBar) this.bds.findViewById(R.id.video_progress);
        this.mcF = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mcF.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mcF.setLayoutParams(layoutParams);
        this.mcS = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || w.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Gm(this.mcM);
        } else {
            Gm(1);
        }
        doR();
    }

    private void Gm(int i) {
        if (this.mcS != null) {
            if (i == 0) {
                this.mcS.bI(1, getString(R.string.tab_photo));
                this.mcS.bI(2, getString(R.string.tab_record));
                this.mcS.setListener(this);
                this.mcS.setCurrentTab(2, false);
                ag(2, false);
            } else if (i == 1) {
                this.mcS.bI(1, getString(R.string.tab_photo));
                this.mcS.setShowIndicator(false);
                this.mcS.setCurrentTab(1, false);
                ag(1, false);
            } else {
                this.mcS.bI(2, getString(R.string.tab_record));
                this.mcS.setShowIndicator(false);
                this.mcS.setCurrentTab(2, false);
                ag(2, false);
            }
        }
    }

    private void doR() {
        if (com.baidu.tbadk.core.util.g.aVY()) {
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
        this.maW.onResume();
        this.mbE = this.maW.dou();
        if (this.mbE != null) {
            this.mbE.setRecordController(this.maO);
            this.mcA.setZoomHelper(this.mbE);
        }
        doS();
        if (this.mcP == null) {
            this.mcP = new l();
            this.mcP.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void fE(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mcQ, str2);
                    if (RecordVideoActivity.this.mcv != null) {
                        RecordVideoActivity.this.mcv.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void NV(String str) {
                    if (RecordVideoActivity.this.mcv != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mcv.b(stickerItem);
                        if (RecordVideoActivity.this.maW != null) {
                            RecordVideoActivity.this.maW.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mcv != null) {
                        RecordVideoActivity.this.mcv.setDownLoadSticker(null);
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
                public void dmt() {
                    if (RecordVideoActivity.this.mcv != null) {
                        RecordVideoActivity.this.mcv.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mcP.dpj();
        if (this.mcv != null && this.mcO) {
            dnJ();
        }
        if (this.lHf != null) {
            this.lHf.IX("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.maW.onPause();
        if (this.mcv != null) {
            if (this.maO != null && this.maO.getStatus() == 6) {
                this.mcv.stopRecord();
                dpb();
            }
            if (this.maO != null && this.maO.aZz()) {
                this.mcv.stopRecord();
            }
        }
        if (this.mcR != null) {
            this.mcR.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.maO == null || this.maO.getStatus() != 7) {
            if (this.maO != null && this.maO.getStatus() == 6) {
                if (this.mcv != null) {
                    this.mcv.stopRecord();
                }
                dpb();
            } else if (this.maO != null && this.maO.onBackPressed()) {
                finish();
            } else {
                if (this.hDn == null) {
                    this.hDn = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.hDn.kT(R.string.video_quit_confirm);
                    this.hDn.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.hDn.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.hDn.hf(true);
                    this.hDn.b(getPageContext());
                }
                this.hDn.aUN();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.mcF.setVisibility(4);
        if (view == this.gqS) {
            onBackPressed();
        } else if (view == this.mcx) {
            if (this.maO.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.maW.dox();
            doS();
        } else if (view == this.mcy) {
            if (this.maO.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mcy.setOnClickListener(null);
            this.maW.doz();
            if (this.maW.doA() && this.maW.doy()) {
                this.maW.dox();
            }
            doS();
            this.mcy.setOnClickListener(this);
        } else if (view == this.mcz) {
            doU();
        }
    }

    private void doS() {
        if (this.maW.doA()) {
            this.mcx.setVisibility(8);
        } else {
            this.mcx.setVisibility(0);
        }
        if (this.maW.doy()) {
            this.mcx.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mcx.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout doT() {
        return this.mcA;
    }

    public void doU() {
        this.mcF.setVisibility(4);
        if (this.maO.getStatus() != 6) {
            this.maO.setStatus(6);
            doZ();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mcI == null) {
                this.mcI = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mcI.setDuration(500L);
                this.mcI.setRepeatCount(5);
                this.mcI.setRepeatMode(2);
                this.mcI.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mcI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.maO.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mcB.setVisibility(0);
                        RecordVideoActivity.this.mcB.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mcB.setVisibility(8);
                    if (RecordVideoActivity.this.maO.getStatus() == 6) {
                        RecordVideoActivity.this.mcv.dpm();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.maO.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mcB.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mcB.setText("");
                        }
                    }
                }
            });
            this.mcB.setAnimation(this.mcI);
            this.mcI.startNow();
            this.mcv.doU();
            if (this.mcR != null) {
                this.mcR.doO();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doV() {
        if (this.maO.getStatus() == 1) {
            this.mcF.setVisibility(4);
            if (this.maO.getStatus() != 6) {
                this.mcv.doV();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doW() {
        this.mcF.setVisibility(4);
        if (this.maO.getStatus() != 6) {
            this.mcv.doW();
            if (this.mcv.dpq()) {
                doQ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doX() {
        this.mcF.setVisibility(4);
        if (this.maO.getStatus() != 6) {
            this.mcv.doX();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doY() {
        this.mcF.setVisibility(4);
        if (this.maO.getStatus() != 6) {
            this.mcv.doY();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void doZ() {
        this.mcN = true;
        if (this.mcH != null && this.mcH.isRunning()) {
            this.mcH.cancel();
        }
        if (this.mcG == null) {
            this.mcG = new AnimatorSet();
            this.mcG.playTogether(ObjectAnimator.ofFloat(this.mcw, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mcC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mcS, "alpha", 1.0f, 0.0f));
            this.mcG.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mes) {
                        RecordVideoActivity.this.mcw.setVisibility(8);
                        RecordVideoActivity.this.mcC.setVisibility(8);
                        RecordVideoActivity.this.mcS.setVisibility(8);
                    }
                }
            });
            this.mcG.setDuration(300L);
        }
        this.mcG.start();
        this.mcC.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void doO() {
        if (this.hSW == 2) {
            if (this.mcN) {
                this.mcN = false;
                if (this.mcR != null) {
                    this.mcR.doO();
                }
            } else {
                return;
            }
        }
        if (this.mcG != null && this.mcG.isRunning()) {
            this.mcG.cancel();
        }
        if (this.mcH == null) {
            this.mcH = new AnimatorSet();
            this.mcH.playTogether(ObjectAnimator.ofFloat(this.mcw, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mcC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mcS, "alpha", 0.0f, 1.0f));
            this.mcH.setDuration(300L);
        }
        this.mcw.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mcC.setVisibility(0);
        }
        if (this.maO.getStatus() == 1) {
            this.mcS.setVisibility(0);
        }
        this.mcH.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpa() {
        if (this.maW != null) {
            this.maW.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void C(boolean z, String str) {
                    RecordVideoActivity.this.maO.setStatus(1);
                    RecordVideoActivity.this.doO();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mcT != null && !w.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mcT)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mcT);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mcT = new ImageFileInfo();
                        RecordVideoActivity.this.mcT.setFilePath(str);
                        RecordVideoActivity.this.mcT.setContentUriStr(null);
                        RecordVideoActivity.this.mcT.setTempFile(true);
                        RecordVideoActivity.this.mcT.setAlbumnId(null);
                        RecordVideoActivity.this.mcT.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mcT);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hLG, RecordVideoActivity.this.mcL)));
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
    public void dpb() {
        this.mcI.cancel();
        this.mcI.setAnimationListener(null);
        this.mcB.clearAnimation();
        this.mcB.setVisibility(8);
        if (this.mcR != null) {
            this.mcR.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpc() {
        dgA();
    }

    private void dgA() {
        if (this.mcJ != null) {
            this.mcJ.cancel();
        }
        if (this.mcK == null) {
            this.mcK = ObjectAnimator.ofFloat(this.mcS, "alpha", 1.0f, 0.0f);
            this.mcK.setDuration(500L);
            this.mcK.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mes) {
                        RecordVideoActivity.this.mcS.setVisibility(8);
                    }
                }
            });
        }
        this.mcK.start();
    }

    private void dgz() {
        if (this.mcK != null) {
            this.mcK.cancel();
        }
        if (this.mcJ == null) {
            this.mcJ = ObjectAnimator.ofFloat(this.mcS, "alpha", 0.0f, 1.0f);
            this.mcJ.setDuration(500L);
        }
        this.mcS.setVisibility(0);
        this.mcJ.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpd() {
        this.mcC.reset();
        if (this.maO.getStatus() == 1) {
            dgz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpe() {
        if (this.bds.getVisibility() != 0) {
            this.mcv.dpl();
            this.maO.setStatus(8);
            doO();
            if (this.maW.mbC != null && this.maW.mbC.size() > 0) {
                this.bds.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        int mProgress;
        final int mcX = 50;
        final int mcY = 1;
        Handler mcZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mcE.G(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dpi();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dpi() {
            this.mcZ.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dpi();
            boolean z = RecordVideoActivity.this.mcR == null || TextUtils.isEmpty(RecordVideoActivity.this.mcR.doN()) || !new File(RecordVideoActivity.this.mcR.doN()).exists();
            if (RecordVideoActivity.this.maW.mbC.size() > 1) {
                return com.baidu.tieba.video.meida.h.doa().a(RecordVideoActivity.this.maW.mbC, RecordVideoActivity.this.maW.dor(), z);
            }
            File file = new File(RecordVideoActivity.this.maW.mbC.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.maW.dor());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.doa().a(RecordVideoActivity.this.maW.mbC, RecordVideoActivity.this.maW.dor(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mcv.dpr();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.doP();
                    RecordVideoActivity.this.Gn(102);
                    RecordVideoActivity.this.bds.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.doP();
                RecordVideoActivity.this.Gn(102);
                RecordVideoActivity.this.bds.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bds.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bn(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mcE.G(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mcv == null || w.isEmpty(this.mcv.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mcv.getChoosedBeautyList()) {
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
        if (this.mcv == null || w.isEmpty(this.mcv.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mcv.getChoosedFilterList()) {
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
        if (this.mcv == null || w.isEmpty(this.mcv.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mcv.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpf() {
        this.mcF.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpg() {
        this.mcF.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dph() {
        if (this.maO.getStatus() == 1) {
            this.mcS.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.maW != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.maW.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ao("c12421").ag("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mcC.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mcC.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.maW.setFilter((String) eVar.getValue());
                        ao aoVar = new ao("c12496");
                        aoVar.dk("obj_id", (String) eVar.getValue());
                        if (this.maO.getStatus() == 1) {
                            aoVar.ag("obj_type", 1);
                        } else {
                            aoVar.ag("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mcC.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mcC.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mcR.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mcC.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mcC.setViewChoosed(0, true);
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
            this.mcQ = stickerItem;
            this.mcP.Ow(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.maW != null) {
                    this.maW.setSticker(null);
                    this.mcV = false;
                }
                if (this.mcv != null) {
                    this.mcv.setDownLoadSticker(null);
                }
                this.mcD.setVisibility(8);
                this.mcC.setViewChoosed(1, false);
                return;
            }
            String Ot = this.mcP.Ot(stickerItem.resource);
            if (!StringUtils.isNull(Ot)) {
                a(stickerItem, Ot);
                if (this.mcv != null) {
                    this.mcv.setDownLoadSticker(null);
                }
            } else {
                if (this.mcv != null) {
                    this.mcv.setDownLoadSticker(stickerItem);
                }
                this.mcP.Ou(stickerItem.resource);
            }
            this.mcC.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.maW != null) {
                this.maW.setSticker(stickerItem);
                this.mcV = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mcD.setText(stickerItem.desc);
                this.mcD.setVisibility(0);
                this.mcD.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mcD.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.mcD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dj(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mcv.getLayoutParams();
            layoutParams.height = i4;
            this.mcv.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ob = com.baidu.tieba.video.editvideo.model.a.dna().Ob(stringExtra);
                if (this.mcR != null && !TextUtils.isEmpty(Ob)) {
                    this.mcR.fH(Ob, stringExtra2);
                    this.mcv.dof();
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
        if (this.maO.getStatus() == 8) {
            this.mcv.dpk();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void vs(boolean z) {
        if (this.maO != null && (this.maO.getStatus() == 1 || this.maO.getStatus() == 3 || this.maO.getStatus() == 4)) {
            if (!z && this.mcV) {
                this.mcA.doE();
                return;
            } else {
                this.mcA.doF();
                return;
            }
        }
        this.mcA.doF();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ag(int i, boolean z) {
        int i2 = 1;
        if (this.hSW != i) {
            switch (i) {
                case 1:
                    if (this.mcR != null) {
                        this.mcR.aKF();
                    }
                    this.maW.setFilter("origin");
                    this.mcC.setViewChoosed(0, false);
                    this.mcC.setViewChoosed(3, false);
                    this.mcv.Gp(1);
                    this.mcC.setViewVisibility(0, 8);
                    this.mcC.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mcC.setViewVisibility(0, 0);
                    this.mcC.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hSW = i;
            this.mcv.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ao().ag("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void doM() {
        if (this.maO.getStatus() == 1 && !this.mcv.dpp()) {
            ag(1, true);
            this.mcS.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void doL() {
        if (this.maO.getStatus() == 1 && !this.mcv.dpp()) {
            ag(2, true);
            this.mcS.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gn(int i) {
        if (this.lHf != null) {
            this.lHf.bo(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(int i, String str) {
        if (this.lHf != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.lHf.bn(i, str);
        }
    }
}
