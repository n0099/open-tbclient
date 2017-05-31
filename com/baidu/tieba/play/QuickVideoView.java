package com.baidu.tieba.play;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.play.a.b;
import com.baidu.tieba.play.v;
import com.baidu.tieba.w;
import java.net.URI;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static w fbk;
    private Map<String, String> AN;
    private v.a aRd;
    private v.d aRe;
    private v.b aRf;
    private v.c aRg;
    private b bAV;
    private ao fbh;
    private String fbi;
    private v fbj;
    private boolean fbl;
    private a fbm;
    private boolean fbn;
    private int fbo;
    private boolean fbp;
    private int fbq;
    private boolean fbr;
    private SurfaceTexture fbs;
    private TextureView.SurfaceTextureListener fbt;
    private v.d fbu;
    private v.a fbv;
    private v.b fbw;
    private b.InterfaceC0077b fbx;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void Ji();

        void Jj();

        String aXO();

        y aXP();

        String gP(String str);

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
            fbk = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.fbl = false;
        this.fbn = false;
        this.fbo = 0;
        this.fbp = false;
        this.fbq = -1;
        this.fbr = false;
        this.fbs = null;
        this.fbt = new ae(this);
        this.fbu = new af(this);
        this.fbv = new ag(this);
        this.fbw = new ah(this);
        this.aRg = new ai(this);
        this.fbx = new aj(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbl = false;
        this.fbn = false;
        this.fbo = 0;
        this.fbp = false;
        this.fbq = -1;
        this.fbr = false;
        this.fbs = null;
        this.fbt = new ae(this);
        this.fbu = new af(this);
        this.fbv = new ag(this);
        this.fbw = new ah(this);
        this.aRg = new ai(this);
        this.fbx = new aj(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fbl = false;
        this.fbn = false;
        this.fbo = 0;
        this.fbp = false;
        this.fbq = -1;
        this.fbr = false;
        this.fbs = null;
        this.fbt = new ae(this);
        this.fbu = new af(this);
        this.fbv = new ag(this);
        this.fbw = new ah(this);
        this.aRg = new ai(this);
        this.fbx = new aj(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fbh = new ao(context);
        this.fbh.setSurfaceTextureListener(this.fbt);
        if (fbk != null) {
            this.fbj = fbk.Jr();
        }
        if (this.fbj != null) {
            this.fbj.setOnPreparedListener(this.fbu);
            this.fbj.setOnCompletionListener(this.fbv);
            this.fbj.setOnErrorListener(this.fbw);
            this.fbj.a(this.aRg);
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
        if (this.fbm != null) {
            str = this.fbm.gP(str);
            if (this.fbm.aXP() != null) {
                this.fbm.aXP().setPlayer(this);
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
        aXL();
        this.fbn = true;
        this.mUri = uri;
        this.AN = map;
        this.fbo = 0;
        removeView(this.fbh);
        addView(this.fbh, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.aq.k(this, w.e.cp_bg_line_k);
    }

    private void aXL() {
        this.fbn = false;
        this.fbl = false;
        if (this.fbj != null) {
            this.fbj.release();
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
        this.fbi = null;
        aXL();
        this.fbp = false;
        if (this.fbm != null) {
            this.fbm.onStop();
        }
        com.baidu.tieba.play.a.b.aYf().a((b.InterfaceC0077b) null);
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aRe = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aRd = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aRf = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.fbl = true;
        if (this.fbj != null) {
            if (this.fbs != null && this.fbr && !this.fbj.Jh()) {
                this.fbj.a(this.mContext, this.mUri, this.AN, this.fbs, this.fbq);
                return;
            } else {
                this.fbj.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.fbm != null) {
            this.fbm.onStart();
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
        if (this.fbj != null) {
            this.fbj.pause();
        }
        if (this.fbm != null) {
            this.fbm.onPause();
        }
        this.fbl = false;
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
        if (this.fbj != null) {
            return this.fbj.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.fbj != null) {
            return this.fbj.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.fbj != null) {
            this.fbj.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.fbj != null) {
            return this.fbj.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.fbj != null) {
            this.fbj.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.fbq = i;
    }

    public int getRecoveryState() {
        return this.fbq;
    }

    public void setNeedRecovery(boolean z) {
        this.fbr = z;
    }

    public void setLooping(boolean z) {
        this.fbp = z;
    }

    public boolean aXM() {
        return this.fbl;
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
        this.bAV = bVar;
    }

    public void setBusiness(a aVar) {
        this.fbm = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.fbp = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.fbj;
    }

    private boolean aXN() {
        return (com.baidu.adp.lib.b.e.eZ().Y("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hk() || this.fbj == null || CustomPlayerSwitchStatic.aXB() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(v vVar, int i, int i2) {
        if (!aXN() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.aYf().a(this.fbx);
        return com.baidu.tieba.play.a.b.aYf().pj(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.fbj == null || this.fbs == null) {
            this.fbi = str;
            URI uri = new URI(this.mUri.toString());
            this.fbj.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.AN, this.fbs, this.mUri.getHost());
            start();
        }
    }
}
