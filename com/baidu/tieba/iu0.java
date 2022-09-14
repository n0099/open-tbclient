package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes4.dex */
public interface iu0 {
    void a(@NonNull ht0 ht0Var);

    void d(@NonNull ht0 ht0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull ht0 ht0Var);

    void k(@NonNull ht0 ht0Var);

    void n(@NonNull ht0 ht0Var);

    void q(@NonNull ht0 ht0Var);
}
