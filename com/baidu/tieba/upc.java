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
public class upc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, app)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "type", app.type);
            poc.a(jSONObject, "pos", app.pos);
            poc.a(jSONObject, "icon_url", app.icon_url);
            poc.a(jSONObject, "icon_link", app.icon_link);
            poc.a(jSONObject, "app_name", app.app_name);
            poc.a(jSONObject, "app_desc", app.app_desc);
            poc.a(jSONObject, "p_name", app.p_name);
            poc.a(jSONObject, "p_url", app.p_url);
            poc.a(jSONObject, BigdayActivityConfig.IMG_URL, app.img_url);
            poc.a(jSONObject, "app_time", app.app_time);
            poc.a(jSONObject, "web_url", app.web_url);
            poc.a(jSONObject, LegoListActivityConfig.AD_ID, app.ad_id);
            poc.a(jSONObject, "id", app.id);
            poc.a(jSONObject, "name", app.name);
            poc.a(jSONObject, "url_type", app.url_type);
            poc.a(jSONObject, "url", app.url);
            poc.a(jSONObject, "ios_url", app.ios_url);
            poc.a(jSONObject, "apk_url", app.apk_url);
            poc.a(jSONObject, "apk_name", app.apk_name);
            poc.a(jSONObject, "pos_name", app.pos_name);
            poc.a(jSONObject, "first_name", app.first_name);
            poc.a(jSONObject, "second_name", app.second_name);
            poc.a(jSONObject, "cpid", app.cpid);
            poc.a(jSONObject, "abtest", app.abtest);
            poc.a(jSONObject, "plan_id", app.plan_id);
            poc.a(jSONObject, "user_id", app.user_id);
            poc.a(jSONObject, "price", app.price);
            poc.a(jSONObject, SmsLoginView.f.j, app.verify);
            poc.a(jSONObject, MigrateStatisticUtils.EXT_INFO, app.ext_info);
            if (app.goods_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (GoodsInfo goodsInfo : app.goods_info) {
                    jSONArray.put(oyc.b(goodsInfo));
                }
                poc.a(jSONObject, "goods_info", jSONArray);
            }
            poc.a(jSONObject, "loc_code", app.loc_code);
            poc.a(jSONObject, "deep_url", app.deep_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
