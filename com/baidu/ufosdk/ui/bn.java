package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5468a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bm f5469b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.f5469b = bmVar;
        this.f5468a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f5469b.f5467b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f5468a));
        edit.commit();
        this.f5469b.f5467b.aA = this.f5468a;
        FeedbackInputActivity.j(this.f5469b.f5467b);
    }
}
