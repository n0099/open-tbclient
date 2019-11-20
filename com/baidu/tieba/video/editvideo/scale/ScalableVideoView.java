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
import com.baidu.tieba.R;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bSn;
    protected ScalableType jyY;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.jyY = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.videoScaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.jyY = ScalableType.values()[i2];
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.bSn != null) {
                this.bSn.setSurface(surface);
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
        if (this.bSn != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        aC(i, i2);
    }

    private void aC(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.jyY)) != null) {
            setTransform(a);
        }
    }

    private void aET() {
        if (this.bSn == null) {
            this.bSn = new MediaPlayer();
            this.bSn.setOnVideoSizeChangedListener(this);
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
        aET();
        this.bSn.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        aET();
        this.bSn.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        aET();
        this.bSn.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        aET();
        this.bSn.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        aET();
        this.bSn.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.jyY = scalableType;
        aC(getVideoWidth(), getVideoHeight());
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        if (this.bSn != null) {
            this.bSn.setOnPreparedListener(onPreparedListener);
            this.bSn.prepare();
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        if (this.bSn != null) {
            this.bSn.setOnErrorListener(onErrorListener);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.bSn != null) {
            this.bSn.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.bSn != null) {
            this.bSn.setOnInfoListener(onInfoListener);
        }
    }

    public int getCurrentPosition() {
        if (this.bSn == null) {
            return 0;
        }
        return this.bSn.getCurrentPosition();
    }

    public int getDuration() {
        if (this.bSn == null) {
            return 0;
        }
        return this.bSn.getDuration();
    }

    public int getVideoHeight() {
        if (this.bSn == null) {
            return 0;
        }
        return this.bSn.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bSn == null) {
            return 0;
        }
        return this.bSn.getVideoWidth();
    }

    public boolean isPlaying() {
        if (this.bSn == null) {
            return false;
        }
        return this.bSn.isPlaying();
    }

    public void pause() {
        if (this.bSn != null) {
            this.bSn.pause();
        }
    }

    public void seekTo(int i) {
        if (this.bSn != null) {
            this.bSn.seekTo(i);
        }
    }

    public void setLooping(boolean z) {
        if (this.bSn != null) {
            this.bSn.setLooping(z);
        }
    }

    public void setVolume(float f, float f2) {
        if (this.bSn != null) {
            this.bSn.setVolume(f, f2);
        }
    }

    public void start() {
        if (this.bSn != null) {
            this.bSn.start();
        }
    }

    public void stop() {
        if (this.bSn != null) {
            this.bSn.stop();
        }
    }

    public void reset() {
        if (this.bSn != null) {
            this.bSn.reset();
        }
    }

    public void release() {
        reset();
        if (this.bSn != null) {
            this.bSn.release();
            this.bSn = null;
        }
    }
}
