package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes7.dex */
public interface qx0 {
    void a(@NonNull pw0 pw0Var);

    void d(@NonNull pw0 pw0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull pw0 pw0Var);

    void k(@NonNull pw0 pw0Var);

    void n(@NonNull pw0 pw0Var);

    void q(@NonNull pw0 pw0Var);
}
