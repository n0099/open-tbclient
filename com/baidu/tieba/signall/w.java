package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private i ceT = null;
    final /* synthetic */ u ceU;

    public w(u uVar) {
        this.ceU = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.ceU.pT = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public s doInBackground(String... strArr) {
        s sVar;
        if (strArr[0] == null) {
            return null;
        }
        String[] split = strArr[0].split(",");
        int ceil = (int) Math.ceil(split.length / 50.0f);
        for (int i = 0; i < ceil; i++) {
            int i2 = i * 50;
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < 50 && i2 + i3 < split.length; i3++) {
                if (i2 + i3 == split.length - 1) {
                    sb.append(split[i2 + i3]);
                } else {
                    sb.append(String.valueOf(split[i2 + i3]) + ",");
                }
            }
            this.ceT = new i();
            if (com.baidu.adp.lib.util.k.iH()) {
                ip(sb.toString());
            }
        }
        sVar = this.ceU.ceP;
        return sVar;
    }

    private s ip(String str) {
        s sVar;
        s sVar2;
        String im = this.ceT.im(str);
        if (this.ceT.pv()) {
            sVar = this.ceU.ceP;
            sVar.parserJson(im);
            sVar2 = this.ceU.ceP;
            return sVar2;
        }
        this.ceU.ceP = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.ceT.cancel();
        this.ceT = null;
        this.ceU.ceO = null;
        this.ceU.pT = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(s sVar) {
        v vVar;
        s sVar2;
        v vVar2;
        v vVar3;
        s sVar3;
        this.ceU.pT = false;
        this.ceU.ceO = null;
        vVar = this.ceU.ceQ;
        if (vVar != null) {
            sVar2 = this.ceU.ceP;
            if (sVar2 != null) {
                vVar3 = this.ceU.ceQ;
                sVar3 = this.ceU.ceP;
                vVar3.b(sVar3);
                return;
            }
            String pw = this.ceT != null ? this.ceT.pw() : null;
            vVar2 = this.ceU.ceQ;
            vVar2.gB(pw);
        }
    }
}
