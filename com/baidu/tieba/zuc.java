package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Baijiahao;
/* loaded from: classes9.dex */
public class zuc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Baijiahao baijiahao) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, baijiahao)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "ori_ugc_nid", baijiahao.ori_ugc_nid);
            ltc.a(jSONObject, "ori_ugc_tid", baijiahao.ori_ugc_tid);
            ltc.a(jSONObject, TiebaStatic.Params.UGC_TYPE, baijiahao.ori_ugc_type);
            ltc.a(jSONObject, "ori_ugc_vid", baijiahao.ori_ugc_vid);
            ltc.a(jSONObject, "forward_url", baijiahao.forward_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
