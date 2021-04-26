package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f23342a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f23343b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f23344c;

    public d(Context context) {
        this.f23342a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("UfoSharePreference", 0);
        this.f23343b = sharedPreferences;
        this.f23344c = sharedPreferences.edit();
    }

    private int a(String str) {
        return this.f23343b.getInt(str, 0);
    }

    private void a(String str, int i2) {
        this.f23344c.putInt(str, i2);
        this.f23344c.commit();
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
