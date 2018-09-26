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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.e;
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
/* loaded from: classes3.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private String aZG;
    private String avN;
    private QuickVideoView bBg;
    private QuickVideoView.b bgC;
    private w bgt;
    private g.InterfaceC0225g bpB;
    private g.a bpx;
    private g.f bpy;
    private int btD;
    private VideoLoadingProgressView.a cED;
    private g cEr;
    private ImageView cHh;
    private View cHl;
    private TextView crz;
    private int currentState;
    private boolean eYE;
    private CallStateReceiver eYV;
    private Runnable eYY;
    private g.b eYZ;
    private View eYq;
    private TbImageView eYz;
    private Runnable eZa;
    private CustomMessageListener eZf;
    private boolean fUT;
    private PbVideoWifiTipLayout fVf;
    private boolean fVn;
    private VideoControllerView.b faZ;
    private ProgressBar glI;
    private TextView glL;
    private boolean gme;
    private boolean gmf;
    private boolean gmg;
    private boolean gmj;
    private boolean gmk;
    private boolean gml;
    private Runnable gmp;
    private QuickVideoView.a gmr;
    private f gsm;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void lT(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.btD = 50;
        this.mSkinType = 3;
        this.eYE = false;
        this.mStartPosition = 0;
        this.gme = true;
        this.gmf = false;
        this.gmg = false;
        this.currentState = -1;
        this.fUT = false;
        this.bpy = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cEr = gVar;
                PushDialogVideoView.this.bgt.bnt();
            }
        };
        this.cED = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aku();
            }
        };
        this.eYY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bBg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eYE = true;
                    PushDialogVideoView.this.eYq.setVisibility(8);
                    PushDialogVideoView.this.cHl.setVisibility(8);
                    PushDialogVideoView.this.bgt.bnu();
                    PushDialogVideoView.this.eYz.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jt().postDelayed(PushDialogVideoView.this.eYY, 20L);
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eYE = false;
                PushDialogVideoView.this.gml = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eYq.setVisibility(0);
                PushDialogVideoView.this.glI.setVisibility(8);
                PushDialogVideoView.this.glI.setProgress(PushDialogVideoView.this.glI.getMax());
                if (PushDialogVideoView.this.bBg == null || PushDialogVideoView.this.bBg.getDuration() > 150000) {
                    PushDialogVideoView.this.lO(false);
                } else {
                    PushDialogVideoView.this.glL.setVisibility(0);
                }
                x.bnz().remove(PushDialogVideoView.this.avN);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bBg.setRecoveryState(3);
                if (PushDialogVideoView.this.bBg != null && PushDialogVideoView.this.bBg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cb(PushDialogVideoView.this.avN, PushDialogVideoView.this.aZG);
                }
            }
        };
        this.eYZ = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cHl.setVisibility(0);
                PushDialogVideoView.this.bgt.bnv();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bBg.setRecoveryState(4);
                if (!j.kK()) {
                    PushDialogVideoView.this.gmj = true;
                }
                PushDialogVideoView.this.gml = false;
                return true;
            }
        };
        this.eZa = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cHl.setVisibility(0);
                PushDialogVideoView.this.bgt.bnv();
            }
        };
        this.bpB = new g.InterfaceC0225g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0225g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gmf) {
                    e.jt().postDelayed(PushDialogVideoView.this.gmp, 200L);
                }
            }
        };
        this.gmp = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bBg == null || !PushDialogVideoView.this.gmf) {
                    e.jt().postDelayed(PushDialogVideoView.this.eYY, 200L);
                    PushDialogVideoView.this.gmf = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bBg.getCurrentPosition()) {
                    PushDialogVideoView.this.gmf = false;
                    e.jt().postDelayed(PushDialogVideoView.this.eYY, 20L);
                } else {
                    e.jt().postDelayed(PushDialogVideoView.this.gmp, 200L);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eYE = false;
                PushDialogVideoView.this.gml = false;
                e.jt().removeCallbacks(PushDialogVideoView.this.eYY);
                e.jt().removeCallbacks(PushDialogVideoView.this.eZa);
            }
        };
        this.eZf = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bBg != null && PushDialogVideoView.this.bBg.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bBg.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bBg.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.faZ != null) {
                                PushDialogVideoView.this.faZ.gZ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.btD - (duration % PushDialogVideoView.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.faZ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gZ(int i) {
                int duration;
                if (PushDialogVideoView.this.bBg != null && (duration = PushDialogVideoView.this.bBg.getDuration()) > 0 && PushDialogVideoView.this.glI != null) {
                    PushDialogVideoView.this.glI.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gmr = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bmG() {
                PushDialogVideoView.this.bgt.startLoading();
                PushDialogVideoView.this.eYz.setVisibility(0);
                PushDialogVideoView.this.cHh.setVisibility(8);
                PushDialogVideoView.this.glL.setVisibility(8);
                PushDialogVideoView.this.cHl.setVisibility(8);
                e.jt().removeCallbacks(PushDialogVideoView.this.eZa);
                e.jt().postDelayed(PushDialogVideoView.this.eZa, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btD = 50;
        this.mSkinType = 3;
        this.eYE = false;
        this.mStartPosition = 0;
        this.gme = true;
        this.gmf = false;
        this.gmg = false;
        this.currentState = -1;
        this.fUT = false;
        this.bpy = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cEr = gVar;
                PushDialogVideoView.this.bgt.bnt();
            }
        };
        this.cED = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aku();
            }
        };
        this.eYY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bBg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eYE = true;
                    PushDialogVideoView.this.eYq.setVisibility(8);
                    PushDialogVideoView.this.cHl.setVisibility(8);
                    PushDialogVideoView.this.bgt.bnu();
                    PushDialogVideoView.this.eYz.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jt().postDelayed(PushDialogVideoView.this.eYY, 20L);
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eYE = false;
                PushDialogVideoView.this.gml = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eYq.setVisibility(0);
                PushDialogVideoView.this.glI.setVisibility(8);
                PushDialogVideoView.this.glI.setProgress(PushDialogVideoView.this.glI.getMax());
                if (PushDialogVideoView.this.bBg == null || PushDialogVideoView.this.bBg.getDuration() > 150000) {
                    PushDialogVideoView.this.lO(false);
                } else {
                    PushDialogVideoView.this.glL.setVisibility(0);
                }
                x.bnz().remove(PushDialogVideoView.this.avN);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bBg.setRecoveryState(3);
                if (PushDialogVideoView.this.bBg != null && PushDialogVideoView.this.bBg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cb(PushDialogVideoView.this.avN, PushDialogVideoView.this.aZG);
                }
            }
        };
        this.eYZ = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cHl.setVisibility(0);
                PushDialogVideoView.this.bgt.bnv();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bBg.setRecoveryState(4);
                if (!j.kK()) {
                    PushDialogVideoView.this.gmj = true;
                }
                PushDialogVideoView.this.gml = false;
                return true;
            }
        };
        this.eZa = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cHl.setVisibility(0);
                PushDialogVideoView.this.bgt.bnv();
            }
        };
        this.bpB = new g.InterfaceC0225g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0225g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gmf) {
                    e.jt().postDelayed(PushDialogVideoView.this.gmp, 200L);
                }
            }
        };
        this.gmp = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bBg == null || !PushDialogVideoView.this.gmf) {
                    e.jt().postDelayed(PushDialogVideoView.this.eYY, 200L);
                    PushDialogVideoView.this.gmf = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bBg.getCurrentPosition()) {
                    PushDialogVideoView.this.gmf = false;
                    e.jt().postDelayed(PushDialogVideoView.this.eYY, 20L);
                } else {
                    e.jt().postDelayed(PushDialogVideoView.this.gmp, 200L);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eYE = false;
                PushDialogVideoView.this.gml = false;
                e.jt().removeCallbacks(PushDialogVideoView.this.eYY);
                e.jt().removeCallbacks(PushDialogVideoView.this.eZa);
            }
        };
        this.eZf = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bBg != null && PushDialogVideoView.this.bBg.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bBg.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bBg.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.faZ != null) {
                                PushDialogVideoView.this.faZ.gZ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.btD - (duration % PushDialogVideoView.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.faZ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gZ(int i) {
                int duration;
                if (PushDialogVideoView.this.bBg != null && (duration = PushDialogVideoView.this.bBg.getDuration()) > 0 && PushDialogVideoView.this.glI != null) {
                    PushDialogVideoView.this.glI.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gmr = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bmG() {
                PushDialogVideoView.this.bgt.startLoading();
                PushDialogVideoView.this.eYz.setVisibility(0);
                PushDialogVideoView.this.cHh.setVisibility(8);
                PushDialogVideoView.this.glL.setVisibility(8);
                PushDialogVideoView.this.cHl.setVisibility(8);
                e.jt().removeCallbacks(PushDialogVideoView.this.eZa);
                e.jt().postDelayed(PushDialogVideoView.this.eZa, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btD = 50;
        this.mSkinType = 3;
        this.eYE = false;
        this.mStartPosition = 0;
        this.gme = true;
        this.gmf = false;
        this.gmg = false;
        this.currentState = -1;
        this.fUT = false;
        this.bpy = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cEr = gVar;
                PushDialogVideoView.this.bgt.bnt();
            }
        };
        this.cED = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aku();
            }
        };
        this.eYY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bBg.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eYE = true;
                    PushDialogVideoView.this.eYq.setVisibility(8);
                    PushDialogVideoView.this.cHl.setVisibility(8);
                    PushDialogVideoView.this.bgt.bnu();
                    PushDialogVideoView.this.eYz.setVisibility(8);
                    if (PushDialogVideoView.this.currentState == 1 || PushDialogVideoView.this.currentState == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.jt().postDelayed(PushDialogVideoView.this.eYY, 20L);
            }
        };
        this.bpx = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eYE = false;
                PushDialogVideoView.this.gml = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eYq.setVisibility(0);
                PushDialogVideoView.this.glI.setVisibility(8);
                PushDialogVideoView.this.glI.setProgress(PushDialogVideoView.this.glI.getMax());
                if (PushDialogVideoView.this.bBg == null || PushDialogVideoView.this.bBg.getDuration() > 150000) {
                    PushDialogVideoView.this.lO(false);
                } else {
                    PushDialogVideoView.this.glL.setVisibility(0);
                }
                x.bnz().remove(PushDialogVideoView.this.avN);
                PushDialogVideoView.this.currentState = 3;
                PushDialogVideoView.this.bBg.setRecoveryState(3);
                if (PushDialogVideoView.this.bBg != null && PushDialogVideoView.this.bBg.getDuration() <= 150000) {
                    PushDialogVideoView.this.cb(PushDialogVideoView.this.avN, PushDialogVideoView.this.aZG);
                }
            }
        };
        this.eYZ = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.cHl.setVisibility(0);
                PushDialogVideoView.this.bgt.bnv();
                PushDialogVideoView.this.currentState = 4;
                PushDialogVideoView.this.bBg.setRecoveryState(4);
                if (!j.kK()) {
                    PushDialogVideoView.this.gmj = true;
                }
                PushDialogVideoView.this.gml = false;
                return true;
            }
        };
        this.eZa = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cHl.setVisibility(0);
                PushDialogVideoView.this.bgt.bnv();
            }
        };
        this.bpB = new g.InterfaceC0225g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0225g
            public void b(g gVar) {
                if (PushDialogVideoView.this.gmf) {
                    e.jt().postDelayed(PushDialogVideoView.this.gmp, 200L);
                }
            }
        };
        this.gmp = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bBg == null || !PushDialogVideoView.this.gmf) {
                    e.jt().postDelayed(PushDialogVideoView.this.eYY, 200L);
                    PushDialogVideoView.this.gmf = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bBg.getCurrentPosition()) {
                    PushDialogVideoView.this.gmf = false;
                    e.jt().postDelayed(PushDialogVideoView.this.eYY, 20L);
                } else {
                    e.jt().postDelayed(PushDialogVideoView.this.gmp, 200L);
                }
            }
        };
        this.bgC = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eYE = false;
                PushDialogVideoView.this.gml = false;
                e.jt().removeCallbacks(PushDialogVideoView.this.eYY);
                e.jt().removeCallbacks(PushDialogVideoView.this.eZa);
            }
        };
        this.eZf = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bBg != null && PushDialogVideoView.this.bBg.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bBg.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bBg.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.faZ != null) {
                                PushDialogVideoView.this.faZ.gZ(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.btD - (duration % PushDialogVideoView.this.btD));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.faZ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gZ(int i2) {
                int duration;
                if (PushDialogVideoView.this.bBg != null && (duration = PushDialogVideoView.this.bBg.getDuration()) > 0 && PushDialogVideoView.this.glI != null) {
                    PushDialogVideoView.this.glI.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gmr = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bmG() {
                PushDialogVideoView.this.bgt.startLoading();
                PushDialogVideoView.this.eYz.setVisibility(0);
                PushDialogVideoView.this.cHh.setVisibility(8);
                PushDialogVideoView.this.glL.setVisibility(8);
                PushDialogVideoView.this.cHl.setVisibility(8);
                e.jt().removeCallbacks(PushDialogVideoView.this.eZa);
                e.jt().postDelayed(PushDialogVideoView.this.eZa, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.aO(context) - l.h(context, e.C0141e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bBg = (QuickVideoView) findViewById(e.g.videoView);
        this.bgt = new w((ViewGroup) findViewById(e.g.auto_video_loading_container));
        this.bgt.setLoadingAnimationListener(this.cED);
        this.glI = (ProgressBar) findViewById(e.g.pgrBottomProgress);
        this.glI.setMax(this.mWidth);
        this.glI.setProgress(0);
        this.eYq = findViewById(e.g.black_mask);
        this.cHl = findViewById(e.g.layout_error);
        this.cHh = (ImageView) findViewById(e.g.img_play);
        this.glL = (TextView) findViewById(e.g.txt_replay);
        this.crz = (TextView) findViewById(e.g.push_dialog_video_time);
        this.eYz = (TbImageView) findViewById(e.g.video_thumbnail);
        this.fVf = (PbVideoWifiTipLayout) findViewById(e.g.layout_wifi_tip);
        this.eYz.setDefaultErrorResource(0);
        this.eYz.setDefaultBgResource(e.f.pic_bg_video_frs);
        this.eYV = new CallStateReceiver();
        this.eYV.register(context);
        this.cHl.setOnClickListener(this);
        this.glL.setOnClickListener(this);
        this.fVf.setOnPlayClickListener(this);
        this.fVf.setFreeClickListener(this);
        setOnClickListener(this);
        this.bBg.setOnPreparedListener(this.bpy);
        this.bBg.setOnCompletionListener(this.bpx);
        this.bBg.setOnErrorListener(this.eYZ);
        this.bBg.setOnSeekCompleteListener(this.bpB);
        this.bBg.setOnSurfaceDestroyedListener(this.bgC);
        this.bBg.setOnRecoveryCallback(this.gmr);
        onChangeSkinType();
    }

    public void onPause() {
        if (bmu()) {
            this.fUT = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.fUT = false;
        } else {
            this.fUT = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.fUT) {
            aUr();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.eZf);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gsm = fVar;
        this.crz.setText(ao.dj(this.gsm.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.avN = str;
        this.aZG = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bBg.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        if (this.bBg != null && this.cEr != null) {
            if (this.gml) {
                this.bBg.start();
                this.gml = false;
            }
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
            com.baidu.adp.lib.g.e.jt().postDelayed(this.eYY, 20L);
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
            if (this.bBg.bmW()) {
                this.currentState = 1;
                this.bBg.setRecoveryState(1);
            }
            if (this.cEr != null) {
                this.mStartPosition = x.bnz().sP(this.avN);
                if (this.mStartPosition != 0) {
                    if (this.bBg != null) {
                        this.bBg.se(this.mStartPosition);
                    } else {
                        this.cEr.seekTo(this.mStartPosition);
                    }
                    if (!this.gmk) {
                        showProgress();
                        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
                    }
                    this.gmf = true;
                }
            }
        }
    }

    public void biN() {
        if (!j.kK()) {
            l.S(getContext(), getContext().getString(e.j.neterror));
        } else if (this.bBg.isPlaying()) {
            pausePlay();
        } else if (this.eYE) {
            aUr();
        } else {
            bmv();
        }
    }

    public void setPauseState() {
        this.bgt.bnv();
        this.cHh.setVisibility(0);
        this.glL.setVisibility(8);
        this.currentState = 2;
        this.bBg.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.gmg) {
            cc(str, str2);
        } else {
            cb(str, str2);
        }
        if (aVar != null) {
            aVar.lT(z);
        }
    }

    public void cb(String str, String str2) {
        bmw();
        this.gml = true;
        this.currentState = 0;
        this.bBg.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bBg.setVideoPath(str, str2);
        this.bgt.startLoading();
        this.eYz.setVisibility(0);
        this.cHh.setVisibility(8);
        this.glL.setVisibility(8);
        this.cHl.setVisibility(8);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.eZa, 60000L);
    }

    public void cc(String str, String str2) {
        bmw();
        this.gml = true;
        this.currentState = 0;
        this.bBg.setRecoveryState(0);
        this.bgt.startLoading();
        this.eYz.setVisibility(0);
        this.cHh.setVisibility(8);
        this.glL.setVisibility(8);
        this.cHl.setVisibility(8);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().postDelayed(this.eZa, 60000L);
    }

    public void aUr() {
        this.currentState = 1;
        this.bBg.setRecoveryState(1);
        this.bBg.start();
        this.eYz.setVisibility(8);
        this.eYq.setVisibility(8);
        this.bgt.bnv();
        showProgress();
        this.cHh.setVisibility(8);
        this.glL.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.kK() && this.gmj && !StringUtils.isNull(this.avN) && !StringUtils.isNull(this.aZG)) {
            this.gmj = false;
            this.gmk = true;
            cb(this.avN, this.aZG);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bBg != null) {
            this.bBg.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bBg.isPlaying() && this.gme) {
            bmt();
        }
        this.bBg.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bBg.isPlaying() && this.gme) {
            bmt();
        }
        this.currentState = 5;
        this.bBg.setRecoveryState(5);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        this.bBg.stopPlayback();
        this.eYE = false;
        this.gml = false;
        this.mStartPosition = 0;
        aHp();
    }

    public void bmt() {
        x.bnz().aI(this.avN, this.bBg.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(boolean z) {
        this.eYq.setVisibility(0);
        this.cHh.setVisibility(0);
        this.glL.setVisibility(8);
        this.bgt.bnv();
        this.glI.setVisibility(8);
        this.cHl.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.eYz.setVisibility(z ? 0 : 8);
    }

    public void aHp() {
        lO(true);
    }

    public boolean bmu() {
        if (this.bBg == null) {
            return false;
        }
        return this.bBg.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bBg == null) {
            return 0;
        }
        return this.bBg.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bBg != null) {
            this.glI.setVisibility(0);
            this.btD = ((this.bBg.getDuration() / 200) / 50) * 50;
            if (this.btD < 50) {
                this.btD = 50;
            } else if (this.btD > 500) {
                this.btD = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.btD - (this.bBg.getCurrentPosition() % this.btD));
        }
    }

    private void bmv() {
        a(this.avN, this.aZG, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bmw();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.gmg = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.kM() && !this.fVn && !com.baidu.tieba.video.g.bCZ().bDa()) {
            this.fVf.setVisibility(0);
            this.fVf.setData(this.gsm.getDuration(), this.gsm.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bmw() {
        if (j.kM()) {
            com.baidu.tieba.video.g.bCZ().cR(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.eYz.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cHl) {
            bmv();
        } else if (view == this) {
            TiebaStatic.log(new am("c13199").w("obj_locate", 2).al("tid", this.aZG));
            biN();
        } else if (view == this.glL) {
            cb(this.avN, this.aZG);
        } else if (view == this.fVf.getTvPlay()) {
            this.fVn = true;
            this.fVf.setVisibility(8);
            cb(this.avN, this.aZG);
        } else if (view == this.fVf.getTvOpenFreeData() && this.mPageContext != null) {
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
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eYY);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.eZa);
        com.baidu.adp.lib.g.e.jt().removeCallbacks(this.gmp);
        this.mHandler.removeMessages(1);
        this.eYV.unregister(getContext());
    }
}
