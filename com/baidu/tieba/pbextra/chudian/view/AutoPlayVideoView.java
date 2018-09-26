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
import org.apache.http.HttpStatus;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private View aAH;
    private String aZG;
    private QuickVideoView bBg;
    private n bBi;
    private QuickVideoView.b bgC;
    private g.b bgy;
    private g.a bpx;
    private g.f bpy;
    private boolean dkW;
    private ForeDrawableImageView eng;
    private View enm;
    private View fWX;
    private a fWY;
    private VideoInfo fWZ;
    private int fXa;
    private RelativeLayout fXb;
    private AudioAnimationView fXc;
    private TextView fXd;
    private PbChudianProcessBar fXe;
    private TextView fXf;
    private boolean fXg;
    private View fXh;
    private View fXi;
    private long fXj;
    private long fXk;
    private float fXl;
    private float fXm;
    private Bitmap fXn;
    private MediaMetadataRetriever fXo;
    private Runnable fXp;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXa = -1;
        this.dkW = false;
        this.fXg = false;
        this.mOnClickListener = null;
        this.fXj = 0L;
        this.fXk = 0L;
        this.mDuration = 0L;
        this.fXl = 1.0f;
        this.fXm = 1.0f;
        this.fXn = null;
        this.fXo = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fXa != 1) {
                            if (AutoPlayVideoView.this.bBg.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fXj = AutoPlayVideoView.this.fXk;
                            AutoPlayVideoView.this.enm.setVisibility(8);
                            if (!AutoPlayVideoView.this.bBi.bmI() || AutoPlayVideoView.this.fXn == null) {
                                AutoPlayVideoView.this.bBg.seekTo((int) AutoPlayVideoView.this.fXk);
                                AutoPlayVideoView.this.eng.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bBg.getDuration();
                            AutoPlayVideoView.this.fXa = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dkW) {
                                AutoPlayVideoView.this.fXe.setVisibility(0);
                                AutoPlayVideoView.this.fXe.n(AutoPlayVideoView.this.fXk, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fXe.bjf();
                                return;
                            }
                            AutoPlayVideoView.this.fXc.pP();
                            AutoPlayVideoView.this.fXc.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dkW) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bBg.getDuration() - AutoPlayVideoView.this.bBg.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fXd.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fXa == 1) {
                            if (AutoPlayVideoView.this.fXj == AutoPlayVideoView.this.bBg.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fXj = AutoPlayVideoView.this.bBg.getCurrentPosition();
                                AutoPlayVideoView.this.aBo();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bBg.isPlaying() && AutoPlayVideoView.this.bBi.bmI() && AutoPlayVideoView.this.fXn != null) {
                            if (AutoPlayVideoView.this.bBg.getCurrentPosition() > AutoPlayVideoView.this.fXk) {
                                AutoPlayVideoView.this.eng.setVisibility(8);
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
        this.bpy = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bBg != null && AutoPlayVideoView.this.bBi.bmI()) {
                        if (AutoPlayVideoView.this.fXo == null) {
                            AutoPlayVideoView.this.fXo = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fXo.setDataSource(AutoPlayVideoView.this.bBi.iT(AutoPlayVideoView.this.bBi.bmH()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fXn != null) {
                            AutoPlayVideoView.this.bBg.seekTo((int) AutoPlayVideoView.this.fXk);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fXl, AutoPlayVideoView.this.fXm);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fWZ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aBo();
                AutoPlayVideoView.this.fXk = 0L;
                if (AutoPlayVideoView.this.dkW) {
                    AutoPlayVideoView.this.eng.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fXh.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eng.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.fXh.setVisibility(8);
                }
                return true;
            }
        };
        this.bpx = null;
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fXp = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fWZ != null && AutoPlayVideoView.this.bBg != null) {
                    AutoPlayVideoView.this.bje();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.fXa = -1;
        this.dkW = false;
        this.fXg = false;
        this.mOnClickListener = null;
        this.fXj = 0L;
        this.fXk = 0L;
        this.mDuration = 0L;
        this.fXl = 1.0f;
        this.fXm = 1.0f;
        this.fXn = null;
        this.fXo = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fXa != 1) {
                            if (AutoPlayVideoView.this.bBg.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fXj = AutoPlayVideoView.this.fXk;
                            AutoPlayVideoView.this.enm.setVisibility(8);
                            if (!AutoPlayVideoView.this.bBi.bmI() || AutoPlayVideoView.this.fXn == null) {
                                AutoPlayVideoView.this.bBg.seekTo((int) AutoPlayVideoView.this.fXk);
                                AutoPlayVideoView.this.eng.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bBg.getDuration();
                            AutoPlayVideoView.this.fXa = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dkW) {
                                AutoPlayVideoView.this.fXe.setVisibility(0);
                                AutoPlayVideoView.this.fXe.n(AutoPlayVideoView.this.fXk, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fXe.bjf();
                                return;
                            }
                            AutoPlayVideoView.this.fXc.pP();
                            AutoPlayVideoView.this.fXc.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dkW) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bBg.getDuration() - AutoPlayVideoView.this.bBg.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fXd.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fXa == 1) {
                            if (AutoPlayVideoView.this.fXj == AutoPlayVideoView.this.bBg.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fXj = AutoPlayVideoView.this.bBg.getCurrentPosition();
                                AutoPlayVideoView.this.aBo();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bBg.isPlaying() && AutoPlayVideoView.this.bBi.bmI() && AutoPlayVideoView.this.fXn != null) {
                            if (AutoPlayVideoView.this.bBg.getCurrentPosition() > AutoPlayVideoView.this.fXk) {
                                AutoPlayVideoView.this.eng.setVisibility(8);
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
        this.bpy = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bBg != null && AutoPlayVideoView.this.bBi.bmI()) {
                        if (AutoPlayVideoView.this.fXo == null) {
                            AutoPlayVideoView.this.fXo = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fXo.setDataSource(AutoPlayVideoView.this.bBi.iT(AutoPlayVideoView.this.bBi.bmH()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fXn != null) {
                            AutoPlayVideoView.this.bBg.seekTo((int) AutoPlayVideoView.this.fXk);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fXl, AutoPlayVideoView.this.fXm);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fWZ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aBo();
                AutoPlayVideoView.this.fXk = 0L;
                if (AutoPlayVideoView.this.dkW) {
                    AutoPlayVideoView.this.eng.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fXh.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eng.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.fXh.setVisibility(8);
                }
                return true;
            }
        };
        this.bpx = null;
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fXp = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fWZ != null && AutoPlayVideoView.this.bBg != null) {
                    AutoPlayVideoView.this.bje();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXa = -1;
        this.dkW = false;
        this.fXg = false;
        this.mOnClickListener = null;
        this.fXj = 0L;
        this.fXk = 0L;
        this.mDuration = 0L;
        this.fXl = 1.0f;
        this.fXm = 1.0f;
        this.fXn = null;
        this.fXo = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fXa != 1) {
                            if (AutoPlayVideoView.this.bBg.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fXj = AutoPlayVideoView.this.fXk;
                            AutoPlayVideoView.this.enm.setVisibility(8);
                            if (!AutoPlayVideoView.this.bBi.bmI() || AutoPlayVideoView.this.fXn == null) {
                                AutoPlayVideoView.this.bBg.seekTo((int) AutoPlayVideoView.this.fXk);
                                AutoPlayVideoView.this.eng.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bBg.getDuration();
                            AutoPlayVideoView.this.fXa = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dkW) {
                                AutoPlayVideoView.this.fXe.setVisibility(0);
                                AutoPlayVideoView.this.fXe.n(AutoPlayVideoView.this.fXk, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fXe.bjf();
                                return;
                            }
                            AutoPlayVideoView.this.fXc.pP();
                            AutoPlayVideoView.this.fXc.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dkW) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bBg.getDuration() - AutoPlayVideoView.this.bBg.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fXd.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fXa == 1) {
                            if (AutoPlayVideoView.this.fXj == AutoPlayVideoView.this.bBg.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fXj = AutoPlayVideoView.this.bBg.getCurrentPosition();
                                AutoPlayVideoView.this.aBo();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bBg.isPlaying() && AutoPlayVideoView.this.bBi.bmI() && AutoPlayVideoView.this.fXn != null) {
                            if (AutoPlayVideoView.this.bBg.getCurrentPosition() > AutoPlayVideoView.this.fXk) {
                                AutoPlayVideoView.this.eng.setVisibility(8);
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
        this.bpy = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bBg != null && AutoPlayVideoView.this.bBi.bmI()) {
                        if (AutoPlayVideoView.this.fXo == null) {
                            AutoPlayVideoView.this.fXo = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fXo.setDataSource(AutoPlayVideoView.this.bBi.iT(AutoPlayVideoView.this.bBi.bmH()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fXn != null) {
                            AutoPlayVideoView.this.bBg.seekTo((int) AutoPlayVideoView.this.fXk);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fXl, AutoPlayVideoView.this.fXm);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fWZ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aBo();
                AutoPlayVideoView.this.fXk = 0L;
                if (AutoPlayVideoView.this.dkW) {
                    AutoPlayVideoView.this.eng.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fXh.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eng.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.fXh.setVisibility(8);
                }
                return true;
            }
        };
        this.bpx = null;
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fXp = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fWZ != null && AutoPlayVideoView.this.bBg != null) {
                    AutoPlayVideoView.this.bje();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.fWX = this.mRootView.findViewById(e.g.content_wrapper);
        this.aAH = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.eng = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.enm = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.fXb = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bBg = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bBi = new n(this.mContext);
        this.bBg.setBusiness(this.bBi);
        this.fXc = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.fXd = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.fXe = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.fXf = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.fXf.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.fXh = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.fXi = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean bjd() {
        return q.bjd();
    }

    public void bje() {
        if (bjd()) {
            this.bBg.setVideoPath(this.fWZ.video_url, this.aZG);
            this.bBg.start();
            this.fXa = 0;
            if (!this.bBi.bmI() || this.fXn == null) {
                showLoading();
            }
            this.fXh.setVisibility(8);
            ln(this.dkW);
            return;
        }
        aBo();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fWZ = videoInfo;
        this.aZG = str;
        this.eng.setDefaultErrorResource(0);
        this.eng.setDefaultResource(0);
        this.eng.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eng.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eng.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bBg.setOnPreparedListener(this.bpy);
        this.bBg.setOnErrorListener(this.bgy);
        if (this.bpx != null) {
            this.bBg.setOnCompletionListener(this.bpx);
        }
        this.bBg.setOnSurfaceDestroyedListener(this.bgC);
        this.fXc.setCertainColumnCount(4);
        this.fXc.setColumnColor(e.d.cp_cont_i);
        this.fXf.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXi.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0141e.ds120);
        }
        layoutParams.height = aO;
        this.fXi.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eng.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.eng.setLayoutParams(layoutParams2);
        this.eng.setOnClickListener(this.mOnClickListener);
        this.fXi.setOnClickListener(this.mOnClickListener);
        this.fXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.dkW) {
                    AutoPlayVideoView.this.fWY.dismiss();
                    AutoPlayVideoView.this.eng.setForegroundDrawable(e.f.icon_play_video);
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
        this.fXe.destroy();
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fXp);
        if (this.bBg.isPlaying()) {
            this.fXj = this.bBg.getCurrentPosition();
            if (this.bBi.bmI() && this.fXo != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fXo.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fXj), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fWZ.video_width.intValue() / frameAtTime.getWidth(), this.fWZ.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fXn;
                                    this.fXn = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eng.setImageBitmap(this.fXn);
                                    this.eng.setForegroundDrawable(0);
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
                                this.fXa = 3;
                                this.eng.setVisibility(0);
                                this.bBg.stopPlayback();
                                this.fXc.pP();
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
        this.fXa = 3;
        this.eng.setVisibility(0);
        this.bBg.stopPlayback();
        this.fXc.pP();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.fXd, e.d.cp_cont_i);
            al.c(this.fXf, e.d.cp_cont_g, 1);
            al.d(this.fXf, e.f.btn_video, 1);
            this.fXc.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fXa;
    }

    public long getCurrentPosition() {
        return this.fXj;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bpx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.enm.setVisibility(0);
        this.eng.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        this.enm.setVisibility(8);
        this.eng.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fXl = f;
        this.fXm = f2;
    }

    public long getDuration() {
        if (this.bBg == null) {
            return this.fWZ.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fWZ.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fXk = j;
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
    public void ln(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.fXb.setVisibility(8);
            this.fXe.setPlayer(this.bBg);
            return;
        }
        this.fXe.setVisibility(8);
        this.fXe.destroy();
        this.fXb.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fWX != null && this.bBg != null) {
            if (!z) {
                if (this.fWY != null) {
                    this.fWY.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            ln(true);
            if (this.fXg) {
                this.fXf.setVisibility(0);
            }
            this.dkW = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWX.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fWX.getParent();
            viewGroup.removeAllViews();
            this.fWY = new a(bdBaseActivity.getActivity(), this.fWX, new ViewGroup.LayoutParams(-1, -1));
            this.fWY.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fWX != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.ln(false);
                        AutoPlayVideoView.this.fXf.setVisibility(8);
                        AutoPlayVideoView.this.dkW = false;
                        ((ViewGroup) AutoPlayVideoView.this.fWX.getParent()).removeView(AutoPlayVideoView.this.fWX);
                        viewGroup.addView(AutoPlayVideoView.this.fWX);
                        AutoPlayVideoView.this.fWX.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fXk = AutoPlayVideoView.this.fXj;
                        if (AutoPlayVideoView.this.fXh.getVisibility() != 0) {
                            AutoPlayVideoView.this.bje();
                        }
                        AutoPlayVideoView.this.fXh.setVisibility(8);
                    }
                }
            });
            this.fXk = this.fXj;
            bje();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fXg = z;
    }
}
