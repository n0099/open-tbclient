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
import com.baidu.tbadk.util.af;
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
/* loaded from: classes13.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> Pf;
    private Animation aLx;
    boolean cwR;
    private g.b dMg;
    private QuickVideoView.b dMk;
    private g.a dVc;
    private g.f dVd;
    private g.e dVf;
    private g eeO;
    private QuickVideoView ekX;
    private CustomMessageListener gpI;
    private ForeDrawableImageView hnJ;
    private AdCard.a jGl;
    private AdCard.f jGm;
    private ViewGroup jJK;
    private d jJL;
    private e jJM;
    private boolean jMd;
    private Runnable jNA;
    private Runnable jNB;
    private CustomMessageListener jNC;
    private View jNc;
    private boolean jNd;
    private VideoInfo jNe;
    private AdvertAppInfo jNf;
    private int jNg;
    private TBLottieAnimationView jNh;
    private TextView jNi;
    private ImageView jNj;
    private ImageView jNk;
    private View jNl;
    private TextView jNm;
    private View jNn;
    private ImageView jNo;
    private VideoControllerView jNp;
    private long jNq;
    private boolean jNr;
    private long jNs;
    private b jNt;
    boolean jNu;
    private boolean jNv;
    private int jNw;
    boolean jNx;
    private int jNy;
    private Runnable jNz;
    private int jvm;
    private CustomMessageListener jyw;
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
        if (this.jNf != null) {
            WebVideoActivity.jGf = new WebVideoActivity.a();
            WebVideoActivity.jGf.jGp = this.jNf;
            WebVideoActivity.jGf.mPage = "DETAIL";
            WebVideoActivity.jGf.mPageNum = this.jNg;
            NewWebVideoActivity.jGq = new NewWebVideoActivity.a();
            NewWebVideoActivity.jGq.jGp = this.jNf;
            NewWebVideoActivity.jGq.mPage = "DETAIL";
            NewWebVideoActivity.jGq.mPageNum = this.jNg;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.jNf.cMY, true, true, true, this.jNe.video_url, this.jNe.thumbnail_url, this.jNe.video_width.intValue() / this.jNe.video_height.intValue(), this.jNe.video_duration.intValue(), this.jNf.cMW);
        if (this.jGl != null) {
            newWebVideoActivityConfig.setChargeStyle(this.jGl.jHm);
            newWebVideoActivityConfig.setChargeUrl(this.jGl.jHn);
        }
        if (this.jGm != null) {
            newWebVideoActivityConfig.setTailFrame(this.jGm.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cag() {
        Z(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.Ec(this.parallelChargeInfo.hXM);
            Iterator<String> it = this.parallelChargeInfo.hXP.iterator();
            while (it.hasNext()) {
                c.Ec(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czD() {
        if (this.jNh != null) {
            this.jNh.clearAnimation();
            this.jNh.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.jNh.setVisibility(8);
                    DistributeVideoView.this.hnJ.setVisibility(8);
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNr);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.jNi.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.jNp.setPlayer(DistributeVideoView.this.ekX);
                        DistributeVideoView.this.jNp.aZ(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.jNe.video_duration.intValue()));
                        DistributeVideoView.this.jNp.showProgress();
                        DistributeVideoView.this.sg(true);
                        com.baidu.adp.lib.f.e.gx().removeCallbacks(DistributeVideoView.this.jNA);
                        com.baidu.adp.lib.f.e.gx().postDelayed(DistributeVideoView.this.jNA, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.jNq = DistributeVideoView.this.ekX.getCurrentPosition();
                    DistributeVideoView.this.sh(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.jNh.setMinFrame(0);
                    DistributeVideoView.this.jNh.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.jNd = false;
        this.Pf = null;
        this.jvm = -1;
        this.jNq = 0L;
        this.jNr = false;
        this.jNs = 0L;
        this.mStyle = 1;
        this.cwR = false;
        this.jNu = false;
        this.jNv = false;
        this.jNx = false;
        this.jNy = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jNl) {
                    DistributeVideoView.this.jNl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jNk || view == DistributeVideoView.this.jNj) {
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNr ? false : true);
                } else if (view == DistributeVideoView.this.jNh || view == DistributeVideoView.this.jNo) {
                    DistributeVideoView.this.cDG();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jNf == null || !DistributeVideoView.this.jNf.aAr()) {
                    if (DistributeVideoView.this.jNt instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jNt;
                        if (!adCard.getAdvertAppInfo().aAq() || adCard.directDownload) {
                            DistributeVideoView.this.cDG();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cag();
                        return;
                    }
                    DistributeVideoView.this.cDG();
                } else {
                    if (DistributeVideoView.this.jNf != null) {
                        WebVideoActivity.jGf = new WebVideoActivity.a();
                        WebVideoActivity.jGf.jGp = DistributeVideoView.this.jNf;
                        WebVideoActivity.jGf.mPage = "DETAIL";
                        WebVideoActivity.jGf.mPageNum = DistributeVideoView.this.jNg;
                        NewWebVideoActivity.jGq = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jGq.jGp = DistributeVideoView.this.jNf;
                        NewWebVideoActivity.jGq.mPage = "DETAIL";
                        NewWebVideoActivity.jGq.mPageNum = DistributeVideoView.this.jNg;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jNf.cMY;
                    if (a.aVn().aVo() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNe.video_url, DistributeVideoView.this.jNe.thumbnail_url, DistributeVideoView.this.jNe.video_width.intValue() / DistributeVideoView.this.jNe.video_height.intValue(), DistributeVideoView.this.jNe.video_duration.intValue(), DistributeVideoView.this.jNf.cMW);
                        if (DistributeVideoView.this.jGl != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGl.jHm);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGl.jHn);
                        }
                        if (DistributeVideoView.this.jGm != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGm.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNe.video_url, DistributeVideoView.this.jNe.thumbnail_url, DistributeVideoView.this.jNe.video_width.intValue() / DistributeVideoView.this.jNe.video_height.intValue(), DistributeVideoView.this.jNe.video_duration.intValue());
                        if (DistributeVideoView.this.jGl != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGl.jHm);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGl.jHn);
                        }
                        if (DistributeVideoView.this.jGm != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGm.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cag();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jvm != 1) {
                            if (DistributeVideoView.this.ekX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jvm = 1;
                                DistributeVideoView.this.czD();
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
                        if (DistributeVideoView.this.jvm == 1) {
                            if (DistributeVideoView.this.jNq == DistributeVideoView.this.ekX.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jNq = DistributeVideoView.this.ekX.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jNw = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eeO = gVar;
                    DistributeVideoView.this.eeO.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jNr && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sf(false);
                    }
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jNf != null) {
                    if (DistributeVideoView.this.jNx && "DETAIL".equals(DistributeVideoView.this.jNf.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), 0);
                }
                return false;
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cDF();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), gVar.getCurrentPosition());
                DistributeVideoView.this.hnJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jNl.setVisibility(0);
                return true;
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jNs = System.currentTimeMillis();
                DistributeVideoView.this.jNx = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), gVar.getDuration());
                DistributeVideoView.this.cDF();
                if (DistributeVideoView.this.jJM != null) {
                    DistributeVideoView.this.jJM.cDw();
                    DistributeVideoView.this.jNi.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jNz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jNe != null && DistributeVideoView.this.ekX != null) {
                    DistributeVideoView.this.Bi(1);
                }
            }
        };
        this.jNA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cDH();
            }
        };
        this.jNB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sh(false);
            }
        };
        this.jyw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jNv) {
                            DistributeVideoView.this.sf(true);
                            return;
                        } else {
                            DistributeVideoView.this.sf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jNv = DistributeVideoView.this.jNr;
                    DistributeVideoView.this.sf(true);
                }
            }
        };
        this.gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sf(true);
                    }
                }
            }
        };
        this.jNC = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sh(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jNd = false;
        this.Pf = null;
        this.jvm = -1;
        this.jNq = 0L;
        this.jNr = false;
        this.jNs = 0L;
        this.mStyle = 1;
        this.cwR = false;
        this.jNu = false;
        this.jNv = false;
        this.jNx = false;
        this.jNy = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jNl) {
                    DistributeVideoView.this.jNl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jNk || view == DistributeVideoView.this.jNj) {
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNr ? false : true);
                } else if (view == DistributeVideoView.this.jNh || view == DistributeVideoView.this.jNo) {
                    DistributeVideoView.this.cDG();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jNf == null || !DistributeVideoView.this.jNf.aAr()) {
                    if (DistributeVideoView.this.jNt instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jNt;
                        if (!adCard.getAdvertAppInfo().aAq() || adCard.directDownload) {
                            DistributeVideoView.this.cDG();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cag();
                        return;
                    }
                    DistributeVideoView.this.cDG();
                } else {
                    if (DistributeVideoView.this.jNf != null) {
                        WebVideoActivity.jGf = new WebVideoActivity.a();
                        WebVideoActivity.jGf.jGp = DistributeVideoView.this.jNf;
                        WebVideoActivity.jGf.mPage = "DETAIL";
                        WebVideoActivity.jGf.mPageNum = DistributeVideoView.this.jNg;
                        NewWebVideoActivity.jGq = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jGq.jGp = DistributeVideoView.this.jNf;
                        NewWebVideoActivity.jGq.mPage = "DETAIL";
                        NewWebVideoActivity.jGq.mPageNum = DistributeVideoView.this.jNg;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jNf.cMY;
                    if (a.aVn().aVo() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNe.video_url, DistributeVideoView.this.jNe.thumbnail_url, DistributeVideoView.this.jNe.video_width.intValue() / DistributeVideoView.this.jNe.video_height.intValue(), DistributeVideoView.this.jNe.video_duration.intValue(), DistributeVideoView.this.jNf.cMW);
                        if (DistributeVideoView.this.jGl != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGl.jHm);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGl.jHn);
                        }
                        if (DistributeVideoView.this.jGm != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGm.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNe.video_url, DistributeVideoView.this.jNe.thumbnail_url, DistributeVideoView.this.jNe.video_width.intValue() / DistributeVideoView.this.jNe.video_height.intValue(), DistributeVideoView.this.jNe.video_duration.intValue());
                        if (DistributeVideoView.this.jGl != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGl.jHm);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGl.jHn);
                        }
                        if (DistributeVideoView.this.jGm != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGm.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cag();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jvm != 1) {
                            if (DistributeVideoView.this.ekX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jvm = 1;
                                DistributeVideoView.this.czD();
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
                        if (DistributeVideoView.this.jvm == 1) {
                            if (DistributeVideoView.this.jNq == DistributeVideoView.this.ekX.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jNq = DistributeVideoView.this.ekX.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jNw = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eeO = gVar;
                    DistributeVideoView.this.eeO.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jNr && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sf(false);
                    }
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jNf != null) {
                    if (DistributeVideoView.this.jNx && "DETAIL".equals(DistributeVideoView.this.jNf.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), 0);
                }
                return false;
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cDF();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), gVar.getCurrentPosition());
                DistributeVideoView.this.hnJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jNl.setVisibility(0);
                return true;
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jNs = System.currentTimeMillis();
                DistributeVideoView.this.jNx = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), gVar.getDuration());
                DistributeVideoView.this.cDF();
                if (DistributeVideoView.this.jJM != null) {
                    DistributeVideoView.this.jJM.cDw();
                    DistributeVideoView.this.jNi.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jNz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jNe != null && DistributeVideoView.this.ekX != null) {
                    DistributeVideoView.this.Bi(1);
                }
            }
        };
        this.jNA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cDH();
            }
        };
        this.jNB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sh(false);
            }
        };
        this.jyw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jNv) {
                            DistributeVideoView.this.sf(true);
                            return;
                        } else {
                            DistributeVideoView.this.sf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jNv = DistributeVideoView.this.jNr;
                    DistributeVideoView.this.sf(true);
                }
            }
        };
        this.gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sf(true);
                    }
                }
            }
        };
        this.jNC = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sh(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jNd = false;
        this.Pf = null;
        this.jvm = -1;
        this.jNq = 0L;
        this.jNr = false;
        this.jNs = 0L;
        this.mStyle = 1;
        this.cwR = false;
        this.jNu = false;
        this.jNv = false;
        this.jNx = false;
        this.jNy = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.jNl) {
                    DistributeVideoView.this.jNl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jNk || view == DistributeVideoView.this.jNj) {
                    DistributeVideoView.this.sf(DistributeVideoView.this.jNr ? false : true);
                } else if (view == DistributeVideoView.this.jNh || view == DistributeVideoView.this.jNo) {
                    DistributeVideoView.this.cDG();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jNf == null || !DistributeVideoView.this.jNf.aAr()) {
                    if (DistributeVideoView.this.jNt instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jNt;
                        if (!adCard.getAdvertAppInfo().aAq() || adCard.directDownload) {
                            DistributeVideoView.this.cDG();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.cag();
                        return;
                    }
                    DistributeVideoView.this.cDG();
                } else {
                    if (DistributeVideoView.this.jNf != null) {
                        WebVideoActivity.jGf = new WebVideoActivity.a();
                        WebVideoActivity.jGf.jGp = DistributeVideoView.this.jNf;
                        WebVideoActivity.jGf.mPage = "DETAIL";
                        WebVideoActivity.jGf.mPageNum = DistributeVideoView.this.jNg;
                        NewWebVideoActivity.jGq = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jGq.jGp = DistributeVideoView.this.jNf;
                        NewWebVideoActivity.jGq.mPage = "DETAIL";
                        NewWebVideoActivity.jGq.mPageNum = DistributeVideoView.this.jNg;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jNf.cMY;
                    if (a.aVn().aVo() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNe.video_url, DistributeVideoView.this.jNe.thumbnail_url, DistributeVideoView.this.jNe.video_width.intValue() / DistributeVideoView.this.jNe.video_height.intValue(), DistributeVideoView.this.jNe.video_duration.intValue(), DistributeVideoView.this.jNf.cMW);
                        if (DistributeVideoView.this.jGl != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGl.jHm);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGl.jHn);
                        }
                        if (DistributeVideoView.this.jGm != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGm.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.jNe.video_url, DistributeVideoView.this.jNe.thumbnail_url, DistributeVideoView.this.jNe.video_width.intValue() / DistributeVideoView.this.jNe.video_height.intValue(), DistributeVideoView.this.jNe.video_duration.intValue());
                        if (DistributeVideoView.this.jGl != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jGl.jHm);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jGl.jHn);
                        }
                        if (DistributeVideoView.this.jGm != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jGm.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.cag();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.jvm != 1) {
                            if (DistributeVideoView.this.ekX.getCurrentPosition() > 0) {
                                DistributeVideoView.this.jvm = 1;
                                DistributeVideoView.this.czD();
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
                        if (DistributeVideoView.this.jvm == 1) {
                            if (DistributeVideoView.this.jNq == DistributeVideoView.this.ekX.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.jNq = DistributeVideoView.this.ekX.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dVd = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jNw = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eeO = gVar;
                    DistributeVideoView.this.eeO.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jNr && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.sf(false);
                    }
                }
            }
        };
        this.dVf = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.jNf != null) {
                    if (DistributeVideoView.this.jNx && "DETAIL".equals(DistributeVideoView.this.jNf.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Z(i3, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), 0);
                }
                return false;
            }
        };
        this.dMg = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cDF();
                DistributeVideoView.this.Z(36, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), gVar.getCurrentPosition());
                DistributeVideoView.this.hnJ.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.jNl.setVisibility(0);
                return true;
            }
        };
        this.dVc = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jNs = System.currentTimeMillis();
                DistributeVideoView.this.jNx = true;
                DistributeVideoView.this.Z(34, DistributeVideoView.this.Bj(DistributeVideoView.this.jNy), gVar.getDuration());
                DistributeVideoView.this.cDF();
                if (DistributeVideoView.this.jJM != null) {
                    DistributeVideoView.this.jJM.cDw();
                    DistributeVideoView.this.jNi.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.jNz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.jNe != null && DistributeVideoView.this.ekX != null) {
                    DistributeVideoView.this.Bi(1);
                }
            }
        };
        this.jNA = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cDH();
            }
        };
        this.jNB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.sh(false);
            }
        };
        this.jyw = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jNv) {
                            DistributeVideoView.this.sf(true);
                            return;
                        } else {
                            DistributeVideoView.this.sf(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jNv = DistributeVideoView.this.jNr;
                    DistributeVideoView.this.sf(true);
                }
            }
        };
        this.gpI = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.sf(true);
                    }
                }
            }
        };
        this.jNC = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.sh(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.jNt = adCard;
        if (this.jNt != null) {
            this.parallelChargeInfo = this.jNt.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.ekX = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.jNh = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hnJ = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.jNi = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.jNl = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.jNm = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.jNj = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.jNn = this.mRootView.findViewById(R.id.distribute_control);
            this.jNo = (ImageView) this.jNn.findViewById(R.id.distribute_play_icon);
            this.jNk = (ImageView) this.jNn.findViewById(R.id.distribute_voice);
            this.jNp = (VideoControllerView) this.jNn.findViewById(R.id.distribute_process);
            this.jJK = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.jJL = new d(context, this.jJK);
            this.jNh.setAnimation(R.raw.lotti_video_loading);
            this.jNh.setMinFrame(0);
            this.jNh.setFrame(0);
        }
    }

    private boolean cDD() {
        return this.mStyle == 1 ? s.cDD() : j.isWifiNet();
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
        this.jGl = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.jGm = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jNe = videoInfo;
        this.mDuration = this.jNe.video_duration.intValue() * 1000;
        this.Pf = new WeakReference<>(this.mContext.getApplicationContext());
        cDF();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.jNe.video_width.intValue() > 0 ? (this.jNe.video_height.intValue() * equipmentWidth) / this.jNe.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hnJ.setDefaultErrorResource(0);
        this.hnJ.setDefaultResource(0);
        this.hnJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hnJ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ekX.setOnPreparedListener(this.dVd);
        this.ekX.setOnErrorListener(this.dMg);
        this.ekX.setOnCompletionListener(this.dVc);
        this.ekX.setOnOutInfoListener(this.dVf);
        this.ekX.setOnSurfaceDestroyedListener(this.dMk);
        am.setViewTextColor(this.jNi, (int) R.color.cp_cont_m);
        this.jNi.setText(StringUtils.translateSecondsToString(this.jNe.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jNr = false;
            am.setImageResource(this.jNj, R.drawable.icon_vedio_npronunciation_small_white);
            this.jNj.setVisibility(8);
        } else {
            this.jNr = true;
            am.setImageResource(this.jNk, R.drawable.ad_icon_sound_open);
            this.jNj.setVisibility(8);
        }
        this.jNk.setOnClickListener(this.mOnClickListener);
        this.jNj.setOnClickListener(this.mOnClickListener);
        this.jNl.setOnClickListener(this.mOnClickListener);
        this.jNl.setVisibility(8);
        am.setBackgroundColor(this.jNl, R.color.black_alpha80);
        am.setViewTextColor(this.jNm, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.jNi.setVisibility(0);
            return;
        }
        this.jNi.setVisibility(8);
        this.jNo.setOnClickListener(this.mOnClickListener);
        this.jNh.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.jNe = videoInfo;
        this.Pf = new WeakReference<>(this.mContext.getApplicationContext());
        cDF();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hnJ.setDefaultErrorResource(0);
        this.hnJ.setDefaultResource(0);
        this.hnJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hnJ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ekX.setOnPreparedListener(this.dVd);
        this.ekX.setOnErrorListener(this.dMg);
        this.ekX.setOnCompletionListener(this.dVc);
        this.ekX.setOnOutInfoListener(this.dVf);
        this.ekX.setOnSurfaceDestroyedListener(this.dMk);
        am.setViewTextColor(this.jNi, (int) R.color.cp_cont_m);
        this.jNi.setText(StringUtils.translateSecondsToString(this.jNe.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jNr = false;
            am.setImageResource(this.jNj, R.drawable.icon_vedio_npronunciation_small_white);
            this.jNj.setVisibility(8);
        } else {
            this.jNr = true;
            am.setImageResource(this.jNk, R.drawable.ad_icon_sound_open);
            this.jNj.setVisibility(8);
        }
        this.jNk.setOnClickListener(this.mOnClickListener);
        this.jNj.setOnClickListener(this.mOnClickListener);
        this.jNl.setOnClickListener(this.mOnClickListener);
        this.jNl.setVisibility(8);
        am.setBackgroundColor(this.jNl, R.color.black_alpha80);
        am.setViewTextColor(this.jNm, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.jNi.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.jNi.setVisibility(8);
        this.jNo.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.jNf;
        }
        this.jJM = this.jJL.a(this.jGm, this.jJM);
        if (this.jJM != null) {
            this.jJM.setPageContext(this.mPageContext);
            this.jJM.c(this.jNt);
            if (this.jJM instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.jJM).sd(this.jMd);
            }
            this.jJM.setAdvertAppInfo(advertAppInfo);
            this.jJM.a(this.jGm);
            this.jJM.cDx();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.jMd = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.jJM != null) {
            this.jJM.setDownloadAppCallback(cVar);
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
        this.dVc = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(int i) {
        this.jNy = i;
        if (this.jNe != null && this.jvm == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.jNs) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.jJM != null) {
                    this.jJM.cDx();
                }
                this.ekX.setVideoPath(this.jNe.video_url);
                this.ekX.start();
                this.jNw = this.ekX.getCurrentPosition();
                am.setImageResource(this.jNo, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.jNl.setVisibility(8);
                this.hnJ.setForegroundDrawable(0);
                this.jvm = 0;
                if (this.mStyle == 1) {
                    this.jNi.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.jNi.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.jNC);
                MessageManager.getInstance().registerListener(this.jyw);
                MessageManager.getInstance().registerListener(this.gpI);
            }
        }
    }

    public void performPlay() {
        Bi(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (cDD()) {
            if (i <= 0) {
                Bi(1);
                return;
            }
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNz);
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jNz, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.jvm == 1) {
            D(32, Bj(this.jNy), this.ekX.getCurrentPosition(), i);
            this.ekX.pause();
            af.a(this.Pf, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.jNo, R.drawable.icon_video_midpause);
            this.jvm = 2;
        }
    }

    public void autoContinue() {
        if (!this.jNu) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.jvm == 2) {
            this.jNy = i;
            Z(33, Bj(i), this.ekX.getCurrentPosition());
            this.jNw = this.ekX.getCurrentPosition();
            this.ekX.start();
            if (this.jNr) {
                af.a(this.Pf, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.jNo, R.drawable.icon_video_midplay);
            this.jvm = 1;
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
        if (this.jNh != null) {
            this.jNh.setAlpha(1.0f);
            this.jNh.setVisibility(0);
            this.jNh.loop(true);
            this.jNh.setMinAndMaxFrame(14, 80);
            this.jNh.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cDE();
        if (z) {
            this.jNh.setAlpha(1.0f);
            this.jNh.setVisibility(0);
            return;
        }
        this.jNh.setVisibility(8);
    }

    private void cDE() {
        if (this.jNh != null) {
            this.jNh.setMinFrame(0);
            this.jNh.setFrame(0);
            this.jNh.cancelAnimation();
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
        if (this.ekX.getCurrentPosition() > 0 && this.jvm != -1 && z) {
            int i = 32;
            int currentPosition = this.ekX.getCurrentPosition();
            if (this.ekX.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, Bj(this.jNy), currentPosition, this.ekX.isPlaying());
        }
        cDF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDF() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNz);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNA);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNB);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.ekX.stopPlayback();
        this.jvm = -1;
        af.a(this.Pf, false);
        sh(false);
        this.hnJ.setForegroundDrawable(0);
        this.hnJ.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.jNo, R.drawable.icon_video_midpause);
        this.jNp.akj();
        this.jNl.setVisibility(8);
        if (this.jNe != null) {
            this.jNi.setText(StringUtils.translateSecondsToString(this.jNe.video_duration.intValue()));
            this.jNi.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eeO = null;
        this.jNv = false;
        MessageManager.getInstance().unRegisterListener(this.jNC);
        MessageManager.getInstance().unRegisterListener(this.jyw);
        MessageManager.getInstance().unRegisterListener(this.gpI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Bj(int i) {
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
        return this.jNe != null ? this.jNe.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.jJM instanceof com.baidu.tieba.recapp.e.a) && (this.jNt instanceof AdCard) && !((AdCard) this.jNt).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jJM).aYe();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.jJM instanceof com.baidu.tieba.recapp.e.a) && (this.jNt instanceof AdCard) && !((AdCard) this.jNt).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jJM).cDv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sf(boolean z) {
        if (z) {
            if (this.eeO != null) {
                this.eeO.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.jNk, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.jNj, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.jvm == 1) {
                af.a(this.Pf, true);
            }
        } else {
            if (this.eeO != null) {
                this.eeO.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.jNk, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.jNj, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.Pf, false);
        }
        this.jNr = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.jvm;
    }

    public VideoInfo getData() {
        return this.jNe;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.jNq;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.jNf = advertAppInfo;
        this.jNg = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.jNf, 303, i, Bj(this.jNy), this.jNe.video_duration.intValue(), this.mDuration, -1);
        if (this.jJM != null) {
            this.jJM.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, int i2, int i3) {
        D(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void D(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.jNf != null && this.jNe != null) {
            this.jNf.page = this.mPage;
            com.baidu.tieba.recapp.report.c.cDp().a(f.a(this.jNf, i, this.jNg, i2, this.jNe.video_duration.intValue(), com.baidu.tieba.ad.a.a.oj(i3), i4));
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
                c(str, this.jNw, i3, this.mDuration, str2, Bk(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.jGl != null && "cpv".equals(this.jGl.jHm) && !TextUtils.isEmpty(this.jGl.jHn)) {
            new com.baidu.tieba.recapp.request.a(this.jGl.jHn).a(str, i, i2, i3, str2, str3);
        }
    }

    private String Bk(int i) {
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
            this.jNc = view;
            this.jNd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sg(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNA);
            if (this.aLx != null) {
                this.aLx.cancel();
            }
            this.jNn.setVisibility(0);
            if (this.jvm == 1) {
                am.setImageResource(this.jNo, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.jNo, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.jNn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDG() {
        switch (this.jvm) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.jW(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aEC();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.jNu = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    sg(true);
                    return;
                }
                return;
            case 2:
                this.jNu = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNA);
                    com.baidu.adp.lib.f.e.gx().postDelayed(this.jNA, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDH() {
        if (!this.cwR && this.aLx != null) {
            this.jNn.startAnimation(this.aLx);
            this.cwR = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.aLx = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.aLx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.jNn.setVisibility(8);
                    DistributeVideoView.this.cwR = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cDI() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jNB);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.jNB, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh(boolean z) {
        if (this.jNj != null && this.mStyle == 1) {
            if (z) {
                this.jNj.setVisibility(0);
                cDI();
                return;
            }
            this.jNj.setVisibility(8);
        }
    }
}
