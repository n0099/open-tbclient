package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class y extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ GuideActivity a;

    private y(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(GuideActivity guideActivity, y yVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        return Boolean.valueOf(GuideActivity.e(this.a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.f(this.a);
        }
    }
}
