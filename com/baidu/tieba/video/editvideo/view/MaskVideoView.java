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
import b.a.r0.a2.g;
import b.a.r0.z3.i.d.c;
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
/* loaded from: classes9.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f54716e;

    /* renamed from: f  reason: collision with root package name */
    public e f54717f;

    /* renamed from: g  reason: collision with root package name */
    public int f54718g;

    /* renamed from: h  reason: collision with root package name */
    public int f54719h;

    /* renamed from: i  reason: collision with root package name */
    public int f54720i;
    public int j;
    public g k;
    public MediaPlayer.OnVideoSizeChangedListener l;
    public MediaPlayer.OnPreparedListener m;
    public f mMaskCoverListener;
    public MediaPlayer.OnPreparedListener n;
    public int o;
    public f p;

    /* loaded from: classes9.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f54721e;

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
            this.f54721e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f54721e.f54718g = mediaPlayer.getVideoWidth();
                this.f54721e.f54719h = mediaPlayer.getVideoHeight();
                if (this.f54721e.f54718g == 0 || this.f54721e.f54719h == 0) {
                    return;
                }
                this.f54721e.getHolder().setFixedSize(this.f54721e.f54718g, this.f54721e.f54719h);
                this.f54721e.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f54722e;

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
            this.f54722e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MediaPlayer.OnPreparedListener onPreparedListener = this.f54722e.m;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                this.f54722e.f54718g = mediaPlayer.getVideoWidth();
                this.f54722e.f54719h = mediaPlayer.getVideoHeight();
                if (this.f54722e.f54718g == 0 || this.f54722e.f54719h == 0) {
                    return;
                }
                this.f54722e.getHolder().setFixedSize(this.f54722e.f54718g, this.f54722e.f54719h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54723e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f54724f;

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
            this.f54724f = maskVideoView;
            this.f54723e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.f54724f.f54717f == null || !this.f54724f.f54717f.u) && this.f54724f.o <= 10) {
                    if (this.f54724f.f54716e != null) {
                        try {
                            this.f54724f.f54716e.seekTo(this.f54723e);
                        } catch (Exception unused) {
                        }
                    }
                    this.f54724f.requestRender();
                    MaskVideoView.i(this.f54724f);
                    this.f54724f.n(this.f54723e);
                    return;
                }
                this.f54724f.o = 0;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f54725e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f54726e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f54727f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f54728g;

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
                this.f54728g = dVar;
                this.f54726e = bitmap;
                this.f54727f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f54728g.f54725e.mMaskCoverListener.onGenMaskCoverFinish(this.f54726e, this.f54727f);
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
            this.f54725e = maskVideoView;
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) || this.f54725e.mMaskCoverListener == null) {
                return;
            }
            b.a.e.e.m.e.a().post(new a(this, bitmap, z));
        }
    }

    /* loaded from: classes9.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Context f54729e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f54730f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f54731g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f54732h;

        /* renamed from: i  reason: collision with root package name */
        public FullFrameRect f54733i;
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

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f54734e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f54735f;

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
                this.f54735f = eVar;
                this.f54734e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<c.a> f2 = b.a.r0.z3.i.d.c.f(this.f54734e);
                    byte[] e2 = b.a.r0.z3.i.d.c.e(this.f54734e);
                    for (int i2 = 0; i2 < 3; i2++) {
                        int length = e2.length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(e2, 0, bArr, 0, e2.length);
                        if (length == 0) {
                            this.f54735f.v.p.onGenMaskCoverFinish(this.f54734e, false);
                        }
                        int width = this.f54734e.getWidth();
                        int height = this.f54734e.getHeight();
                        faceunity.fuRenderToNV21Image(bArr, width, height, 0, this.f54735f.r, 0);
                        Bitmap b2 = b.a.r0.z3.i.d.c.b(bArr, width, height);
                        boolean a2 = b.a.r0.z3.i.d.c.a(b2, f2);
                        if (a2) {
                            this.f54735f.v.p.onGenMaskCoverFinish(b2, true);
                            this.f54734e.recycle();
                            return;
                        }
                        if (a2 || i2 >= 2) {
                            if (!a2 && i2 == 2) {
                                this.f54735f.v.p.onGenMaskCoverFinish(this.f54734e, false);
                            }
                        } else if (b2 != null && !b2.isRecycled()) {
                            b2.recycle();
                        }
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f54736e;

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
                this.f54736e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f54736e.f54733i != null) {
                        this.f54736e.f54733i.release(false);
                        this.f54736e.f54733i = null;
                    }
                    faceunity.fuDestroyItem(this.f54736e.p);
                    int[] iArr = this.f54736e.r;
                    this.f54736e.p = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.f54736e.o);
                    int[] iArr2 = this.f54736e.r;
                    this.f54736e.o = 0;
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
            this.f54729e = context;
            this.f54730f = gLSurfaceView;
            this.f54732h = mediaPlayer;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54733i = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.j = fullFrameRect;
                this.m = fullFrameRect.createTextureObject();
                this.k = new SurfaceTexture(this.m);
                this.f54731g = new Surface(this.k);
                int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.f54729e);
                this.o = upFaceUnity;
                this.r[0] = upFaceUnity;
                this.k.setOnFrameAvailableListener(this);
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
                this.f54730f.queueEvent(new b(this));
            }
        }

        public void n(b.a.r0.z3.i.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.s = aVar.f28381c;
            this.f54730f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gl10) == null) || this.t) {
                return;
            }
            if (this.f54733i == null) {
                k();
                this.f54732h.setSurface(this.f54731g);
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
            int i3 = this.v.f54718g;
            int i4 = this.v.f54719h;
            int i5 = this.n;
            this.n = i5 + 1;
            this.f54733i.drawFrame(faceunity.fuBeautifyImage(i2, 1, i3, i4, i5, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.u = true;
                this.f54730f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, gl10, i2, i3) == null) {
                GLES20.glViewport(0, 0, i2, i3);
                this.v.f54720i = i2;
                this.v.j = i3;
                this.f54732h.setSurface(this.f54731g);
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

    /* loaded from: classes9.dex */
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
        this.f54717f = null;
        this.l = new a(this);
        this.n = new b(this);
        this.o = 0;
        this.p = new d(this);
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f54716e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.n);
        this.f54716e.setOnVideoSizeChangedListener(this.l);
        e eVar = new e(this, getContext(), this, this.f54716e);
        this.f54717f = eVar;
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
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (mediaPlayer = this.f54716e) == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
        n(i2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f54716e.getAudioSessionId() : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54716e.getCurrentPosition() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f54716e.getDuration() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f54716e.isPlaying() : invokeV.booleanValue;
    }

    public void makeMaskBitmap(Bitmap bitmap) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bitmap) == null) || (eVar = this.f54717f) == null) {
            return;
        }
        eVar.l(bitmap);
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            b.a.e.e.m.e.a().postDelayed(new c(this, i2), 500L);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            int defaultSize = GLSurfaceView.getDefaultSize(this.f54718g, i2);
            int defaultSize2 = GLSurfaceView.getDefaultSize(this.f54719h, i3);
            if (this.f54718g > 0 && this.f54719h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i4 = this.f54718g;
                    int i5 = i4 * size2;
                    int i6 = this.f54719h;
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
                    int i7 = (this.f54719h * size) / this.f54718g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i8 = (this.f54718g * size2) / this.f54719h;
                    if (mode != Integer.MIN_VALUE || i8 <= size) {
                        defaultSize = i8;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i9 = this.f54718g;
                    int i10 = this.f54719h;
                    if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                        defaultSize2 = i10;
                    } else {
                        i9 = (i9 * size2) / i10;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i9 <= size) {
                        defaultSize = i9;
                    } else {
                        defaultSize2 = (this.f54719h * size) / this.f54718g;
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
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f54717f == null) {
            return;
        }
        super.onPause();
        this.f54717f.u = false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f54717f == null) {
            return;
        }
        super.onResume();
        this.f54717f.t = false;
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
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f54716e.isPlaying()) {
            this.f54716e.pause();
        }
    }

    public void releaseSource() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f54717f) == null) {
            return;
        }
        eVar.m();
    }

    public void resumeMedia() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (mediaPlayer = this.f54716e) == null) {
            return;
        }
        mediaPlayer.start();
        this.f54716e.seekTo(0);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f54716e.seekTo(i2);
        }
    }

    public void setFilter(b.a.r0.z3.i.e.a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || (eVar = this.f54717f) == null) {
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
            this.f54716e.setOnCompletionListener(onCompletionListener);
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
                this.f54716e.setDataSource(str);
                this.f54716e.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.k;
                if (gVar != null) {
                    gVar.a(204, b.a.r0.a2.a.a(e2));
                }
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f54716e.start();
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (mediaPlayer = this.f54716e) == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.f54716e.release();
        } catch (Throwable th) {
            g gVar = this.k;
            if (gVar != null) {
                gVar.a(205, b.a.r0.a2.a.a(th));
            }
        }
        this.f54716e = null;
        ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(null);
    }
}
