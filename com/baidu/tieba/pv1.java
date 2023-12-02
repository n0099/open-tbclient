package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.tieba.kq2;
import com.baidu.tieba.pb3;
import com.baidu.tieba.qv1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class pv1 extends ou1 implements qv1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pv1 b;

        /* loaded from: classes7.dex */
        public class a implements kq2.a {
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

            @Override // com.baidu.tieba.kq2.a
            public void a(j93 j93Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, j93Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", j93Var.a().toString());
                    xr2.V().v(new lg2("locationChange", hashMap));
                }
            }

            @Override // com.baidu.tieba.kq2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    qd3.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(pv1 pv1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pv1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                if (!ib3.h(nb3Var)) {
                    int b = nb3Var.b();
                    qd3.b("startLocationUpdate", 5000, ib3.f(b), b, ib3.f(b));
                    this.b.d(this.a, new ly1(b, ib3.f(b)));
                } else if (!ek3.M()) {
                    qd3.b("startLocationUpdate", 5004, "user no permission", 10005, ib3.f(10005));
                    this.b.d(this.a, new ly1(10005, ib3.f(10005)));
                } else {
                    this.b.d(this.a, new ly1(0));
                    rp2.I().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements dl3<nb3<pb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ pv1 b;

        public a(pv1 pv1Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pv1Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(nb3<pb3.e> nb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nb3Var) == null) {
                this.b.A(nb3Var, this.a, false);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    k32.d("GetLocationApi", "# parseFromJSON error", e);
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
    public pv1(@NonNull mu1 mu1Var) {
        super(mu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mu1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((mu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(nb3<pb3.e> nb3Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, nb3Var, cVar, z) == null) {
            k32.i("GetLocationApi", "authorized result is " + nb3Var);
            if (ib3.h(nb3Var)) {
                qv1.d().e(cVar, this, z);
                return;
            }
            int b2 = nb3Var.b();
            qd3.b(GameAssistConstKt.METHOD_GET_LOCATION, 5000, ib3.f(b2), b2, ib3.f(b2));
            d(cVar.c, new ly1(b2, ib3.f(b2)));
        }
    }

    public ly1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#startLocationUpdate", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                qd3.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new ly1(1001, "SwanApp is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                qd3.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                k32.c("GetLocationApi", "empty cb");
                return new ly1(201, "empty cb");
            }
            c0.f0().g(i(), "mapp_location", new b(this, optString));
            return ly1.f();
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            r("#getLocation", false);
            k63 c0 = k63.c0();
            if (c0 == null) {
                qd3.b(GameAssistConstKt.METHOD_GET_LOCATION, 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new ly1(1001, "SwanApp is null");
            }
            Pair<ly1, JSONObject> t = t(str);
            ly1 ly1Var = (ly1) t.first;
            if (!ly1Var.isSuccess()) {
                return ly1Var;
            }
            c b2 = c.b(((JSONObject) t.second).toString());
            if (b2 != null && b2.a()) {
                if (TextUtils.isEmpty(b2.c)) {
                    qd3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1001, "empty cb", 201, "empty cb");
                    k32.c("GetLocationApi", "empty cb");
                    return new ly1(201, "empty cb");
                }
                c0.f0().g(i(), "mapp_location", new a(this, b2));
                return ly1.f();
            }
            qd3.b(GameAssistConstKt.METHOD_GET_LOCATION, 1001, "params is invalid", 201, "params is invalid");
            q("params is invalid", null, true);
            return new ly1(201, "params is invalid");
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            rp2.I().e();
            return ly1.f();
        }
        return (ly1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qv1.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, cVar, i) == null) {
            k32.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new ly1(1001, String.valueOf(i)));
        }
    }

    @Override // com.baidu.tieba.qv1.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, str) == null) {
            d(cVar.c, new ly1(10005, "system deny"));
        }
    }

    @Override // com.baidu.tieba.qv1.c
    public void g(c cVar, j93 j93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, cVar, j93Var) == null) {
            d(cVar.c, new ly1(0, "success", j93Var.a()));
        }
    }
}
