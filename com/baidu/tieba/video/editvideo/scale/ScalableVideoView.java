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
    protected MediaPlayer bsq;
    protected ScalableType iXm;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.iXm = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(d.l.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.iXm = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bsq != null) {
                this.bsq.setSurface(surface);
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
        if (this.bsq != null) {
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
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.iXm)) != null) {
            setTransform(a);
        }
    }

    private void axF() {
        if (this.bsq == null) {
            this.bsq = new MediaPlayer();
            this.bsq.setOnVideoSizeChangedListener(this);
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
        axF();
        this.bsq.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        axF();
        this.bsq.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        axF();
        this.bsq.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        axF();
        this.bsq.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        axF();
        this.bsq.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.iXm = scalableType;
        ay(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bsq != null) {
            this.bsq.setOnPreparedListener(onPreparedListener);
            this.bsq.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bsq != null) {
            this.bsq.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bsq != null) {
            this.bsq.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bsq != null) {
            this.bsq.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bsq == null) {
            return 0;
        }
        return this.bsq.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bsq == null) {
            return 0;
        }
        return this.bsq.getDuration();
    }

    public int getVideoHeight() {
        if (this.bsq == null) {
            return 0;
        }
        return this.bsq.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bsq == null) {
            return 0;
        }
        return this.bsq.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bsq == null) {
            return false;
        }
        return this.bsq.isPlaying();
    }

    public void pause() {
        if (this.bsq != null) {
            this.bsq.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bsq != null) {
            this.bsq.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bsq != null) {
            this.bsq.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bsq != null) {
            this.bsq.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bsq != null) {
            this.bsq.start();
        }
    }

    public void stop() {
        if (this.bsq != null) {
            this.bsq.stop();
        }
    }

    public void reset() {
        if (this.bsq != null) {
            this.bsq.reset();
        }
    }

    public void release() {
        reset();
        if (this.bsq != null) {
            this.bsq.release();
            this.bsq = null;
        }
    }
}
