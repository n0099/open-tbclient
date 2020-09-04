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
import com.baidu.tbadk.core.util.at;
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
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.u;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes20.dex */
public class DistributeVideoView extends RelativeLayout implements h {
    private WeakReference<Context> akW;
    private Animation bAh;
    boolean dBR;
    private CyberPlayerManager.OnPreparedListener dLL;
    private CyberPlayerManager.OnErrorListener dLM;
    private CyberPlayerManager.OnCompletionListener dLN;
    private CyberPlayerManager.OnInfoListener dLO;
    private TbCyberVideoView fDP;
    private TbCyberVideoView.a fcn;
    private CustomMessageListener hUJ;
    private ForeDrawableImageView jaZ;
    private AdCard.a lCK;
    private AdCard.f lCL;
    private ViewGroup lFX;
    private d lFY;
    private e lFZ;
    private boolean lIn;
    private VideoControllerView lJA;
    private int lJB;
    private long lJC;
    private boolean lJD;
    private long lJE;
    private b lJF;
    boolean lJG;
    private boolean lJH;
    private int lJI;
    boolean lJJ;
    private int lJK;
    private Runnable lJL;
    private Runnable lJM;
    private Runnable lJN;
    private CustomMessageListener lJO;
    private View lJn;
    private boolean lJo;
    private VideoInfo lJp;
    private AdvertAppInfo lJq;
    private int lJr;
    private TBLottieAnimationView lJs;
    private TextView lJt;
    private ImageView lJu;
    private ImageView lJv;
    private View lJw;
    private TextView lJx;
    private View lJy;
    private ImageView lJz;
    private CustomMessageListener lvw;
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

