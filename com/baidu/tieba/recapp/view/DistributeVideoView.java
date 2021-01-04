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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.ah;
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
    private Animation ciB;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnErrorListener eDg;
    private CyberPlayerManager.OnCompletionListener eDh;
    private CyberPlayerManager.OnInfoListener eDi;
    boolean esE;
    private TbCyberVideoView.a fWA;
    private TbCyberVideoView gBU;
    private CustomMessageListener jgX;
    private ForeDrawableImageView ksB;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private View mMaskView;
    private AdCard.f mNg;
    private Runnable mNl;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private ViewGroup mQp;
    private d mQq;
    private e mQr;
    private View mRootView;
    private boolean mSW;
    private String mScheme;
    private int mStyle;
    private View mTZ;
    private Runnable mUA;
    private Runnable mUB;
    private CustomMessageListener mUC;
    private boolean mUb;
    private VideoInfo mUc;
    private AdCard.a mUd;
    private AdvertAppInfo mUe;
    private int mUf;
    private TBLottieAnimationView mUg;
    private TextView mUh;
    private ImageView mUi;
    private ImageView mUj;
    private View mUl;
    private TextView mUm;
    private View mUn;
    private ImageView mUo;
    private VideoControllerView mUp;
    private int mUq;
    private long mUr;
    private boolean mUs;
    private long mUt;
    private b mUu;
    boolean mUv;
    private boolean mUw;
    private int mUx;
    boolean mUy;
    private int mUz;
    private WeakReference<Context> mWeakContext;

    private void dFp() {
        int i;
        String str = this.mUe != null ? this.mUe.eNV : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            if (s.b(this.mUe, str)) {
                i = 3;
            } else {
                i = s.a(this.mContext, str, this.mUe);
            }
            if (i == 1) {
                ae(706, 1, 0);
            }
        }
    }

    public void jump2DownloadDetailPage() {
        dFp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGj() {
        ae(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCo() {
        if (this.mUg != null) {
            this.mUg.clearAnimation();
            this.mUg.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mUg.setVisibility(8);
                    DistributeVideoView.this.ksB.setVisibility(8);
                    DistributeVideoView.this.xp(DistributeVideoView.this.mUs);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mUh.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mUp.setPlayer(DistributeVideoView.this.gBU);
                        DistributeVideoView.this.mUp.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mUc.video_duration.intValue()));
                        DistributeVideoView.this.mUp.showProgress();
                        DistributeVideoView.this.xq(true);
                        com.baidu.adp.lib.f.e.mB().removeCallbacks(DistributeVideoView.this.mUA);
                        com.baidu.adp.lib.f.e.mB().postDelayed(DistributeVideoView.this.mUA, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mUr = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.xr(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mUg.setMinFrame(0);
                    DistributeVideoView.this.mUg.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mUb = false;
        this.mWeakContext = null;
        this.mUq = -1;
        this.mUr = 0L;
        this.mUs = false;
        this.mUt = 0L;
        this.mStyle = 1;
        this.esE = false;
        this.mUv = false;
        this.mUw = false;
        this.mUy = false;
        this.mUz = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mUl) {
                    DistributeVideoView.this.mUl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mUj || view == DistributeVideoView.this.mUi) {
                    DistributeVideoView.this.xp(!DistributeVideoView.this.mUs);
                } else if (view == DistributeVideoView.this.mUg || view == DistributeVideoView.this.mUo) {
                    DistributeVideoView.this.dGn();
                } else if (!(DistributeVideoView.this.mUu instanceof AdCard)) {
                    DistributeVideoView.this.dGn();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mUq != 1) {
                            if (DistributeVideoView.this.gBU.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mUq = 1;
                                DistributeVideoView.this.dCo();
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
                        if (DistributeVideoView.this.mUq == 1) {
                            if (DistributeVideoView.this.mUr == DistributeVideoView.this.gBU.getCurrentPosition()) {
                                DistributeVideoView.this.bTG();
                            } else {
                                DistributeVideoView.this.mUr = DistributeVideoView.this.gBU.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.mUx = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gBU.getDuration();
                    DistributeVideoView.this.gBU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mUs && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xp(false);
                    }
                }
            }
        };
        this.eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mUe != null) {
                    if (DistributeVideoView.this.mUy && "DETAIL".equals(DistributeVideoView.this.mUe.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), 0);
                }
                return false;
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dGm();
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ae(36, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), DistributeVideoView.this.gBU.getCurrentPosition());
                }
                DistributeVideoView.this.ksB.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mUl.setVisibility(0);
                return true;
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mUt = System.currentTimeMillis();
                DistributeVideoView.this.mUy = true;
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ae(34, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), DistributeVideoView.this.gBU.getDuration());
                }
                DistributeVideoView.this.dGm();
                if (DistributeVideoView.this.mQr != null) {
                    DistributeVideoView.this.mQr.dGc();
                    DistributeVideoView.this.mUh.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mNl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mUc != null && DistributeVideoView.this.gBU != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ju(1);
                }
            }
        };
        this.mUA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGo();
            }
        };
        this.mUB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xr(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mUw) {
                            DistributeVideoView.this.xp(true);
                            return;
                        } else {
                            DistributeVideoView.this.xp(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mUw = DistributeVideoView.this.mUs;
                    DistributeVideoView.this.xp(true);
                }
            }
        };
        this.jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xp(true);
                    }
                }
            }
        };
        this.mUC = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xr(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mUb = false;
        this.mWeakContext = null;
        this.mUq = -1;
        this.mUr = 0L;
        this.mUs = false;
        this.mUt = 0L;
        this.mStyle = 1;
        this.esE = false;
        this.mUv = false;
        this.mUw = false;
        this.mUy = false;
        this.mUz = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mUl) {
                    DistributeVideoView.this.mUl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mUj || view == DistributeVideoView.this.mUi) {
                    DistributeVideoView.this.xp(!DistributeVideoView.this.mUs);
                } else if (view == DistributeVideoView.this.mUg || view == DistributeVideoView.this.mUo) {
                    DistributeVideoView.this.dGn();
                } else if (!(DistributeVideoView.this.mUu instanceof AdCard)) {
                    DistributeVideoView.this.dGn();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mUq != 1) {
                            if (DistributeVideoView.this.gBU.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mUq = 1;
                                DistributeVideoView.this.dCo();
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
                        if (DistributeVideoView.this.mUq == 1) {
                            if (DistributeVideoView.this.mUr == DistributeVideoView.this.gBU.getCurrentPosition()) {
                                DistributeVideoView.this.bTG();
                            } else {
                                DistributeVideoView.this.mUr = DistributeVideoView.this.gBU.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.mUx = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gBU.getDuration();
                    DistributeVideoView.this.gBU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mUs && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xp(false);
                    }
                }
            }
        };
        this.eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mUe != null) {
                    if (DistributeVideoView.this.mUy && "DETAIL".equals(DistributeVideoView.this.mUe.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), 0);
                }
                return false;
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dGm();
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ae(36, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), DistributeVideoView.this.gBU.getCurrentPosition());
                }
                DistributeVideoView.this.ksB.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mUl.setVisibility(0);
                return true;
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mUt = System.currentTimeMillis();
                DistributeVideoView.this.mUy = true;
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ae(34, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), DistributeVideoView.this.gBU.getDuration());
                }
                DistributeVideoView.this.dGm();
                if (DistributeVideoView.this.mQr != null) {
                    DistributeVideoView.this.mQr.dGc();
                    DistributeVideoView.this.mUh.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mNl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mUc != null && DistributeVideoView.this.gBU != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ju(1);
                }
            }
        };
        this.mUA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGo();
            }
        };
        this.mUB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xr(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mUw) {
                            DistributeVideoView.this.xp(true);
                            return;
                        } else {
                            DistributeVideoView.this.xp(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mUw = DistributeVideoView.this.mUs;
                    DistributeVideoView.this.xp(true);
                }
            }
        };
        this.jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xp(true);
                    }
                }
            }
        };
        this.mUC = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xr(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mUb = false;
        this.mWeakContext = null;
        this.mUq = -1;
        this.mUr = 0L;
        this.mUs = false;
        this.mUt = 0L;
        this.mStyle = 1;
        this.esE = false;
        this.mUv = false;
        this.mUw = false;
        this.mUy = false;
        this.mUz = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mUl) {
                    DistributeVideoView.this.mUl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mUj || view == DistributeVideoView.this.mUi) {
                    DistributeVideoView.this.xp(!DistributeVideoView.this.mUs);
                } else if (view == DistributeVideoView.this.mUg || view == DistributeVideoView.this.mUo) {
                    DistributeVideoView.this.dGn();
                } else if (!(DistributeVideoView.this.mUu instanceof AdCard)) {
                    DistributeVideoView.this.dGn();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dGj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mUq != 1) {
                            if (DistributeVideoView.this.gBU.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mUq = 1;
                                DistributeVideoView.this.dCo();
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
                        if (DistributeVideoView.this.mUq == 1) {
                            if (DistributeVideoView.this.mUr == DistributeVideoView.this.gBU.getCurrentPosition()) {
                                DistributeVideoView.this.bTG();
                            } else {
                                DistributeVideoView.this.mUr = DistributeVideoView.this.gBU.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.mUx = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gBU.getDuration();
                    DistributeVideoView.this.gBU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mUs && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xp(false);
                    }
                }
            }
        };
        this.eDi = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mUe != null) {
                    if (DistributeVideoView.this.mUy && "DETAIL".equals(DistributeVideoView.this.mUe.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), 0);
                }
                return false;
            }
        };
        this.eDg = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dGm();
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ae(36, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), DistributeVideoView.this.gBU.getCurrentPosition());
                }
                DistributeVideoView.this.ksB.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mUl.setVisibility(0);
                return true;
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mUt = System.currentTimeMillis();
                DistributeVideoView.this.mUy = true;
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ae(34, DistributeVideoView.this.Jv(DistributeVideoView.this.mUz), DistributeVideoView.this.gBU.getDuration());
                }
                DistributeVideoView.this.dGm();
                if (DistributeVideoView.this.mQr != null) {
                    DistributeVideoView.this.mQr.dGc();
                    DistributeVideoView.this.mUh.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mNl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mUc != null && DistributeVideoView.this.gBU != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ju(1);
                }
            }
        };
        this.mUA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dGo();
            }
        };
        this.mUB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xr(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mUw) {
                            DistributeVideoView.this.xp(true);
                            return;
                        } else {
                            DistributeVideoView.this.xp(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mUw = DistributeVideoView.this.mUs;
                    DistributeVideoView.this.xp(true);
                }
            }
        };
        this.jgX = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xp(true);
                    }
                }
            }
        };
        this.mUC = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xr(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mUu = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gBU = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gBU.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gBU.setNoBussinessStats();
            this.mUg = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.ksB = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mUh = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mUl = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mUm = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mUi = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mUn = this.mRootView.findViewById(R.id.distribute_control);
            this.mUo = (ImageView) this.mUn.findViewById(R.id.distribute_play_icon);
            this.mUj = (ImageView) this.mUn.findViewById(R.id.distribute_voice);
            this.mUp = (VideoControllerView) this.mUn.findViewById(R.id.distribute_process);
            this.mQp = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mQq = new d(context, this.mQp);
            this.mUg.setAnimation(R.raw.lotti_video_loading);
            this.mUg.setMinFrame(0);
            this.mUg.setFrame(0);
            com.baidu.tbadk.a.b.b.m(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dGk() {
        return this.mStyle == 1 ? v.dGk() : com.baidu.adp.lib.util.j.isWifiNet();
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
        this.mUd = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mNg = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mUc = videoInfo;
        this.mDuration = this.mUc.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dGm();
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mUc.video_width.intValue() > 0 ? (this.mUc.video_height.intValue() * equipmentWidth) / this.mUc.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.ksB.setDefaultResource(0);
        this.ksB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.ksB.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnErrorListener(this.eDg);
        this.gBU.setOnCompletionListener(this.eDh);
        this.gBU.setOnInfoListener(this.eDi);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        ao.setViewTextColor(this.mUh, R.color.cp_cont_m);
        this.mUh.setText(StringUtils.translateSecondsToString(this.mUc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mUs = false;
            ao.setImageResource(this.mUi, R.drawable.icon_vedio_npronunciation_small_white);
            this.mUi.setVisibility(8);
        } else {
            this.mUs = true;
            ao.setImageResource(this.mUj, R.drawable.ad_icon_sound_open);
            this.mUi.setVisibility(8);
        }
        this.mUj.setOnClickListener(this.mOnClickListener);
        this.mUi.setOnClickListener(this.mOnClickListener);
        this.mUl.setOnClickListener(this.mOnClickListener);
        this.mUl.setVisibility(8);
        ao.setBackgroundColor(this.mUl, R.color.black_alpha80);
        ao.setViewTextColor(this.mUm, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mUh.setVisibility(0);
            return;
        }
        this.mUh.setVisibility(8);
        this.mUo.setOnClickListener(this.mOnClickListener);
        this.mUg.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mUc = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dGm();
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.ksB.setDefaultResource(0);
        this.ksB.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.ksB.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnErrorListener(this.eDg);
        this.gBU.setOnCompletionListener(this.eDh);
        this.gBU.setOnInfoListener(this.eDi);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        ao.setViewTextColor(this.mUh, R.color.cp_cont_m);
        this.mUh.setText(StringUtils.translateSecondsToString(this.mUc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mUs = false;
            ao.setImageResource(this.mUi, R.drawable.icon_vedio_npronunciation_small_white);
            this.mUi.setVisibility(8);
        } else {
            this.mUs = true;
            ao.setImageResource(this.mUj, R.drawable.ad_icon_sound_open);
            this.mUi.setVisibility(8);
        }
        this.mUj.setOnClickListener(this.mOnClickListener);
        this.mUi.setOnClickListener(this.mOnClickListener);
        this.mUl.setOnClickListener(this.mOnClickListener);
        this.mUl.setVisibility(8);
        ao.setBackgroundColor(this.mUl, R.color.black_alpha80);
        ao.setViewTextColor(this.mUm, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mUh.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mUh.setVisibility(8);
        this.mUo.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mUe;
        }
        this.mQr = this.mQq.a(this.mNg, this.mQr);
        if (this.mQr != null) {
            this.mQr.setPageContext(this.mPageContext);
            this.mQr.c(this.mUu);
            if (this.mQr instanceof a) {
                ((a) this.mQr).xn(this.mSW);
            }
            this.mQr.setAdvertAppInfo(advertAppInfo);
            this.mQr.a(this.mNg);
            this.mQr.dGd();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mSW = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mQr != null) {
            this.mQr.setDownloadAppCallback(cVar);
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
        this.eDh = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ju(int i) {
        this.mUz = i;
        if (this.mUc != null && this.mUq == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mUt) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mQr != null) {
                    this.mQr.dGd();
                }
                this.gBU.setVideoPath(this.mUc.video_url);
                this.gBU.start();
                this.mUx = this.gBU.getCurrentPosition();
                ao.setImageResource(this.mUo, R.drawable.icon_video_midplay);
                bTG();
                this.mUl.setVisibility(8);
                this.ksB.setForegroundDrawable(0);
                this.mUq = 0;
                if (this.mStyle == 1) {
                    this.mUh.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mUh.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mUC);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.jgX);
                }
                ae(31, Jv(this.mUz), 0);
            }
        }
    }

    public void performPlay() {
        Ju(2);
    }

    @Override // com.baidu.tieba.recapp.j
    public void autoPlay(int i) {
        if (dGk()) {
            if (i <= 0) {
                Ju(1);
                return;
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mNl);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.mNl, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mUq == 1) {
            L(32, Jv(this.mUz), this.gBU.getCurrentPosition(), i);
            this.gBU.pause();
            ah.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ao.setImageResource(this.mUo, R.drawable.icon_video_midpause);
            this.mUq = 2;
        }
    }

    public void autoContinue() {
        if (!this.mUv) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mUq == 2) {
            this.mUz = i;
            ae(33, Jv(i), this.gBU.getCurrentPosition());
            this.mUx = this.gBU.getCurrentPosition();
            this.gBU.start();
            if (this.mUs) {
                ah.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ao.setImageResource(this.mUo, R.drawable.icon_video_midplay);
            this.mUq = 1;
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
    public void bTG() {
        if (this.mUg != null) {
            this.mUg.setAlpha(1.0f);
            this.mUg.setVisibility(0);
            this.mUg.loop(true);
            this.mUg.setMinAndMaxFrame(14, 80);
            this.mUg.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dGl();
        if (z) {
            this.mUg.setAlpha(1.0f);
            this.mUg.setVisibility(0);
            return;
        }
        this.mUg.setVisibility(8);
    }

    private void dGl() {
        if (this.mUg != null) {
            this.mUg.setMinFrame(0);
            this.mUg.setFrame(0);
            this.mUg.cancelAnimation();
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
        if (this.gBU.getCurrentPosition() > 0 && this.mUq != -1 && z) {
            int i = 32;
            int currentPosition = this.gBU.getCurrentPosition();
            if (this.gBU.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, Jv(this.mUz), currentPosition, this.gBU.isPlaying());
        }
        dGm();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gBU.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mQp.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ksB.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int Jf = com.baidu.tieba.recapp.lego.a.a.Jf(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = Jf;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = Jf;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = Jf;
            layoutParams4.height = equipmentWidth;
            ao.setBackgroundColor(this, R.color.black_alpha100);
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        }
        this.gBU.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGm() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mNl);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mUA);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mUB);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gBU.stopPlayback();
        this.mUq = -1;
        ah.a(this.mWeakContext, false);
        xr(false);
        this.ksB.setForegroundDrawable(0);
        this.ksB.setVisibility(0);
        setLoadingAnimShow(true);
        ao.setImageResource(this.mUo, R.drawable.icon_video_midpause);
        this.mUp.aUR();
        this.mUl.setVisibility(8);
        if (this.mUc != null) {
            this.mUh.setText(StringUtils.translateSecondsToString(this.mUc.video_duration.intValue()));
            this.mUh.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mUw = false;
        MessageManager.getInstance().unRegisterListener(this.mUC);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.jgX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Jv(int i) {
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
        return this.mUc != null ? this.mUc.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mQr instanceof a) && (this.mUu instanceof AdCard) && !((AdCard) this.mUu).directDownload) {
            ((a) this.mQr).bOI();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mQr instanceof a) && (this.mUu instanceof AdCard) && !((AdCard) this.mUu).directDownload) {
            ((a) this.mQr).dGb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xp(boolean z) {
        if (z) {
            if (this.gBU != null) {
                this.gBU.setVolume(1.0f, 1.0f);
            }
            ao.setImageResource(this.mUj, R.drawable.ad_icon_sound_open);
            ao.setImageResource(this.mUi, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mUq == 1) {
                ah.a(this.mWeakContext, true);
            }
        } else {
            if (this.gBU != null) {
                this.gBU.setVolume(0.0f, 0.0f);
            }
            ao.setImageResource(this.mUj, R.drawable.ad_icon_sound_close);
            ao.setImageResource(this.mUi, R.drawable.icon_vedio_npronunciation_small_white);
            ah.a(this.mWeakContext, false);
        }
        this.mUs = z;
    }

    @Override // com.baidu.tieba.recapp.j
    public int getPlayStatus() {
        return this.mUq;
    }

    public VideoInfo getData() {
        return this.mUc;
    }

    @Override // com.baidu.tieba.recapp.j
    public long getCurrentPosition() {
        return this.mUr;
    }

    @Override // com.baidu.tieba.recapp.j
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mUe = advertAppInfo;
        this.mUf = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = h.a(this.mUe, 303, i, Jv(this.mUz), this.mUc.video_duration.intValue(), this.mDuration, -1);
        if (this.mQr != null) {
            this.mQr.e(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, int i2, int i3) {
        L(i, i2, i3, -1);
    }

    private void e(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void L(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.mUe != null && this.mUc != null) {
            this.mUe.page = this.mPage;
            com.baidu.tieba.recapp.report.e.dFV().a(h.a(this.mUe, i, this.mUf, i2, this.mUc.video_duration.intValue(), com.baidu.tieba.ad.a.a.uD(i3), i4));
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
                c(str, this.mUx, i3, this.mDuration, str2, Jw(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mUd != null && AdCard.CHARGE_STYLE_CPV.equals(this.mUd.mOf) && !TextUtils.isEmpty(this.mUd.mOg)) {
            new com.baidu.tieba.recapp.request.a(this.mUd.mOg).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Jw(int i) {
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
            this.mTZ = view;
            this.mUb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xq(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mUA);
            if (this.ciB != null) {
                this.ciB.cancel();
            }
            this.mUn.setVisibility(0);
            if (this.mUq == 1) {
                ao.setImageResource(this.mUo, R.drawable.icon_video_midplay);
                return;
            } else {
                ao.setImageResource(this.mUo, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mUn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGn() {
        switch (this.mUq) {
            case -1:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!com.baidu.adp.lib.util.j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.pa(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).btX();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mUv = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xq(true);
                    return;
                }
                return;
            case 2:
                this.mUv = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mUA);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.mUA, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dGo() {
        if (!this.esE && this.ciB != null) {
            this.mUn.startAnimation(this.ciB);
            this.esE = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.ciB = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.ciB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mUn.setVisibility(8);
                    DistributeVideoView.this.esE = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dGp() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mUB);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mUB, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(boolean z) {
        if (this.mUi != null && this.mStyle == 1) {
            if (z) {
                this.mUi.setVisibility(0);
                dGp();
                return;
            }
            this.mUi.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
