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
import com.baidu.tbadk.util.ai;
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
/* loaded from: classes25.dex */
public class DistributeVideoView extends RelativeLayout implements h {
    private WeakReference<Context> alw;
    private Animation bDE;
    boolean dDS;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnErrorListener dNP;
    private CyberPlayerManager.OnCompletionListener dNQ;
    private CyberPlayerManager.OnInfoListener dNR;
    private TbCyberVideoView fHb;
    private TbCyberVideoView.a ffg;
    private CustomMessageListener ibJ;
    private ForeDrawableImageView jjF;
    private CustomMessageListener lEn;
    private AdCard.a lLE;
    private AdCard.f lLF;
    private ViewGroup lOR;
    private d lOS;
    private e lOT;
    private boolean lRh;
    boolean lSA;
    private boolean lSB;
    private int lSC;
    boolean lSD;
    private int lSE;
    private Runnable lSF;
    private Runnable lSG;
    private Runnable lSH;
    private CustomMessageListener lSI;
    private View lSh;
    private boolean lSi;
    private VideoInfo lSj;
    private AdvertAppInfo lSk;
    private int lSl;
    private TBLottieAnimationView lSm;
    private TextView lSn;
    private ImageView lSo;
    private ImageView lSp;
    private View lSq;
    private TextView lSr;
    private View lSs;
    private ImageView lSt;
    private VideoControllerView lSu;
    private int lSv;
    private long lSw;
    private boolean lSx;
    private long lSy;
    private b lSz;
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

