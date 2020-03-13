package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.w;
import com.baidu.tieba.play.x;
/* loaded from: classes8.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean EI;
    private Runnable EO;
    private TbImageView OY;
    private String Pj;
    private int currentState;
    private w dMo;
    private QuickVideoView.b dMx;
    private g.a dVp;
    private g.f dVq;
    private g.InterfaceC0590g dVt;
    private int eaf;
    private g efb;
    private QuickVideoView elk;
    private VideoLoadingProgressView.a fJO;
    private View fMs;
    private TextView ftN;
    private ImageView hZA;
    private CallStateReceiver hZV;
    private g.b hZY;
    private Runnable hZZ;
    private View hZr;
    private boolean iXN;
    private PbVideoWifiTipLayout iXY;
    private boolean iYh;
    private CustomMessageListener iae;
    private VideoControllerView.b ibY;
    private i jCq;
    private ProgressBar jtH;
    private TextView jtK;
    private boolean juh;
    private boolean jui;
    private boolean juj;
    private boolean jum;
    private boolean jun;
    private boolean juo;
    private Runnable juu;
    private QuickVideoView.a juw;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void rN(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.eaf = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.juh = true;
        this.jui = false;
        this.juj = false;
        this.currentState = -1;
        this.iXN = false;
        this.dVq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.efb = gVar;
                PushDialogVideoView.this.dMo.czo();
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buO();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elk.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZr.setVisibility(8);
                    PushDialogVideoView.this.fMs.setVisibility(8);
                    PushDialogVideoView.this.dMo.czp();
                    PushDialogVideoView.this.OY.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juo = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZr.setVisibility(0);
                PushDialogVideoView.this.jtH.setVisibility(8);
                PushDialogVideoView.this.jtH.setProgress(PushDialogVideoView.this.jtH.getMax());
                if (PushDialogVideoView.this.elk == null || PushDialogVideoView.this.elk.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jtK.setVisibility(0);
                }
                x.czt().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.elk.setRecoveryState(3);
                if (PushDialogVideoView.this.elk != null && PushDialogVideoView.this.elk.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZY = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fMs.setVisibility(0);
                PushDialogVideoView.this.dMo.czq();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.elk.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jum = true;
                }
                PushDialogVideoView.this.juo = false;
                return true;
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMs.setVisibility(0);
                PushDialogVideoView.this.dMo.czq();
            }
        };
        this.dVt = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jui) {
                    e.gx().postDelayed(PushDialogVideoView.this.juu, 200L);
                }
            }
        };
        this.juu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elk == null || !PushDialogVideoView.this.jui) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jui = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.elk.getCurrentPosition()) {
                    PushDialogVideoView.this.jui = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.juu, 200L);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juo = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZZ);
            }
        };
        this.iae = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.pausePlay();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.elk != null && PushDialogVideoView.this.elk.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.elk.getCurrentPosition();
                            int duration = PushDialogVideoView.this.elk.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibY != null) {
                                PushDialogVideoView.this.ibY.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eaf - (duration % PushDialogVideoView.this.eaf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i) {
                int duration;
                if (PushDialogVideoView.this.elk != null && (duration = PushDialogVideoView.this.elk.getDuration()) > 0 && PushDialogVideoView.this.jtH != null) {
                    PushDialogVideoView.this.jtH.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.juw = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyu() {
                PushDialogVideoView.this.dMo.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZA.setVisibility(8);
                PushDialogVideoView.this.jtK.setVisibility(8);
                PushDialogVideoView.this.fMs.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZZ);
                e.gx().postDelayed(PushDialogVideoView.this.hZZ, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eaf = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.juh = true;
        this.jui = false;
        this.juj = false;
        this.currentState = -1;
        this.iXN = false;
        this.dVq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.efb = gVar;
                PushDialogVideoView.this.dMo.czo();
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buO();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elk.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZr.setVisibility(8);
                    PushDialogVideoView.this.fMs.setVisibility(8);
                    PushDialogVideoView.this.dMo.czp();
                    PushDialogVideoView.this.OY.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juo = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZr.setVisibility(0);
                PushDialogVideoView.this.jtH.setVisibility(8);
                PushDialogVideoView.this.jtH.setProgress(PushDialogVideoView.this.jtH.getMax());
                if (PushDialogVideoView.this.elk == null || PushDialogVideoView.this.elk.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jtK.setVisibility(0);
                }
                x.czt().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.elk.setRecoveryState(3);
                if (PushDialogVideoView.this.elk != null && PushDialogVideoView.this.elk.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZY = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fMs.setVisibility(0);
                PushDialogVideoView.this.dMo.czq();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.elk.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jum = true;
                }
                PushDialogVideoView.this.juo = false;
                return true;
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMs.setVisibility(0);
                PushDialogVideoView.this.dMo.czq();
            }
        };
        this.dVt = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jui) {
                    e.gx().postDelayed(PushDialogVideoView.this.juu, 200L);
                }
            }
        };
        this.juu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elk == null || !PushDialogVideoView.this.jui) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jui = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.elk.getCurrentPosition()) {
                    PushDialogVideoView.this.jui = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.juu, 200L);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juo = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZZ);
            }
        };
        this.iae = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.pausePlay();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.elk != null && PushDialogVideoView.this.elk.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.elk.getCurrentPosition();
                            int duration = PushDialogVideoView.this.elk.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibY != null) {
                                PushDialogVideoView.this.ibY.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eaf - (duration % PushDialogVideoView.this.eaf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i) {
                int duration;
                if (PushDialogVideoView.this.elk != null && (duration = PushDialogVideoView.this.elk.getDuration()) > 0 && PushDialogVideoView.this.jtH != null) {
                    PushDialogVideoView.this.jtH.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.juw = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyu() {
                PushDialogVideoView.this.dMo.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZA.setVisibility(8);
                PushDialogVideoView.this.jtK.setVisibility(8);
                PushDialogVideoView.this.fMs.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZZ);
                e.gx().postDelayed(PushDialogVideoView.this.hZZ, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eaf = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.juh = true;
        this.jui = false;
        this.juj = false;
        this.currentState = -1;
        this.iXN = false;
        this.dVq = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.efb = gVar;
                PushDialogVideoView.this.dMo.czo();
            }
        };
        this.fJO = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buO();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elk.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZr.setVisibility(8);
                    PushDialogVideoView.this.fMs.setVisibility(8);
                    PushDialogVideoView.this.dMo.czp();
                    PushDialogVideoView.this.OY.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
            }
        };
        this.dVp = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juo = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZr.setVisibility(0);
                PushDialogVideoView.this.jtH.setVisibility(8);
                PushDialogVideoView.this.jtH.setProgress(PushDialogVideoView.this.jtH.getMax());
                if (PushDialogVideoView.this.elk == null || PushDialogVideoView.this.elk.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jtK.setVisibility(0);
                }
                x.czt().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.elk.setRecoveryState(3);
                if (PushDialogVideoView.this.elk != null && PushDialogVideoView.this.elk.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZY = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.fMs.setVisibility(0);
                PushDialogVideoView.this.dMo.czq();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.elk.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jum = true;
                }
                PushDialogVideoView.this.juo = false;
                return true;
            }
        };
        this.hZZ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMs.setVisibility(0);
                PushDialogVideoView.this.dMo.czq();
            }
        };
        this.dVt = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jui) {
                    e.gx().postDelayed(PushDialogVideoView.this.juu, 200L);
                }
            }
        };
        this.juu = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elk == null || !PushDialogVideoView.this.jui) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jui = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.elk.getCurrentPosition()) {
                    PushDialogVideoView.this.jui = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.juu, 200L);
                }
            }
        };
        this.dMx = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juo = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZZ);
            }
        };
        this.iae = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.pausePlay();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.elk != null && PushDialogVideoView.this.elk.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.elk.getCurrentPosition();
                            int duration = PushDialogVideoView.this.elk.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibY != null) {
                                PushDialogVideoView.this.ibY.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eaf - (duration % PushDialogVideoView.this.eaf));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i2) {
                int duration;
                if (PushDialogVideoView.this.elk != null && (duration = PushDialogVideoView.this.elk.getDuration()) > 0 && PushDialogVideoView.this.jtH != null) {
                    PushDialogVideoView.this.jtH.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.juw = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyu() {
                PushDialogVideoView.this.dMo.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZA.setVisibility(8);
                PushDialogVideoView.this.jtK.setVisibility(8);
                PushDialogVideoView.this.fMs.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZZ);
                e.gx().postDelayed(PushDialogVideoView.this.hZZ, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.elk = (QuickVideoView) findViewById(R.id.videoView);
        this.dMo = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dMo.setLoadingAnimationListener(this.fJO);
        this.jtH = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.jtH.setMax(this.mWidth);
        this.jtH.setProgress(0);
        this.hZr = findViewById(R.id.black_mask);
        this.fMs = findViewById(R.id.layout_error);
        this.hZA = (ImageView) findViewById(R.id.img_play);
        this.jtK = (TextView) findViewById(R.id.txt_replay);
        this.ftN = (TextView) findViewById(R.id.push_dialog_video_time);
        this.OY = (TbImageView) findViewById(R.id.video_thumbnail);
        this.iXY = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.OY.setDefaultErrorResource(0);
        this.OY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hZV = new CallStateReceiver();
        this.hZV.register(context);
        this.fMs.setOnClickListener(this);
        this.jtK.setOnClickListener(this);
        this.iXY.setOnPlayClickListener(this);
        this.iXY.setFreeClickListener(this);
        setOnClickListener(this);
        this.elk.setOnPreparedListener(this.dVq);
        this.elk.setOnCompletionListener(this.dVp);
        this.elk.setOnErrorListener(this.hZY);
        this.elk.setOnSeekCompleteListener(this.dVt);
        this.elk.setOnSurfaceDestroyedListener(this.dMx);
        this.elk.setOnRecoveryCallback(this.juw);
        onChangeSkinType();
    }

    public void onPause() {
        if (le()) {
            this.iXN = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iXN = false;
        } else {
            this.iXN = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iXN) {
            aka();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.iae);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.jCq = iVar;
        this.ftN.setText(aq.stringForVideoTime(this.jCq.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pj = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.elk.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buO() {
        if (this.elk != null && this.efb != null) {
            if (this.juo) {
                this.elk.start();
                this.juo = false;
            }
            e.gx().removeCallbacks(this.EO);
            e.gx().postDelayed(this.EO, 20L);
            e.gx().removeCallbacks(this.hZZ);
            if (this.elk.cyP()) {
                this.currentState = 1;
                this.elk.setRecoveryState(1);
            }
            if (this.efb != null) {
                this.mStartPosition = x.czt().He(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.elk != null) {
                        this.elk.As(this.mStartPosition);
                    } else {
                        this.efb.seekTo(this.mStartPosition);
                    }
                    if (!this.jun) {
                        showProgress();
                        e.gx().removeCallbacks(this.EO);
                    }
                    this.jui = true;
                }
            }
        }
    }

    public void csn() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.elk.isPlaying()) {
            pausePlay();
        } else if (this.EI) {
            aka();
        } else {
            cyi();
        }
    }

    public void setPauseState() {
        this.dMo.czq();
        this.hZA.setVisibility(0);
        this.jtK.setVisibility(8);
        this.currentState = 2;
        this.elk.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.juj) {
            ej(str, str2);
        } else {
            ei(str, str2);
        }
        if (aVar != null) {
            aVar.rN(z);
        }
    }

    public void ei(String str, String str2) {
        cyj();
        this.juo = true;
        this.currentState = 0;
        this.elk.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.elk.setVideoPath(str, str2);
        this.dMo.startLoading();
        this.OY.setVisibility(0);
        this.hZA.setVisibility(8);
        this.jtK.setVisibility(8);
        this.fMs.setVisibility(8);
        e.gx().removeCallbacks(this.hZZ);
        e.gx().postDelayed(this.hZZ, 60000L);
    }

    public void ej(String str, String str2) {
        cyj();
        this.juo = true;
        this.currentState = 0;
        this.elk.setRecoveryState(0);
        this.dMo.startLoading();
        this.OY.setVisibility(0);
        this.hZA.setVisibility(8);
        this.jtK.setVisibility(8);
        this.fMs.setVisibility(8);
        e.gx().removeCallbacks(this.hZZ);
        e.gx().postDelayed(this.hZZ, 60000L);
    }

    public void aka() {
        this.currentState = 1;
        this.elk.setRecoveryState(1);
        this.elk.start();
        this.OY.setVisibility(8);
        this.hZr.setVisibility(8);
        this.dMo.czq();
        showProgress();
        this.hZA.setVisibility(8);
        this.jtK.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.jum && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pj)) {
            this.jum = false;
            this.jun = true;
            ei(this.mVideoUrl, this.Pj);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.elk != null) {
            this.elk.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.elk.isPlaying() && this.juh) {
            cyh();
        }
        this.elk.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.elk.isPlaying() && this.juh) {
            cyh();
        }
        this.currentState = 5;
        this.elk.setRecoveryState(5);
        e.gx().removeCallbacks(this.EO);
        e.gx().removeCallbacks(this.hZZ);
        this.elk.stopPlayback();
        this.EI = false;
        this.juo = false;
        this.mStartPosition = 0;
        bPP();
    }

    public void cyh() {
        x.czt().bl(this.mVideoUrl, this.elk.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(boolean z) {
        this.hZr.setVisibility(0);
        this.hZA.setVisibility(0);
        this.jtK.setVisibility(8);
        this.dMo.czq();
        this.jtH.setVisibility(8);
        this.fMs.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.OY.setVisibility(z ? 0 : 8);
    }

    public void bPP() {
        rI(true);
    }

    public boolean le() {
        if (this.elk == null) {
            return false;
        }
        return this.elk.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.elk == null) {
            return 0;
        }
        return this.elk.getCurrentPosition();
    }

    public void showProgress() {
        if (this.elk != null) {
            this.jtH.setVisibility(0);
            this.eaf = ((this.elk.getDuration() / 200) / 50) * 50;
            if (this.eaf < 50) {
                this.eaf = 50;
            } else if (this.eaf > 500) {
                this.eaf = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eaf - (this.elk.getCurrentPosition() % this.eaf));
        }
    }

    private void cyi() {
        a(this.mVideoUrl, this.Pj, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cyj();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.juj = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.iYh && !com.baidu.tieba.video.g.cPi().cPj()) {
            this.iXY.setVisibility(0);
            this.iXY.setData(this.jCq.getDuration(), this.jCq.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cyj() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.cPi().fy(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.OY.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fMs) {
            cyi();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 2).cy("tid", this.Pj));
            csn();
        } else if (view == this.jtK) {
            ei(this.mVideoUrl, this.Pj);
        } else if (view == this.iXY.getTvPlay()) {
            this.iYh = true;
            this.iXY.setVisibility(8);
            ei(this.mVideoUrl, this.Pj);
        } else if (view == this.iXY.getTvOpenFreeData() && this.mPageContext != null) {
            this.mPageContext.getPageActivity().finish();
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
        }
    }

    public void onDestroy() {
        stopPlay();
        e.gx().removeCallbacks(this.EO);
        e.gx().removeCallbacks(this.hZZ);
        e.gx().removeCallbacks(this.juu);
        this.mHandler.removeMessages(1);
        this.hZV.unregister(getContext());
    }
}
