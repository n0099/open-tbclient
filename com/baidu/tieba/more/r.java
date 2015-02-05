package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
/* loaded from: classes.dex */
class r extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ ImageProblemActivity bvF;

    private r(ImageProblemActivity imageProblemActivity) {
        this.bvF = imageProblemActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(ImageProblemActivity imageProblemActivity, r rVar) {
        this(imageProblemActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bvF.bvC.start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public BdStatSwitchData doInBackground(Object... objArr) {
        publishProgress(0);
        this.bvF.bvD.Vk();
        publishProgress(1);
        this.bvF.bvD.Vl();
        publishProgress(2);
        this.bvF.bvD.Vm();
        publishProgress(3);
        this.bvF.bvD.Vn();
        publishProgress(4);
        this.bvF.bvD.Vo();
        publishProgress(5);
        this.bvF.bvD.Vp();
        publishProgress(6);
        this.bvF.bvD.Vq();
        publishProgress(7);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.bvF.bvC.b(numArr[0].intValue(), this.bvF.bvD.bvH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        super.onPostExecute(bdStatSwitchData);
        this.bvF.bvC.Vs().setText(this.bvF.getResources().getText(com.baidu.tieba.z.diagnose));
        this.bvF.bvC.complete();
        this.bvF.bvE = null;
    }
}
