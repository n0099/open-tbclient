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
import com.baidu.tieba.r;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static w eSC;
    private v.a aKG;
    private v.d aKH;
    private v.b aKI;
    private v.c aKJ;
    private b aNr;
    private an eSA;
    private v eSB;
    private boolean eSD;
    private a eSE;
    private boolean eSF;
    private int eSG;
    private boolean eSH;
    private int eSI;
    private boolean eSJ;
    private SurfaceTexture eSK;
    private TextureView.SurfaceTextureListener eSL;
    private v.d eSM;
    private v.a eSN;
    private v.b eSO;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;
    private Map<String, String> tU;

    /* loaded from: classes.dex */
    public interface a {
        void IS();

        String aYj();

        y aYk();

        String hd(String str);

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
            eSC = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eSD = false;
        this.eSF = false;
        this.eSG = 0;
        this.eSH = false;
        this.eSI = -1;
        this.eSJ = false;
        this.eSK = null;
        this.eSL = new ae(this);
        this.eSM = new af(this);
        this.eSN = new ag(this);
        this.eSO = new ah(this);
        this.aKJ = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eSD = false;
        this.eSF = false;
        this.eSG = 0;
        this.eSH = false;
        this.eSI = -1;
        this.eSJ = false;
        this.eSK = null;
        this.eSL = new ae(this);
        this.eSM = new af(this);
        this.eSN = new ag(this);
        this.eSO = new ah(this);
        this.aKJ = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eSD = false;
        this.eSF = false;
        this.eSG = 0;
        this.eSH = false;
        this.eSI = -1;
        this.eSJ = false;
        this.eSK = null;
        this.eSL = new ae(this);
        this.eSM = new af(this);
        this.eSN = new ag(this);
        this.eSO = new ah(this);
        this.aKJ = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eSA = new an(context);
        this.eSA.setSurfaceTextureListener(this.eSL);
        if (eSC != null) {
            this.eSB = eSC.Jb();
        }
        if (this.eSB != null) {
            this.eSB.setOnPreparedListener(this.eSM);
            this.eSB.setOnCompletionListener(this.eSN);
            this.eSB.setOnErrorListener(this.eSO);
            this.eSB.a(this.aKJ);
        }
        com.baidu.tbadk.core.util.ap.k(this, r.e.cp_bg_line_k);
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
        if (this.eSE != null) {
            str = this.eSE.hd(str);
            if (this.eSE.aYk() != null) {
                this.eSE.aYk().setPlayer(this);
            }
        }
        if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        aYi();
        this.eSF = true;
        this.mUri = uri;
        this.tU = map;
        this.eSG = 0;
        removeView(this.eSA);
        addView(this.eSA, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.ap.k(this, r.e.cp_bg_line_k);
    }

    private void aYi() {
        this.eSF = false;
        this.eSD = false;
        if (this.eSB != null) {
            this.eSB.release();
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
        aYi();
        this.eSH = false;
        if (this.eSE != null) {
            this.eSE.onStop();
        }
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aKH = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aKG = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aKI = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eSD = true;
        if (this.eSB != null) {
            if (this.eSK != null && this.eSJ && !this.eSB.IR()) {
                this.eSB.a(this.mContext, this.mUri, this.tU, this.eSK, this.eSI);
                return;
            } else {
                this.eSB.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.eSE != null) {
            this.eSE.onStart();
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
        if (this.eSB != null) {
            this.eSB.pause();
        }
        if (this.eSE != null) {
            this.eSE.onPause();
        }
        this.eSD = false;
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
        if (this.eSB != null) {
            return this.eSB.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eSB != null) {
            return this.eSB.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eSB != null) {
            this.eSB.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eSB != null) {
            return this.eSB.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.eSB != null) {
            this.eSB.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.eSI = i;
    }

    public int getRecoveryState() {
        return this.eSI;
    }

    public void setNeedRecovery(boolean z) {
        this.eSJ = z;
    }

    public void setLooping(boolean z) {
        this.eSH = z;
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
        this.aNr = bVar;
    }

    public void setBusiness(a aVar) {
        this.eSE = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eSH = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.eSB;
    }
}
