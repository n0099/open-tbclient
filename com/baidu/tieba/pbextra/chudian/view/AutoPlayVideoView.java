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
    private g.a cRS;
    private g.f cRT;
    private QuickVideoView dlM;
    private n dlO;
    private ForeDrawableImageView gnU;
    private View goa;
    private View hYJ;
    private a hYK;
    private VideoInfo hYL;
    private int hYM;
    private RelativeLayout hYN;
    private AudioAnimationView hYO;
    private TextView hYP;
    private PbChudianProcessBar hYQ;
    private TextView hYR;
    private boolean hYS;
    private View hYT;
    private View hYU;
    private long hYV;
    private long hYW;
    private float hYX;
    private float hYY;
    private Bitmap hYZ;
    private MediaMetadataRetriever hZa;
    private Runnable hZb;
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
        this.hYM = -1;
        this.SE = false;
        this.hYS = false;
        this.mOnClickListener = null;
        this.hYV = 0L;
        this.hYW = 0L;
        this.mDuration = 0L;
        this.hYX = 1.0f;
        this.hYY = 1.0f;
        this.hYZ = null;
        this.hZa = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYM != 1) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYV = AutoPlayVideoView.this.hYW;
                            AutoPlayVideoView.this.goa.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlO.cbc() || AutoPlayVideoView.this.hYZ == null) {
                                AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYW);
                                AutoPlayVideoView.this.gnU.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlM.getDuration();
                            AutoPlayVideoView.this.hYM = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SE) {
                                AutoPlayVideoView.this.hYQ.setVisibility(0);
                                AutoPlayVideoView.this.hYQ.t(AutoPlayVideoView.this.hYW, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYQ.bXr();
                                return;
                            }
                            AutoPlayVideoView.this.hYO.pV();
                            AutoPlayVideoView.this.hYO.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlM.getDuration() - AutoPlayVideoView.this.dlM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYP.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYM == 1) {
                            if (AutoPlayVideoView.this.hYV == AutoPlayVideoView.this.dlM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYV = AutoPlayVideoView.this.dlM.getCurrentPosition();
                                AutoPlayVideoView.this.boL();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlM.isPlaying() && AutoPlayVideoView.this.dlO.cbc() && AutoPlayVideoView.this.hYZ != null) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() > AutoPlayVideoView.this.hYW) {
                                AutoPlayVideoView.this.gnU.setVisibility(8);
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
        this.cRT = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlM != null && AutoPlayVideoView.this.dlO.cbc()) {
                        if (AutoPlayVideoView.this.hZa == null) {
                            AutoPlayVideoView.this.hZa = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hZa.setDataSource(AutoPlayVideoView.this.dlO.rL(AutoPlayVideoView.this.dlO.cbb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hYZ != null) {
                            AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYW);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYX, AutoPlayVideoView.this.hYY);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYL;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boL();
                AutoPlayVideoView.this.hYW = 0L;
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYT.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYT.setVisibility(8);
                }
                return true;
            }
        };
        this.cRS = null;
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hZb = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYL != null && AutoPlayVideoView.this.dlM != null) {
                    AutoPlayVideoView.this.bXq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.hYM = -1;
        this.SE = false;
        this.hYS = false;
        this.mOnClickListener = null;
        this.hYV = 0L;
        this.hYW = 0L;
        this.mDuration = 0L;
        this.hYX = 1.0f;
        this.hYY = 1.0f;
        this.hYZ = null;
        this.hZa = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYM != 1) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYV = AutoPlayVideoView.this.hYW;
                            AutoPlayVideoView.this.goa.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlO.cbc() || AutoPlayVideoView.this.hYZ == null) {
                                AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYW);
                                AutoPlayVideoView.this.gnU.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlM.getDuration();
                            AutoPlayVideoView.this.hYM = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SE) {
                                AutoPlayVideoView.this.hYQ.setVisibility(0);
                                AutoPlayVideoView.this.hYQ.t(AutoPlayVideoView.this.hYW, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYQ.bXr();
                                return;
                            }
                            AutoPlayVideoView.this.hYO.pV();
                            AutoPlayVideoView.this.hYO.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlM.getDuration() - AutoPlayVideoView.this.dlM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYP.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYM == 1) {
                            if (AutoPlayVideoView.this.hYV == AutoPlayVideoView.this.dlM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYV = AutoPlayVideoView.this.dlM.getCurrentPosition();
                                AutoPlayVideoView.this.boL();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlM.isPlaying() && AutoPlayVideoView.this.dlO.cbc() && AutoPlayVideoView.this.hYZ != null) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() > AutoPlayVideoView.this.hYW) {
                                AutoPlayVideoView.this.gnU.setVisibility(8);
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
        this.cRT = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlM != null && AutoPlayVideoView.this.dlO.cbc()) {
                        if (AutoPlayVideoView.this.hZa == null) {
                            AutoPlayVideoView.this.hZa = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hZa.setDataSource(AutoPlayVideoView.this.dlO.rL(AutoPlayVideoView.this.dlO.cbb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hYZ != null) {
                            AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYW);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYX, AutoPlayVideoView.this.hYY);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYL;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boL();
                AutoPlayVideoView.this.hYW = 0L;
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYT.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYT.setVisibility(8);
                }
                return true;
            }
        };
        this.cRS = null;
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hZb = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYL != null && AutoPlayVideoView.this.dlM != null) {
                    AutoPlayVideoView.this.bXq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hYM = -1;
        this.SE = false;
        this.hYS = false;
        this.mOnClickListener = null;
        this.hYV = 0L;
        this.hYW = 0L;
        this.mDuration = 0L;
        this.hYX = 1.0f;
        this.hYY = 1.0f;
        this.hYZ = null;
        this.hZa = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hYM != 1) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hYV = AutoPlayVideoView.this.hYW;
                            AutoPlayVideoView.this.goa.setVisibility(8);
                            if (!AutoPlayVideoView.this.dlO.cbc() || AutoPlayVideoView.this.hYZ == null) {
                                AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYW);
                                AutoPlayVideoView.this.gnU.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dlM.getDuration();
                            AutoPlayVideoView.this.hYM = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SE) {
                                AutoPlayVideoView.this.hYQ.setVisibility(0);
                                AutoPlayVideoView.this.hYQ.t(AutoPlayVideoView.this.hYW, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hYQ.bXr();
                                return;
                            }
                            AutoPlayVideoView.this.hYO.pV();
                            AutoPlayVideoView.this.hYO.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SE) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dlM.getDuration() - AutoPlayVideoView.this.dlM.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hYP.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hYM == 1) {
                            if (AutoPlayVideoView.this.hYV == AutoPlayVideoView.this.dlM.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hYV = AutoPlayVideoView.this.dlM.getCurrentPosition();
                                AutoPlayVideoView.this.boL();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dlM.isPlaying() && AutoPlayVideoView.this.dlO.cbc() && AutoPlayVideoView.this.hYZ != null) {
                            if (AutoPlayVideoView.this.dlM.getCurrentPosition() > AutoPlayVideoView.this.hYW) {
                                AutoPlayVideoView.this.gnU.setVisibility(8);
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
        this.cRT = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dlM != null && AutoPlayVideoView.this.dlO.cbc()) {
                        if (AutoPlayVideoView.this.hZa == null) {
                            AutoPlayVideoView.this.hZa = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hZa.setDataSource(AutoPlayVideoView.this.dlO.rL(AutoPlayVideoView.this.dlO.cbb()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hYZ != null) {
                            AutoPlayVideoView.this.dlM.seekTo((int) AutoPlayVideoView.this.hYW);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hYX, AutoPlayVideoView.this.hYY);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hYL;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boL();
                AutoPlayVideoView.this.hYW = 0L;
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hYT.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.hYT.setVisibility(8);
                }
                return true;
            }
        };
        this.cRS = null;
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hZb = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hYL != null && AutoPlayVideoView.this.dlM != null) {
                    AutoPlayVideoView.this.bXq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.hYJ = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gnU = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.goa = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.hYN = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dlM = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dlO = new n(this.mContext);
        this.dlM.setBusiness(this.dlO);
        this.hYO = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.hYP = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.hYQ = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.hYR = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.hYR.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.hYT = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.hYU = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean bXp() {
        return q.bXp();
    }

    public void bXq() {
        if (bXp()) {
            this.dlM.setVideoPath(this.hYL.video_url, this.bVL);
            this.dlM.start();
            this.hYM = 0;
            if (!this.dlO.cbc() || this.hYZ == null) {
                showLoading();
            }
            this.hYT.setVisibility(8);
            ph(this.SE);
            return;
        }
        boL();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYL = videoInfo;
        this.bVL = str;
        this.gnU.setDefaultErrorResource(0);
        this.gnU.setDefaultResource(0);
        this.gnU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gnU.setForegroundDrawable(R.drawable.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnU.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dlM.setOnPreparedListener(this.cRT);
        this.dlM.setOnErrorListener(this.cIx);
        if (this.cRS != null) {
            this.dlM.setOnCompletionListener(this.cRS);
        }
        this.dlM.setOnSurfaceDestroyedListener(this.cIB);
        this.hYO.setCertainColumnCount(4);
        this.hYO.setColumnColor(R.color.cp_btn_a);
        this.hYR.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hYU.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.g(getContext(), R.dimen.ds120);
        }
        layoutParams.height = af;
        this.hYU.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnU.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.gnU.setLayoutParams(layoutParams2);
        this.gnU.setOnClickListener(this.mOnClickListener);
        this.hYU.setOnClickListener(this.mOnClickListener);
        this.hYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.SE) {
                    AutoPlayVideoView.this.hYK.dismiss();
                    AutoPlayVideoView.this.gnU.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.hYQ.destroy();
        e.iB().removeCallbacks(this.hZb);
        if (this.dlM.isPlaying()) {
            this.hYV = this.dlM.getCurrentPosition();
            if (this.dlO.cbc() && this.hZa != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.hZa.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.hYV), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.hYL.video_width.intValue() / frameAtTime.getWidth(), this.hYL.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.hYZ;
                                    this.hYZ = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gnU.setImageBitmap(this.hYZ);
                                    this.gnU.setForegroundDrawable(0);
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
                                this.hYM = 3;
                                this.gnU.setVisibility(0);
                                this.dlM.stopPlayback();
                                this.hYO.pV();
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
        this.hYM = 3;
        this.gnU.setVisibility(0);
        this.dlM.stopPlayback();
        this.hYO.pV();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.hYP, R.color.cp_btn_a);
            al.f(this.hYR, R.color.cp_cont_g, 1);
            al.g(this.hYR, R.drawable.btn_video, 1);
            this.hYO.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.hYM;
    }

    public long getCurrentPosition() {
        return this.hYV;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cRS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.goa.setVisibility(0);
        this.gnU.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boL() {
        this.goa.setVisibility(8);
        this.gnU.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.hYX = f;
        this.hYY = f2;
    }

    public long getDuration() {
        if (this.dlM == null) {
            return this.hYL.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.hYL.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.hYW = j;
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
            this.hYN.setVisibility(8);
            this.hYQ.setPlayer(this.dlM);
            return;
        }
        this.hYQ.setVisibility(8);
        this.hYQ.destroy();
        this.hYN.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.hYJ != null && this.dlM != null) {
            if (!z) {
                if (this.hYK != null) {
                    this.hYK.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            ph(true);
            if (this.hYS) {
                this.hYR.setVisibility(0);
            }
            this.SE = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hYJ.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.hYJ.getParent();
            viewGroup.removeAllViews();
            this.hYK = new a(bdBaseActivity.getActivity(), this.hYJ, new ViewGroup.LayoutParams(-1, -1));
            this.hYK.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.hYJ != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.ph(false);
                        AutoPlayVideoView.this.hYR.setVisibility(8);
                        AutoPlayVideoView.this.SE = false;
                        ((ViewGroup) AutoPlayVideoView.this.hYJ.getParent()).removeView(AutoPlayVideoView.this.hYJ);
                        viewGroup.addView(AutoPlayVideoView.this.hYJ);
                        AutoPlayVideoView.this.hYJ.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.hYW = AutoPlayVideoView.this.hYV;
                        if (AutoPlayVideoView.this.hYT.getVisibility() != 0) {
                            AutoPlayVideoView.this.bXq();
                        }
                        AutoPlayVideoView.this.hYT.setVisibility(8);
                    }
                }
            });
            this.hYW = this.hYV;
            bXq();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.hYS = z;
    }
}
