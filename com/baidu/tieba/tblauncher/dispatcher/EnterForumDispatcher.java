package com.baidu.tieba.tblauncher.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tieba.gi9;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EnterForumDispatcher implements gi9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String url = "com.baidu.tieba://unidispatch/enterforum";
    public transient /* synthetic */ FieldHolder $fh;

    public EnterForumDispatcher() {
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

    @Override // com.baidu.tieba.gi9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            Intent intent = new Intent();
            intent.setClass(context, MainTabActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("locate_type", 1);
            intent.putExtra(MainTabActivityConfig.IS_NEW_USER, false);
            intent.putExtra("close_dialog", true);
            intent.putExtra(MainTabActivityConfig.NEED_CLOSE_MENU, false);
            String optString = jSONObject.optString("tabName");
            if (!StringUtils.isNull(optString)) {
                intent.putExtra("sub_locate_type", optString);
            }
            context.startActivity(intent);
        }
    }
}
