package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.YyExt;
/* loaded from: classes8.dex */
public class sbd extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull YyExt yyExt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, yyExt)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "sid", yyExt.sid);
            ktc.a(jSONObject, YyLiveRoomConfig.KEY_SSID, yyExt.ssid);
            ktc.a(jSONObject, "template_id", yyExt.template_id);
            ktc.a(jSONObject, "yy_uid", yyExt.yy_uid);
            ktc.a(jSONObject, "is_yy_game", yyExt.is_yy_game);
            ktc.a(jSONObject, "stream_info", yyExt.stream_info);
            ktc.a(jSONObject, "rank_show", yyExt.rank_show);
            ktc.a(jSONObject, "icon_url", yyExt.icon_url);
            ktc.a(jSONObject, "feed_id", yyExt.feed_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
