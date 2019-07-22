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
import com.baidu.tieba.tbadkCore.q;
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
    private g.b cJS;
    private QuickVideoView.b cJW;
    private g.a cTp;
    private g.f cTq;
    private g.e cTs;
    private g dgg;
    private QuickVideoView dnu;
    private CustomMessageListener fvr;
    private ForeDrawableImageView gui;
    private AdCard.a iFY;
    private AdCard.f iFZ;
    private ViewGroup iJn;
    private d iJo;
    private e iJp;
    private View iMF;
    private boolean iMG;
    private AdvertAppInfo iMH;
    private int iMI;
    private TextView iMJ;
    private ImageView iMK;
    private ImageView iML;
    private TextView iMM;
    private View iMN;
    private ImageView iMO;
    private VideoControllerView iMP;
    private boolean iMQ;
    private long iMR;
    private b iMS;
    boolean iMT;
    private boolean iMU;
    private int iMV;
    boolean iMW;
    private int iMX;
    private Runnable iMY;
    private Runnable iMZ;
    private CustomMessageListener iNa;
    private VideoInfo ifc;
    private int ifd;
    private View ifk;
    private long ifm;
    private Runnable ifs;
    private CustomMessageListener iyT;
    private TBLottieAnimationView iyo;
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
    public void ceY() {
        if (this.iyo != null) {
            this.iyo.clearAnimation();
            this.iyo.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.iyo.setVisibility(8);
                    DistributeVideoView.this.gui.setVisibility(8);
                    DistributeVideoView.this.qu(DistributeVideoView.this.iMQ);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iMJ.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iMP.setPlayer(DistributeVideoView.this.dnu);
                        DistributeVideoView.this.iMP.aC(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.ifc.video_duration.intValue()));
                        DistributeVideoView.this.iMP.showProgress();
                        DistributeVideoView.this.qv(true);
                        com.baidu.adp.lib.g.e.iK().removeCallbacks(DistributeVideoView.this.iMY);
                        com.baidu.adp.lib.g.e.iK().postDelayed(DistributeVideoView.this.iMY, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.ifm = DistributeVideoView.this.dnu.getCurrentPosition();
                    DistributeVideoView.this.qw(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.iyo.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iMG = false;
        this.bBD = null;
        this.ifd = -1;
        this.ifm = 0L;
        this.iMQ = false;
        this.iMR = 0L;
        this.mStyle = 1;
        this.boU = false;
        this.iMT = false;
        this.iMU = false;
        this.iMW = false;
        this.iMX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ifk) {
                    DistributeVideoView.this.ifk.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iML || view == DistributeVideoView.this.iMK) {
                    DistributeVideoView.this.qu(DistributeVideoView.this.iMQ ? false : true);
                } else if (view == DistributeVideoView.this.iyo || view == DistributeVideoView.this.iMO) {
                    DistributeVideoView.this.ciN();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iMH == null || !DistributeVideoView.this.iMH.acI()) {
                    DistributeVideoView.this.ciN();
                } else {
                    DistributeVideoView.this.ag(2, 1, 0);
                    if (DistributeVideoView.this.iMH != null) {
                        WebVideoActivity.iFS = new WebVideoActivity.a();
                        WebVideoActivity.iFS.iGc = DistributeVideoView.this.iMH;
                        WebVideoActivity.iFS.azs = "DETAIL";
                        WebVideoActivity.iFS.mPageNum = DistributeVideoView.this.iMI;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVY) ? DistributeVideoView.this.aVY : DistributeVideoView.this.iMH.bEV, true, true, true, DistributeVideoView.this.ifc.video_url, DistributeVideoView.this.ifc.thumbnail_url, DistributeVideoView.this.ifc.video_width.intValue() / DistributeVideoView.this.ifc.video_height.intValue(), DistributeVideoView.this.ifc.video_duration.intValue());
                    if (DistributeVideoView.this.iFY != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iFY.iGV);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iFY.iGW);
                    }
                    if (DistributeVideoView.this.iFZ != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iFZ.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.Ab(DistributeVideoView.this.parallelChargeInfo.heb);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.hee.iterator();
                        while (it.hasNext()) {
                            c.Ab(it.next());
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
                        if (DistributeVideoView.this.ifd != 1) {
                            if (DistributeVideoView.this.dnu.getCurrentPosition() > 0) {
                                DistributeVideoView.this.ifd = 1;
                                DistributeVideoView.this.ceY();
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
                        if (DistributeVideoView.this.ifd == 1) {
                            if (DistributeVideoView.this.ifm == DistributeVideoView.this.dnu.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.ifm = DistributeVideoView.this.dnu.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iMV = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dgg = gVar;
                    DistributeVideoView.this.dgg.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iMQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qu(false);
                    }
                }
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iMH != null) {
                    if (DistributeVideoView.this.iMW && "DETAIL".equals(DistributeVideoView.this.iMH.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ag(i3, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), 0);
                }
                return false;
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.ciM();
                DistributeVideoView.this.ag(36, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), gVar.getCurrentPosition());
                DistributeVideoView.this.gui.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.ifk.setVisibility(0);
                return true;
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iMR = System.currentTimeMillis();
                DistributeVideoView.this.iMW = true;
                DistributeVideoView.this.ag(34, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), gVar.getDuration());
                DistributeVideoView.this.ciM();
                if (DistributeVideoView.this.iJp != null) {
                    DistributeVideoView.this.iJp.ciC();
                    DistributeVideoView.this.iMJ.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ifs = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ifc != null && DistributeVideoView.this.dnu != null) {
                    DistributeVideoView.this.zO(1);
                }
            }
        };
        this.iMY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ciO();
            }
        };
        this.iMZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qw(false);
            }
        };
        this.iyT = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iMU) {
                            DistributeVideoView.this.qu(true);
                            return;
                        } else {
                            DistributeVideoView.this.qu(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iMU = DistributeVideoView.this.iMQ;
                    DistributeVideoView.this.qu(true);
                }
            }
        };
        this.fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qu(true);
                    }
                }
            }
        };
        this.iNa = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qw(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMG = false;
        this.bBD = null;
        this.ifd = -1;
        this.ifm = 0L;
        this.iMQ = false;
        this.iMR = 0L;
        this.mStyle = 1;
        this.boU = false;
        this.iMT = false;
        this.iMU = false;
        this.iMW = false;
        this.iMX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ifk) {
                    DistributeVideoView.this.ifk.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iML || view == DistributeVideoView.this.iMK) {
                    DistributeVideoView.this.qu(DistributeVideoView.this.iMQ ? false : true);
                } else if (view == DistributeVideoView.this.iyo || view == DistributeVideoView.this.iMO) {
                    DistributeVideoView.this.ciN();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iMH == null || !DistributeVideoView.this.iMH.acI()) {
                    DistributeVideoView.this.ciN();
                } else {
                    DistributeVideoView.this.ag(2, 1, 0);
                    if (DistributeVideoView.this.iMH != null) {
                        WebVideoActivity.iFS = new WebVideoActivity.a();
                        WebVideoActivity.iFS.iGc = DistributeVideoView.this.iMH;
                        WebVideoActivity.iFS.azs = "DETAIL";
                        WebVideoActivity.iFS.mPageNum = DistributeVideoView.this.iMI;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVY) ? DistributeVideoView.this.aVY : DistributeVideoView.this.iMH.bEV, true, true, true, DistributeVideoView.this.ifc.video_url, DistributeVideoView.this.ifc.thumbnail_url, DistributeVideoView.this.ifc.video_width.intValue() / DistributeVideoView.this.ifc.video_height.intValue(), DistributeVideoView.this.ifc.video_duration.intValue());
                    if (DistributeVideoView.this.iFY != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iFY.iGV);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iFY.iGW);
                    }
                    if (DistributeVideoView.this.iFZ != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iFZ.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.Ab(DistributeVideoView.this.parallelChargeInfo.heb);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.hee.iterator();
                        while (it.hasNext()) {
                            c.Ab(it.next());
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
                        if (DistributeVideoView.this.ifd != 1) {
                            if (DistributeVideoView.this.dnu.getCurrentPosition() > 0) {
                                DistributeVideoView.this.ifd = 1;
                                DistributeVideoView.this.ceY();
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
                        if (DistributeVideoView.this.ifd == 1) {
                            if (DistributeVideoView.this.ifm == DistributeVideoView.this.dnu.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.ifm = DistributeVideoView.this.dnu.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iMV = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dgg = gVar;
                    DistributeVideoView.this.dgg.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iMQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qu(false);
                    }
                }
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iMH != null) {
                    if (DistributeVideoView.this.iMW && "DETAIL".equals(DistributeVideoView.this.iMH.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ag(i3, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), 0);
                }
                return false;
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.ciM();
                DistributeVideoView.this.ag(36, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), gVar.getCurrentPosition());
                DistributeVideoView.this.gui.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.ifk.setVisibility(0);
                return true;
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iMR = System.currentTimeMillis();
                DistributeVideoView.this.iMW = true;
                DistributeVideoView.this.ag(34, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), gVar.getDuration());
                DistributeVideoView.this.ciM();
                if (DistributeVideoView.this.iJp != null) {
                    DistributeVideoView.this.iJp.ciC();
                    DistributeVideoView.this.iMJ.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ifs = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ifc != null && DistributeVideoView.this.dnu != null) {
                    DistributeVideoView.this.zO(1);
                }
            }
        };
        this.iMY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ciO();
            }
        };
        this.iMZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qw(false);
            }
        };
        this.iyT = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iMU) {
                            DistributeVideoView.this.qu(true);
                            return;
                        } else {
                            DistributeVideoView.this.qu(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iMU = DistributeVideoView.this.iMQ;
                    DistributeVideoView.this.qu(true);
                }
            }
        };
        this.fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qu(true);
                    }
                }
            }
        };
        this.iNa = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qw(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMG = false;
        this.bBD = null;
        this.ifd = -1;
        this.ifm = 0L;
        this.iMQ = false;
        this.iMR = 0L;
        this.mStyle = 1;
        this.boU = false;
        this.iMT = false;
        this.iMU = false;
        this.iMW = false;
        this.iMX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ifk) {
                    DistributeVideoView.this.ifk.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iML || view == DistributeVideoView.this.iMK) {
                    DistributeVideoView.this.qu(DistributeVideoView.this.iMQ ? false : true);
                } else if (view == DistributeVideoView.this.iyo || view == DistributeVideoView.this.iMO) {
                    DistributeVideoView.this.ciN();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iMH == null || !DistributeVideoView.this.iMH.acI()) {
                    DistributeVideoView.this.ciN();
                } else {
                    DistributeVideoView.this.ag(2, 1, 0);
                    if (DistributeVideoView.this.iMH != null) {
                        WebVideoActivity.iFS = new WebVideoActivity.a();
                        WebVideoActivity.iFS.iGc = DistributeVideoView.this.iMH;
                        WebVideoActivity.iFS.azs = "DETAIL";
                        WebVideoActivity.iFS.mPageNum = DistributeVideoView.this.iMI;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aVY) ? DistributeVideoView.this.aVY : DistributeVideoView.this.iMH.bEV, true, true, true, DistributeVideoView.this.ifc.video_url, DistributeVideoView.this.ifc.thumbnail_url, DistributeVideoView.this.ifc.video_width.intValue() / DistributeVideoView.this.ifc.video_height.intValue(), DistributeVideoView.this.ifc.video_duration.intValue());
                    if (DistributeVideoView.this.iFY != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iFY.iGV);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iFY.iGW);
                    }
                    if (DistributeVideoView.this.iFZ != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iFZ.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.Ab(DistributeVideoView.this.parallelChargeInfo.heb);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.hee.iterator();
                        while (it.hasNext()) {
                            c.Ab(it.next());
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
                        if (DistributeVideoView.this.ifd != 1) {
                            if (DistributeVideoView.this.dnu.getCurrentPosition() > 0) {
                                DistributeVideoView.this.ifd = 1;
                                DistributeVideoView.this.ceY();
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
                        if (DistributeVideoView.this.ifd == 1) {
                            if (DistributeVideoView.this.ifm == DistributeVideoView.this.dnu.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.ifm = DistributeVideoView.this.dnu.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.cTq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iMV = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dgg = gVar;
                    DistributeVideoView.this.dgg.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iMQ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qu(false);
                    }
                }
            }
        };
        this.cTs = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iMH != null) {
                    if (DistributeVideoView.this.iMW && "DETAIL".equals(DistributeVideoView.this.iMH.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ag(i3, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), 0);
                }
                return false;
            }
        };
        this.cJS = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.ciM();
                DistributeVideoView.this.ag(36, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), gVar.getCurrentPosition());
                DistributeVideoView.this.gui.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.ifk.setVisibility(0);
                return true;
            }
        };
        this.cTp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iMR = System.currentTimeMillis();
                DistributeVideoView.this.iMW = true;
                DistributeVideoView.this.ag(34, DistributeVideoView.this.zP(DistributeVideoView.this.iMX), gVar.getDuration());
                DistributeVideoView.this.ciM();
                if (DistributeVideoView.this.iJp != null) {
                    DistributeVideoView.this.iJp.ciC();
                    DistributeVideoView.this.iMJ.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cJW = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ifs = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ifc != null && DistributeVideoView.this.dnu != null) {
                    DistributeVideoView.this.zO(1);
                }
            }
        };
        this.iMY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ciO();
            }
        };
        this.iMZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qw(false);
            }
        };
        this.iyT = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iMU) {
                            DistributeVideoView.this.qu(true);
                            return;
                        } else {
                            DistributeVideoView.this.qu(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iMU = DistributeVideoView.this.iMQ;
                    DistributeVideoView.this.qu(true);
                }
            }
        };
        this.fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qu(true);
                    }
                }
            }
        };
        this.iNa = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qw(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aVY = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iMS = adCard;
        if (this.iMS != null) {
            this.parallelChargeInfo = this.iMS.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dnu = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.iyo = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gui = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iMJ = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.ifk = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iMM = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iMK = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iMN = this.mRootView.findViewById(R.id.distribute_control);
            this.iMO = (ImageView) this.iMN.findViewById(R.id.distribute_play_icon);
            this.iML = (ImageView) this.iMN.findViewById(R.id.distribute_voice);
            this.iMP = (VideoControllerView) this.iMN.findViewById(R.id.distribute_process);
            this.iJn = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iJo = new d(context, this.iJn);
            this.iyo.setAnimation(R.raw.lotti_video_loading);
            this.iyo.setFrame(0);
        }
    }

    private boolean caf() {
        return this.mStyle == 1 ? q.caf() : j.kd();
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
        this.iFY = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.iFZ = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ifc = videoInfo;
        this.mDuration = this.ifc.video_duration.intValue() * 1000;
        this.bBD = new WeakReference<>(this.mContext.getApplicationContext());
        ciM();
        am.l(this, R.color.cp_bg_line_d);
        int af = l.af(this.mContext) - l.g(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.ifc.video_width.intValue() > 0 ? (this.ifc.video_height.intValue() * af) / this.ifc.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gui.setDefaultErrorResource(0);
        this.gui.setDefaultResource(0);
        this.gui.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gui.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dnu.setOnPreparedListener(this.cTq);
        this.dnu.setOnErrorListener(this.cJS);
        this.dnu.setOnCompletionListener(this.cTp);
        this.dnu.setOnOutInfoListener(this.cTs);
        this.dnu.setOnSurfaceDestroyedListener(this.cJW);
        am.j(this.iMJ, R.color.cp_cont_m);
        this.iMJ.setText(StringUtils.translateSecondsToString(this.ifc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iMQ = false;
            am.c(this.iMK, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iMK.setVisibility(8);
        } else {
            this.iMQ = true;
            am.c(this.iML, (int) R.drawable.ad_icon_sound_open);
            this.iMK.setVisibility(8);
        }
        this.iML.setOnClickListener(this.mOnClickListener);
        this.iMK.setOnClickListener(this.mOnClickListener);
        this.ifk.setOnClickListener(this.mOnClickListener);
        this.ifk.setVisibility(8);
        am.l(this.ifk, R.color.black_alpha80);
        am.j(this.iMM, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iMJ.setVisibility(0);
            return;
        }
        this.iMJ.setVisibility(8);
        this.iMO.setOnClickListener(this.mOnClickListener);
        this.iyo.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ifc = videoInfo;
        this.bBD = new WeakReference<>(this.mContext.getApplicationContext());
        ciM();
        am.l(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gui.setDefaultErrorResource(0);
        this.gui.setDefaultResource(0);
        this.gui.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gui.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dnu.setOnPreparedListener(this.cTq);
        this.dnu.setOnErrorListener(this.cJS);
        this.dnu.setOnCompletionListener(this.cTp);
        this.dnu.setOnOutInfoListener(this.cTs);
        this.dnu.setOnSurfaceDestroyedListener(this.cJW);
        am.j(this.iMJ, R.color.cp_cont_m);
        this.iMJ.setText(StringUtils.translateSecondsToString(this.ifc.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iMQ = false;
            am.c(this.iMK, (int) R.drawable.icon_vedio_npronunciation_small_white);
            this.iMK.setVisibility(8);
        } else {
            this.iMQ = true;
            am.c(this.iML, (int) R.drawable.ad_icon_sound_open);
            this.iMK.setVisibility(8);
        }
        this.iML.setOnClickListener(this.mOnClickListener);
        this.iMK.setOnClickListener(this.mOnClickListener);
        this.ifk.setOnClickListener(this.mOnClickListener);
        this.ifk.setVisibility(8);
        am.l(this.ifk, R.color.black_alpha80);
        am.j(this.iMM, R.color.cp_btn_a);
        if (this.mStyle == 1) {
            this.iMJ.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iMJ.setVisibility(8);
        this.iMO.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iJp = this.iJo.a(this.iFZ, this.iJp);
        if (this.iJp != null) {
            this.iJp.setPageContext(this.mPageContext);
            this.iJp.c(this.iMS);
            this.iJp.setAdvertAppInfo(advertAppInfo);
            this.iJp.a(this.iFZ);
            this.iJp.ciD();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iJp != null) {
            this.iJp.setDownloadAppCallback(cVar);
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
            n(this.mRootView, i2, i3);
            return true;
        }
        n(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void n(View view, int i, int i2) {
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
        this.cTp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(int i) {
        this.iMX = i;
        if (this.ifc != null && this.ifd == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iMR) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iJp != null) {
                    this.iJp.ciD();
                }
                this.dnu.setVideoPath(this.ifc.video_url);
                this.dnu.start();
                this.iMV = this.dnu.getCurrentPosition();
                am.c(this.iMO, (int) R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.ifk.setVisibility(8);
                this.gui.setForegroundDrawable(0);
                this.ifd = 0;
                if (this.mStyle == 1) {
                    this.iMJ.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iMJ.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iNa);
                MessageManager.getInstance().registerListener(this.iyT);
                MessageManager.getInstance().registerListener(this.fvr);
            }
        }
    }

    public void performPlay() {
        zO(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (caf()) {
            if (i <= 0) {
                zO(1);
                return;
            }
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ifs);
            com.baidu.adp.lib.g.e.iK().postDelayed(this.ifs, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.ifd == 1) {
            B(32, zP(this.iMX), this.dnu.getCurrentPosition(), i);
            this.dnu.pause();
            ad.a(this.bBD, false);
            setLoadingAnimShow(true);
            am.c(this.iMO, (int) R.drawable.icon_video_midpause);
            this.ifd = 2;
        }
    }

    public void autoContinue() {
        if (!this.iMT) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.ifd == 2) {
            this.iMX = i;
            ag(33, zP(i), this.dnu.getCurrentPosition());
            this.iMV = this.dnu.getCurrentPosition();
            this.dnu.start();
            if (this.iMQ) {
                ad.a(this.bBD, true);
            }
            setLoadingAnimShow(false);
            am.c(this.iMO, (int) R.drawable.icon_video_midplay);
            this.ifd = 1;
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
        if (this.iyo != null) {
            this.iyo.setAlpha(1.0f);
            this.iyo.setVisibility(0);
            this.iyo.y(true);
            this.iyo.setMinAndMaxFrame(14, 80);
            this.iyo.br();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        ciL();
        if (z) {
            this.iyo.setAlpha(1.0f);
            this.iyo.setVisibility(0);
            return;
        }
        this.iyo.setVisibility(8);
    }

    private void ciL() {
        if (this.iyo != null) {
            this.iyo.setFrame(0);
            this.iyo.cancelAnimation();
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
        if (this.dnu.getCurrentPosition() > 0 && this.ifd != -1 && z) {
            int i = 32;
            int currentPosition = this.dnu.getCurrentPosition();
            if (this.dnu.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, zP(this.iMX), currentPosition, this.dnu.isPlaying());
        }
        ciM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciM() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.ifs);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iMY);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iMZ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dnu.ceg();
        this.ifd = -1;
        ad.a(this.bBD, false);
        qw(false);
        this.gui.setForegroundDrawable(0);
        this.gui.setVisibility(0);
        setLoadingAnimShow(true);
        am.c(this.iMO, (int) R.drawable.icon_video_midpause);
        this.iMP.aDe();
        this.ifk.setVisibility(8);
        if (this.ifc != null) {
            this.iMJ.setText(StringUtils.translateSecondsToString(this.ifc.video_duration.intValue()));
            this.iMJ.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.dgg = null;
        this.iMU = false;
        MessageManager.getInstance().unRegisterListener(this.iNa);
        MessageManager.getInstance().unRegisterListener(this.iyT);
        MessageManager.getInstance().unRegisterListener(this.fvr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zP(int i) {
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
        return this.ifc != null ? this.ifc.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qu(boolean z) {
        if (z) {
            if (this.dgg != null) {
                this.dgg.setVolume(1.0f, 1.0f);
            }
            am.c(this.iML, (int) R.drawable.ad_icon_sound_open);
            am.c(this.iMK, (int) R.drawable.icon_vedio_pronunciation_small_white);
            if (this.ifd == 1) {
                ad.a(this.bBD, true);
            }
        } else {
            if (this.dgg != null) {
                this.dgg.setVolume(0.0f, 0.0f);
            }
            am.c(this.iML, (int) R.drawable.ad_icon_sound_close);
            am.c(this.iMK, (int) R.drawable.icon_vedio_npronunciation_small_white);
            ad.a(this.bBD, false);
        }
        this.iMQ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.ifd;
    }

    public VideoInfo getData() {
        return this.ifc;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.ifm;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iMH = advertAppInfo;
        this.iMI = i;
        this.azs = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iMH, 303, i, zP(this.iMX), this.ifc.video_duration.intValue(), this.mDuration, -1);
        if (this.iJp != null) {
            this.iJp.e(a);
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
        if (this.iMH != null && this.ifc != null) {
            this.iMH.page = this.azs;
            com.baidu.tieba.recapp.report.c.ciy().a(f.a(this.iMH, i, this.iMI, i2, this.ifc.video_duration.intValue(), a.mv(i3), i4));
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
                c(str, this.iMV, i3, this.mDuration, str2, zQ(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.iFY != null && "cpv".equals(this.iFY.iGV) && !TextUtils.isEmpty(this.iFY.iGW)) {
            new com.baidu.tieba.recapp.request.a(this.iFY.iGW).a(str, i, i2, i3, str2, str3);
        }
    }

    private String zQ(int i) {
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
            this.iMF = view;
            this.iMG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iMY);
            if (this.afH != null) {
                this.afH.cancel();
            }
            this.iMN.setVisibility(0);
            if (this.ifd == 1) {
                am.c(this.iMO, (int) R.drawable.icon_video_midplay);
                return;
            } else {
                am.c(this.iMO, (int) R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iMN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciN() {
        switch (this.ifd) {
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
                    aVar.b(this.mPageContext).agI();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.iMT = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qv(true);
                    return;
                }
                return;
            case 2:
                this.iMT = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iMY);
                    com.baidu.adp.lib.g.e.iK().postDelayed(this.iMY, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciO() {
        if (!this.boU && this.afH != null) {
            this.iMN.startAnimation(this.afH);
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
                    DistributeVideoView.this.iMN.setVisibility(8);
                    DistributeVideoView.this.boU = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void ciP() {
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.iMZ);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.iMZ, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qw(boolean z) {
        if (this.iMK != null && this.mStyle == 1) {
            if (z) {
                this.iMK.setVisibility(0);
                ciP();
                return;
            }
            this.iMK.setVisibility(8);
        }
    }
}
