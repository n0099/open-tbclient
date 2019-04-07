package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.ad.a.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.d;
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
    private String aSy;
    private Animation afd;
    private String axL;
    boolean bib;
    private WeakReference<Context> btD;
    private g.b cAo;
    private QuickVideoView.b cAs;
    private g.a cJH;
    private g.f cJI;
    private g.e cJK;
    private QuickVideoView dbf;
    private g ehx;
    private ForeDrawableImageView fWF;
    private VideoInfo hGH;
    private int hGI;
    private TextView hGL;
    private View hGP;
    private long hGR;
    private Runnable hGX;
    private TBLottieAnimationView hZm;
    private AdCard.a igQ;
    private AdCard.f igR;
    private ViewGroup ikf;
    private d ikg;
    private e ikh;
    private boolean inA;
    private AdvertAppInfo inB;
    private int inC;
    private ImageView inD;
    private ImageView inE;
    private TextView inF;
    private View inG;
    private ImageView inH;
    private VideoControllerView inI;
    private boolean inJ;
    private long inK;
    private b inL;
    boolean inM;
    private int inN;
    boolean inO;
    private int inP;
    private Runnable inQ;
    private View inz;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void bUd() {
        if (this.hZm != null) {
            this.hZm.clearAnimation();
            this.hZm.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.hZm.setVisibility(8);
                    DistributeVideoView.this.fWF.setVisibility(8);
                    DistributeVideoView.this.pq(DistributeVideoView.this.inJ);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mHandler.removeMessages(1002);
                        DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                    } else {
                        DistributeVideoView.this.inI.setPlayer(DistributeVideoView.this.dbf);
                        DistributeVideoView.this.inI.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hGH.video_duration.intValue()));
                        DistributeVideoView.this.inI.showProgress();
                        DistributeVideoView.this.pr(true);
                        com.baidu.adp.lib.g.e.jH().removeCallbacks(DistributeVideoView.this.inQ);
                        com.baidu.adp.lib.g.e.jH().postDelayed(DistributeVideoView.this.inQ, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hGR = DistributeVideoView.this.dbf.getCurrentPosition();
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.hZm.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.inA = false;
        this.btD = null;
        this.hGI = -1;
        this.hGR = 0L;
        this.inJ = false;
        this.inK = 0L;
        this.mStyle = 1;
        this.bib = false;
        this.inM = false;
        this.inO = false;
        this.inP = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hGP) {
                    DistributeVideoView.this.hGP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inE || view == DistributeVideoView.this.inD) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inJ ? false : true);
                } else if (view == DistributeVideoView.this.hZm || view == DistributeVideoView.this.inH) {
                    DistributeVideoView.this.bXP();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inB == null || !DistributeVideoView.this.inB.WZ()) {
                    DistributeVideoView.this.bXP();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inB != null) {
                        WebVideoActivity.igK = new WebVideoActivity.a();
                        WebVideoActivity.igK.igU = DistributeVideoView.this.inB;
                        WebVideoActivity.igK.axL = "DETAIL";
                        WebVideoActivity.igK.mPageNum = DistributeVideoView.this.inC;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSy) ? DistributeVideoView.this.aSy : DistributeVideoView.this.inB.bwI, true, true, true, DistributeVideoView.this.hGH.video_url, DistributeVideoView.this.hGH.thumbnail_url, DistributeVideoView.this.hGH.video_width.intValue() / DistributeVideoView.this.hGH.video_height.intValue(), DistributeVideoView.this.hGH.video_duration.intValue());
                    if (DistributeVideoView.this.igQ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.igQ.ihN);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.igQ.ihO);
                    }
                    if (DistributeVideoView.this.igR != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.igR.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xY(DistributeVideoView.this.parallelChargeInfo.gGr);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGu.iterator();
                        while (it.hasNext()) {
                            c.xY(it.next());
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
                        if (DistributeVideoView.this.hGI != 1) {
                            if (DistributeVideoView.this.dbf.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGI = 1;
                                DistributeVideoView.this.bUd();
                                return;
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        return;
                    case 1002:
                        if (!DistributeVideoView.this.isDisplay()) {
                            DistributeVideoView.this.stopPlay();
                            return;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbf.getDuration() - DistributeVideoView.this.dbf.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGI == 1) {
                            if (DistributeVideoView.this.hGR == DistributeVideoView.this.dbf.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hGR = DistributeVideoView.this.dbf.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.inN = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehx = gVar;
                    DistributeVideoView.this.ehx.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inB != null) {
                    if (DistributeVideoView.this.inO && "DETAIL".equals(DistributeVideoView.this.inB.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yd(DistributeVideoView.this.inP), 0);
                }
                return false;
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXO();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yd(DistributeVideoView.this.inP), gVar.getCurrentPosition());
                DistributeVideoView.this.fWF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hGP.setVisibility(0);
                return true;
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.inK = System.currentTimeMillis();
                DistributeVideoView.this.inO = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yd(DistributeVideoView.this.inP), gVar.getDuration());
                DistributeVideoView.this.bXO();
                if (DistributeVideoView.this.ikh != null) {
                    DistributeVideoView.this.ikh.bXE();
                    DistributeVideoView.this.hGL.setVisibility(8);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hGX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGH != null && DistributeVideoView.this.dbf != null) {
                    DistributeVideoView.this.yc(1);
                }
            }
        };
        this.inQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXQ();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inA = false;
        this.btD = null;
        this.hGI = -1;
        this.hGR = 0L;
        this.inJ = false;
        this.inK = 0L;
        this.mStyle = 1;
        this.bib = false;
        this.inM = false;
        this.inO = false;
        this.inP = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hGP) {
                    DistributeVideoView.this.hGP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inE || view == DistributeVideoView.this.inD) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inJ ? false : true);
                } else if (view == DistributeVideoView.this.hZm || view == DistributeVideoView.this.inH) {
                    DistributeVideoView.this.bXP();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inB == null || !DistributeVideoView.this.inB.WZ()) {
                    DistributeVideoView.this.bXP();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inB != null) {
                        WebVideoActivity.igK = new WebVideoActivity.a();
                        WebVideoActivity.igK.igU = DistributeVideoView.this.inB;
                        WebVideoActivity.igK.axL = "DETAIL";
                        WebVideoActivity.igK.mPageNum = DistributeVideoView.this.inC;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSy) ? DistributeVideoView.this.aSy : DistributeVideoView.this.inB.bwI, true, true, true, DistributeVideoView.this.hGH.video_url, DistributeVideoView.this.hGH.thumbnail_url, DistributeVideoView.this.hGH.video_width.intValue() / DistributeVideoView.this.hGH.video_height.intValue(), DistributeVideoView.this.hGH.video_duration.intValue());
                    if (DistributeVideoView.this.igQ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.igQ.ihN);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.igQ.ihO);
                    }
                    if (DistributeVideoView.this.igR != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.igR.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xY(DistributeVideoView.this.parallelChargeInfo.gGr);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGu.iterator();
                        while (it.hasNext()) {
                            c.xY(it.next());
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
                        if (DistributeVideoView.this.hGI != 1) {
                            if (DistributeVideoView.this.dbf.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGI = 1;
                                DistributeVideoView.this.bUd();
                                return;
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        return;
                    case 1002:
                        if (!DistributeVideoView.this.isDisplay()) {
                            DistributeVideoView.this.stopPlay();
                            return;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbf.getDuration() - DistributeVideoView.this.dbf.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGI == 1) {
                            if (DistributeVideoView.this.hGR == DistributeVideoView.this.dbf.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hGR = DistributeVideoView.this.dbf.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.inN = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehx = gVar;
                    DistributeVideoView.this.ehx.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inB != null) {
                    if (DistributeVideoView.this.inO && "DETAIL".equals(DistributeVideoView.this.inB.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yd(DistributeVideoView.this.inP), 0);
                }
                return false;
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXO();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yd(DistributeVideoView.this.inP), gVar.getCurrentPosition());
                DistributeVideoView.this.fWF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hGP.setVisibility(0);
                return true;
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.inK = System.currentTimeMillis();
                DistributeVideoView.this.inO = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yd(DistributeVideoView.this.inP), gVar.getDuration());
                DistributeVideoView.this.bXO();
                if (DistributeVideoView.this.ikh != null) {
                    DistributeVideoView.this.ikh.bXE();
                    DistributeVideoView.this.hGL.setVisibility(8);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hGX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGH != null && DistributeVideoView.this.dbf != null) {
                    DistributeVideoView.this.yc(1);
                }
            }
        };
        this.inQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXQ();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inA = false;
        this.btD = null;
        this.hGI = -1;
        this.hGR = 0L;
        this.inJ = false;
        this.inK = 0L;
        this.mStyle = 1;
        this.bib = false;
        this.inM = false;
        this.inO = false;
        this.inP = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hGP) {
                    DistributeVideoView.this.hGP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inE || view == DistributeVideoView.this.inD) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inJ ? false : true);
                } else if (view == DistributeVideoView.this.hZm || view == DistributeVideoView.this.inH) {
                    DistributeVideoView.this.bXP();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inB == null || !DistributeVideoView.this.inB.WZ()) {
                    DistributeVideoView.this.bXP();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inB != null) {
                        WebVideoActivity.igK = new WebVideoActivity.a();
                        WebVideoActivity.igK.igU = DistributeVideoView.this.inB;
                        WebVideoActivity.igK.axL = "DETAIL";
                        WebVideoActivity.igK.mPageNum = DistributeVideoView.this.inC;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSy) ? DistributeVideoView.this.aSy : DistributeVideoView.this.inB.bwI, true, true, true, DistributeVideoView.this.hGH.video_url, DistributeVideoView.this.hGH.thumbnail_url, DistributeVideoView.this.hGH.video_width.intValue() / DistributeVideoView.this.hGH.video_height.intValue(), DistributeVideoView.this.hGH.video_duration.intValue());
                    if (DistributeVideoView.this.igQ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.igQ.ihN);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.igQ.ihO);
                    }
                    if (DistributeVideoView.this.igR != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.igR.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xY(DistributeVideoView.this.parallelChargeInfo.gGr);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGu.iterator();
                        while (it.hasNext()) {
                            c.xY(it.next());
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
                        if (DistributeVideoView.this.hGI != 1) {
                            if (DistributeVideoView.this.dbf.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGI = 1;
                                DistributeVideoView.this.bUd();
                                return;
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        return;
                    case 1002:
                        if (!DistributeVideoView.this.isDisplay()) {
                            DistributeVideoView.this.stopPlay();
                            return;
                        }
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbf.getDuration() - DistributeVideoView.this.dbf.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGI == 1) {
                            if (DistributeVideoView.this.hGR == DistributeVideoView.this.dbf.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hGR = DistributeVideoView.this.dbf.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.cJI = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.inN = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehx = gVar;
                    DistributeVideoView.this.ehx.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJK = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.inB != null) {
                    if (DistributeVideoView.this.inO && "DETAIL".equals(DistributeVideoView.this.inB.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yd(DistributeVideoView.this.inP), 0);
                }
                return false;
            }
        };
        this.cAo = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bXO();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yd(DistributeVideoView.this.inP), gVar.getCurrentPosition());
                DistributeVideoView.this.fWF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hGP.setVisibility(0);
                return true;
            }
        };
        this.cJH = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.inK = System.currentTimeMillis();
                DistributeVideoView.this.inO = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yd(DistributeVideoView.this.inP), gVar.getDuration());
                DistributeVideoView.this.bXO();
                if (DistributeVideoView.this.ikh != null) {
                    DistributeVideoView.this.ikh.bXE();
                    DistributeVideoView.this.hGL.setVisibility(8);
                }
            }
        };
        this.cAs = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hGX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGH != null && DistributeVideoView.this.dbf != null) {
                    DistributeVideoView.this.yc(1);
                }
            }
        };
        this.inQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXQ();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aSy = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.inL = adCard;
        if (this.inL != null) {
            this.parallelChargeInfo = this.inL.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.dbf = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.hZm = (TBLottieAnimationView) this.mRootView.findViewById(d.g.video_play);
            this.fWF = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.hGL = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.hGP = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.inF = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.inD = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.inG = this.mRootView.findViewById(d.g.distribute_control);
            this.inH = (ImageView) this.inG.findViewById(d.g.distribute_play_icon);
            this.inE = (ImageView) this.inG.findViewById(d.g.distribute_voice);
            this.inI = (VideoControllerView) this.inG.findViewById(d.g.distribute_process);
            this.ikf = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.ikg = new com.baidu.tieba.recapp.e.d(context, this.ikf);
            this.hZm.setAnimation(d.i.lotti_video_loading);
            this.hZm.setFrame(0);
        }
    }

    private boolean bPt() {
        return this.mStyle == 1 ? q.bPt() : j.kZ();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            aXi();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.igQ = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.igR = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGH = videoInfo;
        this.mDuration = this.hGH.video_duration.intValue() * 1000;
        this.btD = new WeakReference<>(this.mContext.getApplicationContext());
        bXO();
        al.l(this, d.C0277d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.hGH.video_width.intValue() > 0 ? (this.hGH.video_height.intValue() * aO) / this.hGH.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.fWF.setDefaultErrorResource(0);
        this.fWF.setDefaultResource(0);
        this.fWF.setDefaultBgResource(d.f.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWF.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dbf.setOnPreparedListener(this.cJI);
        this.dbf.setOnErrorListener(this.cAo);
        this.dbf.setOnCompletionListener(this.cJH);
        this.dbf.setOnOutInfoListener(this.cJK);
        this.dbf.setOnSurfaceDestroyedListener(this.cAs);
        al.j(this.hGL, d.C0277d.cp_btn_a);
        al.k(this.hGL, d.f.video_play_count_bg);
        this.hGL.setText(StringUtils.translateSecondsToString(this.hGH.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.inJ = false;
            al.c(this.inD, d.f.ad_icon_sound_close);
        } else {
            this.inJ = true;
            al.c(this.inE, d.f.ad_icon_sound_open);
            this.inD.setVisibility(8);
        }
        this.inE.setOnClickListener(this.mOnClickListener);
        this.inD.setOnClickListener(this.mOnClickListener);
        this.hGP.setOnClickListener(this.mOnClickListener);
        this.hGP.setVisibility(8);
        al.l(this.hGP, d.C0277d.black_alpha80);
        al.j(this.inF, d.C0277d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hGL.setVisibility(0);
            return;
        }
        this.hGL.setVisibility(8);
        this.inH.setOnClickListener(this.mOnClickListener);
        this.hZm.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGH = videoInfo;
        this.btD = new WeakReference<>(this.mContext.getApplicationContext());
        bXO();
        al.l(this, d.C0277d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.fWF.setDefaultErrorResource(0);
        this.fWF.setDefaultResource(0);
        this.fWF.setDefaultBgResource(d.f.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWF.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dbf.setOnPreparedListener(this.cJI);
        this.dbf.setOnErrorListener(this.cAo);
        this.dbf.setOnCompletionListener(this.cJH);
        this.dbf.setOnOutInfoListener(this.cJK);
        this.dbf.setOnSurfaceDestroyedListener(this.cAs);
        al.j(this.hGL, d.C0277d.cp_btn_a);
        this.hGL.setText(StringUtils.translateSecondsToString(this.hGH.video_duration.intValue()));
        al.k(this.hGL, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.inJ = false;
            al.c(this.inD, d.f.ad_icon_sound_close);
        } else {
            this.inJ = true;
            al.c(this.inE, d.f.ad_icon_sound_open);
            this.inD.setVisibility(8);
        }
        this.inE.setOnClickListener(this.mOnClickListener);
        this.inD.setOnClickListener(this.mOnClickListener);
        this.hGP.setOnClickListener(this.mOnClickListener);
        this.hGP.setVisibility(8);
        al.l(this.hGP, d.C0277d.black_alpha80);
        al.j(this.inF, d.C0277d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hGL.setVisibility(0);
            return;
        }
        this.hGL.setVisibility(8);
        this.inH.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.ikh = this.ikg.a(this.igR, this.ikh);
        if (this.ikh != null) {
            this.ikh.setPageContext(this.mPageContext);
            this.ikh.c(this.inL);
            this.ikh.setAdvertAppInfo(advertAppInfo);
            this.ikh.a(this.igR);
            this.ikh.bXF();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.ikh != null) {
            this.ikh.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(d.e.ds16) + i;
        int intValue = videoInfo.video_height.intValue();
        int intValue2 = videoInfo.video_width.intValue();
        if (i <= 0 || intValue <= 0 || intValue2 <= 0) {
            k(this.mRootView, i2, i3);
            return true;
        }
        k(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void k(View view, int i, int i2) {
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
        this.cJH = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yc(int i) {
        this.inP = i;
        if (this.hGH != null && this.hGI == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.inK) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.ikh != null) {
                    this.ikh.bXF();
                }
                this.dbf.setVideoPath(this.hGH.video_url);
                this.dbf.start();
                this.inN = this.dbf.getCurrentPosition();
                al.c(this.inH, d.f.icon_video_midplay);
                startLoadingAnim();
                this.hGP.setVisibility(8);
                this.fWF.setForegroundDrawable(0);
                this.hGI = 0;
                if (this.mStyle == 1) {
                    this.hGL.setVisibility(0);
                } else {
                    this.hGL.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        yc(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bPt()) {
            if (i <= 0) {
                yc(1);
                return;
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hGX);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hGX, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hGI == 1) {
            A(32, yd(this.inP), this.dbf.getCurrentPosition(), i);
            this.dbf.pause();
            ad.a(this.btD, false);
            setLoadingAnimShow(true);
            al.c(this.inH, d.f.icon_video_midpause);
            this.hGI = 2;
        }
    }

    public void autoContinue() {
        if (!this.inM) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hGI == 2) {
            this.inP = i;
            ae(33, yd(i), this.dbf.getCurrentPosition());
            this.inN = this.dbf.getCurrentPosition();
            this.dbf.start();
            if (this.inJ) {
                ad.a(this.btD, true);
            }
            setLoadingAnimShow(false);
            al.c(this.inH, d.f.icon_video_midplay);
            this.hGI = 1;
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
        if (this.hZm != null) {
            this.hZm.setAlpha(1.0f);
            this.hZm.setVisibility(0);
            this.hZm.G(true);
            this.hZm.setMinAndMaxFrame(14, 80);
            this.hZm.cu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        bXN();
        if (z) {
            this.hZm.setAlpha(1.0f);
            this.hZm.setVisibility(0);
            return;
        }
        this.hZm.setVisibility(8);
    }

    private void bXN() {
        if (this.hZm != null) {
            this.hZm.setFrame(0);
            this.hZm.cancelAnimation();
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
        if (this.dbf.getCurrentPosition() > 0 && this.hGI != -1 && z) {
            int i = 32;
            int currentPosition = this.dbf.getCurrentPosition();
            if (this.dbf.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, yd(this.inP), currentPosition, this.dbf.isPlaying());
        }
        bXO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hGX);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.inQ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.dbf.stopPlayback();
        this.hGI = -1;
        ad.a(this.btD, false);
        this.fWF.setForegroundDrawable(0);
        this.fWF.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.inH, d.f.icon_video_midpause);
        this.inI.awG();
        this.hGP.setVisibility(8);
        if (this.hGH != null) {
            this.hGL.setText(StringUtils.translateSecondsToString(this.hGH.video_duration.intValue()));
        }
        this.ehx = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yd(int i) {
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
        return this.hGH != null ? this.hGH.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(boolean z) {
        if (z) {
            if (this.ehx != null) {
                this.ehx.setVolume(1.0f, 1.0f);
            }
            al.c(this.inE, d.f.ad_icon_sound_open);
            al.c(this.inD, d.f.ad_icon_sound_open);
            if (this.hGI == 1) {
                ad.a(this.btD, true);
            }
        } else {
            if (this.ehx != null) {
                this.ehx.setVolume(0.0f, 0.0f);
            }
            al.c(this.inE, d.f.ad_icon_sound_close);
            al.c(this.inD, d.f.ad_icon_sound_close);
            ad.a(this.btD, false);
        }
        this.inJ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hGI;
    }

    public VideoInfo getData() {
        return this.hGH;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hGR;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.inA && this.inz != null && this.inz.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.inB = advertAppInfo;
        this.inC = i;
        this.axL = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.inB, 303, i, yd(this.inP), this.hGH.video_duration.intValue(), this.mDuration, -1);
        if (this.ikh != null) {
            this.ikh.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, int i2, int i3) {
        A(i, i2, i3, -1);
    }

    private void h(int i, int i2, int i3, boolean z) {
        a(i, i2, i3, -1, z);
    }

    private void A(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, true);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.inB != null && this.hGH != null) {
            this.inB.page = this.axL;
            com.baidu.tieba.recapp.report.c.bXA().a(f.a(this.inB, i, this.inC, i2, this.hGH.video_duration.intValue(), a.lz(i3), i4));
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
                if ("DETAIL".equals(this.axL)) {
                    str2 = "det";
                } else if ("FRS".equals(this.axL)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.axL)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.inN, i3, this.mDuration, str2, ye(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.igQ != null && "cpv".equals(this.igQ.ihN) && !TextUtils.isEmpty(this.igQ.ihO)) {
            new com.baidu.tieba.recapp.request.a(this.igQ.ihO).a(str, i, i2, i3, str2, str3);
        }
    }

    private String ye(int i) {
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
            this.inz = view;
            this.inA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.inQ);
            if (this.afd != null) {
                this.afd.cancel();
            }
            this.inG.setVisibility(0);
            if (this.hGI == 1) {
                al.c(this.inH, d.f.icon_video_midplay);
                return;
            } else {
                al.c(this.inH, d.f.icon_video_midpause);
                return;
            }
        }
        this.inG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXP() {
        switch (this.hGI) {
            case -1:
                if (!j.kY() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.j.neterror);
                    return;
                } else if (!j.kZ() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.gC(d.j.play_video_mobile_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            DistributeVideoView.this.performPlay();
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(this.mPageContext).aaW();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.inM = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    pr(true);
                    return;
                }
                return;
            case 2:
                this.inM = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.inQ);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.inQ, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXQ() {
        if (!this.bib && this.afd != null) {
            this.inG.startAnimation(this.afd);
            this.bib = true;
        }
    }

    private void aXi() {
        if (this.mPageContext != null) {
            this.afd = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.afd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.inG.setVisibility(8);
                    DistributeVideoView.this.bib = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
