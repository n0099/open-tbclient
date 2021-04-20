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
import d.b.i0.q3.j.d.c;
import d.b.i0.t1.g;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes5.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f21472e;

    /* renamed from: f  reason: collision with root package name */
    public e f21473f;

    /* renamed from: g  reason: collision with root package name */
    public int f21474g;

    /* renamed from: h  reason: collision with root package name */
    public int f21475h;
    public int i;
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
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            MaskVideoView.this.f21474g = mediaPlayer.getVideoWidth();
            MaskVideoView.this.f21475h = mediaPlayer.getVideoHeight();
            if (MaskVideoView.this.f21474g == 0 || MaskVideoView.this.f21475h == 0) {
                return;
            }
            MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.f21474g, MaskVideoView.this.f21475h);
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
            MaskVideoView.this.f21474g = mediaPlayer.getVideoWidth();
            MaskVideoView.this.f21475h = mediaPlayer.getVideoHeight();
            if (MaskVideoView.this.f21474g == 0 || MaskVideoView.this.f21475h == 0) {
                return;
            }
            MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.f21474g, MaskVideoView.this.f21475h);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21478e;

        public c(int i) {
            this.f21478e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((MaskVideoView.this.f21473f == null || !MaskVideoView.this.f21473f.u) && MaskVideoView.this.o <= 10) {
                if (MaskVideoView.this.f21472e != null) {
                    try {
                        MaskVideoView.this.f21472e.seekTo(this.f21478e);
                    } catch (Exception unused) {
                    }
                }
                MaskVideoView.this.requestRender();
                MaskVideoView.i(MaskVideoView.this);
                MaskVideoView.this.o(this.f21478e);
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
            public final /* synthetic */ Bitmap f21481e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f21482f;

            public a(Bitmap bitmap, boolean z) {
                this.f21481e = bitmap;
                this.f21482f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                MaskVideoView.this.p.onGenMaskCoverFinish(this.f21481e, this.f21482f);
            }
        }

        public d() {
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            if (MaskVideoView.this.p != null) {
                d.b.c.e.m.e.a().post(new a(bitmap, z));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

        /* renamed from: e  reason: collision with root package name */
        public Context f21484e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f21485f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f21486g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f21487h;
        public d.e.c.c i;
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
            public final /* synthetic */ Bitmap f21488e;

            public a(Bitmap bitmap) {
                this.f21488e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList<c.a> f2 = d.b.i0.q3.j.d.c.f(this.f21488e);
                byte[] e2 = d.b.i0.q3.j.d.c.e(this.f21488e);
                for (int i = 0; i < 3; i++) {
                    int length = e2.length;
                    byte[] bArr = new byte[length];
                    System.arraycopy(e2, 0, bArr, 0, e2.length);
                    if (length == 0) {
                        MaskVideoView.this.q.onGenMaskCoverFinish(this.f21488e, false);
                    }
                    int width = this.f21488e.getWidth();
                    int height = this.f21488e.getHeight();
                    faceunity.fuRenderToNV21Image(bArr, width, height, 0, e.this.r, 0);
                    Bitmap b2 = d.b.i0.q3.j.d.c.b(bArr, width, height);
                    boolean a2 = d.b.i0.q3.j.d.c.a(b2, f2);
                    if (a2) {
                        MaskVideoView.this.q.onGenMaskCoverFinish(b2, true);
                        this.f21488e.recycle();
                        return;
                    }
                    if (a2 || i >= 2) {
                        if (!a2 && i == 2) {
                            MaskVideoView.this.q.onGenMaskCoverFinish(this.f21488e, false);
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
                if (e.this.i != null) {
                    e.this.i.c(false);
                    e.this.i = null;
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
            this.f21484e = context;
            this.f21485f = gLSurfaceView;
            this.f21487h = mediaPlayer;
        }

        public final void k() {
            this.i = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            d.e.c.c cVar = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.j = cVar;
            this.m = cVar.a();
            this.k = new SurfaceTexture(this.m);
            this.f21486g = new Surface(this.k);
            int a2 = d.e.a.a(this.f21484e);
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
            this.f21485f.queueEvent(new b());
        }

        public void n(d.b.i0.q3.j.e.a aVar) {
            if (aVar != null) {
                this.s = aVar.f60673c;
                this.f21485f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.t) {
                return;
            }
            if (this.i == null) {
                k();
                this.f21487h.setSurface(this.f21486g);
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
            int i = this.m;
            int i2 = MaskVideoView.this.f21474g;
            int i3 = MaskVideoView.this.f21475h;
            int i4 = this.n;
            this.n = i4 + 1;
            this.i.b(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.u = true;
            this.f21485f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            MaskVideoView.this.i = i;
            MaskVideoView.this.j = i2;
            this.f21487h.setSurface(this.f21486g);
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
        this.f21473f = null;
        this.l = new a();
        this.n = new b();
        this.o = 0;
        this.q = new d();
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f21472e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.n);
        this.f21472e.setOnVideoSizeChangedListener(this.l);
        e eVar = new e(getContext(), this, this.f21472e);
        this.f21473f = eVar;
        setRenderer(eVar);
        setRenderMode(0);
    }

    public static /* synthetic */ int i(MaskVideoView maskVideoView) {
        int i = maskVideoView.o;
        maskVideoView.o = i + 1;
        return i;
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
        return this.f21472e.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    @Deprecated
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f21472e.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f21472e.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f21472e.isPlaying();
    }

    public void n(int i) {
        MediaPlayer mediaPlayer = this.f21472e;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(i);
        o(i);
    }

    public final void o(int i) {
        d.b.c.e.m.e.a().postDelayed(new c(i), 500L);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = GLSurfaceView.getDefaultSize(this.f21474g, i);
        int defaultSize2 = GLSurfaceView.getDefaultSize(this.f21475h, i2);
        if (this.f21474g > 0 && this.f21475h > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i3 = this.f21474g;
                int i4 = i3 * size2;
                int i5 = this.f21475h;
                if (i4 < size * i5) {
                    defaultSize = (i3 * size2) / i5;
                    defaultSize2 = size2;
                } else {
                    if (i3 * size2 > size * i5) {
                        defaultSize2 = (i5 * size) / i3;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                }
            } else if (mode == 1073741824) {
                int i6 = (this.f21475h * size) / this.f21474g;
                if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                    defaultSize2 = i6;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i7 = (this.f21474g * size2) / this.f21475h;
                if (mode != Integer.MIN_VALUE || i7 <= size) {
                    defaultSize = i7;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i8 = this.f21474g;
                int i9 = this.f21475h;
                if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                    defaultSize2 = i9;
                } else {
                    i8 = (i8 * size2) / i9;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize = i8;
                } else {
                    defaultSize2 = (this.f21475h * size) / this.f21474g;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.f21473f != null) {
            super.onPause();
            this.f21473f.u = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.f21473f != null) {
            super.onResume();
            this.f21473f.t = false;
        }
    }

    public void p(Bitmap bitmap) {
        e eVar = this.f21473f;
        if (eVar != null) {
            eVar.l(bitmap);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        q();
    }

    public void q() {
        if (this.f21472e.isPlaying()) {
            this.f21472e.pause();
        }
    }

    public void r() {
        e eVar = this.f21473f;
        if (eVar != null) {
            eVar.m();
        }
    }

    public void s() {
        MediaPlayer mediaPlayer = this.f21472e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f21472e.seekTo(0);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.f21472e.seekTo(i);
    }

    public void setFilter(d.b.i0.q3.j.e.a aVar) {
        e eVar = this.f21473f;
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
        this.f21472e.setOnCompletionListener(onCompletionListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.m = onPreparedListener;
    }

    public void setPostMonitorManager(g gVar) {
        this.k = gVar;
    }

    public void setVideoPath(String str) {
        try {
            this.f21472e.setDataSource(str);
            this.f21472e.prepare();
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(204, d.b.i0.t1.a.a(e2));
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.f21472e.start();
    }

    public void t() {
        MediaPlayer mediaPlayer = this.f21472e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f21472e.release();
            } catch (Throwable th) {
                g gVar = this.k;
                if (gVar != null) {
                    gVar.a(205, d.b.i0.t1.a.a(th));
                }
            }
            this.f21472e = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }
}
