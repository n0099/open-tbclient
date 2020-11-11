package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class cy extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(FeedbackInputActivity feedbackInputActivity) {
        this.f3819a = feedbackInputActivity;
    }

    private static Integer a() {
        try {
            Thread.sleep(280L);
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return a();
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        boolean z;
        z = this.f3819a.aD;
        if (z) {
            Intent intent = new Intent(this.f3819a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            intent.putExtra("backPress", true);
            this.f3819a.startActivity(intent);
        }
        this.f3819a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f3819a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f3819a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f3819a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("执行动画失败！！");
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        if (this.f3819a.getCurrentFocus() == null || this.f3819a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f3819a.getSystemService("input_method")).hideSoftInputFromWindow(this.f3819a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
