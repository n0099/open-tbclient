package com.bytedance.sdk.openadsdk.dislike;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f7330a;

    /* renamed from: b  reason: collision with root package name */
    private final q<com.bytedance.sdk.openadsdk.c.a> f7331b = p.f();

    private a() {
    }

    public static a a() {
        if (f7330a == null) {
            synchronized (a.class) {
                if (f7330a == null) {
                    f7330a = new a();
                }
            }
        }
        return f7330a;
    }

    public void a(@NonNull l lVar, List<FilterWord> list) {
        this.f7331b.a(lVar, list);
    }
}
