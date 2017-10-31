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
    protected MediaPlayer aZK;
    protected ScalableType gEA;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gEA = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gEA = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.aZK != null) {
                this.aZK.setSurface(surface);
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
        if (this.aZK != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gEA)) != null) {
            setTransform(a);
        }
    }

    private void MK() {
        if (this.aZK == null) {
            this.aZK = new MediaPlayer();
            this.aZK.setOnVideoSizeChangedListener(this);
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
        MK();
        this.aZK.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        MK();
        this.aZK.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        MK();
        this.aZK.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gEA = scalableType;
        W(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aZK != null) {
            this.aZK.setOnPreparedListener(onPreparedListener);
            this.aZK.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aZK != null) {
            this.aZK.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aZK != null) {
            this.aZK.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aZK != null) {
            this.aZK.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aZK == null) {
            return 0;
        }
        return this.aZK.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aZK == null) {
            return 0;
        }
        return this.aZK.getDuration();
    }

    public int getVideoHeight() {
        if (this.aZK == null) {
            return 0;
        }
        return this.aZK.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aZK == null) {
            return 0;
        }
        return this.aZK.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.aZK == null) {
            return false;
        }
        return this.aZK.isPlaying();
    }

    public void pause() {
        if (this.aZK != null) {
            this.aZK.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aZK != null) {
            this.aZK.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aZK != null) {
            this.aZK.setLooping(z);
        }
    }

    public void start() {
        if (this.aZK != null) {
            this.aZK.start();
        }
    }

    public void stop() {
        if (this.aZK != null) {
            this.aZK.stop();
        }
    }

    public void reset() {
        if (this.aZK != null) {
            this.aZK.reset();
        }
    }

    public void release() {
        reset();
        if (this.aZK != null) {
            this.aZK.release();
            this.aZK = null;
        }
    }
}
