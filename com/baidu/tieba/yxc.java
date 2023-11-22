package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.WorldCupNews;
/* loaded from: classes9.dex */
public class yxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull WorldCupNews worldCupNews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, worldCupNews)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", worldCupNews.title);
            qoc.a(jSONObject, "url", worldCupNews.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
