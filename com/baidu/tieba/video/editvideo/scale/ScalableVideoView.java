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
    protected MediaPlayer bQW;
    protected ScalableType hzB;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hzB = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hzB = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bQW != null) {
                this.bQW.setSurface(surface);
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
        if (this.bQW != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        aV(i, i2);
    }

    private void aV(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hzB)) != null) {
            setTransform(a);
        }
    }

    private void UY() {
        if (this.bQW == null) {
            this.bQW = new MediaPlayer();
            this.bQW.setOnVideoSizeChangedListener(this);
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
        UY();
        this.bQW.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        UY();
        this.bQW.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        UY();
        this.bQW.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hzB = scalableType;
        aV(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bQW != null) {
            this.bQW.setOnPreparedListener(onPreparedListener);
            this.bQW.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bQW != null) {
            this.bQW.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bQW != null) {
            this.bQW.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bQW != null) {
            this.bQW.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bQW == null) {
            return 0;
        }
        return this.bQW.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bQW == null) {
            return 0;
        }
        return this.bQW.getDuration();
    }

    public int getVideoHeight() {
        if (this.bQW == null) {
            return 0;
        }
        return this.bQW.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bQW == null) {
            return 0;
        }
        return this.bQW.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bQW == null) {
            return false;
        }
        return this.bQW.isPlaying();
    }

    public void pause() {
        if (this.bQW != null) {
            this.bQW.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bQW != null) {
            this.bQW.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bQW != null) {
            this.bQW.setLooping(z);
        }
    }

    public void start() {
        if (this.bQW != null) {
            this.bQW.start();
        }
    }

    public void stop() {
        if (this.bQW != null) {
            this.bQW.stop();
        }
    }

    public void reset() {
        if (this.bQW != null) {
            this.bQW.reset();
        }
    }

    public void release() {
        reset();
        if (this.bQW != null) {
            this.bQW.release();
            this.bQW = null;
        }
    }
}
