package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ aa a;
    private volatile an b;

    private ac(aa aaVar) {
        this.a = aaVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(aa aaVar, ac acVar) {
        this(aaVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public SignData doInBackground(Object... objArr) {
        SignData signData;
        Exception e;
        String str;
        String str2;
        String str3;
        String str4;
        try {
            this.b = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            an anVar = this.b;
            str = this.a.a;
            anVar.a("kw", str);
            an anVar2 = this.b;
            str2 = this.a.b;
            anVar2.a("fid", str2);
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
                BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        ab abVar;
        ab abVar2;
        String str;
        String str2;
        this.a.c = null;
        if (signData != null || this.b == null) {
            abVar = this.a.d;
            abVar.a(signData);
            return;
        }
        this.a.mErrorCode = this.b.d();
        this.a.mErrorString = this.b.f();
        abVar2 = this.a.d;
        str = this.a.b;
        str2 = this.a.mErrorString;
        abVar2.a(str, str2);
    }
}
