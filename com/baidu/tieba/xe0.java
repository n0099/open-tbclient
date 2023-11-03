package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes9.dex */
public interface xe0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final xe0 b = new we0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ye0 ye0Var);

    void b(String str, String str2, af0 af0Var);

    String[] c();

    boolean d(Context context, String str);
}
