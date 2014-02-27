package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
final class y extends BdAsyncTask<String, Integer, Boolean> {
    final /* synthetic */ GuideActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(String... strArr) {
        return Boolean.valueOf(GuideActivity.e(this.a));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        GuideActivity.f(this.a);
    }

    private y(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(GuideActivity guideActivity, byte b) {
        this(guideActivity);
    }
}
