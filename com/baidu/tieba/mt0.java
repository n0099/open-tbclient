package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes7.dex */
public interface mt0 {
    void a(@NonNull ms0 ms0Var);

    void d(@NonNull ms0 ms0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull ms0 ms0Var);

    void k(@NonNull ms0 ms0Var);

    void o(@NonNull ms0 ms0Var);

    void r(@NonNull ms0 ms0Var);
}
