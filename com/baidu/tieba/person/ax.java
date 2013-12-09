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
    final /* synthetic */ PersonChangeActivity f2323a;

    private ax(PersonChangeActivity personChangeActivity) {
        this.f2323a = personChangeActivity;
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
        progressBar = this.f2323a.C;
        progressBar.setVisibility(0);
        textView = this.f2323a.g;
        textView.setEnabled(false);
        headImageView = this.f2323a.d;
        headImageView.setImageBitmap(null);
        this.f2323a.z = null;
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.x.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.f2323a.A = null;
        progressBar = this.f2323a.C;
        progressBar.setVisibility(8);
        textView = this.f2323a.g;
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
        com.baidu.tieba.model.bw bwVar;
        com.baidu.adp.widget.ImageView.e eVar2;
        super.a((ax) bitmap);
        this.f2323a.A = null;
        textView = this.f2323a.g;
        textView.setEnabled(true);
        progressBar = this.f2323a.C;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.f2323a.z = new com.baidu.adp.widget.ImageView.e(bitmap, false, null);
            eVar = this.f2323a.z;
            headImageView = this.f2323a.d;
            eVar.a(headImageView);
            com.baidu.tbadk.imageManager.d a2 = com.baidu.tbadk.imageManager.d.a();
            bwVar = this.f2323a.y;
            String portrait = bwVar.a().getPortrait();
            eVar2 = this.f2323a.z;
            a2.a(portrait, eVar2, true);
        }
    }
}
