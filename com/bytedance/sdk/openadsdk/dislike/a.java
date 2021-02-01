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
    private static volatile a f7033a;

    /* renamed from: b  reason: collision with root package name */
    private final q<com.bytedance.sdk.openadsdk.c.a> f7034b = p.f();

    private a() {
    }

    public static a a() {
        if (f7033a == null) {
            synchronized (a.class) {
                if (f7033a == null) {
                    f7033a = new a();
                }
            }
        }
        return f7033a;
    }

    public void a(@NonNull l lVar, List<FilterWord> list) {
        this.f7034b.a(lVar, list);
    }
}
