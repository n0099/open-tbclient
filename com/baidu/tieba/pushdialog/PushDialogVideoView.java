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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private boolean abP;
    private Runnable abV;
    private String anD;
    private TbImageView ant;
    private CyberPlayerManager.OnPreparedListener eDf;
    private CyberPlayerManager.OnCompletionListener eDh;
    private CyberPlayerManager.OnSeekCompleteListener eDk;
    private TbCyberVideoView.a fWA;
    private m fWs;
    private TbCyberVideoView gBU;
    private int gjU;
    private TextView hYX;
    private VideoLoadingProgressView.a ivM;
    private View iyB;
    private CallStateReceiver kZR;
    private CyberPlayerManager.OnErrorListener kZU;
    private Runnable kZV;
    private View kZn;
    private ImageView kZw;
    private CustomMessageListener laa;
    private VideoControllerView.b lbU;
    private ProgressBar mBM;
    private TextView mBP;
    private Runnable mCA;
    private boolean mCm;
    private boolean mCn;
    private boolean mCo;
    private boolean mCr;
    private boolean mCs;
    private boolean mCt;
    private Handler mHandler;
    private int mHeight;
    private i mJf;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private boolean meK;
    private PbVideoWifiTipLayout meU;
    private boolean mfd;

    /* loaded from: classes8.dex */
    public interface a {
        void xa(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.gjU = 50;
        this.mSkinType = 3;
        this.abP = false;
        this.mStartPosition = 0;
        this.mCm = true;
        this.mCn = false;
        this.mCo = false;
        this.meK = false;
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fWs.dBK();
            }
        };
        this.ivM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cuI();
            }
        };
        this.abV = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abP = true;
                    PushDialogVideoView.this.kZn.setVisibility(8);
                    PushDialogVideoView.this.iyB.setVisibility(8);
                    PushDialogVideoView.this.fWs.dBL();
                    PushDialogVideoView.this.ant.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mB().postDelayed(PushDialogVideoView.this.abV, 20L);
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abP = false;
                PushDialogVideoView.this.mCt = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kZn.setVisibility(0);
                PushDialogVideoView.this.mBM.setVisibility(8);
                PushDialogVideoView.this.mBM.setProgress(PushDialogVideoView.this.mBM.getMax());
                if (PushDialogVideoView.this.gBU == null || PushDialogVideoView.this.gBU.getDuration() > 150000) {
                    PushDialogVideoView.this.wV(false);
                } else {
                    PushDialogVideoView.this.mBP.setVisibility(0);
                }
                n.dBQ().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.getDuration() <= 150000) {
                    PushDialogVideoView.this.fY(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.anD);
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.iyB.setVisibility(0);
                PushDialogVideoView.this.fWs.dBM();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mCr = true;
                }
                PushDialogVideoView.this.mCt = false;
                return true;
            }
        };
        this.kZV = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iyB.setVisibility(0);
                PushDialogVideoView.this.fWs.dBM();
            }
        };
        this.eDk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mCn) {
                    e.mB().postDelayed(PushDialogVideoView.this.mCA, 200L);
                }
            }
        };
        this.mCA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU == null || !PushDialogVideoView.this.mCn) {
                    e.mB().postDelayed(PushDialogVideoView.this.abV, 200L);
                    PushDialogVideoView.this.mCn = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gBU.getCurrentPosition()) {
                    PushDialogVideoView.this.mCn = false;
                    e.mB().postDelayed(PushDialogVideoView.this.abV, 20L);
                } else {
                    e.mB().postDelayed(PushDialogVideoView.this.mCA, 200L);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abP = false;
                PushDialogVideoView.this.mCt = false;
                e.mB().removeCallbacks(PushDialogVideoView.this.abV);
                e.mB().removeCallbacks(PushDialogVideoView.this.kZV);
            }
        };
        this.laa = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aUD();
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
                            if (PushDialogVideoView.this.lbU != null) {
                                PushDialogVideoView.this.lbU.uC(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gjU - (duration % PushDialogVideoView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lbU = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void uC(int i) {
                int duration;
                if (PushDialogVideoView.this.gBU != null && (duration = PushDialogVideoView.this.gBU.getDuration()) > 0 && PushDialogVideoView.this.mBM != null) {
                    PushDialogVideoView.this.mBM.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjU = 50;
        this.mSkinType = 3;
        this.abP = false;
        this.mStartPosition = 0;
        this.mCm = true;
        this.mCn = false;
        this.mCo = false;
        this.meK = false;
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fWs.dBK();
            }
        };
        this.ivM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cuI();
            }
        };
        this.abV = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abP = true;
                    PushDialogVideoView.this.kZn.setVisibility(8);
                    PushDialogVideoView.this.iyB.setVisibility(8);
                    PushDialogVideoView.this.fWs.dBL();
                    PushDialogVideoView.this.ant.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mB().postDelayed(PushDialogVideoView.this.abV, 20L);
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abP = false;
                PushDialogVideoView.this.mCt = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kZn.setVisibility(0);
                PushDialogVideoView.this.mBM.setVisibility(8);
                PushDialogVideoView.this.mBM.setProgress(PushDialogVideoView.this.mBM.getMax());
                if (PushDialogVideoView.this.gBU == null || PushDialogVideoView.this.gBU.getDuration() > 150000) {
                    PushDialogVideoView.this.wV(false);
                } else {
                    PushDialogVideoView.this.mBP.setVisibility(0);
                }
                n.dBQ().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.getDuration() <= 150000) {
                    PushDialogVideoView.this.fY(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.anD);
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.iyB.setVisibility(0);
                PushDialogVideoView.this.fWs.dBM();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mCr = true;
                }
                PushDialogVideoView.this.mCt = false;
                return true;
            }
        };
        this.kZV = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iyB.setVisibility(0);
                PushDialogVideoView.this.fWs.dBM();
            }
        };
        this.eDk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mCn) {
                    e.mB().postDelayed(PushDialogVideoView.this.mCA, 200L);
                }
            }
        };
        this.mCA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU == null || !PushDialogVideoView.this.mCn) {
                    e.mB().postDelayed(PushDialogVideoView.this.abV, 200L);
                    PushDialogVideoView.this.mCn = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gBU.getCurrentPosition()) {
                    PushDialogVideoView.this.mCn = false;
                    e.mB().postDelayed(PushDialogVideoView.this.abV, 20L);
                } else {
                    e.mB().postDelayed(PushDialogVideoView.this.mCA, 200L);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abP = false;
                PushDialogVideoView.this.mCt = false;
                e.mB().removeCallbacks(PushDialogVideoView.this.abV);
                e.mB().removeCallbacks(PushDialogVideoView.this.kZV);
            }
        };
        this.laa = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aUD();
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
                            if (PushDialogVideoView.this.lbU != null) {
                                PushDialogVideoView.this.lbU.uC(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gjU - (duration % PushDialogVideoView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lbU = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void uC(int i) {
                int duration;
                if (PushDialogVideoView.this.gBU != null && (duration = PushDialogVideoView.this.gBU.getDuration()) > 0 && PushDialogVideoView.this.mBM != null) {
                    PushDialogVideoView.this.mBM.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjU = 50;
        this.mSkinType = 3;
        this.abP = false;
        this.mStartPosition = 0;
        this.mCm = true;
        this.mCn = false;
        this.mCo = false;
        this.meK = false;
        this.eDf = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fWs.dBK();
            }
        };
        this.ivM = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cuI();
            }
        };
        this.abV = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.abP = true;
                    PushDialogVideoView.this.kZn.setVisibility(8);
                    PushDialogVideoView.this.iyB.setVisibility(8);
                    PushDialogVideoView.this.fWs.dBL();
                    PushDialogVideoView.this.ant.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mB().postDelayed(PushDialogVideoView.this.abV, 20L);
            }
        };
        this.eDh = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.abP = false;
                PushDialogVideoView.this.mCt = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kZn.setVisibility(0);
                PushDialogVideoView.this.mBM.setVisibility(8);
                PushDialogVideoView.this.mBM.setProgress(PushDialogVideoView.this.mBM.getMax());
                if (PushDialogVideoView.this.gBU == null || PushDialogVideoView.this.gBU.getDuration() > 150000) {
                    PushDialogVideoView.this.wV(false);
                } else {
                    PushDialogVideoView.this.mBP.setVisibility(0);
                }
                n.dBQ().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gBU != null && PushDialogVideoView.this.gBU.getDuration() <= 150000) {
                    PushDialogVideoView.this.fY(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.anD);
                }
            }
        };
        this.kZU = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.iyB.setVisibility(0);
                PushDialogVideoView.this.fWs.dBM();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mCr = true;
                }
                PushDialogVideoView.this.mCt = false;
                return true;
            }
        };
        this.kZV = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iyB.setVisibility(0);
                PushDialogVideoView.this.fWs.dBM();
            }
        };
        this.eDk = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mCn) {
                    e.mB().postDelayed(PushDialogVideoView.this.mCA, 200L);
                }
            }
        };
        this.mCA = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gBU == null || !PushDialogVideoView.this.mCn) {
                    e.mB().postDelayed(PushDialogVideoView.this.abV, 200L);
                    PushDialogVideoView.this.mCn = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gBU.getCurrentPosition()) {
                    PushDialogVideoView.this.mCn = false;
                    e.mB().postDelayed(PushDialogVideoView.this.abV, 20L);
                } else {
                    e.mB().postDelayed(PushDialogVideoView.this.mCA, 200L);
                }
            }
        };
        this.fWA = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.abP = false;
                PushDialogVideoView.this.mCt = false;
                e.mB().removeCallbacks(PushDialogVideoView.this.abV);
                e.mB().removeCallbacks(PushDialogVideoView.this.kZV);
            }
        };
        this.laa = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aUD();
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
                            if (PushDialogVideoView.this.lbU != null) {
                                PushDialogVideoView.this.lbU.uC(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.gjU - (duration % PushDialogVideoView.this.gjU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.lbU = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void uC(int i2) {
                int duration;
                if (PushDialogVideoView.this.gBU != null && (duration = PushDialogVideoView.this.gBU.getDuration()) > 0 && PushDialogVideoView.this.mBM != null) {
                    PushDialogVideoView.this.mBM.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
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
        this.fWs = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fWs.setLoadingAnimationListener(this.ivM);
        this.mBM = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mBM.setMax(this.mWidth);
        this.mBM.setProgress(0);
        this.kZn = findViewById(R.id.black_mask);
        this.iyB = findViewById(R.id.layout_error);
        this.kZw = (ImageView) findViewById(R.id.img_play);
        this.mBP = (TextView) findViewById(R.id.txt_replay);
        this.hYX = (TextView) findViewById(R.id.push_dialog_video_time);
        this.ant = (TbImageView) findViewById(R.id.video_thumbnail);
        this.meU = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.ant.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kZR = new CallStateReceiver();
        this.kZR.register(context);
        this.iyB.setOnClickListener(this);
        this.mBP.setOnClickListener(this);
        this.meU.setOnPlayClickListener(this);
        this.meU.setFreeClickListener(this);
        setOnClickListener(this);
        this.gBU.setOnPreparedListener(this.eDf);
        this.gBU.setOnCompletionListener(this.eDh);
        this.gBU.setOnErrorListener(this.kZU);
        this.gBU.setOnSeekCompleteListener(this.eDk);
        this.gBU.setOnSurfaceDestroyedListener(this.fWA);
        onChangeSkinType();
    }

    public void onPause() {
        if (rn()) {
            this.meK = true;
            aUD();
            return;
        }
        this.meK = false;
        aUD();
    }

    public void onResume() {
        if (this.meK) {
            aUE();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.laa);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mJf = iVar;
        this.hYX.setText(at.stringForVideoTime(this.mJf.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.anD = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gBU.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuI() {
        if (this.gBU != null) {
            if (this.mCt) {
                this.gBU.start();
                this.mCt = false;
            }
            e.mB().removeCallbacks(this.abV);
            e.mB().postDelayed(this.abV, 20L);
            e.mB().removeCallbacks(this.kZV);
            this.mStartPosition = n.dBQ().QT(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gBU.seekTo(this.mStartPosition);
                if (!this.mCs) {
                    showProgress();
                    e.mB().removeCallbacks(this.abV);
                }
                this.mCn = true;
            }
        }
    }

    public void dvf() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gBU.isPlaying()) {
            aUD();
        } else if (this.abP) {
            aUE();
        } else {
            dBo();
        }
    }

    public void setPauseState() {
        this.fWs.dBM();
        this.kZw.setVisibility(0);
        this.mBP.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mCo) {
            fZ(str, str2);
        } else {
            fY(str, str2);
        }
        if (aVar != null) {
            aVar.xa(z);
        }
    }

    public void fY(String str, String str2) {
        dBp();
        this.mCt = true;
        setVideoUrl(str, str2);
        this.gBU.setVideoPath(str, str2);
        this.fWs.startLoading();
        this.ant.setVisibility(0);
        this.kZw.setVisibility(8);
        this.mBP.setVisibility(8);
        this.iyB.setVisibility(8);
        e.mB().removeCallbacks(this.kZV);
        e.mB().postDelayed(this.kZV, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void fZ(String str, String str2) {
        dBp();
        this.mCt = true;
        this.fWs.startLoading();
        this.ant.setVisibility(0);
        this.kZw.setVisibility(8);
        this.mBP.setVisibility(8);
        this.iyB.setVisibility(8);
        e.mB().removeCallbacks(this.kZV);
        e.mB().postDelayed(this.kZV, AppStatusRules.DEFAULT_GRANULARITY);
    }

    public void aUE() {
        this.gBU.start();
        this.ant.setVisibility(8);
        this.kZn.setVisibility(8);
        this.fWs.dBM();
        showProgress();
        this.kZw.setVisibility(8);
        this.mBP.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.mCr && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.anD)) {
            this.mCr = false;
            this.mCs = true;
            fY(this.mVideoUrl, this.anD);
        }
    }

    public void aUD() {
        if (this.gBU.isPlaying() && this.mCm) {
            dBn();
        }
        this.gBU.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gBU.isPlaying() && this.mCm) {
            dBn();
        }
        e.mB().removeCallbacks(this.abV);
        e.mB().removeCallbacks(this.kZV);
        this.gBU.stopPlayback();
        this.abP = false;
        this.mCt = false;
        this.mStartPosition = 0;
        cUw();
    }

    public void dBn() {
        n.dBQ().bK(this.mVideoUrl, this.gBU.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wV(boolean z) {
        this.kZn.setVisibility(0);
        this.kZw.setVisibility(0);
        this.mBP.setVisibility(8);
        this.fWs.dBM();
        this.mBM.setVisibility(8);
        this.iyB.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.ant.setVisibility(z ? 0 : 8);
    }

    public void cUw() {
        wV(true);
    }

    public boolean rn() {
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
            this.mBM.setVisibility(0);
            this.gjU = ((this.gBU.getDuration() / 200) / 50) * 50;
            if (this.gjU < 50) {
                this.gjU = 50;
            } else if (this.gjU > 500) {
                this.gjU = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.gjU - (this.gBU.getCurrentPosition() % this.gjU));
        }
    }

    private void dBo() {
        a(this.mVideoUrl, this.anD, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dBp();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mCo = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.mfd && !f.dTE().dTF()) {
            this.meU.setVisibility(0);
            this.meU.setData(this.mJf.getDuration(), this.mJf.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dBp() {
        if (j.isMobileNet()) {
            f.dTE().gY(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.ant.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iyB) {
            dBo();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").an("obj_locate", 2).dX("tid", this.anD));
            dvf();
        } else if (view == this.mBP) {
            fY(this.mVideoUrl, this.anD);
        } else if (view == this.meU.getTvPlay()) {
            this.mfd = true;
            this.meU.setVisibility(8);
            fY(this.mVideoUrl, this.anD);
        } else if (view == this.meU.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mB().removeCallbacks(this.abV);
        e.mB().removeCallbacks(this.kZV);
        e.mB().removeCallbacks(this.mCA);
        this.mHandler.removeMessages(1);
        this.kZR.unregister(getContext());
    }
}
