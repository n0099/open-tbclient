package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity bCA;

    private aq(PersonChangeActivity personChangeActivity) {
        this.bCA = personChangeActivity;
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
        progressBar = this.bCA.afH;
        progressBar.setVisibility(0);
        textView = this.bCA.bCf;
        textView.setEnabled(false);
        this.bCA.bCs.setImageDrawable(null);
        this.bCA.aTH = null;
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
        this.bCA.bCt = null;
        progressBar = this.bCA.afH;
        progressBar.setVisibility(8);
        textView = this.bCA.bCf;
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
        this.bCA.bCt = null;
        textView = this.bCA.bCf;
        textView.setEnabled(true);
        progressBar = this.bCA.afH;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.bCA.aTH = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.bCA.aTH;
            aVar.a(this.bCA.bCs);
            com.baidu.tbadk.imageManager.e si = com.baidu.tbadk.imageManager.e.si();
            auVar = this.bCA.bCr;
            String portrait = auVar.TW().getPortrait();
            aVar2 = this.bCA.aTH;
            si.b(portrait, aVar2, true);
        }
    }
}
