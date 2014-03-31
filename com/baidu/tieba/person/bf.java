package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
final class bf extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(Object... objArr) {
        return com.baidu.tbadk.core.util.w.c(null, "tieba_head_image");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.ImageView.b bVar;
        com.baidu.tieba.model.au auVar;
        com.baidu.adp.widget.ImageView.b bVar2;
        Bitmap bitmap2 = bitmap;
        super.a((bf) bitmap2);
        this.a.w = null;
        textView = this.a.f;
        textView.setEnabled(true);
        progressBar = this.a.y;
        progressBar.setVisibility(8);
        if (bitmap2 != null) {
            this.a.v = new com.baidu.adp.widget.ImageView.b(bitmap2, false, null);
            bVar = this.a.v;
            bVar.a(this.a.a);
            com.baidu.tbadk.imageManager.e a = com.baidu.tbadk.imageManager.e.a();
            auVar = this.a.u;
            String portrait = auVar.a().getPortrait();
            bVar2 = this.a.v;
            a.a(portrait, bVar2, true);
        }
    }

    private bf(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(PersonChangeActivity personChangeActivity, byte b) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.y;
        progressBar.setVisibility(0);
        textView = this.a.f;
        textView.setEnabled(false);
        this.a.a.setImageBitmap(null);
        this.a.v = null;
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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
    public final void d() {
        super.d();
    }
}
