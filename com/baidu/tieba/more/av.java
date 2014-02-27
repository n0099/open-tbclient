package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class av extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ au a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(String str) {
        com.baidu.tieba.i iVar;
        com.baidu.tieba.i iVar2;
        super.a((av) str);
        this.a.a = null;
        iVar = this.a.e;
        if (iVar != null) {
            iVar2 = this.a.e;
            iVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
    }

    private av(au auVar) {
        this.a = auVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(au auVar, byte b) {
        this(auVar);
    }

    private String d() {
        DatabaseService.u();
        com.baidu.tieba.voice.a.e.a();
        try {
            br.a().b();
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
