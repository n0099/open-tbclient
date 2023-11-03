package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.SpriteBubble;
/* loaded from: classes7.dex */
public class kvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsSpriteBubble frsSpriteBubble) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsSpriteBubble)) == null) {
            JSONObject jSONObject = new JSONObject();
            SpriteBubble spriteBubble = frsSpriteBubble.bubble_text;
            if (spriteBubble != null) {
                poc.a(jSONObject, "bubble_text", m3d.b(spriteBubble));
            }
            poc.a(jSONObject, "bubble_uri", frsSpriteBubble.bubble_uri);
            poc.a(jSONObject, "bubble_seconds", frsSpriteBubble.bubble_seconds);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
