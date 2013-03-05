package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    volatile com.baidu.tieba.c.t a;
    com.baidu.tieba.a.aw b;
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

    public void a() {
        ProgressBar progressBar;
        this.c.j = null;
        if (this.a != null) {
            this.a.g();
        }
        this.d = true;
        progressBar = this.c.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        com.baidu.tieba.b.y yVar3;
        com.baidu.tieba.b.y yVar4;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/anti/vcode");
            com.baidu.tieba.c.t tVar = this.a;
            yVar = this.c.c;
            tVar.a("fid", yVar.f());
            com.baidu.tieba.c.t tVar2 = this.a;
            yVar2 = this.c.c;
            tVar2.a("kw", yVar2.g());
            yVar3 = this.c.c;
            if (yVar3.a() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tieba.c.t tVar3 = this.a;
                yVar4 = this.c.c;
                tVar3.a("tid", yVar4.d());
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            this.b = new com.baidu.tieba.a.aw();
            this.b.a(i);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.a = new com.baidu.tieba.c.t(str);
        return com.baidu.tieba.c.e.a(this.a.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        ImageView imageView;
        this.c.j = null;
        if (bitmap != null) {
            imageView = this.c.f;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.h;
        progressBar.setVisibility(8);
        if (this.b != null) {
            yVar = this.c.c;
            yVar.h(this.b.a());
            yVar2 = this.c.c;
            yVar2.i(this.b.b());
        }
        super.onPostExecute(bitmap);
    }
}
