package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes5.dex */
public interface nv0 {
    void a(@NonNull mu0 mu0Var);

    void d(@NonNull mu0 mu0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull mu0 mu0Var);

    void k(@NonNull mu0 mu0Var);

    void n(@NonNull mu0 mu0Var);

    void q(@NonNull mu0 mu0Var);
}
