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
    private b kAz;
    private TextView kBA;
    private AnimatorSet kBB;
    private AnimatorSet kBC;
    private ScaleAnimation kBD;
    private ObjectAnimator kBE;
    private ObjectAnimator kBF;
    private int kBG;
    private ForumWriteData kBH;
    private boolean kBI;
    private boolean kBJ = true;
    private l kBK;
    private StickerItem kBL;
    protected j kBM;
    private RecordTabLayout kBN;
    private ImageFileInfo kBO;
    private HttpMessageListener kBP;
    private boolean kBQ;
    private RecordLayout kBo;
    private VideoControllerLayout kBp;
    private RelativeLayout kBq;
    private ImageView kBr;
    private ImageView kBs;
    private ImageView kBt;
    private com.baidu.tbadk.core.dialog.a kBu;
    private PreviewViewContainer kBv;
    private TextView kBw;
    private VideoEffectButtonLayout kBx;
    private TextView kBy;
    private RoundProgressBar kBz;
    private com.baidu.tieba.j.h kgF;
    private String kvi;
    private SelectMusicModel kvm;
    private b.a kyt;
    private i kzK;
    protected h kzS;
    private Context mContext;
    private int mCurrentTab;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.kgF = lVar.cfr();
        }
        if (this.kgF != null) {
            this.kgF.ceU();
        }
        this.kyt = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void ev(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.kBp != null) {
                        RecordVideoActivity.this.kBp.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.kBp != null) {
                    RecordVideoActivity.this.kBp.setHasLocalVideo(true);
                    RecordVideoActivity.this.kBJ = false;
                }
            }
        };
        this.kBP = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.kBp != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.kBp.setStickerItems(list);
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
    public void cQj() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.kzS.kvn);
        videoInfo.setVideoDuration(this.kzK.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.kzS.kvn).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.kBH == null ? "" : this.kBH.forumName;
        String str2 = this.kBH == null ? "" : this.kBH.forumId;
        int i = this.kBH == null ? -1 : this.kBH.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.kBH.writeCallFrom, str, str2, this.kvi, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.kBM != null) {
            this.kBM.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.kgF != null) {
            this.kgF.ceX();
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
        if (this.kzK != null && this.kzK.isRecording()) {
            this.kzK.stopRecord();
        }
        if (this.kvm != null) {
            this.kvm.cancelLoadData();
        }
        if (this.kgF != null) {
            this.kgF.EL("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.ktJ));
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
        this.kBG = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.kBH = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.kvi = getIntent().getStringExtra("video_title");
        initUI();
        this.kvm = new SelectMusicModel(getPageContext(), this.kBp);
        this.kvm.cOH();
        this.kBM = new j(this);
        this.kBM.b(this.kvm);
        this.kzK.a(this.kBM);
        registerListener(this.kBP);
        registerListener(this.gFp);
        cQk();
    }

    private void cQk() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cPh() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.kyt);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.kBo = (RecordLayout) findViewById(R.id.root_layout);
        this.kBo.setListener(this);
        this.kzK = new i(this);
        this.kBp = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.kBp.setRecordController(this.kzK);
        this.kBp.setRecordControlListener(this);
        this.kBp.setEffectChoosedListener(this);
        this.kBq = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fgN = (ImageView) findViewById(R.id.close_page);
        this.fgN.setOnClickListener(this);
        this.kBr = (ImageView) findViewById(R.id.flash_switch);
        this.kBr.setOnClickListener(this);
        this.kBs = (ImageView) findViewById(R.id.camera_switch);
        this.kBs.setOnClickListener(this);
        this.kBt = (ImageView) findViewById(R.id.count_down);
        this.kBt.setOnClickListener(this);
        this.kBv = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.kzS = new h(this);
        this.kzS.a(this);
        this.kzS.setFaceIdentifyStateListener(this);
        this.kzS.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cPY() {
                if (RecordVideoActivity.this.kBp.cQJ()) {
                    RecordVideoActivity.this.kBp.a((m) null);
                }
            }
        });
        this.kBx = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.kBx.setListener(this);
        this.kzK.a(this.kBx);
        this.kBx.setViewChoosed(2, true);
        this.kBw = (TextView) findViewById(R.id.tv_count_down);
        this.kBy = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.kBw.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.kBw.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.kBx.setVisibility(8);
        }
        this.aBZ = findViewById(R.id.progress_layout);
        this.kBz = (RoundProgressBar) this.aBZ.findViewById(R.id.video_progress);
        this.kBA = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kBA.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.kBA.setLayoutParams(layoutParams);
        this.kBN = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.kBN.bg(1, getString(R.string.tab_photo));
        if (this.kBG != 2 && this.kBG != 3) {
            this.kBN.bg(2, getString(R.string.tab_record));
            this.kBN.setListener(this);
            this.kBN.setCurrentTab(2, false);
            onTabChoosed(2, false);
        } else {
            this.kBN.setShowIndicator(false);
            this.kBN.setCurrentTab(1, false);
            onTabChoosed(1, false);
        }
        cQl();
    }

    private void cQl() {
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
        this.kzS.onResume();
        this.kAz = this.kzS.cPQ();
        if (this.kAz != null) {
            this.kAz.setRecordController(this.kzK);
            this.kBv.setZoomHelper(this.kAz);
        }
        cQm();
        if (this.kBK == null) {
            this.kBK = new l();
            this.kBK.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eA(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.kBL, str2);
                    if (RecordVideoActivity.this.kBp != null) {
                        RecordVideoActivity.this.kBp.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void JG(String str) {
                    if (RecordVideoActivity.this.kBp != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.kBp.b(stickerItem);
                        if (RecordVideoActivity.this.kzS != null) {
                            RecordVideoActivity.this.kzS.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.kBp != null) {
                        RecordVideoActivity.this.kBp.setDownLoadSticker(null);
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
                public void cNR() {
                    if (RecordVideoActivity.this.kBp != null) {
                        RecordVideoActivity.this.kBp.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.kBK.cQD();
        if (this.kBp != null && this.kBJ) {
            cPh();
        }
        if (this.kgF != null) {
            this.kgF.EK("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.kzS.onPause();
        if (this.kBp != null) {
            if (this.kzK != null && this.kzK.getStatus() == 6) {
                this.kBp.stopRecord();
                cQv();
            }
            if (this.kzK != null && this.kzK.isRecording()) {
                this.kBp.stopRecord();
            }
        }
        if (this.kBM != null) {
            this.kBM.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kzK == null || this.kzK.getStatus() != 7) {
            if (this.kzK != null && this.kzK.getStatus() == 6) {
                if (this.kBp != null) {
                    this.kBp.stopRecord();
                }
                cQv();
            } else if (this.kzK.onBackPressed()) {
                finish();
            } else {
                if (this.kBu == null) {
                    this.kBu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.kBu.jF(R.string.video_quit_confirm);
                    this.kBu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.kBu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.kBu.fz(true);
                    this.kBu.b(getPageContext());
                }
                this.kBu.aCp();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.kBA.setVisibility(4);
        if (view == this.fgN) {
            onBackPressed();
        } else if (view == this.kBr) {
            if (this.kzK.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.kzS.cPT();
            cQm();
        } else if (view == this.kBs) {
            if (this.kzK.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.kBs.setOnClickListener(null);
            this.kzS.cPV();
            if (this.kzS.getIsFrontCamera() && this.kzS.cPU()) {
                this.kzS.cPT();
            }
            cQm();
            this.kBs.setOnClickListener(this);
        } else if (view == this.kBt) {
            cQo();
        }
    }

    private void cQm() {
        if (this.kzS.getIsFrontCamera()) {
            this.kBr.setVisibility(8);
        } else {
            this.kBr.setVisibility(0);
        }
        if (this.kzS.cPU()) {
            this.kBr.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.kBr.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cQn() {
        return this.kBv;
    }

    public void cQo() {
        this.kBA.setVisibility(4);
        if (this.kzK.getStatus() != 6) {
            this.kzK.setStatus(6);
            cQt();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.kBD == null) {
                this.kBD = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.kBD.setDuration(500L);
                this.kBD.setRepeatCount(5);
                this.kBD.setRepeatMode(2);
                this.kBD.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.kBD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.kzK.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.kBw.setVisibility(0);
                        RecordVideoActivity.this.kBw.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.kBw.setVisibility(8);
                    if (RecordVideoActivity.this.kzK.getStatus() == 6) {
                        RecordVideoActivity.this.kBp.cQG();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.kzK.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.kBw.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.kBw.setText("");
                        }
                    }
                }
            });
            this.kBw.setAnimation(this.kBD);
            this.kBD.startNow();
            this.kBp.cQo();
            if (this.kBM != null) {
                this.kBM.cQi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQp() {
        if (this.kzK.getStatus() == 1) {
            this.kBA.setVisibility(4);
            if (this.kzK.getStatus() != 6) {
                this.kBp.cQp();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQq() {
        this.kBA.setVisibility(4);
        if (this.kzK.getStatus() != 6) {
            this.kBp.cQq();
            if (this.kBp.cQK()) {
                cQk();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQr() {
        this.kBA.setVisibility(4);
        if (this.kzK.getStatus() != 6) {
            this.kBp.cQr();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cQs() {
        this.kBA.setVisibility(4);
        if (this.kzK.getStatus() != 6) {
            this.kBp.cQs();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQt() {
        this.kBI = true;
        if (this.kBC != null && this.kBC.isRunning()) {
            this.kBC.cancel();
        }
        if (this.kBB == null) {
            this.kBB = new AnimatorSet();
            this.kBB.playTogether(ObjectAnimator.ofFloat(this.kBq, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kBx, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.kBN, "alpha", 1.0f, 0.0f));
            this.kBB.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDn) {
                        RecordVideoActivity.this.kBq.setVisibility(8);
                        RecordVideoActivity.this.kBx.setVisibility(8);
                        RecordVideoActivity.this.kBN.setVisibility(8);
                    }
                }
            });
            this.kBB.setDuration(300L);
        }
        this.kBB.start();
        this.kBx.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQi() {
        if (this.mCurrentTab == 2) {
            if (this.kBI) {
                this.kBI = false;
                if (this.kBM != null) {
                    this.kBM.cQi();
                }
            } else {
                return;
            }
        }
        if (this.kBB != null && this.kBB.isRunning()) {
            this.kBB.cancel();
        }
        if (this.kBC == null) {
            this.kBC = new AnimatorSet();
            this.kBC.playTogether(ObjectAnimator.ofFloat(this.kBq, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kBx, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.kBN, "alpha", 0.0f, 1.0f));
            this.kBC.setDuration(300L);
        }
        this.kBq.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.kBx.setVisibility(0);
        }
        if (this.kzK.getStatus() == 1) {
            this.kBN.setVisibility(0);
        }
        this.kBC.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQu() {
        if (this.kzS != null) {
            this.kzS.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.kzK.setStatus(1);
                    RecordVideoActivity.this.cQi();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.kBO != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.kBO)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.kBO);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.kBO = new ImageFileInfo();
                        RecordVideoActivity.this.kBO.setFilePath(str);
                        RecordVideoActivity.this.kBO.setTempFile(true);
                        RecordVideoActivity.this.kBO.setAlbumnId(null);
                        RecordVideoActivity.this.kBO.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.kBO);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.kBH, RecordVideoActivity.this.kBG)));
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
    public void cQv() {
        this.kBD.cancel();
        this.kBD.setAnimationListener(null);
        this.kBw.clearAnimation();
        this.kBw.setVisibility(8);
        if (this.kBM != null) {
            this.kBM.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQw() {
        cHW();
    }

    private void cHW() {
        if (this.kBE != null) {
            this.kBE.cancel();
        }
        if (this.kBF == null) {
            this.kBF = ObjectAnimator.ofFloat(this.kBN, "alpha", 1.0f, 0.0f);
            this.kBF.setDuration(500L);
            this.kBF.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.kDn) {
                        RecordVideoActivity.this.kBN.setVisibility(8);
                    }
                }
            });
        }
        this.kBF.start();
    }

    private void cHV() {
        if (this.kBF != null) {
            this.kBF.cancel();
        }
        if (this.kBE == null) {
            this.kBE = ObjectAnimator.ofFloat(this.kBN, "alpha", 0.0f, 1.0f);
            this.kBE.setDuration(500L);
        }
        this.kBN.setVisibility(0);
        this.kBE.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQx() {
        this.kBx.reset();
        if (this.kzK.getStatus() == 1) {
            cHV();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQy() {
        if (this.aBZ.getVisibility() != 0) {
            this.kBp.cQF();
            this.kzK.setStatus(8);
            cQi();
            if (this.kzS.kAx != null && this.kzS.kAx.size() > 0) {
                this.aBZ.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int kBS = 50;
        final int kBT = 1;
        Handler kBU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.kBz.V(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cQC();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cQC() {
            this.kBU.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cQC();
            boolean z = RecordVideoActivity.this.kBM == null || TextUtils.isEmpty(RecordVideoActivity.this.kBM.cQh()) || !new File(RecordVideoActivity.this.kBM.cQh()).exists();
            if (RecordVideoActivity.this.kzS.kAx.size() > 1) {
                return com.baidu.tieba.video.meida.h.cPx().a(RecordVideoActivity.this.kzS.kAx, RecordVideoActivity.this.kzS.cPN(), z);
            }
            File file = new File(RecordVideoActivity.this.kzS.kAx.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.kzS.cPN());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cPx().a(RecordVideoActivity.this.kzS.kAx, RecordVideoActivity.this.kzS.cPN(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.kBp.cQL();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cQj();
                    RecordVideoActivity.this.DE(102);
                    RecordVideoActivity.this.aBZ.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cQj();
                RecordVideoActivity.this.DE(102);
                RecordVideoActivity.this.aBZ.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.aBZ.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.aP(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.kBz.V(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.kBp == null || v.isEmpty(this.kBp.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.kBp.getChoosedBeautyList()) {
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
        if (this.kBp == null || v.isEmpty(this.kBp.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.kBp.getChoosedFilterList()) {
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
        if (this.kBp == null || v.isEmpty(this.kBp.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.kBp.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQz() {
        this.kBA.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQA() {
        this.kBA.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cQB() {
        if (this.kzK.getStatus() == 1) {
            this.kBN.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.kzS != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.kzS.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").Z("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.kBx.setViewChoosed(2, false);
                            return;
                        } else {
                            this.kBx.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.kzS.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cp("obj_id", (String) eVar.getValue());
                        if (this.kzK.getStatus() == 1) {
                            anVar.Z("obj_type", 1);
                        } else {
                            anVar.Z("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.kBx.setViewChoosed(3, false);
                            return;
                        } else {
                            this.kBx.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.kBM.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.kBx.setViewChoosed(0, false);
                            return;
                        } else {
                            this.kBx.setViewChoosed(0, true);
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
            this.kBL = stickerItem;
            this.kBK.Ke(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.kzS != null) {
                    this.kzS.setSticker(null);
                    this.kBQ = false;
                }
                if (this.kBp != null) {
                    this.kBp.setDownLoadSticker(null);
                }
                this.kBy.setVisibility(8);
                this.kBx.setViewChoosed(1, false);
                return;
            }
            String Kb = this.kBK.Kb(stickerItem.resource);
            if (!StringUtils.isNull(Kb)) {
                a(stickerItem, Kb);
                if (this.kBp != null) {
                    this.kBp.setDownLoadSticker(null);
                }
            } else {
                if (this.kBp != null) {
                    this.kBp.setDownLoadSticker(stickerItem);
                }
                this.kBK.Kc(stickerItem.resource);
            }
            this.kBx.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.kzS != null) {
                this.kzS.setSticker(stickerItem);
                this.kBQ = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.kBy.setText(stickerItem.desc);
                this.kBy.setVisibility(0);
                this.kBy.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.kBy.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.kBy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cP(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.kBp.getLayoutParams();
            layoutParams.height = i4;
            this.kBp.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String JN = com.baidu.tieba.video.editvideo.model.a.cOB().JN(stringExtra);
                if (this.kBM != null && !TextUtils.isEmpty(JN)) {
                    this.kBM.eB(JN, stringExtra2);
                    this.kBp.cPC();
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
        if (this.kzK.getStatus() == 8) {
            this.kBp.cQE();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void tq(boolean z) {
        if (this.kzK != null && (this.kzK.getStatus() == 1 || this.kzK.getStatus() == 3 || this.kzK.getStatus() == 4)) {
            if (!z && this.kBQ) {
                this.kBv.cPZ();
                return;
            } else {
                this.kBv.cQa();
                return;
            }
        }
        this.kBv.cQa();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void onTabChoosed(int i, boolean z) {
        int i2 = 1;
        if (this.mCurrentTab != i) {
            switch (i) {
                case 1:
                    if (this.kBM != null) {
                        this.kBM.aUk();
                    }
                    this.kzS.setFilter("origin");
                    this.kBx.setViewChoosed(0, false);
                    this.kBx.setViewChoosed(3, false);
                    this.kBp.DG(1);
                    this.kBx.setViewVisibility(0, 8);
                    this.kBx.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.kBx.setViewVisibility(0, 0);
                    this.kBx.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.mCurrentTab = i;
            this.kBp.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().Z("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cQg() {
        if (this.kzK.getStatus() == 1 && !this.kBp.cQJ()) {
            onTabChoosed(1, true);
            this.kBN.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cQf() {
        if (this.kzK.getStatus() == 1 && !this.kBp.cQJ()) {
            onTabChoosed(2, true);
            this.kBN.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(int i) {
        if (this.kgF != null) {
            this.kgF.aQ(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(int i, String str) {
        if (this.kgF != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.kgF.aP(i, str);
        }
    }
}
