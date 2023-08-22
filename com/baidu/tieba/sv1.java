package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.tieba.lo2;
/* loaded from: classes8.dex */
public interface sv1 {
    boolean a(@Nullable Activity activity);

    void b(@NonNull Context context);

    void c(@NonNull String str);

    void d(CallbackHandler callbackHandler);

    void e(db3 db3Var);

    String f(@NonNull Context context);

    void g(db3 db3Var);

    void h(@NonNull Activity activity, String str, String str2, ko2 ko2Var, lo2.b bVar);
}
