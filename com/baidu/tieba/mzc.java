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
public class mzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Lbs lbs) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lbs)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, SuggestAddrField.KEY_LAT, lbs.lat);
            qoc.a(jSONObject, SuggestAddrField.KEY_LNG, lbs.lng);
            qoc.a(jSONObject, "name", lbs.name);
            qoc.a(jSONObject, ComboPraiseManager.PRAISE_SOURCE_PREFIX_HN_SN, lbs.sn);
            qoc.a(jSONObject, "distance", lbs.distance);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
