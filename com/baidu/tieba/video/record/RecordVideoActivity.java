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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.util.am;
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
    private int fFX;
    private final CustomMessageListener fHG;
    private ImageView geO;
    private com.baidu.tieba.j.h iZT;
    private String joU;
    private SelectMusicModel joY;
    private b.a jsk;
    private i jtE;
    protected h jtM;
    private b juv;
    private TextView jvA;
    private AnimatorSet jvB;
    private AnimatorSet jvC;
    private ScaleAnimation jvD;
    private ObjectAnimator jvE;
    private ObjectAnimator jvF;
    private int jvG;
    private ForumWriteData jvH;
    private boolean jvI;
    private boolean jvJ = true;
    private l jvK;
    private StickerItem jvL;
    protected j jvM;
    private RecordTabLayout jvN;
    private ImageFileInfo jvO;
    private HttpMessageListener jvP;
    private boolean jvQ;
    private RecordLayout jvn;
    private VideoControllerLayout jvo;
    private RelativeLayout jvp;
    private ImageView jvq;
    private ImageView jvr;
    private ImageView jvs;
    private com.baidu.tbadk.core.dialog.a jvt;
    private PreviewViewContainer jvu;
    private TextView jvv;
    private VideoEffectButtonLayout jvw;
    private TextView jvx;
    private View jvy;
    private RoundProgressBar jvz;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZT = lVar.bMn();
        }
        if (this.iZT != null) {
            this.iZT.bLR();
        }
        this.jsk = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eo(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.aa(list)) {
                    if (RecordVideoActivity.this.jvo != null) {
                        RecordVideoActivity.this.jvo.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jvo != null) {
                    RecordVideoActivity.this.jvo.setHasLocalVideo(true);
                    RecordVideoActivity.this.jvJ = false;
                }
            }
        };
        this.jvP = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jvo != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jvo.setStickerItems(list);
                    }
                }
            }
        };
        this.fHG = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void ctD() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jtM.jpa);
        videoInfo.setVideoDuration(this.jtE.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jtM.jpa).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jvH == null ? "" : this.jvH.forumName;
        String str2 = this.jvH == null ? "" : this.jvH.forumId;
        int i = this.jvH == null ? -1 : this.jvH.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jvH.writeCallFrom, str, str2, this.joU, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jvM != null) {
            this.jvM.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.iZT != null) {
            this.iZT.bLU();
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
        if (this.jtE != null && this.jtE.akv()) {
            this.jtE.stopRecord();
        }
        if (this.joY != null) {
            this.joY.cancelLoadData();
        }
        if (this.iZT != null) {
            this.iZT.Am("record");
        }
        com.baidu.tbadk.core.util.m.A(new File(com.baidu.tieba.video.c.jno));
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
        this.jvG = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jvH = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.joU = getIntent().getStringExtra("video_title");
        initUI();
        this.joY = new SelectMusicModel(getPageContext(), this.jvo);
        this.joY.crT();
        this.jvM = new j(this);
        this.jvM.b(this.joY);
        this.jtE.a(this.jvM);
        registerListener(this.jvP);
        registerListener(this.fHG);
        ctE();
    }

    private void ctE() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void csw() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jsk);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jvn = (RecordLayout) findViewById(R.id.root_layout);
        this.jvn.setListener(this);
        this.jtE = new i(this);
        this.jvo = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jvo.setRecordController(this.jtE);
        this.jvo.setRecordControlListener(this);
        this.jvo.setEffectChoosedListener(this);
        this.jvp = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.geO = (ImageView) findViewById(R.id.close_page);
        this.geO.setOnClickListener(this);
        this.jvq = (ImageView) findViewById(R.id.flash_switch);
        this.jvq.setOnClickListener(this);
        this.jvr = (ImageView) findViewById(R.id.camera_switch);
        this.jvr.setOnClickListener(this);
        this.jvs = (ImageView) findViewById(R.id.count_down);
        this.jvs.setOnClickListener(this);
        this.jvu = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jtM = new h(this);
        this.jtM.a(this);
        this.jtM.setFaceIdentifyStateListener(this);
        this.jtM.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void ctr() {
                if (RecordVideoActivity.this.jvo.cud()) {
                    RecordVideoActivity.this.jvo.a((m) null);
                }
            }
        });
        this.jvw = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jvw.setListener(this);
        this.jtE.a(this.jvw);
        this.jvw.setViewChoosed(2, true);
        this.jvv = (TextView) findViewById(R.id.tv_count_down);
        this.jvx = (TextView) findViewById(R.id.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds150);
        if (this.jvv.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jvv.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jvw.setVisibility(8);
        }
        this.jvy = findViewById(R.id.progress_layout);
        this.jvz = (RoundProgressBar) this.jvy.findViewById(R.id.video_progress);
        this.jvA = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jvA.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds38);
        this.jvA.setLayoutParams(layoutParams);
        this.jvN = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jvN.aM(1, getString(R.string.tab_photo));
        if (this.jvG != 2 && this.jvG != 3) {
            this.jvN.aM(2, getString(R.string.tab_record));
            this.jvN.setListener(this);
            this.jvN.setCurrentTab(2, false);
            R(2, false);
        } else {
            this.jvN.setShowIndicator(false);
            this.jvN.setCurrentTab(1, false);
            R(1, false);
        }
        ctF();
    }

    private void ctF() {
        if (com.baidu.tbadk.core.util.g.agV()) {
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
        this.jtM.onResume();
        this.juv = this.jtM.cti();
        if (this.juv != null) {
            this.juv.setRecordController(this.jtE);
            this.jvu.setZoomHelper(this.juv);
        }
        ctG();
        if (this.jvK == null) {
            this.jvK = new l();
            this.jvK.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void er(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jvL, str2);
                    if (RecordVideoActivity.this.jvo != null) {
                        RecordVideoActivity.this.jvo.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void EO(String str) {
                    if (RecordVideoActivity.this.jvo != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jvo.b(stickerItem);
                        if (RecordVideoActivity.this.jtM != null) {
                            RecordVideoActivity.this.jtM.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jvo != null) {
                        RecordVideoActivity.this.jvo.setDownLoadSticker(null);
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
                public void crb() {
                    if (RecordVideoActivity.this.jvo != null) {
                        RecordVideoActivity.this.jvo.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jvK.ctX();
        if (this.jvo != null && this.jvJ) {
            csw();
        }
        if (this.iZT != null) {
            this.iZT.Al("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jtM.onPause();
        if (this.jvo != null) {
            if (this.jtE != null && this.jtE.getStatus() == 6) {
                this.jvo.stopRecord();
                ctP();
            }
            if (this.jtE != null && this.jtE.akv()) {
                this.jvo.stopRecord();
            }
        }
        if (this.jvM != null) {
            this.jvM.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jtE == null || this.jtE.getStatus() != 7) {
            if (this.jtE != null && this.jtE.getStatus() == 6) {
                if (this.jvo != null) {
                    this.jvo.stopRecord();
                }
                ctP();
            } else if (this.jtE.onBackPressed()) {
                finish();
            } else {
                if (this.jvt == null) {
                    this.jvt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jvt.ho(R.string.video_quit_confirm);
                    this.jvt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jvt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jvt.dM(true);
                    this.jvt.b(getPageContext());
                }
                this.jvt.afG();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jvA.setVisibility(4);
        if (view == this.geO) {
            onBackPressed();
        } else if (view == this.jvq) {
            if (this.jtE.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jtM.ctl();
            ctG();
        } else if (view == this.jvr) {
            if (this.jtE.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jvr.setOnClickListener(null);
            this.jtM.ctn();
            if (this.jtM.cto() && this.jtM.ctm()) {
                this.jtM.ctl();
            }
            ctG();
            this.jvr.setOnClickListener(this);
        } else if (view == this.jvs) {
            ctI();
        }
    }

    private void ctG() {
        if (this.jtM.cto()) {
            this.jvq.setVisibility(8);
        } else {
            this.jvq.setVisibility(0);
        }
        if (this.jtM.ctm()) {
            this.jvq.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jvq.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout ctH() {
        return this.jvu;
    }

    public void ctI() {
        this.jvA.setVisibility(4);
        if (this.jtE.getStatus() != 6) {
            this.jtE.setStatus(6);
            ctN();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jvD == null) {
                this.jvD = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jvD.setDuration(500L);
                this.jvD.setRepeatCount(5);
                this.jvD.setRepeatMode(2);
                this.jvD.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jvD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jtE.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jvv.setVisibility(0);
                        RecordVideoActivity.this.jvv.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jvv.setVisibility(8);
                    if (RecordVideoActivity.this.jtE.getStatus() == 6) {
                        RecordVideoActivity.this.jvo.cua();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jtE.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jvv.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jvv.setText("");
                        }
                    }
                }
            });
            this.jvv.setAnimation(this.jvD);
            this.jvD.startNow();
            this.jvo.ctI();
            if (this.jvM != null) {
                this.jvM.ctC();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        if (this.jtE.getStatus() == 1) {
            this.jvA.setVisibility(4);
            if (this.jtE.getStatus() != 6) {
                this.jvo.ctJ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        this.jvA.setVisibility(4);
        if (this.jtE.getStatus() != 6) {
            this.jvo.ctK();
            if (this.jvo.cue()) {
                ctE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctL() {
        this.jvA.setVisibility(4);
        if (this.jtE.getStatus() != 6) {
            this.jvo.ctL();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctM() {
        this.jvA.setVisibility(4);
        if (this.jtE.getStatus() != 6) {
            this.jvo.ctM();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctN() {
        this.jvI = true;
        if (this.jvC != null && this.jvC.isRunning()) {
            this.jvC.cancel();
        }
        if (this.jvB == null) {
            this.jvB = new AnimatorSet();
            this.jvB.playTogether(ObjectAnimator.ofFloat(this.jvp, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jvw, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jvN, "alpha", 1.0f, 0.0f));
            this.jvB.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxo) {
                        RecordVideoActivity.this.jvp.setVisibility(8);
                        RecordVideoActivity.this.jvw.setVisibility(8);
                        RecordVideoActivity.this.jvN.setVisibility(8);
                    }
                }
            });
            this.jvB.setDuration(300L);
        }
        this.jvB.start();
        this.jvw.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctC() {
        if (this.fFX == 2) {
            if (this.jvI) {
                this.jvI = false;
                if (this.jvM != null) {
                    this.jvM.ctC();
                }
            } else {
                return;
            }
        }
        if (this.jvB != null && this.jvB.isRunning()) {
            this.jvB.cancel();
        }
        if (this.jvC == null) {
            this.jvC = new AnimatorSet();
            this.jvC.playTogether(ObjectAnimator.ofFloat(this.jvp, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jvw, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jvN, "alpha", 0.0f, 1.0f));
            this.jvC.setDuration(300L);
        }
        this.jvp.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jvw.setVisibility(0);
        }
        if (this.jtE.getStatus() == 1) {
            this.jvN.setVisibility(0);
        }
        this.jvC.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctO() {
        if (this.jtM != null) {
            this.jtM.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void y(boolean z, String str) {
                    RecordVideoActivity.this.jtE.setStatus(1);
                    RecordVideoActivity.this.ctC();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jvO != null && !v.aa(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jvO)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jvO);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jvO = new ImageFileInfo();
                        RecordVideoActivity.this.jvO.setFilePath(str);
                        RecordVideoActivity.this.jvO.setTempFile(true);
                        RecordVideoActivity.this.jvO.setAlbumnId(null);
                        RecordVideoActivity.this.jvO.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jvO);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jvH, RecordVideoActivity.this.jvG)));
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
    public void ctP() {
        this.jvD.cancel();
        this.jvD.setAnimationListener(null);
        this.jvv.clearAnimation();
        this.jvv.setVisibility(8);
        if (this.jvM != null) {
            this.jvM.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctQ() {
        ckX();
    }

    private void ckX() {
        if (this.jvE != null) {
            this.jvE.cancel();
        }
        if (this.jvF == null) {
            this.jvF = ObjectAnimator.ofFloat(this.jvN, "alpha", 1.0f, 0.0f);
            this.jvF.setDuration(500L);
            this.jvF.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxo) {
                        RecordVideoActivity.this.jvN.setVisibility(8);
                    }
                }
            });
        }
        this.jvF.start();
    }

    private void ckW() {
        if (this.jvF != null) {
            this.jvF.cancel();
        }
        if (this.jvE == null) {
            this.jvE = ObjectAnimator.ofFloat(this.jvN, "alpha", 0.0f, 1.0f);
            this.jvE.setDuration(500L);
        }
        this.jvN.setVisibility(0);
        this.jvE.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctR() {
        this.jvw.reset();
        if (this.jtE.getStatus() == 1) {
            ckW();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctS() {
        if (this.jvy.getVisibility() != 0) {
            this.jvo.ctZ();
            this.jtE.setStatus(8);
            ctC();
            if (this.jtM.jut != null && this.jtM.jut.size() > 0) {
                this.jvy.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jvS = 50;
        final int jvT = 1;
        Handler jvU = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jvz.aT(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.ctW();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void ctW() {
            this.jvU.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            ctW();
            boolean z = RecordVideoActivity.this.jvM == null || TextUtils.isEmpty(RecordVideoActivity.this.jvM.ctB()) || !new File(RecordVideoActivity.this.jvM.ctB()).exists();
            if (RecordVideoActivity.this.jtM.jut.size() > 1) {
                return com.baidu.tieba.video.meida.h.csO().a(RecordVideoActivity.this.jtM.jut, RecordVideoActivity.this.jtM.ctf(), z);
            }
            File file = new File(RecordVideoActivity.this.jtM.jut.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.c(file, new File(RecordVideoActivity.this.jtM.ctf()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.csO().a(RecordVideoActivity.this.jtM.jut, RecordVideoActivity.this.jtM.ctf(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jvo.cuf();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.ctD();
                    RecordVideoActivity.this.BL(102);
                    RecordVideoActivity.this.jvy.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.ctD();
                RecordVideoActivity.this.BL(102);
                RecordVideoActivity.this.jvy.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.jvy.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jvz.aT(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jvo == null || v.aa(this.jvo.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jvo.getChoosedBeautyList()) {
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
        if (this.jvo == null || v.aa(this.jvo.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jvo.getChoosedFilterList()) {
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
        if (this.jvo == null || v.aa(this.jvo.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jvo.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctT() {
        this.jvA.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctU() {
        this.jvA.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctV() {
        if (this.jtE.getStatus() == 1) {
            this.jvN.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jtM != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jtM.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").P(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jvw.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jvw.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jtM.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.bT(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jtE.getStatus() == 1) {
                            amVar.P("obj_type", 1);
                        } else {
                            amVar.P("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jvw.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jvw.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jvM.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jvw.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jvw.setViewChoosed(0, true);
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
            this.jvL = stickerItem;
            this.jvK.Fo(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jtM != null) {
                    this.jtM.setSticker(null);
                    this.jvQ = false;
                }
                if (this.jvo != null) {
                    this.jvo.setDownLoadSticker(null);
                }
                this.jvx.setVisibility(8);
                this.jvw.setViewChoosed(1, false);
                return;
            }
            String Fl = this.jvK.Fl(stickerItem.resource);
            if (!StringUtils.isNull(Fl)) {
                a(stickerItem, Fl);
                if (this.jvo != null) {
                    this.jvo.setDownLoadSticker(null);
                }
            } else {
                if (this.jvo != null) {
                    this.jvo.setDownLoadSticker(stickerItem);
                }
                this.jvK.Fm(stickerItem.resource);
            }
            this.jvw.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jtM != null) {
                this.jtM.setSticker(stickerItem);
                this.jvQ = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jvx.setText(stickerItem.desc);
                this.jvx.setVisibility(0);
                this.jvx.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jvx.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jvx.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cD(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jvo.getLayoutParams();
            layoutParams.height = i4;
            this.jvo.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EW = com.baidu.tieba.video.editvideo.model.a.crN().EW(stringExtra);
                if (this.jvM != null && !TextUtils.isEmpty(EW)) {
                    this.jvM.es(EW, stringExtra2);
                    this.jvo.csT();
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
        if (this.jtE.getStatus() == 8) {
            this.jvo.ctY();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void rx(boolean z) {
        if (this.jtE != null && (this.jtE.getStatus() == 1 || this.jtE.getStatus() == 3 || this.jtE.getStatus() == 4)) {
            if (!z && this.jvQ) {
                this.jvu.aTd();
                return;
            } else {
                this.jvu.aTe();
                return;
            }
        }
        this.jvu.aTe();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void R(int i, boolean z) {
        int i2 = 1;
        if (this.fFX != i) {
            switch (i) {
                case 1:
                    if (this.jvM != null) {
                        this.jvM.aAl();
                    }
                    this.jtM.setFilter("origin");
                    this.jvw.setViewChoosed(0, false);
                    this.jvw.setViewChoosed(3, false);
                    this.jvo.BN(1);
                    this.jvw.setViewVisibility(0, 8);
                    this.jvw.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jvw.setViewVisibility(0, 0);
                    this.jvw.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fFX = i;
            this.jvo.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().P("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void ctA() {
        if (this.jtE.getStatus() == 1 && !this.jvo.cud()) {
            R(1, true);
            this.jvN.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void ctz() {
        if (this.jtE.getStatus() == 1 && !this.jvo.cud()) {
            R(2, true);
            this.jvN.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL(int i) {
        if (this.iZT != null) {
            this.iZT.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.iZT != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.iZT.av(i, str);
        }
    }
}
