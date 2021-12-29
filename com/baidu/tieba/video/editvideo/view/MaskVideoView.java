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
import c.a.t0.h2.g;
import c.a.t0.k4.i.d.c;
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
    public MediaPlayer f50486e;

    /* renamed from: f  reason: collision with root package name */
    public e f50487f;

    /* renamed from: g  reason: collision with root package name */
    public int f50488g;

    /* renamed from: h  reason: collision with root package name */
    public int f50489h;

    /* renamed from: i  reason: collision with root package name */
    public g f50490i;

    /* renamed from: j  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f50491j;

    /* renamed from: k  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f50492k;
    public MediaPlayer.OnPreparedListener l;
    public int m;
    public f mMaskCoverListener;
    public f n;

    /* loaded from: classes12.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50493e;

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
            this.f50493e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i2, i3) == null) {
                this.f50493e.f50488g = mediaPlayer.getVideoWidth();
                this.f50493e.f50489h = mediaPlayer.getVideoHeight();
                if (this.f50493e.f50488g == 0 || this.f50493e.f50489h == 0) {
                    return;
                }
                this.f50493e.getHolder().setFixedSize(this.f50493e.f50488g, this.f50493e.f50489h);
                this.f50493e.requestLayout();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50494e;

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
            this.f50494e = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MediaPlayer.OnPreparedListener onPreparedListener = this.f50494e.f50492k;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                this.f50494e.f50488g = mediaPlayer.getVideoWidth();
                this.f50494e.f50489h = mediaPlayer.getVideoHeight();
                if (this.f50494e.f50488g == 0 || this.f50494e.f50489h == 0) {
                    return;
                }
                this.f50494e.getHolder().setFixedSize(this.f50494e.f50488g, this.f50494e.f50489h);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50496f;

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
            this.f50496f = maskVideoView;
            this.f50495e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.f50496f.f50487f == null || !this.f50496f.f50487f.u) && this.f50496f.m <= 10) {
                    if (this.f50496f.f50486e != null) {
                        try {
                            this.f50496f.f50486e.seekTo(this.f50495e);
                        } catch (Exception unused) {
                        }
                    }
                    this.f50496f.requestRender();
                    MaskVideoView.h(this.f50496f);
                    this.f50496f.l(this.f50495e);
                    return;
                }
                this.f50496f.m = 0;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f50497e;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Bitmap f50498e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f50499f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d f50500g;

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
                this.f50500g = dVar;
                this.f50498e = bitmap;
                this.f50499f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f50500g.f50497e.mMaskCoverListener.onGenMaskCoverFinish(this.f50498e, this.f50499f);
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
            this.f50497e = maskVideoView;
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) || this.f50497e.mMaskCoverListener == null) {
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
        public Context f50501e;

        /* renamed from: f  reason: collision with root package name */
        public GLSurfaceView f50502f;

        /* renamed from: g  reason: collision with root package name */
        public Surface f50503g;

        /* renamed from: h  reason: collision with root package name */
        public MediaPlayer f50504h;

        /* renamed from: i  reason: collision with root package name */
        public FullFrameRect f50505i;

        /* renamed from: j  reason: collision with root package name */
        public FullFrameRect f50506j;

        /* renamed from: k  reason: collision with root package name */
        public SurfaceTexture f50507k;
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
            public final /* synthetic */ Bitmap f50508e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f50509f;

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
                this.f50509f = eVar;
                this.f50508e = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<c.a> f2 = c.a.t0.k4.i.d.c.f(this.f50508e);
                    byte[] e2 = c.a.t0.k4.i.d.c.e(this.f50508e);
                    for (int i2 = 0; i2 < 3; i2++) {
                        int length = e2.length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(e2, 0, bArr, 0, e2.length);
                        if (length == 0) {
                            this.f50509f.v.n.onGenMaskCoverFinish(this.f50508e, false);
                        }
                        int width = this.f50508e.getWidth();
                        int height = this.f50508e.getHeight();
                        faceunity.fuRenderToNV21Image(bArr, width, height, 0, this.f50509f.r, 0);
                        Bitmap b2 = c.a.t0.k4.i.d.c.b(bArr, width, height);
                        boolean a = c.a.t0.k4.i.d.c.a(b2, f2);
                        if (a) {
                            this.f50509f.v.n.onGenMaskCoverFinish(b2, true);
                            this.f50508e.recycle();
                            return;
                        }
                        if (a || i2 >= 2) {
                            if (!a && i2 == 2) {
                                this.f50509f.v.n.onGenMaskCoverFinish(this.f50508e, false);
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
            public final /* synthetic */ e f50510e;

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
                this.f50510e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f50510e.f50505i != null) {
                        this.f50510e.f50505i.release(false);
                        this.f50510e.f50505i = null;
                    }
                    faceunity.fuDestroyItem(this.f50510e.p);
                    int[] iArr = this.f50510e.r;
                    this.f50510e.p = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.f50510e.o);
                    int[] iArr2 = this.f50510e.r;
                    this.f50510e.o = 0;
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
            this.f50501e = context;
            this.f50502f = gLSurfaceView;
            this.f50504h = mediaPlayer;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50505i = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f50506j = fullFrameRect;
                this.m = fullFrameRect.createTextureObject();
                this.f50507k = new SurfaceTexture(this.m);
                this.f50503g = new Surface(this.f50507k);
                int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.f50501e);
                this.o = upFaceUnity;
                this.r[0] = upFaceUnity;
                this.f50507k.setOnFrameAvailableListener(this);
            }
        }

        public void l(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if ("normal".equals(this.s)) {
                    this.v.n.onGenMaskCoverFinish(bitmap, true);
                } else if (bitmap == null || bitmap.isRecycled()) {
                    this.v.n.onGenMaskCoverFinish(bitmap, false);
                } else {
                    this.v.queueEvent(new a(this, bitmap));
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.t = true;
                this.f50502f.queueEvent(new b(this));
            }
        }

        public void n(c.a.t0.k4.i.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.s = aVar.f19380c;
            this.f50502f.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gl10) == null) || this.t) {
                return;
            }
            if (this.f50505i == null) {
                k();
                this.f50504h.setSurface(this.f50503g);
            }
            this.f50507k.updateTexImage();
            this.f50507k.getTransformMatrix(this.l);
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
            int i3 = this.v.f50488g;
            int i4 = this.v.f50489h;
            int i5 = this.n;
            this.n = i5 + 1;
            this.f50505i.drawFrame(faceunity.fuBeautifyImage(i2, 1, i3, i4, i5, this.r), this.l);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.u = true;
                this.f50502f.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, gl10, i2, i3) == null) {
                GLES20.glViewport(0, 0, i2, i3);
                this.f50504h.setSurface(this.f50503g);
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
        this.f50487f = null;
        this.f50491j = new a(this);
        this.l = new b(this);
        this.m = 0;
        this.n = new d(this);
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f50486e = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.l);
        this.f50486e.setOnVideoSizeChangedListener(this.f50491j);
        e eVar = new e(this, getContext(), this, this.f50486e);
        this.f50487f = eVar;
        setRenderer(eVar);
        setRenderMode(0);
    }

    public static /* synthetic */ int h(MaskVideoView maskVideoView) {
        int i2 = maskVideoView.m;
        maskVideoView.m = i2 + 1;
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
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (mediaPlayer = this.f50486e) == null) {
            return;
        }
        mediaPlayer.seekTo(i2);
        l(i2);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50486e.getAudioSessionId() : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50486e.getCurrentPosition() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f50486e.getDuration() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f50486e.isPlaying() : invokeV.booleanValue;
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            c.a.d.f.m.e.a().postDelayed(new c(this, i2), 500L);
        }
    }

    public void makeMaskBitmap(Bitmap bitmap) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bitmap) == null) || (eVar = this.f50487f) == null) {
            return;
        }
        eVar.l(bitmap);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            int defaultSize = GLSurfaceView.getDefaultSize(this.f50488g, i2);
            int defaultSize2 = GLSurfaceView.getDefaultSize(this.f50489h, i3);
            if (this.f50488g > 0 && this.f50489h > 0) {
                int mode = View.MeasureSpec.getMode(i2);
                int size = View.MeasureSpec.getSize(i2);
                int mode2 = View.MeasureSpec.getMode(i3);
                int size2 = View.MeasureSpec.getSize(i3);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i4 = this.f50488g;
                    int i5 = i4 * size2;
                    int i6 = this.f50489h;
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
                    int i7 = (this.f50489h * size) / this.f50488g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i8 = (this.f50488g * size2) / this.f50489h;
                    if (mode != Integer.MIN_VALUE || i8 <= size) {
                        defaultSize = i8;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i9 = this.f50488g;
                    int i10 = this.f50489h;
                    if (mode2 != Integer.MIN_VALUE || i10 <= size2) {
                        defaultSize2 = i10;
                    } else {
                        i9 = (i9 * size2) / i10;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i9 <= size) {
                        defaultSize = i9;
                    } else {
                        defaultSize2 = (this.f50489h * size) / this.f50488g;
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
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.f50487f == null) {
            return;
        }
        super.onPause();
        this.f50487f.u = false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.f50487f == null) {
            return;
        }
        super.onResume();
        this.f50487f.t = false;
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
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.f50486e.isPlaying()) {
            this.f50486e.pause();
        }
    }

    public void releaseSource() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (eVar = this.f50487f) == null) {
            return;
        }
        eVar.m();
    }

    public void resumeMedia() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (mediaPlayer = this.f50486e) == null) {
            return;
        }
        mediaPlayer.start();
        this.f50486e.seekTo(0);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f50486e.seekTo(i2);
        }
    }

    public void setFilter(c.a.t0.k4.i.e.a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) || (eVar = this.f50487f) == null) {
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
            this.f50486e.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPreparedListener) == null) {
            this.f50492k = onPreparedListener;
        }
    }

    public void setPostMonitorManager(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, gVar) == null) {
            this.f50490i = gVar;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            try {
                this.f50486e.setDataSource(str);
                this.f50486e.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.f50490i;
                if (gVar != null) {
                    gVar.a(204, c.a.t0.h2.a.a(e2));
                }
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f50486e.start();
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (mediaPlayer = this.f50486e) == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.f50486e.release();
        } catch (Throwable th) {
            g gVar = this.f50490i;
            if (gVar != null) {
                gVar.a(205, c.a.t0.h2.a.a(th));
            }
        }
        this.f50486e = null;
        ((AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).abandonAudioFocus(null);
    }
}
