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
    private TbImageView OZ;
    private String Pk;
    private int currentState;
    private w dME;
    private QuickVideoView.b dMN;
    private g.a dVF;
    private g.f dVG;
    private g.InterfaceC0591g dVJ;
    private int eav;
    private g efr;
    private QuickVideoView elA;
    private VideoLoadingProgressView.a fKw;
    private View fNa;
    private TextView fum;
    private boolean iZI;
    private boolean iZo;
    private PbVideoWifiTipLayout iZz;
    private View iaR;
    private CustomMessageListener ibE;
    private ImageView iba;
    private CallStateReceiver ibv;
    private g.b iby;
    private Runnable ibz;
    private VideoControllerView.b idC;
    private i jDP;
    private boolean jvG;
    private boolean jvH;
    private boolean jvI;
    private boolean jvL;
    private boolean jvM;
    private boolean jvN;
    private Runnable jvT;
    private QuickVideoView.a jvV;
    private ProgressBar jvg;
    private TextView jvj;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes8.dex */
    public interface a {
        void rT(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.eav = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jvG = true;
        this.jvH = false;
        this.jvI = false;
        this.currentState = -1;
        this.iZo = false;
        this.dVG = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.efr = gVar;
                PushDialogVideoView.this.dME.czH();
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buT();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elA.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.iaR.setVisibility(8);
                    PushDialogVideoView.this.fNa.setVisibility(8);
                    PushDialogVideoView.this.dME.czI();
                    PushDialogVideoView.this.OZ.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jvN = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iaR.setVisibility(0);
                PushDialogVideoView.this.jvg.setVisibility(8);
                PushDialogVideoView.this.jvg.setProgress(PushDialogVideoView.this.jvg.getMax());
                if (PushDialogVideoView.this.elA == null || PushDialogVideoView.this.elA.getDuration() > 150000) {
                    PushDialogVideoView.this.rO(false);
                } else {
                    PushDialogVideoView.this.jvj.setVisibility(0);
                }
                x.czM().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.elA.setRecoveryState(3);
                if (PushDialogVideoView.this.elA != null && PushDialogVideoView.this.elA.getDuration() <= 150000) {
                    PushDialogVideoView.this.eg(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pk);
                }
            }
        };
        this.iby = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fNa.setVisibility(0);
                PushDialogVideoView.this.dME.czJ();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.elA.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jvL = true;
                }
                PushDialogVideoView.this.jvN = false;
                return true;
            }
        };
        this.ibz = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fNa.setVisibility(0);
                PushDialogVideoView.this.dME.czJ();
            }
        };
        this.dVJ = new g.InterfaceC0591g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jvH) {
                    e.gx().postDelayed(PushDialogVideoView.this.jvT, 200L);
                }
            }
        };
        this.jvT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elA == null || !PushDialogVideoView.this.jvH) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jvH = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.elA.getCurrentPosition()) {
                    PushDialogVideoView.this.jvH = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jvT, 200L);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jvN = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.ibz);
            }
        };
        this.ibE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.elA != null && PushDialogVideoView.this.elA.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.elA.getCurrentPosition();
                            int duration = PushDialogVideoView.this.elA.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.idC != null) {
                                PushDialogVideoView.this.idC.ok(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eav - (duration % PushDialogVideoView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.idC = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ok(int i) {
                int duration;
                if (PushDialogVideoView.this.elA != null && (duration = PushDialogVideoView.this.elA.getDuration()) > 0 && PushDialogVideoView.this.jvg != null) {
                    PushDialogVideoView.this.jvg.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jvV = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyN() {
                PushDialogVideoView.this.dME.startLoading();
                PushDialogVideoView.this.OZ.setVisibility(0);
                PushDialogVideoView.this.iba.setVisibility(8);
                PushDialogVideoView.this.jvj.setVisibility(8);
                PushDialogVideoView.this.fNa.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.ibz);
                e.gx().postDelayed(PushDialogVideoView.this.ibz, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eav = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jvG = true;
        this.jvH = false;
        this.jvI = false;
        this.currentState = -1;
        this.iZo = false;
        this.dVG = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.efr = gVar;
                PushDialogVideoView.this.dME.czH();
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buT();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elA.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.iaR.setVisibility(8);
                    PushDialogVideoView.this.fNa.setVisibility(8);
                    PushDialogVideoView.this.dME.czI();
                    PushDialogVideoView.this.OZ.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jvN = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iaR.setVisibility(0);
                PushDialogVideoView.this.jvg.setVisibility(8);
                PushDialogVideoView.this.jvg.setProgress(PushDialogVideoView.this.jvg.getMax());
                if (PushDialogVideoView.this.elA == null || PushDialogVideoView.this.elA.getDuration() > 150000) {
                    PushDialogVideoView.this.rO(false);
                } else {
                    PushDialogVideoView.this.jvj.setVisibility(0);
                }
                x.czM().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.elA.setRecoveryState(3);
                if (PushDialogVideoView.this.elA != null && PushDialogVideoView.this.elA.getDuration() <= 150000) {
                    PushDialogVideoView.this.eg(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pk);
                }
            }
        };
        this.iby = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fNa.setVisibility(0);
                PushDialogVideoView.this.dME.czJ();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.elA.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jvL = true;
                }
                PushDialogVideoView.this.jvN = false;
                return true;
            }
        };
        this.ibz = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fNa.setVisibility(0);
                PushDialogVideoView.this.dME.czJ();
            }
        };
        this.dVJ = new g.InterfaceC0591g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jvH) {
                    e.gx().postDelayed(PushDialogVideoView.this.jvT, 200L);
                }
            }
        };
        this.jvT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elA == null || !PushDialogVideoView.this.jvH) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jvH = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.elA.getCurrentPosition()) {
                    PushDialogVideoView.this.jvH = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jvT, 200L);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jvN = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.ibz);
            }
        };
        this.ibE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.elA != null && PushDialogVideoView.this.elA.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.elA.getCurrentPosition();
                            int duration = PushDialogVideoView.this.elA.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.idC != null) {
                                PushDialogVideoView.this.idC.ok(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eav - (duration % PushDialogVideoView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.idC = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ok(int i) {
                int duration;
                if (PushDialogVideoView.this.elA != null && (duration = PushDialogVideoView.this.elA.getDuration()) > 0 && PushDialogVideoView.this.jvg != null) {
                    PushDialogVideoView.this.jvg.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jvV = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyN() {
                PushDialogVideoView.this.dME.startLoading();
                PushDialogVideoView.this.OZ.setVisibility(0);
                PushDialogVideoView.this.iba.setVisibility(8);
                PushDialogVideoView.this.jvj.setVisibility(8);
                PushDialogVideoView.this.fNa.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.ibz);
                e.gx().postDelayed(PushDialogVideoView.this.ibz, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eav = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jvG = true;
        this.jvH = false;
        this.jvI = false;
        this.currentState = -1;
        this.iZo = false;
        this.dVG = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.efr = gVar;
                PushDialogVideoView.this.dME.czH();
            }
        };
        this.fKw = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buT();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elA.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.iaR.setVisibility(8);
                    PushDialogVideoView.this.fNa.setVisibility(8);
                    PushDialogVideoView.this.dME.czI();
                    PushDialogVideoView.this.OZ.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
            }
        };
        this.dVF = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jvN = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.iaR.setVisibility(0);
                PushDialogVideoView.this.jvg.setVisibility(8);
                PushDialogVideoView.this.jvg.setProgress(PushDialogVideoView.this.jvg.getMax());
                if (PushDialogVideoView.this.elA == null || PushDialogVideoView.this.elA.getDuration() > 150000) {
                    PushDialogVideoView.this.rO(false);
                } else {
                    PushDialogVideoView.this.jvj.setVisibility(0);
                }
                x.czM().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.elA.setRecoveryState(3);
                if (PushDialogVideoView.this.elA != null && PushDialogVideoView.this.elA.getDuration() <= 150000) {
                    PushDialogVideoView.this.eg(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pk);
                }
            }
        };
        this.iby = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.fNa.setVisibility(0);
                PushDialogVideoView.this.dME.czJ();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.elA.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jvL = true;
                }
                PushDialogVideoView.this.jvN = false;
                return true;
            }
        };
        this.ibz = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fNa.setVisibility(0);
                PushDialogVideoView.this.dME.czJ();
            }
        };
        this.dVJ = new g.InterfaceC0591g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0591g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jvH) {
                    e.gx().postDelayed(PushDialogVideoView.this.jvT, 200L);
                }
            }
        };
        this.jvT = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.elA == null || !PushDialogVideoView.this.jvH) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jvH = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.elA.getCurrentPosition()) {
                    PushDialogVideoView.this.jvH = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jvT, 200L);
                }
            }
        };
        this.dMN = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jvN = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.ibz);
            }
        };
        this.ibE = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.elA != null && PushDialogVideoView.this.elA.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.elA.getCurrentPosition();
                            int duration = PushDialogVideoView.this.elA.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.idC != null) {
                                PushDialogVideoView.this.idC.ok(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.eav - (duration % PushDialogVideoView.this.eav));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.idC = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void ok(int i2) {
                int duration;
                if (PushDialogVideoView.this.elA != null && (duration = PushDialogVideoView.this.elA.getDuration()) > 0 && PushDialogVideoView.this.jvg != null) {
                    PushDialogVideoView.this.jvg.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jvV = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyN() {
                PushDialogVideoView.this.dME.startLoading();
                PushDialogVideoView.this.OZ.setVisibility(0);
                PushDialogVideoView.this.iba.setVisibility(8);
                PushDialogVideoView.this.jvj.setVisibility(8);
                PushDialogVideoView.this.fNa.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.ibz);
                e.gx().postDelayed(PushDialogVideoView.this.ibz, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.elA = (QuickVideoView) findViewById(R.id.videoView);
        this.dME = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dME.setLoadingAnimationListener(this.fKw);
        this.jvg = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.jvg.setMax(this.mWidth);
        this.jvg.setProgress(0);
        this.iaR = findViewById(R.id.black_mask);
        this.fNa = findViewById(R.id.layout_error);
        this.iba = (ImageView) findViewById(R.id.img_play);
        this.jvj = (TextView) findViewById(R.id.txt_replay);
        this.fum = (TextView) findViewById(R.id.push_dialog_video_time);
        this.OZ = (TbImageView) findViewById(R.id.video_thumbnail);
        this.iZz = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.OZ.setDefaultErrorResource(0);
        this.OZ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ibv = new CallStateReceiver();
        this.ibv.register(context);
        this.fNa.setOnClickListener(this);
        this.jvj.setOnClickListener(this);
        this.iZz.setOnPlayClickListener(this);
        this.iZz.setFreeClickListener(this);
        setOnClickListener(this);
        this.elA.setOnPreparedListener(this.dVG);
        this.elA.setOnCompletionListener(this.dVF);
        this.elA.setOnErrorListener(this.iby);
        this.elA.setOnSeekCompleteListener(this.dVJ);
        this.elA.setOnSurfaceDestroyedListener(this.dMN);
        this.elA.setOnRecoveryCallback(this.jvV);
        onChangeSkinType();
    }

    public void onPause() {
        if (le()) {
            this.iZo = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iZo = false;
        } else {
            this.iZo = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iZo) {
            akd();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.ibE);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.jDP = iVar;
        this.fum.setText(aq.stringForVideoTime(this.jDP.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pk = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.elA.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buT() {
        if (this.elA != null && this.efr != null) {
            if (this.jvN) {
                this.elA.start();
                this.jvN = false;
            }
            e.gx().removeCallbacks(this.EO);
            e.gx().postDelayed(this.EO, 20L);
            e.gx().removeCallbacks(this.ibz);
            if (this.elA.czi()) {
                this.currentState = 1;
                this.elA.setRecoveryState(1);
            }
            if (this.efr != null) {
                this.mStartPosition = x.czM().Hd(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.elA != null) {
                        this.elA.AA(this.mStartPosition);
                    } else {
                        this.efr.seekTo(this.mStartPosition);
                    }
                    if (!this.jvM) {
                        showProgress();
                        e.gx().removeCallbacks(this.EO);
                    }
                    this.jvH = true;
                }
            }
        }
    }

    public void csI() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.elA.isPlaying()) {
            pausePlay();
        } else if (this.EI) {
            akd();
        } else {
            cyB();
        }
    }

    public void setPauseState() {
        this.dME.czJ();
        this.iba.setVisibility(0);
        this.jvj.setVisibility(8);
        this.currentState = 2;
        this.elA.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.jvI) {
            eh(str, str2);
        } else {
            eg(str, str2);
        }
        if (aVar != null) {
            aVar.rT(z);
        }
    }

    public void eg(String str, String str2) {
        cyC();
        this.jvN = true;
        this.currentState = 0;
        this.elA.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.elA.setVideoPath(str, str2);
        this.dME.startLoading();
        this.OZ.setVisibility(0);
        this.iba.setVisibility(8);
        this.jvj.setVisibility(8);
        this.fNa.setVisibility(8);
        e.gx().removeCallbacks(this.ibz);
        e.gx().postDelayed(this.ibz, 60000L);
    }

    public void eh(String str, String str2) {
        cyC();
        this.jvN = true;
        this.currentState = 0;
        this.elA.setRecoveryState(0);
        this.dME.startLoading();
        this.OZ.setVisibility(0);
        this.iba.setVisibility(8);
        this.jvj.setVisibility(8);
        this.fNa.setVisibility(8);
        e.gx().removeCallbacks(this.ibz);
        e.gx().postDelayed(this.ibz, 60000L);
    }

    public void akd() {
        this.currentState = 1;
        this.elA.setRecoveryState(1);
        this.elA.start();
        this.OZ.setVisibility(8);
        this.iaR.setVisibility(8);
        this.dME.czJ();
        showProgress();
        this.iba.setVisibility(8);
        this.jvj.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.jvL && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pk)) {
            this.jvL = false;
            this.jvM = true;
            eg(this.mVideoUrl, this.Pk);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.elA != null) {
            this.elA.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.elA.isPlaying() && this.jvG) {
            cyA();
        }
        this.elA.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.elA.isPlaying() && this.jvG) {
            cyA();
        }
        this.currentState = 5;
        this.elA.setRecoveryState(5);
        e.gx().removeCallbacks(this.EO);
        e.gx().removeCallbacks(this.ibz);
        this.elA.stopPlayback();
        this.EI = false;
        this.jvN = false;
        this.mStartPosition = 0;
        bQh();
    }

    public void cyA() {
        x.czM().bl(this.mVideoUrl, this.elA.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO(boolean z) {
        this.iaR.setVisibility(0);
        this.iba.setVisibility(0);
        this.jvj.setVisibility(8);
        this.dME.czJ();
        this.jvg.setVisibility(8);
        this.fNa.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.OZ.setVisibility(z ? 0 : 8);
    }

    public void bQh() {
        rO(true);
    }

    public boolean le() {
        if (this.elA == null) {
            return false;
        }
        return this.elA.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.elA == null) {
            return 0;
        }
        return this.elA.getCurrentPosition();
    }

    public void showProgress() {
        if (this.elA != null) {
            this.jvg.setVisibility(0);
            this.eav = ((this.elA.getDuration() / 200) / 50) * 50;
            if (this.eav < 50) {
                this.eav = 50;
            } else if (this.eav > 500) {
                this.eav = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.eav - (this.elA.getCurrentPosition() % this.eav));
        }
    }

    private void cyB() {
        a(this.mVideoUrl, this.Pk, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cyC();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.jvI = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.iZI && !com.baidu.tieba.video.g.cPC().cPD()) {
            this.iZz.setVisibility(0);
            this.iZz.setData(this.jDP.getDuration(), this.jDP.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cyC() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.cPC().fx(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.OZ.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fNa) {
            cyB();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 2).cx("tid", this.Pk));
            csI();
        } else if (view == this.jvj) {
            eg(this.mVideoUrl, this.Pk);
        } else if (view == this.iZz.getTvPlay()) {
            this.iZI = true;
            this.iZz.setVisibility(8);
            eg(this.mVideoUrl, this.Pk);
        } else if (view == this.iZz.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.gx().removeCallbacks(this.ibz);
        e.gx().removeCallbacks(this.jvT);
        this.mHandler.removeMessages(1);
        this.ibv.unregister(getContext());
    }
}
