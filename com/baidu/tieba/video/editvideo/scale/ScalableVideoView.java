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
    protected MediaPlayer bTq;
    protected ScalableType hqN;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hqN = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hqN = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bTq != null) {
                this.bTq.setSurface(surface);
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
        if (this.bTq != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hqN)) != null) {
            setTransform(a);
        }
    }

    private void VG() {
        if (this.bTq == null) {
            this.bTq = new MediaPlayer();
            this.bTq.setOnVideoSizeChangedListener(this);
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
        this.bTq.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        VG();
        this.bTq.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        VG();
        this.bTq.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hqN = scalableType;
        aV(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bTq != null) {
            this.bTq.setOnPreparedListener(onPreparedListener);
            this.bTq.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bTq != null) {
            this.bTq.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bTq != null) {
            this.bTq.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bTq != null) {
            this.bTq.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bTq == null) {
            return 0;
        }
        return this.bTq.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bTq == null) {
            return 0;
        }
        return this.bTq.getDuration();
    }

    public int getVideoHeight() {
        if (this.bTq == null) {
            return 0;
        }
        return this.bTq.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bTq == null) {
            return 0;
        }
        return this.bTq.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bTq == null) {
            return false;
        }
        return this.bTq.isPlaying();
    }

    public void pause() {
        if (this.bTq != null) {
            this.bTq.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bTq != null) {
            this.bTq.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bTq != null) {
            this.bTq.setLooping(z);
        }
    }

    public void start() {
        if (this.bTq != null) {
            this.bTq.start();
        }
    }

    public void stop() {
        if (this.bTq != null) {
            this.bTq.stop();
        }
    }

    public void reset() {
        if (this.bTq != null) {
            this.bTq.reset();
        }
    }

    public void release() {
        reset();
        if (this.bTq != null) {
            this.bTq.release();
            this.bTq = null;
        }
    }
}
