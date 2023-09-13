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
/* loaded from: classes7.dex */
public final class pu7 extends e65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pu7() {
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
    public void a(Context context, v55 data) {
        hw7 a0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, data) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧务管理弹窗失败：当前Activity非FrsActivity");
                YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
                return;
            }
            FrsActivity frsActivity = (FrsActivity) context;
            if (frsActivity.x1() != null && frsActivity.x1().a0() != null) {
                wp7 x1 = frsActivity.x1();
                if (x1 != null && (a0 = x1.a0()) != null) {
                    a0.i();
                    return;
                }
                return;
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧务管理弹窗失败：tabController或guideHelper为空");
            YunDialogManager.unMarkShowingDialogName("frsNewUserGuide");
        }
    }
}
