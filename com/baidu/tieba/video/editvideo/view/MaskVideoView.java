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
import d.a.n0.r3.i.d.c;
import d.a.n0.u1.g;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes5.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f21356e;

    /* renamed from: f  reason: collision with root package name */
    public e f21357f;

    /* renamed from: g  reason: collision with root package name */
    public int f21358g;

    /* renamed from: h  reason: collision with root package name */
    public int f21359h;

    /* renamed from: i  reason: collision with root package name */
    public int f21360i;
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
            MaskVideoView.this.f21358g = mediaPlayer.getVideoWidth();
            MaskVideoView.this.f21359h = mediaPlayer.getVideoHeight();
            if (MaskVideoView.this.f21358g == 0 || MaskVideoView.this.f21359h == 0) {
                return;
            }
            MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.f21358g, MaskVideoView.this.f21359h);
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
            MaskVideoView.this.f21358g = mediaPlayer.getVideoWidth();
            MaskVideoView.this.f21359h = mediaPlayer.getVideoHeight();
            if (MaskVideoView.this.f21358g == 0 || MaskVideoView.this.f21359h == 0) {
                return;
            }
            MaskVideoView.this.getHolder().setFixedSize(MaskVideoView.this.f21358g, MaskVideoView.this.f21359h);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21363e;

        public c(int i2) {
            this.f21363e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((MaskVideoView.this.f21357f == null || !MaskVideoView.this.f21357f.u) && MaskVideoView.this.o <= 10) {
                if (MaskVideoView.this.f21356e != null) {
                    try {
                        MaskVideoView.this.f21356e.seekTo(this.f21363e);
                    } catch (Exception unused) {
                    }
                }
                MaskVideoView.this.requestRender();
                MaskVideoView.i(MaskVideoView.this);
                MaskVideoView.this.o(this.f21363e);
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
            public final /* synthetic */ Bitmap f21366e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f21367f;

            public a(Bitmap bitmap, boolean z) {
                this.f21366e = bitmap;
                this.f21367f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                MaskVideoView.this.p.onGenMaskCoverFinish(this.f21366e, this.f21367f);
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
        public Context f21369e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f21370f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f21371g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f21372h;

        /* renamed from: i  reason: collision with root package name */
        public d.e.c.c f21373i;
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
            public final /* synthetic */ Bitmap f21374e;

            public a(Bitmap bitmap) {
                this.f21374e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList<c.a> f2 = d.a.n0.r3.i.d.c.f(this.f21374e);
                byte[] e2 = d.a.n0.r3.i.d.c.e(this.f21374e);
                for (int i2 = 0; i2 < 3; i2++) {
                    int length = e2.length;
                    byte[] bArr = new byte[length];
                    System.arraycopy(e2, 0, bArr, 0, e2.length);
                    if (length == 0) {
                        MaskVideoView.this.q.onGenMaskCoverFinish(this.f21374e, false);
                    }
                    int width = this.f21374e.getWidth();
                    int height = this.f21374e.getHeight();
                    faceunity.fuRenderToNV21Image(bArr, width, height, 0, e.this.r, 0);
                    Bitmap b2 = d.a.n0.r3.i.d.c.b(bArr, width, height);
                    boolean a2 = d.a.n0.r3.i.d.c.a(b2, f2);
                    if (a2) {
                        MaskVideoView.this.q.onGenMaskCoverFinish(b2, true);
                        this.f21374e.recycle();
                        return;
                    }
                    if (a2 || i2 >= 2) {
                        if (!a2 && i2 == 2) {
                            MaskVideoView.this.q.onGenMaskCoverFinish(this.f21374e, false);
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
                if (e.this.f21373i != null) {
                    e.this.f21373i.c(false);
                    e.this.f21373i = null;
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
            this.f21369e = context;
            this.f21370f = gLSurfaceView;
            this.f21372h = mediaPlayer;
        }

        public final void k() {
            this.f21373i = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
            d.e.c.c cVar = new d.e.c.c(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
            this.j = cVar;
            this.m = cVar.a();
            this.k = new SurfaceTexture(this.m);
            this.f21371g = new Surface(this.k);
            int a2 = d.e.a.a(this.f21369e);
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
            this.f21370f.queueEvent(new b());
        }

        public void n(d.a.n0.r3.i.e.a aVar) {
            if (aVar != null) {
                this.s = aVar.f63804c;
                this.f21370f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (this.t) {
                return;
            }
            if (this.f21373i == null) {
                k();
                this.f21372h.setSurface(this.f21371g);
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
            int i3 = MaskVideoView.this.f21358g;
            int i4 = MaskVideoView.this.f21359h;
            int i5 = this.n;
            this.n = i5 + 1;
            this.f21373i.b(faceunity.fuBeautifyImage(i2, 1, i3, i4, i5, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            this.u = true;
            this.f21370f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            MaskVideoView.this.f21360i = i2;
            MaskVideoView.this.j = i3;
            this.f21372h.setSurface(this.f21371g);
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
        this.f21357f = null;
        this.l = new a();
        this.n = new b();
        this.o = 0;
        this.q = new d();
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f21356e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.n);
        this.f21356e.setOnVideoSizeChangedListener(this.l);
        e eVar = new e(getContext(), this, this.f21356e);
        this.f21357f = eVar;
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
        return this.f21356e.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    @Deprecated
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return this.f21356e.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        return this.f21356e.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.f21356e.isPlaying();
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer = this.f21356e;
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
        int defaultSize = GLSurfaceView.getDefaultSize(this.f21358g, i2);
        int defaultSize2 = GLSurfaceView.getDefaultSize(this.f21359h, i3);
        if (this.f21358g > 0 && this.f21359h > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.f21358g;
                int i5 = i4 * size2;
                int i6 = this.f21359h;
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
                int i7 = (this.f21359h * size) / this.f21358g;
                if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                    defaultSize2 = i7;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else if (mode2 == 1073741824) {
                int i8 = (this.f21358g * size2) / this.f21359h;
                if (mode != Integer.MIN_VALUE || i8 <= size) {
                    defaultSize = i8;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                int i9 = this.f21358g;
                int i10 = this.f21359h;
                if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                    defaultSize2 = i10;
                } else {
                    i9 = (i9 * size2) / i10;
                    defaultSize2 = size2;
                }
                if (mode != Integer.MIN_VALUE || i9 <= size) {
                    defaultSize = i9;
                } else {
                    defaultSize2 = (this.f21359h * size) / this.f21358g;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        if (this.f21357f != null) {
            super.onPause();
            this.f21357f.u = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        if (this.f21357f != null) {
            super.onResume();
            this.f21357f.t = false;
        }
    }

    public void p(Bitmap bitmap) {
        e eVar = this.f21357f;
        if (eVar != null) {
            eVar.l(bitmap);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        q();
    }

    public void q() {
        if (this.f21356e.isPlaying()) {
            this.f21356e.pause();
        }
    }

    public void r() {
        e eVar = this.f21357f;
        if (eVar != null) {
            eVar.m();
        }
    }

    public void s() {
        MediaPlayer mediaPlayer = this.f21356e;
        if (mediaPlayer != null) {
            mediaPlayer.start();
            this.f21356e.seekTo(0);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        this.f21356e.seekTo(i2);
    }

    public void setFilter(d.a.n0.r3.i.e.a aVar) {
        e eVar = this.f21357f;
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
        this.f21356e.setOnCompletionListener(onCompletionListener);
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.m = onPreparedListener;
    }

    public void setPostMonitorManager(g gVar) {
        this.k = gVar;
    }

    public void setVideoPath(String str) {
        try {
            this.f21356e.setDataSource(str);
            this.f21356e.prepare();
        } catch (Exception e2) {
            e2.printStackTrace();
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(204, d.a.n0.u1.a.a(e2));
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.f21356e.start();
    }

    public void t() {
        MediaPlayer mediaPlayer = this.f21356e;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                this.f21356e.release();
            } catch (Throwable th) {
                g gVar = this.k;
                if (gVar != null) {
                    gVar.a(205, d.a.n0.u1.a.a(th));
                }
            }
            this.f21356e = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }
}
