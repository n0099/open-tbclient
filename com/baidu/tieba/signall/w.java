package com.baidu.tieba.signall;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends BdAsyncTask<String, Integer, s> {
    private h bLI = null;
    final /* synthetic */ u bLJ;

    public w(u uVar) {
        this.bLJ = uVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.bLJ.cs = true;
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
            this.bLI = new h();
            if (com.baidu.adp.lib.util.j.fh()) {
                hr(sb.toString());
            }
        }
        sVar = this.bLJ.bLE;
        return sVar;
    }

    private s hr(String str) {
        s sVar;
        s sVar2;
        String hp = this.bLI.hp(str);
        if (this.bLI.jq()) {
            sVar = this.bLJ.bLE;
            sVar.parserJson(hp);
            sVar2 = this.bLJ.bLE;
            return sVar2;
        }
        this.bLJ.bLE = null;
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        this.bLI.cancel();
        this.bLI = null;
        this.bLJ.bLD = null;
        this.bLJ.cs = false;
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
        this.bLJ.cs = false;
        this.bLJ.bLD = null;
        vVar = this.bLJ.bLF;
        if (vVar != null) {
            sVar2 = this.bLJ.bLE;
            if (sVar2 != null) {
                vVar3 = this.bLJ.bLF;
                sVar3 = this.bLJ.bLE;
                vVar3.b(sVar3);
                return;
            }
            String jr = this.bLI != null ? this.bLI.jr() : null;
            vVar2 = this.bLJ.bLF;
            vVar2.fw(jr);
        }
    }
}
