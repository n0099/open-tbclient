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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.BaseAutoPlayVideoView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean SE;
    private String bVL;
    private QuickVideoView.b cIB;
    private g.b cIx;
    private g.a cRR;
    private g.f cRS;
    private QuickVideoView dlL;
    private n dlN;
    private ForeDrawableImageView gnT;
    private View gnZ;
    private View hYG;
    private a hYH;
    private VideoInfo hYI;
    private int hYJ;
    private RelativeLayout hYK;
    private AudioAnimationView hYL;
    private TextView hYM;
    private PbChudianProcessBar hYN;
    private TextView hYO;
    private boolean hYP;
    private View hYQ;
    private View hYR;
    private long hYS;
    private long hYT;
    private float hYU;
    private float hYV;
    private Bitmap hYW;
    private MediaMetadataRetriever hYX;
    private Runnable hYY;
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
        this.hYJ = -1;
        this.SE = false;
        this.hYP = false;
        this.mOnClickListener = null;
        this.hYS = 0L;
        this.hYT = 0L;
        this.mDuration = 0L;
        this.hYU = 1.0f;
        this.hYV = 1.0f;
        this.hYW = null;
        this.hYX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYJ != 1) {
                            if (AutoPlayVideoView.this.dlL.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYS = AutoPlayVideoView.this.hYT;
                            AutoPlayVideoView.this.gnZ.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlN.caZ() || AutoPlayVideoView.this.hYW == null) {
                                AutoPlayVideoView.this.dlL.seekTo((int) AutoPlayVideoView.this.hYT);
                                AutoPlayVideoView.this.gnT.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlL.getDuration();
                            AutoPlayVideoView.this.hYJ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SE) {
                                AutoPlayVideoView.this.hYN.setVisibility(0);
                                AutoPlayVideoView.this.hYN.t(AutoPlayVideoView.this.hYT, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYN.bXo();
                                return;
                            }
                            AutoPlayVideoView.this.hYL.pV();
                            AutoPlayVideoView.this.hYL.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlL.getDuration() - AutoPlayVideoView.this.dlL.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYM.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYJ == 1) {
                            if (AutoPlayVideoView.this.hYS == AutoPlayVideoView.this.dlL.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYS = AutoPlayVideoView.this.dlL.getCurrentPosition();
                                AutoPlayVideoView.this.boI();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlL.isPlaying() && AutoPlayVideoView.this.dlN.caZ() && AutoPlayVideoView.this.hYW != null) {
                            if (AutoPlayVideoView.this.dlL.getCurrentPosition() > AutoPlayVideoView.this.hYT) {
                                AutoPlayVideoView.this.gnT.setVisibility(8);
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
        this.cRS = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlL != null && AutoPlayVideoView.this.dlN.caZ()) {
                        if (AutoPlayVideoView.this.hYX == null) {
                            AutoPlayVideoView.this.hYX = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hYX.setDataSource(AutoPlayVideoView.this.dlN.rL(AutoPlayVideoView.this.dlN.caY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hYW != null) {
                            AutoPlayVideoView.this.dlL.seekTo((int) AutoPlayVideoView.this.hYT);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYU, AutoPlayVideoView.this.hYV);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYI;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boI();
                AutoPlayVideoView.this.hYT = 0L;
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYQ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYQ.setVisibility(8);
                }
                return true;
            }
        };
        this.cRR = null;
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hYY = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYI != null && AutoPlayVideoView.this.dlL != null) {
                    AutoPlayVideoView.this.bXn();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.hYJ = -1;
        this.SE = false;
        this.hYP = false;
        this.mOnClickListener = null;
        this.hYS = 0L;
        this.hYT = 0L;
        this.mDuration = 0L;
        this.hYU = 1.0f;
        this.hYV = 1.0f;
        this.hYW = null;
        this.hYX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYJ != 1) {
                            if (AutoPlayVideoView.this.dlL.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYS = AutoPlayVideoView.this.hYT;
                            AutoPlayVideoView.this.gnZ.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlN.caZ() || AutoPlayVideoView.this.hYW == null) {
                                AutoPlayVideoView.this.dlL.seekTo((int) AutoPlayVideoView.this.hYT);
                                AutoPlayVideoView.this.gnT.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlL.getDuration();
                            AutoPlayVideoView.this.hYJ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SE) {
                                AutoPlayVideoView.this.hYN.setVisibility(0);
                                AutoPlayVideoView.this.hYN.t(AutoPlayVideoView.this.hYT, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYN.bXo();
                                return;
                            }
                            AutoPlayVideoView.this.hYL.pV();
                            AutoPlayVideoView.this.hYL.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlL.getDuration() - AutoPlayVideoView.this.dlL.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYM.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYJ == 1) {
                            if (AutoPlayVideoView.this.hYS == AutoPlayVideoView.this.dlL.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYS = AutoPlayVideoView.this.dlL.getCurrentPosition();
                                AutoPlayVideoView.this.boI();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlL.isPlaying() && AutoPlayVideoView.this.dlN.caZ() && AutoPlayVideoView.this.hYW != null) {
                            if (AutoPlayVideoView.this.dlL.getCurrentPosition() > AutoPlayVideoView.this.hYT) {
                                AutoPlayVideoView.this.gnT.setVisibility(8);
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
        this.cRS = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlL != null && AutoPlayVideoView.this.dlN.caZ()) {
                        if (AutoPlayVideoView.this.hYX == null) {
                            AutoPlayVideoView.this.hYX = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hYX.setDataSource(AutoPlayVideoView.this.dlN.rL(AutoPlayVideoView.this.dlN.caY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hYW != null) {
                            AutoPlayVideoView.this.dlL.seekTo((int) AutoPlayVideoView.this.hYT);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYU, AutoPlayVideoView.this.hYV);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYI;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boI();
                AutoPlayVideoView.this.hYT = 0L;
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYQ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYQ.setVisibility(8);
                }
                return true;
            }
        };
        this.cRR = null;
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hYY = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYI != null && AutoPlayVideoView.this.dlL != null) {
                    AutoPlayVideoView.this.bXn();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hYJ = -1;
        this.SE = false;
        this.hYP = false;
        this.mOnClickListener = null;
        this.hYS = 0L;
        this.hYT = 0L;
        this.mDuration = 0L;
        this.hYU = 1.0f;
        this.hYV = 1.0f;
        this.hYW = null;
        this.hYX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYJ != 1) {
                            if (AutoPlayVideoView.this.dlL.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYS = AutoPlayVideoView.this.hYT;
                            AutoPlayVideoView.this.gnZ.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlN.caZ() || AutoPlayVideoView.this.hYW == null) {
                                AutoPlayVideoView.this.dlL.seekTo((int) AutoPlayVideoView.this.hYT);
                                AutoPlayVideoView.this.gnT.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlL.getDuration();
                            AutoPlayVideoView.this.hYJ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SE) {
                                AutoPlayVideoView.this.hYN.setVisibility(0);
                                AutoPlayVideoView.this.hYN.t(AutoPlayVideoView.this.hYT, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYN.bXo();
                                return;
                            }
                            AutoPlayVideoView.this.hYL.pV();
                            AutoPlayVideoView.this.hYL.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlL.getDuration() - AutoPlayVideoView.this.dlL.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYM.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYJ == 1) {
                            if (AutoPlayVideoView.this.hYS == AutoPlayVideoView.this.dlL.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYS = AutoPlayVideoView.this.dlL.getCurrentPosition();
                                AutoPlayVideoView.this.boI();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlL.isPlaying() && AutoPlayVideoView.this.dlN.caZ() && AutoPlayVideoView.this.hYW != null) {
                            if (AutoPlayVideoView.this.dlL.getCurrentPosition() > AutoPlayVideoView.this.hYT) {
                                AutoPlayVideoView.this.gnT.setVisibility(8);
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
        this.cRS = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlL != null && AutoPlayVideoView.this.dlN.caZ()) {
                        if (AutoPlayVideoView.this.hYX == null) {
                            AutoPlayVideoView.this.hYX = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hYX.setDataSource(AutoPlayVideoView.this.dlN.rL(AutoPlayVideoView.this.dlN.caY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hYW != null) {
                            AutoPlayVideoView.this.dlL.seekTo((int) AutoPlayVideoView.this.hYT);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYU, AutoPlayVideoView.this.hYV);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYI;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boI();
                AutoPlayVideoView.this.hYT = 0L;
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYQ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYQ.setVisibility(8);
                }
                return true;
            }
        };
        this.cRR = null;
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hYY = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYI != null && AutoPlayVideoView.this.dlL != null) {
                    AutoPlayVideoView.this.bXn();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.hYG = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gnT = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.gnZ = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.hYK = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dlL = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dlN = new n(this.mContext);
        this.dlL.setBusiness(this.dlN);
        this.hYL = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.hYM = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.hYN = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.hYO = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.hYO.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.hYQ = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.hYR = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean bXm() {
        return q.bXm();
    }

    public void bXn() {
        if (bXm()) {
            this.dlL.setVideoPath(this.hYI.video_url, this.bVL);
            this.dlL.start();
            this.hYJ = 0;
            if (!this.dlN.caZ() || this.hYW == null) {
                showLoading();
            }
            this.hYQ.setVisibility(8);
            ph(this.SE);
            return;
        }
        boI();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYI = videoInfo;
        this.bVL = str;
        this.gnT.setDefaultErrorResource(0);
        this.gnT.setDefaultResource(0);
        this.gnT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gnT.setForegroundDrawable(R.drawable.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnT.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dlL.setOnPreparedListener(this.cRS);
        this.dlL.setOnErrorListener(this.cIx);
        if (this.cRR != null) {
            this.dlL.setOnCompletionListener(this.cRR);
        }
        this.dlL.setOnSurfaceDestroyedListener(this.cIB);
        this.hYL.setCertainColumnCount(4);
        this.hYL.setColumnColor(R.color.cp_btn_a);
        this.hYO.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hYR.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.g(getContext(), R.dimen.ds120);
        }
        layoutParams.height = af;
        this.hYR.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnT.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.gnT.setLayoutParams(layoutParams2);
        this.gnT.setOnClickListener(this.mOnClickListener);
        this.hYR.setOnClickListener(this.mOnClickListener);
        this.hYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.hYH.dismiss();
                    AutoPlayVideoView.this.gnT.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.hYN.destroy();
        e.iB().removeCallbacks(this.hYY);
        if (this.dlL.isPlaying()) {
            this.hYS = this.dlL.getCurrentPosition();
            if (this.dlN.caZ() && this.hYX != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.hYX.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.hYS), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.hYI.video_width.intValue() / frameAtTime.getWidth(), this.hYI.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.hYW;
                                    this.hYW = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gnT.setImageBitmap(this.hYW);
                                    this.gnT.setForegroundDrawable(0);
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
                                this.hYJ = 3;
                                this.gnT.setVisibility(0);
                                this.dlL.stopPlayback();
                                this.hYL.pV();
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
        this.hYJ = 3;
        this.gnT.setVisibility(0);
        this.dlL.stopPlayback();
        this.hYL.pV();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.hYM, R.color.cp_btn_a);
            al.f(this.hYO, R.color.cp_cont_g, 1);
            al.g(this.hYO, R.drawable.btn_video, 1);
            this.hYL.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.hYJ;
    }

    public long getCurrentPosition() {
        return this.hYS;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cRR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.gnZ.setVisibility(0);
        this.gnT.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boI() {
        this.gnZ.setVisibility(8);
        this.gnT.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.hYU = f;
        this.hYV = f2;
    }

    public long getDuration() {
        if (this.dlL == null) {
            return this.hYI.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.hYI.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.hYT = j;
    }

    /* loaded from: classes4.dex */
    private static class a extends Dialog {
        public a(Activity activity, View view, ViewGroup.LayoutParams layoutParams) {
            super(activity);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            requestWindowFeature(1);
            com.baidu.adp.lib.g.g.a(this, activity);
            Window window = getWindow();
            window.setGravity(17);
            window.setBackgroundDrawableResource(R.drawable.alpha15_black_stroke_bg);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setAttributes(attributes);
            window.setContentView(view, layoutParams);
            window.setTitle(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.hYK.setVisibility(8);
            this.hYN.setPlayer(this.dlL);
            return;
        }
        this.hYN.setVisibility(8);
        this.hYN.destroy();
        this.hYK.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.hYG != null && this.dlL != null) {
            if (!z) {
                if (this.hYH != null) {
                    this.hYH.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            ph(true);
            if (this.hYP) {
                this.hYO.setVisibility(0);
            }
            this.SE = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hYG.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.hYG.getParent();
            viewGroup.removeAllViews();
            this.hYH = new a(bdBaseActivity.getActivity(), this.hYG, new ViewGroup.LayoutParams(-1, -1));
            this.hYH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.hYG != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.ph(false);
                        AutoPlayVideoView.this.hYO.setVisibility(8);
                        AutoPlayVideoView.this.SE = false;
                        ((ViewGroup) AutoPlayVideoView.this.hYG.getParent()).removeView(AutoPlayVideoView.this.hYG);
                        viewGroup.addView(AutoPlayVideoView.this.hYG);
                        AutoPlayVideoView.this.hYG.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.hYT = AutoPlayVideoView.this.hYS;
                        if (AutoPlayVideoView.this.hYQ.getVisibility() != 0) {
                            AutoPlayVideoView.this.bXn();
                        }
                        AutoPlayVideoView.this.hYQ.setVisibility(8);
                    }
                }
            });
            this.hYT = this.hYS;
            bXn();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.hYP = z;
    }
}
