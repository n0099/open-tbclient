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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.a.b;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.d.d;
import com.baidu.tieba.recapp.d.e;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.lego.a.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.h;
import com.baidu.tieba.recapp.t;
import com.baidu.tieba.tbadkCore.v;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes7.dex */
public class DistributeVideoView extends RelativeLayout implements k {
    private Animation cjx;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnErrorListener eCc;
    private CyberPlayerManager.OnCompletionListener eCd;
    private CyberPlayerManager.OnInfoListener eCe;
    boolean erz;
    private TbCyberVideoView.a fVI;
    private TbCyberVideoView gBU;
    private CustomMessageListener jjU;
    private ForeDrawableImageView kyt;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private CustomMessageListener mHeadSetPlugListener;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private String mScheme;
    private int mStyle;
    private AdCard.g mUh;
    private Runnable mUn;
    private WeakReference<Context> mWeakContext;
    private ViewGroup mXI;
    private d mXJ;
    private e mXK;
    private RelativeLayout mlp;
    private boolean nam;
    private VideoInfo nbA;
    private AdCard.a nbB;
    private AdvertAppInfo nbC;
    private int nbD;
    private TBLottieAnimationView nbE;
    private TextView nbF;
    private ImageView nbG;
    private ImageView nbH;
    private View nbI;
    private TextView nbJ;
    private View nbK;
    private ImageView nbL;
    private VideoControllerView nbM;
    private TbImageView nbN;
    private int nbO;
    private long nbP;
    private boolean nbQ;
    private long nbR;
    private b nbS;
    boolean nbT;
    private boolean nbU;
    private int nbV;
    boolean nbW;
    private int nbX;
    private int nbY;
    private Runnable nbZ;
    private View nby;
    private boolean nbz;
    private Runnable nca;
    private CustomMessageListener ncb;

    public int jump2DownloadDetailPage() {
        return dER();
    }

