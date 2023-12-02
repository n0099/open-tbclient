package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import org.json.JSONObject;
import tbclient.FrsPage.HeadSdk;
/* loaded from: classes8.dex */
public class r0d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HeadSdk headSdk) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, headSdk)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "head_pic", headSdk.head_pic);
            ktc.a(jSONObject, "head_text", headSdk.head_text);
            ktc.a(jSONObject, HianalyticsBaseData.SDK_NAME, headSdk.sdk_name);
            ktc.a(jSONObject, "sdk_params", headSdk.sdk_params);
            ktc.a(jSONObject, "head_type", headSdk.head_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
