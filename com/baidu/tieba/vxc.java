package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FeedMaskLayer;
import tbclient.MaskLayerText;
/* loaded from: classes8.dex */
public class vxc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FeedMaskLayer feedMaskLayer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, feedMaskLayer)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "topright_text", feedMaskLayer.topright_text);
            if (feedMaskLayer.button_texts != null) {
                JSONArray jSONArray = new JSONArray();
                for (MaskLayerText maskLayerText : feedMaskLayer.button_texts) {
                    jSONArray.put(z4d.b(maskLayerText));
                }
                ktc.a(jSONObject, "button_texts", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
