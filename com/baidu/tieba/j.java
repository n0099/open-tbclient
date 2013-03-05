package com.baidu.tieba;

import android.os.AsyncTask;
/* loaded from: classes.dex */
class j extends AsyncTask {
    final /* synthetic */ GuideActivity a;

    private j(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(GuideActivity guideActivity, j jVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(GuideActivity.f(this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.g(this.a);
        }
    }
}
