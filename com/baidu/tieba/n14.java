package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes5.dex */
public interface n14 {
    boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull fs3 fs3Var);

    boolean b(Context context, String str, String str2, String str3);

    boolean c();

    String getPackageName();

    void init();
}
