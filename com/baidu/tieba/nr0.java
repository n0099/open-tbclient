package com.baidu.tieba;

import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nr0 extends sr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sr0 x(PlayerStatus playerStatus, PlayerStatus playerStatus2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, playerStatus, playerStatus2)) == null) {
            sr0 n = sr0.n(StateEvent.ACTION_STATE_CHANGED, 5);
            n.o(1, playerStatus);
            n.o(2, playerStatus2);
            return n;
        }
        return (sr0) invokeLL.objValue;
    }
}
