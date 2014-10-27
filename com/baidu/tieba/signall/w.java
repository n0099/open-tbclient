package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private h bLt = null;
    final /* synthetic */ u bLu;

    public w(u uVar) {
        this.bLu = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.bLu.cs = true;
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
            this.bLt = new h();
            if (com.baidu.adp.lib.util.j.fh()) {
                hr(sb.toString());
            }
        }
        sVar = this.bLu.bLp;
        return sVar;
    }

    private s hr(String str) {
        s sVar;
        s sVar2;
        String hp = this.bLt.hp(str);
        if (this.bLt.jq()) {
            sVar = this.bLu.bLp;
            sVar.parserJson(hp);
            sVar2 = this.bLu.bLp;
            return sVar2;
        }
        this.bLu.bLp = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.bLt.cancel();
        this.bLt = null;
        this.bLu.bLo = null;
        this.bLu.cs = false;
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
        this.bLu.cs = false;
        this.bLu.bLo = null;
        vVar = this.bLu.bLq;
        if (vVar != null) {
            sVar2 = this.bLu.bLp;
            if (sVar2 != null) {
                vVar3 = this.bLu.bLq;
                sVar3 = this.bLu.bLp;
                vVar3.b(sVar3);
                return;
            }
            String jr = this.bLt != null ? this.bLt.jr() : null;
            vVar2 = this.bLu.bLq;
            vVar2.fw(jr);
        }
    }
}
