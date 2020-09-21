package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes21.dex */
public final class d {
    Context a;
    SharedPreferences b;
    SharedPreferences.Editor c;

    public d(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("UfoSharePreference", 0);
        this.c = this.b.edit();
    }

    private int a(String str) {
        return this.b.getInt(str, 0);
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
