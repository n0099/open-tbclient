package com.baidu.tieba;

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
/* loaded from: classes7.dex */
public class s63 extends t63 implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final lb3<s63> k;
    public static final mb3<s63> l;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean g;
    public long h;
    public long i;
    public int j;

    /* loaded from: classes7.dex */
    public static class a extends lb3<s63> {
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
        @Override // com.baidu.tieba.lb3
        /* renamed from: b */
        public s63 a(@NonNull du2 du2Var) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du2Var)) == null) {
                s63 s63Var = new s63();
                s63Var.a = du2Var.g();
                s63Var.b = du2Var.g();
                s63Var.c = du2Var.readLong();
                s63Var.d = du2Var.readInt();
                s63Var.e = du2Var.g();
                s63Var.f = du2Var.g();
                s63Var.g = du2Var.readBoolean();
                s63Var.h = du2Var.readLong();
                s63Var.i = du2Var.readLong();
                s63Var.j = du2Var.readInt();
                return s63Var;
            }
            return (s63) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends mb3<s63> {
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
        @Override // com.baidu.tieba.mb3
        /* renamed from: b */
        public void a(@NonNull s63 s63Var, @NonNull eu2 eu2Var) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s63Var, eu2Var) == null) {
                eu2Var.f(s63Var.a);
                eu2Var.f(s63Var.b);
                eu2Var.writeLong(s63Var.c);
                eu2Var.writeInt(s63Var.d);
                eu2Var.f(s63Var.e);
                eu2Var.f(s63Var.f);
                eu2Var.writeBoolean(s63Var.g);
                eu2Var.writeLong(s63Var.h);
                eu2Var.writeLong(s63Var.i);
                eu2Var.writeInt(s63Var.j);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948103321, "Lcom/baidu/tieba/s63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948103321, "Lcom/baidu/tieba/s63;");
                return;
            }
        }
        k = new a();
        l = new b();
    }

    public s63() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = 1;
    }

    public Object clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public s63(JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.g = false;
        this.j = 1;
        if (jSONObject == null) {
            return;
        }
        this.a = str;
        this.d = 6;
        this.b = jSONObject.optString("version");
        this.c = jSONObject.optLong("version_code", -1L);
        this.e = jSONObject.optString("path");
        this.g = jSONObject.optBoolean("inline", false);
        this.h = jSONObject.optLong("min_version_code");
        this.i = jSONObject.optLong("max_version_code");
        this.f = jSONObject.optString("config");
        this.j = jSONObject.optInt("require_type");
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return "SwanDependentModel{inline=" + this.g + ", minVersionCode=" + this.h + ", maxVersionCode=" + this.i + ", requireType=" + this.j + ", libName='" + this.a + "', versionName='" + this.b + "', versionCode=" + this.c + ", category=" + this.d + ", libPath='" + this.e + "', libConfig='" + this.f + "'}";
        }
        return (String) invokeV.objValue;
    }
}
