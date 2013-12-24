package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ PersonChangeActivity a;

    private ax(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
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
        progressBar = this.a.C;
        progressBar.setVisibility(0);
        textView = this.a.g;
        textView.setEnabled(false);
        headImageView = this.a.d;
        headImageView.setImageBitmap(null);
        this.a.z = null;
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.util.y.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        this.a.A = null;
        progressBar = this.a.C;
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
        com.baidu.adp.widget.ImageView.e eVar;
        HeadImageView headImageView;
        com.baidu.tieba.model.bw bwVar;
        com.baidu.adp.widget.ImageView.e eVar2;
        super.a((ax) bitmap);
        this.a.A = null;
        textView = this.a.g;
        textView.setEnabled(true);
        progressBar = this.a.C;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.a.z = new com.baidu.adp.widget.ImageView.e(bitmap, false, null);
            eVar = this.a.z;
            headImageView = this.a.d;
            eVar.a(headImageView);
            com.baidu.tbadk.imageManager.d a = com.baidu.tbadk.imageManager.d.a();
            bwVar = this.a.y;
            String portrait = bwVar.a().getPortrait();
            eVar2 = this.a.z;
            a.a(portrait, eVar2, true);
        }
    }
}
