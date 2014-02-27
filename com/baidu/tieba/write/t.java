package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends BdAsyncTask<Object, s, s> {
    final /* synthetic */ s a;
    private com.baidu.tieba.util.ba b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(s sVar) {
        com.baidu.adp.a.g gVar;
        s sVar2 = sVar;
        super.a((t) sVar2);
        this.a.a = null;
        gVar = this.a.mLoadDataCallBack;
        gVar.a(sVar2);
    }

    private t(s sVar) {
        this.a = sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(s sVar, byte b) {
        this(sVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public s a(Object... objArr) {
        s sVar = null;
        String obj = objArr[0].toString();
        this.b = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/frs/toplist");
        this.b.a("kw", obj);
        String l = this.b.l();
        if (this.b.c()) {
            sVar = new s();
            try {
                sVar.a(new JSONObject(l));
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(sVar.getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
        return sVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.a.a = null;
        if (this.b != null) {
            this.b.j();
        }
    }
}
