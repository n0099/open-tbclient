package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.widget.MediaController;
import com.baidu.adp.lib.g.e;
import com.baidu.tieba.i.h;
import com.baidu.tieba.video.editvideo.b.c;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    MediaPlayer.OnPreparedListener aZF;
    private MediaPlayer bdf;
    private String bdg;
    MediaPlayer.OnPreparedListener bdl;
    private h gAg;
    private a gQR;
    MediaPlayer.OnVideoSizeChangedListener gQS;
    private final int gQT;
    private int gQU;
    public b gQV;
    private b gQW;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void c(Bitmap bitmap, boolean z);
    }

    static /* synthetic */ int f(MaskVideoView maskVideoView) {
        int i = maskVideoView.gQU;
        maskVideoView.gQU = i + 1;
        return i;
    }

    public void setPostMonitorManager(h hVar) {
        this.gAg = hVar;
    }

    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gQR = null;
        this.bdg = null;
        this.gQS = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                MaskVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                MaskVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (MaskVideoView.this.mVideoWidth != 0 && MaskVideoView.this.mVideoHeight != 0) {
                    MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.mVideoWidth, MaskVideoView.this.mVideoHeight);
                    MaskVideoView.this.requestLayout();
                }
            }
        };
        this.bdl = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (MaskVideoView.this.aZF != null) {
                    MaskVideoView.this.aZF.onPrepared(mediaPlayer);
                }
                MaskVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                MaskVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (MaskVideoView.this.mVideoWidth != 0 && MaskVideoView.this.mVideoHeight != 0) {
                    MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.mVideoWidth, MaskVideoView.this.mVideoHeight);
                }
            }
        };
        this.gQT = 10;
        this.gQU = 0;
        this.gQW = new b() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4
            @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
            public void c(final Bitmap bitmap, final boolean z) {
                if (MaskVideoView.this.gQV != null) {
                    e.fP().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaskVideoView.this.gQV.c(bitmap, z);
                        }
                    });
                }
            }
        };
        setEGLContextClientVersion(2);
        this.bdf = new MediaPlayer();
    }

    public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.gQR != null) {
            this.gQR.setFilter(aVar);
        }
    }

    public void releaseSource() {
        if (this.gQR != null) {
            this.gQR.releaseResource();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.gQR != null) {
            super.onPause();
            this.gQR.gRd = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.gQR != null) {
            super.onResume();
            this.gQR.gRc = false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.bdf.start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bBT();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.bdf.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.bdf.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bdf.seekTo(i);
    }

    public void vj(int i) {
        this.bdf.seekTo(i);
        vk(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk(final int i) {
        e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if ((MaskVideoView.this.gQR == null || !MaskVideoView.this.gQR.gRd) && MaskVideoView.this.gQU <= 10) {
                    if (MaskVideoView.this.bdf != null) {
                        try {
                            MaskVideoView.this.bdf.seekTo(i);
                        } catch (Exception e) {
                        }
                    }
                    MaskVideoView.this.requestRender();
                    MaskVideoView.f(MaskVideoView.this);
                    MaskVideoView.this.vk(i);
                    return;
                }
                MaskVideoView.this.gQU = 0;
            }
        }, 500L);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.bdf.isPlaying();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    @Deprecated
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return this.bdf.getAudioSessionId();
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * size) {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                } else if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * size) {
                    defaultSize2 = (this.mVideoHeight * size) / this.mVideoWidth;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.mVideoHeight * size) / this.mVideoWidth;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.mVideoWidth;
                int i5 = this.mVideoHeight;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.mVideoHeight * size) / this.mVideoWidth;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.aZF = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bdf.setOnCompletionListener(onCompletionListener);
    }

    public void stopPlayback() {
        if (this.bdf != null) {
            try {
                this.bdf.stop();
                this.bdf.release();
            } catch (Throwable th) {
                if (this.gAg != null) {
                    this.gAg.S(205, com.baidu.tieba.i.a.g(th));
                }
            }
            this.bdf = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void setVideoPath(String str) {
        try {
            this.bdf.setOnPreparedListener(this.bdl);
            this.bdf.setOnVideoSizeChangedListener(this.gQS);
            this.bdf.setDataSource(str);
            this.bdg = str;
            this.bdf.prepare();
            this.gQR = new a(getContext(), this, this.bdf);
            setRenderer(this.gQR);
            setRenderMode(0);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gAg != null) {
                this.gAg.S(204, com.baidu.tieba.i.a.g(e));
            }
        }
    }

    public void bBT() {
        if (this.bdf.isPlaying()) {
            this.bdf.pause();
        }
    }

    public void bBU() {
        this.bdf.start();
        this.bdf.seekTo(0);
    }

    public void v(Bitmap bitmap) {
        if (this.gQR != null) {
            this.gQR.v(bitmap);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
        private MediaPlayer bdf;
        private com.faceunity.gles.c gPm;
        private com.faceunity.gles.c gPn;
        private volatile boolean gRc;
        private volatile boolean gRd;
        private Context mContext;
        private int mFrameId;
        private GLSurfaceView mGLSurfaceView;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureId;
        private final String TAG = "MaskVideoRenderer";
        private final float[] mSTMatrix = new float[16];
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int gPl = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gPl};
        private String gPk = "normal";

        public a(Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            this.mContext = context;
            this.mGLSurfaceView = gLSurfaceView;
            this.bdf = mediaPlayer;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            bBV();
        }

        private void bBV() {
            this.gPm = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gPn = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mTextureId = this.gPn.createTextureObject();
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mFacebeautyItem = com.faceunity.a.cR(this.mContext);
            this.itemsArray[0] = this.mFacebeautyItem;
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            MaskVideoView.this.mSurfaceWidth = i;
            MaskVideoView.this.mSurfaceHeight = i2;
            this.bdf.setSurface(this.mSurface);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.gRc) {
                if (this.gPm == null) {
                    bBV();
                    this.bdf.setSurface(this.mSurface);
                }
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.gPk);
                int i = this.mTextureId;
                int i2 = MaskVideoView.this.mVideoWidth;
                int i3 = MaskVideoView.this.mVideoHeight;
                int i4 = this.mFrameId;
                this.mFrameId = i4 + 1;
                this.gPm.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.itemsArray), this.mSTMatrix);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.gRd = true;
            this.mGLSurfaceView.requestRender();
        }

        public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
            if (aVar != null) {
                this.gPk = aVar.value;
                this.mGLSurfaceView.requestRender();
            }
        }

        public void v(final Bitmap bitmap) {
            if ("normal".equals(this.gPk)) {
                MaskVideoView.this.gQW.c(bitmap, true);
            } else if (bitmap == null || bitmap.isRecycled()) {
                MaskVideoView.this.gQW.c(bitmap, false);
            } else {
                MaskVideoView.this.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<c.a> u = com.baidu.tieba.video.editvideo.b.c.u(bitmap);
                        byte[] t = com.baidu.tieba.video.editvideo.b.c.t(bitmap);
                        for (int i = 0; i < 3; i++) {
                            byte[] bArr = new byte[t.length];
                            System.arraycopy(t, 0, bArr, 0, t.length);
                            if (bArr == null || bArr.length == 0) {
                                MaskVideoView.this.gQW.c(bitmap, false);
                            }
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            faceunity.fuRenderToNV21Image(bArr, width, height, 0, a.this.itemsArray, 0);
                            Bitmap j = com.baidu.tieba.video.editvideo.b.c.j(bArr, width, height);
                            boolean a = com.baidu.tieba.video.editvideo.b.c.a(j, u);
                            if (a) {
                                MaskVideoView.this.gQW.c(j, true);
                                bitmap.recycle();
                                return;
                            }
                            if (!a && i < 2) {
                                if (j != null && !j.isRecycled()) {
                                    j.recycle();
                                }
                            } else if (!a && i == 2) {
                                MaskVideoView.this.gQW.c(bitmap, false);
                            }
                        }
                    }
                });
            }
        }

        public void releaseResource() {
            this.gRc = true;
            this.mGLSurfaceView.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gPm != null) {
                        a.this.gPm.release(false);
                        a.this.gPm = null;
                    }
                    faceunity.fuDestroyItem(a.this.mEffectItem);
                    a.this.itemsArray[1] = a.this.mEffectItem = 0;
                    faceunity.fuDestroyItem(a.this.mFacebeautyItem);
                    a.this.itemsArray[0] = a.this.mFacebeautyItem = 0;
                    faceunity.fuOnDeviceLost();
                }
            });
        }
    }

    public void setGenMaskCoverListener(b bVar) {
        if (bVar != null) {
            this.gQV = bVar;
        }
    }
}
