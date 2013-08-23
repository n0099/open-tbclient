package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1618a;

    private aw(PersonChangeActivity personChangeActivity) {
        this.f1618a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(PersonChangeActivity personChangeActivity, aw awVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        ImageView imageView;
        progressBar = this.f1618a.E;
        progressBar.setVisibility(0);
        button = this.f1618a.e;
        button.setEnabled(false);
        imageView = this.f1618a.c;
        imageView.setImageBitmap(null);
        this.f1618a.B = null;
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.p.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.f1618a.C = null;
        progressBar = this.f1618a.E;
        progressBar.setVisibility(8);
        button = this.f1618a.e;
        button.setEnabled(true);
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
        Button button;
        ProgressBar progressBar;
        com.baidu.adp.widget.a.b bVar;
        ImageView imageView;
        super.a((Object) bitmap);
        this.f1618a.C = null;
        button = this.f1618a.e;
        button.setEnabled(true);
        progressBar = this.f1618a.E;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.f1618a.B = new com.baidu.adp.widget.a.b(bitmap, false, null);
            bVar = this.f1618a.B;
            imageView = this.f1618a.c;
            bVar.a(imageView);
        }
    }
}
