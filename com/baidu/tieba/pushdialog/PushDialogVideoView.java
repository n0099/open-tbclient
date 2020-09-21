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
/* loaded from: classes20.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean ZM;
    private Runnable ZS;
    private String alA;
    private TbImageView alq;
    private CyberPlayerManager.OnPreparedListener dNO;
    private CyberPlayerManager.OnCompletionListener dNQ;
    private CyberPlayerManager.OnSeekCompleteListener dNT;
    private TbCyberVideoView fHb;
    private m feY;
    private TbCyberVideoView.a ffg;
    private int fso;
    private TextView gWv;
    private VideoLoadingProgressView.a hqE;
    private View hts;
    private ImageView jYD;
    private CallStateReceiver jYZ;
    private View jYu;
    private CyberPlayerManager.OnErrorListener jZc;
    private Runnable jZd;
    private CustomMessageListener jZi;
    private VideoControllerView.b kbc;
    private boolean lAO;
    private boolean lAP;
    private boolean lAQ;
    private boolean lAT;
    private boolean lAU;
    private boolean lAV;
    private ProgressBar lAo;
    private TextView lAr;
    private Runnable lBb;
    private j lHy;
    private PbVideoWifiTipLayout ldC;
    private boolean ldL;
    private boolean ldr;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;

    /* loaded from: classes20.dex */
    public interface a {
        void vl(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fso = 50;
        this.mSkinType = 3;
        this.ZM = false;
        this.mStartPosition = 0;
        this.lAO = true;
        this.lAP = false;
        this.lAQ = false;
        this.ldr = false;
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.feY.dnH();
            }
        };
        this.hqE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.ceU();
            }
        };
        this.ZS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fHb.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.ZM = true;
                    PushDialogVideoView.this.jYu.setVisibility(8);
                    PushDialogVideoView.this.hts.setVisibility(8);
                    PushDialogVideoView.this.feY.dnI();
                    PushDialogVideoView.this.alq.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mX().postDelayed(PushDialogVideoView.this.ZS, 20L);
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.ZM = false;
                PushDialogVideoView.this.lAV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jYu.setVisibility(0);
                PushDialogVideoView.this.lAo.setVisibility(8);
                PushDialogVideoView.this.lAo.setProgress(PushDialogVideoView.this.lAo.getMax());
                if (PushDialogVideoView.this.fHb == null || PushDialogVideoView.this.fHb.getDuration() > 150000) {
                    PushDialogVideoView.this.vg(false);
                } else {
                    PushDialogVideoView.this.lAr.setVisibility(0);
                }
                n.dnN().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fHb != null && PushDialogVideoView.this.fHb.getDuration() <= 150000) {
                    PushDialogVideoView.this.fK(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alA);
                }
            }
        };
        this.jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hts.setVisibility(0);
                PushDialogVideoView.this.feY.dnJ();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lAT = true;
                }
                PushDialogVideoView.this.lAV = false;
                return true;
            }
        };
        this.jZd = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hts.setVisibility(0);
                PushDialogVideoView.this.feY.dnJ();
            }
        };
        this.dNT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lAP) {
                    e.mX().postDelayed(PushDialogVideoView.this.lBb, 200L);
                }
            }
        };
        this.lBb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fHb == null || !PushDialogVideoView.this.lAP) {
                    e.mX().postDelayed(PushDialogVideoView.this.ZS, 200L);
                    PushDialogVideoView.this.lAP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fHb.getCurrentPosition()) {
                    PushDialogVideoView.this.lAP = false;
                    e.mX().postDelayed(PushDialogVideoView.this.ZS, 20L);
                } else {
                    e.mX().postDelayed(PushDialogVideoView.this.lBb, 200L);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.ZM = false;
                PushDialogVideoView.this.lAV = false;
                e.mX().removeCallbacks(PushDialogVideoView.this.ZS);
                e.mX().removeCallbacks(PushDialogVideoView.this.jZd);
            }
        };
        this.jZi = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aII();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fHb != null && PushDialogVideoView.this.fHb.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fHb.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fHb.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kbc != null) {
                                PushDialogVideoView.this.kbc.sw(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fso - (duration % PushDialogVideoView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kbc = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sw(int i) {
                int duration;
                if (PushDialogVideoView.this.fHb != null && (duration = PushDialogVideoView.this.fHb.getDuration()) > 0 && PushDialogVideoView.this.lAo != null) {
                    PushDialogVideoView.this.lAo.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fso = 50;
        this.mSkinType = 3;
        this.ZM = false;
        this.mStartPosition = 0;
        this.lAO = true;
        this.lAP = false;
        this.lAQ = false;
        this.ldr = false;
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.feY.dnH();
            }
        };
        this.hqE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.ceU();
            }
        };
        this.ZS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fHb.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.ZM = true;
                    PushDialogVideoView.this.jYu.setVisibility(8);
                    PushDialogVideoView.this.hts.setVisibility(8);
                    PushDialogVideoView.this.feY.dnI();
                    PushDialogVideoView.this.alq.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mX().postDelayed(PushDialogVideoView.this.ZS, 20L);
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.ZM = false;
                PushDialogVideoView.this.lAV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jYu.setVisibility(0);
                PushDialogVideoView.this.lAo.setVisibility(8);
                PushDialogVideoView.this.lAo.setProgress(PushDialogVideoView.this.lAo.getMax());
                if (PushDialogVideoView.this.fHb == null || PushDialogVideoView.this.fHb.getDuration() > 150000) {
                    PushDialogVideoView.this.vg(false);
                } else {
                    PushDialogVideoView.this.lAr.setVisibility(0);
                }
                n.dnN().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fHb != null && PushDialogVideoView.this.fHb.getDuration() <= 150000) {
                    PushDialogVideoView.this.fK(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alA);
                }
            }
        };
        this.jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.hts.setVisibility(0);
                PushDialogVideoView.this.feY.dnJ();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lAT = true;
                }
                PushDialogVideoView.this.lAV = false;
                return true;
            }
        };
        this.jZd = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hts.setVisibility(0);
                PushDialogVideoView.this.feY.dnJ();
            }
        };
        this.dNT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lAP) {
                    e.mX().postDelayed(PushDialogVideoView.this.lBb, 200L);
                }
            }
        };
        this.lBb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fHb == null || !PushDialogVideoView.this.lAP) {
                    e.mX().postDelayed(PushDialogVideoView.this.ZS, 200L);
                    PushDialogVideoView.this.lAP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fHb.getCurrentPosition()) {
                    PushDialogVideoView.this.lAP = false;
                    e.mX().postDelayed(PushDialogVideoView.this.ZS, 20L);
                } else {
                    e.mX().postDelayed(PushDialogVideoView.this.lBb, 200L);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.ZM = false;
                PushDialogVideoView.this.lAV = false;
                e.mX().removeCallbacks(PushDialogVideoView.this.ZS);
                e.mX().removeCallbacks(PushDialogVideoView.this.jZd);
            }
        };
        this.jZi = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aII();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fHb != null && PushDialogVideoView.this.fHb.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fHb.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fHb.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kbc != null) {
                                PushDialogVideoView.this.kbc.sw(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fso - (duration % PushDialogVideoView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kbc = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sw(int i) {
                int duration;
                if (PushDialogVideoView.this.fHb != null && (duration = PushDialogVideoView.this.fHb.getDuration()) > 0 && PushDialogVideoView.this.lAo != null) {
                    PushDialogVideoView.this.lAo.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fso = 50;
        this.mSkinType = 3;
        this.ZM = false;
        this.mStartPosition = 0;
        this.lAO = true;
        this.lAP = false;
        this.lAQ = false;
        this.ldr = false;
        this.dNO = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.feY.dnH();
            }
        };
        this.hqE = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.ceU();
            }
        };
        this.ZS = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fHb.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.ZM = true;
                    PushDialogVideoView.this.jYu.setVisibility(8);
                    PushDialogVideoView.this.hts.setVisibility(8);
                    PushDialogVideoView.this.feY.dnI();
                    PushDialogVideoView.this.alq.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mX().postDelayed(PushDialogVideoView.this.ZS, 20L);
            }
        };
        this.dNQ = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.ZM = false;
                PushDialogVideoView.this.lAV = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.jYu.setVisibility(0);
                PushDialogVideoView.this.lAo.setVisibility(8);
                PushDialogVideoView.this.lAo.setProgress(PushDialogVideoView.this.lAo.getMax());
                if (PushDialogVideoView.this.fHb == null || PushDialogVideoView.this.fHb.getDuration() > 150000) {
                    PushDialogVideoView.this.vg(false);
                } else {
                    PushDialogVideoView.this.lAr.setVisibility(0);
                }
                n.dnN().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.fHb != null && PushDialogVideoView.this.fHb.getDuration() <= 150000) {
                    PushDialogVideoView.this.fK(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alA);
                }
            }
        };
        this.jZc = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.hts.setVisibility(0);
                PushDialogVideoView.this.feY.dnJ();
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.lAT = true;
                }
                PushDialogVideoView.this.lAV = false;
                return true;
            }
        };
        this.jZd = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.hts.setVisibility(0);
                PushDialogVideoView.this.feY.dnJ();
            }
        };
        this.dNT = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.lAP) {
                    e.mX().postDelayed(PushDialogVideoView.this.lBb, 200L);
                }
            }
        };
        this.lBb = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.fHb == null || !PushDialogVideoView.this.lAP) {
                    e.mX().postDelayed(PushDialogVideoView.this.ZS, 200L);
                    PushDialogVideoView.this.lAP = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.fHb.getCurrentPosition()) {
                    PushDialogVideoView.this.lAP = false;
                    e.mX().postDelayed(PushDialogVideoView.this.ZS, 20L);
                } else {
                    e.mX().postDelayed(PushDialogVideoView.this.lBb, 200L);
                }
            }
        };
        this.ffg = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.ZM = false;
                PushDialogVideoView.this.lAV = false;
                e.mX().removeCallbacks(PushDialogVideoView.this.ZS);
                e.mX().removeCallbacks(PushDialogVideoView.this.jZd);
            }
        };
        this.jZi = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aII();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.fHb != null && PushDialogVideoView.this.fHb.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.fHb.getCurrentPosition();
                            int duration = PushDialogVideoView.this.fHb.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kbc != null) {
                                PushDialogVideoView.this.kbc.sw(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fso - (duration % PushDialogVideoView.this.fso));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kbc = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void sw(int i2) {
                int duration;
                if (PushDialogVideoView.this.fHb != null && (duration = PushDialogVideoView.this.fHb.getDuration()) > 0 && PushDialogVideoView.this.lAo != null) {
                    PushDialogVideoView.this.lAo.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.fHb = (TbCyberVideoView) findViewById(R.id.videoView);
        this.fHb.setPlayMode("2");
        this.fHb.setStageType(null);
        this.feY = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.feY.setLoadingAnimationListener(this.hqE);
        this.lAo = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.lAo.setMax(this.mWidth);
        this.lAo.setProgress(0);
        this.jYu = findViewById(R.id.black_mask);
        this.hts = findViewById(R.id.layout_error);
        this.jYD = (ImageView) findViewById(R.id.img_play);
        this.lAr = (TextView) findViewById(R.id.txt_replay);
        this.gWv = (TextView) findViewById(R.id.push_dialog_video_time);
        this.alq = (TbImageView) findViewById(R.id.video_thumbnail);
        this.ldC = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.alq.setDefaultErrorResource(0);
        this.alq.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.jYZ = new CallStateReceiver();
        this.jYZ.register(context);
        this.hts.setOnClickListener(this);
        this.lAr.setOnClickListener(this);
        this.ldC.setOnPlayClickListener(this);
        this.ldC.setFreeClickListener(this);
        setOnClickListener(this);
        this.fHb.setOnPreparedListener(this.dNO);
        this.fHb.setOnCompletionListener(this.dNQ);
        this.fHb.setOnErrorListener(this.jZc);
        this.fHb.setOnSeekCompleteListener(this.dNT);
        this.fHb.setOnSurfaceDestroyedListener(this.ffg);
        onChangeSkinType();
    }

    public void onPause() {
        if (rK()) {
            this.ldr = true;
            aII();
            return;
        }
        this.ldr = false;
        aII();
    }

    public void onResume() {
        if (this.ldr) {
            aIJ();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.jZi);
    }

    public void setTbRichTextVideoInfo(j jVar) {
        this.lHy = jVar;
        this.gWv.setText(at.stringForVideoTime(this.lHy.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alA = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.fHb.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        if (this.fHb != null) {
            if (this.lAV) {
                this.fHb.start();
                this.lAV = false;
            }
            e.mX().removeCallbacks(this.ZS);
            e.mX().postDelayed(this.ZS, 20L);
            e.mX().removeCallbacks(this.jZd);
            this.mStartPosition = n.dnN().Pg(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.fHb.seekTo(this.mStartPosition);
                if (!this.lAU) {
                    showProgress();
                    e.mX().removeCallbacks(this.ZS);
                }
                this.lAP = true;
            }
        }
    }

    public void dhc() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.fHb.isPlaying()) {
            aII();
        } else if (this.ZM) {
            aIJ();
        } else {
            dnk();
        }
    }

    public void setPauseState() {
        this.feY.dnJ();
        this.jYD.setVisibility(0);
        this.lAr.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.lAQ) {
            fL(str, str2);
        } else {
            fK(str, str2);
        }
        if (aVar != null) {
            aVar.vl(z);
        }
    }

    public void fK(String str, String str2) {
        dnl();
        this.lAV = true;
        setVideoUrl(str, str2);
        this.fHb.setVideoPath(str, str2);
        this.feY.startLoading();
        this.alq.setVisibility(0);
        this.jYD.setVisibility(8);
        this.lAr.setVisibility(8);
        this.hts.setVisibility(8);
        e.mX().removeCallbacks(this.jZd);
        e.mX().postDelayed(this.jZd, 60000L);
    }

    public void fL(String str, String str2) {
        dnl();
        this.lAV = true;
        this.feY.startLoading();
        this.alq.setVisibility(0);
        this.jYD.setVisibility(8);
        this.lAr.setVisibility(8);
        this.hts.setVisibility(8);
        e.mX().removeCallbacks(this.jZd);
        e.mX().postDelayed(this.jZd, 60000L);
    }

    public void aIJ() {
        this.fHb.start();
        this.alq.setVisibility(8);
        this.jYu.setVisibility(8);
        this.feY.dnJ();
        showProgress();
        this.jYD.setVisibility(8);
        this.lAr.setVisibility(8);
    }

    public void setNetworkChange() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable() && this.lAT && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alA)) {
            this.lAT = false;
            this.lAU = true;
            fK(this.mVideoUrl, this.alA);
        }
    }

    public void aII() {
        if (this.fHb.isPlaying() && this.lAO) {
            dnj();
        }
        this.fHb.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.fHb.isPlaying() && this.lAO) {
            dnj();
        }
        e.mX().removeCallbacks(this.ZS);
        e.mX().removeCallbacks(this.jZd);
        this.fHb.stopPlayback();
        this.ZM = false;
        this.lAV = false;
        this.mStartPosition = 0;
        cDc();
    }

    public void dnj() {
        n.dnN().by(this.mVideoUrl, this.fHb.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg(boolean z) {
        this.jYu.setVisibility(0);
        this.jYD.setVisibility(0);
        this.lAr.setVisibility(8);
        this.feY.dnJ();
        this.lAo.setVisibility(8);
        this.hts.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.alq.setVisibility(z ? 0 : 8);
    }

    public void cDc() {
        vg(true);
    }

    public boolean rK() {
        if (this.fHb == null) {
            return false;
        }
        return this.fHb.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.fHb == null) {
            return 0;
        }
        return this.fHb.getCurrentPosition();
    }

    public void showProgress() {
        if (this.fHb != null) {
            this.lAo.setVisibility(0);
            this.fso = ((this.fHb.getDuration() / 200) / 50) * 50;
            if (this.fso < 50) {
                this.fso = 50;
            } else if (this.fso > 500) {
                this.fso = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fso - (this.fHb.getCurrentPosition() % this.fso));
        }
    }

    private void dnk() {
        a(this.mVideoUrl, this.alA, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dnl();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.lAQ = ((Boolean) objArr[0]).booleanValue();
        }
        if (com.baidu.adp.lib.util.j.isMobileNet() && !this.ldL && !g.dEY().dEZ()) {
            this.ldC.setVisibility(0);
            this.ldC.setData(this.lHy.getDuration(), this.lHy.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dnl() {
        if (com.baidu.adp.lib.util.j.isMobileNet()) {
            g.dEY().fO(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.alq.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hts) {
            dnk();
        } else if (view == this) {
            TiebaStatic.log(new aq("c13199").ai("obj_locate", 2).dF("tid", this.alA));
            dhc();
        } else if (view == this.lAr) {
            fK(this.mVideoUrl, this.alA);
        } else if (view == this.ldC.getTvPlay()) {
            this.ldL = true;
            this.ldC.setVisibility(8);
            fK(this.mVideoUrl, this.alA);
        } else if (view == this.ldC.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mX().removeCallbacks(this.ZS);
        e.mX().removeCallbacks(this.jZd);
        e.mX().removeCallbacks(this.lBb);
        this.mHandler.removeMessages(1);
        this.jYZ.unregister(getContext());
    }
}
