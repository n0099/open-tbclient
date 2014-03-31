package com.baidu.tieba.util;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o extends BdAsyncTask<String, String, WriteData> {
    private final n a;
    private final String b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ WriteData a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(WriteData writeData) {
        WriteData writeData2 = writeData;
        super.a((o) writeData2);
        if (this.a != null) {
            this.a.a(writeData2);
        }
    }

    public o(String str, n nVar) {
        setPriority(3);
        this.a = nVar;
        this.b = str;
    }

    private WriteData a() {
        String str;
        try {
            str = com.baidu.tbadk.core.c.b.a().d().a(this.b);
        } catch (Exception e) {
            str = null;
        }
        return WriteData.fromDraftString(str);
    }
}
