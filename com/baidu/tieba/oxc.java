package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes7.dex */
public class oxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopNotice topNotice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topNotice)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", topNotice.title);
            poc.a(jSONObject, "title_link", topNotice.title_link);
            poc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, topNotice.author);
            poc.a(jSONObject, "id", topNotice.id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
