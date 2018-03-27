package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
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
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    MediaPlayer.OnPreparedListener bPJ;
    private MediaPlayer bTh;
    private String bTi;
    MediaPlayer.OnPreparedListener bTn;
    private h hca;
    private a hsf;
    MediaPlayer.OnVideoSizeChangedListener hsg;
    private final int hsh;
    private int hsi;
    public b hsj;
    private b hsk;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void c(Bitmap bitmap, boolean z);
    }

    static /* synthetic */ int f(MaskVideoView maskVideoView) {
        int i = maskVideoView.hsi;
        maskVideoView.hsi = i + 1;
        return i;
    }

    public void setPostMonitorManager(h hVar) {
        this.hca = hVar;
    }

    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hsf = null;
        this.bTi = null;
        this.hsg = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.1
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
        this.bTn = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (MaskVideoView.this.bPJ != null) {
                    MaskVideoView.this.bPJ.onPrepared(mediaPlayer);
                }
                MaskVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                MaskVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (MaskVideoView.this.mVideoWidth != 0 && MaskVideoView.this.mVideoHeight != 0) {
                    MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.mVideoWidth, MaskVideoView.this.mVideoHeight);
                }
            }
        };
        this.hsh = 10;
        this.hsi = 0;
        this.hsk = new b() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4
            @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
            public void c(final Bitmap bitmap, final boolean z) {
                if (MaskVideoView.this.hsj != null) {
                    e.ns().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaskVideoView.this.hsj.c(bitmap, z);
                        }
                    });
                }
            }
        };
        setEGLContextClientVersion(2);
        this.bTh = new MediaPlayer();
        this.bTh.setOnPreparedListener(this.bTn);
        this.bTh.setOnVideoSizeChangedListener(this.hsg);
        this.hsf = new a(getContext(), this, this.bTh);
        setRenderer(this.hsf);
        setRenderMode(0);
    }

    public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.hsf != null) {
            this.hsf.setFilter(aVar);
        }
    }

    public void releaseSource() {
        if (this.hsf != null) {
            this.hsf.releaseResource();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.hsf != null) {
            super.onPause();
            this.hsf.hsr = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.hsf != null) {
            super.onResume();
            this.hsf.hsq = false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.bTh.start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bCi();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.bTh.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.bTh.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bTh.seekTo(i);
    }

    public void wM(int i) {
        this.bTh.seekTo(i);
        wN(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wN(final int i) {
        e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if ((MaskVideoView.this.hsf == null || !MaskVideoView.this.hsf.hsr) && MaskVideoView.this.hsi <= 10) {
                    if (MaskVideoView.this.bTh != null) {
                        try {
                            MaskVideoView.this.bTh.seekTo(i);
                        } catch (Exception e) {
                        }
                    }
                    MaskVideoView.this.requestRender();
                    MaskVideoView.f(MaskVideoView.this);
                    MaskVideoView.this.wN(i);
                    return;
                }
                MaskVideoView.this.hsi = 0;
            }
        }, 500L);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.bTh.isPlaying();
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
        return this.bTh.getAudioSessionId();
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
        this.bPJ = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bTh.setOnCompletionListener(onCompletionListener);
    }

    public void stopPlayback() {
        if (this.bTh != null) {
            try {
                this.bTh.stop();
                this.bTh.release();
            } catch (Throwable th) {
                if (this.hca != null) {
                    this.hca.W(HttpStatus.SC_RESET_CONTENT, com.baidu.tieba.i.a.i(th));
                }
            }
            this.bTh = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void setVideoPath(String str) {
        try {
            this.bTh.setDataSource(str);
            this.bTi = str;
            this.bTh.prepare();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hca != null) {
                this.hca.W(HttpStatus.SC_NO_CONTENT, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public void bCi() {
        if (this.bTh.isPlaying()) {
            this.bTh.pause();
        }
    }

    public void bCj() {
        this.bTh.start();
        this.bTh.seekTo(0);
    }

    public void z(Bitmap bitmap) {
        if (this.hsf != null) {
            this.hsf.z(bitmap);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
        private MediaPlayer bTh;
        private com.faceunity.gles.c hqA;
        private com.faceunity.gles.c hqz;
        private volatile boolean hsq;
        private volatile boolean hsr;
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
        private int hqy = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hqy};
        private String hqx = "normal";

        public a(Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            this.mContext = context;
            this.mGLSurfaceView = gLSurfaceView;
            this.bTh = mediaPlayer;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            bCk();
        }

        private void bCk() {
            this.hqz = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hqA = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mTextureId = this.hqA.createTextureObject();
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mFacebeautyItem = com.faceunity.a.cY(this.mContext);
            this.itemsArray[0] = this.mFacebeautyItem;
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            MaskVideoView.this.mSurfaceWidth = i;
            MaskVideoView.this.mSurfaceHeight = i2;
            this.bTh.setSurface(this.mSurface);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hsq) {
                if (this.hqz == null) {
                    bCk();
                    this.bTh.setSurface(this.mSurface);
                }
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                if (!TextUtils.isEmpty(this.hqx) && !this.hqx.equals("normal")) {
                    faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.hqx);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", 0.0d);
                int i = this.mTextureId;
                int i2 = MaskVideoView.this.mVideoWidth;
                int i3 = MaskVideoView.this.mVideoHeight;
                int i4 = this.mFrameId;
                this.mFrameId = i4 + 1;
                this.hqz.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.itemsArray), this.mSTMatrix);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.hsr = true;
            this.mGLSurfaceView.requestRender();
        }

        public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
            if (aVar != null) {
                this.hqx = aVar.value;
                this.mGLSurfaceView.requestRender();
            }
        }

        public void z(final Bitmap bitmap) {
            if ("normal".equals(this.hqx)) {
                MaskVideoView.this.hsk.c(bitmap, true);
            } else if (bitmap == null || bitmap.isRecycled()) {
                MaskVideoView.this.hsk.c(bitmap, false);
            } else {
                MaskVideoView.this.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<c.a> y = com.baidu.tieba.video.editvideo.b.c.y(bitmap);
                        byte[] x = com.baidu.tieba.video.editvideo.b.c.x(bitmap);
                        for (int i = 0; i < 3; i++) {
                            byte[] bArr = new byte[x.length];
                            System.arraycopy(x, 0, bArr, 0, x.length);
                            if (bArr == null || bArr.length == 0) {
                                MaskVideoView.this.hsk.c(bitmap, false);
                            }
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            faceunity.fuRenderToNV21Image(bArr, width, height, 0, a.this.itemsArray, 0);
                            Bitmap j = com.baidu.tieba.video.editvideo.b.c.j(bArr, width, height);
                            boolean a = com.baidu.tieba.video.editvideo.b.c.a(j, y);
                            if (a) {
                                MaskVideoView.this.hsk.c(j, true);
                                bitmap.recycle();
                                return;
                            }
                            if (!a && i < 2) {
                                if (j != null && !j.isRecycled()) {
                                    j.recycle();
                                }
                            } else if (!a && i == 2) {
                                MaskVideoView.this.hsk.c(bitmap, false);
                            }
                        }
                    }
                });
            }
        }

        public void releaseResource() {
            this.hsq = true;
            this.mGLSurfaceView.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hqz != null) {
                        a.this.hqz.release(false);
                        a.this.hqz = null;
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
            this.hsj = bVar;
        }
    }
}
