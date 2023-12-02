package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes8.dex */
public class r2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopNotice topNotice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topNotice)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", topNotice.title);
            ktc.a(jSONObject, "title_link", topNotice.title_link);
            ktc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, topNotice.author);
            ktc.a(jSONObject, "id", topNotice.id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
