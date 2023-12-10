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
public class syc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottomActivity frsBottomActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottomActivity)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", frsBottomActivity.title);
            ltc.a(jSONObject, "abstract", frsBottomActivity._abstract);
            ltc.a(jSONObject, "image", frsBottomActivity.image);
            ltc.a(jSONObject, "icon", frsBottomActivity.icon);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, frsBottomActivity.jump_url);
            FrsBottomActivityTime frsBottomActivityTime = frsBottomActivity.activity_time;
            if (frsBottomActivityTime != null) {
                ltc.a(jSONObject, "activity_time", tyc.b(frsBottomActivityTime));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
