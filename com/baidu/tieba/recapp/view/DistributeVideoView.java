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
    private WeakReference<Context> aHE;
    private g.a bPp;
    private g.f bPq;
    private g.b bPr;
    private g cWm;
    private QuickVideoView caM;
    private QuickVideoView.b caV;
    private Animation dIl;
    private View dtF;
    private ForeDrawableImageView eqM;
    private AdCard.a gBW;
    private AdCard.e gBX;
    private String gCb;
    private ImageView gEV;
    private VideoControllerView gIA;
    private boolean gIB;
    private long gIC;
    boolean gID;
    boolean gIE;
    private int gIF;
    boolean gIG;
    private int gIH;
    private Runnable gII;
    private View gIo;
    private boolean gIp;
    private c gIq;
    private d gIr;
    private ViewGroup gIs;
    private AdvertAppInfo gIt;
    private int gIu;
    private ImageView gIv;
    private ImageView gIw;
    private TextView gIx;
    private View gIy;
    private ImageView gIz;
    private TextView geA;
    private View geE;
    private long geG;
    private Runnable geM;
    private VideoInfo gew;
    private int gex;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;

    public DistributeVideoView(Context context) {
        super(context);
        this.gIp = false;
        this.aHE = null;
        this.gex = -1;
        this.geG = 0L;
        this.gIB = false;
        this.gIC = 0L;
        this.mStyle = 1;
        this.gID = false;
        this.gIE = false;
        this.gIG = false;
        this.gIH = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geE) {
                    DistributeVideoView.this.geE.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIw || view == DistributeVideoView.this.gIv) {
                    DistributeVideoView.this.ma(DistributeVideoView.this.gIB ? false : true);
                } else if (view == DistributeVideoView.this.gEV || view == DistributeVideoView.this.gIz) {
                    DistributeVideoView.this.bpi();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gIt == null || !DistributeVideoView.this.gIt.xL()) {
                    DistributeVideoView.this.bpi();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gIt != null) {
                        WebVideoActivity.gBQ = new WebVideoActivity.a();
                        WebVideoActivity.gBQ.gCa = DistributeVideoView.this.gIt;
                        WebVideoActivity.gBQ.gCb = "DETAIL";
                        WebVideoActivity.gBQ.mPageNum = DistributeVideoView.this.gIu;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gIt.aKx, true, true, true, DistributeVideoView.this.gew.video_url, DistributeVideoView.this.gew.thumbnail_url, DistributeVideoView.this.gew.video_width.intValue() / DistributeVideoView.this.gew.video_height.intValue(), DistributeVideoView.this.gew.video_duration.intValue());
                    if (DistributeVideoView.this.gBW != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gBW.gCU);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gBW.gCV);
                    }
                    if (DistributeVideoView.this.gBX != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gBX.toJsonString());
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
                        if (DistributeVideoView.this.gex != 1) {
                            if (DistributeVideoView.this.caM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gex = 1;
                                DistributeVideoView.this.dtF.setVisibility(8);
                                DistributeVideoView.this.eqM.setVisibility(8);
                                DistributeVideoView.this.ma(DistributeVideoView.this.gIB);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIA.setPlayer(DistributeVideoView.this.caM);
                                    DistributeVideoView.this.gIA.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gew.video_duration.intValue()));
                                    DistributeVideoView.this.gIA.showProgress();
                                    DistributeVideoView.this.mb(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gII);
                                    e.ns().postDelayed(DistributeVideoView.this.gII, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geG = DistributeVideoView.this.caM.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caM.getDuration() - DistributeVideoView.this.caM.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geA.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gex == 1) {
                            if (DistributeVideoView.this.geG == DistributeVideoView.this.caM.getCurrentPosition()) {
                                DistributeVideoView.this.dtF.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geG = DistributeVideoView.this.caM.getCurrentPosition();
                                DistributeVideoView.this.dtF.setVisibility(8);
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
        this.bPq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gIF = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gIt != null) {
                    if (DistributeVideoView.this.gIG && "DETAIL".equals(DistributeVideoView.this.gIt.aJX)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.aj(i, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), 0);
                    DistributeVideoView.this.cWm = gVar;
                    DistributeVideoView.this.cWm.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bph();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), gVar.getCurrentPosition());
                DistributeVideoView.this.eqM.setForegroundDrawable(0);
                DistributeVideoView.this.gEV.setVisibility(8);
                DistributeVideoView.this.geE.setVisibility(0);
                return true;
            }
        };
        this.bPp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIC = System.currentTimeMillis();
                DistributeVideoView.this.gIG = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), gVar.getDuration());
                DistributeVideoView.this.bph();
                if (DistributeVideoView.this.gIr != null) {
                    DistributeVideoView.this.gIr.bpb();
                    DistributeVideoView.this.geA.setVisibility(8);
                    DistributeVideoView.this.gEV.setVisibility(8);
                }
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gew != null && DistributeVideoView.this.caM != null) {
                    DistributeVideoView.this.uA(1);
                }
            }
        };
        this.gII = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpj();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIp = false;
        this.aHE = null;
        this.gex = -1;
        this.geG = 0L;
        this.gIB = false;
        this.gIC = 0L;
        this.mStyle = 1;
        this.gID = false;
        this.gIE = false;
        this.gIG = false;
        this.gIH = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geE) {
                    DistributeVideoView.this.geE.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIw || view == DistributeVideoView.this.gIv) {
                    DistributeVideoView.this.ma(DistributeVideoView.this.gIB ? false : true);
                } else if (view == DistributeVideoView.this.gEV || view == DistributeVideoView.this.gIz) {
                    DistributeVideoView.this.bpi();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gIt == null || !DistributeVideoView.this.gIt.xL()) {
                    DistributeVideoView.this.bpi();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gIt != null) {
                        WebVideoActivity.gBQ = new WebVideoActivity.a();
                        WebVideoActivity.gBQ.gCa = DistributeVideoView.this.gIt;
                        WebVideoActivity.gBQ.gCb = "DETAIL";
                        WebVideoActivity.gBQ.mPageNum = DistributeVideoView.this.gIu;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gIt.aKx, true, true, true, DistributeVideoView.this.gew.video_url, DistributeVideoView.this.gew.thumbnail_url, DistributeVideoView.this.gew.video_width.intValue() / DistributeVideoView.this.gew.video_height.intValue(), DistributeVideoView.this.gew.video_duration.intValue());
                    if (DistributeVideoView.this.gBW != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gBW.gCU);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gBW.gCV);
                    }
                    if (DistributeVideoView.this.gBX != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gBX.toJsonString());
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
                        if (DistributeVideoView.this.gex != 1) {
                            if (DistributeVideoView.this.caM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gex = 1;
                                DistributeVideoView.this.dtF.setVisibility(8);
                                DistributeVideoView.this.eqM.setVisibility(8);
                                DistributeVideoView.this.ma(DistributeVideoView.this.gIB);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIA.setPlayer(DistributeVideoView.this.caM);
                                    DistributeVideoView.this.gIA.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gew.video_duration.intValue()));
                                    DistributeVideoView.this.gIA.showProgress();
                                    DistributeVideoView.this.mb(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gII);
                                    e.ns().postDelayed(DistributeVideoView.this.gII, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geG = DistributeVideoView.this.caM.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caM.getDuration() - DistributeVideoView.this.caM.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geA.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gex == 1) {
                            if (DistributeVideoView.this.geG == DistributeVideoView.this.caM.getCurrentPosition()) {
                                DistributeVideoView.this.dtF.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geG = DistributeVideoView.this.caM.getCurrentPosition();
                                DistributeVideoView.this.dtF.setVisibility(8);
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
        this.bPq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gIF = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gIt != null) {
                    if (DistributeVideoView.this.gIG && "DETAIL".equals(DistributeVideoView.this.gIt.aJX)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.aj(i, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), 0);
                    DistributeVideoView.this.cWm = gVar;
                    DistributeVideoView.this.cWm.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bph();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), gVar.getCurrentPosition());
                DistributeVideoView.this.eqM.setForegroundDrawable(0);
                DistributeVideoView.this.gEV.setVisibility(8);
                DistributeVideoView.this.geE.setVisibility(0);
                return true;
            }
        };
        this.bPp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIC = System.currentTimeMillis();
                DistributeVideoView.this.gIG = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), gVar.getDuration());
                DistributeVideoView.this.bph();
                if (DistributeVideoView.this.gIr != null) {
                    DistributeVideoView.this.gIr.bpb();
                    DistributeVideoView.this.geA.setVisibility(8);
                    DistributeVideoView.this.gEV.setVisibility(8);
                }
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gew != null && DistributeVideoView.this.caM != null) {
                    DistributeVideoView.this.uA(1);
                }
            }
        };
        this.gII = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpj();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIp = false;
        this.aHE = null;
        this.gex = -1;
        this.geG = 0L;
        this.gIB = false;
        this.gIC = 0L;
        this.mStyle = 1;
        this.gID = false;
        this.gIE = false;
        this.gIG = false;
        this.gIH = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geE) {
                    DistributeVideoView.this.geE.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIw || view == DistributeVideoView.this.gIv) {
                    DistributeVideoView.this.ma(DistributeVideoView.this.gIB ? false : true);
                } else if (view == DistributeVideoView.this.gEV || view == DistributeVideoView.this.gIz) {
                    DistributeVideoView.this.bpi();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gIt == null || !DistributeVideoView.this.gIt.xL()) {
                    DistributeVideoView.this.bpi();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gIt != null) {
                        WebVideoActivity.gBQ = new WebVideoActivity.a();
                        WebVideoActivity.gBQ.gCa = DistributeVideoView.this.gIt;
                        WebVideoActivity.gBQ.gCb = "DETAIL";
                        WebVideoActivity.gBQ.mPageNum = DistributeVideoView.this.gIu;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gIt.aKx, true, true, true, DistributeVideoView.this.gew.video_url, DistributeVideoView.this.gew.thumbnail_url, DistributeVideoView.this.gew.video_width.intValue() / DistributeVideoView.this.gew.video_height.intValue(), DistributeVideoView.this.gew.video_duration.intValue());
                    if (DistributeVideoView.this.gBW != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gBW.gCU);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gBW.gCV);
                    }
                    if (DistributeVideoView.this.gBX != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gBX.toJsonString());
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
                        if (DistributeVideoView.this.gex != 1) {
                            if (DistributeVideoView.this.caM.getCurrentPosition() > 0) {
                                DistributeVideoView.this.gex = 1;
                                DistributeVideoView.this.dtF.setVisibility(8);
                                DistributeVideoView.this.eqM.setVisibility(8);
                                DistributeVideoView.this.ma(DistributeVideoView.this.gIB);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIA.setPlayer(DistributeVideoView.this.caM);
                                    DistributeVideoView.this.gIA.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.gew.video_duration.intValue()));
                                    DistributeVideoView.this.gIA.showProgress();
                                    DistributeVideoView.this.mb(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gII);
                                    e.ns().postDelayed(DistributeVideoView.this.gII, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geG = DistributeVideoView.this.caM.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caM.getDuration() - DistributeVideoView.this.caM.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geA.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.gex == 1) {
                            if (DistributeVideoView.this.geG == DistributeVideoView.this.caM.getCurrentPosition()) {
                                DistributeVideoView.this.dtF.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geG = DistributeVideoView.this.caM.getCurrentPosition();
                                DistributeVideoView.this.dtF.setVisibility(8);
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
        this.bPq = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gIF = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gIt != null) {
                    if (DistributeVideoView.this.gIG && "DETAIL".equals(DistributeVideoView.this.gIt.aJX)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.aj(i2, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), 0);
                    DistributeVideoView.this.cWm = gVar;
                    DistributeVideoView.this.cWm.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPr = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bph();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), gVar.getCurrentPosition());
                DistributeVideoView.this.eqM.setForegroundDrawable(0);
                DistributeVideoView.this.gEV.setVisibility(8);
                DistributeVideoView.this.geE.setVisibility(0);
                return true;
            }
        };
        this.bPp = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIC = System.currentTimeMillis();
                DistributeVideoView.this.gIG = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uB(DistributeVideoView.this.gIH), gVar.getDuration());
                DistributeVideoView.this.bph();
                if (DistributeVideoView.this.gIr != null) {
                    DistributeVideoView.this.gIr.bpb();
                    DistributeVideoView.this.geA.setVisibility(8);
                    DistributeVideoView.this.gEV.setVisibility(8);
                }
            }
        };
        this.caV = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.geM = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.gew != null && DistributeVideoView.this.caM != null) {
                    DistributeVideoView.this.uA(1);
                }
            }
        };
        this.gII = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpj();
            }
        };
        init(context);
    }

    private void init(Context context) {
        if (context != null) {
            this.mContext = context;
            this.mRootView = LayoutInflater.from(context).inflate(d.h.distribute_video_view, (ViewGroup) this, true);
            this.caM = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gEV = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.eqM = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.dtF = this.mRootView.findViewById(d.g.distribute_loading);
            this.geA = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.geE = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gIx = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gIv = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gIy = this.mRootView.findViewById(d.g.distribute_control);
            this.gIz = (ImageView) this.gIy.findViewById(d.g.distribute_play_icon);
            this.gIw = (ImageView) this.gIy.findViewById(d.g.distribute_voice);
            this.gIA = (VideoControllerView) this.gIy.findViewById(d.g.distribute_process);
            this.gIs = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gIq = new c(context, this.gIs);
        }
    }

    private boolean bhH() {
        return this.mStyle == 1 ? q.bhH() : j.oK();
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        if (i != 1 && i != 2) {
            BdLog.e("DistributeVideoView: invalid video style!");
            return;
        }
        this.mStyle = i;
        if (tbPageContext != null) {
            this.mPageContext = tbPageContext;
            bpk();
        }
        setData(videoInfo);
    }

    public void setChargeInfo(AdCard.a aVar) {
        this.gBW = aVar;
    }

    public void setVideoTailFrameData(AdCard.e eVar) {
        this.gBX = eVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gew = videoInfo;
        this.mDuration = this.gew.video_duration.intValue() * 1000;
        this.aHE = new WeakReference<>(this.mContext.getApplicationContext());
        bph();
        aj.t(this, d.C0141d.cp_bg_line_d);
        int ao = l.ao(this.mContext) - l.t(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            ao = l.ao(this.mContext);
        }
        int intValue = this.gew.video_width.intValue() > 0 ? (this.gew.video_height.intValue() * ao) / this.gew.video_width.intValue() : ao;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ao;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        aj.s(this.gEV, d.f.icon_play_video);
        this.gEV.setVisibility(8);
        this.eqM.setDefaultErrorResource(0);
        this.eqM.setDefaultResource(0);
        this.eqM.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eqM.setForegroundDrawable(d.f.icon_play_video);
        if (!am.isEmpty(videoInfo.thumbnail_url)) {
            this.eqM.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.caM.setOnPreparedListener(this.bPq);
        this.caM.setOnErrorListener(this.bPr);
        this.caM.setOnCompletionListener(this.bPp);
        this.caM.setOnSurfaceDestroyedListener(this.caV);
        aj.r(this.geA, d.C0141d.cp_cont_i);
        aj.s(this.geA, d.f.video_play_count_bg);
        this.geA.setText(StringUtils.translateSecondsToString(this.gew.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gIB = false;
            aj.c(this.gIv, d.f.ad_icon_sound_close);
        } else {
            this.gIB = true;
            aj.c(this.gIw, d.f.ad_icon_sound_open);
            this.gIv.setVisibility(8);
        }
        this.gIw.setOnClickListener(this.mOnClickListener);
        this.gIv.setOnClickListener(this.mOnClickListener);
        this.geE.setOnClickListener(this.mOnClickListener);
        this.geE.setVisibility(8);
        aj.t(this.geE, d.C0141d.black_alpha80);
        aj.r(this.gIx, d.C0141d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geA.setVisibility(0);
            return;
        }
        this.geA.setVisibility(8);
        this.gIz.setOnClickListener(this.mOnClickListener);
        this.gEV.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.gew = videoInfo;
        this.aHE = new WeakReference<>(this.mContext.getApplicationContext());
        bph();
        aj.t(this, d.C0141d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ao(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        aj.s(this.gEV, d.f.btn_icon_play_video_n);
        this.gEV.setVisibility(8);
        this.eqM.setDefaultErrorResource(0);
        this.eqM.setDefaultResource(0);
        this.eqM.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eqM.setForegroundDrawable(d.f.icon_play_video);
        if (!am.isEmpty(videoInfo.thumbnail_url)) {
            this.eqM.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.caM.setOnPreparedListener(this.bPq);
        this.caM.setOnErrorListener(this.bPr);
        this.caM.setOnCompletionListener(this.bPp);
        this.caM.setOnSurfaceDestroyedListener(this.caV);
        aj.r(this.geA, d.C0141d.cp_cont_i);
        this.geA.setText(StringUtils.translateSecondsToString(this.gew.video_duration.intValue()));
        aj.s(this.geA, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gIB = false;
            aj.c(this.gIv, d.f.ad_icon_sound_close);
        } else {
            this.gIB = true;
            aj.c(this.gIw, d.f.ad_icon_sound_open);
            this.gIv.setVisibility(8);
        }
        this.gIw.setOnClickListener(this.mOnClickListener);
        this.gIv.setOnClickListener(this.mOnClickListener);
        this.geE.setOnClickListener(this.mOnClickListener);
        this.geE.setVisibility(8);
        aj.t(this.geE, d.C0141d.black_alpha80);
        aj.r(this.gIx, d.C0141d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geA.setVisibility(0);
            return;
        }
        this.geA.setVisibility(8);
        this.gIz.setOnClickListener(this.mOnClickListener);
        this.gEV.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gIr = this.gIq.a(this.gBX, this.gIr);
        if (this.gIr != null) {
            this.gIr.setPageContext(this.mPageContext);
            this.gIr.setAdvertAppInfo(advertAppInfo);
            this.gIr.a(this.gBX);
            this.gIr.bpc();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gIr != null) {
            this.gIr.setDownloadAppCallback(cVar);
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
        this.bPp = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(int i) {
        if (this.gIr != null) {
            this.gIr.bpc();
        }
        this.gIH = i;
        if (this.gew != null && this.gex == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gIC) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.caM.setVideoPath(this.gew.video_url);
                this.caM.start();
                this.gIF = this.caM.getCurrentPosition();
                this.gEV.setVisibility(8);
                aj.c(this.gIz, d.f.icon_video_midplay);
                this.dtF.setVisibility(0);
                this.geE.setVisibility(8);
                this.eqM.setForegroundDrawable(0);
                this.gex = 0;
            }
        }
    }

    public void performPlay() {
        uA(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bhH()) {
            if (i <= 0) {
                uA(1);
                return;
            }
            e.ns().removeCallbacks(this.geM);
            e.ns().postDelayed(this.geM, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.gex == 1) {
            F(32, uB(this.gIH), this.caM.getCurrentPosition(), i);
            this.caM.pause();
            y.a(this.aHE, false);
            this.gEV.setVisibility(0);
            aj.c(this.gIz, d.f.icon_video_midpause);
            this.gex = 2;
        }
    }

    public void autoContinue() {
        if (!this.gIE) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.gex == 2) {
            this.gIH = i;
            aj(33, uB(i), this.caM.getCurrentPosition());
            this.gIF = this.caM.getCurrentPosition();
            this.caM.start();
            if (this.gIB) {
                y.a(this.aHE, true);
            }
            this.gEV.setVisibility(8);
            aj.c(this.gIz, d.f.icon_video_midplay);
            this.gex = 1;
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
        if (this.caM.getCurrentPosition() > 0 && this.gex != -1) {
            int i = 32;
            if (this.caM.getDuration() == this.caM.getCurrentPosition()) {
                i = 34;
            }
            f(i, uB(this.gIH), this.caM.getCurrentPosition(), this.caM.isPlaying());
        }
        bph();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bph() {
        e.ns().removeCallbacks(this.geM);
        e.ns().removeCallbacks(this.gII);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.caM.stopPlayback();
        this.gex = -1;
        y.a(this.aHE, false);
        this.eqM.setForegroundDrawable(0);
        this.eqM.setVisibility(0);
        this.dtF.setVisibility(8);
        this.gEV.setVisibility(0);
        aj.c(this.gIz, d.f.icon_video_midpause);
        this.gIA.UC();
        this.geE.setVisibility(8);
        if (this.gew != null) {
            this.geA.setText(StringUtils.translateSecondsToString(this.gew.video_duration.intValue()));
        }
        this.cWm = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uB(int i) {
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
        return this.gew != null ? this.gew.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ma(boolean z) {
        if (z) {
            if (this.cWm != null) {
                this.cWm.setVolume(1.0f, 1.0f);
            }
            aj.c(this.gIw, d.f.ad_icon_sound_open);
            aj.c(this.gIv, d.f.ad_icon_sound_open);
            if (this.gex == 1) {
                y.a(this.aHE, true);
            }
        } else {
            if (this.cWm != null) {
                this.cWm.setVolume(0.0f, 0.0f);
            }
            aj.c(this.gIw, d.f.ad_icon_sound_close);
            aj.c(this.gIv, d.f.ad_icon_sound_close);
            y.a(this.aHE, false);
        }
        this.gIB = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.gex;
    }

    public VideoInfo getData() {
        return this.gew;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.geG;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gIp && this.gIo != null && this.gIo.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aq(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gIt = advertAppInfo;
        this.gIu = i;
        this.gCb = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.aJX = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gIt, 303, i, uB(this.gIH), this.gew.video_duration.intValue(), this.mDuration, -1);
        if (this.gIr != null) {
            this.gIr.e(a);
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
        if (this.gIt != null && this.gew != null) {
            this.gIt.aJX = this.gCb;
            b.boW().a(com.baidu.tieba.recapp.report.e.a(this.gIt, i, this.gIu, i2, this.gew.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.gCb)) {
                    str2 = "det";
                } else if ("FRS".equals(this.gCb)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.gCb)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gIF, i3, this.mDuration, str2, uC(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gBW != null && "cpv".equals(this.gBW.gCU) && !TextUtils.isEmpty(this.gBW.gCV)) {
            new com.baidu.tieba.recapp.request.a(this.gBW.gCV).a(str, i, i2, i3, str2, str3);
        }
    }

    private String uC(int i) {
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
            this.gIo = view;
            this.gIp = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(boolean z) {
        if (z) {
            e.ns().removeCallbacks(this.gII);
            if (this.dIl != null) {
                this.dIl.cancel();
            }
            this.gIy.setVisibility(0);
            if (this.gex == 1) {
                aj.c(this.gIz, d.f.icon_video_midplay);
                return;
            } else {
                aj.c(this.gIz, d.f.icon_video_midpause);
                return;
            }
        }
        this.gIy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpi() {
        switch (this.gex) {
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
                this.gIE = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mb(true);
                    return;
                }
                return;
            case 2:
                this.gIE = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    e.ns().removeCallbacks(this.gII);
                    e.ns().postDelayed(this.gII, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        if (!this.gID && this.dIl != null) {
            this.gIy.startAnimation(this.dIl);
            this.gID = true;
        }
    }

    private void bpk() {
        if (this.mPageContext != null) {
            this.dIl = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dIl.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gIy.setVisibility(8);
                    DistributeVideoView.this.gID = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
