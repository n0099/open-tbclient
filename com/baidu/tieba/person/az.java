package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bSN;

    private az(PersonChangeActivity personChangeActivity) {
        this.bSN = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ az(PersonChangeActivity personChangeActivity, az azVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.bSN.axE;
        progressBar.setVisibility(0);
        this.bSN.bSF.setImageDrawable(null);
        this.bSN.bdE = null;
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
        this.bSN.bSG = null;
        progressBar = this.bSN.axE;
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
        this.bSN.bSG = null;
        progressBar = this.bSN.axE;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bSN.bdE = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bSN.bdE;
            aVar.a(this.bSN.bSF);
            com.baidu.tbadk.imageManager.e Al = com.baidu.tbadk.imageManager.e.Al();
            fVar = this.bSN.bSE;
            String portrait = fVar.wH().getPortrait();
            aVar2 = this.bSN.bdE;
            Al.b(portrait, aVar2, true);
        }
    }
}
