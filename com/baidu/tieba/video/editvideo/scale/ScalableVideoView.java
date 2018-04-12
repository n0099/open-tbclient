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
import com.baidu.tieba.d;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer aOY;
    protected ScalableType gMG;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gMG = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.m.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gMG = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.aOY != null) {
                this.aOY.setSurface(surface);
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
        if (this.aOY != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        R(i, i2);
    }

    private void R(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gMG)) != null) {
            setTransform(a);
        }
    }

    private void Og() {
        if (this.aOY == null) {
            this.aOY = new MediaPlayer();
            this.aOY.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setRawData(int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    public void setDataSource(String str) throws IOException {
        Og();
        this.aOY.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Og();
        this.aOY.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Og();
        this.aOY.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Og();
        this.aOY.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Og();
        this.aOY.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gMG = scalableType;
        R(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aOY != null) {
            this.aOY.setOnPreparedListener(onPreparedListener);
            this.aOY.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aOY != null) {
            this.aOY.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aOY != null) {
            this.aOY.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aOY != null) {
            this.aOY.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aOY == null) {
            return 0;
        }
        return this.aOY.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aOY == null) {
            return 0;
        }
        return this.aOY.getDuration();
    }

    public int getVideoHeight() {
        if (this.aOY == null) {
            return 0;
        }
        return this.aOY.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aOY == null) {
            return 0;
        }
        return this.aOY.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.aOY == null) {
            return false;
        }
        return this.aOY.isPlaying();
    }

    public void pause() {
        if (this.aOY != null) {
            this.aOY.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aOY != null) {
            this.aOY.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aOY != null) {
            this.aOY.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.aOY != null) {
            this.aOY.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.aOY != null) {
            this.aOY.start();
        }
    }

    public void stop() {
        if (this.aOY != null) {
            this.aOY.stop();
        }
    }

    public void reset() {
        if (this.aOY != null) {
            this.aOY.reset();
        }
    }

    public void release() {
        reset();
        if (this.aOY != null) {
            this.aOY.release();
            this.aOY = null;
        }
    }
}
