package com.baidu.tieba.im.validate;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends BdAsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LinkedList f1904a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(LinkedList linkedList) {
        this.f1904a = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        com.baidu.tieba.im.db.l.a().a(this.f1904a);
        return null;
    }
}
