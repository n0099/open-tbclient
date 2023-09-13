package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.xd2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class zd2 implements kd2<jd2>, sd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile yd2 a;
    public volatile yd2 b;
    public final LinkedList<hl2> c;
    public final List<md2<jd2>> d;
    public yd2 e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public boolean i;
    public final Object j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948356033, "Lcom/baidu/tieba/zd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948356033, "Lcom/baidu/tieba/zd2;");
                return;
            }
        }
        k = rr1.a;
        boolean z = true;
        if (hf2.l() != 1) {
            z = false;
        }
        l = z;
    }

    @Override // com.baidu.tieba.ld2
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ld2
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ld2
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kd2
    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.sd2
    public void onReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f = true;
        }
    }

    public zd2() {
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
        this.c = new LinkedList<>();
        this.d = new LinkedList();
        this.j = new Object();
        this.f = false;
        this.g = false;
        this.i = false;
        this.h = false;
    }

    @Override // com.baidu.tieba.kd2
    public void b(String str, PrefetchEvent.c cVar, PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar, pMSAppInfo) == null) {
            if (k) {
                Log.i("SwanAppMasterProviderMulti", "get a prefetch event - " + cVar);
            }
            if (!this.f) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "can not prefetch before default mater ready");
                    return;
                }
                return;
            }
            h82.i(PrefetchEvent.MODULE, "start prefetch master");
            if (pMSAppInfo != null) {
                String str2 = pMSAppInfo.appId;
                if (!TextUtils.isEmpty(str2)) {
                    if (k) {
                        xd2.c().h("SwanAppMasterProviderMulti");
                    }
                    if (this.g) {
                        hb3 b0 = hb3.b0();
                        if (b0 != null && TextUtils.equals(str2, b0.getAppId())) {
                            h82.i(PrefetchEvent.MODULE, "prefetch after app start");
                            this.e.r(str, cVar, pMSAppInfo);
                            return;
                        } else if (k) {
                            Log.w("SwanAppMasterProviderMulti", "can not prefetch after swan app start, only same app allowed");
                            return;
                        } else {
                            return;
                        }
                    }
                    synchronized (this.j) {
                        if (this.g) {
                            return;
                        }
                        if (this.b == null || this.b.w(pMSAppInfo, cVar)) {
                            m(this.b);
                            this.b = l(false, this.i);
                        }
                        this.b.r(str, cVar, pMSAppInfo);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "prefetch currentAppInfo is empty or appId is empty");
            }
        }
    }

    @Override // com.baidu.tieba.ld2
    public void c(md2<jd2> md2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, md2Var) != null) || md2Var == null) {
            return;
        }
        synchronized (this.j) {
            if (this.g) {
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "app already start , call back immediately");
                }
                md2Var.a(this.h, this.e);
                return;
            }
            if (!this.d.contains(md2Var)) {
                this.d.add(md2Var);
            }
        }
    }

    @Override // com.baidu.tieba.kd2
    public void d(hl2 hl2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hl2Var) == null) && hl2Var != null && !this.g) {
            synchronized (this.j) {
                this.c.add(hl2Var);
            }
        }
    }

    public final void k(yd2 yd2Var) {
        yd2 yd2Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yd2Var) == null) {
            if (yd2Var == this.b) {
                yd2Var2 = this.a;
            } else {
                yd2Var2 = this.b;
            }
            this.a = yd2Var;
            m(yd2Var2);
            this.b = null;
        }
    }

    @Override // com.baidu.tieba.kd2
    public void j(boolean z, sd2 sd2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048585, this, z, sd2Var) == null) {
            if (this.a == null) {
                synchronized (this.j) {
                    if (this.a == null) {
                        this.i = z;
                        this.a = l(true, z);
                        this.a.c(this);
                        this.a.c(sd2Var);
                        return;
                    }
                }
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "call prepareDefault repeat");
            }
            if (this.a != null) {
                this.a.c(sd2Var);
            }
        }
    }

    public final void q(boolean z, yd2 yd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048593, this, z, yd2Var) != null) || this.d.size() <= 0) {
            return;
        }
        synchronized (this.j) {
            for (md2<jd2> md2Var : this.d) {
                md2Var.a(z, yd2Var);
            }
            this.d.clear();
        }
        if (k) {
            Log.d("SwanAppMasterProviderMulti", "is hit prefetch env - " + z);
        }
    }

    public yd2 l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            xd2.c().b(!z);
            return new yd2(z, z2);
        }
        return (yd2) invokeCommon.objValue;
    }

    public final void m(yd2 yd2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, yd2Var) == null) && yd2Var != null && yd2Var.i() != null) {
            yd2Var.i().destroy();
            if (k) {
                Log.i("SwanAppMasterProviderMulti", "master destroy, id - " + yd2Var.i().a() + ", isReady - " + yd2Var.n() + ", is Default - " + yd2Var.l());
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.c.isEmpty() || !this.g) {
            return;
        }
        synchronized (this.j) {
            Iterator<hl2> it = this.c.iterator();
            while (it.hasNext()) {
                hl2 next = it.next();
                if (k) {
                    Log.d("SwanAppMasterProviderMulti", "dispatchPendingEvents event: " + next.a);
                }
                bi2.U().U0(next);
            }
            this.c.clear();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ld2
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: p */
    public yd2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (!this.g) {
                if (k) {
                    Log.w("SwanAppMasterProviderMulti", "master not final confirmed, has default - " + f());
                    Log.w("SwanAppMasterProviderMulti", Log.getStackTraceString(new RuntimeException("throw by debug")));
                    return null;
                }
                return null;
            }
            return this.e;
        }
        return (yd2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ld2
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (k) {
                Log.d("SwanAppMasterProviderMulti", "release master provider");
            }
            this.f = false;
            this.g = false;
            this.i = false;
            this.h = false;
            m(this.a);
            m(this.b);
            this.a = null;
            this.b = null;
            this.e = null;
            synchronized (this.j) {
                this.c.clear();
                this.d.clear();
            }
            nd2.c();
            qd2.b().d();
            xd2.c().a();
        }
    }

    public final void o(boolean z, yd2 yd2Var, PMSAppInfo pMSAppInfo) {
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), yd2Var, pMSAppInfo}) == null) {
            this.h = z;
            this.e = yd2Var;
            yd2Var.p(pMSAppInfo);
            this.g = true;
            n();
            k(yd2Var);
            if (k) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            if (k) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "clear useless master cost - " + (currentTimeMillis - j) + "ms");
            }
            q(z, yd2Var);
            xd2.c().a();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0128, code lost:
        if (r7 == false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x012c A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f A[Catch: all -> 0x0180, TryCatch #0 {, blocks: (B:23:0x0065, B:25:0x0069, B:27:0x006d, B:28:0x0076, B:30:0x007c, B:34:0x0088, B:36:0x0091, B:58:0x0135, B:37:0x0095, B:39:0x009d, B:40:0x00a1, B:42:0x00c6, B:47:0x011f, B:54:0x012c, B:55:0x012f, B:56:0x0132, B:59:0x0138), top: B:72:0x0065 }] */
    @Override // com.baidu.tieba.ld2
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public yd2 e(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        long j;
        yd2 yd2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, pMSAppInfo)) == null) {
            if (k) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            if ((pMSAppInfo == null || !this.f) && k) {
                Log.e("SwanAppMasterProviderMulti", Log.getStackTraceString(new Exception("currentAppInfo can not be null， and should call startApp after preload finished")));
            }
            if (k) {
                Log.w("SwanAppMasterProviderMulti", "real start a swan app - " + pMSAppInfo);
                Log.w("SwanAppMasterProviderMulti", "is default master ready - " + this.f);
            }
            if (this.g) {
                return this.e;
            }
            synchronized (this.j) {
                if (!this.g) {
                    if (k) {
                        xd2.c().h("SwanAppMasterProviderMulti");
                    }
                    boolean z = true;
                    if (this.b != null && this.b.n() && pMSAppInfo != null) {
                        if (this.b.w(pMSAppInfo, null)) {
                            yd2Var = this.a;
                            z = false;
                            o(z, yd2Var, pMSAppInfo);
                        } else {
                            if (this.b.j()) {
                                yd2Var = this.b;
                            } else {
                                xd2.a aVar = new xd2.a(pMSAppInfo.appKey, pMSAppInfo.versionCode);
                                boolean f = xd2.c().f(aVar);
                                boolean g = xd2.c().g(aVar);
                                boolean e = xd2.c().e();
                                if (k) {
                                    Log.d("SwanAppMasterProviderMulti", "app - " + aVar + ", is loaded - " + f);
                                    Log.d("SwanAppMasterProviderMulti", "app - " + aVar + ", is loading - " + g);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("has loading app now - ");
                                    sb.append(e);
                                    Log.d("SwanAppMasterProviderMulti", sb.toString());
                                }
                                if (e && !g) {
                                    if (f && l) {
                                        if (z) {
                                            yd2Var = this.b;
                                        } else {
                                            yd2Var = this.a;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                if (z) {
                                }
                            }
                            o(z, yd2Var, pMSAppInfo);
                        }
                    }
                    yd2Var = this.a;
                    z = false;
                    o(z, yd2Var, pMSAppInfo);
                }
            }
            if (k) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("SwanAppMasterProviderMulti", "get right master cost - " + (currentTimeMillis - j) + "ms");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("final master id - ");
                sb2.append(this.e.i().a());
                Log.i("SwanAppMasterProviderMulti", sb2.toString());
            }
            return this.e;
        }
        return (yd2) invokeL.objValue;
    }
}
