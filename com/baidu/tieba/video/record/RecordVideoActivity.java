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
    private View aGi;
    private ImageView fkh;
    private final CustomMessageListener gHC;
    private i kAY;
    private b kBN;
    protected h kBg;
    private RecordLayout kCC;
    private VideoControllerLayout kCD;
    private RelativeLayout kCE;
    private ImageView kCF;
    private ImageView kCG;
    private ImageView kCH;
    private com.baidu.tbadk.core.dialog.a kCI;
    private PreviewViewContainer kCJ;
    private TextView kCK;
    private VideoEffectButtonLayout kCL;
    private TextView kCM;
    private RoundProgressBar kCN;
    private TextView kCO;
    private AnimatorSet kCP;
    private AnimatorSet kCQ;
    private ScaleAnimation kCR;
    private ObjectAnimator kCS;
    private ObjectAnimator kCT;
    private int kCU;
    private ForumWriteData kCV;
    private boolean kCW;
    private boolean kCX = true;
    private l kCY;
    private StickerItem kCZ;
    protected j kDa;
    private RecordTabLayout kDb;
    private ImageFileInfo kDc;
    private HttpMessageListener kDd;
    private boolean kDe;
    private com.baidu.tieba.k.h khZ;
    private SelectMusicModel kwC;
    private String kwy;
    private b.a kzH;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.khZ = lVar.cgZ();
        }
        if (this.khZ != null) {
            this.khZ.cgB();
        }
        this.kzH = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eq(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kCD != null) {
                        RecordVideoActivity.this.kCD.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kCD != null) {
                    RecordVideoActivity.this.kCD.setHasLocalVideo(true);
                    RecordVideoActivity.this.kCX = false;
                }
            }
        };
        this.kDd = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kCD != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kCD.setStickerItems(list);
                    }
                }
            }
        };
        this.gHC = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cRH() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kBg.kwD);
        videoInfo.setVideoDuration(this.kAY.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kBg.kwD).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kCV == null ? "" : this.kCV.forumName;
        String str2 = this.kCV == null ? "" : this.kCV.forumId;
        int i = this.kCV == null ? -1 : this.kCV.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kCV.writeCallFrom, str, str2, this.kwy, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.kDa != null) {
            this.kDa.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.khZ != null) {
            this.khZ.cgE();
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
        if (this.kAY != null && this.kAY.isRecording()) {
            this.kAY.stopRecord();
        }
        if (this.kwC != null) {
            this.kwC.cancelLoadData();
        }
        if (this.khZ != null) {
            this.khZ.Fc("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kuZ));
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
        this.kCU = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kCV = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.kwy = getIntent().getStringExtra("video_title");
        initUI();
        this.kwC = new SelectMusicModel(getPageContext(), this.kCD);
        this.kwC.cQf();
        this.kDa = new j(this);
        this.kDa.b(this.kwC);
        this.kAY.a(this.kDa);
        registerListener(this.kDd);
        registerListener(this.gHC);
        cRI();
    }

    private void cRI() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cQF() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kzH);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kCC = (RecordLayout) findViewById(R.id.root_layout);
        this.kCC.setListener(this);
        this.kAY = new i(this);
        this.kCD = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kCD.setRecordController(this.kAY);
        this.kCD.setRecordControlListener(this);
        this.kCD.setEffectChoosedListener(this);
        this.kCE = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fkh = (ImageView) findViewById(R.id.close_page);
        this.fkh.setOnClickListener(this);
        this.kCF = (ImageView) findViewById(R.id.flash_switch);
        this.kCF.setOnClickListener(this);
        this.kCG = (ImageView) findViewById(R.id.camera_switch);
        this.kCG.setOnClickListener(this);
        this.kCH = (ImageView) findViewById(R.id.count_down);
        this.kCH.setOnClickListener(this);
        this.kCJ = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kBg = new h(this);
        this.kBg.a(this);
        this.kBg.setFaceIdentifyStateListener(this);
        this.kBg.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cRw() {
                if (RecordVideoActivity.this.kCD.cSh()) {
                    RecordVideoActivity.this.kCD.a((m) null);
                }
            }
        });
        this.kCL = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kCL.setListener(this);
        this.kAY.a(this.kCL);
        this.kCL.setViewChoosed(2, true);
        this.kCK = (TextView) findViewById(R.id.tv_count_down);
        this.kCM = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kCK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kCK.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kCL.setVisibility(8);
        }
        this.aGi = findViewById(R.id.progress_layout);
        this.kCN = (RoundProgressBar) this.aGi.findViewById(R.id.video_progress);
        this.kCO = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kCO.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kCO.setLayoutParams(layoutParams);
        this.kDb = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kDb.bf(1, getString(R.string.tab_photo));
        if (this.kCU != 2 && this.kCU != 3) {
            this.kDb.bf(2, getString(R.string.tab_record));
            this.kDb.setListener(this);
            this.kDb.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kDb.setShowIndicator(false);
            this.kDb.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cRJ();
    }

    private void cRJ() {
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
        this.kBg.onResume();
        this.kBN = this.kBg.cRo();
        if (this.kBN != null) {
            this.kBN.setRecordController(this.kAY);
            this.kCJ.setZoomHelper(this.kBN);
        }
        cRK();
        if (this.kCY == null) {
            this.kCY = new l();
            this.kCY.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eJ(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kCZ, str2);
                    if (RecordVideoActivity.this.kCD != null) {
                        RecordVideoActivity.this.kCD.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void JU(String str) {
                    if (RecordVideoActivity.this.kCD != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kCD.b(stickerItem);
                        if (RecordVideoActivity.this.kBg != null) {
                            RecordVideoActivity.this.kBg.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kCD != null) {
                        RecordVideoActivity.this.kCD.setDownLoadSticker(null);
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
                public void cPr() {
                    if (RecordVideoActivity.this.kCD != null) {
                        RecordVideoActivity.this.kCD.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kCY.cSb();
        if (this.kCD != null && this.kCX) {
            cQF();
        }
        if (this.khZ != null) {
            this.khZ.Fb("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kBg.onPause();
        if (this.kCD != null) {
            if (this.kAY != null && this.kAY.getStatus() == 6) {
                this.kCD.stopRecord();
                cRT();
            }
            if (this.kAY != null && this.kAY.isRecording()) {
                this.kCD.stopRecord();
            }
        }
        if (this.kDa != null) {
            this.kDa.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kAY == null || this.kAY.getStatus() != 7) {
            if (this.kAY != null && this.kAY.getStatus() == 6) {
                if (this.kCD != null) {
                    this.kCD.stopRecord();
                }
                cRT();
            } else if (this.kAY.onBackPressed()) {
                finish();
            } else {
                if (this.kCI == null) {
                    this.kCI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kCI.jW(R.string.video_quit_confirm);
                    this.kCI.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kCI.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kCI.fG(true);
                    this.kCI.b(getPageContext());
                }
                this.kCI.aEC();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kCO.setVisibility(4);
        if (view == this.fkh) {
            onBackPressed();
        } else if (view == this.kCF) {
            if (this.kAY.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kBg.cRr();
            cRK();
        } else if (view == this.kCG) {
            if (this.kAY.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kCG.setOnClickListener(null);
            this.kBg.cRt();
            if (this.kBg.getIsFrontCamera() && this.kBg.cRs()) {
                this.kBg.cRr();
            }
            cRK();
            this.kCG.setOnClickListener(this);
        } else if (view == this.kCH) {
            cRM();
        }
    }

    private void cRK() {
        if (this.kBg.getIsFrontCamera()) {
            this.kCF.setVisibility(8);
        } else {
            this.kCF.setVisibility(0);
        }
        if (this.kBg.cRs()) {
            this.kCF.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kCF.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cRL() {
        return this.kCJ;
    }

    public void cRM() {
        this.kCO.setVisibility(4);
        if (this.kAY.getStatus() != 6) {
            this.kAY.setStatus(6);
            cRR();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kCR == null) {
                this.kCR = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kCR.setDuration(500L);
                this.kCR.setRepeatCount(5);
                this.kCR.setRepeatMode(2);
                this.kCR.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kCR.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kAY.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kCK.setVisibility(0);
                        RecordVideoActivity.this.kCK.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kCK.setVisibility(8);
                    if (RecordVideoActivity.this.kAY.getStatus() == 6) {
                        RecordVideoActivity.this.kCD.cSe();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kAY.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kCK.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kCK.setText("");
                        }
                    }
                }
            });
            this.kCK.setAnimation(this.kCR);
            this.kCR.startNow();
            this.kCD.cRM();
            if (this.kDa != null) {
                this.kDa.cRG();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRN() {
        if (this.kAY.getStatus() == 1) {
            this.kCO.setVisibility(4);
            if (this.kAY.getStatus() != 6) {
                this.kCD.cRN();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRO() {
        this.kCO.setVisibility(4);
        if (this.kAY.getStatus() != 6) {
            this.kCD.cRO();
            if (this.kCD.cSi()) {
                cRI();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRP() {
        this.kCO.setVisibility(4);
        if (this.kAY.getStatus() != 6) {
            this.kCD.cRP();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cRQ() {
        this.kCO.setVisibility(4);
        if (this.kAY.getStatus() != 6) {
            this.kCD.cRQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRR() {
        this.kCW = true;
        if (this.kCQ != null && this.kCQ.isRunning()) {
            this.kCQ.cancel();
        }
        if (this.kCP == null) {
            this.kCP = new AnimatorSet();
            this.kCP.playTogether(ObjectAnimator.ofFloat(this.kCE, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kCL, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kDb, "alpha", 1.0f, 0.0f));
            this.kCP.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEB) {
                        RecordVideoActivity.this.kCE.setVisibility(8);
                        RecordVideoActivity.this.kCL.setVisibility(8);
                        RecordVideoActivity.this.kDb.setVisibility(8);
                    }
                }
            });
            this.kCP.setDuration(300L);
        }
        this.kCP.start();
        this.kCL.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRG() {
        if (this.mCurrentTab == 2) {
            if (this.kCW) {
                this.kCW = false;
                if (this.kDa != null) {
                    this.kDa.cRG();
                }
            } else {
                return;
            }
        }
        if (this.kCP != null && this.kCP.isRunning()) {
            this.kCP.cancel();
        }
        if (this.kCQ == null) {
            this.kCQ = new AnimatorSet();
            this.kCQ.playTogether(ObjectAnimator.ofFloat(this.kCE, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kCL, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kDb, "alpha", 0.0f, 1.0f));
            this.kCQ.setDuration(300L);
        }
        this.kCE.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kCL.setVisibility(0);
        }
        if (this.kAY.getStatus() == 1) {
            this.kDb.setVisibility(0);
        }
        this.kCQ.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRS() {
        if (this.kBg != null) {
            this.kBg.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kAY.setStatus(1);
                    RecordVideoActivity.this.cRG();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kDc != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kDc)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kDc);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kDc = new ImageFileInfo();
                        RecordVideoActivity.this.kDc.setFilePath(str);
                        RecordVideoActivity.this.kDc.setTempFile(true);
                        RecordVideoActivity.this.kDc.setAlbumnId(null);
                        RecordVideoActivity.this.kDc.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kDc);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kCV, RecordVideoActivity.this.kCU)));
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
    public void cRT() {
        this.kCR.cancel();
        this.kCR.setAnimationListener(null);
        this.kCK.clearAnimation();
        this.kCK.setVisibility(8);
        if (this.kDa != null) {
            this.kDa.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRU() {
        cJF();
    }

    private void cJF() {
        if (this.kCS != null) {
            this.kCS.cancel();
        }
        if (this.kCT == null) {
            this.kCT = ObjectAnimator.ofFloat(this.kDb, "alpha", 1.0f, 0.0f);
            this.kCT.setDuration(500L);
            this.kCT.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kEB) {
                        RecordVideoActivity.this.kDb.setVisibility(8);
                    }
                }
            });
        }
        this.kCT.start();
    }

    private void cJE() {
        if (this.kCT != null) {
            this.kCT.cancel();
        }
        if (this.kCS == null) {
            this.kCS = ObjectAnimator.ofFloat(this.kDb, "alpha", 0.0f, 1.0f);
            this.kCS.setDuration(500L);
        }
        this.kDb.setVisibility(0);
        this.kCS.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRV() {
        this.kCL.reset();
        if (this.kAY.getStatus() == 1) {
            cJE();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRW() {
        if (this.aGi.getVisibility() != 0) {
            this.kCD.cSd();
            this.kAY.setStatus(8);
            cRG();
            if (this.kBg.kBL != null && this.kBg.kBL.size() > 0) {
                this.aGi.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kDg = 50;
        final int kDh = 1;
        Handler kDi = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kCN.V(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cSa();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cSa() {
            this.kDi.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cSa();
            boolean z = RecordVideoActivity.this.kDa == null || TextUtils.isEmpty(RecordVideoActivity.this.kDa.cRF()) || !new File(RecordVideoActivity.this.kDa.cRF()).exists();
            if (RecordVideoActivity.this.kBg.kBL.size() > 1) {
                return com.baidu.tieba.video.meida.h.cQV().a(RecordVideoActivity.this.kBg.kBL, RecordVideoActivity.this.kBg.cRl(), z);
            }
            File file = new File(RecordVideoActivity.this.kBg.kBL.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kBg.cRl());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cQV().a(RecordVideoActivity.this.kBg.kBL, RecordVideoActivity.this.kBg.cRl(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kCD.cSj();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cRH();
                    RecordVideoActivity.this.DK(102);
                    RecordVideoActivity.this.aGi.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cRH();
                RecordVideoActivity.this.DK(102);
                RecordVideoActivity.this.aGi.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aGi.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aP(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kCN.V(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kCD == null || v.isEmpty(this.kCD.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kCD.getChoosedBeautyList()) {
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
        if (this.kCD == null || v.isEmpty(this.kCD.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kCD.getChoosedFilterList()) {
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
        if (this.kCD == null || v.isEmpty(this.kCD.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kCD.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRX() {
        this.kCO.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRY() {
        this.kCO.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cRZ() {
        if (this.kAY.getStatus() == 1) {
            this.kDb.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kBg != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kBg.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").X("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kCL.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kCL.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kBg.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cy("obj_id", (String) eVar.getValue());
                        if (this.kAY.getStatus() == 1) {
                            anVar.X("obj_type", 1);
                        } else {
                            anVar.X("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kCL.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kCL.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kDa.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kCL.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kCL.setViewChoosed(0, true);
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
            this.kCZ = stickerItem;
            this.kCY.Ks(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kBg != null) {
                    this.kBg.setSticker(null);
                    this.kDe = false;
                }
                if (this.kCD != null) {
                    this.kCD.setDownLoadSticker(null);
                }
                this.kCM.setVisibility(8);
                this.kCL.setViewChoosed(1, false);
                return;
            }
            String Kp = this.kCY.Kp(stickerItem.resource);
            if (!StringUtils.isNull(Kp)) {
                a(stickerItem, Kp);
                if (this.kCD != null) {
                    this.kCD.setDownLoadSticker(null);
                }
            } else {
                if (this.kCD != null) {
                    this.kCD.setDownLoadSticker(stickerItem);
                }
                this.kCY.Kq(stickerItem.resource);
            }
            this.kCL.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kBg != null) {
                this.kBg.setSticker(stickerItem);
                this.kDe = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kCM.setText(stickerItem.desc);
                this.kCM.setVisibility(0);
                this.kCM.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kCM.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kCM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cS(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kCD.getLayoutParams();
            layoutParams.height = i4;
            this.kCD.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Kb = com.baidu.tieba.video.editvideo.model.a.cPZ().Kb(stringExtra);
                if (this.kDa != null && !TextUtils.isEmpty(Kb)) {
                    this.kDa.eK(Kb, stringExtra2);
                    this.kCD.cRa();
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
        if (this.kAY.getStatus() == 8) {
            this.kCD.cSc();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void tu(boolean z) {
        if (this.kAY != null && (this.kAY.getStatus() == 1 || this.kAY.getStatus() == 3 || this.kAY.getStatus() == 4)) {
            if (!z && this.kDe) {
                this.kCJ.cRx();
                return;
            } else {
                this.kCJ.cRy();
                return;
            }
        }
        this.kCJ.cRy();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kDa != null) {
                        this.kDa.aWD();
                    }
                    this.kBg.setFilter("origin");
                    this.kCL.setViewChoosed(0, false);
                    this.kCL.setViewChoosed(3, false);
                    this.kCD.DM(1);
                    this.kCL.setViewVisibility(0, 8);
                    this.kCL.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kCL.setViewVisibility(0, 0);
                    this.kCL.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kCD.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().X("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRE() {
        if (this.kAY.getStatus() == 1 && !this.kCD.cSh()) {
            onTabChoosed(1, true);
            this.kDb.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cRD() {
        if (this.kAY.getStatus() == 1 && !this.kCD.cSh()) {
            onTabChoosed(2, true);
            this.kDb.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DK(int i) {
        if (this.khZ != null) {
            this.khZ.aQ(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (this.khZ != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.khZ.aP(i, str);
        }
    }
}
