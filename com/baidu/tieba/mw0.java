package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes6.dex */
public interface mw0 {
    void a(@NonNull lv0 lv0Var);

    void d(@NonNull lv0 lv0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull lv0 lv0Var);

    void k(@NonNull lv0 lv0Var);

    void n(@NonNull lv0 lv0Var);

    void q(@NonNull lv0 lv0Var);
}
