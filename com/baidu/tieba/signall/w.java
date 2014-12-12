package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private h bPZ = null;
    final /* synthetic */ u bQa;

    public w(u uVar) {
        this.bQa = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.bQa.ez = true;
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
            this.bPZ = new h();
            if (com.baidu.adp.lib.util.i.fg()) {
                hQ(sb.toString());
            }
        }
        sVar = this.bQa.bPV;
        return sVar;
    }

    private s hQ(String str) {
        s sVar;
        s sVar2;
        String hO = this.bPZ.hO(str);
        if (this.bPZ.ma()) {
            sVar = this.bQa.bPV;
            sVar.parserJson(hO);
            sVar2 = this.bQa.bPV;
            return sVar2;
        }
        this.bQa.bPV = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.bPZ.cancel();
        this.bPZ = null;
        this.bQa.bPU = null;
        this.bQa.ez = false;
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
        this.bQa.ez = false;
        this.bQa.bPU = null;
        vVar = this.bQa.bPW;
        if (vVar != null) {
            sVar2 = this.bQa.bPV;
            if (sVar2 != null) {
                vVar3 = this.bQa.bPW;
                sVar3 = this.bQa.bPV;
                vVar3.b(sVar3);
                return;
            }
            String mb = this.bPZ != null ? this.bPZ.mb() : null;
            vVar2 = this.bQa.bPW;
            vVar2.gF(mb);
        }
    }
}
