package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity a;

    private bv(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bv(PersonChangeActivity personChangeActivity, bv bvVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.y;
        progressBar.setVisibility(0);
        textView = this.a.f;
        textView.setEnabled(false);
        this.a.a.setImageBitmap(null);
        this.a.v = null;
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.z.c(null, TbConfig.PERSON_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.a.w = null;
        progressBar = this.a.y;
        progressBar.setVisibility(8);
        textView = this.a.f;
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
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.a.a aVar;
        com.baidu.tieba.model.at atVar;
        com.baidu.adp.widget.a.a aVar2;
        super.onPostExecute(bitmap);
        this.a.w = null;
        textView = this.a.f;
        textView.setEnabled(true);
        progressBar = this.a.y;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.a.v = new com.baidu.adp.widget.a.a(bitmap, false, null);
            aVar = this.a.v;
            aVar.a(this.a.a);
            com.baidu.tbadk.imageManager.e a = com.baidu.tbadk.imageManager.e.a();
            atVar = this.a.u;
            String portrait = atVar.a().getPortrait();
            aVar2 = this.a.v;
            a.a(portrait, aVar2, true);
        }
    }
}
