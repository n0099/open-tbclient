package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface vi0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final vi0 b = new ui0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable wi0 wi0Var);

    void b(String str, String str2, yi0 yi0Var);

    String[] c();

    boolean d(Context context, String str);
}
