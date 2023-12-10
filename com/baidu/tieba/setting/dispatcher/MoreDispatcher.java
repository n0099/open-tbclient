package com.baidu.tieba.setting.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tieba.pma;
import com.baidu.tieba.setting.more.MoreActivity;
import com.baidu.tieba.setting.more.MsgRemindActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class MoreDispatcher implements pma {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String JUMP_TO_PAGE = "toPage";
    public static final String PAGE_SETTING_NOTIFACTION = "notification";
    public transient /* synthetic */ FieldHolder $fh;

    public MoreDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.pma
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString(JUMP_TO_PAGE);
            char c = 65535;
            if (optString.hashCode() == 595233003 && optString.equals("notification")) {
                c = 0;
            }
            if (c != 0) {
                context.startActivity(new Intent(context, MoreActivity.class));
            } else {
                context.startActivity(new Intent(context, MsgRemindActivity.class));
            }
        }
    }
}
