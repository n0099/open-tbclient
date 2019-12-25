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
/* loaded from: classes7.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View aBh;
    private ImageView fdH;
    private final CustomMessageListener gCa;
    private com.baidu.tieba.j.h kdc;
    private String krF;
    private SelectMusicModel krJ;
    private b.a kuQ;
    private b kwX;
    private i kwi;
    protected h kwq;
    private RecordLayout kxM;
    private VideoControllerLayout kxN;
    private RelativeLayout kxO;
    private ImageView kxP;
    private ImageView kxQ;
    private ImageView kxR;
    private com.baidu.tbadk.core.dialog.a kxS;
    private PreviewViewContainer kxT;
    private TextView kxU;
    private VideoEffectButtonLayout kxV;
    private TextView kxW;
    private RoundProgressBar kxX;
    private TextView kxY;
    private AnimatorSet kxZ;
    private AnimatorSet kya;
    private ScaleAnimation kyb;
    private ObjectAnimator kyc;
    private ObjectAnimator kyd;
    private int kye;
    private ForumWriteData kyf;
    private boolean kyg;
    private boolean kyh = true;
    private l kyi;
    private StickerItem kyj;
    protected j kyk;
    private RecordTabLayout kyl;
    private ImageFileInfo kym;
    private HttpMessageListener kyn;
    private boolean kyo;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kdc = lVar.cei();
        }
        if (this.kdc != null) {
            this.kdc.cdL();
        }
        this.kuQ = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void ev(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kxN != null) {
                        RecordVideoActivity.this.kxN.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kxN != null) {
                    RecordVideoActivity.this.kxN.setHasLocalVideo(true);
                    RecordVideoActivity.this.kyh = false;
                }
            }
        };
        this.kyn = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kxN != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kxN.setStickerItems(list);
                    }
                }
            }
        };
        this.gCa = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cPg() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kwq.krK);
        videoInfo.setVideoDuration(this.kwi.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kwq.krK).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kyf == null ? "" : this.kyf.forumName;
        String str2 = this.kyf == null ? "" : this.kyf.forumId;
        int i = this.kyf == null ? -1 : this.kyf.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kyf.writeCallFrom, str, str2, this.krF, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.kyk != null) {
            this.kyk.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.kdc != null) {
            this.kdc.cdO();
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
        if (this.kwi != null && this.kwi.isRecording()) {
            this.kwi.stopRecord();
        }
        if (this.krJ != null) {
            this.krJ.cancelLoadData();
        }
        if (this.kdc != null) {
            this.kdc.EB("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.kqg));
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
        this.kye = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kyf = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.krF = getIntent().getStringExtra("video_title");
        initUI();
        this.krJ = new SelectMusicModel(getPageContext(), this.kxN);
        this.krJ.cNC();
        this.kyk = new j(this);
        this.kyk.b(this.krJ);
        this.kwi.a(this.kyk);
        registerListener(this.kyn);
        registerListener(this.gCa);
        cPh();
    }

    private void cPh() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cOe() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kuQ);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kxM = (RecordLayout) findViewById(R.id.root_layout);
        this.kxM.setListener(this);
        this.kwi = new i(this);
        this.kxN = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kxN.setRecordController(this.kwi);
        this.kxN.setRecordControlListener(this);
        this.kxN.setEffectChoosedListener(this);
        this.kxO = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fdH = (ImageView) findViewById(R.id.close_page);
        this.fdH.setOnClickListener(this);
        this.kxP = (ImageView) findViewById(R.id.flash_switch);
        this.kxP.setOnClickListener(this);
        this.kxQ = (ImageView) findViewById(R.id.camera_switch);
        this.kxQ.setOnClickListener(this);
        this.kxR = (ImageView) findViewById(R.id.count_down);
        this.kxR.setOnClickListener(this);
        this.kxT = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kwq = new h(this);
        this.kwq.a(this);
        this.kwq.setFaceIdentifyStateListener(this);
        this.kwq.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cOV() {
                if (RecordVideoActivity.this.kxN.cPG()) {
                    RecordVideoActivity.this.kxN.a((m) null);
                }
            }
        });
        this.kxV = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kxV.setListener(this);
        this.kwi.a(this.kxV);
        this.kxV.setViewChoosed(2, true);
        this.kxU = (TextView) findViewById(R.id.tv_count_down);
        this.kxW = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kxU.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kxU.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kxV.setVisibility(8);
        }
        this.aBh = findViewById(R.id.progress_layout);
        this.kxX = (RoundProgressBar) this.aBh.findViewById(R.id.video_progress);
        this.kxY = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kxY.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kxY.setLayoutParams(layoutParams);
        this.kyl = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kyl.ba(1, getString(R.string.tab_photo));
        if (this.kye != 2 && this.kye != 3) {
            this.kyl.ba(2, getString(R.string.tab_record));
            this.kyl.setListener(this);
            this.kyl.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kyl.setShowIndicator(false);
            this.kyl.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cPi();
    }

    private void cPi() {
        if (com.baidu.tbadk.core.util.g.aDh()) {
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
        this.kwq.onResume();
        this.kwX = this.kwq.cON();
        if (this.kwX != null) {
            this.kwX.setRecordController(this.kwi);
            this.kxT.setZoomHelper(this.kwX);
        }
        cPj();
        if (this.kyi == null) {
            this.kyi = new l();
            this.kyi.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ey(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kyj, str2);
                    if (RecordVideoActivity.this.kxN != null) {
                        RecordVideoActivity.this.kxN.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Jw(String str) {
                    if (RecordVideoActivity.this.kxN != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kxN.b(stickerItem);
                        if (RecordVideoActivity.this.kwq != null) {
                            RecordVideoActivity.this.kwq.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kxN != null) {
                        RecordVideoActivity.this.kxN.setDownLoadSticker(null);
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
                    recordVideoActivity.aJ(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void cMM() {
                    if (RecordVideoActivity.this.kxN != null) {
                        RecordVideoActivity.this.kxN.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kyi.cPA();
        if (this.kxN != null && this.kyh) {
            cOe();
        }
        if (this.kdc != null) {
            this.kdc.EA("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kwq.onPause();
        if (this.kxN != null) {
            if (this.kwi != null && this.kwi.getStatus() == 6) {
                this.kxN.stopRecord();
                cPs();
            }
            if (this.kwi != null && this.kwi.isRecording()) {
                this.kxN.stopRecord();
            }
        }
        if (this.kyk != null) {
            this.kyk.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kwi == null || this.kwi.getStatus() != 7) {
            if (this.kwi != null && this.kwi.getStatus() == 6) {
                if (this.kxN != null) {
                    this.kxN.stopRecord();
                }
                cPs();
            } else if (this.kwi.onBackPressed()) {
                finish();
            } else {
                if (this.kxS == null) {
                    this.kxS = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kxS.jF(R.string.video_quit_confirm);
                    this.kxS.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kxS.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kxS.fu(true);
                    this.kxS.b(getPageContext());
                }
                this.kxS.aBW();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kxY.setVisibility(4);
        if (view == this.fdH) {
            onBackPressed();
        } else if (view == this.kxP) {
            if (this.kwi.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kwq.cOQ();
            cPj();
        } else if (view == this.kxQ) {
            if (this.kwi.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kxQ.setOnClickListener(null);
            this.kwq.cOS();
            if (this.kwq.getIsFrontCamera() && this.kwq.cOR()) {
                this.kwq.cOQ();
            }
            cPj();
            this.kxQ.setOnClickListener(this);
        } else if (view == this.kxR) {
            cPl();
        }
    }

    private void cPj() {
        if (this.kwq.getIsFrontCamera()) {
            this.kxP.setVisibility(8);
        } else {
            this.kxP.setVisibility(0);
        }
        if (this.kwq.cOR()) {
            this.kxP.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kxP.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cPk() {
        return this.kxT;
    }

    public void cPl() {
        this.kxY.setVisibility(4);
        if (this.kwi.getStatus() != 6) {
            this.kwi.setStatus(6);
            cPq();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kyb == null) {
                this.kyb = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kyb.setDuration(500L);
                this.kyb.setRepeatCount(5);
                this.kyb.setRepeatMode(2);
                this.kyb.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kyb.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kwi.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kxU.setVisibility(0);
                        RecordVideoActivity.this.kxU.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kxU.setVisibility(8);
                    if (RecordVideoActivity.this.kwi.getStatus() == 6) {
                        RecordVideoActivity.this.kxN.cPD();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kwi.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kxU.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kxU.setText("");
                        }
                    }
                }
            });
            this.kxU.setAnimation(this.kyb);
            this.kyb.startNow();
            this.kxN.cPl();
            if (this.kyk != null) {
                this.kyk.cPf();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPm() {
        if (this.kwi.getStatus() == 1) {
            this.kxY.setVisibility(4);
            if (this.kwi.getStatus() != 6) {
                this.kxN.cPm();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPn() {
        this.kxY.setVisibility(4);
        if (this.kwi.getStatus() != 6) {
            this.kxN.cPn();
            if (this.kxN.cPH()) {
                cPh();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPo() {
        this.kxY.setVisibility(4);
        if (this.kwi.getStatus() != 6) {
            this.kxN.cPo();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cPp() {
        this.kxY.setVisibility(4);
        if (this.kwi.getStatus() != 6) {
            this.kxN.cPp();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPq() {
        this.kyg = true;
        if (this.kya != null && this.kya.isRunning()) {
            this.kya.cancel();
        }
        if (this.kxZ == null) {
            this.kxZ = new AnimatorSet();
            this.kxZ.playTogether(ObjectAnimator.ofFloat(this.kxO, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kxV, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kyl, "alpha", 1.0f, 0.0f));
            this.kxZ.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kzL) {
                        RecordVideoActivity.this.kxO.setVisibility(8);
                        RecordVideoActivity.this.kxV.setVisibility(8);
                        RecordVideoActivity.this.kyl.setVisibility(8);
                    }
                }
            });
            this.kxZ.setDuration(300L);
        }
        this.kxZ.start();
        this.kxV.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPf() {
        if (this.mCurrentTab == 2) {
            if (this.kyg) {
                this.kyg = false;
                if (this.kyk != null) {
                    this.kyk.cPf();
                }
            } else {
                return;
            }
        }
        if (this.kxZ != null && this.kxZ.isRunning()) {
            this.kxZ.cancel();
        }
        if (this.kya == null) {
            this.kya = new AnimatorSet();
            this.kya.playTogether(ObjectAnimator.ofFloat(this.kxO, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kxV, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kyl, "alpha", 0.0f, 1.0f));
            this.kya.setDuration(300L);
        }
        this.kxO.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kxV.setVisibility(0);
        }
        if (this.kwi.getStatus() == 1) {
            this.kyl.setVisibility(0);
        }
        this.kya.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPr() {
        if (this.kwq != null) {
            this.kwq.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kwi.setStatus(1);
                    RecordVideoActivity.this.cPf();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kym != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kym)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kym);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kym = new ImageFileInfo();
                        RecordVideoActivity.this.kym.setFilePath(str);
                        RecordVideoActivity.this.kym.setTempFile(true);
                        RecordVideoActivity.this.kym.setAlbumnId(null);
                        RecordVideoActivity.this.kym.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kym);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kyf, RecordVideoActivity.this.kye)));
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
    public void cPs() {
        this.kyb.cancel();
        this.kyb.setAnimationListener(null);
        this.kxU.clearAnimation();
        this.kxU.setVisibility(8);
        if (this.kyk != null) {
            this.kyk.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPt() {
        cGS();
    }

    private void cGS() {
        if (this.kyc != null) {
            this.kyc.cancel();
        }
        if (this.kyd == null) {
            this.kyd = ObjectAnimator.ofFloat(this.kyl, "alpha", 1.0f, 0.0f);
            this.kyd.setDuration(500L);
            this.kyd.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kzL) {
                        RecordVideoActivity.this.kyl.setVisibility(8);
                    }
                }
            });
        }
        this.kyd.start();
    }

    private void cGR() {
        if (this.kyd != null) {
            this.kyd.cancel();
        }
        if (this.kyc == null) {
            this.kyc = ObjectAnimator.ofFloat(this.kyl, "alpha", 0.0f, 1.0f);
            this.kyc.setDuration(500L);
        }
        this.kyl.setVisibility(0);
        this.kyc.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPu() {
        this.kxV.reset();
        if (this.kwi.getStatus() == 1) {
            cGR();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPv() {
        if (this.aBh.getVisibility() != 0) {
            this.kxN.cPC();
            this.kwi.setStatus(8);
            cPf();
            if (this.kwq.kwV != null && this.kwq.kwV.size() > 0) {
                this.aBh.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kyq = 50;
        final int kyr = 1;
        Handler kys = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kxX.W(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cPz();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cPz() {
            this.kys.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cPz();
            boolean z = RecordVideoActivity.this.kyk == null || TextUtils.isEmpty(RecordVideoActivity.this.kyk.cPe()) || !new File(RecordVideoActivity.this.kyk.cPe()).exists();
            if (RecordVideoActivity.this.kwq.kwV.size() > 1) {
                return com.baidu.tieba.video.meida.h.cOu().a(RecordVideoActivity.this.kwq.kwV, RecordVideoActivity.this.kwq.cOK(), z);
            }
            File file = new File(RecordVideoActivity.this.kwq.kwV.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kwq.cOK());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cOu().a(RecordVideoActivity.this.kwq.kwV, RecordVideoActivity.this.kwq.cOK(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kxN.cPI();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cPg();
                    RecordVideoActivity.this.Dy(102);
                    RecordVideoActivity.this.aBh.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cPg();
                RecordVideoActivity.this.Dy(102);
                RecordVideoActivity.this.aBh.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aBh.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aJ(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kxX.W(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kxN == null || v.isEmpty(this.kxN.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kxN.getChoosedBeautyList()) {
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
        if (this.kxN == null || v.isEmpty(this.kxN.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kxN.getChoosedFilterList()) {
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
        if (this.kxN == null || v.isEmpty(this.kxN.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kxN.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPw() {
        this.kxY.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPx() {
        this.kxY.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cPy() {
        if (this.kwi.getStatus() == 1) {
            this.kyl.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kwq != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kwq.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").Z("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kxV.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kxV.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kwq.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cp("obj_id", (String) eVar.getValue());
                        if (this.kwi.getStatus() == 1) {
                            anVar.Z("obj_type", 1);
                        } else {
                            anVar.Z("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kxV.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kxV.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kyk.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kxV.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kxV.setViewChoosed(0, true);
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
            this.kyj = stickerItem;
            this.kyi.JU(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kwq != null) {
                    this.kwq.setSticker(null);
                    this.kyo = false;
                }
                if (this.kxN != null) {
                    this.kxN.setDownLoadSticker(null);
                }
                this.kxW.setVisibility(8);
                this.kxV.setViewChoosed(1, false);
                return;
            }
            String JR = this.kyi.JR(stickerItem.resource);
            if (!StringUtils.isNull(JR)) {
                a(stickerItem, JR);
                if (this.kxN != null) {
                    this.kxN.setDownLoadSticker(null);
                }
            } else {
                if (this.kxN != null) {
                    this.kxN.setDownLoadSticker(stickerItem);
                }
                this.kyi.JS(stickerItem.resource);
            }
            this.kxV.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kwq != null) {
                this.kwq.setSticker(stickerItem);
                this.kyo = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kxW.setText(stickerItem.desc);
                this.kxW.setVisibility(0);
                this.kxW.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kxW.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kxW.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cQ(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kxN.getLayoutParams();
            layoutParams.height = i4;
            this.kxN.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String JD = com.baidu.tieba.video.editvideo.model.a.cNw().JD(stringExtra);
                if (this.kyk != null && !TextUtils.isEmpty(JD)) {
                    this.kyk.ez(JD, stringExtra2);
                    this.kxN.cOz();
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
        if (this.kwi.getStatus() == 8) {
            this.kxN.cPB();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void te(boolean z) {
        if (this.kwi != null && (this.kwi.getStatus() == 1 || this.kwi.getStatus() == 3 || this.kwi.getStatus() == 4)) {
            if (!z && this.kyo) {
                this.kxT.cOW();
                return;
            } else {
                this.kxT.cOX();
                return;
            }
        }
        this.kxT.cOX();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kyk != null) {
                        this.kyk.aTQ();
                    }
                    this.kwq.setFilter("origin");
                    this.kxV.setViewChoosed(0, false);
                    this.kxV.setViewChoosed(3, false);
                    this.kxN.DA(1);
                    this.kxV.setViewVisibility(0, 8);
                    this.kxV.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kxV.setViewVisibility(0, 0);
                    this.kxV.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kxN.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().Z("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cPd() {
        if (this.kwi.getStatus() == 1 && !this.kxN.cPG()) {
            onTabChoosed(1, true);
            this.kyl.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cPc() {
        if (this.kwi.getStatus() == 1 && !this.kxN.cPG()) {
            onTabChoosed(2, true);
            this.kyl.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dy(int i) {
        if (this.kdc != null) {
            this.kdc.aK(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, String str) {
        if (this.kdc != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.kdc.aJ(i, str);
        }
    }
}
