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
    private WeakReference<Context> amy;
    private QuickVideoView bOn;
    private g.b boW;
    private QuickVideoView.b bpa;
    private g.a bxI;
    private g.f bxJ;
    private g.e bxL;
    private g cUy;
    private Animation dNf;
    private ForeDrawableImageView eDk;
    private String fnu;
    private AdCard.a gLJ;
    private AdCard.f gLK;
    private ImageView gOH;
    private ViewGroup gPb;
    private d gPc;
    private e gPd;
    private long gSA;
    private b gSB;
    boolean gSC;
    private int gSD;
    boolean gSE;
    private int gSF;
    private Runnable gSG;
    private View gSp;
    private boolean gSq;
    private AdvertAppInfo gSr;
    private int gSs;
    private ImageView gSt;
    private ImageView gSu;
    private TextView gSv;
    private View gSw;
    private ImageView gSx;
    private VideoControllerView gSy;
    private boolean gSz;
    private VideoInfo gmO;
    private int gmP;
    private TextView gmS;
    private View gmW;
    private long gmY;
    private Runnable gne;
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
        this.gSq = false;
        this.amy = null;
        this.gmP = -1;
        this.gmY = 0L;
        this.gSz = false;
        this.gSA = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gSC = false;
        this.gSE = false;
        this.gSF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gmW) {
                    DistributeVideoView.this.gmW.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gSu || view == DistributeVideoView.this.gSt) {
                    DistributeVideoView.this.mN(DistributeVideoView.this.gSz ? false : true);
                } else if (view == DistributeVideoView.this.gOH || view == DistributeVideoView.this.gSx) {
                    DistributeVideoView.this.bvF();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gSr == null || !DistributeVideoView.this.gSr.ye()) {
                    DistributeVideoView.this.bvF();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gSr != null) {
                        WebVideoActivity.gLD = new WebVideoActivity.a();
                        WebVideoActivity.gLD.gLN = DistributeVideoView.this.gSr;
                        WebVideoActivity.gLD.mPage = "DETAIL";
                        WebVideoActivity.gLD.mPageNum = DistributeVideoView.this.gSs;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fnu) ? DistributeVideoView.this.fnu : DistributeVideoView.this.gSr.apt, true, true, true, DistributeVideoView.this.gmO.video_url, DistributeVideoView.this.gmO.thumbnail_url, DistributeVideoView.this.gmO.video_width.intValue() / DistributeVideoView.this.gmO.video_height.intValue(), DistributeVideoView.this.gmO.video_duration.intValue());
                    if (DistributeVideoView.this.gLJ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gLJ.gMG);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gLJ.gMH);
                    }
                    if (DistributeVideoView.this.gLK != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gLK.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rd(DistributeVideoView.this.parallelChargeInfo.fmN);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fmQ.iterator();
                        while (it.hasNext()) {
                            c.rd(it.next());
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
                        if (DistributeVideoView.this.gmP != 1) {
                            if (DistributeVideoView.this.bOn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gmP = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eDk.setVisibility(8);
                                DistributeVideoView.this.mN(DistributeVideoView.this.gSz);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gSy.setPlayer(DistributeVideoView.this.bOn);
                                    DistributeVideoView.this.gSy.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gmO.video_duration.intValue()));
                                    DistributeVideoView.this.gSy.showProgress();
                                    DistributeVideoView.this.mO(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gSG);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gSG, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gmY = DistributeVideoView.this.bOn.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bOn.getDuration() - DistributeVideoView.this.bOn.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gmS.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gmP == 1) {
                            if (DistributeVideoView.this.gmY == DistributeVideoView.this.bOn.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gmY = DistributeVideoView.this.bOn.getCurrentPosition();
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
        this.bxJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gSD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cUy = gVar;
                    DistributeVideoView.this.cUy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gSr != null) {
                    if (DistributeVideoView.this.gSE && "DETAIL".equals(DistributeVideoView.this.gSr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), 0);
                }
                return false;
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bvE();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), gVar.getCurrentPosition());
                DistributeVideoView.this.eDk.setForegroundDrawable(0);
                DistributeVideoView.this.gOH.setVisibility(8);
                DistributeVideoView.this.gmW.setVisibility(0);
                return true;
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gSA = System.currentTimeMillis();
                DistributeVideoView.this.gSE = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), gVar.getDuration());
                DistributeVideoView.this.bvE();
                if (DistributeVideoView.this.gPd != null) {
                    DistributeVideoView.this.gPd.bvy();
                    DistributeVideoView.this.gmS.setVisibility(8);
                    DistributeVideoView.this.gOH.setVisibility(8);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gne = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gmO != null && DistributeVideoView.this.bOn != null) {
                    DistributeVideoView.this.ub(1);
                }
            }
        };
        this.gSG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bvG();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSq = false;
        this.amy = null;
        this.gmP = -1;
        this.gmY = 0L;
        this.gSz = false;
        this.gSA = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gSC = false;
        this.gSE = false;
        this.gSF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gmW) {
                    DistributeVideoView.this.gmW.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gSu || view == DistributeVideoView.this.gSt) {
                    DistributeVideoView.this.mN(DistributeVideoView.this.gSz ? false : true);
                } else if (view == DistributeVideoView.this.gOH || view == DistributeVideoView.this.gSx) {
                    DistributeVideoView.this.bvF();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gSr == null || !DistributeVideoView.this.gSr.ye()) {
                    DistributeVideoView.this.bvF();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gSr != null) {
                        WebVideoActivity.gLD = new WebVideoActivity.a();
                        WebVideoActivity.gLD.gLN = DistributeVideoView.this.gSr;
                        WebVideoActivity.gLD.mPage = "DETAIL";
                        WebVideoActivity.gLD.mPageNum = DistributeVideoView.this.gSs;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fnu) ? DistributeVideoView.this.fnu : DistributeVideoView.this.gSr.apt, true, true, true, DistributeVideoView.this.gmO.video_url, DistributeVideoView.this.gmO.thumbnail_url, DistributeVideoView.this.gmO.video_width.intValue() / DistributeVideoView.this.gmO.video_height.intValue(), DistributeVideoView.this.gmO.video_duration.intValue());
                    if (DistributeVideoView.this.gLJ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gLJ.gMG);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gLJ.gMH);
                    }
                    if (DistributeVideoView.this.gLK != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gLK.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rd(DistributeVideoView.this.parallelChargeInfo.fmN);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fmQ.iterator();
                        while (it.hasNext()) {
                            c.rd(it.next());
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
                        if (DistributeVideoView.this.gmP != 1) {
                            if (DistributeVideoView.this.bOn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gmP = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eDk.setVisibility(8);
                                DistributeVideoView.this.mN(DistributeVideoView.this.gSz);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gSy.setPlayer(DistributeVideoView.this.bOn);
                                    DistributeVideoView.this.gSy.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gmO.video_duration.intValue()));
                                    DistributeVideoView.this.gSy.showProgress();
                                    DistributeVideoView.this.mO(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gSG);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gSG, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gmY = DistributeVideoView.this.bOn.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bOn.getDuration() - DistributeVideoView.this.bOn.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gmS.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gmP == 1) {
                            if (DistributeVideoView.this.gmY == DistributeVideoView.this.bOn.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gmY = DistributeVideoView.this.bOn.getCurrentPosition();
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
        this.bxJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gSD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cUy = gVar;
                    DistributeVideoView.this.cUy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gSr != null) {
                    if (DistributeVideoView.this.gSE && "DETAIL".equals(DistributeVideoView.this.gSr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), 0);
                }
                return false;
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bvE();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), gVar.getCurrentPosition());
                DistributeVideoView.this.eDk.setForegroundDrawable(0);
                DistributeVideoView.this.gOH.setVisibility(8);
                DistributeVideoView.this.gmW.setVisibility(0);
                return true;
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gSA = System.currentTimeMillis();
                DistributeVideoView.this.gSE = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), gVar.getDuration());
                DistributeVideoView.this.bvE();
                if (DistributeVideoView.this.gPd != null) {
                    DistributeVideoView.this.gPd.bvy();
                    DistributeVideoView.this.gmS.setVisibility(8);
                    DistributeVideoView.this.gOH.setVisibility(8);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gne = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gmO != null && DistributeVideoView.this.bOn != null) {
                    DistributeVideoView.this.ub(1);
                }
            }
        };
        this.gSG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bvG();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gSq = false;
        this.amy = null;
        this.gmP = -1;
        this.gmY = 0L;
        this.gSz = false;
        this.gSA = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gSC = false;
        this.gSE = false;
        this.gSF = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gmW) {
                    DistributeVideoView.this.gmW.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gSu || view == DistributeVideoView.this.gSt) {
                    DistributeVideoView.this.mN(DistributeVideoView.this.gSz ? false : true);
                } else if (view == DistributeVideoView.this.gOH || view == DistributeVideoView.this.gSx) {
                    DistributeVideoView.this.bvF();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gSr == null || !DistributeVideoView.this.gSr.ye()) {
                    DistributeVideoView.this.bvF();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gSr != null) {
                        WebVideoActivity.gLD = new WebVideoActivity.a();
                        WebVideoActivity.gLD.gLN = DistributeVideoView.this.gSr;
                        WebVideoActivity.gLD.mPage = "DETAIL";
                        WebVideoActivity.gLD.mPageNum = DistributeVideoView.this.gSs;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fnu) ? DistributeVideoView.this.fnu : DistributeVideoView.this.gSr.apt, true, true, true, DistributeVideoView.this.gmO.video_url, DistributeVideoView.this.gmO.thumbnail_url, DistributeVideoView.this.gmO.video_width.intValue() / DistributeVideoView.this.gmO.video_height.intValue(), DistributeVideoView.this.gmO.video_duration.intValue());
                    if (DistributeVideoView.this.gLJ != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gLJ.gMG);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gLJ.gMH);
                    }
                    if (DistributeVideoView.this.gLK != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gLK.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rd(DistributeVideoView.this.parallelChargeInfo.fmN);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fmQ.iterator();
                        while (it.hasNext()) {
                            c.rd(it.next());
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
                        if (DistributeVideoView.this.gmP != 1) {
                            if (DistributeVideoView.this.bOn.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gmP = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eDk.setVisibility(8);
                                DistributeVideoView.this.mN(DistributeVideoView.this.gSz);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gSy.setPlayer(DistributeVideoView.this.bOn);
                                    DistributeVideoView.this.gSy.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gmO.video_duration.intValue()));
                                    DistributeVideoView.this.gSy.showProgress();
                                    DistributeVideoView.this.mO(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gSG);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gSG, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gmY = DistributeVideoView.this.bOn.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bOn.getDuration() - DistributeVideoView.this.bOn.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gmS.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gmP == 1) {
                            if (DistributeVideoView.this.gmY == DistributeVideoView.this.bOn.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gmY = DistributeVideoView.this.bOn.getCurrentPosition();
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
        this.bxJ = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gSD = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cUy = gVar;
                    DistributeVideoView.this.cUy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bxL = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gSr != null) {
                    if (DistributeVideoView.this.gSE && "DETAIL".equals(DistributeVideoView.this.gSr.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), 0);
                }
                return false;
            }
        };
        this.boW = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bvE();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), gVar.getCurrentPosition());
                DistributeVideoView.this.eDk.setForegroundDrawable(0);
                DistributeVideoView.this.gOH.setVisibility(8);
                DistributeVideoView.this.gmW.setVisibility(0);
                return true;
            }
        };
        this.bxI = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gSA = System.currentTimeMillis();
                DistributeVideoView.this.gSE = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.uc(DistributeVideoView.this.gSF), gVar.getDuration());
                DistributeVideoView.this.bvE();
                if (DistributeVideoView.this.gPd != null) {
                    DistributeVideoView.this.gPd.bvy();
                    DistributeVideoView.this.gmS.setVisibility(8);
                    DistributeVideoView.this.gOH.setVisibility(8);
                }
            }
        };
        this.bpa = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gne = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gmO != null && DistributeVideoView.this.bOn != null) {
                    DistributeVideoView.this.ub(1);
                }
            }
        };
        this.gSG = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bvG();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.fnu = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gSB = adCard;
        if (this.gSB != null) {
            this.parallelChargeInfo = this.gSB.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bOn = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gOH = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.eDk = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(e.g.distribute_loading);
            this.gmS = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.gmW = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gSv = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gSt = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gSw = this.mRootView.findViewById(e.g.distribute_control);
            this.gSx = (ImageView) this.gSw.findViewById(e.g.distribute_play_icon);
            this.gSu = (ImageView) this.gSw.findViewById(e.g.distribute_voice);
            this.gSy = (VideoControllerView) this.gSw.findViewById(e.g.distribute_process);
            this.gPb = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gPc = new d(context, this.gPb);
        }
    }

    private boolean bnE() {
        return this.mStyle == 1 ? q.bnE() : j.kW();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bvH();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gLJ = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gLK = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gmO = videoInfo;
        this.mDuration = this.gmO.video_duration.intValue() * 1000;
        this.amy = new WeakReference<>(this.mContext.getApplicationContext());
        bvE();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.gmO.video_width.intValue() > 0 ? (this.gmO.video_height.intValue() * aO) / this.gmO.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gOH, e.f.btn_icon_play_video_n);
        this.gOH.setVisibility(8);
        this.eDk.setDefaultErrorResource(0);
        this.eDk.setDefaultResource(0);
        this.eDk.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eDk.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eDk.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bOn.setOnPreparedListener(this.bxJ);
        this.bOn.setOnErrorListener(this.boW);
        this.bOn.setOnCompletionListener(this.bxI);
        this.bOn.setOnOutInfoListener(this.bxL);
        this.bOn.setOnSurfaceDestroyedListener(this.bpa);
        al.h(this.gmS, e.d.cp_cont_i);
        al.i(this.gmS, e.f.video_play_count_bg);
        this.gmS.setText(StringUtils.translateSecondsToString(this.gmO.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gSz = false;
            al.c(this.gSt, e.f.ad_icon_sound_close);
        } else {
            this.gSz = true;
            al.c(this.gSu, e.f.ad_icon_sound_open);
            this.gSt.setVisibility(8);
        }
        this.gSu.setOnClickListener(this.mOnClickListener);
        this.gSt.setOnClickListener(this.mOnClickListener);
        this.gmW.setOnClickListener(this.mOnClickListener);
        this.gmW.setVisibility(8);
        al.j(this.gmW, e.d.black_alpha80);
        al.h(this.gSv, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gmS.setVisibility(0);
            return;
        }
        this.gmS.setVisibility(8);
        this.gSx.setOnClickListener(this.mOnClickListener);
        this.gOH.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gmO = videoInfo;
        this.amy = new WeakReference<>(this.mContext.getApplicationContext());
        bvE();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gOH, e.f.btn_icon_play_video_n);
        this.gOH.setVisibility(8);
        this.eDk.setDefaultErrorResource(0);
        this.eDk.setDefaultResource(0);
        this.eDk.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eDk.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eDk.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bOn.setOnPreparedListener(this.bxJ);
        this.bOn.setOnErrorListener(this.boW);
        this.bOn.setOnCompletionListener(this.bxI);
        this.bOn.setOnOutInfoListener(this.bxL);
        this.bOn.setOnSurfaceDestroyedListener(this.bpa);
        al.h(this.gmS, e.d.cp_cont_i);
        this.gmS.setText(StringUtils.translateSecondsToString(this.gmO.video_duration.intValue()));
        al.i(this.gmS, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gSz = false;
            al.c(this.gSt, e.f.ad_icon_sound_close);
        } else {
            this.gSz = true;
            al.c(this.gSu, e.f.ad_icon_sound_open);
            this.gSt.setVisibility(8);
        }
        this.gSu.setOnClickListener(this.mOnClickListener);
        this.gSt.setOnClickListener(this.mOnClickListener);
        this.gmW.setOnClickListener(this.mOnClickListener);
        this.gmW.setVisibility(8);
        al.j(this.gmW, e.d.black_alpha80);
        al.h(this.gSv, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gmS.setVisibility(0);
            return;
        }
        this.gmS.setVisibility(8);
        this.gSx.setOnClickListener(this.mOnClickListener);
        this.gOH.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gPd = this.gPc.a(this.gLK, this.gPd);
        if (this.gPd != null) {
            this.gPd.setPageContext(this.mPageContext);
            this.gPd.c(this.gSB);
            this.gPd.setAdvertAppInfo(advertAppInfo);
            this.gPd.a(this.gLK);
            this.gPd.bvz();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gPd != null) {
            this.gPd.setDownloadAppCallback(cVar);
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
        this.bxI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        this.gSF = i;
        if (this.gmO != null && this.gmP == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gSA) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gPd != null) {
                    this.gPd.bvz();
                }
                this.bOn.setVideoPath(this.gmO.video_url);
                this.bOn.start();
                this.gSD = this.bOn.getCurrentPosition();
                this.gOH.setVisibility(8);
                al.c(this.gSx, e.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.gmW.setVisibility(8);
                this.eDk.setForegroundDrawable(0);
                this.gmP = 0;
                if (this.mStyle == 1) {
                    this.gmS.setVisibility(0);
                } else {
                    this.gmS.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        ub(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bnE()) {
            if (i <= 0) {
                ub(1);
                return;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gne);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gne, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.gmP == 1) {
            x(32, uc(this.gSF), this.bOn.getCurrentPosition(), i);
            this.bOn.pause();
            aa.a(this.amy, false);
            this.gOH.setVisibility(0);
            al.c(this.gSx, e.f.icon_video_midpause);
            this.gmP = 2;
        }
    }

    public void autoContinue() {
        if (!this.gSC) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.gmP == 2) {
            this.gSF = i;
            ab(33, uc(i), this.bOn.getCurrentPosition());
            this.gSD = this.bOn.getCurrentPosition();
            this.bOn.start();
            if (this.gSz) {
                aa.a(this.amy, true);
            }
            this.gOH.setVisibility(8);
            al.c(this.gSx, e.f.icon_video_midplay);
            this.gmP = 1;
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
        if (this.bOn.getCurrentPosition() > 0 && this.gmP != -1 && z) {
            int i = 32;
            int currentPosition = this.bOn.getCurrentPosition();
            if (this.bOn.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, uc(this.gSF), currentPosition, this.bOn.isPlaying());
        }
        bvE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvE() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gne);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gSG);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bOn.stopPlayback();
        this.gmP = -1;
        aa.a(this.amy, false);
        this.eDk.setForegroundDrawable(0);
        this.eDk.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gOH.setVisibility(0);
        al.c(this.gSx, e.f.icon_video_midpause);
        this.gSy.Wk();
        this.gmW.setVisibility(8);
        if (this.gmO != null) {
            this.gmS.setText(StringUtils.translateSecondsToString(this.gmO.video_duration.intValue()));
        }
        this.cUy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uc(int i) {
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
        return this.gmO != null ? this.gmO.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN(boolean z) {
        if (z) {
            if (this.cUy != null) {
                this.cUy.setVolume(1.0f, 1.0f);
            }
            al.c(this.gSu, e.f.ad_icon_sound_open);
            al.c(this.gSt, e.f.ad_icon_sound_open);
            if (this.gmP == 1) {
                aa.a(this.amy, true);
            }
        } else {
            if (this.cUy != null) {
                this.cUy.setVolume(0.0f, 0.0f);
            }
            al.c(this.gSu, e.f.ad_icon_sound_close);
            al.c(this.gSt, e.f.ad_icon_sound_close);
            aa.a(this.amy, false);
        }
        this.gSz = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.gmP;
    }

    public VideoInfo getData() {
        return this.gmO;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.gmY;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gSq && this.gSp != null && this.gSp.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gSr = advertAppInfo;
        this.gSs = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gSr, 303, i, uc(this.gSF), this.gmO.video_duration.intValue(), this.mDuration, -1);
        if (this.gPd != null) {
            this.gPd.e(a);
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
        if (this.gSr != null && this.gmO != null) {
            this.gSr.page = this.mPage;
            com.baidu.tieba.recapp.report.c.bvu().a(f.a(this.gSr, i, this.gSs, i2, this.gmO.video_duration.intValue(), a.hJ(i3), i4));
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
                c(str, this.gSD, i3, this.mDuration, str2, ud(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gLJ != null && "cpv".equals(this.gLJ.gMG) && !TextUtils.isEmpty(this.gLJ.gMH)) {
            new com.baidu.tieba.recapp.request.a(this.gLJ.gMH).a(str, i, i2, i3, str2, str3);
        }
    }

    private String ud(int i) {
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
            this.gSp = view;
            this.gSq = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mO(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gSG);
            if (this.dNf != null) {
                this.dNf.cancel();
            }
            this.gSw.setVisibility(0);
            if (this.gmP == 1) {
                al.c(this.gSx, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gSx, e.f.icon_video_midpause);
                return;
            }
        }
        this.gSw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvF() {
        switch (this.gmP) {
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
                    aVar.b(this.mPageContext).BF();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gSC = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mO(true);
                    return;
                }
                return;
            case 2:
                this.gSC = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gSG);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.gSG, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvG() {
        if (!this.mIsInAnimation && this.dNf != null) {
            this.gSw.startAnimation(this.dNf);
            this.mIsInAnimation = true;
        }
    }

    private void bvH() {
        if (this.mPageContext != null) {
            this.dNf = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dNf.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gSw.setVisibility(8);
                    DistributeVideoView.this.mIsInAnimation = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
