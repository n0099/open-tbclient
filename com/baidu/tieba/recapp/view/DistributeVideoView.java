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
import com.baidu.tieba.recapp.j;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.h;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.v;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes8.dex */
public class DistributeVideoView extends RelativeLayout implements j {
    private Animation chW;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnErrorListener eAB;
    private CyberPlayerManager.OnCompletionListener eAC;
    private CyberPlayerManager.OnInfoListener eAD;
    boolean epX;
    private TbCyberVideoView.a fUi;
    private TbCyberVideoView gzX;
    private CustomMessageListener jhW;
    private ForeDrawableImageView kwd;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private AdCard.f mRI;
    private Runnable mRN;
    private View mRootView;
    private String mScheme;
    private int mStyle;
    private ViewGroup mUX;
    private d mUY;
    private e mUZ;
    private WeakReference<Context> mWeakContext;
    private boolean mXC;
    private View mYN;
    private boolean mYO;
    private VideoInfo mYP;
    private AdCard.a mYQ;
    private AdvertAppInfo mYR;
    private int mYS;
    private TBLottieAnimationView mYT;
    private TextView mYU;
    private ImageView mYV;
    private ImageView mYW;
    private View mYX;
    private TextView mYY;
    private View mYZ;
    private ImageView mZa;
    private VideoControllerView mZb;
    private int mZc;
    private long mZd;
    private boolean mZe;
    private long mZf;
    private b mZg;
    boolean mZh;
    private boolean mZi;
    private int mZj;
    boolean mZk;
    private int mZl;
    private Runnable mZm;
    private Runnable mZn;
    private CustomMessageListener mZo;

    public int jump2DownloadDetailPage() {
        return dEB();
    }

