package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.MultiMediaDataConstant;
import org.json.JSONObject;
import tbclient.ActionControl;
/* loaded from: classes9.dex */
public class yoc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ActionControl actionControl) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, actionControl)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "url", actionControl.url);
            qoc.a(jSONObject, "name", actionControl.name);
            qoc.a(jSONObject, MultiMediaDataConstant.KEY_EXT_TEXT_WORDS_COLOR, actionControl.text_color);
            qoc.a(jSONObject, "text_color_pressed", actionControl.text_color_pressed);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
