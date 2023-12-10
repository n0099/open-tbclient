package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.live.interfaces.service.bd.IFavorStateServiceKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AlaUserInfo;
import tbclient.YyExt;
/* loaded from: classes7.dex */
public class muc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaUserInfo alaUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "ala_id", alaUserInfo.ala_id);
            ltc.a(jSONObject, "user_name", alaUserInfo.user_name);
            ltc.a(jSONObject, "portrait", alaUserInfo.portrait);
            ltc.a(jSONObject, "description", alaUserInfo.description);
            ltc.a(jSONObject, "sex", alaUserInfo.sex);
            ltc.a(jSONObject, "enter_live", alaUserInfo.enter_live);
            ltc.a(jSONObject, "anchor_live", alaUserInfo.anchor_live);
            ltc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfo.live_status);
            ltc.a(jSONObject, "live_id", alaUserInfo.live_id);
            ltc.a(jSONObject, "location", alaUserInfo.location);
            ltc.a(jSONObject, SuggestAddrField.KEY_LNG, alaUserInfo.lng);
            ltc.a(jSONObject, SuggestAddrField.KEY_LAT, alaUserInfo.lat);
            ltc.a(jSONObject, "update_time", alaUserInfo.update_time);
            ltc.a(jSONObject, "charm_count", alaUserInfo.charm_count);
            ltc.a(jSONObject, "level_exp", alaUserInfo.level_exp);
            ltc.a(jSONObject, "is_official", alaUserInfo.is_official);
            ltc.a(jSONObject, "verify_status", alaUserInfo.verify_status);
            ltc.a(jSONObject, "level_id", alaUserInfo.level_id);
            ltc.a(jSONObject, "great_anchor_icon", alaUserInfo.great_anchor_icon);
            ltc.a(jSONObject, "great_anchor_desc_grade", alaUserInfo.great_anchor_desc_grade);
            ltc.a(jSONObject, "great_anchor_desc_role", alaUserInfo.great_anchor_desc_role);
            ltc.a(jSONObject, "level_name", alaUserInfo.level_name);
            ltc.a(jSONObject, "user_id", alaUserInfo.user_id);
            ltc.a(jSONObject, "anchor_fans", alaUserInfo.anchor_fans);
            YyExt yyExt = alaUserInfo.yy_ext;
            if (yyExt != null) {
                ltc.a(jSONObject, "yy_ext", tbd.b(yyExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
