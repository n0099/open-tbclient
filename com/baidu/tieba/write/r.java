package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    volatile com.baidu.tieba.c.t a;
    com.baidu.tieba.a.ba b;
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
        com.baidu.tieba.b.z zVar;
        com.baidu.tieba.b.z zVar2;
        com.baidu.tieba.b.z zVar3;
        com.baidu.tieba.b.z zVar4;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.a = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/anti/vcode");
            com.baidu.tieba.c.t tVar = this.a;
            zVar = this.c.c;
            tVar.a("fid", zVar.f());
            com.baidu.tieba.c.t tVar2 = this.a;
            zVar2 = this.c.c;
            tVar2.a("kw", zVar2.g());
            zVar3 = this.c.c;
            if (zVar3.a() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tieba.c.t tVar3 = this.a;
                zVar4 = this.c.c;
                tVar3.a("tid", zVar4.d());
            }
            String i = this.a.i();
            if (!this.a.b()) {
                return null;
            }
            this.b = new com.baidu.tieba.a.ba();
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
        com.baidu.tieba.b.z zVar;
        com.baidu.tieba.b.z zVar2;
        ImageView imageView;
        this.c.j = null;
        if (bitmap != null) {
            imageView = this.c.f;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.h;
        progressBar.setVisibility(8);
        if (this.b != null) {
            zVar = this.c.c;
            zVar.h(this.b.a());
            zVar2 = this.c.c;
            zVar2.i(this.b.b());
        }
        super.onPostExecute(bitmap);
    }
}
