package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AddBawuPopInfo;
/* loaded from: classes9.dex */
public class ztc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AddBawuPopInfo addBawuPopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, addBawuPopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", addBawuPopInfo.title);
            ltc.a(jSONObject, "content", addBawuPopInfo.content);
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, addBawuPopInfo.img_url);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, addBawuPopInfo.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
