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
    private String aSz;
    private Animation afe;
    private String axM;
    boolean bic;
    private WeakReference<Context> btE;
    private g.b cAp;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.e cJL;
    private QuickVideoView dbg;
    private g ehy;
    private ForeDrawableImageView fWF;
    private VideoInfo hGI;
    private int hGJ;
    private TextView hGM;
    private View hGQ;
    private long hGS;
    private Runnable hGY;
    private TBLottieAnimationView hZn;
    private AdCard.a igR;
    private AdCard.f igS;
    private ViewGroup ikg;
    private d ikh;
    private e iki;
    private View inA;
    private boolean inB;
    private AdvertAppInfo inC;
    private int inD;
    private ImageView inE;
    private ImageView inF;
    private TextView inG;
    private View inH;
    private ImageView inI;
    private VideoControllerView inJ;
    private boolean inK;
    private long inL;
    private b inM;
    boolean inN;
    private int inO;
    boolean inP;
    private int inQ;
    private Runnable inR;
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
        if (this.hZn != null) {
            this.hZn.clearAnimation();
            this.hZn.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.hZn.setVisibility(8);
                    DistributeVideoView.this.fWF.setVisibility(8);
                    DistributeVideoView.this.pq(DistributeVideoView.this.inK);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mHandler.removeMessages(1002);
                        DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                    } else {
                        DistributeVideoView.this.inJ.setPlayer(DistributeVideoView.this.dbg);
                        DistributeVideoView.this.inJ.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hGI.video_duration.intValue()));
                        DistributeVideoView.this.inJ.showProgress();
                        DistributeVideoView.this.pr(true);
                        com.baidu.adp.lib.g.e.jH().removeCallbacks(DistributeVideoView.this.inR);
                        com.baidu.adp.lib.g.e.jH().postDelayed(DistributeVideoView.this.inR, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hGS = DistributeVideoView.this.dbg.getCurrentPosition();
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.hZn.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.inB = false;
        this.btE = null;
        this.hGJ = -1;
        this.hGS = 0L;
        this.inK = false;
        this.inL = 0L;
        this.mStyle = 1;
        this.bic = false;
        this.inN = false;
        this.inP = false;
        this.inQ = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hGQ) {
                    DistributeVideoView.this.hGQ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inF || view == DistributeVideoView.this.inE) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inK ? false : true);
                } else if (view == DistributeVideoView.this.hZn || view == DistributeVideoView.this.inI) {
                    DistributeVideoView.this.bXP();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inC == null || !DistributeVideoView.this.inC.WZ()) {
                    DistributeVideoView.this.bXP();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inC != null) {
                        WebVideoActivity.igL = new WebVideoActivity.a();
                        WebVideoActivity.igL.igV = DistributeVideoView.this.inC;
                        WebVideoActivity.igL.axM = "DETAIL";
                        WebVideoActivity.igL.mPageNum = DistributeVideoView.this.inD;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSz) ? DistributeVideoView.this.aSz : DistributeVideoView.this.inC.bwJ, true, true, true, DistributeVideoView.this.hGI.video_url, DistributeVideoView.this.hGI.thumbnail_url, DistributeVideoView.this.hGI.video_width.intValue() / DistributeVideoView.this.hGI.video_height.intValue(), DistributeVideoView.this.hGI.video_duration.intValue());
                    if (DistributeVideoView.this.igR != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.igR.ihO);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.igR.ihP);
                    }
                    if (DistributeVideoView.this.igS != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.igS.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xY(DistributeVideoView.this.parallelChargeInfo.gGs);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGv.iterator();
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
                        if (DistributeVideoView.this.hGJ != 1) {
                            if (DistributeVideoView.this.dbg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGJ = 1;
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbg.getDuration() - DistributeVideoView.this.dbg.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGM.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGJ == 1) {
                            if (DistributeVideoView.this.hGS == DistributeVideoView.this.dbg.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hGS = DistributeVideoView.this.dbg.getCurrentPosition();
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.inO = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehy = gVar;
                    DistributeVideoView.this.ehy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inC != null) {
                    if (DistributeVideoView.this.inP && "DETAIL".equals(DistributeVideoView.this.inC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), 0);
                }
                return false;
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXO();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), gVar.getCurrentPosition());
                DistributeVideoView.this.fWF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hGQ.setVisibility(0);
                return true;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.inL = System.currentTimeMillis();
                DistributeVideoView.this.inP = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), gVar.getDuration());
                DistributeVideoView.this.bXO();
                if (DistributeVideoView.this.iki != null) {
                    DistributeVideoView.this.iki.bXE();
                    DistributeVideoView.this.hGM.setVisibility(8);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hGY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGI != null && DistributeVideoView.this.dbg != null) {
                    DistributeVideoView.this.yc(1);
                }
            }
        };
        this.inR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXQ();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inB = false;
        this.btE = null;
        this.hGJ = -1;
        this.hGS = 0L;
        this.inK = false;
        this.inL = 0L;
        this.mStyle = 1;
        this.bic = false;
        this.inN = false;
        this.inP = false;
        this.inQ = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hGQ) {
                    DistributeVideoView.this.hGQ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inF || view == DistributeVideoView.this.inE) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inK ? false : true);
                } else if (view == DistributeVideoView.this.hZn || view == DistributeVideoView.this.inI) {
                    DistributeVideoView.this.bXP();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inC == null || !DistributeVideoView.this.inC.WZ()) {
                    DistributeVideoView.this.bXP();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inC != null) {
                        WebVideoActivity.igL = new WebVideoActivity.a();
                        WebVideoActivity.igL.igV = DistributeVideoView.this.inC;
                        WebVideoActivity.igL.axM = "DETAIL";
                        WebVideoActivity.igL.mPageNum = DistributeVideoView.this.inD;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSz) ? DistributeVideoView.this.aSz : DistributeVideoView.this.inC.bwJ, true, true, true, DistributeVideoView.this.hGI.video_url, DistributeVideoView.this.hGI.thumbnail_url, DistributeVideoView.this.hGI.video_width.intValue() / DistributeVideoView.this.hGI.video_height.intValue(), DistributeVideoView.this.hGI.video_duration.intValue());
                    if (DistributeVideoView.this.igR != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.igR.ihO);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.igR.ihP);
                    }
                    if (DistributeVideoView.this.igS != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.igS.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xY(DistributeVideoView.this.parallelChargeInfo.gGs);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGv.iterator();
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
                        if (DistributeVideoView.this.hGJ != 1) {
                            if (DistributeVideoView.this.dbg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGJ = 1;
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbg.getDuration() - DistributeVideoView.this.dbg.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGM.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGJ == 1) {
                            if (DistributeVideoView.this.hGS == DistributeVideoView.this.dbg.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hGS = DistributeVideoView.this.dbg.getCurrentPosition();
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.inO = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehy = gVar;
                    DistributeVideoView.this.ehy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inC != null) {
                    if (DistributeVideoView.this.inP && "DETAIL".equals(DistributeVideoView.this.inC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), 0);
                }
                return false;
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXO();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), gVar.getCurrentPosition());
                DistributeVideoView.this.fWF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hGQ.setVisibility(0);
                return true;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.inL = System.currentTimeMillis();
                DistributeVideoView.this.inP = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), gVar.getDuration());
                DistributeVideoView.this.bXO();
                if (DistributeVideoView.this.iki != null) {
                    DistributeVideoView.this.iki.bXE();
                    DistributeVideoView.this.hGM.setVisibility(8);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hGY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGI != null && DistributeVideoView.this.dbg != null) {
                    DistributeVideoView.this.yc(1);
                }
            }
        };
        this.inR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXQ();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inB = false;
        this.btE = null;
        this.hGJ = -1;
        this.hGS = 0L;
        this.inK = false;
        this.inL = 0L;
        this.mStyle = 1;
        this.bic = false;
        this.inN = false;
        this.inP = false;
        this.inQ = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hGQ) {
                    DistributeVideoView.this.hGQ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inF || view == DistributeVideoView.this.inE) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inK ? false : true);
                } else if (view == DistributeVideoView.this.hZn || view == DistributeVideoView.this.inI) {
                    DistributeVideoView.this.bXP();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inC == null || !DistributeVideoView.this.inC.WZ()) {
                    DistributeVideoView.this.bXP();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inC != null) {
                        WebVideoActivity.igL = new WebVideoActivity.a();
                        WebVideoActivity.igL.igV = DistributeVideoView.this.inC;
                        WebVideoActivity.igL.axM = "DETAIL";
                        WebVideoActivity.igL.mPageNum = DistributeVideoView.this.inD;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSz) ? DistributeVideoView.this.aSz : DistributeVideoView.this.inC.bwJ, true, true, true, DistributeVideoView.this.hGI.video_url, DistributeVideoView.this.hGI.thumbnail_url, DistributeVideoView.this.hGI.video_width.intValue() / DistributeVideoView.this.hGI.video_height.intValue(), DistributeVideoView.this.hGI.video_duration.intValue());
                    if (DistributeVideoView.this.igR != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.igR.ihO);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.igR.ihP);
                    }
                    if (DistributeVideoView.this.igS != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.igS.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xY(DistributeVideoView.this.parallelChargeInfo.gGs);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGv.iterator();
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
                        if (DistributeVideoView.this.hGJ != 1) {
                            if (DistributeVideoView.this.dbg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGJ = 1;
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbg.getDuration() - DistributeVideoView.this.dbg.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGM.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGJ == 1) {
                            if (DistributeVideoView.this.hGS == DistributeVideoView.this.dbg.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hGS = DistributeVideoView.this.dbg.getCurrentPosition();
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
        this.cJJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.inO = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehy = gVar;
                    DistributeVideoView.this.ehy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.inC != null) {
                    if (DistributeVideoView.this.inP && "DETAIL".equals(DistributeVideoView.this.inC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), 0);
                }
                return false;
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bXO();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), gVar.getCurrentPosition());
                DistributeVideoView.this.fWF.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hGQ.setVisibility(0);
                return true;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.inL = System.currentTimeMillis();
                DistributeVideoView.this.inP = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yd(DistributeVideoView.this.inQ), gVar.getDuration());
                DistributeVideoView.this.bXO();
                if (DistributeVideoView.this.iki != null) {
                    DistributeVideoView.this.iki.bXE();
                    DistributeVideoView.this.hGM.setVisibility(8);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hGY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGI != null && DistributeVideoView.this.dbg != null) {
                    DistributeVideoView.this.yc(1);
                }
            }
        };
        this.inR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXQ();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aSz = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.inM = adCard;
        if (this.inM != null) {
            this.parallelChargeInfo = this.inM.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.dbg = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.hZn = (TBLottieAnimationView) this.mRootView.findViewById(d.g.video_play);
            this.fWF = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.hGM = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.hGQ = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.inG = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.inE = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.inH = this.mRootView.findViewById(d.g.distribute_control);
            this.inI = (ImageView) this.inH.findViewById(d.g.distribute_play_icon);
            this.inF = (ImageView) this.inH.findViewById(d.g.distribute_voice);
            this.inJ = (VideoControllerView) this.inH.findViewById(d.g.distribute_process);
            this.ikg = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.ikh = new com.baidu.tieba.recapp.e.d(context, this.ikg);
            this.hZn.setAnimation(d.i.lotti_video_loading);
            this.hZn.setFrame(0);
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
        this.igR = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.igS = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGI = videoInfo;
        this.mDuration = this.hGI.video_duration.intValue() * 1000;
        this.btE = new WeakReference<>(this.mContext.getApplicationContext());
        bXO();
        al.l(this, d.C0277d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.hGI.video_width.intValue() > 0 ? (this.hGI.video_height.intValue() * aO) / this.hGI.video_width.intValue() : aO;
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
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnErrorListener(this.cAp);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        al.j(this.hGM, d.C0277d.cp_btn_a);
        al.k(this.hGM, d.f.video_play_count_bg);
        this.hGM.setText(StringUtils.translateSecondsToString(this.hGI.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.inK = false;
            al.c(this.inE, d.f.ad_icon_sound_close);
        } else {
            this.inK = true;
            al.c(this.inF, d.f.ad_icon_sound_open);
            this.inE.setVisibility(8);
        }
        this.inF.setOnClickListener(this.mOnClickListener);
        this.inE.setOnClickListener(this.mOnClickListener);
        this.hGQ.setOnClickListener(this.mOnClickListener);
        this.hGQ.setVisibility(8);
        al.l(this.hGQ, d.C0277d.black_alpha80);
        al.j(this.inG, d.C0277d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hGM.setVisibility(0);
            return;
        }
        this.hGM.setVisibility(8);
        this.inI.setOnClickListener(this.mOnClickListener);
        this.hZn.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGI = videoInfo;
        this.btE = new WeakReference<>(this.mContext.getApplicationContext());
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
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnErrorListener(this.cAp);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        al.j(this.hGM, d.C0277d.cp_btn_a);
        this.hGM.setText(StringUtils.translateSecondsToString(this.hGI.video_duration.intValue()));
        al.k(this.hGM, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.inK = false;
            al.c(this.inE, d.f.ad_icon_sound_close);
        } else {
            this.inK = true;
            al.c(this.inF, d.f.ad_icon_sound_open);
            this.inE.setVisibility(8);
        }
        this.inF.setOnClickListener(this.mOnClickListener);
        this.inE.setOnClickListener(this.mOnClickListener);
        this.hGQ.setOnClickListener(this.mOnClickListener);
        this.hGQ.setVisibility(8);
        al.l(this.hGQ, d.C0277d.black_alpha80);
        al.j(this.inG, d.C0277d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hGM.setVisibility(0);
            return;
        }
        this.hGM.setVisibility(8);
        this.inI.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.iki = this.ikh.a(this.igS, this.iki);
        if (this.iki != null) {
            this.iki.setPageContext(this.mPageContext);
            this.iki.c(this.inM);
            this.iki.setAdvertAppInfo(advertAppInfo);
            this.iki.a(this.igS);
            this.iki.bXF();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.iki != null) {
            this.iki.setDownloadAppCallback(cVar);
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
        this.cJI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yc(int i) {
        this.inQ = i;
        if (this.hGI != null && this.hGJ == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.inL) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.iki != null) {
                    this.iki.bXF();
                }
                this.dbg.setVideoPath(this.hGI.video_url);
                this.dbg.start();
                this.inO = this.dbg.getCurrentPosition();
                al.c(this.inI, d.f.icon_video_midplay);
                startLoadingAnim();
                this.hGQ.setVisibility(8);
                this.fWF.setForegroundDrawable(0);
                this.hGJ = 0;
                if (this.mStyle == 1) {
                    this.hGM.setVisibility(0);
                } else {
                    this.hGM.setVisibility(8);
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
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hGY);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hGY, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hGJ == 1) {
            A(32, yd(this.inQ), this.dbg.getCurrentPosition(), i);
            this.dbg.pause();
            ad.a(this.btE, false);
            setLoadingAnimShow(true);
            al.c(this.inI, d.f.icon_video_midpause);
            this.hGJ = 2;
        }
    }

    public void autoContinue() {
        if (!this.inN) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hGJ == 2) {
            this.inQ = i;
            ae(33, yd(i), this.dbg.getCurrentPosition());
            this.inO = this.dbg.getCurrentPosition();
            this.dbg.start();
            if (this.inK) {
                ad.a(this.btE, true);
            }
            setLoadingAnimShow(false);
            al.c(this.inI, d.f.icon_video_midplay);
            this.hGJ = 1;
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
        if (this.hZn != null) {
            this.hZn.setAlpha(1.0f);
            this.hZn.setVisibility(0);
            this.hZn.G(true);
            this.hZn.setMinAndMaxFrame(14, 80);
            this.hZn.cu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        bXN();
        if (z) {
            this.hZn.setAlpha(1.0f);
            this.hZn.setVisibility(0);
            return;
        }
        this.hZn.setVisibility(8);
    }

    private void bXN() {
        if (this.hZn != null) {
            this.hZn.setFrame(0);
            this.hZn.cancelAnimation();
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
        if (this.dbg.getCurrentPosition() > 0 && this.hGJ != -1 && z) {
            int i = 32;
            int currentPosition = this.dbg.getCurrentPosition();
            if (this.dbg.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, yd(this.inQ), currentPosition, this.dbg.isPlaying());
        }
        bXO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hGY);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.inR);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.dbg.stopPlayback();
        this.hGJ = -1;
        ad.a(this.btE, false);
        this.fWF.setForegroundDrawable(0);
        this.fWF.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.inI, d.f.icon_video_midpause);
        this.inJ.awG();
        this.hGQ.setVisibility(8);
        if (this.hGI != null) {
            this.hGM.setText(StringUtils.translateSecondsToString(this.hGI.video_duration.intValue()));
        }
        this.ehy = null;
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
        return this.hGI != null ? this.hGI.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(boolean z) {
        if (z) {
            if (this.ehy != null) {
                this.ehy.setVolume(1.0f, 1.0f);
            }
            al.c(this.inF, d.f.ad_icon_sound_open);
            al.c(this.inE, d.f.ad_icon_sound_open);
            if (this.hGJ == 1) {
                ad.a(this.btE, true);
            }
        } else {
            if (this.ehy != null) {
                this.ehy.setVolume(0.0f, 0.0f);
            }
            al.c(this.inF, d.f.ad_icon_sound_close);
            al.c(this.inE, d.f.ad_icon_sound_close);
            ad.a(this.btE, false);
        }
        this.inK = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hGJ;
    }

    public VideoInfo getData() {
        return this.hGI;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hGS;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.inB && this.inA != null && this.inA.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.inC = advertAppInfo;
        this.inD = i;
        this.axM = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.inC, 303, i, yd(this.inQ), this.hGI.video_duration.intValue(), this.mDuration, -1);
        if (this.iki != null) {
            this.iki.e(a);
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
        if (this.inC != null && this.hGI != null) {
            this.inC.page = this.axM;
            com.baidu.tieba.recapp.report.c.bXA().a(f.a(this.inC, i, this.inD, i2, this.hGI.video_duration.intValue(), a.lz(i3), i4));
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
                if ("DETAIL".equals(this.axM)) {
                    str2 = "det";
                } else if ("FRS".equals(this.axM)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.axM)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.inO, i3, this.mDuration, str2, ye(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.igR != null && "cpv".equals(this.igR.ihO) && !TextUtils.isEmpty(this.igR.ihP)) {
            new com.baidu.tieba.recapp.request.a(this.igR.ihP).a(str, i, i2, i3, str2, str3);
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
            this.inA = view;
            this.inB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.inR);
            if (this.afe != null) {
                this.afe.cancel();
            }
            this.inH.setVisibility(0);
            if (this.hGJ == 1) {
                al.c(this.inI, d.f.icon_video_midplay);
                return;
            } else {
                al.c(this.inI, d.f.icon_video_midpause);
                return;
            }
        }
        this.inH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXP() {
        switch (this.hGJ) {
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
                this.inN = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    pr(true);
                    return;
                }
                return;
            case 2:
                this.inN = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.inR);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.inR, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXQ() {
        if (!this.bic && this.afe != null) {
            this.inH.startAnimation(this.afe);
            this.bic = true;
        }
    }

    private void aXi() {
        if (this.mPageContext != null) {
            this.afe = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.afe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.inH.setVisibility(8);
                    DistributeVideoView.this.bic = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
