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
import com.baidu.tieba.d;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bAy;
    protected ScalableType jzX;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.jzX = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.jzX = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bAy != null) {
                this.bAy.setSurface(surface);
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
        if (this.bAy != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.jzX)) != null) {
            setTransform(a);
        }
    }

    private void aEK() {
        if (this.bAy == null) {
            this.bAy = new MediaPlayer();
            this.bAy.setOnVideoSizeChangedListener(this);
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
        aEK();
        this.bAy.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        aEK();
        this.bAy.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        aEK();
        this.bAy.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        aEK();
        this.bAy.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        aEK();
        this.bAy.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.jzX = scalableType;
        aD(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bAy != null) {
            this.bAy.setOnPreparedListener(onPreparedListener);
            this.bAy.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bAy != null) {
            this.bAy.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bAy != null) {
            this.bAy.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bAy != null) {
            this.bAy.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bAy == null) {
            return 0;
        }
        return this.bAy.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bAy == null) {
            return 0;
        }
        return this.bAy.getDuration();
    }

    public int getVideoHeight() {
        if (this.bAy == null) {
            return 0;
        }
        return this.bAy.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bAy == null) {
            return 0;
        }
        return this.bAy.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bAy == null) {
            return false;
        }
        return this.bAy.isPlaying();
    }

    public void pause() {
        if (this.bAy != null) {
            this.bAy.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bAy != null) {
            this.bAy.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bAy != null) {
            this.bAy.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bAy != null) {
            this.bAy.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bAy != null) {
            this.bAy.start();
        }
    }

    public void stop() {
        if (this.bAy != null) {
            this.bAy.stop();
        }
    }

    public void reset() {
        if (this.bAy != null) {
            this.bAy.reset();
        }
    }

    public void release() {
        reset();
        if (this.bAy != null) {
            this.bAy.release();
            this.bAy = null;
        }
    }
}
