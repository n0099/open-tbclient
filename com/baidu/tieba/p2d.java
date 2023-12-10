package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.TopLiveData;
import tbclient.FrsPage.TopLiveDataPostList;
import tbclient.YyExt;
/* loaded from: classes7.dex */
public class p2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopLiveData topLiveData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topLiveData)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "title", topLiveData.title);
            ltc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, topLiveData.cover);
            ltc.a(jSONObject, "desc", topLiveData.desc);
            ltc.a(jSONObject, "live_size", topLiveData.live_size);
            ltc.a(jSONObject, "jump_type", topLiveData.jump_type);
            ltc.a(jSONObject, BigdayActivityConfig.JUMP_URL, topLiveData.jump_url);
            ltc.a(jSONObject, "flv", topLiveData.flv);
            ltc.a(jSONObject, "hls", topLiveData.hls);
            YyExt yyExt = topLiveData.yy_ext;
            if (yyExt != null) {
                ltc.a(jSONObject, "yy_ext", tbd.b(yyExt));
            }
            if (topLiveData.post_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (TopLiveDataPostList topLiveDataPostList : topLiveData.post_list) {
                    jSONArray.put(q2d.b(topLiveDataPostList));
                }
                ltc.a(jSONObject, "post_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
