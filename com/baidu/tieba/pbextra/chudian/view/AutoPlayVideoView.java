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
    private boolean UT;
    private g.b cAo;
    private QuickVideoView.b cAs;
    private g.a cJH;
    private g.f cJI;
    private String ctw;
    private QuickVideoView dbf;
    private n dbh;
    private ForeDrawableImageView fWF;
    private View fWL;
    private View hGF;
    private a hGG;
    private VideoInfo hGH;
    private int hGI;
    private RelativeLayout hGJ;
    private AudioAnimationView hGK;
    private TextView hGL;
    private PbChudianProcessBar hGM;
    private TextView hGN;
    private boolean hGO;
    private View hGP;
    private View hGQ;
    private long hGR;
    private long hGS;
    private float hGT;
    private float hGU;
    private Bitmap hGV;
    private MediaMetadataRetriever hGW;
    private Runnable hGX;
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
        this.hGI = -1;
        this.UT = false;
        this.hGO = false;
        this.mOnClickListener = null;
        this.hGR = 0L;
        this.hGS = 0L;
        this.mDuration = 0L;
        this.hGT = 1.0f;
        this.hGU = 1.0f;
        this.hGV = null;
        this.hGW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGI != 1) {
                            if (AutoPlayVideoView.this.dbf.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hGR = AutoPlayVideoView.this.hGS;
                            AutoPlayVideoView.this.fWL.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbh.bSY() || AutoPlayVideoView.this.hGV == null) {
                                AutoPlayVideoView.this.dbf.seekTo((int) AutoPlayVideoView.this.hGS);
                                AutoPlayVideoView.this.fWF.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbf.getDuration();
                            AutoPlayVideoView.this.hGI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UT) {
                                AutoPlayVideoView.this.hGM.setVisibility(0);
                                AutoPlayVideoView.this.hGM.s(AutoPlayVideoView.this.hGS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hGM.bPv();
                                return;
                            }
                            AutoPlayVideoView.this.hGK.ra();
                            AutoPlayVideoView.this.hGK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbf.getDuration() - AutoPlayVideoView.this.dbf.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGI == 1) {
                            if (AutoPlayVideoView.this.hGR == AutoPlayVideoView.this.dbf.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hGR = AutoPlayVideoView.this.dbf.getCurrentPosition();
                                AutoPlayVideoView.this.bhp();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbf.isPlaying() && AutoPlayVideoView.this.dbh.bSY() && AutoPlayVideoView.this.hGV != null) {
                            if (AutoPlayVideoView.this.dbf.getCurrentPosition() > AutoPlayVideoView.this.hGS) {
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
        this.cJI = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbf != null && AutoPlayVideoView.this.dbh.bSY()) {
                        if (AutoPlayVideoView.this.hGW == null) {
                            AutoPlayVideoView.this.hGW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hGW.setDataSource(AutoPlayVideoView.this.dbh.qC(AutoPlayVideoView.this.dbh.bSX()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hGV != null) {
                            AutoPlayVideoView.this.dbf.seekTo((int) AutoPlayVideoView.this.hGS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hGT, AutoPlayVideoView.this.hGU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhp();
                AutoPlayVideoView.this.hGS = 0L;
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hGP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hGP.setVisibility(8);
                }
                return true;
            }
        };
        this.cJH = null;
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hGX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGH != null && AutoPlayVideoView.this.dbf != null) {
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
        this.hGI = -1;
        this.UT = false;
        this.hGO = false;
        this.mOnClickListener = null;
        this.hGR = 0L;
        this.hGS = 0L;
        this.mDuration = 0L;
        this.hGT = 1.0f;
        this.hGU = 1.0f;
        this.hGV = null;
        this.hGW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGI != 1) {
                            if (AutoPlayVideoView.this.dbf.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hGR = AutoPlayVideoView.this.hGS;
                            AutoPlayVideoView.this.fWL.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbh.bSY() || AutoPlayVideoView.this.hGV == null) {
                                AutoPlayVideoView.this.dbf.seekTo((int) AutoPlayVideoView.this.hGS);
                                AutoPlayVideoView.this.fWF.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbf.getDuration();
                            AutoPlayVideoView.this.hGI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UT) {
                                AutoPlayVideoView.this.hGM.setVisibility(0);
                                AutoPlayVideoView.this.hGM.s(AutoPlayVideoView.this.hGS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hGM.bPv();
                                return;
                            }
                            AutoPlayVideoView.this.hGK.ra();
                            AutoPlayVideoView.this.hGK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbf.getDuration() - AutoPlayVideoView.this.dbf.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGI == 1) {
                            if (AutoPlayVideoView.this.hGR == AutoPlayVideoView.this.dbf.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hGR = AutoPlayVideoView.this.dbf.getCurrentPosition();
                                AutoPlayVideoView.this.bhp();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbf.isPlaying() && AutoPlayVideoView.this.dbh.bSY() && AutoPlayVideoView.this.hGV != null) {
                            if (AutoPlayVideoView.this.dbf.getCurrentPosition() > AutoPlayVideoView.this.hGS) {
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
        this.cJI = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbf != null && AutoPlayVideoView.this.dbh.bSY()) {
                        if (AutoPlayVideoView.this.hGW == null) {
                            AutoPlayVideoView.this.hGW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hGW.setDataSource(AutoPlayVideoView.this.dbh.qC(AutoPlayVideoView.this.dbh.bSX()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hGV != null) {
                            AutoPlayVideoView.this.dbf.seekTo((int) AutoPlayVideoView.this.hGS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hGT, AutoPlayVideoView.this.hGU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhp();
                AutoPlayVideoView.this.hGS = 0L;
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hGP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hGP.setVisibility(8);
                }
                return true;
            }
        };
        this.cJH = null;
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hGX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGH != null && AutoPlayVideoView.this.dbf != null) {
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
        this.hGI = -1;
        this.UT = false;
        this.hGO = false;
        this.mOnClickListener = null;
        this.hGR = 0L;
        this.hGS = 0L;
        this.mDuration = 0L;
        this.hGT = 1.0f;
        this.hGU = 1.0f;
        this.hGV = null;
        this.hGW = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.hGI != 1) {
                            if (AutoPlayVideoView.this.dbf.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.hGR = AutoPlayVideoView.this.hGS;
                            AutoPlayVideoView.this.fWL.setVisibility(8);
                            if (!AutoPlayVideoView.this.dbh.bSY() || AutoPlayVideoView.this.hGV == null) {
                                AutoPlayVideoView.this.dbf.seekTo((int) AutoPlayVideoView.this.hGS);
                                AutoPlayVideoView.this.fWF.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dbf.getDuration();
                            AutoPlayVideoView.this.hGI = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.UT) {
                                AutoPlayVideoView.this.hGM.setVisibility(0);
                                AutoPlayVideoView.this.hGM.s(AutoPlayVideoView.this.hGS, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.hGM.bPv();
                                return;
                            }
                            AutoPlayVideoView.this.hGK.ra();
                            AutoPlayVideoView.this.hGK.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.UT) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dbf.getDuration() - AutoPlayVideoView.this.dbf.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.hGL.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.hGI == 1) {
                            if (AutoPlayVideoView.this.hGR == AutoPlayVideoView.this.dbf.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.hGR = AutoPlayVideoView.this.dbf.getCurrentPosition();
                                AutoPlayVideoView.this.bhp();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dbf.isPlaying() && AutoPlayVideoView.this.dbh.bSY() && AutoPlayVideoView.this.hGV != null) {
                            if (AutoPlayVideoView.this.dbf.getCurrentPosition() > AutoPlayVideoView.this.hGS) {
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
        this.cJI = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dbf != null && AutoPlayVideoView.this.dbh.bSY()) {
                        if (AutoPlayVideoView.this.hGW == null) {
                            AutoPlayVideoView.this.hGW = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.hGW.setDataSource(AutoPlayVideoView.this.dbh.qC(AutoPlayVideoView.this.dbh.bSX()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.hGV != null) {
                            AutoPlayVideoView.this.dbf.seekTo((int) AutoPlayVideoView.this.hGS);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.hGT, AutoPlayVideoView.this.hGU);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.hGH;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bhp();
                AutoPlayVideoView.this.hGS = 0L;
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(0);
                    AutoPlayVideoView.this.hGP.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.fWF.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.hGP.setVisibility(8);
                }
                return true;
            }
        };
        this.cJH = null;
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.hGX = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.hGH != null && AutoPlayVideoView.this.dbf != null) {
                    AutoPlayVideoView.this.bPu();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.hGF = this.mRootView.findViewById(d.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.fWF = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.fWL = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.hGJ = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.dbf = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.dbh = new n(this.mContext);
        this.dbf.setBusiness(this.dbh);
        this.hGK = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.hGL = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.hGM = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.hGN = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.hGN.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.hGP = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.hGQ = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bPt() {
        return q.bPt();
    }

    public void bPu() {
        if (bPt()) {
            this.dbf.setVideoPath(this.hGH.video_url, this.ctw);
            this.dbf.start();
            this.hGI = 0;
            if (!this.dbh.bSY() || this.hGV == null) {
                showLoading();
            }
            this.hGP.setVisibility(8);
            os(this.UT);
            return;
        }
        bhp();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGH = videoInfo;
        this.ctw = str;
        this.fWF.setDefaultErrorResource(0);
        this.fWF.setDefaultResource(0);
        this.fWF.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.fWF.setForegroundDrawable(d.f.icon_play_video);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWF.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dbf.setOnPreparedListener(this.cJI);
        this.dbf.setOnErrorListener(this.cAo);
        if (this.cJH != null) {
            this.dbf.setOnCompletionListener(this.cJH);
        }
        this.dbf.setOnSurfaceDestroyedListener(this.cAs);
        this.hGK.setCertainColumnCount(4);
        this.hGK.setColumnColor(d.C0277d.cp_btn_a);
        this.hGN.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGQ.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), d.e.ds120);
        }
        layoutParams.height = aO;
        this.hGQ.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWF.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.fWF.setLayoutParams(layoutParams2);
        this.fWF.setOnClickListener(this.mOnClickListener);
        this.hGQ.setOnClickListener(this.mOnClickListener);
        this.hGP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.UT) {
                    AutoPlayVideoView.this.hGG.dismiss();
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
        this.hGM.destroy();
        e.jH().removeCallbacks(this.hGX);
        if (this.dbf.isPlaying()) {
            this.hGR = this.dbf.getCurrentPosition();
            if (this.dbh.bSY() && this.hGW != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.hGW.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.hGR), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.hGH.video_width.intValue() / frameAtTime.getWidth(), this.hGH.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.hGV;
                                    this.hGV = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.fWF.setImageBitmap(this.hGV);
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
                                this.hGI = 3;
                                this.fWF.setVisibility(0);
                                this.dbf.stopPlayback();
                                this.hGK.ra();
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
        this.hGI = 3;
        this.fWF.setVisibility(0);
        this.dbf.stopPlayback();
        this.hGK.ra();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.j(this.hGL, d.C0277d.cp_btn_a);
            al.d(this.hGN, d.C0277d.cp_cont_g, 1);
            al.e(this.hGN, d.f.btn_video, 1);
            this.hGK.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.hGI;
    }

    public long getCurrentPosition() {
        return this.hGR;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cJH = aVar;
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
        this.hGT = f;
        this.hGU = f2;
    }

    public long getDuration() {
        if (this.dbf == null) {
            return this.hGH.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.hGH.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.hGS = j;
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
            this.hGJ.setVisibility(8);
            this.hGM.setPlayer(this.dbf);
            return;
        }
        this.hGM.setVisibility(8);
        this.hGM.destroy();
        this.hGJ.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.hGF != null && this.dbf != null) {
            if (!z) {
                if (this.hGG != null) {
                    this.hGG.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            os(true);
            if (this.hGO) {
                this.hGN.setVisibility(0);
            }
            this.UT = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hGF.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.hGF.getParent();
            viewGroup.removeAllViews();
            this.hGG = new a(bdBaseActivity.getActivity(), this.hGF, new ViewGroup.LayoutParams(-1, -1));
            this.hGG.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.hGF != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.os(false);
                        AutoPlayVideoView.this.hGN.setVisibility(8);
                        AutoPlayVideoView.this.UT = false;
                        ((ViewGroup) AutoPlayVideoView.this.hGF.getParent()).removeView(AutoPlayVideoView.this.hGF);
                        viewGroup.addView(AutoPlayVideoView.this.hGF);
                        AutoPlayVideoView.this.hGF.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.hGS = AutoPlayVideoView.this.hGR;
                        if (AutoPlayVideoView.this.hGP.getVisibility() != 0) {
                            AutoPlayVideoView.this.bPu();
                        }
                        AutoPlayVideoView.this.hGP.setVisibility(8);
                    }
                }
            });
            this.hGS = this.hGR;
            bPu();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.hGO = z;
    }
}
