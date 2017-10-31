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
    private ImageView eUD;
    private String gDD;
    private SelectMusicModel gDH;
    private com.baidu.tieba.video.localvideo.g gDM;
    private String gGb;
    protected h gIr;
    private i gJB;
    private VideoControllerLayout gJC;
    private RelativeLayout gJD;
    private ImageView gJE;
    private ImageView gJF;
    private ImageView gJG;
    private com.baidu.tbadk.core.dialog.a gJH;
    private FrameLayout gJI;
    private TextView gJJ;
    private VideoEffectButtonLayout gJK;
    private View gJL;
    private TextView gJM;
    private View gJN;
    private RoundProgressBar gJO;
    private TextView gJP;
    private AnimatorSet gJQ;
    private AnimatorSet gJR;
    private ScaleAnimation gJS;
    private boolean gJT;
    private l gJV;
    private StickerItem gJW;
    protected j gJX;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean gJU = true;
    private boolean gDP = false;
    private boolean gDN = false;
    private boolean gDO = false;
    private Handler gDR = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            RecordVideoActivity.this.gDR.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    RecordVideoActivity.this.gDR.sendMessageDelayed(RecordVideoActivity.this.gDR.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!RecordVideoActivity.this.gDP) {
                        RecordVideoActivity.this.gGb = null;
                        RecordVideoActivity.this.bAD();
                        break;
                    }
                    break;
                case 3:
                    RecordVideoActivity.this.gDO = true;
                    if (!StringUtils.isNull(RecordVideoActivity.this.gGb)) {
                        File file = new File(RecordVideoActivity.this.gGb);
                        RecordVideoActivity.this.gGb = RecordVideoActivity.this.gGb.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(RecordVideoActivity.this.gGb));
                    }
                    RecordVideoActivity.this.gJN.setVisibility(8);
                    if (!RecordVideoActivity.this.gDN) {
                        RecordVideoActivity.this.bAD();
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    com.baidu.tieba.video.localvideo.g byD = RecordVideoActivity.this.byD();
                    if (byD != null && byD.isConvertRunning()) {
                        RecordVideoActivity.this.byC();
                        RecordVideoActivity.this.bAD();
                        return;
                    }
                    return;
                default:
                    return;
            }
            RecordVideoActivity.this.gDO = false;
            RecordVideoActivity.this.gJN.setVisibility(8);
        }
    };
    private b.a gGe = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dC(List<com.baidu.tieba.video.localvideo.d> list) {
            if (v.v(list)) {
                if (RecordVideoActivity.this.gJC != null) {
                    RecordVideoActivity.this.gJC.setHasLocalVideo(false);
                }
            } else if (RecordVideoActivity.this.gJC != null) {
                RecordVideoActivity.this.gJC.setHasLocalVideo(true);
                RecordVideoActivity.this.gJU = false;
            }
        }
    };
    private HttpMessageListener gJY = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
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
                if (RecordVideoActivity.this.gJC != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(0, stickerItem);
                    RecordVideoActivity.this.gJC.setStickerItems(list);
                }
            }
        }
    };
    private final CustomMessageListener cOp = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                RecordVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.video.localvideo.g byD() {
        if (this.gDM == null) {
            this.gDM = new com.baidu.tieba.video.localvideo.g(this);
            this.gDM.a(new com.baidu.tieba.video.localvideo.f() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
                @Override // com.baidu.tieba.video.localvideo.f
                public void byN() {
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void uM(int i) {
                    RecordVideoActivity.this.gDR.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertSuccess() {
                    RecordVideoActivity.this.gDR.sendEmptyMessage(3);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertFailed() {
                    RecordVideoActivity.this.gDR.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertProgress(int i) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    RecordVideoActivity.this.gDR.sendMessage(obtain);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertAborted() {
                    RecordVideoActivity.this.gDR.sendEmptyMessage(4);
                }
            });
        }
        return this.gDM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byC() {
        byD().abortConvert();
        this.gDP = true;
        if (this.gGb != null) {
            File file = new File(this.gGb);
            if (file.exists()) {
                file.delete();
            }
        }
        this.gJN.setVisibility(8);
        this.gGb = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAD() {
        if (TextUtils.isEmpty(this.gGb)) {
            this.gGb = this.gIr.gDJ;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gGb);
        videoInfo.setVideoDuration(this.gJB.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gGb).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        EditVideoActivityConfig editVideoActivityConfig = new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gDD, videoInfo);
        if (this.gJX != null) {
            this.gJX.a(editVideoActivityConfig);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editVideoActivityConfig));
        this.gDR.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                RecordVideoActivity.this.gJC.uX(1);
            }
        }, 1000L);
        this.gGb = null;
        this.gDO = false;
        this.gDP = false;
        this.gJB.LG();
        this.gIr.bAj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gDN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gDN = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gDM != null) {
            this.gDM.destroy();
        }
        if (this.gDR != null) {
            this.gDR.removeMessages(5);
        }
        if (this.gJB != null && this.gJB.isRecording()) {
            this.gJB.stopRecord();
        }
        if (this.gDH != null) {
            this.gDH.cancelLoadData();
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
        this.gDH = new SelectMusicModel(getPageContext(), this.gJC);
        this.gDH.byW();
        this.gJX = new j(this);
        this.gJX.b(this.gDH);
        this.gJB.a(this.gJX);
        bAE();
        registerListener(this.gJY);
        registerListener(this.cOp);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getStringExtra("forum_id");
        this.gDD = getIntent().getStringExtra("video_title");
    }

    private void bAE() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bzs() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gGe);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gJB = new i(this);
        this.gJC = (VideoControllerLayout) findViewById(d.g.record_controller_layout);
        this.gJC.setRecordController(this.gJB);
        this.gJC.setRecordControlListener(this);
        this.gJC.setEffectChoosedListener(this);
        this.gJD = (RelativeLayout) findViewById(d.g.top_control_layout);
        this.eUD = (ImageView) findViewById(d.g.close_page);
        this.eUD.setOnClickListener(this);
        this.gJE = (ImageView) findViewById(d.g.flash_switch);
        this.gJE.setOnClickListener(this);
        this.gJF = (ImageView) findViewById(d.g.camera_switch);
        this.gJF.setOnClickListener(this);
        this.gJG = (ImageView) findViewById(d.g.count_down);
        this.gJG.setOnClickListener(this);
        this.gJI = (FrameLayout) findViewById(d.g.video_surface_container);
        this.gIr = new h(this);
        this.gIr.a(this);
        this.gJK = (VideoEffectButtonLayout) findViewById(d.g.layout_effect_button);
        this.gJK.setListener(this);
        this.gJB.a(this.gJK);
        this.gJL = findViewById(d.g.iv_effect_indicator);
        this.gJJ = (TextView) findViewById(d.g.tv_count_down);
        this.gJM = (TextView) findViewById(d.g.gesture_guide_tv);
        int ae = ((com.baidu.adp.lib.util.l.ae(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds150);
        if (this.gJJ.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gJJ.getLayoutParams()).topMargin = ae;
        }
        if (getIntent() != null) {
            this.gJC.setForumId(getIntent().getStringExtra("forum_id"));
            this.gJC.setForumName(getIntent().getStringExtra("forum_name"));
            this.gJC.setVideoTitle(getIntent().getStringExtra("video_title"));
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gJK.setVisibility(8);
        }
        this.gJN = findViewById(d.g.progress_layout);
        this.gJO = (RoundProgressBar) this.gJN.findViewById(d.g.video_progress);
        this.gJP = (TextView) findViewById(d.g.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJP.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ac(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds38);
        this.gJP.setLayoutParams(layoutParams);
    }

    private void E(int i, boolean z) {
        this.gJL.setVisibility(0);
        float ac = ((com.baidu.adp.lib.util.l.ac(this.mContext) * 0.25f) * (i + 0.5f)) - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds12);
        if (z) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gJL, "translationX", this.gJL.getTranslationX(), ac);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
            ofFloat.start();
            return;
        }
        this.gJL.setTranslationX(ac);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gIr.onResume();
        if (this.gJV == null) {
            this.gJV = new l();
            this.gJV.a(new l.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                @Override // com.baidu.tieba.video.record.l.a
                public void cf(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gJW, str2);
                    if (RecordVideoActivity.this.gJC != null) {
                        RecordVideoActivity.this.gJC.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void tf(String str) {
                    if (RecordVideoActivity.this.gJC != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gJC.b(stickerItem);
                        if (RecordVideoActivity.this.gIr != null) {
                            RecordVideoActivity.this.gIr.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gJC != null) {
                        RecordVideoActivity.this.gJC.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.j.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                }

                @Override // com.baidu.tieba.video.record.l.a
                public void byq() {
                    if (RecordVideoActivity.this.gJC != null) {
                        RecordVideoActivity.this.gJC.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gJV.bAR();
        if (this.gJC != null && this.gJU) {
            bzs();
        }
        if (this.gDO && !TextUtils.isEmpty(this.gGb) && new File(this.gGb).exists()) {
            bAD();
        }
        if (this.gJX != null) {
            this.gJX.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gIr.onPause();
        if (this.gJC != null) {
            if (this.gJB != null && this.gJB.getStatus() == 6) {
                this.gJC.stopRecord();
                bAM();
            }
            if (this.gJB != null && this.gJB.isRecording()) {
                this.gJC.stopRecord();
            }
        }
        if (this.gJX != null) {
            this.gJX.onPause();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gJB == null || this.gJB.getStatus() != 7) {
            if (this.gJB != null && this.gJB.getStatus() == 6) {
                if (this.gJC != null) {
                    this.gJC.stopRecord();
                }
                bAM();
            } else if (this.gJB.onBackPressed()) {
                finish();
            } else {
                if (this.gJH == null) {
                    this.gJH = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gJH.cc(d.j.video_quit_confirm);
                    this.gJH.a(d.j.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gJH.b(d.j.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gJH.ao(true);
                    this.gJH.b(getPageContext());
                }
                this.gJH.th();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gJP.setVisibility(4);
        if (view == this.eUD) {
            onBackPressed();
        } else if (view == this.gJE) {
            if (this.gJB.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gIr.bAs();
            if (this.gIr.bAt()) {
                this.gJE.setImageResource(d.f.icon_video_flashon_n);
            } else {
                this.gJE.setImageResource(d.f.icon_video_flashoff_n);
            }
        } else if (view == this.gJF) {
            if (this.gJB.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gJF.setOnClickListener(null);
            this.gIr.bAu();
            this.gJF.setOnClickListener(this);
        } else if (view == this.gJG) {
            bAG();
        }
    }

    public FrameLayout bAF() {
        return this.gJI;
    }

    public void bAG() {
        this.gJP.setVisibility(4);
        this.gJL.setVisibility(8);
        if (this.gJB.getStatus() != 6) {
            this.gJB.setStatus(6);
            bAL();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gJS == null) {
                this.gJS = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                this.gJS.setDuration(500L);
                this.gJS.setRepeatCount(5);
                this.gJS.setRepeatMode(2);
                this.gJS.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gJS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (RecordVideoActivity.this.gJB.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gJJ.setVisibility(0);
                        RecordVideoActivity.this.gJJ.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RecordVideoActivity.this.gJJ.setVisibility(8);
                    if (RecordVideoActivity.this.gJB.getStatus() == 6) {
                        RecordVideoActivity.this.gJC.bAU();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (RecordVideoActivity.this.gJB.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gJJ.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gJJ.setText("");
                        }
                    }
                }
            });
            this.gJJ.setAnimation(this.gJS);
            this.gJS.startNow();
            this.gJC.bAG();
            if (this.gJX != null) {
                this.gJX.bAB();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAH() {
        if (this.gJB.getStatus() == 1) {
            this.gJP.setVisibility(4);
            E(0, this.gJC.bAX());
            if (this.gJB.getStatus() != 6) {
                this.gJC.bAH();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAI() {
        this.gJP.setVisibility(4);
        E(1, this.gJC.bAX());
        if (this.gJB.getStatus() != 6) {
            this.gJC.bAI();
            if (this.gJC.bAY()) {
                bAE();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAJ() {
        this.gJP.setVisibility(4);
        E(2, this.gJC.bAX());
        if (this.gJB.getStatus() != 6) {
            this.gJC.bAJ();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bAK() {
        this.gJP.setVisibility(4);
        E(3, this.gJC.bAX());
        if (this.gJB.getStatus() != 6) {
            this.gJC.bAK();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAL() {
        this.gJT = true;
        if (this.gJR != null && this.gJR.isRunning()) {
            this.gJR.cancel();
        }
        if (this.gJQ == null) {
            this.gJQ = new AnimatorSet();
            this.gJQ.playTogether(ObjectAnimator.ofFloat(this.gJD, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gJL, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gJK, "alpha", 1.0f, 0.0f));
            this.gJQ.addListener(new n() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.n, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gLq) {
                        RecordVideoActivity.this.gJD.setVisibility(8);
                        RecordVideoActivity.this.gJK.setVisibility(8);
                    }
                }
            });
            this.gJQ.setDuration(300L);
        }
        this.gJQ.start();
        this.gJK.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAB() {
        if (this.gJT) {
            if (this.gJX != null) {
                this.gJX.bAB();
            }
            this.gJT = false;
            if (this.gJQ != null && this.gJQ.isRunning()) {
                this.gJQ.cancel();
            }
            if (this.gJR == null) {
                this.gJR = new AnimatorSet();
                this.gJR.playTogether(ObjectAnimator.ofFloat(this.gJD, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gJL, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gJK, "alpha", 0.0f, 1.0f));
                this.gJR.setDuration(300L);
            }
            this.gJD.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 18) {
                this.gJK.setVisibility(0);
            }
            this.gJR.start();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAM() {
        this.gJS.cancel();
        this.gJS.setAnimationListener(null);
        this.gJJ.clearAnimation();
        this.gJJ.setVisibility(8);
        if (this.gJX != null) {
            this.gJX.onResume();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAN() {
        this.gJK.reset();
        this.gJL.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAC() {
        if (this.gJN.getVisibility() != 0) {
            this.gJC.bAT();
            if (this.gJB.getVideoDuration() >= 3000.0f) {
                this.gJB.setStatus(4);
            } else {
                this.gJB.setStatus(3);
            }
            bAB();
            if (this.gIr.gIY != null && this.gIr.gIY.size() > 0) {
                this.gJN.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends BdAsyncTask<Void, Void, Boolean> {
        final int gKa = 50;
        final int gKb = 1;
        Handler gKc = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gJO.af(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bAQ();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bAQ() {
            this.gKc.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            boolean z = true;
            bAQ();
            boolean z2 = RecordVideoActivity.this.gJX == null || TextUtils.isEmpty(RecordVideoActivity.this.gJX.bAA()) || !new File(RecordVideoActivity.this.gJX.bAA()).exists();
            if (RecordVideoActivity.this.gIr.gIY.size() > 1) {
                z = com.baidu.tieba.video.meida.g.bzM().a(RecordVideoActivity.this.gIr.gIY, RecordVideoActivity.this.gIr.bAm(), z2);
            } else {
                File file = new File(RecordVideoActivity.this.gIr.gIY.get(0));
                if (!file.exists()) {
                    z = false;
                } else if (z2) {
                    file.renameTo(new File(RecordVideoActivity.this.gIr.bAm()));
                } else {
                    z = com.baidu.tieba.video.meida.g.bzM().a(RecordVideoActivity.this.gIr.gIY, RecordVideoActivity.this.gIr.bAm(), z2);
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            RecordVideoActivity.this.gJC.bAZ();
            if (bool != null && bool.booleanValue()) {
                if (XiaoyingUtil.isXiaoyingInstalled() && !XiaoyingUtil.isXiaoyingForbidden()) {
                    if (RecordVideoActivity.this.gJB.getVideoDuration() < 8000) {
                        com.baidu.tieba.video.localvideo.g byD = RecordVideoActivity.this.byD();
                        if (!byD.isConvertRunning()) {
                            File file = new File(com.baidu.tieba.video.c.gCx, "tieba_" + com.baidu.tieba.video.localvideo.e.tw(RecordVideoActivity.this.gIr.gDJ) + "_tiebaconverting.mp4");
                            RecordVideoActivity.this.gGb = file.getAbsolutePath();
                            byD.setConvertType(2);
                            byD.ch(RecordVideoActivity.this.gIr.gDJ, RecordVideoActivity.this.gGb);
                            RecordVideoActivity.this.gDP = false;
                            RecordVideoActivity.this.gDO = false;
                        } else {
                            return;
                        }
                    } else {
                        RecordVideoActivity.this.gGb = RecordVideoActivity.this.gIr.gDJ;
                        RecordVideoActivity.this.bAD();
                        RecordVideoActivity.this.gJN.setVisibility(8);
                    }
                } else {
                    RecordVideoActivity.this.gGb = RecordVideoActivity.this.gIr.gDJ;
                    RecordVideoActivity.this.bAD();
                    RecordVideoActivity.this.gJN.setVisibility(8);
                    RecordVideoActivity.this.gJX.bAC();
                    return;
                }
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.j.mix_fail));
                RecordVideoActivity.this.gJN.setVisibility(8);
            }
            RecordVideoActivity.this.gJO.af(0.0f);
            RecordVideoActivity.this.gJX.bAC();
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gJC == null || v.v(this.gJC.getChoosedBeautyList())) {
            return arrayList;
        }
        for (d dVar : this.gJC.getChoosedBeautyList()) {
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
        if (this.gJC == null || v.v(this.gJC.getChoosedFilterList())) {
            return arrayList;
        }
        for (d dVar : this.gJC.getChoosedFilterList()) {
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
        if (this.gJC == null || v.v(this.gJC.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gJC.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAO() {
        this.gJP.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bAP() {
        this.gJP.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(d dVar, Object obj) {
        if (this.gIr != null && dVar != null) {
            switch (dVar.getType()) {
                case 1:
                    if (dVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gIr.setBeautyLevel((com.baidu.tieba.video.a) dVar.getValue());
                        TiebaStatic.log(new ak("c12421").r("obj_id", ((com.baidu.tieba.video.a) dVar.getValue()).level));
                        return;
                    }
                    return;
                case 2:
                    if (dVar.getValue() instanceof String) {
                        this.gIr.setFilter((String) dVar.getValue());
                        ak akVar = new ak("c12496");
                        akVar.ac("obj_id", (String) dVar.getValue());
                        if (this.gJB.getStatus() == 1) {
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
                        this.gJX.a((MusicData) dVar.getValue(), obj);
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
            this.gJW = stickerItem;
            this.gJV.tD(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gIr != null) {
                    this.gIr.setSticker(null);
                }
                if (this.gJC != null) {
                    this.gJC.setDownLoadSticker(null);
                }
                this.gJM.setVisibility(8);
                return;
            }
            String tB = this.gJV.tB(stickerItem.resource);
            if (!StringUtils.isNull(tB)) {
                a(stickerItem, tB);
                if (this.gJC != null) {
                    this.gJC.setDownLoadSticker(null);
                    return;
                }
                return;
            }
            if (this.gJC != null) {
                this.gJC.setDownLoadSticker(stickerItem);
            }
            this.gJV.tC(stickerItem.resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gIr != null) {
                this.gIr.setSticker(stickerItem);
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gJM.setText(stickerItem.desc);
                this.gJM.setVisibility(0);
                this.gJM.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gJM.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gJM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.b
    public void ce(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.e.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gJC.getLayoutParams();
            layoutParams.height = i4;
            this.gJC.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 25032) {
            String stringExtra = intent.getStringExtra("music_resource");
            String stringExtra2 = intent.getStringExtra("music_id");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                String tj = com.baidu.tieba.video.editvideo.model.a.byQ().tj(stringExtra);
                if (this.gJX != null && !TextUtils.isEmpty(tj)) {
                    this.gJX.cg(tj, stringExtra2);
                    this.gJC.bAb();
                }
            }
        }
    }
}
