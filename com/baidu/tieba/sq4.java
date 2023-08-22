package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes8.dex */
public class sq4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sq4 h;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ExecutorService b;
    public ExecutorService c;
    public iq4 d;
    public hq4 e;
    public int f;
    public boolean g;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq4 a;

        public a(sq4 sq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.a.e) == null) {
                return;
            }
            hq4Var.t();
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sq4 c;

        public b(sq4 sq4Var, JSONArray jSONArray, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, jSONArray, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sq4Var;
            this.a = jSONArray;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.c.e) == null) {
                return;
            }
            hq4Var.u(this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;
        public final /* synthetic */ sq4 b;

        public c(sq4 sq4Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            this.a = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.b.e) == null) {
                return;
            }
            hq4Var.w(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq4 a;

        public d(sq4 sq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.a.e) == null) {
                return;
            }
            hq4Var.h();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sq4 c;

        public e(sq4 sq4Var, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sq4Var;
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.c.e) == null) {
                return;
            }
            if (this.a) {
                hq4Var.y(this.b);
            } else {
                hq4Var.x(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vq4 a;
        public final /* synthetic */ sq4 b;

        public f(sq4 sq4Var, vq4 vq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, vq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            this.a = vq4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.b.e) == null) {
                return;
            }
            hq4Var.r(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public nq4 a;
        public final /* synthetic */ sq4 b;

        public g(sq4 sq4Var, String str, String str2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, str2, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            this.a = new nq4(str, str2, i);
        }

        public g(sq4 sq4Var, String str, String str2, int i, String str3, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            this.a = new nq4(str, str2, i, str3, i2);
        }

        public g(sq4 sq4Var, String str, String str2, int i, String str3, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, str2, Integer.valueOf(i), str3, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            this.a = new nq4(str, str2, i, str3, j, i2);
        }

        public g(sq4 sq4Var, String str, JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, jSONObject, Integer.valueOf(i)};
                interceptable.invokeUnInit(65539, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            this.a = new nq4(str, jSONObject, i);
        }

        public void a(boolean z) {
            nq4 nq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (nq4Var = this.a) != null) {
                nq4Var.j = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b.e == null) {
                return;
            }
            this.a.b();
            if (!TextUtils.isEmpty(this.b.d.d(this.a.a))) {
                nq4 nq4Var = this.a;
                nq4Var.i = this.b.d.d(nq4Var.a);
            }
            nq4 nq4Var2 = this.a;
            if ((nq4Var2.g & 8) != 0) {
                this.b.e.l(nq4Var2);
            } else {
                this.b.e.k(nq4Var2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public final /* synthetic */ sq4 c;

        public h(sq4 sq4Var, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sq4Var;
            this.a = str;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.c.e) == null) {
                return;
            }
            hq4Var.a(this.a, this.b);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pq4 a;
        public final /* synthetic */ sq4 b;

        public i(sq4 sq4Var, Flow flow, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, flow, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sq4Var;
            pq4 pq4Var = new pq4(flow.getId(), flow.getHandle(), str, flow.getOption(), flow.isSampled());
            this.a = pq4Var;
            pq4Var.e = flow.getStartTime();
            this.a.h = "1";
            sq4Var.f++;
        }

        public void a(boolean z) {
            pq4 pq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (pq4Var = this.a) != null) {
                pq4Var.l = z;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b.e == null) {
                return;
            }
            this.a.a();
            if (!TextUtils.isEmpty(this.b.d.d(this.a.a))) {
                pq4 pq4Var = this.a;
                pq4Var.j = this.b.d.d(pq4Var.a);
            }
            this.b.e.p(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public long c;
        public JSONArray d;
        public final /* synthetic */ sq4 e;

        public j(sq4 sq4Var, String str, int i, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, Integer.valueOf(i), jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sq4Var;
            this.a = str;
            this.b = i;
            this.c = System.currentTimeMillis();
            this.d = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.e.e) == null) {
                return;
            }
            hq4Var.d(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public String c;
        public final /* synthetic */ sq4 d;

        public k(sq4 sq4Var, String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var, str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sq4Var;
            this.a = str;
            this.b = i;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            hq4 hq4Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (hq4Var = this.d.e) == null) {
                return;
            }
            hq4Var.s(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sq4 a;

        public l(sq4 sq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sq4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sq4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.setThreadPriority(10);
                this.a.d = iq4.g();
                sq4 sq4Var = this.a;
                sq4Var.e = new hq4(sq4Var.a);
                this.a.e.o();
            }
        }
    }

    public sq4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        g(jq4.getContext());
    }

    public static sq4 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (h == null) {
                synchronized (sq4.class) {
                    if (h == null) {
                        h = new sq4();
                    }
                }
            }
            return h;
        }
        return (sq4) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.execute(new d(this));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.g) {
            return;
        }
        this.g = true;
        this.b.execute(new a(this));
    }

    public synchronized Flow a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Flow d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, str, str2, i2)) == null) {
            synchronized (this) {
                d2 = d(str, i2);
                if (d2 != null && d2.getValid()) {
                    i iVar = new i(this, d2, str2);
                    if (this.d != null && this.d.m(str)) {
                        iVar.a(true);
                    }
                    this.b.execute(iVar);
                }
            }
            return d2;
        }
        return (Flow) invokeLLI.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) != null) || i2 <= 0) {
            return;
        }
        this.b.execute(new aq4(i2));
        this.c.execute(new aq4(i2));
    }

    public void o(vq4 vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vq4Var) == null) {
            this.b.execute(new f(this, vq4Var));
        }
    }

    public void s(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONArray) == null) {
            wq4.d(jSONArray);
            this.c.execute(new c(this, jSONArray));
        }
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.b.execute(new h(this, str, i2));
        }
    }

    public boolean i(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i2)) == null) {
            if (!TextUtils.equals(str, "834") || new Random().nextInt(100) < 20) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void r(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, jSONArray, str) == null) {
            wq4.d(jSONArray);
            this.c.execute(new b(this, jSONArray, str));
        }
    }

    public void t(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, str, z) == null) {
            this.b.execute(new e(this, z, str));
        }
    }

    public Flow d(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) {
            Flow flow = new Flow(str, this.f, i2);
            iq4 iq4Var = this.d;
            if (iq4Var != null && !iq4Var.c(str, i2)) {
                flow.setValid(false);
                return flow;
            } else if ((i2 & 16) != 0 && !jq4.g().c(str)) {
                flow.setValid(false);
                return flow;
            } else {
                iq4 iq4Var2 = this.d;
                if (iq4Var2 != null && iq4Var2.i(str) > 0) {
                    if (new Random().nextInt(100) >= this.d.i(str)) {
                        flow.setSampled(true);
                        return flow;
                    }
                }
                iq4 iq4Var3 = this.d;
                if (iq4Var3 != null && iq4Var3.l(str)) {
                    flow.setValid(false);
                }
                return flow;
            }
        }
        return (Flow) invokeLI.objValue;
    }

    public void e(String str, int i2, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, str, i2, jSONArray) == null) {
            this.b.execute(new j(this, str, i2, jSONArray));
        }
    }

    public void j(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, i2) == null) && !i(str, i2)) {
            g gVar = new g(this, str, str2, i2);
            iq4 iq4Var = this.d;
            if (iq4Var != null && iq4Var.m(str)) {
                gVar.a(true);
            }
            this.b.execute(gVar);
        }
    }

    public void k(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048585, this, str, jSONObject, i2) == null) && !i(str, i2)) {
            g gVar = new g(this, str, jSONObject, i2);
            iq4 iq4Var = this.d;
            if (iq4Var != null && iq4Var.m(str)) {
                gVar.a(true);
            }
            this.b.execute(gVar);
        }
    }

    public void p(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048590, this, str, i2, str2) == null) {
            this.b.execute(new k(this, str, i2, str2));
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, context) == null) && this.a == null && context != null) {
            if (context instanceof Application) {
                this.a = context;
            } else {
                this.a = context.getApplicationContext();
            }
            int i2 = xu3.e().getInt(QuickPersistConfigConst.KEY_FLOW_HANDLE, 0);
            this.f = i2;
            if (i2 > 1073741823) {
                this.f = i2 - LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            } else {
                this.f = i2 + LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            }
            ExecutorService h2 = h();
            this.b = h2;
            h2.execute(new l(this));
            this.c = Executors.newSingleThreadExecutor();
        }
    }

    public final ExecutorService h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (jq4.g() != null && !jq4.g().j()) {
                if (jq4.g().d() == null) {
                    return Executors.newSingleThreadExecutor();
                }
                return jq4.g().d();
            }
            return Executors.newSingleThreadExecutor();
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void m(String str, String str2, int i2, String str3, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Integer.valueOf(i3)}) == null) {
            this.b.execute(new g(this, str, str2, i2, str3, i3));
        }
    }

    public void n(String str, String str2, int i2, String str3, long j2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, str2, Integer.valueOf(i2), str3, Long.valueOf(j2), Integer.valueOf(i3)}) == null) {
            this.b.execute(new g(this, str, str2, i2, str3, j2, i3));
        }
    }
}
