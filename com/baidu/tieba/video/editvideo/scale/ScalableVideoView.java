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
    protected MediaPlayer bzd;
    protected ScalableType jqm;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.jqm = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.jqm = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bzd != null) {
                this.bzd.setSurface(surface);
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
        if (this.bzd != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.jqm)) != null) {
            setTransform(a);
        }
    }

    private void aCO() {
        if (this.bzd == null) {
            this.bzd = new MediaPlayer();
            this.bzd.setOnVideoSizeChangedListener(this);
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
        aCO();
        this.bzd.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        aCO();
        this.bzd.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        aCO();
        this.bzd.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        aCO();
        this.bzd.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        aCO();
        this.bzd.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.jqm = scalableType;
        ay(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bzd != null) {
            this.bzd.setOnPreparedListener(onPreparedListener);
            this.bzd.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bzd != null) {
            this.bzd.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bzd != null) {
            this.bzd.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bzd != null) {
            this.bzd.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bzd == null) {
            return 0;
        }
        return this.bzd.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bzd == null) {
            return 0;
        }
        return this.bzd.getDuration();
    }

    public int getVideoHeight() {
        if (this.bzd == null) {
            return 0;
        }
        return this.bzd.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bzd == null) {
            return 0;
        }
        return this.bzd.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bzd == null) {
            return false;
        }
        return this.bzd.isPlaying();
    }

    public void pause() {
        if (this.bzd != null) {
            this.bzd.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bzd != null) {
            this.bzd.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bzd != null) {
            this.bzd.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bzd != null) {
            this.bzd.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bzd != null) {
            this.bzd.start();
        }
    }

    public void stop() {
        if (this.bzd != null) {
            this.bzd.stop();
        }
    }

    public void reset() {
        if (this.bzd != null) {
            this.bzd.reset();
        }
    }

    public void release() {
        reset();
        if (this.bzd != null) {
            this.bzd.release();
            this.bzd = null;
        }
    }
}
