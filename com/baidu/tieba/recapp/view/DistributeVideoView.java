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
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private String aSM;
    private Animation ayN;
    boolean bHn;
    private WeakReference<Context> bTF;
    private String bpi;
    private QuickVideoView.b cTC;
    private g.b cTy;
    private g.a dcS;
    private g.f dcT;
    private g.e dcV;
    private g dqC;
    private QuickVideoView dvG;
    private CustomMessageListener fwa;
    private ForeDrawableImageView gtX;
    private AdCard.a iHt;
    private AdCard.f iHu;
    private ViewGroup iKP;
    private d iKQ;
    private e iKR;
    private boolean iNk;
    private int iOA;
    boolean iOB;
    private int iOC;
    private Runnable iOD;
    private Runnable iOE;
    private CustomMessageListener iOF;
    private View iOk;
    private boolean iOl;
    private AdvertAppInfo iOm;
    private int iOn;
    private TextView iOo;
    private ImageView iOp;
    private ImageView iOq;
    private TextView iOr;
    private View iOs;
    private ImageView iOt;
    private VideoControllerView iOu;
    private boolean iOv;
    private long iOw;
    private b iOx;
    boolean iOy;
    private boolean iOz;
    private VideoInfo ifW;
    private int ifX;
    private View ige;
    private long igg;
    private Runnable igm;
    private CustomMessageListener izU;
    private TBLottieAnimationView izo;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View mMaskView;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    public void jump2DownloadDetailPage() {
        if (this.iOm != null) {
            WebVideoActivity.iHn = new WebVideoActivity.a();
            WebVideoActivity.iHn.iHx = this.iOm;
            WebVideoActivity.iHn.aSM = "DETAIL";
            WebVideoActivity.iHn.mPageNum = this.iOn;
            NewWebVideoActivity.iHy = new NewWebVideoActivity.a();
            NewWebVideoActivity.iHy.iHx = this.iOm;
            NewWebVideoActivity.iHy.aSM = "DETAIL";
            NewWebVideoActivity.iHy.mPageNum = this.iOn;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.bpi) ? this.bpi : this.iOm.bWv, true, true, true, this.ifW.video_url, this.ifW.thumbnail_url, this.ifW.video_width.intValue() / this.ifW.video_height.intValue(), this.ifW.video_duration.intValue(), this.iOm.bWt);
        if (this.iHt != null) {
            newWebVideoActivityConfig.setChargeStyle(this.iHt.iIv);
            newWebVideoActivityConfig.setChargeUrl(this.iHt.iIw);
        }
        if (this.iHu != null) {
            newWebVideoActivityConfig.setTailFrame(this.iHu.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGh() {
        Y(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.yT(this.parallelChargeInfo.heb);
            Iterator<String> it = this.parallelChargeInfo.hee.iterator();
            while (it.hasNext()) {
                c.yT(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdc() {
        if (this.izo != null) {
            this.izo.clearAnimation();
            this.izo.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.izo.setVisibility(8);
                    DistributeVideoView.this.gtX.setVisibility(8);
                    DistributeVideoView.this.qh(DistributeVideoView.this.iOv);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iOo.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iOu.setPlayer(DistributeVideoView.this.dvG);
                        DistributeVideoView.this.iOu.aB(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.ifW.video_duration.intValue()));
                        DistributeVideoView.this.iOu.showProgress();
                        DistributeVideoView.this.qi(true);
                        com.baidu.adp.lib.g.e.fZ().removeCallbacks(DistributeVideoView.this.iOD);
                        com.baidu.adp.lib.g.e.fZ().postDelayed(DistributeVideoView.this.iOD, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.igg = DistributeVideoView.this.dvG.getCurrentPosition();
                    DistributeVideoView.this.qj(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.izo.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iOl = false;
        this.bTF = null;
        this.ifX = -1;
        this.igg = 0L;
        this.iOv = false;
        this.iOw = 0L;
        this.mStyle = 1;
        this.bHn = false;
        this.iOy = false;
        this.iOz = false;
        this.iOB = false;
        this.iOC = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ige) {
                    DistributeVideoView.this.ige.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iOq || view == DistributeVideoView.this.iOp) {
                    DistributeVideoView.this.qh(DistributeVideoView.this.iOv ? false : true);
                } else if (view == DistributeVideoView.this.izo || view == DistributeVideoView.this.iOt) {
                    DistributeVideoView.this.cgW();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iOm == null || !DistributeVideoView.this.iOm.agR()) {
                    if (DistributeVideoView.this.iOx instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.iOx;
                        if (!adCard.getAdvertAppInfo().agQ() || adCard.directDownload) {
                            DistributeVideoView.this.cgW();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bGh();
                        return;
                    }
                    DistributeVideoView.this.cgW();
                } else {
                    if (DistributeVideoView.this.iOm != null) {
                        WebVideoActivity.iHn = new WebVideoActivity.a();
                        WebVideoActivity.iHn.iHx = DistributeVideoView.this.iOm;
                        WebVideoActivity.iHn.aSM = "DETAIL";
                        WebVideoActivity.iHn.mPageNum = DistributeVideoView.this.iOn;
                        NewWebVideoActivity.iHy = new NewWebVideoActivity.a();
                        NewWebVideoActivity.iHy.iHx = DistributeVideoView.this.iOm;
                        NewWebVideoActivity.iHy.aSM = "DETAIL";
                        NewWebVideoActivity.iHy.mPageNum = DistributeVideoView.this.iOn;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.bpi) ? DistributeVideoView.this.bpi : DistributeVideoView.this.iOm.bWv;
                    if (a.aAM().aAN() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.ifW.video_url, DistributeVideoView.this.ifW.thumbnail_url, DistributeVideoView.this.ifW.video_width.intValue() / DistributeVideoView.this.ifW.video_height.intValue(), DistributeVideoView.this.ifW.video_duration.intValue(), DistributeVideoView.this.iOm.bWt);
                        if (DistributeVideoView.this.iHt != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHt.iIv);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHt.iIw);
                        }
                        if (DistributeVideoView.this.iHu != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.ifW.video_url, DistributeVideoView.this.ifW.thumbnail_url, DistributeVideoView.this.ifW.video_width.intValue() / DistributeVideoView.this.ifW.video_height.intValue(), DistributeVideoView.this.ifW.video_duration.intValue());
                        if (DistributeVideoView.this.iHt != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHt.iIv);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHt.iIw);
                        }
                        if (DistributeVideoView.this.iHu != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bGh();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.ifX != 1) {
                            if (DistributeVideoView.this.dvG.getCurrentPosition() > 0) {
                                DistributeVideoView.this.ifX = 1;
                                DistributeVideoView.this.cdc();
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
                        if (DistributeVideoView.this.ifX == 1) {
                            if (DistributeVideoView.this.igg == DistributeVideoView.this.dvG.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igg = DistributeVideoView.this.dvG.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iOA = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dqC = gVar;
                    DistributeVideoView.this.dqC.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iOv && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qh(false);
                    }
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iOm != null) {
                    if (DistributeVideoView.this.iOB && "DETAIL".equals(DistributeVideoView.this.iOm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), 0);
                }
                return false;
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cgV();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), gVar.getCurrentPosition());
                DistributeVideoView.this.gtX.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.ige.setVisibility(0);
                return true;
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iOw = System.currentTimeMillis();
                DistributeVideoView.this.iOB = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), gVar.getDuration());
                DistributeVideoView.this.cgV();
                if (DistributeVideoView.this.iKR != null) {
                    DistributeVideoView.this.iKR.cgN();
                    DistributeVideoView.this.iOo.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.igm = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ifW != null && DistributeVideoView.this.dvG != null) {
                    DistributeVideoView.this.yy(1);
                }
            }
        };
        this.iOD = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cgX();
            }
        };
        this.iOE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qj(false);
            }
        };
        this.izU = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iOz) {
                            DistributeVideoView.this.qh(true);
                            return;
                        } else {
                            DistributeVideoView.this.qh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iOz = DistributeVideoView.this.iOv;
                    DistributeVideoView.this.qh(true);
                }
            }
        };
        this.fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qh(true);
                    }
                }
            }
        };
        this.iOF = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qj(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iOl = false;
        this.bTF = null;
        this.ifX = -1;
        this.igg = 0L;
        this.iOv = false;
        this.iOw = 0L;
        this.mStyle = 1;
        this.bHn = false;
        this.iOy = false;
        this.iOz = false;
        this.iOB = false;
        this.iOC = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ige) {
                    DistributeVideoView.this.ige.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iOq || view == DistributeVideoView.this.iOp) {
                    DistributeVideoView.this.qh(DistributeVideoView.this.iOv ? false : true);
                } else if (view == DistributeVideoView.this.izo || view == DistributeVideoView.this.iOt) {
                    DistributeVideoView.this.cgW();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iOm == null || !DistributeVideoView.this.iOm.agR()) {
                    if (DistributeVideoView.this.iOx instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.iOx;
                        if (!adCard.getAdvertAppInfo().agQ() || adCard.directDownload) {
                            DistributeVideoView.this.cgW();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bGh();
                        return;
                    }
                    DistributeVideoView.this.cgW();
                } else {
                    if (DistributeVideoView.this.iOm != null) {
                        WebVideoActivity.iHn = new WebVideoActivity.a();
                        WebVideoActivity.iHn.iHx = DistributeVideoView.this.iOm;
                        WebVideoActivity.iHn.aSM = "DETAIL";
                        WebVideoActivity.iHn.mPageNum = DistributeVideoView.this.iOn;
                        NewWebVideoActivity.iHy = new NewWebVideoActivity.a();
                        NewWebVideoActivity.iHy.iHx = DistributeVideoView.this.iOm;
                        NewWebVideoActivity.iHy.aSM = "DETAIL";
                        NewWebVideoActivity.iHy.mPageNum = DistributeVideoView.this.iOn;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.bpi) ? DistributeVideoView.this.bpi : DistributeVideoView.this.iOm.bWv;
                    if (a.aAM().aAN() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.ifW.video_url, DistributeVideoView.this.ifW.thumbnail_url, DistributeVideoView.this.ifW.video_width.intValue() / DistributeVideoView.this.ifW.video_height.intValue(), DistributeVideoView.this.ifW.video_duration.intValue(), DistributeVideoView.this.iOm.bWt);
                        if (DistributeVideoView.this.iHt != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHt.iIv);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHt.iIw);
                        }
                        if (DistributeVideoView.this.iHu != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.ifW.video_url, DistributeVideoView.this.ifW.thumbnail_url, DistributeVideoView.this.ifW.video_width.intValue() / DistributeVideoView.this.ifW.video_height.intValue(), DistributeVideoView.this.ifW.video_duration.intValue());
                        if (DistributeVideoView.this.iHt != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHt.iIv);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHt.iIw);
                        }
                        if (DistributeVideoView.this.iHu != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bGh();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.ifX != 1) {
                            if (DistributeVideoView.this.dvG.getCurrentPosition() > 0) {
                                DistributeVideoView.this.ifX = 1;
                                DistributeVideoView.this.cdc();
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
                        if (DistributeVideoView.this.ifX == 1) {
                            if (DistributeVideoView.this.igg == DistributeVideoView.this.dvG.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igg = DistributeVideoView.this.dvG.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iOA = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dqC = gVar;
                    DistributeVideoView.this.dqC.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iOv && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qh(false);
                    }
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iOm != null) {
                    if (DistributeVideoView.this.iOB && "DETAIL".equals(DistributeVideoView.this.iOm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), 0);
                }
                return false;
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cgV();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), gVar.getCurrentPosition());
                DistributeVideoView.this.gtX.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.ige.setVisibility(0);
                return true;
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iOw = System.currentTimeMillis();
                DistributeVideoView.this.iOB = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), gVar.getDuration());
                DistributeVideoView.this.cgV();
                if (DistributeVideoView.this.iKR != null) {
                    DistributeVideoView.this.iKR.cgN();
                    DistributeVideoView.this.iOo.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.igm = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ifW != null && DistributeVideoView.this.dvG != null) {
                    DistributeVideoView.this.yy(1);
                }
            }
        };
        this.iOD = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cgX();
            }
        };
        this.iOE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qj(false);
            }
        };
        this.izU = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iOz) {
                            DistributeVideoView.this.qh(true);
                            return;
                        } else {
                            DistributeVideoView.this.qh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iOz = DistributeVideoView.this.iOv;
                    DistributeVideoView.this.qh(true);
                }
            }
        };
        this.fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qh(true);
                    }
                }
            }
        };
        this.iOF = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qj(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iOl = false;
        this.bTF = null;
        this.ifX = -1;
        this.igg = 0L;
        this.iOv = false;
        this.iOw = 0L;
        this.mStyle = 1;
        this.bHn = false;
        this.iOy = false;
        this.iOz = false;
        this.iOB = false;
        this.iOC = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ige) {
                    DistributeVideoView.this.ige.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iOq || view == DistributeVideoView.this.iOp) {
                    DistributeVideoView.this.qh(DistributeVideoView.this.iOv ? false : true);
                } else if (view == DistributeVideoView.this.izo || view == DistributeVideoView.this.iOt) {
                    DistributeVideoView.this.cgW();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iOm == null || !DistributeVideoView.this.iOm.agR()) {
                    if (DistributeVideoView.this.iOx instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.iOx;
                        if (!adCard.getAdvertAppInfo().agQ() || adCard.directDownload) {
                            DistributeVideoView.this.cgW();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bGh();
                        return;
                    }
                    DistributeVideoView.this.cgW();
                } else {
                    if (DistributeVideoView.this.iOm != null) {
                        WebVideoActivity.iHn = new WebVideoActivity.a();
                        WebVideoActivity.iHn.iHx = DistributeVideoView.this.iOm;
                        WebVideoActivity.iHn.aSM = "DETAIL";
                        WebVideoActivity.iHn.mPageNum = DistributeVideoView.this.iOn;
                        NewWebVideoActivity.iHy = new NewWebVideoActivity.a();
                        NewWebVideoActivity.iHy.iHx = DistributeVideoView.this.iOm;
                        NewWebVideoActivity.iHy.aSM = "DETAIL";
                        NewWebVideoActivity.iHy.mPageNum = DistributeVideoView.this.iOn;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.bpi) ? DistributeVideoView.this.bpi : DistributeVideoView.this.iOm.bWv;
                    if (a.aAM().aAN() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.ifW.video_url, DistributeVideoView.this.ifW.thumbnail_url, DistributeVideoView.this.ifW.video_width.intValue() / DistributeVideoView.this.ifW.video_height.intValue(), DistributeVideoView.this.ifW.video_duration.intValue(), DistributeVideoView.this.iOm.bWt);
                        if (DistributeVideoView.this.iHt != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHt.iIv);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHt.iIw);
                        }
                        if (DistributeVideoView.this.iHu != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.ifW.video_url, DistributeVideoView.this.ifW.thumbnail_url, DistributeVideoView.this.ifW.video_width.intValue() / DistributeVideoView.this.ifW.video_height.intValue(), DistributeVideoView.this.ifW.video_duration.intValue());
                        if (DistributeVideoView.this.iHt != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iHt.iIv);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iHt.iIw);
                        }
                        if (DistributeVideoView.this.iHu != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iHu.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bGh();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.ifX != 1) {
                            if (DistributeVideoView.this.dvG.getCurrentPosition() > 0) {
                                DistributeVideoView.this.ifX = 1;
                                DistributeVideoView.this.cdc();
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
                        if (DistributeVideoView.this.ifX == 1) {
                            if (DistributeVideoView.this.igg == DistributeVideoView.this.dvG.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igg = DistributeVideoView.this.dvG.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dcT = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iOA = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.dqC = gVar;
                    DistributeVideoView.this.dqC.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iOv && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qh(false);
                    }
                }
            }
        };
        this.dcV = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iOm != null) {
                    if (DistributeVideoView.this.iOB && "DETAIL".equals(DistributeVideoView.this.iOm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), 0);
                }
                return false;
            }
        };
        this.cTy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cgV();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), gVar.getCurrentPosition());
                DistributeVideoView.this.gtX.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.ige.setVisibility(0);
                return true;
            }
        };
        this.dcS = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iOw = System.currentTimeMillis();
                DistributeVideoView.this.iOB = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.yz(DistributeVideoView.this.iOC), gVar.getDuration());
                DistributeVideoView.this.cgV();
                if (DistributeVideoView.this.iKR != null) {
                    DistributeVideoView.this.iKR.cgN();
                    DistributeVideoView.this.iOo.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cTC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.igm = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.ifW != null && DistributeVideoView.this.dvG != null) {
                    DistributeVideoView.this.yy(1);
                }
            }
        };
        this.iOD = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cgX();
            }
        };
        this.iOE = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qj(false);
            }
        };
        this.izU = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iOz) {
                            DistributeVideoView.this.qh(true);
                            return;
                        } else {
                            DistributeVideoView.this.qh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iOz = DistributeVideoView.this.iOv;
                    DistributeVideoView.this.qh(true);
                }
            }
        };
        this.fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.qh(true);
                    }
                }
            }
        };
        this.iOF = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qj(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.bpi = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iOx = adCard;
        if (this.iOx != null) {
            this.parallelChargeInfo = this.iOx.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dvG = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.izo = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.gtX = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iOo = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.ige = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iOr = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iOp = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iOs = this.mRootView.findViewById(R.id.distribute_control);
            this.iOt = (ImageView) this.iOs.findViewById(R.id.distribute_play_icon);
            this.iOq = (ImageView) this.iOs.findViewById(R.id.distribute_voice);
            this.iOu = (VideoControllerView) this.iOs.findViewById(R.id.distribute_process);
            this.iKP = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iKQ = new d(context, this.iKP);
            this.izo.setAnimation(R.raw.lotti_video_loading);
            this.izo.setFrame(0);
        }
    }

    private boolean bYl() {
        return this.mStyle == 1 ? s.bYl() : j.isWifiNet();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            wJ();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.iHt = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.iHu = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ifW = videoInfo;
        this.mDuration = this.ifW.video_duration.intValue() * 1000;
        this.bTF = new WeakReference<>(this.mContext.getApplicationContext());
        cgV();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.ifW.video_width.intValue() > 0 ? (this.ifW.video_height.intValue() * equipmentWidth) / this.ifW.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.gtX.setDefaultErrorResource(0);
        this.gtX.setDefaultResource(0);
        this.gtX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gtX.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dvG.setOnPreparedListener(this.dcT);
        this.dvG.setOnErrorListener(this.cTy);
        this.dvG.setOnCompletionListener(this.dcS);
        this.dvG.setOnOutInfoListener(this.dcV);
        this.dvG.setOnSurfaceDestroyedListener(this.cTC);
        am.setViewTextColor(this.iOo, (int) R.color.cp_cont_m);
        this.iOo.setText(StringUtils.translateSecondsToString(this.ifW.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iOv = false;
            am.setImageResource(this.iOp, R.drawable.icon_vedio_npronunciation_small_white);
            this.iOp.setVisibility(8);
        } else {
            this.iOv = true;
            am.setImageResource(this.iOq, R.drawable.ad_icon_sound_open);
            this.iOp.setVisibility(8);
        }
        this.iOq.setOnClickListener(this.mOnClickListener);
        this.iOp.setOnClickListener(this.mOnClickListener);
        this.ige.setOnClickListener(this.mOnClickListener);
        this.ige.setVisibility(8);
        am.setBackgroundColor(this.ige, R.color.black_alpha80);
        am.setViewTextColor(this.iOr, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iOo.setVisibility(0);
            return;
        }
        this.iOo.setVisibility(8);
        this.iOt.setOnClickListener(this.mOnClickListener);
        this.izo.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.ifW = videoInfo;
        this.bTF = new WeakReference<>(this.mContext.getApplicationContext());
        cgV();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.gtX.setDefaultErrorResource(0);
        this.gtX.setDefaultResource(0);
        this.gtX.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.gtX.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dvG.setOnPreparedListener(this.dcT);
        this.dvG.setOnErrorListener(this.cTy);
        this.dvG.setOnCompletionListener(this.dcS);
        this.dvG.setOnOutInfoListener(this.dcV);
        this.dvG.setOnSurfaceDestroyedListener(this.cTC);
        am.setViewTextColor(this.iOo, (int) R.color.cp_cont_m);
        this.iOo.setText(StringUtils.translateSecondsToString(this.ifW.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iOv = false;
            am.setImageResource(this.iOp, R.drawable.icon_vedio_npronunciation_small_white);
            this.iOp.setVisibility(8);
        } else {
            this.iOv = true;
            am.setImageResource(this.iOq, R.drawable.ad_icon_sound_open);
            this.iOp.setVisibility(8);
        }
        this.iOq.setOnClickListener(this.mOnClickListener);
        this.iOp.setOnClickListener(this.mOnClickListener);
        this.ige.setOnClickListener(this.mOnClickListener);
        this.ige.setVisibility(8);
        am.setBackgroundColor(this.ige, R.color.black_alpha80);
        am.setViewTextColor(this.iOr, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.iOo.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iOo.setVisibility(8);
        this.iOt.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.iOm;
        }
        this.iKR = this.iKQ.a(this.iHu, this.iKR);
        if (this.iKR != null) {
            this.iKR.setPageContext(this.mPageContext);
            this.iKR.c(this.iOx);
            if (this.iKR instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.iKR).qf(this.iNk);
            }
            this.iKR.setAdvertAppInfo(advertAppInfo);
            this.iKR.a(this.iHu);
            this.iKR.cgO();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.iNk = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iKR != null) {
            this.iKR.setDownloadAppCallback(cVar);
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
            h(this.mRootView, i2, i3);
            return true;
        }
        h(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void h(View view, int i, int i2) {
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
        this.dcS = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy(int i) {
        this.iOC = i;
        if (this.ifW != null && this.ifX == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iOw) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iKR != null) {
                    this.iKR.cgO();
                }
                this.dvG.setVideoPath(this.ifW.video_url);
                this.dvG.start();
                this.iOA = this.dvG.getCurrentPosition();
                am.setImageResource(this.iOt, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.ige.setVisibility(8);
                this.gtX.setForegroundDrawable(0);
                this.ifX = 0;
                if (this.mStyle == 1) {
                    this.iOo.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iOo.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iOF);
                MessageManager.getInstance().registerListener(this.izU);
                MessageManager.getInstance().registerListener(this.fwa);
            }
        }
    }

    public void performPlay() {
        yy(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bYl()) {
            if (i <= 0) {
                yy(1);
                return;
            }
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.igm);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.igm, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.ifX == 1) {
            z(32, yz(this.iOC), this.dvG.getCurrentPosition(), i);
            this.dvG.pause();
            ac.a(this.bTF, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.iOt, R.drawable.icon_video_midpause);
            this.ifX = 2;
        }
    }

    public void autoContinue() {
        if (!this.iOy) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.ifX == 2) {
            this.iOC = i;
            Y(33, yz(i), this.dvG.getCurrentPosition());
            this.iOA = this.dvG.getCurrentPosition();
            this.dvG.start();
            if (this.iOv) {
                ac.a(this.bTF, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.iOt, R.drawable.icon_video_midplay);
            this.ifX = 1;
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
        if (this.izo != null) {
            this.izo.setAlpha(1.0f);
            this.izo.setVisibility(0);
            this.izo.loop(true);
            this.izo.setMinAndMaxFrame(14, 80);
            this.izo.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cgU();
        if (z) {
            this.izo.setAlpha(1.0f);
            this.izo.setVisibility(0);
            return;
        }
        this.izo.setVisibility(8);
    }

    private void cgU() {
        if (this.izo != null) {
            this.izo.setFrame(0);
            this.izo.cancelAnimation();
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
        if (this.dvG.getCurrentPosition() > 0 && this.ifX != -1 && z) {
            int i = 32;
            int currentPosition = this.dvG.getCurrentPosition();
            if (this.dvG.getDuration() == currentPosition) {
                i = 34;
            }
            f(i, yz(this.iOC), currentPosition, this.dvG.isPlaying());
        }
        cgV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgV() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.igm);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iOD);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iOE);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dvG.stopPlayback();
        this.ifX = -1;
        ac.a(this.bTF, false);
        qj(false);
        this.gtX.setForegroundDrawable(0);
        this.gtX.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.iOt, R.drawable.icon_video_midpause);
        this.iOu.aDR();
        this.ige.setVisibility(8);
        if (this.ifW != null) {
            this.iOo.setText(StringUtils.translateSecondsToString(this.ifW.video_duration.intValue()));
            this.iOo.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.dqC = null;
        this.iOz = false;
        MessageManager.getInstance().unRegisterListener(this.iOF);
        MessageManager.getInstance().unRegisterListener(this.izU);
        MessageManager.getInstance().unRegisterListener(this.fwa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yz(int i) {
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
        return this.ifW != null ? this.ifW.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.iKR instanceof com.baidu.tieba.recapp.e.a) && (this.iOx instanceof AdCard) && !((AdCard) this.iOx).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.iKR).aDA();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.iKR instanceof com.baidu.tieba.recapp.e.a) && (this.iOx instanceof AdCard) && !((AdCard) this.iOx).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.iKR).cgM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(boolean z) {
        if (z) {
            if (this.dqC != null) {
                this.dqC.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.iOq, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.iOp, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.ifX == 1) {
                ac.a(this.bTF, true);
            }
        } else {
            if (this.dqC != null) {
                this.dqC.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.iOq, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.iOp, R.drawable.icon_vedio_npronunciation_small_white);
            ac.a(this.bTF, false);
        }
        this.iOv = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.ifX;
    }

    public VideoInfo getData() {
        return this.ifW;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.igg;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iOm = advertAppInfo;
        this.iOn = i;
        this.aSM = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iOm, 303, i, yz(this.iOC), this.ifW.video_duration.intValue(), this.mDuration, -1);
        if (this.iKR != null) {
            this.iKR.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, int i2, int i3) {
        z(i, i2, i3, -1);
    }

    private void f(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void z(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.iOm != null && this.ifW != null) {
            this.iOm.page = this.aSM;
            com.baidu.tieba.recapp.report.c.cgG().a(f.a(this.iOm, i, this.iOn, i2, this.ifW.video_duration.intValue(), com.baidu.tieba.ad.a.a.lE(i3), i4));
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
                if ("DETAIL".equals(this.aSM)) {
                    str2 = "det";
                } else if ("FRS".equals(this.aSM)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.aSM)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.iOA, i3, this.mDuration, str2, yA(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.iHt != null && "cpv".equals(this.iHt.iIv) && !TextUtils.isEmpty(this.iHt.iIw)) {
            new com.baidu.tieba.recapp.request.a(this.iHt.iIw).a(str, i, i2, i3, str2, str3);
        }
    }

    private String yA(int i) {
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
            this.iOk = view;
            this.iOl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iOD);
            if (this.ayN != null) {
                this.ayN.cancel();
            }
            this.iOs.setVisibility(0);
            if (this.ifX == 1) {
                am.setImageResource(this.iOt, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.iOt, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iOs.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgW() {
        switch (this.ifX) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.hT(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).akM();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.iOy = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qi(true);
                    return;
                }
                return;
            case 2:
                this.iOy = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iOD);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.iOD, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgX() {
        if (!this.bHn && this.ayN != null) {
            this.iOs.startAnimation(this.ayN);
            this.bHn = true;
        }
    }

    private void wJ() {
        if (this.mPageContext != null) {
            this.ayN = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.ayN.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.iOs.setVisibility(8);
                    DistributeVideoView.this.bHn = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cgY() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iOE);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iOE, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(boolean z) {
        if (this.iOp != null && this.mStyle == 1) {
            if (z) {
                this.iOp.setVisibility(0);
                cgY();
                return;
            }
            this.iOp.setVisibility(8);
        }
    }
}
