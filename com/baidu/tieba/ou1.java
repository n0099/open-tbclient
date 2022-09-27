package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tieba.nr1;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ou1 extends ku1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a extends nr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ou1 d;

        /* renamed from: com.baidu.tieba.ou1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0359a implements ei3<o83<q83.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nr1.b a;
            public final /* synthetic */ a b;

            public C0359a(a aVar, nr1.b bVar) {
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
            @Override // com.baidu.tieba.ei3
            /* renamed from: b */
            public void a(o83<q83.e> o83Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                    if (j83.h(o83Var)) {
                        this.a.a(this.b.d.A());
                        return;
                    }
                    int b = o83Var.b();
                    this.a.a(new lv1(b, j83.f(b)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ou1 ou1Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ou1Var, str};
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
            this.d = ou1Var;
        }

        @Override // com.baidu.tieba.nr1
        @NonNull
        public lv1 d(@NonNull JSONObject jSONObject, @NonNull nr1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                l33 b0 = l33.b0();
                if (b0 == null) {
                    return new lv1(1001, "null swan runtime");
                }
                b0.e0().g(k33.K(), "mapp_i_get_common_sys_info", new C0359a(this, bVar));
                return new lv1(0);
            }
            return (lv1) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.nr1
        @NonNull
        public lv1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) ? this.d.A() : (lv1) invokeL.objValue;
        }

        @Override // com.baidu.tieba.nr1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? k33.K().E() && k33.K().q().e0().f("mapp_i_get_common_sys_info") : invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                String string = bundle.getString("httpUrl");
                Bundle bundle2 = new Bundle();
                bundle2.putString("zid", sm2.G0().a(AppRuntime.getAppContext()));
                bundle2.putString("uid", sm2.h0().h(AppRuntime.getAppContext()));
                bundle2.putString("cookie", TextUtils.isEmpty(string) ? "" : sm2.q().a().getCookie(string));
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ou1(@NonNull mr1 mr1Var) {
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

    @NonNull
    public final lv1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject z = z();
            if (z == null) {
                return new lv1(1001, "result JSONException");
            }
            return new lv1(0, z);
        }
        return (lv1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "CommonSysInfoApi" : (String) invokeV.objValue;
    }

    @SuppressLint({"SwanBindApiNote"})
    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getCommonSysInfo", false);
            return m(str, new a(this, "getCommonSysInfo"));
        }
        return (lv1) invokeL.objValue;
    }

    public final JSONObject z() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String i = sm2.h0().i(k33.K());
            String r = fh3.r();
            Bundle bundle = new Bundle();
            bundle.putString("httpUrl", ".baidu.com");
            a03 c = yz2.c(b.class, bundle);
            String str3 = "";
            if (c.a()) {
                String string = c.a.getString("zid");
                str2 = c.a.getString("uid");
                str3 = c.a.getString("cookie");
                str = string;
            } else {
                str = "";
                str2 = str;
            }
            String l = dh3.l(str3, "BAIDUID");
            String l2 = dh3.l(str3, "H_WISE_SIDS");
            String a2 = xj4.b(AppRuntime.getAppContext()).a();
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
