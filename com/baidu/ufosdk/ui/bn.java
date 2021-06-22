package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22853a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f22854b;

    public bn(bm bmVar, String str) {
        this.f22854b = bmVar;
        this.f22853a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f22854b.f22852b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f22853a));
        edit.commit();
        this.f22854b.f22852b.aA = this.f22853a;
        FeedbackInputActivity.j(this.f22854b.f22852b);
    }
}
