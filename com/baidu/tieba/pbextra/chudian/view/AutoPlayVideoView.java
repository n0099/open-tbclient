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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.BaseAutoPlayVideoView;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.s;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean Ev;
    private String OC;
    private g.b dHR;
    private QuickVideoView.b dHV;
    private g.a dQN;
    private g.f dQO;
    private QuickVideoView egI;
    private n egK;
    private ForeDrawableImageView hic;
    private View hij;
    private View iXW;
    private a iXX;
    private VideoInfo iXY;
    private int iXZ;
    private RelativeLayout iYa;
    private AudioAnimationView iYb;
    private TextView iYc;
    private PbChudianProcessBar iYd;
    private TextView iYe;
    private boolean iYf;
    private View iYg;
    private View iYh;
    private long iYi;
    private long iYj;
    private float iYk;
    private float iYl;
    private Bitmap iYm;
    private MediaMetadataRetriever iYn;
    private Runnable iYo;
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
        this.iXZ = -1;
        this.Ev = false;
        this.iYf = false;
        this.mOnClickListener = null;
        this.iYi = 0L;
        this.iYj = 0L;
        this.mDuration = 0L;
        this.iYk = 1.0f;
        this.iYl = 1.0f;
        this.iYm = null;
        this.iYn = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.iXZ != 1) {
                            if (AutoPlayVideoView.this.egI.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.iYi = AutoPlayVideoView.this.iYj;
                            AutoPlayVideoView.this.hij.setVisibility(8);
                            if (!AutoPlayVideoView.this.egK.cvU() || AutoPlayVideoView.this.iYm == null) {
                                AutoPlayVideoView.this.egI.seekTo((int) AutoPlayVideoView.this.iYj);
                                AutoPlayVideoView.this.hic.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.egI.getDuration();
                            AutoPlayVideoView.this.iXZ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.Ev) {
                                AutoPlayVideoView.this.iYd.setVisibility(0);
                                AutoPlayVideoView.this.iYd.E(AutoPlayVideoView.this.iYj, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.iYd.crG();
                                return;
                            }
                            AutoPlayVideoView.this.iYb.lD();
                            AutoPlayVideoView.this.iYb.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.Ev) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.egI.getDuration() - AutoPlayVideoView.this.egI.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iYc.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.iXZ == 1) {
                            if (AutoPlayVideoView.this.iYi == AutoPlayVideoView.this.egI.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.iYi = AutoPlayVideoView.this.egI.getCurrentPosition();
                                AutoPlayVideoView.this.hideLoading();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.egI.isPlaying() && AutoPlayVideoView.this.egK.cvU() && AutoPlayVideoView.this.iYm != null) {
                            if (AutoPlayVideoView.this.egI.getCurrentPosition() > AutoPlayVideoView.this.iYj) {
                                AutoPlayVideoView.this.hic.setVisibility(8);
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
        this.dQO = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.egI != null && AutoPlayVideoView.this.egK.cvU()) {
                        if (AutoPlayVideoView.this.iYn == null) {
                            AutoPlayVideoView.this.iYn = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.iYn.setDataSource(AutoPlayVideoView.this.egK.wg(AutoPlayVideoView.this.egK.cvS()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.iYm != null) {
                            AutoPlayVideoView.this.egI.seekTo((int) AutoPlayVideoView.this.iYj);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.iYk, AutoPlayVideoView.this.iYl);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.iXY;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.hideLoading();
                AutoPlayVideoView.this.iYj = 0L;
                if (AutoPlayVideoView.this.Ev) {
                    AutoPlayVideoView.this.hic.setForegroundDrawable(0);
                    AutoPlayVideoView.this.iYg.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.hic.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.iYg.setVisibility(8);
                }
                return true;
            }
        };
        this.dQN = null;
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.iYo = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.iXY != null && AutoPlayVideoView.this.egI != null) {
                    AutoPlayVideoView.this.crF();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.iXZ = -1;
        this.Ev = false;
        this.iYf = false;
        this.mOnClickListener = null;
        this.iYi = 0L;
        this.iYj = 0L;
        this.mDuration = 0L;
        this.iYk = 1.0f;
        this.iYl = 1.0f;
        this.iYm = null;
        this.iYn = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.iXZ != 1) {
                            if (AutoPlayVideoView.this.egI.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.iYi = AutoPlayVideoView.this.iYj;
                            AutoPlayVideoView.this.hij.setVisibility(8);
                            if (!AutoPlayVideoView.this.egK.cvU() || AutoPlayVideoView.this.iYm == null) {
                                AutoPlayVideoView.this.egI.seekTo((int) AutoPlayVideoView.this.iYj);
                                AutoPlayVideoView.this.hic.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.egI.getDuration();
                            AutoPlayVideoView.this.iXZ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.Ev) {
                                AutoPlayVideoView.this.iYd.setVisibility(0);
                                AutoPlayVideoView.this.iYd.E(AutoPlayVideoView.this.iYj, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.iYd.crG();
                                return;
                            }
                            AutoPlayVideoView.this.iYb.lD();
                            AutoPlayVideoView.this.iYb.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.Ev) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.egI.getDuration() - AutoPlayVideoView.this.egI.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iYc.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.iXZ == 1) {
                            if (AutoPlayVideoView.this.iYi == AutoPlayVideoView.this.egI.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.iYi = AutoPlayVideoView.this.egI.getCurrentPosition();
                                AutoPlayVideoView.this.hideLoading();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.egI.isPlaying() && AutoPlayVideoView.this.egK.cvU() && AutoPlayVideoView.this.iYm != null) {
                            if (AutoPlayVideoView.this.egI.getCurrentPosition() > AutoPlayVideoView.this.iYj) {
                                AutoPlayVideoView.this.hic.setVisibility(8);
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
        this.dQO = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.egI != null && AutoPlayVideoView.this.egK.cvU()) {
                        if (AutoPlayVideoView.this.iYn == null) {
                            AutoPlayVideoView.this.iYn = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.iYn.setDataSource(AutoPlayVideoView.this.egK.wg(AutoPlayVideoView.this.egK.cvS()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.iYm != null) {
                            AutoPlayVideoView.this.egI.seekTo((int) AutoPlayVideoView.this.iYj);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.iYk, AutoPlayVideoView.this.iYl);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.iXY;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.hideLoading();
                AutoPlayVideoView.this.iYj = 0L;
                if (AutoPlayVideoView.this.Ev) {
                    AutoPlayVideoView.this.hic.setForegroundDrawable(0);
                    AutoPlayVideoView.this.iYg.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.hic.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.iYg.setVisibility(8);
                }
                return true;
            }
        };
        this.dQN = null;
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.iYo = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.iXY != null && AutoPlayVideoView.this.egI != null) {
                    AutoPlayVideoView.this.crF();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iXZ = -1;
        this.Ev = false;
        this.iYf = false;
        this.mOnClickListener = null;
        this.iYi = 0L;
        this.iYj = 0L;
        this.mDuration = 0L;
        this.iYk = 1.0f;
        this.iYl = 1.0f;
        this.iYm = null;
        this.iYn = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.iXZ != 1) {
                            if (AutoPlayVideoView.this.egI.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.iYi = AutoPlayVideoView.this.iYj;
                            AutoPlayVideoView.this.hij.setVisibility(8);
                            if (!AutoPlayVideoView.this.egK.cvU() || AutoPlayVideoView.this.iYm == null) {
                                AutoPlayVideoView.this.egI.seekTo((int) AutoPlayVideoView.this.iYj);
                                AutoPlayVideoView.this.hic.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.egI.getDuration();
                            AutoPlayVideoView.this.iXZ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.Ev) {
                                AutoPlayVideoView.this.iYd.setVisibility(0);
                                AutoPlayVideoView.this.iYd.E(AutoPlayVideoView.this.iYj, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.iYd.crG();
                                return;
                            }
                            AutoPlayVideoView.this.iYb.lD();
                            AutoPlayVideoView.this.iYb.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.Ev) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.egI.getDuration() - AutoPlayVideoView.this.egI.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iYc.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.iXZ == 1) {
                            if (AutoPlayVideoView.this.iYi == AutoPlayVideoView.this.egI.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.iYi = AutoPlayVideoView.this.egI.getCurrentPosition();
                                AutoPlayVideoView.this.hideLoading();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.egI.isPlaying() && AutoPlayVideoView.this.egK.cvU() && AutoPlayVideoView.this.iYm != null) {
                            if (AutoPlayVideoView.this.egI.getCurrentPosition() > AutoPlayVideoView.this.iYj) {
                                AutoPlayVideoView.this.hic.setVisibility(8);
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
        this.dQO = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.egI != null && AutoPlayVideoView.this.egK.cvU()) {
                        if (AutoPlayVideoView.this.iYn == null) {
                            AutoPlayVideoView.this.iYn = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.iYn.setDataSource(AutoPlayVideoView.this.egK.wg(AutoPlayVideoView.this.egK.cvS()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.iYm != null) {
                            AutoPlayVideoView.this.egI.seekTo((int) AutoPlayVideoView.this.iYj);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.iYk, AutoPlayVideoView.this.iYl);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.iXY;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.hideLoading();
                AutoPlayVideoView.this.iYj = 0L;
                if (AutoPlayVideoView.this.Ev) {
                    AutoPlayVideoView.this.hic.setForegroundDrawable(0);
                    AutoPlayVideoView.this.iYg.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.hic.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.iYg.setVisibility(8);
                }
                return true;
            }
        };
        this.dQN = null;
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.iYo = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.iXY != null && AutoPlayVideoView.this.egI != null) {
                    AutoPlayVideoView.this.crF();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.iXW = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.hic = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.hij = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.iYa = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.egI = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.egK = new n(this.mContext);
        this.egI.setBusiness(this.egK);
        this.iYb = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.iYc = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.iYd = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.iYe = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.iYe.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.iYg = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.iYh = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean crE() {
        return s.crE();
    }

    public void crF() {
        if (crE()) {
            this.egI.setVideoPath(this.iXY.video_url, this.OC);
            this.egI.start();
            this.iXZ = 0;
            if (!this.egK.cvU() || this.iYm == null) {
                showLoading();
            }
            this.iYg.setVisibility(8);
            qM(this.Ev);
            return;
        }
        hideLoading();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.iXY = videoInfo;
        this.OC = str;
        this.hic.setDefaultErrorResource(0);
        this.hic.setDefaultResource(0);
        this.hic.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hic.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hic.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.egI.setOnPreparedListener(this.dQO);
        this.egI.setOnErrorListener(this.dHR);
        if (this.dQN != null) {
            this.egI.setOnCompletionListener(this.dQN);
        }
        this.egI.setOnSurfaceDestroyedListener(this.dHV);
        this.iYb.setCertainColumnCount(4);
        this.iYb.setColumnColor(R.color.cp_cont_a);
        this.iYe.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iYh.getLayoutParams();
        int equipmentWidth = l.getEquipmentWidth(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            equipmentWidth = ((equipmentWidth * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.getDimens(getContext(), R.dimen.ds120);
        }
        layoutParams.height = equipmentWidth;
        this.iYh.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hic.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = equipmentWidth;
        }
        this.hic.setLayoutParams(layoutParams2);
        this.hic.setOnClickListener(this.mOnClickListener);
        this.iYh.setOnClickListener(this.mOnClickListener);
        this.iYg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.Ev) {
                    AutoPlayVideoView.this.iXX.dismiss();
                    AutoPlayVideoView.this.hic.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.iYd.destroy();
        e.gy().removeCallbacks(this.iYo);
        if (this.egI.isPlaying()) {
            this.iYi = this.egI.getCurrentPosition();
            if (this.egK.cvU() && this.iYn != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.iYn.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.iYi), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.iXY.video_width.intValue() / frameAtTime.getWidth(), this.iXY.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.iYm;
                                    this.iYm = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.hic.setImageBitmap(this.iYm);
                                    this.hic.setForegroundDrawable(0);
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
                                this.iXZ = 3;
                                this.hic.setVisibility(0);
                                this.egI.stopPlayback();
                                this.iYb.lD();
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
        this.iXZ = 3;
        this.hic.setVisibility(0);
        this.egI.stopPlayback();
        this.iYb.lD();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.iYc, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.iYe, R.color.cp_cont_g, 1);
            am.setBackgroundResource(this.iYe, R.drawable.btn_video, 1);
            this.iYb.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.iXZ;
    }

    public long getCurrentPosition() {
        return this.iYi;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.dQN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.hij.setVisibility(0);
        this.hic.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        this.hij.setVisibility(8);
        this.hic.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.iYk = f;
        this.iYl = f2;
    }

    public long getDuration() {
        if (this.egI == null) {
            return this.iXY.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.iXY.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.iYj = j;
    }

    /* loaded from: classes6.dex */
    private static class a extends Dialog {
        public a(Activity activity, View view, ViewGroup.LayoutParams layoutParams) {
            super(activity);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            requestWindowFeature(1);
            com.baidu.adp.lib.f.g.showDialog(this, activity);
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
    public void qM(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.iYa.setVisibility(8);
            this.iYd.setPlayer(this.egI);
            return;
        }
        this.iYd.setVisibility(8);
        this.iYd.destroy();
        this.iYa.setVisibility(0);
    }

    public void setFullScreen(TbPageContext tbPageContext, boolean z) {
        if (this.iXW != null && this.egI != null) {
            if (!z) {
                if (this.iXX != null) {
                    this.iXX.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            qM(true);
            if (this.iYf) {
                this.iYe.setVisibility(0);
            }
            this.Ev = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iXW.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.iXW.getParent();
            viewGroup.removeAllViews();
            this.iXX = new a(tbPageContext.getPageActivity(), this.iXW, new ViewGroup.LayoutParams(-1, -1));
            this.iXX.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.iXW != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.qM(false);
                        AutoPlayVideoView.this.iYe.setVisibility(8);
                        AutoPlayVideoView.this.Ev = false;
                        ((ViewGroup) AutoPlayVideoView.this.iXW.getParent()).removeView(AutoPlayVideoView.this.iXW);
                        viewGroup.addView(AutoPlayVideoView.this.iXW);
                        AutoPlayVideoView.this.iXW.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.iYj = AutoPlayVideoView.this.iYi;
                        if (AutoPlayVideoView.this.iYg.getVisibility() != 0) {
                            AutoPlayVideoView.this.crF();
                        }
                        AutoPlayVideoView.this.iYg.setVisibility(8);
                    }
                }
            });
            this.iYj = this.iYi;
            crF();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.iYf = z;
    }
}
