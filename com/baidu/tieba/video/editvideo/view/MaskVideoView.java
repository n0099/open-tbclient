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
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import d.a.j0.q3.j.d.c;
import d.a.j0.t1.g;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f22105e;

    /* renamed from: f  reason: collision with root package name */
    public e f22106f;

    /* renamed from: g  reason: collision with root package name */
    public int f22107g;

    /* renamed from: h  reason: collision with root package name */
    public int f22108h;

    /* renamed from: i  reason: collision with root package name */
    public int f22109i;
    public int j;
    public g k;
    public MediaPlayer.OnVideoSizeChangedListener l;
    public MediaPlayer.OnPreparedListener m;
    public MediaPlayer.OnPreparedListener n;
    public int o;
    public f p;
    public f q;

    /* loaded from: classes5.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            MaskVideoView.this.f22107g = mediaPlayer.getVideoWidth();
            MaskVideoView.this.f22108h = mediaPlayer.getVideoHeight();
            if (MaskVideoView.this.f22107g == 0 || MaskVideoView.this.f22108h == 0) {
                return;
            }
            MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.f22107g, MaskVideoView.this.f22108h);
            MaskVideoView.this.requestLayout();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            MediaPlayer.OnPreparedListener onPreparedListener = MaskVideoView.this.m;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(mediaPlayer);
            }
            MaskVideoView.this.f22107g = mediaPlayer.getVideoWidth();
            MaskVideoView.this.f22108h = mediaPlayer.getVideoHeight();
            if (MaskVideoView.this.f22107g == 0 || MaskVideoView.this.f22108h == 0) {
                return;
            }
            MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.f22107g, MaskVideoView.this.f22108h);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f22112e;

        public c(int i2) {
            this.f22112e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((MaskVideoView.this.f22106f == null || !MaskVideoView.this.f22106f.u) && MaskVideoView.this.o <= 10) {
                if (MaskVideoView.this.f22105e != null) {
                    try {
                        MaskVideoView.this.f22105e.seekTo(this.f22112e);
                    } catch (Exception unused) {
                    }
                }
                MaskVideoView.this.requestRender();
                MaskVideoView.i(MaskVideoView.this);
                MaskVideoView.this.o(this.f22112e);
                return;
            }
            MaskVideoView.this.o = 0;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f {

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f22115e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f22116f;

            public a(Bitmap bitmap, boolean z) {
                this.f22115e = bitmap;
                this.f22116f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                MaskVideoView.this.p.onGenMaskCoverFinish(this.f22115e, this.f22116f);
            }
        }

        public d() {
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            if (MaskVideoView.this.p != null) {
                d.a.c.e.m.e.a().post(new a(bitmap, z));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: e  reason: collision with root package name */
        public Context f22118e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f22119f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f22120g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f22121h;

        /* renamed from: i  reason: collision with root package name */
        public d.e.c.c f22122i;
        public d.e.c.c j;
        public SurfaceTexture k;
        public int m;
        public int n;
        public volatile boolean t;
        public volatile boolean u;
        public final float[] l = new float[16];
        public int o = 0;
        public int p = 0;
        public int q = 0;
        public int[] r = {0, 0, 0};
        public String s = "normal";

        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f22123e;

            public a(Bitmap bitmap) {
                this.f22123e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList<c.a> f2 = d.a.j0.q3.j.d.c.f(this.f22123e);
                byte[] e2 = d.a.j0.q3.j.d.c.e(this.f22123e);
                for (int i2 = 0; i2 < 3; i2++) {
                    int length = e2.length;
                    byte[] bArr = new byte[length];
                    System.arraycopy(e2, 0, bArr, 0, e2.length);
                    if (length == 0) {
                        MaskVideoView.this.q.onGenMaskCoverFinish(this.f22123e, false);
                    }
                    int width = this.f22123e.getWidth();
                    int height = this.f22123e.getHeight();
                    faceunity.fuRenderToNV21Image(bArr, width, height, 0, e.this.r, 0);
                    Bitmap b2 = d.a.j0.q3.j.d.c.b(bArr, width, height);
                    boolean a2 = d.a.j0.q3.j.d.c.a(b2, f2);
                    if (a2) {
                        MaskVideoView.this.q.onGenMaskCoverFinish(b2, true);
                        this.f22123e.recycle();
                        return;
                    }
                    if (a2 || i2 >= 2) {
                        if (!a2 && i2 == 2) {
                            MaskVideoView.this.q.onGenMaskCoverFinish(this.f22123e, false);
                        }
                    } else if (b2 != null && !b2.isRecycled()) {
                        b2.recycle();
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.f22122i != null) {
                    e.this.f22122i.c(false);
                    e.this.f22122i = null;
                }
                faceunity.fuDestroyItem(e.this.p);
                int[] iArr = e.this.r;
                e.this.p = 0;
                iArr[1] = 0;
                faceunity.fuDestroyItem(e.this.o);
                int[] iArr2 = e.this.r;
                e.this.o = 0;
                iArr2[0] = 0;
                faceunity.fuOnDeviceLost();
            }
        }

        public e(Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            this.f22118e = context;
            this.f22119f = gLSurfaceView;
            this.f22121h = mediaPlayer;
        }

        public final void k() {
            this.f22122i = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            d.e.c.c cVar = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.j = cVar;
            this.m = cVar.a();
            this.k = new SurfaceTexture(this.m);
            this.f22120g = new Surface(this.k);
            int a2 = d.e.a.a(this.f22118e);
            this.o = a2;
            this.r[0] = a2;
            this.k.setOnFrameAvailableListener(this);
        }

        public void l(Bitmap bitmap) {
            if ("normal".equals(this.s)) {
                MaskVideoView.this.q.onGenMaskCoverFinish(bitmap, true);
            } else if (bitmap == null || bitmap.isRecycled()) {
                MaskVideoView.this.q.onGenMaskCoverFinish(bitmap, false);
            } else {
                MaskVideoView.this.queueEvent(new a(bitmap));
            }
        }

        public void m() {
            this.t = true;
            this.f22119f.queueEvent(new b());
        }

        public void n(d.a.j0.q3.j.e.a aVar) {
            if (aVar != null) {
                this.s = aVar.f59229c;
                this.f22119f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.t) {
                return;
            }
            if (this.f22122i == null) {
                k();
                this.f22121h.setSurface(this.f22120g);
            }
            this.k.updateTexImage();
            this.k.getTransformMatrix(this.l);
            if (!TextUtils.isEmpty(this.s) && !this.s.equals("normal")) {
                faceunity.fuItemSetParam(this.o, "filter_name", this.s);
            }
            faceunity.fuItemSetParam(this.o, "color_level", 0.0d);
            faceunity.fuItemSetParam(this.o, "blur_level", 0.0d);
            faceunity.fuItemSetParam(this.o, "cheek_thinning", 0.0d);
            faceunity.fuItemSetParam(this.o, "eye_enlarging", 0.0d);
            faceunity.fuItemSetParam(this.o, "face_shape", 0.0d);
            faceunity.fuItemSetParam(this.o, "face_shape_level", 0.0d);
            faceunity.fuItemSetParam(this.o, "red_level", 0.0d);
            faceunity.fuItemSetParam(this.o, "eye_bright", 0.0d);
            faceunity.fuItemSetParam(this.o, "tooth_whiten", 0.0d);
            int i2 = this.m;
            int i3 = MaskVideoView.this.f22107g;
            int i4 = MaskVideoView.this.f22108h;
            int i5 = this.n;
            this.n = i5 + 1;
            this.f22122i.b(faceunity.fuBeautifyImage(i2, 1, i3, i4, i5, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.u = true;
            this.f22119f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            MaskVideoView.this.f22109i = i2;
            MaskVideoView.this.j = i3;
            this.f22121h.setSurface(this.f22120g);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            k();
        }
    }

    /* loaded from: classes5.dex */
    public interface f {
        void onGenMaskCoverFinish(Bitmap bitmap, boolean z);
    }

    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22106f = null;
        this.l = new a();
        this.n = new b();
        this.o = 0;
        this.q = new d();
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f22105e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.n);
        this.f22105e.setOnVideoSizeChangedListener(this.l);
        e eVar = new e(getContext(), this, this.f22105e);
        this.f22106f = eVar;
        setRenderer(eVar);
        setRenderMode(0);
    }

    public static /* synthetic */ int i(MaskVideoView maskVideoView) {
        int i2 = maskVideoView.o;
        maskVideoView.o = i2 + 1;
        return i2;
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
        return this.f22105e.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    @Deprecated
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f22105e.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f22105e.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f22105e.isPlaying();
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f22105e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
        o(i2);
    }

    public final void o(int i2) {
        d.a.c.e.m.e.a().postDelayed(new c(i2), 500L);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        int defaultSize = GLSurfaceView.getDefaultSize(this.f22107g, i2);
        int defaultSize2 = GLSurfaceView.getDefaultSize(this.f22108h, i3);
        if (this.f22107g > 0 && this.f22108h > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.f22107g;
                int i5 = i4 * size2;
                int i6 = this.f22108h;
                if (i5 < size * i6) {
                    defaultSize = (i4 * size2) / i6;
                    defaultSize2 = size2;
                } else {
                    if (i4 * size2 > size * i6) {
                        defaultSize2 = (i6 * size) / i4;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i7 = (this.f22108h * size) / this.f22107g;
                if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                    defaultSize2 = i7;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i8 = (this.f22107g * size2) / this.f22108h;
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize = i8;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i9 = this.f22107g;
                int i10 = this.f22108h;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize2 = i10;
                } else {
                    i9 = (i9 * size2) / i10;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                } else {
                    defaultSize2 = (this.f22108h * size) / this.f22107g;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.f22106f != null) {
            super.onPause();
            this.f22106f.u = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.f22106f != null) {
            super.onResume();
            this.f22106f.t = false;
        }
    }

    public void p(Bitmap bitmap) {
        e eVar = this.f22106f;
        if (eVar != null) {
            eVar.l(bitmap);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        q();
    }

    public void q() {
        if (this.f22105e.isPlaying()) {
            this.f22105e.pause();
        }
    }

    public void r() {
        e eVar = this.f22106f;
        if (eVar != null) {
            eVar.m();
        }
    }

    public void s() {
        MediaPlayer mediaPlayer = this.f22105e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f22105e.seekTo(0);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        this.f22105e.seekTo(i2);
    }

    public void setFilter(d.a.j0.q3.j.e.a aVar) {
        e eVar = this.f22106f;
        if (eVar != null) {
            eVar.n(aVar);
        }
    }

    public void setGenMaskCoverListener(f fVar) {
        if (fVar != null) {
            this.p = fVar;
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f22105e.setOnCompletionListener(onCompletionListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.m = onPreparedListener;
    }

    public void setPostMonitorManager(g gVar) {
        this.k = gVar;
    }

    public void setVideoPath(String str) {
        try {
            this.f22105e.setDataSource(str);
            this.f22105e.prepare();
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(204, d.a.j0.t1.a.a(e2));
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.f22105e.start();
    }

    public void t() {
        MediaPlayer mediaPlayer = this.f22105e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f22105e.release();
            } catch (Throwable th) {
                g gVar = this.k;
                if (gVar != null) {
                    gVar.a(205, d.a.j0.t1.a.a(th));
                }
            }
            this.f22105e = null;
            ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(null);
        }
    }
}
