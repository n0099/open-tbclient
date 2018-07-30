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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.d;
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
    private String aWq;
    private int avR;
    private w bcX;
    private String bdb;
    private QuickVideoView.b bdh;
    private g.a bjG;
    private g.f bjH;
    private g.InterfaceC0219g bjK;
    private int bnL;
    private QuickVideoView bvp;
    private ImageView cBs;
    private View cBw;
    private TextView clJ;
    private g cyE;
    private VideoLoadingProgressView.a cyP;
    private CallStateReceiver eRF;
    private Runnable eRI;
    private g.b eRJ;
    private Runnable eRK;
    private CustomMessageListener eRP;
    private View eRa;
    private TbImageView eRj;
    private boolean eRo;
    private VideoControllerView.b eTJ;
    private boolean fNg;
    private PbVideoWifiTipLayout fNs;
    private boolean fNz;
    private boolean geO;
    private boolean geP;
    private boolean geQ;
    private boolean geT;
    private boolean geU;
    private boolean geV;
    private Runnable geY;
    private ProgressBar geu;
    private TextView gex;
    private QuickVideoView.a gfa;
    private f gkR;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private int mWidth;

    /* loaded from: classes3.dex */
    public interface a {
        void lu(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.bnL = 50;
        this.mSkinType = 3;
        this.eRo = false;
        this.mStartPosition = 0;
        this.geO = true;
        this.geP = false;
        this.geQ = false;
        this.avR = -1;
        this.fNg = false;
        this.bjH = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cyE = gVar;
                PushDialogVideoView.this.bcX.bkQ();
            }
        };
        this.cyP = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aiH();
            }
        };
        this.eRI = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvp.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eRo = true;
                    PushDialogVideoView.this.eRa.setVisibility(8);
                    PushDialogVideoView.this.cBw.setVisibility(8);
                    PushDialogVideoView.this.bcX.bkR();
                    PushDialogVideoView.this.eRj.setVisibility(8);
                    if (PushDialogVideoView.this.avR == 1 || PushDialogVideoView.this.avR == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.in().postDelayed(PushDialogVideoView.this.eRI, 20L);
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eRo = false;
                PushDialogVideoView.this.geV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eRa.setVisibility(0);
                PushDialogVideoView.this.geu.setVisibility(8);
                PushDialogVideoView.this.geu.setProgress(PushDialogVideoView.this.geu.getMax());
                if (PushDialogVideoView.this.bvp == null || PushDialogVideoView.this.bvp.getDuration() > 150000) {
                    PushDialogVideoView.this.lr(false);
                } else {
                    PushDialogVideoView.this.gex.setVisibility(0);
                }
                x.bkW().remove(PushDialogVideoView.this.bdb);
                PushDialogVideoView.this.avR = 3;
                PushDialogVideoView.this.bvp.setRecoveryState(3);
                if (PushDialogVideoView.this.bvp != null && PushDialogVideoView.this.bvp.getDuration() <= 150000) {
                    PushDialogVideoView.this.bS(PushDialogVideoView.this.bdb, PushDialogVideoView.this.aWq);
                }
            }
        };
        this.eRJ = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cBw.setVisibility(0);
                PushDialogVideoView.this.bcX.bkS();
                PushDialogVideoView.this.avR = 4;
                PushDialogVideoView.this.bvp.setRecoveryState(4);
                if (!j.jE()) {
                    PushDialogVideoView.this.geT = true;
                }
                PushDialogVideoView.this.geV = false;
                return true;
            }
        };
        this.eRK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cBw.setVisibility(0);
                PushDialogVideoView.this.bcX.bkS();
            }
        };
        this.bjK = new g.InterfaceC0219g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (PushDialogVideoView.this.geP) {
                    e.in().postDelayed(PushDialogVideoView.this.geY, 200L);
                }
            }
        };
        this.geY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvp == null || !PushDialogVideoView.this.geP) {
                    e.in().postDelayed(PushDialogVideoView.this.eRI, 200L);
                    PushDialogVideoView.this.geP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bvp.getCurrentPosition()) {
                    PushDialogVideoView.this.geP = false;
                    e.in().postDelayed(PushDialogVideoView.this.eRI, 20L);
                } else {
                    e.in().postDelayed(PushDialogVideoView.this.geY, 200L);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eRo = false;
                PushDialogVideoView.this.geV = false;
                e.in().removeCallbacks(PushDialogVideoView.this.eRI);
                e.in().removeCallbacks(PushDialogVideoView.this.eRK);
            }
        };
        this.eRP = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bvp != null && PushDialogVideoView.this.bvp.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bvp.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bvp.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.eTJ != null) {
                                PushDialogVideoView.this.eTJ.gA(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bnL - (duration % PushDialogVideoView.this.bnL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eTJ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gA(int i) {
                int duration;
                if (PushDialogVideoView.this.bvp != null && (duration = PushDialogVideoView.this.bvp.getDuration()) > 0 && PushDialogVideoView.this.geu != null) {
                    PushDialogVideoView.this.geu.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gfa = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bkd() {
                PushDialogVideoView.this.bcX.startLoading();
                PushDialogVideoView.this.eRj.setVisibility(0);
                PushDialogVideoView.this.cBs.setVisibility(8);
                PushDialogVideoView.this.gex.setVisibility(8);
                PushDialogVideoView.this.cBw.setVisibility(8);
                e.in().removeCallbacks(PushDialogVideoView.this.eRK);
                e.in().postDelayed(PushDialogVideoView.this.eRK, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bnL = 50;
        this.mSkinType = 3;
        this.eRo = false;
        this.mStartPosition = 0;
        this.geO = true;
        this.geP = false;
        this.geQ = false;
        this.avR = -1;
        this.fNg = false;
        this.bjH = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cyE = gVar;
                PushDialogVideoView.this.bcX.bkQ();
            }
        };
        this.cyP = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aiH();
            }
        };
        this.eRI = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvp.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eRo = true;
                    PushDialogVideoView.this.eRa.setVisibility(8);
                    PushDialogVideoView.this.cBw.setVisibility(8);
                    PushDialogVideoView.this.bcX.bkR();
                    PushDialogVideoView.this.eRj.setVisibility(8);
                    if (PushDialogVideoView.this.avR == 1 || PushDialogVideoView.this.avR == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.in().postDelayed(PushDialogVideoView.this.eRI, 20L);
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eRo = false;
                PushDialogVideoView.this.geV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eRa.setVisibility(0);
                PushDialogVideoView.this.geu.setVisibility(8);
                PushDialogVideoView.this.geu.setProgress(PushDialogVideoView.this.geu.getMax());
                if (PushDialogVideoView.this.bvp == null || PushDialogVideoView.this.bvp.getDuration() > 150000) {
                    PushDialogVideoView.this.lr(false);
                } else {
                    PushDialogVideoView.this.gex.setVisibility(0);
                }
                x.bkW().remove(PushDialogVideoView.this.bdb);
                PushDialogVideoView.this.avR = 3;
                PushDialogVideoView.this.bvp.setRecoveryState(3);
                if (PushDialogVideoView.this.bvp != null && PushDialogVideoView.this.bvp.getDuration() <= 150000) {
                    PushDialogVideoView.this.bS(PushDialogVideoView.this.bdb, PushDialogVideoView.this.aWq);
                }
            }
        };
        this.eRJ = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i, int i2) {
                PushDialogVideoView.this.cBw.setVisibility(0);
                PushDialogVideoView.this.bcX.bkS();
                PushDialogVideoView.this.avR = 4;
                PushDialogVideoView.this.bvp.setRecoveryState(4);
                if (!j.jE()) {
                    PushDialogVideoView.this.geT = true;
                }
                PushDialogVideoView.this.geV = false;
                return true;
            }
        };
        this.eRK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cBw.setVisibility(0);
                PushDialogVideoView.this.bcX.bkS();
            }
        };
        this.bjK = new g.InterfaceC0219g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (PushDialogVideoView.this.geP) {
                    e.in().postDelayed(PushDialogVideoView.this.geY, 200L);
                }
            }
        };
        this.geY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvp == null || !PushDialogVideoView.this.geP) {
                    e.in().postDelayed(PushDialogVideoView.this.eRI, 200L);
                    PushDialogVideoView.this.geP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bvp.getCurrentPosition()) {
                    PushDialogVideoView.this.geP = false;
                    e.in().postDelayed(PushDialogVideoView.this.eRI, 20L);
                } else {
                    e.in().postDelayed(PushDialogVideoView.this.geY, 200L);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eRo = false;
                PushDialogVideoView.this.geV = false;
                e.in().removeCallbacks(PushDialogVideoView.this.eRI);
                e.in().removeCallbacks(PushDialogVideoView.this.eRK);
            }
        };
        this.eRP = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bvp != null && PushDialogVideoView.this.bvp.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bvp.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bvp.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.eTJ != null) {
                                PushDialogVideoView.this.eTJ.gA(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bnL - (duration % PushDialogVideoView.this.bnL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eTJ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gA(int i) {
                int duration;
                if (PushDialogVideoView.this.bvp != null && (duration = PushDialogVideoView.this.bvp.getDuration()) > 0 && PushDialogVideoView.this.geu != null) {
                    PushDialogVideoView.this.geu.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gfa = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bkd() {
                PushDialogVideoView.this.bcX.startLoading();
                PushDialogVideoView.this.eRj.setVisibility(0);
                PushDialogVideoView.this.cBs.setVisibility(8);
                PushDialogVideoView.this.gex.setVisibility(8);
                PushDialogVideoView.this.cBw.setVisibility(8);
                e.in().removeCallbacks(PushDialogVideoView.this.eRK);
                e.in().postDelayed(PushDialogVideoView.this.eRK, 60000L);
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bnL = 50;
        this.mSkinType = 3;
        this.eRo = false;
        this.mStartPosition = 0;
        this.geO = true;
        this.geP = false;
        this.geQ = false;
        this.avR = -1;
        this.fNg = false;
        this.bjH = new g.f() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.tieba.play.g.f
            public void onPrepared(g gVar) {
                PushDialogVideoView.this.cyE = gVar;
                PushDialogVideoView.this.bcX.bkQ();
            }
        };
        this.cyP = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.aiH();
            }
        };
        this.eRI = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvp.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.eRo = true;
                    PushDialogVideoView.this.eRa.setVisibility(8);
                    PushDialogVideoView.this.cBw.setVisibility(8);
                    PushDialogVideoView.this.bcX.bkR();
                    PushDialogVideoView.this.eRj.setVisibility(8);
                    if (PushDialogVideoView.this.avR == 1 || PushDialogVideoView.this.avR == 2) {
                        PushDialogVideoView.this.showProgress();
                        return;
                    }
                    return;
                }
                e.in().postDelayed(PushDialogVideoView.this.eRI, 20L);
            }
        };
        this.bjG = new g.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.tieba.play.g.a
            public void onCompletion(g gVar) {
                PushDialogVideoView.this.eRo = false;
                PushDialogVideoView.this.geV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.eRa.setVisibility(0);
                PushDialogVideoView.this.geu.setVisibility(8);
                PushDialogVideoView.this.geu.setProgress(PushDialogVideoView.this.geu.getMax());
                if (PushDialogVideoView.this.bvp == null || PushDialogVideoView.this.bvp.getDuration() > 150000) {
                    PushDialogVideoView.this.lr(false);
                } else {
                    PushDialogVideoView.this.gex.setVisibility(0);
                }
                x.bkW().remove(PushDialogVideoView.this.bdb);
                PushDialogVideoView.this.avR = 3;
                PushDialogVideoView.this.bvp.setRecoveryState(3);
                if (PushDialogVideoView.this.bvp != null && PushDialogVideoView.this.bvp.getDuration() <= 150000) {
                    PushDialogVideoView.this.bS(PushDialogVideoView.this.bdb, PushDialogVideoView.this.aWq);
                }
            }
        };
        this.eRJ = new g.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // com.baidu.tieba.play.g.b
            public boolean onError(g gVar, int i2, int i22) {
                PushDialogVideoView.this.cBw.setVisibility(0);
                PushDialogVideoView.this.bcX.bkS();
                PushDialogVideoView.this.avR = 4;
                PushDialogVideoView.this.bvp.setRecoveryState(4);
                if (!j.jE()) {
                    PushDialogVideoView.this.geT = true;
                }
                PushDialogVideoView.this.geV = false;
                return true;
            }
        };
        this.eRK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.cBw.setVisibility(0);
                PushDialogVideoView.this.bcX.bkS();
            }
        };
        this.bjK = new g.InterfaceC0219g() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // com.baidu.tieba.play.g.InterfaceC0219g
            public void b(g gVar) {
                if (PushDialogVideoView.this.geP) {
                    e.in().postDelayed(PushDialogVideoView.this.geY, 200L);
                }
            }
        };
        this.geY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.bvp == null || !PushDialogVideoView.this.geP) {
                    e.in().postDelayed(PushDialogVideoView.this.eRI, 200L);
                    PushDialogVideoView.this.geP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.bvp.getCurrentPosition()) {
                    PushDialogVideoView.this.geP = false;
                    e.in().postDelayed(PushDialogVideoView.this.eRI, 20L);
                } else {
                    e.in().postDelayed(PushDialogVideoView.this.geY, 200L);
                }
            }
        };
        this.bdh = new QuickVideoView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.13
            @Override // com.baidu.tieba.play.QuickVideoView.b
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.eRo = false;
                PushDialogVideoView.this.geV = false;
                e.in().removeCallbacks(PushDialogVideoView.this.eRI);
                e.in().removeCallbacks(PushDialogVideoView.this.eRK);
            }
        };
        this.eRP = new CustomMessageListener(2016503) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.bvp != null && PushDialogVideoView.this.bvp.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.bvp.getCurrentPosition();
                            int duration = PushDialogVideoView.this.bvp.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.eTJ != null) {
                                PushDialogVideoView.this.eTJ.gA(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.bnL - (duration % PushDialogVideoView.this.bnL));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eTJ = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void gA(int i2) {
                int duration;
                if (PushDialogVideoView.this.bvp != null && (duration = PushDialogVideoView.this.bvp.getDuration()) > 0 && PushDialogVideoView.this.geu != null) {
                    PushDialogVideoView.this.geu.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        this.gfa = new QuickVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.QuickVideoView.a
            public void bkd() {
                PushDialogVideoView.this.bcX.startLoading();
                PushDialogVideoView.this.eRj.setVisibility(0);
                PushDialogVideoView.this.cBs.setVisibility(8);
                PushDialogVideoView.this.gex.setVisibility(8);
                PushDialogVideoView.this.cBw.setVisibility(8);
                e.in().removeCallbacks(PushDialogVideoView.this.eRK);
                e.in().postDelayed(PushDialogVideoView.this.eRK, 60000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.ah(context) - l.f(context, d.e.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.bvp = (QuickVideoView) findViewById(d.g.videoView);
        this.bcX = new w((ViewGroup) findViewById(d.g.auto_video_loading_container));
        this.bcX.setLoadingAnimationListener(this.cyP);
        this.geu = (ProgressBar) findViewById(d.g.pgrBottomProgress);
        this.geu.setMax(this.mWidth);
        this.geu.setProgress(0);
        this.eRa = findViewById(d.g.black_mask);
        this.cBw = findViewById(d.g.layout_error);
        this.cBs = (ImageView) findViewById(d.g.img_play);
        this.gex = (TextView) findViewById(d.g.txt_replay);
        this.clJ = (TextView) findViewById(d.g.push_dialog_video_time);
        this.eRj = (TbImageView) findViewById(d.g.video_thumbnail);
        this.fNs = (PbVideoWifiTipLayout) findViewById(d.g.layout_wifi_tip);
        this.eRj.setDefaultErrorResource(0);
        this.eRj.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.eRF = new CallStateReceiver();
        this.eRF.register(context);
        this.cBw.setOnClickListener(this);
        this.gex.setOnClickListener(this);
        this.fNs.setOnPlayClickListener(this);
        this.fNs.setFreeClickListener(this);
        setOnClickListener(this);
        this.bvp.setOnPreparedListener(this.bjH);
        this.bvp.setOnCompletionListener(this.bjG);
        this.bvp.setOnErrorListener(this.eRJ);
        this.bvp.setOnSeekCompleteListener(this.bjK);
        this.bvp.setOnSurfaceDestroyedListener(this.bdh);
        this.bvp.setOnRecoveryCallback(this.gfa);
        onChangeSkinType();
    }

    public void onPause() {
        if (bjU()) {
            this.fNg = true;
            pausePlay();
        } else if (getCurrentState() == 3) {
            this.fNg = false;
        } else {
            this.fNg = false;
            pausePlay();
        }
    }

    public void onResume() {
        if (this.fNg) {
            aSg();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.eRP);
    }

    public void setTbRichTextVideoInfo(f fVar) {
        this.gkR = fVar;
        this.clJ.setText(ap.da(this.gkR.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.bdb = str;
        this.aWq = str2;
    }

    public void setQuickVideoViewBusiness(n nVar) {
        this.bvp.setBusiness(nVar);
    }

    public int getCurrentState() {
        return this.avR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiH() {
        if (this.bvp != null && this.cyE != null) {
            if (this.geV) {
                this.bvp.start();
                this.geV = false;
            }
            e.in().removeCallbacks(this.eRI);
            e.in().postDelayed(this.eRI, 20L);
            e.in().removeCallbacks(this.eRK);
            if (this.bvp.bku()) {
                this.avR = 1;
                this.bvp.setRecoveryState(1);
            }
            if (this.cyE != null) {
                this.mStartPosition = x.bkW().se(this.bdb);
                if (this.mStartPosition != 0) {
                    if (this.bvp != null) {
                        this.bvp.rH(this.mStartPosition);
                    } else {
                        this.cyE.seekTo(this.mStartPosition);
                    }
                    if (!this.geU) {
                        showProgress();
                        e.in().removeCallbacks(this.eRI);
                    }
                    this.geP = true;
                }
            }
        }
    }

    public void bgp() {
        if (!j.jE()) {
            l.F(getContext(), getContext().getString(d.j.neterror));
        } else if (this.bvp.isPlaying()) {
            pausePlay();
        } else if (this.eRo) {
            aSg();
        } else {
            bjV();
        }
    }

    public void setPauseState() {
        this.bcX.bkS();
        this.cBs.setVisibility(0);
        this.gex.setVisibility(8);
        this.avR = 2;
        this.bvp.setRecoveryState(2);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.geQ) {
            bT(str, str2);
        } else {
            bS(str, str2);
        }
        if (aVar != null) {
            aVar.lu(z);
        }
    }

    public void bS(String str, String str2) {
        bjW();
        this.geV = true;
        this.avR = 0;
        this.bvp.setRecoveryState(0);
        setVideoUrl(str, str2);
        this.bvp.setVideoPath(str, str2);
        this.bcX.startLoading();
        this.eRj.setVisibility(0);
        this.cBs.setVisibility(8);
        this.gex.setVisibility(8);
        this.cBw.setVisibility(8);
        e.in().removeCallbacks(this.eRK);
        e.in().postDelayed(this.eRK, 60000L);
    }

    public void bT(String str, String str2) {
        bjW();
        this.geV = true;
        this.avR = 0;
        this.bvp.setRecoveryState(0);
        this.bcX.startLoading();
        this.eRj.setVisibility(0);
        this.cBs.setVisibility(8);
        this.gex.setVisibility(8);
        this.cBw.setVisibility(8);
        e.in().removeCallbacks(this.eRK);
        e.in().postDelayed(this.eRK, 60000L);
    }

    public void aSg() {
        this.avR = 1;
        this.bvp.setRecoveryState(1);
        this.bvp.start();
        this.eRj.setVisibility(8);
        this.eRa.setVisibility(8);
        this.bcX.bkS();
        showProgress();
        this.cBs.setVisibility(8);
        this.gex.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.jE() && this.geT && !StringUtils.isNull(this.bdb) && !StringUtils.isNull(this.aWq)) {
            this.geT = false;
            this.geU = true;
            bS(this.bdb, this.aWq);
        }
    }

    public void setIsNeedRecoveryVideoPlayer(boolean z) {
        if (this.bvp != null) {
            this.bvp.setNeedRecovery(z);
        }
    }

    public void pausePlay() {
        if (this.bvp.isPlaying() && this.geO) {
            bjT();
        }
        this.bvp.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.bvp.isPlaying() && this.geO) {
            bjT();
        }
        this.avR = 5;
        this.bvp.setRecoveryState(5);
        e.in().removeCallbacks(this.eRI);
        e.in().removeCallbacks(this.eRK);
        this.bvp.stopPlayback();
        this.eRo = false;
        this.geV = false;
        this.mStartPosition = 0;
        aFd();
    }

    public void bjT() {
        x.bkW().aD(this.bdb, this.bvp.getCurrentPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        this.eRa.setVisibility(0);
        this.cBs.setVisibility(0);
        this.gex.setVisibility(8);
        this.bcX.bkS();
        this.geu.setVisibility(8);
        this.cBw.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.eRj.setVisibility(z ? 0 : 8);
    }

    public void aFd() {
        lr(true);
    }

    public boolean bjU() {
        if (this.bvp == null) {
            return false;
        }
        return this.bvp.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.bvp == null) {
            return 0;
        }
        return this.bvp.getCurrentPosition();
    }

    public void showProgress() {
        if (this.bvp != null) {
            this.geu.setVisibility(0);
            this.bnL = ((this.bvp.getDuration() / 200) / 50) * 50;
            if (this.bnL < 50) {
                this.bnL = 50;
            } else if (this.bnL > 500) {
                this.bnL = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.bnL - (this.bvp.getCurrentPosition() % this.bnL));
        }
    }

    private void bjV() {
        a(this.bdb, this.aWq, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        bjW();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.geQ = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.jG() && !this.fNz && !com.baidu.tieba.video.g.bAi().bAj()) {
            this.fNs.setVisibility(0);
            this.fNs.setData(this.gkR.getDuration(), this.gkR.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
    }

    private void bjW() {
        if (j.jG()) {
            com.baidu.tieba.video.g.bAi().cl(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.eRj.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cBw) {
            bjV();
        } else if (view == this) {
            TiebaStatic.log(new an("c13199").r("obj_locate", 2).af("tid", this.aWq));
            bgp();
        } else if (view == this.gex) {
            bS(this.bdb, this.aWq);
        } else if (view == this.fNs.getTvPlay()) {
            this.fNz = true;
            this.fNs.setVisibility(8);
            bS(this.bdb, this.aWq);
        } else if (view == this.fNs.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.in().removeCallbacks(this.eRI);
        e.in().removeCallbacks(this.eRK);
        e.in().removeCallbacks(this.geY);
        this.mHandler.removeMessages(1);
        this.eRF.unregister(getContext());
    }
}
