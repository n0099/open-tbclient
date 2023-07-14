package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yt7 extends w65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public yt7() {
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

    @Override // com.baidu.tieba.w65
    public void a(@NonNull Context context, @NonNull o65 o65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, o65Var) == null) {
            if (TbSingleton.getInstance().getFrsResponseData() == null) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示吧务管理弹窗失败：当前没有FRS吧数据");
                m65.u("frsForumManage");
            } else if (!(context instanceof FrsActivity)) {
                YunDialogLog.getInstance().b("YunDialogManager", "展示吧务管理弹窗失败：当前Activity非FrsActivity");
                m65.u("frsForumManage");
            } else {
                FrsFragment v1 = ((FrsActivity) context).v1();
                if (!nv7.a(TbSingleton.getInstance().getFrsResponseData(), v1)) {
                    v1.U4(true);
                    m65.u("frsForumManage");
                }
            }
        }
    }
}
