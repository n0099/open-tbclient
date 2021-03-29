package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23091a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f23092b;

    public bn(bm bmVar, String str) {
        this.f23092b = bmVar;
        this.f23091a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f23092b.f23090b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f23091a));
        edit.commit();
        this.f23092b.f23090b.aA = this.f23091a;
        FeedbackInputActivity.j(this.f23092b.f23090b);
    }
}
