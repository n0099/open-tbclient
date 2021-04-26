package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes5.dex */
public final class cy extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23545a;

    public cy(FeedbackInputActivity feedbackInputActivity) {
        this.f23545a = feedbackInputActivity;
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
        boolean z;
        z = this.f23545a.aD;
        if (z) {
            Intent intent = new Intent(this.f23545a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("backPress", true);
            this.f23545a.startActivity(intent);
        }
        this.f23545a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f23545a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f23545a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f23545a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        if (this.f23545a.getCurrentFocus() == null || this.f23545a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f23545a.getSystemService("input_method")).hideSoftInputFromWindow(this.f23545a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
