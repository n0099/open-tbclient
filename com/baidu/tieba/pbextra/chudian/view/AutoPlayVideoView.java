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
import com.baidu.tieba.f;
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
    private View axB;
    private g.b bdd;
    private QuickVideoView.b bdh;
    private g.a bjM;
    private g.f bjN;
    private QuickVideoView bvr;
    private n bvt;
    private boolean dfe;
    private ForeDrawableImageView efK;
    private View efQ;
    private View fPH;
    private a fPI;
    private VideoInfo fPJ;
    private int fPK;
    private RelativeLayout fPL;
    private AudioAnimationView fPM;
    private TextView fPN;
    private PbChudianProcessBar fPO;
    private TextView fPP;
    private boolean fPQ;
    private View fPR;
    private View fPS;
    private long fPT;
    private long fPU;
    private float fPV;
    private float fPW;
    private Bitmap fPX;
    private MediaMetadataRetriever fPY;
    private Runnable fPZ;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fPK = -1;
        this.dfe = false;
        this.fPQ = false;
        this.mOnClickListener = null;
        this.fPT = 0L;
        this.fPU = 0L;
        this.mDuration = 0L;
        this.fPV = 1.0f;
        this.fPW = 1.0f;
        this.fPX = null;
        this.fPY = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPK != 1) {
                            if (AutoPlayVideoView.this.bvr.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fPT = AutoPlayVideoView.this.fPU;
                            AutoPlayVideoView.this.efQ.setVisibility(8);
                            if (!AutoPlayVideoView.this.bvt.bkc() || AutoPlayVideoView.this.fPX == null) {
                                AutoPlayVideoView.this.bvr.seekTo((int) AutoPlayVideoView.this.fPU);
                                AutoPlayVideoView.this.efK.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bvr.getDuration();
                            AutoPlayVideoView.this.fPK = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dfe) {
                                AutoPlayVideoView.this.fPO.setVisibility(0);
                                AutoPlayVideoView.this.fPO.n(AutoPlayVideoView.this.fPU, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPO.bgE();
                                return;
                            }
                            AutoPlayVideoView.this.fPM.oJ();
                            AutoPlayVideoView.this.fPM.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dfe) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bvr.getDuration() - AutoPlayVideoView.this.bvr.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPN.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPK == 1) {
                            if (AutoPlayVideoView.this.fPT == AutoPlayVideoView.this.bvr.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fPT = AutoPlayVideoView.this.bvr.getCurrentPosition();
                                AutoPlayVideoView.this.azg();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bvr.isPlaying() && AutoPlayVideoView.this.bvt.bkc() && AutoPlayVideoView.this.fPX != null) {
                            if (AutoPlayVideoView.this.bvr.getCurrentPosition() > AutoPlayVideoView.this.fPU) {
                                AutoPlayVideoView.this.efK.setVisibility(8);
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
        this.bjN = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bvr != null && AutoPlayVideoView.this.bvt.bkc()) {
                        if (AutoPlayVideoView.this.fPY == null) {
                            AutoPlayVideoView.this.fPY = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fPY.setDataSource(AutoPlayVideoView.this.bvt.is(AutoPlayVideoView.this.bvt.bkb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fPX != null) {
                            AutoPlayVideoView.this.bvr.seekTo((int) AutoPlayVideoView.this.fPU);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fPV, AutoPlayVideoView.this.fPW);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPJ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.azg();
                AutoPlayVideoView.this.fPU = 0L;
                if (AutoPlayVideoView.this.dfe) {
                    AutoPlayVideoView.this.efK.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPR.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), f.j.pb_play_error);
                    AutoPlayVideoView.this.efK.setForegroundDrawable(f.C0146f.icon_play_video);
                    AutoPlayVideoView.this.fPR.setVisibility(8);
                }
                return true;
            }
        };
        this.bjM = null;
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fPZ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPJ != null && AutoPlayVideoView.this.bvr != null) {
                    AutoPlayVideoView.this.bgD();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.fPK = -1;
        this.dfe = false;
        this.fPQ = false;
        this.mOnClickListener = null;
        this.fPT = 0L;
        this.fPU = 0L;
        this.mDuration = 0L;
        this.fPV = 1.0f;
        this.fPW = 1.0f;
        this.fPX = null;
        this.fPY = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPK != 1) {
                            if (AutoPlayVideoView.this.bvr.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fPT = AutoPlayVideoView.this.fPU;
                            AutoPlayVideoView.this.efQ.setVisibility(8);
                            if (!AutoPlayVideoView.this.bvt.bkc() || AutoPlayVideoView.this.fPX == null) {
                                AutoPlayVideoView.this.bvr.seekTo((int) AutoPlayVideoView.this.fPU);
                                AutoPlayVideoView.this.efK.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bvr.getDuration();
                            AutoPlayVideoView.this.fPK = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dfe) {
                                AutoPlayVideoView.this.fPO.setVisibility(0);
                                AutoPlayVideoView.this.fPO.n(AutoPlayVideoView.this.fPU, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPO.bgE();
                                return;
                            }
                            AutoPlayVideoView.this.fPM.oJ();
                            AutoPlayVideoView.this.fPM.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dfe) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bvr.getDuration() - AutoPlayVideoView.this.bvr.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPN.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPK == 1) {
                            if (AutoPlayVideoView.this.fPT == AutoPlayVideoView.this.bvr.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fPT = AutoPlayVideoView.this.bvr.getCurrentPosition();
                                AutoPlayVideoView.this.azg();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bvr.isPlaying() && AutoPlayVideoView.this.bvt.bkc() && AutoPlayVideoView.this.fPX != null) {
                            if (AutoPlayVideoView.this.bvr.getCurrentPosition() > AutoPlayVideoView.this.fPU) {
                                AutoPlayVideoView.this.efK.setVisibility(8);
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
        this.bjN = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bvr != null && AutoPlayVideoView.this.bvt.bkc()) {
                        if (AutoPlayVideoView.this.fPY == null) {
                            AutoPlayVideoView.this.fPY = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fPY.setDataSource(AutoPlayVideoView.this.bvt.is(AutoPlayVideoView.this.bvt.bkb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fPX != null) {
                            AutoPlayVideoView.this.bvr.seekTo((int) AutoPlayVideoView.this.fPU);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fPV, AutoPlayVideoView.this.fPW);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPJ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.azg();
                AutoPlayVideoView.this.fPU = 0L;
                if (AutoPlayVideoView.this.dfe) {
                    AutoPlayVideoView.this.efK.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPR.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), f.j.pb_play_error);
                    AutoPlayVideoView.this.efK.setForegroundDrawable(f.C0146f.icon_play_video);
                    AutoPlayVideoView.this.fPR.setVisibility(8);
                }
                return true;
            }
        };
        this.bjM = null;
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fPZ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPJ != null && AutoPlayVideoView.this.bvr != null) {
                    AutoPlayVideoView.this.bgD();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fPK = -1;
        this.dfe = false;
        this.fPQ = false;
        this.mOnClickListener = null;
        this.fPT = 0L;
        this.fPU = 0L;
        this.mDuration = 0L;
        this.fPV = 1.0f;
        this.fPW = 1.0f;
        this.fPX = null;
        this.fPY = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPK != 1) {
                            if (AutoPlayVideoView.this.bvr.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fPT = AutoPlayVideoView.this.fPU;
                            AutoPlayVideoView.this.efQ.setVisibility(8);
                            if (!AutoPlayVideoView.this.bvt.bkc() || AutoPlayVideoView.this.fPX == null) {
                                AutoPlayVideoView.this.bvr.seekTo((int) AutoPlayVideoView.this.fPU);
                                AutoPlayVideoView.this.efK.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bvr.getDuration();
                            AutoPlayVideoView.this.fPK = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dfe) {
                                AutoPlayVideoView.this.fPO.setVisibility(0);
                                AutoPlayVideoView.this.fPO.n(AutoPlayVideoView.this.fPU, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPO.bgE();
                                return;
                            }
                            AutoPlayVideoView.this.fPM.oJ();
                            AutoPlayVideoView.this.fPM.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dfe) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bvr.getDuration() - AutoPlayVideoView.this.bvr.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPN.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPK == 1) {
                            if (AutoPlayVideoView.this.fPT == AutoPlayVideoView.this.bvr.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fPT = AutoPlayVideoView.this.bvr.getCurrentPosition();
                                AutoPlayVideoView.this.azg();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bvr.isPlaying() && AutoPlayVideoView.this.bvt.bkc() && AutoPlayVideoView.this.fPX != null) {
                            if (AutoPlayVideoView.this.bvr.getCurrentPosition() > AutoPlayVideoView.this.fPU) {
                                AutoPlayVideoView.this.efK.setVisibility(8);
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
        this.bjN = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bvr != null && AutoPlayVideoView.this.bvt.bkc()) {
                        if (AutoPlayVideoView.this.fPY == null) {
                            AutoPlayVideoView.this.fPY = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fPY.setDataSource(AutoPlayVideoView.this.bvt.is(AutoPlayVideoView.this.bvt.bkb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fPX != null) {
                            AutoPlayVideoView.this.bvr.seekTo((int) AutoPlayVideoView.this.fPU);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fPV, AutoPlayVideoView.this.fPW);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPJ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.azg();
                AutoPlayVideoView.this.fPU = 0L;
                if (AutoPlayVideoView.this.dfe) {
                    AutoPlayVideoView.this.efK.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPR.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), f.j.pb_play_error);
                    AutoPlayVideoView.this.efK.setForegroundDrawable(f.C0146f.icon_play_video);
                    AutoPlayVideoView.this.fPR.setVisibility(8);
                }
                return true;
            }
        };
        this.bjM = null;
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fPZ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPJ != null && AutoPlayVideoView.this.bvr != null) {
                    AutoPlayVideoView.this.bgD();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(f.h.auto_play_video_view, (ViewGroup) this, true);
        this.fPH = this.mRootView.findViewById(f.g.content_wrapper);
        this.axB = this.mRootView.findViewById(f.g.auto_video_black_mask);
        this.efK = (ForeDrawableImageView) this.mRootView.findViewById(f.g.pb_list_video_item_thumbnail);
        this.efQ = this.mRootView.findViewById(f.g.pb_layout_loading);
        this.fPL = (RelativeLayout) this.mRootView.findViewById(f.g.process_bar);
        this.bvr = (QuickVideoView) this.mRootView.findViewById(f.g.texture_video_view);
        this.bvt = new n(this.mContext);
        this.bvr.setBusiness(this.bvt);
        this.fPM = (AudioAnimationView) this.mRootView.findViewById(f.g.playing_animation);
        this.fPN = (TextView) this.mRootView.findViewById(f.g.count_down_process);
        this.fPO = (PbChudianProcessBar) this.mRootView.findViewById(f.g.full_screen_process_bar);
        this.fPP = (TextView) this.mRootView.findViewById(f.g.check_detail);
        this.fPP.setTag(f.g.tag_pb_chudian_check_detail, true);
        this.fPR = this.mRootView.findViewById(f.g.chudian_error_tip);
        this.fPS = this.mRootView.findViewById(f.g.available_click_area);
    }

    private boolean bgC() {
        return q.bgC();
    }

    public void bgD() {
        if (bgC()) {
            this.bvr.setVideoPath(this.fPJ.video_url, this.aWq);
            this.bvr.start();
            this.fPK = 0;
            if (!this.bvt.bkc() || this.fPX == null) {
                showLoading();
            }
            this.fPR.setVisibility(8);
            kR(this.dfe);
            return;
        }
        azg();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPJ = videoInfo;
        this.aWq = str;
        this.efK.setDefaultErrorResource(0);
        this.efK.setDefaultResource(0);
        this.efK.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.efK.setForegroundDrawable(f.C0146f.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.efK.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bvr.setOnPreparedListener(this.bjN);
        this.bvr.setOnErrorListener(this.bdd);
        if (this.bjM != null) {
            this.bvr.setOnCompletionListener(this.bjM);
        }
        this.bvr.setOnSurfaceDestroyedListener(this.bdh);
        this.fPM.setCertainColumnCount(4);
        this.fPM.setColumnColor(f.d.cp_cont_i);
        this.fPP.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPS.getLayoutParams();
        int ah = l.ah(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            ah = ((ah * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.f(getContext(), f.e.ds120);
        }
        layoutParams.height = ah;
        this.fPS.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.efK.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = ah;
        }
        this.efK.setLayoutParams(layoutParams2);
        this.efK.setOnClickListener(this.mOnClickListener);
        this.fPS.setOnClickListener(this.mOnClickListener);
        this.fPR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.dfe) {
                    AutoPlayVideoView.this.fPI.dismiss();
                    AutoPlayVideoView.this.efK.setForegroundDrawable(f.C0146f.icon_play_video);
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
        this.fPO.destroy();
        e.in().removeCallbacks(this.fPZ);
        if (this.bvr.isPlaying()) {
            this.fPT = this.bvr.getCurrentPosition();
            if (this.bvt.bkc() && this.fPY != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fPY.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fPT), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fPJ.video_width.intValue() / frameAtTime.getWidth(), this.fPJ.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fPX;
                                    this.fPX = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.efK.setImageBitmap(this.fPX);
                                    this.efK.setForegroundDrawable(0);
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
                                this.fPK = 3;
                                this.efK.setVisibility(0);
                                this.bvr.stopPlayback();
                                this.fPM.oJ();
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
        this.fPK = 3;
        this.efK.setVisibility(0);
        this.bvr.stopPlayback();
        this.fPM.oJ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.fPN, f.d.cp_cont_i);
            am.c(this.fPP, f.d.cp_cont_g, 1);
            am.d(this.fPP, f.C0146f.btn_video, 1);
            this.fPM.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fPK;
    }

    public long getCurrentPosition() {
        return this.fPT;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bjM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.efQ.setVisibility(0);
        this.efK.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azg() {
        this.efQ.setVisibility(8);
        this.efK.setForegroundDrawable(f.C0146f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fPV = f;
        this.fPW = f2;
    }

    public long getDuration() {
        if (this.bvr == null) {
            return this.fPJ.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fPJ.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fPU = j;
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
            window.setBackgroundDrawableResource(f.C0146f.alpha15_black_stroke_bg);
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
            this.fPL.setVisibility(8);
            this.fPO.setPlayer(this.bvr);
            return;
        }
        this.fPO.setVisibility(8);
        this.fPO.destroy();
        this.fPL.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fPH != null && this.bvr != null) {
            if (!z) {
                if (this.fPI != null) {
                    this.fPI.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            kR(true);
            if (this.fPQ) {
                this.fPP.setVisibility(0);
            }
            this.dfe = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPH.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fPH.getParent();
            viewGroup.removeAllViews();
            this.fPI = new a(bdBaseActivity.getActivity(), this.fPH, new ViewGroup.LayoutParams(-1, -1));
            this.fPI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fPH != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.kR(false);
                        AutoPlayVideoView.this.fPP.setVisibility(8);
                        AutoPlayVideoView.this.dfe = false;
                        ((ViewGroup) AutoPlayVideoView.this.fPH.getParent()).removeView(AutoPlayVideoView.this.fPH);
                        viewGroup.addView(AutoPlayVideoView.this.fPH);
                        AutoPlayVideoView.this.fPH.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fPU = AutoPlayVideoView.this.fPT;
                        if (AutoPlayVideoView.this.fPR.getVisibility() != 0) {
                            AutoPlayVideoView.this.bgD();
                        }
                        AutoPlayVideoView.this.fPR.setVisibility(8);
                    }
                }
            });
            this.fPU = this.fPT;
            bgD();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fPQ = z;
    }
}
