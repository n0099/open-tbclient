package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ir0 extends mr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ir0() {
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

    @Override // com.baidu.tieba.mr0, com.baidu.tieba.kr0, com.baidu.tieba.lr0, com.baidu.tieba.hr0
    public void l(@NonNull ms0 ms0Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ms0Var) == null) {
            super.l(ms0Var);
            if (PlayerEvent.ACTION_PLAYER_ATTACH.equals(ms0Var.c())) {
                if (s().i1().g()) {
                    i = 0;
                } else {
                    i = 8;
                }
                N(i);
            }
        }
    }
}
