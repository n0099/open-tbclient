package com.bytedance.sdk.adnet.core;

import android.content.Context;
import java.io.File;
/* loaded from: classes4.dex */
public class n {
    public static o hU(Context context) {
        return a(context, (com.bytedance.sdk.adnet.e.a) null);
    }

    public static o a(Context context, com.bytedance.sdk.adnet.e.a aVar) {
        if (aVar == null) {
            aVar = new j();
        }
        return a(context, new c(aVar));
    }

    private static o a(Context context, com.bytedance.sdk.adnet.e.c cVar) {
        o oVar = new o(new h(new File(com.bytedance.sdk.adnet.a.b(context), "reqQueue")), cVar);
        oVar.a();
        return oVar;
    }
}
