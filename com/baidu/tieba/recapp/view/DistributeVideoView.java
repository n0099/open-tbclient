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
    private WeakReference<Context> alP;
    private Animation bYl;
    boolean eeh;
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnErrorListener eoh;
    private CyberPlayerManager.OnCompletionListener eoi;
    private CyberPlayerManager.OnInfoListener eoj;
    private TbCyberVideoView.a fFI;
    private TbCyberVideoView gjd;
    private CustomMessageListener iJd;
    private ForeDrawableImageView jQZ;
    private TextView mAa;
    private ImageView mAb;
    private ImageView mAc;
    private View mAd;
    private TextView mAe;
    private View mAf;
    private ImageView mAg;
    private VideoControllerView mAh;
    private int mAi;
    private long mAj;
    private boolean mAk;
    private long mAl;
    private b mAm;
    boolean mAn;
    private boolean mAo;
    private int mAp;
    boolean mAq;
    private int mAr;
    private Runnable mAs;
    private Runnable mAt;
    private Runnable mAu;
    private CustomMessageListener mAv;
    private CustomMessageListener mAw;
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
    private AdCard.a mtr;
    private AdCard.f mts;
    private ViewGroup mwE;
    private d mwF;
    private e mwG;
    private boolean myU;
    private View mzU;
    private boolean mzV;
    private VideoInfo mzW;
    private AdvertAppInfo mzX;
    private int mzY;
    private TBLottieAnimationView mzZ;

    private void dAL() {
        String str = this.mzX != null ? this.mzX.eyQ : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.mzX) == 1) {
            ab(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dAL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBD() {
        ab(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxG() {
        if (this.mzZ != null) {
            this.mzZ.clearAnimation();
            this.mzZ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mzZ.setVisibility(8);
                    DistributeVideoView.this.jQZ.setVisibility(8);
                    DistributeVideoView.this.wH(DistributeVideoView.this.mAk);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mAa.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mAh.setPlayer(DistributeVideoView.this.gjd);
                        DistributeVideoView.this.mAh.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mzW.video_duration.intValue()));
                        DistributeVideoView.this.mAh.showProgress();
                        DistributeVideoView.this.wI(true);
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(DistributeVideoView.this.mAt);
                        com.baidu.adp.lib.f.e.mY().postDelayed(DistributeVideoView.this.mAt, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mAj = DistributeVideoView.this.gjd.getCurrentPosition();
                    DistributeVideoView.this.wJ(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mzZ.setMinFrame(0);
                    DistributeVideoView.this.mzZ.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mzV = false;
        this.alP = null;
        this.mAi = -1;
        this.mAj = 0L;
        this.mAk = false;
        this.mAl = 0L;
        this.mStyle = 1;
        this.eeh = false;
        this.mAn = false;
        this.mAo = false;
        this.mAq = false;
        this.mAr = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mAd) {
                    DistributeVideoView.this.mAd.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mAc || view == DistributeVideoView.this.mAb) {
                    DistributeVideoView.this.wH(!DistributeVideoView.this.mAk);
                } else if (view == DistributeVideoView.this.mzZ || view == DistributeVideoView.this.mAg) {
                    DistributeVideoView.this.dBH();
                } else if (!(DistributeVideoView.this.mAm instanceof AdCard)) {
                    DistributeVideoView.this.dBH();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dBD();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mAi != 1) {
                            if (DistributeVideoView.this.gjd.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mAi = 1;
                                DistributeVideoView.this.dxG();
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
                        if (DistributeVideoView.this.mAi == 1) {
                            if (DistributeVideoView.this.mAj == DistributeVideoView.this.gjd.getCurrentPosition()) {
                                DistributeVideoView.this.bOd();
                            } else {
                                DistributeVideoView.this.mAj = DistributeVideoView.this.gjd.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.mAp = DistributeVideoView.this.gjd.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gjd.getDuration();
                    DistributeVideoView.this.gjd.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mAk && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wH(false);
                    }
                }
            }
        };
        this.eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mzX != null) {
                    if (DistributeVideoView.this.mAq && "DETAIL".equals(DistributeVideoView.this.mzX.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), 0);
                }
                return false;
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dBG();
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.ab(36, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), DistributeVideoView.this.gjd.getCurrentPosition());
                }
                DistributeVideoView.this.jQZ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mAd.setVisibility(0);
                return true;
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mAl = System.currentTimeMillis();
                DistributeVideoView.this.mAq = true;
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.ab(34, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), DistributeVideoView.this.gjd.getDuration());
                }
                DistributeVideoView.this.dBG();
                if (DistributeVideoView.this.mwG != null) {
                    DistributeVideoView.this.mwG.dBw();
                    DistributeVideoView.this.mAa.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mAs = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mzW != null && DistributeVideoView.this.gjd != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ii(1);
                }
            }
        };
        this.mAt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dBI();
            }
        };
        this.mAu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wJ(false);
            }
        };
        this.mAv = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mAo) {
                            DistributeVideoView.this.wH(true);
                            return;
                        } else {
                            DistributeVideoView.this.wH(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mAo = DistributeVideoView.this.mAk;
                    DistributeVideoView.this.wH(true);
                }
            }
        };
        this.iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wH(true);
                    }
                }
            }
        };
        this.mAw = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wJ(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mzV = false;
        this.alP = null;
        this.mAi = -1;
        this.mAj = 0L;
        this.mAk = false;
        this.mAl = 0L;
        this.mStyle = 1;
        this.eeh = false;
        this.mAn = false;
        this.mAo = false;
        this.mAq = false;
        this.mAr = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mAd) {
                    DistributeVideoView.this.mAd.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mAc || view == DistributeVideoView.this.mAb) {
                    DistributeVideoView.this.wH(!DistributeVideoView.this.mAk);
                } else if (view == DistributeVideoView.this.mzZ || view == DistributeVideoView.this.mAg) {
                    DistributeVideoView.this.dBH();
                } else if (!(DistributeVideoView.this.mAm instanceof AdCard)) {
                    DistributeVideoView.this.dBH();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dBD();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mAi != 1) {
                            if (DistributeVideoView.this.gjd.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mAi = 1;
                                DistributeVideoView.this.dxG();
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
                        if (DistributeVideoView.this.mAi == 1) {
                            if (DistributeVideoView.this.mAj == DistributeVideoView.this.gjd.getCurrentPosition()) {
                                DistributeVideoView.this.bOd();
                            } else {
                                DistributeVideoView.this.mAj = DistributeVideoView.this.gjd.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.mAp = DistributeVideoView.this.gjd.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gjd.getDuration();
                    DistributeVideoView.this.gjd.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mAk && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wH(false);
                    }
                }
            }
        };
        this.eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mzX != null) {
                    if (DistributeVideoView.this.mAq && "DETAIL".equals(DistributeVideoView.this.mzX.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), 0);
                }
                return false;
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dBG();
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.ab(36, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), DistributeVideoView.this.gjd.getCurrentPosition());
                }
                DistributeVideoView.this.jQZ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mAd.setVisibility(0);
                return true;
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mAl = System.currentTimeMillis();
                DistributeVideoView.this.mAq = true;
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.ab(34, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), DistributeVideoView.this.gjd.getDuration());
                }
                DistributeVideoView.this.dBG();
                if (DistributeVideoView.this.mwG != null) {
                    DistributeVideoView.this.mwG.dBw();
                    DistributeVideoView.this.mAa.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mAs = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mzW != null && DistributeVideoView.this.gjd != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ii(1);
                }
            }
        };
        this.mAt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dBI();
            }
        };
        this.mAu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wJ(false);
            }
        };
        this.mAv = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mAo) {
                            DistributeVideoView.this.wH(true);
                            return;
                        } else {
                            DistributeVideoView.this.wH(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mAo = DistributeVideoView.this.mAk;
                    DistributeVideoView.this.wH(true);
                }
            }
        };
        this.iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wH(true);
                    }
                }
            }
        };
        this.mAw = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wJ(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mzV = false;
        this.alP = null;
        this.mAi = -1;
        this.mAj = 0L;
        this.mAk = false;
        this.mAl = 0L;
        this.mStyle = 1;
        this.eeh = false;
        this.mAn = false;
        this.mAo = false;
        this.mAq = false;
        this.mAr = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.mAd) {
                    DistributeVideoView.this.mAd.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mAc || view == DistributeVideoView.this.mAb) {
                    DistributeVideoView.this.wH(!DistributeVideoView.this.mAk);
                } else if (view == DistributeVideoView.this.mzZ || view == DistributeVideoView.this.mAg) {
                    DistributeVideoView.this.dBH();
                } else if (!(DistributeVideoView.this.mAm instanceof AdCard)) {
                    DistributeVideoView.this.dBH();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dBD();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mAi != 1) {
                            if (DistributeVideoView.this.gjd.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mAi = 1;
                                DistributeVideoView.this.dxG();
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
                        if (DistributeVideoView.this.mAi == 1) {
                            if (DistributeVideoView.this.mAj == DistributeVideoView.this.gjd.getCurrentPosition()) {
                                DistributeVideoView.this.bOd();
                            } else {
                                DistributeVideoView.this.mAj = DistributeVideoView.this.gjd.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.mAp = DistributeVideoView.this.gjd.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gjd.getDuration();
                    DistributeVideoView.this.gjd.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.mAk && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wH(false);
                    }
                }
            }
        };
        this.eoj = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mzX != null) {
                    if (DistributeVideoView.this.mAq && "DETAIL".equals(DistributeVideoView.this.mzX.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), 0);
                }
                return false;
            }
        };
        this.eoh = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dBG();
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.ab(36, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), DistributeVideoView.this.gjd.getCurrentPosition());
                }
                DistributeVideoView.this.jQZ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.mAd.setVisibility(0);
                return true;
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mAl = System.currentTimeMillis();
                DistributeVideoView.this.mAq = true;
                if (DistributeVideoView.this.gjd != null) {
                    DistributeVideoView.this.ab(34, DistributeVideoView.this.Ij(DistributeVideoView.this.mAr), DistributeVideoView.this.gjd.getDuration());
                }
                DistributeVideoView.this.dBG();
                if (DistributeVideoView.this.mwG != null) {
                    DistributeVideoView.this.mwG.dBw();
                    DistributeVideoView.this.mAa.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.mAs = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mzW != null && DistributeVideoView.this.gjd != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ii(1);
                }
            }
        };
        this.mAt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dBI();
            }
        };
        this.mAu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wJ(false);
            }
        };
        this.mAv = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mAo) {
                            DistributeVideoView.this.wH(true);
                            return;
                        } else {
                            DistributeVideoView.this.wH(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mAo = DistributeVideoView.this.mAk;
                    DistributeVideoView.this.wH(true);
                }
            }
        };
        this.iJd = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wH(true);
                    }
                }
            }
        };
        this.mAw = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wJ(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.mAm = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gjd = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gjd.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gjd.setNoBussinessStats();
            this.mzZ = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jQZ = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mAa = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.mAd = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mAe = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.mAb = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.mAf = this.mRootView.findViewById(R.id.distribute_control);
            this.mAg = (ImageView) this.mAf.findViewById(R.id.distribute_play_icon);
            this.mAc = (ImageView) this.mAf.findViewById(R.id.distribute_voice);
            this.mAh = (VideoControllerView) this.mAf.findViewById(R.id.distribute_process);
            this.mwE = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mwF = new d(context, this.mwE);
            this.mzZ.setAnimation(R.raw.lotti_video_loading);
            this.mzZ.setMinFrame(0);
            this.mzZ.setFrame(0);
            a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dBE() {
        return this.mStyle == 1 ? u.dBE() : j.isWifiNet();
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
        this.mtr = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mts = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mzW = videoInfo;
        this.mDuration = this.mzW.video_duration.intValue() * 1000;
        this.alP = new WeakReference<>(this.mContext.getApplicationContext());
        dBG();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mzW.video_width.intValue() > 0 ? (this.mzW.video_height.intValue() * equipmentWidth) / this.mzW.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jQZ.setDefaultErrorResource(0);
        this.jQZ.setDefaultResource(0);
        this.jQZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jQZ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gjd.setOnPreparedListener(this.eog);
        this.gjd.setOnErrorListener(this.eoh);
        this.gjd.setOnCompletionListener(this.eoi);
        this.gjd.setOnInfoListener(this.eoj);
        this.gjd.setOnSurfaceDestroyedListener(this.fFI);
        ap.setViewTextColor(this.mAa, R.color.cp_cont_m);
        this.mAa.setText(StringUtils.translateSecondsToString(this.mzW.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mAk = false;
            ap.setImageResource(this.mAb, R.drawable.icon_vedio_npronunciation_small_white);
            this.mAb.setVisibility(8);
        } else {
            this.mAk = true;
            ap.setImageResource(this.mAc, R.drawable.ad_icon_sound_open);
            this.mAb.setVisibility(8);
        }
        this.mAc.setOnClickListener(this.mOnClickListener);
        this.mAb.setOnClickListener(this.mOnClickListener);
        this.mAd.setOnClickListener(this.mOnClickListener);
        this.mAd.setVisibility(8);
        ap.setBackgroundColor(this.mAd, R.color.black_alpha80);
        ap.setViewTextColor(this.mAe, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mAa.setVisibility(0);
            return;
        }
        this.mAa.setVisibility(8);
        this.mAg.setOnClickListener(this.mOnClickListener);
        this.mzZ.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mzW = videoInfo;
        this.alP = new WeakReference<>(this.mContext.getApplicationContext());
        dBG();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jQZ.setDefaultErrorResource(0);
        this.jQZ.setDefaultResource(0);
        this.jQZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jQZ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gjd.setOnPreparedListener(this.eog);
        this.gjd.setOnErrorListener(this.eoh);
        this.gjd.setOnCompletionListener(this.eoi);
        this.gjd.setOnInfoListener(this.eoj);
        this.gjd.setOnSurfaceDestroyedListener(this.fFI);
        ap.setViewTextColor(this.mAa, R.color.cp_cont_m);
        this.mAa.setText(StringUtils.translateSecondsToString(this.mzW.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.mAk = false;
            ap.setImageResource(this.mAb, R.drawable.icon_vedio_npronunciation_small_white);
            this.mAb.setVisibility(8);
        } else {
            this.mAk = true;
            ap.setImageResource(this.mAc, R.drawable.ad_icon_sound_open);
            this.mAb.setVisibility(8);
        }
        this.mAc.setOnClickListener(this.mOnClickListener);
        this.mAb.setOnClickListener(this.mOnClickListener);
        this.mAd.setOnClickListener(this.mOnClickListener);
        this.mAd.setVisibility(8);
        ap.setBackgroundColor(this.mAd, R.color.black_alpha80);
        ap.setViewTextColor(this.mAe, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mAa.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mAa.setVisibility(8);
        this.mAg.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mzX;
        }
        this.mwG = this.mwF.a(this.mts, this.mwG);
        if (this.mwG != null) {
            this.mwG.setPageContext(this.mPageContext);
            this.mwG.c(this.mAm);
            if (this.mwG instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.mwG).wF(this.myU);
            }
            this.mwG.setAdvertAppInfo(advertAppInfo);
            this.mwG.a(this.mts);
            this.mwG.dBx();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.myU = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mwG != null) {
            this.mwG.setDownloadAppCallback(cVar);
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
        this.eoi = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii(int i) {
        this.mAr = i;
        if (this.mzW != null && this.mAi == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mAl) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mwG != null) {
                    this.mwG.dBx();
                }
                this.gjd.setVideoPath(this.mzW.video_url);
                this.gjd.start();
                this.mAp = this.gjd.getCurrentPosition();
                ap.setImageResource(this.mAg, R.drawable.icon_video_midplay);
                bOd();
                this.mAd.setVisibility(8);
                this.jQZ.setForegroundDrawable(0);
                this.mAi = 0;
                if (this.mStyle == 1) {
                    this.mAa.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mAa.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.mAw);
                    this.mPageContext.registerListener(this.mAv);
                    this.mPageContext.registerListener(this.iJd);
                }
                ab(31, Ij(this.mAr), 0);
            }
        }
    }

    public void performPlay() {
        Ii(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (dBE()) {
            if (i <= 0) {
                Ii(1);
                return;
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAs);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.mAs, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mAi == 1) {
            G(32, Ij(this.mAr), this.gjd.getCurrentPosition(), i);
            this.gjd.pause();
            ai.a(this.alP, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.mAg, R.drawable.icon_video_midpause);
            this.mAi = 2;
        }
    }

    public void autoContinue() {
        if (!this.mAn) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mAi == 2) {
            this.mAr = i;
            ab(33, Ij(i), this.gjd.getCurrentPosition());
            this.mAp = this.gjd.getCurrentPosition();
            this.gjd.start();
            if (this.mAk) {
                ai.a(this.alP, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.mAg, R.drawable.icon_video_midplay);
            this.mAi = 1;
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
    public void bOd() {
        if (this.mzZ != null) {
            this.mzZ.setAlpha(1.0f);
            this.mzZ.setVisibility(0);
            this.mzZ.loop(true);
            this.mzZ.setMinAndMaxFrame(14, 80);
            this.mzZ.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dBF();
        if (z) {
            this.mzZ.setAlpha(1.0f);
            this.mzZ.setVisibility(0);
            return;
        }
        this.mzZ.setVisibility(8);
    }

    private void dBF() {
        if (this.mzZ != null) {
            this.mzZ.setMinFrame(0);
            this.mzZ.setFrame(0);
            this.mzZ.cancelAnimation();
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
        if (this.gjd.getCurrentPosition() > 0 && this.mAi != -1 && z) {
            int i = 32;
            int currentPosition = this.gjd.getCurrentPosition();
            if (this.gjd.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Ij(this.mAr), currentPosition, this.gjd.isPlaying());
        }
        dBG();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gjd.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mwE.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jQZ.getLayoutParams();
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
        this.gjd.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBG() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAs);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAt);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAu);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gjd.stopPlayback();
        this.mAi = -1;
        ai.a(this.alP, false);
        wJ(false);
        this.jQZ.setForegroundDrawable(0);
        this.jQZ.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.mAg, R.drawable.icon_video_midpause);
        this.mAh.aQa();
        this.mAd.setVisibility(8);
        if (this.mzW != null) {
            this.mAa.setText(StringUtils.translateSecondsToString(this.mzW.video_duration.intValue()));
            this.mAa.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mAo = false;
        MessageManager.getInstance().unRegisterListener(this.mAw);
        MessageManager.getInstance().unRegisterListener(this.mAv);
        MessageManager.getInstance().unRegisterListener(this.iJd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ij(int i) {
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
        return this.mzW != null ? this.mzW.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mwG instanceof com.baidu.tieba.recapp.e.a) && (this.mAm instanceof AdCard) && !((AdCard) this.mAm).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mwG).bJp();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mwG instanceof com.baidu.tieba.recapp.e.a) && (this.mAm instanceof AdCard) && !((AdCard) this.mAm).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mwG).dBv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wH(boolean z) {
        if (z) {
            if (this.gjd != null) {
                this.gjd.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mAc, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.mAb, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mAi == 1) {
                ai.a(this.alP, true);
            }
        } else {
            if (this.gjd != null) {
                this.gjd.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mAc, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.mAb, R.drawable.icon_vedio_npronunciation_small_white);
            ai.a(this.alP, false);
        }
        this.mAk = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.mAi;
    }

    public VideoInfo getData() {
        return this.mzW;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.mAj;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mzX = advertAppInfo;
        this.mzY = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = g.a(this.mzX, 303, i, Ij(this.mAr), this.mzW.video_duration.intValue(), this.mDuration, -1);
        if (this.mwG != null) {
            this.mwG.e(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, int i2, int i3) {
        G(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void G(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.mzX != null && this.mzW != null) {
            this.mzX.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dBp().a(g.a(this.mzX, i, this.mzY, i2, this.mzW.video_duration.intValue(), com.baidu.tieba.ad.a.a.tq(i3), i4));
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
                c(str, this.mAp, i3, this.mDuration, str2, Ik(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mtr != null && "cpv".equals(this.mtr.mut) && !TextUtils.isEmpty(this.mtr.muu)) {
            new com.baidu.tieba.recapp.request.a(this.mtr.muu).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Ik(int i) {
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
            this.mzU = view;
            this.mzV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAt);
            if (this.bYl != null) {
                this.bYl.cancel();
            }
            this.mAf.setVisibility(0);
            if (this.mAi == 1) {
                ap.setImageResource(this.mAg, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.mAg, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.mAf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBH() {
        switch (this.mAi) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.ow(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bpc();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mAn = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    wI(true);
                    return;
                }
                return;
            case 2:
                this.mAn = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAt);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.mAt, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dBI() {
        if (!this.eeh && this.bYl != null) {
            this.mAf.startAnimation(this.bYl);
            this.eeh = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bYl = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bYl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.mAf.setVisibility(8);
                    DistributeVideoView.this.eeh = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dBJ() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mAu);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.mAu, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ(boolean z) {
        if (this.mAb != null && this.mStyle == 1) {
            if (z) {
                this.mAb.setVisibility(0);
                dBJ();
                return;
            }
            this.mAb.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
