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
import android.view.animation.OvershootInterpolator;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.EditVideoActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.tieba.video.editvideo.model.SelectMusicModel;
import com.baidu.tieba.video.localvideo.b;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.video.record.h;
import com.baidu.tieba.video.record.l;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class RecordVideoActivity extends BaseActivity implements VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.b {
    private ImageView eUY;
    private String gEL;
    private SelectMusicModel gEP;
    private com.baidu.tieba.video.localvideo.g gEU;
    private String gHj;
    protected h gJz;
    private i gKJ;
    private VideoControllerLayout gKK;
    private RelativeLayout gKL;
    private ImageView gKM;
    private ImageView gKN;
    private ImageView gKO;
    private com.baidu.tbadk.core.dialog.a gKP;
    private FrameLayout gKQ;
    private TextView gKR;
    private VideoEffectButtonLayout gKS;
    private View gKT;
    private TextView gKU;
    private View gKV;
    private RoundProgressBar gKW;
    private TextView gKX;
    private AnimatorSet gKY;
    private AnimatorSet gKZ;
    private ScaleAnimation gLa;
    private boolean gLb;
    private l gLd;
    private StickerItem gLe;
    protected j gLf;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean gLc = true;
    private boolean gEX = false;
    private boolean gEV = false;
    private boolean gEW = false;
    private Handler gEZ = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            RecordVideoActivity.this.gEZ.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    RecordVideoActivity.this.gEZ.sendMessageDelayed(RecordVideoActivity.this.gEZ.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!RecordVideoActivity.this.gEX) {
                        RecordVideoActivity.this.gHj = null;
                        RecordVideoActivity.this.bAP();
                        break;
                    }
                    break;
                case 3:
                    RecordVideoActivity.this.gEW = true;
                    if (!StringUtils.isNull(RecordVideoActivity.this.gHj)) {
                        File file = new File(RecordVideoActivity.this.gHj);
                        RecordVideoActivity.this.gHj = RecordVideoActivity.this.gHj.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(RecordVideoActivity.this.gHj));
                    }
                    RecordVideoActivity.this.gKV.setVisibility(8);
                    if (!RecordVideoActivity.this.gEV) {
                        RecordVideoActivity.this.bAP();
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    com.baidu.tieba.video.localvideo.g byP = RecordVideoActivity.this.byP();
                    if (byP != null && byP.isConvertRunning()) {
                        RecordVideoActivity.this.byO();
                        RecordVideoActivity.this.bAP();
                        return;
                    }
                    return;
                default:
                    return;
            }
            RecordVideoActivity.this.gEW = false;
            RecordVideoActivity.this.gKV.setVisibility(8);
        }
    };
    private b.a gHm = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dD(List<com.baidu.tieba.video.localvideo.d> list) {
            if (v.v(list)) {
                if (RecordVideoActivity.this.gKK != null) {
                    RecordVideoActivity.this.gKK.setHasLocalVideo(false);
                }
            } else if (RecordVideoActivity.this.gKK != null) {
                RecordVideoActivity.this.gKK.setHasLocalVideo(true);
                RecordVideoActivity.this.gLc = false;
            }
        }
    };
    private HttpMessageListener gLg = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
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
                if (RecordVideoActivity.this.gKK != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(0, stickerItem);
                    RecordVideoActivity.this.gKK.setStickerItems(list);
                }
            }
        }
    };
    private final CustomMessageListener cOJ = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                RecordVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.video.localvideo.g byP() {
        if (this.gEU == null) {
            this.gEU = new com.baidu.tieba.video.localvideo.g(this);
            this.gEU.a(new com.baidu.tieba.video.localvideo.f() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
                @Override // com.baidu.tieba.video.localvideo.f
                public void byZ() {
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void uQ(int i) {
                    RecordVideoActivity.this.gEZ.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertSuccess() {
                    RecordVideoActivity.this.gEZ.sendEmptyMessage(3);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertFailed() {
                    RecordVideoActivity.this.gEZ.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertProgress(int i) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    RecordVideoActivity.this.gEZ.sendMessage(obtain);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertAborted() {
                    RecordVideoActivity.this.gEZ.sendEmptyMessage(4);
                }
            });
        }
        return this.gEU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byO() {
        byP().abortConvert();
        this.gEX = true;
        if (this.gHj != null) {
            File file = new File(this.gHj);
            if (file.exists()) {
                file.delete();
            }
        }
        this.gKV.setVisibility(8);
        this.gHj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAP() {
        if (TextUtils.isEmpty(this.gHj)) {
            this.gHj = this.gJz.gER;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gHj);
        videoInfo.setVideoDuration(this.gKJ.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gHj).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gEL, videoInfo);
        if (this.gLf != null) {
            this.gLf.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.gEZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                RecordVideoActivity.this.gKK.vb(1);
            }
        }, 1000L);
        this.gHj = null;
        this.gEW = false;
        this.gEX = false;
        this.gKJ.LR();
        this.gJz.bAv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gEV = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gEV = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gEU != null) {
            this.gEU.destroy();
        }
        if (this.gEZ != null) {
            this.gEZ.removeMessages(5);
        }
        if (this.gKJ != null && this.gKJ.isRecording()) {
            this.gKJ.stopRecord();
        }
        if (this.gEP != null) {
            this.gEP.cancelLoadData();
        }
    }

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_STICKERS, TbConfig.SERVER_ADDRESS + TbConfig.GET_STICKERS);
        tbHttpMessageTask.setResponsedClass(ResponseGetStickersMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
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
        setContentView(d.h.record_activity);
        initUI();
        this.gEP = new SelectMusicModel(getPageContext(), this.gKK);
        this.gEP.bzi();
        this.gLf = new j(this);
        this.gLf.b(this.gEP);
        this.gKJ.a(this.gLf);
        bAQ();
        registerListener(this.gLg);
        registerListener(this.cOJ);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getStringExtra("forum_id");
        this.gEL = getIntent().getStringExtra("video_title");
    }

    private void bAQ() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bzE() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gHm);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gKJ = new i(this);
        this.gKK = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gKK.setRecordController(this.gKJ);
        this.gKK.setRecordControlListener(this);
        this.gKK.setEffectChoosedListener(this);
        this.gKL = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.eUY = (ImageView) findViewById(d.g.close_page);
        this.eUY.setOnClickListener(this);
        this.gKM = (ImageView) findViewById(d.g.flash_switch);
        this.gKM.setOnClickListener(this);
        this.gKN = (ImageView) findViewById(d.g.camera_switch);
        this.gKN.setOnClickListener(this);
        this.gKO = (ImageView) findViewById(d.g.count_down);
        this.gKO.setOnClickListener(this);
        this.gKQ = (FrameLayout) findViewById(d.g.video_surface_container);
        this.gJz = new h(this);
        this.gJz.a(this);
        this.gKS = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gKS.setListener(this);
        this.gKJ.a(this.gKS);
        this.gKT = findViewById(d.g.iv_effect_indicator);
        this.gKR = (TextView) findViewById(d.g.tv_count_down);
        this.gKU = (TextView) findViewById(d.g.gesture_guide_tv);
        int ae = ((com.baidu.adp.lib.util.l.ae(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds150);
        if (this.gKR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gKR.getLayoutParams()).topMargin = ae;
        }
        if (getIntent() != null) {
            this.gKK.setForumId(getIntent().getStringExtra("forum_id"));
            this.gKK.setForumName(getIntent().getStringExtra("forum_name"));
            this.gKK.setVideoTitle(getIntent().getStringExtra("video_title"));
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gKS.setVisibility(8);
        }
        this.gKV = findViewById(d.g.progress_layout);
        this.gKW = (RoundProgressBar) this.gKV.findViewById(d.g.video_progress);
        this.gKX = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gKX.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ac(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds38);
        this.gKX.setLayoutParams(layoutParams);
    }

    private void F(int i, boolean z) {
        this.gKT.setVisibility(0);
        float ac = ((com.baidu.adp.lib.util.l.ac(this.mContext) * 0.25f) * (i + 0.5f)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds12);
        if (z) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gKT, "translationX", this.gKT.getTranslationX(), ac);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
            ofFloat.start();
            return;
        }
        this.gKT.setTranslationX(ac);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gJz.onResume();
        if (this.gLd == null) {
            this.gLd = new l();
            this.gLd.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                @Override // com.baidu.tieba.video.record.l.a
                public void cj(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gLe, str2);
                    if (RecordVideoActivity.this.gKK != null) {
                        RecordVideoActivity.this.gKK.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void tl(String str) {
                    if (RecordVideoActivity.this.gKK != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gKK.b(stickerItem);
                        if (RecordVideoActivity.this.gJz != null) {
                            RecordVideoActivity.this.gJz.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gKK != null) {
                        RecordVideoActivity.this.gKK.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void byC() {
                    if (RecordVideoActivity.this.gKK != null) {
                        RecordVideoActivity.this.gKK.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gLd.bBd();
        if (this.gKK != null && this.gLc) {
            bzE();
        }
        if (this.gEW && !TextUtils.isEmpty(this.gHj) && new File(this.gHj).exists()) {
            bAP();
        }
        if (this.gLf != null) {
            this.gLf.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gJz.onPause();
        if (this.gKK != null) {
            if (this.gKJ != null && this.gKJ.getStatus() == 6) {
                this.gKK.stopRecord();
                bAY();
            }
            if (this.gKJ != null && this.gKJ.isRecording()) {
                this.gKK.stopRecord();
            }
        }
        if (this.gLf != null) {
            this.gLf.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gKJ == null || this.gKJ.getStatus() != 7) {
            if (this.gKJ != null && this.gKJ.getStatus() == 6) {
                if (this.gKK != null) {
                    this.gKK.stopRecord();
                }
                bAY();
            } else if (this.gKJ.onBackPressed()) {
                finish();
            } else {
                if (this.gKP == null) {
                    this.gKP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gKP.cc(d.j.video_quit_confirm);
                    this.gKP.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gKP.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gKP.ao(true);
                    this.gKP.b(getPageContext());
                }
                this.gKP.th();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gKX.setVisibility(4);
        if (view == this.eUY) {
            onBackPressed();
        } else if (view == this.gKM) {
            if (this.gKJ.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gJz.bAE();
            if (this.gJz.bAF()) {
                this.gKM.setImageResource(d.f.icon_video_flashon_n);
            } else {
                this.gKM.setImageResource(d.f.icon_video_flashoff_n);
            }
        } else if (view == this.gKN) {
            if (this.gKJ.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gKN.setOnClickListener(null);
            this.gJz.bAG();
            this.gKN.setOnClickListener(this);
        } else if (view == this.gKO) {
            bAS();
        }
    }

    public FrameLayout bAR() {
        return this.gKQ;
    }

    public void bAS() {
        this.gKX.setVisibility(4);
        this.gKT.setVisibility(8);
        if (this.gKJ.getStatus() != 6) {
            this.gKJ.setStatus(6);
            bAX();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gLa == null) {
                this.gLa = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gLa.setDuration(500L);
                this.gLa.setRepeatCount(5);
                this.gLa.setRepeatMode(2);
                this.gLa.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gLa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gKJ.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gKR.setVisibility(0);
                        RecordVideoActivity.this.gKR.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gKR.setVisibility(8);
                    if (RecordVideoActivity.this.gKJ.getStatus() == 6) {
                        RecordVideoActivity.this.gKK.bBg();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gKJ.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gKR.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gKR.setText("");
                        }
                    }
                }
            });
            this.gKR.setAnimation(this.gLa);
            this.gLa.startNow();
            this.gKK.bAS();
            if (this.gLf != null) {
                this.gLf.bAN();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAT() {
        if (this.gKJ.getStatus() == 1) {
            this.gKX.setVisibility(4);
            F(0, this.gKK.bBj());
            if (this.gKJ.getStatus() != 6) {
                this.gKK.bAT();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAU() {
        this.gKX.setVisibility(4);
        F(1, this.gKK.bBj());
        if (this.gKJ.getStatus() != 6) {
            this.gKK.bAU();
            if (this.gKK.bBk()) {
                bAQ();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAV() {
        this.gKX.setVisibility(4);
        F(2, this.gKK.bBj());
        if (this.gKJ.getStatus() != 6) {
            this.gKK.bAV();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAW() {
        this.gKX.setVisibility(4);
        F(3, this.gKK.bBj());
        if (this.gKJ.getStatus() != 6) {
            this.gKK.bAW();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAX() {
        this.gLb = true;
        if (this.gKZ != null && this.gKZ.isRunning()) {
            this.gKZ.cancel();
        }
        if (this.gKY == null) {
            this.gKY = new AnimatorSet();
            this.gKY.playTogether(ObjectAnimator.ofFloat(this.gKL, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gKT, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gKS, "alpha", 1.0f, 0.0f));
            this.gKY.addListener(new n() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gMy) {
                        RecordVideoActivity.this.gKL.setVisibility(8);
                        RecordVideoActivity.this.gKS.setVisibility(8);
                    }
                }
            });
            this.gKY.setDuration(300L);
        }
        this.gKY.start();
        this.gKS.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAN() {
        if (this.gLb) {
            if (this.gLf != null) {
                this.gLf.bAN();
            }
            this.gLb = false;
            if (this.gKY != null && this.gKY.isRunning()) {
                this.gKY.cancel();
            }
            if (this.gKZ == null) {
                this.gKZ = new AnimatorSet();
                this.gKZ.playTogether(ObjectAnimator.ofFloat(this.gKL, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gKT, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gKS, "alpha", 0.0f, 1.0f));
                this.gKZ.setDuration(300L);
            }
            this.gKL.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 18) {
                this.gKS.setVisibility(0);
            }
            this.gKZ.start();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAY() {
        this.gLa.cancel();
        this.gLa.setAnimationListener(null);
        this.gKR.clearAnimation();
        this.gKR.setVisibility(8);
        if (this.gLf != null) {
            this.gLf.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAZ() {
        this.gKS.reset();
        this.gKT.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAO() {
        if (this.gKV.getVisibility() != 0) {
            this.gKK.bBf();
            if (this.gKJ.getVideoDuration() >= 3000.0f) {
                this.gKJ.setStatus(4);
            } else {
                this.gKJ.setStatus(3);
            }
            bAN();
            if (this.gJz.gKg != null && this.gJz.gKg.size() > 0) {
                this.gKV.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends BdAsyncTask<Void, Void, Boolean> {
        final int gLi = 50;
        final int gLj = 1;
        Handler gLk = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gKW.af(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bBc();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bBc() {
            this.gLk.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            boolean z = true;
            bBc();
            boolean z2 = RecordVideoActivity.this.gLf == null || TextUtils.isEmpty(RecordVideoActivity.this.gLf.bAM()) || !new File(RecordVideoActivity.this.gLf.bAM()).exists();
            if (RecordVideoActivity.this.gJz.gKg.size() > 1) {
                z = com.baidu.tieba.video.meida.g.bzY().a(RecordVideoActivity.this.gJz.gKg, RecordVideoActivity.this.gJz.bAy(), z2);
            } else {
                File file = new File(RecordVideoActivity.this.gJz.gKg.get(0));
                if (!file.exists()) {
                    z = false;
                } else if (z2) {
                    file.renameTo(new File(RecordVideoActivity.this.gJz.bAy()));
                } else {
                    z = com.baidu.tieba.video.meida.g.bzY().a(RecordVideoActivity.this.gJz.gKg, RecordVideoActivity.this.gJz.bAy(), z2);
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            RecordVideoActivity.this.gKK.bBl();
            if (bool != null && bool.booleanValue()) {
                if (XiaoyingUtil.isXiaoyingInstalled() && !XiaoyingUtil.isXiaoyingForbidden()) {
                    if (RecordVideoActivity.this.gKJ.getVideoDuration() < 8000) {
                        com.baidu.tieba.video.localvideo.g byP = RecordVideoActivity.this.byP();
                        if (!byP.isConvertRunning()) {
                            File file = new File(com.baidu.tieba.video.c.gDF, "tieba_" + com.baidu.tieba.video.localvideo.e.tC(RecordVideoActivity.this.gJz.gER) + "_tiebaconverting.mp4");
                            RecordVideoActivity.this.gHj = file.getAbsolutePath();
                            byP.setConvertType(2);
                            byP.cl(RecordVideoActivity.this.gJz.gER, RecordVideoActivity.this.gHj);
                            RecordVideoActivity.this.gEX = false;
                            RecordVideoActivity.this.gEW = false;
                        } else {
                            return;
                        }
                    } else {
                        RecordVideoActivity.this.gHj = RecordVideoActivity.this.gJz.gER;
                        RecordVideoActivity.this.bAP();
                        RecordVideoActivity.this.gKV.setVisibility(8);
                    }
                } else {
                    RecordVideoActivity.this.gHj = RecordVideoActivity.this.gJz.gER;
                    RecordVideoActivity.this.bAP();
                    RecordVideoActivity.this.gKV.setVisibility(8);
                    RecordVideoActivity.this.gLf.bAO();
                    return;
                }
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.gKV.setVisibility(8);
            }
            RecordVideoActivity.this.gKW.af(0.0f);
            RecordVideoActivity.this.gLf.bAO();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gKK == null || v.v(this.gKK.getChoosedBeautyList())) {
            return arrayList;
        }
        for (d dVar : this.gKK.getChoosedBeautyList()) {
            if (dVar != null) {
                String name = dVar.getName();
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
        if (this.gKK == null || v.v(this.gKK.getChoosedFilterList())) {
            return arrayList;
        }
        for (d dVar : this.gKK.getChoosedFilterList()) {
            if (dVar != null) {
                String str = (String) dVar.getValue();
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public List<String> getChoosedStickerList() {
        ArrayList arrayList = new ArrayList();
        if (this.gKK == null || v.v(this.gKK.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gKK.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bBa() {
        this.gKX.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bBb() {
        this.gKX.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(d dVar, Object obj) {
        if (this.gJz != null && dVar != null) {
            switch (dVar.getType()) {
                case 1:
                    if (dVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gJz.setBeautyLevel((com.baidu.tieba.video.a) dVar.getValue());
                        TiebaStatic.log(new ak("c12421").r("obj_id", ((com.baidu.tieba.video.a) dVar.getValue()).level));
                        return;
                    }
                    return;
                case 2:
                    if (dVar.getValue() instanceof String) {
                        this.gJz.setFilter((String) dVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ac("obj_id", (String) dVar.getValue());
                        if (this.gKJ.getStatus() == 1) {
                            akVar.r("obj_type", 1);
                            return;
                        } else {
                            akVar.r("obj_type", 2);
                            return;
                        }
                    }
                    return;
                case 3:
                    if (dVar.getValue() instanceof MusicData) {
                        this.gLf.a((MusicData) dVar.getValue(), obj);
                        return;
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
            this.gLe = stickerItem;
            this.gLd.tJ(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gJz != null) {
                    this.gJz.setSticker(null);
                }
                if (this.gKK != null) {
                    this.gKK.setDownLoadSticker(null);
                }
                this.gKU.setVisibility(8);
                return;
            }
            String tH = this.gLd.tH(stickerItem.resource);
            if (!StringUtils.isNull(tH)) {
                a(stickerItem, tH);
                if (this.gKK != null) {
                    this.gKK.setDownLoadSticker(null);
                    return;
                }
                return;
            }
            if (this.gKK != null) {
                this.gKK.setDownLoadSticker(stickerItem);
            }
            this.gLd.tI(stickerItem.resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gJz != null) {
                this.gJz.setSticker(stickerItem);
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gKU.setText(stickerItem.desc);
                this.gKU.setVisibility(0);
                this.gKU.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gKU.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gKU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.b
    public void cd(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gKK.getLayoutParams();
            layoutParams.height = i4;
            this.gKK.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tp = com.baidu.tieba.video.editvideo.model.a.bzc().tp(stringExtra);
                if (this.gLf != null && !TextUtils.isEmpty(tp)) {
                    this.gLf.ck(tp, stringExtra2);
                    this.gKK.bAn();
                }
            }
        }
    }
}
