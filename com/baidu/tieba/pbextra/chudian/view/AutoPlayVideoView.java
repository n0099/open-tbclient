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
    private boolean SD;
    private String bVM;
    private QuickVideoView.b cIC;
    private g.b cIy;
    private g.a cRT;
    private g.f cRU;
    private QuickVideoView dlM;
    private n dlO;
    private ForeDrawableImageView gnW;
    private View goc;
    private View hYK;
    private a hYL;
    private VideoInfo hYM;
    private int hYN;
    private RelativeLayout hYO;
    private AudioAnimationView hYP;
    private TextView hYQ;
    private PbChudianProcessBar hYR;
    private TextView hYS;
    private boolean hYT;
    private View hYU;
    private View hYV;
    private long hYW;
    private long hYX;
    private float hYY;
    private float hYZ;
    private Bitmap hZa;
    private MediaMetadataRetriever hZb;
    private Runnable hZc;
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
        this.hYN = -1;
        this.SD = false;
        this.hYT = false;
        this.mOnClickListener = null;
        this.hYW = 0L;
        this.hYX = 0L;
        this.mDuration = 0L;
        this.hYY = 1.0f;
        this.hYZ = 1.0f;
        this.hZa = null;
        this.hZb = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYN != 1) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.hYX;
                            AutoPlayVideoView.this.goc.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlO.cbd() || AutoPlayVideoView.this.hZa == null) {
                                AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYX);
                                AutoPlayVideoView.this.gnW.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlM.getDuration();
                            AutoPlayVideoView.this.hYN = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SD) {
                                AutoPlayVideoView.this.hYR.setVisibility(0);
                                AutoPlayVideoView.this.hYR.t(AutoPlayVideoView.this.hYX, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYR.bXs();
                                return;
                            }
                            AutoPlayVideoView.this.hYP.pV();
                            AutoPlayVideoView.this.hYP.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SD) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlM.getDuration() - AutoPlayVideoView.this.dlM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYN == 1) {
                            if (AutoPlayVideoView.this.hYW == AutoPlayVideoView.this.dlM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.dlM.getCurrentPosition();
                                AutoPlayVideoView.this.boN();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlM.isPlaying() && AutoPlayVideoView.this.dlO.cbd() && AutoPlayVideoView.this.hZa != null) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() > AutoPlayVideoView.this.hYX) {
                                AutoPlayVideoView.this.gnW.setVisibility(8);
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
        this.cRU = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlM != null && AutoPlayVideoView.this.dlO.cbd()) {
                        if (AutoPlayVideoView.this.hZb == null) {
                            AutoPlayVideoView.this.hZb = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hZb.setDataSource(AutoPlayVideoView.this.dlO.rK(AutoPlayVideoView.this.dlO.cbc()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hZa != null) {
                            AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYX);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYY, AutoPlayVideoView.this.hYZ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYM;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boN();
                AutoPlayVideoView.this.hYX = 0L;
                if (AutoPlayVideoView.this.SD) {
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYU.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYU.setVisibility(8);
                }
                return true;
            }
        };
        this.cRT = null;
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hZc = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYM != null && AutoPlayVideoView.this.dlM != null) {
                    AutoPlayVideoView.this.bXr();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.hYN = -1;
        this.SD = false;
        this.hYT = false;
        this.mOnClickListener = null;
        this.hYW = 0L;
        this.hYX = 0L;
        this.mDuration = 0L;
        this.hYY = 1.0f;
        this.hYZ = 1.0f;
        this.hZa = null;
        this.hZb = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYN != 1) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.hYX;
                            AutoPlayVideoView.this.goc.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlO.cbd() || AutoPlayVideoView.this.hZa == null) {
                                AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYX);
                                AutoPlayVideoView.this.gnW.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlM.getDuration();
                            AutoPlayVideoView.this.hYN = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SD) {
                                AutoPlayVideoView.this.hYR.setVisibility(0);
                                AutoPlayVideoView.this.hYR.t(AutoPlayVideoView.this.hYX, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYR.bXs();
                                return;
                            }
                            AutoPlayVideoView.this.hYP.pV();
                            AutoPlayVideoView.this.hYP.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SD) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlM.getDuration() - AutoPlayVideoView.this.dlM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYN == 1) {
                            if (AutoPlayVideoView.this.hYW == AutoPlayVideoView.this.dlM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.dlM.getCurrentPosition();
                                AutoPlayVideoView.this.boN();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlM.isPlaying() && AutoPlayVideoView.this.dlO.cbd() && AutoPlayVideoView.this.hZa != null) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() > AutoPlayVideoView.this.hYX) {
                                AutoPlayVideoView.this.gnW.setVisibility(8);
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
        this.cRU = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlM != null && AutoPlayVideoView.this.dlO.cbd()) {
                        if (AutoPlayVideoView.this.hZb == null) {
                            AutoPlayVideoView.this.hZb = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hZb.setDataSource(AutoPlayVideoView.this.dlO.rK(AutoPlayVideoView.this.dlO.cbc()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hZa != null) {
                            AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYX);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYY, AutoPlayVideoView.this.hYZ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYM;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boN();
                AutoPlayVideoView.this.hYX = 0L;
                if (AutoPlayVideoView.this.SD) {
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYU.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYU.setVisibility(8);
                }
                return true;
            }
        };
        this.cRT = null;
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hZc = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYM != null && AutoPlayVideoView.this.dlM != null) {
                    AutoPlayVideoView.this.bXr();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hYN = -1;
        this.SD = false;
        this.hYT = false;
        this.mOnClickListener = null;
        this.hYW = 0L;
        this.hYX = 0L;
        this.mDuration = 0L;
        this.hYY = 1.0f;
        this.hYZ = 1.0f;
        this.hZa = null;
        this.hZb = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYN != 1) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.hYX;
                            AutoPlayVideoView.this.goc.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlO.cbd() || AutoPlayVideoView.this.hZa == null) {
                                AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYX);
                                AutoPlayVideoView.this.gnW.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlM.getDuration();
                            AutoPlayVideoView.this.hYN = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SD) {
                                AutoPlayVideoView.this.hYR.setVisibility(0);
                                AutoPlayVideoView.this.hYR.t(AutoPlayVideoView.this.hYX, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYR.bXs();
                                return;
                            }
                            AutoPlayVideoView.this.hYP.pV();
                            AutoPlayVideoView.this.hYP.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SD) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlM.getDuration() - AutoPlayVideoView.this.dlM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYN == 1) {
                            if (AutoPlayVideoView.this.hYW == AutoPlayVideoView.this.dlM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.dlM.getCurrentPosition();
                                AutoPlayVideoView.this.boN();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlM.isPlaying() && AutoPlayVideoView.this.dlO.cbd() && AutoPlayVideoView.this.hZa != null) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() > AutoPlayVideoView.this.hYX) {
                                AutoPlayVideoView.this.gnW.setVisibility(8);
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
        this.cRU = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlM != null && AutoPlayVideoView.this.dlO.cbd()) {
                        if (AutoPlayVideoView.this.hZb == null) {
                            AutoPlayVideoView.this.hZb = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hZb.setDataSource(AutoPlayVideoView.this.dlO.rK(AutoPlayVideoView.this.dlO.cbc()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hZa != null) {
                            AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYX);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYY, AutoPlayVideoView.this.hYZ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYM;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boN();
                AutoPlayVideoView.this.hYX = 0L;
                if (AutoPlayVideoView.this.SD) {
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYU.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYU.setVisibility(8);
                }
                return true;
            }
        };
        this.cRT = null;
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hZc = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYM != null && AutoPlayVideoView.this.dlM != null) {
                    AutoPlayVideoView.this.bXr();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.hYK = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gnW = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.goc = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.hYO = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dlM = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dlO = new n(this.mContext);
        this.dlM.setBusiness(this.dlO);
        this.hYP = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.hYQ = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.hYR = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.hYS = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.hYS.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.hYU = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.hYV = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean bXq() {
        return q.bXq();
    }

    public void bXr() {
        if (bXq()) {
            this.dlM.setVideoPath(this.hYM.video_url, this.bVM);
            this.dlM.start();
            this.hYN = 0;
            if (!this.dlO.cbd() || this.hZa == null) {
                showLoading();
            }
            this.hYU.setVisibility(8);
            pi(this.SD);
            return;
        }
        boN();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYM = videoInfo;
        this.bVM = str;
        this.gnW.setDefaultErrorResource(0);
        this.gnW.setDefaultResource(0);
        this.gnW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gnW.setForegroundDrawable(R.drawable.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnW.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dlM.setOnPreparedListener(this.cRU);
        this.dlM.setOnErrorListener(this.cIy);
        if (this.cRT != null) {
            this.dlM.setOnCompletionListener(this.cRT);
        }
        this.dlM.setOnSurfaceDestroyedListener(this.cIC);
        this.hYP.setCertainColumnCount(4);
        this.hYP.setColumnColor(R.color.cp_btn_a);
        this.hYS.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hYV.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.g(getContext(), R.dimen.ds120);
        }
        layoutParams.height = af;
        this.hYV.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnW.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.gnW.setLayoutParams(layoutParams2);
        this.gnW.setOnClickListener(this.mOnClickListener);
        this.hYV.setOnClickListener(this.mOnClickListener);
        this.hYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.SD) {
                    AutoPlayVideoView.this.hYL.dismiss();
                    AutoPlayVideoView.this.gnW.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.hYR.destroy();
        e.iB().removeCallbacks(this.hZc);
        if (this.dlM.isPlaying()) {
            this.hYW = this.dlM.getCurrentPosition();
            if (this.dlO.cbd() && this.hZb != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.hZb.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.hYW), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.hYM.video_width.intValue() / frameAtTime.getWidth(), this.hYM.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.hZa;
                                    this.hZa = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gnW.setImageBitmap(this.hZa);
                                    this.gnW.setForegroundDrawable(0);
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
                                this.hYN = 3;
                                this.gnW.setVisibility(0);
                                this.dlM.stopPlayback();
                                this.hYP.pV();
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
        this.hYN = 3;
        this.gnW.setVisibility(0);
        this.dlM.stopPlayback();
        this.hYP.pV();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.hYQ, R.color.cp_btn_a);
            al.f(this.hYS, R.color.cp_cont_g, 1);
            al.g(this.hYS, R.drawable.btn_video, 1);
            this.hYP.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.hYN;
    }

    public long getCurrentPosition() {
        return this.hYW;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cRT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.goc.setVisibility(0);
        this.gnW.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boN() {
        this.goc.setVisibility(8);
        this.gnW.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.hYY = f;
        this.hYZ = f2;
    }

    public long getDuration() {
        if (this.dlM == null) {
            return this.hYM.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.hYM.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.hYX = j;
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
    public void pi(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.hYO.setVisibility(8);
            this.hYR.setPlayer(this.dlM);
            return;
        }
        this.hYR.setVisibility(8);
        this.hYR.destroy();
        this.hYO.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.hYK != null && this.dlM != null) {
            if (!z) {
                if (this.hYL != null) {
                    this.hYL.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            pi(true);
            if (this.hYT) {
                this.hYS.setVisibility(0);
            }
            this.SD = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hYK.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.hYK.getParent();
            viewGroup.removeAllViews();
            this.hYL = new a(bdBaseActivity.getActivity(), this.hYK, new ViewGroup.LayoutParams(-1, -1));
            this.hYL.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.hYK != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.pi(false);
                        AutoPlayVideoView.this.hYS.setVisibility(8);
                        AutoPlayVideoView.this.SD = false;
                        ((ViewGroup) AutoPlayVideoView.this.hYK.getParent()).removeView(AutoPlayVideoView.this.hYK);
                        viewGroup.addView(AutoPlayVideoView.this.hYK);
                        AutoPlayVideoView.this.hYK.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.hYX = AutoPlayVideoView.this.hYW;
                        if (AutoPlayVideoView.this.hYU.getVisibility() != 0) {
                            AutoPlayVideoView.this.bXr();
                        }
                        AutoPlayVideoView.this.hYU.setVisibility(8);
                    }
                }
            });
            this.hYX = this.hYW;
            bXr();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.hYT = z;
    }
}
