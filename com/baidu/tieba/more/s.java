package com.baidu.tieba.more;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatSwitchData;
/* loaded from: classes.dex */
class s extends BdAsyncTask<Object, Integer, BdStatSwitchData> {
    final /* synthetic */ ImageProblemActivity a;

    private s(ImageProblemActivity imageProblemActivity) {
        this.a = imageProblemActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(ImageProblemActivity imageProblemActivity, s sVar) {
        this(imageProblemActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        this.a.a.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public BdStatSwitchData doInBackground(Object... objArr) {
        publishProgress(0);
        this.a.b.a();
        publishProgress(1);
        this.a.b.b();
        publishProgress(2);
        this.a.b.c();
        publishProgress(3);
        this.a.b.d();
        publishProgress(4);
        this.a.b.e();
        publishProgress(5);
        this.a.b.f();
        publishProgress(6);
        this.a.b.g();
        publishProgress(7);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        this.a.a.a(numArr[0].intValue(), this.a.b.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(BdStatSwitchData bdStatSwitchData) {
        super.onPostExecute(bdStatSwitchData);
        this.a.a.a().setText(this.a.getResources().getText(com.baidu.tieba.x.diagnose));
        this.a.a.c();
        this.a.c = null;
    }
}
