package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public final class ks6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final TiebaPlusInfo a(d87 businessInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
            String str = businessInfo.a().get("tie_plus_info");
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    builder.title = jSONObject.optString("title");
                    builder.desc = jSONObject.optString("desc");
                    builder.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    builder.download_url = jSONObject.optString("download_url");
                    builder.app_id = jSONObject.optString("app_id");
                    builder.app_icon = jSONObject.optString("app_icon");
                    builder.app_package = jSONObject.optString("app_package");
                    builder.app_version = jSONObject.optString("app_version");
                    builder.app_privacy = jSONObject.optString("app_privacy");
                    builder.app_power = jSONObject.optString("app_power");
                    builder.app_company = jSONObject.optString("app_company");
                    builder.target_type = Integer.valueOf(jSONObject.optInt(GameGuideConfigInfo.KEY_TARGET_TYPE));
                    builder.h5_jump_type = Integer.valueOf(jSONObject.optInt("h5_jump_type"));
                    builder.h5_jump_number = jSONObject.optString("h5_jump_number");
                    builder.h5_jump_param = jSONObject.optString("h5_jump_param");
                    builder.jump_type = Integer.valueOf(jSONObject.optInt("jump_type"));
                    builder.item_id = jSONObject.optString("item_id");
                    builder.is_appoint = Integer.valueOf(jSONObject.optInt("is_appoint"));
                    if (jSONObject.has("plugin_user")) {
                        JSONObject jSONObject2 = new JSONObject(jSONObject.optString("plugin_user"));
                        PluginUser.Builder builder2 = new PluginUser.Builder();
                        builder2.user_id = Long.valueOf(jSONObject2.optLong("user_id"));
                        builder2.user_name_show = jSONObject2.optString("user_name_show");
                        builder2.user_type = Integer.valueOf(jSONObject2.optInt("user_type"));
                        builder2.user_photo = jSONObject2.optString("user_photo");
                        builder2.is_download_card_whiteuser = Integer.valueOf(jSONObject2.optInt("is_download_card_whiteuser"));
                        builder.plugin_user = builder2.build(false);
                    }
                    builder.forum_name = jSONObject.optString("forum_name");
                    builder.jump_setting = Integer.valueOf(jSONObject.optInt("jump_setting"));
                    builder.wx_thumbnail = jSONObject.optString("wx_thumbnail");
                    builder.button_desc = jSONObject.optString("button_desc");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            TiebaPlusInfo build = builder.build(true);
            Intrinsics.checkNotNullExpressionValue(build, "builder.build(true)");
            return build;
        }
        return (TiebaPlusInfo) invokeL.objValue;
    }
}
