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
    private g cop;
    private ForeDrawableImageView dLO;
    private Animation dbg;
    private AdCard.a fWZ;
    private AdCard.f fXa;
    private String fXe;
    private ImageView fZY;
    private VideoInfo fzg;
    private int fzh;
    private TextView fzk;
    private View fzo;
    private long fzq;
    private Runnable fzw;
    private ViewGroup gaq;
    private d gar;
    private e gas;
    private View gdE;
    private boolean gdF;
    private AdvertAppInfo gdG;
    private int gdH;
    private ImageView gdI;
    private ImageView gdJ;
    private TextView gdK;
    private View gdL;
    private ImageView gdM;
    private VideoControllerView gdN;
    private boolean gdO;
    private long gdP;
    boolean gdQ;
    boolean gdR;
    private int gdS;
    boolean gdT;
    private int gdU;
    private Runnable gdV;
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
        this.gdF = false;
        this.SX = null;
        this.fzh = -1;
        this.fzq = 0L;
        this.gdO = false;
        this.gdP = 0L;
        this.mStyle = 1;
        this.gdQ = false;
        this.gdR = false;
        this.gdT = false;
        this.gdU = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fzo) {
                    DistributeVideoView.this.fzo.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.gdJ || view2 == DistributeVideoView.this.gdI) {
                    DistributeVideoView.this.lG(DistributeVideoView.this.gdO ? false : true);
                } else if (view2 == DistributeVideoView.this.fZY || view2 == DistributeVideoView.this.gdM) {
                    DistributeVideoView.this.bkq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gdG == null || !DistributeVideoView.this.gdG.qu()) {
                    DistributeVideoView.this.bkq();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gdG != null) {
                        WebVideoActivity.fWT = new WebVideoActivity.a();
                        WebVideoActivity.fWT.fXd = DistributeVideoView.this.gdG;
                        WebVideoActivity.fWT.fXe = "DETAIL";
                        WebVideoActivity.fWT.mPageNum = DistributeVideoView.this.gdH;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gdG.VS, true, true, true, DistributeVideoView.this.fzg.video_url, DistributeVideoView.this.fzg.thumbnail_url, DistributeVideoView.this.fzg.video_width.intValue() / DistributeVideoView.this.fzg.video_height.intValue(), DistributeVideoView.this.fzg.video_duration.intValue());
                    if (DistributeVideoView.this.fWZ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fWZ.fXX);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fWZ.fXY);
                    }
                    if (DistributeVideoView.this.fXa != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fXa.toJsonString());
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
                        if (DistributeVideoView.this.fzh != 1) {
                            if (DistributeVideoView.this.bkP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fzh = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dLO.setVisibility(8);
                                DistributeVideoView.this.lG(DistributeVideoView.this.gdO);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gdN.setPlayer(DistributeVideoView.this.bkP);
                                    DistributeVideoView.this.gdN.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fzg.video_duration.intValue()));
                                    DistributeVideoView.this.gdN.showProgress();
                                    DistributeVideoView.this.lH(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.gdV);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.gdV, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fzq = DistributeVideoView.this.bkP.getCurrentPosition();
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
                            DistributeVideoView.this.fzk.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fzh == 1) {
                            if (DistributeVideoView.this.fzq == DistributeVideoView.this.bkP.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fzq = DistributeVideoView.this.bkP.getCurrentPosition();
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
                DistributeVideoView.this.gdS = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gdG != null) {
                    if (DistributeVideoView.this.gdT && "DETAIL".equals(DistributeVideoView.this.gdG.Vt)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), 0);
                    DistributeVideoView.this.cop = gVar;
                    DistributeVideoView.this.cop.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bkp();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), gVar.getCurrentPosition());
                DistributeVideoView.this.dLO.setForegroundDrawable(0);
                DistributeVideoView.this.fZY.setVisibility(8);
                DistributeVideoView.this.fzo.setVisibility(0);
                return true;
            }
        };
        this.aZn = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gdP = System.currentTimeMillis();
                DistributeVideoView.this.gdT = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), gVar.getDuration());
                DistributeVideoView.this.bkp();
                if (DistributeVideoView.this.gas != null) {
                    DistributeVideoView.this.gas.bkj();
                    DistributeVideoView.this.fzk.setVisibility(8);
                    DistributeVideoView.this.fZY.setVisibility(8);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fzw = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fzg != null && DistributeVideoView.this.bkP != null) {
                    DistributeVideoView.this.sa(1);
                }
            }
        };
        this.gdV = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkr();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdF = false;
        this.SX = null;
        this.fzh = -1;
        this.fzq = 0L;
        this.gdO = false;
        this.gdP = 0L;
        this.mStyle = 1;
        this.gdQ = false;
        this.gdR = false;
        this.gdT = false;
        this.gdU = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fzo) {
                    DistributeVideoView.this.fzo.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.gdJ || view2 == DistributeVideoView.this.gdI) {
                    DistributeVideoView.this.lG(DistributeVideoView.this.gdO ? false : true);
                } else if (view2 == DistributeVideoView.this.fZY || view2 == DistributeVideoView.this.gdM) {
                    DistributeVideoView.this.bkq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gdG == null || !DistributeVideoView.this.gdG.qu()) {
                    DistributeVideoView.this.bkq();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gdG != null) {
                        WebVideoActivity.fWT = new WebVideoActivity.a();
                        WebVideoActivity.fWT.fXd = DistributeVideoView.this.gdG;
                        WebVideoActivity.fWT.fXe = "DETAIL";
                        WebVideoActivity.fWT.mPageNum = DistributeVideoView.this.gdH;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gdG.VS, true, true, true, DistributeVideoView.this.fzg.video_url, DistributeVideoView.this.fzg.thumbnail_url, DistributeVideoView.this.fzg.video_width.intValue() / DistributeVideoView.this.fzg.video_height.intValue(), DistributeVideoView.this.fzg.video_duration.intValue());
                    if (DistributeVideoView.this.fWZ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fWZ.fXX);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fWZ.fXY);
                    }
                    if (DistributeVideoView.this.fXa != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fXa.toJsonString());
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
                        if (DistributeVideoView.this.fzh != 1) {
                            if (DistributeVideoView.this.bkP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fzh = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dLO.setVisibility(8);
                                DistributeVideoView.this.lG(DistributeVideoView.this.gdO);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gdN.setPlayer(DistributeVideoView.this.bkP);
                                    DistributeVideoView.this.gdN.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fzg.video_duration.intValue()));
                                    DistributeVideoView.this.gdN.showProgress();
                                    DistributeVideoView.this.lH(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.gdV);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.gdV, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fzq = DistributeVideoView.this.bkP.getCurrentPosition();
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
                            DistributeVideoView.this.fzk.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fzh == 1) {
                            if (DistributeVideoView.this.fzq == DistributeVideoView.this.bkP.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fzq = DistributeVideoView.this.bkP.getCurrentPosition();
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
                DistributeVideoView.this.gdS = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gdG != null) {
                    if (DistributeVideoView.this.gdT && "DETAIL".equals(DistributeVideoView.this.gdG.Vt)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), 0);
                    DistributeVideoView.this.cop = gVar;
                    DistributeVideoView.this.cop.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bkp();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), gVar.getCurrentPosition());
                DistributeVideoView.this.dLO.setForegroundDrawable(0);
                DistributeVideoView.this.fZY.setVisibility(8);
                DistributeVideoView.this.fzo.setVisibility(0);
                return true;
            }
        };
        this.aZn = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gdP = System.currentTimeMillis();
                DistributeVideoView.this.gdT = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), gVar.getDuration());
                DistributeVideoView.this.bkp();
                if (DistributeVideoView.this.gas != null) {
                    DistributeVideoView.this.gas.bkj();
                    DistributeVideoView.this.fzk.setVisibility(8);
                    DistributeVideoView.this.fZY.setVisibility(8);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fzw = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fzg != null && DistributeVideoView.this.bkP != null) {
                    DistributeVideoView.this.sa(1);
                }
            }
        };
        this.gdV = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkr();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gdF = false;
        this.SX = null;
        this.fzh = -1;
        this.fzq = 0L;
        this.gdO = false;
        this.gdP = 0L;
        this.mStyle = 1;
        this.gdQ = false;
        this.gdR = false;
        this.gdT = false;
        this.gdU = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fzo) {
                    DistributeVideoView.this.fzo.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.gdJ || view2 == DistributeVideoView.this.gdI) {
                    DistributeVideoView.this.lG(DistributeVideoView.this.gdO ? false : true);
                } else if (view2 == DistributeVideoView.this.fZY || view2 == DistributeVideoView.this.gdM) {
                    DistributeVideoView.this.bkq();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gdG == null || !DistributeVideoView.this.gdG.qu()) {
                    DistributeVideoView.this.bkq();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gdG != null) {
                        WebVideoActivity.fWT = new WebVideoActivity.a();
                        WebVideoActivity.fWT.fXd = DistributeVideoView.this.gdG;
                        WebVideoActivity.fWT.fXe = "DETAIL";
                        WebVideoActivity.fWT.mPageNum = DistributeVideoView.this.gdH;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gdG.VS, true, true, true, DistributeVideoView.this.fzg.video_url, DistributeVideoView.this.fzg.thumbnail_url, DistributeVideoView.this.fzg.video_width.intValue() / DistributeVideoView.this.fzg.video_height.intValue(), DistributeVideoView.this.fzg.video_duration.intValue());
                    if (DistributeVideoView.this.fWZ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fWZ.fXX);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fWZ.fXY);
                    }
                    if (DistributeVideoView.this.fXa != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fXa.toJsonString());
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
                        if (DistributeVideoView.this.fzh != 1) {
                            if (DistributeVideoView.this.bkP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fzh = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dLO.setVisibility(8);
                                DistributeVideoView.this.lG(DistributeVideoView.this.gdO);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gdN.setPlayer(DistributeVideoView.this.bkP);
                                    DistributeVideoView.this.gdN.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fzg.video_duration.intValue()));
                                    DistributeVideoView.this.gdN.showProgress();
                                    DistributeVideoView.this.lH(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.gdV);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.gdV, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fzq = DistributeVideoView.this.bkP.getCurrentPosition();
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
                            DistributeVideoView.this.fzk.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fzh == 1) {
                            if (DistributeVideoView.this.fzq == DistributeVideoView.this.bkP.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fzq = DistributeVideoView.this.bkP.getCurrentPosition();
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
                DistributeVideoView.this.gdS = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gdG != null) {
                    if (DistributeVideoView.this.gdT && "DETAIL".equals(DistributeVideoView.this.gdG.Vt)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.X(i2, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), 0);
                    DistributeVideoView.this.cop = gVar;
                    DistributeVideoView.this.cop.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZp = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bkp();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), gVar.getCurrentPosition());
                DistributeVideoView.this.dLO.setForegroundDrawable(0);
                DistributeVideoView.this.fZY.setVisibility(8);
                DistributeVideoView.this.fzo.setVisibility(0);
                return true;
            }
        };
        this.aZn = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gdP = System.currentTimeMillis();
                DistributeVideoView.this.gdT = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sb(DistributeVideoView.this.gdU), gVar.getDuration());
                DistributeVideoView.this.bkp();
                if (DistributeVideoView.this.gas != null) {
                    DistributeVideoView.this.gas.bkj();
                    DistributeVideoView.this.fzk.setVisibility(8);
                    DistributeVideoView.this.fZY.setVisibility(8);
                }
            }
        };
        this.bkY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fzw = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fzg != null && DistributeVideoView.this.bkP != null) {
                    DistributeVideoView.this.sa(1);
                }
            }
        };
        this.gdV = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
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
            this.fZY = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.dLO = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(d.g.distribute_loading);
            this.fzk = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.fzo = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gdK = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gdI = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gdL = this.mRootView.findViewById(d.g.distribute_control);
            this.gdM = (ImageView) this.gdL.findViewById(d.g.distribute_play_icon);
            this.gdJ = (ImageView) this.gdL.findViewById(d.g.distribute_voice);
            this.gdN = (VideoControllerView) this.gdL.findViewById(d.g.distribute_process);
            this.gaq = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gar = new com.baidu.tieba.recapp.e.d(context, this.gaq);
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
        this.fWZ = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.fXa = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fzg = videoInfo;
        this.mDuration = this.fzg.video_duration.intValue() * 1000;
        this.SX = new WeakReference<>(this.mContext.getApplicationContext());
        bkp();
        ak.j(this, d.C0126d.cp_bg_line_d);
        int af = l.af(this.mContext) - l.e(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.fzg.video_width.intValue() > 0 ? (this.fzg.video_height.intValue() * af) / this.fzg.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        ak.i(this.fZY, d.f.icon_play_video);
        this.fZY.setVisibility(8);
        this.dLO.setDefaultErrorResource(0);
        this.dLO.setDefaultResource(0);
        this.dLO.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dLO.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dLO.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnErrorListener(this.aZp);
        this.bkP.setOnCompletionListener(this.aZn);
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        ak.h(this.fzk, d.C0126d.cp_cont_i);
        ak.i(this.fzk, d.f.video_play_count_bg);
        this.fzk.setText(StringUtils.translateSecondsToString(this.fzg.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gdO = false;
            ak.c(this.gdI, d.f.ad_icon_sound_close);
        } else {
            this.gdO = true;
            ak.c(this.gdJ, d.f.ad_icon_sound_open);
            this.gdI.setVisibility(8);
        }
        this.gdJ.setOnClickListener(this.mOnClickListener);
        this.gdI.setOnClickListener(this.mOnClickListener);
        this.fzo.setOnClickListener(this.mOnClickListener);
        this.fzo.setVisibility(8);
        ak.j(this.fzo, d.C0126d.black_alpha80);
        ak.h(this.gdK, d.C0126d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fzk.setVisibility(0);
            return;
        }
        this.fzk.setVisibility(8);
        this.gdM.setOnClickListener(this.mOnClickListener);
        this.fZY.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fzg = videoInfo;
        this.SX = new WeakReference<>(this.mContext.getApplicationContext());
        bkp();
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        ak.i(this.fZY, d.f.btn_icon_play_video_n);
        this.fZY.setVisibility(8);
        this.dLO.setDefaultErrorResource(0);
        this.dLO.setDefaultResource(0);
        this.dLO.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dLO.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dLO.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bkP.setOnPreparedListener(this.aZo);
        this.bkP.setOnErrorListener(this.aZp);
        this.bkP.setOnCompletionListener(this.aZn);
        this.bkP.setOnSurfaceDestroyedListener(this.bkY);
        ak.h(this.fzk, d.C0126d.cp_cont_i);
        this.fzk.setText(StringUtils.translateSecondsToString(this.fzg.video_duration.intValue()));
        ak.i(this.fzk, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gdO = false;
            ak.c(this.gdI, d.f.ad_icon_sound_close);
        } else {
            this.gdO = true;
            ak.c(this.gdJ, d.f.ad_icon_sound_open);
            this.gdI.setVisibility(8);
        }
        this.gdJ.setOnClickListener(this.mOnClickListener);
        this.gdI.setOnClickListener(this.mOnClickListener);
        this.fzo.setOnClickListener(this.mOnClickListener);
        this.fzo.setVisibility(8);
        ak.j(this.fzo, d.C0126d.black_alpha80);
        ak.h(this.gdK, d.C0126d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fzk.setVisibility(0);
            return;
        }
        this.fzk.setVisibility(8);
        this.gdM.setOnClickListener(this.mOnClickListener);
        this.fZY.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gas = this.gar.a(this.fXa, this.gas);
        if (this.gas != null) {
            this.gas.setPageContext(this.mPageContext);
            this.gas.setAdvertAppInfo(advertAppInfo);
            this.gas.a(this.fXa);
            this.gas.bkk();
        }
    }

    public void setDownloadCallback(c cVar) {
        if (this.gas != null) {
            this.gas.setDownloadAppCallback(cVar);
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
        if (this.gas != null) {
            this.gas.bkk();
        }
        this.gdU = i;
        if (this.fzg != null && this.fzh == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gdP) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.bkP.setVideoPath(this.fzg.video_url);
                this.bkP.start();
                this.gdS = this.bkP.getCurrentPosition();
                this.fZY.setVisibility(8);
                ak.c(this.gdM, d.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.fzo.setVisibility(8);
                this.dLO.setForegroundDrawable(0);
                this.fzh = 0;
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
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fzw);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fzw, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fzh == 1) {
            y(32, sb(this.gdU), this.bkP.getCurrentPosition(), i);
            this.bkP.pause();
            y.a(this.SX, false);
            this.fZY.setVisibility(0);
            ak.c(this.gdM, d.f.icon_video_midpause);
            this.fzh = 2;
        }
    }

    public void autoContinue() {
        if (!this.gdR) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fzh == 2) {
            this.gdU = i;
            X(33, sb(i), this.bkP.getCurrentPosition());
            this.gdS = this.bkP.getCurrentPosition();
            this.bkP.start();
            if (this.gdO) {
                y.a(this.SX, true);
            }
            this.fZY.setVisibility(8);
            ak.c(this.gdM, d.f.icon_video_midplay);
            this.fzh = 1;
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
        if (this.bkP.getCurrentPosition() > 0 && this.fzh != -1) {
            int i = 32;
            if (this.bkP.getDuration() == this.bkP.getCurrentPosition()) {
                i = 34;
            }
            e(i, sb(this.gdU), this.bkP.getCurrentPosition(), this.bkP.isPlaying());
        }
        bkp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fzw);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.gdV);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bkP.stopPlayback();
        this.fzh = -1;
        y.a(this.SX, false);
        this.dLO.setForegroundDrawable(0);
        this.dLO.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.fZY.setVisibility(0);
        ak.c(this.gdM, d.f.icon_video_midpause);
        this.gdN.Ne();
        this.fzo.setVisibility(8);
        if (this.fzg != null) {
            this.fzk.setText(StringUtils.translateSecondsToString(this.fzg.video_duration.intValue()));
        }
        this.cop = null;
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
        return this.fzg != null ? this.fzg.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lG(boolean z) {
        if (z) {
            if (this.cop != null) {
                this.cop.setVolume(1.0f, 1.0f);
            }
            ak.c(this.gdJ, d.f.ad_icon_sound_open);
            ak.c(this.gdI, d.f.ad_icon_sound_open);
            if (this.fzh == 1) {
                y.a(this.SX, true);
            }
        } else {
            if (this.cop != null) {
                this.cop.setVolume(0.0f, 0.0f);
            }
            ak.c(this.gdJ, d.f.ad_icon_sound_close);
            ak.c(this.gdI, d.f.ad_icon_sound_close);
            y.a(this.SX, false);
        }
        this.gdO = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fzh;
    }

    public VideoInfo getData() {
        return this.fzg;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fzq;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gdF && this.gdE != null && this.gdE.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.ah(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gdG = advertAppInfo;
        this.gdH = i;
        this.fXe = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.Vt = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gdG, 303, i, sb(this.gdU), this.fzg.video_duration.intValue(), this.mDuration, -1);
        if (this.gas != null) {
            this.gas.e(a);
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
        if (this.gdG != null && this.fzg != null) {
            this.gdG.Vt = this.fXe;
            b.bke().a(com.baidu.tieba.recapp.report.e.a(this.gdG, i, this.gdH, i2, this.fzg.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.fXe)) {
                    str2 = "det";
                } else if ("FRS".equals(this.fXe)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.fXe)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gdS, i3, this.mDuration, str2, sc(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.fWZ != null && "cpv".equals(this.fWZ.fXX) && !TextUtils.isEmpty(this.fWZ.fXY)) {
            new com.baidu.tieba.recapp.request.a(this.fWZ.fXY).a(str, i, i2, i3, str2, str3);
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
            this.gdE = view2;
            this.gdF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.gdV);
            if (this.dbg != null) {
                this.dbg.cancel();
            }
            this.gdL.setVisibility(0);
            if (this.fzh == 1) {
                ak.c(this.gdM, d.f.icon_video_midplay);
                return;
            } else {
                ak.c(this.gdM, d.f.icon_video_midpause);
                return;
            }
        }
        this.gdL.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkq() {
        switch (this.fzh) {
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
                this.gdR = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lH(true);
                    return;
                }
                return;
            case 2:
                this.gdR = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.fw().removeCallbacks(this.gdV);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.gdV, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkr() {
        if (!this.gdQ && this.dbg != null) {
            this.gdL.startAnimation(this.dbg);
            this.gdQ = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.dbg = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dbg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gdL.setVisibility(8);
                    DistributeVideoView.this.gdQ = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
