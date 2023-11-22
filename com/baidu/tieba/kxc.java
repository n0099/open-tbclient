package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ThreadIdListInfo;
/* loaded from: classes7.dex */
public class kxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ThreadIdListInfo threadIdListInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadIdListInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "tid", threadIdListInfo.tid);
            qoc.a(jSONObject, "is_partial_visible", threadIdListInfo.is_partial_visible);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
