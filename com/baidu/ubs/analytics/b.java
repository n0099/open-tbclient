package com.baidu.ubs.analytics;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubs.analytics.a.i;
import com.baidu.ubs.analytics.a.l;
import com.baidu.ubs.analytics.a.n;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public final class b implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a l;
    public List<n> m;
    public List<com.baidu.ubs.analytics.a.a> n;
    public List<l> o;
    public List<i> p;

    /* loaded from: classes7.dex */
    public static class a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String i;
        public String osVersion;
        public String q;
        public String r;
        public String s;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        public a() {
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
            this.E = "unkonw";
        }

        public final String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.B;
            }
            return (String) invokeV.objValue;
        }

        public final String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.C;
            }
            return (String) invokeV.objValue;
        }

        public final String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.D;
            }
            return (String) invokeV.objValue;
        }

        public final String getImei() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.q;
            }
            return (String) invokeV.objValue;
        }

        public final String getOsVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.osVersion;
            }
            return (String) invokeV.objValue;
        }

        public final String getPhone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.E;
            }
            return (String) invokeV.objValue;
        }

        public final String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.i;
            }
            return (String) invokeV.objValue;
        }

        public final String r() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
                return this.r;
            }
            return (String) invokeV.objValue;
        }

        public final String s() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
                return this.s;
            }
            return (String) invokeV.objValue;
        }

        public final String t() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                return this.t;
            }
            return (String) invokeV.objValue;
        }

        public final String u() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                return this.u;
            }
            return (String) invokeV.objValue;
        }

        public final String v() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                return this.v;
            }
            return (String) invokeV.objValue;
        }

        public final String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
                return this.w;
            }
            return (String) invokeV.objValue;
        }

        public final String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
                return this.y;
            }
            return (String) invokeV.objValue;
        }

        public final String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
                return this.z;
            }
            return (String) invokeV.objValue;
        }

        public final String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                return this.A;
            }
            return (String) invokeV.objValue;
        }

        public final void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.i = str;
            }
        }

        public final void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.q = str;
            }
        }

        public final void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.r = str;
            }
        }

        public final void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.s = str;
            }
        }

        public final void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.osVersion = str;
            }
        }

        public final void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.t = str;
            }
        }

        public final void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.u = str;
            }
        }

        public final void j(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.v = str;
            }
        }

        public final void k(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
                this.w = str;
            }
        }

        public final void l(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
                this.y = str;
            }
        }

        public final void m(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
                this.x = str;
            }
        }

        public final void n(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                this.z = str;
            }
        }

        public final void o(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
                this.A = str;
            }
        }

        public final void p(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
                this.B = str;
            }
        }

        public final void q(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
                this.C = str;
            }
        }

        public final void r(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.D = str;
            }
        }

        public final void setPhone(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
                this.E = str;
            }
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

    public final List<com.baidu.ubs.analytics.a.a> getEvents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    public final a n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (a) invokeV.objValue;
    }

    public final List<n> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return (List) invokeV.objValue;
    }

    public final List<l> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return (List) invokeV.objValue;
    }

    public final List<i> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.p;
        }
        return (List) invokeV.objValue;
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public final void b(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.m = list;
        }
    }

    public final void c(List<com.baidu.ubs.analytics.a.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.n = list;
        }
    }

    public final void d(List<l> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.o = list;
        }
    }

    public final void e(List<i> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.p = list;
        }
    }
}
