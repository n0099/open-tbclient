package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface ww0 {
    void a(@NonNull vv0 vv0Var);

    void d(@NonNull vv0 vv0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull vv0 vv0Var);

    void k(@NonNull vv0 vv0Var);

    void n(@NonNull vv0 vv0Var);

    void q(@NonNull vv0 vv0Var);
}
