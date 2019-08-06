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
import com.baidu.mobstat.Config;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private int fLJ;
    private final CustomMessageListener fNv;
    private ImageView glR;
    private i jAW;
    private b jBO;
    protected h jBe;
    private RecordLayout jCG;
    private VideoControllerLayout jCH;
    private RelativeLayout jCI;
    private ImageView jCJ;
    private ImageView jCK;
    private ImageView jCL;
    private com.baidu.tbadk.core.dialog.a jCM;
    private PreviewViewContainer jCN;
    private TextView jCO;
    private VideoEffectButtonLayout jCP;
    private TextView jCQ;
    private View jCR;
    private RoundProgressBar jCS;
    private TextView jCT;
    private AnimatorSet jCU;
    private AnimatorSet jCV;
    private ScaleAnimation jCW;
    private ObjectAnimator jCX;
    private ObjectAnimator jCY;
    private int jCZ;
    private ForumWriteData jDa;
    private boolean jDb;
    private boolean jDc = true;
    private l jDd;
    private StickerItem jDe;
    protected j jDf;
    private RecordTabLayout jDg;
    private ImageFileInfo jDh;
    private HttpMessageListener jDi;
    private boolean jDj;
    private com.baidu.tieba.j.h jhv;
    private String jwm;
    private SelectMusicModel jwq;
    private b.a jzC;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jhv = lVar.bPk();
        }
        if (this.jhv != null) {
            this.jhv.bOO();
        }
        this.jzC = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eq(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.aa(list)) {
                    if (RecordVideoActivity.this.jCH != null) {
                        RecordVideoActivity.this.jCH.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jCH != null) {
                    RecordVideoActivity.this.jCH.setHasLocalVideo(true);
                    RecordVideoActivity.this.jDc = false;
                }
            }
        };
        this.jDi = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jCH != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jCH.setStickerItems(list);
                    }
                }
            }
        };
        this.fNv = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwN() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jBe.jws);
        videoInfo.setVideoDuration(this.jAW.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jBe.jws).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jDa == null ? "" : this.jDa.forumName;
        String str2 = this.jDa == null ? "" : this.jDa.forumId;
        int i = this.jDa == null ? -1 : this.jDa.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jDa.writeCallFrom, str, str2, this.jwm, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jDf != null) {
            this.jDf.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.jhv != null) {
            this.jhv.bOR();
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
        if (this.jAW != null && this.jAW.alC()) {
            this.jAW.stopRecord();
        }
        if (this.jwq != null) {
            this.jwq.cancelLoadData();
        }
        if (this.jhv != null) {
            this.jhv.Ba("record");
        }
        com.baidu.tbadk.core.util.m.A(new File(com.baidu.tieba.video.c.juG));
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
        this.jCZ = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jDa = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.jwm = getIntent().getStringExtra("video_title");
        initUI();
        this.jwq = new SelectMusicModel(getPageContext(), this.jCH);
        this.jwq.cvb();
        this.jDf = new j(this);
        this.jDf.b(this.jwq);
        this.jAW.a(this.jDf);
        registerListener(this.jDi);
        registerListener(this.fNv);
        cwO();
    }

    private void cwO() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cvE() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jzC);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jCG = (RecordLayout) findViewById(R.id.root_layout);
        this.jCG.setListener(this);
        this.jAW = new i(this);
        this.jCH = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jCH.setRecordController(this.jAW);
        this.jCH.setRecordControlListener(this);
        this.jCH.setEffectChoosedListener(this);
        this.jCI = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.glR = (ImageView) findViewById(R.id.close_page);
        this.glR.setOnClickListener(this);
        this.jCJ = (ImageView) findViewById(R.id.flash_switch);
        this.jCJ.setOnClickListener(this);
        this.jCK = (ImageView) findViewById(R.id.camera_switch);
        this.jCK.setOnClickListener(this);
        this.jCL = (ImageView) findViewById(R.id.count_down);
        this.jCL.setOnClickListener(this);
        this.jCN = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jBe = new h(this);
        this.jBe.a(this);
        this.jBe.setFaceIdentifyStateListener(this);
        this.jBe.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cwB() {
                if (RecordVideoActivity.this.jCH.cxn()) {
                    RecordVideoActivity.this.jCH.a((m) null);
                }
            }
        });
        this.jCP = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jCP.setListener(this);
        this.jAW.a(this.jCP);
        this.jCP.setViewChoosed(2, true);
        this.jCO = (TextView) findViewById(R.id.tv_count_down);
        this.jCQ = (TextView) findViewById(R.id.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds150);
        if (this.jCO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jCO.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jCP.setVisibility(8);
        }
        this.jCR = findViewById(R.id.progress_layout);
        this.jCS = (RoundProgressBar) this.jCR.findViewById(R.id.video_progress);
        this.jCT = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jCT.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds38);
        this.jCT.setLayoutParams(layoutParams);
        this.jDg = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jDg.aM(1, getString(R.string.tab_photo));
        if (this.jCZ != 2 && this.jCZ != 3) {
            this.jDg.aM(2, getString(R.string.tab_record));
            this.jDg.setListener(this);
            this.jDg.setCurrentTab(2, false);
            T(2, false);
        } else {
            this.jDg.setShowIndicator(false);
            this.jDg.setCurrentTab(1, false);
            T(1, false);
        }
        cwP();
    }

    private void cwP() {
        if (com.baidu.tbadk.core.util.g.ahZ()) {
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
        this.jBe.onResume();
        this.jBO = this.jBe.cws();
        if (this.jBO != null) {
            this.jBO.setRecordController(this.jAW);
            this.jCN.setZoomHelper(this.jBO);
        }
        cwQ();
        if (this.jDd == null) {
            this.jDd = new l();
            this.jDd.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void es(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jDe, str2);
                    if (RecordVideoActivity.this.jCH != null) {
                        RecordVideoActivity.this.jCH.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void FF(String str) {
                    if (RecordVideoActivity.this.jCH != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jCH.b(stickerItem);
                        if (RecordVideoActivity.this.jBe != null) {
                            RecordVideoActivity.this.jBe.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jCH != null) {
                        RecordVideoActivity.this.jCH.setDownLoadSticker(null);
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
                    recordVideoActivity.av(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void cuj() {
                    if (RecordVideoActivity.this.jCH != null) {
                        RecordVideoActivity.this.jCH.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jDd.cxh();
        if (this.jCH != null && this.jDc) {
            cvE();
        }
        if (this.jhv != null) {
            this.jhv.AZ("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jBe.onPause();
        if (this.jCH != null) {
            if (this.jAW != null && this.jAW.getStatus() == 6) {
                this.jCH.stopRecord();
                cwZ();
            }
            if (this.jAW != null && this.jAW.alC()) {
                this.jCH.stopRecord();
            }
        }
        if (this.jDf != null) {
            this.jDf.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jAW == null || this.jAW.getStatus() != 7) {
            if (this.jAW != null && this.jAW.getStatus() == 6) {
                if (this.jCH != null) {
                    this.jCH.stopRecord();
                }
                cwZ();
            } else if (this.jAW.onBackPressed()) {
                finish();
            } else {
                if (this.jCM == null) {
                    this.jCM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jCM.hu(R.string.video_quit_confirm);
                    this.jCM.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jCM.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jCM.dQ(true);
                    this.jCM.b(getPageContext());
                }
                this.jCM.agK();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jCT.setVisibility(4);
        if (view == this.glR) {
            onBackPressed();
        } else if (view == this.jCJ) {
            if (this.jAW.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jBe.cwv();
            cwQ();
        } else if (view == this.jCK) {
            if (this.jAW.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jCK.setOnClickListener(null);
            this.jBe.cwx();
            if (this.jBe.cwy() && this.jBe.cww()) {
                this.jBe.cwv();
            }
            cwQ();
            this.jCK.setOnClickListener(this);
        } else if (view == this.jCL) {
            cwS();
        }
    }

    private void cwQ() {
        if (this.jBe.cwy()) {
            this.jCJ.setVisibility(8);
        } else {
            this.jCJ.setVisibility(0);
        }
        if (this.jBe.cww()) {
            this.jCJ.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jCJ.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cwR() {
        return this.jCN;
    }

    public void cwS() {
        this.jCT.setVisibility(4);
        if (this.jAW.getStatus() != 6) {
            this.jAW.setStatus(6);
            cwX();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jCW == null) {
                this.jCW = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jCW.setDuration(500L);
                this.jCW.setRepeatCount(5);
                this.jCW.setRepeatMode(2);
                this.jCW.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jCW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jAW.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jCO.setVisibility(0);
                        RecordVideoActivity.this.jCO.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jCO.setVisibility(8);
                    if (RecordVideoActivity.this.jAW.getStatus() == 6) {
                        RecordVideoActivity.this.jCH.cxk();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jAW.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jCO.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jCO.setText("");
                        }
                    }
                }
            });
            this.jCO.setAnimation(this.jCW);
            this.jCW.startNow();
            this.jCH.cwS();
            if (this.jDf != null) {
                this.jDf.cwM();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwT() {
        if (this.jAW.getStatus() == 1) {
            this.jCT.setVisibility(4);
            if (this.jAW.getStatus() != 6) {
                this.jCH.cwT();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwU() {
        this.jCT.setVisibility(4);
        if (this.jAW.getStatus() != 6) {
            this.jCH.cwU();
            if (this.jCH.cxo()) {
                cwO();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwV() {
        this.jCT.setVisibility(4);
        if (this.jAW.getStatus() != 6) {
            this.jCH.cwV();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cwW() {
        this.jCT.setVisibility(4);
        if (this.jAW.getStatus() != 6) {
            this.jCH.cwW();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwX() {
        this.jDb = true;
        if (this.jCV != null && this.jCV.isRunning()) {
            this.jCV.cancel();
        }
        if (this.jCU == null) {
            this.jCU = new AnimatorSet();
            this.jCU.playTogether(ObjectAnimator.ofFloat(this.jCI, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jCP, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jDg, "alpha", 1.0f, 0.0f));
            this.jCU.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jEH) {
                        RecordVideoActivity.this.jCI.setVisibility(8);
                        RecordVideoActivity.this.jCP.setVisibility(8);
                        RecordVideoActivity.this.jDg.setVisibility(8);
                    }
                }
            });
            this.jCU.setDuration(300L);
        }
        this.jCU.start();
        this.jCP.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwM() {
        if (this.fLJ == 2) {
            if (this.jDb) {
                this.jDb = false;
                if (this.jDf != null) {
                    this.jDf.cwM();
                }
            } else {
                return;
            }
        }
        if (this.jCU != null && this.jCU.isRunning()) {
            this.jCU.cancel();
        }
        if (this.jCV == null) {
            this.jCV = new AnimatorSet();
            this.jCV.playTogether(ObjectAnimator.ofFloat(this.jCI, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jCP, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jDg, "alpha", 0.0f, 1.0f));
            this.jCV.setDuration(300L);
        }
        this.jCI.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jCP.setVisibility(0);
        }
        if (this.jAW.getStatus() == 1) {
            this.jDg.setVisibility(0);
        }
        this.jCV.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwY() {
        if (this.jBe != null) {
            this.jBe.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jAW.setStatus(1);
                    RecordVideoActivity.this.cwM();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jDh != null && !v.aa(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jDh)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jDh);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jDh = new ImageFileInfo();
                        RecordVideoActivity.this.jDh.setFilePath(str);
                        RecordVideoActivity.this.jDh.setTempFile(true);
                        RecordVideoActivity.this.jDh.setAlbumnId(null);
                        RecordVideoActivity.this.jDh.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jDh);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), 12012, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jDa, RecordVideoActivity.this.jCZ)));
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra(AlbumActivityConfig.ALBUM_RESULT, RecordVideoActivity.this.mWriteImagesInfo.toJsonString());
                        RecordVideoActivity.this.setResult(-1, intent);
                        RecordVideoActivity.this.finish();
                        ActivityPendingTransitionFactory.closeAnimation(RecordVideoActivity.this.getPageContext(), 0);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cwZ() {
        this.jCW.cancel();
        this.jCW.setAnimationListener(null);
        this.jCO.clearAnimation();
        this.jCO.setVisibility(8);
        if (this.jDf != null) {
            this.jDf.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxa() {
        coi();
    }

    private void coi() {
        if (this.jCX != null) {
            this.jCX.cancel();
        }
        if (this.jCY == null) {
            this.jCY = ObjectAnimator.ofFloat(this.jDg, "alpha", 1.0f, 0.0f);
            this.jCY.setDuration(500L);
            this.jCY.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jEH) {
                        RecordVideoActivity.this.jDg.setVisibility(8);
                    }
                }
            });
        }
        this.jCY.start();
    }

    private void coh() {
        if (this.jCY != null) {
            this.jCY.cancel();
        }
        if (this.jCX == null) {
            this.jCX = ObjectAnimator.ofFloat(this.jDg, "alpha", 0.0f, 1.0f);
            this.jCX.setDuration(500L);
        }
        this.jDg.setVisibility(0);
        this.jCX.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxb() {
        this.jCP.reset();
        if (this.jAW.getStatus() == 1) {
            coh();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxc() {
        if (this.jCR.getVisibility() != 0) {
            this.jCH.cxj();
            this.jAW.setStatus(8);
            cwM();
            if (this.jBe.jBM != null && this.jBe.jBM.size() > 0) {
                this.jCR.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jDl = 50;
        final int jDm = 1;
        Handler jDn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jCS.aU(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cxg();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cxg() {
            this.jDn.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cxg();
            boolean z = RecordVideoActivity.this.jDf == null || TextUtils.isEmpty(RecordVideoActivity.this.jDf.cwL()) || !new File(RecordVideoActivity.this.jDf.cwL()).exists();
            if (RecordVideoActivity.this.jBe.jBM.size() > 1) {
                return com.baidu.tieba.video.meida.h.cvY().a(RecordVideoActivity.this.jBe.jBM, RecordVideoActivity.this.jBe.cwp(), z);
            }
            File file = new File(RecordVideoActivity.this.jBe.jBM.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.c(file, new File(RecordVideoActivity.this.jBe.cwp()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cvY().a(RecordVideoActivity.this.jBe.jBM, RecordVideoActivity.this.jBe.cwp(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jCH.cxp();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cwN();
                    RecordVideoActivity.this.Cu(102);
                    RecordVideoActivity.this.jCR.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cwN();
                RecordVideoActivity.this.Cu(102);
                RecordVideoActivity.this.jCR.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.jCR.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jCS.aU(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jCH == null || v.aa(this.jCH.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jCH.getChoosedBeautyList()) {
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
        if (this.jCH == null || v.aa(this.jCH.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jCH.getChoosedFilterList()) {
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
        if (this.jCH == null || v.aa(this.jCH.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jCH.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxd() {
        this.jCT.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxe() {
        this.jCT.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxf() {
        if (this.jAW.getStatus() == 1) {
            this.jDg.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jBe != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jBe.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").P(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jCP.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jCP.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jBe.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jAW.getStatus() == 1) {
                            anVar.P("obj_type", 1);
                        } else {
                            anVar.P("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jCP.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jCP.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jDf.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jCP.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jCP.setViewChoosed(0, true);
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
            this.jDe = stickerItem;
            this.jDd.Gg(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jBe != null) {
                    this.jBe.setSticker(null);
                    this.jDj = false;
                }
                if (this.jCH != null) {
                    this.jCH.setDownLoadSticker(null);
                }
                this.jCQ.setVisibility(8);
                this.jCP.setViewChoosed(1, false);
                return;
            }
            String Gd = this.jDd.Gd(stickerItem.resource);
            if (!StringUtils.isNull(Gd)) {
                a(stickerItem, Gd);
                if (this.jCH != null) {
                    this.jCH.setDownLoadSticker(null);
                }
            } else {
                if (this.jCH != null) {
                    this.jCH.setDownLoadSticker(stickerItem);
                }
                this.jDd.Ge(stickerItem.resource);
            }
            this.jCP.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jBe != null) {
                this.jBe.setSticker(stickerItem);
                this.jDj = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jCQ.setText(stickerItem.desc);
                this.jCQ.setVisibility(0);
                this.jCQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jCQ.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jCQ.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cI(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.v(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jCH.getLayoutParams();
            layoutParams.height = i4;
            this.jCH.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String FN = com.baidu.tieba.video.editvideo.model.a.cuV().FN(stringExtra);
                if (this.jDf != null && !TextUtils.isEmpty(FN)) {
                    this.jDf.et(FN, stringExtra2);
                    this.jCH.cwd();
                }
            }
        } else if (i == 12012 && i2 == -1) {
            Intent intent2 = new Intent();
            if (intent != null) {
                intent2.putExtra(AlbumActivityConfig.ALBUM_RESULT, intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT));
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
        if (this.jAW.getStatus() == 8) {
            this.jCH.cxi();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void rM(boolean z) {
        if (this.jAW != null && (this.jAW.getStatus() == 1 || this.jAW.getStatus() == 3 || this.jAW.getStatus() == 4)) {
            if (!z && this.jDj) {
                this.jCN.aUY();
                return;
            } else {
                this.jCN.aUZ();
                return;
            }
        }
        this.jCN.aUZ();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void T(int i, boolean z) {
        int i2 = 1;
        if (this.fLJ != i) {
            switch (i) {
                case 1:
                    if (this.jDf != null) {
                        this.jDf.aBC();
                    }
                    this.jBe.setFilter("origin");
                    this.jCP.setViewChoosed(0, false);
                    this.jCP.setViewChoosed(3, false);
                    this.jCH.Cw(1);
                    this.jCP.setViewVisibility(0, 8);
                    this.jCP.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jCP.setViewVisibility(0, 0);
                    this.jCP.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fLJ = i;
            this.jCH.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().P("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cwK() {
        if (this.jAW.getStatus() == 1 && !this.jCH.cxn()) {
            T(1, true);
            this.jDg.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cwJ() {
        if (this.jAW.getStatus() == 1 && !this.jCH.cxn()) {
            T(2, true);
            this.jDg.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cu(int i) {
        if (this.jhv != null) {
            this.jhv.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.jhv != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.jhv.av(i, str);
        }
    }
}
