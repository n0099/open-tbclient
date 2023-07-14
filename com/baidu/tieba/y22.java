package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tieba.ah3;
import com.baidu.tieba.xz1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y22 extends u22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "CommonSysInfoApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends xz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y22 d;

        /* renamed from: com.baidu.tieba.y22$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0540a implements oq3<yg3<ah3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ xz1.b a;
            public final /* synthetic */ a b;

            public C0540a(a aVar, xz1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(yg3<ah3.e> yg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                    if (!tg3.h(yg3Var)) {
                        int b = yg3Var.b();
                        this.a.a(new v32(b, tg3.f(b)));
                        return;
                    }
                    this.a.a(this.b.d.A());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(y22 y22Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y22Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = y22Var;
        }

        @Override // com.baidu.tieba.xz1
        @NonNull
        public v32 d(@NonNull JSONObject jSONObject, @NonNull xz1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                vb3 b0 = vb3.b0();
                if (b0 == null) {
                    return new v32(1001, "null swan runtime");
                }
                b0.e0().g(ub3.K(), "mapp_i_get_common_sys_info", new C0540a(this, bVar));
                return new v32(0);
            }
            return (v32) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.xz1
        @NonNull
        public v32 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return this.d.A();
            }
            return (v32) invokeL.objValue;
        }

        @Override // com.baidu.tieba.xz1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (ub3.K().E() && ub3.K().q().e0().f("mapp_i_get_common_sys_info")) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            String cookie;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("httpUrl");
                Bundle bundle2 = new Bundle();
                bundle2.putString("zid", cv2.G0().a(AppRuntime.getAppContext()));
                bundle2.putString("uid", cv2.h0().h(AppRuntime.getAppContext()));
                xg3 a = cv2.q().a();
                if (TextUtils.isEmpty(string)) {
                    cookie = "";
                } else {
                    cookie = a.getCookie(string);
                }
                bundle2.putString("cookie", cookie);
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y22(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SwanBindApiNote"})
    public v32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getCommonSysInfo", false);
            return m(str, new a(this, "getCommonSysInfo"));
        }
        return (v32) invokeL.objValue;
    }

    @NonNull
    public final v32 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject z = z();
            if (z == null) {
                return new v32(1001, "result JSONException");
            }
            return new v32(0, z);
        }
        return (v32) invokeV.objValue;
    }

    public final JSONObject z() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i = cv2.h0().i(ub3.K());
            String r = pp3.r();
            Bundle bundle = new Bundle();
            bundle.putString("httpUrl", ".baidu.com");
            k83 c = i83.c(b.class, bundle);
            String str3 = "";
            if (!c.a()) {
                str = "";
                str2 = str;
            } else {
                String string = c.a.getString("zid");
                str2 = c.a.getString("uid");
                str3 = c.a.getString("cookie");
                str = string;
            }
            String l = np3.l(str3, "BAIDUID");
            String l2 = np3.l(str3, "H_WISE_SIDS");
            String a2 = hs4.b(AppRuntime.getAppContext()).a();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cuid", i);
                jSONObject.put("imei", r);
                jSONObject.put("zid", str);
                jSONObject.put("uid", str2);
                jSONObject.put("baidu_id", l);
                jSONObject.put("sid", l2);
                jSONObject.put("uuid", a2);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}
