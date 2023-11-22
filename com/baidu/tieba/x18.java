package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class x18 extends g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public x18() {
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

    @Override // com.baidu.tieba.g15
    public void a(Context context, u05 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (context instanceof c25) {
                c25 c25Var = (c25) context;
                if (c25Var.j1() != null) {
                    b25 j1 = c25Var.j1();
                    if (context instanceof FrsActivity) {
                        FrsActivity frsActivity = (FrsActivity) context;
                        if (frsActivity.q1() == null || frsActivity.q1().Z() == null) {
                            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示新用户引导弹窗失败：tabController或guideHelper为空");
                            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                            return;
                        }
                    }
                    j1.o0();
                    return;
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示新用户引导弹窗失败：获取到的IForumDialogExtSupport为空");
            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
        }
    }
}
