package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes8.dex */
public interface zx0 {
    void a(@NonNull yw0 yw0Var);

    void d(@NonNull yw0 yw0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull yw0 yw0Var);

    void k(@NonNull yw0 yw0Var);

    void n(@NonNull yw0 yw0Var);

    void q(@NonNull yw0 yw0Var);
}
