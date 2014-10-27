package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bCm;

    private aq(PersonChangeActivity personChangeActivity) {
        this.bCm = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(PersonChangeActivity personChangeActivity, aq aqVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.bCm.afz;
        progressBar.setVisibility(0);
        textView = this.bCm.bBR;
        textView.setEnabled(false);
        this.bCm.bCe.setImageDrawable(null);
        this.bCm.aTt = null;
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.s.K(null, TbConfig.PERSON_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.bCm.bCf = null;
        progressBar = this.bCm.afz;
        progressBar.setVisibility(8);
        textView = this.bCm.bBR;
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
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.a.a aVar;
        com.baidu.tieba.model.au auVar;
        com.baidu.adp.widget.a.a aVar2;
        super.onPostExecute(bitmap);
        this.bCm.bCf = null;
        textView = this.bCm.bBR;
        textView.setEnabled(true);
        progressBar = this.bCm.afz;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bCm.aTt = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bCm.aTt;
            aVar.a(this.bCm.bCe);
            com.baidu.tbadk.imageManager.e sg = com.baidu.tbadk.imageManager.e.sg();
            auVar = this.bCm.bCd;
            String portrait = auVar.TT().getPortrait();
            aVar2 = this.bCm.aTt;
            sg.b(portrait, aVar2, true);
        }
    }
}
