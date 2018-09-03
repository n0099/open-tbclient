package com.baidu.tieba.recapp.view;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.ad.a.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.f;
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
import com.baidu.tieba.tbadkCore.q;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> aaI;
    private g.b bdd;
    private QuickVideoView.b bdh;
    private g.a bjM;
    private g.f bjN;
    private QuickVideoView bvr;
    private View cXu;
    private g cyB;
    private Animation drd;
    private String eQg;
    private ForeDrawableImageView efK;
    private VideoInfo fPJ;
    private int fPK;
    private TextView fPN;
    private View fPR;
    private long fPT;
    private Runnable fPZ;
    private String goD;
    private AdCard.a goy;
    private AdCard.f goz;
    private ViewGroup grP;
    private d grQ;
    private e grR;
    private ImageView grx;
    private int gvA;
    private Runnable gvB;
    private View gvj;
    private boolean gvk;
    private AdvertAppInfo gvl;
    private int gvm;
    private ImageView gvn;
    private ImageView gvo;
    private TextView gvp;
    private View gvq;
    private ImageView gvr;
    private VideoControllerView gvs;
    private boolean gvt;
    private long gvu;
    private b gvv;
    boolean gvw;
    boolean gvx;
    private int gvy;
    boolean gvz;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    public DistributeVideoView(Context context) {
        super(context);
        this.gvk = false;
        this.aaI = null;
        this.fPK = -1;
        this.fPT = 0L;
        this.gvt = false;
        this.gvu = 0L;
        this.mStyle = 1;
        this.gvw = false;
        this.gvx = false;
        this.gvz = false;
        this.gvA = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPR) {
                    DistributeVideoView.this.fPR.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gvo || view == DistributeVideoView.this.gvn) {
                    DistributeVideoView.this.lI(DistributeVideoView.this.gvt ? false : true);
                } else if (view == DistributeVideoView.this.grx || view == DistributeVideoView.this.gvr) {
                    DistributeVideoView.this.bou();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gvl == null || !DistributeVideoView.this.gvl.tG()) {
                    DistributeVideoView.this.bou();
                } else {
                    DistributeVideoView.this.W(2, 1, 0);
                    if (DistributeVideoView.this.gvl != null) {
                        WebVideoActivity.gos = new WebVideoActivity.a();
                        WebVideoActivity.gos.goC = DistributeVideoView.this.gvl;
                        WebVideoActivity.gos.goD = "DETAIL";
                        WebVideoActivity.gos.mPageNum = DistributeVideoView.this.gvm;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eQg) ? DistributeVideoView.this.eQg : DistributeVideoView.this.gvl.adH, true, true, true, DistributeVideoView.this.fPJ.video_url, DistributeVideoView.this.fPJ.thumbnail_url, DistributeVideoView.this.fPJ.video_width.intValue() / DistributeVideoView.this.fPJ.video_height.intValue(), DistributeVideoView.this.fPJ.video_duration.intValue());
                    if (DistributeVideoView.this.goy != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.goy.gpw);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.goy.gpx);
                    }
                    if (DistributeVideoView.this.goz != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.goz.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pt(DistributeVideoView.this.parallelChargeInfo.ePz);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ePC.iterator();
                        while (it.hasNext()) {
                            c.pt(it.next());
                        }
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.fPK != 1) {
                            if (DistributeVideoView.this.bvr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPK = 1;
                                DistributeVideoView.this.cXu.setVisibility(8);
                                DistributeVideoView.this.efK.setVisibility(8);
                                DistributeVideoView.this.lI(DistributeVideoView.this.gvt);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gvs.setPlayer(DistributeVideoView.this.bvr);
                                    DistributeVideoView.this.gvs.T(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPJ.video_duration.intValue()));
                                    DistributeVideoView.this.gvs.showProgress();
                                    DistributeVideoView.this.lJ(true);
                                    com.baidu.adp.lib.g.e.in().removeCallbacks(DistributeVideoView.this.gvB);
                                    com.baidu.adp.lib.g.e.in().postDelayed(DistributeVideoView.this.gvB, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fPT = DistributeVideoView.this.bvr.getCurrentPosition();
                                DistributeVideoView.this.mHandler.removeMessages(1003);
                                DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bvr.getDuration() - DistributeVideoView.this.bvr.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPN.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPK == 1) {
                            if (DistributeVideoView.this.fPT == DistributeVideoView.this.bvr.getCurrentPosition()) {
                                DistributeVideoView.this.cXu.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fPT = DistributeVideoView.this.bvr.getCurrentPosition();
                                DistributeVideoView.this.cXu.setVisibility(8);
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
        this.bjN = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gvy = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gvl != null) {
                        if (DistributeVideoView.this.gvz && "DETAIL".equals(DistributeVideoView.this.gvl.page)) {
                            i = 35;
                        } else {
                            i = 31;
                        }
                        DistributeVideoView.this.W(i, DistributeVideoView.this.su(DistributeVideoView.this.gvA), 0);
                    }
                    DistributeVideoView.this.cyB = gVar;
                    DistributeVideoView.this.cyB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bot();
                DistributeVideoView.this.W(36, DistributeVideoView.this.su(DistributeVideoView.this.gvA), gVar.getCurrentPosition());
                DistributeVideoView.this.efK.setForegroundDrawable(0);
                DistributeVideoView.this.grx.setVisibility(8);
                DistributeVideoView.this.fPR.setVisibility(0);
                return true;
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gvu = System.currentTimeMillis();
                DistributeVideoView.this.gvz = true;
                DistributeVideoView.this.W(34, DistributeVideoView.this.su(DistributeVideoView.this.gvA), gVar.getDuration());
                DistributeVideoView.this.bot();
                if (DistributeVideoView.this.grR != null) {
                    DistributeVideoView.this.grR.bon();
                    DistributeVideoView.this.fPN.setVisibility(8);
                    DistributeVideoView.this.grx.setVisibility(8);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fPZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPJ != null && DistributeVideoView.this.bvr != null) {
                    DistributeVideoView.this.st(1);
                }
            }
        };
        this.gvB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bov();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvk = false;
        this.aaI = null;
        this.fPK = -1;
        this.fPT = 0L;
        this.gvt = false;
        this.gvu = 0L;
        this.mStyle = 1;
        this.gvw = false;
        this.gvx = false;
        this.gvz = false;
        this.gvA = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPR) {
                    DistributeVideoView.this.fPR.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gvo || view == DistributeVideoView.this.gvn) {
                    DistributeVideoView.this.lI(DistributeVideoView.this.gvt ? false : true);
                } else if (view == DistributeVideoView.this.grx || view == DistributeVideoView.this.gvr) {
                    DistributeVideoView.this.bou();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gvl == null || !DistributeVideoView.this.gvl.tG()) {
                    DistributeVideoView.this.bou();
                } else {
                    DistributeVideoView.this.W(2, 1, 0);
                    if (DistributeVideoView.this.gvl != null) {
                        WebVideoActivity.gos = new WebVideoActivity.a();
                        WebVideoActivity.gos.goC = DistributeVideoView.this.gvl;
                        WebVideoActivity.gos.goD = "DETAIL";
                        WebVideoActivity.gos.mPageNum = DistributeVideoView.this.gvm;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eQg) ? DistributeVideoView.this.eQg : DistributeVideoView.this.gvl.adH, true, true, true, DistributeVideoView.this.fPJ.video_url, DistributeVideoView.this.fPJ.thumbnail_url, DistributeVideoView.this.fPJ.video_width.intValue() / DistributeVideoView.this.fPJ.video_height.intValue(), DistributeVideoView.this.fPJ.video_duration.intValue());
                    if (DistributeVideoView.this.goy != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.goy.gpw);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.goy.gpx);
                    }
                    if (DistributeVideoView.this.goz != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.goz.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pt(DistributeVideoView.this.parallelChargeInfo.ePz);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ePC.iterator();
                        while (it.hasNext()) {
                            c.pt(it.next());
                        }
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.fPK != 1) {
                            if (DistributeVideoView.this.bvr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPK = 1;
                                DistributeVideoView.this.cXu.setVisibility(8);
                                DistributeVideoView.this.efK.setVisibility(8);
                                DistributeVideoView.this.lI(DistributeVideoView.this.gvt);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gvs.setPlayer(DistributeVideoView.this.bvr);
                                    DistributeVideoView.this.gvs.T(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPJ.video_duration.intValue()));
                                    DistributeVideoView.this.gvs.showProgress();
                                    DistributeVideoView.this.lJ(true);
                                    com.baidu.adp.lib.g.e.in().removeCallbacks(DistributeVideoView.this.gvB);
                                    com.baidu.adp.lib.g.e.in().postDelayed(DistributeVideoView.this.gvB, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fPT = DistributeVideoView.this.bvr.getCurrentPosition();
                                DistributeVideoView.this.mHandler.removeMessages(1003);
                                DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bvr.getDuration() - DistributeVideoView.this.bvr.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPN.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPK == 1) {
                            if (DistributeVideoView.this.fPT == DistributeVideoView.this.bvr.getCurrentPosition()) {
                                DistributeVideoView.this.cXu.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fPT = DistributeVideoView.this.bvr.getCurrentPosition();
                                DistributeVideoView.this.cXu.setVisibility(8);
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
        this.bjN = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gvy = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gvl != null) {
                        if (DistributeVideoView.this.gvz && "DETAIL".equals(DistributeVideoView.this.gvl.page)) {
                            i = 35;
                        } else {
                            i = 31;
                        }
                        DistributeVideoView.this.W(i, DistributeVideoView.this.su(DistributeVideoView.this.gvA), 0);
                    }
                    DistributeVideoView.this.cyB = gVar;
                    DistributeVideoView.this.cyB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bot();
                DistributeVideoView.this.W(36, DistributeVideoView.this.su(DistributeVideoView.this.gvA), gVar.getCurrentPosition());
                DistributeVideoView.this.efK.setForegroundDrawable(0);
                DistributeVideoView.this.grx.setVisibility(8);
                DistributeVideoView.this.fPR.setVisibility(0);
                return true;
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gvu = System.currentTimeMillis();
                DistributeVideoView.this.gvz = true;
                DistributeVideoView.this.W(34, DistributeVideoView.this.su(DistributeVideoView.this.gvA), gVar.getDuration());
                DistributeVideoView.this.bot();
                if (DistributeVideoView.this.grR != null) {
                    DistributeVideoView.this.grR.bon();
                    DistributeVideoView.this.fPN.setVisibility(8);
                    DistributeVideoView.this.grx.setVisibility(8);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fPZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPJ != null && DistributeVideoView.this.bvr != null) {
                    DistributeVideoView.this.st(1);
                }
            }
        };
        this.gvB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bov();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvk = false;
        this.aaI = null;
        this.fPK = -1;
        this.fPT = 0L;
        this.gvt = false;
        this.gvu = 0L;
        this.mStyle = 1;
        this.gvw = false;
        this.gvx = false;
        this.gvz = false;
        this.gvA = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPR) {
                    DistributeVideoView.this.fPR.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gvo || view == DistributeVideoView.this.gvn) {
                    DistributeVideoView.this.lI(DistributeVideoView.this.gvt ? false : true);
                } else if (view == DistributeVideoView.this.grx || view == DistributeVideoView.this.gvr) {
                    DistributeVideoView.this.bou();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gvl == null || !DistributeVideoView.this.gvl.tG()) {
                    DistributeVideoView.this.bou();
                } else {
                    DistributeVideoView.this.W(2, 1, 0);
                    if (DistributeVideoView.this.gvl != null) {
                        WebVideoActivity.gos = new WebVideoActivity.a();
                        WebVideoActivity.gos.goC = DistributeVideoView.this.gvl;
                        WebVideoActivity.gos.goD = "DETAIL";
                        WebVideoActivity.gos.mPageNum = DistributeVideoView.this.gvm;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eQg) ? DistributeVideoView.this.eQg : DistributeVideoView.this.gvl.adH, true, true, true, DistributeVideoView.this.fPJ.video_url, DistributeVideoView.this.fPJ.thumbnail_url, DistributeVideoView.this.fPJ.video_width.intValue() / DistributeVideoView.this.fPJ.video_height.intValue(), DistributeVideoView.this.fPJ.video_duration.intValue());
                    if (DistributeVideoView.this.goy != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.goy.gpw);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.goy.gpx);
                    }
                    if (DistributeVideoView.this.goz != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.goz.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pt(DistributeVideoView.this.parallelChargeInfo.ePz);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ePC.iterator();
                        while (it.hasNext()) {
                            c.pt(it.next());
                        }
                    }
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.fPK != 1) {
                            if (DistributeVideoView.this.bvr.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPK = 1;
                                DistributeVideoView.this.cXu.setVisibility(8);
                                DistributeVideoView.this.efK.setVisibility(8);
                                DistributeVideoView.this.lI(DistributeVideoView.this.gvt);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gvs.setPlayer(DistributeVideoView.this.bvr);
                                    DistributeVideoView.this.gvs.T(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPJ.video_duration.intValue()));
                                    DistributeVideoView.this.gvs.showProgress();
                                    DistributeVideoView.this.lJ(true);
                                    com.baidu.adp.lib.g.e.in().removeCallbacks(DistributeVideoView.this.gvB);
                                    com.baidu.adp.lib.g.e.in().postDelayed(DistributeVideoView.this.gvB, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fPT = DistributeVideoView.this.bvr.getCurrentPosition();
                                DistributeVideoView.this.mHandler.removeMessages(1003);
                                DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bvr.getDuration() - DistributeVideoView.this.bvr.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPN.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPK == 1) {
                            if (DistributeVideoView.this.fPT == DistributeVideoView.this.bvr.getCurrentPosition()) {
                                DistributeVideoView.this.cXu.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fPT = DistributeVideoView.this.bvr.getCurrentPosition();
                                DistributeVideoView.this.cXu.setVisibility(8);
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
        this.bjN = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gvy = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gvl != null) {
                        if (DistributeVideoView.this.gvz && "DETAIL".equals(DistributeVideoView.this.gvl.page)) {
                            i2 = 35;
                        } else {
                            i2 = 31;
                        }
                        DistributeVideoView.this.W(i2, DistributeVideoView.this.su(DistributeVideoView.this.gvA), 0);
                    }
                    DistributeVideoView.this.cyB = gVar;
                    DistributeVideoView.this.cyB.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bot();
                DistributeVideoView.this.W(36, DistributeVideoView.this.su(DistributeVideoView.this.gvA), gVar.getCurrentPosition());
                DistributeVideoView.this.efK.setForegroundDrawable(0);
                DistributeVideoView.this.grx.setVisibility(8);
                DistributeVideoView.this.fPR.setVisibility(0);
                return true;
            }
        };
        this.bjM = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gvu = System.currentTimeMillis();
                DistributeVideoView.this.gvz = true;
                DistributeVideoView.this.W(34, DistributeVideoView.this.su(DistributeVideoView.this.gvA), gVar.getDuration());
                DistributeVideoView.this.bot();
                if (DistributeVideoView.this.grR != null) {
                    DistributeVideoView.this.grR.bon();
                    DistributeVideoView.this.fPN.setVisibility(8);
                    DistributeVideoView.this.grx.setVisibility(8);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fPZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPJ != null && DistributeVideoView.this.bvr != null) {
                    DistributeVideoView.this.st(1);
                }
            }
        };
        this.gvB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bov();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.eQg = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gvv = adCard;
        if (this.gvv != null) {
            this.parallelChargeInfo = this.gvv.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(f.h.distribute_video_view, (ViewGroup) this, true);
            this.bvr = (QuickVideoView) this.mRootView.findViewById(f.g.distribute_texture);
            this.grx = (ImageView) this.mRootView.findViewById(f.g.distribute_play);
            this.efK = (ForeDrawableImageView) this.mRootView.findViewById(f.g.distribute_thumbnail);
            this.cXu = this.mRootView.findViewById(f.g.distribute_loading);
            this.fPN = (TextView) this.mRootView.findViewById(f.g.distribute_count_process);
            this.fPR = this.mRootView.findViewById(f.g.distribute_error_tip);
            this.gvp = (TextView) this.mRootView.findViewById(f.g.distribute_error_tip_text);
            this.gvn = (ImageView) this.mRootView.findViewById(f.g.distribute_voice_feed);
            this.gvq = this.mRootView.findViewById(f.g.distribute_control);
            this.gvr = (ImageView) this.gvq.findViewById(f.g.distribute_play_icon);
            this.gvo = (ImageView) this.gvq.findViewById(f.g.distribute_voice);
            this.gvs = (VideoControllerView) this.gvq.findViewById(f.g.distribute_process);
            this.grP = (FrameLayout) this.mRootView.findViewById(f.g.tail_frame_container);
            this.grQ = new d(context, this.grP);
        }
    }

    private boolean bgC() {
        return this.mStyle == 1 ? q.bgC() : j.jF();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bow();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.goy = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.goz = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPJ = videoInfo;
        this.mDuration = this.fPJ.video_duration.intValue() * 1000;
        this.aaI = new WeakReference<>(this.mContext.getApplicationContext());
        bot();
        am.j(this, f.d.cp_bg_line_d);
        int ah = l.ah(this.mContext) - l.f(this.mContext, f.e.ds146);
        if (this.mStyle == 2) {
            ah = l.ah(this.mContext);
        }
        int intValue = this.fPJ.video_width.intValue() > 0 ? (this.fPJ.video_height.intValue() * ah) / this.fPJ.video_width.intValue() : ah;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ah;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        am.i(this.grx, f.C0146f.btn_icon_play_video_n);
        this.grx.setVisibility(8);
        this.efK.setDefaultErrorResource(0);
        this.efK.setDefaultResource(0);
        this.efK.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.efK.setForegroundDrawable(f.C0146f.icon_play_video_ad);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.efK.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bvr.setOnPreparedListener(this.bjN);
        this.bvr.setOnErrorListener(this.bdd);
        this.bvr.setOnCompletionListener(this.bjM);
        this.bvr.setOnSurfaceDestroyedListener(this.bdh);
        am.h(this.fPN, f.d.cp_cont_i);
        am.i(this.fPN, f.C0146f.video_play_count_bg);
        this.fPN.setText(StringUtils.translateSecondsToString(this.fPJ.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gvt = false;
            am.c(this.gvn, f.C0146f.ad_icon_sound_close);
        } else {
            this.gvt = true;
            am.c(this.gvo, f.C0146f.ad_icon_sound_open);
            this.gvn.setVisibility(8);
        }
        this.gvo.setOnClickListener(this.mOnClickListener);
        this.gvn.setOnClickListener(this.mOnClickListener);
        this.fPR.setOnClickListener(this.mOnClickListener);
        this.fPR.setVisibility(8);
        am.j(this.fPR, f.d.black_alpha80);
        am.h(this.gvp, f.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fPN.setVisibility(0);
            return;
        }
        this.fPN.setVisibility(8);
        this.gvr.setOnClickListener(this.mOnClickListener);
        this.grx.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPJ = videoInfo;
        this.aaI = new WeakReference<>(this.mContext.getApplicationContext());
        bot();
        am.j(this, f.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ah(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        am.i(this.grx, f.C0146f.btn_icon_play_video_n);
        this.grx.setVisibility(8);
        this.efK.setDefaultErrorResource(0);
        this.efK.setDefaultResource(0);
        this.efK.setDefaultBgResource(f.C0146f.pic_bg_video_frs);
        this.efK.setForegroundDrawable(f.C0146f.icon_play_video_ad);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.efK.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bvr.setOnPreparedListener(this.bjN);
        this.bvr.setOnErrorListener(this.bdd);
        this.bvr.setOnCompletionListener(this.bjM);
        this.bvr.setOnSurfaceDestroyedListener(this.bdh);
        am.h(this.fPN, f.d.cp_cont_i);
        this.fPN.setText(StringUtils.translateSecondsToString(this.fPJ.video_duration.intValue()));
        am.i(this.fPN, f.C0146f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gvt = false;
            am.c(this.gvn, f.C0146f.ad_icon_sound_close);
        } else {
            this.gvt = true;
            am.c(this.gvo, f.C0146f.ad_icon_sound_open);
            this.gvn.setVisibility(8);
        }
        this.gvo.setOnClickListener(this.mOnClickListener);
        this.gvn.setOnClickListener(this.mOnClickListener);
        this.fPR.setOnClickListener(this.mOnClickListener);
        this.fPR.setVisibility(8);
        am.j(this.fPR, f.d.black_alpha80);
        am.h(this.gvp, f.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fPN.setVisibility(0);
            return;
        }
        this.fPN.setVisibility(8);
        this.gvr.setOnClickListener(this.mOnClickListener);
        this.grx.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.grR = this.grQ.a(this.goz, this.grR);
        if (this.grR != null) {
            this.grR.setPageContext(this.mPageContext);
            this.grR.c(this.gvv);
            this.grR.setAdvertAppInfo(advertAppInfo);
            this.grR.a(this.goz);
            this.grR.boo();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.grR != null) {
            this.grR.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(f.e.ds16) + i;
        int intValue = videoInfo.video_height.intValue();
        int intValue2 = videoInfo.video_width.intValue();
        if (i <= 0 || intValue <= 0 || intValue2 <= 0) {
            i(this.mRootView, i2, i3);
            return true;
        }
        i(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void i(View view, int i, int i2) {
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
        this.bjM = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(int i) {
        this.gvA = i;
        if (this.fPJ != null && this.fPK == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gvu) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.grR != null) {
                    this.grR.boo();
                }
                this.bvr.setVideoPath(this.fPJ.video_url);
                this.bvr.start();
                this.gvy = this.bvr.getCurrentPosition();
                this.grx.setVisibility(8);
                am.c(this.gvr, f.C0146f.icon_video_midplay);
                this.cXu.setVisibility(0);
                this.fPR.setVisibility(8);
                this.efK.setForegroundDrawable(0);
                this.fPK = 0;
                if (this.mStyle == 1) {
                    this.fPN.setVisibility(0);
                } else {
                    this.fPN.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        st(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bgC()) {
            if (i <= 0) {
                st(1);
                return;
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fPZ);
            com.baidu.adp.lib.g.e.in().postDelayed(this.fPZ, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fPK == 1) {
            v(32, su(this.gvA), this.bvr.getCurrentPosition(), i);
            this.bvr.pause();
            y.a(this.aaI, false);
            this.grx.setVisibility(0);
            am.c(this.gvr, f.C0146f.icon_video_midpause);
            this.fPK = 2;
        }
    }

    public void autoContinue() {
        if (!this.gvx) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fPK == 2) {
            this.gvA = i;
            W(33, su(i), this.bvr.getCurrentPosition());
            this.gvy = this.bvr.getCurrentPosition();
            this.bvr.start();
            if (this.gvt) {
                y.a(this.aaI, true);
            }
            this.grx.setVisibility(8);
            am.c(this.gvr, f.C0146f.icon_video_midplay);
            this.fPK = 1;
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

    @Override // com.baidu.tieba.recapp.i
    public void startPlay() {
        autoPlay(0);
    }

    @Override // com.baidu.tieba.recapp.i
    public void stopPlay() {
        stopPlay(true);
    }

    public void stopPlay(boolean z) {
        if (this.bvr.getCurrentPosition() > 0 && this.fPK != -1 && z) {
            int i = 32;
            int currentPosition = this.bvr.getCurrentPosition();
            if (this.bvr.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, su(this.gvA), currentPosition, this.bvr.isPlaying());
        }
        bot();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fPZ);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gvB);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bvr.stopPlayback();
        this.fPK = -1;
        y.a(this.aaI, false);
        this.efK.setForegroundDrawable(0);
        this.efK.setVisibility(0);
        this.cXu.setVisibility(8);
        this.grx.setVisibility(0);
        am.c(this.gvr, f.C0146f.icon_video_midpause);
        this.gvs.Rl();
        this.fPR.setVisibility(8);
        if (this.fPJ != null) {
            this.fPN.setText(StringUtils.translateSecondsToString(this.fPJ.video_duration.intValue()));
        }
        this.cyB = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int su(int i) {
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
        return this.fPJ != null ? this.fPJ.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (z) {
            if (this.cyB != null) {
                this.cyB.setVolume(1.0f, 1.0f);
            }
            am.c(this.gvo, f.C0146f.ad_icon_sound_open);
            am.c(this.gvn, f.C0146f.ad_icon_sound_open);
            if (this.fPK == 1) {
                y.a(this.aaI, true);
            }
        } else {
            if (this.cyB != null) {
                this.cyB.setVolume(0.0f, 0.0f);
            }
            am.c(this.gvo, f.C0146f.ad_icon_sound_close);
            am.c(this.gvn, f.C0146f.ad_icon_sound_close);
            y.a(this.aaI, false);
        }
        this.gvt = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fPK;
    }

    public VideoInfo getData() {
        return this.fPJ;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fPT;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gvk && this.gvj != null && this.gvj.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aj(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gvl = advertAppInfo;
        this.gvm = i;
        this.goD = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = com.baidu.tieba.recapp.report.f.a(this.gvl, 303, i, su(this.gvA), this.fPJ.video_duration.intValue(), this.mDuration, -1);
        if (this.grR != null) {
            this.grR.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(int i, int i2, int i3) {
        v(i, i2, i3, -1);
    }

    private void d(int i, int i2, int i3, boolean z) {
        a(i, i2, i3, -1, z);
    }

    private void v(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, true);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.gvl != null && this.fPJ != null) {
            this.gvl.page = this.goD;
            com.baidu.tieba.recapp.report.c.boj().a(com.baidu.tieba.recapp.report.f.a(this.gvl, i, this.gvm, i2, this.fPJ.video_duration.intValue(), a.gA(i3), i4));
            if (z && i != 31 && i != 33 && i != 35 && i != 2) {
                if (i == 34) {
                    str = "com";
                } else if (i == 36) {
                    str = "ex";
                } else {
                    str = "other";
                    if (i4 == 1) {
                        str = "hide";
                    } else if (i4 == 0) {
                        str = "cl_pau";
                    }
                }
                if ("DETAIL".equals(this.goD)) {
                    str2 = "det";
                } else if ("FRS".equals(this.goD)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.goD)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gvy, i3, this.mDuration, str2, sv(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.goy != null && "cpv".equals(this.goy.gpw) && !TextUtils.isEmpty(this.goy.gpx)) {
            new com.baidu.tieba.recapp.request.a(this.goy.gpx).a(str, i, i2, i3, str2, str3);
        }
    }

    private String sv(int i) {
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
            this.gvj = view;
            this.gvk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.gvB);
            if (this.drd != null) {
                this.drd.cancel();
            }
            this.gvq.setVisibility(0);
            if (this.fPK == 1) {
                am.c(this.gvr, f.C0146f.icon_video_midplay);
                return;
            } else {
                am.c(this.gvr, f.C0146f.icon_video_midpause);
                return;
            }
        }
        this.gvq.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        switch (this.fPK) {
            case -1:
                if (!j.jE() && this.mPageContext != null) {
                    this.mPageContext.showToast(f.j.neterror);
                    return;
                } else if (!j.jF() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cf(f.j.play_video_mobile_tip);
                    aVar.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            DistributeVideoView.this.performPlay();
                        }
                    });
                    aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(this.mPageContext).xe();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gvx = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lJ(true);
                    return;
                }
                return;
            case 2:
                this.gvx = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.in().removeCallbacks(this.gvB);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.gvB, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bov() {
        if (!this.gvw && this.drd != null) {
            this.gvq.startAnimation(this.drd);
            this.gvw = true;
        }
    }

    private void bow() {
        if (this.mPageContext != null) {
            this.drd = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), f.a.anim_alpha_1_to_0_duration_1000);
            this.drd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gvq.setVisibility(8);
                    DistributeVideoView.this.gvw = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
