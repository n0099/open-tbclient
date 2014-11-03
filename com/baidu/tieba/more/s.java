package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
/* loaded from: classes.dex */
class s extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ ImageProblemActivity bqV;

    private s(ImageProblemActivity imageProblemActivity) {
        this.bqV = imageProblemActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ImageProblemActivity imageProblemActivity, s sVar) {
        this(imageProblemActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bqV.bqS.start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public BdStatSwitchData doInBackground(Object... objArr) {
        publishProgress(0);
        this.bqV.bqT.UF();
        publishProgress(1);
        this.bqV.bqT.UG();
        publishProgress(2);
        this.bqV.bqT.UH();
        publishProgress(3);
        this.bqV.bqT.UI();
        publishProgress(4);
        this.bqV.bqT.UJ();
        publishProgress(5);
        this.bqV.bqT.UK();
        publishProgress(6);
        this.bqV.bqT.UL();
        publishProgress(7);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.bqV.bqS.b(numArr[0].intValue(), this.bqV.bqT.bqX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        super.onPostExecute(bdStatSwitchData);
        this.bqV.bqS.UN().setText(this.bqV.getResources().getText(com.baidu.tieba.y.diagnose));
        this.bqV.bqS.complete();
        this.bqV.bqU = null;
    }
}
