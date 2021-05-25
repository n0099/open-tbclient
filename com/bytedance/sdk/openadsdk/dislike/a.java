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
    public static volatile a f28885a;

    /* renamed from: b  reason: collision with root package name */
    public final q<com.bytedance.sdk.openadsdk.c.a> f28886b = p.f();

    public static a a() {
        if (f28885a == null) {
            synchronized (a.class) {
                if (f28885a == null) {
                    f28885a = new a();
                }
            }
        }
        return f28885a;
    }

    public void a(@NonNull l lVar, List<FilterWord> list) {
        this.f28886b.a(lVar, list);
    }
}
