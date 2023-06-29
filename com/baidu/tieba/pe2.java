package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class pe2 implements fe2<ee2>, ne2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;
    public final ke2 a;
    public final LinkedList<cm2> b;
    public final List<he2<ee2>> c;
    public oe2 d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948059084, "Lcom/baidu/tieba/pe2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948059084, "Lcom/baidu/tieba/pe2;");
                return;
            }
        }
        k = ms1.a;
        l = 2;
    }

    @Override // com.baidu.tieba.ge2
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ge2
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ge2
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fe2
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ne2
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.e = true;
        }
    }

    public pe2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new LinkedList<>();
        this.c = new LinkedList();
        this.a = new ke2(l);
        this.j = new Object();
        this.e = false;
        this.f = false;
        this.g = false;
        this.i = false;
        this.h = false;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.b.isEmpty() || !this.f) {
            return;
        }
        synchronized (this.j) {
            Iterator<cm2> it = this.b.iterator();
            while (it.hasNext()) {
                cm2 next = it.next();
                if (k) {
                    Log.d("SwanAppMasterProvider", "dispatchPendingEvents event: " + next.a);
                }
                wi2.U().U0(next);
            }
            this.b.clear();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ge2
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: n */
    public oe2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.f) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProvider", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.d;
        }
        return (oe2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fe2
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProvider", "get a prefetch event - " + cVar);
            }
            c92.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo == null) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch currentAppInfo is empty");
                    return;
                }
                return;
            }
            String str2 = pMSAppInfo.appId;
            if (TextUtils.isEmpty(str2)) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "prefetch appId is empty");
                }
            } else if (this.f) {
                cc3 b0 = cc3.b0();
                if (b0 == null) {
                    return;
                }
                if (TextUtils.equals(str2, b0.getAppId())) {
                    c92.i(PrefetchEvent.MODULE, "prefetch after app start");
                    this.d.r(str, cVar, pMSAppInfo);
                    if (k) {
                        Log.w("SwanAppMasterProvider", "prefetch after app start - " + str2);
                    }
                } else if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch after swan app start");
                }
            } else if (!this.e) {
                if (k) {
                    Log.w("SwanAppMasterProvider", "can not prefetch before default mater ready");
                }
            } else {
                synchronized (this.j) {
                    if (this.f) {
                        return;
                    }
                    oe2 d = this.a.d(str2);
                    if (d == null) {
                        d = k(false, this.i);
                        this.a.f(d);
                    }
                    if (d.w(pMSAppInfo, cVar)) {
                        this.a.c(str2);
                        d = k(false, this.i);
                        this.a.f(d);
                    }
                    this.a.g(Collections.singletonList(d));
                    d.r(str, cVar, pMSAppInfo);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ge2
    public void c(he2<ee2> he2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, he2Var) != null) || he2Var == null) {
            return;
        }
        synchronized (this.j) {
            if (this.f) {
                if (k) {
                    Log.d("SwanAppMasterProvider", "app already start , call back immediately");
                }
                he2Var.a(this.h, this.d);
                return;
            }
            if (!this.c.contains(he2Var)) {
                this.c.add(he2Var);
            }
        }
    }

    @Override // com.baidu.tieba.fe2
    public void d(cm2 cm2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cm2Var) == null) && cm2Var != null && !this.f) {
            synchronized (this.j) {
                this.b.add(cm2Var);
            }
        }
    }

    @Override // com.baidu.tieba.fe2
    public void j(boolean z, ne2 ne2Var) {
        oe2 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, ne2Var) == null) {
            if (!this.g) {
                synchronized (this.j) {
                    if (!this.g) {
                        this.i = z;
                        oe2 k2 = k(true, z);
                        k2.c(this);
                        k2.c(ne2Var);
                        this.a.f(k2);
                        this.g = true;
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "call prepareDefault repeat");
            }
            if (this.f) {
                d = this.d;
            } else {
                d = this.a.d("_default_id_");
            }
            if (d != null) {
                d.c(ne2Var);
            }
        }
    }

    public final void o(boolean z, oe2 oe2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048590, this, z, oe2Var) != null) || this.c.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (he2<ee2> he2Var : this.c) {
                he2Var.a(z, oe2Var);
            }
            this.c.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProvider", "is hit prefetch env - " + z);
        }
    }

    public oe2 k(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return new oe2(z, z2);
        }
        return (oe2) invokeCommon.objValue;
    }

    public final void m(boolean z, oe2 oe2Var, PMSAppInfo pMSAppInfo) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), oe2Var, pMSAppInfo}) == null) {
            this.h = z;
            this.d = oe2Var;
            oe2Var.p(pMSAppInfo);
            this.f = true;
            l();
            if (k) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            this.a.a(Collections.singletonList(oe2Var));
            if (k) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "clear useless master cost - " + (currentTimeMillis - j) + "ms");
            }
            o(z, oe2Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ge2
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public oe2 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        long j;
        String str;
        oe2 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, pMSAppInfo)) == null) {
            if (k) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            if (pMSAppInfo == null && k) {
                Log.e("SwanAppMasterProvider", Log.getStackTraceString(new Exception("currentAppInfo can not be null")));
            }
            if (k) {
                Log.w("SwanAppMasterProvider", "real start a swan app - " + pMSAppInfo);
            }
            if (!this.e && k) {
                throw new RuntimeException("should call startApp after preload finished");
            }
            if (pMSAppInfo == null) {
                str = null;
            } else {
                str = pMSAppInfo.appId;
            }
            if (this.f) {
                return this.d;
            }
            synchronized (this.j) {
                if (!this.f) {
                    boolean z = false;
                    if (!TextUtils.isEmpty(str) && pMSAppInfo != null) {
                        d = this.a.d(str);
                        if (d != null && d.n() && !d.w(pMSAppInfo, null)) {
                            z = true;
                        } else {
                            d = this.a.d("_default_id_");
                        }
                        m(z, d, pMSAppInfo);
                    }
                    d = this.a.d("_default_id_");
                    m(z, d, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("SwanAppMasterProvider", "get right master cost - " + (currentTimeMillis - j) + "ms");
                StringBuilder sb = new StringBuilder();
                sb.append("final master id - ");
                sb.append(this.d.i().a());
                Log.i("SwanAppMasterProvider", sb.toString());
            }
            return this.d;
        }
        return (oe2) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ge2
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e = false;
            this.f = false;
            this.g = false;
            this.i = false;
            this.h = false;
            this.d = null;
            this.a.a(null);
            synchronized (this.j) {
                this.b.clear();
                this.c.clear();
            }
            ie2.c();
            le2.b().d();
        }
    }
}
