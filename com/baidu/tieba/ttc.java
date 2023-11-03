package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsBottomActivity;
import tbclient.FrsBottomActivityTime;
/* loaded from: classes8.dex */
public class ttc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomActivity frsBottomActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomActivity)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", frsBottomActivity.title);
            poc.a(jSONObject, "abstract", frsBottomActivity._abstract);
            poc.a(jSONObject, "image", frsBottomActivity.image);
            poc.a(jSONObject, "icon", frsBottomActivity.icon);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, frsBottomActivity.jump_url);
            FrsBottomActivityTime frsBottomActivityTime = frsBottomActivity.activity_time;
            if (frsBottomActivityTime != null) {
                poc.a(jSONObject, "activity_time", utc.b(frsBottomActivityTime));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
