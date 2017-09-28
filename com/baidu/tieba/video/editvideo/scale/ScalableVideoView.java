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
    protected MediaPlayer aWt;
    protected ScalableType gvL;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gvL = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.n.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gvL = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.aWt != null) {
            this.aWt.setSurface(surface);
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

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        X(i, i2);
    }

    private void X(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gvL)) != null) {
            setTransform(a);
        }
    }

    private void MG() {
        if (this.aWt == null) {
            this.aWt = new MediaPlayer();
            this.aWt.setOnVideoSizeChangedListener(this);
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
        MG();
        this.aWt.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        MG();
        this.aWt.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        MG();
        this.aWt.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gvL = scalableType;
        X(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aWt != null) {
            this.aWt.setOnPreparedListener(onPreparedListener);
            this.aWt.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aWt != null) {
            this.aWt.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aWt != null) {
            this.aWt.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aWt != null) {
            this.aWt.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aWt == null) {
            return 0;
        }
        return this.aWt.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aWt == null) {
            return 0;
        }
        return this.aWt.getDuration();
    }

    public int getVideoHeight() {
        if (this.aWt == null) {
            return 0;
        }
        return this.aWt.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aWt == null) {
            return 0;
        }
        return this.aWt.getVideoWidth();
    }

    public void pause() {
        if (this.aWt != null) {
            this.aWt.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aWt != null) {
            this.aWt.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aWt != null) {
            this.aWt.setLooping(z);
        }
    }

    public void start() {
        if (this.aWt != null) {
            this.aWt.start();
        }
    }

    public void reset() {
        if (this.aWt != null) {
            this.aWt.reset();
        }
    }

    public void release() {
        reset();
        if (this.aWt != null) {
            this.aWt.release();
            this.aWt = null;
        }
    }
}
