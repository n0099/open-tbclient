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
import com.baidu.tieba.h0b;
import com.baidu.tieba.o1b;
import com.baidu.tieba.ss6;
import com.baidu.tieba.view.capture.camera.AspectGLSurfaceView;
import com.baidu.tieba.view.capture.camera.PicGLSurfaceView;
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
/* loaded from: classes8.dex */
public class ts6 implements ss6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public boolean c;
    public boolean d;
    public TbPageContext e;
    public h0b f;
    public AspectGLSurfaceView g;
    public ss6.b h;
    public ss6.a i;
    public boolean j;
    public ig0 k;
    public h0b.e l;
    public o1b.a m;
    public h0b.d n;
    public oi6 o;
    public li6 p;

    /* loaded from: classes8.dex */
    public class d implements h0b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        @Override // com.baidu.tieba.h0b.d
        public void onBeautyEnableChanged(kg0 kg0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kg0Var) == null) {
            }
        }

        /* loaded from: classes8.dex */
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
                    o1b.j(this.a, this.b.a.m);
                }
            }
        }

        public d(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
        }

        @Override // com.baidu.tieba.h0b.d
        public void onChangeGender(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || this.a.f == null || this.a.f.d()) {
            }
        }

        @Override // com.baidu.tieba.h0b.d
        public void onLuaMessage(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hashMap) == null) {
                yg.a().post(new a(this, hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends ig0 {
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

        public a(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ig0, com.baidu.ar.DuMixCallback
        public void onCaseCreate(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                super.onCaseCreate(z, str, str2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h0b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        @Override // com.baidu.tieba.h0b.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.h0b.e
        public void b(ICaptureResult iCaptureResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iCaptureResult) == null) {
            }
        }

        @Override // com.baidu.tieba.h0b.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.h0b.e
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.h0b.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        @Override // com.baidu.tieba.h0b.e
        public void g(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.s0b.b
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            }
        }

        public b(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
        }

        @Override // com.baidu.tieba.s0b.b
        public void onProgress(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) && this.a.i != null) {
                this.a.i.onProgress(j);
            }
        }

        @Override // com.baidu.tieba.h0b.e
        public void f(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) && i > 0 && i2 > 0) {
                this.a.g.setAspectRatio(i / i2, 1);
            }
        }

        @Override // com.baidu.tieba.s0b.b
        public void onStartSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                this.a.d = true;
                if (this.a.h != null) {
                    this.a.h.b();
                }
            }
        }

        @Override // com.baidu.tieba.s0b.b
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

    /* loaded from: classes8.dex */
    public class c implements o1b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        @Override // com.baidu.tieba.o1b.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void g(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048582, this, i) != null) || i < 3000) {
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void onRecordEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            }
        }

        public c(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
        }

        @Override // com.baidu.tieba.o1b.a
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.a.f != null) {
                this.a.f.o(z);
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void k(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && this.a.f != null) {
                this.a.f.D(i);
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.f != null) {
                this.a.f.n();
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void h() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.f != null) {
                this.a.f.j();
            }
        }

        @Override // com.baidu.tieba.o1b.a
        public void i() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.f != null) {
                this.a.f.h();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements oi6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        public e(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
        }

        @Override // com.baidu.tieba.oi6
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

    /* loaded from: classes8.dex */
    public class f implements li6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        public f(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
        }

        @Override // com.baidu.tieba.li6
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

    /* loaded from: classes8.dex */
    public class g implements SurfaceTexture.OnFrameAvailableListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        public g(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
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

    /* loaded from: classes8.dex */
    public class h implements h0b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts6 a;

        public h(ts6 ts6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts6Var;
        }

        @Override // com.baidu.tieba.h0b.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.f != null && z) {
                this.a.f.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PicGLSurfaceView a;
        public final /* synthetic */ ss6.c b;

        public i(ts6 ts6Var, PicGLSurfaceView picGLSurfaceView, ss6.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts6Var, picGLSurfaceView, cVar};
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

    /* loaded from: classes8.dex */
    public static class j implements lxa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<TbPageContext> a;

        @Override // com.baidu.tieba.lxa
        public sya c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (sya) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lxa
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

        @Override // com.baidu.tieba.lxa
        public IMediaPlayer a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                TbPageContext tbPageContext = this.a.get();
                if (tbPageContext != null) {
                    return new eja(tbPageContext.getPageActivity());
                }
                return null;
            }
            return (IMediaPlayer) invokeV.objValue;
        }

        @Override // com.baidu.tieba.lxa
        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return hda.d;
            }
            return (String) invokeV.objValue;
        }
    }

    public ts6(TbPageContext tbPageContext, AspectGLSurfaceView aspectGLSurfaceView, boolean z, ss6.b bVar, ss6.a aVar) {
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

    @Override // com.baidu.tieba.ss6
    public void g(ss6.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            AspectGLSurfaceView aspectGLSurfaceView = this.g;
            if (aspectGLSurfaceView instanceof PicGLSurfaceView) {
                yg.a().postDelayed(new i(this, (PicGLSurfaceView) aspectGLSurfaceView, cVar), 500L);
            }
        }
    }

    @Override // com.baidu.tieba.ss6
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
                    filter.setLevel((vg.d(qmFilterItem.effect, 100.0f) * 1.0f) / 100.0f);
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

    @Override // com.baidu.tieba.ss6
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

    @Override // com.baidu.tieba.ss6
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss6
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h0b h0bVar = this.f;
            if (h0bVar != null) {
                h0bVar.C();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss6
    public oi6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return (oi6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ss6
    public li6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.p;
        }
        return (li6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ss6
    public boolean onDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h0b h0bVar = this.f;
            if (h0bVar != null) {
                h0bVar.a();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss6
    public boolean onPause() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            h0b h0bVar = this.f;
            if (h0bVar != null) {
                h0bVar.f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss6
    public boolean onResume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (!this.c) {
                q();
                this.c = true;
                return true;
            }
            h0b h0bVar = this.f;
            if (h0bVar != null) {
                h0bVar.g();
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
            if (pca.a() && this.g != null) {
                r();
                this.g.a(2, 0);
                return true;
            }
            this.e.getPageActivity().finish();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss6
    public boolean startRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            h0b h0bVar = this.f;
            if (h0bVar != null) {
                h0bVar.A();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ss6
    public boolean stopRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            h0b h0bVar = this.f;
            if (h0bVar != null) {
                h0bVar.B();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h0b h0bVar = new h0b(this.e.getPageActivity());
            this.f = h0bVar;
            h0bVar.k(this.k);
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
            eia D = eia.D(this.e);
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
            kxa.c().h(TbadkCoreApplication.getInst());
            kxa.c().j(FileHelper.getCacheDir());
            kxa.c().k(new j(this.e));
        }
    }
}
