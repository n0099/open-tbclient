package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AppInfo;
/* loaded from: classes8.dex */
public class vpc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AppInfo appInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, appInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, LegoListActivityConfig.AD_ID, appInfo.ad_id);
            poc.a(jSONObject, "ad_name", appInfo.ad_name);
            poc.a(jSONObject, "apk_url", appInfo.apk_url);
            poc.a(jSONObject, "ad_apk_package_name", appInfo.ad_apk_package_name);
            poc.a(jSONObject, "app_size", appInfo.app_size);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
