package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes8.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    Context f5382a;

    /* renamed from: b  reason: collision with root package name */
    SharedPreferences f5383b;
    SharedPreferences.Editor c;

    public d(Context context) {
        this.f5382a = context;
        this.f5383b = context.getSharedPreferences("UfoSharePreference", 0);
        this.c = this.f5383b.edit();
    }

    private int a(String str) {
        return this.f5383b.getInt(str, 0);
    }

    private void a(String str, int i) {
        this.c.putInt(str, i);
        this.c.commit();
    }

    public final int a() {
        return a("editFeedbackView");
    }

    public final void a(int i) {
        a("editFeedbackView", i);
    }

    public final int b() {
        return a("editFeedbackWord");
    }

    public final void b(int i) {
        a("editFeedbackWord", i);
    }

    public final int c() {
        return a("editFeedbackPicture");
    }

    public final void c(int i) {
        a("editFeedbackPicture", i);
    }

    public final int d() {
        return a("myFeedback");
    }

    public final void d(int i) {
        a("myFeedback", i);
    }
}
