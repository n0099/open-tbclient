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
    protected MediaPlayer aOZ;
    protected ScalableType gNG;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gNG = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.m.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gNG = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.aOZ != null) {
                this.aOZ.setSurface(surface);
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
        if (this.aOZ != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gNG)) != null) {
            setTransform(a);
        }
    }

    private void Oe() {
        if (this.aOZ == null) {
            this.aOZ = new MediaPlayer();
            this.aOZ.setOnVideoSizeChangedListener(this);
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
        Oe();
        this.aOZ.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Oe();
        this.aOZ.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Oe();
        this.aOZ.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Oe();
        this.aOZ.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Oe();
        this.aOZ.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gNG = scalableType;
        R(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aOZ != null) {
            this.aOZ.setOnPreparedListener(onPreparedListener);
            this.aOZ.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aOZ != null) {
            this.aOZ.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aOZ != null) {
            this.aOZ.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aOZ != null) {
            this.aOZ.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aOZ == null) {
            return 0;
        }
        return this.aOZ.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aOZ == null) {
            return 0;
        }
        return this.aOZ.getDuration();
    }

    public int getVideoHeight() {
        if (this.aOZ == null) {
            return 0;
        }
        return this.aOZ.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aOZ == null) {
            return 0;
        }
        return this.aOZ.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.aOZ == null) {
            return false;
        }
        return this.aOZ.isPlaying();
    }

    public void pause() {
        if (this.aOZ != null) {
            this.aOZ.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aOZ != null) {
            this.aOZ.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aOZ != null) {
            this.aOZ.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.aOZ != null) {
            this.aOZ.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.aOZ != null) {
            this.aOZ.start();
        }
    }

    public void stop() {
        if (this.aOZ != null) {
            this.aOZ.stop();
        }
    }

    public void reset() {
        if (this.aOZ != null) {
            this.aOZ.reset();
        }
    }

    public void release() {
        reset();
        if (this.aOZ != null) {
            this.aOZ.release();
            this.aOZ = null;
        }
    }
}
