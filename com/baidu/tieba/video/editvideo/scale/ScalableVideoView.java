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
    protected MediaPlayer bTe;
    protected ScalableType hqA;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hqA = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hqA = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bTe != null) {
                this.bTe.setSurface(surface);
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
        if (this.bTe != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hqA)) != null) {
            setTransform(a);
        }
    }

    private void VF() {
        if (this.bTe == null) {
            this.bTe = new MediaPlayer();
            this.bTe.setOnVideoSizeChangedListener(this);
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
        VF();
        this.bTe.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        VF();
        this.bTe.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        VF();
        this.bTe.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hqA = scalableType;
        aV(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bTe != null) {
            this.bTe.setOnPreparedListener(onPreparedListener);
            this.bTe.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bTe != null) {
            this.bTe.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bTe != null) {
            this.bTe.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bTe != null) {
            this.bTe.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bTe == null) {
            return 0;
        }
        return this.bTe.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bTe == null) {
            return 0;
        }
        return this.bTe.getDuration();
    }

    public int getVideoHeight() {
        if (this.bTe == null) {
            return 0;
        }
        return this.bTe.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bTe == null) {
            return 0;
        }
        return this.bTe.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bTe == null) {
            return false;
        }
        return this.bTe.isPlaying();
    }

    public void pause() {
        if (this.bTe != null) {
            this.bTe.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bTe != null) {
            this.bTe.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bTe != null) {
            this.bTe.setLooping(z);
        }
    }

    public void start() {
        if (this.bTe != null) {
            this.bTe.start();
        }
    }

    public void stop() {
        if (this.bTe != null) {
            this.bTe.stop();
        }
    }

    public void reset() {
        if (this.bTe != null) {
            this.bTe.reset();
        }
    }

    public void release() {
        reset();
        if (this.bTe != null) {
            this.bTe.release();
            this.bTe = null;
        }
    }
}
