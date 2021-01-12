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
/* loaded from: classes7.dex */
public class DistributeVideoView extends RelativeLayout implements j {
    private Animation cdO;
    boolean enQ;
    private CyberPlayerManager.OnPreparedListener eyt;
    private CyberPlayerManager.OnErrorListener eyu;
    private CyberPlayerManager.OnCompletionListener eyv;
    private CyberPlayerManager.OnInfoListener eyw;
    private TbCyberVideoView.a fRT;
    private TbCyberVideoView gxn;
    private CustomMessageListener jcq;
    private ForeDrawableImageView knW;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private Runnable mIF;
    private AdCard.f mIz;
    private ViewGroup mLI;
    private d mLJ;
    private e mLK;
    private View mMaskView;
    private boolean mOn;
    private View.OnClickListener mOnClickListener;
    private View mPA;
    private TextView mPB;
    private View mPC;
    private ImageView mPD;
    private VideoControllerView mPE;
    private int mPF;
    private long mPG;
    private boolean mPH;
    private long mPI;
    private b mPJ;
    boolean mPK;
    private boolean mPL;
    private int mPM;
    boolean mPN;
    private int mPO;
    private Runnable mPP;
    private Runnable mPQ;
    private CustomMessageListener mPR;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private View mPq;
    private boolean mPr;
    private VideoInfo mPs;
    private AdCard.a mPt;
    private AdvertAppInfo mPu;
    private int mPv;
    private TBLottieAnimationView mPw;
    private TextView mPx;
    private ImageView mPy;
    private ImageView mPz;
    private View mRootView;
    private String mScheme;
    private int mStyle;
    private WeakReference<Context> mWeakContext;

