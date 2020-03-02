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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View aGh;
    private ImageView fjU;
    private final CustomMessageListener gHq;
    private i kAM;
    protected h kAU;
    private b kBB;
    private TextView kCA;
    private RoundProgressBar kCB;
    private TextView kCC;
    private AnimatorSet kCD;
    private AnimatorSet kCE;
    private ScaleAnimation kCF;
    private ObjectAnimator kCG;
    private ObjectAnimator kCH;
    private int kCI;
    private ForumWriteData kCJ;
    private boolean kCK;
    private boolean kCL = true;
    private l kCM;
    private StickerItem kCN;
    protected j kCO;
    private RecordTabLayout kCP;
    private ImageFileInfo kCQ;
    private HttpMessageListener kCR;
    private boolean kCS;
    private RecordLayout kCq;
    private VideoControllerLayout kCr;
    private RelativeLayout kCs;
    private ImageView kCt;
    private ImageView kCu;
    private ImageView kCv;
    private com.baidu.tbadk.core.dialog.a kCw;
    private PreviewViewContainer kCx;
    private TextView kCy;
    private VideoEffectButtonLayout kCz;
    private com.baidu.tieba.k.h khN;
    private String kwm;
    private SelectMusicModel kwq;
    private b.a kzv;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.khN = lVar.cgY();
        }
        if (this.khN != null) {
            this.khN.cgA();
        }
        this.kzv = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eq(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kCr != null) {
                        RecordVideoActivity.this.kCr.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kCr != null) {
                    RecordVideoActivity.this.kCr.setHasLocalVideo(true);
                    RecordVideoActivity.this.kCL = false;
                }
            }
        };
        this.kCR = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kCr != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kCr.setStickerItems(list);
                    }
                }
            }
        };
        this.gHq = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
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
    public void cRG() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kAU.kwr);
        videoInfo.setVideoDuration(this.kAM.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kAU.kwr).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kCJ == null ? "" : this.kCJ.forumName;
        String str2 = this.kCJ == null ? "" : this.kCJ.forumId;
        int i = this.kCJ == null ? -1 : this.kCJ.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kCJ.writeCallFrom, str, str2, this.kwm, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.kCO != null) {
            this.kCO.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.khN != null) {
            this.khN.cgD();
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
        if (this.kAM != null && this.kAM.isRecording()) {
            this.kAM.stopRecord();
        }
        if (this.kwq != null) {
            this.kwq.cancelLoadData();
        }
        if (this.khN != null) {
            this.khN.Fb("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuN));
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
        this.kCI = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kCJ = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.kwm = getIntent().getStringExtra("video_title");
        initUI();
        this.kwq = new SelectMusicModel(getPageContext(), this.kCr);
        this.kwq.cQe();
        this.kCO = new j(this);
        this.kCO.b(this.kwq);
        this.kAM.a(this.kCO);
        registerListener(this.kCR);
        registerListener(this.gHq);
        cRH();
    }

    private void cRH() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cQE() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kzv);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kCq = (RecordLayout) findViewById(R.id.root_layout);
        this.kCq.setListener(this);
        this.kAM = new i(this);
        this.kCr = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kCr.setRecordController(this.kAM);
        this.kCr.setRecordControlListener(this);
        this.kCr.setEffectChoosedListener(this);
        this.kCs = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fjU = (ImageView) findViewById(R.id.close_page);
        this.fjU.setOnClickListener(this);
        this.kCt = (ImageView) findViewById(R.id.flash_switch);
        this.kCt.setOnClickListener(this);
        this.kCu = (ImageView) findViewById(R.id.camera_switch);
        this.kCu.setOnClickListener(this);
        this.kCv = (ImageView) findViewById(R.id.count_down);
        this.kCv.setOnClickListener(this);
        this.kCx = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kAU = new h(this);
        this.kAU.a(this);
        this.kAU.setFaceIdentifyStateListener(this);
        this.kAU.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cRv() {
                if (RecordVideoActivity.this.kCr.cSg()) {
                    RecordVideoActivity.this.kCr.a((m) null);
                }
            }
        });
        this.kCz = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kCz.setListener(this);
        this.kAM.a(this.kCz);
        this.kCz.setViewChoosed(2, true);
        this.kCy = (TextView) findViewById(R.id.tv_count_down);
        this.kCA = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kCy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kCy.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kCz.setVisibility(8);
        }
        this.aGh = findViewById(R.id.progress_layout);
        this.kCB = (RoundProgressBar) this.aGh.findViewById(R.id.video_progress);
        this.kCC = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCC.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kCC.setLayoutParams(layoutParams);
        this.kCP = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kCP.bf(1, getString(R.string.tab_photo));
        if (this.kCI != 2 && this.kCI != 3) {
            this.kCP.bf(2, getString(R.string.tab_record));
            this.kCP.setListener(this);
            this.kCP.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kCP.setShowIndicator(false);
            this.kCP.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cRI();
    }

    private void cRI() {
        if (com.baidu.tbadk.core.util.g.aFM()) {
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
        this.kAU.onResume();
        this.kBB = this.kAU.cRn();
        if (this.kBB != null) {
            this.kBB.setRecordController(this.kAM);
            this.kCx.setZoomHelper(this.kBB);
        }
        cRJ();
        if (this.kCM == null) {
            this.kCM = new l();
            this.kCM.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eJ(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kCN, str2);
                    if (RecordVideoActivity.this.kCr != null) {
                        RecordVideoActivity.this.kCr.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void JT(String str) {
                    if (RecordVideoActivity.this.kCr != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kCr.b(stickerItem);
                        if (RecordVideoActivity.this.kAU != null) {
                            RecordVideoActivity.this.kAU.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kCr != null) {
                        RecordVideoActivity.this.kCr.setDownLoadSticker(null);
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
                    recordVideoActivity.aP(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void cPq() {
                    if (RecordVideoActivity.this.kCr != null) {
                        RecordVideoActivity.this.kCr.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kCM.cSa();
        if (this.kCr != null && this.kCL) {
            cQE();
        }
        if (this.khN != null) {
            this.khN.Fa("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kAU.onPause();
        if (this.kCr != null) {
            if (this.kAM != null && this.kAM.getStatus() == 6) {
                this.kCr.stopRecord();
                cRS();
            }
            if (this.kAM != null && this.kAM.isRecording()) {
                this.kCr.stopRecord();
            }
        }
        if (this.kCO != null) {
            this.kCO.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kAM == null || this.kAM.getStatus() != 7) {
            if (this.kAM != null && this.kAM.getStatus() == 6) {
                if (this.kCr != null) {
                    this.kCr.stopRecord();
                }
                cRS();
            } else if (this.kAM.onBackPressed()) {
                finish();
            } else {
                if (this.kCw == null) {
                    this.kCw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kCw.jW(R.string.video_quit_confirm);
                    this.kCw.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kCw.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kCw.fG(true);
                    this.kCw.b(getPageContext());
                }
                this.kCw.aEC();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kCC.setVisibility(4);
        if (view == this.fjU) {
            onBackPressed();
        } else if (view == this.kCt) {
            if (this.kAM.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kAU.cRq();
            cRJ();
        } else if (view == this.kCu) {
            if (this.kAM.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kCu.setOnClickListener(null);
            this.kAU.cRs();
            if (this.kAU.getIsFrontCamera() && this.kAU.cRr()) {
                this.kAU.cRq();
            }
            cRJ();
            this.kCu.setOnClickListener(this);
        } else if (view == this.kCv) {
            cRL();
        }
    }

    private void cRJ() {
        if (this.kAU.getIsFrontCamera()) {
            this.kCt.setVisibility(8);
        } else {
            this.kCt.setVisibility(0);
        }
        if (this.kAU.cRr()) {
            this.kCt.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kCt.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cRK() {
        return this.kCx;
    }

    public void cRL() {
        this.kCC.setVisibility(4);
        if (this.kAM.getStatus() != 6) {
            this.kAM.setStatus(6);
            cRQ();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kCF == null) {
                this.kCF = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kCF.setDuration(500L);
                this.kCF.setRepeatCount(5);
                this.kCF.setRepeatMode(2);
                this.kCF.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kCF.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kAM.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kCy.setVisibility(0);
                        RecordVideoActivity.this.kCy.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kCy.setVisibility(8);
                    if (RecordVideoActivity.this.kAM.getStatus() == 6) {
                        RecordVideoActivity.this.kCr.cSd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kAM.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kCy.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kCy.setText("");
                        }
                    }
                }
            });
            this.kCy.setAnimation(this.kCF);
            this.kCF.startNow();
            this.kCr.cRL();
            if (this.kCO != null) {
                this.kCO.cRF();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRM() {
        if (this.kAM.getStatus() == 1) {
            this.kCC.setVisibility(4);
            if (this.kAM.getStatus() != 6) {
                this.kCr.cRM();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        this.kCC.setVisibility(4);
        if (this.kAM.getStatus() != 6) {
            this.kCr.cRN();
            if (this.kCr.cSh()) {
                cRH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRO() {
        this.kCC.setVisibility(4);
        if (this.kAM.getStatus() != 6) {
            this.kCr.cRO();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRP() {
        this.kCC.setVisibility(4);
        if (this.kAM.getStatus() != 6) {
            this.kCr.cRP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRQ() {
        this.kCK = true;
        if (this.kCE != null && this.kCE.isRunning()) {
            this.kCE.cancel();
        }
        if (this.kCD == null) {
            this.kCD = new AnimatorSet();
            this.kCD.playTogether(ObjectAnimator.ofFloat(this.kCs, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCz, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCP, "alpha", 1.0f, 0.0f));
            this.kCD.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEp) {
                        RecordVideoActivity.this.kCs.setVisibility(8);
                        RecordVideoActivity.this.kCz.setVisibility(8);
                        RecordVideoActivity.this.kCP.setVisibility(8);
                    }
                }
            });
            this.kCD.setDuration(300L);
        }
        this.kCD.start();
        this.kCz.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRF() {
        if (this.mCurrentTab == 2) {
            if (this.kCK) {
                this.kCK = false;
                if (this.kCO != null) {
                    this.kCO.cRF();
                }
            } else {
                return;
            }
        }
        if (this.kCD != null && this.kCD.isRunning()) {
            this.kCD.cancel();
        }
        if (this.kCE == null) {
            this.kCE = new AnimatorSet();
            this.kCE.playTogether(ObjectAnimator.ofFloat(this.kCs, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCz, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCP, "alpha", 0.0f, 1.0f));
            this.kCE.setDuration(300L);
        }
        this.kCs.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kCz.setVisibility(0);
        }
        if (this.kAM.getStatus() == 1) {
            this.kCP.setVisibility(0);
        }
        this.kCE.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRR() {
        if (this.kAU != null) {
            this.kAU.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kAM.setStatus(1);
                    RecordVideoActivity.this.cRF();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kCQ != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kCQ)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kCQ);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kCQ = new ImageFileInfo();
                        RecordVideoActivity.this.kCQ.setFilePath(str);
                        RecordVideoActivity.this.kCQ.setTempFile(true);
                        RecordVideoActivity.this.kCQ.setAlbumnId(null);
                        RecordVideoActivity.this.kCQ.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kCQ);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kCJ, RecordVideoActivity.this.kCI)));
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
    public void cRS() {
        this.kCF.cancel();
        this.kCF.setAnimationListener(null);
        this.kCy.clearAnimation();
        this.kCy.setVisibility(8);
        if (this.kCO != null) {
            this.kCO.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRT() {
        cJE();
    }

    private void cJE() {
        if (this.kCG != null) {
            this.kCG.cancel();
        }
        if (this.kCH == null) {
            this.kCH = ObjectAnimator.ofFloat(this.kCP, "alpha", 1.0f, 0.0f);
            this.kCH.setDuration(500L);
            this.kCH.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEp) {
                        RecordVideoActivity.this.kCP.setVisibility(8);
                    }
                }
            });
        }
        this.kCH.start();
    }

    private void cJD() {
        if (this.kCH != null) {
            this.kCH.cancel();
        }
        if (this.kCG == null) {
            this.kCG = ObjectAnimator.ofFloat(this.kCP, "alpha", 0.0f, 1.0f);
            this.kCG.setDuration(500L);
        }
        this.kCP.setVisibility(0);
        this.kCG.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRU() {
        this.kCz.reset();
        if (this.kAM.getStatus() == 1) {
            cJD();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRV() {
        if (this.aGh.getVisibility() != 0) {
            this.kCr.cSc();
            this.kAM.setStatus(8);
            cRF();
            if (this.kAU.kBz != null && this.kAU.kBz.size() > 0) {
                this.aGh.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kCU = 50;
        final int kCV = 1;
        Handler kCW = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kCB.V(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cRZ();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cRZ() {
            this.kCW.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cRZ();
            boolean z = RecordVideoActivity.this.kCO == null || TextUtils.isEmpty(RecordVideoActivity.this.kCO.cRE()) || !new File(RecordVideoActivity.this.kCO.cRE()).exists();
            if (RecordVideoActivity.this.kAU.kBz.size() > 1) {
                return com.baidu.tieba.video.meida.h.cQU().a(RecordVideoActivity.this.kAU.kBz, RecordVideoActivity.this.kAU.cRk(), z);
            }
            File file = new File(RecordVideoActivity.this.kAU.kBz.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kAU.cRk());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cQU().a(RecordVideoActivity.this.kAU.kBz, RecordVideoActivity.this.kAU.cRk(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kCr.cSi();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cRG();
                    RecordVideoActivity.this.DK(102);
                    RecordVideoActivity.this.aGh.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cRG();
                RecordVideoActivity.this.DK(102);
                RecordVideoActivity.this.aGh.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aGh.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aP(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kCB.V(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kCr == null || v.isEmpty(this.kCr.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kCr.getChoosedBeautyList()) {
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
        if (this.kCr == null || v.isEmpty(this.kCr.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kCr.getChoosedFilterList()) {
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
        if (this.kCr == null || v.isEmpty(this.kCr.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kCr.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRW() {
        this.kCC.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRX() {
        this.kCC.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRY() {
        if (this.kAM.getStatus() == 1) {
            this.kCP.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kAU != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kAU.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").X("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kCz.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kCz.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kAU.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cy("obj_id", (String) eVar.getValue());
                        if (this.kAM.getStatus() == 1) {
                            anVar.X("obj_type", 1);
                        } else {
                            anVar.X("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kCz.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kCz.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kCO.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kCz.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kCz.setViewChoosed(0, true);
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
            this.kCN = stickerItem;
            this.kCM.Kr(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kAU != null) {
                    this.kAU.setSticker(null);
                    this.kCS = false;
                }
                if (this.kCr != null) {
                    this.kCr.setDownLoadSticker(null);
                }
                this.kCA.setVisibility(8);
                this.kCz.setViewChoosed(1, false);
                return;
            }
            String Ko = this.kCM.Ko(stickerItem.resource);
            if (!StringUtils.isNull(Ko)) {
                a(stickerItem, Ko);
                if (this.kCr != null) {
                    this.kCr.setDownLoadSticker(null);
                }
            } else {
                if (this.kCr != null) {
                    this.kCr.setDownLoadSticker(stickerItem);
                }
                this.kCM.Kp(stickerItem.resource);
            }
            this.kCz.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kAU != null) {
                this.kAU.setSticker(stickerItem);
                this.kCS = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kCA.setText(stickerItem.desc);
                this.kCA.setVisibility(0);
                this.kCA.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kCA.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kCA.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cS(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kCr.getLayoutParams();
            layoutParams.height = i4;
            this.kCr.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ka = com.baidu.tieba.video.editvideo.model.a.cPY().Ka(stringExtra);
                if (this.kCO != null && !TextUtils.isEmpty(Ka)) {
                    this.kCO.eK(Ka, stringExtra2);
                    this.kCr.cQZ();
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
        if (this.kAM.getStatus() == 8) {
            this.kCr.cSb();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void tu(boolean z) {
        if (this.kAM != null && (this.kAM.getStatus() == 1 || this.kAM.getStatus() == 3 || this.kAM.getStatus() == 4)) {
            if (!z && this.kCS) {
                this.kCx.cRw();
                return;
            } else {
                this.kCx.cRx();
                return;
            }
        }
        this.kCx.cRx();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kCO != null) {
                        this.kCO.aWC();
                    }
                    this.kAU.setFilter("origin");
                    this.kCz.setViewChoosed(0, false);
                    this.kCz.setViewChoosed(3, false);
                    this.kCr.DM(1);
                    this.kCz.setViewVisibility(0, 8);
                    this.kCz.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kCz.setViewVisibility(0, 0);
                    this.kCz.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kCr.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().X("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRD() {
        if (this.kAM.getStatus() == 1 && !this.kCr.cSg()) {
            onTabChoosed(1, true);
            this.kCP.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRC() {
        if (this.kAM.getStatus() == 1 && !this.kCr.cSg()) {
            onTabChoosed(2, true);
            this.kCP.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DK(int i) {
        if (this.khN != null) {
            this.khN.aQ(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (this.khN != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.khN.aP(i, str);
        }
    }
}
