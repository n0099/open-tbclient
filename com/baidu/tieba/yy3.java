package com.baidu.tieba;

import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yy3 extends a04 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948346454, "Lcom/baidu/tieba/yy3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948346454, "Lcom/baidu/tieba/yy3;");
                return;
            }
        }
        c = eo1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yy3() {
        super("getAppList");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.a04
    public uz1 a(@NonNull JSONObject jSONObject, @NonNull yk2 yk2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, yk2Var)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", c());
                if (c) {
                    Log.i("GetAppListAction", jSONObject2.toString());
                }
            } catch (JSONException e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            yk2Var.a(jSONObject2);
            return null;
        }
        return (uz1) invokeLL.objValue;
    }

    public final JSONObject b(PackageInfo packageInfo) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, packageInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appName", packageInfo.applicationInfo.name);
            jSONObject.put("appPackageName", packageInfo.packageName);
            jSONObject.put("appVersion", packageInfo.versionName);
            boolean z = true;
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                z = false;
            }
            jSONObject.put("appIsSystemApp", z);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final JSONArray c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (PackageInfo packageInfo : AppRuntime.getAppContext().getPackageManager().getInstalledPackages(1)) {
                jSONArray.put(b(packageInfo));
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }
}
