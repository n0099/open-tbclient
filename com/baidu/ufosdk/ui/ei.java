package com.baidu.ufosdk.ui;

import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes5.dex */
public final class ei extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23617a;

    public ei(FeedbackReportActivity feedbackReportActivity) {
        this.f23617a = feedbackReportActivity;
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
        this.f23617a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f23617a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f23617a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f23617a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        if (this.f23617a.getCurrentFocus() == null || this.f23617a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f23617a.getSystemService("input_method")).hideSoftInputFromWindow(this.f23617a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
