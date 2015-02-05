package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bHK;

    private ai(PersonChangeActivity personChangeActivity) {
        this.bHK = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(PersonChangeActivity personChangeActivity, ai aiVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.bHK.anQ;
        progressBar.setVisibility(0);
        textView = this.bHK.bfH;
        textView.setEnabled(false);
        this.bHK.bHC.setImageDrawable(null);
        this.bHK.aWB = null;
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.s.X(null, TbConfig.PERSON_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.bHK.bHD = null;
        progressBar = this.bHK.anQ;
        progressBar.setVisibility(8);
        textView = this.bHK.bfH;
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
        super.onPostExecute((ai) bitmap);
        this.bHK.bHD = null;
        textView = this.bHK.bfH;
        textView.setEnabled(true);
        progressBar = this.bHK.anQ;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bHK.aWB = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bHK.aWB;
            aVar.a(this.bHK.bHC);
            com.baidu.tbadk.imageManager.e vY = com.baidu.tbadk.imageManager.e.vY();
            fVar = this.bHK.bHB;
            String portrait = fVar.sv().getPortrait();
            aVar2 = this.bHK.aWB;
            vY.b(portrait, aVar2, true);
        }
    }
}
