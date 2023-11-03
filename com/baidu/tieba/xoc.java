package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ActionControl;
/* loaded from: classes9.dex */
public class xoc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActionControl actionControl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actionControl)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "url", actionControl.url);
            poc.a(jSONObject, "name", actionControl.name);
            poc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, actionControl.text_color);
            poc.a(jSONObject, "text_color_pressed", actionControl.text_color_pressed);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
