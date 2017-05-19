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
    private static w eSy;
    private Map<String, String> AN;
    private v.a aRc;
    private v.d aRd;
    private v.b aRe;
    private v.c aRf;
    private b aTQ;
    private a eSA;
    private boolean eSB;
    private int eSC;
    private boolean eSD;
    private int eSE;
    private boolean eSF;
    private SurfaceTexture eSG;
    private TextureView.SurfaceTextureListener eSH;
    private v.d eSI;
    private v.a eSJ;
    private v.b eSK;
    private an eSw;
    private v eSx;
    private boolean eSz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void Jl();

        void Jm();

        String aWx();

        y aWy();

        String gU(String str);

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
            eSy = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eSz = false;
        this.eSB = false;
        this.eSC = 0;
        this.eSD = false;
        this.eSE = -1;
        this.eSF = false;
        this.eSG = null;
        this.eSH = new ae(this);
        this.eSI = new af(this);
        this.eSJ = new ag(this);
        this.eSK = new ah(this);
        this.aRf = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSz = false;
        this.eSB = false;
        this.eSC = 0;
        this.eSD = false;
        this.eSE = -1;
        this.eSF = false;
        this.eSG = null;
        this.eSH = new ae(this);
        this.eSI = new af(this);
        this.eSJ = new ag(this);
        this.eSK = new ah(this);
        this.aRf = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSz = false;
        this.eSB = false;
        this.eSC = 0;
        this.eSD = false;
        this.eSE = -1;
        this.eSF = false;
        this.eSG = null;
        this.eSH = new ae(this);
        this.eSI = new af(this);
        this.eSJ = new ag(this);
        this.eSK = new ah(this);
        this.aRf = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eSw = new an(context);
        this.eSw.setSurfaceTextureListener(this.eSH);
        if (eSy != null) {
            this.eSx = eSy.Ju();
        }
        if (this.eSx != null) {
            this.eSx.setOnPreparedListener(this.eSI);
            this.eSx.setOnCompletionListener(this.eSJ);
            this.eSx.setOnErrorListener(this.eSK);
            this.eSx.a(this.aRf);
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
        if (this.eSA != null) {
            str = this.eSA.gU(str);
            if (this.eSA.aWy() != null) {
                this.eSA.aWy().setPlayer(this);
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
        aWv();
        this.eSB = true;
        this.mUri = uri;
        this.AN = map;
        this.eSC = 0;
        removeView(this.eSw);
        addView(this.eSw, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_k);
    }

    private void aWv() {
        this.eSB = false;
        this.eSz = false;
        if (this.eSx != null) {
            this.eSx.release();
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
        aWv();
        this.eSD = false;
        if (this.eSA != null) {
            this.eSA.onStop();
        }
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aRd = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aRc = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aRe = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eSz = true;
        if (this.eSx != null) {
            if (this.eSG != null && this.eSF && !this.eSx.Jk()) {
                this.eSx.a(this.mContext, this.mUri, this.AN, this.eSG, this.eSE);
                return;
            } else {
                this.eSx.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.eSA != null) {
            this.eSA.onStart();
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
        if (this.eSx != null) {
            this.eSx.pause();
        }
        if (this.eSA != null) {
            this.eSA.onPause();
        }
        this.eSz = false;
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
        if (this.eSx != null) {
            return this.eSx.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eSx != null) {
            return this.eSx.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eSx != null) {
            this.eSx.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eSx != null) {
            return this.eSx.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.eSx != null) {
            this.eSx.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.eSE = i;
    }

    public int getRecoveryState() {
        return this.eSE;
    }

    public void setNeedRecovery(boolean z) {
        this.eSF = z;
    }

    public void setLooping(boolean z) {
        this.eSD = z;
    }

    public boolean aWw() {
        return this.eSz;
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
        this.aTQ = bVar;
    }

    public void setBusiness(a aVar) {
        this.eSA = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eSD = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.eSx;
    }
}
