package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private i ciY = null;
    final /* synthetic */ u ciZ;

    public w(u uVar) {
        this.ciZ = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.ciZ.pY = true;
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
            this.ciY = new i();
            if (com.baidu.adp.lib.util.k.iX()) {
                ji(sb.toString());
            }
        }
        sVar = this.ciZ.ciV;
        return sVar;
    }

    private s ji(String str) {
        s sVar;
        s sVar2;
        String jf = this.ciY.jf(str);
        if (this.ciY.qa()) {
            sVar = this.ciZ.ciV;
            sVar.parserJson(jf);
            sVar2 = this.ciZ.ciV;
            return sVar2;
        }
        this.ciZ.ciV = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.ciY.cancel();
        this.ciY = null;
        this.ciZ.ciU = null;
        this.ciZ.pY = false;
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
        this.ciZ.pY = false;
        this.ciZ.ciU = null;
        vVar = this.ciZ.ciW;
        if (vVar != null) {
            sVar2 = this.ciZ.ciV;
            if (sVar2 != null) {
                vVar3 = this.ciZ.ciW;
                sVar3 = this.ciZ.ciV;
                vVar3.b(sVar3);
                return;
            }
            String qb = this.ciY != null ? this.ciY.qb() : null;
            vVar2 = this.ciZ.ciW;
            vVar2.he(qb);
        }
    }
}
