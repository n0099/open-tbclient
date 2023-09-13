package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(TbPageContext<?> tbPageContext, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, view2)) == null) {
            boolean z = false;
            if (tbPageContext == null || view2 == null) {
                return false;
            }
            BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
            if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                z = true;
            }
            layoutMode.setNightMode(z);
            tbPageContext.getLayoutMode().onModeChanged(view2);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
