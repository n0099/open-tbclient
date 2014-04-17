package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.TiebaStatic;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba extends BdAsyncTask<Object, Integer, SignData> {
    final /* synthetic */ az a;
    private volatile com.baidu.tbadk.core.util.ak b;

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
        com.baidu.adp.a.h hVar;
        SignData signData2 = signData;
        TiebaStatic.a(TbadkApplication.j().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        this.a.c = null;
        TiebaStatic.a(TbadkApplication.j().getApplicationContext(), "sign_end_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        if (signData2 == null && this.b != null) {
            this.a.mErrorCode = this.b.d();
            this.a.mErrorString = this.b.f();
        }
        hVar = this.a.mLoadDataCallBack;
        hVar.a(signData2);
    }

    private ba(az azVar) {
        this.a = azVar;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(az azVar, byte b) {
        this(azVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x00d5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x00a6 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.baidu.tbadk.core.data.SignData] */
    private SignData a() {
        Object obj;
        Exception e;
        String str;
        String str2;
        String i;
        TiebaStatic.a(TbadkApplication.j().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
        Object obj2 = null;
        try {
            TiebaStatic.a(TbadkApplication.j().getApplicationContext(), "sign_do_time", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            this.b = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/c/forum/sign");
            com.baidu.tbadk.core.util.ak akVar = this.b;
            str = this.a.a;
            akVar.a("kw", str);
            com.baidu.tbadk.core.util.ak akVar2 = this.b;
            str2 = this.a.b;
            akVar2.a("fid", str2);
            this.b.a().a().a = true;
            i = this.b.i();
        } catch (Exception e2) {
            obj = obj2;
            e = e2;
        }
        if (this.b.c()) {
            obj = this.b.a().b().b();
            try {
                if (obj != 0) {
                    SignData signData = new SignData();
                    signData.parserJson(i);
                    obj = signData;
                } else if (!com.baidu.tbadk.core.util.bc.c(i) && "199901".equals(new JSONObject(i).optString("error_code"))) {
                    SignData signData2 = new SignData();
                    signData2.parserJson(i);
                    signData2.setIsSigned(1);
                    signData2.setCountSignNum(1);
                    obj2 = null;
                    signData2.setBonusPoint(0);
                    obj = signData2;
                }
            } catch (Exception e3) {
                e = e3;
                com.baidu.adp.lib.util.f.b(getClass().getName(), "doInBackground", e.getMessage());
                return obj;
            }
            return obj;
        }
        obj = 0;
        return obj;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        com.baidu.adp.a.h hVar;
        if (this.b != null) {
            this.b.g();
        }
        this.a.c = null;
        super.cancel(true);
        hVar = this.a.mLoadDataCallBack;
        hVar.a(null);
    }
}
