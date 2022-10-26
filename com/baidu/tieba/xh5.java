package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class xh5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(int i, IntentConfig intentConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65536, null, i, intentConfig) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(i, intentConfig));
        }
    }

    public static final void b(IntentConfig intentConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, intentConfig) == null) {
            a(2002001, intentConfig);
        }
    }
}
