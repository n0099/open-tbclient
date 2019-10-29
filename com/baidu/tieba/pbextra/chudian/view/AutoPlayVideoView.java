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
    private boolean Cp;
    private g.b cUp;
    private QuickVideoView.b cUt;
    private String cmS;
    private g.a ddK;
    private g.f ddL;
    private QuickVideoView dwx;
    private n dwz;
    private ForeDrawableImageView guO;
    private View guU;
    private View igL;
    private a igM;
    private VideoInfo igN;
    private int igO;
    private RelativeLayout igP;
    private AudioAnimationView igQ;
    private TextView igR;
    private PbChudianProcessBar igS;
    private TextView igT;
    private boolean igU;
    private View igV;
    private View igW;
    private long igX;
    private long igY;
    private float igZ;
    private float iha;
    private Bitmap ihb;
    private MediaMetadataRetriever ihc;
    private Runnable ihd;
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
        this.igO = -1;
        this.Cp = false;
        this.igU = false;
        this.mOnClickListener = null;
        this.igX = 0L;
        this.igY = 0L;
        this.mDuration = 0L;
        this.igZ = 1.0f;
        this.iha = 1.0f;
        this.ihb = null;
        this.ihc = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.igO != 1) {
                            if (AutoPlayVideoView.this.dwx.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igX = AutoPlayVideoView.this.igY;
                            AutoPlayVideoView.this.guU.setVisibility(8);
                            if (!AutoPlayVideoView.this.dwz.ccb() || AutoPlayVideoView.this.ihb == null) {
                                AutoPlayVideoView.this.dwx.seekTo((int) AutoPlayVideoView.this.igY);
                                AutoPlayVideoView.this.guO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dwx.getDuration();
                            AutoPlayVideoView.this.igO = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.Cp) {
                                AutoPlayVideoView.this.igS.setVisibility(0);
                                AutoPlayVideoView.this.igS.z(AutoPlayVideoView.this.igY, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igS.bYp();
                                return;
                            }
                            AutoPlayVideoView.this.igQ.ll();
                            AutoPlayVideoView.this.igQ.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.Cp) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dwx.getDuration() - AutoPlayVideoView.this.dwx.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.igR.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.igO == 1) {
                            if (AutoPlayVideoView.this.igX == AutoPlayVideoView.this.dwx.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igX = AutoPlayVideoView.this.dwx.getCurrentPosition();
                                AutoPlayVideoView.this.boQ();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dwx.isPlaying() && AutoPlayVideoView.this.dwz.ccb() && AutoPlayVideoView.this.ihb != null) {
                            if (AutoPlayVideoView.this.dwx.getCurrentPosition() > AutoPlayVideoView.this.igY) {
                                AutoPlayVideoView.this.guO.setVisibility(8);
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
        this.ddL = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dwx != null && AutoPlayVideoView.this.dwz.ccb()) {
                        if (AutoPlayVideoView.this.ihc == null) {
                            AutoPlayVideoView.this.ihc = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ihc.setDataSource(AutoPlayVideoView.this.dwz.qX(AutoPlayVideoView.this.dwz.cca()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ihb != null) {
                            AutoPlayVideoView.this.dwx.seekTo((int) AutoPlayVideoView.this.igY);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igZ, AutoPlayVideoView.this.iha);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.igN;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boQ();
                AutoPlayVideoView.this.igY = 0L;
                if (AutoPlayVideoView.this.Cp) {
                    AutoPlayVideoView.this.guO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.igV.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.guO.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.igV.setVisibility(8);
                }
                return true;
            }
        };
        this.ddK = null;
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ihd = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.igN != null && AutoPlayVideoView.this.dwx != null) {
                    AutoPlayVideoView.this.bYo();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.igO = -1;
        this.Cp = false;
        this.igU = false;
        this.mOnClickListener = null;
        this.igX = 0L;
        this.igY = 0L;
        this.mDuration = 0L;
        this.igZ = 1.0f;
        this.iha = 1.0f;
        this.ihb = null;
        this.ihc = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.igO != 1) {
                            if (AutoPlayVideoView.this.dwx.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igX = AutoPlayVideoView.this.igY;
                            AutoPlayVideoView.this.guU.setVisibility(8);
                            if (!AutoPlayVideoView.this.dwz.ccb() || AutoPlayVideoView.this.ihb == null) {
                                AutoPlayVideoView.this.dwx.seekTo((int) AutoPlayVideoView.this.igY);
                                AutoPlayVideoView.this.guO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dwx.getDuration();
                            AutoPlayVideoView.this.igO = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.Cp) {
                                AutoPlayVideoView.this.igS.setVisibility(0);
                                AutoPlayVideoView.this.igS.z(AutoPlayVideoView.this.igY, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igS.bYp();
                                return;
                            }
                            AutoPlayVideoView.this.igQ.ll();
                            AutoPlayVideoView.this.igQ.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.Cp) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dwx.getDuration() - AutoPlayVideoView.this.dwx.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.igR.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.igO == 1) {
                            if (AutoPlayVideoView.this.igX == AutoPlayVideoView.this.dwx.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igX = AutoPlayVideoView.this.dwx.getCurrentPosition();
                                AutoPlayVideoView.this.boQ();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dwx.isPlaying() && AutoPlayVideoView.this.dwz.ccb() && AutoPlayVideoView.this.ihb != null) {
                            if (AutoPlayVideoView.this.dwx.getCurrentPosition() > AutoPlayVideoView.this.igY) {
                                AutoPlayVideoView.this.guO.setVisibility(8);
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
        this.ddL = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dwx != null && AutoPlayVideoView.this.dwz.ccb()) {
                        if (AutoPlayVideoView.this.ihc == null) {
                            AutoPlayVideoView.this.ihc = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ihc.setDataSource(AutoPlayVideoView.this.dwz.qX(AutoPlayVideoView.this.dwz.cca()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ihb != null) {
                            AutoPlayVideoView.this.dwx.seekTo((int) AutoPlayVideoView.this.igY);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igZ, AutoPlayVideoView.this.iha);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.igN;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boQ();
                AutoPlayVideoView.this.igY = 0L;
                if (AutoPlayVideoView.this.Cp) {
                    AutoPlayVideoView.this.guO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.igV.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.guO.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.igV.setVisibility(8);
                }
                return true;
            }
        };
        this.ddK = null;
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ihd = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.igN != null && AutoPlayVideoView.this.dwx != null) {
                    AutoPlayVideoView.this.bYo();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.igO = -1;
        this.Cp = false;
        this.igU = false;
        this.mOnClickListener = null;
        this.igX = 0L;
        this.igY = 0L;
        this.mDuration = 0L;
        this.igZ = 1.0f;
        this.iha = 1.0f;
        this.ihb = null;
        this.ihc = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.igO != 1) {
                            if (AutoPlayVideoView.this.dwx.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igX = AutoPlayVideoView.this.igY;
                            AutoPlayVideoView.this.guU.setVisibility(8);
                            if (!AutoPlayVideoView.this.dwz.ccb() || AutoPlayVideoView.this.ihb == null) {
                                AutoPlayVideoView.this.dwx.seekTo((int) AutoPlayVideoView.this.igY);
                                AutoPlayVideoView.this.guO.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dwx.getDuration();
                            AutoPlayVideoView.this.igO = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.Cp) {
                                AutoPlayVideoView.this.igS.setVisibility(0);
                                AutoPlayVideoView.this.igS.z(AutoPlayVideoView.this.igY, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igS.bYp();
                                return;
                            }
                            AutoPlayVideoView.this.igQ.ll();
                            AutoPlayVideoView.this.igQ.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.Cp) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dwx.getDuration() - AutoPlayVideoView.this.dwx.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.igR.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.igO == 1) {
                            if (AutoPlayVideoView.this.igX == AutoPlayVideoView.this.dwx.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igX = AutoPlayVideoView.this.dwx.getCurrentPosition();
                                AutoPlayVideoView.this.boQ();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dwx.isPlaying() && AutoPlayVideoView.this.dwz.ccb() && AutoPlayVideoView.this.ihb != null) {
                            if (AutoPlayVideoView.this.dwx.getCurrentPosition() > AutoPlayVideoView.this.igY) {
                                AutoPlayVideoView.this.guO.setVisibility(8);
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
        this.ddL = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dwx != null && AutoPlayVideoView.this.dwz.ccb()) {
                        if (AutoPlayVideoView.this.ihc == null) {
                            AutoPlayVideoView.this.ihc = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.ihc.setDataSource(AutoPlayVideoView.this.dwz.qX(AutoPlayVideoView.this.dwz.cca()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.ihb != null) {
                            AutoPlayVideoView.this.dwx.seekTo((int) AutoPlayVideoView.this.igY);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igZ, AutoPlayVideoView.this.iha);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.igN;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boQ();
                AutoPlayVideoView.this.igY = 0L;
                if (AutoPlayVideoView.this.Cp) {
                    AutoPlayVideoView.this.guO.setForegroundDrawable(0);
                    AutoPlayVideoView.this.igV.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.guO.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.igV.setVisibility(8);
                }
                return true;
            }
        };
        this.ddK = null;
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.ihd = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.igN != null && AutoPlayVideoView.this.dwx != null) {
                    AutoPlayVideoView.this.bYo();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.igL = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.guO = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.guU = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.igP = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dwx = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dwz = new n(this.mContext);
        this.dwx.setBusiness(this.dwz);
        this.igQ = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.igR = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.igS = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.igT = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.igT.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.igV = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.igW = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean bYn() {
        return s.bYn();
    }

    public void bYo() {
        if (bYn()) {
            this.dwx.setVideoPath(this.igN.video_url, this.cmS);
            this.dwx.start();
            this.igO = 0;
            if (!this.dwz.ccb() || this.ihb == null) {
                showLoading();
            }
            this.igV.setVisibility(8);
            pk(this.Cp);
            return;
        }
        boQ();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.igN = videoInfo;
        this.cmS = str;
        this.guO.setDefaultErrorResource(0);
        this.guO.setDefaultResource(0);
        this.guO.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.guO.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.guO.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dwx.setOnPreparedListener(this.ddL);
        this.dwx.setOnErrorListener(this.cUp);
        if (this.ddK != null) {
            this.dwx.setOnCompletionListener(this.ddK);
        }
        this.dwx.setOnSurfaceDestroyedListener(this.cUt);
        this.igQ.setCertainColumnCount(4);
        this.igQ.setColumnColor(R.color.cp_cont_a);
        this.igT.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igW.getLayoutParams();
        int equipmentWidth = l.getEquipmentWidth(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            equipmentWidth = ((equipmentWidth * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.getDimens(getContext(), R.dimen.ds120);
        }
        layoutParams.height = equipmentWidth;
        this.igW.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.guO.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = equipmentWidth;
        }
        this.guO.setLayoutParams(layoutParams2);
        this.guO.setOnClickListener(this.mOnClickListener);
        this.igW.setOnClickListener(this.mOnClickListener);
        this.igV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.Cp) {
                    AutoPlayVideoView.this.igM.dismiss();
                    AutoPlayVideoView.this.guO.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.igS.destroy();
        e.fZ().removeCallbacks(this.ihd);
        if (this.dwx.isPlaying()) {
            this.igX = this.dwx.getCurrentPosition();
            if (this.dwz.ccb() && this.ihc != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.ihc.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.igX), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.igN.video_width.intValue() / frameAtTime.getWidth(), this.igN.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.ihb;
                                    this.ihb = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.guO.setImageBitmap(this.ihb);
                                    this.guO.setForegroundDrawable(0);
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
                                this.igO = 3;
                                this.guO.setVisibility(0);
                                this.dwx.stopPlayback();
                                this.igQ.ll();
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
        this.igO = 3;
        this.guO.setVisibility(0);
        this.dwx.stopPlayback();
        this.igQ.ll();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.igR, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.igT, R.color.cp_cont_g, 1);
            am.setBackgroundResource(this.igT, R.drawable.btn_video, 1);
            this.igQ.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.igO;
    }

    public long getCurrentPosition() {
        return this.igX;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.ddK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.guU.setVisibility(0);
        this.guO.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boQ() {
        this.guU.setVisibility(8);
        this.guO.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.igZ = f;
        this.iha = f2;
    }

    public long getDuration() {
        if (this.dwx == null) {
            return this.igN.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.igN.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.igY = j;
    }

    /* loaded from: classes4.dex */
    private static class a extends Dialog {
        public a(Activity activity, View view, ViewGroup.LayoutParams layoutParams) {
            super(activity);
            setCanceledOnTouchOutside(false);
            setCancelable(true);
            requestWindowFeature(1);
            com.baidu.adp.lib.g.g.showDialog(this, activity);
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
    public void pk(boolean z) {
        this.mHandler.removeMessages(301);
        if (z) {
            this.igP.setVisibility(8);
            this.igS.setPlayer(this.dwx);
            return;
        }
        this.igS.setVisibility(8);
        this.igS.destroy();
        this.igP.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.igL != null && this.dwx != null) {
            if (!z) {
                if (this.igM != null) {
                    this.igM.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            pk(true);
            if (this.igU) {
                this.igT.setVisibility(0);
            }
            this.Cp = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igL.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.igL.getParent();
            viewGroup.removeAllViews();
            this.igM = new a(bdBaseActivity.getActivity(), this.igL, new ViewGroup.LayoutParams(-1, -1));
            this.igM.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.igL != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.pk(false);
                        AutoPlayVideoView.this.igT.setVisibility(8);
                        AutoPlayVideoView.this.Cp = false;
                        ((ViewGroup) AutoPlayVideoView.this.igL.getParent()).removeView(AutoPlayVideoView.this.igL);
                        viewGroup.addView(AutoPlayVideoView.this.igL);
                        AutoPlayVideoView.this.igL.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.igY = AutoPlayVideoView.this.igX;
                        if (AutoPlayVideoView.this.igV.getVisibility() != 0) {
                            AutoPlayVideoView.this.bYo();
                        }
                        AutoPlayVideoView.this.igV.setVisibility(8);
                    }
                }
            });
            this.igY = this.igX;
            bYo();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.igU = z;
    }
}
