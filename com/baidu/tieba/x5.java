package com.baidu.tieba;

import android.app.Application;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.chromium.net.NetError;
/* loaded from: classes9.dex */
public class x5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int A;
    public static String B = null;
    public static String C = null;
    public static int[] D = null;
    public static ArrayList<BasicNameValuePair> E = null;
    public static int a = -100000000;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448320144, "Lcom/baidu/tieba/x5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448320144, "Lcom/baidu/tieba/x5;");
                return;
            }
        }
        b = (-100000000) - 200;
        c = (-100000000) - 211;
        d = (-100000000) - 213;
        e = (-100000000) + NetError.ERR_CERTIFICATE_TRANSPARENCY_REQUIRED;
        f = (-100000000) - 221;
        g = (-100000000) - 230;
        h = (-100000000) - 232;
        i = (-100000000) - 233;
        j = (-100000000) - 234;
        k = (-100000000) - 235;
        l = (-100000000) - 236;
        m = (-100000000) - 301;
        n = (-100000000) - 302;
        o = (-100000000) - 303;
        p = (-100000000) - 306;
        q = (-100000000) - 307;
        r = (-100000000) - 308;
        s = (-100000000) + NetError.ERR_REDIRECT_CANCEL;
        t = (-100000000) + NetError.ERR_TOO_MANY_REDIRECTS;
        u = (-100000000) + NetError.ERR_UNSAFE_REDIRECT;
        v = (-100000000) + NetError.ERR_UNSAFE_PORT;
        w = (-100000000) - 313;
        x = (-100000000) - 314;
        y = (-100000000) + NetError.ERR_TOO_MANY_REDIRECTS;
        z = (-100000000) + NetError.ERR_UNSAFE_REDIRECT;
        A = (-100000000) - 400;
        D = m5.a;
        E = null;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return C;
        }
        return (String) invokeV.objValue;
    }

    public static ArrayList<BasicNameValuePair> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return E;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static int[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return D;
        }
        return (int[]) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return B;
        }
        return (String) invokeV.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            C = str;
        }
    }

    public static void f(ArrayList<BasicNameValuePair> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, arrayList) == null) {
            E = arrayList;
        }
    }

    public static void g(int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65543, null, iArr) != null) || iArr == null) {
            return;
        }
        D = iArr;
    }

    public static void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            B = str;
        }
    }

    public static String i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i2)) == null) {
            int i3 = a - i2;
            Application app = BdBaseApplication.getInst().getApp();
            if (i3 > -300 && i3 <= -200) {
                return app.getString(R.string.obfuscated_res_0x7f0f0a68);
            }
            return app.getString(R.string.obfuscated_res_0x7f0f0a69);
        }
        return (String) invokeI.objValue;
    }
}
