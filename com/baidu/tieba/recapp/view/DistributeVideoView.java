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
    private QuickVideoView bPc;
    private g.b bpO;
    private QuickVideoView.b bpS;
    private g.a byA;
    private g.f byB;
    private g.e byD;
    private g cYa;
    private Animation dQD;
    private ForeDrawableImageView eGO;
    private String frh;
    private AdCard.a gPF;
    private AdCard.f gPG;
    private ImageView gSD;
    private ViewGroup gSX;
    private d gSY;
    private e gSZ;
    private boolean gWA;
    private long gWB;
    private b gWC;
    boolean gWD;
    private int gWE;
    boolean gWF;
    private int gWG;
    private Runnable gWH;
    private View gWq;
    private boolean gWr;
    private AdvertAppInfo gWs;
    private int gWt;
    private ImageView gWu;
    private ImageView gWv;
    private TextView gWw;
    private View gWx;
    private ImageView gWy;
    private VideoControllerView gWz;
    private VideoInfo gqK;
    private int gqL;
    private TextView gqO;
    private View gqS;
    private long gqU;
    private Runnable gra;
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
        this.gWr = false;
        this.amS = null;
        this.gqL = -1;
        this.gqU = 0L;
        this.gWA = false;
        this.gWB = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gWD = false;
        this.gWF = false;
        this.gWG = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gqS) {
                    DistributeVideoView.this.gqS.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gWv || view == DistributeVideoView.this.gWu) {
                    DistributeVideoView.this.mR(DistributeVideoView.this.gWA ? false : true);
                } else if (view == DistributeVideoView.this.gSD || view == DistributeVideoView.this.gWy) {
                    DistributeVideoView.this.bxb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gWs == null || !DistributeVideoView.this.gWs.yr()) {
                    DistributeVideoView.this.bxb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gWs != null) {
                        WebVideoActivity.gPz = new WebVideoActivity.a();
                        WebVideoActivity.gPz.gPJ = DistributeVideoView.this.gWs;
                        WebVideoActivity.gPz.mPage = "DETAIL";
                        WebVideoActivity.gPz.mPageNum = DistributeVideoView.this.gWt;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.frh) ? DistributeVideoView.this.frh : DistributeVideoView.this.gWs.apW, true, true, true, DistributeVideoView.this.gqK.video_url, DistributeVideoView.this.gqK.thumbnail_url, DistributeVideoView.this.gqK.video_width.intValue() / DistributeVideoView.this.gqK.video_height.intValue(), DistributeVideoView.this.gqK.video_duration.intValue());
                    if (DistributeVideoView.this.gPF != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gPF.gQC);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gPF.gQD);
                    }
                    if (DistributeVideoView.this.gPG != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gPG.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rw(DistributeVideoView.this.parallelChargeInfo.fqA);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fqD.iterator();
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
                        if (DistributeVideoView.this.gqL != 1) {
                            if (DistributeVideoView.this.bPc.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gqL = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGO.setVisibility(8);
                                DistributeVideoView.this.mR(DistributeVideoView.this.gWA);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gWz.setPlayer(DistributeVideoView.this.bPc);
                                    DistributeVideoView.this.gWz.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gqK.video_duration.intValue()));
                                    DistributeVideoView.this.gWz.showProgress();
                                    DistributeVideoView.this.mS(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gWH);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gWH, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gqU = DistributeVideoView.this.bPc.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bPc.getDuration() - DistributeVideoView.this.bPc.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gqO.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gqL == 1) {
                            if (DistributeVideoView.this.gqU == DistributeVideoView.this.bPc.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gqU = DistributeVideoView.this.bPc.getCurrentPosition();
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
        this.byB = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gWE = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cYa = gVar;
                    DistributeVideoView.this.cYa.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gWs != null) {
                    if (DistributeVideoView.this.gWF && "DETAIL".equals(DistributeVideoView.this.gWs.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.us(DistributeVideoView.this.gWG), 0);
                }
                return false;
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bxa();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.us(DistributeVideoView.this.gWG), gVar.getCurrentPosition());
                DistributeVideoView.this.eGO.setForegroundDrawable(0);
                DistributeVideoView.this.gSD.setVisibility(8);
                DistributeVideoView.this.gqS.setVisibility(0);
                return true;
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gWB = System.currentTimeMillis();
                DistributeVideoView.this.gWF = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.us(DistributeVideoView.this.gWG), gVar.getDuration());
                DistributeVideoView.this.bxa();
                if (DistributeVideoView.this.gSZ != null) {
                    DistributeVideoView.this.gSZ.bwS();
                    DistributeVideoView.this.gqO.setVisibility(8);
                    DistributeVideoView.this.gSD.setVisibility(8);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gra = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gqK != null && DistributeVideoView.this.bPc != null) {
                    DistributeVideoView.this.ur(1);
                }
            }
        };
        this.gWH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bxc();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gWr = false;
        this.amS = null;
        this.gqL = -1;
        this.gqU = 0L;
        this.gWA = false;
        this.gWB = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gWD = false;
        this.gWF = false;
        this.gWG = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gqS) {
                    DistributeVideoView.this.gqS.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gWv || view == DistributeVideoView.this.gWu) {
                    DistributeVideoView.this.mR(DistributeVideoView.this.gWA ? false : true);
                } else if (view == DistributeVideoView.this.gSD || view == DistributeVideoView.this.gWy) {
                    DistributeVideoView.this.bxb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gWs == null || !DistributeVideoView.this.gWs.yr()) {
                    DistributeVideoView.this.bxb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gWs != null) {
                        WebVideoActivity.gPz = new WebVideoActivity.a();
                        WebVideoActivity.gPz.gPJ = DistributeVideoView.this.gWs;
                        WebVideoActivity.gPz.mPage = "DETAIL";
                        WebVideoActivity.gPz.mPageNum = DistributeVideoView.this.gWt;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.frh) ? DistributeVideoView.this.frh : DistributeVideoView.this.gWs.apW, true, true, true, DistributeVideoView.this.gqK.video_url, DistributeVideoView.this.gqK.thumbnail_url, DistributeVideoView.this.gqK.video_width.intValue() / DistributeVideoView.this.gqK.video_height.intValue(), DistributeVideoView.this.gqK.video_duration.intValue());
                    if (DistributeVideoView.this.gPF != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gPF.gQC);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gPF.gQD);
                    }
                    if (DistributeVideoView.this.gPG != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gPG.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rw(DistributeVideoView.this.parallelChargeInfo.fqA);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fqD.iterator();
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
                        if (DistributeVideoView.this.gqL != 1) {
                            if (DistributeVideoView.this.bPc.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gqL = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGO.setVisibility(8);
                                DistributeVideoView.this.mR(DistributeVideoView.this.gWA);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gWz.setPlayer(DistributeVideoView.this.bPc);
                                    DistributeVideoView.this.gWz.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gqK.video_duration.intValue()));
                                    DistributeVideoView.this.gWz.showProgress();
                                    DistributeVideoView.this.mS(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gWH);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gWH, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gqU = DistributeVideoView.this.bPc.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bPc.getDuration() - DistributeVideoView.this.bPc.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gqO.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gqL == 1) {
                            if (DistributeVideoView.this.gqU == DistributeVideoView.this.bPc.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gqU = DistributeVideoView.this.bPc.getCurrentPosition();
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
        this.byB = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gWE = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cYa = gVar;
                    DistributeVideoView.this.cYa.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gWs != null) {
                    if (DistributeVideoView.this.gWF && "DETAIL".equals(DistributeVideoView.this.gWs.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.us(DistributeVideoView.this.gWG), 0);
                }
                return false;
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bxa();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.us(DistributeVideoView.this.gWG), gVar.getCurrentPosition());
                DistributeVideoView.this.eGO.setForegroundDrawable(0);
                DistributeVideoView.this.gSD.setVisibility(8);
                DistributeVideoView.this.gqS.setVisibility(0);
                return true;
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gWB = System.currentTimeMillis();
                DistributeVideoView.this.gWF = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.us(DistributeVideoView.this.gWG), gVar.getDuration());
                DistributeVideoView.this.bxa();
                if (DistributeVideoView.this.gSZ != null) {
                    DistributeVideoView.this.gSZ.bwS();
                    DistributeVideoView.this.gqO.setVisibility(8);
                    DistributeVideoView.this.gSD.setVisibility(8);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gra = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gqK != null && DistributeVideoView.this.bPc != null) {
                    DistributeVideoView.this.ur(1);
                }
            }
        };
        this.gWH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bxc();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gWr = false;
        this.amS = null;
        this.gqL = -1;
        this.gqU = 0L;
        this.gWA = false;
        this.gWB = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gWD = false;
        this.gWF = false;
        this.gWG = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gqS) {
                    DistributeVideoView.this.gqS.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gWv || view == DistributeVideoView.this.gWu) {
                    DistributeVideoView.this.mR(DistributeVideoView.this.gWA ? false : true);
                } else if (view == DistributeVideoView.this.gSD || view == DistributeVideoView.this.gWy) {
                    DistributeVideoView.this.bxb();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gWs == null || !DistributeVideoView.this.gWs.yr()) {
                    DistributeVideoView.this.bxb();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gWs != null) {
                        WebVideoActivity.gPz = new WebVideoActivity.a();
                        WebVideoActivity.gPz.gPJ = DistributeVideoView.this.gWs;
                        WebVideoActivity.gPz.mPage = "DETAIL";
                        WebVideoActivity.gPz.mPageNum = DistributeVideoView.this.gWt;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.frh) ? DistributeVideoView.this.frh : DistributeVideoView.this.gWs.apW, true, true, true, DistributeVideoView.this.gqK.video_url, DistributeVideoView.this.gqK.thumbnail_url, DistributeVideoView.this.gqK.video_width.intValue() / DistributeVideoView.this.gqK.video_height.intValue(), DistributeVideoView.this.gqK.video_duration.intValue());
                    if (DistributeVideoView.this.gPF != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gPF.gQC);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gPF.gQD);
                    }
                    if (DistributeVideoView.this.gPG != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gPG.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rw(DistributeVideoView.this.parallelChargeInfo.fqA);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fqD.iterator();
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
                        if (DistributeVideoView.this.gqL != 1) {
                            if (DistributeVideoView.this.bPc.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gqL = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGO.setVisibility(8);
                                DistributeVideoView.this.mR(DistributeVideoView.this.gWA);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gWz.setPlayer(DistributeVideoView.this.bPc);
                                    DistributeVideoView.this.gWz.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gqK.video_duration.intValue()));
                                    DistributeVideoView.this.gWz.showProgress();
                                    DistributeVideoView.this.mS(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gWH);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gWH, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gqU = DistributeVideoView.this.bPc.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bPc.getDuration() - DistributeVideoView.this.bPc.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gqO.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gqL == 1) {
                            if (DistributeVideoView.this.gqU == DistributeVideoView.this.bPc.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gqU = DistributeVideoView.this.bPc.getCurrentPosition();
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
        this.byB = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gWE = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cYa = gVar;
                    DistributeVideoView.this.cYa.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.byD = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gWs != null) {
                    if (DistributeVideoView.this.gWF && "DETAIL".equals(DistributeVideoView.this.gWs.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.us(DistributeVideoView.this.gWG), 0);
                }
                return false;
            }
        };
        this.bpO = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bxa();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.us(DistributeVideoView.this.gWG), gVar.getCurrentPosition());
                DistributeVideoView.this.eGO.setForegroundDrawable(0);
                DistributeVideoView.this.gSD.setVisibility(8);
                DistributeVideoView.this.gqS.setVisibility(0);
                return true;
            }
        };
        this.byA = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gWB = System.currentTimeMillis();
                DistributeVideoView.this.gWF = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.us(DistributeVideoView.this.gWG), gVar.getDuration());
                DistributeVideoView.this.bxa();
                if (DistributeVideoView.this.gSZ != null) {
                    DistributeVideoView.this.gSZ.bwS();
                    DistributeVideoView.this.gqO.setVisibility(8);
                    DistributeVideoView.this.gSD.setVisibility(8);
                }
            }
        };
        this.bpS = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gra = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gqK != null && DistributeVideoView.this.bPc != null) {
                    DistributeVideoView.this.ur(1);
                }
            }
        };
        this.gWH = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bxc();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.frh = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gWC = adCard;
        if (this.gWC != null) {
            this.parallelChargeInfo = this.gWC.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bPc = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gSD = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.eGO = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(e.g.distribute_loading);
            this.gqO = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.gqS = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gWw = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gWu = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gWx = this.mRootView.findViewById(e.g.distribute_control);
            this.gWy = (ImageView) this.gWx.findViewById(e.g.distribute_play_icon);
            this.gWv = (ImageView) this.gWx.findViewById(e.g.distribute_voice);
            this.gWz = (VideoControllerView) this.gWx.findViewById(e.g.distribute_process);
            this.gSX = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gSY = new d(context, this.gSX);
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
        this.gPF = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gPG = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gqK = videoInfo;
        this.mDuration = this.gqK.video_duration.intValue() * 1000;
        this.amS = new WeakReference<>(this.mContext.getApplicationContext());
        bxa();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.gqK.video_width.intValue() > 0 ? (this.gqK.video_height.intValue() * aO) / this.gqK.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gSD, e.f.btn_icon_play_video_n);
        this.gSD.setVisibility(8);
        this.eGO.setDefaultErrorResource(0);
        this.eGO.setDefaultResource(0);
        this.eGO.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGO.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGO.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bPc.setOnPreparedListener(this.byB);
        this.bPc.setOnErrorListener(this.bpO);
        this.bPc.setOnCompletionListener(this.byA);
        this.bPc.setOnOutInfoListener(this.byD);
        this.bPc.setOnSurfaceDestroyedListener(this.bpS);
        al.h(this.gqO, e.d.cp_cont_i);
        al.i(this.gqO, e.f.video_play_count_bg);
        this.gqO.setText(StringUtils.translateSecondsToString(this.gqK.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gWA = false;
            al.c(this.gWu, e.f.ad_icon_sound_close);
        } else {
            this.gWA = true;
            al.c(this.gWv, e.f.ad_icon_sound_open);
            this.gWu.setVisibility(8);
        }
        this.gWv.setOnClickListener(this.mOnClickListener);
        this.gWu.setOnClickListener(this.mOnClickListener);
        this.gqS.setOnClickListener(this.mOnClickListener);
        this.gqS.setVisibility(8);
        al.j(this.gqS, e.d.black_alpha80);
        al.h(this.gWw, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gqO.setVisibility(0);
            return;
        }
        this.gqO.setVisibility(8);
        this.gWy.setOnClickListener(this.mOnClickListener);
        this.gSD.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gqK = videoInfo;
        this.amS = new WeakReference<>(this.mContext.getApplicationContext());
        bxa();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gSD, e.f.btn_icon_play_video_n);
        this.gSD.setVisibility(8);
        this.eGO.setDefaultErrorResource(0);
        this.eGO.setDefaultResource(0);
        this.eGO.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGO.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGO.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bPc.setOnPreparedListener(this.byB);
        this.bPc.setOnErrorListener(this.bpO);
        this.bPc.setOnCompletionListener(this.byA);
        this.bPc.setOnOutInfoListener(this.byD);
        this.bPc.setOnSurfaceDestroyedListener(this.bpS);
        al.h(this.gqO, e.d.cp_cont_i);
        this.gqO.setText(StringUtils.translateSecondsToString(this.gqK.video_duration.intValue()));
        al.i(this.gqO, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gWA = false;
            al.c(this.gWu, e.f.ad_icon_sound_close);
        } else {
            this.gWA = true;
            al.c(this.gWv, e.f.ad_icon_sound_open);
            this.gWu.setVisibility(8);
        }
        this.gWv.setOnClickListener(this.mOnClickListener);
        this.gWu.setOnClickListener(this.mOnClickListener);
        this.gqS.setOnClickListener(this.mOnClickListener);
        this.gqS.setVisibility(8);
        al.j(this.gqS, e.d.black_alpha80);
        al.h(this.gWw, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gqO.setVisibility(0);
            return;
        }
        this.gqO.setVisibility(8);
        this.gWy.setOnClickListener(this.mOnClickListener);
        this.gSD.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gSZ = this.gSY.a(this.gPG, this.gSZ);
        if (this.gSZ != null) {
            this.gSZ.setPageContext(this.mPageContext);
            this.gSZ.c(this.gWC);
            this.gSZ.setAdvertAppInfo(advertAppInfo);
            this.gSZ.a(this.gPG);
            this.gSZ.bwT();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gSZ != null) {
            this.gSZ.setDownloadAppCallback(cVar);
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
        this.byA = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur(int i) {
        this.gWG = i;
        if (this.gqK != null && this.gqL == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gWB) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gSZ != null) {
                    this.gSZ.bwT();
                }
                this.bPc.setVideoPath(this.gqK.video_url);
                this.bPc.start();
                this.gWE = this.bPc.getCurrentPosition();
                this.gSD.setVisibility(8);
                al.c(this.gWy, e.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.gqS.setVisibility(8);
                this.eGO.setForegroundDrawable(0);
                this.gqL = 0;
                if (this.mStyle == 1) {
                    this.gqO.setVisibility(0);
                } else {
                    this.gqO.setVisibility(8);
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
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gra);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gra, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.gqL == 1) {
            x(32, us(this.gWG), this.bPc.getCurrentPosition(), i);
            this.bPc.pause();
            ab.a(this.amS, false);
            this.gSD.setVisibility(0);
            al.c(this.gWy, e.f.icon_video_midpause);
            this.gqL = 2;
        }
    }

    public void autoContinue() {
        if (!this.gWD) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.gqL == 2) {
            this.gWG = i;
            ab(33, us(i), this.bPc.getCurrentPosition());
            this.gWE = this.bPc.getCurrentPosition();
            this.bPc.start();
            if (this.gWA) {
                ab.a(this.amS, true);
            }
            this.gSD.setVisibility(8);
            al.c(this.gWy, e.f.icon_video_midplay);
            this.gqL = 1;
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
        if (this.bPc.getCurrentPosition() > 0 && this.gqL != -1 && z) {
            int i = 32;
            int currentPosition = this.bPc.getCurrentPosition();
            if (this.bPc.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, us(this.gWG), currentPosition, this.bPc.isPlaying());
        }
        bxa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxa() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gra);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gWH);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bPc.stopPlayback();
        this.gqL = -1;
        ab.a(this.amS, false);
        this.eGO.setForegroundDrawable(0);
        this.eGO.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gSD.setVisibility(0);
        al.c(this.gWy, e.f.icon_video_midpause);
        this.gWz.WJ();
        this.gqS.setVisibility(8);
        if (this.gqK != null) {
            this.gqO.setText(StringUtils.translateSecondsToString(this.gqK.video_duration.intValue()));
        }
        this.cYa = null;
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
        return this.gqK != null ? this.gqK.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(boolean z) {
        if (z) {
            if (this.cYa != null) {
                this.cYa.setVolume(1.0f, 1.0f);
            }
            al.c(this.gWv, e.f.ad_icon_sound_open);
            al.c(this.gWu, e.f.ad_icon_sound_open);
            if (this.gqL == 1) {
                ab.a(this.amS, true);
            }
        } else {
            if (this.cYa != null) {
                this.cYa.setVolume(0.0f, 0.0f);
            }
            al.c(this.gWv, e.f.ad_icon_sound_close);
            al.c(this.gWu, e.f.ad_icon_sound_close);
            ab.a(this.amS, false);
        }
        this.gWA = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.gqL;
    }

    public VideoInfo getData() {
        return this.gqK;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.gqU;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gWr && this.gWq != null && this.gWq.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gWs = advertAppInfo;
        this.gWt = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gWs, 303, i, us(this.gWG), this.gqK.video_duration.intValue(), this.mDuration, -1);
        if (this.gSZ != null) {
            this.gSZ.e(a);
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
        if (this.gWs != null && this.gqK != null) {
            this.gWs.page = this.mPage;
            com.baidu.tieba.recapp.report.c.bwO().a(f.a(this.gWs, i, this.gWt, i2, this.gqK.video_duration.intValue(), a.hK(i3), i4));
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
                c(str, this.gWE, i3, this.mDuration, str2, ut(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gPF != null && "cpv".equals(this.gPF.gQC) && !TextUtils.isEmpty(this.gPF.gQD)) {
            new com.baidu.tieba.recapp.request.a(this.gPF.gQD).a(str, i, i2, i3, str2, str3);
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
            this.gWq = view;
            this.gWr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mS(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gWH);
            if (this.dQD != null) {
                this.dQD.cancel();
            }
            this.gWx.setVisibility(0);
            if (this.gqL == 1) {
                al.c(this.gWy, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gWy, e.f.icon_video_midpause);
                return;
            }
        }
        this.gWx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        switch (this.gqL) {
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
                this.gWD = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mS(true);
                    return;
                }
                return;
            case 2:
                this.gWD = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gWH);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.gWH, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (!this.mIsInAnimation && this.dQD != null) {
            this.gWx.startAnimation(this.dQD);
            this.mIsInAnimation = true;
        }
    }

    private void bxd() {
        if (this.mPageContext != null) {
            this.dQD = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dQD.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gWx.setVisibility(8);
                    DistributeVideoView.this.mIsInAnimation = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
