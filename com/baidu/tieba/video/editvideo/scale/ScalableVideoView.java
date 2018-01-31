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
    protected MediaPlayer bRl;
    protected ScalableType hpy;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hpy = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hpy = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bRl != null) {
                this.bRl.setSurface(surface);
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
        if (this.bRl != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hpy)) != null) {
            setTransform(a);
        }
    }

    private void UO() {
        if (this.bRl == null) {
            this.bRl = new MediaPlayer();
            this.bRl.setOnVideoSizeChangedListener(this);
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
        UO();
        this.bRl.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        UO();
        this.bRl.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        UO();
        this.bRl.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hpy = scalableType;
        aV(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bRl != null) {
            this.bRl.setOnPreparedListener(onPreparedListener);
            this.bRl.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bRl != null) {
            this.bRl.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bRl != null) {
            this.bRl.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bRl != null) {
            this.bRl.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bRl == null) {
            return 0;
        }
        return this.bRl.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bRl == null) {
            return 0;
        }
        return this.bRl.getDuration();
    }

    public int getVideoHeight() {
        if (this.bRl == null) {
            return 0;
        }
        return this.bRl.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bRl == null) {
            return 0;
        }
        return this.bRl.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bRl == null) {
            return false;
        }
        return this.bRl.isPlaying();
    }

    public void pause() {
        if (this.bRl != null) {
            this.bRl.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bRl != null) {
            this.bRl.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bRl != null) {
            this.bRl.setLooping(z);
        }
    }

    public void start() {
        if (this.bRl != null) {
            this.bRl.start();
        }
    }

    public void stop() {
        if (this.bRl != null) {
            this.bRl.stop();
        }
    }

    public void reset() {
        if (this.bRl != null) {
            this.bRl.reset();
        }
    }

    public void release() {
        reset();
        if (this.bRl != null) {
            this.bRl.release();
            this.bRl = null;
        }
    }
}
