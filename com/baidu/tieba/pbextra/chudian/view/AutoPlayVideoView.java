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
/* loaded from: classes4.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean SY;
    private String bWU;
    private g.b cJZ;
    private QuickVideoView.b cKd;
    private g.a cTw;
    private g.f cTx;
    private QuickVideoView dnB;
    private n dnD;
    private ForeDrawableImageView gva;
    private View gvg;
    private View igc;
    private a igd;
    private VideoInfo ige;
    private int igf;
    private RelativeLayout igg;
    private AudioAnimationView igh;
    private TextView igi;
    private PbChudianProcessBar igj;
    private TextView igk;
    private boolean igl;
    private View igm;
    private View ign;
    private long igo;
    private long igp;
    private float igq;
    private float igr;
    private Bitmap igs;
    private MediaMetadataRetriever igt;
    private Runnable igu;
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
        this.igf = -1;
        this.SY = false;
        this.igl = false;
        this.mOnClickListener = null;
        this.igo = 0L;
        this.igp = 0L;
        this.mDuration = 0L;
        this.igq = 1.0f;
        this.igr = 1.0f;
        this.igs = null;
        this.igt = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.igf != 1) {
                            if (AutoPlayVideoView.this.dnB.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igo = AutoPlayVideoView.this.igp;
                            AutoPlayVideoView.this.gvg.setVisibility(8);
                            if (!AutoPlayVideoView.this.dnD.cek() || AutoPlayVideoView.this.igs == null) {
                                AutoPlayVideoView.this.dnB.seekTo((int) AutoPlayVideoView.this.igp);
                                AutoPlayVideoView.this.gva.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dnB.getDuration();
                            AutoPlayVideoView.this.igf = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SY) {
                                AutoPlayVideoView.this.igj.setVisibility(0);
                                AutoPlayVideoView.this.igj.t(AutoPlayVideoView.this.igp, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igj.caz();
                                return;
                            }
                            AutoPlayVideoView.this.igh.qr();
                            AutoPlayVideoView.this.igh.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SY) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dnB.getDuration() - AutoPlayVideoView.this.dnB.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.igi.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.igf == 1) {
                            if (AutoPlayVideoView.this.igo == AutoPlayVideoView.this.dnB.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igo = AutoPlayVideoView.this.dnB.getCurrentPosition();
                                AutoPlayVideoView.this.brb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dnB.isPlaying() && AutoPlayVideoView.this.dnD.cek() && AutoPlayVideoView.this.igs != null) {
                            if (AutoPlayVideoView.this.dnB.getCurrentPosition() > AutoPlayVideoView.this.igp) {
                                AutoPlayVideoView.this.gva.setVisibility(8);
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
        this.cTx = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dnB != null && AutoPlayVideoView.this.dnD.cek()) {
                        if (AutoPlayVideoView.this.igt == null) {
                            AutoPlayVideoView.this.igt = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.igt.setDataSource(AutoPlayVideoView.this.dnD.sc(AutoPlayVideoView.this.dnD.cej()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.igs != null) {
                            AutoPlayVideoView.this.dnB.seekTo((int) AutoPlayVideoView.this.igp);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igq, AutoPlayVideoView.this.igr);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ige;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.brb();
                AutoPlayVideoView.this.igp = 0L;
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.gva.setForegroundDrawable(0);
                    AutoPlayVideoView.this.igm.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gva.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.igm.setVisibility(8);
                }
                return true;
            }
        };
        this.cTw = null;
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ige != null && AutoPlayVideoView.this.dnB != null) {
                    AutoPlayVideoView.this.cay();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.igf = -1;
        this.SY = false;
        this.igl = false;
        this.mOnClickListener = null;
        this.igo = 0L;
        this.igp = 0L;
        this.mDuration = 0L;
        this.igq = 1.0f;
        this.igr = 1.0f;
        this.igs = null;
        this.igt = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.igf != 1) {
                            if (AutoPlayVideoView.this.dnB.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igo = AutoPlayVideoView.this.igp;
                            AutoPlayVideoView.this.gvg.setVisibility(8);
                            if (!AutoPlayVideoView.this.dnD.cek() || AutoPlayVideoView.this.igs == null) {
                                AutoPlayVideoView.this.dnB.seekTo((int) AutoPlayVideoView.this.igp);
                                AutoPlayVideoView.this.gva.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dnB.getDuration();
                            AutoPlayVideoView.this.igf = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SY) {
                                AutoPlayVideoView.this.igj.setVisibility(0);
                                AutoPlayVideoView.this.igj.t(AutoPlayVideoView.this.igp, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igj.caz();
                                return;
                            }
                            AutoPlayVideoView.this.igh.qr();
                            AutoPlayVideoView.this.igh.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SY) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dnB.getDuration() - AutoPlayVideoView.this.dnB.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.igi.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.igf == 1) {
                            if (AutoPlayVideoView.this.igo == AutoPlayVideoView.this.dnB.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igo = AutoPlayVideoView.this.dnB.getCurrentPosition();
                                AutoPlayVideoView.this.brb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dnB.isPlaying() && AutoPlayVideoView.this.dnD.cek() && AutoPlayVideoView.this.igs != null) {
                            if (AutoPlayVideoView.this.dnB.getCurrentPosition() > AutoPlayVideoView.this.igp) {
                                AutoPlayVideoView.this.gva.setVisibility(8);
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
        this.cTx = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dnB != null && AutoPlayVideoView.this.dnD.cek()) {
                        if (AutoPlayVideoView.this.igt == null) {
                            AutoPlayVideoView.this.igt = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.igt.setDataSource(AutoPlayVideoView.this.dnD.sc(AutoPlayVideoView.this.dnD.cej()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.igs != null) {
                            AutoPlayVideoView.this.dnB.seekTo((int) AutoPlayVideoView.this.igp);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igq, AutoPlayVideoView.this.igr);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ige;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.brb();
                AutoPlayVideoView.this.igp = 0L;
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.gva.setForegroundDrawable(0);
                    AutoPlayVideoView.this.igm.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gva.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.igm.setVisibility(8);
                }
                return true;
            }
        };
        this.cTw = null;
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ige != null && AutoPlayVideoView.this.dnB != null) {
                    AutoPlayVideoView.this.cay();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.igf = -1;
        this.SY = false;
        this.igl = false;
        this.mOnClickListener = null;
        this.igo = 0L;
        this.igp = 0L;
        this.mDuration = 0L;
        this.igq = 1.0f;
        this.igr = 1.0f;
        this.igs = null;
        this.igt = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.igf != 1) {
                            if (AutoPlayVideoView.this.dnB.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igo = AutoPlayVideoView.this.igp;
                            AutoPlayVideoView.this.gvg.setVisibility(8);
                            if (!AutoPlayVideoView.this.dnD.cek() || AutoPlayVideoView.this.igs == null) {
                                AutoPlayVideoView.this.dnB.seekTo((int) AutoPlayVideoView.this.igp);
                                AutoPlayVideoView.this.gva.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dnB.getDuration();
                            AutoPlayVideoView.this.igf = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SY) {
                                AutoPlayVideoView.this.igj.setVisibility(0);
                                AutoPlayVideoView.this.igj.t(AutoPlayVideoView.this.igp, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igj.caz();
                                return;
                            }
                            AutoPlayVideoView.this.igh.qr();
                            AutoPlayVideoView.this.igh.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SY) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dnB.getDuration() - AutoPlayVideoView.this.dnB.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.igi.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.igf == 1) {
                            if (AutoPlayVideoView.this.igo == AutoPlayVideoView.this.dnB.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igo = AutoPlayVideoView.this.dnB.getCurrentPosition();
                                AutoPlayVideoView.this.brb();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dnB.isPlaying() && AutoPlayVideoView.this.dnD.cek() && AutoPlayVideoView.this.igs != null) {
                            if (AutoPlayVideoView.this.dnB.getCurrentPosition() > AutoPlayVideoView.this.igp) {
                                AutoPlayVideoView.this.gva.setVisibility(8);
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
        this.cTx = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dnB != null && AutoPlayVideoView.this.dnD.cek()) {
                        if (AutoPlayVideoView.this.igt == null) {
                            AutoPlayVideoView.this.igt = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.igt.setDataSource(AutoPlayVideoView.this.dnD.sc(AutoPlayVideoView.this.dnD.cej()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.igs != null) {
                            AutoPlayVideoView.this.dnB.seekTo((int) AutoPlayVideoView.this.igp);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igq, AutoPlayVideoView.this.igr);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ige;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.brb();
                AutoPlayVideoView.this.igp = 0L;
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.gva.setForegroundDrawable(0);
                    AutoPlayVideoView.this.igm.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gva.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.igm.setVisibility(8);
                }
                return true;
            }
        };
        this.cTw = null;
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ige != null && AutoPlayVideoView.this.dnB != null) {
                    AutoPlayVideoView.this.cay();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.igc = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gva = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.gvg = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.igg = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dnB = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dnD = new n(this.mContext);
        this.dnB.setBusiness(this.dnD);
        this.igh = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.igi = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.igj = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.igk = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.igk.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.igm = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.ign = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean cax() {
        return s.cax();
    }

    public void cay() {
        if (cax()) {
            this.dnB.setVideoPath(this.ige.video_url, this.bWU);
            this.dnB.start();
            this.igf = 0;
            if (!this.dnD.cek() || this.igs == null) {
                showLoading();
            }
            this.igm.setVisibility(8);
            px(this.SY);
            return;
        }
        brb();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ige = videoInfo;
        this.bWU = str;
        this.gva.setDefaultErrorResource(0);
        this.gva.setDefaultResource(0);
        this.gva.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gva.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gva.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dnB.setOnPreparedListener(this.cTx);
        this.dnB.setOnErrorListener(this.cJZ);
        if (this.cTw != null) {
            this.dnB.setOnCompletionListener(this.cTw);
        }
        this.dnB.setOnSurfaceDestroyedListener(this.cKd);
        this.igh.setCertainColumnCount(4);
        this.igh.setColumnColor(R.color.cp_btn_a);
        this.igk.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ign.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.g(getContext(), R.dimen.ds120);
        }
        layoutParams.height = af;
        this.ign.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gva.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.gva.setLayoutParams(layoutParams2);
        this.gva.setOnClickListener(this.mOnClickListener);
        this.ign.setOnClickListener(this.mOnClickListener);
        this.igm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.igd.dismiss();
                    AutoPlayVideoView.this.gva.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.igj.destroy();
        e.iK().removeCallbacks(this.igu);
        if (this.dnB.isPlaying()) {
            this.igo = this.dnB.getCurrentPosition();
            if (this.dnD.cek() && this.igt != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.igt.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.igo), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.ige.video_width.intValue() / frameAtTime.getWidth(), this.ige.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.igs;
                                    this.igs = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gva.setImageBitmap(this.igs);
                                    this.gva.setForegroundDrawable(0);
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
                                this.igf = 3;
                                this.gva.setVisibility(0);
                                this.dnB.cey();
                                this.igh.qr();
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
        this.igf = 3;
        this.gva.setVisibility(0);
        this.dnB.cey();
        this.igh.qr();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.igi, R.color.cp_btn_a);
            am.f(this.igk, R.color.cp_cont_g, 1);
            am.g(this.igk, R.drawable.btn_video, 1);
            this.igh.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.igf;
    }

    public long getCurrentPosition() {
        return this.igo;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cTw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.gvg.setVisibility(0);
        this.gva.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
        this.gvg.setVisibility(8);
        this.gva.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.igq = f;
        this.igr = f2;
    }

    public long getDuration() {
        if (this.dnB == null) {
            return this.ige.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.ige.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.igp = j;
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
    public void px(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.igg.setVisibility(8);
            this.igj.setPlayer(this.dnB);
            return;
        }
        this.igj.setVisibility(8);
        this.igj.destroy();
        this.igg.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.igc != null && this.dnB != null) {
            if (!z) {
                if (this.igd != null) {
                    this.igd.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            px(true);
            if (this.igl) {
                this.igk.setVisibility(0);
            }
            this.SY = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igc.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.igc.getParent();
            viewGroup.removeAllViews();
            this.igd = new a(bdBaseActivity.getActivity(), this.igc, new ViewGroup.LayoutParams(-1, -1));
            this.igd.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.igc != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.px(false);
                        AutoPlayVideoView.this.igk.setVisibility(8);
                        AutoPlayVideoView.this.SY = false;
                        ((ViewGroup) AutoPlayVideoView.this.igc.getParent()).removeView(AutoPlayVideoView.this.igc);
                        viewGroup.addView(AutoPlayVideoView.this.igc);
                        AutoPlayVideoView.this.igc.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.igp = AutoPlayVideoView.this.igo;
                        if (AutoPlayVideoView.this.igm.getVisibility() != 0) {
                            AutoPlayVideoView.this.cay();
                        }
                        AutoPlayVideoView.this.igm.setVisibility(8);
                    }
                }
            });
            this.igp = this.igo;
            cay();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.igl = z;
    }
}
