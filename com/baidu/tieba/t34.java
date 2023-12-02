package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes8.dex */
public interface t34 {
    boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull lu3 lu3Var);

    boolean b(Context context, String str, String str2, String str3);

    boolean c();

    String getPackageName();

    void init();
}
