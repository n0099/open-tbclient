package com.baidu.ufosdk.ui;

import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public final class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23086a;

    public bk(FeedbackInputActivity feedbackInputActivity) {
        this.f23086a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        String str4;
        SharedPreferences.Editor edit = this.f23086a.getSharedPreferences("UfoSharePreference", 0).edit();
        str = this.f23086a.aA;
        if (str != null) {
            str3 = this.f23086a.aA;
            if (str3.trim().length() > 0) {
                str4 = this.f23086a.aA;
                str2 = com.baidu.ufosdk.f.k.a(str4);
                edit.putString("cryptContactData", str2);
                edit.commit();
                FeedbackInputActivity.j(this.f23086a);
            }
        }
        str2 = "";
        edit.putString("cryptContactData", str2);
        edit.commit();
        FeedbackInputActivity.j(this.f23086a);
    }
}
