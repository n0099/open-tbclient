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
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean bJP;
    private QuickVideoView bPb;
    private n bPd;
    private String bjm;
    private g.b bpN;
    private QuickVideoView.b bpR;
    private g.f byA;
    private g.a byz;
    private ForeDrawableImageView eGN;
    private View eGT;
    private View gqH;
    private a gqI;
    private VideoInfo gqJ;
    private int gqK;
    private RelativeLayout gqL;
    private AudioAnimationView gqM;
    private TextView gqN;
    private PbChudianProcessBar gqO;
    private TextView gqP;
    private boolean gqQ;
    private View gqR;
    private View gqS;
    private long gqT;
    private long gqU;
    private float gqV;
    private float gqW;
    private Bitmap gqX;
    private MediaMetadataRetriever gqY;
    private Runnable gqZ;
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
        this.gqK = -1;
        this.bJP = false;
        this.gqQ = false;
        this.mOnClickListener = null;
        this.gqT = 0L;
        this.gqU = 0L;
        this.mDuration = 0L;
        this.gqV = 1.0f;
        this.gqW = 1.0f;
        this.gqX = null;
        this.gqY = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gqK != 1) {
                            if (AutoPlayVideoView.this.bPb.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gqT = AutoPlayVideoView.this.gqU;
                            AutoPlayVideoView.this.eGT.setVisibility(8);
                            if (!AutoPlayVideoView.this.bPd.bsF() || AutoPlayVideoView.this.gqX == null) {
                                AutoPlayVideoView.this.bPb.seekTo((int) AutoPlayVideoView.this.gqU);
                                AutoPlayVideoView.this.eGN.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bPb.getDuration();
                            AutoPlayVideoView.this.gqK = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJP) {
                                AutoPlayVideoView.this.gqO.setVisibility(0);
                                AutoPlayVideoView.this.gqO.m(AutoPlayVideoView.this.gqU, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gqO.bpa();
                                return;
                            }
                            AutoPlayVideoView.this.gqM.pX();
                            AutoPlayVideoView.this.gqM.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJP) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bPb.getDuration() - AutoPlayVideoView.this.bPb.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gqN.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gqK == 1) {
                            if (AutoPlayVideoView.this.gqT == AutoPlayVideoView.this.bPb.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gqT = AutoPlayVideoView.this.bPb.getCurrentPosition();
                                AutoPlayVideoView.this.aHb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bPb.isPlaying() && AutoPlayVideoView.this.bPd.bsF() && AutoPlayVideoView.this.gqX != null) {
                            if (AutoPlayVideoView.this.bPb.getCurrentPosition() > AutoPlayVideoView.this.gqU) {
                                AutoPlayVideoView.this.eGN.setVisibility(8);
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
        this.byA = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bPb != null && AutoPlayVideoView.this.bPd.bsF()) {
                        if (AutoPlayVideoView.this.gqY == null) {
                            AutoPlayVideoView.this.gqY = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gqY.setDataSource(AutoPlayVideoView.this.bPd.jR(AutoPlayVideoView.this.bPd.bsE()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gqX != null) {
                            AutoPlayVideoView.this.bPb.seekTo((int) AutoPlayVideoView.this.gqU);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gqV, AutoPlayVideoView.this.gqW);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gqJ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aHb();
                AutoPlayVideoView.this.gqU = 0L;
                if (AutoPlayVideoView.this.bJP) {
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gqR.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gqR.setVisibility(8);
                }
                return true;
            }
        };
        this.byz = null;
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gqZ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gqJ != null && AutoPlayVideoView.this.bPb != null) {
                    AutoPlayVideoView.this.boZ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.gqK = -1;
        this.bJP = false;
        this.gqQ = false;
        this.mOnClickListener = null;
        this.gqT = 0L;
        this.gqU = 0L;
        this.mDuration = 0L;
        this.gqV = 1.0f;
        this.gqW = 1.0f;
        this.gqX = null;
        this.gqY = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gqK != 1) {
                            if (AutoPlayVideoView.this.bPb.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gqT = AutoPlayVideoView.this.gqU;
                            AutoPlayVideoView.this.eGT.setVisibility(8);
                            if (!AutoPlayVideoView.this.bPd.bsF() || AutoPlayVideoView.this.gqX == null) {
                                AutoPlayVideoView.this.bPb.seekTo((int) AutoPlayVideoView.this.gqU);
                                AutoPlayVideoView.this.eGN.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bPb.getDuration();
                            AutoPlayVideoView.this.gqK = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJP) {
                                AutoPlayVideoView.this.gqO.setVisibility(0);
                                AutoPlayVideoView.this.gqO.m(AutoPlayVideoView.this.gqU, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gqO.bpa();
                                return;
                            }
                            AutoPlayVideoView.this.gqM.pX();
                            AutoPlayVideoView.this.gqM.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJP) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bPb.getDuration() - AutoPlayVideoView.this.bPb.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gqN.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gqK == 1) {
                            if (AutoPlayVideoView.this.gqT == AutoPlayVideoView.this.bPb.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gqT = AutoPlayVideoView.this.bPb.getCurrentPosition();
                                AutoPlayVideoView.this.aHb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bPb.isPlaying() && AutoPlayVideoView.this.bPd.bsF() && AutoPlayVideoView.this.gqX != null) {
                            if (AutoPlayVideoView.this.bPb.getCurrentPosition() > AutoPlayVideoView.this.gqU) {
                                AutoPlayVideoView.this.eGN.setVisibility(8);
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
        this.byA = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bPb != null && AutoPlayVideoView.this.bPd.bsF()) {
                        if (AutoPlayVideoView.this.gqY == null) {
                            AutoPlayVideoView.this.gqY = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gqY.setDataSource(AutoPlayVideoView.this.bPd.jR(AutoPlayVideoView.this.bPd.bsE()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gqX != null) {
                            AutoPlayVideoView.this.bPb.seekTo((int) AutoPlayVideoView.this.gqU);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gqV, AutoPlayVideoView.this.gqW);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gqJ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aHb();
                AutoPlayVideoView.this.gqU = 0L;
                if (AutoPlayVideoView.this.bJP) {
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gqR.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gqR.setVisibility(8);
                }
                return true;
            }
        };
        this.byz = null;
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gqZ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gqJ != null && AutoPlayVideoView.this.bPb != null) {
                    AutoPlayVideoView.this.boZ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gqK = -1;
        this.bJP = false;
        this.gqQ = false;
        this.mOnClickListener = null;
        this.gqT = 0L;
        this.gqU = 0L;
        this.mDuration = 0L;
        this.gqV = 1.0f;
        this.gqW = 1.0f;
        this.gqX = null;
        this.gqY = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gqK != 1) {
                            if (AutoPlayVideoView.this.bPb.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gqT = AutoPlayVideoView.this.gqU;
                            AutoPlayVideoView.this.eGT.setVisibility(8);
                            if (!AutoPlayVideoView.this.bPd.bsF() || AutoPlayVideoView.this.gqX == null) {
                                AutoPlayVideoView.this.bPb.seekTo((int) AutoPlayVideoView.this.gqU);
                                AutoPlayVideoView.this.eGN.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bPb.getDuration();
                            AutoPlayVideoView.this.gqK = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJP) {
                                AutoPlayVideoView.this.gqO.setVisibility(0);
                                AutoPlayVideoView.this.gqO.m(AutoPlayVideoView.this.gqU, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gqO.bpa();
                                return;
                            }
                            AutoPlayVideoView.this.gqM.pX();
                            AutoPlayVideoView.this.gqM.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJP) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bPb.getDuration() - AutoPlayVideoView.this.bPb.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gqN.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gqK == 1) {
                            if (AutoPlayVideoView.this.gqT == AutoPlayVideoView.this.bPb.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gqT = AutoPlayVideoView.this.bPb.getCurrentPosition();
                                AutoPlayVideoView.this.aHb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bPb.isPlaying() && AutoPlayVideoView.this.bPd.bsF() && AutoPlayVideoView.this.gqX != null) {
                            if (AutoPlayVideoView.this.bPb.getCurrentPosition() > AutoPlayVideoView.this.gqU) {
                                AutoPlayVideoView.this.eGN.setVisibility(8);
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
        this.byA = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bPb != null && AutoPlayVideoView.this.bPd.bsF()) {
                        if (AutoPlayVideoView.this.gqY == null) {
                            AutoPlayVideoView.this.gqY = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gqY.setDataSource(AutoPlayVideoView.this.bPd.jR(AutoPlayVideoView.this.bPd.bsE()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gqX != null) {
                            AutoPlayVideoView.this.bPb.seekTo((int) AutoPlayVideoView.this.gqU);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gqV, AutoPlayVideoView.this.gqW);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gqJ;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aHb();
                AutoPlayVideoView.this.gqU = 0L;
                if (AutoPlayVideoView.this.bJP) {
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gqR.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gqR.setVisibility(8);
                }
                return true;
            }
        };
        this.byz = null;
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gqZ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gqJ != null && AutoPlayVideoView.this.bPb != null) {
                    AutoPlayVideoView.this.boZ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gqH = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.eGN = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.eGT = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.gqL = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bPb = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bPd = new n(this.mContext);
        this.bPb.setBusiness(this.bPd);
        this.gqM = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.gqN = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.gqO = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.gqP = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.gqP.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.gqR = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.gqS = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean boY() {
        return q.boY();
    }

    public void boZ() {
        if (boY()) {
            this.bPb.setVideoPath(this.gqJ.video_url, this.bjm);
            this.bPb.start();
            this.gqK = 0;
            if (!this.bPd.bsF() || this.gqX == null) {
                showLoading();
            }
            this.gqR.setVisibility(8);
            lV(this.bJP);
            return;
        }
        aHb();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gqJ = videoInfo;
        this.bjm = str;
        this.eGN.setDefaultErrorResource(0);
        this.eGN.setDefaultResource(0);
        this.eGN.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGN.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGN.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bPb.setOnPreparedListener(this.byA);
        this.bPb.setOnErrorListener(this.bpN);
        if (this.byz != null) {
            this.bPb.setOnCompletionListener(this.byz);
        }
        this.bPb.setOnSurfaceDestroyedListener(this.bpR);
        this.gqM.setCertainColumnCount(4);
        this.gqM.setColumnColor(e.d.cp_cont_i);
        this.gqP.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqS.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0210e.ds120);
        }
        layoutParams.height = aO;
        this.gqS.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eGN.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.eGN.setLayoutParams(layoutParams2);
        this.eGN.setOnClickListener(this.mOnClickListener);
        this.gqS.setOnClickListener(this.mOnClickListener);
        this.gqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bJP) {
                    AutoPlayVideoView.this.gqI.dismiss();
                    AutoPlayVideoView.this.eGN.setForegroundDrawable(e.f.icon_play_video);
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
        this.gqO.destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gqZ);
        if (this.bPb.isPlaying()) {
            this.gqT = this.bPb.getCurrentPosition();
            if (this.bPd.bsF() && this.gqY != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.gqY.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.gqT), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.gqJ.video_width.intValue() / frameAtTime.getWidth(), this.gqJ.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.gqX;
                                    this.gqX = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eGN.setImageBitmap(this.gqX);
                                    this.eGN.setForegroundDrawable(0);
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
                                this.gqK = 3;
                                this.eGN.setVisibility(0);
                                this.bPb.stopPlayback();
                                this.gqM.pX();
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
        this.gqK = 3;
        this.eGN.setVisibility(0);
        this.bPb.stopPlayback();
        this.gqM.pX();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.gqN, e.d.cp_cont_i);
            al.c(this.gqP, e.d.cp_cont_g, 1);
            al.d(this.gqP, e.f.btn_video, 1);
            this.gqM.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.gqK;
    }

    public long getCurrentPosition() {
        return this.gqT;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.byz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eGT.setVisibility(0);
        this.eGN.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHb() {
        this.eGT.setVisibility(8);
        this.eGN.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.gqV = f;
        this.gqW = f2;
    }

    public long getDuration() {
        if (this.bPb == null) {
            return this.gqJ.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.gqJ.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.gqU = j;
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
    public void lV(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.gqL.setVisibility(8);
            this.gqO.setPlayer(this.bPb);
            return;
        }
        this.gqO.setVisibility(8);
        this.gqO.destroy();
        this.gqL.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gqH != null && this.bPb != null) {
            if (!z) {
                if (this.gqI != null) {
                    this.gqI.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lV(true);
            if (this.gqQ) {
                this.gqP.setVisibility(0);
            }
            this.bJP = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqH.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gqH.getParent();
            viewGroup.removeAllViews();
            this.gqI = new a(bdBaseActivity.getActivity(), this.gqH, new ViewGroup.LayoutParams(-1, -1));
            this.gqI.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gqH != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lV(false);
                        AutoPlayVideoView.this.gqP.setVisibility(8);
                        AutoPlayVideoView.this.bJP = false;
                        ((ViewGroup) AutoPlayVideoView.this.gqH.getParent()).removeView(AutoPlayVideoView.this.gqH);
                        viewGroup.addView(AutoPlayVideoView.this.gqH);
                        AutoPlayVideoView.this.gqH.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.gqT;
                        if (AutoPlayVideoView.this.gqR.getVisibility() != 0) {
                            AutoPlayVideoView.this.boZ();
                        }
                        AutoPlayVideoView.this.gqR.setVisibility(8);
                    }
                }
            });
            this.gqU = this.gqT;
            boZ();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.gqQ = z;
    }
}
