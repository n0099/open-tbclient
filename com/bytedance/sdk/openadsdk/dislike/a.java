package com.bytedance.sdk.openadsdk.dislike;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.List;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4680a;
    private final q<com.bytedance.sdk.openadsdk.c.a> b = p.f();

    private a() {
    }

    public static a a() {
        if (f4680a == null) {
            synchronized (a.class) {
                if (f4680a == null) {
                    f4680a = new a();
                }
            }
        }
        return f4680a;
    }

    public void a(@NonNull l lVar, List<FilterWord> list) {
        this.b.a(lVar, list);
    }
}