    private void dnI() {
        String str = this.lJq != null ? this.lJq.dWl : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.lJq) == 1) {
            Y(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dnI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doz() {
        Y(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkF() {
        if (this.lJs != null) {
            this.lJs.clearAnimation();
            this.lJs.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.lJs.setVisibility(8);
                    DistributeVideoView.this.jaZ.setVisibility(8);
                    DistributeVideoView.this.vs(DistributeVideoView.this.lJD);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.lJt.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.lJA.setPlayer(DistributeVideoView.this.fDP);
                        DistributeVideoView.this.lJA.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.lJp.video_duration.intValue()));
                        DistributeVideoView.this.lJA.showProgress();
                        DistributeVideoView.this.vt(true);
                        com.baidu.adp.lib.f.e.mS().removeCallbacks(DistributeVideoView.this.lJM);
                        com.baidu.adp.lib.f.e.mS().postDelayed(DistributeVideoView.this.lJM, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.lJC = DistributeVideoView.this.fDP.getCurrentPosition();
                    DistributeVideoView.this.vu(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.lJs.setMinFrame(0);
                    DistributeVideoView.this.lJs.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.lJo = false;
        this.akW = null;
        this.lJB = -1;
        this.lJC = 0L;
        this.lJD = false;
        this.lJE = 0L;
        this.mStyle = 1;
        this.dBR = false;
        this.lJG = false;
        this.lJH = false;
        this.lJJ = false;
        this.lJK = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lJw) {
                    DistributeVideoView.this.lJw.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lJv || view == DistributeVideoView.this.lJu) {
                    DistributeVideoView.this.vs(!DistributeVideoView.this.lJD);
                } else if (view == DistributeVideoView.this.lJs || view == DistributeVideoView.this.lJz) {
                    DistributeVideoView.this.doD();
                } else if (!(DistributeVideoView.this.lJF instanceof AdCard)) {
                    DistributeVideoView.this.doD();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.doz();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lJB != 1) {
                            if (DistributeVideoView.this.fDP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lJB = 1;
                                DistributeVideoView.this.dkF();
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
                        if (DistributeVideoView.this.lJB == 1) {
                            if (DistributeVideoView.this.lJC == DistributeVideoView.this.fDP.getCurrentPosition()) {
                                DistributeVideoView.this.bFc();
                            } else {
                                DistributeVideoView.this.lJC = DistributeVideoView.this.fDP.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.lJI = DistributeVideoView.this.fDP.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fDP.getDuration();
                    DistributeVideoView.this.fDP.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lJD && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vs(false);
                    }
                }
            }
        };
        this.dLO = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lJq != null) {
                    if (DistributeVideoView.this.lJJ && "DETAIL".equals(DistributeVideoView.this.lJq.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), 0);
                }
                return false;
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.doC();
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.Y(36, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), DistributeVideoView.this.fDP.getCurrentPosition());
                }
                DistributeVideoView.this.jaZ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lJw.setVisibility(0);
                return true;
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lJE = System.currentTimeMillis();
                DistributeVideoView.this.lJJ = true;
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.Y(34, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), DistributeVideoView.this.fDP.getDuration());
                }
                DistributeVideoView.this.doC();
                if (DistributeVideoView.this.lFZ != null) {
                    DistributeVideoView.this.lFZ.dos();
                    DistributeVideoView.this.lJt.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lJL = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lJp != null && DistributeVideoView.this.fDP != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Gv(1);
                }
            }
        };
        this.lJM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.doE();
            }
        };
        this.lJN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vu(false);
            }
        };
        this.lvw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lJH) {
                            DistributeVideoView.this.vs(true);
                            return;
                        } else {
                            DistributeVideoView.this.vs(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lJH = DistributeVideoView.this.lJD;
                    DistributeVideoView.this.vs(true);
                }
            }
        };
        this.hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vs(true);
                    }
                }
            }
        };
        this.lJO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vu(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lJo = false;
        this.akW = null;
        this.lJB = -1;
        this.lJC = 0L;
        this.lJD = false;
        this.lJE = 0L;
        this.mStyle = 1;
        this.dBR = false;
        this.lJG = false;
        this.lJH = false;
        this.lJJ = false;
        this.lJK = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lJw) {
                    DistributeVideoView.this.lJw.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lJv || view == DistributeVideoView.this.lJu) {
                    DistributeVideoView.this.vs(!DistributeVideoView.this.lJD);
                } else if (view == DistributeVideoView.this.lJs || view == DistributeVideoView.this.lJz) {
                    DistributeVideoView.this.doD();
                } else if (!(DistributeVideoView.this.lJF instanceof AdCard)) {
                    DistributeVideoView.this.doD();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.doz();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lJB != 1) {
                            if (DistributeVideoView.this.fDP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lJB = 1;
                                DistributeVideoView.this.dkF();
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
                        if (DistributeVideoView.this.lJB == 1) {
                            if (DistributeVideoView.this.lJC == DistributeVideoView.this.fDP.getCurrentPosition()) {
                                DistributeVideoView.this.bFc();
                            } else {
                                DistributeVideoView.this.lJC = DistributeVideoView.this.fDP.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.lJI = DistributeVideoView.this.fDP.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fDP.getDuration();
                    DistributeVideoView.this.fDP.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lJD && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vs(false);
                    }
                }
            }
        };
        this.dLO = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lJq != null) {
                    if (DistributeVideoView.this.lJJ && "DETAIL".equals(DistributeVideoView.this.lJq.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), 0);
                }
                return false;
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.doC();
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.Y(36, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), DistributeVideoView.this.fDP.getCurrentPosition());
                }
                DistributeVideoView.this.jaZ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lJw.setVisibility(0);
                return true;
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lJE = System.currentTimeMillis();
                DistributeVideoView.this.lJJ = true;
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.Y(34, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), DistributeVideoView.this.fDP.getDuration());
                }
                DistributeVideoView.this.doC();
                if (DistributeVideoView.this.lFZ != null) {
                    DistributeVideoView.this.lFZ.dos();
                    DistributeVideoView.this.lJt.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lJL = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lJp != null && DistributeVideoView.this.fDP != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Gv(1);
                }
            }
        };
        this.lJM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.doE();
            }
        };
        this.lJN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vu(false);
            }
        };
        this.lvw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lJH) {
                            DistributeVideoView.this.vs(true);
                            return;
                        } else {
                            DistributeVideoView.this.vs(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lJH = DistributeVideoView.this.lJD;
                    DistributeVideoView.this.vs(true);
                }
            }
        };
        this.hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vs(true);
                    }
                }
            }
        };
        this.lJO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vu(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lJo = false;
        this.akW = null;
        this.lJB = -1;
        this.lJC = 0L;
        this.lJD = false;
        this.lJE = 0L;
        this.mStyle = 1;
        this.dBR = false;
        this.lJG = false;
        this.lJH = false;
        this.lJJ = false;
        this.lJK = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lJw) {
                    DistributeVideoView.this.lJw.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lJv || view == DistributeVideoView.this.lJu) {
                    DistributeVideoView.this.vs(!DistributeVideoView.this.lJD);
                } else if (view == DistributeVideoView.this.lJs || view == DistributeVideoView.this.lJz) {
                    DistributeVideoView.this.doD();
                } else if (!(DistributeVideoView.this.lJF instanceof AdCard)) {
                    DistributeVideoView.this.doD();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.doz();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lJB != 1) {
                            if (DistributeVideoView.this.fDP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lJB = 1;
                                DistributeVideoView.this.dkF();
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
                        if (DistributeVideoView.this.lJB == 1) {
                            if (DistributeVideoView.this.lJC == DistributeVideoView.this.fDP.getCurrentPosition()) {
                                DistributeVideoView.this.bFc();
                            } else {
                                DistributeVideoView.this.lJC = DistributeVideoView.this.fDP.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dLL = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.lJI = DistributeVideoView.this.fDP.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fDP.getDuration();
                    DistributeVideoView.this.fDP.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lJD && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vs(false);
                    }
                }
            }
        };
        this.dLO = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.lJq != null) {
                    if (DistributeVideoView.this.lJJ && "DETAIL".equals(DistributeVideoView.this.lJq.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), 0);
                }
                return false;
            }
        };
        this.dLM = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.doC();
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.Y(36, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), DistributeVideoView.this.fDP.getCurrentPosition());
                }
                DistributeVideoView.this.jaZ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lJw.setVisibility(0);
                return true;
            }
        };
        this.dLN = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lJE = System.currentTimeMillis();
                DistributeVideoView.this.lJJ = true;
                if (DistributeVideoView.this.fDP != null) {
                    DistributeVideoView.this.Y(34, DistributeVideoView.this.Gw(DistributeVideoView.this.lJK), DistributeVideoView.this.fDP.getDuration());
                }
                DistributeVideoView.this.doC();
                if (DistributeVideoView.this.lFZ != null) {
                    DistributeVideoView.this.lFZ.dos();
                    DistributeVideoView.this.lJt.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fcn = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lJL = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lJp != null && DistributeVideoView.this.fDP != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Gv(1);
                }
            }
        };
        this.lJM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.doE();
            }
        };
        this.lJN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vu(false);
            }
        };
        this.lvw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lJH) {
                            DistributeVideoView.this.vs(true);
                            return;
                        } else {
                            DistributeVideoView.this.vs(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lJH = DistributeVideoView.this.lJD;
                    DistributeVideoView.this.vs(true);
                }
            }
        };
        this.hUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vs(true);
                    }
                }
            }
        };
        this.lJO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vu(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.lJF = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fDP = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.fDP.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.fDP.setNoBussinessStats();
            this.lJs = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jaZ = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.lJt = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.lJw = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.lJx = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.lJu = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.lJy = this.mRootView.findViewById(R.id.distribute_control);
            this.lJz = (ImageView) this.lJy.findViewById(R.id.distribute_play_icon);
            this.lJv = (ImageView) this.lJy.findViewById(R.id.distribute_voice);
            this.lJA = (VideoControllerView) this.lJy.findViewById(R.id.distribute_process);
            this.lFX = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.lFY = new d(context, this.lFX);
            this.lJs.setAnimation(R.raw.lotti_video_loading);
            this.lJs.setMinFrame(0);
            this.lJs.setFrame(0);
            a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean doA() {
        return this.mStyle == 1 ? u.doA() : j.isWifiNet();
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
        this.lCK = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.lCL = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lJp = videoInfo;
        this.mDuration = this.lJp.video_duration.intValue() * 1000;
        this.akW = new WeakReference<>(this.mContext.getApplicationContext());
        doC();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.lJp.video_width.intValue() > 0 ? (this.lJp.video_height.intValue() * equipmentWidth) / this.lJp.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jaZ.setDefaultErrorResource(0);
        this.jaZ.setDefaultResource(0);
        this.jaZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jaZ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fDP.setOnPreparedListener(this.dLL);
        this.fDP.setOnErrorListener(this.dLM);
        this.fDP.setOnCompletionListener(this.dLN);
        this.fDP.setOnInfoListener(this.dLO);
        this.fDP.setOnSurfaceDestroyedListener(this.fcn);
        ap.setViewTextColor(this.lJt, R.color.cp_cont_m);
        this.lJt.setText(StringUtils.translateSecondsToString(this.lJp.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lJD = false;
            ap.setImageResource(this.lJu, R.drawable.icon_vedio_npronunciation_small_white);
            this.lJu.setVisibility(8);
        } else {
            this.lJD = true;
            ap.setImageResource(this.lJv, R.drawable.ad_icon_sound_open);
            this.lJu.setVisibility(8);
        }
        this.lJv.setOnClickListener(this.mOnClickListener);
        this.lJu.setOnClickListener(this.mOnClickListener);
        this.lJw.setOnClickListener(this.mOnClickListener);
        this.lJw.setVisibility(8);
        ap.setBackgroundColor(this.lJw, R.color.black_alpha80);
        ap.setViewTextColor(this.lJx, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.lJt.setVisibility(0);
            return;
        }
        this.lJt.setVisibility(8);
        this.lJz.setOnClickListener(this.mOnClickListener);
        this.lJs.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lJp = videoInfo;
        this.akW = new WeakReference<>(this.mContext.getApplicationContext());
        doC();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jaZ.setDefaultErrorResource(0);
        this.jaZ.setDefaultResource(0);
        this.jaZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jaZ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fDP.setOnPreparedListener(this.dLL);
        this.fDP.setOnErrorListener(this.dLM);
        this.fDP.setOnCompletionListener(this.dLN);
        this.fDP.setOnInfoListener(this.dLO);
        this.fDP.setOnSurfaceDestroyedListener(this.fcn);
        ap.setViewTextColor(this.lJt, R.color.cp_cont_m);
        this.lJt.setText(StringUtils.translateSecondsToString(this.lJp.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lJD = false;
            ap.setImageResource(this.lJu, R.drawable.icon_vedio_npronunciation_small_white);
            this.lJu.setVisibility(8);
        } else {
            this.lJD = true;
            ap.setImageResource(this.lJv, R.drawable.ad_icon_sound_open);
            this.lJu.setVisibility(8);
        }
        this.lJv.setOnClickListener(this.mOnClickListener);
        this.lJu.setOnClickListener(this.mOnClickListener);
        this.lJw.setOnClickListener(this.mOnClickListener);
        this.lJw.setVisibility(8);
        ap.setBackgroundColor(this.lJw, R.color.black_alpha80);
        ap.setViewTextColor(this.lJx, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.lJt.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.lJt.setVisibility(8);
        this.lJz.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.lJq;
        }
        this.lFZ = this.lFY.a(this.lCL, this.lFZ);
        if (this.lFZ != null) {
            this.lFZ.setPageContext(this.mPageContext);
            this.lFZ.c(this.lJF);
            if (this.lFZ instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.lFZ).vq(this.lIn);
            }
            this.lFZ.setAdvertAppInfo(advertAppInfo);
            this.lFZ.a(this.lCL);
            this.lFZ.dot();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.lIn = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.lFZ != null) {
            this.lFZ.setDownloadAppCallback(cVar);
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
        this.dLN = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv(int i) {
        this.lJK = i;
        if (this.lJp != null && this.lJB == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.lJE) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.lFZ != null) {
                    this.lFZ.dot();
                }
                this.fDP.setVideoPath(this.lJp.video_url);
                this.fDP.start();
                this.lJI = this.fDP.getCurrentPosition();
                ap.setImageResource(this.lJz, R.drawable.icon_video_midplay);
                bFc();
                this.lJw.setVisibility(8);
                this.jaZ.setForegroundDrawable(0);
                this.lJB = 0;
                if (this.mStyle == 1) {
                    this.lJt.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.lJt.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.lJO);
                    this.mPageContext.registerListener(this.lvw);
                    this.mPageContext.registerListener(this.hUJ);
                }
                Y(31, Gw(this.lJK), 0);
            }
        }
    }

    public void performPlay() {
        Gv(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (doA()) {
            if (i <= 0) {
                Gv(1);
                return;
            }
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJL);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.lJL, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.lJB == 1) {
            F(32, Gw(this.lJK), this.fDP.getCurrentPosition(), i);
            this.fDP.pause();
            ah.a(this.akW, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.lJz, R.drawable.icon_video_midpause);
            this.lJB = 2;
        }
    }

    public void autoContinue() {
        if (!this.lJG) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.lJB == 2) {
            this.lJK = i;
            Y(33, Gw(i), this.fDP.getCurrentPosition());
            this.lJI = this.fDP.getCurrentPosition();
            this.fDP.start();
            if (this.lJD) {
                ah.a(this.akW, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.lJz, R.drawable.icon_video_midplay);
            this.lJB = 1;
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFc() {
        if (this.lJs != null) {
            this.lJs.setAlpha(1.0f);
            this.lJs.setVisibility(0);
            this.lJs.loop(true);
            this.lJs.setMinAndMaxFrame(14, 80);
            this.lJs.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        doB();
        if (z) {
            this.lJs.setAlpha(1.0f);
            this.lJs.setVisibility(0);
            return;
        }
        this.lJs.setVisibility(8);
    }

    private void doB() {
        if (this.lJs != null) {
            this.lJs.setMinFrame(0);
            this.lJs.setFrame(0);
            this.lJs.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public void startPlay() {
        autoPlay(0);
    }

    @Override // com.baidu.tieba.recapp.h
    public void stopPlay() {
        stopPlay(true);
    }

    public void stopPlay(boolean z) {
        if (this.fDP.getCurrentPosition() > 0 && this.lJB != -1 && z) {
            int i = 32;
            int currentPosition = this.fDP.getCurrentPosition();
            if (this.fDP.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Gw(this.lJK), currentPosition, this.fDP.isPlaying());
        }
        doC();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fDP.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lFX.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jaZ.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int dk = com.baidu.g.a.e.a.dk(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = dk;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = dk;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = dk;
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
        this.fDP.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doC() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJL);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJM);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJN);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fDP.stopPlayback();
        this.lJB = -1;
        ah.a(this.akW, false);
        vu(false);
        this.jaZ.setForegroundDrawable(0);
        this.jaZ.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.lJz, R.drawable.icon_video_midpause);
        this.lJA.aIm();
        this.lJw.setVisibility(8);
        if (this.lJp != null) {
            this.lJt.setText(StringUtils.translateSecondsToString(this.lJp.video_duration.intValue()));
            this.lJt.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.lJH = false;
        MessageManager.getInstance().unRegisterListener(this.lJO);
        MessageManager.getInstance().unRegisterListener(this.lvw);
        MessageManager.getInstance().unRegisterListener(this.hUJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Gw(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
        }
        return 1;
    }

    @Override // com.baidu.tieba.recapp.h
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.h
    public String getPlayUrl() {
        return this.lJp != null ? this.lJp.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.lFZ instanceof com.baidu.tieba.recapp.e.a) && (this.lJF instanceof AdCard) && !((AdCard) this.lJF).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lFZ).bAZ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.lFZ instanceof com.baidu.tieba.recapp.e.a) && (this.lJF instanceof AdCard) && !((AdCard) this.lJF).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lFZ).dor();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs(boolean z) {
        if (z) {
            if (this.fDP != null) {
                this.fDP.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.lJv, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.lJu, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.lJB == 1) {
                ah.a(this.akW, true);
            }
        } else {
            if (this.fDP != null) {
                this.fDP.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.lJv, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.lJu, R.drawable.icon_vedio_npronunciation_small_white);
            ah.a(this.akW, false);
        }
        this.lJD = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.lJB;
    }

    public VideoInfo getData() {
        return this.lJp;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.lJC;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.lJq = advertAppInfo;
        this.lJr = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = g.a(this.lJq, 303, i, Gw(this.lJK), this.lJp.video_duration.intValue(), this.mDuration, -1);
        if (this.lFZ != null) {
            this.lFZ.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, int i2, int i3) {
        F(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void F(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.lJq != null && this.lJp != null) {
            this.lJq.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dol().a(g.a(this.lJq, i, this.lJr, i2, this.lJp.video_duration.intValue(), com.baidu.tieba.ad.a.a.sf(i3), i4));
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
                c(str, this.lJI, i3, this.mDuration, str2, Gx(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.lCK != null && "cpv".equals(this.lCK.lDM) && !TextUtils.isEmpty(this.lCK.lDN)) {
            new com.baidu.tieba.recapp.request.a(this.lCK.lDN).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Gx(int i) {
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
            this.lJn = view;
            this.lJo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJM);
            if (this.bAh != null) {
                this.bAh.cancel();
            }
            this.lJy.setVisibility(0);
            if (this.lJB == 1) {
                ap.setImageResource(this.lJz, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.lJz, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.lJy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doD() {
        switch (this.lJB) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.nt(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bhg();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.lJG = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    vt(true);
                    return;
                }
                return;
            case 2:
                this.lJG = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJM);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.lJM, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doE() {
        if (!this.dBR && this.bAh != null) {
            this.lJy.startAnimation(this.bAh);
            this.dBR = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bAh = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bAh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.lJy.setVisibility(8);
                    DistributeVideoView.this.dBR = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void doF() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJN);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.lJN, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(boolean z) {
        if (this.lJu != null && this.mStyle == 1) {
            if (z) {
                this.lJu.setVisibility(0);
                doF();
                return;
            }
            this.lJu.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
