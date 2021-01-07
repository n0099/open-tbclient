package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5749a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bm f5750b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.f5750b = bmVar;
        this.f5749a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f5750b.f5748b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f5749a));
        edit.commit();
        this.f5750b.f5748b.aA = this.f5749a;
        FeedbackInputActivity.j(this.f5750b.f5748b);
    }
}
