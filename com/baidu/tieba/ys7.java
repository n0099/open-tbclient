package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ys7 extends x55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ys7() {
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

    @Override // com.baidu.tieba.x55
    public void a(@NonNull Context context, @NonNull p55 p55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, p55Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧主弹窗失败：当前Activity非FrsActivity");
                YunDialogManager.unMarkShowingDialogName("frsGuide");
                return;
            }
            FrsFragment u1 = ((FrsActivity) context).u1();
            if (u1 == null) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧主弹窗失败：当前FrsFragment为空");
                YunDialogManager.unMarkShowingDialogName("frsGuide");
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921476));
            u1.j5(true);
        }
    }
}
