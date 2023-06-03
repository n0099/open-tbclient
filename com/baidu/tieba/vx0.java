package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes8.dex */
public interface vx0 {
    void a(@NonNull uw0 uw0Var);

    void d(@NonNull uw0 uw0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull uw0 uw0Var);

    void k(@NonNull uw0 uw0Var);

    void n(@NonNull uw0 uw0Var);

    void q(@NonNull uw0 uw0Var);
}
