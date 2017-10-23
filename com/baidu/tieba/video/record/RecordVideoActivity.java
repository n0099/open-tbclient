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
    private ImageView bwg;
    private TextView gAa;
    private View gAb;
    private RoundProgressBar gAc;
    private TextView gAd;
    private AnimatorSet gAe;
    private AnimatorSet gAf;
    private ObjectAnimator gAg;
    private boolean gAh;
    private k gAj;
    private StickerItem gAk;
    private String guL;
    private com.baidu.tieba.video.localvideo.g guT;
    private String gwx;
    protected h gyK;
    private i gzQ;
    private VideoControllerLayout gzR;
    private RelativeLayout gzS;
    private ImageView gzT;
    private ImageView gzU;
    private com.baidu.tbadk.core.dialog.a gzV;
    private FrameLayout gzW;
    private TextView gzX;
    private VideoEffectButtonLayout gzY;
    private View gzZ;
    private Context mContext;
    private String mForumId;
    private String mForumName;
    private boolean gAi = true;
    private boolean guW = false;
    private boolean guU = false;
    private boolean guV = false;
    private Handler guY = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.6
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            RecordVideoActivity.this.guY.removeMessages(5);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    RecordVideoActivity.this.guY.sendMessageDelayed(RecordVideoActivity.this.guY.obtainMessage(5), 60000L);
                    return;
                case 2:
                    if (!RecordVideoActivity.this.guW) {
                        RecordVideoActivity.this.gwx = null;
                        RecordVideoActivity.this.bxk();
                        break;
                    }
                    break;
                case 3:
                    RecordVideoActivity.this.guV = true;
                    if (!StringUtils.isNull(RecordVideoActivity.this.gwx)) {
                        File file = new File(RecordVideoActivity.this.gwx);
                        RecordVideoActivity.this.gwx = RecordVideoActivity.this.gwx.replace("_tiebaconverting.mp4", ".mp4");
                        file.renameTo(new File(RecordVideoActivity.this.gwx));
                    }
                    RecordVideoActivity.this.gAb.setVisibility(8);
                    if (!RecordVideoActivity.this.guU) {
                        RecordVideoActivity.this.bxk();
                        return;
                    }
                    return;
                case 4:
                    break;
                case 5:
                    com.baidu.tieba.video.localvideo.g bvA = RecordVideoActivity.this.bvA();
                    if (bvA != null && bvA.isConvertRunning()) {
                        RecordVideoActivity.this.bvz();
                        RecordVideoActivity.this.bxk();
                        return;
                    }
                    return;
                default:
                    return;
            }
            RecordVideoActivity.this.guV = false;
            RecordVideoActivity.this.gAb.setVisibility(8);
        }
    };
    private b.a gwA = new b.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.8
        @Override // com.baidu.tieba.video.localvideo.b.a
        public void dA(List<com.baidu.tieba.video.localvideo.d> list) {
            if (v.u(list)) {
                if (RecordVideoActivity.this.gzR != null) {
                    RecordVideoActivity.this.gzR.setHasLocalVideo(false);
                }
            } else if (RecordVideoActivity.this.gzR != null) {
                RecordVideoActivity.this.gzR.setHasLocalVideo(true);
                RecordVideoActivity.this.gAi = false;
            }
        }
    };
    private HttpMessageListener gAl = new HttpMessageListener(CmdConfigHttp.CMD_GET_STICKERS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.9
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
                if (RecordVideoActivity.this.gzR != null) {
                    StickerItem stickerItem = new StickerItem();
                    stickerItem.id = -1;
                    stickerItem.isSelect = true;
                    stickerItem.name = "nosticker";
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(0, stickerItem);
                    RecordVideoActivity.this.gzR.setStickerItems(list);
                }
            }
        }
    };
    private final CustomMessageListener cFc = new CustomMessageListener(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData)) {
                RecordVideoActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.video.localvideo.g bvA() {
        if (this.guT == null) {
            this.guT = new com.baidu.tieba.video.localvideo.g(this);
            this.guT.a(new com.baidu.tieba.video.localvideo.f() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.1
                @Override // com.baidu.tieba.video.localvideo.f
                public void bvI() {
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void uv(int i) {
                    RecordVideoActivity.this.guY.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertSuccess() {
                    RecordVideoActivity.this.guY.sendEmptyMessage(3);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertFailed() {
                    RecordVideoActivity.this.guY.sendEmptyMessage(2);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertProgress(int i) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.arg1 = i;
                    RecordVideoActivity.this.guY.sendMessage(obtain);
                }

                @Override // com.baidu.tieba.video.localvideo.f
                public void onConvertAborted() {
                    RecordVideoActivity.this.guY.sendEmptyMessage(4);
                }
            });
        }
        return this.guT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvz() {
        bvA().abortConvert();
        this.guW = true;
        if (this.gwx != null) {
            File file = new File(this.gwx);
            if (file.exists()) {
                file.delete();
            }
        }
        this.gAb.setVisibility(8);
        this.gwx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxk() {
        if (TextUtils.isEmpty(this.gwx)) {
            this.gwx = this.gyK.guQ;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.setVideoPath(this.gwx);
        videoInfo.setVideoDuration(this.gzQ.getVideoDuration() / 1000);
        videoInfo.setVideoWidth(720);
        videoInfo.setVideoHeight(TbConfig.HEAD_IMG_SIZE);
        videoInfo.setVideoLength(new File(this.gwx).length());
        videoInfo.setVideoType(1);
        videoInfo.setIsCompressedVideo(false);
        videoInfo.setBeautifyListInfo(getChoosedBeautyList());
        videoInfo.setFilterListInfo(getChoosedFilterList());
        videoInfo.setStickListInfo(getChoosedStickerList());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditVideoActivityConfig(this, this.mForumName, this.mForumId, this.guL, videoInfo)));
        this.guY.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.7
            @Override // java.lang.Runnable
            public void run() {
                RecordVideoActivity.this.gzR.uF(1);
            }
        }, 1000L);
        this.gwx = null;
        this.guV = false;
        this.guW = false;
        this.gzQ.Lx();
        this.gyK.bwT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.guU = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.guU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.guT != null) {
            this.guT.destroy();
        }
        if (this.guY != null) {
            this.guY.removeMessages(5);
        }
        if (this.gzQ != null && this.gzQ.isRecording()) {
            this.gzQ.stopRecord();
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
        bxl();
        registerListener(this.gAl);
        registerListener(this.cFc);
        this.mForumName = getIntent().getStringExtra("forum_name");
        this.mForumId = getIntent().getStringExtra("forum_id");
        this.guL = getIntent().getStringExtra("video_title");
    }

    private void bxl() {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_STICKERS);
        httpMessage.addParam("pn", 1);
        httpMessage.addParam(LegoListActivityConfig.RN, 999);
        sendMessage(httpMessage);
    }

    private void bwg() {
        com.baidu.tieba.video.localvideo.b bVar = new com.baidu.tieba.video.localvideo.b(this);
        bVar.b(this.gwA);
        bVar.execute(new Void[0]);
    }

    private void initUI() {
        this.gzQ = new i(this);
        this.gzR = (VideoControllerLayout) findViewById(d.h.record_controller_layout);
        this.gzR.setRecordController(this.gzQ);
        this.gzR.setRecordControlListener(this);
        this.gzR.setEffectChoosedListener(this);
        this.gzS = (RelativeLayout) findViewById(d.h.top_control_layout);
        this.bwg = (ImageView) findViewById(d.h.close_page);
        this.bwg.setOnClickListener(this);
        this.gzT = (ImageView) findViewById(d.h.flash_switch);
        this.gzT.setOnClickListener(this);
        this.gzU = (ImageView) findViewById(d.h.camera_switch);
        this.gzU.setOnClickListener(this);
        this.gzW = (FrameLayout) findViewById(d.h.video_surface_container);
        this.gyK = new h(this);
        this.gyK.a(this);
        this.gzY = (VideoEffectButtonLayout) findViewById(d.h.layout_effect_button);
        this.gzY.setListener(this);
        this.gzZ = findViewById(d.h.iv_effect_indicator);
        this.gzX = (TextView) findViewById(d.h.tv_count_down);
        this.gAa = (TextView) findViewById(d.h.gesture_guide_tv);
        int af = ((com.baidu.adp.lib.util.l.af(this.mContext) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds336)) / 2) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds150);
        if (this.gzX.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gzX.getLayoutParams()).topMargin = af;
        }
        if (getIntent() != null) {
            this.gzR.setForumId(getIntent().getStringExtra("forum_id"));
            this.gzR.setForumName(getIntent().getStringExtra("forum_name"));
            this.gzR.setVideoTitle(getIntent().getStringExtra("video_title"));
        }
        if (Build.VERSION.SDK_INT < 18) {
            this.gzY.setVisibility(8);
        }
        this.gAb = findViewById(d.h.progress_layout);
        this.gAc = (RoundProgressBar) this.gAb.findViewById(d.h.video_progress);
        this.gAd = (TextView) findViewById(d.h.min_time_tips);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gAd.getLayoutParams();
        layoutParams.leftMargin = ((int) (com.baidu.adp.lib.util.l.ad(this.mContext) * 0.2d)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds38);
        this.gAd.setLayoutParams(layoutParams);
    }

    private void D(int i, boolean z) {
        this.gzZ.setVisibility(0);
        float ad = ((com.baidu.adp.lib.util.l.ad(this.mContext) * 0.25f) * (i + 0.5f)) - com.baidu.adp.lib.util.l.f(this.mContext, d.f.ds12);
        if (z) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gzZ, "translationX", this.gzZ.getTranslationX(), ad);
            ofFloat.setDuration(500L);
            ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
            ofFloat.start();
            return;
        }
        this.gzZ.setTranslationX(ad);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gyK.onResume();
        if (this.gAj == null) {
            this.gAj = new k();
            this.gAj.a(new k.a() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.10
                @Override // com.baidu.tieba.video.record.k.a
                public void ci(String str, String str2) {
                    RecordVideoActivity.this.a(RecordVideoActivity.this.gAk, str2);
                    if (RecordVideoActivity.this.gzR != null) {
                        RecordVideoActivity.this.gzR.setDownLoadSticker(null);
                    }
                }

                @Override // com.baidu.tieba.video.record.k.a
                public void sx(String str) {
                    if (RecordVideoActivity.this.gzR != null) {
                        StickerItem stickerItem = new StickerItem();
                        stickerItem.id = -1;
                        RecordVideoActivity.this.gzR.b(stickerItem);
                        if (RecordVideoActivity.this.gyK != null) {
                            RecordVideoActivity.this.gyK.setSticker(null);
                        }
                    }
                    if (RecordVideoActivity.this.gzR != null) {
                        RecordVideoActivity.this.gzR.setDownLoadSticker(null);
                    }
                    if (StringUtils.isNull(str)) {
                        RecordVideoActivity.this.showToast(d.l.sticker_download_error);
                    } else {
                        RecordVideoActivity.this.showToast(str);
                    }
                }

                @Override // com.baidu.tieba.video.record.k.a
                public void bvn() {
                    if (RecordVideoActivity.this.gzR != null) {
                        RecordVideoActivity.this.gzR.setDownLoadSticker(null);
                    }
                }
            });
        }
        this.gAj.bxz();
        if (this.gzR != null && this.gAi) {
            bwg();
        }
        if (this.guV && !TextUtils.isEmpty(this.gwx) && new File(this.gwx).exists()) {
            bxk();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.gyK.onPause();
        if (this.gzR != null) {
            if (this.gzQ != null && this.gzQ.getStatus() == 6) {
                this.gzR.stopRecord();
                bxt();
            }
            if (this.gzQ != null && this.gzQ.isRecording()) {
                this.gzR.stopRecord();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.gzQ == null || this.gzQ.getStatus() != 7) {
            if (this.gzQ != null && this.gzQ.getStatus() == 6) {
                if (this.gzR != null) {
                    this.gzR.stopRecord();
                }
                bxt();
            } else if (this.gzQ.onBackPressed()) {
                finish();
            } else {
                if (this.gzV == null) {
                    this.gzV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                    this.gzV.cc(d.l.video_quit_confirm);
                    this.gzV.a(d.l.dialog_ok, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                            RecordVideoActivity.this.finish();
                        }
                    });
                    this.gzV.b(d.l.dialog_cancel, new a.b() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                            aVar.dismiss();
                        }
                    });
                    this.gzV.aq(true);
                    this.gzV.b(getPageContext());
                }
                this.gzV.tb();
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        this.gAd.setVisibility(4);
        if (view == this.bwg) {
            onBackPressed();
        } else if (view == this.gzT) {
            if (this.gzQ.getStatus() == 1) {
                TiebaStatic.log("c12294");
            } else {
                TiebaStatic.log("c12301");
            }
            this.gyK.bxc();
            if (this.gyK.bxd()) {
                this.gzT.setImageResource(d.g.icon_video_flashon_n);
            } else {
                this.gzT.setImageResource(d.g.icon_video_flashoff_n);
            }
        } else if (view == this.gzU) {
            if (this.gzQ.getStatus() == 1) {
                TiebaStatic.log("c12295");
            } else {
                TiebaStatic.log("c12302");
            }
            this.gzU.setOnClickListener(null);
            this.gyK.bxe();
            this.gzU.setOnClickListener(this);
        }
    }

    public FrameLayout bxm() {
        return this.gzW;
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxn() {
        this.gAd.setVisibility(4);
        this.gzZ.setVisibility(8);
        if (this.gzQ.getStatus() != 6) {
            this.gzQ.setStatus(6);
            bxr();
            final AtomicInteger atomicInteger = new AtomicInteger();
            if (this.gAg == null) {
                this.gAg = ObjectAnimator.ofPropertyValuesHolder(this.gzX, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.0f));
                this.gAg.setDuration(500L);
                this.gAg.setRepeatCount(5);
                this.gAg.setRepeatMode(2);
                this.gAg.setInterpolator(new DecelerateInterpolator(2.0f));
            }
            this.gAg.removeAllListeners();
            this.gAg.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.13
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    if (RecordVideoActivity.this.gzQ.getStatus() == 6) {
                        atomicInteger.set(7);
                        RecordVideoActivity.this.gzX.setVisibility(0);
                        RecordVideoActivity.this.gzX.setText(String.valueOf(atomicInteger.get() / 2));
                    }
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    RecordVideoActivity.this.gzX.setVisibility(8);
                }

                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    if (!this.gBA && RecordVideoActivity.this.gzQ.getStatus() == 6) {
                        if (atomicInteger.decrementAndGet() > 1) {
                            RecordVideoActivity.this.gzX.setText(String.valueOf(atomicInteger.get() / 2));
                        } else {
                            RecordVideoActivity.this.gzX.setText("");
                        }
                    }
                }
            });
            this.gAg.start();
            this.gzR.bxn();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxo() {
        this.gAd.setVisibility(4);
        D(1, this.gzR.bxF());
        if (this.gzQ.getStatus() != 6) {
            this.gzR.bxo();
            if (this.gzR.bxG()) {
                bxl();
            }
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxp() {
        this.gAd.setVisibility(4);
        D(2, this.gzR.bxF());
        if (this.gzQ.getStatus() != 6) {
            this.gzR.bxp();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoEffectButtonLayout.a
    public void bxq() {
        this.gAd.setVisibility(4);
        D(3, this.gzR.bxF());
        if (this.gzQ.getStatus() != 6) {
            this.gzR.bxq();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxr() {
        this.gAh = true;
        if (this.gAf != null && this.gAf.isRunning()) {
            this.gAf.cancel();
        }
        if (this.gAe == null) {
            this.gAe = new AnimatorSet();
            this.gAe.playTogether(ObjectAnimator.ofFloat(this.gzS, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gzZ, "alpha", 1.0f, 0.0f), ObjectAnimator.ofFloat(this.gzY, "alpha", 1.0f, 0.0f));
            this.gAe.addListener(new m() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.2
                @Override // com.baidu.tieba.video.record.m, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (!this.gBA) {
                        RecordVideoActivity.this.gzS.setVisibility(8);
                        RecordVideoActivity.this.gzY.setVisibility(8);
                    }
                }
            });
            this.gAe.setDuration(300L);
        }
        this.gAe.start();
        this.gzY.reset();
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxs() {
        if (this.gAh) {
            this.gAh = false;
            if (this.gAe != null && this.gAe.isRunning()) {
                this.gAe.cancel();
            }
            if (this.gAf == null) {
                this.gAf = new AnimatorSet();
                this.gAf.playTogether(ObjectAnimator.ofFloat(this.gzS, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gzZ, "alpha", 0.0f, 1.0f), ObjectAnimator.ofFloat(this.gzY, "alpha", 0.0f, 1.0f));
                this.gAf.setDuration(300L);
            }
            this.gzS.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 18) {
                this.gzY.setVisibility(0);
            }
            this.gAf.start();
        }
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxt() {
        this.gAg.cancel();
        this.gAg.removeAllListeners();
        this.gzX.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxu() {
        this.gzY.reset();
        this.gzZ.setVisibility(8);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxv() {
        if (this.gAb.getVisibility() != 0) {
            this.gzR.bxB();
            if (this.gzQ.getVideoDuration() >= 3000.0f) {
                this.gzQ.setStatus(4);
            } else {
                this.gzQ.setStatus(3);
            }
            bxs();
            if (this.gyK.gzr != null && this.gyK.gzr.size() > 0) {
                this.gAb.setVisibility(0);
                new AnonymousClass3().execute(new Void[0]);
            }
        }
    }

    /* renamed from: com.baidu.tieba.video.record.RecordVideoActivity$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends BdAsyncTask<Void, Void, Boolean> {
        final int gAn = 50;
        final int gAo = 1;
        Handler gAp = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.video.record.RecordVideoActivity.3.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    AnonymousClass3.this.mProgress = (AnonymousClass3.this.mProgress + 5) % 100;
                    RecordVideoActivity.this.gAc.ag(AnonymousClass3.this.mProgress);
                    AnonymousClass3.this.bxy();
                }
            }
        };
        int mProgress;

        AnonymousClass3() {
        }

        public void bxy() {
            this.gAp.sendEmptyMessageDelayed(1, 50L);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Void... voidArr) {
            boolean z;
            bxy();
            if (RecordVideoActivity.this.gyK.gzr.size() > 1) {
                z = com.baidu.tieba.video.meida.g.bwz().j(RecordVideoActivity.this.gyK.gzr, RecordVideoActivity.this.gyK.bwW());
            } else {
                File file = new File(RecordVideoActivity.this.gyK.gzr.get(0));
                if (file.exists()) {
                    file.renameTo(new File(RecordVideoActivity.this.gyK.bwW()));
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
                    if (RecordVideoActivity.this.gzQ.getVideoDuration() < 8000) {
                        com.baidu.tieba.video.localvideo.g bvA = RecordVideoActivity.this.bvA();
                        if (!bvA.isConvertRunning()) {
                            File file = new File(com.baidu.tieba.video.c.gtK, "tieba_" + com.baidu.tieba.video.localvideo.e.sK(RecordVideoActivity.this.gyK.guQ) + "_tiebaconverting.mp4");
                            RecordVideoActivity.this.gwx = file.getAbsolutePath();
                            bvA.setConvertType(2);
                            bvA.ck(RecordVideoActivity.this.gyK.guQ, RecordVideoActivity.this.gwx);
                            RecordVideoActivity.this.guW = false;
                            RecordVideoActivity.this.guV = false;
                        } else {
                            return;
                        }
                    } else {
                        RecordVideoActivity.this.gwx = RecordVideoActivity.this.gyK.guQ;
                        RecordVideoActivity.this.bxk();
                        RecordVideoActivity.this.gAb.setVisibility(8);
                    }
                } else {
                    RecordVideoActivity.this.gwx = RecordVideoActivity.this.gyK.guQ;
                    RecordVideoActivity.this.bxk();
                    RecordVideoActivity.this.gAb.setVisibility(8);
                    return;
                }
            } else {
                com.baidu.adp.lib.util.l.showToast(RecordVideoActivity.this, RecordVideoActivity.this.getString(d.l.mix_fail));
                RecordVideoActivity.this.gAb.setVisibility(8);
            }
            RecordVideoActivity.this.gAc.ag(0.0f);
        }
    }

    public List<String> getChoosedBeautyList() {
        ArrayList arrayList = new ArrayList();
        if (this.gzR == null || v.u(this.gzR.getChoosedBeautyList())) {
            return arrayList;
        }
        for (d dVar : this.gzR.getChoosedBeautyList()) {
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
        if (this.gzR == null || v.u(this.gzR.getChoosedFilterList())) {
            return arrayList;
        }
        for (d dVar : this.gzR.getChoosedFilterList()) {
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
        if (this.gzR == null || v.u(this.gzR.getChoosedStickerList())) {
            return arrayList;
        }
        for (StickerItem stickerItem : this.gzR.getChoosedStickerList()) {
            if (stickerItem != null) {
                arrayList.add(String.valueOf(stickerItem.id));
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxw() {
        this.gAd.setVisibility(0);
    }

    @Override // com.baidu.tieba.video.record.VideoControllerLayout.a
    public void bxx() {
        this.gAd.setVisibility(4);
    }

    @Override // com.baidu.tieba.video.record.VideoEffectLayout.a
    public void a(d dVar) {
        if (this.gyK != null && dVar != null) {
            switch (dVar.getType()) {
                case 1:
                    if (dVar.getValue() instanceof com.baidu.tieba.video.a) {
                        this.gyK.setBeautyLevel((com.baidu.tieba.video.a) dVar.getValue());
                        return;
                    }
                    return;
                case 2:
                    if (dVar.getValue() instanceof String) {
                        this.gyK.setFilter((String) dVar.getValue());
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
            this.gAk = stickerItem;
            this.gAj.sR(stickerItem.resource);
            if (stickerItem.id == -1) {
                if (this.gyK != null) {
                    this.gyK.setSticker(null);
                }
                if (this.gzR != null) {
                    this.gzR.setDownLoadSticker(null);
                }
                this.gAa.setVisibility(8);
                return;
            }
            String sP = this.gAj.sP(stickerItem.resource);
            if (!StringUtils.isNull(sP)) {
                a(stickerItem, sP);
                if (this.gzR != null) {
                    this.gzR.setDownLoadSticker(null);
                    return;
                }
                return;
            }
            if (this.gzR != null) {
                this.gzR.setDownLoadSticker(stickerItem);
            }
            this.gAj.sQ(stickerItem.resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StickerItem stickerItem, String str) {
        if (stickerItem != null && !StringUtils.isNull(str)) {
            stickerItem.localPath = str;
            if (this.gyK != null) {
                this.gyK.setSticker(stickerItem);
            }
            if (!StringUtils.isNull(stickerItem.desc)) {
                this.gAa.setText(stickerItem.desc);
                this.gAa.setVisibility(0);
                this.gAa.postDelayed(new Runnable() { // from class: com.baidu.tieba.video.record.RecordVideoActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        RecordVideoActivity.this.gAa.setVisibility(8);
                    }
                }, 3000L);
                return;
            }
            this.gAa.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.video.record.h.b
    public void cc(int i, int i2) {
        int i3;
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(d.f.ds336);
        if (dimensionPixelOffset > 0 && i2 > 0 && (i3 = (com.baidu.adp.lib.util.l.o(this).heightPixels - i2) - dimensionPixelOffset) > 0) {
            int i4 = dimensionPixelOffset + i3;
            ViewGroup.LayoutParams layoutParams = this.gzR.getLayoutParams();
            layoutParams.height = i4;
            this.gzR.setLayoutParams(layoutParams);
        }
    }
}
