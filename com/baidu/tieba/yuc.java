package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Baijiahao;
/* loaded from: classes9.dex */
public class yuc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Baijiahao baijiahao) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baijiahao)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "ori_ugc_nid", baijiahao.ori_ugc_nid);
            ktc.a(jSONObject, "ori_ugc_tid", baijiahao.ori_ugc_tid);
            ktc.a(jSONObject, TiebaStatic.Params.UGC_TYPE, baijiahao.ori_ugc_type);
            ktc.a(jSONObject, "ori_ugc_vid", baijiahao.ori_ugc_vid);
            ktc.a(jSONObject, "forward_url", baijiahao.forward_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
