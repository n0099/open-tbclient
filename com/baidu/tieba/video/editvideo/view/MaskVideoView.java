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
import c.a.s0.h2.g;
import c.a.s0.j4.i.d.c;
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
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes12.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f50236e;

    /* renamed from: f  reason: collision with root package name */
    public e f50237f;

    /* renamed from: g  reason: collision with root package name */
    public int f50238g;

    /* renamed from: h  reason: collision with root package name */
    public int f50239h;

    /* renamed from: i  reason: collision with root package name */
    public int f50240i;

    /* renamed from: j  reason: collision with root package name */
    public int f50241j;

    /* renamed from: k  reason: collision with root package name */
    public g f50242k;
    public MediaPlayer.OnVideoSizeChangedListener l;
    public MediaPlayer.OnPreparedListener m;
    public f mMaskCoverListener;
    public MediaPlayer.OnPreparedListener n;
    public int o;
    public f p;

    /* loaded from: classes12.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50243e;

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
            this.f50243e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f50243e.f50238g = mediaPlayer.getVideoWidth();
                this.f50243e.f50239h = mediaPlayer.getVideoHeight();
                if (this.f50243e.f50238g == 0 || this.f50243e.f50239h == 0) {
                    return;
                }
                this.f50243e.getHolder().setFixedSize(this.f50243e.f50238g, this.f50243e.f50239h);
                this.f50243e.requestLayout();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50244e;

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
            this.f50244e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MediaPlayer.OnPreparedListener onPreparedListener = this.f50244e.m;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                this.f50244e.f50238g = mediaPlayer.getVideoWidth();
                this.f50244e.f50239h = mediaPlayer.getVideoHeight();
                if (this.f50244e.f50238g == 0 || this.f50244e.f50239h == 0) {
                    return;
                }
                this.f50244e.getHolder().setFixedSize(this.f50244e.f50238g, this.f50244e.f50239h);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50245e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50246f;

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
            this.f50246f = maskVideoView;
            this.f50245e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.f50246f.f50237f == null || !this.f50246f.f50237f.u) && this.f50246f.o <= 10) {
                    if (this.f50246f.f50236e != null) {
                        try {
                            this.f50246f.f50236e.seekTo(this.f50245e);
                        } catch (Exception unused) {
                        }
                    }
                    this.f50246f.requestRender();
                    MaskVideoView.i(this.f50246f);
                    this.f50246f.n(this.f50245e);
                    return;
                }
                this.f50246f.o = 0;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50247e;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f50248e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f50249f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f50250g;

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
                this.f50250g = dVar;
                this.f50248e = bitmap;
                this.f50249f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f50250g.f50247e.mMaskCoverListener.onGenMaskCoverFinish(this.f50248e, this.f50249f);
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
            this.f50247e = maskVideoView;
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) || this.f50247e.mMaskCoverListener == null) {
                return;
            }
            c.a.d.f.m.e.a().post(new a(this, bitmap, z));
        }
    }

    /* loaded from: classes12.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f50251e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f50252f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f50253g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f50254h;

        /* renamed from: i  reason: collision with root package name */
        public FullFrameRect f50255i;

        /* renamed from: j  reason: collision with root package name */
        public FullFrameRect f50256j;

        /* renamed from: k  reason: collision with root package name */
        public SurfaceTexture f50257k;
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

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f50258e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f50259f;

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
                this.f50259f = eVar;
                this.f50258e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<c.a> f2 = c.a.s0.j4.i.d.c.f(this.f50258e);
                    byte[] e2 = c.a.s0.j4.i.d.c.e(this.f50258e);
                    for (int i2 = 0; i2 < 3; i2++) {
                        int length = e2.length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(e2, 0, bArr, 0, e2.length);
                        if (length == 0) {
                            this.f50259f.v.p.onGenMaskCoverFinish(this.f50258e, false);
                        }
                        int width = this.f50258e.getWidth();
                        int height = this.f50258e.getHeight();
                        faceunity.fuRenderToNV21Image(bArr, width, height, 0, this.f50259f.r, 0);
                        Bitmap b2 = c.a.s0.j4.i.d.c.b(bArr, width, height);
                        boolean a = c.a.s0.j4.i.d.c.a(b2, f2);
                        if (a) {
                            this.f50259f.v.p.onGenMaskCoverFinish(b2, true);
                            this.f50258e.recycle();
                            return;
                        }
                        if (a || i2 >= 2) {
                            if (!a && i2 == 2) {
                                this.f50259f.v.p.onGenMaskCoverFinish(this.f50258e, false);
                            }
                        } else if (b2 != null && !b2.isRecycled()) {
                            b2.recycle();
                        }
                    }
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f50260e;

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
                this.f50260e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f50260e.f50255i != null) {
                        this.f50260e.f50255i.release(false);
                        this.f50260e.f50255i = null;
                    }
                    faceunity.fuDestroyItem(this.f50260e.p);
                    int[] iArr = this.f50260e.r;
                    this.f50260e.p = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.f50260e.o);
                    int[] iArr2 = this.f50260e.r;
                    this.f50260e.o = 0;
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
            this.f50251e = context;
            this.f50252f = gLSurfaceView;
            this.f50254h = mediaPlayer;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50255i = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f50256j = fullFrameRect;
                this.m = fullFrameRect.createTextureObject();
                this.f50257k = new SurfaceTexture(this.m);
                this.f50253g = new Surface(this.f50257k);
                int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.f50251e);
                this.o = upFaceUnity;
                this.r[0] = upFaceUnity;
                this.f50257k.setOnFrameAvailableListener(this);
            }
        }

        public void l(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if ("normal".equals(this.s)) {
                    this.v.p.onGenMaskCoverFinish(bitmap, true);
                } else if (bitmap == null || bitmap.isRecycled()) {
                    this.v.p.onGenMaskCoverFinish(bitmap, false);
                } else {
                    this.v.queueEvent(new a(this, bitmap));
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.t = true;
                this.f50252f.queueEvent(new b(this));
            }
        }

        public void n(c.a.s0.j4.i.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.s = aVar.f18646c;
            this.f50252f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gl10) == null) || this.t) {
                return;
            }
            if (this.f50255i == null) {
                k();
                this.f50254h.setSurface(this.f50253g);
            }
            this.f50257k.updateTexImage();
            this.f50257k.getTransformMatrix(this.l);
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
            int i3 = this.v.f50238g;
            int i4 = this.v.f50239h;
            int i5 = this.n;
            this.n = i5 + 1;
            this.f50255i.drawFrame(faceunity.fuBeautifyImage(i2, 1, i3, i4, i5, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.u = true;
                this.f50252f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, gl10, i2, i3) == null) {
                GLES20.glViewport(0, 0, i2, i3);
                this.v.f50240i = i2;
                this.v.f50241j = i3;
                this.f50254h.setSurface(this.f50253g);
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

    /* loaded from: classes12.dex */
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
        this.f50237f = null;
        this.l = new a(this);
        this.n = new b(this);
        this.o = 0;
        this.p = new d(this);
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f50236e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.n);
        this.f50236e.setOnVideoSizeChangedListener(this.l);
        e eVar = new e(this, getContext(), this, this.f50236e);
        this.f50237f = eVar;
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

    public void doLoopSeek(int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (mediaPlayer = this.f50236e) == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
        n(i2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50236e.getAudioSessionId() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    @Deprecated
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50236e.getCurrentPosition() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f50236e.getDuration() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f50236e.isPlaying() : invokeV.booleanValue;
    }

    public void makeMaskBitmap(Bitmap bitmap) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) || (eVar = this.f50237f) == null) {
            return;
        }
        eVar.l(bitmap);
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            c.a.d.f.m.e.a().postDelayed(new c(this, i2), 500L);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            int defaultSize = GLSurfaceView.getDefaultSize(this.f50238g, i2);
            int defaultSize2 = GLSurfaceView.getDefaultSize(this.f50239h, i3);
            if (this.f50238g > 0 && this.f50239h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i4 = this.f50238g;
                    int i5 = i4 * size2;
                    int i6 = this.f50239h;
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
                    int i7 = (this.f50239h * size) / this.f50238g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i8 = (this.f50238g * size2) / this.f50239h;
                    if (mode != Integer.MIN_VALUE || i8 <= size) {
                        defaultSize = i8;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i9 = this.f50238g;
                    int i10 = this.f50239h;
                    if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                        defaultSize2 = i10;
                    } else {
                        i9 = (i9 * size2) / i10;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i9 <= size) {
                        defaultSize = i9;
                    } else {
                        defaultSize2 = (this.f50239h * size) / this.f50238g;
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
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f50237f == null) {
            return;
        }
        super.onPause();
        this.f50237f.u = false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f50237f == null) {
            return;
        }
        super.onResume();
        this.f50237f.t = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            pauseMediaPlayer();
        }
    }

    public void pauseMediaPlayer() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f50236e.isPlaying()) {
            this.f50236e.pause();
        }
    }

    public void releaseSource() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f50237f) == null) {
            return;
        }
        eVar.m();
    }

    public void resumeMedia() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (mediaPlayer = this.f50236e) == null) {
            return;
        }
        mediaPlayer.start();
        this.f50236e.seekTo(0);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f50236e.seekTo(i2);
        }
    }

    public void setFilter(c.a.s0.j4.i.e.a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || (eVar = this.f50237f) == null) {
            return;
        }
        eVar.n(aVar);
    }

    public void setGenMaskCoverListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) || fVar == null) {
            return;
        }
        this.mMaskCoverListener = fVar;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onCompletionListener) == null) {
            this.f50236e.setOnCompletionListener(onCompletionListener);
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
            this.f50242k = gVar;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            try {
                this.f50236e.setDataSource(str);
                this.f50236e.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.f50242k;
                if (gVar != null) {
                    gVar.a(204, c.a.s0.h2.a.a(e2));
                }
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f50236e.start();
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (mediaPlayer = this.f50236e) == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.f50236e.release();
        } catch (Throwable th) {
            g gVar = this.f50242k;
            if (gVar != null) {
                gVar.a(205, c.a.s0.h2.a.a(th));
            }
        }
        this.f50236e = null;
        ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(null);
    }
}
