package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface jt0 {
    void a(@NonNull js0 js0Var);

    void d(@NonNull js0 js0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void k(@NonNull js0 js0Var);

    void l(@NonNull js0 js0Var);

    void o(@NonNull js0 js0Var);

    void r(@NonNull js0 js0Var);
}
