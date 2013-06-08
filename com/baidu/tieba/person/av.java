package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.a.a {
    final /* synthetic */ PersonChangeActivity a;

    private av(PersonChangeActivity personChangeActivity) {
        this.a = personChangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(PersonChangeActivity personChangeActivity, av avVar) {
        this(personChangeActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        ProgressBar progressBar;
        Button button;
        ImageView imageView;
        progressBar = this.a.D;
        progressBar.setVisibility(0);
        button = this.a.f;
        button.setEnabled(false);
        imageView = this.a.d;
        imageView.setImageBitmap(null);
        this.a.A = null;
        super.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        return com.baidu.tieba.d.o.c(null, "tieba_head_image");
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        ProgressBar progressBar;
        Button button;
        this.a.B = null;
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        button = this.a.f;
        button.setEnabled(true);
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void c() {
        super.c();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Bitmap bitmap) {
        Button button;
        ProgressBar progressBar;
        com.baidu.adp.widget.a.b bVar;
        ImageView imageView;
        super.a((Object) bitmap);
        this.a.B = null;
        button = this.a.f;
        button.setEnabled(true);
        progressBar = this.a.D;
        progressBar.setVisibility(8);
        if (bitmap != null) {
            this.a.A = new com.baidu.adp.widget.a.b(bitmap, false, null);
            bVar = this.a.A;
            imageView = this.a.d;
            bVar.b(imageView);
        }
    }
}
