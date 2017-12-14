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
    protected MediaPlayer bdg;
    protected ScalableType gSu;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.gSu = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.gSu = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bdg != null) {
                this.bdg.setSurface(surface);
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
        if (this.bdg != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.gSu)) != null) {
            setTransform(a);
        }
    }

    private void Nz() {
        if (this.bdg == null) {
            this.bdg = new MediaPlayer();
            this.bdg.setOnVideoSizeChangedListener(this);
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
        this.bdg.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Nz();
        this.bdg.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Nz();
        this.bdg.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.gSu = scalableType;
        W(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bdg != null) {
            this.bdg.setOnPreparedListener(onPreparedListener);
            this.bdg.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bdg != null) {
            this.bdg.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bdg != null) {
            this.bdg.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bdg != null) {
            this.bdg.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bdg == null) {
            return 0;
        }
        return this.bdg.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bdg == null) {
            return 0;
        }
        return this.bdg.getDuration();
    }

    public int getVideoHeight() {
        if (this.bdg == null) {
            return 0;
        }
        return this.bdg.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bdg == null) {
            return 0;
        }
        return this.bdg.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bdg == null) {
            return false;
        }
        return this.bdg.isPlaying();
    }

    public void pause() {
        if (this.bdg != null) {
            this.bdg.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bdg != null) {
            this.bdg.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bdg != null) {
            this.bdg.setLooping(z);
        }
    }

    public void start() {
        if (this.bdg != null) {
            this.bdg.start();
        }
    }

    public void stop() {
        if (this.bdg != null) {
            this.bdg.stop();
        }
    }

    public void reset() {
        if (this.bdg != null) {
            this.bdg.reset();
        }
    }

    public void release() {
        reset();
        if (this.bdg != null) {
            this.bdg.release();
            this.bdg = null;
        }
    }
}
