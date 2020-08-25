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
    private WeakReference<Context> akU;
    private Animation bAe;
    boolean dBN;
    private CyberPlayerManager.OnPreparedListener dLH;
    private CyberPlayerManager.OnErrorListener dLI;
    private CyberPlayerManager.OnCompletionListener dLJ;
    private CyberPlayerManager.OnInfoListener dLK;
    private TbCyberVideoView fDL;
    private TbCyberVideoView.a fcj;
    private CustomMessageListener hUD;
    private ForeDrawableImageView jaT;
    private AdCard.f lCA;
    private AdCard.a lCz;
    private ViewGroup lFK;
    private d lFL;
    private e lFM;
    private boolean lIa;
    private Runnable lJA;
    private CustomMessageListener lJB;
    private View lJa;
    private boolean lJb;
    private VideoInfo lJc;
    private AdvertAppInfo lJd;
    private int lJe;
    private TBLottieAnimationView lJf;
    private TextView lJg;
    private ImageView lJh;
    private ImageView lJi;
    private View lJj;
    private TextView lJk;
    private View lJl;
    private ImageView lJm;
    private VideoControllerView lJn;
    private int lJo;
    private long lJp;
    private boolean lJq;
    private long lJr;
    private b lJs;
    boolean lJt;
    private boolean lJu;
    private int lJv;
    boolean lJw;
    private int lJx;
    private Runnable lJy;
    private Runnable lJz;
    private CustomMessageListener lvl;
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

    private void dnF() {
        String str = this.lJd != null ? this.lJd.dWh : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.lJd) == 1) {
            Y(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dnF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dow() {
        Y(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkC() {
        if (this.lJf != null) {
            this.lJf.clearAnimation();
            this.lJf.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.lJf.setVisibility(8);
                    DistributeVideoView.this.jaT.setVisibility(8);
                    DistributeVideoView.this.vq(DistributeVideoView.this.lJq);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.lJg.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.lJn.setPlayer(DistributeVideoView.this.fDL);
                        DistributeVideoView.this.lJn.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.lJc.video_duration.intValue()));
                        DistributeVideoView.this.lJn.showProgress();
                        DistributeVideoView.this.vr(true);
                        com.baidu.adp.lib.f.e.mS().removeCallbacks(DistributeVideoView.this.lJz);
                        com.baidu.adp.lib.f.e.mS().postDelayed(DistributeVideoView.this.lJz, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.lJp = DistributeVideoView.this.fDL.getCurrentPosition();
                    DistributeVideoView.this.vs(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.lJf.setMinFrame(0);
                    DistributeVideoView.this.lJf.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.lJb = false;
        this.akU = null;
        this.lJo = -1;
        this.lJp = 0L;
        this.lJq = false;
        this.lJr = 0L;
        this.mStyle = 1;
        this.dBN = false;
        this.lJt = false;
        this.lJu = false;
        this.lJw = false;
        this.lJx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lJj) {
                    DistributeVideoView.this.lJj.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lJi || view == DistributeVideoView.this.lJh) {
                    DistributeVideoView.this.vq(!DistributeVideoView.this.lJq);
                } else if (view == DistributeVideoView.this.lJf || view == DistributeVideoView.this.lJm) {
                    DistributeVideoView.this.doA();
                } else if (!(DistributeVideoView.this.lJs instanceof AdCard)) {
                    DistributeVideoView.this.doA();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dow();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lJo != 1) {
                            if (DistributeVideoView.this.fDL.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lJo = 1;
                                DistributeVideoView.this.dkC();
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
                        if (DistributeVideoView.this.lJo == 1) {
                            if (DistributeVideoView.this.lJp == DistributeVideoView.this.fDL.getCurrentPosition()) {
                                DistributeVideoView.this.bFb();
                            } else {
                                DistributeVideoView.this.lJp = DistributeVideoView.this.fDL.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.lJv = DistributeVideoView.this.fDL.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fDL.getDuration();
                    DistributeVideoView.this.fDL.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lJq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vq(false);
                    }
                }
            }
        };
        this.dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lJd != null) {
                    if (DistributeVideoView.this.lJw && "DETAIL".equals(DistributeVideoView.this.lJd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), 0);
                }
                return false;
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.doz();
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.Y(36, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), DistributeVideoView.this.fDL.getCurrentPosition());
                }
                DistributeVideoView.this.jaT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lJj.setVisibility(0);
                return true;
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lJr = System.currentTimeMillis();
                DistributeVideoView.this.lJw = true;
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.Y(34, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), DistributeVideoView.this.fDL.getDuration());
                }
                DistributeVideoView.this.doz();
                if (DistributeVideoView.this.lFM != null) {
                    DistributeVideoView.this.lFM.dop();
                    DistributeVideoView.this.lJg.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lJy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lJc != null && DistributeVideoView.this.fDL != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Gv(1);
                }
            }
        };
        this.lJz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.doB();
            }
        };
        this.lJA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vs(false);
            }
        };
        this.lvl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lJu) {
                            DistributeVideoView.this.vq(true);
                            return;
                        } else {
                            DistributeVideoView.this.vq(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lJu = DistributeVideoView.this.lJq;
                    DistributeVideoView.this.vq(true);
                }
            }
        };
        this.hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vq(true);
                    }
                }
            }
        };
        this.lJB = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vs(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lJb = false;
        this.akU = null;
        this.lJo = -1;
        this.lJp = 0L;
        this.lJq = false;
        this.lJr = 0L;
        this.mStyle = 1;
        this.dBN = false;
        this.lJt = false;
        this.lJu = false;
        this.lJw = false;
        this.lJx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lJj) {
                    DistributeVideoView.this.lJj.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lJi || view == DistributeVideoView.this.lJh) {
                    DistributeVideoView.this.vq(!DistributeVideoView.this.lJq);
                } else if (view == DistributeVideoView.this.lJf || view == DistributeVideoView.this.lJm) {
                    DistributeVideoView.this.doA();
                } else if (!(DistributeVideoView.this.lJs instanceof AdCard)) {
                    DistributeVideoView.this.doA();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dow();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lJo != 1) {
                            if (DistributeVideoView.this.fDL.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lJo = 1;
                                DistributeVideoView.this.dkC();
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
                        if (DistributeVideoView.this.lJo == 1) {
                            if (DistributeVideoView.this.lJp == DistributeVideoView.this.fDL.getCurrentPosition()) {
                                DistributeVideoView.this.bFb();
                            } else {
                                DistributeVideoView.this.lJp = DistributeVideoView.this.fDL.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.lJv = DistributeVideoView.this.fDL.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fDL.getDuration();
                    DistributeVideoView.this.fDL.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lJq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vq(false);
                    }
                }
            }
        };
        this.dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lJd != null) {
                    if (DistributeVideoView.this.lJw && "DETAIL".equals(DistributeVideoView.this.lJd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), 0);
                }
                return false;
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.doz();
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.Y(36, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), DistributeVideoView.this.fDL.getCurrentPosition());
                }
                DistributeVideoView.this.jaT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lJj.setVisibility(0);
                return true;
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lJr = System.currentTimeMillis();
                DistributeVideoView.this.lJw = true;
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.Y(34, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), DistributeVideoView.this.fDL.getDuration());
                }
                DistributeVideoView.this.doz();
                if (DistributeVideoView.this.lFM != null) {
                    DistributeVideoView.this.lFM.dop();
                    DistributeVideoView.this.lJg.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lJy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lJc != null && DistributeVideoView.this.fDL != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Gv(1);
                }
            }
        };
        this.lJz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.doB();
            }
        };
        this.lJA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vs(false);
            }
        };
        this.lvl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lJu) {
                            DistributeVideoView.this.vq(true);
                            return;
                        } else {
                            DistributeVideoView.this.vq(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lJu = DistributeVideoView.this.lJq;
                    DistributeVideoView.this.vq(true);
                }
            }
        };
        this.hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vq(true);
                    }
                }
            }
        };
        this.lJB = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vs(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lJb = false;
        this.akU = null;
        this.lJo = -1;
        this.lJp = 0L;
        this.lJq = false;
        this.lJr = 0L;
        this.mStyle = 1;
        this.dBN = false;
        this.lJt = false;
        this.lJu = false;
        this.lJw = false;
        this.lJx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lJj) {
                    DistributeVideoView.this.lJj.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lJi || view == DistributeVideoView.this.lJh) {
                    DistributeVideoView.this.vq(!DistributeVideoView.this.lJq);
                } else if (view == DistributeVideoView.this.lJf || view == DistributeVideoView.this.lJm) {
                    DistributeVideoView.this.doA();
                } else if (!(DistributeVideoView.this.lJs instanceof AdCard)) {
                    DistributeVideoView.this.doA();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dow();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lJo != 1) {
                            if (DistributeVideoView.this.fDL.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lJo = 1;
                                DistributeVideoView.this.dkC();
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
                        if (DistributeVideoView.this.lJo == 1) {
                            if (DistributeVideoView.this.lJp == DistributeVideoView.this.fDL.getCurrentPosition()) {
                                DistributeVideoView.this.bFb();
                            } else {
                                DistributeVideoView.this.lJp = DistributeVideoView.this.fDL.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dLH = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.lJv = DistributeVideoView.this.fDL.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fDL.getDuration();
                    DistributeVideoView.this.fDL.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lJq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.vq(false);
                    }
                }
            }
        };
        this.dLK = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.lJd != null) {
                    if (DistributeVideoView.this.lJw && "DETAIL".equals(DistributeVideoView.this.lJd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), 0);
                }
                return false;
            }
        };
        this.dLI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.doz();
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.Y(36, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), DistributeVideoView.this.fDL.getCurrentPosition());
                }
                DistributeVideoView.this.jaT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lJj.setVisibility(0);
                return true;
            }
        };
        this.dLJ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lJr = System.currentTimeMillis();
                DistributeVideoView.this.lJw = true;
                if (DistributeVideoView.this.fDL != null) {
                    DistributeVideoView.this.Y(34, DistributeVideoView.this.Gw(DistributeVideoView.this.lJx), DistributeVideoView.this.fDL.getDuration());
                }
                DistributeVideoView.this.doz();
                if (DistributeVideoView.this.lFM != null) {
                    DistributeVideoView.this.lFM.dop();
                    DistributeVideoView.this.lJg.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fcj = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.lJy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lJc != null && DistributeVideoView.this.fDL != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Gv(1);
                }
            }
        };
        this.lJz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.doB();
            }
        };
        this.lJA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.vs(false);
            }
        };
        this.lvl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lJu) {
                            DistributeVideoView.this.vq(true);
                            return;
                        } else {
                            DistributeVideoView.this.vq(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lJu = DistributeVideoView.this.lJq;
                    DistributeVideoView.this.vq(true);
                }
            }
        };
        this.hUD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.vq(true);
                    }
                }
            }
        };
        this.lJB = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.vs(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.lJs = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fDL = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.fDL.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.fDL.setNoBussinessStats();
            this.lJf = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jaT = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.lJg = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.lJj = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.lJk = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.lJh = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.lJl = this.mRootView.findViewById(R.id.distribute_control);
            this.lJm = (ImageView) this.lJl.findViewById(R.id.distribute_play_icon);
            this.lJi = (ImageView) this.lJl.findViewById(R.id.distribute_voice);
            this.lJn = (VideoControllerView) this.lJl.findViewById(R.id.distribute_process);
            this.lFK = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.lFL = new d(context, this.lFK);
            this.lJf.setAnimation(R.raw.lotti_video_loading);
            this.lJf.setMinFrame(0);
            this.lJf.setFrame(0);
            a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dox() {
        return this.mStyle == 1 ? u.dox() : j.isWifiNet();
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
        this.lCz = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.lCA = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lJc = videoInfo;
        this.mDuration = this.lJc.video_duration.intValue() * 1000;
        this.akU = new WeakReference<>(this.mContext.getApplicationContext());
        doz();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.lJc.video_width.intValue() > 0 ? (this.lJc.video_height.intValue() * equipmentWidth) / this.lJc.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jaT.setDefaultErrorResource(0);
        this.jaT.setDefaultResource(0);
        this.jaT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jaT.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fDL.setOnPreparedListener(this.dLH);
        this.fDL.setOnErrorListener(this.dLI);
        this.fDL.setOnCompletionListener(this.dLJ);
        this.fDL.setOnInfoListener(this.dLK);
        this.fDL.setOnSurfaceDestroyedListener(this.fcj);
        ap.setViewTextColor(this.lJg, R.color.cp_cont_m);
        this.lJg.setText(StringUtils.translateSecondsToString(this.lJc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lJq = false;
            ap.setImageResource(this.lJh, R.drawable.icon_vedio_npronunciation_small_white);
            this.lJh.setVisibility(8);
        } else {
            this.lJq = true;
            ap.setImageResource(this.lJi, R.drawable.ad_icon_sound_open);
            this.lJh.setVisibility(8);
        }
        this.lJi.setOnClickListener(this.mOnClickListener);
        this.lJh.setOnClickListener(this.mOnClickListener);
        this.lJj.setOnClickListener(this.mOnClickListener);
        this.lJj.setVisibility(8);
        ap.setBackgroundColor(this.lJj, R.color.black_alpha80);
        ap.setViewTextColor(this.lJk, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.lJg.setVisibility(0);
            return;
        }
        this.lJg.setVisibility(8);
        this.lJm.setOnClickListener(this.mOnClickListener);
        this.lJf.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lJc = videoInfo;
        this.akU = new WeakReference<>(this.mContext.getApplicationContext());
        doz();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jaT.setDefaultErrorResource(0);
        this.jaT.setDefaultResource(0);
        this.jaT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jaT.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fDL.setOnPreparedListener(this.dLH);
        this.fDL.setOnErrorListener(this.dLI);
        this.fDL.setOnCompletionListener(this.dLJ);
        this.fDL.setOnInfoListener(this.dLK);
        this.fDL.setOnSurfaceDestroyedListener(this.fcj);
        ap.setViewTextColor(this.lJg, R.color.cp_cont_m);
        this.lJg.setText(StringUtils.translateSecondsToString(this.lJc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lJq = false;
            ap.setImageResource(this.lJh, R.drawable.icon_vedio_npronunciation_small_white);
            this.lJh.setVisibility(8);
        } else {
            this.lJq = true;
            ap.setImageResource(this.lJi, R.drawable.ad_icon_sound_open);
            this.lJh.setVisibility(8);
        }
        this.lJi.setOnClickListener(this.mOnClickListener);
        this.lJh.setOnClickListener(this.mOnClickListener);
        this.lJj.setOnClickListener(this.mOnClickListener);
        this.lJj.setVisibility(8);
        ap.setBackgroundColor(this.lJj, R.color.black_alpha80);
        ap.setViewTextColor(this.lJk, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.lJg.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.lJg.setVisibility(8);
        this.lJm.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.lJd;
        }
        this.lFM = this.lFL.a(this.lCA, this.lFM);
        if (this.lFM != null) {
            this.lFM.setPageContext(this.mPageContext);
            this.lFM.c(this.lJs);
            if (this.lFM instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.lFM).vo(this.lIa);
            }
            this.lFM.setAdvertAppInfo(advertAppInfo);
            this.lFM.a(this.lCA);
            this.lFM.doq();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.lIa = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.lFM != null) {
            this.lFM.setDownloadAppCallback(cVar);
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
        this.dLJ = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gv(int i) {
        this.lJx = i;
        if (this.lJc != null && this.lJo == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.lJr) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.lFM != null) {
                    this.lFM.doq();
                }
                this.fDL.setVideoPath(this.lJc.video_url);
                this.fDL.start();
                this.lJv = this.fDL.getCurrentPosition();
                ap.setImageResource(this.lJm, R.drawable.icon_video_midplay);
                bFb();
                this.lJj.setVisibility(8);
                this.jaT.setForegroundDrawable(0);
                this.lJo = 0;
                if (this.mStyle == 1) {
                    this.lJg.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.lJg.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.lJB);
                    this.mPageContext.registerListener(this.lvl);
                    this.mPageContext.registerListener(this.hUD);
                }
                Y(31, Gw(this.lJx), 0);
            }
        }
    }

    public void performPlay() {
        Gv(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (dox()) {
            if (i <= 0) {
                Gv(1);
                return;
            }
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJy);
            com.baidu.adp.lib.f.e.mS().postDelayed(this.lJy, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.lJo == 1) {
            F(32, Gw(this.lJx), this.fDL.getCurrentPosition(), i);
            this.fDL.pause();
            ah.a(this.akU, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.lJm, R.drawable.icon_video_midpause);
            this.lJo = 2;
        }
    }

    public void autoContinue() {
        if (!this.lJt) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.lJo == 2) {
            this.lJx = i;
            Y(33, Gw(i), this.fDL.getCurrentPosition());
            this.lJv = this.fDL.getCurrentPosition();
            this.fDL.start();
            if (this.lJq) {
                ah.a(this.akU, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.lJm, R.drawable.icon_video_midplay);
            this.lJo = 1;
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
    public void bFb() {
        if (this.lJf != null) {
            this.lJf.setAlpha(1.0f);
            this.lJf.setVisibility(0);
            this.lJf.loop(true);
            this.lJf.setMinAndMaxFrame(14, 80);
            this.lJf.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        doy();
        if (z) {
            this.lJf.setAlpha(1.0f);
            this.lJf.setVisibility(0);
            return;
        }
        this.lJf.setVisibility(8);
    }

    private void doy() {
        if (this.lJf != null) {
            this.lJf.setMinFrame(0);
            this.lJf.setFrame(0);
            this.lJf.cancelAnimation();
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
        if (this.fDL.getCurrentPosition() > 0 && this.lJo != -1 && z) {
            int i = 32;
            int currentPosition = this.fDL.getCurrentPosition();
            if (this.fDL.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Gw(this.lJx), currentPosition, this.fDL.isPlaying());
        }
        doz();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fDL.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lFK.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jaT.getLayoutParams();
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
        this.fDL.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doz() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJy);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJz);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJA);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fDL.stopPlayback();
        this.lJo = -1;
        ah.a(this.akU, false);
        vs(false);
        this.jaT.setForegroundDrawable(0);
        this.jaT.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.lJm, R.drawable.icon_video_midpause);
        this.lJn.aIm();
        this.lJj.setVisibility(8);
        if (this.lJc != null) {
            this.lJg.setText(StringUtils.translateSecondsToString(this.lJc.video_duration.intValue()));
            this.lJg.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.lJu = false;
        MessageManager.getInstance().unRegisterListener(this.lJB);
        MessageManager.getInstance().unRegisterListener(this.lvl);
        MessageManager.getInstance().unRegisterListener(this.hUD);
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
        return this.lJc != null ? this.lJc.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.lFM instanceof com.baidu.tieba.recapp.e.a) && (this.lJs instanceof AdCard) && !((AdCard) this.lJs).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lFM).bAY();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.lFM instanceof com.baidu.tieba.recapp.e.a) && (this.lJs instanceof AdCard) && !((AdCard) this.lJs).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lFM).doo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(boolean z) {
        if (z) {
            if (this.fDL != null) {
                this.fDL.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.lJi, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.lJh, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.lJo == 1) {
                ah.a(this.akU, true);
            }
        } else {
            if (this.fDL != null) {
                this.fDL.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.lJi, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.lJh, R.drawable.icon_vedio_npronunciation_small_white);
            ah.a(this.akU, false);
        }
        this.lJq = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.lJo;
    }

    public VideoInfo getData() {
        return this.lJc;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.lJp;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.lJd = advertAppInfo;
        this.lJe = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = g.a(this.lJd, 303, i, Gw(this.lJx), this.lJc.video_duration.intValue(), this.mDuration, -1);
        if (this.lFM != null) {
            this.lFM.e(a);
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
        if (this.lJd != null && this.lJc != null) {
            this.lJd.page = this.mPage;
            com.baidu.tieba.recapp.report.d.doi().a(g.a(this.lJd, i, this.lJe, i2, this.lJc.video_duration.intValue(), com.baidu.tieba.ad.a.a.sf(i3), i4));
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
                c(str, this.lJv, i3, this.mDuration, str2, Gx(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.lCz != null && "cpv".equals(this.lCz.lDB) && !TextUtils.isEmpty(this.lCz.lDC)) {
            new com.baidu.tieba.recapp.request.a(this.lCz.lDC).a(str, i, i2, i3, str2, str3);
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
            this.lJa = view;
            this.lJb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJz);
            if (this.bAe != null) {
                this.bAe.cancel();
            }
            this.lJl.setVisibility(0);
            if (this.lJo == 1) {
                ap.setImageResource(this.lJm, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.lJm, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.lJl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doA() {
        switch (this.lJo) {
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
                this.lJt = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    vr(true);
                    return;
                }
                return;
            case 2:
                this.lJt = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJz);
                    com.baidu.adp.lib.f.e.mS().postDelayed(this.lJz, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doB() {
        if (!this.dBN && this.bAe != null) {
            this.lJl.startAnimation(this.bAe);
            this.dBN = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bAe = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bAe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.lJl.setVisibility(8);
                    DistributeVideoView.this.dBN = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void doC() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.lJA);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.lJA, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs(boolean z) {
        if (this.lJh != null && this.mStyle == 1) {
            if (z) {
                this.lJh.setVisibility(0);
                doC();
                return;
            }
            this.lJh.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
