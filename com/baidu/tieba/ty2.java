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
import com.bytedance.pangle.plugin.Plugin;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ty2 extends or1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements x42<wy2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty2 a;

        public a(ty2 ty2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ty2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x42
        /* renamed from: b */
        public void a(wy2 wy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wy2Var) == null) {
                this.a.C(wy2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements x42<wy2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty2 a;

        public b(ty2 ty2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ty2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x42
        /* renamed from: b */
        public void a(wy2 wy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wy2Var) == null) {
                this.a.C(wy2Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements x42<wy2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ty2 a;

        public c(ty2 ty2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ty2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ty2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.x42
        /* renamed from: b */
        public void a(wy2 wy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wy2Var) == null) {
                this.a.C(wy2Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ty2(@NonNull mr1 mr1Var) {
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
            q("#invokePluginPayment", false);
            vy2 B = B(str);
            if (B.b()) {
                dz2.b(B.toString());
                return B.i;
            }
            return new bz2().l(B, new c(this));
        }
        return (lv1) invokeL.objValue;
    }

    public final vy2 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            vy2 vy2Var = new vy2();
            Pair<lv1, JSONObject> s = s(str);
            vy2Var.i = (lv1) s.first;
            JSONObject jSONObject = (JSONObject) s.second;
            if (jSONObject == null) {
                return vy2Var;
            }
            String optString = jSONObject.optString("pluginProvider");
            if (TextUtils.isEmpty(optString)) {
                vy2Var.i = new lv1(201, "pluginProvider is empty");
                return vy2Var;
            }
            mc4 g = jz2.g(optString);
            if (g != null) {
                String str2 = g.r;
                if (!TextUtils.isEmpty(str2)) {
                    String optString2 = jSONObject.optString("providerRootPath");
                    if (TextUtils.isEmpty(optString2)) {
                        vy2Var.i = new lv1(201, "providerRootPath is empty");
                        return vy2Var;
                    }
                    String optString3 = jSONObject.optString("slaveId");
                    if (TextUtils.isEmpty(optString3)) {
                        vy2Var.i = new lv1(201, "slaveId is empty");
                        return vy2Var;
                    }
                    String optString4 = jSONObject.optString("componentId");
                    if (TextUtils.isEmpty(optString4)) {
                        vy2Var.i = new lv1(201, "componentId is empty");
                        return vy2Var;
                    }
                    String optString5 = jSONObject.optString("pluginVersion", "release");
                    String str3 = TextUtils.isEmpty(optString5) ? "release" : optString5;
                    JSONObject optJSONObject = jSONObject.optJSONObject("args");
                    String optString6 = jSONObject.optString("cb");
                    vy2Var.a = str2;
                    vy2Var.b = optString;
                    vy2Var.c = optString2;
                    vy2Var.d = str3;
                    vy2Var.e = optString3;
                    vy2Var.f = optString4;
                    vy2Var.g = optJSONObject;
                    vy2Var.h = optString6;
                    return vy2Var;
                }
            }
            vy2Var.i = new lv1(201, "pluginProvider exchange for truth app key，but empty");
            return vy2Var;
        }
        return (vy2) invokeL.objValue;
    }

    public final void C(wy2 wy2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wy2Var) == null) || wy2Var == null) {
            return;
        }
        wy2Var.b();
    }

    @Override // com.baidu.tieba.or1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? Plugin.TAG : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.or1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanInvokeFunPageApi" : (String) invokeV.objValue;
    }

    public lv1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#invokePluginChooseAddress", false);
            vy2 B = B(str);
            if (B.b()) {
                dz2.b(B.toString());
                return B.i;
            }
            return new az2().l(B, new b(this));
        }
        return (lv1) invokeL.objValue;
    }

    public lv1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            vy2 B = B(str);
            if (B.b()) {
                dz2.b(B.toString());
                return B.i;
            }
            return new cz2().l(B, new a(this));
        }
        return (lv1) invokeL.objValue;
    }
}
