package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
/* loaded from: classes8.dex */
public interface zw9 {

    /* loaded from: classes8.dex */
    public interface a {
        int a(Context context, String[] strArr);
    }

    /* loaded from: classes8.dex */
    public interface b {
        int a(Context context, Map<String, String> map);
    }

    /* loaded from: classes8.dex */
    public interface c {
        int a(Context context, String str, String str2, boolean z, d dVar, boolean z2, Bundle bundle);
    }

    /* loaded from: classes8.dex */
    public interface d {
    }

    boolean a(String str);

    void b(Context context, String[] strArr, boolean z, Bundle bundle);

    boolean c(Context context, String[] strArr, Bundle bundle);
}
