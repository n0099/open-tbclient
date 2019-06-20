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
    private final CustomMessageListener fHJ;
    private ImageView geQ;
    private com.baidu.tieba.j.h iZX;
    private String joY;
    private SelectMusicModel jpc;
    private b.a jsn;
    private i jtH;
    protected h jtP;
    private b juy;
    private TextView jvA;
    private View jvB;
    private RoundProgressBar jvC;
    private TextView jvD;
    private AnimatorSet jvE;
    private AnimatorSet jvF;
    private ScaleAnimation jvG;
    private ObjectAnimator jvH;
    private ObjectAnimator jvI;
    private int jvJ;
    private ForumWriteData jvK;
    private boolean jvL;
    private boolean jvM = true;
    private l jvN;
    private StickerItem jvO;
    protected j jvP;
    private RecordTabLayout jvQ;
    private ImageFileInfo jvR;
    private HttpMessageListener jvS;
    private boolean jvT;
    private RecordLayout jvq;
    private VideoControllerLayout jvr;
    private RelativeLayout jvs;
    private ImageView jvt;
    private ImageView jvu;
    private ImageView jvv;
    private com.baidu.tbadk.core.dialog.a jvw;
    private PreviewViewContainer jvx;
    private TextView jvy;
    private VideoEffectButtonLayout jvz;
    private Context mContext;
    private View mStatusBarView;
    private WriteImagesInfo mWriteImagesInfo;

    public RecordVideoActivity() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921309, com.baidu.tieba.j.l.class);
        com.baidu.tieba.j.l lVar = runTask != null ? (com.baidu.tieba.j.l) runTask.getData() : null;
        if (lVar != null) {
            this.iZX = lVar.bMo();
        }
        if (this.iZX != null) {
            this.iZX.bLS();
        }
        this.jsn = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
            @Override // com.baidu.tieba.video.localvideo.b.a
            public void eo(List<com.baidu.tieba.video.localvideo.d> list) {
                if (v.aa(list)) {
                    if (RecordVideoActivity.this.jvr != null) {
                        RecordVideoActivity.this.jvr.setHasLocalVideo(false);
                    }
                } else if (RecordVideoActivity.this.jvr != null) {
                    RecordVideoActivity.this.jvr.setHasLocalVideo(true);
                    RecordVideoActivity.this.jvM = false;
                }
            }
        };
        this.jvS = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
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
                    if (RecordVideoActivity.this.jvr != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        stickerItem.isSelect = true;
                        stickerItem.name = "nosticker";
                        if (list == null) {
                            list = new ArrayList<>();
                        }
                        list.add(0, stickerItem);
                        RecordVideoActivity.this.jvr.setStickerItems(list);
                    }
                }
            }
        };
        this.fHJ = new CustomMessageListener(2001374) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
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
    public void ctC() {
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.jtP.jpe);
        videoInfo.setVideoDuration(this.jtH.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.jtP.jpe).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        String str = this.jvK == null ? "" : this.jvK.forumName;
        String str2 = this.jvK == null ? "" : this.jvK.forumId;
        int i = this.jvK == null ? -1 : this.jvK.defaultZone;
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.jvK.writeCallFrom, str, str2, this.joY, videoInfo);
        editVideoActivityConfig.addFromType(EditVideoActivityConfig.FROM_TYPE_RECORD_VIDEO_ACTIVITY);
        editVideoActivityConfig.addRequestForResult(25036);
        editVideoActivityConfig.setProZone(i);
        if (this.jvP != null) {
            this.jvP.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, editVideoActivityConfig));
        if (this.iZX != null) {
            this.iZX.bLV();
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
        if (this.jtH != null && this.jtH.akv()) {
            this.jtH.stopRecord();
        }
        if (this.jpc != null) {
            this.jpc.cancelLoadData();
        }
        if (this.iZX != null) {
            this.iZX.Ao("record");
        }
        com.baidu.tbadk.core.util.m.A(new File(com.baidu.tieba.video.c.jns));
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
        this.jvJ = getIntent().getIntExtra(RecordVideoActivityConfig.ENTRANCE_FLAG, 0);
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA) instanceof ForumWriteData) {
            this.jvK = (ForumWriteData) getIntent().getSerializableExtra(RecordVideoActivityConfig.FORUM_WRITE_DATA);
        }
        if (getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO) instanceof WriteImagesInfo) {
            this.mWriteImagesInfo = (WriteImagesInfo) getIntent().getSerializableExtra(RecordVideoActivityConfig.WRITE_IMAGE_INFO);
        }
        this.joY = getIntent().getStringExtra("video_title");
        initUI();
        this.jpc = new SelectMusicModel(getPageContext(), this.jvr);
        this.jpc.crS();
        this.jvP = new j(this);
        this.jvP.b(this.jpc);
        this.jtH.a(this.jvP);
        registerListener(this.jvS);
        registerListener(this.fHJ);
        ctD();
    }

    private void ctD() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam(Config.PACKAGE_NAME, 1);
        httpMessage.addParam("rn", 999);
        sendMessage(httpMessage);
    }

    private void csv() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.jsn);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.jvq = (RecordLayout) findViewById(R.id.root_layout);
        this.jvq.setListener(this);
        this.jtH = new i(this);
        this.jvr = (VideoControllerLayout) findViewById(R.id.record_controller_layout);
        this.jvr.setRecordController(this.jtH);
        this.jvr.setRecordControlListener(this);
        this.jvr.setEffectChoosedListener(this);
        this.jvs = (RelativeLayout) findViewById(R.id.top_control_layout);
        this.geQ = (ImageView) findViewById(R.id.close_page);
        this.geQ.setOnClickListener(this);
        this.jvt = (ImageView) findViewById(R.id.flash_switch);
        this.jvt.setOnClickListener(this);
        this.jvu = (ImageView) findViewById(R.id.camera_switch);
        this.jvu.setOnClickListener(this);
        this.jvv = (ImageView) findViewById(R.id.count_down);
        this.jvv.setOnClickListener(this);
        this.jvx = (PreviewViewContainer) findViewById(R.id.video_surface_container);
        this.jtP = new h(this);
        this.jtP.a(this);
        this.jtP.setFaceIdentifyStateListener(this);
        this.jtP.a(new h.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // com.baidu.tieba.video.record.h.b
            public void ctq() {
                if (RecordVideoActivity.this.jvr.cuc()) {
                    RecordVideoActivity.this.jvr.a((m) null);
                }
            }
        });
        this.jvz = (VideoEffectButtonLayout) findViewById(R.id.layout_effect_button);
        this.jvz.setListener(this);
        this.jtH.a(this.jvz);
        this.jvz.setViewChoosed(2, true);
        this.jvy = (TextView) findViewById(R.id.tv_count_down);
        this.jvA = (TextView) findViewById(R.id.gesture_guide_tv);
        int ah = ((com.baidu.adp.lib.util.l.ah(this.mContext) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds336)) / 2) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds150);
        if (this.jvy.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.jvy.getLayoutParams()).topMargin = ah;
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.jvz.setVisibility(8);
        }
        this.jvB = findViewById(R.id.progress_layout);
        this.jvC = (RoundProgressBar) this.jvB.findViewById(R.id.video_progress);
        this.jvD = (TextView) findViewById(R.id.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jvD.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.af(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.ds38);
        this.jvD.setLayoutParams(layoutParams);
        this.jvQ = (RecordTabLayout) findViewById(R.id.tab_layout);
        this.jvQ.aM(1, getString(R.string.tab_photo));
        if (this.jvJ != 2 && this.jvJ != 3) {
            this.jvQ.aM(2, getString(R.string.tab_record));
            this.jvQ.setListener(this);
            this.jvQ.setCurrentTab(2, false);
            R(2, false);
        } else {
            this.jvQ.setShowIndicator(false);
            this.jvQ.setCurrentTab(1, false);
            R(1, false);
        }
        ctE();
    }

    private void ctE() {
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
        this.jtP.onResume();
        this.juy = this.jtP.cth();
        if (this.juy != null) {
            this.juy.setRecordController(this.jtH);
            this.jvx.setZoomHelper(this.juy);
        }
        ctF();
        if (this.jvN == null) {
            this.jvN = new l();
            this.jvN.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
                @Override // com.baidu.tieba.video.record.l.a
                public void er(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.jvO, str2);
                    if (RecordVideoActivity.this.jvr != null) {
                        RecordVideoActivity.this.jvr.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void EQ(String str) {
                    if (RecordVideoActivity.this.jvr != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.jvr.b(stickerItem);
                        if (RecordVideoActivity.this.jtP != null) {
                            RecordVideoActivity.this.jtP.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.jvr != null) {
                        RecordVideoActivity.this.jvr.setDownLoadSticker(null);
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
                public void crc() {
                    if (RecordVideoActivity.this.jvr != null) {
                        RecordVideoActivity.this.jvr.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.jvN.ctW();
        if (this.jvr != null && this.jvM) {
            csv();
        }
        if (this.iZX != null) {
            this.iZX.An("album");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.jtP.onPause();
        if (this.jvr != null) {
            if (this.jtH != null && this.jtH.getStatus() == 6) {
                this.jvr.stopRecord();
                ctO();
            }
            if (this.jtH != null && this.jtH.akv()) {
                this.jvr.stopRecord();
            }
        }
        if (this.jvP != null) {
            this.jvP.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jtH == null || this.jtH.getStatus() != 7) {
            if (this.jtH != null && this.jtH.getStatus() == 6) {
                if (this.jvr != null) {
                    this.jvr.stopRecord();
                }
                ctO();
            } else if (this.jtH.onBackPressed()) {
                finish();
            } else {
                if (this.jvw == null) {
                    this.jvw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.jvw.ho(R.string.video_quit_confirm);
                    this.jvw.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.jvw.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.jvw.dM(true);
                    this.jvw.b(getPageContext());
                }
                this.jvw.afG();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.jvD.setVisibility(4);
        if (view == this.geQ) {
            onBackPressed();
        } else if (view == this.jvt) {
            if (this.jtH.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.jtP.ctk();
            ctF();
        } else if (view == this.jvu) {
            if (this.jtH.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.jvu.setOnClickListener(null);
            this.jtP.ctm();
            if (this.jtP.ctn() && this.jtP.ctl()) {
                this.jtP.ctk();
            }
            ctF();
            this.jvu.setOnClickListener(this);
        } else if (view == this.jvv) {
            ctH();
        }
    }

    private void ctF() {
        if (this.jtP.ctn()) {
            this.jvt.setVisibility(8);
        } else {
            this.jvt.setVisibility(0);
        }
        if (this.jtP.ctl()) {
            this.jvt.setImageResource(R.drawable.icon_video_flashon_n);
        } else {
            this.jvt.setImageResource(R.drawable.icon_video_flashoff_n);
        }
    }

    public FrameLayout ctG() {
        return this.jvx;
    }

    public void ctH() {
        this.jvD.setVisibility(4);
        if (this.jtH.getStatus() != 6) {
            this.jtH.setStatus(6);
            ctM();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.jvG == null) {
                this.jvG = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.jvG.setDuration(500L);
                this.jvG.setRepeatCount(5);
                this.jvG.setRepeatMode(2);
                this.jvG.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.jvG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.jtH.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.jvy.setVisibility(0);
                        RecordVideoActivity.this.jvy.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.jvy.setVisibility(8);
                    if (RecordVideoActivity.this.jtH.getStatus() == 6) {
                        RecordVideoActivity.this.jvr.ctZ();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.jtH.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.jvy.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.jvy.setText("");
                        }
                    }
                }
            });
            this.jvy.setAnimation(this.jvG);
            this.jvG.startNow();
            this.jvr.ctH();
            if (this.jvP != null) {
                this.jvP.ctB();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctI() {
        if (this.jtH.getStatus() == 1) {
            this.jvD.setVisibility(4);
            if (this.jtH.getStatus() != 6) {
                this.jvr.ctI();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctJ() {
        this.jvD.setVisibility(4);
        if (this.jtH.getStatus() != 6) {
            this.jvr.ctJ();
            if (this.jvr.cud()) {
                ctD();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctK() {
        this.jvD.setVisibility(4);
        if (this.jtH.getStatus() != 6) {
            this.jvr.ctK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void ctL() {
        this.jvD.setVisibility(4);
        if (this.jtH.getStatus() != 6) {
            this.jvr.ctL();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctM() {
        this.jvL = true;
        if (this.jvF != null && this.jvF.isRunning()) {
            this.jvF.cancel();
        }
        if (this.jvE == null) {
            this.jvE = new AnimatorSet();
            this.jvE.playTogether(ObjectAnimator.ofFloat(this.jvs, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jvz, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.jvQ, "alpha", 1.0f, 0.0f));
            this.jvE.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxr) {
                        RecordVideoActivity.this.jvs.setVisibility(8);
                        RecordVideoActivity.this.jvz.setVisibility(8);
                        RecordVideoActivity.this.jvQ.setVisibility(8);
                    }
                }
            });
            this.jvE.setDuration(300L);
        }
        this.jvE.start();
        this.jvz.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctB() {
        if (this.fFX == 2) {
            if (this.jvL) {
                this.jvL = false;
                if (this.jvP != null) {
                    this.jvP.ctB();
                }
            } else {
                return;
            }
        }
        if (this.jvE != null && this.jvE.isRunning()) {
            this.jvE.cancel();
        }
        if (this.jvF == null) {
            this.jvF = new AnimatorSet();
            this.jvF.playTogether(ObjectAnimator.ofFloat(this.jvs, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jvz, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.jvQ, "alpha", 0.0f, 1.0f));
            this.jvF.setDuration(300L);
        }
        this.jvs.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 18) {
            this.jvz.setVisibility(0);
        }
        if (this.jtH.getStatus() == 1) {
            this.jvQ.setVisibility(0);
        }
        this.jvF.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctN() {
        if (this.jtP != null) {
            this.jtP.a(new g.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.g.a
                public void y(boolean z, String str) {
                    RecordVideoActivity.this.jtH.setStatus(1);
                    RecordVideoActivity.this.ctB();
                    if (z) {
                        if (RecordVideoActivity.this.mWriteImagesInfo != null) {
                            if (RecordVideoActivity.this.jvR != null && !v.aa(RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles()) && RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().contains(RecordVideoActivity.this.jvR)) {
                                RecordVideoActivity.this.mWriteImagesInfo.getChosedFiles().remove(RecordVideoActivity.this.jvR);
                            }
                        } else {
                            RecordVideoActivity.this.mWriteImagesInfo = new WriteImagesInfo();
                        }
                        RecordVideoActivity.this.jvR = new ImageFileInfo();
                        RecordVideoActivity.this.jvR.setFilePath(str);
                        RecordVideoActivity.this.jvR.setTempFile(true);
                        RecordVideoActivity.this.jvR.setAlbumnId(null);
                        RecordVideoActivity.this.jvR.setIsFromCamera(true);
                        RecordVideoActivity.this.mWriteImagesInfo.addChooseFile(RecordVideoActivity.this.jvR);
                        if (RecordVideoActivity.this.getIntent().getIntExtra("from_type", 0) != 2) {
                            RecordVideoActivity.this.sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(RecordVideoActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, RecordVideoActivity.this.mWriteImagesInfo, RecordVideoActivity.this.mWriteImagesInfo.size() - 1, RecordVideoActivity.this.jvK, RecordVideoActivity.this.jvJ)));
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
    public void ctO() {
        this.jvG.cancel();
        this.jvG.setAnimationListener(null);
        this.jvy.clearAnimation();
        this.jvy.setVisibility(8);
        if (this.jvP != null) {
            this.jvP.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctP() {
        ckY();
    }

    private void ckY() {
        if (this.jvH != null) {
            this.jvH.cancel();
        }
        if (this.jvI == null) {
            this.jvI = ObjectAnimator.ofFloat(this.jvQ, "alpha", 1.0f, 0.0f);
            this.jvI.setDuration(500L);
            this.jvI.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.jxr) {
                        RecordVideoActivity.this.jvQ.setVisibility(8);
                    }
                }
            });
        }
        this.jvI.start();
    }

    private void ckX() {
        if (this.jvI != null) {
            this.jvI.cancel();
        }
        if (this.jvH == null) {
            this.jvH = ObjectAnimator.ofFloat(this.jvQ, "alpha", 0.0f, 1.0f);
            this.jvH.setDuration(500L);
        }
        this.jvQ.setVisibility(0);
        this.jvH.start();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctQ() {
        this.jvz.reset();
        if (this.jtH.getStatus() == 1) {
            ckX();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctR() {
        if (this.jvB.getVisibility() != 0) {
            this.jvr.ctY();
            this.jtH.setStatus(8);
            ctB();
            if (this.jtP.juw != null && this.jtP.juw.size() > 0) {
                this.jvB.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 extends BdAsyncTask<Void, Void, com.baidu.tieba.video.meida.i> {
        final int jvV = 50;
        final int jvW = 1;
        Handler jvX = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.jvC.aT(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.ctV();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void ctV() {
            this.jvX.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public com.baidu.tieba.video.meida.i doInBackground(Void... voidArr) {
            ctV();
            boolean z = RecordVideoActivity.this.jvP == null || TextUtils.isEmpty(RecordVideoActivity.this.jvP.ctA()) || !new File(RecordVideoActivity.this.jvP.ctA()).exists();
            if (RecordVideoActivity.this.jtP.juw.size() > 1) {
                return com.baidu.tieba.video.meida.h.csN().a(RecordVideoActivity.this.jtP.juw, RecordVideoActivity.this.jtP.cte(), z);
            }
            File file = new File(RecordVideoActivity.this.jtP.juw.get(0));
            if (!file.exists()) {
                return null;
            }
            if (z) {
                try {
                    com.baidu.adp.lib.util.f.c(file, new File(RecordVideoActivity.this.jtP.cte()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new com.baidu.tieba.video.meida.i(0, "");
            }
            return com.baidu.tieba.video.meida.h.csN().a(RecordVideoActivity.this.jtP.juw, RecordVideoActivity.this.jtP.cte(), z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onPostExecute(com.baidu.tieba.video.meida.i iVar) {
            RecordVideoActivity.this.jvr.cue();
            if (iVar != null && iVar.result == 0) {
                if (!XiaoyingUtil.isXiaoyingInstalled() || XiaoyingUtil.isXiaoyingForbidden()) {
                    RecordVideoActivity.this.ctC();
                    RecordVideoActivity.this.BL(102);
                    RecordVideoActivity.this.jvB.setVisibility(8);
                    return;
                }
                RecordVideoActivity.this.ctC();
                RecordVideoActivity.this.BL(102);
                RecordVideoActivity.this.jvB.setVisibility(8);
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(R.string.mix_fail));
                RecordVideoActivity.this.jvB.setVisibility(8);
                if (iVar != null) {
                    RecordVideoActivity.this.av(iVar.result, iVar.msg);
                }
            }
            RecordVideoActivity.this.jvC.aT(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.jvr == null || v.aa(this.jvr.getChoosedBeautyList())) {
            return arrayList;
        }
        for (e eVar : this.jvr.getChoosedBeautyList()) {
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
        if (this.jvr == null || v.aa(this.jvr.getChoosedFilterList())) {
            return arrayList;
        }
        for (e eVar : this.jvr.getChoosedFilterList()) {
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
        if (this.jvr == null || v.aa(this.jvr.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.jvr.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctS() {
        this.jvD.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctT() {
        this.jvD.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void ctU() {
        if (this.jtH.getStatus() == 1) {
            this.jvQ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(e eVar, Object obj) {
        if (this.jtP != null && eVar != null) {
            switch (eVar.getType()) {
                case 1:
                    if (eVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.jtP.setBeautyLevel((com.baidu.tieba.video.a) eVar.getValue());
                        TiebaStatic.log(new am("c12421").P(VideoPlayActivityConfig.OBJ_ID, ((com.baidu.tieba.video.a) eVar.getValue()).level));
                        if (((com.baidu.tieba.video.a) eVar.getValue()).level == 0) {
                            this.jvz.setViewChoosed(2, false);
                            return;
                        } else {
                            this.jvz.setViewChoosed(2, true);
                            return;
                        }
                    }
                    return;
                case 2:
                    if (eVar.getValue() instanceof String) {
                        this.jtP.setFilter((String) eVar.getValue());
                        am amVar = new am("c12496");
                        amVar.bT(VideoPlayActivityConfig.OBJ_ID, (String) eVar.getValue());
                        if (this.jtH.getStatus() == 1) {
                            amVar.P("obj_type", 1);
                        } else {
                            amVar.P("obj_type", 2);
                        }
                        if (eVar.getValue().equals("origin")) {
                            this.jvz.setViewChoosed(3, false);
                            return;
                        } else {
                            this.jvz.setViewChoosed(3, true);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (eVar.getValue() instanceof MusicData) {
                        this.jvP.a((MusicData) eVar.getValue(), obj);
                        if (((MusicData) eVar.getValue()).editMusicType == 1) {
                            this.jvz.setViewChoosed(0, false);
                            return;
                        } else {
                            this.jvz.setViewChoosed(0, true);
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
            this.jvO = stickerItem;
            this.jvN.Fq(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.jtP != null) {
                    this.jtP.setSticker(null);
                    this.jvT = false;
                }
                if (this.jvr != null) {
                    this.jvr.setDownLoadSticker(null);
                }
                this.jvA.setVisibility(8);
                this.jvz.setViewChoosed(1, false);
                return;
            }
            String Fn = this.jvN.Fn(stickerItem.resource);
            if (!StringUtils.isNull(Fn)) {
                a(stickerItem, Fn);
                if (this.jvr != null) {
                    this.jvr.setDownLoadSticker(null);
                }
            } else {
                if (this.jvr != null) {
                    this.jvr.setDownLoadSticker(stickerItem);
                }
                this.jvN.Fo(stickerItem.resource);
            }
            this.jvz.setViewChoosed(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.jtP != null) {
                this.jtP.setSticker(stickerItem);
                this.jvT = true;
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.jvA.setText(stickerItem.desc);
                this.jvA.setVisibility(0);
                this.jvA.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.jvA.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.jvA.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.c
    public void cD(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.s(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.jvr.getLayoutParams();
            layoutParams.height = i4;
            this.jvr.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String EY = com.baidu.tieba.video.editvideo.model.a.crM().EY(stringExtra);
                if (this.jvP != null && !TextUtils.isEmpty(EY)) {
                    this.jvP.es(EY, stringExtra2);
                    this.jvr.csS();
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
        if (this.jtH.getStatus() == 8) {
            this.jvr.ctX();
        }
    }

    @Override // com.baidu.tieba.video.record.GLVideoPreviewView.a
    public void ry(boolean z) {
        if (this.jtH != null && (this.jtH.getStatus() == 1 || this.jtH.getStatus() == 3 || this.jtH.getStatus() == 4)) {
            if (!z && this.jvT) {
                this.jvx.aTd();
                return;
            } else {
                this.jvx.aTe();
                return;
            }
        }
        this.jvx.aTe();
    }

    @Override // com.baidu.tieba.video.record.RecordTabLayout.a
    public void R(int i, boolean z) {
        int i2 = 1;
        if (this.fFX != i) {
            switch (i) {
                case 1:
                    if (this.jvP != null) {
                        this.jvP.aAl();
                    }
                    this.jtP.setFilter("origin");
                    this.jvz.setViewChoosed(0, false);
                    this.jvz.setViewChoosed(3, false);
                    this.jvr.BN(1);
                    this.jvz.setViewVisibility(0, 8);
                    this.jvz.setViewVisibility(3, 8);
                    break;
                case 2:
                    this.jvz.setViewVisibility(0, 0);
                    this.jvz.setViewVisibility(3, 0);
                    i2 = 2;
                    break;
            }
            this.fFX = i;
            this.jvr.setCurrentTab(i);
            if (z) {
                TiebaStatic.log(new am().P("obj_type", i2));
            }
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void ctz() {
        if (this.jtH.getStatus() == 1 && !this.jvr.cuc()) {
            R(1, true);
            this.jvQ.setCurrentTab(1, true);
        }
    }

    @Override // com.baidu.tieba.video.record.RecordLayout.a
    public void cty() {
        if (this.jtH.getStatus() == 1 && !this.jvr.cuc()) {
            R(2, true);
            this.jvQ.setCurrentTab(2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL(int i) {
        if (this.iZX != null) {
            this.iZX.aw(i, "record");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void av(int i, String str) {
        if (this.iZX != null) {
            if (StringUtils.isNull(str)) {
                str = "";
            }
            this.iZX.av(i, str);
        }
    }
}
