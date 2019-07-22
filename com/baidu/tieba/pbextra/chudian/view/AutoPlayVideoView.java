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
import com.baidu.tieba.tbadkCore.q;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class AutoPlayVideoView extends BaseAutoPlayVideoView {
    private boolean SY;
    private String bWO;
    private g.b cJS;
    private QuickVideoView.b cJW;
    private g.a cTp;
    private g.f cTq;
    private QuickVideoView dnu;
    private n dnw;
    private ForeDrawableImageView gui;
    private View guo;
    private View ifa;
    private a ifb;
    private VideoInfo ifc;
    private int ifd;
    private RelativeLayout ife;
    private AudioAnimationView iff;
    private TextView ifg;
    private PbChudianProcessBar ifh;
    private TextView ifi;
    private boolean ifj;
    private View ifk;
    private View ifl;
    private long ifm;
    private long ifn;
    private float ifo;
    private float ifp;
    private Bitmap ifq;
    private MediaMetadataRetriever ifr;
    private Runnable ifs;
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
        this.ifd = -1;
        this.SY = false;
        this.ifj = false;
        this.mOnClickListener = null;
        this.ifm = 0L;
        this.ifn = 0L;
        this.mDuration = 0L;
        this.ifo = 1.0f;
        this.ifp = 1.0f;
        this.ifq = null;
        this.ifr = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.ifd != 1) {
                            if (AutoPlayVideoView.this.dnu.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.ifm = AutoPlayVideoView.this.ifn;
                            AutoPlayVideoView.this.guo.setVisibility(8);
                            if (!AutoPlayVideoView.this.dnw.cdS() || AutoPlayVideoView.this.ifq == null) {
                                AutoPlayVideoView.this.dnu.seekTo((int) AutoPlayVideoView.this.ifn);
                                AutoPlayVideoView.this.gui.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dnu.getDuration();
                            AutoPlayVideoView.this.ifd = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SY) {
                                AutoPlayVideoView.this.ifh.setVisibility(0);
                                AutoPlayVideoView.this.ifh.t(AutoPlayVideoView.this.ifn, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.ifh.cah();
                                return;
                            }
                            AutoPlayVideoView.this.iff.qr();
                            AutoPlayVideoView.this.iff.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SY) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dnu.getDuration() - AutoPlayVideoView.this.dnu.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.ifg.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.ifd == 1) {
                            if (AutoPlayVideoView.this.ifm == AutoPlayVideoView.this.dnu.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.ifm = AutoPlayVideoView.this.dnu.getCurrentPosition();
                                AutoPlayVideoView.this.bqO();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dnu.isPlaying() && AutoPlayVideoView.this.dnw.cdS() && AutoPlayVideoView.this.ifq != null) {
                            if (AutoPlayVideoView.this.dnu.getCurrentPosition() > AutoPlayVideoView.this.ifn) {
                                AutoPlayVideoView.this.gui.setVisibility(8);
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
        this.cTq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dnu != null && AutoPlayVideoView.this.dnw.cdS()) {
                        if (AutoPlayVideoView.this.ifr == null) {
                            AutoPlayVideoView.this.ifr = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ifr.setDataSource(AutoPlayVideoView.this.dnw.sc(AutoPlayVideoView.this.dnw.cdR()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ifq != null) {
                            AutoPlayVideoView.this.dnu.seekTo((int) AutoPlayVideoView.this.ifn);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.ifo, AutoPlayVideoView.this.ifp);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ifc;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bqO();
                AutoPlayVideoView.this.ifn = 0L;
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.gui.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ifk.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gui.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.ifk.setVisibility(8);
                }
                return true;
            }
        };
        this.cTp = null;
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ifs = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ifc != null && AutoPlayVideoView.this.dnu != null) {
                    AutoPlayVideoView.this.cag();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.ifd = -1;
        this.SY = false;
        this.ifj = false;
        this.mOnClickListener = null;
        this.ifm = 0L;
        this.ifn = 0L;
        this.mDuration = 0L;
        this.ifo = 1.0f;
        this.ifp = 1.0f;
        this.ifq = null;
        this.ifr = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.ifd != 1) {
                            if (AutoPlayVideoView.this.dnu.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.ifm = AutoPlayVideoView.this.ifn;
                            AutoPlayVideoView.this.guo.setVisibility(8);
                            if (!AutoPlayVideoView.this.dnw.cdS() || AutoPlayVideoView.this.ifq == null) {
                                AutoPlayVideoView.this.dnu.seekTo((int) AutoPlayVideoView.this.ifn);
                                AutoPlayVideoView.this.gui.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dnu.getDuration();
                            AutoPlayVideoView.this.ifd = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SY) {
                                AutoPlayVideoView.this.ifh.setVisibility(0);
                                AutoPlayVideoView.this.ifh.t(AutoPlayVideoView.this.ifn, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.ifh.cah();
                                return;
                            }
                            AutoPlayVideoView.this.iff.qr();
                            AutoPlayVideoView.this.iff.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SY) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dnu.getDuration() - AutoPlayVideoView.this.dnu.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.ifg.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.ifd == 1) {
                            if (AutoPlayVideoView.this.ifm == AutoPlayVideoView.this.dnu.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.ifm = AutoPlayVideoView.this.dnu.getCurrentPosition();
                                AutoPlayVideoView.this.bqO();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dnu.isPlaying() && AutoPlayVideoView.this.dnw.cdS() && AutoPlayVideoView.this.ifq != null) {
                            if (AutoPlayVideoView.this.dnu.getCurrentPosition() > AutoPlayVideoView.this.ifn) {
                                AutoPlayVideoView.this.gui.setVisibility(8);
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
        this.cTq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dnu != null && AutoPlayVideoView.this.dnw.cdS()) {
                        if (AutoPlayVideoView.this.ifr == null) {
                            AutoPlayVideoView.this.ifr = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ifr.setDataSource(AutoPlayVideoView.this.dnw.sc(AutoPlayVideoView.this.dnw.cdR()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ifq != null) {
                            AutoPlayVideoView.this.dnu.seekTo((int) AutoPlayVideoView.this.ifn);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.ifo, AutoPlayVideoView.this.ifp);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ifc;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bqO();
                AutoPlayVideoView.this.ifn = 0L;
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.gui.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ifk.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gui.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.ifk.setVisibility(8);
                }
                return true;
            }
        };
        this.cTp = null;
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ifs = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ifc != null && AutoPlayVideoView.this.dnu != null) {
                    AutoPlayVideoView.this.cag();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ifd = -1;
        this.SY = false;
        this.ifj = false;
        this.mOnClickListener = null;
        this.ifm = 0L;
        this.ifn = 0L;
        this.mDuration = 0L;
        this.ifo = 1.0f;
        this.ifp = 1.0f;
        this.ifq = null;
        this.ifr = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.ifd != 1) {
                            if (AutoPlayVideoView.this.dnu.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.ifm = AutoPlayVideoView.this.ifn;
                            AutoPlayVideoView.this.guo.setVisibility(8);
                            if (!AutoPlayVideoView.this.dnw.cdS() || AutoPlayVideoView.this.ifq == null) {
                                AutoPlayVideoView.this.dnu.seekTo((int) AutoPlayVideoView.this.ifn);
                                AutoPlayVideoView.this.gui.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dnu.getDuration();
                            AutoPlayVideoView.this.ifd = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SY) {
                                AutoPlayVideoView.this.ifh.setVisibility(0);
                                AutoPlayVideoView.this.ifh.t(AutoPlayVideoView.this.ifn, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.ifh.cah();
                                return;
                            }
                            AutoPlayVideoView.this.iff.qr();
                            AutoPlayVideoView.this.iff.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SY) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dnu.getDuration() - AutoPlayVideoView.this.dnu.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.ifg.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.ifd == 1) {
                            if (AutoPlayVideoView.this.ifm == AutoPlayVideoView.this.dnu.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.ifm = AutoPlayVideoView.this.dnu.getCurrentPosition();
                                AutoPlayVideoView.this.bqO();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dnu.isPlaying() && AutoPlayVideoView.this.dnw.cdS() && AutoPlayVideoView.this.ifq != null) {
                            if (AutoPlayVideoView.this.dnu.getCurrentPosition() > AutoPlayVideoView.this.ifn) {
                                AutoPlayVideoView.this.gui.setVisibility(8);
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
        this.cTq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dnu != null && AutoPlayVideoView.this.dnw.cdS()) {
                        if (AutoPlayVideoView.this.ifr == null) {
                            AutoPlayVideoView.this.ifr = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ifr.setDataSource(AutoPlayVideoView.this.dnw.sc(AutoPlayVideoView.this.dnw.cdR()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ifq != null) {
                            AutoPlayVideoView.this.dnu.seekTo((int) AutoPlayVideoView.this.ifn);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.ifo, AutoPlayVideoView.this.ifp);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ifc;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.bqO();
                AutoPlayVideoView.this.ifn = 0L;
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.gui.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ifk.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gui.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.ifk.setVisibility(8);
                }
                return true;
            }
        };
        this.cTp = null;
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ifs = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ifc != null && AutoPlayVideoView.this.dnu != null) {
                    AutoPlayVideoView.this.cag();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.ifa = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gui = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.guo = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.ife = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dnu = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dnw = new n(this.mContext);
        this.dnu.setBusiness(this.dnw);
        this.iff = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.ifg = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.ifh = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.ifi = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.ifi.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.ifk = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.ifl = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean caf() {
        return q.caf();
    }

    public void cag() {
        if (caf()) {
            this.dnu.setVideoPath(this.ifc.video_url, this.bWO);
            this.dnu.start();
            this.ifd = 0;
            if (!this.dnw.cdS() || this.ifq == null) {
                showLoading();
            }
            this.ifk.setVisibility(8);
            pw(this.SY);
            return;
        }
        bqO();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ifc = videoInfo;
        this.bWO = str;
        this.gui.setDefaultErrorResource(0);
        this.gui.setDefaultResource(0);
        this.gui.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gui.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gui.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dnu.setOnPreparedListener(this.cTq);
        this.dnu.setOnErrorListener(this.cJS);
        if (this.cTp != null) {
            this.dnu.setOnCompletionListener(this.cTp);
        }
        this.dnu.setOnSurfaceDestroyedListener(this.cJW);
        this.iff.setCertainColumnCount(4);
        this.iff.setColumnColor(R.color.cp_btn_a);
        this.ifi.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifl.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.g(getContext(), R.dimen.ds120);
        }
        layoutParams.height = af;
        this.ifl.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gui.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.gui.setLayoutParams(layoutParams2);
        this.gui.setOnClickListener(this.mOnClickListener);
        this.ifl.setOnClickListener(this.mOnClickListener);
        this.ifk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.SY) {
                    AutoPlayVideoView.this.ifb.dismiss();
                    AutoPlayVideoView.this.gui.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.ifh.destroy();
        e.iK().removeCallbacks(this.ifs);
        if (this.dnu.isPlaying()) {
            this.ifm = this.dnu.getCurrentPosition();
            if (this.dnw.cdS() && this.ifr != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.ifr.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.ifm), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.ifc.video_width.intValue() / frameAtTime.getWidth(), this.ifc.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.ifq;
                                    this.ifq = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gui.setImageBitmap(this.ifq);
                                    this.gui.setForegroundDrawable(0);
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
                                this.ifd = 3;
                                this.gui.setVisibility(0);
                                this.dnu.ceg();
                                this.iff.qr();
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
        this.ifd = 3;
        this.gui.setVisibility(0);
        this.dnu.ceg();
        this.iff.qr();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.ifg, R.color.cp_btn_a);
            am.f(this.ifi, R.color.cp_cont_g, 1);
            am.g(this.ifi, R.drawable.btn_video, 1);
            this.iff.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.ifd;
    }

    public long getCurrentPosition() {
        return this.ifm;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cTp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.guo.setVisibility(0);
        this.gui.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqO() {
        this.guo.setVisibility(8);
        this.gui.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.ifo = f;
        this.ifp = f2;
    }

    public long getDuration() {
        if (this.dnu == null) {
            return this.ifc.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.ifc.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.ifn = j;
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
    public void pw(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.ife.setVisibility(8);
            this.ifh.setPlayer(this.dnu);
            return;
        }
        this.ifh.setVisibility(8);
        this.ifh.destroy();
        this.ife.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.ifa != null && this.dnu != null) {
            if (!z) {
                if (this.ifb != null) {
                    this.ifb.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            pw(true);
            if (this.ifj) {
                this.ifi.setVisibility(0);
            }
            this.SY = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifa.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.ifa.getParent();
            viewGroup.removeAllViews();
            this.ifb = new a(bdBaseActivity.getActivity(), this.ifa, new ViewGroup.LayoutParams(-1, -1));
            this.ifb.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.ifa != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.pw(false);
                        AutoPlayVideoView.this.ifi.setVisibility(8);
                        AutoPlayVideoView.this.SY = false;
                        ((ViewGroup) AutoPlayVideoView.this.ifa.getParent()).removeView(AutoPlayVideoView.this.ifa);
                        viewGroup.addView(AutoPlayVideoView.this.ifa);
                        AutoPlayVideoView.this.ifa.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.ifn = AutoPlayVideoView.this.ifm;
                        if (AutoPlayVideoView.this.ifk.getVisibility() != 0) {
                            AutoPlayVideoView.this.cag();
                        }
                        AutoPlayVideoView.this.ifk.setVisibility(8);
                    }
                }
            });
            this.ifn = this.ifm;
            cag();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.ifj = z;
    }
}
