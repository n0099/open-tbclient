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
/* loaded from: classes2.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bbp;
    protected ScalableType hms;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hms = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(e.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hms = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bbp != null) {
                this.bbp.setSurface(surface);
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
        if (this.bbp != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        Y(i, i2);
    }

    private void Y(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hms)) != null) {
            setTransform(a);
        }
    }

    private void TZ() {
        if (this.bbp == null) {
            this.bbp = new MediaPlayer();
            this.bbp.setOnVideoSizeChangedListener(this);
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
        TZ();
        this.bbp.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        TZ();
        this.bbp.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        TZ();
        this.bbp.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        TZ();
        this.bbp.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        TZ();
        this.bbp.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hms = scalableType;
        Y(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bbp != null) {
            this.bbp.setOnPreparedListener(onPreparedListener);
            this.bbp.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bbp != null) {
            this.bbp.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bbp != null) {
            this.bbp.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bbp != null) {
            this.bbp.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bbp == null) {
            return 0;
        }
        return this.bbp.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bbp == null) {
            return 0;
        }
        return this.bbp.getDuration();
    }

    public int getVideoHeight() {
        if (this.bbp == null) {
            return 0;
        }
        return this.bbp.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bbp == null) {
            return 0;
        }
        return this.bbp.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bbp == null) {
            return false;
        }
        return this.bbp.isPlaying();
    }

    public void pause() {
        if (this.bbp != null) {
            this.bbp.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bbp != null) {
            this.bbp.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bbp != null) {
            this.bbp.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bbp != null) {
            this.bbp.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bbp != null) {
            this.bbp.start();
        }
    }

    public void stop() {
        if (this.bbp != null) {
            this.bbp.stop();
        }
    }

    public void reset() {
        if (this.bbp != null) {
            this.bbp.reset();
        }
    }

    public void release() {
        reset();
        if (this.bbp != null) {
            this.bbp.release();
            this.bbp = null;
        }
    }
}
