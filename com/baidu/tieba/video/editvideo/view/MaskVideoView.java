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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.TbFileVideoActivityConfig;
import com.baidu.tieba.a79;
import com.baidu.tieba.qla;
import com.baidu.tieba.u69;
import com.baidu.tieba.wla;
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
/* loaded from: classes8.dex */
public class MaskVideoView extends GLSurfaceView implements MediaController.MediaPlayerControl {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaPlayer a;
    public e b;
    public int c;
    public int d;
    public a79 e;
    public MediaPlayer.OnVideoSizeChangedListener f;
    public MediaPlayer.OnPreparedListener g;
    public MediaPlayer.OnPreparedListener h;
    public int i;
    public f j;
    public f k;

    /* loaded from: classes8.dex */
    public interface f {
        void r0(Bitmap bitmap, boolean z);
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
    @Deprecated
    public int getBufferPercentage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaskVideoView a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ d c;

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
                this.c = dVar;
                this.a = bitmap;
                this.b = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.a.j.r0(this.a, this.b);
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
        public void r0(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) && this.a.j != null) {
                SafeHandler.getInst().post(new a(this, bitmap, z));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context a;
        public GLSurfaceView b;
        public Surface c;
        public MediaPlayer d;
        public FullFrameRect e;
        public FullFrameRect f;
        public SurfaceTexture g;
        public final float[] h;
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

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ e b;

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
                this.b = eVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ArrayList<qla.a> f = qla.f(this.a);
                    byte[] e = qla.e(this.a);
                    for (int i = 0; i < 3; i++) {
                        int length = e.length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(e, 0, bArr, 0, e.length);
                        if (length == 0) {
                            this.b.r.k.r0(this.a, false);
                        }
                        int width = this.a.getWidth();
                        int height = this.a.getHeight();
                        faceunity.fuRenderToNV21Image(bArr, width, height, 0, this.b.n, 0);
                        Bitmap b = qla.b(bArr, width, height);
                        boolean a = qla.a(b, f);
                        if (a) {
                            this.b.r.k.r0(b, true);
                            this.a.recycle();
                            return;
                        }
                        if (!a && i < 2) {
                            if (b != null && !b.isRecycled()) {
                                b.recycle();
                            }
                        } else if (!a && i == 2) {
                            this.b.r.k.r0(this.a, false);
                        }
                    }
                }
            }
        }

        /* loaded from: classes8.dex */
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
                    if (this.a.e != null) {
                        this.a.e.release(false);
                        this.a.e = null;
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
            this.h = new float[16];
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = new int[]{0, 0, 0};
            this.o = "normal";
            this.a = context;
            this.b = gLSurfaceView;
            this.d = mediaPlayer;
        }

        public void n(wla wlaVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, wlaVar) == null) && wlaVar != null) {
                this.o = wlaVar.c;
                this.b.requestRender();
            }
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, surfaceTexture) == null) {
                this.q = true;
                this.b.requestRender();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, gl10, eGLConfig) == null) {
                k();
            }
        }

        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_2D));
                FullFrameRect fullFrameRect = new FullFrameRect(new Texture2dProgram(Texture2dProgram.ProgramType.TEXTURE_EXT));
                this.f = fullFrameRect;
                this.i = fullFrameRect.createTextureObject();
                this.g = new SurfaceTexture(this.i);
                this.c = new Surface(this.g);
                int upFaceUnity = FaceUnityUtils.setUpFaceUnity(this.a);
                this.k = upFaceUnity;
                this.n[0] = upFaceUnity;
                this.g.setOnFrameAvailableListener(this);
            }
        }

        public void l(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                if ("normal".equals(this.o)) {
                    this.r.k.r0(bitmap, true);
                } else if (bitmap != null && !bitmap.isRecycled()) {
                    this.r.queueEvent(new a(this, bitmap));
                } else {
                    this.r.k.r0(bitmap, false);
                }
            }
        }

        public void m() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.p = true;
                this.b.queueEvent(new b(this));
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, gl10) != null) || this.p) {
                return;
            }
            if (this.e == null) {
                k();
                this.d.setSurface(this.c);
            }
            this.g.updateTexImage();
            this.g.getTransformMatrix(this.h);
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
            int i2 = this.r.c;
            int i3 = this.r.d;
            int i4 = this.j;
            this.j = i4 + 1;
            this.e.drawFrame(faceunity.fuBeautifyImage(i, 1, i2, i3, i4, this.n), this.h);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048582, this, gl10, i, i2) == null) {
                GLES20.glViewport(0, 0, i, i2);
                this.d.setSurface(this.c);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.c = mediaPlayer.getVideoWidth();
                this.a.d = mediaPlayer.getVideoHeight();
                if (this.a.c != 0 && this.a.d != 0) {
                    this.a.getHolder().setFixedSize(this.a.c, this.a.d);
                    this.a.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                MediaPlayer.OnPreparedListener onPreparedListener = this.a.g;
                if (onPreparedListener != null) {
                    onPreparedListener.onPrepared(mediaPlayer);
                }
                this.a.c = mediaPlayer.getVideoWidth();
                this.a.d = mediaPlayer.getVideoHeight();
                if (this.a.c != 0 && this.a.d != 0) {
                    this.a.getHolder().setFixedSize(this.a.c, this.a.d);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ MaskVideoView b;

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
            this.b = maskVideoView;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((this.b.b == null || !this.b.b.q) && this.b.i <= 10) {
                    if (this.b.a != null) {
                        try {
                            this.b.a.seekTo(this.a);
                        } catch (Exception unused) {
                        }
                    }
                    this.b.requestRender();
                    MaskVideoView.i(this.b);
                    this.b.n(this.a);
                    return;
                }
                this.b.i = 0;
            }
        }
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
        this.b = null;
        this.f = new a(this);
        this.h = new b(this);
        this.i = 0;
        this.k = new d(this);
        setEGLContextClientVersion(2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.h);
        this.a.setOnVideoSizeChangedListener(this.f);
        e eVar = new e(this, getContext(), this, this.a);
        this.b = eVar;
        setRenderer(eVar);
        setRenderMode(0);
    }

    public static /* synthetic */ int i(MaskVideoView maskVideoView) {
        int i = maskVideoView.i;
        maskVideoView.i = i + 1;
        return i;
    }

    public void m(int i) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) != null) || (mediaPlayer = this.a) == null) {
            return;
        }
        mediaPlayer.seekTo(i);
        n(i);
    }

    public final void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            SafeHandler.getInst().postDelayed(new c(this, i), 500L);
        }
    }

    public void o(Bitmap bitmap) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, bitmap) == null) && (eVar = this.b) != null) {
            eVar.l(bitmap);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a.seekTo(i);
        }
    }

    public void setFilter(wla wlaVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, wlaVar) == null) && (eVar = this.b) != null) {
            eVar.n(wlaVar);
        }
    }

    public void setGenMaskCoverListener(f fVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) && fVar != null) {
            this.j = fVar;
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onCompletionListener) == null) {
            this.a.setOnCompletionListener(onCompletionListener);
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, onPreparedListener) == null) {
            this.g = onPreparedListener;
        }
    }

    public void setPostMonitorManager(a79 a79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, a79Var) == null) {
            this.e = a79Var;
        }
    }

    public void setVideoPath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            try {
                this.a.setDataSource(str);
                this.a.prepare();
            } catch (Exception e2) {
                e2.printStackTrace();
                a79 a79Var = this.e;
                if (a79Var != null) {
                    a79Var.a(204, u69.a(e2));
                }
            }
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a.getAudioSessionId();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a.getDuration();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.a.isPlaying();
        }
        return invokeV.booleanValue;
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b != null) {
            super.onPause();
            this.b.q = false;
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.b != null) {
            super.onResume();
            this.b.p = false;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.a.isPlaying()) {
            this.a.pause();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            p();
        }
    }

    public void q() {
        e eVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (eVar = this.b) != null) {
            eVar.m();
        }
    }

    public void r() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (mediaPlayer = this.a) != null) {
            mediaPlayer.start();
            this.a.seekTo(0);
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a.start();
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            int defaultSize = GLSurfaceView.getDefaultSize(this.c, i);
            int defaultSize2 = GLSurfaceView.getDefaultSize(this.d, i2);
            if (this.c > 0 && this.d > 0) {
                int mode = View.MeasureSpec.getMode(i);
                int size = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size2 = View.MeasureSpec.getSize(i2);
                if (mode == 1073741824 && mode2 == 1073741824) {
                    int i3 = this.c;
                    int i4 = i3 * size2;
                    int i5 = this.d;
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
                    int i6 = (this.d * size) / this.c;
                    if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                        defaultSize2 = i6;
                        defaultSize = size;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else if (mode2 == 1073741824) {
                    int i7 = (this.c * size2) / this.d;
                    if (mode != Integer.MIN_VALUE || i7 <= size) {
                        defaultSize = i7;
                        defaultSize2 = size2;
                    }
                    defaultSize = size;
                    defaultSize2 = size2;
                } else {
                    int i8 = this.c;
                    int i9 = this.d;
                    if (mode2 == Integer.MIN_VALUE && i9 > size2) {
                        i8 = (i8 * size2) / i9;
                        defaultSize2 = size2;
                    } else {
                        defaultSize2 = i9;
                    }
                    if (mode == Integer.MIN_VALUE && i8 > size) {
                        defaultSize2 = (this.d * size) / this.c;
                        defaultSize = size;
                    } else {
                        defaultSize = i8;
                    }
                }
            }
            setMeasuredDimension(defaultSize, defaultSize2);
        }
    }

    public void stopPlayback() {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (mediaPlayer = this.a) != null) {
            try {
                mediaPlayer.stop();
                this.a.release();
            } catch (Throwable th) {
                a79 a79Var = this.e;
                if (a79Var != null) {
                    a79Var.a(205, u69.a(th));
                }
            }
            this.a = null;
            ((AudioManager) getContext().getSystemService("audio")).abandonAudioFocus(null);
        }
    }
}
