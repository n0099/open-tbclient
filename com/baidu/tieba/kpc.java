package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaCoverLabel;
/* loaded from: classes7.dex */
public class kpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaCoverLabel alaCoverLabel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaCoverLabel)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "label_id", alaCoverLabel.label_id);
            qoc.a(jSONObject, "label_name", alaCoverLabel.label_name);
            qoc.a(jSONObject, "label_rgb", alaCoverLabel.label_rgb);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
