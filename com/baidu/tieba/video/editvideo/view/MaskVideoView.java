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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.FaceUnityUtils;
import com.faceunity.gles.FullFrameRect;
import com.faceunity.gles.Texture2dProgram;
import com.faceunity.wrapper.faceunity;
import d.a.p0.v3.g.d.c;
import d.a.p0.x1.g;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes4.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f21613e;

    /* renamed from: f  reason: collision with root package name */
    public e f21614f;

    /* renamed from: g  reason: collision with root package name */
    public int f21615g;

    /* renamed from: h  reason: collision with root package name */
    public int f21616h;

    /* renamed from: i  reason: collision with root package name */
    public int f21617i;
    public int j;
    public g k;
    public MediaPlayer.OnVideoSizeChangedListener l;
    public MediaPlayer.OnPreparedListener m;
    public MediaPlayer.OnPreparedListener n;
    public int o;
    public f p;
    public f q;

    /* loaded from: classes4.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f21618e;

        public a(MaskVideoView maskVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21618e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f21618e.f21615g = mediaPlayer.getVideoWidth();
                this.f21618e.f21616h = mediaPlayer.getVideoHeight();
                if (this.f21618e.f21615g == 0 || this.f21618e.f21616h == 0) {
                    return;
                }
                this.f21618e.getHolder().setFixedSize(this.f21618e.f21615g, this.f21618e.f21616h);
                this.f21618e.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f21619e;

        public b(MaskVideoView maskVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21619e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MediaPlayer.OnPreparedListener onPreparedListener = this.f21619e.m;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                this.f21619e.f21615g = mediaPlayer.getVideoWidth();
                this.f21619e.f21616h = mediaPlayer.getVideoHeight();
                if (this.f21619e.f21615g == 0 || this.f21619e.f21616h == 0) {
                    return;
                }
                this.f21619e.getHolder().setFixedSize(this.f21619e.f21615g, this.f21619e.f21616h);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f21620e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f21621f;

        public c(MaskVideoView maskVideoView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21621f = maskVideoView;
            this.f21620e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.f21621f.f21614f == null || !this.f21621f.f21614f.u) && this.f21621f.o <= 10) {
                    if (this.f21621f.f21613e != null) {
                        try {
                            this.f21621f.f21613e.seekTo(this.f21620e);
                        } catch (Exception unused) {
                        }
                    }
                    this.f21621f.requestRender();
                    MaskVideoView.i(this.f21621f);
                    this.f21621f.o(this.f21620e);
                    return;
                }
                this.f21621f.o = 0;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f21622e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f21623e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f21624f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f21625g;

            public a(d dVar, Bitmap bitmap, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21625g = dVar;
                this.f21623e = bitmap;
                this.f21624f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f21625g.f21622e.p.onGenMaskCoverFinish(this.f21623e, this.f21624f);
                }
            }
        }

        public d(MaskVideoView maskVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21622e = maskVideoView;
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) || this.f21622e.p == null) {
                return;
            }
            d.a.c.e.m.e.a().post(new a(this, bitmap, z));
        }
    }

    /* loaded from: classes4.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f21626e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f21627f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f21628g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f21629h;

        /* renamed from: i  reason: collision with root package name */
        public FullFrameRect f21630i;
        public FullFrameRect j;
        public SurfaceTexture k;
        public final float[] l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int[] r;
        public String s;
        public volatile boolean t;
        public volatile boolean u;
        public final /* synthetic */ MaskVideoView v;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f21631e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f21632f;

            public a(e eVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21632f = eVar;
                this.f21631e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<c.a> f2 = d.a.p0.v3.g.d.c.f(this.f21631e);
                    byte[] e2 = d.a.p0.v3.g.d.c.e(this.f21631e);
                    for (int i2 = 0; i2 < 3; i2++) {
                        int length = e2.length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(e2, 0, bArr, 0, e2.length);
                        if (length == 0) {
                            this.f21632f.v.q.onGenMaskCoverFinish(this.f21631e, false);
                        }
                        int width = this.f21631e.getWidth();
                        int height = this.f21631e.getHeight();
                        faceunity.fuRenderToNV21Image(bArr, width, height, 0, this.f21632f.r, 0);
                        Bitmap b2 = d.a.p0.v3.g.d.c.b(bArr, width, height);
                        boolean a2 = d.a.p0.v3.g.d.c.a(b2, f2);
                        if (a2) {
                            this.f21632f.v.q.onGenMaskCoverFinish(b2, true);
                            this.f21631e.recycle();
                            return;
                        }
                        if (a2 || i2 >= 2) {
                            if (!a2 && i2 == 2) {
                                this.f21632f.v.q.onGenMaskCoverFinish(this.f21631e, false);
                            }
                        } else if (b2 != null && !b2.isRecycled()) {
                            b2.recycle();
                        }
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f21633e;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21633e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f21633e.f21630i != null) {
                        this.f21633e.f21630i.release(false);
                        this.f21633e.f21630i = null;
                    }
                    faceunity.fuDestroyItem(this.f21633e.p);
                    int[] iArr = this.f21633e.r;
                    this.f21633e.p = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.f21633e.o);
                    int[] iArr2 = this.f21633e.r;
                    this.f21633e.o = 0;
                    iArr2[0] = 0;
                    faceunity.fuOnDeviceLost();
                }
            }
        }

        public e(MaskVideoView maskVideoView, Context context, GLSurfaceView gLSurfaceView, MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView, context, gLSurfaceView, mediaPlayer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.v = maskVideoView;
            this.l = new float[16];
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = new int[]{0, 0, 0};
            this.s = "normal";
            this.f21626e = context;
            this.f21627f = gLSurfaceView;
            this.f21629h = mediaPlayer;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21630i = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.j = fullFrameRect;
                this.m = fullFrameRect.createTextureObject();
                this.k = new SurfaceTexture(this.m);
                this.f21628g = new Surface(this.k);
                int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.f21626e);
                this.o = upFaceUnity;
                this.r[0] = upFaceUnity;
                this.k.setOnFrameAvailableListener(this);
            }
        }

        public void l(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if ("normal".equals(this.s)) {
                    this.v.q.onGenMaskCoverFinish(bitmap, true);
                } else if (bitmap == null || bitmap.isRecycled()) {
                    this.v.q.onGenMaskCoverFinish(bitmap, false);
                } else {
                    this.v.queueEvent(new a(this, bitmap));
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.t = true;
                this.f21627f.queueEvent(new b(this));
            }
        }

        public void n(d.a.p0.v3.g.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.s = aVar.f65461c;
            this.f21627f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gl10) == null) || this.t) {
                return;
            }
            if (this.f21630i == null) {
                k();
                this.f21629h.setSurface(this.f21628g);
            }
            this.k.updateTexImage();
            this.k.getTransformMatrix(this.l);
            if (!TextUtils.isEmpty(this.s) && !this.s.equals("normal")) {
                faceunity.fuItemSetParam(this.o, TbFileVideoActivityConfig.FILTER_NAME, this.s);
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
            int i3 = this.v.f21615g;
            int i4 = this.v.f21616h;
            int i5 = this.n;
            this.n = i5 + 1;
            this.f21630i.drawFrame(faceunity.fuBeautifyImage(i2, 1, i3, i4, i5, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.u = true;
                this.f21627f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, gl10, i2, i3) == null) {
                GLES20.glViewport(0, 0, i2, i3);
                this.v.f21617i = i2;
                this.v.j = i3;
                this.f21629h.setSurface(this.f21628g);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, gl10, eGLConfig) == null) {
                k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onGenMaskCoverFinish(Bitmap bitmap, boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21614f = null;
        this.l = new a(this);
        this.n = new b(this);
        this.o = 0;
        this.q = new d(this);
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f21613e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.n);
        this.f21613e.setOnVideoSizeChangedListener(this.l);
        e eVar = new e(this, getContext(), this, this.f21613e);
        this.f21614f = eVar;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f21613e.getAudioSessionId() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    @Deprecated
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f21613e.getCurrentPosition() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f21613e.getDuration() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21613e.isPlaying() : invokeV.booleanValue;
    }

    public void n(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (mediaPlayer = this.f21613e) == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
        o(i2);
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            d.a.c.e.m.e.a().postDelayed(new c(this, i2), 500L);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            int defaultSize = GLSurfaceView.getDefaultSize(this.f21615g, i2);
            int defaultSize2 = GLSurfaceView.getDefaultSize(this.f21616h, i3);
            if (this.f21615g > 0 && this.f21616h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i4 = this.f21615g;
                    int i5 = i4 * size2;
                    int i6 = this.f21616h;
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
                    int i7 = (this.f21616h * size) / this.f21615g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i8 = (this.f21615g * size2) / this.f21616h;
                    if (mode != Integer.MIN_VALUE || i8 <= size) {
                        defaultSize = i8;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i9 = this.f21615g;
                    int i10 = this.f21616h;
                    if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                        defaultSize2 = i10;
                    } else {
                        i9 = (i9 * size2) / i10;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i9 <= size) {
                        defaultSize = i9;
                    } else {
                        defaultSize2 = (this.f21616h * size) / this.f21615g;
                        defaultSize = size;
                    }
                }
            }
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f21614f == null) {
            return;
        }
        super.onPause();
        this.f21614f.u = false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f21614f == null) {
            return;
        }
        super.onResume();
        this.f21614f.t = false;
    }

    public void p(Bitmap bitmap) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bitmap) == null) || (eVar = this.f21614f) == null) {
            return;
        }
        eVar.l(bitmap);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f21613e.isPlaying()) {
            this.f21613e.pause();
        }
    }

    public void r() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f21614f) == null) {
            return;
        }
        eVar.m();
    }

    public void s() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (mediaPlayer = this.f21613e) == null) {
            return;
        }
        mediaPlayer.start();
        this.f21613e.seekTo(0);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f21613e.seekTo(i2);
        }
    }

    public void setFilter(d.a.p0.v3.g.e.a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || (eVar = this.f21614f) == null) {
            return;
        }
        eVar.n(aVar);
    }

    public void setGenMaskCoverListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) || fVar == null) {
            return;
        }
        this.p = fVar;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onCompletionListener) == null) {
            this.f21613e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPreparedListener) == null) {
            this.m = onPreparedListener;
        }
    }

    public void setPostMonitorManager(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gVar) == null) {
            this.k = gVar;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            try {
                this.f21613e.setDataSource(str);
                this.f21613e.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.k;
                if (gVar != null) {
                    gVar.a(204, d.a.p0.x1.a.a(e2));
                }
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f21613e.start();
        }
    }

    public void t() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (mediaPlayer = this.f21613e) == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.f21613e.release();
        } catch (Throwable th) {
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(205, d.a.p0.x1.a.a(th));
            }
        }
        this.f21613e = null;
        ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(null);
    }
}
