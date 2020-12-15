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
    private TbCyberVideoView gqV;
    private CustomMessageListener iUL;
    private ForeDrawableImageView kfp;
    private Context mContext;
    private int mDuration;
    private AdCard.a mHQ;
    private AdCard.f mHR;
    private Runnable mHY;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private ViewGroup mLg;
    private d mLh;
    private e mLi;
    private View mMaskView;
    private boolean mNM;
    private View mON;
    private boolean mOO;
    private VideoInfo mOP;
    private AdvertAppInfo mOQ;
    private int mOR;
    private TBLottieAnimationView mOS;
    private TextView mOT;
    private ImageView mOU;
    private ImageView mOV;
    private View mOW;
    private TextView mOX;
    private View mOY;
    private ImageView mOZ;
    private View.OnClickListener mOnClickListener;
    private VideoControllerView mPa;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private int mPb;
    private long mPc;
    private boolean mPd;
    private long mPe;
    private b mPf;
    boolean mPg;
    private boolean mPh;
    private int mPi;
    boolean mPj;
    private int mPk;
    private Runnable mPl;
    private Runnable mPo;
    private CustomMessageListener mPp;
    private View mRootView;
    private String mScheme;
    private int mStyle;
    private WeakReference<Context> mWeakContext;

    private void dFA() {
        String str = this.mOQ != null ? this.mOQ.eEf : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.mOQ) == 1) {
            ac(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dFA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGu() {
        ac(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCz() {
        if (this.mOS != null) {
            this.mOS.clearAnimation();
            this.mOS.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mOS.setVisibility(8);
                    DistributeVideoView.this.kfp.setVisibility(8);
                    DistributeVideoView.this.xo(DistributeVideoView.this.mPd);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mOT.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mPa.setPlayer(DistributeVideoView.this.gqV);
                        DistributeVideoView.this.mPa.bB(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mOP.video_duration.intValue()));
                        DistributeVideoView.this.mPa.showProgress();
                        DistributeVideoView.this.xp(true);
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(DistributeVideoView.this.mPl);
                        com.baidu.adp.lib.f.e.mY().postDelayed(DistributeVideoView.this.mPl, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mPc = DistributeVideoView.this.gqV.getCurrentPosition();
                    DistributeVideoView.this.xq(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mOS.setMinFrame(0);
                    DistributeVideoView.this.mOS.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mOO = false;
        this.mWeakContext = null;
        this.mPb = -1;
        this.mPc = 0L;
        this.mPd = false;
        this.mPe = 0L;
        this.mStyle = 1;
        this.ejA = false;
        this.mPg = false;
        this.mPh = false;
        this.mPj = false;
        this.mPk = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mOW) {
                    DistributeVideoView.this.mOW.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mOV || view == DistributeVideoView.this.mOU) {
                    DistributeVideoView.this.xo(!DistributeVideoView.this.mPd);
                } else if (view == DistributeVideoView.this.mOS || view == DistributeVideoView.this.mOZ) {
                    DistributeVideoView.this.dGy();
                } else if (!(DistributeVideoView.this.mPf instanceof AdCard)) {
                    DistributeVideoView.this.dGy();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGu();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mPb != 1) {
                            if (DistributeVideoView.this.gqV.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mPb = 1;
                                DistributeVideoView.this.dCz();
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
                        if (DistributeVideoView.this.mPb == 1) {
                            if (DistributeVideoView.this.mPc == DistributeVideoView.this.gqV.getCurrentPosition()) {
                                DistributeVideoView.this.bRi();
                            } else {
                                DistributeVideoView.this.mPc = DistributeVideoView.this.gqV.getCurrentPosition();
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
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.mPi = DistributeVideoView.this.gqV.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gqV.getDuration();
                    DistributeVideoView.this.gqV.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPd && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xo(false);
                    }
                }
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mOQ != null) {
                    if (DistributeVideoView.this.mPj && "DETAIL".equals(DistributeVideoView.this.mOQ.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), 0);
                }
                return false;
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dGx();
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), DistributeVideoView.this.gqV.getCurrentPosition());
                }
                DistributeVideoView.this.kfp.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mOW.setVisibility(0);
                return true;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPe = System.currentTimeMillis();
                DistributeVideoView.this.mPj = true;
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), DistributeVideoView.this.gqV.getDuration());
                }
                DistributeVideoView.this.dGx();
                if (DistributeVideoView.this.mLi != null) {
                    DistributeVideoView.this.mLi.dGn();
                    DistributeVideoView.this.mOT.setVisibility(8);
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
        this.mHY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mOP != null && DistributeVideoView.this.gqV != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.JA(1);
                }
            }
        };
        this.mPl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGz();
            }
        };
        this.mPo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.mPh) {
                            DistributeVideoView.this.xo(true);
                            return;
                        } else {
                            DistributeVideoView.this.xo(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPh = DistributeVideoView.this.mPd;
                    DistributeVideoView.this.xo(true);
                }
            }
        };
        this.iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.mPp = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.mOO = false;
        this.mWeakContext = null;
        this.mPb = -1;
        this.mPc = 0L;
        this.mPd = false;
        this.mPe = 0L;
        this.mStyle = 1;
        this.ejA = false;
        this.mPg = false;
        this.mPh = false;
        this.mPj = false;
        this.mPk = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mOW) {
                    DistributeVideoView.this.mOW.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mOV || view == DistributeVideoView.this.mOU) {
                    DistributeVideoView.this.xo(!DistributeVideoView.this.mPd);
                } else if (view == DistributeVideoView.this.mOS || view == DistributeVideoView.this.mOZ) {
                    DistributeVideoView.this.dGy();
                } else if (!(DistributeVideoView.this.mPf instanceof AdCard)) {
                    DistributeVideoView.this.dGy();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGu();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mPb != 1) {
                            if (DistributeVideoView.this.gqV.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mPb = 1;
                                DistributeVideoView.this.dCz();
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
                        if (DistributeVideoView.this.mPb == 1) {
                            if (DistributeVideoView.this.mPc == DistributeVideoView.this.gqV.getCurrentPosition()) {
                                DistributeVideoView.this.bRi();
                            } else {
                                DistributeVideoView.this.mPc = DistributeVideoView.this.gqV.getCurrentPosition();
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
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.mPi = DistributeVideoView.this.gqV.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gqV.getDuration();
                    DistributeVideoView.this.gqV.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPd && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xo(false);
                    }
                }
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mOQ != null) {
                    if (DistributeVideoView.this.mPj && "DETAIL".equals(DistributeVideoView.this.mOQ.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), 0);
                }
                return false;
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dGx();
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), DistributeVideoView.this.gqV.getCurrentPosition());
                }
                DistributeVideoView.this.kfp.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mOW.setVisibility(0);
                return true;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPe = System.currentTimeMillis();
                DistributeVideoView.this.mPj = true;
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), DistributeVideoView.this.gqV.getDuration());
                }
                DistributeVideoView.this.dGx();
                if (DistributeVideoView.this.mLi != null) {
                    DistributeVideoView.this.mLi.dGn();
                    DistributeVideoView.this.mOT.setVisibility(8);
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
        this.mHY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mOP != null && DistributeVideoView.this.gqV != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.JA(1);
                }
            }
        };
        this.mPl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGz();
            }
        };
        this.mPo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.mPh) {
                            DistributeVideoView.this.xo(true);
                            return;
                        } else {
                            DistributeVideoView.this.xo(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPh = DistributeVideoView.this.mPd;
                    DistributeVideoView.this.xo(true);
                }
            }
        };
        this.iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.mPp = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.mOO = false;
        this.mWeakContext = null;
        this.mPb = -1;
        this.mPc = 0L;
        this.mPd = false;
        this.mPe = 0L;
        this.mStyle = 1;
        this.ejA = false;
        this.mPg = false;
        this.mPh = false;
        this.mPj = false;
        this.mPk = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mOW) {
                    DistributeVideoView.this.mOW.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mOV || view == DistributeVideoView.this.mOU) {
                    DistributeVideoView.this.xo(!DistributeVideoView.this.mPd);
                } else if (view == DistributeVideoView.this.mOS || view == DistributeVideoView.this.mOZ) {
                    DistributeVideoView.this.dGy();
                } else if (!(DistributeVideoView.this.mPf instanceof AdCard)) {
                    DistributeVideoView.this.dGy();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGu();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mPb != 1) {
                            if (DistributeVideoView.this.gqV.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mPb = 1;
                                DistributeVideoView.this.dCz();
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
                        if (DistributeVideoView.this.mPb == 1) {
                            if (DistributeVideoView.this.mPc == DistributeVideoView.this.gqV.getCurrentPosition()) {
                                DistributeVideoView.this.bRi();
                            } else {
                                DistributeVideoView.this.mPc = DistributeVideoView.this.gqV.getCurrentPosition();
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
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.mPi = DistributeVideoView.this.gqV.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gqV.getDuration();
                    DistributeVideoView.this.gqV.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPd && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xo(false);
                    }
                }
            }
        };
        this.etB = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mOQ != null) {
                    if (DistributeVideoView.this.mPj && "DETAIL".equals(DistributeVideoView.this.mOQ.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), 0);
                }
                return false;
            }
        };
        this.etz = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dGx();
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), DistributeVideoView.this.gqV.getCurrentPosition());
                }
                DistributeVideoView.this.kfp.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mOW.setVisibility(0);
                return true;
            }
        };
        this.etA = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPe = System.currentTimeMillis();
                DistributeVideoView.this.mPj = true;
                if (DistributeVideoView.this.gqV != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.JB(DistributeVideoView.this.mPk), DistributeVideoView.this.gqV.getDuration());
                }
                DistributeVideoView.this.dGx();
                if (DistributeVideoView.this.mLi != null) {
                    DistributeVideoView.this.mLi.dGn();
                    DistributeVideoView.this.mOT.setVisibility(8);
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
        this.mHY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mOP != null && DistributeVideoView.this.gqV != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.JA(1);
                }
            }
        };
        this.mPl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGz();
            }
        };
        this.mPo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.mPh) {
                            DistributeVideoView.this.xo(true);
                            return;
                        } else {
                            DistributeVideoView.this.xo(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPh = DistributeVideoView.this.mPd;
                    DistributeVideoView.this.xo(true);
                }
            }
        };
        this.iUL = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.mPp = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.mPf = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gqV = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gqV.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gqV.setNoBussinessStats();
            this.mOS = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.kfp = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mOT = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mOW = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mOX = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mOU = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mOY = this.mRootView.findViewById(R.id.distribute_control);
            this.mOZ = (ImageView) this.mOY.findViewById(R.id.distribute_play_icon);
            this.mOV = (ImageView) this.mOY.findViewById(R.id.distribute_voice);
            this.mPa = (VideoControllerView) this.mOY.findViewById(R.id.distribute_process);
            this.mLg = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mLh = new d(context, this.mLg);
            this.mOS.setAnimation(R.raw.lotti_video_loading);
            this.mOS.setMinFrame(0);
            this.mOS.setFrame(0);
            a.j(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dGv() {
        return this.mStyle == 1 ? v.dGv() : com.baidu.adp.lib.util.j.isWifiNet();
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
        this.mHQ = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mHR = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mOP = videoInfo;
        this.mDuration = this.mOP.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dGx();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mOP.video_width.intValue() > 0 ? (this.mOP.video_height.intValue() * equipmentWidth) / this.mOP.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.kfp.setDefaultErrorResource(0);
        this.kfp.setDefaultResource(0);
        this.kfp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kfp.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gqV.setOnPreparedListener(this.ety);
        this.gqV.setOnErrorListener(this.etz);
        this.gqV.setOnCompletionListener(this.etA);
        this.gqV.setOnInfoListener(this.etB);
        this.gqV.setOnSurfaceDestroyedListener(this.fMW);
        ap.setViewTextColor(this.mOT, R.color.cp_cont_m);
        this.mOT.setText(StringUtils.translateSecondsToString(this.mOP.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mPd = false;
            ap.setImageResource(this.mOU, R.drawable.icon_vedio_npronunciation_small_white);
            this.mOU.setVisibility(8);
        } else {
            this.mPd = true;
            ap.setImageResource(this.mOV, R.drawable.ad_icon_sound_open);
            this.mOU.setVisibility(8);
        }
        this.mOV.setOnClickListener(this.mOnClickListener);
        this.mOU.setOnClickListener(this.mOnClickListener);
        this.mOW.setOnClickListener(this.mOnClickListener);
        this.mOW.setVisibility(8);
        ap.setBackgroundColor(this.mOW, R.color.black_alpha80);
        ap.setViewTextColor(this.mOX, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mOT.setVisibility(0);
            return;
        }
        this.mOT.setVisibility(8);
        this.mOZ.setOnClickListener(this.mOnClickListener);
        this.mOS.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mOP = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dGx();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.kfp.setDefaultErrorResource(0);
        this.kfp.setDefaultResource(0);
        this.kfp.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kfp.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gqV.setOnPreparedListener(this.ety);
        this.gqV.setOnErrorListener(this.etz);
        this.gqV.setOnCompletionListener(this.etA);
        this.gqV.setOnInfoListener(this.etB);
        this.gqV.setOnSurfaceDestroyedListener(this.fMW);
        ap.setViewTextColor(this.mOT, R.color.cp_cont_m);
        this.mOT.setText(StringUtils.translateSecondsToString(this.mOP.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mPd = false;
            ap.setImageResource(this.mOU, R.drawable.icon_vedio_npronunciation_small_white);
            this.mOU.setVisibility(8);
        } else {
            this.mPd = true;
            ap.setImageResource(this.mOV, R.drawable.ad_icon_sound_open);
            this.mOU.setVisibility(8);
        }
        this.mOV.setOnClickListener(this.mOnClickListener);
        this.mOU.setOnClickListener(this.mOnClickListener);
        this.mOW.setOnClickListener(this.mOnClickListener);
        this.mOW.setVisibility(8);
        ap.setBackgroundColor(this.mOW, R.color.black_alpha80);
        ap.setViewTextColor(this.mOX, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mOT.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mOT.setVisibility(8);
        this.mOZ.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mOQ;
        }
        this.mLi = this.mLh.a(this.mHR, this.mLi);
        if (this.mLi != null) {
            this.mLi.setPageContext(this.mPageContext);
            this.mLi.c(this.mPf);
            if (this.mLi instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.mLi).xm(this.mNM);
            }
            this.mLi.setAdvertAppInfo(advertAppInfo);
            this.mLi.a(this.mHR);
            this.mLi.dGo();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mNM = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mLi != null) {
            this.mLi.setDownloadAppCallback(cVar);
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
        this.mPk = i;
        if (this.mOP != null && this.mPb == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mPe) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mLi != null) {
                    this.mLi.dGo();
                }
                this.gqV.setVideoPath(this.mOP.video_url);
                this.gqV.start();
                this.mPi = this.gqV.getCurrentPosition();
                ap.setImageResource(this.mOZ, R.drawable.icon_video_midplay);
                bRi();
                this.mOW.setVisibility(8);
                this.kfp.setForegroundDrawable(0);
                this.mPb = 0;
                if (this.mStyle == 1) {
                    this.mOT.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mOT.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mPp);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.iUL);
                }
                ac(31, JB(this.mPk), 0);
            }
        }
    }

    public void performPlay() {
        JA(2);
    }

    @Override // com.baidu.tieba.recapp.j
    public void autoPlay(int i) {
        if (dGv()) {
            if (i <= 0) {
                JA(1);
                return;
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHY);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mHY, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mPb == 1) {
            L(32, JB(this.mPk), this.gqV.getCurrentPosition(), i);
            this.gqV.pause();
            ai.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mOZ, R.drawable.icon_video_midpause);
            this.mPb = 2;
        }
    }

    public void autoContinue() {
        if (!this.mPg) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mPb == 2) {
            this.mPk = i;
            ac(33, JB(i), this.gqV.getCurrentPosition());
            this.mPi = this.gqV.getCurrentPosition();
            this.gqV.start();
            if (this.mPd) {
                ai.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mOZ, R.drawable.icon_video_midplay);
            this.mPb = 1;
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
    public void bRi() {
        if (this.mOS != null) {
            this.mOS.setAlpha(1.0f);
            this.mOS.setVisibility(0);
            this.mOS.loop(true);
            this.mOS.setMinAndMaxFrame(14, 80);
            this.mOS.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dGw();
        if (z) {
            this.mOS.setAlpha(1.0f);
            this.mOS.setVisibility(0);
            return;
        }
        this.mOS.setVisibility(8);
    }

    private void dGw() {
        if (this.mOS != null) {
            this.mOS.setMinFrame(0);
            this.mOS.setFrame(0);
            this.mOS.cancelAnimation();
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
        if (this.gqV.getCurrentPosition() > 0 && this.mPb != -1 && z) {
            int i = 32;
            int currentPosition = this.gqV.getCurrentPosition();
            if (this.gqV.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, JB(this.mPk), currentPosition, this.gqV.isPlaying());
        }
        dGx();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gqV.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLg.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kfp.getLayoutParams();
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
        this.gqV.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGx() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mHY);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPl);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPo);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gqV.stopPlayback();
        this.mPb = -1;
        ai.a(this.mWeakContext, false);
        xq(false);
        this.kfp.setForegroundDrawable(0);
        this.kfp.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mOZ, R.drawable.icon_video_midpause);
        this.mPa.aSx();
        this.mOW.setVisibility(8);
        if (this.mOP != null) {
            this.mOT.setText(StringUtils.translateSecondsToString(this.mOP.video_duration.intValue()));
            this.mOT.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mPh = false;
        MessageManager.getInstance().unRegisterListener(this.mPp);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.iUL);
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
        return this.mOP != null ? this.mOP.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mLi instanceof com.baidu.tieba.recapp.e.a) && (this.mPf instanceof AdCard) && !((AdCard) this.mPf).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mLi).bMr();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mLi instanceof com.baidu.tieba.recapp.e.a) && (this.mPf instanceof AdCard) && !((AdCard) this.mPf).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mLi).dGm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xo(boolean z) {
        if (z) {
            if (this.gqV != null) {
                this.gqV.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mOV, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mOU, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mPb == 1) {
                ai.a(this.mWeakContext, true);
            }
        } else {
            if (this.gqV != null) {
                this.gqV.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mOV, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mOU, R.drawable.icon_vedio_npronunciation_small_white);
            ai.a(this.mWeakContext, false);
        }
        this.mPd = z;
    }

    @Override // com.baidu.tieba.recapp.j
    public int getPlayStatus() {
        return this.mPb;
    }

    public VideoInfo getData() {
        return this.mOP;
    }

    @Override // com.baidu.tieba.recapp.j
    public long getCurrentPosition() {
        return this.mPc;
    }

    @Override // com.baidu.tieba.recapp.j
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mOQ = advertAppInfo;
        this.mOR = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = g.a(this.mOQ, 303, i, JB(this.mPk), this.mOP.video_duration.intValue(), this.mDuration, -1);
        if (this.mLi != null) {
            this.mLi.e(a2);
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
        if (this.mOQ != null && this.mOP != null) {
            this.mOQ.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dGg().a(g.a(this.mOQ, i, this.mOR, i2, this.mOP.video_duration.intValue(), com.baidu.tieba.ad.a.a.us(i3), i4));
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
                c(str, this.mPi, i3, this.mDuration, str2, JC(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mHQ != null && AdCard.CHARGE_STYLE_CPV.equals(this.mHQ.mIX) && !TextUtils.isEmpty(this.mHQ.mIY)) {
            new com.baidu.tieba.recapp.request.a(this.mHQ.mIY).a(str, i, i2, i3, str2, str3);
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
            this.mON = view;
            this.mOO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPl);
            if (this.cbQ != null) {
                this.cbQ.cancel();
            }
            this.mOY.setVisibility(0);
            if (this.mPb == 1) {
                ap.setImageResource(this.mOZ, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mOZ, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mOY.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGy() {
        switch (this.mPb) {
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
                this.mPg = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xp(true);
                    return;
                }
                return;
            case 2:
                this.mPg = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPl);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.mPl, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGz() {
        if (!this.ejA && this.cbQ != null) {
            this.mOY.startAnimation(this.cbQ);
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
                    DistributeVideoView.this.mOY.setVisibility(8);
                    DistributeVideoView.this.ejA = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dGA() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mPo);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mPo, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(boolean z) {
        if (this.mOU != null && this.mStyle == 1) {
            if (z) {
                this.mOU.setVisibility(0);
                dGA();
                return;
            }
            this.mOU.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
