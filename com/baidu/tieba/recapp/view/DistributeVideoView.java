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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.d;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.recapp.activity.WebVideoActivity;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import com.baidu.tieba.recapp.e.c;
import com.baidu.tieba.recapp.e.d;
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
    private WeakReference<Context> aHP;
    private g.a bPC;
    private g.f bPD;
    private g.b bPE;
    private g cWy;
    private QuickVideoView caY;
    private QuickVideoView.b cbh;
    private Animation dIx;
    private View dtR;
    private ForeDrawableImageView eqY;
    private AdCard.a gCl;
    private AdCard.e gCm;
    private String gCq;
    private ImageView gFk;
    private View gID;
    private boolean gIE;
    private c gIF;
    private d gIG;
    private ViewGroup gIH;
    private AdvertAppInfo gII;
    private int gIJ;
    private ImageView gIK;
    private ImageView gIL;
    private TextView gIM;
    private View gIN;
    private ImageView gIO;
    private VideoControllerView gIP;
    private boolean gIQ;
    private long gIR;
    boolean gIS;
    boolean gIT;
    private int gIU;
    boolean gIV;
    private int gIW;
    private Runnable gIX;
    private VideoInfo geH;
    private int geI;
    private TextView geL;
    private View geP;
    private long geR;
    private Runnable geX;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;

    public DistributeVideoView(Context context) {
        super(context);
        this.gIE = false;
        this.aHP = null;
        this.geI = -1;
        this.geR = 0L;
        this.gIQ = false;
        this.gIR = 0L;
        this.mStyle = 1;
        this.gIS = false;
        this.gIT = false;
        this.gIV = false;
        this.gIW = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geP) {
                    DistributeVideoView.this.geP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIL || view == DistributeVideoView.this.gIK) {
                    DistributeVideoView.this.ma(DistributeVideoView.this.gIQ ? false : true);
                } else if (view == DistributeVideoView.this.gFk || view == DistributeVideoView.this.gIO) {
                    DistributeVideoView.this.bpj();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gII == null || !DistributeVideoView.this.gII.xL()) {
                    DistributeVideoView.this.bpj();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gII != null) {
                        WebVideoActivity.gCf = new WebVideoActivity.a();
                        WebVideoActivity.gCf.gCp = DistributeVideoView.this.gII;
                        WebVideoActivity.gCf.gCq = "DETAIL";
                        WebVideoActivity.gCf.mPageNum = DistributeVideoView.this.gIJ;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gII.aKI, true, true, true, DistributeVideoView.this.geH.video_url, DistributeVideoView.this.geH.thumbnail_url, DistributeVideoView.this.geH.video_width.intValue() / DistributeVideoView.this.geH.video_height.intValue(), DistributeVideoView.this.geH.video_duration.intValue());
                    if (DistributeVideoView.this.gCl != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gCl.gDj);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gCl.gDk);
                    }
                    if (DistributeVideoView.this.gCm != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gCm.toJsonString());
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
                        if (DistributeVideoView.this.geI != 1) {
                            if (DistributeVideoView.this.caY.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geI = 1;
                                DistributeVideoView.this.dtR.setVisibility(8);
                                DistributeVideoView.this.eqY.setVisibility(8);
                                DistributeVideoView.this.ma(DistributeVideoView.this.gIQ);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIP.setPlayer(DistributeVideoView.this.caY);
                                    DistributeVideoView.this.gIP.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geH.video_duration.intValue()));
                                    DistributeVideoView.this.gIP.showProgress();
                                    DistributeVideoView.this.mb(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gIX);
                                    e.ns().postDelayed(DistributeVideoView.this.gIX, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geR = DistributeVideoView.this.caY.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caY.getDuration() - DistributeVideoView.this.caY.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geI == 1) {
                            if (DistributeVideoView.this.geR == DistributeVideoView.this.caY.getCurrentPosition()) {
                                DistributeVideoView.this.dtR.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geR = DistributeVideoView.this.caY.getCurrentPosition();
                                DistributeVideoView.this.dtR.setVisibility(8);
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
        this.bPD = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gIU = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gII != null) {
                    if (DistributeVideoView.this.gIV && "DETAIL".equals(DistributeVideoView.this.gII.aKi)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.aj(i, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), 0);
                    DistributeVideoView.this.cWy = gVar;
                    DistributeVideoView.this.cWy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpi();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), gVar.getCurrentPosition());
                DistributeVideoView.this.eqY.setForegroundDrawable(0);
                DistributeVideoView.this.gFk.setVisibility(8);
                DistributeVideoView.this.geP.setVisibility(0);
                return true;
            }
        };
        this.bPC = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIR = System.currentTimeMillis();
                DistributeVideoView.this.gIV = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), gVar.getDuration());
                DistributeVideoView.this.bpi();
                if (DistributeVideoView.this.gIG != null) {
                    DistributeVideoView.this.gIG.bpc();
                    DistributeVideoView.this.geL.setVisibility(8);
                    DistributeVideoView.this.gFk.setVisibility(8);
                }
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geH != null && DistributeVideoView.this.caY != null) {
                    DistributeVideoView.this.uz(1);
                }
            }
        };
        this.gIX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpk();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIE = false;
        this.aHP = null;
        this.geI = -1;
        this.geR = 0L;
        this.gIQ = false;
        this.gIR = 0L;
        this.mStyle = 1;
        this.gIS = false;
        this.gIT = false;
        this.gIV = false;
        this.gIW = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geP) {
                    DistributeVideoView.this.geP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIL || view == DistributeVideoView.this.gIK) {
                    DistributeVideoView.this.ma(DistributeVideoView.this.gIQ ? false : true);
                } else if (view == DistributeVideoView.this.gFk || view == DistributeVideoView.this.gIO) {
                    DistributeVideoView.this.bpj();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gII == null || !DistributeVideoView.this.gII.xL()) {
                    DistributeVideoView.this.bpj();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gII != null) {
                        WebVideoActivity.gCf = new WebVideoActivity.a();
                        WebVideoActivity.gCf.gCp = DistributeVideoView.this.gII;
                        WebVideoActivity.gCf.gCq = "DETAIL";
                        WebVideoActivity.gCf.mPageNum = DistributeVideoView.this.gIJ;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gII.aKI, true, true, true, DistributeVideoView.this.geH.video_url, DistributeVideoView.this.geH.thumbnail_url, DistributeVideoView.this.geH.video_width.intValue() / DistributeVideoView.this.geH.video_height.intValue(), DistributeVideoView.this.geH.video_duration.intValue());
                    if (DistributeVideoView.this.gCl != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gCl.gDj);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gCl.gDk);
                    }
                    if (DistributeVideoView.this.gCm != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gCm.toJsonString());
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
                        if (DistributeVideoView.this.geI != 1) {
                            if (DistributeVideoView.this.caY.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geI = 1;
                                DistributeVideoView.this.dtR.setVisibility(8);
                                DistributeVideoView.this.eqY.setVisibility(8);
                                DistributeVideoView.this.ma(DistributeVideoView.this.gIQ);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIP.setPlayer(DistributeVideoView.this.caY);
                                    DistributeVideoView.this.gIP.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geH.video_duration.intValue()));
                                    DistributeVideoView.this.gIP.showProgress();
                                    DistributeVideoView.this.mb(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gIX);
                                    e.ns().postDelayed(DistributeVideoView.this.gIX, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geR = DistributeVideoView.this.caY.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caY.getDuration() - DistributeVideoView.this.caY.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geI == 1) {
                            if (DistributeVideoView.this.geR == DistributeVideoView.this.caY.getCurrentPosition()) {
                                DistributeVideoView.this.dtR.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geR = DistributeVideoView.this.caY.getCurrentPosition();
                                DistributeVideoView.this.dtR.setVisibility(8);
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
        this.bPD = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gIU = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gII != null) {
                    if (DistributeVideoView.this.gIV && "DETAIL".equals(DistributeVideoView.this.gII.aKi)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.aj(i, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), 0);
                    DistributeVideoView.this.cWy = gVar;
                    DistributeVideoView.this.cWy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpi();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), gVar.getCurrentPosition());
                DistributeVideoView.this.eqY.setForegroundDrawable(0);
                DistributeVideoView.this.gFk.setVisibility(8);
                DistributeVideoView.this.geP.setVisibility(0);
                return true;
            }
        };
        this.bPC = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIR = System.currentTimeMillis();
                DistributeVideoView.this.gIV = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), gVar.getDuration());
                DistributeVideoView.this.bpi();
                if (DistributeVideoView.this.gIG != null) {
                    DistributeVideoView.this.gIG.bpc();
                    DistributeVideoView.this.geL.setVisibility(8);
                    DistributeVideoView.this.gFk.setVisibility(8);
                }
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geH != null && DistributeVideoView.this.caY != null) {
                    DistributeVideoView.this.uz(1);
                }
            }
        };
        this.gIX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpk();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIE = false;
        this.aHP = null;
        this.geI = -1;
        this.geR = 0L;
        this.gIQ = false;
        this.gIR = 0L;
        this.mStyle = 1;
        this.gIS = false;
        this.gIT = false;
        this.gIV = false;
        this.gIW = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geP) {
                    DistributeVideoView.this.geP.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIL || view == DistributeVideoView.this.gIK) {
                    DistributeVideoView.this.ma(DistributeVideoView.this.gIQ ? false : true);
                } else if (view == DistributeVideoView.this.gFk || view == DistributeVideoView.this.gIO) {
                    DistributeVideoView.this.bpj();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gII == null || !DistributeVideoView.this.gII.xL()) {
                    DistributeVideoView.this.bpj();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gII != null) {
                        WebVideoActivity.gCf = new WebVideoActivity.a();
                        WebVideoActivity.gCf.gCp = DistributeVideoView.this.gII;
                        WebVideoActivity.gCf.gCq = "DETAIL";
                        WebVideoActivity.gCf.mPageNum = DistributeVideoView.this.gIJ;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gII.aKI, true, true, true, DistributeVideoView.this.geH.video_url, DistributeVideoView.this.geH.thumbnail_url, DistributeVideoView.this.geH.video_width.intValue() / DistributeVideoView.this.geH.video_height.intValue(), DistributeVideoView.this.geH.video_duration.intValue());
                    if (DistributeVideoView.this.gCl != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gCl.gDj);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gCl.gDk);
                    }
                    if (DistributeVideoView.this.gCm != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gCm.toJsonString());
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
                        if (DistributeVideoView.this.geI != 1) {
                            if (DistributeVideoView.this.caY.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geI = 1;
                                DistributeVideoView.this.dtR.setVisibility(8);
                                DistributeVideoView.this.eqY.setVisibility(8);
                                DistributeVideoView.this.ma(DistributeVideoView.this.gIQ);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIP.setPlayer(DistributeVideoView.this.caY);
                                    DistributeVideoView.this.gIP.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geH.video_duration.intValue()));
                                    DistributeVideoView.this.gIP.showProgress();
                                    DistributeVideoView.this.mb(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gIX);
                                    e.ns().postDelayed(DistributeVideoView.this.gIX, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geR = DistributeVideoView.this.caY.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caY.getDuration() - DistributeVideoView.this.caY.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geL.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geI == 1) {
                            if (DistributeVideoView.this.geR == DistributeVideoView.this.caY.getCurrentPosition()) {
                                DistributeVideoView.this.dtR.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geR = DistributeVideoView.this.caY.getCurrentPosition();
                                DistributeVideoView.this.dtR.setVisibility(8);
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
        this.bPD = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gIU = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gII != null) {
                    if (DistributeVideoView.this.gIV && "DETAIL".equals(DistributeVideoView.this.gII.aKi)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.aj(i2, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), 0);
                    DistributeVideoView.this.cWy = gVar;
                    DistributeVideoView.this.cWy.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPE = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bpi();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), gVar.getCurrentPosition());
                DistributeVideoView.this.eqY.setForegroundDrawable(0);
                DistributeVideoView.this.gFk.setVisibility(8);
                DistributeVideoView.this.geP.setVisibility(0);
                return true;
            }
        };
        this.bPC = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIR = System.currentTimeMillis();
                DistributeVideoView.this.gIV = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uA(DistributeVideoView.this.gIW), gVar.getDuration());
                DistributeVideoView.this.bpi();
                if (DistributeVideoView.this.gIG != null) {
                    DistributeVideoView.this.gIG.bpc();
                    DistributeVideoView.this.geL.setVisibility(8);
                    DistributeVideoView.this.gFk.setVisibility(8);
                }
            }
        };
        this.cbh = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geH != null && DistributeVideoView.this.caY != null) {
                    DistributeVideoView.this.uz(1);
                }
            }
        };
        this.gIX = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpk();
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.caY = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gFk = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.eqY = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.dtR = this.mRootView.findViewById(d.g.distribute_loading);
            this.geL = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.geP = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gIM = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gIK = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gIN = this.mRootView.findViewById(d.g.distribute_control);
            this.gIO = (ImageView) this.gIN.findViewById(d.g.distribute_play_icon);
            this.gIL = (ImageView) this.gIN.findViewById(d.g.distribute_voice);
            this.gIP = (VideoControllerView) this.gIN.findViewById(d.g.distribute_process);
            this.gIH = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gIF = new c(context, this.gIH);
        }
    }

    private boolean bhI() {
        return this.mStyle == 1 ? q.bhI() : j.oK();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bpl();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gCl = aVar;
    }

    public void setVideoTailFrameData(AdCard.e eVar) {
        this.gCm = eVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geH = videoInfo;
        this.mDuration = this.geH.video_duration.intValue() * 1000;
        this.aHP = new WeakReference<>(this.mContext.getApplicationContext());
        bpi();
        aj.t(this, d.C0140d.cp_bg_line_d);
        int ao = l.ao(this.mContext) - l.t(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            ao = l.ao(this.mContext);
        }
        int intValue = this.geH.video_width.intValue() > 0 ? (this.geH.video_height.intValue() * ao) / this.geH.video_width.intValue() : ao;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ao;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        aj.s(this.gFk, d.f.icon_play_video);
        this.gFk.setVisibility(8);
        this.eqY.setDefaultErrorResource(0);
        this.eqY.setDefaultResource(0);
        this.eqY.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eqY.setForegroundDrawable(d.f.icon_play_video);
        if (!am.isEmpty(videoInfo.thumbnail_url)) {
            this.eqY.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.caY.setOnPreparedListener(this.bPD);
        this.caY.setOnErrorListener(this.bPE);
        this.caY.setOnCompletionListener(this.bPC);
        this.caY.setOnSurfaceDestroyedListener(this.cbh);
        aj.r(this.geL, d.C0140d.cp_cont_i);
        aj.s(this.geL, d.f.video_play_count_bg);
        this.geL.setText(StringUtils.translateSecondsToString(this.geH.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gIQ = false;
            aj.c(this.gIK, d.f.ad_icon_sound_close);
        } else {
            this.gIQ = true;
            aj.c(this.gIL, d.f.ad_icon_sound_open);
            this.gIK.setVisibility(8);
        }
        this.gIL.setOnClickListener(this.mOnClickListener);
        this.gIK.setOnClickListener(this.mOnClickListener);
        this.geP.setOnClickListener(this.mOnClickListener);
        this.geP.setVisibility(8);
        aj.t(this.geP, d.C0140d.black_alpha80);
        aj.r(this.gIM, d.C0140d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geL.setVisibility(0);
            return;
        }
        this.geL.setVisibility(8);
        this.gIO.setOnClickListener(this.mOnClickListener);
        this.gFk.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geH = videoInfo;
        this.aHP = new WeakReference<>(this.mContext.getApplicationContext());
        bpi();
        aj.t(this, d.C0140d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ao(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        aj.s(this.gFk, d.f.btn_icon_play_video_n);
        this.gFk.setVisibility(8);
        this.eqY.setDefaultErrorResource(0);
        this.eqY.setDefaultResource(0);
        this.eqY.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eqY.setForegroundDrawable(d.f.icon_play_video);
        if (!am.isEmpty(videoInfo.thumbnail_url)) {
            this.eqY.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.caY.setOnPreparedListener(this.bPD);
        this.caY.setOnErrorListener(this.bPE);
        this.caY.setOnCompletionListener(this.bPC);
        this.caY.setOnSurfaceDestroyedListener(this.cbh);
        aj.r(this.geL, d.C0140d.cp_cont_i);
        this.geL.setText(StringUtils.translateSecondsToString(this.geH.video_duration.intValue()));
        aj.s(this.geL, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gIQ = false;
            aj.c(this.gIK, d.f.ad_icon_sound_close);
        } else {
            this.gIQ = true;
            aj.c(this.gIL, d.f.ad_icon_sound_open);
            this.gIK.setVisibility(8);
        }
        this.gIL.setOnClickListener(this.mOnClickListener);
        this.gIK.setOnClickListener(this.mOnClickListener);
        this.geP.setOnClickListener(this.mOnClickListener);
        this.geP.setVisibility(8);
        aj.t(this.geP, d.C0140d.black_alpha80);
        aj.r(this.gIM, d.C0140d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geL.setVisibility(0);
            return;
        }
        this.geL.setVisibility(8);
        this.gIO.setOnClickListener(this.mOnClickListener);
        this.gFk.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gIG = this.gIF.a(this.gCm, this.gIG);
        if (this.gIG != null) {
            this.gIG.setPageContext(this.mPageContext);
            this.gIG.setAdvertAppInfo(advertAppInfo);
            this.gIG.a(this.gCm);
            this.gIG.bpd();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gIG != null) {
            this.gIG.setDownloadAppCallback(cVar);
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
            k(this.mRootView, i2, i3);
            return true;
        }
        k(this.mRootView, (intValue * dimensionPixelOffset) / intValue2, dimensionPixelOffset);
        return true;
    }

    protected void k(View view, int i, int i2) {
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
        this.bPC = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(int i) {
        if (this.gIG != null) {
            this.gIG.bpd();
        }
        this.gIW = i;
        if (this.geH != null && this.geI == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gIR) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.caY.setVideoPath(this.geH.video_url);
                this.caY.start();
                this.gIU = this.caY.getCurrentPosition();
                this.gFk.setVisibility(8);
                aj.c(this.gIO, d.f.icon_video_midplay);
                this.dtR.setVisibility(0);
                this.geP.setVisibility(8);
                this.eqY.setForegroundDrawable(0);
                this.geI = 0;
            }
        }
    }

    public void performPlay() {
        uz(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bhI()) {
            if (i <= 0) {
                uz(1);
                return;
            }
            e.ns().removeCallbacks(this.geX);
            e.ns().postDelayed(this.geX, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.geI == 1) {
            F(32, uA(this.gIW), this.caY.getCurrentPosition(), i);
            this.caY.pause();
            y.a(this.aHP, false);
            this.gFk.setVisibility(0);
            aj.c(this.gIO, d.f.icon_video_midpause);
            this.geI = 2;
        }
    }

    public void autoContinue() {
        if (!this.gIT) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.geI == 2) {
            this.gIW = i;
            aj(33, uA(i), this.caY.getCurrentPosition());
            this.gIU = this.caY.getCurrentPosition();
            this.caY.start();
            if (this.gIQ) {
                y.a(this.aHP, true);
            }
            this.gFk.setVisibility(8);
            aj.c(this.gIO, d.f.icon_video_midplay);
            this.geI = 1;
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
        if (this.caY.getCurrentPosition() > 0 && this.geI != -1) {
            int i = 32;
            if (this.caY.getDuration() == this.caY.getCurrentPosition()) {
                i = 34;
            }
            f(i, uA(this.gIW), this.caY.getCurrentPosition(), this.caY.isPlaying());
        }
        bpi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpi() {
        e.ns().removeCallbacks(this.geX);
        e.ns().removeCallbacks(this.gIX);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.caY.stopPlayback();
        this.geI = -1;
        y.a(this.aHP, false);
        this.eqY.setForegroundDrawable(0);
        this.eqY.setVisibility(0);
        this.dtR.setVisibility(8);
        this.gFk.setVisibility(0);
        aj.c(this.gIO, d.f.icon_video_midpause);
        this.gIP.UD();
        this.geP.setVisibility(8);
        if (this.geH != null) {
            this.geL.setText(StringUtils.translateSecondsToString(this.geH.video_duration.intValue()));
        }
        this.cWy = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uA(int i) {
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
        return this.geH != null ? this.geH.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(boolean z) {
        if (z) {
            if (this.cWy != null) {
                this.cWy.setVolume(1.0f, 1.0f);
            }
            aj.c(this.gIL, d.f.ad_icon_sound_open);
            aj.c(this.gIK, d.f.ad_icon_sound_open);
            if (this.geI == 1) {
                y.a(this.aHP, true);
            }
        } else {
            if (this.cWy != null) {
                this.cWy.setVolume(0.0f, 0.0f);
            }
            aj.c(this.gIL, d.f.ad_icon_sound_close);
            aj.c(this.gIK, d.f.ad_icon_sound_close);
            y.a(this.aHP, false);
        }
        this.gIQ = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.geI;
    }

    public VideoInfo getData() {
        return this.geH;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.geR;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gIE && this.gID != null && this.gID.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aq(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gII = advertAppInfo;
        this.gIJ = i;
        this.gCq = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.aKi = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gII, 303, i, uA(this.gIW), this.geH.video_duration.intValue(), this.mDuration, -1);
        if (this.gIG != null) {
            this.gIG.e(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i, int i2, int i3) {
        F(i, i2, i3, -1);
    }

    private void f(int i, int i2, int i3, boolean z) {
        a(i, i2, i3, -1, z);
    }

    private void F(int i, int i2, int i3, int i4) {
        a(i, i2, i3, i4, true);
    }

    private void a(int i, int i2, int i3, int i4, boolean z) {
        String str;
        String str2;
        if (this.gII != null && this.geH != null) {
            this.gII.aKi = this.gCq;
            b.boX().a(com.baidu.tieba.recapp.report.e.a(this.gII, i, this.gIJ, i2, this.geH.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.gCq)) {
                    str2 = "det";
                } else if ("FRS".equals(this.gCq)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.gCq)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gIU, i3, this.mDuration, str2, uB(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gCl != null && "cpv".equals(this.gCl.gDj) && !TextUtils.isEmpty(this.gCl.gDk)) {
            new com.baidu.tieba.recapp.request.a(this.gCl.gDk).a(str, i, i2, i3, str2, str3);
        }
    }

    private String uB(int i) {
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
            this.gID = view;
            this.gIE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(boolean z) {
        if (z) {
            e.ns().removeCallbacks(this.gIX);
            if (this.dIx != null) {
                this.dIx.cancel();
            }
            this.gIN.setVisibility(0);
            if (this.geI == 1) {
                aj.c(this.gIO, d.f.icon_video_midplay);
                return;
            } else {
                aj.c(this.gIO, d.f.icon_video_midpause);
                return;
            }
        }
        this.gIN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        switch (this.geI) {
            case -1:
                if (!j.oJ() && this.mPageContext != null) {
                    this.mPageContext.showToast(d.j.neterror);
                    return;
                } else if (!j.oK() && this.mPageContext != null) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
                    aVar.fb(d.j.play_video_mobile_tip);
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
                    aVar.b(this.mPageContext).AU();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gIT = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mb(true);
                    return;
                }
                return;
            case 2:
                this.gIT = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    e.ns().removeCallbacks(this.gIX);
                    e.ns().postDelayed(this.gIX, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpk() {
        if (!this.gIS && this.dIx != null) {
            this.gIN.startAnimation(this.dIx);
            this.gIS = true;
        }
    }

    private void bpl() {
        if (this.mPageContext != null) {
            this.dIx = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dIx.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gIN.setVisibility(8);
                    DistributeVideoView.this.gIS = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
