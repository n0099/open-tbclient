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
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.a.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.b.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
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
    private String aVY;
    private Animation afH;
    private String azs;
    private WeakReference<Context> bBD;
    boolean boU;
    private g.b cJZ;
    private QuickVideoView.b cKd;
    private g.a cTw;
    private g.f cTx;
    private g.e cTz;
    private g dgn;
    private QuickVideoView dnB;
    private CustomMessageListener fvQ;
    private ForeDrawableImageView gva;
    private AdCard.a iHc;
    private AdCard.f iHd;
    private ViewGroup iKr;
    private d iKs;
    private e iKt;
    private View iNJ;
    private boolean iNK;
    private AdvertAppInfo iNL;
    private int iNM;
    private TextView iNN;
    private ImageView iNO;
    private ImageView iNP;
    private TextView iNQ;
    private View iNR;
    private ImageView iNS;
    private VideoControllerView iNT;
    private boolean iNU;
    private long iNV;
    private b iNW;
    boolean iNX;
    private boolean iNY;
    private int iNZ;
    boolean iOa;
    private int iOb;
    private Runnable iOc;
    private Runnable iOd;
    private CustomMessageListener iOe;
    private VideoInfo ige;
    private int igf;
    private View igm;
    private long igo;
    private Runnable igu;
    private CustomMessageListener izX;
    private TBLottieAnimationView izr;
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
    public void cfq() {
        if (this.izr != null) {
            this.izr.clearAnimation();
            this.izr.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.izr.setVisibility(8);
                    DistributeVideoView.this.gva.setVisibility(8);
                    DistributeVideoView.this.qv(DistributeVideoView.this.iNU);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iNN.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iNT.setPlayer(DistributeVideoView.this.dnB);
                        DistributeVideoView.this.iNT.aC(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.ige.video_duration.intValue()));
                        DistributeVideoView.this.iNT.showProgress();
                        DistributeVideoView.this.qw(true);
                        com.baidu.adp.lib.g.e.iK().removeCallbacks(DistributeVideoView.this.iOc);
                        com.baidu.adp.lib.g.e.iK().postDelayed(DistributeVideoView.this.iOc, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.igo = DistributeVideoView.this.dnB.getCurrentPosition();
                    DistributeVideoView.this.qx(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.izr.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iNK = false;
        this.bBD = null;
        this.igf = -1;
        this.igo = 0L;
        this.iNU = false;
        this.iNV = 0L;
        this.mStyle = 1;
        this.boU = false;
        this.iNX = false;
        this.iNY = false;
        this.iOa = false;
        this.iOb = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.igm) {
                    DistributeVideoView.this.igm.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iNP || view == DistributeVideoView.this.iNO) {
                    DistributeVideoView.this.qv(DistributeVideoView.this.iNU ? false : true);
                } else if (view == DistributeVideoView.this.izr || view == DistributeVideoView.this.iNS) {
                    DistributeVideoView.this.cjf();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iNL == null || !DistributeVideoView.this.iNL.acJ()) {
                    DistributeVideoView.this.cjf();
                } else {
                    DistributeVideoView.this.ag(2, 1, 0);
                    if (DistributeVideoView.this.iNL != null) {
                        WebVideoActivity.iGW = new WebVideoActivity.a();
                        WebVideoActivity.iGW.iHg = DistributeVideoView.this.iNL;
                        WebVideoActivity.iGW.azs = "DETAIL";
                        WebVideoActivity.iGW.mPageNum = DistributeVideoView.this.iNM;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVY) ? DistributeVideoView.this.aVY : DistributeVideoView.this.iNL.bEW, true, true, true, DistributeVideoView.this.ige.video_url, DistributeVideoView.this.ige.thumbnail_url, DistributeVideoView.this.ige.video_width.intValue() / DistributeVideoView.this.ige.video_height.intValue(), DistributeVideoView.this.ige.video_duration.intValue());
                    if (DistributeVideoView.this.iHc != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHc.iHZ);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHc.iIa);
                    }
                    if (DistributeVideoView.this.iHd != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHd.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.Ac(DistributeVideoView.this.parallelChargeInfo.heT);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.heW.iterator();
                        while (it.hasNext()) {
                            c.Ac(it.next());
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
                        if (DistributeVideoView.this.igf != 1) {
                            if (DistributeVideoView.this.dnB.getCurrentPosition() > 0) {
                                DistributeVideoView.this.igf = 1;
                                DistributeVideoView.this.cfq();
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
                        if (DistributeVideoView.this.igf == 1) {
                            if (DistributeVideoView.this.igo == DistributeVideoView.this.dnB.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igo = DistributeVideoView.this.dnB.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iNZ = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dgn = gVar;
                    DistributeVideoView.this.dgn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iNU && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qv(false);
                    }
                }
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iNL != null) {
                    if (DistributeVideoView.this.iOa && "DETAIL".equals(DistributeVideoView.this.iNL.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ag(i3, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), 0);
                }
                return false;
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cje();
                DistributeVideoView.this.ag(36, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), gVar.getCurrentPosition());
                DistributeVideoView.this.gva.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.igm.setVisibility(0);
                return true;
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iNV = System.currentTimeMillis();
                DistributeVideoView.this.iOa = true;
                DistributeVideoView.this.ag(34, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), gVar.getDuration());
                DistributeVideoView.this.cje();
                if (DistributeVideoView.this.iKt != null) {
                    DistributeVideoView.this.iKt.ciU();
                    DistributeVideoView.this.iNN.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ige != null && DistributeVideoView.this.dnB != null) {
                    DistributeVideoView.this.zQ(1);
                }
            }
        };
        this.iOc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cjg();
            }
        };
        this.iOd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qx(false);
            }
        };
        this.izX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iNY) {
                            DistributeVideoView.this.qv(true);
                            return;
                        } else {
                            DistributeVideoView.this.qv(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iNY = DistributeVideoView.this.iNU;
                    DistributeVideoView.this.qv(true);
                }
            }
        };
        this.fvQ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qv(true);
                    }
                }
            }
        };
        this.iOe = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qx(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iNK = false;
        this.bBD = null;
        this.igf = -1;
        this.igo = 0L;
        this.iNU = false;
        this.iNV = 0L;
        this.mStyle = 1;
        this.boU = false;
        this.iNX = false;
        this.iNY = false;
        this.iOa = false;
        this.iOb = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.igm) {
                    DistributeVideoView.this.igm.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iNP || view == DistributeVideoView.this.iNO) {
                    DistributeVideoView.this.qv(DistributeVideoView.this.iNU ? false : true);
                } else if (view == DistributeVideoView.this.izr || view == DistributeVideoView.this.iNS) {
                    DistributeVideoView.this.cjf();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iNL == null || !DistributeVideoView.this.iNL.acJ()) {
                    DistributeVideoView.this.cjf();
                } else {
                    DistributeVideoView.this.ag(2, 1, 0);
                    if (DistributeVideoView.this.iNL != null) {
                        WebVideoActivity.iGW = new WebVideoActivity.a();
                        WebVideoActivity.iGW.iHg = DistributeVideoView.this.iNL;
                        WebVideoActivity.iGW.azs = "DETAIL";
                        WebVideoActivity.iGW.mPageNum = DistributeVideoView.this.iNM;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVY) ? DistributeVideoView.this.aVY : DistributeVideoView.this.iNL.bEW, true, true, true, DistributeVideoView.this.ige.video_url, DistributeVideoView.this.ige.thumbnail_url, DistributeVideoView.this.ige.video_width.intValue() / DistributeVideoView.this.ige.video_height.intValue(), DistributeVideoView.this.ige.video_duration.intValue());
                    if (DistributeVideoView.this.iHc != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHc.iHZ);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHc.iIa);
                    }
                    if (DistributeVideoView.this.iHd != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHd.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.Ac(DistributeVideoView.this.parallelChargeInfo.heT);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.heW.iterator();
                        while (it.hasNext()) {
                            c.Ac(it.next());
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
                        if (DistributeVideoView.this.igf != 1) {
                            if (DistributeVideoView.this.dnB.getCurrentPosition() > 0) {
                                DistributeVideoView.this.igf = 1;
                                DistributeVideoView.this.cfq();
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
                        if (DistributeVideoView.this.igf == 1) {
                            if (DistributeVideoView.this.igo == DistributeVideoView.this.dnB.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igo = DistributeVideoView.this.dnB.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iNZ = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dgn = gVar;
                    DistributeVideoView.this.dgn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iNU && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qv(false);
                    }
                }
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iNL != null) {
                    if (DistributeVideoView.this.iOa && "DETAIL".equals(DistributeVideoView.this.iNL.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ag(i3, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), 0);
                }
                return false;
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cje();
                DistributeVideoView.this.ag(36, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), gVar.getCurrentPosition());
                DistributeVideoView.this.gva.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.igm.setVisibility(0);
                return true;
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iNV = System.currentTimeMillis();
                DistributeVideoView.this.iOa = true;
                DistributeVideoView.this.ag(34, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), gVar.getDuration());
                DistributeVideoView.this.cje();
                if (DistributeVideoView.this.iKt != null) {
                    DistributeVideoView.this.iKt.ciU();
                    DistributeVideoView.this.iNN.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ige != null && DistributeVideoView.this.dnB != null) {
                    DistributeVideoView.this.zQ(1);
                }
            }
        };
        this.iOc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cjg();
            }
        };
        this.iOd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qx(false);
            }
        };
        this.izX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iNY) {
                            DistributeVideoView.this.qv(true);
                            return;
                        } else {
                            DistributeVideoView.this.qv(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iNY = DistributeVideoView.this.iNU;
                    DistributeVideoView.this.qv(true);
                }
            }
        };
        this.fvQ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qv(true);
                    }
                }
            }
        };
        this.iOe = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qx(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iNK = false;
        this.bBD = null;
        this.igf = -1;
        this.igo = 0L;
        this.iNU = false;
        this.iNV = 0L;
        this.mStyle = 1;
        this.boU = false;
        this.iNX = false;
        this.iNY = false;
        this.iOa = false;
        this.iOb = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.igm) {
                    DistributeVideoView.this.igm.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iNP || view == DistributeVideoView.this.iNO) {
                    DistributeVideoView.this.qv(DistributeVideoView.this.iNU ? false : true);
                } else if (view == DistributeVideoView.this.izr || view == DistributeVideoView.this.iNS) {
                    DistributeVideoView.this.cjf();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iNL == null || !DistributeVideoView.this.iNL.acJ()) {
                    DistributeVideoView.this.cjf();
                } else {
                    DistributeVideoView.this.ag(2, 1, 0);
                    if (DistributeVideoView.this.iNL != null) {
                        WebVideoActivity.iGW = new WebVideoActivity.a();
                        WebVideoActivity.iGW.iHg = DistributeVideoView.this.iNL;
                        WebVideoActivity.iGW.azs = "DETAIL";
                        WebVideoActivity.iGW.mPageNum = DistributeVideoView.this.iNM;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVY) ? DistributeVideoView.this.aVY : DistributeVideoView.this.iNL.bEW, true, true, true, DistributeVideoView.this.ige.video_url, DistributeVideoView.this.ige.thumbnail_url, DistributeVideoView.this.ige.video_width.intValue() / DistributeVideoView.this.ige.video_height.intValue(), DistributeVideoView.this.ige.video_duration.intValue());
                    if (DistributeVideoView.this.iHc != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHc.iHZ);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHc.iIa);
                    }
                    if (DistributeVideoView.this.iHd != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHd.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.Ac(DistributeVideoView.this.parallelChargeInfo.heT);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.heW.iterator();
                        while (it.hasNext()) {
                            c.Ac(it.next());
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
                        if (DistributeVideoView.this.igf != 1) {
                            if (DistributeVideoView.this.dnB.getCurrentPosition() > 0) {
                                DistributeVideoView.this.igf = 1;
                                DistributeVideoView.this.cfq();
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
                        if (DistributeVideoView.this.igf == 1) {
                            if (DistributeVideoView.this.igo == DistributeVideoView.this.dnB.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igo = DistributeVideoView.this.dnB.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cTx = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iNZ = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dgn = gVar;
                    DistributeVideoView.this.dgn.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iNU && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qv(false);
                    }
                }
            }
        };
        this.cTz = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iNL != null) {
                    if (DistributeVideoView.this.iOa && "DETAIL".equals(DistributeVideoView.this.iNL.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ag(i3, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), 0);
                }
                return false;
            }
        };
        this.cJZ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cje();
                DistributeVideoView.this.ag(36, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), gVar.getCurrentPosition());
                DistributeVideoView.this.gva.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.igm.setVisibility(0);
                return true;
            }
        };
        this.cTw = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iNV = System.currentTimeMillis();
                DistributeVideoView.this.iOa = true;
                DistributeVideoView.this.ag(34, DistributeVideoView.this.zR(DistributeVideoView.this.iOb), gVar.getDuration());
                DistributeVideoView.this.cje();
                if (DistributeVideoView.this.iKt != null) {
                    DistributeVideoView.this.iKt.ciU();
                    DistributeVideoView.this.iNN.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cKd = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.igu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ige != null && DistributeVideoView.this.dnB != null) {
                    DistributeVideoView.this.zQ(1);
                }
            }
        };
        this.iOc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cjg();
            }
        };
        this.iOd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qx(false);
            }
        };
        this.izX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iNY) {
                            DistributeVideoView.this.qv(true);
                            return;
                        } else {
                            DistributeVideoView.this.qv(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iNY = DistributeVideoView.this.iNU;
                    DistributeVideoView.this.qv(true);
                }
            }
        };
        this.fvQ = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qv(true);
                    }
                }
            }
        };
        this.iOe = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qx(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aVY = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iNW = adCard;
        if (this.iNW != null) {
            this.parallelChargeInfo = this.iNW.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dnB = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.izr = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gva = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iNN = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.igm = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iNQ = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iNO = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iNR = this.mRootView.findViewById(R.id.distribute_control);
            this.iNS = (ImageView) this.iNR.findViewById(R.id.distribute_play_icon);
            this.iNP = (ImageView) this.iNR.findViewById(R.id.distribute_voice);
            this.iNT = (VideoControllerView) this.iNR.findViewById(R.id.distribute_process);
            this.iKr = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iKs = new d(context, this.iKr);
            this.izr.setAnimation(R.raw.lotti_video_loading);
            this.izr.setFrame(0);
        }
    }

    private boolean cax() {
        return this.mStyle == 1 ? s.cax() : j.kd();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            Ub();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.iHc = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.iHd = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ige = videoInfo;
        this.mDuration = this.ige.video_duration.intValue() * 1000;
        this.bBD = new WeakReference<>(this.mContext.getApplicationContext());
        cje();
        am.l(this, R.color.cp_bg_line_d);
        int af = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.ige.video_width.intValue() > 0 ? (this.ige.video_height.intValue() * af) / this.ige.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gva.setDefaultErrorResource(0);
        this.gva.setDefaultResource(0);
        this.gva.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gva.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dnB.setOnPreparedListener(this.cTx);
        this.dnB.setOnErrorListener(this.cJZ);
        this.dnB.setOnCompletionListener(this.cTw);
        this.dnB.setOnOutInfoListener(this.cTz);
        this.dnB.setOnSurfaceDestroyedListener(this.cKd);
        am.j(this.iNN, R.color.cp_cont_m);
        this.iNN.setText(StringUtils.translateSecondsToString(this.ige.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iNU = false;
            am.c(this.iNO, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iNO.setVisibility(8);
        } else {
            this.iNU = true;
            am.c(this.iNP, (int) R.drawable.ad_icon_sound_open);
            this.iNO.setVisibility(8);
        }
        this.iNP.setOnClickListener(this.mOnClickListener);
        this.iNO.setOnClickListener(this.mOnClickListener);
        this.igm.setOnClickListener(this.mOnClickListener);
        this.igm.setVisibility(8);
        am.l(this.igm, R.color.black_alpha80);
        am.j(this.iNQ, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iNN.setVisibility(0);
            return;
        }
        this.iNN.setVisibility(8);
        this.iNS.setOnClickListener(this.mOnClickListener);
        this.izr.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ige = videoInfo;
        this.bBD = new WeakReference<>(this.mContext.getApplicationContext());
        cje();
        am.l(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gva.setDefaultErrorResource(0);
        this.gva.setDefaultResource(0);
        this.gva.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gva.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dnB.setOnPreparedListener(this.cTx);
        this.dnB.setOnErrorListener(this.cJZ);
        this.dnB.setOnCompletionListener(this.cTw);
        this.dnB.setOnOutInfoListener(this.cTz);
        this.dnB.setOnSurfaceDestroyedListener(this.cKd);
        am.j(this.iNN, R.color.cp_cont_m);
        this.iNN.setText(StringUtils.translateSecondsToString(this.ige.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iNU = false;
            am.c(this.iNO, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iNO.setVisibility(8);
        } else {
            this.iNU = true;
            am.c(this.iNP, (int) R.drawable.ad_icon_sound_open);
            this.iNO.setVisibility(8);
        }
        this.iNP.setOnClickListener(this.mOnClickListener);
        this.iNO.setOnClickListener(this.mOnClickListener);
        this.igm.setOnClickListener(this.mOnClickListener);
        this.igm.setVisibility(8);
        am.l(this.igm, R.color.black_alpha80);
        am.j(this.iNQ, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.iNN.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iNN.setVisibility(8);
        this.iNS.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iKt = this.iKs.a(this.iHd, this.iKt);
        if (this.iKt != null) {
            this.iKt.setPageContext(this.mPageContext);
            this.iKt.c(this.iNW);
            this.iKt.setAdvertAppInfo(advertAppInfo);
            this.iKt.a(this.iHd);
            this.iKt.ciV();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iKt != null) {
            this.iKt.setDownloadAppCallback(cVar);
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
        this.cTw = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ(int i) {
        this.iOb = i;
        if (this.ige != null && this.igf == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iNV) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iKt != null) {
                    this.iKt.ciV();
                }
                this.dnB.setVideoPath(this.ige.video_url);
                this.dnB.start();
                this.iNZ = this.dnB.getCurrentPosition();
                am.c(this.iNS, (int) R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.igm.setVisibility(8);
                this.gva.setForegroundDrawable(0);
                this.igf = 0;
                if (this.mStyle == 1) {
                    this.iNN.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iNN.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iOe);
                MessageManager.getInstance().registerListener(this.izX);
                MessageManager.getInstance().registerListener(this.fvQ);
            }
        }
    }

    public void performPlay() {
        zQ(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (cax()) {
            if (i <= 0) {
                zQ(1);
                return;
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.igu);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.igu, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.igf == 1) {
            B(32, zR(this.iOb), this.dnB.getCurrentPosition(), i);
            this.dnB.pause();
            ad.a(this.bBD, false);
            setLoadingAnimShow(true);
            am.c(this.iNS, (int) R.drawable.icon_video_midpause);
            this.igf = 2;
        }
    }

    public void autoContinue() {
        if (!this.iNX) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.igf == 2) {
            this.iOb = i;
            ag(33, zR(i), this.dnB.getCurrentPosition());
            this.iNZ = this.dnB.getCurrentPosition();
            this.dnB.start();
            if (this.iNU) {
                ad.a(this.bBD, true);
            }
            setLoadingAnimShow(false);
            am.c(this.iNS, (int) R.drawable.icon_video_midplay);
            this.igf = 1;
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
        if (this.izr != null) {
            this.izr.setAlpha(1.0f);
            this.izr.setVisibility(0);
            this.izr.y(true);
            this.izr.setMinAndMaxFrame(14, 80);
            this.izr.br();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cjd();
        if (z) {
            this.izr.setAlpha(1.0f);
            this.izr.setVisibility(0);
            return;
        }
        this.izr.setVisibility(8);
    }

    private void cjd() {
        if (this.izr != null) {
            this.izr.setFrame(0);
            this.izr.cancelAnimation();
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
        if (this.dnB.getCurrentPosition() > 0 && this.igf != -1 && z) {
            int i = 32;
            int currentPosition = this.dnB.getCurrentPosition();
            if (this.dnB.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, zR(this.iOb), currentPosition, this.dnB.isPlaying());
        }
        cje();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cje() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.igu);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iOc);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iOd);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dnB.cey();
        this.igf = -1;
        ad.a(this.bBD, false);
        qx(false);
        this.gva.setForegroundDrawable(0);
        this.gva.setVisibility(0);
        setLoadingAnimShow(true);
        am.c(this.iNS, (int) R.drawable.icon_video_midpause);
        this.iNT.aDg();
        this.igm.setVisibility(8);
        if (this.ige != null) {
            this.iNN.setText(StringUtils.translateSecondsToString(this.ige.video_duration.intValue()));
            this.iNN.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.dgn = null;
        this.iNY = false;
        MessageManager.getInstance().unRegisterListener(this.iOe);
        MessageManager.getInstance().unRegisterListener(this.izX);
        MessageManager.getInstance().unRegisterListener(this.fvQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zR(int i) {
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
        return this.ige != null ? this.ige.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(boolean z) {
        if (z) {
            if (this.dgn != null) {
                this.dgn.setVolume(1.0f, 1.0f);
            }
            am.c(this.iNP, (int) R.drawable.ad_icon_sound_open);
            am.c(this.iNO, (int) R.drawable.icon_vedio_pronunciation_small_white);
            if (this.igf == 1) {
                ad.a(this.bBD, true);
            }
        } else {
            if (this.dgn != null) {
                this.dgn.setVolume(0.0f, 0.0f);
            }
            am.c(this.iNP, (int) R.drawable.ad_icon_sound_close);
            am.c(this.iNO, (int) R.drawable.icon_vedio_npronunciation_small_white);
            ad.a(this.bBD, false);
        }
        this.iNU = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.igf;
    }

    public VideoInfo getData() {
        return this.ige;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.igo;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iNL = advertAppInfo;
        this.iNM = i;
        this.azs = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iNL, 303, i, zR(this.iOb), this.ige.video_duration.intValue(), this.mDuration, -1);
        if (this.iKt != null) {
            this.iKt.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i, int i2, int i3) {
        B(i, i2, i3, -1);
    }

    private void h(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void B(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.iNL != null && this.ige != null) {
            this.iNL.page = this.azs;
            com.baidu.tieba.recapp.report.c.ciQ().a(f.a(this.iNL, i, this.iNM, i2, this.ige.video_duration.intValue(), a.mw(i3), i4));
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
                if ("DETAIL".equals(this.azs)) {
                    str2 = "det";
                } else if ("FRS".equals(this.azs)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.azs)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.iNZ, i3, this.mDuration, str2, zS(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.iHc != null && "cpv".equals(this.iHc.iHZ) && !TextUtils.isEmpty(this.iHc.iIa)) {
            new com.baidu.tieba.recapp.request.a(this.iHc.iIa).a(str, i, i2, i3, str2, str3);
        }
    }

    private String zS(int i) {
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
            this.iNJ = view;
            this.iNK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qw(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iOc);
            if (this.afH != null) {
                this.afH.cancel();
            }
            this.iNR.setVisibility(0);
            if (this.igf == 1) {
                am.c(this.iNS, (int) R.drawable.icon_video_midplay);
                return;
            } else {
                am.c(this.iNS, (int) R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iNR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjf() {
        switch (this.igf) {
            case -1:
                if (!j.kc() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.kd() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.hu(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).agK();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.iNX = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qw(true);
                    return;
                }
                return;
            case 2:
                this.iNX = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iOc);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.iOc, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjg() {
        if (!this.boU && this.afH != null) {
            this.iNR.startAnimation(this.afH);
            this.boU = true;
        }
    }

    private void Ub() {
        if (this.mPageContext != null) {
            this.afH = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.afH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.iNR.setVisibility(8);
                    DistributeVideoView.this.boU = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cjh() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iOd);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iOd, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx(boolean z) {
        if (this.iNO != null && this.mStyle == 1) {
            if (z) {
                this.iNO.setVisibility(0);
                cjh();
                return;
            }
            this.iNO.setVisibility(8);
        }
    }
}
