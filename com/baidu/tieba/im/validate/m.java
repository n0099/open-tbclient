package com.baidu.tieba.im.validate;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ LinkedList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LinkedList linkedList) {
        this.a = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.db.l.a().a(this.a);
        return null;
    }
}
