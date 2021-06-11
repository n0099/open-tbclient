package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f22619a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f22620b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f22621c;

    public d(Context context) {
        this.f22619a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("UfoSharePreference", 0);
        this.f22620b = sharedPreferences;
        this.f22621c = sharedPreferences.edit();
    }

    private int a(String str) {
        return this.f22620b.getInt(str, 0);
    }

    private void a(String str, int i2) {
        this.f22621c.putInt(str, i2);
        this.f22621c.commit();
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
