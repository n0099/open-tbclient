package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ReportInfo;
/* loaded from: classes7.dex */
public class o2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ReportInfo reportInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, reportInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "info", reportInfo.info);
            qoc.a(jSONObject, "url", reportInfo.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
