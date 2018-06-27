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
    private String aWo;
    private View axY;
    private g.b bcU;
    private QuickVideoView.b bcY;
    private g.a bjb;
    private g.f bjc;
    private QuickVideoView buJ;
    private n buL;
    private boolean dcn;
    private ForeDrawableImageView ebX;
    private View ecd;
    private View fPF;
    private a fPG;
    private VideoInfo fPH;
    private int fPI;
    private RelativeLayout fPJ;
    private AudioAnimationView fPK;
    private TextView fPL;
    private PbChudianProcessBar fPM;
    private TextView fPN;
    private boolean fPO;
    private View fPP;
    private View fPQ;
    private long fPR;
    private long fPS;
    private float fPT;
    private float fPU;
    private Bitmap fPV;
    private MediaMetadataRetriever fPW;
    private Runnable fPX;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fPI = -1;
        this.dcn = false;
        this.fPO = false;
        this.mOnClickListener = null;
        this.fPR = 0L;
        this.fPS = 0L;
        this.mDuration = 0L;
        this.fPT = 1.0f;
        this.fPU = 1.0f;
        this.fPV = null;
        this.fPW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPI != 1) {
                            if (AutoPlayVideoView.this.buJ.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fPR = AutoPlayVideoView.this.fPS;
                            AutoPlayVideoView.this.ecd.setVisibility(8);
                            if (!AutoPlayVideoView.this.buL.blN() || AutoPlayVideoView.this.fPV == null) {
                                AutoPlayVideoView.this.buJ.seekTo((int) AutoPlayVideoView.this.fPS);
                                AutoPlayVideoView.this.ebX.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.buJ.getDuration();
                            AutoPlayVideoView.this.fPI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dcn) {
                                AutoPlayVideoView.this.fPM.setVisibility(0);
                                AutoPlayVideoView.this.fPM.m(AutoPlayVideoView.this.fPS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPM.biq();
                                return;
                            }
                            AutoPlayVideoView.this.fPK.oJ();
                            AutoPlayVideoView.this.fPK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dcn) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.buJ.getDuration() - AutoPlayVideoView.this.buJ.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPI == 1) {
                            if (AutoPlayVideoView.this.fPR == AutoPlayVideoView.this.buJ.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fPR = AutoPlayVideoView.this.buJ.getCurrentPosition();
                                AutoPlayVideoView.this.ayD();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.buJ.isPlaying() && AutoPlayVideoView.this.buL.blN() && AutoPlayVideoView.this.fPV != null) {
                            if (AutoPlayVideoView.this.buJ.getCurrentPosition() > AutoPlayVideoView.this.fPS) {
                                AutoPlayVideoView.this.ebX.setVisibility(8);
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
        this.bjc = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.buJ != null && AutoPlayVideoView.this.buL.blN()) {
                        if (AutoPlayVideoView.this.fPW == null) {
                            AutoPlayVideoView.this.fPW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fPW.setDataSource(AutoPlayVideoView.this.buL.iu(AutoPlayVideoView.this.buL.blM()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fPV != null) {
                            AutoPlayVideoView.this.buJ.seekTo((int) AutoPlayVideoView.this.fPS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fPT, AutoPlayVideoView.this.fPU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.ayD();
                AutoPlayVideoView.this.fPS = 0L;
                if (AutoPlayVideoView.this.dcn) {
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fPP.setVisibility(8);
                }
                return true;
            }
        };
        this.bjb = null;
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fPX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPH != null && AutoPlayVideoView.this.buJ != null) {
                    AutoPlayVideoView.this.bip();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.fPI = -1;
        this.dcn = false;
        this.fPO = false;
        this.mOnClickListener = null;
        this.fPR = 0L;
        this.fPS = 0L;
        this.mDuration = 0L;
        this.fPT = 1.0f;
        this.fPU = 1.0f;
        this.fPV = null;
        this.fPW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPI != 1) {
                            if (AutoPlayVideoView.this.buJ.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fPR = AutoPlayVideoView.this.fPS;
                            AutoPlayVideoView.this.ecd.setVisibility(8);
                            if (!AutoPlayVideoView.this.buL.blN() || AutoPlayVideoView.this.fPV == null) {
                                AutoPlayVideoView.this.buJ.seekTo((int) AutoPlayVideoView.this.fPS);
                                AutoPlayVideoView.this.ebX.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.buJ.getDuration();
                            AutoPlayVideoView.this.fPI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dcn) {
                                AutoPlayVideoView.this.fPM.setVisibility(0);
                                AutoPlayVideoView.this.fPM.m(AutoPlayVideoView.this.fPS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPM.biq();
                                return;
                            }
                            AutoPlayVideoView.this.fPK.oJ();
                            AutoPlayVideoView.this.fPK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dcn) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.buJ.getDuration() - AutoPlayVideoView.this.buJ.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPI == 1) {
                            if (AutoPlayVideoView.this.fPR == AutoPlayVideoView.this.buJ.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fPR = AutoPlayVideoView.this.buJ.getCurrentPosition();
                                AutoPlayVideoView.this.ayD();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.buJ.isPlaying() && AutoPlayVideoView.this.buL.blN() && AutoPlayVideoView.this.fPV != null) {
                            if (AutoPlayVideoView.this.buJ.getCurrentPosition() > AutoPlayVideoView.this.fPS) {
                                AutoPlayVideoView.this.ebX.setVisibility(8);
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
        this.bjc = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.buJ != null && AutoPlayVideoView.this.buL.blN()) {
                        if (AutoPlayVideoView.this.fPW == null) {
                            AutoPlayVideoView.this.fPW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fPW.setDataSource(AutoPlayVideoView.this.buL.iu(AutoPlayVideoView.this.buL.blM()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fPV != null) {
                            AutoPlayVideoView.this.buJ.seekTo((int) AutoPlayVideoView.this.fPS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fPT, AutoPlayVideoView.this.fPU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.ayD();
                AutoPlayVideoView.this.fPS = 0L;
                if (AutoPlayVideoView.this.dcn) {
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fPP.setVisibility(8);
                }
                return true;
            }
        };
        this.bjb = null;
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fPX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPH != null && AutoPlayVideoView.this.buJ != null) {
                    AutoPlayVideoView.this.bip();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fPI = -1;
        this.dcn = false;
        this.fPO = false;
        this.mOnClickListener = null;
        this.fPR = 0L;
        this.fPS = 0L;
        this.mDuration = 0L;
        this.fPT = 1.0f;
        this.fPU = 1.0f;
        this.fPV = null;
        this.fPW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.fPI != 1) {
                            if (AutoPlayVideoView.this.buJ.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.fPR = AutoPlayVideoView.this.fPS;
                            AutoPlayVideoView.this.ecd.setVisibility(8);
                            if (!AutoPlayVideoView.this.buL.blN() || AutoPlayVideoView.this.fPV == null) {
                                AutoPlayVideoView.this.buJ.seekTo((int) AutoPlayVideoView.this.fPS);
                                AutoPlayVideoView.this.ebX.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.buJ.getDuration();
                            AutoPlayVideoView.this.fPI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.dcn) {
                                AutoPlayVideoView.this.fPM.setVisibility(0);
                                AutoPlayVideoView.this.fPM.m(AutoPlayVideoView.this.fPS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.fPM.biq();
                                return;
                            }
                            AutoPlayVideoView.this.fPK.oJ();
                            AutoPlayVideoView.this.fPK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.dcn) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.buJ.getDuration() - AutoPlayVideoView.this.buJ.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.fPL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.fPI == 1) {
                            if (AutoPlayVideoView.this.fPR == AutoPlayVideoView.this.buJ.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.fPR = AutoPlayVideoView.this.buJ.getCurrentPosition();
                                AutoPlayVideoView.this.ayD();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.buJ.isPlaying() && AutoPlayVideoView.this.buL.blN() && AutoPlayVideoView.this.fPV != null) {
                            if (AutoPlayVideoView.this.buJ.getCurrentPosition() > AutoPlayVideoView.this.fPS) {
                                AutoPlayVideoView.this.ebX.setVisibility(8);
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
        this.bjc = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.buJ != null && AutoPlayVideoView.this.buL.blN()) {
                        if (AutoPlayVideoView.this.fPW == null) {
                            AutoPlayVideoView.this.fPW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.fPW.setDataSource(AutoPlayVideoView.this.buL.iu(AutoPlayVideoView.this.buL.blM()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.fPV != null) {
                            AutoPlayVideoView.this.buJ.seekTo((int) AutoPlayVideoView.this.fPS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.fPT, AutoPlayVideoView.this.fPU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.fPH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.ayD();
                AutoPlayVideoView.this.fPS = 0L;
                if (AutoPlayVideoView.this.dcn) {
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(0);
                    AutoPlayVideoView.this.fPP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.k.pb_play_error);
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.fPP.setVisibility(8);
                }
                return true;
            }
        };
        this.bjb = null;
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.fPX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.fPH != null && AutoPlayVideoView.this.buJ != null) {
                    AutoPlayVideoView.this.bip();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.i.auto_play_video_view, (ViewGroup) this, true);
        this.fPF = this.mRootView.findViewById(d.g.content_wrapper);
        this.axY = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.ebX = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.ecd = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.fPJ = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.buJ = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.buL = new n(this.mContext);
        this.buJ.setBusiness(this.buL);
        this.fPK = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.fPL = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.fPM = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.fPN = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.fPN.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.fPP = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.fPQ = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bio() {
        return q.bio();
    }

    public void bip() {
        if (bio()) {
            this.buJ.setVideoPath(this.fPH.video_url, this.aWo);
            this.buJ.start();
            this.fPI = 0;
            if (!this.buL.blN() || this.fPV == null) {
                showLoading();
            }
            this.fPP.setVisibility(8);
            lf(this.dcn);
            return;
        }
        ayD();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPH = videoInfo;
        this.aWo = str;
        this.ebX.setDefaultErrorResource(0);
        this.ebX.setDefaultResource(0);
        this.ebX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ebX.setForegroundDrawable(d.f.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.ebX.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.buJ.setOnPreparedListener(this.bjc);
        this.buJ.setOnErrorListener(this.bcU);
        if (this.bjb != null) {
            this.buJ.setOnCompletionListener(this.bjb);
        }
        this.buJ.setOnSurfaceDestroyedListener(this.bcY);
        this.fPK.setCertainColumnCount(4);
        this.fPK.setColumnColor(d.C0142d.cp_cont_i);
        this.fPN.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPQ.getLayoutParams();
        int ah = l.ah(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            ah = ((ah * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.e(getContext(), d.e.ds120);
        }
        layoutParams.height = ah;
        this.fPQ.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ebX.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = ah;
        }
        this.ebX.setLayoutParams(layoutParams2);
        this.ebX.setOnClickListener(this.mOnClickListener);
        this.fPQ.setOnClickListener(this.mOnClickListener);
        this.fPP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.dcn) {
                    AutoPlayVideoView.this.fPG.dismiss();
                    AutoPlayVideoView.this.ebX.setForegroundDrawable(d.f.icon_play_video);
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
        this.fPM.destroy();
        e.im().removeCallbacks(this.fPX);
        if (this.buJ.isPlaying()) {
            this.fPR = this.buJ.getCurrentPosition();
            if (this.buL.blN() && this.fPW != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.fPW.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.fPR), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.fPH.video_width.intValue() / frameAtTime.getWidth(), this.fPH.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.fPV;
                                    this.fPV = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.ebX.setImageBitmap(this.fPV);
                                    this.ebX.setForegroundDrawable(0);
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
                                this.fPI = 3;
                                this.ebX.setVisibility(0);
                                this.buJ.stopPlayback();
                                this.fPK.oJ();
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
        this.fPI = 3;
        this.ebX.setVisibility(0);
        this.buJ.stopPlayback();
        this.fPK.oJ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.h(this.fPL, d.C0142d.cp_cont_i);
            am.c(this.fPN, d.C0142d.cp_cont_g, 1);
            am.d(this.fPN, d.f.btn_video, 1);
            this.fPK.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.fPI;
    }

    public long getCurrentPosition() {
        return this.fPR;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bjb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.ecd.setVisibility(0);
        this.ebX.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayD() {
        this.ecd.setVisibility(8);
        this.ebX.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.fPT = f;
        this.fPU = f2;
    }

    public long getDuration() {
        if (this.buJ == null) {
            return this.fPH.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.fPH.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.fPS = j;
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
    public void lf(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.fPJ.setVisibility(8);
            this.fPM.setPlayer(this.buJ);
            return;
        }
        this.fPM.setVisibility(8);
        this.fPM.destroy();
        this.fPJ.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.fPF != null && this.buJ != null) {
            if (!z) {
                if (this.fPG != null) {
                    this.fPG.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lf(true);
            if (this.fPO) {
                this.fPN.setVisibility(0);
            }
            this.dcn = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fPF.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.fPF.getParent();
            viewGroup.removeAllViews();
            this.fPG = new a(bdBaseActivity.getActivity(), this.fPF, new ViewGroup.LayoutParams(-1, -1));
            this.fPG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.fPF != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lf(false);
                        AutoPlayVideoView.this.fPN.setVisibility(8);
                        AutoPlayVideoView.this.dcn = false;
                        ((ViewGroup) AutoPlayVideoView.this.fPF.getParent()).removeView(AutoPlayVideoView.this.fPF);
                        viewGroup.addView(AutoPlayVideoView.this.fPF);
                        AutoPlayVideoView.this.fPF.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.fPS = AutoPlayVideoView.this.fPR;
                        if (AutoPlayVideoView.this.fPP.getVisibility() != 0) {
                            AutoPlayVideoView.this.bip();
                        }
                        AutoPlayVideoView.this.fPP.setVisibility(8);
                    }
                }
            });
            this.fPS = this.fPR;
            bip();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.fPO = z;
    }
}
