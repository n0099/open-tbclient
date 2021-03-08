package com.bytedance.sdk.adnet.core;

import android.content.Context;
import java.io.File;
/* loaded from: classes6.dex */
public class m {
    public static n hW(Context context) {
        return a(context, (com.bytedance.sdk.adnet.e.a) null);
    }

    public static n a(Context context, com.bytedance.sdk.adnet.e.a aVar) {
        if (aVar == null) {
            aVar = new l();
        }
        return a(context, new c(aVar));
    }

    private static n a(Context context, com.bytedance.sdk.adnet.e.c cVar) {
        n nVar = new n(new h(new File(com.bytedance.sdk.adnet.a.b(context), "reqQueue")), cVar);
        nVar.a();
        return nVar;
    }
}
