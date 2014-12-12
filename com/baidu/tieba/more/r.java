package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
/* loaded from: classes.dex */
class r extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ ImageProblemActivity buk;

    private r(ImageProblemActivity imageProblemActivity) {
        this.buk = imageProblemActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(ImageProblemActivity imageProblemActivity, r rVar) {
        this(imageProblemActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.buk.buh.start();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public BdStatSwitchData doInBackground(Object... objArr) {
        publishProgress(0);
        this.buk.bui.UR();
        publishProgress(1);
        this.buk.bui.US();
        publishProgress(2);
        this.buk.bui.UT();
        publishProgress(3);
        this.buk.bui.UU();
        publishProgress(4);
        this.buk.bui.UV();
        publishProgress(5);
        this.buk.bui.UW();
        publishProgress(6);
        this.buk.bui.UX();
        publishProgress(7);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.buk.buh.b(numArr[0].intValue(), this.buk.bui.bum);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        super.onPostExecute(bdStatSwitchData);
        this.buk.buh.UZ().setText(this.buk.getResources().getText(com.baidu.tieba.z.diagnose));
        this.buk.buh.complete();
        this.buk.buj = null;
    }
}
