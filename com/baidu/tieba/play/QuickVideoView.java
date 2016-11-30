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
    private static u ffS;
    private t.a aMn;
    private t.d aMo;
    private t.b aMp;
    private t.c aMq;
    private b aOX;
    private al ffQ;
    private t ffR;
    private boolean ffT;
    private a ffU;
    private boolean ffV;
    private int ffW;
    private boolean ffX;
    private TextureView.SurfaceTextureListener ffY;
    private t.d ffZ;
    private t.a fga;
    private t.b fgb;
    private Context mContext;
    private Uri mUri;
    private Map<String, String> ud;

    /* loaded from: classes.dex */
    public interface a {
        void Jk();

        String bcP();

        w bcQ();

        String hh(String str);

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
            ffS = (u) runTask.getData();
        }
    }

    public QuickVideoView(Context context) {
        super(context);
        this.ffT = false;
        this.ffV = false;
        this.ffW = 0;
        this.ffX = false;
        this.ffY = new ac(this);
        this.ffZ = new ad(this);
        this.fga = new ae(this);
        this.fgb = new af(this);
        this.aMq = new ag(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ffT = false;
        this.ffV = false;
        this.ffW = 0;
        this.ffX = false;
        this.ffY = new ac(this);
        this.ffZ = new ad(this);
        this.fga = new ae(this);
        this.fgb = new af(this);
        this.aMq = new ag(this);
        init(context);
    }

    public QuickVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ffT = false;
        this.ffV = false;
        this.ffW = 0;
        this.ffX = false;
        this.ffY = new ac(this);
        this.ffZ = new ad(this);
        this.fga = new ae(this);
        this.fgb = new af(this);
        this.aMq = new ag(this);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ffQ = new al(context);
        this.ffQ.setSurfaceTextureListener(this.ffY);
        if (ffS != null) {
            this.ffR = ffS.Js();
        }
        if (this.ffR != null) {
            this.ffR.setOnPreparedListener(this.ffZ);
            this.ffR.setOnCompletionListener(this.fga);
            this.ffR.setOnErrorListener(this.fgb);
            this.ffR.a(this.aMq);
        }
        com.baidu.tbadk.core.util.at.l(this, r.d.cp_bg_line_k);
    }

    public void setVideoPath(String str) {
        if (this.ffU != null) {
            str = this.ffU.hh(str);
            if (this.ffU.bcQ() != null) {
                this.ffU.bcQ().setPlayer(this);
            }
        }
        if (!com.baidu.tbadk.core.util.ax.isEmpty(str)) {
            setVideoURI(Uri.parse(str));
        }
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        bcO();
        this.ffV = true;
        this.mUri = uri;
        this.ud = map;
        this.ffW = 0;
        removeView(this.ffQ);
        addView(this.ffQ, new FrameLayout.LayoutParams(-2, -2, 17));
        com.baidu.tbadk.core.util.at.l(this, r.d.cp_bg_line_k);
    }

    private void bcO() {
        this.ffV = false;
        this.ffT = false;
        if (this.ffR != null) {
            this.ffR.release();
        }
    }

    public void stopPlayback() {
        bcO();
        this.ffX = false;
        if (this.ffU != null) {
            this.ffU.onStop();
        }
    }

    public void setOnPreparedListener(t.d dVar) {
        this.aMo = dVar;
    }

    public void setOnCompletionListener(t.a aVar) {
        this.aMn = aVar;
    }

    public void setOnErrorListener(t.b bVar) {
        this.aMp = bVar;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.ffT = true;
        if (this.ffR != null) {
            this.ffR.start();
        }
        if (this.ffU != null) {
            this.ffU.onStart();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (this.ffR != null) {
            this.ffR.pause();
        }
        if (this.ffU != null) {
            this.ffU.onPause();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.ffR != null) {
            return this.ffR.getDuration();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.ffR != null) {
            return this.ffR.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (this.ffR != null) {
            this.ffR.seekTo(i);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        if (this.ffR != null) {
            return this.ffR.isPlaying();
        }
        return false;
    }

    public void setLooping(boolean z) {
        this.ffX = z;
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
        this.aOX = bVar;
    }

    public void setBusiness(a aVar) {
        this.ffU = aVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.ffX = false;
    }

    public t getPlayer() {
        return this.ffR;
    }
}
