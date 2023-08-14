package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.go5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class zq7 extends r55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zq7() {
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

    @Override // com.baidu.tieba.r55
    public void a(@NonNull Context context, @NonNull j55 j55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, j55Var) == null) {
            if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示群聊引导弹窗失败：当前Activity非FrsActivity");
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
                return;
            }
            FrsFragment u1 = ((FrsActivity) context).u1();
            if (u1 == null) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示群聊引导弹窗失败：当前FrsFragment为空");
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
                return;
            }
            go5.b S3 = u1.S3();
            if (S3 == null) {
                YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示群聊引导弹窗失败：当前OptFragment为空");
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
            } else if (!S3.Z0()) {
                u1.X4(true);
                YunDialogManager.unMarkShowingDialogName("frsGroupChatGuide");
            }
        }
    }
}
