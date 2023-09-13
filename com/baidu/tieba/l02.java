package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.hv2;
import com.baidu.tieba.m02;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l02 extends kz1 implements m02.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class b implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ l02 b;

        /* loaded from: classes6.dex */
        public class a implements hv2.a {
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

            @Override // com.baidu.tieba.hv2.a
            public void a(ge3 ge3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, ge3Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", ge3Var.a().toString());
                    uw2.T().u(new il2("locationChange", hashMap));
                }
            }

            @Override // com.baidu.tieba.hv2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    ni3.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(l02 l02Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l02Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l02Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    int b = kg3Var.b();
                    ni3.b("startLocationUpdate", 5000, fg3.f(b), b, fg3.f(b));
                    this.b.d(this.a, new h32(b, fg3.f(b)));
                } else if (!bp3.M()) {
                    ni3.b("startLocationUpdate", 5004, "user no permission", 10005, fg3.f(10005));
                    this.b.d(this.a, new h32(10005, fg3.f(10005)));
                } else {
                    this.b.d(this.a, new h32(0));
                    ou2.I().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ l02 b;

        public a(l02 l02Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l02Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l02Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                this.b.z(kg3Var, this.a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    h82.d("GetLocationApi", "# parseFromJSON error", e);
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
    public l02(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startLocationUpdate", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                ni3.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new h32(1001, "SwanApp is null");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ni3.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                h82.c("GetLocationApi", "empty cb");
                return new h32(201, "empty cb");
            }
            b0.e0().g(getContext(), "mapp_location", new b(this, optString));
            return h32.f();
        }
        return (h32) invokeL.objValue;
    }

    public h32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                ni3.b(GameAssistConstKt.METHOD_GET_LOCATION, 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new h32(1001, "SwanApp is null");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            c b2 = c.b(((JSONObject) s.second).toString());
            if (b2 != null && b2.a()) {
                if (TextUtils.isEmpty(b2.c)) {
                    ni3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1001, "empty cb", 201, "empty cb");
                    h82.c("GetLocationApi", "empty cb");
                    return new h32(201, "empty cb");
                }
                b0.e0().g(getContext(), "mapp_location", new a(this, b2));
                return h32.f();
            }
            ni3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1001, "params is invalid", 201, "params is invalid");
            p("params is invalid", null, true);
            return new h32(201, "params is invalid");
        }
        return (h32) invokeL.objValue;
    }

    public h32 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ou2.I().e();
            return h32.f();
        }
        return (h32) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m02.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            h82.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new h32(1001, String.valueOf(i)));
        }
    }

    @Override // com.baidu.tieba.m02.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.c, new h32(10005, "system deny"));
        }
    }

    @Override // com.baidu.tieba.m02.c
    public void g(c cVar, ge3 ge3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, ge3Var) == null) {
            d(cVar.c, new h32(0, "success", ge3Var.a()));
        }
    }

    public final void z(kg3<mg3.e> kg3Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, kg3Var, cVar, z) == null) {
            h82.i("GetLocationApi", "authorized result is " + kg3Var);
            if (fg3.h(kg3Var)) {
                m02.d().e(cVar, this, z);
                return;
            }
            int b2 = kg3Var.b();
            ni3.b(GameAssistConstKt.METHOD_GET_LOCATION, 5000, fg3.f(b2), b2, fg3.f(b2));
            d(cVar.c, new h32(b2, fg3.f(b2)));
        }
    }
}
