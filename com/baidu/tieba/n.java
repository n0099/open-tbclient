package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cloudbase.download.exception.DownloadException;
import com.baidu.tieba.e;
import com.baidu.tieba.f;
import com.baidu.tieba.f10;
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
public class n implements f10, e.a, f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b10 a;
    public h b;
    public Executor c;
    public String d;
    public q e;
    public f10.a f;
    public int g;
    public j h;
    public e i;
    public List<f> j;

    public n(b10 b10Var, h hVar, Executor executor, String str, q qVar, f10.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b10Var, hVar, executor, str, qVar, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = b10Var;
        this.b = hVar;
        this.c = executor;
        this.d = str;
        this.e = qVar;
        this.f = aVar;
        this.h = new j(b10Var.b().toString(), this.a.c(), this.a.a());
        this.j = new LinkedList();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            j jVar = this.h;
            File file = new File(jVar.b, jVar.a);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
        }
    }

    public void b(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            h hVar = this.b;
            hVar.b.n(j);
            hVar.b.o(j2);
            hVar.b.p((int) ((100 * j) / j2));
            hVar.b.r(104);
            hVar.a.a(hVar.b);
        }
    }

    public void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            if (((i) this.i).d()) {
                e();
                return;
            }
            if (((i) this.i).c == 106) {
                h();
                return;
            }
            this.g = 108;
            h hVar = this.b;
            hVar.b.m(downloadException);
            hVar.b.r(108);
            hVar.a.a(hVar.b);
            i();
        }
    }

    @Override // com.baidu.tieba.f10
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e eVar = this.i;
            if (eVar != null) {
                ((i) eVar).c = 107;
            }
            Iterator<f> it = this.j.iterator();
            while (it.hasNext()) {
                ((p) it.next()).f = 107;
            }
            if (this.g != 104) {
                g();
            }
        }
    }

    public void d(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Iterator<f> it = this.j.iterator();
            while (true) {
                z = false;
                boolean z2 = true;
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (((p) it.next()).e != 105) {
                    z2 = false;
                    continue;
                }
                if (!z2) {
                    break;
                }
            }
            if (z) {
                this.g = 105;
                h hVar = this.b;
                hVar.b.r(105);
                hVar.b.q(str);
                hVar.a.a(hVar.b);
                i();
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a();
            this.g = 107;
            h hVar = this.b;
            hVar.b.r(107);
            hVar.a.a(hVar.b);
            i();
        }
    }

    public void f(DownloadException downloadException) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadException) == null) {
            Iterator<f> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((p) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.g = 108;
                h hVar = this.b;
                hVar.b.m(downloadException);
                hVar.b.r(108);
                hVar.a.a(hVar.b);
                i();
            }
        }
    }

    public void g() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Iterator<f> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((p) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                a();
                this.g = 107;
                h hVar = this.b;
                hVar.b.r(107);
                hVar.a.a(hVar.b);
                i();
            }
        }
    }

    public void h() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Iterator<f> it = this.j.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                } else if (((p) it.next()).m()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.g = 106;
                h hVar = this.b;
                hVar.b.r(106);
                hVar.a.a(hVar.b);
                i();
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f.a(this.d, this);
        }
    }

    @Override // com.baidu.tieba.f10
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.g;
            return i == 101 || i == 102 || i == 103 || i == 104;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f10
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            e eVar = this.i;
            if (eVar != null) {
                ((i) eVar).c = 106;
            }
            Iterator<f> it = this.j.iterator();
            while (it.hasNext()) {
                ((p) it.next()).f = 106;
            }
            if (this.g != 104) {
                h();
            }
        }
    }

    @Override // com.baidu.tieba.f10
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = 101;
            h hVar = this.b;
            hVar.b.r(101);
            hVar.b.a().h();
            i iVar = new i(this.a.c(), this);
            this.i = iVar;
            this.c.execute(iVar);
        }
    }
}
