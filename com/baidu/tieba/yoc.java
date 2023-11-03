package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ActivityInfo;
/* loaded from: classes9.dex */
public class yoc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActivityInfo activityInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activityInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "activity_id", activityInfo.activity_id);
            poc.a(jSONObject, "main_title", activityInfo.main_title);
            poc.a(jSONObject, "sub_title", activityInfo.sub_title);
            poc.a(jSONObject, "back_pic", activityInfo.back_pic);
            poc.a(jSONObject, "back_pic_width", activityInfo.back_pic_width);
            poc.a(jSONObject, "back_pic_height", activityInfo.back_pic_height);
            poc.a(jSONObject, "subpage_link", activityInfo.subpage_link);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
