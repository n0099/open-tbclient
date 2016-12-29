package com.baidu.tieba.play;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.play.t;
import com.baidu.tieba.r;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static u eJk;
    private t.a aLE;
    private t.d aLF;
    private t.b aLG;
    private t.c aLH;
    private b aOo;
    private al eJi;
    private t eJj;
    private boolean eJl;
    private a eJm;
    private boolean eJn;
    private int eJo;
    private boolean eJp;
    private TextureView.SurfaceTextureListener eJq;
    private t.d eJr;
    private t.a eJs;
    private t.b eJt;
    private Context mContext;
    private Uri mUri;
    private Map<String, String> ud;

    /* loaded from: classes.dex */
    public interface a {
        void IF();

        String aWw();

        w aWx();

        String hc(String str);

        void onPause();

        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, u.class);
        if (runTask != null) {
            eJk = (u) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eJl = false;
        this.eJn = false;
        this.eJo = 0;
        this.eJp = false;
        this.eJq = new ac(this);
        this.eJr = new ad(this);
        this.eJs = new ae(this);
        this.eJt = new af(this);
        this.aLH = new ag(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eJl = false;
        this.eJn = false;
        this.eJo = 0;
        this.eJp = false;
        this.eJq = new ac(this);
        this.eJr = new ad(this);
        this.eJs = new ae(this);
        this.eJt = new af(this);
        this.aLH = new ag(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eJl = false;
        this.eJn = false;
        this.eJo = 0;
        this.eJp = false;
        this.eJq = new ac(this);
        this.eJr = new ad(this);
        this.eJs = new ae(this);
        this.eJt = new af(this);
        this.aLH = new ag(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eJi = new al(context);
        this.eJi.setSurfaceTextureListener(this.eJq);
        if (eJk != null) {
            this.eJj = eJk.IN();
        }
        if (this.eJj != null) {
            this.eJj.setOnPreparedListener(this.eJr);
            this.eJj.setOnCompletionListener(this.eJs);
            this.eJj.setOnErrorListener(this.eJt);
            this.eJj.a(this.aLH);
        }
        com.baidu.tbadk.core.util.ar.l(this, r.d.cp_bg_line_k);
    }

    public void setVideoPath(String str) {
        if (this.eJm != null) {
            str = this.eJm.hc(str);
            if (this.eJm.aWx() != null) {
                this.eJm.aWx().setPlayer(this);
            }
        }
        if (!com.baidu.tbadk.core.util.av.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        aWv();
        this.eJn = true;
        this.mUri = uri;
        this.ud = map;
        this.eJo = 0;
        removeView(this.eJi);
        addView(this.eJi, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.ar.l(this, r.d.cp_bg_line_k);
    }

    private void aWv() {
        this.eJn = false;
        this.eJl = false;
        if (this.eJj != null) {
            this.eJj.release();
        }
    }

    public void stopPlayback() {
        aWv();
        this.eJp = false;
        if (this.eJm != null) {
            this.eJm.onStop();
        }
    }

    public void setOnPreparedListener(t.d dVar) {
        this.aLF = dVar;
    }

    public void setOnCompletionListener(t.a aVar) {
        this.aLE = aVar;
    }

    public void setOnErrorListener(t.b bVar) {
        this.aLG = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eJl = true;
        if (this.eJj != null) {
            this.eJj.start();
        }
        if (this.eJm != null) {
            this.eJm.onStart();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.eJj != null) {
            this.eJj.pause();
        }
        if (this.eJm != null) {
            this.eJm.onPause();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.eJj != null) {
            return this.eJj.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eJj != null) {
            return this.eJj.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eJj != null) {
            this.eJj.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eJj != null) {
            return this.eJj.isPlaying();
        }
        return false;
    }

    public void setLooping(boolean z) {
        this.eJp = z;
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
        this.aOo = bVar;
    }

    public void setBusiness(a aVar) {
        this.eJm = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.eJp = false;
    }

    public t getPlayer() {
        return this.eJj;
    }
}
