package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends AsyncTask {
    final /* synthetic */ ag a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ag agVar, String str) {
        this.a = agVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.c.af.h(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public aj doInBackground(String... strArr) {
        String str;
        aj ajVar;
        Exception e;
        byte[] imageData;
        Bitmap a;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str2 = String.valueOf(this.c) + "&imgtype=0";
        if (TiebaApplication.b().ac() == 1) {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(80);
        } else {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(45);
        }
        try {
            imageData = this.a.b.getImageData();
            a = imageData != null ? com.baidu.tieba.c.e.a(imageData) : null;
            if (a == null && (imageData = com.baidu.tieba.c.o.d("image", this.d)) != null) {
                a = com.baidu.tieba.c.e.a(imageData);
            }
            if (a == null) {
                this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/p/img?" + str);
                if (this.a.c != null && (this.a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.a.c).i() != null) {
                        this.b.a("fid", ((ImageActivity) this.a.c).i());
                    }
                    if (((ImageActivity) this.a.c).j() != null) {
                        this.b.a("tid", ((ImageActivity) this.a.c).j());
                    }
                    if (((ImageActivity) this.a.c).k() != null) {
                        this.b.a("fname", ((ImageActivity) this.a.c).k());
                    }
                }
                this.b.c(true);
                byte[] h = this.b.h();
                Bitmap a2 = this.b.b() ? com.baidu.tieba.c.e.a(h) : a;
                com.baidu.tieba.c.o.a("image", this.d, h);
                a = a2;
                imageData = h;
            }
            ajVar = new aj(this.a, null);
        } catch (Exception e2) {
            ajVar = null;
            e = e2;
        }
        try {
            ajVar.a = this.c;
            ajVar.b = imageData;
            ajVar.c = a;
            return ajVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
            return ajVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(aj ajVar) {
        ah ahVar;
        ah ahVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (ajVar != null) {
            ahVar = this.a.e;
            if (ahVar != null) {
                ahVar2 = this.a.e;
                ahVar2.a(ajVar.a, ajVar.b);
            }
            Bitmap bitmap = ajVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.tieba.c.ai.a(ajVar.b)) {
                this.a.b.a(ajVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(ajVar.b);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.onPreExecute();
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
