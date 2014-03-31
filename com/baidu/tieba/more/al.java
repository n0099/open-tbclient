package com.baidu.tieba.more;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.model.MoreModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ aj a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        String E = TbadkApplication.E();
        if (TextUtils.isEmpty(E)) {
            return null;
        }
        com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2008015, E));
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        com.baidu.tbadk.d dVar;
        com.baidu.tbadk.d dVar2;
        super.a((al) str);
        this.a.b = null;
        dVar = this.a.e;
        if (dVar != null) {
            dVar2 = this.a.e;
            dVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
        com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2008016));
    }

    private al(aj ajVar) {
        this.a = ajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ al(aj ajVar, byte b) {
        this(ajVar);
    }
}
