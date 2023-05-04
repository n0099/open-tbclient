package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes7.dex */
public interface wv0 {
    void a(@NonNull vu0 vu0Var);

    void d(@NonNull vu0 vu0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull vu0 vu0Var);

    void k(@NonNull vu0 vu0Var);

    void n(@NonNull vu0 vu0Var);

    void q(@NonNull vu0 vu0Var);
}
