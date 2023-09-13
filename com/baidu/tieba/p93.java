package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface b {
        void a(o93 o93Var);
    }

    /* loaded from: classes7.dex */
    public static class a extends ResponseCallback<o93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) != null) || (bVar = this.a) == null) {
                return;
            }
            bVar.a(null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(o93 o93Var, int i) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, o93Var, i) != null) || (bVar = this.a) == null) {
                return;
            }
            if (o93Var == null) {
                bVar.a(null);
            } else {
                bVar.a(o93Var);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public o93 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                if (response == null || response.body() == null || (optJSONObject = new JSONObject(response.body().string()).optJSONObject("data")) == null) {
                    return null;
                }
                if (p93.a) {
                    Log.d("SwanAppRelatedSwanHelper", "parseResponse: RelateSwanData" + optJSONObject.toString());
                }
                return o93.a(optJSONObject);
            }
            return (o93) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948016831, "Lcom/baidu/tieba/p93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948016831, "Lcom/baidu/tieba/p93;");
                return;
            }
        }
        a = rr1.a;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            SwanCoreVersion coreVersion = uw2.T().getCoreVersion();
            String i = pk4.i(ou2.o().L());
            HashMap hashMap = new HashMap(4);
            hashMap.put("appkey", gb3.K().getAppId());
            hashMap.put("swan_core_ver", mk3.i(coreVersion, gb3.K().k()));
            hashMap.put("swan_game_ver", mk3.h(1));
            hashMap.put("uid", ou2.h0().i(ou2.c()));
            return zo3.b(i, hashMap);
        }
        return (String) invokeV.objValue;
    }

    public static void c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bVar) == null) {
            ki4 ki4Var = new ki4(b(), new a(bVar));
            if (li4.g().c()) {
                ki4Var.f = true;
            }
            ki4Var.g = true;
            li4.g().d(ki4Var);
        }
    }
}
