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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.b.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.tbadkCore.t;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes13.dex */
public class DistributeVideoView extends RelativeLayout implements h {
    private WeakReference<Context> ahK;
    private Animation bhy;
    boolean cWe;
    private g eFm;
    private QuickVideoView ePf;
    private g.b emF;
    private QuickVideoView.b emJ;
    private g.a evJ;
    private g.f evK;
    private g.e evM;
    private CustomMessageListener gZT;
    private ForeDrawableImageView hZj;
    private int kgV;
    private CustomMessageListener kkq;
    private AdCard.a krL;
    private AdCard.f krM;
    private ViewGroup kuZ;
    private d kva;
    private e kvb;
    private boolean kxp;
    private ImageView kyA;
    private VideoControllerView kyB;
    private long kyC;
    private boolean kyD;
    private long kyE;
    private b kyF;
    boolean kyG;
    private boolean kyH;
    private int kyI;
    boolean kyJ;
    private int kyK;
    private Runnable kyL;
    private Runnable kyM;
    private Runnable kyN;
    private CustomMessageListener kyO;
    private View kyo;
    private boolean kyp;
    private VideoInfo kyq;
    private AdvertAppInfo kyr;
    private int kys;
    private TBLottieAnimationView kyt;
    private TextView kyu;
    private ImageView kyv;
    private ImageView kyw;
    private View kyx;
    private TextView kyy;
    private View kyz;
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
    private b.a parallelChargeInfo;