    private void dBy() {
        int i;
        String str = this.mPu != null ? this.mPu.eJk : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null) {
            if (s.b(this.mPu, str)) {
                i = 3;
            } else {
                i = s.a(this.mContext, str, this.mPu);
            }
            if (i == 1) {
                ae(706, 1, 0);
            }
        }
    }

    public void jump2DownloadDetailPage() {
        dBy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCs() {
        ae(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dyx() {
        if (this.mPw != null) {
            this.mPw.clearAnimation();
            this.mPw.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mPw.setVisibility(8);
                    DistributeVideoView.this.knW.setVisibility(8);
                    DistributeVideoView.this.xl(DistributeVideoView.this.mPH);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mPx.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mPE.setPlayer(DistributeVideoView.this.gxn);
                        DistributeVideoView.this.mPE.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mPs.video_duration.intValue()));
                        DistributeVideoView.this.mPE.showProgress();
                        DistributeVideoView.this.xm(true);
                        com.baidu.adp.lib.f.e.mB().removeCallbacks(DistributeVideoView.this.mPP);
                        com.baidu.adp.lib.f.e.mB().postDelayed(DistributeVideoView.this.mPP, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mPG = DistributeVideoView.this.gxn.getCurrentPosition();
                    DistributeVideoView.this.xn(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mPw.setMinFrame(0);
                    DistributeVideoView.this.mPw.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mPr = false;
        this.mWeakContext = null;
        this.mPF = -1;
        this.mPG = 0L;
        this.mPH = false;
        this.mPI = 0L;
        this.mStyle = 1;
        this.enQ = false;
        this.mPK = false;
        this.mPL = false;
        this.mPN = false;
        this.mPO = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mPA) {
                    DistributeVideoView.this.mPA.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mPz || view == DistributeVideoView.this.mPy) {
                    DistributeVideoView.this.xl(!DistributeVideoView.this.mPH);
                } else if (view == DistributeVideoView.this.mPw || view == DistributeVideoView.this.mPD) {
                    DistributeVideoView.this.dCw();
                } else if (!(DistributeVideoView.this.mPJ instanceof AdCard)) {
                    DistributeVideoView.this.dCw();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dCs();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mPF != 1) {
                            if (DistributeVideoView.this.gxn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mPF = 1;
                                DistributeVideoView.this.dyx();
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
                        if (DistributeVideoView.this.mPF == 1) {
                            if (DistributeVideoView.this.mPG == DistributeVideoView.this.gxn.getCurrentPosition()) {
                                DistributeVideoView.this.bPP();
                            } else {
                                DistributeVideoView.this.mPG = DistributeVideoView.this.gxn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.mPM = DistributeVideoView.this.gxn.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gxn.getDuration();
                    DistributeVideoView.this.gxn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPH && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xl(false);
                    }
                }
            }
        };
        this.eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mPu != null) {
                    if (DistributeVideoView.this.mPN && "DETAIL".equals(DistributeVideoView.this.mPu.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), 0);
                }
                return false;
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dCv();
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.ae(36, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), DistributeVideoView.this.gxn.getCurrentPosition());
                }
                DistributeVideoView.this.knW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mPA.setVisibility(0);
                return true;
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPI = System.currentTimeMillis();
                DistributeVideoView.this.mPN = true;
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.ae(34, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), DistributeVideoView.this.gxn.getDuration());
                }
                DistributeVideoView.this.dCv();
                if (DistributeVideoView.this.mLK != null) {
                    DistributeVideoView.this.mLK.dCl();
                    DistributeVideoView.this.mPx.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mIF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mPs != null && DistributeVideoView.this.gxn != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HN(1);
                }
            }
        };
        this.mPP = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dCx();
            }
        };
        this.mPQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xn(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mPL) {
                            DistributeVideoView.this.xl(true);
                            return;
                        } else {
                            DistributeVideoView.this.xl(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPL = DistributeVideoView.this.mPH;
                    DistributeVideoView.this.xl(true);
                }
            }
        };
        this.jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xl(true);
                    }
                }
            }
        };
        this.mPR = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xn(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPr = false;
        this.mWeakContext = null;
        this.mPF = -1;
        this.mPG = 0L;
        this.mPH = false;
        this.mPI = 0L;
        this.mStyle = 1;
        this.enQ = false;
        this.mPK = false;
        this.mPL = false;
        this.mPN = false;
        this.mPO = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mPA) {
                    DistributeVideoView.this.mPA.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mPz || view == DistributeVideoView.this.mPy) {
                    DistributeVideoView.this.xl(!DistributeVideoView.this.mPH);
                } else if (view == DistributeVideoView.this.mPw || view == DistributeVideoView.this.mPD) {
                    DistributeVideoView.this.dCw();
                } else if (!(DistributeVideoView.this.mPJ instanceof AdCard)) {
                    DistributeVideoView.this.dCw();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dCs();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mPF != 1) {
                            if (DistributeVideoView.this.gxn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mPF = 1;
                                DistributeVideoView.this.dyx();
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
                        if (DistributeVideoView.this.mPF == 1) {
                            if (DistributeVideoView.this.mPG == DistributeVideoView.this.gxn.getCurrentPosition()) {
                                DistributeVideoView.this.bPP();
                            } else {
                                DistributeVideoView.this.mPG = DistributeVideoView.this.gxn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.mPM = DistributeVideoView.this.gxn.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gxn.getDuration();
                    DistributeVideoView.this.gxn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPH && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xl(false);
                    }
                }
            }
        };
        this.eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mPu != null) {
                    if (DistributeVideoView.this.mPN && "DETAIL".equals(DistributeVideoView.this.mPu.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), 0);
                }
                return false;
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dCv();
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.ae(36, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), DistributeVideoView.this.gxn.getCurrentPosition());
                }
                DistributeVideoView.this.knW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mPA.setVisibility(0);
                return true;
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPI = System.currentTimeMillis();
                DistributeVideoView.this.mPN = true;
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.ae(34, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), DistributeVideoView.this.gxn.getDuration());
                }
                DistributeVideoView.this.dCv();
                if (DistributeVideoView.this.mLK != null) {
                    DistributeVideoView.this.mLK.dCl();
                    DistributeVideoView.this.mPx.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mIF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mPs != null && DistributeVideoView.this.gxn != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HN(1);
                }
            }
        };
        this.mPP = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dCx();
            }
        };
        this.mPQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xn(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mPL) {
                            DistributeVideoView.this.xl(true);
                            return;
                        } else {
                            DistributeVideoView.this.xl(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPL = DistributeVideoView.this.mPH;
                    DistributeVideoView.this.xl(true);
                }
            }
        };
        this.jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xl(true);
                    }
                }
            }
        };
        this.mPR = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xn(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPr = false;
        this.mWeakContext = null;
        this.mPF = -1;
        this.mPG = 0L;
        this.mPH = false;
        this.mPI = 0L;
        this.mStyle = 1;
        this.enQ = false;
        this.mPK = false;
        this.mPL = false;
        this.mPN = false;
        this.mPO = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mPA) {
                    DistributeVideoView.this.mPA.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mPz || view == DistributeVideoView.this.mPy) {
                    DistributeVideoView.this.xl(!DistributeVideoView.this.mPH);
                } else if (view == DistributeVideoView.this.mPw || view == DistributeVideoView.this.mPD) {
                    DistributeVideoView.this.dCw();
                } else if (!(DistributeVideoView.this.mPJ instanceof AdCard)) {
                    DistributeVideoView.this.dCw();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dCs();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mPF != 1) {
                            if (DistributeVideoView.this.gxn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mPF = 1;
                                DistributeVideoView.this.dyx();
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
                        if (DistributeVideoView.this.mPF == 1) {
                            if (DistributeVideoView.this.mPG == DistributeVideoView.this.gxn.getCurrentPosition()) {
                                DistributeVideoView.this.bPP();
                            } else {
                                DistributeVideoView.this.mPG = DistributeVideoView.this.gxn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eyt = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.mPM = DistributeVideoView.this.gxn.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gxn.getDuration();
                    DistributeVideoView.this.gxn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mPH && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xl(false);
                    }
                }
            }
        };
        this.eyw = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mPu != null) {
                    if (DistributeVideoView.this.mPN && "DETAIL".equals(DistributeVideoView.this.mPu.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), 0);
                }
                return false;
            }
        };
        this.eyu = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dCv();
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.ae(36, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), DistributeVideoView.this.gxn.getCurrentPosition());
                }
                DistributeVideoView.this.knW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mPA.setVisibility(0);
                return true;
            }
        };
        this.eyv = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mPI = System.currentTimeMillis();
                DistributeVideoView.this.mPN = true;
                if (DistributeVideoView.this.gxn != null) {
                    DistributeVideoView.this.ae(34, DistributeVideoView.this.HO(DistributeVideoView.this.mPO), DistributeVideoView.this.gxn.getDuration());
                }
                DistributeVideoView.this.dCv();
                if (DistributeVideoView.this.mLK != null) {
                    DistributeVideoView.this.mLK.dCl();
                    DistributeVideoView.this.mPx.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fRT = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mIF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mPs != null && DistributeVideoView.this.gxn != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HN(1);
                }
            }
        };
        this.mPP = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dCx();
            }
        };
        this.mPQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.xn(false);
            }
        };
        this.mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mPL) {
                            DistributeVideoView.this.xl(true);
                            return;
                        } else {
                            DistributeVideoView.this.xl(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mPL = DistributeVideoView.this.mPH;
                    DistributeVideoView.this.xl(true);
                }
            }
        };
        this.jcq = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.xl(true);
                    }
                }
            }
        };
        this.mPR = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.xn(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mPJ = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gxn = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gxn.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gxn.setNoBussinessStats();
            this.mPw = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.knW = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mPx = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mPA = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mPB = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mPy = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mPC = this.mRootView.findViewById(R.id.distribute_control);
            this.mPD = (ImageView) this.mPC.findViewById(R.id.distribute_play_icon);
            this.mPz = (ImageView) this.mPC.findViewById(R.id.distribute_voice);
            this.mPE = (VideoControllerView) this.mPC.findViewById(R.id.distribute_process);
            this.mLI = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mLJ = new d(context, this.mLI);
            this.mPw.setAnimation(R.raw.lotti_video_loading);
            this.mPw.setMinFrame(0);
            this.mPw.setFrame(0);
            com.baidu.tbadk.a.b.b.m(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dCt() {
        return this.mStyle == 1 ? v.dCt() : com.baidu.adp.lib.util.j.isWifiNet();
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
        this.mPt = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mIz = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mPs = videoInfo;
        this.mDuration = this.mPs.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dCv();
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mPs.video_width.intValue() > 0 ? (this.mPs.video_height.intValue() * equipmentWidth) / this.mPs.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.knW.setDefaultResource(0);
        this.knW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.knW.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnErrorListener(this.eyu);
        this.gxn.setOnCompletionListener(this.eyv);
        this.gxn.setOnInfoListener(this.eyw);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        ao.setViewTextColor(this.mPx, R.color.cp_cont_m);
        this.mPx.setText(StringUtils.translateSecondsToString(this.mPs.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mPH = false;
            ao.setImageResource(this.mPy, R.drawable.icon_vedio_npronunciation_small_white);
            this.mPy.setVisibility(8);
        } else {
            this.mPH = true;
            ao.setImageResource(this.mPz, R.drawable.ad_icon_sound_open);
            this.mPy.setVisibility(8);
        }
        this.mPz.setOnClickListener(this.mOnClickListener);
        this.mPy.setOnClickListener(this.mOnClickListener);
        this.mPA.setOnClickListener(this.mOnClickListener);
        this.mPA.setVisibility(8);
        ao.setBackgroundColor(this.mPA, R.color.black_alpha80);
        ao.setViewTextColor(this.mPB, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mPx.setVisibility(0);
            return;
        }
        this.mPx.setVisibility(8);
        this.mPD.setOnClickListener(this.mOnClickListener);
        this.mPw.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mPs = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dCv();
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.knW.setDefaultResource(0);
        this.knW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.knW.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gxn.setOnPreparedListener(this.eyt);
        this.gxn.setOnErrorListener(this.eyu);
        this.gxn.setOnCompletionListener(this.eyv);
        this.gxn.setOnInfoListener(this.eyw);
        this.gxn.setOnSurfaceDestroyedListener(this.fRT);
        ao.setViewTextColor(this.mPx, R.color.cp_cont_m);
        this.mPx.setText(StringUtils.translateSecondsToString(this.mPs.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mPH = false;
            ao.setImageResource(this.mPy, R.drawable.icon_vedio_npronunciation_small_white);
            this.mPy.setVisibility(8);
        } else {
            this.mPH = true;
            ao.setImageResource(this.mPz, R.drawable.ad_icon_sound_open);
            this.mPy.setVisibility(8);
        }
        this.mPz.setOnClickListener(this.mOnClickListener);
        this.mPy.setOnClickListener(this.mOnClickListener);
        this.mPA.setOnClickListener(this.mOnClickListener);
        this.mPA.setVisibility(8);
        ao.setBackgroundColor(this.mPA, R.color.black_alpha80);
        ao.setViewTextColor(this.mPB, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mPx.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mPx.setVisibility(8);
        this.mPD.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mPu;
        }
        this.mLK = this.mLJ.a(this.mIz, this.mLK);
        if (this.mLK != null) {
            this.mLK.setPageContext(this.mPageContext);
            this.mLK.c(this.mPJ);
            if (this.mLK instanceof a) {
                ((a) this.mLK).xj(this.mOn);
            }
            this.mLK.setAdvertAppInfo(advertAppInfo);
            this.mLK.a(this.mIz);
            this.mLK.dCm();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mOn = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mLK != null) {
            this.mLK.setDownloadAppCallback(cVar);
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
        this.eyv = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN(int i) {
        this.mPO = i;
        if (this.mPs != null && this.mPF == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mPI) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mLK != null) {
                    this.mLK.dCm();
                }
                this.gxn.setVideoPath(this.mPs.video_url);
                this.gxn.start();
                this.mPM = this.gxn.getCurrentPosition();
                ao.setImageResource(this.mPD, R.drawable.icon_video_midplay);
                bPP();
                this.mPA.setVisibility(8);
                this.knW.setForegroundDrawable(0);
                this.mPF = 0;
                if (this.mStyle == 1) {
                    this.mPx.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mPx.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mPR);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.jcq);
                }
                ae(31, HO(this.mPO), 0);
            }
        }
    }

    public void performPlay() {
        HN(2);
    }

    @Override // com.baidu.tieba.recapp.j
    public void autoPlay(int i) {
        if (dCt()) {
            if (i <= 0) {
                HN(1);
                return;
            }
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mIF);
            com.baidu.adp.lib.f.e.mB().postDelayed(this.mIF, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mPF == 1) {
            L(32, HO(this.mPO), this.gxn.getCurrentPosition(), i);
            this.gxn.pause();
            ah.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ao.setImageResource(this.mPD, R.drawable.icon_video_midpause);
            this.mPF = 2;
        }
    }

    public void autoContinue() {
        if (!this.mPK) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mPF == 2) {
            this.mPO = i;
            ae(33, HO(i), this.gxn.getCurrentPosition());
            this.mPM = this.gxn.getCurrentPosition();
            this.gxn.start();
            if (this.mPH) {
                ah.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ao.setImageResource(this.mPD, R.drawable.icon_video_midplay);
            this.mPF = 1;
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
    public void bPP() {
        if (this.mPw != null) {
            this.mPw.setAlpha(1.0f);
            this.mPw.setVisibility(0);
            this.mPw.loop(true);
            this.mPw.setMinAndMaxFrame(14, 80);
            this.mPw.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dCu();
        if (z) {
            this.mPw.setAlpha(1.0f);
            this.mPw.setVisibility(0);
            return;
        }
        this.mPw.setVisibility(8);
    }

    private void dCu() {
        if (this.mPw != null) {
            this.mPw.setMinFrame(0);
            this.mPw.setFrame(0);
            this.mPw.cancelAnimation();
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
        if (this.gxn.getCurrentPosition() > 0 && this.mPF != -1 && z) {
            int i = 32;
            int currentPosition = this.gxn.getCurrentPosition();
            if (this.gxn.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, HO(this.mPO), currentPosition, this.gxn.isPlaying());
        }
        dCv();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gxn.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mLI.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.knW.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int Hy = com.baidu.tieba.recapp.lego.a.a.Hy(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = Hy;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = Hy;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = Hy;
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
        this.gxn.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCv() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mIF);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mPP);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mPQ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gxn.stopPlayback();
        this.mPF = -1;
        ah.a(this.mWeakContext, false);
        xn(false);
        this.knW.setForegroundDrawable(0);
        this.knW.setVisibility(0);
        setLoadingAnimShow(true);
        ao.setImageResource(this.mPD, R.drawable.icon_video_midpause);
        this.mPE.aQY();
        this.mPA.setVisibility(8);
        if (this.mPs != null) {
            this.mPx.setText(StringUtils.translateSecondsToString(this.mPs.video_duration.intValue()));
            this.mPx.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mPL = false;
        MessageManager.getInstance().unRegisterListener(this.mPR);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.jcq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int HO(int i) {
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
        return this.mPs != null ? this.mPs.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mLK instanceof a) && (this.mPJ instanceof AdCard) && !((AdCard) this.mPJ).directDownload) {
            ((a) this.mLK).bKR();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mLK instanceof a) && (this.mPJ instanceof AdCard) && !((AdCard) this.mPJ).directDownload) {
            ((a) this.mLK).dCk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(boolean z) {
        if (z) {
            if (this.gxn != null) {
                this.gxn.setVolume(1.0f, 1.0f);
            }
            ao.setImageResource(this.mPz, R.drawable.ad_icon_sound_open);
            ao.setImageResource(this.mPy, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mPF == 1) {
                ah.a(this.mWeakContext, true);
            }
        } else {
            if (this.gxn != null) {
                this.gxn.setVolume(0.0f, 0.0f);
            }
            ao.setImageResource(this.mPz, R.drawable.ad_icon_sound_close);
            ao.setImageResource(this.mPy, R.drawable.icon_vedio_npronunciation_small_white);
            ah.a(this.mWeakContext, false);
        }
        this.mPH = z;
    }

    @Override // com.baidu.tieba.recapp.j
    public int getPlayStatus() {
        return this.mPF;
    }

    public VideoInfo getData() {
        return this.mPs;
    }

    @Override // com.baidu.tieba.recapp.j
    public long getCurrentPosition() {
        return this.mPG;
    }

    @Override // com.baidu.tieba.recapp.j
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mPu = advertAppInfo;
        this.mPv = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = h.a(this.mPu, 303, i, HO(this.mPO), this.mPs.video_duration.intValue(), this.mDuration, -1);
        if (this.mLK != null) {
            this.mLK.e(a2);
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
        if (this.mPu != null && this.mPs != null) {
            this.mPu.page = this.mPage;
            com.baidu.tieba.recapp.report.e.dCe().a(h.a(this.mPu, i, this.mPv, i2, this.mPs.video_duration.intValue(), com.baidu.tieba.ad.a.a.sX(i3), i4));
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
                c(str, this.mPM, i3, this.mDuration, str2, HP(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mPt != null && AdCard.CHARGE_STYLE_CPV.equals(this.mPt.mJA) && !TextUtils.isEmpty(this.mPt.mJB)) {
            new com.baidu.tieba.recapp.request.a(this.mPt.mJB).a(str, i, i2, i3, str2, str3);
        }
    }

    private String HP(int i) {
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
            this.mPq = view;
            this.mPr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mPP);
            if (this.cdO != null) {
                this.cdO.cancel();
            }
            this.mPC.setVisibility(0);
            if (this.mPF == 1) {
                ao.setImageResource(this.mPD, R.drawable.icon_video_midplay);
                return;
            } else {
                ao.setImageResource(this.mPD, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mPC.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCw() {
        switch (this.mPF) {
            case -1:
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!com.baidu.adp.lib.util.j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.nu(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bqe();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mPK = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xm(true);
                    return;
                }
                return;
            case 2:
                this.mPK = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mPP);
                    com.baidu.adp.lib.f.e.mB().postDelayed(this.mPP, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dCx() {
        if (!this.enQ && this.cdO != null) {
            this.mPC.startAnimation(this.cdO);
            this.enQ = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.cdO = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.cdO.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mPC.setVisibility(8);
                    DistributeVideoView.this.enQ = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dCy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.mPQ);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.mPQ, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xn(boolean z) {
        if (this.mPy != null && this.mStyle == 1) {
            if (z) {
                this.mPy.setVisibility(0);
                dCy();
                return;
            }
            this.mPy.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.j
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
