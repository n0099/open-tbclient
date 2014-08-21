package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.SignData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ ad a;
    private volatile com.baidu.tbadk.core.util.ae b;

    private af(ad adVar) {
        this.a = adVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(ad adVar, af afVar) {
        this(adVar);
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
            this.b = new com.baidu.tbadk.core.util.ae(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/c/forum/sign");
            com.baidu.tbadk.core.util.ae aeVar = this.b;
            str = this.a.a;
            aeVar.a("kw", str);
            com.baidu.tbadk.core.util.ae aeVar2 = this.b;
            str2 = this.a.b;
            aeVar2.a("fid", str2);
            this.b.a().a().a = true;
            String h = this.b.h();
            if (!this.b.b() || !this.b.a().b().b()) {
                return null;
            }
            signData = new SignData();
            try {
                signData.parserJson(h);
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
        ae aeVar;
        String str;
        if (this.b != null) {
            this.b.f();
        }
        this.a.c = null;
        super.cancel(true);
        aeVar = this.a.d;
        str = this.a.b;
        aeVar.a(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(SignData signData) {
        ae aeVar;
        ae aeVar2;
        String str;
        String str2;
        this.a.c = null;
        if (signData != null || this.b == null) {
            aeVar = this.a.d;
            aeVar.a(signData);
            return;
        }
        this.a.mErrorCode = this.b.c();
        this.a.mErrorString = this.b.e();
        aeVar2 = this.a.d;
        str = this.a.b;
        str2 = this.a.mErrorString;
        aeVar2.a(str, str2);
    }
}
