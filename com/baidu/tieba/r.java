package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f1667a;

    private r(GuideActivity guideActivity) {
        this.f1667a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(GuideActivity guideActivity, r rVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        return Boolean.valueOf(GuideActivity.f(this.f1667a));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            GuideActivity.g(this.f1667a);
        }
    }
}
