package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.a.b.a;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ah;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.u;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes25.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> alV;
    private Animation bWB;
    boolean ecz;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnErrorListener emx;
    private CyberPlayerManager.OnCompletionListener emy;
    private CyberPlayerManager.OnInfoListener emz;
    private TbCyberVideoView.a fFk;
    private TbCyberVideoView giK;
    private CustomMessageListener iJR;
    private ForeDrawableImageView jRJ;
    private View mAA;
    private boolean mAB;
    private VideoInfo mAC;
    private AdvertAppInfo mAD;
    private int mAE;
    private TBLottieAnimationView mAF;
    private TextView mAG;
    private ImageView mAH;
    private ImageView mAI;
    private View mAJ;
    private TextView mAK;
    private View mAL;
    private ImageView mAM;
    private VideoControllerView mAN;
    private int mAO;
    private long mAP;
    private boolean mAQ;
    private long mAR;
    private b mAS;
    boolean mAT;
    private boolean mAU;
    private int mAV;
    boolean mAW;
    private int mAX;
    private Runnable mAY;
    private Runnable mAZ;
    private Runnable mBa;
    private CustomMessageListener mBb;
    private CustomMessageListener mBc;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private String mScheme;
    private int mStyle;
    private AdCard.a mtH;
    private AdCard.f mtI;
    private ViewGroup mwS;
    private d mwT;
    private e mwU;
    private boolean mzz;

    private void dAi() {
        String str = this.mAD != null ? this.mAD.exe : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && r.a(this.mContext, str, this.mAD) == 1) {
            ad(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dAi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBh() {
        ad(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxg() {
        if (this.mAF != null) {
            this.mAF.clearAnimation();
            this.mAF.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mAF.setVisibility(8);
                    DistributeVideoView.this.jRJ.setVisibility(8);
                    DistributeVideoView.this.wK(DistributeVideoView.this.mAQ);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mAG.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mAN.setPlayer(DistributeVideoView.this.giK);
                        DistributeVideoView.this.mAN.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mAC.video_duration.intValue()));
                        DistributeVideoView.this.mAN.showProgress();
                        DistributeVideoView.this.wL(true);
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(DistributeVideoView.this.mAZ);
                        com.baidu.adp.lib.f.e.mY().postDelayed(DistributeVideoView.this.mAZ, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mAP = DistributeVideoView.this.giK.getCurrentPosition();
                    DistributeVideoView.this.wM(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mAF.setMinFrame(0);
                    DistributeVideoView.this.mAF.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mAB = false;
        this.alV = null;
        this.mAO = -1;
        this.mAP = 0L;
        this.mAQ = false;
        this.mAR = 0L;
        this.mStyle = 1;
        this.ecz = false;
        this.mAT = false;
        this.mAU = false;
        this.mAW = false;
        this.mAX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mAJ) {
                    DistributeVideoView.this.mAJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mAI || view == DistributeVideoView.this.mAH) {
                    DistributeVideoView.this.wK(!DistributeVideoView.this.mAQ);
                } else if (view == DistributeVideoView.this.mAF || view == DistributeVideoView.this.mAM) {
                    DistributeVideoView.this.dBl();
                } else if (!(DistributeVideoView.this.mAS instanceof AdCard)) {
                    DistributeVideoView.this.dBl();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dBh();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mAO != 1) {
                            if (DistributeVideoView.this.giK.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mAO = 1;
                                DistributeVideoView.this.dxg();
                                return;
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        return;
                    case 1002:
                    default:
                        return;
                    case 1003:
                        if (DistributeVideoView.this.mAO == 1) {
                            if (DistributeVideoView.this.mAP == DistributeVideoView.this.giK.getCurrentPosition()) {
                                DistributeVideoView.this.bNw();
                            } else {
                                DistributeVideoView.this.mAP = DistributeVideoView.this.giK.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.mAV = DistributeVideoView.this.giK.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.giK.getDuration();
                    DistributeVideoView.this.giK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mAQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wK(false);
                    }
                }
            }
        };
        this.emz = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mAD != null) {
                    if (DistributeVideoView.this.mAW && "DETAIL".equals(DistributeVideoView.this.mAD.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ad(i3, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), 0);
                }
                return false;
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dBk();
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.ad(36, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), DistributeVideoView.this.giK.getCurrentPosition());
                }
                DistributeVideoView.this.jRJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mAJ.setVisibility(0);
                return true;
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mAR = System.currentTimeMillis();
                DistributeVideoView.this.mAW = true;
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.ad(34, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), DistributeVideoView.this.giK.getDuration());
                }
                DistributeVideoView.this.dBk();
                if (DistributeVideoView.this.mwU != null) {
                    DistributeVideoView.this.mwU.dBa();
                    DistributeVideoView.this.mAG.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mAY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mAC != null && DistributeVideoView.this.giK != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.IJ(1);
                }
            }
        };
        this.mAZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dBm();
            }
        };
        this.mBa = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wM(false);
            }
        };
        this.mBb = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mAU) {
                            DistributeVideoView.this.wK(true);
                            return;
                        } else {
                            DistributeVideoView.this.wK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mAU = DistributeVideoView.this.mAQ;
                    DistributeVideoView.this.wK(true);
                }
            }
        };
        this.iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wK(true);
                    }
                }
            }
        };
        this.mBc = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wM(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAB = false;
        this.alV = null;
        this.mAO = -1;
        this.mAP = 0L;
        this.mAQ = false;
        this.mAR = 0L;
        this.mStyle = 1;
        this.ecz = false;
        this.mAT = false;
        this.mAU = false;
        this.mAW = false;
        this.mAX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mAJ) {
                    DistributeVideoView.this.mAJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mAI || view == DistributeVideoView.this.mAH) {
                    DistributeVideoView.this.wK(!DistributeVideoView.this.mAQ);
                } else if (view == DistributeVideoView.this.mAF || view == DistributeVideoView.this.mAM) {
                    DistributeVideoView.this.dBl();
                } else if (!(DistributeVideoView.this.mAS instanceof AdCard)) {
                    DistributeVideoView.this.dBl();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dBh();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mAO != 1) {
                            if (DistributeVideoView.this.giK.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mAO = 1;
                                DistributeVideoView.this.dxg();
                                return;
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        return;
                    case 1002:
                    default:
                        return;
                    case 1003:
                        if (DistributeVideoView.this.mAO == 1) {
                            if (DistributeVideoView.this.mAP == DistributeVideoView.this.giK.getCurrentPosition()) {
                                DistributeVideoView.this.bNw();
                            } else {
                                DistributeVideoView.this.mAP = DistributeVideoView.this.giK.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.mAV = DistributeVideoView.this.giK.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.giK.getDuration();
                    DistributeVideoView.this.giK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mAQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wK(false);
                    }
                }
            }
        };
        this.emz = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mAD != null) {
                    if (DistributeVideoView.this.mAW && "DETAIL".equals(DistributeVideoView.this.mAD.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ad(i3, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), 0);
                }
                return false;
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dBk();
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.ad(36, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), DistributeVideoView.this.giK.getCurrentPosition());
                }
                DistributeVideoView.this.jRJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mAJ.setVisibility(0);
                return true;
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mAR = System.currentTimeMillis();
                DistributeVideoView.this.mAW = true;
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.ad(34, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), DistributeVideoView.this.giK.getDuration());
                }
                DistributeVideoView.this.dBk();
                if (DistributeVideoView.this.mwU != null) {
                    DistributeVideoView.this.mwU.dBa();
                    DistributeVideoView.this.mAG.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mAY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mAC != null && DistributeVideoView.this.giK != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.IJ(1);
                }
            }
        };
        this.mAZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dBm();
            }
        };
        this.mBa = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wM(false);
            }
        };
        this.mBb = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mAU) {
                            DistributeVideoView.this.wK(true);
                            return;
                        } else {
                            DistributeVideoView.this.wK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mAU = DistributeVideoView.this.mAQ;
                    DistributeVideoView.this.wK(true);
                }
            }
        };
        this.iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wK(true);
                    }
                }
            }
        };
        this.mBc = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wM(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAB = false;
        this.alV = null;
        this.mAO = -1;
        this.mAP = 0L;
        this.mAQ = false;
        this.mAR = 0L;
        this.mStyle = 1;
        this.ecz = false;
        this.mAT = false;
        this.mAU = false;
        this.mAW = false;
        this.mAX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mAJ) {
                    DistributeVideoView.this.mAJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mAI || view == DistributeVideoView.this.mAH) {
                    DistributeVideoView.this.wK(!DistributeVideoView.this.mAQ);
                } else if (view == DistributeVideoView.this.mAF || view == DistributeVideoView.this.mAM) {
                    DistributeVideoView.this.dBl();
                } else if (!(DistributeVideoView.this.mAS instanceof AdCard)) {
                    DistributeVideoView.this.dBl();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dBh();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mAO != 1) {
                            if (DistributeVideoView.this.giK.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mAO = 1;
                                DistributeVideoView.this.dxg();
                                return;
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        return;
                    case 1002:
                    default:
                        return;
                    case 1003:
                        if (DistributeVideoView.this.mAO == 1) {
                            if (DistributeVideoView.this.mAP == DistributeVideoView.this.giK.getCurrentPosition()) {
                                DistributeVideoView.this.bNw();
                            } else {
                                DistributeVideoView.this.mAP = DistributeVideoView.this.giK.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.mAV = DistributeVideoView.this.giK.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.giK.getDuration();
                    DistributeVideoView.this.giK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mAQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wK(false);
                    }
                }
            }
        };
        this.emz = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mAD != null) {
                    if (DistributeVideoView.this.mAW && "DETAIL".equals(DistributeVideoView.this.mAD.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ad(i3, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), 0);
                }
                return false;
            }
        };
        this.emx = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dBk();
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.ad(36, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), DistributeVideoView.this.giK.getCurrentPosition());
                }
                DistributeVideoView.this.jRJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mAJ.setVisibility(0);
                return true;
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mAR = System.currentTimeMillis();
                DistributeVideoView.this.mAW = true;
                if (DistributeVideoView.this.giK != null) {
                    DistributeVideoView.this.ad(34, DistributeVideoView.this.IK(DistributeVideoView.this.mAX), DistributeVideoView.this.giK.getDuration());
                }
                DistributeVideoView.this.dBk();
                if (DistributeVideoView.this.mwU != null) {
                    DistributeVideoView.this.mwU.dBa();
                    DistributeVideoView.this.mAG.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mAY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mAC != null && DistributeVideoView.this.giK != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.IJ(1);
                }
            }
        };
        this.mAZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dBm();
            }
        };
        this.mBa = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wM(false);
            }
        };
        this.mBb = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mAU) {
                            DistributeVideoView.this.wK(true);
                            return;
                        } else {
                            DistributeVideoView.this.wK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mAU = DistributeVideoView.this.mAQ;
                    DistributeVideoView.this.wK(true);
                }
            }
        };
        this.iJR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wK(true);
                    }
                }
            }
        };
        this.mBc = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wM(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mAS = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.giK = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.giK.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.giK.setNoBussinessStats();
            this.mAF = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jRJ = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mAG = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mAJ = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mAK = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mAH = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mAL = this.mRootView.findViewById(R.id.distribute_control);
            this.mAM = (ImageView) this.mAL.findViewById(R.id.distribute_play_icon);
            this.mAI = (ImageView) this.mAL.findViewById(R.id.distribute_voice);
            this.mAN = (VideoControllerView) this.mAL.findViewById(R.id.distribute_process);
            this.mwS = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mwT = new d(context, this.mwS);
            this.mAF.setAnimation(R.raw.lotti_video_loading);
            this.mAF.setMinFrame(0);
            this.mAF.setFrame(0);
            a.j(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dBi() {
        return this.mStyle == 1 ? u.dBi() : j.isWifiNet();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            initAnimation();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.mtH = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mtI = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mAC = videoInfo;
        this.mDuration = this.mAC.video_duration.intValue() * 1000;
        this.alV = new WeakReference<>(this.mContext.getApplicationContext());
        dBk();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mAC.video_width.intValue() > 0 ? (this.mAC.video_height.intValue() * equipmentWidth) / this.mAC.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jRJ.setDefaultErrorResource(0);
        this.jRJ.setDefaultResource(0);
        this.jRJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.jRJ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.giK.setOnPreparedListener(this.emw);
        this.giK.setOnErrorListener(this.emx);
        this.giK.setOnCompletionListener(this.emy);
        this.giK.setOnInfoListener(this.emz);
        this.giK.setOnSurfaceDestroyedListener(this.fFk);
        ap.setViewTextColor(this.mAG, R.color.cp_cont_m);
        this.mAG.setText(StringUtils.translateSecondsToString(this.mAC.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mAQ = false;
            ap.setImageResource(this.mAH, R.drawable.icon_vedio_npronunciation_small_white);
            this.mAH.setVisibility(8);
        } else {
            this.mAQ = true;
            ap.setImageResource(this.mAI, R.drawable.ad_icon_sound_open);
            this.mAH.setVisibility(8);
        }
        this.mAI.setOnClickListener(this.mOnClickListener);
        this.mAH.setOnClickListener(this.mOnClickListener);
        this.mAJ.setOnClickListener(this.mOnClickListener);
        this.mAJ.setVisibility(8);
        ap.setBackgroundColor(this.mAJ, R.color.black_alpha80);
        ap.setViewTextColor(this.mAK, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mAG.setVisibility(0);
            return;
        }
        this.mAG.setVisibility(8);
        this.mAM.setOnClickListener(this.mOnClickListener);
        this.mAF.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mAC = videoInfo;
        this.alV = new WeakReference<>(this.mContext.getApplicationContext());
        dBk();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jRJ.setDefaultErrorResource(0);
        this.jRJ.setDefaultResource(0);
        this.jRJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.jRJ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.giK.setOnPreparedListener(this.emw);
        this.giK.setOnErrorListener(this.emx);
        this.giK.setOnCompletionListener(this.emy);
        this.giK.setOnInfoListener(this.emz);
        this.giK.setOnSurfaceDestroyedListener(this.fFk);
        ap.setViewTextColor(this.mAG, R.color.cp_cont_m);
        this.mAG.setText(StringUtils.translateSecondsToString(this.mAC.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mAQ = false;
            ap.setImageResource(this.mAH, R.drawable.icon_vedio_npronunciation_small_white);
            this.mAH.setVisibility(8);
        } else {
            this.mAQ = true;
            ap.setImageResource(this.mAI, R.drawable.ad_icon_sound_open);
            this.mAH.setVisibility(8);
        }
        this.mAI.setOnClickListener(this.mOnClickListener);
        this.mAH.setOnClickListener(this.mOnClickListener);
        this.mAJ.setOnClickListener(this.mOnClickListener);
        this.mAJ.setVisibility(8);
        ap.setBackgroundColor(this.mAJ, R.color.black_alpha80);
        ap.setViewTextColor(this.mAK, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mAG.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mAG.setVisibility(8);
        this.mAM.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mAD;
        }
        this.mwU = this.mwT.a(this.mtI, this.mwU);
        if (this.mwU != null) {
            this.mwU.setPageContext(this.mPageContext);
            this.mwU.c(this.mAS);
            if (this.mwU instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.mwU).wI(this.mzz);
            }
            this.mwU.setAdvertAppInfo(advertAppInfo);
            this.mwU.a(this.mtI);
            this.mwU.dBb();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mzz = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mwU != null) {
            this.mwU.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int intValue = videoInfo.video_height.intValue();
        int intValue2 = videoInfo.video_width.intValue();
        if (i <= 0 || intValue <= 0 || intValue2 <= 0) {
            setViewSize(this.mRootView, i2, i3);
            return true;
        }
        setViewSize(this.mRootView, (intValue * i) / intValue2, i);
        return true;
    }

    protected void setViewSize(View view, int i, int i2) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.emy = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(int i) {
        this.mAX = i;
        if (this.mAC != null && this.mAO == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mAR) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mwU != null) {
                    this.mwU.dBb();
                }
                this.giK.setVideoPath(this.mAC.video_url);
                this.giK.start();
                this.mAV = this.giK.getCurrentPosition();
                ap.setImageResource(this.mAM, R.drawable.icon_video_midplay);
                bNw();
                this.mAJ.setVisibility(8);
                this.jRJ.setForegroundDrawable(0);
                this.mAO = 0;
                if (this.mStyle == 1) {
                    this.mAG.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mAG.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mBc);
                    this.mPageContext.registerListener(this.mBb);
                    this.mPageContext.registerListener(this.iJR);
                }
                ad(31, IK(this.mAX), 0);
            }
        }
    }

    public void performPlay() {
        IJ(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (dBi()) {
            if (i <= 0) {
                IJ(1);
                return;
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAY);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mAY, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mAO == 1) {
            H(32, IK(this.mAX), this.giK.getCurrentPosition(), i);
            this.giK.pause();
            ah.a(this.alV, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mAM, R.drawable.icon_video_midpause);
            this.mAO = 2;
        }
    }

    public void autoContinue() {
        if (!this.mAT) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mAO == 2) {
            this.mAX = i;
            ad(33, IK(i), this.giK.getCurrentPosition());
            this.mAV = this.giK.getCurrentPosition();
            this.giK.start();
            if (this.mAQ) {
                ah.a(this.alV, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mAM, R.drawable.icon_video_midplay);
            this.mAO = 1;
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNw() {
        if (this.mAF != null) {
            this.mAF.setAlpha(1.0f);
            this.mAF.setVisibility(0);
            this.mAF.loop(true);
            this.mAF.setMinAndMaxFrame(14, 80);
            this.mAF.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dBj();
        if (z) {
            this.mAF.setAlpha(1.0f);
            this.mAF.setVisibility(0);
            return;
        }
        this.mAF.setVisibility(8);
    }

    private void dBj() {
        if (this.mAF != null) {
            this.mAF.setMinFrame(0);
            this.mAF.setFrame(0);
            this.mAF.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        autoPlay(0);
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        stopPlay(true);
    }

    public void stopPlay(boolean z) {
        if (this.giK.getCurrentPosition() > 0 && this.mAO != -1 && z) {
            int i = 32;
            int currentPosition = this.giK.getCurrentPosition();
            if (this.giK.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, IK(this.mAX), currentPosition, this.giK.isPlaying());
        }
        dBk();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.giK.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mwS.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jRJ.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int Iu = com.baidu.tieba.recapp.lego.a.a.Iu(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = Iu;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = Iu;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = Iu;
            layoutParams4.height = equipmentWidth;
            ap.setBackgroundColor(this, R.color.black_alpha100);
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        }
        this.giK.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBk() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAY);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAZ);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mBa);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.giK.stopPlayback();
        this.mAO = -1;
        ah.a(this.alV, false);
        wM(false);
        this.jRJ.setForegroundDrawable(0);
        this.jRJ.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mAM, R.drawable.icon_video_midpause);
        this.mAN.aPs();
        this.mAJ.setVisibility(8);
        if (this.mAC != null) {
            this.mAG.setText(StringUtils.translateSecondsToString(this.mAC.video_duration.intValue()));
            this.mAG.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mAU = false;
        MessageManager.getInstance().unRegisterListener(this.mBc);
        MessageManager.getInstance().unRegisterListener(this.mBb);
        MessageManager.getInstance().unRegisterListener(this.iJR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int IK(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
        }
        return 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.mAC != null ? this.mAC.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mwU instanceof com.baidu.tieba.recapp.e.a) && (this.mAS instanceof AdCard) && !((AdCard) this.mAS).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mwU).bII();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mwU instanceof com.baidu.tieba.recapp.e.a) && (this.mAS instanceof AdCard) && !((AdCard) this.mAS).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mwU).dAZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wK(boolean z) {
        if (z) {
            if (this.giK != null) {
                this.giK.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mAI, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mAH, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mAO == 1) {
                ah.a(this.alV, true);
            }
        } else {
            if (this.giK != null) {
                this.giK.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mAI, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mAH, R.drawable.icon_vedio_npronunciation_small_white);
            ah.a(this.alV, false);
        }
        this.mAQ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.mAO;
    }

    public VideoInfo getData() {
        return this.mAC;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.mAP;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mAD = advertAppInfo;
        this.mAE = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = g.a(this.mAD, 303, i, IK(this.mAX), this.mAC.video_duration.intValue(), this.mDuration, -1);
        if (this.mwU != null) {
            this.mwU.e(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(int i, int i2, int i3) {
        H(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void H(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.mAD != null && this.mAC != null) {
            this.mAD.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dAT().a(g.a(this.mAD, i, this.mAE, i2, this.mAC.video_duration.intValue(), com.baidu.tieba.ad.a.a.tO(i3), i4));
            if (z && i != 31 && i != 33 && i != 35 && i != 2) {
                if (i == 34) {
                    str = "com";
                } else if (i == 36) {
                    str = Config.EXCEPTION_PART;
                } else {
                    str = "other";
                    if (i4 == 1) {
                        str = "hide";
                    } else if (i4 == 0) {
                        str = "cl_pau";
                    }
                }
                if ("DETAIL".equals(this.mPage)) {
                    str2 = "det";
                } else if ("FRS".equals(this.mPage)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.mPage)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.mAV, i3, this.mDuration, str2, IL(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mtH != null && AdCard.CHARGE_STYLE_CPV.equals(this.mtH.muJ) && !TextUtils.isEmpty(this.mtH.muK)) {
            new com.baidu.tieba.recapp.request.a(this.mtH.muK).a(str, i, i2, i3, str2, str3);
        }
    }

    private String IL(int i) {
        if (i == 0) {
            return ActVideoSetting.ACT_URL;
        }
        if (i != 1) {
            return ActVideoSetting.ACT_URL;
        }
        return Config.CELL_LOCATION;
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.mAA = view;
            this.mAB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAZ);
            if (this.bWB != null) {
                this.bWB.cancel();
            }
            this.mAL.setVisibility(0);
            if (this.mAO == 1) {
                ap.setImageResource(this.mAM, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mAM, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mAL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBl() {
        switch (this.mAO) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.os(R.string.play_video_mobile_tip);
                    aVar.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            DistributeVideoView.this.performPlay();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(this.mPageContext).bog();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mAT = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    wL(true);
                    return;
                }
                return;
            case 2:
                this.mAT = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAZ);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.mAZ, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBm() {
        if (!this.ecz && this.bWB != null) {
            this.mAL.startAnimation(this.bWB);
            this.ecz = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bWB = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bWB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mAL.setVisibility(8);
                    DistributeVideoView.this.ecz = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dBn() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mBa);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mBa, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wM(boolean z) {
        if (this.mAH != null && this.mStyle == 1) {
            if (z) {
                this.mAH.setVisibility(0);
                dBn();
                return;
            }
            this.mAH.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
