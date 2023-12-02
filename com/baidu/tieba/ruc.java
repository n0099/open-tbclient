package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes8.dex */
public class ruc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, app)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", app.type);
            ktc.a(jSONObject, "pos", app.pos);
            ktc.a(jSONObject, "icon_url", app.icon_url);
            ktc.a(jSONObject, "icon_link", app.icon_link);
            ktc.a(jSONObject, "app_name", app.app_name);
            ktc.a(jSONObject, "app_desc", app.app_desc);
            ktc.a(jSONObject, "p_name", app.p_name);
            ktc.a(jSONObject, "p_url", app.p_url);
            ktc.a(jSONObject, BigdayActivityConfig.IMG_URL, app.img_url);
            ktc.a(jSONObject, "app_time", app.app_time);
            ktc.a(jSONObject, "web_url", app.web_url);
            ktc.a(jSONObject, LegoListActivityConfig.AD_ID, app.ad_id);
            ktc.a(jSONObject, "id", app.id);
            ktc.a(jSONObject, "name", app.name);
            ktc.a(jSONObject, "url_type", app.url_type);
            ktc.a(jSONObject, "url", app.url);
            ktc.a(jSONObject, "ios_url", app.ios_url);
            ktc.a(jSONObject, "apk_url", app.apk_url);
            ktc.a(jSONObject, "apk_name", app.apk_name);
            ktc.a(jSONObject, "pos_name", app.pos_name);
            ktc.a(jSONObject, "first_name", app.first_name);
            ktc.a(jSONObject, "second_name", app.second_name);
            ktc.a(jSONObject, "cpid", app.cpid);
            ktc.a(jSONObject, "abtest", app.abtest);
            ktc.a(jSONObject, "plan_id", app.plan_id);
            ktc.a(jSONObject, "user_id", app.user_id);
            ktc.a(jSONObject, "price", app.price);
            ktc.a(jSONObject, SmsLoginView.f.j, app.verify);
            ktc.a(jSONObject, MigrateStatisticUtils.EXT_INFO, app.ext_info);
            if (app.goods_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (GoodsInfo goodsInfo : app.goods_info) {
                    jSONArray.put(r3d.b(goodsInfo));
                }
                ktc.a(jSONObject, "goods_info", jSONArray);
            }
            ktc.a(jSONObject, "loc_code", app.loc_code);
            ktc.a(jSONObject, "deep_url", app.deep_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
