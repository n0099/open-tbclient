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
    private String lVZ;
    private SelectMusicModel lWd;
    private b.a lZv;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;
    private i maR;
    protected h maZ;
    private b mbH;
    private ImageView mcA;
    private ImageView mcB;
    private ImageView mcC;
    private PreviewViewContainer mcD;
    private TextView mcE;
    private VideoEffectButtonLayout mcF;
    private TextView mcG;
    private RoundProgressBar mcH;
    private TextView mcI;
    private AnimatorSet mcJ;
    private AnimatorSet mcK;
    private ScaleAnimation mcL;
    private ObjectAnimator mcM;
    private ObjectAnimator mcN;
    private int mcO;
    private int mcP;
    private boolean mcQ;
    private boolean mcR = true;
    private l mcS;
    private StickerItem mcT;
    protected j mcU;
    private RecordTabLayout mcV;
    private ImageFileInfo mcW;
    private HttpMessageListener mcX;
    private boolean mcY;
    private RecordLayout mcx;
    private VideoControllerLayout mcy;
    private RelativeLayout mcz;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.lHf = lVar.cCQ();
        }
        if (this.lHf != null) {
            this.lHf.cCs();
        }
        this.lZv = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void fb(List<com.baidu.tieba.video.localvideo.d> list) {
                if (w.isEmpty(list)) {
                    if (RecordVideoActivity.this.mcy != null) {
                        RecordVideoActivity.this.mcy.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.mcy != null) {
                    RecordVideoActivity.this.mcy.setHasLocalVideo(true);
                    RecordVideoActivity.this.mcR = false;
                }
            }
        };
        this.mcX = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
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
                    if (RecordVideoActivity.this.mcy != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.mcy.setStickerItems(list);
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
    public void doT() {
        PostPrefixData postPrefixData;
        AntiData antiData = null;
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.maZ.lYK);
        videoInfo.setVideoDuration(this.maR.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.maZ.lYK).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.hLG == null ? "" : this.hLG.forumName;
        String str2 = this.hLG == null ? "" : this.hLG.forumId;
        int i = this.hLG == null ? -1 : this.hLG.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.hLG.writeCallFrom, str, str2, this.lVZ, videoInfo);
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
        if (this.mcU != null) {
            this.mcU.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.lHf != null) {
            this.lHf.cCv();
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
        if (this.maR != null && this.maR.aZz()) {
            this.maR.stopRecord();
        }
        if (this.lWd != null) {
            this.lWd.cancelLoadData();
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
        this.mcO = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        this.mcP = getIntent().getIntExtra(RecordVideoActivityConfig.SHOW_TYPE, 0);
        if (getIntent().getSerializableExtra("forum_write_data") instanceof ForumWriteData) {
            this.hLG = (ForumWriteData) getIntent().getSerializableExtra("forum_write_data");
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.lVZ = getIntent().getStringExtra("video_title");
        initUI();
        this.lWd = new SelectMusicModel(getPageContext(), this.mcy);
        this.lWd.dnk();
        this.mcU = new j(this);
        this.mcU.b(this.lWd);
        this.maR.a(this.mcU);
        registerListener(this.mcX);
        registerListener(this.hUL);
        registerListener(this.jDq);
        doU();
    }

    private void doU() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dnN() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.lZv);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.mcx = (RecordLayout) findViewById(R.id.root_layout);
        this.mcx.setListener(this);
        this.maR = new i(this);
        this.mcy = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.mcy.setRecordController(this.maR);
        this.mcy.setRecordControlListener(this);
        this.mcy.setEffectChoosedListener(this);
        this.mcz = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gqS = (ImageView) findViewById(R.id.close_page);
        this.gqS.setOnClickListener(this);
        this.mcA = (ImageView) findViewById(R.id.flash_switch);
        this.mcA.setOnClickListener(this);
        this.mcB = (ImageView) findViewById(R.id.camera_switch);
        this.mcB.setOnClickListener(this);
        this.mcC = (ImageView) findViewById(R.id.count_down);
        this.mcC.setOnClickListener(this);
        this.mcD = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.maZ = new h(this);
        this.maZ.a(this);
        this.maZ.setFaceIdentifyStateListener(this);
        this.maZ.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
            @Override // com.baidu.tieba.video.record.h.b
            public void doH() {
                if (RecordVideoActivity.this.mcy.dpt()) {
                    RecordVideoActivity.this.mcy.a((m) null);
                }
            }
        });
        this.mcF = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.mcF.setListener(this);
        this.maR.a(this.mcF);
        this.mcF.setViewChoosed(2, true);
        this.mcE = (TextView) findViewById(R.id.tv_count_down);
        this.mcG = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.mcE.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.mcE.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.mcF.setVisibility(8);
        }
        this.bds = findViewById(R.id.progress_layout);
        this.mcH = (RoundProgressBar) this.bds.findViewById(R.id.video_progress);
        this.mcI = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mcI.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.mcI.setLayoutParams(layoutParams);
        this.mcV = (RecordTabLayout) findViewById(R.id.tab_layout);
        if (this.mWriteImagesInfo == null || w.isEmpty(this.mWriteImagesInfo.getChosedFiles())) {
            Gm(this.mcP);
        } else {
            Gm(1);
        }
        doV();
    }

    private void Gm(int i) {
        if (this.mcV != null) {
            if (i == 0) {
                this.mcV.bI(1, getString(R.string.tab_photo));
                this.mcV.bI(2, getString(R.string.tab_record));
                this.mcV.setListener(this);
                this.mcV.setCurrentTab(2, false);
                ag(2, false);
            } else if (i == 1) {
                this.mcV.bI(1, getString(R.string.tab_photo));
                this.mcV.setShowIndicator(false);
                this.mcV.setCurrentTab(1, false);
                ag(1, false);
            } else {
                this.mcV.bI(2, getString(R.string.tab_record));
                this.mcV.setShowIndicator(false);
                this.mcV.setCurrentTab(2, false);
                ag(2, false);
            }
        }
    }

    private void doV() {
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
        this.maZ.onResume();
        this.mbH = this.maZ.doy();
        if (this.mbH != null) {
            this.mbH.setRecordController(this.maR);
            this.mcD.setZoomHelper(this.mbH);
        }
        doW();
        if (this.mcS == null) {
            this.mcS = new l();
            this.mcS.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                @Override // com.baidu.tieba.video.record.l.a
                public void fE(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.mcT, str2);
                    if (RecordVideoActivity.this.mcy != null) {
                        RecordVideoActivity.this.mcy.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void NW(String str) {
                    if (RecordVideoActivity.this.mcy != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.mcy.b(stickerItem);
                        if (RecordVideoActivity.this.maZ != null) {
                            RecordVideoActivity.this.maZ.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.mcy != null) {
                        RecordVideoActivity.this.mcy.setDownLoadSticker(null);
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
                public void dmx() {
                    if (RecordVideoActivity.this.mcy != null) {
                        RecordVideoActivity.this.mcy.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.mcS.dpn();
        if (this.mcy != null && this.mcR) {
            dnN();
        }
        if (this.lHf != null) {
            this.lHf.IX("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.maZ.onPause();
        if (this.mcy != null) {
            if (this.maR != null && this.maR.getStatus() == 6) {
                this.mcy.stopRecord();
                dpf();
            }
            if (this.maR != null && this.maR.aZz()) {
                this.mcy.stopRecord();
            }
        }
        if (this.mcU != null) {
            this.mcU.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.maR == null || this.maR.getStatus() != 7) {
            if (this.maR != null && this.maR.getStatus() == 6) {
                if (this.mcy != null) {
                    this.mcy.stopRecord();
                }
                dpf();
            } else if (this.maR != null && this.maR.onBackPressed()) {
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
        this.mcI.setVisibility(4);
        if (view == this.gqS) {
            onBackPressed();
        } else if (view == this.mcA) {
            if (this.maR.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.maZ.doB();
            doW();
        } else if (view == this.mcB) {
            if (this.maR.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.mcB.setOnClickListener(null);
            this.maZ.doD();
            if (this.maZ.doE() && this.maZ.doC()) {
                this.maZ.doB();
            }
            doW();
            this.mcB.setOnClickListener(this);
        } else if (view == this.mcC) {
            doY();
        }
    }

    private void doW() {
        if (this.maZ.doE()) {
            this.mcA.setVisibility(8);
        } else {
            this.mcA.setVisibility(0);
        }
        if (this.maZ.doC()) {
            this.mcA.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.mcA.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout doX() {
        return this.mcD;
    }

    public void doY() {
        this.mcI.setVisibility(4);
        if (this.maR.getStatus() != 6) {
            this.maR.setStatus(6);
            dpd();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.mcL == null) {
                this.mcL = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.mcL.setDuration(500L);
                this.mcL.setRepeatCount(5);
                this.mcL.setRepeatMode(2);
                this.mcL.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.mcL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.maR.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.mcE.setVisibility(0);
                        RecordVideoActivity.this.mcE.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.mcE.setVisibility(8);
                    if (RecordVideoActivity.this.maR.getStatus() == 6) {
                        RecordVideoActivity.this.mcy.dpq();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.maR.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.mcE.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.mcE.setText("");
                        }
                    }
                }
            });
            this.mcE.setAnimation(this.mcL);
            this.mcL.startNow();
            this.mcy.doY();
            if (this.mcU != null) {
                this.mcU.doS();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void doZ() {
        if (this.maR.getStatus() == 1) {
            this.mcI.setVisibility(4);
            if (this.maR.getStatus() != 6) {
                this.mcy.doZ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpa() {
        this.mcI.setVisibility(4);
        if (this.maR.getStatus() != 6) {
            this.mcy.dpa();
            if (this.mcy.dpu()) {
                doU();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpb() {
        this.mcI.setVisibility(4);
        if (this.maR.getStatus() != 6) {
            this.mcy.dpb();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void dpc() {
        this.mcI.setVisibility(4);
        if (this.maR.getStatus() != 6) {
            this.mcy.dpc();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpd() {
        this.mcQ = true;
        if (this.mcK != null && this.mcK.isRunning()) {
            this.mcK.cancel();
        }
        if (this.mcJ == null) {
            this.mcJ = new AnimatorSet();
            this.mcJ.playTogether(ObjectAnimator.ofFloat(this.mcz, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mcF, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.mcV, "alpha", 1.0f, 0.0f));
            this.mcJ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mev) {
                        RecordVideoActivity.this.mcz.setVisibility(8);
                        RecordVideoActivity.this.mcF.setVisibility(8);
                        RecordVideoActivity.this.mcV.setVisibility(8);
                    }
                }
            });
            this.mcJ.setDuration(300L);
        }
        this.mcJ.start();
        this.mcF.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void doS() {
        if (this.hSW == 2) {
            if (this.mcQ) {
                this.mcQ = false;
                if (this.mcU != null) {
                    this.mcU.doS();
                }
            } else {
                return;
            }
        }
        if (this.mcJ != null && this.mcJ.isRunning()) {
            this.mcJ.cancel();
        }
        if (this.mcK == null) {
            this.mcK = new AnimatorSet();
            this.mcK.playTogether(ObjectAnimator.ofFloat(this.mcz, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mcF, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.mcV, "alpha", 0.0f, 1.0f));
            this.mcK.setDuration(300L);
        }
        this.mcz.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mcF.setVisibility(0);
        }
        if (this.maR.getStatus() == 1) {
            this.mcV.setVisibility(0);
        }
        this.mcK.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpe() {
        if (this.maZ != null) {
            this.maZ.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.14
                @Override // com.baidu.tieba.video.record.g.a
                public void C(boolean z, String str) {
                    RecordVideoActivity.this.maR.setStatus(1);
                    RecordVideoActivity.this.doS();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.mcW != null && !w.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.mcW)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.mcW);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.mcW = new ImageFileInfo();
                        RecordVideoActivity.this.mcW.setFilePath(str);
                        RecordVideoActivity.this.mcW.setContentUriStr(null);
                        RecordVideoActivity.this.mcW.setTempFile(true);
                        RecordVideoActivity.this.mcW.setAlbumnId(null);
                        RecordVideoActivity.this.mcW.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.mcW);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.hLG, RecordVideoActivity.this.mcO)));
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
    public void dpf() {
        this.mcL.cancel();
        this.mcL.setAnimationListener(null);
        this.mcE.clearAnimation();
        this.mcE.setVisibility(8);
        if (this.mcU != null) {
            this.mcU.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpg() {
        dgB();
    }

    private void dgB() {
        if (this.mcM != null) {
            this.mcM.cancel();
        }
        if (this.mcN == null) {
            this.mcN = ObjectAnimator.ofFloat(this.mcV, "alpha", 1.0f, 0.0f);
            this.mcN.setDuration(500L);
            this.mcN.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.mev) {
                        RecordVideoActivity.this.mcV.setVisibility(8);
                    }
                }
            });
        }
        this.mcN.start();
    }

    private void dgA() {
        if (this.mcN != null) {
            this.mcN.cancel();
        }
        if (this.mcM == null) {
            this.mcM = ObjectAnimator.ofFloat(this.mcV, "alpha", 0.0f, 1.0f);
            this.mcM.setDuration(500L);
        }
        this.mcV.setVisibility(0);
        this.mcM.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dph() {
        this.mcF.reset();
        if (this.maR.getStatus() == 1) {
            dgA();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpi() {
        if (this.bds.getVisibility() != 0) {
            this.mcy.dpp();
            this.maR.setStatus(8);
            doS();
            if (this.maZ.mbF != null && this.maZ.mbF.size() > 0) {
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
        final int mda = 50;
        final int mdb = 1;
        Handler mdc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.mcH.G(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dpm();
                }
            }
        };

        AnonymousClass3() {
        }

        public void dpm() {
            this.mdc.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dpm();
            boolean z = RecordVideoActivity.this.mcU == null || TextUtils.isEmpty(RecordVideoActivity.this.mcU.doR()) || !new File(RecordVideoActivity.this.mcU.doR()).exists();
            if (RecordVideoActivity.this.maZ.mbF.size() > 1) {
                return com.baidu.tieba.video.meida.h.doe().a(RecordVideoActivity.this.maZ.mbF, RecordVideoActivity.this.maZ.dov(), z);
            }
            File file = new File(RecordVideoActivity.this.maZ.mbF.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    n.copyFile(file.getPath(), RecordVideoActivity.this.maZ.dov());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.doe().a(RecordVideoActivity.this.maZ.mbF, RecordVideoActivity.this.maZ.dov(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.mcy.dpv();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.doT();
                    RecordVideoActivity.this.Gn(102);
                    RecordVideoActivity.this.bds.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.doT();
                RecordVideoActivity.this.Gn(102);
                RecordVideoActivity.this.bds.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bds.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.bn(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.mcH.G(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.mcy == null || w.isEmpty(this.mcy.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.mcy.getChoosedBeautyList()) {
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
        if (this.mcy == null || w.isEmpty(this.mcy.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.mcy.getChoosedFilterList()) {
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
        if (this.mcy == null || w.isEmpty(this.mcy.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.mcy.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpj() {
        this.mcI.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpk() {
        this.mcI.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dpl() {
        if (this.maR.getStatus() == 1) {
            this.mcV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.maZ != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.maZ.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new ao("c12421").ag("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.mcF.setViewChoosed(2, false);
                            return;
                        } else {
                            this.mcF.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.maZ.setFilter((String) eVar.getValue());
                        ao aoVar = new ao("c12496");
                        aoVar.dk("obj_id", (String) eVar.getValue());
                        if (this.maR.getStatus() == 1) {
                            aoVar.ag("obj_type", 1);
                        } else {
                            aoVar.ag("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.mcF.setViewChoosed(3, false);
                            return;
                        } else {
                            this.mcF.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.mcU.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.mcF.setViewChoosed(0, false);
                            return;
                        } else {
                            this.mcF.setViewChoosed(0, true);
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
            this.mcT = stickerItem;
            this.mcS.Ox(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.maZ != null) {
                    this.maZ.setSticker(null);
                    this.mcY = false;
                }
                if (this.mcy != null) {
                    this.mcy.setDownLoadSticker(null);
                }
                this.mcG.setVisibility(8);
                this.mcF.setViewChoosed(1, false);
                return;
            }
            String Ou = this.mcS.Ou(stickerItem.resource);
            if (!StringUtils.isNull(Ou)) {
                a(stickerItem, Ou);
                if (this.mcy != null) {
                    this.mcy.setDownLoadSticker(null);
                }
            } else {
                if (this.mcy != null) {
                    this.mcy.setDownLoadSticker(stickerItem);
                }
                this.mcS.Ov(stickerItem.resource);
            }
            this.mcF.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.maZ != null) {
                this.maZ.setSticker(stickerItem);
                this.mcY = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.mcG.setText(stickerItem.desc);
                this.mcG.setVisibility(0);
                this.mcG.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.mcG.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.mcG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void dj(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.mcy.getLayoutParams();
            layoutParams.height = i4;
            this.mcy.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Oc = com.baidu.tieba.video.editvideo.model.a.dne().Oc(stringExtra);
                if (this.mcU != null && !TextUtils.isEmpty(Oc)) {
                    this.mcU.fH(Oc, stringExtra2);
                    this.mcy.doj();
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
        if (this.maR.getStatus() == 8) {
            this.mcy.dpo();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void vs(boolean z) {
        if (this.maR != null && (this.maR.getStatus() == 1 || this.maR.getStatus() == 3 || this.maR.getStatus() == 4)) {
            if (!z && this.mcY) {
                this.mcD.doI();
                return;
            } else {
                this.mcD.doJ();
                return;
            }
        }
        this.mcD.doJ();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void ag(int i, boolean z) {
        int i2 = 1;
        if (this.hSW != i) {
            switch (i) {
                case 1:
                    if (this.mcU != null) {
                        this.mcU.aKF();
                    }
                    this.maZ.setFilter("origin");
                    this.mcF.setViewChoosed(0, false);
                    this.mcF.setViewChoosed(3, false);
                    this.mcy.Gp(1);
                    this.mcF.setViewVisibility(0, 8);
                    this.mcF.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.mcF.setViewVisibility(0, 0);
                    this.mcF.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hSW = i;
            this.mcy.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new ao().ag("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void doQ() {
        if (this.maR.getStatus() == 1 && !this.mcy.dpt()) {
            ag(1, true);
            this.mcV.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void doP() {
        if (this.maR.getStatus() == 1 && !this.mcy.dpt()) {
            ag(2, true);
            this.mcV.setCurrentTab(2, true);
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
