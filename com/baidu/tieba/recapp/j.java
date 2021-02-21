package com.baidu.tieba.recapp;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;
/* loaded from: classes.dex */
public interface j {

    /* loaded from: classes.dex */
    public interface a {
        int c(Context context, String[] strArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        int l(Context context, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface c {
        int b(Context context, String str, String str2, boolean z, d dVar, boolean z2, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    boolean EA(String str);

    void a(Context context, String[] strArr, boolean z, Bundle bundle);

    boolean a(Context context, String[] strArr, Bundle bundle);
}
