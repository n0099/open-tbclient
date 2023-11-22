package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.TopNotice;
/* loaded from: classes7.dex */
public class pxc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopNotice topNotice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topNotice)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", topNotice.title);
            qoc.a(jSONObject, "title_link", topNotice.title_link);
            qoc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, topNotice.author);
            qoc.a(jSONObject, "id", topNotice.id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
