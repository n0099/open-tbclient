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
    private String aNu;
    private g.a aZn;
    private g.f aZo;
    private g.b aZp;
    private QuickVideoView bkP;
    private n bkR;
    private QuickVideoView.b bkY;
    private View boT;
    private boolean dIE;
    private ForeDrawableImageView dLO;
    private View dLU;
    private View fze;
    private a fzf;
    private VideoInfo fzg;
    private int fzh;
    private RelativeLayout fzi;
    private AudioAnimationView fzj;
    private TextView fzk;
    private PbChudianProcessBar fzl;
    private TextView fzm;
    private boolean fzn;
    private View fzo;
    private View fzp;
    private long fzq;
    private long fzr;
    private float fzs;
    private float fzt;
    private Bitmap fzu;
    private MediaMetadataRetriever fzv;
    private Runnable fzw;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fzh = -1;
        this.dIE = false;
        this.fzn = false;
        this.mOnClickListener = null;
        this.fzq = 0L;
        this.fzr = 0L;
        this.mDuration = 0L;
        this.fzs = 1.0f;
        this.fzt = 1.0f;
        this.fzu = null;
        this.fzv = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fzh != 1) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fzq = AutoPlayVideoView.this.fzr;
                            AutoPlayVideoView.this.dLU.setVisibility(8);
                            if (!AutoPlayVideoView.this.bkR.bgl() || AutoPlayVideoView.this.fzu == null) {
                                AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzr);
                                AutoPlayVideoView.this.dLO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bkP.getDuration();
                            AutoPlayVideoView.this.fzh = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dIE) {
                                AutoPlayVideoView.this.fzl.setVisibility(0);
                                AutoPlayVideoView.this.fzl.m(AutoPlayVideoView.this.fzr, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fzl.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fzj.lT();
                            AutoPlayVideoView.this.fzj.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dIE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bkP.getDuration() - AutoPlayVideoView.this.bkP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fzk.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fzh == 1) {
                            if (AutoPlayVideoView.this.fzq == AutoPlayVideoView.this.bkP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fzq = AutoPlayVideoView.this.bkP.getCurrentPosition();
                                AutoPlayVideoView.this.atM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.bkP.isPlaying() && AutoPlayVideoView.this.bkR.bgl() && AutoPlayVideoView.this.fzu != null) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() > AutoPlayVideoView.this.fzr) {
                                AutoPlayVideoView.this.dLO.setVisibility(8);
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bkP != null && AutoPlayVideoView.this.bkR.bgl()) {
                        if (AutoPlayVideoView.this.fzv == null) {
                            AutoPlayVideoView.this.fzv = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fzv.setDataSource(AutoPlayVideoView.this.bkR.hP(AutoPlayVideoView.this.bkR.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fzu != null) {
                            AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzr);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fzs, AutoPlayVideoView.this.fzt);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fzg;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atM();
                AutoPlayVideoView.this.fzr = 0L;
                if (AutoPlayVideoView.this.dIE) {
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fzo.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fzo.setVisibility(8);
                }
                return true;
            }
        };
        this.aZn = null;
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fzw = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fzg != null && AutoPlayVideoView.this.bkP != null) {
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
        this.fzh = -1;
        this.dIE = false;
        this.fzn = false;
        this.mOnClickListener = null;
        this.fzq = 0L;
        this.fzr = 0L;
        this.mDuration = 0L;
        this.fzs = 1.0f;
        this.fzt = 1.0f;
        this.fzu = null;
        this.fzv = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fzh != 1) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fzq = AutoPlayVideoView.this.fzr;
                            AutoPlayVideoView.this.dLU.setVisibility(8);
                            if (!AutoPlayVideoView.this.bkR.bgl() || AutoPlayVideoView.this.fzu == null) {
                                AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzr);
                                AutoPlayVideoView.this.dLO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bkP.getDuration();
                            AutoPlayVideoView.this.fzh = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dIE) {
                                AutoPlayVideoView.this.fzl.setVisibility(0);
                                AutoPlayVideoView.this.fzl.m(AutoPlayVideoView.this.fzr, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fzl.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fzj.lT();
                            AutoPlayVideoView.this.fzj.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dIE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bkP.getDuration() - AutoPlayVideoView.this.bkP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fzk.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fzh == 1) {
                            if (AutoPlayVideoView.this.fzq == AutoPlayVideoView.this.bkP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fzq = AutoPlayVideoView.this.bkP.getCurrentPosition();
                                AutoPlayVideoView.this.atM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.bkP.isPlaying() && AutoPlayVideoView.this.bkR.bgl() && AutoPlayVideoView.this.fzu != null) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() > AutoPlayVideoView.this.fzr) {
                                AutoPlayVideoView.this.dLO.setVisibility(8);
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bkP != null && AutoPlayVideoView.this.bkR.bgl()) {
                        if (AutoPlayVideoView.this.fzv == null) {
                            AutoPlayVideoView.this.fzv = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fzv.setDataSource(AutoPlayVideoView.this.bkR.hP(AutoPlayVideoView.this.bkR.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fzu != null) {
                            AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzr);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fzs, AutoPlayVideoView.this.fzt);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fzg;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atM();
                AutoPlayVideoView.this.fzr = 0L;
                if (AutoPlayVideoView.this.dIE) {
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fzo.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fzo.setVisibility(8);
                }
                return true;
            }
        };
        this.aZn = null;
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fzw = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fzg != null && AutoPlayVideoView.this.bkP != null) {
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
        this.fzh = -1;
        this.dIE = false;
        this.fzn = false;
        this.mOnClickListener = null;
        this.fzq = 0L;
        this.fzr = 0L;
        this.mDuration = 0L;
        this.fzs = 1.0f;
        this.fzt = 1.0f;
        this.fzu = null;
        this.fzv = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fzh != 1) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fzq = AutoPlayVideoView.this.fzr;
                            AutoPlayVideoView.this.dLU.setVisibility(8);
                            if (!AutoPlayVideoView.this.bkR.bgl() || AutoPlayVideoView.this.fzu == null) {
                                AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzr);
                                AutoPlayVideoView.this.dLO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bkP.getDuration();
                            AutoPlayVideoView.this.fzh = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dIE) {
                                AutoPlayVideoView.this.fzl.setVisibility(0);
                                AutoPlayVideoView.this.fzl.m(AutoPlayVideoView.this.fzr, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fzl.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fzj.lT();
                            AutoPlayVideoView.this.fzj.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dIE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bkP.getDuration() - AutoPlayVideoView.this.bkP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fzk.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fzh == 1) {
                            if (AutoPlayVideoView.this.fzq == AutoPlayVideoView.this.bkP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fzq = AutoPlayVideoView.this.bkP.getCurrentPosition();
                                AutoPlayVideoView.this.atM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.bkP.isPlaying() && AutoPlayVideoView.this.bkR.bgl() && AutoPlayVideoView.this.fzu != null) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() > AutoPlayVideoView.this.fzr) {
                                AutoPlayVideoView.this.dLO.setVisibility(8);
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bkP != null && AutoPlayVideoView.this.bkR.bgl()) {
                        if (AutoPlayVideoView.this.fzv == null) {
                            AutoPlayVideoView.this.fzv = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fzv.setDataSource(AutoPlayVideoView.this.bkR.hP(AutoPlayVideoView.this.bkR.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fzu != null) {
                            AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzr);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fzs, AutoPlayVideoView.this.fzt);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fzg;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atM();
                AutoPlayVideoView.this.fzr = 0L;
                if (AutoPlayVideoView.this.dIE) {
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fzo.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fzo.setVisibility(8);
                }
                return true;
            }
        };
        this.aZn = null;
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fzw = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fzg != null && AutoPlayVideoView.this.bkP != null) {
                    AutoPlayVideoView.this.bcJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.auto_play_video_view, (ViewGroup) this, true);
        this.fze = this.mRootView.findViewById(d.g.content_wrapper);
        this.boT = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.dLO = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.dLU = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.fzi = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.bkP = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.bkR = new n(this.mContext);
        this.bkP.setBusiness(this.bkR);
        this.fzj = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.fzk = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.fzl = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.fzm = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.fzm.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.fzo = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.fzp = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bcI() {
        return q.bcI();
    }

    public void bcJ() {
        if (bcI()) {
            this.bkP.setVideoPath(this.fzg.video_url, this.aNu);
            this.bkP.start();
            this.fzh = 0;
            if (!this.bkR.bgl() || this.fzu == null) {
                showLoading();
            }
            this.fzo.setVisibility(8);
            kO(this.dIE);
            return;
        }
        atM();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fzg = videoInfo;
        this.aNu = str;
        this.dLO.setDefaultErrorResource(0);
        this.dLO.setDefaultResource(0);
        this.dLO.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dLO.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dLO.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnErrorListener(this.aZp);
        if (this.aZn != null) {
            this.bkP.setOnCompletionListener(this.aZn);
        }
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        this.fzj.setCertainColumnCount(4);
        this.fzj.setColumnColor(d.C0126d.cp_cont_i);
        this.fzm.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzp.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.e(getContext(), d.e.ds120);
        }
        layoutParams.height = af;
        this.fzp.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dLO.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.dLO.setLayoutParams(layoutParams2);
        this.dLO.setOnClickListener(this.mOnClickListener);
        this.fzp.setOnClickListener(this.mOnClickListener);
        this.fzo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AutoPlayVideoView.this.dIE) {
                    AutoPlayVideoView.this.fzf.dismiss();
                    AutoPlayVideoView.this.dLO.setForegroundDrawable(d.f.icon_play_video);
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
        this.fzl.destroy();
        e.fw().removeCallbacks(this.fzw);
        if (this.bkP.isPlaying()) {
            this.fzq = this.bkP.getCurrentPosition();
            if (this.bkR.bgl() && this.fzv != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fzv.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fzq), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fzg.video_width.intValue() / frameAtTime.getWidth(), this.fzg.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fzu;
                                    this.fzu = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.dLO.setImageBitmap(this.fzu);
                                    this.dLO.setForegroundDrawable(0);
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
                                this.fzh = 3;
                                this.dLO.setVisibility(0);
                                this.bkP.stopPlayback();
                                this.fzj.lT();
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
        this.fzh = 3;
        this.dLO.setVisibility(0);
        this.bkP.stopPlayback();
        this.fzj.lT();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.fzk, d.C0126d.cp_cont_i);
            ak.c(this.fzm, d.C0126d.cp_cont_g, 1);
            ak.d(this.fzm, d.f.btn_video, 1);
            this.fzj.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fzh;
    }

    public long getCurrentPosition() {
        return this.fzq;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.aZn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.dLU.setVisibility(0);
        this.dLO.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atM() {
        this.dLU.setVisibility(8);
        this.dLO.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fzs = f;
        this.fzt = f2;
    }

    public long getDuration() {
        if (this.bkP == null) {
            return this.fzg.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fzg.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fzr = j;
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
    public void kO(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.fzi.setVisibility(8);
            this.fzl.setPlayer(this.bkP);
            return;
        }
        this.fzl.setVisibility(8);
        this.fzl.destroy();
        this.fzi.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fze != null && this.bkP != null) {
            if (!z) {
                if (this.fzf != null) {
                    this.fzf.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            kO(true);
            if (this.fzn) {
                this.fzm.setVisibility(0);
            }
            this.dIE = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fze.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fze.getParent();
            viewGroup.removeAllViews();
            this.fzf = new a(bdBaseActivity.getActivity(), this.fze, new ViewGroup.LayoutParams(-1, -1));
            this.fzf.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fze != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.kO(false);
                        AutoPlayVideoView.this.fzm.setVisibility(8);
                        AutoPlayVideoView.this.dIE = false;
                        ((ViewGroup) AutoPlayVideoView.this.fze.getParent()).removeView(AutoPlayVideoView.this.fze);
                        viewGroup.addView(AutoPlayVideoView.this.fze);
                        AutoPlayVideoView.this.fze.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fzr = AutoPlayVideoView.this.fzq;
                        if (AutoPlayVideoView.this.fzo.getVisibility() != 0) {
                            AutoPlayVideoView.this.bcJ();
                        }
                        AutoPlayVideoView.this.fzo.setVisibility(8);
                    }
                }
            });
            this.fzr = this.fzq;
            bcJ();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fzn = z;
    }
}
