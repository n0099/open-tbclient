package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
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
    private String aSu;
    private Animation aeX;
    private String axH;
    boolean bhX;
    private WeakReference<Context> bty;
    private g.b cAp;
    private QuickVideoView.b cAt;
    private g.a cJI;
    private g.f cJJ;
    private g.e cJL;
    private QuickVideoView dbg;
    private g ehP;
    private ForeDrawableImageView fWR;
    private VideoInfo hHa;
    private int hHb;
    private TextView hHe;
    private View hHi;
    private long hHk;
    private Runnable hHq;
    private TBLottieAnimationView hZF;
    private AdCard.a ihj;
    private AdCard.f ihk;
    private d ikA;
    private e ikB;
    private ViewGroup ikz;
    private View inV;
    private boolean inW;
    private AdvertAppInfo inX;
    private int inY;
    private ImageView inZ;
    private ImageView ioa;
    private TextView iob;
    private View ioc;
    private ImageView iod;
    private VideoControllerView ioe;
    private boolean iof;
    private long iog;
    private b ioh;
    boolean ioi;
    private int ioj;
    boolean iok;
    private int iol;
    private Runnable iom;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void bUe() {
        if (this.hZF != null) {
            this.hZF.clearAnimation();
            this.hZF.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.hZF.setVisibility(8);
                    DistributeVideoView.this.fWR.setVisibility(8);
                    DistributeVideoView.this.pq(DistributeVideoView.this.iof);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mHandler.removeMessages(1002);
                        DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                    } else {
                        DistributeVideoView.this.ioe.setPlayer(DistributeVideoView.this.dbg);
                        DistributeVideoView.this.ioe.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hHa.video_duration.intValue()));
                        DistributeVideoView.this.ioe.showProgress();
                        DistributeVideoView.this.pr(true);
                        com.baidu.adp.lib.g.e.jH().removeCallbacks(DistributeVideoView.this.iom);
                        com.baidu.adp.lib.g.e.jH().postDelayed(DistributeVideoView.this.iom, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hHk = DistributeVideoView.this.dbg.getCurrentPosition();
                    DistributeVideoView.this.mHandler.removeMessages(PointerIconCompat.TYPE_HELP);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.hZF.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.inW = false;
        this.bty = null;
        this.hHb = -1;
        this.hHk = 0L;
        this.iof = false;
        this.iog = 0L;
        this.mStyle = 1;
        this.bhX = false;
        this.ioi = false;
        this.iok = false;
        this.iol = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hHi) {
                    DistributeVideoView.this.hHi.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.ioa || view == DistributeVideoView.this.inZ) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.iof ? false : true);
                } else if (view == DistributeVideoView.this.hZF || view == DistributeVideoView.this.iod) {
                    DistributeVideoView.this.bXQ();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inX == null || !DistributeVideoView.this.inX.Xc()) {
                    DistributeVideoView.this.bXQ();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inX != null) {
                        WebVideoActivity.ihd = new WebVideoActivity.a();
                        WebVideoActivity.ihd.ihn = DistributeVideoView.this.inX;
                        WebVideoActivity.ihd.axH = "DETAIL";
                        WebVideoActivity.ihd.mPageNum = DistributeVideoView.this.inY;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSu) ? DistributeVideoView.this.aSu : DistributeVideoView.this.inX.bwD, true, true, true, DistributeVideoView.this.hHa.video_url, DistributeVideoView.this.hHa.thumbnail_url, DistributeVideoView.this.hHa.video_width.intValue() / DistributeVideoView.this.hHa.video_height.intValue(), DistributeVideoView.this.hHa.video_duration.intValue());
                    if (DistributeVideoView.this.ihj != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.ihj.iig);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.ihj.iih);
                    }
                    if (DistributeVideoView.this.ihk != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.ihk.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.ya(DistributeVideoView.this.parallelChargeInfo.gGE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGH.iterator();
                        while (it.hasNext()) {
                            c.ya(it.next());
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
                        if (DistributeVideoView.this.hHb != 1) {
                            if (DistributeVideoView.this.dbg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hHb = 1;
                                DistributeVideoView.this.bUe();
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
                            DistributeVideoView.this.hHe.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                        if (DistributeVideoView.this.hHb == 1) {
                            if (DistributeVideoView.this.hHk == DistributeVideoView.this.dbg.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hHk = DistributeVideoView.this.dbg.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, TimeUnit.SECONDS.toMillis(3L));
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
                    DistributeVideoView.this.ioj = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehP = gVar;
                    DistributeVideoView.this.ehP.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inX != null) {
                    if (DistributeVideoView.this.iok && "DETAIL".equals(DistributeVideoView.this.inX.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yh(DistributeVideoView.this.iol), 0);
                }
                return false;
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXP();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yh(DistributeVideoView.this.iol), gVar.getCurrentPosition());
                DistributeVideoView.this.fWR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hHi.setVisibility(0);
                return true;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iog = System.currentTimeMillis();
                DistributeVideoView.this.iok = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yh(DistributeVideoView.this.iol), gVar.getDuration());
                DistributeVideoView.this.bXP();
                if (DistributeVideoView.this.ikB != null) {
                    DistributeVideoView.this.ikB.bXF();
                    DistributeVideoView.this.hHe.setVisibility(8);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hHq = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hHa != null && DistributeVideoView.this.dbg != null) {
                    DistributeVideoView.this.yg(1);
                }
            }
        };
        this.iom = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXR();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inW = false;
        this.bty = null;
        this.hHb = -1;
        this.hHk = 0L;
        this.iof = false;
        this.iog = 0L;
        this.mStyle = 1;
        this.bhX = false;
        this.ioi = false;
        this.iok = false;
        this.iol = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hHi) {
                    DistributeVideoView.this.hHi.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.ioa || view == DistributeVideoView.this.inZ) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.iof ? false : true);
                } else if (view == DistributeVideoView.this.hZF || view == DistributeVideoView.this.iod) {
                    DistributeVideoView.this.bXQ();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inX == null || !DistributeVideoView.this.inX.Xc()) {
                    DistributeVideoView.this.bXQ();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inX != null) {
                        WebVideoActivity.ihd = new WebVideoActivity.a();
                        WebVideoActivity.ihd.ihn = DistributeVideoView.this.inX;
                        WebVideoActivity.ihd.axH = "DETAIL";
                        WebVideoActivity.ihd.mPageNum = DistributeVideoView.this.inY;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSu) ? DistributeVideoView.this.aSu : DistributeVideoView.this.inX.bwD, true, true, true, DistributeVideoView.this.hHa.video_url, DistributeVideoView.this.hHa.thumbnail_url, DistributeVideoView.this.hHa.video_width.intValue() / DistributeVideoView.this.hHa.video_height.intValue(), DistributeVideoView.this.hHa.video_duration.intValue());
                    if (DistributeVideoView.this.ihj != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.ihj.iig);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.ihj.iih);
                    }
                    if (DistributeVideoView.this.ihk != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.ihk.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.ya(DistributeVideoView.this.parallelChargeInfo.gGE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGH.iterator();
                        while (it.hasNext()) {
                            c.ya(it.next());
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
                        if (DistributeVideoView.this.hHb != 1) {
                            if (DistributeVideoView.this.dbg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hHb = 1;
                                DistributeVideoView.this.bUe();
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
                            DistributeVideoView.this.hHe.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                        if (DistributeVideoView.this.hHb == 1) {
                            if (DistributeVideoView.this.hHk == DistributeVideoView.this.dbg.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hHk = DistributeVideoView.this.dbg.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, TimeUnit.SECONDS.toMillis(3L));
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
                    DistributeVideoView.this.ioj = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehP = gVar;
                    DistributeVideoView.this.ehP.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inX != null) {
                    if (DistributeVideoView.this.iok && "DETAIL".equals(DistributeVideoView.this.inX.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yh(DistributeVideoView.this.iol), 0);
                }
                return false;
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXP();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yh(DistributeVideoView.this.iol), gVar.getCurrentPosition());
                DistributeVideoView.this.fWR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hHi.setVisibility(0);
                return true;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iog = System.currentTimeMillis();
                DistributeVideoView.this.iok = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yh(DistributeVideoView.this.iol), gVar.getDuration());
                DistributeVideoView.this.bXP();
                if (DistributeVideoView.this.ikB != null) {
                    DistributeVideoView.this.ikB.bXF();
                    DistributeVideoView.this.hHe.setVisibility(8);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hHq = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hHa != null && DistributeVideoView.this.dbg != null) {
                    DistributeVideoView.this.yg(1);
                }
            }
        };
        this.iom = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXR();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inW = false;
        this.bty = null;
        this.hHb = -1;
        this.hHk = 0L;
        this.iof = false;
        this.iog = 0L;
        this.mStyle = 1;
        this.bhX = false;
        this.ioi = false;
        this.iok = false;
        this.iol = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hHi) {
                    DistributeVideoView.this.hHi.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.ioa || view == DistributeVideoView.this.inZ) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.iof ? false : true);
                } else if (view == DistributeVideoView.this.hZF || view == DistributeVideoView.this.iod) {
                    DistributeVideoView.this.bXQ();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inX == null || !DistributeVideoView.this.inX.Xc()) {
                    DistributeVideoView.this.bXQ();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inX != null) {
                        WebVideoActivity.ihd = new WebVideoActivity.a();
                        WebVideoActivity.ihd.ihn = DistributeVideoView.this.inX;
                        WebVideoActivity.ihd.axH = "DETAIL";
                        WebVideoActivity.ihd.mPageNum = DistributeVideoView.this.inY;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSu) ? DistributeVideoView.this.aSu : DistributeVideoView.this.inX.bwD, true, true, true, DistributeVideoView.this.hHa.video_url, DistributeVideoView.this.hHa.thumbnail_url, DistributeVideoView.this.hHa.video_width.intValue() / DistributeVideoView.this.hHa.video_height.intValue(), DistributeVideoView.this.hHa.video_duration.intValue());
                    if (DistributeVideoView.this.ihj != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.ihj.iig);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.ihj.iih);
                    }
                    if (DistributeVideoView.this.ihk != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.ihk.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.ya(DistributeVideoView.this.parallelChargeInfo.gGE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGH.iterator();
                        while (it.hasNext()) {
                            c.ya(it.next());
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
                        if (DistributeVideoView.this.hHb != 1) {
                            if (DistributeVideoView.this.dbg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hHb = 1;
                                DistributeVideoView.this.bUe();
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
                            DistributeVideoView.this.hHe.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                        if (DistributeVideoView.this.hHb == 1) {
                            if (DistributeVideoView.this.hHk == DistributeVideoView.this.dbg.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hHk = DistributeVideoView.this.dbg.getCurrentPosition();
                                DistributeVideoView.this.setLoadingAnimShow(false);
                            }
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(PointerIconCompat.TYPE_HELP, TimeUnit.SECONDS.toMillis(3L));
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
                    DistributeVideoView.this.ioj = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehP = gVar;
                    DistributeVideoView.this.ehP.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.inX != null) {
                    if (DistributeVideoView.this.iok && "DETAIL".equals(DistributeVideoView.this.inX.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yh(DistributeVideoView.this.iol), 0);
                }
                return false;
            }
        };
        this.cAp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bXP();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yh(DistributeVideoView.this.iol), gVar.getCurrentPosition());
                DistributeVideoView.this.fWR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hHi.setVisibility(0);
                return true;
            }
        };
        this.cJI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.iog = System.currentTimeMillis();
                DistributeVideoView.this.iok = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yh(DistributeVideoView.this.iol), gVar.getDuration());
                DistributeVideoView.this.bXP();
                if (DistributeVideoView.this.ikB != null) {
                    DistributeVideoView.this.ikB.bXF();
                    DistributeVideoView.this.hHe.setVisibility(8);
                }
            }
        };
        this.cAt = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hHq = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hHa != null && DistributeVideoView.this.dbg != null) {
                    DistributeVideoView.this.yg(1);
                }
            }
        };
        this.iom = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXR();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aSu = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.ioh = adCard;
        if (this.ioh != null) {
            this.parallelChargeInfo = this.ioh.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.dbg = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.hZF = (TBLottieAnimationView) this.mRootView.findViewById(d.g.video_play);
            this.fWR = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.hHe = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.hHi = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.iob = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.inZ = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.ioc = this.mRootView.findViewById(d.g.distribute_control);
            this.iod = (ImageView) this.ioc.findViewById(d.g.distribute_play_icon);
            this.ioa = (ImageView) this.ioc.findViewById(d.g.distribute_voice);
            this.ioe = (VideoControllerView) this.ioc.findViewById(d.g.distribute_process);
            this.ikz = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.ikA = new com.baidu.tieba.recapp.e.d(context, this.ikz);
            this.hZF.setAnimation(d.i.lotti_video_loading);
            this.hZF.setFrame(0);
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
            aXk();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.ihj = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.ihk = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hHa = videoInfo;
        this.mDuration = this.hHa.video_duration.intValue() * 1000;
        this.bty = new WeakReference<>(this.mContext.getApplicationContext());
        bXP();
        al.l(this, d.C0236d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.hHa.video_width.intValue() > 0 ? (this.hHa.video_height.intValue() * aO) / this.hHa.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        this.fWR.setDefaultErrorResource(0);
        this.fWR.setDefaultResource(0);
        this.fWR.setDefaultBgResource(d.f.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWR.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnErrorListener(this.cAp);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        al.j(this.hHe, d.C0236d.cp_btn_a);
        al.k(this.hHe, d.f.video_play_count_bg);
        this.hHe.setText(StringUtils.translateSecondsToString(this.hHa.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.iof = false;
            al.c(this.inZ, d.f.ad_icon_sound_close);
        } else {
            this.iof = true;
            al.c(this.ioa, d.f.ad_icon_sound_open);
            this.inZ.setVisibility(8);
        }
        this.ioa.setOnClickListener(this.mOnClickListener);
        this.inZ.setOnClickListener(this.mOnClickListener);
        this.hHi.setOnClickListener(this.mOnClickListener);
        this.hHi.setVisibility(8);
        al.l(this.hHi, d.C0236d.black_alpha80);
        al.j(this.iob, d.C0236d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hHe.setVisibility(0);
            return;
        }
        this.hHe.setVisibility(8);
        this.iod.setOnClickListener(this.mOnClickListener);
        this.hZF.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hHa = videoInfo;
        this.bty = new WeakReference<>(this.mContext.getApplicationContext());
        bXP();
        al.l(this, d.C0236d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        this.fWR.setDefaultErrorResource(0);
        this.fWR.setDefaultResource(0);
        this.fWR.setDefaultBgResource(d.f.pic_bg_video_frs);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.fWR.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.dbg.setOnPreparedListener(this.cJJ);
        this.dbg.setOnErrorListener(this.cAp);
        this.dbg.setOnCompletionListener(this.cJI);
        this.dbg.setOnOutInfoListener(this.cJL);
        this.dbg.setOnSurfaceDestroyedListener(this.cAt);
        al.j(this.hHe, d.C0236d.cp_btn_a);
        this.hHe.setText(StringUtils.translateSecondsToString(this.hHa.video_duration.intValue()));
        al.k(this.hHe, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.iof = false;
            al.c(this.inZ, d.f.ad_icon_sound_close);
        } else {
            this.iof = true;
            al.c(this.ioa, d.f.ad_icon_sound_open);
            this.inZ.setVisibility(8);
        }
        this.ioa.setOnClickListener(this.mOnClickListener);
        this.inZ.setOnClickListener(this.mOnClickListener);
        this.hHi.setOnClickListener(this.mOnClickListener);
        this.hHi.setVisibility(8);
        al.l(this.hHi, d.C0236d.black_alpha80);
        al.j(this.iob, d.C0236d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hHe.setVisibility(0);
            return;
        }
        this.hHe.setVisibility(8);
        this.iod.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.ikB = this.ikA.a(this.ihk, this.ikB);
        if (this.ikB != null) {
            this.ikB.setPageContext(this.mPageContext);
            this.ikB.c(this.ioh);
            this.ikB.setAdvertAppInfo(advertAppInfo);
            this.ikB.a(this.ihk);
            this.ikB.bXG();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.ikB != null) {
            this.ikB.setDownloadAppCallback(cVar);
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
    public void yg(int i) {
        this.iol = i;
        if (this.hHa != null && this.hHb == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.iog) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.ikB != null) {
                    this.ikB.bXG();
                }
                this.dbg.setVideoPath(this.hHa.video_url);
                this.dbg.start();
                this.ioj = this.dbg.getCurrentPosition();
                al.c(this.iod, d.f.icon_video_midplay);
                startLoadingAnim();
                this.hHi.setVisibility(8);
                this.fWR.setForegroundDrawable(0);
                this.hHb = 0;
                if (this.mStyle == 1) {
                    this.hHe.setVisibility(0);
                } else {
                    this.hHe.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        yg(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bPt()) {
            if (i <= 0) {
                yg(1);
                return;
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hHq);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hHq, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hHb == 1) {
            A(32, yh(this.iol), this.dbg.getCurrentPosition(), i);
            this.dbg.pause();
            ad.a(this.bty, false);
            setLoadingAnimShow(true);
            al.c(this.iod, d.f.icon_video_midpause);
            this.hHb = 2;
        }
    }

    public void autoContinue() {
        if (!this.ioi) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hHb == 2) {
            this.iol = i;
            ae(33, yh(i), this.dbg.getCurrentPosition());
            this.ioj = this.dbg.getCurrentPosition();
            this.dbg.start();
            if (this.iof) {
                ad.a(this.bty, true);
            }
            setLoadingAnimShow(false);
            al.c(this.iod, d.f.icon_video_midplay);
            this.hHb = 1;
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
        if (this.hZF != null) {
            this.hZF.setAlpha(1.0f);
            this.hZF.setVisibility(0);
            this.hZF.G(true);
            this.hZF.setMinAndMaxFrame(14, 80);
            this.hZF.cu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        bXO();
        if (z) {
            this.hZF.setAlpha(1.0f);
            this.hZF.setVisibility(0);
            return;
        }
        this.hZF.setVisibility(8);
    }

    private void bXO() {
        if (this.hZF != null) {
            this.hZF.setFrame(0);
            this.hZF.cancelAnimation();
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
        if (this.dbg.getCurrentPosition() > 0 && this.hHb != -1 && z) {
            int i = 32;
            int currentPosition = this.dbg.getCurrentPosition();
            if (this.dbg.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, yh(this.iol), currentPosition, this.dbg.isPlaying());
        }
        bXP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXP() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hHq);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.iom);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(PointerIconCompat.TYPE_HELP);
        this.mHandler.removeMessages(1002);
        this.dbg.stopPlayback();
        this.hHb = -1;
        ad.a(this.bty, false);
        this.fWR.setForegroundDrawable(0);
        this.fWR.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.iod, d.f.icon_video_midpause);
        this.ioe.awJ();
        this.hHi.setVisibility(8);
        if (this.hHa != null) {
            this.hHe.setText(StringUtils.translateSecondsToString(this.hHa.video_duration.intValue()));
        }
        this.ehP = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yh(int i) {
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
        return this.hHa != null ? this.hHa.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(boolean z) {
        if (z) {
            if (this.ehP != null) {
                this.ehP.setVolume(1.0f, 1.0f);
            }
            al.c(this.ioa, d.f.ad_icon_sound_open);
            al.c(this.inZ, d.f.ad_icon_sound_open);
            if (this.hHb == 1) {
                ad.a(this.bty, true);
            }
        } else {
            if (this.ehP != null) {
                this.ehP.setVolume(0.0f, 0.0f);
            }
            al.c(this.ioa, d.f.ad_icon_sound_close);
            al.c(this.inZ, d.f.ad_icon_sound_close);
            ad.a(this.bty, false);
        }
        this.iof = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hHb;
    }

    public VideoInfo getData() {
        return this.hHa;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hHk;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.inW && this.inV != null && this.inV.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.inX = advertAppInfo;
        this.inY = i;
        this.axH = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.inX, 303, i, yh(this.iol), this.hHa.video_duration.intValue(), this.mDuration, -1);
        if (this.ikB != null) {
            this.ikB.e(a);
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
        if (this.inX != null && this.hHa != null) {
            this.inX.page = this.axH;
            com.baidu.tieba.recapp.report.c.bXB().a(f.a(this.inX, i, this.inY, i2, this.hHa.video_duration.intValue(), a.lA(i3), i4));
            if (z && i != 31 && i != 33 && i != 35 && i != 2) {
                if (i == 34) {
                    str = "com";
                } else if (i == 36) {
                    str = "ex";
                } else {
                    str = ImageViewerConfig.FROM_OTHER;
                    if (i4 == 1) {
                        str = "hide";
                    } else if (i4 == 0) {
                        str = "cl_pau";
                    }
                }
                if ("DETAIL".equals(this.axH)) {
                    str2 = "det";
                } else if ("FRS".equals(this.axH)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.axH)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.ioj, i3, this.mDuration, str2, yi(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.ihj != null && "cpv".equals(this.ihj.iig) && !TextUtils.isEmpty(this.ihj.iih)) {
            new com.baidu.tieba.recapp.request.a(this.ihj.iih).a(str, i, i2, i3, str2, str3);
        }
    }

    private String yi(int i) {
        if (i == 0) {
            return ActVideoSetting.ACT_URL;
        }
        if (i != 1) {
            return ActVideoSetting.ACT_URL;
        }
        return "cl";
    }

    public void setHolderView(View view) {
        if (view != null) {
            this.inV = view;
            this.inW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.iom);
            if (this.aeX != null) {
                this.aeX.cancel();
            }
            this.ioc.setVisibility(0);
            if (this.hHb == 1) {
                al.c(this.iod, d.f.icon_video_midplay);
                return;
            } else {
                al.c(this.iod, d.f.icon_video_midpause);
                return;
            }
        }
        this.ioc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXQ() {
        switch (this.hHb) {
            case -1:
                if (!j.kY() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.j.neterror);
                    return;
                } else if (!j.kZ() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.gD(d.j.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).aaZ();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.ioi = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    pr(true);
                    return;
                }
                return;
            case 2:
                this.ioi = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.iom);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.iom, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXR() {
        if (!this.bhX && this.aeX != null) {
            this.ioc.startAnimation(this.aeX);
            this.bhX = true;
        }
    }

    private void aXk() {
        if (this.mPageContext != null) {
            this.aeX = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.aeX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.ioc.setVisibility(8);
                    DistributeVideoView.this.bhX = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
