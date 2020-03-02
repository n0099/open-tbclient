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
    private w dMb;
    private QuickVideoView.b dMk;
    private g.a dVc;
    private g.f dVd;
    private g.InterfaceC0590g dVg;
    private int dZS;
    private g eeO;
    private QuickVideoView ekX;
    private VideoLoadingProgressView.a fJB;
    private View fMf;
    private TextView ftA;
    private CallStateReceiver hZJ;
    private g.b hZM;
    private Runnable hZN;
    private CustomMessageListener hZS;
    private View hZf;
    private ImageView hZo;
    private boolean iXB;
    private PbVideoWifiTipLayout iXM;
    private boolean iXV;
    private VideoControllerView.b ibM;
    private i jCe;
    private boolean jtV;
    private boolean jtW;
    private boolean jtX;
    private ProgressBar jtv;
    private TextView jty;
    private boolean jua;
    private boolean jub;
    private boolean juc;
    private Runnable jui;
    private QuickVideoView.a juk;
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
        this.dZS = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jtV = true;
        this.jtW = false;
        this.jtX = false;
        this.currentState = -1;
        this.iXB = false;
        this.dVd = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eeO = gVar;
                PushDialogVideoView.this.dMb.czn();
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buN();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZf.setVisibility(8);
                    PushDialogVideoView.this.fMf.setVisibility(8);
                    PushDialogVideoView.this.dMb.czo();
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
        this.dVc = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juc = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZf.setVisibility(0);
                PushDialogVideoView.this.jtv.setVisibility(8);
                PushDialogVideoView.this.jtv.setProgress(PushDialogVideoView.this.jtv.getMax());
                if (PushDialogVideoView.this.ekX == null || PushDialogVideoView.this.ekX.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jty.setVisibility(0);
                }
                x.czs().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ekX.setRecoveryState(3);
                if (PushDialogVideoView.this.ekX != null && PushDialogVideoView.this.ekX.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZM = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fMf.setVisibility(0);
                PushDialogVideoView.this.dMb.czp();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ekX.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jua = true;
                }
                PushDialogVideoView.this.juc = false;
                return true;
            }
        };
        this.hZN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMf.setVisibility(0);
                PushDialogVideoView.this.dMb.czp();
            }
        };
        this.dVg = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtW) {
                    e.gx().postDelayed(PushDialogVideoView.this.jui, 200L);
                }
            }
        };
        this.jui = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekX == null || !PushDialogVideoView.this.jtW) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jtW = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ekX.getCurrentPosition()) {
                    PushDialogVideoView.this.jtW = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jui, 200L);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juc = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZN);
            }
        };
        this.hZS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.ekX != null && PushDialogVideoView.this.ekX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ekX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ekX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibM != null) {
                                PushDialogVideoView.this.ibM.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dZS - (duration % PushDialogVideoView.this.dZS));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i) {
                int duration;
                if (PushDialogVideoView.this.ekX != null && (duration = PushDialogVideoView.this.ekX.getDuration()) > 0 && PushDialogVideoView.this.jtv != null) {
                    PushDialogVideoView.this.jtv.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.juk = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyt() {
                PushDialogVideoView.this.dMb.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZo.setVisibility(8);
                PushDialogVideoView.this.jty.setVisibility(8);
                PushDialogVideoView.this.fMf.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZN);
                e.gx().postDelayed(PushDialogVideoView.this.hZN, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZS = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jtV = true;
        this.jtW = false;
        this.jtX = false;
        this.currentState = -1;
        this.iXB = false;
        this.dVd = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eeO = gVar;
                PushDialogVideoView.this.dMb.czn();
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buN();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZf.setVisibility(8);
                    PushDialogVideoView.this.fMf.setVisibility(8);
                    PushDialogVideoView.this.dMb.czo();
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
        this.dVc = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juc = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZf.setVisibility(0);
                PushDialogVideoView.this.jtv.setVisibility(8);
                PushDialogVideoView.this.jtv.setProgress(PushDialogVideoView.this.jtv.getMax());
                if (PushDialogVideoView.this.ekX == null || PushDialogVideoView.this.ekX.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jty.setVisibility(0);
                }
                x.czs().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ekX.setRecoveryState(3);
                if (PushDialogVideoView.this.ekX != null && PushDialogVideoView.this.ekX.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZM = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fMf.setVisibility(0);
                PushDialogVideoView.this.dMb.czp();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ekX.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jua = true;
                }
                PushDialogVideoView.this.juc = false;
                return true;
            }
        };
        this.hZN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMf.setVisibility(0);
                PushDialogVideoView.this.dMb.czp();
            }
        };
        this.dVg = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtW) {
                    e.gx().postDelayed(PushDialogVideoView.this.jui, 200L);
                }
            }
        };
        this.jui = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekX == null || !PushDialogVideoView.this.jtW) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jtW = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ekX.getCurrentPosition()) {
                    PushDialogVideoView.this.jtW = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jui, 200L);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juc = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZN);
            }
        };
        this.hZS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.ekX != null && PushDialogVideoView.this.ekX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ekX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ekX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibM != null) {
                                PushDialogVideoView.this.ibM.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dZS - (duration % PushDialogVideoView.this.dZS));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i) {
                int duration;
                if (PushDialogVideoView.this.ekX != null && (duration = PushDialogVideoView.this.ekX.getDuration()) > 0 && PushDialogVideoView.this.jtv != null) {
                    PushDialogVideoView.this.jtv.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.juk = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyt() {
                PushDialogVideoView.this.dMb.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZo.setVisibility(8);
                PushDialogVideoView.this.jty.setVisibility(8);
                PushDialogVideoView.this.fMf.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZN);
                e.gx().postDelayed(PushDialogVideoView.this.hZN, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZS = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jtV = true;
        this.jtW = false;
        this.jtX = false;
        this.currentState = -1;
        this.iXB = false;
        this.dVd = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eeO = gVar;
                PushDialogVideoView.this.dMb.czn();
            }
        };
        this.fJB = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buN();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZf.setVisibility(8);
                    PushDialogVideoView.this.fMf.setVisibility(8);
                    PushDialogVideoView.this.dMb.czo();
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
        this.dVc = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juc = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZf.setVisibility(0);
                PushDialogVideoView.this.jtv.setVisibility(8);
                PushDialogVideoView.this.jtv.setProgress(PushDialogVideoView.this.jtv.getMax());
                if (PushDialogVideoView.this.ekX == null || PushDialogVideoView.this.ekX.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jty.setVisibility(0);
                }
                x.czs().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ekX.setRecoveryState(3);
                if (PushDialogVideoView.this.ekX != null && PushDialogVideoView.this.ekX.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZM = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.fMf.setVisibility(0);
                PushDialogVideoView.this.dMb.czp();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ekX.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jua = true;
                }
                PushDialogVideoView.this.juc = false;
                return true;
            }
        };
        this.hZN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMf.setVisibility(0);
                PushDialogVideoView.this.dMb.czp();
            }
        };
        this.dVg = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtW) {
                    e.gx().postDelayed(PushDialogVideoView.this.jui, 200L);
                }
            }
        };
        this.jui = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekX == null || !PushDialogVideoView.this.jtW) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jtW = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ekX.getCurrentPosition()) {
                    PushDialogVideoView.this.jtW = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jui, 200L);
                }
            }
        };
        this.dMk = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.juc = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZN);
            }
        };
        this.hZS = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.ekX != null && PushDialogVideoView.this.ekX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ekX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ekX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibM != null) {
                                PushDialogVideoView.this.ibM.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dZS - (duration % PushDialogVideoView.this.dZS));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibM = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i2) {
                int duration;
                if (PushDialogVideoView.this.ekX != null && (duration = PushDialogVideoView.this.ekX.getDuration()) > 0 && PushDialogVideoView.this.jtv != null) {
                    PushDialogVideoView.this.jtv.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.juk = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyt() {
                PushDialogVideoView.this.dMb.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZo.setVisibility(8);
                PushDialogVideoView.this.jty.setVisibility(8);
                PushDialogVideoView.this.fMf.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZN);
                e.gx().postDelayed(PushDialogVideoView.this.hZN, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.ekX = (QuickVideoView) findViewById(R.id.videoView);
        this.dMb = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dMb.setLoadingAnimationListener(this.fJB);
        this.jtv = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.jtv.setMax(this.mWidth);
        this.jtv.setProgress(0);
        this.hZf = findViewById(R.id.black_mask);
        this.fMf = findViewById(R.id.layout_error);
        this.hZo = (ImageView) findViewById(R.id.img_play);
        this.jty = (TextView) findViewById(R.id.txt_replay);
        this.ftA = (TextView) findViewById(R.id.push_dialog_video_time);
        this.OY = (TbImageView) findViewById(R.id.video_thumbnail);
        this.iXM = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.OY.setDefaultErrorResource(0);
        this.OY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hZJ = new CallStateReceiver();
        this.hZJ.register(context);
        this.fMf.setOnClickListener(this);
        this.jty.setOnClickListener(this);
        this.iXM.setOnPlayClickListener(this);
        this.iXM.setFreeClickListener(this);
        setOnClickListener(this);
        this.ekX.setOnPreparedListener(this.dVd);
        this.ekX.setOnCompletionListener(this.dVc);
        this.ekX.setOnErrorListener(this.hZM);
        this.ekX.setOnSeekCompleteListener(this.dVg);
        this.ekX.setOnSurfaceDestroyedListener(this.dMk);
        this.ekX.setOnRecoveryCallback(this.juk);
        onChangeSkinType();
    }

    public void onPause() {
        if (le()) {
            this.iXB = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iXB = false;
        } else {
            this.iXB = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iXB) {
            aka();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hZS);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.jCe = iVar;
        this.ftA.setText(aq.stringForVideoTime(this.jCe.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pj = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.ekX.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buN() {
        if (this.ekX != null && this.eeO != null) {
            if (this.juc) {
                this.ekX.start();
                this.juc = false;
            }
            e.gx().removeCallbacks(this.EO);
            e.gx().postDelayed(this.EO, 20L);
            e.gx().removeCallbacks(this.hZN);
            if (this.ekX.cyO()) {
                this.currentState = 1;
                this.ekX.setRecoveryState(1);
            }
            if (this.eeO != null) {
                this.mStartPosition = x.czs().Hd(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.ekX != null) {
                        this.ekX.As(this.mStartPosition);
                    } else {
                        this.eeO.seekTo(this.mStartPosition);
                    }
                    if (!this.jub) {
                        showProgress();
                        e.gx().removeCallbacks(this.EO);
                    }
                    this.jtW = true;
                }
            }
        }
    }

    public void csm() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.ekX.isPlaying()) {
            pausePlay();
        } else if (this.EI) {
            aka();
        } else {
            cyh();
        }
    }

    public void setPauseState() {
        this.dMb.czp();
        this.hZo.setVisibility(0);
        this.jty.setVisibility(8);
        this.currentState = 2;
        this.ekX.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.jtX) {
            ej(str, str2);
        } else {
            ei(str, str2);
        }
        if (aVar != null) {
            aVar.rN(z);
        }
    }

    public void ei(String str, String str2) {
        cyi();
        this.juc = true;
        this.currentState = 0;
        this.ekX.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.ekX.setVideoPath(str, str2);
        this.dMb.startLoading();
        this.OY.setVisibility(0);
        this.hZo.setVisibility(8);
        this.jty.setVisibility(8);
        this.fMf.setVisibility(8);
        e.gx().removeCallbacks(this.hZN);
        e.gx().postDelayed(this.hZN, 60000L);
    }

    public void ej(String str, String str2) {
        cyi();
        this.juc = true;
        this.currentState = 0;
        this.ekX.setRecoveryState(0);
        this.dMb.startLoading();
        this.OY.setVisibility(0);
        this.hZo.setVisibility(8);
        this.jty.setVisibility(8);
        this.fMf.setVisibility(8);
        e.gx().removeCallbacks(this.hZN);
        e.gx().postDelayed(this.hZN, 60000L);
    }

    public void aka() {
        this.currentState = 1;
        this.ekX.setRecoveryState(1);
        this.ekX.start();
        this.OY.setVisibility(8);
        this.hZf.setVisibility(8);
        this.dMb.czp();
        showProgress();
        this.hZo.setVisibility(8);
        this.jty.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.jua && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pj)) {
            this.jua = false;
            this.jub = true;
            ei(this.mVideoUrl, this.Pj);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.ekX != null) {
            this.ekX.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.ekX.isPlaying() && this.jtV) {
            cyg();
        }
        this.ekX.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.ekX.isPlaying() && this.jtV) {
            cyg();
        }
        this.currentState = 5;
        this.ekX.setRecoveryState(5);
        e.gx().removeCallbacks(this.EO);
        e.gx().removeCallbacks(this.hZN);
        this.ekX.stopPlayback();
        this.EI = false;
        this.juc = false;
        this.mStartPosition = 0;
        bPO();
    }

    public void cyg() {
        x.czs().bl(this.mVideoUrl, this.ekX.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(boolean z) {
        this.hZf.setVisibility(0);
        this.hZo.setVisibility(0);
        this.jty.setVisibility(8);
        this.dMb.czp();
        this.jtv.setVisibility(8);
        this.fMf.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.OY.setVisibility(z ? 0 : 8);
    }

    public void bPO() {
        rI(true);
    }

    public boolean le() {
        if (this.ekX == null) {
            return false;
        }
        return this.ekX.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ekX == null) {
            return 0;
        }
        return this.ekX.getCurrentPosition();
    }

    public void showProgress() {
        if (this.ekX != null) {
            this.jtv.setVisibility(0);
            this.dZS = ((this.ekX.getDuration() / 200) / 50) * 50;
            if (this.dZS < 50) {
                this.dZS = 50;
            } else if (this.dZS > 500) {
                this.dZS = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dZS - (this.ekX.getCurrentPosition() % this.dZS));
        }
    }

    private void cyh() {
        a(this.mVideoUrl, this.Pj, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cyi();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.jtX = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.iXV && !com.baidu.tieba.video.g.cPh().cPi()) {
            this.iXM.setVisibility(0);
            this.iXM.setData(this.jCe.getDuration(), this.jCe.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cyi() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.cPh().fy(getContext());
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
        if (view == this.fMf) {
            cyh();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 2).cy("tid", this.Pj));
            csm();
        } else if (view == this.jty) {
            ei(this.mVideoUrl, this.Pj);
        } else if (view == this.iXM.getTvPlay()) {
            this.iXV = true;
            this.iXM.setVisibility(8);
            ei(this.mVideoUrl, this.Pj);
        } else if (view == this.iXM.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.gx().removeCallbacks(this.hZN);
        e.gx().removeCallbacks(this.jui);
        this.mHandler.removeMessages(1);
        this.hZJ.unregister(getContext());
    }
}
