package com.baidu.tieba.tblauncher;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class g extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ GuideActivity caM;

    private g(GuideActivity guideActivity) {
        this.caM = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(GuideActivity guideActivity, g gVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public Boolean doInBackground(String... strArr) {
        return Boolean.valueOf(GuideActivity.i(this.caM));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.j(this.caM);
        }
    }
}
