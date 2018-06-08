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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.ForeDrawableImageView;
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
import com.baidu.tieba.recapp.report.a;
import com.baidu.tieba.tbadkCore.q;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> aba;
    private g.b bhA;
    private g.a bhy;
    private g.f bhz;
    private QuickVideoView bti;
    private QuickVideoView.b bts;
    private g cxZ;
    private ForeDrawableImageView dYd;
    private Animation dlA;
    private String eIz;
    private VideoInfo fLE;
    private int fLF;
    private TextView fLI;
    private View fLM;
    private long fLO;
    private Runnable fLU;
    private AdCard.a gju;
    private AdCard.f gjv;
    private String gjz;
    private ViewGroup gmL;
    private d gmM;
    private e gmN;
    private ImageView gmt;
    private View gqb;
    private boolean gqc;
    private AdvertAppInfo gqd;
    private int gqe;
    private ImageView gqf;
    private ImageView gqg;
    private TextView gqh;
    private View gqi;
    private ImageView gqj;
    private VideoControllerView gqk;
    private boolean gql;
    private long gqm;
    private b gqn;
    boolean gqo;
    boolean gqp;
    private int gqq;
    boolean gqr;
    private int gqs;
    private Runnable gqt;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View mLoadingView;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;
    private b.a parallelChargeInfo;

    public DistributeVideoView(Context context) {
        super(context);
        this.gqc = false;
        this.aba = null;
        this.fLF = -1;
        this.fLO = 0L;
        this.gql = false;
        this.gqm = 0L;
        this.mStyle = 1;
        this.gqo = false;
        this.gqp = false;
        this.gqr = false;
        this.gqs = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fLM) {
                    DistributeVideoView.this.fLM.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gqg || view == DistributeVideoView.this.gqf) {
                    DistributeVideoView.this.lN(DistributeVideoView.this.gql ? false : true);
                } else if (view == DistributeVideoView.this.gmt || view == DistributeVideoView.this.gqj) {
                    DistributeVideoView.this.bpn();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gqd == null || !DistributeVideoView.this.gqd.tP()) {
                    DistributeVideoView.this.bpn();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gqd != null) {
                        WebVideoActivity.gjo = new WebVideoActivity.a();
                        WebVideoActivity.gjo.gjy = DistributeVideoView.this.gqd;
                        WebVideoActivity.gjo.gjz = "DETAIL";
                        WebVideoActivity.gjo.mPageNum = DistributeVideoView.this.gqe;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eIz) ? DistributeVideoView.this.eIz : DistributeVideoView.this.gqd.adO, true, true, true, DistributeVideoView.this.fLE.video_url, DistributeVideoView.this.fLE.thumbnail_url, DistributeVideoView.this.fLE.video_width.intValue() / DistributeVideoView.this.fLE.video_height.intValue(), DistributeVideoView.this.fLE.video_duration.intValue());
                    if (DistributeVideoView.this.gju != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gju.gks);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gju.gkt);
                    }
                    if (DistributeVideoView.this.gjv != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gjv.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.po(DistributeVideoView.this.parallelChargeInfo.eHS);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eHV.iterator();
                        while (it.hasNext()) {
                            c.po(it.next());
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
                        if (DistributeVideoView.this.fLF != 1) {
                            if (DistributeVideoView.this.bti.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fLF = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dYd.setVisibility(8);
                                DistributeVideoView.this.lN(DistributeVideoView.this.gql);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gqk.setPlayer(DistributeVideoView.this.bti);
                                    DistributeVideoView.this.gqk.R(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fLE.video_duration.intValue()));
                                    DistributeVideoView.this.gqk.showProgress();
                                    DistributeVideoView.this.lO(true);
                                    com.baidu.adp.lib.g.e.im().removeCallbacks(DistributeVideoView.this.gqt);
                                    com.baidu.adp.lib.g.e.im().postDelayed(DistributeVideoView.this.gqt, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fLO = DistributeVideoView.this.bti.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bti.getDuration() - DistributeVideoView.this.bti.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fLI.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fLF == 1) {
                            if (DistributeVideoView.this.fLO == DistributeVideoView.this.bti.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fLO = DistributeVideoView.this.bti.getCurrentPosition();
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
        this.bhz = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gqq = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gqd != null) {
                    if (DistributeVideoView.this.gqr && "DETAIL".equals(DistributeVideoView.this.gqd.adp)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), 0);
                    DistributeVideoView.this.cxZ = gVar;
                    DistributeVideoView.this.cxZ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpm();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), gVar.getCurrentPosition());
                DistributeVideoView.this.dYd.setForegroundDrawable(0);
                DistributeVideoView.this.gmt.setVisibility(8);
                DistributeVideoView.this.fLM.setVisibility(0);
                return true;
            }
        };
        this.bhy = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gqm = System.currentTimeMillis();
                DistributeVideoView.this.gqr = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), gVar.getDuration());
                DistributeVideoView.this.bpm();
                if (DistributeVideoView.this.gmN != null) {
                    DistributeVideoView.this.gmN.bpg();
                    DistributeVideoView.this.fLI.setVisibility(8);
                    DistributeVideoView.this.gmt.setVisibility(8);
                }
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fLU = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fLE != null && DistributeVideoView.this.bti != null) {
                    DistributeVideoView.this.sl(1);
                }
            }
        };
        this.gqt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpo();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gqc = false;
        this.aba = null;
        this.fLF = -1;
        this.fLO = 0L;
        this.gql = false;
        this.gqm = 0L;
        this.mStyle = 1;
        this.gqo = false;
        this.gqp = false;
        this.gqr = false;
        this.gqs = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fLM) {
                    DistributeVideoView.this.fLM.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gqg || view == DistributeVideoView.this.gqf) {
                    DistributeVideoView.this.lN(DistributeVideoView.this.gql ? false : true);
                } else if (view == DistributeVideoView.this.gmt || view == DistributeVideoView.this.gqj) {
                    DistributeVideoView.this.bpn();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gqd == null || !DistributeVideoView.this.gqd.tP()) {
                    DistributeVideoView.this.bpn();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gqd != null) {
                        WebVideoActivity.gjo = new WebVideoActivity.a();
                        WebVideoActivity.gjo.gjy = DistributeVideoView.this.gqd;
                        WebVideoActivity.gjo.gjz = "DETAIL";
                        WebVideoActivity.gjo.mPageNum = DistributeVideoView.this.gqe;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eIz) ? DistributeVideoView.this.eIz : DistributeVideoView.this.gqd.adO, true, true, true, DistributeVideoView.this.fLE.video_url, DistributeVideoView.this.fLE.thumbnail_url, DistributeVideoView.this.fLE.video_width.intValue() / DistributeVideoView.this.fLE.video_height.intValue(), DistributeVideoView.this.fLE.video_duration.intValue());
                    if (DistributeVideoView.this.gju != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gju.gks);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gju.gkt);
                    }
                    if (DistributeVideoView.this.gjv != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gjv.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.po(DistributeVideoView.this.parallelChargeInfo.eHS);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eHV.iterator();
                        while (it.hasNext()) {
                            c.po(it.next());
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
                        if (DistributeVideoView.this.fLF != 1) {
                            if (DistributeVideoView.this.bti.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fLF = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dYd.setVisibility(8);
                                DistributeVideoView.this.lN(DistributeVideoView.this.gql);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gqk.setPlayer(DistributeVideoView.this.bti);
                                    DistributeVideoView.this.gqk.R(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fLE.video_duration.intValue()));
                                    DistributeVideoView.this.gqk.showProgress();
                                    DistributeVideoView.this.lO(true);
                                    com.baidu.adp.lib.g.e.im().removeCallbacks(DistributeVideoView.this.gqt);
                                    com.baidu.adp.lib.g.e.im().postDelayed(DistributeVideoView.this.gqt, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fLO = DistributeVideoView.this.bti.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bti.getDuration() - DistributeVideoView.this.bti.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fLI.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fLF == 1) {
                            if (DistributeVideoView.this.fLO == DistributeVideoView.this.bti.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fLO = DistributeVideoView.this.bti.getCurrentPosition();
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
        this.bhz = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gqq = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gqd != null) {
                    if (DistributeVideoView.this.gqr && "DETAIL".equals(DistributeVideoView.this.gqd.adp)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), 0);
                    DistributeVideoView.this.cxZ = gVar;
                    DistributeVideoView.this.cxZ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpm();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), gVar.getCurrentPosition());
                DistributeVideoView.this.dYd.setForegroundDrawable(0);
                DistributeVideoView.this.gmt.setVisibility(8);
                DistributeVideoView.this.fLM.setVisibility(0);
                return true;
            }
        };
        this.bhy = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gqm = System.currentTimeMillis();
                DistributeVideoView.this.gqr = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), gVar.getDuration());
                DistributeVideoView.this.bpm();
                if (DistributeVideoView.this.gmN != null) {
                    DistributeVideoView.this.gmN.bpg();
                    DistributeVideoView.this.fLI.setVisibility(8);
                    DistributeVideoView.this.gmt.setVisibility(8);
                }
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fLU = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fLE != null && DistributeVideoView.this.bti != null) {
                    DistributeVideoView.this.sl(1);
                }
            }
        };
        this.gqt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpo();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gqc = false;
        this.aba = null;
        this.fLF = -1;
        this.fLO = 0L;
        this.gql = false;
        this.gqm = 0L;
        this.mStyle = 1;
        this.gqo = false;
        this.gqp = false;
        this.gqr = false;
        this.gqs = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fLM) {
                    DistributeVideoView.this.fLM.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gqg || view == DistributeVideoView.this.gqf) {
                    DistributeVideoView.this.lN(DistributeVideoView.this.gql ? false : true);
                } else if (view == DistributeVideoView.this.gmt || view == DistributeVideoView.this.gqj) {
                    DistributeVideoView.this.bpn();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gqd == null || !DistributeVideoView.this.gqd.tP()) {
                    DistributeVideoView.this.bpn();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gqd != null) {
                        WebVideoActivity.gjo = new WebVideoActivity.a();
                        WebVideoActivity.gjo.gjy = DistributeVideoView.this.gqd;
                        WebVideoActivity.gjo.gjz = "DETAIL";
                        WebVideoActivity.gjo.mPageNum = DistributeVideoView.this.gqe;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eIz) ? DistributeVideoView.this.eIz : DistributeVideoView.this.gqd.adO, true, true, true, DistributeVideoView.this.fLE.video_url, DistributeVideoView.this.fLE.thumbnail_url, DistributeVideoView.this.fLE.video_width.intValue() / DistributeVideoView.this.fLE.video_height.intValue(), DistributeVideoView.this.fLE.video_duration.intValue());
                    if (DistributeVideoView.this.gju != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gju.gks);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gju.gkt);
                    }
                    if (DistributeVideoView.this.gjv != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gjv.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.po(DistributeVideoView.this.parallelChargeInfo.eHS);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eHV.iterator();
                        while (it.hasNext()) {
                            c.po(it.next());
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
                        if (DistributeVideoView.this.fLF != 1) {
                            if (DistributeVideoView.this.bti.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fLF = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dYd.setVisibility(8);
                                DistributeVideoView.this.lN(DistributeVideoView.this.gql);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gqk.setPlayer(DistributeVideoView.this.bti);
                                    DistributeVideoView.this.gqk.R(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fLE.video_duration.intValue()));
                                    DistributeVideoView.this.gqk.showProgress();
                                    DistributeVideoView.this.lO(true);
                                    com.baidu.adp.lib.g.e.im().removeCallbacks(DistributeVideoView.this.gqt);
                                    com.baidu.adp.lib.g.e.im().postDelayed(DistributeVideoView.this.gqt, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fLO = DistributeVideoView.this.bti.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bti.getDuration() - DistributeVideoView.this.bti.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fLI.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fLF == 1) {
                            if (DistributeVideoView.this.fLO == DistributeVideoView.this.bti.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fLO = DistributeVideoView.this.bti.getCurrentPosition();
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
        this.bhz = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gqq = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gqd != null) {
                    if (DistributeVideoView.this.gqr && "DETAIL".equals(DistributeVideoView.this.gqd.adp)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.X(i2, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), 0);
                    DistributeVideoView.this.cxZ = gVar;
                    DistributeVideoView.this.cxZ.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bhA = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bpm();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), gVar.getCurrentPosition());
                DistributeVideoView.this.dYd.setForegroundDrawable(0);
                DistributeVideoView.this.gmt.setVisibility(8);
                DistributeVideoView.this.fLM.setVisibility(0);
                return true;
            }
        };
        this.bhy = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gqm = System.currentTimeMillis();
                DistributeVideoView.this.gqr = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sm(DistributeVideoView.this.gqs), gVar.getDuration());
                DistributeVideoView.this.bpm();
                if (DistributeVideoView.this.gmN != null) {
                    DistributeVideoView.this.gmN.bpg();
                    DistributeVideoView.this.fLI.setVisibility(8);
                    DistributeVideoView.this.gmt.setVisibility(8);
                }
            }
        };
        this.bts = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fLU = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fLE != null && DistributeVideoView.this.bti != null) {
                    DistributeVideoView.this.sl(1);
                }
            }
        };
        this.gqt = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpo();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.eIz = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gqn = adCard;
        if (this.gqn != null) {
            this.parallelChargeInfo = this.gqn.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.i.distribute_video_view, (ViewGroup) this, true);
            this.bti = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gmt = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.dYd = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(d.g.distribute_loading);
            this.fLI = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.fLM = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gqh = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gqf = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gqi = this.mRootView.findViewById(d.g.distribute_control);
            this.gqj = (ImageView) this.gqi.findViewById(d.g.distribute_play_icon);
            this.gqg = (ImageView) this.gqi.findViewById(d.g.distribute_voice);
            this.gqk = (VideoControllerView) this.gqi.findViewById(d.g.distribute_process);
            this.gmL = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gmM = new com.baidu.tieba.recapp.e.d(context, this.gmL);
        }
    }

    private boolean bhI() {
        return this.mStyle == 1 ? q.bhI() : j.jE();
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
        this.gju = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gjv = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fLE = videoInfo;
        this.mDuration = this.fLE.video_duration.intValue() * 1000;
        this.aba = new WeakReference<>(this.mContext.getApplicationContext());
        bpm();
        al.j(this, d.C0141d.cp_bg_line_d);
        int ah = l.ah(this.mContext) - l.e(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            ah = l.ah(this.mContext);
        }
        int intValue = this.fLE.video_width.intValue() > 0 ? (this.fLE.video_height.intValue() * ah) / this.fLE.video_width.intValue() : ah;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ah;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gmt, d.f.icon_play_video);
        this.gmt.setVisibility(8);
        this.dYd.setDefaultErrorResource(0);
        this.dYd.setDefaultResource(0);
        this.dYd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dYd.setForegroundDrawable(d.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.dYd.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bti.setOnPreparedListener(this.bhz);
        this.bti.setOnErrorListener(this.bhA);
        this.bti.setOnCompletionListener(this.bhy);
        this.bti.setOnSurfaceDestroyedListener(this.bts);
        al.h(this.fLI, d.C0141d.cp_cont_i);
        al.i(this.fLI, d.f.video_play_count_bg);
        this.fLI.setText(StringUtils.translateSecondsToString(this.fLE.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gql = false;
            al.c(this.gqf, d.f.ad_icon_sound_close);
        } else {
            this.gql = true;
            al.c(this.gqg, d.f.ad_icon_sound_open);
            this.gqf.setVisibility(8);
        }
        this.gqg.setOnClickListener(this.mOnClickListener);
        this.gqf.setOnClickListener(this.mOnClickListener);
        this.fLM.setOnClickListener(this.mOnClickListener);
        this.fLM.setVisibility(8);
        al.j(this.fLM, d.C0141d.black_alpha80);
        al.h(this.gqh, d.C0141d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fLI.setVisibility(0);
            return;
        }
        this.fLI.setVisibility(8);
        this.gqj.setOnClickListener(this.mOnClickListener);
        this.gmt.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fLE = videoInfo;
        this.aba = new WeakReference<>(this.mContext.getApplicationContext());
        bpm();
        al.j(this, d.C0141d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ah(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gmt, d.f.btn_icon_play_video_n);
        this.gmt.setVisibility(8);
        this.dYd.setDefaultErrorResource(0);
        this.dYd.setDefaultResource(0);
        this.dYd.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dYd.setForegroundDrawable(d.f.icon_play_video);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.dYd.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bti.setOnPreparedListener(this.bhz);
        this.bti.setOnErrorListener(this.bhA);
        this.bti.setOnCompletionListener(this.bhy);
        this.bti.setOnSurfaceDestroyedListener(this.bts);
        al.h(this.fLI, d.C0141d.cp_cont_i);
        this.fLI.setText(StringUtils.translateSecondsToString(this.fLE.video_duration.intValue()));
        al.i(this.fLI, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gql = false;
            al.c(this.gqf, d.f.ad_icon_sound_close);
        } else {
            this.gql = true;
            al.c(this.gqg, d.f.ad_icon_sound_open);
            this.gqf.setVisibility(8);
        }
        this.gqg.setOnClickListener(this.mOnClickListener);
        this.gqf.setOnClickListener(this.mOnClickListener);
        this.fLM.setOnClickListener(this.mOnClickListener);
        this.fLM.setVisibility(8);
        al.j(this.fLM, d.C0141d.black_alpha80);
        al.h(this.gqh, d.C0141d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fLI.setVisibility(0);
            return;
        }
        this.fLI.setVisibility(8);
        this.gqj.setOnClickListener(this.mOnClickListener);
        this.gmt.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gmN = this.gmM.a(this.gjv, this.gmN);
        if (this.gmN != null) {
            this.gmN.setPageContext(this.mPageContext);
            this.gmN.c(this.gqn);
            this.gmN.setAdvertAppInfo(advertAppInfo);
            this.gmN.a(this.gjv);
            this.gmN.bph();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gmN != null) {
            this.gmN.setDownloadAppCallback(cVar);
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
        this.bhy = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl(int i) {
        if (this.gmN != null) {
            this.gmN.bph();
        }
        this.gqs = i;
        if (this.fLE != null && this.fLF == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gqm) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.bti.setVideoPath(this.fLE.video_url);
                this.bti.start();
                this.gqq = this.bti.getCurrentPosition();
                this.gmt.setVisibility(8);
                al.c(this.gqj, d.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.fLM.setVisibility(8);
                this.dYd.setForegroundDrawable(0);
                this.fLF = 0;
            }
        }
    }

    public void performPlay() {
        sl(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bhI()) {
            if (i <= 0) {
                sl(1);
                return;
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fLU);
            com.baidu.adp.lib.g.e.im().postDelayed(this.fLU, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fLF == 1) {
            y(32, sm(this.gqs), this.bti.getCurrentPosition(), i);
            this.bti.pause();
            z.a(this.aba, false);
            this.gmt.setVisibility(0);
            al.c(this.gqj, d.f.icon_video_midpause);
            this.fLF = 2;
        }
    }

    public void autoContinue() {
        if (!this.gqp) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fLF == 2) {
            this.gqs = i;
            X(33, sm(i), this.bti.getCurrentPosition());
            this.gqq = this.bti.getCurrentPosition();
            this.bti.start();
            if (this.gql) {
                z.a(this.aba, true);
            }
            this.gmt.setVisibility(8);
            al.c(this.gqj, d.f.icon_video_midplay);
            this.fLF = 1;
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
        if (this.bti.getCurrentPosition() > 0 && this.fLF != -1) {
            int i = 32;
            if (this.bti.getDuration() == this.bti.getCurrentPosition()) {
                i = 34;
            }
            e(i, sm(this.gqs), this.bti.getCurrentPosition(), this.bti.isPlaying());
        }
        bpm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpm() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fLU);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gqt);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bti.stopPlayback();
        this.fLF = -1;
        z.a(this.aba, false);
        this.dYd.setForegroundDrawable(0);
        this.dYd.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gmt.setVisibility(0);
        al.c(this.gqj, d.f.icon_video_midpause);
        this.gqk.QC();
        this.fLM.setVisibility(8);
        if (this.fLE != null) {
            this.fLI.setText(StringUtils.translateSecondsToString(this.fLE.video_duration.intValue()));
        }
        this.cxZ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sm(int i) {
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
        return this.fLE != null ? this.fLE.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lN(boolean z) {
        if (z) {
            if (this.cxZ != null) {
                this.cxZ.setVolume(1.0f, 1.0f);
            }
            al.c(this.gqg, d.f.ad_icon_sound_open);
            al.c(this.gqf, d.f.ad_icon_sound_open);
            if (this.fLF == 1) {
                z.a(this.aba, true);
            }
        } else {
            if (this.cxZ != null) {
                this.cxZ.setVolume(0.0f, 0.0f);
            }
            al.c(this.gqg, d.f.ad_icon_sound_close);
            al.c(this.gqf, d.f.ad_icon_sound_close);
            z.a(this.aba, false);
        }
        this.gql = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fLF;
    }

    public VideoInfo getData() {
        return this.fLE;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fLO;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gqc && this.gqb != null && this.gqb.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aj(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gqd = advertAppInfo;
        this.gqe = i;
        this.gjz = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.adp = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gqd, 303, i, sm(this.gqs), this.fLE.video_duration.intValue(), this.mDuration, -1);
        if (this.gmN != null) {
            this.gmN.e(a);
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
        if (this.gqd != null && this.fLE != null) {
            this.gqd.adp = this.gjz;
            com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(this.gqd, i, this.gqe, i2, this.fLE.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.gjz)) {
                    str2 = "det";
                } else if ("FRS".equals(this.gjz)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.gjz)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gqq, i3, this.mDuration, str2, sn(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gju != null && "cpv".equals(this.gju.gks) && !TextUtils.isEmpty(this.gju.gkt)) {
            new com.baidu.tieba.recapp.request.a(this.gju.gkt).a(str, i, i2, i3, str2, str3);
        }
    }

    private String sn(int i) {
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
            this.gqb = view;
            this.gqc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gqt);
            if (this.dlA != null) {
                this.dlA.cancel();
            }
            this.gqi.setVisibility(0);
            if (this.fLF == 1) {
                al.c(this.gqj, d.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gqj, d.f.icon_video_midpause);
                return;
            }
        }
        this.gqi.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpn() {
        switch (this.fLF) {
            case -1:
                if (!j.jD() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.k.neterror);
                    return;
                } else if (!j.jE() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cc(d.k.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).xa();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gqp = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lO(true);
                    return;
                }
                return;
            case 2:
                this.gqp = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.im().removeCallbacks(this.gqt);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.gqt, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpo() {
        if (!this.gqo && this.dlA != null) {
            this.gqi.startAnimation(this.dlA);
            this.gqo = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.dlA = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dlA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gqi.setVisibility(8);
                    DistributeVideoView.this.gqo = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
