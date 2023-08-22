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
/* loaded from: classes9.dex */
public class z63 extends y63 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final qb3<z63> h;
    public static final rb3<z63> i;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;

    /* loaded from: classes9.dex */
    public static class a extends qb3<z63> {
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
        @Override // com.baidu.tieba.qb3
        /* renamed from: b */
        public z63 a(@NonNull iu2 iu2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iu2Var)) == null) {
                z63 z63Var = new z63();
                z63Var.g = iu2Var.g();
                z63Var.b = iu2Var.g();
                z63Var.c = iu2Var.readLong();
                z63Var.a = iu2Var.g();
                z63Var.d = iu2Var.readInt();
                z63Var.e = iu2Var.g();
                z63Var.f = iu2Var.g();
                return z63Var;
            }
            return (z63) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b extends rb3<z63> {
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
        @Override // com.baidu.tieba.rb3
        /* renamed from: b */
        public void a(@NonNull z63 z63Var, @NonNull ju2 ju2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z63Var, ju2Var) == null) {
                ju2Var.f(z63Var.g);
                ju2Var.f(z63Var.b);
                ju2Var.writeLong(z63Var.c);
                ju2Var.f(z63Var.a);
                ju2Var.writeInt(z63Var.d);
                ju2Var.f(z63Var.e);
                ju2Var.f(z63Var.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948311858, "Lcom/baidu/tieba/z63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948311858, "Lcom/baidu/tieba/z63;");
                return;
            }
        }
        h = new a();
        i = new b();
    }

    public z63() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.a) && (this.c >= 0 || !TextUtils.isEmpty(this.b))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public z63(JSONObject jSONObject, int i2) {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "SwanPluginModel{pluginAlias='" + this.g + "', versionName='" + this.b + "', versionCode='" + this.c + "', libName='" + this.a + "', category=" + this.d + ", libPath='" + this.e + "', libConfig='" + this.f + "'}";
        }
        return (String) invokeV.objValue;
    }
}
