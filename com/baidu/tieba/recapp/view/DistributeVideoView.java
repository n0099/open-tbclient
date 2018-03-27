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
import com.baidu.tieba.tbadkCore.r;
import com.meizu.cloud.pushsdk.notification.model.ActVideoSetting;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class DistributeVideoView extends RelativeLayout implements i {
    private WeakReference<Context> aHF;
    private g.a bPs;
    private g.f bPt;
    private g.b bPu;
    private g cWp;
    private QuickVideoView caP;
    private QuickVideoView.b caY;
    private Animation dIq;
    private View dtI;
    private ForeDrawableImageView erc;
    private AdCard.a gCm;
    private AdCard.e gCn;
    private String gCr;
    private ImageView gFl;
    private View gIE;
    private boolean gIF;
    private c gIG;
    private d gIH;
    private ViewGroup gII;
    private AdvertAppInfo gIJ;
    private int gIK;
    private ImageView gIL;
    private ImageView gIM;
    private TextView gIN;
    private View gIO;
    private ImageView gIP;
    private VideoControllerView gIQ;
    private boolean gIR;
    private long gIS;
    boolean gIT;
    boolean gIU;
    private int gIV;
    boolean gIW;
    private int gIX;
    private Runnable gIY;
    private VideoInfo geM;
    private int geN;
    private TextView geQ;
    private View geU;
    private long geW;
    private Runnable gfc;
    private Context mContext;
    private int mDuration;
    private Handler mHandler;
    private View.OnClickListener mOnClickListener;
    private TbPageContext<?> mPageContext;
    private View mRootView;
    private int mStyle;

    public DistributeVideoView(Context context) {
        super(context);
        this.gIF = false;
        this.aHF = null;
        this.geN = -1;
        this.geW = 0L;
        this.gIR = false;
        this.gIS = 0L;
        this.mStyle = 1;
        this.gIT = false;
        this.gIU = false;
        this.gIW = false;
        this.gIX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geU) {
                    DistributeVideoView.this.geU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIM || view == DistributeVideoView.this.gIL) {
                    DistributeVideoView.this.mf(DistributeVideoView.this.gIR ? false : true);
                } else if (view == DistributeVideoView.this.gFl || view == DistributeVideoView.this.gIP) {
                    DistributeVideoView.this.bpj();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gIJ == null || !DistributeVideoView.this.gIJ.xL()) {
                    DistributeVideoView.this.bpj();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gIJ != null) {
                        WebVideoActivity.gCg = new WebVideoActivity.a();
                        WebVideoActivity.gCg.gCq = DistributeVideoView.this.gIJ;
                        WebVideoActivity.gCg.gCr = "DETAIL";
                        WebVideoActivity.gCg.mPageNum = DistributeVideoView.this.gIK;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gIJ.aKy, true, true, true, DistributeVideoView.this.geM.video_url, DistributeVideoView.this.geM.thumbnail_url, DistributeVideoView.this.geM.video_width.intValue() / DistributeVideoView.this.geM.video_height.intValue(), DistributeVideoView.this.geM.video_duration.intValue());
                    if (DistributeVideoView.this.gCm != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gCm.gDk);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gCm.gDl);
                    }
                    if (DistributeVideoView.this.gCn != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gCn.toJsonString());
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
                        if (DistributeVideoView.this.geN != 1) {
                            if (DistributeVideoView.this.caP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geN = 1;
                                DistributeVideoView.this.dtI.setVisibility(8);
                                DistributeVideoView.this.erc.setVisibility(8);
                                DistributeVideoView.this.mf(DistributeVideoView.this.gIR);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIQ.setPlayer(DistributeVideoView.this.caP);
                                    DistributeVideoView.this.gIQ.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geM.video_duration.intValue()));
                                    DistributeVideoView.this.gIQ.showProgress();
                                    DistributeVideoView.this.mg(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gIY);
                                    e.ns().postDelayed(DistributeVideoView.this.gIY, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geW = DistributeVideoView.this.caP.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caP.getDuration() - DistributeVideoView.this.caP.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geN == 1) {
                            if (DistributeVideoView.this.geW == DistributeVideoView.this.caP.getCurrentPosition()) {
                                DistributeVideoView.this.dtI.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geW = DistributeVideoView.this.caP.getCurrentPosition();
                                DistributeVideoView.this.dtI.setVisibility(8);
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
        this.bPt = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gIV = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gIJ != null) {
                    if (DistributeVideoView.this.gIW && "DETAIL".equals(DistributeVideoView.this.gIJ.aJY)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.aj(i, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), 0);
                    DistributeVideoView.this.cWp = gVar;
                    DistributeVideoView.this.cWp.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpi();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), gVar.getCurrentPosition());
                DistributeVideoView.this.erc.setForegroundDrawable(0);
                DistributeVideoView.this.gFl.setVisibility(8);
                DistributeVideoView.this.geU.setVisibility(0);
                return true;
            }
        };
        this.bPs = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIS = System.currentTimeMillis();
                DistributeVideoView.this.gIW = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), gVar.getDuration());
                DistributeVideoView.this.bpi();
                if (DistributeVideoView.this.gIH != null) {
                    DistributeVideoView.this.gIH.bpc();
                    DistributeVideoView.this.geQ.setVisibility(8);
                    DistributeVideoView.this.gFl.setVisibility(8);
                }
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gfc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geM != null && DistributeVideoView.this.caP != null) {
                    DistributeVideoView.this.uA(1);
                }
            }
        };
        this.gIY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpk();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIF = false;
        this.aHF = null;
        this.geN = -1;
        this.geW = 0L;
        this.gIR = false;
        this.gIS = 0L;
        this.mStyle = 1;
        this.gIT = false;
        this.gIU = false;
        this.gIW = false;
        this.gIX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geU) {
                    DistributeVideoView.this.geU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIM || view == DistributeVideoView.this.gIL) {
                    DistributeVideoView.this.mf(DistributeVideoView.this.gIR ? false : true);
                } else if (view == DistributeVideoView.this.gFl || view == DistributeVideoView.this.gIP) {
                    DistributeVideoView.this.bpj();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gIJ == null || !DistributeVideoView.this.gIJ.xL()) {
                    DistributeVideoView.this.bpj();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gIJ != null) {
                        WebVideoActivity.gCg = new WebVideoActivity.a();
                        WebVideoActivity.gCg.gCq = DistributeVideoView.this.gIJ;
                        WebVideoActivity.gCg.gCr = "DETAIL";
                        WebVideoActivity.gCg.mPageNum = DistributeVideoView.this.gIK;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gIJ.aKy, true, true, true, DistributeVideoView.this.geM.video_url, DistributeVideoView.this.geM.thumbnail_url, DistributeVideoView.this.geM.video_width.intValue() / DistributeVideoView.this.geM.video_height.intValue(), DistributeVideoView.this.geM.video_duration.intValue());
                    if (DistributeVideoView.this.gCm != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gCm.gDk);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gCm.gDl);
                    }
                    if (DistributeVideoView.this.gCn != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gCn.toJsonString());
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
                        if (DistributeVideoView.this.geN != 1) {
                            if (DistributeVideoView.this.caP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geN = 1;
                                DistributeVideoView.this.dtI.setVisibility(8);
                                DistributeVideoView.this.erc.setVisibility(8);
                                DistributeVideoView.this.mf(DistributeVideoView.this.gIR);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIQ.setPlayer(DistributeVideoView.this.caP);
                                    DistributeVideoView.this.gIQ.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geM.video_duration.intValue()));
                                    DistributeVideoView.this.gIQ.showProgress();
                                    DistributeVideoView.this.mg(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gIY);
                                    e.ns().postDelayed(DistributeVideoView.this.gIY, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geW = DistributeVideoView.this.caP.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caP.getDuration() - DistributeVideoView.this.caP.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geN == 1) {
                            if (DistributeVideoView.this.geW == DistributeVideoView.this.caP.getCurrentPosition()) {
                                DistributeVideoView.this.dtI.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geW = DistributeVideoView.this.caP.getCurrentPosition();
                                DistributeVideoView.this.dtI.setVisibility(8);
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
        this.bPt = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i;
                DistributeVideoView.this.gIV = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gIJ != null) {
                    if (DistributeVideoView.this.gIW && "DETAIL".equals(DistributeVideoView.this.gIJ.aJY)) {
                        i = 35;
                    } else {
                        i = 31;
                    }
                    DistributeVideoView.this.aj(i, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), 0);
                    DistributeVideoView.this.cWp = gVar;
                    DistributeVideoView.this.cWp.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                DistributeVideoView.this.bpi();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), gVar.getCurrentPosition());
                DistributeVideoView.this.erc.setForegroundDrawable(0);
                DistributeVideoView.this.gFl.setVisibility(8);
                DistributeVideoView.this.geU.setVisibility(0);
                return true;
            }
        };
        this.bPs = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIS = System.currentTimeMillis();
                DistributeVideoView.this.gIW = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), gVar.getDuration());
                DistributeVideoView.this.bpi();
                if (DistributeVideoView.this.gIH != null) {
                    DistributeVideoView.this.gIH.bpc();
                    DistributeVideoView.this.geQ.setVisibility(8);
                    DistributeVideoView.this.gFl.setVisibility(8);
                }
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gfc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geM != null && DistributeVideoView.this.caP != null) {
                    DistributeVideoView.this.uA(1);
                }
            }
        };
        this.gIY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                DistributeVideoView.this.bpk();
            }
        };
        init(context);
    }

    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIF = false;
        this.aHF = null;
        this.geN = -1;
        this.geW = 0L;
        this.gIR = false;
        this.gIS = 0L;
        this.mStyle = 1;
        this.gIT = false;
        this.gIU = false;
        this.gIW = false;
        this.gIX = 2;
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == DistributeVideoView.this.geU) {
                    DistributeVideoView.this.geU.setVisibility(8);
                    DistributeVideoView.this.performPlay();
                } else if (view == DistributeVideoView.this.gIM || view == DistributeVideoView.this.gIL) {
                    DistributeVideoView.this.mf(DistributeVideoView.this.gIR ? false : true);
                } else if (view == DistributeVideoView.this.gFl || view == DistributeVideoView.this.gIP) {
                    DistributeVideoView.this.bpj();
                } else if (DistributeVideoView.this.mStyle != 1 || DistributeVideoView.this.gIJ == null || !DistributeVideoView.this.gIJ.xL()) {
                    DistributeVideoView.this.bpj();
                } else {
                    DistributeVideoView.this.aj(2, 1, 0);
                    if (DistributeVideoView.this.gIJ != null) {
                        WebVideoActivity.gCg = new WebVideoActivity.a();
                        WebVideoActivity.gCg.gCq = DistributeVideoView.this.gIJ;
                        WebVideoActivity.gCg.gCr = "DETAIL";
                        WebVideoActivity.gCg.mPageNum = DistributeVideoView.this.gIK;
                    }
                    WebVideoActivityConfig webVideoActivityConfig = new WebVideoActivityConfig(DistributeVideoView.this.mContext, "", DistributeVideoView.this.gIJ.aKy, true, true, true, DistributeVideoView.this.geM.video_url, DistributeVideoView.this.geM.thumbnail_url, DistributeVideoView.this.geM.video_width.intValue() / DistributeVideoView.this.geM.video_height.intValue(), DistributeVideoView.this.geM.video_duration.intValue());
                    if (DistributeVideoView.this.gCm != null) {
                        webVideoActivityConfig.setChargeStyle(DistributeVideoView.this.gCm.gDk);
                        webVideoActivityConfig.setChargeUrl(DistributeVideoView.this.gCm.gDl);
                    }
                    if (DistributeVideoView.this.gCn != null) {
                        webVideoActivityConfig.setTailFrame(DistributeVideoView.this.gCn.toJsonString());
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
                        if (DistributeVideoView.this.geN != 1) {
                            if (DistributeVideoView.this.caP.getCurrentPosition() > 0) {
                                DistributeVideoView.this.geN = 1;
                                DistributeVideoView.this.dtI.setVisibility(8);
                                DistributeVideoView.this.erc.setVisibility(8);
                                DistributeVideoView.this.mf(DistributeVideoView.this.gIR);
                                if (DistributeVideoView.this.mStyle == 1) {
                                    DistributeVideoView.this.mHandler.removeMessages(1002);
                                    DistributeVideoView.this.mHandler.sendEmptyMessage(1002);
                                } else {
                                    DistributeVideoView.this.gIQ.setPlayer(DistributeVideoView.this.caP);
                                    DistributeVideoView.this.gIQ.aU(0, (int) TimeUnit.SECONDS.toMillis(DistributeVideoView.this.geM.video_duration.intValue()));
                                    DistributeVideoView.this.gIQ.showProgress();
                                    DistributeVideoView.this.mg(true);
                                    e.ns().removeCallbacks(DistributeVideoView.this.gIY);
                                    e.ns().postDelayed(DistributeVideoView.this.gIY, TimeUnit.SECONDS.toMillis(3L));
                                }
                                DistributeVideoView.this.geW = DistributeVideoView.this.caP.getCurrentPosition();
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
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(DistributeVideoView.this.caP.getDuration() - DistributeVideoView.this.caP.getCurrentPosition());
                        if (seconds >= 0) {
                            DistributeVideoView.this.geQ.setText(StringUtils.translateSecondsToString((int) seconds));
                            DistributeVideoView.this.mHandler.sendEmptyMessageDelayed(1002, TimeUnit.SECONDS.toMillis(1L));
                            return;
                        }
                        BdLog.e("AutoPlayVideoView: wrong time");
                        return;
                    case 1003:
                        if (DistributeVideoView.this.geN == 1) {
                            if (DistributeVideoView.this.geW == DistributeVideoView.this.caP.getCurrentPosition()) {
                                DistributeVideoView.this.dtI.setVisibility(0);
                            } else {
                                DistributeVideoView.this.geW = DistributeVideoView.this.caP.getCurrentPosition();
                                DistributeVideoView.this.dtI.setVisibility(8);
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
        this.bPt = new g.f() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                int i2;
                DistributeVideoView.this.gIV = gVar.getCurrentPosition();
                DistributeVideoView.this.mDuration = gVar.getDuration();
                if (gVar != null && DistributeVideoView.this.gIJ != null) {
                    if (DistributeVideoView.this.gIW && "DETAIL".equals(DistributeVideoView.this.gIJ.aJY)) {
                        i2 = 35;
                    } else {
                        i2 = 31;
                    }
                    DistributeVideoView.this.aj(i2, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), 0);
                    DistributeVideoView.this.cWp = gVar;
                    DistributeVideoView.this.cWp.setVolume(0.0f, 0.0f);
                    DistributeVideoView.this.mHandler.removeMessages(1001);
                    DistributeVideoView.this.mHandler.sendEmptyMessage(1001);
                }
            }
        };
        this.bPu = new g.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                DistributeVideoView.this.bpi();
                DistributeVideoView.this.aj(36, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), gVar.getCurrentPosition());
                DistributeVideoView.this.erc.setForegroundDrawable(0);
                DistributeVideoView.this.gFl.setVisibility(8);
                DistributeVideoView.this.geU.setVisibility(0);
                return true;
            }
        };
        this.bPs = new g.a() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                DistributeVideoView.this.gIS = System.currentTimeMillis();
                DistributeVideoView.this.gIW = true;
                DistributeVideoView.this.aj(34, DistributeVideoView.this.uB(DistributeVideoView.this.gIX), gVar.getDuration());
                DistributeVideoView.this.bpi();
                if (DistributeVideoView.this.gIH != null) {
                    DistributeVideoView.this.gIH.bpc();
                    DistributeVideoView.this.geQ.setVisibility(8);
                    DistributeVideoView.this.gFl.setVisibility(8);
                }
            }
        };
        this.caY = new QuickVideoView.b() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                DistributeVideoView.this.stopPlay();
            }
        };
        this.gfc = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (DistributeVideoView.this.geM != null && DistributeVideoView.this.caP != null) {
                    DistributeVideoView.this.uA(1);
                }
            }
        };
        this.gIY = new Runnable() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
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
            this.caP = (QuickVideoView) this.mRootView.findViewById(d.g.distribute_texture);
            this.gFl = (ImageView) this.mRootView.findViewById(d.g.distribute_play);
            this.erc = (ForeDrawableImageView) this.mRootView.findViewById(d.g.distribute_thumbnail);
            this.dtI = this.mRootView.findViewById(d.g.distribute_loading);
            this.geQ = (TextView) this.mRootView.findViewById(d.g.distribute_count_process);
            this.geU = this.mRootView.findViewById(d.g.distribute_error_tip);
            this.gIN = (TextView) this.mRootView.findViewById(d.g.distribute_error_tip_text);
            this.gIL = (ImageView) this.mRootView.findViewById(d.g.distribute_voice_feed);
            this.gIO = this.mRootView.findViewById(d.g.distribute_control);
            this.gIP = (ImageView) this.gIO.findViewById(d.g.distribute_play_icon);
            this.gIM = (ImageView) this.gIO.findViewById(d.g.distribute_voice);
            this.gIQ = (VideoControllerView) this.gIO.findViewById(d.g.distribute_process);
            this.gII = (FrameLayout) this.mRootView.findViewById(d.g.tail_frame_container);
            this.gIG = new c(context, this.gII);
        }
    }

    private boolean bhI() {
        return this.mStyle == 1 ? r.bhI() : j.oK();
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
        this.gCm = aVar;
    }

    public void setVideoTailFrameData(AdCard.e eVar) {
        this.gCn = eVar;
    }

    public void setData(VideoInfo videoInfo) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geM = videoInfo;
        this.mDuration = this.geM.video_duration.intValue() * 1000;
        this.aHF = new WeakReference<>(this.mContext.getApplicationContext());
        bpi();
        aj.t(this, d.C0141d.cp_bg_line_d);
        int ao = l.ao(this.mContext) - l.t(this.mContext, d.e.ds146);
        if (this.mStyle == 2) {
            ao = l.ao(this.mContext);
        }
        int intValue = this.geM.video_width.intValue() > 0 ? (this.geM.video_height.intValue() * ao) / this.geM.video_width.intValue() : ao;
        ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = ao;
            layoutParams.height = intValue;
            this.mRootView.setLayoutParams(layoutParams);
        }
        setOnClickListener(this.mOnClickListener);
        aj.s(this.gFl, d.f.icon_play_video);
        this.gFl.setVisibility(8);
        this.erc.setDefaultErrorResource(0);
        this.erc.setDefaultResource(0);
        this.erc.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.erc.setForegroundDrawable(d.f.icon_play_video);
        if (!am.isEmpty(videoInfo.thumbnail_url)) {
            this.erc.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.caP.setOnPreparedListener(this.bPt);
        this.caP.setOnErrorListener(this.bPu);
        this.caP.setOnCompletionListener(this.bPs);
        this.caP.setOnSurfaceDestroyedListener(this.caY);
        aj.r(this.geQ, d.C0141d.cp_cont_i);
        aj.s(this.geQ, d.f.video_play_count_bg);
        this.geQ.setText(StringUtils.translateSecondsToString(this.geM.video_duration.intValue()));
        if (this.mStyle == 1) {
            this.gIR = false;
            aj.c(this.gIL, d.f.ad_icon_sound_close);
        } else {
            this.gIR = true;
            aj.c(this.gIM, d.f.ad_icon_sound_open);
            this.gIL.setVisibility(8);
        }
        this.gIM.setOnClickListener(this.mOnClickListener);
        this.gIL.setOnClickListener(this.mOnClickListener);
        this.geU.setOnClickListener(this.mOnClickListener);
        this.geU.setVisibility(8);
        aj.t(this.geU, d.C0141d.black_alpha80);
        aj.r(this.gIN, d.C0141d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geQ.setVisibility(0);
            return;
        }
        this.geQ.setVisibility(8);
        this.gIP.setOnClickListener(this.mOnClickListener);
        this.gFl.setOnClickListener(this.mOnClickListener);
    }

    public void setData(VideoInfo videoInfo, int i, int i2, int i3) {
        if (videoInfo == null) {
            setVisibility(8);
            return;
        }
        this.geM = videoInfo;
        this.aHF = new WeakReference<>(this.mContext.getApplicationContext());
        bpi();
        aj.t(this, d.C0141d.cp_bg_line_d);
        if (this.mStyle == 2) {
            i = l.ao(this.mContext);
        }
        a(videoInfo, i, i2, i3);
        setOnClickListener(this.mOnClickListener);
        aj.s(this.gFl, d.f.btn_icon_play_video_n);
        this.gFl.setVisibility(8);
        this.erc.setDefaultErrorResource(0);
        this.erc.setDefaultResource(0);
        this.erc.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.erc.setForegroundDrawable(d.f.icon_play_video);
        if (!am.isEmpty(videoInfo.thumbnail_url)) {
            this.erc.startLoad(videoInfo.thumbnail_url, 10, false);
        }
        this.caP.setOnPreparedListener(this.bPt);
        this.caP.setOnErrorListener(this.bPu);
        this.caP.setOnCompletionListener(this.bPs);
        this.caP.setOnSurfaceDestroyedListener(this.caY);
        aj.r(this.geQ, d.C0141d.cp_cont_i);
        this.geQ.setText(StringUtils.translateSecondsToString(this.geM.video_duration.intValue()));
        aj.s(this.geQ, d.f.video_play_count_bg);
        if (this.mStyle == 1) {
            this.gIR = false;
            aj.c(this.gIL, d.f.ad_icon_sound_close);
        } else {
            this.gIR = true;
            aj.c(this.gIM, d.f.ad_icon_sound_open);
            this.gIL.setVisibility(8);
        }
        this.gIM.setOnClickListener(this.mOnClickListener);
        this.gIL.setOnClickListener(this.mOnClickListener);
        this.geU.setOnClickListener(this.mOnClickListener);
        this.geU.setVisibility(8);
        aj.t(this.geU, d.C0141d.black_alpha80);
        aj.r(this.gIN, d.C0141d.cp_cont_i);
        if (this.mStyle == 1) {
            this.geQ.setVisibility(0);
            return;
        }
        this.geQ.setVisibility(8);
        this.gIP.setOnClickListener(this.mOnClickListener);
        this.gFl.setOnClickListener(this.mOnClickListener);
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        this.gIH = this.gIG.a(this.gCn, this.gIH);
        if (this.gIH != null) {
            this.gIH.setPageContext(this.mPageContext);
            this.gIH.setAdvertAppInfo(advertAppInfo);
            this.gIH.a(this.gCn);
            this.gIH.bpd();
        }
    }

    public void setDownloadCallback(com.baidu.tieba.lego.card.c cVar) {
        if (this.gIH != null) {
            this.gIH.setDownloadAppCallback(cVar);
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
        this.bPs = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(int i) {
        if (this.gIH != null) {
            this.gIH.bpd();
        }
        this.gIX = i;
        if (this.geM != null && this.geN == -1) {
            if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.gIS) >= TimeUnit.SECONDS.toSeconds(3L)) {
                this.caP.setVideoPath(this.geM.video_url);
                this.caP.start();
                this.gIV = this.caP.getCurrentPosition();
                this.gFl.setVisibility(8);
                aj.c(this.gIP, d.f.icon_video_midplay);
                this.dtI.setVisibility(0);
                this.geU.setVisibility(8);
                this.erc.setForegroundDrawable(0);
                this.geN = 0;
            }
        }
    }

    public void performPlay() {
        uA(2);
    }

    @Override // com.baidu.tieba.recapp.i
    public void autoPlay(int i) {
        if (bhI()) {
            if (i <= 0) {
                uA(1);
                return;
            }
            e.ns().removeCallbacks(this.gfc);
            e.ns().postDelayed(this.gfc, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public void pausePlay(int i) {
        if (this.geN == 1) {
            F(32, uB(this.gIX), this.caP.getCurrentPosition(), i);
            this.caP.pause();
            y.a(this.aHF, false);
            this.gFl.setVisibility(0);
            aj.c(this.gIP, d.f.icon_video_midpause);
            this.geN = 2;
        }
    }

    public void autoContinue() {
        if (!this.gIU) {
            continuePlay(1);
        }
    }

    public void continuePlay(int i) {
        if (this.geN == 2) {
            this.gIX = i;
            aj(33, uB(i), this.caP.getCurrentPosition());
            this.gIV = this.caP.getCurrentPosition();
            this.caP.start();
            if (this.gIR) {
                y.a(this.aHF, true);
            }
            this.gFl.setVisibility(8);
            aj.c(this.gIP, d.f.icon_video_midplay);
            this.geN = 1;
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
        if (this.caP.getCurrentPosition() > 0 && this.geN != -1) {
            int i = 32;
            if (this.caP.getDuration() == this.caP.getCurrentPosition()) {
                i = 34;
            }
            f(i, uB(this.gIX), this.caP.getCurrentPosition(), this.caP.isPlaying());
        }
        bpi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpi() {
        e.ns().removeCallbacks(this.gfc);
        e.ns().removeCallbacks(this.gIY);
        this.mHandler.removeMessages(1001);
        this.mHandler.removeMessages(1003);
        this.mHandler.removeMessages(1002);
        this.caP.stopPlayback();
        this.geN = -1;
        y.a(this.aHF, false);
        this.erc.setForegroundDrawable(0);
        this.erc.setVisibility(0);
        this.dtI.setVisibility(8);
        this.gFl.setVisibility(0);
        aj.c(this.gIP, d.f.icon_video_midpause);
        this.gIQ.UD();
        this.geU.setVisibility(8);
        if (this.geM != null) {
            this.geQ.setText(StringUtils.translateSecondsToString(this.geM.video_duration.intValue()));
        }
        this.cWp = null;
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
        return this.geM != null ? this.geM.video_url : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mf(boolean z) {
        if (z) {
            if (this.cWp != null) {
                this.cWp.setVolume(1.0f, 1.0f);
            }
            aj.c(this.gIM, d.f.ad_icon_sound_open);
            aj.c(this.gIL, d.f.ad_icon_sound_open);
            if (this.geN == 1) {
                y.a(this.aHF, true);
            }
        } else {
            if (this.cWp != null) {
                this.cWp.setVolume(0.0f, 0.0f);
            }
            aj.c(this.gIM, d.f.ad_icon_sound_close);
            aj.c(this.gIL, d.f.ad_icon_sound_close);
            y.a(this.aHF, false);
        }
        this.gIR = z;
    }

    @Override // com.baidu.tieba.recapp.i
    public int getPlayStatus() {
        return this.geN;
    }

    public VideoInfo getData() {
        return this.geM;
    }

    @Override // com.baidu.tieba.recapp.i
    public long getCurrentPosition() {
        return this.geW;
    }

    @Override // com.baidu.tieba.recapp.i
    public void release() {
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDisplay() {
        if (this.gIF && this.gIE != null && this.gIE.getParent() == null) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        return iArr[1] + getHeight() >= 0 && iArr[1] <= l.aq(this.mContext);
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        this.gIJ = advertAppInfo;
        this.gIK = i;
        this.gCr = str;
        a(advertAppInfo, i, str);
    }

    private void a(AdvertAppInfo advertAppInfo, int i, String str) {
        advertAppInfo.aJY = str;
        a a = com.baidu.tieba.recapp.report.e.a(this.gIJ, 303, i, uB(this.gIX), this.geM.video_duration.intValue(), this.mDuration, -1);
        if (this.gIH != null) {
            this.gIH.e(a);
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
        if (this.gIJ != null && this.geM != null) {
            this.gIJ.aJY = this.gCr;
            b.boX().a(com.baidu.tieba.recapp.report.e.a(this.gIJ, i, this.gIK, i2, this.geM.video_duration.intValue(), (int) TimeUnit.MILLISECONDS.toSeconds(i3), i4));
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
                if ("DETAIL".equals(this.gCr)) {
                    str2 = "det";
                } else if ("FRS".equals(this.gCr)) {
                    str2 = "frs";
                } else if ("NEWINDEX".equals(this.gCr)) {
                    str2 = "ind";
                } else {
                    str2 = "oth";
                }
                c(str, this.gIV, i3, this.mDuration, str2, uC(i2));
            }
        }
    }

    private void c(String str, int i, int i2, int i3, String str2, String str3) {
        if (this.gCm != null && "cpv".equals(this.gCm.gDk) && !TextUtils.isEmpty(this.gCm.gDl)) {
            new com.baidu.tieba.recapp.request.a(this.gCm.gDl).a(str, i, i2, i3, str2, str3);
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
            this.gIE = view;
            this.gIF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg(boolean z) {
        if (z) {
            e.ns().removeCallbacks(this.gIY);
            if (this.dIq != null) {
                this.dIq.cancel();
            }
            this.gIO.setVisibility(0);
            if (this.geN == 1) {
                aj.c(this.gIP, d.f.icon_video_midplay);
                return;
            } else {
                aj.c(this.gIP, d.f.icon_video_midpause);
                return;
            }
        }
        this.gIO.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        switch (this.geN) {
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
                    aVar.b(this.mPageContext).AV();
                    return;
                } else {
                    performPlay();
                    return;
                }
            case 0:
                stopPlay();
                return;
            case 1:
                this.gIU = true;
                pausePlay(0);
                if (this.mStyle == 2) {
                    mg(true);
                    return;
                }
                return;
            case 2:
                this.gIU = false;
                continuePlay(2);
                if (this.mStyle == 2) {
                    e.ns().removeCallbacks(this.gIY);
                    e.ns().postDelayed(this.gIY, TimeUnit.SECONDS.toMillis(3L));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpk() {
        if (!this.gIT && this.dIq != null) {
            this.gIO.startAnimation(this.dIq);
            this.gIT = true;
        }
    }

    private void bpl() {
        if (this.mPageContext != null) {
            this.dIq = AnimationUtils.loadAnimation(this.mPageContext.getPageActivity(), d.a.anim_alpha_1_to_0_duration_1000);
            this.dIq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    DistributeVideoView.this.gIO.setVisibility(8);
                    DistributeVideoView.this.gIT = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
        }
    }
}
