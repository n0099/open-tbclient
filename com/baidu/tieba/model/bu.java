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
    final /* synthetic */ bs a;
    private com.baidu.tieba.a.i b = null;
    private String c = null;
    private boolean d = false;

    public bu(bs bsVar) {
        this.a = bsVar;
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
        this.b = new com.baidu.tieba.a.i();
        com.baidu.tieba.a.i iVar = this.b;
        writeData = this.a.b;
        z = this.a.d;
        this.c = iVar.a(writeData, z);
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
        btVar = this.a.c;
        if (btVar != null) {
            btVar2 = this.a.c;
            btVar2.a(false, null, null, null, null);
        }
        super.cancel(true);
        this.a.a = null;
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
            btVar5 = this.a.c;
            if (btVar5 != null) {
                btVar6 = this.a.c;
                btVar6.a(false, str, null, null, e);
                return;
            }
            return;
        }
        com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
        bdVar.a(this.c);
        if (bdVar.b() != null) {
            writeData = this.a.b;
            if (writeData != null) {
                writeData2 = this.a.b;
                writeData2.setVcodeMD5(bdVar.a());
                writeData3 = this.a.b;
                writeData3.setVcodeUrl(bdVar.b());
                btVar3 = this.a.c;
                if (btVar3 != null) {
                    btVar4 = this.a.c;
                    writeData4 = this.a.b;
                    btVar4.a(false, str, bdVar, writeData4, e);
                    return;
                }
                return;
            }
        }
        btVar = this.a.c;
        if (btVar != null) {
            btVar2 = this.a.c;
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
        com.baidu.tieba.util.be.e(getClass().getName(), "onPostExecute", "result:" + str);
        this.a.a = null;
        if (!this.d) {
            if (str == null) {
                btVar = this.a.c;
                btVar.a(false, TiebaApplication.h().getString(R.string.neterror), null, null, null);
            } else if (this.b.a()) {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.c);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    errorData.setError_msg(TiebaApplication.h().getString(R.string.send_success));
                    btVar2 = this.a.c;
                    if (btVar2 != null) {
                        AntiData e = (this.b == null || !this.b.a()) ? null : this.b.e();
                        btVar3 = this.a.c;
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
