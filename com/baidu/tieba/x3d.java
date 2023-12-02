package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.appsearchlib.Info;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.HotUserRankEntry;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class x3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull HotUserRankEntry hotUserRankEntry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hotUserRankEntry)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (hotUserRankEntry.hot_user != null) {
                JSONArray jSONArray = new JSONArray();
                for (ShortUserInfo shortUserInfo : hotUserRankEntry.hot_user) {
                    jSONArray.put(c8d.b(shortUserInfo));
                }
                ktc.a(jSONObject, "hot_user", jSONArray);
            }
            ktc.a(jSONObject, Info.kBaiduModuleKey, hotUserRankEntry.module_name);
            ktc.a(jSONObject, "module_icon", hotUserRankEntry.module_icon);
            ktc.a(jSONObject, "today_rank", hotUserRankEntry.today_rank);
            ktc.a(jSONObject, "yesterday_rank", hotUserRankEntry.yesterday_rank);
            ktc.a(jSONObject, "is_in_rank", hotUserRankEntry.is_in_rank);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
