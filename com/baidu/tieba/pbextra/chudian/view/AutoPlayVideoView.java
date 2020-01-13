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
/* loaded from: classes7.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean EA;
    private String OG;
    private g.b dIa;
    private QuickVideoView.b dIe;
    private g.a dQW;
    private g.f dQX;
    private QuickVideoView egS;
    private n egU;
    private ForeDrawableImageView hlG;
    private View hlM;
    private a jbA;
    private VideoInfo jbB;
    private int jbC;
    private RelativeLayout jbD;
    private AudioAnimationView jbE;
    private TextView jbF;
    private PbChudianProcessBar jbG;
    private TextView jbH;
    private boolean jbI;
    private View jbJ;
    private View jbK;
    private long jbL;
    private long jbM;
    private float jbN;
    private float jbO;
    private Bitmap jbP;
    private MediaMetadataRetriever jbQ;
    private Runnable jbR;
    private View jbz;
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
        this.jbC = -1;
        this.EA = false;
        this.jbI = false;
        this.mOnClickListener = null;
        this.jbL = 0L;
        this.jbM = 0L;
        this.mDuration = 0L;
        this.jbN = 1.0f;
        this.jbO = 1.0f;
        this.jbP = null;
        this.jbQ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.jbC != 1) {
                            if (AutoPlayVideoView.this.egS.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.jbL = AutoPlayVideoView.this.jbM;
                            AutoPlayVideoView.this.hlM.setVisibility(8);
                            if (!AutoPlayVideoView.this.egU.cxb() || AutoPlayVideoView.this.jbP == null) {
                                AutoPlayVideoView.this.egS.seekTo((int) AutoPlayVideoView.this.jbM);
                                AutoPlayVideoView.this.hlG.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.egS.getDuration();
                            AutoPlayVideoView.this.jbC = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.EA) {
                                AutoPlayVideoView.this.jbG.setVisibility(0);
                                AutoPlayVideoView.this.jbG.E(AutoPlayVideoView.this.jbM, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.jbG.csN();
                                return;
                            }
                            AutoPlayVideoView.this.jbE.lD();
                            AutoPlayVideoView.this.jbE.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.EA) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.egS.getDuration() - AutoPlayVideoView.this.egS.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.jbF.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.jbC == 1) {
                            if (AutoPlayVideoView.this.jbL == AutoPlayVideoView.this.egS.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.jbL = AutoPlayVideoView.this.egS.getCurrentPosition();
                                AutoPlayVideoView.this.hideLoading();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.egS.isPlaying() && AutoPlayVideoView.this.egU.cxb() && AutoPlayVideoView.this.jbP != null) {
                            if (AutoPlayVideoView.this.egS.getCurrentPosition() > AutoPlayVideoView.this.jbM) {
                                AutoPlayVideoView.this.hlG.setVisibility(8);
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
        this.dQX = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.egS != null && AutoPlayVideoView.this.egU.cxb()) {
                        if (AutoPlayVideoView.this.jbQ == null) {
                            AutoPlayVideoView.this.jbQ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.jbQ.setDataSource(AutoPlayVideoView.this.egU.wk(AutoPlayVideoView.this.egU.cwZ()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.jbP != null) {
                            AutoPlayVideoView.this.egS.seekTo((int) AutoPlayVideoView.this.jbM);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.jbN, AutoPlayVideoView.this.jbO);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.jbB;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.hideLoading();
                AutoPlayVideoView.this.jbM = 0L;
                if (AutoPlayVideoView.this.EA) {
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(0);
                    AutoPlayVideoView.this.jbJ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.jbJ.setVisibility(8);
                }
                return true;
            }
        };
        this.dQW = null;
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.jbR = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.jbB != null && AutoPlayVideoView.this.egS != null) {
                    AutoPlayVideoView.this.csM();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.jbC = -1;
        this.EA = false;
        this.jbI = false;
        this.mOnClickListener = null;
        this.jbL = 0L;
        this.jbM = 0L;
        this.mDuration = 0L;
        this.jbN = 1.0f;
        this.jbO = 1.0f;
        this.jbP = null;
        this.jbQ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.jbC != 1) {
                            if (AutoPlayVideoView.this.egS.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.jbL = AutoPlayVideoView.this.jbM;
                            AutoPlayVideoView.this.hlM.setVisibility(8);
                            if (!AutoPlayVideoView.this.egU.cxb() || AutoPlayVideoView.this.jbP == null) {
                                AutoPlayVideoView.this.egS.seekTo((int) AutoPlayVideoView.this.jbM);
                                AutoPlayVideoView.this.hlG.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.egS.getDuration();
                            AutoPlayVideoView.this.jbC = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.EA) {
                                AutoPlayVideoView.this.jbG.setVisibility(0);
                                AutoPlayVideoView.this.jbG.E(AutoPlayVideoView.this.jbM, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.jbG.csN();
                                return;
                            }
                            AutoPlayVideoView.this.jbE.lD();
                            AutoPlayVideoView.this.jbE.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.EA) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.egS.getDuration() - AutoPlayVideoView.this.egS.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.jbF.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.jbC == 1) {
                            if (AutoPlayVideoView.this.jbL == AutoPlayVideoView.this.egS.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.jbL = AutoPlayVideoView.this.egS.getCurrentPosition();
                                AutoPlayVideoView.this.hideLoading();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.egS.isPlaying() && AutoPlayVideoView.this.egU.cxb() && AutoPlayVideoView.this.jbP != null) {
                            if (AutoPlayVideoView.this.egS.getCurrentPosition() > AutoPlayVideoView.this.jbM) {
                                AutoPlayVideoView.this.hlG.setVisibility(8);
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
        this.dQX = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.egS != null && AutoPlayVideoView.this.egU.cxb()) {
                        if (AutoPlayVideoView.this.jbQ == null) {
                            AutoPlayVideoView.this.jbQ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.jbQ.setDataSource(AutoPlayVideoView.this.egU.wk(AutoPlayVideoView.this.egU.cwZ()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.jbP != null) {
                            AutoPlayVideoView.this.egS.seekTo((int) AutoPlayVideoView.this.jbM);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.jbN, AutoPlayVideoView.this.jbO);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.jbB;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.hideLoading();
                AutoPlayVideoView.this.jbM = 0L;
                if (AutoPlayVideoView.this.EA) {
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(0);
                    AutoPlayVideoView.this.jbJ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.jbJ.setVisibility(8);
                }
                return true;
            }
        };
        this.dQW = null;
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.jbR = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.jbB != null && AutoPlayVideoView.this.egS != null) {
                    AutoPlayVideoView.this.csM();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.jbC = -1;
        this.EA = false;
        this.jbI = false;
        this.mOnClickListener = null;
        this.jbL = 0L;
        this.jbM = 0L;
        this.mDuration = 0L;
        this.jbN = 1.0f;
        this.jbO = 1.0f;
        this.jbP = null;
        this.jbQ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.jbC != 1) {
                            if (AutoPlayVideoView.this.egS.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.jbL = AutoPlayVideoView.this.jbM;
                            AutoPlayVideoView.this.hlM.setVisibility(8);
                            if (!AutoPlayVideoView.this.egU.cxb() || AutoPlayVideoView.this.jbP == null) {
                                AutoPlayVideoView.this.egS.seekTo((int) AutoPlayVideoView.this.jbM);
                                AutoPlayVideoView.this.hlG.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.egS.getDuration();
                            AutoPlayVideoView.this.jbC = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.EA) {
                                AutoPlayVideoView.this.jbG.setVisibility(0);
                                AutoPlayVideoView.this.jbG.E(AutoPlayVideoView.this.jbM, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.jbG.csN();
                                return;
                            }
                            AutoPlayVideoView.this.jbE.lD();
                            AutoPlayVideoView.this.jbE.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.EA) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.egS.getDuration() - AutoPlayVideoView.this.egS.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.jbF.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.jbC == 1) {
                            if (AutoPlayVideoView.this.jbL == AutoPlayVideoView.this.egS.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.jbL = AutoPlayVideoView.this.egS.getCurrentPosition();
                                AutoPlayVideoView.this.hideLoading();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.egS.isPlaying() && AutoPlayVideoView.this.egU.cxb() && AutoPlayVideoView.this.jbP != null) {
                            if (AutoPlayVideoView.this.egS.getCurrentPosition() > AutoPlayVideoView.this.jbM) {
                                AutoPlayVideoView.this.hlG.setVisibility(8);
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
        this.dQX = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.egS != null && AutoPlayVideoView.this.egU.cxb()) {
                        if (AutoPlayVideoView.this.jbQ == null) {
                            AutoPlayVideoView.this.jbQ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.jbQ.setDataSource(AutoPlayVideoView.this.egU.wk(AutoPlayVideoView.this.egU.cwZ()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.jbP != null) {
                            AutoPlayVideoView.this.egS.seekTo((int) AutoPlayVideoView.this.jbM);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.jbN, AutoPlayVideoView.this.jbO);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.jbB;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.hideLoading();
                AutoPlayVideoView.this.jbM = 0L;
                if (AutoPlayVideoView.this.EA) {
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(0);
                    AutoPlayVideoView.this.jbJ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.jbJ.setVisibility(8);
                }
                return true;
            }
        };
        this.dQW = null;
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.jbR = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.jbB != null && AutoPlayVideoView.this.egS != null) {
                    AutoPlayVideoView.this.csM();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.jbz = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.hlG = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.hlM = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.jbD = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.egS = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.egU = new n(this.mContext);
        this.egS.setBusiness(this.egU);
        this.jbE = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.jbF = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.jbG = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.jbH = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.jbH.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.jbJ = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.jbK = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean csL() {
        return s.csL();
    }

    public void csM() {
        if (csL()) {
            this.egS.setVideoPath(this.jbB.video_url, this.OG);
            this.egS.start();
            this.jbC = 0;
            if (!this.egU.cxb() || this.jbP == null) {
                showLoading();
            }
            this.jbJ.setVisibility(8);
            qZ(this.EA);
            return;
        }
        hideLoading();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jbB = videoInfo;
        this.OG = str;
        this.hlG.setDefaultErrorResource(0);
        this.hlG.setDefaultResource(0);
        this.hlG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hlG.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hlG.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.egS.setOnPreparedListener(this.dQX);
        this.egS.setOnErrorListener(this.dIa);
        if (this.dQW != null) {
            this.egS.setOnCompletionListener(this.dQW);
        }
        this.egS.setOnSurfaceDestroyedListener(this.dIe);
        this.jbE.setCertainColumnCount(4);
        this.jbE.setColumnColor(R.color.cp_cont_a);
        this.jbH.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jbK.getLayoutParams();
        int equipmentWidth = l.getEquipmentWidth(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            equipmentWidth = ((equipmentWidth * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.getDimens(getContext(), R.dimen.ds120);
        }
        layoutParams.height = equipmentWidth;
        this.jbK.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hlG.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = equipmentWidth;
        }
        this.hlG.setLayoutParams(layoutParams2);
        this.hlG.setOnClickListener(this.mOnClickListener);
        this.jbK.setOnClickListener(this.mOnClickListener);
        this.jbJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.EA) {
                    AutoPlayVideoView.this.jbA.dismiss();
                    AutoPlayVideoView.this.hlG.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.jbG.destroy();
        e.gx().removeCallbacks(this.jbR);
        if (this.egS.isPlaying()) {
            this.jbL = this.egS.getCurrentPosition();
            if (this.egU.cxb() && this.jbQ != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.jbQ.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.jbL), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.jbB.video_width.intValue() / frameAtTime.getWidth(), this.jbB.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.jbP;
                                    this.jbP = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.hlG.setImageBitmap(this.jbP);
                                    this.hlG.setForegroundDrawable(0);
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
                                this.jbC = 3;
                                this.hlG.setVisibility(0);
                                this.egS.stopPlayback();
                                this.jbE.lD();
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
        this.jbC = 3;
        this.hlG.setVisibility(0);
        this.egS.stopPlayback();
        this.jbE.lD();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.jbF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.jbH, R.color.cp_cont_g, 1);
            am.setBackgroundResource(this.jbH, R.drawable.btn_video, 1);
            this.jbE.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.jbC;
    }

    public long getCurrentPosition() {
        return this.jbL;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.dQW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.hlM.setVisibility(0);
        this.hlG.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        this.hlM.setVisibility(8);
        this.hlG.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.jbN = f;
        this.jbO = f2;
    }

    public long getDuration() {
        if (this.egS == null) {
            return this.jbB.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.jbB.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.jbM = j;
    }

    /* loaded from: classes7.dex */
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
    public void qZ(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.jbD.setVisibility(8);
            this.jbG.setPlayer(this.egS);
            return;
        }
        this.jbG.setVisibility(8);
        this.jbG.destroy();
        this.jbD.setVisibility(0);
    }

    public void setFullScreen(TbPageContext tbPageContext, boolean z) {
        if (this.jbz != null && this.egS != null) {
            if (!z) {
                if (this.jbA != null) {
                    this.jbA.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            qZ(true);
            if (this.jbI) {
                this.jbH.setVisibility(0);
            }
            this.EA = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jbz.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.jbz.getParent();
            viewGroup.removeAllViews();
            this.jbA = new a(tbPageContext.getPageActivity(), this.jbz, new ViewGroup.LayoutParams(-1, -1));
            this.jbA.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.jbz != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.qZ(false);
                        AutoPlayVideoView.this.jbH.setVisibility(8);
                        AutoPlayVideoView.this.EA = false;
                        ((ViewGroup) AutoPlayVideoView.this.jbz.getParent()).removeView(AutoPlayVideoView.this.jbz);
                        viewGroup.addView(AutoPlayVideoView.this.jbz);
                        AutoPlayVideoView.this.jbz.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.jbM = AutoPlayVideoView.this.jbL;
                        if (AutoPlayVideoView.this.jbJ.getVisibility() != 0) {
                            AutoPlayVideoView.this.csM();
                        }
                        AutoPlayVideoView.this.jbJ.setVisibility(8);
                    }
                }
            });
            this.jbM = this.jbL;
            csM();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.jbI = z;
    }
}
