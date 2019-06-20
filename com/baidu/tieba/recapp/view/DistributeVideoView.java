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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.b.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.tbadkCore.q;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private String aVo;
    private Animation afk;
    private String ayL;
    private WeakReference<Context> bAG;
    boolean boh;
    private QuickVideoView.b cIC;
    private g.b cIy;
    private g.a cRT;
    private g.f cRU;
    private g.e cRW;
    private g deD;
    private QuickVideoView dlM;
    private CustomMessageListener fqt;
    private ForeDrawableImageView gnW;
    private VideoInfo hYM;
    private int hYN;
    private View hYU;
    private long hYW;
    private Runnable hZc;
    private ViewGroup iCV;
    private d iCW;
    private e iCX;
    private b iGA;
    boolean iGB;
    private boolean iGC;
    private int iGD;
    boolean iGE;
    private int iGF;
    private Runnable iGG;
    private Runnable iGH;
    private CustomMessageListener iGI;
    private View iGn;
    private boolean iGo;
    private AdvertAppInfo iGp;
    private int iGq;
    private TextView iGr;
    private ImageView iGs;
    private ImageView iGt;
    private TextView iGu;
    private View iGv;
    private ImageView iGw;
    private VideoControllerView iGx;
    private boolean iGy;
    private long iGz;
    private TBLottieAnimationView irX;
    private CustomMessageListener isC;
    private AdCard.a izG;
    private AdCard.f izH;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void cci() {
        if (this.irX != null) {
            this.irX.clearAnimation();
            this.irX.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.irX.setVisibility(8);
                    DistributeVideoView.this.gnW.setVisibility(8);
                    DistributeVideoView.this.qf(DistributeVideoView.this.iGy);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iGr.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iGx.setPlayer(DistributeVideoView.this.dlM);
                        DistributeVideoView.this.iGx.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hYM.video_duration.intValue()));
                        DistributeVideoView.this.iGx.showProgress();
                        DistributeVideoView.this.qg(true);
                        com.baidu.adp.lib.g.e.iB().removeCallbacks(DistributeVideoView.this.iGG);
                        com.baidu.adp.lib.g.e.iB().postDelayed(DistributeVideoView.this.iGG, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hYW = DistributeVideoView.this.dlM.getCurrentPosition();
                    DistributeVideoView.this.qh(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.irX.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iGo = false;
        this.bAG = null;
        this.hYN = -1;
        this.hYW = 0L;
        this.iGy = false;
        this.iGz = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGB = false;
        this.iGC = false;
        this.iGE = false;
        this.iGF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYU) {
                    DistributeVideoView.this.hYU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGt || view == DistributeVideoView.this.iGs) {
                    DistributeVideoView.this.qf(DistributeVideoView.this.iGy ? false : true);
                } else if (view == DistributeVideoView.this.irX || view == DistributeVideoView.this.iGw) {
                    DistributeVideoView.this.cfW();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGp == null || !DistributeVideoView.this.iGp.abG()) {
                    DistributeVideoView.this.cfW();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGp != null) {
                        WebVideoActivity.izA = new WebVideoActivity.a();
                        WebVideoActivity.izA.izK = DistributeVideoView.this.iGp;
                        WebVideoActivity.izA.ayL = "DETAIL";
                        WebVideoActivity.izA.mPageNum = DistributeVideoView.this.iGq;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGp.bDV, true, true, true, DistributeVideoView.this.hYM.video_url, DistributeVideoView.this.hYM.thumbnail_url, DistributeVideoView.this.hYM.video_width.intValue() / DistributeVideoView.this.hYM.video_height.intValue(), DistributeVideoView.this.hYM.video_duration.intValue());
                    if (DistributeVideoView.this.izG != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izG.iAD);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izG.iAE);
                    }
                    if (DistributeVideoView.this.izH != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izH.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zq(DistributeVideoView.this.parallelChargeInfo.gXQ);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXT.iterator();
                        while (it.hasNext()) {
                            c.zq(it.next());
                        }
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.hYN != 1) {
                            if (DistributeVideoView.this.dlM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYN = 1;
                                DistributeVideoView.this.cci();
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
                        if (DistributeVideoView.this.hYN == 1) {
                            if (DistributeVideoView.this.hYW == DistributeVideoView.this.dlM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYW = DistributeVideoView.this.dlM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRU = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deD = gVar;
                    DistributeVideoView.this.deD.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGy && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qf(false);
                    }
                }
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iGp != null) {
                    if (DistributeVideoView.this.iGE && "DETAIL".equals(DistributeVideoView.this.iGp.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), 0);
                }
                return false;
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cfV();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), gVar.getCurrentPosition());
                DistributeVideoView.this.gnW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYU.setVisibility(0);
                return true;
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGz = System.currentTimeMillis();
                DistributeVideoView.this.iGE = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), gVar.getDuration());
                DistributeVideoView.this.cfV();
                if (DistributeVideoView.this.iCX != null) {
                    DistributeVideoView.this.iCX.cfL();
                    DistributeVideoView.this.iGr.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hZc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYM != null && DistributeVideoView.this.dlM != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfX();
            }
        };
        this.iGH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qh(false);
            }
        };
        this.isC = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGC) {
                            DistributeVideoView.this.qf(true);
                            return;
                        } else {
                            DistributeVideoView.this.qf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGC = DistributeVideoView.this.iGy;
                    DistributeVideoView.this.qf(true);
                }
            }
        };
        this.fqt = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qf(true);
                    }
                }
            }
        };
        this.iGI = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qh(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGo = false;
        this.bAG = null;
        this.hYN = -1;
        this.hYW = 0L;
        this.iGy = false;
        this.iGz = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGB = false;
        this.iGC = false;
        this.iGE = false;
        this.iGF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYU) {
                    DistributeVideoView.this.hYU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGt || view == DistributeVideoView.this.iGs) {
                    DistributeVideoView.this.qf(DistributeVideoView.this.iGy ? false : true);
                } else if (view == DistributeVideoView.this.irX || view == DistributeVideoView.this.iGw) {
                    DistributeVideoView.this.cfW();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGp == null || !DistributeVideoView.this.iGp.abG()) {
                    DistributeVideoView.this.cfW();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGp != null) {
                        WebVideoActivity.izA = new WebVideoActivity.a();
                        WebVideoActivity.izA.izK = DistributeVideoView.this.iGp;
                        WebVideoActivity.izA.ayL = "DETAIL";
                        WebVideoActivity.izA.mPageNum = DistributeVideoView.this.iGq;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGp.bDV, true, true, true, DistributeVideoView.this.hYM.video_url, DistributeVideoView.this.hYM.thumbnail_url, DistributeVideoView.this.hYM.video_width.intValue() / DistributeVideoView.this.hYM.video_height.intValue(), DistributeVideoView.this.hYM.video_duration.intValue());
                    if (DistributeVideoView.this.izG != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izG.iAD);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izG.iAE);
                    }
                    if (DistributeVideoView.this.izH != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izH.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zq(DistributeVideoView.this.parallelChargeInfo.gXQ);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXT.iterator();
                        while (it.hasNext()) {
                            c.zq(it.next());
                        }
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.hYN != 1) {
                            if (DistributeVideoView.this.dlM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYN = 1;
                                DistributeVideoView.this.cci();
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
                        if (DistributeVideoView.this.hYN == 1) {
                            if (DistributeVideoView.this.hYW == DistributeVideoView.this.dlM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYW = DistributeVideoView.this.dlM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRU = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deD = gVar;
                    DistributeVideoView.this.deD.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGy && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qf(false);
                    }
                }
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iGp != null) {
                    if (DistributeVideoView.this.iGE && "DETAIL".equals(DistributeVideoView.this.iGp.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), 0);
                }
                return false;
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cfV();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), gVar.getCurrentPosition());
                DistributeVideoView.this.gnW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYU.setVisibility(0);
                return true;
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGz = System.currentTimeMillis();
                DistributeVideoView.this.iGE = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), gVar.getDuration());
                DistributeVideoView.this.cfV();
                if (DistributeVideoView.this.iCX != null) {
                    DistributeVideoView.this.iCX.cfL();
                    DistributeVideoView.this.iGr.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hZc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYM != null && DistributeVideoView.this.dlM != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfX();
            }
        };
        this.iGH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qh(false);
            }
        };
        this.isC = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGC) {
                            DistributeVideoView.this.qf(true);
                            return;
                        } else {
                            DistributeVideoView.this.qf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGC = DistributeVideoView.this.iGy;
                    DistributeVideoView.this.qf(true);
                }
            }
        };
        this.fqt = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qf(true);
                    }
                }
            }
        };
        this.iGI = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qh(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGo = false;
        this.bAG = null;
        this.hYN = -1;
        this.hYW = 0L;
        this.iGy = false;
        this.iGz = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGB = false;
        this.iGC = false;
        this.iGE = false;
        this.iGF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYU) {
                    DistributeVideoView.this.hYU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGt || view == DistributeVideoView.this.iGs) {
                    DistributeVideoView.this.qf(DistributeVideoView.this.iGy ? false : true);
                } else if (view == DistributeVideoView.this.irX || view == DistributeVideoView.this.iGw) {
                    DistributeVideoView.this.cfW();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGp == null || !DistributeVideoView.this.iGp.abG()) {
                    DistributeVideoView.this.cfW();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGp != null) {
                        WebVideoActivity.izA = new WebVideoActivity.a();
                        WebVideoActivity.izA.izK = DistributeVideoView.this.iGp;
                        WebVideoActivity.izA.ayL = "DETAIL";
                        WebVideoActivity.izA.mPageNum = DistributeVideoView.this.iGq;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGp.bDV, true, true, true, DistributeVideoView.this.hYM.video_url, DistributeVideoView.this.hYM.thumbnail_url, DistributeVideoView.this.hYM.video_width.intValue() / DistributeVideoView.this.hYM.video_height.intValue(), DistributeVideoView.this.hYM.video_duration.intValue());
                    if (DistributeVideoView.this.izG != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izG.iAD);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izG.iAE);
                    }
                    if (DistributeVideoView.this.izH != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izH.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zq(DistributeVideoView.this.parallelChargeInfo.gXQ);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXT.iterator();
                        while (it.hasNext()) {
                            c.zq(it.next());
                        }
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.hYN != 1) {
                            if (DistributeVideoView.this.dlM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYN = 1;
                                DistributeVideoView.this.cci();
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
                        if (DistributeVideoView.this.hYN == 1) {
                            if (DistributeVideoView.this.hYW == DistributeVideoView.this.dlM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYW = DistributeVideoView.this.dlM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRU = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deD = gVar;
                    DistributeVideoView.this.deD.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGy && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qf(false);
                    }
                }
            }
        };
        this.cRW = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iGp != null) {
                    if (DistributeVideoView.this.iGE && "DETAIL".equals(DistributeVideoView.this.iGp.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), 0);
                }
                return false;
            }
        };
        this.cIy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cfV();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), gVar.getCurrentPosition());
                DistributeVideoView.this.gnW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYU.setVisibility(0);
                return true;
            }
        };
        this.cRT = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGz = System.currentTimeMillis();
                DistributeVideoView.this.iGE = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGF), gVar.getDuration());
                DistributeVideoView.this.cfV();
                if (DistributeVideoView.this.iCX != null) {
                    DistributeVideoView.this.iCX.cfL();
                    DistributeVideoView.this.iGr.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cIC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hZc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYM != null && DistributeVideoView.this.dlM != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfX();
            }
        };
        this.iGH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qh(false);
            }
        };
        this.isC = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGC) {
                            DistributeVideoView.this.qf(true);
                            return;
                        } else {
                            DistributeVideoView.this.qf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGC = DistributeVideoView.this.iGy;
                    DistributeVideoView.this.qf(true);
                }
            }
        };
        this.fqt = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qf(true);
                    }
                }
            }
        };
        this.iGI = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qh(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aVo = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iGA = adCard;
        if (this.iGA != null) {
            this.parallelChargeInfo = this.iGA.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dlM = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.irX = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gnW = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iGr = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.hYU = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iGu = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iGs = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iGv = this.mRootView.findViewById(R.id.distribute_control);
            this.iGw = (ImageView) this.iGv.findViewById(R.id.distribute_play_icon);
            this.iGt = (ImageView) this.iGv.findViewById(R.id.distribute_voice);
            this.iGx = (VideoControllerView) this.iGv.findViewById(R.id.distribute_process);
            this.iCV = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iCW = new d(context, this.iCV);
            this.irX.setAnimation(R.raw.lotti_video_loading);
            this.irX.setFrame(0);
        }
    }

    private boolean bXq() {
        return this.mStyle == 1 ? q.bXq() : j.jT();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            Ti();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.izG = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.izH = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYM = videoInfo;
        this.mDuration = this.hYM.video_duration.intValue() * 1000;
        this.bAG = new WeakReference<>(this.mContext.getApplicationContext());
        cfV();
        al.l(this, R.color.cp_bg_line_d);
        int af = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.hYM.video_width.intValue() > 0 ? (this.hYM.video_height.intValue() * af) / this.hYM.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gnW.setDefaultErrorResource(0);
        this.gnW.setDefaultResource(0);
        this.gnW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnW.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dlM.setOnPreparedListener(this.cRU);
        this.dlM.setOnErrorListener(this.cIy);
        this.dlM.setOnCompletionListener(this.cRT);
        this.dlM.setOnOutInfoListener(this.cRW);
        this.dlM.setOnSurfaceDestroyedListener(this.cIC);
        al.j(this.iGr, R.color.cp_cont_m);
        this.iGr.setText(StringUtils.translateSecondsToString(this.hYM.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iGy = false;
            al.c(this.iGs, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iGs.setVisibility(8);
        } else {
            this.iGy = true;
            al.c(this.iGt, (int) R.drawable.ad_icon_sound_open);
            this.iGs.setVisibility(8);
        }
        this.iGt.setOnClickListener(this.mOnClickListener);
        this.iGs.setOnClickListener(this.mOnClickListener);
        this.hYU.setOnClickListener(this.mOnClickListener);
        this.hYU.setVisibility(8);
        al.l(this.hYU, R.color.black_alpha80);
        al.j(this.iGu, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iGr.setVisibility(0);
            return;
        }
        this.iGr.setVisibility(8);
        this.iGw.setOnClickListener(this.mOnClickListener);
        this.irX.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYM = videoInfo;
        this.bAG = new WeakReference<>(this.mContext.getApplicationContext());
        cfV();
        al.l(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gnW.setDefaultErrorResource(0);
        this.gnW.setDefaultResource(0);
        this.gnW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnW.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dlM.setOnPreparedListener(this.cRU);
        this.dlM.setOnErrorListener(this.cIy);
        this.dlM.setOnCompletionListener(this.cRT);
        this.dlM.setOnOutInfoListener(this.cRW);
        this.dlM.setOnSurfaceDestroyedListener(this.cIC);
        al.j(this.iGr, R.color.cp_cont_m);
        this.iGr.setText(StringUtils.translateSecondsToString(this.hYM.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iGy = false;
            al.c(this.iGs, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iGs.setVisibility(8);
        } else {
            this.iGy = true;
            al.c(this.iGt, (int) R.drawable.ad_icon_sound_open);
            this.iGs.setVisibility(8);
        }
        this.iGt.setOnClickListener(this.mOnClickListener);
        this.iGs.setOnClickListener(this.mOnClickListener);
        this.hYU.setOnClickListener(this.mOnClickListener);
        this.hYU.setVisibility(8);
        al.l(this.hYU, R.color.black_alpha80);
        al.j(this.iGu, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.iGr.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iGr.setVisibility(8);
        this.iGw.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iCX = this.iCW.a(this.izH, this.iCX);
        if (this.iCX != null) {
            this.iCX.setPageContext(this.mPageContext);
            this.iCX.c(this.iGA);
            this.iCX.setAdvertAppInfo(advertAppInfo);
            this.iCX.a(this.izH);
            this.iCX.cfM();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iCX != null) {
            this.iCX.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.ds16) + i;
        int intValue = videoInfo.video_height.intValue();
        int intValue2 = videoInfo.video_width.intValue();
        if (i <= 0 || intValue <= 0 || intValue2 <= 0) {
            n(this.mRootView, i2, i3);
            return true;
        }
        n(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void n(View view, int i, int i2) {
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

    public void setOnCompleteListener(g.a aVar) {
        this.cRT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        this.iGF = i;
        if (this.hYM != null && this.hYN == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iGz) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iCX != null) {
                    this.iCX.cfM();
                }
                this.dlM.setVideoPath(this.hYM.video_url);
                this.dlM.start();
                this.iGD = this.dlM.getCurrentPosition();
                al.c(this.iGw, (int) R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.hYU.setVisibility(8);
                this.gnW.setForegroundDrawable(0);
                this.hYN = 0;
                if (this.mStyle == 1) {
                    this.iGr.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iGr.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iGI);
                MessageManager.getInstance().registerListener(this.isC);
                MessageManager.getInstance().registerListener(this.fqt);
            }
        }
    }

    public void performPlay() {
        zj(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bXq()) {
            if (i <= 0) {
                zj(1);
                return;
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hZc);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.hZc, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hYN == 1) {
            A(32, zk(this.iGF), this.dlM.getCurrentPosition(), i);
            this.dlM.pause();
            ad.a(this.bAG, false);
            setLoadingAnimShow(true);
            al.c(this.iGw, (int) R.drawable.icon_video_midpause);
            this.hYN = 2;
        }
    }

    public void autoContinue() {
        if (!this.iGB) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hYN == 2) {
            this.iGF = i;
            af(33, zk(i), this.dlM.getCurrentPosition());
            this.iGD = this.dlM.getCurrentPosition();
            this.dlM.start();
            if (this.iGy) {
                ad.a(this.bAG, true);
            }
            setLoadingAnimShow(false);
            al.c(this.iGw, (int) R.drawable.icon_video_midplay);
            this.hYN = 1;
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlayStarted() {
        return getPlayStatus() != -1;
    }

    @Override // com.baidu.tieba.recapp.i
    public boolean isPlaying() {
        return getPlayStatus() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startLoadingAnim() {
        if (this.irX != null) {
            this.irX.setAlpha(1.0f);
            this.irX.setVisibility(0);
            this.irX.y(true);
            this.irX.setMinAndMaxFrame(14, 80);
            this.irX.bo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cfU();
        if (z) {
            this.irX.setAlpha(1.0f);
            this.irX.setVisibility(0);
            return;
        }
        this.irX.setVisibility(8);
    }

    private void cfU() {
        if (this.irX != null) {
            this.irX.setFrame(0);
            this.irX.cancelAnimation();
        }
    }

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        autoPlay(0);
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        stopPlay(true);
    }

    public void stopPlay(boolean z) {
        if (this.dlM.getCurrentPosition() > 0 && this.hYN != -1 && z) {
            int i = 32;
            int currentPosition = this.dlM.getCurrentPosition();
            if (this.dlM.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, zk(this.iGF), currentPosition, this.dlM.isPlaying());
        }
        cfV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfV() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hZc);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGG);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGH);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dlM.stopPlayback();
        this.hYN = -1;
        ad.a(this.bAG, false);
        qh(false);
        this.gnW.setForegroundDrawable(0);
        this.gnW.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.iGw, (int) R.drawable.icon_video_midpause);
        this.iGx.aBP();
        this.hYU.setVisibility(8);
        if (this.hYM != null) {
            this.iGr.setText(StringUtils.translateSecondsToString(this.hYM.video_duration.intValue()));
            this.iGr.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.deD = null;
        this.iGC = false;
        MessageManager.getInstance().unRegisterListener(this.iGI);
        MessageManager.getInstance().unRegisterListener(this.isC);
        MessageManager.getInstance().unRegisterListener(this.fqt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zk(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
        }
        return 1;
    }

    @Override // com.baidu.tieba.recapp.i
    public View getVideoContainer() {
        return this;
    }

    @Override // com.baidu.tieba.recapp.i
    public String getPlayUrl() {
        return this.hYM != null ? this.hYM.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(boolean z) {
        if (z) {
            if (this.deD != null) {
                this.deD.setVolume(1.0f, 1.0f);
            }
            al.c(this.iGt, (int) R.drawable.ad_icon_sound_open);
            al.c(this.iGs, (int) R.drawable.icon_vedio_pronunciation_small_white);
            if (this.hYN == 1) {
                ad.a(this.bAG, true);
            }
        } else {
            if (this.deD != null) {
                this.deD.setVolume(0.0f, 0.0f);
            }
            al.c(this.iGt, (int) R.drawable.ad_icon_sound_close);
            al.c(this.iGs, (int) R.drawable.icon_vedio_npronunciation_small_white);
            ad.a(this.bAG, false);
        }
        this.iGy = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hYN;
    }

    public VideoInfo getData() {
        return this.hYM;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hYW;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iGp = advertAppInfo;
        this.iGq = i;
        this.ayL = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iGp, 303, i, zk(this.iGF), this.hYM.video_duration.intValue(), this.mDuration, -1);
        if (this.iCX != null) {
            this.iCX.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(int i, int i2, int i3) {
        A(i, i2, i3, -1);
    }

    private void h(int i, int i2, int i3, boolean z) {
        a(i, i2, i3, -1, z);
    }

    private void A(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, true);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.iGp != null && this.hYM != null) {
            this.iGp.page = this.ayL;
            com.baidu.tieba.recapp.report.c.cfH().a(f.a(this.iGp, i, this.iGq, i2, this.hYM.video_duration.intValue(), a.mo(i3), i4));
            if (z && i != 31 && i != 33 && i != 35 && i != 2) {
                if (i == 34) {
                    str = "com";
                } else if (i == 36) {
                    str = Config.EXCEPTION_PART;
                } else {
                    str = ImageViewerConfig.FROM_OTHER;
                    if (i4 == 1) {
                        str = "hide";
                    } else if (i4 == 0) {
                        str = "cl_pau";
                    }
                }
                if ("DETAIL".equals(this.ayL)) {
                    str2 = "det";
                } else if ("FRS".equals(this.ayL)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.ayL)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.iGD, i3, this.mDuration, str2, zl(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.izG != null && "cpv".equals(this.izG.iAD) && !TextUtils.isEmpty(this.izG.iAE)) {
            new com.baidu.tieba.recapp.request.a(this.izG.iAE).a(str, i, i2, i3, str2, str3);
        }
    }

    private String zl(int i) {
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
            this.iGn = view;
            this.iGo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGG);
            if (this.afk != null) {
                this.afk.cancel();
            }
            this.iGv.setVisibility(0);
            if (this.hYN == 1) {
                al.c(this.iGw, (int) R.drawable.icon_video_midplay);
                return;
            } else {
                al.c(this.iGw, (int) R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iGv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfW() {
        switch (this.hYN) {
            case -1:
                if (!j.jS() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.jT() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.ho(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).afG();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.iGB = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qg(true);
                    return;
                }
                return;
            case 2:
                this.iGB = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGG);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.iGG, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfX() {
        if (!this.boh && this.afk != null) {
            this.iGv.startAnimation(this.afk);
            this.boh = true;
        }
    }

    private void Ti() {
        if (this.mPageContext != null) {
            this.afk = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.afk.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.iGv.setVisibility(8);
                    DistributeVideoView.this.boh = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cfY() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGH);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iGH, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(boolean z) {
        if (this.iGs != null && this.mStyle == 1) {
            if (z) {
                this.iGs.setVisibility(0);
                cfY();
                return;
            }
            this.iGs.setVisibility(8);
        }
    }
}
