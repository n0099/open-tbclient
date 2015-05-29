package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private i ciX = null;
    final /* synthetic */ u ciY;

    public w(u uVar) {
        this.ciY = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.ciY.pY = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: z */
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
            this.ciX = new i();
            if (com.baidu.adp.lib.util.k.iX()) {
                ji(sb.toString());
            }
        }
        sVar = this.ciY.ciU;
        return sVar;
    }

    private s ji(String str) {
        s sVar;
        s sVar2;
        String jf = this.ciX.jf(str);
        if (this.ciX.qa()) {
            sVar = this.ciY.ciU;
            sVar.parserJson(jf);
            sVar2 = this.ciY.ciU;
            return sVar2;
        }
        this.ciY.ciU = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.ciX.cancel();
        this.ciX = null;
        this.ciY.ciT = null;
        this.ciY.pY = false;
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
        this.ciY.pY = false;
        this.ciY.ciT = null;
        vVar = this.ciY.ciV;
        if (vVar != null) {
            sVar2 = this.ciY.ciU;
            if (sVar2 != null) {
                vVar3 = this.ciY.ciV;
                sVar3 = this.ciY.ciU;
                vVar3.b(sVar3);
                return;
            }
            String qb = this.ciX != null ? this.ciX.qb() : null;
            vVar2 = this.ciY.ciV;
            vVar2.he(qb);
        }
    }
}
