package com.baidu.tieba;

import android.graphics.SurfaceTexture;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.j8b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class upa implements j8b.b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile upa k;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public j8b.b b;
    public j8b.b c;
    public j8b.b d;
    public boolean e;
    public j8b.f f;
    public SurfaceTexture g;
    public int h;
    public boolean i;
    public j8b.a j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948220067, "Lcom/baidu/tieba/upa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948220067, "Lcom/baidu/tieba/upa;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements j8b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ upa a;

        public a(upa upaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {upaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = upaVar;
        }

        @Override // com.baidu.tieba.j8b.a
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                }
                this.a.C();
                this.a.d.k(this.a.g, this.a.f);
                if (!this.a.i) {
                    return;
                }
                this.a.i = false;
                this.a.d.n();
            }
        }
    }

    public upa(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.i = false;
        this.j = new a(this);
        this.a = tbPageContext;
        if (Build.VERSION.SDK_INT >= 21) {
            if (System.currentTimeMillis() - spa.b.c() >= spa.a) {
                spa.b.k(0);
            }
            if (1 != spa.b.d().intValue()) {
                this.c = rpa.U(tbPageContext);
            }
        }
        tpa B = tpa.B(tbPageContext);
        this.b = B;
        this.d = B;
    }

    @Override // com.baidu.tieba.j8b.b
    public void d(byte[] bArr) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) && (bVar = this.d) == this.b && bVar != null) {
            bVar.d(bArr);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void h(boolean z) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.e = z;
            if (z && (bVar = this.c) != null) {
                bVar.s(this.j);
                this.d = this.c;
                return;
            }
            j8b.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.release();
            }
            this.d = this.b;
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void i(boolean z) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (bVar = this.d) != null) {
            bVar.i(z);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void j(boolean z) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (bVar = this.d) != null) {
            bVar.j(z);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void l(int i) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (bVar = this.d) != null) {
            bVar.l(i);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void m(boolean z) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (bVar = this.d) != null) {
            bVar.m(z);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void s(j8b.a aVar) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) && (bVar = this.c) != null) {
            bVar.s(aVar);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.h = i;
            j8b.b bVar = this.d;
            if (bVar != null) {
                bVar.u(i);
            }
        }
    }

    public static upa D(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tbPageContext)) == null) {
            if (k == null) {
                synchronized (upa.class) {
                    if (k == null) {
                        k = new upa(tbPageContext);
                    } else if (tbPageContext != null) {
                        k.a = tbPageContext;
                    }
                }
            }
            return k;
        }
        return (upa) invokeL.objValue;
    }

    public static TbPageContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (k == null) {
                return null;
            }
            return k.a;
        }
        return (TbPageContext) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.b();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.e();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.i = true;
            j8b.b bVar = this.d;
            if (bVar != null) {
                bVar.n();
            }
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.o();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.p();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public void q() {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bVar = this.d) != null) {
            bVar.q();
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.r();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.j8b.b
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            q();
            this.d = null;
            j8b.b bVar = this.b;
            if (bVar != null) {
                bVar.release();
            }
            j8b.b bVar2 = this.c;
            if (bVar2 != null) {
                bVar2.release();
            }
            k = null;
            this.a = null;
            this.f = null;
            this.g = null;
            this.j = null;
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            j8b.b bVar = this.d;
            if (bVar != null) {
                return bVar.v();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c != null) {
            this.b.u(this.h);
            this.b.i(this.c.o());
            this.b.m(this.c.a());
            this.b.j(this.c.p());
            this.c.q();
            this.c.release();
            this.d = this.b;
            this.e = false;
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void c(int i, int i2, int i3, int i4) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) && (bVar = this.d) != null) {
            bVar.c(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void t(int i, int i2, int i3, int i4) {
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048597, this, i, i2, i3, i4) == null) && (bVar = this.d) != null) {
            bVar.t(i, i2, i3, i4);
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public void g(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.b.g(i, i2, i3, z);
            j8b.b bVar = this.c;
            if (bVar != null) {
                bVar.g(i, i2, i3, z);
            }
        }
    }

    @Override // com.baidu.tieba.j8b.b
    public boolean k(SurfaceTexture surfaceTexture, j8b.f fVar) {
        InterceptResult invokeLL;
        j8b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, surfaceTexture, fVar)) == null) {
            this.g = surfaceTexture;
            this.f = fVar;
            if (this.e && (bVar = this.c) != null) {
                if (bVar.k(surfaceTexture, fVar)) {
                    return true;
                }
                C();
                j8b.b bVar2 = this.d;
                if (bVar2 == null) {
                    return false;
                }
                boolean k2 = bVar2.k(surfaceTexture, fVar);
                if (this.i) {
                    this.i = false;
                    this.d.n();
                }
                return k2;
            }
            j8b.b bVar3 = this.b;
            this.d = bVar3;
            if (bVar3 == null) {
                return false;
            }
            return bVar3.k(surfaceTexture, fVar);
        }
        return invokeLL.booleanValue;
    }
}
