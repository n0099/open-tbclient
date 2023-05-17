package com.baidu.tieba;

import android.content.Context;
import android.text.SpannableString;
import androidx.core.util.Pair;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ey6;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes7.dex */
public final class tl6 implements ey6.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tl6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ey6.k
    public SpannableString a(Context context, uz6 businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            ThreadData threadData = new ThreadData();
            TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
            String str = businessInfo.a().get("tieba_plus_info");
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
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString("plugin_user"));
                    PluginUser.Builder builder2 = new PluginUser.Builder();
                    builder2.user_id = Long.valueOf(jSONObject2.optLong("user_id"));
                    builder2.user_name_show = jSONObject2.optString("user_name_show");
                    builder2.user_type = Integer.valueOf(jSONObject2.optInt("user_type"));
                    builder2.user_photo = jSONObject2.optString("user_photo");
                    builder2.is_download_card_whiteuser = Integer.valueOf(jSONObject2.optInt("is_download_card_whiteuser"));
                    builder.plugin_user = builder2.build(false);
                    builder.forum_name = jSONObject.optString("forum_name");
                    builder.jump_setting = Integer.valueOf(jSONObject.optInt("jump_setting"));
                    builder.wx_thumbnail = jSONObject.optString("wx_thumbnail");
                    builder.button_desc = jSONObject.optString("button_desc");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String str2 = businessInfo.a().get("tiebaplus_ad");
            if (str2 != null) {
                try {
                    JSONObject jSONObject3 = new JSONObject(str2);
                    threadData.tiePlusAdSource = jSONObject3.optString(TiebaStatic.Params.T_PLUS_AD_SOURCE);
                    threadData.tiePlusShowUrl = jSONObject3.optString("show_url");
                    threadData.tiePlusCostUrl = jSONObject3.optString("cost_url");
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            threadData.tiePlusMonitorShowUrl = businessInfo.a().get("exposure_monitor_url");
            threadData.tiePlusMonitorClickUrl = businessInfo.a().get("click_monitor_url");
            String str3 = businessInfo.a().get("works_info");
            if (str3 != null) {
                WorksInfoData worksInfoData = new WorksInfoData();
                worksInfoData.parseJson(new JSONObject(str3));
                threadData.worksInfoData = worksInfoData;
            }
            threadData.threadType = pg.e(businessInfo.a().get("thread_type"), 0);
            threadData.isTiebaPlusAdThread = Intrinsics.areEqual(businessInfo.a().get("is_tiebaplus_ad"), "1");
            threadData.tiebaPlusOrderId = businessInfo.a().get("tiebaplus_order_id");
            threadData.tiebaPlusToken = businessInfo.a().get("tiebaplus_token");
            threadData.tiebaPlusExtraParam = businessInfo.a().get("tiebaplus_extra_param");
            threadData.tiebaplusCantDelete = Intrinsics.areEqual(businessInfo.a().get("tiebaplus_cant_delete"), "1");
            Pair<CharSequence, vx5> r = nx5.r(35, threadData, builder.build(false));
            if (r != null) {
                CharSequence charSequence = r.first;
                if (charSequence instanceof SpannableString) {
                    if (charSequence != null) {
                        return (SpannableString) charSequence;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
                }
            }
            return new SpannableString("");
        }
        return (SpannableString) invokeLL.objValue;
    }
}
