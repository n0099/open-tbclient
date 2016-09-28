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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.play.e;
import com.baidu.tieba.r;
import java.util.Map;
/* loaded from: classes.dex */
public class QuickVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private static f eYH;
    private e.a aLq;
    private e.d aLr;
    private e.b aLs;
    private e.c aLt;
    private b aMS;
    private w eYF;
    private e eYG;
    private boolean eYI;
    private a eYJ;
    private boolean eYK;
    private int eYL;
    private TextureView.SurfaceTextureListener eYM;
    private e.d eYN;
    private e.a eYO;
    private e.b eYP;
    private Context mContext;
    private Uri mUri;
    private Map<String, String> uc;

    /* loaded from: classes.dex */
    public interface a {
        void baq();

        h bar();

        String hg(String str);

        void onPause();

        void onStart();

        void onStop();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onSurfaceDestroyed();
    }

    static {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, f.class);
        if (runTask != null) {
            eYH = (f) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.eYI = false;
        this.eYK = false;
        this.eYL = 0;
        this.eYM = new n(this);
        this.eYN = new o(this);
        this.eYO = new p(this);
        this.eYP = new q(this);
        this.aLt = new r(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYI = false;
        this.eYK = false;
        this.eYL = 0;
        this.eYM = new n(this);
        this.eYN = new o(this);
        this.eYO = new p(this);
        this.eYP = new q(this);
        this.aLt = new r(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYI = false;
        this.eYK = false;
        this.eYL = 0;
        this.eYM = new n(this);
        this.eYN = new o(this);
        this.eYO = new p(this);
        this.eYP = new q(this);
        this.aLt = new r(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.eYF = new w(context);
        this.eYF.setSurfaceTextureListener(this.eYM);
        if (eYH != null) {
            this.eYG = eYH.Jm();
        }
        if (this.eYG != null) {
            this.eYG.setOnPreparedListener(this.eYN);
            this.eYG.setOnCompletionListener(this.eYO);
            this.eYG.setOnErrorListener(this.eYP);
            this.eYG.a(this.aLt);
        }
        av.l(this, r.d.cp_bg_line_k);
    }

    public void setVideoPath(String str) {
        if (this.eYJ != null) {
            str = this.eYJ.hg(str);
            if (this.eYJ.bar() != null) {
                this.eYJ.bar().setPlayer(this);
            }
        }
        if (!az.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        stopPlayback();
        this.eYK = true;
        this.mUri = uri;
        this.uc = map;
        this.eYL = 0;
        removeView(this.eYF);
        addView(this.eYF, new FrameLayout.LayoutParams(-2, -2, 17));
        av.l(this, r.d.cp_bg_line_k);
    }

    public void stopPlayback() {
        this.eYK = false;
        this.eYI = false;
        if (this.eYG != null) {
            this.eYG.release();
        }
        if (this.eYJ != null) {
            this.eYJ.onStop();
        }
    }

    public void setOnPreparedListener(e.d dVar) {
        this.aLr = dVar;
    }

    public void setOnCompletionListener(e.a aVar) {
        this.aLq = aVar;
    }

    public void setOnErrorListener(e.b bVar) {
        this.aLs = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.eYI = true;
        if (this.eYG != null) {
            this.eYG.start();
        }
        if (this.eYJ != null) {
            this.eYJ.onStart();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.eYG != null) {
            this.eYG.pause();
        }
        if (this.eYJ != null) {
            this.eYJ.onPause();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.eYG != null) {
            return this.eYG.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.eYG != null) {
            return this.eYG.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.eYG != null) {
            this.eYG.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.eYG != null) {
            return this.eYG.isPlaying();
        }
        return false;
    }

    public void setLooping(boolean z) {
        if (this.eYG != null) {
            this.eYG.setLooping(z);
        }
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
        this.aMS = bVar;
    }

    public void setBusiness(a aVar) {
        this.eYJ = aVar;
    }
}
