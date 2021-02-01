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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.m;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.o;
import com.baidu.tieba.video.f;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes8.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean abI;
    private Runnable abO;
    private String amC;
    private TbImageView ams;
    private CyberPlayerManager.OnPreparedListener eAA;
    private CyberPlayerManager.OnCompletionListener eAC;
    private CyberPlayerManager.OnSeekCompleteListener eAF;
    private m fUa;
    private TbCyberVideoView.a fUi;
    private int ghB;
    private TbCyberVideoView gzX;
    private TextView hYL;
    private VideoLoadingProgressView.a iwJ;
    private View izE;
    private View lcM;
    private ImageView lcV;
    private CallStateReceiver ldp;
    private CyberPlayerManager.OnErrorListener lds;
    private Runnable ldt;
    private CustomMessageListener ldy;
    private VideoControllerView.b lfs;
    private boolean mGN;
    private boolean mGO;
    private boolean mGP;
    private boolean mGS;
    private boolean mGT;
    private boolean mGU;
    private ProgressBar mGm;
    private TextView mGp;
    private Runnable mHa;
    private Handler mHandler;
    private int mHeight;
    private i mNA;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private boolean mjC;
    private boolean mjj;
    private PbVideoWifiTipLayout mjt;

    /* loaded from: classes8.dex */
    public interface a {
        void xo(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.ghB = 50;
        this.mSkinType = 3;
        this.abI = false;
        this.mStartPosition = 0;
        this.mGN = true;
        this.mGO = false;
        this.mGP = false;
        this.mjj = false;
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fUa.dAa();
            }
        };
        this.iwJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csa();
            }
        };
        this.abO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gzX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abI = true;
                    PushDialogVideoView.this.lcM.setVisibility(8);
                    PushDialogVideoView.this.izE.setVisibility(8);
                    PushDialogVideoView.this.fUa.dAb();
                    PushDialogVideoView.this.ams.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mGU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lcM.setVisibility(0);
                PushDialogVideoView.this.mGm.setVisibility(8);
                PushDialogVideoView.this.mGm.setProgress(PushDialogVideoView.this.mGm.getMax());
                if (PushDialogVideoView.this.gzX == null || PushDialogVideoView.this.gzX.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mGp.setVisibility(0);
                }
                n.dAg().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gzX != null && PushDialogVideoView.this.gzX.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amC);
                }
            }
        };
        this.lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.izE.setVisibility(0);
                PushDialogVideoView.this.fUa.dAc();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mGS = true;
                }
                PushDialogVideoView.this.mGU = false;
                return true;
            }
        };
        this.ldt = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.izE.setVisibility(0);
                PushDialogVideoView.this.fUa.dAc();
            }
        };
        this.eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mGO) {
                    e.mA().postDelayed(PushDialogVideoView.this.mHa, 200L);
                }
            }
        };
        this.mHa = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gzX == null || !PushDialogVideoView.this.mGO) {
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 200L);
                    PushDialogVideoView.this.mGO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gzX.getCurrentPosition()) {
                    PushDialogVideoView.this.mGO = false;
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mHa, 200L);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mGU = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.abO);
                e.mA().removeCallbacks(PushDialogVideoView.this.ldt);
            }
        };
        this.ldy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gzX != null && PushDialogVideoView.this.gzX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gzX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gzX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lfs != null) {
                                PushDialogVideoView.this.lfs.tb(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.ghB - (duration % PushDialogVideoView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lfs = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tb(int i) {
                int duration;
                if (PushDialogVideoView.this.gzX != null && (duration = PushDialogVideoView.this.gzX.getDuration()) > 0 && PushDialogVideoView.this.mGm != null) {
                    PushDialogVideoView.this.mGm.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghB = 50;
        this.mSkinType = 3;
        this.abI = false;
        this.mStartPosition = 0;
        this.mGN = true;
        this.mGO = false;
        this.mGP = false;
        this.mjj = false;
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fUa.dAa();
            }
        };
        this.iwJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csa();
            }
        };
        this.abO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gzX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abI = true;
                    PushDialogVideoView.this.lcM.setVisibility(8);
                    PushDialogVideoView.this.izE.setVisibility(8);
                    PushDialogVideoView.this.fUa.dAb();
                    PushDialogVideoView.this.ams.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mGU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lcM.setVisibility(0);
                PushDialogVideoView.this.mGm.setVisibility(8);
                PushDialogVideoView.this.mGm.setProgress(PushDialogVideoView.this.mGm.getMax());
                if (PushDialogVideoView.this.gzX == null || PushDialogVideoView.this.gzX.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mGp.setVisibility(0);
                }
                n.dAg().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gzX != null && PushDialogVideoView.this.gzX.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amC);
                }
            }
        };
        this.lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.izE.setVisibility(0);
                PushDialogVideoView.this.fUa.dAc();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mGS = true;
                }
                PushDialogVideoView.this.mGU = false;
                return true;
            }
        };
        this.ldt = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.izE.setVisibility(0);
                PushDialogVideoView.this.fUa.dAc();
            }
        };
        this.eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mGO) {
                    e.mA().postDelayed(PushDialogVideoView.this.mHa, 200L);
                }
            }
        };
        this.mHa = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gzX == null || !PushDialogVideoView.this.mGO) {
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 200L);
                    PushDialogVideoView.this.mGO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gzX.getCurrentPosition()) {
                    PushDialogVideoView.this.mGO = false;
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mHa, 200L);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mGU = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.abO);
                e.mA().removeCallbacks(PushDialogVideoView.this.ldt);
            }
        };
        this.ldy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gzX != null && PushDialogVideoView.this.gzX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gzX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gzX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lfs != null) {
                                PushDialogVideoView.this.lfs.tb(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.ghB - (duration % PushDialogVideoView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lfs = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tb(int i) {
                int duration;
                if (PushDialogVideoView.this.gzX != null && (duration = PushDialogVideoView.this.gzX.getDuration()) > 0 && PushDialogVideoView.this.mGm != null) {
                    PushDialogVideoView.this.mGm.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghB = 50;
        this.mSkinType = 3;
        this.abI = false;
        this.mStartPosition = 0;
        this.mGN = true;
        this.mGO = false;
        this.mGP = false;
        this.mjj = false;
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fUa.dAa();
            }
        };
        this.iwJ = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csa();
            }
        };
        this.abO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gzX.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abI = true;
                    PushDialogVideoView.this.lcM.setVisibility(8);
                    PushDialogVideoView.this.izE.setVisibility(8);
                    PushDialogVideoView.this.fUa.dAb();
                    PushDialogVideoView.this.ams.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
            }
        };
        this.eAC = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mGU = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lcM.setVisibility(0);
                PushDialogVideoView.this.mGm.setVisibility(8);
                PushDialogVideoView.this.mGm.setProgress(PushDialogVideoView.this.mGm.getMax());
                if (PushDialogVideoView.this.gzX == null || PushDialogVideoView.this.gzX.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mGp.setVisibility(0);
                }
                n.dAg().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gzX != null && PushDialogVideoView.this.gzX.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amC);
                }
            }
        };
        this.lds = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.izE.setVisibility(0);
                PushDialogVideoView.this.fUa.dAc();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mGS = true;
                }
                PushDialogVideoView.this.mGU = false;
                return true;
            }
        };
        this.ldt = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.izE.setVisibility(0);
                PushDialogVideoView.this.fUa.dAc();
            }
        };
        this.eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mGO) {
                    e.mA().postDelayed(PushDialogVideoView.this.mHa, 200L);
                }
            }
        };
        this.mHa = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gzX == null || !PushDialogVideoView.this.mGO) {
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 200L);
                    PushDialogVideoView.this.mGO = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gzX.getCurrentPosition()) {
                    PushDialogVideoView.this.mGO = false;
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mHa, 200L);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mGU = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.abO);
                e.mA().removeCallbacks(PushDialogVideoView.this.ldt);
            }
        };
        this.ldy = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gzX != null && PushDialogVideoView.this.gzX.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gzX.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gzX.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lfs != null) {
                                PushDialogVideoView.this.lfs.tb(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.ghB - (duration % PushDialogVideoView.this.ghB));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lfs = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tb(int i2) {
                int duration;
                if (PushDialogVideoView.this.gzX != null && (duration = PushDialogVideoView.this.gzX.getDuration()) > 0 && PushDialogVideoView.this.mGm != null) {
                    PushDialogVideoView.this.mGm.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gzX = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gzX.setPlayMode("2");
        this.gzX.setStageType(null);
        this.fUa = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwJ);
        this.mGm = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mGm.setMax(this.mWidth);
        this.mGm.setProgress(0);
        this.lcM = findViewById(R.id.black_mask);
        this.izE = findViewById(R.id.layout_error);
        this.lcV = (ImageView) findViewById(R.id.img_play);
        this.mGp = (TextView) findViewById(R.id.txt_replay);
        this.hYL = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ams = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mjt = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ams.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ldp = new CallStateReceiver();
        this.ldp.register(context);
        this.izE.setOnClickListener(this);
        this.mGp.setOnClickListener(this);
        this.mjt.setOnPlayClickListener(this);
        this.mjt.setFreeClickListener(this);
        setOnClickListener(this);
        this.gzX.setOnPreparedListener(this.eAA);
        this.gzX.setOnCompletionListener(this.eAC);
        this.gzX.setOnErrorListener(this.lds);
        this.gzX.setOnSeekCompleteListener(this.eAF);
        this.gzX.setOnSurfaceDestroyedListener(this.fUi);
        onChangeSkinType();
    }

    public void onPause() {
        if (rl()) {
            this.mjj = true;
            pausePlay();
            return;
        }
        this.mjj = false;
        pausePlay();
    }

    public void onResume() {
        if (this.mjj) {
            resumePlay();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.ldy);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mNA = iVar;
        this.hYL.setText(au.stringForVideoTime(this.mNA.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amC = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gzX.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csa() {
        if (this.gzX != null) {
            if (this.mGU) {
                this.gzX.start();
                this.mGU = false;
            }
            e.mA().removeCallbacks(this.abO);
            e.mA().postDelayed(this.abO, 20L);
            e.mA().removeCallbacks(this.ldt);
            this.mStartPosition = n.dAg().QD(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gzX.seekTo(this.mStartPosition);
                if (!this.mGT) {
                    showProgress();
                    e.mA().removeCallbacks(this.abO);
                }
                this.mGO = true;
            }
        }
    }

    public void dtB() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gzX.isPlaying()) {
            pausePlay();
        } else if (this.abI) {
            resumePlay();
        } else {
            dzF();
        }
    }

    public void setPauseState() {
        this.fUa.dAc();
        this.lcV.setVisibility(0);
        this.mGp.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mGP) {
            fY(str, str2);
        } else {
            fX(str, str2);
        }
        if (aVar != null) {
            aVar.xo(z);
        }
    }

    public void fX(String str, String str2) {
        dzG();
        this.mGU = true;
        setVideoUrl(str, str2);
        this.gzX.setVideoPath(str, str2);
        this.fUa.startLoading();
        this.ams.setVisibility(0);
        this.lcV.setVisibility(8);
        this.mGp.setVisibility(8);
        this.izE.setVisibility(8);
        e.mA().removeCallbacks(this.ldt);
        e.mA().postDelayed(this.ldt, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void fY(String str, String str2) {
        dzG();
        this.mGU = true;
        this.fUa.startLoading();
        this.ams.setVisibility(0);
        this.lcV.setVisibility(8);
        this.mGp.setVisibility(8);
        this.izE.setVisibility(8);
        e.mA().removeCallbacks(this.ldt);
        e.mA().postDelayed(this.ldt, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void resumePlay() {
        this.gzX.start();
        this.ams.setVisibility(8);
        this.lcM.setVisibility(8);
        this.fUa.dAc();
        showProgress();
        this.lcV.setVisibility(8);
        this.mGp.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mGS && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amC)) {
            this.mGS = false;
            this.mGT = true;
            fX(this.mVideoUrl, this.amC);
        }
    }

    public void pausePlay() {
        if (this.gzX.isPlaying() && this.mGN) {
            dzE();
        }
        this.gzX.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gzX.isPlaying() && this.mGN) {
            dzE();
        }
        e.mA().removeCallbacks(this.abO);
        e.mA().removeCallbacks(this.ldt);
        this.gzX.stopPlayback();
        this.abI = false;
        this.mGU = false;
        this.mStartPosition = 0;
        cSD();
    }

    public void dzE() {
        n.dAg().bL(this.mVideoUrl, this.gzX.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        this.lcM.setVisibility(0);
        this.lcV.setVisibility(0);
        this.mGp.setVisibility(8);
        this.fUa.dAc();
        this.mGm.setVisibility(8);
        this.izE.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ams.setVisibility(z ? 0 : 8);
    }

    public void cSD() {
        xj(true);
    }

    public boolean rl() {
        if (this.gzX == null) {
            return false;
        }
        return this.gzX.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gzX == null) {
            return 0;
        }
        return this.gzX.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gzX != null) {
            this.mGm.setVisibility(0);
            this.ghB = ((this.gzX.getDuration() / 200) / 50) * 50;
            if (this.ghB < 50) {
                this.ghB = 50;
            } else if (this.ghB > 500) {
                this.ghB = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ghB - (this.gzX.getCurrentPosition() % this.ghB));
        }
    }

    private void dzF() {
        a(this.mVideoUrl, this.amC, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dzG();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mGP = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.mjC && !f.dRX().dRY()) {
            this.mjt.setVisibility(0);
            this.mjt.setData(this.mNA.getDuration(), this.mNA.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dzG() {
        if (j.isMobileNet()) {
            f.dRX().gZ(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.ams.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.izE) {
            dzF();
        } else if (view == this) {
            TiebaStatic.log(new ar("c13199").ap("obj_locate", 2).dR("tid", this.amC));
            dtB();
        } else if (view == this.mGp) {
            fX(this.mVideoUrl, this.amC);
        } else if (view == this.mjt.getTvPlay()) {
            this.mjC = true;
            this.mjt.setVisibility(8);
            fX(this.mVideoUrl, this.amC);
        } else if (view == this.mjt.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mA().removeCallbacks(this.abO);
        e.mA().removeCallbacks(this.ldt);
        e.mA().removeCallbacks(this.mHa);
        this.mHandler.removeMessages(1);
        this.ldp.unregister(getContext());
    }
}
