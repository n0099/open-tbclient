package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f1514a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar, String str) {
        this.f1514a = aqVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.y.f(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public at a(String... strArr) {
        String str;
        at atVar;
        Exception e;
        byte[] imageData;
        Bitmap a2;
        if (this.c == null || this.d == null) {
            return null;
        }
        String str2 = String.valueOf(this.c) + "&imgtype=0";
        if (TiebaApplication.f().ao() == 1) {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(80);
        } else {
            str = String.valueOf(str2) + "&qulity=" + String.valueOf(45);
        }
        try {
            imageData = this.f1514a.b.getImageData();
            a2 = imageData != null ? com.baidu.tieba.util.d.a(imageData) : null;
            if (a2 == null && (imageData = com.baidu.tieba.util.m.d("image", this.d)) != null) {
                a2 = com.baidu.tieba.util.d.a(imageData);
            }
            if (a2 == null) {
                this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.j) + str);
                if (this.f1514a.c != null && (this.f1514a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.f1514a.c).b() != null) {
                        this.b.a("fid", ((ImageActivity) this.f1514a.c).b());
                    }
                    if (((ImageActivity) this.f1514a.c).c() != null) {
                        this.b.a("tid", ((ImageActivity) this.f1514a.c).c());
                    }
                    if (((ImageActivity) this.f1514a.c).d() != null) {
                        this.b.a("fname", ((ImageActivity) this.f1514a.c).d());
                    }
                }
                this.b.c(true);
                byte[] i = this.b.i();
                Bitmap a3 = this.b.c() ? com.baidu.tieba.util.d.a(i) : a2;
                com.baidu.tieba.util.m.a("image", this.d, i);
                a2 = a3;
                imageData = i;
            }
            atVar = new at(this.f1514a, null);
        } catch (Exception e2) {
            atVar = null;
            e = e2;
        }
        try {
            atVar.f1515a = this.c;
            atVar.b = imageData;
            atVar.c = a2;
            return atVar;
        } catch (Exception e3) {
            e = e3;
            com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            return atVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(at atVar) {
        ar arVar;
        ar arVar2;
        this.f1514a.f1513a.setVisibility(8);
        this.f1514a.d = null;
        if (atVar != null) {
            arVar = this.f1514a.e;
            if (arVar != null) {
                arVar2 = this.f1514a.e;
                arVar2.a(atVar.f1515a, atVar.b);
            }
            Bitmap bitmap = atVar.c;
            if (bitmap == null) {
                this.f1514a.b.l();
            } else if (com.baidu.tieba.util.ab.a(atVar.b)) {
                this.f1514a.b.a(atVar.b, bitmap);
            } else {
                this.f1514a.b.setImageBitmap(bitmap);
                this.f1514a.b.setImageData(atVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.f1514a.b.setImageBitmap(null);
        this.f1514a.f1513a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.f1514a.b.setVisibility(0);
        this.f1514a.f1513a.setVisibility(8);
        this.f1514a.d = null;
        super.cancel(true);
    }
}
