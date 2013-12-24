package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends BdAsyncTask<String, Integer, by> {
    final /* synthetic */ bu a;
    private com.baidu.tieba.util.an b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bu buVar, String str, boolean z) {
        this.a = buVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bc.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public by a(String... strArr) {
        boolean z;
        String str;
        by byVar;
        Exception e;
        boolean z2;
        if (this.c == null || this.d == null) {
            return null;
        }
        if (this.c != null && this.c.startsWith("width=")) {
            this.a.f = false;
        }
        z = this.a.f;
        if (z) {
            str = this.c;
        } else {
            str = com.baidu.tieba.data.h.l + ((this.c + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bd.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            Bitmap a = imageData != null ? com.baidu.tieba.util.m.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    a = com.baidu.adp.lib.h.a.a().a(this.c);
                    if (a != null && imageData == null) {
                        imageData = com.baidu.adp.lib.h.a.a().a(a, 100);
                    }
                } else {
                    imageData = com.baidu.tieba.util.y.d("image", this.d);
                    if (imageData != null) {
                        a = com.baidu.tieba.util.m.a(imageData);
                    }
                }
            }
            if (a == null) {
                this.b = new com.baidu.tieba.util.an(str);
                com.baidu.tieba.util.an anVar = this.b;
                z2 = this.a.f;
                anVar.f(z2);
                if (this.a.c != null && (this.a.c instanceof ImageActivity)) {
                    if (((ImageActivity) this.a.c).a() != null) {
                        this.b.a("fid", ((ImageActivity) this.a.c).a());
                    }
                    if (((ImageActivity) this.a.c).b() != null) {
                        this.b.a("tid", ((ImageActivity) this.a.c).b());
                    }
                    if (((ImageActivity) this.a.c).c() != null) {
                        this.b.a("fname", ((ImageActivity) this.a.c).c());
                    }
                }
                this.b.d(true);
                byte[] k = this.b.k();
                Bitmap a2 = this.b.c() ? com.baidu.tieba.util.m.a(k) : a;
                com.baidu.tieba.util.y.a("image", this.d, k);
                a = a2;
                imageData = k;
            }
            byVar = new by(this.a);
            try {
                byVar.a = this.c;
                byVar.b = imageData;
                byVar.c = a;
                return byVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
                return byVar;
            }
        } catch (Exception e3) {
            byVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(by byVar) {
        bw bwVar;
        bw bwVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (byVar != null) {
            bwVar = this.a.e;
            if (bwVar != null) {
                bwVar2 = this.a.e;
                bwVar2.a(byVar.a, byVar.b);
            }
            Bitmap bitmap = byVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.adp.lib.h.g.a(byVar.b)) {
                this.a.b.a(byVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(byVar.b);
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
            this.b.j();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
