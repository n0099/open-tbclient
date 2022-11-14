package com.baidu.tieba;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.tieba.ci1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qi1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qi1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, mi1> a;
    public final ArrayList<ci1.a> b;
    public com.baidu.sso.h.h c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements ci1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ci1.a e;

        public a(qi1 qi1Var, mi1 mi1Var, Context context, int i, long j, ci1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi1Var, mi1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.ci1.a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.j(this.b, this.c, this.d);
                        return;
                    }
                    if (this.e != null) {
                        this.e.onFinish(str);
                    }
                    ii1.c().d(false);
                } catch (Throwable unused) {
                    ci1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    ii1.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ci1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ ci1.a e;

        public b(qi1 qi1Var, mi1 mi1Var, Context context, int i, long j, ci1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qi1Var, mi1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.ci1.a
        public void onFinish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    if (new JSONObject(str).optInt("0", -1) == 0) {
                        this.a.p(this.b, this.c, this.d);
                        return;
                    }
                    if (this.e != null) {
                        this.e.onFinish(str);
                    }
                    ii1.c().n(false);
                } catch (Throwable unused) {
                    ci1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    ii1.c().n(false);
                }
            }
        }
    }

    public qi1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = new ArrayList<>();
        this.f = -1;
    }

    public static qi1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (qi1.class) {
                    if (g == null) {
                        g = new qi1();
                    }
                }
            }
            return g;
        }
        return (qi1) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public final int b(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) {
            if (this.a.size() == 1) {
                return Integer.valueOf(this.a.get(this.a.keySet().iterator().next()).c).intValue();
            }
            if (this.a.size() == 2 && i2 < 4 && i2 > 0) {
                return i2;
            }
            return i;
        }
        return invokeII.intValue;
    }

    public synchronized void c(int i, int i2, int i3, int i4, String str, pi1 pi1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, pi1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (pi1Var == null) {
                    return;
                }
                Pair<Boolean, ci1.a> b2 = ii1.c().b(i);
                if (!((Boolean) b2.first).booleanValue()) {
                    return;
                }
                si1.a().b(i);
                h((ci1.a) b2.second, new li1(i2, i3, i4, str), pi1Var.a, z);
                if (i2 == 1) {
                    pi1Var.b = 1;
                }
                if (z) {
                    int i5 = pi1Var.a;
                    if (i5 == 1) {
                        fj1.b(this.d, i4, pi1Var.b, i3, str);
                    } else if (i5 == 3) {
                        fj1.f(this.d, i4, pi1Var.b, i3, str);
                    } else if (i5 == 2) {
                        if (i2 == 3 && i3 == 2019) {
                            di1.f(this.d).z(System.currentTimeMillis());
                            di1.f(this.d).i(i3);
                        }
                        fj1.a(this.d, i4, i2, i3, pi1Var.c, pi1Var.d);
                    } else {
                        if (i2 == 3 && i3 == 2019) {
                            di1.f(this.d).L(System.currentTimeMillis());
                            di1.f(this.d).q(i3);
                        }
                        fj1.e(this.d, i4, i2, i3, pi1Var.c, pi1Var.d);
                    }
                }
            }
        }
    }

    public synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            synchronized (this) {
                try {
                    if (this.e) {
                        return;
                    }
                    this.d = context.getApplicationContext();
                    if (!bj1.f(context)) {
                        yj1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!fi1.a(this.d).d() && pj1.j(this.d) == 0) {
                        z = true;
                    }
                    g(this.d, z);
                    pj1.l(this.d);
                    this.a.put(1, new ji1(this.d));
                    this.a.put(3, new ti1(this.d));
                    this.a.put(2, new vi1(this.d));
                    this.e = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i, Pair<Integer, Integer> pair, long j, ci1.a aVar) {
        Pair<Integer, Integer> pair2;
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (ii1.c().g()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = ii1.c().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    si1.a().c(message, j);
                    if (pair == null) {
                        pair2 = xj1.c(context);
                    } else {
                        pair2 = pair;
                    }
                    intValue = ((Integer) pair2.first).intValue();
                    intValue2 = ((Integer) pair2.second).intValue();
                    intValue3 = ((Integer) pair2.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    pi1 pi1Var = new pi1();
                    pi1Var.a = 1;
                    c(i2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", pi1Var, true);
                }
                if (!i(a2, intValue2, intValue, 1)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                ii1.c().i(false, true);
                if (b2 != 1 && b2 != 2 && b2 != 3) {
                    pi1 pi1Var2 = new pi1();
                    pi1Var2.a = 1;
                    c(a2, 3, 2004, b2, "has no op.", pi1Var2, true);
                    return;
                }
                mi1 mi1Var = this.a.get(Integer.valueOf(b2));
                if (mi1Var == null) {
                    pi1 pi1Var3 = new pi1();
                    pi1Var3.a = 1;
                    c(a2, 3, 2002, b2, "not support current operator", pi1Var3, true);
                } else {
                    mi1Var.m(intValue3);
                    mi1Var.i(context, intValue, a2);
                    fj1.d(context, intValue3, 1, mi1.q);
                }
            }
        }
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, ci1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            int a2 = ii1.c().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                si1.a().c(message, j);
                if (pair == null) {
                    pair = xj1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (!i(a2, intValue2, intValue, 3)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                if (!ii1.c().m(false, true)) {
                    pi1 pi1Var = new pi1();
                    pi1Var.a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", pi1Var, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    pi1 pi1Var2 = new pi1();
                    pi1Var2.a = 3;
                    c(a2, 3, 2004, b2, "has no op.", pi1Var2, true);
                } else {
                    mi1 mi1Var = this.a.get(Integer.valueOf(b2));
                    if (mi1Var == null) {
                        pi1 pi1Var3 = new pi1();
                        pi1Var3.a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", pi1Var3, true);
                        return;
                    }
                    mi1Var.m(intValue3);
                    mi1Var.h(context, a2);
                    fj1.d(context, intValue3, 3, mi1.r);
                }
            } catch (Throwable unused) {
                pi1 pi1Var4 = new pi1();
                pi1Var4.a = 3;
                c(a2, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, -1, "auth login unknown error.", pi1Var4, true);
            }
        }
    }

    public void f(Context context, long j, ci1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = ii1.c().a(aVar);
            Pair<Integer, Integer> c = xj1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (!i(a2, intValue2, intValue, 2)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                pi1 pi1Var = new pi1();
                pi1Var.a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", pi1Var, true);
                return;
            }
            mi1 mi1Var = this.a.get(Integer.valueOf(intValue2));
            if (mi1Var == null) {
                pi1 pi1Var2 = new pi1();
                pi1Var2.a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", pi1Var2, true);
            } else if (!ii1.c().e(false, true)) {
                pi1 pi1Var3 = new pi1();
                pi1Var3.a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", pi1Var3, false);
            } else {
                fj1.d(context, intValue2, 2, mi1.q);
                if (!mi1Var.l()) {
                    mi1Var.j(context, a2, j);
                } else if (ii1.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (ii1.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!mi1Var.l()) {
                                    mi1Var.j(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                pj1.d(th);
                                pi1 pi1Var4 = new pi1();
                                pi1Var4.a = 2;
                                c(a2, 3, 2019, intValue2, "auth out time", pi1Var4, true);
                                return;
                            }
                        } else {
                            pi1 pi1Var5 = new pi1();
                            pi1Var5.a = 2;
                            c(a2, 3, 2019, intValue2, "auth out time", pi1Var5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, c, j, new a(this, mi1Var, context, a2, j, aVar));
                }
            }
        }
    }

    public void l(Context context, long j, ci1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = ii1.c().a(aVar);
            Pair<Integer, Integer> c = xj1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (!i(a2, intValue2, intValue, 4)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                pi1 pi1Var = new pi1();
                pi1Var.a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", pi1Var, true);
                return;
            }
            mi1 mi1Var = this.a.get(Integer.valueOf(intValue2));
            if (mi1Var == null) {
                pi1 pi1Var2 = new pi1();
                pi1Var2.a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", pi1Var2, true);
            } else if (!ii1.c().o(false, true)) {
                pi1 pi1Var3 = new pi1();
                pi1Var3.a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", pi1Var3, false);
            } else {
                fj1.d(context, intValue2, 4, mi1.r);
                if (!mi1Var.q()) {
                    mi1Var.p(context, a2, j);
                } else if (ii1.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (ii1.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!mi1Var.q()) {
                                    mi1Var.p(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                pj1.d(th);
                                pi1 pi1Var4 = new pi1();
                                pi1Var4.a = 4;
                                c(a2, 3, 2019, intValue2, "auth out time", pi1Var4, true);
                                return;
                            }
                        } else {
                            pi1 pi1Var5 = new pi1();
                            pi1Var5.a = 4;
                            c(a2, 3, 2019, intValue2, "auth out time", pi1Var5, true);
                            return;
                        }
                    }
                } else {
                    k(context, 0, c, j, new b(this, mi1Var, context, a2, j, aVar));
                }
            }
        }
    }

    public synchronized void g(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, context, z) == null) {
            synchronized (this) {
                try {
                    m(context);
                    this.c = new com.baidu.sso.h.h();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("sso_action_t_m");
                    if (z) {
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    }
                    context.registerReceiver(this.c, intentFilter);
                } catch (Throwable th) {
                    pj1.d(th);
                }
            }
        }
    }

    public final synchronized void h(ci1.a aVar, li1 li1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, li1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (i == 1) {
                    this.b.clear();
                    oi1.b(aVar, li1Var, i, (ArrayList) this.b.clone(), z);
                } else {
                    oi1.b(aVar, li1Var, i, null, z);
                }
            }
        }
    }

    public final boolean i(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            pi1 pi1Var = new pi1();
            pi1Var.a = i4;
            if (!this.e) {
                c(i, 3, 2001, i2, "has no init.", pi1Var, false);
                return false;
            } else if (TextUtils.isEmpty(ci1.b) && TextUtils.isEmpty(ci1.c)) {
                c(i, 3, 2007, i2, "has no key.", pi1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                c(i, 3, 2002, i2, "has no sdk.", pi1Var, false);
                return false;
            } else if (i3 == 0) {
                c(i, 3, 2003, i2, "has no net.", pi1Var, false);
                return false;
            } else {
                return true;
            }
        }
        return invokeIIII.booleanValue;
    }

    public final void m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            try {
                if (this.c != null) {
                    context.unregisterReceiver(this.c);
                }
                this.c = null;
            } catch (Throwable th) {
                pj1.d(th);
            }
        }
    }
}
