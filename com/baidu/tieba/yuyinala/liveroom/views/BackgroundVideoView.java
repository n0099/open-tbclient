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
    private int cqj;
    private MediaPlayer.OnPreparedListener eaV;
    private MediaPlayer.OnErrorListener eaX;
    MediaPlayer.OnPreparedListener exU;
    MediaPlayer.OnVideoSizeChangedListener exW;
    private MediaPlayer.OnErrorListener exX;
    private MediaPlayer mMediaPlayer;
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;
    MediaPlayer.OnInfoListener nKo;
    private int osM;
    private MediaPlayer.OnVideoSizeChangedListener osN;
    private MediaPlayer.OnInfoListener osO;
    SurfaceHolder.Callback osP;

    public BackgroundVideoView(Context context) {
        this(context, null);
    }

    public BackgroundVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackgroundVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqj = 0;
        this.osM = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.osP = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                boolean z = true;
                BackgroundVideoView.this.mSurfaceWidth = i3;
                BackgroundVideoView.this.mSurfaceHeight = i4;
                boolean z2 = BackgroundVideoView.this.osM == 3;
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
                BackgroundVideoView.this.bfE();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                BackgroundVideoView.this.mSurfaceHolder = null;
                BackgroundVideoView.this.release(true);
            }
        };
        this.exW = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                BackgroundVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                BackgroundVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (BackgroundVideoView.this.mVideoWidth != 0 && BackgroundVideoView.this.mVideoHeight != 0) {
                    BackgroundVideoView.this.getHolder().setFixedSize(BackgroundVideoView.this.mVideoWidth, BackgroundVideoView.this.mVideoHeight);
                    BackgroundVideoView.this.requestLayout();
                }
                if (BackgroundVideoView.this.osN != null) {
                    BackgroundVideoView.this.osN.onVideoSizeChanged(mediaPlayer, i2, i3);
                }
            }
        };
        this.exU = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                BackgroundVideoView.this.cqj = 2;
                if (BackgroundVideoView.this.eaV != null) {
                    BackgroundVideoView.this.eaV.onPrepared(BackgroundVideoView.this.mMediaPlayer);
                }
                BackgroundVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                BackgroundVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (BackgroundVideoView.this.mVideoWidth != 0 && BackgroundVideoView.this.mVideoHeight != 0) {
                    BackgroundVideoView.this.getHolder().setFixedSize(BackgroundVideoView.this.mVideoWidth, BackgroundVideoView.this.mVideoHeight);
                }
                BackgroundVideoView.this.start();
            }
        };
        this.exX = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                Log.d("BackgroundVideoView", "Error: " + i2 + "," + i3);
                BackgroundVideoView.this.cqj = -1;
                BackgroundVideoView.this.osM = -1;
                if (BackgroundVideoView.this.eaX == null || BackgroundVideoView.this.eaX.onError(BackgroundVideoView.this.mMediaPlayer, i2, i3)) {
                }
                return true;
            }
        };
        this.nKo = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (BackgroundVideoView.this.osO != null) {
                    BackgroundVideoView.this.osO.onInfo(mediaPlayer, i2, i3);
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
        getHolder().addCallback(this.osP);
        getHolder().setType(3);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.mUri = uri;
        bfE();
        requestLayout();
        invalidate();
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.cqj = 3;
        }
        this.osM = 3;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.cqj = 4;
        }
        this.osM = 4;
    }

    public void ead() {
        release(false);
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.cqj == -1 || this.cqj == 0 || this.cqj == 1) ? false : true;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.cqj = 0;
            this.osM = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfE() {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            release(false);
            try {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setDataSource(getContext(), this.mUri);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.setLooping(true);
                this.mMediaPlayer.setOnPreparedListener(this.exU);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.exW);
                this.mMediaPlayer.setOnErrorListener(this.exX);
                this.mMediaPlayer.setOnInfoListener(this.nKo);
                this.mMediaPlayer.prepareAsync();
                this.cqj = 1;
            } catch (IOException e) {
                Log.w("BackgroundVideoView", "Unable to open content: " + this.mUri, e);
                this.cqj = -1;
                this.osM = -1;
                this.exX.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e2) {
                Log.w("BackgroundVideoView", "Unable to open content: " + this.mUri, e2);
                this.cqj = -1;
                this.osM = -1;
                this.exX.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.cqj = 0;
            if (z) {
                this.osM = 0;
            }
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.eaX = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.osO = onInfoListener;
    }
}
