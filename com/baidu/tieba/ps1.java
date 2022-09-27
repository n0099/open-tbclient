package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.tieba.ln2;
import com.baidu.tieba.q83;
import com.baidu.tieba.qs1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ps1 extends or1 implements qs1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ ps1 b;

        public a(ps1 ps1Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ps1Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                this.b.z(o83Var, this.a, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ps1 b;

        /* loaded from: classes5.dex */
        public class a implements ln2.a {
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

            @Override // com.baidu.tieba.ln2.a
            public void a(k63 k63Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, k63Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", k63Var.a().toString());
                    yo2.U().u(new md2("locationChange", hashMap));
                }
            }

            @Override // com.baidu.tieba.ln2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    ra3.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(ps1 ps1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ps1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ps1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                if (!j83.h(o83Var)) {
                    int b = o83Var.b();
                    ra3.b("startLocationUpdate", 5000, j83.f(b), b, j83.f(b));
                    this.b.d(this.a, new lv1(b, j83.f(b)));
                } else if (!fh3.M()) {
                    ra3.b("startLocationUpdate", 5004, "user no permission", 10005, j83.f(10005));
                    this.b.d(this.a, new lv1(10005, j83.f(10005)));
                } else {
                    this.b.d(this.a, new lv1(0));
                    sm2.I().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                        cVar.a = CoordinateType.WGS84;
                    }
                    cVar.b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e) {
                    l02.d("GetLocationApi", "# parseFromJSON error", e);
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.equals(this.a, CoordinateType.WGS84) || TextUtils.equals(this.a, "gcj02") || TextUtils.equals(this.a, "bd09ll")) && !TextUtils.isEmpty(this.c) : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ps1(@NonNull mr1 mr1Var) {
        super(mr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mr1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public lv1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startLocationUpdate", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                ra3.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new lv1(1001, "SwanApp is null");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ra3.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                    l02.c("GetLocationApi", "empty cb");
                    return new lv1(201, "empty cb");
                }
                b0.e0().g(getContext(), "mapp_location", new b(this, optString));
                return lv1.f();
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sm2.I().e();
            return lv1.f();
        }
        return (lv1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qs1.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            l02.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new lv1(1001, String.valueOf(i)));
        }
    }

    @Override // com.baidu.tieba.qs1.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.c, new lv1(10005, "system deny"));
        }
    }

    @Override // com.baidu.tieba.qs1.c
    public void g(c cVar, k63 k63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, k63Var) == null) {
            d(cVar.c, new lv1(0, "success", k63Var.a()));
        }
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            l33 b0 = l33.b0();
            if (b0 == null) {
                ra3.b("getLocation", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new lv1(1001, "SwanApp is null");
            }
            Pair<lv1, JSONObject> s = s(str);
            lv1 lv1Var = (lv1) s.first;
            if (lv1Var.isSuccess()) {
                c b2 = c.b(((JSONObject) s.second).toString());
                if (b2 != null && b2.a()) {
                    if (TextUtils.isEmpty(b2.c)) {
                        ra3.b("getLocation", 1001, "empty cb", 201, "empty cb");
                        l02.c("GetLocationApi", "empty cb");
                        return new lv1(201, "empty cb");
                    }
                    b0.e0().g(getContext(), "mapp_location", new a(this, b2));
                    return lv1.f();
                }
                ra3.b("getLocation", 1001, "params is invalid", 201, "params is invalid");
                p("params is invalid", null, true);
                return new lv1(201, "params is invalid");
            }
            return lv1Var;
        }
        return (lv1) invokeL.objValue;
    }

    public final void z(o83<q83.e> o83Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, o83Var, cVar, z) == null) {
            l02.i("GetLocationApi", "authorized result is " + o83Var);
            if (j83.h(o83Var)) {
                qs1.d().e(cVar, this, z);
                return;
            }
            int b2 = o83Var.b();
            ra3.b("getLocation", 5000, j83.f(b2), b2, j83.f(b2));
            d(cVar.c, new lv1(b2, j83.f(b2)));
        }
    }
}
