package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface vu0 {
    void a(@NonNull ut0 ut0Var);

    void d(@NonNull ut0 ut0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull ut0 ut0Var);

    void k(@NonNull ut0 ut0Var);

    void n(@NonNull ut0 ut0Var);

    void q(@NonNull ut0 ut0Var);
}
