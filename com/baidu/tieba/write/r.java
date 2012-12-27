package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    volatile com.baidu.tieba.c.t a;
    com.baidu.tieba.a.av b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(VcodeActivity vcodeActivity, r rVar) {
        this(vcodeActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        com.baidu.tieba.b.u uVar;
        com.baidu.tieba.b.u uVar2;
        com.baidu.tieba.b.u uVar3;
        com.baidu.tieba.b.u uVar4;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/anti/vcode");
            com.baidu.tieba.c.t tVar = this.a;
            uVar = this.c.b;
            tVar.a("fid", uVar.f());
            com.baidu.tieba.c.t tVar2 = this.a;
            uVar2 = this.c.b;
            tVar2.a("kw", uVar2.g());
            uVar3 = this.c.b;
            if (uVar3.a() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tieba.c.t tVar3 = this.a;
                uVar4 = this.c.b;
                tVar3.a("tid", uVar4.d());
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            this.b = new com.baidu.tieba.a.av();
            this.b.a(i);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.a = new com.baidu.tieba.c.t(str);
        return com.baidu.tieba.c.e.a(this.a.h());
    }

    public void a() {
        ProgressBar progressBar;
        this.c.i = null;
        if (this.a != null) {
            this.a.g();
        }
        this.d = true;
        progressBar = this.c.g;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        com.baidu.tieba.b.u uVar;
        com.baidu.tieba.b.u uVar2;
        ImageView imageView;
        this.c.i = null;
        if (bitmap != null) {
            imageView = this.c.e;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            uVar = this.c.b;
            uVar.h(this.b.a());
            uVar2 = this.c.b;
            uVar2.i(this.b.b());
        }
        super.onPostExecute(bitmap);
    }
}
