package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private h bRJ = null;
    final /* synthetic */ u bRK;

    public w(u uVar) {
        this.bRK = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.bRK.eB = true;
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
            this.bRJ = new h();
            if (com.baidu.adp.lib.util.i.ff()) {
                hX(sb.toString());
            }
        }
        sVar = this.bRK.bRF;
        return sVar;
    }

    private s hX(String str) {
        s sVar;
        s sVar2;
        String hV = this.bRJ.hV(str);
        if (this.bRJ.ma()) {
            sVar = this.bRK.bRF;
            sVar.parserJson(hV);
            sVar2 = this.bRK.bRF;
            return sVar2;
        }
        this.bRK.bRF = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.bRJ.cancel();
        this.bRJ = null;
        this.bRK.bRE = null;
        this.bRK.eB = false;
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
        this.bRK.eB = false;
        this.bRK.bRE = null;
        vVar = this.bRK.bRG;
        if (vVar != null) {
            sVar2 = this.bRK.bRF;
            if (sVar2 != null) {
                vVar3 = this.bRK.bRG;
                sVar3 = this.bRK.bRF;
                vVar3.b(sVar3);
                return;
            }
            String mb = this.bRJ != null ? this.bRJ.mb() : null;
            vVar2 = this.bRK.bRG;
            vVar2.gK(mb);
        }
    }
}
