package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonChangeActivity f2214a;

    private ax(PersonChangeActivity personChangeActivity) {
        this.f2214a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ax(PersonChangeActivity personChangeActivity, al alVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        TextView textView;
        HeadImageView headImageView;
        progressBar = this.f2214a.C;
        progressBar.setVisibility(0);
        textView = this.f2214a.g;
        textView.setEnabled(false);
        headImageView = this.f2214a.d;
        headImageView.setImageBitmap(null);
        this.f2214a.z = null;
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.af.d(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.f2214a.A = null;
        progressBar = this.f2214a.C;
        progressBar.setVisibility(8);
        textView = this.f2214a.g;
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
        com.baidu.adp.widget.ImageView.e eVar;
        HeadImageView headImageView;
        super.a((ax) bitmap);
        this.f2214a.A = null;
        textView = this.f2214a.g;
        textView.setEnabled(true);
        progressBar = this.f2214a.C;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.f2214a.z = new com.baidu.adp.widget.ImageView.e(bitmap, false, null);
            eVar = this.f2214a.z;
            headImageView = this.f2214a.d;
            eVar.a(headImageView);
        }
    }
}
