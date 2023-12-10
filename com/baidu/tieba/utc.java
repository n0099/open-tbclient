package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes8.dex */
public class utc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActivityInfo activityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "activity_id", activityInfo.activity_id);
            ltc.a(jSONObject, "main_title", activityInfo.main_title);
            ltc.a(jSONObject, "sub_title", activityInfo.sub_title);
            ltc.a(jSONObject, "back_pic", activityInfo.back_pic);
            ltc.a(jSONObject, "back_pic_width", activityInfo.back_pic_width);
            ltc.a(jSONObject, "back_pic_height", activityInfo.back_pic_height);
            ltc.a(jSONObject, "subpage_link", activityInfo.subpage_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
