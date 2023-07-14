package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class iw0 extends mw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public iw0() {
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

    @Override // com.baidu.tieba.mw0, com.baidu.tieba.kw0, com.baidu.tieba.lw0, com.baidu.tieba.hw0
    public void k(@NonNull mx0 mx0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mx0Var) == null) {
            super.k(mx0Var);
            if (PlayerEvent.ACTION_PLAYER_ATTACH.equals(mx0Var.c())) {
                if (q().n1().g()) {
                    i = 0;
                } else {
                    i = 8;
                }
                M(i);
            }
        }
    }
}
