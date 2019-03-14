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
    private String aSv;
    private Animation aeY;
    private String axI;
    boolean bhY;
    private WeakReference<Context> btA;
    private g.b cAm;
    private QuickVideoView.b cAq;
    private g.a cJF;
    private g.f cJG;
    private g.e cJI;
    private QuickVideoView dbc;
    private g ehL;
    private ForeDrawableImageView fWR;
    private VideoInfo hGV;
    private int hGW;
    private TextView hGZ;
    private View hHd;
    private long hHf;
    private Runnable hHl;
    private TBLottieAnimationView hZA;
    private AdCard.a ihe;
    private AdCard.f ihf;
    private ViewGroup ikt;
    private d iku;
    private e ikv;
    private View inP;
    private boolean inQ;
    private AdvertAppInfo inR;
    private int inS;
    private ImageView inT;
    private ImageView inU;
    private TextView inV;
    private View inW;
    private ImageView inX;
    private VideoControllerView inY;
    private boolean inZ;
    private long ioa;
    private b iob;
    boolean ioc;
    private int iod;
    boolean ioe;
    private int iof;
    private Runnable iog;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    /* JADX INFO: Access modifiers changed from: private */
    public void bUh() {
        if (this.hZA != null) {
            this.hZA.clearAnimation();
            this.hZA.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DistributeVideoView.this.hZA.setVisibility(8);
                    DistributeVideoView.this.fWR.setVisibility(8);
                    DistributeVideoView.this.pq(DistributeVideoView.this.inZ);
                    if (DistributeVideoView.this.mStyle == 1) {
                        DistributeVideoView.this.mHandler.removeMessages(1002);
                        DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                    } else {
                        DistributeVideoView.this.inY.setPlayer(DistributeVideoView.this.dbc);
                        DistributeVideoView.this.inY.ax(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.hGV.video_duration.intValue()));
                        DistributeVideoView.this.inY.showProgress();
                        DistributeVideoView.this.pr(true);
                        com.baidu.adp.lib.g.e.jH().removeCallbacks(DistributeVideoView.this.iog);
                        com.baidu.adp.lib.g.e.jH().postDelayed(DistributeVideoView.this.iog, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView.this.hHf = DistributeVideoView.this.dbc.getCurrentPosition();
                    DistributeVideoView.this.mHandler.removeMessages(1003);
                    DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    DistributeVideoView.this.hZA.setFrame(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
    }

    public DistributeVideoView(Context context) {
        super(context);
        this.inQ = false;
        this.btA = null;
        this.hGW = -1;
        this.hHf = 0L;
        this.inZ = false;
        this.ioa = 0L;
        this.mStyle = 1;
        this.bhY = false;
        this.ioc = false;
        this.ioe = false;
        this.iof = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hHd) {
                    DistributeVideoView.this.hHd.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inU || view == DistributeVideoView.this.inT) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inZ ? false : true);
                } else if (view == DistributeVideoView.this.hZA || view == DistributeVideoView.this.inX) {
                    DistributeVideoView.this.bXT();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inR == null || !DistributeVideoView.this.inR.Xc()) {
                    DistributeVideoView.this.bXT();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inR != null) {
                        WebVideoActivity.igY = new WebVideoActivity.a();
                        WebVideoActivity.igY.ihi = DistributeVideoView.this.inR;
                        WebVideoActivity.igY.axI = "DETAIL";
                        WebVideoActivity.igY.mPageNum = DistributeVideoView.this.inS;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSv) ? DistributeVideoView.this.aSv : DistributeVideoView.this.inR.bwF, true, true, true, DistributeVideoView.this.hGV.video_url, DistributeVideoView.this.hGV.thumbnail_url, DistributeVideoView.this.hGV.video_width.intValue() / DistributeVideoView.this.hGV.video_height.intValue(), DistributeVideoView.this.hGV.video_duration.intValue());
                    if (DistributeVideoView.this.ihe != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.ihe.iib);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.ihe.iic);
                    }
                    if (DistributeVideoView.this.ihf != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.ihf.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xZ(DistributeVideoView.this.parallelChargeInfo.gGE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGH.iterator();
                        while (it.hasNext()) {
                            c.xZ(it.next());
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
                        if (DistributeVideoView.this.hGW != 1) {
                            if (DistributeVideoView.this.dbc.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGW = 1;
                                DistributeVideoView.this.bUh();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbc.getDuration() - DistributeVideoView.this.dbc.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGZ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGW == 1) {
                            if (DistributeVideoView.this.hHf == DistributeVideoView.this.dbc.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hHf = DistributeVideoView.this.dbc.getCurrentPosition();
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
        this.cJG = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iod = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehL = gVar;
                    DistributeVideoView.this.ehL.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inR != null) {
                    if (DistributeVideoView.this.ioe && "DETAIL".equals(DistributeVideoView.this.inR.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yh(DistributeVideoView.this.iof), 0);
                }
                return false;
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXS();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yh(DistributeVideoView.this.iof), gVar.getCurrentPosition());
                DistributeVideoView.this.fWR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hHd.setVisibility(0);
                return true;
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.ioa = System.currentTimeMillis();
                DistributeVideoView.this.ioe = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yh(DistributeVideoView.this.iof), gVar.getDuration());
                DistributeVideoView.this.bXS();
                if (DistributeVideoView.this.ikv != null) {
                    DistributeVideoView.this.ikv.bXI();
                    DistributeVideoView.this.hGZ.setVisibility(8);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hHl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGV != null && DistributeVideoView.this.dbc != null) {
                    DistributeVideoView.this.yg(1);
                }
            }
        };
        this.iog = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXU();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inQ = false;
        this.btA = null;
        this.hGW = -1;
        this.hHf = 0L;
        this.inZ = false;
        this.ioa = 0L;
        this.mStyle = 1;
        this.bhY = false;
        this.ioc = false;
        this.ioe = false;
        this.iof = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hHd) {
                    DistributeVideoView.this.hHd.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inU || view == DistributeVideoView.this.inT) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inZ ? false : true);
                } else if (view == DistributeVideoView.this.hZA || view == DistributeVideoView.this.inX) {
                    DistributeVideoView.this.bXT();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inR == null || !DistributeVideoView.this.inR.Xc()) {
                    DistributeVideoView.this.bXT();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inR != null) {
                        WebVideoActivity.igY = new WebVideoActivity.a();
                        WebVideoActivity.igY.ihi = DistributeVideoView.this.inR;
                        WebVideoActivity.igY.axI = "DETAIL";
                        WebVideoActivity.igY.mPageNum = DistributeVideoView.this.inS;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSv) ? DistributeVideoView.this.aSv : DistributeVideoView.this.inR.bwF, true, true, true, DistributeVideoView.this.hGV.video_url, DistributeVideoView.this.hGV.thumbnail_url, DistributeVideoView.this.hGV.video_width.intValue() / DistributeVideoView.this.hGV.video_height.intValue(), DistributeVideoView.this.hGV.video_duration.intValue());
                    if (DistributeVideoView.this.ihe != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.ihe.iib);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.ihe.iic);
                    }
                    if (DistributeVideoView.this.ihf != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.ihf.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xZ(DistributeVideoView.this.parallelChargeInfo.gGE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGH.iterator();
                        while (it.hasNext()) {
                            c.xZ(it.next());
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
                        if (DistributeVideoView.this.hGW != 1) {
                            if (DistributeVideoView.this.dbc.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGW = 1;
                                DistributeVideoView.this.bUh();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbc.getDuration() - DistributeVideoView.this.dbc.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGZ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGW == 1) {
                            if (DistributeVideoView.this.hHf == DistributeVideoView.this.dbc.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hHf = DistributeVideoView.this.dbc.getCurrentPosition();
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
        this.cJG = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iod = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehL = gVar;
                    DistributeVideoView.this.ehL.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.inR != null) {
                    if (DistributeVideoView.this.ioe && "DETAIL".equals(DistributeVideoView.this.inR.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yh(DistributeVideoView.this.iof), 0);
                }
                return false;
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bXS();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yh(DistributeVideoView.this.iof), gVar.getCurrentPosition());
                DistributeVideoView.this.fWR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hHd.setVisibility(0);
                return true;
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.ioa = System.currentTimeMillis();
                DistributeVideoView.this.ioe = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yh(DistributeVideoView.this.iof), gVar.getDuration());
                DistributeVideoView.this.bXS();
                if (DistributeVideoView.this.ikv != null) {
                    DistributeVideoView.this.ikv.bXI();
                    DistributeVideoView.this.hGZ.setVisibility(8);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hHl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGV != null && DistributeVideoView.this.dbc != null) {
                    DistributeVideoView.this.yg(1);
                }
            }
        };
        this.iog = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXU();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.inQ = false;
        this.btA = null;
        this.hGW = -1;
        this.hHf = 0L;
        this.inZ = false;
        this.ioa = 0L;
        this.mStyle = 1;
        this.bhY = false;
        this.ioc = false;
        this.ioe = false;
        this.iof = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.hHd) {
                    DistributeVideoView.this.hHd.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.inU || view == DistributeVideoView.this.inT) {
                    DistributeVideoView.this.pq(DistributeVideoView.this.inZ ? false : true);
                } else if (view == DistributeVideoView.this.hZA || view == DistributeVideoView.this.inX) {
                    DistributeVideoView.this.bXT();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.inR == null || !DistributeVideoView.this.inR.Xc()) {
                    DistributeVideoView.this.bXT();
                } else {
                    DistributeVideoView.this.ae(2, 1, 0);
                    if (DistributeVideoView.this.inR != null) {
                        WebVideoActivity.igY = new WebVideoActivity.a();
                        WebVideoActivity.igY.ihi = DistributeVideoView.this.inR;
                        WebVideoActivity.igY.axI = "DETAIL";
                        WebVideoActivity.igY.mPageNum = DistributeVideoView.this.inS;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.aSv) ? DistributeVideoView.this.aSv : DistributeVideoView.this.inR.bwF, true, true, true, DistributeVideoView.this.hGV.video_url, DistributeVideoView.this.hGV.thumbnail_url, DistributeVideoView.this.hGV.video_width.intValue() / DistributeVideoView.this.hGV.video_height.intValue(), DistributeVideoView.this.hGV.video_duration.intValue());
                    if (DistributeVideoView.this.ihe != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.ihe.iib);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.ihe.iic);
                    }
                    if (DistributeVideoView.this.ihf != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.ihf.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.xZ(DistributeVideoView.this.parallelChargeInfo.gGE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.gGH.iterator();
                        while (it.hasNext()) {
                            c.xZ(it.next());
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
                        if (DistributeVideoView.this.hGW != 1) {
                            if (DistributeVideoView.this.dbc.getCurrentPosition() > 0) {
                                DistributeVideoView.this.hGW = 1;
                                DistributeVideoView.this.bUh();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.dbc.getDuration() - DistributeVideoView.this.dbc.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.hGZ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.hGW == 1) {
                            if (DistributeVideoView.this.hHf == DistributeVideoView.this.dbc.getCurrentPosition()) {
                                DistributeVideoView.this.startLoadingAnim();
                            } else {
                                DistributeVideoView.this.hHf = DistributeVideoView.this.dbc.getCurrentPosition();
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
        this.cJG = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.iod = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.ehL = gVar;
                    DistributeVideoView.this.ehL.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.cJI = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.inR != null) {
                    if (DistributeVideoView.this.ioe && "DETAIL".equals(DistributeVideoView.this.inR.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ae(i3, DistributeVideoView.this.yh(DistributeVideoView.this.iof), 0);
                }
                return false;
            }
        };
        this.cAm = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bXS();
                DistributeVideoView.this.ae(36, DistributeVideoView.this.yh(DistributeVideoView.this.iof), gVar.getCurrentPosition());
                DistributeVideoView.this.fWR.setForegroundDrawable(0);
                DistributeVideoView.this.setLoadingAnimShow(false);
                DistributeVideoView.this.hHd.setVisibility(0);
                return true;
            }
        };
        this.cJF = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.ioa = System.currentTimeMillis();
                DistributeVideoView.this.ioe = true;
                DistributeVideoView.this.ae(34, DistributeVideoView.this.yh(DistributeVideoView.this.iof), gVar.getDuration());
                DistributeVideoView.this.bXS();
                if (DistributeVideoView.this.ikv != null) {
                    DistributeVideoView.this.ikv.bXI();
                    DistributeVideoView.this.hGZ.setVisibility(8);
                }
            }
        };
        this.cAq = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.hHl = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.hGV != null && DistributeVideoView.this.dbc != null) {
                    DistributeVideoView.this.yg(1);
                }
            }
        };
        this.iog = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bXU();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.aSv = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.iob = adCard;
        if (this.iob != null) {
            this.parallelChargeInfo = this.iob.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.dbc = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.hZA = (TBLottieAnimationView) this.mRootView.findViewById(d.g.video_play);
            this.fWR = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.hGZ = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.hHd = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.inV = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.inT = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.inW = this.mRootView.findViewById(d.g.distribute_control);
            this.inX = (ImageView) this.inW.findViewById(d.g.distribute_play_icon);
            this.inU = (ImageView) this.inW.findViewById(d.g.distribute_voice);
            this.inY = (VideoControllerView) this.inW.findViewById(d.g.distribute_process);
            this.ikt = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.iku = new com.baidu.tieba.recapp.e.d(context, this.ikt);
            this.hZA.setAnimation(d.i.lotti_video_loading);
            this.hZA.setFrame(0);
        }
    }

    private boolean bPw() {
        return this.mStyle == 1 ? q.bPw() : j.kZ();
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
        this.ihe = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.ihf = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGV = videoInfo;
        this.mDuration = this.hGV.video_duration.intValue() * 1000;
        this.btA = new WeakReference<>(this.mContext.getApplicationContext());
        bXS();
        al.l(this, d.C0277d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.hGV.video_width.intValue() > 0 ? (this.hGV.video_height.intValue() * aO) / this.hGV.video_width.intValue() : aO;
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
        this.dbc.setOnPreparedListener(this.cJG);
        this.dbc.setOnErrorListener(this.cAm);
        this.dbc.setOnCompletionListener(this.cJF);
        this.dbc.setOnOutInfoListener(this.cJI);
        this.dbc.setOnSurfaceDestroyedListener(this.cAq);
        al.j(this.hGZ, d.C0277d.cp_btn_a);
        al.k(this.hGZ, d.f.video_play_count_bg);
        this.hGZ.setText(StringUtils.translateSecondsToString(this.hGV.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.inZ = false;
            al.c(this.inT, d.f.ad_icon_sound_close);
        } else {
            this.inZ = true;
            al.c(this.inU, d.f.ad_icon_sound_open);
            this.inT.setVisibility(8);
        }
        this.inU.setOnClickListener(this.mOnClickListener);
        this.inT.setOnClickListener(this.mOnClickListener);
        this.hHd.setOnClickListener(this.mOnClickListener);
        this.hHd.setVisibility(8);
        al.l(this.hHd, d.C0277d.black_alpha80);
        al.j(this.inV, d.C0277d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hGZ.setVisibility(0);
            return;
        }
        this.hGZ.setVisibility(8);
        this.inX.setOnClickListener(this.mOnClickListener);
        this.hZA.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.hGV = videoInfo;
        this.btA = new WeakReference<>(this.mContext.getApplicationContext());
        bXS();
        al.l(this, d.C0277d.cp_bg_line_d);
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
        this.dbc.setOnPreparedListener(this.cJG);
        this.dbc.setOnErrorListener(this.cAm);
        this.dbc.setOnCompletionListener(this.cJF);
        this.dbc.setOnOutInfoListener(this.cJI);
        this.dbc.setOnSurfaceDestroyedListener(this.cAq);
        al.j(this.hGZ, d.C0277d.cp_btn_a);
        this.hGZ.setText(StringUtils.translateSecondsToString(this.hGV.video_duration.intValue()));
        al.k(this.hGZ, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.inZ = false;
            al.c(this.inT, d.f.ad_icon_sound_close);
        } else {
            this.inZ = true;
            al.c(this.inU, d.f.ad_icon_sound_open);
            this.inT.setVisibility(8);
        }
        this.inU.setOnClickListener(this.mOnClickListener);
        this.inT.setOnClickListener(this.mOnClickListener);
        this.hHd.setOnClickListener(this.mOnClickListener);
        this.hHd.setVisibility(8);
        al.l(this.hHd, d.C0277d.black_alpha80);
        al.j(this.inV, d.C0277d.cp_btn_a);
        if (this.mStyle == 1) {
            this.hGZ.setVisibility(0);
            return;
        }
        this.hGZ.setVisibility(8);
        this.inX.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.ikv = this.iku.a(this.ihf, this.ikv);
        if (this.ikv != null) {
            this.ikv.setPageContext(this.mPageContext);
            this.ikv.c(this.iob);
            this.ikv.setAdvertAppInfo(advertAppInfo);
            this.ikv.a(this.ihf);
            this.ikv.bXJ();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.ikv != null) {
            this.ikv.setDownloadAppCallback(cVar);
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
        this.cJF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yg(int i) {
        this.iof = i;
        if (this.hGV != null && this.hGW == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.ioa) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.ikv != null) {
                    this.ikv.bXJ();
                }
                this.dbc.setVideoPath(this.hGV.video_url);
                this.dbc.start();
                this.iod = this.dbc.getCurrentPosition();
                al.c(this.inX, d.f.icon_video_midplay);
                startLoadingAnim();
                this.hHd.setVisibility(8);
                this.fWR.setForegroundDrawable(0);
                this.hGW = 0;
                if (this.mStyle == 1) {
                    this.hGZ.setVisibility(0);
                } else {
                    this.hGZ.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        yg(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bPw()) {
            if (i <= 0) {
                yg(1);
                return;
            }
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hHl);
            com.baidu.adp.lib.g.e.jH().postDelayed(this.hHl, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.hGW == 1) {
            A(32, yh(this.iof), this.dbc.getCurrentPosition(), i);
            this.dbc.pause();
            ad.a(this.btA, false);
            setLoadingAnimShow(true);
            al.c(this.inX, d.f.icon_video_midpause);
            this.hGW = 2;
        }
    }

    public void autoContinue() {
        if (!this.ioc) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.hGW == 2) {
            this.iof = i;
            ae(33, yh(i), this.dbc.getCurrentPosition());
            this.iod = this.dbc.getCurrentPosition();
            this.dbc.start();
            if (this.inZ) {
                ad.a(this.btA, true);
            }
            setLoadingAnimShow(false);
            al.c(this.inX, d.f.icon_video_midplay);
            this.hGW = 1;
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
        if (this.hZA != null) {
            this.hZA.setAlpha(1.0f);
            this.hZA.setVisibility(0);
            this.hZA.G(true);
            this.hZA.setMinAndMaxFrame(14, 80);
            this.hZA.cu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        bXR();
        if (z) {
            this.hZA.setAlpha(1.0f);
            this.hZA.setVisibility(0);
            return;
        }
        this.hZA.setVisibility(8);
    }

    private void bXR() {
        if (this.hZA != null) {
            this.hZA.setFrame(0);
            this.hZA.cancelAnimation();
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
        if (this.dbc.getCurrentPosition() > 0 && this.hGW != -1 && z) {
            int i = 32;
            int currentPosition = this.dbc.getCurrentPosition();
            if (this.dbc.getDuration() == currentPosition) {
                i = 34;
            }
            h(i, yh(this.iof), currentPosition, this.dbc.isPlaying());
        }
        bXS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXS() {
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hHl);
        com.baidu.adp.lib.g.e.jH().removeCallbacks(this.iog);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.dbc.stopPlayback();
        this.hGW = -1;
        ad.a(this.btA, false);
        this.fWR.setForegroundDrawable(0);
        this.fWR.setVisibility(0);
        setLoadingAnimShow(true);
        al.c(this.inX, d.f.icon_video_midpause);
        this.inY.awJ();
        this.hHd.setVisibility(8);
        if (this.hGV != null) {
            this.hGZ.setText(StringUtils.translateSecondsToString(this.hGV.video_duration.intValue()));
        }
        this.ehL = null;
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
        return this.hGV != null ? this.hGV.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pq(boolean z) {
        if (z) {
            if (this.ehL != null) {
                this.ehL.setVolume(1.0f, 1.0f);
            }
            al.c(this.inU, d.f.ad_icon_sound_open);
            al.c(this.inT, d.f.ad_icon_sound_open);
            if (this.hGW == 1) {
                ad.a(this.btA, true);
            }
        } else {
            if (this.ehL != null) {
                this.ehL.setVolume(0.0f, 0.0f);
            }
            al.c(this.inU, d.f.ad_icon_sound_close);
            al.c(this.inT, d.f.ad_icon_sound_close);
            ad.a(this.btA, false);
        }
        this.inZ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.hGW;
    }

    public VideoInfo getData() {
        return this.hGV;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.hHf;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.inQ && this.inP != null && this.inP.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.inR = advertAppInfo;
        this.inS = i;
        this.axI = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.inR, 303, i, yh(this.iof), this.hGV.video_duration.intValue(), this.mDuration, -1);
        if (this.ikv != null) {
            this.ikv.e(a);
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
        if (this.inR != null && this.hGV != null) {
            this.inR.page = this.axI;
            com.baidu.tieba.recapp.report.c.bXE().a(f.a(this.inR, i, this.inS, i2, this.hGV.video_duration.intValue(), a.lA(i3), i4));
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
                if ("DETAIL".equals(this.axI)) {
                    str2 = "det";
                } else if ("FRS".equals(this.axI)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.axI)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.iod, i3, this.mDuration, str2, yi(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.ihe != null && "cpv".equals(this.ihe.iib) && !TextUtils.isEmpty(this.ihe.iic)) {
            new com.baidu.tieba.recapp.request.a(this.ihe.iic).a(str, i, i2, i3, str2, str3);
        }
    }

    private String yi(int i) {
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
            this.inP = view;
            this.inQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.iog);
            if (this.aeY != null) {
                this.aeY.cancel();
            }
            this.inW.setVisibility(0);
            if (this.hGW == 1) {
                al.c(this.inX, d.f.icon_video_midplay);
                return;
            } else {
                al.c(this.inX, d.f.icon_video_midpause);
                return;
            }
        }
        this.inW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXT() {
        switch (this.hGW) {
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
                this.ioc = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    pr(true);
                    return;
                }
                return;
            case 2:
                this.ioc = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.iog);
                    com.baidu.adp.lib.g.e.jH().postDelayed(this.iog, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXU() {
        if (!this.bhY && this.aeY != null) {
            this.inW.startAnimation(this.aeY);
            this.bhY = true;
        }
    }

    private void aXk() {
        if (this.mPageContext != null) {
            this.aeY = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.aeY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.inW.setVisibility(8);
                    DistributeVideoView.this.bhY = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
