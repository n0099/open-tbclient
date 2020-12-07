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
import com.baidu.tbadk.a.b.a;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.recapp.j;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.v;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes26.dex */
public class DistributeVideoView extends RelativeLayout implements j {
    private Animation cbQ;
    boolean ejA;
    private CyberPlayerManager.OnCompletionListener etA;
    private CyberPlayerManager.OnInfoListener etB;
    private CyberPlayerManager.OnPreparedListener ety;
    private CyberPlayerManager.OnErrorListener etz;
    private TbCyberVideoView.a fMW;
    private TbCyberVideoView gqT;
    private CustomMessageListener iUJ;
    private ForeDrawableImageView kfn;
    private Context mContext;
    private int mDuration;
    private AdCard.a mHO;
    private AdCard.f mHP;
    private Runnable mHW;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private ViewGroup mLe;
    private d mLf;
    private e mLg;
    private View mMaskView;
    private boolean mNK;
    private View mOL;
    private boolean mOM;
    private VideoInfo mON;
    private AdvertAppInfo mOO;
    private int mOP;
    private TBLottieAnimationView mOQ;
    private TextView mOR;
    private ImageView mOS;
    private ImageView mOT;
    private View mOU;
    private TextView mOV;
    private View mOW;
    private ImageView mOX;
    private VideoControllerView mOY;
    private int mOZ;
    private View.OnClickListener mOnClickListener;
    private long mPa;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private boolean mPb;
    private long mPc;
    private b mPd;
    boolean mPe;
    private boolean mPf;
    private int mPg;
    boolean mPh;
    private int mPi;
    private Runnable mPj;
    private Runnable mPk;
    private CustomMessageListener mPl;
    private View mRootView;
    private String mScheme;
    private int mStyle;
    private WeakReference<Context> mWeakContext;

