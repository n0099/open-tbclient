package com.baidu.tieba.recapp;

import android.content.Context;
import java.util.Map;
/* loaded from: classes.dex */
public interface i {

    /* loaded from: classes.dex */
    public interface a {
        int c(Context context, String[] strArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        int d(Context context, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface c {
        int b(Context context, String str, String str2, boolean z, d dVar, boolean z2);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    void a(Context context, String[] strArr, boolean z);

    boolean b(Context context, String[] strArr);

    boolean hM(String str);
}
