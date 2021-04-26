package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23494a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f23495b;

    public bn(bm bmVar, String str) {
        this.f23495b = bmVar;
        this.f23494a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f23495b.f23493b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f23494a));
        edit.commit();
        this.f23495b.f23493b.aA = this.f23494a;
        FeedbackInputActivity.j(this.f23495b.f23493b);
    }
}
