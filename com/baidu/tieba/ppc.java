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
public class ppc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaUserInfo alaUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "ala_id", alaUserInfo.ala_id);
            qoc.a(jSONObject, "user_name", alaUserInfo.user_name);
            qoc.a(jSONObject, "portrait", alaUserInfo.portrait);
            qoc.a(jSONObject, "description", alaUserInfo.description);
            qoc.a(jSONObject, "sex", alaUserInfo.sex);
            qoc.a(jSONObject, "enter_live", alaUserInfo.enter_live);
            qoc.a(jSONObject, "anchor_live", alaUserInfo.anchor_live);
            qoc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfo.live_status);
            qoc.a(jSONObject, "live_id", alaUserInfo.live_id);
            qoc.a(jSONObject, "location", alaUserInfo.location);
            qoc.a(jSONObject, SuggestAddrField.KEY_LNG, alaUserInfo.lng);
            qoc.a(jSONObject, SuggestAddrField.KEY_LAT, alaUserInfo.lat);
            qoc.a(jSONObject, "update_time", alaUserInfo.update_time);
            qoc.a(jSONObject, "charm_count", alaUserInfo.charm_count);
            qoc.a(jSONObject, "level_exp", alaUserInfo.level_exp);
            qoc.a(jSONObject, "is_official", alaUserInfo.is_official);
            qoc.a(jSONObject, "verify_status", alaUserInfo.verify_status);
            qoc.a(jSONObject, "level_id", alaUserInfo.level_id);
            qoc.a(jSONObject, "great_anchor_icon", alaUserInfo.great_anchor_icon);
            qoc.a(jSONObject, "great_anchor_desc_grade", alaUserInfo.great_anchor_desc_grade);
            qoc.a(jSONObject, "great_anchor_desc_role", alaUserInfo.great_anchor_desc_role);
            qoc.a(jSONObject, "level_name", alaUserInfo.level_name);
            qoc.a(jSONObject, "user_id", alaUserInfo.user_id);
            qoc.a(jSONObject, "anchor_fans", alaUserInfo.anchor_fans);
            YyExt yyExt = alaUserInfo.yy_ext;
            if (yyExt != null) {
                qoc.a(jSONObject, "yy_ext", p6d.b(yyExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
