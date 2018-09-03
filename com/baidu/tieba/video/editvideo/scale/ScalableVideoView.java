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
import com.baidu.tieba.f;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer aXW;
    protected ScalableType heA;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.heA = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(f.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.heA = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.aXW != null) {
                this.aXW.setSurface(surface);
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
        if (this.aXW != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        U(i, i2);
    }

    private void U(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.heA)) != null) {
            setTransform(a);
        }
    }

    private void Sm() {
        if (this.aXW == null) {
            this.aXW = new MediaPlayer();
            this.aXW.setOnVideoSizeChangedListener(this);
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
        Sm();
        this.aXW.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Sm();
        this.aXW.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Sm();
        this.aXW.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Sm();
        this.aXW.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Sm();
        this.aXW.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.heA = scalableType;
        U(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aXW != null) {
            this.aXW.setOnPreparedListener(onPreparedListener);
            this.aXW.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aXW != null) {
            this.aXW.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aXW != null) {
            this.aXW.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aXW != null) {
            this.aXW.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aXW == null) {
            return 0;
        }
        return this.aXW.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aXW == null) {
            return 0;
        }
        return this.aXW.getDuration();
    }

    public int getVideoHeight() {
        if (this.aXW == null) {
            return 0;
        }
        return this.aXW.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aXW == null) {
            return 0;
        }
        return this.aXW.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.aXW == null) {
            return false;
        }
        return this.aXW.isPlaying();
    }

    public void pause() {
        if (this.aXW != null) {
            this.aXW.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aXW != null) {
            this.aXW.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aXW != null) {
            this.aXW.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.aXW != null) {
            this.aXW.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.aXW != null) {
            this.aXW.start();
        }
    }

    public void stop() {
        if (this.aXW != null) {
            this.aXW.stop();
        }
    }

    public void reset() {
        if (this.aXW != null) {
            this.aXW.reset();
        }
    }

    public void release() {
        reset();
        if (this.aXW != null) {
            this.aXW.release();
            this.aXW = null;
        }
    }
}
