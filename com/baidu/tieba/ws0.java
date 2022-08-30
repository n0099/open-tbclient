package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface ws0 {
    void a(@NonNull vr0 vr0Var);

    void d(@NonNull vr0 vr0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull vr0 vr0Var);

    void k(@NonNull vr0 vr0Var);

    void n(@NonNull vr0 vr0Var);

    void q(@NonNull vr0 vr0Var);
}
