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
import com.baidu.tieba.video.g;
/* loaded from: classes20.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    private boolean aaj;
    private Runnable aap;
    private TbImageView alP;
    private String alZ;
    private CyberPlayerManager.OnSeekCompleteListener emB;
    private CyberPlayerManager.OnPreparedListener emw;
    private CyberPlayerManager.OnCompletionListener emy;
    private m fFc;
    private TbCyberVideoView.a fFk;
    private int fSr;
    private TbCyberVideoView giK;
    private TextView hCR;
    private VideoLoadingProgressView.a hYs;
    private View ibi;
    private CallStateReceiver kGU;
    private CyberPlayerManager.OnErrorListener kGX;
    private Runnable kGY;
    private View kGq;
    private ImageView kGz;
    private CustomMessageListener kHd;
    private VideoControllerView.b kIW;
    private PbVideoWifiTipLayout lLG;
    private boolean lLP;
    private boolean lLv;
    private Handler mHandler;
    private int mHeight;
    private TbPageContext<?> mPageContext;
    private int mSkinType;
    private int mStartPosition;
    private String mVideoUrl;
    private int mWidth;
    private boolean miT;
    private boolean miU;
    private boolean miV;
    private boolean miY;
    private boolean miZ;
    private ProgressBar mit;
    private TextView miw;
    private boolean mja;
    private Runnable mjg;
    private i mpE;

    /* loaded from: classes20.dex */
    public interface a {
        void wv(boolean z);
    }

    public PushDialogVideoView(Context context) {
        super(context);
        this.fSr = 50;
        this.mSkinType = 3;
        this.aaj = false;
        this.mStartPosition = 0;
        this.miT = true;
        this.miU = false;
        this.miV = false;
        this.lLv = false;
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fFc.dwB();
            }
        };
        this.hYs = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cnA();
            }
        };
        this.aap = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.giK.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aaj = true;
                    PushDialogVideoView.this.kGq.setVisibility(8);
                    PushDialogVideoView.this.ibi.setVisibility(8);
                    PushDialogVideoView.this.fFc.dwC();
                    PushDialogVideoView.this.alP.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aap, 20L);
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aaj = false;
                PushDialogVideoView.this.mja = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kGq.setVisibility(0);
                PushDialogVideoView.this.mit.setVisibility(8);
                PushDialogVideoView.this.mit.setProgress(PushDialogVideoView.this.mit.getMax());
                if (PushDialogVideoView.this.giK == null || PushDialogVideoView.this.giK.getDuration() > 150000) {
                    PushDialogVideoView.this.wq(false);
                } else {
                    PushDialogVideoView.this.miw.setVisibility(0);
                }
                n.dwH().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.giK != null && PushDialogVideoView.this.giK.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alZ);
                }
            }
        };
        this.kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.ibi.setVisibility(0);
                PushDialogVideoView.this.fFc.dwD();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.miY = true;
                }
                PushDialogVideoView.this.mja = false;
                return true;
            }
        };
        this.kGY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ibi.setVisibility(0);
                PushDialogVideoView.this.fFc.dwD();
            }
        };
        this.emB = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.miU) {
                    e.mY().postDelayed(PushDialogVideoView.this.mjg, 200L);
                }
            }
        };
        this.mjg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.giK == null || !PushDialogVideoView.this.miU) {
                    e.mY().postDelayed(PushDialogVideoView.this.aap, 200L);
                    PushDialogVideoView.this.miU = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.giK.getCurrentPosition()) {
                    PushDialogVideoView.this.miU = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aap, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mjg, 200L);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aaj = false;
                PushDialogVideoView.this.mja = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aap);
                e.mY().removeCallbacks(PushDialogVideoView.this.kGY);
            }
        };
        this.kHd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aPd();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.giK != null && PushDialogVideoView.this.giK.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.giK.getCurrentPosition();
                            int duration = PushDialogVideoView.this.giK.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kIW != null) {
                                PushDialogVideoView.this.kIW.tN(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fSr - (duration % PushDialogVideoView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIW = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tN(int i) {
                int duration;
                if (PushDialogVideoView.this.giK != null && (duration = PushDialogVideoView.this.giK.getDuration()) > 0 && PushDialogVideoView.this.mit != null) {
                    PushDialogVideoView.this.mit.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fSr = 50;
        this.mSkinType = 3;
        this.aaj = false;
        this.mStartPosition = 0;
        this.miT = true;
        this.miU = false;
        this.miV = false;
        this.lLv = false;
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fFc.dwB();
            }
        };
        this.hYs = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cnA();
            }
        };
        this.aap = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.giK.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aaj = true;
                    PushDialogVideoView.this.kGq.setVisibility(8);
                    PushDialogVideoView.this.ibi.setVisibility(8);
                    PushDialogVideoView.this.fFc.dwC();
                    PushDialogVideoView.this.alP.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aap, 20L);
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aaj = false;
                PushDialogVideoView.this.mja = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kGq.setVisibility(0);
                PushDialogVideoView.this.mit.setVisibility(8);
                PushDialogVideoView.this.mit.setProgress(PushDialogVideoView.this.mit.getMax());
                if (PushDialogVideoView.this.giK == null || PushDialogVideoView.this.giK.getDuration() > 150000) {
                    PushDialogVideoView.this.wq(false);
                } else {
                    PushDialogVideoView.this.miw.setVisibility(0);
                }
                n.dwH().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.giK != null && PushDialogVideoView.this.giK.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alZ);
                }
            }
        };
        this.kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i, int i2, Object obj) {
                PushDialogVideoView.this.ibi.setVisibility(0);
                PushDialogVideoView.this.fFc.dwD();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.miY = true;
                }
                PushDialogVideoView.this.mja = false;
                return true;
            }
        };
        this.kGY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ibi.setVisibility(0);
                PushDialogVideoView.this.fFc.dwD();
            }
        };
        this.emB = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.miU) {
                    e.mY().postDelayed(PushDialogVideoView.this.mjg, 200L);
                }
            }
        };
        this.mjg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.giK == null || !PushDialogVideoView.this.miU) {
                    e.mY().postDelayed(PushDialogVideoView.this.aap, 200L);
                    PushDialogVideoView.this.miU = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.giK.getCurrentPosition()) {
                    PushDialogVideoView.this.miU = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aap, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mjg, 200L);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aaj = false;
                PushDialogVideoView.this.mja = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aap);
                e.mY().removeCallbacks(PushDialogVideoView.this.kGY);
            }
        };
        this.kHd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aPd();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.giK != null && PushDialogVideoView.this.giK.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.giK.getCurrentPosition();
                            int duration = PushDialogVideoView.this.giK.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kIW != null) {
                                PushDialogVideoView.this.kIW.tN(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fSr - (duration % PushDialogVideoView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIW = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tN(int i) {
                int duration;
                if (PushDialogVideoView.this.giK != null && (duration = PushDialogVideoView.this.giK.getDuration()) > 0 && PushDialogVideoView.this.mit != null) {
                    PushDialogVideoView.this.mit.setProgress((int) ((i * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fSr = 50;
        this.mSkinType = 3;
        this.aaj = false;
        this.mStartPosition = 0;
        this.miT = true;
        this.miU = false;
        this.miV = false;
        this.lLv = false;
        this.emw = new CyberPlayerManager.OnPreparedListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.1
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                PushDialogVideoView.this.fFc.dwB();
            }
        };
        this.hYs = new VideoLoadingProgressView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.5
            @Override // com.baidu.tieba.play.VideoLoadingProgressView.a
            public void onAnimationEnd() {
                PushDialogVideoView.this.cnA();
            }
        };
        this.aap = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.giK.getCurrentPosition() > 100) {
                    PushDialogVideoView.this.aaj = true;
                    PushDialogVideoView.this.kGq.setVisibility(8);
                    PushDialogVideoView.this.ibi.setVisibility(8);
                    PushDialogVideoView.this.fFc.dwC();
                    PushDialogVideoView.this.alP.setVisibility(8);
                    PushDialogVideoView.this.showProgress();
                    return;
                }
                e.mY().postDelayed(PushDialogVideoView.this.aap, 20L);
            }
        };
        this.emy = new CyberPlayerManager.OnCompletionListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.7
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                PushDialogVideoView.this.aaj = false;
                PushDialogVideoView.this.mja = false;
                PushDialogVideoView.this.mStartPosition = 0;
                PushDialogVideoView.this.kGq.setVisibility(0);
                PushDialogVideoView.this.mit.setVisibility(8);
                PushDialogVideoView.this.mit.setProgress(PushDialogVideoView.this.mit.getMax());
                if (PushDialogVideoView.this.giK == null || PushDialogVideoView.this.giK.getDuration() > 150000) {
                    PushDialogVideoView.this.wq(false);
                } else {
                    PushDialogVideoView.this.miw.setVisibility(0);
                }
                n.dwH().remove(PushDialogVideoView.this.mVideoUrl);
                if (PushDialogVideoView.this.giK != null && PushDialogVideoView.this.giK.getDuration() <= 150000) {
                    PushDialogVideoView.this.fW(PushDialogVideoView.this.mVideoUrl, PushDialogVideoView.this.alZ);
                }
            }
        };
        this.kGX = new CyberPlayerManager.OnErrorListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.8
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i2, int i22, Object obj) {
                PushDialogVideoView.this.ibi.setVisibility(0);
                PushDialogVideoView.this.fFc.dwD();
                if (!j.isNetWorkAvailable()) {
                    PushDialogVideoView.this.miY = true;
                }
                PushDialogVideoView.this.mja = false;
                return true;
            }
        };
        this.kGY = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                PushDialogVideoView.this.ibi.setVisibility(0);
                PushDialogVideoView.this.fFc.dwD();
            }
        };
        this.emB = new CyberPlayerManager.OnSeekCompleteListener() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.10
            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PushDialogVideoView.this.miU) {
                    e.mY().postDelayed(PushDialogVideoView.this.mjg, 200L);
                }
            }
        };
        this.mjg = new Runnable() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                if (PushDialogVideoView.this.giK == null || !PushDialogVideoView.this.miU) {
                    e.mY().postDelayed(PushDialogVideoView.this.aap, 200L);
                    PushDialogVideoView.this.miU = false;
                } else if (PushDialogVideoView.this.mStartPosition != PushDialogVideoView.this.giK.getCurrentPosition()) {
                    PushDialogVideoView.this.miU = false;
                    e.mY().postDelayed(PushDialogVideoView.this.aap, 20L);
                } else {
                    e.mY().postDelayed(PushDialogVideoView.this.mjg, 200L);
                }
            }
        };
        this.fFk = new TbCyberVideoView.a() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.12
            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
            public void onSurfaceDestroyed() {
                PushDialogVideoView.this.aaj = false;
                PushDialogVideoView.this.mja = false;
                e.mY().removeCallbacks(PushDialogVideoView.this.aap);
                e.mY().removeCallbacks(PushDialogVideoView.this.kGY);
            }
        };
        this.kHd = new CustomMessageListener(CmdConfigCustom.CMD_CALL_STATE_CHANGED) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if ((customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                    PushDialogVideoView.this.aPd();
                }
            }
        };
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        if (PushDialogVideoView.this.giK != null && PushDialogVideoView.this.giK.isPlaying()) {
                            int currentPosition = PushDialogVideoView.this.giK.getCurrentPosition();
                            int duration = PushDialogVideoView.this.giK.getDuration();
                            if (currentPosition <= duration) {
                                duration = currentPosition;
                            }
                            if (PushDialogVideoView.this.kIW != null) {
                                PushDialogVideoView.this.kIW.tN(duration);
                            }
                            sendMessageDelayed(obtainMessage(1), PushDialogVideoView.this.fSr - (duration % PushDialogVideoView.this.fSr));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIW = new VideoControllerView.b() { // from class: com.baidu.tieba.pushdialog.PushDialogVideoView.4
            @Override // com.baidu.tieba.play.VideoControllerView.b
            public void tN(int i2) {
                int duration;
                if (PushDialogVideoView.this.giK != null && (duration = PushDialogVideoView.this.giK.getDuration()) > 0 && PushDialogVideoView.this.mit != null) {
                    PushDialogVideoView.this.mit.setProgress((int) ((i2 * PushDialogVideoView.this.getWidth()) / duration));
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
        this.mWidth = l.getEquipmentWidth(context) - l.getDimens(context, R.dimen.tbds132);
        this.mHeight = (int) (this.mWidth * 0.5625f);
        this.giK = (TbCyberVideoView) findViewById(R.id.videoView);
        this.giK.setPlayMode("2");
        this.giK.setStageType(null);
        this.fFc = new m((ViewGroup) findViewById(R.id.auto_video_loading_container));
        this.fFc.setLoadingAnimationListener(this.hYs);
        this.mit = (ProgressBar) findViewById(R.id.pgrBottomProgress);
        this.mit.setMax(this.mWidth);
        this.mit.setProgress(0);
        this.kGq = findViewById(R.id.black_mask);
        this.ibi = findViewById(R.id.layout_error);
        this.kGz = (ImageView) findViewById(R.id.img_play);
        this.miw = (TextView) findViewById(R.id.txt_replay);
        this.hCR = (TextView) findViewById(R.id.push_dialog_video_time);
        this.alP = (TbImageView) findViewById(R.id.video_thumbnail);
        this.lLG = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
        this.alP.setDefaultErrorResource(0);
        this.alP.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.kGU = new CallStateReceiver();
        this.kGU.register(context);
        this.ibi.setOnClickListener(this);
        this.miw.setOnClickListener(this);
        this.lLG.setOnPlayClickListener(this);
        this.lLG.setFreeClickListener(this);
        setOnClickListener(this);
        this.giK.setOnPreparedListener(this.emw);
        this.giK.setOnCompletionListener(this.emy);
        this.giK.setOnErrorListener(this.kGX);
        this.giK.setOnSeekCompleteListener(this.emB);
        this.giK.setOnSurfaceDestroyedListener(this.fFk);
        onChangeSkinType();
    }

    public void onPause() {
        if (rK()) {
            this.lLv = true;
            aPd();
            return;
        }
        this.lLv = false;
        aPd();
    }

    public void onResume() {
        if (this.lLv) {
            aPe();
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mPageContext.registerListener(this.kHd);
    }

    public void setTbRichTextVideoInfo(i iVar) {
        this.mpE = iVar;
        this.hCR.setText(au.stringForVideoTime(this.mpE.getDuration() * 1000));
    }

    public void setVideoUrl(String str, String str2) {
        this.mVideoUrl = str;
        this.alZ = str2;
    }

    public void setVideoViewBusiness(o oVar) {
        this.giK.setVideoStatData(oVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnA() {
        if (this.giK != null) {
            if (this.mja) {
                this.giK.start();
                this.mja = false;
            }
            e.mY().removeCallbacks(this.aap);
            e.mY().postDelayed(this.aap, 20L);
            e.mY().removeCallbacks(this.kGY);
            this.mStartPosition = n.dwH().Qf(this.mVideoUrl);
            if (this.mStartPosition != 0) {
                this.giK.seekTo(this.mStartPosition);
                if (!this.miZ) {
                    showProgress();
                    e.mY().removeCallbacks(this.aap);
                }
                this.miU = true;
            }
        }
    }

    public void dpV() {
        if (!j.isNetWorkAvailable()) {
            l.showLongToast(getContext(), getContext().getString(R.string.neterror));
        } else if (this.giK.isPlaying()) {
            aPd();
        } else if (this.aaj) {
            aPe();
        } else {
            dwf();
        }
    }

    public void setPauseState() {
        this.fFc.dwD();
        this.kGz.setVisibility(0);
        this.miw.setVisibility(8);
    }

    private void a(a aVar, boolean z, String str, String str2) {
        if (this.miV) {
            fX(str, str2);
        } else {
            fW(str, str2);
        }
        if (aVar != null) {
            aVar.wv(z);
        }
    }

    public void fW(String str, String str2) {
        dwg();
        this.mja = true;
        setVideoUrl(str, str2);
        this.giK.setVideoPath(str, str2);
        this.fFc.startLoading();
        this.alP.setVisibility(0);
        this.kGz.setVisibility(8);
        this.miw.setVisibility(8);
        this.ibi.setVisibility(8);
        e.mY().removeCallbacks(this.kGY);
        e.mY().postDelayed(this.kGY, 60000L);
    }

    public void fX(String str, String str2) {
        dwg();
        this.mja = true;
        this.fFc.startLoading();
        this.alP.setVisibility(0);
        this.kGz.setVisibility(8);
        this.miw.setVisibility(8);
        this.ibi.setVisibility(8);
        e.mY().removeCallbacks(this.kGY);
        e.mY().postDelayed(this.kGY, 60000L);
    }

    public void aPe() {
        this.giK.start();
        this.alP.setVisibility(8);
        this.kGq.setVisibility(8);
        this.fFc.dwD();
        showProgress();
        this.kGz.setVisibility(8);
        this.miw.setVisibility(8);
    }

    public void setNetworkChange() {
        if (j.isNetWorkAvailable() && this.miY && !StringUtils.isNull(this.mVideoUrl) && !StringUtils.isNull(this.alZ)) {
            this.miY = false;
            this.miZ = true;
            fW(this.mVideoUrl, this.alZ);
        }
    }

    public void aPd() {
        if (this.giK.isPlaying() && this.miT) {
            dwe();
        }
        this.giK.pause();
        setPauseState();
    }

    public void stopPlay() {
        if (this.giK.isPlaying() && this.miT) {
            dwe();
        }
        e.mY().removeCallbacks(this.aap);
        e.mY().removeCallbacks(this.kGY);
        this.giK.stopPlayback();
        this.aaj = false;
        this.mja = false;
        this.mStartPosition = 0;
        cMa();
    }

    public void dwe() {
        n.dwH().bB(this.mVideoUrl, this.giK.getCurrentPositionSync());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wq(boolean z) {
        this.kGq.setVisibility(0);
        this.kGz.setVisibility(0);
        this.miw.setVisibility(8);
        this.fFc.dwD();
        this.mit.setVisibility(8);
        this.ibi.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.alP.setVisibility(z ? 0 : 8);
    }

    public void cMa() {
        wq(true);
    }

    public boolean rK() {
        if (this.giK == null) {
            return false;
        }
        return this.giK.isPlaying();
    }

    public int getCurrentPosition() {
        if (this.giK == null) {
            return 0;
        }
        return this.giK.getCurrentPosition();
    }

    public void showProgress() {
        if (this.giK != null) {
            this.mit.setVisibility(0);
            this.fSr = ((this.giK.getDuration() / 200) / 50) * 50;
            if (this.fSr < 50) {
                this.fSr = 50;
            } else if (this.fSr > 500) {
                this.fSr = 500;
            }
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), this.fSr - (this.giK.getCurrentPosition() % this.fSr));
        }
    }

    private void dwf() {
        a(this.mVideoUrl, this.alZ, (a) null, new Object[0]);
    }

    public void a(String str, String str2, a aVar, Object... objArr) {
        dwg();
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
            this.miV = ((Boolean) objArr[0]).booleanValue();
        }
        if (j.isMobileNet() && !this.lLP && !g.dOt().dOu()) {
            this.lLG.setVisibility(0);
            this.lLG.setData(this.mpE.getDuration(), this.mpE.getFileSize());
            return;
        }
        a(aVar, true, str, str2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
    }

    private void dwg() {
        if (j.isMobileNet()) {
            g.dOt().fV(getContext());
        }
    }

    public void setThumbnail(String str) {
        this.alP.startLoad(str, 17, false);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ibi) {
            dwf();
        } else if (view == this) {
            TiebaStatic.log(new ar("c13199").ak("obj_locate", 2).dR("tid", this.alZ));
            dpV();
        } else if (view == this.miw) {
            fW(this.mVideoUrl, this.alZ);
        } else if (view == this.lLG.getTvPlay()) {
            this.lLP = true;
            this.lLG.setVisibility(8);
            fW(this.mVideoUrl, this.alZ);
        } else if (view == this.lLG.getTvOpenFreeData() && this.mPageContext != null) {
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
        e.mY().removeCallbacks(this.aap);
        e.mY().removeCallbacks(this.kGY);
        e.mY().removeCallbacks(this.mjg);
        this.mHandler.removeMessages(1);
        this.kGU.unregister(getContext());
    }
}
