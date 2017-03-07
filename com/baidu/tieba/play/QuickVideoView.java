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
    private static w eWj;
    private Map<String, String> Bj;
    private v.a aQr;
    private v.d aQs;
    private v.b aQt;
    private v.c aQu;
    private b aTe;
    private an eWh;
    private v eWi;
    private boolean eWk;
    private a eWl;
    private boolean eWm;
    private int eWn;
    private boolean eWo;
    private int eWp;
    private boolean eWq;
    private SurfaceTexture eWr;
    private TextureView.SurfaceTextureListener eWs;
    private v.d eWt;
    private v.a eWu;
    private v.b eWv;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void Jx();

        void Jy();

        String aXO();

        y aXP();

        String gS(String str);

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
            eWj = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eWk = false;
        this.eWm = false;
        this.eWn = 0;
        this.eWo = false;
        this.eWp = -1;
        this.eWq = false;
        this.eWr = null;
        this.eWs = new ae(this);
        this.eWt = new af(this);
        this.eWu = new ag(this);
        this.eWv = new ah(this);
        this.aQu = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eWk = false;
        this.eWm = false;
        this.eWn = 0;
        this.eWo = false;
        this.eWp = -1;
        this.eWq = false;
        this.eWr = null;
        this.eWs = new ae(this);
        this.eWt = new af(this);
        this.eWu = new ag(this);
        this.eWv = new ah(this);
        this.aQu = new ai(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eWk = false;
        this.eWm = false;
        this.eWn = 0;
        this.eWo = false;
        this.eWp = -1;
        this.eWq = false;
        this.eWr = null;
        this.eWs = new ae(this);
        this.eWt = new af(this);
        this.eWu = new ag(this);
        this.eWv = new ah(this);
        this.aQu = new ai(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eWh = new an(context);
        this.eWh.setSurfaceTextureListener(this.eWs);
        if (eWj != null) {
            this.eWi = eWj.JG();
        }
        if (this.eWi != null) {
            this.eWi.setOnPreparedListener(this.eWt);
            this.eWi.setOnCompletionListener(this.eWu);
            this.eWi.setOnErrorListener(this.eWv);
            this.eWi.a(this.aQu);
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
        if (this.eWl != null) {
            str = this.eWl.gS(str);
            if (this.eWl.aXP() != null) {
                this.eWl.aXP().setPlayer(this);
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
        aXM();
        this.eWm = true;
        this.mUri = uri;
        this.Bj = map;
        this.eWn = 0;
        removeView(this.eWh);
        addView(this.eWh, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_k);
    }

    private void aXM() {
        this.eWm = false;
        this.eWk = false;
        if (this.eWi != null) {
            this.eWi.release();
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
        aXM();
        this.eWo = false;
        if (this.eWl != null) {
            this.eWl.onStop();
        }
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aQs = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aQr = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aQt = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eWk = true;
        if (this.eWi != null) {
            if (this.eWr != null && this.eWq && !this.eWi.Jw()) {
                this.eWi.a(this.mContext, this.mUri, this.Bj, this.eWr, this.eWp);
                return;
            } else {
                this.eWi.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.eWl != null) {
            this.eWl.onStart();
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
        if (this.eWi != null) {
            this.eWi.pause();
        }
        if (this.eWl != null) {
            this.eWl.onPause();
        }
        this.eWk = false;
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
        if (this.eWi != null) {
            return this.eWi.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eWi != null) {
            return this.eWi.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eWi != null) {
            this.eWi.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eWi != null) {
            return this.eWi.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.eWi != null) {
            this.eWi.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.eWp = i;
    }

    public int getRecoveryState() {
        return this.eWp;
    }

    public void setNeedRecovery(boolean z) {
        this.eWq = z;
    }

    public void setLooping(boolean z) {
        this.eWo = z;
    }

    public boolean aXN() {
        return this.eWk;
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
        this.aTe = bVar;
    }

    public void setBusiness(a aVar) {
        this.eWl = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eWo = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.eWi;
    }
}
