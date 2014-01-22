package com.baidu.tieba.view;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.pb.ImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct extends BdAsyncTask<String, Integer, cu> {
    final /* synthetic */ cq a;
    private com.baidu.tieba.util.ax b = null;
    private String c;
    private String d;
    private boolean e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cq cqVar, String str, boolean z) {
        this.a = cqVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = com.baidu.tieba.util.bu.f(str);
        this.e = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public cu a(String... strArr) {
        boolean z;
        String str;
        cu cuVar;
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
            str = com.baidu.tieba.data.h.k + ((this.c + "&imgtype=0") + "&qulity=" + com.baidu.tieba.util.bx.a().d());
        }
        try {
            byte[] imageData = this.a.b.getImageData();
            Bitmap a = imageData != null ? com.baidu.tieba.util.n.a(imageData) : null;
            if (a == null) {
                if (this.e && this.c.startsWith("/")) {
                    a = com.baidu.adp.lib.g.a.a().a(this.c);
                    if (a != null && imageData == null) {
                        imageData = com.baidu.adp.lib.g.a.a().a(a, 100);
                    }
                } else {
                    imageData = com.baidu.tieba.util.ad.d("image", this.d);
                    if (imageData != null) {
                        a = com.baidu.tieba.util.n.a(imageData);
                    }
                }
            }
            if (a == null) {
                this.b = new com.baidu.tieba.util.ax(str);
                com.baidu.tieba.util.ax axVar = this.b;
                z2 = this.a.f;
                axVar.f(z2);
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
                byte[] l = this.b.l();
                Bitmap a2 = this.b.d() ? com.baidu.tieba.util.n.a(l) : a;
                com.baidu.tieba.util.ad.a("image", this.d, l);
                a = a2;
                imageData = l;
            }
            cuVar = new cu(this.a);
            try {
                cuVar.a = this.c;
                cuVar.b = imageData;
                cuVar.c = a;
                return cuVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.adp.lib.g.e.b(getClass().getName(), "doInBackground", e.getMessage());
                return cuVar;
            }
        } catch (Exception e3) {
            cuVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(cu cuVar) {
        cs csVar;
        cs csVar2;
        this.a.a.setVisibility(8);
        this.a.d = null;
        if (cuVar != null) {
            csVar = this.a.e;
            if (csVar != null) {
                csVar2 = this.a.e;
                csVar2.a(cuVar.a, cuVar.b);
            }
            Bitmap bitmap = cuVar.c;
            if (bitmap == null) {
                this.a.b.l();
            } else if (com.baidu.adp.lib.g.g.a(cuVar.b)) {
                this.a.b.a(cuVar.b, bitmap);
            } else {
                this.a.b.setImageBitmap(bitmap);
                this.a.b.setImageData(cuVar.b);
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
            this.b.k();
        }
        this.a.b.setVisibility(0);
        this.a.a.setVisibility(8);
        this.a.d = null;
        super.cancel(true);
    }
}
