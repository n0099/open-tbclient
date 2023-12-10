package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TopNews;
/* loaded from: classes8.dex */
public class r2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopNews topNews) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topNews)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "news_link", topNews.news_link);
            ltc.a(jSONObject, "summary", topNews.summary);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
