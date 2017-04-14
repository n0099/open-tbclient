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
    private static w eUi;
    private Map<String, String> AK;
    private v.a aQH;
    private v.d aQI;
    private v.b aQJ;
    private v.c aQK;
    private b aTt;
    private an eUg;
    private v eUh;
    private boolean eUj;
    private a eUk;
    private boolean eUl;
    private int eUm;
    private boolean eUn;
    private int eUo;
    private boolean eUp;
    private SurfaceTexture eUq;
    private TextureView.SurfaceTextureListener eUr;
    private v.d eUs;
    private v.a eUt;
    private v.b eUu;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void JX();

        void JY();

        String aXX();

        y aXY();

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
            eUi = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eUj = false;
        this.eUl = false;
        this.eUm = 0;
        this.eUn = false;
        this.eUo = -1;
        this.eUp = false;
        this.eUq = null;
        this.eUr = new ae(this);
        this.eUs = new af(this);
        this.eUt = new ag(this);
        this.eUu = new ah(this);
        this.aQK = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUj = false;
        this.eUl = false;
        this.eUm = 0;
        this.eUn = false;
        this.eUo = -1;
        this.eUp = false;
        this.eUq = null;
        this.eUr = new ae(this);
        this.eUs = new af(this);
        this.eUt = new ag(this);
        this.eUu = new ah(this);
        this.aQK = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUj = false;
        this.eUl = false;
        this.eUm = 0;
        this.eUn = false;
        this.eUo = -1;
        this.eUp = false;
        this.eUq = null;
        this.eUr = new ae(this);
        this.eUs = new af(this);
        this.eUt = new ag(this);
        this.eUu = new ah(this);
        this.aQK = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eUg = new an(context);
        this.eUg.setSurfaceTextureListener(this.eUr);
        if (eUi != null) {
            this.eUh = eUi.Kg();
        }
        if (this.eUh != null) {
            this.eUh.setOnPreparedListener(this.eUs);
            this.eUh.setOnCompletionListener(this.eUt);
            this.eUh.setOnErrorListener(this.eUu);
            this.eUh.a(this.aQK);
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
        if (this.eUk != null) {
            str = this.eUk.gW(str);
            if (this.eUk.aXY() != null) {
                this.eUk.aXY().setPlayer(this);
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
        aXV();
        this.eUl = true;
        this.mUri = uri;
        this.AK = map;
        this.eUm = 0;
        removeView(this.eUg);
        addView(this.eUg, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_k);
    }

    private void aXV() {
        this.eUl = false;
        this.eUj = false;
        if (this.eUh != null) {
            this.eUh.release();
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
        aXV();
        this.eUn = false;
        if (this.eUk != null) {
            this.eUk.onStop();
        }
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aQI = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aQH = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aQJ = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eUj = true;
        if (this.eUh != null) {
            if (this.eUq != null && this.eUp && !this.eUh.JW()) {
                this.eUh.a(this.mContext, this.mUri, this.AK, this.eUq, this.eUo);
                return;
            } else {
                this.eUh.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.eUk != null) {
            this.eUk.onStart();
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
        if (this.eUh != null) {
            this.eUh.pause();
        }
        if (this.eUk != null) {
            this.eUk.onPause();
        }
        this.eUj = false;
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
        if (this.eUh != null) {
            return this.eUh.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eUh != null) {
            return this.eUh.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eUh != null) {
            this.eUh.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eUh != null) {
            return this.eUh.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.eUh != null) {
            this.eUh.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.eUo = i;
    }

    public int getRecoveryState() {
        return this.eUo;
    }

    public void setNeedRecovery(boolean z) {
        this.eUp = z;
    }

    public void setLooping(boolean z) {
        this.eUn = z;
    }

    public boolean aXW() {
        return this.eUj;
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
        this.aTt = bVar;
    }

    public void setBusiness(a aVar) {
        this.eUk = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eUn = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.eUh;
    }
}
