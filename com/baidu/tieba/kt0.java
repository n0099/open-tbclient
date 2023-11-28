package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes7.dex */
public interface kt0 {
    void a(@NonNull ks0 ks0Var);

    void d(@NonNull ks0 ks0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull ks0 ks0Var);

    void k(@NonNull ks0 ks0Var);

    void o(@NonNull ks0 ks0Var);

    void r(@NonNull ks0 ks0Var);
}
