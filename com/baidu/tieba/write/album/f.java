package com.baidu.tieba.write.album;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<Object, Integer, List<a>> {
    private final m ctC;
    final /* synthetic */ e ctD;

    public f(e eVar, m mVar) {
        this.ctD = eVar;
        this.ctC = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: D */
    public List<a> doInBackground(Object... objArr) {
        List<a> apH;
        apH = this.ctD.apH();
        return apH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.ctC != null) {
            this.ctC.mU();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public void onPostExecute(List<a> list) {
        super.onPostExecute(list);
        if (this.ctC != null) {
            this.ctC.aX(list);
        }
    }
}
