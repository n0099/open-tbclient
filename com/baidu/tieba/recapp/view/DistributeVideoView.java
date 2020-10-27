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
    private Animation bSB;
    boolean dYq;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnErrorListener ein;
    private CyberPlayerManager.OnCompletionListener eio;
    private CyberPlayerManager.OnInfoListener eip;
    private TbCyberVideoView.a fzS;
    private TbCyberVideoView gdn;
    private CustomMessageListener iDg;
    private ForeDrawableImageView jLc;
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
    private AdCard.a mnt;
    private AdCard.f mnu;
    private ViewGroup mqH;
    private d mqI;
    private e mqJ;
    private boolean msY;
    private View mtY;
    private boolean mtZ;
    private CustomMessageListener muA;
    private VideoInfo mua;
    private AdvertAppInfo mub;
    private int muc;
    private TBLottieAnimationView mud;
    private TextView mue;
    private ImageView muf;
    private ImageView mug;
    private View muh;
    private TextView mui;
    private View muj;
    private ImageView muk;
    private VideoControllerView mul;
    private int mum;
    private long mun;
    private boolean muo;
    private long mup;
    private b muq;
    boolean mur;
    private boolean mus;
    private int mut;
    boolean muu;
    private int muv;
    private Runnable muw;
    private Runnable mux;
    private Runnable muy;
    private CustomMessageListener muz;

    private void dyj() {
        String str = this.mub != null ? this.mub.esW : "";
        if (!TextUtils.isEmpty(this.mScheme)) {
            str = this.mScheme;
        }
        if (!TextUtils.isEmpty(str) && this.mContext != null && s.a(this.mContext, str, this.mub) == 1) {
            ab(706, 1, 0);
        }
    }

    public void jump2DownloadDetailPage() {
        dyj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzb() {
        ab(2, 1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dve() {
        if (this.mud != null) {
            this.mud.clearAnimation();
            this.mud.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.mud.setVisibility(8);
                    DistributeVideoView.this.jLc.setVisibility(8);
                    DistributeVideoView.this.wy(DistributeVideoView.this.muo);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mue.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.mul.setPlayer(DistributeVideoView.this.gdn);
                        DistributeVideoView.this.mul.bz(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.mua.video_duration.intValue()));
                        DistributeVideoView.this.mul.showProgress();
                        DistributeVideoView.this.wz(true);
                        com.baidu.adp.lib.f.e.mY().removeCallbacks(DistributeVideoView.this.mux);
                        com.baidu.adp.lib.f.e.mY().postDelayed(DistributeVideoView.this.mux, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.mun = DistributeVideoView.this.gdn.getCurrentPosition();
                    DistributeVideoView.this.wA(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.mud.setMinFrame(0);
                    DistributeVideoView.this.mud.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.mtZ = false;
        this.alP = null;
        this.mum = -1;
        this.mun = 0L;
        this.muo = false;
        this.mup = 0L;
        this.mStyle = 1;
        this.dYq = false;
        this.mur = false;
        this.mus = false;
        this.muu = false;
        this.muv = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.muh) {
                    DistributeVideoView.this.muh.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mug || view == DistributeVideoView.this.muf) {
                    DistributeVideoView.this.wy(!DistributeVideoView.this.muo);
                } else if (view == DistributeVideoView.this.mud || view == DistributeVideoView.this.muk) {
                    DistributeVideoView.this.dzf();
                } else if (!(DistributeVideoView.this.muq instanceof AdCard)) {
                    DistributeVideoView.this.dzf();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dzb();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mum != 1) {
                            if (DistributeVideoView.this.gdn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mum = 1;
                                DistributeVideoView.this.dve();
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
                        if (DistributeVideoView.this.mum == 1) {
                            if (DistributeVideoView.this.mun == DistributeVideoView.this.gdn.getCurrentPosition()) {
                                DistributeVideoView.this.bLE();
                            } else {
                                DistributeVideoView.this.mun = DistributeVideoView.this.gdn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.mut = DistributeVideoView.this.gdn.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gdn.getDuration();
                    DistributeVideoView.this.gdn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.muo && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wy(false);
                    }
                }
            }
        };
        this.eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mub != null) {
                    if (DistributeVideoView.this.muu && "DETAIL".equals(DistributeVideoView.this.mub.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.HW(DistributeVideoView.this.muv), 0);
                }
                return false;
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dze();
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.ab(36, DistributeVideoView.this.HW(DistributeVideoView.this.muv), DistributeVideoView.this.gdn.getCurrentPosition());
                }
                DistributeVideoView.this.jLc.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.muh.setVisibility(0);
                return true;
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mup = System.currentTimeMillis();
                DistributeVideoView.this.muu = true;
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.ab(34, DistributeVideoView.this.HW(DistributeVideoView.this.muv), DistributeVideoView.this.gdn.getDuration());
                }
                DistributeVideoView.this.dze();
                if (DistributeVideoView.this.mqJ != null) {
                    DistributeVideoView.this.mqJ.dyU();
                    DistributeVideoView.this.mue.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.muw = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mua != null && DistributeVideoView.this.gdn != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HV(1);
                }
            }
        };
        this.mux = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dzg();
            }
        };
        this.muy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wA(false);
            }
        };
        this.muz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mus) {
                            DistributeVideoView.this.wy(true);
                            return;
                        } else {
                            DistributeVideoView.this.wy(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mus = DistributeVideoView.this.muo;
                    DistributeVideoView.this.wy(true);
                }
            }
        };
        this.iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wy(true);
                    }
                }
            }
        };
        this.muA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wA(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mtZ = false;
        this.alP = null;
        this.mum = -1;
        this.mun = 0L;
        this.muo = false;
        this.mup = 0L;
        this.mStyle = 1;
        this.dYq = false;
        this.mur = false;
        this.mus = false;
        this.muu = false;
        this.muv = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.muh) {
                    DistributeVideoView.this.muh.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mug || view == DistributeVideoView.this.muf) {
                    DistributeVideoView.this.wy(!DistributeVideoView.this.muo);
                } else if (view == DistributeVideoView.this.mud || view == DistributeVideoView.this.muk) {
                    DistributeVideoView.this.dzf();
                } else if (!(DistributeVideoView.this.muq instanceof AdCard)) {
                    DistributeVideoView.this.dzf();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dzb();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mum != 1) {
                            if (DistributeVideoView.this.gdn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mum = 1;
                                DistributeVideoView.this.dve();
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
                        if (DistributeVideoView.this.mum == 1) {
                            if (DistributeVideoView.this.mun == DistributeVideoView.this.gdn.getCurrentPosition()) {
                                DistributeVideoView.this.bLE();
                            } else {
                                DistributeVideoView.this.mun = DistributeVideoView.this.gdn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.mut = DistributeVideoView.this.gdn.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gdn.getDuration();
                    DistributeVideoView.this.gdn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.muo && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wy(false);
                    }
                }
            }
        };
        this.eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.mub != null) {
                    if (DistributeVideoView.this.muu && "DETAIL".equals(DistributeVideoView.this.mub.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.HW(DistributeVideoView.this.muv), 0);
                }
                return false;
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.dze();
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.ab(36, DistributeVideoView.this.HW(DistributeVideoView.this.muv), DistributeVideoView.this.gdn.getCurrentPosition());
                }
                DistributeVideoView.this.jLc.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.muh.setVisibility(0);
                return true;
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mup = System.currentTimeMillis();
                DistributeVideoView.this.muu = true;
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.ab(34, DistributeVideoView.this.HW(DistributeVideoView.this.muv), DistributeVideoView.this.gdn.getDuration());
                }
                DistributeVideoView.this.dze();
                if (DistributeVideoView.this.mqJ != null) {
                    DistributeVideoView.this.mqJ.dyU();
                    DistributeVideoView.this.mue.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.muw = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mua != null && DistributeVideoView.this.gdn != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HV(1);
                }
            }
        };
        this.mux = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dzg();
            }
        };
        this.muy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wA(false);
            }
        };
        this.muz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mus) {
                            DistributeVideoView.this.wy(true);
                            return;
                        } else {
                            DistributeVideoView.this.wy(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mus = DistributeVideoView.this.muo;
                    DistributeVideoView.this.wy(true);
                }
            }
        };
        this.iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wy(true);
                    }
                }
            }
        };
        this.muA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wA(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mtZ = false;
        this.alP = null;
        this.mum = -1;
        this.mun = 0L;
        this.muo = false;
        this.mup = 0L;
        this.mStyle = 1;
        this.dYq = false;
        this.mur = false;
        this.mus = false;
        this.muu = false;
        this.muv = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.muh) {
                    DistributeVideoView.this.muh.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.mug || view == DistributeVideoView.this.muf) {
                    DistributeVideoView.this.wy(!DistributeVideoView.this.muo);
                } else if (view == DistributeVideoView.this.mud || view == DistributeVideoView.this.muk) {
                    DistributeVideoView.this.dzf();
                } else if (!(DistributeVideoView.this.muq instanceof AdCard)) {
                    DistributeVideoView.this.dzf();
                } else {
                    DistributeVideoView.this.jump2DownloadDetailPage();
                    DistributeVideoView.this.dzb();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.mum != 1) {
                            if (DistributeVideoView.this.gdn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.mum = 1;
                                DistributeVideoView.this.dve();
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
                        if (DistributeVideoView.this.mum == 1) {
                            if (DistributeVideoView.this.mun == DistributeVideoView.this.gdn.getCurrentPosition()) {
                                DistributeVideoView.this.bLE();
                            } else {
                                DistributeVideoView.this.mun = DistributeVideoView.this.gdn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.mut = DistributeVideoView.this.gdn.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.gdn.getDuration();
                    DistributeVideoView.this.gdn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.muo && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.wy(false);
                    }
                }
            }
        };
        this.eip = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.mub != null) {
                    if (DistributeVideoView.this.muu && "DETAIL".equals(DistributeVideoView.this.mub.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.HW(DistributeVideoView.this.muv), 0);
                }
                return false;
            }
        };
        this.ein = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.dze();
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.ab(36, DistributeVideoView.this.HW(DistributeVideoView.this.muv), DistributeVideoView.this.gdn.getCurrentPosition());
                }
                DistributeVideoView.this.jLc.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.muh.setVisibility(0);
                return true;
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.mup = System.currentTimeMillis();
                DistributeVideoView.this.muu = true;
                if (DistributeVideoView.this.gdn != null) {
                    DistributeVideoView.this.ab(34, DistributeVideoView.this.HW(DistributeVideoView.this.muv), DistributeVideoView.this.gdn.getDuration());
                }
                DistributeVideoView.this.dze();
                if (DistributeVideoView.this.mqJ != null) {
                    DistributeVideoView.this.mqJ.dyU();
                    DistributeVideoView.this.mue.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.muw = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.mua != null && DistributeVideoView.this.gdn != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.HV(1);
                }
            }
        };
        this.mux = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dzg();
            }
        };
        this.muy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.wA(false);
            }
        };
        this.muz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.mus) {
                            DistributeVideoView.this.wy(true);
                            return;
                        } else {
                            DistributeVideoView.this.wy(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.mus = DistributeVideoView.this.muo;
                    DistributeVideoView.this.wy(true);
                }
            }
        };
        this.iDg = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.wy(true);
                    }
                }
            }
        };
        this.muA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.wA(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setAdInfo(AdCard adCard) {
        this.muq = adCard;
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.gdn = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.gdn.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            this.gdn.setNoBussinessStats();
            this.mud = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.jLc = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.mue = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.muh = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.mui = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.muf = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.muj = this.mRootView.findViewById(R.id.distribute_control);
            this.muk = (ImageView) this.muj.findViewById(R.id.distribute_play_icon);
            this.mug = (ImageView) this.muj.findViewById(R.id.distribute_voice);
            this.mul = (VideoControllerView) this.muj.findViewById(R.id.distribute_process);
            this.mqH = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.mqI = new d(context, this.mqH);
            this.mud.setAnimation(R.raw.lotti_video_loading);
            this.mud.setMinFrame(0);
            this.mud.setFrame(0);
            a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean dzc() {
        return this.mStyle == 1 ? u.dzc() : j.isWifiNet();
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
        this.mnt = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.mnu = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mua = videoInfo;
        this.mDuration = this.mua.video_duration.intValue() * 1000;
        this.alP = new WeakReference<>(this.mContext.getApplicationContext());
        dze();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.mua.video_width.intValue() > 0 ? (this.mua.video_height.intValue() * equipmentWidth) / this.mua.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.jLc.setDefaultErrorResource(0);
        this.jLc.setDefaultResource(0);
        this.jLc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jLc.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gdn.setOnPreparedListener(this.eim);
        this.gdn.setOnErrorListener(this.ein);
        this.gdn.setOnCompletionListener(this.eio);
        this.gdn.setOnInfoListener(this.eip);
        this.gdn.setOnSurfaceDestroyedListener(this.fzS);
        ap.setViewTextColor(this.mue, R.color.cp_cont_m);
        this.mue.setText(StringUtils.translateSecondsToString(this.mua.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.muo = false;
            ap.setImageResource(this.muf, R.drawable.icon_vedio_npronunciation_small_white);
            this.muf.setVisibility(8);
        } else {
            this.muo = true;
            ap.setImageResource(this.mug, R.drawable.ad_icon_sound_open);
            this.muf.setVisibility(8);
        }
        this.mug.setOnClickListener(this.mOnClickListener);
        this.muf.setOnClickListener(this.mOnClickListener);
        this.muh.setOnClickListener(this.mOnClickListener);
        this.muh.setVisibility(8);
        ap.setBackgroundColor(this.muh, R.color.black_alpha80);
        ap.setViewTextColor(this.mui, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.mue.setVisibility(0);
            return;
        }
        this.mue.setVisibility(8);
        this.muk.setOnClickListener(this.mOnClickListener);
        this.mud.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.mua = videoInfo;
        this.alP = new WeakReference<>(this.mContext.getApplicationContext());
        dze();
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.jLc.setDefaultErrorResource(0);
        this.jLc.setDefaultResource(0);
        this.jLc.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!at.isEmpty(videoInfo.thumbnail_url)) {
            this.jLc.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.gdn.setOnPreparedListener(this.eim);
        this.gdn.setOnErrorListener(this.ein);
        this.gdn.setOnCompletionListener(this.eio);
        this.gdn.setOnInfoListener(this.eip);
        this.gdn.setOnSurfaceDestroyedListener(this.fzS);
        ap.setViewTextColor(this.mue, R.color.cp_cont_m);
        this.mue.setText(StringUtils.translateSecondsToString(this.mua.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.muo = false;
            ap.setImageResource(this.muf, R.drawable.icon_vedio_npronunciation_small_white);
            this.muf.setVisibility(8);
        } else {
            this.muo = true;
            ap.setImageResource(this.mug, R.drawable.ad_icon_sound_open);
            this.muf.setVisibility(8);
        }
        this.mug.setOnClickListener(this.mOnClickListener);
        this.muf.setOnClickListener(this.mOnClickListener);
        this.muh.setOnClickListener(this.mOnClickListener);
        this.muh.setVisibility(8);
        ap.setBackgroundColor(this.muh, R.color.black_alpha80);
        ap.setViewTextColor(this.mui, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mue.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.mue.setVisibility(8);
        this.muk.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.mub;
        }
        this.mqJ = this.mqI.a(this.mnu, this.mqJ);
        if (this.mqJ != null) {
            this.mqJ.setPageContext(this.mPageContext);
            this.mqJ.c(this.muq);
            if (this.mqJ instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.mqJ).ww(this.msY);
            }
            this.mqJ.setAdvertAppInfo(advertAppInfo);
            this.mqJ.a(this.mnu);
            this.mqJ.dyV();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.msY = z;
    }

    public void setDownloadCallback(c cVar) {
        if (this.mqJ != null) {
            this.mqJ.setDownloadAppCallback(cVar);
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
        this.eio = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HV(int i) {
        this.muv = i;
        if (this.mua != null && this.mum == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.mup) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.mqJ != null) {
                    this.mqJ.dyV();
                }
                this.gdn.setVideoPath(this.mua.video_url);
                this.gdn.start();
                this.mut = this.gdn.getCurrentPosition();
                ap.setImageResource(this.muk, R.drawable.icon_video_midplay);
                bLE();
                this.muh.setVisibility(8);
                this.jLc.setForegroundDrawable(0);
                this.mum = 0;
                if (this.mStyle == 1) {
                    this.mue.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.mue.setVisibility(8);
                }
                if (this.mPageContext != null) {
                    this.mPageContext.registerListener(this.muA);
                    this.mPageContext.registerListener(this.muz);
                    this.mPageContext.registerListener(this.iDg);
                }
                ab(31, HW(this.muv), 0);
            }
        }
    }

    public void performPlay() {
        HV(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (dzc()) {
            if (i <= 0) {
                HV(1);
                return;
            }
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.muw);
            com.baidu.adp.lib.f.e.mY().postDelayed(this.muw, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.mum == 1) {
            G(32, HW(this.muv), this.gdn.getCurrentPosition(), i);
            this.gdn.pause();
            ai.a(this.alP, false);
            setLoadingAnimShow(true);
            ap.setImageResource(this.muk, R.drawable.icon_video_midpause);
            this.mum = 2;
        }
    }

    public void autoContinue() {
        if (!this.mur) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.mum == 2) {
            this.muv = i;
            ab(33, HW(i), this.gdn.getCurrentPosition());
            this.mut = this.gdn.getCurrentPosition();
            this.gdn.start();
            if (this.muo) {
                ai.a(this.alP, true);
            }
            setLoadingAnimShow(false);
            ap.setImageResource(this.muk, R.drawable.icon_video_midplay);
            this.mum = 1;
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
    public void bLE() {
        if (this.mud != null) {
            this.mud.setAlpha(1.0f);
            this.mud.setVisibility(0);
            this.mud.loop(true);
            this.mud.setMinAndMaxFrame(14, 80);
            this.mud.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        dzd();
        if (z) {
            this.mud.setAlpha(1.0f);
            this.mud.setVisibility(0);
            return;
        }
        this.mud.setVisibility(8);
    }

    private void dzd() {
        if (this.mud != null) {
            this.mud.setMinFrame(0);
            this.mud.setFrame(0);
            this.mud.cancelAnimation();
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
        if (this.gdn.getCurrentPosition() > 0 && this.mum != -1 && z) {
            int i = 32;
            int currentPosition = this.gdn.getCurrentPosition();
            if (this.gdn.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, HW(this.muv), currentPosition, this.gdn.isPlaying());
        }
        dze();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gdn.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mqH.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jLc.getLayoutParams();
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
        this.gdn.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dze() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.muw);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mux);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.muy);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.gdn.stopPlayback();
        this.mum = -1;
        ai.a(this.alP, false);
        wA(false);
        this.jLc.setForegroundDrawable(0);
        this.jLc.setVisibility(0);
        setLoadingAnimShow(true);
        ap.setImageResource(this.muk, R.drawable.icon_video_midpause);
        this.mul.aNA();
        this.muh.setVisibility(8);
        if (this.mua != null) {
            this.mue.setText(StringUtils.translateSecondsToString(this.mua.video_duration.intValue()));
            this.mue.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.mus = false;
        MessageManager.getInstance().unRegisterListener(this.muA);
        MessageManager.getInstance().unRegisterListener(this.muz);
        MessageManager.getInstance().unRegisterListener(this.iDg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int HW(int i) {
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
        return this.mua != null ? this.mua.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.mqJ instanceof com.baidu.tieba.recapp.e.a) && (this.muq instanceof AdCard) && !((AdCard) this.muq).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mqJ).bGQ();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.mqJ instanceof com.baidu.tieba.recapp.e.a) && (this.muq instanceof AdCard) && !((AdCard) this.muq).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.mqJ).dyT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wy(boolean z) {
        if (z) {
            if (this.gdn != null) {
                this.gdn.setVolume(1.0f, 1.0f);
            }
            ap.setImageResource(this.mug, R.drawable.ad_icon_sound_open);
            ap.setImageResource(this.muf, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.mum == 1) {
                ai.a(this.alP, true);
            }
        } else {
            if (this.gdn != null) {
                this.gdn.setVolume(0.0f, 0.0f);
            }
            ap.setImageResource(this.mug, R.drawable.ad_icon_sound_close);
            ap.setImageResource(this.muf, R.drawable.icon_vedio_npronunciation_small_white);
            ai.a(this.alP, false);
        }
        this.muo = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.mum;
    }

    public VideoInfo getData() {
        return this.mua;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.mun;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.mub = advertAppInfo;
        this.muc = i;
        this.mPage = str;
        b(advertAppInfo, i, str);
    }

    private void b(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a2 = g.a(this.mub, 303, i, HW(this.muv), this.mua.video_duration.intValue(), this.mDuration, -1);
        if (this.mqJ != null) {
            this.mqJ.e(a2);
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
        if (this.mub != null && this.mua != null) {
            this.mub.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dyN().a(g.a(this.mub, i, this.muc, i2, this.mua.video_duration.intValue(), com.baidu.tieba.ad.a.a.tg(i3), i4));
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
                c(str, this.mut, i3, this.mDuration, str2, HX(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.mnt != null && "cpv".equals(this.mnt.mow) && !TextUtils.isEmpty(this.mnt.mox)) {
            new com.baidu.tieba.recapp.request.a(this.mnt.mox).a(str, i, i2, i3, str2, str3);
        }
    }

    private String HX(int i) {
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
            this.mtY = view;
            this.mtZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wz(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mux);
            if (this.bSB != null) {
                this.bSB.cancel();
            }
            this.muj.setVisibility(0);
            if (this.mum == 1) {
                ap.setImageResource(this.muk, R.drawable.icon_video_midplay);
                return;
            } else {
                ap.setImageResource(this.muk, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.muj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzf() {
        switch (this.mum) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.om(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).bmC();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.mur = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    wz(true);
                    return;
                }
                return;
            case 2:
                this.mur = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.mux);
                    com.baidu.adp.lib.f.e.mY().postDelayed(this.mux, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzg() {
        if (!this.dYq && this.bSB != null) {
            this.muj.startAnimation(this.bSB);
            this.dYq = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bSB = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bSB.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.muj.setVisibility(8);
                    DistributeVideoView.this.dYq = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void dzh() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.muy);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.muy, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wA(boolean z) {
        if (this.muf != null && this.mStyle == 1) {
            if (z) {
                this.muf.setVisibility(0);
                dzh();
                return;
            }
            this.muf.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
