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
public class utc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomActivity frsBottomActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomActivity)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "title", frsBottomActivity.title);
            qoc.a(jSONObject, "abstract", frsBottomActivity._abstract);
            qoc.a(jSONObject, "image", frsBottomActivity.image);
            qoc.a(jSONObject, "icon", frsBottomActivity.icon);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, frsBottomActivity.jump_url);
            FrsBottomActivityTime frsBottomActivityTime = frsBottomActivity.activity_time;
            if (frsBottomActivityTime != null) {
                qoc.a(jSONObject, "activity_time", vtc.b(frsBottomActivityTime));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
