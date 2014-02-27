package com.baidu.tieba.im.validate;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class n extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ LinkedList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LinkedList linkedList) {
        this.a = linkedList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(Void... voidArr) {
        com.baidu.tieba.im.db.c.a().a(this.a);
        return null;
    }
}