    private void dFz() {
        String str = this.mOO != null ? this.mOO.eEf : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.mOO) == 1) {
            ac(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dFz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGt() {
        ac(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCy() {
        if (this.mOQ != null) {
            this.mOQ.clearAnimation();
            this.mOQ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mOQ.setVisibility(8);
                    DistributeVideoView.this.kfn.setVisibility(8);
                    DistributeVideoView.this.xo(DistributeVideoView.this.mPb);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mOR.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mOY.setPlayer(DistributeVideoView.this.gqT);
                        DistributeVideoView.this.mOY.bB(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mON.video_duration.intValue()));
                        DistributeVideoView.this.mOY.showProgress();
                        DistributeVideoView.this.xp(true);
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(DistributeVideoView.this.mPj);
                        com.baidu.adp.lib.f.e.mY().postDelayed(DistributeVideoView.this.mPj, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mPa = DistributeVideoView.this.gqT.getCurrentPosition();
                    DistributeVideoView.this.xq(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mOQ.setMinFrame(0);
                    DistributeVideoView.this.mOQ.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mOM = false;
        this.mWeakContext = null;
        this.mOZ = -1;
        this.mPa = 0L;
        this.mPb = false;
        this.mPc = 0L;
        this.mStyle = 1;
        this.ejA = false;
        this.mPe = false;
        this.mPf = false;
        this.mPh = false;
        this.mPi = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mOU) {
                    DistributeVideoView.this.mOU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mOT || view == DistributeVideoView.this.mOS) {
                    DistributeVideoView.this.xo(!DistributeVideoView.this.mPb);
                } else if (view == DistributeVideoView.this.mOQ || view == DistributeVideoView.this.mOX) {
                    DistributeVideoView.this.dGx();
                } else if (!(DistributeVideoView.this.mPd instanceof AdCard)) {
                    DistributeVideoView.this.dGx();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGt();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mOZ != 1) {
                            if (DistributeVideoView.this.gqT.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mOZ = 1;
                                DistributeVideoView.this.dCy();
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
                        if (DistributeVideoView.this.mOZ == 1) {
                            if (DistributeVideoView.this.mPa == DistributeVideoView.this.gqT.getCurrentPosition()) {
                                DistributeVideoView.this.bRh();
                            } else {
                                DistributeVideoView.this.mPa = DistributeVideoView.this.gqT.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.mPg = DistributeVideoView.this.gqT.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gqT.getDuration();
                    DistributeVideoView.this.gqT.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPb && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xo(false);
                    }
                }
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mOO != null) {
                    if (DistributeVideoView.this.mPh && "DETAIL".equals(DistributeVideoView.this.mOO.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), 0);
                }
                return false;
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dGw();
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), DistributeVideoView.this.gqT.getCurrentPosition());
                }
                DistributeVideoView.this.kfn.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mOU.setVisibility(0);
                return true;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPc = System.currentTimeMillis();
                DistributeVideoView.this.mPh = true;
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), DistributeVideoView.this.gqT.getDuration());
                }
                DistributeVideoView.this.dGw();
                if (DistributeVideoView.this.mLg != null) {
                    DistributeVideoView.this.mLg.dGm();
                    DistributeVideoView.this.mOR.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mHW = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mON != null && DistributeVideoView.this.gqT != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.JA(1);
                }
            }
        };
        this.mPj = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGy();
            }
        };
        this.mPk = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xq(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mPf) {
                            DistributeVideoView.this.xo(true);
                            return;
                        } else {
                            DistributeVideoView.this.xo(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPf = DistributeVideoView.this.mPb;
                    DistributeVideoView.this.xo(true);
                }
            }
        };
        this.iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xo(true);
                    }
                }
            }
        };
        this.mPl = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xq(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOM = false;
        this.mWeakContext = null;
        this.mOZ = -1;
        this.mPa = 0L;
        this.mPb = false;
        this.mPc = 0L;
        this.mStyle = 1;
        this.ejA = false;
        this.mPe = false;
        this.mPf = false;
        this.mPh = false;
        this.mPi = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mOU) {
                    DistributeVideoView.this.mOU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mOT || view == DistributeVideoView.this.mOS) {
                    DistributeVideoView.this.xo(!DistributeVideoView.this.mPb);
                } else if (view == DistributeVideoView.this.mOQ || view == DistributeVideoView.this.mOX) {
                    DistributeVideoView.this.dGx();
                } else if (!(DistributeVideoView.this.mPd instanceof AdCard)) {
                    DistributeVideoView.this.dGx();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGt();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mOZ != 1) {
                            if (DistributeVideoView.this.gqT.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mOZ = 1;
                                DistributeVideoView.this.dCy();
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
                        if (DistributeVideoView.this.mOZ == 1) {
                            if (DistributeVideoView.this.mPa == DistributeVideoView.this.gqT.getCurrentPosition()) {
                                DistributeVideoView.this.bRh();
                            } else {
                                DistributeVideoView.this.mPa = DistributeVideoView.this.gqT.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.mPg = DistributeVideoView.this.gqT.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gqT.getDuration();
                    DistributeVideoView.this.gqT.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPb && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xo(false);
                    }
                }
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mOO != null) {
                    if (DistributeVideoView.this.mPh && "DETAIL".equals(DistributeVideoView.this.mOO.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), 0);
                }
                return false;
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dGw();
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), DistributeVideoView.this.gqT.getCurrentPosition());
                }
                DistributeVideoView.this.kfn.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mOU.setVisibility(0);
                return true;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPc = System.currentTimeMillis();
                DistributeVideoView.this.mPh = true;
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), DistributeVideoView.this.gqT.getDuration());
                }
                DistributeVideoView.this.dGw();
                if (DistributeVideoView.this.mLg != null) {
                    DistributeVideoView.this.mLg.dGm();
                    DistributeVideoView.this.mOR.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mHW = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mON != null && DistributeVideoView.this.gqT != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.JA(1);
                }
            }
        };
        this.mPj = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGy();
            }
        };
        this.mPk = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xq(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mPf) {
                            DistributeVideoView.this.xo(true);
                            return;
                        } else {
                            DistributeVideoView.this.xo(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPf = DistributeVideoView.this.mPb;
                    DistributeVideoView.this.xo(true);
                }
            }
        };
        this.iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xo(true);
                    }
                }
            }
        };
        this.mPl = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xq(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOM = false;
        this.mWeakContext = null;
        this.mOZ = -1;
        this.mPa = 0L;
        this.mPb = false;
        this.mPc = 0L;
        this.mStyle = 1;
        this.ejA = false;
        this.mPe = false;
        this.mPf = false;
        this.mPh = false;
        this.mPi = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mOU) {
                    DistributeVideoView.this.mOU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mOT || view == DistributeVideoView.this.mOS) {
                    DistributeVideoView.this.xo(!DistributeVideoView.this.mPb);
                } else if (view == DistributeVideoView.this.mOQ || view == DistributeVideoView.this.mOX) {
                    DistributeVideoView.this.dGx();
                } else if (!(DistributeVideoView.this.mPd instanceof AdCard)) {
                    DistributeVideoView.this.dGx();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGt();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mOZ != 1) {
                            if (DistributeVideoView.this.gqT.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mOZ = 1;
                                DistributeVideoView.this.dCy();
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
                        if (DistributeVideoView.this.mOZ == 1) {
                            if (DistributeVideoView.this.mPa == DistributeVideoView.this.gqT.getCurrentPosition()) {
                                DistributeVideoView.this.bRh();
                            } else {
                                DistributeVideoView.this.mPa = DistributeVideoView.this.gqT.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.ety = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.mPg = DistributeVideoView.this.gqT.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gqT.getDuration();
                    DistributeVideoView.this.gqT.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPb && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xo(false);
                    }
                }
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mOO != null) {
                    if (DistributeVideoView.this.mPh && "DETAIL".equals(DistributeVideoView.this.mOO.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), 0);
                }
                return false;
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dGw();
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), DistributeVideoView.this.gqT.getCurrentPosition());
                }
                DistributeVideoView.this.kfn.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mOU.setVisibility(0);
                return true;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPc = System.currentTimeMillis();
                DistributeVideoView.this.mPh = true;
                if (DistributeVideoView.this.gqT != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.JB(DistributeVideoView.this.mPi), DistributeVideoView.this.gqT.getDuration());
                }
                DistributeVideoView.this.dGw();
                if (DistributeVideoView.this.mLg != null) {
                    DistributeVideoView.this.mLg.dGm();
                    DistributeVideoView.this.mOR.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fMW = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mHW = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mON != null && DistributeVideoView.this.gqT != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.JA(1);
                }
            }
        };
        this.mPj = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGy();
            }
        };
        this.mPk = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xq(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mPf) {
                            DistributeVideoView.this.xo(true);
                            return;
                        } else {
                            DistributeVideoView.this.xo(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPf = DistributeVideoView.this.mPb;
                    DistributeVideoView.this.xo(true);
                }
            }
        };
        this.iUJ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xo(true);
                    }
                }
            }
        };
        this.mPl = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xq(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mPd = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gqT = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gqT.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gqT.setNoBussinessStats();
            this.mOQ = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.kfn = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mOR = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mOU = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mOV = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mOS = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mOW = this.mRootView.findViewById(R.id.distribute_control);
            this.mOX = (ImageView) this.mOW.findViewById(R.id.distribute_play_icon);
            this.mOT = (ImageView) this.mOW.findViewById(R.id.distribute_voice);
            this.mOY = (VideoControllerView) this.mOW.findViewById(R.id.distribute_process);
            this.mLe = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mLf = new d(context, this.mLe);
            this.mOQ.setAnimation(R.raw.lotti_video_loading);
            this.mOQ.setMinFrame(0);
            this.mOQ.setFrame(0);
            a.j(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dGu() {
        return this.mStyle == 1 ? v.dGu() : com.baidu.adp.lib.util.j.isWifiNet();
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
        this.mHO = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mHP = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mON = videoInfo;
        this.mDuration = this.mON.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dGw();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mON.video_width.intValue() > 0 ? (this.mON.video_height.intValue() * equipmentWidth) / this.mON.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.kfn.setDefaultErrorResource(0);
        this.kfn.setDefaultResource(0);
        this.kfn.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kfn.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gqT.setOnPreparedListener(this.ety);
        this.gqT.setOnErrorListener(this.etz);
        this.gqT.setOnCompletionListener(this.etA);
        this.gqT.setOnInfoListener(this.etB);
        this.gqT.setOnSurfaceDestroyedListener(this.fMW);
        ap.setViewTextColor(this.mOR, R.color.cp_cont_m);
        this.mOR.setText(StringUtils.translateSecondsToString(this.mON.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mPb = false;
            ap.setImageResource(this.mOS, R.drawable.icon_vedio_npronunciation_small_white);
            this.mOS.setVisibility(8);
        } else {
            this.mPb = true;
            ap.setImageResource(this.mOT, R.drawable.ad_icon_sound_open);
            this.mOS.setVisibility(8);
        }
        this.mOT.setOnClickListener(this.mOnClickListener);
        this.mOS.setOnClickListener(this.mOnClickListener);
        this.mOU.setOnClickListener(this.mOnClickListener);
        this.mOU.setVisibility(8);
        ap.setBackgroundColor(this.mOU, R.color.black_alpha80);
        ap.setViewTextColor(this.mOV, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mOR.setVisibility(0);
            return;
        }
        this.mOR.setVisibility(8);
        this.mOX.setOnClickListener(this.mOnClickListener);
        this.mOQ.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mON = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dGw();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.kfn.setDefaultErrorResource(0);
        this.kfn.setDefaultResource(0);
        this.kfn.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kfn.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gqT.setOnPreparedListener(this.ety);
        this.gqT.setOnErrorListener(this.etz);
        this.gqT.setOnCompletionListener(this.etA);
        this.gqT.setOnInfoListener(this.etB);
        this.gqT.setOnSurfaceDestroyedListener(this.fMW);
        ap.setViewTextColor(this.mOR, R.color.cp_cont_m);
        this.mOR.setText(StringUtils.translateSecondsToString(this.mON.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mPb = false;
            ap.setImageResource(this.mOS, R.drawable.icon_vedio_npronunciation_small_white);
            this.mOS.setVisibility(8);
        } else {
            this.mPb = true;
            ap.setImageResource(this.mOT, R.drawable.ad_icon_sound_open);
            this.mOS.setVisibility(8);
        }
        this.mOT.setOnClickListener(this.mOnClickListener);
        this.mOS.setOnClickListener(this.mOnClickListener);
        this.mOU.setOnClickListener(this.mOnClickListener);
        this.mOU.setVisibility(8);
        ap.setBackgroundColor(this.mOU, R.color.black_alpha80);
        ap.setViewTextColor(this.mOV, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mOR.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mOR.setVisibility(8);
        this.mOX.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mOO;
        }
        this.mLg = this.mLf.a(this.mHP, this.mLg);
        if (this.mLg != null) {
            this.mLg.setPageContext(this.mPageContext);
            this.mLg.c(this.mPd);
            if (this.mLg instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.mLg).xm(this.mNK);
            }
            this.mLg.setAdvertAppInfo(advertAppInfo);
            this.mLg.a(this.mHP);
            this.mLg.dGn();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mNK = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mLg != null) {
            this.mLg.setDownloadAppCallback(cVar);
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
        this.etA = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JA(int i) {
        this.mPi = i;
        if (this.mON != null && this.mOZ == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mPc) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mLg != null) {
                    this.mLg.dGn();
                }
                this.gqT.setVideoPath(this.mON.video_url);
                this.gqT.start();
                this.mPg = this.gqT.getCurrentPosition();
                ap.setImageResource(this.mOX, R.drawable.icon_video_midplay);
                bRh();
                this.mOU.setVisibility(8);
                this.kfn.setForegroundDrawable(0);
                this.mOZ = 0;
                if (this.mStyle == 1) {
                    this.mOR.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mOR.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mPl);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.iUJ);
                }
                ac(31, JB(this.mPi), 0);
            }
        }
    }

    public void performPlay() {
        JA(2);
    }

    @Override // com.baidu.tieba.recapp.j
    public void autoPlay(int i) {
        if (dGu()) {
            if (i <= 0) {
                JA(1);
                return;
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHW);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mHW, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mOZ == 1) {
            L(32, JB(this.mPi), this.gqT.getCurrentPosition(), i);
            this.gqT.pause();
            ai.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mOX, R.drawable.icon_video_midpause);
            this.mOZ = 2;
        }
    }

    public void autoContinue() {
        if (!this.mPe) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mOZ == 2) {
            this.mPi = i;
            ac(33, JB(i), this.gqT.getCurrentPosition());
            this.mPg = this.gqT.getCurrentPosition();
            this.gqT.start();
            if (this.mPb) {
                ai.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mOX, R.drawable.icon_video_midplay);
            this.mOZ = 1;
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
    public void bRh() {
        if (this.mOQ != null) {
            this.mOQ.setAlpha(1.0f);
            this.mOQ.setVisibility(0);
            this.mOQ.loop(true);
            this.mOQ.setMinAndMaxFrame(14, 80);
            this.mOQ.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dGv();
        if (z) {
            this.mOQ.setAlpha(1.0f);
            this.mOQ.setVisibility(0);
            return;
        }
        this.mOQ.setVisibility(8);
    }

    private void dGv() {
        if (this.mOQ != null) {
            this.mOQ.setMinFrame(0);
            this.mOQ.setFrame(0);
            this.mOQ.cancelAnimation();
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
        if (this.gqT.getCurrentPosition() > 0 && this.mOZ != -1 && z) {
            int i = 32;
            int currentPosition = this.gqT.getCurrentPosition();
            if (this.gqT.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, JB(this.mPi), currentPosition, this.gqT.isPlaying());
        }
        dGw();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gqT.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLe.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kfn.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int Jl = com.baidu.tieba.recapp.lego.a.a.Jl(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = Jl;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = Jl;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = Jl;
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
        this.gqT.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGw() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHW);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPj);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPk);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gqT.stopPlayback();
        this.mOZ = -1;
        ai.a(this.mWeakContext, false);
        xq(false);
        this.kfn.setForegroundDrawable(0);
        this.kfn.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mOX, R.drawable.icon_video_midpause);
        this.mOY.aSx();
        this.mOU.setVisibility(8);
        if (this.mON != null) {
            this.mOR.setText(StringUtils.translateSecondsToString(this.mON.video_duration.intValue()));
            this.mOR.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mPf = false;
        MessageManager.getInstance().unRegisterListener(this.mPl);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.iUJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int JB(int i) {
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
        return this.mON != null ? this.mON.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mLg instanceof com.baidu.tieba.recapp.e.a) && (this.mPd instanceof AdCard) && !((AdCard) this.mPd).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mLg).bMq();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mLg instanceof com.baidu.tieba.recapp.e.a) && (this.mPd instanceof AdCard) && !((AdCard) this.mPd).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mLg).dGl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xo(boolean z) {
        if (z) {
            if (this.gqT != null) {
                this.gqT.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mOT, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mOS, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mOZ == 1) {
                ai.a(this.mWeakContext, true);
            }
        } else {
            if (this.gqT != null) {
                this.gqT.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mOT, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mOS, R.drawable.icon_vedio_npronunciation_small_white);
            ai.a(this.mWeakContext, false);
        }
        this.mPb = z;
    }

    @Override // com.baidu.tieba.recapp.j
    public int getPlayStatus() {
        return this.mOZ;
    }

    public VideoInfo getData() {
        return this.mON;
    }

    @Override // com.baidu.tieba.recapp.j
    public long getCurrentPosition() {
        return this.mPa;
    }

    @Override // com.baidu.tieba.recapp.j
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mOO = advertAppInfo;
        this.mOP = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = g.a(this.mOO, 303, i, JB(this.mPi), this.mON.video_duration.intValue(), this.mDuration, -1);
        if (this.mLg != null) {
            this.mLg.e(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2, int i3) {
        L(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void L(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.mOO != null && this.mON != null) {
            this.mOO.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dGf().a(g.a(this.mOO, i, this.mOP, i2, this.mON.video_duration.intValue(), com.baidu.tieba.ad.a.a.us(i3), i4));
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
                c(str, this.mPg, i3, this.mDuration, str2, JC(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mHO != null && AdCard.CHARGE_STYLE_CPV.equals(this.mHO.mIV) && !TextUtils.isEmpty(this.mHO.mIW)) {
            new com.baidu.tieba.recapp.request.a(this.mHO.mIW).a(str, i, i2, i3, str2, str3);
        }
    }

    private String JC(int i) {
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
            this.mOL = view;
            this.mOM = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPj);
            if (this.cbQ != null) {
                this.cbQ.cancel();
            }
            this.mOW.setVisibility(0);
            if (this.mOZ == 1) {
                ap.setImageResource(this.mOX, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mOX, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mOW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGx() {
        switch (this.mOZ) {
            case -1:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!com.baidu.adp.lib.util.j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.oQ(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).brv();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mPe = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xp(true);
                    return;
                }
                return;
            case 2:
                this.mPe = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPj);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.mPj, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGy() {
        if (!this.ejA && this.cbQ != null) {
            this.mOW.startAnimation(this.cbQ);
            this.ejA = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.cbQ = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.cbQ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mOW.setVisibility(8);
                    DistributeVideoView.this.ejA = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dGz() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPk);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mPk, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(boolean z) {
        if (this.mOS != null && this.mStyle == 1) {
            if (z) {
                this.mOS.setVisibility(0);
                dGz();
                return;
            }
            this.mOS.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
