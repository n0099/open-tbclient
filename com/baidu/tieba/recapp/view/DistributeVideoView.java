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
    private g.b eBk;
    private QuickVideoView.b eBo;
    private g.a eKl;
    private g.f eKm;
    private g.e eKo;
    private QuickVideoView fbM;
    private CustomMessageListener hoH;
    private g hxJ;
    private ForeDrawableImageView inW;
    private CustomMessageListener kCl;
    private AdCard.a kJF;
    private AdCard.f kJG;
    private ViewGroup kMS;
    private d kMT;
    private e kMU;
    private boolean kPi;
    private boolean kQA;
    private int kQB;
    boolean kQC;
    private int kQD;
    private Runnable kQE;
    private Runnable kQF;
    private Runnable kQG;
    private CustomMessageListener kQH;
    private View kQh;
    private boolean kQi;
    private VideoInfo kQj;
    private AdvertAppInfo kQk;
    private int kQl;
    private TBLottieAnimationView kQm;
    private TextView kQn;
    private ImageView kQo;
    private ImageView kQp;
    private View kQq;
    private TextView kQr;
    private View kQs;
    private ImageView kQt;
    private VideoControllerView kQu;
    private long kQv;
    private boolean kQw;
    private long kQx;
    private b kQy;
    boolean kQz;
    private int kyN;
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
        if (this.kQk != null) {
            WebVideoActivity.kJz = new WebVideoActivity.a();
            WebVideoActivity.kJz.kJJ = this.kQk;
            WebVideoActivity.kJz.mPage = "DETAIL";
            WebVideoActivity.kJz.mPageNum = this.kQl;
            NewWebVideoActivity.kJK = new NewWebVideoActivity.a();
            NewWebVideoActivity.kJK.kJJ = this.kQk;
            NewWebVideoActivity.kJK.mPage = "DETAIL";
            NewWebVideoActivity.kJK.mPageNum = this.kQl;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.kQk.dAw, true, true, true, this.kQj.video_url, this.kQj.thumbnail_url, this.kQj.video_width.intValue() / this.kQj.video_height.intValue(), this.kQj.video_duration.intValue(), this.kQk.dAu);
        if (this.kJF != null) {
            newWebVideoActivityConfig.setChargeStyle(this.kJF.kKH);
            newWebVideoActivityConfig.setChargeUrl(this.kJF.kKI);
        }
        if (this.kJG != null) {
            newWebVideoActivityConfig.setTailFrame(this.kJG.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crz() {
        ac(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.Hx(this.parallelChargeInfo.iYu);
            Iterator<String> it = this.parallelChargeInfo.iYx.iterator();
            while (it.hasNext()) {
                c.Hx(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRF() {
        if (this.kQm != null) {
            this.kQm.clearAnimation();
            this.kQm.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.kQm.setVisibility(8);
                    DistributeVideoView.this.inW.setVisibility(8);
                    DistributeVideoView.this.tK(DistributeVideoView.this.kQw);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.kQn.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.kQu.setPlayer(DistributeVideoView.this.fbM);
                        DistributeVideoView.this.kQu.bj(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.kQj.video_duration.intValue()));
                        DistributeVideoView.this.kQu.showProgress();
                        DistributeVideoView.this.tL(true);
                        com.baidu.adp.lib.f.e.ld().removeCallbacks(DistributeVideoView.this.kQF);
                        com.baidu.adp.lib.f.e.ld().postDelayed(DistributeVideoView.this.kQF, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.kQv = DistributeVideoView.this.fbM.getCurrentPosition();
                    DistributeVideoView.this.tM(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.kQm.setMinFrame(0);
                    DistributeVideoView.this.kQm.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.kQi = false;
        this.aio = null;
        this.kyN = -1;
        this.kQv = 0L;
        this.kQw = false;
        this.kQx = 0L;
        this.mStyle = 1;
        this.dhf = false;
        this.kQz = false;
        this.kQA = false;
        this.kQC = false;
        this.kQD = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kQq) {
                    DistributeVideoView.this.kQq.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kQp || view == DistributeVideoView.this.kQo) {
                    DistributeVideoView.this.tK(DistributeVideoView.this.kQw ? false : true);
                } else if (view == DistributeVideoView.this.kQm || view == DistributeVideoView.this.kQt) {
                    DistributeVideoView.this.cVB();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kQk == null || !DistributeVideoView.this.kQk.aOA()) {
                    if (DistributeVideoView.this.kQy instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kQy;
                        if (!adCard.getAdvertAppInfo().aOz() || adCard.directDownload) {
                            DistributeVideoView.this.cVB();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.crz();
                        return;
                    }
                    DistributeVideoView.this.cVB();
                } else {
                    if (DistributeVideoView.this.kQk != null) {
                        WebVideoActivity.kJz = new WebVideoActivity.a();
                        WebVideoActivity.kJz.kJJ = DistributeVideoView.this.kQk;
                        WebVideoActivity.kJz.mPage = "DETAIL";
                        WebVideoActivity.kJz.mPageNum = DistributeVideoView.this.kQl;
                        NewWebVideoActivity.kJK = new NewWebVideoActivity.a();
                        NewWebVideoActivity.kJK.kJJ = DistributeVideoView.this.kQk;
                        NewWebVideoActivity.kJK.mPage = "DETAIL";
                        NewWebVideoActivity.kJK.mPageNum = DistributeVideoView.this.kQl;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kQk.dAw;
                    if (a.bjL().bjM() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kQj.video_url, DistributeVideoView.this.kQj.thumbnail_url, DistributeVideoView.this.kQj.video_width.intValue() / DistributeVideoView.this.kQj.video_height.intValue(), DistributeVideoView.this.kQj.video_duration.intValue(), DistributeVideoView.this.kQk.dAu);
                        if (DistributeVideoView.this.kJF != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kJF.kKH);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kJF.kKI);
                        }
                        if (DistributeVideoView.this.kJG != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.kJG.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kQj.video_url, DistributeVideoView.this.kQj.thumbnail_url, DistributeVideoView.this.kQj.video_width.intValue() / DistributeVideoView.this.kQj.video_height.intValue(), DistributeVideoView.this.kQj.video_duration.intValue());
                        if (DistributeVideoView.this.kJF != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kJF.kKH);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kJF.kKI);
                        }
                        if (DistributeVideoView.this.kJG != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.kJG.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.crz();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kyN != 1) {
                            if (DistributeVideoView.this.fbM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kyN = 1;
                                DistributeVideoView.this.cRF();
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
                        if (DistributeVideoView.this.kyN == 1) {
                            if (DistributeVideoView.this.kQv == DistributeVideoView.this.fbM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kQv = DistributeVideoView.this.fbM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kQB = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hxJ = gVar;
                    DistributeVideoView.this.hxJ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kQw && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tK(false);
                    }
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kQk != null) {
                    if (DistributeVideoView.this.kQC && "DETAIL".equals(DistributeVideoView.this.kQk.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), 0);
                }
                return false;
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cVA();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), gVar.getCurrentPosition());
                DistributeVideoView.this.inW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kQq.setVisibility(0);
                return true;
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kQx = System.currentTimeMillis();
                DistributeVideoView.this.kQC = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), gVar.getDuration());
                DistributeVideoView.this.cVA();
                if (DistributeVideoView.this.kMU != null) {
                    DistributeVideoView.this.kMU.cVr();
                    DistributeVideoView.this.kQn.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kQE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kQj != null && DistributeVideoView.this.fbM != null) {
                    DistributeVideoView.this.CA(1);
                }
            }
        };
        this.kQF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cVC();
            }
        };
        this.kQG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.tM(false);
            }
        };
        this.kCl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kQA) {
                            DistributeVideoView.this.tK(true);
                            return;
                        } else {
                            DistributeVideoView.this.tK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kQA = DistributeVideoView.this.kQw;
                    DistributeVideoView.this.tK(true);
                }
            }
        };
        this.hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.kQH = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.kQi = false;
        this.aio = null;
        this.kyN = -1;
        this.kQv = 0L;
        this.kQw = false;
        this.kQx = 0L;
        this.mStyle = 1;
        this.dhf = false;
        this.kQz = false;
        this.kQA = false;
        this.kQC = false;
        this.kQD = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kQq) {
                    DistributeVideoView.this.kQq.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kQp || view == DistributeVideoView.this.kQo) {
                    DistributeVideoView.this.tK(DistributeVideoView.this.kQw ? false : true);
                } else if (view == DistributeVideoView.this.kQm || view == DistributeVideoView.this.kQt) {
                    DistributeVideoView.this.cVB();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kQk == null || !DistributeVideoView.this.kQk.aOA()) {
                    if (DistributeVideoView.this.kQy instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kQy;
                        if (!adCard.getAdvertAppInfo().aOz() || adCard.directDownload) {
                            DistributeVideoView.this.cVB();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.crz();
                        return;
                    }
                    DistributeVideoView.this.cVB();
                } else {
                    if (DistributeVideoView.this.kQk != null) {
                        WebVideoActivity.kJz = new WebVideoActivity.a();
                        WebVideoActivity.kJz.kJJ = DistributeVideoView.this.kQk;
                        WebVideoActivity.kJz.mPage = "DETAIL";
                        WebVideoActivity.kJz.mPageNum = DistributeVideoView.this.kQl;
                        NewWebVideoActivity.kJK = new NewWebVideoActivity.a();
                        NewWebVideoActivity.kJK.kJJ = DistributeVideoView.this.kQk;
                        NewWebVideoActivity.kJK.mPage = "DETAIL";
                        NewWebVideoActivity.kJK.mPageNum = DistributeVideoView.this.kQl;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kQk.dAw;
                    if (a.bjL().bjM() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kQj.video_url, DistributeVideoView.this.kQj.thumbnail_url, DistributeVideoView.this.kQj.video_width.intValue() / DistributeVideoView.this.kQj.video_height.intValue(), DistributeVideoView.this.kQj.video_duration.intValue(), DistributeVideoView.this.kQk.dAu);
                        if (DistributeVideoView.this.kJF != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kJF.kKH);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kJF.kKI);
                        }
                        if (DistributeVideoView.this.kJG != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.kJG.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kQj.video_url, DistributeVideoView.this.kQj.thumbnail_url, DistributeVideoView.this.kQj.video_width.intValue() / DistributeVideoView.this.kQj.video_height.intValue(), DistributeVideoView.this.kQj.video_duration.intValue());
                        if (DistributeVideoView.this.kJF != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kJF.kKH);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kJF.kKI);
                        }
                        if (DistributeVideoView.this.kJG != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.kJG.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.crz();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kyN != 1) {
                            if (DistributeVideoView.this.fbM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kyN = 1;
                                DistributeVideoView.this.cRF();
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
                        if (DistributeVideoView.this.kyN == 1) {
                            if (DistributeVideoView.this.kQv == DistributeVideoView.this.fbM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kQv = DistributeVideoView.this.fbM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kQB = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hxJ = gVar;
                    DistributeVideoView.this.hxJ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kQw && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tK(false);
                    }
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.kQk != null) {
                    if (DistributeVideoView.this.kQC && "DETAIL".equals(DistributeVideoView.this.kQk.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), 0);
                }
                return false;
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cVA();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), gVar.getCurrentPosition());
                DistributeVideoView.this.inW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kQq.setVisibility(0);
                return true;
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kQx = System.currentTimeMillis();
                DistributeVideoView.this.kQC = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), gVar.getDuration());
                DistributeVideoView.this.cVA();
                if (DistributeVideoView.this.kMU != null) {
                    DistributeVideoView.this.kMU.cVr();
                    DistributeVideoView.this.kQn.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kQE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kQj != null && DistributeVideoView.this.fbM != null) {
                    DistributeVideoView.this.CA(1);
                }
            }
        };
        this.kQF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cVC();
            }
        };
        this.kQG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.tM(false);
            }
        };
        this.kCl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kQA) {
                            DistributeVideoView.this.tK(true);
                            return;
                        } else {
                            DistributeVideoView.this.tK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kQA = DistributeVideoView.this.kQw;
                    DistributeVideoView.this.tK(true);
                }
            }
        };
        this.hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.kQH = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.kQi = false;
        this.aio = null;
        this.kyN = -1;
        this.kQv = 0L;
        this.kQw = false;
        this.kQx = 0L;
        this.mStyle = 1;
        this.dhf = false;
        this.kQz = false;
        this.kQA = false;
        this.kQC = false;
        this.kQD = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.kQq) {
                    DistributeVideoView.this.kQq.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.kQp || view == DistributeVideoView.this.kQo) {
                    DistributeVideoView.this.tK(DistributeVideoView.this.kQw ? false : true);
                } else if (view == DistributeVideoView.this.kQm || view == DistributeVideoView.this.kQt) {
                    DistributeVideoView.this.cVB();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.kQk == null || !DistributeVideoView.this.kQk.aOA()) {
                    if (DistributeVideoView.this.kQy instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.kQy;
                        if (!adCard.getAdvertAppInfo().aOz() || adCard.directDownload) {
                            DistributeVideoView.this.cVB();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.crz();
                        return;
                    }
                    DistributeVideoView.this.cVB();
                } else {
                    if (DistributeVideoView.this.kQk != null) {
                        WebVideoActivity.kJz = new WebVideoActivity.a();
                        WebVideoActivity.kJz.kJJ = DistributeVideoView.this.kQk;
                        WebVideoActivity.kJz.mPage = "DETAIL";
                        WebVideoActivity.kJz.mPageNum = DistributeVideoView.this.kQl;
                        NewWebVideoActivity.kJK = new NewWebVideoActivity.a();
                        NewWebVideoActivity.kJK.kJJ = DistributeVideoView.this.kQk;
                        NewWebVideoActivity.kJK.mPage = "DETAIL";
                        NewWebVideoActivity.kJK.mPageNum = DistributeVideoView.this.kQl;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.kQk.dAw;
                    if (a.bjL().bjM() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kQj.video_url, DistributeVideoView.this.kQj.thumbnail_url, DistributeVideoView.this.kQj.video_width.intValue() / DistributeVideoView.this.kQj.video_height.intValue(), DistributeVideoView.this.kQj.video_duration.intValue(), DistributeVideoView.this.kQk.dAu);
                        if (DistributeVideoView.this.kJF != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kJF.kKH);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kJF.kKI);
                        }
                        if (DistributeVideoView.this.kJG != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.kJG.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.kQj.video_url, DistributeVideoView.this.kQj.thumbnail_url, DistributeVideoView.this.kQj.video_width.intValue() / DistributeVideoView.this.kQj.video_height.intValue(), DistributeVideoView.this.kQj.video_duration.intValue());
                        if (DistributeVideoView.this.kJF != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.kJF.kKH);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.kJF.kKI);
                        }
                        if (DistributeVideoView.this.kJG != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.kJG.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.crz();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.kyN != 1) {
                            if (DistributeVideoView.this.fbM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.kyN = 1;
                                DistributeVideoView.this.cRF();
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
                        if (DistributeVideoView.this.kyN == 1) {
                            if (DistributeVideoView.this.kQv == DistributeVideoView.this.fbM.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.kQv = DistributeVideoView.this.fbM.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.eKm = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.kQB = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.hxJ = gVar;
                    DistributeVideoView.this.hxJ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.kQw && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.tK(false);
                    }
                }
            }
        };
        this.eKo = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.kQk != null) {
                    if (DistributeVideoView.this.kQC && "DETAIL".equals(DistributeVideoView.this.kQk.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ac(i3, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), 0);
                }
                return false;
            }
        };
        this.eBk = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cVA();
                DistributeVideoView.this.ac(36, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), gVar.getCurrentPosition());
                DistributeVideoView.this.inW.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.kQq.setVisibility(0);
                return true;
            }
        };
        this.eKl = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.kQx = System.currentTimeMillis();
                DistributeVideoView.this.kQC = true;
                DistributeVideoView.this.ac(34, DistributeVideoView.this.CB(DistributeVideoView.this.kQD), gVar.getDuration());
                DistributeVideoView.this.cVA();
                if (DistributeVideoView.this.kMU != null) {
                    DistributeVideoView.this.kMU.cVr();
                    DistributeVideoView.this.kQn.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eBo = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.kQE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.kQj != null && DistributeVideoView.this.fbM != null) {
                    DistributeVideoView.this.CA(1);
                }
            }
        };
        this.kQF = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cVC();
            }
        };
        this.kQG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.tM(false);
            }
        };
        this.kCl = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.kQA) {
                            DistributeVideoView.this.tK(true);
                            return;
                        } else {
                            DistributeVideoView.this.tK(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.kQA = DistributeVideoView.this.kQw;
                    DistributeVideoView.this.tK(true);
                }
            }
        };
        this.hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.kQH = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.kQy = adCard;
        if (this.kQy != null) {
            this.parallelChargeInfo = this.kQy.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fbM = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.kQm = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.inW = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.kQn = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.kQq = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.kQr = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.kQo = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.kQs = this.mRootView.findViewById(R.id.distribute_control);
            this.kQt = (ImageView) this.kQs.findViewById(R.id.distribute_play_icon);
            this.kQp = (ImageView) this.kQs.findViewById(R.id.distribute_voice);
            this.kQu = (VideoControllerView) this.kQs.findViewById(R.id.distribute_process);
            this.kMS = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.kMT = new d(context, this.kMS);
            this.kQm.setAnimation(R.raw.lotti_video_loading);
            this.kQm.setMinFrame(0);
            this.kQm.setFrame(0);
        }
    }

    private boolean cVy() {
        return this.mStyle == 1 ? t.cVy() : j.isWifiNet();
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
        this.kJF = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.kJG = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kQj = videoInfo;
        this.mDuration = this.kQj.video_duration.intValue() * 1000;
        this.aio = new WeakReference<>(this.mContext.getApplicationContext());
        cVA();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.kQj.video_width.intValue() > 0 ? (this.kQj.video_height.intValue() * equipmentWidth) / this.kQj.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.inW.setDefaultErrorResource(0);
        this.inW.setDefaultResource(0);
        this.inW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.inW.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fbM.setOnPreparedListener(this.eKm);
        this.fbM.setOnErrorListener(this.eBk);
        this.fbM.setOnCompletionListener(this.eKl);
        this.fbM.setOnOutInfoListener(this.eKo);
        this.fbM.setOnSurfaceDestroyedListener(this.eBo);
        am.setViewTextColor(this.kQn, (int) R.color.cp_cont_m);
        this.kQn.setText(StringUtils.translateSecondsToString(this.kQj.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kQw = false;
            am.setImageResource(this.kQo, R.drawable.icon_vedio_npronunciation_small_white);
            this.kQo.setVisibility(8);
        } else {
            this.kQw = true;
            am.setImageResource(this.kQp, R.drawable.ad_icon_sound_open);
            this.kQo.setVisibility(8);
        }
        this.kQp.setOnClickListener(this.mOnClickListener);
        this.kQo.setOnClickListener(this.mOnClickListener);
        this.kQq.setOnClickListener(this.mOnClickListener);
        this.kQq.setVisibility(8);
        am.setBackgroundColor(this.kQq, R.color.black_alpha80);
        am.setViewTextColor(this.kQr, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.kQn.setVisibility(0);
            return;
        }
        this.kQn.setVisibility(8);
        this.kQt.setOnClickListener(this.mOnClickListener);
        this.kQm.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.kQj = videoInfo;
        this.aio = new WeakReference<>(this.mContext.getApplicationContext());
        cVA();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.inW.setDefaultErrorResource(0);
        this.inW.setDefaultResource(0);
        this.inW.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.inW.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fbM.setOnPreparedListener(this.eKm);
        this.fbM.setOnErrorListener(this.eBk);
        this.fbM.setOnCompletionListener(this.eKl);
        this.fbM.setOnOutInfoListener(this.eKo);
        this.fbM.setOnSurfaceDestroyedListener(this.eBo);
        am.setViewTextColor(this.kQn, (int) R.color.cp_cont_m);
        this.kQn.setText(StringUtils.translateSecondsToString(this.kQj.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.kQw = false;
            am.setImageResource(this.kQo, R.drawable.icon_vedio_npronunciation_small_white);
            this.kQo.setVisibility(8);
        } else {
            this.kQw = true;
            am.setImageResource(this.kQp, R.drawable.ad_icon_sound_open);
            this.kQo.setVisibility(8);
        }
        this.kQp.setOnClickListener(this.mOnClickListener);
        this.kQo.setOnClickListener(this.mOnClickListener);
        this.kQq.setOnClickListener(this.mOnClickListener);
        this.kQq.setVisibility(8);
        am.setBackgroundColor(this.kQq, R.color.black_alpha80);
        am.setViewTextColor(this.kQr, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.kQn.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.kQn.setVisibility(8);
        this.kQt.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.kQk;
        }
        this.kMU = this.kMT.a(this.kJG, this.kMU);
        if (this.kMU != null) {
            this.kMU.setPageContext(this.mPageContext);
            this.kMU.c(this.kQy);
            if (this.kMU instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.kMU).tI(this.kPi);
            }
            this.kMU.setAdvertAppInfo(advertAppInfo);
            this.kMU.a(this.kJG);
            this.kMU.cVs();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.kPi = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.kMU != null) {
            this.kMU.setDownloadAppCallback(cVar);
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
        this.eKl = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA(int i) {
        this.kQD = i;
        if (this.kQj != null && this.kyN == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.kQx) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.kMU != null) {
                    this.kMU.cVs();
                }
                this.fbM.setVideoPath(this.kQj.video_url);
                this.fbM.start();
                this.kQB = this.fbM.getCurrentPosition();
                am.setImageResource(this.kQt, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.kQq.setVisibility(8);
                this.inW.setForegroundDrawable(0);
                this.kyN = 0;
                if (this.mStyle == 1) {
                    this.kQn.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.kQn.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.kQH);
                MessageManager.getInstance().registerListener(this.kCl);
                MessageManager.getInstance().registerListener(this.hoH);
            }
        }
    }

    public void performPlay() {
        CA(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (cVy()) {
            if (i <= 0) {
                CA(1);
                return;
            }
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQE);
            com.baidu.adp.lib.f.e.ld().postDelayed(this.kQE, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.kyN == 1) {
            E(32, CB(this.kQD), this.fbM.getCurrentPosition(), i);
            this.fbM.pause();
            ag.a(this.aio, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.kQt, R.drawable.icon_video_midpause);
            this.kyN = 2;
        }
    }

    public void autoContinue() {
        if (!this.kQz) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.kyN == 2) {
            this.kQD = i;
            ac(33, CB(i), this.fbM.getCurrentPosition());
            this.kQB = this.fbM.getCurrentPosition();
            this.fbM.start();
            if (this.kQw) {
                ag.a(this.aio, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.kQt, R.drawable.icon_video_midplay);
            this.kyN = 1;
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
        if (this.kQm != null) {
            this.kQm.setAlpha(1.0f);
            this.kQm.setVisibility(0);
            this.kQm.loop(true);
            this.kQm.setMinAndMaxFrame(14, 80);
            this.kQm.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cVz();
        if (z) {
            this.kQm.setAlpha(1.0f);
            this.kQm.setVisibility(0);
            return;
        }
        this.kQm.setVisibility(8);
    }

    private void cVz() {
        if (this.kQm != null) {
            this.kQm.setMinFrame(0);
            this.kQm.setFrame(0);
            this.kQm.cancelAnimation();
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
        if (this.fbM.getCurrentPosition() > 0 && this.kyN != -1 && z) {
            int i = 32;
            int currentPosition = this.fbM.getCurrentPosition();
            if (this.fbM.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, CB(this.kQD), currentPosition, this.fbM.isPlaying());
        }
        cVA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVA() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQE);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQF);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQG);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fbM.stopPlayback();
        this.kyN = -1;
        ag.a(this.aio, false);
        tM(false);
        this.inW.setForegroundDrawable(0);
        this.inW.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.kQt, R.drawable.icon_video_midpause);
        this.kQu.awd();
        this.kQq.setVisibility(8);
        if (this.kQj != null) {
            this.kQn.setText(StringUtils.translateSecondsToString(this.kQj.video_duration.intValue()));
            this.kQn.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.hxJ = null;
        this.kQA = false;
        MessageManager.getInstance().unRegisterListener(this.kQH);
        MessageManager.getInstance().unRegisterListener(this.kCl);
        MessageManager.getInstance().unRegisterListener(this.hoH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int CB(int i) {
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
        return this.kQj != null ? this.kQj.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.kMU instanceof com.baidu.tieba.recapp.e.a) && (this.kQy instanceof AdCard) && !((AdCard) this.kQy).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kMU).bmx();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.kMU instanceof com.baidu.tieba.recapp.e.a) && (this.kQy instanceof AdCard) && !((AdCard) this.kQy).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.kMU).cVq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tK(boolean z) {
        if (z) {
            if (this.hxJ != null) {
                this.hxJ.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.kQp, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.kQo, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.kyN == 1) {
                ag.a(this.aio, true);
            }
        } else {
            if (this.hxJ != null) {
                this.hxJ.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.kQp, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.kQo, R.drawable.icon_vedio_npronunciation_small_white);
            ag.a(this.aio, false);
        }
        this.kQw = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.kyN;
    }

    public VideoInfo getData() {
        return this.kQj;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.kQv;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.kQk = advertAppInfo;
        this.kQl = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = com.baidu.tieba.recapp.report.g.a(this.kQk, 303, i, CB(this.kQD), this.kQj.video_duration.intValue(), this.mDuration, -1);
        if (this.kMU != null) {
            this.kMU.e(a);
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
        if (this.kQk != null && this.kQj != null) {
            this.kQk.page = this.mPage;
            com.baidu.tieba.recapp.report.d.cVk().a(com.baidu.tieba.recapp.report.g.a(this.kQk, i, this.kQl, i2, this.kQj.video_duration.intValue(), com.baidu.tieba.ad.a.a.pf(i3), i4));
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
                c(str, this.kQB, i3, this.mDuration, str2, CC(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.kJF != null && "cpv".equals(this.kJF.kKH) && !TextUtils.isEmpty(this.kJF.kKI)) {
            new com.baidu.tieba.recapp.request.a(this.kJF.kKI).a(str, i, i2, i3, str2, str3);
        }
    }

    private String CC(int i) {
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
            this.kQh = view;
            this.kQi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQF);
            if (this.boW != null) {
                this.boW.cancel();
            }
            this.kQs.setVisibility(0);
            if (this.kyN == 1) {
                am.setImageResource(this.kQt, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.kQt, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.kQs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVB() {
        switch (this.kyN) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.kD(R.string.play_video_mobile_tip);
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
                this.kQz = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    tL(true);
                    return;
                }
                return;
            case 2:
                this.kQz = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQF);
                    com.baidu.adp.lib.f.e.ld().postDelayed(this.kQF, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVC() {
        if (!this.dhf && this.boW != null) {
            this.kQs.startAnimation(this.boW);
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
                    DistributeVideoView.this.kQs.setVisibility(8);
                    DistributeVideoView.this.dhf = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cVD() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.kQG);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.kQG, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM(boolean z) {
        if (this.kQo != null && this.mStyle == 1) {
            if (z) {
                this.kQo.setVisibility(0);
                cVD();
                return;
            }
            this.kQo.setVisibility(8);
        }
    }
}
