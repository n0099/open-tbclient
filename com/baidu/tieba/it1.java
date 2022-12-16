package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.eo2;
import com.baidu.tieba.j93;
import com.baidu.tieba.jt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class it1 extends hs1 implements jt1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class b implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ it1 b;

        /* loaded from: classes4.dex */
        public class a implements eo2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.eo2.a
            public void a(d73 d73Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d73Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", d73Var.a().toString());
                    rp2.U().u(new fe2("locationChange", hashMap));
                }
            }

            @Override // com.baidu.tieba.eo2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    kb3.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(it1 it1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = it1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (!c93.h(h93Var)) {
                    int b = h93Var.b();
                    kb3.b("startLocationUpdate", 5000, c93.f(b), b, c93.f(b));
                    this.b.d(this.a, new ew1(b, c93.f(b)));
                } else if (!yh3.M()) {
                    kb3.b("startLocationUpdate", 5004, "user no permission", 10005, c93.f(10005));
                    this.b.d(this.a, new ew1(10005, c93.f(10005)));
                } else {
                    this.b.d(this.a, new ew1(0));
                    ln2.I().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ it1 b;

        public a(it1 it1Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = it1Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                this.b.z(h93Var, this.a, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public String c;

        public c() {
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

        public static c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                c cVar = new c();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("type");
                    cVar.a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.a = "wgs84";
                    }
                    cVar.b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e) {
                    e12.d("GetLocationApi", "# parseFromJSON error", e);
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if ((TextUtils.equals(this.a, "wgs84") || TextUtils.equals(this.a, "gcj02") || TextUtils.equals(this.a, "bd09ll")) && !TextUtils.isEmpty(this.c)) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public it1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ew1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startLocationUpdate", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                kb3.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new ew1(1001, "SwanApp is null");
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                kb3.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                e12.c("GetLocationApi", "empty cb");
                return new ew1(201, "empty cb");
            }
            b0.e0().g(getContext(), "mapp_location", new b(this, optString));
            return ew1.f();
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                kb3.b("getLocation", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new ew1(1001, "SwanApp is null");
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            c b2 = c.b(((JSONObject) s.second).toString());
            if (b2 != null && b2.a()) {
                if (TextUtils.isEmpty(b2.c)) {
                    kb3.b("getLocation", 1001, "empty cb", 201, "empty cb");
                    e12.c("GetLocationApi", "empty cb");
                    return new ew1(201, "empty cb");
                }
                b0.e0().g(getContext(), "mapp_location", new a(this, b2));
                return ew1.f();
            }
            kb3.b("getLocation", 1001, "params is invalid", 201, "params is invalid");
            p("params is invalid", null, true);
            return new ew1(201, "params is invalid");
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ln2.I().e();
            return ew1.f();
        }
        return (ew1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jt1.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            e12.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new ew1(1001, String.valueOf(i)));
        }
    }

    @Override // com.baidu.tieba.jt1.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.c, new ew1(10005, "system deny"));
        }
    }

    @Override // com.baidu.tieba.jt1.c
    public void g(c cVar, d73 d73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, d73Var) == null) {
            d(cVar.c, new ew1(0, "success", d73Var.a()));
        }
    }

    public final void z(h93<j93.e> h93Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, h93Var, cVar, z) == null) {
            e12.i("GetLocationApi", "authorized result is " + h93Var);
            if (c93.h(h93Var)) {
                jt1.d().e(cVar, this, z);
                return;
            }
            int b2 = h93Var.b();
            kb3.b("getLocation", 5000, c93.f(b2), b2, c93.f(b2));
            d(cVar.c, new ew1(b2, c93.f(b2)));
        }
    }
}
