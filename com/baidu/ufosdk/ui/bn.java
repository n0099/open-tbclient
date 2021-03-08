package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes7.dex */
final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3687a;
    final /* synthetic */ bm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.b = bmVar;
        this.f3687a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.b.b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f3687a));
        edit.commit();
        this.b.b.aA = this.f3687a;
        FeedbackInputActivity.j(this.b.b);
    }
}
