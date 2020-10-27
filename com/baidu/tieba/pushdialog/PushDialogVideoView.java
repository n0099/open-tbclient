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
import com.baidu.adp.lib.util.l;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.j;
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
import com.baidu.tieba.video.g;
/* loaded from: classes21.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean aae;
    private Runnable aak;
    private TbImageView alJ;
    private String alT;
    private CyberPlayerManager.OnPreparedListener eim;
    private CyberPlayerManager.OnCompletionListener eio;
    private CyberPlayerManager.OnSeekCompleteListener eir;
    private int fMU;
    private m fzK;
    private TbCyberVideoView.a fzS;
    private TbCyberVideoView gdn;
    private VideoLoadingProgressView.a hRV;
    private View hUJ;
    private TextView hxn;
    private CallStateReceiver kAL;
    private CyberPlayerManager.OnErrorListener kAO;
    private Runnable kAP;
    private CustomMessageListener kAU;
    private View kAh;
    private ImageView kAq;
    private VideoControllerView.b kCN;
    private boolean lFB;
    private boolean lFh;
    private PbVideoWifiTipLayout lFs;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private boolean mcB;
    private boolean mcC;
    private boolean mcD;
    private boolean mcG;
    private boolean mcH;
    private boolean mcI;
    private Runnable mcO;
    private ProgressBar mcb;
    private TextView mce;
    private j mjn;

    /* loaded from: classes21.dex */
    public interface a {
        void wj(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fMU = 50;
        this.mSkinType = 3;
        this.aae = false;
        this.mStartPosition = 0;
        this.mcB = true;
        this.mcC = false;
        this.mcD = false;
        this.lFh = false;
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fzK.duz();
            }
        };
        this.hRV = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.clx();
            }
        };
        this.aak = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gdn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aae = true;
                    PushDialogVideoView.this.kAh.setVisibility(8);
                    PushDialogVideoView.this.hUJ.setVisibility(8);
                    PushDialogVideoView.this.fzK.duA();
                    PushDialogVideoView.this.alJ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.mcI = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kAh.setVisibility(0);
                PushDialogVideoView.this.mcb.setVisibility(8);
                PushDialogVideoView.this.mcb.setProgress(PushDialogVideoView.this.mcb.getMax());
                if (PushDialogVideoView.this.gdn == null || PushDialogVideoView.this.gdn.getDuration() > 150000) {
                    PushDialogVideoView.this.we(false);
                } else {
                    PushDialogVideoView.this.mce.setVisibility(0);
                }
                n.duF().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gdn != null && PushDialogVideoView.this.gdn.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alT);
                }
            }
        };
        this.kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hUJ.setVisibility(0);
                PushDialogVideoView.this.fzK.duB();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mcG = true;
                }
                PushDialogVideoView.this.mcI = false;
                return true;
            }
        };
        this.kAP = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hUJ.setVisibility(0);
                PushDialogVideoView.this.fzK.duB();
            }
        };
        this.eir = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mcC) {
                    e.mY().postDelayed(PushDialogVideoView.this.mcO, 200L);
                }
            }
        };
        this.mcO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gdn == null || !PushDialogVideoView.this.mcC) {
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 200L);
                    PushDialogVideoView.this.mcC = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gdn.getCurrentPosition()) {
                    PushDialogVideoView.this.mcC = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mcO, 200L);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.mcI = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aak);
                e.mY().removeCallbacks(PushDialogVideoView.this.kAP);
            }
        };
        this.kAU = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aNl();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gdn != null && PushDialogVideoView.this.gdn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gdn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gdn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kCN != null) {
                                PushDialogVideoView.this.kCN.tf(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fMU - (duration % PushDialogVideoView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kCN = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tf(int i) {
                int duration;
                if (PushDialogVideoView.this.gdn != null && (duration = PushDialogVideoView.this.gdn.getDuration()) > 0 && PushDialogVideoView.this.mcb != null) {
                    PushDialogVideoView.this.mcb.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fMU = 50;
        this.mSkinType = 3;
        this.aae = false;
        this.mStartPosition = 0;
        this.mcB = true;
        this.mcC = false;
        this.mcD = false;
        this.lFh = false;
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fzK.duz();
            }
        };
        this.hRV = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.clx();
            }
        };
        this.aak = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gdn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aae = true;
                    PushDialogVideoView.this.kAh.setVisibility(8);
                    PushDialogVideoView.this.hUJ.setVisibility(8);
                    PushDialogVideoView.this.fzK.duA();
                    PushDialogVideoView.this.alJ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.mcI = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kAh.setVisibility(0);
                PushDialogVideoView.this.mcb.setVisibility(8);
                PushDialogVideoView.this.mcb.setProgress(PushDialogVideoView.this.mcb.getMax());
                if (PushDialogVideoView.this.gdn == null || PushDialogVideoView.this.gdn.getDuration() > 150000) {
                    PushDialogVideoView.this.we(false);
                } else {
                    PushDialogVideoView.this.mce.setVisibility(0);
                }
                n.duF().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gdn != null && PushDialogVideoView.this.gdn.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alT);
                }
            }
        };
        this.kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hUJ.setVisibility(0);
                PushDialogVideoView.this.fzK.duB();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mcG = true;
                }
                PushDialogVideoView.this.mcI = false;
                return true;
            }
        };
        this.kAP = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hUJ.setVisibility(0);
                PushDialogVideoView.this.fzK.duB();
            }
        };
        this.eir = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mcC) {
                    e.mY().postDelayed(PushDialogVideoView.this.mcO, 200L);
                }
            }
        };
        this.mcO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gdn == null || !PushDialogVideoView.this.mcC) {
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 200L);
                    PushDialogVideoView.this.mcC = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gdn.getCurrentPosition()) {
                    PushDialogVideoView.this.mcC = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mcO, 200L);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.mcI = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aak);
                e.mY().removeCallbacks(PushDialogVideoView.this.kAP);
            }
        };
        this.kAU = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aNl();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gdn != null && PushDialogVideoView.this.gdn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gdn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gdn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kCN != null) {
                                PushDialogVideoView.this.kCN.tf(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fMU - (duration % PushDialogVideoView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kCN = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tf(int i) {
                int duration;
                if (PushDialogVideoView.this.gdn != null && (duration = PushDialogVideoView.this.gdn.getDuration()) > 0 && PushDialogVideoView.this.mcb != null) {
                    PushDialogVideoView.this.mcb.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fMU = 50;
        this.mSkinType = 3;
        this.aae = false;
        this.mStartPosition = 0;
        this.mcB = true;
        this.mcC = false;
        this.mcD = false;
        this.lFh = false;
        this.eim = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fzK.duz();
            }
        };
        this.hRV = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.clx();
            }
        };
        this.aak = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gdn.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aae = true;
                    PushDialogVideoView.this.kAh.setVisibility(8);
                    PushDialogVideoView.this.hUJ.setVisibility(8);
                    PushDialogVideoView.this.fzK.duA();
                    PushDialogVideoView.this.alJ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
            }
        };
        this.eio = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.mcI = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kAh.setVisibility(0);
                PushDialogVideoView.this.mcb.setVisibility(8);
                PushDialogVideoView.this.mcb.setProgress(PushDialogVideoView.this.mcb.getMax());
                if (PushDialogVideoView.this.gdn == null || PushDialogVideoView.this.gdn.getDuration() > 150000) {
                    PushDialogVideoView.this.we(false);
                } else {
                    PushDialogVideoView.this.mce.setVisibility(0);
                }
                n.duF().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gdn != null && PushDialogVideoView.this.gdn.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alT);
                }
            }
        };
        this.kAO = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.hUJ.setVisibility(0);
                PushDialogVideoView.this.fzK.duB();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.mcG = true;
                }
                PushDialogVideoView.this.mcI = false;
                return true;
            }
        };
        this.kAP = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hUJ.setVisibility(0);
                PushDialogVideoView.this.fzK.duB();
            }
        };
        this.eir = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.mcC) {
                    e.mY().postDelayed(PushDialogVideoView.this.mcO, 200L);
                }
            }
        };
        this.mcO = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gdn == null || !PushDialogVideoView.this.mcC) {
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 200L);
                    PushDialogVideoView.this.mcC = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gdn.getCurrentPosition()) {
                    PushDialogVideoView.this.mcC = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mcO, 200L);
                }
            }
        };
        this.fzS = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.mcI = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aak);
                e.mY().removeCallbacks(PushDialogVideoView.this.kAP);
            }
        };
        this.kAU = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aNl();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gdn != null && PushDialogVideoView.this.gdn.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gdn.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gdn.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kCN != null) {
                                PushDialogVideoView.this.kCN.tf(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fMU - (duration % PushDialogVideoView.this.fMU));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kCN = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tf(int i2) {
                int duration;
                if (PushDialogVideoView.this.gdn != null && (duration = PushDialogVideoView.this.gdn.getDuration()) > 0 && PushDialogVideoView.this.mcb != null) {
                    PushDialogVideoView.this.mcb.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gdn = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gdn.setPlayMode("2");
        this.gdn.setStageType(null);
        this.fzK = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fzK.setLoadingAnimationListener(this.hRV);
        this.mcb = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mcb.setMax(this.mWidth);
        this.mcb.setProgress(0);
        this.kAh = findViewById(R.id.black_mask);
        this.hUJ = findViewById(R.id.layout_error);
        this.kAq = (ImageView) findViewById(R.id.img_play);
        this.mce = (TextView) findViewById(R.id.txt_replay);
        this.hxn = (TextView) findViewById(R.id.push_dialog_video_time);
        this.alJ = (TbImageView) findViewById(R.id.video_thumbnail);
        this.lFs = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.alJ.setDefaultErrorResource(0);
        this.alJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kAL = new CallStateReceiver();
        this.kAL.register(context);
        this.hUJ.setOnClickListener(this);
        this.mce.setOnClickListener(this);
        this.lFs.setOnPlayClickListener(this);
        this.lFs.setFreeClickListener(this);
        setOnClickListener(this);
        this.gdn.setOnPreparedListener(this.eim);
        this.gdn.setOnCompletionListener(this.eio);
        this.gdn.setOnErrorListener(this.kAO);
        this.gdn.setOnSeekCompleteListener(this.eir);
        this.gdn.setOnSurfaceDestroyedListener(this.fzS);
        onChangeSkinType();
    }

    public void onPause() {
        if (rK()) {
            this.lFh = true;
            aNl();
            return;
        }
        this.lFh = false;
        aNl();
    }

    public void onResume() {
        if (this.lFh) {
            aNm();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kAU);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.mjn = jVar;
        this.hxn.setText(at.stringForVideoTime(this.mjn.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alT = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gdn.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clx() {
        if (this.gdn != null) {
            if (this.mcI) {
                this.gdn.start();
                this.mcI = false;
            }
            e.mY().removeCallbacks(this.aak);
            e.mY().postDelayed(this.aak, 20L);
            e.mY().removeCallbacks(this.kAP);
            this.mStartPosition = n.duF().Qt(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gdn.seekTo(this.mStartPosition);
                if (!this.mcH) {
                    showProgress();
                    e.mY().removeCallbacks(this.aak);
                }
                this.mcC = true;
            }
        }
    }

    public void dnT() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gdn.isPlaying()) {
            aNl();
        } else if (this.aae) {
            aNm();
        } else {
            dud();
        }
    }

    public void setPauseState() {
        this.fzK.duB();
        this.kAq.setVisibility(0);
        this.mce.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.mcD) {
            fX(str, str2);
        } else {
            fW(str, str2);
        }
        if (aVar != null) {
            aVar.wj(z);
        }
    }

    public void fW(String str, String str2) {
        due();
        this.mcI = true;
        setVideoUrl(str, str2);
        this.gdn.setVideoPath(str, str2);
        this.fzK.startLoading();
        this.alJ.setVisibility(0);
        this.kAq.setVisibility(8);
        this.mce.setVisibility(8);
        this.hUJ.setVisibility(8);
        e.mY().removeCallbacks(this.kAP);
        e.mY().postDelayed(this.kAP, 60000L);
    }

    public void fX(String str, String str2) {
        due();
        this.mcI = true;
        this.fzK.startLoading();
        this.alJ.setVisibility(0);
        this.kAq.setVisibility(8);
        this.mce.setVisibility(8);
        this.hUJ.setVisibility(8);
        e.mY().removeCallbacks(this.kAP);
        e.mY().postDelayed(this.kAP, 60000L);
    }

    public void aNm() {
        this.gdn.start();
        this.alJ.setVisibility(8);
        this.kAh.setVisibility(8);
        this.fzK.duB();
        showProgress();
        this.kAq.setVisibility(8);
        this.mce.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.mcG && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alT)) {
            this.mcG = false;
            this.mcH = true;
            fW(this.mVideoUrl, this.alT);
        }
    }

    public void aNl() {
        if (this.gdn.isPlaying() && this.mcB) {
            duc();
        }
        this.gdn.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gdn.isPlaying() && this.mcB) {
            duc();
        }
        e.mY().removeCallbacks(this.aak);
        e.mY().removeCallbacks(this.kAP);
        this.gdn.stopPlayback();
        this.aae = false;
        this.mcI = false;
        this.mStartPosition = 0;
        cJS();
    }

    public void duc() {
        n.duF().bA(this.mVideoUrl, this.gdn.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(boolean z) {
        this.kAh.setVisibility(0);
        this.kAq.setVisibility(0);
        this.mce.setVisibility(8);
        this.fzK.duB();
        this.mcb.setVisibility(8);
        this.hUJ.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.alJ.setVisibility(z ? 0 : 8);
    }

    public void cJS() {
        we(true);
    }

    public boolean rK() {
        if (this.gdn == null) {
            return false;
        }
        return this.gdn.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gdn == null) {
            return 0;
        }
        return this.gdn.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gdn != null) {
            this.mcb.setVisibility(0);
            this.fMU = ((this.gdn.getDuration() / 200) / 50) * 50;
            if (this.fMU < 50) {
                this.fMU = 50;
            } else if (this.fMU > 500) {
                this.fMU = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fMU - (this.gdn.getCurrentPosition() % this.fMU));
        }
    }

    private void dud() {
        a(this.mVideoUrl, this.alT, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        due();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.mcD = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.lFB && !g.dLS().dLT()) {
            this.lFs.setVisibility(0);
            this.lFs.setData(this.mjn.getDuration(), this.mjn.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void due() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dLS().fW(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.alJ.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hUJ) {
            dud();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").aj("obj_locate", 2).dR("tid", this.alT));
            dnT();
        } else if (view == this.mce) {
            fW(this.mVideoUrl, this.alT);
        } else if (view == this.lFs.getTvPlay()) {
            this.lFB = true;
            this.lFs.setVisibility(8);
            fW(this.mVideoUrl, this.alT);
        } else if (view == this.lFs.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mY().removeCallbacks(this.aak);
        e.mY().removeCallbacks(this.kAP);
        e.mY().removeCallbacks(this.mcO);
        this.mHandler.removeMessages(1);
        this.kAL.unregister(getContext());
    }
}
