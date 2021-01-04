package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.a;

import android.content.Context;
import android.os.Build;
/* loaded from: classes11.dex */
public final class f {
    public static d a(Context context, e eVar) {
        d cVar;
        int i = Build.VERSION.SDK_INT;
        if (i < 5) {
            cVar = new a(context);
        } else if (i < 8) {
            cVar = new b(context);
        } else {
            cVar = new c(context);
        }
        cVar.a(eVar);
        return cVar;
    }
}
