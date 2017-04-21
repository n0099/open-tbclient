package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.play.v;
import com.baidu.tieba.w;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static w eWy;
    private Map<String, String> AN;
    private v.a aQJ;
    private v.d aQK;
    private v.b aQL;
    private v.c aQM;
    private b aTv;
    private a eWA;
    private boolean eWB;
    private int eWC;
    private boolean eWD;
    private int eWE;
    private boolean eWF;
    private SurfaceTexture eWG;
    private TextureView.SurfaceTextureListener eWH;
    private v.d eWI;
    private v.a eWJ;
    private v.b eWK;
    private an eWw;
    private v eWx;
    private boolean eWz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void JX();

        void JY();

        String aYY();

        y aYZ();

        String gW(String str);

        void onPause();

        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, w.class);
        if (runTask != null) {
            eWy = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eWz = false;
        this.eWB = false;
        this.eWC = 0;
        this.eWD = false;
        this.eWE = -1;
        this.eWF = false;
        this.eWG = null;
        this.eWH = new ae(this);
        this.eWI = new af(this);
        this.eWJ = new ag(this);
        this.eWK = new ah(this);
        this.aQM = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWz = false;
        this.eWB = false;
        this.eWC = 0;
        this.eWD = false;
        this.eWE = -1;
        this.eWF = false;
        this.eWG = null;
        this.eWH = new ae(this);
        this.eWI = new af(this);
        this.eWJ = new ag(this);
        this.eWK = new ah(this);
        this.aQM = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWz = false;
        this.eWB = false;
        this.eWC = 0;
        this.eWD = false;
        this.eWE = -1;
        this.eWF = false;
        this.eWG = null;
        this.eWH = new ae(this);
        this.eWI = new af(this);
        this.eWJ = new ag(this);
        this.eWK = new ah(this);
        this.aQM = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eWw = new an(context);
        this.eWw.setSurfaceTextureListener(this.eWH);
        if (eWy != null) {
            this.eWx = eWy.Kg();
        }
        if (this.eWx != null) {
            this.eWx.setOnPreparedListener(this.eWI);
            this.eWx.setOnCompletionListener(this.eWJ);
            this.eWx.setOnErrorListener(this.eWK);
            this.eWx.a(this.aQM);
        }
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_k);
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                this.mWakeLock = powerManager.newWakeLock(10, "QuickVideoView_WakeLock");
                this.mWakeLock.setReferenceCounted(false);
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void setVideoPath(String str) {
        if (this.eWA != null) {
            str = this.eWA.gW(str);
            if (this.eWA.aYZ() != null) {
                this.eWA.aYZ().setPlayer(this);
            }
        }
        if (!com.baidu.tbadk.core.util.au.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        aYW();
        this.eWB = true;
        this.mUri = uri;
        this.AN = map;
        this.eWC = 0;
        removeView(this.eWw);
        addView(this.eWw, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_k);
    }

    private void aYW() {
        this.eWB = false;
        this.eWz = false;
        if (this.eWx != null) {
            this.eWx.release();
        }
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public void stopPlayback() {
        aYW();
        this.eWD = false;
        if (this.eWA != null) {
            this.eWA.onStop();
        }
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aQK = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aQJ = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aQL = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eWz = true;
        if (this.eWx != null) {
            if (this.eWG != null && this.eWF && !this.eWx.JW()) {
                this.eWx.a(this.mContext, this.mUri, this.AN, this.eWG, this.eWE);
                return;
            } else {
                this.eWx.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.eWA != null) {
            this.eWA.onStart();
        }
        try {
            if (this.mWakeLock != null && !this.mWakeLock.isHeld()) {
                this.mWakeLock.acquire();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.eWx != null) {
            this.eWx.pause();
        }
        if (this.eWA != null) {
            this.eWA.onPause();
        }
        this.eWz = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.eWx != null) {
            return this.eWx.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eWx != null) {
            return this.eWx.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eWx != null) {
            this.eWx.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eWx != null) {
            return this.eWx.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.eWx != null) {
            this.eWx.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.eWE = i;
    }

    public int getRecoveryState() {
        return this.eWE;
    }

    public void setNeedRecovery(boolean z) {
        this.eWF = z;
    }

    public void setLooping(boolean z) {
        this.eWD = z;
    }

    public boolean aYX() {
        return this.eWz;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return false;
    }

    public void setOnSurfaceDestroyedListener(b bVar) {
        this.aTv = bVar;
    }

    public void setBusiness(a aVar) {
        this.eWA = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eWD = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.eWx;
    }
}
