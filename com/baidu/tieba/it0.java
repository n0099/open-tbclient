package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class it0 extends mt0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public it0() {
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

    @Override // com.baidu.tieba.mt0, com.baidu.tieba.kt0, com.baidu.tieba.lt0, com.baidu.tieba.ht0
    public void k(@NonNull mu0 mu0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mu0Var) == null) {
            super.k(mu0Var);
            if (PlayerEvent.ACTION_PLAYER_ATTACH.equals(mu0Var.c())) {
                if (q().n1().g()) {
                    i = 0;
                } else {
                    i = 8;
                }
                K(i);
            }
        }
    }
}
