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
    private static volatile a f7031a;

    /* renamed from: b  reason: collision with root package name */
    private final q<com.bytedance.sdk.openadsdk.c.a> f7032b = p.f();

    private a() {
    }

    public static a a() {
        if (f7031a == null) {
            synchronized (a.class) {
                if (f7031a == null) {
                    f7031a = new a();
                }
            }
        }
        return f7031a;
    }

    public void a(@NonNull l lVar, List<FilterWord> list) {
        this.f7032b.a(lVar, list);
    }
}