    public void jump2DownloadDetailPage() {
        if (this.kyr != null) {
            WebVideoActivity.krF = new WebVideoActivity.a();
            WebVideoActivity.krF.krP = this.kyr;
            WebVideoActivity.krF.mPage = "DETAIL";
            WebVideoActivity.krF.mPageNum = this.kys;
            NewWebVideoActivity.krQ = new NewWebVideoActivity.a();
            NewWebVideoActivity.krQ.krP = this.kyr;
            NewWebVideoActivity.krQ.mPage = "DETAIL";
            NewWebVideoActivity.krQ.mPageNum = this.kys;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.kyr.dmu, true, true, true, this.kyq.video_url, this.kyq.thumbnail_url, this.kyq.video_width.intValue() / this.kyq.video_height.intValue(), this.kyq.video_duration.intValue(), this.kyr.dms);
        if (this.krL != null) {
            newWebVideoActivityConfig.setChargeStyle(this.krL.ksN);
            newWebVideoActivityConfig.setChargeUrl(this.krL.ksO);
        }
        if (this.krM != null) {
            newWebVideoActivityConfig.setTailFrame(this.krM.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cla() {
        ac(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.FO(this.parallelChargeInfo.iJu);
            Iterator<String> it = this.parallelChargeInfo.iJx.iterator();
            while (it.hasNext()) {
                c.FO(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKF() {
        if (this.kyt != null) {
            this.kyt.clearAnimation();
            this.kyt.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.kyt.setVisibility(8);
                    DistributeVideoView.this.hZj.setVisibility(8);
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyD);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.kyu.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.kyB.setPlayer(DistributeVideoView.this.ePf);
                        DistributeVideoView.this.kyB.be(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.kyq.video_duration.intValue()));
                        DistributeVideoView.this.kyB.showProgress();
                        DistributeVideoView.this.tn(true);
                        com.baidu.adp.lib.f.e.lb().removeCallbacks(DistributeVideoView.this.kyM);
                        com.baidu.adp.lib.f.e.lb().postDelayed(DistributeVideoView.this.kyM, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.kyC = DistributeVideoView.this.ePf.getCurrentPosition();
                    DistributeVideoView.this.to(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.kyt.setMinFrame(0);
                    DistributeVideoView.this.kyt.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.kyp = false;
        this.ahK = null;
        this.kgV = -1;
        this.kyC = 0L;
        this.kyD = false;
        this.kyE = 0L;
        this.mStyle = 1;
        this.cWe = false;
        this.kyG = false;
        this.kyH = false;
        this.kyJ = false;
        this.kyK = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kyx) {
                    DistributeVideoView.this.kyx.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kyw || view == DistributeVideoView.this.kyv) {
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyD ? false : true);
                } else if (view == DistributeVideoView.this.kyt || view == DistributeVideoView.this.kyA) {
                    DistributeVideoView.this.cOA();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kyr == null || !DistributeVideoView.this.kyr.aIF()) {
                    if (DistributeVideoView.this.kyF instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kyF;
                        if (!adCard.getAdvertAppInfo().aIE() || adCard.directDownload) {
                            DistributeVideoView.this.cOA();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cla();
                        return;
                    }
                    DistributeVideoView.this.cOA();
                } else {
                    if (DistributeVideoView.this.kyr != null) {
                        WebVideoActivity.krF = new WebVideoActivity.a();
                        WebVideoActivity.krF.krP = DistributeVideoView.this.kyr;
                        WebVideoActivity.krF.mPage = "DETAIL";
                        WebVideoActivity.krF.mPageNum = DistributeVideoView.this.kys;
                        NewWebVideoActivity.krQ = new NewWebVideoActivity.a();
                        NewWebVideoActivity.krQ.krP = DistributeVideoView.this.kyr;
                        NewWebVideoActivity.krQ.mPage = "DETAIL";
                        NewWebVideoActivity.krQ.mPageNum = DistributeVideoView.this.kys;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kyr.dmu;
                    if (a.bdA().bdB() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kyq.video_url, DistributeVideoView.this.kyq.thumbnail_url, DistributeVideoView.this.kyq.video_width.intValue() / DistributeVideoView.this.kyq.video_height.intValue(), DistributeVideoView.this.kyq.video_duration.intValue(), DistributeVideoView.this.kyr.dms);
                        if (DistributeVideoView.this.krL != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krL.ksN);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krL.ksO);
                        }
                        if (DistributeVideoView.this.krM != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.krM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kyq.video_url, DistributeVideoView.this.kyq.thumbnail_url, DistributeVideoView.this.kyq.video_width.intValue() / DistributeVideoView.this.kyq.video_height.intValue(), DistributeVideoView.this.kyq.video_duration.intValue());
                        if (DistributeVideoView.this.krL != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krL.ksN);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krL.ksO);
                        }
                        if (DistributeVideoView.this.krM != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.krM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cla();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kgV != 1) {
                            if (DistributeVideoView.this.ePf.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kgV = 1;
                                DistributeVideoView.this.cKF();
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
                        if (DistributeVideoView.this.kgV == 1) {
                            if (DistributeVideoView.this.kyC == DistributeVideoView.this.ePf.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kyC = DistributeVideoView.this.ePf.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kyI = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eFm = gVar;
                    DistributeVideoView.this.eFm.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kyD && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tm(false);
                    }
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kyr != null) {
                    if (DistributeVideoView.this.kyJ && "DETAIL".equals(DistributeVideoView.this.kyr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), 0);
                }
                return false;
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cOz();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), gVar.getCurrentPosition());
                DistributeVideoView.this.hZj.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kyx.setVisibility(0);
                return true;
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kyE = System.currentTimeMillis();
                DistributeVideoView.this.kyJ = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), gVar.getDuration());
                DistributeVideoView.this.cOz();
                if (DistributeVideoView.this.kvb != null) {
                    DistributeVideoView.this.kvb.cOq();
                    DistributeVideoView.this.kyu.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kyL = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kyq != null && DistributeVideoView.this.ePf != null) {
                    DistributeVideoView.this.BQ(1);
                }
            }
        };
        this.kyM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cOB();
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.to(false);
            }
        };
        this.kkq = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kyH) {
                            DistributeVideoView.this.tm(true);
                            return;
                        } else {
                            DistributeVideoView.this.tm(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kyH = DistributeVideoView.this.kyD;
                    DistributeVideoView.this.tm(true);
                }
            }
        };
        this.gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tm(true);
                    }
                }
            }
        };
        this.kyO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.to(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kyp = false;
        this.ahK = null;
        this.kgV = -1;
        this.kyC = 0L;
        this.kyD = false;
        this.kyE = 0L;
        this.mStyle = 1;
        this.cWe = false;
        this.kyG = false;
        this.kyH = false;
        this.kyJ = false;
        this.kyK = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kyx) {
                    DistributeVideoView.this.kyx.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kyw || view == DistributeVideoView.this.kyv) {
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyD ? false : true);
                } else if (view == DistributeVideoView.this.kyt || view == DistributeVideoView.this.kyA) {
                    DistributeVideoView.this.cOA();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kyr == null || !DistributeVideoView.this.kyr.aIF()) {
                    if (DistributeVideoView.this.kyF instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kyF;
                        if (!adCard.getAdvertAppInfo().aIE() || adCard.directDownload) {
                            DistributeVideoView.this.cOA();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cla();
                        return;
                    }
                    DistributeVideoView.this.cOA();
                } else {
                    if (DistributeVideoView.this.kyr != null) {
                        WebVideoActivity.krF = new WebVideoActivity.a();
                        WebVideoActivity.krF.krP = DistributeVideoView.this.kyr;
                        WebVideoActivity.krF.mPage = "DETAIL";
                        WebVideoActivity.krF.mPageNum = DistributeVideoView.this.kys;
                        NewWebVideoActivity.krQ = new NewWebVideoActivity.a();
                        NewWebVideoActivity.krQ.krP = DistributeVideoView.this.kyr;
                        NewWebVideoActivity.krQ.mPage = "DETAIL";
                        NewWebVideoActivity.krQ.mPageNum = DistributeVideoView.this.kys;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kyr.dmu;
                    if (a.bdA().bdB() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kyq.video_url, DistributeVideoView.this.kyq.thumbnail_url, DistributeVideoView.this.kyq.video_width.intValue() / DistributeVideoView.this.kyq.video_height.intValue(), DistributeVideoView.this.kyq.video_duration.intValue(), DistributeVideoView.this.kyr.dms);
                        if (DistributeVideoView.this.krL != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krL.ksN);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krL.ksO);
                        }
                        if (DistributeVideoView.this.krM != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.krM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kyq.video_url, DistributeVideoView.this.kyq.thumbnail_url, DistributeVideoView.this.kyq.video_width.intValue() / DistributeVideoView.this.kyq.video_height.intValue(), DistributeVideoView.this.kyq.video_duration.intValue());
                        if (DistributeVideoView.this.krL != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krL.ksN);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krL.ksO);
                        }
                        if (DistributeVideoView.this.krM != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.krM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cla();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kgV != 1) {
                            if (DistributeVideoView.this.ePf.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kgV = 1;
                                DistributeVideoView.this.cKF();
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
                        if (DistributeVideoView.this.kgV == 1) {
                            if (DistributeVideoView.this.kyC == DistributeVideoView.this.ePf.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kyC = DistributeVideoView.this.ePf.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kyI = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eFm = gVar;
                    DistributeVideoView.this.eFm.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kyD && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tm(false);
                    }
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kyr != null) {
                    if (DistributeVideoView.this.kyJ && "DETAIL".equals(DistributeVideoView.this.kyr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), 0);
                }
                return false;
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cOz();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), gVar.getCurrentPosition());
                DistributeVideoView.this.hZj.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kyx.setVisibility(0);
                return true;
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kyE = System.currentTimeMillis();
                DistributeVideoView.this.kyJ = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), gVar.getDuration());
                DistributeVideoView.this.cOz();
                if (DistributeVideoView.this.kvb != null) {
                    DistributeVideoView.this.kvb.cOq();
                    DistributeVideoView.this.kyu.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kyL = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kyq != null && DistributeVideoView.this.ePf != null) {
                    DistributeVideoView.this.BQ(1);
                }
            }
        };
        this.kyM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cOB();
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.to(false);
            }
        };
        this.kkq = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kyH) {
                            DistributeVideoView.this.tm(true);
                            return;
                        } else {
                            DistributeVideoView.this.tm(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kyH = DistributeVideoView.this.kyD;
                    DistributeVideoView.this.tm(true);
                }
            }
        };
        this.gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tm(true);
                    }
                }
            }
        };
        this.kyO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.to(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kyp = false;
        this.ahK = null;
        this.kgV = -1;
        this.kyC = 0L;
        this.kyD = false;
        this.kyE = 0L;
        this.mStyle = 1;
        this.cWe = false;
        this.kyG = false;
        this.kyH = false;
        this.kyJ = false;
        this.kyK = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kyx) {
                    DistributeVideoView.this.kyx.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kyw || view == DistributeVideoView.this.kyv) {
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyD ? false : true);
                } else if (view == DistributeVideoView.this.kyt || view == DistributeVideoView.this.kyA) {
                    DistributeVideoView.this.cOA();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kyr == null || !DistributeVideoView.this.kyr.aIF()) {
                    if (DistributeVideoView.this.kyF instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kyF;
                        if (!adCard.getAdvertAppInfo().aIE() || adCard.directDownload) {
                            DistributeVideoView.this.cOA();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cla();
                        return;
                    }
                    DistributeVideoView.this.cOA();
                } else {
                    if (DistributeVideoView.this.kyr != null) {
                        WebVideoActivity.krF = new WebVideoActivity.a();
                        WebVideoActivity.krF.krP = DistributeVideoView.this.kyr;
                        WebVideoActivity.krF.mPage = "DETAIL";
                        WebVideoActivity.krF.mPageNum = DistributeVideoView.this.kys;
                        NewWebVideoActivity.krQ = new NewWebVideoActivity.a();
                        NewWebVideoActivity.krQ.krP = DistributeVideoView.this.kyr;
                        NewWebVideoActivity.krQ.mPage = "DETAIL";
                        NewWebVideoActivity.krQ.mPageNum = DistributeVideoView.this.kys;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kyr.dmu;
                    if (a.bdA().bdB() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kyq.video_url, DistributeVideoView.this.kyq.thumbnail_url, DistributeVideoView.this.kyq.video_width.intValue() / DistributeVideoView.this.kyq.video_height.intValue(), DistributeVideoView.this.kyq.video_duration.intValue(), DistributeVideoView.this.kyr.dms);
                        if (DistributeVideoView.this.krL != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krL.ksN);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krL.ksO);
                        }
                        if (DistributeVideoView.this.krM != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.krM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kyq.video_url, DistributeVideoView.this.kyq.thumbnail_url, DistributeVideoView.this.kyq.video_width.intValue() / DistributeVideoView.this.kyq.video_height.intValue(), DistributeVideoView.this.kyq.video_duration.intValue());
                        if (DistributeVideoView.this.krL != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krL.ksN);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krL.ksO);
                        }
                        if (DistributeVideoView.this.krM != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.krM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cla();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kgV != 1) {
                            if (DistributeVideoView.this.ePf.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kgV = 1;
                                DistributeVideoView.this.cKF();
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
                        if (DistributeVideoView.this.kgV == 1) {
                            if (DistributeVideoView.this.kyC == DistributeVideoView.this.ePf.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kyC = DistributeVideoView.this.ePf.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.evK = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kyI = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eFm = gVar;
                    DistributeVideoView.this.eFm.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kyD && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tm(false);
                    }
                }
            }
        };
        this.evM = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.kyr != null) {
                    if (DistributeVideoView.this.kyJ && "DETAIL".equals(DistributeVideoView.this.kyr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), 0);
                }
                return false;
            }
        };
        this.emF = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cOz();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), gVar.getCurrentPosition());
                DistributeVideoView.this.hZj.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kyx.setVisibility(0);
                return true;
            }
        };
        this.evJ = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kyE = System.currentTimeMillis();
                DistributeVideoView.this.kyJ = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.BR(DistributeVideoView.this.kyK), gVar.getDuration());
                DistributeVideoView.this.cOz();
                if (DistributeVideoView.this.kvb != null) {
                    DistributeVideoView.this.kvb.cOq();
                    DistributeVideoView.this.kyu.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.emJ = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kyL = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kyq != null && DistributeVideoView.this.ePf != null) {
                    DistributeVideoView.this.BQ(1);
                }
            }
        };
        this.kyM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cOB();
            }
        };
        this.kyN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.to(false);
            }
        };
        this.kkq = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kyH) {
                            DistributeVideoView.this.tm(true);
                            return;
                        } else {
                            DistributeVideoView.this.tm(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kyH = DistributeVideoView.this.kyD;
                    DistributeVideoView.this.tm(true);
                }
            }
        };
        this.gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tm(true);
                    }
                }
            }
        };
        this.kyO = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.to(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.kyF = adCard;
        if (this.kyF != null) {
            this.parallelChargeInfo = this.kyF.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.ePf = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.kyt = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hZj = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.kyu = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.kyx = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.kyy = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.kyv = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.kyz = this.mRootView.findViewById(R.id.distribute_control);
            this.kyA = (ImageView) this.kyz.findViewById(R.id.distribute_play_icon);
            this.kyw = (ImageView) this.kyz.findViewById(R.id.distribute_voice);
            this.kyB = (VideoControllerView) this.kyz.findViewById(R.id.distribute_process);
            this.kuZ = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.kva = new d(context, this.kuZ);
            this.kyt.setAnimation(R.raw.lotti_video_loading);
            this.kyt.setMinFrame(0);
            this.kyt.setFrame(0);
        }
    }

    private boolean cOx() {
        return this.mStyle == 1 ? t.cOx() : j.isWifiNet();
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
        this.krL = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.krM = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kyq = videoInfo;
        this.mDuration = this.kyq.video_duration.intValue() * 1000;
        this.ahK = new WeakReference<>(this.mContext.getApplicationContext());
        cOz();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.kyq.video_width.intValue() > 0 ? (this.kyq.video_height.intValue() * equipmentWidth) / this.kyq.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hZj.setDefaultErrorResource(0);
        this.hZj.setDefaultResource(0);
        this.hZj.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hZj.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ePf.setOnPreparedListener(this.evK);
        this.ePf.setOnErrorListener(this.emF);
        this.ePf.setOnCompletionListener(this.evJ);
        this.ePf.setOnOutInfoListener(this.evM);
        this.ePf.setOnSurfaceDestroyedListener(this.emJ);
        am.setViewTextColor(this.kyu, (int) R.color.cp_cont_m);
        this.kyu.setText(StringUtils.translateSecondsToString(this.kyq.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kyD = false;
            am.setImageResource(this.kyv, R.drawable.icon_vedio_npronunciation_small_white);
            this.kyv.setVisibility(8);
        } else {
            this.kyD = true;
            am.setImageResource(this.kyw, R.drawable.ad_icon_sound_open);
            this.kyv.setVisibility(8);
        }
        this.kyw.setOnClickListener(this.mOnClickListener);
        this.kyv.setOnClickListener(this.mOnClickListener);
        this.kyx.setOnClickListener(this.mOnClickListener);
        this.kyx.setVisibility(8);
        am.setBackgroundColor(this.kyx, R.color.black_alpha80);
        am.setViewTextColor(this.kyy, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.kyu.setVisibility(0);
            return;
        }
        this.kyu.setVisibility(8);
        this.kyA.setOnClickListener(this.mOnClickListener);
        this.kyt.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kyq = videoInfo;
        this.ahK = new WeakReference<>(this.mContext.getApplicationContext());
        cOz();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hZj.setDefaultErrorResource(0);
        this.hZj.setDefaultResource(0);
        this.hZj.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hZj.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ePf.setOnPreparedListener(this.evK);
        this.ePf.setOnErrorListener(this.emF);
        this.ePf.setOnCompletionListener(this.evJ);
        this.ePf.setOnOutInfoListener(this.evM);
        this.ePf.setOnSurfaceDestroyedListener(this.emJ);
        am.setViewTextColor(this.kyu, (int) R.color.cp_cont_m);
        this.kyu.setText(StringUtils.translateSecondsToString(this.kyq.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kyD = false;
            am.setImageResource(this.kyv, R.drawable.icon_vedio_npronunciation_small_white);
            this.kyv.setVisibility(8);
        } else {
            this.kyD = true;
            am.setImageResource(this.kyw, R.drawable.ad_icon_sound_open);
            this.kyv.setVisibility(8);
        }
        this.kyw.setOnClickListener(this.mOnClickListener);
        this.kyv.setOnClickListener(this.mOnClickListener);
        this.kyx.setOnClickListener(this.mOnClickListener);
        this.kyx.setVisibility(8);
        am.setBackgroundColor(this.kyx, R.color.black_alpha80);
        am.setViewTextColor(this.kyy, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.kyu.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.kyu.setVisibility(8);
        this.kyA.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.kyr;
        }
        this.kvb = this.kva.a(this.krM, this.kvb);
        if (this.kvb != null) {
            this.kvb.setPageContext(this.mPageContext);
            this.kvb.c(this.kyF);
            if (this.kvb instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.kvb).tk(this.kxp);
            }
            this.kvb.setAdvertAppInfo(advertAppInfo);
            this.kvb.a(this.krM);
            this.kvb.cOr();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.kxp = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.kvb != null) {
            this.kvb.setDownloadAppCallback(cVar);
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
            setViewSize(this.mRootView, i2, i3);
            return true;
        }
        setViewSize(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
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

    public void setOnCompleteListener(g.a aVar) {
        this.evJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ(int i) {
        this.kyK = i;
        if (this.kyq != null && this.kgV == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.kyE) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.kvb != null) {
                    this.kvb.cOr();
                }
                this.ePf.setVideoPath(this.kyq.video_url);
                this.ePf.start();
                this.kyI = this.ePf.getCurrentPosition();
                am.setImageResource(this.kyA, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.kyx.setVisibility(8);
                this.hZj.setForegroundDrawable(0);
                this.kgV = 0;
                if (this.mStyle == 1) {
                    this.kyu.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.kyu.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.kyO);
                MessageManager.getInstance().registerListener(this.kkq);
                MessageManager.getInstance().registerListener(this.gZT);
            }
        }
    }

    public void performPlay() {
        BQ(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (cOx()) {
            if (i <= 0) {
                BQ(1);
                return;
            }
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyL);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.kyL, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.kgV == 1) {
            D(32, BR(this.kyK), this.ePf.getCurrentPosition(), i);
            this.ePf.pause();
            af.a(this.ahK, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.kyA, R.drawable.icon_video_midpause);
            this.kgV = 2;
        }
    }

    public void autoContinue() {
        if (!this.kyG) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.kgV == 2) {
            this.kyK = i;
            ac(33, BR(i), this.ePf.getCurrentPosition());
            this.kyI = this.ePf.getCurrentPosition();
            this.ePf.start();
            if (this.kyD) {
                af.a(this.ahK, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.kyA, R.drawable.icon_video_midplay);
            this.kgV = 1;
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
    public void startLoadingAnim() {
        if (this.kyt != null) {
            this.kyt.setAlpha(1.0f);
            this.kyt.setVisibility(0);
            this.kyt.loop(true);
            this.kyt.setMinAndMaxFrame(14, 80);
            this.kyt.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cOy();
        if (z) {
            this.kyt.setAlpha(1.0f);
            this.kyt.setVisibility(0);
            return;
        }
        this.kyt.setVisibility(8);
    }

    private void cOy() {
        if (this.kyt != null) {
            this.kyt.setMinFrame(0);
            this.kyt.setFrame(0);
            this.kyt.cancelAnimation();
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
        if (this.ePf.getCurrentPosition() > 0 && this.kgV != -1 && z) {
            int i = 32;
            int currentPosition = this.ePf.getCurrentPosition();
            if (this.ePf.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, BR(this.kyK), currentPosition, this.ePf.isPlaying());
        }
        cOz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOz() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyL);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyM);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyN);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.ePf.stopPlayback();
        this.kgV = -1;
        af.a(this.ahK, false);
        to(false);
        this.hZj.setForegroundDrawable(0);
        this.hZj.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.kyA, R.drawable.icon_video_midpause);
        this.kyB.asw();
        this.kyx.setVisibility(8);
        if (this.kyq != null) {
            this.kyu.setText(StringUtils.translateSecondsToString(this.kyq.video_duration.intValue()));
            this.kyu.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eFm = null;
        this.kyH = false;
        MessageManager.getInstance().unRegisterListener(this.kyO);
        MessageManager.getInstance().unRegisterListener(this.kkq);
        MessageManager.getInstance().unRegisterListener(this.gZT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BR(int i) {
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
        return this.kyq != null ? this.kyq.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.kvb instanceof com.baidu.tieba.recapp.e.a) && (this.kyF instanceof AdCard) && !((AdCard) this.kyF).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kvb).bgm();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.kvb instanceof com.baidu.tieba.recapp.e.a) && (this.kyF instanceof AdCard) && !((AdCard) this.kyF).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kvb).cOp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm(boolean z) {
        if (z) {
            if (this.eFm != null) {
                this.eFm.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.kyw, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.kyv, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.kgV == 1) {
                af.a(this.ahK, true);
            }
        } else {
            if (this.eFm != null) {
                this.eFm.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.kyw, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.kyv, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.ahK, false);
        }
        this.kyD = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.kgV;
    }

    public VideoInfo getData() {
        return this.kyq;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.kyC;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.kyr = advertAppInfo;
        this.kys = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(this.kyr, 303, i, BR(this.kyK), this.kyq.video_duration.intValue(), this.mDuration, -1);
        if (this.kvb != null) {
            this.kvb.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2, int i3) {
        D(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void D(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.kyr != null && this.kyq != null) {
            this.kyr.page = this.mPage;
            com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(this.kyr, i, this.kys, i2, this.kyq.video_duration.intValue(), com.baidu.tieba.ad.a.a.oy(i3), i4));
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
                c(str, this.kyI, i3, this.mDuration, str2, BS(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.krL != null && "cpv".equals(this.krL.ksN) && !TextUtils.isEmpty(this.krL.ksO)) {
            new com.baidu.tieba.recapp.request.a(this.krL.ksO).a(str, i, i2, i3, str2, str3);
        }
    }

    private String BS(int i) {
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
            this.kyo = view;
            this.kyp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tn(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyM);
            if (this.bhy != null) {
                this.bhy.cancel();
            }
            this.kyz.setVisibility(0);
            if (this.kgV == 1) {
                am.setImageResource(this.kyA, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.kyA, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.kyz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOA() {
        switch (this.kgV) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.kd(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aMS();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.kyG = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    tn(true);
                    return;
                }
                return;
            case 2:
                this.kyG = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyM);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.kyM, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOB() {
        if (!this.cWe && this.bhy != null) {
            this.kyz.startAnimation(this.bhy);
            this.cWe = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bhy = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bhy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.kyz.setVisibility(8);
                    DistributeVideoView.this.cWe = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cOC() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyN);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.kyN, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(boolean z) {
        if (this.kyv != null && this.mStyle == 1) {
            if (z) {
                this.kyv.setVisibility(0);
                cOC();
                return;
            }
            this.kyv.setVisibility(8);
        }
    }
}
