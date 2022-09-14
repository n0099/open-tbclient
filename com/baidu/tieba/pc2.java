package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.oc2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class pc2 implements ie4<JSONArray> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;
    public final qc2 a;
    public final String b;
    public ac4 c;
    public ac4 d;
    public re3 e;
    public boolean f;
    public boolean g;
    public final Collection<rh3<pc2>> h;
    public final Collection<rh3<pc2>> i;
    public oc2.b j;

    /* loaded from: classes5.dex */
    public class a implements Function1<re3, Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pc2 a;

        public a(pc2 pc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pc2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Unit invoke(re3 re3Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, re3Var)) == null) {
                if (pc2.k) {
                    Log.i("SoUpdating", "install: " + this.a.k() + " onCallback");
                }
                this.a.i(re3Var);
                this.a.f = false;
                return null;
            }
            return (Unit) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948057162, "Lcom/baidu/tieba/pc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948057162, "Lcom/baidu/tieba/pc2;");
                return;
            }
        }
        k = ij1.a;
    }

    public pc2(@NonNull qc2 qc2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qc2Var, str};
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
        this.a = qc2Var;
        this.b = str;
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ie4
    /* renamed from: f */
    public void a(@NonNull JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray) == null) {
            ac4 l = l();
            if (k) {
                Log.i("SoUpdating", "decorateParams libName=" + this.b + " localSo=" + l);
            }
            try {
                Iterator<AbiType> it = AbiType.currentAbi().getCompatible().iterator();
                while (it.hasNext()) {
                    AbiType next = it.next();
                    if (k) {
                        Log.i("SoUpdating", "decorateParams loop abi=" + next);
                    }
                    if (next != null) {
                        wf4 d = wf4.d(this.b, next);
                        if (k) {
                            Log.i("SoUpdating", "decorateParams loop bundleId=" + d);
                        }
                        if (d != null) {
                            JSONObject jSONObject = new JSONObject();
                            boolean z = l != null && next == l.q;
                            long j = (l == null || !z) ? 0L : l.i;
                            String str = "0";
                            String str2 = (l == null || !z) ? "0" : l.j;
                            if (!TextUtils.isEmpty(str2)) {
                                str = str2;
                            }
                            jSONObject.put("type", "so");
                            jSONObject.put("bundle_id", d.b);
                            jSONObject.put("version_code", j);
                            jSONObject.put("version_name", str);
                            if (k) {
                                Log.i("SoUpdating", "decorate abi=" + next + " jo=" + jSONObject);
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

    public synchronized pc2 g(rh3<pc2> rh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rh3Var)) == null) {
            synchronized (this) {
                this.h.remove(rh3Var);
            }
            return this;
        }
        return (pc2) invokeL.objValue;
    }

    public synchronized pc2 h(rh3<pc2> rh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rh3Var)) == null) {
            synchronized (this) {
                this.i.remove(rh3Var);
            }
            return this;
        }
        return (pc2) invokeL.objValue;
    }

    public final synchronized pc2 i(re3 re3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, re3Var)) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "finish: " + k() + " finished=" + this.g + " error=" + re3Var);
                }
                if (this.g) {
                    return this;
                }
                this.g = true;
                this.e = re3Var;
                if (re3Var == null) {
                    nc2.d.v(k(), System.currentTimeMillis());
                }
                nc2.d.f(k());
                t();
                e();
                return this;
            }
        }
        return (pc2) invokeL.objValue;
    }

    public ac4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.d : (ac4) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public ac4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.c == null && !TextUtils.isEmpty(this.b)) {
                this.c = va4.i().t(this.b);
            }
            return this.c;
        }
        return (ac4) invokeV.objValue;
    }

    public oc2.b m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (oc2.b) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? n() && (this.e == null || nc2.d.k(k())) : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ac4 ac4Var = this.d;
            return (ac4Var == null || ac4Var == this.c) ? false : true;
        }
        return invokeV.booleanValue;
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
                    nc2.d.x(k(), new a(this));
                }
            }
        }
    }

    public boolean r(qc2 qc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, qc2Var)) == null) ? qc2Var != null && qc2Var == this.a : invokeL.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? !n() && this.f : invokeV.booleanValue;
    }

    public final synchronized void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                if (k) {
                    Log.i("SoUpdating", "notifyFinish: " + k() + " mCallbacks=" + this.h.size());
                }
                this.g = true;
                for (rh3<pc2> rh3Var : this.h) {
                    if (rh3Var != null) {
                        rh3Var.a(this);
                    }
                }
            }
        }
    }

    public synchronized pc2 u(rh3<pc2> rh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, rh3Var)) == null) {
            synchronized (this) {
                this.h.add(rh3Var);
            }
            return this;
        }
        return (pc2) invokeL.objValue;
    }

    public synchronized pc2 v(rh3<pc2> rh3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, rh3Var)) == null) {
            synchronized (this) {
                this.i.add(rh3Var);
            }
            return this;
        }
        return (pc2) invokeL.objValue;
    }

    public pc2 w(qc2 qc2Var, ac4 ac4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, qc2Var, ac4Var)) == null) {
            if (r(qc2Var)) {
                this.d = ac4Var;
            }
            return this;
        }
        return (pc2) invokeLL.objValue;
    }

    public synchronized void x(oc2.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            synchronized (this) {
                if (!this.g && bVar != null && 0 != bVar.b) {
                    this.j = bVar;
                    for (rh3<pc2> rh3Var : this.i) {
                        if (rh3Var != null) {
                            rh3Var.a(this);
                        }
                    }
                }
            }
        }
    }
}
