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
    private WeakReference<Context> aiW;
    private QuickVideoView bKy;
    private QuickVideoView.b blC;
    private g.b bly;
    private g.a bul;
    private g.f bum;
    private g.e buo;
    private g cNR;
    private Animation dGG;
    private ForeDrawableImageView ews;
    private String fgC;
    private AdCard.a gET;
    private AdCard.f gEU;
    private ImageView gHR;
    private ViewGroup gIl;
    private d gIm;
    private e gIn;
    private boolean gLA;
    private AdvertAppInfo gLB;
    private int gLC;
    private ImageView gLD;
    private ImageView gLE;
    private TextView gLF;
    private View gLG;
    private ImageView gLH;
    private VideoControllerView gLI;
    private boolean gLJ;
    private long gLK;
    private b gLL;
    boolean gLM;
    private int gLN;
    boolean gLO;
    private int gLP;
    private Runnable gLQ;
    private View gLz;
    private VideoInfo gfX;
    private int gfY;
    private TextView ggb;
    private View ggf;
    private long ggh;
    private Runnable ggn;
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
        this.gLA = false;
        this.aiW = null;
        this.gfY = -1;
        this.ggh = 0L;
        this.gLJ = false;
        this.gLK = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gLM = false;
        this.gLO = false;
        this.gLP = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ggf) {
                    DistributeVideoView.this.ggf.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gLE || view == DistributeVideoView.this.gLD) {
                    DistributeVideoView.this.mK(DistributeVideoView.this.gLJ ? false : true);
                } else if (view == DistributeVideoView.this.gHR || view == DistributeVideoView.this.gLH) {
                    DistributeVideoView.this.btM();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gLB == null || !DistributeVideoView.this.gLB.xa()) {
                    DistributeVideoView.this.btM();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gLB != null) {
                        WebVideoActivity.gEN = new WebVideoActivity.a();
                        WebVideoActivity.gEN.gEX = DistributeVideoView.this.gLB;
                        WebVideoActivity.gEN.mPage = "DETAIL";
                        WebVideoActivity.gEN.mPageNum = DistributeVideoView.this.gLC;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fgC) ? DistributeVideoView.this.fgC : DistributeVideoView.this.gLB.alS, true, true, true, DistributeVideoView.this.gfX.video_url, DistributeVideoView.this.gfX.thumbnail_url, DistributeVideoView.this.gfX.video_width.intValue() / DistributeVideoView.this.gfX.video_height.intValue(), DistributeVideoView.this.gfX.video_duration.intValue());
                    if (DistributeVideoView.this.gET != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gET.gFQ);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gET.gFR);
                    }
                    if (DistributeVideoView.this.gEU != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gEU.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qB(DistributeVideoView.this.parallelChargeInfo.ffV);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ffY.iterator();
                        while (it.hasNext()) {
                            c.qB(it.next());
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
                        if (DistributeVideoView.this.gfY != 1) {
                            if (DistributeVideoView.this.bKy.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gfY = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.ews.setVisibility(8);
                                DistributeVideoView.this.mK(DistributeVideoView.this.gLJ);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gLI.setPlayer(DistributeVideoView.this.bKy);
                                    DistributeVideoView.this.gLI.Y(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gfX.video_duration.intValue()));
                                    DistributeVideoView.this.gLI.showProgress();
                                    DistributeVideoView.this.mL(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gLQ);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gLQ, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.ggh = DistributeVideoView.this.bKy.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bKy.getDuration() - DistributeVideoView.this.bKy.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.ggb.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gfY == 1) {
                            if (DistributeVideoView.this.ggh == DistributeVideoView.this.bKy.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.ggh = DistributeVideoView.this.bKy.getCurrentPosition();
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
        this.bum = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gLN = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cNR = gVar;
                    DistributeVideoView.this.cNR.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gLB != null) {
                    if (DistributeVideoView.this.gLO && "DETAIL".equals(DistributeVideoView.this.gLB.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), 0);
                }
                return false;
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.btL();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), gVar.getCurrentPosition());
                DistributeVideoView.this.ews.setForegroundDrawable(0);
                DistributeVideoView.this.gHR.setVisibility(8);
                DistributeVideoView.this.ggf.setVisibility(0);
                return true;
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gLK = System.currentTimeMillis();
                DistributeVideoView.this.gLO = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), gVar.getDuration());
                DistributeVideoView.this.btL();
                if (DistributeVideoView.this.gIn != null) {
                    DistributeVideoView.this.gIn.btF();
                    DistributeVideoView.this.ggb.setVisibility(8);
                    DistributeVideoView.this.gHR.setVisibility(8);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ggn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gfX != null && DistributeVideoView.this.bKy != null) {
                    DistributeVideoView.this.tH(1);
                }
            }
        };
        this.gLQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.btN();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLA = false;
        this.aiW = null;
        this.gfY = -1;
        this.ggh = 0L;
        this.gLJ = false;
        this.gLK = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gLM = false;
        this.gLO = false;
        this.gLP = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ggf) {
                    DistributeVideoView.this.ggf.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gLE || view == DistributeVideoView.this.gLD) {
                    DistributeVideoView.this.mK(DistributeVideoView.this.gLJ ? false : true);
                } else if (view == DistributeVideoView.this.gHR || view == DistributeVideoView.this.gLH) {
                    DistributeVideoView.this.btM();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gLB == null || !DistributeVideoView.this.gLB.xa()) {
                    DistributeVideoView.this.btM();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gLB != null) {
                        WebVideoActivity.gEN = new WebVideoActivity.a();
                        WebVideoActivity.gEN.gEX = DistributeVideoView.this.gLB;
                        WebVideoActivity.gEN.mPage = "DETAIL";
                        WebVideoActivity.gEN.mPageNum = DistributeVideoView.this.gLC;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fgC) ? DistributeVideoView.this.fgC : DistributeVideoView.this.gLB.alS, true, true, true, DistributeVideoView.this.gfX.video_url, DistributeVideoView.this.gfX.thumbnail_url, DistributeVideoView.this.gfX.video_width.intValue() / DistributeVideoView.this.gfX.video_height.intValue(), DistributeVideoView.this.gfX.video_duration.intValue());
                    if (DistributeVideoView.this.gET != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gET.gFQ);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gET.gFR);
                    }
                    if (DistributeVideoView.this.gEU != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gEU.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qB(DistributeVideoView.this.parallelChargeInfo.ffV);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ffY.iterator();
                        while (it.hasNext()) {
                            c.qB(it.next());
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
                        if (DistributeVideoView.this.gfY != 1) {
                            if (DistributeVideoView.this.bKy.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gfY = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.ews.setVisibility(8);
                                DistributeVideoView.this.mK(DistributeVideoView.this.gLJ);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gLI.setPlayer(DistributeVideoView.this.bKy);
                                    DistributeVideoView.this.gLI.Y(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gfX.video_duration.intValue()));
                                    DistributeVideoView.this.gLI.showProgress();
                                    DistributeVideoView.this.mL(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gLQ);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gLQ, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.ggh = DistributeVideoView.this.bKy.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bKy.getDuration() - DistributeVideoView.this.bKy.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.ggb.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gfY == 1) {
                            if (DistributeVideoView.this.ggh == DistributeVideoView.this.bKy.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.ggh = DistributeVideoView.this.bKy.getCurrentPosition();
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
        this.bum = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gLN = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cNR = gVar;
                    DistributeVideoView.this.cNR.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gLB != null) {
                    if (DistributeVideoView.this.gLO && "DETAIL".equals(DistributeVideoView.this.gLB.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), 0);
                }
                return false;
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.btL();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), gVar.getCurrentPosition());
                DistributeVideoView.this.ews.setForegroundDrawable(0);
                DistributeVideoView.this.gHR.setVisibility(8);
                DistributeVideoView.this.ggf.setVisibility(0);
                return true;
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gLK = System.currentTimeMillis();
                DistributeVideoView.this.gLO = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), gVar.getDuration());
                DistributeVideoView.this.btL();
                if (DistributeVideoView.this.gIn != null) {
                    DistributeVideoView.this.gIn.btF();
                    DistributeVideoView.this.ggb.setVisibility(8);
                    DistributeVideoView.this.gHR.setVisibility(8);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ggn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gfX != null && DistributeVideoView.this.bKy != null) {
                    DistributeVideoView.this.tH(1);
                }
            }
        };
        this.gLQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.btN();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLA = false;
        this.aiW = null;
        this.gfY = -1;
        this.ggh = 0L;
        this.gLJ = false;
        this.gLK = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gLM = false;
        this.gLO = false;
        this.gLP = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.ggf) {
                    DistributeVideoView.this.ggf.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gLE || view == DistributeVideoView.this.gLD) {
                    DistributeVideoView.this.mK(DistributeVideoView.this.gLJ ? false : true);
                } else if (view == DistributeVideoView.this.gHR || view == DistributeVideoView.this.gLH) {
                    DistributeVideoView.this.btM();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gLB == null || !DistributeVideoView.this.gLB.xa()) {
                    DistributeVideoView.this.btM();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gLB != null) {
                        WebVideoActivity.gEN = new WebVideoActivity.a();
                        WebVideoActivity.gEN.gEX = DistributeVideoView.this.gLB;
                        WebVideoActivity.gEN.mPage = "DETAIL";
                        WebVideoActivity.gEN.mPageNum = DistributeVideoView.this.gLC;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fgC) ? DistributeVideoView.this.fgC : DistributeVideoView.this.gLB.alS, true, true, true, DistributeVideoView.this.gfX.video_url, DistributeVideoView.this.gfX.thumbnail_url, DistributeVideoView.this.gfX.video_width.intValue() / DistributeVideoView.this.gfX.video_height.intValue(), DistributeVideoView.this.gfX.video_duration.intValue());
                    if (DistributeVideoView.this.gET != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gET.gFQ);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gET.gFR);
                    }
                    if (DistributeVideoView.this.gEU != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gEU.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.qB(DistributeVideoView.this.parallelChargeInfo.ffV);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ffY.iterator();
                        while (it.hasNext()) {
                            c.qB(it.next());
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
                        if (DistributeVideoView.this.gfY != 1) {
                            if (DistributeVideoView.this.bKy.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gfY = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.ews.setVisibility(8);
                                DistributeVideoView.this.mK(DistributeVideoView.this.gLJ);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gLI.setPlayer(DistributeVideoView.this.bKy);
                                    DistributeVideoView.this.gLI.Y(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gfX.video_duration.intValue()));
                                    DistributeVideoView.this.gLI.showProgress();
                                    DistributeVideoView.this.mL(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gLQ);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gLQ, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.ggh = DistributeVideoView.this.bKy.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bKy.getDuration() - DistributeVideoView.this.bKy.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.ggb.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gfY == 1) {
                            if (DistributeVideoView.this.ggh == DistributeVideoView.this.bKy.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.ggh = DistributeVideoView.this.bKy.getCurrentPosition();
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
        this.bum = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gLN = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cNR = gVar;
                    DistributeVideoView.this.cNR.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.buo = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gLB != null) {
                    if (DistributeVideoView.this.gLO && "DETAIL".equals(DistributeVideoView.this.gLB.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), 0);
                }
                return false;
            }
        };
        this.bly = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.btL();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), gVar.getCurrentPosition());
                DistributeVideoView.this.ews.setForegroundDrawable(0);
                DistributeVideoView.this.gHR.setVisibility(8);
                DistributeVideoView.this.ggf.setVisibility(0);
                return true;
            }
        };
        this.bul = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gLK = System.currentTimeMillis();
                DistributeVideoView.this.gLO = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.tI(DistributeVideoView.this.gLP), gVar.getDuration());
                DistributeVideoView.this.btL();
                if (DistributeVideoView.this.gIn != null) {
                    DistributeVideoView.this.gIn.btF();
                    DistributeVideoView.this.ggb.setVisibility(8);
                    DistributeVideoView.this.gHR.setVisibility(8);
                }
            }
        };
        this.blC = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.ggn = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gfX != null && DistributeVideoView.this.bKy != null) {
                    DistributeVideoView.this.tH(1);
                }
            }
        };
        this.gLQ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.btN();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.fgC = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gLL = adCard;
        if (this.gLL != null) {
            this.parallelChargeInfo = this.gLL.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bKy = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gHR = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.ews = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(e.g.distribute_loading);
            this.ggb = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.ggf = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gLF = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gLD = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gLG = this.mRootView.findViewById(e.g.distribute_control);
            this.gLH = (ImageView) this.gLG.findViewById(e.g.distribute_play_icon);
            this.gLE = (ImageView) this.gLG.findViewById(e.g.distribute_voice);
            this.gLI = (VideoControllerView) this.gLG.findViewById(e.g.distribute_process);
            this.gIl = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gIm = new d(context, this.gIl);
        }
    }

    private boolean blL() {
        return this.mStyle == 1 ? q.blL() : j.kW();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            btO();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gET = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gEU = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gfX = videoInfo;
        this.mDuration = this.gfX.video_duration.intValue() * 1000;
        this.aiW = new WeakReference<>(this.mContext.getApplicationContext());
        btL();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0200e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.gfX.video_width.intValue() > 0 ? (this.gfX.video_height.intValue() * aO) / this.gfX.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gHR, e.f.btn_icon_play_video_n);
        this.gHR.setVisibility(8);
        this.ews.setDefaultErrorResource(0);
        this.ews.setDefaultResource(0);
        this.ews.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.ews.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.ews.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bKy.setOnPreparedListener(this.bum);
        this.bKy.setOnErrorListener(this.bly);
        this.bKy.setOnCompletionListener(this.bul);
        this.bKy.setOnOutInfoListener(this.buo);
        this.bKy.setOnSurfaceDestroyedListener(this.blC);
        al.h(this.ggb, e.d.cp_cont_i);
        al.i(this.ggb, e.f.video_play_count_bg);
        this.ggb.setText(StringUtils.translateSecondsToString(this.gfX.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gLJ = false;
            al.c(this.gLD, e.f.ad_icon_sound_close);
        } else {
            this.gLJ = true;
            al.c(this.gLE, e.f.ad_icon_sound_open);
            this.gLD.setVisibility(8);
        }
        this.gLE.setOnClickListener(this.mOnClickListener);
        this.gLD.setOnClickListener(this.mOnClickListener);
        this.ggf.setOnClickListener(this.mOnClickListener);
        this.ggf.setVisibility(8);
        al.j(this.ggf, e.d.black_alpha80);
        al.h(this.gLF, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.ggb.setVisibility(0);
            return;
        }
        this.ggb.setVisibility(8);
        this.gLH.setOnClickListener(this.mOnClickListener);
        this.gHR.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gfX = videoInfo;
        this.aiW = new WeakReference<>(this.mContext.getApplicationContext());
        btL();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gHR, e.f.btn_icon_play_video_n);
        this.gHR.setVisibility(8);
        this.ews.setDefaultErrorResource(0);
        this.ews.setDefaultResource(0);
        this.ews.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.ews.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.ews.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bKy.setOnPreparedListener(this.bum);
        this.bKy.setOnErrorListener(this.bly);
        this.bKy.setOnCompletionListener(this.bul);
        this.bKy.setOnOutInfoListener(this.buo);
        this.bKy.setOnSurfaceDestroyedListener(this.blC);
        al.h(this.ggb, e.d.cp_cont_i);
        this.ggb.setText(StringUtils.translateSecondsToString(this.gfX.video_duration.intValue()));
        al.i(this.ggb, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gLJ = false;
            al.c(this.gLD, e.f.ad_icon_sound_close);
        } else {
            this.gLJ = true;
            al.c(this.gLE, e.f.ad_icon_sound_open);
            this.gLD.setVisibility(8);
        }
        this.gLE.setOnClickListener(this.mOnClickListener);
        this.gLD.setOnClickListener(this.mOnClickListener);
        this.ggf.setOnClickListener(this.mOnClickListener);
        this.ggf.setVisibility(8);
        al.j(this.ggf, e.d.black_alpha80);
        al.h(this.gLF, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.ggb.setVisibility(0);
            return;
        }
        this.ggb.setVisibility(8);
        this.gLH.setOnClickListener(this.mOnClickListener);
        this.gHR.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gIn = this.gIm.a(this.gEU, this.gIn);
        if (this.gIn != null) {
            this.gIn.setPageContext(this.mPageContext);
            this.gIn.c(this.gLL);
            this.gIn.setAdvertAppInfo(advertAppInfo);
            this.gIn.a(this.gEU);
            this.gIn.btG();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gIn != null) {
            this.gIn.setDownloadAppCallback(cVar);
        }
    }

    protected boolean a(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null || this.mRootView == null) {
            return false;
        }
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(e.C0200e.ds16) + i;
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
        this.bul = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(int i) {
        this.gLP = i;
        if (this.gfX != null && this.gfY == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gLK) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gIn != null) {
                    this.gIn.btG();
                }
                this.bKy.setVideoPath(this.gfX.video_url);
                this.bKy.start();
                this.gLN = this.bKy.getCurrentPosition();
                this.gHR.setVisibility(8);
                al.c(this.gLH, e.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.ggf.setVisibility(8);
                this.ews.setForegroundDrawable(0);
                this.gfY = 0;
                if (this.mStyle == 1) {
                    this.ggb.setVisibility(0);
                } else {
                    this.ggb.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        tH(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (blL()) {
            if (i <= 0) {
                tH(1);
                return;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ggn);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.ggn, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.gfY == 1) {
            w(32, tI(this.gLP), this.bKy.getCurrentPosition(), i);
            this.bKy.pause();
            aa.a(this.aiW, false);
            this.gHR.setVisibility(0);
            al.c(this.gLH, e.f.icon_video_midpause);
            this.gfY = 2;
        }
    }

    public void autoContinue() {
        if (!this.gLM) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.gfY == 2) {
            this.gLP = i;
            ab(33, tI(i), this.bKy.getCurrentPosition());
            this.gLN = this.bKy.getCurrentPosition();
            this.bKy.start();
            if (this.gLJ) {
                aa.a(this.aiW, true);
            }
            this.gHR.setVisibility(8);
            al.c(this.gLH, e.f.icon_video_midplay);
            this.gfY = 1;
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
        if (this.bKy.getCurrentPosition() > 0 && this.gfY != -1 && z) {
            int i = 32;
            int currentPosition = this.bKy.getCurrentPosition();
            if (this.bKy.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, tI(this.gLP), currentPosition, this.bKy.isPlaying());
        }
        btL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btL() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.ggn);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gLQ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bKy.stopPlayback();
        this.gfY = -1;
        aa.a(this.aiW, false);
        this.ews.setForegroundDrawable(0);
        this.ews.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gHR.setVisibility(0);
        al.c(this.gLH, e.f.icon_video_midpause);
        this.gLI.Ve();
        this.ggf.setVisibility(8);
        if (this.gfX != null) {
            this.ggb.setText(StringUtils.translateSecondsToString(this.gfX.video_duration.intValue()));
        }
        this.cNR = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tI(int i) {
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
        return this.gfX != null ? this.gfX.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mK(boolean z) {
        if (z) {
            if (this.cNR != null) {
                this.cNR.setVolume(1.0f, 1.0f);
            }
            al.c(this.gLE, e.f.ad_icon_sound_open);
            al.c(this.gLD, e.f.ad_icon_sound_open);
            if (this.gfY == 1) {
                aa.a(this.aiW, true);
            }
        } else {
            if (this.cNR != null) {
                this.cNR.setVolume(0.0f, 0.0f);
            }
            al.c(this.gLE, e.f.ad_icon_sound_close);
            al.c(this.gLD, e.f.ad_icon_sound_close);
            aa.a(this.aiW, false);
        }
        this.gLJ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.gfY;
    }

    public VideoInfo getData() {
        return this.gfX;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.ggh;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gLA && this.gLz != null && this.gLz.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gLB = advertAppInfo;
        this.gLC = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gLB, 303, i, tI(this.gLP), this.gfX.video_duration.intValue(), this.mDuration, -1);
        if (this.gIn != null) {
            this.gIn.e(a);
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
        if (this.gLB != null && this.gfX != null) {
            this.gLB.page = this.mPage;
            com.baidu.tieba.recapp.report.c.btB().a(f.a(this.gLB, i, this.gLC, i2, this.gfX.video_duration.intValue(), a.hv(i3), i4));
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
                c(str, this.gLN, i3, this.mDuration, str2, tJ(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gET != null && "cpv".equals(this.gET.gFQ) && !TextUtils.isEmpty(this.gET.gFR)) {
            new com.baidu.tieba.recapp.request.a(this.gET.gFR).a(str, i, i2, i3, str2, str3);
        }
    }

    private String tJ(int i) {
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
            this.gLz = view;
            this.gLA = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mL(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gLQ);
            if (this.dGG != null) {
                this.dGG.cancel();
            }
            this.gLG.setVisibility(0);
            if (this.gfY == 1) {
                al.c(this.gLH, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gLH, e.f.icon_video_midpause);
                return;
            }
        }
        this.gLG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btM() {
        switch (this.gfY) {
            case -1:
                if (!j.kV() && this.mPageContext != null) {
                    this.mPageContext.showToast(e.j.neterror);
                    return;
                } else if (!j.kW() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cN(e.j.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).AB();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gLM = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mL(true);
                    return;
                }
                return;
            case 2:
                this.gLM = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gLQ);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.gLQ, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btN() {
        if (!this.mIsInAnimation && this.dGG != null) {
            this.gLG.startAnimation(this.dGG);
            this.mIsInAnimation = true;
        }
    }

    private void btO() {
        if (this.mPageContext != null) {
            this.dGG = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dGG.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gLG.setVisibility(8);
                    DistributeVideoView.this.mIsInAnimation = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
