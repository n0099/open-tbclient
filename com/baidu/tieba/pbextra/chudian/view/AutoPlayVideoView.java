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
    private boolean bJQ;
    private QuickVideoView bPc;
    private n bPe;
    private String bjn;
    private g.b bpO;
    private QuickVideoView.b bpS;
    private g.a byA;
    private g.f byB;
    private ForeDrawableImageView eGO;
    private View eGU;
    private View gqI;
    private a gqJ;
    private VideoInfo gqK;
    private int gqL;
    private RelativeLayout gqM;
    private AudioAnimationView gqN;
    private TextView gqO;
    private PbChudianProcessBar gqP;
    private TextView gqQ;
    private boolean gqR;
    private View gqS;
    private View gqT;
    private long gqU;
    private long gqV;
    private float gqW;
    private float gqX;
    private Bitmap gqY;
    private MediaMetadataRetriever gqZ;
    private Runnable gra;
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
        this.gqL = -1;
        this.bJQ = false;
        this.gqR = false;
        this.mOnClickListener = null;
        this.gqU = 0L;
        this.gqV = 0L;
        this.mDuration = 0L;
        this.gqW = 1.0f;
        this.gqX = 1.0f;
        this.gqY = null;
        this.gqZ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gqL != 1) {
                            if (AutoPlayVideoView.this.bPc.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.gqV;
                            AutoPlayVideoView.this.eGU.setVisibility(8);
                            if (!AutoPlayVideoView.this.bPe.bsF() || AutoPlayVideoView.this.gqY == null) {
                                AutoPlayVideoView.this.bPc.seekTo((int) AutoPlayVideoView.this.gqV);
                                AutoPlayVideoView.this.eGO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bPc.getDuration();
                            AutoPlayVideoView.this.gqL = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJQ) {
                                AutoPlayVideoView.this.gqP.setVisibility(0);
                                AutoPlayVideoView.this.gqP.m(AutoPlayVideoView.this.gqV, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gqP.bpa();
                                return;
                            }
                            AutoPlayVideoView.this.gqN.pX();
                            AutoPlayVideoView.this.gqN.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJQ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bPc.getDuration() - AutoPlayVideoView.this.bPc.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gqO.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gqL == 1) {
                            if (AutoPlayVideoView.this.gqU == AutoPlayVideoView.this.bPc.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.bPc.getCurrentPosition();
                                AutoPlayVideoView.this.aHb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bPc.isPlaying() && AutoPlayVideoView.this.bPe.bsF() && AutoPlayVideoView.this.gqY != null) {
                            if (AutoPlayVideoView.this.bPc.getCurrentPosition() > AutoPlayVideoView.this.gqV) {
                                AutoPlayVideoView.this.eGO.setVisibility(8);
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
        this.byB = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bPc != null && AutoPlayVideoView.this.bPe.bsF()) {
                        if (AutoPlayVideoView.this.gqZ == null) {
                            AutoPlayVideoView.this.gqZ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gqZ.setDataSource(AutoPlayVideoView.this.bPe.jR(AutoPlayVideoView.this.bPe.bsE()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gqY != null) {
                            AutoPlayVideoView.this.bPc.seekTo((int) AutoPlayVideoView.this.gqV);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gqW, AutoPlayVideoView.this.gqX);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gqK;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aHb();
                AutoPlayVideoView.this.gqV = 0L;
                if (AutoPlayVideoView.this.bJQ) {
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gqS.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gqS.setVisibility(8);
                }
                return true;
            }
        };
        this.byA = null;
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gra = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gqK != null && AutoPlayVideoView.this.bPc != null) {
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
        this.gqL = -1;
        this.bJQ = false;
        this.gqR = false;
        this.mOnClickListener = null;
        this.gqU = 0L;
        this.gqV = 0L;
        this.mDuration = 0L;
        this.gqW = 1.0f;
        this.gqX = 1.0f;
        this.gqY = null;
        this.gqZ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gqL != 1) {
                            if (AutoPlayVideoView.this.bPc.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.gqV;
                            AutoPlayVideoView.this.eGU.setVisibility(8);
                            if (!AutoPlayVideoView.this.bPe.bsF() || AutoPlayVideoView.this.gqY == null) {
                                AutoPlayVideoView.this.bPc.seekTo((int) AutoPlayVideoView.this.gqV);
                                AutoPlayVideoView.this.eGO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bPc.getDuration();
                            AutoPlayVideoView.this.gqL = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJQ) {
                                AutoPlayVideoView.this.gqP.setVisibility(0);
                                AutoPlayVideoView.this.gqP.m(AutoPlayVideoView.this.gqV, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gqP.bpa();
                                return;
                            }
                            AutoPlayVideoView.this.gqN.pX();
                            AutoPlayVideoView.this.gqN.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJQ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bPc.getDuration() - AutoPlayVideoView.this.bPc.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gqO.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gqL == 1) {
                            if (AutoPlayVideoView.this.gqU == AutoPlayVideoView.this.bPc.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.bPc.getCurrentPosition();
                                AutoPlayVideoView.this.aHb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bPc.isPlaying() && AutoPlayVideoView.this.bPe.bsF() && AutoPlayVideoView.this.gqY != null) {
                            if (AutoPlayVideoView.this.bPc.getCurrentPosition() > AutoPlayVideoView.this.gqV) {
                                AutoPlayVideoView.this.eGO.setVisibility(8);
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
        this.byB = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bPc != null && AutoPlayVideoView.this.bPe.bsF()) {
                        if (AutoPlayVideoView.this.gqZ == null) {
                            AutoPlayVideoView.this.gqZ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gqZ.setDataSource(AutoPlayVideoView.this.bPe.jR(AutoPlayVideoView.this.bPe.bsE()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gqY != null) {
                            AutoPlayVideoView.this.bPc.seekTo((int) AutoPlayVideoView.this.gqV);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gqW, AutoPlayVideoView.this.gqX);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gqK;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aHb();
                AutoPlayVideoView.this.gqV = 0L;
                if (AutoPlayVideoView.this.bJQ) {
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gqS.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gqS.setVisibility(8);
                }
                return true;
            }
        };
        this.byA = null;
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gra = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gqK != null && AutoPlayVideoView.this.bPc != null) {
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
        this.gqL = -1;
        this.bJQ = false;
        this.gqR = false;
        this.mOnClickListener = null;
        this.gqU = 0L;
        this.gqV = 0L;
        this.mDuration = 0L;
        this.gqW = 1.0f;
        this.gqX = 1.0f;
        this.gqY = null;
        this.gqZ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gqL != 1) {
                            if (AutoPlayVideoView.this.bPc.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.gqV;
                            AutoPlayVideoView.this.eGU.setVisibility(8);
                            if (!AutoPlayVideoView.this.bPe.bsF() || AutoPlayVideoView.this.gqY == null) {
                                AutoPlayVideoView.this.bPc.seekTo((int) AutoPlayVideoView.this.gqV);
                                AutoPlayVideoView.this.eGO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bPc.getDuration();
                            AutoPlayVideoView.this.gqL = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bJQ) {
                                AutoPlayVideoView.this.gqP.setVisibility(0);
                                AutoPlayVideoView.this.gqP.m(AutoPlayVideoView.this.gqV, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gqP.bpa();
                                return;
                            }
                            AutoPlayVideoView.this.gqN.pX();
                            AutoPlayVideoView.this.gqN.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bJQ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bPc.getDuration() - AutoPlayVideoView.this.bPc.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gqO.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gqL == 1) {
                            if (AutoPlayVideoView.this.gqU == AutoPlayVideoView.this.bPc.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gqU = AutoPlayVideoView.this.bPc.getCurrentPosition();
                                AutoPlayVideoView.this.aHb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bPc.isPlaying() && AutoPlayVideoView.this.bPe.bsF() && AutoPlayVideoView.this.gqY != null) {
                            if (AutoPlayVideoView.this.bPc.getCurrentPosition() > AutoPlayVideoView.this.gqV) {
                                AutoPlayVideoView.this.eGO.setVisibility(8);
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
        this.byB = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bPc != null && AutoPlayVideoView.this.bPe.bsF()) {
                        if (AutoPlayVideoView.this.gqZ == null) {
                            AutoPlayVideoView.this.gqZ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gqZ.setDataSource(AutoPlayVideoView.this.bPe.jR(AutoPlayVideoView.this.bPe.bsE()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gqY != null) {
                            AutoPlayVideoView.this.bPc.seekTo((int) AutoPlayVideoView.this.gqV);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gqW, AutoPlayVideoView.this.gqX);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gqK;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aHb();
                AutoPlayVideoView.this.gqV = 0L;
                if (AutoPlayVideoView.this.bJQ) {
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gqS.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gqS.setVisibility(8);
                }
                return true;
            }
        };
        this.byA = null;
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gra = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gqK != null && AutoPlayVideoView.this.bPc != null) {
                    AutoPlayVideoView.this.boZ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gqI = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.eGO = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.eGU = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.gqM = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bPc = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bPe = new n(this.mContext);
        this.bPc.setBusiness(this.bPe);
        this.gqN = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.gqO = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.gqP = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.gqQ = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.gqQ.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.gqS = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.gqT = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean boY() {
        return q.boY();
    }

    public void boZ() {
        if (boY()) {
            this.bPc.setVideoPath(this.gqK.video_url, this.bjn);
            this.bPc.start();
            this.gqL = 0;
            if (!this.bPe.bsF() || this.gqY == null) {
                showLoading();
            }
            this.gqS.setVisibility(8);
            lV(this.bJQ);
            return;
        }
        aHb();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gqK = videoInfo;
        this.bjn = str;
        this.eGO.setDefaultErrorResource(0);
        this.eGO.setDefaultResource(0);
        this.eGO.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGO.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGO.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bPc.setOnPreparedListener(this.byB);
        this.bPc.setOnErrorListener(this.bpO);
        if (this.byA != null) {
            this.bPc.setOnCompletionListener(this.byA);
        }
        this.bPc.setOnSurfaceDestroyedListener(this.bpS);
        this.gqN.setCertainColumnCount(4);
        this.gqN.setColumnColor(e.d.cp_cont_i);
        this.gqQ.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqT.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0210e.ds120);
        }
        layoutParams.height = aO;
        this.gqT.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eGO.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.eGO.setLayoutParams(layoutParams2);
        this.eGO.setOnClickListener(this.mOnClickListener);
        this.gqT.setOnClickListener(this.mOnClickListener);
        this.gqS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bJQ) {
                    AutoPlayVideoView.this.gqJ.dismiss();
                    AutoPlayVideoView.this.eGO.setForegroundDrawable(e.f.icon_play_video);
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
        this.gqP.destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gra);
        if (this.bPc.isPlaying()) {
            this.gqU = this.bPc.getCurrentPosition();
            if (this.bPe.bsF() && this.gqZ != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.gqZ.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.gqU), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.gqK.video_width.intValue() / frameAtTime.getWidth(), this.gqK.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.gqY;
                                    this.gqY = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eGO.setImageBitmap(this.gqY);
                                    this.eGO.setForegroundDrawable(0);
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
                                this.gqL = 3;
                                this.eGO.setVisibility(0);
                                this.bPc.stopPlayback();
                                this.gqN.pX();
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
        this.gqL = 3;
        this.eGO.setVisibility(0);
        this.bPc.stopPlayback();
        this.gqN.pX();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.gqO, e.d.cp_cont_i);
            al.c(this.gqQ, e.d.cp_cont_g, 1);
            al.d(this.gqQ, e.f.btn_video, 1);
            this.gqN.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.gqL;
    }

    public long getCurrentPosition() {
        return this.gqU;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.byA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eGU.setVisibility(0);
        this.eGO.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHb() {
        this.eGU.setVisibility(8);
        this.eGO.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.gqW = f;
        this.gqX = f2;
    }

    public long getDuration() {
        if (this.bPc == null) {
            return this.gqK.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.gqK.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.gqV = j;
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
            this.gqM.setVisibility(8);
            this.gqP.setPlayer(this.bPc);
            return;
        }
        this.gqP.setVisibility(8);
        this.gqP.destroy();
        this.gqM.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gqI != null && this.bPc != null) {
            if (!z) {
                if (this.gqJ != null) {
                    this.gqJ.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lV(true);
            if (this.gqR) {
                this.gqQ.setVisibility(0);
            }
            this.bJQ = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqI.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gqI.getParent();
            viewGroup.removeAllViews();
            this.gqJ = new a(bdBaseActivity.getActivity(), this.gqI, new ViewGroup.LayoutParams(-1, -1));
            this.gqJ.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gqI != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lV(false);
                        AutoPlayVideoView.this.gqQ.setVisibility(8);
                        AutoPlayVideoView.this.bJQ = false;
                        ((ViewGroup) AutoPlayVideoView.this.gqI.getParent()).removeView(AutoPlayVideoView.this.gqI);
                        viewGroup.addView(AutoPlayVideoView.this.gqI);
                        AutoPlayVideoView.this.gqI.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.gqV = AutoPlayVideoView.this.gqU;
                        if (AutoPlayVideoView.this.gqS.getVisibility() != 0) {
                            AutoPlayVideoView.this.boZ();
                        }
                        AutoPlayVideoView.this.gqS.setVisibility(8);
                    }
                }
            });
            this.gqV = this.gqU;
            boZ();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.gqR = z;
    }
}
