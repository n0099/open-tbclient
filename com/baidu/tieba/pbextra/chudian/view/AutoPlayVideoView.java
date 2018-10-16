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
    private boolean bEK;
    private QuickVideoView bJN;
    private n bJP;
    private String beh;
    private g.b bkN;
    private QuickVideoView.b bkR;
    private g.a bty;
    private g.f btz;
    private ForeDrawableImageView euY;
    private View eve;
    private VideoInfo geA;
    private int geB;
    private RelativeLayout geC;
    private AudioAnimationView geD;
    private TextView geE;
    private PbChudianProcessBar geF;
    private TextView geG;
    private boolean geH;
    private View geI;
    private View geJ;
    private long geK;
    private long geL;
    private float geM;
    private float geN;
    private Bitmap geO;
    private MediaMetadataRetriever geP;
    private Runnable geQ;
    private View gey;
    private a gez;
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
        this.geB = -1;
        this.bEK = false;
        this.geH = false;
        this.mOnClickListener = null;
        this.geK = 0L;
        this.geL = 0L;
        this.mDuration = 0L;
        this.geM = 1.0f;
        this.geN = 1.0f;
        this.geO = null;
        this.geP = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geB != 1) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geK = AutoPlayVideoView.this.geL;
                            AutoPlayVideoView.this.eve.setVisibility(8);
                            if (!AutoPlayVideoView.this.bJP.bpW() || AutoPlayVideoView.this.geO == null) {
                                AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geL);
                                AutoPlayVideoView.this.euY.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bJN.getDuration();
                            AutoPlayVideoView.this.geB = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bEK) {
                                AutoPlayVideoView.this.geF.setVisibility(0);
                                AutoPlayVideoView.this.geF.n(AutoPlayVideoView.this.geL, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geF.bmr();
                                return;
                            }
                            AutoPlayVideoView.this.geD.pW();
                            AutoPlayVideoView.this.geD.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bEK) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bJN.getDuration() - AutoPlayVideoView.this.bJN.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geE.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.geB == 1) {
                            if (AutoPlayVideoView.this.geK == AutoPlayVideoView.this.bJN.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geK = AutoPlayVideoView.this.bJN.getCurrentPosition();
                                AutoPlayVideoView.this.aEH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bJN.isPlaying() && AutoPlayVideoView.this.bJP.bpW() && AutoPlayVideoView.this.geO != null) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() > AutoPlayVideoView.this.geL) {
                                AutoPlayVideoView.this.euY.setVisibility(8);
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
        this.btz = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bJN != null && AutoPlayVideoView.this.bJP.bpW()) {
                        if (AutoPlayVideoView.this.geP == null) {
                            AutoPlayVideoView.this.geP = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geP.setDataSource(AutoPlayVideoView.this.bJP.jg(AutoPlayVideoView.this.bJP.bpV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geO != null) {
                            AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geL);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geM, AutoPlayVideoView.this.geN);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geA;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEH();
                AutoPlayVideoView.this.geL = 0L;
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.euY.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geI.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.euY.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.geI.setVisibility(8);
                }
                return true;
            }
        };
        this.bty = null;
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geQ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geA != null && AutoPlayVideoView.this.bJN != null) {
                    AutoPlayVideoView.this.bmq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.geB = -1;
        this.bEK = false;
        this.geH = false;
        this.mOnClickListener = null;
        this.geK = 0L;
        this.geL = 0L;
        this.mDuration = 0L;
        this.geM = 1.0f;
        this.geN = 1.0f;
        this.geO = null;
        this.geP = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geB != 1) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geK = AutoPlayVideoView.this.geL;
                            AutoPlayVideoView.this.eve.setVisibility(8);
                            if (!AutoPlayVideoView.this.bJP.bpW() || AutoPlayVideoView.this.geO == null) {
                                AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geL);
                                AutoPlayVideoView.this.euY.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bJN.getDuration();
                            AutoPlayVideoView.this.geB = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bEK) {
                                AutoPlayVideoView.this.geF.setVisibility(0);
                                AutoPlayVideoView.this.geF.n(AutoPlayVideoView.this.geL, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geF.bmr();
                                return;
                            }
                            AutoPlayVideoView.this.geD.pW();
                            AutoPlayVideoView.this.geD.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bEK) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bJN.getDuration() - AutoPlayVideoView.this.bJN.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geE.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.geB == 1) {
                            if (AutoPlayVideoView.this.geK == AutoPlayVideoView.this.bJN.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geK = AutoPlayVideoView.this.bJN.getCurrentPosition();
                                AutoPlayVideoView.this.aEH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bJN.isPlaying() && AutoPlayVideoView.this.bJP.bpW() && AutoPlayVideoView.this.geO != null) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() > AutoPlayVideoView.this.geL) {
                                AutoPlayVideoView.this.euY.setVisibility(8);
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
        this.btz = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bJN != null && AutoPlayVideoView.this.bJP.bpW()) {
                        if (AutoPlayVideoView.this.geP == null) {
                            AutoPlayVideoView.this.geP = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geP.setDataSource(AutoPlayVideoView.this.bJP.jg(AutoPlayVideoView.this.bJP.bpV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geO != null) {
                            AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geL);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geM, AutoPlayVideoView.this.geN);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geA;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEH();
                AutoPlayVideoView.this.geL = 0L;
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.euY.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geI.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.euY.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.geI.setVisibility(8);
                }
                return true;
            }
        };
        this.bty = null;
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geQ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geA != null && AutoPlayVideoView.this.bJN != null) {
                    AutoPlayVideoView.this.bmq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.geB = -1;
        this.bEK = false;
        this.geH = false;
        this.mOnClickListener = null;
        this.geK = 0L;
        this.geL = 0L;
        this.mDuration = 0L;
        this.geM = 1.0f;
        this.geN = 1.0f;
        this.geO = null;
        this.geP = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geB != 1) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geK = AutoPlayVideoView.this.geL;
                            AutoPlayVideoView.this.eve.setVisibility(8);
                            if (!AutoPlayVideoView.this.bJP.bpW() || AutoPlayVideoView.this.geO == null) {
                                AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geL);
                                AutoPlayVideoView.this.euY.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bJN.getDuration();
                            AutoPlayVideoView.this.geB = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bEK) {
                                AutoPlayVideoView.this.geF.setVisibility(0);
                                AutoPlayVideoView.this.geF.n(AutoPlayVideoView.this.geL, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geF.bmr();
                                return;
                            }
                            AutoPlayVideoView.this.geD.pW();
                            AutoPlayVideoView.this.geD.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bEK) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bJN.getDuration() - AutoPlayVideoView.this.bJN.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geE.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.geB == 1) {
                            if (AutoPlayVideoView.this.geK == AutoPlayVideoView.this.bJN.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geK = AutoPlayVideoView.this.bJN.getCurrentPosition();
                                AutoPlayVideoView.this.aEH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bJN.isPlaying() && AutoPlayVideoView.this.bJP.bpW() && AutoPlayVideoView.this.geO != null) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() > AutoPlayVideoView.this.geL) {
                                AutoPlayVideoView.this.euY.setVisibility(8);
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
        this.btz = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.bJN != null && AutoPlayVideoView.this.bJP.bpW()) {
                        if (AutoPlayVideoView.this.geP == null) {
                            AutoPlayVideoView.this.geP = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geP.setDataSource(AutoPlayVideoView.this.bJP.jg(AutoPlayVideoView.this.bJP.bpV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geO != null) {
                            AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geL);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geM, AutoPlayVideoView.this.geN);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geA;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEH();
                AutoPlayVideoView.this.geL = 0L;
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.euY.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geI.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.euY.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.geI.setVisibility(8);
                }
                return true;
            }
        };
        this.bty = null;
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.geQ = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geA != null && AutoPlayVideoView.this.bJN != null) {
                    AutoPlayVideoView.this.bmq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gey = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.euY = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.eve = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.geC = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bJN = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bJP = new n(this.mContext);
        this.bJN.setBusiness(this.bJP);
        this.geD = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.geE = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.geF = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.geG = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.geG.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.geI = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.geJ = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean bmp() {
        return q.bmp();
    }

    public void bmq() {
        if (bmp()) {
            this.bJN.setVideoPath(this.geA.video_url, this.beh);
            this.bJN.start();
            this.geB = 0;
            if (!this.bJP.bpW() || this.geO == null) {
                showLoading();
            }
            this.geI.setVisibility(8);
            lE(this.bEK);
            return;
        }
        aEH();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geA = videoInfo;
        this.beh = str;
        this.euY.setDefaultErrorResource(0);
        this.euY.setDefaultResource(0);
        this.euY.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.euY.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.euY.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnErrorListener(this.bkN);
        if (this.bty != null) {
            this.bJN.setOnCompletionListener(this.bty);
        }
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        this.geD.setCertainColumnCount(4);
        this.geD.setColumnColor(e.d.cp_cont_i);
        this.geG.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.geJ.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0175e.ds120);
        }
        layoutParams.height = aO;
        this.geJ.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.euY.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.euY.setLayoutParams(layoutParams2);
        this.euY.setOnClickListener(this.mOnClickListener);
        this.geJ.setOnClickListener(this.mOnClickListener);
        this.geI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.gez.dismiss();
                    AutoPlayVideoView.this.euY.setForegroundDrawable(e.f.icon_play_video);
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
        this.geF.destroy();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.geQ);
        if (this.bJN.isPlaying()) {
            this.geK = this.bJN.getCurrentPosition();
            if (this.bJP.bpW() && this.geP != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.geP.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.geK), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.geA.video_width.intValue() / frameAtTime.getWidth(), this.geA.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.geO;
                                    this.geO = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.euY.setImageBitmap(this.geO);
                                    this.euY.setForegroundDrawable(0);
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
                                this.geB = 3;
                                this.euY.setVisibility(0);
                                this.bJN.stopPlayback();
                                this.geD.pW();
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
        this.geB = 3;
        this.euY.setVisibility(0);
        this.bJN.stopPlayback();
        this.geD.pW();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.geE, e.d.cp_cont_i);
            al.c(this.geG, e.d.cp_cont_g, 1);
            al.d(this.geG, e.f.btn_video, 1);
            this.geD.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.geB;
    }

    public long getCurrentPosition() {
        return this.geK;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bty = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eve.setVisibility(0);
        this.euY.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEH() {
        this.eve.setVisibility(8);
        this.euY.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.geM = f;
        this.geN = f2;
    }

    public long getDuration() {
        if (this.bJN == null) {
            return this.geA.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.geA.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.geL = j;
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
    public void lE(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.geC.setVisibility(8);
            this.geF.setPlayer(this.bJN);
            return;
        }
        this.geF.setVisibility(8);
        this.geF.destroy();
        this.geC.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gey != null && this.bJN != null) {
            if (!z) {
                if (this.gez != null) {
                    this.gez.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lE(true);
            if (this.geH) {
                this.geG.setVisibility(0);
            }
            this.bEK = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gey.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gey.getParent();
            viewGroup.removeAllViews();
            this.gez = new a(bdBaseActivity.getActivity(), this.gey, new ViewGroup.LayoutParams(-1, -1));
            this.gez.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gey != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lE(false);
                        AutoPlayVideoView.this.geG.setVisibility(8);
                        AutoPlayVideoView.this.bEK = false;
                        ((ViewGroup) AutoPlayVideoView.this.gey.getParent()).removeView(AutoPlayVideoView.this.gey);
                        viewGroup.addView(AutoPlayVideoView.this.gey);
                        AutoPlayVideoView.this.gey.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.geL = AutoPlayVideoView.this.geK;
                        if (AutoPlayVideoView.this.geI.getVisibility() != 0) {
                            AutoPlayVideoView.this.bmq();
                        }
                        AutoPlayVideoView.this.geI.setVisibility(8);
                    }
                }
            });
            this.geL = this.geK;
            bmq();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.geH = z;
    }
}
