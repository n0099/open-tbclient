package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class j33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final m33<a> e;
        public static final l33<a> f;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        /* renamed from: com.baidu.tieba.j33$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0304a extends m33<a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0304a() {
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
            public void a(@NonNull a aVar, @NonNull em2 em2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, em2Var) == null) {
                    em2Var.writeInt(aVar.a);
                    em2Var.writeInt(aVar.b);
                    em2Var.writeInt(aVar.c);
                    em2Var.writeInt(aVar.d);
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class b extends l33<a> {
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
            @Override // com.baidu.tieba.l33
            /* renamed from: b */
            public a a(@NonNull dm2 dm2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm2Var)) == null) {
                    a aVar = new a();
                    aVar.a = dm2Var.readInt();
                    aVar.b = dm2Var.readInt();
                    aVar.c = dm2Var.readInt();
                    aVar.d = dm2Var.readInt();
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-738901534, "Lcom/baidu/tieba/j33$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-738901534, "Lcom/baidu/tieba/j33$a;");
                    return;
                }
            }
            e = new C0304a();
            f = new b();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static a a(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return b();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
                if (optJSONObject == null) {
                    return b();
                }
                a aVar = new a();
                if (optJSONObject.optInt("request") > 0 && optJSONObject.optInt("request") <= 60000) {
                    aVar.a = optJSONObject.optInt("request", 10000);
                } else {
                    aVar.a = 10000;
                }
                aVar.b = optJSONObject.optInt("connectSocket", 60000);
                aVar.c = optJSONObject.optInt("uploadFile");
                aVar.d = optJSONObject.optInt("downloadFile");
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (j33.a) {
                    Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
                }
                a aVar = new a();
                aVar.a = 10000;
                aVar.b = 60000;
                return aVar;
            }
            return (a) invokeV.objValue;
        }

        public static int c(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
                if (aVar != null && aVar.a > 0) {
                    return aVar.a;
                }
                return 10000;
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832319, "Lcom/baidu/tieba/j33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832319, "Lcom/baidu/tieba/j33;");
                return;
            }
        }
        a = ij1.a;
    }
}
