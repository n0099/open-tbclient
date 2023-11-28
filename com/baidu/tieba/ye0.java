package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes9.dex */
public interface ye0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ye0 b = new xe0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable ze0 ze0Var);

    void b(String str, String str2, bf0 bf0Var);

    String[] c();

    boolean d(Context context, String str);
}
