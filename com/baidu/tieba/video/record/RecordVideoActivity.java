package com.baidu.tieba.video.record;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.video.localvideo.b;
import com.baidu.tieba.video.record.VideoControllerLayout;
import com.baidu.tieba.video.record.VideoEffectButtonLayout;
import com.baidu.tieba.video.record.VideoEffectLayout;
import com.baidu.tieba.video.record.h;
import com.baidu.tieba.video.record.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class RecordVideoActivity extends BaseActivity implements VideoControllerLayout.a, VideoEffectButtonLayout.a, VideoEffectLayout.a, h.b {
    private ImageView bws;
    private i gAf;
    private VideoControllerLayout gAg;
    private RelativeLayout gAh;
    private ImageView gAi;
    private ImageView gAj;
    private com.baidu.tbadk.core.dialog.a gAk;
    private FrameLayout gAl;
    private TextView gAm;
    private VideoEffectButtonLayout gAn;
    private View gAo;
    private TextView gAp;
    private View gAq;
    private RoundProgressBar gAr;
    private TextView gAs;
    private AnimatorSet gAt;
    private AnimatorSet gAu;
    private ObjectAnimator gAv;
    private boolean gAw;
    private k gAy;
    private StickerItem gAz;
    private String guZ;
    private com.baidu.tieba.video.localvideo.g gvh;
    private String gwL;
    protected h gyY;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean gAx = true;
    private boolean gvk = false;
    private boolean gvi = false;
    private boolean gvj = false;
    private Handler gvm = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            RecordVideoActivity.this.gvm.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    RecordVideoActivity.this.gvm.sendMessageDelayed(RecordVideoActivity.this.gvm.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!RecordVideoActivity.this.gvk) {
                        RecordVideoActivity.this.gwL = null;
                        RecordVideoActivity.this.bxs();
                        break;
                    }
                    break;
                case 3:
                    RecordVideoActivity.this.gvj = true;
                    if (!StringUtils.isNull(RecordVideoActivity.this.gwL)) {
                        File file = new File(RecordVideoActivity.this.gwL);
                        RecordVideoActivity.this.gwL = RecordVideoActivity.this.gwL.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(RecordVideoActivity.this.gwL));
                    }
                    RecordVideoActivity.this.gAq.setVisibility(8);
                    if (!RecordVideoActivity.this.gvi) {
                        RecordVideoActivity.this.bxs();
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    com.baidu.tieba.video.localvideo.g bvI = RecordVideoActivity.this.bvI();
                    if (bvI != null && bvI.isConvertRunning()) {
                        RecordVideoActivity.this.bvH();
                        RecordVideoActivity.this.bxs();
                        return;
                    }
                    return;
                default:
                    return;
            }
            RecordVideoActivity.this.gvj = false;
            RecordVideoActivity.this.gAq.setVisibility(8);
        }
    };
    private b.a gwO = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dA(List<com.baidu.tieba.video.localvideo.d> list) {
            if (v.u(list)) {
                if (RecordVideoActivity.this.gAg != null) {
                    RecordVideoActivity.this.gAg.setHasLocalVideo(false);
                }
            } else if (RecordVideoActivity.this.gAg != null) {
                RecordVideoActivity.this.gAg.setHasLocalVideo(true);
                RecordVideoActivity.this.gAx = false;
            }
        }
    };
    private HttpMessageListener gAA = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
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
                if (RecordVideoActivity.this.gAg != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(0, stickerItem);
                    RecordVideoActivity.this.gAg.setStickerItems(list);
                }
            }
        }
    };
    private final CustomMessageListener cFo = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                RecordVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.video.localvideo.g bvI() {
        if (this.gvh == null) {
            this.gvh = new com.baidu.tieba.video.localvideo.g(this);
            this.gvh.a(new com.baidu.tieba.video.localvideo.f() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
                @Override // com.baidu.tieba.video.localvideo.f
                public void bvQ() {
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void uw(int i) {
                    RecordVideoActivity.this.gvm.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertSuccess() {
                    RecordVideoActivity.this.gvm.sendEmptyMessage(3);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertFailed() {
                    RecordVideoActivity.this.gvm.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertProgress(int i) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    RecordVideoActivity.this.gvm.sendMessage(obtain);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertAborted() {
                    RecordVideoActivity.this.gvm.sendEmptyMessage(4);
                }
            });
        }
        return this.gvh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvH() {
        bvI().abortConvert();
        this.gvk = true;
        if (this.gwL != null) {
            File file = new File(this.gwL);
            if (file.exists()) {
                file.delete();
            }
        }
        this.gAq.setVisibility(8);
        this.gwL = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxs() {
        if (TextUtils.isEmpty(this.gwL)) {
            this.gwL = this.gyY.gve;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gwL);
        videoInfo.setVideoDuration(this.gAf.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gwL).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.guZ, videoInfo)));
        this.gvm.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                RecordVideoActivity.this.gAg.uG(1);
            }
        }, 1000L);
        this.gwL = null;
        this.gvj = false;
        this.gvk = false;
        this.gAf.LD();
        this.gyY.bxb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gvi = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gvi = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gvh != null) {
            this.gvh.destroy();
        }
        if (this.gvm != null) {
            this.gvm.removeMessages(5);
        }
        if (this.gAf != null && this.gAf.isRecording()) {
            this.gAf.stopRecord();
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
        setContentView(d.j.record_activity);
        initUI();
        bxt();
        registerListener(this.gAA);
        registerListener(this.cFo);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getStringExtra("forum_id");
        this.guZ = getIntent().getStringExtra("video_title");
    }

    private void bxt() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bwo() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gwO);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gAf = new i(this);
        this.gAg = (VideoControllerLayout) findViewById(d.h.record_controller_layout);
        this.gAg.setRecordController(this.gAf);
        this.gAg.setRecordControlListener(this);
        this.gAg.setEffectChoosedListener(this);
        this.gAh = (RelativeLayout) findViewById(d.h.top_control_layout);
        this.bws = (ImageView) findViewById(d.h.close_page);
        this.bws.setOnClickListener(this);
        this.gAi = (ImageView) findViewById(d.h.flash_switch);
        this.gAi.setOnClickListener(this);
        this.gAj = (ImageView) findViewById(d.h.camera_switch);
        this.gAj.setOnClickListener(this);
        this.gAl = (FrameLayout) findViewById(d.h.video_surface_container);
        this.gyY = new h(this);
        this.gyY.a(this);
        this.gAn = (VideoEffectButtonLayout) findViewById(d.h.layout_effect_button);
        this.gAn.setListener(this);
        this.gAo = findViewById(d.h.iv_effect_indicator);
        this.gAm = (TextView) findViewById(d.h.tv_count_down);
        this.gAp = (TextView) findViewById(d.h.gesture_guide_tv);
        int af = ((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds150);
        if (this.gAm.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gAm.getLayoutParams()).topMargin = af;
        }
        if (getIntent() != null) {
            this.gAg.setForumId(getIntent().getStringExtra("forum_id"));
            this.gAg.setForumName(getIntent().getStringExtra("forum_name"));
            this.gAg.setVideoTitle(getIntent().getStringExtra("video_title"));
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gAn.setVisibility(8);
        }
        this.gAq = findViewById(d.h.progress_layout);
        this.gAr = (RoundProgressBar) this.gAq.findViewById(d.h.video_progress);
        this.gAs = (TextView) findViewById(d.h.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gAs.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ad(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds38);
        this.gAs.setLayoutParams(layoutParams);
    }

    private void D(int i, boolean z) {
        this.gAo.setVisibility(0);
        float ad = ((com.baidu.adp.lib.util.l.ad(this.mContext) * 0.25f) * (i + 0.5f)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds12);
        if (z) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gAo, "translationX", this.gAo.getTranslationX(), ad);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
            ofFloat.start();
            return;
        }
        this.gAo.setTranslationX(ad);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gyY.onResume();
        if (this.gAy == null) {
            this.gAy = new k();
            this.gAy.a(new k.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                @Override // com.baidu.tieba.video.record.k.a
                public void cj(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gAz, str2);
                    if (RecordVideoActivity.this.gAg != null) {
                        RecordVideoActivity.this.gAg.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.k.a
                public void sy(String str) {
                    if (RecordVideoActivity.this.gAg != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gAg.b(stickerItem);
                        if (RecordVideoActivity.this.gyY != null) {
                            RecordVideoActivity.this.gyY.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gAg != null) {
                        RecordVideoActivity.this.gAg.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.l.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                }

                @Override // com.baidu.tieba.video.record.k.a
                public void bvv() {
                    if (RecordVideoActivity.this.gAg != null) {
                        RecordVideoActivity.this.gAg.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gAy.bxH();
        if (this.gAg != null && this.gAx) {
            bwo();
        }
        if (this.gvj && !TextUtils.isEmpty(this.gwL) && new File(this.gwL).exists()) {
            bxs();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gyY.onPause();
        if (this.gAg != null) {
            if (this.gAf != null && this.gAf.getStatus() == 6) {
                this.gAg.stopRecord();
                bxB();
            }
            if (this.gAf != null && this.gAf.isRecording()) {
                this.gAg.stopRecord();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gAf == null || this.gAf.getStatus() != 7) {
            if (this.gAf != null && this.gAf.getStatus() == 6) {
                if (this.gAg != null) {
                    this.gAg.stopRecord();
                }
                bxB();
            } else if (this.gAf.onBackPressed()) {
                finish();
            } else {
                if (this.gAk == null) {
                    this.gAk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gAk.cd(d.l.video_quit_confirm);
                    this.gAk.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gAk.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gAk.ar(true);
                    this.gAk.b(getPageContext());
                }
                this.gAk.ti();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gAs.setVisibility(4);
        if (view == this.bws) {
            onBackPressed();
        } else if (view == this.gAi) {
            if (this.gAf.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gyY.bxk();
            if (this.gyY.bxl()) {
                this.gAi.setImageResource(d.g.icon_video_flashon_n);
            } else {
                this.gAi.setImageResource(d.g.icon_video_flashoff_n);
            }
        } else if (view == this.gAj) {
            if (this.gAf.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gAj.setOnClickListener(null);
            this.gyY.bxm();
            this.gAj.setOnClickListener(this);
        }
    }

    public FrameLayout bxu() {
        return this.gAl;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxv() {
        this.gAs.setVisibility(4);
        this.gAo.setVisibility(8);
        if (this.gAf.getStatus() != 6) {
            this.gAf.setStatus(6);
            bxz();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gAv == null) {
                this.gAv = ObjectAnimator.ofPropertyValuesHolder(this.gAm, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
                this.gAv.setDuration(500L);
                this.gAv.setRepeatCount(5);
                this.gAv.setRepeatMode(2);
                this.gAv.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gAv.removeAllListeners();
            this.gAv.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (RecordVideoActivity.this.gAf.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gAm.setVisibility(0);
                        RecordVideoActivity.this.gAm.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RecordVideoActivity.this.gAm.setVisibility(8);
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    if (!this.gBP && RecordVideoActivity.this.gAf.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gAm.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gAm.setText("");
                        }
                    }
                }
            });
            this.gAv.start();
            this.gAg.bxv();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxw() {
        this.gAs.setVisibility(4);
        D(1, this.gAg.bxN());
        if (this.gAf.getStatus() != 6) {
            this.gAg.bxw();
            if (this.gAg.bxO()) {
                bxt();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxx() {
        this.gAs.setVisibility(4);
        D(2, this.gAg.bxN());
        if (this.gAf.getStatus() != 6) {
            this.gAg.bxx();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxy() {
        this.gAs.setVisibility(4);
        D(3, this.gAg.bxN());
        if (this.gAf.getStatus() != 6) {
            this.gAg.bxy();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxz() {
        this.gAw = true;
        if (this.gAu != null && this.gAu.isRunning()) {
            this.gAu.cancel();
        }
        if (this.gAt == null) {
            this.gAt = new AnimatorSet();
            this.gAt.playTogether(ObjectAnimator.ofFloat(this.gAh, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gAo, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gAn, "alpha", 1.0f, 0.0f));
            this.gAt.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBP) {
                        RecordVideoActivity.this.gAh.setVisibility(8);
                        RecordVideoActivity.this.gAn.setVisibility(8);
                    }
                }
            });
            this.gAt.setDuration(300L);
        }
        this.gAt.start();
        this.gAn.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxA() {
        if (this.gAw) {
            this.gAw = false;
            if (this.gAt != null && this.gAt.isRunning()) {
                this.gAt.cancel();
            }
            if (this.gAu == null) {
                this.gAu = new AnimatorSet();
                this.gAu.playTogether(ObjectAnimator.ofFloat(this.gAh, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gAo, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gAn, "alpha", 0.0f, 1.0f));
                this.gAu.setDuration(300L);
            }
            this.gAh.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 18) {
                this.gAn.setVisibility(0);
            }
            this.gAu.start();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxB() {
        this.gAv.cancel();
        this.gAv.removeAllListeners();
        this.gAm.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxC() {
        this.gAn.reset();
        this.gAo.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxD() {
        if (this.gAq.getVisibility() != 0) {
            this.gAg.bxJ();
            if (this.gAf.getVideoDuration() >= 3000.0f) {
                this.gAf.setStatus(4);
            } else {
                this.gAf.setStatus(3);
            }
            bxA();
            if (this.gyY.gzG != null && this.gyY.gzG.size() > 0) {
                this.gAq.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends BdAsyncTask<Void, Void, Boolean> {
        final int gAC = 50;
        final int gAD = 1;
        Handler gAE = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gAr.ag(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bxG();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bxG() {
            this.gAE.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            boolean z;
            bxG();
            if (RecordVideoActivity.this.gyY.gzG.size() > 1) {
                z = com.baidu.tieba.video.meida.g.bwH().j(RecordVideoActivity.this.gyY.gzG, RecordVideoActivity.this.gyY.bxe());
            } else {
                File file = new File(RecordVideoActivity.this.gyY.gzG.get(0));
                if (file.exists()) {
                    file.renameTo(new File(RecordVideoActivity.this.gyY.bxe()));
                    z = true;
                } else {
                    z = false;
                }
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                if (XiaoyingUtil.isXiaoyingInstalled() && !XiaoyingUtil.isXiaoyingForbidden()) {
                    if (RecordVideoActivity.this.gAf.getVideoDuration() < 8000) {
                        com.baidu.tieba.video.localvideo.g bvI = RecordVideoActivity.this.bvI();
                        if (!bvI.isConvertRunning()) {
                            File file = new File(com.baidu.tieba.video.c.gtY, "tieba_" + com.baidu.tieba.video.localvideo.e.sL(RecordVideoActivity.this.gyY.gve) + "_tiebaconverting.mp4");
                            RecordVideoActivity.this.gwL = file.getAbsolutePath();
                            bvI.setConvertType(2);
                            bvI.cl(RecordVideoActivity.this.gyY.gve, RecordVideoActivity.this.gwL);
                            RecordVideoActivity.this.gvk = false;
                            RecordVideoActivity.this.gvj = false;
                        } else {
                            return;
                        }
                    } else {
                        RecordVideoActivity.this.gwL = RecordVideoActivity.this.gyY.gve;
                        RecordVideoActivity.this.bxs();
                        RecordVideoActivity.this.gAq.setVisibility(8);
                    }
                } else {
                    RecordVideoActivity.this.gwL = RecordVideoActivity.this.gyY.gve;
                    RecordVideoActivity.this.bxs();
                    RecordVideoActivity.this.gAq.setVisibility(8);
                    return;
                }
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.l.mix_fail));
                RecordVideoActivity.this.gAq.setVisibility(8);
            }
            RecordVideoActivity.this.gAr.ag(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gAg == null || v.u(this.gAg.getChoosedBeautyList())) {
            return arrayList;
        }
        for (d dVar : this.gAg.getChoosedBeautyList()) {
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
        if (this.gAg == null || v.u(this.gAg.getChoosedFilterList())) {
            return arrayList;
        }
        for (d dVar : this.gAg.getChoosedFilterList()) {
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
        if (this.gAg == null || v.u(this.gAg.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gAg.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxE() {
        this.gAs.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxF() {
        this.gAs.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(d dVar) {
        if (this.gyY != null && dVar != null) {
            switch (dVar.getType()) {
                case 1:
                    if (dVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gyY.setBeautyLevel((com.baidu.tieba.video.a) dVar.getValue());
                        return;
                    }
                    return;
                case 2:
                    if (dVar.getValue() instanceof String) {
                        this.gyY.setFilter((String) dVar.getValue());
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
            this.gAz = stickerItem;
            this.gAy.sS(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gyY != null) {
                    this.gyY.setSticker(null);
                }
                if (this.gAg != null) {
                    this.gAg.setDownLoadSticker(null);
                }
                this.gAp.setVisibility(8);
                return;
            }
            String sQ = this.gAy.sQ(stickerItem.resource);
            if (!StringUtils.isNull(sQ)) {
                a(stickerItem, sQ);
                if (this.gAg != null) {
                    this.gAg.setDownLoadSticker(null);
                    return;
                }
                return;
            }
            if (this.gAg != null) {
                this.gAg.setDownLoadSticker(stickerItem);
            }
            this.gAy.sR(stickerItem.resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gyY != null) {
                this.gyY.setSticker(stickerItem);
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gAp.setText(stickerItem.desc);
                this.gAp.setVisibility(0);
                this.gAp.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gAp.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gAp.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.b
    public void cc(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gAg.getLayoutParams();
            layoutParams.height = i4;
            this.gAg.setLayoutParams(layoutParams);
        }
    }
}
