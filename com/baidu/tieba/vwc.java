package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EsportRank;
import tbclient.EsportUser;
/* loaded from: classes8.dex */
public class vwc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EsportRank esportRank) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esportRank)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", esportRank.title);
            ktc.a(jSONObject, MultiRatePlayUrlHelper.RANK, esportRank.rank);
            EsportUser esportUser = esportRank.user;
            if (esportUser != null) {
                ktc.a(jSONObject, "user", xwc.b(esportUser));
            }
            ktc.a(jSONObject, "text", esportRank.text);
            ktc.a(jSONObject, "url", esportRank.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
