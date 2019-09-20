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
    private boolean SX;
    private String bXN;
    private g.b cKP;
    private QuickVideoView.b cKT;
    private g.a cUp;
    private g.f cUq;
    private QuickVideoView dpn;
    private n dpp;
    private ForeDrawableImageView gwR;
    private View gwX;
    private View iib;
    private a iic;
    private VideoInfo iid;
    private int iie;
    private RelativeLayout iif;
    private AudioAnimationView iig;
    private TextView iih;
    private PbChudianProcessBar iii;
    private TextView iij;
    private boolean iik;
    private View iil;
    private View iim;
    private long iin;
    private long iio;
    private float iip;
    private float iiq;
    private Bitmap iir;
    private MediaMetadataRetriever iis;
    private Runnable iit;
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
        this.iie = -1;
        this.SX = false;
        this.iik = false;
        this.mOnClickListener = null;
        this.iin = 0L;
        this.iio = 0L;
        this.mDuration = 0L;
        this.iip = 1.0f;
        this.iiq = 1.0f;
        this.iir = null;
        this.iis = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.iie != 1) {
                            if (AutoPlayVideoView.this.dpn.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.iin = AutoPlayVideoView.this.iio;
                            AutoPlayVideoView.this.gwX.setVisibility(8);
                            if (!AutoPlayVideoView.this.dpp.ceZ() || AutoPlayVideoView.this.iir == null) {
                                AutoPlayVideoView.this.dpn.seekTo((int) AutoPlayVideoView.this.iio);
                                AutoPlayVideoView.this.gwR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dpn.getDuration();
                            AutoPlayVideoView.this.iie = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SX) {
                                AutoPlayVideoView.this.iii.setVisibility(0);
                                AutoPlayVideoView.this.iii.t(AutoPlayVideoView.this.iio, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.iii.cbn();
                                return;
                            }
                            AutoPlayVideoView.this.iig.qs();
                            AutoPlayVideoView.this.iig.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SX) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dpn.getDuration() - AutoPlayVideoView.this.dpn.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iih.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.iie == 1) {
                            if (AutoPlayVideoView.this.iin == AutoPlayVideoView.this.dpn.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.iin = AutoPlayVideoView.this.dpn.getCurrentPosition();
                                AutoPlayVideoView.this.brM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dpn.isPlaying() && AutoPlayVideoView.this.dpp.ceZ() && AutoPlayVideoView.this.iir != null) {
                            if (AutoPlayVideoView.this.dpn.getCurrentPosition() > AutoPlayVideoView.this.iio) {
                                AutoPlayVideoView.this.gwR.setVisibility(8);
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
        this.cUq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dpn != null && AutoPlayVideoView.this.dpp.ceZ()) {
                        if (AutoPlayVideoView.this.iis == null) {
                            AutoPlayVideoView.this.iis = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.iis.setDataSource(AutoPlayVideoView.this.dpp.sn(AutoPlayVideoView.this.dpp.ceY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.iir != null) {
                            AutoPlayVideoView.this.dpn.seekTo((int) AutoPlayVideoView.this.iio);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.iip, AutoPlayVideoView.this.iiq);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.iid;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.brM();
                AutoPlayVideoView.this.iio = 0L;
                if (AutoPlayVideoView.this.SX) {
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.iil.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.iil.setVisibility(8);
                }
                return true;
            }
        };
        this.cUp = null;
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.iit = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.iid != null && AutoPlayVideoView.this.dpn != null) {
                    AutoPlayVideoView.this.cbm();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.iie = -1;
        this.SX = false;
        this.iik = false;
        this.mOnClickListener = null;
        this.iin = 0L;
        this.iio = 0L;
        this.mDuration = 0L;
        this.iip = 1.0f;
        this.iiq = 1.0f;
        this.iir = null;
        this.iis = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.iie != 1) {
                            if (AutoPlayVideoView.this.dpn.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.iin = AutoPlayVideoView.this.iio;
                            AutoPlayVideoView.this.gwX.setVisibility(8);
                            if (!AutoPlayVideoView.this.dpp.ceZ() || AutoPlayVideoView.this.iir == null) {
                                AutoPlayVideoView.this.dpn.seekTo((int) AutoPlayVideoView.this.iio);
                                AutoPlayVideoView.this.gwR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dpn.getDuration();
                            AutoPlayVideoView.this.iie = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SX) {
                                AutoPlayVideoView.this.iii.setVisibility(0);
                                AutoPlayVideoView.this.iii.t(AutoPlayVideoView.this.iio, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.iii.cbn();
                                return;
                            }
                            AutoPlayVideoView.this.iig.qs();
                            AutoPlayVideoView.this.iig.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SX) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dpn.getDuration() - AutoPlayVideoView.this.dpn.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iih.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.iie == 1) {
                            if (AutoPlayVideoView.this.iin == AutoPlayVideoView.this.dpn.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.iin = AutoPlayVideoView.this.dpn.getCurrentPosition();
                                AutoPlayVideoView.this.brM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dpn.isPlaying() && AutoPlayVideoView.this.dpp.ceZ() && AutoPlayVideoView.this.iir != null) {
                            if (AutoPlayVideoView.this.dpn.getCurrentPosition() > AutoPlayVideoView.this.iio) {
                                AutoPlayVideoView.this.gwR.setVisibility(8);
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
        this.cUq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dpn != null && AutoPlayVideoView.this.dpp.ceZ()) {
                        if (AutoPlayVideoView.this.iis == null) {
                            AutoPlayVideoView.this.iis = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.iis.setDataSource(AutoPlayVideoView.this.dpp.sn(AutoPlayVideoView.this.dpp.ceY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.iir != null) {
                            AutoPlayVideoView.this.dpn.seekTo((int) AutoPlayVideoView.this.iio);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.iip, AutoPlayVideoView.this.iiq);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.iid;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.brM();
                AutoPlayVideoView.this.iio = 0L;
                if (AutoPlayVideoView.this.SX) {
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.iil.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.iil.setVisibility(8);
                }
                return true;
            }
        };
        this.cUp = null;
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.iit = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.iid != null && AutoPlayVideoView.this.dpn != null) {
                    AutoPlayVideoView.this.cbm();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iie = -1;
        this.SX = false;
        this.iik = false;
        this.mOnClickListener = null;
        this.iin = 0L;
        this.iio = 0L;
        this.mDuration = 0L;
        this.iip = 1.0f;
        this.iiq = 1.0f;
        this.iir = null;
        this.iis = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.iie != 1) {
                            if (AutoPlayVideoView.this.dpn.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.iin = AutoPlayVideoView.this.iio;
                            AutoPlayVideoView.this.gwX.setVisibility(8);
                            if (!AutoPlayVideoView.this.dpp.ceZ() || AutoPlayVideoView.this.iir == null) {
                                AutoPlayVideoView.this.dpn.seekTo((int) AutoPlayVideoView.this.iio);
                                AutoPlayVideoView.this.gwR.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dpn.getDuration();
                            AutoPlayVideoView.this.iie = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.SX) {
                                AutoPlayVideoView.this.iii.setVisibility(0);
                                AutoPlayVideoView.this.iii.t(AutoPlayVideoView.this.iio, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.iii.cbn();
                                return;
                            }
                            AutoPlayVideoView.this.iig.qs();
                            AutoPlayVideoView.this.iig.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.SX) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dpn.getDuration() - AutoPlayVideoView.this.dpn.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iih.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.iie == 1) {
                            if (AutoPlayVideoView.this.iin == AutoPlayVideoView.this.dpn.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.iin = AutoPlayVideoView.this.dpn.getCurrentPosition();
                                AutoPlayVideoView.this.brM();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dpn.isPlaying() && AutoPlayVideoView.this.dpp.ceZ() && AutoPlayVideoView.this.iir != null) {
                            if (AutoPlayVideoView.this.dpn.getCurrentPosition() > AutoPlayVideoView.this.iio) {
                                AutoPlayVideoView.this.gwR.setVisibility(8);
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
        this.cUq = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dpn != null && AutoPlayVideoView.this.dpp.ceZ()) {
                        if (AutoPlayVideoView.this.iis == null) {
                            AutoPlayVideoView.this.iis = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.iis.setDataSource(AutoPlayVideoView.this.dpp.sn(AutoPlayVideoView.this.dpp.ceY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.iir != null) {
                            AutoPlayVideoView.this.dpn.seekTo((int) AutoPlayVideoView.this.iio);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.iip, AutoPlayVideoView.this.iiq);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.iid;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.brM();
                AutoPlayVideoView.this.iio = 0L;
                if (AutoPlayVideoView.this.SX) {
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(0);
                    AutoPlayVideoView.this.iil.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.iil.setVisibility(8);
                }
                return true;
            }
        };
        this.cUp = null;
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.iit = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.iid != null && AutoPlayVideoView.this.dpn != null) {
                    AutoPlayVideoView.this.cbm();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.iib = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gwR = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.gwX = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.iif = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dpn = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dpp = new n(this.mContext);
        this.dpn.setBusiness(this.dpp);
        this.iig = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.iih = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.iii = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.iij = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.iij.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.iil = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.iim = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean cbl() {
        return s.cbl();
    }

    public void cbm() {
        if (cbl()) {
            this.dpn.setVideoPath(this.iid.video_url, this.bXN);
            this.dpn.start();
            this.iie = 0;
            if (!this.dpp.ceZ() || this.iir == null) {
                showLoading();
            }
            this.iil.setVisibility(8);
            pB(this.SX);
            return;
        }
        brM();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.iid = videoInfo;
        this.bXN = str;
        this.gwR.setDefaultErrorResource(0);
        this.gwR.setDefaultResource(0);
        this.gwR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gwR.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gwR.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dpn.setOnPreparedListener(this.cUq);
        this.dpn.setOnErrorListener(this.cKP);
        if (this.cUp != null) {
            this.dpn.setOnCompletionListener(this.cUp);
        }
        this.dpn.setOnSurfaceDestroyedListener(this.cKT);
        this.iig.setCertainColumnCount(4);
        this.iig.setColumnColor(R.color.cp_cont_a);
        this.iij.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iim.getLayoutParams();
        int af = l.af(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            af = ((af * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.g(getContext(), R.dimen.ds120);
        }
        layoutParams.height = af;
        this.iim.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gwR.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = af;
        }
        this.gwR.setLayoutParams(layoutParams2);
        this.gwR.setOnClickListener(this.mOnClickListener);
        this.iim.setOnClickListener(this.mOnClickListener);
        this.iil.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.SX) {
                    AutoPlayVideoView.this.iic.dismiss();
                    AutoPlayVideoView.this.gwR.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.iii.destroy();
        e.iK().removeCallbacks(this.iit);
        if (this.dpn.isPlaying()) {
            this.iin = this.dpn.getCurrentPosition();
            if (this.dpp.ceZ() && this.iis != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.iis.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.iin), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.iid.video_width.intValue() / frameAtTime.getWidth(), this.iid.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.iir;
                                    this.iir = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gwR.setImageBitmap(this.iir);
                                    this.gwR.setForegroundDrawable(0);
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
                                this.iie = 3;
                                this.gwR.setVisibility(0);
                                this.dpn.stopPlayback();
                                this.iig.qs();
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
        this.iie = 3;
        this.gwR.setVisibility(0);
        this.dpn.stopPlayback();
        this.iig.qs();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.j(this.iih, R.color.cp_cont_a);
            am.f(this.iij, R.color.cp_cont_g, 1);
            am.g(this.iij, R.drawable.btn_video, 1);
            this.iig.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.iie;
    }

    public long getCurrentPosition() {
        return this.iin;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.cUp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.gwX.setVisibility(0);
        this.gwR.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brM() {
        this.gwX.setVisibility(8);
        this.gwR.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.iip = f;
        this.iiq = f2;
    }

    public long getDuration() {
        if (this.dpn == null) {
            return this.iid.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.iid.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.iio = j;
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
    public void pB(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.iif.setVisibility(8);
            this.iii.setPlayer(this.dpn);
            return;
        }
        this.iii.setVisibility(8);
        this.iii.destroy();
        this.iif.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.iib != null && this.dpn != null) {
            if (!z) {
                if (this.iic != null) {
                    this.iic.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            pB(true);
            if (this.iik) {
                this.iij.setVisibility(0);
            }
            this.SX = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iib.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.iib.getParent();
            viewGroup.removeAllViews();
            this.iic = new a(bdBaseActivity.getActivity(), this.iib, new ViewGroup.LayoutParams(-1, -1));
            this.iic.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.iib != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.pB(false);
                        AutoPlayVideoView.this.iij.setVisibility(8);
                        AutoPlayVideoView.this.SX = false;
                        ((ViewGroup) AutoPlayVideoView.this.iib.getParent()).removeView(AutoPlayVideoView.this.iib);
                        viewGroup.addView(AutoPlayVideoView.this.iib);
                        AutoPlayVideoView.this.iib.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.iio = AutoPlayVideoView.this.iin;
                        if (AutoPlayVideoView.this.iil.getVisibility() != 0) {
                            AutoPlayVideoView.this.cbm();
                        }
                        AutoPlayVideoView.this.iil.setVisibility(8);
                    }
                }
            });
            this.iio = this.iin;
            cbm();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.iik = z;
    }
}
