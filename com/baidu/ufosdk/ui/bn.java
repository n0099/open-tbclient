package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22668a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ bm f22669b;

    public bn(bm bmVar, String str) {
        this.f22669b = bmVar;
        this.f22668a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences.Editor edit = this.f22669b.f22667b.getSharedPreferences("UfoSharePreference", 0).edit();
        edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(this.f22668a));
        edit.commit();
        this.f22669b.f22667b.aA = this.f22668a;
        FeedbackInputActivity.j(this.f22669b.f22667b);
    }
}
