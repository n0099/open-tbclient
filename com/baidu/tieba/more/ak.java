package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.DatabaseManager;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ak extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ aj a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(String str) {
        com.baidu.tbadk.d dVar;
        com.baidu.tbadk.d dVar2;
        super.a((ak) str);
        this.a.a = null;
        dVar = this.a.e;
        if (dVar != null) {
            dVar2 = this.a.e;
            dVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
    }

    private ak(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ak(aj ajVar, byte b) {
        this(ajVar);
    }

    private String a() {
        new DatabaseManager(DatabaseManager.DatabaseLocation.SDCARD);
        DatabaseManager.b();
        com.baidu.tbadk.core.voice.cache.e.a();
        try {
            bb.a().b();
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
