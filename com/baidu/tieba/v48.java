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
public class v48 extends m15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v48() {
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

    @Override // com.baidu.tieba.m15
    public void a(@NonNull Context context, @NonNull a15 a15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, a15Var) == null) {
            if (context instanceof i25) {
                i25 i25Var = (i25) context;
                if (i25Var.i1() != null) {
                    h25 i1 = i25Var.i1();
                    if (i1.W() == null) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧内屏蔽弹窗失败：当前没有FRS吧数据");
                        YunDialogManager.unMarkShowingDialogName("frsShield");
                        return;
                    } else if (!f68.d(i1)) {
                        i1.S1(true);
                        YunDialogManager.unMarkShowingDialogName("frsShield");
                        return;
                    } else {
                        return;
                    }
                }
            }
            YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧内屏蔽弹窗失败：获取到的IForumDialogExtSupport为空");
            YunDialogManager.unMarkShowingDialogName("frsShield");
        }
    }
}
