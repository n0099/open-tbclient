package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes5.dex */
public interface ov0 {
    void a(@NonNull nu0 nu0Var);

    void d(@NonNull nu0 nu0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull nu0 nu0Var);

    void k(@NonNull nu0 nu0Var);

    void n(@NonNull nu0 nu0Var);

    void q(@NonNull nu0 nu0Var);
}
