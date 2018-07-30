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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.BaseAutoPlayVideoView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private String aWq;
    private View axE;
    private g.b bdd;
    private QuickVideoView.b bdh;
    private g.a bjG;
    private g.f bjH;
    private QuickVideoView bvp;
    private n bvr;
    private boolean dfg;
    private ForeDrawableImageView efN;
    private View efT;
    private View fPP;
    private a fPQ;
    private VideoInfo fPR;
    private int fPS;
    private RelativeLayout fPT;
    private AudioAnimationView fPU;
    private TextView fPV;
    private PbChudianProcessBar fPW;
    private TextView fPX;
    private boolean fPY;
    private View fPZ;
    private View fQa;
    private long fQb;
    private long fQc;
    private float fQd;
    private float fQe;
    private Bitmap fQf;
    private MediaMetadataRetriever fQg;
    private Runnable fQh;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fPS = -1;
        this.dfg = false;
        this.fPY = false;
        this.mOnClickListener = null;
        this.fQb = 0L;
        this.fQc = 0L;
        this.mDuration = 0L;
        this.fQd = 1.0f;
        this.fQe = 1.0f;
        this.fQf = null;
        this.fQg = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPS != 1) {
                            if (AutoPlayVideoView.this.bvp.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fQb = AutoPlayVideoView.this.fQc;
                            AutoPlayVideoView.this.efT.setVisibility(8);
                            if (!AutoPlayVideoView.this.bvr.bkf() || AutoPlayVideoView.this.fQf == null) {
                                AutoPlayVideoView.this.bvp.seekTo((int) AutoPlayVideoView.this.fQc);
                                AutoPlayVideoView.this.efN.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bvp.getDuration();
                            AutoPlayVideoView.this.fPS = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dfg) {
                                AutoPlayVideoView.this.fPW.setVisibility(0);
                                AutoPlayVideoView.this.fPW.m(AutoPlayVideoView.this.fQc, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPW.bgJ();
                                return;
                            }
                            AutoPlayVideoView.this.fPU.oM();
                            AutoPlayVideoView.this.fPU.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dfg) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bvp.getDuration() - AutoPlayVideoView.this.bvp.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPV.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPS == 1) {
                            if (AutoPlayVideoView.this.fQb == AutoPlayVideoView.this.bvp.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fQb = AutoPlayVideoView.this.bvp.getCurrentPosition();
                                AutoPlayVideoView.this.azi();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bvp.isPlaying() && AutoPlayVideoView.this.bvr.bkf() && AutoPlayVideoView.this.fQf != null) {
                            if (AutoPlayVideoView.this.bvp.getCurrentPosition() > AutoPlayVideoView.this.fQc) {
                                AutoPlayVideoView.this.efN.setVisibility(8);
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
        this.bjH = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bvp != null && AutoPlayVideoView.this.bvr.bkf()) {
                        if (AutoPlayVideoView.this.fQg == null) {
                            AutoPlayVideoView.this.fQg = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fQg.setDataSource(AutoPlayVideoView.this.bvr.ir(AutoPlayVideoView.this.bvr.bke()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fQf != null) {
                            AutoPlayVideoView.this.bvp.seekTo((int) AutoPlayVideoView.this.fQc);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fQd, AutoPlayVideoView.this.fQe);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPR;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.azi();
                AutoPlayVideoView.this.fQc = 0L;
                if (AutoPlayVideoView.this.dfg) {
                    AutoPlayVideoView.this.efN.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPZ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.efN.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fPZ.setVisibility(8);
                }
                return true;
            }
        };
        this.bjG = null;
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fQh = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPR != null && AutoPlayVideoView.this.bvp != null) {
                    AutoPlayVideoView.this.bgI();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.fPS = -1;
        this.dfg = false;
        this.fPY = false;
        this.mOnClickListener = null;
        this.fQb = 0L;
        this.fQc = 0L;
        this.mDuration = 0L;
        this.fQd = 1.0f;
        this.fQe = 1.0f;
        this.fQf = null;
        this.fQg = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPS != 1) {
                            if (AutoPlayVideoView.this.bvp.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fQb = AutoPlayVideoView.this.fQc;
                            AutoPlayVideoView.this.efT.setVisibility(8);
                            if (!AutoPlayVideoView.this.bvr.bkf() || AutoPlayVideoView.this.fQf == null) {
                                AutoPlayVideoView.this.bvp.seekTo((int) AutoPlayVideoView.this.fQc);
                                AutoPlayVideoView.this.efN.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bvp.getDuration();
                            AutoPlayVideoView.this.fPS = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dfg) {
                                AutoPlayVideoView.this.fPW.setVisibility(0);
                                AutoPlayVideoView.this.fPW.m(AutoPlayVideoView.this.fQc, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPW.bgJ();
                                return;
                            }
                            AutoPlayVideoView.this.fPU.oM();
                            AutoPlayVideoView.this.fPU.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dfg) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bvp.getDuration() - AutoPlayVideoView.this.bvp.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPV.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPS == 1) {
                            if (AutoPlayVideoView.this.fQb == AutoPlayVideoView.this.bvp.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fQb = AutoPlayVideoView.this.bvp.getCurrentPosition();
                                AutoPlayVideoView.this.azi();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bvp.isPlaying() && AutoPlayVideoView.this.bvr.bkf() && AutoPlayVideoView.this.fQf != null) {
                            if (AutoPlayVideoView.this.bvp.getCurrentPosition() > AutoPlayVideoView.this.fQc) {
                                AutoPlayVideoView.this.efN.setVisibility(8);
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
        this.bjH = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bvp != null && AutoPlayVideoView.this.bvr.bkf()) {
                        if (AutoPlayVideoView.this.fQg == null) {
                            AutoPlayVideoView.this.fQg = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fQg.setDataSource(AutoPlayVideoView.this.bvr.ir(AutoPlayVideoView.this.bvr.bke()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fQf != null) {
                            AutoPlayVideoView.this.bvp.seekTo((int) AutoPlayVideoView.this.fQc);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fQd, AutoPlayVideoView.this.fQe);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPR;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.azi();
                AutoPlayVideoView.this.fQc = 0L;
                if (AutoPlayVideoView.this.dfg) {
                    AutoPlayVideoView.this.efN.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPZ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.efN.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fPZ.setVisibility(8);
                }
                return true;
            }
        };
        this.bjG = null;
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fQh = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPR != null && AutoPlayVideoView.this.bvp != null) {
                    AutoPlayVideoView.this.bgI();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fPS = -1;
        this.dfg = false;
        this.fPY = false;
        this.mOnClickListener = null;
        this.fQb = 0L;
        this.fQc = 0L;
        this.mDuration = 0L;
        this.fQd = 1.0f;
        this.fQe = 1.0f;
        this.fQf = null;
        this.fQg = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPS != 1) {
                            if (AutoPlayVideoView.this.bvp.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fQb = AutoPlayVideoView.this.fQc;
                            AutoPlayVideoView.this.efT.setVisibility(8);
                            if (!AutoPlayVideoView.this.bvr.bkf() || AutoPlayVideoView.this.fQf == null) {
                                AutoPlayVideoView.this.bvp.seekTo((int) AutoPlayVideoView.this.fQc);
                                AutoPlayVideoView.this.efN.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bvp.getDuration();
                            AutoPlayVideoView.this.fPS = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dfg) {
                                AutoPlayVideoView.this.fPW.setVisibility(0);
                                AutoPlayVideoView.this.fPW.m(AutoPlayVideoView.this.fQc, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPW.bgJ();
                                return;
                            }
                            AutoPlayVideoView.this.fPU.oM();
                            AutoPlayVideoView.this.fPU.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dfg) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bvp.getDuration() - AutoPlayVideoView.this.bvp.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPV.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPS == 1) {
                            if (AutoPlayVideoView.this.fQb == AutoPlayVideoView.this.bvp.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fQb = AutoPlayVideoView.this.bvp.getCurrentPosition();
                                AutoPlayVideoView.this.azi();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bvp.isPlaying() && AutoPlayVideoView.this.bvr.bkf() && AutoPlayVideoView.this.fQf != null) {
                            if (AutoPlayVideoView.this.bvp.getCurrentPosition() > AutoPlayVideoView.this.fQc) {
                                AutoPlayVideoView.this.efN.setVisibility(8);
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
        this.bjH = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bvp != null && AutoPlayVideoView.this.bvr.bkf()) {
                        if (AutoPlayVideoView.this.fQg == null) {
                            AutoPlayVideoView.this.fQg = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fQg.setDataSource(AutoPlayVideoView.this.bvr.ir(AutoPlayVideoView.this.bvr.bke()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fQf != null) {
                            AutoPlayVideoView.this.bvp.seekTo((int) AutoPlayVideoView.this.fQc);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fQd, AutoPlayVideoView.this.fQe);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPR;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.azi();
                AutoPlayVideoView.this.fQc = 0L;
                if (AutoPlayVideoView.this.dfg) {
                    AutoPlayVideoView.this.efN.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPZ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.efN.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fPZ.setVisibility(8);
                }
                return true;
            }
        };
        this.bjG = null;
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fQh = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPR != null && AutoPlayVideoView.this.bvp != null) {
                    AutoPlayVideoView.this.bgI();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.fPP = this.mRootView.findViewById(d.g.content_wrapper);
        this.axE = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.efN = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.efT = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.fPT = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.bvp = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.bvr = new n(this.mContext);
        this.bvp.setBusiness(this.bvr);
        this.fPU = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.fPV = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.fPW = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.fPX = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.fPX.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.fPZ = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.fQa = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bgH() {
        return q.bgH();
    }

    public void bgI() {
        if (bgH()) {
            this.bvp.setVideoPath(this.fPR.video_url, this.aWq);
            this.bvp.start();
            this.fPS = 0;
            if (!this.bvr.bkf() || this.fQf == null) {
                showLoading();
            }
            this.fPZ.setVisibility(8);
            kR(this.dfg);
            return;
        }
        azi();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPR = videoInfo;
        this.aWq = str;
        this.efN.setDefaultErrorResource(0);
        this.efN.setDefaultResource(0);
        this.efN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.efN.setForegroundDrawable(d.f.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.efN.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bvp.setOnPreparedListener(this.bjH);
        this.bvp.setOnErrorListener(this.bdd);
        if (this.bjG != null) {
            this.bvp.setOnCompletionListener(this.bjG);
        }
        this.bvp.setOnSurfaceDestroyedListener(this.bdh);
        this.fPU.setCertainColumnCount(4);
        this.fPU.setColumnColor(d.C0140d.cp_cont_i);
        this.fPX.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fQa.getLayoutParams();
        int ah = l.ah(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            ah = ((ah * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.f(getContext(), d.e.ds120);
        }
        layoutParams.height = ah;
        this.fQa.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.efN.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = ah;
        }
        this.efN.setLayoutParams(layoutParams2);
        this.efN.setOnClickListener(this.mOnClickListener);
        this.fQa.setOnClickListener(this.mOnClickListener);
        this.fPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.dfg) {
                    AutoPlayVideoView.this.fPQ.dismiss();
                    AutoPlayVideoView.this.efN.setForegroundDrawable(d.f.icon_play_video);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void stopPlay() {
        this.mHandler.removeMessages(202);
        this.mHandler.removeMessages(301);
        this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
        this.mHandler.removeMessages(501);
        this.fPW.destroy();
        e.in().removeCallbacks(this.fQh);
        if (this.bvp.isPlaying()) {
            this.fQb = this.bvp.getCurrentPosition();
            if (this.bvr.bkf() && this.fQg != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fQg.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fQb), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fPR.video_width.intValue() / frameAtTime.getWidth(), this.fPR.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fQf;
                                    this.fQf = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.efN.setImageBitmap(this.fQf);
                                    this.efN.setForegroundDrawable(0);
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
                                this.fPS = 3;
                                this.efN.setVisibility(0);
                                this.bvp.stopPlayback();
                                this.fPU.oM();
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
        this.fPS = 3;
        this.efN.setVisibility(0);
        this.bvp.stopPlayback();
        this.fPU.oM();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.fPV, d.C0140d.cp_cont_i);
            am.c(this.fPX, d.C0140d.cp_cont_g, 1);
            am.d(this.fPX, d.f.btn_video, 1);
            this.fPU.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fPS;
    }

    public long getCurrentPosition() {
        return this.fQb;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bjG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.efT.setVisibility(0);
        this.efN.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azi() {
        this.efT.setVisibility(8);
        this.efN.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fQd = f;
        this.fQe = f2;
    }

    public long getDuration() {
        if (this.bvp == null) {
            return this.fPR.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fPR.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fQc = j;
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
            window.setBackgroundDrawableResource(d.f.alpha15_black_stroke_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setContentView(view, layoutParams);
            window.setTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.fPT.setVisibility(8);
            this.fPW.setPlayer(this.bvp);
            return;
        }
        this.fPW.setVisibility(8);
        this.fPW.destroy();
        this.fPT.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fPP != null && this.bvp != null) {
            if (!z) {
                if (this.fPQ != null) {
                    this.fPQ.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            kR(true);
            if (this.fPY) {
                this.fPX.setVisibility(0);
            }
            this.dfg = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPP.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fPP.getParent();
            viewGroup.removeAllViews();
            this.fPQ = new a(bdBaseActivity.getActivity(), this.fPP, new ViewGroup.LayoutParams(-1, -1));
            this.fPQ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fPP != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.kR(false);
                        AutoPlayVideoView.this.fPX.setVisibility(8);
                        AutoPlayVideoView.this.dfg = false;
                        ((ViewGroup) AutoPlayVideoView.this.fPP.getParent()).removeView(AutoPlayVideoView.this.fPP);
                        viewGroup.addView(AutoPlayVideoView.this.fPP);
                        AutoPlayVideoView.this.fPP.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fQc = AutoPlayVideoView.this.fQb;
                        if (AutoPlayVideoView.this.fPZ.getVisibility() != 0) {
                            AutoPlayVideoView.this.bgI();
                        }
                        AutoPlayVideoView.this.fPZ.setVisibility(8);
                    }
                }
            });
            this.fQc = this.fQb;
            bgI();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fPY = z;
    }
}
