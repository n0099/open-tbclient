package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ac extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ aa a;
    private volatile ak b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ SignData a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(SignData signData) {
        ab abVar;
        ab abVar2;
        String str;
        String str2;
        SignData signData2 = signData;
        this.a.c = null;
        if (signData2 == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
            abVar2 = this.a.d;
            str = this.a.b;
            str2 = this.a.mErrorString;
            abVar2.a(str, str2);
            return;
        }
        abVar = this.a.d;
        abVar.a(signData2);
    }

    private ac(aa aaVar) {
        this.a = aaVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(aa aaVar, byte b) {
        this(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
    }

    private SignData a() {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.b = new ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/sign");
            ak akVar = this.b;
            str = this.a.a;
            akVar.a("kw", str);
            ak akVar2 = this.b;
            str2 = this.a.b;
            akVar2.a("fid", str2);
            this.b.a().a().a = true;
            String i = this.b.i();
            if (!this.b.c() || !this.b.a().b().b()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(i);
                str3 = this.a.b;
                signData.setForumId(str3);
                str4 = this.a.a;
                signData.setForumName(str4);
                return signData;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ab abVar;
        String str;
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        super.cancel(true);
        abVar = this.a.d;
        str = this.a.b;
        abVar.a(str, null);
    }
}
