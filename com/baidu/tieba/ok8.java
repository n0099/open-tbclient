package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public interface ok8 {
    void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map);

    void d(@NonNull String str, int i);

    void k(@NonNull String str, int i);

    void l(@NonNull String str, @NonNull String str2);

    void m(@NonNull String str, @Nullable Object obj, @Nullable yk8 yk8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i);

    void q(@NonNull AbilityItem abilityItem);
}
