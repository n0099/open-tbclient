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
    protected MediaPlayer bsm;
    protected ScalableType iXx;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.iXx = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.iXx = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bsm != null) {
                this.bsm.setSurface(surface);
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
        if (this.bsm != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        ay(i, i2);
    }

    private void ay(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.iXx)) != null) {
            setTransform(a);
        }
    }

    private void axI() {
        if (this.bsm == null) {
            this.bsm = new MediaPlayer();
            this.bsm.setOnVideoSizeChangedListener(this);
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
        axI();
        this.bsm.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        axI();
        this.bsm.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        axI();
        this.bsm.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        axI();
        this.bsm.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        axI();
        this.bsm.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.iXx = scalableType;
        ay(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bsm != null) {
            this.bsm.setOnPreparedListener(onPreparedListener);
            this.bsm.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bsm != null) {
            this.bsm.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bsm != null) {
            this.bsm.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bsm != null) {
            this.bsm.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bsm == null) {
            return 0;
        }
        return this.bsm.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bsm == null) {
            return 0;
        }
        return this.bsm.getDuration();
    }

    public int getVideoHeight() {
        if (this.bsm == null) {
            return 0;
        }
        return this.bsm.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bsm == null) {
            return 0;
        }
        return this.bsm.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bsm == null) {
            return false;
        }
        return this.bsm.isPlaying();
    }

    public void pause() {
        if (this.bsm != null) {
            this.bsm.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bsm != null) {
            this.bsm.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bsm != null) {
            this.bsm.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bsm != null) {
            this.bsm.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bsm != null) {
            this.bsm.start();
        }
    }

    public void stop() {
        if (this.bsm != null) {
            this.bsm.stop();
        }
    }

    public void reset() {
        if (this.bsm != null) {
            this.bsm.reset();
        }
    }

    public void release() {
        reset();
        if (this.bsm != null) {
            this.bsm.release();
            this.bsm = null;
        }
    }
}
