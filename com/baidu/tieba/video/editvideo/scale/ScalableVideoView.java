package com.baidu.tieba.video.editvideo.scale;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.c;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bAa;
    protected ScalableType jwu;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.jwu = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.jwu = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bAa != null) {
                this.bAa.setSurface(surface);
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
        if (this.bAa != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        aD(i, i2);
    }

    private void aD(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.jwu)) != null) {
            setTransform(a);
        }
    }

    private void aEe() {
        if (this.bAa == null) {
            this.bAa = new MediaPlayer();
            this.bAa.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void setRawData(int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(TbadkCoreApplication.getInst().getResources().getAssets().openFd(str));
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    public void setDataSource(String str) throws IOException {
        aEe();
        this.bAa.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        aEe();
        this.bAa.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        aEe();
        this.bAa.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        aEe();
        this.bAa.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        aEe();
        this.bAa.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.jwu = scalableType;
        aD(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bAa != null) {
            this.bAa.setOnPreparedListener(onPreparedListener);
            this.bAa.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bAa != null) {
            this.bAa.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bAa != null) {
            this.bAa.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bAa != null) {
            this.bAa.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bAa == null) {
            return 0;
        }
        return this.bAa.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bAa == null) {
            return 0;
        }
        return this.bAa.getDuration();
    }

    public int getVideoHeight() {
        if (this.bAa == null) {
            return 0;
        }
        return this.bAa.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bAa == null) {
            return 0;
        }
        return this.bAa.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bAa == null) {
            return false;
        }
        return this.bAa.isPlaying();
    }

    public void pause() {
        if (this.bAa != null) {
            this.bAa.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bAa != null) {
            this.bAa.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bAa != null) {
            this.bAa.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bAa != null) {
            this.bAa.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bAa != null) {
            this.bAa.start();
        }
    }

    public void stop() {
        if (this.bAa != null) {
            this.bAa.stop();
        }
    }

    public void reset() {
        if (this.bAa != null) {
            this.bAa.reset();
        }
    }

    public void release() {
        reset();
        if (this.bAa != null) {
            this.bAa.release();
            this.bAa = null;
        }
    }
}
