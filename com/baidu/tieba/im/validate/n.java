package com.baidu.tieba.im.validate;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ LinkedList a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LinkedList linkedList) {
        this.a = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        com.baidu.tieba.im.db.d.a().a(this.a);
        return null;
    }
}
