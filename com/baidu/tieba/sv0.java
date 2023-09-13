package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class sv0 extends wv0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sv0() {
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

    @Override // com.baidu.tieba.wv0, com.baidu.tieba.uv0, com.baidu.tieba.vv0, com.baidu.tieba.rv0
    public void k(@NonNull ww0 ww0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ww0Var) == null) {
            super.k(ww0Var);
            if (PlayerEvent.ACTION_PLAYER_ATTACH.equals(ww0Var.c())) {
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
