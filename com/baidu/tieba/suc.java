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
public class suc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, app)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", app.type);
            ltc.a(jSONObject, "pos", app.pos);
            ltc.a(jSONObject, "icon_url", app.icon_url);
            ltc.a(jSONObject, "icon_link", app.icon_link);
            ltc.a(jSONObject, "app_name", app.app_name);
            ltc.a(jSONObject, "app_desc", app.app_desc);
            ltc.a(jSONObject, "p_name", app.p_name);
            ltc.a(jSONObject, "p_url", app.p_url);
            ltc.a(jSONObject, BigdayActivityConfig.IMG_URL, app.img_url);
            ltc.a(jSONObject, "app_time", app.app_time);
            ltc.a(jSONObject, "web_url", app.web_url);
            ltc.a(jSONObject, LegoListActivityConfig.AD_ID, app.ad_id);
            ltc.a(jSONObject, "id", app.id);
            ltc.a(jSONObject, "name", app.name);
            ltc.a(jSONObject, "url_type", app.url_type);
            ltc.a(jSONObject, "url", app.url);
            ltc.a(jSONObject, "ios_url", app.ios_url);
            ltc.a(jSONObject, "apk_url", app.apk_url);
            ltc.a(jSONObject, "apk_name", app.apk_name);
            ltc.a(jSONObject, "pos_name", app.pos_name);
            ltc.a(jSONObject, "first_name", app.first_name);
            ltc.a(jSONObject, "second_name", app.second_name);
            ltc.a(jSONObject, "cpid", app.cpid);
            ltc.a(jSONObject, "abtest", app.abtest);
            ltc.a(jSONObject, "plan_id", app.plan_id);
            ltc.a(jSONObject, "user_id", app.user_id);
            ltc.a(jSONObject, "price", app.price);
            ltc.a(jSONObject, SmsLoginView.f.j, app.verify);
            ltc.a(jSONObject, MigrateStatisticUtils.EXT_INFO, app.ext_info);
            if (app.goods_info != null) {
                JSONArray jSONArray = new JSONArray();
                for (GoodsInfo goodsInfo : app.goods_info) {
                    jSONArray.put(s3d.b(goodsInfo));
                }
                ltc.a(jSONObject, "goods_info", jSONArray);
            }
            ltc.a(jSONObject, "loc_code", app.loc_code);
            ltc.a(jSONObject, "deep_url", app.deep_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
