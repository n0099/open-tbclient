package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f1667a;

    private av(PersonChangeActivity personChangeActivity) {
        this.f1667a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(PersonChangeActivity personChangeActivity, av avVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        Button button;
        HeadImageView headImageView;
        progressBar = this.f1667a.E;
        progressBar.setVisibility(0);
        button = this.f1667a.g;
        button.setEnabled(false);
        headImageView = this.f1667a.d;
        headImageView.setImageBitmap(null);
        this.f1667a.B = null;
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
        this.f1667a.C = null;
        progressBar = this.f1667a.E;
        progressBar.setVisibility(8);
        button = this.f1667a.g;
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
        com.baidu.adp.widget.a.c cVar;
        HeadImageView headImageView;
        super.a((av) bitmap);
        this.f1667a.C = null;
        button = this.f1667a.g;
        button.setEnabled(true);
        progressBar = this.f1667a.E;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.f1667a.B = new com.baidu.adp.widget.a.c(bitmap, false, null);
            cVar = this.f1667a.B;
            headImageView = this.f1667a.d;
            cVar.a(headImageView);
        }
    }
}
