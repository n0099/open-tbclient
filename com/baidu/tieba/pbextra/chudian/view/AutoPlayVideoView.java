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
    private boolean BP;
    private QuickVideoView.b cTC;
    private g.b cTy;
    private String cma;
    private g.a dcS;
    private g.f dcT;
    private QuickVideoView dvG;
    private n dvI;
    private ForeDrawableImageView gtX;
    private View gud;
    private View ifU;
    private a ifV;
    private VideoInfo ifW;
    private int ifX;
    private RelativeLayout ifY;
    private AudioAnimationView ifZ;
    private TextView iga;
    private PbChudianProcessBar igb;
    private TextView igc;
    private boolean igd;
    private View ige;
    private View igf;
    private long igg;
    private long igh;
    private float igi;
    private float igj;
    private Bitmap igk;
    private MediaMetadataRetriever igl;
    private Runnable igm;
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
        this.ifX = -1;
        this.BP = false;
        this.igd = false;
        this.mOnClickListener = null;
        this.igg = 0L;
        this.igh = 0L;
        this.mDuration = 0L;
        this.igi = 1.0f;
        this.igj = 1.0f;
        this.igk = null;
        this.igl = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.ifX != 1) {
                            if (AutoPlayVideoView.this.dvG.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igg = AutoPlayVideoView.this.igh;
                            AutoPlayVideoView.this.gud.setVisibility(8);
                            if (!AutoPlayVideoView.this.dvI.cbZ() || AutoPlayVideoView.this.igk == null) {
                                AutoPlayVideoView.this.dvG.seekTo((int) AutoPlayVideoView.this.igh);
                                AutoPlayVideoView.this.gtX.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dvG.getDuration();
                            AutoPlayVideoView.this.ifX = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.BP) {
                                AutoPlayVideoView.this.igb.setVisibility(0);
                                AutoPlayVideoView.this.igb.z(AutoPlayVideoView.this.igh, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igb.bYn();
                                return;
                            }
                            AutoPlayVideoView.this.ifZ.ll();
                            AutoPlayVideoView.this.ifZ.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.BP) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dvG.getDuration() - AutoPlayVideoView.this.dvG.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iga.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.ifX == 1) {
                            if (AutoPlayVideoView.this.igg == AutoPlayVideoView.this.dvG.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igg = AutoPlayVideoView.this.dvG.getCurrentPosition();
                                AutoPlayVideoView.this.boO();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dvG.isPlaying() && AutoPlayVideoView.this.dvI.cbZ() && AutoPlayVideoView.this.igk != null) {
                            if (AutoPlayVideoView.this.dvG.getCurrentPosition() > AutoPlayVideoView.this.igh) {
                                AutoPlayVideoView.this.gtX.setVisibility(8);
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
        this.dcT = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dvG != null && AutoPlayVideoView.this.dvI.cbZ()) {
                        if (AutoPlayVideoView.this.igl == null) {
                            AutoPlayVideoView.this.igl = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.igl.setDataSource(AutoPlayVideoView.this.dvI.qX(AutoPlayVideoView.this.dvI.cbY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.igk != null) {
                            AutoPlayVideoView.this.dvG.seekTo((int) AutoPlayVideoView.this.igh);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igi, AutoPlayVideoView.this.igj);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ifW;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boO();
                AutoPlayVideoView.this.igh = 0L;
                if (AutoPlayVideoView.this.BP) {
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ige.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.ige.setVisibility(8);
                }
                return true;
            }
        };
        this.dcS = null;
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.igm = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ifW != null && AutoPlayVideoView.this.dvG != null) {
                    AutoPlayVideoView.this.bYm();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mSkinType = 3;
        this.ifX = -1;
        this.BP = false;
        this.igd = false;
        this.mOnClickListener = null;
        this.igg = 0L;
        this.igh = 0L;
        this.mDuration = 0L;
        this.igi = 1.0f;
        this.igj = 1.0f;
        this.igk = null;
        this.igl = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.ifX != 1) {
                            if (AutoPlayVideoView.this.dvG.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igg = AutoPlayVideoView.this.igh;
                            AutoPlayVideoView.this.gud.setVisibility(8);
                            if (!AutoPlayVideoView.this.dvI.cbZ() || AutoPlayVideoView.this.igk == null) {
                                AutoPlayVideoView.this.dvG.seekTo((int) AutoPlayVideoView.this.igh);
                                AutoPlayVideoView.this.gtX.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dvG.getDuration();
                            AutoPlayVideoView.this.ifX = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.BP) {
                                AutoPlayVideoView.this.igb.setVisibility(0);
                                AutoPlayVideoView.this.igb.z(AutoPlayVideoView.this.igh, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igb.bYn();
                                return;
                            }
                            AutoPlayVideoView.this.ifZ.ll();
                            AutoPlayVideoView.this.ifZ.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.BP) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dvG.getDuration() - AutoPlayVideoView.this.dvG.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iga.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.ifX == 1) {
                            if (AutoPlayVideoView.this.igg == AutoPlayVideoView.this.dvG.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igg = AutoPlayVideoView.this.dvG.getCurrentPosition();
                                AutoPlayVideoView.this.boO();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dvG.isPlaying() && AutoPlayVideoView.this.dvI.cbZ() && AutoPlayVideoView.this.igk != null) {
                            if (AutoPlayVideoView.this.dvG.getCurrentPosition() > AutoPlayVideoView.this.igh) {
                                AutoPlayVideoView.this.gtX.setVisibility(8);
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
        this.dcT = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dvG != null && AutoPlayVideoView.this.dvI.cbZ()) {
                        if (AutoPlayVideoView.this.igl == null) {
                            AutoPlayVideoView.this.igl = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.igl.setDataSource(AutoPlayVideoView.this.dvI.qX(AutoPlayVideoView.this.dvI.cbY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.igk != null) {
                            AutoPlayVideoView.this.dvG.seekTo((int) AutoPlayVideoView.this.igh);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igi, AutoPlayVideoView.this.igj);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ifW;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boO();
                AutoPlayVideoView.this.igh = 0L;
                if (AutoPlayVideoView.this.BP) {
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ige.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.ige.setVisibility(8);
                }
                return true;
            }
        };
        this.dcS = null;
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.igm = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ifW != null && AutoPlayVideoView.this.dvG != null) {
                    AutoPlayVideoView.this.bYm();
                }
            }
        };
        this.mContext = context;
        init();
    }

    public AutoPlayVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ifX = -1;
        this.BP = false;
        this.igd = false;
        this.mOnClickListener = null;
        this.igg = 0L;
        this.igh = 0L;
        this.mDuration = 0L;
        this.igi = 1.0f;
        this.igj = 1.0f;
        this.igk = null;
        this.igl = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 202:
                        if (AutoPlayVideoView.this.ifX != 1) {
                            if (AutoPlayVideoView.this.dvG.getCurrentPosition() <= 0) {
                                Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                                obtainMessage.obj = message.obj;
                                AutoPlayVideoView.this.mHandler.sendMessageDelayed(obtainMessage, 500L);
                                return;
                            }
                            AutoPlayVideoView.this.igg = AutoPlayVideoView.this.igh;
                            AutoPlayVideoView.this.gud.setVisibility(8);
                            if (!AutoPlayVideoView.this.dvI.cbZ() || AutoPlayVideoView.this.igk == null) {
                                AutoPlayVideoView.this.dvG.seekTo((int) AutoPlayVideoView.this.igh);
                                AutoPlayVideoView.this.gtX.setVisibility(8);
                            } else {
                                AutoPlayVideoView.this.mHandler.removeMessages(501);
                                AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(501, TimeUnit.MILLISECONDS.toMillis(200L));
                            }
                            AutoPlayVideoView.this.mDuration = AutoPlayVideoView.this.dvG.getDuration();
                            AutoPlayVideoView.this.ifX = 1;
                            AutoPlayVideoView.this.mHandler.removeMessages(401);
                            AutoPlayVideoView.this.mHandler.removeMessages(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessage(301);
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            if (AutoPlayVideoView.this.BP) {
                                AutoPlayVideoView.this.igb.setVisibility(0);
                                AutoPlayVideoView.this.igb.z(AutoPlayVideoView.this.igh, AutoPlayVideoView.this.mDuration);
                                AutoPlayVideoView.this.igb.bYn();
                                return;
                            }
                            AutoPlayVideoView.this.ifZ.ll();
                            AutoPlayVideoView.this.ifZ.start();
                            return;
                        }
                        return;
                    case 301:
                        if (!AutoPlayVideoView.this.BP) {
                            long seconds = TimeUnit.MILLISECONDS.toSeconds(AutoPlayVideoView.this.dvG.getDuration() - AutoPlayVideoView.this.dvG.getCurrentPosition());
                            if (seconds >= 0) {
                                AutoPlayVideoView.this.iga.setText(StringUtils.translateSecondsToString((int) seconds));
                            } else {
                                BdLog.e("AutoPlayVideoView: wrong time");
                                return;
                            }
                        }
                        AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(301, TimeUnit.SECONDS.toMillis(1L));
                        return;
                    case 401:
                        if (AutoPlayVideoView.this.ifX == 1) {
                            if (AutoPlayVideoView.this.igg == AutoPlayVideoView.this.dvG.getCurrentPosition()) {
                                AutoPlayVideoView.this.showLoading();
                            } else {
                                AutoPlayVideoView.this.igg = AutoPlayVideoView.this.dvG.getCurrentPosition();
                                AutoPlayVideoView.this.boO();
                            }
                            AutoPlayVideoView.this.mHandler.sendEmptyMessageDelayed(401, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    case 501:
                        if (AutoPlayVideoView.this.dvG.isPlaying() && AutoPlayVideoView.this.dvI.cbZ() && AutoPlayVideoView.this.igk != null) {
                            if (AutoPlayVideoView.this.dvG.getCurrentPosition() > AutoPlayVideoView.this.igh) {
                                AutoPlayVideoView.this.gtX.setVisibility(8);
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
        this.dcT = new g.f() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.2
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    if (AutoPlayVideoView.this.dvG != null && AutoPlayVideoView.this.dvI.cbZ()) {
                        if (AutoPlayVideoView.this.igl == null) {
                            AutoPlayVideoView.this.igl = new MediaMetadataRetriever();
                            try {
                                AutoPlayVideoView.this.igl.setDataSource(AutoPlayVideoView.this.dvI.qX(AutoPlayVideoView.this.dvI.cbY()));
                            } catch (IllegalArgumentException e) {
                                BdLog.e(e.getMessage());
                            }
                        }
                        if (AutoPlayVideoView.this.igk != null) {
                            AutoPlayVideoView.this.dvG.seekTo((int) AutoPlayVideoView.this.igh);
                        }
                    }
                    gVar.setVolume(AutoPlayVideoView.this.igi, AutoPlayVideoView.this.igj);
                    Message obtainMessage = AutoPlayVideoView.this.mHandler.obtainMessage(202);
                    obtainMessage.obj = AutoPlayVideoView.this.ifW;
                    AutoPlayVideoView.this.mHandler.sendMessage(obtainMessage);
                }
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.3
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                AutoPlayVideoView.this.stopPlay();
                AutoPlayVideoView.this.boO();
                AutoPlayVideoView.this.igh = 0L;
                if (AutoPlayVideoView.this.BP) {
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(0);
                    AutoPlayVideoView.this.ige.setVisibility(0);
                } else {
                    l.showToast(AutoPlayVideoView.this.getContext(), (int) R.string.pb_play_error);
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(R.drawable.icon_play_video);
                    AutoPlayVideoView.this.ige.setVisibility(8);
                }
                return true;
            }
        };
        this.dcS = null;
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.4
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                AutoPlayVideoView.this.stopPlay();
            }
        };
        this.igm = new Runnable() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                if (AutoPlayVideoView.this.ifW != null && AutoPlayVideoView.this.dvG != null) {
                    AutoPlayVideoView.this.bYm();
                }
            }
        };
        this.mContext = context;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.auto_play_video_view, (ViewGroup) this, true);
        this.ifU = this.mRootView.findViewById(R.id.content_wrapper);
        this.mMaskView = this.mRootView.findViewById(R.id.auto_video_black_mask);
        this.gtX = (ForeDrawableImageView) this.mRootView.findViewById(R.id.pb_list_video_item_thumbnail);
        this.gud = this.mRootView.findViewById(R.id.pb_layout_loading);
        this.ifY = (RelativeLayout) this.mRootView.findViewById(R.id.process_bar);
        this.dvG = (QuickVideoView) this.mRootView.findViewById(R.id.texture_video_view);
        this.dvI = new n(this.mContext);
        this.dvG.setBusiness(this.dvI);
        this.ifZ = (AudioAnimationView) this.mRootView.findViewById(R.id.playing_animation);
        this.iga = (TextView) this.mRootView.findViewById(R.id.count_down_process);
        this.igb = (PbChudianProcessBar) this.mRootView.findViewById(R.id.full_screen_process_bar);
        this.igc = (TextView) this.mRootView.findViewById(R.id.check_detail);
        this.igc.setTag(R.id.tag_pb_chudian_check_detail, true);
        this.ige = this.mRootView.findViewById(R.id.chudian_error_tip);
        this.igf = this.mRootView.findViewById(R.id.available_click_area);
    }

    private boolean bYl() {
        return s.bYl();
    }

    public void bYm() {
        if (bYl()) {
            this.dvG.setVideoPath(this.ifW.video_url, this.cma);
            this.dvG.start();
            this.ifX = 0;
            if (!this.dvI.cbZ() || this.igk == null) {
                showLoading();
            }
            this.ige.setVisibility(8);
            pk(this.BP);
            return;
        }
        boO();
    }

    public void setData(VideoInfo videoInfo, String str) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ifW = videoInfo;
        this.cma = str;
        this.gtX.setDefaultErrorResource(0);
        this.gtX.setDefaultResource(0);
        this.gtX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.gtX.setForegroundDrawable(R.drawable.icon_play_video);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gtX.startLoad(videoInfo.thumbnail_url, 17, false);
        }
        this.dvG.setOnPreparedListener(this.dcT);
        this.dvG.setOnErrorListener(this.cTy);
        if (this.dcS != null) {
            this.dvG.setOnCompletionListener(this.dcS);
        }
        this.dvG.setOnSurfaceDestroyedListener(this.cTC);
        this.ifZ.setCertainColumnCount(4);
        this.ifZ.setColumnColor(R.color.cp_cont_a);
        this.igc.setOnClickListener(this.mOnClickListener);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igf.getLayoutParams();
        int equipmentWidth = l.getEquipmentWidth(this.mContext);
        if (videoInfo.video_width.intValue() > 0) {
            equipmentWidth = ((equipmentWidth * videoInfo.video_height.intValue()) / videoInfo.video_width.intValue()) + l.getDimens(getContext(), R.dimen.ds120);
        }
        layoutParams.height = equipmentWidth;
        this.igf.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gtX.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = equipmentWidth;
        }
        this.gtX.setLayoutParams(layoutParams2);
        this.gtX.setOnClickListener(this.mOnClickListener);
        this.igf.setOnClickListener(this.mOnClickListener);
        this.ige.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AutoPlayVideoView.this.BP) {
                    AutoPlayVideoView.this.ifV.dismiss();
                    AutoPlayVideoView.this.gtX.setForegroundDrawable(R.drawable.icon_play_video);
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
        this.igb.destroy();
        e.fZ().removeCallbacks(this.igm);
        if (this.dvG.isPlaying()) {
            this.igg = this.dvG.getCurrentPosition();
            if (this.dvI.cbZ() && this.igl != null) {
                Bitmap bitmap = null;
                try {
                    try {
                        Bitmap frameAtTime = this.igl.getFrameAtTime(TimeUnit.MILLISECONDS.toMicros(this.igg), 2);
                        if (frameAtTime != null) {
                            try {
                                if (frameAtTime.getWidth() > 0 && frameAtTime.getHeight() > 0) {
                                    Matrix matrix = new Matrix();
                                    matrix.postScale(this.ifW.video_width.intValue() / frameAtTime.getWidth(), this.ifW.video_height.intValue() / frameAtTime.getHeight());
                                    Bitmap bitmap2 = this.igk;
                                    this.igk = Bitmap.createBitmap(frameAtTime, 0, 0, frameAtTime.getWidth(), frameAtTime.getHeight(), matrix, true);
                                    this.gtX.setImageBitmap(this.igk);
                                    this.gtX.setForegroundDrawable(0);
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
                                this.ifX = 3;
                                this.gtX.setVisibility(0);
                                this.dvG.stopPlayback();
                                this.ifZ.ll();
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
        this.ifX = 3;
        this.gtX.setVisibility(0);
        this.dvG.stopPlayback();
        this.ifZ.ll();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.iga, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.igc, R.color.cp_cont_g, 1);
            am.setBackgroundResource(this.igc, R.drawable.btn_video, 1);
            this.ifZ.onChangeSkinType(i);
            this.mSkinType = i;
        }
    }

    public int getPlayStatus() {
        return this.ifX;
    }

    public long getCurrentPosition() {
        return this.igg;
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.dcS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        this.gud.setVisibility(0);
        this.gtX.setForegroundDrawable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boO() {
        this.gud.setVisibility(8);
        this.gtX.setForegroundDrawable(R.drawable.icon_play_video);
    }

    public void setVolume(float f, float f2) {
        this.igi = f;
        this.igj = f2;
    }

    public long getDuration() {
        if (this.dvG == null) {
            return this.ifW.video_duration.intValue();
        }
        if (this.mDuration <= 0) {
            return this.ifW.video_duration.intValue();
        }
        return this.mDuration;
    }

    public void setStartPosition(long j) {
        this.igh = j;
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
            this.ifY.setVisibility(8);
            this.igb.setPlayer(this.dvG);
            return;
        }
        this.igb.setVisibility(8);
        this.igb.destroy();
        this.ifY.setVisibility(0);
    }

    public void setFullScreen(BdBaseActivity<?> bdBaseActivity, boolean z) {
        if (this.ifU != null && this.dvG != null) {
            if (!z) {
                if (this.ifV != null) {
                    this.ifV.dismiss();
                    return;
                }
                return;
            }
            setVolume(1.0f, 1.0f);
            pk(true);
            if (this.igd) {
                this.igc.setVisibility(0);
            }
            this.BP = true;
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifU.getLayoutParams();
            final ViewGroup viewGroup = (ViewGroup) this.ifU.getParent();
            viewGroup.removeAllViews();
            this.ifV = new a(bdBaseActivity.getActivity(), this.ifU, new ViewGroup.LayoutParams(-1, -1));
            this.ifV.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.pbextra.chudian.view.AutoPlayVideoView.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (AutoPlayVideoView.this.ifU != null && viewGroup != null && layoutParams != null) {
                        AutoPlayVideoView.this.setVolume(0.0f, 0.0f);
                        AutoPlayVideoView.this.pk(false);
                        AutoPlayVideoView.this.igc.setVisibility(8);
                        AutoPlayVideoView.this.BP = false;
                        ((ViewGroup) AutoPlayVideoView.this.ifU.getParent()).removeView(AutoPlayVideoView.this.ifU);
                        viewGroup.addView(AutoPlayVideoView.this.ifU);
                        AutoPlayVideoView.this.ifU.setLayoutParams(layoutParams);
                        AutoPlayVideoView.this.igh = AutoPlayVideoView.this.igg;
                        if (AutoPlayVideoView.this.ige.getVisibility() != 0) {
                            AutoPlayVideoView.this.bYm();
                        }
                        AutoPlayVideoView.this.ige.setVisibility(8);
                    }
                }
            });
            this.igh = this.igg;
            bYm();
        }
    }

    public void setNeedDisplayBottomView(boolean z) {
        this.igd = z;
    }
}
