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
/* loaded from: classes7.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean adf;
    private Runnable adl;
    private TbImageView anK;
    private String anU;
    private CyberPlayerManager.OnPreparedListener eCb;
    private CyberPlayerManager.OnCompletionListener eCd;
    private CyberPlayerManager.OnSeekCompleteListener eCg;
    private m fVA;
    private TbCyberVideoView.a fVI;
    private TbCyberVideoView gBU;
    private int gjt;
    private View iBB;
    private TextView iaI;
    private VideoLoadingProgressView.a iyG;
    private CallStateReceiver lfG;
    private CyberPlayerManager.OnErrorListener lfJ;
    private Runnable lfK;
    private CustomMessageListener lfP;
    private View lfd;
    private ImageView lfm;
    private VideoControllerView.b lhI;
    private Handler mHandler;
    private int mHeight;
    private ProgressBar mIH;
    private TextView mIK;
    private boolean mJj;
    private boolean mJk;
    private boolean mJl;
    private boolean mJo;
    private boolean mJp;
    private boolean mJq;
    private Runnable mJw;
    private i mPT;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private boolean mlA;
    private PbVideoWifiTipLayout mlK;
    private boolean mlT;

    /* loaded from: classes7.dex */
    public interface a {
        void xo(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.gjt = 50;
        this.mSkinType = 3;
        this.adf = false;
        this.mStartPosition = 0;
        this.mJj = true;
        this.mJk = false;
        this.mJl = false;
        this.mlA = false;
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fVA.dAp();
            }
        };
        this.iyG = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csn();
            }
        };
        this.adl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.adf = true;
                    PushDialogVideoView.this.lfd.setVisibility(8);
                    PushDialogVideoView.this.iBB.setVisibility(8);
                    PushDialogVideoView.this.fVA.dAq();
                    PushDialogVideoView.this.anK.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mA().postDelayed(PushDialogVideoView.this.adl, 20L);
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.adf = false;
                PushDialogVideoView.this.mJq = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lfd.setVisibility(0);
                PushDialogVideoView.this.mIH.setVisibility(8);
                PushDialogVideoView.this.mIH.setProgress(PushDialogVideoView.this.mIH.getMax());
                if (PushDialogVideoView.this.gBU == null || PushDialogVideoView.this.gBU.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mIK.setVisibility(0);
                }
                n.dAv().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.anU);
                }
            }
        };
        this.lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.iBB.setVisibility(0);
                PushDialogVideoView.this.fVA.dAr();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mJo = true;
                }
                PushDialogVideoView.this.mJq = false;
                return true;
            }
        };
        this.lfK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iBB.setVisibility(0);
                PushDialogVideoView.this.fVA.dAr();
            }
        };
        this.eCg = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mJk) {
                    e.mA().postDelayed(PushDialogVideoView.this.mJw, 200L);
                }
            }
        };
        this.mJw = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU == null || !PushDialogVideoView.this.mJk) {
                    e.mA().postDelayed(PushDialogVideoView.this.adl, 200L);
                    PushDialogVideoView.this.mJk = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gBU.getCurrentPosition()) {
                    PushDialogVideoView.this.mJk = false;
                    e.mA().postDelayed(PushDialogVideoView.this.adl, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mJw, 200L);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.adf = false;
                PushDialogVideoView.this.mJq = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.adl);
                e.mA().removeCallbacks(PushDialogVideoView.this.lfK);
            }
        };
        this.lfP = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gBU.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gBU.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lhI != null) {
                                PushDialogVideoView.this.lhI.td(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gjt - (duration % PushDialogVideoView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lhI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void td(int i) {
                int duration;
                if (PushDialogVideoView.this.gBU != null && (duration = PushDialogVideoView.this.gBU.getDuration()) > 0 && PushDialogVideoView.this.mIH != null) {
                    PushDialogVideoView.this.mIH.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjt = 50;
        this.mSkinType = 3;
        this.adf = false;
        this.mStartPosition = 0;
        this.mJj = true;
        this.mJk = false;
        this.mJl = false;
        this.mlA = false;
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fVA.dAp();
            }
        };
        this.iyG = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csn();
            }
        };
        this.adl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.adf = true;
                    PushDialogVideoView.this.lfd.setVisibility(8);
                    PushDialogVideoView.this.iBB.setVisibility(8);
                    PushDialogVideoView.this.fVA.dAq();
                    PushDialogVideoView.this.anK.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mA().postDelayed(PushDialogVideoView.this.adl, 20L);
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.adf = false;
                PushDialogVideoView.this.mJq = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lfd.setVisibility(0);
                PushDialogVideoView.this.mIH.setVisibility(8);
                PushDialogVideoView.this.mIH.setProgress(PushDialogVideoView.this.mIH.getMax());
                if (PushDialogVideoView.this.gBU == null || PushDialogVideoView.this.gBU.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mIK.setVisibility(0);
                }
                n.dAv().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.anU);
                }
            }
        };
        this.lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.iBB.setVisibility(0);
                PushDialogVideoView.this.fVA.dAr();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mJo = true;
                }
                PushDialogVideoView.this.mJq = false;
                return true;
            }
        };
        this.lfK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iBB.setVisibility(0);
                PushDialogVideoView.this.fVA.dAr();
            }
        };
        this.eCg = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mJk) {
                    e.mA().postDelayed(PushDialogVideoView.this.mJw, 200L);
                }
            }
        };
        this.mJw = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU == null || !PushDialogVideoView.this.mJk) {
                    e.mA().postDelayed(PushDialogVideoView.this.adl, 200L);
                    PushDialogVideoView.this.mJk = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gBU.getCurrentPosition()) {
                    PushDialogVideoView.this.mJk = false;
                    e.mA().postDelayed(PushDialogVideoView.this.adl, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mJw, 200L);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.adf = false;
                PushDialogVideoView.this.mJq = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.adl);
                e.mA().removeCallbacks(PushDialogVideoView.this.lfK);
            }
        };
        this.lfP = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gBU.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gBU.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lhI != null) {
                                PushDialogVideoView.this.lhI.td(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gjt - (duration % PushDialogVideoView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lhI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void td(int i) {
                int duration;
                if (PushDialogVideoView.this.gBU != null && (duration = PushDialogVideoView.this.gBU.getDuration()) > 0 && PushDialogVideoView.this.mIH != null) {
                    PushDialogVideoView.this.mIH.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjt = 50;
        this.mSkinType = 3;
        this.adf = false;
        this.mStartPosition = 0;
        this.mJj = true;
        this.mJk = false;
        this.mJl = false;
        this.mlA = false;
        this.eCb = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fVA.dAp();
            }
        };
        this.iyG = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.csn();
            }
        };
        this.adl = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.adf = true;
                    PushDialogVideoView.this.lfd.setVisibility(8);
                    PushDialogVideoView.this.iBB.setVisibility(8);
                    PushDialogVideoView.this.fVA.dAq();
                    PushDialogVideoView.this.anK.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mA().postDelayed(PushDialogVideoView.this.adl, 20L);
            }
        };
        this.eCd = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.adf = false;
                PushDialogVideoView.this.mJq = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.lfd.setVisibility(0);
                PushDialogVideoView.this.mIH.setVisibility(8);
                PushDialogVideoView.this.mIH.setProgress(PushDialogVideoView.this.mIH.getMax());
                if (PushDialogVideoView.this.gBU == null || PushDialogVideoView.this.gBU.getDuration() > 150000) {
                    PushDialogVideoView.this.xj(false);
                } else {
                    PushDialogVideoView.this.mIK.setVisibility(0);
                }
                n.dAv().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.getDuration() <= 150000) {
                    PushDialogVideoView.this.fX(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.anU);
                }
            }
        };
        this.lfJ = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.iBB.setVisibility(0);
                PushDialogVideoView.this.fVA.dAr();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mJo = true;
                }
                PushDialogVideoView.this.mJq = false;
                return true;
            }
        };
        this.lfK = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iBB.setVisibility(0);
                PushDialogVideoView.this.fVA.dAr();
            }
        };
        this.eCg = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mJk) {
                    e.mA().postDelayed(PushDialogVideoView.this.mJw, 200L);
                }
            }
        };
        this.mJw = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU == null || !PushDialogVideoView.this.mJk) {
                    e.mA().postDelayed(PushDialogVideoView.this.adl, 200L);
                    PushDialogVideoView.this.mJk = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gBU.getCurrentPosition()) {
                    PushDialogVideoView.this.mJk = false;
                    e.mA().postDelayed(PushDialogVideoView.this.adl, 20L);
                } else {
                    e.mA().postDelayed(PushDialogVideoView.this.mJw, 200L);
                }
            }
        };
        this.fVI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.adf = false;
                PushDialogVideoView.this.mJq = false;
                e.mA().removeCallbacks(PushDialogVideoView.this.adl);
                e.mA().removeCallbacks(PushDialogVideoView.this.lfK);
            }
        };
        this.lfP = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
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
                        if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gBU.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gBU.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.lhI != null) {
                                PushDialogVideoView.this.lhI.td(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gjt - (duration % PushDialogVideoView.this.gjt));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lhI = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void td(int i2) {
                int duration;
                if (PushDialogVideoView.this.gBU != null && (duration = PushDialogVideoView.this.gBU.getDuration()) > 0 && PushDialogVideoView.this.mIH != null) {
                    PushDialogVideoView.this.mIH.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gBU = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gBU.setPlayMode("2");
        this.gBU.setStageType(null);
        this.fVA = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fVA.setLoadingAnimationListener(this.iyG);
        this.mIH = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mIH.setMax(this.mWidth);
        this.mIH.setProgress(0);
        this.lfd = findViewById(R.id.black_mask);
        this.iBB = findViewById(R.id.layout_error);
        this.lfm = (ImageView) findViewById(R.id.img_play);
        this.mIK = (TextView) findViewById(R.id.txt_replay);
        this.iaI = (TextView) findViewById(R.id.push_dialog_video_time);
        this.anK = (TbImageView) findViewById(R.id.video_thumbnail);
        this.mlK = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.anK.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.lfG = new CallStateReceiver();
        this.lfG.register(context);
        this.iBB.setOnClickListener(this);
        this.mIK.setOnClickListener(this);
        this.mlK.setOnPlayClickListener(this);
        this.mlK.setFreeClickListener(this);
        setOnClickListener(this);
        this.gBU.setOnPreparedListener(this.eCb);
        this.gBU.setOnCompletionListener(this.eCd);
        this.gBU.setOnErrorListener(this.lfJ);
        this.gBU.setOnSeekCompleteListener(this.eCg);
        this.gBU.setOnSurfaceDestroyedListener(this.fVI);
        onChangeSkinType();
    }

    public void onPause() {
        if (rl()) {
            this.mlA = true;
            pausePlay();
            return;
        }
        this.mlA = false;
        pausePlay();
    }

    public void onResume() {
        if (this.mlA) {
            resumePlay();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.lfP);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mPT = iVar;
        this.iaI.setText(au.stringForVideoTime(this.mPT.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.anU = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gBU.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csn() {
        if (this.gBU != null) {
            if (this.mJq) {
                this.gBU.start();
                this.mJq = false;
            }
            e.mA().removeCallbacks(this.adl);
            e.mA().postDelayed(this.adl, 20L);
            e.mA().removeCallbacks(this.lfK);
            this.mStartPosition = n.dAv().QK(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gBU.seekTo(this.mStartPosition);
                if (!this.mJp) {
                    showProgress();
                    e.mA().removeCallbacks(this.adl);
                }
                this.mJk = true;
            }
        }
    }

    public void dtR() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gBU.isPlaying()) {
            pausePlay();
        } else if (this.adf) {
            resumePlay();
        } else {
            dzV();
        }
    }

    public void setPauseState() {
        this.fVA.dAr();
        this.lfm.setVisibility(0);
        this.mIK.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mJl) {
            fY(str, str2);
        } else {
            fX(str, str2);
        }
        if (aVar != null) {
            aVar.xo(z);
        }
    }

    public void fX(String str, String str2) {
        dzW();
        this.mJq = true;
        setVideoUrl(str, str2);
        this.gBU.setVideoPath(str, str2);
        this.fVA.startLoading();
        this.anK.setVisibility(0);
        this.lfm.setVisibility(8);
        this.mIK.setVisibility(8);
        this.iBB.setVisibility(8);
        e.mA().removeCallbacks(this.lfK);
        e.mA().postDelayed(this.lfK, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void fY(String str, String str2) {
        dzW();
        this.mJq = true;
        this.fVA.startLoading();
        this.anK.setVisibility(0);
        this.lfm.setVisibility(8);
        this.mIK.setVisibility(8);
        this.iBB.setVisibility(8);
        e.mA().removeCallbacks(this.lfK);
        e.mA().postDelayed(this.lfK, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void resumePlay() {
        this.gBU.start();
        this.anK.setVisibility(8);
        this.lfd.setVisibility(8);
        this.fVA.dAr();
        showProgress();
        this.lfm.setVisibility(8);
        this.mIK.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mJo && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.anU)) {
            this.mJo = false;
            this.mJp = true;
            fX(this.mVideoUrl, this.anU);
        }
    }

    public void pausePlay() {
        if (this.gBU.isPlaying() && this.mJj) {
            dzU();
        }
        this.gBU.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gBU.isPlaying() && this.mJj) {
            dzU();
        }
        e.mA().removeCallbacks(this.adl);
        e.mA().removeCallbacks(this.lfK);
        this.gBU.stopPlayback();
        this.adf = false;
        this.mJq = false;
        this.mStartPosition = 0;
        cSR();
    }

    public void dzU() {
        n.dAv().bL(this.mVideoUrl, this.gBU.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(boolean z) {
        this.lfd.setVisibility(0);
        this.lfm.setVisibility(0);
        this.mIK.setVisibility(8);
        this.fVA.dAr();
        this.mIH.setVisibility(8);
        this.iBB.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.anK.setVisibility(z ? 0 : 8);
    }

    public void cSR() {
        xj(true);
    }

    public boolean rl() {
        if (this.gBU == null) {
            return false;
        }
        return this.gBU.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gBU == null) {
            return 0;
        }
        return this.gBU.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gBU != null) {
            this.mIH.setVisibility(0);
            this.gjt = ((this.gBU.getDuration() / 200) / 50) * 50;
            if (this.gjt < 50) {
                this.gjt = 50;
            } else if (this.gjt > 500) {
                this.gjt = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjt - (this.gBU.getCurrentPosition() % this.gjt));
        }
    }

    private void dzV() {
        a(this.mVideoUrl, this.anU, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dzW();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mJl = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.mlT && !f.dSn().dSo()) {
            this.mlK.setVisibility(0);
            this.mlK.setData(this.mPT.getDuration(), this.mPT.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dzW() {
        if (j.isMobileNet()) {
            f.dSn().gY(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.anK.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iBB) {
            dzV();
        } else if (view == this) {
            TiebaStatic.log(new ar("c13199").aq("obj_locate", 2).dR("tid", this.anU));
            dtR();
        } else if (view == this.mIK) {
            fX(this.mVideoUrl, this.anU);
        } else if (view == this.mlK.getTvPlay()) {
            this.mlT = true;
            this.mlK.setVisibility(8);
            fX(this.mVideoUrl, this.anU);
        } else if (view == this.mlK.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mA().removeCallbacks(this.adl);
        e.mA().removeCallbacks(this.lfK);
        e.mA().removeCallbacks(this.mJw);
        this.mHandler.removeMessages(1);
        this.lfG.unregister(getContext());
    }
}
