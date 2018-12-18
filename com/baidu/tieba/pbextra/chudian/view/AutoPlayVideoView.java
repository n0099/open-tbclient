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
    private boolean bIZ;
    private QuickVideoView bOn;
    private n bOp;
    private String biw;
    private g.b boW;
    private QuickVideoView.b bpa;
    private g.a bxI;
    private g.f bxJ;
    private ForeDrawableImageView eDk;
    private View eDq;
    private View gmM;
    private a gmN;
    private VideoInfo gmO;
    private int gmP;
    private RelativeLayout gmQ;
    private AudioAnimationView gmR;
    private TextView gmS;
    private PbChudianProcessBar gmT;
    private TextView gmU;
    private boolean gmV;
    private View gmW;
    private View gmX;
    private long gmY;
    private long gmZ;
    private float gna;
    private float gnb;
    private Bitmap gnc;
    private MediaMetadataRetriever gnd;
    private Runnable gne;
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
        this.gmP = -1;
        this.bIZ = false;
        this.gmV = false;
        this.mOnClickListener = null;
        this.gmY = 0L;
        this.gmZ = 0L;
        this.mDuration = 0L;
        this.gna = 1.0f;
        this.gnb = 1.0f;
        this.gnc = null;
        this.gnd = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gmP != 1) {
                            if (AutoPlayVideoView.this.bOn.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gmY = AutoPlayVideoView.this.gmZ;
                            AutoPlayVideoView.this.eDq.setVisibility(8);
                            if (!AutoPlayVideoView.this.bOp.brk() || AutoPlayVideoView.this.gnc == null) {
                                AutoPlayVideoView.this.bOn.seekTo((int) AutoPlayVideoView.this.gmZ);
                                AutoPlayVideoView.this.eDk.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bOn.getDuration();
                            AutoPlayVideoView.this.gmP = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bIZ) {
                                AutoPlayVideoView.this.gmT.setVisibility(0);
                                AutoPlayVideoView.this.gmT.m(AutoPlayVideoView.this.gmZ, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gmT.bnF();
                                return;
                            }
                            AutoPlayVideoView.this.gmR.pT();
                            AutoPlayVideoView.this.gmR.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bIZ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bOn.getDuration() - AutoPlayVideoView.this.bOn.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gmS.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gmP == 1) {
                            if (AutoPlayVideoView.this.gmY == AutoPlayVideoView.this.bOn.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gmY = AutoPlayVideoView.this.bOn.getCurrentPosition();
                                AutoPlayVideoView.this.aFP();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bOn.isPlaying() && AutoPlayVideoView.this.bOp.brk() && AutoPlayVideoView.this.gnc != null) {
                            if (AutoPlayVideoView.this.bOn.getCurrentPosition() > AutoPlayVideoView.this.gmZ) {
                                AutoPlayVideoView.this.eDk.setVisibility(8);
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
        this.bxJ = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bOn != null && AutoPlayVideoView.this.bOp.brk()) {
                        if (AutoPlayVideoView.this.gnd == null) {
                            AutoPlayVideoView.this.gnd = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gnd.setDataSource(AutoPlayVideoView.this.bOp.jA(AutoPlayVideoView.this.bOp.brj()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gnc != null) {
                            AutoPlayVideoView.this.bOn.seekTo((int) AutoPlayVideoView.this.gmZ);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gna, AutoPlayVideoView.this.gnb);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gmO;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aFP();
                AutoPlayVideoView.this.gmZ = 0L;
                if (AutoPlayVideoView.this.bIZ) {
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gmW.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gmW.setVisibility(8);
                }
                return true;
            }
        };
        this.bxI = null;
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gne = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gmO != null && AutoPlayVideoView.this.bOn != null) {
                    AutoPlayVideoView.this.bnE();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.gmP = -1;
        this.bIZ = false;
        this.gmV = false;
        this.mOnClickListener = null;
        this.gmY = 0L;
        this.gmZ = 0L;
        this.mDuration = 0L;
        this.gna = 1.0f;
        this.gnb = 1.0f;
        this.gnc = null;
        this.gnd = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gmP != 1) {
                            if (AutoPlayVideoView.this.bOn.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gmY = AutoPlayVideoView.this.gmZ;
                            AutoPlayVideoView.this.eDq.setVisibility(8);
                            if (!AutoPlayVideoView.this.bOp.brk() || AutoPlayVideoView.this.gnc == null) {
                                AutoPlayVideoView.this.bOn.seekTo((int) AutoPlayVideoView.this.gmZ);
                                AutoPlayVideoView.this.eDk.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bOn.getDuration();
                            AutoPlayVideoView.this.gmP = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bIZ) {
                                AutoPlayVideoView.this.gmT.setVisibility(0);
                                AutoPlayVideoView.this.gmT.m(AutoPlayVideoView.this.gmZ, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gmT.bnF();
                                return;
                            }
                            AutoPlayVideoView.this.gmR.pT();
                            AutoPlayVideoView.this.gmR.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bIZ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bOn.getDuration() - AutoPlayVideoView.this.bOn.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gmS.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gmP == 1) {
                            if (AutoPlayVideoView.this.gmY == AutoPlayVideoView.this.bOn.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gmY = AutoPlayVideoView.this.bOn.getCurrentPosition();
                                AutoPlayVideoView.this.aFP();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bOn.isPlaying() && AutoPlayVideoView.this.bOp.brk() && AutoPlayVideoView.this.gnc != null) {
                            if (AutoPlayVideoView.this.bOn.getCurrentPosition() > AutoPlayVideoView.this.gmZ) {
                                AutoPlayVideoView.this.eDk.setVisibility(8);
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
        this.bxJ = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bOn != null && AutoPlayVideoView.this.bOp.brk()) {
                        if (AutoPlayVideoView.this.gnd == null) {
                            AutoPlayVideoView.this.gnd = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gnd.setDataSource(AutoPlayVideoView.this.bOp.jA(AutoPlayVideoView.this.bOp.brj()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gnc != null) {
                            AutoPlayVideoView.this.bOn.seekTo((int) AutoPlayVideoView.this.gmZ);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gna, AutoPlayVideoView.this.gnb);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gmO;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aFP();
                AutoPlayVideoView.this.gmZ = 0L;
                if (AutoPlayVideoView.this.bIZ) {
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gmW.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gmW.setVisibility(8);
                }
                return true;
            }
        };
        this.bxI = null;
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gne = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gmO != null && AutoPlayVideoView.this.bOn != null) {
                    AutoPlayVideoView.this.bnE();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gmP = -1;
        this.bIZ = false;
        this.gmV = false;
        this.mOnClickListener = null;
        this.gmY = 0L;
        this.gmZ = 0L;
        this.mDuration = 0L;
        this.gna = 1.0f;
        this.gnb = 1.0f;
        this.gnc = null;
        this.gnd = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.gmP != 1) {
                            if (AutoPlayVideoView.this.bOn.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.gmY = AutoPlayVideoView.this.gmZ;
                            AutoPlayVideoView.this.eDq.setVisibility(8);
                            if (!AutoPlayVideoView.this.bOp.brk() || AutoPlayVideoView.this.gnc == null) {
                                AutoPlayVideoView.this.bOn.seekTo((int) AutoPlayVideoView.this.gmZ);
                                AutoPlayVideoView.this.eDk.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bOn.getDuration();
                            AutoPlayVideoView.this.gmP = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bIZ) {
                                AutoPlayVideoView.this.gmT.setVisibility(0);
                                AutoPlayVideoView.this.gmT.m(AutoPlayVideoView.this.gmZ, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.gmT.bnF();
                                return;
                            }
                            AutoPlayVideoView.this.gmR.pT();
                            AutoPlayVideoView.this.gmR.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bIZ) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bOn.getDuration() - AutoPlayVideoView.this.bOn.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.gmS.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.gmP == 1) {
                            if (AutoPlayVideoView.this.gmY == AutoPlayVideoView.this.bOn.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.gmY = AutoPlayVideoView.this.bOn.getCurrentPosition();
                                AutoPlayVideoView.this.aFP();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bOn.isPlaying() && AutoPlayVideoView.this.bOp.brk() && AutoPlayVideoView.this.gnc != null) {
                            if (AutoPlayVideoView.this.bOn.getCurrentPosition() > AutoPlayVideoView.this.gmZ) {
                                AutoPlayVideoView.this.eDk.setVisibility(8);
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
        this.bxJ = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bOn != null && AutoPlayVideoView.this.bOp.brk()) {
                        if (AutoPlayVideoView.this.gnd == null) {
                            AutoPlayVideoView.this.gnd = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gnd.setDataSource(AutoPlayVideoView.this.bOp.jA(AutoPlayVideoView.this.bOp.brj()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gnc != null) {
                            AutoPlayVideoView.this.bOn.seekTo((int) AutoPlayVideoView.this.gmZ);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.gna, AutoPlayVideoView.this.gnb);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.gmO;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aFP();
                AutoPlayVideoView.this.gmZ = 0L;
                if (AutoPlayVideoView.this.bIZ) {
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(0);
                    AutoPlayVideoView.this.gmW.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.gmW.setVisibility(8);
                }
                return true;
            }
        };
        this.bxI = null;
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gne = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.gmO != null && AutoPlayVideoView.this.bOn != null) {
                    AutoPlayVideoView.this.bnE();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gmM = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.eDk = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.eDq = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.gmQ = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bOn = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bOp = new n(this.mContext);
        this.bOn.setBusiness(this.bOp);
        this.gmR = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.gmS = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.gmT = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.gmU = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.gmU.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.gmW = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.gmX = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean bnD() {
        return q.bnD();
    }

    public void bnE() {
        if (bnD()) {
            this.bOn.setVideoPath(this.gmO.video_url, this.biw);
            this.bOn.start();
            this.gmP = 0;
            if (!this.bOp.brk() || this.gnc == null) {
                showLoading();
            }
            this.gmW.setVisibility(8);
            lS(this.bIZ);
            return;
        }
        aFP();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gmO = videoInfo;
        this.biw = str;
        this.eDk.setDefaultErrorResource(0);
        this.eDk.setDefaultResource(0);
        this.eDk.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eDk.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eDk.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bOn.setOnPreparedListener(this.bxJ);
        this.bOn.setOnErrorListener(this.boW);
        if (this.bxI != null) {
            this.bOn.setOnCompletionListener(this.bxI);
        }
        this.bOn.setOnSurfaceDestroyedListener(this.bpa);
        this.gmR.setCertainColumnCount(4);
        this.gmR.setColumnColor(e.d.cp_cont_i);
        this.gmU.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmX.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0210e.ds120);
        }
        layoutParams.height = aO;
        this.gmX.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eDk.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.eDk.setLayoutParams(layoutParams2);
        this.eDk.setOnClickListener(this.mOnClickListener);
        this.gmX.setOnClickListener(this.mOnClickListener);
        this.gmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bIZ) {
                    AutoPlayVideoView.this.gmN.dismiss();
                    AutoPlayVideoView.this.eDk.setForegroundDrawable(e.f.icon_play_video);
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
        this.gmT.destroy();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gne);
        if (this.bOn.isPlaying()) {
            this.gmY = this.bOn.getCurrentPosition();
            if (this.bOp.brk() && this.gnd != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.gnd.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.gmY), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.gmO.video_width.intValue() / frameAtTime.getWidth(), this.gmO.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.gnc;
                                    this.gnc = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.eDk.setImageBitmap(this.gnc);
                                    this.eDk.setForegroundDrawable(0);
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
                                this.gmP = 3;
                                this.eDk.setVisibility(0);
                                this.bOn.stopPlayback();
                                this.gmR.pT();
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
        this.gmP = 3;
        this.eDk.setVisibility(0);
        this.bOn.stopPlayback();
        this.gmR.pT();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.gmS, e.d.cp_cont_i);
            al.c(this.gmU, e.d.cp_cont_g, 1);
            al.d(this.gmU, e.f.btn_video, 1);
            this.gmR.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.gmP;
    }

    public long getCurrentPosition() {
        return this.gmY;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bxI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eDq.setVisibility(0);
        this.eDk.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFP() {
        this.eDq.setVisibility(8);
        this.eDk.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.gna = f;
        this.gnb = f2;
    }

    public long getDuration() {
        if (this.bOn == null) {
            return this.gmO.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.gmO.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.gmZ = j;
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
    public void lS(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.gmQ.setVisibility(8);
            this.gmT.setPlayer(this.bOn);
            return;
        }
        this.gmT.setVisibility(8);
        this.gmT.destroy();
        this.gmQ.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gmM != null && this.bOn != null) {
            if (!z) {
                if (this.gmN != null) {
                    this.gmN.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lS(true);
            if (this.gmV) {
                this.gmU.setVisibility(0);
            }
            this.bIZ = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmM.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gmM.getParent();
            viewGroup.removeAllViews();
            this.gmN = new a(bdBaseActivity.getActivity(), this.gmM, new ViewGroup.LayoutParams(-1, -1));
            this.gmN.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gmM != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lS(false);
                        AutoPlayVideoView.this.gmU.setVisibility(8);
                        AutoPlayVideoView.this.bIZ = false;
                        ((ViewGroup) AutoPlayVideoView.this.gmM.getParent()).removeView(AutoPlayVideoView.this.gmM);
                        viewGroup.addView(AutoPlayVideoView.this.gmM);
                        AutoPlayVideoView.this.gmM.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.gmZ = AutoPlayVideoView.this.gmY;
                        if (AutoPlayVideoView.this.gmW.getVisibility() != 0) {
                            AutoPlayVideoView.this.bnE();
                        }
                        AutoPlayVideoView.this.gmW.setVisibility(8);
                    }
                }
            });
            this.gmZ = this.gmY;
            bnE();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.gmV = z;
    }
}
