package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.pg3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.WebAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
@Autowired
/* loaded from: classes6.dex */
public final class qg3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile qg3 g;
    public static final pg3.a h;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ArrayList<pg3>> a;
    public final ug3 b;
    public volatile Boolean c;
    public volatile Boolean d;
    public final boolean e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg3 a;

        public a(qg3 qg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qg3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.l();
                this.a.q().a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(@NonNull qg3 qg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, qg3Var) == null) {
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948090828, "Lcom/baidu/tieba/qg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948090828, "Lcom/baidu/tieba/qg3;");
                return;
            }
        }
        f = eo1.a;
        h = new pg3.a();
    }

    public static synchronized qg3 l() {
        InterceptResult invokeV;
        qg3 qg3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (qg3.class) {
                if (g == null) {
                    g = new qg3();
                }
                qg3Var = g;
            }
            return qg3Var;
        }
        return (qg3) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    @Inject(force = false)
    public final synchronized b q() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                bVar = new b();
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && t73.K().E() && a()) {
            ok3.k(new a(this), "preInitCookieDb");
        }
    }

    public qg3() {
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
        this.a = new LinkedHashMap(32, 0.75f, true);
        br2.g0().getSwitch("swan_cookie_enable", false);
        this.e = false;
        this.b = new ug3(this);
    }

    public static synchronized void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            synchronized (qg3.class) {
                if (g != null) {
                    g.r(z);
                }
                g = null;
            }
        }
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            return f(str, null);
        }
        return (String) invokeL.objValue;
    }

    public final synchronized void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    this.b.c();
                }
                this.b.e();
                u42.k("SwanCookieManager", "onRelease");
            }
        }
    }

    public synchronized void y(pg3 pg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, pg3Var) == null) {
            synchronized (this) {
                pg3Var.i = 1;
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c != null) {
                    u42.k("SwanCookieManager", "acceptCookie =" + this.c);
                    return this.c.booleanValue();
                }
                h();
                boolean z = false;
                if (this.d == null) {
                    return false;
                }
                if (this.d.booleanValue() && this.e) {
                    z = true;
                }
                this.c = Boolean.valueOf(z);
                u42.k("SwanCookieManager", "mEnableStore =" + this.d + "; mCookieABSwitch=" + this.e);
                return this.c.booleanValue();
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void d(ArrayList<pg3> arrayList, pg3 pg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, pg3Var) == null) {
            synchronized (this) {
                if (arrayList != null && pg3Var != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (pg3Var.e >= 0 && pg3Var.e <= currentTimeMillis) {
                        return;
                    }
                    if (arrayList.size() >= 50) {
                        pg3 pg3Var2 = new pg3();
                        pg3Var2.g = currentTimeMillis;
                        Iterator<pg3> it = arrayList.iterator();
                        while (it.hasNext()) {
                            pg3 next = it.next();
                            if (next != null && next.g < pg3Var2.g && next.i != 2) {
                                pg3Var2 = next;
                            }
                        }
                        pg3Var2.i = 2;
                    }
                    pg3Var.g = currentTimeMillis;
                    pg3Var.h = currentTimeMillis;
                    pg3Var.i = 0;
                    arrayList.add(pg3Var);
                }
            }
        }
    }

    public String f(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (f) {
                Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
            }
            if (t73.K().E() && a()) {
                if (!rg3.a(str)) {
                    return str2;
                }
                try {
                    return i(new WebAddress(str), str2);
                } catch (Exception unused) {
                    if (f) {
                        Log.e("SwanCookieManager", "Bad address: " + str);
                    }
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public final synchronized String i(WebAddress webAddress, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webAddress, str)) == null) {
            synchronized (this) {
                String[] e = rg3.e(webAddress);
                if (e == null) {
                    return str;
                }
                String d = rg3.d(e[0]);
                if (d == null) {
                    return str;
                }
                ArrayList<pg3> arrayList = this.a.get(d);
                if (arrayList == null) {
                    arrayList = this.b.k(d);
                    this.a.put(d, arrayList);
                }
                SortedSet<pg3> m = m(arrayList, webAddress.getScheme(), e);
                if (m != null && !m.isEmpty()) {
                    String b2 = rg3.b(m, str);
                    if (f) {
                        Log.d("SwanCookieManager", "getCookie result:" + b2 + ";defaultCookie=" + str);
                    }
                    return b2;
                }
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public void x(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, str, collection) == null) && !TextUtils.isEmpty(str) && collection != null && !collection.isEmpty()) {
            if (k(collection) > 4096) {
                u42.o("SwanCookieManager", "setCookie values is too large");
                return;
            }
            if (f) {
                Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
            }
            for (String str2 : collection) {
                w(str, str2);
            }
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<pg3> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, arrayList) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
                    String d = rg3.d(str2);
                    if (d == null) {
                        return;
                    }
                    ArrayList<pg3> arrayList2 = this.a.get(d);
                    if (arrayList2 == null) {
                        arrayList2 = this.b.k(d);
                        this.a.put(d, arrayList2);
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        pg3 pg3Var = arrayList.get(i);
                        if (!p(arrayList2, pg3Var, str)) {
                            d(arrayList2, pg3Var);
                        }
                    }
                }
            }
        }
    }

    public synchronized void g(pg3 pg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pg3Var) == null) {
            synchronized (this) {
                if (pg3Var == null) {
                    return;
                }
                if (pg3Var.i == 2) {
                    String d = rg3.d(pg3Var.a);
                    if (d == null) {
                        return;
                    }
                    ArrayList<pg3> arrayList = this.a.get(d);
                    if (arrayList != null) {
                        arrayList.remove(pg3Var);
                        if (arrayList.isEmpty()) {
                            this.a.remove(d);
                        }
                    }
                }
            }
        }
    }

    public final long k(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) {
            long j = 0;
            if (collection != null && !collection.isEmpty()) {
                for (String str : collection) {
                    if (str != null) {
                        j += str.length();
                    }
                }
            }
            return j;
        }
        return invokeL.longValue;
    }

    public void h() {
        SwanAppConfigData Q;
        SwanAppConfigData.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.d != null || (Q = t73.K().q().Q()) == null || (cVar = Q.r) == null) {
            return;
        }
        this.d = Boolean.valueOf(cVar.a);
        u42.k("SwanCookieManager", "enableStore =" + this.d);
    }

    public synchronized ArrayList<pg3> n() {
        InterceptResult invokeV;
        ArrayList<pg3> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (ArrayList<pg3> arrayList2 : this.a.values()) {
                    if (arrayList2 != null) {
                        Iterator<pg3> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            pg3 next = it.next();
                            if (next != null && next.i != 1) {
                                arrayList.add(next);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final synchronized SortedSet<pg3> m(ArrayList<pg3> arrayList, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, arrayList, str, strArr)) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    if (!arrayList.isEmpty() && strArr != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TreeSet treeSet = new TreeSet(h);
                        Iterator<pg3> it = arrayList.iterator();
                        while (it.hasNext()) {
                            pg3 next = it.next();
                            if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.e < 0 || next.e > currentTimeMillis)) {
                                if (!next.f || "https".equals(str)) {
                                    if (next.i != 2) {
                                        next.g = currentTimeMillis;
                                        treeSet.add(next);
                                    }
                                }
                            }
                        }
                        return treeSet;
                    }
                }
                return null;
            }
        }
        return (SortedSet) invokeLLL.objValue;
    }

    public final synchronized boolean p(ArrayList<pg3> arrayList, pg3 pg3Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, arrayList, pg3Var, str)) == null) {
            synchronized (this) {
                if (arrayList == null || pg3Var == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<pg3> it = arrayList.iterator();
                while (it.hasNext()) {
                    pg3 next = it.next();
                    if (pg3Var.b(next)) {
                        if (pg3Var.e >= 0 && pg3Var.e <= currentTimeMillis) {
                            next.h = currentTimeMillis;
                            next.i = 2;
                            return true;
                        }
                        if (!next.f || "https".equals(str)) {
                            next.d = pg3Var.d;
                            next.e = pg3Var.e;
                            next.f = pg3Var.f;
                            next.g = currentTimeMillis;
                            next.h = currentTimeMillis;
                            next.i = 3;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final ArrayList<pg3> s(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, strArr, str)) == null) {
            if (strArr == null || TextUtils.isEmpty(str)) {
                return null;
            }
            if (strArr[1].length() > 1) {
                int lastIndexOf = strArr[1].lastIndexOf(47);
                String str2 = strArr[1];
                if (lastIndexOf <= 0) {
                    lastIndexOf++;
                }
                strArr[1] = str2.substring(0, lastIndexOf);
            }
            try {
                return rg3.g(strArr[0], strArr[1], str);
            } catch (Exception unused) {
                if (!f) {
                    return null;
                }
                Log.e("SwanCookieManager", "parse cookie failed: " + str);
                return null;
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    public final synchronized void v(WebAddress webAddress, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, webAddress, str) == null) {
            synchronized (this) {
                if (webAddress != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.length() > 4096) {
                            u42.o("SwanCookieManager", "setCookie value is too large");
                            return;
                        }
                        String[] e = rg3.e(webAddress);
                        if (e == null) {
                            return;
                        }
                        e(webAddress.getScheme(), e[0], s(e, str));
                        this.b.g();
                    }
                }
            }
        }
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, str, str2) != null) || !t73.K().E() || !a() || !rg3.a(str)) {
            return;
        }
        try {
            v(new WebAddress(str), str2);
        } catch (Exception unused) {
            if (f) {
                Log.e("SwanCookieManager", "setCookie with bad address: " + str);
            }
        }
    }
}
