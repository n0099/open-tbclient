package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.i;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class a implements com.ss.android.a.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f7357a;

    public a(Context context) {
        this.f7357a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.b
    public boolean a() {
        return i.c().a();
    }
}
