package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ChatContent;
/* loaded from: classes8.dex */
public class wqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ChatContent chatContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, chatContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "scheme", chatContent.scheme);
            qoc.a(jSONObject, "btn_text", chatContent.btn_text);
            qoc.a(jSONObject, "bot_uk", chatContent.bot_uk);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
