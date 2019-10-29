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
    private String aTe;
    private Animation azf;
    boolean bIe;
    private WeakReference<Context> bUw;
    private String bpA;
    private g.b cUp;
    private QuickVideoView.b cUt;
    private g.a ddK;
    private g.f ddL;
    private g.e ddN;
    private g drt;
    private QuickVideoView dwx;
    private CustomMessageListener fwR;
    private ForeDrawableImageView guO;
    private CustomMessageListener iAL;
    private TBLottieAnimationView iAf;
    private AdCard.a iIk;
    private AdCard.f iIl;
    private ViewGroup iLG;
    private d iLH;
    private e iLI;
    private boolean iOb;
    private View iPb;
    private boolean iPc;
    private AdvertAppInfo iPd;
    private int iPe;
    private TextView iPf;
    private ImageView iPg;
    private ImageView iPh;
    private TextView iPi;
    private View iPj;
    private ImageView iPk;
    private VideoControllerView iPl;
    private boolean iPm;
    private long iPn;
    private b iPo;
    boolean iPp;
    private boolean iPq;
    private int iPr;
    boolean iPs;
    private int iPt;
    private Runnable iPu;
    private Runnable iPv;
    private CustomMessageListener iPw;
    private VideoInfo igN;
    private int igO;
    private View igV;
    private long igX;
    private Runnable ihd;
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
        if (this.iPd != null) {
            WebVideoActivity.iIe = new WebVideoActivity.a();
            WebVideoActivity.iIe.iIo = this.iPd;
            WebVideoActivity.iIe.aTe = "DETAIL";
            WebVideoActivity.iIe.mPageNum = this.iPe;
            NewWebVideoActivity.iIp = new NewWebVideoActivity.a();
            NewWebVideoActivity.iIp.iIo = this.iPd;
            NewWebVideoActivity.iIp.aTe = "DETAIL";
            NewWebVideoActivity.iIp.mPageNum = this.iPe;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.bpA) ? this.bpA : this.iPd.bXm, true, true, true, this.igN.video_url, this.igN.thumbnail_url, this.igN.video_width.intValue() / this.igN.video_height.intValue(), this.igN.video_duration.intValue(), this.iPd.bXk);
        if (this.iIk != null) {
            newWebVideoActivityConfig.setChargeStyle(this.iIk.iJm);
            newWebVideoActivityConfig.setChargeUrl(this.iIk.iJn);
        }
        if (this.iIl != null) {
            newWebVideoActivityConfig.setTailFrame(this.iIl.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGj() {
        Y(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.yT(this.parallelChargeInfo.heS);
            Iterator<String> it = this.parallelChargeInfo.heV.iterator();
            while (it.hasNext()) {
                c.yT(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cde() {
        if (this.iAf != null) {
            this.iAf.clearAnimation();
            this.iAf.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.iAf.setVisibility(8);
                    DistributeVideoView.this.guO.setVisibility(8);
                    DistributeVideoView.this.qh(DistributeVideoView.this.iPm);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.iPf.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.iPl.setPlayer(DistributeVideoView.this.dwx);
                        DistributeVideoView.this.iPl.aD(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.igN.video_duration.intValue()));
                        DistributeVideoView.this.iPl.showProgress();
                        DistributeVideoView.this.qi(true);
                        com.baidu.adp.lib.g.e.fZ().removeCallbacks(DistributeVideoView.this.iPu);
                        com.baidu.adp.lib.g.e.fZ().postDelayed(DistributeVideoView.this.iPu, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.igX = DistributeVideoView.this.dwx.getCurrentPosition();
                    DistributeVideoView.this.qj(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.iAf.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.iPc = false;
        this.bUw = null;
        this.igO = -1;
        this.igX = 0L;
        this.iPm = false;
        this.iPn = 0L;
        this.mStyle = 1;
        this.bIe = false;
        this.iPp = false;
        this.iPq = false;
        this.iPs = false;
        this.iPt = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.igV) {
                    DistributeVideoView.this.igV.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iPh || view == DistributeVideoView.this.iPg) {
                    DistributeVideoView.this.qh(DistributeVideoView.this.iPm ? false : true);
                } else if (view == DistributeVideoView.this.iAf || view == DistributeVideoView.this.iPk) {
                    DistributeVideoView.this.cgY();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iPd == null || !DistributeVideoView.this.iPd.agT()) {
                    if (DistributeVideoView.this.iPo instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.iPo;
                        if (!adCard.getAdvertAppInfo().agS() || adCard.directDownload) {
                            DistributeVideoView.this.cgY();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bGj();
                        return;
                    }
                    DistributeVideoView.this.cgY();
                } else {
                    if (DistributeVideoView.this.iPd != null) {
                        WebVideoActivity.iIe = new WebVideoActivity.a();
                        WebVideoActivity.iIe.iIo = DistributeVideoView.this.iPd;
                        WebVideoActivity.iIe.aTe = "DETAIL";
                        WebVideoActivity.iIe.mPageNum = DistributeVideoView.this.iPe;
                        NewWebVideoActivity.iIp = new NewWebVideoActivity.a();
                        NewWebVideoActivity.iIp.iIo = DistributeVideoView.this.iPd;
                        NewWebVideoActivity.iIp.aTe = "DETAIL";
                        NewWebVideoActivity.iIp.mPageNum = DistributeVideoView.this.iPe;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.bpA) ? DistributeVideoView.this.bpA : DistributeVideoView.this.iPd.bXm;
                    if (a.aAO().aAP() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.igN.video_url, DistributeVideoView.this.igN.thumbnail_url, DistributeVideoView.this.igN.video_width.intValue() / DistributeVideoView.this.igN.video_height.intValue(), DistributeVideoView.this.igN.video_duration.intValue(), DistributeVideoView.this.iPd.bXk);
                        if (DistributeVideoView.this.iIk != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iIk.iJm);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iIk.iJn);
                        }
                        if (DistributeVideoView.this.iIl != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iIl.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.igN.video_url, DistributeVideoView.this.igN.thumbnail_url, DistributeVideoView.this.igN.video_width.intValue() / DistributeVideoView.this.igN.video_height.intValue(), DistributeVideoView.this.igN.video_duration.intValue());
                        if (DistributeVideoView.this.iIk != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iIk.iJm);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iIk.iJn);
                        }
                        if (DistributeVideoView.this.iIl != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iIl.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bGj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.igO != 1) {
                            if (DistributeVideoView.this.dwx.getCurrentPosition() > 0) {
                                DistributeVideoView.this.igO = 1;
                                DistributeVideoView.this.cde();
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
                        if (DistributeVideoView.this.igO == 1) {
                            if (DistributeVideoView.this.igX == DistributeVideoView.this.dwx.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igX = DistributeVideoView.this.dwx.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iPr = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.drt = gVar;
                    DistributeVideoView.this.drt.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iPm && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qh(false);
                    }
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iPd != null) {
                    if (DistributeVideoView.this.iPs && "DETAIL".equals(DistributeVideoView.this.iPd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), 0);
                }
                return false;
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cgX();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), gVar.getCurrentPosition());
                DistributeVideoView.this.guO.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.igV.setVisibility(0);
                return true;
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iPn = System.currentTimeMillis();
                DistributeVideoView.this.iPs = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), gVar.getDuration());
                DistributeVideoView.this.cgX();
                if (DistributeVideoView.this.iLI != null) {
                    DistributeVideoView.this.iLI.cgP();
                    DistributeVideoView.this.iPf.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ihd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.igN != null && DistributeVideoView.this.dwx != null) {
                    DistributeVideoView.this.yz(1);
                }
            }
        };
        this.iPu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cgZ();
            }
        };
        this.iPv = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qj(false);
            }
        };
        this.iAL = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iPq) {
                            DistributeVideoView.this.qh(true);
                            return;
                        } else {
                            DistributeVideoView.this.qh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iPq = DistributeVideoView.this.iPm;
                    DistributeVideoView.this.qh(true);
                }
            }
        };
        this.fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.iPw = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.iPc = false;
        this.bUw = null;
        this.igO = -1;
        this.igX = 0L;
        this.iPm = false;
        this.iPn = 0L;
        this.mStyle = 1;
        this.bIe = false;
        this.iPp = false;
        this.iPq = false;
        this.iPs = false;
        this.iPt = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.igV) {
                    DistributeVideoView.this.igV.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iPh || view == DistributeVideoView.this.iPg) {
                    DistributeVideoView.this.qh(DistributeVideoView.this.iPm ? false : true);
                } else if (view == DistributeVideoView.this.iAf || view == DistributeVideoView.this.iPk) {
                    DistributeVideoView.this.cgY();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iPd == null || !DistributeVideoView.this.iPd.agT()) {
                    if (DistributeVideoView.this.iPo instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.iPo;
                        if (!adCard.getAdvertAppInfo().agS() || adCard.directDownload) {
                            DistributeVideoView.this.cgY();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bGj();
                        return;
                    }
                    DistributeVideoView.this.cgY();
                } else {
                    if (DistributeVideoView.this.iPd != null) {
                        WebVideoActivity.iIe = new WebVideoActivity.a();
                        WebVideoActivity.iIe.iIo = DistributeVideoView.this.iPd;
                        WebVideoActivity.iIe.aTe = "DETAIL";
                        WebVideoActivity.iIe.mPageNum = DistributeVideoView.this.iPe;
                        NewWebVideoActivity.iIp = new NewWebVideoActivity.a();
                        NewWebVideoActivity.iIp.iIo = DistributeVideoView.this.iPd;
                        NewWebVideoActivity.iIp.aTe = "DETAIL";
                        NewWebVideoActivity.iIp.mPageNum = DistributeVideoView.this.iPe;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.bpA) ? DistributeVideoView.this.bpA : DistributeVideoView.this.iPd.bXm;
                    if (a.aAO().aAP() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.igN.video_url, DistributeVideoView.this.igN.thumbnail_url, DistributeVideoView.this.igN.video_width.intValue() / DistributeVideoView.this.igN.video_height.intValue(), DistributeVideoView.this.igN.video_duration.intValue(), DistributeVideoView.this.iPd.bXk);
                        if (DistributeVideoView.this.iIk != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iIk.iJm);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iIk.iJn);
                        }
                        if (DistributeVideoView.this.iIl != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iIl.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.igN.video_url, DistributeVideoView.this.igN.thumbnail_url, DistributeVideoView.this.igN.video_width.intValue() / DistributeVideoView.this.igN.video_height.intValue(), DistributeVideoView.this.igN.video_duration.intValue());
                        if (DistributeVideoView.this.iIk != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iIk.iJm);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iIk.iJn);
                        }
                        if (DistributeVideoView.this.iIl != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iIl.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bGj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.igO != 1) {
                            if (DistributeVideoView.this.dwx.getCurrentPosition() > 0) {
                                DistributeVideoView.this.igO = 1;
                                DistributeVideoView.this.cde();
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
                        if (DistributeVideoView.this.igO == 1) {
                            if (DistributeVideoView.this.igX == DistributeVideoView.this.dwx.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igX = DistributeVideoView.this.dwx.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iPr = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.drt = gVar;
                    DistributeVideoView.this.drt.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iPm && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qh(false);
                    }
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.iPd != null) {
                    if (DistributeVideoView.this.iPs && "DETAIL".equals(DistributeVideoView.this.iPd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), 0);
                }
                return false;
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cgX();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), gVar.getCurrentPosition());
                DistributeVideoView.this.guO.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.igV.setVisibility(0);
                return true;
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iPn = System.currentTimeMillis();
                DistributeVideoView.this.iPs = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), gVar.getDuration());
                DistributeVideoView.this.cgX();
                if (DistributeVideoView.this.iLI != null) {
                    DistributeVideoView.this.iLI.cgP();
                    DistributeVideoView.this.iPf.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ihd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.igN != null && DistributeVideoView.this.dwx != null) {
                    DistributeVideoView.this.yz(1);
                }
            }
        };
        this.iPu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cgZ();
            }
        };
        this.iPv = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qj(false);
            }
        };
        this.iAL = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iPq) {
                            DistributeVideoView.this.qh(true);
                            return;
                        } else {
                            DistributeVideoView.this.qh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iPq = DistributeVideoView.this.iPm;
                    DistributeVideoView.this.qh(true);
                }
            }
        };
        this.fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.iPw = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
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
        this.iPc = false;
        this.bUw = null;
        this.igO = -1;
        this.igX = 0L;
        this.iPm = false;
        this.iPn = 0L;
        this.mStyle = 1;
        this.bIe = false;
        this.iPp = false;
        this.iPq = false;
        this.iPs = false;
        this.iPt = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.igV) {
                    DistributeVideoView.this.igV.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.iPh || view == DistributeVideoView.this.iPg) {
                    DistributeVideoView.this.qh(DistributeVideoView.this.iPm ? false : true);
                } else if (view == DistributeVideoView.this.iAf || view == DistributeVideoView.this.iPk) {
                    DistributeVideoView.this.cgY();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.iPd == null || !DistributeVideoView.this.iPd.agT()) {
                    if (DistributeVideoView.this.iPo instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.iPo;
                        if (!adCard.getAdvertAppInfo().agS() || adCard.directDownload) {
                            DistributeVideoView.this.cgY();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bGj();
                        return;
                    }
                    DistributeVideoView.this.cgY();
                } else {
                    if (DistributeVideoView.this.iPd != null) {
                        WebVideoActivity.iIe = new WebVideoActivity.a();
                        WebVideoActivity.iIe.iIo = DistributeVideoView.this.iPd;
                        WebVideoActivity.iIe.aTe = "DETAIL";
                        WebVideoActivity.iIe.mPageNum = DistributeVideoView.this.iPe;
                        NewWebVideoActivity.iIp = new NewWebVideoActivity.a();
                        NewWebVideoActivity.iIp.iIo = DistributeVideoView.this.iPd;
                        NewWebVideoActivity.iIp.aTe = "DETAIL";
                        NewWebVideoActivity.iIp.mPageNum = DistributeVideoView.this.iPe;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.bpA) ? DistributeVideoView.this.bpA : DistributeVideoView.this.iPd.bXm;
                    if (a.aAO().aAP() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.igN.video_url, DistributeVideoView.this.igN.thumbnail_url, DistributeVideoView.this.igN.video_width.intValue() / DistributeVideoView.this.igN.video_height.intValue(), DistributeVideoView.this.igN.video_duration.intValue(), DistributeVideoView.this.iPd.bXk);
                        if (DistributeVideoView.this.iIk != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iIk.iJm);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iIk.iJn);
                        }
                        if (DistributeVideoView.this.iIl != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.iIl.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.igN.video_url, DistributeVideoView.this.igN.thumbnail_url, DistributeVideoView.this.igN.video_width.intValue() / DistributeVideoView.this.igN.video_height.intValue(), DistributeVideoView.this.igN.video_duration.intValue());
                        if (DistributeVideoView.this.iIk != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.iIk.iJm);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.iIk.iJn);
                        }
                        if (DistributeVideoView.this.iIl != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.iIl.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bGj();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.igO != 1) {
                            if (DistributeVideoView.this.dwx.getCurrentPosition() > 0) {
                                DistributeVideoView.this.igO = 1;
                                DistributeVideoView.this.cde();
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
                        if (DistributeVideoView.this.igO == 1) {
                            if (DistributeVideoView.this.igX == DistributeVideoView.this.dwx.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.igX = DistributeVideoView.this.dwx.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.ddL = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iPr = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.drt = gVar;
                    DistributeVideoView.this.drt.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.iPm && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.qh(false);
                    }
                }
            }
        };
        this.ddN = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.iPd != null) {
                    if (DistributeVideoView.this.iPs && "DETAIL".equals(DistributeVideoView.this.iPd.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), 0);
                }
                return false;
            }
        };
        this.cUp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cgX();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), gVar.getCurrentPosition());
                DistributeVideoView.this.guO.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.igV.setVisibility(0);
                return true;
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iPn = System.currentTimeMillis();
                DistributeVideoView.this.iPs = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.yA(DistributeVideoView.this.iPt), gVar.getDuration());
                DistributeVideoView.this.cgX();
                if (DistributeVideoView.this.iLI != null) {
                    DistributeVideoView.this.iLI.cgP();
                    DistributeVideoView.this.iPf.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ihd = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.igN != null && DistributeVideoView.this.dwx != null) {
                    DistributeVideoView.this.yz(1);
                }
            }
        };
        this.iPu = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cgZ();
            }
        };
        this.iPv = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.qj(false);
            }
        };
        this.iAL = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.iPq) {
                            DistributeVideoView.this.qh(true);
                            return;
                        } else {
                            DistributeVideoView.this.qh(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.iPq = DistributeVideoView.this.iPm;
                    DistributeVideoView.this.qh(true);
                }
            }
        };
        this.fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
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
        this.iPw = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.qj(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.bpA = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iPo = adCard;
        if (this.iPo != null) {
            this.parallelChargeInfo = this.iPo.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.dwx = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.iAf = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.guO = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.iPf = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.igV = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.iPi = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.iPg = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.iPj = this.mRootView.findViewById(R.id.distribute_control);
            this.iPk = (ImageView) this.iPj.findViewById(R.id.distribute_play_icon);
            this.iPh = (ImageView) this.iPj.findViewById(R.id.distribute_voice);
            this.iPl = (VideoControllerView) this.iPj.findViewById(R.id.distribute_process);
            this.iLG = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.iLH = new d(context, this.iLG);
            this.iAf.setAnimation(R.raw.lotti_video_loading);
            this.iAf.setFrame(0);
        }
    }

    private boolean bYn() {
        return this.mStyle == 1 ? s.bYn() : j.isWifiNet();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            wI();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.iIk = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.iIl = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.igN = videoInfo;
        this.mDuration = this.igN.video_duration.intValue() * 1000;
        this.bUw = new WeakReference<>(this.mContext.getApplicationContext());
        cgX();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.igN.video_width.intValue() > 0 ? (this.igN.video_height.intValue() * equipmentWidth) / this.igN.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.guO.setDefaultErrorResource(0);
        this.guO.setDefaultResource(0);
        this.guO.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.guO.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dwx.setOnPreparedListener(this.ddL);
        this.dwx.setOnErrorListener(this.cUp);
        this.dwx.setOnCompletionListener(this.ddK);
        this.dwx.setOnOutInfoListener(this.ddN);
        this.dwx.setOnSurfaceDestroyedListener(this.cUt);
        am.setViewTextColor(this.iPf, (int) R.color.cp_cont_m);
        this.iPf.setText(StringUtils.translateSecondsToString(this.igN.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iPm = false;
            am.setImageResource(this.iPg, R.drawable.icon_vedio_npronunciation_small_white);
            this.iPg.setVisibility(8);
        } else {
            this.iPm = true;
            am.setImageResource(this.iPh, R.drawable.ad_icon_sound_open);
            this.iPg.setVisibility(8);
        }
        this.iPh.setOnClickListener(this.mOnClickListener);
        this.iPg.setOnClickListener(this.mOnClickListener);
        this.igV.setOnClickListener(this.mOnClickListener);
        this.igV.setVisibility(8);
        am.setBackgroundColor(this.igV, R.color.black_alpha80);
        am.setViewTextColor(this.iPi, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.iPf.setVisibility(0);
            return;
        }
        this.iPf.setVisibility(8);
        this.iPk.setOnClickListener(this.mOnClickListener);
        this.iAf.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.igN = videoInfo;
        this.bUw = new WeakReference<>(this.mContext.getApplicationContext());
        cgX();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.guO.setDefaultErrorResource(0);
        this.guO.setDefaultResource(0);
        this.guO.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.guO.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dwx.setOnPreparedListener(this.ddL);
        this.dwx.setOnErrorListener(this.cUp);
        this.dwx.setOnCompletionListener(this.ddK);
        this.dwx.setOnOutInfoListener(this.ddN);
        this.dwx.setOnSurfaceDestroyedListener(this.cUt);
        am.setViewTextColor(this.iPf, (int) R.color.cp_cont_m);
        this.iPf.setText(StringUtils.translateSecondsToString(this.igN.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iPm = false;
            am.setImageResource(this.iPg, R.drawable.icon_vedio_npronunciation_small_white);
            this.iPg.setVisibility(8);
        } else {
            this.iPm = true;
            am.setImageResource(this.iPh, R.drawable.ad_icon_sound_open);
            this.iPg.setVisibility(8);
        }
        this.iPh.setOnClickListener(this.mOnClickListener);
        this.iPg.setOnClickListener(this.mOnClickListener);
        this.igV.setOnClickListener(this.mOnClickListener);
        this.igV.setVisibility(8);
        am.setBackgroundColor(this.igV, R.color.black_alpha80);
        am.setViewTextColor(this.iPi, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.iPf.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.iPf.setVisibility(8);
        this.iPk.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.iPd;
        }
        this.iLI = this.iLH.a(this.iIl, this.iLI);
        if (this.iLI != null) {
            this.iLI.setPageContext(this.mPageContext);
            this.iLI.c(this.iPo);
            if (this.iLI instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.iLI).qf(this.iOb);
            }
            this.iLI.setAdvertAppInfo(advertAppInfo);
            this.iLI.a(this.iIl);
            this.iLI.cgQ();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.iOb = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iLI != null) {
            this.iLI.setDownloadAppCallback(cVar);
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
        this.ddK = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yz(int i) {
        this.iPt = i;
        if (this.igN != null && this.igO == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iPn) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iLI != null) {
                    this.iLI.cgQ();
                }
                this.dwx.setVideoPath(this.igN.video_url);
                this.dwx.start();
                this.iPr = this.dwx.getCurrentPosition();
                am.setImageResource(this.iPk, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.igV.setVisibility(8);
                this.guO.setForegroundDrawable(0);
                this.igO = 0;
                if (this.mStyle == 1) {
                    this.iPf.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.iPf.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.iPw);
                MessageManager.getInstance().registerListener(this.iAL);
                MessageManager.getInstance().registerListener(this.fwR);
            }
        }
    }

    public void performPlay() {
        yz(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bYn()) {
            if (i <= 0) {
                yz(1);
                return;
            }
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ihd);
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.ihd, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.igO == 1) {
            z(32, yA(this.iPt), this.dwx.getCurrentPosition(), i);
            this.dwx.pause();
            ac.a(this.bUw, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.iPk, R.drawable.icon_video_midpause);
            this.igO = 2;
        }
    }

    public void autoContinue() {
        if (!this.iPp) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.igO == 2) {
            this.iPt = i;
            Y(33, yA(i), this.dwx.getCurrentPosition());
            this.iPr = this.dwx.getCurrentPosition();
            this.dwx.start();
            if (this.iPm) {
                ac.a(this.bUw, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.iPk, R.drawable.icon_video_midplay);
            this.igO = 1;
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
        if (this.iAf != null) {
            this.iAf.setAlpha(1.0f);
            this.iAf.setVisibility(0);
            this.iAf.loop(true);
            this.iAf.setMinAndMaxFrame(14, 80);
            this.iAf.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cgW();
        if (z) {
            this.iAf.setAlpha(1.0f);
            this.iAf.setVisibility(0);
            return;
        }
        this.iAf.setVisibility(8);
    }

    private void cgW() {
        if (this.iAf != null) {
            this.iAf.setFrame(0);
            this.iAf.cancelAnimation();
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
        if (this.dwx.getCurrentPosition() > 0 && this.igO != -1 && z) {
            int i = 32;
            int currentPosition = this.dwx.getCurrentPosition();
            if (this.dwx.getDuration() == currentPosition) {
                i = 34;
            }
            f(i, yA(this.iPt), currentPosition, this.dwx.isPlaying());
        }
        cgX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgX() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.ihd);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iPu);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iPv);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.dwx.stopPlayback();
        this.igO = -1;
        ac.a(this.bUw, false);
        qj(false);
        this.guO.setForegroundDrawable(0);
        this.guO.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.iPk, R.drawable.icon_video_midpause);
        this.iPl.aDT();
        this.igV.setVisibility(8);
        if (this.igN != null) {
            this.iPf.setText(StringUtils.translateSecondsToString(this.igN.video_duration.intValue()));
            this.iPf.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.drt = null;
        this.iPq = false;
        MessageManager.getInstance().unRegisterListener(this.iPw);
        MessageManager.getInstance().unRegisterListener(this.iAL);
        MessageManager.getInstance().unRegisterListener(this.fwR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yA(int i) {
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
        return this.igN != null ? this.igN.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.iLI instanceof com.baidu.tieba.recapp.e.a) && (this.iPo instanceof AdCard) && !((AdCard) this.iPo).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.iLI).aDC();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.iLI instanceof com.baidu.tieba.recapp.e.a) && (this.iPo instanceof AdCard) && !((AdCard) this.iPo).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.iLI).cgO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(boolean z) {
        if (z) {
            if (this.drt != null) {
                this.drt.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.iPh, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.iPg, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.igO == 1) {
                ac.a(this.bUw, true);
            }
        } else {
            if (this.drt != null) {
                this.drt.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.iPh, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.iPg, R.drawable.icon_vedio_npronunciation_small_white);
            ac.a(this.bUw, false);
        }
        this.iPm = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.igO;
    }

    public VideoInfo getData() {
        return this.igN;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.igX;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.iPd = advertAppInfo;
        this.iPe = i;
        this.aTe = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.iPd, 303, i, yA(this.iPt), this.igN.video_duration.intValue(), this.mDuration, -1);
        if (this.iLI != null) {
            this.iLI.e(a);
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
        if (this.iPd != null && this.igN != null) {
            this.iPd.page = this.aTe;
            com.baidu.tieba.recapp.report.c.cgI().a(f.a(this.iPd, i, this.iPe, i2, this.igN.video_duration.intValue(), com.baidu.tieba.ad.a.a.lF(i3), i4));
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
                if ("DETAIL".equals(this.aTe)) {
                    str2 = "det";
                } else if ("FRS".equals(this.aTe)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.aTe)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.iPr, i3, this.mDuration, str2, yB(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.iIk != null && "cpv".equals(this.iIk.iJm) && !TextUtils.isEmpty(this.iIk.iJn)) {
            new com.baidu.tieba.recapp.request.a(this.iIk.iJn).a(str, i, i2, i3, str2, str3);
        }
    }

    private String yB(int i) {
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
            this.iPb = view;
            this.iPc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qi(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iPu);
            if (this.azf != null) {
                this.azf.cancel();
            }
            this.iPj.setVisibility(0);
            if (this.igO == 1) {
                am.setImageResource(this.iPk, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.iPk, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.iPj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        switch (this.igO) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.hU(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).akO();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.iPp = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    qi(true);
                    return;
                }
                return;
            case 2:
                this.iPp = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iPu);
                    com.baidu.adp.lib.g.e.fZ().postDelayed(this.iPu, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgZ() {
        if (!this.bIe && this.azf != null) {
            this.iPj.startAnimation(this.azf);
            this.bIe = true;
        }
    }

    private void wI() {
        if (this.mPageContext != null) {
            this.azf = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.azf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.iPj.setVisibility(8);
                    DistributeVideoView.this.bIe = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cha() {
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.iPv);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.iPv, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(boolean z) {
        if (this.iPg != null && this.mStyle == 1) {
            if (z) {
                this.iPg.setVisibility(0);
                cha();
                return;
            }
            this.iPg.setVisibility(8);
        }
    }
}
