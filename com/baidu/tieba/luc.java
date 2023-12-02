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
public class luc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AlaUserInfo alaUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "ala_id", alaUserInfo.ala_id);
            ktc.a(jSONObject, "user_name", alaUserInfo.user_name);
            ktc.a(jSONObject, "portrait", alaUserInfo.portrait);
            ktc.a(jSONObject, "description", alaUserInfo.description);
            ktc.a(jSONObject, "sex", alaUserInfo.sex);
            ktc.a(jSONObject, "enter_live", alaUserInfo.enter_live);
            ktc.a(jSONObject, "anchor_live", alaUserInfo.anchor_live);
            ktc.a(jSONObject, IFavorStateServiceKt.KEY_FAVOR_LIVE_STATUS, alaUserInfo.live_status);
            ktc.a(jSONObject, "live_id", alaUserInfo.live_id);
            ktc.a(jSONObject, "location", alaUserInfo.location);
            ktc.a(jSONObject, SuggestAddrField.KEY_LNG, alaUserInfo.lng);
            ktc.a(jSONObject, SuggestAddrField.KEY_LAT, alaUserInfo.lat);
            ktc.a(jSONObject, "update_time", alaUserInfo.update_time);
            ktc.a(jSONObject, "charm_count", alaUserInfo.charm_count);
            ktc.a(jSONObject, "level_exp", alaUserInfo.level_exp);
            ktc.a(jSONObject, "is_official", alaUserInfo.is_official);
            ktc.a(jSONObject, "verify_status", alaUserInfo.verify_status);
            ktc.a(jSONObject, "level_id", alaUserInfo.level_id);
            ktc.a(jSONObject, "great_anchor_icon", alaUserInfo.great_anchor_icon);
            ktc.a(jSONObject, "great_anchor_desc_grade", alaUserInfo.great_anchor_desc_grade);
            ktc.a(jSONObject, "great_anchor_desc_role", alaUserInfo.great_anchor_desc_role);
            ktc.a(jSONObject, "level_name", alaUserInfo.level_name);
            ktc.a(jSONObject, "user_id", alaUserInfo.user_id);
            ktc.a(jSONObject, "anchor_fans", alaUserInfo.anchor_fans);
            YyExt yyExt = alaUserInfo.yy_ext;
            if (yyExt != null) {
                ktc.a(jSONObject, "yy_ext", sbd.b(yyExt));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
