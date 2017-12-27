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
    MediaPlayer.OnPreparedListener bNv;
    private MediaPlayer bQW;
    private String bQX;
    MediaPlayer.OnPreparedListener bRc;
    private a hAI;
    MediaPlayer.OnVideoSizeChangedListener hAJ;
    private final int hAK;
    private int hAL;
    public b hAM;
    private b hAN;
    private h hjJ;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void c(Bitmap bitmap, boolean z);
    }

    static /* synthetic */ int f(MaskVideoView maskVideoView) {
        int i = maskVideoView.hAL;
        maskVideoView.hAL = i + 1;
        return i;
    }

    public void setPostMonitorManager(h hVar) {
        this.hjJ = hVar;
    }

    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAI = null;
        this.bQX = null;
        this.hAJ = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.1
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
        this.bRc = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (MaskVideoView.this.bNv != null) {
                    MaskVideoView.this.bNv.onPrepared(mediaPlayer);
                }
                MaskVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                MaskVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (MaskVideoView.this.mVideoWidth != 0 && MaskVideoView.this.mVideoHeight != 0) {
                    MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.mVideoWidth, MaskVideoView.this.mVideoHeight);
                }
            }
        };
        this.hAK = 10;
        this.hAL = 0;
        this.hAN = new b() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4
            @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
            public void c(final Bitmap bitmap, final boolean z) {
                if (MaskVideoView.this.hAM != null) {
                    e.nr().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaskVideoView.this.hAM.c(bitmap, z);
                        }
                    });
                }
            }
        };
        setEGLContextClientVersion(2);
        this.bQW = new MediaPlayer();
        this.bQW.setOnPreparedListener(this.bRc);
        this.bQW.setOnVideoSizeChangedListener(this.hAJ);
        this.hAI = new a(getContext(), this, this.bQW);
        setRenderer(this.hAI);
        setRenderMode(0);
    }

    public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.hAI != null) {
            this.hAI.setFilter(aVar);
        }
    }

    public void releaseSource() {
        if (this.hAI != null) {
            this.hAI.releaseResource();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.hAI != null) {
            super.onPause();
            this.hAI.hAU = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.hAI != null) {
            super.onResume();
            this.hAI.hAT = false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.bQW.start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bHW();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.bQW.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.bQW.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.bQW.seekTo(i);
    }

    public void yk(int i) {
        this.bQW.seekTo(i);
        yl(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(final int i) {
        e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if ((MaskVideoView.this.hAI == null || !MaskVideoView.this.hAI.hAU) && MaskVideoView.this.hAL <= 10) {
                    if (MaskVideoView.this.bQW != null) {
                        try {
                            MaskVideoView.this.bQW.seekTo(i);
                        } catch (Exception e) {
                        }
                    }
                    MaskVideoView.this.requestRender();
                    MaskVideoView.f(MaskVideoView.this);
                    MaskVideoView.this.yl(i);
                    return;
                }
                MaskVideoView.this.hAL = 0;
            }
        }, 500L);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.bQW.isPlaying();
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
        return this.bQW.getAudioSessionId();
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
        this.bNv = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bQW.setOnCompletionListener(onCompletionListener);
    }

    public void stopPlayback() {
        if (this.bQW != null) {
            try {
                this.bQW.stop();
                this.bQW.release();
            } catch (Throwable th) {
                if (this.hjJ != null) {
                    this.hjJ.R(HttpStatus.SC_RESET_CONTENT, com.baidu.tieba.i.a.i(th));
                }
            }
            this.bQW = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void setVideoPath(String str) {
        try {
            this.bQW.setDataSource(str);
            this.bQX = str;
            this.bQW.prepare();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.hjJ != null) {
                this.hjJ.R(HttpStatus.SC_NO_CONTENT, com.baidu.tieba.i.a.i(e));
            }
        }
    }

    public void bHW() {
        if (this.bQW.isPlaying()) {
            this.bQW.pause();
        }
    }

    public void bHX() {
        this.bQW.start();
        this.bQW.seekTo(0);
    }

    public void w(Bitmap bitmap) {
        if (this.hAI != null) {
            this.hAI.w(bitmap);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
        private MediaPlayer bQW;
        private volatile boolean hAT;
        private volatile boolean hAU;
        private com.faceunity.gles.c hzc;
        private com.faceunity.gles.c hzd;
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
        private int hzb = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.hzb};
        private String hza = "normal";

        public a(Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            this.mContext = context;
            this.mGLSurfaceView = gLSurfaceView;
            this.bQW = mediaPlayer;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            bHY();
        }

        private void bHY() {
            this.hzc = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.hzd = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mTextureId = this.hzd.createTextureObject();
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mFacebeautyItem = com.faceunity.a.cA(this.mContext);
            this.itemsArray[0] = this.mFacebeautyItem;
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            MaskVideoView.this.mSurfaceWidth = i;
            MaskVideoView.this.mSurfaceHeight = i2;
            this.bQW.setSurface(this.mSurface);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.hAT) {
                if (this.hzc == null) {
                    bHY();
                    this.bQW.setSurface(this.mSurface);
                }
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                if (!TextUtils.isEmpty(this.hza) && !this.hza.equals("normal")) {
                    faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.hza);
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
                this.hzc.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.itemsArray), this.mSTMatrix);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.hAU = true;
            this.mGLSurfaceView.requestRender();
        }

        public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
            if (aVar != null) {
                this.hza = aVar.value;
                this.mGLSurfaceView.requestRender();
            }
        }

        public void w(final Bitmap bitmap) {
            if ("normal".equals(this.hza)) {
                MaskVideoView.this.hAN.c(bitmap, true);
            } else if (bitmap == null || bitmap.isRecycled()) {
                MaskVideoView.this.hAN.c(bitmap, false);
            } else {
                MaskVideoView.this.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<c.a> v = com.baidu.tieba.video.editvideo.b.c.v(bitmap);
                        byte[] u = com.baidu.tieba.video.editvideo.b.c.u(bitmap);
                        for (int i = 0; i < 3; i++) {
                            byte[] bArr = new byte[u.length];
                            System.arraycopy(u, 0, bArr, 0, u.length);
                            if (bArr == null || bArr.length == 0) {
                                MaskVideoView.this.hAN.c(bitmap, false);
                            }
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            faceunity.fuRenderToNV21Image(bArr, width, height, 0, a.this.itemsArray, 0);
                            Bitmap j = com.baidu.tieba.video.editvideo.b.c.j(bArr, width, height);
                            boolean a = com.baidu.tieba.video.editvideo.b.c.a(j, v);
                            if (a) {
                                MaskVideoView.this.hAN.c(j, true);
                                bitmap.recycle();
                                return;
                            }
                            if (!a && i < 2) {
                                if (j != null && !j.isRecycled()) {
                                    j.recycle();
                                }
                            } else if (!a && i == 2) {
                                MaskVideoView.this.hAN.c(bitmap, false);
                            }
                        }
                    }
                });
            }
        }

        public void releaseResource() {
            this.hAT = true;
            this.mGLSurfaceView.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.hzc != null) {
                        a.this.hzc.release(false);
                        a.this.hzc = null;
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
            this.hAM = bVar;
        }
    }
}
