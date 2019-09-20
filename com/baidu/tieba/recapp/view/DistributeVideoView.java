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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ac;
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
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private String aWw;
    private Animation afH;
    private String azQ;
    private WeakReference<Context> bCb;
    boolean bps;
    private g.b cKP;
    private QuickVideoView.b cKT;
    private g.a cUp;
    private g.f cUq;
    private g.e cUs;
    private g dhY;
    private QuickVideoView dpn;
    private CustomMessageListener fxD;
    private ForeDrawableImageView gwR;
    private TBLottieAnimationView iBJ;
    private CustomMessageListener iCp;
    private AdCard.a iJt;
    private AdCard.f iJu;
    private ViewGroup iMN;
    private d iMO;
    private e iMP;
    private CustomMessageListener iQA;
    private View iQf;
    private boolean iQg;
    private AdvertAppInfo iQh;
    private int iQi;
    private TextView iQj;
    private ImageView iQk;
    private ImageView iQl;
    private TextView iQm;
    private View iQn;
    private ImageView iQo;
    private VideoControllerView iQp;
    private boolean iQq;
    private long iQr;
    private b iQs;
    boolean iQt;
    private boolean iQu;
    private int iQv;
    boolean iQw;
    private int iQx;
    private Runnable iQy;
    private Runnable iQz;
    private VideoInfo iid;
    private int iie;
    private View iil;
    private long iin;
    private Runnable iit;
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
    public void cge() {
        if (this.iBJ != null) {
            this.iBJ.clearAnimation();
            this.iBJ.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.iBJ.setVisibility(8);
                    DistributeVideoView.this.gwR.setVisibility(8);
                    DistributeVideoView.this.qy(DistributeVideoView.this.iQq);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iQj.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iQp.setPlayer(DistributeVideoView.this.dpn);
                        DistributeVideoView.this.iQp.aC(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.iid.video_duration.intValue()));
                        DistributeVideoView.this.iQp.showProgress();
                        DistributeVideoView.this.qz(true);
                        com.baidu.adp.lib.g.e.iK().removeCallbacks(DistributeVideoView.this.iQy);
                        com.baidu.adp.lib.g.e.iK().postDelayed(DistributeVideoView.this.iQy, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.iin = DistributeVideoView.this.dpn.getCurrentPosition();
                    DistributeVideoView.this.qA(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.iBJ.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iQg = false;
        this.bCb = null;
        this.iie = -1;
        this.iin = 0L;
        this.iQq = false;
        this.iQr = 0L;
        this.mStyle = 1;
        this.bps = false;
        this.iQt = false;
        this.iQu = false;
        this.iQw = false;
        this.iQx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.iil) {
                    DistributeVideoView.this.iil.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iQl || view == DistributeVideoView.this.iQk) {
                    DistributeVideoView.this.qy(DistributeVideoView.this.iQq ? false : true);
                } else if (view == DistributeVideoView.this.iBJ || view == DistributeVideoView.this.iQo) {
                    DistributeVideoView.this.cjR();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iQh == null || !DistributeVideoView.this.iQh.acN()) {
                    DistributeVideoView.this.cjR();
                } else {
                    DistributeVideoView.this.ah(2, 1, 0);
                    if (DistributeVideoView.this.iQh != null) {
                        WebVideoActivity.iJn = new WebVideoActivity.a();
                        WebVideoActivity.iJn.iJx = DistributeVideoView.this.iQh;
                        WebVideoActivity.iJn.azQ = "DETAIL";
                        WebVideoActivity.iJn.mPageNum = DistributeVideoView.this.iQi;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.aWw) ? DistributeVideoView.this.aWw : DistributeVideoView.this.iQh.bFu;
                    if (a.aAF().aAG() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iid.video_url, DistributeVideoView.this.iid.thumbnail_url, DistributeVideoView.this.iid.video_width.intValue() / DistributeVideoView.this.iid.video_height.intValue(), DistributeVideoView.this.iid.video_duration.intValue(), DistributeVideoView.this.iQh.bFs);
                        if (DistributeVideoView.this.iJt != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iJt.iKv);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iJt.iKw);
                        }
                        if (DistributeVideoView.this.iJu != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iJu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, newWebVideoActivityConfig));
                        if (DistributeVideoView.this.parallelChargeInfo != null) {
                            c.AB(DistributeVideoView.this.parallelChargeInfo.hgN);
                            Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.hgQ.iterator();
                            while (it.hasNext()) {
                                c.AB(it.next());
                            }
                            return;
                        }
                        return;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iid.video_url, DistributeVideoView.this.iid.thumbnail_url, DistributeVideoView.this.iid.video_width.intValue() / DistributeVideoView.this.iid.video_height.intValue(), DistributeVideoView.this.iid.video_duration.intValue());
                    if (DistributeVideoView.this.iJt != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iJt.iKv);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iJt.iKw);
                    }
                    if (DistributeVideoView.this.iJu != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iJu.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.AB(DistributeVideoView.this.parallelChargeInfo.hgN);
                        Iterator<String> it2 = DistributeVideoView.this.parallelChargeInfo.hgQ.iterator();
                        while (it2.hasNext()) {
                            c.AB(it2.next());
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
                        if (DistributeVideoView.this.iie != 1) {
                            if (DistributeVideoView.this.dpn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.iie = 1;
                                DistributeVideoView.this.cge();
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
                        if (DistributeVideoView.this.iie == 1) {
                            if (DistributeVideoView.this.iin == DistributeVideoView.this.dpn.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.iin = DistributeVideoView.this.dpn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iQv = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dhY = gVar;
                    DistributeVideoView.this.dhY.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iQq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qy(false);
                    }
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iQh != null) {
                    if (DistributeVideoView.this.iQw && "DETAIL".equals(DistributeVideoView.this.iQh.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ah(i3, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), 0);
                }
                return false;
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cjQ();
                DistributeVideoView.this.ah(36, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), gVar.getCurrentPosition());
                DistributeVideoView.this.gwR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.iil.setVisibility(0);
                return true;
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iQr = System.currentTimeMillis();
                DistributeVideoView.this.iQw = true;
                DistributeVideoView.this.ah(34, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), gVar.getDuration());
                DistributeVideoView.this.cjQ();
                if (DistributeVideoView.this.iMP != null) {
                    DistributeVideoView.this.iMP.cjI();
                    DistributeVideoView.this.iQj.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.iit = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.iid != null && DistributeVideoView.this.dpn != null) {
                    DistributeVideoView.this.zT(1);
                }
            }
        };
        this.iQy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cjS();
            }
        };
        this.iQz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qA(false);
            }
        };
        this.iCp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iQu) {
                            DistributeVideoView.this.qy(true);
                            return;
                        } else {
                            DistributeVideoView.this.qy(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iQu = DistributeVideoView.this.iQq;
                    DistributeVideoView.this.qy(true);
                }
            }
        };
        this.fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qy(true);
                    }
                }
            }
        };
        this.iQA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qA(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iQg = false;
        this.bCb = null;
        this.iie = -1;
        this.iin = 0L;
        this.iQq = false;
        this.iQr = 0L;
        this.mStyle = 1;
        this.bps = false;
        this.iQt = false;
        this.iQu = false;
        this.iQw = false;
        this.iQx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.iil) {
                    DistributeVideoView.this.iil.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iQl || view == DistributeVideoView.this.iQk) {
                    DistributeVideoView.this.qy(DistributeVideoView.this.iQq ? false : true);
                } else if (view == DistributeVideoView.this.iBJ || view == DistributeVideoView.this.iQo) {
                    DistributeVideoView.this.cjR();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iQh == null || !DistributeVideoView.this.iQh.acN()) {
                    DistributeVideoView.this.cjR();
                } else {
                    DistributeVideoView.this.ah(2, 1, 0);
                    if (DistributeVideoView.this.iQh != null) {
                        WebVideoActivity.iJn = new WebVideoActivity.a();
                        WebVideoActivity.iJn.iJx = DistributeVideoView.this.iQh;
                        WebVideoActivity.iJn.azQ = "DETAIL";
                        WebVideoActivity.iJn.mPageNum = DistributeVideoView.this.iQi;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.aWw) ? DistributeVideoView.this.aWw : DistributeVideoView.this.iQh.bFu;
                    if (a.aAF().aAG() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iid.video_url, DistributeVideoView.this.iid.thumbnail_url, DistributeVideoView.this.iid.video_width.intValue() / DistributeVideoView.this.iid.video_height.intValue(), DistributeVideoView.this.iid.video_duration.intValue(), DistributeVideoView.this.iQh.bFs);
                        if (DistributeVideoView.this.iJt != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iJt.iKv);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iJt.iKw);
                        }
                        if (DistributeVideoView.this.iJu != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iJu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, newWebVideoActivityConfig));
                        if (DistributeVideoView.this.parallelChargeInfo != null) {
                            c.AB(DistributeVideoView.this.parallelChargeInfo.hgN);
                            Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.hgQ.iterator();
                            while (it.hasNext()) {
                                c.AB(it.next());
                            }
                            return;
                        }
                        return;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iid.video_url, DistributeVideoView.this.iid.thumbnail_url, DistributeVideoView.this.iid.video_width.intValue() / DistributeVideoView.this.iid.video_height.intValue(), DistributeVideoView.this.iid.video_duration.intValue());
                    if (DistributeVideoView.this.iJt != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iJt.iKv);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iJt.iKw);
                    }
                    if (DistributeVideoView.this.iJu != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iJu.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.AB(DistributeVideoView.this.parallelChargeInfo.hgN);
                        Iterator<String> it2 = DistributeVideoView.this.parallelChargeInfo.hgQ.iterator();
                        while (it2.hasNext()) {
                            c.AB(it2.next());
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
                        if (DistributeVideoView.this.iie != 1) {
                            if (DistributeVideoView.this.dpn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.iie = 1;
                                DistributeVideoView.this.cge();
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
                        if (DistributeVideoView.this.iie == 1) {
                            if (DistributeVideoView.this.iin == DistributeVideoView.this.dpn.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.iin = DistributeVideoView.this.dpn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iQv = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dhY = gVar;
                    DistributeVideoView.this.dhY.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iQq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qy(false);
                    }
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iQh != null) {
                    if (DistributeVideoView.this.iQw && "DETAIL".equals(DistributeVideoView.this.iQh.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ah(i3, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), 0);
                }
                return false;
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cjQ();
                DistributeVideoView.this.ah(36, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), gVar.getCurrentPosition());
                DistributeVideoView.this.gwR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.iil.setVisibility(0);
                return true;
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iQr = System.currentTimeMillis();
                DistributeVideoView.this.iQw = true;
                DistributeVideoView.this.ah(34, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), gVar.getDuration());
                DistributeVideoView.this.cjQ();
                if (DistributeVideoView.this.iMP != null) {
                    DistributeVideoView.this.iMP.cjI();
                    DistributeVideoView.this.iQj.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.iit = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.iid != null && DistributeVideoView.this.dpn != null) {
                    DistributeVideoView.this.zT(1);
                }
            }
        };
        this.iQy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cjS();
            }
        };
        this.iQz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qA(false);
            }
        };
        this.iCp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iQu) {
                            DistributeVideoView.this.qy(true);
                            return;
                        } else {
                            DistributeVideoView.this.qy(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iQu = DistributeVideoView.this.iQq;
                    DistributeVideoView.this.qy(true);
                }
            }
        };
        this.fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qy(true);
                    }
                }
            }
        };
        this.iQA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qA(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iQg = false;
        this.bCb = null;
        this.iie = -1;
        this.iin = 0L;
        this.iQq = false;
        this.iQr = 0L;
        this.mStyle = 1;
        this.bps = false;
        this.iQt = false;
        this.iQu = false;
        this.iQw = false;
        this.iQx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.iil) {
                    DistributeVideoView.this.iil.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iQl || view == DistributeVideoView.this.iQk) {
                    DistributeVideoView.this.qy(DistributeVideoView.this.iQq ? false : true);
                } else if (view == DistributeVideoView.this.iBJ || view == DistributeVideoView.this.iQo) {
                    DistributeVideoView.this.cjR();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iQh == null || !DistributeVideoView.this.iQh.acN()) {
                    DistributeVideoView.this.cjR();
                } else {
                    DistributeVideoView.this.ah(2, 1, 0);
                    if (DistributeVideoView.this.iQh != null) {
                        WebVideoActivity.iJn = new WebVideoActivity.a();
                        WebVideoActivity.iJn.iJx = DistributeVideoView.this.iQh;
                        WebVideoActivity.iJn.azQ = "DETAIL";
                        WebVideoActivity.iJn.mPageNum = DistributeVideoView.this.iQi;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.aWw) ? DistributeVideoView.this.aWw : DistributeVideoView.this.iQh.bFu;
                    if (a.aAF().aAG() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iid.video_url, DistributeVideoView.this.iid.thumbnail_url, DistributeVideoView.this.iid.video_width.intValue() / DistributeVideoView.this.iid.video_height.intValue(), DistributeVideoView.this.iid.video_duration.intValue(), DistributeVideoView.this.iQh.bFs);
                        if (DistributeVideoView.this.iJt != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iJt.iKv);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iJt.iKw);
                        }
                        if (DistributeVideoView.this.iJu != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iJu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, newWebVideoActivityConfig));
                        if (DistributeVideoView.this.parallelChargeInfo != null) {
                            c.AB(DistributeVideoView.this.parallelChargeInfo.hgN);
                            Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.hgQ.iterator();
                            while (it.hasNext()) {
                                c.AB(it.next());
                            }
                            return;
                        }
                        return;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iid.video_url, DistributeVideoView.this.iid.thumbnail_url, DistributeVideoView.this.iid.video_width.intValue() / DistributeVideoView.this.iid.video_height.intValue(), DistributeVideoView.this.iid.video_duration.intValue());
                    if (DistributeVideoView.this.iJt != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iJt.iKv);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iJt.iKw);
                    }
                    if (DistributeVideoView.this.iJu != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iJu.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.AB(DistributeVideoView.this.parallelChargeInfo.hgN);
                        Iterator<String> it2 = DistributeVideoView.this.parallelChargeInfo.hgQ.iterator();
                        while (it2.hasNext()) {
                            c.AB(it2.next());
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
                        if (DistributeVideoView.this.iie != 1) {
                            if (DistributeVideoView.this.dpn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.iie = 1;
                                DistributeVideoView.this.cge();
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
                        if (DistributeVideoView.this.iie == 1) {
                            if (DistributeVideoView.this.iin == DistributeVideoView.this.dpn.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.iin = DistributeVideoView.this.dpn.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cUq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iQv = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dhY = gVar;
                    DistributeVideoView.this.dhY.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iQq && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qy(false);
                    }
                }
            }
        };
        this.cUs = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iQh != null) {
                    if (DistributeVideoView.this.iQw && "DETAIL".equals(DistributeVideoView.this.iQh.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ah(i3, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), 0);
                }
                return false;
            }
        };
        this.cKP = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cjQ();
                DistributeVideoView.this.ah(36, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), gVar.getCurrentPosition());
                DistributeVideoView.this.gwR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.iil.setVisibility(0);
                return true;
            }
        };
        this.cUp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iQr = System.currentTimeMillis();
                DistributeVideoView.this.iQw = true;
                DistributeVideoView.this.ah(34, DistributeVideoView.this.zU(DistributeVideoView.this.iQx), gVar.getDuration());
                DistributeVideoView.this.cjQ();
                if (DistributeVideoView.this.iMP != null) {
                    DistributeVideoView.this.iMP.cjI();
                    DistributeVideoView.this.iQj.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cKT = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.iit = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.iid != null && DistributeVideoView.this.dpn != null) {
                    DistributeVideoView.this.zT(1);
                }
            }
        };
        this.iQy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cjS();
            }
        };
        this.iQz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qA(false);
            }
        };
        this.iCp = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iQu) {
                            DistributeVideoView.this.qy(true);
                            return;
                        } else {
                            DistributeVideoView.this.qy(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iQu = DistributeVideoView.this.iQq;
                    DistributeVideoView.this.qy(true);
                }
            }
        };
        this.fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qy(true);
                    }
                }
            }
        };
        this.iQA = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qA(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aWw = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iQs = adCard;
        if (this.iQs != null) {
            this.parallelChargeInfo = this.iQs.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dpn = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.iBJ = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gwR = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iQj = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.iil = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iQm = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iQk = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iQn = this.mRootView.findViewById(R.id.distribute_control);
            this.iQo = (ImageView) this.iQn.findViewById(R.id.distribute_play_icon);
            this.iQl = (ImageView) this.iQn.findViewById(R.id.distribute_voice);
            this.iQp = (VideoControllerView) this.iQn.findViewById(R.id.distribute_process);
            this.iMN = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iMO = new d(context, this.iMN);
            this.iBJ.setAnimation(R.raw.lotti_video_loading);
            this.iBJ.setFrame(0);
        }
    }

    private boolean cbl() {
        return this.mStyle == 1 ? s.cbl() : j.kd();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            Uf();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.iJt = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.iJu = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.iid = videoInfo;
        this.mDuration = this.iid.video_duration.intValue() * 1000;
        this.bCb = new WeakReference<>(this.mContext.getApplicationContext());
        cjQ();
        am.l(this, R.color.cp_bg_line_d);
        int af = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.iid.video_width.intValue() > 0 ? (this.iid.video_height.intValue() * af) / this.iid.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gwR.setDefaultErrorResource(0);
        this.gwR.setDefaultResource(0);
        this.gwR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gwR.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dpn.setOnPreparedListener(this.cUq);
        this.dpn.setOnErrorListener(this.cKP);
        this.dpn.setOnCompletionListener(this.cUp);
        this.dpn.setOnOutInfoListener(this.cUs);
        this.dpn.setOnSurfaceDestroyedListener(this.cKT);
        am.j(this.iQj, R.color.cp_cont_m);
        this.iQj.setText(StringUtils.translateSecondsToString(this.iid.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iQq = false;
            am.c(this.iQk, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iQk.setVisibility(8);
        } else {
            this.iQq = true;
            am.c(this.iQl, (int) R.drawable.ad_icon_sound_open);
            this.iQk.setVisibility(8);
        }
        this.iQl.setOnClickListener(this.mOnClickListener);
        this.iQk.setOnClickListener(this.mOnClickListener);
        this.iil.setOnClickListener(this.mOnClickListener);
        this.iil.setVisibility(8);
        am.l(this.iil, R.color.black_alpha80);
        am.j(this.iQm, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iQj.setVisibility(0);
            return;
        }
        this.iQj.setVisibility(8);
        this.iQo.setOnClickListener(this.mOnClickListener);
        this.iBJ.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.iid = videoInfo;
        this.bCb = new WeakReference<>(this.mContext.getApplicationContext());
        cjQ();
        am.l(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gwR.setDefaultErrorResource(0);
        this.gwR.setDefaultResource(0);
        this.gwR.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gwR.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dpn.setOnPreparedListener(this.cUq);
        this.dpn.setOnErrorListener(this.cKP);
        this.dpn.setOnCompletionListener(this.cUp);
        this.dpn.setOnOutInfoListener(this.cUs);
        this.dpn.setOnSurfaceDestroyedListener(this.cKT);
        am.j(this.iQj, R.color.cp_cont_m);
        this.iQj.setText(StringUtils.translateSecondsToString(this.iid.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iQq = false;
            am.c(this.iQk, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iQk.setVisibility(8);
        } else {
            this.iQq = true;
            am.c(this.iQl, (int) R.drawable.ad_icon_sound_open);
            this.iQk.setVisibility(8);
        }
        this.iQl.setOnClickListener(this.mOnClickListener);
        this.iQk.setOnClickListener(this.mOnClickListener);
        this.iil.setOnClickListener(this.mOnClickListener);
        this.iil.setVisibility(8);
        am.l(this.iil, R.color.black_alpha80);
        am.j(this.iQm, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.iQj.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iQj.setVisibility(8);
        this.iQo.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iMP = this.iMO.a(this.iJu, this.iMP);
        if (this.iMP != null) {
            this.iMP.setPageContext(this.mPageContext);
            this.iMP.c(this.iQs);
            this.iMP.setAdvertAppInfo(advertAppInfo);
            this.iMP.a(this.iJu);
            this.iMP.cjJ();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iMP != null) {
            this.iMP.setDownloadAppCallback(cVar);
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
            m(this.mRootView, i2, i3);
            return true;
        }
        m(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void m(View view, int i, int i2) {
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
        this.cUp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zT(int i) {
        this.iQx = i;
        if (this.iid != null && this.iie == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iQr) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iMP != null) {
                    this.iMP.cjJ();
                }
                this.dpn.setVideoPath(this.iid.video_url);
                this.dpn.start();
                this.iQv = this.dpn.getCurrentPosition();
                am.c(this.iQo, (int) R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.iil.setVisibility(8);
                this.gwR.setForegroundDrawable(0);
                this.iie = 0;
                if (this.mStyle == 1) {
                    this.iQj.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iQj.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iQA);
                MessageManager.getInstance().registerListener(this.iCp);
                MessageManager.getInstance().registerListener(this.fxD);
            }
        }
    }

    public void performPlay() {
        zT(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (cbl()) {
            if (i <= 0) {
                zT(1);
                return;
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iit);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.iit, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.iie == 1) {
            E(32, zU(this.iQx), this.dpn.getCurrentPosition(), i);
            this.dpn.pause();
            ac.a(this.bCb, false);
            setLoadingAnimShow(true);
            am.c(this.iQo, (int) R.drawable.icon_video_midpause);
            this.iie = 2;
        }
    }

    public void autoContinue() {
        if (!this.iQt) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.iie == 2) {
            this.iQx = i;
            ah(33, zU(i), this.dpn.getCurrentPosition());
            this.iQv = this.dpn.getCurrentPosition();
            this.dpn.start();
            if (this.iQq) {
                ac.a(this.bCb, true);
            }
            setLoadingAnimShow(false);
            am.c(this.iQo, (int) R.drawable.icon_video_midplay);
            this.iie = 1;
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
        if (this.iBJ != null) {
            this.iBJ.setAlpha(1.0f);
            this.iBJ.setVisibility(0);
            this.iBJ.y(true);
            this.iBJ.setMinAndMaxFrame(14, 80);
            this.iBJ.br();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cjP();
        if (z) {
            this.iBJ.setAlpha(1.0f);
            this.iBJ.setVisibility(0);
            return;
        }
        this.iBJ.setVisibility(8);
    }

    private void cjP() {
        if (this.iBJ != null) {
            this.iBJ.setFrame(0);
            this.iBJ.cancelAnimation();
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
        if (this.dpn.getCurrentPosition() > 0 && this.iie != -1 && z) {
            int i = 32;
            int currentPosition = this.dpn.getCurrentPosition();
            if (this.dpn.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, zU(this.iQx), currentPosition, this.dpn.isPlaying());
        }
        cjQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjQ() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iit);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iQy);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iQz);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dpn.stopPlayback();
        this.iie = -1;
        ac.a(this.bCb, false);
        qA(false);
        this.gwR.setForegroundDrawable(0);
        this.gwR.setVisibility(0);
        setLoadingAnimShow(true);
        am.c(this.iQo, (int) R.drawable.icon_video_midpause);
        this.iQp.aDK();
        this.iil.setVisibility(8);
        if (this.iid != null) {
            this.iQj.setText(StringUtils.translateSecondsToString(this.iid.video_duration.intValue()));
            this.iQj.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.dhY = null;
        this.iQu = false;
        MessageManager.getInstance().unRegisterListener(this.iQA);
        MessageManager.getInstance().unRegisterListener(this.iCp);
        MessageManager.getInstance().unRegisterListener(this.fxD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zU(int i) {
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
        return this.iid != null ? this.iid.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qy(boolean z) {
        if (z) {
            if (this.dhY != null) {
                this.dhY.setVolume(1.0f, 1.0f);
            }
            am.c(this.iQl, (int) R.drawable.ad_icon_sound_open);
            am.c(this.iQk, (int) R.drawable.icon_vedio_pronunciation_small_white);
            if (this.iie == 1) {
                ac.a(this.bCb, true);
            }
        } else {
            if (this.dhY != null) {
                this.dhY.setVolume(0.0f, 0.0f);
            }
            am.c(this.iQl, (int) R.drawable.ad_icon_sound_close);
            am.c(this.iQk, (int) R.drawable.icon_vedio_npronunciation_small_white);
            ac.a(this.bCb, false);
        }
        this.iQq = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.iie;
    }

    public VideoInfo getData() {
        return this.iid;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.iin;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iQh = advertAppInfo;
        this.iQi = i;
        this.azQ = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iQh, 303, i, zU(this.iQx), this.iid.video_duration.intValue(), this.mDuration, -1);
        if (this.iMP != null) {
            this.iMP.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(int i, int i2, int i3) {
        E(i, i2, i3, -1);
    }

    private void h(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void E(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.iQh != null && this.iid != null) {
            this.iQh.page = this.azQ;
            com.baidu.tieba.recapp.report.c.cjE().a(f.a(this.iQh, i, this.iQi, i2, this.iid.video_duration.intValue(), com.baidu.tieba.ad.a.a.mA(i3), i4));
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
                if ("DETAIL".equals(this.azQ)) {
                    str2 = "det";
                } else if ("FRS".equals(this.azQ)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.azQ)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.iQv, i3, this.mDuration, str2, zV(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.iJt != null && "cpv".equals(this.iJt.iKv) && !TextUtils.isEmpty(this.iJt.iKw)) {
            new com.baidu.tieba.recapp.request.a(this.iJt.iKw).a(str, i, i2, i3, str2, str3);
        }
    }

    private String zV(int i) {
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
            this.iQf = view;
            this.iQg = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qz(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iQy);
            if (this.afH != null) {
                this.afH.cancel();
            }
            this.iQn.setVisibility(0);
            if (this.iie == 1) {
                am.c(this.iQo, (int) R.drawable.icon_video_midplay);
                return;
            } else {
                am.c(this.iQo, (int) R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iQn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjR() {
        switch (this.iie) {
            case -1:
                if (!j.kc() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.kd() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.hv(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).agO();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.iQt = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qz(true);
                    return;
                }
                return;
            case 2:
                this.iQt = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iQy);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.iQy, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjS() {
        if (!this.bps && this.afH != null) {
            this.iQn.startAnimation(this.afH);
            this.bps = true;
        }
    }

    private void Uf() {
        if (this.mPageContext != null) {
            this.afH = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.afH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.iQn.setVisibility(8);
                    DistributeVideoView.this.bps = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cjT() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iQz);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iQz, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qA(boolean z) {
        if (this.iQk != null && this.mStyle == 1) {
            if (z) {
                this.iQk.setVisibility(0);
                cjT();
                return;
            }
            this.iQk.setVisibility(8);
        }
    }
}
