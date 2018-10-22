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
    private ForeDrawableImageView euZ;
    private View evf;
    private a geA;
    private VideoInfo geB;
    private int geC;
    private RelativeLayout geD;
    private AudioAnimationView geE;
    private TextView geF;
    private PbChudianProcessBar geG;
    private TextView geH;
    private boolean geI;
    private View geJ;
    private View geK;
    private long geL;
    private long geM;
    private float geN;
    private float geO;
    private Bitmap geP;
    private MediaMetadataRetriever geQ;
    private Runnable geR;
    private View gez;
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
        this.geC = -1;
        this.bEK = false;
        this.geI = false;
        this.mOnClickListener = null;
        this.geL = 0L;
        this.geM = 0L;
        this.mDuration = 0L;
        this.geN = 1.0f;
        this.geO = 1.0f;
        this.geP = null;
        this.geQ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geC != 1) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geL = AutoPlayVideoView.this.geM;
                            AutoPlayVideoView.this.evf.setVisibility(8);
                            if (!AutoPlayVideoView.this.bJP.bpW() || AutoPlayVideoView.this.geP == null) {
                                AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geM);
                                AutoPlayVideoView.this.euZ.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bJN.getDuration();
                            AutoPlayVideoView.this.geC = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bEK) {
                                AutoPlayVideoView.this.geG.setVisibility(0);
                                AutoPlayVideoView.this.geG.n(AutoPlayVideoView.this.geM, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geG.bmr();
                                return;
                            }
                            AutoPlayVideoView.this.geE.pW();
                            AutoPlayVideoView.this.geE.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bEK) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bJN.getDuration() - AutoPlayVideoView.this.bJN.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geF.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.geC == 1) {
                            if (AutoPlayVideoView.this.geL == AutoPlayVideoView.this.bJN.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geL = AutoPlayVideoView.this.bJN.getCurrentPosition();
                                AutoPlayVideoView.this.aEH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bJN.isPlaying() && AutoPlayVideoView.this.bJP.bpW() && AutoPlayVideoView.this.geP != null) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() > AutoPlayVideoView.this.geM) {
                                AutoPlayVideoView.this.euZ.setVisibility(8);
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
                        if (AutoPlayVideoView.this.geQ == null) {
                            AutoPlayVideoView.this.geQ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geQ.setDataSource(AutoPlayVideoView.this.bJP.jg(AutoPlayVideoView.this.bJP.bpV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geP != null) {
                            AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geM);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geN, AutoPlayVideoView.this.geO);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geB;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEH();
                AutoPlayVideoView.this.geM = 0L;
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geJ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.geJ.setVisibility(8);
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
        this.geR = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geB != null && AutoPlayVideoView.this.bJN != null) {
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
        this.geC = -1;
        this.bEK = false;
        this.geI = false;
        this.mOnClickListener = null;
        this.geL = 0L;
        this.geM = 0L;
        this.mDuration = 0L;
        this.geN = 1.0f;
        this.geO = 1.0f;
        this.geP = null;
        this.geQ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geC != 1) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geL = AutoPlayVideoView.this.geM;
                            AutoPlayVideoView.this.evf.setVisibility(8);
                            if (!AutoPlayVideoView.this.bJP.bpW() || AutoPlayVideoView.this.geP == null) {
                                AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geM);
                                AutoPlayVideoView.this.euZ.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bJN.getDuration();
                            AutoPlayVideoView.this.geC = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bEK) {
                                AutoPlayVideoView.this.geG.setVisibility(0);
                                AutoPlayVideoView.this.geG.n(AutoPlayVideoView.this.geM, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geG.bmr();
                                return;
                            }
                            AutoPlayVideoView.this.geE.pW();
                            AutoPlayVideoView.this.geE.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bEK) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bJN.getDuration() - AutoPlayVideoView.this.bJN.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geF.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.geC == 1) {
                            if (AutoPlayVideoView.this.geL == AutoPlayVideoView.this.bJN.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geL = AutoPlayVideoView.this.bJN.getCurrentPosition();
                                AutoPlayVideoView.this.aEH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bJN.isPlaying() && AutoPlayVideoView.this.bJP.bpW() && AutoPlayVideoView.this.geP != null) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() > AutoPlayVideoView.this.geM) {
                                AutoPlayVideoView.this.euZ.setVisibility(8);
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
                        if (AutoPlayVideoView.this.geQ == null) {
                            AutoPlayVideoView.this.geQ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geQ.setDataSource(AutoPlayVideoView.this.bJP.jg(AutoPlayVideoView.this.bJP.bpV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geP != null) {
                            AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geM);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geN, AutoPlayVideoView.this.geO);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geB;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEH();
                AutoPlayVideoView.this.geM = 0L;
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geJ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.geJ.setVisibility(8);
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
        this.geR = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geB != null && AutoPlayVideoView.this.bJN != null) {
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
        this.geC = -1;
        this.bEK = false;
        this.geI = false;
        this.mOnClickListener = null;
        this.geL = 0L;
        this.geM = 0L;
        this.mDuration = 0L;
        this.geN = 1.0f;
        this.geO = 1.0f;
        this.geP = null;
        this.geQ = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geC != 1) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geL = AutoPlayVideoView.this.geM;
                            AutoPlayVideoView.this.evf.setVisibility(8);
                            if (!AutoPlayVideoView.this.bJP.bpW() || AutoPlayVideoView.this.geP == null) {
                                AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geM);
                                AutoPlayVideoView.this.euZ.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.bJN.getDuration();
                            AutoPlayVideoView.this.geC = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.bEK) {
                                AutoPlayVideoView.this.geG.setVisibility(0);
                                AutoPlayVideoView.this.geG.n(AutoPlayVideoView.this.geM, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geG.bmr();
                                return;
                            }
                            AutoPlayVideoView.this.geE.pW();
                            AutoPlayVideoView.this.geE.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.bEK) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.bJN.getDuration() - AutoPlayVideoView.this.bJN.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geF.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.geC == 1) {
                            if (AutoPlayVideoView.this.geL == AutoPlayVideoView.this.bJN.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geL = AutoPlayVideoView.this.bJN.getCurrentPosition();
                                AutoPlayVideoView.this.aEH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.bJN.isPlaying() && AutoPlayVideoView.this.bJP.bpW() && AutoPlayVideoView.this.geP != null) {
                            if (AutoPlayVideoView.this.bJN.getCurrentPosition() > AutoPlayVideoView.this.geM) {
                                AutoPlayVideoView.this.euZ.setVisibility(8);
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
                        if (AutoPlayVideoView.this.geQ == null) {
                            AutoPlayVideoView.this.geQ = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.geQ.setDataSource(AutoPlayVideoView.this.bJP.jg(AutoPlayVideoView.this.bJP.bpV()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.geP != null) {
                            AutoPlayVideoView.this.bJN.seekTo((int) AutoPlayVideoView.this.geM);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geN, AutoPlayVideoView.this.geO);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geB;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aEH();
                AutoPlayVideoView.this.geM = 0L;
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geJ.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), e.j.pb_play_error);
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(e.f.icon_play_video);
                    AutoPlayVideoView.this.geJ.setVisibility(8);
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
        this.geR = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geB != null && AutoPlayVideoView.this.bJN != null) {
                    AutoPlayVideoView.this.bmq();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(e.h.auto_play_video_view, (ViewGroup) this, true);
        this.gez = this.mRootView.findViewById(e.g.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(e.g.auto_video_black_mask);
        this.euZ = (ForeDrawableImageView) this.mRootView.findViewById(e.g.pb_list_video_item_thumbnail);
        this.evf = this.mRootView.findViewById(e.g.pb_layout_loading);
        this.geD = (RelativeLayout) this.mRootView.findViewById(e.g.process_bar);
        this.bJN = (QuickVideoView) this.mRootView.findViewById(e.g.texture_video_view);
        this.bJP = new n(this.mContext);
        this.bJN.setBusiness(this.bJP);
        this.geE = (AudioAnimationView) this.mRootView.findViewById(e.g.playing_animation);
        this.geF = (TextView) this.mRootView.findViewById(e.g.count_down_process);
        this.geG = (PbChudianProcessBar) this.mRootView.findViewById(e.g.full_screen_process_bar);
        this.geH = (TextView) this.mRootView.findViewById(e.g.check_detail);
        this.geH.setTag(e.g.tag_pb_chudian_check_detail, true);
        this.geJ = this.mRootView.findViewById(e.g.chudian_error_tip);
        this.geK = this.mRootView.findViewById(e.g.available_click_area);
    }

    private boolean bmp() {
        return q.bmp();
    }

    public void bmq() {
        if (bmp()) {
            this.bJN.setVideoPath(this.geB.video_url, this.beh);
            this.bJN.start();
            this.geC = 0;
            if (!this.bJP.bpW() || this.geP == null) {
                showLoading();
            }
            this.geJ.setVisibility(8);
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
        this.geB = videoInfo;
        this.beh = str;
        this.euZ.setDefaultErrorResource(0);
        this.euZ.setDefaultResource(0);
        this.euZ.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.euZ.setForegroundDrawable(e.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.euZ.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnErrorListener(this.bkN);
        if (this.bty != null) {
            this.bJN.setOnCompletionListener(this.bty);
        }
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        this.geE.setCertainColumnCount(4);
        this.geE.setColumnColor(e.d.cp_cont_i);
        this.geH.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.geK.getLayoutParams();
        int aO = l.aO(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            aO = ((aO * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.h(getContext(), e.C0175e.ds120);
        }
        layoutParams.height = aO;
        this.geK.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.euZ.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = aO;
        }
        this.euZ.setLayoutParams(layoutParams2);
        this.euZ.setOnClickListener(this.mOnClickListener);
        this.geK.setOnClickListener(this.mOnClickListener);
        this.geJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.bEK) {
                    AutoPlayVideoView.this.geA.dismiss();
                    AutoPlayVideoView.this.euZ.setForegroundDrawable(e.f.icon_play_video);
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
        this.geG.destroy();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.geR);
        if (this.bJN.isPlaying()) {
            this.geL = this.bJN.getCurrentPosition();
            if (this.bJP.bpW() && this.geQ != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.geQ.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.geL), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.geB.video_width.intValue() / frameAtTime.getWidth(), this.geB.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.geP;
                                    this.geP = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.euZ.setImageBitmap(this.geP);
                                    this.euZ.setForegroundDrawable(0);
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
                                this.geC = 3;
                                this.euZ.setVisibility(0);
                                this.bJN.stopPlayback();
                                this.geE.pW();
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
        this.geC = 3;
        this.euZ.setVisibility(0);
        this.bJN.stopPlayback();
        this.geE.pW();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            al.h(this.geF, e.d.cp_cont_i);
            al.c(this.geH, e.d.cp_cont_g, 1);
            al.d(this.geH, e.f.btn_video, 1);
            this.geE.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.geC;
    }

    public long getCurrentPosition() {
        return this.geL;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bty = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.evf.setVisibility(0);
        this.euZ.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEH() {
        this.evf.setVisibility(8);
        this.euZ.setForegroundDrawable(e.f.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.geN = f;
        this.geO = f2;
    }

    public long getDuration() {
        if (this.bJN == null) {
            return this.geB.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.geB.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.geM = j;
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
            this.geD.setVisibility(8);
            this.geG.setPlayer(this.bJN);
            return;
        }
        this.geG.setVisibility(8);
        this.geG.destroy();
        this.geD.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.gez != null && this.bJN != null) {
            if (!z) {
                if (this.geA != null) {
                    this.geA.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            lE(true);
            if (this.geI) {
                this.geH.setVisibility(0);
            }
            this.bEK = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gez.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.gez.getParent();
            viewGroup.removeAllViews();
            this.geA = new a(bdBaseActivity.getActivity(), this.gez, new ViewGroup.LayoutParams(-1, -1));
            this.geA.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.gez != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.lE(false);
                        AutoPlayVideoView.this.geH.setVisibility(8);
                        AutoPlayVideoView.this.bEK = false;
                        ((ViewGroup) AutoPlayVideoView.this.gez.getParent()).removeView(AutoPlayVideoView.this.gez);
                        viewGroup.addView(AutoPlayVideoView.this.gez);
                        AutoPlayVideoView.this.gez.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.geM = AutoPlayVideoView.this.geL;
                        if (AutoPlayVideoView.this.geJ.getVisibility() != 0) {
                            AutoPlayVideoView.this.bmq();
                        }
                        AutoPlayVideoView.this.geJ.setVisibility(8);
                    }
                }
            });
            this.geM = this.geL;
            bmq();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.geI = z;
    }
}
