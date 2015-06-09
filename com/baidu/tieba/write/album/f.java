package com.baidu.tieba.write.album;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    private final o cyi;
    final /* synthetic */ e cyj;

    public f(e eVar, o oVar) {
        this.cyj = eVar;
        this.cyi = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: G */
    public List<a> doInBackground(Object... objArr) {
        List<a> arN;
        arN = this.cyj.arN();
        return arN;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.cyi != null) {
            this.cyi.nm();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<a> list) {
        super.onPostExecute(list);
        if (this.cyi != null) {
            this.cyi.bd(list);
        }
    }
}
