package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.GiftInfo;
/* loaded from: classes7.dex */
public class myc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull GiftInfo giftInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, giftInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", giftInfo.icon);
            qoc.a(jSONObject, "num", giftInfo.num);
            qoc.a(jSONObject, "gift_id", giftInfo.gift_id);
            qoc.a(jSONObject, "gift_name", giftInfo.gift_name);
            qoc.a(jSONObject, "large_thumbnail_url", giftInfo.large_thumbnail_url);
            qoc.a(jSONObject, "sender_id", giftInfo.sender_id);
            qoc.a(jSONObject, "sender_name", giftInfo.sender_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
