package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f22587a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f22588b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f22589c;

    public d(Context context) {
        this.f22587a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("UfoSharePreference", 0);
        this.f22588b = sharedPreferences;
        this.f22589c = sharedPreferences.edit();
    }

    private int a(String str) {
        return this.f22588b.getInt(str, 0);
    }

    private void a(String str, int i2) {
        this.f22589c.putInt(str, i2);
        this.f22589c.commit();
    }

    public final int a() {
        return a("editFeedbackView");
    }

    public final void a(int i2) {
        a("editFeedbackView", i2);
    }

    public final int b() {
        return a("editFeedbackWord");
    }

    public final void b(int i2) {
        a("editFeedbackWord", i2);
    }

    public final int c() {
        return a("editFeedbackPicture");
    }

    public final void c(int i2) {
        a("editFeedbackPicture", i2);
    }

    public final int d() {
        return a("myFeedback");
    }

    public final void d(int i2) {
        a("myFeedback", i2);
    }
}
