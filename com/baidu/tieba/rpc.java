package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AnimationThread;
/* loaded from: classes8.dex */
public class rpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AnimationThread animationThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, animationThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "video_pic", animationThread.video_pic);
            qoc.a(jSONObject, BigdayActivityConfig.JUMP_URL, animationThread.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
