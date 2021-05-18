package com.baidu.ufosdk.ui;

import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
/* loaded from: classes5.dex */
public final class au extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackFacePageActivity f22717a;

    public au(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f22717a = feedbackFacePageActivity;
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
        this.f22717a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f22717a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f22717a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f22717a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception unused) {
            com.baidu.ufosdk.f.c.d("exit!");
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        if (this.f22717a.getCurrentFocus() == null || this.f22717a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f22717a.getSystemService("input_method")).hideSoftInputFromWindow(this.f22717a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
