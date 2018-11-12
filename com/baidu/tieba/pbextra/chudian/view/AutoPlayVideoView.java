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
    private boolean bFw;
    private n bKA;
    private QuickVideoView bKy;
    private String beV;
    private QuickVideoView.b blC;
    private g.b bly;
    private g.a bul;
    private g.f bum;
    private ForeDrawableImageView ews;
    private View ewy;
    private View gfV;
    private a gfW;
    private VideoInfo gfX;
    private int gfY;
    private RelativeLayout gfZ;
    private AudioAnimationView gga;
    private TextView ggb;
    private PbChudianProcessBar ggc;
    private TextView ggd;
    private boolean gge;
    private View ggf;
    private View ggg;
    private long ggh;
    private long ggi;
    private float ggj;
    private float ggk;
    private Bitmap ggl;
    private MediaMetadataRetriever ggm;
    private Runnable ggn;
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
        this.gfY = -1;
        this.bFw = false;
        this.gge = false;
        this.mOnClickListener = null;
        this.ggh = 0L;
        this.ggi = 0L;
        this.mDuration = 0L;
        this.ggj = 1.0f;
        this.ggk = 1.0f;
        this.ggl = null;
        this.ggm = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gfY != 1) {
                            if (AutoPlayVideoView.this.bKy.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.ggh = AutoPlayVideoView.this.ggi;
                            AutoPlayVideoView.this.ewy.setVisibility(8);
                            if (!AutoPlayVideoView.this.bKA.bps() || AutoPlayVideoView.this.ggl == null) {
                                AutoPlayVideoView.this.bKy.seekTo((int) AutoPlayVideoView.this.ggi);
                                AutoPlayVideoView.this.ews.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bKy.getDuration();
                            AutoPlayVideoView.this.gfY = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bFw) {
                                AutoPlayVideoView.this.ggc.setVisibility(0);
                                AutoPlayVideoView.this.ggc.m(AutoPlayVideoView.this.ggi, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.ggc.blN();
                                return;
                            }
                            AutoPlayVideoView.this.gga.pU();
                            AutoPlayVideoView.this.gga.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bFw) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bKy.getDuration() - AutoPlayVideoView.this.bKy.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.ggb.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gfY == 1) {
                            if (AutoPlayVideoView.this.ggh == AutoPlayVideoView.this.bKy.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.ggh = AutoPlayVideoView.this.bKy.getCurrentPosition();
                                AutoPlayVideoView.this.aEd();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bKy.isPlaying() && AutoPlayVideoView.this.bKA.bps() && AutoPlayVideoView.this.ggl != null) {
                            if (AutoPlayVideoView.this.bKy.getCurrentPosition() > AutoPlayVideoView.this.ggi) {
                                AutoPlayVideoView.this.ews.setVisibility(8);
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
        this.bum = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bKy != null && AutoPlayVideoView.this.bKA.bps()) {
                        if (AutoPlayVideoView.this.ggm == null) {
                            AutoPlayVideoView.this.ggm = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ggm.setDataSource(AutoPlayVideoView.this.bKA.ji(AutoPlayVideoView.this.bKA.bpr()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ggl != null) {
                            AutoPlayVideoView.this.bKy.seekTo((int) AutoPlayVideoView.this.ggi);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.ggj, AutoPlayVideoView.this.ggk);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gfX;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEd();
                AutoPlayVideoView.this.ggi = 0L;
                if (AutoPlayVideoView.this.bFw) {
                    AutoPlayVideoView.this.ews.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ggf.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.ews.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.ggf.setVisibility(8);
                }
                return true;
            }
        };
        this.bul = null;
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ggn = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gfX != null && AutoPlayVideoView.this.bKy != null) {
                    AutoPlayVideoView.this.blM();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.gfY = -1;
        this.bFw = false;
        this.gge = false;
        this.mOnClickListener = null;
        this.ggh = 0L;
        this.ggi = 0L;
        this.mDuration = 0L;
        this.ggj = 1.0f;
        this.ggk = 1.0f;
        this.ggl = null;
        this.ggm = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gfY != 1) {
                            if (AutoPlayVideoView.this.bKy.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.ggh = AutoPlayVideoView.this.ggi;
                            AutoPlayVideoView.this.ewy.setVisibility(8);
                            if (!AutoPlayVideoView.this.bKA.bps() || AutoPlayVideoView.this.ggl == null) {
                                AutoPlayVideoView.this.bKy.seekTo((int) AutoPlayVideoView.this.ggi);
                                AutoPlayVideoView.this.ews.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bKy.getDuration();
                            AutoPlayVideoView.this.gfY = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bFw) {
                                AutoPlayVideoView.this.ggc.setVisibility(0);
                                AutoPlayVideoView.this.ggc.m(AutoPlayVideoView.this.ggi, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.ggc.blN();
                                return;
                            }
                            AutoPlayVideoView.this.gga.pU();
                            AutoPlayVideoView.this.gga.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bFw) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bKy.getDuration() - AutoPlayVideoView.this.bKy.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.ggb.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gfY == 1) {
                            if (AutoPlayVideoView.this.ggh == AutoPlayVideoView.this.bKy.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.ggh = AutoPlayVideoView.this.bKy.getCurrentPosition();
                                AutoPlayVideoView.this.aEd();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bKy.isPlaying() && AutoPlayVideoView.this.bKA.bps() && AutoPlayVideoView.this.ggl != null) {
                            if (AutoPlayVideoView.this.bKy.getCurrentPosition() > AutoPlayVideoView.this.ggi) {
                                AutoPlayVideoView.this.ews.setVisibility(8);
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
        this.bum = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bKy != null && AutoPlayVideoView.this.bKA.bps()) {
                        if (AutoPlayVideoView.this.ggm == null) {
                            AutoPlayVideoView.this.ggm = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ggm.setDataSource(AutoPlayVideoView.this.bKA.ji(AutoPlayVideoView.this.bKA.bpr()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ggl != null) {
                            AutoPlayVideoView.this.bKy.seekTo((int) AutoPlayVideoView.this.ggi);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.ggj, AutoPlayVideoView.this.ggk);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gfX;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEd();
                AutoPlayVideoView.this.ggi = 0L;
                if (AutoPlayVideoView.this.bFw) {
                    AutoPlayVideoView.this.ews.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ggf.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.ews.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.ggf.setVisibility(8);
                }
                return true;
            }
        };
        this.bul = null;
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ggn = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gfX != null && AutoPlayVideoView.this.bKy != null) {
                    AutoPlayVideoView.this.blM();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gfY = -1;
        this.bFw = false;
        this.gge = false;
        this.mOnClickListener = null;
        this.ggh = 0L;
        this.ggi = 0L;
        this.mDuration = 0L;
        this.ggj = 1.0f;
        this.ggk = 1.0f;
        this.ggl = null;
        this.ggm = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gfY != 1) {
                            if (AutoPlayVideoView.this.bKy.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.ggh = AutoPlayVideoView.this.ggi;
                            AutoPlayVideoView.this.ewy.setVisibility(8);
                            if (!AutoPlayVideoView.this.bKA.bps() || AutoPlayVideoView.this.ggl == null) {
                                AutoPlayVideoView.this.bKy.seekTo((int) AutoPlayVideoView.this.ggi);
                                AutoPlayVideoView.this.ews.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bKy.getDuration();
                            AutoPlayVideoView.this.gfY = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bFw) {
                                AutoPlayVideoView.this.ggc.setVisibility(0);
                                AutoPlayVideoView.this.ggc.m(AutoPlayVideoView.this.ggi, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.ggc.blN();
                                return;
                            }
                            AutoPlayVideoView.this.gga.pU();
                            AutoPlayVideoView.this.gga.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bFw) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bKy.getDuration() - AutoPlayVideoView.this.bKy.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.ggb.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gfY == 1) {
                            if (AutoPlayVideoView.this.ggh == AutoPlayVideoView.this.bKy.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.ggh = AutoPlayVideoView.this.bKy.getCurrentPosition();
                                AutoPlayVideoView.this.aEd();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bKy.isPlaying() && AutoPlayVideoView.this.bKA.bps() && AutoPlayVideoView.this.ggl != null) {
                            if (AutoPlayVideoView.this.bKy.getCurrentPosition() > AutoPlayVideoView.this.ggi) {
                                AutoPlayVideoView.this.ews.setVisibility(8);
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
        this.bum = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bKy != null && AutoPlayVideoView.this.bKA.bps()) {
                        if (AutoPlayVideoView.this.ggm == null) {
                            AutoPlayVideoView.this.ggm = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ggm.setDataSource(AutoPlayVideoView.this.bKA.ji(AutoPlayVideoView.this.bKA.bpr()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ggl != null) {
                            AutoPlayVideoView.this.bKy.seekTo((int) AutoPlayVideoView.this.ggi);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.ggj, AutoPlayVideoView.this.ggk);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gfX;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEd();
                AutoPlayVideoView.this.ggi = 0L;
                if (AutoPlayVideoView.this.bFw) {
                    AutoPlayVideoView.this.ews.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ggf.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.ews.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.ggf.setVisibility(8);
                }
                return true;
            }
        };
        this.bul = null;
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ggn = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gfX != null && AutoPlayVideoView.this.bKy != null) {
                    AutoPlayVideoView.this.blM();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gfV = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.ews = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.ewy = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.gfZ = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bKy = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bKA = new n(this.mContext);
        this.bKy.setBusiness(this.bKA);
        this.gga = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.ggb = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.ggc = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.ggd = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.ggd.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.ggf = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.ggg = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean blL() {
        return q.blL();
    }

    public void blM() {
        if (blL()) {
            this.bKy.setVideoPath(this.gfX.video_url, this.beV);
            this.bKy.start();
            this.gfY = 0;
            if (!this.bKA.bps() || this.ggl == null) {
                showLoading();
            }
            this.ggf.setVisibility(8);
            lP(this.bFw);
            return;
        }
        aEd();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gfX = videoInfo;
        this.beV = str;
        this.ews.setDefaultErrorResource(0);
        this.ews.setDefaultResource(0);
        this.ews.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.ews.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.ews.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bKy.setOnPreparedListener(this.bum);
        this.bKy.setOnErrorListener(this.bly);
        if (this.bul != null) {
            this.bKy.setOnCompletionListener(this.bul);
        }
        this.bKy.setOnSurfaceDestroyedListener(this.blC);
        this.gga.setCertainColumnCount(4);
        this.gga.setColumnColor(e.d.cp_cont_i);
        this.ggd.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ggg.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0200e.ds120);
        }
        layoutParams.height = aO;
        this.ggg.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ews.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.ews.setLayoutParams(layoutParams2);
        this.ews.setOnClickListener(this.mOnClickListener);
        this.ggg.setOnClickListener(this.mOnClickListener);
        this.ggf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bFw) {
                    AutoPlayVideoView.this.gfW.dismiss();
                    AutoPlayVideoView.this.ews.setForegroundDrawable(e.f.icon_play_video);
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
        this.ggc.destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ggn);
        if (this.bKy.isPlaying()) {
            this.ggh = this.bKy.getCurrentPosition();
            if (this.bKA.bps() && this.ggm != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.ggm.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.ggh), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.gfX.video_width.intValue() / frameAtTime.getWidth(), this.gfX.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.ggl;
                                    this.ggl = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.ews.setImageBitmap(this.ggl);
                                    this.ews.setForegroundDrawable(0);
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
                                this.gfY = 3;
                                this.ews.setVisibility(0);
                                this.bKy.stopPlayback();
                                this.gga.pU();
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
        this.gfY = 3;
        this.ews.setVisibility(0);
        this.bKy.stopPlayback();
        this.gga.pU();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.ggb, e.d.cp_cont_i);
            al.c(this.ggd, e.d.cp_cont_g, 1);
            al.d(this.ggd, e.f.btn_video, 1);
            this.gga.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.gfY;
    }

    public long getCurrentPosition() {
        return this.ggh;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bul = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.ewy.setVisibility(0);
        this.ews.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEd() {
        this.ewy.setVisibility(8);
        this.ews.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.ggj = f;
        this.ggk = f2;
    }

    public long getDuration() {
        if (this.bKy == null) {
            return this.gfX.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.gfX.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.ggi = j;
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
    public void lP(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.gfZ.setVisibility(8);
            this.ggc.setPlayer(this.bKy);
            return;
        }
        this.ggc.setVisibility(8);
        this.ggc.destroy();
        this.gfZ.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gfV != null && this.bKy != null) {
            if (!z) {
                if (this.gfW != null) {
                    this.gfW.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lP(true);
            if (this.gge) {
                this.ggd.setVisibility(0);
            }
            this.bFw = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gfV.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gfV.getParent();
            viewGroup.removeAllViews();
            this.gfW = new a(bdBaseActivity.getActivity(), this.gfV, new ViewGroup.LayoutParams(-1, -1));
            this.gfW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gfV != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lP(false);
                        AutoPlayVideoView.this.ggd.setVisibility(8);
                        AutoPlayVideoView.this.bFw = false;
                        ((ViewGroup) AutoPlayVideoView.this.gfV.getParent()).removeView(AutoPlayVideoView.this.gfV);
                        viewGroup.addView(AutoPlayVideoView.this.gfV);
                        AutoPlayVideoView.this.gfV.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.ggi = AutoPlayVideoView.this.ggh;
                        if (AutoPlayVideoView.this.ggf.getVisibility() != 0) {
                            AutoPlayVideoView.this.blM();
                        }
                        AutoPlayVideoView.this.ggf.setVisibility(8);
                    }
                }
            });
            this.ggi = this.ggh;
            blM();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.gge = z;
    }
}
