package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ThreadIdListInfo;
/* loaded from: classes6.dex */
public class k2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadIdListInfo threadIdListInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadIdListInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "tid", threadIdListInfo.tid);
            ktc.a(jSONObject, "is_partial_visible", threadIdListInfo.is_partial_visible);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
