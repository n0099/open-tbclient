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
    private WeakReference<Context> adl;
    private QuickVideoView bBg;
    private QuickVideoView.b bgC;
    private g.b bgy;
    private g.e bpA;
    private g.a bpx;
    private g.f bpy;
    private g cEr;
    private View ddp;
    private Animation dxq;
    private String eXB;
    private ForeDrawableImageView eng;
    private VideoInfo fWZ;
    private int fXa;
    private TextView fXd;
    private View fXh;
    private long fXj;
    private Runnable fXp;
    private View gCA;
    private boolean gCB;
    private AdvertAppInfo gCC;
    private int gCD;
    private ImageView gCE;
    private ImageView gCF;
    private TextView gCG;
    private View gCH;
    private ImageView gCI;
    private VideoControllerView gCJ;
    private boolean gCK;
    private long gCL;
    private b gCM;
    boolean gCN;
    boolean gCO;
    private int gCP;
    boolean gCQ;
    private int gCR;
    private Runnable gCS;
    private AdCard.a gvQ;
    private AdCard.f gvR;
    private String gvV;
    private ImageView gyP;
    private ViewGroup gzj;
    private d gzk;
    private e gzl;
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
        this.gCB = false;
        this.adl = null;
        this.fXa = -1;
        this.fXj = 0L;
        this.gCK = false;
        this.gCL = 0L;
        this.mStyle = 1;
        this.gCN = false;
        this.gCO = false;
        this.gCQ = false;
        this.gCR = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fXh) {
                    DistributeVideoView.this.fXh.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gCF || view == DistributeVideoView.this.gCE) {
                    DistributeVideoView.this.mh(DistributeVideoView.this.gCK ? false : true);
                } else if (view == DistributeVideoView.this.gyP || view == DistributeVideoView.this.gCI) {
                    DistributeVideoView.this.brb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gCC == null || !DistributeVideoView.this.gCC.uJ()) {
                    DistributeVideoView.this.brb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gCC != null) {
                        WebVideoActivity.gvK = new WebVideoActivity.a();
                        WebVideoActivity.gvK.gvU = DistributeVideoView.this.gCC;
                        WebVideoActivity.gvK.gvV = "DETAIL";
                        WebVideoActivity.gvK.mPageNum = DistributeVideoView.this.gCD;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eXB) ? DistributeVideoView.this.eXB : DistributeVideoView.this.gCC.agi, true, true, true, DistributeVideoView.this.fWZ.video_url, DistributeVideoView.this.fWZ.thumbnail_url, DistributeVideoView.this.fWZ.video_width.intValue() / DistributeVideoView.this.fWZ.video_height.intValue(), DistributeVideoView.this.fWZ.video_duration.intValue());
                    if (DistributeVideoView.this.gvQ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gvQ.gwO);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gvQ.gwP);
                    }
                    if (DistributeVideoView.this.gvR != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gvR.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pY(DistributeVideoView.this.parallelChargeInfo.eWU);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eWX.iterator();
                        while (it.hasNext()) {
                            c.pY(it.next());
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
                        if (DistributeVideoView.this.fXa != 1) {
                            if (DistributeVideoView.this.bBg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fXa = 1;
                                DistributeVideoView.this.ddp.setVisibility(8);
                                DistributeVideoView.this.eng.setVisibility(8);
                                DistributeVideoView.this.mh(DistributeVideoView.this.gCK);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gCJ.setPlayer(DistributeVideoView.this.bBg);
                                    DistributeVideoView.this.gCJ.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fWZ.video_duration.intValue()));
                                    DistributeVideoView.this.gCJ.showProgress();
                                    DistributeVideoView.this.mi(true);
                                    com.baidu.adp.lib.g.e.jt().removeCallbacks(DistributeVideoView.this.gCS);
                                    com.baidu.adp.lib.g.e.jt().postDelayed(DistributeVideoView.this.gCS, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fXj = DistributeVideoView.this.bBg.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bBg.getDuration() - DistributeVideoView.this.bBg.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fXd.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fXa == 1) {
                            if (DistributeVideoView.this.fXj == DistributeVideoView.this.bBg.getCurrentPosition()) {
                                DistributeVideoView.this.ddp.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fXj = DistributeVideoView.this.bBg.getCurrentPosition();
                                DistributeVideoView.this.ddp.setVisibility(8);
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
        this.bpy = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gCP = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cEr = gVar;
                    DistributeVideoView.this.cEr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gCC != null) {
                    if (DistributeVideoView.this.gCQ && "DETAIL".equals(DistributeVideoView.this.gCC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), 0);
                }
                return false;
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bra();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), gVar.getCurrentPosition());
                DistributeVideoView.this.eng.setForegroundDrawable(0);
                DistributeVideoView.this.gyP.setVisibility(8);
                DistributeVideoView.this.fXh.setVisibility(0);
                return true;
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gCL = System.currentTimeMillis();
                DistributeVideoView.this.gCQ = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), gVar.getDuration());
                DistributeVideoView.this.bra();
                if (DistributeVideoView.this.gzl != null) {
                    DistributeVideoView.this.gzl.bqU();
                    DistributeVideoView.this.fXd.setVisibility(8);
                    DistributeVideoView.this.gyP.setVisibility(8);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fXp = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fWZ != null && DistributeVideoView.this.bBg != null) {
                    DistributeVideoView.this.sR(1);
                }
            }
        };
        this.gCS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.brc();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gCB = false;
        this.adl = null;
        this.fXa = -1;
        this.fXj = 0L;
        this.gCK = false;
        this.gCL = 0L;
        this.mStyle = 1;
        this.gCN = false;
        this.gCO = false;
        this.gCQ = false;
        this.gCR = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fXh) {
                    DistributeVideoView.this.fXh.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gCF || view == DistributeVideoView.this.gCE) {
                    DistributeVideoView.this.mh(DistributeVideoView.this.gCK ? false : true);
                } else if (view == DistributeVideoView.this.gyP || view == DistributeVideoView.this.gCI) {
                    DistributeVideoView.this.brb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gCC == null || !DistributeVideoView.this.gCC.uJ()) {
                    DistributeVideoView.this.brb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gCC != null) {
                        WebVideoActivity.gvK = new WebVideoActivity.a();
                        WebVideoActivity.gvK.gvU = DistributeVideoView.this.gCC;
                        WebVideoActivity.gvK.gvV = "DETAIL";
                        WebVideoActivity.gvK.mPageNum = DistributeVideoView.this.gCD;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eXB) ? DistributeVideoView.this.eXB : DistributeVideoView.this.gCC.agi, true, true, true, DistributeVideoView.this.fWZ.video_url, DistributeVideoView.this.fWZ.thumbnail_url, DistributeVideoView.this.fWZ.video_width.intValue() / DistributeVideoView.this.fWZ.video_height.intValue(), DistributeVideoView.this.fWZ.video_duration.intValue());
                    if (DistributeVideoView.this.gvQ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gvQ.gwO);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gvQ.gwP);
                    }
                    if (DistributeVideoView.this.gvR != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gvR.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pY(DistributeVideoView.this.parallelChargeInfo.eWU);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eWX.iterator();
                        while (it.hasNext()) {
                            c.pY(it.next());
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
                        if (DistributeVideoView.this.fXa != 1) {
                            if (DistributeVideoView.this.bBg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fXa = 1;
                                DistributeVideoView.this.ddp.setVisibility(8);
                                DistributeVideoView.this.eng.setVisibility(8);
                                DistributeVideoView.this.mh(DistributeVideoView.this.gCK);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gCJ.setPlayer(DistributeVideoView.this.bBg);
                                    DistributeVideoView.this.gCJ.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fWZ.video_duration.intValue()));
                                    DistributeVideoView.this.gCJ.showProgress();
                                    DistributeVideoView.this.mi(true);
                                    com.baidu.adp.lib.g.e.jt().removeCallbacks(DistributeVideoView.this.gCS);
                                    com.baidu.adp.lib.g.e.jt().postDelayed(DistributeVideoView.this.gCS, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fXj = DistributeVideoView.this.bBg.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bBg.getDuration() - DistributeVideoView.this.bBg.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fXd.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fXa == 1) {
                            if (DistributeVideoView.this.fXj == DistributeVideoView.this.bBg.getCurrentPosition()) {
                                DistributeVideoView.this.ddp.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fXj = DistributeVideoView.this.bBg.getCurrentPosition();
                                DistributeVideoView.this.ddp.setVisibility(8);
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
        this.bpy = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gCP = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cEr = gVar;
                    DistributeVideoView.this.cEr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gCC != null) {
                    if (DistributeVideoView.this.gCQ && "DETAIL".equals(DistributeVideoView.this.gCC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), 0);
                }
                return false;
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bra();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), gVar.getCurrentPosition());
                DistributeVideoView.this.eng.setForegroundDrawable(0);
                DistributeVideoView.this.gyP.setVisibility(8);
                DistributeVideoView.this.fXh.setVisibility(0);
                return true;
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gCL = System.currentTimeMillis();
                DistributeVideoView.this.gCQ = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), gVar.getDuration());
                DistributeVideoView.this.bra();
                if (DistributeVideoView.this.gzl != null) {
                    DistributeVideoView.this.gzl.bqU();
                    DistributeVideoView.this.fXd.setVisibility(8);
                    DistributeVideoView.this.gyP.setVisibility(8);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fXp = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fWZ != null && DistributeVideoView.this.bBg != null) {
                    DistributeVideoView.this.sR(1);
                }
            }
        };
        this.gCS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.brc();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gCB = false;
        this.adl = null;
        this.fXa = -1;
        this.fXj = 0L;
        this.gCK = false;
        this.gCL = 0L;
        this.mStyle = 1;
        this.gCN = false;
        this.gCO = false;
        this.gCQ = false;
        this.gCR = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fXh) {
                    DistributeVideoView.this.fXh.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gCF || view == DistributeVideoView.this.gCE) {
                    DistributeVideoView.this.mh(DistributeVideoView.this.gCK ? false : true);
                } else if (view == DistributeVideoView.this.gyP || view == DistributeVideoView.this.gCI) {
                    DistributeVideoView.this.brb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gCC == null || !DistributeVideoView.this.gCC.uJ()) {
                    DistributeVideoView.this.brb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gCC != null) {
                        WebVideoActivity.gvK = new WebVideoActivity.a();
                        WebVideoActivity.gvK.gvU = DistributeVideoView.this.gCC;
                        WebVideoActivity.gvK.gvV = "DETAIL";
                        WebVideoActivity.gvK.mPageNum = DistributeVideoView.this.gCD;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eXB) ? DistributeVideoView.this.eXB : DistributeVideoView.this.gCC.agi, true, true, true, DistributeVideoView.this.fWZ.video_url, DistributeVideoView.this.fWZ.thumbnail_url, DistributeVideoView.this.fWZ.video_width.intValue() / DistributeVideoView.this.fWZ.video_height.intValue(), DistributeVideoView.this.fWZ.video_duration.intValue());
                    if (DistributeVideoView.this.gvQ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gvQ.gwO);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gvQ.gwP);
                    }
                    if (DistributeVideoView.this.gvR != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gvR.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pY(DistributeVideoView.this.parallelChargeInfo.eWU);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eWX.iterator();
                        while (it.hasNext()) {
                            c.pY(it.next());
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
                        if (DistributeVideoView.this.fXa != 1) {
                            if (DistributeVideoView.this.bBg.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fXa = 1;
                                DistributeVideoView.this.ddp.setVisibility(8);
                                DistributeVideoView.this.eng.setVisibility(8);
                                DistributeVideoView.this.mh(DistributeVideoView.this.gCK);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gCJ.setPlayer(DistributeVideoView.this.bBg);
                                    DistributeVideoView.this.gCJ.X(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fWZ.video_duration.intValue()));
                                    DistributeVideoView.this.gCJ.showProgress();
                                    DistributeVideoView.this.mi(true);
                                    com.baidu.adp.lib.g.e.jt().removeCallbacks(DistributeVideoView.this.gCS);
                                    com.baidu.adp.lib.g.e.jt().postDelayed(DistributeVideoView.this.gCS, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fXj = DistributeVideoView.this.bBg.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bBg.getDuration() - DistributeVideoView.this.bBg.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fXd.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fXa == 1) {
                            if (DistributeVideoView.this.fXj == DistributeVideoView.this.bBg.getCurrentPosition()) {
                                DistributeVideoView.this.ddp.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fXj = DistributeVideoView.this.bBg.getCurrentPosition();
                                DistributeVideoView.this.ddp.setVisibility(8);
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
        this.bpy = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gCP = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cEr = gVar;
                    DistributeVideoView.this.cEr.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bpA = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gCC != null) {
                    if (DistributeVideoView.this.gCQ && "DETAIL".equals(DistributeVideoView.this.gCC.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), 0);
                }
                return false;
            }
        };
        this.bgy = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bra();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), gVar.getCurrentPosition());
                DistributeVideoView.this.eng.setForegroundDrawable(0);
                DistributeVideoView.this.gyP.setVisibility(8);
                DistributeVideoView.this.fXh.setVisibility(0);
                return true;
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gCL = System.currentTimeMillis();
                DistributeVideoView.this.gCQ = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.sS(DistributeVideoView.this.gCR), gVar.getDuration());
                DistributeVideoView.this.bra();
                if (DistributeVideoView.this.gzl != null) {
                    DistributeVideoView.this.gzl.bqU();
                    DistributeVideoView.this.fXd.setVisibility(8);
                    DistributeVideoView.this.gyP.setVisibility(8);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fXp = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fWZ != null && DistributeVideoView.this.bBg != null) {
                    DistributeVideoView.this.sR(1);
                }
            }
        };
        this.gCS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.brc();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.eXB = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gCM = adCard;
        if (this.gCM != null) {
            this.parallelChargeInfo = this.gCM.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bBg = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gyP = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.eng = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.ddp = this.mRootView.findViewById(e.g.distribute_loading);
            this.fXd = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.fXh = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gCG = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gCE = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gCH = this.mRootView.findViewById(e.g.distribute_control);
            this.gCI = (ImageView) this.gCH.findViewById(e.g.distribute_play_icon);
            this.gCF = (ImageView) this.gCH.findViewById(e.g.distribute_voice);
            this.gCJ = (VideoControllerView) this.gCH.findViewById(e.g.distribute_process);
            this.gzj = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gzk = new d(context, this.gzj);
        }
    }

    private boolean bjd() {
        return this.mStyle == 1 ? q.bjd() : j.kL();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            brd();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gvQ = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gvR = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fWZ = videoInfo;
        this.mDuration = this.fWZ.video_duration.intValue() * 1000;
        this.adl = new WeakReference<>(this.mContext.getApplicationContext());
        bra();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0141e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.fWZ.video_width.intValue() > 0 ? (this.fWZ.video_height.intValue() * aO) / this.fWZ.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gyP, e.f.btn_icon_play_video_n);
        this.gyP.setVisibility(8);
        this.eng.setDefaultErrorResource(0);
        this.eng.setDefaultResource(0);
        this.eng.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eng.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eng.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bBg.setOnPreparedListener(this.bpy);
        this.bBg.setOnErrorListener(this.bgy);
        this.bBg.setOnCompletionListener(this.bpx);
        this.bBg.setOnOutInfoListener(this.bpA);
        this.bBg.setOnSurfaceDestroyedListener(this.bgC);
        al.h(this.fXd, e.d.cp_cont_i);
        al.i(this.fXd, e.f.video_play_count_bg);
        this.fXd.setText(StringUtils.translateSecondsToString(this.fWZ.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gCK = false;
            al.c(this.gCE, e.f.ad_icon_sound_close);
        } else {
            this.gCK = true;
            al.c(this.gCF, e.f.ad_icon_sound_open);
            this.gCE.setVisibility(8);
        }
        this.gCF.setOnClickListener(this.mOnClickListener);
        this.gCE.setOnClickListener(this.mOnClickListener);
        this.fXh.setOnClickListener(this.mOnClickListener);
        this.fXh.setVisibility(8);
        al.j(this.fXh, e.d.black_alpha80);
        al.h(this.gCG, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fXd.setVisibility(0);
            return;
        }
        this.fXd.setVisibility(8);
        this.gCI.setOnClickListener(this.mOnClickListener);
        this.gyP.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fWZ = videoInfo;
        this.adl = new WeakReference<>(this.mContext.getApplicationContext());
        bra();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gyP, e.f.btn_icon_play_video_n);
        this.gyP.setVisibility(8);
        this.eng.setDefaultErrorResource(0);
        this.eng.setDefaultResource(0);
        this.eng.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eng.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eng.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bBg.setOnPreparedListener(this.bpy);
        this.bBg.setOnErrorListener(this.bgy);
        this.bBg.setOnCompletionListener(this.bpx);
        this.bBg.setOnOutInfoListener(this.bpA);
        this.bBg.setOnSurfaceDestroyedListener(this.bgC);
        al.h(this.fXd, e.d.cp_cont_i);
        this.fXd.setText(StringUtils.translateSecondsToString(this.fWZ.video_duration.intValue()));
        al.i(this.fXd, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gCK = false;
            al.c(this.gCE, e.f.ad_icon_sound_close);
        } else {
            this.gCK = true;
            al.c(this.gCF, e.f.ad_icon_sound_open);
            this.gCE.setVisibility(8);
        }
        this.gCF.setOnClickListener(this.mOnClickListener);
        this.gCE.setOnClickListener(this.mOnClickListener);
        this.fXh.setOnClickListener(this.mOnClickListener);
        this.fXh.setVisibility(8);
        al.j(this.fXh, e.d.black_alpha80);
        al.h(this.gCG, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fXd.setVisibility(0);
            return;
        }
        this.fXd.setVisibility(8);
        this.gCI.setOnClickListener(this.mOnClickListener);
        this.gyP.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gzl = this.gzk.a(this.gvR, this.gzl);
        if (this.gzl != null) {
            this.gzl.setPageContext(this.mPageContext);
            this.gzl.c(this.gCM);
            this.gzl.setAdvertAppInfo(advertAppInfo);
            this.gzl.a(this.gvR);
            this.gzl.bqV();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gzl != null) {
            this.gzl.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(e.C0141e.ds16) + i;
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
        this.bpx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sR(int i) {
        this.gCR = i;
        if (this.fWZ != null && this.fXa == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gCL) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gzl != null) {
                    this.gzl.bqV();
                }
                this.bBg.setVideoPath(this.fWZ.video_url);
                this.bBg.start();
                this.gCP = this.bBg.getCurrentPosition();
                this.gyP.setVisibility(8);
                al.c(this.gCI, e.f.icon_video_midplay);
                this.ddp.setVisibility(0);
                this.fXh.setVisibility(8);
                this.eng.setForegroundDrawable(0);
                this.fXa = 0;
                if (this.mStyle == 1) {
                    this.fXd.setVisibility(0);
                } else {
                    this.fXd.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        sR(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bjd()) {
            if (i <= 0) {
                sR(1);
                return;
            }
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fXp);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.fXp, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fXa == 1) {
            w(32, sS(this.gCR), this.bBg.getCurrentPosition(), i);
            this.bBg.pause();
            aa.a(this.adl, false);
            this.gyP.setVisibility(0);
            al.c(this.gCI, e.f.icon_video_midpause);
            this.fXa = 2;
        }
    }

    public void autoContinue() {
        if (!this.gCO) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fXa == 2) {
            this.gCR = i;
            ab(33, sS(i), this.bBg.getCurrentPosition());
            this.gCP = this.bBg.getCurrentPosition();
            this.bBg.start();
            if (this.gCK) {
                aa.a(this.adl, true);
            }
            this.gyP.setVisibility(8);
            al.c(this.gCI, e.f.icon_video_midplay);
            this.fXa = 1;
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
        if (this.bBg.getCurrentPosition() > 0 && this.fXa != -1 && z) {
            int i = 32;
            int currentPosition = this.bBg.getCurrentPosition();
            if (this.bBg.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, sS(this.gCR), currentPosition, this.bBg.isPlaying());
        }
        bra();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.fXp);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gCS);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bBg.stopPlayback();
        this.fXa = -1;
        aa.a(this.adl, false);
        this.eng.setForegroundDrawable(0);
        this.eng.setVisibility(0);
        this.ddp.setVisibility(8);
        this.gyP.setVisibility(0);
        al.c(this.gCI, e.f.icon_video_midpause);
        this.gCJ.SZ();
        this.fXh.setVisibility(8);
        if (this.fWZ != null) {
            this.fXd.setText(StringUtils.translateSecondsToString(this.fWZ.video_duration.intValue()));
        }
        this.cEr = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sS(int i) {
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
        return this.fWZ != null ? this.fWZ.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mh(boolean z) {
        if (z) {
            if (this.cEr != null) {
                this.cEr.setVolume(1.0f, 1.0f);
            }
            al.c(this.gCF, e.f.ad_icon_sound_open);
            al.c(this.gCE, e.f.ad_icon_sound_open);
            if (this.fXa == 1) {
                aa.a(this.adl, true);
            }
        } else {
            if (this.cEr != null) {
                this.cEr.setVolume(0.0f, 0.0f);
            }
            al.c(this.gCF, e.f.ad_icon_sound_close);
            al.c(this.gCE, e.f.ad_icon_sound_close);
            aa.a(this.adl, false);
        }
        this.gCK = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fXa;
    }

    public VideoInfo getData() {
        return this.fWZ;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fXj;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gCB && this.gCA != null && this.gCA.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gCC = advertAppInfo;
        this.gCD = i;
        this.gvV = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gCC, 303, i, sS(this.gCR), this.fWZ.video_duration.intValue(), this.mDuration, -1);
        if (this.gzl != null) {
            this.gzl.e(a);
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
        if (this.gCC != null && this.fWZ != null) {
            this.gCC.page = this.gvV;
            com.baidu.tieba.recapp.report.c.bqQ().a(f.a(this.gCC, i, this.gCD, i2, this.fWZ.video_duration.intValue(), a.ha(i3), i4));
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
                if ("DETAIL".equals(this.gvV)) {
                    str2 = "det";
                } else if ("FRS".equals(this.gvV)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.gvV)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gCP, i3, this.mDuration, str2, sT(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gvQ != null && "cpv".equals(this.gvQ.gwO) && !TextUtils.isEmpty(this.gvQ.gwP)) {
            new com.baidu.tieba.recapp.request.a(this.gvQ.gwP).a(str, i, i2, i3, str2, str3);
        }
    }

    private String sT(int i) {
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
            this.gCA = view;
            this.gCB = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gCS);
            if (this.dxq != null) {
                this.dxq.cancel();
            }
            this.gCH.setVisibility(0);
            if (this.fXa == 1) {
                al.c(this.gCI, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gCI, e.f.icon_video_midpause);
                return;
            }
        }
        this.gCH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
        switch (this.fXa) {
            case -1:
                if (!j.kK() && this.mPageContext != null) {
                    this.mPageContext.showToast(e.j.neterror);
                    return;
                } else if (!j.kL() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cp(e.j.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).yl();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gCO = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mi(true);
                    return;
                }
                return;
            case 2:
                this.gCO = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gCS);
                    com.baidu.adp.lib.g.e.jt().postDelayed(this.gCS, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brc() {
        if (!this.gCN && this.dxq != null) {
            this.gCH.startAnimation(this.dxq);
            this.gCN = true;
        }
    }

    private void brd() {
        if (this.mPageContext != null) {
            this.dxq = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dxq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gCH.setVisibility(8);
                    DistributeVideoView.this.gCN = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
