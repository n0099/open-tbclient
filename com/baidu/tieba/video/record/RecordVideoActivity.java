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
    private View bcg;
    private ImageView fOY;
    private int hqc;
    private final CustomMessageListener hrS;
    private com.baidu.tieba.k.h kTI;
    private String lis;
    private SelectMusicModel liw;
    private b.a llH;
    private b lnR;
    private i lna;
    protected h lnj;
    private RecordLayout loL;
    private VideoControllerLayout loM;
    private RelativeLayout loN;
    private ImageView loO;
    private ImageView loP;
    private ImageView loQ;
    private com.baidu.tbadk.core.dialog.a loR;
    private PreviewViewContainer loS;
    private TextView loT;
    private VideoEffectButtonLayout loU;
    private TextView loV;
    private RoundProgressBar loW;
    private TextView loX;
    private AnimatorSet loY;
    private AnimatorSet loZ;
    private ScaleAnimation lpa;
    private ObjectAnimator lpb;
    private ObjectAnimator lpc;
    private int lpd;
    private ForumWriteData lpe;
    private boolean lpf;
    private boolean lpg = true;
    private l lph;
    private StickerItem lpi;
    protected j lpj;
    private RecordTabLayout lpk;
    private ImageFileInfo lpl;
    private HttpMessageListener lpm;
    private boolean lpn;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.k.l.class);
        com.baidu.tieba.k.l lVar = runTask != null ? (com.baidu.tieba.k.l) runTask.getData() : null;
        if (lVar != null) {
            this.kTI = lVar.csa();
        }
        if (this.kTI != null) {
            this.kTI.crC();
        }
        this.llH = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eF(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.loM != null) {
                        RecordVideoActivity.this.loM.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.loM != null) {
                    RecordVideoActivity.this.loM.setHasLocalVideo(true);
                    RecordVideoActivity.this.lpg = false;
                }
            }
        };
        this.lpm = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.loM != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.loM.setStickerItems(list);
                    }
                }
            }
        };
        this.hrS = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void ddc() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.lnj.lix);
        videoInfo.setVideoDuration(this.lna.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.lnj.lix).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.lpe == null ? "" : this.lpe.forumName;
        String str2 = this.lpe == null ? "" : this.lpe.forumId;
        int i = this.lpe == null ? -1 : this.lpe.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.lpe.writeCallFrom, str, str2, this.lis, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        editVideoActivityConfig.setFrsTabInfo(this.lpe != null ? this.lpe.frsTabInfo : null);
        editVideoActivityConfig.setFrom(this.lpe.mFrom);
        if (this.lpj != null) {
            this.lpj.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.kTI != null) {
            this.kTI.crF();
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
        if (this.lna != null && this.lna.aRo()) {
            this.lna.stopRecord();
        }
        if (this.liw != null) {
            this.liw.cancelLoadData();
        }
        if (this.kTI != null) {
            this.kTI.GJ("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.lgQ));
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
        this.lpd = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.lpe = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.lis = getIntent().getStringExtra("video_title");
        initUI();
        this.liw = new SelectMusicModel(getPageContext(), this.loM);
        this.liw.dbw();
        this.lpj = new j(this);
        this.lpj.b(this.liw);
        this.lna.a(this.lpj);
        registerListener(this.lpm);
        registerListener(this.hrS);
        ddd();
    }

    private void ddd() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void dbW() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.llH);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.loL = (RecordLayout) findViewById(R.id.root_layout);
        this.loL.setListener(this);
        this.lna = new i(this);
        this.loM = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.loM.setRecordController(this.lna);
        this.loM.setRecordControlListener(this);
        this.loM.setEffectChoosedListener(this);
        this.loN = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.fOY = (ImageView) findViewById(R.id.close_page);
        this.fOY.setOnClickListener(this);
        this.loO = (ImageView) findViewById(R.id.flash_switch);
        this.loO.setOnClickListener(this);
        this.loP = (ImageView) findViewById(R.id.camera_switch);
        this.loP.setOnClickListener(this);
        this.loQ = (ImageView) findViewById(R.id.count_down);
        this.loQ.setOnClickListener(this);
        this.loS = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.lnj = new h(this);
        this.lnj.a(this);
        this.lnj.setFaceIdentifyStateListener(this);
        this.lnj.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void dcQ() {
                if (RecordVideoActivity.this.loM.ddC()) {
                    RecordVideoActivity.this.loM.a((m) null);
                }
            }
        });
        this.loU = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.loU.setListener(this);
        this.lna.a(this.loU);
        this.loU.setViewChoosed(2, true);
        this.loT = (TextView) findViewById(R.id.tv_count_down);
        this.loV = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.loT.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.loT.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.loU.setVisibility(8);
        }
        this.bcg = findViewById(R.id.progress_layout);
        this.loW = (RoundProgressBar) this.bcg.findViewById(R.id.video_progress);
        this.loX = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.loX.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.loX.setLayoutParams(layoutParams);
        this.lpk = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.lpk.bw(1, getString(R.string.tab_photo));
        if (this.lpd != 2 && this.lpd != 3) {
            this.lpk.bw(2, getString(R.string.tab_record));
            this.lpk.setListener(this);
            this.lpk.setCurrentTab(2, false);
            Z(2, false);
        } else {
            this.lpk.setShowIndicator(false);
            this.lpk.setCurrentTab(1, false);
            Z(1, false);
        }
        dde();
    }

    private void dde() {
        if (com.baidu.tbadk.core.util.g.aOe()) {
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
        this.lnj.onResume();
        this.lnR = this.lnj.dcH();
        if (this.lnR != null) {
            this.lnR.setRecordController(this.lna);
            this.loS.setZoomHelper(this.lnR);
        }
        ddf();
        if (this.lph == null) {
            this.lph = new l();
            this.lph.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void eW(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.lpi, str2);
                    if (RecordVideoActivity.this.loM != null) {
                        RecordVideoActivity.this.loM.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void LD(String str) {
                    if (RecordVideoActivity.this.loM != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.loM.b(stickerItem);
                        if (RecordVideoActivity.this.lnj != null) {
                            RecordVideoActivity.this.lnj.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.loM != null) {
                        RecordVideoActivity.this.loM.setDownLoadSticker(null);
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
                public void daH() {
                    if (RecordVideoActivity.this.loM != null) {
                        RecordVideoActivity.this.loM.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.lph.ddw();
        if (this.loM != null && this.lpg) {
            dbW();
        }
        if (this.kTI != null) {
            this.kTI.GI("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.lnj.onPause();
        if (this.loM != null) {
            if (this.lna != null && this.lna.getStatus() == 6) {
                this.loM.stopRecord();
                ddo();
            }
            if (this.lna != null && this.lna.aRo()) {
                this.loM.stopRecord();
            }
        }
        if (this.lpj != null) {
            this.lpj.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.lna == null || this.lna.getStatus() != 7) {
            if (this.lna != null && this.lna.getStatus() == 6) {
                if (this.loM != null) {
                    this.loM.stopRecord();
                }
                ddo();
            } else if (this.lna != null && this.lna.onBackPressed()) {
                finish();
            } else {
                if (this.loR == null) {
                    this.loR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.loR.kd(R.string.video_quit_confirm);
                    this.loR.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.loR.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.loR.gE(true);
                    this.loR.b(getPageContext());
                }
                this.loR.aMU();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.loX.setVisibility(4);
        if (view == this.fOY) {
            onBackPressed();
        } else if (view == this.loO) {
            if (this.lna.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.lnj.dcK();
            ddf();
        } else if (view == this.loP) {
            if (this.lna.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.loP.setOnClickListener(null);
            this.lnj.dcM();
            if (this.lnj.dcN() && this.lnj.dcL()) {
                this.lnj.dcK();
            }
            ddf();
            this.loP.setOnClickListener(this);
        } else if (view == this.loQ) {
            ddh();
        }
    }

    private void ddf() {
        if (this.lnj.dcN()) {
            this.loO.setVisibility(8);
        } else {
            this.loO.setVisibility(0);
        }
        if (this.lnj.dcL()) {
            this.loO.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.loO.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout ddg() {
        return this.loS;
    }

    public void ddh() {
        this.loX.setVisibility(4);
        if (this.lna.getStatus() != 6) {
            this.lna.setStatus(6);
            ddm();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.lpa == null) {
                this.lpa = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.lpa.setDuration(500L);
                this.lpa.setRepeatCount(5);
                this.lpa.setRepeatMode(2);
                this.lpa.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.lpa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.lna.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.loT.setVisibility(0);
                        RecordVideoActivity.this.loT.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.loT.setVisibility(8);
                    if (RecordVideoActivity.this.lna.getStatus() == 6) {
                        RecordVideoActivity.this.loM.ddz();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.lna.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.loT.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.loT.setText("");
                        }
                    }
                }
            });
            this.loT.setAnimation(this.lpa);
            this.lpa.startNow();
            this.loM.ddh();
            if (this.lpj != null) {
                this.lpj.ddb();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddi() {
        if (this.lna.getStatus() == 1) {
            this.loX.setVisibility(4);
            if (this.lna.getStatus() != 6) {
                this.loM.ddi();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddj() {
        this.loX.setVisibility(4);
        if (this.lna.getStatus() != 6) {
            this.loM.ddj();
            if (this.loM.ddD()) {
                ddd();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddk() {
        this.loX.setVisibility(4);
        if (this.lna.getStatus() != 6) {
            this.loM.ddk();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ddl() {
        this.loX.setVisibility(4);
        if (this.lna.getStatus() != 6) {
            this.loM.ddl();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddm() {
        this.lpf = true;
        if (this.loZ != null && this.loZ.isRunning()) {
            this.loZ.cancel();
        }
        if (this.loY == null) {
            this.loY = new AnimatorSet();
            this.loY.playTogether(ObjectAnimator.ofFloat(this.loN, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.loU, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.lpk, "alpha", 1.0f, 0.0f));
            this.loY.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqK) {
                        RecordVideoActivity.this.loN.setVisibility(8);
                        RecordVideoActivity.this.loU.setVisibility(8);
                        RecordVideoActivity.this.lpk.setVisibility(8);
                    }
                }
            });
            this.loY.setDuration(300L);
        }
        this.loY.start();
        this.loU.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddb() {
        if (this.hqc == 2) {
            if (this.lpf) {
                this.lpf = false;
                if (this.lpj != null) {
                    this.lpj.ddb();
                }
            } else {
                return;
            }
        }
        if (this.loY != null && this.loY.isRunning()) {
            this.loY.cancel();
        }
        if (this.loZ == null) {
            this.loZ = new AnimatorSet();
            this.loZ.playTogether(ObjectAnimator.ofFloat(this.loN, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.loU, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.lpk, "alpha", 0.0f, 1.0f));
            this.loZ.setDuration(300L);
        }
        this.loN.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.loU.setVisibility(0);
        }
        if (this.lna.getStatus() == 1) {
            this.lpk.setVisibility(0);
        }
        this.loZ.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddn() {
        if (this.lnj != null) {
            this.lnj.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void A(boolean z, String str) {
                    RecordVideoActivity.this.lna.setStatus(1);
                    RecordVideoActivity.this.ddb();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.lpl != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.lpl)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.lpl);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.lpl = new ImageFileInfo();
                        RecordVideoActivity.this.lpl.setFilePath(str);
                        RecordVideoActivity.this.lpl.setContentUriStr(null);
                        RecordVideoActivity.this.lpl.setTempFile(true);
                        RecordVideoActivity.this.lpl.setAlbumnId(null);
                        RecordVideoActivity.this.lpl.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.lpl);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.lpe, RecordVideoActivity.this.lpd)));
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
    public void ddo() {
        this.lpa.cancel();
        this.lpa.setAnimationListener(null);
        this.loT.clearAnimation();
        this.loT.setVisibility(8);
        if (this.lpj != null) {
            this.lpj.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddp() {
        cUU();
    }

    private void cUU() {
        if (this.lpb != null) {
            this.lpb.cancel();
        }
        if (this.lpc == null) {
            this.lpc = ObjectAnimator.ofFloat(this.lpk, "alpha", 1.0f, 0.0f);
            this.lpc.setDuration(500L);
            this.lpc.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.lqK) {
                        RecordVideoActivity.this.lpk.setVisibility(8);
                    }
                }
            });
        }
        this.lpc.start();
    }

    private void cUT() {
        if (this.lpc != null) {
            this.lpc.cancel();
        }
        if (this.lpb == null) {
            this.lpb = ObjectAnimator.ofFloat(this.lpk, "alpha", 0.0f, 1.0f);
            this.lpb.setDuration(500L);
        }
        this.lpk.setVisibility(0);
        this.lpb.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddq() {
        this.loU.reset();
        if (this.lna.getStatus() == 1) {
            cUT();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddr() {
        if (this.bcg.getVisibility() != 0) {
            this.loM.ddy();
            this.lna.setStatus(8);
            ddb();
            if (this.lnj.lnP != null && this.lnj.lnP.size() > 0) {
                this.bcg.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int lpp = 50;
        final int lpq = 1;
        Handler lpr = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.loW.F(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.ddv();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void ddv() {
            this.lpr.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            ddv();
            boolean z = RecordVideoActivity.this.lpj == null || TextUtils.isEmpty(RecordVideoActivity.this.lpj.dda()) || !new File(RecordVideoActivity.this.lpj.dda()).exists();
            if (RecordVideoActivity.this.lnj.lnP.size() > 1) {
                return com.baidu.tieba.video.meida.h.dcn().a(RecordVideoActivity.this.lnj.lnP, RecordVideoActivity.this.lnj.dcE(), z);
            }
            File file = new File(RecordVideoActivity.this.lnj.lnP.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.tbadk.core.util.m.copyFile(file.getPath(), RecordVideoActivity.this.lnj.dcE());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.dcn().a(RecordVideoActivity.this.lnj.lnP, RecordVideoActivity.this.lnj.dcE(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.loM.ddE();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.ddc();
                    RecordVideoActivity.this.Ew(102);
                    RecordVideoActivity.this.bcg.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.ddc();
                RecordVideoActivity.this.Ew(102);
                RecordVideoActivity.this.bcg.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.bcg.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.be(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.loW.F(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.loM == null || v.isEmpty(this.loM.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.loM.getChoosedBeautyList()) {
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
        if (this.loM == null || v.isEmpty(this.loM.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.loM.getChoosedFilterList()) {
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
        if (this.loM == null || v.isEmpty(this.loM.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.loM.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void dds() {
        this.loX.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddt() {
        this.loX.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ddu() {
        if (this.lna.getStatus() == 1) {
            this.lpk.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.lnj != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.lnj.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").af("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.loU.setViewChoosed(2, false);
                            return;
                        } else {
                            this.loU.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.lnj.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.cI("obj_id", (String) eVar.getValue());
                        if (this.lna.getStatus() == 1) {
                            anVar.af("obj_type", 1);
                        } else {
                            anVar.af("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.loU.setViewChoosed(3, false);
                            return;
                        } else {
                            this.loU.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.lpj.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.loU.setViewChoosed(0, false);
                            return;
                        } else {
                            this.loU.setViewChoosed(0, true);
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
            this.lpi = stickerItem;
            this.lph.Md(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.lnj != null) {
                    this.lnj.setSticker(null);
                    this.lpn = false;
                }
                if (this.loM != null) {
                    this.loM.setDownLoadSticker(null);
                }
                this.loV.setVisibility(8);
                this.loU.setViewChoosed(1, false);
                return;
            }
            String Ma = this.lph.Ma(stickerItem.resource);
            if (!StringUtils.isNull(Ma)) {
                a(stickerItem, Ma);
                if (this.loM != null) {
                    this.loM.setDownLoadSticker(null);
                }
            } else {
                if (this.loM != null) {
                    this.loM.setDownLoadSticker(stickerItem);
                }
                this.lph.Mb(stickerItem.resource);
            }
            this.loU.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.lnj != null) {
                this.lnj.setSticker(stickerItem);
                this.lpn = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.loV.setText(stickerItem.desc);
                this.loV.setVisibility(0);
                this.loV.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.loV.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.loV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cY(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.loM.getLayoutParams();
            layoutParams.height = i4;
            this.loM.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String LL = com.baidu.tieba.video.editvideo.model.a.dbq().LL(stringExtra);
                if (this.lpj != null && !TextUtils.isEmpty(LL)) {
                    this.lpj.eX(LL, stringExtra2);
                    this.loM.dcs();
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
        if (this.lna.getStatus() == 8) {
            this.loM.ddx();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void uC(boolean z) {
        if (this.lna != null && (this.lna.getStatus() == 1 || this.lna.getStatus() == 3 || this.lna.getStatus() == 4)) {
            if (!z && this.lpn) {
                this.loS.dcR();
                return;
            } else {
                this.loS.dcS();
                return;
            }
        }
        this.loS.dcS();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void Z(int i, boolean z) {
        int i2 = 1;
        if (this.hqc != i) {
            switch (i) {
                case 1:
                    if (this.lpj != null) {
                        this.lpj.beN();
                    }
                    this.lnj.setFilter("origin");
                    this.loU.setViewChoosed(0, false);
                    this.loU.setViewChoosed(3, false);
                    this.loM.Ey(1);
                    this.loU.setViewVisibility(0, 8);
                    this.loU.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.loU.setViewVisibility(0, 0);
                    this.loU.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.hqc = i;
            this.loM.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().af("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dcZ() {
        if (this.lna.getStatus() == 1 && !this.loM.ddC()) {
            Z(1, true);
            this.lpk.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void dcY() {
        if (this.lna.getStatus() == 1 && !this.loM.ddC()) {
            Z(2, true);
            this.lpk.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ew(int i) {
        if (this.kTI != null) {
            this.kTI.bf(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, String str) {
        if (this.kTI != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.kTI.be(i, str);
        }
    }
}
