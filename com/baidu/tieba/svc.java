package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.MangaBrowserActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CartoonThread;
/* loaded from: classes8.dex */
public class svc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CartoonThread cartoonThread) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, cartoonThread)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, MangaBrowserActivityConfig.CARTOON_ID, cartoonThread.cartoon_id);
            ltc.a(jSONObject, MangaBrowserActivityConfig.CHAPTER_ID, cartoonThread.chapter_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
