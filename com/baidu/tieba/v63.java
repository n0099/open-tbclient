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
/* loaded from: classes8.dex */
public final class v63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static final y63<a> e;
        public static final x63<a> f;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        /* renamed from: com.baidu.tieba.v63$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C0497a extends y63<a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0497a() {
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
            @Override // com.baidu.tieba.y63
            /* renamed from: c */
            public void b(@NonNull a aVar, @NonNull qp2 qp2Var) throws Exception {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, qp2Var) == null) {
                    qp2Var.writeInt(aVar.a);
                    qp2Var.writeInt(aVar.b);
                    qp2Var.writeInt(aVar.c);
                    qp2Var.writeInt(aVar.d);
                }
            }
        }

        /* loaded from: classes8.dex */
        public static class b extends x63<a> {
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
            @Override // com.baidu.tieba.x63
            /* renamed from: c */
            public a b(@NonNull pp2 pp2Var) throws Exception {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pp2Var)) == null) {
                    a aVar = new a();
                    aVar.a = pp2Var.readInt();
                    aVar.b = pp2Var.readInt();
                    aVar.c = pp2Var.readInt();
                    aVar.d = pp2Var.readInt();
                    return aVar;
                }
                return (a) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-392581159, "Lcom/baidu/tieba/v63$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-392581159, "Lcom/baidu/tieba/v63$a;");
                    return;
                }
            }
            e = new C0497a();
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

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (v63.a) {
                    Log.w("SwanAppCommonConfigData", "NetworkConfig createNullObject()");
                }
                a aVar = new a();
                aVar.a = 10000;
                aVar.b = 60000;
                return aVar;
            }
            return (a) invokeV.objValue;
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

        public static int c(a aVar) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar)) == null) {
                if (aVar != null && aVar.a > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948192694, "Lcom/baidu/tieba/v63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948192694, "Lcom/baidu/tieba/v63;");
                return;
            }
        }
        a = vm1.a;
    }
}
