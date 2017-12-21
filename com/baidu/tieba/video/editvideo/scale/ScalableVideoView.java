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
    protected MediaPlayer bdk;
    protected ScalableType gSz;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gSz = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gSz = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bdk != null) {
                this.bdk.setSurface(surface);
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
        if (this.bdk != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        W(i, i2);
    }

    private void W(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gSz)) != null) {
            setTransform(a);
        }
    }

    private void Nz() {
        if (this.bdk == null) {
            this.bdk = new MediaPlayer();
            this.bdk.setOnVideoSizeChangedListener(this);
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
        this.bdk.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Nz();
        this.bdk.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Nz();
        this.bdk.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gSz = scalableType;
        W(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bdk != null) {
            this.bdk.setOnPreparedListener(onPreparedListener);
            this.bdk.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bdk != null) {
            this.bdk.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bdk != null) {
            this.bdk.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bdk != null) {
            this.bdk.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bdk == null) {
            return 0;
        }
        return this.bdk.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bdk == null) {
            return 0;
        }
        return this.bdk.getDuration();
    }

    public int getVideoHeight() {
        if (this.bdk == null) {
            return 0;
        }
        return this.bdk.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bdk == null) {
            return 0;
        }
        return this.bdk.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bdk == null) {
            return false;
        }
        return this.bdk.isPlaying();
    }

    public void pause() {
        if (this.bdk != null) {
            this.bdk.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bdk != null) {
            this.bdk.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bdk != null) {
            this.bdk.setLooping(z);
        }
    }

    public void start() {
        if (this.bdk != null) {
            this.bdk.start();
        }
    }

    public void stop() {
        if (this.bdk != null) {
            this.bdk.stop();
        }
    }

    public void reset() {
        if (this.bdk != null) {
            this.bdk.reset();
        }
    }

    public void release() {
        reset();
        if (this.bdk != null) {
            this.bdk.release();
            this.bdk = null;
        }
    }
}
