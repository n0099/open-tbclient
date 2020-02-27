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
    private View aGg;
    private ImageView fjT;
    private final CustomMessageListener gHo;
    private i kAK;
    protected h kAS;
    private b kBz;
    private TextView kCA;
    private AnimatorSet kCB;
    private AnimatorSet kCC;
    private ScaleAnimation kCD;
    private ObjectAnimator kCE;
    private ObjectAnimator kCF;
    private int kCG;
    private ForumWriteData kCH;
    private boolean kCI;
    private boolean kCJ = true;
    private l kCK;
    private StickerItem kCL;
    protected j kCM;
    private RecordTabLayout kCN;
    private ImageFileInfo kCO;
    private HttpMessageListener kCP;
    private boolean kCQ;
    private RecordLayout kCo;
    private VideoControllerLayout kCp;
    private RelativeLayout kCq;
    private ImageView kCr;
    private ImageView kCs;
    private ImageView kCt;
    private com.baidu.tbadk.core.dialog.a kCu;
    private PreviewViewContainer kCv;
    private TextView kCw;
    private VideoEffectButtonLayout kCx;
    private TextView kCy;
    private RoundProgressBar kCz;
    private com.baidu.tieba.k.h khL;
    private String kwk;
    private SelectMusicModel kwo;
    private b.a kzt;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.khL = lVar.cgW();
        }
        if (this.khL != null) {
            this.khL.cgy();
        }
        this.kzt = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eq(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kCp != null) {
                        RecordVideoActivity.this.kCp.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kCp != null) {
                    RecordVideoActivity.this.kCp.setHasLocalVideo(true);
                    RecordVideoActivity.this.kCJ = false;
                }
            }
        };
        this.kCP = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kCp != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kCp.setStickerItems(list);
                    }
                }
            }
        };
        this.gHo = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cRE() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kAS.kwp);
        videoInfo.setVideoDuration(this.kAK.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kAS.kwp).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kCH == null ? "" : this.kCH.forumName;
        String str2 = this.kCH == null ? "" : this.kCH.forumId;
        int i = this.kCH == null ? -1 : this.kCH.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kCH.writeCallFrom, str, str2, this.kwk, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.kCM != null) {
            this.kCM.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.khL != null) {
            this.khL.cgB();
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
        if (this.kAK != null && this.kAK.isRecording()) {
            this.kAK.stopRecord();
        }
        if (this.kwo != null) {
            this.kwo.cancelLoadData();
        }
        if (this.khL != null) {
            this.khL.Fb("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuL));
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
        this.kCG = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kCH = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.kwk = getIntent().getStringExtra("video_title");
        initUI();
        this.kwo = new SelectMusicModel(getPageContext(), this.kCp);
        this.kwo.cQc();
        this.kCM = new j(this);
        this.kCM.b(this.kwo);
        this.kAK.a(this.kCM);
        registerListener(this.kCP);
        registerListener(this.gHo);
        cRF();
    }

    private void cRF() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cQC() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kzt);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kCo = (RecordLayout) findViewById(R.id.root_layout);
        this.kCo.setListener(this);
        this.kAK = new i(this);
        this.kCp = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kCp.setRecordController(this.kAK);
        this.kCp.setRecordControlListener(this);
        this.kCp.setEffectChoosedListener(this);
        this.kCq = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fjT = (ImageView) findViewById(R.id.close_page);
        this.fjT.setOnClickListener(this);
        this.kCr = (ImageView) findViewById(R.id.flash_switch);
        this.kCr.setOnClickListener(this);
        this.kCs = (ImageView) findViewById(R.id.camera_switch);
        this.kCs.setOnClickListener(this);
        this.kCt = (ImageView) findViewById(R.id.count_down);
        this.kCt.setOnClickListener(this);
        this.kCv = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kAS = new h(this);
        this.kAS.a(this);
        this.kAS.setFaceIdentifyStateListener(this);
        this.kAS.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cRt() {
                if (RecordVideoActivity.this.kCp.cSe()) {
                    RecordVideoActivity.this.kCp.a((m) null);
                }
            }
        });
        this.kCx = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kCx.setListener(this);
        this.kAK.a(this.kCx);
        this.kCx.setViewChoosed(2, true);
        this.kCw = (TextView) findViewById(R.id.tv_count_down);
        this.kCy = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kCw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kCw.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kCx.setVisibility(8);
        }
        this.aGg = findViewById(R.id.progress_layout);
        this.kCz = (RoundProgressBar) this.aGg.findViewById(R.id.video_progress);
        this.kCA = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCA.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kCA.setLayoutParams(layoutParams);
        this.kCN = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kCN.bf(1, getString(R.string.tab_photo));
        if (this.kCG != 2 && this.kCG != 3) {
            this.kCN.bf(2, getString(R.string.tab_record));
            this.kCN.setListener(this);
            this.kCN.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kCN.setShowIndicator(false);
            this.kCN.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cRG();
    }

    private void cRG() {
        if (com.baidu.tbadk.core.util.g.aFK()) {
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
        this.kAS.onResume();
        this.kBz = this.kAS.cRl();
        if (this.kBz != null) {
            this.kBz.setRecordController(this.kAK);
            this.kCv.setZoomHelper(this.kBz);
        }
        cRH();
        if (this.kCK == null) {
            this.kCK = new l();
            this.kCK.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eJ(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kCL, str2);
                    if (RecordVideoActivity.this.kCp != null) {
                        RecordVideoActivity.this.kCp.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void JT(String str) {
                    if (RecordVideoActivity.this.kCp != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kCp.b(stickerItem);
                        if (RecordVideoActivity.this.kAS != null) {
                            RecordVideoActivity.this.kAS.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kCp != null) {
                        RecordVideoActivity.this.kCp.setDownLoadSticker(null);
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
                public void cPo() {
                    if (RecordVideoActivity.this.kCp != null) {
                        RecordVideoActivity.this.kCp.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kCK.cRY();
        if (this.kCp != null && this.kCJ) {
            cQC();
        }
        if (this.khL != null) {
            this.khL.Fa("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kAS.onPause();
        if (this.kCp != null) {
            if (this.kAK != null && this.kAK.getStatus() == 6) {
                this.kCp.stopRecord();
                cRQ();
            }
            if (this.kAK != null && this.kAK.isRecording()) {
                this.kCp.stopRecord();
            }
        }
        if (this.kCM != null) {
            this.kCM.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kAK == null || this.kAK.getStatus() != 7) {
            if (this.kAK != null && this.kAK.getStatus() == 6) {
                if (this.kCp != null) {
                    this.kCp.stopRecord();
                }
                cRQ();
            } else if (this.kAK.onBackPressed()) {
                finish();
            } else {
                if (this.kCu == null) {
                    this.kCu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kCu.jW(R.string.video_quit_confirm);
                    this.kCu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kCu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kCu.fG(true);
                    this.kCu.b(getPageContext());
                }
                this.kCu.aEA();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kCA.setVisibility(4);
        if (view == this.fjT) {
            onBackPressed();
        } else if (view == this.kCr) {
            if (this.kAK.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kAS.cRo();
            cRH();
        } else if (view == this.kCs) {
            if (this.kAK.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kCs.setOnClickListener(null);
            this.kAS.cRq();
            if (this.kAS.getIsFrontCamera() && this.kAS.cRp()) {
                this.kAS.cRo();
            }
            cRH();
            this.kCs.setOnClickListener(this);
        } else if (view == this.kCt) {
            cRJ();
        }
    }

    private void cRH() {
        if (this.kAS.getIsFrontCamera()) {
            this.kCr.setVisibility(8);
        } else {
            this.kCr.setVisibility(0);
        }
        if (this.kAS.cRp()) {
            this.kCr.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kCr.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cRI() {
        return this.kCv;
    }

    public void cRJ() {
        this.kCA.setVisibility(4);
        if (this.kAK.getStatus() != 6) {
            this.kAK.setStatus(6);
            cRO();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kCD == null) {
                this.kCD = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kCD.setDuration(500L);
                this.kCD.setRepeatCount(5);
                this.kCD.setRepeatMode(2);
                this.kCD.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kCD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kAK.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kCw.setVisibility(0);
                        RecordVideoActivity.this.kCw.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kCw.setVisibility(8);
                    if (RecordVideoActivity.this.kAK.getStatus() == 6) {
                        RecordVideoActivity.this.kCp.cSb();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kAK.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kCw.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kCw.setText("");
                        }
                    }
                }
            });
            this.kCw.setAnimation(this.kCD);
            this.kCD.startNow();
            this.kCp.cRJ();
            if (this.kCM != null) {
                this.kCM.cRD();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRK() {
        if (this.kAK.getStatus() == 1) {
            this.kCA.setVisibility(4);
            if (this.kAK.getStatus() != 6) {
                this.kCp.cRK();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRL() {
        this.kCA.setVisibility(4);
        if (this.kAK.getStatus() != 6) {
            this.kCp.cRL();
            if (this.kCp.cSf()) {
                cRF();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRM() {
        this.kCA.setVisibility(4);
        if (this.kAK.getStatus() != 6) {
            this.kCp.cRM();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        this.kCA.setVisibility(4);
        if (this.kAK.getStatus() != 6) {
            this.kCp.cRN();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRO() {
        this.kCI = true;
        if (this.kCC != null && this.kCC.isRunning()) {
            this.kCC.cancel();
        }
        if (this.kCB == null) {
            this.kCB = new AnimatorSet();
            this.kCB.playTogether(ObjectAnimator.ofFloat(this.kCq, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCx, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCN, "alpha", 1.0f, 0.0f));
            this.kCB.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEn) {
                        RecordVideoActivity.this.kCq.setVisibility(8);
                        RecordVideoActivity.this.kCx.setVisibility(8);
                        RecordVideoActivity.this.kCN.setVisibility(8);
                    }
                }
            });
            this.kCB.setDuration(300L);
        }
        this.kCB.start();
        this.kCx.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRD() {
        if (this.mCurrentTab == 2) {
            if (this.kCI) {
                this.kCI = false;
                if (this.kCM != null) {
                    this.kCM.cRD();
                }
            } else {
                return;
            }
        }
        if (this.kCB != null && this.kCB.isRunning()) {
            this.kCB.cancel();
        }
        if (this.kCC == null) {
            this.kCC = new AnimatorSet();
            this.kCC.playTogether(ObjectAnimator.ofFloat(this.kCq, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCx, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCN, "alpha", 0.0f, 1.0f));
            this.kCC.setDuration(300L);
        }
        this.kCq.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kCx.setVisibility(0);
        }
        if (this.kAK.getStatus() == 1) {
            this.kCN.setVisibility(0);
        }
        this.kCC.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRP() {
        if (this.kAS != null) {
            this.kAS.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kAK.setStatus(1);
                    RecordVideoActivity.this.cRD();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kCO != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kCO)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kCO);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kCO = new ImageFileInfo();
                        RecordVideoActivity.this.kCO.setFilePath(str);
                        RecordVideoActivity.this.kCO.setTempFile(true);
                        RecordVideoActivity.this.kCO.setAlbumnId(null);
                        RecordVideoActivity.this.kCO.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kCO);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kCH, RecordVideoActivity.this.kCG)));
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
    public void cRQ() {
        this.kCD.cancel();
        this.kCD.setAnimationListener(null);
        this.kCw.clearAnimation();
        this.kCw.setVisibility(8);
        if (this.kCM != null) {
            this.kCM.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRR() {
        cJC();
    }

    private void cJC() {
        if (this.kCE != null) {
            this.kCE.cancel();
        }
        if (this.kCF == null) {
            this.kCF = ObjectAnimator.ofFloat(this.kCN, "alpha", 1.0f, 0.0f);
            this.kCF.setDuration(500L);
            this.kCF.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEn) {
                        RecordVideoActivity.this.kCN.setVisibility(8);
                    }
                }
            });
        }
        this.kCF.start();
    }

    private void cJB() {
        if (this.kCF != null) {
            this.kCF.cancel();
        }
        if (this.kCE == null) {
            this.kCE = ObjectAnimator.ofFloat(this.kCN, "alpha", 0.0f, 1.0f);
            this.kCE.setDuration(500L);
        }
        this.kCN.setVisibility(0);
        this.kCE.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRS() {
        this.kCx.reset();
        if (this.kAK.getStatus() == 1) {
            cJB();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRT() {
        if (this.aGg.getVisibility() != 0) {
            this.kCp.cSa();
            this.kAK.setStatus(8);
            cRD();
            if (this.kAS.kBx != null && this.kAS.kBx.size() > 0) {
                this.aGg.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kCS = 50;
        final int kCT = 1;
        Handler kCU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kCz.V(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cRX();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cRX() {
            this.kCU.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cRX();
            boolean z = RecordVideoActivity.this.kCM == null || TextUtils.isEmpty(RecordVideoActivity.this.kCM.cRC()) || !new File(RecordVideoActivity.this.kCM.cRC()).exists();
            if (RecordVideoActivity.this.kAS.kBx.size() > 1) {
                return com.baidu.tieba.video.meida.h.cQS().a(RecordVideoActivity.this.kAS.kBx, RecordVideoActivity.this.kAS.cRi(), z);
            }
            File file = new File(RecordVideoActivity.this.kAS.kBx.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kAS.cRi());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cQS().a(RecordVideoActivity.this.kAS.kBx, RecordVideoActivity.this.kAS.cRi(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kCp.cSg();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cRE();
                    RecordVideoActivity.this.DK(102);
                    RecordVideoActivity.this.aGg.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cRE();
                RecordVideoActivity.this.DK(102);
                RecordVideoActivity.this.aGg.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aGg.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aP(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kCz.V(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kCp == null || v.isEmpty(this.kCp.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kCp.getChoosedBeautyList()) {
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
        if (this.kCp == null || v.isEmpty(this.kCp.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kCp.getChoosedFilterList()) {
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
        if (this.kCp == null || v.isEmpty(this.kCp.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kCp.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRU() {
        this.kCA.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRV() {
        this.kCA.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRW() {
        if (this.kAK.getStatus() == 1) {
            this.kCN.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kAS != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kAS.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").X("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kCx.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kCx.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kAS.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cy("obj_id", (String) eVar.getValue());
                        if (this.kAK.getStatus() == 1) {
                            anVar.X("obj_type", 1);
                        } else {
                            anVar.X("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kCx.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kCx.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kCM.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kCx.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kCx.setViewChoosed(0, true);
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
            this.kCL = stickerItem;
            this.kCK.Kr(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kAS != null) {
                    this.kAS.setSticker(null);
                    this.kCQ = false;
                }
                if (this.kCp != null) {
                    this.kCp.setDownLoadSticker(null);
                }
                this.kCy.setVisibility(8);
                this.kCx.setViewChoosed(1, false);
                return;
            }
            String Ko = this.kCK.Ko(stickerItem.resource);
            if (!StringUtils.isNull(Ko)) {
                a(stickerItem, Ko);
                if (this.kCp != null) {
                    this.kCp.setDownLoadSticker(null);
                }
            } else {
                if (this.kCp != null) {
                    this.kCp.setDownLoadSticker(stickerItem);
                }
                this.kCK.Kp(stickerItem.resource);
            }
            this.kCx.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kAS != null) {
                this.kAS.setSticker(stickerItem);
                this.kCQ = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kCy.setText(stickerItem.desc);
                this.kCy.setVisibility(0);
                this.kCy.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kCy.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kCy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cS(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kCp.getLayoutParams();
            layoutParams.height = i4;
            this.kCp.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Ka = com.baidu.tieba.video.editvideo.model.a.cPW().Ka(stringExtra);
                if (this.kCM != null && !TextUtils.isEmpty(Ka)) {
                    this.kCM.eK(Ka, stringExtra2);
                    this.kCp.cQX();
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
        if (this.kAK.getStatus() == 8) {
            this.kCp.cRZ();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void tu(boolean z) {
        if (this.kAK != null && (this.kAK.getStatus() == 1 || this.kAK.getStatus() == 3 || this.kAK.getStatus() == 4)) {
            if (!z && this.kCQ) {
                this.kCv.cRu();
                return;
            } else {
                this.kCv.cRv();
                return;
            }
        }
        this.kCv.cRv();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kCM != null) {
                        this.kCM.aWA();
                    }
                    this.kAS.setFilter("origin");
                    this.kCx.setViewChoosed(0, false);
                    this.kCx.setViewChoosed(3, false);
                    this.kCp.DM(1);
                    this.kCx.setViewVisibility(0, 8);
                    this.kCx.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kCx.setViewVisibility(0, 0);
                    this.kCx.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kCp.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().X("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRB() {
        if (this.kAK.getStatus() == 1 && !this.kCp.cSe()) {
            onTabChoosed(1, true);
            this.kCN.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRA() {
        if (this.kAK.getStatus() == 1 && !this.kCp.cSe()) {
            onTabChoosed(2, true);
            this.kCN.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DK(int i) {
        if (this.khL != null) {
            this.khL.aQ(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (this.khL != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.khL.aP(i, str);
        }
    }
}
