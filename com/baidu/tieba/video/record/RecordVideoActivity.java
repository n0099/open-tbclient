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
/* loaded from: classes8.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View aBZ;
    private ImageView fgN;
    private final CustomMessageListener gFp;
    private b kAE;
    private PreviewViewContainer kBA;
    private TextView kBB;
    private VideoEffectButtonLayout kBC;
    private TextView kBD;
    private RoundProgressBar kBE;
    private TextView kBF;
    private AnimatorSet kBG;
    private AnimatorSet kBH;
    private ScaleAnimation kBI;
    private ObjectAnimator kBJ;
    private ObjectAnimator kBK;
    private int kBL;
    private ForumWriteData kBM;
    private boolean kBN;
    private boolean kBO = true;
    private l kBP;
    private StickerItem kBQ;
    protected j kBR;
    private RecordTabLayout kBS;
    private ImageFileInfo kBT;
    private HttpMessageListener kBU;
    private boolean kBV;
    private RecordLayout kBt;
    private VideoControllerLayout kBu;
    private RelativeLayout kBv;
    private ImageView kBw;
    private ImageView kBx;
    private ImageView kBy;
    private com.baidu.tbadk.core.dialog.a kBz;
    private com.baidu.tieba.j.h kgK;
    private String kvn;
    private SelectMusicModel kvr;
    private b.a kyy;
    private i kzP;
    protected h kzX;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kgK = lVar.cfr();
        }
        if (this.kgK != null) {
            this.kgK.ceU();
        }
        this.kyy = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void ev(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kBu != null) {
                        RecordVideoActivity.this.kBu.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kBu != null) {
                    RecordVideoActivity.this.kBu.setHasLocalVideo(true);
                    RecordVideoActivity.this.kBO = false;
                }
            }
        };
        this.kBU = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kBu != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kBu.setStickerItems(list);
                    }
                }
            }
        };
        this.gFp = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cQl() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kzX.kvs);
        videoInfo.setVideoDuration(this.kzP.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kzX.kvs).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kBM == null ? "" : this.kBM.forumName;
        String str2 = this.kBM == null ? "" : this.kBM.forumId;
        int i = this.kBM == null ? -1 : this.kBM.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kBM.writeCallFrom, str, str2, this.kvn, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.kBR != null) {
            this.kBR.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.kgK != null) {
            this.kgK.ceX();
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
        if (this.kzP != null && this.kzP.isRecording()) {
            this.kzP.stopRecord();
        }
        if (this.kvr != null) {
            this.kvr.cancelLoadData();
        }
        if (this.kgK != null) {
            this.kgK.EL("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.ktO));
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
        this.kBL = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kBM = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.kvn = getIntent().getStringExtra("video_title");
        initUI();
        this.kvr = new SelectMusicModel(getPageContext(), this.kBu);
        this.kvr.cOJ();
        this.kBR = new j(this);
        this.kBR.b(this.kvr);
        this.kzP.a(this.kBR);
        registerListener(this.kBU);
        registerListener(this.gFp);
        cQm();
    }

    private void cQm() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cPj() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kyy);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kBt = (RecordLayout) findViewById(R.id.root_layout);
        this.kBt.setListener(this);
        this.kzP = new i(this);
        this.kBu = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kBu.setRecordController(this.kzP);
        this.kBu.setRecordControlListener(this);
        this.kBu.setEffectChoosedListener(this);
        this.kBv = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fgN = (ImageView) findViewById(R.id.close_page);
        this.fgN.setOnClickListener(this);
        this.kBw = (ImageView) findViewById(R.id.flash_switch);
        this.kBw.setOnClickListener(this);
        this.kBx = (ImageView) findViewById(R.id.camera_switch);
        this.kBx.setOnClickListener(this);
        this.kBy = (ImageView) findViewById(R.id.count_down);
        this.kBy.setOnClickListener(this);
        this.kBA = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kzX = new h(this);
        this.kzX.a(this);
        this.kzX.setFaceIdentifyStateListener(this);
        this.kzX.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cQa() {
                if (RecordVideoActivity.this.kBu.cQL()) {
                    RecordVideoActivity.this.kBu.a((m) null);
                }
            }
        });
        this.kBC = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kBC.setListener(this);
        this.kzP.a(this.kBC);
        this.kBC.setViewChoosed(2, true);
        this.kBB = (TextView) findViewById(R.id.tv_count_down);
        this.kBD = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kBB.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kBB.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kBC.setVisibility(8);
        }
        this.aBZ = findViewById(R.id.progress_layout);
        this.kBE = (RoundProgressBar) this.aBZ.findViewById(R.id.video_progress);
        this.kBF = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kBF.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kBF.setLayoutParams(layoutParams);
        this.kBS = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kBS.bg(1, getString(R.string.tab_photo));
        if (this.kBL != 2 && this.kBL != 3) {
            this.kBS.bg(2, getString(R.string.tab_record));
            this.kBS.setListener(this);
            this.kBS.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kBS.setShowIndicator(false);
            this.kBS.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cQn();
    }

    private void cQn() {
        if (com.baidu.tbadk.core.util.g.aDA()) {
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
        this.kzX.onResume();
        this.kAE = this.kzX.cPS();
        if (this.kAE != null) {
            this.kAE.setRecordController(this.kzP);
            this.kBA.setZoomHelper(this.kAE);
        }
        cQo();
        if (this.kBP == null) {
            this.kBP = new l();
            this.kBP.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eA(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kBQ, str2);
                    if (RecordVideoActivity.this.kBu != null) {
                        RecordVideoActivity.this.kBu.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void JG(String str) {
                    if (RecordVideoActivity.this.kBu != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kBu.b(stickerItem);
                        if (RecordVideoActivity.this.kzX != null) {
                            RecordVideoActivity.this.kzX.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kBu != null) {
                        RecordVideoActivity.this.kBu.setDownLoadSticker(null);
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
                public void cNT() {
                    if (RecordVideoActivity.this.kBu != null) {
                        RecordVideoActivity.this.kBu.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kBP.cQF();
        if (this.kBu != null && this.kBO) {
            cPj();
        }
        if (this.kgK != null) {
            this.kgK.EK("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kzX.onPause();
        if (this.kBu != null) {
            if (this.kzP != null && this.kzP.getStatus() == 6) {
                this.kBu.stopRecord();
                cQx();
            }
            if (this.kzP != null && this.kzP.isRecording()) {
                this.kBu.stopRecord();
            }
        }
        if (this.kBR != null) {
            this.kBR.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kzP == null || this.kzP.getStatus() != 7) {
            if (this.kzP != null && this.kzP.getStatus() == 6) {
                if (this.kBu != null) {
                    this.kBu.stopRecord();
                }
                cQx();
            } else if (this.kzP.onBackPressed()) {
                finish();
            } else {
                if (this.kBz == null) {
                    this.kBz = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kBz.jF(R.string.video_quit_confirm);
                    this.kBz.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kBz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kBz.fz(true);
                    this.kBz.b(getPageContext());
                }
                this.kBz.aCp();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kBF.setVisibility(4);
        if (view == this.fgN) {
            onBackPressed();
        } else if (view == this.kBw) {
            if (this.kzP.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kzX.cPV();
            cQo();
        } else if (view == this.kBx) {
            if (this.kzP.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kBx.setOnClickListener(null);
            this.kzX.cPX();
            if (this.kzX.getIsFrontCamera() && this.kzX.cPW()) {
                this.kzX.cPV();
            }
            cQo();
            this.kBx.setOnClickListener(this);
        } else if (view == this.kBy) {
            cQq();
        }
    }

    private void cQo() {
        if (this.kzX.getIsFrontCamera()) {
            this.kBw.setVisibility(8);
        } else {
            this.kBw.setVisibility(0);
        }
        if (this.kzX.cPW()) {
            this.kBw.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kBw.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cQp() {
        return this.kBA;
    }

    public void cQq() {
        this.kBF.setVisibility(4);
        if (this.kzP.getStatus() != 6) {
            this.kzP.setStatus(6);
            cQv();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kBI == null) {
                this.kBI = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kBI.setDuration(500L);
                this.kBI.setRepeatCount(5);
                this.kBI.setRepeatMode(2);
                this.kBI.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kBI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kzP.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kBB.setVisibility(0);
                        RecordVideoActivity.this.kBB.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kBB.setVisibility(8);
                    if (RecordVideoActivity.this.kzP.getStatus() == 6) {
                        RecordVideoActivity.this.kBu.cQI();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kzP.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kBB.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kBB.setText("");
                        }
                    }
                }
            });
            this.kBB.setAnimation(this.kBI);
            this.kBI.startNow();
            this.kBu.cQq();
            if (this.kBR != null) {
                this.kBR.cQk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQr() {
        if (this.kzP.getStatus() == 1) {
            this.kBF.setVisibility(4);
            if (this.kzP.getStatus() != 6) {
                this.kBu.cQr();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQs() {
        this.kBF.setVisibility(4);
        if (this.kzP.getStatus() != 6) {
            this.kBu.cQs();
            if (this.kBu.cQM()) {
                cQm();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQt() {
        this.kBF.setVisibility(4);
        if (this.kzP.getStatus() != 6) {
            this.kBu.cQt();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQu() {
        this.kBF.setVisibility(4);
        if (this.kzP.getStatus() != 6) {
            this.kBu.cQu();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQv() {
        this.kBN = true;
        if (this.kBH != null && this.kBH.isRunning()) {
            this.kBH.cancel();
        }
        if (this.kBG == null) {
            this.kBG = new AnimatorSet();
            this.kBG.playTogether(ObjectAnimator.ofFloat(this.kBv, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kBC, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kBS, "alpha", 1.0f, 0.0f));
            this.kBG.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDs) {
                        RecordVideoActivity.this.kBv.setVisibility(8);
                        RecordVideoActivity.this.kBC.setVisibility(8);
                        RecordVideoActivity.this.kBS.setVisibility(8);
                    }
                }
            });
            this.kBG.setDuration(300L);
        }
        this.kBG.start();
        this.kBC.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQk() {
        if (this.mCurrentTab == 2) {
            if (this.kBN) {
                this.kBN = false;
                if (this.kBR != null) {
                    this.kBR.cQk();
                }
            } else {
                return;
            }
        }
        if (this.kBG != null && this.kBG.isRunning()) {
            this.kBG.cancel();
        }
        if (this.kBH == null) {
            this.kBH = new AnimatorSet();
            this.kBH.playTogether(ObjectAnimator.ofFloat(this.kBv, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kBC, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kBS, "alpha", 0.0f, 1.0f));
            this.kBH.setDuration(300L);
        }
        this.kBv.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kBC.setVisibility(0);
        }
        if (this.kzP.getStatus() == 1) {
            this.kBS.setVisibility(0);
        }
        this.kBH.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQw() {
        if (this.kzX != null) {
            this.kzX.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kzP.setStatus(1);
                    RecordVideoActivity.this.cQk();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kBT != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kBT)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kBT);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kBT = new ImageFileInfo();
                        RecordVideoActivity.this.kBT.setFilePath(str);
                        RecordVideoActivity.this.kBT.setTempFile(true);
                        RecordVideoActivity.this.kBT.setAlbumnId(null);
                        RecordVideoActivity.this.kBT.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kBT);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kBM, RecordVideoActivity.this.kBL)));
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
    public void cQx() {
        this.kBI.cancel();
        this.kBI.setAnimationListener(null);
        this.kBB.clearAnimation();
        this.kBB.setVisibility(8);
        if (this.kBR != null) {
            this.kBR.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQy() {
        cHY();
    }

    private void cHY() {
        if (this.kBJ != null) {
            this.kBJ.cancel();
        }
        if (this.kBK == null) {
            this.kBK = ObjectAnimator.ofFloat(this.kBS, "alpha", 1.0f, 0.0f);
            this.kBK.setDuration(500L);
            this.kBK.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDs) {
                        RecordVideoActivity.this.kBS.setVisibility(8);
                    }
                }
            });
        }
        this.kBK.start();
    }

    private void cHX() {
        if (this.kBK != null) {
            this.kBK.cancel();
        }
        if (this.kBJ == null) {
            this.kBJ = ObjectAnimator.ofFloat(this.kBS, "alpha", 0.0f, 1.0f);
            this.kBJ.setDuration(500L);
        }
        this.kBS.setVisibility(0);
        this.kBJ.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQz() {
        this.kBC.reset();
        if (this.kzP.getStatus() == 1) {
            cHX();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQA() {
        if (this.aBZ.getVisibility() != 0) {
            this.kBu.cQH();
            this.kzP.setStatus(8);
            cQk();
            if (this.kzX.kAC != null && this.kzX.kAC.size() > 0) {
                this.aBZ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kBX = 50;
        final int kBY = 1;
        Handler kBZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kBE.V(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cQE();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cQE() {
            this.kBZ.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cQE();
            boolean z = RecordVideoActivity.this.kBR == null || TextUtils.isEmpty(RecordVideoActivity.this.kBR.cQj()) || !new File(RecordVideoActivity.this.kBR.cQj()).exists();
            if (RecordVideoActivity.this.kzX.kAC.size() > 1) {
                return com.baidu.tieba.video.meida.h.cPz().a(RecordVideoActivity.this.kzX.kAC, RecordVideoActivity.this.kzX.cPP(), z);
            }
            File file = new File(RecordVideoActivity.this.kzX.kAC.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kzX.cPP());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cPz().a(RecordVideoActivity.this.kzX.kAC, RecordVideoActivity.this.kzX.cPP(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kBu.cQN();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cQl();
                    RecordVideoActivity.this.DE(102);
                    RecordVideoActivity.this.aBZ.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cQl();
                RecordVideoActivity.this.DE(102);
                RecordVideoActivity.this.aBZ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aBZ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aP(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kBE.V(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kBu == null || v.isEmpty(this.kBu.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kBu.getChoosedBeautyList()) {
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
        if (this.kBu == null || v.isEmpty(this.kBu.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kBu.getChoosedFilterList()) {
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
        if (this.kBu == null || v.isEmpty(this.kBu.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kBu.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQB() {
        this.kBF.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQC() {
        this.kBF.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQD() {
        if (this.kzP.getStatus() == 1) {
            this.kBS.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kzX != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kzX.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").Z("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kBC.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kBC.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kzX.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cp("obj_id", (String) eVar.getValue());
                        if (this.kzP.getStatus() == 1) {
                            anVar.Z("obj_type", 1);
                        } else {
                            anVar.Z("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kBC.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kBC.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kBR.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kBC.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kBC.setViewChoosed(0, true);
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
            this.kBQ = stickerItem;
            this.kBP.Ke(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kzX != null) {
                    this.kzX.setSticker(null);
                    this.kBV = false;
                }
                if (this.kBu != null) {
                    this.kBu.setDownLoadSticker(null);
                }
                this.kBD.setVisibility(8);
                this.kBC.setViewChoosed(1, false);
                return;
            }
            String Kb = this.kBP.Kb(stickerItem.resource);
            if (!StringUtils.isNull(Kb)) {
                a(stickerItem, Kb);
                if (this.kBu != null) {
                    this.kBu.setDownLoadSticker(null);
                }
            } else {
                if (this.kBu != null) {
                    this.kBu.setDownLoadSticker(stickerItem);
                }
                this.kBP.Kc(stickerItem.resource);
            }
            this.kBC.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kzX != null) {
                this.kzX.setSticker(stickerItem);
                this.kBV = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kBD.setText(stickerItem.desc);
                this.kBD.setVisibility(0);
                this.kBD.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kBD.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kBD.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cP(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kBu.getLayoutParams();
            layoutParams.height = i4;
            this.kBu.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String JN = com.baidu.tieba.video.editvideo.model.a.cOD().JN(stringExtra);
                if (this.kBR != null && !TextUtils.isEmpty(JN)) {
                    this.kBR.eB(JN, stringExtra2);
                    this.kBu.cPE();
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
        if (this.kzP.getStatus() == 8) {
            this.kBu.cQG();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void tq(boolean z) {
        if (this.kzP != null && (this.kzP.getStatus() == 1 || this.kzP.getStatus() == 3 || this.kzP.getStatus() == 4)) {
            if (!z && this.kBV) {
                this.kBA.cQb();
                return;
            } else {
                this.kBA.cQc();
                return;
            }
        }
        this.kBA.cQc();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kBR != null) {
                        this.kBR.aUk();
                    }
                    this.kzX.setFilter("origin");
                    this.kBC.setViewChoosed(0, false);
                    this.kBC.setViewChoosed(3, false);
                    this.kBu.DG(1);
                    this.kBC.setViewVisibility(0, 8);
                    this.kBC.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kBC.setViewVisibility(0, 0);
                    this.kBC.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kBu.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().Z("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cQi() {
        if (this.kzP.getStatus() == 1 && !this.kBu.cQL()) {
            onTabChoosed(1, true);
            this.kBS.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cQh() {
        if (this.kzP.getStatus() == 1 && !this.kBu.cQL()) {
            onTabChoosed(2, true);
            this.kBS.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(int i) {
        if (this.kgK != null) {
            this.kgK.aQ(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (this.kgK != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.kgK.aP(i, str);
        }
    }
}
