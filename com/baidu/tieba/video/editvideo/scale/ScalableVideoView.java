package com.baidu.tieba.video.editvideo.scale;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes10.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected ScalableType lXn;
    protected MediaPlayer mMediaPlayer;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.lXn = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.lXn = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.mMediaPlayer != null) {
                this.mMediaPlayer.setSurface(surface);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mMediaPlayer != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        bo(i, i2);
    }

    private void bo(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.lXn)) != null) {
            setTransform(a);
        }
    }

    private void bqp() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setRawData(int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(TbadkCoreApplication.getInst().getResources().getAssets().openFd(str));
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    public void setDataSource(String str) throws IOException {
        bqp();
        this.mMediaPlayer.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        bqp();
        this.mMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        bqp();
        this.mMediaPlayer.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        bqp();
        this.mMediaPlayer.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        bqp();
        this.mMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.lXn = scalableType;
        bo(getVideoWidth(), getVideoHeight());
    }

    public void a(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
            this.mMediaPlayer.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.mMediaPlayer == null) {
            return 0;
        }
        return this.mMediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        if (this.mMediaPlayer == null) {
            return 0;
        }
        return this.mMediaPlayer.getDuration();
    }

    public int getVideoHeight() {
        if (this.mMediaPlayer == null) {
            return 0;
        }
        return this.mMediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.mMediaPlayer == null) {
            return 0;
        }
        return this.mMediaPlayer.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.mMediaPlayer == null) {
            return false;
        }
        return this.mMediaPlayer.isPlaying();
    }

    public void pause() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.pause();
        }
    }

    public void seekTo(int i) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.start();
        }
    }

    public void stop() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.stop();
        }
    }

    public void reset() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
        }
    }

    public void release() {
        reset();
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }
}
