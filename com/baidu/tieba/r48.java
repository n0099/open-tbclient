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
public class r48 extends j15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public r48() {
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

    @Override // com.baidu.tieba.j15
    public void a(@NonNull Context context, @NonNull x05 x05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, x05Var) == null) {
            if (context instanceof f25) {
                f25 f25Var = (f25) context;
                if (f25Var.i1() != null) {
                    e25 i1 = f25Var.i1();
                    if (i1.W() == null) {
                        YunDialogLog.getInstance().e(YunDialogManager.LOG_KEY, "展示吧内屏蔽弹窗失败：当前没有FRS吧数据");
                        YunDialogManager.unMarkShowingDialogName("frsShield");
                        return;
                    } else if (!b68.d(i1)) {
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
