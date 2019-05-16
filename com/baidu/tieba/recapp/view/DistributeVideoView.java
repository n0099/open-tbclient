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
    private QuickVideoView.b cIB;
    private g.b cIx;
    private g.a cRR;
    private g.f cRS;
    private g.e cRU;
    private g deB;
    private QuickVideoView dlL;
    private CustomMessageListener fqs;
    private ForeDrawableImageView gnT;
    private VideoInfo hYI;
    private int hYJ;
    private View hYQ;
    private long hYS;
    private Runnable hYY;
    private ViewGroup iCS;
    private d iCT;
    private e iCU;
    private int iGA;
    boolean iGB;
    private int iGC;
    private Runnable iGD;
    private Runnable iGE;
    private CustomMessageListener iGF;
    private View iGk;
    private boolean iGl;
    private AdvertAppInfo iGm;
    private int iGn;
    private TextView iGo;
    private ImageView iGp;
    private ImageView iGq;
    private TextView iGr;
    private View iGs;
    private ImageView iGt;
    private VideoControllerView iGu;
    private boolean iGv;
    private long iGw;
    private b iGx;
    boolean iGy;
    private boolean iGz;
    private TBLottieAnimationView irT;
    private CustomMessageListener isy;
    private AdCard.a izD;
    private AdCard.f izE;
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
    public void cce() {
        if (this.irT != null) {
            this.irT.clearAnimation();
            this.irT.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.irT.setVisibility(8);
                    DistributeVideoView.this.gnT.setVisibility(8);
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGv);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iGo.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iGu.setPlayer(DistributeVideoView.this.dlL);
                        DistributeVideoView.this.iGu.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hYI.video_duration.intValue()));
                        DistributeVideoView.this.iGu.showProgress();
                        DistributeVideoView.this.qf(true);
                        com.baidu.adp.lib.g.e.iB().removeCallbacks(DistributeVideoView.this.iGD);
                        com.baidu.adp.lib.g.e.iB().postDelayed(DistributeVideoView.this.iGD, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hYS = DistributeVideoView.this.dlL.getCurrentPosition();
                    DistributeVideoView.this.qg(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.irT.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iGl = false;
        this.bAG = null;
        this.hYJ = -1;
        this.hYS = 0L;
        this.iGv = false;
        this.iGw = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGy = false;
        this.iGz = false;
        this.iGB = false;
        this.iGC = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYQ) {
                    DistributeVideoView.this.hYQ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGq || view == DistributeVideoView.this.iGp) {
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGv ? false : true);
                } else if (view == DistributeVideoView.this.irT || view == DistributeVideoView.this.iGt) {
                    DistributeVideoView.this.cfT();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGm == null || !DistributeVideoView.this.iGm.abG()) {
                    DistributeVideoView.this.cfT();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGm != null) {
                        WebVideoActivity.izx = new WebVideoActivity.a();
                        WebVideoActivity.izx.izH = DistributeVideoView.this.iGm;
                        WebVideoActivity.izx.ayL = "DETAIL";
                        WebVideoActivity.izx.mPageNum = DistributeVideoView.this.iGn;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGm.bDU, true, true, true, DistributeVideoView.this.hYI.video_url, DistributeVideoView.this.hYI.thumbnail_url, DistributeVideoView.this.hYI.video_width.intValue() / DistributeVideoView.this.hYI.video_height.intValue(), DistributeVideoView.this.hYI.video_duration.intValue());
                    if (DistributeVideoView.this.izD != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izD.iAA);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izD.iAB);
                    }
                    if (DistributeVideoView.this.izE != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izE.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zo(DistributeVideoView.this.parallelChargeInfo.gXM);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXP.iterator();
                        while (it.hasNext()) {
                            c.zo(it.next());
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
                        if (DistributeVideoView.this.hYJ != 1) {
                            if (DistributeVideoView.this.dlL.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYJ = 1;
                                DistributeVideoView.this.cce();
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
                        if (DistributeVideoView.this.hYJ == 1) {
                            if (DistributeVideoView.this.hYS == DistributeVideoView.this.dlL.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYS = DistributeVideoView.this.dlL.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGA = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deB = gVar;
                    DistributeVideoView.this.deB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGv && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qe(false);
                    }
                }
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iGm != null) {
                    if (DistributeVideoView.this.iGB && "DETAIL".equals(DistributeVideoView.this.iGm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), 0);
                }
                return false;
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cfS();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), gVar.getCurrentPosition());
                DistributeVideoView.this.gnT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYQ.setVisibility(0);
                return true;
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGw = System.currentTimeMillis();
                DistributeVideoView.this.iGB = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), gVar.getDuration());
                DistributeVideoView.this.cfS();
                if (DistributeVideoView.this.iCU != null) {
                    DistributeVideoView.this.iCU.cfI();
                    DistributeVideoView.this.iGo.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hYY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYI != null && DistributeVideoView.this.dlL != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGD = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfU();
            }
        };
        this.iGE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qg(false);
            }
        };
        this.isy = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGz) {
                            DistributeVideoView.this.qe(true);
                            return;
                        } else {
                            DistributeVideoView.this.qe(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGz = DistributeVideoView.this.iGv;
                    DistributeVideoView.this.qe(true);
                }
            }
        };
        this.fqs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qe(true);
                    }
                }
            }
        };
        this.iGF = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qg(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iGl = false;
        this.bAG = null;
        this.hYJ = -1;
        this.hYS = 0L;
        this.iGv = false;
        this.iGw = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGy = false;
        this.iGz = false;
        this.iGB = false;
        this.iGC = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYQ) {
                    DistributeVideoView.this.hYQ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGq || view == DistributeVideoView.this.iGp) {
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGv ? false : true);
                } else if (view == DistributeVideoView.this.irT || view == DistributeVideoView.this.iGt) {
                    DistributeVideoView.this.cfT();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGm == null || !DistributeVideoView.this.iGm.abG()) {
                    DistributeVideoView.this.cfT();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGm != null) {
                        WebVideoActivity.izx = new WebVideoActivity.a();
                        WebVideoActivity.izx.izH = DistributeVideoView.this.iGm;
                        WebVideoActivity.izx.ayL = "DETAIL";
                        WebVideoActivity.izx.mPageNum = DistributeVideoView.this.iGn;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGm.bDU, true, true, true, DistributeVideoView.this.hYI.video_url, DistributeVideoView.this.hYI.thumbnail_url, DistributeVideoView.this.hYI.video_width.intValue() / DistributeVideoView.this.hYI.video_height.intValue(), DistributeVideoView.this.hYI.video_duration.intValue());
                    if (DistributeVideoView.this.izD != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izD.iAA);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izD.iAB);
                    }
                    if (DistributeVideoView.this.izE != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izE.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zo(DistributeVideoView.this.parallelChargeInfo.gXM);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXP.iterator();
                        while (it.hasNext()) {
                            c.zo(it.next());
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
                        if (DistributeVideoView.this.hYJ != 1) {
                            if (DistributeVideoView.this.dlL.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYJ = 1;
                                DistributeVideoView.this.cce();
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
                        if (DistributeVideoView.this.hYJ == 1) {
                            if (DistributeVideoView.this.hYS == DistributeVideoView.this.dlL.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYS = DistributeVideoView.this.dlL.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGA = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deB = gVar;
                    DistributeVideoView.this.deB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGv && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qe(false);
                    }
                }
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iGm != null) {
                    if (DistributeVideoView.this.iGB && "DETAIL".equals(DistributeVideoView.this.iGm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), 0);
                }
                return false;
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cfS();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), gVar.getCurrentPosition());
                DistributeVideoView.this.gnT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYQ.setVisibility(0);
                return true;
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGw = System.currentTimeMillis();
                DistributeVideoView.this.iGB = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), gVar.getDuration());
                DistributeVideoView.this.cfS();
                if (DistributeVideoView.this.iCU != null) {
                    DistributeVideoView.this.iCU.cfI();
                    DistributeVideoView.this.iGo.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hYY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYI != null && DistributeVideoView.this.dlL != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGD = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfU();
            }
        };
        this.iGE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qg(false);
            }
        };
        this.isy = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGz) {
                            DistributeVideoView.this.qe(true);
                            return;
                        } else {
                            DistributeVideoView.this.qe(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGz = DistributeVideoView.this.iGv;
                    DistributeVideoView.this.qe(true);
                }
            }
        };
        this.fqs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qe(true);
                    }
                }
            }
        };
        this.iGF = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qg(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iGl = false;
        this.bAG = null;
        this.hYJ = -1;
        this.hYS = 0L;
        this.iGv = false;
        this.iGw = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGy = false;
        this.iGz = false;
        this.iGB = false;
        this.iGC = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYQ) {
                    DistributeVideoView.this.hYQ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGq || view == DistributeVideoView.this.iGp) {
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGv ? false : true);
                } else if (view == DistributeVideoView.this.irT || view == DistributeVideoView.this.iGt) {
                    DistributeVideoView.this.cfT();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGm == null || !DistributeVideoView.this.iGm.abG()) {
                    DistributeVideoView.this.cfT();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGm != null) {
                        WebVideoActivity.izx = new WebVideoActivity.a();
                        WebVideoActivity.izx.izH = DistributeVideoView.this.iGm;
                        WebVideoActivity.izx.ayL = "DETAIL";
                        WebVideoActivity.izx.mPageNum = DistributeVideoView.this.iGn;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGm.bDU, true, true, true, DistributeVideoView.this.hYI.video_url, DistributeVideoView.this.hYI.thumbnail_url, DistributeVideoView.this.hYI.video_width.intValue() / DistributeVideoView.this.hYI.video_height.intValue(), DistributeVideoView.this.hYI.video_duration.intValue());
                    if (DistributeVideoView.this.izD != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izD.iAA);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izD.iAB);
                    }
                    if (DistributeVideoView.this.izE != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izE.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zo(DistributeVideoView.this.parallelChargeInfo.gXM);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXP.iterator();
                        while (it.hasNext()) {
                            c.zo(it.next());
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
                        if (DistributeVideoView.this.hYJ != 1) {
                            if (DistributeVideoView.this.dlL.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYJ = 1;
                                DistributeVideoView.this.cce();
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
                        if (DistributeVideoView.this.hYJ == 1) {
                            if (DistributeVideoView.this.hYS == DistributeVideoView.this.dlL.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYS = DistributeVideoView.this.dlL.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRS = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGA = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deB = gVar;
                    DistributeVideoView.this.deB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGv && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qe(false);
                    }
                }
            }
        };
        this.cRU = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iGm != null) {
                    if (DistributeVideoView.this.iGB && "DETAIL".equals(DistributeVideoView.this.iGm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), 0);
                }
                return false;
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cfS();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), gVar.getCurrentPosition());
                DistributeVideoView.this.gnT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYQ.setVisibility(0);
                return true;
            }
        };
        this.cRR = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGw = System.currentTimeMillis();
                DistributeVideoView.this.iGB = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGC), gVar.getDuration());
                DistributeVideoView.this.cfS();
                if (DistributeVideoView.this.iCU != null) {
                    DistributeVideoView.this.iCU.cfI();
                    DistributeVideoView.this.iGo.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cIB = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hYY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYI != null && DistributeVideoView.this.dlL != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGD = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfU();
            }
        };
        this.iGE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qg(false);
            }
        };
        this.isy = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGz) {
                            DistributeVideoView.this.qe(true);
                            return;
                        } else {
                            DistributeVideoView.this.qe(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGz = DistributeVideoView.this.iGv;
                    DistributeVideoView.this.qe(true);
                }
            }
        };
        this.fqs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qe(true);
                    }
                }
            }
        };
        this.iGF = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qg(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aVo = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iGx = adCard;
        if (this.iGx != null) {
            this.parallelChargeInfo = this.iGx.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dlL = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.irT = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gnT = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iGo = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.hYQ = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iGr = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iGp = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iGs = this.mRootView.findViewById(R.id.distribute_control);
            this.iGt = (ImageView) this.iGs.findViewById(R.id.distribute_play_icon);
            this.iGq = (ImageView) this.iGs.findViewById(R.id.distribute_voice);
            this.iGu = (VideoControllerView) this.iGs.findViewById(R.id.distribute_process);
            this.iCS = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iCT = new d(context, this.iCS);
            this.irT.setAnimation(R.raw.lotti_video_loading);
            this.irT.setFrame(0);
        }
    }

    private boolean bXm() {
        return this.mStyle == 1 ? q.bXm() : j.jT();
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
        this.izD = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.izE = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYI = videoInfo;
        this.mDuration = this.hYI.video_duration.intValue() * 1000;
        this.bAG = new WeakReference<>(this.mContext.getApplicationContext());
        cfS();
        al.l(this, R.color.cp_bg_line_d);
        int af = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.hYI.video_width.intValue() > 0 ? (this.hYI.video_height.intValue() * af) / this.hYI.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gnT.setDefaultErrorResource(0);
        this.gnT.setDefaultResource(0);
        this.gnT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnT.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dlL.setOnPreparedListener(this.cRS);
        this.dlL.setOnErrorListener(this.cIx);
        this.dlL.setOnCompletionListener(this.cRR);
        this.dlL.setOnOutInfoListener(this.cRU);
        this.dlL.setOnSurfaceDestroyedListener(this.cIB);
        al.j(this.iGo, R.color.cp_cont_m);
        this.iGo.setText(StringUtils.translateSecondsToString(this.hYI.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iGv = false;
            al.c(this.iGp, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iGp.setVisibility(8);
        } else {
            this.iGv = true;
            al.c(this.iGq, (int) R.drawable.ad_icon_sound_open);
            this.iGp.setVisibility(8);
        }
        this.iGq.setOnClickListener(this.mOnClickListener);
        this.iGp.setOnClickListener(this.mOnClickListener);
        this.hYQ.setOnClickListener(this.mOnClickListener);
        this.hYQ.setVisibility(8);
        al.l(this.hYQ, R.color.black_alpha80);
        al.j(this.iGr, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iGo.setVisibility(0);
            return;
        }
        this.iGo.setVisibility(8);
        this.iGt.setOnClickListener(this.mOnClickListener);
        this.irT.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYI = videoInfo;
        this.bAG = new WeakReference<>(this.mContext.getApplicationContext());
        cfS();
        al.l(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gnT.setDefaultErrorResource(0);
        this.gnT.setDefaultResource(0);
        this.gnT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnT.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dlL.setOnPreparedListener(this.cRS);
        this.dlL.setOnErrorListener(this.cIx);
        this.dlL.setOnCompletionListener(this.cRR);
        this.dlL.setOnOutInfoListener(this.cRU);
        this.dlL.setOnSurfaceDestroyedListener(this.cIB);
        al.j(this.iGo, R.color.cp_cont_m);
        this.iGo.setText(StringUtils.translateSecondsToString(this.hYI.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iGv = false;
            al.c(this.iGp, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iGp.setVisibility(8);
        } else {
            this.iGv = true;
            al.c(this.iGq, (int) R.drawable.ad_icon_sound_open);
            this.iGp.setVisibility(8);
        }
        this.iGq.setOnClickListener(this.mOnClickListener);
        this.iGp.setOnClickListener(this.mOnClickListener);
        this.hYQ.setOnClickListener(this.mOnClickListener);
        this.hYQ.setVisibility(8);
        al.l(this.hYQ, R.color.black_alpha80);
        al.j(this.iGr, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.iGo.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iGo.setVisibility(8);
        this.iGt.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iCU = this.iCT.a(this.izE, this.iCU);
        if (this.iCU != null) {
            this.iCU.setPageContext(this.mPageContext);
            this.iCU.c(this.iGx);
            this.iCU.setAdvertAppInfo(advertAppInfo);
            this.iCU.a(this.izE);
            this.iCU.cfJ();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iCU != null) {
            this.iCU.setDownloadAppCallback(cVar);
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
        this.cRR = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        this.iGC = i;
        if (this.hYI != null && this.hYJ == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iGw) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iCU != null) {
                    this.iCU.cfJ();
                }
                this.dlL.setVideoPath(this.hYI.video_url);
                this.dlL.start();
                this.iGA = this.dlL.getCurrentPosition();
                al.c(this.iGt, (int) R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.hYQ.setVisibility(8);
                this.gnT.setForegroundDrawable(0);
                this.hYJ = 0;
                if (this.mStyle == 1) {
                    this.iGo.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iGo.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iGF);
                MessageManager.getInstance().registerListener(this.isy);
                MessageManager.getInstance().registerListener(this.fqs);
            }
        }
    }

    public void performPlay() {
        zj(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bXm()) {
            if (i <= 0) {
                zj(1);
                return;
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hYY);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.hYY, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hYJ == 1) {
            A(32, zk(this.iGC), this.dlL.getCurrentPosition(), i);
            this.dlL.pause();
            ad.a(this.bAG, false);
            setLoadingAnimShow(true);
            al.c(this.iGt, (int) R.drawable.icon_video_midpause);
            this.hYJ = 2;
        }
    }

    public void autoContinue() {
        if (!this.iGy) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hYJ == 2) {
            this.iGC = i;
            af(33, zk(i), this.dlL.getCurrentPosition());
            this.iGA = this.dlL.getCurrentPosition();
            this.dlL.start();
            if (this.iGv) {
                ad.a(this.bAG, true);
            }
            setLoadingAnimShow(false);
            al.c(this.iGt, (int) R.drawable.icon_video_midplay);
            this.hYJ = 1;
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
        if (this.irT != null) {
            this.irT.setAlpha(1.0f);
            this.irT.setVisibility(0);
            this.irT.y(true);
            this.irT.setMinAndMaxFrame(14, 80);
            this.irT.bo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cfR();
        if (z) {
            this.irT.setAlpha(1.0f);
            this.irT.setVisibility(0);
            return;
        }
        this.irT.setVisibility(8);
    }

    private void cfR() {
        if (this.irT != null) {
            this.irT.setFrame(0);
            this.irT.cancelAnimation();
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
        if (this.dlL.getCurrentPosition() > 0 && this.hYJ != -1 && z) {
            int i = 32;
            int currentPosition = this.dlL.getCurrentPosition();
            if (this.dlL.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, zk(this.iGC), currentPosition, this.dlL.isPlaying());
        }
        cfS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfS() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hYY);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGD);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGE);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dlL.stopPlayback();
        this.hYJ = -1;
        ad.a(this.bAG, false);
        qg(false);
        this.gnT.setForegroundDrawable(0);
        this.gnT.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.iGt, (int) R.drawable.icon_video_midpause);
        this.iGu.aBM();
        this.hYQ.setVisibility(8);
        if (this.hYI != null) {
            this.iGo.setText(StringUtils.translateSecondsToString(this.hYI.video_duration.intValue()));
            this.iGo.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.deB = null;
        this.iGz = false;
        MessageManager.getInstance().unRegisterListener(this.iGF);
        MessageManager.getInstance().unRegisterListener(this.isy);
        MessageManager.getInstance().unRegisterListener(this.fqs);
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
        return this.hYI != null ? this.hYI.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(boolean z) {
        if (z) {
            if (this.deB != null) {
                this.deB.setVolume(1.0f, 1.0f);
            }
            al.c(this.iGq, (int) R.drawable.ad_icon_sound_open);
            al.c(this.iGp, (int) R.drawable.icon_vedio_pronunciation_small_white);
            if (this.hYJ == 1) {
                ad.a(this.bAG, true);
            }
        } else {
            if (this.deB != null) {
                this.deB.setVolume(0.0f, 0.0f);
            }
            al.c(this.iGq, (int) R.drawable.ad_icon_sound_close);
            al.c(this.iGp, (int) R.drawable.icon_vedio_npronunciation_small_white);
            ad.a(this.bAG, false);
        }
        this.iGv = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hYJ;
    }

    public VideoInfo getData() {
        return this.hYI;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hYS;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iGm = advertAppInfo;
        this.iGn = i;
        this.ayL = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iGm, 303, i, zk(this.iGC), this.hYI.video_duration.intValue(), this.mDuration, -1);
        if (this.iCU != null) {
            this.iCU.e(a);
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
        if (this.iGm != null && this.hYI != null) {
            this.iGm.page = this.ayL;
            com.baidu.tieba.recapp.report.c.cfE().a(f.a(this.iGm, i, this.iGn, i2, this.hYI.video_duration.intValue(), a.mo(i3), i4));
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
                c(str, this.iGA, i3, this.mDuration, str2, zl(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.izD != null && "cpv".equals(this.izD.iAA) && !TextUtils.isEmpty(this.izD.iAB)) {
            new com.baidu.tieba.recapp.request.a(this.izD.iAB).a(str, i, i2, i3, str2, str3);
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
            this.iGk = view;
            this.iGl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGD);
            if (this.afk != null) {
                this.afk.cancel();
            }
            this.iGs.setVisibility(0);
            if (this.hYJ == 1) {
                al.c(this.iGt, (int) R.drawable.icon_video_midplay);
                return;
            } else {
                al.c(this.iGt, (int) R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iGs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfT() {
        switch (this.hYJ) {
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
                this.iGy = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qf(true);
                    return;
                }
                return;
            case 2:
                this.iGy = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGD);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.iGD, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfU() {
        if (!this.boh && this.afk != null) {
            this.iGs.startAnimation(this.afk);
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
                    DistributeVideoView.this.iGs.setVisibility(8);
                    DistributeVideoView.this.boh = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cfV() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGE);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iGE, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        if (this.iGp != null && this.mStyle == 1) {
            if (z) {
                this.iGp.setVisibility(0);
                cfV();
                return;
            }
            this.iGp.setVisibility(8);
        }
    }
}
