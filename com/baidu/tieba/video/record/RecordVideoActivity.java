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
    private View bcl;
    private ImageView fPd;
    private int hqi;
    private final CustomMessageListener hrY;
    private com.baidu.tieba.k.h kTM;
    private SelectMusicModel liA;
    private String liw;
    private b.a llL;
    private b lnV;
    private i lne;
    protected h lnn;
    private RecordLayout loP;
    private VideoControllerLayout loQ;
    private RelativeLayout loR;
    private ImageView loS;
    private ImageView loT;
    private ImageView loU;
    private com.baidu.tbadk.core.dialog.a loV;
    private PreviewViewContainer loW;
    private TextView loX;
    private VideoEffectButtonLayout loY;
    private TextView loZ;
    private RoundProgressBar lpa;
    private TextView lpb;
    private AnimatorSet lpc;
    private AnimatorSet lpd;
    private ScaleAnimation lpe;
    private ObjectAnimator lpf;
    private ObjectAnimator lpg;
    private int lph;
    private ForumWriteData lpi;
    private boolean lpj;
    private boolean lpk = true;
    private l lpl;
    private StickerItem lpm;
    protected j lpn;
    private RecordTabLayout lpo;
    private ImageFileInfo lpp;
    private HttpMessageListener lpq;
    private boolean lpr;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.kTM = lVar.crX();
        }
        if (this.kTM != null) {
            this.kTM.crz();
        }
        this.llL = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eF(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.loQ != null) {
                        RecordVideoActivity.this.loQ.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.loQ != null) {
                    RecordVideoActivity.this.loQ.setHasLocalVideo(true);
                    RecordVideoActivity.this.lpk = false;
                }
            }
        };
        this.lpq = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.loQ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.loQ.setStickerItems(list);
                    }
                }
            }
        };
        this.hrY = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                    Intent intent = new Intent();
                    intent.putExtra(PostWriteCallBackData.GENERAL_TAB_ID, ((PostWriteCallBackData) customResponsedMessage.getData()).getGeneralTabId());
                    RecordVideoActivity.this.setResult(-1, intent);
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
    public void dcZ() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lnn.liB);
        videoInfo.setVideoDuration(this.lne.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.lnn.liB).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.lpi == null ? "" : this.lpi.forumName;
        String str2 = this.lpi == null ? "" : this.lpi.forumId;
        int i = this.lpi == null ? -1 : this.lpi.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.lpi.writeCallFrom, str, str2, this.liw, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.lpi != null ? this.lpi.frsTabInfo : null);
        editVideoActivityConfig.setFrom(this.lpi.mFrom);
        if (this.lpn != null) {
            this.lpn.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.kTM != null) {
            this.kTM.crC();
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
        if (this.lne != null && this.lne.aRl()) {
            this.lne.stopRecord();
        }
        if (this.liA != null) {
            this.liA.cancelLoadData();
        }
        if (this.kTM != null) {
            this.kTM.GM("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lgU));
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
        this.lph = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.lpi = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.liw = getIntent().getStringExtra("video_title");
        initUI();
        this.liA = new SelectMusicModel(getPageContext(), this.loQ);
        this.liA.dbt();
        this.lpn = new j(this);
        this.lpn.b(this.liA);
        this.lne.a(this.lpn);
        registerListener(this.lpq);
        registerListener(this.hrY);
        dda();
    }

    private void dda() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dbT() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.llL);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.loP = (RecordLayout) findViewById(R.id.root_layout);
        this.loP.setListener(this);
        this.lne = new i(this);
        this.loQ = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.loQ.setRecordController(this.lne);
        this.loQ.setRecordControlListener(this);
        this.loQ.setEffectChoosedListener(this);
        this.loR = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fPd = (ImageView) findViewById(R.id.close_page);
        this.fPd.setOnClickListener(this);
        this.loS = (ImageView) findViewById(R.id.flash_switch);
        this.loS.setOnClickListener(this);
        this.loT = (ImageView) findViewById(R.id.camera_switch);
        this.loT.setOnClickListener(this);
        this.loU = (ImageView) findViewById(R.id.count_down);
        this.loU.setOnClickListener(this);
        this.loW = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.lnn = new h(this);
        this.lnn.a(this);
        this.lnn.setFaceIdentifyStateListener(this);
        this.lnn.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void dcN() {
                if (RecordVideoActivity.this.loQ.ddz()) {
                    RecordVideoActivity.this.loQ.a((m) null);
                }
            }
        });
        this.loY = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.loY.setListener(this);
        this.lne.a(this.loY);
        this.loY.setViewChoosed(2, true);
        this.loX = (TextView) findViewById(R.id.tv_count_down);
        this.loZ = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.loX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.loX.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.loY.setVisibility(8);
        }
        this.bcl = findViewById(R.id.progress_layout);
        this.lpa = (RoundProgressBar) this.bcl.findViewById(R.id.video_progress);
        this.lpb = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lpb.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.lpb.setLayoutParams(layoutParams);
        this.lpo = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.lpo.bw(1, getString(R.string.tab_photo));
        if (this.lph != 2 && this.lph != 3) {
            this.lpo.bw(2, getString(R.string.tab_record));
            this.lpo.setListener(this);
            this.lpo.setCurrentTab(2, false);
            Z(2, false);
        } else {
            this.lpo.setShowIndicator(false);
            this.lpo.setCurrentTab(1, false);
            Z(1, false);
        }
        ddb();
    }

    private void ddb() {
        if (com.baidu.tbadk.core.util.g.aOc()) {
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
        this.lnn.onResume();
        this.lnV = this.lnn.dcE();
        if (this.lnV != null) {
            this.lnV.setRecordController(this.lne);
            this.loW.setZoomHelper(this.lnV);
        }
        ddc();
        if (this.lpl == null) {
            this.lpl = new l();
            this.lpl.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eW(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.lpm, str2);
                    if (RecordVideoActivity.this.loQ != null) {
                        RecordVideoActivity.this.loQ.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void LG(String str) {
                    if (RecordVideoActivity.this.loQ != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.loQ.b(stickerItem);
                        if (RecordVideoActivity.this.lnn != null) {
                            RecordVideoActivity.this.lnn.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.loQ != null) {
                        RecordVideoActivity.this.loQ.setDownLoadSticker(null);
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
                    recordVideoActivity.be(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void daE() {
                    if (RecordVideoActivity.this.loQ != null) {
                        RecordVideoActivity.this.loQ.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.lpl.ddt();
        if (this.loQ != null && this.lpk) {
            dbT();
        }
        if (this.kTM != null) {
            this.kTM.GL("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lnn.onPause();
        if (this.loQ != null) {
            if (this.lne != null && this.lne.getStatus() == 6) {
                this.loQ.stopRecord();
                ddl();
            }
            if (this.lne != null && this.lne.aRl()) {
                this.loQ.stopRecord();
            }
        }
        if (this.lpn != null) {
            this.lpn.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lne == null || this.lne.getStatus() != 7) {
            if (this.lne != null && this.lne.getStatus() == 6) {
                if (this.loQ != null) {
                    this.loQ.stopRecord();
                }
                ddl();
            } else if (this.lne != null && this.lne.onBackPressed()) {
                finish();
            } else {
                if (this.loV == null) {
                    this.loV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.loV.kd(R.string.video_quit_confirm);
                    this.loV.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.loV.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.loV.gE(true);
                    this.loV.b(getPageContext());
                }
                this.loV.aMS();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.lpb.setVisibility(4);
        if (view == this.fPd) {
            onBackPressed();
        } else if (view == this.loS) {
            if (this.lne.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.lnn.dcH();
            ddc();
        } else if (view == this.loT) {
            if (this.lne.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.loT.setOnClickListener(null);
            this.lnn.dcJ();
            if (this.lnn.dcK() && this.lnn.dcI()) {
                this.lnn.dcH();
            }
            ddc();
            this.loT.setOnClickListener(this);
        } else if (view == this.loU) {
            dde();
        }
    }

    private void ddc() {
        if (this.lnn.dcK()) {
            this.loS.setVisibility(8);
        } else {
            this.loS.setVisibility(0);
        }
        if (this.lnn.dcI()) {
            this.loS.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.loS.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout ddd() {
        return this.loW;
    }

    public void dde() {
        this.lpb.setVisibility(4);
        if (this.lne.getStatus() != 6) {
            this.lne.setStatus(6);
            ddj();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.lpe == null) {
                this.lpe = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.lpe.setDuration(500L);
                this.lpe.setRepeatCount(5);
                this.lpe.setRepeatMode(2);
                this.lpe.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.lpe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.lne.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.loX.setVisibility(0);
                        RecordVideoActivity.this.loX.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.loX.setVisibility(8);
                    if (RecordVideoActivity.this.lne.getStatus() == 6) {
                        RecordVideoActivity.this.loQ.ddw();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.lne.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.loX.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.loX.setText("");
                        }
                    }
                }
            });
            this.loX.setAnimation(this.lpe);
            this.lpe.startNow();
            this.loQ.dde();
            if (this.lpn != null) {
                this.lpn.dcY();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddf() {
        if (this.lne.getStatus() == 1) {
            this.lpb.setVisibility(4);
            if (this.lne.getStatus() != 6) {
                this.loQ.ddf();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddg() {
        this.lpb.setVisibility(4);
        if (this.lne.getStatus() != 6) {
            this.loQ.ddg();
            if (this.loQ.ddA()) {
                dda();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddh() {
        this.lpb.setVisibility(4);
        if (this.lne.getStatus() != 6) {
            this.loQ.ddh();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddi() {
        this.lpb.setVisibility(4);
        if (this.lne.getStatus() != 6) {
            this.loQ.ddi();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddj() {
        this.lpj = true;
        if (this.lpd != null && this.lpd.isRunning()) {
            this.lpd.cancel();
        }
        if (this.lpc == null) {
            this.lpc = new AnimatorSet();
            this.lpc.playTogether(ObjectAnimator.ofFloat(this.loR, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.loY, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lpo, "alpha", 1.0f, 0.0f));
            this.lpc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqO) {
                        RecordVideoActivity.this.loR.setVisibility(8);
                        RecordVideoActivity.this.loY.setVisibility(8);
                        RecordVideoActivity.this.lpo.setVisibility(8);
                    }
                }
            });
            this.lpc.setDuration(300L);
        }
        this.lpc.start();
        this.loY.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dcY() {
        if (this.hqi == 2) {
            if (this.lpj) {
                this.lpj = false;
                if (this.lpn != null) {
                    this.lpn.dcY();
                }
            } else {
                return;
            }
        }
        if (this.lpc != null && this.lpc.isRunning()) {
            this.lpc.cancel();
        }
        if (this.lpd == null) {
            this.lpd = new AnimatorSet();
            this.lpd.playTogether(ObjectAnimator.ofFloat(this.loR, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.loY, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lpo, "alpha", 0.0f, 1.0f));
            this.lpd.setDuration(300L);
        }
        this.loR.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.loY.setVisibility(0);
        }
        if (this.lne.getStatus() == 1) {
            this.lpo.setVisibility(0);
        }
        this.lpd.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddk() {
        if (this.lnn != null) {
            this.lnn.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void A(boolean z, String str) {
                    RecordVideoActivity.this.lne.setStatus(1);
                    RecordVideoActivity.this.dcY();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.lpp != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.lpp)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.lpp);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.lpp = new ImageFileInfo();
                        RecordVideoActivity.this.lpp.setFilePath(str);
                        RecordVideoActivity.this.lpp.setContentUriStr(null);
                        RecordVideoActivity.this.lpp.setTempFile(true);
                        RecordVideoActivity.this.lpp.setAlbumnId(null);
                        RecordVideoActivity.this.lpp.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.lpp);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.lpi, RecordVideoActivity.this.lph)));
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
    public void ddl() {
        this.lpe.cancel();
        this.lpe.setAnimationListener(null);
        this.loX.clearAnimation();
        this.loX.setVisibility(8);
        if (this.lpn != null) {
            this.lpn.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddm() {
        cUR();
    }

    private void cUR() {
        if (this.lpf != null) {
            this.lpf.cancel();
        }
        if (this.lpg == null) {
            this.lpg = ObjectAnimator.ofFloat(this.lpo, "alpha", 1.0f, 0.0f);
            this.lpg.setDuration(500L);
            this.lpg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqO) {
                        RecordVideoActivity.this.lpo.setVisibility(8);
                    }
                }
            });
        }
        this.lpg.start();
    }

    private void cUQ() {
        if (this.lpg != null) {
            this.lpg.cancel();
        }
        if (this.lpf == null) {
            this.lpf = ObjectAnimator.ofFloat(this.lpo, "alpha", 0.0f, 1.0f);
            this.lpf.setDuration(500L);
        }
        this.lpo.setVisibility(0);
        this.lpf.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddn() {
        this.loY.reset();
        if (this.lne.getStatus() == 1) {
            cUQ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddo() {
        if (this.bcl.getVisibility() != 0) {
            this.loQ.ddv();
            this.lne.setStatus(8);
            dcY();
            if (this.lnn.lnT != null && this.lnn.lnT.size() > 0) {
                this.bcl.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int lpt = 50;
        final int lpu = 1;
        Handler lpv = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.lpa.F(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.dds();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void dds() {
            this.lpv.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            dds();
            boolean z = RecordVideoActivity.this.lpn == null || TextUtils.isEmpty(RecordVideoActivity.this.lpn.dcX()) || !new File(RecordVideoActivity.this.lpn.dcX()).exists();
            if (RecordVideoActivity.this.lnn.lnT.size() > 1) {
                return com.baidu.tieba.video.meida.h.dck().a(RecordVideoActivity.this.lnn.lnT, RecordVideoActivity.this.lnn.dcB(), z);
            }
            File file = new File(RecordVideoActivity.this.lnn.lnT.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.lnn.dcB());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dck().a(RecordVideoActivity.this.lnn.lnT, RecordVideoActivity.this.lnn.dcB(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.loQ.ddB();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.dcZ();
                    RecordVideoActivity.this.Ew(102);
                    RecordVideoActivity.this.bcl.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.dcZ();
                RecordVideoActivity.this.Ew(102);
                RecordVideoActivity.this.bcl.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bcl.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.be(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.lpa.F(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.loQ == null || v.isEmpty(this.loQ.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.loQ.getChoosedBeautyList()) {
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
        if (this.loQ == null || v.isEmpty(this.loQ.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.loQ.getChoosedFilterList()) {
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
        if (this.loQ == null || v.isEmpty(this.loQ.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.loQ.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddp() {
        this.lpb.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddq() {
        this.lpb.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddr() {
        if (this.lne.getStatus() == 1) {
            this.lpo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.lnn != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.lnn.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").af("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.loY.setViewChoosed(2, false);
                            return;
                        } else {
                            this.loY.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.lnn.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cI("obj_id", (String) eVar.getValue());
                        if (this.lne.getStatus() == 1) {
                            anVar.af("obj_type", 1);
                        } else {
                            anVar.af("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.loY.setViewChoosed(3, false);
                            return;
                        } else {
                            this.loY.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.lpn.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.loY.setViewChoosed(0, false);
                            return;
                        } else {
                            this.loY.setViewChoosed(0, true);
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
            this.lpm = stickerItem;
            this.lpl.Mg(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.lnn != null) {
                    this.lnn.setSticker(null);
                    this.lpr = false;
                }
                if (this.loQ != null) {
                    this.loQ.setDownLoadSticker(null);
                }
                this.loZ.setVisibility(8);
                this.loY.setViewChoosed(1, false);
                return;
            }
            String Md = this.lpl.Md(stickerItem.resource);
            if (!StringUtils.isNull(Md)) {
                a(stickerItem, Md);
                if (this.loQ != null) {
                    this.loQ.setDownLoadSticker(null);
                }
            } else {
                if (this.loQ != null) {
                    this.loQ.setDownLoadSticker(stickerItem);
                }
                this.lpl.Me(stickerItem.resource);
            }
            this.loY.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.lnn != null) {
                this.lnn.setSticker(stickerItem);
                this.lpr = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.loZ.setText(stickerItem.desc);
                this.loZ.setVisibility(0);
                this.loZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.loZ.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.loZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cY(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.loQ.getLayoutParams();
            layoutParams.height = i4;
            this.loQ.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String LO = com.baidu.tieba.video.editvideo.model.a.dbn().LO(stringExtra);
                if (this.lpn != null && !TextUtils.isEmpty(LO)) {
                    this.lpn.eX(LO, stringExtra2);
                    this.loQ.dcp();
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
        if (this.lne.getStatus() == 8) {
            this.loQ.ddu();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void uC(boolean z) {
        if (this.lne != null && (this.lne.getStatus() == 1 || this.lne.getStatus() == 3 || this.lne.getStatus() == 4)) {
            if (!z && this.lpr) {
                this.loW.dcO();
                return;
            } else {
                this.loW.dcP();
                return;
            }
        }
        this.loW.dcP();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void Z(int i, boolean z) {
        int i2 = 1;
        if (this.hqi != i) {
            switch (i) {
                case 1:
                    if (this.lpn != null) {
                        this.lpn.beL();
                    }
                    this.lnn.setFilter("origin");
                    this.loY.setViewChoosed(0, false);
                    this.loY.setViewChoosed(3, false);
                    this.loQ.Ey(1);
                    this.loY.setViewVisibility(0, 8);
                    this.loY.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.loY.setViewVisibility(0, 0);
                    this.loY.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hqi = i;
            this.loQ.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().af("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dcW() {
        if (this.lne.getStatus() == 1 && !this.loQ.ddz()) {
            Z(1, true);
            this.lpo.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dcV() {
        if (this.lne.getStatus() == 1 && !this.loQ.ddz()) {
            Z(2, true);
            this.lpo.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ew(int i) {
        if (this.kTM != null) {
            this.kTM.bf(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, String str) {
        if (this.kTM != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.kTM.be(i, str);
        }
    }
}
