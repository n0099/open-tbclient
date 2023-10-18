package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable MsgProcessor.e eVar, @NonNull TbSysMsg tbSysMsg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, eVar, tbSysMsg) == null) && eVar != null) {
            eVar.a(tbSysMsg);
        }
    }
}
