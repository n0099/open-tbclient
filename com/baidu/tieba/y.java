package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class y extends BdAsyncTask<String, Integer, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GuideActivity f2727a;

    private y(GuideActivity guideActivity) {
        this.f2727a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(GuideActivity guideActivity, u uVar) {
        this(guideActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(String... strArr) {
        boolean c;
        c = this.f2727a.c();
        return Boolean.valueOf(c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            this.f2727a.b();
        }
    }
}
