package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface vg0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final vg0 b = new ug0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable wg0 wg0Var);

    void b(String str, String str2, yg0 yg0Var);

    String[] c();

    boolean d(Context context, String str);
}
