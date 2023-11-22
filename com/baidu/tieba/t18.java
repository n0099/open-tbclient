package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class t18 extends g15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public t18() {
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
    public void a(@NonNull Context context, @NonNull u05 u05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, u05Var) == null) {
            if (context instanceof c25) {
                c25 c25Var = (c25) context;
                if (c25Var.j1() != null) {
                    b25 j1 = c25Var.j1();
                    if (j1.U() == null) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧务管理弹窗失败：当前没有FRS吧数据");
                        YunDialogManager.unMarkShowingDialogName("frsForumManage");
                        return;
                    } else if (!j38.a(j1, context)) {
                        j1.G1(true);
                        YunDialogManager.unMarkShowingDialogName("frsForumManage");
                        return;
                    } else {
                        return;
                    }
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧务管理弹窗失败：获取到的IForumDialogExtSupport为空");
            YunDialogManager.unMarkShowingDialogName("frsForumManage");
        }
    }
}
