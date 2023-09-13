package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class wz1 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "HostDownloadManager" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "HostDownloadManagerApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements xz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(wz1 wz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements xz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wz1 wz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements xz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(wz1 wz1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wz1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wz1(@NonNull iz1 iz1Var) {
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

    public h32 query(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#query", false);
            if (hb3.b0() == null) {
                return new h32(1001);
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (h32Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new h32(202, "cb is empty");
                }
                zv1 z = ou2.z();
                if (z != null) {
                    z.b(optString, new b(this, optString2));
                }
                return h32.f();
            }
            h82.c("HostDownloadManagerApi", "parse fail");
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public h32 x(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                return new h32(1001);
            }
            if (b0.w() == null) {
                return new h32(1001);
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (h32Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(202, ExceptionMessage.URL_EMPTY);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new h32(202, "cb is empty");
                }
                String optString3 = jSONObject.optString("name");
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                zv1 z = ou2.z();
                if (z != null) {
                    z.d(optString, optString3, optJSONObject, new a(this, optString2));
                }
                return h32.f();
            }
            h82.c("HostDownloadManagerApi", "parse fail");
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public h32 z(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#openFile", false);
            if (hb3.b0() == null) {
                return new h32(1001);
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (h32Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new h32(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new h32(202, "cb is empty");
                }
                SwanAppActivity activity = uw2.T().getActivity();
                if (activity == null) {
                    return new h32(1001);
                }
                zv1 z = ou2.z();
                if (z != null) {
                    z.c(activity, optString, new c(this, optString2));
                }
                return h32.f();
            }
            h82.c("HostDownloadManagerApi", "parse fail");
            return h32Var;
        }
        return (h32) invokeL.objValue;
    }

    public h32 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#openDownloadCenter", false);
            if (hb3.b0() == null) {
                return new h32(1001);
            }
            zv1 z = ou2.z();
            if (z != null) {
                z.a();
            }
            return h32.f();
        }
        return (h32) invokeV.objValue;
    }
}
