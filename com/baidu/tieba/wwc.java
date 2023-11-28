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
public class wwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EsportRank esportRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esportRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", esportRank.title);
            ltc.a(jSONObject, MultiRatePlayUrlHelper.RANK, esportRank.rank);
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                ltc.a(jSONObject, "user", ywc.b(esportUser));
            }
            ltc.a(jSONObject, "text", esportRank.text);
            ltc.a(jSONObject, "url", esportRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
