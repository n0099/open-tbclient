package com.baidu.tieba;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes5.dex */
public interface ri0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");
    public static final ri0 b = new qi0();

    boolean a(Context context, String str, Map map, si0 si0Var);

    void b(String str, String str2, ui0 ui0Var);

    String[] c();

    boolean d(Context context, String str);
}
