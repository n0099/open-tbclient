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
/* loaded from: classes26.dex */
public class DistributeVideoView extends RelativeLayout implements h {
    private WeakReference<Context> alO;
    private Animation bKg;
    boolean dPT;
    private CyberPlayerManager.OnPreparedListener dZP;
    private CyberPlayerManager.OnErrorListener dZQ;
    private CyberPlayerManager.OnCompletionListener dZR;
    private CyberPlayerManager.OnInfoListener dZS;
    private TbCyberVideoView fTk;
    private TbCyberVideoView.a frv;
    private CustomMessageListener iqK;
    private ForeDrawableImageView jyD;
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
    private AdCard.a maV;
    private AdCard.f maW;
    private ViewGroup mei;
    private d mej;
    private e mek;
    private boolean mgz;
    private boolean mhA;
    private VideoInfo mhB;
    private AdvertAppInfo mhC;
    private int mhD;
    private TBLottieAnimationView mhE;
    private TextView mhF;
    private ImageView mhG;
    private ImageView mhH;
    private View mhI;
    private TextView mhJ;
    private View mhK;
    private ImageView mhL;
    private VideoControllerView mhM;
    private int mhN;
    private long mhO;
    private boolean mhP;
    private long mhQ;
    private b mhR;
    boolean mhS;
    private boolean mhT;
    private int mhU;
    boolean mhV;
    private int mhW;
    private Runnable mhX;
    private Runnable mhY;
    private Runnable mhZ;
    private View mhz;
    private CustomMessageListener mia;
    private CustomMessageListener mib;

