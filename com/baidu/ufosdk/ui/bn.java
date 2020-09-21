package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes21.dex */
final class bn implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ bm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, String str) {
        this.b = bmVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.b.b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.a));
        edit.commit();
        this.b.b.aA = this.a;
        FeedbackInputActivity.j(this.b.b);
    }
}
