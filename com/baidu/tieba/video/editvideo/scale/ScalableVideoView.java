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
import com.baidu.tieba.e;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer Wd;
    protected ScalableType hCD;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hCD = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(e.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hCD = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.Wd != null) {
                this.Wd.setSurface(surface);
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
        if (this.Wd != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        aa(i, i2);
    }

    private void aa(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hCD)) != null) {
            setTransform(a);
        }
    }

    private void Xk() {
        if (this.Wd == null) {
            this.Wd = new MediaPlayer();
            this.Wd.setOnVideoSizeChangedListener(this);
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
        Xk();
        this.Wd.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Xk();
        this.Wd.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Xk();
        this.Wd.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Xk();
        this.Wd.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Xk();
        this.Wd.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hCD = scalableType;
        aa(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.Wd != null) {
            this.Wd.setOnPreparedListener(onPreparedListener);
            this.Wd.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.Wd != null) {
            this.Wd.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.Wd != null) {
            this.Wd.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.Wd != null) {
            this.Wd.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.Wd == null) {
            return 0;
        }
        return this.Wd.getCurrentPosition();
    }

    public int getDuration() {
        if (this.Wd == null) {
            return 0;
        }
        return this.Wd.getDuration();
    }

    public int getVideoHeight() {
        if (this.Wd == null) {
            return 0;
        }
        return this.Wd.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.Wd == null) {
            return 0;
        }
        return this.Wd.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.Wd == null) {
            return false;
        }
        return this.Wd.isPlaying();
    }

    public void pause() {
        if (this.Wd != null) {
            this.Wd.pause();
        }
    }

    public void seekTo(int i) {
        if (this.Wd != null) {
            this.Wd.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.Wd != null) {
            this.Wd.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.Wd != null) {
            this.Wd.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.Wd != null) {
            this.Wd.start();
        }
    }

    public void stop() {
        if (this.Wd != null) {
            this.Wd.stop();
        }
    }

    public void reset() {
        if (this.Wd != null) {
            this.Wd.reset();
        }
    }

    public void release() {
        reset();
        if (this.Wd != null) {
            this.Wd.release();
            this.Wd = null;
        }
    }
}
