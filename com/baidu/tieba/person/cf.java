package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity a;

    private cf(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ cf(PersonChangeActivity personChangeActivity, cf cfVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.af.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        TextView textView;
        ProgressBar progressBar;
        com.baidu.adp.widget.ImageView.b bVar;
        com.baidu.tieba.model.bo boVar;
        com.baidu.adp.widget.ImageView.b bVar2;
        super.a((cf) bitmap);
        this.a.y = null;
        textView = this.a.g;
        textView.setEnabled(true);
        progressBar = this.a.A;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.a.x = new com.baidu.adp.widget.ImageView.b(bitmap, false, null);
            bVar = this.a.x;
            bVar.a(this.a.a);
            com.baidu.tbadk.imageManager.e a = com.baidu.tbadk.imageManager.e.a();
            boVar = this.a.w;
            String portrait = boVar.a().getPortrait();
            bVar2 = this.a.x;
            a.a(portrait, bVar2, true);
        }
    }
}
