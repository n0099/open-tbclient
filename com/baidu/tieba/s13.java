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
public class s13 extends ou1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ou1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "Plugin" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ou1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements w72<v13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s13 a;

        public a(s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s13Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(v13 v13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v13Var) != null) {
                return;
            }
            this.a.D(v13Var);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements w72<v13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s13 a;

        public b(s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s13Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(v13 v13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v13Var) != null) {
                return;
            }
            this.a.D(v13Var);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements w72<v13> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s13 a;

        public c(s13 s13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s13Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s13Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.w72
        /* renamed from: b */
        public void a(v13 v13Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v13Var) != null) {
                return;
            }
            this.a.D(v13Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s13(@NonNull mu1 mu1Var) {
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

    public ly1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            u13 C = C(str);
            if (C.b()) {
                c23.b(C.toString());
                return C.i;
            }
            return new b23().l(C, new a(this));
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#invokePluginPayment", false);
            u13 C = C(str);
            if (C.b()) {
                c23.b(C.toString());
                return C.i;
            }
            return new a23().l(C, new c(this));
        }
        return (ly1) invokeL.objValue;
    }

    public ly1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#invokePluginChooseAddress", false);
            u13 C = C(str);
            if (C.b()) {
                c23.b(C.toString());
                return C.i;
            }
            return new z13().l(C, new b(this));
        }
        return (ly1) invokeL.objValue;
    }

    public final u13 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            u13 u13Var = new u13();
            Pair<ly1, JSONObject> t = t(str);
            u13Var.i = (ly1) t.first;
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                return u13Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                u13Var.i = new ly1(201, "pluginProvider is empty");
                return u13Var;
            }
            lf4 g = i23.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        u13Var.i = new ly1(201, "providerRootPath is empty");
                        return u13Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        u13Var.i = new ly1(201, "slaveId is empty");
                        return u13Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        u13Var.i = new ly1(201, "componentId is empty");
                        return u13Var;
                    }
                    String str3 = "release";
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    if (!TextUtils.isEmpty(optString5)) {
                        str3 = optString5;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
                    String optString6 = jSONObject.optString("cb");
                    u13Var.a = str2;
                    u13Var.b = optString;
                    u13Var.c = optString2;
                    u13Var.d = str3;
                    u13Var.e = optString3;
                    u13Var.f = optString4;
                    u13Var.g = optJSONObject;
                    u13Var.h = optString6;
                    return u13Var;
                }
            }
            u13Var.i = new ly1(201, "pluginProvider exchange for truth app key，but empty");
            return u13Var;
        }
        return (u13) invokeL.objValue;
    }

    public final void D(v13 v13Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, v13Var) == null) && v13Var != null) {
            v13Var.b();
        }
    }
}
