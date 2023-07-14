package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.constants.PlayerStatus;
/* loaded from: classes7.dex */
public interface ny0 {
    void a(@NonNull mx0 mx0Var);

    void d(@NonNull mx0 mx0Var);

    int getExpectOrder();

    @Nullable
    int[] getSubscribeEvent();

    int getType();

    void h(PlayerStatus playerStatus, PlayerStatus playerStatus2);

    void j(@NonNull mx0 mx0Var);

    void k(@NonNull mx0 mx0Var);

    void n(@NonNull mx0 mx0Var);

    void q(@NonNull mx0 mx0Var);
}
