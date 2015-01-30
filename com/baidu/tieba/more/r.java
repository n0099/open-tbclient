package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
/* loaded from: classes.dex */
class r extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ ImageProblemActivity bvG;

    private r(ImageProblemActivity imageProblemActivity) {
        this.bvG = imageProblemActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(ImageProblemActivity imageProblemActivity, r rVar) {
        this(imageProblemActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.bvG.bvD.start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public BdStatSwitchData doInBackground(Object... objArr) {
        publishProgress(0);
        this.bvG.bvE.Vp();
        publishProgress(1);
        this.bvG.bvE.Vq();
        publishProgress(2);
        this.bvG.bvE.Vr();
        publishProgress(3);
        this.bvG.bvE.Vs();
        publishProgress(4);
        this.bvG.bvE.Vt();
        publishProgress(5);
        this.bvG.bvE.Vu();
        publishProgress(6);
        this.bvG.bvE.Vv();
        publishProgress(7);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.bvG.bvD.b(numArr[0].intValue(), this.bvG.bvE.bvI);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        super.onPostExecute(bdStatSwitchData);
        this.bvG.bvD.Vx().setText(this.bvG.getResources().getText(com.baidu.tieba.z.diagnose));
        this.bvG.bvD.complete();
        this.bvG.bvF = null;
    }
}
