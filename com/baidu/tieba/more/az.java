package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.be;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f2000a;

    private az(ax axVar) {
        this.f2000a = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((az) str);
        this.f2000a.f1999a = null;
        gVar = this.f2000a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f2000a.mLoadDataCallBack;
            gVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        DatabaseService.x();
        com.baidu.tieba.voice.a.e.a();
        try {
            File[] listFiles = new File(com.baidu.tieba.util.w.f2463a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        be.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.util.w.f2463a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        be.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            be.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
