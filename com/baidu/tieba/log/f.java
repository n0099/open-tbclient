package com.baidu.tieba.log;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ a a;
    private e b = null;
    private String c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        this.b = new e(this.a, (byte) 0);
        this.b.a(this.c, "c/s/logupload", true);
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a((f) str);
        this.a.p = null;
    }

    public f(a aVar, String str) {
        this.a = aVar;
        this.c = "";
        this.c = str;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        if (this.b != null) {
            this.b.a();
        }
        this.a.p = null;
        super.cancel(true);
    }
}
