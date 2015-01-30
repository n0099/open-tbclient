package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bHL;

    private ai(PersonChangeActivity personChangeActivity) {
        this.bHL = personChangeActivity;
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
        progressBar = this.bHL.anT;
        progressBar.setVisibility(0);
        textView = this.bHL.bfI;
        textView.setEnabled(false);
        this.bHL.bHD.setImageDrawable(null);
        this.bHL.aWC = null;
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
        this.bHL.bHE = null;
        progressBar = this.bHL.anT;
        progressBar.setVisibility(8);
        textView = this.bHL.bfI;
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
        this.bHL.bHE = null;
        textView = this.bHL.bfI;
        textView.setEnabled(true);
        progressBar = this.bHL.anT;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bHL.aWC = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bHL.aWC;
            aVar.a(this.bHL.bHD);
            com.baidu.tbadk.imageManager.e we = com.baidu.tbadk.imageManager.e.we();
            fVar = this.bHL.bHC;
            String portrait = fVar.sB().getPortrait();
            aVar2 = this.bHL.aWC;
            we.b(portrait, aVar2, true);
        }
    }
}
