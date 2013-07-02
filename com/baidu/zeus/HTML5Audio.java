package com.baidu.zeus;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class HTML5Audio extends Handler implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener {
    private static final String LOGTAG = "HTML5Audio";
    private static final int TIMEUPDATE = 100;
    private static final int TIMEUPDATE_PERIOD = 250;
    private MediaPlayer mMediaPlayer;
    private int mNativePointer;
    private java.util.Timer mTimer;
    private String mUrl;
    private static int IDLE = 0;
    private static int INITIALIZED = 1;
    private static int PREPARED = 2;
    private static int STARTED = 4;
    private static int COMPLETE = 5;
    private static int PAUSED = 6;
    private static int STOPPED = -2;
    private static int ERROR = -1;
    private int mState = IDLE;
    private boolean mAskToPlay = false;

    private native void nativeOnBuffering(int i, int i2);

    private native void nativeOnEnded(int i);

    private native void nativeOnPrepared(int i, int i2, int i3, int i4);

    private native void nativeOnTimeupdate(int i, int i2);

    /* loaded from: classes.dex */
    final class TimeupdateTask extends TimerTask {
        private TimeupdateTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            HTML5Audio.this.obtainMessage(100).sendToTarget();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                try {
                    if (this.mState != ERROR && this.mMediaPlayer.isPlaying()) {
                        nativeOnTimeupdate(this.mMediaPlayer.getCurrentPosition(), this.mNativePointer);
                        return;
                    }
                    return;
                } catch (IllegalStateException e) {
                    this.mState = ERROR;
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        nativeOnBuffering(i, this.mNativePointer);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        nativeOnEnded(this.mNativePointer);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.mState = ERROR;
        resetMediaPlayer();
        this.mState = IDLE;
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.mState = PREPARED;
        if (this.mTimer != null) {
            this.mTimer.schedule(new TimeupdateTask(), 250L, 250L);
        }
        nativeOnPrepared(mediaPlayer.getDuration(), 0, 0, this.mNativePointer);
        if (this.mAskToPlay) {
            this.mAskToPlay = false;
            play();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        nativeOnTimeupdate(mediaPlayer.getCurrentPosition(), this.mNativePointer);
    }

    public HTML5Audio(int i) {
        this.mNativePointer = i;
        resetMediaPlayer();
    }

    private void resetMediaPlayer() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
        } else {
            this.mMediaPlayer.reset();
        }
        this.mMediaPlayer.setOnBufferingUpdateListener(this);
        this.mMediaPlayer.setOnCompletionListener(this);
        this.mMediaPlayer.setOnErrorListener(this);
        this.mMediaPlayer.setOnPreparedListener(this);
        this.mMediaPlayer.setOnSeekCompleteListener(this);
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new java.util.Timer();
        this.mState = IDLE;
    }

    private void setDataSource(String str) {
        this.mUrl = str;
        try {
            if (this.mState != IDLE) {
                resetMediaPlayer();
            }
            this.mMediaPlayer.setDataSource(str);
            this.mState = INITIALIZED;
            this.mMediaPlayer.prepareAsync();
        } catch (IOException e) {
            Log.e(LOGTAG, "couldn't load the resource: " + str + " exc: " + e);
            resetMediaPlayer();
        }
    }

    private void play() {
        if ((this.mState == ERROR || this.mState == IDLE) && this.mUrl != null) {
            resetMediaPlayer();
            setDataSource(this.mUrl);
            this.mAskToPlay = true;
        }
        if (this.mState >= PREPARED) {
            this.mMediaPlayer.start();
            this.mState = STARTED;
        }
    }

    private void pause() {
        if (this.mState == STARTED) {
            if (this.mTimer != null) {
                this.mTimer.purge();
            }
            this.mMediaPlayer.pause();
            this.mState = PAUSED;
        }
    }

    private void seek(int i) {
        if (this.mState >= PREPARED) {
            this.mMediaPlayer.seekTo(i);
        }
    }

    private void teardown() {
        this.mMediaPlayer.release();
        this.mState = ERROR;
        this.mNativePointer = 0;
    }

    private float getMaxTimeSeekable() {
        return this.mMediaPlayer.getDuration() / 1000.0f;
    }
}
