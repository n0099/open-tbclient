package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class f extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ GuideActivity bxy;

    private f(GuideActivity guideActivity) {
        this.bxy = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ f(GuideActivity guideActivity, f fVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(GuideActivity.f(this.bxy));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.g(this.bxy);
        }
    }
}
