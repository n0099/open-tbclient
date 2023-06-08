package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.oo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class to7 extends j65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public to7() {
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
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前Activity非FrsActivity");
                z55.s("frsGroupChatGuide");
                return;
            }
            FrsFragment v1 = ((FrsActivity) context).v1();
            if (v1 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前FrsFragment为空");
                z55.s("frsGroupChatGuide");
                return;
            }
            oo5.b O3 = v1.O3();
            if (O3 == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示群聊引导弹窗失败：当前OptFragment为空");
                z55.s("frsGroupChatGuide");
            } else if (!O3.Y0()) {
                z55.s("frsGroupChatGuide");
            }
        }
    }
}
