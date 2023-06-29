package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public interface uh8 {
    void b(@NonNull String str, @NonNull String str2, @NonNull Map<String, Object> map);

    void d(@NonNull String str, int i);

    void f(@NonNull String str, @Nullable Object obj, @Nullable nf8 nf8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map, int i);

    void g(@NonNull String str, int i);

    void j(@NonNull String str, @NonNull String str2);

    void l(@NonNull AbilityItem abilityItem);
}
