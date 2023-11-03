package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ReportInfo;
/* loaded from: classes7.dex */
public class n2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ReportInfo reportInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, reportInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "info", reportInfo.info);
            poc.a(jSONObject, "url", reportInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
