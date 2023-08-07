package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.ClickBackCard;
import tbclient.ClickBackCardItem;
@JvmName(name = "ClickBackCardBuilder")
/* loaded from: classes6.dex */
public final class k45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ClickBackCard a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject != null) {
                ClickBackCard.Builder builder = new ClickBackCard.Builder();
                builder.card_name = jSONObject.optString("card_name");
                JSONArray optJSONArray = jSONObject.optJSONArray("card_list");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        ClickBackCardItem.Builder builder2 = new ClickBackCardItem.Builder();
                        builder2.text = optJSONObject.optString("text");
                        builder2.jump_url = optJSONObject.optString(BigdayActivityConfig.JUMP_URL);
                        builder2.business_id = Long.valueOf(optJSONObject.optLong("business_id"));
                        builder2.business_type = optJSONObject.optString("business_type");
                        ClickBackCardItem build = builder2.build(true);
                        Intrinsics.checkNotNullExpressionValue(build, "builder1.build(true)");
                        arrayList.add(build);
                    }
                    builder.card_list = arrayList;
                }
                return builder.build(true);
            }
            return null;
        }
        return (ClickBackCard) invokeL.objValue;
    }

    public static final ClickBackCard b(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return null;
            }
            return a(new JSONObject(str));
        }
        return (ClickBackCard) invokeL.objValue;
    }
}
