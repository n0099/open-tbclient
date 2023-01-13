package com.baidu.tieba;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qi1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q;
    public static String r;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public int c;
    public int d;
    public String e;
    public long f;
    public String g;
    public String h;
    public long i;
    public long j;

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public qi1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 8000L;
        this.a = context;
    }

    public static void k(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            if (TextUtils.equals(str, FunAdSdk.PLATFORM_CM)) {
                k = str2;
                l = str3;
            } else if (TextUtils.equals(str, Config.EXCEPTION_CRASH_TYPE)) {
                m = str2;
                n = str3;
            } else if (TextUtils.equals(str, "cu")) {
                o = str2;
                p = str3;
            }
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                if (str.length() == 11 && str.contains("*") && str.charAt(3) == '*') {
                    int g0 = hi1.f(this.a).g0();
                    if (g0 <= 11 - str.replace("*", "").trim().length()) {
                        return str;
                    }
                    char[] charArray = str.toCharArray();
                    StringBuilder sb = new StringBuilder();
                    int i = g0 + 3;
                    for (int i2 = 0; i2 < charArray.length; i2++) {
                        if (i2 < 3) {
                            sb.append(charArray[i2]);
                        } else if (i2 < i) {
                            sb.append("*");
                        } else {
                            sb.append(charArray[i2]);
                        }
                    }
                    return sb.toString();
                }
                return str;
            } catch (Throwable th) {
                tj1.d(th);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public void b(int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            try {
                if (!mi1.c().l(i)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("0", this.c);
                jSONObject.put("1", this.e);
                jSONObject.put("3", this.b);
                jSONObject.put("4", uj1.b(this.a));
                if (!TextUtils.isEmpty(this.g)) {
                    jSONObject.put("5", vj1.c(this.g.getBytes(), hi1.f(this.a).k0()));
                }
                jSONObject.put("6", q);
                String b = ji1.a(this.a).b(jSONObject, this.j);
                if (!mi1.c().l(i)) {
                    return;
                }
                if (!TextUtils.isEmpty(b)) {
                    s();
                    JSONObject jSONObject2 = new JSONObject(b);
                    int optInt = jSONObject2.optInt("0", -1);
                    hi1.f(this.a).z(System.currentTimeMillis());
                    if (optInt == 0) {
                        hi1.f(this.a).i(0);
                        JSONObject optJSONObject = new JSONObject(jSONObject2.optString("1")).optJSONObject("data");
                        if (optJSONObject != null) {
                            str = optJSONObject.optString("uk");
                        } else {
                            str = "";
                        }
                        f(i, 0, 0, this.c, jSONObject2.optString("1"), optInt, str);
                        return;
                    }
                    hi1.f(this.a).i(4);
                    f(i, 4, si1.a(optInt), this.c, jSONObject2.optString("1"), optInt, "");
                    return;
                }
                f(i, 4, 2005, this.c, "server req empty.", -1, "");
            } catch (Throwable th) {
                tj1.d(th);
                d(i, 3, 2009, this.c, "post token unknown error.");
            }
        }
    }

    public void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            Message message = new Message();
            message.what = i;
            message.arg1 = this.c;
            message.arg2 = i2;
            wi1.a().c(message, this.j);
        }
    }

    public void h(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, context, i) == null) {
            r = UUID.randomUUID().toString();
            ji1.a(context).d();
            t();
        }
    }

    public void d(int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            f(i, i2, i3, i4, str, -1, "");
        }
    }

    public void n(int i, int i2, int i3, int i4, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
            o(i, i2, i3, i4, str, -1, "");
        }
    }

    public synchronized void e(int i, int i2, int i3, int i4, String str, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5)}) == null) {
            synchronized (this) {
                ti1 ti1Var = new ti1();
                ti1Var.a = i5;
                ui1.j().c(i, i2, i3, i4, str, ti1Var, true);
            }
        }
    }

    public synchronized void f(int i, int i2, int i3, int i4, String str, int i5, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), str2}) == null) {
            synchronized (this) {
                ti1 ti1Var = new ti1();
                ti1Var.a = 2;
                ti1Var.c = i5;
                ti1Var.d = str2;
                ui1.j().c(i, i2, i3, i4, str, ti1Var, true);
            }
        }
    }

    public void o(int i, int i2, int i3, int i4, String str, int i5, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Integer.valueOf(i5), str2}) == null) {
            ti1 ti1Var = new ti1();
            ti1Var.a = 4;
            ti1Var.c = i5;
            ti1Var.d = str2;
            ui1.j().c(i, i2, i3, i4, str, ti1Var, true);
        }
    }

    public void g(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048582, this, i, i2, str) != null) || !mi1.c().l(i)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", i2);
            jSONObject.put("1", str);
            String e = ji1.a(this.a).e(jSONObject, this.j);
            if (!mi1.c().l(i)) {
                return;
            }
            if (TextUtils.isEmpty(e)) {
                n(i, 4, 2005, this.c, "server req empty.");
            } else {
                t();
                JSONObject jSONObject2 = new JSONObject(e);
                int optInt = jSONObject2.optInt("0", -1);
                String optString = jSONObject2.optString("1");
                hi1.f(this.a).L(System.currentTimeMillis());
                if (optInt == 0) {
                    hi1.f(this.a).q(0);
                    o(i, 0, 0, this.c, optString, optInt, "");
                } else {
                    int a = si1.a(optInt);
                    hi1.f(this.a).q(4);
                    o(i, 4, a, this.c, optString, optInt, "");
                }
            }
        } catch (Throwable th) {
            tj1.d(th);
            n(i, 3, 2009, this.c, "post token unknown error.");
        }
    }

    public void i(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, i, i2) == null) {
            q = UUID.randomUUID().toString();
            vi1.c().j();
            ji1.a(context).d();
            s();
        }
    }

    public void j(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.j = j;
        }
    }

    public void p(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            ji1.a(context).d();
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.d = i;
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int i = this.c;
            if (i == 1) {
                if (TextUtils.isEmpty(k) || TextUtils.isEmpty(l)) {
                    return false;
                }
                return true;
            } else if (i == 3) {
                if (TextUtils.isEmpty(m) || TextUtils.isEmpty(n)) {
                    return false;
                }
                return true;
            } else if (i != 2 || TextUtils.isEmpty(o) || TextUtils.isEmpty(p)) {
                return false;
            } else {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.e = null;
            this.f = 0L;
            this.g = null;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.h = null;
            this.i = 0L;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return getClass().getSimpleName();
        }
        return (String) invokeV.objValue;
    }
}
