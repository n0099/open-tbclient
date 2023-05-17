package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lua {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static RippedAd a(JSONObject jSONObject) {
        InterceptResult invokeL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            if (optJSONObject != null) {
                str2 = optJSONObject.optString("appname");
                str3 = optJSONObject.optString("pkg_name");
                str = optJSONObject.optString("pkgurl");
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            RippedAd.Builder builder = new RippedAd.Builder();
            builder.setCorporation(jSONObject.optString("corporation_name")).setTitle(jSONObject.optString("txt")).setDescription(jSONObject.optString("desc")).setAppName(str2).setAppPkg(str3).setAppUrl(str).setIconUrl(jSONObject.optString("img2")).setImageUrl(jSONObject.optString("img")).setVideoImageUrl(null).setVideoUrl(jSONObject.optString("video")).setClickUrl(jSONObject.optString("rl")).setDeepLinkUrl(jSONObject.optString("customized_invoke_url")).setConvUrl(null);
            return builder.build();
        }
        return (RippedAd) invokeL.objValue;
    }
}
