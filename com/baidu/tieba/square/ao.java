package com.baidu.tieba.square;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask<Object, ah, ah> {
    private int bNe;
    final /* synthetic */ am bNg;
    private com.baidu.tieba.a.b bNd = null;
    private com.baidu.adp.lib.cache.t<String> bNf = null;

    public ao(am amVar, int i) {
        this.bNg = amVar;
        this.bNe = 1;
        this.bNe = i;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: y */
    public ah doInBackground(Object... objArr) {
        ah ahVar;
        String str = null;
        this.bNd = new com.baidu.tieba.a.b();
        this.bNf = com.baidu.tbadk.core.a.a.kS().bd("tb.square");
        if (this.bNe == 0) {
            String str2 = this.bNf.get("square_cache_key");
            if (str2 == null) {
                return null;
            }
            ah ahVar2 = new ah();
            ahVar2.parserJson(str2);
            if (!ahVar2.adr()) {
                this.bNe = 1;
                str = str2;
                ahVar = ahVar2;
            } else {
                return ahVar2;
            }
        } else {
            ahVar = null;
        }
        if (this.bNe == 1) {
            this.bNg.azR = System.currentTimeMillis();
            str = this.bNd.AB();
            this.bNg.azS = this.bNd.AC();
            this.bNg.azT = this.bNd.AD();
            this.bNg.azU = System.currentTimeMillis();
        }
        if (this.bNd.jq()) {
            ahVar = new ah();
            ahVar.parserJson(str);
            this.bNf.a("square_cache_key", str, 86400000L);
        }
        return ahVar;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
        if (this.bNd != null) {
            this.bNd.cancel();
        }
        this.bNg.bNa = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ah ahVar) {
        an anVar;
        an anVar2;
        an anVar3;
        this.bNg.bNa = null;
        this.bNg.bNb = ahVar;
        anVar = this.bNg.bNc;
        if (anVar != null) {
            if (this.bNe == 0 || this.bNd.jq()) {
                anVar2 = this.bNg.bNc;
                anVar2.a(true, null, ahVar);
                return;
            }
            String jr = this.bNd.jr();
            anVar3 = this.bNg.bNc;
            anVar3.a(false, jr, ahVar);
        }
    }
}