    private int dEB() {
        String str = this.mYR != null ? this.mYR.eLw : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (TextUtils.isEmpty(str) || this.mContext == null) {
            return 0;
        }
        if (s.b(this.mYR, str)) {
            return 3;
        }
        return s.a(this.mContext, str, this.mYR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEC() {
        ac(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAH() {
        if (this.mYT != null) {
            this.mYT.clearAnimation();
            this.mYT.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mYT.setVisibility(8);
                    DistributeVideoView.this.kwd.setVisibility(8);
                    DistributeVideoView.this.xE(DistributeVideoView.this.mZe);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mYU.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mZb.setPlayer(DistributeVideoView.this.gzX);
                        DistributeVideoView.this.mZb.bw(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mYP.video_duration.intValue()));
                        DistributeVideoView.this.mZb.showProgress();
                        DistributeVideoView.this.xF(true);
                        com.baidu.adp.lib.f.e.mA().removeCallbacks(DistributeVideoView.this.mZm);
                        com.baidu.adp.lib.f.e.mA().postDelayed(DistributeVideoView.this.mZm, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mZd = DistributeVideoView.this.gzX.getCurrentPosition();
                    DistributeVideoView.this.xG(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mYT.setMinFrame(0);
                    DistributeVideoView.this.mYT.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mYO = false;
        this.mWeakContext = null;
        this.mZc = -1;
        this.mZd = 0L;
        this.mZe = false;
        this.mZf = 0L;
        this.mStyle = 1;
        this.epX = false;
        this.mZh = false;
        this.mZi = false;
        this.mZk = false;
        this.mZl = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mYX) {
                    DistributeVideoView.this.mYX.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mYW || view == DistributeVideoView.this.mYV) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.mZe);
                } else if (view == DistributeVideoView.this.mYT || view == DistributeVideoView.this.mZa) {
                    DistributeVideoView.this.dEG();
                } else if (!(DistributeVideoView.this.mZg instanceof AdCard)) {
                    DistributeVideoView.this.dEG();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dEC();
                    if (s.HL(jump2DownloadDetailPage)) {
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
                        if (DistributeVideoView.this.mZc != 1) {
                            if (DistributeVideoView.this.gzX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mZc = 1;
                                DistributeVideoView.this.dAH();
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
                        if (DistributeVideoView.this.mZc == 1) {
                            if (DistributeVideoView.this.mZd == DistributeVideoView.this.gzX.getCurrentPosition()) {
                                DistributeVideoView.this.bQt();
                            } else {
                                DistributeVideoView.this.mZd = DistributeVideoView.this.gzX.getCurrentPosition();
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
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.mZj = DistributeVideoView.this.gzX.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gzX.getDuration();
                    DistributeVideoView.this.gzX.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mZe && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mYR != null) {
                    if (DistributeVideoView.this.mZk && "DETAIL".equals(DistributeVideoView.this.mYR.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), 0);
                }
                return false;
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dEF();
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), DistributeVideoView.this.gzX.getCurrentPosition());
                }
                DistributeVideoView.this.kwd.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mYX.setVisibility(0);
                return true;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mZf = System.currentTimeMillis();
                DistributeVideoView.this.mZk = true;
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), DistributeVideoView.this.gzX.getDuration());
                }
                DistributeVideoView.this.dEF();
                if (DistributeVideoView.this.mUZ != null) {
                    DistributeVideoView.this.mUZ.dEt();
                    DistributeVideoView.this.mYU.setVisibility(8);
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
        this.mRN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mYP != null && DistributeVideoView.this.gzX != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ig(1);
                }
            }
        };
        this.mZm = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEH();
            }
        };
        this.mZn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.mZi) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mZi = DistributeVideoView.this.mZe;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.mZo = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.mYO = false;
        this.mWeakContext = null;
        this.mZc = -1;
        this.mZd = 0L;
        this.mZe = false;
        this.mZf = 0L;
        this.mStyle = 1;
        this.epX = false;
        this.mZh = false;
        this.mZi = false;
        this.mZk = false;
        this.mZl = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mYX) {
                    DistributeVideoView.this.mYX.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mYW || view == DistributeVideoView.this.mYV) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.mZe);
                } else if (view == DistributeVideoView.this.mYT || view == DistributeVideoView.this.mZa) {
                    DistributeVideoView.this.dEG();
                } else if (!(DistributeVideoView.this.mZg instanceof AdCard)) {
                    DistributeVideoView.this.dEG();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dEC();
                    if (s.HL(jump2DownloadDetailPage)) {
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
                        if (DistributeVideoView.this.mZc != 1) {
                            if (DistributeVideoView.this.gzX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mZc = 1;
                                DistributeVideoView.this.dAH();
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
                        if (DistributeVideoView.this.mZc == 1) {
                            if (DistributeVideoView.this.mZd == DistributeVideoView.this.gzX.getCurrentPosition()) {
                                DistributeVideoView.this.bQt();
                            } else {
                                DistributeVideoView.this.mZd = DistributeVideoView.this.gzX.getCurrentPosition();
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
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.mZj = DistributeVideoView.this.gzX.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gzX.getDuration();
                    DistributeVideoView.this.gzX.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mZe && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mYR != null) {
                    if (DistributeVideoView.this.mZk && "DETAIL".equals(DistributeVideoView.this.mYR.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), 0);
                }
                return false;
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dEF();
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), DistributeVideoView.this.gzX.getCurrentPosition());
                }
                DistributeVideoView.this.kwd.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mYX.setVisibility(0);
                return true;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mZf = System.currentTimeMillis();
                DistributeVideoView.this.mZk = true;
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), DistributeVideoView.this.gzX.getDuration());
                }
                DistributeVideoView.this.dEF();
                if (DistributeVideoView.this.mUZ != null) {
                    DistributeVideoView.this.mUZ.dEt();
                    DistributeVideoView.this.mYU.setVisibility(8);
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
        this.mRN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mYP != null && DistributeVideoView.this.gzX != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ig(1);
                }
            }
        };
        this.mZm = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEH();
            }
        };
        this.mZn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.mZi) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mZi = DistributeVideoView.this.mZe;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.mZo = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.mYO = false;
        this.mWeakContext = null;
        this.mZc = -1;
        this.mZd = 0L;
        this.mZe = false;
        this.mZf = 0L;
        this.mStyle = 1;
        this.epX = false;
        this.mZh = false;
        this.mZi = false;
        this.mZk = false;
        this.mZl = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mYX) {
                    DistributeVideoView.this.mYX.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mYW || view == DistributeVideoView.this.mYV) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.mZe);
                } else if (view == DistributeVideoView.this.mYT || view == DistributeVideoView.this.mZa) {
                    DistributeVideoView.this.dEG();
                } else if (!(DistributeVideoView.this.mZg instanceof AdCard)) {
                    DistributeVideoView.this.dEG();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dEC();
                    if (s.HL(jump2DownloadDetailPage)) {
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
                        if (DistributeVideoView.this.mZc != 1) {
                            if (DistributeVideoView.this.gzX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mZc = 1;
                                DistributeVideoView.this.dAH();
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
                        if (DistributeVideoView.this.mZc == 1) {
                            if (DistributeVideoView.this.mZd == DistributeVideoView.this.gzX.getCurrentPosition()) {
                                DistributeVideoView.this.bQt();
                            } else {
                                DistributeVideoView.this.mZd = DistributeVideoView.this.gzX.getCurrentPosition();
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
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.mZj = DistributeVideoView.this.gzX.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gzX.getDuration();
                    DistributeVideoView.this.gzX.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mZe && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eAD = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mYR != null) {
                    if (DistributeVideoView.this.mZk && "DETAIL".equals(DistributeVideoView.this.mYR.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), 0);
                }
                return false;
            }
        };
        this.eAB = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dEF();
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), DistributeVideoView.this.gzX.getCurrentPosition());
                }
                DistributeVideoView.this.kwd.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mYX.setVisibility(0);
                return true;
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mZf = System.currentTimeMillis();
                DistributeVideoView.this.mZk = true;
                if (DistributeVideoView.this.gzX != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Ih(DistributeVideoView.this.mZl), DistributeVideoView.this.gzX.getDuration());
                }
                DistributeVideoView.this.dEF();
                if (DistributeVideoView.this.mUZ != null) {
                    DistributeVideoView.this.mUZ.dEt();
                    DistributeVideoView.this.mYU.setVisibility(8);
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
        this.mRN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mYP != null && DistributeVideoView.this.gzX != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ig(1);
                }
            }
        };
        this.mZm = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEH();
            }
        };
        this.mZn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.mZi) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mZi = DistributeVideoView.this.mZe;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jhW = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.mZo = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.mZg = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gzX = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gzX.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gzX.setNoBussinessStats();
            this.mYT = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.kwd = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mYU = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mYX = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mYY = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mYV = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mYZ = this.mRootView.findViewById(R.id.distribute_control);
            this.mZa = (ImageView) this.mYZ.findViewById(R.id.distribute_play_icon);
            this.mYW = (ImageView) this.mYZ.findViewById(R.id.distribute_voice);
            this.mZb = (VideoControllerView) this.mYZ.findViewById(R.id.distribute_process);
            this.mUX = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mUY = new d(context, this.mUX);
            this.mYT.setAnimation(R.raw.lotti_video_loading);
            this.mYT.setMinFrame(0);
            this.mYT.setFrame(0);
            com.baidu.tbadk.a.b.b.m(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dED() {
        return this.mStyle == 1 ? v.dED() : com.baidu.adp.lib.util.j.isWifiNet();
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
        this.mYQ = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mRI = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mYP = videoInfo;
        this.mDuration = this.mYP.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dEF();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mYP.video_width.intValue() > 0 ? (this.mYP.video_height.intValue() * equipmentWidth) / this.mYP.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.kwd.setDefaultResource(0);
        this.kwd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kwd.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnErrorListener(this.eAB);
        this.gzX.setOnCompletionListener(this.eAC);
        this.gzX.setOnInfoListener(this.eAD);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        ap.setViewTextColor(this.mYU, R.color.cp_cont_m);
        this.mYU.setText(StringUtils.translateSecondsToString(this.mYP.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mZe = false;
            ap.setImageResource(this.mYV, R.drawable.icon_vedio_npronunciation_small_white);
            this.mYV.setVisibility(8);
        } else {
            this.mZe = true;
            ap.setImageResource(this.mYW, R.drawable.ad_icon_sound_open);
            this.mYV.setVisibility(8);
        }
        this.mYW.setOnClickListener(this.mOnClickListener);
        this.mYV.setOnClickListener(this.mOnClickListener);
        this.mYX.setOnClickListener(this.mOnClickListener);
        this.mYX.setVisibility(8);
        ap.setBackgroundColor(this.mYX, R.color.black_alpha80);
        ap.setViewTextColor(this.mYY, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mYU.setVisibility(0);
            return;
        }
        this.mYU.setVisibility(8);
        this.mZa.setOnClickListener(this.mOnClickListener);
        this.mYT.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mYP = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dEF();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.kwd.setDefaultResource(0);
        this.kwd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kwd.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnErrorListener(this.eAB);
        this.gzX.setOnCompletionListener(this.eAC);
        this.gzX.setOnInfoListener(this.eAD);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        ap.setViewTextColor(this.mYU, R.color.cp_cont_m);
        this.mYU.setText(StringUtils.translateSecondsToString(this.mYP.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mZe = false;
            ap.setImageResource(this.mYV, R.drawable.icon_vedio_npronunciation_small_white);
            this.mYV.setVisibility(8);
        } else {
            this.mZe = true;
            ap.setImageResource(this.mYW, R.drawable.ad_icon_sound_open);
            this.mYV.setVisibility(8);
        }
        this.mYW.setOnClickListener(this.mOnClickListener);
        this.mYV.setOnClickListener(this.mOnClickListener);
        this.mYX.setOnClickListener(this.mOnClickListener);
        this.mYX.setVisibility(8);
        ap.setBackgroundColor(this.mYX, R.color.black_alpha80);
        ap.setViewTextColor(this.mYY, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mYU.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mYU.setVisibility(8);
        this.mZa.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mYR;
        }
        this.mUZ = this.mUY.a(this.mRI, this.mUZ);
        if (this.mUZ != null) {
            this.mUZ.setPageContext(this.mPageContext);
            this.mUZ.c(this.mZg);
            if (this.mUZ instanceof a) {
                ((a) this.mUZ).xC(this.mXC);
            }
            this.mUZ.setAdvertAppInfo(advertAppInfo);
            this.mUZ.a(this.mRI);
            this.mUZ.dEu();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mXC = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mUZ != null) {
            this.mUZ.setDownloadAppCallback(cVar);
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
        this.mZl = i;
        if (this.mYP != null && this.mZc == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mZf) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mUZ != null) {
                    this.mUZ.dEu();
                }
                this.gzX.setVideoPath(this.mYP.video_url);
                this.gzX.start();
                this.mZj = this.gzX.getCurrentPosition();
                ap.setImageResource(this.mZa, R.drawable.icon_video_midplay);
                bQt();
                this.mYX.setVisibility(8);
                this.kwd.setForegroundDrawable(0);
                this.mZc = 0;
                if (this.mStyle == 1) {
                    this.mYU.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mYU.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mZo);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.jhW);
                }
                ac(31, Ih(this.mZl), 0);
            }
        }
    }

    public void performPlay() {
        Ig(2);
    }

    @Override // com.baidu.tieba.recapp.j
    public void autoPlay(int i) {
        if (dED()) {
            if (i <= 0) {
                Ig(1);
                return;
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mRN);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mRN, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mZc == 1) {
            J(32, Ih(this.mZl), this.gzX.getCurrentPosition(), i);
            this.gzX.pause();
            ak.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mZa, R.drawable.icon_video_midpause);
            this.mZc = 2;
        }
    }

    public void autoContinue() {
        if (!this.mZh) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mZc == 2) {
            this.mZl = i;
            ac(33, Ih(i), this.gzX.getCurrentPosition());
            this.mZj = this.gzX.getCurrentPosition();
            this.gzX.start();
            if (this.mZe) {
                ak.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mZa, R.drawable.icon_video_midplay);
            this.mZc = 1;
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQt() {
        if (this.mYT != null) {
            this.mYT.setAlpha(1.0f);
            this.mYT.setVisibility(0);
            this.mYT.loop(true);
            this.mYT.setMinAndMaxFrame(14, 80);
            this.mYT.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dEE();
        if (z) {
            this.mYT.setAlpha(1.0f);
            this.mYT.setVisibility(0);
            return;
        }
        this.mYT.setVisibility(8);
    }

    private void dEE() {
        if (this.mYT != null) {
            this.mYT.setMinFrame(0);
            this.mYT.setFrame(0);
            this.mYT.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public void startPlay() {
        autoPlay(0);
    }

    @Override // com.baidu.tieba.recapp.j
    public void stopPlay() {
        stopPlay(true);
    }

    public void stopPlay(boolean z) {
        if (this.gzX.getCurrentPosition() > 0 && this.mZc != -1 && z) {
            int i = 32;
            int currentPosition = this.gzX.getCurrentPosition();
            if (this.gzX.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, Ih(this.mZl), currentPosition, this.gzX.isPlaying());
        }
        dEF();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gzX.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mUX.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kwd.getLayoutParams();
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
        this.gzX.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEF() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mRN);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZm);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZn);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gzX.stopPlayback();
        this.mZc = -1;
        ak.a(this.mWeakContext, false);
        xG(false);
        this.kwd.setForegroundDrawable(0);
        this.kwd.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mZa, R.drawable.icon_video_midpause);
        this.mZb.aRo();
        this.mYX.setVisibility(8);
        if (this.mYP != null) {
            this.mYU.setText(StringUtils.translateSecondsToString(this.mYP.video_duration.intValue()));
            this.mYU.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mZi = false;
        MessageManager.getInstance().unRegisterListener(this.mZo);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.jhW);
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

    @Override // com.baidu.tieba.recapp.j
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.j
    public String getPlayUrl() {
        return this.mYP != null ? this.mYP.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mUZ instanceof a) && (this.mZg instanceof AdCard) && !((AdCard) this.mZg).directDownload) {
            ((a) this.mUZ).bLl();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mUZ instanceof a) && (this.mZg instanceof AdCard) && !((AdCard) this.mZg).directDownload) {
            ((a) this.mUZ).dEs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(boolean z) {
        if (z) {
            if (this.gzX != null) {
                this.gzX.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mYW, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mYV, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mZc == 1) {
                ak.a(this.mWeakContext, true);
            }
        } else {
            if (this.gzX != null) {
                this.gzX.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mYW, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mYV, R.drawable.icon_vedio_npronunciation_small_white);
            ak.a(this.mWeakContext, false);
        }
        this.mZe = z;
    }

    @Override // com.baidu.tieba.recapp.j
    public int getPlayStatus() {
        return this.mZc;
    }

    public VideoInfo getData() {
        return this.mYP;
    }

    @Override // com.baidu.tieba.recapp.j
    public long getCurrentPosition() {
        return this.mZd;
    }

    @Override // com.baidu.tieba.recapp.j
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mYR = advertAppInfo;
        this.mYS = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = h.a(this.mYR, 303, i, Ih(this.mZl), this.mYP.video_duration.intValue(), this.mDuration, -1);
        if (this.mUZ != null) {
            this.mUZ.e(a2);
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
        if (this.mYR != null && this.mYP != null) {
            this.mYR.page = this.mPage;
            com.baidu.tieba.recapp.report.e.dEm().a(h.a(this.mYR, i, this.mYS, i2, this.mYP.video_duration.intValue(), com.baidu.tieba.ad.a.a.tc(i3), i4));
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
                c(str, this.mZj, i3, this.mDuration, str2, Ij(i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(int i) {
        if (this.mYR != null && this.mYP != null) {
            this.mYR.page = this.mPage;
            com.baidu.tieba.recapp.report.c a2 = h.a(this.mYR, 706, this.mYS, 1, this.mYP.video_duration.intValue(), com.baidu.tieba.ad.a.a.tc(0), -1);
            boolean z = i == 1000;
            a2.RR(z ? "APP" : "URL");
            if (!z) {
                a2.HZ(i);
            }
            a2.RQ("DEEPLINK");
            com.baidu.tieba.recapp.report.e.dEm().a(a2);
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mYQ != null && AdCard.CHARGE_STYLE_CPV.equals(this.mYQ.mSI) && !TextUtils.isEmpty(this.mYQ.mSJ)) {
            new com.baidu.tieba.recapp.request.a(this.mYQ.mSJ).a(str, i, i2, i3, str2, str3);
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
            this.mYN = view;
            this.mYO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZm);
            if (this.chW != null) {
                this.chW.cancel();
            }
            this.mYZ.setVisibility(0);
            if (this.mZc == 1) {
                ap.setImageResource(this.mZa, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mZa, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mYZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEG() {
        switch (this.mZc) {
            case -1:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!com.baidu.adp.lib.util.j.isWifiNet() && this.mPageContext != null) {
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
                this.mZh = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xF(true);
                    return;
                }
                return;
            case 2:
                this.mZh = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZm);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.mZm, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEH() {
        if (!this.epX && this.chW != null) {
            this.mYZ.startAnimation(this.chW);
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
                    DistributeVideoView.this.mYZ.setVisibility(8);
                    DistributeVideoView.this.epX = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dEI() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mZn);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.mZn, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(boolean z) {
        if (this.mYV != null && this.mStyle == 1) {
            if (z) {
                this.mYV.setVisibility(0);
                dEI();
                return;
            }
            this.mYV.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
