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
/* loaded from: classes7.dex */
public class p63 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Plugin.TAG : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements tc2<s63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p63 a;

        public a(p63 p63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(s63 s63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s63Var) != null) {
                return;
            }
            this.a.C(s63Var);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements tc2<s63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p63 a;

        public b(p63 p63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(s63 s63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s63Var) != null) {
                return;
            }
            this.a.C(s63Var);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements tc2<s63> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p63 a;

        public c(p63 p63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {p63Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = p63Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tc2
        /* renamed from: b */
        public void a(s63 s63Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s63Var) != null) {
                return;
            }
            this.a.C(s63Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p63(@NonNull iz1 iz1Var) {
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
            q("#invokePluginPayment", false);
            r63 B = B(str);
            if (B.b()) {
                z63.b(B.toString());
                return B.i;
            }
            return new x63().l(B, new c(this));
        }
        return (h32) invokeL.objValue;
    }

    public h32 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#invokePluginChooseAddress", false);
            r63 B = B(str);
            if (B.b()) {
                z63.b(B.toString());
                return B.i;
            }
            return new w63().l(B, new b(this));
        }
        return (h32) invokeL.objValue;
    }

    public h32 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r63 B = B(str);
            if (B.b()) {
                z63.b(B.toString());
                return B.i;
            }
            return new y63().l(B, new a(this));
        }
        return (h32) invokeL.objValue;
    }

    public final r63 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r63 r63Var = new r63();
            Pair<h32, JSONObject> s = s(str);
            r63Var.i = (h32) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return r63Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                r63Var.i = new h32(201, "pluginProvider is empty");
                return r63Var;
            }
            ik4 g = f73.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        r63Var.i = new h32(201, "providerRootPath is empty");
                        return r63Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        r63Var.i = new h32(201, "slaveId is empty");
                        return r63Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        r63Var.i = new h32(201, "componentId is empty");
                        return r63Var;
                    }
                    String str3 = "release";
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    if (!TextUtils.isEmpty(optString5)) {
                        str3 = optString5;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
                    String optString6 = jSONObject.optString("cb");
                    r63Var.a = str2;
                    r63Var.b = optString;
                    r63Var.c = optString2;
                    r63Var.d = str3;
                    r63Var.e = optString3;
                    r63Var.f = optString4;
                    r63Var.g = optJSONObject;
                    r63Var.h = optString6;
                    return r63Var;
                }
            }
            r63Var.i = new h32(201, "pluginProvider exchange for truth app key，but empty");
            return r63Var;
        }
        return (r63) invokeL.objValue;
    }

    public final void C(s63 s63Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s63Var) == null) && s63Var != null) {
            s63Var.b();
        }
    }
}
