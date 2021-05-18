package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22739a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f22740b;

    public bn(bm bmVar, String str) {
        this.f22740b = bmVar;
        this.f22739a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f22740b.f22738b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f22739a));
        edit.commit();
        this.f22740b.f22738b.aA = this.f22739a;
        FeedbackInputActivity.j(this.f22740b.f22738b);
    }
}
