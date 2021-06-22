package com.baidu.ufosdk.ui;

import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes5.dex */
public final class af extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22816a;

    public af(FeedbackEditActivity feedbackEditActivity) {
        this.f22816a = feedbackEditActivity;
    }

    public static Integer a() {
        try {
            Thread.sleep(280L);
            return null;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        this.f22816a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f22816a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f22816a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f22816a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        if (this.f22816a.getCurrentFocus() == null || this.f22816a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f22816a.getSystemService("input_method")).hideSoftInputFromWindow(this.f22816a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
