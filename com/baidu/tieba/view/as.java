package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends BdAsyncTask {
    final /* synthetic */ aq a;
    private com.baidu.tieba.util.r b = null;
    private String c;
    private String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(aq aqVar, String str) {
        this.a = aqVar;
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
        Bitmap a;
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
            imageData = this.a.b.getImageData();
            a = imageData != null ? com.baidu.tieba.util.d.a(imageData) : null;
            if (a == null && (imageData = com.baidu.tieba.util.m.d("image", this.d)) != null) {
                a = com.baidu.tieba.util.d.a(imageData);
            }
            if (a == null) {
                this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.j) + str);
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
                byte[] i = this.b.i();
                Bitmap a2 = this.b.c() ? com.baidu.tieba.util.d.a(i) : a;
                com.baidu.tieba.util.m.a("image", this.d, i);
                a = a2;
                imageData = i;
            }
            atVar = new at(this.a, null);
        } catch (Exception e2) {
            atVar = null;
            e = e2;
        }
        try {
            atVar.a = this.c;
            atVar.b = imageData;
            atVar.c = a;
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
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (atVar != null) {
            arVar = this.a.e;
            if (arVar != null) {
                arVar2 = this.a.e;
                arVar2.a(atVar.a, atVar.b);
            }
            Bitmap bitmap = atVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.tieba.util.ab.a(atVar.b)) {
                this.a.b.a(atVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(atVar.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.a.b.setImageBitmap(null);
        this.a.a.setVisibility(0);
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
