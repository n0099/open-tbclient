package com.baidu.tieba.person;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bl extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ PersonImageActivity c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        switch (com.baidu.tbadk.core.util.w.a(this.a, this.b, this.c)) {
            case -2:
                return com.baidu.tbadk.core.util.w.b();
            case -1:
            default:
                return this.c.getString(com.baidu.tieba.a.k.save_error);
            case 0:
                return this.c.getString(com.baidu.tieba.a.k.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        ProgressBar progressBar;
        String str2 = str;
        super.a((bl) str2);
        this.c.showToast(str2);
        this.c.b = null;
        progressBar = this.c.a;
        progressBar.setVisibility(8);
    }

    public bl(PersonImageActivity personImageActivity, String str, byte[] bArr) {
        this.c = personImageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.c.b = null;
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
