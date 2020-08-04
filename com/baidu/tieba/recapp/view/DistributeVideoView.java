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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.lego.card.b.b;
import com.baidu.tieba.lego.card.b.c;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivity;
import com.baidu.tieba.recapp.activity.newstyle.NewWebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.h;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.g;
import com.baidu.tieba.tbadkCore.t;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes20.dex */
public class DistributeVideoView extends RelativeLayout implements h {
    private WeakReference<Context> ajF;
    private Animation but;
    private CyberPlayerManager.OnInfoListener dCA;
    private CyberPlayerManager.OnPreparedListener dCx;
    private CyberPlayerManager.OnErrorListener dCy;
    private CyberPlayerManager.OnCompletionListener dCz;
    boolean drM;
    private TbCyberVideoView.a eRD;
    private TbCyberVideoView fsr;
    private CustomMessageListener hHn;
    private ForeDrawableImageView iLV;
    private CustomMessageListener leS;
    private AdCard.a llY;
    private AdCard.f llZ;
    private ViewGroup lpp;
    private d lpq;
    private e lpr;
    private boolean lrF;
    private View lsF;
    private boolean lsG;
    private VideoInfo lsH;
    private AdvertAppInfo lsI;
    private int lsJ;
    private TBLottieAnimationView lsK;
    private TextView lsL;
    private ImageView lsM;
    private ImageView lsN;
    private View lsO;
    private TextView lsP;
    private View lsQ;
    private ImageView lsR;
    private VideoControllerView lsS;
    private int lsT;
    private long lsU;
    private boolean lsV;
    private long lsW;
    private b lsX;
    boolean lsY;
    private boolean lsZ;
    private int lta;
    boolean ltb;
    private int ltc;
    private Runnable ltd;
    private Runnable lte;
    private Runnable ltf;
    private CustomMessageListener ltg;
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
        if (this.lsI != null) {
            WebVideoActivity.llQ = new WebVideoActivity.a();
            WebVideoActivity.llQ.lmc = this.lsI;
            WebVideoActivity.llQ.mPage = "DETAIL";
            WebVideoActivity.llQ.mPageNum = this.lsJ;
            NewWebVideoActivity.lmd = new NewWebVideoActivity.a();
            NewWebVideoActivity.lmd.lmc = this.lsI;
            NewWebVideoActivity.lmd.mPage = "DETAIL";
            NewWebVideoActivity.lmd.mPageNum = this.lsJ;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.lsI.dMY, true, true, true, this.lsH.video_url, this.lsH.thumbnail_url, this.lsH.video_width.intValue() / this.lsH.video_height.intValue(), this.lsH.video_duration.intValue(), this.lsI.dMW);
        if (this.llY != null) {
            newWebVideoActivityConfig.setChargeStyle(this.llY.lna);
            newWebVideoActivityConfig.setChargeUrl(this.llY.lnb);
        }
        if (this.llZ != null) {
            newWebVideoActivityConfig.setTailFrame(this.llZ.toJsonString());
        }
        if (this.lsX instanceof AdCard) {
            newWebVideoActivityConfig.setGoodStyle(((AdCard) this.lsX).goodsStyle);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czx() {
        Z(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.IO(this.parallelChargeInfo.jyW);
            Iterator<String> it = this.parallelChargeInfo.jyZ.iterator();
            while (it.hasNext()) {
                c.IO(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZy() {
        if (this.lsK != null) {
            this.lsK.clearAnimation();
            this.lsK.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.lsK.setVisibility(8);
                    DistributeVideoView.this.iLV.setVisibility(8);
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsV);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.lsL.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.lsS.setPlayer(DistributeVideoView.this.fsr);
                        DistributeVideoView.this.lsS.bq(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.lsH.video_duration.intValue()));
                        DistributeVideoView.this.lsS.showProgress();
                        DistributeVideoView.this.uE(true);
                        com.baidu.adp.lib.f.e.lt().removeCallbacks(DistributeVideoView.this.lte);
                        com.baidu.adp.lib.f.e.lt().postDelayed(DistributeVideoView.this.lte, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.lsU = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.uF(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.lsK.setMinFrame(0);
                    DistributeVideoView.this.lsK.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.lsG = false;
        this.ajF = null;
        this.lsT = -1;
        this.lsU = 0L;
        this.lsV = false;
        this.lsW = 0L;
        this.mStyle = 1;
        this.drM = false;
        this.lsY = false;
        this.lsZ = false;
        this.ltb = false;
        this.ltc = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lsO) {
                    DistributeVideoView.this.lsO.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lsN || view == DistributeVideoView.this.lsM) {
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsV ? false : true);
                } else if (view == DistributeVideoView.this.lsK || view == DistributeVideoView.this.lsR) {
                    DistributeVideoView.this.ddp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.lsI == null || !DistributeVideoView.this.lsI.aUg()) {
                    if (DistributeVideoView.this.lsX instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.lsX;
                        if (!adCard.getAdvertAppInfo().aUf() || adCard.directDownload) {
                            DistributeVideoView.this.ddp();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.czx();
                        return;
                    }
                    DistributeVideoView.this.ddp();
                } else {
                    if (DistributeVideoView.this.lsI != null) {
                        WebVideoActivity.llQ = new WebVideoActivity.a();
                        WebVideoActivity.llQ.lmc = DistributeVideoView.this.lsI;
                        WebVideoActivity.llQ.mPage = "DETAIL";
                        WebVideoActivity.llQ.mPageNum = DistributeVideoView.this.lsJ;
                        NewWebVideoActivity.lmd = new NewWebVideoActivity.a();
                        NewWebVideoActivity.lmd.lmc = DistributeVideoView.this.lsI;
                        NewWebVideoActivity.lmd.mPage = "DETAIL";
                        NewWebVideoActivity.lmd.mPageNum = DistributeVideoView.this.lsJ;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.lsI.dMY;
                    if (a.bqh().bqi() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsH.video_url, DistributeVideoView.this.lsH.thumbnail_url, DistributeVideoView.this.lsH.video_width.intValue() / DistributeVideoView.this.lsH.video_height.intValue(), DistributeVideoView.this.lsH.video_duration.intValue(), DistributeVideoView.this.lsI.dMW);
                        if (DistributeVideoView.this.llY != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llY.lna);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llY.lnb);
                        }
                        if (DistributeVideoView.this.llZ != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.llZ.toJsonString());
                        }
                        if (DistributeVideoView.this.lsX instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsX).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsH.video_url, DistributeVideoView.this.lsH.thumbnail_url, DistributeVideoView.this.lsH.video_width.intValue() / DistributeVideoView.this.lsH.video_height.intValue(), DistributeVideoView.this.lsH.video_duration.intValue());
                        if (DistributeVideoView.this.llY != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llY.lna);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llY.lnb);
                        }
                        if (DistributeVideoView.this.llZ != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.llZ.toJsonString());
                        }
                        if (DistributeVideoView.this.lsX instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsX).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.czx();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lsT != 1) {
                            if (DistributeVideoView.this.fsr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lsT = 1;
                                DistributeVideoView.this.cZy();
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
                        if (DistributeVideoView.this.lsT == 1) {
                            if (DistributeVideoView.this.lsU == DistributeVideoView.this.fsr.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.lsU = DistributeVideoView.this.fsr.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.lta = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fsr.getDuration();
                    DistributeVideoView.this.fsr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lsV && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.uD(false);
                    }
                }
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lsI != null) {
                    if (DistributeVideoView.this.ltb && "DETAIL".equals(DistributeVideoView.this.lsI.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), 0);
                }
                return false;
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(36, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), DistributeVideoView.this.fsr.getCurrentPosition());
                }
                DistributeVideoView.this.iLV.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lsO.setVisibility(0);
                return true;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lsW = System.currentTimeMillis();
                DistributeVideoView.this.ltb = true;
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(34, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), DistributeVideoView.this.fsr.getDuration());
                }
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.lpr != null) {
                    DistributeVideoView.this.lpr.ddf();
                    DistributeVideoView.this.lsL.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ltd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lsH != null && DistributeVideoView.this.fsr != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ea(1);
                }
            }
        };
        this.lte = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ddq();
            }
        };
        this.ltf = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.uF(false);
            }
        };
        this.leS = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lsZ) {
                            DistributeVideoView.this.uD(true);
                            return;
                        } else {
                            DistributeVideoView.this.uD(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lsZ = DistributeVideoView.this.lsV;
                    DistributeVideoView.this.uD(true);
                }
            }
        };
        this.hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.uD(true);
                    }
                }
            }
        };
        this.ltg = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.uF(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lsG = false;
        this.ajF = null;
        this.lsT = -1;
        this.lsU = 0L;
        this.lsV = false;
        this.lsW = 0L;
        this.mStyle = 1;
        this.drM = false;
        this.lsY = false;
        this.lsZ = false;
        this.ltb = false;
        this.ltc = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lsO) {
                    DistributeVideoView.this.lsO.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lsN || view == DistributeVideoView.this.lsM) {
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsV ? false : true);
                } else if (view == DistributeVideoView.this.lsK || view == DistributeVideoView.this.lsR) {
                    DistributeVideoView.this.ddp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.lsI == null || !DistributeVideoView.this.lsI.aUg()) {
                    if (DistributeVideoView.this.lsX instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.lsX;
                        if (!adCard.getAdvertAppInfo().aUf() || adCard.directDownload) {
                            DistributeVideoView.this.ddp();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.czx();
                        return;
                    }
                    DistributeVideoView.this.ddp();
                } else {
                    if (DistributeVideoView.this.lsI != null) {
                        WebVideoActivity.llQ = new WebVideoActivity.a();
                        WebVideoActivity.llQ.lmc = DistributeVideoView.this.lsI;
                        WebVideoActivity.llQ.mPage = "DETAIL";
                        WebVideoActivity.llQ.mPageNum = DistributeVideoView.this.lsJ;
                        NewWebVideoActivity.lmd = new NewWebVideoActivity.a();
                        NewWebVideoActivity.lmd.lmc = DistributeVideoView.this.lsI;
                        NewWebVideoActivity.lmd.mPage = "DETAIL";
                        NewWebVideoActivity.lmd.mPageNum = DistributeVideoView.this.lsJ;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.lsI.dMY;
                    if (a.bqh().bqi() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsH.video_url, DistributeVideoView.this.lsH.thumbnail_url, DistributeVideoView.this.lsH.video_width.intValue() / DistributeVideoView.this.lsH.video_height.intValue(), DistributeVideoView.this.lsH.video_duration.intValue(), DistributeVideoView.this.lsI.dMW);
                        if (DistributeVideoView.this.llY != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llY.lna);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llY.lnb);
                        }
                        if (DistributeVideoView.this.llZ != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.llZ.toJsonString());
                        }
                        if (DistributeVideoView.this.lsX instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsX).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsH.video_url, DistributeVideoView.this.lsH.thumbnail_url, DistributeVideoView.this.lsH.video_width.intValue() / DistributeVideoView.this.lsH.video_height.intValue(), DistributeVideoView.this.lsH.video_duration.intValue());
                        if (DistributeVideoView.this.llY != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llY.lna);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llY.lnb);
                        }
                        if (DistributeVideoView.this.llZ != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.llZ.toJsonString());
                        }
                        if (DistributeVideoView.this.lsX instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsX).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.czx();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lsT != 1) {
                            if (DistributeVideoView.this.fsr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lsT = 1;
                                DistributeVideoView.this.cZy();
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
                        if (DistributeVideoView.this.lsT == 1) {
                            if (DistributeVideoView.this.lsU == DistributeVideoView.this.fsr.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.lsU = DistributeVideoView.this.fsr.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.lta = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fsr.getDuration();
                    DistributeVideoView.this.fsr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lsV && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.uD(false);
                    }
                }
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lsI != null) {
                    if (DistributeVideoView.this.ltb && "DETAIL".equals(DistributeVideoView.this.lsI.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), 0);
                }
                return false;
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(36, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), DistributeVideoView.this.fsr.getCurrentPosition());
                }
                DistributeVideoView.this.iLV.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lsO.setVisibility(0);
                return true;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lsW = System.currentTimeMillis();
                DistributeVideoView.this.ltb = true;
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(34, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), DistributeVideoView.this.fsr.getDuration());
                }
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.lpr != null) {
                    DistributeVideoView.this.lpr.ddf();
                    DistributeVideoView.this.lsL.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ltd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lsH != null && DistributeVideoView.this.fsr != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ea(1);
                }
            }
        };
        this.lte = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ddq();
            }
        };
        this.ltf = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.uF(false);
            }
        };
        this.leS = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lsZ) {
                            DistributeVideoView.this.uD(true);
                            return;
                        } else {
                            DistributeVideoView.this.uD(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lsZ = DistributeVideoView.this.lsV;
                    DistributeVideoView.this.uD(true);
                }
            }
        };
        this.hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.uD(true);
                    }
                }
            }
        };
        this.ltg = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.uF(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lsG = false;
        this.ajF = null;
        this.lsT = -1;
        this.lsU = 0L;
        this.lsV = false;
        this.lsW = 0L;
        this.mStyle = 1;
        this.drM = false;
        this.lsY = false;
        this.lsZ = false;
        this.ltb = false;
        this.ltc = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lsO) {
                    DistributeVideoView.this.lsO.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lsN || view == DistributeVideoView.this.lsM) {
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsV ? false : true);
                } else if (view == DistributeVideoView.this.lsK || view == DistributeVideoView.this.lsR) {
                    DistributeVideoView.this.ddp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.lsI == null || !DistributeVideoView.this.lsI.aUg()) {
                    if (DistributeVideoView.this.lsX instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.lsX;
                        if (!adCard.getAdvertAppInfo().aUf() || adCard.directDownload) {
                            DistributeVideoView.this.ddp();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.czx();
                        return;
                    }
                    DistributeVideoView.this.ddp();
                } else {
                    if (DistributeVideoView.this.lsI != null) {
                        WebVideoActivity.llQ = new WebVideoActivity.a();
                        WebVideoActivity.llQ.lmc = DistributeVideoView.this.lsI;
                        WebVideoActivity.llQ.mPage = "DETAIL";
                        WebVideoActivity.llQ.mPageNum = DistributeVideoView.this.lsJ;
                        NewWebVideoActivity.lmd = new NewWebVideoActivity.a();
                        NewWebVideoActivity.lmd.lmc = DistributeVideoView.this.lsI;
                        NewWebVideoActivity.lmd.mPage = "DETAIL";
                        NewWebVideoActivity.lmd.mPageNum = DistributeVideoView.this.lsJ;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.lsI.dMY;
                    if (a.bqh().bqi() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsH.video_url, DistributeVideoView.this.lsH.thumbnail_url, DistributeVideoView.this.lsH.video_width.intValue() / DistributeVideoView.this.lsH.video_height.intValue(), DistributeVideoView.this.lsH.video_duration.intValue(), DistributeVideoView.this.lsI.dMW);
                        if (DistributeVideoView.this.llY != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llY.lna);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llY.lnb);
                        }
                        if (DistributeVideoView.this.llZ != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.llZ.toJsonString());
                        }
                        if (DistributeVideoView.this.lsX instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsX).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsH.video_url, DistributeVideoView.this.lsH.thumbnail_url, DistributeVideoView.this.lsH.video_width.intValue() / DistributeVideoView.this.lsH.video_height.intValue(), DistributeVideoView.this.lsH.video_duration.intValue());
                        if (DistributeVideoView.this.llY != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llY.lna);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llY.lnb);
                        }
                        if (DistributeVideoView.this.llZ != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.llZ.toJsonString());
                        }
                        if (DistributeVideoView.this.lsX instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsX).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.czx();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.lsT != 1) {
                            if (DistributeVideoView.this.fsr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lsT = 1;
                                DistributeVideoView.this.cZy();
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
                        if (DistributeVideoView.this.lsT == 1) {
                            if (DistributeVideoView.this.lsU == DistributeVideoView.this.fsr.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.lsU = DistributeVideoView.this.fsr.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dCx = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.lta = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fsr.getDuration();
                    DistributeVideoView.this.fsr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lsV && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.uD(false);
                    }
                }
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.lsI != null) {
                    if (DistributeVideoView.this.ltb && "DETAIL".equals(DistributeVideoView.this.lsI.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), 0);
                }
                return false;
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(36, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), DistributeVideoView.this.fsr.getCurrentPosition());
                }
                DistributeVideoView.this.iLV.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lsO.setVisibility(0);
                return true;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lsW = System.currentTimeMillis();
                DistributeVideoView.this.ltb = true;
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(34, DistributeVideoView.this.Eb(DistributeVideoView.this.ltc), DistributeVideoView.this.fsr.getDuration());
                }
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.lpr != null) {
                    DistributeVideoView.this.lpr.ddf();
                    DistributeVideoView.this.lsL.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.eRD = new TbCyberVideoView.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ltd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lsH != null && DistributeVideoView.this.fsr != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ea(1);
                }
            }
        };
        this.lte = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ddq();
            }
        };
        this.ltf = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.uF(false);
            }
        };
        this.leS = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lsZ) {
                            DistributeVideoView.this.uD(true);
                            return;
                        } else {
                            DistributeVideoView.this.uD(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lsZ = DistributeVideoView.this.lsV;
                    DistributeVideoView.this.uD(true);
                }
            }
        };
        this.hHn = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.uD(true);
                    }
                }
            }
        };
        this.ltg = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.uF(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.lsX = adCard;
        if (this.lsX != null) {
            this.parallelChargeInfo = this.lsX.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fsr = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.fsr.setNoBussinessStats();
            this.lsK = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.iLV = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.lsL = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.lsO = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.lsP = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.lsM = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.lsQ = this.mRootView.findViewById(R.id.distribute_control);
            this.lsR = (ImageView) this.lsQ.findViewById(R.id.distribute_play_icon);
            this.lsN = (ImageView) this.lsQ.findViewById(R.id.distribute_voice);
            this.lsS = (VideoControllerView) this.lsQ.findViewById(R.id.distribute_process);
            this.lpp = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.lpq = new d(context, this.lpp);
            this.lsK.setAnimation(R.raw.lotti_video_loading);
            this.lsK.setMinFrame(0);
            this.lsK.setFrame(0);
            com.baidu.tbadk.a.b.a.h(this.mMaskView, R.drawable.video_mask_bg);
        }
    }

    private boolean ddm() {
        return this.mStyle == 1 ? t.ddm() : j.isWifiNet();
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
        this.llY = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.llZ = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lsH = videoInfo;
        this.mDuration = this.lsH.video_duration.intValue() * 1000;
        this.ajF = new WeakReference<>(this.mContext.getApplicationContext());
        ddo();
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.lsH.video_width.intValue() > 0 ? (this.lsH.video_height.intValue() * equipmentWidth) / this.lsH.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.iLV.setDefaultErrorResource(0);
        this.iLV.setDefaultResource(0);
        this.iLV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!as.isEmpty(videoInfo.thumbnail_url)) {
            this.iLV.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnErrorListener(this.dCy);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnInfoListener(this.dCA);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        ao.setViewTextColor(this.lsL, R.color.cp_cont_m);
        this.lsL.setText(StringUtils.translateSecondsToString(this.lsH.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lsV = false;
            ao.setImageResource(this.lsM, R.drawable.icon_vedio_npronunciation_small_white);
            this.lsM.setVisibility(8);
        } else {
            this.lsV = true;
            ao.setImageResource(this.lsN, R.drawable.ad_icon_sound_open);
            this.lsM.setVisibility(8);
        }
        this.lsN.setOnClickListener(this.mOnClickListener);
        this.lsM.setOnClickListener(this.mOnClickListener);
        this.lsO.setOnClickListener(this.mOnClickListener);
        this.lsO.setVisibility(8);
        ao.setBackgroundColor(this.lsO, R.color.black_alpha80);
        ao.setViewTextColor(this.lsP, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.lsL.setVisibility(0);
            return;
        }
        this.lsL.setVisibility(8);
        this.lsR.setOnClickListener(this.mOnClickListener);
        this.lsK.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lsH = videoInfo;
        this.ajF = new WeakReference<>(this.mContext.getApplicationContext());
        ddo();
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.iLV.setDefaultErrorResource(0);
        this.iLV.setDefaultResource(0);
        this.iLV.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!as.isEmpty(videoInfo.thumbnail_url)) {
            this.iLV.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnErrorListener(this.dCy);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnInfoListener(this.dCA);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        ao.setViewTextColor(this.lsL, R.color.cp_cont_m);
        this.lsL.setText(StringUtils.translateSecondsToString(this.lsH.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lsV = false;
            ao.setImageResource(this.lsM, R.drawable.icon_vedio_npronunciation_small_white);
            this.lsM.setVisibility(8);
        } else {
            this.lsV = true;
            ao.setImageResource(this.lsN, R.drawable.ad_icon_sound_open);
            this.lsM.setVisibility(8);
        }
        this.lsN.setOnClickListener(this.mOnClickListener);
        this.lsM.setOnClickListener(this.mOnClickListener);
        this.lsO.setOnClickListener(this.mOnClickListener);
        this.lsO.setVisibility(8);
        ao.setBackgroundColor(this.lsO, R.color.black_alpha80);
        ao.setViewTextColor(this.lsP, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.lsL.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.lsL.setVisibility(8);
        this.lsR.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.lsI;
        }
        this.lpr = this.lpq.a(this.llZ, this.lpr);
        if (this.lpr != null) {
            this.lpr.setPageContext(this.mPageContext);
            this.lpr.c(this.lsX);
            if (this.lpr instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.lpr).uB(this.lrF);
            }
            this.lpr.setAdvertAppInfo(advertAppInfo);
            this.lpr.a(this.llZ);
            this.lpr.ddg();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.lrF = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.lpr != null) {
            this.lpr.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int intValue = videoInfo.video_height.intValue();
        int intValue2 = videoInfo.video_width.intValue();
        if (i <= 0 || intValue <= 0 || intValue2 <= 0) {
            setViewSize(this.mRootView, i2, i3);
            return true;
        }
        setViewSize(this.mRootView, (intValue * i) / intValue2, i);
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

    public void setOnCompleteListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.dCz = onCompletionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea(int i) {
        this.ltc = i;
        if (this.lsH != null && this.lsT == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.lsW) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.lpr != null) {
                    this.lpr.ddg();
                }
                this.fsr.setVideoPath(this.lsH.video_url);
                this.fsr.start();
                this.lta = this.fsr.getCurrentPosition();
                ao.setImageResource(this.lsR, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.lsO.setVisibility(8);
                this.iLV.setForegroundDrawable(0);
                this.lsT = 0;
                if (this.mStyle == 1) {
                    this.lsL.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.lsL.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.ltg);
                MessageManager.getInstance().registerListener(this.leS);
                MessageManager.getInstance().registerListener(this.hHn);
            }
        }
    }

    public void performPlay() {
        Ea(2);
    }

    @Override // com.baidu.tieba.recapp.h
    public void autoPlay(int i) {
        if (ddm()) {
            if (i <= 0) {
                Ea(1);
                return;
            }
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltd);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ltd, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.lsT == 1) {
            F(32, Eb(this.ltc), this.fsr.getCurrentPosition(), i);
            this.fsr.pause();
            ag.a(this.ajF, false);
            setLoadingAnimShow(true);
            ao.setImageResource(this.lsR, R.drawable.icon_video_midpause);
            this.lsT = 2;
        }
    }

    public void autoContinue() {
        if (!this.lsY) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.lsT == 2) {
            this.ltc = i;
            Z(33, Eb(i), this.fsr.getCurrentPosition());
            this.lta = this.fsr.getCurrentPosition();
            this.fsr.start();
            if (this.lsV) {
                ag.a(this.ajF, true);
            }
            setLoadingAnimShow(false);
            ao.setImageResource(this.lsR, R.drawable.icon_video_midplay);
            this.lsT = 1;
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
        if (this.lsK != null) {
            this.lsK.setAlpha(1.0f);
            this.lsK.setVisibility(0);
            this.lsK.loop(true);
            this.lsK.setMinAndMaxFrame(14, 80);
            this.lsK.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        ddn();
        if (z) {
            this.lsK.setAlpha(1.0f);
            this.lsK.setVisibility(0);
            return;
        }
        this.lsK.setVisibility(8);
    }

    private void ddn() {
        if (this.lsK != null) {
            this.lsK.setMinFrame(0);
            this.lsK.setFrame(0);
            this.lsK.cancelAnimation();
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
        if (this.fsr.getCurrentPosition() > 0 && this.lsT != -1 && z) {
            int i = 32;
            int currentPosition = this.fsr.getCurrentPosition();
            if (this.fsr.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Eb(this.ltc), currentPosition, this.fsr.isPlaying());
        }
        ddo();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsr.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lpp.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iLV.getLayoutParams();
        if (z) {
            int equipmentWidth = l.getEquipmentWidth(getContext());
            int bA = com.baidu.c.a.e.a.bA(equipmentWidth);
            layoutParams.width = l.getEquipmentWidth(getContext());
            layoutParams.height = equipmentWidth;
            layoutParams2.width = bA;
            layoutParams2.height = equipmentWidth;
            layoutParams3.width = bA;
            layoutParams3.height = equipmentWidth;
            layoutParams4.width = bA;
            layoutParams4.height = equipmentWidth;
            ao.setBackgroundColor(this, R.color.black_alpha100);
        } else {
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams3.width = -1;
            layoutParams3.height = -1;
            layoutParams4.width = -1;
            layoutParams4.height = -1;
        }
        this.fsr.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddo() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltd);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lte);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltf);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fsr.stopPlayback();
        this.lsT = -1;
        ag.a(this.ajF, false);
        uF(false);
        this.iLV.setForegroundDrawable(0);
        this.iLV.setVisibility(0);
        setLoadingAnimShow(true);
        ao.setImageResource(this.lsR, R.drawable.icon_video_midpause);
        this.lsS.azZ();
        this.lsO.setVisibility(8);
        if (this.lsH != null) {
            this.lsL.setText(StringUtils.translateSecondsToString(this.lsH.video_duration.intValue()));
            this.lsL.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.lsZ = false;
        MessageManager.getInstance().unRegisterListener(this.ltg);
        MessageManager.getInstance().unRegisterListener(this.leS);
        MessageManager.getInstance().unRegisterListener(this.hHn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Eb(int i) {
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
        return this.lsH != null ? this.lsH.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.lpr instanceof com.baidu.tieba.recapp.e.a) && (this.lsX instanceof AdCard) && !((AdCard) this.lsX).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lpr).bsb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.lpr instanceof com.baidu.tieba.recapp.e.a) && (this.lsX instanceof AdCard) && !((AdCard) this.lsX).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lpr).dde();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(boolean z) {
        if (z) {
            if (this.fsr != null) {
                this.fsr.setVolume(1.0f, 1.0f);
            }
            ao.setImageResource(this.lsN, R.drawable.ad_icon_sound_open);
            ao.setImageResource(this.lsM, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.lsT == 1) {
                ag.a(this.ajF, true);
            }
        } else {
            if (this.fsr != null) {
                this.fsr.setVolume(0.0f, 0.0f);
            }
            ao.setImageResource(this.lsN, R.drawable.ad_icon_sound_close);
            ao.setImageResource(this.lsM, R.drawable.icon_vedio_npronunciation_small_white);
            ag.a(this.ajF, false);
        }
        this.lsV = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.lsT;
    }

    public VideoInfo getData() {
        return this.lsH;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.lsU;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.lsI = advertAppInfo;
        this.lsJ = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = g.a(this.lsI, 303, i, Eb(this.ltc), this.lsH.video_duration.intValue(), this.mDuration, -1);
        if (this.lpr != null) {
            this.lpr.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, int i2, int i3) {
        F(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void F(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.lsI != null && this.lsH != null) {
            this.lsI.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lsI, i, this.lsJ, i2, this.lsH.video_duration.intValue(), com.baidu.tieba.ad.a.a.pT(i3), i4));
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
                c(str, this.lta, i3, this.mDuration, str2, Ec(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.llY != null && "cpv".equals(this.llY.lna) && !TextUtils.isEmpty(this.llY.lnb)) {
            new com.baidu.tieba.recapp.request.a(this.llY.lnb).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Ec(int i) {
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
            this.lsF = view;
            this.lsG = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lte);
            if (this.but != null) {
                this.but.cancel();
            }
            this.lsQ.setVisibility(0);
            if (this.lsT == 1) {
                ao.setImageResource(this.lsR, R.drawable.icon_video_midplay);
                return;
            } else {
                ao.setImageResource(this.lsR, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.lsQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddp() {
        switch (this.lsT) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast(R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.ln(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aYL();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.lsY = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    uE(true);
                    return;
                }
                return;
            case 2:
                this.lsY = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.lte);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.lte, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddq() {
        if (!this.drM && this.but != null) {
            this.lsQ.startAnimation(this.but);
            this.drM = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.but = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.but.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.lsQ.setVisibility(8);
                    DistributeVideoView.this.drM = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void ddr() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltf);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.ltf, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(boolean z) {
        if (this.lsM != null && this.mStyle == 1) {
            if (z) {
                this.lsM.setVisibility(0);
                ddr();
                return;
            }
            this.lsM.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
