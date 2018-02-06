package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AutoPlayVideoView extends a {
    private String bDf;
    private g.a bPC;
    private g.f bPD;
    private g.b bPE;
    private QuickVideoView caY;
    private n cba;
    private QuickVideoView.b cbh;
    private View cfd;
    private boolean eoc;
    private ForeDrawableImageView eqY;
    private View ere;
    private View geG;
    private VideoInfo geH;
    private int geI;
    private RelativeLayout geJ;
    private AudioAnimationView geK;
    private TextView geL;
    private PbChudianProcessBar geM;
    private TextView geN;
    private boolean geO;
    private View geP;
    private View geQ;
    private long geR;
    private long geS;
    private float geT;
    private float geU;
    private Bitmap geV;
    private MediaMetadataRetriever geW;
    private Runnable geX;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.geI = -1;
        this.eoc = false;
        this.geO = false;
        this.mOnClickListener = null;
        this.geR = 0L;
        this.geS = 0L;
        this.mDuration = 0L;
        this.geT = 1.0f;
        this.geU = 1.0f;
        this.geV = null;
        this.geW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geI != 1) {
                            if (AutoPlayVideoView.this.caY.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geR = AutoPlayVideoView.this.geS;
                            AutoPlayVideoView.this.ere.setVisibility(8);
                            if (!AutoPlayVideoView.this.cba.blf() || AutoPlayVideoView.this.geV == null) {
                                AutoPlayVideoView.this.caY.seekTo((int) AutoPlayVideoView.this.geS);
                                AutoPlayVideoView.this.eqY.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caY.getDuration();
                            AutoPlayVideoView.this.geI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.eoc) {
                                AutoPlayVideoView.this.geM.setVisibility(0);
                                AutoPlayVideoView.this.geM.l(AutoPlayVideoView.this.geS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geM.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.geK.tn();
                            AutoPlayVideoView.this.geK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.eoc) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caY.getDuration() - AutoPlayVideoView.this.caY.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.geI == 1) {
                            if (AutoPlayVideoView.this.geR == AutoPlayVideoView.this.caY.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geR = AutoPlayVideoView.this.caY.getCurrentPosition();
                                AutoPlayVideoView.this.aIH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caY.isPlaying() && AutoPlayVideoView.this.cba.blf() && AutoPlayVideoView.this.geV != null) {
                            if (AutoPlayVideoView.this.caY.getCurrentPosition() > AutoPlayVideoView.this.geS) {
                                AutoPlayVideoView.this.eqY.setVisibility(8);
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
        this.bPD = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caY != null && AutoPlayVideoView.this.cba.blf()) {
                        if (AutoPlayVideoView.this.geW == null) {
                            AutoPlayVideoView.this.geW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geW.setDataSource(AutoPlayVideoView.this.cba.hW(AutoPlayVideoView.this.cba.ble()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geV != null) {
                            AutoPlayVideoView.this.caY.seekTo((int) AutoPlayVideoView.this.geS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geT, AutoPlayVideoView.this.geU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIH();
                AutoPlayVideoView.this.geS = 0L;
                if (AutoPlayVideoView.this.eoc) {
                    AutoPlayVideoView.this.eqY.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.eqY.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geP.setVisibility(8);
                }
                return true;
            }
        };
        this.bPC = null;
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geH != null && AutoPlayVideoView.this.caY != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.geI = -1;
        this.eoc = false;
        this.geO = false;
        this.mOnClickListener = null;
        this.geR = 0L;
        this.geS = 0L;
        this.mDuration = 0L;
        this.geT = 1.0f;
        this.geU = 1.0f;
        this.geV = null;
        this.geW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geI != 1) {
                            if (AutoPlayVideoView.this.caY.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geR = AutoPlayVideoView.this.geS;
                            AutoPlayVideoView.this.ere.setVisibility(8);
                            if (!AutoPlayVideoView.this.cba.blf() || AutoPlayVideoView.this.geV == null) {
                                AutoPlayVideoView.this.caY.seekTo((int) AutoPlayVideoView.this.geS);
                                AutoPlayVideoView.this.eqY.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caY.getDuration();
                            AutoPlayVideoView.this.geI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.eoc) {
                                AutoPlayVideoView.this.geM.setVisibility(0);
                                AutoPlayVideoView.this.geM.l(AutoPlayVideoView.this.geS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geM.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.geK.tn();
                            AutoPlayVideoView.this.geK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.eoc) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caY.getDuration() - AutoPlayVideoView.this.caY.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.geI == 1) {
                            if (AutoPlayVideoView.this.geR == AutoPlayVideoView.this.caY.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geR = AutoPlayVideoView.this.caY.getCurrentPosition();
                                AutoPlayVideoView.this.aIH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caY.isPlaying() && AutoPlayVideoView.this.cba.blf() && AutoPlayVideoView.this.geV != null) {
                            if (AutoPlayVideoView.this.caY.getCurrentPosition() > AutoPlayVideoView.this.geS) {
                                AutoPlayVideoView.this.eqY.setVisibility(8);
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
        this.bPD = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caY != null && AutoPlayVideoView.this.cba.blf()) {
                        if (AutoPlayVideoView.this.geW == null) {
                            AutoPlayVideoView.this.geW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geW.setDataSource(AutoPlayVideoView.this.cba.hW(AutoPlayVideoView.this.cba.ble()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geV != null) {
                            AutoPlayVideoView.this.caY.seekTo((int) AutoPlayVideoView.this.geS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geT, AutoPlayVideoView.this.geU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIH();
                AutoPlayVideoView.this.geS = 0L;
                if (AutoPlayVideoView.this.eoc) {
                    AutoPlayVideoView.this.eqY.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.eqY.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geP.setVisibility(8);
                }
                return true;
            }
        };
        this.bPC = null;
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geH != null && AutoPlayVideoView.this.caY != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.geI = -1;
        this.eoc = false;
        this.geO = false;
        this.mOnClickListener = null;
        this.geR = 0L;
        this.geS = 0L;
        this.mDuration = 0L;
        this.geT = 1.0f;
        this.geU = 1.0f;
        this.geV = null;
        this.geW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geI != 1) {
                            if (AutoPlayVideoView.this.caY.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geR = AutoPlayVideoView.this.geS;
                            AutoPlayVideoView.this.ere.setVisibility(8);
                            if (!AutoPlayVideoView.this.cba.blf() || AutoPlayVideoView.this.geV == null) {
                                AutoPlayVideoView.this.caY.seekTo((int) AutoPlayVideoView.this.geS);
                                AutoPlayVideoView.this.eqY.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caY.getDuration();
                            AutoPlayVideoView.this.geI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.eoc) {
                                AutoPlayVideoView.this.geM.setVisibility(0);
                                AutoPlayVideoView.this.geM.l(AutoPlayVideoView.this.geS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geM.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.geK.tn();
                            AutoPlayVideoView.this.geK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.eoc) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caY.getDuration() - AutoPlayVideoView.this.caY.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.geI == 1) {
                            if (AutoPlayVideoView.this.geR == AutoPlayVideoView.this.caY.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geR = AutoPlayVideoView.this.caY.getCurrentPosition();
                                AutoPlayVideoView.this.aIH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caY.isPlaying() && AutoPlayVideoView.this.cba.blf() && AutoPlayVideoView.this.geV != null) {
                            if (AutoPlayVideoView.this.caY.getCurrentPosition() > AutoPlayVideoView.this.geS) {
                                AutoPlayVideoView.this.eqY.setVisibility(8);
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
        this.bPD = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caY != null && AutoPlayVideoView.this.cba.blf()) {
                        if (AutoPlayVideoView.this.geW == null) {
                            AutoPlayVideoView.this.geW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geW.setDataSource(AutoPlayVideoView.this.cba.hW(AutoPlayVideoView.this.cba.ble()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geV != null) {
                            AutoPlayVideoView.this.caY.seekTo((int) AutoPlayVideoView.this.geS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geT, AutoPlayVideoView.this.geU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIH();
                AutoPlayVideoView.this.geS = 0L;
                if (AutoPlayVideoView.this.eoc) {
                    AutoPlayVideoView.this.eqY.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.eqY.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geP.setVisibility(8);
                }
                return true;
            }
        };
        this.bPC = null;
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geH != null && AutoPlayVideoView.this.caY != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.geG = this.mRootView.findViewById(d.g.content_wrapper);
        this.cfd = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.eqY = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.ere = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.geJ = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.caY = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.cba = new n(this.mContext);
        this.caY.setBusiness(this.cba);
        this.geK = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.geL = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.geM = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.geN = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.geN.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.geP = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.geQ = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bhI() {
        return q.bhI();
    }

    public void bhJ() {
        if (bhI()) {
            this.caY.bN(this.geH.video_url, this.bDf);
            this.caY.start();
            this.geI = 0;
            if (!this.cba.blf() || this.geV == null) {
                showLoading();
            }
            this.geP.setVisibility(8);
            lm(this.eoc);
            return;
        }
        aIH();
    }

    public void stopPlay() {
        this.mHandler.removeMessages(202);
        this.mHandler.removeMessages(301);
        this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
        this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
        this.geM.destroy();
        e.ns().removeCallbacks(this.geX);
        if (this.caY.isPlaying()) {
            this.geR = this.caY.getCurrentPosition();
            if (this.cba.blf() && this.geW != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.geW.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.geR), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.geH.video_width.intValue() / frameAtTime.getWidth(), this.geH.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.geV;
                                    this.geV = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eqY.setImageBitmap(this.geV);
                                    this.eqY.setForegroundDrawable(0);
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
                                this.geI = 3;
                                this.eqY.setVisibility(0);
                                this.caY.stopPlayback();
                                this.geK.tn();
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
        this.geI = 3;
        this.eqY.setVisibility(0);
        this.caY.stopPlayback();
        this.geK.tn();
    }

    public int getPlayStatus() {
        return this.geI;
    }

    public long getCurrentPosition() {
        return this.geR;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bPC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.ere.setVisibility(0);
        this.eqY.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIH() {
        this.ere.setVisibility(8);
        this.eqY.setForegroundDrawable(d.f.icon_play_video);
    }

    public long getDuration() {
        if (this.caY == null) {
            return this.geH.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.geH.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.geS = j;
    }

    private void lm(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.geJ.setVisibility(8);
            this.geM.setPlayer(this.caY);
            return;
        }
        this.geM.setVisibility(8);
        this.geM.destroy();
        this.geJ.setVisibility(0);
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.geO = z;
    }
}
