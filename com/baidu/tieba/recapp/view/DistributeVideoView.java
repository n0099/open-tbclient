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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.ag;
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
    private WeakReference<Context> ajK;
    private Animation btW;
    boolean dlR;
    private g.b eLe;
    private QuickVideoView.b eLi;
    private g.a eUI;
    private g.f eUJ;
    private g.e eUL;
    private QuickVideoView fnh;
    private CustomMessageListener hBs;
    private g hKR;
    private ForeDrawableImageView iFP;
    private int kTQ;
    private CustomMessageListener kXp;
    private AdCard.a leI;
    private AdCard.f leJ;
    private ViewGroup lhU;
    private d lhV;
    private e lhW;
    private boolean lkk;
    private b llA;
    boolean llB;
    private boolean llC;
    private int llD;
    boolean llE;
    private int llF;
    private Runnable llG;
    private Runnable llH;
    private Runnable llI;
    private CustomMessageListener llJ;
    private View llj;
    private boolean llk;
    private VideoInfo lll;
    private AdvertAppInfo llm;
    private int lln;
    private TBLottieAnimationView llo;
    private TextView llp;
    private ImageView llq;
    private ImageView llr;
    private View lls;
    private TextView llt;
    private View llu;
    private ImageView llv;
    private VideoControllerView llw;
    private long llx;
    private boolean lly;
    private long llz;
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
        if (this.llm != null) {
            WebVideoActivity.leB = new WebVideoActivity.a();
            WebVideoActivity.leB.leM = this.llm;
            WebVideoActivity.leB.mPage = "DETAIL";
            WebVideoActivity.leB.mPageNum = this.lln;
            NewWebVideoActivity.leN = new NewWebVideoActivity.a();
            NewWebVideoActivity.leN.leM = this.llm;
            NewWebVideoActivity.leN.mPage = "DETAIL";
            NewWebVideoActivity.leN.mPageNum = this.lln;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.llm.dGN, true, true, true, this.lll.video_url, this.lll.thumbnail_url, this.lll.video_width.intValue() / this.lll.video_height.intValue(), this.lll.video_duration.intValue(), this.llm.dGL);
        if (this.leI != null) {
            newWebVideoActivityConfig.setChargeStyle(this.leI.lfK);
            newWebVideoActivityConfig.setChargeUrl(this.leI.lfL);
        }
        if (this.leJ != null) {
            newWebVideoActivityConfig.setTailFrame(this.leJ.toJsonString());
        }
        if (this.llA instanceof AdCard) {
            newWebVideoActivityConfig.setGoodStyle(((AdCard) this.llA).goodsStyle);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvy() {
        ac(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.HZ(this.parallelChargeInfo.jqr);
            Iterator<String> it = this.parallelChargeInfo.jqu.iterator();
            while (it.hasNext()) {
                c.HZ(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWl() {
        if (this.llo != null) {
            this.llo.clearAnimation();
            this.llo.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.llo.setVisibility(8);
                    DistributeVideoView.this.iFP.setVisibility(8);
                    DistributeVideoView.this.tZ(DistributeVideoView.this.lly);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.llp.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.llw.setPlayer(DistributeVideoView.this.fnh);
                        DistributeVideoView.this.llw.bn(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.lll.video_duration.intValue()));
                        DistributeVideoView.this.llw.showProgress();
                        DistributeVideoView.this.ua(true);
                        com.baidu.adp.lib.f.e.lt().removeCallbacks(DistributeVideoView.this.llH);
                        com.baidu.adp.lib.f.e.lt().postDelayed(DistributeVideoView.this.llH, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.llx = DistributeVideoView.this.fnh.getCurrentPosition();
                    DistributeVideoView.this.ub(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.llo.setMinFrame(0);
                    DistributeVideoView.this.llo.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.llk = false;
        this.ajK = null;
        this.kTQ = -1;
        this.llx = 0L;
        this.lly = false;
        this.llz = 0L;
        this.mStyle = 1;
        this.dlR = false;
        this.llB = false;
        this.llC = false;
        this.llE = false;
        this.llF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lls) {
                    DistributeVideoView.this.lls.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.llr || view == DistributeVideoView.this.llq) {
                    DistributeVideoView.this.tZ(DistributeVideoView.this.lly ? false : true);
                } else if (view == DistributeVideoView.this.llo || view == DistributeVideoView.this.llv) {
                    DistributeVideoView.this.dah();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.llm == null || !DistributeVideoView.this.llm.aQk()) {
                    if (DistributeVideoView.this.llA instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.llA;
                        if (!adCard.getAdvertAppInfo().aQj() || adCard.directDownload) {
                            DistributeVideoView.this.dah();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cvy();
                        return;
                    }
                    DistributeVideoView.this.dah();
                } else {
                    if (DistributeVideoView.this.llm != null) {
                        WebVideoActivity.leB = new WebVideoActivity.a();
                        WebVideoActivity.leB.leM = DistributeVideoView.this.llm;
                        WebVideoActivity.leB.mPage = "DETAIL";
                        WebVideoActivity.leB.mPageNum = DistributeVideoView.this.lln;
                        NewWebVideoActivity.leN = new NewWebVideoActivity.a();
                        NewWebVideoActivity.leN.leM = DistributeVideoView.this.llm;
                        NewWebVideoActivity.leN.mPage = "DETAIL";
                        NewWebVideoActivity.leN.mPageNum = DistributeVideoView.this.lln;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.llm.dGN;
                    if (a.bmm().bmn() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lll.video_url, DistributeVideoView.this.lll.thumbnail_url, DistributeVideoView.this.lll.video_width.intValue() / DistributeVideoView.this.lll.video_height.intValue(), DistributeVideoView.this.lll.video_duration.intValue(), DistributeVideoView.this.llm.dGL);
                        if (DistributeVideoView.this.leI != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.leI.lfK);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.leI.lfL);
                        }
                        if (DistributeVideoView.this.leJ != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.leJ.toJsonString());
                        }
                        if (DistributeVideoView.this.llA instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.llA).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lll.video_url, DistributeVideoView.this.lll.thumbnail_url, DistributeVideoView.this.lll.video_width.intValue() / DistributeVideoView.this.lll.video_height.intValue(), DistributeVideoView.this.lll.video_duration.intValue());
                        if (DistributeVideoView.this.leI != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.leI.lfK);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.leI.lfL);
                        }
                        if (DistributeVideoView.this.leJ != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.leJ.toJsonString());
                        }
                        if (DistributeVideoView.this.llA instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.llA).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cvy();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kTQ != 1) {
                            if (DistributeVideoView.this.fnh.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kTQ = 1;
                                DistributeVideoView.this.cWl();
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
                        if (DistributeVideoView.this.kTQ == 1) {
                            if (DistributeVideoView.this.llx == DistributeVideoView.this.fnh.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.llx = DistributeVideoView.this.fnh.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.llD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hKR = gVar;
                    DistributeVideoView.this.hKR.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lly && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tZ(false);
                    }
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.llm != null) {
                    if (DistributeVideoView.this.llE && "DETAIL".equals(DistributeVideoView.this.llm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.DF(DistributeVideoView.this.llF), 0);
                }
                return false;
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.dag();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.DF(DistributeVideoView.this.llF), gVar.getCurrentPosition());
                DistributeVideoView.this.iFP.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lls.setVisibility(0);
                return true;
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.llz = System.currentTimeMillis();
                DistributeVideoView.this.llE = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.DF(DistributeVideoView.this.llF), gVar.getDuration());
                DistributeVideoView.this.dag();
                if (DistributeVideoView.this.lhW != null) {
                    DistributeVideoView.this.lhW.cZX();
                    DistributeVideoView.this.llp.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.llG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lll != null && DistributeVideoView.this.fnh != null) {
                    DistributeVideoView.this.DE(1);
                }
            }
        };
        this.llH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dai();
            }
        };
        this.llI = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ub(false);
            }
        };
        this.kXp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.llC) {
                            DistributeVideoView.this.tZ(true);
                            return;
                        } else {
                            DistributeVideoView.this.tZ(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.llC = DistributeVideoView.this.lly;
                    DistributeVideoView.this.tZ(true);
                }
            }
        };
        this.hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tZ(true);
                    }
                }
            }
        };
        this.llJ = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.ub(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.llk = false;
        this.ajK = null;
        this.kTQ = -1;
        this.llx = 0L;
        this.lly = false;
        this.llz = 0L;
        this.mStyle = 1;
        this.dlR = false;
        this.llB = false;
        this.llC = false;
        this.llE = false;
        this.llF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lls) {
                    DistributeVideoView.this.lls.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.llr || view == DistributeVideoView.this.llq) {
                    DistributeVideoView.this.tZ(DistributeVideoView.this.lly ? false : true);
                } else if (view == DistributeVideoView.this.llo || view == DistributeVideoView.this.llv) {
                    DistributeVideoView.this.dah();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.llm == null || !DistributeVideoView.this.llm.aQk()) {
                    if (DistributeVideoView.this.llA instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.llA;
                        if (!adCard.getAdvertAppInfo().aQj() || adCard.directDownload) {
                            DistributeVideoView.this.dah();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cvy();
                        return;
                    }
                    DistributeVideoView.this.dah();
                } else {
                    if (DistributeVideoView.this.llm != null) {
                        WebVideoActivity.leB = new WebVideoActivity.a();
                        WebVideoActivity.leB.leM = DistributeVideoView.this.llm;
                        WebVideoActivity.leB.mPage = "DETAIL";
                        WebVideoActivity.leB.mPageNum = DistributeVideoView.this.lln;
                        NewWebVideoActivity.leN = new NewWebVideoActivity.a();
                        NewWebVideoActivity.leN.leM = DistributeVideoView.this.llm;
                        NewWebVideoActivity.leN.mPage = "DETAIL";
                        NewWebVideoActivity.leN.mPageNum = DistributeVideoView.this.lln;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.llm.dGN;
                    if (a.bmm().bmn() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lll.video_url, DistributeVideoView.this.lll.thumbnail_url, DistributeVideoView.this.lll.video_width.intValue() / DistributeVideoView.this.lll.video_height.intValue(), DistributeVideoView.this.lll.video_duration.intValue(), DistributeVideoView.this.llm.dGL);
                        if (DistributeVideoView.this.leI != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.leI.lfK);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.leI.lfL);
                        }
                        if (DistributeVideoView.this.leJ != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.leJ.toJsonString());
                        }
                        if (DistributeVideoView.this.llA instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.llA).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lll.video_url, DistributeVideoView.this.lll.thumbnail_url, DistributeVideoView.this.lll.video_width.intValue() / DistributeVideoView.this.lll.video_height.intValue(), DistributeVideoView.this.lll.video_duration.intValue());
                        if (DistributeVideoView.this.leI != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.leI.lfK);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.leI.lfL);
                        }
                        if (DistributeVideoView.this.leJ != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.leJ.toJsonString());
                        }
                        if (DistributeVideoView.this.llA instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.llA).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cvy();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kTQ != 1) {
                            if (DistributeVideoView.this.fnh.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kTQ = 1;
                                DistributeVideoView.this.cWl();
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
                        if (DistributeVideoView.this.kTQ == 1) {
                            if (DistributeVideoView.this.llx == DistributeVideoView.this.fnh.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.llx = DistributeVideoView.this.fnh.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.llD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hKR = gVar;
                    DistributeVideoView.this.hKR.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lly && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tZ(false);
                    }
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.llm != null) {
                    if (DistributeVideoView.this.llE && "DETAIL".equals(DistributeVideoView.this.llm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.DF(DistributeVideoView.this.llF), 0);
                }
                return false;
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.dag();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.DF(DistributeVideoView.this.llF), gVar.getCurrentPosition());
                DistributeVideoView.this.iFP.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lls.setVisibility(0);
                return true;
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.llz = System.currentTimeMillis();
                DistributeVideoView.this.llE = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.DF(DistributeVideoView.this.llF), gVar.getDuration());
                DistributeVideoView.this.dag();
                if (DistributeVideoView.this.lhW != null) {
                    DistributeVideoView.this.lhW.cZX();
                    DistributeVideoView.this.llp.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.llG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lll != null && DistributeVideoView.this.fnh != null) {
                    DistributeVideoView.this.DE(1);
                }
            }
        };
        this.llH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dai();
            }
        };
        this.llI = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ub(false);
            }
        };
        this.kXp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.llC) {
                            DistributeVideoView.this.tZ(true);
                            return;
                        } else {
                            DistributeVideoView.this.tZ(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.llC = DistributeVideoView.this.lly;
                    DistributeVideoView.this.tZ(true);
                }
            }
        };
        this.hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tZ(true);
                    }
                }
            }
        };
        this.llJ = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.ub(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.llk = false;
        this.ajK = null;
        this.kTQ = -1;
        this.llx = 0L;
        this.lly = false;
        this.llz = 0L;
        this.mStyle = 1;
        this.dlR = false;
        this.llB = false;
        this.llC = false;
        this.llE = false;
        this.llF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lls) {
                    DistributeVideoView.this.lls.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.llr || view == DistributeVideoView.this.llq) {
                    DistributeVideoView.this.tZ(DistributeVideoView.this.lly ? false : true);
                } else if (view == DistributeVideoView.this.llo || view == DistributeVideoView.this.llv) {
                    DistributeVideoView.this.dah();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.llm == null || !DistributeVideoView.this.llm.aQk()) {
                    if (DistributeVideoView.this.llA instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.llA;
                        if (!adCard.getAdvertAppInfo().aQj() || adCard.directDownload) {
                            DistributeVideoView.this.dah();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cvy();
                        return;
                    }
                    DistributeVideoView.this.dah();
                } else {
                    if (DistributeVideoView.this.llm != null) {
                        WebVideoActivity.leB = new WebVideoActivity.a();
                        WebVideoActivity.leB.leM = DistributeVideoView.this.llm;
                        WebVideoActivity.leB.mPage = "DETAIL";
                        WebVideoActivity.leB.mPageNum = DistributeVideoView.this.lln;
                        NewWebVideoActivity.leN = new NewWebVideoActivity.a();
                        NewWebVideoActivity.leN.leM = DistributeVideoView.this.llm;
                        NewWebVideoActivity.leN.mPage = "DETAIL";
                        NewWebVideoActivity.leN.mPageNum = DistributeVideoView.this.lln;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.llm.dGN;
                    if (a.bmm().bmn() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lll.video_url, DistributeVideoView.this.lll.thumbnail_url, DistributeVideoView.this.lll.video_width.intValue() / DistributeVideoView.this.lll.video_height.intValue(), DistributeVideoView.this.lll.video_duration.intValue(), DistributeVideoView.this.llm.dGL);
                        if (DistributeVideoView.this.leI != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.leI.lfK);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.leI.lfL);
                        }
                        if (DistributeVideoView.this.leJ != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.leJ.toJsonString());
                        }
                        if (DistributeVideoView.this.llA instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.llA).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lll.video_url, DistributeVideoView.this.lll.thumbnail_url, DistributeVideoView.this.lll.video_width.intValue() / DistributeVideoView.this.lll.video_height.intValue(), DistributeVideoView.this.lll.video_duration.intValue());
                        if (DistributeVideoView.this.leI != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.leI.lfK);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.leI.lfL);
                        }
                        if (DistributeVideoView.this.leJ != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.leJ.toJsonString());
                        }
                        if (DistributeVideoView.this.llA instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.llA).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cvy();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kTQ != 1) {
                            if (DistributeVideoView.this.fnh.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kTQ = 1;
                                DistributeVideoView.this.cWl();
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
                        if (DistributeVideoView.this.kTQ == 1) {
                            if (DistributeVideoView.this.llx == DistributeVideoView.this.fnh.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.llx = DistributeVideoView.this.fnh.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eUJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.llD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hKR = gVar;
                    DistributeVideoView.this.hKR.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lly && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tZ(false);
                    }
                }
            }
        };
        this.eUL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.llm != null) {
                    if (DistributeVideoView.this.llE && "DETAIL".equals(DistributeVideoView.this.llm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.DF(DistributeVideoView.this.llF), 0);
                }
                return false;
            }
        };
        this.eLe = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.dag();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.DF(DistributeVideoView.this.llF), gVar.getCurrentPosition());
                DistributeVideoView.this.iFP.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lls.setVisibility(0);
                return true;
            }
        };
        this.eUI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.llz = System.currentTimeMillis();
                DistributeVideoView.this.llE = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.DF(DistributeVideoView.this.llF), gVar.getDuration());
                DistributeVideoView.this.dag();
                if (DistributeVideoView.this.lhW != null) {
                    DistributeVideoView.this.lhW.cZX();
                    DistributeVideoView.this.llp.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eLi = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.llG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lll != null && DistributeVideoView.this.fnh != null) {
                    DistributeVideoView.this.DE(1);
                }
            }
        };
        this.llH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.dai();
            }
        };
        this.llI = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ub(false);
            }
        };
        this.kXp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.llC) {
                            DistributeVideoView.this.tZ(true);
                            return;
                        } else {
                            DistributeVideoView.this.tZ(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.llC = DistributeVideoView.this.lly;
                    DistributeVideoView.this.tZ(true);
                }
            }
        };
        this.hBs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tZ(true);
                    }
                }
            }
        };
        this.llJ = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.ub(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.llA = adCard;
        if (this.llA != null) {
            this.parallelChargeInfo = this.llA.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fnh = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.llo = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.iFP = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.llp = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.lls = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.llt = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.llq = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.llu = this.mRootView.findViewById(R.id.distribute_control);
            this.llv = (ImageView) this.llu.findViewById(R.id.distribute_play_icon);
            this.llr = (ImageView) this.llu.findViewById(R.id.distribute_voice);
            this.llw = (VideoControllerView) this.llu.findViewById(R.id.distribute_process);
            this.lhU = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.lhV = new d(context, this.lhU);
            this.llo.setAnimation(R.raw.lotti_video_loading);
            this.llo.setMinFrame(0);
            this.llo.setFrame(0);
        }
    }

    private boolean dae() {
        return this.mStyle == 1 ? t.dae() : j.isWifiNet();
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
        this.leI = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.leJ = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lll = videoInfo;
        this.mDuration = this.lll.video_duration.intValue() * 1000;
        this.ajK = new WeakReference<>(this.mContext.getApplicationContext());
        dag();
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.lll.video_width.intValue() > 0 ? (this.lll.video_height.intValue() * equipmentWidth) / this.lll.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.iFP.setDefaultErrorResource(0);
        this.iFP.setDefaultResource(0);
        this.iFP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ar.isEmpty(videoInfo.thumbnail_url)) {
            this.iFP.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fnh.setOnPreparedListener(this.eUJ);
        this.fnh.setOnErrorListener(this.eLe);
        this.fnh.setOnCompletionListener(this.eUI);
        this.fnh.setOnOutInfoListener(this.eUL);
        this.fnh.setOnSurfaceDestroyedListener(this.eLi);
        an.setViewTextColor(this.llp, (int) R.color.cp_cont_m);
        this.llp.setText(StringUtils.translateSecondsToString(this.lll.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lly = false;
            an.setImageResource(this.llq, R.drawable.icon_vedio_npronunciation_small_white);
            this.llq.setVisibility(8);
        } else {
            this.lly = true;
            an.setImageResource(this.llr, R.drawable.ad_icon_sound_open);
            this.llq.setVisibility(8);
        }
        this.llr.setOnClickListener(this.mOnClickListener);
        this.llq.setOnClickListener(this.mOnClickListener);
        this.lls.setOnClickListener(this.mOnClickListener);
        this.lls.setVisibility(8);
        an.setBackgroundColor(this.lls, R.color.black_alpha80);
        an.setViewTextColor(this.llt, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.llp.setVisibility(0);
            return;
        }
        this.llp.setVisibility(8);
        this.llv.setOnClickListener(this.mOnClickListener);
        this.llo.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lll = videoInfo;
        this.ajK = new WeakReference<>(this.mContext.getApplicationContext());
        dag();
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.iFP.setDefaultErrorResource(0);
        this.iFP.setDefaultResource(0);
        this.iFP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!ar.isEmpty(videoInfo.thumbnail_url)) {
            this.iFP.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fnh.setOnPreparedListener(this.eUJ);
        this.fnh.setOnErrorListener(this.eLe);
        this.fnh.setOnCompletionListener(this.eUI);
        this.fnh.setOnOutInfoListener(this.eUL);
        this.fnh.setOnSurfaceDestroyedListener(this.eLi);
        an.setViewTextColor(this.llp, (int) R.color.cp_cont_m);
        this.llp.setText(StringUtils.translateSecondsToString(this.lll.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lly = false;
            an.setImageResource(this.llq, R.drawable.icon_vedio_npronunciation_small_white);
            this.llq.setVisibility(8);
        } else {
            this.lly = true;
            an.setImageResource(this.llr, R.drawable.ad_icon_sound_open);
            this.llq.setVisibility(8);
        }
        this.llr.setOnClickListener(this.mOnClickListener);
        this.llq.setOnClickListener(this.mOnClickListener);
        this.lls.setOnClickListener(this.mOnClickListener);
        this.lls.setVisibility(8);
        an.setBackgroundColor(this.lls, R.color.black_alpha80);
        an.setViewTextColor(this.llt, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.llp.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.llp.setVisibility(8);
        this.llv.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.llm;
        }
        this.lhW = this.lhV.a(this.leJ, this.lhW);
        if (this.lhW != null) {
            this.lhW.setPageContext(this.mPageContext);
            this.lhW.c(this.llA);
            if (this.lhW instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.lhW).tX(this.lkk);
            }
            this.lhW.setAdvertAppInfo(advertAppInfo);
            this.lhW.a(this.leJ);
            this.lhW.cZY();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.lkk = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.lhW != null) {
            this.lhW.setDownloadAppCallback(cVar);
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
        this.eUI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DE(int i) {
        this.llF = i;
        if (this.lll != null && this.kTQ == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.llz) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.lhW != null) {
                    this.lhW.cZY();
                }
                this.fnh.setVideoPath(this.lll.video_url);
                this.fnh.start();
                this.llD = this.fnh.getCurrentPosition();
                an.setImageResource(this.llv, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.lls.setVisibility(8);
                this.iFP.setForegroundDrawable(0);
                this.kTQ = 0;
                if (this.mStyle == 1) {
                    this.llp.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.llp.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.llJ);
                MessageManager.getInstance().registerListener(this.kXp);
                MessageManager.getInstance().registerListener(this.hBs);
            }
        }
    }

    public void performPlay() {
        DE(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (dae()) {
            if (i <= 0) {
                DE(1);
                return;
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llG);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.llG, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.kTQ == 1) {
            E(32, DF(this.llF), this.fnh.getCurrentPosition(), i);
            this.fnh.pause();
            ag.a(this.ajK, false);
            setLoadingAnimShow(true);
            an.setImageResource(this.llv, R.drawable.icon_video_midpause);
            this.kTQ = 2;
        }
    }

    public void autoContinue() {
        if (!this.llB) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.kTQ == 2) {
            this.llF = i;
            ac(33, DF(i), this.fnh.getCurrentPosition());
            this.llD = this.fnh.getCurrentPosition();
            this.fnh.start();
            if (this.lly) {
                ag.a(this.ajK, true);
            }
            setLoadingAnimShow(false);
            an.setImageResource(this.llv, R.drawable.icon_video_midplay);
            this.kTQ = 1;
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
        if (this.llo != null) {
            this.llo.setAlpha(1.0f);
            this.llo.setVisibility(0);
            this.llo.loop(true);
            this.llo.setMinAndMaxFrame(14, 80);
            this.llo.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        daf();
        if (z) {
            this.llo.setAlpha(1.0f);
            this.llo.setVisibility(0);
            return;
        }
        this.llo.setVisibility(8);
    }

    private void daf() {
        if (this.llo != null) {
            this.llo.setMinFrame(0);
            this.llo.setFrame(0);
            this.llo.cancelAnimation();
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
        if (this.fnh.getCurrentPosition() > 0 && this.kTQ != -1 && z) {
            int i = 32;
            int currentPosition = this.fnh.getCurrentPosition();
            if (this.fnh.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, DF(this.llF), currentPosition, this.fnh.isPlaying());
        }
        dag();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fnh.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lhU.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iFP.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int by = com.baidu.b.a.e.a.by(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = by;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = by;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = by;
            layoutParams4.height = equipmentWidth;
            an.setBackgroundColor(this, R.color.black_alpha100);
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        }
        this.fnh.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dag() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llG);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llH);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llI);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fnh.stopPlayback();
        this.kTQ = -1;
        ag.a(this.ajK, false);
        ub(false);
        this.iFP.setForegroundDrawable(0);
        this.iFP.setVisibility(0);
        setLoadingAnimShow(true);
        an.setImageResource(this.llv, R.drawable.icon_video_midpause);
        this.llw.axj();
        this.lls.setVisibility(8);
        if (this.lll != null) {
            this.llp.setText(StringUtils.translateSecondsToString(this.lll.video_duration.intValue()));
            this.llp.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.hKR = null;
        this.llC = false;
        MessageManager.getInstance().unRegisterListener(this.llJ);
        MessageManager.getInstance().unRegisterListener(this.kXp);
        MessageManager.getInstance().unRegisterListener(this.hBs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int DF(int i) {
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
        return this.lll != null ? this.lll.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.lhW instanceof com.baidu.tieba.recapp.e.a) && (this.llA instanceof AdCard) && !((AdCard) this.llA).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lhW).boY();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.lhW instanceof com.baidu.tieba.recapp.e.a) && (this.llA instanceof AdCard) && !((AdCard) this.llA).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lhW).cZW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(boolean z) {
        if (z) {
            if (this.hKR != null) {
                this.hKR.setVolume(1.0f, 1.0f);
            }
            an.setImageResource(this.llr, R.drawable.ad_icon_sound_open);
            an.setImageResource(this.llq, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.kTQ == 1) {
                ag.a(this.ajK, true);
            }
        } else {
            if (this.hKR != null) {
                this.hKR.setVolume(0.0f, 0.0f);
            }
            an.setImageResource(this.llr, R.drawable.ad_icon_sound_close);
            an.setImageResource(this.llq, R.drawable.icon_vedio_npronunciation_small_white);
            ag.a(this.ajK, false);
        }
        this.lly = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.kTQ;
    }

    public VideoInfo getData() {
        return this.lll;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.llx;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.llm = advertAppInfo;
        this.lln = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(this.llm, 303, i, DF(this.llF), this.lll.video_duration.intValue(), this.mDuration, -1);
        if (this.lhW != null) {
            this.lhW.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(int i, int i2, int i3) {
        E(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void E(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.llm != null && this.lll != null) {
            this.llm.page = this.mPage;
            com.baidu.tieba.recapp.report.d.cZQ().a(com.baidu.tieba.recapp.report.g.a(this.llm, i, this.lln, i2, this.lll.video_duration.intValue(), com.baidu.tieba.ad.a.a.pG(i3), i4));
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
                c(str, this.llD, i3, this.mDuration, str2, DG(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.leI != null && "cpv".equals(this.leI.lfK) && !TextUtils.isEmpty(this.leI.lfL)) {
            new com.baidu.tieba.recapp.request.a(this.leI.lfL).a(str, i, i2, i3, str2, str3);
        }
    }

    private String DG(int i) {
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
            this.llj = view;
            this.llk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llH);
            if (this.btW != null) {
                this.btW.cancel();
            }
            this.llu.setVisibility(0);
            if (this.kTQ == 1) {
                an.setImageResource(this.llv, R.drawable.icon_video_midplay);
                return;
            } else {
                an.setImageResource(this.llv, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.llu.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dah() {
        switch (this.kTQ) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.kT(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aUN();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.llB = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    ua(true);
                    return;
                }
                return;
            case 2:
                this.llB = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llH);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.llH, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dai() {
        if (!this.dlR && this.btW != null) {
            this.llu.startAnimation(this.btW);
            this.dlR = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.btW = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.btW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.llu.setVisibility(8);
                    DistributeVideoView.this.dlR = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void daj() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.llI);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.llI, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(boolean z) {
        if (this.llq != null && this.mStyle == 1) {
            if (z) {
                this.llq.setVisibility(0);
                daj();
                return;
            }
            this.llq.setVisibility(8);
        }
    }
}
