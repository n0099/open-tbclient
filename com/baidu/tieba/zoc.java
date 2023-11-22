package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes9.dex */
public class zoc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActivityInfo activityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "activity_id", activityInfo.activity_id);
            qoc.a(jSONObject, "main_title", activityInfo.main_title);
            qoc.a(jSONObject, "sub_title", activityInfo.sub_title);
            qoc.a(jSONObject, "back_pic", activityInfo.back_pic);
            qoc.a(jSONObject, "back_pic_width", activityInfo.back_pic_width);
            qoc.a(jSONObject, "back_pic_height", activityInfo.back_pic_height);
            qoc.a(jSONObject, "subpage_link", activityInfo.subpage_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
