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
import com.bytedance.pangle.plugin.Plugin;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l63 extends gz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Plugin.TAG : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements pc2<o63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l63 a;

        public a(l63 l63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pc2
        /* renamed from: b */
        public void a(o63 o63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o63Var) != null) {
                return;
            }
            this.a.C(o63Var);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements pc2<o63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l63 a;

        public b(l63 l63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pc2
        /* renamed from: b */
        public void a(o63 o63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o63Var) != null) {
                return;
            }
            this.a.C(o63Var);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements pc2<o63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l63 a;

        public c(l63 l63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pc2
        /* renamed from: b */
        public void a(o63 o63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o63Var) != null) {
                return;
            }
            this.a.C(o63Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l63(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public d32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#invokePluginPayment", false);
            n63 B = B(str);
            if (B.b()) {
                v63.b(B.toString());
                return B.i;
            }
            return new t63().l(B, new c(this));
        }
        return (d32) invokeL.objValue;
    }

    public d32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#invokePluginChooseAddress", false);
            n63 B = B(str);
            if (B.b()) {
                v63.b(B.toString());
                return B.i;
            }
            return new s63().l(B, new b(this));
        }
        return (d32) invokeL.objValue;
    }

    public d32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            n63 B = B(str);
            if (B.b()) {
                v63.b(B.toString());
                return B.i;
            }
            return new u63().l(B, new a(this));
        }
        return (d32) invokeL.objValue;
    }

    public final n63 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            n63 n63Var = new n63();
            Pair<d32, JSONObject> s = s(str);
            n63Var.i = (d32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return n63Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                n63Var.i = new d32(201, "pluginProvider is empty");
                return n63Var;
            }
            ek4 g = b73.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        n63Var.i = new d32(201, "providerRootPath is empty");
                        return n63Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        n63Var.i = new d32(201, "slaveId is empty");
                        return n63Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        n63Var.i = new d32(201, "componentId is empty");
                        return n63Var;
                    }
                    String str3 = "release";
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    if (!TextUtils.isEmpty(optString5)) {
                        str3 = optString5;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
                    String optString6 = jSONObject.optString("cb");
                    n63Var.a = str2;
                    n63Var.b = optString;
                    n63Var.c = optString2;
                    n63Var.d = str3;
                    n63Var.e = optString3;
                    n63Var.f = optString4;
                    n63Var.g = optJSONObject;
                    n63Var.h = optString6;
                    return n63Var;
                }
            }
            n63Var.i = new d32(201, "pluginProvider exchange for truth app key，but empty");
            return n63Var;
        }
        return (n63) invokeL.objValue;
    }

    public final void C(o63 o63Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, o63Var) == null) && o63Var != null) {
            o63Var.b();
        }
    }
}
