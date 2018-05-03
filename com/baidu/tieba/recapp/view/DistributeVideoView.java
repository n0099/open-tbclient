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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.c;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.e.d;
import com.baidu.tieba.recapp.e.e;
import com.baidu.tieba.recapp.i;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.a;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.tbadkCore.q;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> SX;
    private g.a aZn;
    private g.f aZo;
    private g.b aZp;
    private QuickVideoView bkP;
    private QuickVideoView.b bkY;

    /* renamed from: com  reason: collision with root package name */
    private g f19com;
    private ForeDrawableImageView dLL;
    private Animation dbd;
    private AdCard.a fWW;
    private AdCard.f fWX;
    private String fXb;
    private ImageView fZV;
    private VideoInfo fzd;
    private int fze;
    private TextView fzh;
    private View fzl;
    private long fzn;
    private Runnable fzt;
    private ViewGroup gan;
    private d gao;
    private e gap;
    private View gdB;
    private boolean gdC;
    private AdvertAppInfo gdD;
    private int gdE;
    private ImageView gdF;
    private ImageView gdG;
    private TextView gdH;
    private View gdI;
    private ImageView gdJ;
    private VideoControllerView gdK;
    private boolean gdL;
    private long gdM;
    boolean gdN;
    boolean gdO;
    private int gdP;
    boolean gdQ;
    private int gdR;
    private Runnable gdS;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View mLoadingView;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;

    public DistributeVideoView(Context context) {
        super(context);
        this.gdC = false;
        this.SX = null;
        this.fze = -1;
        this.fzn = 0L;
        this.gdL = false;
        this.gdM = 0L;
        this.mStyle = 1;
        this.gdN = false;
        this.gdO = false;
        this.gdQ = false;
        this.gdR = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fzl) {
                    DistributeVideoView.this.fzl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.gdG || view2 == DistributeVideoView.this.gdF) {
                    DistributeVideoView.this.lG(DistributeVideoView.this.gdL ? false : true);
                } else if (view2 == DistributeVideoView.this.fZV || view2 == DistributeVideoView.this.gdJ) {
                    DistributeVideoView.this.bkq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gdD == null || !DistributeVideoView.this.gdD.qu()) {
                    DistributeVideoView.this.bkq();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gdD != null) {
                        WebVideoActivity.fWQ = new WebVideoActivity.a();
                        WebVideoActivity.fWQ.fXa = DistributeVideoView.this.gdD;
                        WebVideoActivity.fWQ.fXb = "DETAIL";
                        WebVideoActivity.fWQ.mPageNum = DistributeVideoView.this.gdE;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gdD.VS, true, true, true, DistributeVideoView.this.fzd.video_url, DistributeVideoView.this.fzd.thumbnail_url, DistributeVideoView.this.fzd.video_width.intValue() / DistributeVideoView.this.fzd.video_height.intValue(), DistributeVideoView.this.fzd.video_duration.intValue());
                    if (DistributeVideoView.this.fWW != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fWW.fXU);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fWW.fXV);
                    }
                    if (DistributeVideoView.this.fWX != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fWX.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.fze != 1) {
                            if (DistributeVideoView.this.bkP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fze = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dLL.setVisibility(8);
                                DistributeVideoView.this.lG(DistributeVideoView.this.gdL);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gdK.setPlayer(DistributeVideoView.this.bkP);
                                    DistributeVideoView.this.gdK.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fzd.video_duration.intValue()));
                                    DistributeVideoView.this.gdK.showProgress();
                                    DistributeVideoView.this.lH(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.gdS);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.gdS, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fzn = DistributeVideoView.this.bkP.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bkP.getDuration() - DistributeVideoView.this.bkP.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fzh.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fze == 1) {
                            if (DistributeVideoView.this.fzn == DistributeVideoView.this.bkP.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fzn = DistributeVideoView.this.bkP.getCurrentPosition();
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gdP = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gdD != null) {
                    if (DistributeVideoView.this.gdQ && "DETAIL".equals(DistributeVideoView.this.gdD.Vt)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), 0);
                    DistributeVideoView.this.f19com = gVar;
                    DistributeVideoView.this.f19com.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bkp();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), gVar.getCurrentPosition());
                DistributeVideoView.this.dLL.setForegroundDrawable(0);
                DistributeVideoView.this.fZV.setVisibility(8);
                DistributeVideoView.this.fzl.setVisibility(0);
                return true;
            }
        };
        this.aZn = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gdM = System.currentTimeMillis();
                DistributeVideoView.this.gdQ = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), gVar.getDuration());
                DistributeVideoView.this.bkp();
                if (DistributeVideoView.this.gap != null) {
                    DistributeVideoView.this.gap.bkj();
                    DistributeVideoView.this.fzh.setVisibility(8);
                    DistributeVideoView.this.fZV.setVisibility(8);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fzt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fzd != null && DistributeVideoView.this.bkP != null) {
                    DistributeVideoView.this.sa(1);
                }
            }
        };
        this.gdS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkr();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdC = false;
        this.SX = null;
        this.fze = -1;
        this.fzn = 0L;
        this.gdL = false;
        this.gdM = 0L;
        this.mStyle = 1;
        this.gdN = false;
        this.gdO = false;
        this.gdQ = false;
        this.gdR = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fzl) {
                    DistributeVideoView.this.fzl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.gdG || view2 == DistributeVideoView.this.gdF) {
                    DistributeVideoView.this.lG(DistributeVideoView.this.gdL ? false : true);
                } else if (view2 == DistributeVideoView.this.fZV || view2 == DistributeVideoView.this.gdJ) {
                    DistributeVideoView.this.bkq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gdD == null || !DistributeVideoView.this.gdD.qu()) {
                    DistributeVideoView.this.bkq();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gdD != null) {
                        WebVideoActivity.fWQ = new WebVideoActivity.a();
                        WebVideoActivity.fWQ.fXa = DistributeVideoView.this.gdD;
                        WebVideoActivity.fWQ.fXb = "DETAIL";
                        WebVideoActivity.fWQ.mPageNum = DistributeVideoView.this.gdE;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gdD.VS, true, true, true, DistributeVideoView.this.fzd.video_url, DistributeVideoView.this.fzd.thumbnail_url, DistributeVideoView.this.fzd.video_width.intValue() / DistributeVideoView.this.fzd.video_height.intValue(), DistributeVideoView.this.fzd.video_duration.intValue());
                    if (DistributeVideoView.this.fWW != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fWW.fXU);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fWW.fXV);
                    }
                    if (DistributeVideoView.this.fWX != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fWX.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.fze != 1) {
                            if (DistributeVideoView.this.bkP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fze = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dLL.setVisibility(8);
                                DistributeVideoView.this.lG(DistributeVideoView.this.gdL);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gdK.setPlayer(DistributeVideoView.this.bkP);
                                    DistributeVideoView.this.gdK.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fzd.video_duration.intValue()));
                                    DistributeVideoView.this.gdK.showProgress();
                                    DistributeVideoView.this.lH(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.gdS);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.gdS, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fzn = DistributeVideoView.this.bkP.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bkP.getDuration() - DistributeVideoView.this.bkP.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fzh.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fze == 1) {
                            if (DistributeVideoView.this.fzn == DistributeVideoView.this.bkP.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fzn = DistributeVideoView.this.bkP.getCurrentPosition();
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gdP = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gdD != null) {
                    if (DistributeVideoView.this.gdQ && "DETAIL".equals(DistributeVideoView.this.gdD.Vt)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), 0);
                    DistributeVideoView.this.f19com = gVar;
                    DistributeVideoView.this.f19com.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bkp();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), gVar.getCurrentPosition());
                DistributeVideoView.this.dLL.setForegroundDrawable(0);
                DistributeVideoView.this.fZV.setVisibility(8);
                DistributeVideoView.this.fzl.setVisibility(0);
                return true;
            }
        };
        this.aZn = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gdM = System.currentTimeMillis();
                DistributeVideoView.this.gdQ = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), gVar.getDuration());
                DistributeVideoView.this.bkp();
                if (DistributeVideoView.this.gap != null) {
                    DistributeVideoView.this.gap.bkj();
                    DistributeVideoView.this.fzh.setVisibility(8);
                    DistributeVideoView.this.fZV.setVisibility(8);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fzt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fzd != null && DistributeVideoView.this.bkP != null) {
                    DistributeVideoView.this.sa(1);
                }
            }
        };
        this.gdS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkr();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdC = false;
        this.SX = null;
        this.fze = -1;
        this.fzn = 0L;
        this.gdL = false;
        this.gdM = 0L;
        this.mStyle = 1;
        this.gdN = false;
        this.gdO = false;
        this.gdQ = false;
        this.gdR = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fzl) {
                    DistributeVideoView.this.fzl.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.gdG || view2 == DistributeVideoView.this.gdF) {
                    DistributeVideoView.this.lG(DistributeVideoView.this.gdL ? false : true);
                } else if (view2 == DistributeVideoView.this.fZV || view2 == DistributeVideoView.this.gdJ) {
                    DistributeVideoView.this.bkq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gdD == null || !DistributeVideoView.this.gdD.qu()) {
                    DistributeVideoView.this.bkq();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gdD != null) {
                        WebVideoActivity.fWQ = new WebVideoActivity.a();
                        WebVideoActivity.fWQ.fXa = DistributeVideoView.this.gdD;
                        WebVideoActivity.fWQ.fXb = "DETAIL";
                        WebVideoActivity.fWQ.mPageNum = DistributeVideoView.this.gdE;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gdD.VS, true, true, true, DistributeVideoView.this.fzd.video_url, DistributeVideoView.this.fzd.thumbnail_url, DistributeVideoView.this.fzd.video_width.intValue() / DistributeVideoView.this.fzd.video_height.intValue(), DistributeVideoView.this.fzd.video_duration.intValue());
                    if (DistributeVideoView.this.fWW != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fWW.fXU);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fWW.fXV);
                    }
                    if (DistributeVideoView.this.fWX != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fWX.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1001:
                        if (DistributeVideoView.this.fze != 1) {
                            if (DistributeVideoView.this.bkP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fze = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dLL.setVisibility(8);
                                DistributeVideoView.this.lG(DistributeVideoView.this.gdL);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gdK.setPlayer(DistributeVideoView.this.bkP);
                                    DistributeVideoView.this.gdK.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fzd.video_duration.intValue()));
                                    DistributeVideoView.this.gdK.showProgress();
                                    DistributeVideoView.this.lH(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.gdS);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.gdS, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fzn = DistributeVideoView.this.bkP.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bkP.getDuration() - DistributeVideoView.this.bkP.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fzh.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fze == 1) {
                            if (DistributeVideoView.this.fzn == DistributeVideoView.this.bkP.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fzn = DistributeVideoView.this.bkP.getCurrentPosition();
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
        this.aZo = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gdP = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gdD != null) {
                    if (DistributeVideoView.this.gdQ && "DETAIL".equals(DistributeVideoView.this.gdD.Vt)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.X(i2, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), 0);
                    DistributeVideoView.this.f19com = gVar;
                    DistributeVideoView.this.f19com.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bkp();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), gVar.getCurrentPosition());
                DistributeVideoView.this.dLL.setForegroundDrawable(0);
                DistributeVideoView.this.fZV.setVisibility(8);
                DistributeVideoView.this.fzl.setVisibility(0);
                return true;
            }
        };
        this.aZn = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gdM = System.currentTimeMillis();
                DistributeVideoView.this.gdQ = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sb(DistributeVideoView.this.gdR), gVar.getDuration());
                DistributeVideoView.this.bkp();
                if (DistributeVideoView.this.gap != null) {
                    DistributeVideoView.this.gap.bkj();
                    DistributeVideoView.this.fzh.setVisibility(8);
                    DistributeVideoView.this.fZV.setVisibility(8);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fzt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fzd != null && DistributeVideoView.this.bkP != null) {
                    DistributeVideoView.this.sa(1);
                }
            }
        };
        this.gdS = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkr();
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.i.distribute_video_view, (ViewGroup) this, true);
            this.bkP = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.fZV = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.dLL = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(d.g.distribute_loading);
            this.fzh = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.fzl = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gdH = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gdF = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gdI = this.mRootView.findViewById(d.g.distribute_control);
            this.gdJ = (ImageView) this.gdI.findViewById(d.g.distribute_play_icon);
            this.gdG = (ImageView) this.gdI.findViewById(d.g.distribute_voice);
            this.gdK = (VideoControllerView) this.gdI.findViewById(d.g.distribute_process);
            this.gan = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gao = new com.baidu.tieba.recapp.e.d(context, this.gan);
        }
    }

    private boolean bcI() {
        return this.mStyle == 1 ? q.bcI() : j.gQ();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            initAnimation();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.fWW = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.fWX = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fzd = videoInfo;
        this.mDuration = this.fzd.video_duration.intValue() * 1000;
        this.SX = new WeakReference<>(this.mContext.getApplicationContext());
        bkp();
        ak.j(this, d.C0126d.cp_bg_line_d);
        int af = l.af(this.mContext) - l.e(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.fzd.video_width.intValue() > 0 ? (this.fzd.video_height.intValue() * af) / this.fzd.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        ak.i(this.fZV, d.f.icon_play_video);
        this.fZV.setVisibility(8);
        this.dLL.setDefaultErrorResource(0);
        this.dLL.setDefaultResource(0);
        this.dLL.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dLL.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dLL.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnErrorListener(this.aZp);
        this.bkP.setOnCompletionListener(this.aZn);
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        ak.h(this.fzh, d.C0126d.cp_cont_i);
        ak.i(this.fzh, d.f.video_play_count_bg);
        this.fzh.setText(StringUtils.translateSecondsToString(this.fzd.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gdL = false;
            ak.c(this.gdF, d.f.ad_icon_sound_close);
        } else {
            this.gdL = true;
            ak.c(this.gdG, d.f.ad_icon_sound_open);
            this.gdF.setVisibility(8);
        }
        this.gdG.setOnClickListener(this.mOnClickListener);
        this.gdF.setOnClickListener(this.mOnClickListener);
        this.fzl.setOnClickListener(this.mOnClickListener);
        this.fzl.setVisibility(8);
        ak.j(this.fzl, d.C0126d.black_alpha80);
        ak.h(this.gdH, d.C0126d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fzh.setVisibility(0);
            return;
        }
        this.fzh.setVisibility(8);
        this.gdJ.setOnClickListener(this.mOnClickListener);
        this.fZV.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fzd = videoInfo;
        this.SX = new WeakReference<>(this.mContext.getApplicationContext());
        bkp();
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        ak.i(this.fZV, d.f.btn_icon_play_video_n);
        this.fZV.setVisibility(8);
        this.dLL.setDefaultErrorResource(0);
        this.dLL.setDefaultResource(0);
        this.dLL.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dLL.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dLL.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnErrorListener(this.aZp);
        this.bkP.setOnCompletionListener(this.aZn);
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        ak.h(this.fzh, d.C0126d.cp_cont_i);
        this.fzh.setText(StringUtils.translateSecondsToString(this.fzd.video_duration.intValue()));
        ak.i(this.fzh, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gdL = false;
            ak.c(this.gdF, d.f.ad_icon_sound_close);
        } else {
            this.gdL = true;
            ak.c(this.gdG, d.f.ad_icon_sound_open);
            this.gdF.setVisibility(8);
        }
        this.gdG.setOnClickListener(this.mOnClickListener);
        this.gdF.setOnClickListener(this.mOnClickListener);
        this.fzl.setOnClickListener(this.mOnClickListener);
        this.fzl.setVisibility(8);
        ak.j(this.fzl, d.C0126d.black_alpha80);
        ak.h(this.gdH, d.C0126d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fzh.setVisibility(0);
            return;
        }
        this.fzh.setVisibility(8);
        this.gdJ.setOnClickListener(this.mOnClickListener);
        this.fZV.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gap = this.gao.a(this.fWX, this.gap);
        if (this.gap != null) {
            this.gap.setPageContext(this.mPageContext);
            this.gap.setAdvertAppInfo(advertAppInfo);
            this.gap.a(this.fWX);
            this.gap.bkk();
        }
    }

    public void setDownloadCallback(c cVar) {
        if (this.gap != null) {
            this.gap.setDownloadAppCallback(cVar);
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
            i(this.mRootView, i2, i3);
            return true;
        }
        i(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void i(View view2, int i, int i2) {
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCompleteListener(g.a aVar) {
        this.aZn = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(int i) {
        if (this.gap != null) {
            this.gap.bkk();
        }
        this.gdR = i;
        if (this.fzd != null && this.fze == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gdM) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.bkP.setVideoPath(this.fzd.video_url);
                this.bkP.start();
                this.gdP = this.bkP.getCurrentPosition();
                this.fZV.setVisibility(8);
                ak.c(this.gdJ, d.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.fzl.setVisibility(8);
                this.dLL.setForegroundDrawable(0);
                this.fze = 0;
            }
        }
    }

    public void performPlay() {
        sa(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bcI()) {
            if (i <= 0) {
                sa(1);
                return;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fzt);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fzt, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fze == 1) {
            y(32, sb(this.gdR), this.bkP.getCurrentPosition(), i);
            this.bkP.pause();
            y.a(this.SX, false);
            this.fZV.setVisibility(0);
            ak.c(this.gdJ, d.f.icon_video_midpause);
            this.fze = 2;
        }
    }

    public void autoContinue() {
        if (!this.gdO) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fze == 2) {
            this.gdR = i;
            X(33, sb(i), this.bkP.getCurrentPosition());
            this.gdP = this.bkP.getCurrentPosition();
            this.bkP.start();
            if (this.gdL) {
                y.a(this.SX, true);
            }
            this.fZV.setVisibility(8);
            ak.c(this.gdJ, d.f.icon_video_midplay);
            this.fze = 1;
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
        if (this.bkP.getCurrentPosition() > 0 && this.fze != -1) {
            int i = 32;
            if (this.bkP.getDuration() == this.bkP.getCurrentPosition()) {
                i = 34;
            }
            e(i, sb(this.gdR), this.bkP.getCurrentPosition(), this.bkP.isPlaying());
        }
        bkp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fzt);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.gdS);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bkP.stopPlayback();
        this.fze = -1;
        y.a(this.SX, false);
        this.dLL.setForegroundDrawable(0);
        this.dLL.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.fZV.setVisibility(0);
        ak.c(this.gdJ, d.f.icon_video_midpause);
        this.gdK.Ne();
        this.fzl.setVisibility(8);
        if (this.fzd != null) {
            this.fzh.setText(StringUtils.translateSecondsToString(this.fzd.video_duration.intValue()));
        }
        this.f19com = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sb(int i) {
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
        return this.fzd != null ? this.fzd.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if (z) {
            if (this.f19com != null) {
                this.f19com.setVolume(1.0f, 1.0f);
            }
            ak.c(this.gdG, d.f.ad_icon_sound_open);
            ak.c(this.gdF, d.f.ad_icon_sound_open);
            if (this.fze == 1) {
                y.a(this.SX, true);
            }
        } else {
            if (this.f19com != null) {
                this.f19com.setVolume(0.0f, 0.0f);
            }
            ak.c(this.gdG, d.f.ad_icon_sound_close);
            ak.c(this.gdF, d.f.ad_icon_sound_close);
            y.a(this.SX, false);
        }
        this.gdL = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fze;
    }

    public VideoInfo getData() {
        return this.fzd;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fzn;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gdC && this.gdB != null && this.gdB.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.ah(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gdD = advertAppInfo;
        this.gdE = i;
        this.fXb = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.Vt = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gdD, 303, i, sb(this.gdR), this.fzd.video_duration.intValue(), this.mDuration, -1);
        if (this.gap != null) {
            this.gap.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i, int i2, int i3) {
        y(i, i2, i3, -1);
    }

    private void e(int i, int i2, int i3, boolean z) {
        b(i, i2, i3, -1, z);
    }

    private void y(int i, int i2, int i3, int i4) {
        b(i, i2, i3, i4, true);
    }

    private void b(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.gdD != null && this.fzd != null) {
            this.gdD.Vt = this.fXb;
            b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gdD, i, this.gdE, i2, this.fzd.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.fXb)) {
                    str2 = "det";
                } else if ("FRS".equals(this.fXb)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.fXb)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gdP, i3, this.mDuration, str2, sc(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.fWW != null && "cpv".equals(this.fWW.fXU) && !TextUtils.isEmpty(this.fWW.fXV)) {
            new com.baidu.tieba.recapp.request.a(this.fWW.fXV).a(str, i, i2, i3, str2, str3);
        }
    }

    private String sc(int i) {
        if (i == 0) {
            return ActVideoSetting.ACT_URL;
        }
        if (i != 1) {
            return ActVideoSetting.ACT_URL;
        }
        return "cl";
    }

    public void setHolderView(View view2) {
        if (view2 != null) {
            this.gdB = view2;
            this.gdC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.gdS);
            if (this.dbd != null) {
                this.dbd.cancel();
            }
            this.gdI.setVisibility(0);
            if (this.fze == 1) {
                ak.c(this.gdJ, d.f.icon_video_midplay);
                return;
            } else {
                ak.c(this.gdJ, d.f.icon_video_midpause);
                return;
            }
        }
        this.gdI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkq() {
        switch (this.fze) {
            case -1:
                if (!j.gP() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.k.neterror);
                    return;
                } else if (!j.gQ() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.bZ(d.k.play_video_mobile_tip);
                    aVar.a(d.k.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            DistributeVideoView.this.performPlay();
                        }
                    });
                    aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(this.mPageContext).tD();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gdO = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lH(true);
                    return;
                }
                return;
            case 2:
                this.gdO = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.fw().removeCallbacks(this.gdS);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.gdS, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkr() {
        if (!this.gdN && this.dbd != null) {
            this.gdI.startAnimation(this.dbd);
            this.gdN = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.dbd = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dbd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gdI.setVisibility(8);
                    DistributeVideoView.this.gdN = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
