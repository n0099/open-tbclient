package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23090a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f23091b;

    public bn(bm bmVar, String str) {
        this.f23091b = bmVar;
        this.f23090a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f23091b.f23089b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f23090a));
        edit.commit();
        this.f23091b.f23089b.aA = this.f23090a;
        FeedbackInputActivity.j(this.f23091b.f23089b);
    }
}
