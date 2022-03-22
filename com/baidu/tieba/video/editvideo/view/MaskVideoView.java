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
import c.a.p0.l2.g;
import c.a.p0.n4.i.d.c;
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
/* loaded from: classes6.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;

    /* renamed from: b  reason: collision with root package name */
    public e f36444b;

    /* renamed from: c  reason: collision with root package name */
    public int f36445c;

    /* renamed from: d  reason: collision with root package name */
    public int f36446d;

    /* renamed from: e  reason: collision with root package name */
    public g f36447e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f36448f;

    /* renamed from: g  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f36449g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f36450h;
    public int i;
    public f j;
    public f k;

    /* loaded from: classes6.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaskVideoView a;

        public a(MaskVideoView maskVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048576, this, mediaPlayer, i, i2) == null) {
                this.a.f36445c = mediaPlayer.getVideoWidth();
                this.a.f36446d = mediaPlayer.getVideoHeight();
                if (this.a.f36445c == 0 || this.a.f36446d == 0) {
                    return;
                }
                this.a.getHolder().setFixedSize(this.a.f36445c, this.a.f36446d);
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements MediaPlayer.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaskVideoView a;

        public b(MaskVideoView maskVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = maskVideoView;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, mediaPlayer) == null) {
                MediaPlayer.OnPreparedListener onPreparedListener = this.a.f36449g;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                this.a.f36445c = mediaPlayer.getVideoWidth();
                this.a.f36446d = mediaPlayer.getVideoHeight();
                if (this.a.f36445c == 0 || this.a.f36446d == 0) {
                    return;
                }
                this.a.getHolder().setFixedSize(this.a.f36445c, this.a.f36446d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ MaskVideoView f36451b;

        public c(MaskVideoView maskVideoView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maskVideoView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36451b = maskVideoView;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.f36451b.f36444b == null || !this.f36451b.f36444b.q) && this.f36451b.i <= 10) {
                    if (this.f36451b.a != null) {
                        try {
                            this.f36451b.a.seekTo(this.a);
                        } catch (Exception unused) {
                        }
                    }
                    this.f36451b.requestRender();
                    MaskVideoView.r(this.f36451b);
                    this.f36451b.w(this.a);
                    return;
                }
                this.f36451b.i = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaskVideoView a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ boolean f36452b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ d f36453c;

            public a(d dVar, Bitmap bitmap, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, bitmap, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36453c = dVar;
                this.a = bitmap;
                this.f36452b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f36453c.a.j.onGenMaskCoverFinish(this.a, this.f36452b);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = maskVideoView;
        }

        @Override // com.baidu.tieba.video.editvideo.view.MaskVideoView.f
        public void onGenMaskCoverFinish(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) || this.a.j == null) {
                return;
            }
            c.a.d.f.m.e.a().post(new a(this, bitmap, z));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;

        /* renamed from: b  reason: collision with root package name */
        public GLSurfaceView f36454b;

        /* renamed from: c  reason: collision with root package name */
        public Surface f36455c;

        /* renamed from: d  reason: collision with root package name */
        public MediaPlayer f36456d;

        /* renamed from: e  reason: collision with root package name */
        public FullFrameRect f36457e;

        /* renamed from: f  reason: collision with root package name */
        public FullFrameRect f36458f;

        /* renamed from: g  reason: collision with root package name */
        public SurfaceTexture f36459g;

        /* renamed from: h  reason: collision with root package name */
        public final float[] f36460h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int[] n;
        public String o;
        public volatile boolean p;
        public volatile boolean q;
        public final /* synthetic */ MaskVideoView r;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f36461b;

            public a(e eVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36461b = eVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<c.a> f2 = c.a.p0.n4.i.d.c.f(this.a);
                    byte[] e2 = c.a.p0.n4.i.d.c.e(this.a);
                    for (int i = 0; i < 3; i++) {
                        int length = e2.length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(e2, 0, bArr, 0, e2.length);
                        if (length == 0) {
                            this.f36461b.r.k.onGenMaskCoverFinish(this.a, false);
                        }
                        int width = this.a.getWidth();
                        int height = this.a.getHeight();
                        faceunity.fuRenderToNV21Image(bArr, width, height, 0, this.f36461b.n, 0);
                        Bitmap b2 = c.a.p0.n4.i.d.c.b(bArr, width, height);
                        boolean a = c.a.p0.n4.i.d.c.a(b2, f2);
                        if (a) {
                            this.f36461b.r.k.onGenMaskCoverFinish(b2, true);
                            this.a.recycle();
                            return;
                        }
                        if (a || i >= 2) {
                            if (!a && i == 2) {
                                this.f36461b.r.k.onGenMaskCoverFinish(this.a, false);
                            }
                        } else if (b2 != null && !b2.isRecycled()) {
                            b2.recycle();
                        }
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.f36457e != null) {
                        this.a.f36457e.release(false);
                        this.a.f36457e = null;
                    }
                    faceunity.fuDestroyItem(this.a.l);
                    int[] iArr = this.a.n;
                    this.a.l = 0;
                    iArr[1] = 0;
                    faceunity.fuDestroyItem(this.a.k);
                    int[] iArr2 = this.a.n;
                    this.a.k = 0;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.r = maskVideoView;
            this.f36460h = new float[16];
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = new int[]{0, 0, 0};
            this.o = "normal";
            this.a = context;
            this.f36454b = gLSurfaceView;
            this.f36456d = mediaPlayer;
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36457e = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f36458f = fullFrameRect;
                this.i = fullFrameRect.createTextureObject();
                this.f36459g = new SurfaceTexture(this.i);
                this.f36455c = new Surface(this.f36459g);
                int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.a);
                this.k = upFaceUnity;
                this.n[0] = upFaceUnity;
                this.f36459g.setOnFrameAvailableListener(this);
            }
        }

        public void l(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if ("normal".equals(this.o)) {
                    this.r.k.onGenMaskCoverFinish(bitmap, true);
                } else if (bitmap == null || bitmap.isRecycled()) {
                    this.r.k.onGenMaskCoverFinish(bitmap, false);
                } else {
                    this.r.queueEvent(new a(this, bitmap));
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.p = true;
                this.f36454b.queueEvent(new b(this));
            }
        }

        public void n(c.a.p0.n4.i.e.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
                return;
            }
            this.o = aVar.f16666c;
            this.f36454b.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, gl10) == null) || this.p) {
                return;
            }
            if (this.f36457e == null) {
                k();
                this.f36456d.setSurface(this.f36455c);
            }
            this.f36459g.updateTexImage();
            this.f36459g.getTransformMatrix(this.f36460h);
            if (!TextUtils.isEmpty(this.o) && !this.o.equals("normal")) {
                faceunity.fuItemSetParam(this.k, TbFileVideoActivityConfig.FILTER_NAME, this.o);
            }
            faceunity.fuItemSetParam(this.k, "color_level", 0.0d);
            faceunity.fuItemSetParam(this.k, "blur_level", 0.0d);
            faceunity.fuItemSetParam(this.k, "cheek_thinning", 0.0d);
            faceunity.fuItemSetParam(this.k, "eye_enlarging", 0.0d);
            faceunity.fuItemSetParam(this.k, "face_shape", 0.0d);
            faceunity.fuItemSetParam(this.k, "face_shape_level", 0.0d);
            faceunity.fuItemSetParam(this.k, "red_level", 0.0d);
            faceunity.fuItemSetParam(this.k, "eye_bright", 0.0d);
            faceunity.fuItemSetParam(this.k, "tooth_whiten", 0.0d);
            int i = this.i;
            int i2 = this.r.f36445c;
            int i3 = this.r.f36446d;
            int i4 = this.j;
            this.j = i4 + 1;
            this.f36457e.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.n), this.f36460h);
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.q = true;
                this.f36454b.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, gl10, i, i2) == null) {
                GLES20.glViewport(0, 0, i, i2);
                this.f36456d.setSurface(this.f36455c);
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

    /* loaded from: classes6.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36444b = null;
        this.f36448f = new a(this);
        this.f36450h = new b(this);
        this.i = 0;
        this.k = new d(this);
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.f36450h);
        this.a.setOnVideoSizeChangedListener(this.f36448f);
        e eVar = new e(this, getContext(), this, this.a);
        this.f36444b = eVar;
        setRenderer(eVar);
        setRenderMode(0);
    }

    public static /* synthetic */ int r(MaskVideoView maskVideoView) {
        int i = maskVideoView.i;
        maskVideoView.i = i + 1;
        return i;
    }

    public void A() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.start();
        this.a.seekTo(0);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.getAudioSessionId() : invokeV.intValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.getCurrentPosition() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.getDuration() : invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.isPlaying() : invokeV.booleanValue;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            int defaultSize = GLSurfaceView.getDefaultSize(this.f36445c, i);
            int defaultSize2 = GLSurfaceView.getDefaultSize(this.f36446d, i2);
            if (this.f36445c > 0 && this.f36446d > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int size = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i3 = this.f36445c;
                    int i4 = i3 * size2;
                    int i5 = this.f36446d;
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
                    int i6 = (this.f36446d * size) / this.f36445c;
                    if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                        defaultSize2 = i6;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i7 = (this.f36445c * size2) / this.f36446d;
                    if (mode != Integer.MIN_VALUE || i7 <= size) {
                        defaultSize = i7;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i8 = this.f36445c;
                    int i9 = this.f36446d;
                    if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                        defaultSize2 = i9;
                    } else {
                        i8 = (i8 * size2) / i9;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i8 <= size) {
                        defaultSize = i8;
                    } else {
                        defaultSize2 = (this.f36446d * size) / this.f36445c;
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
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f36444b == null) {
            return;
        }
        super.onPause();
        this.f36444b.q = false;
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f36444b == null) {
            return;
        }
        super.onResume();
        this.f36444b.p = false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            y();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.a.seekTo(i);
        }
    }

    public void setFilter(c.a.p0.n4.i.e.a aVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || (eVar = this.f36444b) == null) {
            return;
        }
        eVar.n(aVar);
    }

    public void setGenMaskCoverListener(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) || fVar == null) {
            return;
        }
        this.j = fVar;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onCompletionListener) == null) {
            this.a.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onPreparedListener) == null) {
            this.f36449g = onPreparedListener;
        }
    }

    public void setPostMonitorManager(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, gVar) == null) {
            this.f36447e = gVar;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            try {
                this.a.setDataSource(str);
                this.a.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
                g gVar = this.f36447e;
                if (gVar != null) {
                    gVar.a(204, c.a.p0.l2.a.a(e2));
                }
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.a.start();
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (mediaPlayer = this.a) == null) {
            return;
        }
        try {
            mediaPlayer.stop();
            this.a.release();
        } catch (Throwable th) {
            g gVar = this.f36447e;
            if (gVar != null) {
                gVar.a(205, c.a.p0.l2.a.a(th));
            }
        }
        this.a = null;
        ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
    }

    public void v(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.seekTo(i);
        w(i);
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            c.a.d.f.m.e.a().postDelayed(new c(this, i), 500L);
        }
    }

    public void x(Bitmap bitmap) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, bitmap) == null) || (eVar = this.f36444b) == null) {
            return;
        }
        eVar.l(bitmap);
    }

    public void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && this.a.isPlaying()) {
            this.a.pause();
        }
    }

    public void z() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (eVar = this.f36444b) == null) {
            return;
        }
        eVar.m();
    }
}
