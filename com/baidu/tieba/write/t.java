package com.baidu.tieba.write;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t extends BdAsyncTask<Object, s, s> {
    final /* synthetic */ s a;
    private com.baidu.tbadk.core.util.ak b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(s sVar) {
        com.baidu.adp.a.h hVar;
        s sVar2 = sVar;
        super.a((t) sVar2);
        this.a.a = null;
        hVar = this.a.mLoadDataCallBack;
        hVar.a(sVar2);
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
        this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/frs/toplist");
        this.b.a("kw", obj);
        String i = this.b.i();
        if (this.b.a().b().b()) {
            sVar = new s();
            try {
                sVar.a(new JSONObject(i));
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(sVar.getClass().getName(), "parserJson", "error = " + e.getMessage());
            }
        }
        return sVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        this.a.a = null;
        if (this.b != null) {
            this.b.g();
        }
    }
}
