package com.baidu.tieba;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bi1;
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
public class pi1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pi1 g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Integer, li1> a;
    public final ArrayList<bi1.a> b;
    public com.baidu.sso.h.h c;
    public Context d;
    public boolean e;
    public int f;

    /* loaded from: classes5.dex */
    public class a implements bi1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ bi1.a e;

        public a(pi1 pi1Var, li1 li1Var, Context context, int i, long j, bi1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi1Var, li1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.bi1.a
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
                    hi1.c().d(false);
                } catch (Throwable unused) {
                    bi1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    hi1.c().d(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bi1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ li1 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;
        public final /* synthetic */ bi1.a e;

        public b(pi1 pi1Var, li1 li1Var, Context context, int i, long j, bi1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pi1Var, li1Var, context, Integer.valueOf(i), Long.valueOf(j), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = li1Var;
            this.b = context;
            this.c = i;
            this.d = j;
            this.e = aVar;
        }

        @Override // com.baidu.tieba.bi1.a
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
                    hi1.c().n(false);
                } catch (Throwable unused) {
                    bi1.a aVar = this.e;
                    if (aVar != null) {
                        aVar.onFinish(str);
                    }
                    hi1.c().n(false);
                }
            }
        }
    }

    public pi1() {
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

    public static pi1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (pi1.class) {
                    if (g == null) {
                        g = new pi1();
                    }
                }
            }
            return g;
        }
        return (pi1) invokeV.objValue;
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

    public synchronized void c(int i, int i2, int i3, int i4, String str, oi1 oi1Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, oi1Var, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (oi1Var == null) {
                    return;
                }
                Pair<Boolean, bi1.a> b2 = hi1.c().b(i);
                if (!((Boolean) b2.first).booleanValue()) {
                    return;
                }
                ri1.a().b(i);
                h((bi1.a) b2.second, new ki1(i2, i3, i4, str), oi1Var.a, z);
                if (i2 == 1) {
                    oi1Var.b = 1;
                }
                if (z) {
                    int i5 = oi1Var.a;
                    if (i5 == 1) {
                        ej1.b(this.d, i4, oi1Var.b, i3, str);
                    } else if (i5 == 3) {
                        ej1.f(this.d, i4, oi1Var.b, i3, str);
                    } else if (i5 == 2) {
                        if (i2 == 3 && i3 == 2019) {
                            ci1.f(this.d).z(System.currentTimeMillis());
                            ci1.f(this.d).i(i3);
                        }
                        ej1.a(this.d, i4, i2, i3, oi1Var.c, oi1Var.d);
                    } else {
                        if (i2 == 3 && i3 == 2019) {
                            ci1.f(this.d).L(System.currentTimeMillis());
                            ci1.f(this.d).q(i3);
                        }
                        ej1.e(this.d, i4, i2, i3, oi1Var.c, oi1Var.d);
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
                    if (!aj1.f(context)) {
                        xj1.b().a(this.d, null);
                    }
                    boolean z = false;
                    if (!ei1.a(this.d).d() && oj1.j(this.d) == 0) {
                        z = true;
                    }
                    g(this.d, z);
                    oj1.l(this.d);
                    this.a.put(1, new ii1(this.d));
                    this.a.put(3, new si1(this.d));
                    this.a.put(2, new ui1(this.d));
                    this.e = true;
                }
            }
        }
    }

    public synchronized void e(Context context, int i, Pair<Integer, Integer> pair, long j, bi1.a aVar) {
        Pair<Integer, Integer> pair2;
        int intValue;
        int intValue2;
        int intValue3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            synchronized (this) {
                int i2 = -1;
                if (hi1.c().g()) {
                    this.b.add(aVar);
                    return;
                }
                this.b.clear();
                int a2 = hi1.c().a(aVar);
                try {
                    Message message = new Message();
                    message.what = a2;
                    message.arg1 = -1;
                    message.arg2 = 1;
                    this.f = -1;
                    ri1.a().c(message, j);
                    if (pair == null) {
                        pair2 = wj1.c(context);
                    } else {
                        pair2 = pair;
                    }
                    intValue = ((Integer) pair2.first).intValue();
                    intValue2 = ((Integer) pair2.second).intValue();
                    intValue3 = ((Integer) pair2.second).intValue();
                } catch (Throwable unused) {
                    i2 = a2;
                    oi1 oi1Var = new oi1();
                    oi1Var.a = 1;
                    c(i2, 3, 2009, -1, "auth login unknown error.", oi1Var, true);
                }
                if (!i(a2, intValue2, intValue, 1)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                hi1.c().i(false, true);
                if (b2 != 1 && b2 != 2 && b2 != 3) {
                    oi1 oi1Var2 = new oi1();
                    oi1Var2.a = 1;
                    c(a2, 3, 2004, b2, "has no op.", oi1Var2, true);
                    return;
                }
                li1 li1Var = this.a.get(Integer.valueOf(b2));
                if (li1Var == null) {
                    oi1 oi1Var3 = new oi1();
                    oi1Var3.a = 1;
                    c(a2, 3, 2002, b2, "not support current operator", oi1Var3, true);
                } else {
                    li1Var.m(intValue3);
                    li1Var.i(context, intValue, a2);
                    ej1.d(context, intValue3, 1, li1.q);
                }
            }
        }
    }

    public void k(Context context, int i, Pair<Integer, Integer> pair, long j, bi1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), pair, Long.valueOf(j), aVar}) == null) {
            int a2 = hi1.c().a(aVar);
            try {
                Message message = new Message();
                message.what = a2;
                message.arg1 = -1;
                message.arg2 = 3;
                this.f = -1;
                ri1.a().c(message, j);
                if (pair == null) {
                    pair = wj1.c(context);
                }
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                int intValue3 = ((Integer) pair.second).intValue();
                if (!i(a2, intValue2, intValue, 3)) {
                    return;
                }
                int b2 = b(intValue2, i);
                this.f = b2;
                if (!hi1.c().m(false, true)) {
                    oi1 oi1Var = new oi1();
                    oi1Var.a = 3;
                    c(a2, 3, 998, b2, "is doing auth prelogin.", oi1Var, false);
                } else if (b2 != 1 && b2 != 2 && b2 != 3) {
                    oi1 oi1Var2 = new oi1();
                    oi1Var2.a = 3;
                    c(a2, 3, 2004, b2, "has no op.", oi1Var2, true);
                } else {
                    li1 li1Var = this.a.get(Integer.valueOf(b2));
                    if (li1Var == null) {
                        oi1 oi1Var3 = new oi1();
                        oi1Var3.a = 3;
                        c(a2, 3, 2002, b2, "not support current operator", oi1Var3, true);
                        return;
                    }
                    li1Var.m(intValue3);
                    li1Var.h(context, a2);
                    ej1.d(context, intValue3, 3, li1.r);
                }
            } catch (Throwable unused) {
                oi1 oi1Var4 = new oi1();
                oi1Var4.a = 3;
                c(a2, 3, 2009, -1, "auth login unknown error.", oi1Var4, true);
            }
        }
    }

    public void f(Context context, long j, bi1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = hi1.c().a(aVar);
            Pair<Integer, Integer> c = wj1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (!i(a2, intValue2, intValue, 2)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                oi1 oi1Var = new oi1();
                oi1Var.a = 2;
                c(a2, 3, 2004, intValue2, "has no op.", oi1Var, true);
                return;
            }
            li1 li1Var = this.a.get(Integer.valueOf(intValue2));
            if (li1Var == null) {
                oi1 oi1Var2 = new oi1();
                oi1Var2.a = 2;
                c(a2, 3, 2002, intValue2, "not support current operator", oi1Var2, true);
            } else if (!hi1.c().e(false, true)) {
                oi1 oi1Var3 = new oi1();
                oi1Var3.a = 2;
                c(a2, 3, 998, intValue2, "is doing auth login.", oi1Var3, false);
            } else {
                ej1.d(context, intValue2, 2, li1.q);
                if (!li1Var.l()) {
                    li1Var.j(context, a2, j);
                } else if (hi1.c().g()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (hi1.c().g()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!li1Var.l()) {
                                    li1Var.j(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                oj1.d(th);
                                oi1 oi1Var4 = new oi1();
                                oi1Var4.a = 2;
                                c(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", oi1Var4, true);
                                return;
                            }
                        } else {
                            oi1 oi1Var5 = new oi1();
                            oi1Var5.a = 2;
                            c(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", oi1Var5, true);
                            return;
                        }
                    }
                } else {
                    e(context, 0, c, j, new a(this, li1Var, context, a2, j, aVar));
                }
            }
        }
    }

    public void l(Context context, long j, bi1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), aVar}) == null) {
            int a2 = hi1.c().a(aVar);
            Pair<Integer, Integer> c = wj1.c(context);
            int intValue = ((Integer) c.first).intValue();
            int intValue2 = ((Integer) c.second).intValue();
            if (!i(a2, intValue2, intValue, 4)) {
                return;
            }
            if (intValue2 != 1 && intValue2 != 2 && intValue2 != 3) {
                oi1 oi1Var = new oi1();
                oi1Var.a = 4;
                c(a2, 3, 2004, intValue2, "has no op.", oi1Var, true);
                return;
            }
            li1 li1Var = this.a.get(Integer.valueOf(intValue2));
            if (li1Var == null) {
                oi1 oi1Var2 = new oi1();
                oi1Var2.a = 4;
                c(a2, 3, 2002, intValue2, "not support current operator", oi1Var2, true);
            } else if (!hi1.c().o(false, true)) {
                oi1 oi1Var3 = new oi1();
                oi1Var3.a = 4;
                c(a2, 3, 998, intValue2, "is doing auth verify.", oi1Var3, false);
            } else {
                ej1.d(context, intValue2, 4, li1.r);
                if (!li1Var.q()) {
                    li1Var.p(context, a2, j);
                } else if (hi1.c().k()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (hi1.c().k()) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 0 && currentTimeMillis2 < j) {
                            try {
                                Thread.sleep(100L);
                                if (!li1Var.q()) {
                                    li1Var.p(context, a2, j);
                                    return;
                                }
                            } catch (Throwable th) {
                                oj1.d(th);
                                oi1 oi1Var4 = new oi1();
                                oi1Var4.a = 4;
                                c(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", oi1Var4, true);
                                return;
                            }
                        } else {
                            oi1 oi1Var5 = new oi1();
                            oi1Var5.a = 4;
                            c(a2, 3, IMConstants.IM_MSG_TYPE_ADVISORY_DISCLAIMER, intValue2, "auth out time", oi1Var5, true);
                            return;
                        }
                    }
                } else {
                    k(context, 0, c, j, new b(this, li1Var, context, a2, j, aVar));
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
                    oj1.d(th);
                }
            }
        }
    }

    public final synchronized void h(bi1.a aVar, ki1 ki1Var, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{aVar, ki1Var, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (i == 1) {
                    this.b.clear();
                    ni1.b(aVar, ki1Var, i, (ArrayList) this.b.clone(), z);
                } else {
                    ni1.b(aVar, ki1Var, i, null, z);
                }
            }
        }
    }

    public final boolean i(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4)) == null) {
            oi1 oi1Var = new oi1();
            oi1Var.a = i4;
            if (!this.e) {
                c(i, 3, 2001, i2, "has no init.", oi1Var, false);
                return false;
            } else if (TextUtils.isEmpty(bi1.b) && TextUtils.isEmpty(bi1.c)) {
                c(i, 3, 2007, i2, "has no key.", oi1Var, false);
                return false;
            } else if (this.a.isEmpty()) {
                c(i, 3, 2002, i2, "has no sdk.", oi1Var, false);
                return false;
            } else if (i3 == 0) {
                c(i, 3, 2003, i2, "has no net.", oi1Var, false);
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
                oj1.d(th);
            }
        }
    }
}
