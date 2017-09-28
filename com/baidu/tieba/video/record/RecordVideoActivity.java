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
    private StickerItem gAA;
    private i gAg;
    private VideoControllerLayout gAh;
    private RelativeLayout gAi;
    private ImageView gAj;
    private ImageView gAk;
    private com.baidu.tbadk.core.dialog.a gAl;
    private FrameLayout gAm;
    private TextView gAn;
    private VideoEffectButtonLayout gAo;
    private View gAp;
    private TextView gAq;
    private View gAr;
    private RoundProgressBar gAs;
    private TextView gAt;
    private AnimatorSet gAu;
    private AnimatorSet gAv;
    private ObjectAnimator gAw;
    private boolean gAx;
    private k gAz;
    private String gva;
    private com.baidu.tieba.video.localvideo.g gvi;
    private String gwM;
    protected h gyZ;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean gAy = true;
    private boolean gvl = false;
    private boolean gvj = false;
    private boolean gvk = false;
    private Handler gvn = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            RecordVideoActivity.this.gvn.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    RecordVideoActivity.this.gvn.sendMessageDelayed(RecordVideoActivity.this.gvn.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!RecordVideoActivity.this.gvl) {
                        RecordVideoActivity.this.gwM = null;
                        RecordVideoActivity.this.bxt();
                        break;
                    }
                    break;
                case 3:
                    RecordVideoActivity.this.gvk = true;
                    if (!StringUtils.isNull(RecordVideoActivity.this.gwM)) {
                        File file = new File(RecordVideoActivity.this.gwM);
                        RecordVideoActivity.this.gwM = RecordVideoActivity.this.gwM.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(RecordVideoActivity.this.gwM));
                    }
                    RecordVideoActivity.this.gAr.setVisibility(8);
                    if (!RecordVideoActivity.this.gvj) {
                        RecordVideoActivity.this.bxt();
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    com.baidu.tieba.video.localvideo.g bvJ = RecordVideoActivity.this.bvJ();
                    if (bvJ != null && bvJ.isConvertRunning()) {
                        RecordVideoActivity.this.bvI();
                        RecordVideoActivity.this.bxt();
                        return;
                    }
                    return;
                default:
                    return;
            }
            RecordVideoActivity.this.gvk = false;
            RecordVideoActivity.this.gAr.setVisibility(8);
        }
    };
    private b.a gwP = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dA(List<com.baidu.tieba.video.localvideo.d> list) {
            if (v.u(list)) {
                if (RecordVideoActivity.this.gAh != null) {
                    RecordVideoActivity.this.gAh.setHasLocalVideo(false);
                }
            } else if (RecordVideoActivity.this.gAh != null) {
                RecordVideoActivity.this.gAh.setHasLocalVideo(true);
                RecordVideoActivity.this.gAy = false;
            }
        }
    };
    private HttpMessageListener gAB = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
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
                if (RecordVideoActivity.this.gAh != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(0, stickerItem);
                    RecordVideoActivity.this.gAh.setStickerItems(list);
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
    public com.baidu.tieba.video.localvideo.g bvJ() {
        if (this.gvi == null) {
            this.gvi = new com.baidu.tieba.video.localvideo.g(this);
            this.gvi.a(new com.baidu.tieba.video.localvideo.f() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
                @Override // com.baidu.tieba.video.localvideo.f
                public void bvR() {
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void uw(int i) {
                    RecordVideoActivity.this.gvn.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertSuccess() {
                    RecordVideoActivity.this.gvn.sendEmptyMessage(3);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertFailed() {
                    RecordVideoActivity.this.gvn.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertProgress(int i) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    RecordVideoActivity.this.gvn.sendMessage(obtain);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertAborted() {
                    RecordVideoActivity.this.gvn.sendEmptyMessage(4);
                }
            });
        }
        return this.gvi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        bvJ().abortConvert();
        this.gvl = true;
        if (this.gwM != null) {
            File file = new File(this.gwM);
            if (file.exists()) {
                file.delete();
            }
        }
        this.gAr.setVisibility(8);
        this.gwM = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxt() {
        if (TextUtils.isEmpty(this.gwM)) {
            this.gwM = this.gyZ.gvf;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gwM);
        videoInfo.setVideoDuration(this.gAg.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gwM).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.gva, videoInfo)));
        this.gvn.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                RecordVideoActivity.this.gAh.uG(1);
            }
        }, 1000L);
        this.gwM = null;
        this.gvk = false;
        this.gvl = false;
        this.gAg.LD();
        this.gyZ.bxc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.gvj = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.gvj = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gvi != null) {
            this.gvi.destroy();
        }
        if (this.gvn != null) {
            this.gvn.removeMessages(5);
        }
        if (this.gAg != null && this.gAg.isRecording()) {
            this.gAg.stopRecord();
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
        bxu();
        registerListener(this.gAB);
        registerListener(this.cFo);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getStringExtra("forum_id");
        this.gva = getIntent().getStringExtra("video_title");
    }

    private void bxu() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bwp() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gwP);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gAg = new i(this);
        this.gAh = (VideoControllerLayout) findViewById(d.h.record_controller_layout);
        this.gAh.setRecordController(this.gAg);
        this.gAh.setRecordControlListener(this);
        this.gAh.setEffectChoosedListener(this);
        this.gAi = (RelativeLayout) findViewById(d.h.top_control_layout);
        this.bws = (ImageView) findViewById(d.h.close_page);
        this.bws.setOnClickListener(this);
        this.gAj = (ImageView) findViewById(d.h.flash_switch);
        this.gAj.setOnClickListener(this);
        this.gAk = (ImageView) findViewById(d.h.camera_switch);
        this.gAk.setOnClickListener(this);
        this.gAm = (FrameLayout) findViewById(d.h.video_surface_container);
        this.gyZ = new h(this);
        this.gyZ.a(this);
        this.gAo = (VideoEffectButtonLayout) findViewById(d.h.layout_effect_button);
        this.gAo.setListener(this);
        this.gAp = findViewById(d.h.iv_effect_indicator);
        this.gAn = (TextView) findViewById(d.h.tv_count_down);
        this.gAq = (TextView) findViewById(d.h.gesture_guide_tv);
        int af = ((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds150);
        if (this.gAn.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gAn.getLayoutParams()).topMargin = af;
        }
        if (getIntent() != null) {
            this.gAh.setForumId(getIntent().getStringExtra("forum_id"));
            this.gAh.setForumName(getIntent().getStringExtra("forum_name"));
            this.gAh.setVideoTitle(getIntent().getStringExtra("video_title"));
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gAo.setVisibility(8);
        }
        this.gAr = findViewById(d.h.progress_layout);
        this.gAs = (RoundProgressBar) this.gAr.findViewById(d.h.video_progress);
        this.gAt = (TextView) findViewById(d.h.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gAt.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ad(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds38);
        this.gAt.setLayoutParams(layoutParams);
    }

    private void D(int i, boolean z) {
        this.gAp.setVisibility(0);
        float ad = ((com.baidu.adp.lib.util.l.ad(this.mContext) * 0.25f) * (i + 0.5f)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds12);
        if (z) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gAp, "translationX", this.gAp.getTranslationX(), ad);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
            ofFloat.start();
            return;
        }
        this.gAp.setTranslationX(ad);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gyZ.onResume();
        if (this.gAz == null) {
            this.gAz = new k();
            this.gAz.a(new k.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                @Override // com.baidu.tieba.video.record.k.a
                public void cj(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gAA, str2);
                    if (RecordVideoActivity.this.gAh != null) {
                        RecordVideoActivity.this.gAh.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.k.a
                public void sy(String str) {
                    if (RecordVideoActivity.this.gAh != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gAh.b(stickerItem);
                        if (RecordVideoActivity.this.gyZ != null) {
                            RecordVideoActivity.this.gyZ.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gAh != null) {
                        RecordVideoActivity.this.gAh.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.l.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                }

                @Override // com.baidu.tieba.video.record.k.a
                public void bvw() {
                    if (RecordVideoActivity.this.gAh != null) {
                        RecordVideoActivity.this.gAh.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gAz.bxI();
        if (this.gAh != null && this.gAy) {
            bwp();
        }
        if (this.gvk && !TextUtils.isEmpty(this.gwM) && new File(this.gwM).exists()) {
            bxt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gyZ.onPause();
        if (this.gAh != null) {
            if (this.gAg != null && this.gAg.getStatus() == 6) {
                this.gAh.stopRecord();
                bxC();
            }
            if (this.gAg != null && this.gAg.isRecording()) {
                this.gAh.stopRecord();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gAg == null || this.gAg.getStatus() != 7) {
            if (this.gAg != null && this.gAg.getStatus() == 6) {
                if (this.gAh != null) {
                    this.gAh.stopRecord();
                }
                bxC();
            } else if (this.gAg.onBackPressed()) {
                finish();
            } else {
                if (this.gAl == null) {
                    this.gAl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gAl.cd(d.l.video_quit_confirm);
                    this.gAl.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gAl.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gAl.ar(true);
                    this.gAl.b(getPageContext());
                }
                this.gAl.ti();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gAt.setVisibility(4);
        if (view == this.bws) {
            onBackPressed();
        } else if (view == this.gAj) {
            if (this.gAg.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gyZ.bxl();
            if (this.gyZ.bxm()) {
                this.gAj.setImageResource(d.g.icon_video_flashon_n);
            } else {
                this.gAj.setImageResource(d.g.icon_video_flashoff_n);
            }
        } else if (view == this.gAk) {
            if (this.gAg.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gAk.setOnClickListener(null);
            this.gyZ.bxn();
            this.gAk.setOnClickListener(this);
        }
    }

    public FrameLayout bxv() {
        return this.gAm;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxw() {
        this.gAt.setVisibility(4);
        this.gAp.setVisibility(8);
        if (this.gAg.getStatus() != 6) {
            this.gAg.setStatus(6);
            bxA();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gAw == null) {
                this.gAw = ObjectAnimator.ofPropertyValuesHolder(this.gAn, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
                this.gAw.setDuration(500L);
                this.gAw.setRepeatCount(5);
                this.gAw.setRepeatMode(2);
                this.gAw.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gAw.removeAllListeners();
            this.gAw.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (RecordVideoActivity.this.gAg.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gAn.setVisibility(0);
                        RecordVideoActivity.this.gAn.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RecordVideoActivity.this.gAn.setVisibility(8);
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    if (!this.gBQ && RecordVideoActivity.this.gAg.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gAn.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gAn.setText("");
                        }
                    }
                }
            });
            this.gAw.start();
            this.gAh.bxw();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxx() {
        this.gAt.setVisibility(4);
        D(1, this.gAh.bxO());
        if (this.gAg.getStatus() != 6) {
            this.gAh.bxx();
            if (this.gAh.bxP()) {
                bxu();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxy() {
        this.gAt.setVisibility(4);
        D(2, this.gAh.bxO());
        if (this.gAg.getStatus() != 6) {
            this.gAh.bxy();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxz() {
        this.gAt.setVisibility(4);
        D(3, this.gAh.bxO());
        if (this.gAg.getStatus() != 6) {
            this.gAh.bxz();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxA() {
        this.gAx = true;
        if (this.gAv != null && this.gAv.isRunning()) {
            this.gAv.cancel();
        }
        if (this.gAu == null) {
            this.gAu = new AnimatorSet();
            this.gAu.playTogether(ObjectAnimator.ofFloat(this.gAi, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gAp, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gAo, "alpha", 1.0f, 0.0f));
            this.gAu.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBQ) {
                        RecordVideoActivity.this.gAi.setVisibility(8);
                        RecordVideoActivity.this.gAo.setVisibility(8);
                    }
                }
            });
            this.gAu.setDuration(300L);
        }
        this.gAu.start();
        this.gAo.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxB() {
        if (this.gAx) {
            this.gAx = false;
            if (this.gAu != null && this.gAu.isRunning()) {
                this.gAu.cancel();
            }
            if (this.gAv == null) {
                this.gAv = new AnimatorSet();
                this.gAv.playTogether(ObjectAnimator.ofFloat(this.gAi, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gAp, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gAo, "alpha", 0.0f, 1.0f));
                this.gAv.setDuration(300L);
            }
            this.gAi.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 18) {
                this.gAo.setVisibility(0);
            }
            this.gAv.start();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxC() {
        this.gAw.cancel();
        this.gAw.removeAllListeners();
        this.gAn.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxD() {
        this.gAo.reset();
        this.gAp.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxE() {
        if (this.gAr.getVisibility() != 0) {
            this.gAh.bxK();
            if (this.gAg.getVideoDuration() >= 3000.0f) {
                this.gAg.setStatus(4);
            } else {
                this.gAg.setStatus(3);
            }
            bxB();
            if (this.gyZ.gzH != null && this.gyZ.gzH.size() > 0) {
                this.gAr.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends BdAsyncTask<Void, Void, Boolean> {
        final int gAD = 50;
        final int gAE = 1;
        Handler gAF = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gAs.ag(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bxH();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bxH() {
            this.gAF.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            boolean z;
            bxH();
            if (RecordVideoActivity.this.gyZ.gzH.size() > 1) {
                z = com.baidu.tieba.video.meida.g.bwI().j(RecordVideoActivity.this.gyZ.gzH, RecordVideoActivity.this.gyZ.bxf());
            } else {
                File file = new File(RecordVideoActivity.this.gyZ.gzH.get(0));
                if (file.exists()) {
                    file.renameTo(new File(RecordVideoActivity.this.gyZ.bxf()));
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
                    if (RecordVideoActivity.this.gAg.getVideoDuration() < 8000) {
                        com.baidu.tieba.video.localvideo.g bvJ = RecordVideoActivity.this.bvJ();
                        if (!bvJ.isConvertRunning()) {
                            File file = new File(com.baidu.tieba.video.c.gtZ, "tieba_" + com.baidu.tieba.video.localvideo.e.sL(RecordVideoActivity.this.gyZ.gvf) + "_tiebaconverting.mp4");
                            RecordVideoActivity.this.gwM = file.getAbsolutePath();
                            bvJ.setConvertType(2);
                            bvJ.cl(RecordVideoActivity.this.gyZ.gvf, RecordVideoActivity.this.gwM);
                            RecordVideoActivity.this.gvl = false;
                            RecordVideoActivity.this.gvk = false;
                        } else {
                            return;
                        }
                    } else {
                        RecordVideoActivity.this.gwM = RecordVideoActivity.this.gyZ.gvf;
                        RecordVideoActivity.this.bxt();
                        RecordVideoActivity.this.gAr.setVisibility(8);
                    }
                } else {
                    RecordVideoActivity.this.gwM = RecordVideoActivity.this.gyZ.gvf;
                    RecordVideoActivity.this.bxt();
                    RecordVideoActivity.this.gAr.setVisibility(8);
                    return;
                }
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.l.mix_fail));
                RecordVideoActivity.this.gAr.setVisibility(8);
            }
            RecordVideoActivity.this.gAs.ag(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gAh == null || v.u(this.gAh.getChoosedBeautyList())) {
            return arrayList;
        }
        for (d dVar : this.gAh.getChoosedBeautyList()) {
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
        if (this.gAh == null || v.u(this.gAh.getChoosedFilterList())) {
            return arrayList;
        }
        for (d dVar : this.gAh.getChoosedFilterList()) {
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
        if (this.gAh == null || v.u(this.gAh.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gAh.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxF() {
        this.gAt.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxG() {
        this.gAt.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(d dVar) {
        if (this.gyZ != null && dVar != null) {
            switch (dVar.getType()) {
                case 1:
                    if (dVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gyZ.setBeautyLevel((com.baidu.tieba.video.a) dVar.getValue());
                        return;
                    }
                    return;
                case 2:
                    if (dVar.getValue() instanceof String) {
                        this.gyZ.setFilter((String) dVar.getValue());
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
            this.gAA = stickerItem;
            this.gAz.sS(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gyZ != null) {
                    this.gyZ.setSticker(null);
                }
                if (this.gAh != null) {
                    this.gAh.setDownLoadSticker(null);
                }
                this.gAq.setVisibility(8);
                return;
            }
            String sQ = this.gAz.sQ(stickerItem.resource);
            if (!StringUtils.isNull(sQ)) {
                a(stickerItem, sQ);
                if (this.gAh != null) {
                    this.gAh.setDownLoadSticker(null);
                    return;
                }
                return;
            }
            if (this.gAh != null) {
                this.gAh.setDownLoadSticker(stickerItem);
            }
            this.gAz.sR(stickerItem.resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gyZ != null) {
                this.gyZ.setSticker(stickerItem);
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gAq.setText(stickerItem.desc);
                this.gAq.setVisibility(0);
                this.gAq.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gAq.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gAq.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.b
    public void cc(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gAh.getLayoutParams();
            layoutParams.height = i4;
            this.gAh.setLayoutParams(layoutParams);
        }
    }
}
