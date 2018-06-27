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
    private WeakReference<Context> abe;
    private g.b bcU;
    private QuickVideoView.b bcY;
    private g.a bjb;
    private g.f bjc;
    private QuickVideoView buJ;
    private g cwc;
    private Animation dom;
    private String eMq;
    private ForeDrawableImageView ebX;
    private VideoInfo fPH;
    private int fPI;
    private TextView fPL;
    private View fPP;
    private long fPR;
    private Runnable fPX;
    private AdCard.a gnl;
    private AdCard.f gnm;
    private String gnq;
    private ViewGroup gqC;
    private d gqD;
    private e gqE;
    private ImageView gqk;
    private View gtT;
    private boolean gtU;
    private AdvertAppInfo gtV;
    private int gtW;
    private ImageView gtX;
    private ImageView gtY;
    private TextView gtZ;
    private View gua;
    private ImageView gub;
    private VideoControllerView guc;
    private boolean gud;
    private long gue;
    private b guf;
    boolean gug;
    boolean guh;
    private int gui;
    boolean guj;
    private int guk;
    private Runnable gul;
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
        this.gtU = false;
        this.abe = null;
        this.fPI = -1;
        this.fPR = 0L;
        this.gud = false;
        this.gue = 0L;
        this.mStyle = 1;
        this.gug = false;
        this.guh = false;
        this.guj = false;
        this.guk = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPP) {
                    DistributeVideoView.this.fPP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gtY || view == DistributeVideoView.this.gtX) {
                    DistributeVideoView.this.lX(DistributeVideoView.this.gud ? false : true);
                } else if (view == DistributeVideoView.this.gqk || view == DistributeVideoView.this.gub) {
                    DistributeVideoView.this.bpO();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gtV == null || !DistributeVideoView.this.gtV.tV()) {
                    DistributeVideoView.this.bpO();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gtV != null) {
                        WebVideoActivity.gnf = new WebVideoActivity.a();
                        WebVideoActivity.gnf.gnp = DistributeVideoView.this.gtV;
                        WebVideoActivity.gnf.gnq = "DETAIL";
                        WebVideoActivity.gnf.mPageNum = DistributeVideoView.this.gtW;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eMq) ? DistributeVideoView.this.eMq : DistributeVideoView.this.gtV.aed, true, true, true, DistributeVideoView.this.fPH.video_url, DistributeVideoView.this.fPH.thumbnail_url, DistributeVideoView.this.fPH.video_width.intValue() / DistributeVideoView.this.fPH.video_height.intValue(), DistributeVideoView.this.fPH.video_duration.intValue());
                    if (DistributeVideoView.this.gnl != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gnl.goj);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gnl.gok);
                    }
                    if (DistributeVideoView.this.gnm != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gnm.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pp(DistributeVideoView.this.parallelChargeInfo.eLJ);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eLM.iterator();
                        while (it.hasNext()) {
                            c.pp(it.next());
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
                        if (DistributeVideoView.this.fPI != 1) {
                            if (DistributeVideoView.this.buJ.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPI = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.ebX.setVisibility(8);
                                DistributeVideoView.this.lX(DistributeVideoView.this.gud);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.guc.setPlayer(DistributeVideoView.this.buJ);
                                    DistributeVideoView.this.guc.R(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPH.video_duration.intValue()));
                                    DistributeVideoView.this.guc.showProgress();
                                    DistributeVideoView.this.lY(true);
                                    com.baidu.adp.lib.g.e.im().removeCallbacks(DistributeVideoView.this.gul);
                                    com.baidu.adp.lib.g.e.im().postDelayed(DistributeVideoView.this.gul, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fPR = DistributeVideoView.this.buJ.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.buJ.getDuration() - DistributeVideoView.this.buJ.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPI == 1) {
                            if (DistributeVideoView.this.fPR == DistributeVideoView.this.buJ.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fPR = DistributeVideoView.this.buJ.getCurrentPosition();
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
        this.bjc = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gui = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gtV != null) {
                        if (DistributeVideoView.this.guj && "DETAIL".equals(DistributeVideoView.this.gtV.adE)) {
                            i = 35;
                        } else {
                            i = 31;
                        }
                        DistributeVideoView.this.X(i, DistributeVideoView.this.sw(DistributeVideoView.this.guk), 0);
                    }
                    DistributeVideoView.this.cwc = gVar;
                    DistributeVideoView.this.cwc.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpN();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sw(DistributeVideoView.this.guk), gVar.getCurrentPosition());
                DistributeVideoView.this.ebX.setForegroundDrawable(0);
                DistributeVideoView.this.gqk.setVisibility(8);
                DistributeVideoView.this.fPP.setVisibility(0);
                return true;
            }
        };
        this.bjb = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gue = System.currentTimeMillis();
                DistributeVideoView.this.guj = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sw(DistributeVideoView.this.guk), gVar.getDuration());
                DistributeVideoView.this.bpN();
                if (DistributeVideoView.this.gqE != null) {
                    DistributeVideoView.this.gqE.bpH();
                    DistributeVideoView.this.fPL.setVisibility(8);
                    DistributeVideoView.this.gqk.setVisibility(8);
                }
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fPX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPH != null && DistributeVideoView.this.buJ != null) {
                    DistributeVideoView.this.sv(1);
                }
            }
        };
        this.gul = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpP();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtU = false;
        this.abe = null;
        this.fPI = -1;
        this.fPR = 0L;
        this.gud = false;
        this.gue = 0L;
        this.mStyle = 1;
        this.gug = false;
        this.guh = false;
        this.guj = false;
        this.guk = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPP) {
                    DistributeVideoView.this.fPP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gtY || view == DistributeVideoView.this.gtX) {
                    DistributeVideoView.this.lX(DistributeVideoView.this.gud ? false : true);
                } else if (view == DistributeVideoView.this.gqk || view == DistributeVideoView.this.gub) {
                    DistributeVideoView.this.bpO();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gtV == null || !DistributeVideoView.this.gtV.tV()) {
                    DistributeVideoView.this.bpO();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gtV != null) {
                        WebVideoActivity.gnf = new WebVideoActivity.a();
                        WebVideoActivity.gnf.gnp = DistributeVideoView.this.gtV;
                        WebVideoActivity.gnf.gnq = "DETAIL";
                        WebVideoActivity.gnf.mPageNum = DistributeVideoView.this.gtW;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eMq) ? DistributeVideoView.this.eMq : DistributeVideoView.this.gtV.aed, true, true, true, DistributeVideoView.this.fPH.video_url, DistributeVideoView.this.fPH.thumbnail_url, DistributeVideoView.this.fPH.video_width.intValue() / DistributeVideoView.this.fPH.video_height.intValue(), DistributeVideoView.this.fPH.video_duration.intValue());
                    if (DistributeVideoView.this.gnl != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gnl.goj);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gnl.gok);
                    }
                    if (DistributeVideoView.this.gnm != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gnm.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pp(DistributeVideoView.this.parallelChargeInfo.eLJ);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eLM.iterator();
                        while (it.hasNext()) {
                            c.pp(it.next());
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
                        if (DistributeVideoView.this.fPI != 1) {
                            if (DistributeVideoView.this.buJ.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPI = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.ebX.setVisibility(8);
                                DistributeVideoView.this.lX(DistributeVideoView.this.gud);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.guc.setPlayer(DistributeVideoView.this.buJ);
                                    DistributeVideoView.this.guc.R(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPH.video_duration.intValue()));
                                    DistributeVideoView.this.guc.showProgress();
                                    DistributeVideoView.this.lY(true);
                                    com.baidu.adp.lib.g.e.im().removeCallbacks(DistributeVideoView.this.gul);
                                    com.baidu.adp.lib.g.e.im().postDelayed(DistributeVideoView.this.gul, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fPR = DistributeVideoView.this.buJ.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.buJ.getDuration() - DistributeVideoView.this.buJ.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPI == 1) {
                            if (DistributeVideoView.this.fPR == DistributeVideoView.this.buJ.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fPR = DistributeVideoView.this.buJ.getCurrentPosition();
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
        this.bjc = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gui = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gtV != null) {
                        if (DistributeVideoView.this.guj && "DETAIL".equals(DistributeVideoView.this.gtV.adE)) {
                            i = 35;
                        } else {
                            i = 31;
                        }
                        DistributeVideoView.this.X(i, DistributeVideoView.this.sw(DistributeVideoView.this.guk), 0);
                    }
                    DistributeVideoView.this.cwc = gVar;
                    DistributeVideoView.this.cwc.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpN();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sw(DistributeVideoView.this.guk), gVar.getCurrentPosition());
                DistributeVideoView.this.ebX.setForegroundDrawable(0);
                DistributeVideoView.this.gqk.setVisibility(8);
                DistributeVideoView.this.fPP.setVisibility(0);
                return true;
            }
        };
        this.bjb = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gue = System.currentTimeMillis();
                DistributeVideoView.this.guj = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sw(DistributeVideoView.this.guk), gVar.getDuration());
                DistributeVideoView.this.bpN();
                if (DistributeVideoView.this.gqE != null) {
                    DistributeVideoView.this.gqE.bpH();
                    DistributeVideoView.this.fPL.setVisibility(8);
                    DistributeVideoView.this.gqk.setVisibility(8);
                }
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fPX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPH != null && DistributeVideoView.this.buJ != null) {
                    DistributeVideoView.this.sv(1);
                }
            }
        };
        this.gul = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpP();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtU = false;
        this.abe = null;
        this.fPI = -1;
        this.fPR = 0L;
        this.gud = false;
        this.gue = 0L;
        this.mStyle = 1;
        this.gug = false;
        this.guh = false;
        this.guj = false;
        this.guk = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.fPP) {
                    DistributeVideoView.this.fPP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gtY || view == DistributeVideoView.this.gtX) {
                    DistributeVideoView.this.lX(DistributeVideoView.this.gud ? false : true);
                } else if (view == DistributeVideoView.this.gqk || view == DistributeVideoView.this.gub) {
                    DistributeVideoView.this.bpO();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gtV == null || !DistributeVideoView.this.gtV.tV()) {
                    DistributeVideoView.this.bpO();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.gtV != null) {
                        WebVideoActivity.gnf = new WebVideoActivity.a();
                        WebVideoActivity.gnf.gnp = DistributeVideoView.this.gtV;
                        WebVideoActivity.gnf.gnq = "DETAIL";
                        WebVideoActivity.gnf.mPageNum = DistributeVideoView.this.gtW;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.eMq) ? DistributeVideoView.this.eMq : DistributeVideoView.this.gtV.aed, true, true, true, DistributeVideoView.this.fPH.video_url, DistributeVideoView.this.fPH.thumbnail_url, DistributeVideoView.this.fPH.video_width.intValue() / DistributeVideoView.this.fPH.video_height.intValue(), DistributeVideoView.this.fPH.video_duration.intValue());
                    if (DistributeVideoView.this.gnl != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gnl.goj);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gnl.gok);
                    }
                    if (DistributeVideoView.this.gnm != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gnm.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.pp(DistributeVideoView.this.parallelChargeInfo.eLJ);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.eLM.iterator();
                        while (it.hasNext()) {
                            c.pp(it.next());
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
                        if (DistributeVideoView.this.fPI != 1) {
                            if (DistributeVideoView.this.buJ.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fPI = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.ebX.setVisibility(8);
                                DistributeVideoView.this.lX(DistributeVideoView.this.gud);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.guc.setPlayer(DistributeVideoView.this.buJ);
                                    DistributeVideoView.this.guc.R(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fPH.video_duration.intValue()));
                                    DistributeVideoView.this.guc.showProgress();
                                    DistributeVideoView.this.lY(true);
                                    com.baidu.adp.lib.g.e.im().removeCallbacks(DistributeVideoView.this.gul);
                                    com.baidu.adp.lib.g.e.im().postDelayed(DistributeVideoView.this.gul, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fPR = DistributeVideoView.this.buJ.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.buJ.getDuration() - DistributeVideoView.this.buJ.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fPL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fPI == 1) {
                            if (DistributeVideoView.this.fPR == DistributeVideoView.this.buJ.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fPR = DistributeVideoView.this.buJ.getCurrentPosition();
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
        this.bjc = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gui = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null) {
                    if (DistributeVideoView.this.gtV != null) {
                        if (DistributeVideoView.this.guj && "DETAIL".equals(DistributeVideoView.this.gtV.adE)) {
                            i2 = 35;
                        } else {
                            i2 = 31;
                        }
                        DistributeVideoView.this.X(i2, DistributeVideoView.this.sw(DistributeVideoView.this.guk), 0);
                    }
                    DistributeVideoView.this.cwc = gVar;
                    DistributeVideoView.this.cwc.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bcU = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bpN();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sw(DistributeVideoView.this.guk), gVar.getCurrentPosition());
                DistributeVideoView.this.ebX.setForegroundDrawable(0);
                DistributeVideoView.this.gqk.setVisibility(8);
                DistributeVideoView.this.fPP.setVisibility(0);
                return true;
            }
        };
        this.bjb = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gue = System.currentTimeMillis();
                DistributeVideoView.this.guj = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sw(DistributeVideoView.this.guk), gVar.getDuration());
                DistributeVideoView.this.bpN();
                if (DistributeVideoView.this.gqE != null) {
                    DistributeVideoView.this.gqE.bpH();
                    DistributeVideoView.this.fPL.setVisibility(8);
                    DistributeVideoView.this.gqk.setVisibility(8);
                }
            }
        };
        this.bcY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fPX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fPH != null && DistributeVideoView.this.buJ != null) {
                    DistributeVideoView.this.sv(1);
                }
            }
        };
        this.gul = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpP();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.eMq = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.guf = adCard;
        if (this.guf != null) {
            this.parallelChargeInfo = this.guf.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.i.distribute_video_view, (ViewGroup) this, true);
            this.buJ = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gqk = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.ebX = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(d.g.distribute_loading);
            this.fPL = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.fPP = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gtZ = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gtX = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gua = this.mRootView.findViewById(d.g.distribute_control);
            this.gub = (ImageView) this.gua.findViewById(d.g.distribute_play_icon);
            this.gtY = (ImageView) this.gua.findViewById(d.g.distribute_voice);
            this.guc = (VideoControllerView) this.gua.findViewById(d.g.distribute_process);
            this.gqC = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gqD = new com.baidu.tieba.recapp.e.d(context, this.gqC);
        }
    }

    private boolean bio() {
        return this.mStyle == 1 ? q.bio() : j.jE();
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
        this.gnl = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gnm = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPH = videoInfo;
        this.mDuration = this.fPH.video_duration.intValue() * 1000;
        this.abe = new WeakReference<>(this.mContext.getApplicationContext());
        bpN();
        am.j(this, d.C0142d.cp_bg_line_d);
        int ah = l.ah(this.mContext) - l.e(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            ah = l.ah(this.mContext);
        }
        int intValue = this.fPH.video_width.intValue() > 0 ? (this.fPH.video_height.intValue() * ah) / this.fPH.video_width.intValue() : ah;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ah;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        am.i(this.gqk, d.f.btn_icon_play_video_n);
        this.gqk.setVisibility(8);
        this.ebX.setDefaultErrorResource(0);
        this.ebX.setDefaultResource(0);
        this.ebX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ebX.setForegroundDrawable(d.f.icon_play_video_ad);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.ebX.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.buJ.setOnPreparedListener(this.bjc);
        this.buJ.setOnErrorListener(this.bcU);
        this.buJ.setOnCompletionListener(this.bjb);
        this.buJ.setOnSurfaceDestroyedListener(this.bcY);
        am.h(this.fPL, d.C0142d.cp_cont_i);
        am.i(this.fPL, d.f.video_play_count_bg);
        this.fPL.setText(StringUtils.translateSecondsToString(this.fPH.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gud = false;
            am.c(this.gtX, d.f.ad_icon_sound_close);
        } else {
            this.gud = true;
            am.c(this.gtY, d.f.ad_icon_sound_open);
            this.gtX.setVisibility(8);
        }
        this.gtY.setOnClickListener(this.mOnClickListener);
        this.gtX.setOnClickListener(this.mOnClickListener);
        this.fPP.setOnClickListener(this.mOnClickListener);
        this.fPP.setVisibility(8);
        am.j(this.fPP, d.C0142d.black_alpha80);
        am.h(this.gtZ, d.C0142d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fPL.setVisibility(0);
            return;
        }
        this.fPL.setVisibility(8);
        this.gub.setOnClickListener(this.mOnClickListener);
        this.gqk.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fPH = videoInfo;
        this.abe = new WeakReference<>(this.mContext.getApplicationContext());
        bpN();
        am.j(this, d.C0142d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ah(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        am.i(this.gqk, d.f.btn_icon_play_video_n);
        this.gqk.setVisibility(8);
        this.ebX.setDefaultErrorResource(0);
        this.ebX.setDefaultResource(0);
        this.ebX.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.ebX.setForegroundDrawable(d.f.icon_play_video_ad);
        if (!ap.isEmpty(videoInfo.thumbnail_url)) {
            this.ebX.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.buJ.setOnPreparedListener(this.bjc);
        this.buJ.setOnErrorListener(this.bcU);
        this.buJ.setOnCompletionListener(this.bjb);
        this.buJ.setOnSurfaceDestroyedListener(this.bcY);
        am.h(this.fPL, d.C0142d.cp_cont_i);
        this.fPL.setText(StringUtils.translateSecondsToString(this.fPH.video_duration.intValue()));
        am.i(this.fPL, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gud = false;
            am.c(this.gtX, d.f.ad_icon_sound_close);
        } else {
            this.gud = true;
            am.c(this.gtY, d.f.ad_icon_sound_open);
            this.gtX.setVisibility(8);
        }
        this.gtY.setOnClickListener(this.mOnClickListener);
        this.gtX.setOnClickListener(this.mOnClickListener);
        this.fPP.setOnClickListener(this.mOnClickListener);
        this.fPP.setVisibility(8);
        am.j(this.fPP, d.C0142d.black_alpha80);
        am.h(this.gtZ, d.C0142d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fPL.setVisibility(0);
            return;
        }
        this.fPL.setVisibility(8);
        this.gub.setOnClickListener(this.mOnClickListener);
        this.gqk.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gqE = this.gqD.a(this.gnm, this.gqE);
        if (this.gqE != null) {
            this.gqE.setPageContext(this.mPageContext);
            this.gqE.c(this.guf);
            this.gqE.setAdvertAppInfo(advertAppInfo);
            this.gqE.a(this.gnm);
            this.gqE.bpI();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gqE != null) {
            this.gqE.setDownloadAppCallback(cVar);
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
        this.bjb = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv(int i) {
        this.guk = i;
        if (this.fPH != null && this.fPI == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gue) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gqE != null) {
                    this.gqE.bpI();
                }
                this.buJ.setVideoPath(this.fPH.video_url);
                this.buJ.start();
                this.gui = this.buJ.getCurrentPosition();
                this.gqk.setVisibility(8);
                am.c(this.gub, d.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.fPP.setVisibility(8);
                this.ebX.setForegroundDrawable(0);
                this.fPI = 0;
                if (this.mStyle == 1) {
                    this.fPL.setVisibility(0);
                } else {
                    this.fPL.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        sv(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bio()) {
            if (i <= 0) {
                sv(1);
                return;
            }
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fPX);
            com.baidu.adp.lib.g.e.im().postDelayed(this.fPX, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fPI == 1) {
            y(32, sw(this.guk), this.buJ.getCurrentPosition(), i);
            this.buJ.pause();
            z.a(this.abe, false);
            this.gqk.setVisibility(0);
            am.c(this.gub, d.f.icon_video_midpause);
            this.fPI = 2;
        }
    }

    public void autoContinue() {
        if (!this.guh) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fPI == 2) {
            this.guk = i;
            X(33, sw(i), this.buJ.getCurrentPosition());
            this.gui = this.buJ.getCurrentPosition();
            this.buJ.start();
            if (this.gud) {
                z.a(this.abe, true);
            }
            this.gqk.setVisibility(8);
            am.c(this.gub, d.f.icon_video_midplay);
            this.fPI = 1;
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
        if (this.buJ.getCurrentPosition() > 0 && this.fPI != -1) {
            int i = 32;
            if (this.buJ.getDuration() == this.buJ.getCurrentPosition()) {
                i = 34;
            }
            e(i, sw(this.guk), this.buJ.getCurrentPosition(), this.buJ.isPlaying());
        }
        bpN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpN() {
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.fPX);
        com.baidu.adp.lib.g.e.im().removeCallbacks(this.gul);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.buJ.stopPlayback();
        this.fPI = -1;
        z.a(this.abe, false);
        this.ebX.setForegroundDrawable(0);
        this.ebX.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gqk.setVisibility(0);
        am.c(this.gub, d.f.icon_video_midpause);
        this.guc.QZ();
        this.fPP.setVisibility(8);
        if (this.fPH != null) {
            this.fPL.setText(StringUtils.translateSecondsToString(this.fPH.video_duration.intValue()));
        }
        this.cwc = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sw(int i) {
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
        return this.fPH != null ? this.fPH.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lX(boolean z) {
        if (z) {
            if (this.cwc != null) {
                this.cwc.setVolume(1.0f, 1.0f);
            }
            am.c(this.gtY, d.f.ad_icon_sound_open);
            am.c(this.gtX, d.f.ad_icon_sound_open);
            if (this.fPI == 1) {
                z.a(this.abe, true);
            }
        } else {
            if (this.cwc != null) {
                this.cwc.setVolume(0.0f, 0.0f);
            }
            am.c(this.gtY, d.f.ad_icon_sound_close);
            am.c(this.gtX, d.f.ad_icon_sound_close);
            z.a(this.abe, false);
        }
        this.gud = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fPI;
    }

    public VideoInfo getData() {
        return this.fPH;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fPR;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gtU && this.gtT != null && this.gtT.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aj(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gtV = advertAppInfo;
        this.gtW = i;
        this.gnq = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.adE = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gtV, 303, i, sw(this.guk), this.fPH.video_duration.intValue(), this.mDuration, -1);
        if (this.gqE != null) {
            this.gqE.e(a);
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
        if (this.gtV != null && this.fPH != null) {
            this.gtV.adE = this.gnq;
            com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(this.gtV, i, this.gtW, i2, this.fPH.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.gnq)) {
                    str2 = "det";
                } else if ("FRS".equals(this.gnq)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.gnq)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gui, i3, this.mDuration, str2, sx(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gnl != null && "cpv".equals(this.gnl.goj) && !TextUtils.isEmpty(this.gnl.gok)) {
            new com.baidu.tieba.recapp.request.a(this.gnl.gok).a(str, i, i2, i3, str2, str3);
        }
    }

    private String sx(int i) {
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
            this.gtT = view;
            this.gtU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lY(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.gul);
            if (this.dom != null) {
                this.dom.cancel();
            }
            this.gua.setVisibility(0);
            if (this.fPI == 1) {
                am.c(this.gub, d.f.icon_video_midplay);
                return;
            } else {
                am.c(this.gub, d.f.icon_video_midpause);
                return;
            }
        }
        this.gua.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpO() {
        switch (this.fPI) {
            case -1:
                if (!j.jD() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.k.neterror);
                    return;
                } else if (!j.jE() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.cd(d.k.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).xn();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.guh = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lY(true);
                    return;
                }
                return;
            case 2:
                this.guh = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.im().removeCallbacks(this.gul);
                    com.baidu.adp.lib.g.e.im().postDelayed(this.gul, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpP() {
        if (!this.gug && this.dom != null) {
            this.gua.startAnimation(this.dom);
            this.gug = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.dom = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dom.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gua.setVisibility(8);
                    DistributeVideoView.this.gug = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
