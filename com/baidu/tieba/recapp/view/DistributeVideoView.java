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
    private WeakReference<Context> ST;
    private g.a aZo;
    private g.f aZp;
    private g.b aZq;
    private QuickVideoView ble;
    private QuickVideoView.b bln;
    private g cpw;
    private ForeDrawableImageView dMR;
    private Animation dck;
    private VideoInfo fAj;
    private int fAk;
    private TextView fAn;
    private View fAr;
    private long fAt;
    private Runnable fAz;
    private AdCard.a fYc;
    private AdCard.f fYd;
    private String fYh;
    private ImageView gbb;
    private ViewGroup gbt;
    private d gbu;
    private e gbv;
    private View geI;
    private boolean geJ;
    private AdvertAppInfo geK;
    private int geL;
    private ImageView geM;
    private ImageView geN;
    private TextView geO;
    private View geP;
    private ImageView geQ;
    private VideoControllerView geR;
    private boolean geS;
    private long geT;
    boolean geU;
    boolean geV;
    private int geW;
    boolean geX;
    private int geY;
    private Runnable geZ;
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
        this.geJ = false;
        this.ST = null;
        this.fAk = -1;
        this.fAt = 0L;
        this.geS = false;
        this.geT = 0L;
        this.mStyle = 1;
        this.geU = false;
        this.geV = false;
        this.geX = false;
        this.geY = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fAr) {
                    DistributeVideoView.this.fAr.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.geN || view2 == DistributeVideoView.this.geM) {
                    DistributeVideoView.this.lH(DistributeVideoView.this.geS ? false : true);
                } else if (view2 == DistributeVideoView.this.gbb || view2 == DistributeVideoView.this.geQ) {
                    DistributeVideoView.this.bkp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.geK == null || !DistributeVideoView.this.geK.qt()) {
                    DistributeVideoView.this.bkp();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.geK != null) {
                        WebVideoActivity.fXW = new WebVideoActivity.a();
                        WebVideoActivity.fXW.fYg = DistributeVideoView.this.geK;
                        WebVideoActivity.fXW.fYh = "DETAIL";
                        WebVideoActivity.fXW.mPageNum = DistributeVideoView.this.geL;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.geK.VO, true, true, true, DistributeVideoView.this.fAj.video_url, DistributeVideoView.this.fAj.thumbnail_url, DistributeVideoView.this.fAj.video_width.intValue() / DistributeVideoView.this.fAj.video_height.intValue(), DistributeVideoView.this.fAj.video_duration.intValue());
                    if (DistributeVideoView.this.fYc != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fYc.fZa);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fYc.fZb);
                    }
                    if (DistributeVideoView.this.fYd != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fYd.toJsonString());
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
                        if (DistributeVideoView.this.fAk != 1) {
                            if (DistributeVideoView.this.ble.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fAk = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dMR.setVisibility(8);
                                DistributeVideoView.this.lH(DistributeVideoView.this.geS);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.geR.setPlayer(DistributeVideoView.this.ble);
                                    DistributeVideoView.this.geR.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fAj.video_duration.intValue()));
                                    DistributeVideoView.this.geR.showProgress();
                                    DistributeVideoView.this.lI(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.geZ);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.geZ, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fAt = DistributeVideoView.this.ble.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.ble.getDuration() - DistributeVideoView.this.ble.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fAn.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fAk == 1) {
                            if (DistributeVideoView.this.fAt == DistributeVideoView.this.ble.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fAt = DistributeVideoView.this.ble.getCurrentPosition();
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
        this.aZp = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.geW = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.geK != null) {
                    if (DistributeVideoView.this.geX && "DETAIL".equals(DistributeVideoView.this.geK.Vp)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sa(DistributeVideoView.this.geY), 0);
                    DistributeVideoView.this.cpw = gVar;
                    DistributeVideoView.this.cpw.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bko();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sa(DistributeVideoView.this.geY), gVar.getCurrentPosition());
                DistributeVideoView.this.dMR.setForegroundDrawable(0);
                DistributeVideoView.this.gbb.setVisibility(8);
                DistributeVideoView.this.fAr.setVisibility(0);
                return true;
            }
        };
        this.aZo = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.geT = System.currentTimeMillis();
                DistributeVideoView.this.geX = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sa(DistributeVideoView.this.geY), gVar.getDuration());
                DistributeVideoView.this.bko();
                if (DistributeVideoView.this.gbv != null) {
                    DistributeVideoView.this.gbv.bki();
                    DistributeVideoView.this.fAn.setVisibility(8);
                    DistributeVideoView.this.gbb.setVisibility(8);
                }
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fAz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fAj != null && DistributeVideoView.this.ble != null) {
                    DistributeVideoView.this.rZ(1);
                }
            }
        };
        this.geZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkq();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.geJ = false;
        this.ST = null;
        this.fAk = -1;
        this.fAt = 0L;
        this.geS = false;
        this.geT = 0L;
        this.mStyle = 1;
        this.geU = false;
        this.geV = false;
        this.geX = false;
        this.geY = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fAr) {
                    DistributeVideoView.this.fAr.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.geN || view2 == DistributeVideoView.this.geM) {
                    DistributeVideoView.this.lH(DistributeVideoView.this.geS ? false : true);
                } else if (view2 == DistributeVideoView.this.gbb || view2 == DistributeVideoView.this.geQ) {
                    DistributeVideoView.this.bkp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.geK == null || !DistributeVideoView.this.geK.qt()) {
                    DistributeVideoView.this.bkp();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.geK != null) {
                        WebVideoActivity.fXW = new WebVideoActivity.a();
                        WebVideoActivity.fXW.fYg = DistributeVideoView.this.geK;
                        WebVideoActivity.fXW.fYh = "DETAIL";
                        WebVideoActivity.fXW.mPageNum = DistributeVideoView.this.geL;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.geK.VO, true, true, true, DistributeVideoView.this.fAj.video_url, DistributeVideoView.this.fAj.thumbnail_url, DistributeVideoView.this.fAj.video_width.intValue() / DistributeVideoView.this.fAj.video_height.intValue(), DistributeVideoView.this.fAj.video_duration.intValue());
                    if (DistributeVideoView.this.fYc != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fYc.fZa);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fYc.fZb);
                    }
                    if (DistributeVideoView.this.fYd != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fYd.toJsonString());
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
                        if (DistributeVideoView.this.fAk != 1) {
                            if (DistributeVideoView.this.ble.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fAk = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dMR.setVisibility(8);
                                DistributeVideoView.this.lH(DistributeVideoView.this.geS);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.geR.setPlayer(DistributeVideoView.this.ble);
                                    DistributeVideoView.this.geR.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fAj.video_duration.intValue()));
                                    DistributeVideoView.this.geR.showProgress();
                                    DistributeVideoView.this.lI(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.geZ);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.geZ, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fAt = DistributeVideoView.this.ble.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.ble.getDuration() - DistributeVideoView.this.ble.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fAn.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fAk == 1) {
                            if (DistributeVideoView.this.fAt == DistributeVideoView.this.ble.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fAt = DistributeVideoView.this.ble.getCurrentPosition();
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
        this.aZp = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.geW = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.geK != null) {
                    if (DistributeVideoView.this.geX && "DETAIL".equals(DistributeVideoView.this.geK.Vp)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.X(i, DistributeVideoView.this.sa(DistributeVideoView.this.geY), 0);
                    DistributeVideoView.this.cpw = gVar;
                    DistributeVideoView.this.cpw.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bko();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sa(DistributeVideoView.this.geY), gVar.getCurrentPosition());
                DistributeVideoView.this.dMR.setForegroundDrawable(0);
                DistributeVideoView.this.gbb.setVisibility(8);
                DistributeVideoView.this.fAr.setVisibility(0);
                return true;
            }
        };
        this.aZo = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.geT = System.currentTimeMillis();
                DistributeVideoView.this.geX = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sa(DistributeVideoView.this.geY), gVar.getDuration());
                DistributeVideoView.this.bko();
                if (DistributeVideoView.this.gbv != null) {
                    DistributeVideoView.this.gbv.bki();
                    DistributeVideoView.this.fAn.setVisibility(8);
                    DistributeVideoView.this.gbb.setVisibility(8);
                }
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fAz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fAj != null && DistributeVideoView.this.ble != null) {
                    DistributeVideoView.this.rZ(1);
                }
            }
        };
        this.geZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkq();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.geJ = false;
        this.ST = null;
        this.fAk = -1;
        this.fAt = 0L;
        this.geS = false;
        this.geT = 0L;
        this.mStyle = 1;
        this.geU = false;
        this.geV = false;
        this.geX = false;
        this.geY = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (view2 == DistributeVideoView.this.fAr) {
                    DistributeVideoView.this.fAr.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view2 == DistributeVideoView.this.geN || view2 == DistributeVideoView.this.geM) {
                    DistributeVideoView.this.lH(DistributeVideoView.this.geS ? false : true);
                } else if (view2 == DistributeVideoView.this.gbb || view2 == DistributeVideoView.this.geQ) {
                    DistributeVideoView.this.bkp();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.geK == null || !DistributeVideoView.this.geK.qt()) {
                    DistributeVideoView.this.bkp();
                } else {
                    DistributeVideoView.this.X(2, 1, 0);
                    if (DistributeVideoView.this.geK != null) {
                        WebVideoActivity.fXW = new WebVideoActivity.a();
                        WebVideoActivity.fXW.fYg = DistributeVideoView.this.geK;
                        WebVideoActivity.fXW.fYh = "DETAIL";
                        WebVideoActivity.fXW.mPageNum = DistributeVideoView.this.geL;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.geK.VO, true, true, true, DistributeVideoView.this.fAj.video_url, DistributeVideoView.this.fAj.thumbnail_url, DistributeVideoView.this.fAj.video_width.intValue() / DistributeVideoView.this.fAj.video_height.intValue(), DistributeVideoView.this.fAj.video_duration.intValue());
                    if (DistributeVideoView.this.fYc != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.fYc.fZa);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.fYc.fZb);
                    }
                    if (DistributeVideoView.this.fYd != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.fYd.toJsonString());
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
                        if (DistributeVideoView.this.fAk != 1) {
                            if (DistributeVideoView.this.ble.getCurrentPosition() > 0) {
                                DistributeVideoView.this.fAk = 1;
                                DistributeVideoView.this.mLoadingView.setVisibility(8);
                                DistributeVideoView.this.dMR.setVisibility(8);
                                DistributeVideoView.this.lH(DistributeVideoView.this.geS);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.geR.setPlayer(DistributeVideoView.this.ble);
                                    DistributeVideoView.this.geR.Q(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.fAj.video_duration.intValue()));
                                    DistributeVideoView.this.geR.showProgress();
                                    DistributeVideoView.this.lI(true);
                                    com.baidu.adp.lib.g.e.fw().removeCallbacks(DistributeVideoView.this.geZ);
                                    com.baidu.adp.lib.g.e.fw().postDelayed(DistributeVideoView.this.geZ, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.fAt = DistributeVideoView.this.ble.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.ble.getDuration() - DistributeVideoView.this.ble.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.fAn.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.fAk == 1) {
                            if (DistributeVideoView.this.fAt == DistributeVideoView.this.ble.getCurrentPosition()) {
                                DistributeVideoView.this.mLoadingView.setVisibility(0);
                            } else {
                                DistributeVideoView.this.fAt = DistributeVideoView.this.ble.getCurrentPosition();
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
        this.aZp = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.geW = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.geK != null) {
                    if (DistributeVideoView.this.geX && "DETAIL".equals(DistributeVideoView.this.geK.Vp)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.X(i2, DistributeVideoView.this.sa(DistributeVideoView.this.geY), 0);
                    DistributeVideoView.this.cpw = gVar;
                    DistributeVideoView.this.cpw.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.aZq = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bko();
                DistributeVideoView.this.X(36, DistributeVideoView.this.sa(DistributeVideoView.this.geY), gVar.getCurrentPosition());
                DistributeVideoView.this.dMR.setForegroundDrawable(0);
                DistributeVideoView.this.gbb.setVisibility(8);
                DistributeVideoView.this.fAr.setVisibility(0);
                return true;
            }
        };
        this.aZo = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.geT = System.currentTimeMillis();
                DistributeVideoView.this.geX = true;
                DistributeVideoView.this.X(34, DistributeVideoView.this.sa(DistributeVideoView.this.geY), gVar.getDuration());
                DistributeVideoView.this.bko();
                if (DistributeVideoView.this.gbv != null) {
                    DistributeVideoView.this.gbv.bki();
                    DistributeVideoView.this.fAn.setVisibility(8);
                    DistributeVideoView.this.gbb.setVisibility(8);
                }
            }
        };
        this.bln = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.fAz = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.fAj != null && DistributeVideoView.this.ble != null) {
                    DistributeVideoView.this.rZ(1);
                }
            }
        };
        this.geZ = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bkq();
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.i.distribute_video_view, (ViewGroup) this, true);
            this.ble = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gbb = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.dMR = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.mLoadingView = this.mRootView.findViewById(d.g.distribute_loading);
            this.fAn = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.fAr = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.geO = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.geM = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.geP = this.mRootView.findViewById(d.g.distribute_control);
            this.geQ = (ImageView) this.geP.findViewById(d.g.distribute_play_icon);
            this.geN = (ImageView) this.geP.findViewById(d.g.distribute_voice);
            this.geR = (VideoControllerView) this.geP.findViewById(d.g.distribute_process);
            this.gbt = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gbu = new com.baidu.tieba.recapp.e.d(context, this.gbt);
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
        this.fYc = aVar;
    }

    public void setVideoTailFrameData(AdCard.f fVar) {
        this.fYd = fVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fAj = videoInfo;
        this.mDuration = this.fAj.video_duration.intValue() * 1000;
        this.ST = new WeakReference<>(this.mContext.getApplicationContext());
        bko();
        ak.j(this, d.C0126d.cp_bg_line_d);
        int af = l.af(this.mContext) - l.e(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            af = l.af(this.mContext);
        }
        int intValue = this.fAj.video_width.intValue() > 0 ? (this.fAj.video_height.intValue() * af) / this.fAj.video_width.intValue() : af;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = af;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        ak.i(this.gbb, d.f.icon_play_video);
        this.gbb.setVisibility(8);
        this.dMR.setDefaultErrorResource(0);
        this.dMR.setDefaultResource(0);
        this.dMR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dMR.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dMR.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ble.setOnPreparedListener(this.aZp);
        this.ble.setOnErrorListener(this.aZq);
        this.ble.setOnCompletionListener(this.aZo);
        this.ble.setOnSurfaceDestroyedListener(this.bln);
        ak.h(this.fAn, d.C0126d.cp_cont_i);
        ak.i(this.fAn, d.f.video_play_count_bg);
        this.fAn.setText(StringUtils.translateSecondsToString(this.fAj.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.geS = false;
            ak.c(this.geM, d.f.ad_icon_sound_close);
        } else {
            this.geS = true;
            ak.c(this.geN, d.f.ad_icon_sound_open);
            this.geM.setVisibility(8);
        }
        this.geN.setOnClickListener(this.mOnClickListener);
        this.geM.setOnClickListener(this.mOnClickListener);
        this.fAr.setOnClickListener(this.mOnClickListener);
        this.fAr.setVisibility(8);
        ak.j(this.fAr, d.C0126d.black_alpha80);
        ak.h(this.geO, d.C0126d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fAn.setVisibility(0);
            return;
        }
        this.fAn.setVisibility(8);
        this.geQ.setOnClickListener(this.mOnClickListener);
        this.gbb.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.fAj = videoInfo;
        this.ST = new WeakReference<>(this.mContext.getApplicationContext());
        bko();
        ak.j(this, d.C0126d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.af(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        ak.i(this.gbb, d.f.btn_icon_play_video_n);
        this.gbb.setVisibility(8);
        this.dMR.setDefaultErrorResource(0);
        this.dMR.setDefaultResource(0);
        this.dMR.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.dMR.setForegroundDrawable(d.f.icon_play_video);
        if (!an.isEmpty(videoInfo.thumbnail_url)) {
            this.dMR.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.ble.setOnPreparedListener(this.aZp);
        this.ble.setOnErrorListener(this.aZq);
        this.ble.setOnCompletionListener(this.aZo);
        this.ble.setOnSurfaceDestroyedListener(this.bln);
        ak.h(this.fAn, d.C0126d.cp_cont_i);
        this.fAn.setText(StringUtils.translateSecondsToString(this.fAj.video_duration.intValue()));
        ak.i(this.fAn, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.geS = false;
            ak.c(this.geM, d.f.ad_icon_sound_close);
        } else {
            this.geS = true;
            ak.c(this.geN, d.f.ad_icon_sound_open);
            this.geM.setVisibility(8);
        }
        this.geN.setOnClickListener(this.mOnClickListener);
        this.geM.setOnClickListener(this.mOnClickListener);
        this.fAr.setOnClickListener(this.mOnClickListener);
        this.fAr.setVisibility(8);
        ak.j(this.fAr, d.C0126d.black_alpha80);
        ak.h(this.geO, d.C0126d.cp_cont_i);
        if (this.mStyle == 1) {
            this.fAn.setVisibility(0);
            return;
        }
        this.fAn.setVisibility(8);
        this.geQ.setOnClickListener(this.mOnClickListener);
        this.gbb.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gbv = this.gbu.a(this.fYd, this.gbv);
        if (this.gbv != null) {
            this.gbv.setPageContext(this.mPageContext);
            this.gbv.setAdvertAppInfo(advertAppInfo);
            this.gbv.a(this.fYd);
            this.gbv.bkj();
        }
    }

    public void setDownloadCallback(c cVar) {
        if (this.gbv != null) {
            this.gbv.setDownloadAppCallback(cVar);
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
        this.aZo = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ(int i) {
        if (this.gbv != null) {
            this.gbv.bkj();
        }
        this.geY = i;
        if (this.fAj != null && this.fAk == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.geT) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.ble.setVideoPath(this.fAj.video_url);
                this.ble.start();
                this.geW = this.ble.getCurrentPosition();
                this.gbb.setVisibility(8);
                ak.c(this.geQ, d.f.icon_video_midplay);
                this.mLoadingView.setVisibility(0);
                this.fAr.setVisibility(8);
                this.dMR.setForegroundDrawable(0);
                this.fAk = 0;
            }
        }
    }

    public void performPlay() {
        rZ(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bcI()) {
            if (i <= 0) {
                rZ(1);
                return;
            }
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fAz);
            com.baidu.adp.lib.g.e.fw().postDelayed(this.fAz, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.fAk == 1) {
            y(32, sa(this.geY), this.ble.getCurrentPosition(), i);
            this.ble.pause();
            y.a(this.ST, false);
            this.gbb.setVisibility(0);
            ak.c(this.geQ, d.f.icon_video_midpause);
            this.fAk = 2;
        }
    }

    public void autoContinue() {
        if (!this.geV) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.fAk == 2) {
            this.geY = i;
            X(33, sa(i), this.ble.getCurrentPosition());
            this.geW = this.ble.getCurrentPosition();
            this.ble.start();
            if (this.geS) {
                y.a(this.ST, true);
            }
            this.gbb.setVisibility(8);
            ak.c(this.geQ, d.f.icon_video_midplay);
            this.fAk = 1;
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
        if (this.ble.getCurrentPosition() > 0 && this.fAk != -1) {
            int i = 32;
            if (this.ble.getDuration() == this.ble.getCurrentPosition()) {
                i = 34;
            }
            e(i, sa(this.geY), this.ble.getCurrentPosition(), this.ble.isPlaying());
        }
        bko();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.fAz);
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.geZ);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.ble.stopPlayback();
        this.fAk = -1;
        y.a(this.ST, false);
        this.dMR.setForegroundDrawable(0);
        this.dMR.setVisibility(0);
        this.mLoadingView.setVisibility(8);
        this.gbb.setVisibility(0);
        ak.c(this.geQ, d.f.icon_video_midpause);
        this.geR.Nc();
        this.fAr.setVisibility(8);
        if (this.fAj != null) {
            this.fAn.setText(StringUtils.translateSecondsToString(this.fAj.video_duration.intValue()));
        }
        this.cpw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sa(int i) {
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
        return this.fAj != null ? this.fAj.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lH(boolean z) {
        if (z) {
            if (this.cpw != null) {
                this.cpw.setVolume(1.0f, 1.0f);
            }
            ak.c(this.geN, d.f.ad_icon_sound_open);
            ak.c(this.geM, d.f.ad_icon_sound_open);
            if (this.fAk == 1) {
                y.a(this.ST, true);
            }
        } else {
            if (this.cpw != null) {
                this.cpw.setVolume(0.0f, 0.0f);
            }
            ak.c(this.geN, d.f.ad_icon_sound_close);
            ak.c(this.geM, d.f.ad_icon_sound_close);
            y.a(this.ST, false);
        }
        this.geS = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.fAk;
    }

    public VideoInfo getData() {
        return this.fAj;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.fAt;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.geJ && this.geI != null && this.geI.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.ah(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.geK = advertAppInfo;
        this.geL = i;
        this.fYh = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.Vp = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.geK, 303, i, sa(this.geY), this.fAj.video_duration.intValue(), this.mDuration, -1);
        if (this.gbv != null) {
            this.gbv.e(a);
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
        if (this.geK != null && this.fAj != null) {
            this.geK.Vp = this.fYh;
            b.bkd().a(com.baidu.tieba.recapp.report.e.a(this.geK, i, this.geL, i2, this.fAj.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.fYh)) {
                    str2 = "det";
                } else if ("FRS".equals(this.fYh)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.fYh)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.geW, i3, this.mDuration, str2, sb(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.fYc != null && "cpv".equals(this.fYc.fZa) && !TextUtils.isEmpty(this.fYc.fZb)) {
            new com.baidu.tieba.recapp.request.a(this.fYc.fZb).a(str, i, i2, i3, str2, str3);
        }
    }

    private String sb(int i) {
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
            this.geI = view2;
            this.geJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI(boolean z) {
        if (z) {
            com.baidu.adp.lib.g.e.fw().removeCallbacks(this.geZ);
            if (this.dck != null) {
                this.dck.cancel();
            }
            this.geP.setVisibility(0);
            if (this.fAk == 1) {
                ak.c(this.geQ, d.f.icon_video_midplay);
                return;
            } else {
                ak.c(this.geQ, d.f.icon_video_midpause);
                return;
            }
        }
        this.geP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        switch (this.fAk) {
            case -1:
                if (!j.gP() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.k.neterror);
                    return;
                } else if (!j.gQ() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.ca(d.k.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).tC();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.geV = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    lI(true);
                    return;
                }
                return;
            case 2:
                this.geV = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    com.baidu.adp.lib.g.e.fw().removeCallbacks(this.geZ);
                    com.baidu.adp.lib.g.e.fw().postDelayed(this.geZ, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkq() {
        if (!this.geU && this.dck != null) {
            this.geP.startAnimation(this.dck);
            this.geU = true;
        }
    }

    private void initAnimation() {
        if (this.mPageContext != null) {
            this.dck = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dck.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.geP.setVisibility(8);
                    DistributeVideoView.this.geU = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
