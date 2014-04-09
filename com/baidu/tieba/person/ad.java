package com.baidu.tieba.person;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad extends BdAsyncTask<String, Integer, Void> {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.a = abVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(String... strArr) {
        return a2(strArr);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static Void a2(String... strArr) {
        com.baidu.tbadk.core.a.o.a(strArr[0], strArr[1]);
        return null;
    }
}
