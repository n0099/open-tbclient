package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5744a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(FeedbackInputActivity feedbackInputActivity) {
        this.f5744a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        SharedPreferences.Editor edit = this.f5744a.getSharedPreferences("UfoSharePreference", 0).edit();
        str = this.f5744a.aA;
        if (str != null) {
            str2 = this.f5744a.aA;
            if (str2.trim().length() > 0) {
                str3 = this.f5744a.aA;
                edit.putString("cryptContactData", com.baidu.ufosdk.f.k.a(str3));
                edit.commit();
                FeedbackInputActivity.j(this.f5744a);
            }
        }
        edit.putString("cryptContactData", "");
        edit.commit();
        FeedbackInputActivity.j(this.f5744a);
    }
}
