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
    private static w flA;
    private Map<String, String> AN;
    private v.a aSw;
    private v.d aSx;
    private v.b aSy;
    private v.c aSz;
    private b bBO;
    private boolean flB;
    private a flC;
    private boolean flD;
    private int flE;
    private boolean flF;
    private int flG;
    private boolean flH;
    private SurfaceTexture flI;
    private TextureView.SurfaceTextureListener flJ;
    private v.d flK;
    private v.a flL;
    private v.b flM;
    private b.InterfaceC0080b flN;
    private ao flx;
    private String fly;
    private v flz;
    private Context mContext;
    private Uri mUri;
    private PowerManager.WakeLock mWakeLock;

    /* loaded from: classes.dex */
    public interface a {
        void JG();

        void JH();

        String bbZ();

        y bca();

        String hm(String str);

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
            flA = (w) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.flB = false;
        this.flD = false;
        this.flE = 0;
        this.flF = false;
        this.flG = -1;
        this.flH = false;
        this.flI = null;
        this.flJ = new ae(this);
        this.flK = new af(this);
        this.flL = new ag(this);
        this.flM = new ah(this);
        this.aSz = new ai(this);
        this.flN = new aj(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.flB = false;
        this.flD = false;
        this.flE = 0;
        this.flF = false;
        this.flG = -1;
        this.flH = false;
        this.flI = null;
        this.flJ = new ae(this);
        this.flK = new af(this);
        this.flL = new ag(this);
        this.flM = new ah(this);
        this.aSz = new ai(this);
        this.flN = new aj(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.flB = false;
        this.flD = false;
        this.flE = 0;
        this.flF = false;
        this.flG = -1;
        this.flH = false;
        this.flI = null;
        this.flJ = new ae(this);
        this.flK = new af(this);
        this.flL = new ag(this);
        this.flM = new ah(this);
        this.aSz = new ai(this);
        this.flN = new aj(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.flx = new ao(context);
        this.flx.setSurfaceTextureListener(this.flJ);
        if (flA != null) {
            this.flz = flA.JP();
        }
        if (this.flz != null) {
            this.flz.setOnPreparedListener(this.flK);
            this.flz.setOnCompletionListener(this.flL);
            this.flz.setOnErrorListener(this.flM);
            this.flz.a(this.aSz);
        }
        com.baidu.tbadk.core.util.as.k(this, w.e.cp_bg_line_k);
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
        if (this.flC != null) {
            str = this.flC.hm(str);
            if (this.flC.bca() != null) {
                this.flC.bca().setPlayer(this);
            }
        }
        if (!com.baidu.tbadk.core.util.aw.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        bbW();
        this.flD = true;
        this.mUri = uri;
        this.AN = map;
        this.flE = 0;
        removeView(this.flx);
        addView(this.flx, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.as.k(this, w.e.cp_bg_line_k);
    }

    private void bbW() {
        this.flD = false;
        this.flB = false;
        if (this.flz != null) {
            this.flz.release();
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
        this.fly = null;
        bbW();
        this.flF = false;
        if (this.flC != null) {
            this.flC.onStop();
        }
        com.baidu.tieba.play.a.b.bcq().a((b.InterfaceC0080b) null);
    }

    public void setOnPreparedListener(v.d dVar) {
        this.aSx = dVar;
    }

    public void setOnCompletionListener(v.a aVar) {
        this.aSw = aVar;
    }

    public void setOnErrorListener(v.b bVar) {
        this.aSy = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.flB = true;
        if (this.flz != null) {
            if (this.flI != null && this.flH && !this.flz.JF()) {
                this.flz.a(this.mContext, this.mUri, this.AN, this.flI, this.flG);
                return;
            } else {
                this.flz.start();
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_VEDIO_START_PLAY));
            }
        }
        if (this.flC != null) {
            this.flC.onStart();
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
        if (this.flz != null) {
            this.flz.pause();
        }
        if (this.flC != null) {
            this.flC.onPause();
        }
        this.flB = false;
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
        if (this.flz != null) {
            return this.flz.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.flz != null) {
            return this.flz.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.flz != null) {
            this.flz.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.flz != null) {
            return this.flz.isPlaying();
        }
        return false;
    }

    public void setVolume(float f, float f2) {
        if (this.flz != null) {
            this.flz.setVolume(f, f2);
        }
    }

    public void setRecoveryState(int i) {
        this.flG = i;
    }

    public int getRecoveryState() {
        return this.flG;
    }

    public void setNeedRecovery(boolean z) {
        this.flH = z;
    }

    public void setLooping(boolean z) {
        this.flF = z;
    }

    public boolean bbX() {
        return this.flB;
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
        this.bBO = bVar;
    }

    public void setBusiness(a aVar) {
        this.flC = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.flF = false;
        try {
            if (this.mWakeLock != null && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public v getPlayer() {
        return this.flz;
    }

    private boolean bbY() {
        return (com.baidu.adp.lib.b.e.eY().ad("android_video_http_dns_open") == 0 || !com.baidu.adp.lib.util.i.hj() || this.flz == null || CustomPlayerSwitchStatic.bbM() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(v vVar, int i, int i2) {
        if (!bbY() || i2 == -100 || this.mUri == null || TextUtils.isEmpty(this.mUri.getHost())) {
            return false;
        }
        com.baidu.tieba.play.a.b.bcq().a(this.flN);
        return com.baidu.tieba.play.a.b.bcq().qg(this.mUri.getHost());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(String str, String str2) throws Exception {
        if (getCurrentPosition() <= 0 || this.flz == null || this.flI == null) {
            this.fly = str;
            URI uri = new URI(this.mUri.toString());
            this.flz.a(this.mContext, Uri.parse(new URI(uri.getScheme(), str, uri.getPath(), uri.getFragment()).toString()), this.AN, this.flI, this.mUri.getHost());
            start();
        }
    }
}
