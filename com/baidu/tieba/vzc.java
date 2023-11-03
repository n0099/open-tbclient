package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LotteryTheme;
/* loaded from: classes8.dex */
public class vzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LotteryTheme lotteryTheme) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lotteryTheme)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "bgcolor", lotteryTheme.bgcolor);
            poc.a(jSONObject, "bgimage", lotteryTheme.bgimage);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
