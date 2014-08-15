package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
class al extends BdAsyncTask<String, Integer, Void> {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(String... strArr) {
        com.baidu.tbadk.core.account.a.a(strArr[0], strArr[1]);
        return null;
    }
}
