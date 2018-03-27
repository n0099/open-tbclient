package com.baidu.tieba.pbextra.chudian.view;

import android.content.Context;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.view.a;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.view.AudioAnimationView;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpStatus;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class AutoPlayVideoView extends a {
    private String bCV;
    private g.a bPs;
    private g.f bPt;
    private g.b bPu;
    private QuickVideoView caP;
    private n caR;
    private QuickVideoView.b caY;
    private View ceU;
    private boolean eoh;
    private ForeDrawableImageView erc;
    private View eri;
    private View geL;
    private VideoInfo geM;
    private int geN;
    private RelativeLayout geO;
    private AudioAnimationView geP;
    private TextView geQ;
    private PbChudianProcessBar geR;
    private TextView geS;
    private boolean geT;
    private View geU;
    private View geV;
    private long geW;
    private long geX;
    private float geY;
    private float geZ;
    private Bitmap gfa;
    private MediaMetadataRetriever gfb;
    private Runnable gfc;
    private Context mContext;
    private long mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private View mRootView;
    private int mSkinType;

    public AutoPlayVideoView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.geN = -1;
        this.eoh = false;
        this.geT = false;
        this.mOnClickListener = null;
        this.geW = 0L;
        this.geX = 0L;
        this.mDuration = 0L;
        this.geY = 1.0f;
        this.geZ = 1.0f;
        this.gfa = null;
        this.gfb = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geN != 1) {
                            if (AutoPlayVideoView.this.caP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geW = AutoPlayVideoView.this.geX;
                            AutoPlayVideoView.this.eri.setVisibility(8);
                            if (!AutoPlayVideoView.this.caR.blf() || AutoPlayVideoView.this.gfa == null) {
                                AutoPlayVideoView.this.caP.seekTo((int) AutoPlayVideoView.this.geX);
                                AutoPlayVideoView.this.erc.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caP.getDuration();
                            AutoPlayVideoView.this.geN = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.eoh) {
                                AutoPlayVideoView.this.geR.setVisibility(0);
                                AutoPlayVideoView.this.geR.l(AutoPlayVideoView.this.geX, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geR.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.geP.tn();
                            AutoPlayVideoView.this.geP.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.eoh) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caP.getDuration() - AutoPlayVideoView.this.caP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.geN == 1) {
                            if (AutoPlayVideoView.this.geW == AutoPlayVideoView.this.caP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geW = AutoPlayVideoView.this.caP.getCurrentPosition();
                                AutoPlayVideoView.this.aIH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caP.isPlaying() && AutoPlayVideoView.this.caR.blf() && AutoPlayVideoView.this.gfa != null) {
                            if (AutoPlayVideoView.this.caP.getCurrentPosition() > AutoPlayVideoView.this.geX) {
                                AutoPlayVideoView.this.erc.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caP != null && AutoPlayVideoView.this.caR.blf()) {
                        if (AutoPlayVideoView.this.gfb == null) {
                            AutoPlayVideoView.this.gfb = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gfb.setDataSource(AutoPlayVideoView.this.caR.hW(AutoPlayVideoView.this.caR.ble()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gfa != null) {
                            AutoPlayVideoView.this.caP.seekTo((int) AutoPlayVideoView.this.geX);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geY, AutoPlayVideoView.this.geZ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geM;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIH();
                AutoPlayVideoView.this.geX = 0L;
                if (AutoPlayVideoView.this.eoh) {
                    AutoPlayVideoView.this.erc.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geU.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.erc.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geU.setVisibility(8);
                }
                return true;
            }
        };
        this.bPs = null;
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gfc = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geM != null && AutoPlayVideoView.this.caP != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.geN = -1;
        this.eoh = false;
        this.geT = false;
        this.mOnClickListener = null;
        this.geW = 0L;
        this.geX = 0L;
        this.mDuration = 0L;
        this.geY = 1.0f;
        this.geZ = 1.0f;
        this.gfa = null;
        this.gfb = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geN != 1) {
                            if (AutoPlayVideoView.this.caP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geW = AutoPlayVideoView.this.geX;
                            AutoPlayVideoView.this.eri.setVisibility(8);
                            if (!AutoPlayVideoView.this.caR.blf() || AutoPlayVideoView.this.gfa == null) {
                                AutoPlayVideoView.this.caP.seekTo((int) AutoPlayVideoView.this.geX);
                                AutoPlayVideoView.this.erc.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caP.getDuration();
                            AutoPlayVideoView.this.geN = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.eoh) {
                                AutoPlayVideoView.this.geR.setVisibility(0);
                                AutoPlayVideoView.this.geR.l(AutoPlayVideoView.this.geX, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geR.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.geP.tn();
                            AutoPlayVideoView.this.geP.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.eoh) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caP.getDuration() - AutoPlayVideoView.this.caP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.geN == 1) {
                            if (AutoPlayVideoView.this.geW == AutoPlayVideoView.this.caP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geW = AutoPlayVideoView.this.caP.getCurrentPosition();
                                AutoPlayVideoView.this.aIH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caP.isPlaying() && AutoPlayVideoView.this.caR.blf() && AutoPlayVideoView.this.gfa != null) {
                            if (AutoPlayVideoView.this.caP.getCurrentPosition() > AutoPlayVideoView.this.geX) {
                                AutoPlayVideoView.this.erc.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caP != null && AutoPlayVideoView.this.caR.blf()) {
                        if (AutoPlayVideoView.this.gfb == null) {
                            AutoPlayVideoView.this.gfb = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gfb.setDataSource(AutoPlayVideoView.this.caR.hW(AutoPlayVideoView.this.caR.ble()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gfa != null) {
                            AutoPlayVideoView.this.caP.seekTo((int) AutoPlayVideoView.this.geX);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geY, AutoPlayVideoView.this.geZ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geM;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIH();
                AutoPlayVideoView.this.geX = 0L;
                if (AutoPlayVideoView.this.eoh) {
                    AutoPlayVideoView.this.erc.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geU.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.erc.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geU.setVisibility(8);
                }
                return true;
            }
        };
        this.bPs = null;
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gfc = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geM != null && AutoPlayVideoView.this.caP != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.geN = -1;
        this.eoh = false;
        this.geT = false;
        this.mOnClickListener = null;
        this.geW = 0L;
        this.geX = 0L;
        this.mDuration = 0L;
        this.geY = 1.0f;
        this.geZ = 1.0f;
        this.gfa = null;
        this.gfb = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.geN != 1) {
                            if (AutoPlayVideoView.this.caP.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.geW = AutoPlayVideoView.this.geX;
                            AutoPlayVideoView.this.eri.setVisibility(8);
                            if (!AutoPlayVideoView.this.caR.blf() || AutoPlayVideoView.this.gfa == null) {
                                AutoPlayVideoView.this.caP.seekTo((int) AutoPlayVideoView.this.geX);
                                AutoPlayVideoView.this.erc.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.caP.getDuration();
                            AutoPlayVideoView.this.geN = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.eoh) {
                                AutoPlayVideoView.this.geR.setVisibility(0);
                                AutoPlayVideoView.this.geR.l(AutoPlayVideoView.this.geX, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.geR.bhK();
                                return;
                            }
                            AutoPlayVideoView.this.geP.tn();
                            AutoPlayVideoView.this.geP.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.eoh) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.caP.getDuration() - AutoPlayVideoView.this.caP.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.geQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case HttpStatus.SC_UNAUTHORIZED /* 401 */:
                        if (AutoPlayVideoView.this.geN == 1) {
                            if (AutoPlayVideoView.this.geW == AutoPlayVideoView.this.caP.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.geW = AutoPlayVideoView.this.caP.getCurrentPosition();
                                AutoPlayVideoView.this.aIH();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_UNAUTHORIZED, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                        if (AutoPlayVideoView.this.caP.isPlaying() && AutoPlayVideoView.this.caR.blf() && AutoPlayVideoView.this.gfa != null) {
                            if (AutoPlayVideoView.this.caP.getCurrentPosition() > AutoPlayVideoView.this.geX) {
                                AutoPlayVideoView.this.erc.setVisibility(8);
                                return;
                            } else {
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(HttpStatus.SC_NOT_IMPLEMENTED, TimeUnit.MILLISECONDS.toMillis(200L));
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.bPt = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.caP != null && AutoPlayVideoView.this.caR.blf()) {
                        if (AutoPlayVideoView.this.gfb == null) {
                            AutoPlayVideoView.this.gfb = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.gfb.setDataSource(AutoPlayVideoView.this.caR.hW(AutoPlayVideoView.this.caR.ble()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.gfa != null) {
                            AutoPlayVideoView.this.caP.seekTo((int) AutoPlayVideoView.this.geX);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.geY, AutoPlayVideoView.this.geZ);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.geM;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.aIH();
                AutoPlayVideoView.this.geX = 0L;
                if (AutoPlayVideoView.this.eoh) {
                    AutoPlayVideoView.this.erc.setForegroundDrawable(0);
                    AutoPlayVideoView.this.geU.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), d.j.pb_play_error);
                    AutoPlayVideoView.this.erc.setForegroundDrawable(d.f.icon_play_video);
                    AutoPlayVideoView.this.geU.setVisibility(8);
                }
                return true;
            }
        };
        this.bPs = null;
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.gfc = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.geM != null && AutoPlayVideoView.this.caP != null) {
                    AutoPlayVideoView.this.bhJ();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(d.h.auto_play_video_view, (ViewGroup) this, true);
        this.geL = this.mRootView.findViewById(d.g.content_wrapper);
        this.ceU = this.mRootView.findViewById(d.g.auto_video_black_mask);
        this.erc = (ForeDrawableImageView) this.mRootView.findViewById(d.g.pb_list_video_item_thumbnail);
        this.eri = this.mRootView.findViewById(d.g.pb_layout_loading);
        this.geO = (RelativeLayout) this.mRootView.findViewById(d.g.process_bar);
        this.caP = (QuickVideoView) this.mRootView.findViewById(d.g.texture_video_view);
        this.caR = new n(this.mContext);
        this.caP.setBusiness(this.caR);
        this.geP = (AudioAnimationView) this.mRootView.findViewById(d.g.playing_animation);
        this.geQ = (TextView) this.mRootView.findViewById(d.g.count_down_process);
        this.geR = (PbChudianProcessBar) this.mRootView.findViewById(d.g.full_screen_process_bar);
        this.geS = (TextView) this.mRootView.findViewById(d.g.check_detail);
        this.geS.setTag(d.g.tag_pb_chudian_check_detail, true);
        this.geU = this.mRootView.findViewById(d.g.chudian_error_tip);
        this.geV = this.mRootView.findViewById(d.g.available_click_area);
    }

    private boolean bhI() {
        return r.bhI();
    }

    public void bhJ() {
        if (bhI()) {
            this.caP.bN(this.geM.video_url, this.bCV);
            this.caP.start();
            this.geN = 0;
            if (!this.caR.blf() || this.gfa == null) {
                showLoading();
            }
            this.geU.setVisibility(8);
            lr(this.eoh);
            return;
        }
        aIH();
    }

    public void stopPlay() {
        this.mHandler.removeMessages(202);
        this.mHandler.removeMessages(301);
        this.mHandler.removeMessages(HttpStatus.SC_UNAUTHORIZED);
        this.mHandler.removeMessages(HttpStatus.SC_NOT_IMPLEMENTED);
        this.geR.destroy();
        e.ns().removeCallbacks(this.gfc);
        if (this.caP.isPlaying()) {
            this.geW = this.caP.getCurrentPosition();
            if (this.caR.blf() && this.gfb != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.gfb.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.geW), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.geM.video_width.intValue() / frameAtTime.getWidth(), this.geM.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.gfa;
                                    this.gfa = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.erc.setImageBitmap(this.gfa);
                                    this.erc.setForegroundDrawable(0);
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
                                this.geN = 3;
                                this.erc.setVisibility(0);
                                this.caP.stopPlayback();
                                this.geP.tn();
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
        this.geN = 3;
        this.erc.setVisibility(0);
        this.caP.stopPlayback();
        this.geP.tn();
    }

    public int getPlayStatus() {
        return this.geN;
    }

    public long getCurrentPosition() {
        return this.geW;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.bPs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.eri.setVisibility(0);
        this.erc.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIH() {
        this.eri.setVisibility(8);
        this.erc.setForegroundDrawable(d.f.icon_play_video);
    }

    public long getDuration() {
        if (this.caP == null) {
            return this.geM.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.geM.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.geX = j;
    }

    private void lr(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.geO.setVisibility(8);
            this.geR.setPlayer(this.caP);
            return;
        }
        this.geR.setVisibility(8);
        this.geR.destroy();
        this.geO.setVisibility(0);
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.geT = z;
    }
}
