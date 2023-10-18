package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class x03 extends tt1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.tt1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Plugin" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tt1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements b72<a13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x03 a;

        public a(x03 x03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(a13 a13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a13Var) != null) {
                return;
            }
            this.a.D(a13Var);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b72<a13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x03 a;

        public b(x03 x03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(a13 a13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a13Var) != null) {
                return;
            }
            this.a.D(a13Var);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b72<a13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x03 a;

        public c(x03 x03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = x03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(a13 a13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a13Var) != null) {
                return;
            }
            this.a.D(a13Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x03(@NonNull rt1 rt1Var) {
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

    public qx1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            z03 C = C(str);
            if (C.b()) {
                h13.b(C.toString());
                return C.i;
            }
            return new g13().l(C, new a(this));
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#invokePluginPayment", false);
            z03 C = C(str);
            if (C.b()) {
                h13.b(C.toString());
                return C.i;
            }
            return new f13().l(C, new c(this));
        }
        return (qx1) invokeL.objValue;
    }

    public qx1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#invokePluginChooseAddress", false);
            z03 C = C(str);
            if (C.b()) {
                h13.b(C.toString());
                return C.i;
            }
            return new e13().l(C, new b(this));
        }
        return (qx1) invokeL.objValue;
    }

    public final z03 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            z03 z03Var = new z03();
            Pair<qx1, JSONObject> t = t(str);
            z03Var.i = (qx1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                return z03Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                z03Var.i = new qx1(201, "pluginProvider is empty");
                return z03Var;
            }
            qe4 g = n13.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        z03Var.i = new qx1(201, "providerRootPath is empty");
                        return z03Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        z03Var.i = new qx1(201, "slaveId is empty");
                        return z03Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        z03Var.i = new qx1(201, "componentId is empty");
                        return z03Var;
                    }
                    String str3 = "release";
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    if (!TextUtils.isEmpty(optString5)) {
                        str3 = optString5;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
                    String optString6 = jSONObject.optString("cb");
                    z03Var.a = str2;
                    z03Var.b = optString;
                    z03Var.c = optString2;
                    z03Var.d = str3;
                    z03Var.e = optString3;
                    z03Var.f = optString4;
                    z03Var.g = optJSONObject;
                    z03Var.h = optString6;
                    return z03Var;
                }
            }
            z03Var.i = new qx1(201, "pluginProvider exchange for truth app key，but empty");
            return z03Var;
        }
        return (z03) invokeL.objValue;
    }

    public final void D(a13 a13Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, a13Var) == null) && a13Var != null) {
            a13Var.b();
        }
    }
}
