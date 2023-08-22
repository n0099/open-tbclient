package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes8.dex */
public interface tx0 {
    void a(@NonNull sw0 sw0Var);

    void d(@NonNull sw0 sw0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull sw0 sw0Var);

    void k(@NonNull sw0 sw0Var);

    void n(@NonNull sw0 sw0Var);

    void q(@NonNull sw0 sw0Var);
}
