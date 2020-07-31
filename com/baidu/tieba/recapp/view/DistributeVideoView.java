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
    private ForeDrawableImageView iLT;
    private CustomMessageListener leQ;
    private AdCard.a llW;
    private AdCard.f llX;
    private ViewGroup lpn;
    private d lpo;
    private e lpp;
    private boolean lrD;
    private View lsD;
    private boolean lsE;
    private VideoInfo lsF;
    private AdvertAppInfo lsG;
    private int lsH;
    private TBLottieAnimationView lsI;
    private TextView lsJ;
    private ImageView lsK;
    private ImageView lsL;
    private View lsM;
    private TextView lsN;
    private View lsO;
    private ImageView lsP;
    private VideoControllerView lsQ;
    private int lsR;
    private long lsS;
    private boolean lsT;
    private long lsU;
    private b lsV;
    boolean lsW;
    private boolean lsX;
    private int lsY;
    boolean lsZ;
    private int lta;
    private Runnable ltb;
    private Runnable ltc;
    private Runnable ltd;
    private CustomMessageListener lte;
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
        if (this.lsG != null) {
            WebVideoActivity.llO = new WebVideoActivity.a();
            WebVideoActivity.llO.lma = this.lsG;
            WebVideoActivity.llO.mPage = "DETAIL";
            WebVideoActivity.llO.mPageNum = this.lsH;
            NewWebVideoActivity.lmb = new NewWebVideoActivity.a();
            NewWebVideoActivity.lmb.lma = this.lsG;
            NewWebVideoActivity.lmb.mPage = "DETAIL";
            NewWebVideoActivity.lmb.mPageNum = this.lsH;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.lsG.dMY, true, true, true, this.lsF.video_url, this.lsF.thumbnail_url, this.lsF.video_width.intValue() / this.lsF.video_height.intValue(), this.lsF.video_duration.intValue(), this.lsG.dMW);
        if (this.llW != null) {
            newWebVideoActivityConfig.setChargeStyle(this.llW.lmY);
            newWebVideoActivityConfig.setChargeUrl(this.llW.lmZ);
        }
        if (this.llX != null) {
            newWebVideoActivityConfig.setTailFrame(this.llX.toJsonString());
        }
        if (this.lsV instanceof AdCard) {
            newWebVideoActivityConfig.setGoodStyle(((AdCard) this.lsV).goodsStyle);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czx() {
        Z(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.IO(this.parallelChargeInfo.jyU);
            Iterator<String> it = this.parallelChargeInfo.jyX.iterator();
            while (it.hasNext()) {
                c.IO(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZy() {
        if (this.lsI != null) {
            this.lsI.clearAnimation();
            this.lsI.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.lsI.setVisibility(8);
                    DistributeVideoView.this.iLT.setVisibility(8);
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsT);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.lsJ.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.lsQ.setPlayer(DistributeVideoView.this.fsr);
                        DistributeVideoView.this.lsQ.bq(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.lsF.video_duration.intValue()));
                        DistributeVideoView.this.lsQ.showProgress();
                        DistributeVideoView.this.uE(true);
                        com.baidu.adp.lib.f.e.lt().removeCallbacks(DistributeVideoView.this.ltc);
                        com.baidu.adp.lib.f.e.lt().postDelayed(DistributeVideoView.this.ltc, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.lsS = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.uF(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.lsI.setMinFrame(0);
                    DistributeVideoView.this.lsI.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.lsE = false;
        this.ajF = null;
        this.lsR = -1;
        this.lsS = 0L;
        this.lsT = false;
        this.lsU = 0L;
        this.mStyle = 1;
        this.drM = false;
        this.lsW = false;
        this.lsX = false;
        this.lsZ = false;
        this.lta = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lsM) {
                    DistributeVideoView.this.lsM.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lsL || view == DistributeVideoView.this.lsK) {
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsT ? false : true);
                } else if (view == DistributeVideoView.this.lsI || view == DistributeVideoView.this.lsP) {
                    DistributeVideoView.this.ddp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.lsG == null || !DistributeVideoView.this.lsG.aUg()) {
                    if (DistributeVideoView.this.lsV instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.lsV;
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
                    if (DistributeVideoView.this.lsG != null) {
                        WebVideoActivity.llO = new WebVideoActivity.a();
                        WebVideoActivity.llO.lma = DistributeVideoView.this.lsG;
                        WebVideoActivity.llO.mPage = "DETAIL";
                        WebVideoActivity.llO.mPageNum = DistributeVideoView.this.lsH;
                        NewWebVideoActivity.lmb = new NewWebVideoActivity.a();
                        NewWebVideoActivity.lmb.lma = DistributeVideoView.this.lsG;
                        NewWebVideoActivity.lmb.mPage = "DETAIL";
                        NewWebVideoActivity.lmb.mPageNum = DistributeVideoView.this.lsH;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.lsG.dMY;
                    if (a.bqh().bqi() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsF.video_url, DistributeVideoView.this.lsF.thumbnail_url, DistributeVideoView.this.lsF.video_width.intValue() / DistributeVideoView.this.lsF.video_height.intValue(), DistributeVideoView.this.lsF.video_duration.intValue(), DistributeVideoView.this.lsG.dMW);
                        if (DistributeVideoView.this.llW != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llW.lmY);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llW.lmZ);
                        }
                        if (DistributeVideoView.this.llX != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.llX.toJsonString());
                        }
                        if (DistributeVideoView.this.lsV instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsV).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsF.video_url, DistributeVideoView.this.lsF.thumbnail_url, DistributeVideoView.this.lsF.video_width.intValue() / DistributeVideoView.this.lsF.video_height.intValue(), DistributeVideoView.this.lsF.video_duration.intValue());
                        if (DistributeVideoView.this.llW != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llW.lmY);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llW.lmZ);
                        }
                        if (DistributeVideoView.this.llX != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.llX.toJsonString());
                        }
                        if (DistributeVideoView.this.lsV instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsV).goodsStyle);
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
                        if (DistributeVideoView.this.lsR != 1) {
                            if (DistributeVideoView.this.fsr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lsR = 1;
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
                        if (DistributeVideoView.this.lsR == 1) {
                            if (DistributeVideoView.this.lsS == DistributeVideoView.this.fsr.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.lsS = DistributeVideoView.this.fsr.getCurrentPosition();
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
                    DistributeVideoView.this.lsY = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fsr.getDuration();
                    DistributeVideoView.this.fsr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lsT && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.uD(false);
                    }
                }
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lsG != null) {
                    if (DistributeVideoView.this.lsZ && "DETAIL".equals(DistributeVideoView.this.lsG.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), 0);
                }
                return false;
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(36, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), DistributeVideoView.this.fsr.getCurrentPosition());
                }
                DistributeVideoView.this.iLT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lsM.setVisibility(0);
                return true;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lsU = System.currentTimeMillis();
                DistributeVideoView.this.lsZ = true;
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(34, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), DistributeVideoView.this.fsr.getDuration());
                }
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.lpp != null) {
                    DistributeVideoView.this.lpp.ddf();
                    DistributeVideoView.this.lsJ.setVisibility(8);
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
        this.ltb = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lsF != null && DistributeVideoView.this.fsr != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ea(1);
                }
            }
        };
        this.ltc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ddq();
            }
        };
        this.ltd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.uF(false);
            }
        };
        this.leQ = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lsX) {
                            DistributeVideoView.this.uD(true);
                            return;
                        } else {
                            DistributeVideoView.this.uD(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lsX = DistributeVideoView.this.lsT;
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
        this.lte = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.lsE = false;
        this.ajF = null;
        this.lsR = -1;
        this.lsS = 0L;
        this.lsT = false;
        this.lsU = 0L;
        this.mStyle = 1;
        this.drM = false;
        this.lsW = false;
        this.lsX = false;
        this.lsZ = false;
        this.lta = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lsM) {
                    DistributeVideoView.this.lsM.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lsL || view == DistributeVideoView.this.lsK) {
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsT ? false : true);
                } else if (view == DistributeVideoView.this.lsI || view == DistributeVideoView.this.lsP) {
                    DistributeVideoView.this.ddp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.lsG == null || !DistributeVideoView.this.lsG.aUg()) {
                    if (DistributeVideoView.this.lsV instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.lsV;
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
                    if (DistributeVideoView.this.lsG != null) {
                        WebVideoActivity.llO = new WebVideoActivity.a();
                        WebVideoActivity.llO.lma = DistributeVideoView.this.lsG;
                        WebVideoActivity.llO.mPage = "DETAIL";
                        WebVideoActivity.llO.mPageNum = DistributeVideoView.this.lsH;
                        NewWebVideoActivity.lmb = new NewWebVideoActivity.a();
                        NewWebVideoActivity.lmb.lma = DistributeVideoView.this.lsG;
                        NewWebVideoActivity.lmb.mPage = "DETAIL";
                        NewWebVideoActivity.lmb.mPageNum = DistributeVideoView.this.lsH;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.lsG.dMY;
                    if (a.bqh().bqi() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsF.video_url, DistributeVideoView.this.lsF.thumbnail_url, DistributeVideoView.this.lsF.video_width.intValue() / DistributeVideoView.this.lsF.video_height.intValue(), DistributeVideoView.this.lsF.video_duration.intValue(), DistributeVideoView.this.lsG.dMW);
                        if (DistributeVideoView.this.llW != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llW.lmY);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llW.lmZ);
                        }
                        if (DistributeVideoView.this.llX != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.llX.toJsonString());
                        }
                        if (DistributeVideoView.this.lsV instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsV).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsF.video_url, DistributeVideoView.this.lsF.thumbnail_url, DistributeVideoView.this.lsF.video_width.intValue() / DistributeVideoView.this.lsF.video_height.intValue(), DistributeVideoView.this.lsF.video_duration.intValue());
                        if (DistributeVideoView.this.llW != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llW.lmY);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llW.lmZ);
                        }
                        if (DistributeVideoView.this.llX != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.llX.toJsonString());
                        }
                        if (DistributeVideoView.this.lsV instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsV).goodsStyle);
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
                        if (DistributeVideoView.this.lsR != 1) {
                            if (DistributeVideoView.this.fsr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lsR = 1;
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
                        if (DistributeVideoView.this.lsR == 1) {
                            if (DistributeVideoView.this.lsS == DistributeVideoView.this.fsr.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.lsS = DistributeVideoView.this.fsr.getCurrentPosition();
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
                    DistributeVideoView.this.lsY = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fsr.getDuration();
                    DistributeVideoView.this.fsr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lsT && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.uD(false);
                    }
                }
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i, int i2, Object obj) {
                int i3;
                if (i == 3 && DistributeVideoView.this.lsG != null) {
                    if (DistributeVideoView.this.lsZ && "DETAIL".equals(DistributeVideoView.this.lsG.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), 0);
                }
                return false;
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(36, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), DistributeVideoView.this.fsr.getCurrentPosition());
                }
                DistributeVideoView.this.iLT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lsM.setVisibility(0);
                return true;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lsU = System.currentTimeMillis();
                DistributeVideoView.this.lsZ = true;
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(34, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), DistributeVideoView.this.fsr.getDuration());
                }
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.lpp != null) {
                    DistributeVideoView.this.lpp.ddf();
                    DistributeVideoView.this.lsJ.setVisibility(8);
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
        this.ltb = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lsF != null && DistributeVideoView.this.fsr != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ea(1);
                }
            }
        };
        this.ltc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ddq();
            }
        };
        this.ltd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.uF(false);
            }
        };
        this.leQ = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lsX) {
                            DistributeVideoView.this.uD(true);
                            return;
                        } else {
                            DistributeVideoView.this.uD(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lsX = DistributeVideoView.this.lsT;
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
        this.lte = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.lsE = false;
        this.ajF = null;
        this.lsR = -1;
        this.lsS = 0L;
        this.lsT = false;
        this.lsU = 0L;
        this.mStyle = 1;
        this.drM = false;
        this.lsW = false;
        this.lsX = false;
        this.lsZ = false;
        this.lta = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.lsM) {
                    DistributeVideoView.this.lsM.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.lsL || view == DistributeVideoView.this.lsK) {
                    DistributeVideoView.this.uD(DistributeVideoView.this.lsT ? false : true);
                } else if (view == DistributeVideoView.this.lsI || view == DistributeVideoView.this.lsP) {
                    DistributeVideoView.this.ddp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.lsG == null || !DistributeVideoView.this.lsG.aUg()) {
                    if (DistributeVideoView.this.lsV instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.lsV;
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
                    if (DistributeVideoView.this.lsG != null) {
                        WebVideoActivity.llO = new WebVideoActivity.a();
                        WebVideoActivity.llO.lma = DistributeVideoView.this.lsG;
                        WebVideoActivity.llO.mPage = "DETAIL";
                        WebVideoActivity.llO.mPageNum = DistributeVideoView.this.lsH;
                        NewWebVideoActivity.lmb = new NewWebVideoActivity.a();
                        NewWebVideoActivity.lmb.lma = DistributeVideoView.this.lsG;
                        NewWebVideoActivity.lmb.mPage = "DETAIL";
                        NewWebVideoActivity.lmb.mPageNum = DistributeVideoView.this.lsH;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.lsG.dMY;
                    if (a.bqh().bqi() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsF.video_url, DistributeVideoView.this.lsF.thumbnail_url, DistributeVideoView.this.lsF.video_width.intValue() / DistributeVideoView.this.lsF.video_height.intValue(), DistributeVideoView.this.lsF.video_duration.intValue(), DistributeVideoView.this.lsG.dMW);
                        if (DistributeVideoView.this.llW != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llW.lmY);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llW.lmZ);
                        }
                        if (DistributeVideoView.this.llX != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.llX.toJsonString());
                        }
                        if (DistributeVideoView.this.lsV instanceof AdCard) {
                            newWebVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsV).goodsStyle);
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.lsF.video_url, DistributeVideoView.this.lsF.thumbnail_url, DistributeVideoView.this.lsF.video_width.intValue() / DistributeVideoView.this.lsF.video_height.intValue(), DistributeVideoView.this.lsF.video_duration.intValue());
                        if (DistributeVideoView.this.llW != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.llW.lmY);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.llW.lmZ);
                        }
                        if (DistributeVideoView.this.llX != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.llX.toJsonString());
                        }
                        if (DistributeVideoView.this.lsV instanceof AdCard) {
                            webVideoActivityConfig.setGoodStyle(((AdCard) DistributeVideoView.this.lsV).goodsStyle);
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
                        if (DistributeVideoView.this.lsR != 1) {
                            if (DistributeVideoView.this.fsr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.lsR = 1;
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
                        if (DistributeVideoView.this.lsR == 1) {
                            if (DistributeVideoView.this.lsS == DistributeVideoView.this.fsr.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.lsS = DistributeVideoView.this.fsr.getCurrentPosition();
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
                    DistributeVideoView.this.lsY = DistributeVideoView.this.fsr.getCurrentPosition();
                    DistributeVideoView.this.mDuration = DistributeVideoView.this.fsr.getDuration();
                    DistributeVideoView.this.fsr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.lsT && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.uD(false);
                    }
                }
            }
        };
        this.dCA = new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i2, int i22, Object obj) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.lsG != null) {
                    if (DistributeVideoView.this.lsZ && "DETAIL".equals(DistributeVideoView.this.lsG.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), 0);
                }
                return false;
            }
        };
        this.dCy = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(36, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), DistributeVideoView.this.fsr.getCurrentPosition());
                }
                DistributeVideoView.this.iLT.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.lsM.setVisibility(0);
                return true;
            }
        };
        this.dCz = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                DistributeVideoView.this.lsU = System.currentTimeMillis();
                DistributeVideoView.this.lsZ = true;
                if (DistributeVideoView.this.fsr != null) {
                    DistributeVideoView.this.Z(34, DistributeVideoView.this.Eb(DistributeVideoView.this.lta), DistributeVideoView.this.fsr.getDuration());
                }
                DistributeVideoView.this.ddo();
                if (DistributeVideoView.this.lpp != null) {
                    DistributeVideoView.this.lpp.ddf();
                    DistributeVideoView.this.lsJ.setVisibility(8);
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
        this.ltb = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.lsF != null && DistributeVideoView.this.fsr != null && DistributeVideoView.this.canPlay()) {
                    DistributeVideoView.this.Ea(1);
                }
            }
        };
        this.ltc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.ddq();
            }
        };
        this.ltd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.uF(false);
            }
        };
        this.leQ = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.lsX) {
                            DistributeVideoView.this.uD(true);
                            return;
                        } else {
                            DistributeVideoView.this.uD(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.lsX = DistributeVideoView.this.lsT;
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
        this.lte = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.lsV = adCard;
        if (this.lsV != null) {
            this.parallelChargeInfo = this.lsV.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.fsr = (TbCyberVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.fsr.setNoBussinessStats();
            this.lsI = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.iLT = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.lsJ = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.lsM = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.lsN = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.lsK = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.lsO = this.mRootView.findViewById(R.id.distribute_control);
            this.lsP = (ImageView) this.lsO.findViewById(R.id.distribute_play_icon);
            this.lsL = (ImageView) this.lsO.findViewById(R.id.distribute_voice);
            this.lsQ = (VideoControllerView) this.lsO.findViewById(R.id.distribute_process);
            this.lpn = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.lpo = new d(context, this.lpn);
            this.lsI.setAnimation(R.raw.lotti_video_loading);
            this.lsI.setMinFrame(0);
            this.lsI.setFrame(0);
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
        this.llW = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.llX = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lsF = videoInfo;
        this.mDuration = this.lsF.video_duration.intValue() * 1000;
        this.ajF = new WeakReference<>(this.mContext.getApplicationContext());
        ddo();
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.lsF.video_width.intValue() > 0 ? (this.lsF.video_height.intValue() * equipmentWidth) / this.lsF.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.iLT.setDefaultErrorResource(0);
        this.iLT.setDefaultResource(0);
        this.iLT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!as.isEmpty(videoInfo.thumbnail_url)) {
            this.iLT.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnErrorListener(this.dCy);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnInfoListener(this.dCA);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        ao.setViewTextColor(this.lsJ, R.color.cp_cont_m);
        this.lsJ.setText(StringUtils.translateSecondsToString(this.lsF.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lsT = false;
            ao.setImageResource(this.lsK, R.drawable.icon_vedio_npronunciation_small_white);
            this.lsK.setVisibility(8);
        } else {
            this.lsT = true;
            ao.setImageResource(this.lsL, R.drawable.ad_icon_sound_open);
            this.lsK.setVisibility(8);
        }
        this.lsL.setOnClickListener(this.mOnClickListener);
        this.lsK.setOnClickListener(this.mOnClickListener);
        this.lsM.setOnClickListener(this.mOnClickListener);
        this.lsM.setVisibility(8);
        ao.setBackgroundColor(this.lsM, R.color.black_alpha80);
        ao.setViewTextColor(this.lsN, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.lsJ.setVisibility(0);
            return;
        }
        this.lsJ.setVisibility(8);
        this.lsP.setOnClickListener(this.mOnClickListener);
        this.lsI.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.lsF = videoInfo;
        this.ajF = new WeakReference<>(this.mContext.getApplicationContext());
        ddo();
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.iLT.setDefaultErrorResource(0);
        this.iLT.setDefaultResource(0);
        this.iLT.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!as.isEmpty(videoInfo.thumbnail_url)) {
            this.iLT.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.fsr.setOnPreparedListener(this.dCx);
        this.fsr.setOnErrorListener(this.dCy);
        this.fsr.setOnCompletionListener(this.dCz);
        this.fsr.setOnInfoListener(this.dCA);
        this.fsr.setOnSurfaceDestroyedListener(this.eRD);
        ao.setViewTextColor(this.lsJ, R.color.cp_cont_m);
        this.lsJ.setText(StringUtils.translateSecondsToString(this.lsF.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.lsT = false;
            ao.setImageResource(this.lsK, R.drawable.icon_vedio_npronunciation_small_white);
            this.lsK.setVisibility(8);
        } else {
            this.lsT = true;
            ao.setImageResource(this.lsL, R.drawable.ad_icon_sound_open);
            this.lsK.setVisibility(8);
        }
        this.lsL.setOnClickListener(this.mOnClickListener);
        this.lsK.setOnClickListener(this.mOnClickListener);
        this.lsM.setOnClickListener(this.mOnClickListener);
        this.lsM.setVisibility(8);
        ao.setBackgroundColor(this.lsM, R.color.black_alpha80);
        ao.setViewTextColor(this.lsN, R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.lsJ.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.lsJ.setVisibility(8);
        this.lsP.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.lsG;
        }
        this.lpp = this.lpo.a(this.llX, this.lpp);
        if (this.lpp != null) {
            this.lpp.setPageContext(this.mPageContext);
            this.lpp.c(this.lsV);
            if (this.lpp instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.lpp).uB(this.lrD);
            }
            this.lpp.setAdvertAppInfo(advertAppInfo);
            this.lpp.a(this.llX);
            this.lpp.ddg();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.lrD = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.lpp != null) {
            this.lpp.setDownloadAppCallback(cVar);
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
        this.lta = i;
        if (this.lsF != null && this.lsR == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.lsU) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.lpp != null) {
                    this.lpp.ddg();
                }
                this.fsr.setVideoPath(this.lsF.video_url);
                this.fsr.start();
                this.lsY = this.fsr.getCurrentPosition();
                ao.setImageResource(this.lsP, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.lsM.setVisibility(8);
                this.iLT.setForegroundDrawable(0);
                this.lsR = 0;
                if (this.mStyle == 1) {
                    this.lsJ.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.lsJ.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.lte);
                MessageManager.getInstance().registerListener(this.leQ);
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
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltb);
            com.baidu.adp.lib.f.e.lt().postDelayed(this.ltb, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.lsR == 1) {
            F(32, Eb(this.lta), this.fsr.getCurrentPosition(), i);
            this.fsr.pause();
            ag.a(this.ajF, false);
            setLoadingAnimShow(true);
            ao.setImageResource(this.lsP, R.drawable.icon_video_midpause);
            this.lsR = 2;
        }
    }

    public void autoContinue() {
        if (!this.lsW) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.lsR == 2) {
            this.lta = i;
            Z(33, Eb(i), this.fsr.getCurrentPosition());
            this.lsY = this.fsr.getCurrentPosition();
            this.fsr.start();
            if (this.lsT) {
                ag.a(this.ajF, true);
            }
            setLoadingAnimShow(false);
            ao.setImageResource(this.lsP, R.drawable.icon_video_midplay);
            this.lsR = 1;
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
        if (this.lsI != null) {
            this.lsI.setAlpha(1.0f);
            this.lsI.setVisibility(0);
            this.lsI.loop(true);
            this.lsI.setMinAndMaxFrame(14, 80);
            this.lsI.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        ddn();
        if (z) {
            this.lsI.setAlpha(1.0f);
            this.lsI.setVisibility(0);
            return;
        }
        this.lsI.setVisibility(8);
    }

    private void ddn() {
        if (this.lsI != null) {
            this.lsI.setMinFrame(0);
            this.lsI.setFrame(0);
            this.lsI.cancelAnimation();
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
        if (this.fsr.getCurrentPosition() > 0 && this.lsR != -1 && z) {
            int i = 32;
            int currentPosition = this.fsr.getCurrentPosition();
            if (this.fsr.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Eb(this.lta), currentPosition, this.fsr.isPlaying());
        }
        ddo();
    }

    public void initVideoViewLayout(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fsr.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lpn.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.iLT.getLayoutParams();
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
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltb);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltc);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltd);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.fsr.stopPlayback();
        this.lsR = -1;
        ag.a(this.ajF, false);
        uF(false);
        this.iLT.setForegroundDrawable(0);
        this.iLT.setVisibility(0);
        setLoadingAnimShow(true);
        ao.setImageResource(this.lsP, R.drawable.icon_video_midpause);
        this.lsQ.azZ();
        this.lsM.setVisibility(8);
        if (this.lsF != null) {
            this.lsJ.setText(StringUtils.translateSecondsToString(this.lsF.video_duration.intValue()));
            this.lsJ.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.lsX = false;
        MessageManager.getInstance().unRegisterListener(this.lte);
        MessageManager.getInstance().unRegisterListener(this.leQ);
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
        return this.lsF != null ? this.lsF.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.lpp instanceof com.baidu.tieba.recapp.e.a) && (this.lsV instanceof AdCard) && !((AdCard) this.lsV).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lpp).bsb();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.lpp instanceof com.baidu.tieba.recapp.e.a) && (this.lsV instanceof AdCard) && !((AdCard) this.lsV).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.lpp).dde();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uD(boolean z) {
        if (z) {
            if (this.fsr != null) {
                this.fsr.setVolume(1.0f, 1.0f);
            }
            ao.setImageResource(this.lsL, R.drawable.ad_icon_sound_open);
            ao.setImageResource(this.lsK, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.lsR == 1) {
                ag.a(this.ajF, true);
            }
        } else {
            if (this.fsr != null) {
                this.fsr.setVolume(0.0f, 0.0f);
            }
            ao.setImageResource(this.lsL, R.drawable.ad_icon_sound_close);
            ao.setImageResource(this.lsK, R.drawable.icon_vedio_npronunciation_small_white);
            ag.a(this.ajF, false);
        }
        this.lsT = z;
    }

    @Override // com.baidu.tieba.recapp.h
    public int getPlayStatus() {
        return this.lsR;
    }

    public VideoInfo getData() {
        return this.lsF;
    }

    @Override // com.baidu.tieba.recapp.h
    public long getCurrentPosition() {
        return this.lsS;
    }

    @Override // com.baidu.tieba.recapp.h
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.lsG = advertAppInfo;
        this.lsH = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.c a = g.a(this.lsG, 303, i, Eb(this.lta), this.lsF.video_duration.intValue(), this.mDuration, -1);
        if (this.lpp != null) {
            this.lpp.e(a);
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
        if (this.lsG != null && this.lsF != null) {
            this.lsG.page = this.mPage;
            com.baidu.tieba.recapp.report.d.dcY().a(g.a(this.lsG, i, this.lsH, i2, this.lsF.video_duration.intValue(), com.baidu.tieba.ad.a.a.pT(i3), i4));
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
                c(str, this.lsY, i3, this.mDuration, str2, Ec(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.llW != null && "cpv".equals(this.llW.lmY) && !TextUtils.isEmpty(this.llW.lmZ)) {
            new com.baidu.tieba.recapp.request.a(this.llW.lmZ).a(str, i, i2, i3, str2, str3);
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
            this.lsD = view;
            this.lsE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uE(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltc);
            if (this.but != null) {
                this.but.cancel();
            }
            this.lsO.setVisibility(0);
            if (this.lsR == 1) {
                ao.setImageResource(this.lsP, R.drawable.icon_video_midplay);
                return;
            } else {
                ao.setImageResource(this.lsP, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.lsO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ddp() {
        switch (this.lsR) {
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
                this.lsW = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    uE(true);
                    return;
                }
                return;
            case 2:
                this.lsW = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltc);
                    com.baidu.adp.lib.f.e.lt().postDelayed(this.ltc, TimeUnit.SECONDS.toMillis(3L));
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
            this.lsO.startAnimation(this.but);
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
                    DistributeVideoView.this.lsO.setVisibility(8);
                    DistributeVideoView.this.drM = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void ddr() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.ltd);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.ltd, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(boolean z) {
        if (this.lsK != null && this.mStyle == 1) {
            if (z) {
                this.lsK.setVisibility(0);
                ddr();
                return;
            }
            this.lsK.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.h
    public boolean canPlay() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.getEquipmentHeight(this.mContext);
    }
}
