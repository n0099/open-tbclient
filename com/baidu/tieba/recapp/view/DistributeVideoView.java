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
/* loaded from: classes10.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> Oy;
    private Animation aGz;
    boolean csD;
    private g.b dHR;
    private QuickVideoView.b dHV;
    private g.a dQN;
    private g.f dQO;
    private g.e dQQ;
    private g eaB;
    private QuickVideoView egI;
    private CustomMessageListener gkw;
    private ForeDrawableImageView hic;
    private VideoInfo iXY;
    private int iXZ;
    private View iYg;
    private long iYi;
    private Runnable iYo;
    private AdCard.a jBL;
    private AdCard.f jBM;
    private ViewGroup jFf;
    private d jFg;
    private e jFh;
    private boolean jHy;
    private int jIA;
    private TBLottieAnimationView jIB;
    private TextView jIC;
    private ImageView jID;
    private ImageView jIE;
    private TextView jIF;
    private View jIG;
    private ImageView jIH;
    private VideoControllerView jII;
    private boolean jIJ;
    private long jIK;
    private b jIL;
    boolean jIM;
    private boolean jIN;
    private int jIO;
    boolean jIP;
    private int jIQ;
    private Runnable jIR;
    private Runnable jIS;
    private CustomMessageListener jIT;
    private View jIx;
    private boolean jIy;
    private AdvertAppInfo jIz;
    private CustomMessageListener jtX;
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
        if (this.jIz != null) {
            WebVideoActivity.jBF = new WebVideoActivity.a();
            WebVideoActivity.jBF.jBP = this.jIz;
            WebVideoActivity.jBF.mPage = "DETAIL";
            WebVideoActivity.jBF.mPageNum = this.jIA;
            NewWebVideoActivity.jBQ = new NewWebVideoActivity.a();
            NewWebVideoActivity.jBQ.jBP = this.jIz;
            NewWebVideoActivity.jBQ.mPage = "DETAIL";
            NewWebVideoActivity.jBQ.mPageNum = this.jIA;
        }
        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(this.mContext, "", !TextUtils.isEmpty(this.mScheme) ? this.mScheme : this.jIz.cII, true, true, true, this.iXY.video_url, this.iXY.thumbnail_url, this.iXY.video_width.intValue() / this.iXY.video_height.intValue(), this.iXY.video_duration.intValue(), this.jIz.cIG);
        if (this.jBL != null) {
            newWebVideoActivityConfig.setChargeStyle(this.jBL.jCM);
            newWebVideoActivityConfig.setChargeUrl(this.jBL.jCN);
        }
        if (this.jBM != null) {
            newWebVideoActivityConfig.setTailFrame(this.jBM.toJsonString());
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXu() {
        Y(2, 1, 0);
        if (this.parallelChargeInfo != null) {
            c.DC(this.parallelChargeInfo.hSi);
            Iterator<String> it = this.parallelChargeInfo.hSl.iterator();
            while (it.hasNext()) {
                c.DC(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwY() {
        if (this.jIB != null) {
            this.jIB.clearAnimation();
            this.jIB.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.jIB.setVisibility(8);
                    DistributeVideoView.this.hic.setVisibility(8);
                    DistributeVideoView.this.rQ(DistributeVideoView.this.jIJ);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.jIC.setVisibility(8);
                        DistributeVideoView.this.mMaskView.setVisibility(8);
                    } else {
                        DistributeVideoView.this.jII.setPlayer(DistributeVideoView.this.egI);
                        DistributeVideoView.this.jII.aV(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.iXY.video_duration.intValue()));
                        DistributeVideoView.this.jII.showProgress();
                        DistributeVideoView.this.rR(true);
                        com.baidu.adp.lib.f.e.gy().removeCallbacks(DistributeVideoView.this.jIR);
                        com.baidu.adp.lib.f.e.gy().postDelayed(DistributeVideoView.this.jIR, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.iYi = DistributeVideoView.this.egI.getCurrentPosition();
                    DistributeVideoView.this.rS(true);
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.jIB.setMinFrame(0);
                    DistributeVideoView.this.jIB.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.jIy = false;
        this.Oy = null;
        this.iXZ = -1;
        this.iYi = 0L;
        this.jIJ = false;
        this.jIK = 0L;
        this.mStyle = 1;
        this.csD = false;
        this.jIM = false;
        this.jIN = false;
        this.jIP = false;
        this.jIQ = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.iYg) {
                    DistributeVideoView.this.iYg.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jIE || view == DistributeVideoView.this.jID) {
                    DistributeVideoView.this.rQ(DistributeVideoView.this.jIJ ? false : true);
                } else if (view == DistributeVideoView.this.jIB || view == DistributeVideoView.this.jIH) {
                    DistributeVideoView.this.cAZ();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jIz == null || !DistributeVideoView.this.jIz.axI()) {
                    if (DistributeVideoView.this.jIL instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jIL;
                        if (!adCard.getAdvertAppInfo().axH() || adCard.directDownload) {
                            DistributeVideoView.this.cAZ();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bXu();
                        return;
                    }
                    DistributeVideoView.this.cAZ();
                } else {
                    if (DistributeVideoView.this.jIz != null) {
                        WebVideoActivity.jBF = new WebVideoActivity.a();
                        WebVideoActivity.jBF.jBP = DistributeVideoView.this.jIz;
                        WebVideoActivity.jBF.mPage = "DETAIL";
                        WebVideoActivity.jBF.mPageNum = DistributeVideoView.this.jIA;
                        NewWebVideoActivity.jBQ = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jBQ.jBP = DistributeVideoView.this.jIz;
                        NewWebVideoActivity.jBQ.mPage = "DETAIL";
                        NewWebVideoActivity.jBQ.mPageNum = DistributeVideoView.this.jIA;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jIz.cII;
                    if (a.aSA().aSB() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iXY.video_url, DistributeVideoView.this.iXY.thumbnail_url, DistributeVideoView.this.iXY.video_width.intValue() / DistributeVideoView.this.iXY.video_height.intValue(), DistributeVideoView.this.iXY.video_duration.intValue(), DistributeVideoView.this.jIz.cIG);
                        if (DistributeVideoView.this.jBL != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jBL.jCM);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jBL.jCN);
                        }
                        if (DistributeVideoView.this.jBM != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jBM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iXY.video_url, DistributeVideoView.this.iXY.thumbnail_url, DistributeVideoView.this.iXY.video_width.intValue() / DistributeVideoView.this.iXY.video_height.intValue(), DistributeVideoView.this.iXY.video_duration.intValue());
                        if (DistributeVideoView.this.jBL != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jBL.jCM);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jBL.jCN);
                        }
                        if (DistributeVideoView.this.jBM != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jBM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bXu();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.iXZ != 1) {
                            if (DistributeVideoView.this.egI.getCurrentPosition() > 0) {
                                DistributeVideoView.this.iXZ = 1;
                                DistributeVideoView.this.cwY();
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
                        if (DistributeVideoView.this.iXZ == 1) {
                            if (DistributeVideoView.this.iYi == DistributeVideoView.this.egI.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.iYi = DistributeVideoView.this.egI.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jIO = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaB = gVar;
                    DistributeVideoView.this.eaB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jIJ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.rQ(false);
                    }
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jIz != null) {
                    if (DistributeVideoView.this.jIP && "DETAIL".equals(DistributeVideoView.this.jIz.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), 0);
                }
                return false;
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cAY();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), gVar.getCurrentPosition());
                DistributeVideoView.this.hic.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.iYg.setVisibility(0);
                return true;
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jIK = System.currentTimeMillis();
                DistributeVideoView.this.jIP = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), gVar.getDuration());
                DistributeVideoView.this.cAY();
                if (DistributeVideoView.this.jFh != null) {
                    DistributeVideoView.this.jFh.cAQ();
                    DistributeVideoView.this.jIC.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.iYo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.iXY != null && DistributeVideoView.this.egI != null) {
                    DistributeVideoView.this.AU(1);
                }
            }
        };
        this.jIR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cBa();
            }
        };
        this.jIS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.rS(false);
            }
        };
        this.jtX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jIN) {
                            DistributeVideoView.this.rQ(true);
                            return;
                        } else {
                            DistributeVideoView.this.rQ(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jIN = DistributeVideoView.this.jIJ;
                    DistributeVideoView.this.rQ(true);
                }
            }
        };
        this.gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.rQ(true);
                    }
                }
            }
        };
        this.jIT = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.rS(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jIy = false;
        this.Oy = null;
        this.iXZ = -1;
        this.iYi = 0L;
        this.jIJ = false;
        this.jIK = 0L;
        this.mStyle = 1;
        this.csD = false;
        this.jIM = false;
        this.jIN = false;
        this.jIP = false;
        this.jIQ = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.iYg) {
                    DistributeVideoView.this.iYg.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jIE || view == DistributeVideoView.this.jID) {
                    DistributeVideoView.this.rQ(DistributeVideoView.this.jIJ ? false : true);
                } else if (view == DistributeVideoView.this.jIB || view == DistributeVideoView.this.jIH) {
                    DistributeVideoView.this.cAZ();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jIz == null || !DistributeVideoView.this.jIz.axI()) {
                    if (DistributeVideoView.this.jIL instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jIL;
                        if (!adCard.getAdvertAppInfo().axH() || adCard.directDownload) {
                            DistributeVideoView.this.cAZ();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bXu();
                        return;
                    }
                    DistributeVideoView.this.cAZ();
                } else {
                    if (DistributeVideoView.this.jIz != null) {
                        WebVideoActivity.jBF = new WebVideoActivity.a();
                        WebVideoActivity.jBF.jBP = DistributeVideoView.this.jIz;
                        WebVideoActivity.jBF.mPage = "DETAIL";
                        WebVideoActivity.jBF.mPageNum = DistributeVideoView.this.jIA;
                        NewWebVideoActivity.jBQ = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jBQ.jBP = DistributeVideoView.this.jIz;
                        NewWebVideoActivity.jBQ.mPage = "DETAIL";
                        NewWebVideoActivity.jBQ.mPageNum = DistributeVideoView.this.jIA;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jIz.cII;
                    if (a.aSA().aSB() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iXY.video_url, DistributeVideoView.this.iXY.thumbnail_url, DistributeVideoView.this.iXY.video_width.intValue() / DistributeVideoView.this.iXY.video_height.intValue(), DistributeVideoView.this.iXY.video_duration.intValue(), DistributeVideoView.this.jIz.cIG);
                        if (DistributeVideoView.this.jBL != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jBL.jCM);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jBL.jCN);
                        }
                        if (DistributeVideoView.this.jBM != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jBM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iXY.video_url, DistributeVideoView.this.iXY.thumbnail_url, DistributeVideoView.this.iXY.video_width.intValue() / DistributeVideoView.this.iXY.video_height.intValue(), DistributeVideoView.this.iXY.video_duration.intValue());
                        if (DistributeVideoView.this.jBL != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jBL.jCM);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jBL.jCN);
                        }
                        if (DistributeVideoView.this.jBM != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jBM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bXu();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.iXZ != 1) {
                            if (DistributeVideoView.this.egI.getCurrentPosition() > 0) {
                                DistributeVideoView.this.iXZ = 1;
                                DistributeVideoView.this.cwY();
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
                        if (DistributeVideoView.this.iXZ == 1) {
                            if (DistributeVideoView.this.iYi == DistributeVideoView.this.egI.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.iYi = DistributeVideoView.this.egI.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jIO = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaB = gVar;
                    DistributeVideoView.this.eaB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jIJ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.rQ(false);
                    }
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.jIz != null) {
                    if (DistributeVideoView.this.jIP && "DETAIL".equals(DistributeVideoView.this.jIz.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), 0);
                }
                return false;
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.cAY();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), gVar.getCurrentPosition());
                DistributeVideoView.this.hic.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.iYg.setVisibility(0);
                return true;
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jIK = System.currentTimeMillis();
                DistributeVideoView.this.jIP = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), gVar.getDuration());
                DistributeVideoView.this.cAY();
                if (DistributeVideoView.this.jFh != null) {
                    DistributeVideoView.this.jFh.cAQ();
                    DistributeVideoView.this.jIC.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.iYo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.iXY != null && DistributeVideoView.this.egI != null) {
                    DistributeVideoView.this.AU(1);
                }
            }
        };
        this.jIR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cBa();
            }
        };
        this.jIS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.rS(false);
            }
        };
        this.jtX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jIN) {
                            DistributeVideoView.this.rQ(true);
                            return;
                        } else {
                            DistributeVideoView.this.rQ(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jIN = DistributeVideoView.this.jIJ;
                    DistributeVideoView.this.rQ(true);
                }
            }
        };
        this.gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.rQ(true);
                    }
                }
            }
        };
        this.jIT = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.rS(true);
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jIy = false;
        this.Oy = null;
        this.iXZ = -1;
        this.iYi = 0L;
        this.jIJ = false;
        this.jIK = 0L;
        this.mStyle = 1;
        this.csD = false;
        this.jIM = false;
        this.jIN = false;
        this.jIP = false;
        this.jIQ = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.iYg) {
                    DistributeVideoView.this.iYg.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.jIE || view == DistributeVideoView.this.jID) {
                    DistributeVideoView.this.rQ(DistributeVideoView.this.jIJ ? false : true);
                } else if (view == DistributeVideoView.this.jIB || view == DistributeVideoView.this.jIH) {
                    DistributeVideoView.this.cAZ();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.jIz == null || !DistributeVideoView.this.jIz.axI()) {
                    if (DistributeVideoView.this.jIL instanceof AdCard) {
                        AdCard adCard = (AdCard) DistributeVideoView.this.jIL;
                        if (!adCard.getAdvertAppInfo().axH() || adCard.directDownload) {
                            DistributeVideoView.this.cAZ();
                            return;
                        }
                        DistributeVideoView.this.jump2DownloadDetailPage();
                        DistributeVideoView.this.bXu();
                        return;
                    }
                    DistributeVideoView.this.cAZ();
                } else {
                    if (DistributeVideoView.this.jIz != null) {
                        WebVideoActivity.jBF = new WebVideoActivity.a();
                        WebVideoActivity.jBF.jBP = DistributeVideoView.this.jIz;
                        WebVideoActivity.jBF.mPage = "DETAIL";
                        WebVideoActivity.jBF.mPageNum = DistributeVideoView.this.jIA;
                        NewWebVideoActivity.jBQ = new NewWebVideoActivity.a();
                        NewWebVideoActivity.jBQ.jBP = DistributeVideoView.this.jIz;
                        NewWebVideoActivity.jBQ.mPage = "DETAIL";
                        NewWebVideoActivity.jBQ.mPageNum = DistributeVideoView.this.jIA;
                    }
                    String str = !TextUtils.isEmpty(DistributeVideoView.this.mScheme) ? DistributeVideoView.this.mScheme : DistributeVideoView.this.jIz.cII;
                    if (a.aSA().aSB() == 1) {
                        NewWebVideoActivityConfig newWebVideoActivityConfig = new NewWebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iXY.video_url, DistributeVideoView.this.iXY.thumbnail_url, DistributeVideoView.this.iXY.video_width.intValue() / DistributeVideoView.this.iXY.video_height.intValue(), DistributeVideoView.this.iXY.video_duration.intValue(), DistributeVideoView.this.jIz.cIG);
                        if (DistributeVideoView.this.jBL != null) {
                            newWebVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jBL.jCM);
                            newWebVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jBL.jCN);
                        }
                        if (DistributeVideoView.this.jBM != null) {
                            newWebVideoActivityConfig.setTailFrame(DistributeVideoView.this.jBM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, newWebVideoActivityConfig));
                    } else {
                        WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", str, true, true, true, DistributeVideoView.this.iXY.video_url, DistributeVideoView.this.iXY.thumbnail_url, DistributeVideoView.this.iXY.video_width.intValue() / DistributeVideoView.this.iXY.video_height.intValue(), DistributeVideoView.this.iXY.video_duration.intValue());
                        if (DistributeVideoView.this.jBL != null) {
                            webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.jBL.jCM);
                            webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.jBL.jCN);
                        }
                        if (DistributeVideoView.this.jBM != null) {
                            webVideoActivityConfig.setTailFrame(DistributeVideoView.this.jBM.toJsonString());
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, webVideoActivityConfig));
                    }
                    DistributeVideoView.this.bXu();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.iXZ != 1) {
                            if (DistributeVideoView.this.egI.getCurrentPosition() > 0) {
                                DistributeVideoView.this.iXZ = 1;
                                DistributeVideoView.this.cwY();
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
                        if (DistributeVideoView.this.iXZ == 1) {
                            if (DistributeVideoView.this.iYi == DistributeVideoView.this.egI.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.iYi = DistributeVideoView.this.egI.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                }
            }
        };
        this.dQO = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.jIO = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.eaB = gVar;
                    DistributeVideoView.this.eaB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                    if (DistributeVideoView.this.jIJ && DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.rQ(false);
                    }
                }
            }
        };
        this.dQQ = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.jIz != null) {
                    if (DistributeVideoView.this.jIP && "DETAIL".equals(DistributeVideoView.this.jIz.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.Y(i3, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), 0);
                }
                return false;
            }
        };
        this.dHR = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.cAY();
                DistributeVideoView.this.Y(36, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), gVar.getCurrentPosition());
                DistributeVideoView.this.hic.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.iYg.setVisibility(0);
                return true;
            }
        };
        this.dQN = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.jIK = System.currentTimeMillis();
                DistributeVideoView.this.jIP = true;
                DistributeVideoView.this.Y(34, DistributeVideoView.this.AV(DistributeVideoView.this.jIQ), gVar.getDuration());
                DistributeVideoView.this.cAY();
                if (DistributeVideoView.this.jFh != null) {
                    DistributeVideoView.this.jFh.cAQ();
                    DistributeVideoView.this.jIC.setVisibility(8);
                    DistributeVideoView.this.mMaskView.setVisibility(8);
                    DistributeVideoView.this.setLoadingAnimShow(false);
                }
            }
        };
        this.dHV = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.iYo = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.iXY != null && DistributeVideoView.this.egI != null) {
                    DistributeVideoView.this.AU(1);
                }
            }
        };
        this.jIR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.cBa();
            }
        };
        this.jIS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.rS(false);
            }
        };
        this.jtX = new CustomMessageListener(2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && DistributeVideoView.this.mStyle == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (DistributeVideoView.this.jIN) {
                            DistributeVideoView.this.rQ(true);
                            return;
                        } else {
                            DistributeVideoView.this.rQ(false);
                            return;
                        }
                    }
                    DistributeVideoView.this.jIN = DistributeVideoView.this.jIJ;
                    DistributeVideoView.this.rQ(true);
                }
            }
        };
        this.gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && DistributeVideoView.this.mStyle == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        DistributeVideoView.this.rQ(true);
                    }
                }
            }
        };
        this.jIT = new CustomMessageListener(2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                DistributeVideoView.this.rS(true);
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.mScheme = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.jIL = adCard;
        if (this.jIL != null) {
            this.parallelChargeInfo = this.jIL.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
            this.egI = (QuickVideoView) this.mRootView.findViewById(R.id.distribute_texture);
            this.jIB = (TBLottieAnimationView) this.mRootView.findViewById(R.id.video_play);
            this.hic = (ForeDrawableImageView) this.mRootView.findViewById(R.id.distribute_thumbnail);
            this.jIC = (TextView) this.mRootView.findViewById(R.id.distribute_count_process);
            this.mMaskView = this.mRootView.findViewById(R.id.black_mask_top);
            this.iYg = this.mRootView.findViewById(R.id.distribute_error_tip);
            this.jIF = (TextView) this.mRootView.findViewById(R.id.distribute_error_tip_text);
            this.jID = (ImageView) this.mRootView.findViewById(R.id.distribute_voice_feed);
            this.jIG = this.mRootView.findViewById(R.id.distribute_control);
            this.jIH = (ImageView) this.jIG.findViewById(R.id.distribute_play_icon);
            this.jIE = (ImageView) this.jIG.findViewById(R.id.distribute_voice);
            this.jII = (VideoControllerView) this.jIG.findViewById(R.id.distribute_process);
            this.jFf = (FrameLayout) this.mRootView.findViewById(R.id.tail_frame_container);
            this.jFg = new d(context, this.jFf);
            this.jIB.setAnimation(R.raw.lotti_video_loading);
            this.jIB.setMinFrame(0);
            this.jIB.setFrame(0);
        }
    }

    private boolean crE() {
        return this.mStyle == 1 ? s.crE() : j.isWifiNet();
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
        this.jBL = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.jBM = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.iXY = videoInfo;
        this.mDuration = this.iXY.video_duration.intValue() * 1000;
        this.Oy = new WeakReference<>(this.mContext.getApplicationContext());
        cAY();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        int equipmentWidth = l.getEquipmentWidth(this.mContext) - l.getDimens(this.mContext, R.dimen.ds146);
        if (this.mStyle == 2) {
            equipmentWidth = l.getEquipmentWidth(this.mContext);
        }
        int intValue = this.iXY.video_width.intValue() > 0 ? (this.iXY.video_height.intValue() * equipmentWidth) / this.iXY.video_width.intValue() : equipmentWidth;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = equipmentWidth;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.hic.setDefaultErrorResource(0);
        this.hic.setDefaultResource(0);
        this.hic.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hic.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.egI.setOnPreparedListener(this.dQO);
        this.egI.setOnErrorListener(this.dHR);
        this.egI.setOnCompletionListener(this.dQN);
        this.egI.setOnOutInfoListener(this.dQQ);
        this.egI.setOnSurfaceDestroyedListener(this.dHV);
        am.setViewTextColor(this.jIC, (int) R.color.cp_cont_m);
        this.jIC.setText(StringUtils.translateSecondsToString(this.iXY.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jIJ = false;
            am.setImageResource(this.jID, R.drawable.icon_vedio_npronunciation_small_white);
            this.jID.setVisibility(8);
        } else {
            this.jIJ = true;
            am.setImageResource(this.jIE, R.drawable.ad_icon_sound_open);
            this.jID.setVisibility(8);
        }
        this.jIE.setOnClickListener(this.mOnClickListener);
        this.jID.setOnClickListener(this.mOnClickListener);
        this.iYg.setOnClickListener(this.mOnClickListener);
        this.iYg.setVisibility(8);
        am.setBackgroundColor(this.iYg, R.color.black_alpha80);
        am.setViewTextColor(this.jIF, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.mMaskView.setVisibility(0);
            this.jIC.setVisibility(0);
            return;
        }
        this.jIC.setVisibility(8);
        this.jIH.setOnClickListener(this.mOnClickListener);
        this.jIB.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.iXY = videoInfo;
        this.Oy = new WeakReference<>(this.mContext.getApplicationContext());
        cAY();
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.getEquipmentWidth(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.hic.setDefaultErrorResource(0);
        this.hic.setDefaultResource(0);
        this.hic.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        if (!aq.isEmpty(videoInfo.thumbnail_url)) {
            this.hic.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.egI.setOnPreparedListener(this.dQO);
        this.egI.setOnErrorListener(this.dHR);
        this.egI.setOnCompletionListener(this.dQN);
        this.egI.setOnOutInfoListener(this.dQQ);
        this.egI.setOnSurfaceDestroyedListener(this.dHV);
        am.setViewTextColor(this.jIC, (int) R.color.cp_cont_m);
        this.jIC.setText(StringUtils.translateSecondsToString(this.iXY.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.jIJ = false;
            am.setImageResource(this.jID, R.drawable.icon_vedio_npronunciation_small_white);
            this.jID.setVisibility(8);
        } else {
            this.jIJ = true;
            am.setImageResource(this.jIE, R.drawable.ad_icon_sound_open);
            this.jID.setVisibility(8);
        }
        this.jIE.setOnClickListener(this.mOnClickListener);
        this.jID.setOnClickListener(this.mOnClickListener);
        this.iYg.setOnClickListener(this.mOnClickListener);
        this.iYg.setVisibility(8);
        am.setBackgroundColor(this.iYg, R.color.black_alpha80);
        am.setViewTextColor(this.jIF, (int) R.color.cp_cont_a);
        if (this.mStyle == 1) {
            this.jIC.setVisibility(0);
            this.mMaskView.setVisibility(0);
            return;
        }
        this.jIC.setVisibility(8);
        this.jIH.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        if (advertAppInfo == null) {
            advertAppInfo = this.jIz;
        }
        this.jFh = this.jFg.a(this.jBM, this.jFh);
        if (this.jFh != null) {
            this.jFh.setPageContext(this.mPageContext);
            this.jFh.c(this.jIL);
            if (this.jFh instanceof com.baidu.tieba.recapp.e.a) {
                ((com.baidu.tieba.recapp.e.a) this.jFh).rO(this.jHy);
            }
            this.jFh.setAdvertAppInfo(advertAppInfo);
            this.jFh.a(this.jBM);
            this.jFh.cAR();
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        this.jHy = z;
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.jFh != null) {
            this.jFh.setDownloadAppCallback(cVar);
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
        this.dQN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU(int i) {
        this.jIQ = i;
        if (this.iXY != null && this.iXZ == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.jIK) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.jFh != null) {
                    this.jFh.cAR();
                }
                this.egI.setVideoPath(this.iXY.video_url);
                this.egI.start();
                this.jIO = this.egI.getCurrentPosition();
                am.setImageResource(this.jIH, R.drawable.icon_video_midplay);
                startLoadingAnim();
                this.iYg.setVisibility(8);
                this.hic.setForegroundDrawable(0);
                this.iXZ = 0;
                if (this.mStyle == 1) {
                    this.jIC.setVisibility(0);
                    this.mMaskView.setVisibility(0);
                } else {
                    this.jIC.setVisibility(8);
                }
                MessageManager.getInstance().registerListener(this.jIT);
                MessageManager.getInstance().registerListener(this.jtX);
                MessageManager.getInstance().registerListener(this.gkw);
            }
        }
    }

    public void performPlay() {
        AU(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (crE()) {
            if (i <= 0) {
                AU(1);
                return;
            }
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iYo);
            com.baidu.adp.lib.f.e.gy().postDelayed(this.iYo, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.iXZ == 1) {
            D(32, AV(this.jIQ), this.egI.getCurrentPosition(), i);
            this.egI.pause();
            af.a(this.Oy, false);
            setLoadingAnimShow(true);
            am.setImageResource(this.jIH, R.drawable.icon_video_midpause);
            this.iXZ = 2;
        }
    }

    public void autoContinue() {
        if (!this.jIM) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.iXZ == 2) {
            this.jIQ = i;
            Y(33, AV(i), this.egI.getCurrentPosition());
            this.jIO = this.egI.getCurrentPosition();
            this.egI.start();
            if (this.jIJ) {
                af.a(this.Oy, true);
            }
            setLoadingAnimShow(false);
            am.setImageResource(this.jIH, R.drawable.icon_video_midplay);
            this.iXZ = 1;
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
        if (this.jIB != null) {
            this.jIB.setAlpha(1.0f);
            this.jIB.setVisibility(0);
            this.jIB.loop(true);
            this.jIB.setMinAndMaxFrame(14, 80);
            this.jIB.playAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        cAX();
        if (z) {
            this.jIB.setAlpha(1.0f);
            this.jIB.setVisibility(0);
            return;
        }
        this.jIB.setVisibility(8);
    }

    private void cAX() {
        if (this.jIB != null) {
            this.jIB.setMinFrame(0);
            this.jIB.setFrame(0);
            this.jIB.cancelAnimation();
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
        if (this.egI.getCurrentPosition() > 0 && this.iXZ != -1 && z) {
            int i = 32;
            int currentPosition = this.egI.getCurrentPosition();
            if (this.egI.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, AV(this.jIQ), currentPosition, this.egI.isPlaying());
        }
        cAY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAY() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.iYo);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jIR);
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jIS);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.egI.stopPlayback();
        this.iXZ = -1;
        af.a(this.Oy, false);
        rS(false);
        this.hic.setForegroundDrawable(0);
        this.hic.setVisibility(0);
        setLoadingAnimShow(true);
        am.setImageResource(this.jIH, R.drawable.icon_video_midpause);
        this.jII.ahA();
        this.iYg.setVisibility(8);
        if (this.iXY != null) {
            this.jIC.setText(StringUtils.translateSecondsToString(this.iXY.video_duration.intValue()));
            this.jIC.setVisibility(0);
            this.mMaskView.setVisibility(0);
        }
        this.eaB = null;
        this.jIN = false;
        MessageManager.getInstance().unRegisterListener(this.jIT);
        MessageManager.getInstance().unRegisterListener(this.jtX);
        MessageManager.getInstance().unRegisterListener(this.gkw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int AV(int i) {
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
        return this.iXY != null ? this.iXY.video_url : "";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((this.jFh instanceof com.baidu.tieba.recapp.e.a) && (this.jIL instanceof AdCard) && !((AdCard) this.jIL).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jFh).aVu();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if ((this.jFh instanceof com.baidu.tieba.recapp.e.a) && (this.jIL instanceof AdCard) && !((AdCard) this.jIL).directDownload) {
            ((com.baidu.tieba.recapp.e.a) this.jFh).cAP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(boolean z) {
        if (z) {
            if (this.eaB != null) {
                this.eaB.setVolume(1.0f, 1.0f);
            }
            am.setImageResource(this.jIE, R.drawable.ad_icon_sound_open);
            am.setImageResource(this.jID, R.drawable.icon_vedio_pronunciation_small_white);
            if (this.iXZ == 1) {
                af.a(this.Oy, true);
            }
        } else {
            if (this.eaB != null) {
                this.eaB.setVolume(0.0f, 0.0f);
            }
            am.setImageResource(this.jIE, R.drawable.ad_icon_sound_close);
            am.setImageResource(this.jID, R.drawable.icon_vedio_npronunciation_small_white);
            af.a(this.Oy, false);
        }
        this.jIJ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.iXZ;
    }

    public VideoInfo getData() {
        return this.iXY;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.iYi;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.jIz = advertAppInfo;
        this.jIA = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.jIz, 303, i, AV(this.jIQ), this.iXY.video_duration.intValue(), this.mDuration, -1);
        if (this.jFh != null) {
            this.jFh.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(int i, int i2, int i3) {
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
        if (this.jIz != null && this.iXY != null) {
            this.jIz.page = this.mPage;
            com.baidu.tieba.recapp.report.c.cAJ().a(f.a(this.jIz, i, this.jIA, i2, this.iXY.video_duration.intValue(), com.baidu.tieba.ad.a.a.nS(i3), i4));
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
                c(str, this.jIO, i3, this.mDuration, str2, AW(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.jBL != null && "cpv".equals(this.jBL.jCM) && !TextUtils.isEmpty(this.jBL.jCN)) {
            new com.baidu.tieba.recapp.request.a(this.jBL.jCN).a(str, i, i2, i3, str2, str3);
        }
    }

    private String AW(int i) {
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
            this.jIx = view;
            this.jIy = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR(boolean z) {
        if (z) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jIR);
            if (this.aGz != null) {
                this.aGz.cancel();
            }
            this.jIG.setVisibility(0);
            if (this.iXZ == 1) {
                am.setImageResource(this.jIH, R.drawable.icon_video_midplay);
                return;
            } else {
                am.setImageResource(this.jIH, R.drawable.icon_video_midpause);
                return;
            }
        }
        this.jIG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAZ() {
        switch (this.iXZ) {
            case -1:
                if (!j.isNetWorkAvailable() && this.mPageContext != null) {
                    this.mPageContext.showToast((int) R.string.neterror);
                    return;
                } else if (!j.isWifiNet() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.jF(R.string.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aBW();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.jIM = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    rR(true);
                    return;
                }
                return;
            case 2:
                this.jIM = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jIR);
                    com.baidu.adp.lib.f.e.gy().postDelayed(this.jIR, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cBa() {
        if (!this.csD && this.aGz != null) {
            this.jIG.startAnimation(this.aGz);
            this.csD = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.aGz = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
            this.aGz.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.jIG.setVisibility(8);
                    DistributeVideoView.this.csD = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }

    private void cBb() {
        com.baidu.adp.lib.f.e.gy().removeCallbacks(this.jIS);
        com.baidu.adp.lib.f.e.gy().postDelayed(this.jIS, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS(boolean z) {
        if (this.jID != null && this.mStyle == 1) {
            if (z) {
                this.jID.setVisibility(0);
                cBb();
                return;
            }
            this.jID.setVisibility(8);
        }
    }
}
