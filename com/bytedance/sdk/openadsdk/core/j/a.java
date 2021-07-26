package com.bytedance.sdk.openadsdk.core.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;

    /* renamed from: a  reason: collision with root package name */
    public String f30370a;

    /* renamed from: b  reason: collision with root package name */
    public int f30371b;

    /* renamed from: c  reason: collision with root package name */
    public int f30372c;

    /* renamed from: d  reason: collision with root package name */
    public int f30373d;

    /* renamed from: e  reason: collision with root package name */
    public int f30374e;

    /* renamed from: f  reason: collision with root package name */
    public int f30375f;

    /* renamed from: g  reason: collision with root package name */
    public int f30376g;

    /* renamed from: h  reason: collision with root package name */
    public int f30377h;

    /* renamed from: i  reason: collision with root package name */
    public int f30378i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public List<String> z;

    public a() {
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
        this.f30371b = 1;
        this.f30372c = 1;
        this.f30373d = 2;
        this.f30374e = 1;
        this.f30375f = 100;
        this.f30376g = 0;
        this.f30377h = 2;
        this.f30378i = 1;
        this.j = 3;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 2;
        this.o = 1;
        this.p = 0;
        this.q = 1500;
        this.r = 2;
        this.s = -1;
        this.t = 20;
        this.u = -1;
        this.v = 0;
        this.w = 0;
        this.x = 5;
        this.y = false;
        this.A = 2;
        this.B = 100;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new a() : (a) invokeV.objValue;
    }

    public a b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            this.v = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.w = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            this.t = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.s = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            this.p = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            this.q = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.r = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            this.n = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            this.l = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            this.m = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            this.k = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            this.j = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            this.f30371b = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            this.f30372c = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            this.f30373d = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.f30374e = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            this.f30375f = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            this.f30376g = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            this.f30377h = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
            this.f30378i = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a v(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            this.o = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
            this.A = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            this.B = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            this.x = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            this.u = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            this.f30370a = str;
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                this.z = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        this.z.add(jSONArray.get(i2).toString());
                    } catch (Exception unused) {
                    }
                }
            }
            return this;
        }
        return (a) invokeL.objValue;
    }

    public a a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.y = z;
            return this;
        }
        return (a) invokeZ.objValue;
    }
}
