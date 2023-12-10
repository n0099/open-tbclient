package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Lbs;
/* loaded from: classes7.dex */
public class p4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Lbs lbs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lbs)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, SuggestAddrField.KEY_LAT, lbs.lat);
            ltc.a(jSONObject, SuggestAddrField.KEY_LNG, lbs.lng);
            ltc.a(jSONObject, "name", lbs.name);
            ltc.a(jSONObject, ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, lbs.sn);
            ltc.a(jSONObject, "distance", lbs.distance);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
