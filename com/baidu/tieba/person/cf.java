package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* loaded from: classes.dex */
final class cf extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.af.c(null, "tieba_head_image");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.ImageView.b bVar;
        com.baidu.tieba.model.bo boVar;
        com.baidu.adp.widget.ImageView.b bVar2;
        Bitmap bitmap2 = bitmap;
        super.a((cf) bitmap2);
        this.a.y = null;
        textView = this.a.g;
        textView.setEnabled(true);
        progressBar = this.a.A;
        progressBar.setVisibility(8);
        if (bitmap2 != null) {
            this.a.x = new com.baidu.adp.widget.ImageView.b(bitmap2, false, null);
            bVar = this.a.x;
            bVar.a(this.a.a);
            com.baidu.tbadk.imageManager.e a = com.baidu.tbadk.imageManager.e.a();
            boVar = this.a.w;
            String portrait = boVar.a().getPortrait();
            bVar2 = this.a.x;
            a.a(portrait, bVar2, true);
        }
    }

    private cf(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cf(PersonChangeActivity personChangeActivity, byte b) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.A;
        progressBar.setVisibility(0);
        textView = this.a.g;
        textView.setEnabled(false);
        this.a.a.setImageBitmap(null);
        this.a.x = null;
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.a.y = null;
        progressBar = this.a.A;
        progressBar.setVisibility(8);
        textView = this.a.g;
        textView.setEnabled(true);
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }
}
