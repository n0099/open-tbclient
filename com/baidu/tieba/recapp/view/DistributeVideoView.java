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
import com.baidu.tieba.tbadkCore.s;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes11.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> OC;
    private Animation aHr;
    boolean csO;
    private g.b dIa;
    private QuickVideoView.b dIe;
    private g.a dQW;
    private g.f dQX;
    private g.e dQZ;
    private g eaK;
    private QuickVideoView egS;
    private CustomMessageListener gnF;
    private ForeDrawableImageView hlG;
    private AdCard.a jFs;
    private AdCard.f jFt;
    private ViewGroup jIM;
    private d jIN;
    private e jIO;
    private boolean jLf;
    private CustomMessageListener jMA;
    private View jMe;
    private boolean jMf;
    private AdvertAppInfo jMg;
    private int jMh;
    private TBLottieAnimationView jMi;
    private TextView jMj;
    private ImageView jMk;
    private ImageView jMl;
    private TextView jMm;
    private View jMn;
    private ImageView jMo;
    private VideoControllerView jMp;
    private boolean jMq;
    private long jMr;
    private b jMs;
    boolean jMt;
    private boolean jMu;
    private int jMv;
    boolean jMw;
    private int jMx;
    private Runnable jMy;
    private Runnable jMz;
    private VideoInfo jbG;
    private int jbH;
    private View jbO;
    private long jbQ;
    private Runnable jbW;
    private CustomMessageListener jxE;
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
        if (this.jMg != null) {
            WebVideoActivity.jFm = new WebVideoActivity.a();
            WebVideoActivity.jFm.jFw = this.jMg;
            WebVideoActivity.jFm.mPage = "DETAIL";
            WebVideoActivity.jFm.mPageNum = this.jMh;
            NewWebVideoActivity.jFx = new NewWebVideoActivity.a();
            NewWebVideoActivity.jFx.jFw = this.jMg;
            NewWebVideoActivity.jFx.mPage = "DETAIL";
            NewWebVideoActivity.jFx.mPageNum = this.jMh;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.jMg.cIU, true, true, true, this.jbG.video_url, this.jbG.thumbnail_url, this.jbG.video_width.intValue() / this.jbG.video_height.intValue(), this.jbG.video_duration.intValue(), this.jMg.cIS);
        if (this.jFs != null) {
            newWebVideoActivityConfig.setChargeStyle(this.jFs.jGt);
            newWebVideoActivityConfig.setChargeUrl(this.jFs.jGu);
        }
        if (this.jFt != null) {
            newWebVideoActivityConfig.setTailFrame(this.jFt.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYD() {
        Y(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.DM(this.parallelChargeInfo.hVM);
            Iterator<String> it = this.parallelChargeInfo.hVP.iterator();
            while (it.hasNext()) {
                c.DM(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyh() {
        if (this.jMi != null) {
            this.jMi.clearAnimation();
            this.jMi.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.jMi.setVisibility(8);
                    DistributeVideoView.this.hlG.setVisibility(8);
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMq);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.jMj.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.jMp.setPlayer(DistributeVideoView.this.egS);
                        DistributeVideoView.this.jMp.aZ(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.jbG.video_duration.intValue()));
                        DistributeVideoView.this.jMp.showProgress();
                        DistributeVideoView.this.sd(true);
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(DistributeVideoView.this.jMy);
                        com.baidu.adp.lib.f.e.gx().postDelayed(DistributeVideoView.this.jMy, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.jbQ = DistributeVideoView.this.egS.getCurrentPosition();
                    DistributeVideoView.this.se(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.jMi.setMinFrame(0);
                    DistributeVideoView.this.jMi.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.jMf = false;
        this.OC = null;
        this.jbH = -1;
        this.jbQ = 0L;
        this.jMq = false;
        this.jMr = 0L;
        this.mStyle = 1;
        this.csO = false;
        this.jMt = false;
        this.jMu = false;
        this.jMw = false;
        this.jMx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jbO) {
                    DistributeVideoView.this.jbO.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jMl || view == DistributeVideoView.this.jMk) {
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMq ? false : true);
                } else if (view == DistributeVideoView.this.jMi || view == DistributeVideoView.this.jMo) {
                    DistributeVideoView.this.cCh();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jMg == null || !DistributeVideoView.this.jMg.ayb()) {
                    if (DistributeVideoView.this.jMs instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jMs;
                        if (!adCard.getAdvertAppInfo().aya() || adCard.directDownload) {
                            DistributeVideoView.this.cCh();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bYD();
                        return;
                    }
                    DistributeVideoView.this.cCh();
                } else {
                    if (DistributeVideoView.this.jMg != null) {
                        WebVideoActivity.jFm = new WebVideoActivity.a();
                        WebVideoActivity.jFm.jFw = DistributeVideoView.this.jMg;
                        WebVideoActivity.jFm.mPage = "DETAIL";
                        WebVideoActivity.jFm.mPageNum = DistributeVideoView.this.jMh;
                        NewWebVideoActivity.jFx = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jFx.jFw = DistributeVideoView.this.jMg;
                        NewWebVideoActivity.jFx.mPage = "DETAIL";
                        NewWebVideoActivity.jFx.mPageNum = DistributeVideoView.this.jMh;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jMg.cIU;
                    if (a.aSU().aSV() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbG.video_url, DistributeVideoView.this.jbG.thumbnail_url, DistributeVideoView.this.jbG.video_width.intValue() / DistributeVideoView.this.jbG.video_height.intValue(), DistributeVideoView.this.jbG.video_duration.intValue(), DistributeVideoView.this.jMg.cIS);
                        if (DistributeVideoView.this.jFs != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFs.jGt);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFs.jGu);
                        }
                        if (DistributeVideoView.this.jFt != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFt.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbG.video_url, DistributeVideoView.this.jbG.thumbnail_url, DistributeVideoView.this.jbG.video_width.intValue() / DistributeVideoView.this.jbG.video_height.intValue(), DistributeVideoView.this.jbG.video_duration.intValue());
                        if (DistributeVideoView.this.jFs != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFs.jGt);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFs.jGu);
                        }
                        if (DistributeVideoView.this.jFt != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFt.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bYD();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jbH != 1) {
                            if (DistributeVideoView.this.egS.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jbH = 1;
                                DistributeVideoView.this.cyh();
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
                        if (DistributeVideoView.this.jbH == 1) {
                            if (DistributeVideoView.this.jbQ == DistributeVideoView.this.egS.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jbQ = DistributeVideoView.this.egS.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jMv = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaK = gVar;
                    DistributeVideoView.this.eaK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jMq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sc(false);
                    }
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jMg != null) {
                    if (DistributeVideoView.this.jMw && "DETAIL".equals(DistributeVideoView.this.jMg.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), 0);
                }
                return false;
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cCg();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), gVar.getCurrentPosition());
                DistributeVideoView.this.hlG.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jbO.setVisibility(0);
                return true;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jMr = System.currentTimeMillis();
                DistributeVideoView.this.jMw = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), gVar.getDuration());
                DistributeVideoView.this.cCg();
                if (DistributeVideoView.this.jIO != null) {
                    DistributeVideoView.this.jIO.cBY();
                    DistributeVideoView.this.jMj.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jbW = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jbG != null && DistributeVideoView.this.egS != null) {
                    DistributeVideoView.this.AZ(1);
                }
            }
        };
        this.jMy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cCi();
            }
        };
        this.jMz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.se(false);
            }
        };
        this.jxE = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jMu) {
                            DistributeVideoView.this.sc(true);
                            return;
                        } else {
                            DistributeVideoView.this.sc(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jMu = DistributeVideoView.this.jMq;
                    DistributeVideoView.this.sc(true);
                }
            }
        };
        this.gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sc(true);
                    }
                }
            }
        };
        this.jMA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.se(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMf = false;
        this.OC = null;
        this.jbH = -1;
        this.jbQ = 0L;
        this.jMq = false;
        this.jMr = 0L;
        this.mStyle = 1;
        this.csO = false;
        this.jMt = false;
        this.jMu = false;
        this.jMw = false;
        this.jMx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jbO) {
                    DistributeVideoView.this.jbO.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jMl || view == DistributeVideoView.this.jMk) {
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMq ? false : true);
                } else if (view == DistributeVideoView.this.jMi || view == DistributeVideoView.this.jMo) {
                    DistributeVideoView.this.cCh();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jMg == null || !DistributeVideoView.this.jMg.ayb()) {
                    if (DistributeVideoView.this.jMs instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jMs;
                        if (!adCard.getAdvertAppInfo().aya() || adCard.directDownload) {
                            DistributeVideoView.this.cCh();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bYD();
                        return;
                    }
                    DistributeVideoView.this.cCh();
                } else {
                    if (DistributeVideoView.this.jMg != null) {
                        WebVideoActivity.jFm = new WebVideoActivity.a();
                        WebVideoActivity.jFm.jFw = DistributeVideoView.this.jMg;
                        WebVideoActivity.jFm.mPage = "DETAIL";
                        WebVideoActivity.jFm.mPageNum = DistributeVideoView.this.jMh;
                        NewWebVideoActivity.jFx = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jFx.jFw = DistributeVideoView.this.jMg;
                        NewWebVideoActivity.jFx.mPage = "DETAIL";
                        NewWebVideoActivity.jFx.mPageNum = DistributeVideoView.this.jMh;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jMg.cIU;
                    if (a.aSU().aSV() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbG.video_url, DistributeVideoView.this.jbG.thumbnail_url, DistributeVideoView.this.jbG.video_width.intValue() / DistributeVideoView.this.jbG.video_height.intValue(), DistributeVideoView.this.jbG.video_duration.intValue(), DistributeVideoView.this.jMg.cIS);
                        if (DistributeVideoView.this.jFs != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFs.jGt);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFs.jGu);
                        }
                        if (DistributeVideoView.this.jFt != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFt.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbG.video_url, DistributeVideoView.this.jbG.thumbnail_url, DistributeVideoView.this.jbG.video_width.intValue() / DistributeVideoView.this.jbG.video_height.intValue(), DistributeVideoView.this.jbG.video_duration.intValue());
                        if (DistributeVideoView.this.jFs != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFs.jGt);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFs.jGu);
                        }
                        if (DistributeVideoView.this.jFt != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFt.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bYD();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jbH != 1) {
                            if (DistributeVideoView.this.egS.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jbH = 1;
                                DistributeVideoView.this.cyh();
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
                        if (DistributeVideoView.this.jbH == 1) {
                            if (DistributeVideoView.this.jbQ == DistributeVideoView.this.egS.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jbQ = DistributeVideoView.this.egS.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jMv = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaK = gVar;
                    DistributeVideoView.this.eaK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jMq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sc(false);
                    }
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jMg != null) {
                    if (DistributeVideoView.this.jMw && "DETAIL".equals(DistributeVideoView.this.jMg.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), 0);
                }
                return false;
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cCg();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), gVar.getCurrentPosition());
                DistributeVideoView.this.hlG.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jbO.setVisibility(0);
                return true;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jMr = System.currentTimeMillis();
                DistributeVideoView.this.jMw = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), gVar.getDuration());
                DistributeVideoView.this.cCg();
                if (DistributeVideoView.this.jIO != null) {
                    DistributeVideoView.this.jIO.cBY();
                    DistributeVideoView.this.jMj.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jbW = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jbG != null && DistributeVideoView.this.egS != null) {
                    DistributeVideoView.this.AZ(1);
                }
            }
        };
        this.jMy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cCi();
            }
        };
        this.jMz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.se(false);
            }
        };
        this.jxE = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jMu) {
                            DistributeVideoView.this.sc(true);
                            return;
                        } else {
                            DistributeVideoView.this.sc(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jMu = DistributeVideoView.this.jMq;
                    DistributeVideoView.this.sc(true);
                }
            }
        };
        this.gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sc(true);
                    }
                }
            }
        };
        this.jMA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.se(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jMf = false;
        this.OC = null;
        this.jbH = -1;
        this.jbQ = 0L;
        this.jMq = false;
        this.jMr = 0L;
        this.mStyle = 1;
        this.csO = false;
        this.jMt = false;
        this.jMu = false;
        this.jMw = false;
        this.jMx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jbO) {
                    DistributeVideoView.this.jbO.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jMl || view == DistributeVideoView.this.jMk) {
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMq ? false : true);
                } else if (view == DistributeVideoView.this.jMi || view == DistributeVideoView.this.jMo) {
                    DistributeVideoView.this.cCh();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jMg == null || !DistributeVideoView.this.jMg.ayb()) {
                    if (DistributeVideoView.this.jMs instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jMs;
                        if (!adCard.getAdvertAppInfo().aya() || adCard.directDownload) {
                            DistributeVideoView.this.cCh();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bYD();
                        return;
                    }
                    DistributeVideoView.this.cCh();
                } else {
                    if (DistributeVideoView.this.jMg != null) {
                        WebVideoActivity.jFm = new WebVideoActivity.a();
                        WebVideoActivity.jFm.jFw = DistributeVideoView.this.jMg;
                        WebVideoActivity.jFm.mPage = "DETAIL";
                        WebVideoActivity.jFm.mPageNum = DistributeVideoView.this.jMh;
                        NewWebVideoActivity.jFx = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jFx.jFw = DistributeVideoView.this.jMg;
                        NewWebVideoActivity.jFx.mPage = "DETAIL";
                        NewWebVideoActivity.jFx.mPageNum = DistributeVideoView.this.jMh;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jMg.cIU;
                    if (a.aSU().aSV() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbG.video_url, DistributeVideoView.this.jbG.thumbnail_url, DistributeVideoView.this.jbG.video_width.intValue() / DistributeVideoView.this.jbG.video_height.intValue(), DistributeVideoView.this.jbG.video_duration.intValue(), DistributeVideoView.this.jMg.cIS);
                        if (DistributeVideoView.this.jFs != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFs.jGt);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFs.jGu);
                        }
                        if (DistributeVideoView.this.jFt != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFt.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbG.video_url, DistributeVideoView.this.jbG.thumbnail_url, DistributeVideoView.this.jbG.video_width.intValue() / DistributeVideoView.this.jbG.video_height.intValue(), DistributeVideoView.this.jbG.video_duration.intValue());
                        if (DistributeVideoView.this.jFs != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFs.jGt);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFs.jGu);
                        }
                        if (DistributeVideoView.this.jFt != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFt.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bYD();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jbH != 1) {
                            if (DistributeVideoView.this.egS.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jbH = 1;
                                DistributeVideoView.this.cyh();
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
                        if (DistributeVideoView.this.jbH == 1) {
                            if (DistributeVideoView.this.jbQ == DistributeVideoView.this.egS.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jbQ = DistributeVideoView.this.egS.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dQX = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jMv = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaK = gVar;
                    DistributeVideoView.this.eaK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jMq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sc(false);
                    }
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.jMg != null) {
                    if (DistributeVideoView.this.jMw && "DETAIL".equals(DistributeVideoView.this.jMg.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), 0);
                }
                return false;
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cCg();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), gVar.getCurrentPosition());
                DistributeVideoView.this.hlG.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jbO.setVisibility(0);
                return true;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jMr = System.currentTimeMillis();
                DistributeVideoView.this.jMw = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.Ba(DistributeVideoView.this.jMx), gVar.getDuration());
                DistributeVideoView.this.cCg();
                if (DistributeVideoView.this.jIO != null) {
                    DistributeVideoView.this.jIO.cBY();
                    DistributeVideoView.this.jMj.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dIe = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jbW = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jbG != null && DistributeVideoView.this.egS != null) {
                    DistributeVideoView.this.AZ(1);
                }
            }
        };
        this.jMy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cCi();
            }
        };
        this.jMz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.se(false);
            }
        };
        this.jxE = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jMu) {
                            DistributeVideoView.this.sc(true);
                            return;
                        } else {
                            DistributeVideoView.this.sc(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jMu = DistributeVideoView.this.jMq;
                    DistributeVideoView.this.sc(true);
                }
            }
        };
        this.gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sc(true);
                    }
                }
            }
        };
        this.jMA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.se(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.jMs = adCard;
        if (this.jMs != null) {
            this.parallelChargeInfo = this.jMs.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.egS = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.jMi = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hlG = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.jMj = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.jbO = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.jMm = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.jMk = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.jMn = this.mRootView.findViewById(R.id.distribute_control);
            this.jMo = (ImageView) this.jMn.findViewById(R.id.distribute_play_icon);
            this.jMl = (ImageView) this.jMn.findViewById(R.id.distribute_voice);
            this.jMp = (VideoControllerView) this.jMn.findViewById(R.id.distribute_process);
            this.jIM = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.jIN = new d(context, this.jIM);
            this.jMi.setAnimation(R.raw.lotti_video_loading);
            this.jMi.setMinFrame(0);
            this.jMi.setFrame(0);
        }
    }

    private boolean csN() {
        return this.mStyle == 1 ? s.csN() : j.isWifiNet();
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
        this.jFs = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.jFt = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jbG = videoInfo;
        this.mDuration = this.jbG.video_duration.intValue() * 1000;
        this.OC = new WeakReference<>(this.mContext.getApplicationContext());
        cCg();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.jbG.video_width.intValue() > 0 ? (this.jbG.video_height.intValue() * equipmentWidth) / this.jbG.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hlG.setDefaultErrorResource(0);
        this.hlG.setDefaultResource(0);
        this.hlG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hlG.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.egS.setOnPreparedListener(this.dQX);
        this.egS.setOnErrorListener(this.dIa);
        this.egS.setOnCompletionListener(this.dQW);
        this.egS.setOnOutInfoListener(this.dQZ);
        this.egS.setOnSurfaceDestroyedListener(this.dIe);
        am.setViewTextColor(this.jMj, (int) R.color.cp_cont_m);
        this.jMj.setText(StringUtils.translateSecondsToString(this.jbG.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jMq = false;
            am.setImageResource(this.jMk, R.drawable.icon_vedio_npronunciation_small_white);
            this.jMk.setVisibility(8);
        } else {
            this.jMq = true;
            am.setImageResource(this.jMl, R.drawable.ad_icon_sound_open);
            this.jMk.setVisibility(8);
        }
        this.jMl.setOnClickListener(this.mOnClickListener);
        this.jMk.setOnClickListener(this.mOnClickListener);
        this.jbO.setOnClickListener(this.mOnClickListener);
        this.jbO.setVisibility(8);
        am.setBackgroundColor(this.jbO, R.color.black_alpha80);
        am.setViewTextColor(this.jMm, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.jMj.setVisibility(0);
            return;
        }
        this.jMj.setVisibility(8);
        this.jMo.setOnClickListener(this.mOnClickListener);
        this.jMi.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jbG = videoInfo;
        this.OC = new WeakReference<>(this.mContext.getApplicationContext());
        cCg();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hlG.setDefaultErrorResource(0);
        this.hlG.setDefaultResource(0);
        this.hlG.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hlG.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.egS.setOnPreparedListener(this.dQX);
        this.egS.setOnErrorListener(this.dIa);
        this.egS.setOnCompletionListener(this.dQW);
        this.egS.setOnOutInfoListener(this.dQZ);
        this.egS.setOnSurfaceDestroyedListener(this.dIe);
        am.setViewTextColor(this.jMj, (int) R.color.cp_cont_m);
        this.jMj.setText(StringUtils.translateSecondsToString(this.jbG.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jMq = false;
            am.setImageResource(this.jMk, R.drawable.icon_vedio_npronunciation_small_white);
            this.jMk.setVisibility(8);
        } else {
            this.jMq = true;
            am.setImageResource(this.jMl, R.drawable.ad_icon_sound_open);
            this.jMk.setVisibility(8);
        }
        this.jMl.setOnClickListener(this.mOnClickListener);
        this.jMk.setOnClickListener(this.mOnClickListener);
        this.jbO.setOnClickListener(this.mOnClickListener);
        this.jbO.setVisibility(8);
        am.setBackgroundColor(this.jbO, R.color.black_alpha80);
        am.setViewTextColor(this.jMm, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.jMj.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.jMj.setVisibility(8);
        this.jMo.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.jMg;
        }
        this.jIO = this.jIN.a(this.jFt, this.jIO);
        if (this.jIO != null) {
            this.jIO.setPageContext(this.mPageContext);
            this.jIO.c(this.jMs);
            if (this.jIO instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.jIO).sa(this.jLf);
            }
            this.jIO.setAdvertAppInfo(advertAppInfo);
            this.jIO.a(this.jFt);
            this.jIO.cBZ();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.jLf = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.jIO != null) {
            this.jIO.setDownloadAppCallback(cVar);
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
        this.dQW = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ(int i) {
        this.jMx = i;
        if (this.jbG != null && this.jbH == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.jMr) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.jIO != null) {
                    this.jIO.cBZ();
                }
                this.egS.setVideoPath(this.jbG.video_url);
                this.egS.start();
                this.jMv = this.egS.getCurrentPosition();
                am.setImageResource(this.jMo, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.jbO.setVisibility(8);
                this.hlG.setForegroundDrawable(0);
                this.jbH = 0;
                if (this.mStyle == 1) {
                    this.jMj.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.jMj.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.jMA);
                MessageManager.getInstance().registerListener(this.jxE);
                MessageManager.getInstance().registerListener(this.gnF);
            }
        }
    }

    public void performPlay() {
        AZ(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (csN()) {
            if (i <= 0) {
                AZ(1);
                return;
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbW);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jbW, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.jbH == 1) {
            D(32, Ba(this.jMx), this.egS.getCurrentPosition(), i);
            this.egS.pause();
            af.a(this.OC, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.jMo, R.drawable.icon_video_midpause);
            this.jbH = 2;
        }
    }

    public void autoContinue() {
        if (!this.jMt) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.jbH == 2) {
            this.jMx = i;
            Y(33, Ba(i), this.egS.getCurrentPosition());
            this.jMv = this.egS.getCurrentPosition();
            this.egS.start();
            if (this.jMq) {
                af.a(this.OC, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.jMo, R.drawable.icon_video_midplay);
            this.jbH = 1;
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
        if (this.jMi != null) {
            this.jMi.setAlpha(1.0f);
            this.jMi.setVisibility(0);
            this.jMi.loop(true);
            this.jMi.setMinAndMaxFrame(14, 80);
            this.jMi.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cCf();
        if (z) {
            this.jMi.setAlpha(1.0f);
            this.jMi.setVisibility(0);
            return;
        }
        this.jMi.setVisibility(8);
    }

    private void cCf() {
        if (this.jMi != null) {
            this.jMi.setMinFrame(0);
            this.jMi.setFrame(0);
            this.jMi.cancelAnimation();
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
        if (this.egS.getCurrentPosition() > 0 && this.jbH != -1 && z) {
            int i = 32;
            int currentPosition = this.egS.getCurrentPosition();
            if (this.egS.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Ba(this.jMx), currentPosition, this.egS.isPlaying());
        }
        cCg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCg() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbW);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMy);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMz);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.egS.stopPlayback();
        this.jbH = -1;
        af.a(this.OC, false);
        se(false);
        this.hlG.setForegroundDrawable(0);
        this.hlG.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.jMo, R.drawable.icon_video_midpause);
        this.jMp.ahT();
        this.jbO.setVisibility(8);
        if (this.jbG != null) {
            this.jMj.setText(StringUtils.translateSecondsToString(this.jbG.video_duration.intValue()));
            this.jMj.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eaK = null;
        this.jMu = false;
        MessageManager.getInstance().unRegisterListener(this.jMA);
        MessageManager.getInstance().unRegisterListener(this.jxE);
        MessageManager.getInstance().unRegisterListener(this.gnF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Ba(int i) {
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
        return this.jbG != null ? this.jbG.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.jIO instanceof com.baidu.tieba.recapp.e.a) && (this.jMs instanceof AdCard) && !((AdCard) this.jMs).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jIO).aVN();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.jIO instanceof com.baidu.tieba.recapp.e.a) && (this.jMs instanceof AdCard) && !((AdCard) this.jMs).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jIO).cBX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z) {
        if (z) {
            if (this.eaK != null) {
                this.eaK.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.jMl, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.jMk, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.jbH == 1) {
                af.a(this.OC, true);
            }
        } else {
            if (this.eaK != null) {
                this.eaK.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.jMl, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.jMk, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.OC, false);
        }
        this.jMq = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.jbH;
    }

    public VideoInfo getData() {
        return this.jbG;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.jbQ;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.jMg = advertAppInfo;
        this.jMh = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.jMg, 303, i, Ba(this.jMx), this.jbG.video_duration.intValue(), this.mDuration, -1);
        if (this.jIO != null) {
            this.jIO.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, int i2, int i3) {
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
        if (this.jMg != null && this.jbG != null) {
            this.jMg.page = this.mPage;
            com.baidu.tieba.recapp.report.c.cBR().a(f.a(this.jMg, i, this.jMh, i2, this.jbG.video_duration.intValue(), com.baidu.tieba.ad.a.a.nS(i3), i4));
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
                c(str, this.jMv, i3, this.mDuration, str2, Bb(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.jFs != null && "cpv".equals(this.jFs.jGt) && !TextUtils.isEmpty(this.jFs.jGu)) {
            new com.baidu.tieba.recapp.request.a(this.jFs.jGu).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Bb(int i) {
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
            this.jMe = view;
            this.jMf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sd(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMy);
            if (this.aHr != null) {
                this.aHr.cancel();
            }
            this.jMn.setVisibility(0);
            if (this.jbH == 1) {
                am.setImageResource(this.jMo, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.jMo, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.jMn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCh() {
        switch (this.jbH) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.jF(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aCp();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.jMt = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    sd(true);
                    return;
                }
                return;
            case 2:
                this.jMt = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMy);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.jMy, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCi() {
        if (!this.csO && this.aHr != null) {
            this.jMn.startAnimation(this.aHr);
            this.csO = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.aHr = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.aHr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.jMn.setVisibility(8);
                    DistributeVideoView.this.csO = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cCj() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMz);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jMz, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(boolean z) {
        if (this.jMk != null && this.mStyle == 1) {
            if (z) {
                this.jMk.setVisibility(0);
                cCj();
                return;
            }
            this.jMk.setVisibility(8);
        }
    }
}
