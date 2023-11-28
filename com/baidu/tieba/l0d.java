package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.FrsSpriteBubble;
import tbclient.SpriteBubble;
/* loaded from: classes7.dex */
public class l0d extends ltc {
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
                ltc.a(jSONObject, "bubble_text", q8d.b(spriteBubble));
            }
            ltc.a(jSONObject, "bubble_uri", frsSpriteBubble.bubble_uri);
            ltc.a(jSONObject, "bubble_seconds", frsSpriteBubble.bubble_seconds);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
