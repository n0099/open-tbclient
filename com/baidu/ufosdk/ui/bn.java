package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes22.dex */
final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3779a;
    final /* synthetic */ bm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.b = bmVar;
        this.f3779a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.b.b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f3779a));
        edit.commit();
        this.b.b.aA = this.f3779a;
        FeedbackInputActivity.j(this.b.b);
    }
}
