package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.message.UpgradePopWindowMessage;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class np7 extends j65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public np7() {
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

    @Override // com.baidu.tieba.j65
    public void a(@NonNull Context context, @NonNull b65 b65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, b65Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "FRS升级弹窗失败：当前Activity非FrsActivity");
                z55.s("frsUpgrade");
                return;
            }
            UpgradePopWindowMessage upgradePopWindowMessage = new UpgradePopWindowMessage(2001016, ((FrsActivity) context).getPageContext());
            upgradePopWindowMessage.setFromPage("frs");
            MessageManager.getInstance().sendMessage(upgradePopWindowMessage);
        }
    }
}
