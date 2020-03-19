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
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.f;
import com.baidu.tieba.tbadkCore.t;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes13.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> Pg;
    private Animation aLM;
    boolean cxd;
    private g.b dMJ;
    private QuickVideoView.b dMN;
    private g.a dVF;
    private g.f dVG;
    private g.e dVI;
    private g efr;
    private QuickVideoView elA;
    private CustomMessageListener gqF;
    private ForeDrawableImageView hpv;
    private CustomMessageListener jAh;
    private AdCard.a jHW;
    private AdCard.f jHX;
    private e jLA;
    private ViewGroup jLy;
    private d jLz;
    private boolean jNR;
    private View jOQ;
    private boolean jOR;
    private VideoInfo jOS;
    private AdvertAppInfo jOT;
    private int jOU;
    private TBLottieAnimationView jOV;
    private TextView jOW;
    private ImageView jOX;
    private ImageView jOY;
    private View jOZ;
    private TextView jPa;
    private View jPb;
    private ImageView jPc;
    private VideoControllerView jPd;
    private long jPe;
    private boolean jPf;
    private long jPg;
    private b jPh;
    boolean jPi;
    private boolean jPj;
    private int jPk;
    boolean jPl;
    private int jPm;
    private Runnable jPn;
    private Runnable jPo;
    private Runnable jPp;
    private CustomMessageListener jPq;
    private int jwX;
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
        if (this.jOT != null) {
            WebVideoActivity.jHQ = new WebVideoActivity.a();
            WebVideoActivity.jHQ.jIa = this.jOT;
            WebVideoActivity.jHQ.mPage = "DETAIL";
            WebVideoActivity.jHQ.mPageNum = this.jOU;
            NewWebVideoActivity.jIb = new NewWebVideoActivity.a();
            NewWebVideoActivity.jIb.jIa = this.jOT;
            NewWebVideoActivity.jIb.mPage = "DETAIL";
            NewWebVideoActivity.jIb.mPageNum = this.jOU;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.jOT.cNm, true, true, true, this.jOS.video_url, this.jOS.thumbnail_url, this.jOS.video_width.intValue() / this.jOS.video_height.intValue(), this.jOS.video_duration.intValue(), this.jOT.cNk);
        if (this.jHW != null) {
            newWebVideoActivityConfig.setChargeStyle(this.jHW.jIX);
            newWebVideoActivityConfig.setChargeUrl(this.jHW.jIY);
        }
        if (this.jHX != null) {
            newWebVideoActivityConfig.setTailFrame(this.jHX.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caA() {
        Z(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.Ed(this.parallelChargeInfo.hZy);
            Iterator<String> it = this.parallelChargeInfo.hZB.iterator();
            while (it.hasNext()) {
                c.Ed(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czX() {
        if (this.jOV != null) {
            this.jOV.clearAnimation();
            this.jOV.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.jOV.setVisibility(8);
                    DistributeVideoView.this.hpv.setVisibility(8);
                    DistributeVideoView.this.sl(DistributeVideoView.this.jPf);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.jOW.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.jPd.setPlayer(DistributeVideoView.this.elA);
                        DistributeVideoView.this.jPd.ba(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.jOS.video_duration.intValue()));
                        DistributeVideoView.this.jPd.showProgress();
                        DistributeVideoView.this.sm(true);
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(DistributeVideoView.this.jPo);
                        com.baidu.adp.lib.f.e.gx().postDelayed(DistributeVideoView.this.jPo, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.jPe = DistributeVideoView.this.elA.getCurrentPosition();
                    DistributeVideoView.this.sn(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.jOV.setMinFrame(0);
                    DistributeVideoView.this.jOV.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.jOR = false;
        this.Pg = null;
        this.jwX = -1;
        this.jPe = 0L;
        this.jPf = false;
        this.jPg = 0L;
        this.mStyle = 1;
        this.cxd = false;
        this.jPi = false;
        this.jPj = false;
        this.jPl = false;
        this.jPm = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jOZ) {
                    DistributeVideoView.this.jOZ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jOY || view == DistributeVideoView.this.jOX) {
                    DistributeVideoView.this.sl(DistributeVideoView.this.jPf ? false : true);
                } else if (view == DistributeVideoView.this.jOV || view == DistributeVideoView.this.jPc) {
                    DistributeVideoView.this.cEb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jOT == null || !DistributeVideoView.this.jOT.aAu()) {
                    if (DistributeVideoView.this.jPh instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jPh;
                        if (!adCard.getAdvertAppInfo().aAt() || adCard.directDownload) {
                            DistributeVideoView.this.cEb();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.caA();
                        return;
                    }
                    DistributeVideoView.this.cEb();
                } else {
                    if (DistributeVideoView.this.jOT != null) {
                        WebVideoActivity.jHQ = new WebVideoActivity.a();
                        WebVideoActivity.jHQ.jIa = DistributeVideoView.this.jOT;
                        WebVideoActivity.jHQ.mPage = "DETAIL";
                        WebVideoActivity.jHQ.mPageNum = DistributeVideoView.this.jOU;
                        NewWebVideoActivity.jIb = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jIb.jIa = DistributeVideoView.this.jOT;
                        NewWebVideoActivity.jIb.mPage = "DETAIL";
                        NewWebVideoActivity.jIb.mPageNum = DistributeVideoView.this.jOU;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jOT.cNm;
                    if (a.aVs().aVt() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jOS.video_url, DistributeVideoView.this.jOS.thumbnail_url, DistributeVideoView.this.jOS.video_width.intValue() / DistributeVideoView.this.jOS.video_height.intValue(), DistributeVideoView.this.jOS.video_duration.intValue(), DistributeVideoView.this.jOT.cNk);
                        if (DistributeVideoView.this.jHW != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jHW.jIX);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jHW.jIY);
                        }
                        if (DistributeVideoView.this.jHX != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jHX.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jOS.video_url, DistributeVideoView.this.jOS.thumbnail_url, DistributeVideoView.this.jOS.video_width.intValue() / DistributeVideoView.this.jOS.video_height.intValue(), DistributeVideoView.this.jOS.video_duration.intValue());
                        if (DistributeVideoView.this.jHW != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jHW.jIX);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jHW.jIY);
                        }
                        if (DistributeVideoView.this.jHX != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jHX.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.caA();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jwX != 1) {
                            if (DistributeVideoView.this.elA.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jwX = 1;
                                DistributeVideoView.this.czX();
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
                        if (DistributeVideoView.this.jwX == 1) {
                            if (DistributeVideoView.this.jPe == DistributeVideoView.this.elA.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jPe = DistributeVideoView.this.elA.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jPk = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.efr = gVar;
                    DistributeVideoView.this.efr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jPf && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sl(false);
                    }
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jOT != null) {
                    if (DistributeVideoView.this.jPl && "DETAIL".equals(DistributeVideoView.this.jOT.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), 0);
                }
                return false;
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cEa();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), gVar.getCurrentPosition());
                DistributeVideoView.this.hpv.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jOZ.setVisibility(0);
                return true;
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jPg = System.currentTimeMillis();
                DistributeVideoView.this.jPl = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), gVar.getDuration());
                DistributeVideoView.this.cEa();
                if (DistributeVideoView.this.jLA != null) {
                    DistributeVideoView.this.jLA.cDR();
                    DistributeVideoView.this.jOW.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jPn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jOS != null && DistributeVideoView.this.elA != null) {
                    DistributeVideoView.this.Bq(1);
                }
            }
        };
        this.jPo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cEc();
            }
        };
        this.jPp = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sn(false);
            }
        };
        this.jAh = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jPj) {
                            DistributeVideoView.this.sl(true);
                            return;
                        } else {
                            DistributeVideoView.this.sl(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jPj = DistributeVideoView.this.jPf;
                    DistributeVideoView.this.sl(true);
                }
            }
        };
        this.gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sl(true);
                    }
                }
            }
        };
        this.jPq = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sn(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jOR = false;
        this.Pg = null;
        this.jwX = -1;
        this.jPe = 0L;
        this.jPf = false;
        this.jPg = 0L;
        this.mStyle = 1;
        this.cxd = false;
        this.jPi = false;
        this.jPj = false;
        this.jPl = false;
        this.jPm = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jOZ) {
                    DistributeVideoView.this.jOZ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jOY || view == DistributeVideoView.this.jOX) {
                    DistributeVideoView.this.sl(DistributeVideoView.this.jPf ? false : true);
                } else if (view == DistributeVideoView.this.jOV || view == DistributeVideoView.this.jPc) {
                    DistributeVideoView.this.cEb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jOT == null || !DistributeVideoView.this.jOT.aAu()) {
                    if (DistributeVideoView.this.jPh instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jPh;
                        if (!adCard.getAdvertAppInfo().aAt() || adCard.directDownload) {
                            DistributeVideoView.this.cEb();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.caA();
                        return;
                    }
                    DistributeVideoView.this.cEb();
                } else {
                    if (DistributeVideoView.this.jOT != null) {
                        WebVideoActivity.jHQ = new WebVideoActivity.a();
                        WebVideoActivity.jHQ.jIa = DistributeVideoView.this.jOT;
                        WebVideoActivity.jHQ.mPage = "DETAIL";
                        WebVideoActivity.jHQ.mPageNum = DistributeVideoView.this.jOU;
                        NewWebVideoActivity.jIb = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jIb.jIa = DistributeVideoView.this.jOT;
                        NewWebVideoActivity.jIb.mPage = "DETAIL";
                        NewWebVideoActivity.jIb.mPageNum = DistributeVideoView.this.jOU;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jOT.cNm;
                    if (a.aVs().aVt() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jOS.video_url, DistributeVideoView.this.jOS.thumbnail_url, DistributeVideoView.this.jOS.video_width.intValue() / DistributeVideoView.this.jOS.video_height.intValue(), DistributeVideoView.this.jOS.video_duration.intValue(), DistributeVideoView.this.jOT.cNk);
                        if (DistributeVideoView.this.jHW != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jHW.jIX);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jHW.jIY);
                        }
                        if (DistributeVideoView.this.jHX != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jHX.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jOS.video_url, DistributeVideoView.this.jOS.thumbnail_url, DistributeVideoView.this.jOS.video_width.intValue() / DistributeVideoView.this.jOS.video_height.intValue(), DistributeVideoView.this.jOS.video_duration.intValue());
                        if (DistributeVideoView.this.jHW != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jHW.jIX);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jHW.jIY);
                        }
                        if (DistributeVideoView.this.jHX != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jHX.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.caA();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jwX != 1) {
                            if (DistributeVideoView.this.elA.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jwX = 1;
                                DistributeVideoView.this.czX();
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
                        if (DistributeVideoView.this.jwX == 1) {
                            if (DistributeVideoView.this.jPe == DistributeVideoView.this.elA.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jPe = DistributeVideoView.this.elA.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jPk = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.efr = gVar;
                    DistributeVideoView.this.efr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jPf && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sl(false);
                    }
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jOT != null) {
                    if (DistributeVideoView.this.jPl && "DETAIL".equals(DistributeVideoView.this.jOT.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), 0);
                }
                return false;
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cEa();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), gVar.getCurrentPosition());
                DistributeVideoView.this.hpv.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jOZ.setVisibility(0);
                return true;
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jPg = System.currentTimeMillis();
                DistributeVideoView.this.jPl = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), gVar.getDuration());
                DistributeVideoView.this.cEa();
                if (DistributeVideoView.this.jLA != null) {
                    DistributeVideoView.this.jLA.cDR();
                    DistributeVideoView.this.jOW.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jPn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jOS != null && DistributeVideoView.this.elA != null) {
                    DistributeVideoView.this.Bq(1);
                }
            }
        };
        this.jPo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cEc();
            }
        };
        this.jPp = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sn(false);
            }
        };
        this.jAh = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jPj) {
                            DistributeVideoView.this.sl(true);
                            return;
                        } else {
                            DistributeVideoView.this.sl(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jPj = DistributeVideoView.this.jPf;
                    DistributeVideoView.this.sl(true);
                }
            }
        };
        this.gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sl(true);
                    }
                }
            }
        };
        this.jPq = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sn(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jOR = false;
        this.Pg = null;
        this.jwX = -1;
        this.jPe = 0L;
        this.jPf = false;
        this.jPg = 0L;
        this.mStyle = 1;
        this.cxd = false;
        this.jPi = false;
        this.jPj = false;
        this.jPl = false;
        this.jPm = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jOZ) {
                    DistributeVideoView.this.jOZ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jOY || view == DistributeVideoView.this.jOX) {
                    DistributeVideoView.this.sl(DistributeVideoView.this.jPf ? false : true);
                } else if (view == DistributeVideoView.this.jOV || view == DistributeVideoView.this.jPc) {
                    DistributeVideoView.this.cEb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jOT == null || !DistributeVideoView.this.jOT.aAu()) {
                    if (DistributeVideoView.this.jPh instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jPh;
                        if (!adCard.getAdvertAppInfo().aAt() || adCard.directDownload) {
                            DistributeVideoView.this.cEb();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.caA();
                        return;
                    }
                    DistributeVideoView.this.cEb();
                } else {
                    if (DistributeVideoView.this.jOT != null) {
                        WebVideoActivity.jHQ = new WebVideoActivity.a();
                        WebVideoActivity.jHQ.jIa = DistributeVideoView.this.jOT;
                        WebVideoActivity.jHQ.mPage = "DETAIL";
                        WebVideoActivity.jHQ.mPageNum = DistributeVideoView.this.jOU;
                        NewWebVideoActivity.jIb = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jIb.jIa = DistributeVideoView.this.jOT;
                        NewWebVideoActivity.jIb.mPage = "DETAIL";
                        NewWebVideoActivity.jIb.mPageNum = DistributeVideoView.this.jOU;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jOT.cNm;
                    if (a.aVs().aVt() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jOS.video_url, DistributeVideoView.this.jOS.thumbnail_url, DistributeVideoView.this.jOS.video_width.intValue() / DistributeVideoView.this.jOS.video_height.intValue(), DistributeVideoView.this.jOS.video_duration.intValue(), DistributeVideoView.this.jOT.cNk);
                        if (DistributeVideoView.this.jHW != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jHW.jIX);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jHW.jIY);
                        }
                        if (DistributeVideoView.this.jHX != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jHX.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jOS.video_url, DistributeVideoView.this.jOS.thumbnail_url, DistributeVideoView.this.jOS.video_width.intValue() / DistributeVideoView.this.jOS.video_height.intValue(), DistributeVideoView.this.jOS.video_duration.intValue());
                        if (DistributeVideoView.this.jHW != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jHW.jIX);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jHW.jIY);
                        }
                        if (DistributeVideoView.this.jHX != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jHX.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.caA();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jwX != 1) {
                            if (DistributeVideoView.this.elA.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jwX = 1;
                                DistributeVideoView.this.czX();
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
                        if (DistributeVideoView.this.jwX == 1) {
                            if (DistributeVideoView.this.jPe == DistributeVideoView.this.elA.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jPe = DistributeVideoView.this.elA.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVG = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jPk = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.efr = gVar;
                    DistributeVideoView.this.efr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jPf && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sl(false);
                    }
                }
            }
        };
        this.dVI = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.jOT != null) {
                    if (DistributeVideoView.this.jPl && "DETAIL".equals(DistributeVideoView.this.jOT.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), 0);
                }
                return false;
            }
        };
        this.dMJ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cEa();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), gVar.getCurrentPosition());
                DistributeVideoView.this.hpv.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jOZ.setVisibility(0);
                return true;
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jPg = System.currentTimeMillis();
                DistributeVideoView.this.jPl = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Br(DistributeVideoView.this.jPm), gVar.getDuration());
                DistributeVideoView.this.cEa();
                if (DistributeVideoView.this.jLA != null) {
                    DistributeVideoView.this.jLA.cDR();
                    DistributeVideoView.this.jOW.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jPn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jOS != null && DistributeVideoView.this.elA != null) {
                    DistributeVideoView.this.Bq(1);
                }
            }
        };
        this.jPo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cEc();
            }
        };
        this.jPp = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sn(false);
            }
        };
        this.jAh = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jPj) {
                            DistributeVideoView.this.sl(true);
                            return;
                        } else {
                            DistributeVideoView.this.sl(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jPj = DistributeVideoView.this.jPf;
                    DistributeVideoView.this.sl(true);
                }
            }
        };
        this.gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sl(true);
                    }
                }
            }
        };
        this.jPq = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sn(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.jPh = adCard;
        if (this.jPh != null) {
            this.parallelChargeInfo = this.jPh.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.elA = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.jOV = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hpv = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.jOW = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.jOZ = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.jPa = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.jOX = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.jPb = this.mRootView.findViewById(R.id.distribute_control);
            this.jPc = (ImageView) this.jPb.findViewById(R.id.distribute_play_icon);
            this.jOY = (ImageView) this.jPb.findViewById(R.id.distribute_voice);
            this.jPd = (VideoControllerView) this.jPb.findViewById(R.id.distribute_process);
            this.jLy = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.jLz = new d(context, this.jLy);
            this.jOV.setAnimation(R.raw.lotti_video_loading);
            this.jOV.setMinFrame(0);
            this.jOV.setFrame(0);
        }
    }

    private boolean cDY() {
        return this.mStyle == 1 ? t.cDY() : j.isWifiNet();
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
        this.jHW = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.jHX = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jOS = videoInfo;
        this.mDuration = this.jOS.video_duration.intValue() * 1000;
        this.Pg = new WeakReference<>(this.mContext.getApplicationContext());
        cEa();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.jOS.video_width.intValue() > 0 ? (this.jOS.video_height.intValue() * equipmentWidth) / this.jOS.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hpv.setDefaultErrorResource(0);
        this.hpv.setDefaultResource(0);
        this.hpv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hpv.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.elA.setOnPreparedListener(this.dVG);
        this.elA.setOnErrorListener(this.dMJ);
        this.elA.setOnCompletionListener(this.dVF);
        this.elA.setOnOutInfoListener(this.dVI);
        this.elA.setOnSurfaceDestroyedListener(this.dMN);
        am.setViewTextColor(this.jOW, (int) R.color.cp_cont_m);
        this.jOW.setText(StringUtils.translateSecondsToString(this.jOS.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jPf = false;
            am.setImageResource(this.jOX, R.drawable.icon_vedio_npronunciation_small_white);
            this.jOX.setVisibility(8);
        } else {
            this.jPf = true;
            am.setImageResource(this.jOY, R.drawable.ad_icon_sound_open);
            this.jOX.setVisibility(8);
        }
        this.jOY.setOnClickListener(this.mOnClickListener);
        this.jOX.setOnClickListener(this.mOnClickListener);
        this.jOZ.setOnClickListener(this.mOnClickListener);
        this.jOZ.setVisibility(8);
        am.setBackgroundColor(this.jOZ, R.color.black_alpha80);
        am.setViewTextColor(this.jPa, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.jOW.setVisibility(0);
            return;
        }
        this.jOW.setVisibility(8);
        this.jPc.setOnClickListener(this.mOnClickListener);
        this.jOV.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jOS = videoInfo;
        this.Pg = new WeakReference<>(this.mContext.getApplicationContext());
        cEa();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hpv.setDefaultErrorResource(0);
        this.hpv.setDefaultResource(0);
        this.hpv.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hpv.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.elA.setOnPreparedListener(this.dVG);
        this.elA.setOnErrorListener(this.dMJ);
        this.elA.setOnCompletionListener(this.dVF);
        this.elA.setOnOutInfoListener(this.dVI);
        this.elA.setOnSurfaceDestroyedListener(this.dMN);
        am.setViewTextColor(this.jOW, (int) R.color.cp_cont_m);
        this.jOW.setText(StringUtils.translateSecondsToString(this.jOS.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jPf = false;
            am.setImageResource(this.jOX, R.drawable.icon_vedio_npronunciation_small_white);
            this.jOX.setVisibility(8);
        } else {
            this.jPf = true;
            am.setImageResource(this.jOY, R.drawable.ad_icon_sound_open);
            this.jOX.setVisibility(8);
        }
        this.jOY.setOnClickListener(this.mOnClickListener);
        this.jOX.setOnClickListener(this.mOnClickListener);
        this.jOZ.setOnClickListener(this.mOnClickListener);
        this.jOZ.setVisibility(8);
        am.setBackgroundColor(this.jOZ, R.color.black_alpha80);
        am.setViewTextColor(this.jPa, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.jOW.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.jOW.setVisibility(8);
        this.jPc.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.jOT;
        }
        this.jLA = this.jLz.a(this.jHX, this.jLA);
        if (this.jLA != null) {
            this.jLA.setPageContext(this.mPageContext);
            this.jLA.c(this.jPh);
            if (this.jLA instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.jLA).sj(this.jNR);
            }
            this.jLA.setAdvertAppInfo(advertAppInfo);
            this.jLA.a(this.jHX);
            this.jLA.cDS();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.jNR = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.jLA != null) {
            this.jLA.setDownloadAppCallback(cVar);
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
        this.dVF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq(int i) {
        this.jPm = i;
        if (this.jOS != null && this.jwX == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.jPg) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.jLA != null) {
                    this.jLA.cDS();
                }
                this.elA.setVideoPath(this.jOS.video_url);
                this.elA.start();
                this.jPk = this.elA.getCurrentPosition();
                am.setImageResource(this.jPc, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.jOZ.setVisibility(8);
                this.hpv.setForegroundDrawable(0);
                this.jwX = 0;
                if (this.mStyle == 1) {
                    this.jOW.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.jOW.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.jPq);
                MessageManager.getInstance().registerListener(this.jAh);
                MessageManager.getInstance().registerListener(this.gqF);
            }
        }
    }

    public void performPlay() {
        Bq(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (cDY()) {
            if (i <= 0) {
                Bq(1);
                return;
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPn);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jPn, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.jwX == 1) {
            D(32, Br(this.jPm), this.elA.getCurrentPosition(), i);
            this.elA.pause();
            af.a(this.Pg, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.jPc, R.drawable.icon_video_midpause);
            this.jwX = 2;
        }
    }

    public void autoContinue() {
        if (!this.jPi) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.jwX == 2) {
            this.jPm = i;
            Z(33, Br(i), this.elA.getCurrentPosition());
            this.jPk = this.elA.getCurrentPosition();
            this.elA.start();
            if (this.jPf) {
                af.a(this.Pg, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.jPc, R.drawable.icon_video_midplay);
            this.jwX = 1;
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
        if (this.jOV != null) {
            this.jOV.setAlpha(1.0f);
            this.jOV.setVisibility(0);
            this.jOV.loop(true);
            this.jOV.setMinAndMaxFrame(14, 80);
            this.jOV.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cDZ();
        if (z) {
            this.jOV.setAlpha(1.0f);
            this.jOV.setVisibility(0);
            return;
        }
        this.jOV.setVisibility(8);
    }

    private void cDZ() {
        if (this.jOV != null) {
            this.jOV.setMinFrame(0);
            this.jOV.setFrame(0);
            this.jOV.cancelAnimation();
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
        if (this.elA.getCurrentPosition() > 0 && this.jwX != -1 && z) {
            int i = 32;
            int currentPosition = this.elA.getCurrentPosition();
            if (this.elA.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Br(this.jPm), currentPosition, this.elA.isPlaying());
        }
        cEa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEa() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPn);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPo);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPp);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.elA.stopPlayback();
        this.jwX = -1;
        af.a(this.Pg, false);
        sn(false);
        this.hpv.setForegroundDrawable(0);
        this.hpv.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.jPc, R.drawable.icon_video_midpause);
        this.jPd.akm();
        this.jOZ.setVisibility(8);
        if (this.jOS != null) {
            this.jOW.setText(StringUtils.translateSecondsToString(this.jOS.video_duration.intValue()));
            this.jOW.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.efr = null;
        this.jPj = false;
        MessageManager.getInstance().unRegisterListener(this.jPq);
        MessageManager.getInstance().unRegisterListener(this.jAh);
        MessageManager.getInstance().unRegisterListener(this.gqF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Br(int i) {
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
        return this.jOS != null ? this.jOS.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.jLA instanceof com.baidu.tieba.recapp.e.a) && (this.jPh instanceof AdCard) && !((AdCard) this.jPh).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jLA).aYj();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.jLA instanceof com.baidu.tieba.recapp.e.a) && (this.jPh instanceof AdCard) && !((AdCard) this.jPh).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jLA).cDQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(boolean z) {
        if (z) {
            if (this.efr != null) {
                this.efr.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.jOY, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.jOX, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.jwX == 1) {
                af.a(this.Pg, true);
            }
        } else {
            if (this.efr != null) {
                this.efr.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.jOY, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.jOX, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.Pg, false);
        }
        this.jPf = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.jwX;
    }

    public VideoInfo getData() {
        return this.jOS;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.jPe;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.jOT = advertAppInfo;
        this.jOU = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.jOT, 303, i, Br(this.jPm), this.jOS.video_duration.intValue(), this.mDuration, -1);
        if (this.jLA != null) {
            this.jLA.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, int i2, int i3) {
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
        if (this.jOT != null && this.jOS != null) {
            this.jOT.page = this.mPage;
            com.baidu.tieba.recapp.report.c.cDK().a(f.a(this.jOT, i, this.jOU, i2, this.jOS.video_duration.intValue(), com.baidu.tieba.ad.a.a.ol(i3), i4));
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
                c(str, this.jPk, i3, this.mDuration, str2, Bs(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.jHW != null && "cpv".equals(this.jHW.jIX) && !TextUtils.isEmpty(this.jHW.jIY)) {
            new com.baidu.tieba.recapp.request.a(this.jHW.jIY).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Bs(int i) {
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
            this.jOQ = view;
            this.jOR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sm(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPo);
            if (this.aLM != null) {
                this.aLM.cancel();
            }
            this.jPb.setVisibility(0);
            if (this.jwX == 1) {
                am.setImageResource(this.jPc, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.jPc, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.jPb.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEb() {
        switch (this.jwX) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.jW(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aEG();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.jPi = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    sm(true);
                    return;
                }
                return;
            case 2:
                this.jPi = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPo);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.jPo, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEc() {
        if (!this.cxd && this.aLM != null) {
            this.jPb.startAnimation(this.aLM);
            this.cxd = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.aLM = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.aLM.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.jPb.setVisibility(8);
                    DistributeVideoView.this.cxd = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cEd() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jPp);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jPp, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(boolean z) {
        if (this.jOX != null && this.mStyle == 1) {
            if (z) {
                this.jOX.setVisibility(0);
                cEd();
                return;
            }
            this.jOX.setVisibility(8);
        }
    }
}
