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
/* loaded from: classes11.dex */
public class BackgroundVideoView extends SurfaceView {
    private int cvb;
    MediaPlayer.OnPreparedListener eCI;
    MediaPlayer.OnVideoSizeChangedListener eCK;
    private MediaPlayer.OnErrorListener eCL;
    private MediaPlayer.OnPreparedListener efH;
    private MediaPlayer.OnErrorListener efJ;
    private MediaPlayer mMediaPlayer;
    private int mSurfaceHeight;
    private SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private Uri mUri;
    private int mVideoHeight;
    private int mVideoWidth;
    MediaPlayer.OnInfoListener nOT;
    private int oxs;
    private MediaPlayer.OnVideoSizeChangedListener oxt;
    private MediaPlayer.OnInfoListener oxu;
    SurfaceHolder.Callback oxv;

    public BackgroundVideoView(Context context) {
        this(context, null);
    }

    public BackgroundVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackgroundVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cvb = 0;
        this.oxs = 0;
        this.mSurfaceHolder = null;
        this.mMediaPlayer = null;
        this.oxv = new SurfaceHolder.Callback() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                boolean z = true;
                BackgroundVideoView.this.mSurfaceWidth = i3;
                BackgroundVideoView.this.mSurfaceHeight = i4;
                boolean z2 = BackgroundVideoView.this.oxs == 3;
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
                BackgroundVideoView.this.bjy();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                BackgroundVideoView.this.mSurfaceHolder = null;
                BackgroundVideoView.this.release(true);
            }
        };
        this.eCK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.2
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                BackgroundVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                BackgroundVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (BackgroundVideoView.this.mVideoWidth != 0 && BackgroundVideoView.this.mVideoHeight != 0) {
                    BackgroundVideoView.this.getHolder().setFixedSize(BackgroundVideoView.this.mVideoWidth, BackgroundVideoView.this.mVideoHeight);
                    BackgroundVideoView.this.requestLayout();
                }
                if (BackgroundVideoView.this.oxt != null) {
                    BackgroundVideoView.this.oxt.onVideoSizeChanged(mediaPlayer, i2, i3);
                }
            }
        };
        this.eCI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                BackgroundVideoView.this.cvb = 2;
                if (BackgroundVideoView.this.efH != null) {
                    BackgroundVideoView.this.efH.onPrepared(BackgroundVideoView.this.mMediaPlayer);
                }
                BackgroundVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                BackgroundVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (BackgroundVideoView.this.mVideoWidth != 0 && BackgroundVideoView.this.mVideoHeight != 0) {
                    BackgroundVideoView.this.getHolder().setFixedSize(BackgroundVideoView.this.mVideoWidth, BackgroundVideoView.this.mVideoHeight);
                }
                BackgroundVideoView.this.start();
            }
        };
        this.eCL = new MediaPlayer.OnErrorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.4
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                Log.d("BackgroundVideoView", "Error: " + i2 + "," + i3);
                BackgroundVideoView.this.cvb = -1;
                BackgroundVideoView.this.oxs = -1;
                if (BackgroundVideoView.this.efJ == null || BackgroundVideoView.this.efJ.onError(BackgroundVideoView.this.mMediaPlayer, i2, i3)) {
                }
                return true;
            }
        };
        this.nOT = new MediaPlayer.OnInfoListener() { // from class: com.baidu.tieba.yuyinala.liveroom.views.BackgroundVideoView.5
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
                if (BackgroundVideoView.this.oxu != null) {
                    BackgroundVideoView.this.oxu.onInfo(mediaPlayer, i2, i3);
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
        getHolder().addCallback(this.oxv);
        getHolder().setType(3);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.mUri = uri;
        bjy();
        requestLayout();
        invalidate();
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.cvb = 3;
        }
        this.oxs = 3;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.cvb = 4;
        }
        this.oxs = 4;
    }

    public void edV() {
        release(false);
    }

    private boolean isInPlaybackState() {
        return (this.mMediaPlayer == null || this.cvb == -1 || this.cvb == 0 || this.cvb == 1) ? false : true;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.cvb = 0;
            this.oxs = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjy() {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            release(false);
            try {
                this.mMediaPlayer = new MediaPlayer();
                this.mMediaPlayer.setDataSource(getContext(), this.mUri);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.setLooping(true);
                this.mMediaPlayer.setOnPreparedListener(this.eCI);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.eCK);
                this.mMediaPlayer.setOnErrorListener(this.eCL);
                this.mMediaPlayer.setOnInfoListener(this.nOT);
                this.mMediaPlayer.prepareAsync();
                this.cvb = 1;
            } catch (IOException e) {
                Log.w("BackgroundVideoView", "Unable to open content: " + this.mUri, e);
                this.cvb = -1;
                this.oxs = -1;
                this.eCL.onError(this.mMediaPlayer, 1, 0);
            } catch (IllegalArgumentException e2) {
                Log.w("BackgroundVideoView", "Unable to open content: " + this.mUri, e2);
                this.cvb = -1;
                this.oxs = -1;
                this.eCL.onError(this.mMediaPlayer, 1, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.cvb = 0;
            if (z) {
                this.oxs = 0;
            }
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.efJ = onErrorListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.oxu = onInfoListener;
    }
}