    private void drr() {
        String str = this.lSk != null ? this.lSk.dYv : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.lSk) == 1) {
            aa(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        drr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsj() {
        aa(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dom() {
        if (this.lSm != null) {
            this.lSm.clearAnimation();
            this.lSm.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.lSm.setVisibility(8);
                    DistributeVideoView.this.jjF.setVisibility(8);
                    DistributeVideoView.this.vA(DistributeVideoView.this.lSx);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.lSn.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.lSu.setPlayer(DistributeVideoView.this.fHb);
                        DistributeVideoView.this.lSu.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.lSj.video_duration.intValue()));
                        DistributeVideoView.this.lSu.showProgress();
                        DistributeVideoView.this.vB(true);
                        com.baidu.adp.lib.f.e.mX().removeCallbacks(DistributeVideoView.this.lSG);
                        com.baidu.adp.lib.f.e.mX().postDelayed(DistributeVideoView.this.lSG, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.lSw = DistributeVideoView.this.fHb.getCurrentPosition();
                    DistributeVideoView.this.vC(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.lSm.setMinFrame(0);
                    DistributeVideoView.this.lSm.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.lSi = false;
        this.alw = null;
        this.lSv = -1;
        this.lSw = 0L;
        this.lSx = false;
        this.lSy = 0L;
        this.mStyle = 1;
        this.dDS = false;
        this.lSA = false;
        this.lSB = false;
        this.lSD = false;
        this.lSE = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lSq) {
                    DistributeVideoView.this.lSq.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lSp || view == DistributeVideoView.this.lSo) {
                    DistributeVideoView.this.vA(!DistributeVideoView.this.lSx);
                } else if (view == DistributeVideoView.this.lSm || view == DistributeVideoView.this.lSt) {
                    DistributeVideoView.this.dsn();
                } else if (!(DistributeVideoView.this.lSz instanceof AdCard)) {
                    DistributeVideoView.this.dsn();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dsj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lSv != 1) {
                            if (DistributeVideoView.this.fHb.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lSv = 1;
                                DistributeVideoView.this.dom();
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
                        if (DistributeVideoView.this.lSv == 1) {
                            if (DistributeVideoView.this.lSw == DistributeVideoView.this.fHb.getCurrentPosition()) {
                                DistributeVideoView.this.bGs();
                            } else {
                                DistributeVideoView.this.lSw = DistributeVideoView.this.fHb.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.lSC = DistributeVideoView.this.fHb.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fHb.getDuration();
                    DistributeVideoView.this.fHb.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lSx && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vA(false);
                    }
                }
            }
        };
        this.dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lSk != null) {
                    if (DistributeVideoView.this.lSD && "DETAIL".equals(DistributeVideoView.this.lSk.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.aa(i3, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), 0);
                }
                return false;
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dsm();
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.aa(36, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), DistributeVideoView.this.fHb.getCurrentPosition());
                }
                DistributeVideoView.this.jjF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lSq.setVisibility(0);
                return true;
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lSy = System.currentTimeMillis();
                DistributeVideoView.this.lSD = true;
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.aa(34, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), DistributeVideoView.this.fHb.getDuration());
                }
                DistributeVideoView.this.dsm();
                if (DistributeVideoView.this.lOT != null) {
                    DistributeVideoView.this.lOT.dsc();
                    DistributeVideoView.this.lSn.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lSF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lSj != null && DistributeVideoView.this.fHb != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.GW(1);
                }
            }
        };
        this.lSG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dso();
            }
        };
        this.lSH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vC(false);
            }
        };
        this.lEn = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lSB) {
                            DistributeVideoView.this.vA(true);
                            return;
                        } else {
                            DistributeVideoView.this.vA(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lSB = DistributeVideoView.this.lSx;
                    DistributeVideoView.this.vA(true);
                }
            }
        };
        this.ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vA(true);
                    }
                }
            }
        };
        this.lSI = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vC(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lSi = false;
        this.alw = null;
        this.lSv = -1;
        this.lSw = 0L;
        this.lSx = false;
        this.lSy = 0L;
        this.mStyle = 1;
        this.dDS = false;
        this.lSA = false;
        this.lSB = false;
        this.lSD = false;
        this.lSE = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lSq) {
                    DistributeVideoView.this.lSq.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lSp || view == DistributeVideoView.this.lSo) {
                    DistributeVideoView.this.vA(!DistributeVideoView.this.lSx);
                } else if (view == DistributeVideoView.this.lSm || view == DistributeVideoView.this.lSt) {
                    DistributeVideoView.this.dsn();
                } else if (!(DistributeVideoView.this.lSz instanceof AdCard)) {
                    DistributeVideoView.this.dsn();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dsj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lSv != 1) {
                            if (DistributeVideoView.this.fHb.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lSv = 1;
                                DistributeVideoView.this.dom();
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
                        if (DistributeVideoView.this.lSv == 1) {
                            if (DistributeVideoView.this.lSw == DistributeVideoView.this.fHb.getCurrentPosition()) {
                                DistributeVideoView.this.bGs();
                            } else {
                                DistributeVideoView.this.lSw = DistributeVideoView.this.fHb.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.lSC = DistributeVideoView.this.fHb.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fHb.getDuration();
                    DistributeVideoView.this.fHb.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lSx && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vA(false);
                    }
                }
            }
        };
        this.dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lSk != null) {
                    if (DistributeVideoView.this.lSD && "DETAIL".equals(DistributeVideoView.this.lSk.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.aa(i3, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), 0);
                }
                return false;
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dsm();
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.aa(36, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), DistributeVideoView.this.fHb.getCurrentPosition());
                }
                DistributeVideoView.this.jjF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lSq.setVisibility(0);
                return true;
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lSy = System.currentTimeMillis();
                DistributeVideoView.this.lSD = true;
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.aa(34, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), DistributeVideoView.this.fHb.getDuration());
                }
                DistributeVideoView.this.dsm();
                if (DistributeVideoView.this.lOT != null) {
                    DistributeVideoView.this.lOT.dsc();
                    DistributeVideoView.this.lSn.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lSF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lSj != null && DistributeVideoView.this.fHb != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.GW(1);
                }
            }
        };
        this.lSG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dso();
            }
        };
        this.lSH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vC(false);
            }
        };
        this.lEn = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lSB) {
                            DistributeVideoView.this.vA(true);
                            return;
                        } else {
                            DistributeVideoView.this.vA(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lSB = DistributeVideoView.this.lSx;
                    DistributeVideoView.this.vA(true);
                }
            }
        };
        this.ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vA(true);
                    }
                }
            }
        };
        this.lSI = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vC(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lSi = false;
        this.alw = null;
        this.lSv = -1;
        this.lSw = 0L;
        this.lSx = false;
        this.lSy = 0L;
        this.mStyle = 1;
        this.dDS = false;
        this.lSA = false;
        this.lSB = false;
        this.lSD = false;
        this.lSE = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lSq) {
                    DistributeVideoView.this.lSq.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lSp || view == DistributeVideoView.this.lSo) {
                    DistributeVideoView.this.vA(!DistributeVideoView.this.lSx);
                } else if (view == DistributeVideoView.this.lSm || view == DistributeVideoView.this.lSt) {
                    DistributeVideoView.this.dsn();
                } else if (!(DistributeVideoView.this.lSz instanceof AdCard)) {
                    DistributeVideoView.this.dsn();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dsj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lSv != 1) {
                            if (DistributeVideoView.this.fHb.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lSv = 1;
                                DistributeVideoView.this.dom();
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
                        if (DistributeVideoView.this.lSv == 1) {
                            if (DistributeVideoView.this.lSw == DistributeVideoView.this.fHb.getCurrentPosition()) {
                                DistributeVideoView.this.bGs();
                            } else {
                                DistributeVideoView.this.lSw = DistributeVideoView.this.fHb.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.lSC = DistributeVideoView.this.fHb.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fHb.getDuration();
                    DistributeVideoView.this.fHb.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lSx && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vA(false);
                    }
                }
            }
        };
        this.dNR = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.lSk != null) {
                    if (DistributeVideoView.this.lSD && "DETAIL".equals(DistributeVideoView.this.lSk.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.aa(i3, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), 0);
                }
                return false;
            }
        };
        this.dNP = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dsm();
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.aa(36, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), DistributeVideoView.this.fHb.getCurrentPosition());
                }
                DistributeVideoView.this.jjF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lSq.setVisibility(0);
                return true;
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lSy = System.currentTimeMillis();
                DistributeVideoView.this.lSD = true;
                if (DistributeVideoView.this.fHb != null) {
                    DistributeVideoView.this.aa(34, DistributeVideoView.this.GX(DistributeVideoView.this.lSE), DistributeVideoView.this.fHb.getDuration());
                }
                DistributeVideoView.this.dsm();
                if (DistributeVideoView.this.lOT != null) {
                    DistributeVideoView.this.lOT.dsc();
                    DistributeVideoView.this.lSn.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lSF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lSj != null && DistributeVideoView.this.fHb != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.GW(1);
                }
            }
        };
        this.lSG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dso();
            }
        };
        this.lSH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vC(false);
            }
        };
        this.lEn = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lSB) {
                            DistributeVideoView.this.vA(true);
                            return;
                        } else {
                            DistributeVideoView.this.vA(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lSB = DistributeVideoView.this.lSx;
                    DistributeVideoView.this.vA(true);
                }
            }
        };
        this.ibJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vA(true);
                    }
                }
            }
        };
        this.lSI = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vC(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.lSz = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fHb = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.fHb.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.fHb.setNoBussinessStats();
            this.lSm = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jjF = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.lSn = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.lSq = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.lSr = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.lSo = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.lSs = this.mRootView.findViewById(R.id.distribute_control);
            this.lSt = (ImageView) this.lSs.findViewById(R.id.distribute_play_icon);
            this.lSp = (ImageView) this.lSs.findViewById(R.id.distribute_voice);
            this.lSu = (VideoControllerView) this.lSs.findViewById(R.id.distribute_process);
            this.lOR = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.lOS = new d(context, this.lOR);
            this.lSm.setAnimation(R.raw.lotti_video_loading);
            this.lSm.setMinFrame(0);
            this.lSm.setFrame(0);
            a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dsk() {
        return this.mStyle == 1 ? u.dsk() : j.isWifiNet();
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
        this.lLE = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.lLF = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lSj = videoInfo;
        this.mDuration = this.lSj.video_duration.intValue() * 1000;
        this.alw = new WeakReference<>(this.mContext.getApplicationContext());
        dsm();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.lSj.video_width.intValue() > 0 ? (this.lSj.video_height.intValue() * equipmentWidth) / this.lSj.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jjF.setDefaultErrorResource(0);
        this.jjF.setDefaultResource(0);
        this.jjF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jjF.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fHb.setOnPreparedListener(this.dNO);
        this.fHb.setOnErrorListener(this.dNP);
        this.fHb.setOnCompletionListener(this.dNQ);
        this.fHb.setOnInfoListener(this.dNR);
        this.fHb.setOnSurfaceDestroyedListener(this.ffg);
        ap.setViewTextColor(this.lSn, R.color.cp_cont_m);
        this.lSn.setText(StringUtils.translateSecondsToString(this.lSj.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lSx = false;
            ap.setImageResource(this.lSo, R.drawable.icon_vedio_npronunciation_small_white);
            this.lSo.setVisibility(8);
        } else {
            this.lSx = true;
            ap.setImageResource(this.lSp, R.drawable.ad_icon_sound_open);
            this.lSo.setVisibility(8);
        }
        this.lSp.setOnClickListener(this.mOnClickListener);
        this.lSo.setOnClickListener(this.mOnClickListener);
        this.lSq.setOnClickListener(this.mOnClickListener);
        this.lSq.setVisibility(8);
        ap.setBackgroundColor(this.lSq, R.color.black_alpha80);
        ap.setViewTextColor(this.lSr, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.lSn.setVisibility(0);
            return;
        }
        this.lSn.setVisibility(8);
        this.lSt.setOnClickListener(this.mOnClickListener);
        this.lSm.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lSj = videoInfo;
        this.alw = new WeakReference<>(this.mContext.getApplicationContext());
        dsm();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jjF.setDefaultErrorResource(0);
        this.jjF.setDefaultResource(0);
        this.jjF.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jjF.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fHb.setOnPreparedListener(this.dNO);
        this.fHb.setOnErrorListener(this.dNP);
        this.fHb.setOnCompletionListener(this.dNQ);
        this.fHb.setOnInfoListener(this.dNR);
        this.fHb.setOnSurfaceDestroyedListener(this.ffg);
        ap.setViewTextColor(this.lSn, R.color.cp_cont_m);
        this.lSn.setText(StringUtils.translateSecondsToString(this.lSj.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lSx = false;
            ap.setImageResource(this.lSo, R.drawable.icon_vedio_npronunciation_small_white);
            this.lSo.setVisibility(8);
        } else {
            this.lSx = true;
            ap.setImageResource(this.lSp, R.drawable.ad_icon_sound_open);
            this.lSo.setVisibility(8);
        }
        this.lSp.setOnClickListener(this.mOnClickListener);
        this.lSo.setOnClickListener(this.mOnClickListener);
        this.lSq.setOnClickListener(this.mOnClickListener);
        this.lSq.setVisibility(8);
        ap.setBackgroundColor(this.lSq, R.color.black_alpha80);
        ap.setViewTextColor(this.lSr, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.lSn.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.lSn.setVisibility(8);
        this.lSt.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.lSk;
        }
        this.lOT = this.lOS.a(this.lLF, this.lOT);
        if (this.lOT != null) {
            this.lOT.setPageContext(this.mPageContext);
            this.lOT.c(this.lSz);
            if (this.lOT instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.lOT).vy(this.lRh);
            }
            this.lOT.setAdvertAppInfo(advertAppInfo);
            this.lOT.a(this.lLF);
            this.lOT.dsd();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.lRh = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.lOT != null) {
            this.lOT.setDownloadAppCallback(cVar);
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
        this.dNQ = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GW(int i) {
        this.lSE = i;
        if (this.lSj != null && this.lSv == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.lSy) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.lOT != null) {
                    this.lOT.dsd();
                }
                this.fHb.setVideoPath(this.lSj.video_url);
                this.fHb.start();
                this.lSC = this.fHb.getCurrentPosition();
                ap.setImageResource(this.lSt, R.drawable.icon_video_midplay);
                bGs();
                this.lSq.setVisibility(8);
                this.jjF.setForegroundDrawable(0);
                this.lSv = 0;
                if (this.mStyle == 1) {
                    this.lSn.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.lSn.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.lSI);
                    this.mPageContext.registerListener(this.lEn);
                    this.mPageContext.registerListener(this.ibJ);
                }
                aa(31, GX(this.lSE), 0);
            }
        }
    }

    public void performPlay() {
        GW(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (dsk()) {
            if (i <= 0) {
                GW(1);
                return;
            }
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSF);
            com.baidu.adp.lib.f.e.mX().postDelayed(this.lSF, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.lSv == 1) {
            F(32, GX(this.lSE), this.fHb.getCurrentPosition(), i);
            this.fHb.pause();
            ai.a(this.alw, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.lSt, R.drawable.icon_video_midpause);
            this.lSv = 2;
        }
    }

    public void autoContinue() {
        if (!this.lSA) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.lSv == 2) {
            this.lSE = i;
            aa(33, GX(i), this.fHb.getCurrentPosition());
            this.lSC = this.fHb.getCurrentPosition();
            this.fHb.start();
            if (this.lSx) {
                ai.a(this.alw, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.lSt, R.drawable.icon_video_midplay);
            this.lSv = 1;
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
    public void bGs() {
        if (this.lSm != null) {
            this.lSm.setAlpha(1.0f);
            this.lSm.setVisibility(0);
            this.lSm.loop(true);
            this.lSm.setMinAndMaxFrame(14, 80);
            this.lSm.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dsl();
        if (z) {
            this.lSm.setAlpha(1.0f);
            this.lSm.setVisibility(0);
            return;
        }
        this.lSm.setVisibility(8);
    }

    private void dsl() {
        if (this.lSm != null) {
            this.lSm.setMinFrame(0);
            this.lSm.setFrame(0);
            this.lSm.cancelAnimation();
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
        if (this.fHb.getCurrentPosition() > 0 && this.lSv != -1 && z) {
            int i = 32;
            int currentPosition = this.fHb.getCurrentPosition();
            if (this.fHb.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, GX(this.lSE), currentPosition, this.fHb.isPlaying());
        }
        dsm();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fHb.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lOR.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jjF.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int m22do = com.baidu.g.a.e.a.m22do(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = m22do;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = m22do;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = m22do;
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
        this.fHb.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsm() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSF);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSG);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSH);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fHb.stopPlayback();
        this.lSv = -1;
        ai.a(this.alw, false);
        vC(false);
        this.jjF.setForegroundDrawable(0);
        this.jjF.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.lSt, R.drawable.icon_video_midpause);
        this.lSu.aIX();
        this.lSq.setVisibility(8);
        if (this.lSj != null) {
            this.lSn.setText(StringUtils.translateSecondsToString(this.lSj.video_duration.intValue()));
            this.lSn.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.lSB = false;
        MessageManager.getInstance().unRegisterListener(this.lSI);
        MessageManager.getInstance().unRegisterListener(this.lEn);
        MessageManager.getInstance().unRegisterListener(this.ibJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int GX(int i) {
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
        return this.lSj != null ? this.lSj.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.lOT instanceof com.baidu.tieba.recapp.e.a) && (this.lSz instanceof AdCard) && !((AdCard) this.lSz).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lOT).bCl();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.lOT instanceof com.baidu.tieba.recapp.e.a) && (this.lSz instanceof AdCard) && !((AdCard) this.lSz).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lOT).dsb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vA(boolean z) {
        if (z) {
            if (this.fHb != null) {
                this.fHb.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.lSp, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.lSo, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.lSv == 1) {
                ai.a(this.alw, true);
            }
        } else {
            if (this.fHb != null) {
                this.fHb.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.lSp, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.lSo, R.drawable.icon_vedio_npronunciation_small_white);
            ai.a(this.alw, false);
        }
        this.lSx = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.lSv;
    }

    public VideoInfo getData() {
        return this.lSj;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.lSw;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.lSk = advertAppInfo;
        this.lSl = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = g.a(this.lSk, 303, i, GX(this.lSE), this.lSj.video_duration.intValue(), this.mDuration, -1);
        if (this.lOT != null) {
            this.lOT.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(int i, int i2, int i3) {
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
        if (this.lSk != null && this.lSj != null) {
            this.lSk.page = this.mPage;
            com.baidu.tieba.recapp.report.d.drV().a(g.a(this.lSk, i, this.lSl, i2, this.lSj.video_duration.intValue(), com.baidu.tieba.ad.a.a.sx(i3), i4));
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
                c(str, this.lSC, i3, this.mDuration, str2, GY(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.lLE != null && "cpv".equals(this.lLE.lMG) && !TextUtils.isEmpty(this.lLE.lMH)) {
            new com.baidu.tieba.recapp.request.a(this.lLE.lMH).a(str, i, i2, i3, str2, str3);
        }
    }

    private String GY(int i) {
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
            this.lSh = view;
            this.lSi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vB(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSG);
            if (this.bDE != null) {
                this.bDE.cancel();
            }
            this.lSs.setVisibility(0);
            if (this.lSv == 1) {
                ap.setImageResource(this.lSt, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.lSt, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.lSs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsn() {
        switch (this.lSv) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.nE(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bia();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.lSA = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    vB(true);
                    return;
                }
                return;
            case 2:
                this.lSA = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSG);
                    com.baidu.adp.lib.f.e.mX().postDelayed(this.lSG, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dso() {
        if (!this.dDS && this.bDE != null) {
            this.lSs.startAnimation(this.bDE);
            this.dDS = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bDE = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bDE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.lSs.setVisibility(8);
                    DistributeVideoView.this.dDS = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dsp() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.lSH);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.lSH, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vC(boolean z) {
        if (this.lSo != null && this.mStyle == 1) {
            if (z) {
                this.lSo.setVisibility(0);
                dsp();
                return;
            }
            this.lSo.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
