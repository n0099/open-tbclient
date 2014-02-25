package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends BdAsyncTask<String, String, WriteData> {
    private final ag a;
    private final String b;

    public ah(String str, ag agVar) {
        setPriority(3);
        this.a = agVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public WriteData a(String... strArr) {
        String str;
        try {
            str = com.baidu.tieba.c.a.a().d().a(this.b);
        } catch (Exception e) {
            str = null;
        }
        return WriteData.fromDraftString(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(WriteData writeData) {
        super.a((ah) writeData);
        if (this.a != null) {
            this.a.a(writeData);
        }
    }
}
