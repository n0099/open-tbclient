package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ z a;
    private volatile aq b;

    private ab(z zVar) {
        this.a = zVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(z zVar, ab abVar) {
        this(zVar);
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
            this.b = new aq(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            aq aqVar = this.b;
            str = this.a.a;
            aqVar.a("kw", str);
            aq aqVar2 = this.b;
            str2 = this.a.b;
            aqVar2.a("fid", str2);
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
                BdLog.e(e.getMessage());
                return signData;
            }
        } catch (Exception e3) {
            signData = null;
            e = e3;
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        aa aaVar;
        String str;
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        super.cancel(true);
        aaVar = this.a.d;
        str = this.a.b;
        aaVar.a(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        aa aaVar;
        aa aaVar2;
        String str;
        String str2;
        this.a.c = null;
        if (signData != null || this.b == null) {
            aaVar = this.a.d;
            aaVar.a(signData);
            return;
        }
        this.a.mErrorCode = this.b.d();
        this.a.mErrorString = this.b.f();
        aaVar2 = this.a.d;
        str = this.a.b;
        str2 = this.a.mErrorString;
        aaVar2.a(str, str2);
    }
}
