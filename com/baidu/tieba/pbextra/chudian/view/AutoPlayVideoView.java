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
    private String bCS;
    private g.a bPp;
    private g.f bPq;
    private g.b bPr;
    private QuickVideoView caM;
    private n caO;
    private QuickVideoView.b caV;
    private View ceR;
    private boolean enQ;
    private ForeDrawableImageView eqM;
    private View eqS;
    private TextView geA;
    private PbChudianProcessBar geB;
    private TextView geC;
    private boolean geD;
    private View geE;
    private View geF;
    private long geG;
    private long geH;
    private float geI;
    private float geJ;
    private Bitmap geK;
    private MediaMetadataRetriever geL;
    private Runnable geM;
    private View gev;
    private VideoInfo gew;
    private int gex;
    private RelativeLayout gey;
    private AudioAnimationView gez;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gex = -1;
        this.enQ = false;
        this.geD = false;
        this.mOnClickListener = null;
        this.geG = 0L;
        this.geH = 0L;
        this.mDuration = 0L;
        this.geI = 1.0f;
        this.geJ = 1.0f;
        this.geK = null;
        this.geL = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gex != 1) {
                            if (AutoPlayVideoView.this.caM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geG = AutoPlayVideoView.this.geH;
                            AutoPlayVideoView.this.eqS.setVisibility(8);
                            if (!AutoPlayVideoView.this.caO.ble() || AutoPlayVideoView.this.geK == null) {
                                AutoPlayVideoView.this.caM.seekTo((int) AutoPlayVideoView.this.geH);
                                AutoPlayVideoView.this.eqM.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caM.getDuration();
                            AutoPlayVideoView.this.gex = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.enQ) {
                                AutoPlayVideoView.this.geB.setVisibility(0);
                                AutoPlayVideoView.this.geB.l(AutoPlayVideoView.this.geH, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geB.bhJ();
                                return;
                            }
                            AutoPlayVideoView.this.gez.tn();
                            AutoPlayVideoView.this.gez.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.enQ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caM.getDuration() - AutoPlayVideoView.this.caM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geA.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.gex == 1) {
                            if (AutoPlayVideoView.this.geG == AutoPlayVideoView.this.caM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geG = AutoPlayVideoView.this.caM.getCurrentPosition();
                                AutoPlayVideoView.this.aIG();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caM.isPlaying() && AutoPlayVideoView.this.caO.ble() && AutoPlayVideoView.this.geK != null) {
                            if (AutoPlayVideoView.this.caM.getCurrentPosition() > AutoPlayVideoView.this.geH) {
                                AutoPlayVideoView.this.eqM.setVisibility(8);
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
        this.bPq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caM != null && AutoPlayVideoView.this.caO.ble()) {
                        if (AutoPlayVideoView.this.geL == null) {
                            AutoPlayVideoView.this.geL = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geL.setDataSource(AutoPlayVideoView.this.caO.hW(AutoPlayVideoView.this.caO.bld()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geK != null) {
                            AutoPlayVideoView.this.caM.seekTo((int) AutoPlayVideoView.this.geH);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geI, AutoPlayVideoView.this.geJ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gew;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIG();
                AutoPlayVideoView.this.geH = 0L;
                if (AutoPlayVideoView.this.enQ) {
                    AutoPlayVideoView.this.eqM.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geE.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.eqM.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geE.setVisibility(8);
                }
                return true;
            }
        };
        this.bPp = null;
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geM = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gew != null && AutoPlayVideoView.this.caM != null) {
                    AutoPlayVideoView.this.bhI();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.gex = -1;
        this.enQ = false;
        this.geD = false;
        this.mOnClickListener = null;
        this.geG = 0L;
        this.geH = 0L;
        this.mDuration = 0L;
        this.geI = 1.0f;
        this.geJ = 1.0f;
        this.geK = null;
        this.geL = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gex != 1) {
                            if (AutoPlayVideoView.this.caM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geG = AutoPlayVideoView.this.geH;
                            AutoPlayVideoView.this.eqS.setVisibility(8);
                            if (!AutoPlayVideoView.this.caO.ble() || AutoPlayVideoView.this.geK == null) {
                                AutoPlayVideoView.this.caM.seekTo((int) AutoPlayVideoView.this.geH);
                                AutoPlayVideoView.this.eqM.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caM.getDuration();
                            AutoPlayVideoView.this.gex = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.enQ) {
                                AutoPlayVideoView.this.geB.setVisibility(0);
                                AutoPlayVideoView.this.geB.l(AutoPlayVideoView.this.geH, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geB.bhJ();
                                return;
                            }
                            AutoPlayVideoView.this.gez.tn();
                            AutoPlayVideoView.this.gez.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.enQ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caM.getDuration() - AutoPlayVideoView.this.caM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geA.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.gex == 1) {
                            if (AutoPlayVideoView.this.geG == AutoPlayVideoView.this.caM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geG = AutoPlayVideoView.this.caM.getCurrentPosition();
                                AutoPlayVideoView.this.aIG();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caM.isPlaying() && AutoPlayVideoView.this.caO.ble() && AutoPlayVideoView.this.geK != null) {
                            if (AutoPlayVideoView.this.caM.getCurrentPosition() > AutoPlayVideoView.this.geH) {
                                AutoPlayVideoView.this.eqM.setVisibility(8);
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
        this.bPq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caM != null && AutoPlayVideoView.this.caO.ble()) {
                        if (AutoPlayVideoView.this.geL == null) {
                            AutoPlayVideoView.this.geL = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geL.setDataSource(AutoPlayVideoView.this.caO.hW(AutoPlayVideoView.this.caO.bld()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geK != null) {
                            AutoPlayVideoView.this.caM.seekTo((int) AutoPlayVideoView.this.geH);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geI, AutoPlayVideoView.this.geJ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gew;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIG();
                AutoPlayVideoView.this.geH = 0L;
                if (AutoPlayVideoView.this.enQ) {
                    AutoPlayVideoView.this.eqM.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geE.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.eqM.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geE.setVisibility(8);
                }
                return true;
            }
        };
        this.bPp = null;
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geM = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gew != null && AutoPlayVideoView.this.caM != null) {
                    AutoPlayVideoView.this.bhI();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gex = -1;
        this.enQ = false;
        this.geD = false;
        this.mOnClickListener = null;
        this.geG = 0L;
        this.geH = 0L;
        this.mDuration = 0L;
        this.geI = 1.0f;
        this.geJ = 1.0f;
        this.geK = null;
        this.geL = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gex != 1) {
                            if (AutoPlayVideoView.this.caM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geG = AutoPlayVideoView.this.geH;
                            AutoPlayVideoView.this.eqS.setVisibility(8);
                            if (!AutoPlayVideoView.this.caO.ble() || AutoPlayVideoView.this.geK == null) {
                                AutoPlayVideoView.this.caM.seekTo((int) AutoPlayVideoView.this.geH);
                                AutoPlayVideoView.this.eqM.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caM.getDuration();
                            AutoPlayVideoView.this.gex = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.enQ) {
                                AutoPlayVideoView.this.geB.setVisibility(0);
                                AutoPlayVideoView.this.geB.l(AutoPlayVideoView.this.geH, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geB.bhJ();
                                return;
                            }
                            AutoPlayVideoView.this.gez.tn();
                            AutoPlayVideoView.this.gez.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.enQ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caM.getDuration() - AutoPlayVideoView.this.caM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geA.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.gex == 1) {
                            if (AutoPlayVideoView.this.geG == AutoPlayVideoView.this.caM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geG = AutoPlayVideoView.this.caM.getCurrentPosition();
                                AutoPlayVideoView.this.aIG();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caM.isPlaying() && AutoPlayVideoView.this.caO.ble() && AutoPlayVideoView.this.geK != null) {
                            if (AutoPlayVideoView.this.caM.getCurrentPosition() > AutoPlayVideoView.this.geH) {
                                AutoPlayVideoView.this.eqM.setVisibility(8);
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
        this.bPq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caM != null && AutoPlayVideoView.this.caO.ble()) {
                        if (AutoPlayVideoView.this.geL == null) {
                            AutoPlayVideoView.this.geL = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geL.setDataSource(AutoPlayVideoView.this.caO.hW(AutoPlayVideoView.this.caO.bld()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geK != null) {
                            AutoPlayVideoView.this.caM.seekTo((int) AutoPlayVideoView.this.geH);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geI, AutoPlayVideoView.this.geJ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gew;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIG();
                AutoPlayVideoView.this.geH = 0L;
                if (AutoPlayVideoView.this.enQ) {
                    AutoPlayVideoView.this.eqM.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geE.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.eqM.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geE.setVisibility(8);
                }
                return true;
            }
        };
        this.bPp = null;
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geM = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gew != null && AutoPlayVideoView.this.caM != null) {
                    AutoPlayVideoView.this.bhI();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.gev = this.mRootView.findViewById(d.g.content_wrapper);
        this.ceR = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.eqM = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.eqS = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.gey = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.caM = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.caO = new n(this.mContext);
        this.caM.setBusiness(this.caO);
        this.gez = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.geA = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.geB = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.geC = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.geC.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.geE = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.geF = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bhH() {
        return q.bhH();
    }

    public void bhI() {
        if (bhH()) {
            this.caM.bN(this.gew.video_url, this.bCS);
            this.caM.start();
            this.gex = 0;
            if (!this.caO.ble() || this.geK == null) {
                showLoading();
            }
            this.geE.setVisibility(8);
            lm(this.enQ);
            return;
        }
        aIG();
    }

    public void stopPlay() {
        this.mHandler.removeMessages(202);
        this.mHandler.removeMessages(301);
        this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
        this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
        this.geB.destroy();
        e.ns().removeCallbacks(this.geM);
        if (this.caM.isPlaying()) {
            this.geG = this.caM.getCurrentPosition();
            if (this.caO.ble() && this.geL != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.geL.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.geG), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.gew.video_width.intValue() / frameAtTime.getWidth(), this.gew.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.geK;
                                    this.geK = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eqM.setImageBitmap(this.geK);
                                    this.eqM.setForegroundDrawable(0);
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
                                this.gex = 3;
                                this.eqM.setVisibility(0);
                                this.caM.stopPlayback();
                                this.gez.tn();
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
        this.gex = 3;
        this.eqM.setVisibility(0);
        this.caM.stopPlayback();
        this.gez.tn();
    }

    public int getPlayStatus() {
        return this.gex;
    }

    public long getCurrentPosition() {
        return this.geG;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bPp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eqS.setVisibility(0);
        this.eqM.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIG() {
        this.eqS.setVisibility(8);
        this.eqM.setForegroundDrawable(d.f.icon_play_video);
    }

    public long getDuration() {
        if (this.caM == null) {
            return this.gew.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.gew.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.geH = j;
    }

    private void lm(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.gey.setVisibility(8);
            this.geB.setPlayer(this.caM);
            return;
        }
        this.geB.setVisibility(8);
        this.geB.destroy();
        this.gey.setVisibility(0);
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.geD = z;
    }
}
