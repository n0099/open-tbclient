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
    private QuickVideoView bOq;
    private g.b boZ;
    private QuickVideoView.b bpd;
    private g.a bxL;
    private g.f bxM;
    private g.e bxO;
    private g cXo;
    private Animation dPT;
    private ForeDrawableImageView eGb;
    private String fqm;
    private AdCard.a gOA;
    private AdCard.f gOB;
    private ViewGroup gRT;
    private d gRU;
    private e gRV;
    private ImageView gRz;
    private int gVA;
    private Runnable gVB;
    private View gVk;
    private boolean gVl;
    private AdvertAppInfo gVm;
    private int gVn;
    private ImageView gVo;
    private ImageView gVp;
    private TextView gVq;
    private View gVr;
    private ImageView gVs;
    private VideoControllerView gVt;
    private boolean gVu;
    private long gVv;
    private b gVw;
    boolean gVx;
    private int gVy;
    boolean gVz;
    private VideoInfo gpF;
    private int gpG;
    private TextView gpJ;
    private View gpN;
    private long gpP;
    private Runnable gpV;
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
        this.gVl = false;
        this.amy = null;
        this.gpG = -1;
        this.gpP = 0L;
        this.gVu = false;
        this.gVv = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gVx = false;
        this.gVz = false;
        this.gVA = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gpN) {
                    DistributeVideoView.this.gpN.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gVp || view == DistributeVideoView.this.gVo) {
                    DistributeVideoView.this.mQ(DistributeVideoView.this.gVu ? false : true);
                } else if (view == DistributeVideoView.this.gRz || view == DistributeVideoView.this.gVs) {
                    DistributeVideoView.this.bws();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gVm == null || !DistributeVideoView.this.gVm.ye()) {
                    DistributeVideoView.this.bws();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gVm != null) {
                        WebVideoActivity.gOu = new WebVideoActivity.a();
                        WebVideoActivity.gOu.gOE = DistributeVideoView.this.gVm;
                        WebVideoActivity.gOu.mPage = "DETAIL";
                        WebVideoActivity.gOu.mPageNum = DistributeVideoView.this.gVn;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fqm) ? DistributeVideoView.this.fqm : DistributeVideoView.this.gVm.apt, true, true, true, DistributeVideoView.this.gpF.video_url, DistributeVideoView.this.gpF.thumbnail_url, DistributeVideoView.this.gpF.video_width.intValue() / DistributeVideoView.this.gpF.video_height.intValue(), DistributeVideoView.this.gpF.video_duration.intValue());
                    if (DistributeVideoView.this.gOA != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gOA.gPy);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gOA.gPz);
                    }
                    if (DistributeVideoView.this.gOB != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gOB.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rg(DistributeVideoView.this.parallelChargeInfo.fpF);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fpI.iterator();
                        while (it.hasNext()) {
                            c.rg(it.next());
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
                        if (DistributeVideoView.this.gpG != 1) {
                            if (DistributeVideoView.this.bOq.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gpG = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGb.setVisibility(8);
                                DistributeVideoView.this.mQ(DistributeVideoView.this.gVu);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gVt.setPlayer(DistributeVideoView.this.bOq);
                                    DistributeVideoView.this.gVt.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gpF.video_duration.intValue()));
                                    DistributeVideoView.this.gVt.showProgress();
                                    DistributeVideoView.this.mR(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gVB);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gVB, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gpP = DistributeVideoView.this.bOq.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bOq.getDuration() - DistributeVideoView.this.bOq.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gpJ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gpG == 1) {
                            if (DistributeVideoView.this.gpP == DistributeVideoView.this.bOq.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gpP = DistributeVideoView.this.bOq.getCurrentPosition();
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
        this.bxM = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gVy = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cXo = gVar;
                    DistributeVideoView.this.cXo.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gVm != null) {
                    if (DistributeVideoView.this.gVz && "DETAIL".equals(DistributeVideoView.this.gVm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.up(DistributeVideoView.this.gVA), 0);
                }
                return false;
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bwr();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.up(DistributeVideoView.this.gVA), gVar.getCurrentPosition());
                DistributeVideoView.this.eGb.setForegroundDrawable(0);
                DistributeVideoView.this.gRz.setVisibility(8);
                DistributeVideoView.this.gpN.setVisibility(0);
                return true;
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gVv = System.currentTimeMillis();
                DistributeVideoView.this.gVz = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.up(DistributeVideoView.this.gVA), gVar.getDuration());
                DistributeVideoView.this.bwr();
                if (DistributeVideoView.this.gRV != null) {
                    DistributeVideoView.this.gRV.bwj();
                    DistributeVideoView.this.gpJ.setVisibility(8);
                    DistributeVideoView.this.gRz.setVisibility(8);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gpV = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gpF != null && DistributeVideoView.this.bOq != null) {
                    DistributeVideoView.this.uo(1);
                }
            }
        };
        this.gVB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bwt();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gVl = false;
        this.amy = null;
        this.gpG = -1;
        this.gpP = 0L;
        this.gVu = false;
        this.gVv = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gVx = false;
        this.gVz = false;
        this.gVA = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gpN) {
                    DistributeVideoView.this.gpN.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gVp || view == DistributeVideoView.this.gVo) {
                    DistributeVideoView.this.mQ(DistributeVideoView.this.gVu ? false : true);
                } else if (view == DistributeVideoView.this.gRz || view == DistributeVideoView.this.gVs) {
                    DistributeVideoView.this.bws();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gVm == null || !DistributeVideoView.this.gVm.ye()) {
                    DistributeVideoView.this.bws();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gVm != null) {
                        WebVideoActivity.gOu = new WebVideoActivity.a();
                        WebVideoActivity.gOu.gOE = DistributeVideoView.this.gVm;
                        WebVideoActivity.gOu.mPage = "DETAIL";
                        WebVideoActivity.gOu.mPageNum = DistributeVideoView.this.gVn;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fqm) ? DistributeVideoView.this.fqm : DistributeVideoView.this.gVm.apt, true, true, true, DistributeVideoView.this.gpF.video_url, DistributeVideoView.this.gpF.thumbnail_url, DistributeVideoView.this.gpF.video_width.intValue() / DistributeVideoView.this.gpF.video_height.intValue(), DistributeVideoView.this.gpF.video_duration.intValue());
                    if (DistributeVideoView.this.gOA != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gOA.gPy);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gOA.gPz);
                    }
                    if (DistributeVideoView.this.gOB != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gOB.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rg(DistributeVideoView.this.parallelChargeInfo.fpF);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fpI.iterator();
                        while (it.hasNext()) {
                            c.rg(it.next());
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
                        if (DistributeVideoView.this.gpG != 1) {
                            if (DistributeVideoView.this.bOq.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gpG = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGb.setVisibility(8);
                                DistributeVideoView.this.mQ(DistributeVideoView.this.gVu);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gVt.setPlayer(DistributeVideoView.this.bOq);
                                    DistributeVideoView.this.gVt.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gpF.video_duration.intValue()));
                                    DistributeVideoView.this.gVt.showProgress();
                                    DistributeVideoView.this.mR(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gVB);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gVB, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gpP = DistributeVideoView.this.bOq.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bOq.getDuration() - DistributeVideoView.this.bOq.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gpJ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gpG == 1) {
                            if (DistributeVideoView.this.gpP == DistributeVideoView.this.bOq.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gpP = DistributeVideoView.this.bOq.getCurrentPosition();
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
        this.bxM = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gVy = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cXo = gVar;
                    DistributeVideoView.this.cXo.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i, int i2) {
                int i3;
                if (i == 3 && DistributeVideoView.this.gVm != null) {
                    if (DistributeVideoView.this.gVz && "DETAIL".equals(DistributeVideoView.this.gVm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.up(DistributeVideoView.this.gVA), 0);
                }
                return false;
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bwr();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.up(DistributeVideoView.this.gVA), gVar.getCurrentPosition());
                DistributeVideoView.this.eGb.setForegroundDrawable(0);
                DistributeVideoView.this.gRz.setVisibility(8);
                DistributeVideoView.this.gpN.setVisibility(0);
                return true;
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gVv = System.currentTimeMillis();
                DistributeVideoView.this.gVz = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.up(DistributeVideoView.this.gVA), gVar.getDuration());
                DistributeVideoView.this.bwr();
                if (DistributeVideoView.this.gRV != null) {
                    DistributeVideoView.this.gRV.bwj();
                    DistributeVideoView.this.gpJ.setVisibility(8);
                    DistributeVideoView.this.gRz.setVisibility(8);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gpV = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gpF != null && DistributeVideoView.this.bOq != null) {
                    DistributeVideoView.this.uo(1);
                }
            }
        };
        this.gVB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bwt();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gVl = false;
        this.amy = null;
        this.gpG = -1;
        this.gpP = 0L;
        this.gVu = false;
        this.gVv = 0L;
        this.mStyle = 1;
        this.mIsInAnimation = false;
        this.gVx = false;
        this.gVz = false;
        this.gVA = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.gpN) {
                    DistributeVideoView.this.gpN.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gVp || view == DistributeVideoView.this.gVo) {
                    DistributeVideoView.this.mQ(DistributeVideoView.this.gVu ? false : true);
                } else if (view == DistributeVideoView.this.gRz || view == DistributeVideoView.this.gVs) {
                    DistributeVideoView.this.bws();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gVm == null || !DistributeVideoView.this.gVm.ye()) {
                    DistributeVideoView.this.bws();
                } else {
                    DistributeVideoView.this.ab(2, 1, 0);
                    if (DistributeVideoView.this.gVm != null) {
                        WebVideoActivity.gOu = new WebVideoActivity.a();
                        WebVideoActivity.gOu.gOE = DistributeVideoView.this.gVm;
                        WebVideoActivity.gOu.mPage = "DETAIL";
                        WebVideoActivity.gOu.mPageNum = DistributeVideoView.this.gVn;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", !TextUtils.isEmpty(DistributeVideoView.this.fqm) ? DistributeVideoView.this.fqm : DistributeVideoView.this.gVm.apt, true, true, true, DistributeVideoView.this.gpF.video_url, DistributeVideoView.this.gpF.thumbnail_url, DistributeVideoView.this.gpF.video_width.intValue() / DistributeVideoView.this.gpF.video_height.intValue(), DistributeVideoView.this.gpF.video_duration.intValue());
                    if (DistributeVideoView.this.gOA != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gOA.gPy);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gOA.gPz);
                    }
                    if (DistributeVideoView.this.gOB != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gOB.toJsonString());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, webVideoActivityConfig));
                    if (DistributeVideoView.this.parallelChargeInfo != null) {
                        c.rg(DistributeVideoView.this.parallelChargeInfo.fpF);
                        Iterator<String> it = DistributeVideoView.this.parallelChargeInfo.fpI.iterator();
                        while (it.hasNext()) {
                            c.rg(it.next());
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
                        if (DistributeVideoView.this.gpG != 1) {
                            if (DistributeVideoView.this.bOq.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gpG = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.eGb.setVisibility(8);
                                DistributeVideoView.this.mQ(DistributeVideoView.this.gVu);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gVt.setPlayer(DistributeVideoView.this.bOq);
                                    DistributeVideoView.this.gVt.Z(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gpF.video_duration.intValue()));
                                    DistributeVideoView.this.gVt.showProgress();
                                    DistributeVideoView.this.mR(true);
                                    com.baidu.adp.lib.g.e.jG().removeCallbacks(DistributeVideoView.this.gVB);
                                    com.baidu.adp.lib.g.e.jG().postDelayed(DistributeVideoView.this.gVB, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.gpP = DistributeVideoView.this.bOq.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.bOq.getDuration() - DistributeVideoView.this.bOq.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.gpJ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gpG == 1) {
                            if (DistributeVideoView.this.gpP == DistributeVideoView.this.bOq.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.gpP = DistributeVideoView.this.bOq.getCurrentPosition();
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
        this.bxM = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                if (gVar != null) {
                    DistributeVideoView.this.gVy = gVar.getCurrentPosition();
                    DistributeVideoView.this.mDuration = gVar.getDuration();
                    DistributeVideoView.this.cXo = gVar;
                    DistributeVideoView.this.cXo.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bxO = new g.e() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.e
            public boolean onInfo(g gVar, int i2, int i22) {
                int i3;
                if (i2 == 3 && DistributeVideoView.this.gVm != null) {
                    if (DistributeVideoView.this.gVz && "DETAIL".equals(DistributeVideoView.this.gVm.page)) {
                        i3 = 35;
                    } else {
                        i3 = 31;
                    }
                    DistributeVideoView.this.ab(i3, DistributeVideoView.this.up(DistributeVideoView.this.gVA), 0);
                }
                return false;
            }
        };
        this.boZ = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bwr();
                DistributeVideoView.this.ab(36, DistributeVideoView.this.up(DistributeVideoView.this.gVA), gVar.getCurrentPosition());
                DistributeVideoView.this.eGb.setForegroundDrawable(0);
                DistributeVideoView.this.gRz.setVisibility(8);
                DistributeVideoView.this.gpN.setVisibility(0);
                return true;
            }
        };
        this.bxL = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gVv = System.currentTimeMillis();
                DistributeVideoView.this.gVz = true;
                DistributeVideoView.this.ab(34, DistributeVideoView.this.up(DistributeVideoView.this.gVA), gVar.getDuration());
                DistributeVideoView.this.bwr();
                if (DistributeVideoView.this.gRV != null) {
                    DistributeVideoView.this.gRV.bwj();
                    DistributeVideoView.this.gpJ.setVisibility(8);
                    DistributeVideoView.this.gRz.setVisibility(8);
                }
            }
        };
        this.bpd = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gpV = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gpF != null && DistributeVideoView.this.bOq != null) {
                    DistributeVideoView.this.uo(1);
                }
            }
        };
        this.gVB = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bwt();
            }
        };
        init(context);
    }

    public void setScheme(String str) {
        this.fqm = str;
    }

    public void setParallelChargeInfo(AdCard adCard) {
        this.gVw = adCard;
        if (this.gVw != null) {
            this.parallelChargeInfo = this.gVw.getParallelCharge();
        }
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(e.h.distribute_video_view, (ViewGroup) this, true);
            this.bOq = (QuickVideoView) this.mRootView.findViewById(e.g.distribute_texture);
            this.gRz = (ImageView) this.mRootView.findViewById(e.g.distribute_play);
            this.eGb = (ForeDrawableImageView) this.mRootView.findViewById(e.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(e.g.distribute_loading);
            this.gpJ = (TextView) this.mRootView.findViewById(e.g.distribute_count_process);
            this.gpN = this.mRootView.findViewById(e.g.distribute_error_tip);
            this.gVq = (TextView) this.mRootView.findViewById(e.g.distribute_error_tip_text);
            this.gVo = (ImageView) this.mRootView.findViewById(e.g.distribute_voice_feed);
            this.gVr = this.mRootView.findViewById(e.g.distribute_control);
            this.gVs = (ImageView) this.gVr.findViewById(e.g.distribute_play_icon);
            this.gVp = (ImageView) this.gVr.findViewById(e.g.distribute_voice);
            this.gVt = (VideoControllerView) this.gVr.findViewById(e.g.distribute_process);
            this.gRT = (FrameLayout) this.mRootView.findViewById(e.g.tail_frame_container);
            this.gRU = new d(context, this.gRT);
        }
    }

    private boolean bop() {
        return this.mStyle == 1 ? q.bop() : j.kW();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bwu();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gOA = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.gOB = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gpF = videoInfo;
        this.mDuration = this.gpF.video_duration.intValue() * 1000;
        this.amy = new WeakReference<>(this.mContext.getApplicationContext());
        bwr();
        al.j(this, e.d.cp_bg_line_d);
        int aO = l.aO(this.mContext) - l.h(this.mContext, e.C0210e.ds146);
        if (this.mStyle == 2) {
            aO = l.aO(this.mContext);
        }
        int intValue = this.gpF.video_width.intValue() > 0 ? (this.gpF.video_height.intValue() * aO) / this.gpF.video_width.intValue() : aO;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = aO;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        al.i(this.gRz, e.f.btn_icon_play_video_n);
        this.gRz.setVisibility(8);
        this.eGb.setDefaultErrorResource(0);
        this.eGb.setDefaultResource(0);
        this.eGb.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGb.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGb.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bOq.setOnPreparedListener(this.bxM);
        this.bOq.setOnErrorListener(this.boZ);
        this.bOq.setOnCompletionListener(this.bxL);
        this.bOq.setOnOutInfoListener(this.bxO);
        this.bOq.setOnSurfaceDestroyedListener(this.bpd);
        al.h(this.gpJ, e.d.cp_cont_i);
        al.i(this.gpJ, e.f.video_play_count_bg);
        this.gpJ.setText(StringUtils.translateSecondsToString(this.gpF.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gVu = false;
            al.c(this.gVo, e.f.ad_icon_sound_close);
        } else {
            this.gVu = true;
            al.c(this.gVp, e.f.ad_icon_sound_open);
            this.gVo.setVisibility(8);
        }
        this.gVp.setOnClickListener(this.mOnClickListener);
        this.gVo.setOnClickListener(this.mOnClickListener);
        this.gpN.setOnClickListener(this.mOnClickListener);
        this.gpN.setVisibility(8);
        al.j(this.gpN, e.d.black_alpha80);
        al.h(this.gVq, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gpJ.setVisibility(0);
            return;
        }
        this.gpJ.setVisibility(8);
        this.gVs.setOnClickListener(this.mOnClickListener);
        this.gRz.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gpF = videoInfo;
        this.amy = new WeakReference<>(this.mContext.getApplicationContext());
        bwr();
        al.j(this, e.d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.aO(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        al.i(this.gRz, e.f.btn_icon_play_video_n);
        this.gRz.setVisibility(8);
        this.eGb.setDefaultErrorResource(0);
        this.eGb.setDefaultResource(0);
        this.eGb.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eGb.setForegroundDrawable(e.f.icon_play_video_ad);
        if (!ao.isEmpty(videoInfo.thumbnail_url)) {
            this.eGb.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.bOq.setOnPreparedListener(this.bxM);
        this.bOq.setOnErrorListener(this.boZ);
        this.bOq.setOnCompletionListener(this.bxL);
        this.bOq.setOnOutInfoListener(this.bxO);
        this.bOq.setOnSurfaceDestroyedListener(this.bpd);
        al.h(this.gpJ, e.d.cp_cont_i);
        this.gpJ.setText(StringUtils.translateSecondsToString(this.gpF.video_duration.intValue()));
        al.i(this.gpJ, e.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gVu = false;
            al.c(this.gVo, e.f.ad_icon_sound_close);
        } else {
            this.gVu = true;
            al.c(this.gVp, e.f.ad_icon_sound_open);
            this.gVo.setVisibility(8);
        }
        this.gVp.setOnClickListener(this.mOnClickListener);
        this.gVo.setOnClickListener(this.mOnClickListener);
        this.gpN.setOnClickListener(this.mOnClickListener);
        this.gpN.setVisibility(8);
        al.j(this.gpN, e.d.black_alpha80);
        al.h(this.gVq, e.d.cp_cont_i);
        if (this.mStyle == 1) {
            this.gpJ.setVisibility(0);
            return;
        }
        this.gpJ.setVisibility(8);
        this.gVs.setOnClickListener(this.mOnClickListener);
        this.gRz.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gRV = this.gRU.a(this.gOB, this.gRV);
        if (this.gRV != null) {
            this.gRV.setPageContext(this.mPageContext);
            this.gRV.c(this.gVw);
            this.gRV.setAdvertAppInfo(advertAppInfo);
            this.gRV.a(this.gOB);
            this.gRV.bwk();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gRV != null) {
            this.gRV.setDownloadAppCallback(cVar);
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
        this.bxL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(int i) {
        this.gVA = i;
        if (this.gpF != null && this.gpG == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gVv) >= TimeUnit.SECONDS.toSeconds(3L)) {
                if (this.gRV != null) {
                    this.gRV.bwk();
                }
                this.bOq.setVideoPath(this.gpF.video_url);
                this.bOq.start();
                this.gVy = this.bOq.getCurrentPosition();
                this.gRz.setVisibility(8);
                al.c(this.gVs, e.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.gpN.setVisibility(8);
                this.eGb.setForegroundDrawable(0);
                this.gpG = 0;
                if (this.mStyle == 1) {
                    this.gpJ.setVisibility(0);
                } else {
                    this.gpJ.setVisibility(8);
                }
            }
        }
    }

    public void performPlay() {
        uo(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bop()) {
            if (i <= 0) {
                uo(1);
                return;
            }
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gpV);
            com.baidu.adp.lib.g.e.jG().postDelayed(this.gpV, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.gpG == 1) {
            x(32, up(this.gVA), this.bOq.getCurrentPosition(), i);
            this.bOq.pause();
            aa.a(this.amy, false);
            this.gRz.setVisibility(0);
            al.c(this.gVs, e.f.icon_video_midpause);
            this.gpG = 2;
        }
    }

    public void autoContinue() {
        if (!this.gVx) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.gpG == 2) {
            this.gVA = i;
            ab(33, up(i), this.bOq.getCurrentPosition());
            this.gVy = this.bOq.getCurrentPosition();
            this.bOq.start();
            if (this.gVu) {
                aa.a(this.amy, true);
            }
            this.gRz.setVisibility(8);
            al.c(this.gVs, e.f.icon_video_midplay);
            this.gpG = 1;
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
        if (this.bOq.getCurrentPosition() > 0 && this.gpG != -1 && z) {
            int i = 32;
            int currentPosition = this.bOq.getCurrentPosition();
            if (this.bOq.getDuration() == currentPosition) {
                i = 34;
            }
            e(i, up(this.gVA), currentPosition, this.bOq.isPlaying());
        }
        bwr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwr() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gpV);
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gVB);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.bOq.stopPlayback();
        this.gpG = -1;
        aa.a(this.amy, false);
        this.eGb.setForegroundDrawable(0);
        this.eGb.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gRz.setVisibility(0);
        al.c(this.gVs, e.f.icon_video_midpause);
        this.gVt.Wm();
        this.gpN.setVisibility(8);
        if (this.gpF != null) {
            this.gpJ.setText(StringUtils.translateSecondsToString(this.gpF.video_duration.intValue()));
        }
        this.cXo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int up(int i) {
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
        return this.gpF != null ? this.gpF.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mQ(boolean z) {
        if (z) {
            if (this.cXo != null) {
                this.cXo.setVolume(1.0f, 1.0f);
            }
            al.c(this.gVp, e.f.ad_icon_sound_open);
            al.c(this.gVo, e.f.ad_icon_sound_open);
            if (this.gpG == 1) {
                aa.a(this.amy, true);
            }
        } else {
            if (this.cXo != null) {
                this.cXo.setVolume(0.0f, 0.0f);
            }
            al.c(this.gVp, e.f.ad_icon_sound_close);
            al.c(this.gVo, e.f.ad_icon_sound_close);
            aa.a(this.amy, false);
        }
        this.gVu = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.gpG;
    }

    public VideoInfo getData() {
        return this.gpF;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.gpP;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gVl && this.gVk != null && this.gVk.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aQ(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gVm = advertAppInfo;
        this.gVn = i;
        this.mPage = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.page = str;
        com.baidu.tieba.recapp.report.b a = f.a(this.gVm, 303, i, up(this.gVA), this.gpF.video_duration.intValue(), this.mDuration, -1);
        if (this.gRV != null) {
            this.gRV.e(a);
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
        if (this.gVm != null && this.gpF != null) {
            this.gVm.page = this.mPage;
            com.baidu.tieba.recapp.report.c.bwf().a(f.a(this.gVm, i, this.gVn, i2, this.gpF.video_duration.intValue(), a.hK(i3), i4));
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
                c(str, this.gVy, i3, this.mDuration, str2, uq(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gOA != null && "cpv".equals(this.gOA.gPy) && !TextUtils.isEmpty(this.gOA.gPz)) {
            new com.baidu.tieba.recapp.request.a(this.gOA.gPz).a(str, i, i2, i3, str2, str3);
        }
    }

    private String uq(int i) {
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
            this.gVk = view;
            this.gVl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gVB);
            if (this.dPT != null) {
                this.dPT.cancel();
            }
            this.gVr.setVisibility(0);
            if (this.gpG == 1) {
                al.c(this.gVs, e.f.icon_video_midplay);
                return;
            } else {
                al.c(this.gVs, e.f.icon_video_midpause);
                return;
            }
        }
        this.gVr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bws() {
        switch (this.gpG) {
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
                this.gVx = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mR(true);
                    return;
                }
                return;
            case 2:
                this.gVx = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.gVB);
                    com.baidu.adp.lib.g.e.jG().postDelayed(this.gVB, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwt() {
        if (!this.mIsInAnimation && this.dPT != null) {
            this.gVr.startAnimation(this.dPT);
            this.mIsInAnimation = true;
        }
    }

    private void bwu() {
        if (this.mPageContext != null) {
            this.dPT = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), e.a.anim_alpha_1_to_0_duration_1000);
            this.dPT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gVr.setVisibility(8);
                    DistributeVideoView.this.mIsInAnimation = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
