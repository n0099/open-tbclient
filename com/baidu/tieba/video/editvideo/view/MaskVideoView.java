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
import com.baidu.tieba.l.g;
import com.baidu.tieba.video.editvideo.b.c;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes8.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    MediaPlayer.OnPreparedListener eCI;
    MediaPlayer.OnVideoSizeChangedListener eCK;
    MediaPlayer.OnPreparedListener efH;
    private MediaPlayer mMediaPlayer;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private String mVideoPath;
    private int mVideoWidth;
    private a nIX;
    private final int nIY;
    private int nIZ;
    public b nJa;
    private b nJb;
    private g nsP;

    /* loaded from: classes8.dex */
    public interface b {
        void c(Bitmap bitmap, boolean z);
    }

    static /* synthetic */ int f(MaskVideoView maskVideoView) {
        int i = maskVideoView.nIZ;
        maskVideoView.nIZ = i + 1;
        return i;
    }

    public void setPostMonitorManager(g gVar) {
        this.nsP = gVar;
    }

    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIX = null;
        this.mVideoPath = null;
        this.eCK = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.1
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
        this.eCI = new MediaPlayer.OnPreparedListener() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.2
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                if (MaskVideoView.this.efH != null) {
                    MaskVideoView.this.efH.onPrepared(mediaPlayer);
                }
                MaskVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                MaskVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (MaskVideoView.this.mVideoWidth != 0 && MaskVideoView.this.mVideoHeight != 0) {
                    MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.mVideoWidth, MaskVideoView.this.mVideoHeight);
                }
            }
        };
        this.nIY = 10;
        this.nIZ = 0;
        this.nJb = new b() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4
            @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.b
            public void c(final Bitmap bitmap, final boolean z) {
                if (MaskVideoView.this.nJa != null) {
                    com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MaskVideoView.this.nJa.c(bitmap, z);
                        }
                    });
                }
            }
        };
        setEGLContextClientVersion(2);
        this.mMediaPlayer = new MediaPlayer();
        this.mMediaPlayer.setOnPreparedListener(this.eCI);
        this.mMediaPlayer.setOnVideoSizeChangedListener(this.eCK);
        this.nIX = new a(getContext(), this, this.mMediaPlayer);
        setRenderer(this.nIX);
        setRenderMode(0);
    }

    public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (this.nIX != null) {
            this.nIX.setFilter(aVar);
        }
    }

    public void releaseSource() {
        if (this.nIX != null) {
            this.nIX.releaseResource();
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.nIX != null) {
            super.onPause();
            this.nIX.nJj = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.nIX != null) {
            super.onResume();
            this.nIX.nJi = false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.mMediaPlayer.start();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        dUR();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.mMediaPlayer.seekTo(i);
    }

    public void LQ(int i) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.seekTo(i);
            LR(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LR(final int i) {
        com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                if ((MaskVideoView.this.nIX == null || !MaskVideoView.this.nIX.nJj) && MaskVideoView.this.nIZ <= 10) {
                    if (MaskVideoView.this.mMediaPlayer != null) {
                        try {
                            MaskVideoView.this.mMediaPlayer.seekTo(i);
                        } catch (Exception e) {
                        }
                    }
                    MaskVideoView.this.requestRender();
                    MaskVideoView.f(MaskVideoView.this);
                    MaskVideoView.this.LR(i);
                    return;
                }
                MaskVideoView.this.nIZ = 0;
            }
        }, 500L);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
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
        return this.mMediaPlayer.getAudioSessionId();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
        if (r1 > r2) goto L11;
     */
    @Override // android.view.SurfaceView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i);
            i3 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * i3) {
                    i3 = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                } else if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * i3) {
                    defaultSize2 = (this.mVideoHeight * i3) / this.mVideoWidth;
                }
            } else if (mode == 1073741824) {
                int i4 = (this.mVideoHeight * i3) / this.mVideoWidth;
                if (mode2 != Integer.MIN_VALUE || i4 <= defaultSize2) {
                    defaultSize2 = i4;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                if (mode == Integer.MIN_VALUE) {
                }
            } else {
                defaultSize = this.mVideoWidth;
                int i5 = this.mVideoHeight;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                } else {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > i3) {
                    defaultSize2 = (this.mVideoHeight * i3) / this.mVideoWidth;
                }
            }
            setMeasuredDimension(i3, defaultSize2);
        }
        i3 = defaultSize;
        setMeasuredDimension(i3, defaultSize2);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.efH = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void stopPlayback() {
        if (this.mMediaPlayer != null) {
            try {
                this.mMediaPlayer.stop();
                this.mMediaPlayer.release();
            } catch (Throwable th) {
                if (this.nsP != null) {
                    this.nsP.bF(205, com.baidu.tieba.l.a.p(th));
                }
            }
            this.mMediaPlayer = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void setVideoPath(String str) {
        try {
            this.mMediaPlayer.setDataSource(str);
            this.mVideoPath = str;
            this.mMediaPlayer.prepare();
        } catch (Exception e) {
            e.printStackTrace();
            if (this.nsP != null) {
                this.nsP.bF(204, com.baidu.tieba.l.a.p(e));
            }
        }
    }

    public void dUR() {
        if (this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
        }
    }

    public void resumeMedia() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.start();
            this.mMediaPlayer.seekTo(0);
        }
    }

    public void R(Bitmap bitmap) {
        if (this.nIX != null) {
            this.nIX.R(bitmap);
        }
    }

    /* loaded from: classes8.dex */
    private class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
        private Context mContext;
        private int mFrameId;
        private MediaPlayer mMediaPlayer;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureId;
        private com.faceunity.gles.c nHw;
        private com.faceunity.gles.c nHx;
        private GLSurfaceView nJh;
        private volatile boolean nJi;
        private volatile boolean nJj;
        private final String TAG = "MaskVideoRenderer";
        private final float[] mSTMatrix = new float[16];
        private int mFacebeautyItem = 0;
        private int mEffectItem = 0;
        private int nHv = 0;
        private int[] itemsArray = {this.mFacebeautyItem, this.mEffectItem, this.nHv};
        private String mFilterValue = "normal";

        public a(Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            this.mContext = context;
            this.nJh = gLSurfaceView;
            this.mMediaPlayer = mediaPlayer;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            dUS();
        }

        private void dUS() {
            this.nHw = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            this.nHx = new com.faceunity.gles.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.mTextureId = this.nHx.createTextureObject();
            this.mSurfaceTexture = new SurfaceTexture(this.mTextureId);
            this.mSurface = new Surface(this.mSurfaceTexture);
            this.mFacebeautyItem = com.faceunity.a.im(this.mContext);
            this.itemsArray[0] = this.mFacebeautyItem;
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            MaskVideoView.this.mSurfaceWidth = i;
            MaskVideoView.this.mSurfaceHeight = i2;
            this.mMediaPlayer.setSurface(this.mSurface);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (!this.nJi) {
                if (this.nHw == null) {
                    dUS();
                    this.mMediaPlayer.setSurface(this.mSurface);
                }
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.mSTMatrix);
                if (!TextUtils.isEmpty(this.mFilterValue) && !this.mFilterValue.equals("normal")) {
                    faceunity.fuItemSetParam(this.mFacebeautyItem, "filter_name", this.mFilterValue);
                }
                faceunity.fuItemSetParam(this.mFacebeautyItem, "color_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "blur_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "cheek_thinning", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_enlarging", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "face_shape_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "red_level", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "eye_bright", 0.0d);
                faceunity.fuItemSetParam(this.mFacebeautyItem, "tooth_whiten", 0.0d);
                int i = this.mTextureId;
                int i2 = MaskVideoView.this.mVideoWidth;
                int i3 = MaskVideoView.this.mVideoHeight;
                int i4 = this.mFrameId;
                this.mFrameId = i4 + 1;
                this.nHw.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.itemsArray), this.mSTMatrix);
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.nJj = true;
            this.nJh.requestRender();
        }

        public void setFilter(com.baidu.tieba.video.editvideo.data.a aVar) {
            if (aVar != null) {
                this.mFilterValue = aVar.value;
                this.nJh.requestRender();
            }
        }

        public void R(final Bitmap bitmap) {
            if ("normal".equals(this.mFilterValue)) {
                MaskVideoView.this.nJb.c(bitmap, true);
            } else if (bitmap == null || bitmap.isRecycled()) {
                MaskVideoView.this.nJb.c(bitmap, false);
            } else {
                MaskVideoView.this.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ArrayList<c.a> Q = com.baidu.tieba.video.editvideo.b.c.Q(bitmap);
                        byte[] P = com.baidu.tieba.video.editvideo.b.c.P(bitmap);
                        for (int i = 0; i < 3; i++) {
                            byte[] bArr = new byte[P.length];
                            System.arraycopy(P, 0, bArr, 0, P.length);
                            if (bArr == null || bArr.length == 0) {
                                MaskVideoView.this.nJb.c(bitmap, false);
                            }
                            int width = bitmap.getWidth();
                            int height = bitmap.getHeight();
                            faceunity.fuRenderToNV21Image(bArr, width, height, 0, a.this.itemsArray, 0);
                            Bitmap t = com.baidu.tieba.video.editvideo.b.c.t(bArr, width, height);
                            boolean b2 = com.baidu.tieba.video.editvideo.b.c.b(t, Q);
                            if (b2) {
                                MaskVideoView.this.nJb.c(t, true);
                                bitmap.recycle();
                                return;
                            }
                            if (!b2 && i < 2) {
                                if (t != null && !t.isRecycled()) {
                                    t.recycle();
                                }
                            } else if (!b2 && i == 2) {
                                MaskVideoView.this.nJb.c(bitmap, false);
                            }
                        }
                    }
                });
            }
        }

        public void releaseResource() {
            this.nJi = true;
            this.nJh.queueEvent(new Runnable() { // from class: com.baidu.tieba.video.editvideo.view.MaskVideoView.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.nHw != null) {
                        a.this.nHw.release(false);
                        a.this.nHw = null;
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
            this.nJa = bVar;
        }
    }
}
