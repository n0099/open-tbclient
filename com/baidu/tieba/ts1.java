package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ts1 extends hs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "HostDownloadManager" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "HostDownloadManagerApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements us1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ts1 ts1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts1Var, str};
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

    /* loaded from: classes6.dex */
    public class b implements us1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ts1 ts1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts1Var, str};
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

    /* loaded from: classes6.dex */
    public class c implements us1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ts1 ts1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts1Var, str};
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
    public ts1(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ew1 query(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#query", false);
            if (e43.b0() == null) {
                return new ew1(1001);
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (ew1Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new ew1(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ew1(202, "cb is empty");
                }
                wo1 z = ln2.z();
                if (z != null) {
                    z.b(optString, new b(this, optString2));
                }
                return ew1.f();
            }
            e12.c("HostDownloadManagerApi", "parse fail");
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 x(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            e43 b0 = e43.b0();
            if (b0 == null) {
                return new ew1(1001);
            }
            if (b0.w() == null) {
                return new ew1(1001);
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (ew1Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("url");
                if (TextUtils.isEmpty(optString)) {
                    return new ew1(202, "url is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ew1(202, "cb is empty");
                }
                String optString3 = jSONObject.optString("name");
                JSONObject optJSONObject = jSONObject.optJSONObject("header");
                wo1 z = ln2.z();
                if (z != null) {
                    z.d(optString, optString3, optJSONObject, new a(this, optString2));
                }
                return ew1.f();
            }
            e12.c("HostDownloadManagerApi", "parse fail");
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 z(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#openFile", false);
            if (e43.b0() == null) {
                return new ew1(1001);
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (ew1Var.isSuccess() && (obj = s.second) != null) {
                JSONObject jSONObject = (JSONObject) obj;
                String optString = jSONObject.optString("taskID");
                if (TextUtils.isEmpty(optString)) {
                    return new ew1(202, "taskId is empty");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new ew1(202, "cb is empty");
                }
                SwanAppActivity activity = rp2.U().getActivity();
                if (activity == null) {
                    return new ew1(1001);
                }
                wo1 z = ln2.z();
                if (z != null) {
                    z.c(activity, optString, new c(this, optString2));
                }
                return ew1.f();
            }
            e12.c("HostDownloadManagerApi", "parse fail");
            return ew1Var;
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#openDownloadCenter", false);
            if (e43.b0() == null) {
                return new ew1(1001);
            }
            wo1 z = ln2.z();
            if (z != null) {
                z.a();
            }
            return ew1.f();
        }
        return (ew1) invokeV.objValue;
    }
}
