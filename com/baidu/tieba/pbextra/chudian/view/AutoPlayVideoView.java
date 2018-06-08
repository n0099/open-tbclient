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
import com.baidu.tbadk.core.util.ao;
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
    private View aFL;
    private String aVt;
    private g.b bhA;
    private g.a bhy;
    private g.f bhz;
    private QuickVideoView bti;
    private n btk;
    private QuickVideoView.b bts;
    private boolean dUT;
    private ForeDrawableImageView dYd;
    private View dYj;
    private View fLC;
    private a fLD;
    private VideoInfo fLE;
    private int fLF;
    private RelativeLayout fLG;
    private AudioAnimationView fLH;
    private TextView fLI;
    private PbChudianProcessBar fLJ;
    private TextView fLK;
    private boolean fLL;
    private View fLM;
    private View fLN;
    private long fLO;
    private long fLP;
    private float fLQ;
    private float fLR;
    private Bitmap fLS;
    private MediaMetadataRetriever fLT;
    private Runnable fLU;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fLF = -1;
        this.dUT = false;
        this.fLL = false;
        this.mOnClickListener = null;
        this.fLO = 0L;
        this.fLP = 0L;
        this.mDuration = 0L;
        this.fLQ = 1.0f;
        this.fLR = 1.0f;
        this.fLS = null;
        this.fLT = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fLF != 1) {
                            if (AutoPlayVideoView.this.bti.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fLO = AutoPlayVideoView.this.fLP;
                            AutoPlayVideoView.this.dYj.setVisibility(8);
                            if (!AutoPlayVideoView.this.btk.blj() || AutoPlayVideoView.this.fLS == null) {
                                AutoPlayVideoView.this.bti.seekTo((int) AutoPlayVideoView.this.fLP);
                                AutoPlayVideoView.this.dYd.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bti.getDuration();
                            AutoPlayVideoView.this.fLF = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dUT) {
                                AutoPlayVideoView.this.fLJ.setVisibility(0);
                                AutoPlayVideoView.this.fLJ.p(AutoPlayVideoView.this.fLP, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fLJ.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.fLH.oJ();
                            AutoPlayVideoView.this.fLH.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dUT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bti.getDuration() - AutoPlayVideoView.this.bti.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fLI.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fLF == 1) {
                            if (AutoPlayVideoView.this.fLO == AutoPlayVideoView.this.bti.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fLO = AutoPlayVideoView.this.bti.getCurrentPosition();
                                AutoPlayVideoView.this.axY();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bti.isPlaying() && AutoPlayVideoView.this.btk.blj() && AutoPlayVideoView.this.fLS != null) {
                            if (AutoPlayVideoView.this.bti.getCurrentPosition() > AutoPlayVideoView.this.fLP) {
                                AutoPlayVideoView.this.dYd.setVisibility(8);
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
        this.bhz = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bti != null && AutoPlayVideoView.this.btk.blj()) {
                        if (AutoPlayVideoView.this.fLT == null) {
                            AutoPlayVideoView.this.fLT = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fLT.setDataSource(AutoPlayVideoView.this.btk.ip(AutoPlayVideoView.this.btk.bli()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fLS != null) {
                            AutoPlayVideoView.this.bti.seekTo((int) AutoPlayVideoView.this.fLP);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fLQ, AutoPlayVideoView.this.fLR);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fLE;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.axY();
                AutoPlayVideoView.this.fLP = 0L;
                if (AutoPlayVideoView.this.dUT) {
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fLM.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fLM.setVisibility(8);
                }
                return true;
            }
        };
        this.bhy = null;
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fLU = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fLE != null && AutoPlayVideoView.this.bti != null) {
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
        this.fLF = -1;
        this.dUT = false;
        this.fLL = false;
        this.mOnClickListener = null;
        this.fLO = 0L;
        this.fLP = 0L;
        this.mDuration = 0L;
        this.fLQ = 1.0f;
        this.fLR = 1.0f;
        this.fLS = null;
        this.fLT = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fLF != 1) {
                            if (AutoPlayVideoView.this.bti.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fLO = AutoPlayVideoView.this.fLP;
                            AutoPlayVideoView.this.dYj.setVisibility(8);
                            if (!AutoPlayVideoView.this.btk.blj() || AutoPlayVideoView.this.fLS == null) {
                                AutoPlayVideoView.this.bti.seekTo((int) AutoPlayVideoView.this.fLP);
                                AutoPlayVideoView.this.dYd.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bti.getDuration();
                            AutoPlayVideoView.this.fLF = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dUT) {
                                AutoPlayVideoView.this.fLJ.setVisibility(0);
                                AutoPlayVideoView.this.fLJ.p(AutoPlayVideoView.this.fLP, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fLJ.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.fLH.oJ();
                            AutoPlayVideoView.this.fLH.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dUT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bti.getDuration() - AutoPlayVideoView.this.bti.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fLI.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fLF == 1) {
                            if (AutoPlayVideoView.this.fLO == AutoPlayVideoView.this.bti.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fLO = AutoPlayVideoView.this.bti.getCurrentPosition();
                                AutoPlayVideoView.this.axY();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bti.isPlaying() && AutoPlayVideoView.this.btk.blj() && AutoPlayVideoView.this.fLS != null) {
                            if (AutoPlayVideoView.this.bti.getCurrentPosition() > AutoPlayVideoView.this.fLP) {
                                AutoPlayVideoView.this.dYd.setVisibility(8);
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
        this.bhz = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bti != null && AutoPlayVideoView.this.btk.blj()) {
                        if (AutoPlayVideoView.this.fLT == null) {
                            AutoPlayVideoView.this.fLT = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fLT.setDataSource(AutoPlayVideoView.this.btk.ip(AutoPlayVideoView.this.btk.bli()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fLS != null) {
                            AutoPlayVideoView.this.bti.seekTo((int) AutoPlayVideoView.this.fLP);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fLQ, AutoPlayVideoView.this.fLR);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fLE;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.axY();
                AutoPlayVideoView.this.fLP = 0L;
                if (AutoPlayVideoView.this.dUT) {
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fLM.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fLM.setVisibility(8);
                }
                return true;
            }
        };
        this.bhy = null;
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fLU = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fLE != null && AutoPlayVideoView.this.bti != null) {
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
        this.fLF = -1;
        this.dUT = false;
        this.fLL = false;
        this.mOnClickListener = null;
        this.fLO = 0L;
        this.fLP = 0L;
        this.mDuration = 0L;
        this.fLQ = 1.0f;
        this.fLR = 1.0f;
        this.fLS = null;
        this.fLT = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fLF != 1) {
                            if (AutoPlayVideoView.this.bti.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fLO = AutoPlayVideoView.this.fLP;
                            AutoPlayVideoView.this.dYj.setVisibility(8);
                            if (!AutoPlayVideoView.this.btk.blj() || AutoPlayVideoView.this.fLS == null) {
                                AutoPlayVideoView.this.bti.seekTo((int) AutoPlayVideoView.this.fLP);
                                AutoPlayVideoView.this.dYd.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bti.getDuration();
                            AutoPlayVideoView.this.fLF = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dUT) {
                                AutoPlayVideoView.this.fLJ.setVisibility(0);
                                AutoPlayVideoView.this.fLJ.p(AutoPlayVideoView.this.fLP, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fLJ.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.fLH.oJ();
                            AutoPlayVideoView.this.fLH.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dUT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bti.getDuration() - AutoPlayVideoView.this.bti.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fLI.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fLF == 1) {
                            if (AutoPlayVideoView.this.fLO == AutoPlayVideoView.this.bti.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fLO = AutoPlayVideoView.this.bti.getCurrentPosition();
                                AutoPlayVideoView.this.axY();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bti.isPlaying() && AutoPlayVideoView.this.btk.blj() && AutoPlayVideoView.this.fLS != null) {
                            if (AutoPlayVideoView.this.bti.getCurrentPosition() > AutoPlayVideoView.this.fLP) {
                                AutoPlayVideoView.this.dYd.setVisibility(8);
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
        this.bhz = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bti != null && AutoPlayVideoView.this.btk.blj()) {
                        if (AutoPlayVideoView.this.fLT == null) {
                            AutoPlayVideoView.this.fLT = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fLT.setDataSource(AutoPlayVideoView.this.btk.ip(AutoPlayVideoView.this.btk.bli()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fLS != null) {
                            AutoPlayVideoView.this.bti.seekTo((int) AutoPlayVideoView.this.fLP);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fLQ, AutoPlayVideoView.this.fLR);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fLE;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.axY();
                AutoPlayVideoView.this.fLP = 0L;
                if (AutoPlayVideoView.this.dUT) {
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fLM.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fLM.setVisibility(8);
                }
                return true;
            }
        };
        this.bhy = null;
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fLU = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fLE != null && AutoPlayVideoView.this.bti != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.auto_play_video_view, (ViewGroup) this, true);
        this.fLC = this.mRootView.findViewById(d.g.content_wrapper);
        this.aFL = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.dYd = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.dYj = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.fLG = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.bti = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.btk = new n(this.mContext);
        this.bti.setBusiness(this.btk);
        this.fLH = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.fLI = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.fLJ = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.fLK = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.fLK.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.fLM = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.fLN = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bhI() {
        return q.bhI();
    }

    public void bhJ() {
        if (bhI()) {
            this.bti.setVideoPath(this.fLE.video_url, this.aVt);
            this.bti.start();
            this.fLF = 0;
            if (!this.btk.blj() || this.fLS == null) {
                showLoading();
            }
            this.fLM.setVisibility(8);
            kV(this.dUT);
            return;
        }
        axY();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fLE = videoInfo;
        this.aVt = str;
        this.dYd.setDefaultErrorResource(0);
        this.dYd.setDefaultResource(0);
        this.dYd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dYd.setForegroundDrawable(d.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.dYd.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bti.setOnPreparedListener(this.bhz);
        this.bti.setOnErrorListener(this.bhA);
        if (this.bhy != null) {
            this.bti.setOnCompletionListener(this.bhy);
        }
        this.bti.setOnSurfaceDestroyedListener(this.bts);
        this.fLH.setCertainColumnCount(4);
        this.fLH.setColumnColor(d.C0141d.cp_cont_i);
        this.fLK.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLN.getLayoutParams();
        int ah = l.ah(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            ah = ((ah * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.e(getContext(), d.e.ds120);
        }
        layoutParams.height = ah;
        this.fLN.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dYd.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = ah;
        }
        this.dYd.setLayoutParams(layoutParams2);
        this.dYd.setOnClickListener(this.mOnClickListener);
        this.fLN.setOnClickListener(this.mOnClickListener);
        this.fLM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.dUT) {
                    AutoPlayVideoView.this.fLD.dismiss();
                    AutoPlayVideoView.this.dYd.setForegroundDrawable(d.f.icon_play_video);
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
        this.fLJ.destroy();
        e.im().removeCallbacks(this.fLU);
        if (this.bti.isPlaying()) {
            this.fLO = this.bti.getCurrentPosition();
            if (this.btk.blj() && this.fLT != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fLT.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fLO), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fLE.video_width.intValue() / frameAtTime.getWidth(), this.fLE.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fLS;
                                    this.fLS = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.dYd.setImageBitmap(this.fLS);
                                    this.dYd.setForegroundDrawable(0);
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
                                this.fLF = 3;
                                this.dYd.setVisibility(0);
                                this.bti.stopPlayback();
                                this.fLH.oJ();
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
        this.fLF = 3;
        this.dYd.setVisibility(0);
        this.bti.stopPlayback();
        this.fLH.oJ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.fLI, d.C0141d.cp_cont_i);
            al.c(this.fLK, d.C0141d.cp_cont_g, 1);
            al.d(this.fLK, d.f.btn_video, 1);
            this.fLH.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fLF;
    }

    public long getCurrentPosition() {
        return this.fLO;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bhy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.dYj.setVisibility(0);
        this.dYd.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axY() {
        this.dYj.setVisibility(8);
        this.dYd.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fLQ = f;
        this.fLR = f2;
    }

    public long getDuration() {
        if (this.bti == null) {
            return this.fLE.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fLE.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fLP = j;
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
    public void kV(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.fLG.setVisibility(8);
            this.fLJ.setPlayer(this.bti);
            return;
        }
        this.fLJ.setVisibility(8);
        this.fLJ.destroy();
        this.fLG.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fLC != null && this.bti != null) {
            if (!z) {
                if (this.fLD != null) {
                    this.fLD.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            kV(true);
            if (this.fLL) {
                this.fLK.setVisibility(0);
            }
            this.dUT = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLC.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fLC.getParent();
            viewGroup.removeAllViews();
            this.fLD = new a(bdBaseActivity.getActivity(), this.fLC, new ViewGroup.LayoutParams(-1, -1));
            this.fLD.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fLC != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.kV(false);
                        AutoPlayVideoView.this.fLK.setVisibility(8);
                        AutoPlayVideoView.this.dUT = false;
                        ((ViewGroup) AutoPlayVideoView.this.fLC.getParent()).removeView(AutoPlayVideoView.this.fLC);
                        viewGroup.addView(AutoPlayVideoView.this.fLC);
                        AutoPlayVideoView.this.fLC.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fLP = AutoPlayVideoView.this.fLO;
                        if (AutoPlayVideoView.this.fLM.getVisibility() != 0) {
                            AutoPlayVideoView.this.bhJ();
                        }
                        AutoPlayVideoView.this.fLM.setVisibility(8);
                    }
                }
            });
            this.fLP = this.fLO;
            bhJ();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fLL = z;
    }
}
