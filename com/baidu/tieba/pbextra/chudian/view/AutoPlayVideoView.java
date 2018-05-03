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
    private boolean dIB;
    private ForeDrawableImageView dLL;
    private View dLR;
    private View fzb;
    private a fzc;
    private VideoInfo fzd;
    private int fze;
    private RelativeLayout fzf;
    private AudioAnimationView fzg;
    private TextView fzh;
    private PbChudianProcessBar fzi;
    private TextView fzj;
    private boolean fzk;
    private View fzl;
    private View fzm;
    private long fzn;
    private long fzo;
    private float fzp;
    private float fzq;
    private Bitmap fzr;
    private MediaMetadataRetriever fzs;
    private Runnable fzt;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fze = -1;
        this.dIB = false;
        this.fzk = false;
        this.mOnClickListener = null;
        this.fzn = 0L;
        this.fzo = 0L;
        this.mDuration = 0L;
        this.fzp = 1.0f;
        this.fzq = 1.0f;
        this.fzr = null;
        this.fzs = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fze != 1) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fzn = AutoPlayVideoView.this.fzo;
                            AutoPlayVideoView.this.dLR.setVisibility(8);
                            if (!AutoPlayVideoView.this.bkR.bgl() || AutoPlayVideoView.this.fzr == null) {
                                AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzo);
                                AutoPlayVideoView.this.dLL.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bkP.getDuration();
                            AutoPlayVideoView.this.fze = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dIB) {
                                AutoPlayVideoView.this.fzi.setVisibility(0);
                                AutoPlayVideoView.this.fzi.o(AutoPlayVideoView.this.fzo, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fzi.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fzg.lT();
                            AutoPlayVideoView.this.fzg.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dIB) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bkP.getDuration() - AutoPlayVideoView.this.bkP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fzh.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fze == 1) {
                            if (AutoPlayVideoView.this.fzn == AutoPlayVideoView.this.bkP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fzn = AutoPlayVideoView.this.bkP.getCurrentPosition();
                                AutoPlayVideoView.this.atM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.bkP.isPlaying() && AutoPlayVideoView.this.bkR.bgl() && AutoPlayVideoView.this.fzr != null) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() > AutoPlayVideoView.this.fzo) {
                                AutoPlayVideoView.this.dLL.setVisibility(8);
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
                        if (AutoPlayVideoView.this.fzs == null) {
                            AutoPlayVideoView.this.fzs = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fzs.setDataSource(AutoPlayVideoView.this.bkR.hP(AutoPlayVideoView.this.bkR.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fzr != null) {
                            AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzo);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fzp, AutoPlayVideoView.this.fzq);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fzd;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atM();
                AutoPlayVideoView.this.fzo = 0L;
                if (AutoPlayVideoView.this.dIB) {
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fzl.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fzl.setVisibility(8);
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
        this.fzt = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fzd != null && AutoPlayVideoView.this.bkP != null) {
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
        this.fze = -1;
        this.dIB = false;
        this.fzk = false;
        this.mOnClickListener = null;
        this.fzn = 0L;
        this.fzo = 0L;
        this.mDuration = 0L;
        this.fzp = 1.0f;
        this.fzq = 1.0f;
        this.fzr = null;
        this.fzs = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fze != 1) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fzn = AutoPlayVideoView.this.fzo;
                            AutoPlayVideoView.this.dLR.setVisibility(8);
                            if (!AutoPlayVideoView.this.bkR.bgl() || AutoPlayVideoView.this.fzr == null) {
                                AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzo);
                                AutoPlayVideoView.this.dLL.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bkP.getDuration();
                            AutoPlayVideoView.this.fze = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dIB) {
                                AutoPlayVideoView.this.fzi.setVisibility(0);
                                AutoPlayVideoView.this.fzi.o(AutoPlayVideoView.this.fzo, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fzi.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fzg.lT();
                            AutoPlayVideoView.this.fzg.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dIB) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bkP.getDuration() - AutoPlayVideoView.this.bkP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fzh.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fze == 1) {
                            if (AutoPlayVideoView.this.fzn == AutoPlayVideoView.this.bkP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fzn = AutoPlayVideoView.this.bkP.getCurrentPosition();
                                AutoPlayVideoView.this.atM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.bkP.isPlaying() && AutoPlayVideoView.this.bkR.bgl() && AutoPlayVideoView.this.fzr != null) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() > AutoPlayVideoView.this.fzo) {
                                AutoPlayVideoView.this.dLL.setVisibility(8);
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
                        if (AutoPlayVideoView.this.fzs == null) {
                            AutoPlayVideoView.this.fzs = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fzs.setDataSource(AutoPlayVideoView.this.bkR.hP(AutoPlayVideoView.this.bkR.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fzr != null) {
                            AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzo);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fzp, AutoPlayVideoView.this.fzq);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fzd;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atM();
                AutoPlayVideoView.this.fzo = 0L;
                if (AutoPlayVideoView.this.dIB) {
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fzl.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fzl.setVisibility(8);
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
        this.fzt = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fzd != null && AutoPlayVideoView.this.bkP != null) {
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
        this.fze = -1;
        this.dIB = false;
        this.fzk = false;
        this.mOnClickListener = null;
        this.fzn = 0L;
        this.fzo = 0L;
        this.mDuration = 0L;
        this.fzp = 1.0f;
        this.fzq = 1.0f;
        this.fzr = null;
        this.fzs = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fze != 1) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fzn = AutoPlayVideoView.this.fzo;
                            AutoPlayVideoView.this.dLR.setVisibility(8);
                            if (!AutoPlayVideoView.this.bkR.bgl() || AutoPlayVideoView.this.fzr == null) {
                                AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzo);
                                AutoPlayVideoView.this.dLL.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bkP.getDuration();
                            AutoPlayVideoView.this.fze = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dIB) {
                                AutoPlayVideoView.this.fzi.setVisibility(0);
                                AutoPlayVideoView.this.fzi.o(AutoPlayVideoView.this.fzo, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fzi.bcK();
                                return;
                            }
                            AutoPlayVideoView.this.fzg.lT();
                            AutoPlayVideoView.this.fzg.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dIB) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bkP.getDuration() - AutoPlayVideoView.this.bkP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fzh.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fze == 1) {
                            if (AutoPlayVideoView.this.fzn == AutoPlayVideoView.this.bkP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fzn = AutoPlayVideoView.this.bkP.getCurrentPosition();
                                AutoPlayVideoView.this.atM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.bkP.isPlaying() && AutoPlayVideoView.this.bkR.bgl() && AutoPlayVideoView.this.fzr != null) {
                            if (AutoPlayVideoView.this.bkP.getCurrentPosition() > AutoPlayVideoView.this.fzo) {
                                AutoPlayVideoView.this.dLL.setVisibility(8);
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
                        if (AutoPlayVideoView.this.fzs == null) {
                            AutoPlayVideoView.this.fzs = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fzs.setDataSource(AutoPlayVideoView.this.bkR.hP(AutoPlayVideoView.this.bkR.bgk()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fzr != null) {
                            AutoPlayVideoView.this.bkP.seekTo((int) AutoPlayVideoView.this.fzo);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fzp, AutoPlayVideoView.this.fzq);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fzd;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.atM();
                AutoPlayVideoView.this.fzo = 0L;
                if (AutoPlayVideoView.this.dIB) {
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fzl.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fzl.setVisibility(8);
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
        this.fzt = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fzd != null && AutoPlayVideoView.this.bkP != null) {
                    AutoPlayVideoView.this.bcJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.auto_play_video_view, (ViewGroup) this, true);
        this.fzb = this.mRootView.findViewById(d.g.content_wrapper);
        this.boT = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.dLL = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.dLR = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.fzf = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.bkP = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.bkR = new n(this.mContext);
        this.bkP.setBusiness(this.bkR);
        this.fzg = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.fzh = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.fzi = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.fzj = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.fzj.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.fzl = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.fzm = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bcI() {
        return q.bcI();
    }

    public void bcJ() {
        if (bcI()) {
            this.bkP.setVideoPath(this.fzd.video_url, this.aNu);
            this.bkP.start();
            this.fze = 0;
            if (!this.bkR.bgl() || this.fzr == null) {
                showLoading();
            }
            this.fzl.setVisibility(8);
            kO(this.dIB);
            return;
        }
        atM();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fzd = videoInfo;
        this.aNu = str;
        this.dLL.setDefaultErrorResource(0);
        this.dLL.setDefaultResource(0);
        this.dLL.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dLL.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dLL.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnErrorListener(this.aZp);
        if (this.aZn != null) {
            this.bkP.setOnCompletionListener(this.aZn);
        }
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        this.fzg.setCertainColumnCount(4);
        this.fzg.setColumnColor(d.C0126d.cp_cont_i);
        this.fzj.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzm.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.e(getContext(), d.e.ds120);
        }
        layoutParams.height = af;
        this.fzm.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dLL.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.dLL.setLayoutParams(layoutParams2);
        this.dLL.setOnClickListener(this.mOnClickListener);
        this.fzm.setOnClickListener(this.mOnClickListener);
        this.fzl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (AutoPlayVideoView.this.dIB) {
                    AutoPlayVideoView.this.fzc.dismiss();
                    AutoPlayVideoView.this.dLL.setForegroundDrawable(d.f.icon_play_video);
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
        this.fzi.destroy();
        e.fw().removeCallbacks(this.fzt);
        if (this.bkP.isPlaying()) {
            this.fzn = this.bkP.getCurrentPosition();
            if (this.bkR.bgl() && this.fzs != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fzs.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fzn), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fzd.video_width.intValue() / frameAtTime.getWidth(), this.fzd.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fzr;
                                    this.fzr = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.dLL.setImageBitmap(this.fzr);
                                    this.dLL.setForegroundDrawable(0);
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
                                this.fze = 3;
                                this.dLL.setVisibility(0);
                                this.bkP.stopPlayback();
                                this.fzg.lT();
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
        this.fze = 3;
        this.dLL.setVisibility(0);
        this.bkP.stopPlayback();
        this.fzg.lT();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ak.h(this.fzh, d.C0126d.cp_cont_i);
            ak.c(this.fzj, d.C0126d.cp_cont_g, 1);
            ak.d(this.fzj, d.f.btn_video, 1);
            this.fzg.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fze;
    }

    public long getCurrentPosition() {
        return this.fzn;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.aZn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.dLR.setVisibility(0);
        this.dLL.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atM() {
        this.dLR.setVisibility(8);
        this.dLL.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fzp = f;
        this.fzq = f2;
    }

    public long getDuration() {
        if (this.bkP == null) {
            return this.fzd.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fzd.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fzo = j;
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
            this.fzf.setVisibility(8);
            this.fzi.setPlayer(this.bkP);
            return;
        }
        this.fzi.setVisibility(8);
        this.fzi.destroy();
        this.fzf.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fzb != null && this.bkP != null) {
            if (!z) {
                if (this.fzc != null) {
                    this.fzc.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            kO(true);
            if (this.fzk) {
                this.fzj.setVisibility(0);
            }
            this.dIB = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fzb.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fzb.getParent();
            viewGroup.removeAllViews();
            this.fzc = new a(bdBaseActivity.getActivity(), this.fzb, new ViewGroup.LayoutParams(-1, -1));
            this.fzc.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fzb != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.kO(false);
                        AutoPlayVideoView.this.fzj.setVisibility(8);
                        AutoPlayVideoView.this.dIB = false;
                        ((ViewGroup) AutoPlayVideoView.this.fzb.getParent()).removeView(AutoPlayVideoView.this.fzb);
                        viewGroup.addView(AutoPlayVideoView.this.fzb);
                        AutoPlayVideoView.this.fzb.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fzo = AutoPlayVideoView.this.fzn;
                        if (AutoPlayVideoView.this.fzl.getVisibility() != 0) {
                            AutoPlayVideoView.this.bcJ();
                        }
                        AutoPlayVideoView.this.fzl.setVisibility(8);
                    }
                }
            });
            this.fzo = this.fzn;
            bcJ();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fzk = z;
    }
}
