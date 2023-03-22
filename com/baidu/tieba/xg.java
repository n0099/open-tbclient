package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.engine.ARPScriptEnvironment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public StringBuffer b;
    public StringBuffer c;
    public StringBuffer d;
    public int e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public String o;
    public boolean p;
    public boolean q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public th v;

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? "omp" : (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? ARPScriptEnvironment.KEY_DATA_PIP_TRACK : (String) invokeV.objValue;
    }

    public xg(th thVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {thVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new StringBuffer();
        this.c = new StringBuffer();
        this.d = new StringBuffer();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0L;
        this.i = 0L;
        this.j = 0L;
        this.k = 0L;
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.p = false;
        this.q = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = thVar;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if ("net".equals(str) || "op".equals(str) || "crash".equals(str) || "msg".equals(str)) {
                return "error";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.q;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                this.b = new StringBuffer();
                this.e = 0;
                this.l = 0L;
            }
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                this.c = new StringBuffer();
                this.f = 0;
                this.m = 0L;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this) {
                this.d = new StringBuffer();
                this.g = 0;
                this.n = 0L;
            }
        }
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.o;
        }
        return (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.l;
        }
        return invokeV.longValue;
    }

    public long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.n;
        }
        return invokeV.longValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.k;
        }
        return invokeV.longValue;
    }

    public StringBuffer x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.b;
        }
        return (StringBuffer) invokeV.objValue;
    }

    public StringBuffer y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.c;
        }
        return (StringBuffer) invokeV.objValue;
    }

    public StringBuffer z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.d;
        }
        return (StringBuffer) invokeV.objValue;
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.n = j;
        }
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.l = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.m = j;
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.a = str;
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.u = z;
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.t = z;
        }
    }

    public void L(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.k = j;
        }
    }

    public synchronized void a(og ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ogVar) == null) {
            synchronized (this) {
                if (ogVar != null) {
                    try {
                        this.b.append(ogVar.toString());
                        this.b.append("\r\n");
                        this.e++;
                    } catch (Exception e) {
                        BdLog.e(e);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.v != null) {
                    this.v.a(this);
                }
                this.h = System.currentTimeMillis();
            }
        }
    }

    public synchronized void b(og ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ogVar) == null) {
            synchronized (this) {
                if (ogVar != null) {
                    try {
                        this.c.append(ogVar.toString());
                        this.c.append("\r\n");
                        this.f++;
                    } catch (Exception e) {
                        BdLog.e(e);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.v != null) {
                    this.v.a(this);
                }
                this.i = System.currentTimeMillis();
            }
        }
    }

    public synchronized void c(og ogVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ogVar) == null) {
            synchronized (this) {
                if (ogVar != null) {
                    try {
                        if (ogVar.f() != null) {
                            this.d.append(ogVar.f().c().toString());
                            this.d.append("\r\n");
                            this.g++;
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.v != null) {
                    this.v.a(this);
                }
                this.j = System.currentTimeMillis();
            }
        }
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            StringBuilder sb = new StringBuilder(40);
            sb.append(this.o);
            sb.append(System.currentTimeMillis());
            sb.append(BdStatisticsManager.getInstance().getProcessName());
            sb.append("Uploading");
            sb.append(".log");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (TextUtils.isEmpty(this.r)) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.o);
                sb.append(BdStatisticsManager.getInstance().getProcessName());
                sb.append("Writing");
                sb.append(".log");
                this.r = sb.toString();
            }
            return this.r;
        }
        return (String) invokeV.objValue;
    }
}
