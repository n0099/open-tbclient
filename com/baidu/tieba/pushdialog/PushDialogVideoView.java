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
    private CyberPlayerManager.OnPreparedListener eog;
    private CyberPlayerManager.OnCompletionListener eoi;
    private CyberPlayerManager.OnSeekCompleteListener eol;
    private m fFA;
    private TbCyberVideoView.a fFI;
    private int fSK;
    private TbCyberVideoView gjd;
    private TextView hDk;
    private VideoLoadingProgressView.a hXS;
    private View iaG;
    private CallStateReceiver kGF;
    private CyberPlayerManager.OnErrorListener kGI;
    private Runnable kGJ;
    private CustomMessageListener kGO;
    private View kGb;
    private ImageView kGk;
    private VideoControllerView.b kIH;
    private boolean lLd;
    private PbVideoWifiTipLayout lLo;
    private boolean lLx;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private ProgressBar mhY;
    private boolean miA;
    private boolean miB;
    private boolean miC;
    private boolean miF;
    private boolean miG;
    private boolean miH;
    private Runnable miN;
    private TextView mib;
    private j mpk;

    /* loaded from: classes21.dex */
    public interface a {
        void ws(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fSK = 50;
        this.mSkinType = 3;
        this.aae = false;
        this.mStartPosition = 0;
        this.miA = true;
        this.miB = false;
        this.miC = false;
        this.lLd = false;
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fFA.dxb();
            }
        };
        this.hXS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cnY();
            }
        };
        this.aak = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gjd.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aae = true;
                    PushDialogVideoView.this.kGb.setVisibility(8);
                    PushDialogVideoView.this.iaG.setVisibility(8);
                    PushDialogVideoView.this.fFA.dxc();
                    PushDialogVideoView.this.alJ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.miH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kGb.setVisibility(0);
                PushDialogVideoView.this.mhY.setVisibility(8);
                PushDialogVideoView.this.mhY.setProgress(PushDialogVideoView.this.mhY.getMax());
                if (PushDialogVideoView.this.gjd == null || PushDialogVideoView.this.gjd.getDuration() > 150000) {
                    PushDialogVideoView.this.wn(false);
                } else {
                    PushDialogVideoView.this.mib.setVisibility(0);
                }
                n.dxh().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gjd != null && PushDialogVideoView.this.gjd.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alT);
                }
            }
        };
        this.kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.iaG.setVisibility(0);
                PushDialogVideoView.this.fFA.dxd();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.miF = true;
                }
                PushDialogVideoView.this.miH = false;
                return true;
            }
        };
        this.kGJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iaG.setVisibility(0);
                PushDialogVideoView.this.fFA.dxd();
            }
        };
        this.eol = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.miB) {
                    e.mY().postDelayed(PushDialogVideoView.this.miN, 200L);
                }
            }
        };
        this.miN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gjd == null || !PushDialogVideoView.this.miB) {
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 200L);
                    PushDialogVideoView.this.miB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gjd.getCurrentPosition()) {
                    PushDialogVideoView.this.miB = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.miN, 200L);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.miH = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aak);
                e.mY().removeCallbacks(PushDialogVideoView.this.kGJ);
            }
        };
        this.kGO = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aPL();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gjd != null && PushDialogVideoView.this.gjd.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gjd.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gjd.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kIH != null) {
                                PushDialogVideoView.this.kIH.tp(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fSK - (duration % PushDialogVideoView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIH = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tp(int i) {
                int duration;
                if (PushDialogVideoView.this.gjd != null && (duration = PushDialogVideoView.this.gjd.getDuration()) > 0 && PushDialogVideoView.this.mhY != null) {
                    PushDialogVideoView.this.mhY.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSK = 50;
        this.mSkinType = 3;
        this.aae = false;
        this.mStartPosition = 0;
        this.miA = true;
        this.miB = false;
        this.miC = false;
        this.lLd = false;
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fFA.dxb();
            }
        };
        this.hXS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cnY();
            }
        };
        this.aak = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gjd.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aae = true;
                    PushDialogVideoView.this.kGb.setVisibility(8);
                    PushDialogVideoView.this.iaG.setVisibility(8);
                    PushDialogVideoView.this.fFA.dxc();
                    PushDialogVideoView.this.alJ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.miH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kGb.setVisibility(0);
                PushDialogVideoView.this.mhY.setVisibility(8);
                PushDialogVideoView.this.mhY.setProgress(PushDialogVideoView.this.mhY.getMax());
                if (PushDialogVideoView.this.gjd == null || PushDialogVideoView.this.gjd.getDuration() > 150000) {
                    PushDialogVideoView.this.wn(false);
                } else {
                    PushDialogVideoView.this.mib.setVisibility(0);
                }
                n.dxh().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gjd != null && PushDialogVideoView.this.gjd.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alT);
                }
            }
        };
        this.kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.iaG.setVisibility(0);
                PushDialogVideoView.this.fFA.dxd();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.miF = true;
                }
                PushDialogVideoView.this.miH = false;
                return true;
            }
        };
        this.kGJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iaG.setVisibility(0);
                PushDialogVideoView.this.fFA.dxd();
            }
        };
        this.eol = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.miB) {
                    e.mY().postDelayed(PushDialogVideoView.this.miN, 200L);
                }
            }
        };
        this.miN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gjd == null || !PushDialogVideoView.this.miB) {
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 200L);
                    PushDialogVideoView.this.miB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gjd.getCurrentPosition()) {
                    PushDialogVideoView.this.miB = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.miN, 200L);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.miH = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aak);
                e.mY().removeCallbacks(PushDialogVideoView.this.kGJ);
            }
        };
        this.kGO = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aPL();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gjd != null && PushDialogVideoView.this.gjd.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gjd.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gjd.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kIH != null) {
                                PushDialogVideoView.this.kIH.tp(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fSK - (duration % PushDialogVideoView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIH = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tp(int i) {
                int duration;
                if (PushDialogVideoView.this.gjd != null && (duration = PushDialogVideoView.this.gjd.getDuration()) > 0 && PushDialogVideoView.this.mhY != null) {
                    PushDialogVideoView.this.mhY.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSK = 50;
        this.mSkinType = 3;
        this.aae = false;
        this.mStartPosition = 0;
        this.miA = true;
        this.miB = false;
        this.miC = false;
        this.lLd = false;
        this.eog = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fFA.dxb();
            }
        };
        this.hXS = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cnY();
            }
        };
        this.aak = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gjd.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aae = true;
                    PushDialogVideoView.this.kGb.setVisibility(8);
                    PushDialogVideoView.this.iaG.setVisibility(8);
                    PushDialogVideoView.this.fFA.dxc();
                    PushDialogVideoView.this.alJ.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
            }
        };
        this.eoi = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.miH = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kGb.setVisibility(0);
                PushDialogVideoView.this.mhY.setVisibility(8);
                PushDialogVideoView.this.mhY.setProgress(PushDialogVideoView.this.mhY.getMax());
                if (PushDialogVideoView.this.gjd == null || PushDialogVideoView.this.gjd.getDuration() > 150000) {
                    PushDialogVideoView.this.wn(false);
                } else {
                    PushDialogVideoView.this.mib.setVisibility(0);
                }
                n.dxh().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.gjd != null && PushDialogVideoView.this.gjd.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alT);
                }
            }
        };
        this.kGI = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.iaG.setVisibility(0);
                PushDialogVideoView.this.fFA.dxd();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.miF = true;
                }
                PushDialogVideoView.this.miH = false;
                return true;
            }
        };
        this.kGJ = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.iaG.setVisibility(0);
                PushDialogVideoView.this.fFA.dxd();
            }
        };
        this.eol = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.miB) {
                    e.mY().postDelayed(PushDialogVideoView.this.miN, 200L);
                }
            }
        };
        this.miN = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.gjd == null || !PushDialogVideoView.this.miB) {
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 200L);
                    PushDialogVideoView.this.miB = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.gjd.getCurrentPosition()) {
                    PushDialogVideoView.this.miB = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aak, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.miN, 200L);
                }
            }
        };
        this.fFI = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aae = false;
                PushDialogVideoView.this.miH = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aak);
                e.mY().removeCallbacks(PushDialogVideoView.this.kGJ);
            }
        };
        this.kGO = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aPL();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.gjd != null && PushDialogVideoView.this.gjd.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.gjd.getCurrentPosition();
                            int duration = PushDialogVideoView.this.gjd.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kIH != null) {
                                PushDialogVideoView.this.kIH.tp(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fSK - (duration % PushDialogVideoView.this.fSK));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIH = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tp(int i2) {
                int duration;
                if (PushDialogVideoView.this.gjd != null && (duration = PushDialogVideoView.this.gjd.getDuration()) > 0 && PushDialogVideoView.this.mhY != null) {
                    PushDialogVideoView.this.mhY.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.gjd = (TbCyberVideoView) findViewById(R.id.videoView);
        this.gjd.setPlayMode("2");
        this.gjd.setStageType(null);
        this.fFA = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fFA.setLoadingAnimationListener(this.hXS);
        this.mhY = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mhY.setMax(this.mWidth);
        this.mhY.setProgress(0);
        this.kGb = findViewById(R.id.black_mask);
        this.iaG = findViewById(R.id.layout_error);
        this.kGk = (ImageView) findViewById(R.id.img_play);
        this.mib = (TextView) findViewById(R.id.txt_replay);
        this.hDk = (TextView) findViewById(R.id.push_dialog_video_time);
        this.alJ = (TbImageView) findViewById(R.id.video_thumbnail);
        this.lLo = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.alJ.setDefaultErrorResource(0);
        this.alJ.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kGF = new CallStateReceiver();
        this.kGF.register(context);
        this.iaG.setOnClickListener(this);
        this.mib.setOnClickListener(this);
        this.lLo.setOnPlayClickListener(this);
        this.lLo.setFreeClickListener(this);
        setOnClickListener(this);
        this.gjd.setOnPreparedListener(this.eog);
        this.gjd.setOnCompletionListener(this.eoi);
        this.gjd.setOnErrorListener(this.kGI);
        this.gjd.setOnSeekCompleteListener(this.eol);
        this.gjd.setOnSurfaceDestroyedListener(this.fFI);
        onChangeSkinType();
    }

    public void onPause() {
        if (rK()) {
            this.lLd = true;
            aPL();
            return;
        }
        this.lLd = false;
        aPL();
    }

    public void onResume() {
        if (this.lLd) {
            aPM();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kGO);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.mpk = jVar;
        this.hDk.setText(at.stringForVideoTime(this.mpk.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alT = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.gjd.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnY() {
        if (this.gjd != null) {
            if (this.miH) {
                this.gjd.start();
                this.miH = false;
            }
            e.mY().removeCallbacks(this.aak);
            e.mY().postDelayed(this.aak, 20L);
            e.mY().removeCallbacks(this.kGJ);
            this.mStartPosition = n.dxh().QK(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.gjd.seekTo(this.mStartPosition);
                if (!this.miG) {
                    showProgress();
                    e.mY().removeCallbacks(this.aak);
                }
                this.miB = true;
            }
        }
    }

    public void dqv() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.gjd.isPlaying()) {
            aPL();
        } else if (this.aae) {
            aPM();
        } else {
            dwF();
        }
    }

    public void setPauseState() {
        this.fFA.dxd();
        this.kGk.setVisibility(0);
        this.mib.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.miC) {
            fX(str, str2);
        } else {
            fW(str, str2);
        }
        if (aVar != null) {
            aVar.ws(z);
        }
    }

    public void fW(String str, String str2) {
        dwG();
        this.miH = true;
        setVideoUrl(str, str2);
        this.gjd.setVideoPath(str, str2);
        this.fFA.startLoading();
        this.alJ.setVisibility(0);
        this.kGk.setVisibility(8);
        this.mib.setVisibility(8);
        this.iaG.setVisibility(8);
        e.mY().removeCallbacks(this.kGJ);
        e.mY().postDelayed(this.kGJ, 60000L);
    }

    public void fX(String str, String str2) {
        dwG();
        this.miH = true;
        this.fFA.startLoading();
        this.alJ.setVisibility(0);
        this.kGk.setVisibility(8);
        this.mib.setVisibility(8);
        this.iaG.setVisibility(8);
        e.mY().removeCallbacks(this.kGJ);
        e.mY().postDelayed(this.kGJ, 60000L);
    }

    public void aPM() {
        this.gjd.start();
        this.alJ.setVisibility(8);
        this.kGb.setVisibility(8);
        this.fFA.dxd();
        showProgress();
        this.kGk.setVisibility(8);
        this.mib.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.miF && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alT)) {
            this.miF = false;
            this.miG = true;
            fW(this.mVideoUrl, this.alT);
        }
    }

    public void aPL() {
        if (this.gjd.isPlaying() && this.miA) {
            dwE();
        }
        this.gjd.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.gjd.isPlaying() && this.miA) {
            dwE();
        }
        e.mY().removeCallbacks(this.aak);
        e.mY().removeCallbacks(this.kGJ);
        this.gjd.stopPlayback();
        this.aae = false;
        this.miH = false;
        this.mStartPosition = 0;
        cMt();
    }

    public void dwE() {
        n.dxh().bC(this.mVideoUrl, this.gjd.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn(boolean z) {
        this.kGb.setVisibility(0);
        this.kGk.setVisibility(0);
        this.mib.setVisibility(8);
        this.fFA.dxd();
        this.mhY.setVisibility(8);
        this.iaG.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.alJ.setVisibility(z ? 0 : 8);
    }

    public void cMt() {
        wn(true);
    }

    public boolean rK() {
        if (this.gjd == null) {
            return false;
        }
        return this.gjd.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.gjd == null) {
            return 0;
        }
        return this.gjd.getCurrentPosition();
    }

    public void showProgress() {
        if (this.gjd != null) {
            this.mhY.setVisibility(0);
            this.fSK = ((this.gjd.getDuration() / 200) / 50) * 50;
            if (this.fSK < 50) {
                this.fSK = 50;
            } else if (this.fSK > 500) {
                this.fSK = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fSK - (this.gjd.getCurrentPosition() % this.fSK));
        }
    }

    private void dwF() {
        a(this.mVideoUrl, this.alT, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dwG();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.miC = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.lLx && !g.dOu().dOv()) {
            this.lLo.setVisibility(0);
            this.lLo.setData(this.mpk.getDuration(), this.mpk.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dwG() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dOu().fW(getContext());
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
        if (view == this.iaG) {
            dwF();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").al("obj_locate", 2).dR("tid", this.alT));
            dqv();
        } else if (view == this.mib) {
            fW(this.mVideoUrl, this.alT);
        } else if (view == this.lLo.getTvPlay()) {
            this.lLx = true;
            this.lLo.setVisibility(8);
            fW(this.mVideoUrl, this.alT);
        } else if (view == this.lLo.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mY().removeCallbacks(this.kGJ);
        e.mY().removeCallbacks(this.miN);
        this.mHandler.removeMessages(1);
        this.kGF.unregister(getContext());
    }
}