    private int dER() {
        String str = this.nbC != null ? this.nbC.eMW : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (TextUtils.isEmpty(str) || this.mContext == null) {
            return 0;
        }
        if (t.b(this.nbC, str)) {
            return 3;
        }
        return t.a(this.mContext, str, this.nbC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dES() {
        ac(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dAW() {
        if (this.nbE != null) {
            this.nbE.clearAnimation();
            this.nbE.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.nbE.setVisibility(8);
                    DistributeVideoView.this.kyt.setVisibility(8);
                    DistributeVideoView.this.xE(DistributeVideoView.this.nbQ);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.nbF.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.nbM.setPlayer(DistributeVideoView.this.gBU);
                        DistributeVideoView.this.nbM.bx(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.nbA.video_duration.intValue()));
                        DistributeVideoView.this.nbM.showProgress();
                        DistributeVideoView.this.xF(true);
                        com.baidu.adp.lib.f.e.mA().removeCallbacks(DistributeVideoView.this.nbZ);
                        com.baidu.adp.lib.f.e.mA().postDelayed(DistributeVideoView.this.nbZ, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.nbP = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.xG(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.nbE.setMinFrame(0);
                    DistributeVideoView.this.nbE.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.nbz = false;
        this.mWeakContext = null;
        this.nbO = -1;
        this.nbP = 0L;
        this.nbQ = false;
        this.nbR = 0L;
        this.mStyle = 1;
        this.erz = false;
        this.nbT = false;
        this.nbU = false;
        this.nbW = false;
        this.nbX = 2;
        this.nbY = 1;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.nbI) {
                    DistributeVideoView.this.nbI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.nbH || view == DistributeVideoView.this.nbG) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.nbQ);
                } else if (view == DistributeVideoView.this.nbE || view == DistributeVideoView.this.nbL) {
                    DistributeVideoView.this.dEW();
                } else if (!(DistributeVideoView.this.nbS instanceof AdCard)) {
                    DistributeVideoView.this.dEW();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dES();
                    if (t.HO(jump2DownloadDetailPage)) {
                        DistributeVideoView.this.Im(jump2DownloadDetailPage);
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.nbO != 1) {
                            if (DistributeVideoView.this.gBU.getCurrentPosition() > 0) {
                                DistributeVideoView.this.nbO = 1;
                                DistributeVideoView.this.dAW();
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
                        if (DistributeVideoView.this.nbO == 1) {
                            if (DistributeVideoView.this.nbP == DistributeVideoView.this.gBU.getCurrentPosition()) {
                                DistributeVideoView.this.bQG();
                            } else {
                                DistributeVideoView.this.nbP = DistributeVideoView.this.gBU.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.nbV = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gBU.getDuration();
                    DistributeVideoView.this.gBU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.nbQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.nbC != null) {
                    if (DistributeVideoView.this.nbW && "DETAIL".equals(DistributeVideoView.this.nbC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), 0);
                }
                return false;
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dEV();
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), DistributeVideoView.this.gBU.getCurrentPosition());
                }
                DistributeVideoView.this.kyt.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.nbI.setVisibility(0);
                return true;
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.nbR = System.currentTimeMillis();
                DistributeVideoView.this.nbW = true;
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), DistributeVideoView.this.gBU.getDuration());
                }
                DistributeVideoView.this.dEV();
                if (DistributeVideoView.this.mXK != null) {
                    DistributeVideoView.this.mXK.dEJ();
                    DistributeVideoView.this.nbF.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mUn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.nbA != null && DistributeVideoView.this.gBU != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ik(1);
                }
            }
        };
        this.nbZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEX();
            }
        };
        this.nca = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.nbU) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.nbU = DistributeVideoView.this.nbQ;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.ncb = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.nbz = false;
        this.mWeakContext = null;
        this.nbO = -1;
        this.nbP = 0L;
        this.nbQ = false;
        this.nbR = 0L;
        this.mStyle = 1;
        this.erz = false;
        this.nbT = false;
        this.nbU = false;
        this.nbW = false;
        this.nbX = 2;
        this.nbY = 1;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.nbI) {
                    DistributeVideoView.this.nbI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.nbH || view == DistributeVideoView.this.nbG) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.nbQ);
                } else if (view == DistributeVideoView.this.nbE || view == DistributeVideoView.this.nbL) {
                    DistributeVideoView.this.dEW();
                } else if (!(DistributeVideoView.this.nbS instanceof AdCard)) {
                    DistributeVideoView.this.dEW();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dES();
                    if (t.HO(jump2DownloadDetailPage)) {
                        DistributeVideoView.this.Im(jump2DownloadDetailPage);
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.nbO != 1) {
                            if (DistributeVideoView.this.gBU.getCurrentPosition() > 0) {
                                DistributeVideoView.this.nbO = 1;
                                DistributeVideoView.this.dAW();
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
                        if (DistributeVideoView.this.nbO == 1) {
                            if (DistributeVideoView.this.nbP == DistributeVideoView.this.gBU.getCurrentPosition()) {
                                DistributeVideoView.this.bQG();
                            } else {
                                DistributeVideoView.this.nbP = DistributeVideoView.this.gBU.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.nbV = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gBU.getDuration();
                    DistributeVideoView.this.gBU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.nbQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.nbC != null) {
                    if (DistributeVideoView.this.nbW && "DETAIL".equals(DistributeVideoView.this.nbC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), 0);
                }
                return false;
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dEV();
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), DistributeVideoView.this.gBU.getCurrentPosition());
                }
                DistributeVideoView.this.kyt.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.nbI.setVisibility(0);
                return true;
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.nbR = System.currentTimeMillis();
                DistributeVideoView.this.nbW = true;
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), DistributeVideoView.this.gBU.getDuration());
                }
                DistributeVideoView.this.dEV();
                if (DistributeVideoView.this.mXK != null) {
                    DistributeVideoView.this.mXK.dEJ();
                    DistributeVideoView.this.nbF.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mUn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.nbA != null && DistributeVideoView.this.gBU != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ik(1);
                }
            }
        };
        this.nbZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEX();
            }
        };
        this.nca = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.nbU) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.nbU = DistributeVideoView.this.nbQ;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.ncb = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.nbz = false;
        this.mWeakContext = null;
        this.nbO = -1;
        this.nbP = 0L;
        this.nbQ = false;
        this.nbR = 0L;
        this.mStyle = 1;
        this.erz = false;
        this.nbT = false;
        this.nbU = false;
        this.nbW = false;
        this.nbX = 2;
        this.nbY = 1;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.nbI) {
                    DistributeVideoView.this.nbI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.nbH || view == DistributeVideoView.this.nbG) {
                    DistributeVideoView.this.xE(!DistributeVideoView.this.nbQ);
                } else if (view == DistributeVideoView.this.nbE || view == DistributeVideoView.this.nbL) {
                    DistributeVideoView.this.dEW();
                } else if (!(DistributeVideoView.this.nbS instanceof AdCard)) {
                    DistributeVideoView.this.dEW();
                } else {
                    int jump2DownloadDetailPage = DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dES();
                    if (t.HO(jump2DownloadDetailPage)) {
                        DistributeVideoView.this.Im(jump2DownloadDetailPage);
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.nbO != 1) {
                            if (DistributeVideoView.this.gBU.getCurrentPosition() > 0) {
                                DistributeVideoView.this.nbO = 1;
                                DistributeVideoView.this.dAW();
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
                        if (DistributeVideoView.this.nbO == 1) {
                            if (DistributeVideoView.this.nbP == DistributeVideoView.this.gBU.getCurrentPosition()) {
                                DistributeVideoView.this.bQG();
                            } else {
                                DistributeVideoView.this.nbP = DistributeVideoView.this.gBU.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.nbV = DistributeVideoView.this.gBU.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gBU.getDuration();
                    DistributeVideoView.this.gBU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.nbQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.xE(false);
                    }
                }
            }
        };
        this.eCe = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.nbC != null) {
                    if (DistributeVideoView.this.nbW && "DETAIL".equals(DistributeVideoView.this.nbC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), 0);
                }
                return false;
            }
        };
        this.eCc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dEV();
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ac(36, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), DistributeVideoView.this.gBU.getCurrentPosition());
                }
                DistributeVideoView.this.kyt.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.nbI.setVisibility(0);
                return true;
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.nbR = System.currentTimeMillis();
                DistributeVideoView.this.nbW = true;
                if (DistributeVideoView.this.gBU != null) {
                    DistributeVideoView.this.ac(34, DistributeVideoView.this.Il(DistributeVideoView.this.nbX), DistributeVideoView.this.gBU.getDuration());
                }
                DistributeVideoView.this.dEV();
                if (DistributeVideoView.this.mXK != null) {
                    DistributeVideoView.this.mXK.dEJ();
                    DistributeVideoView.this.nbF.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mUn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.nbA != null && DistributeVideoView.this.gBU != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ik(1);
                }
            }
        };
        this.nbZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dEX();
            }
        };
        this.nca = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                        if (DistributeVideoView.this.nbU) {
                            DistributeVideoView.this.xE(true);
                            return;
                        } else {
                            DistributeVideoView.this.xE(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.nbU = DistributeVideoView.this.nbQ;
                    DistributeVideoView.this.xE(true);
                }
            }
        };
        this.jjU = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.ncb = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.nbS = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gBU = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gBU.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gBU.setNoBussinessStats();
            this.nbE = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.kyt = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.nbF = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.nbI = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.nbJ = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.nbG = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.nbK = this.mRootView.findViewById(R.id.distribute_control);
            this.nbL = (ImageView) this.nbK.findViewById(R.id.distribute_play_icon);
            this.nbH = (ImageView) this.nbK.findViewById(R.id.distribute_voice);
            this.nbM = (VideoControllerView) this.nbK.findViewById(R.id.distribute_process);
            this.mXI = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mXJ = new d(context, this.mXI);
            this.nbN = (TbImageView) this.mRootView.findViewById(R.id.bottom_picture);
            this.nbN.setVisibility(8);
            this.mlp = (RelativeLayout) this.mRootView.findViewById(R.id.video_container);
            this.nbE.setAnimation(R.raw.lotti_video_loading);
            this.nbE.setMinFrame(0);
            this.nbE.setFrame(0);
            com.baidu.tbadk.a.b.b.m(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dET() {
        return this.mStyle == 1 ? v.dET() : j.isWifiNet();
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
        this.nbB = aVar;
    }

    public void setVideoTailFrameData(AdCard.g gVar) {
        this.mUh = gVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.nbA = videoInfo;
        this.mDuration = this.nbA.video_duration.intValue() * 1000;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dEV();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.nbA.video_width.intValue() > 0 ? (this.nbA.video_height.intValue() * equipmentWidth) / this.nbA.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.kyt.setDefaultResource(0);
        this.kyt.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kyt.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnErrorListener(this.eCc);
        this.gBU.setOnCompletionListener(this.eCd);
        this.gBU.setOnInfoListener(this.eCe);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        ap.setViewTextColor(this.nbF, R.color.cp_cont_m);
        this.nbF.setText(StringUtils.translateSecondsToString(this.nbA.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.nbQ = false;
            ap.setImageResource(this.nbG, R.drawable.icon_vedio_npronunciation_small_white);
            this.nbG.setVisibility(8);
        } else {
            this.nbQ = true;
            ap.setImageResource(this.nbH, R.drawable.ad_icon_sound_open);
            this.nbG.setVisibility(8);
        }
        this.nbH.setOnClickListener(this.mOnClickListener);
        this.nbG.setOnClickListener(this.mOnClickListener);
        this.nbI.setOnClickListener(this.mOnClickListener);
        this.nbI.setVisibility(8);
        ap.setBackgroundColor(this.nbI, R.color.black_alpha80);
        ap.setViewTextColor(this.nbJ, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.nbF.setVisibility(0);
            return;
        }
        this.nbF.setVisibility(8);
        this.nbL.setOnClickListener(this.mOnClickListener);
        this.nbE.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, AdCard.f fVar, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.nbA = videoInfo;
        this.mWeakContext = new WeakReference<>(this.mContext.getApplicationContext());
        dEV();
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mRootView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i4;
        setOnClickListener(this.mOnClickListener);
        if (fVar != null && fVar.isValid()) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.nbN.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i4;
            this.nbN.startLoad(fVar.mVA, 30, false);
            this.nbN.setVisibility(0);
            if (fVar.mVC > 0.0d) {
                i = (int) (i3 * fVar.mVC);
                i2 = a.HT(i);
            }
            if (fVar.mVD <= 0.0d) {
                i7 = 0;
            } else {
                i7 = Math.min((int) (i3 * fVar.mVD), i3 - i);
            }
            i5 = 11;
            i6 = i7;
        } else {
            this.nbN.setVisibility(8);
            i5 = 13;
            i6 = 0;
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mlp.getLayoutParams();
        layoutParams3.width = i;
        layoutParams3.height = i2;
        layoutParams3.rightMargin = i6;
        layoutParams3.addRule(i5);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gBU.getLayoutParams();
        layoutParams4.width = i;
        layoutParams4.height = i2;
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.kyt.getLayoutParams();
        layoutParams5.width = i;
        layoutParams5.height = i2;
        this.kyt.setDefaultResource(0);
        this.kyt.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!au.isEmpty(videoInfo.thumbnail_url)) {
            this.kyt.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnErrorListener(this.eCc);
        this.gBU.setOnCompletionListener(this.eCd);
        this.gBU.setOnInfoListener(this.eCe);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        ap.setViewTextColor(this.nbF, R.color.cp_cont_m);
        this.nbF.setText(StringUtils.translateSecondsToString(this.nbA.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.nbQ = false;
            ap.setImageResource(this.nbG, R.drawable.icon_vedio_npronunciation_small_white);
            this.nbG.setVisibility(8);
        } else {
            this.nbQ = true;
            ap.setImageResource(this.nbH, R.drawable.ad_icon_sound_open);
            this.nbG.setVisibility(8);
        }
        this.nbH.setOnClickListener(this.mOnClickListener);
        this.nbG.setOnClickListener(this.mOnClickListener);
        this.nbI.setOnClickListener(this.mOnClickListener);
        this.nbI.setVisibility(8);
        ap.setBackgroundColor(this.nbI, R.color.black_alpha80);
        ap.setViewTextColor(this.nbJ, R.color.CAM_X0101);
        if (this.mStyle == 1) {
            this.nbF.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.nbF.setVisibility(8);
        this.nbL.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.nbC;
        }
        this.mXK = this.mXJ.a(this.mUh, this.mXK);
        if (this.mXK != null) {
            this.mXK.setPageContext(this.mPageContext);
            this.mXK.c(this.nbS);
            if (this.mXK instanceof com.baidu.tieba.recapp.d.a) {
                ((com.baidu.tieba.recapp.d.a) this.mXK).xC(this.nam);
            }
            this.mXK.setAdvertAppInfo(advertAppInfo);
            this.mXK.a(this.mUh);
            this.mXK.dEK();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.nam = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mXK != null) {
            this.mXK.setDownloadAppCallback(cVar);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.eCd = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ik(int i) {
        this.nbX = i;
        if (this.nbA != null && this.nbO == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.nbR) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mXK != null) {
                    this.mXK.dEK();
                }
                this.gBU.setVideoPath(this.nbA.video_url);
                this.gBU.setVideoScalingMode(this.nbY);
                this.gBU.start();
                this.nbV = this.gBU.getCurrentPosition();
                ap.setImageResource(this.nbL, R.drawable.icon_video_midplay);
                bQG();
                this.nbI.setVisibility(8);
                this.kyt.setForegroundDrawable(0);
                this.nbO = 0;
                if (this.mStyle == 1) {
                    this.nbF.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.nbF.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.ncb);
                    this.mPageContext.registerListener(this.mHeadSetPlugListener);
                    this.mPageContext.registerListener(this.jjU);
                }
                ac(31, Il(this.nbX), 0);
            }
        }
    }

    public void performPlay() {
        Ik(2);
    }

    @Override // com.baidu.tieba.recapp.k
    public void autoPlay(int i) {
        if (dET()) {
            if (i <= 0) {
                Ik(1);
                return;
            }
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mUn);
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mUn, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.nbO == 1) {
            J(32, Il(this.nbX), this.gBU.getCurrentPosition(), i);
            this.gBU.pause();
            ak.a(this.mWeakContext, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.nbL, R.drawable.icon_video_midpause);
            this.nbO = 2;
        }
    }

    public void autoContinue() {
        if (!this.nbT) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.nbO == 2) {
            this.nbX = i;
            ac(33, Il(i), this.gBU.getCurrentPosition());
            this.nbV = this.gBU.getCurrentPosition();
            this.gBU.start();
            if (this.nbQ) {
                ak.a(this.mWeakContext, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.nbL, R.drawable.icon_video_midplay);
            this.nbO = 1;
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
    public void bQG() {
        if (this.nbE != null) {
            this.nbE.setAlpha(1.0f);
            this.nbE.setVisibility(0);
            this.nbE.loop(true);
            this.nbE.setMinAndMaxFrame(14, 80);
            this.nbE.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dEU();
        if (z) {
            this.nbE.setAlpha(1.0f);
            this.nbE.setVisibility(0);
            return;
        }
        this.nbE.setVisibility(8);
    }

    private void dEU() {
        if (this.nbE != null) {
            this.nbE.setMinFrame(0);
            this.nbE.setFrame(0);
            this.nbE.cancelAnimation();
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
        if (this.gBU.getCurrentPosition() > 0 && this.nbO != -1 && z) {
            int i = 32;
            int currentPosition = this.gBU.getCurrentPosition();
            if (this.gBU.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, Il(this.nbX), currentPosition, this.gBU.isPlaying());
        }
        dEV();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gBU.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mXI.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kyt.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int HU = a.HU(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = HU;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = HU;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = HU;
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
        this.gBU.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEV() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mUn);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nbZ);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nca);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gBU.stopPlayback();
        this.nbO = -1;
        ak.a(this.mWeakContext, false);
        xG(false);
        this.kyt.setForegroundDrawable(0);
        this.kyt.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.nbL, R.drawable.icon_video_midpause);
        this.nbM.aRr();
        this.nbI.setVisibility(8);
        if (this.nbA != null) {
            this.nbF.setText(StringUtils.translateSecondsToString(this.nbA.video_duration.intValue()));
            this.nbF.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.nbU = false;
        MessageManager.getInstance().unRegisterListener(this.ncb);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
        MessageManager.getInstance().unRegisterListener(this.jjU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Il(int i) {
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
        return this.nbA != null ? this.nbA.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mXK instanceof com.baidu.tieba.recapp.d.a) && (this.nbS instanceof AdCard) && !((AdCard) this.nbS).directDownload) {
            ((com.baidu.tieba.recapp.d.a) this.mXK).bLu();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mXK instanceof com.baidu.tieba.recapp.d.a) && (this.nbS instanceof AdCard) && !((AdCard) this.nbS).directDownload) {
            ((com.baidu.tieba.recapp.d.a) this.mXK).dEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xE(boolean z) {
        if (z) {
            if (this.gBU != null) {
                this.gBU.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.nbH, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.nbG, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.nbO == 1) {
                ak.a(this.mWeakContext, true);
            }
        } else {
            if (this.gBU != null) {
                this.gBU.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.nbH, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.nbG, R.drawable.icon_vedio_npronunciation_small_white);
            ak.a(this.mWeakContext, false);
        }
        this.nbQ = z;
    }

    @Override // com.baidu.tieba.recapp.k
    public int getPlayStatus() {
        return this.nbO;
    }

    public VideoInfo getData() {
        return this.nbA;
    }

    @Override // com.baidu.tieba.recapp.k
    public long getCurrentPosition() {
        return this.nbP;
    }

    @Override // com.baidu.tieba.recapp.k
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.nbC = advertAppInfo;
        this.nbD = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = h.a(this.nbC, 303, i, Il(this.nbX), this.nbA.video_duration.intValue(), this.mDuration, -1);
        if (this.mXK != null) {
            this.mXK.e(a2);
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
        if (this.nbC != null && this.nbA != null) {
            this.nbC.page = this.mPage;
            com.baidu.tieba.recapp.report.e.dEC().a(h.a(this.nbC, i, this.nbD, i2, this.nbA.video_duration.intValue(), com.baidu.tieba.ad.b.a.te(i3), i4));
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
                c(str, this.nbV, i3, this.mDuration, str2, In(i2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im(int i) {
        if (this.nbC != null && this.nbA != null) {
            this.nbC.page = this.mPage;
            com.baidu.tieba.recapp.report.c a2 = h.a(this.nbC, 706, this.nbD, 1, this.nbA.video_duration.intValue(), com.baidu.tieba.ad.b.a.te(0), -1);
            boolean z = i == 1000;
            a2.Sj(z ? "APP" : "URL");
            if (!z) {
                a2.Id(i);
            }
            a2.Si("DEEPLINK");
            com.baidu.tieba.recapp.report.e.dEC().a(a2);
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.nbB != null && AdCard.CHARGE_STYLE_CPV.equals(this.nbB.mVq) && !TextUtils.isEmpty(this.nbB.mVr)) {
            new com.baidu.tieba.recapp.request.a(this.nbB.mVr).a(str, i, i2, i3, str2, str3);
        }
    }

    private String In(int i) {
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
            this.nby = view;
            this.nbz = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nbZ);
            if (this.cjx != null) {
                this.cjx.cancel();
            }
            this.nbK.setVisibility(0);
            if (this.nbO == 1) {
                ap.setImageResource(this.nbL, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.nbL, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.nbK.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEW() {
        switch (this.nbO) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.ny(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bqz();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.nbT = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    xF(true);
                    return;
                }
                return;
            case 2:
                this.nbT = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nbZ);
                    com.baidu.adp.lib.f.e.mA().postDelayed(this.nbZ, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dEX() {
        if (!this.erz && this.cjx != null) {
            this.nbK.startAnimation(this.cjx);
            this.erz = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.cjx = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.cjx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.nbK.setVisibility(8);
                    DistributeVideoView.this.erz = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dEY() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.nca);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.nca, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG(boolean z) {
        if (this.nbG != null && this.mStyle == 1) {
            if (z) {
                this.nbG.setVisibility(0);
                dEY();
                return;
            }
            this.nbG.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.k
    public boolean canPlay() {
        boolean z = true;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        if ((iArr[1] + getHeight()) - 120 <= 0 || iArr[1] > l.getEquipmentHeight(this.mContext)) {
            z = false;
        }
        return z;
    }

    public void setVideoScalingMode(int i) {
        this.nbY = i;
        this.gBU.setVideoScalingMode(i);
    }
}
