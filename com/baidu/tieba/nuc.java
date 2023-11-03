package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Calendar;
/* loaded from: classes7.dex */
public class nuc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, calendar)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "d", calendar.d);
            poc.a(jSONObject, "t", calendar.t);
            poc.a(jSONObject, MultiRatePlayUrlHelper.RANK, calendar.rank);
            poc.a(jSONObject, "sign_type", calendar.sign_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
