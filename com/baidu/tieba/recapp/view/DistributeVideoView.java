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
/* loaded from: classes13.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> Pf;
    private Animation aLw;
    boolean cwQ;
    private g.b dMf;
    private QuickVideoView.b dMj;
    private g.a dVb;
    private g.f dVc;
    private g.e dVe;
    private g eeN;
    private QuickVideoView ekW;
    private CustomMessageListener gpG;
    private ForeDrawableImageView hnH;
    private AdCard.a jGj;
    private AdCard.f jGk;
    private ViewGroup jJI;
    private d jJJ;
    private e jJK;
    private boolean jMb;
    private CustomMessageListener jNA;
    private View jNa;
    private boolean jNb;
    private VideoInfo jNc;
    private AdvertAppInfo jNd;
    private int jNe;
    private TBLottieAnimationView jNf;
    private TextView jNg;
    private ImageView jNh;
    private ImageView jNi;
    private View jNj;
    private TextView jNk;
    private View jNl;
    private ImageView jNm;
    private VideoControllerView jNn;
    private long jNo;
    private boolean jNp;
    private long jNq;
    private b jNr;
    boolean jNs;
    private boolean jNt;
    private int jNu;
    boolean jNv;
    private int jNw;
    private Runnable jNx;
    private Runnable jNy;
    private Runnable jNz;
    private int jvk;
    private CustomMessageListener jyu;
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
        if (this.jNd != null) {
            WebVideoActivity.jGd = new WebVideoActivity.a();
            WebVideoActivity.jGd.jGn = this.jNd;
            WebVideoActivity.jGd.mPage = "DETAIL";
            WebVideoActivity.jGd.mPageNum = this.jNe;
            NewWebVideoActivity.jGo = new NewWebVideoActivity.a();
            NewWebVideoActivity.jGo.jGn = this.jNd;
            NewWebVideoActivity.jGo.mPage = "DETAIL";
            NewWebVideoActivity.jGo.mPageNum = this.jNe;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.jNd.cMX, true, true, true, this.jNc.video_url, this.jNc.thumbnail_url, this.jNc.video_width.intValue() / this.jNc.video_height.intValue(), this.jNc.video_duration.intValue(), this.jNd.cMV);
        if (this.jGj != null) {
            newWebVideoActivityConfig.setChargeStyle(this.jGj.jHk);
            newWebVideoActivityConfig.setChargeUrl(this.jGj.jHl);
        }
        if (this.jGk != null) {
            newWebVideoActivityConfig.setTailFrame(this.jGk.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cae() {
        Z(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.Ec(this.parallelChargeInfo.hXK);
            Iterator<String> it = this.parallelChargeInfo.hXN.iterator();
            while (it.hasNext()) {
                c.Ec(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czB() {
        if (this.jNf != null) {
            this.jNf.clearAnimation();
            this.jNf.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.jNf.setVisibility(8);
                    DistributeVideoView.this.hnH.setVisibility(8);
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNp);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.jNg.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.jNn.setPlayer(DistributeVideoView.this.ekW);
                        DistributeVideoView.this.jNn.aZ(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.jNc.video_duration.intValue()));
                        DistributeVideoView.this.jNn.showProgress();
                        DistributeVideoView.this.sg(true);
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(DistributeVideoView.this.jNy);
                        com.baidu.adp.lib.f.e.gx().postDelayed(DistributeVideoView.this.jNy, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.jNo = DistributeVideoView.this.ekW.getCurrentPosition();
                    DistributeVideoView.this.sh(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.jNf.setMinFrame(0);
                    DistributeVideoView.this.jNf.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.jNb = false;
        this.Pf = null;
        this.jvk = -1;
        this.jNo = 0L;
        this.jNp = false;
        this.jNq = 0L;
        this.mStyle = 1;
        this.cwQ = false;
        this.jNs = false;
        this.jNt = false;
        this.jNv = false;
        this.jNw = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jNj) {
                    DistributeVideoView.this.jNj.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jNi || view == DistributeVideoView.this.jNh) {
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNp ? false : true);
                } else if (view == DistributeVideoView.this.jNf || view == DistributeVideoView.this.jNm) {
                    DistributeVideoView.this.cDE();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jNd == null || !DistributeVideoView.this.jNd.aAp()) {
                    if (DistributeVideoView.this.jNr instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jNr;
                        if (!adCard.getAdvertAppInfo().aAo() || adCard.directDownload) {
                            DistributeVideoView.this.cDE();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cae();
                        return;
                    }
                    DistributeVideoView.this.cDE();
                } else {
                    if (DistributeVideoView.this.jNd != null) {
                        WebVideoActivity.jGd = new WebVideoActivity.a();
                        WebVideoActivity.jGd.jGn = DistributeVideoView.this.jNd;
                        WebVideoActivity.jGd.mPage = "DETAIL";
                        WebVideoActivity.jGd.mPageNum = DistributeVideoView.this.jNe;
                        NewWebVideoActivity.jGo = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jGo.jGn = DistributeVideoView.this.jNd;
                        NewWebVideoActivity.jGo.mPage = "DETAIL";
                        NewWebVideoActivity.jGo.mPageNum = DistributeVideoView.this.jNe;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jNd.cMX;
                    if (a.aVl().aVm() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNc.video_url, DistributeVideoView.this.jNc.thumbnail_url, DistributeVideoView.this.jNc.video_width.intValue() / DistributeVideoView.this.jNc.video_height.intValue(), DistributeVideoView.this.jNc.video_duration.intValue(), DistributeVideoView.this.jNd.cMV);
                        if (DistributeVideoView.this.jGj != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGj.jHk);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGj.jHl);
                        }
                        if (DistributeVideoView.this.jGk != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGk.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNc.video_url, DistributeVideoView.this.jNc.thumbnail_url, DistributeVideoView.this.jNc.video_width.intValue() / DistributeVideoView.this.jNc.video_height.intValue(), DistributeVideoView.this.jNc.video_duration.intValue());
                        if (DistributeVideoView.this.jGj != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGj.jHk);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGj.jHl);
                        }
                        if (DistributeVideoView.this.jGk != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGk.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cae();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jvk != 1) {
                            if (DistributeVideoView.this.ekW.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jvk = 1;
                                DistributeVideoView.this.czB();
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
                        if (DistributeVideoView.this.jvk == 1) {
                            if (DistributeVideoView.this.jNo == DistributeVideoView.this.ekW.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jNo = DistributeVideoView.this.ekW.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jNu = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eeN = gVar;
                    DistributeVideoView.this.eeN.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jNp && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sf(false);
                    }
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jNd != null) {
                    if (DistributeVideoView.this.jNv && "DETAIL".equals(DistributeVideoView.this.jNd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), 0);
                }
                return false;
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cDD();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), gVar.getCurrentPosition());
                DistributeVideoView.this.hnH.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jNj.setVisibility(0);
                return true;
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jNq = System.currentTimeMillis();
                DistributeVideoView.this.jNv = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), gVar.getDuration());
                DistributeVideoView.this.cDD();
                if (DistributeVideoView.this.jJK != null) {
                    DistributeVideoView.this.jJK.cDu();
                    DistributeVideoView.this.jNg.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jNx = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jNc != null && DistributeVideoView.this.ekW != null) {
                    DistributeVideoView.this.Bi(1);
                }
            }
        };
        this.jNy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cDF();
            }
        };
        this.jNz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sh(false);
            }
        };
        this.jyu = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jNt) {
                            DistributeVideoView.this.sf(true);
                            return;
                        } else {
                            DistributeVideoView.this.sf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jNt = DistributeVideoView.this.jNp;
                    DistributeVideoView.this.sf(true);
                }
            }
        };
        this.gpG = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sf(true);
                    }
                }
            }
        };
        this.jNA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sh(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jNb = false;
        this.Pf = null;
        this.jvk = -1;
        this.jNo = 0L;
        this.jNp = false;
        this.jNq = 0L;
        this.mStyle = 1;
        this.cwQ = false;
        this.jNs = false;
        this.jNt = false;
        this.jNv = false;
        this.jNw = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jNj) {
                    DistributeVideoView.this.jNj.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jNi || view == DistributeVideoView.this.jNh) {
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNp ? false : true);
                } else if (view == DistributeVideoView.this.jNf || view == DistributeVideoView.this.jNm) {
                    DistributeVideoView.this.cDE();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jNd == null || !DistributeVideoView.this.jNd.aAp()) {
                    if (DistributeVideoView.this.jNr instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jNr;
                        if (!adCard.getAdvertAppInfo().aAo() || adCard.directDownload) {
                            DistributeVideoView.this.cDE();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cae();
                        return;
                    }
                    DistributeVideoView.this.cDE();
                } else {
                    if (DistributeVideoView.this.jNd != null) {
                        WebVideoActivity.jGd = new WebVideoActivity.a();
                        WebVideoActivity.jGd.jGn = DistributeVideoView.this.jNd;
                        WebVideoActivity.jGd.mPage = "DETAIL";
                        WebVideoActivity.jGd.mPageNum = DistributeVideoView.this.jNe;
                        NewWebVideoActivity.jGo = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jGo.jGn = DistributeVideoView.this.jNd;
                        NewWebVideoActivity.jGo.mPage = "DETAIL";
                        NewWebVideoActivity.jGo.mPageNum = DistributeVideoView.this.jNe;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jNd.cMX;
                    if (a.aVl().aVm() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNc.video_url, DistributeVideoView.this.jNc.thumbnail_url, DistributeVideoView.this.jNc.video_width.intValue() / DistributeVideoView.this.jNc.video_height.intValue(), DistributeVideoView.this.jNc.video_duration.intValue(), DistributeVideoView.this.jNd.cMV);
                        if (DistributeVideoView.this.jGj != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGj.jHk);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGj.jHl);
                        }
                        if (DistributeVideoView.this.jGk != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGk.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNc.video_url, DistributeVideoView.this.jNc.thumbnail_url, DistributeVideoView.this.jNc.video_width.intValue() / DistributeVideoView.this.jNc.video_height.intValue(), DistributeVideoView.this.jNc.video_duration.intValue());
                        if (DistributeVideoView.this.jGj != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGj.jHk);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGj.jHl);
                        }
                        if (DistributeVideoView.this.jGk != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGk.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cae();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jvk != 1) {
                            if (DistributeVideoView.this.ekW.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jvk = 1;
                                DistributeVideoView.this.czB();
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
                        if (DistributeVideoView.this.jvk == 1) {
                            if (DistributeVideoView.this.jNo == DistributeVideoView.this.ekW.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jNo = DistributeVideoView.this.ekW.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jNu = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eeN = gVar;
                    DistributeVideoView.this.eeN.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jNp && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sf(false);
                    }
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jNd != null) {
                    if (DistributeVideoView.this.jNv && "DETAIL".equals(DistributeVideoView.this.jNd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), 0);
                }
                return false;
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cDD();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), gVar.getCurrentPosition());
                DistributeVideoView.this.hnH.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jNj.setVisibility(0);
                return true;
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jNq = System.currentTimeMillis();
                DistributeVideoView.this.jNv = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), gVar.getDuration());
                DistributeVideoView.this.cDD();
                if (DistributeVideoView.this.jJK != null) {
                    DistributeVideoView.this.jJK.cDu();
                    DistributeVideoView.this.jNg.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jNx = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jNc != null && DistributeVideoView.this.ekW != null) {
                    DistributeVideoView.this.Bi(1);
                }
            }
        };
        this.jNy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cDF();
            }
        };
        this.jNz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sh(false);
            }
        };
        this.jyu = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jNt) {
                            DistributeVideoView.this.sf(true);
                            return;
                        } else {
                            DistributeVideoView.this.sf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jNt = DistributeVideoView.this.jNp;
                    DistributeVideoView.this.sf(true);
                }
            }
        };
        this.gpG = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sf(true);
                    }
                }
            }
        };
        this.jNA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sh(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jNb = false;
        this.Pf = null;
        this.jvk = -1;
        this.jNo = 0L;
        this.jNp = false;
        this.jNq = 0L;
        this.mStyle = 1;
        this.cwQ = false;
        this.jNs = false;
        this.jNt = false;
        this.jNv = false;
        this.jNw = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jNj) {
                    DistributeVideoView.this.jNj.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jNi || view == DistributeVideoView.this.jNh) {
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNp ? false : true);
                } else if (view == DistributeVideoView.this.jNf || view == DistributeVideoView.this.jNm) {
                    DistributeVideoView.this.cDE();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jNd == null || !DistributeVideoView.this.jNd.aAp()) {
                    if (DistributeVideoView.this.jNr instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jNr;
                        if (!adCard.getAdvertAppInfo().aAo() || adCard.directDownload) {
                            DistributeVideoView.this.cDE();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cae();
                        return;
                    }
                    DistributeVideoView.this.cDE();
                } else {
                    if (DistributeVideoView.this.jNd != null) {
                        WebVideoActivity.jGd = new WebVideoActivity.a();
                        WebVideoActivity.jGd.jGn = DistributeVideoView.this.jNd;
                        WebVideoActivity.jGd.mPage = "DETAIL";
                        WebVideoActivity.jGd.mPageNum = DistributeVideoView.this.jNe;
                        NewWebVideoActivity.jGo = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jGo.jGn = DistributeVideoView.this.jNd;
                        NewWebVideoActivity.jGo.mPage = "DETAIL";
                        NewWebVideoActivity.jGo.mPageNum = DistributeVideoView.this.jNe;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jNd.cMX;
                    if (a.aVl().aVm() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNc.video_url, DistributeVideoView.this.jNc.thumbnail_url, DistributeVideoView.this.jNc.video_width.intValue() / DistributeVideoView.this.jNc.video_height.intValue(), DistributeVideoView.this.jNc.video_duration.intValue(), DistributeVideoView.this.jNd.cMV);
                        if (DistributeVideoView.this.jGj != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGj.jHk);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGj.jHl);
                        }
                        if (DistributeVideoView.this.jGk != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGk.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNc.video_url, DistributeVideoView.this.jNc.thumbnail_url, DistributeVideoView.this.jNc.video_width.intValue() / DistributeVideoView.this.jNc.video_height.intValue(), DistributeVideoView.this.jNc.video_duration.intValue());
                        if (DistributeVideoView.this.jGj != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGj.jHk);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGj.jHl);
                        }
                        if (DistributeVideoView.this.jGk != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGk.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cae();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jvk != 1) {
                            if (DistributeVideoView.this.ekW.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jvk = 1;
                                DistributeVideoView.this.czB();
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
                        if (DistributeVideoView.this.jvk == 1) {
                            if (DistributeVideoView.this.jNo == DistributeVideoView.this.ekW.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jNo = DistributeVideoView.this.ekW.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVc = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jNu = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eeN = gVar;
                    DistributeVideoView.this.eeN.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jNp && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sf(false);
                    }
                }
            }
        };
        this.dVe = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.jNd != null) {
                    if (DistributeVideoView.this.jNv && "DETAIL".equals(DistributeVideoView.this.jNd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), 0);
                }
                return false;
            }
        };
        this.dMf = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cDD();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), gVar.getCurrentPosition());
                DistributeVideoView.this.hnH.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jNj.setVisibility(0);
                return true;
            }
        };
        this.dVb = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jNq = System.currentTimeMillis();
                DistributeVideoView.this.jNv = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Bj(DistributeVideoView.this.jNw), gVar.getDuration());
                DistributeVideoView.this.cDD();
                if (DistributeVideoView.this.jJK != null) {
                    DistributeVideoView.this.jJK.cDu();
                    DistributeVideoView.this.jNg.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jNx = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jNc != null && DistributeVideoView.this.ekW != null) {
                    DistributeVideoView.this.Bi(1);
                }
            }
        };
        this.jNy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cDF();
            }
        };
        this.jNz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sh(false);
            }
        };
        this.jyu = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jNt) {
                            DistributeVideoView.this.sf(true);
                            return;
                        } else {
                            DistributeVideoView.this.sf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jNt = DistributeVideoView.this.jNp;
                    DistributeVideoView.this.sf(true);
                }
            }
        };
        this.gpG = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sf(true);
                    }
                }
            }
        };
        this.jNA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sh(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.jNr = adCard;
        if (this.jNr != null) {
            this.parallelChargeInfo = this.jNr.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.ekW = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.jNf = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hnH = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.jNg = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.jNj = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.jNk = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.jNh = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.jNl = this.mRootView.findViewById(R.id.distribute_control);
            this.jNm = (ImageView) this.jNl.findViewById(R.id.distribute_play_icon);
            this.jNi = (ImageView) this.jNl.findViewById(R.id.distribute_voice);
            this.jNn = (VideoControllerView) this.jNl.findViewById(R.id.distribute_process);
            this.jJI = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.jJJ = new d(context, this.jJI);
            this.jNf.setAnimation(R.raw.lotti_video_loading);
            this.jNf.setMinFrame(0);
            this.jNf.setFrame(0);
        }
    }

    private boolean cDB() {
        return this.mStyle == 1 ? s.cDB() : j.isWifiNet();
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
        this.jGj = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.jGk = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jNc = videoInfo;
        this.mDuration = this.jNc.video_duration.intValue() * 1000;
        this.Pf = new WeakReference<>(this.mContext.getApplicationContext());
        cDD();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.jNc.video_width.intValue() > 0 ? (this.jNc.video_height.intValue() * equipmentWidth) / this.jNc.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hnH.setDefaultErrorResource(0);
        this.hnH.setDefaultResource(0);
        this.hnH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hnH.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ekW.setOnPreparedListener(this.dVc);
        this.ekW.setOnErrorListener(this.dMf);
        this.ekW.setOnCompletionListener(this.dVb);
        this.ekW.setOnOutInfoListener(this.dVe);
        this.ekW.setOnSurfaceDestroyedListener(this.dMj);
        am.setViewTextColor(this.jNg, (int) R.color.cp_cont_m);
        this.jNg.setText(StringUtils.translateSecondsToString(this.jNc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jNp = false;
            am.setImageResource(this.jNh, R.drawable.icon_vedio_npronunciation_small_white);
            this.jNh.setVisibility(8);
        } else {
            this.jNp = true;
            am.setImageResource(this.jNi, R.drawable.ad_icon_sound_open);
            this.jNh.setVisibility(8);
        }
        this.jNi.setOnClickListener(this.mOnClickListener);
        this.jNh.setOnClickListener(this.mOnClickListener);
        this.jNj.setOnClickListener(this.mOnClickListener);
        this.jNj.setVisibility(8);
        am.setBackgroundColor(this.jNj, R.color.black_alpha80);
        am.setViewTextColor(this.jNk, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.jNg.setVisibility(0);
            return;
        }
        this.jNg.setVisibility(8);
        this.jNm.setOnClickListener(this.mOnClickListener);
        this.jNf.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jNc = videoInfo;
        this.Pf = new WeakReference<>(this.mContext.getApplicationContext());
        cDD();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hnH.setDefaultErrorResource(0);
        this.hnH.setDefaultResource(0);
        this.hnH.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hnH.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ekW.setOnPreparedListener(this.dVc);
        this.ekW.setOnErrorListener(this.dMf);
        this.ekW.setOnCompletionListener(this.dVb);
        this.ekW.setOnOutInfoListener(this.dVe);
        this.ekW.setOnSurfaceDestroyedListener(this.dMj);
        am.setViewTextColor(this.jNg, (int) R.color.cp_cont_m);
        this.jNg.setText(StringUtils.translateSecondsToString(this.jNc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jNp = false;
            am.setImageResource(this.jNh, R.drawable.icon_vedio_npronunciation_small_white);
            this.jNh.setVisibility(8);
        } else {
            this.jNp = true;
            am.setImageResource(this.jNi, R.drawable.ad_icon_sound_open);
            this.jNh.setVisibility(8);
        }
        this.jNi.setOnClickListener(this.mOnClickListener);
        this.jNh.setOnClickListener(this.mOnClickListener);
        this.jNj.setOnClickListener(this.mOnClickListener);
        this.jNj.setVisibility(8);
        am.setBackgroundColor(this.jNj, R.color.black_alpha80);
        am.setViewTextColor(this.jNk, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.jNg.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.jNg.setVisibility(8);
        this.jNm.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.jNd;
        }
        this.jJK = this.jJJ.a(this.jGk, this.jJK);
        if (this.jJK != null) {
            this.jJK.setPageContext(this.mPageContext);
            this.jJK.c(this.jNr);
            if (this.jJK instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.jJK).sd(this.jMb);
            }
            this.jJK.setAdvertAppInfo(advertAppInfo);
            this.jJK.a(this.jGk);
            this.jJK.cDv();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.jMb = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.jJK != null) {
            this.jJK.setDownloadAppCallback(cVar);
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
        this.dVb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(int i) {
        this.jNw = i;
        if (this.jNc != null && this.jvk == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.jNq) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.jJK != null) {
                    this.jJK.cDv();
                }
                this.ekW.setVideoPath(this.jNc.video_url);
                this.ekW.start();
                this.jNu = this.ekW.getCurrentPosition();
                am.setImageResource(this.jNm, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.jNj.setVisibility(8);
                this.hnH.setForegroundDrawable(0);
                this.jvk = 0;
                if (this.mStyle == 1) {
                    this.jNg.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.jNg.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.jNA);
                MessageManager.getInstance().registerListener(this.jyu);
                MessageManager.getInstance().registerListener(this.gpG);
            }
        }
    }

    public void performPlay() {
        Bi(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (cDB()) {
            if (i <= 0) {
                Bi(1);
                return;
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNx);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jNx, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.jvk == 1) {
            D(32, Bj(this.jNw), this.ekW.getCurrentPosition(), i);
            this.ekW.pause();
            af.a(this.Pf, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.jNm, R.drawable.icon_video_midpause);
            this.jvk = 2;
        }
    }

    public void autoContinue() {
        if (!this.jNs) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.jvk == 2) {
            this.jNw = i;
            Z(33, Bj(i), this.ekW.getCurrentPosition());
            this.jNu = this.ekW.getCurrentPosition();
            this.ekW.start();
            if (this.jNp) {
                af.a(this.Pf, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.jNm, R.drawable.icon_video_midplay);
            this.jvk = 1;
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
        if (this.jNf != null) {
            this.jNf.setAlpha(1.0f);
            this.jNf.setVisibility(0);
            this.jNf.loop(true);
            this.jNf.setMinAndMaxFrame(14, 80);
            this.jNf.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cDC();
        if (z) {
            this.jNf.setAlpha(1.0f);
            this.jNf.setVisibility(0);
            return;
        }
        this.jNf.setVisibility(8);
    }

    private void cDC() {
        if (this.jNf != null) {
            this.jNf.setMinFrame(0);
            this.jNf.setFrame(0);
            this.jNf.cancelAnimation();
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
        if (this.ekW.getCurrentPosition() > 0 && this.jvk != -1 && z) {
            int i = 32;
            int currentPosition = this.ekW.getCurrentPosition();
            if (this.ekW.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Bj(this.jNw), currentPosition, this.ekW.isPlaying());
        }
        cDD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDD() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNx);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNy);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNz);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.ekW.stopPlayback();
        this.jvk = -1;
        af.a(this.Pf, false);
        sh(false);
        this.hnH.setForegroundDrawable(0);
        this.hnH.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.jNm, R.drawable.icon_video_midpause);
        this.jNn.akh();
        this.jNj.setVisibility(8);
        if (this.jNc != null) {
            this.jNg.setText(StringUtils.translateSecondsToString(this.jNc.video_duration.intValue()));
            this.jNg.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eeN = null;
        this.jNt = false;
        MessageManager.getInstance().unRegisterListener(this.jNA);
        MessageManager.getInstance().unRegisterListener(this.jyu);
        MessageManager.getInstance().unRegisterListener(this.gpG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Bj(int i) {
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
        return this.jNc != null ? this.jNc.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.jJK instanceof com.baidu.tieba.recapp.e.a) && (this.jNr instanceof AdCard) && !((AdCard) this.jNr).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jJK).aYc();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.jJK instanceof com.baidu.tieba.recapp.e.a) && (this.jNr instanceof AdCard) && !((AdCard) this.jNr).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jJK).cDt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf(boolean z) {
        if (z) {
            if (this.eeN != null) {
                this.eeN.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.jNi, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.jNh, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.jvk == 1) {
                af.a(this.Pf, true);
            }
        } else {
            if (this.eeN != null) {
                this.eeN.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.jNi, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.jNh, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.Pf, false);
        }
        this.jNp = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.jvk;
    }

    public VideoInfo getData() {
        return this.jNc;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.jNo;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.jNd = advertAppInfo;
        this.jNe = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.jNd, 303, i, Bj(this.jNw), this.jNc.video_duration.intValue(), this.mDuration, -1);
        if (this.jJK != null) {
            this.jJK.e(a);
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
        if (this.jNd != null && this.jNc != null) {
            this.jNd.page = this.mPage;
            com.baidu.tieba.recapp.report.c.cDn().a(f.a(this.jNd, i, this.jNe, i2, this.jNc.video_duration.intValue(), com.baidu.tieba.ad.a.a.oj(i3), i4));
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
                c(str, this.jNu, i3, this.mDuration, str2, Bk(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.jGj != null && "cpv".equals(this.jGj.jHk) && !TextUtils.isEmpty(this.jGj.jHl)) {
            new com.baidu.tieba.recapp.request.a(this.jGj.jHl).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Bk(int i) {
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
            this.jNa = view;
            this.jNb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sg(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNy);
            if (this.aLw != null) {
                this.aLw.cancel();
            }
            this.jNl.setVisibility(0);
            if (this.jvk == 1) {
                am.setImageResource(this.jNm, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.jNm, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.jNl.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDE() {
        switch (this.jvk) {
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
                    aVar.b(this.mPageContext).aEA();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.jNs = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    sg(true);
                    return;
                }
                return;
            case 2:
                this.jNs = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNy);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.jNy, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        if (!this.cwQ && this.aLw != null) {
            this.jNl.startAnimation(this.aLw);
            this.cwQ = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.aLw = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.aLw.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.jNl.setVisibility(8);
                    DistributeVideoView.this.cwQ = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cDG() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNz);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jNz, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(boolean z) {
        if (this.jNh != null && this.mStyle == 1) {
            if (z) {
                this.jNh.setVisibility(0);
                cDG();
                return;
            }
            this.jNh.setVisibility(8);
        }
    }
}
