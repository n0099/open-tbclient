package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ag extends BdAsyncTask<String, String, WriteData> {
    private final af a;
    private final String b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ WriteData a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(WriteData writeData) {
        WriteData writeData2 = writeData;
        super.a((ag) writeData2);
        if (this.a != null) {
            this.a.a(writeData2);
        }
    }

    public ag(String str, af afVar) {
        setPriority(3);
        this.a = afVar;
        this.b = str;
    }

    private WriteData d() {
        String str;
        try {
            str = com.baidu.tieba.c.a.a().d().a(this.b);
        } catch (Exception e) {
            str = null;
        }
        return WriteData.fromDraftString(str);
    }
}
