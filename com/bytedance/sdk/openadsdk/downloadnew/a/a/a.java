package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.i;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a implements com.ss.android.a.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f4699a;

    public a(Context context) {
        this.f4699a = new WeakReference<>(context);
    }

    @Override // com.ss.android.a.a.a.b
    public boolean a() {
        return i.d().a();
    }
}
