package com.baidu.tieba;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes6.dex */
public interface to1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, fg2 fg2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, fg2 fg2Var);

    void e(String str, hw2 hw2Var);
}
