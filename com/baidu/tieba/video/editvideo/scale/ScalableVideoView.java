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
    protected MediaPlayer Wm;
    protected ScalableType hGW;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hGW = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(e.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hGW = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.Wm != null) {
                this.Wm.setSurface(surface);
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
        if (this.Wm != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hGW)) != null) {
            setTransform(a);
        }
    }

    private void XJ() {
        if (this.Wm == null) {
            this.Wm = new MediaPlayer();
            this.Wm.setOnVideoSizeChangedListener(this);
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
        XJ();
        this.Wm.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        XJ();
        this.Wm.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        XJ();
        this.Wm.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        XJ();
        this.Wm.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        XJ();
        this.Wm.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hGW = scalableType;
        aa(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.Wm != null) {
            this.Wm.setOnPreparedListener(onPreparedListener);
            this.Wm.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.Wm != null) {
            this.Wm.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.Wm != null) {
            this.Wm.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.Wm != null) {
            this.Wm.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.Wm == null) {
            return 0;
        }
        return this.Wm.getCurrentPosition();
    }

    public int getDuration() {
        if (this.Wm == null) {
            return 0;
        }
        return this.Wm.getDuration();
    }

    public int getVideoHeight() {
        if (this.Wm == null) {
            return 0;
        }
        return this.Wm.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.Wm == null) {
            return 0;
        }
        return this.Wm.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.Wm == null) {
            return false;
        }
        return this.Wm.isPlaying();
    }

    public void pause() {
        if (this.Wm != null) {
            this.Wm.pause();
        }
    }

    public void seekTo(int i) {
        if (this.Wm != null) {
            this.Wm.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.Wm != null) {
            this.Wm.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.Wm != null) {
            this.Wm.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.Wm != null) {
            this.Wm.start();
        }
    }

    public void stop() {
        if (this.Wm != null) {
            this.Wm.stop();
        }
    }

    public void reset() {
        if (this.Wm != null) {
            this.Wm.reset();
        }
    }

    public void release() {
        reset();
        if (this.Wm != null) {
            this.Wm.release();
            this.Wm = null;
        }
    }
}
