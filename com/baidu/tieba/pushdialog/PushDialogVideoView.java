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
    private w dMa;
    private QuickVideoView.b dMj;
    private g.a dVb;
    private g.f dVc;
    private g.InterfaceC0590g dVf;
    private int dZR;
    private g eeN;
    private QuickVideoView ekW;
    private VideoLoadingProgressView.a fJz;
    private View fMd;
    private TextView ftz;
    private CallStateReceiver hZH;
    private g.b hZK;
    private Runnable hZL;
    private CustomMessageListener hZQ;
    private View hZd;
    private ImageView hZm;
    private PbVideoWifiTipLayout iXK;
    private boolean iXT;
    private boolean iXz;
    private VideoControllerView.b ibK;
    private i jCc;
    private boolean jtT;
    private boolean jtU;
    private boolean jtV;
    private boolean jtY;
    private boolean jtZ;
    private ProgressBar jtt;
    private TextView jtw;
    private boolean jua;
    private Runnable jug;
    private QuickVideoView.a jui;
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
        this.dZR = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jtT = true;
        this.jtU = false;
        this.jtV = false;
        this.currentState = -1;
        this.iXz = false;
        this.dVc = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eeN = gVar;
                PushDialogVideoView.this.dMa.czl();
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buL();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekW.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZd.setVisibility(8);
                    PushDialogVideoView.this.fMd.setVisibility(8);
                    PushDialogVideoView.this.dMa.czm();
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
        this.dVb = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jua = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZd.setVisibility(0);
                PushDialogVideoView.this.jtt.setVisibility(8);
                PushDialogVideoView.this.jtt.setProgress(PushDialogVideoView.this.jtt.getMax());
                if (PushDialogVideoView.this.ekW == null || PushDialogVideoView.this.ekW.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jtw.setVisibility(0);
                }
                x.czq().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ekW.setRecoveryState(3);
                if (PushDialogVideoView.this.ekW != null && PushDialogVideoView.this.ekW.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZK = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fMd.setVisibility(0);
                PushDialogVideoView.this.dMa.czn();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ekW.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jtY = true;
                }
                PushDialogVideoView.this.jua = false;
                return true;
            }
        };
        this.hZL = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMd.setVisibility(0);
                PushDialogVideoView.this.dMa.czn();
            }
        };
        this.dVf = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtU) {
                    e.gx().postDelayed(PushDialogVideoView.this.jug, 200L);
                }
            }
        };
        this.jug = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekW == null || !PushDialogVideoView.this.jtU) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jtU = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ekW.getCurrentPosition()) {
                    PushDialogVideoView.this.jtU = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jug, 200L);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jua = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZL);
            }
        };
        this.hZQ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.ekW != null && PushDialogVideoView.this.ekW.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ekW.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ekW.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibK != null) {
                                PushDialogVideoView.this.ibK.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dZR - (duration % PushDialogVideoView.this.dZR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibK = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i) {
                int duration;
                if (PushDialogVideoView.this.ekW != null && (duration = PushDialogVideoView.this.ekW.getDuration()) > 0 && PushDialogVideoView.this.jtt != null) {
                    PushDialogVideoView.this.jtt.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jui = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyr() {
                PushDialogVideoView.this.dMa.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZm.setVisibility(8);
                PushDialogVideoView.this.jtw.setVisibility(8);
                PushDialogVideoView.this.fMd.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZL);
                e.gx().postDelayed(PushDialogVideoView.this.hZL, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dZR = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jtT = true;
        this.jtU = false;
        this.jtV = false;
        this.currentState = -1;
        this.iXz = false;
        this.dVc = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eeN = gVar;
                PushDialogVideoView.this.dMa.czl();
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buL();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekW.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZd.setVisibility(8);
                    PushDialogVideoView.this.fMd.setVisibility(8);
                    PushDialogVideoView.this.dMa.czm();
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
        this.dVb = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jua = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZd.setVisibility(0);
                PushDialogVideoView.this.jtt.setVisibility(8);
                PushDialogVideoView.this.jtt.setProgress(PushDialogVideoView.this.jtt.getMax());
                if (PushDialogVideoView.this.ekW == null || PushDialogVideoView.this.ekW.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jtw.setVisibility(0);
                }
                x.czq().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ekW.setRecoveryState(3);
                if (PushDialogVideoView.this.ekW != null && PushDialogVideoView.this.ekW.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZK = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.fMd.setVisibility(0);
                PushDialogVideoView.this.dMa.czn();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ekW.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jtY = true;
                }
                PushDialogVideoView.this.jua = false;
                return true;
            }
        };
        this.hZL = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMd.setVisibility(0);
                PushDialogVideoView.this.dMa.czn();
            }
        };
        this.dVf = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtU) {
                    e.gx().postDelayed(PushDialogVideoView.this.jug, 200L);
                }
            }
        };
        this.jug = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekW == null || !PushDialogVideoView.this.jtU) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jtU = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ekW.getCurrentPosition()) {
                    PushDialogVideoView.this.jtU = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jug, 200L);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jua = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZL);
            }
        };
        this.hZQ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.ekW != null && PushDialogVideoView.this.ekW.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ekW.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ekW.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibK != null) {
                                PushDialogVideoView.this.ibK.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dZR - (duration % PushDialogVideoView.this.dZR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibK = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i) {
                int duration;
                if (PushDialogVideoView.this.ekW != null && (duration = PushDialogVideoView.this.ekW.getDuration()) > 0 && PushDialogVideoView.this.jtt != null) {
                    PushDialogVideoView.this.jtt.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jui = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyr() {
                PushDialogVideoView.this.dMa.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZm.setVisibility(8);
                PushDialogVideoView.this.jtw.setVisibility(8);
                PushDialogVideoView.this.fMd.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZL);
                e.gx().postDelayed(PushDialogVideoView.this.hZL, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dZR = 50;
        this.mSkinType = 3;
        this.EI = false;
        this.mStartPosition = 0;
        this.jtT = true;
        this.jtU = false;
        this.jtV = false;
        this.currentState = -1;
        this.iXz = false;
        this.dVc = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.eeN = gVar;
                PushDialogVideoView.this.dMa.czl();
            }
        };
        this.fJz = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.buL();
            }
        };
        this.EO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekW.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.EI = true;
                    PushDialogVideoView.this.hZd.setVisibility(8);
                    PushDialogVideoView.this.fMd.setVisibility(8);
                    PushDialogVideoView.this.dMa.czm();
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
        this.dVb = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jua = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hZd.setVisibility(0);
                PushDialogVideoView.this.jtt.setVisibility(8);
                PushDialogVideoView.this.jtt.setProgress(PushDialogVideoView.this.jtt.getMax());
                if (PushDialogVideoView.this.ekW == null || PushDialogVideoView.this.ekW.getDuration() > 150000) {
                    PushDialogVideoView.this.rI(false);
                } else {
                    PushDialogVideoView.this.jtw.setVisibility(0);
                }
                x.czq().remove(PushDialogVideoView.this.mVideoUrl);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.ekW.setRecoveryState(3);
                if (PushDialogVideoView.this.ekW != null && PushDialogVideoView.this.ekW.getDuration() <= 150000) {
                    PushDialogVideoView.this.ei(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.Pj);
                }
            }
        };
        this.hZK = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.fMd.setVisibility(0);
                PushDialogVideoView.this.dMa.czn();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.ekW.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.jtY = true;
                }
                PushDialogVideoView.this.jua = false;
                return true;
            }
        };
        this.hZL = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.fMd.setVisibility(0);
                PushDialogVideoView.this.dMa.czn();
            }
        };
        this.dVf = new g.InterfaceC0590g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0590g
            public void b(g gVar) {
                if (PushDialogVideoView.this.jtU) {
                    e.gx().postDelayed(PushDialogVideoView.this.jug, 200L);
                }
            }
        };
        this.jug = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.ekW == null || !PushDialogVideoView.this.jtU) {
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 200L);
                    PushDialogVideoView.this.jtU = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.ekW.getCurrentPosition()) {
                    PushDialogVideoView.this.jtU = false;
                    e.gx().postDelayed(PushDialogVideoView.this.EO, 20L);
                } else {
                    e.gx().postDelayed(PushDialogVideoView.this.jug, 200L);
                }
            }
        };
        this.dMj = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.EI = false;
                PushDialogVideoView.this.jua = false;
                e.gx().removeCallbacks(PushDialogVideoView.this.EO);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZL);
            }
        };
        this.hZQ = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.ekW != null && PushDialogVideoView.this.ekW.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.ekW.getCurrentPosition();
                            int duration = PushDialogVideoView.this.ekW.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.ibK != null) {
                                PushDialogVideoView.this.ibK.oi(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.dZR - (duration % PushDialogVideoView.this.dZR));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.ibK = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void oi(int i2) {
                int duration;
                if (PushDialogVideoView.this.ekW != null && (duration = PushDialogVideoView.this.ekW.getDuration()) > 0 && PushDialogVideoView.this.jtt != null) {
                    PushDialogVideoView.this.jtt.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.jui = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cyr() {
                PushDialogVideoView.this.dMa.startLoading();
                PushDialogVideoView.this.OY.setVisibility(0);
                PushDialogVideoView.this.hZm.setVisibility(8);
                PushDialogVideoView.this.jtw.setVisibility(8);
                PushDialogVideoView.this.fMd.setVisibility(8);
                e.gx().removeCallbacks(PushDialogVideoView.this.hZL);
                e.gx().postDelayed(PushDialogVideoView.this.hZL, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.ekW = (QuickVideoView) findViewById(R.id.videoView);
        this.dMa = new w((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.dMa.setLoadingAnimationListener(this.fJz);
        this.jtt = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.jtt.setMax(this.mWidth);
        this.jtt.setProgress(0);
        this.hZd = findViewById(R.id.black_mask);
        this.fMd = findViewById(R.id.layout_error);
        this.hZm = (ImageView) findViewById(R.id.img_play);
        this.jtw = (TextView) findViewById(R.id.txt_replay);
        this.ftz = (TextView) findViewById(R.id.push_dialog_video_time);
        this.OY = (TbImageView) findViewById(R.id.video_thumbnail);
        this.iXK = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.OY.setDefaultErrorResource(0);
        this.OY.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hZH = new CallStateReceiver();
        this.hZH.register(context);
        this.fMd.setOnClickListener(this);
        this.jtw.setOnClickListener(this);
        this.iXK.setOnPlayClickListener(this);
        this.iXK.setFreeClickListener(this);
        setOnClickListener(this);
        this.ekW.setOnPreparedListener(this.dVc);
        this.ekW.setOnCompletionListener(this.dVb);
        this.ekW.setOnErrorListener(this.hZK);
        this.ekW.setOnSeekCompleteListener(this.dVf);
        this.ekW.setOnSurfaceDestroyedListener(this.dMj);
        this.ekW.setOnRecoveryCallback(this.jui);
        onChangeSkinType();
    }

    public void onPause() {
        if (le()) {
            this.iXz = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iXz = false;
        } else {
            this.iXz = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iXz) {
            ajY();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hZQ);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.jCc = iVar;
        this.ftz.setText(aq.stringForVideoTime(this.jCc.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.Pj = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.ekW.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buL() {
        if (this.ekW != null && this.eeN != null) {
            if (this.jua) {
                this.ekW.start();
                this.jua = false;
            }
            e.gx().removeCallbacks(this.EO);
            e.gx().postDelayed(this.EO, 20L);
            e.gx().removeCallbacks(this.hZL);
            if (this.ekW.cyM()) {
                this.currentState = 1;
                this.ekW.setRecoveryState(1);
            }
            if (this.eeN != null) {
                this.mStartPosition = x.czq().Hd(this.mVideoUrl);
                if (this.mStartPosition != 0) {
                    if (this.ekW != null) {
                        this.ekW.As(this.mStartPosition);
                    } else {
                        this.eeN.seekTo(this.mStartPosition);
                    }
                    if (!this.jtZ) {
                        showProgress();
                        e.gx().removeCallbacks(this.EO);
                    }
                    this.jtU = true;
                }
            }
        }
    }

    public void csk() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.ekW.isPlaying()) {
            pausePlay();
        } else if (this.EI) {
            ajY();
        } else {
            cyf();
        }
    }

    public void setPauseState() {
        this.dMa.czn();
        this.hZm.setVisibility(0);
        this.jtw.setVisibility(8);
        this.currentState = 2;
        this.ekW.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.jtV) {
            ej(str, str2);
        } else {
            ei(str, str2);
        }
        if (aVar != null) {
            aVar.rN(z);
        }
    }

    public void ei(String str, String str2) {
        cyg();
        this.jua = true;
        this.currentState = 0;
        this.ekW.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.ekW.setVideoPath(str, str2);
        this.dMa.startLoading();
        this.OY.setVisibility(0);
        this.hZm.setVisibility(8);
        this.jtw.setVisibility(8);
        this.fMd.setVisibility(8);
        e.gx().removeCallbacks(this.hZL);
        e.gx().postDelayed(this.hZL, 60000L);
    }

    public void ej(String str, String str2) {
        cyg();
        this.jua = true;
        this.currentState = 0;
        this.ekW.setRecoveryState(0);
        this.dMa.startLoading();
        this.OY.setVisibility(0);
        this.hZm.setVisibility(8);
        this.jtw.setVisibility(8);
        this.fMd.setVisibility(8);
        e.gx().removeCallbacks(this.hZL);
        e.gx().postDelayed(this.hZL, 60000L);
    }

    public void ajY() {
        this.currentState = 1;
        this.ekW.setRecoveryState(1);
        this.ekW.start();
        this.OY.setVisibility(8);
        this.hZd.setVisibility(8);
        this.dMa.czn();
        showProgress();
        this.hZm.setVisibility(8);
        this.jtw.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.jtY && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.Pj)) {
            this.jtY = false;
            this.jtZ = true;
            ei(this.mVideoUrl, this.Pj);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.ekW != null) {
            this.ekW.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.ekW.isPlaying() && this.jtT) {
            cye();
        }
        this.ekW.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.ekW.isPlaying() && this.jtT) {
            cye();
        }
        this.currentState = 5;
        this.ekW.setRecoveryState(5);
        e.gx().removeCallbacks(this.EO);
        e.gx().removeCallbacks(this.hZL);
        this.ekW.stopPlayback();
        this.EI = false;
        this.jua = false;
        this.mStartPosition = 0;
        bPM();
    }

    public void cye() {
        x.czq().bl(this.mVideoUrl, this.ekW.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rI(boolean z) {
        this.hZd.setVisibility(0);
        this.hZm.setVisibility(0);
        this.jtw.setVisibility(8);
        this.dMa.czn();
        this.jtt.setVisibility(8);
        this.fMd.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.OY.setVisibility(z ? 0 : 8);
    }

    public void bPM() {
        rI(true);
    }

    public boolean le() {
        if (this.ekW == null) {
            return false;
        }
        return this.ekW.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.ekW == null) {
            return 0;
        }
        return this.ekW.getCurrentPosition();
    }

    public void showProgress() {
        if (this.ekW != null) {
            this.jtt.setVisibility(0);
            this.dZR = ((this.ekW.getDuration() / 200) / 50) * 50;
            if (this.dZR < 50) {
                this.dZR = 50;
            } else if (this.dZR > 500) {
                this.dZR = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.dZR - (this.ekW.getCurrentPosition() % this.dZR));
        }
    }

    private void cyf() {
        a(this.mVideoUrl, this.Pj, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cyg();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.jtV = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.iXT && !com.baidu.tieba.video.g.cPf().cPg()) {
            this.iXK.setVisibility(0);
            this.iXK.setData(this.jCc.getDuration(), this.jCc.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cyg() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.cPf().fy(getContext());
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
        if (view == this.fMd) {
            cyf();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").X("obj_locate", 2).cy("tid", this.Pj));
            csk();
        } else if (view == this.jtw) {
            ei(this.mVideoUrl, this.Pj);
        } else if (view == this.iXK.getTvPlay()) {
            this.iXT = true;
            this.iXK.setVisibility(8);
            ei(this.mVideoUrl, this.Pj);
        } else if (view == this.iXK.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.gx().removeCallbacks(this.hZL);
        e.gx().removeCallbacks(this.jug);
        this.mHandler.removeMessages(1);
        this.hZH.unregister(getContext());
    }
}
