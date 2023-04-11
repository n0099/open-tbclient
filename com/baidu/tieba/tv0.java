package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface tv0 {
    void a(@NonNull su0 su0Var);

    void d(@NonNull su0 su0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull su0 su0Var);

    void k(@NonNull su0 su0Var);

    void n(@NonNull su0 su0Var);

    void q(@NonNull su0 su0Var);
}
