package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.model.MoreModel;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bg;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ax f1992a;

    private az(ax axVar) {
        this.f1992a = axVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        com.baidu.adp.a.g gVar;
        com.baidu.adp.a.g gVar2;
        super.a((az) str);
        this.f1992a.f1991a = null;
        gVar = this.f1992a.mLoadDataCallBack;
        if (gVar != null) {
            gVar2 = this.f1992a.mLoadDataCallBack;
            gVar2.a(MoreModel.TaskType.DO_CLEAR);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        com.baidu.tieba.im.db.m.b();
        DatabaseService.x();
        com.baidu.tieba.voice.a.e.a();
        try {
            File[] listFiles = new File(com.baidu.tieba.util.af.f2480a + "/tieba/image/").listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        bg.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
            }
            File[] listFiles2 = new File(com.baidu.tieba.util.af.f2480a + "/tieba/hotspot/").listFiles();
            if (listFiles2 != null) {
                for (File file2 : listFiles2) {
                    if (!file2.delete()) {
                        bg.b(getClass().getName(), "doInBackground", "list[i].delete error");
                    }
                }
                return null;
            }
            return null;
        } catch (Exception e) {
            bg.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }
}
