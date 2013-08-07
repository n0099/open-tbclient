package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.util.DatabaseService;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MoreModel f1341a;

    private az(MoreModel moreModel) {
        this.f1341a = moreModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(MoreModel moreModel, az azVar) {
        this(moreModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.e eVar;
        com.baidu.adp.a.e eVar2;
        super.a((Object) str);
        this.f1341a.f1315a = null;
        eVar = this.f1341a.mLoadDataCallBack;
        if (eVar != null) {
            eVar2 = this.f1341a.mLoadDataCallBack;
            eVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        DatabaseService.z();
        try {
            File[] listFiles = new File(com.baidu.tieba.util.p.f1769a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.util.p.f1769a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
