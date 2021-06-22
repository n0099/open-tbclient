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
import com.baidu.tieba.R$styleable;
import d.a.o0.r3.i.g.a;
import d.a.o0.r3.i.g.b;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f21412e;

    /* renamed from: f  reason: collision with root package name */
    public ScalableType f21413f;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
    }

    public final void a() {
        if (this.f21412e == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f21412e = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        f();
    }

    public boolean b() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public void c() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.pause();
    }

    public void d(MediaPlayer.OnPreparedListener onPreparedListener) throws IOException, IllegalStateException {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnPreparedListener(onPreparedListener);
        this.f21412e.prepare();
    }

    public void e() {
        f();
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f21412e = null;
        }
    }

    public void f() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public final void g(int i2, int i3) {
        Matrix m;
        if (i2 == 0 || i3 == 0 || (m = new a(new b(getWidth(), getHeight()), new b(i2, i3)).m(this.f21413f)) == null) {
            return;
        }
        setTransform(m);
    }

    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getDuration();
    }

    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    public void h(int i2) {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
    }

    public void i() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.start();
    }

    public void j() {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.stop();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f21412e == null) {
            return;
        }
        if (b()) {
            j();
        }
        e();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        try {
            Surface surface = new Surface(surfaceTexture);
            if (this.f21412e != null) {
                this.f21412e.setSurface(surface);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        g(i2, i3);
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(TbadkCoreApplication.getInst().getResources().getAssets().openFd(str));
    }

    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setOnInfoListener(onInfoListener);
    }

    public void setRawData(int i2) throws IOException {
        setDataSource(getResources().openRawResourceFd(i2));
    }

    public void setScalableType(ScalableType scalableType) {
        this.f21413f = scalableType;
        g(getVideoWidth(), getVideoHeight());
    }

    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f21412e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.f21413f = ScalableType.NONE;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.videoScaleStyle, 0, 0)) == null) {
            return;
        }
        int i3 = obtainStyledAttributes.getInt(R$styleable.videoScaleStyle_videoScalableType, ScalableType.NONE.ordinal());
        obtainStyledAttributes.recycle();
        this.f21413f = ScalableType.values()[i3];
    }

    public void setDataSource(String str) throws IOException {
        a();
        this.f21412e.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        a();
        this.f21412e.setDataSource(context, uri, map);
    }

    public void setDataSource(Context context, Uri uri) throws IOException {
        a();
        this.f21412e.setDataSource(context, uri);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        a();
        this.f21412e.setDataSource(fileDescriptor, j, j2);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        a();
        this.f21412e.setDataSource(fileDescriptor);
    }
}
