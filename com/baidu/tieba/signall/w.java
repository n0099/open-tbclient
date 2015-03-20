package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private i ceE = null;
    final /* synthetic */ u ceF;

    public w(u uVar) {
        this.ceF = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.ceF.pT = true;
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
            this.ceE = new i();
            if (com.baidu.adp.lib.util.k.iH()) {
                im(sb.toString());
            }
        }
        sVar = this.ceF.ceA;
        return sVar;
    }

    private s im(String str) {
        s sVar;
        s sVar2;
        String ij = this.ceE.ij(str);
        if (this.ceE.pv()) {
            sVar = this.ceF.ceA;
            sVar.parserJson(ij);
            sVar2 = this.ceF.ceA;
            return sVar2;
        }
        this.ceF.ceA = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.ceE.cancel();
        this.ceE = null;
        this.ceF.cez = null;
        this.ceF.pT = false;
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
        this.ceF.pT = false;
        this.ceF.cez = null;
        vVar = this.ceF.ceB;
        if (vVar != null) {
            sVar2 = this.ceF.ceA;
            if (sVar2 != null) {
                vVar3 = this.ceF.ceB;
                sVar3 = this.ceF.ceA;
                vVar3.b(sVar3);
                return;
            }
            String pw = this.ceE != null ? this.ceE.pw() : null;
            vVar2 = this.ceF.ceB;
            vVar2.gy(pw);
        }
    }
}
