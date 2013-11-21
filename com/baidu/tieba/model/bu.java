package com.baidu.tieba.model;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bs f1902a;
    private com.baidu.tieba.a.k b = null;
    private String c = null;
    private boolean d = false;

    public bu(bs bsVar) {
        this.f1902a = bsVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        WriteData writeData;
        boolean z;
        if (this.d) {
            return null;
        }
        this.b = new com.baidu.tieba.a.k();
        com.baidu.tieba.a.k kVar = this.b;
        writeData = this.f1902a.b;
        z = this.f1902a.d;
        this.c = kVar.a(writeData, z);
        return this.c;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        bt btVar;
        bt btVar2;
        this.d = true;
        if (this.b != null) {
            this.b.d();
        }
        btVar = this.f1902a.c;
        if (btVar != null) {
            btVar2 = this.f1902a.c;
            btVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.f1902a.f1901a = null;
    }

    private void a(int i, String str) {
        bt btVar;
        bt btVar2;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        bt btVar3;
        bt btVar4;
        WriteData writeData4;
        bt btVar5;
        bt btVar6;
        AntiData e = this.b != null ? this.b.e() : null;
        if (i != 5 && i != 6) {
            btVar5 = this.f1902a.c;
            if (btVar5 != null) {
                btVar6 = this.f1902a.c;
                btVar6.a(false, str, null, null, e);
                return;
            }
            return;
        }
        com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
        bdVar.a(this.c);
        if (bdVar.b() != null) {
            writeData = this.f1902a.b;
            if (writeData != null) {
                writeData2 = this.f1902a.b;
                writeData2.setVcodeMD5(bdVar.a());
                writeData3 = this.f1902a.b;
                writeData3.setVcodeUrl(bdVar.b());
                btVar3 = this.f1902a.c;
                if (btVar3 != null) {
                    btVar4 = this.f1902a.c;
                    writeData4 = this.f1902a.b;
                    btVar4.a(false, str, bdVar, writeData4, e);
                    return;
                }
                return;
            }
        }
        btVar = this.f1902a.c;
        if (btVar != null) {
            btVar2 = this.f1902a.c;
            btVar2.a(false, str, null, null, e);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        bt btVar;
        bt btVar2;
        bt btVar3;
        super.a((bu) str);
        com.baidu.tieba.util.bg.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.f1902a.f1901a = null;
        if (!this.d) {
            if (str == null) {
                btVar = this.f1902a.c;
                btVar.a(false, TiebaApplication.g().getString(R.string.neterror), null, null, null);
            } else if (this.b.a()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.c);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    errorData.setError_msg(TiebaApplication.g().getString(R.string.send_success));
                    btVar2 = this.f1902a.c;
                    if (btVar2 != null) {
                        AntiData e = (this.b == null || !this.b.a()) ? null : this.b.e();
                        btVar3 = this.f1902a.c;
                        btVar3.a(true, errorData.getError_msg(), null, null, e);
                        return;
                    }
                    return;
                }
                a(errorData.getError_code(), errorData.getError_msg());
            } else {
                a(this.b.b(), this.b.c());
            }
        }
    }
}
