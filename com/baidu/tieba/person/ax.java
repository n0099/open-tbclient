package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2187a;

    private ax(PersonChangeActivity personChangeActivity) {
        this.f2187a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(PersonChangeActivity personChangeActivity, al alVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        HeadImageView headImageView;
        progressBar = this.f2187a.E;
        progressBar.setVisibility(0);
        button = this.f2187a.g;
        button.setEnabled(false);
        headImageView = this.f2187a.d;
        headImageView.setImageBitmap(null);
        this.f2187a.B = null;
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.w.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.f2187a.C = null;
        progressBar = this.f2187a.E;
        progressBar.setVisibility(8);
        button = this.f2187a.g;
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
        com.baidu.adp.widget.ImageView.e eVar;
        HeadImageView headImageView;
        super.a((ax) bitmap);
        this.f2187a.C = null;
        button = this.f2187a.g;
        button.setEnabled(true);
        progressBar = this.f2187a.E;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.f2187a.B = new com.baidu.adp.widget.ImageView.e(bitmap, false, null);
            eVar = this.f2187a.B;
            headImageView = this.f2187a.d;
            eVar.a(headImageView);
        }
    }
}
