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
/* loaded from: classes8.dex */
public class vyc extends qoc {
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
                    jSONArray.put(a3d.b(shortUserInfo));
                }
                qoc.a(jSONObject, "hot_user", jSONArray);
            }
            qoc.a(jSONObject, Info.kBaiduModuleKey, hotUserRankEntry.module_name);
            qoc.a(jSONObject, "module_icon", hotUserRankEntry.module_icon);
            qoc.a(jSONObject, "today_rank", hotUserRankEntry.today_rank);
            qoc.a(jSONObject, "yesterday_rank", hotUserRankEntry.yesterday_rank);
            qoc.a(jSONObject, "is_in_rank", hotUserRankEntry.is_in_rank);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
