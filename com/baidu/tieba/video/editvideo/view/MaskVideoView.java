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
import com.baidu.tieba.j.h;
import com.baidu.tieba.video.editvideo.b.c;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.apache.http.HttpStatus;
/* loaded from: classes2.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    private MediaPlayer aWV;
    MediaPlayer.OnVideoSizeChangedListener aWW;
    MediaPlayer.OnPreparedListener bhQ;
    MediaPlayer.OnPreparedListener blB;
    private String blw;
    private h gJZ;
    private a hap;
    private final int haq;
    private int har;
    public b has;
    private b hat;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void c(Bitmap bitmap, boolean z);
    }

    static /* synthetic */ int f(MaskVideoView maskVideoView) {
        int i = maskVideoView.har;
        maskVideoView.har = i + 1;
        return i;
    }

    public void setPostMonitorManager(h hVar) {
        this.gJZ = hVar;
    }

    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hap = null;
        this.blw = null;
        this.aWW = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.1
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
        this.blB = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (MaskVideoView.this.bhQ != null) {
                    MaskVideoView.this.bhQ.onPrepared(mediaPlayer);
                }
                MaskVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                MaskVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (MaskVideoView.this.mVideoWidth != 0 && MaskVideoView.this.mVideoHeight != 0) {
                    MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.mVideoWidth, MaskVideoView.this.mVideoHeight);
                }
            }
        };
        this.haq = 10;
        this.har = 0;
        this.hat = new b() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4
            @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
            public void c(final Bitmap bitmap, final boolean z) {
                if (MaskVideoView.this.has != null) {
                    e.im().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaskVideoView.this.has.c(bitmap, z);
                        }
                    });
                }
            }
        };
        setEGLContextClientVersion(2);
        this.aWV = new MediaPlayer();
        this.aWV.setOnPreparedListener(this.blB);
        this.aWV.setOnVideoSizeChangedListener(this.aWW);
        this.hap = new a(getContext(), this, this.aWV);
        setRenderer(this.hap);
        setRenderMode(0);
    }

    public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.hap != null) {
            this.hap.setFilter(aVar);
        }
    }

    public void releaseSource() {
        if (this.hap != null) {
            this.hap.releaseResource();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.hap != null) {
            super.onPause();
            this.hap.haA = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.hap != null) {
            super.onResume();
            this.hap.haz = false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.aWV.start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        bCs();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.aWV.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.aWV.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.aWV.seekTo(i);
    }

    public void uA(int i) {
        this.aWV.seekTo(i);
        uB(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(final int i) {
        e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if ((MaskVideoView.this.hap == null || !MaskVideoView.this.hap.haA) && MaskVideoView.this.har <= 10) {
                    if (MaskVideoView.this.aWV != null) {
                        try {
                            MaskVideoView.this.aWV.seekTo(i);
                        } catch (Exception e) {
                        }
                    }
                    MaskVideoView.this.requestRender();
                    MaskVideoView.f(MaskVideoView.this);
                    MaskVideoView.this.uB(i);
                    return;
                }
                MaskVideoView.this.har = 0;
            }
        }, 500L);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.aWV.isPlaying();
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
        return this.aWV.getAudioSessionId();
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
        this.bhQ = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.aWV.setOnCompletionListener(onCompletionListener);
    }

    public void stopPlayback() {
        if (this.aWV != null) {
            try {
                this.aWV.stop();
                this.aWV.release();
            } catch (Throwable th) {
                if (this.gJZ != null) {
                    this.gJZ.ae(HttpStatus.SC_RESET_CONTENT, com.baidu.tieba.j.a.m(th));
                }
            }
            this.aWV = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void setVideoPath(String str) {
        try {
            this.aWV.setDataSource(str);
            this.blw = str;
            this.aWV.prepare();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.gJZ != null) {
                this.gJZ.ae(HttpStatus.SC_NO_CONTENT, com.baidu.tieba.j.a.m(e));
            }
        }
    }

    public void bCs() {
        if (this.aWV.isPlaying()) {
            this.aWV.pause();
        }
    }

    public void bCt() {
        this.aWV.start();
        this.aWV.seekTo(0);
    }

    public void C(Bitmap bitmap) {
        if (this.hap != null) {
            this.hap.C(bitmap);
        }
    }

    /* loaded from: classes2.dex */
    private class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
        private MediaPlayer aWV;
        private com.faceunity.gles.c gYL;
        private com.faceunity.gles.c gYM;
        private volatile boolean haA;
        private volatile boolean haz;
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
        private int gYK = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.gYK};
        private String gYJ = "normal";

        public a(Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            this.mContext = context;
            this.mGLSurfaceView = gLSurfaceView;
            this.aWV = mediaPlayer;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            bCu();
        }

        private void bCu() {
            this.gYL = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.gYM = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mTextureId = this.gYM.createTextureObject();
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mFacebeautyItem = com.faceunity.a.da(this.mContext);
            this.itemsArray[0] = this.mFacebeautyItem;
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            MaskVideoView.this.mSurfaceWidth = i;
            MaskVideoView.this.mSurfaceHeight = i2;
            this.aWV.setSurface(this.mSurface);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.haz) {
                if (this.gYL == null) {
                    bCu();
                    this.aWV.setSurface(this.mSurface);
                }
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                if (!TextUtils.isEmpty(this.gYJ) && !this.gYJ.equals("normal")) {
                    faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.gYJ);
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
                this.gYL.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.itemsArray), this.mSTMatrix);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.haA = true;
            this.mGLSurfaceView.requestRender();
        }

        public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
            if (aVar != null) {
                this.gYJ = aVar.value;
                this.mGLSurfaceView.requestRender();
            }
        }

        public void C(final Bitmap bitmap) {
            if ("normal".equals(this.gYJ)) {
                MaskVideoView.this.hat.c(bitmap, true);
            } else if (bitmap == null || bitmap.isRecycled()) {
                MaskVideoView.this.hat.c(bitmap, false);
            } else {
                MaskVideoView.this.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<c.a> B = com.baidu.tieba.video.editvideo.b.c.B(bitmap);
                        byte[] A = com.baidu.tieba.video.editvideo.b.c.A(bitmap);
                        for (int i = 0; i < 3; i++) {
                            byte[] bArr = new byte[A.length];
                            System.arraycopy(A, 0, bArr, 0, A.length);
                            if (bArr == null || bArr.length == 0) {
                                MaskVideoView.this.hat.c(bitmap, false);
                            }
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            faceunity.fuRenderToNV21Image(bArr, width, height, 0, a.this.itemsArray, 0);
                            Bitmap j = com.baidu.tieba.video.editvideo.b.c.j(bArr, width, height);
                            boolean a = com.baidu.tieba.video.editvideo.b.c.a(j, B);
                            if (a) {
                                MaskVideoView.this.hat.c(j, true);
                                bitmap.recycle();
                                return;
                            }
                            if (!a && i < 2) {
                                if (j != null && !j.isRecycled()) {
                                    j.recycle();
                                }
                            } else if (!a && i == 2) {
                                MaskVideoView.this.hat.c(bitmap, false);
                            }
                        }
                    }
                });
            }
        }

        public void releaseResource() {
            this.haz = true;
            this.mGLSurfaceView.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gYL != null) {
                        a.this.gYL.release(false);
                        a.this.gYL = null;
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
            this.has = bVar;
        }
    }
}
