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
public class vpc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, app)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "type", app.type);
            qoc.a(jSONObject, "pos", app.pos);
            qoc.a(jSONObject, "icon_url", app.icon_url);
            qoc.a(jSONObject, "icon_link", app.icon_link);
            qoc.a(jSONObject, "app_name", app.app_name);
            qoc.a(jSONObject, "app_desc", app.app_desc);
            qoc.a(jSONObject, "p_name", app.p_name);
            qoc.a(jSONObject, "p_url", app.p_url);
            qoc.a(jSONObject, BigdayActivityConfig.IMG_URL, app.img_url);
            qoc.a(jSONObject, "app_time", app.app_time);
            qoc.a(jSONObject, "web_url", app.web_url);
            qoc.a(jSONObject, LegoListActivityConfig.AD_ID, app.ad_id);
            qoc.a(jSONObject, "id", app.id);
            qoc.a(jSONObject, "name", app.name);
            qoc.a(jSONObject, "url_type", app.url_type);
            qoc.a(jSONObject, "url", app.url);
            qoc.a(jSONObject, "ios_url", app.ios_url);
            qoc.a(jSONObject, "apk_url", app.apk_url);
            qoc.a(jSONObject, "apk_name", app.apk_name);
            qoc.a(jSONObject, "pos_name", app.pos_name);
            qoc.a(jSONObject, "first_name", app.first_name);
            qoc.a(jSONObject, "second_name", app.second_name);
            qoc.a(jSONObject, "cpid", app.cpid);
            qoc.a(jSONObject, "abtest", app.abtest);
            qoc.a(jSONObject, "plan_id", app.plan_id);
            qoc.a(jSONObject, "user_id", app.user_id);
            qoc.a(jSONObject, "price", app.price);
            qoc.a(jSONObject, SmsLoginView.f.j, app.verify);
            qoc.a(jSONObject, MigrateStatisticUtils.EXT_INFO, app.ext_info);
            if (app.goods_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (GoodsInfo goodsInfo : app.goods_info) {
                    jSONArray.put(pyc.b(goodsInfo));
                }
                qoc.a(jSONObject, "goods_info", jSONArray);
            }
            qoc.a(jSONObject, "loc_code", app.loc_code);
            qoc.a(jSONObject, "deep_url", app.deep_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
