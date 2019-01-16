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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.ab;
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
    private WeakReference<Context> amS;
    private QuickVideoView bPb;
    private g.b bpN;
    private QuickVideoView.b bpR;
    private g.f byA;
    private g.e byC;
    private g.a byz;
    private g cXZ;
    private Animation dQC;
    private ForeDrawableImageView eGN;
    private String frg;
    private AdCard.a gPE;
    private AdCard.f gPF;
    private ImageView gSC;
    private ViewGroup gSW;
    private d gSX;
    private e gSY;
    private long gWA;
    private b gWB;
    boolean gWC;
    private int gWD;
    boolean gWE;
    private int gWF;
    private Runnable gWG;
    private View gWp;
    private boolean gWq;
    private AdvertAppInfo gWr;
    private int gWs;
    private ImageView gWt;
    private ImageView gWu;
    private TextView gWv;
    private View gWw;
    private ImageView gWx;
    private VideoControllerView gWy;
    private boolean gWz;
    private VideoInfo gqJ;
    private int gqK;
    private TextView gqN;
    private View gqR;
    private long gqT;
    private Runnable gqZ;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    boolean mIsInAnimation;
    private View mLoadingView;
    private View.OnClickListener mOnClickListener;
    private String mPage;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    public DistributeVideoView(Context context) {
        super(context);
        this.gWq = false;
        this.amS = null;
        this.gqK = -1;
        this.gqT = 0L;
        this.gWz = false;
        this.gWA = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gWC = false;
        this.gWE = false;
        this.gWF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gqR) {
                    DistributeVideoView.this.gqR.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gWu || view == DistributeVideoView.this.gWt) {
                    DistributeVideoView.this.mR(DistributeVideoView.this.gWz ? false : true);
                } else if (view == DistributeVideoView.this.gSC || view == DistributeVideoView.this.gWx) {
                    DistributeVideoView.this.bxb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gWr == null || !DistributeVideoView.this.gWr.yr()) {
                    DistributeVideoView.this.bxb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gWr != null) {
                        WebVideoActivity.gPy = new WebVideoActivity.a();
                        WebVideoActivity.gPy.gPI = DistributeVideoView.this.gWr;
                        WebVideoActivity.gPy.mPage = "DETAIL";
                        WebVideoActivity.gPy.mPageNum = DistributeVideoView.this.gWs;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.frg) ? DistributeVideoView.this.frg : DistributeVideoView.this.gWr.apV, true, true, true, DistributeVideoView.this.gqJ.video_url, DistributeVideoView.this.gqJ.thumbnail_url, DistributeVideoView.this.gqJ.video_width.intValue() / DistributeVideoView.this.gqJ.video_height.intValue(), DistributeVideoView.this.gqJ.video_duration.intValue());
                    if (DistributeVideoView.this.gPE != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gPE.gQB);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gPE.gQC);
                    }
                    if (DistributeVideoView.this.gPF != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gPF.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rw(DistributeVideoView.this.parallelChargeInfo.fqz);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fqC.iterator();
                        while (it.hasNext()) {
                            c.rw(it.next());
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
                        if (DistributeVideoView.this.gqK != 1) {
                            if (DistributeVideoView.this.bPb.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gqK = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGN.setVisibility(8);
                                DistributeVideoView.this.mR(DistributeVideoView.this.gWz);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gWy.setPlayer(DistributeVideoView.this.bPb);
                                    DistributeVideoView.this.gWy.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gqJ.video_duration.intValue()));
                                    DistributeVideoView.this.gWy.showProgress();
                                    DistributeVideoView.this.mS(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gWG);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gWG, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gqT = DistributeVideoView.this.bPb.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bPb.getDuration() - DistributeVideoView.this.bPb.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gqN.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gqK == 1) {
                            if (DistributeVideoView.this.gqT == DistributeVideoView.this.bPb.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gqT = DistributeVideoView.this.bPb.getCurrentPosition();
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
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
        this.byA = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gWD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cXZ = gVar;
                    DistributeVideoView.this.cXZ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gWr != null) {
                    if (DistributeVideoView.this.gWE && "DETAIL".equals(DistributeVideoView.this.gWr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.us(DistributeVideoView.this.gWF), 0);
                }
                return false;
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bxa();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.us(DistributeVideoView.this.gWF), gVar.getCurrentPosition());
                DistributeVideoView.this.eGN.setForegroundDrawable(0);
                DistributeVideoView.this.gSC.setVisibility(8);
                DistributeVideoView.this.gqR.setVisibility(0);
                return true;
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gWA = System.currentTimeMillis();
                DistributeVideoView.this.gWE = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.us(DistributeVideoView.this.gWF), gVar.getDuration());
                DistributeVideoView.this.bxa();
                if (DistributeVideoView.this.gSY != null) {
                    DistributeVideoView.this.gSY.bwS();
                    DistributeVideoView.this.gqN.setVisibility(8);
                    DistributeVideoView.this.gSC.setVisibility(8);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gqZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gqJ != null && DistributeVideoView.this.bPb != null) {
                    DistributeVideoView.this.ur(1);
                }
            }
        };
        this.gWG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bxc();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWq = false;
        this.amS = null;
        this.gqK = -1;
        this.gqT = 0L;
        this.gWz = false;
        this.gWA = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gWC = false;
        this.gWE = false;
        this.gWF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gqR) {
                    DistributeVideoView.this.gqR.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gWu || view == DistributeVideoView.this.gWt) {
                    DistributeVideoView.this.mR(DistributeVideoView.this.gWz ? false : true);
                } else if (view == DistributeVideoView.this.gSC || view == DistributeVideoView.this.gWx) {
                    DistributeVideoView.this.bxb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gWr == null || !DistributeVideoView.this.gWr.yr()) {
                    DistributeVideoView.this.bxb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gWr != null) {
                        WebVideoActivity.gPy = new WebVideoActivity.a();
                        WebVideoActivity.gPy.gPI = DistributeVideoView.this.gWr;
                        WebVideoActivity.gPy.mPage = "DETAIL";
                        WebVideoActivity.gPy.mPageNum = DistributeVideoView.this.gWs;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.frg) ? DistributeVideoView.this.frg : DistributeVideoView.this.gWr.apV, true, true, true, DistributeVideoView.this.gqJ.video_url, DistributeVideoView.this.gqJ.thumbnail_url, DistributeVideoView.this.gqJ.video_width.intValue() / DistributeVideoView.this.gqJ.video_height.intValue(), DistributeVideoView.this.gqJ.video_duration.intValue());
                    if (DistributeVideoView.this.gPE != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gPE.gQB);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gPE.gQC);
                    }
                    if (DistributeVideoView.this.gPF != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gPF.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rw(DistributeVideoView.this.parallelChargeInfo.fqz);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fqC.iterator();
                        while (it.hasNext()) {
                            c.rw(it.next());
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
                        if (DistributeVideoView.this.gqK != 1) {
                            if (DistributeVideoView.this.bPb.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gqK = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGN.setVisibility(8);
                                DistributeVideoView.this.mR(DistributeVideoView.this.gWz);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gWy.setPlayer(DistributeVideoView.this.bPb);
                                    DistributeVideoView.this.gWy.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gqJ.video_duration.intValue()));
                                    DistributeVideoView.this.gWy.showProgress();
                                    DistributeVideoView.this.mS(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gWG);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gWG, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gqT = DistributeVideoView.this.bPb.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bPb.getDuration() - DistributeVideoView.this.bPb.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gqN.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gqK == 1) {
                            if (DistributeVideoView.this.gqT == DistributeVideoView.this.bPb.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gqT = DistributeVideoView.this.bPb.getCurrentPosition();
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
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
        this.byA = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gWD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cXZ = gVar;
                    DistributeVideoView.this.cXZ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gWr != null) {
                    if (DistributeVideoView.this.gWE && "DETAIL".equals(DistributeVideoView.this.gWr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.us(DistributeVideoView.this.gWF), 0);
                }
                return false;
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bxa();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.us(DistributeVideoView.this.gWF), gVar.getCurrentPosition());
                DistributeVideoView.this.eGN.setForegroundDrawable(0);
                DistributeVideoView.this.gSC.setVisibility(8);
                DistributeVideoView.this.gqR.setVisibility(0);
                return true;
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gWA = System.currentTimeMillis();
                DistributeVideoView.this.gWE = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.us(DistributeVideoView.this.gWF), gVar.getDuration());
                DistributeVideoView.this.bxa();
                if (DistributeVideoView.this.gSY != null) {
                    DistributeVideoView.this.gSY.bwS();
                    DistributeVideoView.this.gqN.setVisibility(8);
                    DistributeVideoView.this.gSC.setVisibility(8);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gqZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gqJ != null && DistributeVideoView.this.bPb != null) {
                    DistributeVideoView.this.ur(1);
                }
            }
        };
        this.gWG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bxc();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWq = false;
        this.amS = null;
        this.gqK = -1;
        this.gqT = 0L;
        this.gWz = false;
        this.gWA = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gWC = false;
        this.gWE = false;
        this.gWF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gqR) {
                    DistributeVideoView.this.gqR.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gWu || view == DistributeVideoView.this.gWt) {
                    DistributeVideoView.this.mR(DistributeVideoView.this.gWz ? false : true);
                } else if (view == DistributeVideoView.this.gSC || view == DistributeVideoView.this.gWx) {
                    DistributeVideoView.this.bxb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gWr == null || !DistributeVideoView.this.gWr.yr()) {
                    DistributeVideoView.this.bxb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gWr != null) {
                        WebVideoActivity.gPy = new WebVideoActivity.a();
                        WebVideoActivity.gPy.gPI = DistributeVideoView.this.gWr;
                        WebVideoActivity.gPy.mPage = "DETAIL";
                        WebVideoActivity.gPy.mPageNum = DistributeVideoView.this.gWs;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.frg) ? DistributeVideoView.this.frg : DistributeVideoView.this.gWr.apV, true, true, true, DistributeVideoView.this.gqJ.video_url, DistributeVideoView.this.gqJ.thumbnail_url, DistributeVideoView.this.gqJ.video_width.intValue() / DistributeVideoView.this.gqJ.video_height.intValue(), DistributeVideoView.this.gqJ.video_duration.intValue());
                    if (DistributeVideoView.this.gPE != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gPE.gQB);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gPE.gQC);
                    }
                    if (DistributeVideoView.this.gPF != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gPF.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rw(DistributeVideoView.this.parallelChargeInfo.fqz);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fqC.iterator();
                        while (it.hasNext()) {
                            c.rw(it.next());
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
                        if (DistributeVideoView.this.gqK != 1) {
                            if (DistributeVideoView.this.bPb.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gqK = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGN.setVisibility(8);
                                DistributeVideoView.this.mR(DistributeVideoView.this.gWz);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gWy.setPlayer(DistributeVideoView.this.bPb);
                                    DistributeVideoView.this.gWy.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gqJ.video_duration.intValue()));
                                    DistributeVideoView.this.gWy.showProgress();
                                    DistributeVideoView.this.mS(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gWG);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gWG, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gqT = DistributeVideoView.this.bPb.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bPb.getDuration() - DistributeVideoView.this.bPb.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gqN.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gqK == 1) {
                            if (DistributeVideoView.this.gqT == DistributeVideoView.this.bPb.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gqT = DistributeVideoView.this.bPb.getCurrentPosition();
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
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
        this.byA = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gWD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cXZ = gVar;
                    DistributeVideoView.this.cXZ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.byC = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gWr != null) {
                    if (DistributeVideoView.this.gWE && "DETAIL".equals(DistributeVideoView.this.gWr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.us(DistributeVideoView.this.gWF), 0);
                }
                return false;
            }
        };
        this.bpN = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bxa();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.us(DistributeVideoView.this.gWF), gVar.getCurrentPosition());
                DistributeVideoView.this.eGN.setForegroundDrawable(0);
                DistributeVideoView.this.gSC.setVisibility(8);
                DistributeVideoView.this.gqR.setVisibility(0);
                return true;
            }
        };
        this.byz = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gWA = System.currentTimeMillis();
                DistributeVideoView.this.gWE = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.us(DistributeVideoView.this.gWF), gVar.getDuration());
                DistributeVideoView.this.bxa();
                if (DistributeVideoView.this.gSY != null) {
                    DistributeVideoView.this.gSY.bwS();
                    DistributeVideoView.this.gqN.setVisibility(8);
                    DistributeVideoView.this.gSC.setVisibility(8);
                }
            }
        };
        this.bpR = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gqZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gqJ != null && DistributeVideoView.this.bPb != null) {
                    DistributeVideoView.this.ur(1);
                }
            }
        };
        this.gWG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bxc();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.frg = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gWB = adCard;
        if (this.gWB != null) {
            this.parallelChargeInfo = this.gWB.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bPb = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gSC = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.eGN = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(e.g.distribute_loading);
            this.gqN = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.gqR = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gWv = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gWt = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gWw = this.mRootView.findViewById(e.g.distribute_control);
            this.gWx = (ImageView) this.gWw.findViewById(e.g.distribute_play_icon);
            this.gWu = (ImageView) this.gWw.findViewById(e.g.distribute_voice);
            this.gWy = (VideoControllerView) this.gWw.findViewById(e.g.distribute_process);
            this.gSW = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gSX = new d(context, this.gSW);
        }
    }

    private boolean boY() {
        return this.mStyle == 1 ? q.boY() : j.kW();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bxd();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gPE = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gPF = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gqJ = videoInfo;
        this.mDuration = this.gqJ.video_duration.intValue() * 1000;
        this.amS = new WeakReference<>(this.mContext.getApplicationContext());
        bxa();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.gqJ.video_width.intValue() > 0 ? (this.gqJ.video_height.intValue() * aO) / this.gqJ.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gSC, e.f.btn_icon_play_video_n);
        this.gSC.setVisibility(8);
        this.eGN.setDefaultErrorResource(0);
        this.eGN.setDefaultResource(0);
        this.eGN.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGN.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGN.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bPb.setOnPreparedListener(this.byA);
        this.bPb.setOnErrorListener(this.bpN);
        this.bPb.setOnCompletionListener(this.byz);
        this.bPb.setOnOutInfoListener(this.byC);
        this.bPb.setOnSurfaceDestroyedListener(this.bpR);
        al.h(this.gqN, e.d.cp_cont_i);
        al.i(this.gqN, e.f.video_play_count_bg);
        this.gqN.setText(StringUtils.translateSecondsToString(this.gqJ.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gWz = false;
            al.c(this.gWt, e.f.ad_icon_sound_close);
        } else {
            this.gWz = true;
            al.c(this.gWu, e.f.ad_icon_sound_open);
            this.gWt.setVisibility(8);
        }
        this.gWu.setOnClickListener(this.mOnClickListener);
        this.gWt.setOnClickListener(this.mOnClickListener);
        this.gqR.setOnClickListener(this.mOnClickListener);
        this.gqR.setVisibility(8);
        al.j(this.gqR, e.d.black_alpha80);
        al.h(this.gWv, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gqN.setVisibility(0);
            return;
        }
        this.gqN.setVisibility(8);
        this.gWx.setOnClickListener(this.mOnClickListener);
        this.gSC.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gqJ = videoInfo;
        this.amS = new WeakReference<>(this.mContext.getApplicationContext());
        bxa();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gSC, e.f.btn_icon_play_video_n);
        this.gSC.setVisibility(8);
        this.eGN.setDefaultErrorResource(0);
        this.eGN.setDefaultResource(0);
        this.eGN.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGN.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGN.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bPb.setOnPreparedListener(this.byA);
        this.bPb.setOnErrorListener(this.bpN);
        this.bPb.setOnCompletionListener(this.byz);
        this.bPb.setOnOutInfoListener(this.byC);
        this.bPb.setOnSurfaceDestroyedListener(this.bpR);
        al.h(this.gqN, e.d.cp_cont_i);
        this.gqN.setText(StringUtils.translateSecondsToString(this.gqJ.video_duration.intValue()));
        al.i(this.gqN, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gWz = false;
            al.c(this.gWt, e.f.ad_icon_sound_close);
        } else {
            this.gWz = true;
            al.c(this.gWu, e.f.ad_icon_sound_open);
            this.gWt.setVisibility(8);
        }
        this.gWu.setOnClickListener(this.mOnClickListener);
        this.gWt.setOnClickListener(this.mOnClickListener);
        this.gqR.setOnClickListener(this.mOnClickListener);
        this.gqR.setVisibility(8);
        al.j(this.gqR, e.d.black_alpha80);
        al.h(this.gWv, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gqN.setVisibility(0);
            return;
        }
        this.gqN.setVisibility(8);
        this.gWx.setOnClickListener(this.mOnClickListener);
        this.gSC.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gSY = this.gSX.a(this.gPF, this.gSY);
        if (this.gSY != null) {
            this.gSY.setPageContext(this.mPageContext);
            this.gSY.c(this.gWB);
            this.gSY.setAdvertAppInfo(advertAppInfo);
            this.gSY.a(this.gPF);
            this.gSY.bwT();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gSY != null) {
            this.gSY.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(e.C0210e.ds16) + i;
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
        this.byz = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur(int i) {
        this.gWF = i;
        if (this.gqJ != null && this.gqK == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gWA) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gSY != null) {
                    this.gSY.bwT();
                }
                this.bPb.setVideoPath(this.gqJ.video_url);
                this.bPb.start();
                this.gWD = this.bPb.getCurrentPosition();
                this.gSC.setVisibility(8);
                al.c(this.gWx, e.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.gqR.setVisibility(8);
                this.eGN.setForegroundDrawable(0);
                this.gqK = 0;
                if (this.mStyle == 1) {
                    this.gqN.setVisibility(0);
                } else {
                    this.gqN.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        ur(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (boY()) {
            if (i <= 0) {
                ur(1);
                return;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gqZ);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gqZ, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.gqK == 1) {
            x(32, us(this.gWF), this.bPb.getCurrentPosition(), i);
            this.bPb.pause();
            ab.a(this.amS, false);
            this.gSC.setVisibility(0);
            al.c(this.gWx, e.f.icon_video_midpause);
            this.gqK = 2;
        }
    }

    public void autoContinue() {
        if (!this.gWC) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.gqK == 2) {
            this.gWF = i;
            ab(33, us(i), this.bPb.getCurrentPosition());
            this.gWD = this.bPb.getCurrentPosition();
            this.bPb.start();
            if (this.gWz) {
                ab.a(this.amS, true);
            }
            this.gSC.setVisibility(8);
            al.c(this.gWx, e.f.icon_video_midplay);
            this.gqK = 1;
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
        if (this.bPb.getCurrentPosition() > 0 && this.gqK != -1 && z) {
            int i = 32;
            int currentPosition = this.bPb.getCurrentPosition();
            if (this.bPb.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, us(this.gWF), currentPosition, this.bPb.isPlaying());
        }
        bxa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxa() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gqZ);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gWG);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bPb.stopPlayback();
        this.gqK = -1;
        ab.a(this.amS, false);
        this.eGN.setForegroundDrawable(0);
        this.eGN.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gSC.setVisibility(0);
        al.c(this.gWx, e.f.icon_video_midpause);
        this.gWy.WJ();
        this.gqR.setVisibility(8);
        if (this.gqJ != null) {
            this.gqN.setText(StringUtils.translateSecondsToString(this.gqJ.video_duration.intValue()));
        }
        this.cXZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int us(int i) {
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
        return this.gqJ != null ? this.gqJ.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(boolean z) {
        if (z) {
            if (this.cXZ != null) {
                this.cXZ.setVolume(1.0f, 1.0f);
            }
            al.c(this.gWu, e.f.ad_icon_sound_open);
            al.c(this.gWt, e.f.ad_icon_sound_open);
            if (this.gqK == 1) {
                ab.a(this.amS, true);
            }
        } else {
            if (this.cXZ != null) {
                this.cXZ.setVolume(0.0f, 0.0f);
            }
            al.c(this.gWu, e.f.ad_icon_sound_close);
            al.c(this.gWt, e.f.ad_icon_sound_close);
            ab.a(this.amS, false);
        }
        this.gWz = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.gqK;
    }

    public VideoInfo getData() {
        return this.gqJ;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.gqT;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gWq && this.gWp != null && this.gWp.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gWr = advertAppInfo;
        this.gWs = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gWr, 303, i, us(this.gWF), this.gqJ.video_duration.intValue(), this.mDuration, -1);
        if (this.gSY != null) {
            this.gSY.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(int i, int i2, int i3) {
        x(i, i2, i3, -1);
    }

    private void e(int i, int i2, int i3, boolean z) {
        a(i, i2, i3, -1, z);
    }

    private void x(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, true);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.gWr != null && this.gqJ != null) {
            this.gWr.page = this.mPage;
            com.baidu.tieba.recapp.report.c.bwO().a(f.a(this.gWr, i, this.gWs, i2, this.gqJ.video_duration.intValue(), a.hK(i3), i4));
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
                if ("DETAIL".equals(this.mPage)) {
                    str2 = "det";
                } else if ("FRS".equals(this.mPage)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.mPage)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gWD, i3, this.mDuration, str2, ut(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gPE != null && "cpv".equals(this.gPE.gQB) && !TextUtils.isEmpty(this.gPE.gQC)) {
            new com.baidu.tieba.recapp.request.a(this.gPE.gQC).a(str, i, i2, i3, str2, str3);
        }
    }

    private String ut(int i) {
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
            this.gWp = view;
            this.gWq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gWG);
            if (this.dQC != null) {
                this.dQC.cancel();
            }
            this.gWw.setVisibility(0);
            if (this.gqK == 1) {
                al.c(this.gWx, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gWx, e.f.icon_video_midpause);
                return;
            }
        }
        this.gWw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        switch (this.gqK) {
            case -1:
                if (!j.kV() && this.mPageContext != null) {
                    this.mPageContext.showToast(e.j.neterror);
                    return;
                } else if (!j.kW() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.db(e.j.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).BS();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gWC = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mS(true);
                    return;
                }
                return;
            case 2:
                this.gWC = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gWG);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.gWG, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (!this.mIsInAnimation && this.dQC != null) {
            this.gWw.startAnimation(this.dQC);
            this.mIsInAnimation = true;
        }
    }

    private void bxd() {
        if (this.mPageContext != null) {
            this.dQC = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dQC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gWw.setVisibility(8);
                    DistributeVideoView.this.mIsInAnimation = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
