package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ au a;

    private av(au auVar) {
        this.a = auVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(au auVar, av avVar) {
        this(auVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.tieba.i iVar;
        com.baidu.tieba.i iVar2;
        super.a((av) str);
        this.a.a = null;
        iVar = this.a.e;
        if (iVar == null) {
            return;
        }
        iVar2 = this.a.e;
        iVar2.a(MoreModel.TaskType.DO_CLEAR);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        DatabaseService.u();
        com.baidu.tieba.voice.a.e.a();
        try {
            br.a().b();
            return null;
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
