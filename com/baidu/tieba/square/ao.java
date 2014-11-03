package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, ah, ah> {
    private int bNt;
    final /* synthetic */ am bNv;
    private com.baidu.tieba.a.b bNs = null;
    private com.baidu.adp.lib.cache.t<String> bNu = null;

    public ao(am amVar, int i) {
        this.bNv = amVar;
        this.bNt = 1;
        this.bNt = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public ah doInBackground(Object... objArr) {
        ah ahVar;
        String str = null;
        this.bNs = new com.baidu.tieba.a.b();
        this.bNu = com.baidu.tbadk.core.a.a.kS().bd("tb.square");
        if (this.bNt == 0) {
            String str2 = this.bNu.get("square_cache_key");
            if (str2 == null) {
                return null;
            }
            ah ahVar2 = new ah();
            ahVar2.parserJson(str2);
            if (!ahVar2.adu()) {
                this.bNt = 1;
                str = str2;
                ahVar = ahVar2;
            } else {
                return ahVar2;
            }
        } else {
            ahVar = null;
        }
        if (this.bNt == 1) {
            this.bNv.aAa = System.currentTimeMillis();
            str = this.bNs.AD();
            this.bNv.aAb = this.bNs.AE();
            this.bNv.aAc = this.bNs.AF();
            this.bNv.aAd = System.currentTimeMillis();
        }
        if (this.bNs.jq()) {
            ahVar = new ah();
            ahVar.parserJson(str);
            this.bNu.a("square_cache_key", str, 86400000L);
        }
        return ahVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.bNs != null) {
            this.bNs.cancel();
        }
        this.bNv.bNp = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ah ahVar) {
        an anVar;
        an anVar2;
        an anVar3;
        this.bNv.bNp = null;
        this.bNv.bNq = ahVar;
        anVar = this.bNv.bNr;
        if (anVar != null) {
            if (this.bNt == 0 || this.bNs.jq()) {
                anVar2 = this.bNv.bNr;
                anVar2.a(true, null, ahVar);
                return;
            }
            String jr = this.bNs.jr();
            anVar3 = this.bNv.bNr;
            anVar3.a(false, jr, ahVar);
        }
    }
}
