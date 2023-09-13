package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k65 extends e65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k65() {
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

    @Override // com.baidu.tieba.e65
    public void a(@NonNull Context context, @NonNull v55 v55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, v55Var) == null) {
            TbWebViewActivityConfig activityConfig = BrowserHelper.getActivityConfig(context, "", "https://tieba.baidu.com/mo/q/hybrid/popups?page=god-invite", false, true, true);
            activityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            activityConfig.setWebDialogName("newGod");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, activityConfig));
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_new_god_pop_is_show"), false);
            YunDialogManager.markShowingDialogName("newGod");
        }
    }
}
