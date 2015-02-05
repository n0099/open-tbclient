package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private h bRI = null;
    final /* synthetic */ u bRJ;

    public w(u uVar) {
        this.bRJ = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.bRJ.eB = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: A */
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
            this.bRI = new h();
            if (com.baidu.adp.lib.util.i.ff()) {
                hV(sb.toString());
            }
        }
        sVar = this.bRJ.bRE;
        return sVar;
    }

    private s hV(String str) {
        s sVar;
        s sVar2;
        String hT = this.bRI.hT(str);
        if (this.bRI.lT()) {
            sVar = this.bRJ.bRE;
            sVar.parserJson(hT);
            sVar2 = this.bRJ.bRE;
            return sVar2;
        }
        this.bRJ.bRE = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.bRI.cancel();
        this.bRI = null;
        this.bRJ.bRD = null;
        this.bRJ.eB = false;
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
        this.bRJ.eB = false;
        this.bRJ.bRD = null;
        vVar = this.bRJ.bRF;
        if (vVar != null) {
            sVar2 = this.bRJ.bRE;
            if (sVar2 != null) {
                vVar3 = this.bRJ.bRF;
                sVar3 = this.bRJ.bRE;
                vVar3.b(sVar3);
                return;
            }
            String lU = this.bRI != null ? this.bRI.lU() : null;
            vVar2 = this.bRJ.bRF;
            vVar2.gH(lU);
        }
    }
}
