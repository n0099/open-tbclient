package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.Calendar;
/* loaded from: classes7.dex */
public class nzc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Calendar calendar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, calendar)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "d", calendar.d);
            ktc.a(jSONObject, "t", calendar.t);
            ktc.a(jSONObject, MultiRatePlayUrlHelper.RANK, calendar.rank);
            ktc.a(jSONObject, "sign_type", calendar.sign_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
