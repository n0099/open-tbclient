package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bSO;

    private az(PersonChangeActivity personChangeActivity) {
        this.bSO = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(PersonChangeActivity personChangeActivity, az azVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.bSO.axF;
        progressBar.setVisibility(0);
        this.bSO.bSG.setImageDrawable(null);
        this.bSO.bdF = null;
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.o.ac(null, TbConfig.PERSON_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.bSO.bSH = null;
        progressBar = this.bSO.axF;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        com.baidu.adp.widget.a.a aVar;
        com.baidu.tbadk.coreExtra.c.f fVar;
        com.baidu.adp.widget.a.a aVar2;
        super.onPostExecute((az) bitmap);
        this.bSO.bSH = null;
        progressBar = this.bSO.axF;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bSO.bdF = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bSO.bdF;
            aVar.a(this.bSO.bSG);
            com.baidu.tbadk.imageManager.e Am = com.baidu.tbadk.imageManager.e.Am();
            fVar = this.bSO.bSF;
            String portrait = fVar.wI().getPortrait();
            aVar2 = this.bSO.bdF;
            Am.b(portrait, aVar2, true);
        }
    }
}
