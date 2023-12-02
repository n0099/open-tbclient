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
public class o2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull TopLiveData topLiveData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, topLiveData)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "title", topLiveData.title);
            ktc.a(jSONObject, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY, topLiveData.cover);
            ktc.a(jSONObject, "desc", topLiveData.desc);
            ktc.a(jSONObject, "live_size", topLiveData.live_size);
            ktc.a(jSONObject, "jump_type", topLiveData.jump_type);
            ktc.a(jSONObject, BigdayActivityConfig.JUMP_URL, topLiveData.jump_url);
            ktc.a(jSONObject, "flv", topLiveData.flv);
            ktc.a(jSONObject, "hls", topLiveData.hls);
            YyExt yyExt = topLiveData.yy_ext;
            if (yyExt != null) {
                ktc.a(jSONObject, "yy_ext", sbd.b(yyExt));
            }
            if (topLiveData.post_list != null) {
                JSONArray jSONArray = new JSONArray();
                for (TopLiveDataPostList topLiveDataPostList : topLiveData.post_list) {
                    jSONArray.put(p2d.b(topLiveDataPostList));
                }
                ktc.a(jSONObject, "post_list", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
