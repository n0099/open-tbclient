package com.baidu.tieba.view;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends AsyncTask {
    final /* synthetic */ ah a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ah ahVar, String str) {
        this.a = ahVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.c.ad.g(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public ak doInBackground(String... strArr) {
        ak akVar;
        Exception e;
        byte[] imageData;
        Bitmap a;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str = String.valueOf(this.c) + "&imgtype=0";
        String str2 = TiebaApplication.a().Y() == 1 ? String.valueOf(str) + "&qulity=" + String.valueOf(80) : String.valueOf(str) + "&qulity=" + String.valueOf(45);
        try {
            imageData = this.a.b.getImageData();
            a = imageData != null ? com.baidu.tieba.c.e.a(imageData) : null;
            if (a == null && (imageData = com.baidu.tieba.c.o.d("image", this.d)) != null) {
                a = com.baidu.tieba.c.e.a(imageData);
            }
            if (a == null) {
                this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/p/img?" + str2);
                if (this.a.c != null && (this.a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.a.c).g() != null) {
                        this.b.a("fid", ((ImageActivity) this.a.c).g());
                    }
                    if (((ImageActivity) this.a.c).h() != null) {
                        this.b.a("tid", ((ImageActivity) this.a.c).h());
                    }
                    if (((ImageActivity) this.a.c).i() != null) {
                        this.b.a("fname", ((ImageActivity) this.a.c).i());
                    }
                }
                this.b.c(true);
                byte[] h = this.b.h();
                Bitmap a2 = this.b.b() ? com.baidu.tieba.c.e.a(h) : a;
                com.baidu.tieba.c.o.a("image", this.d, h);
                a = a2;
                imageData = h;
            }
            akVar = new ak(this.a, null);
        } catch (Exception e2) {
            akVar = null;
            e = e2;
        }
        try {
            akVar.a = this.c;
            akVar.b = imageData;
            akVar.c = a;
            return akVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return akVar;
        }
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(ak akVar) {
        ai aiVar;
        ai aiVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (akVar == null) {
            return;
        }
        aiVar = this.a.e;
        if (aiVar != null) {
            aiVar2 = this.a.e;
            aiVar2.a(akVar.a, akVar.b);
        }
        Bitmap bitmap = akVar.c;
        if (bitmap == null) {
            this.a.b.l();
        } else if (com.baidu.tieba.c.ag.a(akVar.b)) {
            this.a.b.a(akVar.b, bitmap);
        } else {
            this.a.b.setImageBitmap(bitmap);
            this.a.b.setImageData(akVar.b);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.onPreExecute();
    }
}
