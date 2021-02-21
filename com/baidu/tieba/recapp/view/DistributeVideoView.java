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
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ak;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.a.b;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.d.a;
import com.baidu.tieba.recapp.d.d;
import com.baidu.tieba.recapp.d.e;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.h;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.tbadkCore.v;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class DistributeVideoView extends RelativeLayout implements k {
    private Animation chW;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private CyberPlayerManager.OnCompletionListener eAC;
    private CyberPlayerManager.OnInfoListener eAD;
    boolean epX;
    private TbCyberVideoView.a fUi;
    private TbCyberVideoView gAl;
    private CustomMessageListener jil;
    private ForeDrawableImageView kwr;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private AdCard.f mSa;
    private String mScheme;
    private Runnable mSf;
    private int mStyle;
    private ViewGroup mVx;
    private d mVy;
    private e mVz;
    private WeakReference<Context> mWeakContext;
    private boolean mYc;
    private ImageView mZA;
    private VideoControllerView mZB;
    private int mZC;
    private long mZD;
    private boolean mZE;
    private long mZF;
    private b mZG;
    boolean mZH;
    private boolean mZI;
    private int mZJ;
    boolean mZK;
    private int mZL;
    private Runnable mZM;
    private Runnable mZN;
    private CustomMessageListener mZO;
    private View mZn;
    private boolean mZo;
    private VideoInfo mZp;
    private AdCard.a mZq;
    private AdvertAppInfo mZr;
    private int mZs;
    private TBLottieAnimationView mZt;
    private TextView mZu;
    private ImageView mZv;
    private ImageView mZw;
    private View mZx;
    private TextView mZy;
    private View mZz;

    public int jump2DownloadDetailPage() {
        return dEJ();
    }

    private int dEJ() {
        String str = this.mZr != null ? this.mZr.eLv : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (TextUtils.isEmpty(str) || this.mContext == null) {
            return 0;
        }
        if (t.b(this.mZr, str)) {
            return 3;
        }
        return t.a(this.mContext, str, this.mZr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEK() {
        ac(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAO() {
        if (this.mZt != null) {
            this.mZt.clearAnimation();
            this.mZt.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mZt.setVisibility(8);
                    DistributeVideoView.this.kwr.setVisibility(8);
                    DistributeVideoView.this.xE(DistributeVideoView.this.mZE);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mZu.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mZB.setPlayer(DistributeVideoView.this.gAl);
                        DistributeVideoView.this.mZB.bx(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mZp.video_duration.intValue()));
                        DistributeVideoView.this.mZB.showProgress();
                        DistributeVideoView.this.xF(true);
                        com.baidu.adp.lib.f.e.mA().removeCallbacks(DistributeVideoView.this.mZM);
                        com.baidu.adp.lib.f.e.mA().postDelayed(DistributeVideoView.this.mZM, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mZD = DistributeVideoView.this.gAl.getCurrentPosition();
                    DistributeVideoView.this.xG(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mZt.setMinFrame(0);
                    DistributeVideoView.this.mZt.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mZo = false;
        this.mWeakContext = null;
        this.mZC = -1;
        this.mZD = 0L;
        this.mZE = false;
        this.mZF = 0L;
        this.mStyle = 1;
        this.epX = false;
        this.mZH = false;
        this.mZI = false;
        this.mZK = false;
        this.mZL = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mZx) {
                    DistributeVideoView.this.mZx.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mZw || view == DistributeVideoView.this.mZv) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.mZE);
                } else if (view == DistributeVideoView.this.mZt || view == DistributeVideoView.this.mZA) {
                    DistributeVideoView.this.dEO();
                } else if (!(DistributeVideoView.this.mZG instanceof AdCard)) {
                    DistributeVideoView.this.dEO();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dEK();
                    if (t.HL(jump2DownloadDetailPage)) {
                        DistributeVideoView.this.Ii(jump2DownloadDetailPage);
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mZC != 1) {
                            if (DistributeVideoView.this.gAl.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mZC = 1;
                                DistributeVideoView.this.dAO();
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
                        if (DistributeVideoView.this.mZC == 1) {
                            if (DistributeVideoView.this.mZD == DistributeVideoView.this.gAl.getCurrentPosition()) {
                                DistributeVideoView.this.bQA();
                            } else {
                                DistributeVideoView.this.mZD = DistributeVideoView.this.gAl.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.mZJ = DistributeVideoView.this.gAl.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gAl.getDuration();
                    DistributeVideoView.this.gAl.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mZE && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mZr != null) {
                    if (DistributeVideoView.this.mZK && "DETAIL".equals(DistributeVideoView.this.mZr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), 0);
                }
                return false;
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dEN();
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), DistributeVideoView.this.gAl.getCurrentPosition());
                }
                DistributeVideoView.this.kwr.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mZx.setVisibility(0);
                return true;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mZF = System.currentTimeMillis();
                DistributeVideoView.this.mZK = true;
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), DistributeVideoView.this.gAl.getDuration());
                }
                DistributeVideoView.this.dEN();
                if (DistributeVideoView.this.mVz != null) {
                    DistributeVideoView.this.mVz.dEB();
                    DistributeVideoView.this.mZu.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mSf = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mZp != null && DistributeVideoView.this.gAl != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ig(1);
                }
            }
        };
        this.mZM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEP();
            }
        };
        this.mZN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xG(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mZI) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mZI = DistributeVideoView.this.mZE;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xE(true);
                    }
                }
            }
        };
        this.mZO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xG(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mZo = false;
        this.mWeakContext = null;
        this.mZC = -1;
        this.mZD = 0L;
        this.mZE = false;
        this.mZF = 0L;
        this.mStyle = 1;
        this.epX = false;
        this.mZH = false;
        this.mZI = false;
        this.mZK = false;
        this.mZL = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mZx) {
                    DistributeVideoView.this.mZx.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mZw || view == DistributeVideoView.this.mZv) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.mZE);
                } else if (view == DistributeVideoView.this.mZt || view == DistributeVideoView.this.mZA) {
                    DistributeVideoView.this.dEO();
                } else if (!(DistributeVideoView.this.mZG instanceof AdCard)) {
                    DistributeVideoView.this.dEO();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dEK();
                    if (t.HL(jump2DownloadDetailPage)) {
                        DistributeVideoView.this.Ii(jump2DownloadDetailPage);
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mZC != 1) {
                            if (DistributeVideoView.this.gAl.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mZC = 1;
                                DistributeVideoView.this.dAO();
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
                        if (DistributeVideoView.this.mZC == 1) {
                            if (DistributeVideoView.this.mZD == DistributeVideoView.this.gAl.getCurrentPosition()) {
                                DistributeVideoView.this.bQA();
                            } else {
                                DistributeVideoView.this.mZD = DistributeVideoView.this.gAl.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.mZJ = DistributeVideoView.this.gAl.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gAl.getDuration();
                    DistributeVideoView.this.gAl.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mZE && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mZr != null) {
                    if (DistributeVideoView.this.mZK && "DETAIL".equals(DistributeVideoView.this.mZr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), 0);
                }
                return false;
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dEN();
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), DistributeVideoView.this.gAl.getCurrentPosition());
                }
                DistributeVideoView.this.kwr.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mZx.setVisibility(0);
                return true;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mZF = System.currentTimeMillis();
                DistributeVideoView.this.mZK = true;
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), DistributeVideoView.this.gAl.getDuration());
                }
                DistributeVideoView.this.dEN();
                if (DistributeVideoView.this.mVz != null) {
                    DistributeVideoView.this.mVz.dEB();
                    DistributeVideoView.this.mZu.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mSf = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mZp != null && DistributeVideoView.this.gAl != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ig(1);
                }
            }
        };
        this.mZM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEP();
            }
        };
        this.mZN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xG(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mZI) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mZI = DistributeVideoView.this.mZE;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xE(true);
                    }
                }
            }
        };
        this.mZO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xG(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mZo = false;
        this.mWeakContext = null;
        this.mZC = -1;
        this.mZD = 0L;
        this.mZE = false;
        this.mZF = 0L;
        this.mStyle = 1;
        this.epX = false;
        this.mZH = false;
        this.mZI = false;
        this.mZK = false;
        this.mZL = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mZx) {
                    DistributeVideoView.this.mZx.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mZw || view == DistributeVideoView.this.mZv) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.mZE);
                } else if (view == DistributeVideoView.this.mZt || view == DistributeVideoView.this.mZA) {
                    DistributeVideoView.this.dEO();
                } else if (!(DistributeVideoView.this.mZG instanceof AdCard)) {
                    DistributeVideoView.this.dEO();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dEK();
                    if (t.HL(jump2DownloadDetailPage)) {
                        DistributeVideoView.this.Ii(jump2DownloadDetailPage);
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mZC != 1) {
                            if (DistributeVideoView.this.gAl.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mZC = 1;
                                DistributeVideoView.this.dAO();
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
                        if (DistributeVideoView.this.mZC == 1) {
                            if (DistributeVideoView.this.mZD == DistributeVideoView.this.gAl.getCurrentPosition()) {
                                DistributeVideoView.this.bQA();
                            } else {
                                DistributeVideoView.this.mZD = DistributeVideoView.this.gAl.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.mZJ = DistributeVideoView.this.gAl.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gAl.getDuration();
                    DistributeVideoView.this.gAl.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mZE && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mZr != null) {
                    if (DistributeVideoView.this.mZK && "DETAIL".equals(DistributeVideoView.this.mZr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), 0);
                }
                return false;
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dEN();
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), DistributeVideoView.this.gAl.getCurrentPosition());
                }
                DistributeVideoView.this.kwr.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mZx.setVisibility(0);
                return true;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mZF = System.currentTimeMillis();
                DistributeVideoView.this.mZK = true;
                if (DistributeVideoView.this.gAl != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Ih(DistributeVideoView.this.mZL), DistributeVideoView.this.gAl.getDuration());
                }
                DistributeVideoView.this.dEN();
                if (DistributeVideoView.this.mVz != null) {
                    DistributeVideoView.this.mVz.dEB();
                    DistributeVideoView.this.mZu.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mSf = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mZp != null && DistributeVideoView.this.gAl != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ig(1);
                }
            }
        };
        this.mZM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEP();
            }
        };
        this.mZN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xG(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mZI) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mZI = DistributeVideoView.this.mZE;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jil = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xE(true);
                    }
                }
            }
        };
        this.mZO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xG(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mZG = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gAl = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gAl.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gAl.setNoBussinessStats();
            this.mZt = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.kwr = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mZu = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mZx = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mZy = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mZv = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mZz = this.mRootView.findViewById(R.id.distribute_control);
            this.mZA = (ImageView) this.mZz.findViewById(R.id.distribute_play_icon);
            this.mZw = (ImageView) this.mZz.findViewById(R.id.distribute_voice);
            this.mZB = (VideoControllerView) this.mZz.findViewById(R.id.distribute_process);
            this.mVx = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mVy = new d(context, this.mVx);
            this.mZt.setAnimation(R.raw.lotti_video_loading);
            this.mZt.setMinFrame(0);
            this.mZt.setFrame(0);
            com.baidu.tbadk.a.b.b.m(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dEL() {
        return this.mStyle == 1 ? v.dEL() : j.isWifiNet();
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
        this.mZq = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mSa = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mZp = videoInfo;
        this.mDuration = this.mZp.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dEN();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mZp.video_width.intValue() > 0 ? (this.mZp.video_height.intValue() * equipmentWidth) / this.mZp.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.kwr.setDefaultResource(0);
        this.kwr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kwr.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnErrorListener(this.eAB);
        this.gAl.setOnCompletionListener(this.eAC);
        this.gAl.setOnInfoListener(this.eAD);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        ap.setViewTextColor(this.mZu, R.color.cp_cont_m);
        this.mZu.setText(StringUtils.translateSecondsToString(this.mZp.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mZE = false;
            ap.setImageResource(this.mZv, R.drawable.icon_vedio_npronunciation_small_white);
            this.mZv.setVisibility(8);
        } else {
            this.mZE = true;
            ap.setImageResource(this.mZw, R.drawable.ad_icon_sound_open);
            this.mZv.setVisibility(8);
        }
        this.mZw.setOnClickListener(this.mOnClickListener);
        this.mZv.setOnClickListener(this.mOnClickListener);
        this.mZx.setOnClickListener(this.mOnClickListener);
        this.mZx.setVisibility(8);
        ap.setBackgroundColor(this.mZx, R.color.black_alpha80);
        ap.setViewTextColor(this.mZy, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mZu.setVisibility(0);
            return;
        }
        this.mZu.setVisibility(8);
        this.mZA.setOnClickListener(this.mOnClickListener);
        this.mZt.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mZp = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dEN();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.kwr.setDefaultResource(0);
        this.kwr.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kwr.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnErrorListener(this.eAB);
        this.gAl.setOnCompletionListener(this.eAC);
        this.gAl.setOnInfoListener(this.eAD);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        ap.setViewTextColor(this.mZu, R.color.cp_cont_m);
        this.mZu.setText(StringUtils.translateSecondsToString(this.mZp.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mZE = false;
            ap.setImageResource(this.mZv, R.drawable.icon_vedio_npronunciation_small_white);
            this.mZv.setVisibility(8);
        } else {
            this.mZE = true;
            ap.setImageResource(this.mZw, R.drawable.ad_icon_sound_open);
            this.mZv.setVisibility(8);
        }
        this.mZw.setOnClickListener(this.mOnClickListener);
        this.mZv.setOnClickListener(this.mOnClickListener);
        this.mZx.setOnClickListener(this.mOnClickListener);
        this.mZx.setVisibility(8);
        ap.setBackgroundColor(this.mZx, R.color.black_alpha80);
        ap.setViewTextColor(this.mZy, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mZu.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mZu.setVisibility(8);
        this.mZA.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mZr;
        }
        this.mVz = this.mVy.a(this.mSa, this.mVz);
        if (this.mVz != null) {
            this.mVz.setPageContext(this.mPageContext);
            this.mVz.c(this.mZG);
            if (this.mVz instanceof a) {
                ((a) this.mVz).xC(this.mYc);
            }
            this.mVz.setAdvertAppInfo(advertAppInfo);
            this.mVz.a(this.mSa);
            this.mVz.dEC();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mYc = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mVz != null) {
            this.mVz.setDownloadAppCallback(cVar);
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
        this.eAC = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(int i) {
        this.mZL = i;
        if (this.mZp != null && this.mZC == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mZF) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mVz != null) {
                    this.mVz.dEC();
                }
                this.gAl.setVideoPath(this.mZp.video_url);
                this.gAl.start();
                this.mZJ = this.gAl.getCurrentPosition();
                ap.setImageResource(this.mZA, R.drawable.icon_video_midplay);
                bQA();
                this.mZx.setVisibility(8);
                this.kwr.setForegroundDrawable(0);
                this.mZC = 0;
                if (this.mStyle == 1) {
                    this.mZu.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mZu.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mZO);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.jil);
                }
                ac(31, Ih(this.mZL), 0);
            }
        }
    }

    public void performPlay() {
        Ig(2);
    }

    @Override // com.baidu.tieba.recapp.k
    public void autoPlay(int i) {
        if (dEL()) {
            if (i <= 0) {
                Ig(1);
                return;
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mSf);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mSf, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mZC == 1) {
            J(32, Ih(this.mZL), this.gAl.getCurrentPosition(), i);
            this.gAl.pause();
            ak.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mZA, R.drawable.icon_video_midpause);
            this.mZC = 2;
        }
    }

    public void autoContinue() {
        if (!this.mZH) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mZC == 2) {
            this.mZL = i;
            ac(33, Ih(i), this.gAl.getCurrentPosition());
            this.mZJ = this.gAl.getCurrentPosition();
            this.gAl.start();
            if (this.mZE) {
                ak.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mZA, R.drawable.icon_video_midplay);
            this.mZC = 1;
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // com.baidu.tieba.recapp.k
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQA() {
        if (this.mZt != null) {
            this.mZt.setAlpha(1.0f);
            this.mZt.setVisibility(0);
            this.mZt.loop(true);
            this.mZt.setMinAndMaxFrame(14, 80);
            this.mZt.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dEM();
        if (z) {
            this.mZt.setAlpha(1.0f);
            this.mZt.setVisibility(0);
            return;
        }
        this.mZt.setVisibility(8);
    }

    private void dEM() {
        if (this.mZt != null) {
            this.mZt.setMinFrame(0);
            this.mZt.setFrame(0);
            this.mZt.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public void startPlay() {
        autoPlay(0);
    }

    @Override // com.baidu.tieba.recapp.k
    public void stopPlay() {
        stopPlay(true);
    }

    public void stopPlay(boolean z) {
        if (this.gAl.getCurrentPosition() > 0 && this.mZC != -1 && z) {
            int i = 32;
            int currentPosition = this.gAl.getCurrentPosition();
            if (this.gAl.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, Ih(this.mZL), currentPosition, this.gAl.isPlaying());
        }
        dEN();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gAl.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mVx.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kwr.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int HR = com.baidu.tieba.recapp.lego.a.a.HR(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = HR;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = HR;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = HR;
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
        this.gAl.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEN() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mSf);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZM);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZN);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gAl.stopPlayback();
        this.mZC = -1;
        ak.a(this.mWeakContext, false);
        xG(false);
        this.kwr.setForegroundDrawable(0);
        this.kwr.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mZA, R.drawable.icon_video_midpause);
        this.mZB.aRo();
        this.mZx.setVisibility(8);
        if (this.mZp != null) {
            this.mZu.setText(StringUtils.translateSecondsToString(this.mZp.video_duration.intValue()));
            this.mZu.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mZI = false;
        MessageManager.getInstance().unRegisterListener(this.mZO);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.jil);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ih(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
        }
        return 1;
    }

    @Override // com.baidu.tieba.recapp.k
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.k
    public String getPlayUrl() {
        return this.mZp != null ? this.mZp.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mVz instanceof a) && (this.mZG instanceof AdCard) && !((AdCard) this.mZG).directDownload) {
            ((a) this.mVz).bLq();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mVz instanceof a) && (this.mZG instanceof AdCard) && !((AdCard) this.mZG).directDownload) {
            ((a) this.mVz).dEA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(boolean z) {
        if (z) {
            if (this.gAl != null) {
                this.gAl.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mZw, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mZv, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mZC == 1) {
                ak.a(this.mWeakContext, true);
            }
        } else {
            if (this.gAl != null) {
                this.gAl.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mZw, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mZv, R.drawable.icon_vedio_npronunciation_small_white);
            ak.a(this.mWeakContext, false);
        }
        this.mZE = z;
    }

    @Override // com.baidu.tieba.recapp.k
    public int getPlayStatus() {
        return this.mZC;
    }

    public VideoInfo getData() {
        return this.mZp;
    }

    @Override // com.baidu.tieba.recapp.k
    public long getCurrentPosition() {
        return this.mZD;
    }

    @Override // com.baidu.tieba.recapp.k
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mZr = advertAppInfo;
        this.mZs = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = h.a(this.mZr, 303, i, Ih(this.mZL), this.mZp.video_duration.intValue(), this.mDuration, -1);
        if (this.mVz != null) {
            this.mVz.e(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2, int i3) {
        J(i, i2, i3, -1);
    }

    private void e(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void J(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.mZr != null && this.mZp != null) {
            this.mZr.page = this.mPage;
            com.baidu.tieba.recapp.report.e.dEu().a(h.a(this.mZr, i, this.mZs, i2, this.mZp.video_duration.intValue(), com.baidu.tieba.ad.b.a.tc(i3), i4));
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
                c(str, this.mZJ, i3, this.mDuration, str2, Ij(i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(int i) {
        if (this.mZr != null && this.mZp != null) {
            this.mZr.page = this.mPage;
            com.baidu.tieba.recapp.report.c a2 = h.a(this.mZr, 706, this.mZs, 1, this.mZp.video_duration.intValue(), com.baidu.tieba.ad.b.a.tc(0), -1);
            boolean z = i == 1000;
            a2.Sd(z ? "APP" : "URL");
            if (!z) {
                a2.HZ(i);
            }
            a2.Sc("DEEPLINK");
            com.baidu.tieba.recapp.report.e.dEu().a(a2);
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mZq != null && AdCard.CHARGE_STYLE_CPV.equals(this.mZq.mTk) && !TextUtils.isEmpty(this.mZq.mTl)) {
            new com.baidu.tieba.recapp.request.a(this.mZq.mTl).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Ij(int i) {
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
            this.mZn = view;
            this.mZo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZM);
            if (this.chW != null) {
                this.chW.cancel();
            }
            this.mZz.setVisibility(0);
            if (this.mZC == 1) {
                ap.setImageResource(this.mZA, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mZA, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mZz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEO() {
        switch (this.mZC) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.nx(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bqx();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mZH = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xF(true);
                    return;
                }
                return;
            case 2:
                this.mZH = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZM);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.mZM, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEP() {
        if (!this.epX && this.chW != null) {
            this.mZz.startAnimation(this.chW);
            this.epX = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.chW = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.chW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mZz.setVisibility(8);
                    DistributeVideoView.this.epX = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dEQ() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZN);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mZN, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(boolean z) {
        if (this.mZv != null && this.mStyle == 1) {
            if (z) {
                this.mZv.setVisibility(0);
                dEQ();
                return;
            }
            this.mZv.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
