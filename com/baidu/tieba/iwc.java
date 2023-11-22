package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.PhotoInfo;
/* loaded from: classes6.dex */
public class iwc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PhotoInfo photoInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, photoInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "pic", photoInfo.pic);
            qoc.a(jSONObject, "num", photoInfo.num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
