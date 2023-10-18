package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.tieba.st1;
import com.baidu.tieba.ua3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class tw1 extends pw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "CommonSysInfoApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends st1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw1 d;

        /* renamed from: com.baidu.tieba.tw1$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0479a implements ik3<sa3<ua3.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ st1.b a;
            public final /* synthetic */ a b;

            public C0479a(a aVar, st1.b bVar) {
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
            @Override // com.baidu.tieba.ik3
            /* renamed from: b */
            public void a(sa3<ua3.e> sa3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sa3Var) == null) {
                    if (!na3.h(sa3Var)) {
                        int b = sa3Var.b();
                        this.a.a(new qx1(b, na3.f(b)));
                        return;
                    }
                    this.a.a(this.b.d.B());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tw1 tw1Var, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw1Var, str};
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
            this.d = tw1Var;
        }

        @Override // com.baidu.tieba.st1
        @NonNull
        public qx1 d(@NonNull JSONObject jSONObject, @NonNull st1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                p53 c0 = p53.c0();
                if (c0 == null) {
                    return new qx1(1001, "null swan runtime");
                }
                c0.f0().g(o53.K(), "mapp_i_get_common_sys_info", new C0479a(this, bVar));
                return new qx1(0);
            }
            return (qx1) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.st1
        @NonNull
        public qx1 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return this.d.B();
            }
            return (qx1) invokeL.objValue;
        }

        @Override // com.baidu.tieba.st1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (o53.K().E() && o53.K().q().f0().f("mapp_i_get_common_sys_info")) {
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
                bundle2.putString("zid", wo2.G0().a(AppRuntime.getAppContext()));
                bundle2.putString("uid", wo2.h0().h(AppRuntime.getAppContext()));
                ra3 a = wo2.q().a();
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
    public tw1(@NonNull rt1 rt1Var) {
        super(rt1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rt1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((rt1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @SuppressLint({"SwanBindApiNote"})
    public qx1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            r("#getCommonSysInfo", false);
            return n(str, new a(this, "getCommonSysInfo"));
        }
        return (qx1) invokeL.objValue;
    }

    public final JSONObject A() {
        InterceptResult invokeV;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String i = wo2.h0().i(o53.K());
            String r = jj3.r();
            Bundle bundle = new Bundle();
            bundle.putString("httpUrl", ".baidu.com");
            e23 c = c23.c(b.class, bundle);
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
            String l = hj3.l(str3, "BAIDUID");
            String l2 = hj3.l(str3, "H_WISE_SIDS");
            String a2 = am4.b(AppRuntime.getAppContext()).a();
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

    @NonNull
    public final qx1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject A = A();
            if (A == null) {
                return new qx1(1001, "result JSONException");
            }
            return new qx1(0, A);
        }
        return (qx1) invokeV.objValue;
    }
}
