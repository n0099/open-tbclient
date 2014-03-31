package com.baidu.tieba.image;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ ImageViewerActivity c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        switch (w.a(this.a, this.b, this.c)) {
            case -2:
                return w.b();
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
        TextView textView;
        ProgressBar progressBar;
        String str2 = str;
        super.a((k) str2);
        this.c.showToast(str2);
        this.c.h = null;
        textView = this.c.i;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
    }

    public k(ImageViewerActivity imageViewerActivity, String str, byte[] bArr) {
        this.c = imageViewerActivity;
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
        TextView textView;
        ProgressBar progressBar;
        this.c.h = null;
        textView = this.c.i;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
