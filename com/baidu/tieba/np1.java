package com.baidu.tieba;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public interface np1 {
    String a();

    @AnyThread
    void b(@NonNull String str, @NonNull Set<String> set, @NonNull SubscribeHelper.i iVar);

    void c(@NonNull String str, zg2 zg2Var);

    void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, zg2 zg2Var);

    void e(String str, bx2 bx2Var);
}
