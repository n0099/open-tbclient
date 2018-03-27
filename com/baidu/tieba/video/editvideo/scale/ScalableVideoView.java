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
    protected MediaPlayer bTh;
    protected ScalableType hqY;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hqY = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hqY = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bTh != null) {
                this.bTh.setSurface(surface);
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
        if (this.bTh != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hqY)) != null) {
            setTransform(a);
        }
    }

    private void VG() {
        if (this.bTh == null) {
            this.bTh = new MediaPlayer();
            this.bTh.setOnVideoSizeChangedListener(this);
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
        VG();
        this.bTh.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        VG();
        this.bTh.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        VG();
        this.bTh.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hqY = scalableType;
        aV(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bTh != null) {
            this.bTh.setOnPreparedListener(onPreparedListener);
            this.bTh.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bTh != null) {
            this.bTh.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bTh != null) {
            this.bTh.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bTh != null) {
            this.bTh.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bTh == null) {
            return 0;
        }
        return this.bTh.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bTh == null) {
            return 0;
        }
        return this.bTh.getDuration();
    }

    public int getVideoHeight() {
        if (this.bTh == null) {
            return 0;
        }
        return this.bTh.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bTh == null) {
            return 0;
        }
        return this.bTh.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bTh == null) {
            return false;
        }
        return this.bTh.isPlaying();
    }

    public void pause() {
        if (this.bTh != null) {
            this.bTh.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bTh != null) {
            this.bTh.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bTh != null) {
            this.bTh.setLooping(z);
        }
    }

    public void start() {
        if (this.bTh != null) {
            this.bTh.start();
        }
    }

    public void stop() {
        if (this.bTh != null) {
            this.bTh.stop();
        }
    }

    public void reset() {
        if (this.bTh != null) {
            this.bTh.reset();
        }
    }

    public void release() {
        reset();
        if (this.bTh != null) {
            this.bTh.release();
            this.bTh = null;
        }
    }
}
