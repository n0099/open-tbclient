package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface si0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final si0 b = new ri0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ti0 ti0Var);

    void b(String str, String str2, vi0 vi0Var);

    String[] c();

    boolean d(Context context, String str);
}
