package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends IntentConfig> void a(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65536, null, i, t) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(i, t));
        }
    }

    public static final <T extends IntentConfig> void b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, t) == null) {
            a(2002001, t);
        }
    }
}
