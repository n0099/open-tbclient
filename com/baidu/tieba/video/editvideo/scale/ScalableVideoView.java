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
    protected MediaPlayer aZT;
    protected ScalableType gFI;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gFI = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gFI = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.aZT != null) {
                this.aZT.setSurface(surface);
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
        if (this.aZT != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gFI)) != null) {
            setTransform(a);
        }
    }

    private void MV() {
        if (this.aZT == null) {
            this.aZT = new MediaPlayer();
            this.aZT.setOnVideoSizeChangedListener(this);
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
        MV();
        this.aZT.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        MV();
        this.aZT.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        MV();
        this.aZT.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gFI = scalableType;
        W(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aZT != null) {
            this.aZT.setOnPreparedListener(onPreparedListener);
            this.aZT.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aZT != null) {
            this.aZT.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aZT != null) {
            this.aZT.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aZT != null) {
            this.aZT.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aZT == null) {
            return 0;
        }
        return this.aZT.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aZT == null) {
            return 0;
        }
        return this.aZT.getDuration();
    }

    public int getVideoHeight() {
        if (this.aZT == null) {
            return 0;
        }
        return this.aZT.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aZT == null) {
            return 0;
        }
        return this.aZT.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.aZT == null) {
            return false;
        }
        return this.aZT.isPlaying();
    }

    public void pause() {
        if (this.aZT != null) {
            this.aZT.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aZT != null) {
            this.aZT.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aZT != null) {
            this.aZT.setLooping(z);
        }
    }

    public void start() {
        if (this.aZT != null) {
            this.aZT.start();
        }
    }

    public void stop() {
        if (this.aZT != null) {
            this.aZT.stop();
        }
    }

    public void reset() {
        if (this.aZT != null) {
            this.aZT.reset();
        }
    }

    public void release() {
        reset();
        if (this.aZT != null) {
            this.aZT.release();
            this.aZT = null;
        }
    }
}
