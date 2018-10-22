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
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.ad.a.a;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.e;
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
    private WeakReference<Context> aij;
    private QuickVideoView bJN;
    private g.b bkN;
    private QuickVideoView.b bkR;
    private g.e btB;
    private g.a bty;
    private g.f btz;
    private g cML;
    private Animation dFr;
    private View dlx;
    private ForeDrawableImageView euZ;
    private String ffj;
    private AdCard.a gDs;
    private AdCard.f gDt;
    private ViewGroup gGK;
    private d gGL;
    private e gGM;
    private ImageView gGq;
    private View gJZ;
    private boolean gKa;
    private AdvertAppInfo gKb;
    private int gKc;
    private ImageView gKd;
    private ImageView gKe;
    private TextView gKf;
    private View gKg;
    private ImageView gKh;
    private VideoControllerView gKi;
    private boolean gKj;
    private long gKk;
    private b gKl;
    boolean gKm;
    boolean gKn;
    private int gKo;
    boolean gKp;
    private int gKq;
    private Runnable gKr;
    private VideoInfo geB;
    private int geC;
    private TextView geF;
    private View geJ;
    private long geL;
    private Runnable geR;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    public DistributeVideoView(Context context) {
        super(context);
        this.gKa = false;
        this.aij = null;
        this.geC = -1;
        this.geL = 0L;
        this.gKj = false;
        this.gKk = 0L;
        this.mStyle = 1;
        this.gKm = false;
        this.gKn = false;
        this.gKp = false;
        this.gKq = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geJ) {
                    DistributeVideoView.this.geJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gKe || view == DistributeVideoView.this.gKd) {
                    DistributeVideoView.this.mz(DistributeVideoView.this.gKj ? false : true);
                } else if (view == DistributeVideoView.this.gGq || view == DistributeVideoView.this.gKh) {
                    DistributeVideoView.this.buq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gKb == null || !DistributeVideoView.this.gKb.wS()) {
                    DistributeVideoView.this.buq();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gKb != null) {
                        WebVideoActivity.gDm = new WebVideoActivity.a();
                        WebVideoActivity.gDm.gDw = DistributeVideoView.this.gKb;
                        WebVideoActivity.gDm.mPage = "DETAIL";
                        WebVideoActivity.gDm.mPageNum = DistributeVideoView.this.gKc;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.ffj) ? DistributeVideoView.this.ffj : DistributeVideoView.this.gKb.ale, true, true, true, DistributeVideoView.this.geB.video_url, DistributeVideoView.this.geB.thumbnail_url, DistributeVideoView.this.geB.video_width.intValue() / DistributeVideoView.this.geB.video_height.intValue(), DistributeVideoView.this.geB.video_duration.intValue());
                    if (DistributeVideoView.this.gDs != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gDs.gEp);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gDs.gEq);
                    }
                    if (DistributeVideoView.this.gDt != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gDt.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qA(DistributeVideoView.this.parallelChargeInfo.feC);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.feF.iterator();
                        while (it.hasNext()) {
                            c.qA(it.next());
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
                        if (DistributeVideoView.this.geC != 1) {
                            if (DistributeVideoView.this.bJN.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geC = 1;
                                DistributeVideoView.this.dlx.setVisibility(8);
                                DistributeVideoView.this.euZ.setVisibility(8);
                                DistributeVideoView.this.mz(DistributeVideoView.this.gKj);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gKi.setPlayer(DistributeVideoView.this.bJN);
                                    DistributeVideoView.this.gKi.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geB.video_duration.intValue()));
                                    DistributeVideoView.this.gKi.showProgress();
                                    DistributeVideoView.this.mA(true);
                                    com.baidu.adp.lib.g.e.jI().removeCallbacks(DistributeVideoView.this.gKr);
                                    com.baidu.adp.lib.g.e.jI().postDelayed(DistributeVideoView.this.gKr, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geL = DistributeVideoView.this.bJN.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bJN.getDuration() - DistributeVideoView.this.bJN.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geF.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geC == 1) {
                            if (DistributeVideoView.this.geL == DistributeVideoView.this.bJN.getCurrentPosition()) {
                                DistributeVideoView.this.dlx.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geL = DistributeVideoView.this.bJN.getCurrentPosition();
                                DistributeVideoView.this.dlx.setVisibility(8);
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
        this.btz = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gKo = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cML = gVar;
                    DistributeVideoView.this.cML.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gKb != null) {
                    if (DistributeVideoView.this.gKp && "DETAIL".equals(DistributeVideoView.this.gKb.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), 0);
                }
                return false;
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bup();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), gVar.getCurrentPosition());
                DistributeVideoView.this.euZ.setForegroundDrawable(0);
                DistributeVideoView.this.gGq.setVisibility(8);
                DistributeVideoView.this.geJ.setVisibility(0);
                return true;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gKk = System.currentTimeMillis();
                DistributeVideoView.this.gKp = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), gVar.getDuration());
                DistributeVideoView.this.bup();
                if (DistributeVideoView.this.gGM != null) {
                    DistributeVideoView.this.gGM.buj();
                    DistributeVideoView.this.geF.setVisibility(8);
                    DistributeVideoView.this.gGq.setVisibility(8);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geB != null && DistributeVideoView.this.bJN != null) {
                    DistributeVideoView.this.to(1);
                }
            }
        };
        this.gKr = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bur();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKa = false;
        this.aij = null;
        this.geC = -1;
        this.geL = 0L;
        this.gKj = false;
        this.gKk = 0L;
        this.mStyle = 1;
        this.gKm = false;
        this.gKn = false;
        this.gKp = false;
        this.gKq = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geJ) {
                    DistributeVideoView.this.geJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gKe || view == DistributeVideoView.this.gKd) {
                    DistributeVideoView.this.mz(DistributeVideoView.this.gKj ? false : true);
                } else if (view == DistributeVideoView.this.gGq || view == DistributeVideoView.this.gKh) {
                    DistributeVideoView.this.buq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gKb == null || !DistributeVideoView.this.gKb.wS()) {
                    DistributeVideoView.this.buq();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gKb != null) {
                        WebVideoActivity.gDm = new WebVideoActivity.a();
                        WebVideoActivity.gDm.gDw = DistributeVideoView.this.gKb;
                        WebVideoActivity.gDm.mPage = "DETAIL";
                        WebVideoActivity.gDm.mPageNum = DistributeVideoView.this.gKc;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.ffj) ? DistributeVideoView.this.ffj : DistributeVideoView.this.gKb.ale, true, true, true, DistributeVideoView.this.geB.video_url, DistributeVideoView.this.geB.thumbnail_url, DistributeVideoView.this.geB.video_width.intValue() / DistributeVideoView.this.geB.video_height.intValue(), DistributeVideoView.this.geB.video_duration.intValue());
                    if (DistributeVideoView.this.gDs != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gDs.gEp);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gDs.gEq);
                    }
                    if (DistributeVideoView.this.gDt != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gDt.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qA(DistributeVideoView.this.parallelChargeInfo.feC);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.feF.iterator();
                        while (it.hasNext()) {
                            c.qA(it.next());
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
                        if (DistributeVideoView.this.geC != 1) {
                            if (DistributeVideoView.this.bJN.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geC = 1;
                                DistributeVideoView.this.dlx.setVisibility(8);
                                DistributeVideoView.this.euZ.setVisibility(8);
                                DistributeVideoView.this.mz(DistributeVideoView.this.gKj);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gKi.setPlayer(DistributeVideoView.this.bJN);
                                    DistributeVideoView.this.gKi.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geB.video_duration.intValue()));
                                    DistributeVideoView.this.gKi.showProgress();
                                    DistributeVideoView.this.mA(true);
                                    com.baidu.adp.lib.g.e.jI().removeCallbacks(DistributeVideoView.this.gKr);
                                    com.baidu.adp.lib.g.e.jI().postDelayed(DistributeVideoView.this.gKr, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geL = DistributeVideoView.this.bJN.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bJN.getDuration() - DistributeVideoView.this.bJN.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geF.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geC == 1) {
                            if (DistributeVideoView.this.geL == DistributeVideoView.this.bJN.getCurrentPosition()) {
                                DistributeVideoView.this.dlx.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geL = DistributeVideoView.this.bJN.getCurrentPosition();
                                DistributeVideoView.this.dlx.setVisibility(8);
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
        this.btz = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gKo = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cML = gVar;
                    DistributeVideoView.this.cML.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gKb != null) {
                    if (DistributeVideoView.this.gKp && "DETAIL".equals(DistributeVideoView.this.gKb.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), 0);
                }
                return false;
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bup();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), gVar.getCurrentPosition());
                DistributeVideoView.this.euZ.setForegroundDrawable(0);
                DistributeVideoView.this.gGq.setVisibility(8);
                DistributeVideoView.this.geJ.setVisibility(0);
                return true;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gKk = System.currentTimeMillis();
                DistributeVideoView.this.gKp = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), gVar.getDuration());
                DistributeVideoView.this.bup();
                if (DistributeVideoView.this.gGM != null) {
                    DistributeVideoView.this.gGM.buj();
                    DistributeVideoView.this.geF.setVisibility(8);
                    DistributeVideoView.this.gGq.setVisibility(8);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geB != null && DistributeVideoView.this.bJN != null) {
                    DistributeVideoView.this.to(1);
                }
            }
        };
        this.gKr = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bur();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKa = false;
        this.aij = null;
        this.geC = -1;
        this.geL = 0L;
        this.gKj = false;
        this.gKk = 0L;
        this.mStyle = 1;
        this.gKm = false;
        this.gKn = false;
        this.gKp = false;
        this.gKq = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geJ) {
                    DistributeVideoView.this.geJ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gKe || view == DistributeVideoView.this.gKd) {
                    DistributeVideoView.this.mz(DistributeVideoView.this.gKj ? false : true);
                } else if (view == DistributeVideoView.this.gGq || view == DistributeVideoView.this.gKh) {
                    DistributeVideoView.this.buq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gKb == null || !DistributeVideoView.this.gKb.wS()) {
                    DistributeVideoView.this.buq();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gKb != null) {
                        WebVideoActivity.gDm = new WebVideoActivity.a();
                        WebVideoActivity.gDm.gDw = DistributeVideoView.this.gKb;
                        WebVideoActivity.gDm.mPage = "DETAIL";
                        WebVideoActivity.gDm.mPageNum = DistributeVideoView.this.gKc;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.ffj) ? DistributeVideoView.this.ffj : DistributeVideoView.this.gKb.ale, true, true, true, DistributeVideoView.this.geB.video_url, DistributeVideoView.this.geB.thumbnail_url, DistributeVideoView.this.geB.video_width.intValue() / DistributeVideoView.this.geB.video_height.intValue(), DistributeVideoView.this.geB.video_duration.intValue());
                    if (DistributeVideoView.this.gDs != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gDs.gEp);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gDs.gEq);
                    }
                    if (DistributeVideoView.this.gDt != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gDt.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qA(DistributeVideoView.this.parallelChargeInfo.feC);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.feF.iterator();
                        while (it.hasNext()) {
                            c.qA(it.next());
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
                        if (DistributeVideoView.this.geC != 1) {
                            if (DistributeVideoView.this.bJN.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geC = 1;
                                DistributeVideoView.this.dlx.setVisibility(8);
                                DistributeVideoView.this.euZ.setVisibility(8);
                                DistributeVideoView.this.mz(DistributeVideoView.this.gKj);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gKi.setPlayer(DistributeVideoView.this.bJN);
                                    DistributeVideoView.this.gKi.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geB.video_duration.intValue()));
                                    DistributeVideoView.this.gKi.showProgress();
                                    DistributeVideoView.this.mA(true);
                                    com.baidu.adp.lib.g.e.jI().removeCallbacks(DistributeVideoView.this.gKr);
                                    com.baidu.adp.lib.g.e.jI().postDelayed(DistributeVideoView.this.gKr, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geL = DistributeVideoView.this.bJN.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bJN.getDuration() - DistributeVideoView.this.bJN.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geF.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geC == 1) {
                            if (DistributeVideoView.this.geL == DistributeVideoView.this.bJN.getCurrentPosition()) {
                                DistributeVideoView.this.dlx.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geL = DistributeVideoView.this.bJN.getCurrentPosition();
                                DistributeVideoView.this.dlx.setVisibility(8);
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
        this.btz = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gKo = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cML = gVar;
                    DistributeVideoView.this.cML.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.btB = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gKb != null) {
                    if (DistributeVideoView.this.gKp && "DETAIL".equals(DistributeVideoView.this.gKb.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), 0);
                }
                return false;
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bup();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), gVar.getCurrentPosition());
                DistributeVideoView.this.euZ.setForegroundDrawable(0);
                DistributeVideoView.this.gGq.setVisibility(8);
                DistributeVideoView.this.geJ.setVisibility(0);
                return true;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gKk = System.currentTimeMillis();
                DistributeVideoView.this.gKp = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tp(DistributeVideoView.this.gKq), gVar.getDuration());
                DistributeVideoView.this.bup();
                if (DistributeVideoView.this.gGM != null) {
                    DistributeVideoView.this.gGM.buj();
                    DistributeVideoView.this.geF.setVisibility(8);
                    DistributeVideoView.this.gGq.setVisibility(8);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geR = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geB != null && DistributeVideoView.this.bJN != null) {
                    DistributeVideoView.this.to(1);
                }
            }
        };
        this.gKr = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bur();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.ffj = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gKl = adCard;
        if (this.gKl != null) {
            this.parallelChargeInfo = this.gKl.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bJN = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gGq = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.euZ = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.dlx = this.mRootView.findViewById(e.g.distribute_loading);
            this.geF = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.geJ = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gKf = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gKd = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gKg = this.mRootView.findViewById(e.g.distribute_control);
            this.gKh = (ImageView) this.gKg.findViewById(e.g.distribute_play_icon);
            this.gKe = (ImageView) this.gKg.findViewById(e.g.distribute_voice);
            this.gKi = (VideoControllerView) this.gKg.findViewById(e.g.distribute_process);
            this.gGK = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gGL = new d(context, this.gGK);
        }
    }

    private boolean bmp() {
        return this.mStyle == 1 ? q.bmp() : j.kY();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bus();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gDs = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gDt = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geB = videoInfo;
        this.mDuration = this.geB.video_duration.intValue() * 1000;
        this.aij = new WeakReference<>(this.mContext.getApplicationContext());
        bup();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0175e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.geB.video_width.intValue() > 0 ? (this.geB.video_height.intValue() * aO) / this.geB.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gGq, e.f.btn_icon_play_video_n);
        this.gGq.setVisibility(8);
        this.euZ.setDefaultErrorResource(0);
        this.euZ.setDefaultResource(0);
        this.euZ.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.euZ.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.euZ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnErrorListener(this.bkN);
        this.bJN.setOnCompletionListener(this.bty);
        this.bJN.setOnOutInfoListener(this.btB);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        al.h(this.geF, e.d.cp_cont_i);
        al.i(this.geF, e.f.video_play_count_bg);
        this.geF.setText(StringUtils.translateSecondsToString(this.geB.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gKj = false;
            al.c(this.gKd, e.f.ad_icon_sound_close);
        } else {
            this.gKj = true;
            al.c(this.gKe, e.f.ad_icon_sound_open);
            this.gKd.setVisibility(8);
        }
        this.gKe.setOnClickListener(this.mOnClickListener);
        this.gKd.setOnClickListener(this.mOnClickListener);
        this.geJ.setOnClickListener(this.mOnClickListener);
        this.geJ.setVisibility(8);
        al.j(this.geJ, e.d.black_alpha80);
        al.h(this.gKf, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geF.setVisibility(0);
            return;
        }
        this.geF.setVisibility(8);
        this.gKh.setOnClickListener(this.mOnClickListener);
        this.gGq.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geB = videoInfo;
        this.aij = new WeakReference<>(this.mContext.getApplicationContext());
        bup();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gGq, e.f.btn_icon_play_video_n);
        this.gGq.setVisibility(8);
        this.euZ.setDefaultErrorResource(0);
        this.euZ.setDefaultResource(0);
        this.euZ.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.euZ.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.euZ.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnErrorListener(this.bkN);
        this.bJN.setOnCompletionListener(this.bty);
        this.bJN.setOnOutInfoListener(this.btB);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        al.h(this.geF, e.d.cp_cont_i);
        this.geF.setText(StringUtils.translateSecondsToString(this.geB.video_duration.intValue()));
        al.i(this.geF, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gKj = false;
            al.c(this.gKd, e.f.ad_icon_sound_close);
        } else {
            this.gKj = true;
            al.c(this.gKe, e.f.ad_icon_sound_open);
            this.gKd.setVisibility(8);
        }
        this.gKe.setOnClickListener(this.mOnClickListener);
        this.gKd.setOnClickListener(this.mOnClickListener);
        this.geJ.setOnClickListener(this.mOnClickListener);
        this.geJ.setVisibility(8);
        al.j(this.geJ, e.d.black_alpha80);
        al.h(this.gKf, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geF.setVisibility(0);
            return;
        }
        this.geF.setVisibility(8);
        this.gKh.setOnClickListener(this.mOnClickListener);
        this.gGq.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gGM = this.gGL.a(this.gDt, this.gGM);
        if (this.gGM != null) {
            this.gGM.setPageContext(this.mPageContext);
            this.gGM.c(this.gKl);
            this.gGM.setAdvertAppInfo(advertAppInfo);
            this.gGM.a(this.gDt);
            this.gGM.buk();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gGM != null) {
            this.gGM.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(e.C0175e.ds16) + i;
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
        this.bty = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(int i) {
        this.gKq = i;
        if (this.geB != null && this.geC == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gKk) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gGM != null) {
                    this.gGM.buk();
                }
                this.bJN.setVideoPath(this.geB.video_url);
                this.bJN.start();
                this.gKo = this.bJN.getCurrentPosition();
                this.gGq.setVisibility(8);
                al.c(this.gKh, e.f.icon_video_midplay);
                this.dlx.setVisibility(0);
                this.geJ.setVisibility(8);
                this.euZ.setForegroundDrawable(0);
                this.geC = 0;
                if (this.mStyle == 1) {
                    this.geF.setVisibility(0);
                } else {
                    this.geF.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        to(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bmp()) {
            if (i <= 0) {
                to(1);
                return;
            }
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.geR);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.geR, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.geC == 1) {
            w(32, tp(this.gKq), this.bJN.getCurrentPosition(), i);
            this.bJN.pause();
            aa.a(this.aij, false);
            this.gGq.setVisibility(0);
            al.c(this.gKh, e.f.icon_video_midpause);
            this.geC = 2;
        }
    }

    public void autoContinue() {
        if (!this.gKn) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.geC == 2) {
            this.gKq = i;
            ab(33, tp(i), this.bJN.getCurrentPosition());
            this.gKo = this.bJN.getCurrentPosition();
            this.bJN.start();
            if (this.gKj) {
                aa.a(this.aij, true);
            }
            this.gGq.setVisibility(8);
            al.c(this.gKh, e.f.icon_video_midplay);
            this.geC = 1;
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
        if (this.bJN.getCurrentPosition() > 0 && this.geC != -1 && z) {
            int i = 32;
            int currentPosition = this.bJN.getCurrentPosition();
            if (this.bJN.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, tp(this.gKq), currentPosition, this.bJN.isPlaying());
        }
        bup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.geR);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gKr);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bJN.stopPlayback();
        this.geC = -1;
        aa.a(this.aij, false);
        this.euZ.setForegroundDrawable(0);
        this.euZ.setVisibility(0);
        this.dlx.setVisibility(8);
        this.gGq.setVisibility(0);
        al.c(this.gKh, e.f.icon_video_midpause);
        this.gKi.UV();
        this.geJ.setVisibility(8);
        if (this.geB != null) {
            this.geF.setText(StringUtils.translateSecondsToString(this.geB.video_duration.intValue()));
        }
        this.cML = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tp(int i) {
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
        return this.geB != null ? this.geB.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(boolean z) {
        if (z) {
            if (this.cML != null) {
                this.cML.setVolume(1.0f, 1.0f);
            }
            al.c(this.gKe, e.f.ad_icon_sound_open);
            al.c(this.gKd, e.f.ad_icon_sound_open);
            if (this.geC == 1) {
                aa.a(this.aij, true);
            }
        } else {
            if (this.cML != null) {
                this.cML.setVolume(0.0f, 0.0f);
            }
            al.c(this.gKe, e.f.ad_icon_sound_close);
            al.c(this.gKd, e.f.ad_icon_sound_close);
            aa.a(this.aij, false);
        }
        this.gKj = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.geC;
    }

    public VideoInfo getData() {
        return this.geB;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.geL;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gKa && this.gJZ != null && this.gJZ.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gKb = advertAppInfo;
        this.gKc = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gKb, 303, i, tp(this.gKq), this.geB.video_duration.intValue(), this.mDuration, -1);
        if (this.gGM != null) {
            this.gGM.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, int i2, int i3) {
        w(i, i2, i3, -1);
    }

    private void e(int i, int i2, int i3, boolean z) {
        a(i, i2, i3, -1, z);
    }

    private void w(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, true);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.gKb != null && this.geB != null) {
            this.gKb.page = this.mPage;
            com.baidu.tieba.recapp.report.c.buf().a(f.a(this.gKb, i, this.gKc, i2, this.geB.video_duration.intValue(), a.hi(i3), i4));
            if (z && i != 31 && i != 33 && i != 35 && i != 2) {
                if (i == 34) {
                    str = "com";
                } else if (i == 36) {
                    str = Config.EXCEPTION_PART;
                } else {
                    str = "other";
                    if (i4 == 1) {
                        str = AiAppsNaViewModel.KEY_HIDDEN;
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
                c(str, this.gKo, i3, this.mDuration, str2, tq(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gDs != null && "cpv".equals(this.gDs.gEp) && !TextUtils.isEmpty(this.gDs.gEq)) {
            new com.baidu.tieba.recapp.request.a(this.gDs.gEq).a(str, i, i2, i3, str2, str3);
        }
    }

    private String tq(int i) {
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
            this.gJZ = view;
            this.gKa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gKr);
            if (this.dFr != null) {
                this.dFr.cancel();
            }
            this.gKg.setVisibility(0);
            if (this.geC == 1) {
                al.c(this.gKh, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gKh, e.f.icon_video_midpause);
                return;
            }
        }
        this.gKg.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buq() {
        switch (this.geC) {
            case -1:
                if (!j.kX() && this.mPageContext != null) {
                    this.mPageContext.showToast(e.j.neterror);
                    return;
                } else if (!j.kY() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cz(e.j.play_video_mobile_tip);
                    aVar.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            DistributeVideoView.this.performPlay();
                        }
                    });
                    aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(this.mPageContext).Au();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gKn = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mA(true);
                    return;
                }
                return;
            case 2:
                this.gKn = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gKr);
                    com.baidu.adp.lib.g.e.jI().postDelayed(this.gKr, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bur() {
        if (!this.gKm && this.dFr != null) {
            this.gKg.startAnimation(this.dFr);
            this.gKm = true;
        }
    }

    private void bus() {
        if (this.mPageContext != null) {
            this.dFr = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dFr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gKg.setVisibility(8);
                    DistributeVideoView.this.gKm = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
