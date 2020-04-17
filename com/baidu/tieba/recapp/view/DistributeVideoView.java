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
    private WeakReference<Context> ahH;
    private Animation bht;
    boolean cVZ;
    private g eFh;
    private QuickVideoView ePa;
    private g.b emA;
    private QuickVideoView.b emE;
    private g.a evE;
    private g.f evF;
    private g.e evH;
    private CustomMessageListener gZN;
    private ForeDrawableImageView hZd;
    private int kgR;
    private CustomMessageListener kkm;
    private AdCard.a krH;
    private AdCard.f krI;
    private ViewGroup kuV;
    private d kuW;
    private e kuX;
    private boolean kxl;
    private long kyA;
    private b kyB;
    boolean kyC;
    private boolean kyD;
    private int kyE;
    boolean kyF;
    private int kyG;
    private Runnable kyH;
    private Runnable kyI;
    private Runnable kyJ;
    private CustomMessageListener kyK;
    private View kyk;
    private boolean kyl;
    private VideoInfo kym;
    private AdvertAppInfo kyn;
    private int kyo;
    private TBLottieAnimationView kyp;
    private TextView kyq;
    private ImageView kyr;
    private ImageView kys;
    private View kyt;
    private TextView kyu;
    private View kyv;
    private ImageView kyw;
    private VideoControllerView kyx;
    private long kyy;
    private boolean kyz;
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
        if (this.kyn != null) {
            WebVideoActivity.krB = new WebVideoActivity.a();
            WebVideoActivity.krB.krL = this.kyn;
            WebVideoActivity.krB.mPage = "DETAIL";
            WebVideoActivity.krB.mPageNum = this.kyo;
            NewWebVideoActivity.krM = new NewWebVideoActivity.a();
            NewWebVideoActivity.krM.krL = this.kyn;
            NewWebVideoActivity.krM.mPage = "DETAIL";
            NewWebVideoActivity.krM.mPageNum = this.kyo;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.kyn.dmq, true, true, true, this.kym.video_url, this.kym.thumbnail_url, this.kym.video_width.intValue() / this.kym.video_height.intValue(), this.kym.video_duration.intValue(), this.kyn.dmo);
        if (this.krH != null) {
            newWebVideoActivityConfig.setChargeStyle(this.krH.ksJ);
            newWebVideoActivityConfig.setChargeUrl(this.krH.ksK);
        }
        if (this.krI != null) {
            newWebVideoActivityConfig.setTailFrame(this.krI.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clb() {
        ac(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.FL(this.parallelChargeInfo.iJq);
            Iterator<String> it = this.parallelChargeInfo.iJt.iterator();
            while (it.hasNext()) {
                c.FL(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKH() {
        if (this.kyp != null) {
            this.kyp.clearAnimation();
            this.kyp.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.kyp.setVisibility(8);
                    DistributeVideoView.this.hZd.setVisibility(8);
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyz);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.kyq.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.kyx.setPlayer(DistributeVideoView.this.ePa);
                        DistributeVideoView.this.kyx.be(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.kym.video_duration.intValue()));
                        DistributeVideoView.this.kyx.showProgress();
                        DistributeVideoView.this.tn(true);
                        com.baidu.adp.lib.f.e.lb().removeCallbacks(DistributeVideoView.this.kyI);
                        com.baidu.adp.lib.f.e.lb().postDelayed(DistributeVideoView.this.kyI, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.kyy = DistributeVideoView.this.ePa.getCurrentPosition();
                    DistributeVideoView.this.to(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.kyp.setMinFrame(0);
                    DistributeVideoView.this.kyp.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.kyl = false;
        this.ahH = null;
        this.kgR = -1;
        this.kyy = 0L;
        this.kyz = false;
        this.kyA = 0L;
        this.mStyle = 1;
        this.cVZ = false;
        this.kyC = false;
        this.kyD = false;
        this.kyF = false;
        this.kyG = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kyt) {
                    DistributeVideoView.this.kyt.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kys || view == DistributeVideoView.this.kyr) {
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyz ? false : true);
                } else if (view == DistributeVideoView.this.kyp || view == DistributeVideoView.this.kyw) {
                    DistributeVideoView.this.cOC();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kyn == null || !DistributeVideoView.this.kyn.aIH()) {
                    if (DistributeVideoView.this.kyB instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kyB;
                        if (!adCard.getAdvertAppInfo().aIG() || adCard.directDownload) {
                            DistributeVideoView.this.cOC();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.clb();
                        return;
                    }
                    DistributeVideoView.this.cOC();
                } else {
                    if (DistributeVideoView.this.kyn != null) {
                        WebVideoActivity.krB = new WebVideoActivity.a();
                        WebVideoActivity.krB.krL = DistributeVideoView.this.kyn;
                        WebVideoActivity.krB.mPage = "DETAIL";
                        WebVideoActivity.krB.mPageNum = DistributeVideoView.this.kyo;
                        NewWebVideoActivity.krM = new NewWebVideoActivity.a();
                        NewWebVideoActivity.krM.krL = DistributeVideoView.this.kyn;
                        NewWebVideoActivity.krM.mPage = "DETAIL";
                        NewWebVideoActivity.krM.mPageNum = DistributeVideoView.this.kyo;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kyn.dmq;
                    if (a.bdC().bdD() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kym.video_url, DistributeVideoView.this.kym.thumbnail_url, DistributeVideoView.this.kym.video_width.intValue() / DistributeVideoView.this.kym.video_height.intValue(), DistributeVideoView.this.kym.video_duration.intValue(), DistributeVideoView.this.kyn.dmo);
                        if (DistributeVideoView.this.krH != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krH.ksJ);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krH.ksK);
                        }
                        if (DistributeVideoView.this.krI != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.krI.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kym.video_url, DistributeVideoView.this.kym.thumbnail_url, DistributeVideoView.this.kym.video_width.intValue() / DistributeVideoView.this.kym.video_height.intValue(), DistributeVideoView.this.kym.video_duration.intValue());
                        if (DistributeVideoView.this.krH != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krH.ksJ);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krH.ksK);
                        }
                        if (DistributeVideoView.this.krI != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.krI.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.clb();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kgR != 1) {
                            if (DistributeVideoView.this.ePa.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kgR = 1;
                                DistributeVideoView.this.cKH();
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
                        if (DistributeVideoView.this.kgR == 1) {
                            if (DistributeVideoView.this.kyy == DistributeVideoView.this.ePa.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kyy = DistributeVideoView.this.ePa.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kyE = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eFh = gVar;
                    DistributeVideoView.this.eFh.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kyz && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tm(false);
                    }
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kyn != null) {
                    if (DistributeVideoView.this.kyF && "DETAIL".equals(DistributeVideoView.this.kyn.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), 0);
                }
                return false;
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cOB();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), gVar.getCurrentPosition());
                DistributeVideoView.this.hZd.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kyt.setVisibility(0);
                return true;
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kyA = System.currentTimeMillis();
                DistributeVideoView.this.kyF = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), gVar.getDuration());
                DistributeVideoView.this.cOB();
                if (DistributeVideoView.this.kuX != null) {
                    DistributeVideoView.this.kuX.cOs();
                    DistributeVideoView.this.kyq.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kyH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kym != null && DistributeVideoView.this.ePa != null) {
                    DistributeVideoView.this.BQ(1);
                }
            }
        };
        this.kyI = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cOD();
            }
        };
        this.kyJ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.to(false);
            }
        };
        this.kkm = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kyD) {
                            DistributeVideoView.this.tm(true);
                            return;
                        } else {
                            DistributeVideoView.this.tm(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kyD = DistributeVideoView.this.kyz;
                    DistributeVideoView.this.tm(true);
                }
            }
        };
        this.gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.kyK = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.kyl = false;
        this.ahH = null;
        this.kgR = -1;
        this.kyy = 0L;
        this.kyz = false;
        this.kyA = 0L;
        this.mStyle = 1;
        this.cVZ = false;
        this.kyC = false;
        this.kyD = false;
        this.kyF = false;
        this.kyG = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kyt) {
                    DistributeVideoView.this.kyt.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kys || view == DistributeVideoView.this.kyr) {
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyz ? false : true);
                } else if (view == DistributeVideoView.this.kyp || view == DistributeVideoView.this.kyw) {
                    DistributeVideoView.this.cOC();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kyn == null || !DistributeVideoView.this.kyn.aIH()) {
                    if (DistributeVideoView.this.kyB instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kyB;
                        if (!adCard.getAdvertAppInfo().aIG() || adCard.directDownload) {
                            DistributeVideoView.this.cOC();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.clb();
                        return;
                    }
                    DistributeVideoView.this.cOC();
                } else {
                    if (DistributeVideoView.this.kyn != null) {
                        WebVideoActivity.krB = new WebVideoActivity.a();
                        WebVideoActivity.krB.krL = DistributeVideoView.this.kyn;
                        WebVideoActivity.krB.mPage = "DETAIL";
                        WebVideoActivity.krB.mPageNum = DistributeVideoView.this.kyo;
                        NewWebVideoActivity.krM = new NewWebVideoActivity.a();
                        NewWebVideoActivity.krM.krL = DistributeVideoView.this.kyn;
                        NewWebVideoActivity.krM.mPage = "DETAIL";
                        NewWebVideoActivity.krM.mPageNum = DistributeVideoView.this.kyo;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kyn.dmq;
                    if (a.bdC().bdD() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kym.video_url, DistributeVideoView.this.kym.thumbnail_url, DistributeVideoView.this.kym.video_width.intValue() / DistributeVideoView.this.kym.video_height.intValue(), DistributeVideoView.this.kym.video_duration.intValue(), DistributeVideoView.this.kyn.dmo);
                        if (DistributeVideoView.this.krH != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krH.ksJ);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krH.ksK);
                        }
                        if (DistributeVideoView.this.krI != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.krI.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kym.video_url, DistributeVideoView.this.kym.thumbnail_url, DistributeVideoView.this.kym.video_width.intValue() / DistributeVideoView.this.kym.video_height.intValue(), DistributeVideoView.this.kym.video_duration.intValue());
                        if (DistributeVideoView.this.krH != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krH.ksJ);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krH.ksK);
                        }
                        if (DistributeVideoView.this.krI != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.krI.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.clb();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kgR != 1) {
                            if (DistributeVideoView.this.ePa.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kgR = 1;
                                DistributeVideoView.this.cKH();
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
                        if (DistributeVideoView.this.kgR == 1) {
                            if (DistributeVideoView.this.kyy == DistributeVideoView.this.ePa.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kyy = DistributeVideoView.this.ePa.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kyE = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eFh = gVar;
                    DistributeVideoView.this.eFh.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kyz && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tm(false);
                    }
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kyn != null) {
                    if (DistributeVideoView.this.kyF && "DETAIL".equals(DistributeVideoView.this.kyn.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), 0);
                }
                return false;
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cOB();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), gVar.getCurrentPosition());
                DistributeVideoView.this.hZd.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kyt.setVisibility(0);
                return true;
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kyA = System.currentTimeMillis();
                DistributeVideoView.this.kyF = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), gVar.getDuration());
                DistributeVideoView.this.cOB();
                if (DistributeVideoView.this.kuX != null) {
                    DistributeVideoView.this.kuX.cOs();
                    DistributeVideoView.this.kyq.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kyH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kym != null && DistributeVideoView.this.ePa != null) {
                    DistributeVideoView.this.BQ(1);
                }
            }
        };
        this.kyI = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cOD();
            }
        };
        this.kyJ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.to(false);
            }
        };
        this.kkm = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kyD) {
                            DistributeVideoView.this.tm(true);
                            return;
                        } else {
                            DistributeVideoView.this.tm(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kyD = DistributeVideoView.this.kyz;
                    DistributeVideoView.this.tm(true);
                }
            }
        };
        this.gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.kyK = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.kyl = false;
        this.ahH = null;
        this.kgR = -1;
        this.kyy = 0L;
        this.kyz = false;
        this.kyA = 0L;
        this.mStyle = 1;
        this.cVZ = false;
        this.kyC = false;
        this.kyD = false;
        this.kyF = false;
        this.kyG = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kyt) {
                    DistributeVideoView.this.kyt.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kys || view == DistributeVideoView.this.kyr) {
                    DistributeVideoView.this.tm(DistributeVideoView.this.kyz ? false : true);
                } else if (view == DistributeVideoView.this.kyp || view == DistributeVideoView.this.kyw) {
                    DistributeVideoView.this.cOC();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kyn == null || !DistributeVideoView.this.kyn.aIH()) {
                    if (DistributeVideoView.this.kyB instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kyB;
                        if (!adCard.getAdvertAppInfo().aIG() || adCard.directDownload) {
                            DistributeVideoView.this.cOC();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.clb();
                        return;
                    }
                    DistributeVideoView.this.cOC();
                } else {
                    if (DistributeVideoView.this.kyn != null) {
                        WebVideoActivity.krB = new WebVideoActivity.a();
                        WebVideoActivity.krB.krL = DistributeVideoView.this.kyn;
                        WebVideoActivity.krB.mPage = "DETAIL";
                        WebVideoActivity.krB.mPageNum = DistributeVideoView.this.kyo;
                        NewWebVideoActivity.krM = new NewWebVideoActivity.a();
                        NewWebVideoActivity.krM.krL = DistributeVideoView.this.kyn;
                        NewWebVideoActivity.krM.mPage = "DETAIL";
                        NewWebVideoActivity.krM.mPageNum = DistributeVideoView.this.kyo;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kyn.dmq;
                    if (a.bdC().bdD() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kym.video_url, DistributeVideoView.this.kym.thumbnail_url, DistributeVideoView.this.kym.video_width.intValue() / DistributeVideoView.this.kym.video_height.intValue(), DistributeVideoView.this.kym.video_duration.intValue(), DistributeVideoView.this.kyn.dmo);
                        if (DistributeVideoView.this.krH != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krH.ksJ);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krH.ksK);
                        }
                        if (DistributeVideoView.this.krI != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.krI.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kym.video_url, DistributeVideoView.this.kym.thumbnail_url, DistributeVideoView.this.kym.video_width.intValue() / DistributeVideoView.this.kym.video_height.intValue(), DistributeVideoView.this.kym.video_duration.intValue());
                        if (DistributeVideoView.this.krH != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.krH.ksJ);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.krH.ksK);
                        }
                        if (DistributeVideoView.this.krI != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.krI.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.clb();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kgR != 1) {
                            if (DistributeVideoView.this.ePa.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kgR = 1;
                                DistributeVideoView.this.cKH();
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
                        if (DistributeVideoView.this.kgR == 1) {
                            if (DistributeVideoView.this.kyy == DistributeVideoView.this.ePa.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kyy = DistributeVideoView.this.ePa.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.evF = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kyE = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eFh = gVar;
                    DistributeVideoView.this.eFh.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kyz && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tm(false);
                    }
                }
            }
        };
        this.evH = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.kyn != null) {
                    if (DistributeVideoView.this.kyF && "DETAIL".equals(DistributeVideoView.this.kyn.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), 0);
                }
                return false;
            }
        };
        this.emA = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cOB();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), gVar.getCurrentPosition());
                DistributeVideoView.this.hZd.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kyt.setVisibility(0);
                return true;
            }
        };
        this.evE = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kyA = System.currentTimeMillis();
                DistributeVideoView.this.kyF = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.BR(DistributeVideoView.this.kyG), gVar.getDuration());
                DistributeVideoView.this.cOB();
                if (DistributeVideoView.this.kuX != null) {
                    DistributeVideoView.this.kuX.cOs();
                    DistributeVideoView.this.kyq.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.emE = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kyH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kym != null && DistributeVideoView.this.ePa != null) {
                    DistributeVideoView.this.BQ(1);
                }
            }
        };
        this.kyI = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cOD();
            }
        };
        this.kyJ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.to(false);
            }
        };
        this.kkm = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kyD) {
                            DistributeVideoView.this.tm(true);
                            return;
                        } else {
                            DistributeVideoView.this.tm(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kyD = DistributeVideoView.this.kyz;
                    DistributeVideoView.this.tm(true);
                }
            }
        };
        this.gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.kyK = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.kyB = adCard;
        if (this.kyB != null) {
            this.parallelChargeInfo = this.kyB.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.ePa = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.kyp = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hZd = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.kyq = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.kyt = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.kyu = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.kyr = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.kyv = this.mRootView.findViewById(R.id.distribute_control);
            this.kyw = (ImageView) this.kyv.findViewById(R.id.distribute_play_icon);
            this.kys = (ImageView) this.kyv.findViewById(R.id.distribute_voice);
            this.kyx = (VideoControllerView) this.kyv.findViewById(R.id.distribute_process);
            this.kuV = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.kuW = new d(context, this.kuV);
            this.kyp.setAnimation(R.raw.lotti_video_loading);
            this.kyp.setMinFrame(0);
            this.kyp.setFrame(0);
        }
    }

    private boolean cOz() {
        return this.mStyle == 1 ? t.cOz() : j.isWifiNet();
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
        this.krH = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.krI = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kym = videoInfo;
        this.mDuration = this.kym.video_duration.intValue() * 1000;
        this.ahH = new WeakReference<>(this.mContext.getApplicationContext());
        cOB();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.kym.video_width.intValue() > 0 ? (this.kym.video_height.intValue() * equipmentWidth) / this.kym.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hZd.setDefaultErrorResource(0);
        this.hZd.setDefaultResource(0);
        this.hZd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hZd.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ePa.setOnPreparedListener(this.evF);
        this.ePa.setOnErrorListener(this.emA);
        this.ePa.setOnCompletionListener(this.evE);
        this.ePa.setOnOutInfoListener(this.evH);
        this.ePa.setOnSurfaceDestroyedListener(this.emE);
        am.setViewTextColor(this.kyq, (int) R.color.cp_cont_m);
        this.kyq.setText(StringUtils.translateSecondsToString(this.kym.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kyz = false;
            am.setImageResource(this.kyr, R.drawable.icon_vedio_npronunciation_small_white);
            this.kyr.setVisibility(8);
        } else {
            this.kyz = true;
            am.setImageResource(this.kys, R.drawable.ad_icon_sound_open);
            this.kyr.setVisibility(8);
        }
        this.kys.setOnClickListener(this.mOnClickListener);
        this.kyr.setOnClickListener(this.mOnClickListener);
        this.kyt.setOnClickListener(this.mOnClickListener);
        this.kyt.setVisibility(8);
        am.setBackgroundColor(this.kyt, R.color.black_alpha80);
        am.setViewTextColor(this.kyu, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.kyq.setVisibility(0);
            return;
        }
        this.kyq.setVisibility(8);
        this.kyw.setOnClickListener(this.mOnClickListener);
        this.kyp.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kym = videoInfo;
        this.ahH = new WeakReference<>(this.mContext.getApplicationContext());
        cOB();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hZd.setDefaultErrorResource(0);
        this.hZd.setDefaultResource(0);
        this.hZd.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hZd.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ePa.setOnPreparedListener(this.evF);
        this.ePa.setOnErrorListener(this.emA);
        this.ePa.setOnCompletionListener(this.evE);
        this.ePa.setOnOutInfoListener(this.evH);
        this.ePa.setOnSurfaceDestroyedListener(this.emE);
        am.setViewTextColor(this.kyq, (int) R.color.cp_cont_m);
        this.kyq.setText(StringUtils.translateSecondsToString(this.kym.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kyz = false;
            am.setImageResource(this.kyr, R.drawable.icon_vedio_npronunciation_small_white);
            this.kyr.setVisibility(8);
        } else {
            this.kyz = true;
            am.setImageResource(this.kys, R.drawable.ad_icon_sound_open);
            this.kyr.setVisibility(8);
        }
        this.kys.setOnClickListener(this.mOnClickListener);
        this.kyr.setOnClickListener(this.mOnClickListener);
        this.kyt.setOnClickListener(this.mOnClickListener);
        this.kyt.setVisibility(8);
        am.setBackgroundColor(this.kyt, R.color.black_alpha80);
        am.setViewTextColor(this.kyu, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.kyq.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.kyq.setVisibility(8);
        this.kyw.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.kyn;
        }
        this.kuX = this.kuW.a(this.krI, this.kuX);
        if (this.kuX != null) {
            this.kuX.setPageContext(this.mPageContext);
            this.kuX.c(this.kyB);
            if (this.kuX instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.kuX).tk(this.kxl);
            }
            this.kuX.setAdvertAppInfo(advertAppInfo);
            this.kuX.a(this.krI);
            this.kuX.cOt();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.kxl = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.kuX != null) {
            this.kuX.setDownloadAppCallback(cVar);
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
        this.evE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ(int i) {
        this.kyG = i;
        if (this.kym != null && this.kgR == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.kyA) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.kuX != null) {
                    this.kuX.cOt();
                }
                this.ePa.setVideoPath(this.kym.video_url);
                this.ePa.start();
                this.kyE = this.ePa.getCurrentPosition();
                am.setImageResource(this.kyw, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.kyt.setVisibility(8);
                this.hZd.setForegroundDrawable(0);
                this.kgR = 0;
                if (this.mStyle == 1) {
                    this.kyq.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.kyq.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.kyK);
                MessageManager.getInstance().registerListener(this.kkm);
                MessageManager.getInstance().registerListener(this.gZN);
            }
        }
    }

    public void performPlay() {
        BQ(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (cOz()) {
            if (i <= 0) {
                BQ(1);
                return;
            }
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyH);
            com.baidu.adp.lib.f.e.lb().postDelayed(this.kyH, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.kgR == 1) {
            D(32, BR(this.kyG), this.ePa.getCurrentPosition(), i);
            this.ePa.pause();
            af.a(this.ahH, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.kyw, R.drawable.icon_video_midpause);
            this.kgR = 2;
        }
    }

    public void autoContinue() {
        if (!this.kyC) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.kgR == 2) {
            this.kyG = i;
            ac(33, BR(i), this.ePa.getCurrentPosition());
            this.kyE = this.ePa.getCurrentPosition();
            this.ePa.start();
            if (this.kyz) {
                af.a(this.ahH, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.kyw, R.drawable.icon_video_midplay);
            this.kgR = 1;
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
        if (this.kyp != null) {
            this.kyp.setAlpha(1.0f);
            this.kyp.setVisibility(0);
            this.kyp.loop(true);
            this.kyp.setMinAndMaxFrame(14, 80);
            this.kyp.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cOA();
        if (z) {
            this.kyp.setAlpha(1.0f);
            this.kyp.setVisibility(0);
            return;
        }
        this.kyp.setVisibility(8);
    }

    private void cOA() {
        if (this.kyp != null) {
            this.kyp.setMinFrame(0);
            this.kyp.setFrame(0);
            this.kyp.cancelAnimation();
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
        if (this.ePa.getCurrentPosition() > 0 && this.kgR != -1 && z) {
            int i = 32;
            int currentPosition = this.ePa.getCurrentPosition();
            if (this.ePa.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, BR(this.kyG), currentPosition, this.ePa.isPlaying());
        }
        cOB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOB() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyH);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyI);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyJ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.ePa.stopPlayback();
        this.kgR = -1;
        af.a(this.ahH, false);
        to(false);
        this.hZd.setForegroundDrawable(0);
        this.hZd.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.kyw, R.drawable.icon_video_midpause);
        this.kyx.asx();
        this.kyt.setVisibility(8);
        if (this.kym != null) {
            this.kyq.setText(StringUtils.translateSecondsToString(this.kym.video_duration.intValue()));
            this.kyq.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eFh = null;
        this.kyD = false;
        MessageManager.getInstance().unRegisterListener(this.kyK);
        MessageManager.getInstance().unRegisterListener(this.kkm);
        MessageManager.getInstance().unRegisterListener(this.gZN);
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
        return this.kym != null ? this.kym.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.kuX instanceof com.baidu.tieba.recapp.e.a) && (this.kyB instanceof AdCard) && !((AdCard) this.kyB).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kuX).bgo();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.kuX instanceof com.baidu.tieba.recapp.e.a) && (this.kyB instanceof AdCard) && !((AdCard) this.kyB).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kuX).cOr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tm(boolean z) {
        if (z) {
            if (this.eFh != null) {
                this.eFh.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.kys, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.kyr, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.kgR == 1) {
                af.a(this.ahH, true);
            }
        } else {
            if (this.eFh != null) {
                this.eFh.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.kys, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.kyr, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.ahH, false);
        }
        this.kyz = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.kgR;
    }

    public VideoInfo getData() {
        return this.kym;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.kyy;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.kyn = advertAppInfo;
        this.kyo = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(this.kyn, 303, i, BR(this.kyG), this.kym.video_duration.intValue(), this.mDuration, -1);
        if (this.kuX != null) {
            this.kuX.e(a);
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
        if (this.kyn != null && this.kym != null) {
            this.kyn.page = this.mPage;
            com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(this.kyn, i, this.kyo, i2, this.kym.video_duration.intValue(), com.baidu.tieba.ad.a.a.oy(i3), i4));
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
                c(str, this.kyE, i3, this.mDuration, str2, BS(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.krH != null && "cpv".equals(this.krH.ksJ) && !TextUtils.isEmpty(this.krH.ksK)) {
            new com.baidu.tieba.recapp.request.a(this.krH.ksK).a(str, i, i2, i3, str2, str3);
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
            this.kyk = view;
            this.kyl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tn(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyI);
            if (this.bht != null) {
                this.bht.cancel();
            }
            this.kyv.setVisibility(0);
            if (this.kgR == 1) {
                am.setImageResource(this.kyw, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.kyw, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.kyv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOC() {
        switch (this.kgR) {
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
                    aVar.b(this.mPageContext).aMU();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.kyC = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    tn(true);
                    return;
                }
                return;
            case 2:
                this.kyC = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyI);
                    com.baidu.adp.lib.f.e.lb().postDelayed(this.kyI, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOD() {
        if (!this.cVZ && this.bht != null) {
            this.kyv.startAnimation(this.bht);
            this.cVZ = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.bht = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.bht.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.kyv.setVisibility(8);
                    DistributeVideoView.this.cVZ = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cOE() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.kyJ);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.kyJ, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(boolean z) {
        if (this.kyr != null && this.mStyle == 1) {
            if (z) {
                this.kyr.setVisibility(0);
                cOE();
                return;
            }
            this.kyr.setVisibility(8);
        }
    }
}
