package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ at f2082a;

    private av(at atVar) {
        this.f2082a = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((av) str);
        this.f2082a.f2081a = null;
        gVar = this.f2082a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f2082a.mLoadDataCallBack;
            gVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        com.baidu.tieba.im.db.s.b();
        DatabaseService.x();
        com.baidu.tieba.voice.a.e.a();
        try {
            File[] listFiles = new File(com.baidu.tieba.util.x.f2616a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        bd.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.util.x.f2616a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        bd.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            bd.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
