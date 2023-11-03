package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SpriteButton;
/* loaded from: classes7.dex */
public class n3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SpriteButton spriteButton) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, spriteButton)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text", spriteButton.text);
            poc.a(jSONObject, "schema", spriteButton.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
