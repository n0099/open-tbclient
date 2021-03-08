package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class BackgroundVideoView extends SurfaceView {
    MediaPlayer.OnPreparedListener eBE;
    MediaPlayer.OnVideoSizeChangedListener eBG;
    private MediaPlayer.OnErrorListener eBH;
    private int eBs;
    private MediaPlayer.OnPreparedListener eeD;
    private MediaPlayer.OnErrorListener eeF;
    private MediaPlayer mMediaPlayer;
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;
    MediaPlayer.OnInfoListener nWA;
    private int oFd;
    private MediaPlayer.OnVideoSizeChangedListener oFe;
    private MediaPlayer.OnInfoListener oFf;
    SurfaceHolder.Callback oFg;

    public BackgroundVideoView(Context context) {
        this(context, null);
    }

    public BackgroundVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackgroundVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBs = 0;
        this.oFd = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.oFg = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                boolean z = true;
                BackgroundVideoView.this.mSurfaceWidth = i3;
                BackgroundVideoView.this.mSurfaceHeight = i4;
                boolean z2 = BackgroundVideoView.this.oFd == 3;
                if (BackgroundVideoView.this.mVideoWidth != i3 || BackgroundVideoView.this.mVideoHeight != i4) {
                    z = false;
                }
                if (BackgroundVideoView.this.mMediaPlayer != null && z2 && z) {
                    BackgroundVideoView.this.start();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                BackgroundVideoView.this.mSurfaceHolder = surfaceHolder;
                BackgroundVideoView.this.bfT();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                BackgroundVideoView.this.mSurfaceHolder = null;
                BackgroundVideoView.this.release(true);
            }
        };
        this.eBG = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                BackgroundVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                BackgroundVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (BackgroundVideoView.this.mVideoWidth != 0 && BackgroundVideoView.this.mVideoHeight != 0) {
                    BackgroundVideoView.this.getHolder().setFixedSize(BackgroundVideoView.this.mVideoWidth, BackgroundVideoView.this.mVideoHeight);
                    BackgroundVideoView.this.requestLayout();
                }
                if (BackgroundVideoView.this.oFe != null) {
                    BackgroundVideoView.this.oFe.onVideoSizeChanged(mediaPlayer, i2, i3);
                }
            }
        };
        this.eBE = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                BackgroundVideoView.this.eBs = 2;
                if (BackgroundVideoView.this.eeD != null) {
                    BackgroundVideoView.this.eeD.onPrepared(BackgroundVideoView.this.mMediaPlayer);
                }
                BackgroundVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                BackgroundVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (BackgroundVideoView.this.mVideoWidth != 0 && BackgroundVideoView.this.mVideoHeight != 0) {
                    BackgroundVideoView.this.getHolder().setFixedSize(BackgroundVideoView.this.mVideoWidth, BackgroundVideoView.this.mVideoHeight);
                }
                BackgroundVideoView.this.start();
            }
        };
        this.eBH = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                Log.d("BackgroundVideoView", "Error: " + i2 + "," + i3);
                BackgroundVideoView.this.eBs = -1;
                BackgroundVideoView.this.oFd = -1;
                if (BackgroundVideoView.this.eeF == null || BackgroundVideoView.this.eeF.onError(BackgroundVideoView.this.mMediaPlayer, i2, i3)) {
                }
                return true;
            }
        };
        this.nWA = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (BackgroundVideoView.this.oFf != null) {
                    BackgroundVideoView.this.oFf.onInfo(mediaPlayer, i2, i3);
                    return false;
                }
                return false;
            }
        };
        init();
    }

    private void init() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.oFg);
        getHolder().setType(3);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.mUri = uri;
        bfT();
        requestLayout();
        invalidate();
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.eBs = 3;
        }
        this.oFd = 3;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.eBs = 4;
        }
        this.oFd = 4;
    }

    public void ecG() {
        release(false);
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.eBs == -1 || this.eBs == 0 || this.eBs == 1) ? false : true;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.eBs = 0;
            this.oFd = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfT() {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            release(false);
            try {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setDataSource(getContext(), this.mUri);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.setLooping(true);
                this.mMediaPlayer.setOnPreparedListener(this.eBE);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.eBG);
                this.mMediaPlayer.setOnErrorListener(this.eBH);
                this.mMediaPlayer.setOnInfoListener(this.nWA);
                this.mMediaPlayer.prepareAsync();
                this.eBs = 1;
            } catch (IOException e) {
                Log.w("BackgroundVideoView", "Unable to open content: " + this.mUri, e);
                this.eBs = -1;
                this.oFd = -1;
                this.eBH.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e2) {
                Log.w("BackgroundVideoView", "Unable to open content: " + this.mUri, e2);
                this.eBs = -1;
                this.oFd = -1;
                this.eBH.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.eBs = 0;
            if (z) {
                this.oFd = 0;
            }
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.eeF = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.oFf = onInfoListener;
    }
}
