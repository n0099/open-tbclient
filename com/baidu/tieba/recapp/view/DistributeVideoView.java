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
    private WeakReference<Context> aio;
    private Animation boW;
    boolean dhf;
    private g.b eBv;
    private QuickVideoView.b eBz;
    private g.a eKw;
    private g.f eKx;
    private g.e eKz;
    private QuickVideoView fbX;
    private CustomMessageListener hoS;
    private g hxU;
    private ForeDrawableImageView ioJ;
    private CustomMessageListener kDt;
    private AdCard.a kKO;
    private AdCard.f kKP;
    private ViewGroup kOb;
    private d kOc;
    private e kOd;
    private boolean kQr;
    private TextView kRA;
    private View kRB;
    private ImageView kRC;
    private VideoControllerView kRD;
    private long kRE;
    private boolean kRF;
    private long kRG;
    private b kRH;
    boolean kRI;
    private boolean kRJ;
    private int kRK;
    boolean kRL;
    private int kRM;
    private Runnable kRN;
    private Runnable kRO;
    private Runnable kRP;
    private CustomMessageListener kRQ;
    private View kRq;
    private boolean kRr;
    private VideoInfo kRs;
    private AdvertAppInfo kRt;
    private int kRu;
    private TBLottieAnimationView kRv;
    private TextView kRw;
    private ImageView kRx;
    private ImageView kRy;
    private View kRz;
    private int kzT;
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
        if (this.kRt != null) {
            WebVideoActivity.kKH = new WebVideoActivity.a();
            WebVideoActivity.kKH.kKS = this.kRt;
            WebVideoActivity.kKH.mPage = "DETAIL";
            WebVideoActivity.kKH.mPageNum = this.kRu;
            NewWebVideoActivity.kKT = new NewWebVideoActivity.a();
            NewWebVideoActivity.kKT.kKS = this.kRt;
            NewWebVideoActivity.kKT.mPage = "DETAIL";
            NewWebVideoActivity.kKT.mPageNum = this.kRu;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.kRt.dAw, true, true, true, this.kRs.video_url, this.kRs.thumbnail_url, this.kRs.video_width.intValue() / this.kRs.video_height.intValue(), this.kRs.video_duration.intValue(), this.kRt.dAu);
        if (this.kKO != null) {
            newWebVideoActivityConfig.setChargeStyle(this.kKO.kLQ);
            newWebVideoActivityConfig.setChargeUrl(this.kKO.kLR);
        }
        if (this.kKP != null) {
            newWebVideoActivityConfig.setTailFrame(this.kKP.toJsonString());
        }
        if (this.kRH instanceof AdCard) {
            newWebVideoActivityConfig.setGoodStyle(((AdCard) this.kRH).goodsStyle);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crI() {
        ac(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.Hx(this.parallelChargeInfo.iZh);
            Iterator<String> it = this.parallelChargeInfo.iZk.iterator();
            while (it.hasNext()) {
                c.Hx(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRV() {
        if (this.kRv != null) {
            this.kRv.clearAnimation();
            this.kRv.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.kRv.setVisibility(8);
                    DistributeVideoView.this.ioJ.setVisibility(8);
                    DistributeVideoView.this.tK(DistributeVideoView.this.kRF);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.kRw.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.kRD.setPlayer(DistributeVideoView.this.fbX);
                        DistributeVideoView.this.kRD.bj(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.kRs.video_duration.intValue()));
                        DistributeVideoView.this.kRD.showProgress();
                        DistributeVideoView.this.tL(true);
                        com.baidu.adp.lib.f.e.ld().removeCallbacks(DistributeVideoView.this.kRO);
                        com.baidu.adp.lib.f.e.ld().postDelayed(DistributeVideoView.this.kRO, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.kRE = DistributeVideoView.this.fbX.getCurrentPosition();
                    DistributeVideoView.this.tM(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.kRv.setMinFrame(0);
                    DistributeVideoView.this.kRv.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.kRr = false;
        this.aio = null;
        this.kzT = -1;
        this.kRE = 0L;
        this.kRF = false;
        this.kRG = 0L;
        this.mStyle = 1;
        this.dhf = false;
        this.kRI = false;
        this.kRJ = false;
        this.kRL = false;
        this.kRM = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kRz) {
                    DistributeVideoView.this.kRz.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kRy || view == DistributeVideoView.this.kRx) {
                    DistributeVideoView.this.tK(DistributeVideoView.this.kRF ? false : true);
                } else if (view == DistributeVideoView.this.kRv || view == DistributeVideoView.this.kRC) {
                    DistributeVideoView.this.cVR();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kRt == null || !DistributeVideoView.this.kRt.aOA()) {
                    if (DistributeVideoView.this.kRH instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kRH;
                        if (!adCard.getAdvertAppInfo().aOz() || adCard.directDownload) {
                            DistributeVideoView.this.cVR();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.crI();
                        return;
                    }
                    DistributeVideoView.this.cVR();
                } else {
                    if (DistributeVideoView.this.kRt != null) {
                        WebVideoActivity.kKH = new WebVideoActivity.a();
                        WebVideoActivity.kKH.kKS = DistributeVideoView.this.kRt;
                        WebVideoActivity.kKH.mPage = "DETAIL";
                        WebVideoActivity.kKH.mPageNum = DistributeVideoView.this.kRu;
                        NewWebVideoActivity.kKT = new NewWebVideoActivity.a();
                        NewWebVideoActivity.kKT.kKS = DistributeVideoView.this.kRt;
                        NewWebVideoActivity.kKT.mPage = "DETAIL";
                        NewWebVideoActivity.kKT.mPageNum = DistributeVideoView.this.kRu;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kRt.dAw;
                    if (a.bjN().bjO() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kRs.video_url, DistributeVideoView.this.kRs.thumbnail_url, DistributeVideoView.this.kRs.video_width.intValue() / DistributeVideoView.this.kRs.video_height.intValue(), DistributeVideoView.this.kRs.video_duration.intValue(), DistributeVideoView.this.kRt.dAu);
                        if (DistributeVideoView.this.kKO != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kKO.kLQ);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kKO.kLR);
                        }
                        if (DistributeVideoView.this.kKP != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.kKP.toJsonString());
                        }
                        if (DistributeVideoView.this.kRH instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.kRH).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kRs.video_url, DistributeVideoView.this.kRs.thumbnail_url, DistributeVideoView.this.kRs.video_width.intValue() / DistributeVideoView.this.kRs.video_height.intValue(), DistributeVideoView.this.kRs.video_duration.intValue());
                        if (DistributeVideoView.this.kKO != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kKO.kLQ);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kKO.kLR);
                        }
                        if (DistributeVideoView.this.kKP != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.kKP.toJsonString());
                        }
                        if (DistributeVideoView.this.kRH instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.kRH).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.crI();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kzT != 1) {
                            if (DistributeVideoView.this.fbX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kzT = 1;
                                DistributeVideoView.this.cRV();
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
                        if (DistributeVideoView.this.kzT == 1) {
                            if (DistributeVideoView.this.kRE == DistributeVideoView.this.fbX.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kRE = DistributeVideoView.this.fbX.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kRK = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hxU = gVar;
                    DistributeVideoView.this.hxU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kRF && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tK(false);
                    }
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kRt != null) {
                    if (DistributeVideoView.this.kRL && "DETAIL".equals(DistributeVideoView.this.kRt.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), 0);
                }
                return false;
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cVQ();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), gVar.getCurrentPosition());
                DistributeVideoView.this.ioJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kRz.setVisibility(0);
                return true;
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kRG = System.currentTimeMillis();
                DistributeVideoView.this.kRL = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), gVar.getDuration());
                DistributeVideoView.this.cVQ();
                if (DistributeVideoView.this.kOd != null) {
                    DistributeVideoView.this.kOd.cVH();
                    DistributeVideoView.this.kRw.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kRN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kRs != null && DistributeVideoView.this.fbX != null) {
                    DistributeVideoView.this.CC(1);
                }
            }
        };
        this.kRO = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cVS();
            }
        };
        this.kRP = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.tM(false);
            }
        };
        this.kDt = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kRJ) {
                            DistributeVideoView.this.tK(true);
                            return;
                        } else {
                            DistributeVideoView.this.tK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kRJ = DistributeVideoView.this.kRF;
                    DistributeVideoView.this.tK(true);
                }
            }
        };
        this.hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tK(true);
                    }
                }
            }
        };
        this.kRQ = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.tM(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kRr = false;
        this.aio = null;
        this.kzT = -1;
        this.kRE = 0L;
        this.kRF = false;
        this.kRG = 0L;
        this.mStyle = 1;
        this.dhf = false;
        this.kRI = false;
        this.kRJ = false;
        this.kRL = false;
        this.kRM = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kRz) {
                    DistributeVideoView.this.kRz.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kRy || view == DistributeVideoView.this.kRx) {
                    DistributeVideoView.this.tK(DistributeVideoView.this.kRF ? false : true);
                } else if (view == DistributeVideoView.this.kRv || view == DistributeVideoView.this.kRC) {
                    DistributeVideoView.this.cVR();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kRt == null || !DistributeVideoView.this.kRt.aOA()) {
                    if (DistributeVideoView.this.kRH instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kRH;
                        if (!adCard.getAdvertAppInfo().aOz() || adCard.directDownload) {
                            DistributeVideoView.this.cVR();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.crI();
                        return;
                    }
                    DistributeVideoView.this.cVR();
                } else {
                    if (DistributeVideoView.this.kRt != null) {
                        WebVideoActivity.kKH = new WebVideoActivity.a();
                        WebVideoActivity.kKH.kKS = DistributeVideoView.this.kRt;
                        WebVideoActivity.kKH.mPage = "DETAIL";
                        WebVideoActivity.kKH.mPageNum = DistributeVideoView.this.kRu;
                        NewWebVideoActivity.kKT = new NewWebVideoActivity.a();
                        NewWebVideoActivity.kKT.kKS = DistributeVideoView.this.kRt;
                        NewWebVideoActivity.kKT.mPage = "DETAIL";
                        NewWebVideoActivity.kKT.mPageNum = DistributeVideoView.this.kRu;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kRt.dAw;
                    if (a.bjN().bjO() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kRs.video_url, DistributeVideoView.this.kRs.thumbnail_url, DistributeVideoView.this.kRs.video_width.intValue() / DistributeVideoView.this.kRs.video_height.intValue(), DistributeVideoView.this.kRs.video_duration.intValue(), DistributeVideoView.this.kRt.dAu);
                        if (DistributeVideoView.this.kKO != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kKO.kLQ);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kKO.kLR);
                        }
                        if (DistributeVideoView.this.kKP != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.kKP.toJsonString());
                        }
                        if (DistributeVideoView.this.kRH instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.kRH).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kRs.video_url, DistributeVideoView.this.kRs.thumbnail_url, DistributeVideoView.this.kRs.video_width.intValue() / DistributeVideoView.this.kRs.video_height.intValue(), DistributeVideoView.this.kRs.video_duration.intValue());
                        if (DistributeVideoView.this.kKO != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kKO.kLQ);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kKO.kLR);
                        }
                        if (DistributeVideoView.this.kKP != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.kKP.toJsonString());
                        }
                        if (DistributeVideoView.this.kRH instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.kRH).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.crI();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kzT != 1) {
                            if (DistributeVideoView.this.fbX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kzT = 1;
                                DistributeVideoView.this.cRV();
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
                        if (DistributeVideoView.this.kzT == 1) {
                            if (DistributeVideoView.this.kRE == DistributeVideoView.this.fbX.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kRE = DistributeVideoView.this.fbX.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kRK = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hxU = gVar;
                    DistributeVideoView.this.hxU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kRF && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tK(false);
                    }
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kRt != null) {
                    if (DistributeVideoView.this.kRL && "DETAIL".equals(DistributeVideoView.this.kRt.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), 0);
                }
                return false;
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cVQ();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), gVar.getCurrentPosition());
                DistributeVideoView.this.ioJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kRz.setVisibility(0);
                return true;
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kRG = System.currentTimeMillis();
                DistributeVideoView.this.kRL = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), gVar.getDuration());
                DistributeVideoView.this.cVQ();
                if (DistributeVideoView.this.kOd != null) {
                    DistributeVideoView.this.kOd.cVH();
                    DistributeVideoView.this.kRw.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kRN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kRs != null && DistributeVideoView.this.fbX != null) {
                    DistributeVideoView.this.CC(1);
                }
            }
        };
        this.kRO = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cVS();
            }
        };
        this.kRP = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.tM(false);
            }
        };
        this.kDt = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kRJ) {
                            DistributeVideoView.this.tK(true);
                            return;
                        } else {
                            DistributeVideoView.this.tK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kRJ = DistributeVideoView.this.kRF;
                    DistributeVideoView.this.tK(true);
                }
            }
        };
        this.hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tK(true);
                    }
                }
            }
        };
        this.kRQ = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.tM(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kRr = false;
        this.aio = null;
        this.kzT = -1;
        this.kRE = 0L;
        this.kRF = false;
        this.kRG = 0L;
        this.mStyle = 1;
        this.dhf = false;
        this.kRI = false;
        this.kRJ = false;
        this.kRL = false;
        this.kRM = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kRz) {
                    DistributeVideoView.this.kRz.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kRy || view == DistributeVideoView.this.kRx) {
                    DistributeVideoView.this.tK(DistributeVideoView.this.kRF ? false : true);
                } else if (view == DistributeVideoView.this.kRv || view == DistributeVideoView.this.kRC) {
                    DistributeVideoView.this.cVR();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kRt == null || !DistributeVideoView.this.kRt.aOA()) {
                    if (DistributeVideoView.this.kRH instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kRH;
                        if (!adCard.getAdvertAppInfo().aOz() || adCard.directDownload) {
                            DistributeVideoView.this.cVR();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.crI();
                        return;
                    }
                    DistributeVideoView.this.cVR();
                } else {
                    if (DistributeVideoView.this.kRt != null) {
                        WebVideoActivity.kKH = new WebVideoActivity.a();
                        WebVideoActivity.kKH.kKS = DistributeVideoView.this.kRt;
                        WebVideoActivity.kKH.mPage = "DETAIL";
                        WebVideoActivity.kKH.mPageNum = DistributeVideoView.this.kRu;
                        NewWebVideoActivity.kKT = new NewWebVideoActivity.a();
                        NewWebVideoActivity.kKT.kKS = DistributeVideoView.this.kRt;
                        NewWebVideoActivity.kKT.mPage = "DETAIL";
                        NewWebVideoActivity.kKT.mPageNum = DistributeVideoView.this.kRu;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kRt.dAw;
                    if (a.bjN().bjO() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kRs.video_url, DistributeVideoView.this.kRs.thumbnail_url, DistributeVideoView.this.kRs.video_width.intValue() / DistributeVideoView.this.kRs.video_height.intValue(), DistributeVideoView.this.kRs.video_duration.intValue(), DistributeVideoView.this.kRt.dAu);
                        if (DistributeVideoView.this.kKO != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kKO.kLQ);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kKO.kLR);
                        }
                        if (DistributeVideoView.this.kKP != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.kKP.toJsonString());
                        }
                        if (DistributeVideoView.this.kRH instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.kRH).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kRs.video_url, DistributeVideoView.this.kRs.thumbnail_url, DistributeVideoView.this.kRs.video_width.intValue() / DistributeVideoView.this.kRs.video_height.intValue(), DistributeVideoView.this.kRs.video_duration.intValue());
                        if (DistributeVideoView.this.kKO != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kKO.kLQ);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kKO.kLR);
                        }
                        if (DistributeVideoView.this.kKP != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.kKP.toJsonString());
                        }
                        if (DistributeVideoView.this.kRH instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.kRH).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.crI();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kzT != 1) {
                            if (DistributeVideoView.this.fbX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kzT = 1;
                                DistributeVideoView.this.cRV();
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
                        if (DistributeVideoView.this.kzT == 1) {
                            if (DistributeVideoView.this.kRE == DistributeVideoView.this.fbX.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kRE = DistributeVideoView.this.fbX.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eKx = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kRK = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hxU = gVar;
                    DistributeVideoView.this.hxU.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kRF && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tK(false);
                    }
                }
            }
        };
        this.eKz = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.kRt != null) {
                    if (DistributeVideoView.this.kRL && "DETAIL".equals(DistributeVideoView.this.kRt.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), 0);
                }
                return false;
            }
        };
        this.eBv = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cVQ();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), gVar.getCurrentPosition());
                DistributeVideoView.this.ioJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kRz.setVisibility(0);
                return true;
            }
        };
        this.eKw = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kRG = System.currentTimeMillis();
                DistributeVideoView.this.kRL = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.CD(DistributeVideoView.this.kRM), gVar.getDuration());
                DistributeVideoView.this.cVQ();
                if (DistributeVideoView.this.kOd != null) {
                    DistributeVideoView.this.kOd.cVH();
                    DistributeVideoView.this.kRw.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eBz = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kRN = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kRs != null && DistributeVideoView.this.fbX != null) {
                    DistributeVideoView.this.CC(1);
                }
            }
        };
        this.kRO = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cVS();
            }
        };
        this.kRP = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.tM(false);
            }
        };
        this.kDt = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kRJ) {
                            DistributeVideoView.this.tK(true);
                            return;
                        } else {
                            DistributeVideoView.this.tK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kRJ = DistributeVideoView.this.kRF;
                    DistributeVideoView.this.tK(true);
                }
            }
        };
        this.hoS = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.tK(true);
                    }
                }
            }
        };
        this.kRQ = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.tM(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.kRH = adCard;
        if (this.kRH != null) {
            this.parallelChargeInfo = this.kRH.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fbX = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.kRv = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.ioJ = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.kRw = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.kRz = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.kRA = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.kRx = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.kRB = this.mRootView.findViewById(R.id.distribute_control);
            this.kRC = (ImageView) this.kRB.findViewById(R.id.distribute_play_icon);
            this.kRy = (ImageView) this.kRB.findViewById(R.id.distribute_voice);
            this.kRD = (VideoControllerView) this.kRB.findViewById(R.id.distribute_process);
            this.kOb = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.kOc = new d(context, this.kOb);
            this.kRv.setAnimation(R.raw.lotti_video_loading);
            this.kRv.setMinFrame(0);
            this.kRv.setFrame(0);
        }
    }

    private boolean cVO() {
        return this.mStyle == 1 ? t.cVO() : j.isWifiNet();
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
        this.kKO = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.kKP = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kRs = videoInfo;
        this.mDuration = this.kRs.video_duration.intValue() * 1000;
        this.aio = new WeakReference<>(this.mContext.getApplicationContext());
        cVQ();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.kRs.video_width.intValue() > 0 ? (this.kRs.video_height.intValue() * equipmentWidth) / this.kRs.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.ioJ.setDefaultErrorResource(0);
        this.ioJ.setDefaultResource(0);
        this.ioJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.ioJ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fbX.setOnPreparedListener(this.eKx);
        this.fbX.setOnErrorListener(this.eBv);
        this.fbX.setOnCompletionListener(this.eKw);
        this.fbX.setOnOutInfoListener(this.eKz);
        this.fbX.setOnSurfaceDestroyedListener(this.eBz);
        am.setViewTextColor(this.kRw, (int) R.color.cp_cont_m);
        this.kRw.setText(StringUtils.translateSecondsToString(this.kRs.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kRF = false;
            am.setImageResource(this.kRx, R.drawable.icon_vedio_npronunciation_small_white);
            this.kRx.setVisibility(8);
        } else {
            this.kRF = true;
            am.setImageResource(this.kRy, R.drawable.ad_icon_sound_open);
            this.kRx.setVisibility(8);
        }
        this.kRy.setOnClickListener(this.mOnClickListener);
        this.kRx.setOnClickListener(this.mOnClickListener);
        this.kRz.setOnClickListener(this.mOnClickListener);
        this.kRz.setVisibility(8);
        am.setBackgroundColor(this.kRz, R.color.black_alpha80);
        am.setViewTextColor(this.kRA, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.kRw.setVisibility(0);
            return;
        }
        this.kRw.setVisibility(8);
        this.kRC.setOnClickListener(this.mOnClickListener);
        this.kRv.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kRs = videoInfo;
        this.aio = new WeakReference<>(this.mContext.getApplicationContext());
        cVQ();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.ioJ.setDefaultErrorResource(0);
        this.ioJ.setDefaultResource(0);
        this.ioJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.ioJ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fbX.setOnPreparedListener(this.eKx);
        this.fbX.setOnErrorListener(this.eBv);
        this.fbX.setOnCompletionListener(this.eKw);
        this.fbX.setOnOutInfoListener(this.eKz);
        this.fbX.setOnSurfaceDestroyedListener(this.eBz);
        am.setViewTextColor(this.kRw, (int) R.color.cp_cont_m);
        this.kRw.setText(StringUtils.translateSecondsToString(this.kRs.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kRF = false;
            am.setImageResource(this.kRx, R.drawable.icon_vedio_npronunciation_small_white);
            this.kRx.setVisibility(8);
        } else {
            this.kRF = true;
            am.setImageResource(this.kRy, R.drawable.ad_icon_sound_open);
            this.kRx.setVisibility(8);
        }
        this.kRy.setOnClickListener(this.mOnClickListener);
        this.kRx.setOnClickListener(this.mOnClickListener);
        this.kRz.setOnClickListener(this.mOnClickListener);
        this.kRz.setVisibility(8);
        am.setBackgroundColor(this.kRz, R.color.black_alpha80);
        am.setViewTextColor(this.kRA, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.kRw.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.kRw.setVisibility(8);
        this.kRC.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.kRt;
        }
        this.kOd = this.kOc.a(this.kKP, this.kOd);
        if (this.kOd != null) {
            this.kOd.setPageContext(this.mPageContext);
            this.kOd.c(this.kRH);
            if (this.kOd instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.kOd).tI(this.kQr);
            }
            this.kOd.setAdvertAppInfo(advertAppInfo);
            this.kOd.a(this.kKP);
            this.kOd.cVI();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.kQr = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.kOd != null) {
            this.kOd.setDownloadAppCallback(cVar);
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
        this.eKw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CC(int i) {
        this.kRM = i;
        if (this.kRs != null && this.kzT == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.kRG) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.kOd != null) {
                    this.kOd.cVI();
                }
                this.fbX.setVideoPath(this.kRs.video_url);
                this.fbX.start();
                this.kRK = this.fbX.getCurrentPosition();
                am.setImageResource(this.kRC, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.kRz.setVisibility(8);
                this.ioJ.setForegroundDrawable(0);
                this.kzT = 0;
                if (this.mStyle == 1) {
                    this.kRw.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.kRw.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.kRQ);
                MessageManager.getInstance().registerListener(this.kDt);
                MessageManager.getInstance().registerListener(this.hoS);
            }
        }
    }

    public void performPlay() {
        CC(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (cVO()) {
            if (i <= 0) {
                CC(1);
                return;
            }
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRN);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kRN, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.kzT == 1) {
            E(32, CD(this.kRM), this.fbX.getCurrentPosition(), i);
            this.fbX.pause();
            ag.a(this.aio, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.kRC, R.drawable.icon_video_midpause);
            this.kzT = 2;
        }
    }

    public void autoContinue() {
        if (!this.kRI) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.kzT == 2) {
            this.kRM = i;
            ac(33, CD(i), this.fbX.getCurrentPosition());
            this.kRK = this.fbX.getCurrentPosition();
            this.fbX.start();
            if (this.kRF) {
                ag.a(this.aio, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.kRC, R.drawable.icon_video_midplay);
            this.kzT = 1;
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
        if (this.kRv != null) {
            this.kRv.setAlpha(1.0f);
            this.kRv.setVisibility(0);
            this.kRv.loop(true);
            this.kRv.setMinAndMaxFrame(14, 80);
            this.kRv.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cVP();
        if (z) {
            this.kRv.setAlpha(1.0f);
            this.kRv.setVisibility(0);
            return;
        }
        this.kRv.setVisibility(8);
    }

    private void cVP() {
        if (this.kRv != null) {
            this.kRv.setMinFrame(0);
            this.kRv.setFrame(0);
            this.kRv.cancelAnimation();
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
        if (this.fbX.getCurrentPosition() > 0 && this.kzT != -1 && z) {
            int i = 32;
            int currentPosition = this.fbX.getCurrentPosition();
            if (this.fbX.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, CD(this.kRM), currentPosition, this.fbX.isPlaying());
        }
        cVQ();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fbX.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.kOb.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.ioJ.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int bt = com.baidu.b.a.e.a.bt(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = bt;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = bt;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = bt;
            layoutParams4.height = equipmentWidth;
            am.setBackgroundColor(this, R.color.black_alpha100);
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        }
        this.fbX.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVQ() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRN);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRO);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRP);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fbX.stopPlayback();
        this.kzT = -1;
        ag.a(this.aio, false);
        tM(false);
        this.ioJ.setForegroundDrawable(0);
        this.ioJ.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.kRC, R.drawable.icon_video_midpause);
        this.kRD.awd();
        this.kRz.setVisibility(8);
        if (this.kRs != null) {
            this.kRw.setText(StringUtils.translateSecondsToString(this.kRs.video_duration.intValue()));
            this.kRw.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.hxU = null;
        this.kRJ = false;
        MessageManager.getInstance().unRegisterListener(this.kRQ);
        MessageManager.getInstance().unRegisterListener(this.kDt);
        MessageManager.getInstance().unRegisterListener(this.hoS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int CD(int i) {
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
        return this.kRs != null ? this.kRs.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.kOd instanceof com.baidu.tieba.recapp.e.a) && (this.kRH instanceof AdCard) && !((AdCard) this.kRH).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kOd).bmz();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.kOd instanceof com.baidu.tieba.recapp.e.a) && (this.kRH instanceof AdCard) && !((AdCard) this.kRH).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kOd).cVG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK(boolean z) {
        if (z) {
            if (this.hxU != null) {
                this.hxU.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.kRy, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.kRx, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.kzT == 1) {
                ag.a(this.aio, true);
            }
        } else {
            if (this.hxU != null) {
                this.hxU.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.kRy, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.kRx, R.drawable.icon_vedio_npronunciation_small_white);
            ag.a(this.aio, false);
        }
        this.kRF = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.kzT;
    }

    public VideoInfo getData() {
        return this.kRs;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.kRE;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.kRt = advertAppInfo;
        this.kRu = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(this.kRt, 303, i, CD(this.kRM), this.kRs.video_duration.intValue(), this.mDuration, -1);
        if (this.kOd != null) {
            this.kOd.e(a);
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
        if (this.kRt != null && this.kRs != null) {
            this.kRt.page = this.mPage;
            com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(this.kRt, i, this.kRu, i2, this.kRs.video_duration.intValue(), com.baidu.tieba.ad.a.a.ph(i3), i4));
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
                c(str, this.kRK, i3, this.mDuration, str2, CE(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.kKO != null && "cpv".equals(this.kKO.kLQ) && !TextUtils.isEmpty(this.kKO.kLR)) {
            new com.baidu.tieba.recapp.request.a(this.kKO.kLR).a(str, i, i2, i3, str2, str3);
        }
    }

    private String CE(int i) {
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
            this.kRq = view;
            this.kRr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRO);
            if (this.boW != null) {
                this.boW.cancel();
            }
            this.kRB.setVisibility(0);
            if (this.kzT == 1) {
                am.setImageResource(this.kRC, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.kRC, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.kRB.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVR() {
        switch (this.kzT) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.kF(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aST();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.kRI = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    tL(true);
                    return;
                }
                return;
            case 2:
                this.kRI = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRO);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.kRO, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVS() {
        if (!this.dhf && this.boW != null) {
            this.kRB.startAnimation(this.boW);
            this.dhf = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.boW = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.boW.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.kRB.setVisibility(8);
                    DistributeVideoView.this.dhf = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cVT() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kRP);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kRP, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM(boolean z) {
        if (this.kRx != null && this.mStyle == 1) {
            if (z) {
                this.kRx.setVisibility(0);
                cVT();
                return;
            }
            this.kRx.setVisibility(8);
        }
    }
}
