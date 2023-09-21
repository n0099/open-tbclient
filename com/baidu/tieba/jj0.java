package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes6.dex */
public interface jj0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final jj0 b = new ij0();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable kj0 kj0Var);

    void b(String str, String str2, mj0 mj0Var);

    String[] c();

    boolean d(Context context, String str);
}
