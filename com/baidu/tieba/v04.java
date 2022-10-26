package com.baidu.tieba;

import android.content.Context;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
/* loaded from: classes6.dex */
public interface v04 {
    boolean a(Context context, SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, nr3 nr3Var);

    boolean b(Context context, String str, String str2, String str3);

    boolean c();

    String getPackageName();

    void init();
}
