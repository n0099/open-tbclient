package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ar a;
    private com.baidu.tieba.d.t b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ar arVar, String str) {
        this.a = arVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.d.ad.f(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public au a(String... strArr) {
        String str;
        au auVar;
        Exception e;
        byte[] imageData;
        Bitmap a;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str2 = String.valueOf(this.c) + "&imgtype=0";
        if (TiebaApplication.e().an() == 1) {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(80);
        } else {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(45);
        }
        try {
            imageData = this.a.b.getImageData();
            a = imageData != null ? com.baidu.tieba.d.d.a(imageData) : null;
            if (a == null && (imageData = com.baidu.tieba.d.o.d("image", this.d)) != null) {
                a = com.baidu.tieba.d.d.a(imageData);
            }
            if (a == null) {
                this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.j) + str);
                if (this.a.c != null && (this.a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.a.c).b() != null) {
                        this.b.a("fid", ((ImageActivity) this.a.c).b());
                    }
                    if (((ImageActivity) this.a.c).c() != null) {
                        this.b.a("tid", ((ImageActivity) this.a.c).c());
                    }
                    if (((ImageActivity) this.a.c).d() != null) {
                        this.b.a("fname", ((ImageActivity) this.a.c).d());
                    }
                }
                this.b.c(true);
                byte[] h = this.b.h();
                Bitmap a2 = this.b.b() ? com.baidu.tieba.d.d.a(h) : a;
                com.baidu.tieba.d.o.a("image", this.d, h);
                a = a2;
                imageData = h;
            }
            auVar = new au(this.a, null);
        } catch (Exception e2) {
            auVar = null;
            e = e2;
        }
        try {
            auVar.a = this.c;
            auVar.b = imageData;
            auVar.c = a;
            return auVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return auVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(au auVar) {
        as asVar;
        as asVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (auVar != null) {
            asVar = this.a.e;
            if (asVar != null) {
                asVar2 = this.a.e;
                asVar2.a(auVar.a, auVar.b);
            }
            Bitmap bitmap = auVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.tieba.d.ag.a(auVar.b)) {
                this.a.b.a(auVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(auVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
