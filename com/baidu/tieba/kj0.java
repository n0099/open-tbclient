package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface kj0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final kj0 b = new jj0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable lj0 lj0Var);

    void b(String str, String str2, nj0 nj0Var);

    String[] c();

    boolean d(Context context, String str);
}
