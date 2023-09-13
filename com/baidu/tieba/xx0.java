package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes8.dex */
public interface xx0 {
    void a(@NonNull ww0 ww0Var);

    void d(@NonNull ww0 ww0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull ww0 ww0Var);

    void k(@NonNull ww0 ww0Var);

    void n(@NonNull ww0 ww0Var);

    void q(@NonNull ww0 ww0Var);
}
