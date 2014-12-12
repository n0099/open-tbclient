package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bGa;

    private aj(PersonChangeActivity personChangeActivity) {
        this.bGa = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(PersonChangeActivity personChangeActivity, aj ajVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.bGa.amY;
        progressBar.setVisibility(0);
        textView = this.bGa.ben;
        textView.setEnabled(false);
        this.bGa.bFS.setImageDrawable(null);
        this.bGa.aVj = null;
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.s.U(null, TbConfig.PERSON_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.bGa.bFT = null;
        progressBar = this.bGa.amY;
        progressBar.setVisibility(8);
        textView = this.bGa.ben;
        textView.setEnabled(true);
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
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.a.a aVar;
        com.baidu.tbadk.coreExtra.c.f fVar;
        com.baidu.adp.widget.a.a aVar2;
        super.onPostExecute((aj) bitmap);
        this.bGa.bFT = null;
        textView = this.bGa.ben;
        textView.setEnabled(true);
        progressBar = this.bGa.amY;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bGa.aVj = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bGa.aVj;
            aVar.a(this.bGa.bFS);
            com.baidu.tbadk.imageManager.e vL = com.baidu.tbadk.imageManager.e.vL();
            fVar = this.bGa.bFR;
            String portrait = fVar.sl().getPortrait();
            aVar2 = this.bGa.aVj;
            vL.b(portrait, aVar2, true);
        }
    }
}
