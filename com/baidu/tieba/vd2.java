package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.ud2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class vd2 implements of4<JSONArray> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public final wd2 a;
    public final String b;
    public gd4 c;
    public gd4 d;
    public xf3 e;
    public boolean f;
    public boolean g;
    public final Collection<xi3<vd2>> h;
    public final Collection<xi3<vd2>> i;
    public ud2.b j;

    /* loaded from: classes6.dex */
    public class a implements Function1<xf3, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vd2 a;

        public a(vd2 vd2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vd2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vd2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(xf3 xf3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xf3Var)) == null) {
                if (vd2.k) {
                    Log.i("SoUpdating", "install: " + this.a.k() + " onCallback");
                }
                this.a.i(xf3Var);
                this.a.f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236869, "Lcom/baidu/tieba/vd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236869, "Lcom/baidu/tieba/vd2;");
                return;
            }
        }
        k = ok1.a;
    }

    public final synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.h.clear();
                this.i.clear();
            }
        }
    }

    public gd4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return (gd4) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public gd4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c == null && !TextUtils.isEmpty(this.b)) {
                this.c = bc4.i().t(this.b);
            }
            return this.c;
        }
        return (gd4) invokeV.objValue;
    }

    public ud2.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (ud2.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (n() && (this.e == null || td2.d.k(k()))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            gd4 gd4Var = this.d;
            if (gd4Var != null && gd4Var != this.c) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!n() && this.f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public vd2(@NonNull wd2 wd2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wd2Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = false;
        this.h = new HashSet();
        this.i = new HashSet();
        this.j = null;
        this.a = wd2Var;
        this.b = str;
    }

    public vd2 w(wd2 wd2Var, gd4 gd4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, wd2Var, gd4Var)) == null) {
            if (r(wd2Var)) {
                this.d = gd4Var;
            }
            return this;
        }
        return (vd2) invokeLL.objValue;
    }

    public synchronized vd2 g(xi3<vd2> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xi3Var)) == null) {
            synchronized (this) {
                this.h.remove(xi3Var);
            }
            return this;
        }
        return (vd2) invokeL.objValue;
    }

    public synchronized vd2 h(xi3<vd2> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xi3Var)) == null) {
            synchronized (this) {
                this.i.remove(xi3Var);
            }
            return this;
        }
        return (vd2) invokeL.objValue;
    }

    public boolean r(wd2 wd2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, wd2Var)) == null) {
            if (wd2Var != null && wd2Var == this.a) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized vd2 u(xi3<vd2> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, xi3Var)) == null) {
            synchronized (this) {
                this.h.add(xi3Var);
            }
            return this;
        }
        return (vd2) invokeL.objValue;
    }

    public synchronized vd2 v(xi3<vd2> xi3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, xi3Var)) == null) {
            synchronized (this) {
                this.i.add(xi3Var);
            }
            return this;
        }
        return (vd2) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.of4
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        boolean z;
        long j;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            gd4 l = l();
            if (k) {
                Log.i("SoUpdating", "decorateParams libName=" + this.b + " localSo=" + l);
            }
            try {
                for (AbiType abiType : AbiType.currentAbi().getCompatible()) {
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop abi=" + abiType);
                    }
                    if (abiType != null) {
                        ch4 d = ch4.d(this.b, abiType);
                        if (k) {
                            Log.i("SoUpdating", "decorateParams loop bundleId=" + d);
                        }
                        if (d != null) {
                            JSONObject jSONObject = new JSONObject();
                            if (l != null && abiType == l.q) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (l != null && z) {
                                j = l.i;
                            } else {
                                j = 0;
                            }
                            String str2 = "0";
                            if (l == null || !z) {
                                str = "0";
                            } else {
                                str = l.j;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d.b);
                            jSONObject.put("version_code", j);
                            jSONObject.put("version_name", str2);
                            if (k) {
                                Log.i("SoUpdating", "decorate abi=" + abiType + " jo=" + jSONObject);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (JSONException e) {
                if (k) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final synchronized vd2 i(xf3 xf3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, xf3Var)) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "finish: " + k() + " finished=" + this.g + " error=" + xf3Var);
                }
                if (this.g) {
                    return this;
                }
                this.g = true;
                this.e = xf3Var;
                if (xf3Var == null) {
                    td2.d.v(k(), System.currentTimeMillis());
                }
                td2.d.f(k());
                t();
                e();
                return this;
            }
        }
        return (vd2) invokeL.objValue;
    }

    public synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "install: " + k() + " finished=" + this.g + " installing=" + this.f);
                }
                if (!this.g && !this.f) {
                    this.f = true;
                    if (k) {
                        Log.i("SoUpdating", "install: " + k());
                    }
                    td2.d.x(k(), new a(this));
                }
            }
        }
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.h.size());
                }
                this.g = true;
                for (xi3<vd2> xi3Var : this.h) {
                    if (xi3Var != null) {
                        xi3Var.a(this);
                    }
                }
            }
        }
    }

    public synchronized void x(ud2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.g && bVar != null && 0 != bVar.b) {
                    this.j = bVar;
                    for (xi3<vd2> xi3Var : this.i) {
                        if (xi3Var != null) {
                            xi3Var.a(this);
                        }
                    }
                }
            }
        }
    }
}
