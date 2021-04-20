package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22776a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f22777b;

    public bn(bm bmVar, String str) {
        this.f22777b = bmVar;
        this.f22776a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f22777b.f22775b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f22776a));
        edit.commit();
        this.f22777b.f22775b.aA = this.f22776a;
        FeedbackInputActivity.j(this.f22777b.f22775b);
    }
}
