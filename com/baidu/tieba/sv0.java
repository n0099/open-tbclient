package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface sv0 {
    void a(@NonNull ru0 ru0Var);

    void d(@NonNull ru0 ru0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull ru0 ru0Var);

    void k(@NonNull ru0 ru0Var);

    void n(@NonNull ru0 ru0Var);

    void q(@NonNull ru0 ru0Var);
}
