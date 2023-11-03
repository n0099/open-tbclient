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
public class opc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaUserInfo alaUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "ala_id", alaUserInfo.ala_id);
            poc.a(jSONObject, "user_name", alaUserInfo.user_name);
            poc.a(jSONObject, "portrait", alaUserInfo.portrait);
            poc.a(jSONObject, "description", alaUserInfo.description);
            poc.a(jSONObject, "sex", alaUserInfo.sex);
            poc.a(jSONObject, "enter_live", alaUserInfo.enter_live);
            poc.a(jSONObject, "anchor_live", alaUserInfo.anchor_live);
            poc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfo.live_status);
            poc.a(jSONObject, "live_id", alaUserInfo.live_id);
            poc.a(jSONObject, "location", alaUserInfo.location);
            poc.a(jSONObject, SuggestAddrField.KEY_LNG, alaUserInfo.lng);
            poc.a(jSONObject, SuggestAddrField.KEY_LAT, alaUserInfo.lat);
            poc.a(jSONObject, "update_time", alaUserInfo.update_time);
            poc.a(jSONObject, "charm_count", alaUserInfo.charm_count);
            poc.a(jSONObject, "level_exp", alaUserInfo.level_exp);
            poc.a(jSONObject, "is_official", alaUserInfo.is_official);
            poc.a(jSONObject, "verify_status", alaUserInfo.verify_status);
            poc.a(jSONObject, "level_id", alaUserInfo.level_id);
            poc.a(jSONObject, "great_anchor_icon", alaUserInfo.great_anchor_icon);
            poc.a(jSONObject, "great_anchor_desc_grade", alaUserInfo.great_anchor_desc_grade);
            poc.a(jSONObject, "great_anchor_desc_role", alaUserInfo.great_anchor_desc_role);
            poc.a(jSONObject, "level_name", alaUserInfo.level_name);
            poc.a(jSONObject, "user_id", alaUserInfo.user_id);
            poc.a(jSONObject, "anchor_fans", alaUserInfo.anchor_fans);
            YyExt yyExt = alaUserInfo.yy_ext;
            if (yyExt != null) {
                poc.a(jSONObject, "yy_ext", o6d.b(yyExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
