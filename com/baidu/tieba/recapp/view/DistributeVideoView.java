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
    private ForeDrawableImageView euY;
    private String ffi;
    private AdCard.a gDr;
    private AdCard.f gDs;
    private ViewGroup gGJ;
    private d gGK;
    private e gGL;
    private ImageView gGp;
    private View gJY;
    private boolean gJZ;
    private AdvertAppInfo gKa;
    private int gKb;
    private ImageView gKc;
    private ImageView gKd;
    private TextView gKe;
    private View gKf;
    private ImageView gKg;
    private VideoControllerView gKh;
    private boolean gKi;
    private long gKj;
    private b gKk;
    boolean gKl;
    boolean gKm;
    private int gKn;
    boolean gKo;
    private int gKp;
    private Runnable gKq;
    private VideoInfo geA;
    private int geB;
    private TextView geE;
    private View geI;
    private long geK;
    private Runnable geQ;
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
        this.gJZ = false;
        this.aij = null;
        this.geB = -1;
        this.geK = 0L;
        this.gKi = false;
        this.gKj = 0L;
        this.mStyle = 1;
        this.gKl = false;
        this.gKm = false;
        this.gKo = false;
        this.gKp = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geI) {
                    DistributeVideoView.this.geI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gKd || view == DistributeVideoView.this.gKc) {
                    DistributeVideoView.this.mz(DistributeVideoView.this.gKi ? false : true);
                } else if (view == DistributeVideoView.this.gGp || view == DistributeVideoView.this.gKg) {
                    DistributeVideoView.this.buq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gKa == null || !DistributeVideoView.this.gKa.wS()) {
                    DistributeVideoView.this.buq();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gKa != null) {
                        WebVideoActivity.gDl = new WebVideoActivity.a();
                        WebVideoActivity.gDl.gDv = DistributeVideoView.this.gKa;
                        WebVideoActivity.gDl.mPage = "DETAIL";
                        WebVideoActivity.gDl.mPageNum = DistributeVideoView.this.gKb;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.ffi) ? DistributeVideoView.this.ffi : DistributeVideoView.this.gKa.ale, true, true, true, DistributeVideoView.this.geA.video_url, DistributeVideoView.this.geA.thumbnail_url, DistributeVideoView.this.geA.video_width.intValue() / DistributeVideoView.this.geA.video_height.intValue(), DistributeVideoView.this.geA.video_duration.intValue());
                    if (DistributeVideoView.this.gDr != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gDr.gEo);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gDr.gEp);
                    }
                    if (DistributeVideoView.this.gDs != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gDs.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qA(DistributeVideoView.this.parallelChargeInfo.feB);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.feE.iterator();
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
                        if (DistributeVideoView.this.geB != 1) {
                            if (DistributeVideoView.this.bJN.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geB = 1;
                                DistributeVideoView.this.dlx.setVisibility(8);
                                DistributeVideoView.this.euY.setVisibility(8);
                                DistributeVideoView.this.mz(DistributeVideoView.this.gKi);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gKh.setPlayer(DistributeVideoView.this.bJN);
                                    DistributeVideoView.this.gKh.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geA.video_duration.intValue()));
                                    DistributeVideoView.this.gKh.showProgress();
                                    DistributeVideoView.this.mA(true);
                                    com.baidu.adp.lib.g.e.jI().removeCallbacks(DistributeVideoView.this.gKq);
                                    com.baidu.adp.lib.g.e.jI().postDelayed(DistributeVideoView.this.gKq, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geK = DistributeVideoView.this.bJN.getCurrentPosition();
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
                            DistributeVideoView.this.geE.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geB == 1) {
                            if (DistributeVideoView.this.geK == DistributeVideoView.this.bJN.getCurrentPosition()) {
                                DistributeVideoView.this.dlx.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geK = DistributeVideoView.this.bJN.getCurrentPosition();
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
                    DistributeVideoView.this.gKn = gVar.getCurrentPosition();
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
                if (i == 3 && DistributeVideoView.this.gKa != null) {
                    if (DistributeVideoView.this.gKo && "DETAIL".equals(DistributeVideoView.this.gKa.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), 0);
                }
                return false;
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bup();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), gVar.getCurrentPosition());
                DistributeVideoView.this.euY.setForegroundDrawable(0);
                DistributeVideoView.this.gGp.setVisibility(8);
                DistributeVideoView.this.geI.setVisibility(0);
                return true;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gKj = System.currentTimeMillis();
                DistributeVideoView.this.gKo = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), gVar.getDuration());
                DistributeVideoView.this.bup();
                if (DistributeVideoView.this.gGL != null) {
                    DistributeVideoView.this.gGL.buj();
                    DistributeVideoView.this.geE.setVisibility(8);
                    DistributeVideoView.this.gGp.setVisibility(8);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geA != null && DistributeVideoView.this.bJN != null) {
                    DistributeVideoView.this.to(1);
                }
            }
        };
        this.gKq = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bur();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJZ = false;
        this.aij = null;
        this.geB = -1;
        this.geK = 0L;
        this.gKi = false;
        this.gKj = 0L;
        this.mStyle = 1;
        this.gKl = false;
        this.gKm = false;
        this.gKo = false;
        this.gKp = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geI) {
                    DistributeVideoView.this.geI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gKd || view == DistributeVideoView.this.gKc) {
                    DistributeVideoView.this.mz(DistributeVideoView.this.gKi ? false : true);
                } else if (view == DistributeVideoView.this.gGp || view == DistributeVideoView.this.gKg) {
                    DistributeVideoView.this.buq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gKa == null || !DistributeVideoView.this.gKa.wS()) {
                    DistributeVideoView.this.buq();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gKa != null) {
                        WebVideoActivity.gDl = new WebVideoActivity.a();
                        WebVideoActivity.gDl.gDv = DistributeVideoView.this.gKa;
                        WebVideoActivity.gDl.mPage = "DETAIL";
                        WebVideoActivity.gDl.mPageNum = DistributeVideoView.this.gKb;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.ffi) ? DistributeVideoView.this.ffi : DistributeVideoView.this.gKa.ale, true, true, true, DistributeVideoView.this.geA.video_url, DistributeVideoView.this.geA.thumbnail_url, DistributeVideoView.this.geA.video_width.intValue() / DistributeVideoView.this.geA.video_height.intValue(), DistributeVideoView.this.geA.video_duration.intValue());
                    if (DistributeVideoView.this.gDr != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gDr.gEo);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gDr.gEp);
                    }
                    if (DistributeVideoView.this.gDs != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gDs.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qA(DistributeVideoView.this.parallelChargeInfo.feB);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.feE.iterator();
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
                        if (DistributeVideoView.this.geB != 1) {
                            if (DistributeVideoView.this.bJN.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geB = 1;
                                DistributeVideoView.this.dlx.setVisibility(8);
                                DistributeVideoView.this.euY.setVisibility(8);
                                DistributeVideoView.this.mz(DistributeVideoView.this.gKi);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gKh.setPlayer(DistributeVideoView.this.bJN);
                                    DistributeVideoView.this.gKh.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geA.video_duration.intValue()));
                                    DistributeVideoView.this.gKh.showProgress();
                                    DistributeVideoView.this.mA(true);
                                    com.baidu.adp.lib.g.e.jI().removeCallbacks(DistributeVideoView.this.gKq);
                                    com.baidu.adp.lib.g.e.jI().postDelayed(DistributeVideoView.this.gKq, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geK = DistributeVideoView.this.bJN.getCurrentPosition();
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
                            DistributeVideoView.this.geE.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geB == 1) {
                            if (DistributeVideoView.this.geK == DistributeVideoView.this.bJN.getCurrentPosition()) {
                                DistributeVideoView.this.dlx.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geK = DistributeVideoView.this.bJN.getCurrentPosition();
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
                    DistributeVideoView.this.gKn = gVar.getCurrentPosition();
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
                if (i == 3 && DistributeVideoView.this.gKa != null) {
                    if (DistributeVideoView.this.gKo && "DETAIL".equals(DistributeVideoView.this.gKa.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), 0);
                }
                return false;
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bup();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), gVar.getCurrentPosition());
                DistributeVideoView.this.euY.setForegroundDrawable(0);
                DistributeVideoView.this.gGp.setVisibility(8);
                DistributeVideoView.this.geI.setVisibility(0);
                return true;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gKj = System.currentTimeMillis();
                DistributeVideoView.this.gKo = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), gVar.getDuration());
                DistributeVideoView.this.bup();
                if (DistributeVideoView.this.gGL != null) {
                    DistributeVideoView.this.gGL.buj();
                    DistributeVideoView.this.geE.setVisibility(8);
                    DistributeVideoView.this.gGp.setVisibility(8);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geA != null && DistributeVideoView.this.bJN != null) {
                    DistributeVideoView.this.to(1);
                }
            }
        };
        this.gKq = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bur();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gJZ = false;
        this.aij = null;
        this.geB = -1;
        this.geK = 0L;
        this.gKi = false;
        this.gKj = 0L;
        this.mStyle = 1;
        this.gKl = false;
        this.gKm = false;
        this.gKo = false;
        this.gKp = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geI) {
                    DistributeVideoView.this.geI.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gKd || view == DistributeVideoView.this.gKc) {
                    DistributeVideoView.this.mz(DistributeVideoView.this.gKi ? false : true);
                } else if (view == DistributeVideoView.this.gGp || view == DistributeVideoView.this.gKg) {
                    DistributeVideoView.this.buq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gKa == null || !DistributeVideoView.this.gKa.wS()) {
                    DistributeVideoView.this.buq();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gKa != null) {
                        WebVideoActivity.gDl = new WebVideoActivity.a();
                        WebVideoActivity.gDl.gDv = DistributeVideoView.this.gKa;
                        WebVideoActivity.gDl.mPage = "DETAIL";
                        WebVideoActivity.gDl.mPageNum = DistributeVideoView.this.gKb;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.ffi) ? DistributeVideoView.this.ffi : DistributeVideoView.this.gKa.ale, true, true, true, DistributeVideoView.this.geA.video_url, DistributeVideoView.this.geA.thumbnail_url, DistributeVideoView.this.geA.video_width.intValue() / DistributeVideoView.this.geA.video_height.intValue(), DistributeVideoView.this.geA.video_duration.intValue());
                    if (DistributeVideoView.this.gDr != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gDr.gEo);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gDr.gEp);
                    }
                    if (DistributeVideoView.this.gDs != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gDs.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qA(DistributeVideoView.this.parallelChargeInfo.feB);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.feE.iterator();
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
                        if (DistributeVideoView.this.geB != 1) {
                            if (DistributeVideoView.this.bJN.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geB = 1;
                                DistributeVideoView.this.dlx.setVisibility(8);
                                DistributeVideoView.this.euY.setVisibility(8);
                                DistributeVideoView.this.mz(DistributeVideoView.this.gKi);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gKh.setPlayer(DistributeVideoView.this.bJN);
                                    DistributeVideoView.this.gKh.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geA.video_duration.intValue()));
                                    DistributeVideoView.this.gKh.showProgress();
                                    DistributeVideoView.this.mA(true);
                                    com.baidu.adp.lib.g.e.jI().removeCallbacks(DistributeVideoView.this.gKq);
                                    com.baidu.adp.lib.g.e.jI().postDelayed(DistributeVideoView.this.gKq, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geK = DistributeVideoView.this.bJN.getCurrentPosition();
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
                            DistributeVideoView.this.geE.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geB == 1) {
                            if (DistributeVideoView.this.geK == DistributeVideoView.this.bJN.getCurrentPosition()) {
                                DistributeVideoView.this.dlx.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geK = DistributeVideoView.this.bJN.getCurrentPosition();
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
                    DistributeVideoView.this.gKn = gVar.getCurrentPosition();
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
                if (i2 == 3 && DistributeVideoView.this.gKa != null) {
                    if (DistributeVideoView.this.gKo && "DETAIL".equals(DistributeVideoView.this.gKa.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), 0);
                }
                return false;
            }
        };
        this.bkN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bup();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), gVar.getCurrentPosition());
                DistributeVideoView.this.euY.setForegroundDrawable(0);
                DistributeVideoView.this.gGp.setVisibility(8);
                DistributeVideoView.this.geI.setVisibility(0);
                return true;
            }
        };
        this.bty = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gKj = System.currentTimeMillis();
                DistributeVideoView.this.gKo = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tp(DistributeVideoView.this.gKp), gVar.getDuration());
                DistributeVideoView.this.bup();
                if (DistributeVideoView.this.gGL != null) {
                    DistributeVideoView.this.gGL.buj();
                    DistributeVideoView.this.geE.setVisibility(8);
                    DistributeVideoView.this.gGp.setVisibility(8);
                }
            }
        };
        this.bkR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geA != null && DistributeVideoView.this.bJN != null) {
                    DistributeVideoView.this.to(1);
                }
            }
        };
        this.gKq = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bur();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.ffi = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gKk = adCard;
        if (this.gKk != null) {
            this.parallelChargeInfo = this.gKk.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bJN = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gGp = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.euY = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.dlx = this.mRootView.findViewById(e.g.distribute_loading);
            this.geE = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.geI = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gKe = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gKc = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gKf = this.mRootView.findViewById(e.g.distribute_control);
            this.gKg = (ImageView) this.gKf.findViewById(e.g.distribute_play_icon);
            this.gKd = (ImageView) this.gKf.findViewById(e.g.distribute_voice);
            this.gKh = (VideoControllerView) this.gKf.findViewById(e.g.distribute_process);
            this.gGJ = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gGK = new d(context, this.gGJ);
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
        this.gDr = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gDs = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geA = videoInfo;
        this.mDuration = this.geA.video_duration.intValue() * 1000;
        this.aij = new WeakReference<>(this.mContext.getApplicationContext());
        bup();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0175e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.geA.video_width.intValue() > 0 ? (this.geA.video_height.intValue() * aO) / this.geA.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gGp, e.f.btn_icon_play_video_n);
        this.gGp.setVisibility(8);
        this.euY.setDefaultErrorResource(0);
        this.euY.setDefaultResource(0);
        this.euY.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.euY.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.euY.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnErrorListener(this.bkN);
        this.bJN.setOnCompletionListener(this.bty);
        this.bJN.setOnOutInfoListener(this.btB);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        al.h(this.geE, e.d.cp_cont_i);
        al.i(this.geE, e.f.video_play_count_bg);
        this.geE.setText(StringUtils.translateSecondsToString(this.geA.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gKi = false;
            al.c(this.gKc, e.f.ad_icon_sound_close);
        } else {
            this.gKi = true;
            al.c(this.gKd, e.f.ad_icon_sound_open);
            this.gKc.setVisibility(8);
        }
        this.gKd.setOnClickListener(this.mOnClickListener);
        this.gKc.setOnClickListener(this.mOnClickListener);
        this.geI.setOnClickListener(this.mOnClickListener);
        this.geI.setVisibility(8);
        al.j(this.geI, e.d.black_alpha80);
        al.h(this.gKe, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geE.setVisibility(0);
            return;
        }
        this.geE.setVisibility(8);
        this.gKg.setOnClickListener(this.mOnClickListener);
        this.gGp.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geA = videoInfo;
        this.aij = new WeakReference<>(this.mContext.getApplicationContext());
        bup();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gGp, e.f.btn_icon_play_video_n);
        this.gGp.setVisibility(8);
        this.euY.setDefaultErrorResource(0);
        this.euY.setDefaultResource(0);
        this.euY.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.euY.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.euY.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bJN.setOnPreparedListener(this.btz);
        this.bJN.setOnErrorListener(this.bkN);
        this.bJN.setOnCompletionListener(this.bty);
        this.bJN.setOnOutInfoListener(this.btB);
        this.bJN.setOnSurfaceDestroyedListener(this.bkR);
        al.h(this.geE, e.d.cp_cont_i);
        this.geE.setText(StringUtils.translateSecondsToString(this.geA.video_duration.intValue()));
        al.i(this.geE, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gKi = false;
            al.c(this.gKc, e.f.ad_icon_sound_close);
        } else {
            this.gKi = true;
            al.c(this.gKd, e.f.ad_icon_sound_open);
            this.gKc.setVisibility(8);
        }
        this.gKd.setOnClickListener(this.mOnClickListener);
        this.gKc.setOnClickListener(this.mOnClickListener);
        this.geI.setOnClickListener(this.mOnClickListener);
        this.geI.setVisibility(8);
        al.j(this.geI, e.d.black_alpha80);
        al.h(this.gKe, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geE.setVisibility(0);
            return;
        }
        this.geE.setVisibility(8);
        this.gKg.setOnClickListener(this.mOnClickListener);
        this.gGp.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gGL = this.gGK.a(this.gDs, this.gGL);
        if (this.gGL != null) {
            this.gGL.setPageContext(this.mPageContext);
            this.gGL.c(this.gKk);
            this.gGL.setAdvertAppInfo(advertAppInfo);
            this.gGL.a(this.gDs);
            this.gGL.buk();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gGL != null) {
            this.gGL.setDownloadAppCallback(cVar);
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
        this.gKp = i;
        if (this.geA != null && this.geB == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gKj) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gGL != null) {
                    this.gGL.buk();
                }
                this.bJN.setVideoPath(this.geA.video_url);
                this.bJN.start();
                this.gKn = this.bJN.getCurrentPosition();
                this.gGp.setVisibility(8);
                al.c(this.gKg, e.f.icon_video_midplay);
                this.dlx.setVisibility(0);
                this.geI.setVisibility(8);
                this.euY.setForegroundDrawable(0);
                this.geB = 0;
                if (this.mStyle == 1) {
                    this.geE.setVisibility(0);
                } else {
                    this.geE.setVisibility(8);
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
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.geQ);
            com.baidu.adp.lib.g.e.jI().postDelayed(this.geQ, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.geB == 1) {
            w(32, tp(this.gKp), this.bJN.getCurrentPosition(), i);
            this.bJN.pause();
            aa.a(this.aij, false);
            this.gGp.setVisibility(0);
            al.c(this.gKg, e.f.icon_video_midpause);
            this.geB = 2;
        }
    }

    public void autoContinue() {
        if (!this.gKm) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.geB == 2) {
            this.gKp = i;
            ab(33, tp(i), this.bJN.getCurrentPosition());
            this.gKn = this.bJN.getCurrentPosition();
            this.bJN.start();
            if (this.gKi) {
                aa.a(this.aij, true);
            }
            this.gGp.setVisibility(8);
            al.c(this.gKg, e.f.icon_video_midplay);
            this.geB = 1;
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
        if (this.bJN.getCurrentPosition() > 0 && this.geB != -1 && z) {
            int i = 32;
            int currentPosition = this.bJN.getCurrentPosition();
            if (this.bJN.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, tp(this.gKp), currentPosition, this.bJN.isPlaying());
        }
        bup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.geQ);
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gKq);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bJN.stopPlayback();
        this.geB = -1;
        aa.a(this.aij, false);
        this.euY.setForegroundDrawable(0);
        this.euY.setVisibility(0);
        this.dlx.setVisibility(8);
        this.gGp.setVisibility(0);
        al.c(this.gKg, e.f.icon_video_midpause);
        this.gKh.UV();
        this.geI.setVisibility(8);
        if (this.geA != null) {
            this.geE.setText(StringUtils.translateSecondsToString(this.geA.video_duration.intValue()));
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
        return this.geA != null ? this.geA.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(boolean z) {
        if (z) {
            if (this.cML != null) {
                this.cML.setVolume(1.0f, 1.0f);
            }
            al.c(this.gKd, e.f.ad_icon_sound_open);
            al.c(this.gKc, e.f.ad_icon_sound_open);
            if (this.geB == 1) {
                aa.a(this.aij, true);
            }
        } else {
            if (this.cML != null) {
                this.cML.setVolume(0.0f, 0.0f);
            }
            al.c(this.gKd, e.f.ad_icon_sound_close);
            al.c(this.gKc, e.f.ad_icon_sound_close);
            aa.a(this.aij, false);
        }
        this.gKi = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.geB;
    }

    public VideoInfo getData() {
        return this.geA;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.geK;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gJZ && this.gJY != null && this.gJY.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gKa = advertAppInfo;
        this.gKb = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gKa, 303, i, tp(this.gKp), this.geA.video_duration.intValue(), this.mDuration, -1);
        if (this.gGL != null) {
            this.gGL.e(a);
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
        if (this.gKa != null && this.geA != null) {
            this.gKa.page = this.mPage;
            com.baidu.tieba.recapp.report.c.buf().a(f.a(this.gKa, i, this.gKb, i2, this.geA.video_duration.intValue(), a.hi(i3), i4));
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
                c(str, this.gKn, i3, this.mDuration, str2, tq(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gDr != null && "cpv".equals(this.gDr.gEo) && !TextUtils.isEmpty(this.gDr.gEp)) {
            new com.baidu.tieba.recapp.request.a(this.gDr.gEp).a(str, i, i2, i3, str2, str3);
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
            this.gJY = view;
            this.gJZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gKq);
            if (this.dFr != null) {
                this.dFr.cancel();
            }
            this.gKf.setVisibility(0);
            if (this.geB == 1) {
                al.c(this.gKg, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gKg, e.f.icon_video_midpause);
                return;
            }
        }
        this.gKf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buq() {
        switch (this.geB) {
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
                this.gKm = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mA(true);
                    return;
                }
                return;
            case 2:
                this.gKm = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jI().removeCallbacks(this.gKq);
                    com.baidu.adp.lib.g.e.jI().postDelayed(this.gKq, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bur() {
        if (!this.gKl && this.dFr != null) {
            this.gKf.startAnimation(this.dFr);
            this.gKl = true;
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
                    DistributeVideoView.this.gKf.setVisibility(8);
                    DistributeVideoView.this.gKl = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
