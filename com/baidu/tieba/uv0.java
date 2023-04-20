package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface uv0 {
    void a(@NonNull tu0 tu0Var);

    void d(@NonNull tu0 tu0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull tu0 tu0Var);

    void k(@NonNull tu0 tu0Var);

    void n(@NonNull tu0 tu0Var);

    void q(@NonNull tu0 tu0Var);
}
