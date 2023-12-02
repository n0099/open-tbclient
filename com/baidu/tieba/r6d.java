package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PostExposeHead;
/* loaded from: classes8.dex */
public class r6d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PostExposeHead postExposeHead) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, postExposeHead)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, BigdayActivityConfig.IMG_URL, postExposeHead.img_url);
            ktc.a(jSONObject, "corner_url", postExposeHead.corner_url);
            ktc.a(jSONObject, "schema", postExposeHead.schema);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
