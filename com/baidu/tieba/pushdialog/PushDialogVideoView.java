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
import com.baidu.adp.lib.g.e;
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
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.QuickVideoView;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.x;
import com.baidu.tieba.play.y;
/* loaded from: classes3.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean Cd;
    private Runnable Cj;
    private x cUk;
    private QuickVideoView.b cUt;
    private String cmS;
    private String cmf;
    private int currentState;
    private g.a ddK;
    private g.f ddL;
    private g.InterfaceC0498g ddO;
    private int diJ;
    private g drt;
    private QuickVideoView dwx;
    private VideoLoadingProgressView.a eMT;
    private View ePz;
    private TextView exe;
    private CallStateReceiver hgT;
    private g.b hgW;
    private Runnable hgX;
    private View hgo;
    private ImageView hgx;
    private TbImageView hgy;
    private CustomMessageListener hhc;
    private VideoControllerView.b hiY;
    private f iEb;
    private PbVideoWifiTipLayout ieH;
    private boolean ieQ;
    private boolean iew;
    private ProgressBar ivS;
    private TextView ivV;
    private Runnable iwE;
    private QuickVideoView.a iwG;
    private boolean iwr;
    private boolean iws;
    private boolean iwt;
    private boolean iww;
    private boolean iwx;
    private boolean iwy;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void pP(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.diJ = 50;
        this.mSkinType = 3;
        this.Cd = false;
        this.mStartPosition = 0;
        this.iwr = true;
        this.iws = false;
        this.iwt = false;
        this.currentState = -1;
        this.iew = false;
        this.ddL = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.drt = gVar;
                PushDialogVideoView.this.cUk.ccN();
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bad();
            }
        };
        this.Cj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dwx.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Cd = true;
                    PushDialogVideoView.this.hgo.setVisibility(8);
                    PushDialogVideoView.this.ePz.setVisibility(8);
                    PushDialogVideoView.this.cUk.ccO();
                    PushDialogVideoView.this.hgy.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.fZ().postDelayed(PushDialogVideoView.this.Cj, 20L);
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Cd = false;
                PushDialogVideoView.this.iwy = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hgo.setVisibility(0);
                PushDialogVideoView.this.ivS.setVisibility(8);
                PushDialogVideoView.this.ivS.setProgress(PushDialogVideoView.this.ivS.getMax());
                if (PushDialogVideoView.this.dwx == null || PushDialogVideoView.this.dwx.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.ivV.setVisibility(0);
                }
                y.ccT().remove(PushDialogVideoView.this.cmf);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dwx.setRecoveryState(3);
                if (PushDialogVideoView.this.dwx != null && PushDialogVideoView.this.dwx.getDuration() <= 150000) {
                    PushDialogVideoView.this.cm(PushDialogVideoView.this.cmf, PushDialogVideoView.this.cmS);
                }
            }
        };
        this.hgW = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ePz.setVisibility(0);
                PushDialogVideoView.this.cUk.ccP();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dwx.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.iww = true;
                }
                PushDialogVideoView.this.iwy = false;
                return true;
            }
        };
        this.hgX = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ePz.setVisibility(0);
                PushDialogVideoView.this.cUk.ccP();
            }
        };
        this.ddO = new g.InterfaceC0498g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iws) {
                    e.fZ().postDelayed(PushDialogVideoView.this.iwE, 200L);
                }
            }
        };
        this.iwE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dwx == null || !PushDialogVideoView.this.iws) {
                    e.fZ().postDelayed(PushDialogVideoView.this.Cj, 200L);
                    PushDialogVideoView.this.iws = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dwx.getCurrentPosition()) {
                    PushDialogVideoView.this.iws = false;
                    e.fZ().postDelayed(PushDialogVideoView.this.Cj, 20L);
                } else {
                    e.fZ().postDelayed(PushDialogVideoView.this.iwE, 200L);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Cd = false;
                PushDialogVideoView.this.iwy = false;
                e.fZ().removeCallbacks(PushDialogVideoView.this.Cj);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgX);
            }
        };
        this.hhc = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dwx != null && PushDialogVideoView.this.dwx.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dwx.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dwx.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hiY != null) {
                                PushDialogVideoView.this.hiY.lE(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.diJ - (duration % PushDialogVideoView.this.diJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lE(int i) {
                int duration;
                if (PushDialogVideoView.this.dwx != null && (duration = PushDialogVideoView.this.dwx.getDuration()) > 0 && PushDialogVideoView.this.ivS != null) {
                    PushDialogVideoView.this.ivS.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iwG = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbZ() {
                PushDialogVideoView.this.cUk.startLoading();
                PushDialogVideoView.this.hgy.setVisibility(0);
                PushDialogVideoView.this.hgx.setVisibility(8);
                PushDialogVideoView.this.ivV.setVisibility(8);
                PushDialogVideoView.this.ePz.setVisibility(8);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgX);
                e.fZ().postDelayed(PushDialogVideoView.this.hgX, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.diJ = 50;
        this.mSkinType = 3;
        this.Cd = false;
        this.mStartPosition = 0;
        this.iwr = true;
        this.iws = false;
        this.iwt = false;
        this.currentState = -1;
        this.iew = false;
        this.ddL = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.drt = gVar;
                PushDialogVideoView.this.cUk.ccN();
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bad();
            }
        };
        this.Cj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dwx.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Cd = true;
                    PushDialogVideoView.this.hgo.setVisibility(8);
                    PushDialogVideoView.this.ePz.setVisibility(8);
                    PushDialogVideoView.this.cUk.ccO();
                    PushDialogVideoView.this.hgy.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.fZ().postDelayed(PushDialogVideoView.this.Cj, 20L);
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Cd = false;
                PushDialogVideoView.this.iwy = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hgo.setVisibility(0);
                PushDialogVideoView.this.ivS.setVisibility(8);
                PushDialogVideoView.this.ivS.setProgress(PushDialogVideoView.this.ivS.getMax());
                if (PushDialogVideoView.this.dwx == null || PushDialogVideoView.this.dwx.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.ivV.setVisibility(0);
                }
                y.ccT().remove(PushDialogVideoView.this.cmf);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dwx.setRecoveryState(3);
                if (PushDialogVideoView.this.dwx != null && PushDialogVideoView.this.dwx.getDuration() <= 150000) {
                    PushDialogVideoView.this.cm(PushDialogVideoView.this.cmf, PushDialogVideoView.this.cmS);
                }
            }
        };
        this.hgW = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.ePz.setVisibility(0);
                PushDialogVideoView.this.cUk.ccP();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dwx.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.iww = true;
                }
                PushDialogVideoView.this.iwy = false;
                return true;
            }
        };
        this.hgX = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ePz.setVisibility(0);
                PushDialogVideoView.this.cUk.ccP();
            }
        };
        this.ddO = new g.InterfaceC0498g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iws) {
                    e.fZ().postDelayed(PushDialogVideoView.this.iwE, 200L);
                }
            }
        };
        this.iwE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dwx == null || !PushDialogVideoView.this.iws) {
                    e.fZ().postDelayed(PushDialogVideoView.this.Cj, 200L);
                    PushDialogVideoView.this.iws = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dwx.getCurrentPosition()) {
                    PushDialogVideoView.this.iws = false;
                    e.fZ().postDelayed(PushDialogVideoView.this.Cj, 20L);
                } else {
                    e.fZ().postDelayed(PushDialogVideoView.this.iwE, 200L);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Cd = false;
                PushDialogVideoView.this.iwy = false;
                e.fZ().removeCallbacks(PushDialogVideoView.this.Cj);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgX);
            }
        };
        this.hhc = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dwx != null && PushDialogVideoView.this.dwx.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dwx.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dwx.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hiY != null) {
                                PushDialogVideoView.this.hiY.lE(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.diJ - (duration % PushDialogVideoView.this.diJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lE(int i) {
                int duration;
                if (PushDialogVideoView.this.dwx != null && (duration = PushDialogVideoView.this.dwx.getDuration()) > 0 && PushDialogVideoView.this.ivS != null) {
                    PushDialogVideoView.this.ivS.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iwG = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbZ() {
                PushDialogVideoView.this.cUk.startLoading();
                PushDialogVideoView.this.hgy.setVisibility(0);
                PushDialogVideoView.this.hgx.setVisibility(8);
                PushDialogVideoView.this.ivV.setVisibility(8);
                PushDialogVideoView.this.ePz.setVisibility(8);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgX);
                e.fZ().postDelayed(PushDialogVideoView.this.hgX, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.diJ = 50;
        this.mSkinType = 3;
        this.Cd = false;
        this.mStartPosition = 0;
        this.iwr = true;
        this.iws = false;
        this.iwt = false;
        this.currentState = -1;
        this.iew = false;
        this.ddL = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.drt = gVar;
                PushDialogVideoView.this.cUk.ccN();
            }
        };
        this.eMT = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.bad();
            }
        };
        this.Cj = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dwx.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.Cd = true;
                    PushDialogVideoView.this.hgo.setVisibility(8);
                    PushDialogVideoView.this.ePz.setVisibility(8);
                    PushDialogVideoView.this.cUk.ccO();
                    PushDialogVideoView.this.hgy.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.fZ().postDelayed(PushDialogVideoView.this.Cj, 20L);
            }
        };
        this.ddK = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.Cd = false;
                PushDialogVideoView.this.iwy = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.hgo.setVisibility(0);
                PushDialogVideoView.this.ivS.setVisibility(8);
                PushDialogVideoView.this.ivS.setProgress(PushDialogVideoView.this.ivS.getMax());
                if (PushDialogVideoView.this.dwx == null || PushDialogVideoView.this.dwx.getDuration() > 150000) {
                    PushDialogVideoView.this.pK(false);
                } else {
                    PushDialogVideoView.this.ivV.setVisibility(0);
                }
                y.ccT().remove(PushDialogVideoView.this.cmf);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.dwx.setRecoveryState(3);
                if (PushDialogVideoView.this.dwx != null && PushDialogVideoView.this.dwx.getDuration() <= 150000) {
                    PushDialogVideoView.this.cm(PushDialogVideoView.this.cmf, PushDialogVideoView.this.cmS);
                }
            }
        };
        this.hgW = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.ePz.setVisibility(0);
                PushDialogVideoView.this.cUk.ccP();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.dwx.setRecoveryState(4);
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.iww = true;
                }
                PushDialogVideoView.this.iwy = false;
                return true;
            }
        };
        this.hgX = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ePz.setVisibility(0);
                PushDialogVideoView.this.cUk.ccP();
            }
        };
        this.ddO = new g.InterfaceC0498g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0498g
            public void b(g gVar) {
                if (PushDialogVideoView.this.iws) {
                    e.fZ().postDelayed(PushDialogVideoView.this.iwE, 200L);
                }
            }
        };
        this.iwE = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.dwx == null || !PushDialogVideoView.this.iws) {
                    e.fZ().postDelayed(PushDialogVideoView.this.Cj, 200L);
                    PushDialogVideoView.this.iws = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.dwx.getCurrentPosition()) {
                    PushDialogVideoView.this.iws = false;
                    e.fZ().postDelayed(PushDialogVideoView.this.Cj, 20L);
                } else {
                    e.fZ().postDelayed(PushDialogVideoView.this.iwE, 200L);
                }
            }
        };
        this.cUt = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.Cd = false;
                PushDialogVideoView.this.iwy = false;
                e.fZ().removeCallbacks(PushDialogVideoView.this.Cj);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgX);
            }
        };
        this.hhc = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.dwx != null && PushDialogVideoView.this.dwx.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.dwx.getCurrentPosition();
                            int duration = PushDialogVideoView.this.dwx.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.hiY != null) {
                                PushDialogVideoView.this.hiY.lE(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.diJ - (duration % PushDialogVideoView.this.diJ));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.hiY = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void lE(int i2) {
                int duration;
                if (PushDialogVideoView.this.dwx != null && (duration = PushDialogVideoView.this.dwx.getDuration()) > 0 && PushDialogVideoView.this.ivS != null) {
                    PushDialogVideoView.this.ivS.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.iwG = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void cbZ() {
                PushDialogVideoView.this.cUk.startLoading();
                PushDialogVideoView.this.hgy.setVisibility(0);
                PushDialogVideoView.this.hgx.setVisibility(8);
                PushDialogVideoView.this.ivV.setVisibility(8);
                PushDialogVideoView.this.ePz.setVisibility(8);
                e.fZ().removeCallbacks(PushDialogVideoView.this.hgX);
                e.fZ().postDelayed(PushDialogVideoView.this.hgX, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.dwx = (QuickVideoView) findViewById(R.id.videoView);
        this.cUk = new x((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.cUk.setLoadingAnimationListener(this.eMT);
        this.ivS = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.ivS.setMax(this.mWidth);
        this.ivS.setProgress(0);
        this.hgo = findViewById(R.id.black_mask);
        this.ePz = findViewById(R.id.layout_error);
        this.hgx = (ImageView) findViewById(R.id.img_play);
        this.ivV = (TextView) findViewById(R.id.txt_replay);
        this.exe = (TextView) findViewById(R.id.push_dialog_video_time);
        this.hgy = (TbImageView) findViewById(R.id.video_thumbnail);
        this.ieH = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.hgy.setDefaultErrorResource(0);
        this.hgy.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.hgT = new CallStateReceiver();
        this.hgT.register(context);
        this.ePz.setOnClickListener(this);
        this.ivV.setOnClickListener(this);
        this.ieH.setOnPlayClickListener(this);
        this.ieH.setFreeClickListener(this);
        setOnClickListener(this);
        this.dwx.setOnPreparedListener(this.ddL);
        this.dwx.setOnCompletionListener(this.ddK);
        this.dwx.setOnErrorListener(this.hgW);
        this.dwx.setOnSeekCompleteListener(this.ddO);
        this.dwx.setOnSurfaceDestroyedListener(this.cUt);
        this.dwx.setOnRecoveryCallback(this.iwG);
        onChangeSkinType();
    }

    public void onPause() {
        if (kx()) {
            this.iew = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.iew = false;
        } else {
            this.iew = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.iew) {
            bIM();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.hhc);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.iEb = fVar;
        this.exe.setText(aq.stringForVideoTime(this.iEb.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.cmf = str;
        this.cmS = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.dwx.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bad() {
        if (this.dwx != null && this.drt != null) {
            if (this.iwy) {
                this.dwx.start();
                this.iwy = false;
            }
            e.fZ().removeCallbacks(this.Cj);
            e.fZ().postDelayed(this.Cj, 20L);
            e.fZ().removeCallbacks(this.hgX);
            if (this.dwx.ccq()) {
                this.currentState = 1;
                this.dwx.setRecoveryState(1);
            }
            if (this.drt != null) {
                this.mStartPosition = y.ccT().BS(this.cmf);
                if (this.mStartPosition != 0) {
                    if (this.dwx != null) {
                        this.dwx.xH(this.mStartPosition);
                    } else {
                        this.drt.seekTo(this.mStartPosition);
                    }
                    if (!this.iwx) {
                        showProgress();
                        e.fZ().removeCallbacks(this.Cj);
                    }
                    this.iws = true;
                }
            }
        }
    }

    public void bXW() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.dwx.isPlaying()) {
            pausePlay();
        } else if (this.Cd) {
            bIM();
        } else {
            cbN();
        }
    }

    public void setPauseState() {
        this.cUk.ccP();
        this.hgx.setVisibility(0);
        this.ivV.setVisibility(8);
        this.currentState = 2;
        this.dwx.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.iwt) {
            dF(str, str2);
        } else {
            cm(str, str2);
        }
        if (aVar != null) {
            aVar.pP(z);
        }
    }

    public void cm(String str, String str2) {
        cbO();
        this.iwy = true;
        this.currentState = 0;
        this.dwx.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.dwx.setVideoPath(str, str2);
        this.cUk.startLoading();
        this.hgy.setVisibility(0);
        this.hgx.setVisibility(8);
        this.ivV.setVisibility(8);
        this.ePz.setVisibility(8);
        e.fZ().removeCallbacks(this.hgX);
        e.fZ().postDelayed(this.hgX, 60000L);
    }

    public void dF(String str, String str2) {
        cbO();
        this.iwy = true;
        this.currentState = 0;
        this.dwx.setRecoveryState(0);
        this.cUk.startLoading();
        this.hgy.setVisibility(0);
        this.hgx.setVisibility(8);
        this.ivV.setVisibility(8);
        this.ePz.setVisibility(8);
        e.fZ().removeCallbacks(this.hgX);
        e.fZ().postDelayed(this.hgX, 60000L);
    }

    public void bIM() {
        this.currentState = 1;
        this.dwx.setRecoveryState(1);
        this.dwx.start();
        this.hgy.setVisibility(8);
        this.hgo.setVisibility(8);
        this.cUk.ccP();
        showProgress();
        this.hgx.setVisibility(8);
        this.ivV.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.iww && !StringUtils.isNull(this.cmf) && !StringUtils.isNull(this.cmS)) {
            this.iww = false;
            this.iwx = true;
            cm(this.cmf, this.cmS);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.dwx != null) {
            this.dwx.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.dwx.isPlaying() && this.iwr) {
            cbM();
        }
        this.dwx.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.dwx.isPlaying() && this.iwr) {
            cbM();
        }
        this.currentState = 5;
        this.dwx.setRecoveryState(5);
        e.fZ().removeCallbacks(this.Cj);
        e.fZ().removeCallbacks(this.hgX);
        this.dwx.stopPlayback();
        this.Cd = false;
        this.iwy = false;
        this.mStartPosition = 0;
        bvM();
    }

    public void cbM() {
        y.ccT().bd(this.cmf, this.dwx.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pK(boolean z) {
        this.hgo.setVisibility(0);
        this.hgx.setVisibility(0);
        this.ivV.setVisibility(8);
        this.cUk.ccP();
        this.ivS.setVisibility(8);
        this.ePz.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.hgy.setVisibility(z ? 0 : 8);
    }

    public void bvM() {
        pK(true);
    }

    public boolean kx() {
        if (this.dwx == null) {
            return false;
        }
        return this.dwx.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.dwx == null) {
            return 0;
        }
        return this.dwx.getCurrentPosition();
    }

    public void showProgress() {
        if (this.dwx != null) {
            this.ivS.setVisibility(0);
            this.diJ = ((this.dwx.getDuration() / 200) / 50) * 50;
            if (this.diJ < 50) {
                this.diJ = 50;
            } else if (this.diJ > 500) {
                this.diJ = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.diJ - (this.dwx.getCurrentPosition() % this.diJ));
        }
    }

    private void cbN() {
        a(this.cmf, this.cmS, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        cbO();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.iwt = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.ieQ && !com.baidu.tieba.video.g.csD().csE()) {
            this.ieH.setVisibility(0);
            this.ieH.setData(this.iEb.getDuration(), this.iEb.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void cbO() {
        if (j.isMobileNet()) {
            com.baidu.tieba.video.g.csD().ef(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.hgy.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ePz) {
            cbN();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").O("obj_locate", 2).bS("tid", this.cmS));
            bXW();
        } else if (view == this.ivV) {
            cm(this.cmf, this.cmS);
        } else if (view == this.ieH.getTvPlay()) {
            this.ieQ = true;
            this.ieH.setVisibility(8);
            cm(this.cmf, this.cmS);
        } else if (view == this.ieH.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.fZ().removeCallbacks(this.Cj);
        e.fZ().removeCallbacks(this.hgX);
        e.fZ().removeCallbacks(this.iwE);
        this.mHandler.removeMessages(1);
        this.hgT.unregister(getContext());
    }
}
