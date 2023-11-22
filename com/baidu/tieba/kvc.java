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
/* loaded from: classes7.dex */
public class kvc extends qoc {
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
                qoc.a(jSONObject, "frs_activity", ttc.b(frsBottomActivityBase));
            }
            FrsBottomChatroomBase frsBottomChatroomBase = frsBottom.frs_chatroom;
            if (frsBottomChatroomBase != null) {
                qoc.a(jSONObject, "frs_chatroom", wtc.b(frsBottomChatroomBase));
            }
            FrsBottomSmartBgColor frsBottomSmartBgColor = frsBottom.frs_smart_bg_color;
            if (frsBottomSmartBgColor != null) {
                qoc.a(jSONObject, "frs_smart_bg_color", xtc.b(frsBottomSmartBgColor));
            }
            qoc.a(jSONObject, "has_more_module", frsBottom.has_more_module);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
