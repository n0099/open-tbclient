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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public class RecordVideoActivity extends BaseActivity implements GLVideoPreviewView.a, RecordLayout.a, RecordTabLayout.a, VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.c {
    private View atn;
    private int fMa;
    private final CustomMessageListener fNN;
    private ImageView gmq;
    private b.a jAZ;
    protected h jCB;
    private i jCt;
    private b jDk;
    protected j jEA;
    private RecordTabLayout jEB;
    private ImageFileInfo jEC;
    private HttpMessageListener jED;
    private boolean jEE;
    private RecordLayout jEc;
    private VideoControllerLayout jEd;
    private RelativeLayout jEe;
    private ImageView jEf;
    private ImageView jEg;
    private ImageView jEh;
    private com.baidu.tbadk.core.dialog.a jEi;
    private PreviewViewContainer jEj;
    private TextView jEk;
    private VideoEffectButtonLayout jEl;
    private TextView jEm;
    private RoundProgressBar jEn;
    private TextView jEo;
    private AnimatorSet jEp;
    private AnimatorSet jEq;
    private ScaleAnimation jEr;
    private ObjectAnimator jEs;
    private ObjectAnimator jEt;
    private int jEu;
    private ForumWriteData jEv;
    private boolean jEw;
    private boolean jEx = true;
    private l jEy;
    private StickerItem jEz;
    private com.baidu.tieba.j.h jiP;
    private String jxJ;
    private SelectMusicModel jxN;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jiP = lVar.bMW();
        }
        if (this.jiP != null) {
            this.jiP.bMz();
        }
        this.jAZ = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eD(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.jEd != null) {
                        RecordVideoActivity.this.jEd.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jEd != null) {
                    RecordVideoActivity.this.jEd.setHasLocalVideo(true);
                    RecordVideoActivity.this.jEx = false;
                }
            }
        };
        this.jED = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jEd != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jEd.setStickerItems(list);
                    }
                }
            }
        };
        this.fNN = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cvp() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jCB.jxP);
        videoInfo.setVideoDuration(this.jCt.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jCB.jxP).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jEv == null ? "" : this.jEv.forumName;
        String str2 = this.jEv == null ? "" : this.jEv.forumId;
        int i = this.jEv == null ? -1 : this.jEv.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jEv.writeCallFrom, str, str2, this.jxJ, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.jEA != null) {
            this.jEA.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.jiP != null) {
            this.jiP.bMC();
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
        if (this.jCt != null && this.jCt.aoA()) {
            this.jCt.stopRecord();
        }
        if (this.jxN != null) {
            this.jxN.cancelLoadData();
        }
        if (this.jiP != null) {
            this.jiP.zT("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.jwd));
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
        this.jEu = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jEv = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.jxJ = getIntent().getStringExtra("video_title");
        initUI();
        this.jxN = new SelectMusicModel(getPageContext(), this.jEd);
        this.jxN.ctB();
        this.jEA = new j(this);
        this.jEA.b(this.jxN);
        this.jCt.a(this.jEA);
        registerListener(this.jED);
        registerListener(this.fNN);
        cvq();
    }

    private void cvq() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cue() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jAZ);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jEc = (RecordLayout) findViewById(R.id.root_layout);
        this.jEc.setListener(this);
        this.jCt = new i(this);
        this.jEd = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jEd.setRecordController(this.jCt);
        this.jEd.setRecordControlListener(this);
        this.jEd.setEffectChoosedListener(this);
        this.jEe = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gmq = (ImageView) findViewById(R.id.close_page);
        this.gmq.setOnClickListener(this);
        this.jEf = (ImageView) findViewById(R.id.flash_switch);
        this.jEf.setOnClickListener(this);
        this.jEg = (ImageView) findViewById(R.id.camera_switch);
        this.jEg.setOnClickListener(this);
        this.jEh = (ImageView) findViewById(R.id.count_down);
        this.jEh.setOnClickListener(this);
        this.jEj = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jCB = new h(this);
        this.jCB.a(this);
        this.jCB.setFaceIdentifyStateListener(this);
        this.jCB.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cvb() {
                if (RecordVideoActivity.this.jEd.cvP()) {
                    RecordVideoActivity.this.jEd.a((m) null);
                }
            }
        });
        this.jEl = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jEl.setListener(this);
        this.jCt.a(this.jEl);
        this.jEl.setViewChoosed(2, true);
        this.jEk = (TextView) findViewById(R.id.tv_count_down);
        this.jEm = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.jEk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jEk.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jEl.setVisibility(8);
        }
        this.atn = findViewById(R.id.progress_layout);
        this.jEn = (RoundProgressBar) this.atn.findViewById(R.id.video_progress);
        this.jEo = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jEo.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.jEo.setLayoutParams(layoutParams);
        this.jEB = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jEB.aM(1, getString(R.string.tab_photo));
        if (this.jEu != 2 && this.jEu != 3) {
            this.jEB.aM(2, getString(R.string.tab_record));
            this.jEB.setListener(this);
            this.jEB.setCurrentTab(2, false);
            S(2, false);
        } else {
            this.jEB.setShowIndicator(false);
            this.jEB.setCurrentTab(1, false);
            S(1, false);
        }
        cvr();
    }

    private void cvr() {
        if (com.baidu.tbadk.core.util.g.alV()) {
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
        this.jCB.onResume();
        this.jDk = this.jCB.cuS();
        if (this.jDk != null) {
            this.jDk.setRecordController(this.jCt);
            this.jEj.setZoomHelper(this.jDk);
        }
        cvs();
        if (this.jEy == null) {
            this.jEy = new l();
            this.jEy.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ef(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jEz, str2);
                    if (RecordVideoActivity.this.jEd != null) {
                        RecordVideoActivity.this.jEd.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void EH(String str) {
                    if (RecordVideoActivity.this.jEd != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jEd.b(stickerItem);
                        if (RecordVideoActivity.this.jCB != null) {
                            RecordVideoActivity.this.jCB.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jEd != null) {
                        RecordVideoActivity.this.jEd.setDownLoadSticker(null);
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
                    recordVideoActivity.au(5, str);
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void csK() {
                    if (RecordVideoActivity.this.jEd != null) {
                        RecordVideoActivity.this.jEd.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jEy.cvJ();
        if (this.jEd != null && this.jEx) {
            cue();
        }
        if (this.jiP != null) {
            this.jiP.zS("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jCB.onPause();
        if (this.jEd != null) {
            if (this.jCt != null && this.jCt.getStatus() == 6) {
                this.jEd.stopRecord();
                cvB();
            }
            if (this.jCt != null && this.jCt.aoA()) {
                this.jEd.stopRecord();
            }
        }
        if (this.jEA != null) {
            this.jEA.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jCt == null || this.jCt.getStatus() != 7) {
            if (this.jCt != null && this.jCt.getStatus() == 6) {
                if (this.jEd != null) {
                    this.jEd.stopRecord();
                }
                cvB();
            } else if (this.jCt.onBackPressed()) {
                finish();
            } else {
                if (this.jEi == null) {
                    this.jEi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jEi.hT(R.string.video_quit_confirm);
                    this.jEi.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jEi.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jEi.eg(true);
                    this.jEi.b(getPageContext());
                }
                this.jEi.akM();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jEo.setVisibility(4);
        if (view == this.gmq) {
            onBackPressed();
        } else if (view == this.jEf) {
            if (this.jCt.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jCB.cuV();
            cvs();
        } else if (view == this.jEg) {
            if (this.jCt.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jEg.setOnClickListener(null);
            this.jCB.cuX();
            if (this.jCB.cuY() && this.jCB.cuW()) {
                this.jCB.cuV();
            }
            cvs();
            this.jEg.setOnClickListener(this);
        } else if (view == this.jEh) {
            cvu();
        }
    }

    private void cvs() {
        if (this.jCB.cuY()) {
            this.jEf.setVisibility(8);
        } else {
            this.jEf.setVisibility(0);
        }
        if (this.jCB.cuW()) {
            this.jEf.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jEf.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cvt() {
        return this.jEj;
    }

    public void cvu() {
        this.jEo.setVisibility(4);
        if (this.jCt.getStatus() != 6) {
            this.jCt.setStatus(6);
            cvz();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jEr == null) {
                this.jEr = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jEr.setDuration(500L);
                this.jEr.setRepeatCount(5);
                this.jEr.setRepeatMode(2);
                this.jEr.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jEr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jCt.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jEk.setVisibility(0);
                        RecordVideoActivity.this.jEk.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jEk.setVisibility(8);
                    if (RecordVideoActivity.this.jCt.getStatus() == 6) {
                        RecordVideoActivity.this.jEd.cvM();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jCt.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jEk.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jEk.setText("");
                        }
                    }
                }
            });
            this.jEk.setAnimation(this.jEr);
            this.jEr.startNow();
            this.jEd.cvu();
            if (this.jEA != null) {
                this.jEA.cvo();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvv() {
        if (this.jCt.getStatus() == 1) {
            this.jEo.setVisibility(4);
            if (this.jCt.getStatus() != 6) {
                this.jEd.cvv();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvw() {
        this.jEo.setVisibility(4);
        if (this.jCt.getStatus() != 6) {
            this.jEd.cvw();
            if (this.jEd.cvQ()) {
                cvq();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvx() {
        this.jEo.setVisibility(4);
        if (this.jCt.getStatus() != 6) {
            this.jEd.cvx();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvy() {
        this.jEo.setVisibility(4);
        if (this.jCt.getStatus() != 6) {
            this.jEd.cvy();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvz() {
        this.jEw = true;
        if (this.jEq != null && this.jEq.isRunning()) {
            this.jEq.cancel();
        }
        if (this.jEp == null) {
            this.jEp = new AnimatorSet();
            this.jEp.playTogether(ObjectAnimator.ofFloat(this.jEe, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jEl, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jEB, "alpha", 1.0f, 0.0f));
            this.jEp.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGc) {
                        RecordVideoActivity.this.jEe.setVisibility(8);
                        RecordVideoActivity.this.jEl.setVisibility(8);
                        RecordVideoActivity.this.jEB.setVisibility(8);
                    }
                }
            });
            this.jEp.setDuration(300L);
        }
        this.jEp.start();
        this.jEl.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvo() {
        if (this.fMa == 2) {
            if (this.jEw) {
                this.jEw = false;
                if (this.jEA != null) {
                    this.jEA.cvo();
                }
            } else {
                return;
            }
        }
        if (this.jEp != null && this.jEp.isRunning()) {
            this.jEp.cancel();
        }
        if (this.jEq == null) {
            this.jEq = new AnimatorSet();
            this.jEq.playTogether(ObjectAnimator.ofFloat(this.jEe, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jEl, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jEB, "alpha", 0.0f, 1.0f));
            this.jEq.setDuration(300L);
        }
        this.jEe.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jEl.setVisibility(0);
        }
        if (this.jCt.getStatus() == 1) {
            this.jEB.setVisibility(0);
        }
        this.jEq.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvA() {
        if (this.jCB != null) {
            this.jCB.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jCt.setStatus(1);
                    RecordVideoActivity.this.cvo();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jEC != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jEC)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jEC);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jEC = new ImageFileInfo();
                        RecordVideoActivity.this.jEC.setFilePath(str);
                        RecordVideoActivity.this.jEC.setTempFile(true);
                        RecordVideoActivity.this.jEC.setAlbumnId(null);
                        RecordVideoActivity.this.jEC.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jEC);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jEv, RecordVideoActivity.this.jEu)));
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
    public void cvB() {
        this.jEr.cancel();
        this.jEr.setAnimationListener(null);
        this.jEk.clearAnimation();
        this.jEk.setVisibility(8);
        if (this.jEA != null) {
            this.jEA.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvC() {
        cmJ();
    }

    private void cmJ() {
        if (this.jEs != null) {
            this.jEs.cancel();
        }
        if (this.jEt == null) {
            this.jEt = ObjectAnimator.ofFloat(this.jEB, "alpha", 1.0f, 0.0f);
            this.jEt.setDuration(500L);
            this.jEt.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGc) {
                        RecordVideoActivity.this.jEB.setVisibility(8);
                    }
                }
            });
        }
        this.jEt.start();
    }

    private void cmI() {
        if (this.jEt != null) {
            this.jEt.cancel();
        }
        if (this.jEs == null) {
            this.jEs = ObjectAnimator.ofFloat(this.jEB, "alpha", 0.0f, 1.0f);
            this.jEs.setDuration(500L);
        }
        this.jEB.setVisibility(0);
        this.jEs.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvD() {
        this.jEl.reset();
        if (this.jCt.getStatus() == 1) {
            cmI();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvE() {
        if (this.atn.getVisibility() != 0) {
            this.jEd.cvL();
            this.jCt.setStatus(8);
            cvo();
            if (this.jCB.jDi != null && this.jCB.jDi.size() > 0) {
                this.atn.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jEG = 50;
        final int jEH = 1;
        Handler jEI = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jEn.ay(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cvI();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cvI() {
            this.jEI.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cvI();
            boolean z = RecordVideoActivity.this.jEA == null || TextUtils.isEmpty(RecordVideoActivity.this.jEA.cvn()) || !new File(RecordVideoActivity.this.jEA.cvn()).exists();
            if (RecordVideoActivity.this.jCB.jDi.size() > 1) {
                return com.baidu.tieba.video.meida.h.cuy().a(RecordVideoActivity.this.jCB.jDi, RecordVideoActivity.this.jCB.cuP(), z);
            }
            File file = new File(RecordVideoActivity.this.jCB.jDi.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.copyFile(file, new File(RecordVideoActivity.this.jCB.cuP()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cuy().a(RecordVideoActivity.this.jCB.jDi, RecordVideoActivity.this.jCB.cuP(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jEd.cvR();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cvp();
                    RecordVideoActivity.this.Bd(102);
                    RecordVideoActivity.this.atn.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cvp();
                RecordVideoActivity.this.Bd(102);
                RecordVideoActivity.this.atn.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.atn.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.au(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jEn.ay(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jEd == null || v.isEmpty(this.jEd.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jEd.getChoosedBeautyList()) {
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
        if (this.jEd == null || v.isEmpty(this.jEd.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jEd.getChoosedFilterList()) {
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
        if (this.jEd == null || v.isEmpty(this.jEd.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jEd.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvF() {
        this.jEo.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvG() {
        this.jEo.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvH() {
        if (this.jCt.getStatus() == 1) {
            this.jEB.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jCB != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jCB.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").O("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jEl.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jEl.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jCB.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.bS("obj_id", (String) eVar.getValue());
                        if (this.jCt.getStatus() == 1) {
                            anVar.O("obj_type", 1);
                        } else {
                            anVar.O("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jEl.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jEl.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jEA.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jEl.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jEl.setViewChoosed(0, true);
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
            this.jEz = stickerItem;
            this.jEy.Fi(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jCB != null) {
                    this.jCB.setSticker(null);
                    this.jEE = false;
                }
                if (this.jEd != null) {
                    this.jEd.setDownLoadSticker(null);
                }
                this.jEm.setVisibility(8);
                this.jEl.setViewChoosed(1, false);
                return;
            }
            String Ff = this.jEy.Ff(stickerItem.resource);
            if (!StringUtils.isNull(Ff)) {
                a(stickerItem, Ff);
                if (this.jEd != null) {
                    this.jEd.setDownLoadSticker(null);
                }
            } else {
                if (this.jEd != null) {
                    this.jEd.setDownLoadSticker(stickerItem);
                }
                this.jEy.Fg(stickerItem.resource);
            }
            this.jEl.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jCB != null) {
                this.jCB.setSticker(stickerItem);
                this.jEE = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jEm.setText(stickerItem.desc);
                this.jEm.setVisibility(0);
                this.jEm.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jEm.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jEm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cy(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jEd.getLayoutParams();
            layoutParams.height = i4;
            this.jEd.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EP = com.baidu.tieba.video.editvideo.model.a.ctv().EP(stringExtra);
                if (this.jEA != null && !TextUtils.isEmpty(EP)) {
                    this.jEA.eg(EP, stringExtra2);
                    this.jEd.cuD();
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
        if (this.jCt.getStatus() == 8) {
            this.jEd.cvK();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void ry(boolean z) {
        if (this.jCt != null && (this.jCt.getStatus() == 1 || this.jCt.getStatus() == 3 || this.jCt.getStatus() == 4)) {
            if (!z && this.jEE) {
                this.jEj.cvc();
                return;
            } else {
                this.jEj.cvd();
                return;
            }
        }
        this.jEj.cvd();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void S(int i, boolean z) {
        int i2 = 1;
        if (this.fMa != i) {
            switch (i) {
                case 1:
                    if (this.jEA != null) {
                        this.jEA.aBY();
                    }
                    this.jCB.setFilter("origin");
                    this.jEl.setViewChoosed(0, false);
                    this.jEl.setViewChoosed(3, false);
                    this.jEd.Bf(1);
                    this.jEl.setViewVisibility(0, 8);
                    this.jEl.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jEl.setViewVisibility(0, 0);
                    this.jEl.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fMa = i;
            this.jEd.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().O("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cvm() {
        if (this.jCt.getStatus() == 1 && !this.jEd.cvP()) {
            S(1, true);
            this.jEB.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cvl() {
        if (this.jCt.getStatus() == 1 && !this.jEd.cvP()) {
            S(2, true);
            this.jEB.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd(int i) {
        if (this.jiP != null) {
            this.jiP.av(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(int i, String str) {
        if (this.jiP != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.jiP.au(i, str);
        }
    }
}
