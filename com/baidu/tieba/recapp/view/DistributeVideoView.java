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
    private AdCard.a jFn;
    private AdCard.f jFo;
    private ViewGroup jIH;
    private d jII;
    private e jIJ;
    private View jLZ;
    private boolean jLa;
    private boolean jMa;
    private AdvertAppInfo jMb;
    private int jMc;
    private TBLottieAnimationView jMd;
    private TextView jMe;
    private ImageView jMf;
    private ImageView jMg;
    private TextView jMh;
    private View jMi;
    private ImageView jMj;
    private VideoControllerView jMk;
    private boolean jMl;
    private long jMm;
    private b jMn;
    boolean jMo;
    private boolean jMp;
    private int jMq;
    boolean jMr;
    private int jMs;
    private Runnable jMt;
    private Runnable jMu;
    private CustomMessageListener jMv;
    private VideoInfo jbB;
    private int jbC;
    private View jbJ;
    private long jbL;
    private Runnable jbR;
    private CustomMessageListener jxz;
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
        if (this.jMb != null) {
            WebVideoActivity.jFh = new WebVideoActivity.a();
            WebVideoActivity.jFh.jFr = this.jMb;
            WebVideoActivity.jFh.mPage = "DETAIL";
            WebVideoActivity.jFh.mPageNum = this.jMc;
            NewWebVideoActivity.jFs = new NewWebVideoActivity.a();
            NewWebVideoActivity.jFs.jFr = this.jMb;
            NewWebVideoActivity.jFs.mPage = "DETAIL";
            NewWebVideoActivity.jFs.mPageNum = this.jMc;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.jMb.cIU, true, true, true, this.jbB.video_url, this.jbB.thumbnail_url, this.jbB.video_width.intValue() / this.jbB.video_height.intValue(), this.jbB.video_duration.intValue(), this.jMb.cIS);
        if (this.jFn != null) {
            newWebVideoActivityConfig.setChargeStyle(this.jFn.jGo);
            newWebVideoActivityConfig.setChargeUrl(this.jFn.jGp);
        }
        if (this.jFo != null) {
            newWebVideoActivityConfig.setTailFrame(this.jFo.toJsonString());
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
    public void cyf() {
        if (this.jMd != null) {
            this.jMd.clearAnimation();
            this.jMd.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.jMd.setVisibility(8);
                    DistributeVideoView.this.hlG.setVisibility(8);
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMl);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.jMe.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.jMk.setPlayer(DistributeVideoView.this.egS);
                        DistributeVideoView.this.jMk.aZ(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.jbB.video_duration.intValue()));
                        DistributeVideoView.this.jMk.showProgress();
                        DistributeVideoView.this.sd(true);
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(DistributeVideoView.this.jMt);
                        com.baidu.adp.lib.f.e.gx().postDelayed(DistributeVideoView.this.jMt, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.jbL = DistributeVideoView.this.egS.getCurrentPosition();
                    DistributeVideoView.this.se(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.jMd.setMinFrame(0);
                    DistributeVideoView.this.jMd.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.jMa = false;
        this.OC = null;
        this.jbC = -1;
        this.jbL = 0L;
        this.jMl = false;
        this.jMm = 0L;
        this.mStyle = 1;
        this.csO = false;
        this.jMo = false;
        this.jMp = false;
        this.jMr = false;
        this.jMs = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jbJ) {
                    DistributeVideoView.this.jbJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jMg || view == DistributeVideoView.this.jMf) {
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMl ? false : true);
                } else if (view == DistributeVideoView.this.jMd || view == DistributeVideoView.this.jMj) {
                    DistributeVideoView.this.cCf();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jMb == null || !DistributeVideoView.this.jMb.ayb()) {
                    if (DistributeVideoView.this.jMn instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jMn;
                        if (!adCard.getAdvertAppInfo().aya() || adCard.directDownload) {
                            DistributeVideoView.this.cCf();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bYD();
                        return;
                    }
                    DistributeVideoView.this.cCf();
                } else {
                    if (DistributeVideoView.this.jMb != null) {
                        WebVideoActivity.jFh = new WebVideoActivity.a();
                        WebVideoActivity.jFh.jFr = DistributeVideoView.this.jMb;
                        WebVideoActivity.jFh.mPage = "DETAIL";
                        WebVideoActivity.jFh.mPageNum = DistributeVideoView.this.jMc;
                        NewWebVideoActivity.jFs = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jFs.jFr = DistributeVideoView.this.jMb;
                        NewWebVideoActivity.jFs.mPage = "DETAIL";
                        NewWebVideoActivity.jFs.mPageNum = DistributeVideoView.this.jMc;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jMb.cIU;
                    if (a.aSU().aSV() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbB.video_url, DistributeVideoView.this.jbB.thumbnail_url, DistributeVideoView.this.jbB.video_width.intValue() / DistributeVideoView.this.jbB.video_height.intValue(), DistributeVideoView.this.jbB.video_duration.intValue(), DistributeVideoView.this.jMb.cIS);
                        if (DistributeVideoView.this.jFn != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFn.jGo);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFn.jGp);
                        }
                        if (DistributeVideoView.this.jFo != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFo.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbB.video_url, DistributeVideoView.this.jbB.thumbnail_url, DistributeVideoView.this.jbB.video_width.intValue() / DistributeVideoView.this.jbB.video_height.intValue(), DistributeVideoView.this.jbB.video_duration.intValue());
                        if (DistributeVideoView.this.jFn != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFn.jGo);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFn.jGp);
                        }
                        if (DistributeVideoView.this.jFo != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFo.toJsonString());
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
                        if (DistributeVideoView.this.jbC != 1) {
                            if (DistributeVideoView.this.egS.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jbC = 1;
                                DistributeVideoView.this.cyf();
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
                        if (DistributeVideoView.this.jbC == 1) {
                            if (DistributeVideoView.this.jbL == DistributeVideoView.this.egS.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jbL = DistributeVideoView.this.egS.getCurrentPosition();
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
                    DistributeVideoView.this.jMq = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaK = gVar;
                    DistributeVideoView.this.eaK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jMl && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sc(false);
                    }
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jMb != null) {
                    if (DistributeVideoView.this.jMr && "DETAIL".equals(DistributeVideoView.this.jMb.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), 0);
                }
                return false;
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cCe();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), gVar.getCurrentPosition());
                DistributeVideoView.this.hlG.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jbJ.setVisibility(0);
                return true;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jMm = System.currentTimeMillis();
                DistributeVideoView.this.jMr = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), gVar.getDuration());
                DistributeVideoView.this.cCe();
                if (DistributeVideoView.this.jIJ != null) {
                    DistributeVideoView.this.jIJ.cBW();
                    DistributeVideoView.this.jMe.setVisibility(8);
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
        this.jbR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jbB != null && DistributeVideoView.this.egS != null) {
                    DistributeVideoView.this.AZ(1);
                }
            }
        };
        this.jMt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cCg();
            }
        };
        this.jMu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.se(false);
            }
        };
        this.jxz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jMp) {
                            DistributeVideoView.this.sc(true);
                            return;
                        } else {
                            DistributeVideoView.this.sc(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jMp = DistributeVideoView.this.jMl;
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
        this.jMv = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.jMa = false;
        this.OC = null;
        this.jbC = -1;
        this.jbL = 0L;
        this.jMl = false;
        this.jMm = 0L;
        this.mStyle = 1;
        this.csO = false;
        this.jMo = false;
        this.jMp = false;
        this.jMr = false;
        this.jMs = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jbJ) {
                    DistributeVideoView.this.jbJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jMg || view == DistributeVideoView.this.jMf) {
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMl ? false : true);
                } else if (view == DistributeVideoView.this.jMd || view == DistributeVideoView.this.jMj) {
                    DistributeVideoView.this.cCf();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jMb == null || !DistributeVideoView.this.jMb.ayb()) {
                    if (DistributeVideoView.this.jMn instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jMn;
                        if (!adCard.getAdvertAppInfo().aya() || adCard.directDownload) {
                            DistributeVideoView.this.cCf();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bYD();
                        return;
                    }
                    DistributeVideoView.this.cCf();
                } else {
                    if (DistributeVideoView.this.jMb != null) {
                        WebVideoActivity.jFh = new WebVideoActivity.a();
                        WebVideoActivity.jFh.jFr = DistributeVideoView.this.jMb;
                        WebVideoActivity.jFh.mPage = "DETAIL";
                        WebVideoActivity.jFh.mPageNum = DistributeVideoView.this.jMc;
                        NewWebVideoActivity.jFs = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jFs.jFr = DistributeVideoView.this.jMb;
                        NewWebVideoActivity.jFs.mPage = "DETAIL";
                        NewWebVideoActivity.jFs.mPageNum = DistributeVideoView.this.jMc;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jMb.cIU;
                    if (a.aSU().aSV() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbB.video_url, DistributeVideoView.this.jbB.thumbnail_url, DistributeVideoView.this.jbB.video_width.intValue() / DistributeVideoView.this.jbB.video_height.intValue(), DistributeVideoView.this.jbB.video_duration.intValue(), DistributeVideoView.this.jMb.cIS);
                        if (DistributeVideoView.this.jFn != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFn.jGo);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFn.jGp);
                        }
                        if (DistributeVideoView.this.jFo != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFo.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbB.video_url, DistributeVideoView.this.jbB.thumbnail_url, DistributeVideoView.this.jbB.video_width.intValue() / DistributeVideoView.this.jbB.video_height.intValue(), DistributeVideoView.this.jbB.video_duration.intValue());
                        if (DistributeVideoView.this.jFn != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFn.jGo);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFn.jGp);
                        }
                        if (DistributeVideoView.this.jFo != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFo.toJsonString());
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
                        if (DistributeVideoView.this.jbC != 1) {
                            if (DistributeVideoView.this.egS.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jbC = 1;
                                DistributeVideoView.this.cyf();
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
                        if (DistributeVideoView.this.jbC == 1) {
                            if (DistributeVideoView.this.jbL == DistributeVideoView.this.egS.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jbL = DistributeVideoView.this.egS.getCurrentPosition();
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
                    DistributeVideoView.this.jMq = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaK = gVar;
                    DistributeVideoView.this.eaK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jMl && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sc(false);
                    }
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jMb != null) {
                    if (DistributeVideoView.this.jMr && "DETAIL".equals(DistributeVideoView.this.jMb.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), 0);
                }
                return false;
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cCe();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), gVar.getCurrentPosition());
                DistributeVideoView.this.hlG.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jbJ.setVisibility(0);
                return true;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jMm = System.currentTimeMillis();
                DistributeVideoView.this.jMr = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), gVar.getDuration());
                DistributeVideoView.this.cCe();
                if (DistributeVideoView.this.jIJ != null) {
                    DistributeVideoView.this.jIJ.cBW();
                    DistributeVideoView.this.jMe.setVisibility(8);
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
        this.jbR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jbB != null && DistributeVideoView.this.egS != null) {
                    DistributeVideoView.this.AZ(1);
                }
            }
        };
        this.jMt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cCg();
            }
        };
        this.jMu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.se(false);
            }
        };
        this.jxz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jMp) {
                            DistributeVideoView.this.sc(true);
                            return;
                        } else {
                            DistributeVideoView.this.sc(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jMp = DistributeVideoView.this.jMl;
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
        this.jMv = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.jMa = false;
        this.OC = null;
        this.jbC = -1;
        this.jbL = 0L;
        this.jMl = false;
        this.jMm = 0L;
        this.mStyle = 1;
        this.csO = false;
        this.jMo = false;
        this.jMp = false;
        this.jMr = false;
        this.jMs = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jbJ) {
                    DistributeVideoView.this.jbJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jMg || view == DistributeVideoView.this.jMf) {
                    DistributeVideoView.this.sc(DistributeVideoView.this.jMl ? false : true);
                } else if (view == DistributeVideoView.this.jMd || view == DistributeVideoView.this.jMj) {
                    DistributeVideoView.this.cCf();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jMb == null || !DistributeVideoView.this.jMb.ayb()) {
                    if (DistributeVideoView.this.jMn instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jMn;
                        if (!adCard.getAdvertAppInfo().aya() || adCard.directDownload) {
                            DistributeVideoView.this.cCf();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bYD();
                        return;
                    }
                    DistributeVideoView.this.cCf();
                } else {
                    if (DistributeVideoView.this.jMb != null) {
                        WebVideoActivity.jFh = new WebVideoActivity.a();
                        WebVideoActivity.jFh.jFr = DistributeVideoView.this.jMb;
                        WebVideoActivity.jFh.mPage = "DETAIL";
                        WebVideoActivity.jFh.mPageNum = DistributeVideoView.this.jMc;
                        NewWebVideoActivity.jFs = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jFs.jFr = DistributeVideoView.this.jMb;
                        NewWebVideoActivity.jFs.mPage = "DETAIL";
                        NewWebVideoActivity.jFs.mPageNum = DistributeVideoView.this.jMc;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jMb.cIU;
                    if (a.aSU().aSV() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbB.video_url, DistributeVideoView.this.jbB.thumbnail_url, DistributeVideoView.this.jbB.video_width.intValue() / DistributeVideoView.this.jbB.video_height.intValue(), DistributeVideoView.this.jbB.video_duration.intValue(), DistributeVideoView.this.jMb.cIS);
                        if (DistributeVideoView.this.jFn != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFn.jGo);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFn.jGp);
                        }
                        if (DistributeVideoView.this.jFo != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFo.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jbB.video_url, DistributeVideoView.this.jbB.thumbnail_url, DistributeVideoView.this.jbB.video_width.intValue() / DistributeVideoView.this.jbB.video_height.intValue(), DistributeVideoView.this.jbB.video_duration.intValue());
                        if (DistributeVideoView.this.jFn != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jFn.jGo);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jFn.jGp);
                        }
                        if (DistributeVideoView.this.jFo != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jFo.toJsonString());
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
                        if (DistributeVideoView.this.jbC != 1) {
                            if (DistributeVideoView.this.egS.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jbC = 1;
                                DistributeVideoView.this.cyf();
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
                        if (DistributeVideoView.this.jbC == 1) {
                            if (DistributeVideoView.this.jbL == DistributeVideoView.this.egS.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jbL = DistributeVideoView.this.egS.getCurrentPosition();
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
                    DistributeVideoView.this.jMq = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaK = gVar;
                    DistributeVideoView.this.eaK.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jMl && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sc(false);
                    }
                }
            }
        };
        this.dQZ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.jMb != null) {
                    if (DistributeVideoView.this.jMr && "DETAIL".equals(DistributeVideoView.this.jMb.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), 0);
                }
                return false;
            }
        };
        this.dIa = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cCe();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), gVar.getCurrentPosition());
                DistributeVideoView.this.hlG.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jbJ.setVisibility(0);
                return true;
            }
        };
        this.dQW = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jMm = System.currentTimeMillis();
                DistributeVideoView.this.jMr = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.Ba(DistributeVideoView.this.jMs), gVar.getDuration());
                DistributeVideoView.this.cCe();
                if (DistributeVideoView.this.jIJ != null) {
                    DistributeVideoView.this.jIJ.cBW();
                    DistributeVideoView.this.jMe.setVisibility(8);
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
        this.jbR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jbB != null && DistributeVideoView.this.egS != null) {
                    DistributeVideoView.this.AZ(1);
                }
            }
        };
        this.jMt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cCg();
            }
        };
        this.jMu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.se(false);
            }
        };
        this.jxz = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jMp) {
                            DistributeVideoView.this.sc(true);
                            return;
                        } else {
                            DistributeVideoView.this.sc(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jMp = DistributeVideoView.this.jMl;
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
        this.jMv = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.jMn = adCard;
        if (this.jMn != null) {
            this.parallelChargeInfo = this.jMn.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.egS = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.jMd = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hlG = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.jMe = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.jbJ = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.jMh = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.jMf = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.jMi = this.mRootView.findViewById(R.id.distribute_control);
            this.jMj = (ImageView) this.jMi.findViewById(R.id.distribute_play_icon);
            this.jMg = (ImageView) this.jMi.findViewById(R.id.distribute_voice);
            this.jMk = (VideoControllerView) this.jMi.findViewById(R.id.distribute_process);
            this.jIH = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.jII = new d(context, this.jIH);
            this.jMd.setAnimation(R.raw.lotti_video_loading);
            this.jMd.setMinFrame(0);
            this.jMd.setFrame(0);
        }
    }

    private boolean csL() {
        return this.mStyle == 1 ? s.csL() : j.isWifiNet();
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
        this.jFn = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.jFo = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jbB = videoInfo;
        this.mDuration = this.jbB.video_duration.intValue() * 1000;
        this.OC = new WeakReference<>(this.mContext.getApplicationContext());
        cCe();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.jbB.video_width.intValue() > 0 ? (this.jbB.video_height.intValue() * equipmentWidth) / this.jbB.video_width.intValue() : equipmentWidth;
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
        am.setViewTextColor(this.jMe, (int) R.color.cp_cont_m);
        this.jMe.setText(StringUtils.translateSecondsToString(this.jbB.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jMl = false;
            am.setImageResource(this.jMf, R.drawable.icon_vedio_npronunciation_small_white);
            this.jMf.setVisibility(8);
        } else {
            this.jMl = true;
            am.setImageResource(this.jMg, R.drawable.ad_icon_sound_open);
            this.jMf.setVisibility(8);
        }
        this.jMg.setOnClickListener(this.mOnClickListener);
        this.jMf.setOnClickListener(this.mOnClickListener);
        this.jbJ.setOnClickListener(this.mOnClickListener);
        this.jbJ.setVisibility(8);
        am.setBackgroundColor(this.jbJ, R.color.black_alpha80);
        am.setViewTextColor(this.jMh, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.jMe.setVisibility(0);
            return;
        }
        this.jMe.setVisibility(8);
        this.jMj.setOnClickListener(this.mOnClickListener);
        this.jMd.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jbB = videoInfo;
        this.OC = new WeakReference<>(this.mContext.getApplicationContext());
        cCe();
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
        am.setViewTextColor(this.jMe, (int) R.color.cp_cont_m);
        this.jMe.setText(StringUtils.translateSecondsToString(this.jbB.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jMl = false;
            am.setImageResource(this.jMf, R.drawable.icon_vedio_npronunciation_small_white);
            this.jMf.setVisibility(8);
        } else {
            this.jMl = true;
            am.setImageResource(this.jMg, R.drawable.ad_icon_sound_open);
            this.jMf.setVisibility(8);
        }
        this.jMg.setOnClickListener(this.mOnClickListener);
        this.jMf.setOnClickListener(this.mOnClickListener);
        this.jbJ.setOnClickListener(this.mOnClickListener);
        this.jbJ.setVisibility(8);
        am.setBackgroundColor(this.jbJ, R.color.black_alpha80);
        am.setViewTextColor(this.jMh, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.jMe.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.jMe.setVisibility(8);
        this.jMj.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.jMb;
        }
        this.jIJ = this.jII.a(this.jFo, this.jIJ);
        if (this.jIJ != null) {
            this.jIJ.setPageContext(this.mPageContext);
            this.jIJ.c(this.jMn);
            if (this.jIJ instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.jIJ).sa(this.jLa);
            }
            this.jIJ.setAdvertAppInfo(advertAppInfo);
            this.jIJ.a(this.jFo);
            this.jIJ.cBX();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.jLa = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.jIJ != null) {
            this.jIJ.setDownloadAppCallback(cVar);
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
        this.jMs = i;
        if (this.jbB != null && this.jbC == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.jMm) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.jIJ != null) {
                    this.jIJ.cBX();
                }
                this.egS.setVideoPath(this.jbB.video_url);
                this.egS.start();
                this.jMq = this.egS.getCurrentPosition();
                am.setImageResource(this.jMj, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.jbJ.setVisibility(8);
                this.hlG.setForegroundDrawable(0);
                this.jbC = 0;
                if (this.mStyle == 1) {
                    this.jMe.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.jMe.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.jMv);
                MessageManager.getInstance().registerListener(this.jxz);
                MessageManager.getInstance().registerListener(this.gnF);
            }
        }
    }

    public void performPlay() {
        AZ(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (csL()) {
            if (i <= 0) {
                AZ(1);
                return;
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbR);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jbR, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.jbC == 1) {
            D(32, Ba(this.jMs), this.egS.getCurrentPosition(), i);
            this.egS.pause();
            af.a(this.OC, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.jMj, R.drawable.icon_video_midpause);
            this.jbC = 2;
        }
    }

    public void autoContinue() {
        if (!this.jMo) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.jbC == 2) {
            this.jMs = i;
            Y(33, Ba(i), this.egS.getCurrentPosition());
            this.jMq = this.egS.getCurrentPosition();
            this.egS.start();
            if (this.jMl) {
                af.a(this.OC, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.jMj, R.drawable.icon_video_midplay);
            this.jbC = 1;
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
        if (this.jMd != null) {
            this.jMd.setAlpha(1.0f);
            this.jMd.setVisibility(0);
            this.jMd.loop(true);
            this.jMd.setMinAndMaxFrame(14, 80);
            this.jMd.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cCd();
        if (z) {
            this.jMd.setAlpha(1.0f);
            this.jMd.setVisibility(0);
            return;
        }
        this.jMd.setVisibility(8);
    }

    private void cCd() {
        if (this.jMd != null) {
            this.jMd.setMinFrame(0);
            this.jMd.setFrame(0);
            this.jMd.cancelAnimation();
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
        if (this.egS.getCurrentPosition() > 0 && this.jbC != -1 && z) {
            int i = 32;
            int currentPosition = this.egS.getCurrentPosition();
            if (this.egS.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Ba(this.jMs), currentPosition, this.egS.isPlaying());
        }
        cCe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCe() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jbR);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMt);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMu);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.egS.stopPlayback();
        this.jbC = -1;
        af.a(this.OC, false);
        se(false);
        this.hlG.setForegroundDrawable(0);
        this.hlG.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.jMj, R.drawable.icon_video_midpause);
        this.jMk.ahT();
        this.jbJ.setVisibility(8);
        if (this.jbB != null) {
            this.jMe.setText(StringUtils.translateSecondsToString(this.jbB.video_duration.intValue()));
            this.jMe.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eaK = null;
        this.jMp = false;
        MessageManager.getInstance().unRegisterListener(this.jMv);
        MessageManager.getInstance().unRegisterListener(this.jxz);
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
        return this.jbB != null ? this.jbB.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.jIJ instanceof com.baidu.tieba.recapp.e.a) && (this.jMn instanceof AdCard) && !((AdCard) this.jMn).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jIJ).aVN();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.jIJ instanceof com.baidu.tieba.recapp.e.a) && (this.jMn instanceof AdCard) && !((AdCard) this.jMn).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jIJ).cBV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z) {
        if (z) {
            if (this.eaK != null) {
                this.eaK.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.jMg, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.jMf, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.jbC == 1) {
                af.a(this.OC, true);
            }
        } else {
            if (this.eaK != null) {
                this.eaK.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.jMg, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.jMf, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.OC, false);
        }
        this.jMl = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.jbC;
    }

    public VideoInfo getData() {
        return this.jbB;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.jbL;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.jMb = advertAppInfo;
        this.jMc = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.jMb, 303, i, Ba(this.jMs), this.jbB.video_duration.intValue(), this.mDuration, -1);
        if (this.jIJ != null) {
            this.jIJ.e(a);
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
        if (this.jMb != null && this.jbB != null) {
            this.jMb.page = this.mPage;
            com.baidu.tieba.recapp.report.c.cBP().a(f.a(this.jMb, i, this.jMc, i2, this.jbB.video_duration.intValue(), com.baidu.tieba.ad.a.a.nS(i3), i4));
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
                c(str, this.jMq, i3, this.mDuration, str2, Bb(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.jFn != null && "cpv".equals(this.jFn.jGo) && !TextUtils.isEmpty(this.jFn.jGp)) {
            new com.baidu.tieba.recapp.request.a(this.jFn.jGp).a(str, i, i2, i3, str2, str3);
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
            this.jLZ = view;
            this.jMa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sd(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMt);
            if (this.aHr != null) {
                this.aHr.cancel();
            }
            this.jMi.setVisibility(0);
            if (this.jbC == 1) {
                am.setImageResource(this.jMj, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.jMj, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.jMi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCf() {
        switch (this.jbC) {
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
                this.jMo = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    sd(true);
                    return;
                }
                return;
            case 2:
                this.jMo = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMt);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.jMt, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCg() {
        if (!this.csO && this.aHr != null) {
            this.jMi.startAnimation(this.aHr);
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
                    DistributeVideoView.this.jMi.setVisibility(8);
                    DistributeVideoView.this.csO = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cCh() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jMu);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jMu, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void se(boolean z) {
        if (this.jMf != null && this.mStyle == 1) {
            if (z) {
                this.jMf.setVisibility(0);
                cCh();
                return;
            }
            this.jMf.setVisibility(8);
        }
    }
}
