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
    private View atF;
    private int fMR;
    private final CustomMessageListener fOE;
    private ImageView gnh;
    private b.a jBQ;
    private i jDk;
    protected h jDs;
    private RecordLayout jET;
    private VideoControllerLayout jEU;
    private RelativeLayout jEV;
    private ImageView jEW;
    private ImageView jEX;
    private ImageView jEY;
    private com.baidu.tbadk.core.dialog.a jEZ;
    private b jEb;
    private PreviewViewContainer jFa;
    private TextView jFb;
    private VideoEffectButtonLayout jFc;
    private TextView jFd;
    private RoundProgressBar jFe;
    private TextView jFf;
    private AnimatorSet jFg;
    private AnimatorSet jFh;
    private ScaleAnimation jFi;
    private ObjectAnimator jFj;
    private ObjectAnimator jFk;
    private int jFl;
    private ForumWriteData jFm;
    private boolean jFn;
    private boolean jFo = true;
    private l jFp;
    private StickerItem jFq;
    protected j jFr;
    private RecordTabLayout jFs;
    private ImageFileInfo jFt;
    private HttpMessageListener jFu;
    private boolean jFv;
    private com.baidu.tieba.j.h jjG;
    private String jyA;
    private SelectMusicModel jyE;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_VIDEO_PLATFORM_FACTORY, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.jjG = lVar.bMY();
        }
        if (this.jjG != null) {
            this.jjG.bMB();
        }
        this.jBQ = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eD(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.isEmpty(list)) {
                    if (RecordVideoActivity.this.jEU != null) {
                        RecordVideoActivity.this.jEU.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jEU != null) {
                    RecordVideoActivity.this.jEU.setHasLocalVideo(true);
                    RecordVideoActivity.this.jFo = false;
                }
            }
        };
        this.jFu = new HttpMessageListener(1003368) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jEU != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jEU.setStickerItems(list);
                    }
                }
            }
        };
        this.fOE = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void cvr() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jDs.jyG);
        videoInfo.setVideoDuration(this.jDk.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jDs.jyG).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jFm == null ? "" : this.jFm.forumName;
        String str2 = this.jFm == null ? "" : this.jFm.forumId;
        int i = this.jFm == null ? -1 : this.jFm.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jFm.writeCallFrom, str, str2, this.jyA, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(RequestResponseCode.REQUEST_EDIT_VIDEO_ACTIVITY);
        editVideoActivityConfig.setProZone(i);
        if (this.jFr != null) {
            this.jFr.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        if (this.jjG != null) {
            this.jjG.bME();
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
        if (this.jDk != null && this.jDk.aoC()) {
            this.jDk.stopRecord();
        }
        if (this.jyE != null) {
            this.jyE.cancelLoadData();
        }
        if (this.jjG != null) {
            this.jjG.zT("record");
        }
        com.baidu.tbadk.core.util.m.deleteFileOrDir(new File(com.baidu.tieba.video.c.jwU));
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
        this.jFl = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jFm = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.jyA = getIntent().getStringExtra("video_title");
        initUI();
        this.jyE = new SelectMusicModel(getPageContext(), this.jEU);
        this.jyE.ctD();
        this.jFr = new j(this);
        this.jFr.b(this.jyE);
        this.jDk.a(this.jFr);
        registerListener(this.jFu);
        registerListener(this.fOE);
        cvs();
    }

    private void cvs() {
        HttpMessage httpMessage = new HttpMessage(1003368);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void cug() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jBQ);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jET = (RecordLayout) findViewById(R.id.root_layout);
        this.jET.setListener(this);
        this.jDk = new i(this);
        this.jEU = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jEU.setRecordController(this.jDk);
        this.jEU.setRecordControlListener(this);
        this.jEU.setEffectChoosedListener(this);
        this.jEV = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.gnh = (ImageView) findViewById(R.id.close_page);
        this.gnh.setOnClickListener(this);
        this.jEW = (ImageView) findViewById(R.id.flash_switch);
        this.jEW.setOnClickListener(this);
        this.jEX = (ImageView) findViewById(R.id.camera_switch);
        this.jEX.setOnClickListener(this);
        this.jEY = (ImageView) findViewById(R.id.count_down);
        this.jEY.setOnClickListener(this);
        this.jFa = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jDs = new h(this);
        this.jDs.a(this);
        this.jDs.setFaceIdentifyStateListener(this);
        this.jDs.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void cvd() {
                if (RecordVideoActivity.this.jEU.cvR()) {
                    RecordVideoActivity.this.jEU.a((m) null);
                }
            }
        });
        this.jFc = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jFc.setListener(this);
        this.jDk.a(this.jFc);
        this.jFc.setViewChoosed(2, true);
        this.jFb = (TextView) findViewById(R.id.tv_count_down);
        this.jFd = (TextView) findViewById(R.id.gesture_guide_tv);
        int equipmentHeight = ((com.baidu.adp.lib.util.l.getEquipmentHeight(this.mContext) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds150);
        if (this.jFb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jFb.getLayoutParams()).topMargin = equipmentHeight;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jFc.setVisibility(8);
        }
        this.atF = findViewById(R.id.progress_layout);
        this.jFe = (RoundProgressBar) this.atF.findViewById(R.id.video_progress);
        this.jFf = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jFf.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.ds38);
        this.jFf.setLayoutParams(layoutParams);
        this.jFs = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jFs.aN(1, getString(R.string.tab_photo));
        if (this.jFl != 2 && this.jFl != 3) {
            this.jFs.aN(2, getString(R.string.tab_record));
            this.jFs.setListener(this);
            this.jFs.setCurrentTab(2, false);
            S(2, false);
        } else {
            this.jFs.setShowIndicator(false);
            this.jFs.setCurrentTab(1, false);
            S(1, false);
        }
        cvt();
    }

    private void cvt() {
        if (com.baidu.tbadk.core.util.g.alX()) {
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
        this.jDs.onResume();
        this.jEb = this.jDs.cuU();
        if (this.jEb != null) {
            this.jEb.setRecordController(this.jDk);
            this.jFa.setZoomHelper(this.jEb);
        }
        cvu();
        if (this.jFp == null) {
            this.jFp = new l();
            this.jFp.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void ef(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jFq, str2);
                    if (RecordVideoActivity.this.jEU != null) {
                        RecordVideoActivity.this.jEU.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void EH(String str) {
                    if (RecordVideoActivity.this.jEU != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jEU.b(stickerItem);
                        if (RecordVideoActivity.this.jDs != null) {
                            RecordVideoActivity.this.jDs.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jEU != null) {
                        RecordVideoActivity.this.jEU.setDownLoadSticker(null);
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
                public void csM() {
                    if (RecordVideoActivity.this.jEU != null) {
                        RecordVideoActivity.this.jEU.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jFp.cvL();
        if (this.jEU != null && this.jFo) {
            cug();
        }
        if (this.jjG != null) {
            this.jjG.zS("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jDs.onPause();
        if (this.jEU != null) {
            if (this.jDk != null && this.jDk.getStatus() == 6) {
                this.jEU.stopRecord();
                cvD();
            }
            if (this.jDk != null && this.jDk.aoC()) {
                this.jEU.stopRecord();
            }
        }
        if (this.jFr != null) {
            this.jFr.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jDk == null || this.jDk.getStatus() != 7) {
            if (this.jDk != null && this.jDk.getStatus() == 6) {
                if (this.jEU != null) {
                    this.jEU.stopRecord();
                }
                cvD();
            } else if (this.jDk.onBackPressed()) {
                finish();
            } else {
                if (this.jEZ == null) {
                    this.jEZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jEZ.hU(R.string.video_quit_confirm);
                    this.jEZ.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jEZ.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jEZ.eg(true);
                    this.jEZ.b(getPageContext());
                }
                this.jEZ.akO();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jFf.setVisibility(4);
        if (view == this.gnh) {
            onBackPressed();
        } else if (view == this.jEW) {
            if (this.jDk.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jDs.cuX();
            cvu();
        } else if (view == this.jEX) {
            if (this.jDk.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jEX.setOnClickListener(null);
            this.jDs.cuZ();
            if (this.jDs.cva() && this.jDs.cuY()) {
                this.jDs.cuX();
            }
            cvu();
            this.jEX.setOnClickListener(this);
        } else if (view == this.jEY) {
            cvw();
        }
    }

    private void cvu() {
        if (this.jDs.cva()) {
            this.jEW.setVisibility(8);
        } else {
            this.jEW.setVisibility(0);
        }
        if (this.jDs.cuY()) {
            this.jEW.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jEW.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout cvv() {
        return this.jFa;
    }

    public void cvw() {
        this.jFf.setVisibility(4);
        if (this.jDk.getStatus() != 6) {
            this.jDk.setStatus(6);
            cvB();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jFi == null) {
                this.jFi = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jFi.setDuration(500L);
                this.jFi.setRepeatCount(5);
                this.jFi.setRepeatMode(2);
                this.jFi.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jFi.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jDk.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jFb.setVisibility(0);
                        RecordVideoActivity.this.jFb.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jFb.setVisibility(8);
                    if (RecordVideoActivity.this.jDk.getStatus() == 6) {
                        RecordVideoActivity.this.jEU.cvO();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jDk.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jFb.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jFb.setText("");
                        }
                    }
                }
            });
            this.jFb.setAnimation(this.jFi);
            this.jFi.startNow();
            this.jEU.cvw();
            if (this.jFr != null) {
                this.jFr.cvq();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvx() {
        if (this.jDk.getStatus() == 1) {
            this.jFf.setVisibility(4);
            if (this.jDk.getStatus() != 6) {
                this.jEU.cvx();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvy() {
        this.jFf.setVisibility(4);
        if (this.jDk.getStatus() != 6) {
            this.jEU.cvy();
            if (this.jEU.cvS()) {
                cvs();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvz() {
        this.jFf.setVisibility(4);
        if (this.jDk.getStatus() != 6) {
            this.jEU.cvz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void cvA() {
        this.jFf.setVisibility(4);
        if (this.jDk.getStatus() != 6) {
            this.jEU.cvA();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvB() {
        this.jFn = true;
        if (this.jFh != null && this.jFh.isRunning()) {
            this.jFh.cancel();
        }
        if (this.jFg == null) {
            this.jFg = new AnimatorSet();
            this.jFg.playTogether(ObjectAnimator.ofFloat(this.jEV, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jFc, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jFs, "alpha", 1.0f, 0.0f));
            this.jFg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGT) {
                        RecordVideoActivity.this.jEV.setVisibility(8);
                        RecordVideoActivity.this.jFc.setVisibility(8);
                        RecordVideoActivity.this.jFs.setVisibility(8);
                    }
                }
            });
            this.jFg.setDuration(300L);
        }
        this.jFg.start();
        this.jFc.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvq() {
        if (this.fMR == 2) {
            if (this.jFn) {
                this.jFn = false;
                if (this.jFr != null) {
                    this.jFr.cvq();
                }
            } else {
                return;
            }
        }
        if (this.jFg != null && this.jFg.isRunning()) {
            this.jFg.cancel();
        }
        if (this.jFh == null) {
            this.jFh = new AnimatorSet();
            this.jFh.playTogether(ObjectAnimator.ofFloat(this.jEV, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jFc, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jFs, "alpha", 0.0f, 1.0f));
            this.jFh.setDuration(300L);
        }
        this.jEV.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jFc.setVisibility(0);
        }
        if (this.jDk.getStatus() == 1) {
            this.jFs.setVisibility(0);
        }
        this.jFh.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvC() {
        if (this.jDs != null) {
            this.jDs.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void z(boolean z, String str) {
                    RecordVideoActivity.this.jDk.setStatus(1);
                    RecordVideoActivity.this.cvq();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jFt != null && !v.isEmpty(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jFt)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jFt);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jFt = new ImageFileInfo();
                        RecordVideoActivity.this.jFt.setFilePath(str);
                        RecordVideoActivity.this.jFt.setTempFile(true);
                        RecordVideoActivity.this.jFt.setAlbumnId(null);
                        RecordVideoActivity.this.jFt.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jFt);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jFm, RecordVideoActivity.this.jFl)));
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
    public void cvD() {
        this.jFi.cancel();
        this.jFi.setAnimationListener(null);
        this.jFb.clearAnimation();
        this.jFb.setVisibility(8);
        if (this.jFr != null) {
            this.jFr.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvE() {
        cmL();
    }

    private void cmL() {
        if (this.jFj != null) {
            this.jFj.cancel();
        }
        if (this.jFk == null) {
            this.jFk = ObjectAnimator.ofFloat(this.jFs, "alpha", 1.0f, 0.0f);
            this.jFk.setDuration(500L);
            this.jFk.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jGT) {
                        RecordVideoActivity.this.jFs.setVisibility(8);
                    }
                }
            });
        }
        this.jFk.start();
    }

    private void cmK() {
        if (this.jFk != null) {
            this.jFk.cancel();
        }
        if (this.jFj == null) {
            this.jFj = ObjectAnimator.ofFloat(this.jFs, "alpha", 0.0f, 1.0f);
            this.jFj.setDuration(500L);
        }
        this.jFs.setVisibility(0);
        this.jFj.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvF() {
        this.jFc.reset();
        if (this.jDk.getStatus() == 1) {
            cmK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvG() {
        if (this.atF.getVisibility() != 0) {
            this.jEU.cvN();
            this.jDk.setStatus(8);
            cvq();
            if (this.jDs.jDZ != null && this.jDs.jDZ.size() > 0) {
                this.atF.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jFx = 50;
        final int jFy = 1;
        Handler jFz = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jFe.ay(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.cvK();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void cvK() {
            this.jFz.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            cvK();
            boolean z = RecordVideoActivity.this.jFr == null || TextUtils.isEmpty(RecordVideoActivity.this.jFr.cvp()) || !new File(RecordVideoActivity.this.jFr.cvp()).exists();
            if (RecordVideoActivity.this.jDs.jDZ.size() > 1) {
                return com.baidu.tieba.video.meida.h.cuA().a(RecordVideoActivity.this.jDs.jDZ, RecordVideoActivity.this.jDs.cuR(), z);
            }
            File file = new File(RecordVideoActivity.this.jDs.jDZ.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.copyFile(file, new File(RecordVideoActivity.this.jDs.cuR()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.cuA().a(RecordVideoActivity.this.jDs.jDZ, RecordVideoActivity.this.jDs.cuR(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jEU.cvT();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.cvr();
                    RecordVideoActivity.this.Be(102);
                    RecordVideoActivity.this.atF.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.cvr();
                RecordVideoActivity.this.Be(102);
                RecordVideoActivity.this.atF.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.atF.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jFe.ay(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jEU == null || v.isEmpty(this.jEU.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jEU.getChoosedBeautyList()) {
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
        if (this.jEU == null || v.isEmpty(this.jEU.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jEU.getChoosedFilterList()) {
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
        if (this.jEU == null || v.isEmpty(this.jEU.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jEU.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvH() {
        this.jFf.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvI() {
        this.jFf.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void cvJ() {
        if (this.jDk.getStatus() == 1) {
            this.jFs.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jDs != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jDs.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new an("c12421").O("obj_id", ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jFc.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jFc.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jDs.setFilter((String) eVar.getValue());
                        an anVar = new an("c12496");
                        anVar.bS("obj_id", (String) eVar.getValue());
                        if (this.jDk.getStatus() == 1) {
                            anVar.O("obj_type", 1);
                        } else {
                            anVar.O("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jFc.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jFc.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jFr.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jFc.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jFc.setViewChoosed(0, true);
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
            this.jFq = stickerItem;
            this.jFp.Fi(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jDs != null) {
                    this.jDs.setSticker(null);
                    this.jFv = false;
                }
                if (this.jEU != null) {
                    this.jEU.setDownLoadSticker(null);
                }
                this.jFd.setVisibility(8);
                this.jFc.setViewChoosed(1, false);
                return;
            }
            String Ff = this.jFp.Ff(stickerItem.resource);
            if (!StringUtils.isNull(Ff)) {
                a(stickerItem, Ff);
                if (this.jEU != null) {
                    this.jEU.setDownLoadSticker(null);
                }
            } else {
                if (this.jEU != null) {
                    this.jEU.setDownLoadSticker(stickerItem);
                }
                this.jFp.Fg(stickerItem.resource);
            }
            this.jFc.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jDs != null) {
                this.jDs.setSticker(stickerItem);
                this.jFv = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jFd.setText(stickerItem.desc);
                this.jFd.setVisibility(0);
                this.jFd.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jFd.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jFd.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cA(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.getScreenSize(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jEU.getLayoutParams();
            layoutParams.height = i4;
            this.jEU.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EP = com.baidu.tieba.video.editvideo.model.a.ctx().EP(stringExtra);
                if (this.jFr != null && !TextUtils.isEmpty(EP)) {
                    this.jFr.eg(EP, stringExtra2);
                    this.jEU.cuF();
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
        if (this.jDk.getStatus() == 8) {
            this.jEU.cvM();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void ry(boolean z) {
        if (this.jDk != null && (this.jDk.getStatus() == 1 || this.jDk.getStatus() == 3 || this.jDk.getStatus() == 4)) {
            if (!z && this.jFv) {
                this.jFa.cve();
                return;
            } else {
                this.jFa.cvf();
                return;
            }
        }
        this.jFa.cvf();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void S(int i, boolean z) {
        int i2 = 1;
        if (this.fMR != i) {
            switch (i) {
                case 1:
                    if (this.jFr != null) {
                        this.jFr.aCa();
                    }
                    this.jDs.setFilter("origin");
                    this.jFc.setViewChoosed(0, false);
                    this.jFc.setViewChoosed(3, false);
                    this.jEU.Bg(1);
                    this.jFc.setViewVisibility(0, 8);
                    this.jFc.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jFc.setViewVisibility(0, 0);
                    this.jFc.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fMR = i;
            this.jEU.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new an().O("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cvo() {
        if (this.jDk.getStatus() == 1 && !this.jEU.cvR()) {
            S(1, true);
            this.jFs.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cvn() {
        if (this.jDk.getStatus() == 1 && !this.jEU.cvR()) {
            S(2, true);
            this.jFs.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be(int i) {
        if (this.jjG != null) {
            this.jjG.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.jjG != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.jjG.av(i, str);
        }
    }
}
