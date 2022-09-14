package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class uy2 extends ty2 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final l33<uy2> h;
    public static final m33<uy2> i;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    /* loaded from: classes6.dex */
    public static class a extends l33<uy2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.l33
        /* renamed from: b */
        public uy2 a(@NonNull dm2 dm2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm2Var)) == null) {
                uy2 uy2Var = new uy2();
                uy2Var.g = dm2Var.g();
                uy2Var.b = dm2Var.g();
                uy2Var.c = dm2Var.readLong();
                uy2Var.a = dm2Var.g();
                uy2Var.d = dm2Var.readInt();
                uy2Var.e = dm2Var.g();
                uy2Var.f = dm2Var.g();
                return uy2Var;
            }
            return (uy2) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends m33<uy2> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.m33
        /* renamed from: b */
        public void a(@NonNull uy2 uy2Var, @NonNull em2 em2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uy2Var, em2Var) == null) {
                em2Var.f(uy2Var.g);
                em2Var.f(uy2Var.b);
                em2Var.writeLong(uy2Var.c);
                em2Var.f(uy2Var.a);
                em2Var.writeInt(uy2Var.d);
                em2Var.f(uy2Var.e);
                em2Var.f(uy2Var.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948227259, "Lcom/baidu/tieba/uy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948227259, "Lcom/baidu/tieba/uy2;");
                return;
            }
        }
        h = new a();
        i = new b();
    }

    public uy2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.a) && (this.c >= 0 || !TextUtils.isEmpty(this.b)) : invokeV.booleanValue;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? super.clone() : invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanPluginModel{pluginAlias='" + this.g + "', versionName='" + this.b + "', versionCode='" + this.c + "', libName='" + this.a + "', category=" + this.d + ", libPath='" + this.e + "', libConfig='" + this.f + "'}";
        }
        return (String) invokeV.objValue;
    }

    public uy2(JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString("version");
        this.c = jSONObject.optLong("version_code", -1L);
        this.a = jSONObject.optString("provider");
        this.e = jSONObject.optString("path");
        this.f = jSONObject.optString("config");
        this.d = i2;
    }
}
