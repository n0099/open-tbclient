package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ PersonImageActivity c;

    public cs(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.c = personImageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.s.a(this.a, this.b, this.c)) {
            case -2:
                return com.baidu.tbadk.core.util.s.b();
            case -1:
            default:
                return this.c.getString(com.baidu.tieba.x.save_error);
            case 0:
                return this.c.getString(com.baidu.tieba.x.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute(str);
        this.c.showToast(str);
        this.c.b = null;
        progressBar = this.c.a;
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.c.b = null;
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
