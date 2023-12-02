package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AnimationThread;
/* loaded from: classes7.dex */
public class nuc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnimationThread animationThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, animationThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "video_pic", animationThread.video_pic);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, animationThread.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
