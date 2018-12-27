package com.baidu.tieba.pbextra.chudian.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.view.BaseAutoPlayVideoView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean bJc;
    private QuickVideoView bOq;
    private n bOs;
    private String biz;
    private g.b boZ;
    private QuickVideoView.b bpd;
    private g.a bxL;
    private g.f bxM;
    private ForeDrawableImageView eGb;
    private View eGh;
    private View gpD;
    private a gpE;
    private VideoInfo gpF;
    private int gpG;
    private RelativeLayout gpH;
    private AudioAnimationView gpI;
    private TextView gpJ;
    private PbChudianProcessBar gpK;
    private TextView gpL;
    private boolean gpM;
    private View gpN;
    private View gpO;
    private long gpP;
    private long gpQ;
    private float gpR;
    private float gpS;
    private Bitmap gpT;
    private MediaMetadataRetriever gpU;
    private Runnable gpV;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gpG = -1;
        this.bJc = false;
        this.gpM = false;
        this.mOnClickListener = null;
        this.gpP = 0L;
        this.gpQ = 0L;
        this.mDuration = 0L;
        this.gpR = 1.0f;
        this.gpS = 1.0f;
        this.gpT = null;
        this.gpU = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gpG != 1) {
                            if (AutoPlayVideoView.this.bOq.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gpP = AutoPlayVideoView.this.gpQ;
                            AutoPlayVideoView.this.eGh.setVisibility(8);
                            if (!AutoPlayVideoView.this.bOs.brW() || AutoPlayVideoView.this.gpT == null) {
                                AutoPlayVideoView.this.bOq.seekTo((int) AutoPlayVideoView.this.gpQ);
                                AutoPlayVideoView.this.eGb.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bOq.getDuration();
                            AutoPlayVideoView.this.gpG = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJc) {
                                AutoPlayVideoView.this.gpK.setVisibility(0);
                                AutoPlayVideoView.this.gpK.m(AutoPlayVideoView.this.gpQ, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gpK.bor();
                                return;
                            }
                            AutoPlayVideoView.this.gpI.pT();
                            AutoPlayVideoView.this.gpI.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJc) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bOq.getDuration() - AutoPlayVideoView.this.bOq.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gpJ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gpG == 1) {
                            if (AutoPlayVideoView.this.gpP == AutoPlayVideoView.this.bOq.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gpP = AutoPlayVideoView.this.bOq.getCurrentPosition();
                                AutoPlayVideoView.this.aGE();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bOq.isPlaying() && AutoPlayVideoView.this.bOs.brW() && AutoPlayVideoView.this.gpT != null) {
                            if (AutoPlayVideoView.this.bOq.getCurrentPosition() > AutoPlayVideoView.this.gpQ) {
                                AutoPlayVideoView.this.eGb.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bOq != null && AutoPlayVideoView.this.bOs.brW()) {
                        if (AutoPlayVideoView.this.gpU == null) {
                            AutoPlayVideoView.this.gpU = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gpU.setDataSource(AutoPlayVideoView.this.bOs.jB(AutoPlayVideoView.this.bOs.brV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gpT != null) {
                            AutoPlayVideoView.this.bOq.seekTo((int) AutoPlayVideoView.this.gpQ);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gpR, AutoPlayVideoView.this.gpS);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gpF;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aGE();
                AutoPlayVideoView.this.gpQ = 0L;
                if (AutoPlayVideoView.this.bJc) {
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gpN.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gpN.setVisibility(8);
                }
                return true;
            }
        };
        this.bxL = null;
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gpV = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gpF != null && AutoPlayVideoView.this.bOq != null) {
                    AutoPlayVideoView.this.boq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.gpG = -1;
        this.bJc = false;
        this.gpM = false;
        this.mOnClickListener = null;
        this.gpP = 0L;
        this.gpQ = 0L;
        this.mDuration = 0L;
        this.gpR = 1.0f;
        this.gpS = 1.0f;
        this.gpT = null;
        this.gpU = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gpG != 1) {
                            if (AutoPlayVideoView.this.bOq.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gpP = AutoPlayVideoView.this.gpQ;
                            AutoPlayVideoView.this.eGh.setVisibility(8);
                            if (!AutoPlayVideoView.this.bOs.brW() || AutoPlayVideoView.this.gpT == null) {
                                AutoPlayVideoView.this.bOq.seekTo((int) AutoPlayVideoView.this.gpQ);
                                AutoPlayVideoView.this.eGb.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bOq.getDuration();
                            AutoPlayVideoView.this.gpG = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJc) {
                                AutoPlayVideoView.this.gpK.setVisibility(0);
                                AutoPlayVideoView.this.gpK.m(AutoPlayVideoView.this.gpQ, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gpK.bor();
                                return;
                            }
                            AutoPlayVideoView.this.gpI.pT();
                            AutoPlayVideoView.this.gpI.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJc) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bOq.getDuration() - AutoPlayVideoView.this.bOq.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gpJ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gpG == 1) {
                            if (AutoPlayVideoView.this.gpP == AutoPlayVideoView.this.bOq.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gpP = AutoPlayVideoView.this.bOq.getCurrentPosition();
                                AutoPlayVideoView.this.aGE();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bOq.isPlaying() && AutoPlayVideoView.this.bOs.brW() && AutoPlayVideoView.this.gpT != null) {
                            if (AutoPlayVideoView.this.bOq.getCurrentPosition() > AutoPlayVideoView.this.gpQ) {
                                AutoPlayVideoView.this.eGb.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bOq != null && AutoPlayVideoView.this.bOs.brW()) {
                        if (AutoPlayVideoView.this.gpU == null) {
                            AutoPlayVideoView.this.gpU = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gpU.setDataSource(AutoPlayVideoView.this.bOs.jB(AutoPlayVideoView.this.bOs.brV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gpT != null) {
                            AutoPlayVideoView.this.bOq.seekTo((int) AutoPlayVideoView.this.gpQ);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gpR, AutoPlayVideoView.this.gpS);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gpF;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aGE();
                AutoPlayVideoView.this.gpQ = 0L;
                if (AutoPlayVideoView.this.bJc) {
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gpN.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gpN.setVisibility(8);
                }
                return true;
            }
        };
        this.bxL = null;
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gpV = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gpF != null && AutoPlayVideoView.this.bOq != null) {
                    AutoPlayVideoView.this.boq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gpG = -1;
        this.bJc = false;
        this.gpM = false;
        this.mOnClickListener = null;
        this.gpP = 0L;
        this.gpQ = 0L;
        this.mDuration = 0L;
        this.gpR = 1.0f;
        this.gpS = 1.0f;
        this.gpT = null;
        this.gpU = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gpG != 1) {
                            if (AutoPlayVideoView.this.bOq.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gpP = AutoPlayVideoView.this.gpQ;
                            AutoPlayVideoView.this.eGh.setVisibility(8);
                            if (!AutoPlayVideoView.this.bOs.brW() || AutoPlayVideoView.this.gpT == null) {
                                AutoPlayVideoView.this.bOq.seekTo((int) AutoPlayVideoView.this.gpQ);
                                AutoPlayVideoView.this.eGb.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bOq.getDuration();
                            AutoPlayVideoView.this.gpG = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJc) {
                                AutoPlayVideoView.this.gpK.setVisibility(0);
                                AutoPlayVideoView.this.gpK.m(AutoPlayVideoView.this.gpQ, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gpK.bor();
                                return;
                            }
                            AutoPlayVideoView.this.gpI.pT();
                            AutoPlayVideoView.this.gpI.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJc) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bOq.getDuration() - AutoPlayVideoView.this.bOq.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gpJ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gpG == 1) {
                            if (AutoPlayVideoView.this.gpP == AutoPlayVideoView.this.bOq.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gpP = AutoPlayVideoView.this.bOq.getCurrentPosition();
                                AutoPlayVideoView.this.aGE();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bOq.isPlaying() && AutoPlayVideoView.this.bOs.brW() && AutoPlayVideoView.this.gpT != null) {
                            if (AutoPlayVideoView.this.bOq.getCurrentPosition() > AutoPlayVideoView.this.gpQ) {
                                AutoPlayVideoView.this.eGb.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bxM = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bOq != null && AutoPlayVideoView.this.bOs.brW()) {
                        if (AutoPlayVideoView.this.gpU == null) {
                            AutoPlayVideoView.this.gpU = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gpU.setDataSource(AutoPlayVideoView.this.bOs.jB(AutoPlayVideoView.this.bOs.brV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gpT != null) {
                            AutoPlayVideoView.this.bOq.seekTo((int) AutoPlayVideoView.this.gpQ);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gpR, AutoPlayVideoView.this.gpS);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gpF;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aGE();
                AutoPlayVideoView.this.gpQ = 0L;
                if (AutoPlayVideoView.this.bJc) {
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gpN.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gpN.setVisibility(8);
                }
                return true;
            }
        };
        this.bxL = null;
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gpV = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gpF != null && AutoPlayVideoView.this.bOq != null) {
                    AutoPlayVideoView.this.boq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gpD = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.eGb = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.eGh = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.gpH = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bOq = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bOs = new n(this.mContext);
        this.bOq.setBusiness(this.bOs);
        this.gpI = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.gpJ = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.gpK = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.gpL = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.gpL.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.gpN = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.gpO = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean bop() {
        return q.bop();
    }

    public void boq() {
        if (bop()) {
            this.bOq.setVideoPath(this.gpF.video_url, this.biz);
            this.bOq.start();
            this.gpG = 0;
            if (!this.bOs.brW() || this.gpT == null) {
                showLoading();
            }
            this.gpN.setVisibility(8);
            lV(this.bJc);
            return;
        }
        aGE();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gpF = videoInfo;
        this.biz = str;
        this.eGb.setDefaultErrorResource(0);
        this.eGb.setDefaultResource(0);
        this.eGb.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGb.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGb.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bOq.setOnPreparedListener(this.bxM);
        this.bOq.setOnErrorListener(this.boZ);
        if (this.bxL != null) {
            this.bOq.setOnCompletionListener(this.bxL);
        }
        this.bOq.setOnSurfaceDestroyedListener(this.bpd);
        this.gpI.setCertainColumnCount(4);
        this.gpI.setColumnColor(e.d.cp_cont_i);
        this.gpL.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpO.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0210e.ds120);
        }
        layoutParams.height = aO;
        this.gpO.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eGb.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.eGb.setLayoutParams(layoutParams2);
        this.eGb.setOnClickListener(this.mOnClickListener);
        this.gpO.setOnClickListener(this.mOnClickListener);
        this.gpN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bJc) {
                    AutoPlayVideoView.this.gpE.dismiss();
                    AutoPlayVideoView.this.eGb.setForegroundDrawable(e.f.icon_play_video);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void stopPlay() {
        this.mHandler.removeMessages(202);
        this.mHandler.removeMessages(301);
        this.mHandler.removeMessages(401);
        this.mHandler.removeMessages(501);
        this.gpK.destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gpV);
        if (this.bOq.isPlaying()) {
            this.gpP = this.bOq.getCurrentPosition();
            if (this.bOs.brW() && this.gpU != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.gpU.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.gpP), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.gpF.video_width.intValue() / frameAtTime.getWidth(), this.gpF.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.gpT;
                                    this.gpT = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eGb.setImageBitmap(this.gpT);
                                    this.eGb.setForegroundDrawable(0);
                                    if (bitmap2 != null) {
                                        bitmap2.recycle();
                                    }
                                }
                            } catch (Exception e) {
                                bitmap = frameAtTime;
                                e = e;
                                e.printStackTrace();
                                if (bitmap != null) {
                                    try {
                                        bitmap.recycle();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                this.gpG = 3;
                                this.eGb.setVisibility(0);
                                this.bOq.stopPlayback();
                                this.gpI.pT();
                            } catch (Throwable th) {
                                bitmap = frameAtTime;
                                th = th;
                                if (bitmap != null) {
                                    try {
                                        bitmap.recycle();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        }
                        if (frameAtTime != null) {
                            try {
                                frameAtTime.recycle();
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        this.gpG = 3;
        this.eGb.setVisibility(0);
        this.bOq.stopPlayback();
        this.gpI.pT();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.gpJ, e.d.cp_cont_i);
            al.c(this.gpL, e.d.cp_cont_g, 1);
            al.d(this.gpL, e.f.btn_video, 1);
            this.gpI.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.gpG;
    }

    public long getCurrentPosition() {
        return this.gpP;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bxL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eGh.setVisibility(0);
        this.eGb.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGE() {
        this.eGh.setVisibility(8);
        this.eGb.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.gpR = f;
        this.gpS = f2;
    }

    public long getDuration() {
        if (this.bOq == null) {
            return this.gpF.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.gpF.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.gpQ = j;
    }

    /* loaded from: classes3.dex */
    private static class a extends Dialog {
        public a(Activity activity, View view, ViewGroup.LayoutParams layoutParams) {
            super(activity);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            requestWindowFeature(1);
            com.baidu.adp.lib.g.g.a(this, activity);
            Window window = getWindow();
            window.setGravity(17);
            window.setBackgroundDrawableResource(e.f.alpha15_black_stroke_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setContentView(view, layoutParams);
            window.setTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lV(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.gpH.setVisibility(8);
            this.gpK.setPlayer(this.bOq);
            return;
        }
        this.gpK.setVisibility(8);
        this.gpK.destroy();
        this.gpH.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gpD != null && this.bOq != null) {
            if (!z) {
                if (this.gpE != null) {
                    this.gpE.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lV(true);
            if (this.gpM) {
                this.gpL.setVisibility(0);
            }
            this.bJc = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpD.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gpD.getParent();
            viewGroup.removeAllViews();
            this.gpE = new a(bdBaseActivity.getActivity(), this.gpD, new ViewGroup.LayoutParams(-1, -1));
            this.gpE.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gpD != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lV(false);
                        AutoPlayVideoView.this.gpL.setVisibility(8);
                        AutoPlayVideoView.this.bJc = false;
                        ((ViewGroup) AutoPlayVideoView.this.gpD.getParent()).removeView(AutoPlayVideoView.this.gpD);
                        viewGroup.addView(AutoPlayVideoView.this.gpD);
                        AutoPlayVideoView.this.gpD.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.gpQ = AutoPlayVideoView.this.gpP;
                        if (AutoPlayVideoView.this.gpN.getVisibility() != 0) {
                            AutoPlayVideoView.this.boq();
                        }
                        AutoPlayVideoView.this.gpN.setVisibility(8);
                    }
                }
            });
            this.gpQ = this.gpP;
            boq();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.gpM = z;
    }
}
