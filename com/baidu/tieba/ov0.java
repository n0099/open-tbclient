package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ov0 extends sv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ov0() {
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

    @Override // com.baidu.tieba.sv0, com.baidu.tieba.qv0, com.baidu.tieba.rv0, com.baidu.tieba.nv0
    public void k(@NonNull sw0 sw0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sw0Var) == null) {
            super.k(sw0Var);
            if (PlayerEvent.ACTION_PLAYER_ATTACH.equals(sw0Var.c())) {
                if (q().n1().g()) {
                    i = 0;
                } else {
                    i = 8;
                }
                L(i);
            }
        }
    }
}
