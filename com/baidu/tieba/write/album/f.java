package com.baidu.tieba.write.album;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    private final o cyh;
    final /* synthetic */ e cyi;

    public f(e eVar, o oVar) {
        this.cyi = eVar;
        this.cyh = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: G */
    public List<a> doInBackground(Object... objArr) {
        List<a> arM;
        arM = this.cyi.arM();
        return arM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.cyh != null) {
            this.cyh.nm();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(List<a> list) {
        super.onPostExecute(list);
        if (this.cyh != null) {
            this.cyh.bd(list);
        }
    }
}
