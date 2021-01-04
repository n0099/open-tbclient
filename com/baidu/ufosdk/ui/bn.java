package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes8.dex */
final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5748a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bm f5749b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.f5749b = bmVar;
        this.f5748a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f5749b.f5747b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f5748a));
        edit.commit();
        this.f5749b.f5747b.aA = this.f5748a;
        FeedbackInputActivity.j(this.f5749b.f5747b);
    }
}
