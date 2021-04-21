package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22784a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f22785b;

    public bn(bm bmVar, String str) {
        this.f22785b = bmVar;
        this.f22784a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f22785b.f22783b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f22784a));
        edit.commit();
        this.f22785b.f22783b.aA = this.f22784a;
        FeedbackInputActivity.j(this.f22785b.f22783b);
    }
}
