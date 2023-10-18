package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes8.dex */
public interface ss0 {
    void a(@NonNull sr0 sr0Var);

    void d(@NonNull sr0 sr0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull sr0 sr0Var);

    void k(@NonNull sr0 sr0Var);

    void n(@NonNull sr0 sr0Var);

    void q(@NonNull sr0 sr0Var);
}
