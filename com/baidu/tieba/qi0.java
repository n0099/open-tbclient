package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes5.dex */
public interface qi0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final qi0 b = new pi0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ri0 ri0Var);

    void b(String str, String str2, ti0 ti0Var);

    String[] c();

    boolean d(Context context, String str);
}
