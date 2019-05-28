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
    private g.a cRS;
    private g.f cRT;
    private g.e cRV;
    private g deC;
    private QuickVideoView dlM;
    private CustomMessageListener fqt;
    private ForeDrawableImageView gnU;
    private VideoInfo hYL;
    private int hYM;
    private View hYT;
    private long hYV;
    private Runnable hZb;
    private ViewGroup iCU;
    private d iCV;
    private e iCW;
    boolean iGA;
    private boolean iGB;
    private int iGC;
    boolean iGD;
    private int iGE;
    private Runnable iGF;
    private Runnable iGG;
    private CustomMessageListener iGH;
    private View iGm;
    private boolean iGn;
    private AdvertAppInfo iGo;
    private int iGp;
    private TextView iGq;
    private ImageView iGr;
    private ImageView iGs;
    private TextView iGt;
    private View iGu;
    private ImageView iGv;
    private VideoControllerView iGw;
    private boolean iGx;
    private long iGy;
    private b iGz;
    private TBLottieAnimationView irW;
    private CustomMessageListener isB;
    private AdCard.a izF;
    private AdCard.f izG;
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
    public void cch() {
        if (this.irW != null) {
            this.irW.clearAnimation();
            this.irW.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.irW.setVisibility(8);
                    DistributeVideoView.this.gnU.setVisibility(8);
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGx);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iGq.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iGw.setPlayer(DistributeVideoView.this.dlM);
                        DistributeVideoView.this.iGw.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hYL.video_duration.intValue()));
                        DistributeVideoView.this.iGw.showProgress();
                        DistributeVideoView.this.qf(true);
                        com.baidu.adp.lib.g.e.iB().removeCallbacks(DistributeVideoView.this.iGF);
                        com.baidu.adp.lib.g.e.iB().postDelayed(DistributeVideoView.this.iGF, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hYV = DistributeVideoView.this.dlM.getCurrentPosition();
                    DistributeVideoView.this.qg(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.irW.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iGn = false;
        this.bAG = null;
        this.hYM = -1;
        this.hYV = 0L;
        this.iGx = false;
        this.iGy = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGA = false;
        this.iGB = false;
        this.iGD = false;
        this.iGE = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYT) {
                    DistributeVideoView.this.hYT.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGs || view == DistributeVideoView.this.iGr) {
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGx ? false : true);
                } else if (view == DistributeVideoView.this.irW || view == DistributeVideoView.this.iGv) {
                    DistributeVideoView.this.cfV();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGo == null || !DistributeVideoView.this.iGo.abG()) {
                    DistributeVideoView.this.cfV();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGo != null) {
                        WebVideoActivity.izz = new WebVideoActivity.a();
                        WebVideoActivity.izz.izJ = DistributeVideoView.this.iGo;
                        WebVideoActivity.izz.ayL = "DETAIL";
                        WebVideoActivity.izz.mPageNum = DistributeVideoView.this.iGp;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGo.bDU, true, true, true, DistributeVideoView.this.hYL.video_url, DistributeVideoView.this.hYL.thumbnail_url, DistributeVideoView.this.hYL.video_width.intValue() / DistributeVideoView.this.hYL.video_height.intValue(), DistributeVideoView.this.hYL.video_duration.intValue());
                    if (DistributeVideoView.this.izF != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izF.iAC);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izF.iAD);
                    }
                    if (DistributeVideoView.this.izG != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izG.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zo(DistributeVideoView.this.parallelChargeInfo.gXP);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXS.iterator();
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
                        if (DistributeVideoView.this.hYM != 1) {
                            if (DistributeVideoView.this.dlM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYM = 1;
                                DistributeVideoView.this.cch();
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
                        if (DistributeVideoView.this.hYM == 1) {
                            if (DistributeVideoView.this.hYV == DistributeVideoView.this.dlM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYV = DistributeVideoView.this.dlM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGC = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deC = gVar;
                    DistributeVideoView.this.deC.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGx && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qe(false);
                    }
                }
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iGo != null) {
                    if (DistributeVideoView.this.iGD && "DETAIL".equals(DistributeVideoView.this.iGo.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), 0);
                }
                return false;
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cfU();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), gVar.getCurrentPosition());
                DistributeVideoView.this.gnU.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYT.setVisibility(0);
                return true;
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGy = System.currentTimeMillis();
                DistributeVideoView.this.iGD = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), gVar.getDuration());
                DistributeVideoView.this.cfU();
                if (DistributeVideoView.this.iCW != null) {
                    DistributeVideoView.this.iCW.cfK();
                    DistributeVideoView.this.iGq.setVisibility(8);
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
        this.hZb = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYL != null && DistributeVideoView.this.dlM != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfW();
            }
        };
        this.iGG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qg(false);
            }
        };
        this.isB = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGB) {
                            DistributeVideoView.this.qe(true);
                            return;
                        } else {
                            DistributeVideoView.this.qe(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGB = DistributeVideoView.this.iGx;
                    DistributeVideoView.this.qe(true);
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
                        DistributeVideoView.this.qe(true);
                    }
                }
            }
        };
        this.iGH = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.iGn = false;
        this.bAG = null;
        this.hYM = -1;
        this.hYV = 0L;
        this.iGx = false;
        this.iGy = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGA = false;
        this.iGB = false;
        this.iGD = false;
        this.iGE = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYT) {
                    DistributeVideoView.this.hYT.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGs || view == DistributeVideoView.this.iGr) {
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGx ? false : true);
                } else if (view == DistributeVideoView.this.irW || view == DistributeVideoView.this.iGv) {
                    DistributeVideoView.this.cfV();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGo == null || !DistributeVideoView.this.iGo.abG()) {
                    DistributeVideoView.this.cfV();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGo != null) {
                        WebVideoActivity.izz = new WebVideoActivity.a();
                        WebVideoActivity.izz.izJ = DistributeVideoView.this.iGo;
                        WebVideoActivity.izz.ayL = "DETAIL";
                        WebVideoActivity.izz.mPageNum = DistributeVideoView.this.iGp;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGo.bDU, true, true, true, DistributeVideoView.this.hYL.video_url, DistributeVideoView.this.hYL.thumbnail_url, DistributeVideoView.this.hYL.video_width.intValue() / DistributeVideoView.this.hYL.video_height.intValue(), DistributeVideoView.this.hYL.video_duration.intValue());
                    if (DistributeVideoView.this.izF != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izF.iAC);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izF.iAD);
                    }
                    if (DistributeVideoView.this.izG != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izG.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zo(DistributeVideoView.this.parallelChargeInfo.gXP);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXS.iterator();
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
                        if (DistributeVideoView.this.hYM != 1) {
                            if (DistributeVideoView.this.dlM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYM = 1;
                                DistributeVideoView.this.cch();
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
                        if (DistributeVideoView.this.hYM == 1) {
                            if (DistributeVideoView.this.hYV == DistributeVideoView.this.dlM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYV = DistributeVideoView.this.dlM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGC = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deC = gVar;
                    DistributeVideoView.this.deC.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGx && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qe(false);
                    }
                }
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iGo != null) {
                    if (DistributeVideoView.this.iGD && "DETAIL".equals(DistributeVideoView.this.iGo.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), 0);
                }
                return false;
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cfU();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), gVar.getCurrentPosition());
                DistributeVideoView.this.gnU.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYT.setVisibility(0);
                return true;
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGy = System.currentTimeMillis();
                DistributeVideoView.this.iGD = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), gVar.getDuration());
                DistributeVideoView.this.cfU();
                if (DistributeVideoView.this.iCW != null) {
                    DistributeVideoView.this.iCW.cfK();
                    DistributeVideoView.this.iGq.setVisibility(8);
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
        this.hZb = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYL != null && DistributeVideoView.this.dlM != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfW();
            }
        };
        this.iGG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qg(false);
            }
        };
        this.isB = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGB) {
                            DistributeVideoView.this.qe(true);
                            return;
                        } else {
                            DistributeVideoView.this.qe(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGB = DistributeVideoView.this.iGx;
                    DistributeVideoView.this.qe(true);
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
                        DistributeVideoView.this.qe(true);
                    }
                }
            }
        };
        this.iGH = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.iGn = false;
        this.bAG = null;
        this.hYM = -1;
        this.hYV = 0L;
        this.iGx = false;
        this.iGy = 0L;
        this.mStyle = 1;
        this.boh = false;
        this.iGA = false;
        this.iGB = false;
        this.iGD = false;
        this.iGE = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hYT) {
                    DistributeVideoView.this.hYT.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iGs || view == DistributeVideoView.this.iGr) {
                    DistributeVideoView.this.qe(DistributeVideoView.this.iGx ? false : true);
                } else if (view == DistributeVideoView.this.irW || view == DistributeVideoView.this.iGv) {
                    DistributeVideoView.this.cfV();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iGo == null || !DistributeVideoView.this.iGo.abG()) {
                    DistributeVideoView.this.cfV();
                } else {
                    DistributeVideoView.this.af(2, 1, 0);
                    if (DistributeVideoView.this.iGo != null) {
                        WebVideoActivity.izz = new WebVideoActivity.a();
                        WebVideoActivity.izz.izJ = DistributeVideoView.this.iGo;
                        WebVideoActivity.izz.ayL = "DETAIL";
                        WebVideoActivity.izz.mPageNum = DistributeVideoView.this.iGp;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVo) ? DistributeVideoView.this.aVo : DistributeVideoView.this.iGo.bDU, true, true, true, DistributeVideoView.this.hYL.video_url, DistributeVideoView.this.hYL.thumbnail_url, DistributeVideoView.this.hYL.video_width.intValue() / DistributeVideoView.this.hYL.video_height.intValue(), DistributeVideoView.this.hYL.video_duration.intValue());
                    if (DistributeVideoView.this.izF != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.izF.iAC);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.izF.iAD);
                    }
                    if (DistributeVideoView.this.izG != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.izG.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.zo(DistributeVideoView.this.parallelChargeInfo.gXP);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gXS.iterator();
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
                        if (DistributeVideoView.this.hYM != 1) {
                            if (DistributeVideoView.this.dlM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hYM = 1;
                                DistributeVideoView.this.cch();
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
                        if (DistributeVideoView.this.hYM == 1) {
                            if (DistributeVideoView.this.hYV == DistributeVideoView.this.dlM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hYV = DistributeVideoView.this.dlM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cRT = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iGC = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.deC = gVar;
                    DistributeVideoView.this.deC.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iGx && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qe(false);
                    }
                }
            }
        };
        this.cRV = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iGo != null) {
                    if (DistributeVideoView.this.iGD && "DETAIL".equals(DistributeVideoView.this.iGo.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.af(i3, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), 0);
                }
                return false;
            }
        };
        this.cIx = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cfU();
                DistributeVideoView.this.af(36, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), gVar.getCurrentPosition());
                DistributeVideoView.this.gnU.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hYT.setVisibility(0);
                return true;
            }
        };
        this.cRS = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iGy = System.currentTimeMillis();
                DistributeVideoView.this.iGD = true;
                DistributeVideoView.this.af(34, DistributeVideoView.this.zk(DistributeVideoView.this.iGE), gVar.getDuration());
                DistributeVideoView.this.cfU();
                if (DistributeVideoView.this.iCW != null) {
                    DistributeVideoView.this.iCW.cfK();
                    DistributeVideoView.this.iGq.setVisibility(8);
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
        this.hZb = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hYL != null && DistributeVideoView.this.dlM != null) {
                    DistributeVideoView.this.zj(1);
                }
            }
        };
        this.iGF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cfW();
            }
        };
        this.iGG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qg(false);
            }
        };
        this.isB = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iGB) {
                            DistributeVideoView.this.qe(true);
                            return;
                        } else {
                            DistributeVideoView.this.qe(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iGB = DistributeVideoView.this.iGx;
                    DistributeVideoView.this.qe(true);
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
                        DistributeVideoView.this.qe(true);
                    }
                }
            }
        };
        this.iGH = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.iGz = adCard;
        if (this.iGz != null) {
            this.parallelChargeInfo = this.iGz.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dlM = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.irW = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gnU = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iGq = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.hYT = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iGt = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iGr = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iGu = this.mRootView.findViewById(R.id.distribute_control);
            this.iGv = (ImageView) this.iGu.findViewById(R.id.distribute_play_icon);
            this.iGs = (ImageView) this.iGu.findViewById(R.id.distribute_voice);
            this.iGw = (VideoControllerView) this.iGu.findViewById(R.id.distribute_process);
            this.iCU = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iCV = new d(context, this.iCU);
            this.irW.setAnimation(R.raw.lotti_video_loading);
            this.irW.setFrame(0);
        }
    }

    private boolean bXp() {
        return this.mStyle == 1 ? q.bXp() : j.jT();
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
        this.izF = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.izG = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYL = videoInfo;
        this.mDuration = this.hYL.video_duration.intValue() * 1000;
        this.bAG = new WeakReference<>(this.mContext.getApplicationContext());
        cfU();
        al.l(this, R.color.cp_bg_line_d);
        int af = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.hYL.video_width.intValue() > 0 ? (this.hYL.video_height.intValue() * af) / this.hYL.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gnU.setDefaultErrorResource(0);
        this.gnU.setDefaultResource(0);
        this.gnU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnU.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dlM.setOnPreparedListener(this.cRT);
        this.dlM.setOnErrorListener(this.cIx);
        this.dlM.setOnCompletionListener(this.cRS);
        this.dlM.setOnOutInfoListener(this.cRV);
        this.dlM.setOnSurfaceDestroyedListener(this.cIB);
        al.j(this.iGq, R.color.cp_cont_m);
        this.iGq.setText(StringUtils.translateSecondsToString(this.hYL.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iGx = false;
            al.c(this.iGr, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iGr.setVisibility(8);
        } else {
            this.iGx = true;
            al.c(this.iGs, (int) R.drawable.ad_icon_sound_open);
            this.iGr.setVisibility(8);
        }
        this.iGs.setOnClickListener(this.mOnClickListener);
        this.iGr.setOnClickListener(this.mOnClickListener);
        this.hYT.setOnClickListener(this.mOnClickListener);
        this.hYT.setVisibility(8);
        al.l(this.hYT, R.color.black_alpha80);
        al.j(this.iGt, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iGq.setVisibility(0);
            return;
        }
        this.iGq.setVisibility(8);
        this.iGv.setOnClickListener(this.mOnClickListener);
        this.irW.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hYL = videoInfo;
        this.bAG = new WeakReference<>(this.mContext.getApplicationContext());
        cfU();
        al.l(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gnU.setDefaultErrorResource(0);
        this.gnU.setDefaultResource(0);
        this.gnU.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.gnU.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dlM.setOnPreparedListener(this.cRT);
        this.dlM.setOnErrorListener(this.cIx);
        this.dlM.setOnCompletionListener(this.cRS);
        this.dlM.setOnOutInfoListener(this.cRV);
        this.dlM.setOnSurfaceDestroyedListener(this.cIB);
        al.j(this.iGq, R.color.cp_cont_m);
        this.iGq.setText(StringUtils.translateSecondsToString(this.hYL.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iGx = false;
            al.c(this.iGr, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iGr.setVisibility(8);
        } else {
            this.iGx = true;
            al.c(this.iGs, (int) R.drawable.ad_icon_sound_open);
            this.iGr.setVisibility(8);
        }
        this.iGs.setOnClickListener(this.mOnClickListener);
        this.iGr.setOnClickListener(this.mOnClickListener);
        this.hYT.setOnClickListener(this.mOnClickListener);
        this.hYT.setVisibility(8);
        al.l(this.hYT, R.color.black_alpha80);
        al.j(this.iGt, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.iGq.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iGq.setVisibility(8);
        this.iGv.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iCW = this.iCV.a(this.izG, this.iCW);
        if (this.iCW != null) {
            this.iCW.setPageContext(this.mPageContext);
            this.iCW.c(this.iGz);
            this.iCW.setAdvertAppInfo(advertAppInfo);
            this.iCW.a(this.izG);
            this.iCW.cfL();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iCW != null) {
            this.iCW.setDownloadAppCallback(cVar);
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
        this.cRS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zj(int i) {
        this.iGE = i;
        if (this.hYL != null && this.hYM == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iGy) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iCW != null) {
                    this.iCW.cfL();
                }
                this.dlM.setVideoPath(this.hYL.video_url);
                this.dlM.start();
                this.iGC = this.dlM.getCurrentPosition();
                al.c(this.iGv, (int) R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.hYT.setVisibility(8);
                this.gnU.setForegroundDrawable(0);
                this.hYM = 0;
                if (this.mStyle == 1) {
                    this.iGq.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iGq.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iGH);
                MessageManager.getInstance().registerListener(this.isB);
                MessageManager.getInstance().registerListener(this.fqt);
            }
        }
    }

    public void performPlay() {
        zj(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bXp()) {
            if (i <= 0) {
                zj(1);
                return;
            }
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hZb);
            com.baidu.adp.lib.g.e.iB().postDelayed(this.hZb, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hYM == 1) {
            A(32, zk(this.iGE), this.dlM.getCurrentPosition(), i);
            this.dlM.pause();
            ad.a(this.bAG, false);
            setLoadingAnimShow(true);
            al.c(this.iGv, (int) R.drawable.icon_video_midpause);
            this.hYM = 2;
        }
    }

    public void autoContinue() {
        if (!this.iGA) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hYM == 2) {
            this.iGE = i;
            af(33, zk(i), this.dlM.getCurrentPosition());
            this.iGC = this.dlM.getCurrentPosition();
            this.dlM.start();
            if (this.iGx) {
                ad.a(this.bAG, true);
            }
            setLoadingAnimShow(false);
            al.c(this.iGv, (int) R.drawable.icon_video_midplay);
            this.hYM = 1;
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
        if (this.irW != null) {
            this.irW.setAlpha(1.0f);
            this.irW.setVisibility(0);
            this.irW.y(true);
            this.irW.setMinAndMaxFrame(14, 80);
            this.irW.bo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cfT();
        if (z) {
            this.irW.setAlpha(1.0f);
            this.irW.setVisibility(0);
            return;
        }
        this.irW.setVisibility(8);
    }

    private void cfT() {
        if (this.irW != null) {
            this.irW.setFrame(0);
            this.irW.cancelAnimation();
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
        if (this.dlM.getCurrentPosition() > 0 && this.hYM != -1 && z) {
            int i = 32;
            int currentPosition = this.dlM.getCurrentPosition();
            if (this.dlM.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, zk(this.iGE), currentPosition, this.dlM.isPlaying());
        }
        cfU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfU() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hZb);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGF);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGG);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dlM.stopPlayback();
        this.hYM = -1;
        ad.a(this.bAG, false);
        qg(false);
        this.gnU.setForegroundDrawable(0);
        this.gnU.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.iGv, (int) R.drawable.icon_video_midpause);
        this.iGw.aBP();
        this.hYT.setVisibility(8);
        if (this.hYL != null) {
            this.iGq.setText(StringUtils.translateSecondsToString(this.hYL.video_duration.intValue()));
            this.iGq.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.deC = null;
        this.iGB = false;
        MessageManager.getInstance().unRegisterListener(this.iGH);
        MessageManager.getInstance().unRegisterListener(this.isB);
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
        return this.hYL != null ? this.hYL.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(boolean z) {
        if (z) {
            if (this.deC != null) {
                this.deC.setVolume(1.0f, 1.0f);
            }
            al.c(this.iGs, (int) R.drawable.ad_icon_sound_open);
            al.c(this.iGr, (int) R.drawable.icon_vedio_pronunciation_small_white);
            if (this.hYM == 1) {
                ad.a(this.bAG, true);
            }
        } else {
            if (this.deC != null) {
                this.deC.setVolume(0.0f, 0.0f);
            }
            al.c(this.iGs, (int) R.drawable.ad_icon_sound_close);
            al.c(this.iGr, (int) R.drawable.icon_vedio_npronunciation_small_white);
            ad.a(this.bAG, false);
        }
        this.iGx = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hYM;
    }

    public VideoInfo getData() {
        return this.hYL;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hYV;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iGo = advertAppInfo;
        this.iGp = i;
        this.ayL = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iGo, 303, i, zk(this.iGE), this.hYL.video_duration.intValue(), this.mDuration, -1);
        if (this.iCW != null) {
            this.iCW.e(a);
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
        if (this.iGo != null && this.hYL != null) {
            this.iGo.page = this.ayL;
            com.baidu.tieba.recapp.report.c.cfG().a(f.a(this.iGo, i, this.iGp, i2, this.hYL.video_duration.intValue(), a.mo(i3), i4));
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
                c(str, this.iGC, i3, this.mDuration, str2, zl(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.izF != null && "cpv".equals(this.izF.iAC) && !TextUtils.isEmpty(this.izF.iAD)) {
            new com.baidu.tieba.recapp.request.a(this.izF.iAD).a(str, i, i2, i3, str2, str3);
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
            this.iGm = view;
            this.iGn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qf(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGF);
            if (this.afk != null) {
                this.afk.cancel();
            }
            this.iGu.setVisibility(0);
            if (this.hYM == 1) {
                al.c(this.iGv, (int) R.drawable.icon_video_midplay);
                return;
            } else {
                al.c(this.iGv, (int) R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iGu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfV() {
        switch (this.hYM) {
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
                this.iGA = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qf(true);
                    return;
                }
                return;
            case 2:
                this.iGA = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGF);
                    com.baidu.adp.lib.g.e.iB().postDelayed(this.iGF, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfW() {
        if (!this.boh && this.afk != null) {
            this.iGu.startAnimation(this.afk);
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
                    DistributeVideoView.this.iGu.setVisibility(8);
                    DistributeVideoView.this.boh = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cfX() {
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.iGG);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.iGG, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(boolean z) {
        if (this.iGr != null && this.mStyle == 1) {
            if (z) {
                this.iGr.setVisibility(0);
                cfX();
                return;
            }
            this.iGr.setVisibility(8);
        }
    }
}
