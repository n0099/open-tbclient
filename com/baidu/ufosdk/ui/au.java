package com.baidu.ufosdk.ui;

import android.os.AsyncTask;
import android.view.inputmethod.InputMethodManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class au extends AsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f5444a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f5444a = feedbackFacePageActivity;
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
        this.f5444a.finish();
        try {
            com.baidu.ufosdk.f.c.d("执行动画...");
            this.f5444a.overridePendingTransition(com.baidu.ufosdk.f.i.a(this.f5444a.getApplicationContext(), "ufo_slide_in_from_left"), com.baidu.ufosdk.f.i.a(this.f5444a.getApplicationContext(), "ufo_slide_out_to_right"));
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.d("exit!");
        }
    }

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        if (this.f5444a.getCurrentFocus() == null || this.f5444a.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) this.f5444a.getSystemService("input_method")).hideSoftInputFromWindow(this.f5444a.getCurrentFocus().getWindowToken(), 2);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }
}
