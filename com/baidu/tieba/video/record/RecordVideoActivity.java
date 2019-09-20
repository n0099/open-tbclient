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
    private int fNy;
    private final CustomMessageListener fPk;
    private ImageView gnI;
    private b.a jBY;
    protected h jDA;
    private i jDs;
    private b jEk;
    private StickerItem jFA;
    protected j jFB;
    private RecordTabLayout jFC;
    private ImageFileInfo jFD;
    private HttpMessageListener jFE;
    private boolean jFF;
    private RecordLayout jFc;
    private VideoControllerLayout jFd;
    private RelativeLayout jFe;
    private ImageView jFf;
    private ImageView jFg;
    private ImageView jFh;
    private com.baidu.tbadk.core.dialog.a jFi;
    private PreviewViewContainer jFj;
    private TextView jFk;
    private VideoEffectButtonLayout jFl;
    private TextView jFm;
    private View jFn;
    private RoundProgressBar jFo;
    private TextView jFp;
    private AnimatorSet jFq;
    private AnimatorSet jFr;
    private ScaleAnimation jFs;
    private ObjectAnimator jFt;
    private ObjectAnimator jFu;
    private int jFv;
    private ForumWriteData jFw;
    private boolean jFx;
    private boolean jFy = true;
    private l jFz;
    private com.baidu.tieba.j.h jjR;
    private String jyI;
    private SelectMusicModel jyM;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjR = lVar.bPY();
        }
        if (this.jjR != null) {
            this.jjR.bPB();
        }
        this.jBY = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eq(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.aa(list)) {
                    if (RecordVideoActivity.this.jFd != null) {
                        RecordVideoActivity.this.jFd.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jFd != null) {
                    RecordVideoActivity.this.jFd.setHasLocalVideo(true);
                    RecordVideoActivity.this.jFy = false;
                }
            }
        };
        this.jFE = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jFd != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jFd.setStickerItems(list);
                    }
                }
            }
        };
        this.fPk = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cxB() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jDA.jyO);
        videoInfo.setVideoDuration(this.jDs.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jDA.jyO).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jFw == null ? "" : this.jFw.forumName;
        String str2 = this.jFw == null ? "" : this.jFw.forumId;
        int i = this.jFw == null ? -1 : this.jFw.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jFw.writeCallFrom, str, str2, this.jyI, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jFB != null) {
            this.jFB.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.jjR != null) {
            this.jjR.bPE();
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
        if (this.jDs != null && this.jDs.alO()) {
            this.jDs.stopRecord();
        }
        if (this.jyM != null) {
            this.jyM.cancelLoadData();
        }
        if (this.jjR != null) {
            this.jjR.Bz("record");
        }
        com.baidu.tbadk.core.util.m.A(new File(com.baidu.tieba.video.c.jxc));
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
        this.jFv = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jFw = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.jyI = getIntent().getStringExtra("video_title");
        initUI();
        this.jyM = new SelectMusicModel(getPageContext(), this.jFd);
        this.jyM.cvP();
        this.jFB = new j(this);
        this.jFB.b(this.jyM);
        this.jDs.a(this.jFB);
        registerListener(this.jFE);
        registerListener(this.fPk);
        cxC();
    }

    private void cxC() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cws() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jBY);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jFc = (RecordLayout) findViewById(R.id.root_layout);
        this.jFc.setListener(this);
        this.jDs = new i(this);
        this.jFd = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jFd.setRecordController(this.jDs);
        this.jFd.setRecordControlListener(this);
        this.jFd.setEffectChoosedListener(this);
        this.jFe = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gnI = (ImageView) findViewById(R.id.close_page);
        this.gnI.setOnClickListener(this);
        this.jFf = (ImageView) findViewById(R.id.flash_switch);
        this.jFf.setOnClickListener(this);
        this.jFg = (ImageView) findViewById(R.id.camera_switch);
        this.jFg.setOnClickListener(this);
        this.jFh = (ImageView) findViewById(R.id.count_down);
        this.jFh.setOnClickListener(this);
        this.jFj = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jDA = new h(this);
        this.jDA.a(this);
        this.jDA.setFaceIdentifyStateListener(this);
        this.jDA.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cxp() {
                if (RecordVideoActivity.this.jFd.cyb()) {
                    RecordVideoActivity.this.jFd.a((m) null);
                }
            }
        });
        this.jFl = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jFl.setListener(this);
        this.jDs.a(this.jFl);
        this.jFl.setViewChoosed(2, true);
        this.jFk = (TextView) findViewById(R.id.tv_count_down);
        this.jFm = (TextView) findViewById(R.id.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds150);
        if (this.jFk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jFk.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jFl.setVisibility(8);
        }
        this.jFn = findViewById(R.id.progress_layout);
        this.jFo = (RoundProgressBar) this.jFn.findViewById(R.id.video_progress);
        this.jFp = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jFp.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds38);
        this.jFp.setLayoutParams(layoutParams);
        this.jFC = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jFC.aM(1, getString(R.string.tab_photo));
        if (this.jFv != 2 && this.jFv != 3) {
            this.jFC.aM(2, getString(R.string.tab_record));
            this.jFC.setListener(this);
            this.jFC.setCurrentTab(2, false);
            U(2, false);
        } else {
            this.jFC.setShowIndicator(false);
            this.jFC.setCurrentTab(1, false);
            U(1, false);
        }
        cxD();
    }

    private void cxD() {
        if (com.baidu.tbadk.core.util.g.aid()) {
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
        this.jDA.onResume();
        this.jEk = this.jDA.cxg();
        if (this.jEk != null) {
            this.jEk.setRecordController(this.jDs);
            this.jFj.setZoomHelper(this.jEk);
        }
        cxE();
        if (this.jFz == null) {
            this.jFz = new l();
            this.jFz.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void et(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jFA, str2);
                    if (RecordVideoActivity.this.jFd != null) {
                        RecordVideoActivity.this.jFd.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void Gf(String str) {
                    if (RecordVideoActivity.this.jFd != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jFd.b(stickerItem);
                        if (RecordVideoActivity.this.jDA != null) {
                            RecordVideoActivity.this.jDA.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jFd != null) {
                        RecordVideoActivity.this.jFd.setDownLoadSticker(null);
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
                public void cuX() {
                    if (RecordVideoActivity.this.jFd != null) {
                        RecordVideoActivity.this.jFd.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jFz.cxV();
        if (this.jFd != null && this.jFy) {
            cws();
        }
        if (this.jjR != null) {
            this.jjR.By("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jDA.onPause();
        if (this.jFd != null) {
            if (this.jDs != null && this.jDs.getStatus() == 6) {
                this.jFd.stopRecord();
                cxN();
            }
            if (this.jDs != null && this.jDs.alO()) {
                this.jFd.stopRecord();
            }
        }
        if (this.jFB != null) {
            this.jFB.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jDs == null || this.jDs.getStatus() != 7) {
            if (this.jDs != null && this.jDs.getStatus() == 6) {
                if (this.jFd != null) {
                    this.jFd.stopRecord();
                }
                cxN();
            } else if (this.jDs.onBackPressed()) {
                finish();
            } else {
                if (this.jFi == null) {
                    this.jFi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jFi.hv(R.string.video_quit_confirm);
                    this.jFi.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jFi.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jFi.dQ(true);
                    this.jFi.b(getPageContext());
                }
                this.jFi.agO();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jFp.setVisibility(4);
        if (view == this.gnI) {
            onBackPressed();
        } else if (view == this.jFf) {
            if (this.jDs.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jDA.cxj();
            cxE();
        } else if (view == this.jFg) {
            if (this.jDs.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jFg.setOnClickListener(null);
            this.jDA.cxl();
            if (this.jDA.cxm() && this.jDA.cxk()) {
                this.jDA.cxj();
            }
            cxE();
            this.jFg.setOnClickListener(this);
        } else if (view == this.jFh) {
            cxG();
        }
    }

    private void cxE() {
        if (this.jDA.cxm()) {
            this.jFf.setVisibility(8);
        } else {
            this.jFf.setVisibility(0);
        }
        if (this.jDA.cxk()) {
            this.jFf.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jFf.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cxF() {
        return this.jFj;
    }

    public void cxG() {
        this.jFp.setVisibility(4);
        if (this.jDs.getStatus() != 6) {
            this.jDs.setStatus(6);
            cxL();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jFs == null) {
                this.jFs = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jFs.setDuration(500L);
                this.jFs.setRepeatCount(5);
                this.jFs.setRepeatMode(2);
                this.jFs.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jFs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jDs.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jFk.setVisibility(0);
                        RecordVideoActivity.this.jFk.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jFk.setVisibility(8);
                    if (RecordVideoActivity.this.jDs.getStatus() == 6) {
                        RecordVideoActivity.this.jFd.cxY();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jDs.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jFk.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jFk.setText("");
                        }
                    }
                }
            });
            this.jFk.setAnimation(this.jFs);
            this.jFs.startNow();
            this.jFd.cxG();
            if (this.jFB != null) {
                this.jFB.cxA();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxH() {
        if (this.jDs.getStatus() == 1) {
            this.jFp.setVisibility(4);
            if (this.jDs.getStatus() != 6) {
                this.jFd.cxH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxI() {
        this.jFp.setVisibility(4);
        if (this.jDs.getStatus() != 6) {
            this.jFd.cxI();
            if (this.jFd.cyc()) {
                cxC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxJ() {
        this.jFp.setVisibility(4);
        if (this.jDs.getStatus() != 6) {
            this.jFd.cxJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cxK() {
        this.jFp.setVisibility(4);
        if (this.jDs.getStatus() != 6) {
            this.jFd.cxK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxL() {
        this.jFx = true;
        if (this.jFr != null && this.jFr.isRunning()) {
            this.jFr.cancel();
        }
        if (this.jFq == null) {
            this.jFq = new AnimatorSet();
            this.jFq.playTogether(ObjectAnimator.ofFloat(this.jFe, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jFl, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jFC, "alpha", 1.0f, 0.0f));
            this.jFq.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jHd) {
                        RecordVideoActivity.this.jFe.setVisibility(8);
                        RecordVideoActivity.this.jFl.setVisibility(8);
                        RecordVideoActivity.this.jFC.setVisibility(8);
                    }
                }
            });
            this.jFq.setDuration(300L);
        }
        this.jFq.start();
        this.jFl.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxA() {
        if (this.fNy == 2) {
            if (this.jFx) {
                this.jFx = false;
                if (this.jFB != null) {
                    this.jFB.cxA();
                }
            } else {
                return;
            }
        }
        if (this.jFq != null && this.jFq.isRunning()) {
            this.jFq.cancel();
        }
        if (this.jFr == null) {
            this.jFr = new AnimatorSet();
            this.jFr.playTogether(ObjectAnimator.ofFloat(this.jFe, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jFl, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jFC, "alpha", 0.0f, 1.0f));
            this.jFr.setDuration(300L);
        }
        this.jFe.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jFl.setVisibility(0);
        }
        if (this.jDs.getStatus() == 1) {
            this.jFC.setVisibility(0);
        }
        this.jFr.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxM() {
        if (this.jDA != null) {
            this.jDA.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jDs.setStatus(1);
                    RecordVideoActivity.this.cxA();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jFD != null && !v.aa(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jFD)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jFD);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jFD = new ImageFileInfo();
                        RecordVideoActivity.this.jFD.setFilePath(str);
                        RecordVideoActivity.this.jFD.setTempFile(true);
                        RecordVideoActivity.this.jFD.setAlbumnId(null);
                        RecordVideoActivity.this.jFD.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jFD);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), 12012, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jFw, RecordVideoActivity.this.jFv)));
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
    public void cxN() {
        this.jFs.cancel();
        this.jFs.setAnimationListener(null);
        this.jFk.clearAnimation();
        this.jFk.setVisibility(8);
        if (this.jFB != null) {
            this.jFB.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxO() {
        coV();
    }

    private void coV() {
        if (this.jFt != null) {
            this.jFt.cancel();
        }
        if (this.jFu == null) {
            this.jFu = ObjectAnimator.ofFloat(this.jFC, "alpha", 1.0f, 0.0f);
            this.jFu.setDuration(500L);
            this.jFu.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jHd) {
                        RecordVideoActivity.this.jFC.setVisibility(8);
                    }
                }
            });
        }
        this.jFu.start();
    }

    private void coU() {
        if (this.jFu != null) {
            this.jFu.cancel();
        }
        if (this.jFt == null) {
            this.jFt = ObjectAnimator.ofFloat(this.jFC, "alpha", 0.0f, 1.0f);
            this.jFt.setDuration(500L);
        }
        this.jFC.setVisibility(0);
        this.jFt.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxP() {
        this.jFl.reset();
        if (this.jDs.getStatus() == 1) {
            coU();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxQ() {
        if (this.jFn.getVisibility() != 0) {
            this.jFd.cxX();
            this.jDs.setStatus(8);
            cxA();
            if (this.jDA.jEi != null && this.jDA.jEi.size() > 0) {
                this.jFn.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jFH = 50;
        final int jFI = 1;
        Handler jFJ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jFo.aV(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cxU();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cxU() {
            this.jFJ.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cxU();
            boolean z = RecordVideoActivity.this.jFB == null || TextUtils.isEmpty(RecordVideoActivity.this.jFB.cxz()) || !new File(RecordVideoActivity.this.jFB.cxz()).exists();
            if (RecordVideoActivity.this.jDA.jEi.size() > 1) {
                return com.baidu.tieba.video.meida.h.cwM().a(RecordVideoActivity.this.jDA.jEi, RecordVideoActivity.this.jDA.cxd(), z);
            }
            File file = new File(RecordVideoActivity.this.jDA.jEi.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.c(file, new File(RecordVideoActivity.this.jDA.cxd()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cwM().a(RecordVideoActivity.this.jDA.jEi, RecordVideoActivity.this.jDA.cxd(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jFd.cyd();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cxB();
                    RecordVideoActivity.this.Cy(102);
                    RecordVideoActivity.this.jFn.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cxB();
                RecordVideoActivity.this.Cy(102);
                RecordVideoActivity.this.jFn.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.jFn.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jFo.aV(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jFd == null || v.aa(this.jFd.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jFd.getChoosedBeautyList()) {
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
        if (this.jFd == null || v.aa(this.jFd.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jFd.getChoosedFilterList()) {
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
        if (this.jFd == null || v.aa(this.jFd.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jFd.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxR() {
        this.jFp.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxS() {
        this.jFp.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cxT() {
        if (this.jDs.getStatus() == 1) {
            this.jFC.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jDA != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jDA.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").P(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jFl.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jFl.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jDA.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jDs.getStatus() == 1) {
                            anVar.P("obj_type", 1);
                        } else {
                            anVar.P("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jFl.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jFl.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jFB.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jFl.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jFl.setViewChoosed(0, true);
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
            this.jFA = stickerItem;
            this.jFz.GG(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jDA != null) {
                    this.jDA.setSticker(null);
                    this.jFF = false;
                }
                if (this.jFd != null) {
                    this.jFd.setDownLoadSticker(null);
                }
                this.jFm.setVisibility(8);
                this.jFl.setViewChoosed(1, false);
                return;
            }
            String GD = this.jFz.GD(stickerItem.resource);
            if (!StringUtils.isNull(GD)) {
                a(stickerItem, GD);
                if (this.jFd != null) {
                    this.jFd.setDownLoadSticker(null);
                }
            } else {
                if (this.jFd != null) {
                    this.jFd.setDownLoadSticker(stickerItem);
                }
                this.jFz.GE(stickerItem.resource);
            }
            this.jFl.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jDA != null) {
                this.jDA.setSticker(stickerItem);
                this.jFF = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jFm.setText(stickerItem.desc);
                this.jFm.setVisibility(0);
                this.jFm.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jFm.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jFm.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cH(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.v(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jFd.getLayoutParams();
            layoutParams.height = i4;
            this.jFd.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String Gn = com.baidu.tieba.video.editvideo.model.a.cvJ().Gn(stringExtra);
                if (this.jFB != null && !TextUtils.isEmpty(Gn)) {
                    this.jFB.eu(Gn, stringExtra2);
                    this.jFd.cwR();
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
        if (this.jDs.getStatus() == 8) {
            this.jFd.cxW();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void rP(boolean z) {
        if (this.jDs != null && (this.jDs.getStatus() == 1 || this.jDs.getStatus() == 3 || this.jDs.getStatus() == 4)) {
            if (!z && this.jFF) {
                this.jFj.aVC();
                return;
            } else {
                this.jFj.aVD();
                return;
            }
        }
        this.jFj.aVD();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void U(int i, boolean z) {
        int i2 = 1;
        if (this.fNy != i) {
            switch (i) {
                case 1:
                    if (this.jFB != null) {
                        this.jFB.aBQ();
                    }
                    this.jDA.setFilter("origin");
                    this.jFl.setViewChoosed(0, false);
                    this.jFl.setViewChoosed(3, false);
                    this.jFd.CA(1);
                    this.jFl.setViewVisibility(0, 8);
                    this.jFl.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jFl.setViewVisibility(0, 0);
                    this.jFl.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fNy = i;
            this.jFd.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().P("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cxy() {
        if (this.jDs.getStatus() == 1 && !this.jFd.cyb()) {
            U(1, true);
            this.jFC.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cxx() {
        if (this.jDs.getStatus() == 1 && !this.jFd.cyb()) {
            U(2, true);
            this.jFC.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cy(int i) {
        if (this.jjR != null) {
            this.jjR.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.jjR != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.jjR.av(i, str);
        }
    }
}
