package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import java.io.IOException;
/* loaded from: classes.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    private int Jh;
    private MediaPlayer bxu;
    private a cKK;
    private String cVY;
    private int cVZ;
    private int cWa;
    private MediaController cWb;
    private MediaPlayer.OnCompletionListener cWc;
    private MediaPlayer.OnPreparedListener cWd;
    private int cWe;
    private MediaPlayer.OnErrorListener cWf;
    private int cWg;
    private boolean cWh;
    private boolean cWi;
    private boolean cWj;
    private TextureView.SurfaceTextureListener cWk;
    MediaPlayer.OnVideoSizeChangedListener cWl;
    MediaPlayer.OnPreparedListener cWm;
    private MediaPlayer.OnCompletionListener cWn;
    private MediaPlayer.OnErrorListener cWo;
    private MediaPlayer.OnBufferingUpdateListener cWp;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private int mVideoHeight;
    private int mVideoWidth;

    /* loaded from: classes.dex */
    public interface a {
        void ape();
    }

    public TextureVideoView(Context context) {
        super(context);
        this.cVZ = 0;
        this.cWa = 0;
        this.bxu = null;
        this.cWk = new n(this);
        this.cWl = new o(this);
        this.cWm = new p(this);
        this.cWn = new q(this);
        this.cWo = new r(this);
        this.cWp = new s(this);
        aF(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        aF(context);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cVZ = 0;
        this.cWa = 0;
        this.bxu = null;
        this.cWk = new n(this);
        this.cWl = new o(this);
        this.cWm = new p(this);
        this.cWn = new q(this);
        this.cWo = new r(this);
        this.cWp = new s(this);
        aF(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * defaultSize) {
                defaultSize2 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
            } else if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * defaultSize) {
                defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    private void aF(Context context) {
        this.mContext = context;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.cWk);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.cVZ = 0;
        this.cWa = 0;
    }

    public void setVideoPath(String str) {
        this.cVY = str;
        this.cWg = 0;
        asW();
        requestLayout();
        invalidate();
    }

    public void stopPlayback() {
        if (this.bxu != null) {
            this.bxu.stop();
            this.bxu.release();
            this.bxu = null;
            this.cVZ = 0;
            this.cWa = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asW() {
        if (this.cVY != null && !this.cVY.isEmpty() && this.mSurfaceTexture != null) {
            fP(false);
            try {
                this.bxu = new MediaPlayer();
                this.bxu.setOnPreparedListener(this.cWm);
                this.bxu.setOnVideoSizeChangedListener(this.cWl);
                this.Jh = -1;
                this.bxu.setOnCompletionListener(this.cWn);
                this.bxu.setOnErrorListener(this.cWo);
                this.bxu.setOnBufferingUpdateListener(this.cWp);
                this.cWe = 0;
                this.bxu.setDataSource(this.cVY);
                this.bxu.setSurface(new Surface(this.mSurfaceTexture));
                this.bxu.setAudioStreamType(3);
                this.bxu.prepareAsync();
                this.cVZ = 1;
                asX();
            } catch (IOException e) {
                this.cVZ = -1;
                this.cWa = -1;
                this.cWo.onError(this.bxu, 1, 0);
            } catch (IllegalArgumentException e2) {
                this.cVZ = -1;
                this.cWa = -1;
                this.cWo.onError(this.bxu, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        if (this.cWb != null) {
            this.cWb.hide();
        }
        this.cWb = mediaController;
        asX();
    }

    private void asX() {
        if (this.bxu != null && this.cWb != null) {
            this.cWb.setMediaPlayer(this);
            this.cWb.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
            this.cWb.setEnabled(asZ());
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.cWd = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.cWc = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.cWf = onErrorListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(boolean z) {
        if (this.bxu != null) {
            this.bxu.reset();
            this.bxu.release();
            this.bxu = null;
            this.cVZ = 0;
            if (z) {
                this.cWa = 0;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (asZ() && this.cWb != null) {
            asY();
            return false;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (asZ() && this.cWb != null) {
            asY();
            return false;
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (asZ() && z && this.cWb != null) {
            if (i == 79 || i == 85) {
                if (this.bxu.isPlaying()) {
                    pause();
                    this.cWb.show();
                    return true;
                }
                start();
                this.cWb.hide();
                return true;
            } else if (i == 126) {
                if (this.bxu.isPlaying()) {
                    return true;
                }
                start();
                this.cWb.hide();
                return true;
            } else if (i == 86 || i == 127) {
                if (this.bxu.isPlaying()) {
                    pause();
                    this.cWb.show();
                    return true;
                }
                return true;
            } else {
                asY();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void asY() {
        if (this.cWb.isShowing()) {
            this.cWb.hide();
        } else {
            this.cWb.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (asZ()) {
            this.bxu.start();
            this.cVZ = 3;
        }
        this.cWa = 3;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (asZ() && this.bxu.isPlaying()) {
            this.bxu.pause();
            this.cVZ = 4;
        }
        this.cWa = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (asZ()) {
            if (this.Jh > 0) {
                return this.Jh;
            }
            this.Jh = this.bxu.getDuration();
            return this.Jh;
        }
        this.Jh = -1;
        return this.Jh;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (asZ()) {
            return this.bxu.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (asZ()) {
            this.bxu.seekTo(i);
            this.cWg = 0;
            return;
        }
        this.cWg = i;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return asZ() && this.bxu.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.bxu != null) {
            return this.cWe;
        }
        return 0;
    }

    private boolean asZ() {
        return (this.bxu == null || this.cVZ == -1 || this.cVZ == 0 || this.cVZ == 1) ? false : true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.cWh;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.cWi;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.cWj;
    }

    public void setOnSurfaceDestroyedListener(a aVar) {
        this.cKK = aVar;
    }
}
