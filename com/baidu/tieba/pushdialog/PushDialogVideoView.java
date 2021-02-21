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
    private TbCyberVideoView gAl;
    private int ghP;
    private TextView hYZ;
    private VideoLoadingProgressView.a iwX;
    private View izS;
    private CallStateReceiver ldD;
    private CyberPlayerManager.OnErrorListener ldG;
    private Runnable ldH;
    private CustomMessageListener ldM;
    private View lda;
    private ImageView ldj;
    private VideoControllerView.b lfG;
    private ProgressBar mGB;
    private TextView mGE;
    private Handler mHandler;
    private boolean mHc;
    private boolean mHd;
    private boolean mHe;
    private int mHeight;
    private boolean mHh;
    private boolean mHi;
    private boolean mHj;
    private Runnable mHp;
    private i mNP;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private PbVideoWifiTipLayout mjI;
    private boolean mjR;
    private boolean mjy;

    /* loaded from: classes8.dex */
    public interface a {
        void xo(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.ghP = 50;
        this.mSkinType = 3;
        this.abI = false;
        this.mStartPosition = 0;
        this.mHc = true;
        this.mHd = false;
        this.mHe = false;
        this.mjy = false;
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fUa.dAh();
            }
        };
        this.iwX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csh();
            }
        };
        this.abO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gAl.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abI = true;
                    PushDialogVideoView.this.lda.setVisibility(8);
                    PushDialogVideoView.this.izS.setVisibility(8);
                    PushDialogVideoView.this.fUa.dAi();
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
                PushDialogVideoView.this.mHj = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lda.setVisibility(0);
                PushDialogVideoView.this.mGB.setVisibility(8);
                PushDialogVideoView.this.mGB.setProgress(PushDialogVideoView.this.mGB.getMax());
                if (PushDialogVideoView.this.gAl == null || PushDialogVideoView.this.gAl.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mGE.setVisibility(0);
                }
                n.dAn().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gAl != null && PushDialogVideoView.this.gAl.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amC);
                }
            }
        };
        this.ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.izS.setVisibility(0);
                PushDialogVideoView.this.fUa.dAj();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mHh = true;
                }
                PushDialogVideoView.this.mHj = false;
                return true;
            }
        };
        this.ldH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.izS.setVisibility(0);
                PushDialogVideoView.this.fUa.dAj();
            }
        };
        this.eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mHd) {
                    e.mA().postDelayed(PushDialogVideoView.this.mHp, 200L);
                }
            }
        };
        this.mHp = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gAl == null || !PushDialogVideoView.this.mHd) {
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 200L);
                    PushDialogVideoView.this.mHd = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gAl.getCurrentPosition()) {
                    PushDialogVideoView.this.mHd = false;
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mHp, 200L);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mHj = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.abO);
                e.mA().removeCallbacks(PushDialogVideoView.this.ldH);
            }
        };
        this.ldM = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gAl != null && PushDialogVideoView.this.gAl.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gAl.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gAl.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lfG != null) {
                                PushDialogVideoView.this.lfG.tb(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.ghP - (duration % PushDialogVideoView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lfG = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tb(int i) {
                int duration;
                if (PushDialogVideoView.this.gAl != null && (duration = PushDialogVideoView.this.gAl.getDuration()) > 0 && PushDialogVideoView.this.mGB != null) {
                    PushDialogVideoView.this.mGB.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghP = 50;
        this.mSkinType = 3;
        this.abI = false;
        this.mStartPosition = 0;
        this.mHc = true;
        this.mHd = false;
        this.mHe = false;
        this.mjy = false;
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fUa.dAh();
            }
        };
        this.iwX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csh();
            }
        };
        this.abO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gAl.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abI = true;
                    PushDialogVideoView.this.lda.setVisibility(8);
                    PushDialogVideoView.this.izS.setVisibility(8);
                    PushDialogVideoView.this.fUa.dAi();
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
                PushDialogVideoView.this.mHj = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lda.setVisibility(0);
                PushDialogVideoView.this.mGB.setVisibility(8);
                PushDialogVideoView.this.mGB.setProgress(PushDialogVideoView.this.mGB.getMax());
                if (PushDialogVideoView.this.gAl == null || PushDialogVideoView.this.gAl.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mGE.setVisibility(0);
                }
                n.dAn().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gAl != null && PushDialogVideoView.this.gAl.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amC);
                }
            }
        };
        this.ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.izS.setVisibility(0);
                PushDialogVideoView.this.fUa.dAj();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mHh = true;
                }
                PushDialogVideoView.this.mHj = false;
                return true;
            }
        };
        this.ldH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.izS.setVisibility(0);
                PushDialogVideoView.this.fUa.dAj();
            }
        };
        this.eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mHd) {
                    e.mA().postDelayed(PushDialogVideoView.this.mHp, 200L);
                }
            }
        };
        this.mHp = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gAl == null || !PushDialogVideoView.this.mHd) {
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 200L);
                    PushDialogVideoView.this.mHd = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gAl.getCurrentPosition()) {
                    PushDialogVideoView.this.mHd = false;
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mHp, 200L);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mHj = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.abO);
                e.mA().removeCallbacks(PushDialogVideoView.this.ldH);
            }
        };
        this.ldM = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gAl != null && PushDialogVideoView.this.gAl.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gAl.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gAl.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lfG != null) {
                                PushDialogVideoView.this.lfG.tb(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.ghP - (duration % PushDialogVideoView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lfG = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tb(int i) {
                int duration;
                if (PushDialogVideoView.this.gAl != null && (duration = PushDialogVideoView.this.gAl.getDuration()) > 0 && PushDialogVideoView.this.mGB != null) {
                    PushDialogVideoView.this.mGB.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghP = 50;
        this.mSkinType = 3;
        this.abI = false;
        this.mStartPosition = 0;
        this.mHc = true;
        this.mHd = false;
        this.mHe = false;
        this.mjy = false;
        this.eAA = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fUa.dAh();
            }
        };
        this.iwX = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csh();
            }
        };
        this.abO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gAl.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abI = true;
                    PushDialogVideoView.this.lda.setVisibility(8);
                    PushDialogVideoView.this.izS.setVisibility(8);
                    PushDialogVideoView.this.fUa.dAi();
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
                PushDialogVideoView.this.mHj = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lda.setVisibility(0);
                PushDialogVideoView.this.mGB.setVisibility(8);
                PushDialogVideoView.this.mGB.setProgress(PushDialogVideoView.this.mGB.getMax());
                if (PushDialogVideoView.this.gAl == null || PushDialogVideoView.this.gAl.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mGE.setVisibility(0);
                }
                n.dAn().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gAl != null && PushDialogVideoView.this.gAl.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.amC);
                }
            }
        };
        this.ldG = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.izS.setVisibility(0);
                PushDialogVideoView.this.fUa.dAj();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mHh = true;
                }
                PushDialogVideoView.this.mHj = false;
                return true;
            }
        };
        this.ldH = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.izS.setVisibility(0);
                PushDialogVideoView.this.fUa.dAj();
            }
        };
        this.eAF = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mHd) {
                    e.mA().postDelayed(PushDialogVideoView.this.mHp, 200L);
                }
            }
        };
        this.mHp = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gAl == null || !PushDialogVideoView.this.mHd) {
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 200L);
                    PushDialogVideoView.this.mHd = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gAl.getCurrentPosition()) {
                    PushDialogVideoView.this.mHd = false;
                    e.mA().postDelayed(PushDialogVideoView.this.abO, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mHp, 200L);
                }
            }
        };
        this.fUi = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abI = false;
                PushDialogVideoView.this.mHj = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.abO);
                e.mA().removeCallbacks(PushDialogVideoView.this.ldH);
            }
        };
        this.ldM = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gAl != null && PushDialogVideoView.this.gAl.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gAl.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gAl.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lfG != null) {
                                PushDialogVideoView.this.lfG.tb(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.ghP - (duration % PushDialogVideoView.this.ghP));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lfG = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tb(int i2) {
                int duration;
                if (PushDialogVideoView.this.gAl != null && (duration = PushDialogVideoView.this.gAl.getDuration()) > 0 && PushDialogVideoView.this.mGB != null) {
                    PushDialogVideoView.this.mGB.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gAl = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gAl.setPlayMode("2");
        this.gAl.setStageType(null);
        this.fUa = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fUa.setLoadingAnimationListener(this.iwX);
        this.mGB = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mGB.setMax(this.mWidth);
        this.mGB.setProgress(0);
        this.lda = findViewById(R.id.black_mask);
        this.izS = findViewById(R.id.layout_error);
        this.ldj = (ImageView) findViewById(R.id.img_play);
        this.mGE = (TextView) findViewById(R.id.txt_replay);
        this.hYZ = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ams = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mjI = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ams.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.ldD = new CallStateReceiver();
        this.ldD.register(context);
        this.izS.setOnClickListener(this);
        this.mGE.setOnClickListener(this);
        this.mjI.setOnPlayClickListener(this);
        this.mjI.setFreeClickListener(this);
        setOnClickListener(this);
        this.gAl.setOnPreparedListener(this.eAA);
        this.gAl.setOnCompletionListener(this.eAC);
        this.gAl.setOnErrorListener(this.ldG);
        this.gAl.setOnSeekCompleteListener(this.eAF);
        this.gAl.setOnSurfaceDestroyedListener(this.fUi);
        onChangeSkinType();
    }

    public void onPause() {
        if (rl()) {
            this.mjy = true;
            pausePlay();
            return;
        }
        this.mjy = false;
        pausePlay();
    }

    public void onResume() {
        if (this.mjy) {
            resumePlay();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.ldM);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mNP = iVar;
        this.hYZ.setText(au.stringForVideoTime(this.mNP.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.amC = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gAl.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csh() {
        if (this.gAl != null) {
            if (this.mHj) {
                this.gAl.start();
                this.mHj = false;
            }
            e.mA().removeCallbacks(this.abO);
            e.mA().postDelayed(this.abO, 20L);
            e.mA().removeCallbacks(this.ldH);
            this.mStartPosition = n.dAn().QE(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gAl.seekTo(this.mStartPosition);
                if (!this.mHi) {
                    showProgress();
                    e.mA().removeCallbacks(this.abO);
                }
                this.mHd = true;
            }
        }
    }

    public void dtI() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gAl.isPlaying()) {
            pausePlay();
        } else if (this.abI) {
            resumePlay();
        } else {
            dzM();
        }
    }

    public void setPauseState() {
        this.fUa.dAj();
        this.ldj.setVisibility(0);
        this.mGE.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mHe) {
            fY(str, str2);
        } else {
            fX(str, str2);
        }
        if (aVar != null) {
            aVar.xo(z);
        }
    }

    public void fX(String str, String str2) {
        dzN();
        this.mHj = true;
        setVideoUrl(str, str2);
        this.gAl.setVideoPath(str, str2);
        this.fUa.startLoading();
        this.ams.setVisibility(0);
        this.ldj.setVisibility(8);
        this.mGE.setVisibility(8);
        this.izS.setVisibility(8);
        e.mA().removeCallbacks(this.ldH);
        e.mA().postDelayed(this.ldH, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void fY(String str, String str2) {
        dzN();
        this.mHj = true;
        this.fUa.startLoading();
        this.ams.setVisibility(0);
        this.ldj.setVisibility(8);
        this.mGE.setVisibility(8);
        this.izS.setVisibility(8);
        e.mA().removeCallbacks(this.ldH);
        e.mA().postDelayed(this.ldH, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void resumePlay() {
        this.gAl.start();
        this.ams.setVisibility(8);
        this.lda.setVisibility(8);
        this.fUa.dAj();
        showProgress();
        this.ldj.setVisibility(8);
        this.mGE.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mHh && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.amC)) {
            this.mHh = false;
            this.mHi = true;
            fX(this.mVideoUrl, this.amC);
        }
    }

    public void pausePlay() {
        if (this.gAl.isPlaying() && this.mHc) {
            dzL();
        }
        this.gAl.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gAl.isPlaying() && this.mHc) {
            dzL();
        }
        e.mA().removeCallbacks(this.abO);
        e.mA().removeCallbacks(this.ldH);
        this.gAl.stopPlayback();
        this.abI = false;
        this.mHj = false;
        this.mStartPosition = 0;
        cSK();
    }

    public void dzL() {
        n.dAn().bL(this.mVideoUrl, this.gAl.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        this.lda.setVisibility(0);
        this.ldj.setVisibility(0);
        this.mGE.setVisibility(8);
        this.fUa.dAj();
        this.mGB.setVisibility(8);
        this.izS.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ams.setVisibility(z ? 0 : 8);
    }

    public void cSK() {
        xj(true);
    }

    public boolean rl() {
        if (this.gAl == null) {
            return false;
        }
        return this.gAl.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gAl == null) {
            return 0;
        }
        return this.gAl.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gAl != null) {
            this.mGB.setVisibility(0);
            this.ghP = ((this.gAl.getDuration() / 200) / 50) * 50;
            if (this.ghP < 50) {
                this.ghP = 50;
            } else if (this.ghP > 500) {
                this.ghP = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.ghP - (this.gAl.getCurrentPosition() % this.ghP));
        }
    }

    private void dzM() {
        a(this.mVideoUrl, this.amC, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dzN();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mHe = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.mjR && !f.dSf().dSg()) {
            this.mjI.setVisibility(0);
            this.mjI.setData(this.mNP.getDuration(), this.mNP.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dzN() {
        if (j.isMobileNet()) {
            f.dSf().gZ(getContext());
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
        if (view == this.izS) {
            dzM();
        } else if (view == this) {
            TiebaStatic.log(new ar("c13199").ap("obj_locate", 2).dR("tid", this.amC));
            dtI();
        } else if (view == this.mGE) {
            fX(this.mVideoUrl, this.amC);
        } else if (view == this.mjI.getTvPlay()) {
            this.mjR = true;
            this.mjI.setVisibility(8);
            fX(this.mVideoUrl, this.amC);
        } else if (view == this.mjI.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mA().removeCallbacks(this.ldH);
        e.mA().removeCallbacks(this.mHp);
        this.mHandler.removeMessages(1);
        this.ldD.unregister(getContext());
    }
}
