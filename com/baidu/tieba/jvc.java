package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsBottomActivityBase;
import tbclient.FrsBottomChatroomBase;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.FrsBottom;
/* loaded from: classes6.dex */
public class jvc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsBottom frsBottom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsBottom)) == null) {
            JSONObject jSONObject = new JSONObject();
            FrsBottomActivityBase frsBottomActivityBase = frsBottom.frs_activity;
            if (frsBottomActivityBase != null) {
                poc.a(jSONObject, "frs_activity", stc.b(frsBottomActivityBase));
            }
            FrsBottomChatroomBase frsBottomChatroomBase = frsBottom.frs_chatroom;
            if (frsBottomChatroomBase != null) {
                poc.a(jSONObject, "frs_chatroom", vtc.b(frsBottomChatroomBase));
            }
            FrsBottomSmartBgColor frsBottomSmartBgColor = frsBottom.frs_smart_bg_color;
            if (frsBottomSmartBgColor != null) {
                poc.a(jSONObject, "frs_smart_bg_color", wtc.b(frsBottomSmartBgColor));
            }
            poc.a(jSONObject, "has_more_module", frsBottom.has_more_module);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
