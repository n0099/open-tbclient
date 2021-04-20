package com.baidu.ufosdk.f;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public Context f22631a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f22632b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f22633c;

    public d(Context context) {
        this.f22631a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("UfoSharePreference", 0);
        this.f22632b = sharedPreferences;
        this.f22633c = sharedPreferences.edit();
    }

    private int a(String str) {
        return this.f22632b.getInt(str, 0);
    }

    private void a(String str, int i) {
        this.f22633c.putInt(str, i);
        this.f22633c.commit();
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
