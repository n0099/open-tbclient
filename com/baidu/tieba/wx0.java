package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes8.dex */
public interface wx0 {
    void a(@NonNull vw0 vw0Var);

    void d(@NonNull vw0 vw0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull vw0 vw0Var);

    void k(@NonNull vw0 vw0Var);

    void n(@NonNull vw0 vw0Var);

    void q(@NonNull vw0 vw0Var);
}