    private void dvc() {
        String str = this.mhC != null ? this.mhC.ekx : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.mhC) == 1) {
            aa(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dvc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvU() {
        aa(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drX() {
        if (this.mhE != null) {
            this.mhE.clearAnimation();
            this.mhE.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mhE.setVisibility(8);
                    DistributeVideoView.this.jyD.setVisibility(8);
                    DistributeVideoView.this.wh(DistributeVideoView.this.mhP);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mhF.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mhM.setPlayer(DistributeVideoView.this.fTk);
                        DistributeVideoView.this.mhM.by(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mhB.video_duration.intValue()));
                        DistributeVideoView.this.mhM.showProgress();
                        DistributeVideoView.this.wi(true);
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(DistributeVideoView.this.mhY);
                        com.baidu.adp.lib.f.e.mY().postDelayed(DistributeVideoView.this.mhY, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mhO = DistributeVideoView.this.fTk.getCurrentPosition();
                    DistributeVideoView.this.wj(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mhE.setMinFrame(0);
                    DistributeVideoView.this.mhE.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mhA = false;
        this.alO = null;
        this.mhN = -1;
        this.mhO = 0L;
        this.mhP = false;
        this.mhQ = 0L;
        this.mStyle = 1;
        this.dPT = false;
        this.mhS = false;
        this.mhT = false;
        this.mhV = false;
        this.mhW = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mhI) {
                    DistributeVideoView.this.mhI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mhH || view == DistributeVideoView.this.mhG) {
                    DistributeVideoView.this.wh(!DistributeVideoView.this.mhP);
                } else if (view == DistributeVideoView.this.mhE || view == DistributeVideoView.this.mhL) {
                    DistributeVideoView.this.dvY();
                } else if (!(DistributeVideoView.this.mhR instanceof AdCard)) {
                    DistributeVideoView.this.dvY();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dvU();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mhN != 1) {
                            if (DistributeVideoView.this.fTk.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mhN = 1;
                                DistributeVideoView.this.drX();
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
                        if (DistributeVideoView.this.mhN == 1) {
                            if (DistributeVideoView.this.mhO == DistributeVideoView.this.fTk.getCurrentPosition()) {
                                DistributeVideoView.this.bJe();
                            } else {
                                DistributeVideoView.this.mhO = DistributeVideoView.this.fTk.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.mhU = DistributeVideoView.this.fTk.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fTk.getDuration();
                    DistributeVideoView.this.fTk.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mhP && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wh(false);
                    }
                }
            }
        };
        this.dZS = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mhC != null) {
                    if (DistributeVideoView.this.mhV && "DETAIL".equals(DistributeVideoView.this.mhC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.aa(i3, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), 0);
                }
                return false;
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dvX();
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.aa(36, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), DistributeVideoView.this.fTk.getCurrentPosition());
                }
                DistributeVideoView.this.jyD.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mhI.setVisibility(0);
                return true;
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mhQ = System.currentTimeMillis();
                DistributeVideoView.this.mhV = true;
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.aa(34, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), DistributeVideoView.this.fTk.getDuration());
                }
                DistributeVideoView.this.dvX();
                if (DistributeVideoView.this.mek != null) {
                    DistributeVideoView.this.mek.dvN();
                    DistributeVideoView.this.mhF.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mhX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mhB != null && DistributeVideoView.this.fTk != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HC(1);
                }
            }
        };
        this.mhY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dvZ();
            }
        };
        this.mhZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wj(false);
            }
        };
        this.mia = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mhT) {
                            DistributeVideoView.this.wh(true);
                            return;
                        } else {
                            DistributeVideoView.this.wh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mhT = DistributeVideoView.this.mhP;
                    DistributeVideoView.this.wh(true);
                }
            }
        };
        this.iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wh(true);
                    }
                }
            }
        };
        this.mib = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wj(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mhA = false;
        this.alO = null;
        this.mhN = -1;
        this.mhO = 0L;
        this.mhP = false;
        this.mhQ = 0L;
        this.mStyle = 1;
        this.dPT = false;
        this.mhS = false;
        this.mhT = false;
        this.mhV = false;
        this.mhW = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mhI) {
                    DistributeVideoView.this.mhI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mhH || view == DistributeVideoView.this.mhG) {
                    DistributeVideoView.this.wh(!DistributeVideoView.this.mhP);
                } else if (view == DistributeVideoView.this.mhE || view == DistributeVideoView.this.mhL) {
                    DistributeVideoView.this.dvY();
                } else if (!(DistributeVideoView.this.mhR instanceof AdCard)) {
                    DistributeVideoView.this.dvY();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dvU();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mhN != 1) {
                            if (DistributeVideoView.this.fTk.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mhN = 1;
                                DistributeVideoView.this.drX();
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
                        if (DistributeVideoView.this.mhN == 1) {
                            if (DistributeVideoView.this.mhO == DistributeVideoView.this.fTk.getCurrentPosition()) {
                                DistributeVideoView.this.bJe();
                            } else {
                                DistributeVideoView.this.mhO = DistributeVideoView.this.fTk.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.mhU = DistributeVideoView.this.fTk.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fTk.getDuration();
                    DistributeVideoView.this.fTk.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mhP && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wh(false);
                    }
                }
            }
        };
        this.dZS = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mhC != null) {
                    if (DistributeVideoView.this.mhV && "DETAIL".equals(DistributeVideoView.this.mhC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.aa(i3, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), 0);
                }
                return false;
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dvX();
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.aa(36, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), DistributeVideoView.this.fTk.getCurrentPosition());
                }
                DistributeVideoView.this.jyD.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mhI.setVisibility(0);
                return true;
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mhQ = System.currentTimeMillis();
                DistributeVideoView.this.mhV = true;
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.aa(34, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), DistributeVideoView.this.fTk.getDuration());
                }
                DistributeVideoView.this.dvX();
                if (DistributeVideoView.this.mek != null) {
                    DistributeVideoView.this.mek.dvN();
                    DistributeVideoView.this.mhF.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mhX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mhB != null && DistributeVideoView.this.fTk != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HC(1);
                }
            }
        };
        this.mhY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dvZ();
            }
        };
        this.mhZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wj(false);
            }
        };
        this.mia = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mhT) {
                            DistributeVideoView.this.wh(true);
                            return;
                        } else {
                            DistributeVideoView.this.wh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mhT = DistributeVideoView.this.mhP;
                    DistributeVideoView.this.wh(true);
                }
            }
        };
        this.iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wh(true);
                    }
                }
            }
        };
        this.mib = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wj(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mhA = false;
        this.alO = null;
        this.mhN = -1;
        this.mhO = 0L;
        this.mhP = false;
        this.mhQ = 0L;
        this.mStyle = 1;
        this.dPT = false;
        this.mhS = false;
        this.mhT = false;
        this.mhV = false;
        this.mhW = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mhI) {
                    DistributeVideoView.this.mhI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mhH || view == DistributeVideoView.this.mhG) {
                    DistributeVideoView.this.wh(!DistributeVideoView.this.mhP);
                } else if (view == DistributeVideoView.this.mhE || view == DistributeVideoView.this.mhL) {
                    DistributeVideoView.this.dvY();
                } else if (!(DistributeVideoView.this.mhR instanceof AdCard)) {
                    DistributeVideoView.this.dvY();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dvU();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mhN != 1) {
                            if (DistributeVideoView.this.fTk.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mhN = 1;
                                DistributeVideoView.this.drX();
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
                        if (DistributeVideoView.this.mhN == 1) {
                            if (DistributeVideoView.this.mhO == DistributeVideoView.this.fTk.getCurrentPosition()) {
                                DistributeVideoView.this.bJe();
                            } else {
                                DistributeVideoView.this.mhO = DistributeVideoView.this.fTk.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dZP = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.mhU = DistributeVideoView.this.fTk.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fTk.getDuration();
                    DistributeVideoView.this.fTk.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mhP && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wh(false);
                    }
                }
            }
        };
        this.dZS = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mhC != null) {
                    if (DistributeVideoView.this.mhV && "DETAIL".equals(DistributeVideoView.this.mhC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.aa(i3, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), 0);
                }
                return false;
            }
        };
        this.dZQ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dvX();
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.aa(36, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), DistributeVideoView.this.fTk.getCurrentPosition());
                }
                DistributeVideoView.this.jyD.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mhI.setVisibility(0);
                return true;
            }
        };
        this.dZR = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mhQ = System.currentTimeMillis();
                DistributeVideoView.this.mhV = true;
                if (DistributeVideoView.this.fTk != null) {
                    DistributeVideoView.this.aa(34, DistributeVideoView.this.HD(DistributeVideoView.this.mhW), DistributeVideoView.this.fTk.getDuration());
                }
                DistributeVideoView.this.dvX();
                if (DistributeVideoView.this.mek != null) {
                    DistributeVideoView.this.mek.dvN();
                    DistributeVideoView.this.mhF.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.frv = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mhX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mhB != null && DistributeVideoView.this.fTk != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HC(1);
                }
            }
        };
        this.mhY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dvZ();
            }
        };
        this.mhZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wj(false);
            }
        };
        this.mia = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mhT) {
                            DistributeVideoView.this.wh(true);
                            return;
                        } else {
                            DistributeVideoView.this.wh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mhT = DistributeVideoView.this.mhP;
                    DistributeVideoView.this.wh(true);
                }
            }
        };
        this.iqK = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wh(true);
                    }
                }
            }
        };
        this.mib = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wj(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mhR = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fTk = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.fTk.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.fTk.setNoBussinessStats();
            this.mhE = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jyD = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mhF = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mhI = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mhJ = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mhG = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mhK = this.mRootView.findViewById(R.id.distribute_control);
            this.mhL = (ImageView) this.mhK.findViewById(R.id.distribute_play_icon);
            this.mhH = (ImageView) this.mhK.findViewById(R.id.distribute_voice);
            this.mhM = (VideoControllerView) this.mhK.findViewById(R.id.distribute_process);
            this.mei = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mej = new d(context, this.mei);
            this.mhE.setAnimation(R.raw.lotti_video_loading);
            this.mhE.setMinFrame(0);
            this.mhE.setFrame(0);
            a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dvV() {
        return this.mStyle == 1 ? u.dvV() : j.isWifiNet();
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
        this.maV = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.maW = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mhB = videoInfo;
        this.mDuration = this.mhB.video_duration.intValue() * 1000;
        this.alO = new WeakReference<>(this.mContext.getApplicationContext());
        dvX();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mhB.video_width.intValue() > 0 ? (this.mhB.video_height.intValue() * equipmentWidth) / this.mhB.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jyD.setDefaultErrorResource(0);
        this.jyD.setDefaultResource(0);
        this.jyD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jyD.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fTk.setOnPreparedListener(this.dZP);
        this.fTk.setOnErrorListener(this.dZQ);
        this.fTk.setOnCompletionListener(this.dZR);
        this.fTk.setOnInfoListener(this.dZS);
        this.fTk.setOnSurfaceDestroyedListener(this.frv);
        ap.setViewTextColor(this.mhF, R.color.cp_cont_m);
        this.mhF.setText(StringUtils.translateSecondsToString(this.mhB.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mhP = false;
            ap.setImageResource(this.mhG, R.drawable.icon_vedio_npronunciation_small_white);
            this.mhG.setVisibility(8);
        } else {
            this.mhP = true;
            ap.setImageResource(this.mhH, R.drawable.ad_icon_sound_open);
            this.mhG.setVisibility(8);
        }
        this.mhH.setOnClickListener(this.mOnClickListener);
        this.mhG.setOnClickListener(this.mOnClickListener);
        this.mhI.setOnClickListener(this.mOnClickListener);
        this.mhI.setVisibility(8);
        ap.setBackgroundColor(this.mhI, R.color.black_alpha80);
        ap.setViewTextColor(this.mhJ, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mhF.setVisibility(0);
            return;
        }
        this.mhF.setVisibility(8);
        this.mhL.setOnClickListener(this.mOnClickListener);
        this.mhE.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mhB = videoInfo;
        this.alO = new WeakReference<>(this.mContext.getApplicationContext());
        dvX();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jyD.setDefaultErrorResource(0);
        this.jyD.setDefaultResource(0);
        this.jyD.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jyD.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fTk.setOnPreparedListener(this.dZP);
        this.fTk.setOnErrorListener(this.dZQ);
        this.fTk.setOnCompletionListener(this.dZR);
        this.fTk.setOnInfoListener(this.dZS);
        this.fTk.setOnSurfaceDestroyedListener(this.frv);
        ap.setViewTextColor(this.mhF, R.color.cp_cont_m);
        this.mhF.setText(StringUtils.translateSecondsToString(this.mhB.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mhP = false;
            ap.setImageResource(this.mhG, R.drawable.icon_vedio_npronunciation_small_white);
            this.mhG.setVisibility(8);
        } else {
            this.mhP = true;
            ap.setImageResource(this.mhH, R.drawable.ad_icon_sound_open);
            this.mhG.setVisibility(8);
        }
        this.mhH.setOnClickListener(this.mOnClickListener);
        this.mhG.setOnClickListener(this.mOnClickListener);
        this.mhI.setOnClickListener(this.mOnClickListener);
        this.mhI.setVisibility(8);
        ap.setBackgroundColor(this.mhI, R.color.black_alpha80);
        ap.setViewTextColor(this.mhJ, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mhF.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mhF.setVisibility(8);
        this.mhL.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mhC;
        }
        this.mek = this.mej.a(this.maW, this.mek);
        if (this.mek != null) {
            this.mek.setPageContext(this.mPageContext);
            this.mek.c(this.mhR);
            if (this.mek instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.mek).wf(this.mgz);
            }
            this.mek.setAdvertAppInfo(advertAppInfo);
            this.mek.a(this.maW);
            this.mek.dvO();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.mgz = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mek != null) {
            this.mek.setDownloadAppCallback(cVar);
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
        this.dZR = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HC(int i) {
        this.mhW = i;
        if (this.mhB != null && this.mhN == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mhQ) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mek != null) {
                    this.mek.dvO();
                }
                this.fTk.setVideoPath(this.mhB.video_url);
                this.fTk.start();
                this.mhU = this.fTk.getCurrentPosition();
                ap.setImageResource(this.mhL, R.drawable.icon_video_midplay);
                bJe();
                this.mhI.setVisibility(8);
                this.jyD.setForegroundDrawable(0);
                this.mhN = 0;
                if (this.mStyle == 1) {
                    this.mhF.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mhF.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mib);
                    this.mPageContext.registerListener(this.mia);
                    this.mPageContext.registerListener(this.iqK);
                }
                aa(31, HD(this.mhW), 0);
            }
        }
    }

    public void performPlay() {
        HC(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (dvV()) {
            if (i <= 0) {
                HC(1);
                return;
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhX);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mhX, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mhN == 1) {
            F(32, HD(this.mhW), this.fTk.getCurrentPosition(), i);
            this.fTk.pause();
            ai.a(this.alO, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mhL, R.drawable.icon_video_midpause);
            this.mhN = 2;
        }
    }

    public void autoContinue() {
        if (!this.mhS) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mhN == 2) {
            this.mhW = i;
            aa(33, HD(i), this.fTk.getCurrentPosition());
            this.mhU = this.fTk.getCurrentPosition();
            this.fTk.start();
            if (this.mhP) {
                ai.a(this.alO, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mhL, R.drawable.icon_video_midplay);
            this.mhN = 1;
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
    public void bJe() {
        if (this.mhE != null) {
            this.mhE.setAlpha(1.0f);
            this.mhE.setVisibility(0);
            this.mhE.loop(true);
            this.mhE.setMinAndMaxFrame(14, 80);
            this.mhE.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dvW();
        if (z) {
            this.mhE.setAlpha(1.0f);
            this.mhE.setVisibility(0);
            return;
        }
        this.mhE.setVisibility(8);
    }

    private void dvW() {
        if (this.mhE != null) {
            this.mhE.setMinFrame(0);
            this.mhE.setFrame(0);
            this.mhE.cancelAnimation();
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
        if (this.fTk.getCurrentPosition() > 0 && this.mhN != -1 && z) {
            int i = 32;
            int currentPosition = this.fTk.getCurrentPosition();
            if (this.fTk.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, HD(this.mhW), currentPosition, this.fTk.isPlaying());
        }
        dvX();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fTk.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mei.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jyD.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int m21do = com.baidu.g.a.e.a.m21do(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = m21do;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = m21do;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = m21do;
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
        this.fTk.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvX() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhX);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhY);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhZ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fTk.stopPlayback();
        this.mhN = -1;
        ai.a(this.alO, false);
        wj(false);
        this.jyD.setForegroundDrawable(0);
        this.jyD.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mhL, R.drawable.icon_video_midpause);
        this.mhM.aLG();
        this.mhI.setVisibility(8);
        if (this.mhB != null) {
            this.mhF.setText(StringUtils.translateSecondsToString(this.mhB.video_duration.intValue()));
            this.mhF.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mhT = false;
        MessageManager.getInstance().unRegisterListener(this.mib);
        MessageManager.getInstance().unRegisterListener(this.mia);
        MessageManager.getInstance().unRegisterListener(this.iqK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int HD(int i) {
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
        return this.mhB != null ? this.mhB.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mek instanceof com.baidu.tieba.recapp.e.a) && (this.mhR instanceof AdCard) && !((AdCard) this.mhR).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mek).bEX();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mek instanceof com.baidu.tieba.recapp.e.a) && (this.mhR instanceof AdCard) && !((AdCard) this.mhR).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mek).dvM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(boolean z) {
        if (z) {
            if (this.fTk != null) {
                this.fTk.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mhH, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mhG, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mhN == 1) {
                ai.a(this.alO, true);
            }
        } else {
            if (this.fTk != null) {
                this.fTk.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mhH, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mhG, R.drawable.icon_vedio_npronunciation_small_white);
            ai.a(this.alO, false);
        }
        this.mhP = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.mhN;
    }

    public VideoInfo getData() {
        return this.mhB;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.mhO;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mhC = advertAppInfo;
        this.mhD = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = g.a(this.mhC, 303, i, HD(this.mhW), this.mhB.video_duration.intValue(), this.mDuration, -1);
        if (this.mek != null) {
            this.mek.e(a2);
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
        if (this.mhC != null && this.mhB != null) {
            this.mhC.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dvG().a(g.a(this.mhC, i, this.mhD, i2, this.mhB.video_duration.intValue(), com.baidu.tieba.ad.a.a.sV(i3), i4));
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
                c(str, this.mhU, i3, this.mDuration, str2, HE(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.maV != null && "cpv".equals(this.maV.mbX) && !TextUtils.isEmpty(this.maV.mbY)) {
            new com.baidu.tieba.recapp.request.a(this.maV.mbY).a(str, i, i2, i3, str2, str3);
        }
    }

    private String HE(int i) {
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
            this.mhz = view;
            this.mhA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhY);
            if (this.bKg != null) {
                this.bKg.cancel();
            }
            this.mhK.setVisibility(0);
            if (this.mhN == 1) {
                ap.setImageResource(this.mhL, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mhL, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mhK.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvY() {
        switch (this.mhN) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.ob(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bkJ();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mhS = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    wi(true);
                    return;
                }
                return;
            case 2:
                this.mhS = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhY);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.mhY, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvZ() {
        if (!this.dPT && this.bKg != null) {
            this.mhK.startAnimation(this.bKg);
            this.dPT = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bKg = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bKg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mhK.setVisibility(8);
                    DistributeVideoView.this.dPT = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dwa() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mhZ);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mhZ, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wj(boolean z) {
        if (this.mhG != null && this.mStyle == 1) {
            if (z) {
                this.mhG.setVisibility(0);
                dwa();
                return;
            }
            this.mhG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
