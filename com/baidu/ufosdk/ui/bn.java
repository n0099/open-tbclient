package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes7.dex */
final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5466a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bm f5467b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.f5467b = bmVar;
        this.f5466a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f5467b.f5465b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f5466a));
        edit.commit();
        this.f5467b.f5465b.aA = this.f5466a;
        FeedbackInputActivity.j(this.f5467b.f5465b);
    }
}
