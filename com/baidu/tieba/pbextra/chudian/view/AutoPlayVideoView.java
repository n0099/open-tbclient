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
import com.baidu.tieba.d;
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
    private boolean UU;
    private g.b cAp;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private String ctx;
    private QuickVideoView dbg;
    private n dbi;
    private ForeDrawableImageView fWF;
    private View fWL;
    private View hGG;
    private a hGH;
    private VideoInfo hGI;
    private int hGJ;
    private RelativeLayout hGK;
    private AudioAnimationView hGL;
    private TextView hGM;
    private PbChudianProcessBar hGN;
    private TextView hGO;
    private boolean hGP;
    private View hGQ;
    private View hGR;
    private long hGS;
    private long hGT;
    private float hGU;
    private float hGV;
    private Bitmap hGW;
    private MediaMetadataRetriever hGX;
    private Runnable hGY;
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
        this.hGJ = -1;
        this.UU = false;
        this.hGP = false;
        this.mOnClickListener = null;
        this.hGS = 0L;
        this.hGT = 0L;
        this.mDuration = 0L;
        this.hGU = 1.0f;
        this.hGV = 1.0f;
        this.hGW = null;
        this.hGX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGJ != 1) {
                            if (AutoPlayVideoView.this.dbg.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.hGT;
                            AutoPlayVideoView.this.fWL.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbi.bSY() || AutoPlayVideoView.this.hGW == null) {
                                AutoPlayVideoView.this.dbg.seekTo((int) AutoPlayVideoView.this.hGT);
                                AutoPlayVideoView.this.fWF.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbg.getDuration();
                            AutoPlayVideoView.this.hGJ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UU) {
                                AutoPlayVideoView.this.hGN.setVisibility(0);
                                AutoPlayVideoView.this.hGN.s(AutoPlayVideoView.this.hGT, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hGN.bPv();
                                return;
                            }
                            AutoPlayVideoView.this.hGL.ra();
                            AutoPlayVideoView.this.hGL.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UU) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbg.getDuration() - AutoPlayVideoView.this.dbg.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGM.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGJ == 1) {
                            if (AutoPlayVideoView.this.hGS == AutoPlayVideoView.this.dbg.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.dbg.getCurrentPosition();
                                AutoPlayVideoView.this.bhp();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbg.isPlaying() && AutoPlayVideoView.this.dbi.bSY() && AutoPlayVideoView.this.hGW != null) {
                            if (AutoPlayVideoView.this.dbg.getCurrentPosition() > AutoPlayVideoView.this.hGT) {
                                AutoPlayVideoView.this.fWF.setVisibility(8);
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbg != null && AutoPlayVideoView.this.dbi.bSY()) {
                        if (AutoPlayVideoView.this.hGX == null) {
                            AutoPlayVideoView.this.hGX = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hGX.setDataSource(AutoPlayVideoView.this.dbi.qC(AutoPlayVideoView.this.dbi.bSX()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hGW != null) {
                            AutoPlayVideoView.this.dbg.seekTo((int) AutoPlayVideoView.this.hGT);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hGU, AutoPlayVideoView.this.hGV);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGI;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhp();
                AutoPlayVideoView.this.hGT = 0L;
                if (AutoPlayVideoView.this.UU) {
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hGQ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hGQ.setVisibility(8);
                }
                return true;
            }
        };
        this.cJI = null;
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hGY = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGI != null && AutoPlayVideoView.this.dbg != null) {
                    AutoPlayVideoView.this.bPu();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.hGJ = -1;
        this.UU = false;
        this.hGP = false;
        this.mOnClickListener = null;
        this.hGS = 0L;
        this.hGT = 0L;
        this.mDuration = 0L;
        this.hGU = 1.0f;
        this.hGV = 1.0f;
        this.hGW = null;
        this.hGX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGJ != 1) {
                            if (AutoPlayVideoView.this.dbg.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.hGT;
                            AutoPlayVideoView.this.fWL.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbi.bSY() || AutoPlayVideoView.this.hGW == null) {
                                AutoPlayVideoView.this.dbg.seekTo((int) AutoPlayVideoView.this.hGT);
                                AutoPlayVideoView.this.fWF.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbg.getDuration();
                            AutoPlayVideoView.this.hGJ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UU) {
                                AutoPlayVideoView.this.hGN.setVisibility(0);
                                AutoPlayVideoView.this.hGN.s(AutoPlayVideoView.this.hGT, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hGN.bPv();
                                return;
                            }
                            AutoPlayVideoView.this.hGL.ra();
                            AutoPlayVideoView.this.hGL.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UU) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbg.getDuration() - AutoPlayVideoView.this.dbg.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGM.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGJ == 1) {
                            if (AutoPlayVideoView.this.hGS == AutoPlayVideoView.this.dbg.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.dbg.getCurrentPosition();
                                AutoPlayVideoView.this.bhp();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbg.isPlaying() && AutoPlayVideoView.this.dbi.bSY() && AutoPlayVideoView.this.hGW != null) {
                            if (AutoPlayVideoView.this.dbg.getCurrentPosition() > AutoPlayVideoView.this.hGT) {
                                AutoPlayVideoView.this.fWF.setVisibility(8);
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbg != null && AutoPlayVideoView.this.dbi.bSY()) {
                        if (AutoPlayVideoView.this.hGX == null) {
                            AutoPlayVideoView.this.hGX = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hGX.setDataSource(AutoPlayVideoView.this.dbi.qC(AutoPlayVideoView.this.dbi.bSX()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hGW != null) {
                            AutoPlayVideoView.this.dbg.seekTo((int) AutoPlayVideoView.this.hGT);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hGU, AutoPlayVideoView.this.hGV);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGI;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhp();
                AutoPlayVideoView.this.hGT = 0L;
                if (AutoPlayVideoView.this.UU) {
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hGQ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hGQ.setVisibility(8);
                }
                return true;
            }
        };
        this.cJI = null;
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hGY = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGI != null && AutoPlayVideoView.this.dbg != null) {
                    AutoPlayVideoView.this.bPu();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hGJ = -1;
        this.UU = false;
        this.hGP = false;
        this.mOnClickListener = null;
        this.hGS = 0L;
        this.hGT = 0L;
        this.mDuration = 0L;
        this.hGU = 1.0f;
        this.hGV = 1.0f;
        this.hGW = null;
        this.hGX = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGJ != 1) {
                            if (AutoPlayVideoView.this.dbg.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.hGT;
                            AutoPlayVideoView.this.fWL.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbi.bSY() || AutoPlayVideoView.this.hGW == null) {
                                AutoPlayVideoView.this.dbg.seekTo((int) AutoPlayVideoView.this.hGT);
                                AutoPlayVideoView.this.fWF.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbg.getDuration();
                            AutoPlayVideoView.this.hGJ = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UU) {
                                AutoPlayVideoView.this.hGN.setVisibility(0);
                                AutoPlayVideoView.this.hGN.s(AutoPlayVideoView.this.hGT, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hGN.bPv();
                                return;
                            }
                            AutoPlayVideoView.this.hGL.ra();
                            AutoPlayVideoView.this.hGL.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UU) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbg.getDuration() - AutoPlayVideoView.this.dbg.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGM.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGJ == 1) {
                            if (AutoPlayVideoView.this.hGS == AutoPlayVideoView.this.dbg.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.dbg.getCurrentPosition();
                                AutoPlayVideoView.this.bhp();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbg.isPlaying() && AutoPlayVideoView.this.dbi.bSY() && AutoPlayVideoView.this.hGW != null) {
                            if (AutoPlayVideoView.this.dbg.getCurrentPosition() > AutoPlayVideoView.this.hGT) {
                                AutoPlayVideoView.this.fWF.setVisibility(8);
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbg != null && AutoPlayVideoView.this.dbi.bSY()) {
                        if (AutoPlayVideoView.this.hGX == null) {
                            AutoPlayVideoView.this.hGX = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hGX.setDataSource(AutoPlayVideoView.this.dbi.qC(AutoPlayVideoView.this.dbi.bSX()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hGW != null) {
                            AutoPlayVideoView.this.dbg.seekTo((int) AutoPlayVideoView.this.hGT);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hGU, AutoPlayVideoView.this.hGV);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGI;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhp();
                AutoPlayVideoView.this.hGT = 0L;
                if (AutoPlayVideoView.this.UU) {
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hGQ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hGQ.setVisibility(8);
                }
                return true;
            }
        };
        this.cJI = null;
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hGY = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGI != null && AutoPlayVideoView.this.dbg != null) {
                    AutoPlayVideoView.this.bPu();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.hGG = this.mRootView.findViewById(d.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.fWF = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.fWL = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.hGK = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.dbg = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.dbi = new n(this.mContext);
        this.dbg.setBusiness(this.dbi);
        this.hGL = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.hGM = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.hGN = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.hGO = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.hGO.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.hGQ = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.hGR = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bPt() {
        return q.bPt();
    }

    public void bPu() {
        if (bPt()) {
            this.dbg.setVideoPath(this.hGI.video_url, this.ctx);
            this.dbg.start();
            this.hGJ = 0;
            if (!this.dbi.bSY() || this.hGW == null) {
                showLoading();
            }
            this.hGQ.setVisibility(8);
            os(this.UU);
            return;
        }
        bhp();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGI = videoInfo;
        this.ctx = str;
        this.fWF.setDefaultErrorResource(0);
        this.fWF.setDefaultResource(0);
        this.fWF.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.fWF.setForegroundDrawable(d.f.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWF.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnErrorListener(this.cAp);
        if (this.cJI != null) {
            this.dbg.setOnCompletionListener(this.cJI);
        }
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        this.hGL.setCertainColumnCount(4);
        this.hGL.setColumnColor(d.C0277d.cp_btn_a);
        this.hGO.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGR.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), d.e.ds120);
        }
        layoutParams.height = aO;
        this.hGR.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWF.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.fWF.setLayoutParams(layoutParams2);
        this.fWF.setOnClickListener(this.mOnClickListener);
        this.hGR.setOnClickListener(this.mOnClickListener);
        this.hGQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.UU) {
                    AutoPlayVideoView.this.hGH.dismiss();
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
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
        this.hGN.destroy();
        e.jH().removeCallbacks(this.hGY);
        if (this.dbg.isPlaying()) {
            this.hGS = this.dbg.getCurrentPosition();
            if (this.dbi.bSY() && this.hGX != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.hGX.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.hGS), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.hGI.video_width.intValue() / frameAtTime.getWidth(), this.hGI.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.hGW;
                                    this.hGW = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.fWF.setImageBitmap(this.hGW);
                                    this.fWF.setForegroundDrawable(0);
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
                                this.hGJ = 3;
                                this.fWF.setVisibility(0);
                                this.dbg.stopPlayback();
                                this.hGL.ra();
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
        this.hGJ = 3;
        this.fWF.setVisibility(0);
        this.dbg.stopPlayback();
        this.hGL.ra();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.hGM, d.C0277d.cp_btn_a);
            al.d(this.hGO, d.C0277d.cp_cont_g, 1);
            al.e(this.hGO, d.f.btn_video, 1);
            this.hGL.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.hGJ;
    }

    public long getCurrentPosition() {
        return this.hGS;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cJI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.fWL.setVisibility(0);
        this.fWF.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhp() {
        this.fWL.setVisibility(8);
        this.fWF.setForegroundDrawable(d.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.hGU = f;
        this.hGV = f2;
    }

    public long getDuration() {
        if (this.dbg == null) {
            return this.hGI.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.hGI.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.hGT = j;
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
    public void os(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.hGK.setVisibility(8);
            this.hGN.setPlayer(this.dbg);
            return;
        }
        this.hGN.setVisibility(8);
        this.hGN.destroy();
        this.hGK.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.hGG != null && this.dbg != null) {
            if (!z) {
                if (this.hGH != null) {
                    this.hGH.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            os(true);
            if (this.hGP) {
                this.hGO.setVisibility(0);
            }
            this.UU = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGG.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.hGG.getParent();
            viewGroup.removeAllViews();
            this.hGH = new a(bdBaseActivity.getActivity(), this.hGG, new ViewGroup.LayoutParams(-1, -1));
            this.hGH.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.hGG != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.os(false);
                        AutoPlayVideoView.this.hGO.setVisibility(8);
                        AutoPlayVideoView.this.UU = false;
                        ((ViewGroup) AutoPlayVideoView.this.hGG.getParent()).removeView(AutoPlayVideoView.this.hGG);
                        viewGroup.addView(AutoPlayVideoView.this.hGG);
                        AutoPlayVideoView.this.hGG.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.hGT = AutoPlayVideoView.this.hGS;
                        if (AutoPlayVideoView.this.hGQ.getVisibility() != 0) {
                            AutoPlayVideoView.this.bPu();
                        }
                        AutoPlayVideoView.this.hGQ.setVisibility(8);
                    }
                }
            });
            this.hGT = this.hGS;
            bPu();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.hGP = z;
    }
}
