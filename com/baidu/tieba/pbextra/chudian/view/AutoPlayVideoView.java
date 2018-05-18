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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
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
    private String aNv;
    private g.a aZo;
    private g.f aZp;
    private g.b aZq;
    private QuickVideoView ble;
    private n blg;
    private QuickVideoView.b bln;
    private View bpi;
    private boolean dJH;
    private ForeDrawableImageView dMR;
    private View dMX;
    private View fAh;
    private a fAi;
    private VideoInfo fAj;
    private int fAk;
    private RelativeLayout fAl;
    private AudioAnimationView fAm;
    private TextView fAn;
    private PbChudianProcessBar fAo;
    private TextView fAp;
    private boolean fAq;
    private View fAr;
    private View fAs;
    private long fAt;
    private long fAu;
    private float fAv;
    private float fAw;
    private Bitmap fAx;
    private MediaMetadataRetriever fAy;
    private Runnable fAz;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fAk = -1;
        this.dJH = false;
        this.fAq = false;
        this.mOnClickListener = null;
        this.fAt = 0L;
        this.fAu = 0L;
        this.mDuration = 0L;
        this.fAv = 1.0f;
        this.fAw = 1.0f;
        this.fAx = null;
        this.fAy = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fAk != 1) {
                            if (AutoPlayVideoView.this.ble.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fAt = AutoPlayVideoView.this.fAu;
                            AutoPlayVideoView.this.dMX.setVisibility(8);
                            if (!AutoPlayVideoView.this.blg.bgl() || AutoPlayVideoView.this.fAx == null) {
                                AutoPlayVideoView.this.ble.seekTo((int) AutoPlayVideoView.this.fAu);
                                AutoPlayVideoView.this.dMR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.ble.getDuration();
                            AutoPlayVideoView.this.fAk = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dJH) {
                                AutoPlayVideoView.this.fAo.setVisibility(0);
                                AutoPlayVideoView.this.fAo.o(AutoPlayVideoView.this.fAu, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fAo.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fAm.lS();
                            AutoPlayVideoView.this.fAm.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dJH) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.ble.getDuration() - AutoPlayVideoView.this.ble.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fAn.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fAk == 1) {
                            if (AutoPlayVideoView.this.fAt == AutoPlayVideoView.this.ble.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fAt = AutoPlayVideoView.this.ble.getCurrentPosition();
                                AutoPlayVideoView.this.atL();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.ble.isPlaying() && AutoPlayVideoView.this.blg.bgl() && AutoPlayVideoView.this.fAx != null) {
                            if (AutoPlayVideoView.this.ble.getCurrentPosition() > AutoPlayVideoView.this.fAu) {
                                AutoPlayVideoView.this.dMR.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.ble != null && AutoPlayVideoView.this.blg.bgl()) {
                        if (AutoPlayVideoView.this.fAy == null) {
                            AutoPlayVideoView.this.fAy = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fAy.setDataSource(AutoPlayVideoView.this.blg.hQ(AutoPlayVideoView.this.blg.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fAx != null) {
                            AutoPlayVideoView.this.ble.seekTo((int) AutoPlayVideoView.this.fAu);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fAv, AutoPlayVideoView.this.fAw);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fAj;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atL();
                AutoPlayVideoView.this.fAu = 0L;
                if (AutoPlayVideoView.this.dJH) {
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fAr.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fAr.setVisibility(8);
                }
                return true;
            }
        };
        this.aZo = null;
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fAz = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fAj != null && AutoPlayVideoView.this.ble != null) {
                    AutoPlayVideoView.this.bcJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.fAk = -1;
        this.dJH = false;
        this.fAq = false;
        this.mOnClickListener = null;
        this.fAt = 0L;
        this.fAu = 0L;
        this.mDuration = 0L;
        this.fAv = 1.0f;
        this.fAw = 1.0f;
        this.fAx = null;
        this.fAy = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fAk != 1) {
                            if (AutoPlayVideoView.this.ble.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fAt = AutoPlayVideoView.this.fAu;
                            AutoPlayVideoView.this.dMX.setVisibility(8);
                            if (!AutoPlayVideoView.this.blg.bgl() || AutoPlayVideoView.this.fAx == null) {
                                AutoPlayVideoView.this.ble.seekTo((int) AutoPlayVideoView.this.fAu);
                                AutoPlayVideoView.this.dMR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.ble.getDuration();
                            AutoPlayVideoView.this.fAk = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dJH) {
                                AutoPlayVideoView.this.fAo.setVisibility(0);
                                AutoPlayVideoView.this.fAo.o(AutoPlayVideoView.this.fAu, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fAo.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fAm.lS();
                            AutoPlayVideoView.this.fAm.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dJH) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.ble.getDuration() - AutoPlayVideoView.this.ble.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fAn.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fAk == 1) {
                            if (AutoPlayVideoView.this.fAt == AutoPlayVideoView.this.ble.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fAt = AutoPlayVideoView.this.ble.getCurrentPosition();
                                AutoPlayVideoView.this.atL();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.ble.isPlaying() && AutoPlayVideoView.this.blg.bgl() && AutoPlayVideoView.this.fAx != null) {
                            if (AutoPlayVideoView.this.ble.getCurrentPosition() > AutoPlayVideoView.this.fAu) {
                                AutoPlayVideoView.this.dMR.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.ble != null && AutoPlayVideoView.this.blg.bgl()) {
                        if (AutoPlayVideoView.this.fAy == null) {
                            AutoPlayVideoView.this.fAy = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fAy.setDataSource(AutoPlayVideoView.this.blg.hQ(AutoPlayVideoView.this.blg.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fAx != null) {
                            AutoPlayVideoView.this.ble.seekTo((int) AutoPlayVideoView.this.fAu);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fAv, AutoPlayVideoView.this.fAw);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fAj;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atL();
                AutoPlayVideoView.this.fAu = 0L;
                if (AutoPlayVideoView.this.dJH) {
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fAr.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fAr.setVisibility(8);
                }
                return true;
            }
        };
        this.aZo = null;
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fAz = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fAj != null && AutoPlayVideoView.this.ble != null) {
                    AutoPlayVideoView.this.bcJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fAk = -1;
        this.dJH = false;
        this.fAq = false;
        this.mOnClickListener = null;
        this.fAt = 0L;
        this.fAu = 0L;
        this.mDuration = 0L;
        this.fAv = 1.0f;
        this.fAw = 1.0f;
        this.fAx = null;
        this.fAy = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fAk != 1) {
                            if (AutoPlayVideoView.this.ble.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fAt = AutoPlayVideoView.this.fAu;
                            AutoPlayVideoView.this.dMX.setVisibility(8);
                            if (!AutoPlayVideoView.this.blg.bgl() || AutoPlayVideoView.this.fAx == null) {
                                AutoPlayVideoView.this.ble.seekTo((int) AutoPlayVideoView.this.fAu);
                                AutoPlayVideoView.this.dMR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.ble.getDuration();
                            AutoPlayVideoView.this.fAk = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dJH) {
                                AutoPlayVideoView.this.fAo.setVisibility(0);
                                AutoPlayVideoView.this.fAo.o(AutoPlayVideoView.this.fAu, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fAo.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fAm.lS();
                            AutoPlayVideoView.this.fAm.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dJH) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.ble.getDuration() - AutoPlayVideoView.this.ble.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fAn.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fAk == 1) {
                            if (AutoPlayVideoView.this.fAt == AutoPlayVideoView.this.ble.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fAt = AutoPlayVideoView.this.ble.getCurrentPosition();
                                AutoPlayVideoView.this.atL();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.ble.isPlaying() && AutoPlayVideoView.this.blg.bgl() && AutoPlayVideoView.this.fAx != null) {
                            if (AutoPlayVideoView.this.ble.getCurrentPosition() > AutoPlayVideoView.this.fAu) {
                                AutoPlayVideoView.this.dMR.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.aZp = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.ble != null && AutoPlayVideoView.this.blg.bgl()) {
                        if (AutoPlayVideoView.this.fAy == null) {
                            AutoPlayVideoView.this.fAy = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fAy.setDataSource(AutoPlayVideoView.this.blg.hQ(AutoPlayVideoView.this.blg.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fAx != null) {
                            AutoPlayVideoView.this.ble.seekTo((int) AutoPlayVideoView.this.fAu);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fAv, AutoPlayVideoView.this.fAw);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fAj;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atL();
                AutoPlayVideoView.this.fAu = 0L;
                if (AutoPlayVideoView.this.dJH) {
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fAr.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fAr.setVisibility(8);
                }
                return true;
            }
        };
        this.aZo = null;
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fAz = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fAj != null && AutoPlayVideoView.this.ble != null) {
                    AutoPlayVideoView.this.bcJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.auto_play_video_view, (ViewGroup) this, true);
        this.fAh = this.mRootView.findViewById(d.g.content_wrapper);
        this.bpi = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.dMR = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.dMX = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.fAl = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.ble = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.blg = new n(this.mContext);
        this.ble.setBusiness(this.blg);
        this.fAm = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.fAn = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.fAo = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.fAp = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.fAp.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.fAr = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.fAs = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bcI() {
        return q.bcI();
    }

    public void bcJ() {
        if (bcI()) {
            this.ble.setVideoPath(this.fAj.video_url, this.aNv);
            this.ble.start();
            this.fAk = 0;
            if (!this.blg.bgl() || this.fAx == null) {
                showLoading();
            }
            this.fAr.setVisibility(8);
            kP(this.dJH);
            return;
        }
        atL();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fAj = videoInfo;
        this.aNv = str;
        this.dMR.setDefaultErrorResource(0);
        this.dMR.setDefaultResource(0);
        this.dMR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dMR.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dMR.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.ble.setOnPreparedListener(this.aZp);
        this.ble.setOnErrorListener(this.aZq);
        if (this.aZo != null) {
            this.ble.setOnCompletionListener(this.aZo);
        }
        this.ble.setOnSurfaceDestroyedListener(this.bln);
        this.fAm.setCertainColumnCount(4);
        this.fAm.setColumnColor(d.C0126d.cp_cont_i);
        this.fAp.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAs.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.e(getContext(), d.e.ds120);
        }
        layoutParams.height = af;
        this.fAs.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dMR.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.dMR.setLayoutParams(layoutParams2);
        this.dMR.setOnClickListener(this.mOnClickListener);
        this.fAs.setOnClickListener(this.mOnClickListener);
        this.fAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AutoPlayVideoView.this.dJH) {
                    AutoPlayVideoView.this.fAi.dismiss();
                    AutoPlayVideoView.this.dMR.setForegroundDrawable(d.f.icon_play_video);
                }
            }
        });
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void stopPlay() {
        this.mHandler.removeMessages(202);
        this.mHandler.removeMessages(301);
        this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
        this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
        this.fAo.destroy();
        e.fw().removeCallbacks(this.fAz);
        if (this.ble.isPlaying()) {
            this.fAt = this.ble.getCurrentPosition();
            if (this.blg.bgl() && this.fAy != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fAy.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fAt), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fAj.video_width.intValue() / frameAtTime.getWidth(), this.fAj.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fAx;
                                    this.fAx = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.dMR.setImageBitmap(this.fAx);
                                    this.dMR.setForegroundDrawable(0);
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
                                this.fAk = 3;
                                this.dMR.setVisibility(0);
                                this.ble.stopPlayback();
                                this.fAm.lS();
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
        this.fAk = 3;
        this.dMR.setVisibility(0);
        this.ble.stopPlayback();
        this.fAm.lS();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.fAn, d.C0126d.cp_cont_i);
            ak.c(this.fAp, d.C0126d.cp_cont_g, 1);
            ak.d(this.fAp, d.f.btn_video, 1);
            this.fAm.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fAk;
    }

    public long getCurrentPosition() {
        return this.fAt;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.aZo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.dMX.setVisibility(0);
        this.dMR.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atL() {
        this.dMX.setVisibility(8);
        this.dMR.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fAv = f;
        this.fAw = f2;
    }

    public long getDuration() {
        if (this.ble == null) {
            return this.fAj.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fAj.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fAu = j;
    }

    /* loaded from: classes3.dex */
    private static class a extends Dialog {
        public a(Activity activity, View view2, ViewGroup.LayoutParams layoutParams) {
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
            window.setContentView(view2, layoutParams);
            window.setTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kP(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.fAl.setVisibility(8);
            this.fAo.setPlayer(this.ble);
            return;
        }
        this.fAo.setVisibility(8);
        this.fAo.destroy();
        this.fAl.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fAh != null && this.ble != null) {
            if (!z) {
                if (this.fAi != null) {
                    this.fAi.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            kP(true);
            if (this.fAq) {
                this.fAp.setVisibility(0);
            }
            this.dJH = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAh.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fAh.getParent();
            viewGroup.removeAllViews();
            this.fAi = new a(bdBaseActivity.getActivity(), this.fAh, new ViewGroup.LayoutParams(-1, -1));
            this.fAi.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fAh != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.kP(false);
                        AutoPlayVideoView.this.fAp.setVisibility(8);
                        AutoPlayVideoView.this.dJH = false;
                        ((ViewGroup) AutoPlayVideoView.this.fAh.getParent()).removeView(AutoPlayVideoView.this.fAh);
                        viewGroup.addView(AutoPlayVideoView.this.fAh);
                        AutoPlayVideoView.this.fAh.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fAu = AutoPlayVideoView.this.fAt;
                        if (AutoPlayVideoView.this.fAr.getVisibility() != 0) {
                            AutoPlayVideoView.this.bcJ();
                        }
                        AutoPlayVideoView.this.fAr.setVisibility(8);
                    }
                }
            });
            this.fAu = this.fAt;
            bcJ();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fAq = z;
    }
}
