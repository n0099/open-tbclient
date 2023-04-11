package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes7.dex */
public interface zh0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final zh0 b = new yh0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ai0 ai0Var);

    void b(String str, String str2, ci0 ci0Var);

    String[] c();

    boolean d(Context context, String str);
}
