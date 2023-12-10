package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.AdInfo;
import tbclient.Media;
/* loaded from: classes9.dex */
public class xtc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "show_rule", adInfo.show_rule);
            ltc.a(jSONObject, TiebaStatic.Params.AD_TYPE, adInfo.ad_type);
            ltc.a(jSONObject, TiebaStatic.Params.AD_DESC, adInfo.ad_desc);
            ltc.a(jSONObject, "ad_pic", adInfo.ad_pic);
            ltc.a(jSONObject, SignAllForumAdvertActivityConfig.AD_URL, adInfo.ad_url);
            ltc.a(jSONObject, "ad_name", adInfo.ad_name);
            ltc.a(jSONObject, "portrait", adInfo.portrait);
            if (adInfo.media != null) {
                JSONArray jSONArray = new JSONArray();
                for (Media media : adInfo.media) {
                    jSONArray.put(c5d.b(media));
                }
                ltc.a(jSONObject, "media", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
