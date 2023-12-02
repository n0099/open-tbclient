package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.LinkThreadContent;
/* loaded from: classes8.dex */
public class t4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull LinkThreadContent linkThreadContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, linkThreadContent)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "link_type", linkThreadContent.link_type);
            ktc.a(jSONObject, "link_title", linkThreadContent.link_title);
            ktc.a(jSONObject, "link_abstract", linkThreadContent.link_abstract);
            ktc.a(jSONObject, "link_head_pic", linkThreadContent.link_head_pic);
            ktc.a(jSONObject, "link_head_small_pic", linkThreadContent.link_head_small_pic);
            ktc.a(jSONObject, "link_head_big_pic", linkThreadContent.link_head_big_pic);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
