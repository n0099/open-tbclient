package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.DuMixErrorType;
import com.baidu.ar.DuMixInput;
import com.baidu.ar.DuMixOutput;
import com.baidu.ar.capture.ICaptureResult;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.minivideo.arface.bean.Sticker;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.data.QmFilterItem;
import com.baidu.tieba.external.sticker.data.QmStickerItem;
import com.baidu.tieba.fva;
import com.baidu.tieba.is6;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.tieba.view.capture.camera.PicGLSurfaceView;
import com.baidu.tieba.yta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.android.gms.common.util.GmsVersion;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class js6 implements is6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public TbPageContext e;
    public yta f;
    public AspectGLSurfaceView g;
    public is6.b h;
    public is6.a i;
    public boolean j;
    public eg0 k;
    public yta.e l;
    public fva.a m;
    public yta.d n;
    public ei6 o;
    public bi6 p;

    /* loaded from: classes6.dex */
    public class d implements yta.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        @Override // com.baidu.tieba.yta.d
        public void onBeautyEnableChanged(gg0 gg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gg0Var) == null) {
            }
        }

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ d b;

            public a(d dVar, HashMap hashMap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, hashMap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    fva.j(this.a, this.b.a.m);
                }
            }
        }

        public d(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // com.baidu.tieba.yta.d
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.a.f == null || this.a.f.d()) {
            }
        }

        @Override // com.baidu.tieba.yta.d
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                wg.a().post(new a(this, hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends eg0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.ar.DuMixCallback
        public void onError(DuMixErrorType duMixErrorType, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, duMixErrorType, str, str2) == null) {
            }
        }

        @Override // com.baidu.ar.DuMixCallback
        public void onSetup(boolean z, DuMixInput duMixInput, DuMixOutput duMixOutput) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), duMixInput, duMixOutput}) == null) {
            }
        }

        public a(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.eg0, com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                super.onCaseCreate(z, str, str2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements yta.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        @Override // com.baidu.tieba.yta.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.yta.e
        public void b(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCaptureResult) == null) {
            }
        }

        @Override // com.baidu.tieba.yta.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.yta.e
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.yta.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.yta.e
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.jua.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            }
        }

        public b(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // com.baidu.tieba.jua.b
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) && this.a.i != null) {
                this.a.i.onProgress(j);
            }
        }

        @Override // com.baidu.tieba.yta.e
        public void f(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) && i > 0 && i2 > 0) {
                this.a.g.setAspectRatio(i / i2, 1);
            }
        }

        @Override // com.baidu.tieba.jua.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.a.d = true;
                if (this.a.h != null) {
                    this.a.h.b();
                }
            }
        }

        @Override // com.baidu.tieba.jua.b
        public void onStopSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
                if (this.a.f != null && this.a.h != null) {
                    this.a.h.a(this.a.f.b());
                }
                this.a.d = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements fva.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        @Override // com.baidu.tieba.fva.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void g(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i < 3000) {
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void onRecordEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        public c(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // com.baidu.tieba.fva.a
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.a.f != null) {
                this.a.f.o(z);
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void k(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.a.f != null) {
                this.a.f.D(i);
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.f != null) {
                this.a.f.n();
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void h() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.f != null) {
                this.a.f.j();
            }
        }

        @Override // com.baidu.tieba.fva.a
        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.f != null) {
                this.a.f.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ei6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        public e(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // com.baidu.tieba.ei6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.f != null) {
                    this.a.f.x(f);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements bi6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        public f(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // com.baidu.tieba.bi6
        public boolean a(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                if (this.a.f != null) {
                    this.a.f.z(f);
                    return true;
                }
                return false;
            }
            return invokeF.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        public g(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, surfaceTexture) != null) || !this.a.b) {
                return;
            }
            this.a.b = false;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yta.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ js6 a;

        public h(js6 js6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = js6Var;
        }

        @Override // com.baidu.tieba.yta.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.f != null && z) {
                this.a.f.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PicGLSurfaceView a;
        public final /* synthetic */ is6.c b;

        public i(js6 js6Var, PicGLSurfaceView picGLSurfaceView, is6.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js6Var, picGLSurfaceView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = picGLSurfaceView;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.m(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class j implements cra {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<TbPageContext> a;

        @Override // com.baidu.tieba.cra
        public jsa c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (jsa) invokeV.objValue;
        }

        @Override // com.baidu.tieba.cra
        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tieba_unknown" : (String) invokeV.objValue;
        }

        public j(TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(tbPageContext);
        }

        @Override // com.baidu.tieba.cra
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TbPageContext tbPageContext = this.a.get();
                if (tbPageContext != null) {
                    return new xca(tbPageContext.getPageActivity());
                }
                return null;
            }
            return (IMediaPlayer) invokeV.objValue;
        }

        @Override // com.baidu.tieba.cra
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return e7a.d;
            }
            return (String) invokeV.objValue;
        }
    }

    public js6(TbPageContext tbPageContext, AspectGLSurfaceView aspectGLSurfaceView, boolean z, is6.b bVar, is6.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aspectGLSurfaceView, Boolean.valueOf(z), bVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = true;
        this.c = false;
        this.d = false;
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.n = new d(this);
        this.o = new e(this);
        this.p = new f(this);
        this.e = tbPageContext;
        this.g = aspectGLSurfaceView;
        this.j = z;
        this.h = bVar;
        this.i = aVar;
        p();
    }

    @Override // com.baidu.tieba.is6
    public void g(is6.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            AspectGLSurfaceView aspectGLSurfaceView = this.g;
            if (aspectGLSurfaceView instanceof PicGLSurfaceView) {
                wg.a().postDelayed(new i(this, (PicGLSurfaceView) aspectGLSurfaceView, cVar), 500L);
            }
        }
    }

    @Override // com.baidu.tieba.is6
    public boolean a(QmFilterItem qmFilterItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qmFilterItem)) == null) {
            if (qmFilterItem == null) {
                this.f.l(null);
                return true;
            } else if (this.f != null) {
                if (!StringUtils.isNull(qmFilterItem.localPath) && !"origin".equals(qmFilterItem.localPath)) {
                    Filter filter = new Filter();
                    filter.setDataType(1);
                    filter.setLevel((tg.d(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f);
                    filter.setFile(new File(qmFilterItem.localPath));
                    this.f.l(filter);
                } else {
                    this.f.l(null);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean b(QmStickerItem qmStickerItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qmStickerItem)) == null) {
            if (qmStickerItem == null) {
                this.f.y(null, "");
                return true;
            } else if (this.f != null) {
                if ("nosticker".equals(qmStickerItem.localPath)) {
                    this.f.y(null, "");
                } else {
                    Sticker sticker = new Sticker();
                    sticker.setMaxVersion(qmStickerItem.sdkVersionMax);
                    sticker.setMiniVersion(qmStickerItem.sdkVersionMin);
                    sticker.setFile(new File(qmStickerItem.localPath));
                    this.f.y(sticker, "");
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            yta ytaVar = this.f;
            if (ytaVar != null) {
                ytaVar.C();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public ei6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return (ei6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is6
    public bi6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.p;
        }
        return (bi6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean onDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            yta ytaVar = this.f;
            if (ytaVar != null) {
                ytaVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean onPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            yta ytaVar = this.f;
            if (ytaVar != null) {
                ytaVar.f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean onResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.c) {
                q();
                this.c = true;
                return true;
            }
            yta ytaVar = this.f;
            if (ytaVar != null) {
                ytaVar.g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (m6a.a() && this.g != null) {
                r();
                this.g.a(2, 0);
                return true;
            }
            this.e.getPageActivity().finish();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean startRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            yta ytaVar = this.f;
            if (ytaVar != null) {
                ytaVar.A();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.is6
    public boolean stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            yta ytaVar = this.f;
            if (ytaVar != null) {
                ytaVar.B();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            yta ytaVar = new yta(this.e.getPageActivity());
            this.f = ytaVar;
            ytaVar.k(this.k);
            this.f.m(this.g);
            this.f.r(this.l);
            this.f.q(this.n);
            int i2 = 720;
            int i3 = 1280;
            if (this.a == 1) {
                i2 = 1280;
                i3 = 720;
            }
            this.f.i(i2, i3);
            xba D = xba.D(this.e);
            D.h(true);
            D.m(true);
            D.j(true);
            D.u(this.e.getPageActivity().getWindowManager().getDefaultDisplay().getRotation());
            this.f.c(D, 30, GmsVersion.VERSION_LONGHORN, this.j, FileHelper.getVideoTmpDir());
            this.f.t(false);
            this.f.w(true);
            this.f.v(true);
            this.f.s(false);
            this.f.u(false);
            this.f.p(new g(this));
            this.f.e(new h(this));
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            bra.c().h(TbadkCoreApplication.getInst());
            bra.c().j(FileHelper.getCacheDir());
            bra.c().k(new j(this.e));
        }
    }
}
