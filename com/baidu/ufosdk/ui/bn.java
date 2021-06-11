package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22771a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f22772b;

    public bn(bm bmVar, String str) {
        this.f22772b = bmVar;
        this.f22771a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f22772b.f22770b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f22771a));
        edit.commit();
        this.f22772b.f22770b.aA = this.f22771a;
        FeedbackInputActivity.j(this.f22772b.f22770b);
    }
}
