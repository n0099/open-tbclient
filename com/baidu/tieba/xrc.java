package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes9.dex */
public class xrc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EsportRank esportRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esportRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "title", esportRank.title);
            poc.a(jSONObject, MultiRatePlayUrlHelper.RANK, esportRank.rank);
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                poc.a(jSONObject, "user", zrc.b(esportUser));
            }
            poc.a(jSONObject, "text", esportRank.text);
            poc.a(jSONObject, "url", esportRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
