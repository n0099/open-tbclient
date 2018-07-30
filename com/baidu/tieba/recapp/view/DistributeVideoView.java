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
    private WeakReference<Context> aaH;
    private g.b bdd;
    private QuickVideoView.b bdh;
    private g.a bjG;
    private g.f bjH;
    private QuickVideoView bvp;
    private View cXy;
    private g cyE;
    private Animation drf;
    private String eQl;
    private ForeDrawableImageView efN;
    private VideoInfo fPR;
    private int fPS;
    private TextView fPV;
    private View fPZ;
    private long fQb;
    private Runnable fQh;
    private String goA;
    private AdCard.a gov;
    private AdCard.f gow;
    private ViewGroup grM;
    private d grN;
    private e grO;
    private ImageView gru;
    private View gvg;
    private boolean gvh;
    private AdvertAppInfo gvi;
    private int gvj;
    private ImageView gvk;
    private ImageView gvl;
    private TextView gvm;
    private View gvn;
    private ImageView gvo;
    private VideoControllerView gvp;
    private boolean gvq;
    private long gvr;
    private b gvs;
    boolean gvt;
    boolean gvu;
    private int gvv;
    boolean gvw;
    private int gvx;
    private Runnable gvy;
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
        this.gvh = false;
        this.aaH = null;
        this.fPS = -1;
        this.fQb = 0L;
        this.gvq = false;
        this.gvr = 0L;
        this.mStyle = 1;
        this.gvt = false;
        this.gvu = false;
        this.gvw = false;
        this.gvx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPZ) {
                    DistributeVideoView.this.fPZ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gvl || view == DistributeVideoView.this.gvk) {
                    DistributeVideoView.this.lI(DistributeVideoView.this.gvq ? false : true);
                } else if (view == DistributeVideoView.this.gru || view == DistributeVideoView.this.gvo) {
                    DistributeVideoView.this.bot();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gvi == null || !DistributeVideoView.this.gvi.tH()) {
                    DistributeVideoView.this.bot();
                } else {
                    DistributeVideoView.this.W(2, 1, 0);
                    if (DistributeVideoView.this.gvi != null) {
                        WebVideoActivity.gop = new WebVideoActivity.a();
                        WebVideoActivity.gop.goz = DistributeVideoView.this.gvi;
                        WebVideoActivity.gop.goA = "DETAIL";
                        WebVideoActivity.gop.mPageNum = DistributeVideoView.this.gvj;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eQl) ? DistributeVideoView.this.eQl : DistributeVideoView.this.gvi.adH, true, true, true, DistributeVideoView.this.fPR.video_url, DistributeVideoView.this.fPR.thumbnail_url, DistributeVideoView.this.fPR.video_width.intValue() / DistributeVideoView.this.fPR.video_height.intValue(), DistributeVideoView.this.fPR.video_duration.intValue());
                    if (DistributeVideoView.this.gov != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gov.gpt);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gov.gpu);
                    }
                    if (DistributeVideoView.this.gow != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gow.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pr(DistributeVideoView.this.parallelChargeInfo.ePE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ePH.iterator();
                        while (it.hasNext()) {
                            c.pr(it.next());
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
                        if (DistributeVideoView.this.fPS != 1) {
                            if (DistributeVideoView.this.bvp.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPS = 1;
                                DistributeVideoView.this.cXy.setVisibility(8);
                                DistributeVideoView.this.efN.setVisibility(8);
                                DistributeVideoView.this.lI(DistributeVideoView.this.gvq);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gvp.setPlayer(DistributeVideoView.this.bvp);
                                    DistributeVideoView.this.gvp.T(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPR.video_duration.intValue()));
                                    DistributeVideoView.this.gvp.showProgress();
                                    DistributeVideoView.this.lJ(true);
                                    com.baidu.adp.lib.g.e.in().removeCallbacks(DistributeVideoView.this.gvy);
                                    com.baidu.adp.lib.g.e.in().postDelayed(DistributeVideoView.this.gvy, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fQb = DistributeVideoView.this.bvp.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bvp.getDuration() - DistributeVideoView.this.bvp.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPV.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPS == 1) {
                            if (DistributeVideoView.this.fQb == DistributeVideoView.this.bvp.getCurrentPosition()) {
                                DistributeVideoView.this.cXy.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fQb = DistributeVideoView.this.bvp.getCurrentPosition();
                                DistributeVideoView.this.cXy.setVisibility(8);
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
        this.bjH = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gvv = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gvi != null) {
                        if (DistributeVideoView.this.gvw && "DETAIL".equals(DistributeVideoView.this.gvi.adi)) {
                            i = 35;
                        } else {
                            i = 31;
                        }
                        DistributeVideoView.this.W(i, DistributeVideoView.this.su(DistributeVideoView.this.gvx), 0);
                    }
                    DistributeVideoView.this.cyE = gVar;
                    DistributeVideoView.this.cyE.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bos();
                DistributeVideoView.this.W(36, DistributeVideoView.this.su(DistributeVideoView.this.gvx), gVar.getCurrentPosition());
                DistributeVideoView.this.efN.setForegroundDrawable(0);
                DistributeVideoView.this.gru.setVisibility(8);
                DistributeVideoView.this.fPZ.setVisibility(0);
                return true;
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gvr = System.currentTimeMillis();
                DistributeVideoView.this.gvw = true;
                DistributeVideoView.this.W(34, DistributeVideoView.this.su(DistributeVideoView.this.gvx), gVar.getDuration());
                DistributeVideoView.this.bos();
                if (DistributeVideoView.this.grO != null) {
                    DistributeVideoView.this.grO.bom();
                    DistributeVideoView.this.fPV.setVisibility(8);
                    DistributeVideoView.this.gru.setVisibility(8);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fQh = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPR != null && DistributeVideoView.this.bvp != null) {
                    DistributeVideoView.this.st(1);
                }
            }
        };
        this.gvy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bou();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvh = false;
        this.aaH = null;
        this.fPS = -1;
        this.fQb = 0L;
        this.gvq = false;
        this.gvr = 0L;
        this.mStyle = 1;
        this.gvt = false;
        this.gvu = false;
        this.gvw = false;
        this.gvx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPZ) {
                    DistributeVideoView.this.fPZ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gvl || view == DistributeVideoView.this.gvk) {
                    DistributeVideoView.this.lI(DistributeVideoView.this.gvq ? false : true);
                } else if (view == DistributeVideoView.this.gru || view == DistributeVideoView.this.gvo) {
                    DistributeVideoView.this.bot();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gvi == null || !DistributeVideoView.this.gvi.tH()) {
                    DistributeVideoView.this.bot();
                } else {
                    DistributeVideoView.this.W(2, 1, 0);
                    if (DistributeVideoView.this.gvi != null) {
                        WebVideoActivity.gop = new WebVideoActivity.a();
                        WebVideoActivity.gop.goz = DistributeVideoView.this.gvi;
                        WebVideoActivity.gop.goA = "DETAIL";
                        WebVideoActivity.gop.mPageNum = DistributeVideoView.this.gvj;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eQl) ? DistributeVideoView.this.eQl : DistributeVideoView.this.gvi.adH, true, true, true, DistributeVideoView.this.fPR.video_url, DistributeVideoView.this.fPR.thumbnail_url, DistributeVideoView.this.fPR.video_width.intValue() / DistributeVideoView.this.fPR.video_height.intValue(), DistributeVideoView.this.fPR.video_duration.intValue());
                    if (DistributeVideoView.this.gov != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gov.gpt);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gov.gpu);
                    }
                    if (DistributeVideoView.this.gow != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gow.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pr(DistributeVideoView.this.parallelChargeInfo.ePE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ePH.iterator();
                        while (it.hasNext()) {
                            c.pr(it.next());
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
                        if (DistributeVideoView.this.fPS != 1) {
                            if (DistributeVideoView.this.bvp.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPS = 1;
                                DistributeVideoView.this.cXy.setVisibility(8);
                                DistributeVideoView.this.efN.setVisibility(8);
                                DistributeVideoView.this.lI(DistributeVideoView.this.gvq);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gvp.setPlayer(DistributeVideoView.this.bvp);
                                    DistributeVideoView.this.gvp.T(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPR.video_duration.intValue()));
                                    DistributeVideoView.this.gvp.showProgress();
                                    DistributeVideoView.this.lJ(true);
                                    com.baidu.adp.lib.g.e.in().removeCallbacks(DistributeVideoView.this.gvy);
                                    com.baidu.adp.lib.g.e.in().postDelayed(DistributeVideoView.this.gvy, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fQb = DistributeVideoView.this.bvp.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bvp.getDuration() - DistributeVideoView.this.bvp.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPV.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPS == 1) {
                            if (DistributeVideoView.this.fQb == DistributeVideoView.this.bvp.getCurrentPosition()) {
                                DistributeVideoView.this.cXy.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fQb = DistributeVideoView.this.bvp.getCurrentPosition();
                                DistributeVideoView.this.cXy.setVisibility(8);
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
        this.bjH = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gvv = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gvi != null) {
                        if (DistributeVideoView.this.gvw && "DETAIL".equals(DistributeVideoView.this.gvi.adi)) {
                            i = 35;
                        } else {
                            i = 31;
                        }
                        DistributeVideoView.this.W(i, DistributeVideoView.this.su(DistributeVideoView.this.gvx), 0);
                    }
                    DistributeVideoView.this.cyE = gVar;
                    DistributeVideoView.this.cyE.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bos();
                DistributeVideoView.this.W(36, DistributeVideoView.this.su(DistributeVideoView.this.gvx), gVar.getCurrentPosition());
                DistributeVideoView.this.efN.setForegroundDrawable(0);
                DistributeVideoView.this.gru.setVisibility(8);
                DistributeVideoView.this.fPZ.setVisibility(0);
                return true;
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gvr = System.currentTimeMillis();
                DistributeVideoView.this.gvw = true;
                DistributeVideoView.this.W(34, DistributeVideoView.this.su(DistributeVideoView.this.gvx), gVar.getDuration());
                DistributeVideoView.this.bos();
                if (DistributeVideoView.this.grO != null) {
                    DistributeVideoView.this.grO.bom();
                    DistributeVideoView.this.fPV.setVisibility(8);
                    DistributeVideoView.this.gru.setVisibility(8);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fQh = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPR != null && DistributeVideoView.this.bvp != null) {
                    DistributeVideoView.this.st(1);
                }
            }
        };
        this.gvy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bou();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gvh = false;
        this.aaH = null;
        this.fPS = -1;
        this.fQb = 0L;
        this.gvq = false;
        this.gvr = 0L;
        this.mStyle = 1;
        this.gvt = false;
        this.gvu = false;
        this.gvw = false;
        this.gvx = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPZ) {
                    DistributeVideoView.this.fPZ.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gvl || view == DistributeVideoView.this.gvk) {
                    DistributeVideoView.this.lI(DistributeVideoView.this.gvq ? false : true);
                } else if (view == DistributeVideoView.this.gru || view == DistributeVideoView.this.gvo) {
                    DistributeVideoView.this.bot();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gvi == null || !DistributeVideoView.this.gvi.tH()) {
                    DistributeVideoView.this.bot();
                } else {
                    DistributeVideoView.this.W(2, 1, 0);
                    if (DistributeVideoView.this.gvi != null) {
                        WebVideoActivity.gop = new WebVideoActivity.a();
                        WebVideoActivity.gop.goz = DistributeVideoView.this.gvi;
                        WebVideoActivity.gop.goA = "DETAIL";
                        WebVideoActivity.gop.mPageNum = DistributeVideoView.this.gvj;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eQl) ? DistributeVideoView.this.eQl : DistributeVideoView.this.gvi.adH, true, true, true, DistributeVideoView.this.fPR.video_url, DistributeVideoView.this.fPR.thumbnail_url, DistributeVideoView.this.fPR.video_width.intValue() / DistributeVideoView.this.fPR.video_height.intValue(), DistributeVideoView.this.fPR.video_duration.intValue());
                    if (DistributeVideoView.this.gov != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gov.gpt);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gov.gpu);
                    }
                    if (DistributeVideoView.this.gow != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gow.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pr(DistributeVideoView.this.parallelChargeInfo.ePE);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.ePH.iterator();
                        while (it.hasNext()) {
                            c.pr(it.next());
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
                        if (DistributeVideoView.this.fPS != 1) {
                            if (DistributeVideoView.this.bvp.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPS = 1;
                                DistributeVideoView.this.cXy.setVisibility(8);
                                DistributeVideoView.this.efN.setVisibility(8);
                                DistributeVideoView.this.lI(DistributeVideoView.this.gvq);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gvp.setPlayer(DistributeVideoView.this.bvp);
                                    DistributeVideoView.this.gvp.T(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPR.video_duration.intValue()));
                                    DistributeVideoView.this.gvp.showProgress();
                                    DistributeVideoView.this.lJ(true);
                                    com.baidu.adp.lib.g.e.in().removeCallbacks(DistributeVideoView.this.gvy);
                                    com.baidu.adp.lib.g.e.in().postDelayed(DistributeVideoView.this.gvy, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fQb = DistributeVideoView.this.bvp.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bvp.getDuration() - DistributeVideoView.this.bvp.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPV.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPS == 1) {
                            if (DistributeVideoView.this.fQb == DistributeVideoView.this.bvp.getCurrentPosition()) {
                                DistributeVideoView.this.cXy.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fQb = DistributeVideoView.this.bvp.getCurrentPosition();
                                DistributeVideoView.this.cXy.setVisibility(8);
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
        this.bjH = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gvv = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gvi != null) {
                        if (DistributeVideoView.this.gvw && "DETAIL".equals(DistributeVideoView.this.gvi.adi)) {
                            i2 = 35;
                        } else {
                            i2 = 31;
                        }
                        DistributeVideoView.this.W(i2, DistributeVideoView.this.su(DistributeVideoView.this.gvx), 0);
                    }
                    DistributeVideoView.this.cyE = gVar;
                    DistributeVideoView.this.cyE.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bdd = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bos();
                DistributeVideoView.this.W(36, DistributeVideoView.this.su(DistributeVideoView.this.gvx), gVar.getCurrentPosition());
                DistributeVideoView.this.efN.setForegroundDrawable(0);
                DistributeVideoView.this.gru.setVisibility(8);
                DistributeVideoView.this.fPZ.setVisibility(0);
                return true;
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gvr = System.currentTimeMillis();
                DistributeVideoView.this.gvw = true;
                DistributeVideoView.this.W(34, DistributeVideoView.this.su(DistributeVideoView.this.gvx), gVar.getDuration());
                DistributeVideoView.this.bos();
                if (DistributeVideoView.this.grO != null) {
                    DistributeVideoView.this.grO.bom();
                    DistributeVideoView.this.fPV.setVisibility(8);
                    DistributeVideoView.this.gru.setVisibility(8);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fQh = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPR != null && DistributeVideoView.this.bvp != null) {
                    DistributeVideoView.this.st(1);
                }
            }
        };
        this.gvy = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bou();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.eQl = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gvs = adCard;
        if (this.gvs != null) {
            this.parallelChargeInfo = this.gvs.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.bvp = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gru = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.efN = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.cXy = this.mRootView.findViewById(d.g.distribute_loading);
            this.fPV = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.fPZ = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gvm = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gvk = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gvn = this.mRootView.findViewById(d.g.distribute_control);
            this.gvo = (ImageView) this.gvn.findViewById(d.g.distribute_play_icon);
            this.gvl = (ImageView) this.gvn.findViewById(d.g.distribute_voice);
            this.gvp = (VideoControllerView) this.gvn.findViewById(d.g.distribute_process);
            this.grM = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.grN = new com.baidu.tieba.recapp.e.d(context, this.grM);
        }
    }

    private boolean bgH() {
        return this.mStyle == 1 ? q.bgH() : j.jF();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bov();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gov = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gow = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPR = videoInfo;
        this.mDuration = this.fPR.video_duration.intValue() * 1000;
        this.aaH = new WeakReference<>(this.mContext.getApplicationContext());
        bos();
        am.j(this, d.C0140d.cp_bg_line_d);
        int ah = l.ah(this.mContext) - l.f(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            ah = l.ah(this.mContext);
        }
        int intValue = this.fPR.video_width.intValue() > 0 ? (this.fPR.video_height.intValue() * ah) / this.fPR.video_width.intValue() : ah;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ah;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        am.i(this.gru, d.f.btn_icon_play_video_n);
        this.gru.setVisibility(8);
        this.efN.setDefaultErrorResource(0);
        this.efN.setDefaultResource(0);
        this.efN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.efN.setForegroundDrawable(d.f.icon_play_video_ad);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.efN.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bvp.setOnPreparedListener(this.bjH);
        this.bvp.setOnErrorListener(this.bdd);
        this.bvp.setOnCompletionListener(this.bjG);
        this.bvp.setOnSurfaceDestroyedListener(this.bdh);
        am.h(this.fPV, d.C0140d.cp_cont_i);
        am.i(this.fPV, d.f.video_play_count_bg);
        this.fPV.setText(StringUtils.translateSecondsToString(this.fPR.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gvq = false;
            am.c(this.gvk, d.f.ad_icon_sound_close);
        } else {
            this.gvq = true;
            am.c(this.gvl, d.f.ad_icon_sound_open);
            this.gvk.setVisibility(8);
        }
        this.gvl.setOnClickListener(this.mOnClickListener);
        this.gvk.setOnClickListener(this.mOnClickListener);
        this.fPZ.setOnClickListener(this.mOnClickListener);
        this.fPZ.setVisibility(8);
        am.j(this.fPZ, d.C0140d.black_alpha80);
        am.h(this.gvm, d.C0140d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fPV.setVisibility(0);
            return;
        }
        this.fPV.setVisibility(8);
        this.gvo.setOnClickListener(this.mOnClickListener);
        this.gru.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPR = videoInfo;
        this.aaH = new WeakReference<>(this.mContext.getApplicationContext());
        bos();
        am.j(this, d.C0140d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ah(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        am.i(this.gru, d.f.btn_icon_play_video_n);
        this.gru.setVisibility(8);
        this.efN.setDefaultErrorResource(0);
        this.efN.setDefaultResource(0);
        this.efN.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.efN.setForegroundDrawable(d.f.icon_play_video_ad);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.efN.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bvp.setOnPreparedListener(this.bjH);
        this.bvp.setOnErrorListener(this.bdd);
        this.bvp.setOnCompletionListener(this.bjG);
        this.bvp.setOnSurfaceDestroyedListener(this.bdh);
        am.h(this.fPV, d.C0140d.cp_cont_i);
        this.fPV.setText(StringUtils.translateSecondsToString(this.fPR.video_duration.intValue()));
        am.i(this.fPV, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gvq = false;
            am.c(this.gvk, d.f.ad_icon_sound_close);
        } else {
            this.gvq = true;
            am.c(this.gvl, d.f.ad_icon_sound_open);
            this.gvk.setVisibility(8);
        }
        this.gvl.setOnClickListener(this.mOnClickListener);
        this.gvk.setOnClickListener(this.mOnClickListener);
        this.fPZ.setOnClickListener(this.mOnClickListener);
        this.fPZ.setVisibility(8);
        am.j(this.fPZ, d.C0140d.black_alpha80);
        am.h(this.gvm, d.C0140d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fPV.setVisibility(0);
            return;
        }
        this.fPV.setVisibility(8);
        this.gvo.setOnClickListener(this.mOnClickListener);
        this.gru.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.grO = this.grN.a(this.gow, this.grO);
        if (this.grO != null) {
            this.grO.setPageContext(this.mPageContext);
            this.grO.c(this.gvs);
            this.grO.setAdvertAppInfo(advertAppInfo);
            this.grO.a(this.gow);
            this.grO.bon();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.grO != null) {
            this.grO.setDownloadAppCallback(cVar);
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
        this.bjG = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void st(int i) {
        this.gvx = i;
        if (this.fPR != null && this.fPS == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gvr) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.grO != null) {
                    this.grO.bon();
                }
                this.bvp.setVideoPath(this.fPR.video_url);
                this.bvp.start();
                this.gvv = this.bvp.getCurrentPosition();
                this.gru.setVisibility(8);
                am.c(this.gvo, d.f.icon_video_midplay);
                this.cXy.setVisibility(0);
                this.fPZ.setVisibility(8);
                this.efN.setForegroundDrawable(0);
                this.fPS = 0;
                if (this.mStyle == 1) {
                    this.fPV.setVisibility(0);
                } else {
                    this.fPV.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        st(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bgH()) {
            if (i <= 0) {
                st(1);
                return;
            }
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fQh);
            com.baidu.adp.lib.g.e.in().postDelayed(this.fQh, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fPS == 1) {
            v(32, su(this.gvx), this.bvp.getCurrentPosition(), i);
            this.bvp.pause();
            y.a(this.aaH, false);
            this.gru.setVisibility(0);
            am.c(this.gvo, d.f.icon_video_midpause);
            this.fPS = 2;
        }
    }

    public void autoContinue() {
        if (!this.gvu) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fPS == 2) {
            this.gvx = i;
            W(33, su(i), this.bvp.getCurrentPosition());
            this.gvv = this.bvp.getCurrentPosition();
            this.bvp.start();
            if (this.gvq) {
                y.a(this.aaH, true);
            }
            this.gru.setVisibility(8);
            am.c(this.gvo, d.f.icon_video_midplay);
            this.fPS = 1;
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
        if (this.bvp.getCurrentPosition() > 0 && this.fPS != -1 && z) {
            int i = 32;
            int currentPosition = this.bvp.getCurrentPosition();
            if (this.bvp.getDuration() == currentPosition) {
                i = 34;
            }
            d(i, su(this.gvx), currentPosition, this.bvp.isPlaying());
        }
        bos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.fQh);
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.gvy);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bvp.stopPlayback();
        this.fPS = -1;
        y.a(this.aaH, false);
        this.efN.setForegroundDrawable(0);
        this.efN.setVisibility(0);
        this.cXy.setVisibility(8);
        this.gru.setVisibility(0);
        am.c(this.gvo, d.f.icon_video_midpause);
        this.gvp.Rg();
        this.fPZ.setVisibility(8);
        if (this.fPR != null) {
            this.fPV.setText(StringUtils.translateSecondsToString(this.fPR.video_duration.intValue()));
        }
        this.cyE = null;
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
        return this.fPR != null ? this.fPR.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (z) {
            if (this.cyE != null) {
                this.cyE.setVolume(1.0f, 1.0f);
            }
            am.c(this.gvl, d.f.ad_icon_sound_open);
            am.c(this.gvk, d.f.ad_icon_sound_open);
            if (this.fPS == 1) {
                y.a(this.aaH, true);
            }
        } else {
            if (this.cyE != null) {
                this.cyE.setVolume(0.0f, 0.0f);
            }
            am.c(this.gvl, d.f.ad_icon_sound_close);
            am.c(this.gvk, d.f.ad_icon_sound_close);
            y.a(this.aaH, false);
        }
        this.gvq = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fPS;
    }

    public VideoInfo getData() {
        return this.fPR;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fQb;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gvh && this.gvg != null && this.gvg.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aj(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gvi = advertAppInfo;
        this.gvj = i;
        this.goA = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.adi = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gvi, 303, i, su(this.gvx), this.fPR.video_duration.intValue(), this.mDuration, -1);
        if (this.grO != null) {
            this.grO.e(a);
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
        if (this.gvi != null && this.fPR != null) {
            this.gvi.adi = this.goA;
            com.baidu.tieba.recapp.report.c.boi().a(f.a(this.gvi, i, this.gvj, i2, this.fPR.video_duration.intValue(), a.gB(i3), i4));
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
                if ("DETAIL".equals(this.goA)) {
                    str2 = "det";
                } else if ("FRS".equals(this.goA)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.goA)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gvv, i3, this.mDuration, str2, sv(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gov != null && "cpv".equals(this.gov.gpt) && !TextUtils.isEmpty(this.gov.gpu)) {
            new com.baidu.tieba.recapp.request.a(this.gov.gpu).a(str, i, i2, i3, str2, str3);
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
            this.gvg = view;
            this.gvh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.gvy);
            if (this.drf != null) {
                this.drf.cancel();
            }
            this.gvn.setVisibility(0);
            if (this.fPS == 1) {
                am.c(this.gvo, d.f.icon_video_midplay);
                return;
            } else {
                am.c(this.gvo, d.f.icon_video_midpause);
                return;
            }
        }
        this.gvn.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        switch (this.fPS) {
            case -1:
                if (!j.jE() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.j.neterror);
                    return;
                } else if (!j.jF() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cf(d.j.play_video_mobile_tip);
                    aVar.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            DistributeVideoView.this.performPlay();
                        }
                    });
                    aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(this.mPageContext).xf();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gvu = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lJ(true);
                    return;
                }
                return;
            case 2:
                this.gvu = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.in().removeCallbacks(this.gvy);
                    com.baidu.adp.lib.g.e.in().postDelayed(this.gvy, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        if (!this.gvt && this.drf != null) {
            this.gvn.startAnimation(this.drf);
            this.gvt = true;
        }
    }

    private void bov() {
        if (this.mPageContext != null) {
            this.drf = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.drf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gvn.setVisibility(8);
                    DistributeVideoView.this.gvt = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
