package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.tieba.f;
import com.baidu.tieba.g;
import com.baidu.tieba.n10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class o implements n10, f.a, g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j10 a;
    public i b;
    public Executor c;
    public String d;
    public r e;
    public n10.a f;
    public int g;
    public k h;
    public f i;
    public List<g> j;

    public o(j10 j10Var, i iVar, Executor executor, String str, r rVar, n10.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j10Var, iVar, executor, str, rVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j10Var;
        this.b = iVar;
        this.c = executor;
        this.d = str;
        this.e = rVar;
        this.f = aVar;
        this.h = new k(j10Var.b().toString(), this.a.c(), this.a.a());
        this.j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            k kVar = this.h;
            File file = new File(kVar.b, kVar.a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            this.g = 107;
            i iVar = this.b;
            iVar.b.r(107);
            iVar.a.a(iVar.b);
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.a(this.d, this);
        }
    }

    @Override // com.baidu.tieba.n10
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.g;
            if (i != 101 && i != 102 && i != 103 && i != 104) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            i iVar = this.b;
            iVar.b.n(j);
            iVar.b.o(j2);
            iVar.b.p((int) ((100 * j) / j2));
            iVar.b.r(104);
            iVar.a.a(iVar.b);
        }
    }

    public void c(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((j) this.i).d()) {
                e();
                return;
            }
            if (((j) this.i).c == 106) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                h();
                return;
            }
            this.g = 108;
            i iVar = this.b;
            iVar.b.m(downloadException);
            iVar.b.r(108);
            iVar.a.a(iVar.b);
            i();
        }
    }

    public void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Iterator<g> it = this.j.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (it.hasNext()) {
                    if (((q) it.next()).e != 105) {
                        z2 = false;
                        continue;
                    }
                    if (!z2) {
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.g = 105;
                i iVar = this.b;
                iVar.b.r(105);
                iVar.b.q(str);
                iVar.a.a(iVar.b);
                i();
            }
        }
    }

    public void f(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            Iterator<g> it = this.j.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((q) it.next()).m()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.g = 108;
                i iVar = this.b;
                iVar.b.m(downloadException);
                iVar.b.r(108);
                iVar.a.a(iVar.b);
                i();
            }
        }
    }

    @Override // com.baidu.tieba.n10
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f fVar = this.i;
            if (fVar != null) {
                ((j) fVar).c = 107;
            }
            Iterator<g> it = this.j.iterator();
            while (it.hasNext()) {
                ((q) it.next()).f = 107;
            }
            if (this.g != 104) {
                g();
            }
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<g> it = this.j.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((q) it.next()).m()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                a();
                this.g = 107;
                i iVar = this.b;
                iVar.b.r(107);
                iVar.a.a(iVar.b);
                i();
            }
        }
    }

    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<g> it = this.j.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((q) it.next()).m()) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.g = 106;
                i iVar = this.b;
                iVar.b.r(106);
                iVar.a.a(iVar.b);
                i();
            }
        }
    }

    @Override // com.baidu.tieba.n10
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            f fVar = this.i;
            if (fVar != null) {
                ((j) fVar).c = 106;
            }
            Iterator<g> it = this.j.iterator();
            while (it.hasNext()) {
                ((q) it.next()).f = 106;
            }
            if (this.g != 104) {
                h();
            }
        }
    }

    @Override // com.baidu.tieba.n10
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = 101;
            i iVar = this.b;
            iVar.b.r(101);
            iVar.b.a().h();
            j jVar = new j(this.a.c(), this);
            this.i = jVar;
            this.c.execute(jVar);
        }
    }
}
