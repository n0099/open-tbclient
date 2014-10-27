package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
/* loaded from: classes.dex */
class s extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ ImageProblemActivity bqH;

    private s(ImageProblemActivity imageProblemActivity) {
        this.bqH = imageProblemActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ImageProblemActivity imageProblemActivity, s sVar) {
        this(imageProblemActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bqH.bqE.start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public BdStatSwitchData doInBackground(Object... objArr) {
        publishProgress(0);
        this.bqH.bqF.UC();
        publishProgress(1);
        this.bqH.bqF.UD();
        publishProgress(2);
        this.bqH.bqF.UE();
        publishProgress(3);
        this.bqH.bqF.UF();
        publishProgress(4);
        this.bqH.bqF.UG();
        publishProgress(5);
        this.bqH.bqF.UH();
        publishProgress(6);
        this.bqH.bqF.UI();
        publishProgress(7);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.bqH.bqE.b(numArr[0].intValue(), this.bqH.bqF.bqJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        super.onPostExecute(bdStatSwitchData);
        this.bqH.bqE.UK().setText(this.bqH.getResources().getText(com.baidu.tieba.y.diagnose));
        this.bqH.bqE.complete();
        this.bqH.bqG = null;
    }
}
