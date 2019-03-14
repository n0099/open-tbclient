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
import com.baidu.tbadk.core.util.al;
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
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean UT;
    private g.b cAm;
    private QuickVideoView.b cAq;
    private g.a cJF;
    private g.f cJG;
    private String ctu;
    private QuickVideoView dbc;
    private n dbe;
    private ForeDrawableImageView fWR;
    private View fWX;
    private View hGT;
    private a hGU;
    private VideoInfo hGV;
    private int hGW;
    private RelativeLayout hGX;
    private AudioAnimationView hGY;
    private TextView hGZ;
    private PbChudianProcessBar hHa;
    private TextView hHb;
    private boolean hHc;
    private View hHd;
    private View hHe;
    private long hHf;
    private long hHg;
    private float hHh;
    private float hHi;
    private Bitmap hHj;
    private MediaMetadataRetriever hHk;
    private Runnable hHl;
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
        this.hGW = -1;
        this.UT = false;
        this.hHc = false;
        this.mOnClickListener = null;
        this.hHf = 0L;
        this.hHg = 0L;
        this.mDuration = 0L;
        this.hHh = 1.0f;
        this.hHi = 1.0f;
        this.hHj = null;
        this.hHk = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGW != 1) {
                            if (AutoPlayVideoView.this.dbc.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hHf = AutoPlayVideoView.this.hHg;
                            AutoPlayVideoView.this.fWX.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbe.bTc() || AutoPlayVideoView.this.hHj == null) {
                                AutoPlayVideoView.this.dbc.seekTo((int) AutoPlayVideoView.this.hHg);
                                AutoPlayVideoView.this.fWR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbc.getDuration();
                            AutoPlayVideoView.this.hGW = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UT) {
                                AutoPlayVideoView.this.hHa.setVisibility(0);
                                AutoPlayVideoView.this.hHa.s(AutoPlayVideoView.this.hHg, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hHa.bPy();
                                return;
                            }
                            AutoPlayVideoView.this.hGY.ra();
                            AutoPlayVideoView.this.hGY.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbc.getDuration() - AutoPlayVideoView.this.dbc.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGZ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGW == 1) {
                            if (AutoPlayVideoView.this.hHf == AutoPlayVideoView.this.dbc.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hHf = AutoPlayVideoView.this.dbc.getCurrentPosition();
                                AutoPlayVideoView.this.bhr();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbc.isPlaying() && AutoPlayVideoView.this.dbe.bTc() && AutoPlayVideoView.this.hHj != null) {
                            if (AutoPlayVideoView.this.dbc.getCurrentPosition() > AutoPlayVideoView.this.hHg) {
                                AutoPlayVideoView.this.fWR.setVisibility(8);
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
        this.cJG = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbc != null && AutoPlayVideoView.this.dbe.bTc()) {
                        if (AutoPlayVideoView.this.hHk == null) {
                            AutoPlayVideoView.this.hHk = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hHk.setDataSource(AutoPlayVideoView.this.dbe.qB(AutoPlayVideoView.this.dbe.bTb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hHj != null) {
                            AutoPlayVideoView.this.dbc.seekTo((int) AutoPlayVideoView.this.hHg);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hHh, AutoPlayVideoView.this.hHi);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGV;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhr();
                AutoPlayVideoView.this.hHg = 0L;
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hHd.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hHd.setVisibility(8);
                }
                return true;
            }
        };
        this.cJF = null;
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hHl = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGV != null && AutoPlayVideoView.this.dbc != null) {
                    AutoPlayVideoView.this.bPx();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.hGW = -1;
        this.UT = false;
        this.hHc = false;
        this.mOnClickListener = null;
        this.hHf = 0L;
        this.hHg = 0L;
        this.mDuration = 0L;
        this.hHh = 1.0f;
        this.hHi = 1.0f;
        this.hHj = null;
        this.hHk = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGW != 1) {
                            if (AutoPlayVideoView.this.dbc.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hHf = AutoPlayVideoView.this.hHg;
                            AutoPlayVideoView.this.fWX.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbe.bTc() || AutoPlayVideoView.this.hHj == null) {
                                AutoPlayVideoView.this.dbc.seekTo((int) AutoPlayVideoView.this.hHg);
                                AutoPlayVideoView.this.fWR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbc.getDuration();
                            AutoPlayVideoView.this.hGW = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UT) {
                                AutoPlayVideoView.this.hHa.setVisibility(0);
                                AutoPlayVideoView.this.hHa.s(AutoPlayVideoView.this.hHg, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hHa.bPy();
                                return;
                            }
                            AutoPlayVideoView.this.hGY.ra();
                            AutoPlayVideoView.this.hGY.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbc.getDuration() - AutoPlayVideoView.this.dbc.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGZ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGW == 1) {
                            if (AutoPlayVideoView.this.hHf == AutoPlayVideoView.this.dbc.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hHf = AutoPlayVideoView.this.dbc.getCurrentPosition();
                                AutoPlayVideoView.this.bhr();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbc.isPlaying() && AutoPlayVideoView.this.dbe.bTc() && AutoPlayVideoView.this.hHj != null) {
                            if (AutoPlayVideoView.this.dbc.getCurrentPosition() > AutoPlayVideoView.this.hHg) {
                                AutoPlayVideoView.this.fWR.setVisibility(8);
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
        this.cJG = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbc != null && AutoPlayVideoView.this.dbe.bTc()) {
                        if (AutoPlayVideoView.this.hHk == null) {
                            AutoPlayVideoView.this.hHk = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hHk.setDataSource(AutoPlayVideoView.this.dbe.qB(AutoPlayVideoView.this.dbe.bTb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hHj != null) {
                            AutoPlayVideoView.this.dbc.seekTo((int) AutoPlayVideoView.this.hHg);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hHh, AutoPlayVideoView.this.hHi);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGV;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhr();
                AutoPlayVideoView.this.hHg = 0L;
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hHd.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hHd.setVisibility(8);
                }
                return true;
            }
        };
        this.cJF = null;
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hHl = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGV != null && AutoPlayVideoView.this.dbc != null) {
                    AutoPlayVideoView.this.bPx();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hGW = -1;
        this.UT = false;
        this.hHc = false;
        this.mOnClickListener = null;
        this.hHf = 0L;
        this.hHg = 0L;
        this.mDuration = 0L;
        this.hHh = 1.0f;
        this.hHi = 1.0f;
        this.hHj = null;
        this.hHk = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGW != 1) {
                            if (AutoPlayVideoView.this.dbc.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hHf = AutoPlayVideoView.this.hHg;
                            AutoPlayVideoView.this.fWX.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbe.bTc() || AutoPlayVideoView.this.hHj == null) {
                                AutoPlayVideoView.this.dbc.seekTo((int) AutoPlayVideoView.this.hHg);
                                AutoPlayVideoView.this.fWR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbc.getDuration();
                            AutoPlayVideoView.this.hGW = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UT) {
                                AutoPlayVideoView.this.hHa.setVisibility(0);
                                AutoPlayVideoView.this.hHa.s(AutoPlayVideoView.this.hHg, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hHa.bPy();
                                return;
                            }
                            AutoPlayVideoView.this.hGY.ra();
                            AutoPlayVideoView.this.hGY.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbc.getDuration() - AutoPlayVideoView.this.dbc.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGZ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGW == 1) {
                            if (AutoPlayVideoView.this.hHf == AutoPlayVideoView.this.dbc.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hHf = AutoPlayVideoView.this.dbc.getCurrentPosition();
                                AutoPlayVideoView.this.bhr();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbc.isPlaying() && AutoPlayVideoView.this.dbe.bTc() && AutoPlayVideoView.this.hHj != null) {
                            if (AutoPlayVideoView.this.dbc.getCurrentPosition() > AutoPlayVideoView.this.hHg) {
                                AutoPlayVideoView.this.fWR.setVisibility(8);
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
        this.cJG = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbc != null && AutoPlayVideoView.this.dbe.bTc()) {
                        if (AutoPlayVideoView.this.hHk == null) {
                            AutoPlayVideoView.this.hHk = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hHk.setDataSource(AutoPlayVideoView.this.dbe.qB(AutoPlayVideoView.this.dbe.bTb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hHj != null) {
                            AutoPlayVideoView.this.dbc.seekTo((int) AutoPlayVideoView.this.hHg);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hHh, AutoPlayVideoView.this.hHi);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGV;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhr();
                AutoPlayVideoView.this.hHg = 0L;
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hHd.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hHd.setVisibility(8);
                }
                return true;
            }
        };
        this.cJF = null;
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hHl = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGV != null && AutoPlayVideoView.this.dbc != null) {
                    AutoPlayVideoView.this.bPx();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.hGT = this.mRootView.findViewById(d.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.fWR = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.fWX = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.hGX = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.dbc = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.dbe = new n(this.mContext);
        this.dbc.setBusiness(this.dbe);
        this.hGY = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.hGZ = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.hHa = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.hHb = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.hHb.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.hHd = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.hHe = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bPw() {
        return q.bPw();
    }

    public void bPx() {
        if (bPw()) {
            this.dbc.setVideoPath(this.hGV.video_url, this.ctu);
            this.dbc.start();
            this.hGW = 0;
            if (!this.dbe.bTc() || this.hHj == null) {
                showLoading();
            }
            this.hHd.setVisibility(8);
            os(this.UT);
            return;
        }
        bhr();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGV = videoInfo;
        this.ctu = str;
        this.fWR.setDefaultErrorResource(0);
        this.fWR.setDefaultResource(0);
        this.fWR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.fWR.setForegroundDrawable(d.f.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWR.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dbc.setOnPreparedListener(this.cJG);
        this.dbc.setOnErrorListener(this.cAm);
        if (this.cJF != null) {
            this.dbc.setOnCompletionListener(this.cJF);
        }
        this.dbc.setOnSurfaceDestroyedListener(this.cAq);
        this.hGY.setCertainColumnCount(4);
        this.hGY.setColumnColor(d.C0277d.cp_btn_a);
        this.hHb.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHe.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), d.e.ds120);
        }
        layoutParams.height = aO;
        this.hHe.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWR.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.fWR.setLayoutParams(layoutParams2);
        this.fWR.setOnClickListener(this.mOnClickListener);
        this.hHe.setOnClickListener(this.mOnClickListener);
        this.hHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.hGU.dismiss();
                    AutoPlayVideoView.this.fWR.setForegroundDrawable(d.f.icon_play_video);
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
        this.hHa.destroy();
        e.jH().removeCallbacks(this.hHl);
        if (this.dbc.isPlaying()) {
            this.hHf = this.dbc.getCurrentPosition();
            if (this.dbe.bTc() && this.hHk != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.hHk.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.hHf), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.hGV.video_width.intValue() / frameAtTime.getWidth(), this.hGV.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.hHj;
                                    this.hHj = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.fWR.setImageBitmap(this.hHj);
                                    this.fWR.setForegroundDrawable(0);
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
                                this.hGW = 3;
                                this.fWR.setVisibility(0);
                                this.dbc.stopPlayback();
                                this.hGY.ra();
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
        this.hGW = 3;
        this.fWR.setVisibility(0);
        this.dbc.stopPlayback();
        this.hGY.ra();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.hGZ, d.C0277d.cp_btn_a);
            al.d(this.hHb, d.C0277d.cp_cont_g, 1);
            al.e(this.hHb, d.f.btn_video, 1);
            this.hGY.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.hGW;
    }

    public long getCurrentPosition() {
        return this.hHf;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cJF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.fWX.setVisibility(0);
        this.fWR.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhr() {
        this.fWX.setVisibility(8);
        this.fWR.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.hHh = f;
        this.hHi = f2;
    }

    public long getDuration() {
        if (this.dbc == null) {
            return this.hGV.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.hGV.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.hHg = j;
    }

    /* loaded from: classes4.dex */
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
    public void os(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.hGX.setVisibility(8);
            this.hHa.setPlayer(this.dbc);
            return;
        }
        this.hHa.setVisibility(8);
        this.hHa.destroy();
        this.hGX.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.hGT != null && this.dbc != null) {
            if (!z) {
                if (this.hGU != null) {
                    this.hGU.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            os(true);
            if (this.hHc) {
                this.hHb.setVisibility(0);
            }
            this.UT = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGT.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.hGT.getParent();
            viewGroup.removeAllViews();
            this.hGU = new a(bdBaseActivity.getActivity(), this.hGT, new ViewGroup.LayoutParams(-1, -1));
            this.hGU.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.hGT != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.os(false);
                        AutoPlayVideoView.this.hHb.setVisibility(8);
                        AutoPlayVideoView.this.UT = false;
                        ((ViewGroup) AutoPlayVideoView.this.hGT.getParent()).removeView(AutoPlayVideoView.this.hGT);
                        viewGroup.addView(AutoPlayVideoView.this.hGT);
                        AutoPlayVideoView.this.hGT.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.hHg = AutoPlayVideoView.this.hHf;
                        if (AutoPlayVideoView.this.hHd.getVisibility() != 0) {
                            AutoPlayVideoView.this.bPx();
                        }
                        AutoPlayVideoView.this.hHd.setVisibility(8);
                    }
                }
            });
            this.hHg = this.hHf;
            bPx();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.hHc = z;
    }
}
