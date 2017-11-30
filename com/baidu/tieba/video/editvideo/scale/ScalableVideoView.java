package com.baidu.tieba.video.editvideo.scale;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.tieba.d;
import java.io.FileDescriptor;
import java.io.IOException;
/* loaded from: classes2.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bdf;
    protected ScalableType gPL;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gPL = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gPL = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bdf != null) {
                this.bdf.setSurface(surface);
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
        if (this.bdf != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        V(i, i2);
    }

    private void V(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gPL)) != null) {
            setTransform(a);
        }
    }

    private void Nz() {
        if (this.bdf == null) {
            this.bdf = new MediaPlayer();
            this.bdf.setOnVideoSizeChangedListener(this);
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
        Nz();
        this.bdf.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Nz();
        this.bdf.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Nz();
        this.bdf.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gPL = scalableType;
        V(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bdf != null) {
            this.bdf.setOnPreparedListener(onPreparedListener);
            this.bdf.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bdf != null) {
            this.bdf.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bdf != null) {
            this.bdf.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bdf != null) {
            this.bdf.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bdf == null) {
            return 0;
        }
        return this.bdf.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bdf == null) {
            return 0;
        }
        return this.bdf.getDuration();
    }

    public int getVideoHeight() {
        if (this.bdf == null) {
            return 0;
        }
        return this.bdf.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bdf == null) {
            return 0;
        }
        return this.bdf.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bdf == null) {
            return false;
        }
        return this.bdf.isPlaying();
    }

    public void pause() {
        if (this.bdf != null) {
            this.bdf.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bdf != null) {
            this.bdf.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bdf != null) {
            this.bdf.setLooping(z);
        }
    }

    public void start() {
        if (this.bdf != null) {
            this.bdf.start();
        }
    }

    public void stop() {
        if (this.bdf != null) {
            this.bdf.stop();
        }
    }

    public void reset() {
        if (this.bdf != null) {
            this.bdf.reset();
        }
    }

    public void release() {
        reset();
        if (this.bdf != null) {
            this.bdf.release();
            this.bdf = null;
        }
    }
}
