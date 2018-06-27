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
import com.baidu.tieba.d;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes2.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer aXQ;
    protected ScalableType hdn;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.hdn = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.m.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.hdn = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.aXQ != null) {
                this.aXQ.setSurface(surface);
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
        if (this.aXQ != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        S(i, i2);
    }

    private void S(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.hdn)) != null) {
            setTransform(a);
        }
    }

    private void Sa() {
        if (this.aXQ == null) {
            this.aXQ = new MediaPlayer();
            this.aXQ.setOnVideoSizeChangedListener(this);
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
        Sa();
        this.aXQ.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        Sa();
        this.aXQ.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        Sa();
        this.aXQ.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Sa();
        this.aXQ.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Sa();
        this.aXQ.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.hdn = scalableType;
        S(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.aXQ != null) {
            this.aXQ.setOnPreparedListener(onPreparedListener);
            this.aXQ.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.aXQ != null) {
            this.aXQ.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.aXQ != null) {
            this.aXQ.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.aXQ != null) {
            this.aXQ.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.aXQ == null) {
            return 0;
        }
        return this.aXQ.getCurrentPosition();
    }

    public int getDuration() {
        if (this.aXQ == null) {
            return 0;
        }
        return this.aXQ.getDuration();
    }

    public int getVideoHeight() {
        if (this.aXQ == null) {
            return 0;
        }
        return this.aXQ.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.aXQ == null) {
            return 0;
        }
        return this.aXQ.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.aXQ == null) {
            return false;
        }
        return this.aXQ.isPlaying();
    }

    public void pause() {
        if (this.aXQ != null) {
            this.aXQ.pause();
        }
    }

    public void seekTo(int i) {
        if (this.aXQ != null) {
            this.aXQ.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.aXQ != null) {
            this.aXQ.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.aXQ != null) {
            this.aXQ.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.aXQ != null) {
            this.aXQ.start();
        }
    }

    public void stop() {
        if (this.aXQ != null) {
            this.aXQ.stop();
        }
    }

    public void reset() {
        if (this.aXQ != null) {
            this.aXQ.reset();
        }
    }

    public void release() {
        reset();
        if (this.aXQ != null) {
            this.aXQ.release();
            this.aXQ = null;
        }
    }
}
